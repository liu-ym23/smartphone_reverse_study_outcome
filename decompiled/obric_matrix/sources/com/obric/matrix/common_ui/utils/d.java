package com.obric.matrix.common_ui.utils;

import android.graphics.Color;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0004\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\b\u001a\u00020\t\u001a\u0012\u0010\n\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\b\u001a\u00020\t\u001a\u0012\u0010\u000b\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\b\u001a\u00020\t\u001a\u0012\u0010\f\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\r\u001a\u00020\u0003\u001a\u0012\u0010\u000e\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010\u0011\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\r\u001a\u00020\u0003\u001a\u0012\u0010\u0012\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010\u0013\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010\u0014\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\b\u001a\u00020\t\u001a\u0012\u0010\u0015\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\b\u001a\u00020\t\u001a\u0012\u0010\u0016\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\b\u001a\u00020\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"TAG", "", "getNavigationBarHeight", "", "Landroidx/fragment/app/FragmentActivity;", "getStatusBarHeight", "setupImmersiveNavigationBars", "", "light", "", "setupImmersiveStatusBars", "setupImmersiveSystemBars", "setupNavigationBarColor", TypedValues.Custom.S_COLOR, "setupNavigationBarPadding", "viewGroup", "Landroid/view/ViewGroup;", "setupStatusBarColor", "setupStatusBarPadding", "setupSystemBarsPadding", "setupTransparentNavigationBars", "setupTransparentStatusBars", "setupTransparentSystemBars", "common_ui_cnRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class d {
    public static final void a(FragmentActivity r3, boolean r4) {
        o.f(r3, "<this>");
        WindowCompat.setDecorFitsSystemWindows(r3.getWindow(), false);
        r3.getWindow().setNavigationBarColor(Color.argb(1, 255, 255, 255));
        WindowInsetsControllerCompat r5 = WindowCompat.getInsetsController(r3.getWindow(), r3.getWindow().getDecorView());
        o.e(r5, "getInsetsController(window, window.decorView)");
        r5.setAppearanceLightNavigationBars(r4);
    }

    public static final void b(FragmentActivity r3, boolean r4) {
        o.f(r3, "<this>");
        WindowCompat.setDecorFitsSystemWindows(r3.getWindow(), false);
        r3.getWindow().setStatusBarColor(Color.argb(1, 255, 255, 255));
        WindowInsetsControllerCompat r5 = WindowCompat.getInsetsController(r3.getWindow(), r3.getWindow().getDecorView());
        o.e(r5, "getInsetsController(window, window.decorView)");
        r5.setAppearanceLightStatusBars(r4);
    }
}
