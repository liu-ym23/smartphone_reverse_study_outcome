package com.obric.oui.common.util;

import android.content.Context;
import android.content.res.Resources;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ResourceUtils {
    public static boolean a(Context r3) {
        Resources r4 = r3.getResources();     // Catch: Exception -> L7
        Intrinsics.e(r4, "context.resources");     // Catch: Exception -> L7
        if (r4.getConfiguration().orientation != 2) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        L.c("ResourceUtils", "isLandscape error", e);
        return false;
    }
}
