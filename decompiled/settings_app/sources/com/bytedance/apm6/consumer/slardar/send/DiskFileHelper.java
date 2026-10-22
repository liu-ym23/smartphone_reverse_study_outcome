package com.bytedance.apm6.consumer.slardar.send;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.android.settings.utils.HanziToPinyin;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.DiskEnvironmentHelper;
import com.bytedance.apm6.foundation.context.ApmContext;
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

/* JADX INFO: loaded from: classes3.dex */
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

    private static class InnerHolder {
        private static DiskFileHelper instance;

        private InnerHolder() {
        }

        static /* synthetic */ DiskFileHelper access$000() {
            return instance;
        }

        static {
            instance = new DiskFileHelper(null);
        }
    }

    static class RetryMessage {
        private static final String SPLIT = "_";
        private long nextSendTime;
        private int retryCount;

        static /* synthetic */ int access$100(RetryMessage r0) {
            return r0.retryCount;
        }

        static /* synthetic */ long access$200(RetryMessage r2) {
            return r2.nextSendTime;
        }

        public RetryMessage(int r1, long r2) {
            this.retryCount = r1;
            this.nextSendTime = r2;
        }

        void update(int r1, long r2) {
            this.retryCount = r1;
            this.nextSendTime = r2;
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
    }

    /* synthetic */ DiskFileHelper(AnonymousClass1 r1) {
        this();
    }

    private DiskFileHelper() {
        this.retryMessages = new ConcurrentHashMap();
        this.remainSize = 0;
        this.failedFilesInited = false;
        this.failedFiles = new ArrayList();
    }

    static DiskFileHelper getInstance() {
        return InnerHolder.access$000();
    }

    synchronized boolean saveFile(byte[] r8, String r9, int r10, long r11) {
        monitor-enter(this);
        ensureInit();     // Catch: Throwable -> L28
        if (this.directory != null) goto L9;
        monitor-exit(this);
        return false;
    L9:
        String r12 = String.format("%d%s%s%s%s", new Object[]{Long.valueOf(System.currentTimeMillis()), "_", UUID.randomUUID().toString(), ".", r9});     // Catch: Throwable -> L28
        File r1 = new File(this.directory, r12);     // Catch: Throwable -> L28
        FileChannel r3 = null;
        updateRetryMessage(r1, r10, r11);     // Catch: Throwable -> L20
        r3 = new FileOutputStream(r1).getChannel();     // Catch: Throwable -> L20
        r3.write(ByteBuffer.wrap(r8));     // Catch: Throwable -> L20
        if (this.failedFiles.contains(r12) == true) goto L15;
        add(r12);     // Catch: Throwable -> L20
    L15:
        if (ApmContext.isDebugMode() == false) goto L17;
        Logger.d(Constants.TAG, "saveFile:" + r1.getName());     // Catch: Throwable -> L20
    L17:
        IOUtils.closeQuietly(r3);     // Catch: Throwable -> L28
        monitor-exit(this);
        return true;
    L20:
        th = move-exception;
        Logger.e(Constants.TAG, "saveFile", th);     // Catch: Throwable -> L25
        IOUtils.closeQuietly(r3);     // Catch: Throwable -> L28
        return false;
    L25:
        th = move-exception;
        IOUtils.closeQuietly(r3);     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    synchronized void deleteLog(File r3) {
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

    synchronized File getSendFile(String r9) {
        monitor-enter(this);
        String r10 = "." + r9;     // Catch: Throwable -> L44
        initFailedFiles();     // Catch: Throwable -> L44
        if (ApmContext.isDebugMode() == false) goto L8;
        Logger.d(Constants.TAG, "failedFiles:" + this.failedFiles + HanziToPinyin.Token.SEPARATOR + r10);     // Catch: Throwable -> L44
    L8:
        File r1 = null;
        if (this.failedFiles.size() != 0) goto L12;
        monitor-exit(this);
        return null;
    L12:
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L44
        Iterator<String> r2 = this.failedFiles.iterator();     // Catch: Throwable -> L44
    L14:
        if (r2.hasNext() == false) goto L19;
        String r3 = r2.next();     // Catch: Throwable -> L44
        if (r3.endsWith(r10) == false) goto L14;
        r0.add(r3);     // Catch: Throwable -> L44
        goto L14
    L19:
        if (ListUtils.isEmpty(r0) == false) goto L22;
        monitor-exit(this);
        return null;
    L22:
        Collections.sort(r0, new AnonymousClass1(this));     // Catch: Throwable -> L44
        Iterator r11 = r0.iterator();     // Catch: Throwable -> L44
        RetryMessage r4 = null;
    L23:
        if (r11.hasNext() == false) goto L42;
        File r5 = new File(getInstance().getDirectory(), (String) r11.next());     // Catch: Throwable -> L44
        RetryMessage r6 = getReportMessage(r5);     // Catch: Throwable -> L44
        if (r6 == null) goto L41;
        if (ApmContext.isDebugMode() == false) goto L32;
        Logger.d(Constants.TAG, "list send file:" + r5.getName() + HanziToPinyin.Token.SEPARATOR + RetryMessage.access$100(r6) + HanziToPinyin.Token.SEPARATOR + RetryMessage.access$200(r6) + HanziToPinyin.Token.SEPARATOR + System.currentTimeMillis());     // Catch: Throwable -> L44
    L32:
        if (RetryMessage.access$100(r6) == 0) goto L41;
        if (RetryMessage.access$200(r6) < System.currentTimeMillis()) goto L41;
        if (r4 == null) goto L40;
        if (RetryMessage.access$200(r4) <= RetryMessage.access$200(r6)) goto L23;
    L40:
        r4 = r6;
        r1 = r5;
    L41:
        r1 = r5;
    L42:
        monitor-exit(this);
        return r1;
    L44:
        th = move-exception;
        throw th;
    }

    File getDirectory() {
        ensureInit();
        return this.directory;
    }

    File[] listFiles() {
        ensureInit();
        File r0 = this.directory;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.listFiles();
    }

    RetryMessage getReportMessage(File r4) {
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

    void updateRetryMessage(File r3, int r4, long r5) {
        if (r3 != null) goto L13;
        return;
    L13:
        ensureInit();     // Catch: Throwable -> L10
        SharedPreferences.Editor r0 = this.sharedPreferences.edit();     // Catch: Throwable -> L10
        String r6 = r3.getName();     // Catch: Throwable -> L10
        if (this.retryMessages.containsKey(r6) == false) goto L7;
        RetryMessage r2 = this.retryMessages.get(r6);     // Catch: Throwable -> L10
    L8:
        r2.update(r4, r5);     // Catch: Throwable -> L10
        r0.putString(r6, r2.getString());     // Catch: Throwable -> L10
        r0.commit();     // Catch: Throwable -> L10
        return;
    L7:
        RetryMessage r1 = new RetryMessage(r4, r5);     // Catch: Throwable -> L10
        this.retryMessages.put(r6, r1);     // Catch: Throwable -> L10
        r2 = r1;
    L10:
        th = move-exception;
        Logger.e(Constants.TAG, "updateRetryMessage", th);
    }

    static long getCreateTime(File r4) {
        String[] r5 = r4.getName().split("_");     // Catch: Throwable -> L8
        if (r5.length == 2) goto L6;
        return -1;
    L6:
        return Long.parseLong(r5[0]);
    L11:
        return -1;
    }

    private synchronized void ensureInit() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.inited == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        File r0 = new File(DiskEnvironmentHelper.getWorkingDirectory(), LOG);     // Catch: Throwable -> L13
        if (r0.exists() == true) goto L10;
        r0.mkdirs();     // Catch: Throwable -> L13
    L10:
        this.directory = r0;     // Catch: Throwable -> L13
        this.sharedPreferences = ApmContext.getContext().getSharedPreferences(REPORT_MESSAGE, 0);     // Catch: Throwable -> L13
        this.inited = true;     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    private synchronized void initFailedFiles() {
        monitor-enter(this);
        int r1 = 0;
        if (this.failedFilesInited == true) goto L13;
        String[] r0 = getInstance().getDirectory().list();     // Catch: Throwable -> L25
        int r2 = r0.length;     // Catch: Throwable -> L25
    L6:
        if (r1 >= r2) goto L11;
        String r3 = r0[r1];     // Catch: Throwable -> L25
        if (this.failedFiles.contains(r3) == true) goto L10;
        add(r3);     // Catch: Throwable -> L25
    L10:
        r1 = r1 + 1;     // Catch: Throwable -> L25
        goto L6
    L11:
        this.failedFilesInited = true;     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L13:
        if (this.remainSize <= 0) goto L23;
        if (this.failedFiles.size() != 0) goto L23;
        String[] r4 = getInstance().getDirectory().list();     // Catch: Throwable -> L25
        int r5 = r4.length;     // Catch: Throwable -> L25
    L17:
        if (r1 >= r5) goto L22;
        String r6 = r4[r1];     // Catch: Throwable -> L25
        if (this.failedFiles.contains(r6) == true) goto L21;
        add(r6);     // Catch: Throwable -> L25
    L21:
        r1 = r1 + 1;     // Catch: Throwable -> L25
        goto L17
    L22:
        this.remainSize -= (long) this.failedFiles.size();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    private void add(String r5) {
        if (this.failedFiles.size() <= 5000) goto L6;
        this.remainSize++;
        return;
    L6:
        this.failedFiles.add(r5);
    }
}
