package com.ss.ttuploader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.ss.ttuploader.net.TTUploadDNSParser;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTVideoUploader implements Handler.Callback {
    public static final int FileUploadProcessEncryption = 1;
    public static final int FileUploadProcessTypeOriginal = 0;
    public static final int FileUploadProcessUri = 3;
    public static final int IsClose = 5;
    public static final int IsComplete = 3;
    private static boolean IsErrored = false;
    public static final int IsFail = 2;
    public static final int IsInit = 0;
    public static final int IsStart = 1;
    public static final int IsStop = 4;
    public static final int KeIsAuthorization = 15;
    public static final int KeIsGetRedirectLocation = 14;
    public static final int KeyIsAliveMaxFailTime = 22;
    public static final int KeyIsDisableUploadInfo = 301;
    public static final int KeyIsEnableExternDNS = 21;
    public static final int KeyIsEnableExternNet = 26;
    public static final int KeyIsEnableFileTryHttps = 25;
    public static final int KeyIsEnableHeaderXStorageMode = 83;
    public static final int KeyIsEnableHttps = 19;
    public static final int KeyIsEnableKeepAlive = 20;
    public static final int KeyIsEnableMutiTask = 29;
    public static final int KeyIsEnablePostMethod = 23;
    public static final int KeyIsEnableQuic = 28;
    public static final int KeyIsExternFileReader = 200;
    public static final int KeyIsExternNetLoader = 27;
    public static final int KeyIsExternNetParameter = 41;
    public static final int KeyIsExtra = 58;
    public static final int KeyIsFileRetryCount = 6;
    public static final int KeyIsFileUploadDomain = 2;
    public static final int KeyIsGetAlgorithm = 52;
    public static final int KeyIsGetCoverUrI = 12;
    public static final int KeyIsGetCoverUrl = 11;
    public static final int KeyIsGetDNSIp = 75;
    public static final int KeyIsGetLog = 100;
    public static final int KeyIsGetObjectId = 51;
    public static final int KeyIsGetSecretKey = 50;
    public static final int KeyIsGetTosKey = 300;
    public static final int KeyIsGetVersion = 53;
    public static final int KeyIsGetVideoId = 10;
    public static final int KeyIsHostWeight = 87;
    public static final int KeyIsIsUseServerHost = 17;
    public static final int KeyIsIsUseUpHost = 18;
    public static final int KeyIsLogCallback = 78;
    public static final int KeyIsMaxFailTime = 13;
    public static final int KeyIsMediaDataReader = 201;
    public static final int KeyIsMediaInfo = 68;
    public static final int KeyIsNetworkRoutMode = 86;
    public static final int KeyIsNewHttpProxyLoader = 40;
    public static final int KeyIsObjectType = 54;
    public static final int KeyIsOpenResume = 70;
    public static final int KeyIsPathName = 0;
    public static final int KeyIsPlainObjectId = 59;
    public static final int KeyIsPolicyParams = 55;
    public static final int KeyIsPreUploadEncryptionMode = 74;
    public static final int KeyIsPrivateVideo = 88;
    public static final int KeyIsScenesTag = 85;
    public static final int KeyIsServerParameter = 16;
    public static final int KeyIsSetCustomConfig = 63;
    public static final int KeyIsSetDeviceID = 66;
    public static final int KeyIsSetEvStateEnable = 79;
    public static final int KeyIsSetLinkTurboEnable = 82;
    public static final int KeyIsSetMinSize = 77;
    public static final int KeyIsSetOpenBoe = 67;
    public static final int KeyIsSetResponeTimeOut = 76;
    public static final int KeyIsSetTraceId = 69;
    public static final int KeyIsSetTranTimeOutUnit = 64;
    public static final int KeyIsSetUserRefrence = 62;
    public static final int KeyIsSliceRetryCount = 5;
    public static final int KeyIsSliceSize = 8;
    public static final int KeyIsSliceTimeout = 7;
    public static final int KeyIsSocketNum = 9;
    public static final int KeyIsSourceMd5 = 57;
    public static final int KeyIsTcpOpenTimeOutMilliSec = 24;
    public static final int KeyIsTotalTimeout = 89;
    public static final int KeyIsUploadCookie = 4;
    public static final int KeyIsUserName = 1;
    public static final int KeyIsVideoUploadDomain = 3;
    public static final int MAX_HEADER_SIZE = 20;
    public static final int MessageIsCallBackError = 101;
    public static final int MessageIsCallBackHeader = 102;
    public static final int MessageIsCallBackStage = 103;
    public static final int MessageIsCallBackStageEvent = 104;
    public static final int MessageIsNetRoutError = 112;
    public static final int MessageIsNetRoutVidInfoFirst = 110;
    public static final int MessageIsSpeedTestError = 106;
    public static final int MessageIsSpeedTestSuccess = 105;
    public static final int MessageIsSpeedTestUseless = 108;
    public static final int MessageIsnetRoutVidInfoAll = 111;
    public static final int MsgIsCallBackLog = 100;
    public static final int MsgIsComplete = 0;
    public static final int MsgIsFail = 2;
    public static final int MsgIsUpdateProgress = 1;
    public static final int MsgIsUploadCancel = 3;
    public static final int NetStateIsClose = -1;
    public static final int NetStateIsNotReachable = 0;
    public static final int NetStateIsReachable = 1;
    public static final int NetwrokRoutModeDomain = 0;
    public static final int NetwrokRoutModeTopN = 1;
    public static final int TestModeRout = 1;
    public static final int TestModeSpeed = 0;
    public static final int keyIsConfigString = 56;
    int currentType;
    int headerIndex;
    private TTVideoUploaderAbstractListener mAbstractListener;
    private long mEndTime;
    private long mHandle;
    private Handler mHandler;
    private String[] mHeaders;
    private Lock mHeadersLock;
    private boolean mIsTestSpeed;
    private JSONObject mJsonInfo;
    private TTVideoUploaderListener mListener;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private final ReentrantReadWriteLock mReadWritedLock;
    private long mSartTime;
    private int mState;
    private final ReentrantReadWriteLock.WriteLock mWriteLock;

    public static class LogInfo {
        private int code;
        private String info;

        public LogInfo(int r1, String r2) {
            this.code = r1;
            this.info = r2;
        }

        public int getCode() {
            return this.code;
        }

        public String getInfo() {
            return this.info;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    static {
        if (TTUploadUtil.initInternal() == true) goto L6;
        IsErrored = true;
        return;
    }

    public TTVideoUploader() {
        this.mState = -1;
        this.currentType = 0;
        this.mHandler = null;
        this.mReadWritedLock = new ReentrantReadWriteLock();
        this.mListener = null;
        this.mAbstractListener = null;
        this.mHeadersLock = new ReentrantLock();
        this.mHandle = _create(0);     // Catch: Throwable -> L5
    L7:
        if (this.mHandle == 0) goto L18;
        if (Looper.myLooper() == null) goto L11;
        Handler r2 = new Handler(this);
    L12:
        this.mHandler = r2;
        this.mReadLock = this.mReadWritedLock.readLock();
        this.mWriteLock = this.mReadWritedLock.writeLock();
        getDNSIP();
        this.mState = 0;
        this.mIsTestSpeed = false;
        this.mHeaders = new String[20];
        int r3 = 0;
    L13:
        if (r3 >= 20) goto L15;
        this.mHeaders[r3] = null;
        r3 = r3 + 1;
        goto L13
    L15:
        this.headerIndex = 0;
        return;
    L11:
        r2 = new Handler(Looper.getMainLooper(), this);
        goto L12
    L18:
        throw new Exception("create native uploader fail");
    L5:
        this.mHandle = 0;
        goto L7
    }

    public TTVideoUploader(int r7) {
        this.mState = -1;
        this.currentType = 0;
        this.mHandler = null;
        this.mReadWritedLock = new ReentrantReadWriteLock();
        this.mListener = null;
        this.mAbstractListener = null;
        this.mHeadersLock = new ReentrantLock();
        if (IsErrored == false) goto L5;
        TTUploadUtil.initInternal();
    L5:
        setCurrentType(r7);
        if (r7 != 0) goto L8;
    L28:
        this.mHandle = _create(r7);     // Catch: Throwable -> L27
    L15:
        if (this.mHandle == 0) goto L26;
        if (Looper.myLooper() == null) goto L19;
        Handler r8 = new Handler(this);
    L20:
        this.mHandler = r8;
        this.mReadLock = this.mReadWritedLock.readLock();
        this.mWriteLock = this.mReadWritedLock.writeLock();
        this.mState = 0;
        this.mIsTestSpeed = false;
        getDNSIP();
        this.mHeaders = new String[20];
        int r2 = 0;
    L21:
        if (r2 >= 20) goto L23;
        this.mHeaders[r2] = null;
        r2 = r2 + 1;
        goto L21
    L23:
        this.headerIndex = 0;
        return;
    L19:
        r8 = new Handler(Looper.getMainLooper(), this);
        goto L20
    L26:
        throw new Exception("create native uploader fail");
    L13:
        this.mHandle = 0;
        goto L15
    L8:
        if (r7 == 1) goto L28;
        if (r7 != 3) goto L13;
        goto L13
    }

    private static native void _cancelUpload(long r0);

    private static native String _close(long r0, int r2);

    private final native long _create(int r1);

    private static native long _getLongValue(long r0, int r2);

    private static native String _getStringValue(long r0, int r2);

    private static native void _mergeUpload(long r0);

    private static native void _setContext(long r0, String r2);

    private static native void _setInt64Value(long r0, int r2, long r3);

    private static native void _setIntValue(long r0, int r2, int r3);

    private static native void _setObject(long r0, int r2, Object r3);

    private static native void _setPoster(long r0, float r2);

    private static native void _setStringValue(long r0, int r2, String r3);

    private static native void _start(long r0);

    private static native void _startSpeedTest(long r0, int r2, int r3, int r4);

    private static native String _stop(long r0);

    private static native void _stopSpeedTest(long r0);

    public static boolean isError() {
        return IsErrored;
    }

    private void setDeviceID(long r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (r5 <= 0) goto L10;
        _setInt64Value(r0, 66, r5);
        return;
    }

    private void setTraceId(String r5) {
        if (this.mHandle == 0) goto L10;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.isEmpty() == true) goto L12;
        _setStringValue(this.mHandle, 69, r5);
        return;
    L12:
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public JSONObject addLogToManager(String r4) {
        JSONObject r0 = new JSONObject(r4);     // Catch: Exception -> L22
        r0.put("dns_version", TTUploadResolver.mDNSVersion);     // Catch: Exception -> L22
        r0.put("main_dns_type", TTUploadDNSParser.mGlobalMainType);     // Catch: Exception -> L22
        r0.put("main_back_type", TTUploadDNSParser.mGlobalBackType);     // Catch: Exception -> L22
        r0.put("back_delayed_time", TTUploadDNSParser.mGlobalBackUpDelayedTime);     // Catch: Exception -> L22
        r0.put("expired_time", TTUploadDNSParser.mGlobalDefaultExpiredTime);     // Catch: Exception -> L22
        JSONObject r5 = this.mJsonInfo;     // Catch: Exception -> L22
        if (r5 == null) goto L8;
        Iterator<String> r6 = r5.keys();     // Catch: Exception -> L22
    L6:
        if (r6.hasNext() == false) goto L8;
        String r1 = r6.next();     // Catch: Exception -> L22
        r0.put(r1, this.mJsonInfo.get(r1));     // Catch: Exception -> L22
    L8:
        String r7 = "";
        this.mHeadersLock.lock();     // Catch: Throwable -> L19
        int r2 = 0;
    L11:
        if (r2 >= 20) goto L16;
        if (TextUtils.isEmpty(this.mHeaders[r2]) == true) goto L15;
        r7 = r7 + "#" + this.mHeaders[r2];     // Catch: Throwable -> L19
    L15:
        r2 = r2 + 1;
        goto L11
    L16:
        this.mHeadersLock.unlock();     // Catch: Exception -> L22
        if (TextUtils.isEmpty(r7) == true) goto L24;
        r0.put("cdn_headers", r7);     // Catch: Exception -> L22
    L24:
        if (this.mIsTestSpeed == true) goto L26;
        UploadEventManager.instance.addEvent(r0);
    L26:
        return r0;
    L19:
        th = move-exception;
        this.mHeadersLock.unlock();     // Catch: Exception -> L22
        throw th;     // Catch: Exception -> L22
    L22:
        r0 = null;
        goto L24
    }

    public void allowMergeUpload() {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _mergeUpload(r0);
    }

    public void cancelUpload() {
        this.mWriteLock.lock();
        long r0 = this.mHandle;
        if (r0 != 0) goto L6;
    L4:
        this.mWriteLock.unlock();
        return;
    L6:
        _cancelUpload(r0);
        goto L4
    }

    public int checkNet(int r3, int r4) {
        Log.e("ttmn", "checketNet");
        TTVideoUploaderListener r2 = this.mListener;
        if (r2 != null) goto L7;
        return 1;
    L7:
        return r2.videoUploadCheckNetState(r3, r4);
    }

    public void close() {
        close(0);
    }

    public void close(int r5) {
        this.mWriteLock.lock();
    L16:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L4:
        if (this.mHandle == 0) goto L14;
        String r0 = getDNSIP();     // Catch: Throwable -> L16
        if (r0 != null) goto L8;
    L10:
        String r1 = _close(this.mHandle, r5);     // Catch: Throwable -> L16
        if (r5 == 0) goto L13;
        addLogToManager(r1);     // Catch: Throwable -> L16
    L13:
        this.mHandle = 0;     // Catch: Throwable -> L16
        this.mState = 5;     // Catch: Throwable -> L16
        this.mHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L16
        goto L14
    L8:
        if (r0.isEmpty() == true) goto L10;
        setStringValue(75, r0);     // Catch: Throwable -> L16
    L14:
        this.mWriteLock.unlock();
    }

    public String getDNSIP() {
        return TTUploadUtil.getDNSServerIP();
    }

    public String getStringFromExtern(int r1) {
        TTVideoUploaderListener r0 = this.mListener;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getStringFromExtern(r1);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r6) {
        int r0 = r6.what;
        Object r7 = r6.obj;
        if ((r7 instanceof LogInfo) == false) goto L6;
        LogInfo r8 = (LogInfo) r7;
        onLogInfoSync(r0, r8.getCode(), r8.getInfo());
        return true;
    L6:
        TTVideoUploaderListener r5 = this.mListener;
        if (r5 != null) goto L9;
        return true;
    L9:
        TTVideoInfo r9 = (TTVideoInfo) r7;
        if (r9 == null) goto L12;
        long r3 = r9.mProgress;
    L13:
        r5.onNotify(r0, r3, r9);
        return true;
    L12:
        r3 = 0;
        goto L13
    }

    public void onLogInfo(int r3, int r4, String r5) {
        if (this.mState == 1) goto L5;
        return;
    L5:
        LogInfo r0 = new LogInfo(r4, r5);
        Message r2 = this.mHandler.obtainMessage();
        r2.what = r3;
        r2.obj = r0;
        r2.sendToTarget();
    }

    public void onLogInfoSync(int r5, int r6, String r7) {
        if (r5 != 102) goto L15;
        if (TextUtils.isEmpty(r7) == true) goto L15;
        this.mHeadersLock.lock();     // Catch: Throwable -> L11
        if (this.headerIndex < 20) goto L9;
        this.headerIndex = 0;     // Catch: Throwable -> L11
    L9:
        String[] r8 = this.mHeaders;     // Catch: Throwable -> L11
        int r9 = this.headerIndex;     // Catch: Throwable -> L11
        r8[r9] = r7;     // Catch: Throwable -> L11
        this.headerIndex = r9 + 1;     // Catch: Throwable -> L11
        this.mHeadersLock.unlock();
        return;
    L11:
        th = move-exception;
        this.mHeadersLock.unlock();
        throw th;
    L15:
        if (r5 != 104) goto L35;
        if (this.mAbstractListener == null) goto L77;
        Map<String, String> r10 = new HashMap(20);
        JSONObject r0 = new JSONObject(r7);     // Catch: JSONException -> L30
        JSONObject r11 = this.mJsonInfo;     // Catch: JSONException -> L28
        if (r11 == null) goto L26;
        Iterator<String> r12 = r11.keys();     // Catch: JSONException -> L28
    L24:
        if (r12.hasNext() == false) goto L26;
        String r13 = r12.next();     // Catch: JSONException -> L28
        r0.put(r13, this.mJsonInfo.get(r13));     // Catch: JSONException -> L28
    L26:
        r10 = TTUploadUtil.jsonToHashMap(r0);     // Catch: JSONException -> L28
    L33:
        this.mAbstractListener.onEventLog(r0);
        this.mAbstractListener.onEventLogMap(r10);
        return;
    L28:
        JSONException e2 = e;
    L32:
        e2.printStackTrace();
    L30:
        e = move-exception;
        r0 = null;
        e2 = e;
        goto L32
    L77:
        return;
    L35:
        if (r5 != 105) goto L40;
        TTVideoUploaderAbstractListener r4 = this.mAbstractListener;
        if (r4 == null) goto L79;
        r4.onSpeedVidContext(0, r6, r7);
        return;
    L79:
        return;
    L40:
        if (r5 != 106) goto L45;
        TTVideoUploaderAbstractListener r14 = this.mAbstractListener;
        if (r14 == null) goto L81;
        r14.onSpeedVidContext(1, r6, r7);
        return;
    L81:
        return;
    L45:
        if (r5 != 110) goto L51;
        TTVideoUploaderAbstractListener r15 = this.mAbstractListener;
        if (r15 == null) goto L83;
        int r16 = 2;
    L49:
        r15.onSpeedVidContext(r16, r6, r7);
        return;
    L83:
        return;
    L51:
        if (r5 != 111) goto L56;
        r15 = this.mAbstractListener;
        if (r15 == null) goto L85;
        r16 = 3;
        goto L49
    L85:
        return;
    L56:
        if (r5 != 112) goto L61;
        r15 = this.mAbstractListener;
        if (r15 == null) goto L86;
        r16 = 4;
        goto L49
    L86:
        return;
    L61:
        if (r5 != 103) goto L65;
        long r1 = new Date().getTime() / 1000;
        TTVideoUploaderListener r2 = this.mListener;
        if (r2 == null) goto L65;
        r2.onUploadVideoStage(r6, r1);
    L65:
        TTVideoUploaderListener r17 = this.mListener;
        if (r17 == null) goto L87;
        r17.onLog(r5, r6, r7);
        return;
    }

    public void onNotify(int r27, long r28, int r30) {
        if (this.mState == 1) goto L5;
        return;
    L5:
        TTVideoInfo r2 = null;
        if (r27 == 0) goto L29;
        if (r27 != 1) goto L9;
        r2 = new TTVideoInfo(null, null, null, r28, null, null);
    L39:
        Message r0 = this.mHandler.obtainMessage();
        r0.what = r27;
        r0.obj = r2;
        r0.sendToTarget();
        return;
    L9:
        if (r27 == 2) goto L22;
        if (r27 != 3) goto L12;
        addLogToManager(_getStringValue(this.mHandle, 100));
        r2 = new TTVideoInfo(null, null, null, r28, _getStringValue(this.mHandle, 14), null);
        goto L39
    L12:
        if (r27 != 105) goto L14;
        r2 = new TTVideoInfo(null, null, null, r28, _getStringValue(this.mHandle, 14), null);
        goto L39
    L14:
        if (r27 != 106) goto L16;
        r2 = new TTVideoInfo(null, null, null, r28, _getStringValue(this.mHandle, 14), null);
        this.mState = 2;
        goto L39
    L16:
        if (r27 != 108) goto L39;
        r2 = new TTVideoInfo(null, null, null, r28, _getStringValue(this.mHandle, 14), null);
        goto L39
    L22:
        String r3 = getDNSIP();
        if (r3 != null) goto L25;
    L27:
        String r4 = _getStringValue(this.mHandle, 100);
        TTVideoInfo r5 = new TTVideoInfo(null, null, null, r28, _getStringValue(this.mHandle, 14), null);
        addLogToManager(r4);
        this.mState = 2;
        r2 = r5;
        goto L39
    L25:
        if (r3.isEmpty() == true) goto L27;
        setStringValue(75, r3);
        goto L27
    L29:
        this.mEndTime = System.currentTimeMillis();
        String r10 = _getStringValue(this.mHandle, 10);
        String r11 = _getStringValue(this.mHandle, 11);
        String r12 = _getStringValue(this.mHandle, 12);
        String r15 = _getStringValue(this.mHandle, KeyIsGetTosKey);
        String r17 = _getStringValue(this.mHandle, 51);
        String r18 = _getStringValue(this.mHandle, 50);
        String r19 = _getStringValue(this.mHandle, 52);
        String r20 = _getStringValue(this.mHandle, 53);
        String r23 = _getStringValue(this.mHandle, 57);
        String r24 = _getStringValue(this.mHandle, 58);
        String r25 = _getStringValue(this.mHandle, 59);
        String r16 = _getStringValue(this.mHandle, 68);
        if (this.currentType != 1) goto L32;
        r2 = new TTVideoInfo(r17, r18, r19, r20, r28, r23, r24, r25);
    L33:
        String r6 = getDNSIP();
        if (r6 != null) goto L36;
    L38:
        r2.mLog = addLogToManager(_getStringValue(this.mHandle, 100));
        this.mState = 3;
        goto L39
    L36:
        if (r6.isEmpty() == true) goto L38;
        setStringValue(75, r6);
        goto L38
    L32:
        r2 = new TTVideoInfo(r10, r11, r12, r28, r15, r16);
        goto L33
    }

    public void setAbstractListener(TTVideoUploaderAbstractListener r1) {
        this.mAbstractListener = r1;
    }

    public void setAliveMaxFailTime(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 22, r5);
        return;
    L9:
        return;
    }

    public void setAuthorization(String r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 == null) goto L9;
        _setStringValue(r0, 15, r5);
        return;
    L9:
        return;
    }

    public void setConfig(TreeMap<String, Object> r5) {
        if (this.mHandle == 0) goto L10;
        if (r5 == null) goto L12;
        String r6 = TTUploadUtil.mapToString(r5);
        if (r6 == null) goto L11;
        setStringValue(56, r6);
        return;
    L11:
        return;
    L12:
        return;
    }

    public void setContext(String r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 == null) goto L9;
        _setContext(r0, r5);
        return;
    L9:
        return;
    }

    public void setCurrentType(int r1) {
        this.currentType = r1;
    }

    public void setCustomConfig(TreeMap<String, Object> r5) {
        if (this.mHandle == 0) goto L21;
        if (r5 == null) goto L22;
        JSONObject r6 = TTUploadUtil.mapToJSON(r5);
        if (r6 != null) goto L9;
        return;
    L9:
        JSONObject r0 = new JSONObject();
        r0.put("custom_config", r6);     // Catch: Throwable -> L15
        String r7 = r0.toString();     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r7) == true) goto L20;
        setStringValue(63, r7);
        return;
    L20:
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    L22:
        return;
    }

    public void setEnableBigFile(int r5) {
        if (this.mHandle == 0) goto L8;
        if (r5 < 0) goto L9;
        Log.e("ttmn", "TTVideoUploader-222222!");
        _setIntValue(this.mHandle, 83, r5);
        return;
    L9:
        return;
    }

    public void setEnableExternDNS(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L10;
        if (r5 != 0) goto L6;
    L8:
        _setIntValue(r0, 21, r5);
        return;
    L6:
        if (r5 == 1) goto L8;
        return;
    }

    public void setEnableExternNet(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 26, r5);
        return;
    L9:
        return;
    }

    public void setEnableFiletryHttps(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L10;
        if (r5 != 0) goto L6;
    L8:
        _setIntValue(r0, 25, r5);
        return;
    L6:
        if (r5 == 1) goto L8;
        return;
    }

    public void setEnableHttps(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 19, r5);
        return;
    L9:
        return;
    }

    public void setEnableKeepAlive(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L10;
        if (r5 != 0) goto L6;
    L8:
        _setIntValue(r0, 20, r5);
        return;
    L6:
        if (r5 == 1) goto L8;
        return;
    }

    public void setEnableLinkTurbo(int r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 82, r5);
    }

    public void setEnableLogCallBack(boolean r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L6;
        return;
    L6:
        if (r5 == false) goto L8;
        int r6 = 1;
    L9:
        _setIntValue(r0, 78, r6);
        return;
    L8:
        r6 = 0;
        goto L9
    }

    public void setEnableMutiTask(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L10;
        if (r5 != 0) goto L6;
    L8:
        _setIntValue(r0, 29, r5);
        return;
    L6:
        if (r5 == 1) goto L8;
        return;
    }

    public void setEnablePostMethod(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L10;
        if (r5 != 0) goto L6;
    L8:
        _setIntValue(r0, 23, r5);
        return;
    L6:
        if (r5 == 1) goto L8;
        return;
    }

    public void setEnableQuic(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L10;
        if (r5 != 0) goto L6;
    L8:
        _setIntValue(r0, 28, r5);
        return;
    L6:
        if (r5 == 1) goto L8;
        return;
    }

    public void setEnableServerHost(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L10;
        if (r5 != 0) goto L6;
    L8:
        _setIntValue(r0, 17, r5);
        return;
    L6:
        if (r5 == 1) goto L8;
        return;
    }

    public void setEnableUpHost(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L10;
        if (r5 != 0) goto L6;
    L8:
        _setIntValue(r0, 18, r5);
        return;
    L6:
        if (r5 == 1) goto L8;
        return;
    }

    public void setEvStateEnable(boolean r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 79, r5 ? 1 : 0);
    }

    public void setExternFileReader(TTExternFileReader r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 == null) goto L9;
        _setObject(r0, 200, r5);
        return;
    L9:
        return;
    }

    public void setExternLogInfo(JSONObject r1) {
        this.mJsonInfo = r1;
    }

    public void setExternMinSIze(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 <= 0) goto L9;
        _setIntValue(r0, 77, r5);
        return;
    L9:
        return;
    }

    public void setExternNetInfo(String r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 == null) goto L9;
        _setStringValue(r0, 41, r5);
        return;
    L9:
        return;
    }

    public void setFileRetryCount(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 6, r5);
        return;
    L9:
        return;
    }

    public void setFileUploadDomain(String r2) {
        setStringValue(2, r2);
    }

    public void setHandler(Handler r1) {
        this.mHandler = r1;
    }

    public void setListener(TTVideoUploaderListener r1) {
        this.mListener = r1;
    }

    public void setMaxFailTime(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 13, r5);
        return;
    L9:
        return;
    }

    public void setMediaDataReader(TTMediaDataReader r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 == null) goto L9;
        _setObject(r0, 201, r5);
        return;
    L9:
        return;
    }

    public void setNetworkRoutMode(int r5, int r6) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 86, r5);
        _setIntValue(this.mHandle, 87, r6);
        Log.v("ttmn", "weight" + r6);
    }

    public void setNewHttpProxyLoader(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L10;
        if (r5 != 0) goto L6;
    L8:
        _setIntValue(r0, 40, r5);
        return;
    L6:
        if (r5 == 1) goto L8;
        return;
    }

    public void setOpenBoe(boolean r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L6;
        return;
    L6:
        if (r5 == false) goto L8;
        int r6 = 1;
    L9:
        _setIntValue(r0, 67, r6);
        return;
    L8:
        r6 = 0;
        goto L9
    }

    public void setOpenResume(boolean r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L6;
        return;
    L6:
        if (r5 == false) goto L8;
        int r6 = 1;
    L9:
        _setIntValue(r0, 70, r6);
        return;
    L8:
        r6 = 0;
        goto L9
    }

    public void setPathName(String r2) {
        setStringValue(0, r2);
    }

    public void setPolicyParams(TreeMap<String, Object> r5) {
        if (this.mHandle == 0) goto L10;
        if (r5 == null) goto L12;
        String r6 = TTUploadUtil.mapToString(r5);
        if (TextUtils.isEmpty(r6) == true) goto L11;
        setStringValue(55, r6);
        return;
    L11:
        return;
    L12:
        return;
    }

    public void setPoster(float r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (r5 < 0.0f) goto L10;
        _setPoster(r0, r5);
        return;
    }

    public void setPreUploadEncryptionMode(int r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 74, r5);
    }

    public void setPrivateVideo(boolean r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L6;
        return;
    L6:
        if (r5 == false) goto L8;
        int r6 = 1;
    L9:
        _setIntValue(r0, 88, r6);
        return;
    L8:
        r6 = 0;
        goto L9
    }

    public void setResponeTimeOut(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 76, r5);
        return;
    L9:
        return;
    }

    public void setScenesTag(String r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 == null) goto L9;
        _setStringValue(r0, 85, r5);
        return;
    L9:
        return;
    }

    public void setServerParameter(String r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 == null) goto L9;
        _setStringValue(r0, 16, r5);
        return;
    L9:
        return;
    }

    public void setSliceReTryCount(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 5, r5);
        return;
    L9:
        return;
    }

    public void setSliceSize(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 8, r5);
        return;
    L9:
        return;
    }

    public void setSliceTimeout(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 7, r5);
        return;
    L9:
        return;
    }

    public void setSocketNum(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 9, r5);
        return;
    L9:
        return;
    }

    public void setStringValue(int r5, String r6) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r6 == null) goto L9;
        _setStringValue(r0, r5, r6);
        return;
    L9:
        return;
    }

    public void setTTExternLoader(TTExternNetLoader r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 == null) goto L9;
        _setObject(r0, 27, r5);
        return;
    L9:
        return;
    }

    public void setTcpOpenTimeOutMilliSec(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 24, r5);
        return;
    L9:
        return;
    }

    public void setTestSpeed(boolean r5) {
        if (this.mHandle != 0) goto L5;
        return;
    L5:
        this.mIsTestSpeed = r5;
    }

    public void setTotalTimeout(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 89, r5);
        return;
    L9:
        return;
    }

    public void setTraceIDConfig(Map<Object, Object> r5) {
        if (r5.get(69) == null) goto L12;
        if ((r5.get(69) instanceof String) == false) goto L12;
        String r6 = (String) r5.get(69);
        if (r6 != null) goto L9;
        return;
    L9:
        if (r6.isEmpty() == true) goto L20;
        setTraceId(r6);
        return;
    L20:
        return;
    L12:
        if (r5.get(66) != null) goto L14;
        return;
    L14:
        if ((r5.get(66) instanceof Long) == false) goto L23;
        long r0 = ((Long) r5.get(66)).longValue();
        if (r0 <= 0) goto L24;
        setDeviceID(r0);
        return;
    L24:
        return;
    }

    public void setTranTimeOutUnit(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 <= 0) goto L9;
        _setIntValue(r0, 64, r5);
        return;
    L9:
        return;
    }

    public void setUploadCookie(String r2) {
        setStringValue(4, r2);
    }

    public void setUserKey(String r2) {
        setStringValue(1, r2);
    }

    public void setUserRefrence(String r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 == null) goto L9;
        _setStringValue(r0, 62, r5);
        return;
    L9:
        return;
    }

    public void setVideoObjectType(String r5) {
        if (this.mHandle == 0) goto L10;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.equals("") == true) goto L12;
        setStringValue(54, r5);
        return;
    L12:
        return;
    }

    public void setVideoUploadDomain(String r2) {
        setStringValue(3, r2);
    }

    public void start() {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (this.mHandle == 0) goto L6;
        this.mState = 1;     // Catch: Throwable -> L8
        this.mSartTime = System.currentTimeMillis();     // Catch: Throwable -> L8
        _start(this.mHandle);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    public void startSpeedTest(int r5, int r6, int r7) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (this.mHandle == 0) goto L6;
        this.mState = 1;     // Catch: Throwable -> L8
        this.mSartTime = System.currentTimeMillis();     // Catch: Throwable -> L8
        _startSpeedTest(this.mHandle, r5, r6, r7);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    public void stop() {
        this.mWriteLock.lock();
    L13:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L4:
        if (this.mHandle == 0) goto L11;
        String r0 = getDNSIP();     // Catch: Throwable -> L13
        if (r0 != null) goto L8;
    L10:
        addLogToManager(_stop(this.mHandle));     // Catch: Throwable -> L13
        this.mState = 4;     // Catch: Throwable -> L13
        goto L11
    L8:
        if (r0.isEmpty() == true) goto L10;
        setStringValue(75, r0);     // Catch: Throwable -> L13
    L11:
        this.mWriteLock.unlock();
    }

    public void stopSpeedTest() {
        this.mReadLock.lock();
        long r0 = this.mHandle;
        if (r0 != 0) goto L6;
    L4:
        this.mReadLock.unlock();
        return;
    L6:
        _stopSpeedTest(r0);
        goto L4
    }

    public int switchNetType(int r2) {
        TTVideoUploaderAbstractListener r1 = this.mAbstractListener;
        if (r1 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r1.switchNetType(r2) == false) goto L8;
        return 1;
    }
}
