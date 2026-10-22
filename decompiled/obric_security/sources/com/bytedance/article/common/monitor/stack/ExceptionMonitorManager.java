package com.bytedance.article.common.monitor.stack;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.UrlUtils;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ExceptionMonitorManager implements AsyncEventManager.IMonitorTimeTask {
    private static final String CONTENT_TYPE = "application/json; charset=utf-8";
    private static final String EXCEPTION_FILTER_SWITCH = "exception_filter_network";
    private static final int EXCEPTION_LOGS_LIMIT_SIZE = 20;
    private static final int EXCEPTION_MSG_LIMIT_SIZE = 10240;
    private static final long EXCEPTION_STOP_COLLECT_INTERVAL = 1800000;
    private static final long EXCEPTION_UPLOAD_INTERVAL = 1200000;
    private static final long LIMIT_UPLOAD_LOG_SIZE = 1048576;
    private static final Object mLock = null;
    private static volatile ExceptionMonitorManager sInstance = null;
    private static volatile IStoreLog sStoreLog = null;
    private static String sUploadUrl = "https://mon.zijieapi.com/monitor/collect/c/exception";
    private volatile CacheExceptionLog mCacheInstance;
    private volatile int mExceptionLogSize;
    private final LinkedList<StackInfo> mExceptionLogs;
    private volatile boolean mForceNotUpload;
    private volatile JSONObject mHeaderInfo;
    private volatile long mLastUploadTime;
    private volatile long mStartStopCollectTime;

    public interface IStoreLog {
        void writeLogToFile(String r1);
    }

    static /* synthetic */ Object access$000() {
        return mLock;
    }

    static /* synthetic */ LinkedList access$100(ExceptionMonitorManager r0) {
        return r0.mExceptionLogs;
    }

    static /* synthetic */ int access$202(ExceptionMonitorManager r0, int r1) {
        r0.mExceptionLogSize = r1;
        return r1;
    }

    static /* synthetic */ JSONObject access$300(ExceptionMonitorManager r0) {
        return r0.mHeaderInfo;
    }

    static /* synthetic */ JSONObject access$302(ExceptionMonitorManager r0, JSONObject r1) {
        r0.mHeaderInfo = r1;
        return r1;
    }

    static /* synthetic */ String access$400() {
        return sUploadUrl;
    }

    static /* synthetic */ void access$500(ExceptionMonitorManager r0, String r1, String r2) {
        r0.uploadLogs(r1, r2);
    }

    @Override // com.bytedance.apm.thread.AsyncEventManager.IMonitorTimeTask
    public void onTimeEvent(long r5) {
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (this.mCacheInstance == null) goto L5;
        this.mCacheInstance.handleCacheLog();     // Catch: Throwable -> L18
    L5:
        long r6 = System.currentTimeMillis();     // Catch: Throwable -> L18
        if ((r6 - this.mLastUploadTime) <= 1200000) goto L10;
        if (this.mExceptionLogSize <= 0) goto L10;
    L11:
        processLogs();     // Catch: Throwable -> L18
    L13:
        if (this.mForceNotUpload == true) goto L15;
        return;
    L15:
        if ((r6 - this.mStartStopCollectTime) <= 1800000) goto L24;
        this.mForceNotUpload = false;     // Catch: Throwable -> L18
        return;
    L24:
        return;
    L10:
        if (this.mExceptionLogSize <= 20) goto L13;
        goto L11
    }

    static {
        mLock = new Object();
    }

    public static ExceptionMonitorManager getInstance() {
        if (sInstance != null) goto L15;
        Object r0 = mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ExceptionMonitorManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public static void setUploadUrl(String r0) {
        sUploadUrl = r0;
    }

    private ExceptionMonitorManager() {
        this.mExceptionLogs = new LinkedList();
        AsyncEventManager.getInstance().addTimeTask(this);
        this.mCacheInstance = new CacheExceptionLog();
    }

    public static void registerLogToFileModule(IStoreLog r1) {
        if (sStoreLog != null) goto L6;
        sStoreLog = r1;
        return;
    }

    boolean getCollectExceptionSwitch(String r1) {
        return ApmDelegate.getInstance().getLogTypeSwitch(r1);
    }

    public void enqueue(String r5, String r6, String r7, boolean r8) {
    L44:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L52;
        boolean r0 = false;
        if (r8 == false) goto L19;
        JSONObject r9 = new JSONObject(r6);     // Catch: Throwable -> L44
        r9.put("log_type", "log_exception");     // Catch: Throwable -> L44
        if (r7 == null) goto L16;
        if (r7.length() <= 10240) goto L14;
        r9.put("extraMessage", r7.substring(0, 10240));     // Catch: Throwable -> L44
        goto L16
    L14:
        r9.put("extraMessage", r7);     // Catch: Throwable -> L44
    L16:
        if (sStoreLog == null) goto L19;
        sStoreLog.writeLogToFile(r9.toString());     // Catch: Throwable -> L44
    L19:
        if (ApmDelegate.getInstance().isConfigReady() == false) goto L21;
        boolean r10 = getCollectExceptionSwitch(r5);     // Catch: Throwable -> L44
        boolean r11 = ApmDelegate.getInstance().getServiceNameSwitch(r7);     // Catch: Throwable -> L44
        if (r10 == true) goto L28;
        if (r11 == true) goto L28;
        return;
    L28:
        if (this.mForceNotUpload == true) goto L51;
        Object r12 = mLock;     // Catch: Throwable -> L44
        monitor-enter(r12);     // Catch: Throwable -> L44
        int r13 = this.mExceptionLogs.size();     // Catch: Throwable -> L40
        if (r13 < 20) goto L35;
        r0 = true;
    L35:
        this.mExceptionLogs.add(new StackInfo(r5, r6));     // Catch: Throwable -> L40
        this.mExceptionLogSize = r13 + 1;     // Catch: Throwable -> L40
        monitor-exit(r12);     // Catch: Throwable -> L40
        if (r0 == false) goto L53;
        processLogs();     // Catch: Throwable -> L44
        return;
    L53:
        return;
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L51:
        return;
    L21:
        if (this.mCacheInstance == null) goto L50;
        this.mCacheInstance.cacheLog(r5, r6);     // Catch: Throwable -> L44
        return;
    L50:
        return;
    }

    public void directReport(StackTraceElement r8, String r9, String r10) {
        String r0 = r8.getClassName();     // Catch: Throwable -> L7
        String r1 = r8.getMethodName();     // Catch: Throwable -> L7
        int r11 = r8.getLineNumber();     // Catch: Throwable -> L7
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L7
        r2.put("event_type", "exception");     // Catch: Throwable -> L7
        r2.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L7
        r2.put("class_ref", r0);     // Catch: Throwable -> L7
        r2.put("method", r1);     // Catch: Throwable -> L7
        r2.put("line_num", r11);     // Catch: Throwable -> L7
        r2.put("stack", r9);     // Catch: Throwable -> L7
        r2.put(ApmTrafficStats.KEY_EXCEPTION_TYPE, 1);     // Catch: Throwable -> L7
        r2.put("is_core", 1);     // Catch: Throwable -> L7
        r2.put("message", r10);     // Catch: Throwable -> L7
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L7
        JSONArray r13 = new JSONArray();     // Catch: Throwable -> L7
        r13.put(r2);     // Catch: Throwable -> L7
        r12.put("data", r13);     // Catch: Throwable -> L7
        if (this.mHeaderInfo != null) goto L5;
        this.mHeaderInfo = ApmContext.getHeader();     // Catch: Throwable -> L7
    L5:
        r12.put("header", this.mHeaderInfo);     // Catch: Throwable -> L7
        HttpUtil.excutePost(1048576, UrlUtils.addParamsToURL(sUploadUrl, ApmContext.getQueryParamsMap()), r12.toString().getBytes(), HttpUtil.CompressType.GZIP, "application/json; charset=utf-8", true);     // Catch: Throwable -> L7
        return;
    }

    public void directReport(Throwable r8, String r9) {
        StackTraceElement[] r0 = r8.getStackTrace();     // Catch: Throwable -> L7
        String r2 = r0[0].getClassName();     // Catch: Throwable -> L7
        String r3 = r0[0].getMethodName();     // Catch: Throwable -> L7
        int r1 = r0[0].getLineNumber();     // Catch: Throwable -> L7
        String r10 = Stack.getExceptionStack(r8);     // Catch: Throwable -> L7
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L7
        r4.put("event_type", "exception");     // Catch: Throwable -> L7
        r4.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L7
        r4.put("class_ref", r2);     // Catch: Throwable -> L7
        r4.put("method", r3);     // Catch: Throwable -> L7
        r4.put("line_num", r1);     // Catch: Throwable -> L7
        r4.put("stack", r10);     // Catch: Throwable -> L7
        r4.put(ApmTrafficStats.KEY_EXCEPTION_TYPE, 1);     // Catch: Throwable -> L7
        r4.put("is_core", 1);     // Catch: Throwable -> L7
        r4.put("message", r9);     // Catch: Throwable -> L7
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L7
        JSONArray r12 = new JSONArray();     // Catch: Throwable -> L7
        r12.put(r4);     // Catch: Throwable -> L7
        r11.put("data", r12);     // Catch: Throwable -> L7
        if (this.mHeaderInfo != null) goto L5;
        this.mHeaderInfo = ApmContext.getHeader();     // Catch: Throwable -> L7
    L5:
        r11.put("header", this.mHeaderInfo);     // Catch: Throwable -> L7
        HttpUtil.excutePost(1048576, UrlUtils.addParamsToURL(sUploadUrl, ApmContext.getQueryParamsMap()), r11.toString().getBytes(), HttpUtil.CompressType.GZIP, "application/json; charset=utf-8", true);     // Catch: Throwable -> L7
        return;
    }

    private void processLogs() {
        this.mLastUploadTime = System.currentTimeMillis();
        AsyncEventManager.getInstance().submitTask(new AnonymousClass1(this));
    }

    private void uploadLogs(String r9, String r10) {
    L6:
        th = move-exception;
        if ((th instanceof HttpResponseException) == false) goto L10;
        int r11 = th.getStatusCode();
    L12:
        if (r11 >= 500) goto L14;
        return;
    L14:
        if (r11 > 600) goto L21;
        this.mStartStopCollectTime = System.currentTimeMillis();
        this.mForceNotUpload = true;
        return;
    L21:
        return;
    L10:
        r11 = -1;
        goto L12
    L3:
        if (ApmDelegate.getInstance().isConfigReady() == false) goto L19;
        HttpUtil.excutePost(1048576, UrlUtils.addParamsToURL(r9, ApmContext.getQueryParamsMap()), r10.getBytes(), HttpUtil.CompressType.GZIP, "application/json; charset=utf-8", true);     // Catch: Throwable -> L6
        return;
    }

    public boolean getExceptionFilterSwitch() {
        if (ApmDelegate.getInstance().isConfigReady() == true) goto L5;
    L7:
        return false;
    L5:
        if (ApmDelegate.getInstance().getLogTypeSwitch(EXCEPTION_FILTER_SWITCH) == true) goto L7;
        return true;
    }
}
