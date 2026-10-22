package coil.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.decode.DecodeUtils;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import com.bytedance.apm.constant.PerfConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: DrawableUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002J(\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcoil/util/DrawableUtils;", "", "()V", "DEFAULT_SIZE", "", "convertToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "config", "Landroid/graphics/Bitmap$Config;", PerfConsts.PERF_DISK_FILE_SIZE, "Lcoil/size/Size;", "scale", "Lcoil/size/Scale;", "allowInexactSize", "", "isConfigValid", "bitmap", "isSizeValid", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DrawableUtils {
    private static final int DEFAULT_SIZE = 512;
    public static final DrawableUtils INSTANCE = null;

    static {
        INSTANCE = new DrawableUtils();
    }

    private DrawableUtils() {
    }

    public final Bitmap convertToBitmap(Drawable r4, Bitmap.Config r5, Size r6, Scale r7, boolean r8) {
        if ((r4 instanceof BitmapDrawable) == false) goto L9;
        Bitmap r0 = ((BitmapDrawable) r4).getBitmap();
        if (isConfigValid(r0, r5) == false) goto L9;
        if (isSizeValid(r8, r0, r6, r7) == false) goto L9;
        return r0;
    L9:
        Drawable r3 = r4.mutate();
        int r9 = Utils.getWidth(r3);
        int r10 = 512;
        if (r9 > 0) goto L13;
        r9 = 512;
    L13:
        int r1 = Utils.getHeight(r3);
        if (r1 <= 0) goto L17;
        r10 = r1;
    L17:
        if (Sizes.isOriginal(r6) == false) goto L19;
        int r2 = r9;
    L21:
        if (Sizes.isOriginal(r6) == false) goto L23;
        int r11 = r10;
    L24:
        double r12 = DecodeUtils.computeSizeMultiplier(r9, r10, r2, r11, r7);
        int r13 = MathKt.roundToInt(((double) r9) * r12);
        int r14 = MathKt.roundToInt(r12 * ((double) r10));
        Bitmap r15 = Bitmap.createBitmap(r13, r14, Bitmaps.toSoftware(r5));
        Intrinsics.checkNotNullExpressionValue(r15, "createBitmap(width, height, config)");
        Rect r16 = r3.getBounds();
        int r17 = r16.left;
        int r18 = r16.top;
        int r19 = r16.right;
        int r20 = r16.bottom;
        r3.setBounds(0, 0, r13, r14);
        r3.draw(new Canvas(r15));
        r3.setBounds(r17, r18, r19, r20);
        return r15;
    L23:
        r11 = Utils.toPx(r6.getHeight(), r7);
        goto L24
    L19:
        r2 = Utils.toPx(r6.getWidth(), r7);
        goto L21
    }

    private final boolean isConfigValid(Bitmap r1, Bitmap.Config r2) {
        if (r1.getConfig() != Bitmaps.toSoftware(r2)) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean isSizeValid(boolean r4, Bitmap r5, Size r6, Scale r7) {
        if (r4 == false) goto L5;
        return true;
    L5:
        int r8 = r5.getWidth();
        int r0 = r5.getHeight();
        if (Sizes.isOriginal(r6) == false) goto L8;
        int r1 = r5.getWidth();
    L10:
        if (Sizes.isOriginal(r6) == false) goto L12;
        int r9 = r5.getHeight();
    L14:
        if (DecodeUtils.computeSizeMultiplier(r8, r0, r1, r9, r7) == 1.0d) goto L18;
        return false;
    L18:
        return true;
    L12:
        r9 = Utils.toPx(r6.getHeight(), r7);
        goto L14
    L8:
        r1 = Utils.toPx(r6.getWidth(), r7);
        goto L10
    }
}
