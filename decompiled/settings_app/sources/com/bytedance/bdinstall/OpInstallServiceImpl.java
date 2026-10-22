package com.bytedance.bdinstall;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.callback.event.InstallFinishEvent;
import com.bytedance.bdinstall.service.IInstallService;
import com.bytedance.bdinstall.service.ServiceManager;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class OpInstallServiceImpl implements IInstallService, OpInstallOptionsHelper.OnDataChangedListener {
    private InstallInfo mInstallInfo;

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean activeManually() {
        return false;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void changeUriRuntimeAndReInstall(Env r1) {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void clearAndSetEnv(Env r1) {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public Env getCurEnv() {
        return null;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean getHeader(JSONObject r1) {
        return false;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean isNewUserFirstLaunch() {
        return false;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public JSONObject loadOrGetHeader() {
        return null;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void reStart() {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void resetAndReInstall(Context r1, Env r2, long r3, OnResetListener r5) {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void setAccount(Account r1) {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void start() {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void updateHeader(Context r1, Map<String, String> r2, boolean r3, boolean r4) {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void updateMemoryHeader(Context r1, Map<String, Object> r2) {
    }

    OpInstallServiceImpl() {
        DrLog.d("OTHER PROCESS IMPL");
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void init(InstallOptions r2, Env r3) {
        new OpInstallOptionsHelper(r2.getContext()).startObserver(r2.getContext(), this);
        Cdid.get(r2.getContext());
        ServiceManager.registerService(DeviceTokenService.class, new CpDeviceTokenServiceImpl(r2.getContext()));
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public InstallInfo getInstallInfo() {
        InstallInfo r0 = this.mInstallInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.clone();
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public String getDid() {
        InstallInfo r0 = this.mInstallInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDid();
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void registerLifeCycleListener(Application r1) {
        throw new IllegalStateException("BdInstall process is wrong");
    }

    @Override // com.bytedance.bdinstall.OpInstallOptionsHelper.OnDataChangedListener
    public void onInstallInfoChanged(InstallInfo r3) {
        DrLog.d("install info changed : " + r3);
        this.mInstallInfo = r3;
        CallbackCenter.postEvent(new InstallFinishEvent(r3));
    }
}
