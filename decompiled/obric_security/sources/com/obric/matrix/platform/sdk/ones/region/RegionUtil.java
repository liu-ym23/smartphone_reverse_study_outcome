package com.obric.matrix.platform.sdk.ones.region;

import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RegionUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/region/RegionUtil;", "", "()V", "REGION_KEY", "", "TARGET_NON_EEA", "getRegion", "Lcom/obric/matrix/platform/sdk/ones/region/Region;", "getSystemProperty", "key", "isCN", "", "isHK", "isNonEeaRegion", "value", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RegionUtil {
    public static final RegionUtil INSTANCE = null;
    private static final String REGION_KEY = "ro.vendor.feature.zte_feature_abroad";
    private static final String TARGET_NON_EEA = "NON_EEA";

    static {
        INSTANCE = new RegionUtil();
    }

    private RegionUtil() {
    }

    public final Region getRegion() {
        if (isNonEeaRegion(getSystemProperty(REGION_KEY)) == false) goto L6;
        return Region.HK;
    L6:
        return Region.CN;
    }

    private final boolean isNonEeaRegion(String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        String r4 = StringsKt.trim(r3).toString();
        if (r4.length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        return false;
    L11:
        if (StringsKt.equals(r4, TARGET_NON_EEA, true) == true) goto L13;
        return false;
    L13:
        return true;
    L8:
        r0 = false;
        goto L9
    }

    public final boolean isHK() {
        if (getRegion() != Region.HK) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isCN() {
        if (getRegion() != Region.CN) goto L5;
        return true;
    L5:
        return false;
    }

    private final String getSystemProperty(String r8) {
        Object[] r1 = {r8, ""};     // Catch: Exception -> L10
        String r9 = null;
        Object r0 = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, r1);     // Catch: Exception -> L10
        if ((r0 instanceof String) == false) goto L6;
        r9 = (String) r0;     // Catch: Exception -> L10
    L6:
        if (r9 != null) goto L9;
        return "";
    L9:
        return r9;
    L14:
        return "";
    }
}
