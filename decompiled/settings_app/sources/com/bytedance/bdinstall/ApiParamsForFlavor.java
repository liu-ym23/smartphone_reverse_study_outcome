package com.bytedance.bdinstall;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.loader.AliYunUUIDHandler;
import com.bytedance.bdinstall.loader.SstLoader;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.util.SensitiveUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class ApiParamsForFlavor {
    ApiParamsForFlavor() {
    }

    static void addSstParams(Context r2, Map<String, String> r3, boolean r4, InstallOptions r5) {
        if (r5 != null) goto L4;
    L11:
        String r6 = AliYunUUIDHandler.inst().getCloudUUID();
        if (TextUtils.isEmpty(r6) == true) goto L14;
        r3.put("aliyun_uuid", r6);
    L14:
        if (r4 == false) goto L24;
        String r7 = Oaid.instance(r2).getOaidId();     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r7) == true) goto L25;
        r3.put("oaid", r7);     // Catch: Throwable -> L19
        return;
    L25:
        return;
    L19:
        th = move-exception;
        th.printStackTrace();
        return;
    L24:
        return;
    L4:
        if (r5.isTouristMode() == true) goto L11;
        String r0 = SensitiveUtils.getMacAddress(r2);
        if (TextUtils.isEmpty(r0) == true) goto L8;
        r3.put("mac_address", r0);
    L8:
        String r8 = SensitiveUtils.getDeviceIdWithCache(r2, r5);
        if (Utils.isBadId(r8) == true) goto L11;
        r3.put("uuid", r8);
        goto L11
    }

    static void addActiveParams(Context r3, InstallOptions r4, StringBuilder r5) {
        if (r4.isTouristMode() == true) goto L15;
        Api.addParams(r5, SstLoader.KEY_BUILD_SERIAL, SensitiveUtils.getSerialNumber(r3, r4));
        if (r4.reportPhoneDetailInfo() == false) goto L15;
        String[] r6 = SensitiveUtils.getSimSerialNumbers(r3, r4);
        if (r6 == null) goto L15;
        if (r6.length <= 0) goto L15;
        String r0 = r6[0];
        int r1 = 1;
    L12:
        if (r1 >= r6.length) goto L14;
        r0 = r0 + "," + r6[r1];
        r1 = r1 + 1;
        goto L12
    L14:
        Api.addParams(r5, SstLoader.KEY_SIM_SERIAL_NUMBER, r0);
    L15:
        Oaid.instance(r3).getOaidId();
    }

    public static void addCommonParams(boolean r0, Context r1) {
        if (r0 == true) goto L4;
        return;
    L4:
        if (BDInstall.getAdIdConfig().enablePrefetchAdId() == false) goto L8;
        Oaid.instance(r1).init();
        return;
    }
}
