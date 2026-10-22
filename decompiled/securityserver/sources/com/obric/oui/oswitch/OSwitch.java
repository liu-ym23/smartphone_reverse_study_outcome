package com.obric.oui.oswitch;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.securityserver.R;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.utils.log.L;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OSwitch extends SwitchCompat {
    public final int T;
    public final int U;

    @Metadata
    public static final class Companion {
    }

    @JvmOverloads
    public OSwitch(@NotNull Context r4, @Nullable AttributeSet r5) {
        Intrinsics.f(r4, "context");
        super(r4, r5, R.attr.OUISwitchStyle);
        TypedArray r6 = r4.obtainStyledAttributes(r5, com.obric.common.oui.R.styleable.s, R.attr.OUISwitchStyle, 0);
        this.T = r6.getResourceId(3, 0);
        this.U = r6.getResourceId(2, 0);
        r6.recycle();
        if (getThumbDrawable() != null) goto L6;
        setThumbDrawable(ContextCompat.getDrawable(r4, R.drawable.o_switch_thumb));
    L6:
        if (getTrackDrawable() != null) goto L12;
        boolean r7 = isChecked();
        CustomTransitionDrawable r1 = new CustomTransitionDrawable(getUncheckedDrawable(), getCheckedDrawable());
        if (r7 == false) goto L10;
        r1.f238d = 0;
        r1.e = 255;
        r1.f = 0;
        r1.c = 0;
        r1.g = false;
        r1.f237a = 1;
        r1.invalidateSelf();
    L11:
        setTrackDrawable(r1);
        goto L12
    L10:
        r1.f = 0;
        r1.f237a = 0;
        r1.invalidateSelf();
    L12:
        setEnabled(isEnabled());
    }

    private final Drawable getCheckedDrawable() {
        int r0 = this.U;
        if (r0 != 0) goto L5;
        Drawable r1 = ContextCompat.getDrawable(getContext(), R.drawable.o_switch_track_checked);
        Intrinsics.c(r1);
        Drawable r2 = r1.mutate();
        Intrinsics.e(r2, "ContextCompat.getDrawabl…                .mutate()");
        return r2;
    L5:
        Drawable r3 = ContextCompat.getDrawable(getContext(), r0);
        Intrinsics.c(r3);
        Drawable r4 = r3.mutate();
        Intrinsics.e(r4, "ContextCompat.getDrawabl… trackChecked)!!.mutate()");
        return r4;
    }

    private final boolean getTargetCheckedState() {
        if (getThumbPosition() <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final float getThumbPosition() {
        Field r0 = SwitchCompat.class.getDeclaredField("A");     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        Intrinsics.e(r0, BaseSwitches.V);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        Object r2 = r0.get(this);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        if (r2 == null) goto L10;
        return ((Float) r2).floatValue();
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
    L5:
        e = move-exception;
        e.printStackTrace();
    L13:
        return 0.0f;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    private final int getTouchMode() {
        Field r0 = SwitchCompat.class.getDeclaredField("u");     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        Intrinsics.e(r0, BaseSwitches.V);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        Object r2 = r0.get(this);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        if (r2 == null) goto L10;
        return ((Integer) r2).intValue();
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
    L5:
        e = move-exception;
        e.printStackTrace();
    L13:
        return 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    private final Drawable getUncheckedDrawable() {
        int r0 = this.T;
        if (r0 != 0) goto L5;
        Drawable r1 = ContextCompat.getDrawable(getContext(), R.drawable.o_switch_track_unchecked);
        Intrinsics.c(r1);
        Drawable r2 = r1.mutate();
        Intrinsics.e(r2, "ContextCompat.getDrawabl…                .mutate()");
        return r2;
    L5:
        Drawable r3 = ContextCompat.getDrawable(getContext(), r0);
        Intrinsics.c(r3);
        Drawable r4 = r3.mutate();
        Intrinsics.e(r4, "ContextCompat.getDrawabl…rackUnchecked)!!.mutate()");
        return r4;
    }

    public final void c(boolean r3) {
        Drawable r2 = getTrackDrawable();
        if ((r2 instanceof TransitionDrawable) == false) goto L12;
        if (r3 == false) goto L10;
        TransitionDrawable r4 = (TransitionDrawable) r2;
        Method r5 = TransitionDrawable.class.getDeclaredMethod("showSecondLayer", null);     // Catch: Exception -> L8
        Intrinsics.e(r5, "showSecondLayerMethod");     // Catch: Exception -> L8
        r5.setAccessible(true);     // Catch: Exception -> L8
        r5.invoke(r4, null);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        L.c("OSwitch", "reflectShowSecondLayer, error", e);
        return;
    L10:
        ((TransitionDrawable) r2).resetTransition();
        return;
    L12:
        if ((r2 instanceof CustomTransitionDrawable) == true) goto L14;
        return;
    L14:
        if (r3 == false) goto L16;
        CustomTransitionDrawable r6 = (CustomTransitionDrawable) r2;
        r6.f = 255;
        r6.f237a = 0;
        r6.invalidateSelf();
        return;
    L16:
        CustomTransitionDrawable r7 = (CustomTransitionDrawable) r2;
        r7.f = 0;
        r7.f237a = 0;
        r7.invalidateSelf();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        measure(0, 0);     // Catch: Exception -> L18
        int r2 = getMeasuredWidth();     // Catch: Exception -> L18
        int r3 = getMeasuredHeight();     // Catch: Exception -> L18
        if (r2 <= 0) goto L26;
        if (r3 <= 0) goto L27;
        float r4 = 20;
        Resources r5 = Resources.getSystem();     // Catch: Exception -> L18
        Intrinsics.e(r5, "Resources.getSystem()");     // Catch: Exception -> L18
        int r6 = r2 + MathKt.a(TypedValue.applyDimension(1, r4, r5.getDisplayMetrics()));     // Catch: Exception -> L18
        Resources r7 = Resources.getSystem();     // Catch: Exception -> L18
        Intrinsics.e(r7, "Resources.getSystem()");     // Catch: Exception -> L18
        int r8 = r3 + MathKt.a(TypedValue.applyDimension(1, r4, r7.getDisplayMetrics()));     // Catch: Exception -> L18
        ViewParent r0 = getParent();     // Catch: Exception -> L18
        if (r0 != null) goto L11;
    L9:
        r0 = null;
    L12:
        ViewGroup r1 = (ViewGroup) r0;     // Catch: Exception -> L18
        if (r1 == null) goto L20;
        r1.measure(0, 0);     // Catch: Exception -> L18
        int r9 = r1.getMeasuredWidth();     // Catch: Exception -> L18
        if (r8 > r1.getMeasuredHeight()) goto L17;
        if (r6 <= r9) goto L20;
    L17:
        ViewExtensionsKt.b(r1, r6, r8, false);     // Catch: Exception -> L18
    L20:
        ViewExtensionsKt.b(this, r6, r8, false);     // Catch: Exception -> L18
        return;
    L11:
        if ((r0 instanceof ViewGroup) == false) goto L9;
    L27:
        return;
    L26:
        return;
    L18:
        e = move-exception;
        L.c("OSwitch", "increaseTouchArea, error", e);
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r6) {
        Intrinsics.f(r6, "ev");
        if (r6.getAction() == 3) goto L7;
        if (r6.getAction() == 1) goto L7;
    L32:
        return super.onTouchEvent(r6);
    L7:
        if (getTouchMode() != 2) goto L32;
        Field r3 = SwitchCompat.class.getDeclaredField("u");     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
        Intrinsics.e(r3, BaseSwitches.V);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
        r3.setAccessible(true);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
        r3.set(this, 0);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
    L18:
        if (r6.getAction() == 1) goto L20;
    L22:
        boolean r4 = false;
    L23:
        boolean r5 = isChecked();
        if (r4 == false) goto L26;
        boolean r7 = getTargetCheckedState();
    L27:
        if (r7 == r5) goto L29;
        playSoundEffect(0);
    L29:
        setChecked(r7);
        MotionEvent r0 = MotionEvent.obtain(r6);
        Intrinsics.e(r0, "cancel");
        r0.setAction(3);
        super.onTouchEvent(r0);
        r0.recycle();
        super.onTouchEvent(r6);
        return true;
    L26:
        r7 = r5;
        goto L27
    L20:
        if (isEnabled() == false) goto L22;
        r4 = true;
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r10) {
        boolean r0 = isChecked();
        super.setChecked(r10);
        boolean r11 = isChecked();
        int r2 = 255;
        if (isEnabled() == false) goto L11;
        Drawable r1 = getTrackDrawable();
        if (r1 == null) goto L7;
        r1.setAlpha(255);
    L7:
        Drawable r3 = getThumbDrawable();
        if (r3 == null) goto L25;
        r3.setAlpha(255);
    L25:
        if (getWindowToken() != null) goto L27;
    L53:
        if (r0 == r11) goto L63;
        c(r11);
        return;
    L63:
        return;
    L27:
        if (ViewCompat.isLaidOut(this) == false) goto L53;
        if (r0 == r11) goto L56;
        Drawable r9 = getTrackDrawable();
        if ((r9 instanceof TransitionDrawable) == false) goto L35;
        if (r11 == false) goto L33;
        ((TransitionDrawable) r9).startTransition(260);
        return;
    L33:
        ((TransitionDrawable) r9).reverseTransition(100);
        return;
    L35:
        if ((r9 instanceof CustomTransitionDrawable) == true) goto L37;
        return;
    L37:
        if (r11 == false) goto L39;
        CustomTransitionDrawable r12 = (CustomTransitionDrawable) r9;
        r12.f238d = 0;
        r12.e = 255;
        r12.f = 0;
        r12.c = 260;
        r12.g = false;
        r12.f237a = 1;
        r12.invalidateSelf();
        return;
    L39:
        CustomTransitionDrawable r13 = (CustomTransitionDrawable) r9;
        r13.getClass();
        long r5 = SystemClock.uptimeMillis();
        if (r13.f237a != 2) goto L52;
        long r6 = r5 - r13.b;
        int r14 = r13.c;
        if (r6 > r14) goto L52;
        boolean r4 = !r13.g;
        r13.g = r4;
        r13.f238d = r13.f;
        if (r4 == false) goto L47;
        r2 = 0;
    L47:
        r13.e = r2;
        if (r4 == false) goto L50;
        int r15 = (int) r6;
    L51:
        r13.c = r15;
        r13.f237a = 1;
        r13.invalidateSelf();
        return;
    L50:
        r15 = r14 - ((int) r6);
    L52:
        r13.f238d = 255;
        r13.e = 0;
        r13.f = 255;
        r13.c = 100;
        r13.g = true;
        r13.f237a = 1;
        r13.invalidateSelf();
        return;
    L56:
        return;
    L11:
        if (isChecked() == false) goto L18;
        Drawable r7 = getTrackDrawable();
        if (r7 == null) goto L15;
        r7.setAlpha(76);
    L15:
        Drawable r8 = getThumbDrawable();
        if (r8 == null) goto L25;
        r8.setAlpha(127);
        goto L25
    L18:
        Drawable r16 = getTrackDrawable();
        if (r16 == null) goto L21;
        r16.setAlpha(76);
    L21:
        Drawable r17 = getThumbDrawable();
        if (r17 == null) goto L25;
        r17.setAlpha(255);
        goto L25
    }

    @Override // com.obric.oui.oswitch.SwitchCompat
    public void setCheckedNoAnim(boolean r2) {
        boolean r0 = isChecked();
        super.setCheckedNoAnim(r2);
        boolean r3 = isChecked();
        if (r0 == r3) goto L6;
        c(r3);
        return;
    }

    @Deprecated
    public final void setCheckedWithoutFeedback(boolean r4) {
        if (r4 != isChecked()) goto L5;
    L18:
        super.setChecked(r4);
        return;
    L5:
        if ((getTrackDrawable() instanceof TransitionDrawable) == false) goto L18;
        if (r4 == false) goto L13;
        Drawable r2 = getTrackDrawable();
        if (r2 == null) goto L12;
        ((TransitionDrawable) r2).startTransition(180);
        goto L18
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L13:
        Drawable r3 = getTrackDrawable();
        if (r3 == null) goto L17;
        ((TransitionDrawable) r3).reverseTransition(180);
        goto L18
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r3) {
        super.setEnabled(r3);
        if (r3 == false) goto L11;
        Drawable r4 = getTrackDrawable();
        if (r4 == null) goto L7;
        r4.setAlpha(255);
    L7:
        Drawable r2 = getThumbDrawable();
        if (r2 == null) goto L25;
        r2.setAlpha(255);
        return;
    L25:
        return;
    L11:
        if (isChecked() == false) goto L18;
        Drawable r5 = getTrackDrawable();
        if (r5 == null) goto L15;
        r5.setAlpha(76);
    L15:
        Drawable r6 = getThumbDrawable();
        if (r6 == null) goto L27;
        r6.setAlpha(127);
        return;
    L27:
        return;
    L18:
        Drawable r7 = getTrackDrawable();
        if (r7 == null) goto L21;
        r7.setAlpha(76);
    L21:
        Drawable r8 = getThumbDrawable();
        if (r8 == null) goto L29;
        r8.setAlpha(255);
        return;
    }
}
