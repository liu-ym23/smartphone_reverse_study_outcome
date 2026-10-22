package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.BuildConfig;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.PreInstallChannelCallback;
import com.bytedance.bdinstall.migrate.MigrateDetector;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.RequestIdGenerator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DRSpecialLoader {
    private static final String KEY_FIRST_INSTALL_TIME = "apk_first_install_time";
    private static final String KEY_GIT_HASH = "git_hash";
    private static final String KEY_IS_SYSTEM_APP = "is_system_app";
    private static final String KEY_PRE_INSTALL_CHANNEL = "pre_installed_channel";
    private final InstallOptions mOptions;

    DRSpecialLoader(InstallOptions r1) {
        this.mOptions = r1;
    }

    protected boolean doLoad(JSONObject r2, Env r3) throws JSONException, SecurityException {
        if (r3.isChildMode() == false) goto L5;
        r2.put("scene", 2);
    L5:
        r2.put("device_platform", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        new HarmonyLoader().doLoad(r2);
        r2.put(KEY_GIT_HASH, BuildConfig.GIT_HASH);
        r2.put(Api.KEY_SDK_VERSION_CODE, DrLog.SDK_VERSION_CODE);
        r2.put(Api.KEY_SDK_TARGET_VERSION, 30);
        r2.put("req_id", RequestIdGenerator.getRequestId());
        r2.put("sdk_version", BuildConfig.VERSION_NAME);
        r2.put("guest_mode", this.mOptions.isTouristMode() ? 1 : 0);
        r2.put("sdk_flavor", BuildConfig.FLAVOR);
        if (MigrateDetector.isThisDeviceMigrate(this.mOptions.getContext()) == false) goto L14;
        String r4 = MigrateDetector.getOldDid(this.mOptions.getContext());
        if (TextUtils.isEmpty(r4) == false) goto L19;
        r4 = "";
    L19:
        r2.put(Api.KEY_OLD_DID, r4);     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        addPreInstallInfo(r2);
        INewUserModeService r1 = (INewUserModeService) ServiceManager.getService(INewUserModeService.class);
        if (r1 == null) goto L21;
        r1.addNewUserModeExtra(r2);
        return true;
    L21:
        return true;
    }

    private void addPreInstallInfo(JSONObject r5) throws JSONException {
        Context r0 = this.mOptions.getContext();
        PreInstallChannelCallback r4 = this.mOptions.getPreInstallChannelCallback();
        if (r4 == null) goto L19;
        r5.put(KEY_PRE_INSTALL_CHANNEL, r4.getChannel(r0));
    L19:
        int r1 = 0;
        PackageInfo r6 = r0.getPackageManager().getPackageInfo(r0.getPackageName(), 0);     // Catch: Throwable -> L16
        if (r6 == null) goto L21;
        r5.put(KEY_FIRST_INSTALL_TIME, r6.firstInstallTime);     // Catch: Throwable -> L16
        if ((r6.applicationInfo.flags & 1) != 1) goto L10;
        boolean r7 = true;
    L12:
        if (r7 == false) goto L14;
        r1 = 1;
    L14:
        r5.put(KEY_IS_SYSTEM_APP, r1);     // Catch: Throwable -> L16
        return;
    L10:
        r7 = false;
        goto L12
    L21:
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
    }
}
