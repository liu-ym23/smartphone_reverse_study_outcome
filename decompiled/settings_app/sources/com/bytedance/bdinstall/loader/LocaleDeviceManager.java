package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.ExecutorUtil;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.util.RomUtils;

/* JADX INFO: loaded from: classes3.dex */
public class LocaleDeviceManager extends DeviceManager {
    public LocaleDeviceManager(Context r1, InstallOptions r2, Env r3) {
        super(r1, r2, r3);
    }

    @Override // com.bytedance.bdinstall.loader.DeviceManager
    protected void migrate() {
        super.migrate();
        if (BDInstall.getAdIdConfig().enablePrefetchAdId() == false) goto L6;
        Oaid.instance(this.mApp).init();
        return;
    }

    @Override // com.bytedance.bdinstall.loader.DeviceManager
    public void start() {
        super.start();
        if (this.mOptions.isNeedSharedStorage() == false) goto L5;
        return;
    L5:
        if (this.mOptions.deleteSharedStorage() == true) goto L7;
        return;
    L7:
        if (RomUtils.isAndroidROrHigher() == true) goto L9;
    L12:
        ExecutorUtil.runOnIOExecutor(new DeprecatedFileCleaner(this.mOptions));
        return;
    L9:
        if (RomUtils.isTargetROrHigher(this.mApp) == false) goto L12;
        DrLog.d("target r, not clean");
    }
}
