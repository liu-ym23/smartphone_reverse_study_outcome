package com.obric.oui.tab;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: OTabLayoutHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J>\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nJ\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0006\u0010\u001d\u001a\u00020\bJ\b\u0010\u001e\u001a\u00020\u0013H\u0002J\u0006\u0010\u001f\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\bJ&\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/oui/tab/OTabLayoutEdgeFadeHelper;", "", "()V", "dstInXfermode", "Landroid/graphics/PorterDuffXfermode;", "edgeFadePaint", "Landroid/graphics/Paint;", "edgeFadeShaderLength", "", "enabled", "", "fadeLength", "leftEdgeFadeMatrix", "Landroid/graphics/Matrix;", "leftEdgeFadeShader", "Landroid/graphics/LinearGradient;", "rightEdgeFadeMatrix", "rightEdgeFadeShader", "drawOverlay", "", "canvas", "Landroid/graphics/Canvas;", "left", "top", "right", "bottom", "showLeftFade", "showRightFade", "ensureEdgeFadeShaders", "getFadeLength", "invalidateShaders", "isEnabled", "setEnabled", "setFadeLength", "lengthPx", "shouldApply", MaterialConfigFormatNames.WIDTH, "", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTabLayoutEdgeFadeHelper {
    public static final Companion Companion = null;
    public static final float DEFAULT_EDGE_FADE_LENGTH_DP = 16.0f;
    private static final float[] EDGE_FADE_POSITIONS = null;
    private final PorterDuffXfermode dstInXfermode;
    private final Paint edgeFadePaint;
    private float edgeFadeShaderLength;
    private boolean enabled;
    private float fadeLength;
    private final Matrix leftEdgeFadeMatrix;
    private LinearGradient leftEdgeFadeShader;
    private final Matrix rightEdgeFadeMatrix;
    private LinearGradient rightEdgeFadeShader;

    /* JADX INFO: compiled from: OTabLayoutHelper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/tab/OTabLayoutEdgeFadeHelper$Companion;", "", "()V", "DEFAULT_EDGE_FADE_LENGTH_DP", "", "EDGE_FADE_POSITIONS", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public OTabLayoutEdgeFadeHelper() {
        this.edgeFadePaint = new Paint(1);
        this.dstInXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.leftEdgeFadeMatrix = new Matrix();
        this.rightEdgeFadeMatrix = new Matrix();
        this.edgeFadeShaderLength = -1.0f;
    }

    static {
        Companion = new Companion(null);
        EDGE_FADE_POSITIONS = new float[]{0.0f, 1.0f};
    }

    public final boolean shouldApply(int r2, int r3, boolean r4, boolean r5) {
        if (this.enabled == true) goto L5;
    L11:
        return false;
    L5:
        if (this.fadeLength <= 0.0f) goto L11;
        if (r2 <= 0) goto L11;
        if (r3 <= 0) goto L11;
        if (r4 == true) goto L10;
        if (r5 == false) goto L11;
    L10:
        return true;
    }

    public final void drawOverlay(Canvas r11, float r12, float r13, float r14, float r15, boolean r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        float r8 = Math.min(this.fadeLength, ((int) (r14 - r12)) / 2.0f);
        if (r8 > 0.0f) goto L5;
        return;
    L5:
        ensureEdgeFadeShaders(r8);
        this.edgeFadePaint.setXfermode(this.dstInXfermode);
        if (r16 == false) goto L11;
        LinearGradient r1 = this.leftEdgeFadeShader;
        if (r1 == null) goto L10;
        this.leftEdgeFadeMatrix.reset();
        this.leftEdgeFadeMatrix.setTranslate(r12, 0.0f);
        r1.setLocalMatrix(this.leftEdgeFadeMatrix);
        this.edgeFadePaint.setShader(r1);
    L10:
        r11.drawRect(r12, r13, r12 + r8, r15, this.edgeFadePaint);
    L11:
        if (r17 == false) goto L16;
        LinearGradient r2 = this.rightEdgeFadeShader;
        if (r2 == null) goto L15;
        this.rightEdgeFadeMatrix.reset();
        this.rightEdgeFadeMatrix.setTranslate(r14 - r8, 0.0f);
        r2.setLocalMatrix(this.rightEdgeFadeMatrix);
        this.edgeFadePaint.setShader(r2);
    L15:
        r11.drawRect(r14 - r8, r13, r14, r15, this.edgeFadePaint);
    L16:
        this.edgeFadePaint.setShader(null);
        this.edgeFadePaint.setXfermode(null);
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

    private final void ensureEdgeFadeShaders(float r17) {
        if (this.edgeFadeShaderLength != r17) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return;
    L8:
        this.edgeFadeShaderLength = r17;
        int[] r6 = {Color.argb(0, 0, 0, 0), Color.argb(255, 0, 0, 0)};
        float[] r15 = EDGE_FADE_POSITIONS;
        this.leftEdgeFadeShader = new LinearGradient(0.0f, 0.0f, r17, 0.0f, r6, r15, Shader.TileMode.CLAMP);
        this.rightEdgeFadeShader = new LinearGradient(0.0f, 0.0f, r17, 0.0f, new int[]{Color.argb(255, 0, 0, 0), Color.argb(0, 0, 0, 0)}, r15, Shader.TileMode.CLAMP);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private final void invalidateShaders() {
        this.edgeFadeShaderLength = -1.0f;
        this.leftEdgeFadeShader = null;
        this.rightEdgeFadeShader = null;
    }
}
