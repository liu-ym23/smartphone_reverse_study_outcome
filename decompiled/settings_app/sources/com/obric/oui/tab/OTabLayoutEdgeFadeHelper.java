package com.obric.oui.tab;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.View;
import com.android.settings.search.IndexDatabaseHelper;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: OTabLayoutHelper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 D2\u00020\u0001:\u0001DB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0002J>\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\fJ\u0010\u0010-\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010.\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\nH\u0002J\u0006\u0010/\u001a\u00020\nJ\b\u00100\u001a\u00020\u001cH\u0002J\u0006\u00101\u001a\u00020\fJ \u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\nH\u0002J\b\u00106\u001a\u00020\fH\u0002J\u0010\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\nH\u0002J\u0010\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\fH\u0002J\u000e\u0010;\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u00020\nJ\u0016\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u0015J\u0006\u0010A\u001a\u00020\fJ\u0006\u0010B\u001a\u00020\fJ\u001e\u0010C\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/obric/oui/tab/OTabLayoutEdgeFadeHelper;", "", "()V", "animator", "Landroid/animation/ValueAnimator;", "dstInXfermode", "Landroid/graphics/PorterDuffXfermode;", "edgeFadePaint", "Landroid/graphics/Paint;", "edgeFadeShaderLength", "", IndexDatabaseHelper.IndexColumns.ENABLED, "", "fadeLength", "lastTargetLeftStrength", "lastTargetRightStrength", "leftEdgeFadeMatrix", "Landroid/graphics/Matrix;", "leftEdgeFadeShader", "Landroid/graphics/LinearGradient;", "leftEdgeFadeShaderAlpha", "", "leftFadeStrength", "rightEdgeFadeMatrix", "rightEdgeFadeShader", "rightEdgeFadeShaderAlpha", "rightFadeStrength", "animateFadeStrength", "", "targetLeftStrength", "targetRightStrength", "invalidateView", "Landroid/view/View;", "clearAnimatorReference", "animation", "Landroid/animation/Animator;", "drawOverlay", "canvas", "Landroid/graphics/Canvas;", "left", "top", "right", "bottom", "showLeftFade", "showRightFade", "ensureLeftEdgeFadeShader", "ensureRightEdgeFadeShader", "getFadeLength", "invalidateShaders", "isEnabled", "lerp", "start", TraceStatsConsts.STATS_KEY_END, "fraction", "resetFadeState", "resolveEdgeAlpha", "strength", "resolveTargetStrength", "visible", "setEnabled", "setFadeLength", "lengthPx", "shouldApply", MaterialConfigFormatNames.WIDTH, MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "shouldDrawLeftFade", "shouldDrawRightFade", "updateFadeVisibility", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTabLayoutEdgeFadeHelper {
    public static final Companion Companion = null;
    public static final float DEFAULT_EDGE_FADE_LENGTH_DP = 20.0f;
    private static final long EDGE_FADE_ANIM_DURATION_MS = 120;
    private static final float[] EDGE_FADE_POSITIONS = null;
    private ValueAnimator animator;
    private final PorterDuffXfermode dstInXfermode;
    private final Paint edgeFadePaint;
    private float edgeFadeShaderLength;
    private boolean enabled;
    private float fadeLength;
    private float lastTargetLeftStrength;
    private float lastTargetRightStrength;
    private final Matrix leftEdgeFadeMatrix;
    private LinearGradient leftEdgeFadeShader;
    private int leftEdgeFadeShaderAlpha;
    private float leftFadeStrength;
    private final Matrix rightEdgeFadeMatrix;
    private LinearGradient rightEdgeFadeShader;
    private int rightEdgeFadeShaderAlpha;
    private float rightFadeStrength;

    /* JADX INFO: compiled from: OTabLayoutHelper.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/oui/tab/OTabLayoutEdgeFadeHelper$Companion;", "", "()V", "DEFAULT_EDGE_FADE_LENGTH_DP", "", "EDGE_FADE_ANIM_DURATION_MS", "", "EDGE_FADE_POSITIONS", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$JeftXzEu57SC3BAcN92uu7dvkx8(OTabLayoutEdgeFadeHelper r0, float r1, float r2, float r3, float r4, View r5, ValueAnimator r6) {
        m1409animateFadeStrength$lambda1$lambda0(r0, r1, r2, r3, r4, r5, r6);
    }

    private final float resolveTargetStrength(boolean r1) {
        if (r1 == false) goto L4;
        return 1.0f;
    L4:
        return 0.0f;
    }

    public OTabLayoutEdgeFadeHelper() {
        this.edgeFadePaint = new Paint(1);
        this.dstInXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.leftEdgeFadeMatrix = new Matrix();
        this.rightEdgeFadeMatrix = new Matrix();
        this.edgeFadeShaderLength = -1.0f;
        this.leftEdgeFadeShaderAlpha = -1;
        this.rightEdgeFadeShaderAlpha = -1;
    }

    public static final /* synthetic */ void access$clearAnimatorReference(OTabLayoutEdgeFadeHelper r0, Animator r1) {
        r0.clearAnimatorReference(r1);
    }

    static {
        Companion = new Companion(null);
        EDGE_FADE_POSITIONS = new float[]{0.0f, 1.0f};
    }

    public final void updateFadeVisibility(boolean r3, boolean r4, View r5) {
        Intrinsics.checkNotNullParameter(r5, "invalidateView");
        if (this.enabled == false) goto L10;
        if (this.fadeLength <= 0.0f) goto L10;
        animateFadeStrength(resolveTargetStrength(r3), resolveTargetStrength(r4), r5);
        return;
    L10:
        if (resetFadeState() == false) goto L13;
        r5.invalidate();
        return;
    }

    public final boolean shouldApply(int r3, int r4) {
        if (this.enabled == true) goto L5;
    L13:
        return false;
    L5:
        if (this.fadeLength <= 0.0f) goto L13;
        if (r3 <= 0) goto L13;
        if (r4 <= 0) goto L13;
        if (shouldDrawLeftFade() == false) goto L11;
    L12:
        return true;
    L11:
        if (shouldDrawRightFade() == false) goto L13;
        goto L12
    }

    public final boolean shouldDrawLeftFade() {
        if (this.leftFadeStrength <= 0.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean shouldDrawRightFade() {
        if (this.rightFadeStrength <= 0.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public final void drawOverlay(Canvas r12, float r13, float r14, float r15, float r16, boolean r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        float r8 = Math.min(this.fadeLength, ((int) (r15 - r13)) / 2.0f);
        if (r8 > 0.0f) goto L5;
        return;
    L5:
        this.edgeFadePaint.setXfermode(this.dstInXfermode);
        if (r17 == false) goto L10;
        float r1 = this.leftFadeStrength * r8;
        if (r1 <= 0.0f) goto L10;
        LinearGradient r3 = ensureLeftEdgeFadeShader(r8);
        this.leftEdgeFadeMatrix.reset();
        this.leftEdgeFadeMatrix.setScale(r1 / r8, 1.0f);
        this.leftEdgeFadeMatrix.postTranslate(r13, 0.0f);
        r3.setLocalMatrix(this.leftEdgeFadeMatrix);
        this.edgeFadePaint.setShader(r3);
        r12.drawRect(r13, r14, r13 + r1, r16, this.edgeFadePaint);
    L10:
        if (r18 == false) goto L14;
        float r2 = this.rightFadeStrength * r8;
        if (r2 <= 0.0f) goto L14;
        LinearGradient r4 = ensureRightEdgeFadeShader(r8);
        this.rightEdgeFadeMatrix.reset();
        this.rightEdgeFadeMatrix.setScale(r2 / r8, 1.0f);
        float r5 = r15 - r2;
        this.rightEdgeFadeMatrix.postTranslate(r5, 0.0f);
        r4.setLocalMatrix(this.rightEdgeFadeMatrix);
        this.edgeFadePaint.setShader(r4);
        r12.drawRect(r5, r14, r15, r16, this.edgeFadePaint);
    L14:
        this.edgeFadePaint.setShader(null);
        this.edgeFadePaint.setXfermode(null);
    }

    private final void animateFadeStrength(final float r11, final float r12, final View r13) {
        boolean r1 = true;
        if (this.lastTargetLeftStrength != r11) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L13:
        final float r5 = this.leftFadeStrength;
        final float r7 = this.rightFadeStrength;
        this.lastTargetLeftStrength = r11;
        this.lastTargetRightStrength = r12;
        if (r5 != r11) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == true) goto L19;
    L24:
        ValueAnimator r3 = this.animator;
        if (r3 == null) goto L28;
        r3.cancel();
    L28:
        ValueAnimator r4 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r4.setDuration(Math.max(1, (long) (120 * Math.max(Math.abs(r11 - r5), Math.abs(r12 - r7)))));
        r4.addUpdateListener(new OTabLayoutEdgeFadeHelper$$ExternalSyntheticLambda0(this, r5, r11, r7, r12, r13));
        r4.addListener(new OTabLayoutEdgeFadeHelper$animateFadeStrength$1$2(this));
        this.animator = r4;
        if (r4 == null) goto L33;
        r4.start();
        return;
    L33:
        return;
    L19:
        if (r7 == r12) goto L22;
        r1 = false;
    L22:
        if (r1 == false) goto L24;
        return;
    L16:
        r2 = false;
        goto L17
    L8:
        if (this.lastTargetRightStrength != r12) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == false) goto L13;
        return;
    L10:
        r6 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    /* JADX INFO: renamed from: animateFadeStrength$lambda-1$lambda-0, reason: not valid java name */
    private static final void m1409animateFadeStrength$lambda1$lambda0(OTabLayoutEdgeFadeHelper r1, float r2, float r3, float r4, float r5, View r6, ValueAnimator r7) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r6, "$invalidateView");
        Intrinsics.checkNotNullParameter(r7, "it");
        Object r8 = r7.getAnimatedValue();
        if (r8 == null) goto L7;
        float r9 = ((Float) r8).floatValue();
        r1.leftFadeStrength = r1.lerp(r2, r3, r9);
        r1.rightFadeStrength = r1.lerp(r4, r5, r9);
        r6.invalidate();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    private final void clearAnimatorReference(Animator r2) {
        if (this.animator != r2) goto L6;
        this.animator = null;
        return;
    }

    public final boolean setEnabled(boolean r2) {
        if (this.enabled != r2) goto L6;
        return false;
    L6:
        this.enabled = r2;
        return true;
    }

    public final boolean isEnabled() {
        return this.enabled;
    }

    public final boolean setFadeLength(float r4) {
        float r5 = RangesKt.coerceAtLeast(r4, 0.0f);
        if (this.fadeLength != r5) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return false;
    L8:
        this.fadeLength = r5;
        invalidateShaders();
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public final float getFadeLength() {
        return this.fadeLength;
    }

    private final LinearGradient ensureLeftEdgeFadeShader(float r14) {
        int r0 = resolveEdgeAlpha(this.leftFadeStrength);
        LinearGradient r1 = this.leftEdgeFadeShader;
        if (r1 != null) goto L5;
    L12:
        LinearGradient r2 = new LinearGradient(0.0f, 0.0f, r14, 0.0f, new int[]{Color.argb(r0, 0, 0, 0), Color.argb(255, 0, 0, 0)}, EDGE_FADE_POSITIONS, Shader.TileMode.CLAMP);
        this.leftEdgeFadeShader = r2;
        this.edgeFadeShaderLength = r14;
        this.leftEdgeFadeShaderAlpha = r0;
        return r2;
    L5:
        if (this.edgeFadeShaderLength != r14) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L12;
        if (this.leftEdgeFadeShaderAlpha != r0) goto L12;
        return r1;
    L7:
        r4 = false;
        goto L8
    }

    private final LinearGradient ensureRightEdgeFadeShader(float r14) {
        int r0 = resolveEdgeAlpha(this.rightFadeStrength);
        LinearGradient r1 = this.rightEdgeFadeShader;
        if (r1 != null) goto L5;
    L12:
        LinearGradient r2 = new LinearGradient(0.0f, 0.0f, r14, 0.0f, new int[]{Color.argb(255, 0, 0, 0), Color.argb(r0, 0, 0, 0)}, EDGE_FADE_POSITIONS, Shader.TileMode.CLAMP);
        this.rightEdgeFadeShader = r2;
        this.edgeFadeShaderLength = r14;
        this.rightEdgeFadeShaderAlpha = r0;
        return r2;
    L5:
        if (this.edgeFadeShaderLength != r14) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L12;
        if (this.rightEdgeFadeShaderAlpha != r0) goto L12;
        return r1;
    L7:
        r4 = false;
        goto L8
    }

    private final int resolveEdgeAlpha(float r3) {
        return MathKt.roundToInt(255 * (1.0f - RangesKt.coerceIn(r3, 0.0f, 1.0f)));
    }

    private final float lerp(float r2, float r3, float r4) {
        return r2 + ((r3 - r2) * RangesKt.coerceIn(r4, 0.0f, 1.0f));
    }

    private final boolean resetFadeState() {
        if (shouldDrawLeftFade() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        ValueAnimator r1 = this.animator;
        if (r1 == null) goto L13;
        r1.cancel();
    L13:
        this.animator = null;
        this.leftFadeStrength = 0.0f;
        this.rightFadeStrength = 0.0f;
        this.lastTargetLeftStrength = 0.0f;
        this.lastTargetRightStrength = 0.0f;
        invalidateShaders();
        return r0;
    L5:
        if (shouldDrawRightFade() == true) goto L8;
        r0 = false;
        goto L9
    }

    private final void invalidateShaders() {
        this.edgeFadeShaderLength = -1.0f;
        this.leftEdgeFadeShader = null;
        this.rightEdgeFadeShader = null;
        this.leftEdgeFadeShaderAlpha = -1;
        this.rightEdgeFadeShaderAlpha = -1;
    }
}
