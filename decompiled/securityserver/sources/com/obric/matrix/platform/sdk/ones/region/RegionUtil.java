package com.obric.matrix.platform.sdk.ones.region;

import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class RegionUtil {

    @NotNull
    public static final RegionUtil INSTANCE = null;

    @NotNull
    private static final String REGION_KEY = "ro.vendor.feature.zte_feature_abroad";

    @NotNull
    private static final String TARGET_NON_EEA = "NON_EEA";

    static {
        INSTANCE = new RegionUtil();
    }

    private RegionUtil() {
    }

    private final String getSystemProperty(String r4) {
        String r1 = null;
        Object r3 = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r4, ""});     // Catch: Exception -> L10
        if ((r3 instanceof String) == false) goto L6;
        r1 = (String) r3;     // Catch: Exception -> L10
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L14:
        return "";
    }

    private final boolean isNonEeaRegion(String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        String r4 = StringsKt.J(r3).toString();
        if (r4.length() > 0) goto L8;
        return false;
    L8:
        if (StringsKt.p(r4, TARGET_NON_EEA, true) == true) goto L10;
        return false;
    L10:
        return true;
    }

    @NotNull
    public final Region getRegion() {
        if (isNonEeaRegion(getSystemProperty(REGION_KEY)) == false) goto L6;
        return Region.HK;
    L6:
        return Region.CN;
    }

    public final boolean isCN() {
        if (getRegion() != Region.CN) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isHK() {
        if (getRegion() != Region.HK) goto L5;
        return true;
    L5:
        return false;
    }
}
