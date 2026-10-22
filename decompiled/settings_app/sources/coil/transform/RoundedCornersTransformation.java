package coil.transform;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import android.icu.text.PluralRules;
import coil.decode.DecodeUtils;
import coil.size.Dimension;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import coil.util.Bitmaps;
import com.bytedance.apm.constant.PerfConsts;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: RoundedCornersTransformation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B-\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ$\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0016J!\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcoil/transform/RoundedCornersTransformation;", "Lcoil/transform/Transformation;", "radius", "", "(F)V", "topLeft", "topRight", "bottomLeft", "bottomRight", "(FFFF)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/String;", "calculateOutputSize", "Lkotlin/Pair;", "", "input", "Landroid/graphics/Bitmap;", PerfConsts.PERF_DISK_FILE_SIZE, "Lcoil/size/Size;", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "transform", "(Landroid/graphics/Bitmap;Lcoil/size/Size;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RoundedCornersTransformation implements Transformation {
    private final float bottomLeft;
    private final float bottomRight;
    private final String cacheKey;
    private final float topLeft;
    private final float topRight;

    public RoundedCornersTransformation() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
    }

    public RoundedCornersTransformation(float r3, float r4, float r5, float r6) {
        this.topLeft = r3;
        this.topRight = r4;
        this.bottomLeft = r5;
        this.bottomRight = r6;
        if (r3 >= 0.0f) goto L5;
    L11:
        boolean r0 = false;
    L12:
        if (r0 == false) goto L16;
        this.cacheKey = getClass().getName() + '-' + r3 + ',' + r4 + ',' + r5 + ',' + r6;
        return;
    L16:
        throw new IllegalArgumentException("All radii must be >= 0.".toString());
    L5:
        if (r4 < 0.0f) goto L11;
        if (r5 < 0.0f) goto L11;
        if (r6 < 0.0f) goto L11;
        r0 = true;
        goto L12
    }

    public /* synthetic */ RoundedCornersTransformation(float r2, float r3, float r4, float r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0.0f;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 0.0f;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 0.0f;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 0.0f;
    L14:
        this(r2, r3, r4, r5);
    }

    public RoundedCornersTransformation(float r1) {
        this(r1, r1, r1, r1);
    }

    @Override // coil.transform.Transformation
    public String getCacheKey() {
        return this.cacheKey;
    }

    @Override // coil.transform.Transformation
    public Object transform(Bitmap r11, Size r12, Continuation<? super Bitmap> r13) {
        Paint r14 = new Paint(3);
        Pair<Integer, Integer> r15 = calculateOutputSize(r11, r12);
        int r1 = r15.component1().intValue();
        int r16 = r15.component2().intValue();
        Bitmap r2 = Bitmap.createBitmap(r1, r16, Bitmaps.getSafeConfig(r11));
        Intrinsics.checkNotNullExpressionValue(r2, "createBitmap(width, height, config)");
        Canvas r3 = new Canvas(r2);
        r3.drawColor(0, PorterDuff.Mode.CLEAR);
        Matrix r4 = new Matrix();
        float r6 = (float) DecodeUtils.computeSizeMultiplier(r11.getWidth(), r11.getHeight(), r1, r16, Scale.FILL);
        float r8 = 2;
        r4.setTranslate((r1 - (r11.getWidth() * r6)) / r8, (r16 - (r11.getHeight() * r6)) / r8);
        r4.preScale(r6, r6);
        BitmapShader r17 = new BitmapShader(r11, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        r17.setLocalMatrix(r4);
        r14.setShader(r17);
        float r18 = this.topLeft;
        float r19 = this.topRight;
        float r110 = this.bottomRight;
        float r10 = this.bottomLeft;
        float[] r111 = {r18, r18, r19, r19, r110, r110, r10, r10};
        RectF r112 = new RectF(0.0f, 0.0f, r3.getWidth(), r3.getHeight());
        Path r113 = new Path();
        r113.addRoundRect(r112, r111, Path.Direction.CW);
        r3.drawPath(r113, r14);
        return r2;
    }

    private final Pair<Integer, Integer> calculateOutputSize(Bitmap r5, Size r6) {
        if (Sizes.isOriginal(r6) == true) goto L5;
        Dimension r4 = r6.component1();
        Dimension r0 = r6.component2();
        if ((r4 instanceof Dimension.Pixels) == true) goto L9;
    L12:
        int r7 = r5.getWidth();
        int r1 = r5.getHeight();
        Dimension r2 = r6.getWidth();
        int r3 = Integer.MIN_VALUE;
        if ((r2 instanceof Dimension.Pixels) == false) goto L15;
        int r8 = ((Dimension.Pixels) r2).px;
    L16:
        Dimension r9 = r6.getHeight();
        if ((r9 instanceof Dimension.Pixels) == false) goto L19;
        r3 = ((Dimension.Pixels) r9).px;
    L19:
        double r10 = DecodeUtils.computeSizeMultiplier(r7, r1, r8, r3, Scale.FILL);
        return TuplesKt.to(Integer.valueOf(MathKt.roundToInt(((double) r5.getWidth()) * r10)), Integer.valueOf(MathKt.roundToInt(r10 * ((double) r5.getHeight()))));
    L15:
        r8 = Integer.MIN_VALUE;
        goto L16
    L9:
        if ((r0 instanceof Dimension.Pixels) == false) goto L12;
        return TuplesKt.to(Integer.valueOf(((Dimension.Pixels) r4).px), Integer.valueOf(((Dimension.Pixels) r0).px));
    L5:
        return TuplesKt.to(Integer.valueOf(r5.getWidth()), Integer.valueOf(r5.getHeight()));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RoundedCornersTransformation) == false) goto L29;
        RoundedCornersTransformation r6 = (RoundedCornersTransformation) r5;
        if (this.topLeft != r6.topLeft) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L29;
        if (this.topRight != r6.topRight) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == false) goto L29;
        if (this.bottomLeft != r6.bottomLeft) goto L20;
        boolean r3 = true;
    L21:
        if (r3 == false) goto L29;
        if (this.bottomRight != r6.bottomRight) goto L25;
        boolean r4 = true;
    L26:
        if (r4 == false) goto L29;
        return true;
    L25:
        r4 = false;
        goto L26
    L20:
        r3 = false;
        goto L21
    L15:
        r2 = false;
        goto L16
    L10:
        r1 = false;
    L29:
        return false;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.topLeft) * 31) + Float.hashCode(this.topRight)) * 31) + Float.hashCode(this.bottomLeft)) * 31) + Float.hashCode(this.bottomRight);
    }
}
