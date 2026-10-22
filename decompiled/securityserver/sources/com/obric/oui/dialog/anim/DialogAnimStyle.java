package com.obric.oui.dialog.anim;

import a.a;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.bytedance.securityserver.R;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.animation.engine.DynamicAnimation;
import com.obric.oui.animation.style.UtilKt;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DialogAnimStyle {

    @Metadata
    public static final enum HeightLevel extends Enum<HeightLevel> {
        public static final HeightLevel b = null;
        public static final HeightLevel c = null;
        public static final HeightLevel e = null;
        public static final /* synthetic */ HeightLevel[] f = null;

        static {
            HeightLevel r0 = new HeightLevel("SMALL", 0, 0.4f);
            b = r0;
            HeightLevel r1 = new HeightLevel("MEDIUM", 1, 0.8f);
            c = r1;
            HeightLevel r2 = new HeightLevel("LARGE", 2, 1.0f);
            e = r2;
            f = new HeightLevel[]{r0, r1, r2};
        }

        public HeightLevel(String r1, int r2, float r3) {
            super(r1, r2);
        }

        public static HeightLevel valueOf(String r1) {
            return (HeightLevel) Enum.valueOf(HeightLevel.class, r1);
        }

        public static HeightLevel[] values() {
            return (HeightLevel[]) f.clone();
        }
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[HeightLevel.values().length];
            r0[0] = 1;
            r0[1] = 2;
            r0[2] = 3;
            int[] r1 = new int[HeightLevel.values().length];
            r1[0] = 1;
            r1[1] = 2;
            r1[2] = 3;
        }
    }

    static {
    }

    public static final void a(Window r2, float r3, float r4, float r5) {
        r2.setDimAmount(((r5 - r4) * RangesKt.a(r3, 0.0f, 1.0f)) + r4);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w("DialogAnimStyle", "updateWindowDimWithAnim: " + e.getMessage());
    }

    public static void b(View r4) {
        Intrinsics.f(r4, "container");
        int r0 = a.d("Resources.getSystem()", 1, 10);
        ViewGroup.LayoutParams r1 = r4.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (r2.topMargin >= r0) goto L7;
        r2.topMargin = r0;
    L7:
        r4.setLayoutParams(r1);
    }

    public static HeightLevel c(View r1, int r2) {
        HeightLevel r0 = HeightLevel.c;
        if (r2 > 0) goto L5;
        return r0;
    L5:
        float r3 = r1.getHeight() / r2;
        if (r3 >= 0.4f) goto L9;
        return HeightLevel.b;
    L9:
        if (r3 >= 0.8f) goto L12;
        return r0;
    L12:
        return HeightLevel.e;
    }

    public static Pair d(boolean r3, HeightLevel r4, boolean r5) {
        Float r0 = Float.valueOf(1.0f);
        if (r3 == true) goto L7;
        return new Pair(r0, Float.valueOf(480.0f));
    L7:
        if (r5 == false) goto L18;
        int r6 = r4.ordinal();
        if (r6 == 0) goto L31;
        if (r6 == 1) goto L30;
        if (r6 != 2) goto L15;
        return new Pair(r0, Float.valueOf(247.0f));
    L15:
        throw new NoWhenBranchMatchedException();
    L30:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(247.0f));
    L31:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(439.0f));
    L18:
        int r7 = r4.ordinal();
        if (r7 == 0) goto L28;
        if (r7 == 1) goto L33;
        if (r7 != 2) goto L25;
        return new Pair(r0, Float.valueOf(322.0f));
    L25:
        throw new NoWhenBranchMatchedException();
    L33:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(322.0f));
    L28:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(632.0f));
    }

    public static ViewPropertySpringAnimator e(View r7, final Window r8, boolean r9, boolean r10) {
        Intrinsics.f(r7, "$this$dialogBottomHide");
        Resources r0 = Resources.getSystem();
        Intrinsics.e(r0, "Resources.getSystem()");
        int r1 = r0.getDisplayMetrics().heightPixels;
        int r2 = r7.getHeight();
        Resources r4 = Resources.getSystem();
        Intrinsics.e(r4, "Resources.getSystem()");
        int r3 = MathKt.a(TypedValue.applyDimension(1, 32, r4.getDisplayMetrics())) + r2;
        Pair r11 = d(r10, c(r7, r1), false);
        final float r5 = ((Number) r11.b).floatValue();
        final float r12 = ((Number) r11.c).floatValue();
        Object r6 = r7.getTag(R.id.o_dialog_anim_out);
        if (r6 != null) goto L6;
    L4:
        r6 = null;
    L7:
        ViewPropertySpringAnimator r13 = (ViewPropertySpringAnimator) r6;
        if (r13 != null) goto L10;
        r13 = new ViewPropertySpringAnimator(r7);
        r7.setTag(R.id.o_dialog_anim_out, r13);
    L10:
        final float r14 = r3;
        r13.a(DynamicAnimation.m, r14, new DialogAnimStyle$dialogBottomHide$spring$1(r5, r12));
        if (r8 == null) goto L18;
        if (r9 == false) goto L18;
        r8.addFlags(2);     // Catch: Exception -> L16
        final float r15 = r8.getAttributes().dimAmount;     // Catch: Exception -> L16
        r13.f = new DialogAnimStyle$dialogBottomHide$$inlined$apply$lambda$1(r14, r15, r8);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        Log.w("DialogAnimStyle", "dialogBottomHide, can't show dim anim: " + e.getMessage());
    L18:
        ArrayList r16 = UtilKt.a(r7);
        Object r17 = r7.getContext().getSystemService("input_method");
        if (r17 == null) goto L28;
        InputMethodManager r18 = (InputMethodManager) r17;
        Iterator r19 = r16.iterator();
    L22:
        if (r19.hasNext() == false) goto L26;
        EditText r20 = (EditText) r19.next();
        if (r18.isActive(r20) == false) goto L22;
        r18.hideSoftInputFromWindow(r20.getWindowToken(), 0);
        goto L22
    L26:
        return r13;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L6:
        if ((r6 instanceof ViewPropertySpringAnimator) == false) goto L4;
        goto L4
    }

    public static ViewPropertySpringAnimator f(View r6, final Window r7, boolean r8, final float r9, boolean r10) {
        Intrinsics.f(r6, "$this$dialogBottomShow");
        Resources r0 = Resources.getSystem();
        Intrinsics.e(r0, "Resources.getSystem()");
        int r1 = r0.getDisplayMetrics().heightPixels;
        int r2 = r6.getHeight();
        Resources r4 = Resources.getSystem();
        Intrinsics.e(r4, "Resources.getSystem()");
        final int r3 = MathKt.a(TypedValue.applyDimension(1, 32, r4.getDisplayMetrics())) + r2;
        r6.setAlpha(1.0f);
        Pair r11 = d(r10, c(r6, r1), true);
        final float r5 = ((Number) r11.b).floatValue();
        final float r12 = ((Number) r11.c).floatValue();
        Object r13 = r6.getTag(R.id.o_dialog_anim_in);
        if (r13 != null) goto L6;
    L4:
        r13 = null;
    L7:
        ViewPropertySpringAnimator r14 = (ViewPropertySpringAnimator) r13;
        if (r14 != null) goto L10;
        r14 = new ViewPropertySpringAnimator(r6);
        r6.setTag(R.id.o_dialog_anim_in, r14);
    L10:
        r14.a(DynamicAnimation.m, 0.0f, new DialogAnimStyle$dialogBottomShow$1(r5, r12, r3));
        if (r7 == null) goto L18;
        if (r8 == false) goto L18;
        r7.addFlags(2);     // Catch: Exception -> L16
        final float r15 = r3;
        r14.f = new DialogAnimStyle$dialogBottomShow$$inlined$apply$lambda$1(r15, r9, r7);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        Log.w("DialogAnimStyle", "dialogBottomShow, can't show dim anim: " + e.getMessage());
    L18:
        return r14;
    L6:
        if ((r13 instanceof ViewPropertySpringAnimator) == false) goto L4;
        goto L4
    }
}
