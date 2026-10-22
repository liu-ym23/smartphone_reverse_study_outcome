package coil.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.exifinterface.media.ExifInterface;
import coil.util.Bitmaps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;

/* JADX INFO: compiled from: ExifUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcoil/decode/ExifUtils;", "", "()V", "PAINT", "Landroid/graphics/Paint;", "getExifData", "Lcoil/decode/ExifData;", "mimeType", "", "source", "Lokio/BufferedSource;", "policy", "Lcoil/decode/ExifOrientationPolicy;", "reverseTransformations", "Landroid/graphics/Bitmap;", "inBitmap", "exifData", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExifUtils {
    public static final ExifUtils INSTANCE = null;
    private static final Paint PAINT = null;

    private ExifUtils() {
    }

    static {
        INSTANCE = new ExifUtils();
        PAINT = new Paint(3);
    }

    public final ExifData getExifData(String r1, BufferedSource r2, ExifOrientationPolicy r3) {
        if (ExifUtilsKt.supports(r3, r1) == false) goto L7;
        ExifInterface r0 = new ExifInterface(new ExifInterfaceInputStream(r2.peek().inputStream()));
        return new ExifData(r0.isFlipped(), r0.getRotationDegrees());
    L7:
        return ExifData.NONE;
    }

    public final Bitmap reverseTransformations(Bitmap r6, ExifData r7) {
        if (r7.isFlipped() == false) goto L5;
    L7:
        Matrix r5 = new Matrix();
        float r0 = r6.getWidth() / 2.0f;
        float r2 = r6.getHeight() / 2.0f;
        if (r7.isFlipped() == false) goto L11;
        r5.postScale(-1.0f, 1.0f, r0, r2);
    L11:
        if (ExifUtilsKt.isRotated(r7) == false) goto L13;
        r5.postRotate(r7.getRotationDegrees(), r0, r2);
    L13:
        RectF r1 = new RectF(0.0f, 0.0f, r6.getWidth(), r6.getHeight());
        r5.mapRect(r1);
        boolean r3 = true;
        if (r1.left != 0.0f) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == true) goto L19;
    L23:
        r5.postTranslate(-r1.left, -r1.top);
    L25:
        if (ExifUtilsKt.isSwapped(r7) == false) goto L27;
        Bitmap r8 = Bitmap.createBitmap(r6.getHeight(), r6.getWidth(), Bitmaps.getSafeConfig(r6));
        Intrinsics.checkNotNullExpressionValue(r8, "createBitmap(width, height, config)");
    L28:
        new Canvas(r8).drawBitmap(r6, r5, PAINT);
        r6.recycle();
        return r8;
    L27:
        r8 = Bitmap.createBitmap(r6.getWidth(), r6.getHeight(), Bitmaps.getSafeConfig(r6));
        Intrinsics.checkNotNullExpressionValue(r8, "createBitmap(width, height, config)");
        goto L28
    L19:
        if (r1.top == 0.0f) goto L22;
        r3 = false;
    L22:
        if (r3 == true) goto L25;
    L16:
        r4 = false;
        goto L17
    L5:
        if (ExifUtilsKt.isRotated(r7) == true) goto L7;
        return r6;
    }
}
