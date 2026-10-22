package com.ss.ttuploader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.ss.ttuploader.net.TTUploadDNSParser;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTImageUploader implements Handler.Callback {
    public static final int FileUploadProcessEncryption = 1;
    public static final int FileUploadProcessMediaInfo = 2;
    public static final int FileUploadProcessTypeImageX = 4;
    public static final int FileUploadProcessTypeOriginal = 0;
    public static final int FileUploadProcessTypeUri = 3;
    public static final int IsClose = 5;
    public static final int IsComplete = 3;
    private static boolean IsErrored = false;
    public static final int IsFail = 2;
    public static final int IsInit = 0;
    public static final int IsStart = 1;
    public static final int IsStop = 4;
    public static final int KeIsAuthorization = 15;
    public static final int KeIsGetRedirectLocation = 14;
    public static final int KeyIsApplyAuth = 83;
    public static final int KeyIsCommitAuth = 84;
    public static final int KeyIsEnableHttps = 19;
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
    public static final int KeyIsGetVersion = 53;
    public static final int KeyIsGetVideoId = 10;
    public static final int KeyIsMaxFailTime = 13;
    public static final int KeyIsMediaDataReader = 201;
    public static final int KeyIsMetaInfoParams = 61;
    public static final int KeyIsObjectType = 54;
    public static final int KeyIsPathName = 0;
    public static final int KeyIsPlainObjectId = 59;
    public static final int KeyIsPolicyParams = 55;
    public static final int KeyIsPreUpload = 80;
    public static final int KeyIsPreUploadEncryptionMode = 74;
    public static final int KeyIsScenesTag = 85;
    public static final int KeyIsServerParameter = 16;
    public static final int KeyIsSetCustomConfig = 63;
    public static final int KeyIsSetDeviceID = 66;
    public static final int KeyIsSetOpenBoe = 67;
    public static final int KeyIsSetProcessAction = 65;
    public static final int KeyIsSetReaderType = 81;
    public static final int KeyIsSetTraceId = 69;
    public static final int KeyIsSetTranTimeOutUnit = 64;
    public static final int KeyIsSetfileNum = 71;
    public static final int KeyIsSliceRetryCount = 5;
    public static final int KeyIsSliceSize = 8;
    public static final int KeyIsSliceTimeout = 7;
    public static final int KeyIsSocketNum = 9;
    public static final int KeyIsSourceMd5 = 57;
    public static final int KeyIsUploadCookie = 4;
    public static final int KeyIsUserName = 1;
    public static final int KeyIsVideoUploadDomain = 3;
    public static final int MsgIsComplete = 0;
    public static final int MsgIsFail = 2;
    public static final int MsgIsSingleImageComplete = 3;
    public static final int MsgIsSingleImageFail = 4;
    public static final int MsgIsUpdateProgress = 1;
    public static final int TTUploadReaderTypeCallBack = 1;
    public static final int TTUploadReaderTypeFilePath = 0;
    public static final int TTUploadReaderTypeMedia = 2;
    public static final int keyIsConfigString = 56;
    int currentType;
    private TTImageUploaderAbstractListener mAbstractListener;
    private long mEndTime;
    private long mHandle;
    private Handler mHandler;
    private int mImageNum;
    private TTImageUploaderListener mListener;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private final ReentrantReadWriteLock mReadWritedLock;
    private long mSartTime;
    private int mState;
    private final ReentrantReadWriteLock.WriteLock mWriteLock;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    static {
        if (TTUploadUtil.initInternal() == true) goto L6;
        IsErrored = true;
        return;
    }

    public TTImageUploader() {
        this.mState = -1;
        this.mImageNum = 0;
        this.currentType = 0;
        this.mHandler = null;
        this.mReadWritedLock = new ReentrantReadWriteLock();
        this.mListener = null;
        this.mAbstractListener = null;
        if (IsErrored == false) goto L19;
        TTUploadUtil.initInternal();
    L19:
        this.mHandle = _imageUploaderCreate(0);     // Catch: Throwable -> L8
    L10:
        if (this.mHandle == 0) goto L18;
        if (Looper.myLooper() == null) goto L14;
        Handler r1 = new Handler(this);
    L15:
        this.mHandler = r1;
        this.mReadLock = this.mReadWritedLock.readLock();
        this.mWriteLock = this.mReadWritedLock.writeLock();
        this.mState = 0;
        getDNSIP();
        return;
    L14:
        r1 = new Handler(Looper.getMainLooper(), this);
        goto L15
    L18:
        throw new Exception("create native uploader fail");
    L8:
        this.mHandle = 0;
        goto L10
    }

    public TTImageUploader(int r6) {
        this.mState = -1;
        this.mImageNum = 0;
        this.currentType = 0;
        this.mHandler = null;
        this.mReadWritedLock = new ReentrantReadWriteLock();
        this.mListener = null;
        this.mAbstractListener = null;
        setCurrentType(r6);
        this.mHandle = _imageUploaderCreate(r6);     // Catch: Throwable -> L5
    L8:
        if (this.mHandle == 0) goto L16;
        if (Looper.myLooper() == null) goto L12;
        Handler r7 = new Handler(this);
    L13:
        this.mHandler = r7;
        this.mReadLock = this.mReadWritedLock.readLock();
        this.mWriteLock = this.mReadWritedLock.writeLock();
        this.mState = 0;
        getDNSIP();
        return;
    L12:
        r7 = new Handler(Looper.getMainLooper(), this);
        goto L13
    L16:
        throw new Exception("create native uploader fail");
    L5:
        th = move-exception;
        this.mHandle = 0;
        Log.e("ttmn", th.toString());
        goto L8
    }

    private static native void _allowUpload(long r0);

    private static native long _getLongValue(long r0, int r2);

    private static native void _imageUploaderClose(long r0);

    private final native long _imageUploaderCreate(int r1);

    private static native String _imageUploaderGetImageMetaInfo(long r0, int r2);

    private static native String _imageUploaderGetImageUri(long r0, int r2);

    private static native String _imageUploaderGetStringValue(long r0, int r2);

    private static native void _imageUploaderSetFileName(long r0, int r2, String[] r3);

    private static native void _imageUploaderSetFilePath(long r0, int r2, String[] r3);

    private static native void _imageUploaderSetIntValue(long r0, int r2, int r3);

    private static native void _imageUploaderSetStringValue(long r0, int r2, String r3);

    private static native void _imageUploaderStart(long r0);

    private static native String _imageUploaderStop(long r0);

    private static native void _setInt64Value(long r0, int r2, long r3);

    private static native void _setObject(long r0, int r2, Object r3);

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
        _imageUploaderSetStringValue(this.mHandle, 69, r5);
        return;
    L12:
        return;
    }

    public void addLogToManager(String r2) {
        JSONObject r1 = new JSONObject(r2);     // Catch: Exception -> L4
        r1.put("dns_version", TTUploadResolver.mDNSVersion);     // Catch: Exception -> L4
        r1.put("main_dns_type", TTUploadDNSParser.mGlobalMainType);     // Catch: Exception -> L4
        r1.put("main_back_type", TTUploadDNSParser.mGlobalBackType);     // Catch: Exception -> L4
        r1.put("back_delayed_time", TTUploadDNSParser.mGlobalBackUpDelayedTime);     // Catch: Exception -> L4
        r1.put("expired_time", TTUploadDNSParser.mGlobalDefaultExpiredTime);     // Catch: Exception -> L4
    L5:
        UploadEventManager.instance.addImageEvent(r1);
        return;
    L4:
        r1 = null;
        goto L5
    }

    public void allowContinueUpload() {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _allowUpload(r0);
    }

    public int checkNet(int r1, int r2) {
        TTImageUploaderAbstractListener r0 = this.mAbstractListener;
        if (r0 != null) goto L7;
        return -2;
    L7:
        return r0.imageUploadCheckNetState(r1, r2);
    }

    public void close() {
        this.mWriteLock.lock();
        long r0 = this.mHandle;     // Catch: Throwable -> L8
        if (r0 == 0) goto L6;
        _imageUploaderClose(r0);     // Catch: Throwable -> L8
        this.mHandle = 0;     // Catch: Throwable -> L8
        this.mState = 5;     // Catch: Throwable -> L8
        this.mHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L8
    L6:
        this.mWriteLock.unlock();
        return;
    L8:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public void extraParams(JSONObject r5) {
        if (this.mHandle == 0) goto L10;
        if (r5 == null) goto L12;
        String r6 = r5.toString();
        if (r6 == null) goto L11;
        setStringValue(61, r6);
        return;
    L11:
        return;
    L12:
        return;
    }

    public String getDNSIP() {
        return TTUploadUtil.getDNSServerIP();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r5) {
        int r0 = r5.what;
        TTImageUploaderListener r4 = this.mListener;
        if (r4 != null) goto L5;
        return true;
    L5:
        TTImageInfo r6 = (TTImageInfo) r5.obj;
        if (r6 == null) goto L8;
        long r2 = r6.mProgress;
    L9:
        r4.onNotify(r0, r2, r6);
        return true;
    L8:
        r2 = 0;
        goto L9
    }

    public void onLogInfo(int r1, int r2, String r3) {
        TTImageUploaderListener r0 = this.mListener;
    }

    public void onNotify(int r18, long r19, int r21) {
        if (this.mState == 1) goto L5;
        return;
    L5:
        TTImageInfo r3 = null;
        int r14 = (int) r19;
        if (r18 == 0) goto L26;
        if (r18 != 1) goto L9;
        r3 = new TTImageInfo(null, r21, r14, null);
    L32:
        Message r0 = this.mHandler.obtainMessage();
        r0.what = r18;
        r0.obj = r3;
        r0.sendToTarget();
        return;
    L9:
        if (r18 == 2) goto L19;
        if (r18 != 3) goto L12;
        this.mEndTime = System.currentTimeMillis();
        String r6 = _imageUploaderGetStringValue(this.mHandle, 51);
        String r7 = _imageUploaderGetStringValue(this.mHandle, 50);
        String r8 = _imageUploaderGetStringValue(this.mHandle, 52);
        String r9 = _imageUploaderGetStringValue(this.mHandle, 53);
        String r11 = _imageUploaderGetStringValue(this.mHandle, 57);
        String r12 = _imageUploaderGetStringValue(this.mHandle, 58);
        String r2 = _imageUploaderGetImageUri(this.mHandle, r14);
        String r4 = _imageUploaderGetImageMetaInfo(this.mHandle, r14);
        String r13 = _imageUploaderGetStringValue(this.mHandle, 59);
        if (this.currentType != 1) goto L18;
        r3 = new TTImageInfo(r6, r7, r8, r9, r2, r11, r12, r13, 0, r14);
        goto L32
    L18:
        r3 = new TTImageInfo(r2, 0, r14, r4);
        goto L32
    L12:
        if (r18 != 4) goto L32;
        r3 = new TTImageInfo(null, r21, r14, null);
        goto L32
    L19:
        String r5 = getDNSIP();
        if (r5 != null) goto L22;
    L24:
        addLogToManager(_imageUploaderGetStringValue(this.mHandle, 100));
        this.mState = 2;
        goto L32
    L22:
        if (r5.isEmpty() == true) goto L24;
        setStringValue(75, r5);
        goto L24
    L26:
        String r10 = getDNSIP();
        if (r10 != null) goto L29;
    L31:
        addLogToManager(_imageUploaderGetStringValue(this.mHandle, 100));
        this.mState = 3;
        goto L32
    L29:
        if (r10.isEmpty() == true) goto L31;
        setStringValue(75, r10);
        goto L31
    }

    public void setAbstractListener(TTImageUploaderAbstractListener r1) {
        this.mAbstractListener = r1;
    }

    public void setAuthorization(String r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 == null) goto L9;
        _imageUploaderSetStringValue(r0, 15, r5);
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

    public void setEnableHttps(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L10;
        if (r5 != 0) goto L6;
    L8:
        _imageUploaderSetIntValue(r0, 19, r5);
        return;
    L6:
        if (r5 == 1) goto L8;
        return;
    }

    public void setFileName(int r5, String[] r6) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L9;
        if (r6 == null) goto L10;
        if (r5 <= 0) goto L11;
        _imageUploaderSetFileName(r0, r5, r6);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setFilePath(int r5, String[] r6) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L9;
        if (r6 == null) goto L10;
        if (r5 <= 0) goto L11;
        this.mImageNum = r5;
        _imageUploaderSetFilePath(r0, r5, r6);
        _imageUploaderSetIntValue(this.mHandle, 81, 0);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setFileRetryCount(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _imageUploaderSetIntValue(r0, 6, r5);
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

    public void setImageUploadDomain(String r2) {
        setStringValue(3, r2);
    }

    public void setListener(TTImageUploaderListener r1) {
        this.mListener = r1;
    }

    public void setMaxFailTime(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _imageUploaderSetIntValue(r0, 13, r5);
        return;
    L9:
        return;
    }

    public void setMediaDataReader(TTMediaDataReader r5, int r6) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L9;
        if (r5 == null) goto L10;
        if (r6 <= 0) goto L11;
        _imageUploaderSetIntValue(r0, 71, r6);
        _setObject(this.mHandle, 201, r5);
        _imageUploaderSetIntValue(this.mHandle, 81, 2);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setMediaDataReader(TTMediaDataReader r5, int r6, int r7) {
        if (this.mHandle == 0) goto L9;
        if (r5 == null) goto L10;
        if (r6 <= 0) goto L11;
        setMediaDataReader(r5, r6);
        _imageUploaderSetIntValue(this.mHandle, 81, r7);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setObjectType(String r2) {
        setStringValue(54, r2);
    }

    public void setOpenBoe(boolean r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L6;
        return;
    L6:
        if (r5 == false) goto L8;
        int r6 = 1;
    L9:
        _imageUploaderSetIntValue(r0, 67, r6);
        return;
    L8:
        r6 = 0;
        goto L9
    }

    public void setPolicyParams(TreeMap<String, Object> r5) {
        if (this.mHandle == 0) goto L10;
        if (r5 == null) goto L12;
        String r6 = TTUploadUtil.mapToString(r5);
        if (r6 == null) goto L11;
        setStringValue(55, r6);
        return;
    L11:
        return;
    L12:
        return;
    }

    public void setPreUpload(boolean r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _imageUploaderSetIntValue(r0, 80, r5 ? 1 : 0);
    }

    public void setPreheatUploader(boolean r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _imageUploaderSetIntValue(r0, 74, r5 ? 1 : 0);
    }

    public void setProcessAction(String r2) {
        setStringValue(65, r2);
    }

    public void setScenesTag(String r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 == null) goto L9;
        _imageUploaderSetStringValue(r0, 85, r5);
        return;
    L9:
        return;
    }

    public void setServerParameter(String r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 == null) goto L9;
        _imageUploaderSetStringValue(r0, 16, r5);
        return;
    L9:
        return;
    }

    public void setSliceReTryCount(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _imageUploaderSetIntValue(r0, 5, r5);
        return;
    L9:
        return;
    }

    public void setSliceSize(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _imageUploaderSetIntValue(r0, 8, r5);
        return;
    L9:
        return;
    }

    public void setSliceTimeout(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _imageUploaderSetIntValue(r0, 7, r5);
        return;
    L9:
        return;
    }

    public void setSocketNum(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _imageUploaderSetIntValue(r0, 9, r5);
        return;
    L9:
        return;
    }

    public void setStringValue(int r5, String r6) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r6 == null) goto L9;
        _imageUploaderSetStringValue(r0, r5, r6);
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
        _imageUploaderSetIntValue(r0, 64, r5);
        return;
    L9:
        return;
    }

    public void setUploadCookie(String r2) {
        setStringValue(4, r2);
    }

    public void setUploadToken(String r4) {
        Log.e("ttmn", r4);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isEmpty() == false) goto L20;
        return;
    L20:
        JSONObject r5 = new JSONObject(new String(Base64.decode(r4.getBytes(), 2)));     // Catch: JSONException -> L17
        String r1 = r5.getString("ApplyUploadToken");     // Catch: JSONException -> L17
        String r6 = r5.getString("CommitUploadToken");     // Catch: JSONException -> L17
        if (r1 != null) goto L10;
    L12:
        if (r6 != null) goto L14;
        return;
    L14:
        if (r6.isEmpty() == true) goto L25;
        setStringValue(84, r6);     // Catch: JSONException -> L17
        return;
    L25:
        return;
    L10:
        if (r1.isEmpty() == true) goto L12;
        setStringValue(83, r1);     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        Log.e("ttmn", "uploadToken is encode json error !!!");
        e.printStackTrace();
    }

    public void setUserKey(String r2) {
        setStringValue(1, r2);
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
        _imageUploaderStart(this.mHandle);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    public void stop() {
        this.mWriteLock.lock();
        long r0 = this.mHandle;     // Catch: Throwable -> L8
        if (r0 == 0) goto L6;
        addLogToManager(_imageUploaderStop(r0));     // Catch: Throwable -> L8
        this.mState = 4;     // Catch: Throwable -> L8
    L6:
        this.mWriteLock.unlock();
        return;
    L8:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }
}
