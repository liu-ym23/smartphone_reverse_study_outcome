package com.obric.oui.dialog.alert;

import a.a;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public final class ImageStyleController implements StyleController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f213a;
    public Integer b;
    public Integer c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f214d;
    public final Context e;
    public final int f;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class FixRatioLayout extends FrameLayout {
        @Override // android.widget.FrameLayout, android.view.View
        public final void onMeasure(int r2, int r3) {
            super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r2) / 2, BasicMeasure.EXACTLY));
        }
    }

    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface ImageStyle {
    }

    public ImageStyleController(Context r2) {
        Intrinsics.f(r2, "context");
        this.e = r2;
        this.f = 0;
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public final void a(Context r6, FrameLayout r7) {
        Intrinsics.f(r7, "parent");
        int r1 = -2;
        if (this.f != 0) goto L12;
        Integer r0 = this.c;
        if (r0 == null) goto L7;
        int r2 = r0.intValue();
    L8:
        Integer r3 = this.b;
        if (r3 == null) goto L11;
        r1 = r3.intValue();
    L11:
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(r2, r1);
        r8.gravity = 1;
        r8.topMargin = a.d("Resources.getSystem()", 1, 28);
        r7.addView(c(), r8);
        return;
    L7:
        r2 = -2;
        goto L8
    L12:
        Integer r4 = this.c;
        if (r4 == null) goto L15;
        int r5 = r4.intValue();
    L16:
        Integer r9 = this.b;
        if (r9 == null) goto L19;
        r1 = r9.intValue();
    L19:
        ViewGroup.LayoutParams r10 = new FrameLayout.LayoutParams(r5, r1);
        if (this.f214d == false) goto L22;
        ViewGroup r11 = new FrameLayout(r6);
    L23:
        r11.addView(c(), new FrameLayout.LayoutParams(-1, -1));
        r7.addView(r11, r10);
        return;
    L22:
        r11 = new FixRatioLayout(r6);
        goto L23
    L15:
        r5 = -1;
        goto L16
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public final void b(OAlertDialog r1) {
        Intrinsics.f(r1, "dialog");
    }

    public final ImageView c() {
        ImageView r0 = new ImageView(this.e);
        r0.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable r2 = this.f213a;
        if (r2 == null) goto L5;
        r0.setImageDrawable(r2);
    L5:
        return r0;
    }
}
