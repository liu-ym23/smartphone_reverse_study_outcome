package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.obric.common.oea.foundation.animation.builder.ValueAnimatable;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oea.foundation.animation.spec.AnimationSpecKt;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OProgressButton.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J(\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0014J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0010J\u000e\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\fJ\b\u0010\"\u001a\u00020\u0016H\u0002J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0007J\u0016\u0010#\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0010J\b\u0010%\u001a\u00020\u0016H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/oui/button/OProgressButton;", "Lcom/obric/oui/button/OButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "coveredTextColor", "currentProgress", "currentProgressFloat", "", "defaultBackgroundColor", "Ljava/lang/Integer;", "isInProgressMode", "", "progressAnimator", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "progressBgDrawableRes", "uncoveredTextColor", "changeToProgressDrawable", "", "onSizeChanged", "w", "h", "oldw", "oldh", "setProgress", "progressPercentage", "setProgressMode", "isProgressMode", "updateBackgroundProgress", "progress", "updateButtonMode", "updateProgress", "animate", "updateTextShader", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OProgressButton extends OButton {
    private final int coveredTextColor;
    private int currentProgress;
    private float currentProgressFloat;
    private Integer defaultBackgroundColor;
    private boolean isInProgressMode;
    private AnimationManager progressAnimator;
    private final int progressBgDrawableRes;
    private final int uncoveredTextColor;

    public OProgressButton(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OProgressButton(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 0;
    L5:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ int access$getCurrentProgress$p(OProgressButton r0) {
        return r0.currentProgress;
    }

    public static final /* synthetic */ float access$getCurrentProgressFloat$p(OProgressButton r0) {
        return r0.currentProgressFloat;
    }

    public static final /* synthetic */ boolean access$isInProgressMode$p(OProgressButton r0) {
        return r0.isInProgressMode;
    }

    public static final /* synthetic */ void access$setCurrentProgressFloat$p(OProgressButton r0, float r1) {
        r0.currentProgressFloat = r1;
    }

    public static final /* synthetic */ void access$updateTextShader(OProgressButton r0) {
        r0.updateTextShader();
    }

    public OProgressButton(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, 0, null, 24, null);
        TypedArray r13 = r10.obtainStyledAttributes(r11, R.styleable.OProgressButton);
        Intrinsics.checkNotNullExpressionValue(r13, "context.obtainStyledAttr…tyleable.OProgressButton)");
        this.coveredTextColor = r13.getColor(R.styleable.OProgressButton_android_textColor, ContextCompat.getColor(r10, R.color.oui_on_accent_default));
        this.uncoveredTextColor = r13.getColor(R.styleable.OProgressButton_oui_progress_button_uncovered_text_color, ContextCompat.getColor(r10, R.color.oui_accent_6_bg));
        this.progressBgDrawableRes = r13.getResourceId(R.styleable.OProgressButton_oui_progress_bg_resource, R.drawable.o_button_progress_drawable_primary);
        r13.recycle();
        Drawable r14 = getBackground();
        if ((r14 instanceof ColorDrawable) == false) goto L6;
        this.defaultBackgroundColor = Integer.valueOf(((ColorDrawable) r14).getColor());
        return;
    }

    private final void updateButtonMode() {
        if (this.isInProgressMode == false) goto L5;
        changeToProgressDrawable();
        return;
    L5:
        getPaint().setShader(null);
        setTextColor(this.coveredTextColor);
        if (this.defaultBackgroundColor == null) goto L8;
        Integer r1 = this.defaultBackgroundColor;
        Intrinsics.checkNotNull(r1);
        setBackground(new ColorDrawable(r1.intValue()));
    L8:
        invalidate();
    }

    private final void changeToProgressDrawable() {
        Drawable r0 = ContextCompat.getDrawable(getContext(), this.progressBgDrawableRes);
        ClipDrawable r1 = null;
        if (r0 != null) goto L5;
        Drawable r2 = null;
    L6:
        setBackground(r2);
        Drawable r3 = getBackground();
        if ((r3 instanceof LayerDrawable) == false) goto L16;
        Drawable r4 = ((LayerDrawable) r3).findDrawableByLayerId(android.R.id.progress);
        if ((r4 instanceof ClipDrawable) == false) goto L11;
        r1 = (ClipDrawable) r4;
    L11:
        Integer r5 = this.defaultBackgroundColor;
        if (r5 == null) goto L16;
        if (r1 == null) goto L16;
        Intrinsics.checkNotNull(r5);
        r1.setTint(r5.intValue());
    L16:
        updateBackgroundProgress(this.currentProgressFloat);
        updateTextShader();
        return;
    L5:
        r2 = r0.mutate();
        goto L6
    }

    public final void setProgressMode(boolean r2) {
        if (this.isInProgressMode == r2) goto L6;
        this.isInProgressMode = r2;
        updateButtonMode();
        return;
    }

    public final void setProgress(int r5) {
        if (this.currentProgress != r5) goto L5;
        return;
    L5:
        AnimationManager r0 = this.progressAnimator;
        if (r0 == null) goto L9;
        AnimationManager.cancelAnimation$default(r0, false, 1, null);
    L9:
        this.currentProgress = r5;
        float r6 = r5;
        this.currentProgressFloat = r6;
        updateBackgroundProgress(r6);
        if (this.isInProgressMode == false) goto L13;
        updateTextShader();
        return;
    }

    public final void updateProgress(int r2) {
        updateProgress(r2, false);
    }

    public final void updateProgress(int r10, boolean r11) {
        if (r11 == true) goto L6;
        setProgress(r10);
        return;
    L6:
        if (this.currentProgress != r10) goto L8;
        return;
    L8:
        this.currentProgress = r10;
        if (this.isInProgressMode == true) goto L11;
        return;
    L11:
        AnimationManager r12 = this.progressAnimator;
        if (r12 == null) goto L15;
        AnimationManager.cancelAnimation$default(r12, false, 1, null);
    L15:
        float r13 = Math.abs(this.currentProgressFloat - r10);
        int r1 = 100;
        if (r13 <= 10.0f) goto L18;
        r1 = (int) (100 + ((50 * r13) / 10));
    L18:
        this.progressAnimator = ValueAnimatable.Builder.of$default(new ValueAnimatable.Builder(), this.currentProgressFloat, this.currentProgress, AnimationSpecKt.tween(r1, 0, Token.Easing.OUI_ANIMATION_EASING_LINEAR), null, 8, null).onUpdate(new AnonymousClass1(this)).onEnd(new AnonymousClass2(this)).build().start();
        if (this.isInProgressMode == false) goto L22;
        updateTextShader();
        return;
    }

    public final void updateBackgroundProgress(float r2) {
        Drawable r1 = getBackground();
        if ((r1 instanceof LayerDrawable) == false) goto L12;
        Drawable r3 = ((LayerDrawable) r1).findDrawableByLayerId(android.R.id.progress);
        if ((r3 instanceof ClipDrawable) == false) goto L7;
        ClipDrawable r4 = (ClipDrawable) r3;
    L8:
        if (r4 == null) goto L13;
        r4.setLevel((int) (r2 * 100));
        return;
    L13:
        return;
    L7:
        r4 = null;
        goto L8
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.isInProgressMode == false) goto L6;
        updateTextShader();
        return;
    }

    private final void updateTextShader() {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        float r0 = this.currentProgressFloat / 100.0f;
        float r5 = getWidth();
        float r1 = RangesKt.coerceIn(r0, 0.0f, 1.0f);
        if (r1 > 0.0f) goto L9;
        getPaint().setShader(null);
        setTextColor(this.uncoveredTextColor);
    L12:
        invalidate();
        return;
    L9:
        if (r1 < 1.0f) goto L11;
        getPaint().setShader(null);
        setTextColor(this.coveredTextColor);
        goto L12
    L11:
        int r9 = this.coveredTextColor;
        int r10 = this.uncoveredTextColor;
        getPaint().setShader(new LinearGradient(0.0f, 0.0f, r5, 0.0f, new int[]{r9, r9, r10, r10}, new float[]{0.0f, r1, r1, 1.0f}, Shader.TileMode.CLAMP));
        setTextColor(this.coveredTextColor);
        goto L12
    }
}
