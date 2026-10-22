package com.ss.android.larksso;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f12047a = 0;

    static {
        f12047a = e.f12035c;
    }

    private static int a(@ColorInt int r6, int r7) {
        if (r7 != 0) goto L4;
        return r6;
    L4:
        float r0 = 1.0f - (r7 / 255.0f);
        return ((int) (((double) ((r6 & 255) * r0)) + 0.5d)) | (((((int) (((double) (((r6 >> 16) & 255) * r0)) + 0.5d)) << 16) | ViewCompat.MEASURED_STATE_MASK) | (((int) (((double) (((r6 >> 8) & 255) * r0)) + 0.5d)) << 8));
    }

    private static View b(Activity r3, @ColorInt int r4, int r5) {
        View r0 = new View(r3);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, c(r3)));
        r0.setBackgroundColor(a(r4, r5));
        r0.setId(f12047a);
        return r0;
    }

    private static int c(Context r4) {
        int r0 = r4.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return r4.getResources().getDimensionPixelSize(r0);
    }

    public static void d(Activity r3, @ColorInt int r4, @IntRange(from = 0, to = 255) int r5) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 21) goto L6;
        r3.getWindow().addFlags(Integer.MIN_VALUE);
        r3.getWindow().clearFlags(67108864);
        r3.getWindow().setStatusBarColor(a(r4, r5));
        return;
    L6:
        if (r0 < 19) goto L17;
        r3.getWindow().addFlags(67108864);
        ViewGroup r1 = (ViewGroup) r3.getWindow().getDecorView();
        View r2 = r1.findViewById(f12047a);
        if (r2 != null) goto L10;
        r1.addView(b(r3, r4, r5));
    L14:
        f(r3);
        return;
    L10:
        if (r2.getVisibility() != 8) goto L12;
        r2.setVisibility(0);
    L12:
        r2.setBackgroundColor(a(r4, r5));
        goto L14
    }

    public static void e(Activity r1, @ColorInt int r2) {
        d(r1, r2, 0);
    }

    private static void f(Activity r4) {
        ViewGroup r5 = (ViewGroup) r4.findViewById(R.id.content);
        int r0 = r5.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        View r2 = r5.getChildAt(r1);
        if ((r2 instanceof ViewGroup) == false) goto L7;
        r2.setFitsSystemWindows(true);
        ((ViewGroup) r2).setClipToPadding(true);
    L7:
        r1 = r1 + 1;
        goto L3
    }
}
