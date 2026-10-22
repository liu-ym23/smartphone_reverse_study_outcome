package com.obric.oui.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OImage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 %2\u00020\u0001:\u0001%B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001a\u001a\u00020\u0011J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0011J\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u000fJ\u000e\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u000fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/oui/image/OImage;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clipPath", "Landroid/graphics/Path;", "clipRect", "Landroid/graphics/RectF;", "contentRect", "effectiveRadiusPx", "", "imageShape", "Lcom/obric/oui/image/OImageShape;", "roundedRadiusPx", "strokePaint", "Landroid/graphics/Paint;", "strokeRect", "strokeWidthPx", "styleConfig", "Lcom/obric/oui/image/OImageStyleConfig;", "styleRadiusPx", "getImageShape", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setImageShape", "shape", "setRadiusDp", "radiusDp", "setRadiusPx", "radiusPx", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OImage extends AppCompatImageView {
    public static final Companion Companion = null;
    public static final float OUI_IMAGE_RAIDUS_L2_DP = 12.0f;
    public static final float OUI_IMAGE_RAIDUS_M1_DP = 8.0f;
    public static final float OUI_IMAGE_RAIDUS_M2_DP = 10.0f;
    public static final float OUI_IMAGE_RAIDUS_S_DP = 6.0f;
    public static final float OUI_IMAGE_RAIDUS_XL_DP = 16.0f;
    private static final String TAG = "OImage";
    private final Path clipPath;
    private final RectF clipRect;
    private final RectF contentRect;
    private float effectiveRadiusPx;
    private OImageShape imageShape;
    private final float roundedRadiusPx;
    private final Paint strokePaint;
    private final RectF strokeRect;
    private final float strokeWidthPx;
    private final OImageStyleConfig styleConfig;
    private float styleRadiusPx;

    /* JADX INFO: compiled from: OImage.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/image/OImage$Companion;", "", "()V", "OUI_IMAGE_RAIDUS_L2_DP", "", "OUI_IMAGE_RAIDUS_M1_DP", "OUI_IMAGE_RAIDUS_M2_DP", "OUI_IMAGE_RAIDUS_S_DP", "OUI_IMAGE_RAIDUS_XL_DP", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public OImage(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OImage(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OImage(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OImage(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11);
        this.clipPath = new Path();
        this.clipRect = new RectF();
        this.contentRect = new RectF();
        this.strokeRect = new RectF();
        this.styleConfig = OImageStyleConfig.Companion.fromAttributes$default(OImageStyleConfig.Companion, r9, r10, r11, 0, 8, null);
        this.roundedRadiusPx = r9.getResources().getDimension(R.dimen.oui_image_rounded_radius);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        OImage r3 = this;     // Catch: Throwable -> L9
        TypedArray r12 = r9.obtainStyledAttributes(r10, new int[]{android.R.attr.radius}, r11, 0);     // Catch: Throwable -> L9
        float r13 = r12.getDimension(0, 0.0f);     // Catch: Throwable -> L6
        r12.recycle();     // Catch: Throwable -> L9
        Object r14 = Result.m774constructorimpl(Float.valueOf(r13));     // Catch: Throwable -> L9
    L11:
        Throwable r15 = Result.m777exceptionOrNullimpl(r14);
        if (r15 == null) goto L15;
        Log.w(TAG, "Failed to parse android:radius; fallback to 0", r15);
        r14 = Float.valueOf(0.0f);
    L15:
        this.styleRadiusPx = ((Number) r14).floatValue();
        OImageShape r16 = this.styleConfig.getShape();
        this.imageShape = r16;
        this.effectiveRadiusPx = OImageStyleHelperKt.resolveEffectiveRadius(r16, this.styleRadiusPx, this.roundedRadiusPx);
        float r17 = r9.getResources().getDimension(R.dimen.oui_image_stroke_width);
        this.strokeWidthPx = r17;
        Paint r18 = new Paint(1);
        r18.setStyle(Paint.Style.STROKE);
        r18.setColor(ContextCompat.getColor(r9, R.color.oui_line_1));
        r18.setStrokeWidth(r17);
        this.strokePaint = r18;
        return;
    L6:
        th = move-exception;
        r12.recycle();     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r14 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final void setImageShape(OImageShape r4) {
        Intrinsics.checkNotNullParameter(r4, "shape");
        if (r4 != this.imageShape) goto L6;
        Log.d(TAG, Intrinsics.stringPlus("Skip setImageShape because shape is unchanged: ", r4));
        return;
    L6:
        this.imageShape = r4;
        this.effectiveRadiusPx = OImageStyleHelperKt.resolveEffectiveRadius(r4, this.styleRadiusPx, this.roundedRadiusPx);
        Log.i(TAG, "Image shape changed to " + r4 + ", effectiveRadiusPx=" + this.effectiveRadiusPx);
        invalidate();
    }

    public final void setRadiusDp(float r2) {
        setRadiusPx(r2 * getContext().getResources().getDisplayMetrics().density);
    }

    public final void setRadiusPx(float r3) {
        if (this.styleRadiusPx != r3) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.styleRadiusPx = r3;
        this.effectiveRadiusPx = OImageStyleHelperKt.resolveEffectiveRadius(this.imageShape, r3, this.roundedRadiusPx);
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final OImageShape getImageShape() {
        return this.imageShape;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        float r0 = getWidth();
        float r1 = getHeight();
        if (r0 > 0.0f) goto L5;
    L31:
        Log.w(TAG, "Skip draw due to invalid size width=" + r0 + " height=" + r1);
        return;
    L5:
        if (r1 <= 0.0f) goto L31;
        this.clipRect.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        if (this.clipRect.isEmpty() == false) goto L11;
        Log.w(TAG, Intrinsics.stringPlus("Skip draw due to empty clip bounds rect=", this.clipRect));
        return;
    L11:
        boolean r2 = this.styleConfig.getStrokeEnabled();
        if (r2 == false) goto L14;
        float r3 = RangesKt.coerceAtLeast(this.effectiveRadiusPx - this.strokeWidthPx, 0.0f);
    L15:
        if (r2 == false) goto L21;
        this.contentRect.set(this.clipRect);
        RectF r4 = this.contentRect;
        float r5 = this.strokeWidthPx;
        r4.inset(r5, r5);
        if (this.contentRect.isEmpty() == false) goto L20;
        Log.w(TAG, Intrinsics.stringPlus("Stroke ON but skip content draw due to empty content bounds rect=", this.contentRect));
        return;
    L20:
        RectF r6 = this.contentRect;
    L22:
        this.clipPath.reset();
        this.clipPath.addRoundRect(r6, r3, r3, Path.Direction.CW);
        int r7 = r9.save();
        r9.clipPath(this.clipPath);
        super.onDraw(r9);
        r9.restoreToCount(r7);
        if (r2 == true) goto L25;
        return;
    L25:
        this.strokeRect.set(this.clipRect);
        float r8 = this.strokeWidthPx / 2.0f;
        this.strokeRect.inset(r8, r8);
        if (this.strokeRect.isEmpty() == false) goto L29;
        Log.w(TAG, Intrinsics.stringPlus("Stroke ON but skip due to empty stroke bounds rect=", this.strokeRect));
        return;
    L29:
        float r10 = RangesKt.coerceAtLeast(this.effectiveRadiusPx - r8, 0.0f);
        r9.drawRoundRect(this.strokeRect, r10, r10, this.strokePaint);
        return;
    L21:
        r6 = this.clipRect;
        goto L22
    L14:
        r3 = this.effectiveRadiusPx;
        goto L15
    }
}
