package com.obric.oui.drawble;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SuppressLint({"RestrictedApi"})
public class RotatingDrawable extends DrawableWrapper implements Animatable {
    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        Intrinsics.f(r5, "canvas");
        if (getWrappedDrawable() != null) goto L5;
        return;
    L5:
        r5.save();
        r5.rotate(0.0f, (getBounds().left + getBounds().right) / 2.0f, (getBounds().top + getBounds().bottom) / 2.0f);
        getWrappedDrawable().draw(r5);
        r5.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return false;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r4) {
        Intrinsics.f(r4, "bounds");
        super.onBoundsChange(r4);
        if (r4.width() >= r4.height()) goto L5;
        r4.width();
        Drawable r3 = getWrappedDrawable();
        Intrinsics.e(r3, "wrappedDrawable");
        r3.getIntrinsicWidth();
        return;
    L5:
        r4.height();
        Drawable r5 = getWrappedDrawable();
        Intrinsics.e(r5, "wrappedDrawable");
        r5.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        new LinearInterpolator();
        throw null;
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        throw null;
    }
}
