package com.obric.oui.common.style;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oui.R;
import com.obric.oui.utils.ViewUtil;
import com.obric.oui.utils.log.L;
import java.lang.ref.WeakReference;
import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
public class OUIAlphaHelper implements IOUIAlpha {
    private static final boolean DEBUGGABLE = false;
    private static final String TAG = "OUIAlphaHelper";
    private AttributeSet mAttributeSet;
    private boolean mChangeAlphaWhenDisable;
    private boolean mChangeAlphaWhenPress;
    private boolean mChangeAlphaWhenSelected;
    private Context mContext;
    private int mDefAttr;
    private int mDefStyle;
    private boolean mDisablePressReleaseAnim;
    private float mDisabledAlpha;
    private boolean mKeepPressAlpha;
    private float mNormalAlpha;
    private int mOverridePressedColor;
    private ObjectAnimator mPressAnimator;
    private long mPressDuration;
    private int mPressedColor;
    private Drawable mPressedColorDrawable;
    private int mRadius;
    private ObjectAnimator mReleaseAnimator;
    private long mReleaseDuration;
    private Drawable mSelectedColorDrawable;
    private WeakReference<View> mTarget;
    private Boolean mUserChangeAlphaWhenDisable;
    private Boolean mUserChangeAlphaWhenPress;
    private Boolean mUserChangeAlphaWhenSelected;
    private Boolean mUserDisablePressReleaseAnim;

    static /* synthetic */ void access$000(OUIAlphaHelper r0) {
        r0.handleForegroundStatus();
    }

    public void setPressedColorDrawable(ColorDrawable r1) {
        this.mPressedColorDrawable = r1;
    }

    public OUIAlphaHelper(View r5) {
        this.mChangeAlphaWhenPress = true;
        this.mKeepPressAlpha = false;
        this.mChangeAlphaWhenDisable = true;
        this.mChangeAlphaWhenSelected = false;
        this.mDisablePressReleaseAnim = false;
        this.mUserChangeAlphaWhenPress = null;
        this.mUserChangeAlphaWhenDisable = null;
        this.mUserChangeAlphaWhenSelected = null;
        this.mUserDisablePressReleaseAnim = null;
        this.mNormalAlpha = 1.0f;
        this.mPressedColor = 0;
        this.mOverridePressedColor = -1;
        this.mDisabledAlpha = 0.3f;
        this.mPressDuration = 1;
        this.mReleaseDuration = Token.Duration.OUI_ANIMATION_DURATION_SHORT_4.getDuration();
        this.mRadius = 0;
        this.mTarget = new WeakReference(r5);
        int r0 = OUIResHelper.getAttrColor(r5.getContext(), R.attr.OUI_alpha_pressed);
        if (r0 <= 0) goto L5;
        this.mPressedColor = r0;
    L5:
        float r1 = OUIResHelper.getAttrFloatValue(r5.getContext(), R.attr.OUI_alpha_disabled);
        if (r1 <= 0.0f) goto L8;
        this.mDisabledAlpha = r1;
    L8:
        float r6 = r5.getAlpha();
        if (r6 <= 0.0f) goto L12;
        this.mNormalAlpha = r6;
        return;
    }

    public OUIAlphaHelper(View r5, int r6, float r7) {
        this.mChangeAlphaWhenPress = true;
        this.mKeepPressAlpha = false;
        this.mChangeAlphaWhenDisable = true;
        this.mChangeAlphaWhenSelected = false;
        this.mDisablePressReleaseAnim = false;
        this.mUserChangeAlphaWhenPress = null;
        this.mUserChangeAlphaWhenDisable = null;
        this.mUserChangeAlphaWhenSelected = null;
        this.mUserDisablePressReleaseAnim = null;
        this.mNormalAlpha = 1.0f;
        this.mPressedColor = 0;
        this.mOverridePressedColor = -1;
        this.mDisabledAlpha = 0.3f;
        this.mPressDuration = 1;
        this.mReleaseDuration = Token.Duration.OUI_ANIMATION_DURATION_SHORT_4.getDuration();
        this.mRadius = 0;
        this.mTarget = new WeakReference(r5);
        this.mPressedColor = r6;
        this.mDisabledAlpha = r7;
    }

    public OUIAlphaHelper(Context r7, AttributeSet r8, int r9, View r10) {
        this(r7, r8, r9, 0, r10);
    }

    public OUIAlphaHelper(Context r5, AttributeSet r6, int r7, int r8) {
        this.mChangeAlphaWhenPress = true;
        this.mKeepPressAlpha = false;
        this.mChangeAlphaWhenDisable = true;
        this.mChangeAlphaWhenSelected = false;
        this.mDisablePressReleaseAnim = false;
        this.mUserChangeAlphaWhenPress = null;
        this.mUserChangeAlphaWhenDisable = null;
        this.mUserChangeAlphaWhenSelected = null;
        this.mUserDisablePressReleaseAnim = null;
        this.mNormalAlpha = 1.0f;
        this.mPressedColor = 0;
        this.mOverridePressedColor = -1;
        this.mDisabledAlpha = 0.3f;
        this.mPressDuration = 1;
        this.mReleaseDuration = Token.Duration.OUI_ANIMATION_DURATION_SHORT_4.getDuration();
        this.mRadius = 0;
        this.mContext = r5;
        this.mAttributeSet = r6;
        this.mDefAttr = r7;
        this.mDefStyle = r8;
    }

    public OUIAlphaHelper(Context r1, AttributeSet r2, int r3, int r4, View r5) {
        this(r1, r2, r3, r4);
        initView(r5);
    }

    public void initView(View r2) {
        this.mTarget = new WeakReference(r2);
        initColors(r2);
    }

    public void setRadius(int r2) {
        if (this.mRadius == r2) goto L10;
        this.mRadius = r2;
        View r3 = this.mTarget.get();
        if (r3 != null) goto L8;
        L.e(TAG, "setRadius: owner is null");
        return;
    L8:
        initDrawableAnimator(r3);
        return;
    }

    public void setPressDuration(long r3) {
        if (this.mPressDuration == r3) goto L8;
        this.mPressDuration = r3;
        ObjectAnimator r2 = this.mPressAnimator;
        if (r2 == null) goto L9;
        r2.setDuration(r3);
        return;
    L9:
        return;
    }

    public void setReleaseDuration(long r3) {
        if (this.mReleaseDuration == r3) goto L8;
        this.mReleaseDuration = r3;
        ObjectAnimator r2 = this.mReleaseAnimator;
        if (r2 == null) goto L9;
        r2.setDuration(r3);
        return;
    L9:
        return;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void refreshColors(String r1) {
        View r2 = this.mTarget.get();
        if (r2 != null) goto L6;
        L.e(TAG, "refreshColors: owner is null");
        return;
    L6:
        initColors(r2);
    }

    private void initDrawableAnimator(View r6) {
        if (this.mRadius <= 0) goto L5;
        GradientDrawable r0 = new GradientDrawable();
        this.mPressedColorDrawable = r0;
        r0.setCornerRadius(this.mRadius);
        ((GradientDrawable) this.mPressedColorDrawable).setColor(this.mPressedColor);
        GradientDrawable r1 = new GradientDrawable();
        this.mSelectedColorDrawable = r1;
        r1.setCornerRadius(this.mRadius);
        ((GradientDrawable) this.mSelectedColorDrawable).setColor(this.mPressedColor);
    L6:
        boolean r2 = true;
        if (this.mUserChangeAlphaWhenPress != null) goto L14;
        if (this.mPressedColor <= 0) goto L11;
        boolean r3 = true;
    L12:
        this.mChangeAlphaWhenPress = r3;
        goto L14
    L11:
        r3 = false;
    L14:
        if (this.mUserChangeAlphaWhenDisable == null) goto L16;
    L20:
        onEnabledChanged(r6, r6.isEnabled());
        ObjectAnimator r7 = ObjectAnimator.ofInt(this.mPressedColorDrawable, "alpha", new int[]{255, 255});
        this.mPressAnimator = r7;
        r7.setDuration(this.mPressDuration);
        this.mPressAnimator.setInterpolator(null);
        this.mPressAnimator.addUpdateListener(new OUIAlphaHelper$$ExternalSyntheticLambda2(this));
        ObjectAnimator r8 = ObjectAnimator.ofInt(this.mPressedColorDrawable, "alpha", new int[]{255, 0});
        this.mReleaseAnimator = r8;
        r8.setDuration(this.mReleaseDuration);
        this.mReleaseAnimator.setInterpolator(null);
        this.mReleaseAnimator.addListener(new AnonymousClass1(this));
        this.mReleaseAnimator.addUpdateListener(new OUIAlphaHelper$$ExternalSyntheticLambda3(this));
        return;
    L16:
        if (this.mDisabledAlpha > 0.0f) goto L19;
        r2 = false;
    L19:
        this.mChangeAlphaWhenDisable = r2;
        goto L20
    L5:
        this.mPressedColorDrawable = new ColorDrawable(this.mPressedColor);
        this.mSelectedColorDrawable = new ColorDrawable(this.mPressedColor);
        goto L6
    }

    /* JADX INFO: renamed from: lambda$initDrawableAnimator$0$com-obric-oui-common-style-OUIAlphaHelper, reason: not valid java name */
    /* synthetic */ void m1090x6e8615f7(ValueAnimator r2) {
        pressColorAnimSideEffect(r2, "press anim");
    }

    /* JADX INFO: renamed from: lambda$initDrawableAnimator$1$com-obric-oui-common-style-OUIAlphaHelper, reason: not valid java name */
    /* synthetic */ void m1091x53c784b8(ValueAnimator r2) {
        pressColorAnimSideEffect(r2, "release anim");
    }

    private void initColors(View r10) {
        int r0 = getDefaultPressColor(r10);
        int r4 = 0;
        int[] r2 = {ContextCompat.getColor(r10.getContext(), R.color.oui_accent_bg), ContextCompat.getColor(r10.getContext(), R.color.oui_functional_red_6)};
        this.mPressedColor = r0;
        TypedArray r3 = this.mContext.obtainStyledAttributes(this.mAttributeSet, R.styleable.OUIAlpha, this.mDefAttr, this.mDefStyle);
        if (this.mAttributeSet == null) goto L5;
    L8:
        int r5 = r3.getIndexCount();
        int r6 = 0;
    L9:
        if (r6 >= r5) goto L18;
        int r7 = r3.getIndex(r6);
        if (r7 != R.styleable.OUIAlpha_OUI_alpha_pressed) goto L14;
        this.mPressedColor = r3.getColor(r7, r0);
    L16:
        r6 = r6 + 1;
        goto L9
    L14:
        if (r7 != R.styleable.OUIAlpha_OUI_alpha_disabled) goto L16;
        this.mDisabledAlpha = r3.getFloat(r7, -1.0f);
    L18:
        if (this.mPressedColor != r0) goto L26;
        Drawable r1 = r10.getBackground();
        if ((r1 instanceof ColorDrawable) == false) goto L26;
    L21:
        if (r4 >= 2) goto L26;
        if (((ColorDrawable) r1).getColor() != r2[r4]) goto L25;
        this.mPressedColor = ContextCompat.getColor(r10.getContext(), R.color.oui_pressed_on_color);
    L25:
        r4 = r4 + 1;
    L26:
        initDrawableAnimator(r10);
        return;
    L5:
        if (this.mDefAttr != 0) goto L8;
        if (this.mDefStyle == 0) goto L18;
        goto L8
    }

    private int getDefaultPressColor(View r2) {
        int r1 = this.mOverridePressedColor;
        if (r1 == (-1)) goto L5;
        return r1;
    L5:
        return ContextCompat.getColor(r2.getContext(), R.color.oui_fill_element_2);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setOverridePressColor(int r2) {
        if (this.mOverridePressedColor == r2) goto L6;
        this.mOverridePressedColor = r2;
        return;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setKeepPressAlpha(final boolean r3) {
        L.v(TAG, "setKeepPressAlpha, " + r3 + ", target: " + this.mTarget.get());
        if (this.mKeepPressAlpha == r3) goto L7;
        this.mKeepPressAlpha = r3;
        if (r3 == true) goto L7;
        onPressedChanged(this.mTarget.get(), false);
    L7:
        ViewUtil.traverseDescendants(this.mTarget.get(), new OUIAlphaHelper$$ExternalSyntheticLambda1(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Unit lambda$setKeepPressAlpha$2(boolean r1, View r2) {
        if ((r2 instanceof IOUIAlpha) == false) goto L7;
        ((IOUIAlpha) r2).setKeepPressAlpha(r1);
        return null;
    L7:
        return null;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void onPressedChanged(View r1, boolean r2) {
        if (this.mTarget.get() != null) goto L5;
        return;
    L5:
        this.mPressAnimator.cancel();
        this.mReleaseAnimator.cancel();
        if (this.mChangeAlphaWhenPress == true) goto L8;
        return;
    L8:
        if (this.mKeepPressAlpha == true) goto L17;
        if (r2 == false) goto L12;
        handleForegroundStatus();
        this.mPressAnimator.start();
        return;
    L12:
        if (this.mDisablePressReleaseAnim == false) goto L14;
        skipPressAnim();
        return;
    L14:
        this.mReleaseAnimator.start();
        return;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void onSelectedChanged(View r1, boolean r2) {
        if (this.mChangeAlphaWhenSelected == false) goto L6;
        handleForegroundStatus();
        return;
    }

    public void onEnabledChanged(View r3, boolean r4) {
        View r0 = this.mTarget.get();
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.mChangeAlphaWhenDisable == false) goto L10;
        if (r4 == false) goto L9;
        float r2 = this.mNormalAlpha;
    L11:
        if (r3 != r0) goto L13;
    L15:
        r0.setAlpha(r2);
        return;
    L13:
        if (r0.isEnabled() == r4) goto L15;
        r0.setEnabled(r4);
        goto L15
    L9:
        r2 = this.mDisabledAlpha;
        goto L11
    L10:
        r2 = this.mNormalAlpha;
        goto L11
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenPress(boolean r2) {
        setChangeAlphaWhenPress(r2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleForegroundStatus() {
        View r0 = this.mTarget.get();
        if (r0 != 0) goto L6;
        return;
    L6:
        if (this.mChangeAlphaWhenPress == false) goto L15;
        if (r0.isPressed() == false) goto L10;
    L13:
        r0.setForeground(this.mPressedColorDrawable);
        return;
    L10:
        if ((r0 instanceof IOUILayout) == false) goto L15;
        if (((IOUILayout) r0).isFakePressed() == true) goto L13;
    L15:
        if (this.mChangeAlphaWhenPress == false) goto L22;
        if ((r0 instanceof IOUILayout) == false) goto L22;
        if (((IOUILayout) r0).decideIsNeedUpdatePressedForegroundBySelf() == false) goto L22;
        r0.setForeground(this.mPressedColorDrawable);
        return;
    L22:
        if (this.mChangeAlphaWhenSelected == true) goto L24;
    L26:
        r0.setForeground(null);
        return;
    L24:
        if (r0.isSelected() == false) goto L26;
        r0.setForeground(this.mSelectedColorDrawable);
    }

    public void setChangeAlphaWhenPress(boolean r2, boolean r3) {
        this.mUserChangeAlphaWhenPress = Boolean.valueOf(r2);
        this.mChangeAlphaWhenPress = r2;
        View r4 = this.mTarget.get();
        if (r4 == null) goto L7;
        if (r3 == false) goto L8;
        onPressedChanged(r4, r4.isPressed());
        return;
    L8:
        return;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenDisable(boolean r2) {
        this.mUserChangeAlphaWhenDisable = Boolean.valueOf(r2);
        this.mChangeAlphaWhenDisable = r2;
        View r3 = this.mTarget.get();
        if (r3 == null) goto L6;
        onEnabledChanged(r3, r3.isEnabled());
        return;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenSelected(boolean r2) {
        this.mUserChangeAlphaWhenSelected = Boolean.valueOf(r2);
        this.mChangeAlphaWhenSelected = r2;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void disablePressReleaseAnim(boolean r2) {
        this.mUserDisablePressReleaseAnim = Boolean.valueOf(r2);
        this.mDisablePressReleaseAnim = r2;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void resetAlphaAnim() {
        this.mKeepPressAlpha = false;
        if (this.mChangeAlphaWhenPress == false) goto L5;
        skipPressAnim();
    L5:
        ViewUtil.traverseDescendants(this.mTarget.get(), new OUIAlphaHelper$$ExternalSyntheticLambda0());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Unit lambda$resetAlphaAnim$3(View r1) {
        if ((r1 instanceof IOUIAlpha) == false) goto L7;
        ((IOUIAlpha) r1).resetAlphaAnim();
        return null;
    L7:
        return null;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void handleTouchEvent(MotionEvent r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        int r3 = r2.getAction();
        if (r3 == 1) goto L10;
        if (r3 == 3) goto L10;
        return;
    L10:
        if (this.mDisablePressReleaseAnim == false) goto L13;
        skipPressAnim();
        return;
    }

    private void skipPressAnim() {
        this.mPressAnimator.cancel();
        this.mReleaseAnimator.cancel();
        this.mPressedColorDrawable.setAlpha(0);
        View r2 = this.mTarget.get();
        if (r2 == null) goto L6;
        r2.setForeground(null);
        return;
    }

    private void pressColorAnimSideEffect(ValueAnimator r4, String r5) {
        KeyEvent.Callback r3 = (View) this.mTarget.get();
        if ((r3 instanceof IOUILayout) == true) goto L5;
        return;
    L5:
        IOUILayout r6 = (IOUILayout) r3;
        Object r7 = r4.getAnimatedValue("alpha");
        if (r6.shouldUpdateDividerColorOnPress() == false) goto L16;
        if ((r7 instanceof Integer) == false) goto L16;
        int r0 = ((Integer) r7).intValue();
        if (r0 >= 0) goto L12;
    L14:
        L.e(TAG, "pressColorAnimSideEffect, invalid alpha: " + r0 + ", scene: " + r5);
        goto L16
    L12:
        if (r0 > 255) goto L14;
        r6.updateDividerColorStrength((255 - r0) / 255.0f);
    L16:
        if ((r7 instanceof Integer) == false) goto L19;
        r6.onPressAlphaChange(((Integer) r7).intValue());
        return;
    }
}
