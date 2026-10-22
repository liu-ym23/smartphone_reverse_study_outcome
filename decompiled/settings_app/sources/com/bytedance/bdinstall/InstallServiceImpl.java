package com.bytedance.bdinstall;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.appstate.AppLifeCycleListener;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.callback.event.HeaderChangeEvent;
import com.bytedance.bdinstall.loader.DeviceManager;
import com.bytedance.bdinstall.loader.LocaleDeviceManager;
import com.bytedance.bdinstall.service.IInstallService;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.Constants;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.TimeoutInstallListener;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class InstallServiceImpl implements IInstallService {
    private volatile DeviceManager mDeviceManager;
    private volatile InstallDispatcher mInstallDispatcher;
    private final AtomicBoolean mRegistered;
    private final AppLifeCycleListener sAppLifeCycleListener;
    private volatile InstallOptions sOptions;
    private final AtomicBoolean sStarted;

    static /* synthetic */ void access$000(InstallServiceImpl r0, boolean r1) {
        r0.doStart(r1);
    }

    static /* synthetic */ InstallDispatcher access$100(InstallServiceImpl r0) {
        return r0.mInstallDispatcher;
    }

    static /* synthetic */ DeviceManager access$200(InstallServiceImpl r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ AtomicBoolean access$300(InstallServiceImpl r0) {
        return r0.sStarted;
    }

    static /* synthetic */ void access$400(InstallServiceImpl r0) {
        r0.setStarted();
    }

    static /* synthetic */ InstallOptions access$500(InstallServiceImpl r0) {
        return r0.sOptions;
    }

    InstallServiceImpl() {
        this.sStarted = new AtomicBoolean(false);
        this.sAppLifeCycleListener = new AppLifeCycleListener();
        this.mRegistered = new AtomicBoolean(false);
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void init(InstallOptions r9, Env r10) {
        long r0 = System.currentTimeMillis();
        DrLog.d("main process install#init");
        monitor-enter(InstallServiceImpl.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.mInstallDispatcher != null) goto L15;
        this.sOptions = r9;     // Catch: Throwable -> L18
        DrLog.DEBUG = r9.isDebuggable();     // Catch: Throwable -> L18
        if (r9.getLogger() == null) goto L10;
        DrLog.setLogger(r9.getLogger());     // Catch: Throwable -> L18
    L10:
        if (TextUtils.equals(r9.getChannel(), "local_test") == true) goto L21;
    L14:
        this.mDeviceManager = new LocaleDeviceManager(r9.getContext(), r9, r10);     // Catch: Throwable -> L18
        this.mInstallDispatcher = new InstallDispatcher(r9, this.mDeviceManager, this.sAppLifeCycleListener, r10);     // Catch: Throwable -> L18
        ServiceManager.registerService(DeviceTokenService.class, new DeviceTokenServiceImpl(r9.getContext(), r10));     // Catch: Throwable -> L18
        goto L15
    L21:
        ServiceManager.registerService(INewUserModeService.class, (INewUserModeService) Class.forName(Constants.NAME_NEW_USER_IMPL).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r9.getContext()}));     // Catch: Throwable -> L13
    L13:
        DrLog.e("not find new user mode impl ,ignore");     // Catch: Throwable -> L18
    L15:
        monitor-exit(InstallServiceImpl.class);     // Catch: Throwable -> L18
        DrLog.d("init ：" + (System.currentTimeMillis() - r0));
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void start() {
        if (hasInit() == false) goto L7;
        DrLog.d("install#start");
        ExecutorUtil.runOnHandlerThread(new AnonymousClass1(this));
        setStarted();
        return;
    L7:
        throw new RuntimeException("please init first");
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void reStart() {
        if (hasInit() == false) goto L9;
        DrLog.d("install#reStart");
        if (this.mInstallDispatcher == null) goto L10;
        this.mInstallDispatcher.reStart(this.mDeviceManager.getCurEnv(), true, false);
        return;
    L10:
        return;
    L9:
        throw new RuntimeException("please init first");
    }

    private void setStarted() {
        if (LocalConstants.getCommonSp(this.sOptions.getContext()).getBoolean(Api.KEY_STARTED, false) == true) goto L6;
        LocalConstants.getCommonSp(this.sOptions.getContext()).edit().putBoolean(Api.KEY_STARTED, true).apply();
        return;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void registerLifeCycleListener(Application r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.mRegistered.compareAndSet(false, true) == false) goto L8;
        r4.registerActivityLifecycleCallbacks(this.sAppLifeCycleListener);
        return;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void clearAndSetEnv(final Env r3) {
        DrLog.d("install#clearInstallInfoWhenSwitchChildMode");
        if (this.mInstallDispatcher == null) goto L5;
        DrLog.d("clearInstallInfoWhenSwitchChildMode " + r3);
        ExecutorUtil.runOnHandlerThread(new AnonymousClass2(this, r3));
        return;
    L5:
        DrLog.ysnp(new RuntimeException("not init yet"));
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void resetAndReInstall(Context r2, final Env r3, long r4, OnResetListener r6) {
        DrLog.d("install#resetInstallInfoWhenSwitchChildMode");
        if (this.mInstallDispatcher == null) goto L5;
        DrLog.d("resetInstallInfoWhenSwitchChildMode " + r3);
        TimeoutInstallListener r5 = new TimeoutInstallListener(r4, r6);
        BDInstall.addInstallListener(false, r5);
        r5.startTiming();
        ExecutorUtil.runOnHandlerThread(new AnonymousClass3(this, r3));
        return;
    L5:
        DrLog.ysnp(new RuntimeException("not init yet"));
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void changeUriRuntimeAndReInstall(final Env r3) {
        DrLog.d("install#changeUriRuntimeAndReInstall");
        if (this.mInstallDispatcher == null) goto L5;
        DrLog.d("changeUriRuntimeAndReInstall " + r3);
        ExecutorUtil.runOnHandlerThread(new AnonymousClass4(this, r3));
        return;
    L5:
        DrLog.ysnp(new RuntimeException("not init yet"));
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public InstallInfo getInstallInfo() {
        if (this.mDeviceManager != null) goto L7;
        return null;
    L7:
        return this.mDeviceManager.getInstallInfo();
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public String getDid() {
        if (this.mDeviceManager != null) goto L7;
        return null;
    L7:
        return this.mDeviceManager.getDid();
    }

    private boolean hasInit() {
        if (this.mInstallDispatcher == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void doStart(boolean r3) {
        if (hasInit() == false) goto L13;
        if (this.sStarted.getAndSet(true) == false) goto L7;
        return;
    L7:
        INewUserModeService r0 = (INewUserModeService) ServiceManager.getService(INewUserModeService.class);
        if (r0 == null) goto L10;
        r0.start();
    L10:
        this.mDeviceManager.start();
        this.mInstallDispatcher.start(r3);
        new OpInstallOptionsHelper(this.sOptions.getContext()).trySync();
        return;
    L13:
        throw new RuntimeException("please init first");
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void updateMemoryHeader(Context r5, Map<String, Object> r6) {
        if (this.mDeviceManager == null) goto L19;
        Iterator<Map.Entry<String, Object>> r7 = r6.entrySet().iterator();
    L5:
        boolean r0 = false;
    L7:
        if (r7.hasNext() == false) goto L12;
        Map.Entry<String, Object> r1 = r7.next();
        if (this.mDeviceManager.updateHeader(r1.getKey(), r1.getValue()) == true) goto L11;
        if (r0 == false) goto L5;
    L11:
        r0 = true;
        goto L7
    L12:
        if (r0 == false) goto L20;
        CallbackCenter.postEvent(new HeaderChangeEvent(this.mDeviceManager.getConstHeader()));
        return;
    L20:
        return;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void updateHeader(Context r5, Map<String, String> r6, boolean r7, boolean r8) {
        SharedPreferences r9 = LocalConstants.getCommonSp(r5);
        if (r7 == false) goto L5;
        SharedPreferences.Editor r10 = r9.edit();
    L6:
        boolean r0 = false;
        if (this.mDeviceManager == null) goto L22;
        Iterator<Map.Entry<String, String>> r11 = r6.entrySet().iterator();
        boolean r12 = false;
    L10:
        if (r11.hasNext() == false) goto L19;
        Map.Entry<String, String> r1 = r11.next();
        String r2 = r1.getKey();
        String r3 = r1.getValue();
        if (this.mDeviceManager.updateHeader(r2, r3) == true) goto L16;
        if (r12 == true) goto L16;
        r12 = false;
    L17:
        if (r10 == null) goto L10;
        r10.putString(r2, r3);
    L16:
        r12 = true;
        goto L17
    L19:
        if (r10 == null) goto L21;
        r10.apply();
    L21:
        r0 = r12;
    L22:
        if (r0 == false) goto L27;
        if (r8 == false) goto L27;
        if (this.mInstallDispatcher == null) goto L27;
        this.mInstallDispatcher.redoRegister();
    L27:
        if (r0 == false) goto L35;
        CallbackCenter.postEvent(new HeaderChangeEvent(this.mDeviceManager.getConstHeader()));
        return;
    L35:
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean activeManually() {
        DrLog.d("install#activeManually");
        if (hasInit() == false) goto L6;
        ExecutorUtil.runOnHandlerThread(new AnonymousClass5(this));
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void setAccount(final Account r2) {
        ExecutorUtil.runOnHandlerThread(new AnonymousClass6(this, r2));
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public JSONObject loadOrGetHeader() {
        if (hasInit() == false) goto L7;
        JSONObject r1 = this.mDeviceManager.loadOrGetHeader();
        JSONObject r0 = new JSONObject();
        Utils.copy(r0, r1);
        return r0;
    L7:
        throw new IllegalStateException("please call after init");
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean getHeader(JSONObject r2) {
        if (this.mDeviceManager == null) goto L8;
        JSONObject r1 = this.mDeviceManager.getHeader();
        if (r1 == null) goto L10;
        Utils.copy(r2, r1);
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean isNewUserFirstLaunch() {
        if (this.mDeviceManager != null) goto L5;
        return false;
    L5:
        return this.mDeviceManager.isNewUser();
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public Env getCurEnv() {
        return this.mDeviceManager.getCurEnv();
    }
}
