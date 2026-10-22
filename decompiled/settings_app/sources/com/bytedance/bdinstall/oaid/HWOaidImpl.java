package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.util.Singleton;

/* JADX INFO: loaded from: classes3.dex */
final class HWOaidImpl implements OaidApi {
    private static final String ACTION = "com.uodis.opendevice.OPENIDS_SERVICE";
    private static final String HWID = "com.huawei.hwid";
    private static final Singleton<Boolean> support = null;

    static class HWOaid extends OaidApi.Result {
        long versionCode;

        HWOaid() {
            this.versionCode = 0;
        }
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Huawei";
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public /* bridge */ /* synthetic */ OaidApi.Result getOaid(Context r1) {
        return getOaid(r1);
    }

    static {
        support = new AnonymousClass1();
    }

    HWOaidImpl() {
    }

    static boolean isSupport(Context r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        return support.get(new Object[]{r3}).booleanValue();
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r1) {
        return isSupport(r1);
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public HWOaid getOaid(Context r4) {
        HWOaid r3 = new HWOaid();
        String r0 = Settings.Global.getString(r4.getContentResolver(), "pps_oaid");     // Catch: Throwable -> L7
        String r1 = Settings.Global.getString(r4.getContentResolver(), "pps_track_limit");     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r0) == true) goto L9;
        r3.oaid = r0;     // Catch: Throwable -> L7
        r3.isTrackLimit = Boolean.parseBoolean(r1);     // Catch: Throwable -> L7
        r3.versionCode = 202003021704L;     // Catch: Throwable -> L7
        return r3;
    L9:
        Pair<String, Boolean> r2 = tryFetchResult(r4);
        if (r2 == null) goto L12;
        r3.oaid = (String) r2.first;
        r3.isTrackLimit = ((Boolean) r2.second).booleanValue();
        r3.versionCode = getHwIdVersionCode(r4);
    L12:
        return r3;
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    private static int getHwIdVersionCode(Context r2) {
        PackageInfo r3 = r2.getPackageManager().getPackageInfo(HWID, 0);     // Catch: PackageManager.NameNotFoundException -> L7
        if (r3 == null) goto L12;
        return r3.versionCode;
    L12:
        return 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    private static Pair<String, Boolean> tryFetchResult(Context r3) {
        return (Pair) new ServiceBlockBinder(r3, new Intent(ACTION).setPackage(HWID), new AnonymousClass2()).blockFetchResult();
    }
}
