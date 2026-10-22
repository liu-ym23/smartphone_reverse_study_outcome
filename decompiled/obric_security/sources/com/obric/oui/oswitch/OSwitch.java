package com.obric.oui.oswitch;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.utils.KtExt;
import com.obric.oui.utils.log.L;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSwitch.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 B2\u00020\u0001:\u0001BB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u001c\u0010\u001e\u001a\u00020\u00182\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u0007H\u0002J\u001a\u0010!\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010$\u001a\u00020\u0018H\u0014J0\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0014J\u0018\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0016J\u0010\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u000200H\u0016J\u000e\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\nJ\u0010\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\nH\u0016J\u0018\u00105\u001a\u00020\u00182\u0006\u00104\u001a\u00020\n2\u0006\u00106\u001a\u00020\nH\u0002J\u0010\u00107\u001a\u00020\u00182\u0006\u00104\u001a\u00020\nH\u0016J\u0010\u00108\u001a\u00020\u00182\u0006\u00104\u001a\u00020\nH\u0007J\u0010\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\nH\u0016J\b\u0010;\u001a\u00020\u0018H\u0002J\u0010\u0010<\u001a\u00020\u00182\u0006\u0010/\u001a\u000200H\u0002J\b\u0010=\u001a\u00020\u0018H\u0002J\u0014\u0010>\u001a\n @*\u0004\u0018\u00010?0?*\u00020AH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/obric/oui/oswitch/OSwitch;", "Lcom/obric/oui/oswitch/SwitchCompat;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "changeAlphaWhenDisable", "", "targetCheckedState", "getTargetCheckedState", "()Z", "thumbPosition", "", "getThumbPosition", "()F", "touchMode", "getTouchMode", "()I", "trackChecked", "trackUnchecked", "changeTrackDrawableStateWithoutAnim", "", "isChecked", "doTrackDrawableTransitionAnim", "getCheckedDrawable", "Landroid/graphics/drawable/Drawable;", "getUncheckedDrawable", "increaseTouchArea", "xAmount", "yAmount", "makeAndroidTransitionDrawable", "makeCustomTransitionDrawable", "Lcom/obric/oui/oswitch/CustomTransitionDrawable;", "onAttachedToWindow", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "setChangeAlphaWhenDisable", "change", "setChecked", "checked", "setCheckedInner", "withAnim", "setCheckedNoAnim", "setCheckedWithoutFeedback", "setEnabled", "enabled", "setIdleTouchMode", "stopDrag", "updateAlphaState", "reflectShowSecondLayer", "", "kotlin.jvm.PlatformType", "Landroid/graphics/drawable/TransitionDrawable;", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSwitch extends SwitchCompat {
    public static final Companion Companion = null;
    private static final String TAG = "OSwitch";
    private static final boolean USE_CUSTOM_TRANSITION_DRAWABLE = true;
    private boolean changeAlphaWhenDisable;
    private int trackChecked;
    private int trackUnchecked;

    /* JADX INFO: compiled from: OSwitch.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/oswitch/OSwitch$Companion;", "", "()V", "TAG", "", "USE_CUSTOM_TRANSITION_DRAWABLE", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OSwitch(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OSwitch(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OSwitch(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = R.attr.OUISwitchStyle;
    L8:
        this(r1, r2, r3);
    }

    public OSwitch(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.changeAlphaWhenDisable = true;
        int[] r1 = R.styleable.OSwitch;
        Intrinsics.checkNotNullExpressionValue(r1, TAG);
        TypedArray r7 = r4.obtainStyledAttributes(r5, r1, r6, 0);
        Intrinsics.checkNotNullExpressionValue(r7, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.trackUnchecked = r7.getResourceId(R.styleable.OSwitch_oui_trackUnchecked, 0);
        this.trackChecked = r7.getResourceId(R.styleable.OSwitch_oui_trackChecked, 0);
        this.changeAlphaWhenDisable = r7.getBoolean(R.styleable.OSwitch_oui_disabledAlpha, true);
        r7.recycle();
        if (getThumbDrawable() != null) goto L6;
        setThumbDrawable(ContextCompat.getDrawable(r4, R.drawable.o_switch_thumb));
    L6:
        if (getTrackDrawable() != null) goto L8;
        setTrackDrawable(makeCustomTransitionDrawable(r4, isChecked()));
    L8:
        setEnabled(isEnabled());
    }

    public final void setChangeAlphaWhenDisable(boolean r2) {
        if (this.changeAlphaWhenDisable == r2) goto L6;
        this.changeAlphaWhenDisable = r2;
        updateAlphaState();
        return;
    }

    private final void updateAlphaState() {
        if (this.changeAlphaWhenDisable == true) goto L5;
        Drawable r0 = getTrackDrawable();
        if (r0 == null) goto L36;
        r0.setAlpha(255);
    L36:
        Drawable r3 = getThumbDrawable();
        if (r3 == null) goto L47;
        r3.setAlpha(255);
        return;
    L47:
        return;
    L5:
        if (isEnabled() == false) goto L15;
        Drawable r1 = getTrackDrawable();
        if (r1 == null) goto L10;
        r1.setAlpha(255);
    L10:
        Drawable r4 = getThumbDrawable();
        if (r4 == null) goto L44;
        r4.setAlpha(255);
        return;
    L44:
        return;
    L15:
        if (isChecked() == false) goto L24;
        Drawable r2 = getTrackDrawable();
        if (r2 == null) goto L20;
        r2.setAlpha(76);
    L20:
        Drawable r5 = getThumbDrawable();
        if (r5 == null) goto L45;
        r5.setAlpha(127);
        return;
    L45:
        return;
    L24:
        Drawable r6 = getTrackDrawable();
        if (r6 == null) goto L28;
        r6.setAlpha(76);
    L28:
        Drawable r7 = getThumbDrawable();
        if (r7 == null) goto L46;
        r7.setAlpha(255);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        updateAlphaState();
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "ev");
        if (r4.getAction() == 3) goto L7;
        if (r4.getAction() == 1) goto L7;
    L11:
        return super.onTouchEvent(r4);
    L7:
        if (getTouchMode() != 2) goto L11;
        stopDrag(r4);
        super.onTouchEvent(r4);
        return true;
    }

    private final void stopDrag(MotionEvent r4) {
        setIdleTouchMode();
        boolean r2 = true;
        if (r4.getAction() == 1) goto L5;
    L7:
        r2 = false;
    L8:
        boolean r0 = isChecked();
        if (r2 == false) goto L11;
        boolean r3 = getTargetCheckedState();
    L12:
        if (r3 == r0) goto L14;
        playSoundEffect(0);
    L14:
        setChecked(r3);
        MotionEvent r5 = MotionEvent.obtain(r4);
        r5.setAction(3);
        Intrinsics.checkNotNullExpressionValue(r5, "cancel");
        super.onTouchEvent(r5);
        r5.recycle();
        return;
    L11:
        r3 = r0;
        goto L12
    L5:
        if (isEnabled() == false) goto L7;
        goto L7
    }

    private final boolean getTargetCheckedState() {
        if (getThumbPosition() <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final float getThumbPosition() {
        Field r0 = SwitchCompat.class.getDeclaredField("mThumbPosition");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        Object r2 = r0.get(this);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        if (r2 == null) goto L6;
        return ((Float) r2).floatValue();
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
    L7:
        e = move-exception;
        e.printStackTrace();
    L11:
        return 0.0f;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    private final int getTouchMode() {
        Field r0 = SwitchCompat.class.getDeclaredField("mTouchMode");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        Object r2 = r0.get(this);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        if (r2 == null) goto L6;
        return ((Integer) r2).intValue();
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
    L7:
        e = move-exception;
        e.printStackTrace();
    L11:
        return 0;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    private final void setIdleTouchMode() {
        Field r0 = SwitchCompat.class.getDeclaredField("mTouchMode");     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        r0.set(this, 0);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
    L12:
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Deprecated(message = "use setHapticFeedbackEnabled instead")
    public final void setCheckedWithoutFeedback(boolean r2) {
        setCheckedInner(r2, true);
    }

    private final void setCheckedInner(boolean r3, boolean r4) {
        if (r3 == isChecked()) goto L19;
        if (r4 == false) goto L19;
        if ((getTrackDrawable() instanceof TransitionDrawable) == false) goto L19;
        if (r3 == false) goto L14;
        Drawable r1 = getTrackDrawable();
        if (r1 == null) goto L13;
        ((TransitionDrawable) r1).startTransition(180);
        goto L19
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L14:
        Drawable r2 = getTrackDrawable();
        if (r2 == null) goto L18;
        ((TransitionDrawable) r2).reverseTransition(180);
        goto L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L19:
        super.setChecked(r3);
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r3) {
        boolean r0 = isChecked();
        super.setChecked(r3);
        boolean r4 = isChecked();
        updateAlphaState();
        if (getWindowToken() != null) goto L5;
    L8:
        changeTrackDrawableStateWithoutAnim(r4);
        return;
    L5:
        if (hasValidSize() == false) goto L8;
        if (r0 == r4) goto L10;
        doTrackDrawableTransitionAnim(r4);
        return;
    }

    @Override // com.obric.oui.oswitch.SwitchCompat
    public void setCheckedNoAnim(boolean r1) {
        super.setCheckedNoAnim(r1);
        changeTrackDrawableStateWithoutAnim(r1);
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.TextView, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.TextView, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        increaseTouchArea$default(this, 0, 0, 3, null);
    }

    private final Drawable getUncheckedDrawable() {
        if (this.trackUnchecked != 0) goto L5;
        Drawable r1 = ContextCompat.getDrawable(getContext(), R.drawable.o_switch_track_unchecked);
        Intrinsics.checkNotNull(r1);
        Drawable r2 = r1.mutate();
        Intrinsics.checkNotNullExpressionValue(r2, "{\n            ContextCom…      .mutate()\n        }");
        return r2;
    L5:
        Drawable r3 = ContextCompat.getDrawable(getContext(), this.trackUnchecked);
        Intrinsics.checkNotNull(r3);
        Drawable r4 = r3.mutate();
        Intrinsics.checkNotNullExpressionValue(r4, "{\n            ContextCom…ked)!!.mutate()\n        }");
        return r4;
    }

    private final Drawable getCheckedDrawable() {
        if (this.trackChecked != 0) goto L5;
        Drawable r1 = ContextCompat.getDrawable(getContext(), R.drawable.o_switch_track_checked);
        Intrinsics.checkNotNull(r1);
        Drawable r2 = r1.mutate();
        Intrinsics.checkNotNullExpressionValue(r2, "{\n            ContextCom…      .mutate()\n        }");
        return r2;
    L5:
        Drawable r3 = ContextCompat.getDrawable(getContext(), this.trackChecked);
        Intrinsics.checkNotNull(r3);
        Drawable r4 = r3.mutate();
        Intrinsics.checkNotNullExpressionValue(r4, "{\n            ContextCom…ked)!!.mutate()\n        }");
        return r4;
    }

    private final CustomTransitionDrawable makeCustomTransitionDrawable(Context r2, boolean r3) {
        CustomTransitionDrawable r0 = new CustomTransitionDrawable(getUncheckedDrawable(), getCheckedDrawable());
        if (r3 == false) goto L5;
        r0.startTransition(0);
    L6:
        return r0;
    L5:
        r0.resetTransition();
        goto L6
    }

    private final Drawable makeAndroidTransitionDrawable(Context r2, boolean r3) {
        Drawable r1 = ContextCompat.getDrawable(r2, R.drawable.o_switch_track_transition);
        if (r1 == null) goto L10;
        TransitionDrawable r4 = (TransitionDrawable) r1;
        r4.setCrossFadeEnabled(true);
        if (r3 == false) goto L7;
        r4.startTransition(0);
    L8:
        return r1;
    L7:
        r4.resetTransition();
        goto L8
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    }

    private final void doTrackDrawableTransitionAnim(boolean r4) {
        Drawable r3 = getTrackDrawable();
        if ((r3 instanceof TransitionDrawable) == false) goto L8;
        if (r4 == false) goto L6;
        ((TransitionDrawable) r3).startTransition(260);
        return;
    L6:
        ((TransitionDrawable) r3).reverseTransition(100);
        return;
    L8:
        if ((r3 instanceof CustomTransitionDrawable) == false) goto L15;
        if (r4 == false) goto L11;
        ((CustomTransitionDrawable) r3).startTransition(260);
        return;
    L11:
        ((CustomTransitionDrawable) r3).reverseTransition(100);
        return;
    }

    private final void changeTrackDrawableStateWithoutAnim(boolean r3) {
        Drawable r0 = getTrackDrawable();
        if ((r0 instanceof TransitionDrawable) == false) goto L8;
        if (r3 == false) goto L6;
        reflectShowSecondLayer((TransitionDrawable) r0);
        return;
    L6:
        ((TransitionDrawable) r0).resetTransition();
        return;
    L8:
        if ((r0 instanceof CustomTransitionDrawable) == false) goto L15;
        if (r3 == false) goto L11;
        ((CustomTransitionDrawable) r0).showSecondLayer();
        return;
    L11:
        ((CustomTransitionDrawable) r0).resetTransition();
        return;
    }

    private final Object reflectShowSecondLayer(TransitionDrawable r4) {
        Method r3 = TransitionDrawable.class.getDeclaredMethod("showSecondLayer", new Class[0]);     // Catch: Exception -> L4
        r3.setAccessible(true);     // Catch: Exception -> L4
        return r3.invoke(r4, new Object[0]);
    L4:
        e = move-exception;
        L.e(TAG, "reflectShowSecondLayer, error", e);
        return Unit.INSTANCE;
    }

    static /* synthetic */ void increaseTouchArea$default(OSwitch r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 20;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 20;
    L8:
        r1.increaseTouchArea(r2, r3);
    }

    private final void increaseTouchArea(int r10, int r11) {
        measure(0, 0);     // Catch: Exception -> L21
        int r1 = getMeasuredWidth();     // Catch: Exception -> L21
        int r2 = getMeasuredHeight();     // Catch: Exception -> L21
        if (r1 <= 0) goto L20;
        if (r2 <= 0) goto L26;
        int r12 = OUnitExtensionKt.vdp(this, r10) + r1;     // Catch: Exception -> L21
        int r13 = OUnitExtensionKt.vdp(this, r11) + r2;     // Catch: Exception -> L21
        KtExt r3 = KtExt.INSTANCE;     // Catch: Exception -> L21
        ViewParent r4 = getParent();     // Catch: Exception -> L21
        if (r4 != null) goto L11;
    L9:
        r4 = null;
    L12:
        ViewGroup r5 = (ViewGroup) r4;     // Catch: Exception -> L21
        if (r5 == null) goto L18;
        r5.measure(0, 0);     // Catch: Exception -> L21
        int r0 = r5.getMeasuredWidth();     // Catch: Exception -> L21
        if (r13 > r5.getMeasuredHeight()) goto L17;
        if (r12 <= r0) goto L18;
    L17:
        ViewExtensionsKt.expandTouchArea$default(r5, r12, r13, false, 4, null);     // Catch: Exception -> L21
    L18:
        ViewExtensionsKt.expandTouchArea$default(this, r12, r13, false, 4, null);     // Catch: Exception -> L21
        return;
    L11:
        if ((r4 instanceof ViewGroup) == false) goto L9;
    L26:
        return;
    L20:
        return;
    L21:
        e = move-exception;
        L.e(TAG, "increaseTouchArea, error", e);
    }
}
