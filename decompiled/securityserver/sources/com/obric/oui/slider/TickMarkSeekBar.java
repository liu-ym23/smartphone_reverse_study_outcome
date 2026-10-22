package com.obric.oui.slider;

import a.a;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.obric.common.oui.R;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.common.style.SmoothCornerH;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class TickMarkSeekBar extends AppCompatSeekBar {
    public static final /* synthetic */ int t = 0;
    public float b;
    public final float c;
    public final float e;
    public final float f;
    public int i;
    public int j;
    public int k;
    public final Paint l;
    public final Path m;
    public final RectF n;
    public final Path o;
    public final SeekBarVibrateHelper p;
    public final Shadow q;
    public boolean r;
    public OnSeekBarChangeListenerExt s;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public interface OnSeekBarChangeListenerExt {
        void a();

        void b();

        void c();

        void d();
    }

    public TickMarkSeekBar(Context r16, AttributeSet r17, int r18) {
        Intrinsics.f(r16, "context");
        super(r16, r17, r18);
        float r2 = 6;
        this.b = a.d("Resources.getSystem()", 1, r2);
        this.c = a.d("Resources.getSystem()", 1, 16);
        this.e = a.d("Resources.getSystem()", 1, 18);
        this.f = a.d("Resources.getSystem()", 1, 22);
        a.d("Resources.getSystem()", 1, 2);
        Paint r6 = new Paint();
        this.l = r6;
        this.m = new Path();
        this.n = new RectF();
        this.o = new Path();
        SeekBarVibrateHelper r7 = new SeekBarVibrateHelper();
        r7.f284a = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.p = r7;
        Shadow r8 = new Shadow(Color.parseColor("#00000000"), 0.0f, 0.0f, 0.0f, 0.0f);
        this.q = r8;
        TypedArray r9 = r16.getTheme().obtainStyledAttributes(r17, R.styleable.z, r18, 0);
        Resources r10 = Resources.getSystem();
        Intrinsics.e(r10, "Resources.getSystem()");
        this.b = r9.getDimensionPixelSize(1, MathKt.a(TypedValue.applyDimension(1, r2, r10.getDisplayMetrics())));
        this.i = r9.getColor(0, r9.getResources().getColor(com.bytedance.securityserver.R.color.oui_basic_line_2));
        this.j = r9.getColor(2, r9.getResources().getColor(com.bytedance.securityserver.R.color.oui_functional_blue_6));
        this.k = r9.getColor(3, r9.getResources().getColor(com.bytedance.securityserver.R.color.oui_on_accent_default));
        setOnSeekBarChangeListenerExt(null);
        getResources().getColor(com.bytedance.securityserver.R.color.oui_basic_line_3);
        r6.setStyle(Paint.Style.FILL);
        TypedArray r0 = r16.obtainStyledAttributes(com.bytedance.securityserver.R.style.OUIShadow_1_2, R.styleable.u);
        Intrinsics.e(r0, "context.obtainStyledAttr…s, R.styleable.OUILayout)");
        r8.f204a = r0.getColor(13, Color.parseColor("#00000000"));
        r8.b = r0.getDimension(12, 0.0f);
        r8.c = r0.getDimension(10, 0.0f);
        r8.f205d = r0.getDimension(11, 0.0f);
        r8.e = r0.getDimension(14, 0.0f);
        r0.recycle();
    }

    public final float a() {
        float r0 = getWidth();
        float r1 = this.e;
        return (((getProgress() * 1.0f) / getMax()) * (r0 - r1)) + (r1 / 2.0f);
    }

    public final void b(Canvas r7) {
        r7.save();
        float r0 = this.b / 2;
        a();
        RectF r1 = this.n;
        float r2 = this.c;
        r1.set(0.0f, r2 - r0, getWidth(), r2 + r0);
        Path r3 = this.m;
        r3.reset();
        r3.addRoundRect(r1, r0, r0, Path.Direction.CW);
        Paint r4 = this.l;
        r4.setColor(this.i);
        r7.drawPath(r3, r4);
        r7.restore();
    }

    public final void c(Canvas r11) {
        r11.save();
        float r1 = this.b / 2;
        float r3 = a();
        if (this.r == false) goto L5;
        float r4 = this.f;
    L6:
        RectF r5 = this.n;
        float r6 = this.c;
        r5.set(0.0f, r6 - r1, r3, r6 + r1);
        Path r7 = this.o;
        r7.reset();
        Path.Direction r0 = Path.Direction.CW;
        r7.addRoundRect(r5, new float[]{r1, r1, 0.0f, 0.0f, 0.0f, 0.0f, r1, r1}, r0);
        Paint r2 = this.l;
        r2.setColor(this.j);
        Path r10 = this.m;
        r10.reset();
        r10.addCircle(r3, r6, r4 / 2.0f, r0);
        r11.clipOutPath(r10);
        r11.drawPath(r7, r2);
        r11.restore();
        return;
    L5:
        r4 = this.e;
        goto L6
    }

    public final void d(Canvas r8) {
        r8.save();
        if (this.r == false) goto L5;
        float r0 = this.f;
    L6:
        float r1 = a();
        Paint r2 = this.l;
        r2.setColor(this.k);
        RectF r3 = this.n;
        float r4 = r0 / 2.0f;
        float r5 = this.c;
        r3.set(r1 - r4, r5 - r4, r1 + r4, r5 + r4);
        r8.drawRoundRect(r3, r4, r4, r2);
        r8.restore();
        r8.save();
        Shadow r7 = this.q;
        Intrinsics.f(r7, "shadow");
        float r6 = 0;
        float r9 = r7.g;
        if (r9 <= r6) goto L9;
        r4 = r9;
    L9:
        Path r10 = new Path();
        SmoothCornerH.a(r10, r3, r4);
        int r11 = r8.save();
        RectF r12 = new RectF(r3);
        r12.offset(r7.c, r7.f205d);
        float r13 = -r7.e;
        r12.inset(r13, r13);
        r8.clipOutPath(r10);
        int r14 = r7.f204a;
        Paint r15 = r7.f;
        r15.setColor(r14);
        if (r7.b <= r6) goto L12;
        r15.setMaskFilter(new BlurMaskFilter(r7.b, BlurMaskFilter.Blur.NORMAL));
    L12:
        SmoothCornerH.f(r8, r12, r4, r15);
        r8.restoreToCount(r11);
        r8.restore();
        return;
    L5:
        r0 = this.e;
        goto L6
    }

    public final void e(Canvas r1) {
    }

    @Override // android.widget.ProgressBar, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r2) {
        Intrinsics.f(r2, "dr");
        super.invalidateDrawable(r2);
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas r2) {
        monitor-enter(this);
        Intrinsics.f(r2, "canvas");     // Catch: Throwable -> L6
        b(r2);     // Catch: Throwable -> L6
        c(r2);     // Catch: Throwable -> L6
        d(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void onMeasure(int r3, int r4) {
        Resources r0 = Resources.getSystem();
        Intrinsics.e(r0, "Resources.getSystem()");
        super.onMeasure(r3, View.MeasureSpec.makeMeasureSpec(MathKt.a(TypedValue.applyDimension(1, 32, r0.getDisplayMetrics())), BasicMeasure.EXACTLY));
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public final boolean onTouchEvent(MotionEvent r3) {
        if (r3 == null) goto L4;
        Integer r0 = Integer.valueOf(r3.getAction());
    L5:
        if (r0 != null) goto L8;
    L9:
        if (r0 != null) goto L12;
    L14:
        this.r = false;
        invalidate();
    L17:
        return super.onTouchEvent(r3);
    L12:
        if (r0.intValue() != 2) goto L14;
    L15:
        this.r = true;
        invalidate();
        goto L17
    L8:
        if (r0.intValue() == 0) goto L15;
    L4:
        r0 = null;
        goto L5
    }

    public final void setBackgroundHeight(float r1) {
        this.b = r1;
        invalidate();
    }

    public void setDefaultTickMarkCount(int r1) {
        invalidate();
    }

    public final void setOnSeekBarChangeListenerExt(@Nullable OnSeekBarChangeListenerExt r1) {
        this.s = r1;
        super.setOnSeekBarChangeListener(new AnonymousClass1(this));
    }

    public final void setProcessBackgroundColor(int r2) {
        this.i = getResources().getColor(r2);
        invalidate();
    }

    public final void setProcessProgressColor(int r2) {
        this.j = getResources().getColor(r2);
        invalidate();
    }

    public final void setThumbColor(int r2) {
        this.k = getResources().getColor(r2);
    }
}
