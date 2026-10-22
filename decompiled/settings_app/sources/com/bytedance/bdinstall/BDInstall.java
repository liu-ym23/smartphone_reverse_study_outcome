package com.bytedance.bdinstall;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.callback.HeaderUpdateCallback;
import com.bytedance.bdinstall.callback.InstallFinishCallback;
import com.bytedance.bdinstall.callback.OaidCallback;
import com.bytedance.bdinstall.intf.IAdIdConfig;
import com.bytedance.bdinstall.intf.IParamFilter;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.service.IInstallService;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.NUApi;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.Constants;
import com.bytedance.bdinstall.util.DataObserverHolder;
import com.bytedance.bdinstall.util.Singleton;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class BDInstall {
    private static volatile IAdIdConfig sAdIdConfig;
    private static volatile AppContext sAppContext;
    private static volatile IParamFilter sFilter;
    private static final Singleton<InstallInfo> sInstallInfoBeforeInit = null;
    private static final InstallWaitingLock sInstallLock = null;
    private static volatile InstallOptions sOptions;
    private static final Singleton<IInstallService> service = null;

    public static void clearInstallInfoWhenSwitchChildMode(Env r0) {
    }

    public static void resetInstallInfoWhenSwitchChildMode(Context r0, Env r1, long r2, OnResetListener r4) {
    }

    static {
        sAdIdConfig = new IAdIdConfig.AdIdConfig();
        sInstallLock = new InstallWaitingLock();
        service = new AnonymousClass1();
        sOptions = null;
        sInstallInfoBeforeInit = new AnonymousClass2();
    }

    private BDInstall() {
    }

    public static void init(InstallOptions r1) {
        init(r1, Env.DEFAULT);
    }

    public static void init(InstallOptions r4, Env r5) {
        sOptions = r4;
        IParamFilter r0 = r4.getParamFilter();
        if (r0 == null) goto L6;
        sFilter = r0;
    L6:
        if (r4.getAdIdConfig() == null) goto L8;
        sAdIdConfig = r4.getAdIdConfig();
    L8:
        ISstInfoProvider r1 = r4.getSstInfoProvider();
        if (r1 == null) goto L11;
        SstInfoCompat.setSstInfoProvider(r1);
    L11:
        service.get(new Object[]{r4.getContext()}).init(r4, r5);
    }

    public static void start() {
        service.get(new Object[]{sOptions.getContext()}).start();
        Oaid.instance(sOptions.getContext()).startNotify();
    }

    public static void reFetchOaid() {
        Oaid.instance(sOptions.getContext()).clear();
        Oaid.resetSelf(sOptions.getContext());
        Oaid.instance(sOptions.getContext()).init();
    }

    public static void reStart() {
        service.get(new Object[]{sOptions.getContext()}).reStart();
    }

    public static Map<String, String> getRequestHeader() {
        DeviceTokenService r0 = (DeviceTokenService) ServiceManager.getService(DeviceTokenService.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getRequestHeader();
    }

    public static Env getCurrentEnv() {
        if (sOptions != null) goto L5;
        return null;
    L5:
        if (sOptions.getContext() != null) goto L8;
        return null;
    L8:
        return service.get(new Object[]{sOptions.getContext()}).getCurEnv();
    }

    public static void changeUriRuntimeAndReInstall(Env r4) {
        service.get(new Object[]{sOptions.getContext()}).changeUriRuntimeAndReInstall(r4);
    }

    public static void setExecutor(ExecutorOptions r0) {
        ExecutorUtil.setExecutor(r0);
    }

    public static String addNetCommonParams(Context r1, String r2, boolean r3, Level r4) {
        return addNetCommonParams(r1, new StringBuilder(r2), r3, r4);
    }

    public static String addNetCommonParams(Context r1, StringBuilder r2, boolean r3, Level r4) {
        return ApiParamsUtil.appendNetParams(r1, r2, null, r3, r4);
    }

    public static String addNetCommonParams(Context r0, StringBuilder r1, String r2, boolean r3, Level r4) {
        return ApiParamsUtil.appendNetParams(r0, r1, r2, r3, r4);
    }

    public static void putCommonParams(Context r1, Map<String, String> r2, boolean r3, Level r4) {
        ApiParamsUtil.appendParamsToMap(r1, r3, null, r2, r4);
    }

    public static void setCommonExtraParam(IExtraParams r0) {
        ApiParamsUtil.setExtraParams(r0);
    }

    public static void addInstallListener(boolean r1, IInstallListener r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        CallbackCenter.register(r1, new InstallFinishCallback(r2));
    }

    public static void removeInstallListener(IInstallListener r0) {
        CallbackCenter.unregister(r0);
    }

    public static void addHeaderChangeListener(boolean r1, HeaderUpdateListener r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        CallbackCenter.register(r1, new HeaderUpdateCallback(r2));
    }

    public static void removeHeaderChangeListener(HeaderUpdateListener r0) {
        CallbackCenter.unregister(r0);
    }

    public static void addOaidObserver(boolean r1, IOaidObserver r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        CallbackCenter.register(r1, new OaidCallback(r2));
    }

    public static void removeOaidObserver(IOaidObserver r0) {
        CallbackCenter.unregister(r0);
    }

    public static void addOnDataObserver(IDataObserver r1) {
        DataObserverHolder.getInstance().addDataObserver(r1);
    }

    public static void removeOnDataObserver(IDataObserver r1) {
        DataObserverHolder.getInstance().removeDataObserver(r1);
    }

    public static void setUserUniqueId(Context r4, String r5) {
        HashMap r0 = new HashMap();
        r0.put(Api.KEY_USER_UNIQUE_ID, r5);
        service.get(new Object[]{r4}).updateHeader(r4, r0, true, true);
    }

    public static void setCustomHeader(Context r3, JSONObject r4) {
        HashMap r0 = new HashMap();
        r0.put("custom", r4);
        service.get(new Object[]{r3}).updateMemoryHeader(r3, r0);
    }

    public static void updateLanguageAndRegion(Context r3, String r4, String r5) {
        HashMap r0 = new HashMap();
        r0.put(Api.KEY_APP_LANGUAGE, r4);
        r0.put(Api.KEY_APP_REGION, r5);
        service.get(new Object[]{r3}).updateHeader(r3, r0, true, true);
    }

    public static void setUserAgent(Context r4, String r5) {
        if (r4 != null) goto L5;
        DrLog.e("context is null when setUserAgent");
        return;
    L5:
        HashMap r0 = new HashMap();
        r0.put(Api.KEY_USER_AGENT, r5);
        service.get(new Object[]{r4}).updateHeader(r4, r0, true, false);
    }

    public static void setAppTrack(Context r4, JSONObject r5) {
        if (r4 != null) goto L5;
        DrLog.e("context is null when setAppTrack");
        return;
    L5:
        HashMap r0 = new HashMap();
        if (r5 != null) goto L8;
        String r6 = null;
    L9:
        r0.put(Api.KEY_APP_TRACK, r6);
        service.get(new Object[]{r4}).updateHeader(r4, r0, true, false);
        return;
    L8:
        r6 = r5.toString();
        goto L9
    }

    public static void setAccount(Account r4) {
        service.get(new Object[]{sOptions.getContext()}).setAccount(r4);
    }

    public static JSONObject loadOrGetHeader() {
        return service.get(new Object[]{sOptions.getContext()}).loadOrGetHeader();
    }

    public static boolean getCurrentHeader(JSONObject r4) {
        return service.get(new Object[]{sOptions.getContext()}).getHeader(r4);
    L5:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public static void getSSIDs(Map<String, String> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        InstallInfo r0 = getInstallInfo();
        if (r0 != null) goto L7;
        return;
    L7:
        String r1 = r0.getDid();
        if (TextUtils.isEmpty(r1) == true) goto L10;
        r3.put("device_id", r1);
    L10:
        String r2 = r0.getIid();
        if (TextUtils.isEmpty(r2) == true) goto L13;
        r3.put(Api.KEY_INSTALL_ID, r2);
    L13:
        String r4 = r0.getOpenUdid();
        if (TextUtils.isEmpty(r4) == true) goto L16;
        r3.put(Api.KEY_OPEN_UDID, r4);
    L16:
        String r5 = r0.getClientUdid();
        if (TextUtils.isEmpty(r5) == true) goto L20;
        r3.put(Api.KEY_C_UDID, r5);
        return;
    }

    public static InstallInfo getInstallInfo() {
        if (sOptions != null) goto L5;
    L9:
        DrLog.e("BDInstall#getInstallInfo error, not init yet!");
        return tryGetFallbackInstallInfo(getAppContext());
    L5:
        if (sOptions.getContext() == null) goto L9;
        return service.get(new Object[]{sOptions.getContext()}).getInstallInfo();
    }

    public static String getDid() {
        if (sOptions != null) goto L5;
    L9:
        DrLog.e("BDInstall#getDid error, not init yet!");
        InstallInfo r0 = tryGetFallbackInstallInfo(getAppContext());
        if (r0 != null) goto L13;
        return null;
    L13:
        return r0.getDid();
    L5:
        if (sOptions.getContext() == null) goto L9;
        return service.get(new Object[]{sOptions.getContext()}).getDid();
    }

    private static InstallInfo tryGetFallbackInstallInfo(AppContext r3) {
        if (r3 == null) goto L5;
        Context r4 = r3.getContext();
    L6:
        if (r4 != null) goto L8;
        r4 = BDInstallProvider.getFallbackContext();
    L8:
        if (r4 != null) goto L11;
        return null;
    L11:
        return sInstallInfoBeforeInit.get(new Object[]{r4});
    L5:
        r4 = null;
        goto L6
    }

    public static InstallInfo waitingForInstallFinish(long r2) throws InterruptedException {
        InstallInfo r0 = getInstallInfo();
        if (r0 != null) goto L5;
    L10:
        sInstallLock.tryWaitingForInstallFinish(r2);
        return getInstallInfo();
    L5:
        if (TextUtils.isEmpty(r0.getDid()) == true) goto L10;
        if (TextUtils.isEmpty(r0.getIid()) == true) goto L10;
        return r0;
    }

    public static InstallInfo waitingForInstallFinishWithOldWay() throws InterruptedException {
        InstallInfo r0 = getInstallInfo();
        if (r0 != null) goto L5;
    L10:
        sInstallLock.tryWaitingForInstallFinishInOldWay();
        return getInstallInfo();
    L5:
        if (TextUtils.isEmpty(r0.getDid()) == true) goto L10;
        if (TextUtils.isEmpty(r0.getIid()) == true) goto L10;
        return r0;
    }

    public static boolean activeManually() {
        if (sOptions != null) goto L5;
    L9:
        return false;
    L5:
        if (sOptions.getContext() == null) goto L9;
        return service.get(new Object[]{sOptions.getContext()}).activeManually();
    }

    public static void setLogger(ILogger r0) {
        DrLog.setLogger(r0);
    }

    public static NUApi newUserMode() {
        INewUserModeService r0 = (INewUserModeService) ServiceManager.getService(INewUserModeService.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getApi();
    }

    public static boolean isNewUserMode() {
        INewUserModeService r0 = (INewUserModeService) ServiceManager.getService(INewUserModeService.class);
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isNewUserMode();
    }

    public static boolean isNewUserModeAvailable() {
        if (Class.forName(Constants.NAME_NEW_USER_IMPL) == null) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Deprecated
    public static boolean isNewUserFirstLaunch() {
        if (sOptions != null) goto L5;
    L9:
        return false;
    L5:
        if (sOptions.getContext() == null) goto L9;
        return service.get(new Object[]{sOptions.getContext()}).isNewUserFirstLaunch();
    }

    public static void setAppContext(AppContext r0) {
        sAppContext = r0;
    }

    public static AppContext getAppContext() {
        return sAppContext;
    }

    @Deprecated
    public static void setParamsFilter(IParamFilter r0) {
        sFilter = r0;
    }

    public static IParamFilter getParamsFilter() {
        return sFilter;
    }

    public static void setAdIdConfig(IAdIdConfig r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        sAdIdConfig = r0;
    }

    public static IAdIdConfig getAdIdConfig() {
        return sAdIdConfig;
    }

    static InstallOptions getInstallOptions() {
        return sOptions;
    }

    static void registerLifeCycleListener(Application r3) {
        if (r3 != null) goto L5;
        Log.e("DrLog", "application is null when registerLifeCycleListener");
        return;
    L5:
        service.get(new Object[]{r3}).registerLifeCycleListener(r3);
    }

    public static void clearAndSetEnv(Env r4) {
        service.get(new Object[]{sOptions.getContext()}).clearAndSetEnv(r4);
    }

    public static void resetAndReInstall(Context r7, Env r8, long r9, OnResetListener r11) {
        service.get(new Object[]{r7}).resetAndReInstall(r7, r8, r9, r11);
    }
}
