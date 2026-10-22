package coil.transform;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.icu.text.PluralRules;
import coil.size.Size;
import coil.util.Bitmaps;
import com.bytedance.apm.constant.PerfConsts;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CircleCropTransformation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J!\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcoil/transform/CircleCropTransformation;", "Lcoil/transform/Transformation;", "()V", "cacheKey", "", "getCacheKey", "()Ljava/lang/String;", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "transform", "Landroid/graphics/Bitmap;", "input", PerfConsts.PERF_DISK_FILE_SIZE, "Lcoil/size/Size;", "(Landroid/graphics/Bitmap;Lcoil/size/Size;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CircleCropTransformation implements Transformation {
    private final String cacheKey;

    public CircleCropTransformation() {
        this.cacheKey = getClass().getName();
    }

    @Override // coil.transform.Transformation
    public String getCacheKey() {
        return this.cacheKey;
    }

    @Override // coil.transform.Transformation
    public Object transform(Bitmap r5, Size r6, Continuation<? super Bitmap> r7) {
        Paint r4 = new Paint(3);
        int r8 = Math.min(r5.getWidth(), r5.getHeight());
        float r9 = r8 / 2.0f;
        Bitmap r10 = Bitmap.createBitmap(r8, r8, Bitmaps.getSafeConfig(r5));
        Intrinsics.checkNotNullExpressionValue(r10, "createBitmap(width, height, config)");
        Canvas r1 = new Canvas(r10);
        r1.drawCircle(r9, r9, r9, r4);
        r4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r1.drawBitmap(r5, r9 - (r5.getWidth() / 2.0f), r9 - (r5.getHeight() / 2.0f), r4);
        return r10;
    }

    public boolean equals(Object r1) {
        return r1 instanceof CircleCropTransformation;
    }

    public int hashCode() {
        return getClass().hashCode();
    }
}
