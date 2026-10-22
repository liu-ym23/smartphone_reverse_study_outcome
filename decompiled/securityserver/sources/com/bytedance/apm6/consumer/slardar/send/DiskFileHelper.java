package com.bytedance.apm6.consumer.slardar.send;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.DiskEnvironmentHelper;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.log.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
class DiskFileHelper {
    private static final String DOT = ".";
    private static final String JOINER = "_";
    private static final String LOG = "log";
    private static final long MAX_SIZE = 5000;
    private static final String REPORT_MESSAGE = "log_report_message";
    private File directory;
    private ArrayList<String> failedFiles;
    private volatile boolean failedFilesInited;
    private volatile boolean inited;
    private long remainSize;
    private ConcurrentHashMap<String, RetryMessage> retryMessages;
    private SharedPreferences sharedPreferences;

    public static class InnerHolder {
        private static DiskFileHelper instance;

        static {
            instance = new DiskFileHelper(null);
        }

        private InnerHolder() {
        }

        public static /* synthetic */ DiskFileHelper access$000() {
            return instance;
        }
    }

    public static class RetryMessage {
        private static final String SPLIT = "_";
        private long nextSendTime;
        private int retryCount;

        public RetryMessage(int r1, long r2) {
            this.retryCount = r1;
            this.nextSendTime = r2;
        }

        public static /* synthetic */ int access$100(RetryMessage r0) {
            return r0.retryCount;
        }

        public static /* synthetic */ long access$200(RetryMessage r2) {
            return r2.nextSendTime;
        }

        public static RetryMessage parse(String r4) {
            String[] r5 = r4.split("_");     // Catch: Exception -> L4
            return new RetryMessage(Integer.parseInt(r5[0]), Long.parseLong(r5[1]));
        L4:
            return null;
        }

        public int getRetryCount() {
            return this.retryCount;
        }

        public String getString() {
            return this.retryCount + "_" + this.nextSendTime;
        }

        public void update(int r1, long r2) {
            this.retryCount = r1;
            this.nextSendTime = r2;
        }
    }

    public /* synthetic */ DiskFileHelper(AnonymousClass1 r1) {
        this();
    }

    private void add(String r5) {
        if (this.failedFiles.size() <= 5000) goto L6;
        this.remainSize++;
        return;
    L6:
        this.failedFiles.add(r5);
    }

    private synchronized void ensureInit() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.inited == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        File r0 = new File(DiskEnvironmentHelper.getWorkingDirectory(), LOG);     // Catch: Throwable -> L10
        if (r0.exists() == true) goto L12;
        r0.mkdirs();     // Catch: Throwable -> L10
    L12:
        this.directory = r0;     // Catch: Throwable -> L10
        this.sharedPreferences = ApmBaseContext.getContext().getSharedPreferences(REPORT_MESSAGE, 0);     // Catch: Throwable -> L10
        this.inited = true;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public static long getCreateTime(File r4) {
        String[] r5 = r4.getName().split("_");     // Catch: Throwable -> L8
        if (r5.length == 2) goto L6;
        return -1;
    L6:
        return Long.parseLong(r5[0]);
    L11:
        return -1;
    }

    public static DiskFileHelper getInstance() {
        return InnerHolder.access$000();
    }

    private synchronized void initFailedFiles() {
        monitor-enter(this);
        int r1 = 0;
        if (this.failedFilesInited == true) goto L15;
        String[] r0 = getInstance().getDirectory().list();     // Catch: Throwable -> L10
        int r2 = r0.length;     // Catch: Throwable -> L10
    L6:
        if (r1 >= r2) goto L13;
        String r3 = r0[r1];     // Catch: Throwable -> L10
        if (this.failedFiles.contains(r3) == true) goto L12;
        add(r3);     // Catch: Throwable -> L10
    L12:
        r1 = r1 + 1;     // Catch: Throwable -> L10
        goto L6
    L13:
        this.failedFilesInited = true;     // Catch: Throwable -> L10
    L25:
        monitor-exit(this);
        return;
    L15:
        if (this.remainSize <= 0) goto L25;
        if (this.failedFiles.size() != 0) goto L25;
        String[] r4 = getInstance().getDirectory().list();     // Catch: Throwable -> L10
        int r5 = r4.length;     // Catch: Throwable -> L10
    L19:
        if (r1 >= r5) goto L24;
        String r6 = r4[r1];     // Catch: Throwable -> L10
        if (this.failedFiles.contains(r6) == true) goto L23;
        add(r6);     // Catch: Throwable -> L10
    L23:
        r1 = r1 + 1;     // Catch: Throwable -> L10
        goto L19
    L24:
        this.remainSize -= (long) this.failedFiles.size();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"ApplySharedPref"})
    public synchronized void deleteLog(File r3) {
        monitor-enter(this);
        if (r3 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.failedFiles.remove(r3.getName());     // Catch: Throwable -> L9
        ensureInit();     // Catch: Throwable -> L9
        FileUtils.deleteFile(r3);     // Catch: Throwable -> L9
        this.retryMessages.remove(r3.getName());     // Catch: Throwable -> L9
        SharedPreferences.Editor r0 = this.sharedPreferences.edit();     // Catch: Throwable -> L9
        r0.remove(r3.getName());     // Catch: Throwable -> L9
        r0.commit();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public File getDirectory() {
        ensureInit();
        return this.directory;
    }

    public RetryMessage getReportMessage(File r4) {
        RetryMessage r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        ensureInit();
        String r5 = r4.getName();
        if (this.retryMessages.containsKey(r5) == false) goto L10;
        return this.retryMessages.get(r5);
    L10:
        if (this.sharedPreferences.contains(r5) == false) goto L16;
        String r1 = this.sharedPreferences.getString(r5, "");
        if (TextUtils.isEmpty(r1) == true) goto L14;
        r0 = RetryMessage.parse(r1);
    L14:
        if (r0 == null) goto L16;
        this.retryMessages.put(r5, r0);
    L16:
        return r0;
    }

    public synchronized File getSendFile(String r9) {
        monitor-enter(this);
        String r10 = "." + r9;     // Catch: Throwable -> L7
        initFailedFiles();     // Catch: Throwable -> L7
        if (ApmBaseContext.isDebugMode() == false) goto L10;
        Logger.d(Constants.TAG, "failedFiles:" + this.failedFiles + " " + r10);     // Catch: Throwable -> L7
    L10:
        File r1 = null;
        if (this.failedFiles.size() != 0) goto L14;
        monitor-exit(this);
        return null;
    L14:
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L7
        Iterator<String> r2 = this.failedFiles.iterator();     // Catch: Throwable -> L7
    L16:
        if (r2.hasNext() == false) goto L21;
        String r3 = r2.next();     // Catch: Throwable -> L7
        if (r3.endsWith(r10) == false) goto L16;
        r0.add(r3);     // Catch: Throwable -> L7
        goto L16
    L21:
        if (ListUtils.isEmpty(r0) == false) goto L24;
        monitor-exit(this);
        return null;
    L24:
        Collections.sort(r0, new AnonymousClass1(this));     // Catch: Throwable -> L7
        Iterator r11 = r0.iterator();     // Catch: Throwable -> L7
        RetryMessage r4 = null;
    L25:
        if (r11.hasNext() == false) goto L44;
        File r5 = new File(getInstance().getDirectory(), (String) r11.next());     // Catch: Throwable -> L7
        RetryMessage r6 = getReportMessage(r5);     // Catch: Throwable -> L7
        if (r6 == null) goto L43;
        if (ApmBaseContext.isDebugMode() == false) goto L34;
        Logger.d(Constants.TAG, "list send file:" + r5.getName() + " " + RetryMessage.access$100(r6) + " " + RetryMessage.access$200(r6) + " " + System.currentTimeMillis());     // Catch: Throwable -> L7
    L34:
        if (RetryMessage.access$100(r6) == 0) goto L43;
        if (RetryMessage.access$200(r6) < System.currentTimeMillis()) goto L43;
        if (r4 == null) goto L42;
        if (RetryMessage.access$200(r4) <= RetryMessage.access$200(r6)) goto L25;
    L42:
        r4 = r6;
        r1 = r5;
    L43:
        r1 = r5;
    L44:
        monitor-exit(this);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public File[] listFiles() {
        ensureInit();
        File r0 = this.directory;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.listFiles();
    }

    public synchronized boolean saveFile(byte[] r8, String r9, int r10, long r11) {
        monitor-enter(this);
        ensureInit();     // Catch: Throwable -> L23
        if (this.directory != null) goto L9;
        monitor-exit(this);
        return false;
    L9:
        String r12 = String.format("%d%s%s%s%s", new Object[]{Long.valueOf(System.currentTimeMillis()), "_", UUID.randomUUID().toString(), ".", r9});     // Catch: Throwable -> L23
        File r1 = new File(this.directory, r12);     // Catch: Throwable -> L23
        FileChannel r3 = null;
        updateRetryMessage(r1, r10, r11);     // Catch: Throwable -> L14
        r3 = new FileOutputStream(r1).getChannel();     // Catch: Throwable -> L14
        r3.write(ByteBuffer.wrap(r8));     // Catch: Throwable -> L14
        if (this.failedFiles.contains(r12) == true) goto L17;
        add(r12);     // Catch: Throwable -> L14
    L17:
        if (ApmBaseContext.isDebugMode() == false) goto L19;
        Logger.d(Constants.TAG, "saveFile:" + r1.getName());     // Catch: Throwable -> L14
    L19:
        IOUtils.closeQuietly(r3);     // Catch: Throwable -> L23
        monitor-exit(this);
        return true;
    L14:
        th = move-exception;
        Logger.e(Constants.TAG, "saveFile", th);     // Catch: Throwable -> L29
        IOUtils.closeQuietly(r3);     // Catch: Throwable -> L23
        return false;
    L29:
        th = move-exception;
        IOUtils.closeQuietly(r3);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"ApplySharedPref"})
    public void updateRetryMessage(File r3, int r4, long r5) {
        if (r3 != null) goto L14;
        return;
    L14:
        ensureInit();     // Catch: Throwable -> L7
        SharedPreferences.Editor r0 = this.sharedPreferences.edit();     // Catch: Throwable -> L7
        String r6 = r3.getName();     // Catch: Throwable -> L7
        if (this.retryMessages.containsKey(r6) == false) goto L9;
        RetryMessage r2 = this.retryMessages.get(r6);     // Catch: Throwable -> L7
    L10:
        r2.update(r4, r5);     // Catch: Throwable -> L7
        r0.putString(r6, r2.getString());     // Catch: Throwable -> L7
        r0.commit();     // Catch: Throwable -> L7
        return;
    L9:
        RetryMessage r1 = new RetryMessage(r4, r5);     // Catch: Throwable -> L7
        this.retryMessages.put(r6, r1);     // Catch: Throwable -> L7
        r2 = r1;
    L7:
        th = move-exception;
        Logger.e(Constants.TAG, "updateRetryMessage", th);
    }

    private DiskFileHelper() {
        this.retryMessages = new ConcurrentHashMap();
        this.remainSize = 0;
        this.failedFilesInited = false;
        this.failedFiles = new ArrayList();
    }
}
