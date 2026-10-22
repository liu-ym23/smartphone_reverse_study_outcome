package com.android.settings.fuelgauge.appBatteryUseOptimization.apppoweruse;

import com.android.settings.utils.HanziToPinyin;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AppPowerProfileData.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"toAppPowerProfileData", "Lcom/android/settings/fuelgauge/appBatteryUseOptimization/apppoweruse/AppPowerProfileData;", "logStr", "", "app_neridaCnRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class AppPowerProfileDataKt {
    public static final AppPowerProfileData toAppPowerProfileData(String r15) {
        String r0 = "";
        Intrinsics.checkNotNullParameter(r15, "logStr");
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r16 = StringsKt.split$default(r15, new String[]{HanziToPinyin.Token.SEPARATOR}, false, 0, 6, null).iterator();
    L3:
        int r3 = 0;
        if (r16.hasNext() == true) goto L36;
        String r17 = (String) r1.get("pkgName");     // Catch: Exception -> L27
        if (r17 == null) goto L12;
        r0 = r17;
    L12:
        String r18 = (String) r1.get("power(mAh)");     // Catch: Exception -> L27
        if (r18 == null) goto L16;
        int r19 = Integer.parseInt(r18);     // Catch: Exception -> L27
    L32:
        String r2 = (String) r1.get("fgDun(s)");     // Catch: Exception -> L26
        if (r2 == null) goto L21;
        int r4 = Integer.parseInt(r2);     // Catch: Exception -> L26
    L34:
        String r5 = (String) r1.get("bgDun(s)");     // Catch: Exception -> L31
        if (r5 == null) goto L29;
        r3 = Integer.parseInt(r5);     // Catch: Exception -> L31
    L29:
        return new AppPowerProfileData(r0, null, null, r19, 0.0f, r4, r3, null, 150, null);
    L21:
        r4 = 0;
    L26:
        r4 = 0;
        goto L29
    L16:
        r19 = 0;
    L27:
        r19 = 0;
        r4 = 0;
        goto L29
    L36:
        List r6 = StringsKt.split$default((String) r16.next(), new String[]{":"}, false, 0, 6, null);     // Catch: Exception -> L30
        r1.put((String) r6.get(0), (String) r6.get(1));     // Catch: Exception -> L30
        goto L3
    }
}
