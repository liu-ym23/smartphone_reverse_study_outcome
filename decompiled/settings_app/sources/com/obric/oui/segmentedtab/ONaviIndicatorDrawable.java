package com.obric.oui.segmentedtab;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.obric.common.oea.foundation.animation.builder.ValueAnimatable;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oea.foundation.animation.spec.AnimationSpecKt;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.oui.common.style.SmoothCornerH;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: ONaviIndicatorDrawable.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001NB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\tH\u0002J\u0016\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u0004J\u0010\u0010?\u001a\u00020:2\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020\u0004H\u0016J\b\u0010C\u001a\u00020\u0004H\u0016J\b\u0010D\u001a\u00020\u0004H\u0016J\b\u0010E\u001a\u00020\u0004H\u0017J\u0010\u0010F\u001a\u00020:2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010G\u001a\u00020:2\b\u0010H\u001a\u0004\u0018\u00010\u0006J&\u0010I\u001a\u00020:2\u0006\u0010,\u001a\u00020\t2\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tJ\u0012\u0010J\u001a\u00020:2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J&\u0010M\u001a\u00020:2\u0006\u0010,\u001a\u00020\t2\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR$\u0010#\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR&\u0010&\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8F@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R\u000e\u0010(\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/obric/oui/segmentedtab/ONaviIndicatorDrawable;", "Landroid/graphics/drawable/Drawable;", "()V", "alpha", "", "animListener", "Lcom/obric/oui/segmentedtab/ONaviIndicatorDrawable$AnimListener;", "color", "currentHeight", "", "currentLeft", "currentTop", "currentWidth", "enableAnim", "", "value", "enableAnimation", "getEnableAnimation", "()Z", "setEnableAnimation", "(Z)V", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "indicatorColor", "getIndicatorColor", "()I", "setIndicatorColor", "(I)V", "indicatorCornerRadius", "getIndicatorCornerRadius", "()F", "setIndicatorCornerRadius", "(F)V", "indicatorHeight", "getIndicatorHeight", "setIndicatorHeight", "inset", "getInset", "setInset", "isAnimRunning", "setAnimRunning", "lastHeight", "lastLeft", "lastTop", "lastWidth", "left", "mBounds", "Landroid/graphics/Rect;", "maxWidthScale", "minHeightScale", "paint", "Landroid/graphics/Paint;", "positionAnimator", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "radius", "sizeAnimator", "top", MaterialConfigFormatNames.WIDTH, "calculateSizeByFraction", "", "fraction", "checkAndInitHeightAndRadius", "parentHeight", "spacing", "draw", "canvas", "Landroid/graphics/Canvas;", "getAlpha", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "setAlpha", "setAnimListener", "listener", "setBound", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "updateBound", "AnimListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ONaviIndicatorDrawable extends Drawable {
    private int alpha;
    private AnimListener animListener;
    private int color;
    private float currentHeight;
    private float currentLeft;
    private float currentTop;
    private float currentWidth;
    private boolean enableAnim;
    private float height;
    private float inset;
    private boolean isAnimRunning;
    private float lastHeight;
    private float lastLeft;
    private float lastTop;
    private float lastWidth;
    private float left;
    private Rect mBounds;
    private final float maxWidthScale;
    private final float minHeightScale;
    private final Paint paint;
    private AnimationManager positionAnimator;
    private float radius;
    private AnimationManager sizeAnimator;
    private float top;
    private float width;

    /* JADX INFO: compiled from: ONaviIndicatorDrawable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/segmentedtab/ONaviIndicatorDrawable$AnimListener;", "", "onAnimCancel", "", "onAnimEnd", "onAnimStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface AnimListener {
        void onAnimCancel();

        void onAnimEnd();

        void onAnimStart();
    }

    public ONaviIndicatorDrawable() {
        this.paint = new Paint();
        this.alpha = 255;
        this.mBounds = new Rect();
        this.enableAnim = true;
        this.maxWidthScale = 1.15f;
        this.minHeightScale = 0.85f;
    }

    public static final /* synthetic */ void access$calculateSizeByFraction(ONaviIndicatorDrawable r0, float r1) {
        r0.calculateSizeByFraction(r1);
    }

    public static final /* synthetic */ AnimListener access$getAnimListener$p(ONaviIndicatorDrawable r0) {
        return r0.animListener;
    }

    public static final /* synthetic */ float access$getLeft$p(ONaviIndicatorDrawable r0) {
        return r0.left;
    }

    public static final /* synthetic */ void access$setAnimRunning(ONaviIndicatorDrawable r0, boolean r1) {
        r0.setAnimRunning(r1);
    }

    public static final /* synthetic */ void access$setLeft$p(ONaviIndicatorDrawable r0, float r1) {
        r0.left = r1;
    }

    public final boolean isAnimRunning() {
        return this.isAnimRunning;
    }

    private final void setAnimRunning(boolean r1) {
        this.isAnimRunning = r1;
    }

    public final int getIndicatorColor() {
        return this.color;
    }

    public final void setIndicatorColor(int r2) {
        if (this.color == r2) goto L6;
        this.color = r2;
        this.paint.setColor(r2);
        invalidateSelf();
        return;
    }

    public final float getIndicatorCornerRadius() {
        return this.radius;
    }

    public final void setIndicatorCornerRadius(float r2) {
        if (this.radius != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.radius = r2;
        invalidateSelf();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final float getInset() {
        return this.inset;
    }

    public final void setInset(float r2) {
        if (this.inset != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.inset = r2;
        invalidateSelf();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.height;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.width;
    }

    public final float getIndicatorHeight() {
        return this.currentHeight;
    }

    public final void setIndicatorHeight(float r5) {
        boolean r1 = true;
        if (this.lastHeight != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.lastHeight = r5;
    L8:
        float r2 = this.currentHeight;
        if (r2 == r5) goto L12;
        r1 = false;
    L12:
        if (r1 == true) goto L15;
        this.lastHeight = r2;
        this.currentHeight = r5;
        this.height = r5;
        invalidateSelf();
        return;
    L15:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean getEnableAnimation() {
        return this.enableAnim;
    }

    public final void setEnableAnimation(boolean r1) {
        this.enableAnim = r1;
    }

    public final void setAnimListener(AnimListener r1) {
        this.animListener = r1;
    }

    public final void checkAndInitHeightAndRadius(int r3, int r4) {
        if (getIndicatorHeight() >= 0.0f) goto L6;
        setIndicatorHeight(r3 - (r4 * 2.0f));
    L6:
        if (getIndicatorCornerRadius() >= 0.0f) goto L8;
    L9:
        setIndicatorCornerRadius(getIndicatorHeight());
        return;
    L8:
        if (getIndicatorCornerRadius() > (getIndicatorHeight() / 2)) goto L9;
    }

    public final void setBound(float r1, float r2, float r3, float r4) {
        this.left = r1;
        this.top = r2;
        this.width = r3;
        this.height = r4;
        this.lastLeft = r1;
        this.lastTop = r2;
        this.lastWidth = r3;
        this.lastHeight = r4;
        this.currentLeft = r1;
        this.currentTop = r2;
        this.currentWidth = r3;
        this.currentHeight = r4;
    }

    public final void updateBound(float r9, float r10, float r11, float r12) {
        float r0 = this.currentWidth;
        if (r0 <= 0.0f) goto L5;
        this.lastLeft = this.currentLeft;
        this.lastWidth = r0;
        this.lastTop = this.currentTop;
    L5:
        float r1 = this.currentHeight;
        if (r1 <= 0.0f) goto L8;
        this.lastHeight = r1;
    L8:
        this.currentTop = r10;
        this.currentLeft = r9;
        this.currentWidth = r11;
        this.height = r12;
        if (this.lastLeft != r9) goto L11;
        boolean r13 = true;
    L12:
        if (r13 == true) goto L14;
    L19:
        AnimationManager r14 = this.positionAnimator;
        if (r14 == null) goto L23;
        AnimationManager.cancelAnimation$default(r14, false, 1, null);
    L23:
        AnimationManager r15 = this.sizeAnimator;
        if (r15 == null) goto L27;
        AnimationManager.cancelAnimation$default(r15, false, 1, null);
    L27:
        this.positionAnimator = ValueAnimatable.Builder.of$default(new ValueAnimatable.Builder(), this.lastLeft + ((this.lastWidth * (1 - this.maxWidthScale)) / 2.0f), this.currentLeft, AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0, 4, null), null, 8, null).onUpdate(new AnonymousClass1(this)).build().start();
        this.sizeAnimator = ValueAnimatable.Builder.of$default(new ValueAnimatable.Builder(), 0.0f, 1.0f, AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_4, Token.Duration.OUI_ANIMATION_DURATION_VERY_LONG_2, 0, 4, null), null, 8, null).onUpdate(new AnonymousClass2(this)).onEnd(new AnonymousClass3(this)).build().start();
        AnimListener r8 = this.animListener;
        if (r8 == null) goto L33;
        r8.onAnimStart();
        return;
    L33:
        return;
    L14:
        if (this.lastWidth != r11) goto L16;
        boolean r16 = true;
    L17:
        if (r16 == false) goto L19;
        invalidateSelf();
        return;
    L16:
        r16 = false;
        goto L17
    L11:
        r13 = false;
        goto L12
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        float r0 = this.lastTop;
        float r1 = (r0 + r0) + this.lastHeight;
        float r2 = 2;
        float r3 = this.height;
        float r5 = (r1 / r2) - (r3 / r2);
        this.top = r5;
        float r4 = this.left;
        SmoothCornerH.drawRoundRect(r11, r4, r5, r4 + this.width, r5 + r3, getIndicatorCornerRadius(), this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        if (r2 == this.alpha) goto L6;
        this.alpha = r2;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        if (this.alpha != 255) goto L5;
        return -1;
    L5:
        return -3;
    }

    private final void calculateSizeByFraction(float r5) {
        float r0 = this.lastWidth * this.maxWidthScale;
        float r1 = r0 + ((this.currentWidth - r0) * r5);
        boolean r2 = true;
        if (this.width != r1) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L8;
        this.width = r1;
        invalidateSelf();
    L8:
        float r4 = this.currentHeight;
        float r6 = this.minHeightScale * r4;
        float r7 = r6 + ((r4 - r6) * r5);
        if (this.height == r7) goto L12;
        r2 = false;
    L12:
        if (r2 == true) goto L15;
        this.height = r7;
        invalidateSelf();
        return;
    L15:
        return;
    L5:
        r3 = false;
        goto L6
    }
}
