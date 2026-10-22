package com.obric.oui.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.appcompat.app.AppCompatDelegate;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ActivityUtils {
    public static final void a(Activity r6) {
        Intrinsics.f(r6, "$this$adaptLightDarkStatusBar");
        Window r7 = r6.getWindow();
        if (r7 == null) goto L5;
        WindowInsetsController r8 = r7.getInsetsController();
    L6:
        if (r8 == null) goto L23;
        Resources r0 = Resources.getSystem();
        Intrinsics.e(r0, "Resources.getSystem()");
        int r1 = r0.getConfiguration().uiMode & 48;
        boolean r2 = true;
        if (r1 != 32) goto L10;
        boolean r3 = true;
    L11:
        L.a("ActivityUtils", "isSystemInDarkTheme: " + r3 + ", currentNightMode" + r1);
        if (r3 == false) goto L14;
    L21:
        r8.setSystemBarsAppearance(0, 8);
        return;
    L14:
        if (AppCompatDelegate.getDefaultNightMode() == 2) goto L17;
        r2 = false;
    L17:
        L.a("ActivityUtils", "isAppInDarkTheme: " + r2);
        if (r2 == true) goto L21;
        r8.setSystemBarsAppearance(8, 8);
        return;
    L10:
        r3 = false;
        goto L11
    L23:
        return;
    L5:
        r8 = null;
        goto L6
    }
}
