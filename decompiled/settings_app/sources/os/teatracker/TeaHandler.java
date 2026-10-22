package os.teatracker;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.GlobalProxyLancet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class TeaHandler extends BaseHandler implements IBdInstall.InstallCallBack {
    private static final int MSG_EVENT = 2;
    private static final int MSG_INIT = 1;
    private static final int MSG_QUIT = 4;
    private static final int MSG_SET_AB_SDK_VERSION = 5;
    private static final int MSG_SET_PRIVACY_POLICY_CONFIRMED = 6;
    private static final int MSG_SYS_EVENT = 7;
    private static final int MSG_TEA_SERVICE_CONNECTED = 3;
    private static final String TAG = "EventHandler";
    private static final Object sLock = null;
    private Class implClass;
    private String mAbSDKVersion;
    private ContentObserver mAppServiceObserver;
    private TeaAgent.AppStateListener mAppStateListener;
    private AppStateChangeReceiver mAppStateReceiver;
    private boolean mBdInstall;
    private volatile TeaConfig mConfig;
    private Context mContext;
    private String mDeviceId;
    private final WorkHandler mHandler;
    private String mInstallId;
    private Boolean mIsPrivacyPolicyConfirmed;
    private final List<WeakReference<TeaAgent.TeaListener>> mListeners;

    private static class WorkHandler extends Handler {
        private static final int MAX_CACHE_SIZE = 100;
        private final TeaServiceProxy.BindCallback mCallback;
        private volatile Context mContext;
        private List<TeaEvent> mEventsCache;
        private Map<String, Object> mGlobalParams;
        private final AtomicBoolean mInitDone;
        private final List<TeaEvent> mSysEventsCache;
        private TeaServiceProxy mTeaServiceProxy;

        WorkHandler(Looper looper) {
            super(looper);
            this.mEventsCache = new ArrayList();
            this.mSysEventsCache = new ArrayList();
            this.mInitDone = new AtomicBoolean(false);
            TeaServiceProxy.BindCallback r2 = new AnonymousClass1(this);
            this.mCallback = r2;
            TeaServiceProxy r0 = TeaServiceProxy.getTeaServiceProxy(this);
            this.mTeaServiceProxy = r0;
            r0.setBindCallback(r2);
        }

        public void setContext(Context context) {
            this.mContext = context;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                case 7: goto L5;
                default: goto L19;
            };
        L5:
            onEvent((TeaEvent) msg.obj, true);
            return;
        L6:
            setPrivacyPolicyConfirmed(((Boolean) msg.obj).booleanValue());
            return;
        L7:
            setAbSdkVersion((String) msg.obj);
            return;
        L8:
            onQuit();
            return;
        L9:
            onTeaServiceConnected();
            return;
        L10:
            onEvent((TeaEvent) msg.obj, false);
            return;
        L11:
            onInit((Map) msg.obj);
            return;
        }

        private void setAbSdkVersion(String abSdkVersion) {
            if (this.mInitDone.get() == true) goto L7;
            Log.i(TeaConfig.TAG, "setAbSdkVersion before init");
            return;
        L7:
            if (this.mTeaServiceProxy.isTeaServiceConnected() == false) goto L10;
            this.mTeaServiceProxy.setAbSdkVersion(abSdkVersion);
            return;
        }

        private void setPrivacyPolicyConfirmed(boolean confirmed) {
            if (this.mInitDone.get() == true) goto L7;
            Log.i(TeaConfig.TAG, "setPrivacyPolicyConfirmed before init");
            return;
        L7:
            if (this.mTeaServiceProxy.isTeaServiceConnected() == false) goto L10;
            this.mTeaServiceProxy.setPrivacyPolicyConfirmed(confirmed);
            return;
        }

        private void onInit(Map<String, Object> globalParams) {
            Log.i(TeaConfig.TAG, "TeaHandler onInit...");
            if (TeaUtil.isTrackerGranted(this.mContext) == true) goto L5;
        L7:
            this.mGlobalParams = globalParams;
            this.mInitDone.set(true);
            return;
        L5:
            if (this.mTeaServiceProxy.isTeaServiceConnected() == true) goto L7;
            this.mTeaServiceProxy.bindService(this.mContext);
            goto L7
        }

        private void onEvent(final TeaEvent teaData, boolean isSysEvent) {
            Log.i(TeaHandler.TAG, "onEvent: " + teaData.getEvent());
            if (teaData != null) goto L6;
            return;
        L6:
            if (this.mInitDone.get() == true) goto L8;
        L22:
            Log.i(TeaConfig.TAG, "onEvent before Init=" + this.mInitDone.get());
            cacheEvent(teaData, false, isSysEvent);
            return;
        L8:
            if (hasMessages(3) == true) goto L22;
            if (TeaUtil.isTrackerGranted(this.mContext) == true) goto L14;
            Log.i(TeaConfig.TAG, "mermaid app unGranted.");
            onQuit();
            return;
        L14:
            mergeParams(teaData);
            if (this.mTeaServiceProxy.isTeaServiceConnected() == false) goto L20;
            cacheEvent(teaData, true, isSysEvent);
            if (isSysEvent == false) goto L19;
            onEvent(this.mSysEventsCache, true);
            return;
        L19:
            onEvent(this.mEventsCache, false);
            return;
        L20:
            cacheEvent(teaData, false, isSysEvent);
            this.mTeaServiceProxy.bindService(this.mContext);
        }

        private void mergeParams(TeaEvent teaEvent) {
            if (teaEvent != null) goto L4;
            return;
        L4:
            JSONObject r0 = teaEvent.getJsonParams();
            if (r0 != null) goto L7;
            r0 = new JSONObject();
        L7:
            Map<String, Object> r1 = this.mGlobalParams;
            if (r1 != null) goto L26;
            return;
        L26:
            if (r1.isEmpty() == true) goto L31;
            Iterator<Map.Entry<String, Object>> r3 = this.mGlobalParams.entrySet().iterator();     // Catch: Throwable -> L17 JSONException -> L19
        L14:
            if (r3.hasNext() == false) goto L21;
            Map.Entry<String, Object> r2 = r3.next();     // Catch: Throwable -> L17 JSONException -> L19
            r0.put(r2.getKey(), r2.getValue());     // Catch: Throwable -> L17 JSONException -> L19
        L21:
            teaEvent.setJsonParams(r0);
            return;
        L19:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L17
            goto L21
        L31:
            return;
        L17:
            th = move-exception;
            teaEvent.setJsonParams(r0);
            throw th;
        }

        private void cacheEvent(TeaEvent teaEvent, boolean dontRemove, boolean isSysEvent) {
            if (teaEvent != null) goto L5;
            return;
        L5:
            if (isSysEvent == false) goto L12;
            if (this.mSysEventsCache.size() < 100) goto L10;
            if (dontRemove == true) goto L10;
            this.mSysEventsCache.remove(0);
        L10:
            this.mSysEventsCache.add(teaEvent);
            return;
        L12:
            if (this.mEventsCache.size() < 100) goto L15;
            if (dontRemove == true) goto L15;
            this.mEventsCache.remove(0);
        L15:
            this.mEventsCache.add(teaEvent);
        }

        private void onTeaServiceConnected() {
            if (this.mEventsCache.isEmpty() == false) goto L8;
            if (this.mSysEventsCache.isEmpty() == false) goto L8;
            return;
        L8:
            if (this.mTeaServiceProxy.isTeaServiceConnected() == false) goto L21;
            Iterator<TeaEvent> r0 = this.mEventsCache.iterator();
        L11:
            if (r0.hasNext() == false) goto L13;
            mergeParams(r0.next());
            goto L11
        L13:
            Iterator<TeaEvent> r1 = this.mSysEventsCache.iterator();
        L15:
            if (r1.hasNext() == false) goto L17;
            mergeParams(r1.next());
            goto L15
        L17:
            onEvent(this.mEventsCache, false);
            onEvent(this.mSysEventsCache, true);
            return;
        }

        private void onEvent(List<TeaEvent> teaEvents, boolean isSysEvent) {
            if (teaEvents != null) goto L4;
            return;
        L4:
            if (teaEvents.isEmpty() == false) goto L7;
            return;
        L7:
            if (this.mTeaServiceProxy.isTeaServiceConnected() == true) goto L9;
            this.mTeaServiceProxy.bindService(this.mContext);
            return;
        L9:
            if (this.mTeaServiceProxy.onEvent(teaEvents, isSysEvent) == false) goto L14;
            teaEvents.clear();
            return;
        }

        private void onQuit() {
            Log.i(TeaConfig.TAG, "TeaHandler onQuit...");
            List<TeaEvent> r0 = this.mEventsCache;
            if (r0 == null) goto L5;
            r0.clear();
            this.mEventsCache = null;
        L5:
            TeaServiceProxy r1 = this.mTeaServiceProxy;
            if (r1 == null) goto L8;
            r1.unbindService();
            this.mTeaServiceProxy.setBindCallback(null);
            this.mTeaServiceProxy = null;
        L8:
            this.mContext = null;
        }
    }

    static /* synthetic */ void access$000(TeaHandler r0) {
        r0.bdInstallRegister();
    }

    static /* synthetic */ Object access$100() {
        return sLock;
    }

    static /* synthetic */ List access$200(TeaHandler r0) {
        return r0.mListeners;
    }

    static {
        sLock = new Object();
    }

    @Override // os.teatracker.IBdInstall.InstallCallBack
    public void onGetDeviceId(final String did, final String iid) {
        this.mHandler.post(new TeaHandler$$ExternalSyntheticLambda1(this, did, iid));
    }

    /* JADX INFO: renamed from: lambda$onGetDeviceId$0$os-teatracker-TeaHandler, reason: not valid java name */
    /* synthetic */ void m3247lambda$onGetDeviceId$0$osteatrackerTeaHandler(String r3, String r4) {
        this.mDeviceId = r3;
        this.mInstallId = r4;
        Object r5 = sLock;
        monitor-enter(r5);
        Iterator<WeakReference<TeaAgent.TeaListener>> r6 = this.mListeners.iterator();     // Catch: Throwable -> L16
    L6:
        if (r6.hasNext() == false) goto L14;
        WeakReference<TeaAgent.TeaListener> r0 = r6.next();     // Catch: Throwable -> L16
        if (r0 == null) goto L6;
        TeaAgent.TeaListener r1 = r0.get();     // Catch: Throwable -> L16
        if (r1 == null) goto L6;
        r1.onDeviceIdLoaded(this.mDeviceId);     // Catch: Throwable -> L16
        r1.onInstallIdLoaded(this.mInstallId);     // Catch: Throwable -> L16
        goto L6
    L14:
        monitor-exit(r5);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // os.teatracker.BaseHandler
    public void addTeaListener(TeaAgent.TeaListener listener) {
        Log.i(TAG, "addTeaListener:");
        Object r0 = sLock;
        monitor-enter(r0);
        if (listener != null) goto L11;
    L6:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        this.mListeners.add(new WeakReference(listener));     // Catch: Throwable -> L8
        goto L6
    }

    @Override // os.teatracker.BaseHandler
    public void removeTeaListener(TeaAgent.TeaListener listener) {
        Object r0 = sLock;
        monitor-enter(r0);
        Iterator<WeakReference<TeaAgent.TeaListener>> r1 = this.mListeners.iterator();     // Catch: Throwable -> L28
    L6:
        if (r1.hasNext() == false) goto L15;
        WeakReference<TeaAgent.TeaListener> r2 = r1.next();     // Catch: Throwable -> L28
        if (r2.get() == null) goto L13;
        if (r2.get() != listener) goto L13;
        r1.remove();     // Catch: Throwable -> L28
    L13:
        if (r2.get() != null) goto L6;
        r1.remove();     // Catch: Throwable -> L28
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L28
        Object r5 = sLock;
        monitor-enter(r5);
    L25:
        th = move-exception;
        throw th;
    L19:
        if (this.mListeners.size() == 0) goto L21;
    L23:
        monitor-exit(r5);     // Catch: Throwable -> L25
        return;
    L21:
        if (this.mAppServiceObserver == null) goto L23;
        this.mHandler.post(new TeaHandler$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L25
    L28:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: lambda$removeTeaListener$1$os-teatracker-TeaHandler, reason: not valid java name */
    /* synthetic */ void m3248lambda$removeTeaListener$1$osteatrackerTeaHandler() {
        if (this.mListeners.size() == 0) goto L5;
        return;
    L5:
        if (this.mAppServiceObserver == null) goto L9;
        this.mContext.getContentResolver().unregisterContentObserver(this.mAppServiceObserver);
        this.mAppServiceObserver = null;
        return;
    }

    @Override // os.teatracker.BaseHandler
    public void setAppStateListener(TeaAgent.AppStateListener listener) {
        this.mAppStateListener = listener;
        if (listener != null) goto L5;
        return;
    L5:
        if (this.mAppStateReceiver != null) goto L9;
        this.mAppStateReceiver = new AppStateChangeReceiver();
        IntentFilter r2 = new IntentFilter(TeaConst.APP_STATE_ACTION);
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mAppStateReceiver, r2);
        return;
    }

    @Override // os.teatracker.BaseHandler
    public TeaAgent.AppStateListener getAppStateListener() {
        return this.mAppStateListener;
    }

    @Override // os.teatracker.BaseHandler
    public void setAbSDKVersion(String abSDKVersion) {
        this.mAbSDKVersion = abSDKVersion;
        Message.obtain(this.mHandler, 5, abSDKVersion).sendToTarget();
    }

    @Override // os.teatracker.BaseHandler
    public void setPrivacyPolicyConfirmed(boolean confirmed) {
        this.mIsPrivacyPolicyConfirmed = Boolean.valueOf(confirmed);
        Message.obtain(this.mHandler, 6, Boolean.valueOf(confirmed)).sendToTarget();
    }

    @Override // os.teatracker.BaseHandler
    public Boolean isPrivacyPolicyConfirmed() {
        return this.mIsPrivacyPolicyConfirmed;
    }

    @Override // os.teatracker.BaseHandler
    public String getAbSDKVersion() {
        return this.mAbSDKVersion;
    }

    @Override // os.teatracker.BaseHandler
    public void init(Context context, TeaConfig config) {
        Log.i(TAG, "init:");
        if (context == null) goto L52;
        if (this.mContext == null) goto L7;
        return;
    L7:
        String r1 = null;
        PackageInfo r3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);     // Catch: Exception -> L18 PackageManager.NameNotFoundException -> L20
        if (r3.applicationInfo.metaData != null) goto L11;
    L22:
        if (config == null) goto L25;
        if (r1 != null) goto L27;
        r1 = config.getAppId();
    L27:
        if (TextUtils.isEmpty(r1) == true) goto L50;
        config.setAppId(r1);
        if (context.getApplicationContext() == null) goto L32;
        context = context.getApplicationContext();
    L32:
        this.mContext = context;
        this.mConfig = config;
        this.mHandler.setContext(this.mContext);
        Message.obtain(this.mHandler, 1, config.getGlobalParams()).sendToTarget();
        checkBdInstall();
        String r7 = getTeaTrackerDid();
        String r8 = getInstallId();
        if (this.mBdInstall == false) goto L45;
        if (TextUtils.isEmpty(r7) == true) goto L54;
        bdInstallRegister();
        return;
    L54:
    L41:
        e = move-exception;
        e.printStackTrace();
        return;
    L37:
        if (isProviderExists(this.mContext, TeaConst.AUTHORITY_URI.getAuthority()) == false) goto L39;
        ContentResolver r9 = this.mContext.getContentResolver();     // Catch: RuntimeException -> L41
        Uri r10 = TeaConst.URI_DEVICE_ID;     // Catch: RuntimeException -> L41
        final WorkHandler r2 = this.mHandler;     // Catch: RuntimeException -> L41
        r9.registerContentObserver(r10, false, new AnonymousClass1(this, r2));     // Catch: RuntimeException -> L41
    L53:
        return;
    L39:
        bdInstallRegister();     // Catch: RuntimeException -> L41
        goto L53
    L45:
        if (TextUtils.isEmpty(r7) == true) goto L47;
        onGetDeviceId(r7, r8);
    L47:
        final WorkHandler r11 = this.mHandler;
        this.mAppServiceObserver = new AnonymousClass2(this, r11);
        this.mContext.getContentResolver().registerContentObserver(TeaConst.URI_DEVICE_ID, false, this.mAppServiceObserver);
        return;
    L50:
        throw new IllegalArgumentException("teatracker_app_id must be declared in manifest as meta data");
    L25:
        config = new TeaConfig();
        goto L27
    L11:
        if (r3.applicationInfo.metaData.containsKey(TeaUtil.TEATRACKER_APP_ID) == false) goto L22;
        r1 = r3.applicationInfo.metaData.getString(TeaUtil.TEATRACKER_APP_ID, null);     // Catch: Exception -> L18 PackageManager.NameNotFoundException -> L20
        if (TextUtils.isEmpty(r1) == false) goto L22;
        int r0 = r3.applicationInfo.metaData.getInt(TeaUtil.TEATRACKER_APP_ID, 0);     // Catch: Exception -> L18 PackageManager.NameNotFoundException -> L20
        if (r0 == 0) goto L22;
        r1 = String.valueOf(r0);     // Catch: Exception -> L18 PackageManager.NameNotFoundException -> L20
    L20:
        e = move-exception;
        Log.e(TeaConfig.TAG, "get package info error!", e);
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L22
    L52:
        throw new IllegalArgumentException("context can't be null when initing Tea tracker.");
    }

    private void checkBdInstall() {
        Log.d(TAG, "checkBdInstall");
        this.implClass = Class.forName("os.teatracker.BdInstallImpl");     // Catch: ClassNotFoundException -> L10
    L5:
        if (this.implClass == null) goto L7;
        boolean r0 = true;
    L8:
        this.mBdInstall = r0;
        return;
    L7:
        r0 = false;
        goto L8
    }

    private void bdInstallRegister() {
        Log.d(TAG, "bdInstallRegister: ");
        if (this.mBdInstall == true) goto L5;
        return;
    L5:
        Bundle r0 = null;
        PackageInfo r1 = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 128);     // Catch: Exception -> L12 PackageManager.NameNotFoundException -> L14
        if (r1.applicationInfo.metaData != null) goto L9;
    L21:
        IBdInstall r2 = (IBdInstall) this.implClass.newInstance();     // Catch: Throwable -> L18
        Bundle r3 = new Bundle();     // Catch: Throwable -> L18
        r3.putString("app_id", this.mConfig.getAppId());     // Catch: Throwable -> L18
        r3.putString("app_name", this.mConfig.getAppName());     // Catch: Throwable -> L18
        r3.putString(IBdInstall.PARAM_APP_CHANNEL, this.mConfig.getChannel());     // Catch: Throwable -> L18
        r3.putBundle(IBdInstall.PARAM_META_DATA, r0);     // Catch: Throwable -> L18
        r2.register(this.mContext, this.mHandler, r3, this);     // Catch: Throwable -> L18
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        if (r1.applicationInfo.metaData.containsKey(TeaUtil.TEATRACKER_APP_ID) == false) goto L21;
        r0 = r1.applicationInfo.metaData;     // Catch: Exception -> L12 PackageManager.NameNotFoundException -> L14
    L14:
        e = move-exception;
        Log.e(TeaConfig.TAG, "get package info error!", e);
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L21
    }

    @Override // os.teatracker.BaseHandler
    public void onEvent(TeaEvent event) {
        Message.obtain(this.mHandler, 2, event).sendToTarget();
    }

    @Override // os.teatracker.BaseHandler
    public void onSysEvent(TeaEvent event) {
        Message.obtain(this.mHandler, 7, event).sendToTarget();
    }

    @Override // os.teatracker.BaseHandler
    public String getDeviceId() {
        if (this.mBdInstall == false) goto L7;
        return this.mDeviceId;
    L7:
        return getTeaTrackerDid();
    }

    @Override // os.teatracker.BaseHandler
    public String getTeaTrackerDid() {
        Bundle r3 = this.mContext.getContentResolver().call(TeaConst.AUTHORITY_URI, "getDeviceId", null, null);     // Catch: Exception -> L7
        if (r3 == null) goto L9;
        return r3.getString("key_device_info");
    L9:
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    @Override // os.teatracker.BaseHandler
    public String getInstallId() {
        if (this.mBdInstall == true) goto L5;
        return "INVALID_IID_MISSING_BDINSTALL";
    L5:
        return this.mInstallId;
    }

    @Override // os.teatracker.BaseHandler
    public String getUDID() {
        Bundle r3 = this.mContext.getContentResolver().call(TeaConst.AUTHORITY_URI, TeaConst.METHOD_GET_UDID, null, null);     // Catch: Exception -> L7
        if (r3 == null) goto L9;
        return r3.getString(TeaConst.KEY_CLIENT_UDID);
    L9:
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    @Override // os.teatracker.BaseHandler
    public String getOaid() {
        Bundle r3 = this.mContext.getContentResolver().call(TeaConst.OAID_AUTHORITY_URI, "request_oaid", null, null);     // Catch: Exception -> L7
        if (r3 == null) goto L9;
        return r3.getString("oaid");
    L9:
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public String getAndroidId() {
        Bundle r3 = this.mContext.getContentResolver().call(TeaConst.AUTHORITY_URI, TeaConst.METHOD_GET_ANDROID_ID, null, null);     // Catch: Exception -> L7
        if (r3 == null) goto L9;
        return r3.getString(TeaConst.KEY_CLIENT_ANDROID_ID);
    L9:
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    @Override // os.teatracker.BaseHandler
    public String getSerialNumber() {
        Bundle r3 = this.mContext.getContentResolver().call(TeaConst.AUTHORITY_URI, TeaConst.METHOD_GET_SN, null, null);     // Catch: Exception -> L7
        if (r3 == null) goto L9;
        return r3.getString(TeaConst.KEY_CLIENT_SN);
    L9:
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    @Override // os.teatracker.BaseHandler
    public String getImei() {
        Bundle r3 = this.mContext.getContentResolver().call(TeaConst.AUTHORITY_URI, TeaConst.METHOD_GET_IMEI, null, null);     // Catch: Exception -> L7
        if (r3 == null) goto L9;
        return r3.getString(TeaConst.KEY_CLIENT_IMEI);
    L9:
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    @Override // os.teatracker.BaseHandler
    public String getMeid() {
        Bundle r3 = this.mContext.getContentResolver().call(TeaConst.AUTHORITY_URI, TeaConst.METHOD_GET_MEID, null, null);     // Catch: Exception -> L7
        if (r3 == null) goto L9;
        return r3.getString(TeaConst.KEY_CLIENT_MEID);
    L9:
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    @Override // os.teatracker.BaseHandler
    public void setEnableET(String appId, boolean enable) {
        Intent r0 = new Intent("com.bytedance.os.mermaid.ENABLE_ET_VERIFY");
        r0.setPackage("com.bytedance.os.mermaid");
        r0.putExtra("app_id", appId);
        r0.putExtra("enable", enable);
        this.mContext.sendBroadcast(r0);
    }

    @Override // os.teatracker.BaseHandler
    public void onQuit() {
        this.mContext.getContentResolver().unregisterContentObserver(this.mAppServiceObserver);
        this.mContext.unregisterReceiver(this.mAppStateReceiver);
        Message.obtain(this.mHandler, 4).sendToTarget();
        this.mHandler.getLooper().quitSafely();
        this.mConfig = null;
    }

    @Override // os.teatracker.BaseHandler
    TeaConfig getTeaConfig() {
        return this.mConfig;
    }

    @Override // os.teatracker.BaseHandler
    Context getContext() {
        return this.mContext;
    }

    public TeaHandler() {
        this.implClass = null;
        this.mListeners = Collections.synchronizedList(new ArrayList());
        this.mAppStateListener = null;
        this.mAppStateReceiver = null;
        this.mIsPrivacyPolicyConfirmed = null;
        HandlerThread r0 = new HandlerThread("Tea Handler");
        r0.start();
        this.mHandler = new WorkHandler((Looper) Objects.requireNonNull(r0.getLooper()));
    }

    private boolean isProviderExists(Context context, String authority) {
        if (context.getPackageManager().resolveContentProvider(authority, 0) == null) goto L6;
        return true;
    L6:
        return false;
    }
}
