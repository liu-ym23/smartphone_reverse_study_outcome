package com.obric.oui.slider;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SuppressLint({"ClickableViewAccessibility"})
public class OSlider extends ConstraintLayout {
    public static final /* synthetic */ int f = 0;
    public TickMarkSeekBar.OnSeekBarChangeListenerExt b;
    public Drawable c;
    public Drawable e;

    /* JADX INFO: renamed from: com.obric.oui.slider.OSlider$2, reason: invalid class name */
    @Metadata
    public final class AnonymousClass2 implements TickMarkSeekBar.OnSeekBarChangeListenerExt {
        @Override // com.obric.oui.slider.TickMarkSeekBar.OnSeekBarChangeListenerExt
        public final void a() {
            throw null;
        }

        @Override // com.obric.oui.slider.TickMarkSeekBar.OnSeekBarChangeListenerExt
        public final void b() {
            int r0 = OSlider.f;
            throw null;
        }

        @Override // com.obric.oui.slider.TickMarkSeekBar.OnSeekBarChangeListenerExt
        public final void c() {
            throw null;
        }

        @Override // com.obric.oui.slider.TickMarkSeekBar.OnSeekBarChangeListenerExt
        public final void d() {
            int r0 = OSlider.f;
            throw null;
        }
    }

    @Metadata
    public static final class Companion {
    }

    @Nullable
    public final Drawable getLeftImage() {
        return this.c;
    }

    public final float getMaxValue() {
        throw null;
    }

    public final float getMinValue() {
        throw null;
    }

    public final float getProgress() {
        throw null;
    }

    @Nullable
    public final Drawable getRightImage() {
        return this.e;
    }

    @NotNull
    public final SeekBar getSeekBar() {
        return null;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r3, int r4) {
        Resources r0 = Resources.getSystem();
        Intrinsics.e(r0, "Resources.getSystem()");
        super.onMeasure(r3, View.MeasureSpec.makeMeasureSpec(MathKt.a(TypedValue.applyDimension(1, 32, r0.getDisplayMetrics())), BasicMeasure.EXACTLY));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.f(r2, "event");
        return super.onTouchEvent(r2);
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        throw null;
    }

    @Override // android.view.View
    public void setHapticFeedbackEnabled(boolean r1) {
        super.setHapticFeedbackEnabled(r1);
        throw null;
    }

    public final void setIsSegmented(boolean r1) {
        throw null;
    }

    public final void setLeftIcon(@NotNull Drawable r1) {
        Intrinsics.f(r1, "drawable");
        throw null;
    }

    public final void setLeftImage(@Nullable Drawable r1) {
        this.c = r1;
    }

    public final void setMaxValue(float r2) {
        Log.d("OSlider", "setMaxValue >>> " + r2);
        throw null;
    }

    public final void setMinValue(float r2) {
        Log.d("OSlider", "setMinValue >>> " + r2);
        throw null;
    }

    public final void setOnSeekBarChangeListenerExt(@Nullable TickMarkSeekBar.OnSeekBarChangeListenerExt r1) {
        this.b = r1;
    }

    public final void setProcessBackgroundColor(int r1) {
        throw null;
    }

    public final void setProcessProgressColor(int r1) {
        throw null;
    }

    public final void setProgress(float r1) {
        throw null;
    }

    public final void setRightIcon(@NotNull Drawable r1) {
        Intrinsics.f(r1, "drawable");
        throw null;
    }

    public final void setRightImage(@Nullable Drawable r1) {
        this.e = r1;
    }

    public final void setSeekBarHeight(float r1) {
        throw null;
    }

    public final void setThumbColor(int r1) {
        throw null;
    }

    public final void setTickMarkCount(int r1) {
        throw null;
    }
}
