package com.bytedance.apm6.consumer.slardar;

import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm6.consumer.slardar.persistent.LogFile;
import com.bytedance.apm6.consumer.slardar.persistent.PersistentBuffer;
import com.bytedance.apm6.consumer.slardar.send.LogSender;
import com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.cache.LimitedQueue;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.common.utility.io.IOUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LogReporter implements WeedOutStrategy {
    private static final long LOOP_INTERVAL = 60000;
    private static final long MAX_BODY_BYTES = 1048576;
    private static final String TYPE_WEED_OUT = "first_log_dir";
    private volatile AsyncTask asyncTask;
    private volatile long interval;
    private volatile boolean isPaused;
    private LimitedQueue<LogFile> limitedQueue;
    private volatile long onceReportMaxSizeBytes;
    private volatile PersistentBuffer persistentBuffer;

    public static class InnerHolder {
        private static final LogReporter instance = null;

        static {
            instance = new LogReporter();
        }

        private InnerHolder() {
        }

        public static /* synthetic */ LogReporter access$000() {
            return instance;
        }
    }

    public LogReporter() {
        this.interval = 60000;
        this.onceReportMaxSizeBytes = 1048576;
        this.limitedQueue = new LimitedQueue(10);
        this.isPaused = false;
    }

    public static /* synthetic */ void access$100(LogReporter r0) {
        r0.report();
    }

    public static /* synthetic */ void access$200(LogReporter r0) {
        r0.moveInactiveSubProcessData();
    }

    public static /* synthetic */ PersistentBuffer access$300(LogReporter r0) {
        return r0.persistentBuffer;
    }

    private void flushBuffer() {
    L6:
        th = move-exception;
        Logger.e(Constants.TAG, "flushBuffer", th);
        return;
    L3:
        if (this.persistentBuffer == null) goto L11;
        this.persistentBuffer.flush();     // Catch: Throwable -> L6
        return;
    }

    private long getCreateTime(File r4) {
        String r3 = r4.getName();
        int r5 = r3.indexOf("_");
        if (r5 != (-1)) goto L9;
        return -1;
    L9:
        return Long.parseLong(r3.substring(0, r5));
    L8:
        return -1;
    }

    public static LogReporter getInstance() {
        return InnerHolder.access$000();
    }

    private void moveInactiveSubProcessData() {
        File r13 = DiskEnvironmentHelper.getSubProcessPersistentDirectory();
        if (r13.exists() == true) goto L5;
        return;
    L5:
        File[] r14 = r13.listFiles();
        if (r14 != null) goto L8;
        return;
    L8:
        int r0 = r14.length;
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L43;
        File r3 = r14[r2];
        if (r3 == null) goto L42;
        if (r3.exists() == false) goto L42;
        if (r3.length() <= 0) goto L42;
        if (Long.parseLong(r3.getName().split("_")[0]) >= ApmContext.getInitTimeStamp()) goto L42;
        FileChannel r4 = null;
        r4 = new RandomAccessFile(r3, "rw").getChannel();     // Catch: Throwable -> L28
        FileLock r5 = r4.tryLock(0, Long.MAX_VALUE, false);     // Catch: Throwable -> L28
        if (r5 == null) goto L32;
        if (r5.isValid() == false) goto L32;
        File r6 = new File(DiskEnvironmentHelper.getFlushDirectory(), DiskEnvironmentHelper.generateFlushFileName());     // Catch: Throwable -> L28
        boolean r7 = IOUtils.renameFile(r3.getAbsolutePath(), r6.getAbsolutePath());     // Catch: Throwable -> L28
        if (ApmBaseContext.isDebugMode() == false) goto L30;
        Logger.d(Constants.TAG, "moveInactiveSubProcessData: src:" + r3.getAbsolutePath() + " dst:" + r6.getAbsolutePath() + " isSuccess:" + r7);     // Catch: Throwable -> L28
    L30:
        r5.release();     // Catch: Throwable -> L28
    L34:
        com.bytedance.apm6.util.IOUtils.closeQuietly(r4);
    L32:
        if (ApmBaseContext.isDebugMode() == false) goto L34;
        Logger.d(Constants.TAG, "moveInactiveSubProcessData isValid is not true ");     // Catch: Throwable -> L28
    L28:
        th = move-exception;
    L39:
        th = move-exception;
        com.bytedance.apm6.util.IOUtils.closeQuietly(r4);
        throw th;
    L36:
        if (ApmBaseContext.isDebugMode() == false) goto L34;
        Logger.w(Constants.TAG, "moveInactiveSubProcessData failed.", th);     // Catch: Throwable -> L39
    L42:
        r2 = r2 + 1;
        goto L9
    }

    private void report() {
        long r0 = System.currentTimeMillis();
        flushBuffer();
        reportMemory();
        if (ApmContext.isMainProcess() == false) goto L8;
        if (this.isPaused == true) goto L8;
        reportFile();
    L8:
        if (ApmBaseContext.isDebugMode() == false) goto L11;
        Logger.d(Constants.TAG, "LogReporter One Loop Cost:" + (System.currentTimeMillis() - r0));
        return;
    }

    private void reportFile() {
        if (this.persistentBuffer == null) goto L5;
        String[] r0 = this.persistentBuffer.list();
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.length == 0) goto L48;
        List r1 = Arrays.asList(r0);
        Collections.sort(r1, new AnonymousClass6(this));
        if (ApmBaseContext.isDebugMode() == false) goto L13;
        Logger.d(Constants.TAG, "reportFile: parsing " + r1.size() + " files. fileNameList" + r1);
    L13:
        ArrayList r2 = new ArrayList();
        int r3 = 0;
        int r4 = 0;
    L15:
        if (r3 >= r1.size()) goto L38;
        File r7 = new File(DiskEnvironmentHelper.getFlushDirectory(), (String) r1.get(r3));
        if (r7.exists() == false) goto L36;
        LogFile r5 = LogFile.fromFile(r7);
        if (r5 == null) goto L22;
        int r8 = r5.getTotalBytes();
        if (r4 != 0) goto L28;
    L35:
        r4 = r4 + r8;
        r2.add(r5);
        goto L36
    L28:
        if ((r4 + r8) < this.onceReportMaxSizeBytes) goto L35;
        if (ApmAlogHelper.getInnerLogger() == null) goto L33;
        ApmAlogHelper.getInnerLogger().d(Constants.TAG, "sendList:" + r1.toString());
    L33:
        LogSender.getInstance().sendLog(r2, r1.size() - r2.size());
        return;
    L22:
        if (ApmBaseContext.isDebugMode() == false) goto L24;
        Logger.d(Constants.TAG, "logFile invalid. delete now.");
    L24:
        r7.delete();
    L36:
        r3 = r3 + 1;
        goto L15
    L38:
        if (ApmAlogHelper.getInnerLogger() == null) goto L40;
        ApmAlogHelper.getInnerLogger().d(Constants.TAG, "sendList:" + r1.toString());
    L40:
        LogSender.getInstance().sendLog(r2, 0);
        return;
    L48:
        return;
    L5:
        Logger.e(Constants.TAG, "persistentBuffer is null");
        r0 = null;
        goto L6
    }

    private void reportMemory() {
        if (this.limitedQueue.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L7:
        if (this.limitedQueue.isEmpty() == true) goto L18;
        r0.add(this.limitedQueue.pop());
        LogFile r3 = this.limitedQueue.pop();
        if (r3 == null) goto L7;
        int r4 = r3.getTotalBytes();
        if (r2 == 0) goto L17;
        if ((r2 + r4) < this.onceReportMaxSizeBytes) goto L17;
        LogSender.getInstance().sendLog(r0, 0);
        r0.clear();
        r0.add(r3);
        r2 = r4;
    L17:
        r2 = r2 + r4;
        r0.add(r3);
        goto L7
    L18:
        LogSender.getInstance().sendLog(r0, 0);
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public void doWeedOut(long r10) {
        if (this.persistentBuffer != null) goto L5;
        return;
    L5:
        String[] r0 = this.persistentBuffer.list();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.length == 0) goto L24;
        int r1 = r0.length;
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L25;
        String r3 = r0[r2];
        File r4 = new File(DiskEnvironmentHelper.getFlushDirectory(), r3);
        long r5 = getCreateTime(r4);
        if (r5 != (-1)) goto L16;
        FileUtils.deleteFile(r4);
    L18:
        r2 = r2 + 1;
        goto L11
    L16:
        if (r5 > r10) goto L18;
        FileUtils.deleteFile(r4);
        goto L18
    L25:
        return;
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public void doWeedOutSize(long r11) {
        if (this.persistentBuffer != null) goto L5;
        return;
    L5:
        String[] r10 = this.persistentBuffer.list();
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.length == 0) goto L41;
        Arrays.sort(r10);
        int r0 = r10.length;
        int r1 = 0;
        long r2 = 0;
        int r4 = 0;
        long r5 = 0;
    L11:
        if (r4 >= r0) goto L18;
        File r8 = new File(DiskEnvironmentHelper.getFlushDirectory(), r10[r4]);
        if (r8.exists() == false) goto L17;
        if (r8.isFile() == false) goto L17;
        r5 = r5 + r8.length();
    L17:
        r4 = r4 + 1;
        goto L11
    L18:
        int r3 = r10.length;
    L19:
        if (r1 >= r3) goto L42;
        String r6 = r10[r1];
        if ((r5 - r2) <= r11) goto L43;
        File r7 = new File(DiskEnvironmentHelper.getFlushDirectory(), r6);
        if (r7.exists() == false) goto L29;
        if (r7.isFile() == false) goto L29;
        long r9 = r7.length();
        if (FileUtils.deleteFileWithResult(r7) == false) goto L29;
        r2 = r2 + r9;
    L29:
        r1 = r1 + 1;
        goto L19
    L43:
        return;
    L42:
        return;
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public String getName() {
        return TYPE_WEED_OUT;
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public long getSize() {
        String[] r7 = this.persistentBuffer.list();
        long r0 = 0;
        if (r7 != null) goto L5;
    L10:
        return r0;
    L5:
        if (r7.length == 0) goto L10;
        int r2 = r7.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L10;
        String r4 = r7[r3];
        r0 = r0 + new File(DiskEnvironmentHelper.getFlushDirectory(), r4).length();
        r3 = r3 + 1;
        goto L8
    }

    public synchronized void init() {
        monitor-enter(this);
        final long r4 = this.interval;     // Catch: Throwable -> L7
        final long r2 = 0;
        this.asyncTask = new AnonymousClass2(this, r2, r4);     // Catch: Throwable -> L7
        AsyncTaskManagerType r0 = AsyncTaskManagerType.IO;     // Catch: Throwable -> L7
        AsyncTaskManager.getInstance(r0).sendTask(this.asyncTask);     // Catch: Throwable -> L7
        if (ApmContext.isMainProcess() == false) goto L9;
        final long r3 = 10000;
        AsyncTaskManager.getInstance(r0).sendTask(new AnonymousClass3(this, r3));     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void pause() {
        monitor-enter(this);
        this.isPaused = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void restart() {
        monitor-enter(this);
        AsyncTaskManager.getInstance(AsyncTaskManagerType.IO).sendTask(new AnonymousClass4(this));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void resume() {
        monitor-enter(this);
        this.isPaused = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void saveLogFileInMemory(LogFile r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.limitedQueue.push(r1);
    }

    public synchronized void setLoopInterval(long r8) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (ApmBaseContext.isDebugMode() == false) goto L10;
        Logger.d(Constants.TAG, "setLoopInterval:" + this.interval);     // Catch: Throwable -> L7
    L10:
        if (r8 > 0) goto L12;
    L21:
        monitor-exit(this);
        return;
    L12:
        if (this.interval == r8) goto L21;
        this.interval = r8;     // Catch: Throwable -> L7
        if (this.asyncTask != null) goto L18;
        monitor-exit(this);
        return;
    L18:
        AsyncTaskManagerType r9 = AsyncTaskManagerType.IO;     // Catch: Throwable -> L7
        AsyncTaskManager.getInstance(r9).removeTask(this.asyncTask);     // Catch: Throwable -> L7
        final long r3 = this.interval;     // Catch: Throwable -> L7
        final long r5 = this.interval;     // Catch: Throwable -> L7
        this.asyncTask = new AnonymousClass1(this, r3, r5);     // Catch: Throwable -> L7
        AsyncTaskManager.getInstance(r9).sendTask(this.asyncTask);     // Catch: Throwable -> L7
        monitor-exit(this);
    }

    public void setOnceReportMaxSizeBytes(long r3) {
        if (r3 > 0) goto L5;
        return;
    L5:
        this.onceReportMaxSizeBytes = r3;
    }

    public void setPersistentBuffer(PersistentBuffer r1) {
        this.persistentBuffer = r1;
    }

    public void uploadRemainLogs() {
        if (ApmContext.isMainProcess() == true) goto L5;
        return;
    L5:
        AsyncTaskManager.getInstance(AsyncTaskManagerType.IO).sendTask(new AnonymousClass5(this));
    }
}
