package com.obric.oui.privacy.recyclerview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PrivacyTopDownAlphaMaskRecyclerView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 L2\u00020\u0001:\u0001LB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u000eH\u0002J\b\u00107\u001a\u00020\u000eH\u0002J\u0010\u00108\u001a\u0002042\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u0002042\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010<\u001a\u0002042\u0006\u00109\u001a\u00020:H\u0002J\b\u0010=\u001a\u00020\u000eH\u0002J\b\u0010>\u001a\u000204H\u0002J\b\u0010?\u001a\u000204H\u0002J\b\u0010@\u001a\u000204H\u0014J\u0018\u0010A\u001a\u0002042\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007H\u0014J(\u0010D\u001a\u0002042\u0006\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u0007H\u0014J\b\u0010I\u001a\u000204H\u0002J\u0010\u0010J\u001a\u0002042\b\b\u0002\u0010K\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR$\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010&\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010\u001aR\u000e\u0010)\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/obric/oui/privacy/recyclerview/PrivacyTopDownAlphaMaskRecyclerView;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allowFadeUpdates", "", "animator", "Landroid/animation/ValueAnimator;", "bottomFadeStrength", "", "bottomShader", "Landroid/graphics/LinearGradient;", "bottomShaderMatrix", "Landroid/graphics/Matrix;", "detectStackTypeChanged", "dstInXfermode", "Landroid/graphics/PorterDuffXfermode;", "dynamicFade", "getDynamicFade", "()Z", "setDynamicFade", "(Z)V", "value", "fadeBottom", "getFadeBottom", "setFadeBottom", "fadeEdgeLength", "getFadeEdgeLength", "()F", "setFadeEdgeLength", "(F)V", "fadePaint", "Landroid/graphics/Paint;", "fadeTop", "getFadeTop", "setFadeTop", "lastTargetBottomStrength", "lastTargetTopStrength", "shaderBottomStrength", "shaderFadeEdgeLength", "shaderHeight", "shaderTopStrength", "shaderWidth", "topFadeStrength", "topShader", "topShaderMatrix", "animateFadeStrength", "", "targetTop", "targetBottom", "defaultFadeEdgeLength", "draw", "canvas", "Landroid/graphics/Canvas;", "drawBottomFade", "drawTopFade", "effectiveFadeEdgeLength", "ensureFadeShaders", "invalidateFadeShaders", "onDetachedFromWindow", "onMeasure", "widthSpec", "heightSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "rebuildFadeShaders", "updateFadeVisibility", "animate", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrivacyTopDownAlphaMaskRecyclerView extends RecyclerView {
    public static final Companion Companion = null;
    private static final int DEFAULT_FADE_EDGE_DP = 75;
    private static final long FADE_ANIMATION_DURATION = 100;
    private static final float[] FADE_POSITIONS = null;
    private boolean allowFadeUpdates;
    private ValueAnimator animator;
    private float bottomFadeStrength;
    private LinearGradient bottomShader;
    private final Matrix bottomShaderMatrix;
    private boolean detectStackTypeChanged;
    private final PorterDuffXfermode dstInXfermode;
    private boolean dynamicFade;
    private boolean fadeBottom;
    private float fadeEdgeLength;
    private final Paint fadePaint;
    private boolean fadeTop;
    private float lastTargetBottomStrength;
    private float lastTargetTopStrength;
    private float shaderBottomStrength;
    private float shaderFadeEdgeLength;
    private int shaderHeight;
    private float shaderTopStrength;
    private int shaderWidth;
    private float topFadeStrength;
    private LinearGradient topShader;
    private final Matrix topShaderMatrix;

    /* JADX INFO: compiled from: PrivacyTopDownAlphaMaskRecyclerView.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/oui/privacy/recyclerview/PrivacyTopDownAlphaMaskRecyclerView$Companion;", "", "()V", "DEFAULT_FADE_EDGE_DP", "", "FADE_ANIMATION_DURATION", "", "FADE_POSITIONS", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$597EiQ9LW45s6htDZiN4ifMgXDU(PrivacyTopDownAlphaMaskRecyclerView r0, float r1, float r2, float r3, float r4, ValueAnimator r5) {
        m461animateFadeStrength$lambda2$lambda1(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$TLlQ6YUx1d0nGDY1kTW4R4joph8(PrivacyTopDownAlphaMaskRecyclerView r0) {
        m462onSizeChanged$lambda0(r0);
    }

    public PrivacyTopDownAlphaMaskRecyclerView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public PrivacyTopDownAlphaMaskRecyclerView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ PrivacyTopDownAlphaMaskRecyclerView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ boolean access$getAllowFadeUpdates$p(PrivacyTopDownAlphaMaskRecyclerView r0) {
        return r0.allowFadeUpdates;
    }

    public static final /* synthetic */ void access$setAllowFadeUpdates$p(PrivacyTopDownAlphaMaskRecyclerView r0, boolean r1) {
        r0.allowFadeUpdates = r1;
    }

    public PrivacyTopDownAlphaMaskRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.fadeEdgeLength = defaultFadeEdgeLength();
        this.dynamicFade = true;
        this.fadeTop = true;
        this.fadeBottom = true;
        this.fadePaint = new Paint(1);
        this.dstInXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.topShaderMatrix = new Matrix();
        this.bottomShaderMatrix = new Matrix();
        this.shaderWidth = -1;
        this.shaderHeight = -1;
        this.shaderFadeEdgeLength = -1.0f;
        this.shaderTopStrength = Float.NaN;
        this.shaderBottomStrength = Float.NaN;
        this.detectStackTypeChanged = true;
        if (this.dynamicFade == false) goto L6;
        addOnScrollListener(new AnonymousClass1(this));
        return;
    }

    static {
        Companion = new Companion(null);
        FADE_POSITIONS = new float[]{0.0f, 1.0f};
    }

    public final float getFadeEdgeLength() {
        return this.fadeEdgeLength;
    }

    public final void setFadeEdgeLength(float r2) {
        float r3 = RangesKt.coerceAtLeast(r2, 0.0f);
        if (this.fadeEdgeLength != r3) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.fadeEdgeLength = r3;
        invalidateFadeShaders();
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean getDynamicFade() {
        return this.dynamicFade;
    }

    public final void setDynamicFade(boolean r1) {
        this.dynamicFade = r1;
    }

    public final boolean getFadeTop() {
        return this.fadeTop;
    }

    public final void setFadeTop(boolean r2) {
        if (this.fadeTop != r2) goto L5;
        return;
    L5:
        this.fadeTop = r2;
        invalidate();
    }

    public final boolean getFadeBottom() {
        return this.fadeBottom;
    }

    public final void setFadeBottom(boolean r2) {
        if (this.fadeBottom != r2) goto L5;
        return;
    L5:
        this.fadeBottom = r2;
        invalidate();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        if ((getLayoutManager() instanceof LinearLayoutManager) == true) goto L5;
        return;
    L5:
        if (this.detectStackTypeChanged == false) goto L27;
        int r5 = computeVerticalScrollRange();
        if (r5 <= 0) goto L28;
        int r6 = 0;
        this.detectStackTypeChanged = false;
        if (r5 > ((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom())) goto L11;
        boolean r7 = true;
    L12:
        RecyclerView.LayoutManager r0 = getLayoutManager();
        if (r0 == null) goto L25;
        if (((LinearLayoutManager) r0).getStackFromEnd() == r7) goto L21;
        RecyclerView.LayoutManager r1 = getLayoutManager();
        if (r1 == null) goto L20;
        ((LinearLayoutManager) r1).setStackFromEnd(r7);
        goto L21
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.orecyclerview.widget.LinearLayoutManager");
    L21:
        if (r7 == false) goto L23;
        r6 = 2;
    L23:
        setOverScrollMode(r6);
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.orecyclerview.widget.LinearLayoutManager");
    L11:
        r7 = false;
        goto L12
    L28:
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        invalidateFadeShaders();
        post(new PrivacyTopDownAlphaMaskRecyclerView$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: onSizeChanged$lambda-0, reason: not valid java name */
    private static final void m462onSizeChanged$lambda0(PrivacyTopDownAlphaMaskRecyclerView r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.dynamicFade == false) goto L5;
        r1.allowFadeUpdates = false;
        r1.updateFadeVisibility(false);
        return;
    L5:
        r1.topFadeStrength = 1.0f;
        r1.bottomFadeStrength = 1.0f;
        r1.invalidateFadeShaders();
        r1.invalidate();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.View
    public void draw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        if (getWidth() > 0) goto L5;
    L31:
        super.draw(r9);
        return;
    L5:
        if (getHeight() <= 0) goto L31;
        if (this.fadeEdgeLength <= 0.0f) goto L31;
        if (this.fadeTop == true) goto L14;
        if (this.fadeBottom == true) goto L14;
    L17:
        super.draw(r9);
        return;
    L14:
        if (this.topFadeStrength <= 0.0f) goto L16;
    L19:
        ensureFadeShaders();
        int r0 = r9.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        super.draw(r9);
        this.fadePaint.setXfermode(this.dstInXfermode);
        if (this.fadeTop == false) goto L25;
        if (this.topFadeStrength <= 0.0f) goto L25;
        drawTopFade(r9);
    L25:
        if (this.fadeBottom == true) goto L27;
    L29:
        this.fadePaint.setXfermode(null);
        this.fadePaint.setShader(null);
        r9.restoreToCount(r0);
        return;
    L27:
        if (this.bottomFadeStrength <= 0.0f) goto L29;
        drawBottomFade(r9);
        goto L29
    L16:
        if (this.bottomFadeStrength > 0.0f) goto L19;
        goto L17
    }

    public static /* synthetic */ void updateFadeVisibility$default(PrivacyTopDownAlphaMaskRecyclerView r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.updateFadeVisibility(r1);
    }

    public final void updateFadeVisibility(boolean r7) {
        boolean r0 = canScrollVertically(-1);
        boolean r1 = true;
        boolean r2 = canScrollVertically(1);
        float r4 = 1.0f;
        if (this.fadeTop == false) goto L6;
        if (r0 == false) goto L6;
        float r3 = 1.0f;
    L8:
        if (this.fadeBottom == false) goto L11;
        if (r2 == false) goto L11;
    L12:
        if (r7 == true) goto L14;
        this.lastTargetTopStrength = r3;
        this.lastTargetBottomStrength = r4;
        this.topFadeStrength = r3;
        this.bottomFadeStrength = r4;
        invalidateFadeShaders();
        invalidate();
        return;
    L14:
        if (this.lastTargetTopStrength != r3) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == true) goto L19;
    L24:
        this.lastTargetTopStrength = r3;
        this.lastTargetBottomStrength = r4;
        animateFadeStrength(r3, r4);
        return;
    L19:
        if (this.lastTargetBottomStrength == r4) goto L22;
        r1 = false;
    L22:
        if (r1 == false) goto L24;
        return;
    L16:
        r8 = false;
    L11:
        r4 = 0.0f;
    L6:
        r3 = 0.0f;
        goto L8
    }

    private final void animateFadeStrength(final float r9, final float r10) {
        final float r2 = this.topFadeStrength;
        final float r4 = this.bottomFadeStrength;
        boolean r1 = true;
        if (r2 != r9) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L13:
        ValueAnimator r3 = this.animator;
        if (r3 == null) goto L17;
        r3.cancel();
    L17:
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r6.setDuration(100);
        r6.addUpdateListener(new PrivacyTopDownAlphaMaskRecyclerView$$ExternalSyntheticLambda1(this, r2, r9, r4, r10));
        this.animator = r6;
        if (r6 == null) goto L22;
        r6.start();
        return;
    L22:
        return;
    L8:
        if (r4 == r10) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        return;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX INFO: renamed from: animateFadeStrength$lambda-2$lambda-1, reason: not valid java name */
    private static final void m461animateFadeStrength$lambda2$lambda1(PrivacyTopDownAlphaMaskRecyclerView r1, float r2, float r3, float r4, float r5, ValueAnimator r6) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r6, "anim");
        Object r7 = r6.getAnimatedValue();
        if (r7 == null) goto L7;
        float r8 = ((Float) r7).floatValue();
        r1.topFadeStrength = r2 + ((r3 - r2) * r8);
        r1.bottomFadeStrength = r4 + ((r5 - r4) * r8);
        r1.invalidateFadeShaders();
        r1.invalidate();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    private final void drawTopFade(Canvas r7) {
        float r4 = effectiveFadeEdgeLength();
        if (r4 > 0.0f) goto L5;
        return;
    L5:
        LinearGradient r0 = this.topShader;
        if (r0 != null) goto L8;
        return;
    L8:
        this.topShaderMatrix.reset();
        r0.setLocalMatrix(this.topShaderMatrix);
        this.fadePaint.setShader(r0);
        r7.drawRect(0.0f, 0.0f, getWidth(), r4, this.fadePaint);
    }

    private final void drawBottomFade(Canvas r10) {
        float r0 = effectiveFadeEdgeLength();
        if (r0 > 0.0f) goto L5;
        return;
    L5:
        float r7 = getHeight();
        float r5 = RangesKt.coerceAtLeast(r7 - r0, 0.0f);
        LinearGradient r1 = this.bottomShader;
        if (r1 != null) goto L8;
        return;
    L8:
        this.bottomShaderMatrix.reset();
        this.bottomShaderMatrix.setTranslate(0.0f, r5);
        r1.setLocalMatrix(this.bottomShaderMatrix);
        this.fadePaint.setShader(r1);
        r10.drawRect(0.0f, r5, getWidth(), r7, this.fadePaint);
    }

    private final void ensureFadeShaders() {
        if (this.shaderWidth == getWidth()) goto L5;
    L22:
        rebuildFadeShaders();
        return;
    L5:
        if (this.shaderHeight != getHeight()) goto L22;
        boolean r1 = true;
        if (this.shaderFadeEdgeLength != this.fadeEdgeLength) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L22;
        if (this.shaderTopStrength != this.topFadeStrength) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L22;
        if (this.shaderBottomStrength == this.bottomFadeStrength) goto L20;
        r1 = false;
    L20:
        if (r1 == false) goto L22;
        return;
    L14:
        r2 = false;
        goto L15
    L9:
        r0 = false;
        goto L10
    }

    private final void rebuildFadeShaders() {
        this.shaderWidth = getWidth();
        this.shaderHeight = getHeight();
        this.shaderFadeEdgeLength = this.fadeEdgeLength;
        this.shaderTopStrength = this.topFadeStrength;
        this.shaderBottomStrength = this.bottomFadeStrength;
        float r1 = effectiveFadeEdgeLength();
        LinearGradient r10 = null;
        if (getWidth() > 0) goto L5;
    L23:
        this.topShader = null;
        this.bottomShader = null;
        return;
    L5:
        if (getHeight() <= 0) goto L23;
        if (r1 <= 0.0f) goto L23;
        float r2 = RangesKt.coerceIn(this.topFadeStrength, 0.0f, 1.0f);
        float r12 = RangesKt.coerceIn(this.bottomFadeStrength, 0.0f, 1.0f);
        int r4 = RangesKt.coerceIn((int) ((1.0f - r2) * 255.0f), 0, 255);
        int r15 = RangesKt.coerceIn((int) ((1.0f - r12) * 255.0f), 0, 255);
        if (r2 > 0.0f) goto L12;
    L14:
        LinearGradient r3 = (LinearGradient) null;
        LinearGradient r5 = null;
    L15:
        this.topShader = r5;
        if (r12 > 0.0f) goto L18;
    L20:
        LinearGradient r6 = (LinearGradient) null;
    L21:
        this.bottomShader = r10;
        return;
    L18:
        if (this.bottomShader != null) goto L20;
        r10 = new LinearGradient(0.0f, r1, 0.0f, 0.0f, new int[]{Color.argb(r15, 0, 0, 0), Color.argb(255, 0, 0, 0)}, FADE_POSITIONS, Shader.TileMode.CLAMP);
        goto L21
    L12:
        if (this.topShader != null) goto L14;
        r5 = new LinearGradient(0.0f, 0.0f, 0.0f, r1, new int[]{Color.argb(r4, 0, 0, 0), Color.argb(255, 0, 0, 0)}, FADE_POSITIONS, Shader.TileMode.CLAMP);
        goto L15
    }

    private final void invalidateFadeShaders() {
        this.shaderWidth = -1;
        this.shaderHeight = -1;
        this.shaderFadeEdgeLength = -1.0f;
        this.shaderTopStrength = Float.NaN;
        this.shaderBottomStrength = Float.NaN;
        this.topShader = null;
        this.bottomShader = null;
    }

    private final float effectiveFadeEdgeLength() {
        return RangesKt.coerceAtMost(this.fadeEdgeLength, getHeight());
    }

    private final float defaultFadeEdgeLength() {
        return TypedValue.applyDimension(1, 75.0f, getResources().getDisplayMetrics());
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r0 = this.animator;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        removeCallbacks(null);
    }
}
