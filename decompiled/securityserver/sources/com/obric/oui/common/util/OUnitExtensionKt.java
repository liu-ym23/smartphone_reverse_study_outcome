package com.obric.oui.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OUnitExtensionKt {
    public static final int a(int r2) {
        Resources r0 = Resources.getSystem();
        Intrinsics.e(r0, "Resources.getSystem()");
        return (int) ((r2 * r0.getDisplayMetrics().density) + 0.5f);
    }

    public static final int b(Context r1) {
        Intrinsics.f(r1, "$this$getScreenHeight");
        Resources r2 = r1.getResources();
        Intrinsics.e(r2, "resources");
        DisplayMetrics r3 = r2.getDisplayMetrics();
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.heightPixels;
    }

    public static final int c(Context r1) {
        Intrinsics.f(r1, "$this$getScreenWidth");
        Resources r2 = r1.getResources();
        Intrinsics.e(r2, "resources");
        DisplayMetrics r3 = r2.getDisplayMetrics();
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.widthPixels;
    }
}
