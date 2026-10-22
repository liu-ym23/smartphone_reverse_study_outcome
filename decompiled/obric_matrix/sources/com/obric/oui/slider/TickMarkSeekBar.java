package com.obric.oui.slider;

import android.R;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.e;
import com.obric.common.oui.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.i0.j0;
import kotlin.i0.r;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0002deB'\b\u0007\u0012\u0006\u0010=\u001a\u00020<\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010_\u0012\b\b\u0002\u0010a\u001a\u00020\u0012¢\u0006\u0004\bb\u0010cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0013\u001a\u00020\n*\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\u00020\n*\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0018\u0010\u0006J\u001f\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ/\u0010#\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0012H\u0014¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0012¢\u0006\u0004\b&\u0010\u001fJ\u0015\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0012¢\u0006\u0004\b(\u0010\u001fJ\u0015\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0012¢\u0006\u0004\b*\u0010\u001fJ\u0015\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\u0015\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102J\u0015\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u00020/¢\u0006\u0004\b4\u00102J\u0015\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u00020/¢\u0006\u0004\b6\u00102J)\u0010:\u001a\u00020\u00042\u0006\u00107\u001a\u00020/2\b\b\u0002\u00108\u001a\u00020\u00122\b\b\u0002\u00109\u001a\u00020\u0012¢\u0006\u0004\b:\u0010;J\u001f\u0010?\u001a\u0004\u0018\u00010\r2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020\u0012¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020\u00042\u0006\u0010A\u001a\u00020+H\u0016¢\u0006\u0004\bB\u0010.J\u0017\u0010D\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010C¢\u0006\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010FR\u0016\u0010K\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010JR\u0016\u0010%\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010MR\u0016\u0010Q\u001a\u00020O8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u00107\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010VR\u0018\u0010X\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010WR\u0016\u0010Y\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010JR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010^\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010J¨\u0006f"}, d2 = {"Lcom/obric/oui/slider/TickMarkSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "Landroid/graphics/Canvas;", "canvas", "Lkotlin/f0;", "i", "(Landroid/graphics/Canvas;)V", "j", "l", "k", "", "getOffset", "()F", "Landroid/graphics/drawable/LayerDrawable;", "getBgDrawable", "()Landroid/graphics/drawable/LayerDrawable;", "h", "()V", "", "q", "(I)F", "decimals", "n", "(FI)F", "onDraw", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "defaultTickMarkCount", "setDefaultTickMarkCount", "(I)V", "w", "oldw", "oldh", "onSizeChanged", "(IIII)V", "sliderHeight", "setSliderHeight", "thumbColorResId", "setThumbColor", "defaultMargin", "setDefaultMargin", "Landroid/graphics/drawable/Drawable;", "imageIcon", "setImageIcon", "(Landroid/graphics/drawable/Drawable;)V", "", "visibility", "setProcessImageIconVisibility", "(Z)V", "isAlwaysLight", "setIsAlwaysLight", "isAlwaysNight", "setIsAlwaysNight", "istyleSegmented", "tickMarkCount", "initTickPosition", "p", "(ZII)V", "Landroid/content/Context;", "context", "id", "m", "(Landroid/content/Context;I)Landroid/graphics/drawable/LayerDrawable;", "dr", "invalidateDrawable", "Lcom/obric/oui/slider/TickMarkSeekBar$a;", "setOnSeekBarChangeListenerExt", "(Lcom/obric/oui/slider/TickMarkSeekBar$a;)V", "Landroid/graphics/drawable/Drawable;", "defaultTickMark", "g", "separateBackground", "I", "mCurrentTickIndex", "Lcom/obric/oui/slider/b;", "Lcom/obric/oui/slider/b;", "defaultProcessdrawable", "Lcom/obric/oui/slider/c;", "Lcom/obric/oui/slider/c;", "seekBarVibrateHelper", "", "f", "Ljava/lang/String;", "TAG", "Z", "Lcom/obric/oui/slider/TickMarkSeekBar$a;", "onSeekBarChangeListenerExt", "_defaultTickMarkCount", "Lcom/obric/oui/slider/TickMarkSeekBar$b;", "o", "Lcom/obric/oui/slider/TickMarkSeekBar$b;", "tickMarkStyle", "defaultBackgroudHeight", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public class TickMarkSeekBar extends AppCompatSeekBar {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f11399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f11400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Drawable f11401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.obric.oui.slider.b f11402i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f11403j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f11404k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f11405l;
    private int m;
    private int n;
    private b o;
    private final com.obric.oui.slider.c p;
    private a q;

    public interface a {
        void a(SeekBar r1, float r2, boolean r3);

        void b(int r1);

        void onStartTrackingTouch(SeekBar r1);

        void onStopTrackingTouch(SeekBar r1);
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f11406f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f11407g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ b[] f11408h = null;

        static {
            b r1 = new b("DEFAULT", 0);
            f11406f = r1;
            b r2 = new b("MARGIN16", 1);
            f11407g = r2;
            f11408h = new b[]{r1, r2};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        public static b valueOf(String r1) {
            return (b) Enum.valueOf(b.class, r1);
        }

        public static b[] values() {
            return (b[]) f11408h.clone();
        }
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TickMarkSeekBar f11409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f11410b;

        c(TickMarkSeekBar r1, int r2) {
            this.f11409a = r1;
            this.f11410b = r2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r1) {
            o.f(r1, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            o.f(r2, "animation");
            TickMarkSeekBar.f(this.f11409a, this.f11410b);
            a r3 = TickMarkSeekBar.c(this.f11409a);
            if (r3 == null) goto L5;
            r3.b(this.f11410b);
        L5:
            this.f11409a.invalidate();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r1) {
            o.f(r1, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r1) {
            o.f(r1, "animation");
        }
    }

    public static final class d implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TickMarkSeekBar f11411a;

        d(TickMarkSeekBar r1) {
            this.f11411a = r1;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar r9, int r10, boolean r11) {
            o.f(r9, "seekBar");
            if (Build.VERSION.SDK_INT >= 26) goto L5;
        L7:
            a r0 = TickMarkSeekBar.c(this.f11411a);
            if (r0 == null) goto L11;
            r0.a(r9, TickMarkSeekBar.g(this.f11411a, r10), r11);
            return;
        L11:
            return;
        L5:
            if (this.f11411a.isHapticFeedbackEnabled() == false) goto L7;
            com.obric.oui.slider.c r1 = TickMarkSeekBar.d(this.f11411a);
            Context r2 = this.f11411a.getContext();
            o.e(r2, "context");
            r1.a(r2, r9, r10, r11, TickMarkSeekBar.e(this.f11411a), TickMarkSeekBar.b(this.f11411a));
            goto L7
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar r3) {
            TickMarkSeekBar.f(this.f11411a, -1);
            a r2 = TickMarkSeekBar.c(this.f11411a);
            if (r2 == null) goto L6;
            r2.onStartTrackingTouch(r3);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar r1) {
            TickMarkSeekBar.a(this.f11411a);
            a r2 = TickMarkSeekBar.c(this.f11411a);
            if (r2 == null) goto L6;
            r2.onStopTrackingTouch(this.f11411a);
            return;
        }
    }

    static {
    }

    public TickMarkSeekBar(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public TickMarkSeekBar(Context r7, AttributeSet r8, int r9) {
        o.f(r7, "context");
        super(r7, r8, r9);
        this.f11399f = "TickSeekBar";
        this.f11403j = -1;
        float r1 = 8;
        Resources r2 = Resources.getSystem();
        o.e(r2, "Resources.getSystem()");
        this.f11404k = kotlin.o0.a.a(TypedValue.applyDimension(1, r1, r2.getDisplayMetrics()));
        this.m = -1;
        Resources r3 = Resources.getSystem();
        o.e(r3, "Resources.getSystem()");
        this.n = kotlin.o0.a.a(TypedValue.applyDimension(1, 32, r3.getDisplayMetrics()));
        this.o = b.f11406f;
        this.p = new com.obric.oui.slider.c();
        TypedArray r10 = r7.getTheme().obtainStyledAttributes(r8, k.L2, r9, 0);
        int r11 = k.M2;
        Resources r0 = Resources.getSystem();
        o.e(r0, "Resources.getSystem()");
        this.f11404k = r10.getDimensionPixelSize(r11, kotlin.o0.a.a(TypedValue.applyDimension(1, r1, r0.getDisplayMetrics())));
        this.f11400g = getBgDrawable();
        this.f11401h = ContextCompat.getDrawable(r7, e.w);
        setThumb(new com.obric.oui.slider.d(r7, this.n));
        setThumbOffset(0);
        com.obric.oui.slider.b r12 = new com.obric.oui.slider.b(r7);
        this.f11402i = r12;
        setProgressDrawable(r12);
        setOnSeekBarChangeListenerExt(null);
    }

    public /* synthetic */ TickMarkSeekBar(Context r1, AttributeSet r2, int r3, int r4, g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ void a(TickMarkSeekBar r0) {
        r0.h();
    }

    public static final /* synthetic */ boolean b(TickMarkSeekBar r0) {
        return r0.f11405l;
    }

    public static final /* synthetic */ a c(TickMarkSeekBar r0) {
        return r0.q;
    }

    public static final /* synthetic */ com.obric.oui.slider.c d(TickMarkSeekBar r0) {
        return r0.p;
    }

    public static final /* synthetic */ int e(TickMarkSeekBar r0) {
        return r0.f11403j;
    }

    public static final /* synthetic */ void f(TickMarkSeekBar r0, int r1) {
        r0.m = r1;
    }

    public static final /* synthetic */ float g(TickMarkSeekBar r0, int r1) {
        return r0.q(r1);
    }

    private final LayerDrawable getBgDrawable() {
        if (this.f11405l == false) goto L8;
        int r0 = this.f11404k;
        Resources r4 = Resources.getSystem();
        o.e(r4, "Resources.getSystem()");
        if (r0 >= kotlin.o0.a.a(TypedValue.applyDimension(1, 10, r4.getDisplayMetrics()))) goto L7;
        return null;
    L7:
        Context r1 = getContext();
        o.e(r1, "context");
        int r2 = e.f8233h;
    L10:
        return m(r1, r2);
    L8:
        r1 = getContext();
        o.e(r1, "context");
        r2 = e.f8232g;
        goto L10
    }

    private final float getOffset() {
        Drawable r1 = getThumb();
        o.e(r1, "thumb");
        return r1.getIntrinsicWidth() / 2;
    }

    private final void h() {
        if (this.f11405l == false) goto L30;
        int r0 = this.f11403j;
        Drawable r1 = this.f11401h;
        o.c(r1);
        float r2 = getMeasuredWidth() - r1.getIntrinsicWidth();
        float r3 = r2 / (r0 - 1);
        kotlin.r0.d r4 = kotlin.r0.e.m(0, r0);
        ArrayList r5 = new ArrayList(r.q(r4, 10));
        Iterator<Integer> r6 = r4.iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        r5.add(Float.valueOf(((j0) r6).nextInt() * r3));
        goto L6
    L8:
        float r7 = (getProgress() / getMax()) * r2;
        Iterator<Integer> r8 = r.h(r5).iterator();
        if (r8.hasNext() == true) goto L11;
        Integer r9 = null;
    L21:
        Integer r10 = r9;
        if (r10 == null) goto L24;
        int r11 = r10.intValue();
    L25:
        int r12 = kotlin.r0.e.f(kotlin.o0.a.a((((Number) r5.get(r11)).floatValue() / r2) * getMax()), getMax());
        d.g.d.f.f.b.i(this.f11399f, "anchorPoint, closestTickIndex: " + r11 + ", closestProgress: " + r12);
        ObjectAnimator r13 = ObjectAnimator.ofInt(this, "progress", new int[]{r12});
        r13.setDuration(100);
        r13.start();
        r13.addListener(new c(this, r11));
        return;
    L24:
        r11 = 0;
        goto L25
    L11:
        Integer r14 = r8.next();
        if (r8.hasNext() == true) goto L14;
    L13:
        r9 = r14;
        goto L21
    L14:
        float r15 = Math.abs(((Number) r5.get(r14.intValue())).floatValue() - r7);
    L15:
        Integer r16 = r8.next();
        float r17 = Math.abs(((Number) r5.get(r16.intValue())).floatValue() - r7);
        if (Float.compare(r15, r17) <= 0) goto L19;
        r14 = r16;
        r15 = r17;
    L19:
        if (r8.hasNext() == true) goto L15;
    }

    private final void i(Canvas r9) {
        if (this.f11400g == null) goto L12;
        int r0 = r9.save();
        r9.translate(getOffset(), getPaddingTop());
        int r3 = getMeasuredHeight() / 2;
        Drawable r5 = this.f11400g;
        o.c(r5);
        int r4 = r3 - (r5.getIntrinsicHeight() / 2);
        int r6 = getMeasuredWidth() - ((int) (getOffset() * 2));
        int r7 = getMeasuredHeight() / 2;
        Drawable r8 = this.f11400g;
        o.c(r8);
        Rect r1 = new Rect(0, r4, r6, r7 + (r8.getIntrinsicHeight() / 2));
        Drawable r2 = this.f11400g;
        if (r2 == null) goto L7;
        r2.setBounds(r1);
    L7:
        Drawable r10 = this.f11400g;
        if (r10 == null) goto L10;
        r10.draw(r9);
    L10:
        r9.restoreToCount(r0);
        return;
    }

    private final void j(Canvas r10) {
        Drawable r0 = getProgressDrawable();
        if (r0 == null) goto L6;
        int r1 = r10.save();
        r10.translate(getOffset(), getPaddingTop());
        r0.setBounds(new Rect(0, (getMeasuredHeight() / 2) - (r0.getIntrinsicHeight() / 2), getMeasuredWidth() - ((int) (getOffset() * 2)), (getMeasuredHeight() / 2) + (r0.getIntrinsicHeight() / 2)));
        r0.draw(r10);
        r10.restoreToCount(r1);
        return;
    }

    private final void k(Canvas r1) {
        Drawable r0 = getThumb();
        if (r0 == null) goto L6;
        r0.draw(r1);
        return;
    }

    private final void l(Canvas r22) {
        TickMarkSeekBar r0 = this;
        Drawable r2 = r0.f11401h;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r0.f11403j > 0) goto L7;
        return;
    L7:
        if (r0.f11405l == true) goto L9;
        return;
    L9:
        if (r0.o != b.f11407g) goto L17;
        int r3 = r22.save();
        r22.translate(getOffset(), getPaddingTop());
        Resources r9 = Resources.getSystem();
        o.e(r9, "Resources.getSystem()");
        int r4 = kotlin.o0.a.a(TypedValue.applyDimension(1, 13, r9.getDisplayMetrics()));
        int r6 = ((getMeasuredWidth() - (r4 * 2)) - r2.getIntrinsicWidth()) - ((int) (getOffset() * 2));
        int r10 = r0.f11403j - 1;
        int r7 = r6 / r10;
        if (r10 < 0) goto L16;
        int r5 = 0;
    L13:
        int r8 = (r7 * r5) + r4;
        r2.setBounds(r8, (getMeasuredHeight() / 2) - (r2.getIntrinsicHeight() / 2), r2.getIntrinsicWidth() + r8, (getMeasuredHeight() / 2) + (r2.getIntrinsicHeight() / 2));
        r2.draw(r22);
        if (r5 == r10) goto L16;
        r5 = r5 + 1;
    L16:
        r22.restoreToCount(r3);
        return;
    L17:
        r3 = r22.save();
        r22.translate(0.0f, getPaddingTop());
        int r11 = r0.f11403j;
        int r12 = r2.getIntrinsicWidth();
        int r13 = r2.getIntrinsicHeight();
        float r14 = 4;
        Resources r15 = Resources.getSystem();
        o.e(r15, "Resources.getSystem()");
        int r16 = kotlin.o0.a.a(TypedValue.applyDimension(1, r14, r15.getDisplayMetrics()));
        int r17 = r11 - 1;
        int r18 = (getMeasuredWidth() - r2.getIntrinsicWidth()) / r17;
        Paint r19 = new Paint();
        r19.setColor(getResources().getColor(com.obric.common.oui.c.f8201J));
        r19.setStyle(Paint.Style.FILL);
        r19.setAntiAlias(true);
        int r20 = 0;
    L18:
        if (r20 >= r11) goto L16;
        int r21 = r18 * r20;
        int r110 = r13 / 2;
        int r111 = r11;
        int r23 = r21 + r12;
        int r24 = r13;
        r2.setBounds(r21, (getMeasuredHeight() / 2) - r110, r23, (getMeasuredHeight() / 2) + r110);
        if (r0.m == r20) goto L22;
        r2.draw(r22);
    L22:
        if (r20 >= r17) goto L24;
        int r25 = r23 + r16;
        int r112 = getMeasuredHeight() / 2;
        Resources r26 = Resources.getSystem();
        o.e(r26, "Resources.getSystem()");
        int r113 = r112 - kotlin.o0.a.a(TypedValue.applyDimension(1, r14, r26.getDisplayMetrics()));
        int r27 = getMeasuredHeight() / 2;
        Resources r1 = Resources.getSystem();
        o.e(r1, "Resources.getSystem()");
        RectF r28 = new RectF(r25, r113, ((r25 + r18) - r12) - (r16 * 2), r27 + kotlin.o0.a.a(TypedValue.applyDimension(1, r14, r1.getDisplayMetrics())));
        Resources r29 = Resources.getSystem();
        o.e(r29, "Resources.getSystem()");
        boolean r30 = true;
        float r31 = kotlin.o0.a.a(TypedValue.applyDimension(1, r14, r29.getDisplayMetrics()));
        Resources r32 = Resources.getSystem();
        o.e(r32, "Resources.getSystem()");
        r22.drawRoundRect(r28, r31, kotlin.o0.a.a(TypedValue.applyDimension(1, r14, r32.getDisplayMetrics())), r19);
    L25:
        r20 = r20 + 1;
        r0 = this;
        r11 = r111;
        r2 = r2;
        r13 = r24;
        goto L18
    L24:
        r30 = true;
        goto L25
    }

    private final float n(float r4, int r5) {
        String r3 = String.format(Locale.CHINA, "%." + r5 + 'f', Arrays.copyOf(new Object[]{Float.valueOf(r4)}, 1));
        o.e(r3, "format(locale, this, *args)");
        return Float.parseFloat(r3);
    }

    static /* synthetic */ float o(TickMarkSeekBar r0, float r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r2 = 2;
    L7:
        return r0.n(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: round");
    }

    private final float q(int r4) {
        return o(this, r4 / 100, 0, 1, null);
    }

    @Override // android.widget.ProgressBar, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r2) {
        o.f(r2, "dr");
        super.invalidateDrawable(r2);
    }

    public final LayerDrawable m(Context r3, int r4) {
        o.f(r3, "context");
        Drawable r5 = ContextCompat.getDrawable(r3, r4);
        if ((r5 instanceof LayerDrawable) == true) goto L5;
        r5 = null;
    L5:
        LayerDrawable r6 = (LayerDrawable) r5;
        if (r6 == null) goto L14;
        Drawable r7 = r6.findDrawableByLayerId(R.id.background);
        if ((r7 instanceof GradientDrawable) == true) goto L10;
        r7 = null;
    L10:
        GradientDrawable r8 = (GradientDrawable) r7;
        if (r8 == null) goto L14;
        r8.setSize(r8.getIntrinsicWidth(), this.f11404k);
        return r6;
    L14:
        return null;
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas r2) {
        monitor-enter(this);
        o.f(r2, "canvas");     // Catch: Throwable -> L6
        i(r2);     // Catch: Throwable -> L6
        j(r2);     // Catch: Throwable -> L6
        l(r2);     // Catch: Throwable -> L6
        k(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        if (this.f11405l == true) goto L5;
        return;
    L5:
        if (getThumb() == null) goto L7;
        Drawable r4 = getThumb();
        o.e(r4, "thumb");
        int r5 = r4.getIntrinsicHeight();
    L9:
        if (getMeasuredHeight() != 0) goto L13;
        setMeasuredDimension(getMeasuredWidth(), View.MeasureSpec.makeMeasureSpec(r5, BasicMeasure.EXACTLY));
        return;
    L13:
        return;
    L7:
        r5 = 0;
        goto L9
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int r3, int r4, int r5, int r6) {
        super.onSizeChanged(r3, r4, r5, r6);
        int r7 = (r4 - getPaddingTop()) - getPaddingBottom();
        if (getThumb() == null) goto L5;
        Drawable r8 = getThumb();
        o.e(r8, "thumb");
        int r9 = r8.getIntrinsicHeight();
    L6:
        if (r9 > r7) goto L8;
        return;
    L8:
        if (getThumb() == null) goto L12;
        int r10 = (r7 - r9) / 2;
        Drawable r11 = getThumb();
        o.e(r11, "thumb");
        Rect r12 = r11.getBounds();
        o.e(r12, "thumb.bounds");
        int r1 = r12.left;
        int r13 = r12.right;
        Rect r0 = new Rect(r1, r10, r13, r9 + r10);
        Drawable r2 = getThumb();
        o.e(r2, "thumb");
        r2.setBounds(r0);
        return;
    L12:
        return;
    L5:
        r9 = 0;
        goto L6
    }

    public final void p(boolean r5, int r6, int r7) {
        this.f11405l = r5;
        if (r5 == false) goto L5;
        setProgressDrawable(null);
        Drawable r8 = getThumb();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type com.obric.oui.slider.ThumbDrawable");
        Resources r3 = Resources.getSystem();
        o.e(r3, "Resources.getSystem()");
        ((com.obric.oui.slider.d) r8).a(kotlin.o0.a.a(TypedValue.applyDimension(1, 6, r3.getDisplayMetrics())));
        this.m = r7;
        this.f11403j = r6;
        int r9 = getMeasuredWidth();
        Drawable r0 = getThumb();
        o.e(r0, "thumb");
        float r10 = r9 - r0.getIntrinsicWidth();
        setProgress((int) (((r7 * (r10 / (r6 - 1))) / r10) * getMax()));
    L6:
        h();
        invalidate();
        return;
    L5:
        this.f11403j = -1;
        this.m = -1;
        setProgressDrawable(this.f11402i);
        Drawable r11 = getThumb();
        Objects.requireNonNull(r11, "null cannot be cast to non-null type com.obric.oui.slider.ThumbDrawable");
        Resources r12 = Resources.getSystem();
        o.e(r12, "Resources.getSystem()");
        ((com.obric.oui.slider.d) r11).a(kotlin.o0.a.a(TypedValue.applyDimension(1, 4, r12.getDisplayMetrics())));
        goto L6
    }

    public final void setDefaultMargin(int r2) {
        Drawable r1 = getProgressDrawable();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.oui.slider.ProgressDrawable");
        ((com.obric.oui.slider.b) r1).c(r2);
    }

    public void setDefaultTickMarkCount(int r3) {
        this.f11403j = r3;
        this.m = -1;
        if (this.o != b.f11406f) goto L10;
        Drawable r0 = this.f11400g;
        if ((r0 instanceof com.obric.oui.slider.a) == true) goto L7;
        r0 = null;
    L7:
        com.obric.oui.slider.a r1 = (com.obric.oui.slider.a) r0;
        if (r1 == null) goto L10;
        r1.a(r3);
    L10:
        invalidate();
    }

    public final void setImageIcon(Drawable r2) {
        o.f(r2, "imageIcon");
        Drawable r1 = getProgressDrawable();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.oui.slider.ProgressDrawable");
        ((com.obric.oui.slider.b) r1).d(r2);
    }

    public final void setIsAlwaysLight(boolean r1) {
        this.f11400g = getBgDrawable();
        invalidate();
    }

    public final void setIsAlwaysNight(boolean r1) {
        this.f11400g = getBgDrawable();
        invalidate();
    }

    public final void setOnSeekBarChangeListenerExt(a r1) {
        this.q = r1;
        super.setOnSeekBarChangeListener(new d(this));
    }

    public final void setProcessImageIconVisibility(boolean r2) {
        Drawable r1 = getProgressDrawable();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.oui.slider.ProgressDrawable");
        com.obric.oui.slider.b r3 = (com.obric.oui.slider.b) r1;
        if (r2 == false) goto L5;
        r3.e();
        return;
    L5:
        r3.b();
    }

    public final void setSliderHeight(int r2) {
        this.n = r2;
        Drawable r1 = getThumb();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.oui.slider.ThumbDrawable");
        ((com.obric.oui.slider.d) r1).c(r2);
    }

    public final void setThumbColor(int r2) {
        Drawable r1 = getThumb();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.oui.slider.ThumbDrawable");
        ((com.obric.oui.slider.d) r1).b(r2);
    }
}
