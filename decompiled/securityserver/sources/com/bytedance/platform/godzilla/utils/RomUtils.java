package com.bytedance.platform.godzilla.utils;

import a.a;
import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class RomUtils {
    private static final CharSequence AMIGO = null;

    static {
        AMIGO = "amigo";
    }

    private RomUtils() {
    }

    public static boolean isAmigo() {
        String r0 = Build.DISPLAY;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L7:
        return false;
    L5:
        if (r0.toLowerCase(Locale.getDefault()).contains(AMIGO) == false) goto L7;
        return true;
    }

    public static boolean isColorOS() {
        String r0 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        return a.z(r0, "oppo");
    }
}
