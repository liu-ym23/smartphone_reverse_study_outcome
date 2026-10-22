package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.android.settings.users.AppRestrictionsFragment;
import com.android.settings.utils.HanziToPinyin;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Cdid;
import com.bytedance.bdinstall.DeviceTokenService;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.ExecutorUtil;
import com.bytedance.bdinstall.IEventDepend;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.callback.RegisterResultListener;
import com.bytedance.bdinstall.callback.event.HeaderChangeEvent;
import com.bytedance.bdinstall.callback.event.InstallFinishEvent;
import com.bytedance.bdinstall.callback.event.RequestDrSuccessEvent;
import com.bytedance.bdinstall.migrate.MigrateDetector;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.storage.DeviceParamProviderCreator;
import com.bytedance.bdinstall.storage.ICache;
import com.bytedance.bdinstall.storage.SPCache;
import com.bytedance.bdinstall.util.DataObserverHolder;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.RequestIdGenerator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceManager implements RegisterResultListener {
    private static final String KEY_DR_AID = "dr_aid";
    private static final String KEY_DR_CHANNEL = "dr_channel";
    private static final String KEY_INSTALL_VERSION_CODE = "dr_install_vc";
    private static final int MAX_PERMISSION = 10;
    public static final int STATE_DIFF = 2;
    public static final int STATE_EMPTY = 0;
    public static final int STATE_SAME = 1;
    private boolean hasInitLoader;
    private boolean mAllReady;
    protected final Context mApp;
    private int mCountPermission;
    private volatile boolean mDetectedMigrate;
    private final DRSpecialLoader mDrSpecialHeaderLoader;
    private Env mEnv;
    private JSONObject mHeader;
    private boolean mIsNewUser;
    private final Map<Class<?>, BaseLoader> mLoaders;
    private final Object mLock;
    protected final InstallOptions mOptions;
    private ICache mSpCache;
    private final AtomicBoolean mStarted;

    public DeviceManager(Context r3, InstallOptions r4, Env r5) {
        this.mLoaders = new LinkedHashMap(32);
        this.hasInitLoader = false;
        this.mLock = new Object();
        this.mDetectedMigrate = false;
        this.mStarted = new AtomicBoolean(false);
        this.mCountPermission = 0;
        this.mApp = r3;
        this.mEnv = r5;
        this.mOptions = r4;
        this.mHeader = new JSONObject();
        this.mDrSpecialHeaderLoader = new DRSpecialLoader(r4);
        this.mSpCache = createSpCache(r3, r5);
        ExecutorUtil.runOnHandlerThread(new AnonymousClass1(this));
    }

    private ICache createSpCache(Context r2, Env r3) {
        INewUserModeService r1 = (INewUserModeService) ServiceManager.getService(INewUserModeService.class);
        SPCache r0 = new SPCache(r2, r3.getEnvIsolateSp(r2));
        if (r1 != null) goto L5;
        return r0;
    L5:
        return (ICache) r1.tryReplaceService(ICache.class, r0);
    }

    public void start() {
        if (this.mStarted.getAndSet(true) == true) goto L6;
        DeviceParamProviderCreator.registerInstallParameterProvider(this.mApp, this.mEnv, this.mOptions);
        return;
    }

    public void changeEnv(Env r7, boolean r8) {
        this.mEnv = r7;
        this.mSpCache = createSpCache(this.mApp, r7);
        DeviceParamProviderCreator.registerInstallParameterProvider(this.mApp, r7, this.mOptions);
        Map<Class<?>, BaseLoader> r0 = this.mLoaders;
        monitor-enter(r0);
        this.mLoaders.put(ServerIdLoader.class, new ServerIdLoader(this.mOptions, r7));     // Catch: Throwable -> L10
        this.mLoaders.put(DeviceParamsLoader.class, new DeviceParamsLoader(this.mApp, this.mOptions, r7));     // Catch: Throwable -> L10
        this.mLoaders.put(ConfigLoader.class, new ConfigLoader(this.mApp, this.mOptions, r7));     // Catch: Throwable -> L10
        this.mLoaders.put(CdidLoader.class, new CdidLoader(this.mApp));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetRequestTime(r7);
        if (r8 == false) goto L15;
        loadHeaderAndNotify();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void loadHeaderAndNotify() {
        load();
        CallbackCenter.postEvent(new HeaderChangeEvent(getConstHeader()));
        notifyDidAndIidLoadSuccessEvent();
    }

    public void reloadHeaderSstLoader() {
        ((BaseLoader) Objects.requireNonNull(this.mLoaders.get(SstLoader.class))).mReady = false;
        loadHeaderAndNotify();
    }

    private void resetRequestTime(Env r3) {
        r3.getEnvIsolateSp(this.mApp).edit().putLong(Api.KEY_REGISTER_TIME, 0).apply();
    }

    protected void migrate() {
        Context r0 = this.mApp;
    L14:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mDetectedMigrate = true;     // Catch: Throwable -> L20
        this.mLock.notifyAll();     // Catch: Throwable -> L20
        throw th;
    L20:
        th = move-exception;
        throw th;
    L4:
        if (detectMigrate(r0, this.mEnv) == true) goto L6;
        OldSpMigrater.tryDoSDKMigrate(r0, this.mEnv, this.mOptions);     // Catch: Throwable -> L14
    L6:
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mDetectedMigrate = true;     // Catch: Throwable -> L11
        this.mLock.notifyAll();     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private boolean detectMigrate(Context r5, Env r6) {
        if (this.mOptions.enableOneKeyMigrateDetect() == true) goto L6;
        DrLog.d("disable OneKeyMigrateDetect");
        return false;
    L6:
        MigrateDetector r0 = new MigrateDetector(r5);
        boolean r1 = r0.isMigrate();
        DrLog.d("is one key migrate：" + r1);
        if (r1 == false) goto L9;
        MigrateDetector.saveOldDid(r5, getDid(), true);
        MigrateClear.clear(r5, this.mOptions, r6);
    L9:
        r0.disableComponent();
        return r1;
    }

    public JSONObject getConstHeader() {
        return this.mHeader;
    }

    private boolean needSyncFromSub(BaseLoader r3) {
        if (Utils.isMainProcess(this.mOptions.getContext()) == false) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (DrLog.debug() == false) goto L11;
        DrLog.d("needSyncFromSub " + r3 + HanziToPinyin.Token.SEPARATOR + r2);
    L11:
        return r2;
    L5:
        if (r3.syncFromSub == false) goto L7;
        r2 = true;
        goto L9
    }

    public boolean load() {
        Map<Class<?>, BaseLoader> r0 = this.mLoaders;
        monitor-enter(r0);
    L58:
        th = move-exception;
        throw th;
    L5:
        if (this.hasInitLoader == true) goto L7;
        this.hasInitLoader = true;     // Catch: Throwable -> L58
        this.mLoaders.put(BuildLoader.class, new BuildLoader(this.mApp));     // Catch: Throwable -> L58
        this.mLoaders.put(ConfigLoader.class, new ConfigLoader(this.mApp, this.mOptions, this.mEnv));     // Catch: Throwable -> L58
        this.mLoaders.put(DisplayLoader.class, new DisplayLoader(this.mApp));     // Catch: Throwable -> L58
        this.mLoaders.put(LocaleLoader.class, new LocaleLoader(this.mApp));     // Catch: Throwable -> L58
        this.mLoaders.put(NetLoader.class, new NetLoader(this.mApp));     // Catch: Throwable -> L58
        this.mLoaders.put(PackageLoader.class, new PackageLoader(this.mApp, this.mOptions));     // Catch: Throwable -> L58
        this.mLoaders.put(RomLoader.class, new RomLoader());     // Catch: Throwable -> L58
        this.mLoaders.put(ServerIdLoader.class, new ServerIdLoader(this.mOptions, this.mEnv));     // Catch: Throwable -> L58
        this.mLoaders.put(SigHashLoader.class, new SigHashLoader(this.mApp));     // Catch: Throwable -> L58
        this.mLoaders.put(SimCountryLoader.class, new SimCountryLoader(this.mApp));     // Catch: Throwable -> L58
        this.mLoaders.put(DeviceParamsLoader.class, new DeviceParamsLoader(this.mApp, this.mOptions, this.mEnv));     // Catch: Throwable -> L58
        this.mLoaders.put(CdidLoader.class, new CdidLoader(this.mApp));     // Catch: Throwable -> L58
        this.mLoaders.put(AppTraitLoader.class, new AppTraitLoader(this.mApp, this.mOptions));     // Catch: Throwable -> L58
        this.mLoaders.put(AppKeyLoader.class, new AppKeyLoader(this.mApp));     // Catch: Throwable -> L58
        this.mLoaders.put(CustomLoader.class, new CustomLoader(this.mOptions));     // Catch: Throwable -> L58
        this.mLoaders.put(FlavorSpecialLoader.class, new FlavorSpecialLoader(this.mApp, this.mOptions));     // Catch: Throwable -> L58
        this.mLoaders.put(SstLoader.class, new SstLoader(this.mApp, this.mOptions));     // Catch: Throwable -> L58
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L58
        monitor-enter(this);
        JSONObject r1 = getConstHeader();     // Catch: Throwable -> L55
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L55
        Utils.copy(r2, r1);     // Catch: Throwable -> L55
        Iterator<BaseLoader> r3 = this.mLoaders.values().iterator();     // Catch: Throwable -> L55
        boolean r4 = true;
        int r5 = 0;
        int r6 = 0;
    L11:
        if (r3.hasNext() == false) goto L43;
        BaseLoader r7 = r3.next();     // Catch: Throwable -> L55
        if (r7.mReady == true) goto L15;
    L65:
        r7.remove(r2);     // Catch: SecurityException -> L20 JSONException -> L28 Throwable -> L55
        r7.mReady = r7.doLoad(r2);     // Catch: SecurityException -> L20 JSONException -> L28 Throwable -> L55
    L31:
        if (r7.mReady == false) goto L33;
    L36:
        if (r7.mReady == false) goto L38;
    L41:
        boolean r8 = true;
    L42:
        r4 = r4 & r8;     // Catch: Throwable -> L55
        goto L11
    L38:
        if (r7.mOptional == true) goto L41;
        r8 = false;
        goto L42
    L33:
        if (r7.mOptional == true) goto L36;
        r6 = r6 + 1;     // Catch: Throwable -> L55
    L20:
        e = move-exception;
        if (r7.mOptional == true) goto L31;
        r5 = r5 + 1;     // Catch: Throwable -> L55
        DrLog.w("loadHeader, " + this.mCountPermission, e);     // Catch: Throwable -> L55
        if (r7.mReady == true) goto L31;
        if (this.mCountPermission <= 10) goto L31;
        r7.mReady = true;     // Catch: Throwable -> L55
    L28:
        e = move-exception;
        DrLog.ysnp(e);     // Catch: Throwable -> L55
        goto L31
    L15:
        if (r7.mShouldUpdate == true) goto L65;
        if (needSyncFromSub(r7) == false) goto L36;
    L43:
        this.mHeader = r2;     // Catch: Throwable -> L55
        this.mAllReady = r4;     // Catch: Throwable -> L55
        if (DrLog.debug() == false) goto L46;
        DrLog.d("loadHeader, " + this.mAllReady + ", " + this.mCountPermission + ", " + this.mHeader);     // Catch: Throwable -> L55
    L47:
        if (r5 <= 0) goto L52;
        if (r5 != r6) goto L52;
        this.mCountPermission++;     // Catch: Throwable -> L55
        if (getRegisterState() == 0) goto L52;
        this.mCountPermission += 10;     // Catch: Throwable -> L55
    L52:
        monitor-exit(this);     // Catch: Throwable -> L55
        return this.mAllReady;
    L46:
        DrLog.i("loadHeader, " + this.mAllReady + ", " + this.mCountPermission, null);     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        throw th;
    }

    private String getSsid() {
        return this.mSpCache.getCachedString("ssid");
    }

    public int getRegisterState() {
        String r0 = getConstHeader().optString("device_id", "");
        String r1 = getConstHeader().optString(Api.KEY_INSTALL_ID, "");
        String r2 = getConstHeader().optString(Api.KEY_BD_DID, "");
        if (Utils.checkId(r0) == true) goto L7;
        if (Utils.checkId(r2) == true) goto L7;
        return 0;
    L7:
        if (Utils.checkId(r1) == true) goto L9;
        return 0;
    L9:
        if (LocalConstants.getCommonSp(this.mApp).getLong(KEY_INSTALL_VERSION_CODE, 0) != getConstHeader().optLong("version_code", -1)) goto L11;
        return 1;
    L11:
        return 2;
    }

    public boolean updateHeader(String r4, Object r5) {
        Object r0 = getConstHeader().opt(r4);
        if (r5 != null) goto L5;
    L6:
        if (r5 != null) goto L19;
        if (r0 == null) goto L19;
    L8:
        monitor-enter(this);
        JSONObject r1 = this.mHeader;     // Catch: Throwable -> L11 JSONException -> L13
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L11 JSONException -> L13
        Utils.copy(r2, r1);     // Catch: Throwable -> L11 JSONException -> L13
        r2.put(r4, r5);     // Catch: Throwable -> L11 JSONException -> L13
        this.mHeader = r2;     // Catch: Throwable -> L11 JSONException -> L13
    L15:
        monitor-exit(this);     // Catch: Throwable -> L11
        boolean r3 = true;
    L21:
        if (DrLog.debug() == false) goto L23;
        DrLog.d("updateHeader, " + r4 + ", " + r0 + ", " + r5);
    L23:
        return r3;
    L11:
        th = move-exception;
        throw th;
    L13:
        e = move-exception;
        DrLog.ysnp(e);     // Catch: Throwable -> L11
    L19:
        r3 = false;
        goto L21
    L5:
        if (r5.equals(r0) == false) goto L8;
        goto L6
    }

    public String getDid() {
        IInstallParameters r0 = (IInstallParameters) ServiceManager.getService(IInstallParameters.class);
        if (r0 == null) goto L7;
        return r0.getDeviceId();
    L7:
        return this.mSpCache.loadDeviceId("", "");
    }

    private String getIid() {
        return this.mSpCache.getCachedString(Api.KEY_INSTALL_ID);
    }

    private String getClientUdid() {
        return LocalConstants.getCommonSp(this.mApp).getString(Api.KEY_C_UDID, null);
    }

    private String getOpenUdid() {
        return LocalConstants.getCommonSp(this.mApp).getString(Api.KEY_OPEN_UDID, null);
    }

    public InstallInfo getInstallInfo() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        awaitLoadedLocked();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        String r1 = getDid();
        String r2 = getIid();
        String r3 = getOpenUdid();
        String r4 = getClientUdid();
        String r6 = getSsid();
        InstallInfo r5 = new InstallInfo();
        if (TextUtils.isEmpty(r1) == false) goto L9;
        r1 = "";
    L9:
        r5.setDid(r1);
        if (TextUtils.isEmpty(r2) == false) goto L12;
        r2 = "";
    L12:
        r5.setIid(r2);
        r5.setClientUdid(r4);
        r5.setOpenUdid(r3);
        r5.setSsid(r6);
        return r5;
    L14:
        th = move-exception;
        throw th;
    }

    public JSONObject getHeader() {
        if (this.mAllReady == true) goto L7;
        return null;
    L7:
        return getConstHeader();
    }

    public boolean isUpgrade() {
        if (LocalConstants.getCommonSp(this.mApp).getLong(KEY_INSTALL_VERSION_CODE, 0) == getConstHeader().optLong("version_code", 0)) goto L5;
        return true;
    L5:
        return false;
    }

    public void updateDrSpecialHeader(JSONObject r1, Env r2) {
        this.mDrSpecialHeaderLoader.doLoad(r1, r2);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void notifyBeforeRegister() {
        InstallInfo r4 = getInstallInfo();
        String r0 = null;
        if (r4 == null) goto L5;
        String r1 = r4.getDid();
    L6:
        if (r4 == null) goto L8;
        String r2 = r4.getIid();
    L9:
        if (r4 == null) goto L11;
        r0 = r4.getSsid();
    L11:
        DataObserverHolder.getInstance().onIdLoaded(r1, r2, r0);
        if (r4 != null) goto L14;
        return;
    L14:
        if (TextUtils.isEmpty(r4.getDid()) == false) goto L16;
        return;
    L16:
        if (TextUtils.isEmpty(r4.getIid()) == true) goto L22;
        CallbackCenter.postEvent(new InstallFinishEvent(r4));
        return;
    L22:
        return;
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public void notifyDidAndIidLoadSuccessEvent() {
        InstallInfo r1 = getInstallInfo();
        if (r1 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r1.getDid()) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r1.getIid()) == true) goto L13;
        CallbackCenter.postEvent(new InstallFinishEvent(r1));
        return;
    }

    private void awaitLoadedLocked() {
    L3:
        if (this.mDetectedMigrate == true) goto L8;
        this.mLock.wait();     // Catch: InterruptedException -> L6
    L6:
        e = move-exception;
        DrLog.ysnp(e);
        goto L3
    }

    @Override // com.bytedance.bdinstall.callback.RegisterResultListener
    public boolean onRegisterResult(JSONObject r21, Env r22, IInstallParameters r23) {
        if (r21 != null) goto L5;
        return false;
    L5:
        String r10 = r21.optString("device_id_str", "");
        String r12 = r21.optString("install_id_str", "");
        String r5 = r21.optString(Api.KEY_DEVICE_TOKEN, "");
        String r14 = r21.optString("ssid", "");
        String r6 = r21.optString(Api.KEY_CD, "");
        if (r21.optInt(AppRestrictionsFragment.EXTRA_NEW_USER, 0) <= 0) goto L8;
        boolean r7 = true;
    L9:
        this.mIsNewUser = r7;
        if (DrLog.debug() == false) goto L12;
        DrLog.d("saveRegisterInfo, " + r10 + ", " + r12 + ", " + r14 + ", , " + r6 + ", " + r21);
    L12:
        boolean r13 = Utils.checkId(r10);
        boolean r16 = Utils.checkId(r12);
        Utils.checkId(r6);
        SharedPreferences.Editor r8 = this.mOptions.getSp().edit();
        SharedPreferences r9 = LocalConstants.getCommonSp(this.mApp);
        SharedPreferences.Editor r11 = r9.edit();
        boolean r15 = Utils.checkId(r14);     // Catch: JSONException -> L102
        long r18 = r9.getLong(KEY_INSTALL_VERSION_CODE, 0);     // Catch: JSONException -> L100
        long r4 = getConstHeader().optLong("version_code", 0);     // Catch: JSONException -> L100
        if (r18 != r4) goto L113;
    L22:
        r11.putString(KEY_DR_CHANNEL, this.mOptions.getChannel());     // Catch: JSONException -> L100
        r11.putString(KEY_DR_AID, String.valueOf(this.mOptions.getAid()));     // Catch: JSONException -> L100
        if (r13 == true) goto L126;
        JSONObject r17 = new JSONObject();     // Catch: JSONException -> L28
        r17.put(ApmTrafficStats.TTNET_RESPONSE, r21);     // Catch: JSONException -> L28
        IEventDepend r19 = this.mOptions.getEventDepend();     // Catch: JSONException -> L28
        if (r19 == null) goto L126;
        r19.onEvent("tt_fetch_did_error", r17);     // Catch: JSONException -> L28
    L28:
        e = e;
    L99:
        boolean r20 = false;
    L105:
        DrLog.ysnp(e);
    L106:
        if (r13 == false) goto L109;
        if (r16 == false) goto L109;
        boolean r24 = true;
    L110:
        if (r24 == false) goto L112;
        CallbackCenter.postEvent(new RequestDrSuccessEvent(r21));
    L112:
        return r24;
    L109:
        r24 = r20;
    L126:
        String r25 = getDid();     // Catch: JSONException -> L97
        if (DrLog.debug() == false) goto L33;
        DrLog.d("od=" + r25 + " nd=" + r10 + " ck=" + r13);     // Catch: JSONException -> L28
    L33:
        if (r13 == true) goto L35;
        boolean r3 = false;
        boolean r26 = false;
    L52:
        String r110 = getConstHeader().optString(Api.KEY_INSTALL_ID, "");     // Catch: JSONException -> L97
        if (r16 == true) goto L55;
    L62:
        r8.putString("device_id", r10);     // Catch: JSONException -> L97
        r8.putString(Api.KEY_INSTALL_ID, r12);     // Catch: JSONException -> L97
        String r0 = getConstHeader().optString("ssid", "");     // Catch: JSONException -> L97
        if (r15 == true) goto L65;
    L68:
        this.mOptions.saveConfigAfterRegister(r11);     // Catch: JSONException -> L97
        r11.apply();     // Catch: JSONException -> L97
        r8.apply();     // Catch: JSONException -> L97
        ((DeviceTokenService) ServiceManager.getService(DeviceTokenService.class)).updateToken(r5, r22);     // Catch: JSONException -> L97
        if (TextUtils.equals(r10, r25) == false) goto L71;
    L73:
        boolean r27 = false;
    L75:
        if (TextUtils.equals(r12, r110) == false) goto L77;
    L79:
        boolean r28 = false;
    L80:
        if (r3 == false) goto L82;
        CallbackCenter.postEvent(new HeaderChangeEvent(getConstHeader()));     // Catch: JSONException -> L28
    L82:
        if (r27 == true) goto L86;
        if (r28 == true) goto L86;
        r20 = false;
    L89:
        DataObserverHolder.getInstance().onRemoteIdGet(r26, r25, r10, r110, r12, r0, r14);     // Catch: JSONException -> L93
        r13 = r13;
    L93:
        e = e;
        r13 = r13;
    L95:
        e = e;
    L86:
        notifyDidAndIidLoadSuccessEvent();     // Catch: JSONException -> L97
        r20 = false;
        MigrateDetector.saveOldDid(this.mApp, null, false);     // Catch: JSONException -> L95
        goto L89
    L77:
        if (TextUtils.isEmpty(r12) == true) goto L79;
        r28 = true;
        goto L80
    L71:
        if (TextUtils.isEmpty(r10) == true) goto L73;
        r27 = true;
        goto L75
    L65:
        if (updateHeader("ssid", r14) == false) goto L68;
        this.mSpCache.cacheString("ssid", r14);     // Catch: JSONException -> L28
        r3 = true;
        r26 = true;
        goto L68
    L55:
        if (updateHeader(Api.KEY_INSTALL_ID, r12) == false) goto L62;
        this.mSpCache.cacheString(Api.KEY_INSTALL_ID, r12);     // Catch: JSONException -> L28
        if (TextUtils.isEmpty(r110) == true) goto L61;
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L28
        r1.put("old_id", r110);     // Catch: JSONException -> L28
        r1.put("new_id", r12);     // Catch: JSONException -> L28
        IEventDepend r29 = this.mOptions.getEventDepend();     // Catch: JSONException -> L28
        if (r29 == null) goto L61;
        r29.onEvent("iid_change", r1);     // Catch: JSONException -> L28
    L61:
        r3 = true;
        r26 = true;
        goto L62
    L35:
        if (r10.equals(this.mHeader.optString("device_id")) == true) goto L44;
        monitor-enter(this);     // Catch: JSONException -> L28
        JSONObject r30 = this.mHeader;     // Catch: Throwable -> L41
        JSONObject r31 = new JSONObject();     // Catch: Throwable -> L41
        Utils.copy(r31, r30);     // Catch: Throwable -> L41
        r31.put("device_id", r10);     // Catch: Throwable -> L41
        this.mHeader = r31;     // Catch: Throwable -> L41
        monitor-exit(this);     // Catch: Throwable -> L41
        r23.updateDeviceId(r10);     // Catch: JSONException -> L28
        r3 = true;
        r26 = true;
    L46:
        if (r10.equals(r25) == true) goto L52;
        if (TextUtils.isEmpty(r25) == true) goto L50;
        monitorDidError(r23, r10, r25);     // Catch: JSONException -> L28
    L50:
        r26 = true;
        goto L52
    L41:
        th = move-exception;
        throw th;     // Catch: JSONException -> L28
    L44:
        r3 = false;
        r26 = false;
    L97:
        e = e;
        goto L99
    L113:
        r11.putLong(KEY_INSTALL_VERSION_CODE, r4);     // Catch: JSONException -> L20
    L20:
        e = e;
        r20 = false;
        r13 = false;
    L100:
        e = e;
        r20 = false;
    L104:
        r13 = r20;
    L102:
        e = e;
        r20 = false;
        goto L104
    L8:
        r7 = false;
        goto L9
    }

    private void monitorDidError(IInstallParameters r4, String r5, String r6) throws JSONException {
        String r0 = r4.getClientUDID();
        JSONObject r1 = new JSONObject();
        r1.put("old_id", r6);
        r1.put("new_id", r5);
        if (this.mEnv.isChildMode() == true) goto L5;
        r1.put(Api.KEY_OPEN_UDID, r4.getOpenUdid(true));
    L5:
        r1.put(Api.KEY_C_UDID, r0);
        IEventDepend r3 = this.mOptions.getEventDepend();
        if (r3 == null) goto L9;
        r3.onEvent("did_change", r1);
        return;
    }

    public boolean isDiffChannel() {
        return !TextUtils.equals(LocalConstants.getCommonSp(this.mApp).getString(KEY_DR_CHANNEL, null), this.mOptions.getChannel());
    }

    public boolean isDiffAid() {
        return !TextUtils.equals(LocalConstants.getCommonSp(this.mApp).getString(KEY_DR_AID, null), String.valueOf(this.mOptions.getAid()));
    }

    public JSONObject loadOrGetHeader() {
        JSONObject r0 = getHeader();
        if (r0 == null) goto L5;
        return r0;
    L5:
        start();
        load();
        return getHeader();
    }

    @Deprecated
    public boolean isNewUser() {
        return this.mIsNewUser;
    }

    public void clear() {
        IInstallParameters r0 = (IInstallParameters) ServiceManager.getService(IInstallParameters.class);
        if (r0 == null) goto L5;
        r0.clearAll();
    L5:
        Cdid.clearCdid(this.mApp);
        RequestIdGenerator.clearReqId();
    }

    public Env getCurEnv() {
        return this.mEnv;
    }
}
