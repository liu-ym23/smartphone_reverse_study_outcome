package com.bytedance.apm6.consumer.slardar.persistent;

import com.bytedance.apm.doctor.DoctorDataUtil;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.DiskEnvironmentHelper;
import com.bytedance.apm6.consumer.slardar.LogReporter;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.ApmBaseContext;
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

    private Monitorable createLargeEvent() {
        return new AnonymousClass2(this);
    }

    private void flushToMemory() {
        this.byteBuffer.position(getTotalBytes() + 18);
        this.byteBuffer.flip();
        LogFile r3 = LogFile.fromMemory(this.byteBuffer);
        if (ApmBaseContext.isDebugMode() == false) goto L5;
        Logger.d(Constants.TAG, "flush to memory success. logFile=" + r3);
    L5:
        LogReporter.getInstance().saveLogFileInMemory(r3);
    }

    private long getHeaderId() {
        return this.byteBuffer.getLong(2);
    }

    private short getMagicNumber() {
        return this.byteBuffer.getShort(0);
    }

    private int getTotalBytes() {
        return this.byteBuffer.getInt(14);
    }

    private int getTotalCount() {
        return this.byteBuffer.getInt(10);
    }

    private void reset() {
        this.byteBuffer.clear();
        this.byteBuffer.putShort(MAGIC_NUMBER);
        this.byteBuffer.putLong(this.headerId);
        this.byteBuffer.putInt(0);
        this.byteBuffer.putInt(0);
    }

    private void setTotalBytes(int r2) {
        this.byteBuffer.putInt(14, r2);
    }

    private void setTotalCount(int r2) {
        this.byteBuffer.putInt(10, r2);
    }

    public synchronized void flush() {
        monitor-enter(this);
        short r5 = getMagicNumber();     // Catch: Throwable -> L12
        long r6 = getHeaderId();     // Catch: Throwable -> L12
        int r8 = getTotalCount();     // Catch: Throwable -> L12
        int r9 = getTotalBytes();     // Catch: Throwable -> L12
        if (r5 != 2082) goto L51;
        if (r9 <= 0) goto L51;
        if (r8 <= 0) goto L51;
        if (ApmBaseContext.isDebugMode() == false) goto L14;
        Logger.d(Constants.TAG, "flushing: headerId=" + r6 + " totalCount=" + r8 + " totalBytes=" + r9);     // Catch: Throwable -> L12
    L14:
        long r4 = System.nanoTime();     // Catch: Throwable -> L12
        boolean r7 = false;
        FileChannel r10 = null;
        String r11 = System.currentTimeMillis() + "_" + UUID.randomUUID().toString();     // Catch: Throwable -> L30
    L22:
        th = move-exception;
        Logger.e(Constants.TAG, "flushDir create error.", th);     // Catch: Throwable -> L30
    L27:
        File r12 = new File(this.flushDir, r11 + SUFFIX_TMP);     // Catch: Throwable -> L30
        if (r12.exists() == false) goto L32;
        Logger.e(Constants.TAG, "file is exist:" + r12.getName());     // Catch: Throwable -> L30
    L32:
        r10 = new FileOutputStream(r12, false).getChannel();     // Catch: Throwable -> L30
        this.byteBuffer.position(r9 + 18);     // Catch: Throwable -> L30
        this.byteBuffer.flip();     // Catch: Throwable -> L30
        r10.write(this.byteBuffer);     // Catch: Throwable -> L30
        if (r12.renameTo(new File(this.flushDir, r11 + SUFFIX_LOG)) == false) goto L35;
        r7 = true;
    L37:
        if (ApmBaseContext.isDebugMode() == false) goto L39;
        Logger.d(Constants.TAG, "flush to file success. flushFile=" + r12.getAbsolutePath());     // Catch: Throwable -> L30
    L39:
        IOUtils.closeQuietly(r10);     // Catch: Throwable -> L12
        if (r7 == true) goto L45;
        flushToMemory();     // Catch: Throwable -> L12
    L45:
        reset();     // Catch: Throwable -> L12
        if (ApmBaseContext.isDebugMode() == false) goto L48;
        Logger.d(Constants.TAG, "flush cost=" + (System.nanoTime() - r4));     // Catch: Throwable -> L12
    L48:
        monitor-exit(this);
        return;
    L35:
        Logger.e(Constants.TAG, "rename error" + r12.getAbsolutePath());     // Catch: Throwable -> L30
        goto L37
    L18:
        if (this.flushDir.exists() == true) goto L27;
        File r13 = this.flushDir.getParentFile();     // Catch: Throwable -> L22
        if (r13.exists() == true) goto L24;
        r13.mkdirs();     // Catch: Throwable -> L22
    L24:
        this.flushDir.mkdirs();     // Catch: Throwable -> L22
    L30:
        th = move-exception;
        Logger.e(Constants.TAG, this.flushDir.exists() + " flush to file failed.", th);     // Catch: Throwable -> L58
    L51:
        if (ApmBaseContext.isDebugMode() == false) goto L53;
        Logger.d(Constants.TAG, "flushing: Skipped. no data to flush. reset buffer now.");     // Catch: Throwable -> L12
    L53:
        reset();     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized String[] list() {
        monitor-enter(this);
        File[] r0 = DiskEnvironmentHelper.getFlushDirectory().listFiles(new AnonymousClass1(this));     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L11
        int r2 = r0.length;     // Catch: Throwable -> L11
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L13;
        r1.add(r0[r3].getName());     // Catch: Throwable -> L11
        r3 = r3 + 1;     // Catch: Throwable -> L11
        goto L9
    L13:
        String[] r4 = (String[]) r1.toArray(new String[r1.size()]);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r4;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized void push(JSONObject r6) {
        monitor-enter(this);
        if (r6 != null) goto L32;
        monitor-exit(this);
        return;
    L32:
        String r1 = r6.toString();     // Catch: Throwable -> L10
        if (ApmBaseContext.isDebugMode() == false) goto L12;
        DoctorDataUtil.saveToFileEvent(r6);     // Catch: Throwable -> L10
    L12:
        byte[] r7 = r1.getBytes();     // Catch: Throwable -> L10
        int r2 = r7.length + 4;     // Catch: Throwable -> L10
        if (r2 <= 262144) goto L18;
        Monitor.record(createLargeEvent());     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L18:
        if (r2 <= this.byteBuffer.remaining()) goto L20;
        flush();     // Catch: Throwable -> L10
    L20:
        this.byteBuffer.putInt(r7.length);     // Catch: Throwable -> L10
        this.byteBuffer.put(r7);     // Catch: Throwable -> L10
        setTotalCount(getTotalCount() + 1);     // Catch: Throwable -> L10
        setTotalBytes(getTotalBytes() + r2);     // Catch: Throwable -> L10
        if (ApmBaseContext.isDebugMode() == false) goto L24;
        Logger.d(Constants.TAG, "push success: totalCount=" + getTotalCount() + ", totalBytes=" + getTotalBytes() + ", logItem=" + r1);     // Catch: Throwable -> L10
    L24:
        if (this.byteBuffer.position() < TOTAL_BYTES_THRESHOLD) goto L26;
    L27:
        flush();     // Catch: Throwable -> L10
    L28:
        monitor-exit(this);
        return;
    L26:
        if (getTotalCount() < 256) goto L28;
    L10:
        th = move-exception;
        throw th;
    }
}
