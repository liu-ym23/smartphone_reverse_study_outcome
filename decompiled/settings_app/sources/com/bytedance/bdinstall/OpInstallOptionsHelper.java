package com.bytedance.bdinstall;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
final class OpInstallOptionsHelper implements IInstallListener {
    private static final String kEY_INSTALL_INFO = "install_info";
    private final Context mContext;

    interface OnDataChangedListener {
        void onInstallInfoChanged(InstallInfo r1);
    }

    OpInstallOptionsHelper(Context r1) {
        this.mContext = r1;
    }

    void trySync() {
        BDInstall.addInstallListener(true, this);
    }

    void startObserver(Context r2, final OnDataChangedListener r3) {
        SubpSyncManager.inst(r2).observer(kEY_INSTALL_INFO, new AnonymousClass1(this, r3));
    }

    @Override // com.bytedance.bdinstall.IInstallListener
    public void installFinished(InstallInfo r2) {
        SubpSyncManager.inst(this.mContext).sendSubpEvent(kEY_INSTALL_INFO, r2.toJson().toString());
    }

    InstallInfo getSavedInstallInfo() {
        return InstallInfo.parse(this.mContext.getSharedPreferences("ug_install_op_pref", 0).getString(kEY_INSTALL_INFO, null));
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
