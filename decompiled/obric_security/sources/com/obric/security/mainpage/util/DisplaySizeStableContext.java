package com.obric.security.mainpage.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import com.bytedance.apm.constant.TraceStatsConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisplaySizeStableContext.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¨\u0006\u000b"}, d2 = {"Lcom/obric/security/mainpage/util/DisplaySizeStableContext;", "", "()V", "create", "Landroid/content/Context;", TraceStatsConsts.STATS_BASE_MODULE, "dpToPx", "", "value", "", "resolveDisplaySizeIndependentDensity", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class DisplaySizeStableContext {
    public static final DisplaySizeStableContext INSTANCE = null;

    static {
        INSTANCE = new DisplaySizeStableContext();
    }

    private DisplaySizeStableContext() {
    }

    public final Context create(Context r4) {
        Intrinsics.checkNotNullParameter(r4, TraceStatsConsts.STATS_BASE_MODULE);
        Resources r1 = r4.getResources();
        Intrinsics.checkNotNullExpressionValue(r1, "base.resources");
        Configuration r0 = new Configuration(r1.getConfiguration());
        r0.densityDpi = resolveDisplaySizeIndependentDensity(r4);
        r0.fontScale = 1.0f;
        Context r3 = r4.createConfigurationContext(r0);
        Intrinsics.checkNotNullExpressionValue(r3, "it");
        r3.getTheme().setTo(r4.getTheme());
        Intrinsics.checkNotNullExpressionValue(r3, "base.createConfiguration…tTo(base.theme)\n        }");
        return r3;
    }

    public final int dpToPx(Context r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, TraceStatsConsts.STATS_BASE_MODULE);
        return (int) ((r3 * (resolveDisplaySizeIndependentDensity(r2) / 160)) + 0.5f);
    }

    private final int resolveDisplaySizeIndependentDensity(Context r7) {
        int r6 = DisplayMetrics.DENSITY_DEVICE_STABLE;
        Display r8 = r7.getDisplay();
        if (r8 != null) goto L5;
        return r6;
    L5:
        Intrinsics.checkNotNullExpressionValue(r8, "base.display ?: return stableDensity");
        DisplayMetrics r0 = new DisplayMetrics();
        r8.getRealMetrics(r0);
        int r1 = Math.max(r0.widthPixels, r0.heightPixels);
        Display.Mode[] r9 = r8.getSupportedModes();
        int r2 = r9.length;
        int r3 = 0;
        int r4 = r1;
    L6:
        if (r3 >= r2) goto L8;
        Display.Mode r5 = r9[r3];
        r4 = Math.max(r4, Math.max(r5.getPhysicalWidth(), r5.getPhysicalHeight()));
        r3 = r3 + 1;
        goto L6
    L8:
        if (r4 <= 0) goto L14;
        if (r1 > 0) goto L12;
        return r6;
    L12:
        return (int) ((r6 * (r1 / r4)) + 0.5f);
    L14:
        return r6;
    }
}
