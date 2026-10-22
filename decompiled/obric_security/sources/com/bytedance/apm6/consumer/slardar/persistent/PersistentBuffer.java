package com.bytedance.apm6.consumer.slardar.persistent;

import com.bytedance.apm.doctor.DoctorDataUtil;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.DiskEnvironmentHelper;
import com.bytedance.apm6.consumer.slardar.LogReporter;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.log.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PersistentBuffer {
    private static final int BUFFER_SIZE = 262162;
    private static final int HEADER_SIZE = 18;
    public static final short MAGIC_NUMBER = 2082;
    private static final int MAX_DATA_SIZE = 262144;
    private static final String SUFFIX_LOG = ".log";
    private static final String SUFFIX_TMP = ".txt";
    private static final int TOTAL_BYTES_THRESHOLD = 262134;
    private static final int TOTAL_COUNT_THRESHOLD = 256;
    private ByteBuffer byteBuffer;
    private final File flushDir;
    private final long headerId;
    private FileLock lock;

    public PersistentBuffer(long r7, File r9, File r10) {
        this.flushDir = r10;
        this.headerId = r7;
        FileChannel r0 = new RandomAccessFile(r9, "rw").getChannel();     // Catch: Throwable -> L5
        this.lock = r0.tryLock();     // Catch: Throwable -> L5
        this.byteBuffer = r0.map(FileChannel.MapMode.READ_WRITE, 0, 262162);     // Catch: Throwable -> L5
        flush();     // Catch: Throwable -> L5
    L8:
        if (this.byteBuffer != null) goto L10;
        this.byteBuffer = ByteBuffer.allocate(BUFFER_SIZE);
    L10:
        reset();
        return;
    L5:
        th = move-exception;
        Logger.e(Constants.TAG, "create MappedByteBuffer failed. will fallback into HeapByteBuffer", th);
        goto L8
    }

    private void reset() {
        this.byteBuffer.clear();
        this.byteBuffer.putShort(MAGIC_NUMBER);
        this.byteBuffer.putLong(this.headerId);
        this.byteBuffer.putInt(0);
        this.byteBuffer.putInt(0);
    }

    private short getMagicNumber() {
        return this.byteBuffer.getShort(0);
    }

    private long getHeaderId() {
        return this.byteBuffer.getLong(2);
    }

    private int getTotalCount() {
        return this.byteBuffer.getInt(10);
    }

    private void setTotalCount(int r2) {
        this.byteBuffer.putInt(10, r2);
    }

    private int getTotalBytes() {
        return this.byteBuffer.getInt(14);
    }

    private void setTotalBytes(int r2) {
        this.byteBuffer.putInt(14, r2);
    }

    public synchronized void push(JSONObject r6) {
        monitor-enter(this);
        if (r6 != null) goto L30;
        monitor-exit(this);
        return;
    L30:
        String r0 = r6.toString();     // Catch: Throwable -> L27
        if (ApmContext.isDebugMode() == false) goto L9;
        DoctorDataUtil.saveToFileEvent(r6);     // Catch: Throwable -> L27
    L9:
        byte[] r7 = r0.getBytes();     // Catch: Throwable -> L27
        int r1 = r7.length + 4;     // Catch: Throwable -> L27
        if (r1 <= 262144) goto L15;
        Monitor.record(createLargeEvent());     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L15:
        if (r1 <= this.byteBuffer.remaining()) goto L17;
        flush();     // Catch: Throwable -> L27
    L17:
        this.byteBuffer.putInt(r7.length);     // Catch: Throwable -> L27
        this.byteBuffer.put(r7);     // Catch: Throwable -> L27
        setTotalCount(getTotalCount() + 1);     // Catch: Throwable -> L27
        setTotalBytes(getTotalBytes() + r1);     // Catch: Throwable -> L27
        if (ApmContext.isDebugMode() == false) goto L21;
        Logger.d(Constants.TAG, String.format("push success: totalCount=%s, totalBytes=%s, logItem=%s", new Object[]{Integer.valueOf(getTotalCount()), Integer.valueOf(getTotalBytes()), r0}));     // Catch: Throwable -> L27
    L21:
        if (this.byteBuffer.position() < TOTAL_BYTES_THRESHOLD) goto L23;
    L24:
        flush();     // Catch: Throwable -> L27
    L25:
        monitor-exit(this);
        return;
    L23:
        if (getTotalCount() < 256) goto L25;
    L27:
        th = move-exception;
        throw th;
    }

    public synchronized void flush() {
        monitor-enter(this);
        short r5 = getMagicNumber();     // Catch: Throwable -> L52
        long r6 = getHeaderId();     // Catch: Throwable -> L52
        int r8 = getTotalCount();     // Catch: Throwable -> L52
        int r9 = getTotalBytes();     // Catch: Throwable -> L52
        if (r5 != 2082) goto L47;
        if (r9 <= 0) goto L47;
        if (r8 <= 0) goto L47;
        if (ApmContext.isDebugMode() == false) goto L12;
        Logger.d(Constants.TAG, "flushing: headerId=" + r6 + " totalCount=" + r8 + " totalBytes=" + r9);     // Catch: Throwable -> L52
    L12:
        long r4 = System.nanoTime();     // Catch: Throwable -> L52
        boolean r7 = false;
        FileChannel r10 = null;
        String r11 = System.currentTimeMillis() + "_" + UUID.randomUUID().toString();     // Catch: Throwable -> L36
    L22:
        th = move-exception;
        Logger.e(Constants.TAG, "flushDir create error.", th);     // Catch: Throwable -> L36
    L24:
        File r12 = new File(this.flushDir, r11 + SUFFIX_TMP);     // Catch: Throwable -> L36
        if (r12.exists() == false) goto L27;
        Logger.e(Constants.TAG, "file is exist:" + r12.getName());     // Catch: Throwable -> L36
    L27:
        r10 = new FileOutputStream(r12, false).getChannel();     // Catch: Throwable -> L36
        this.byteBuffer.position(r9 + 18);     // Catch: Throwable -> L36
        this.byteBuffer.flip();     // Catch: Throwable -> L36
        r10.write(this.byteBuffer);     // Catch: Throwable -> L36
        if (r12.renameTo(new File(this.flushDir, r11 + SUFFIX_LOG)) == false) goto L30;
        r7 = true;
    L32:
        if (ApmContext.isDebugMode() == false) goto L34;
        Logger.d(Constants.TAG, "flush to file success. flushFile=" + r12.getAbsolutePath());     // Catch: Throwable -> L36
    L34:
        IOUtils.closeQuietly(r10);     // Catch: Throwable -> L52
        if (r7 == true) goto L41;
        flushToMemory();     // Catch: Throwable -> L52
    L41:
        reset();     // Catch: Throwable -> L52
        if (ApmContext.isDebugMode() == false) goto L44;
        Logger.d(Constants.TAG, "flush cost=" + (System.nanoTime() - r4));     // Catch: Throwable -> L52
    L44:
        monitor-exit(this);
        return;
    L30:
        Logger.e(Constants.TAG, "rename error" + r12.getAbsolutePath());     // Catch: Throwable -> L36
        goto L32
    L16:
        if (this.flushDir.exists() == true) goto L24;
        File r13 = this.flushDir.getParentFile();     // Catch: Throwable -> L22
        if (r13.exists() == true) goto L20;
        r13.mkdirs();     // Catch: Throwable -> L22
    L20:
        this.flushDir.mkdirs();     // Catch: Throwable -> L22
    L36:
        th = move-exception;
        Logger.e(Constants.TAG, this.flushDir.exists() + " flush to file failed.", th);     // Catch: Throwable -> L55
    L47:
        if (ApmContext.isDebugMode() == false) goto L49;
        Logger.d(Constants.TAG, "flushing: Skipped. no data to flush. reset buffer now.");     // Catch: Throwable -> L52
    L49:
        reset();     // Catch: Throwable -> L52
        monitor-exit(this);
        return;
    L52:
        th = move-exception;
        throw th;
    }

    private void flushToMemory() {
        this.byteBuffer.position(getTotalBytes() + 18);
        this.byteBuffer.flip();
        LogFile r3 = LogFile.fromMemory(this.byteBuffer);
        if (ApmContext.isDebugMode() == false) goto L5;
        Logger.d(Constants.TAG, "flush to memory success. logFile=" + r3);
    L5:
        LogReporter.getInstance().saveLogFileInMemory(r3);
    }

    public synchronized String[] list() {
        monitor-enter(this);
        File[] r0 = DiskEnvironmentHelper.getFlushDirectory().listFiles(new AnonymousClass1(this));     // Catch: Throwable -> L14
        if (r0 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L14
        int r2 = r0.length;     // Catch: Throwable -> L14
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L11;
        r1.add(r0[r3].getName());     // Catch: Throwable -> L14
        r3 = r3 + 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        String[] r4 = (String[]) r1.toArray(new String[r1.size()]);     // Catch: Throwable -> L14
        monitor-exit(this);
        return r4;
    L14:
        th = move-exception;
        throw th;
    }

    private Monitorable createLargeEvent() {
        return new AnonymousClass2(this);
    }
}
