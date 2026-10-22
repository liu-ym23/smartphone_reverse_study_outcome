package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapCompat {

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static boolean hasMipMap(Bitmap r0) {
            return r0.hasMipMap();
        }

        @DoNotInline
        static void setHasMipMap(Bitmap r0, boolean r1) {
            r0.setHasMipMap(r1);
        }
    }

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static int getAllocationByteCount(Bitmap r0) {
            return r0.getAllocationByteCount();
        }
    }

    @RequiresApi(27)
    static class Api27Impl {
        private Api27Impl() {
        }

        @DoNotInline
        static Bitmap copyBitmapIfHardware(Bitmap r3) {
            if (r3.getConfig() != Bitmap.Config.HARDWARE) goto L9;
            Bitmap.Config r0 = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT < 31) goto L8;
            r0 = Api31Impl.getHardwareBitmapConfig(r3);
        L8:
            return r3.copy(r0, true);
        L9:
            return r3;
        }

        @DoNotInline
        static Bitmap createBitmapWithSourceColorspace(int r3, int r4, Bitmap r5, boolean r6) {
            Bitmap.Config r0 = r5.getConfig();
            ColorSpace r1 = r5.getColorSpace();
            ColorSpace r2 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (r6 == false) goto L8;
            if (r5.getColorSpace().equals(r2) == true) goto L8;
            r0 = Bitmap.Config.RGBA_F16;
            r1 = r2;
        L13:
            return Bitmap.createBitmap(r3, r4, r0, r5.hasAlpha(), r1);
        L8:
            if (r5.getConfig() != Bitmap.Config.HARDWARE) goto L13;
            r0 = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT < 31) goto L13;
            r0 = Api31Impl.getHardwareBitmapConfig(r5);
            goto L13
        }

        @DoNotInline
        static boolean isAlreadyF16AndLinear(Bitmap r3) {
            ColorSpace r0 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (r3.getConfig() == Bitmap.Config.RGBA_F16) goto L5;
        L7:
            return false;
        L5:
            if (r3.getColorSpace().equals(r0) == false) goto L7;
            return true;
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void setPaintBlendMode(Paint r1) {
            r1.setBlendMode(BlendMode.SRC);
        }
    }

    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static Bitmap.Config getHardwareBitmapConfig(Bitmap r1) {
            if (r1.getHardwareBuffer().getFormat() != 22) goto L7;
            return Bitmap.Config.RGBA_F16;
        L7:
            return Bitmap.Config.ARGB_8888;
        }
    }

    private BitmapCompat() {
    }

    @NonNull
    public static Bitmap createScaledBitmap(@NonNull Bitmap r20, int r21, int r22, @Nullable Rect r23, boolean r24) {
        Bitmap r0 = r20;
        int r4 = Build.VERSION.SDK_INT;
        if (r21 <= 0) goto L139;
        if (r22 <= 0) goto L139;
        if (r23 == null) goto L20;
        if (r23.isEmpty() == true) goto L18;
        if (r23.left < 0) goto L18;
        if (r23.right > r20.getWidth()) goto L18;
        if (r23.top < 0) goto L18;
        if (r23.bottom <= r20.getHeight()) goto L20;
    L18:
        throw new IllegalArgumentException("srcRect must be contained by srcBm!");
    L20:
        if (r4 < 27) goto L22;
        Bitmap r6 = Api27Impl.copyBitmapIfHardware(r20);
    L23:
        if (r23 == null) goto L25;
        int r7 = r23.width();
    L26:
        if (r23 == null) goto L28;
        int r8 = r23.height();
    L29:
        float r9 = r21 / r7;
        float r10 = r22 / r8;
        if (r23 == null) goto L32;
        int r12 = r23.left;
    L33:
        if (r23 == null) goto L35;
        int r3 = r23.top;
    L37:
        if (r12 != 0) goto L49;
        if (r3 != 0) goto L49;
        if (r21 != r20.getWidth()) goto L49;
        if (r22 != r20.getHeight()) goto L49;
        if (r20.isMutable() == false) goto L48;
        if (r0 != r6) goto L48;
        return r0.copy(r20.getConfig(), true);
    L48:
        return r6;
    L49:
        Paint r14 = new Paint(1);
        r14.setFilterBitmap(true);
        if (r4 < 29) goto L52;
        Api29Impl.setPaintBlendMode(r14);
    L53:
        if (r7 != r21) goto L57;
        if (r8 != r22) goto L57;
        Bitmap r1 = Bitmap.createBitmap(r21, r22, r6.getConfig());
        new Canvas(r1).drawBitmap(r6, -r12, -r3, r14);
        return r1;
    L57:
        double r16 = Math.log(2.0d);
        double r13 = Math.log(r9) / r16;
        if (r9 <= 1.0f) goto L60;
        double r15 = Math.ceil(r13);
    L61:
        int r11 = (int) r15;
        if (r10 <= 1.0f) goto L64;
        double r17 = Math.ceil(Math.log(r10) / r16);
    L65:
        int r18 = (int) r17;
        Bitmap r19 = null;
        if (r24 == false) goto L78;
        if (r4 < 27) goto L78;
        if (Api27Impl.isAlreadyF16AndLinear(r20) == true) goto L78;
        if (r11 <= 0) goto L73;
        int r110 = sizeAtStep(r7, r21, 1, r11);
    L74:
        if (r18 <= 0) goto L76;
        int r111 = sizeAtStep(r8, r22, 1, r18);
    L77:
        Bitmap r112 = Api27Impl.createBitmapWithSourceColorspace(r110, r111, r0, true);
        Paint r113 = r14;
        new Canvas(r112).drawBitmap(r6, -r12, -r3, r113);
        int r114 = 1;
        r3 = 0;
        r12 = 0;
        r19 = r6;
        r6 = r112;
    L79:
        Rect r115 = new Rect(r12, r3, r7, r8);
        Rect r5 = new Rect();
        int r116 = r11;
        int r117 = r18;
    L80:
        if (r116 != 0) goto L87;
        if (r117 != 0) goto L87;
        if (r19 == r0) goto L86;
        if (r19 == null) goto L86;
        r19.recycle();
    L86:
        return r6;
    L87:
        if (r116 >= 0) goto L89;
        r116 = r116 + 1;
    L91:
        if (r117 >= 0) goto L93;
        r117 = r117 + 1;
    L95:
        Rect r25 = r115;
        int r26 = r117;
        Paint r118 = r113;
        Bitmap r119 = r6;
        r5.set(0, 0, sizeAtStep(r7, r21, r116, r11), sizeAtStep(r8, r22, r26, r18));
        if (r116 != 0) goto L99;
        if (r26 != 0) goto L99;
        boolean r120 = true;
    L100:
        if (r19 != null) goto L102;
    L106:
        boolean r121 = false;
    L107:
        if (r19 == null) goto L119;
        if (r19 == r0) goto L119;
        if (r24 == true) goto L111;
    L114:
        if (r120 == false) goto L118;
        if (r121 == false) goto L119;
        if (r114 != 0) goto L119;
    L118:
        r6 = r19;
    L137:
        new Canvas(r6).drawBitmap(r119, r25, r5, r118);
        r25.set(r5);
        r19 = r119;
        r117 = r26;
        r0 = r20;
        r113 = r118;
        r115 = r25;
        goto L80
    L111:
        if (r4 < 27) goto L114;
        if (Api27Impl.isAlreadyF16AndLinear(r19) == true) goto L114;
    L119:
        if (r19 == r0) goto L122;
        if (r19 == null) goto L122;
        r19.recycle();
    L122:
        if (r116 <= 0) goto L124;
        int r27 = r114;
    L125:
        int r28 = sizeAtStep(r7, r21, r27, r11);
        if (r26 <= 0) goto L128;
        int r122 = r114;
    L129:
        int r123 = sizeAtStep(r8, r22, r122, r18);
        if (r4 < 27) goto L136;
        if (r24 == false) goto L134;
        if (r120 == true) goto L134;
        boolean r124 = true;
    L135:
        r6 = Api27Impl.createBitmapWithSourceColorspace(r28, r123, r0, r124);
    L134:
        r124 = false;
        goto L135
    L136:
        r6 = Bitmap.createBitmap(r28, r123, r119.getConfig());
        goto L137
    L128:
        r122 = r26;
        goto L129
    L124:
        r27 = r116;
        goto L125
    L102:
        if (r19.getWidth() != r21) goto L106;
        if (r19.getHeight() != r22) goto L106;
        r121 = true;
    L99:
        r120 = false;
        goto L100
    L93:
        if (r117 <= 0) goto L95;
        r117 = r117 - 1;
        goto L95
    L89:
        if (r116 <= 0) goto L91;
        r116 = r116 - 1;
        goto L91
    L76:
        r111 = r8;
        goto L77
    L73:
        r110 = r7;
    L78:
        r113 = r14;
        r114 = 0;
        goto L79
    L64:
        r17 = Math.floor(Math.log(r10) / r16);
        goto L65
    L60:
        r15 = Math.floor(r13);
        goto L61
    L52:
        r14.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        goto L53
    L35:
        r3 = 0;
        goto L37
    L32:
        r12 = 0;
        goto L33
    L28:
        r8 = r20.getHeight();
        goto L29
    L25:
        r7 = r20.getWidth();
        goto L26
    L22:
        r6 = r0;
    L139:
        throw new IllegalArgumentException("dstW and dstH must be > 0!");
    }

    public static int getAllocationByteCount(@NonNull Bitmap r2) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.getAllocationByteCount(r2);
    L7:
        return r2.getByteCount();
    }

    public static boolean hasMipMap(@NonNull Bitmap r2) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return false;
    L5:
        return Api17Impl.hasMipMap(r2);
    }

    public static void setHasMipMap(@NonNull Bitmap r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        Api17Impl.setHasMipMap(r2, r3);
        return;
    }

    @VisibleForTesting
    public static int sizeAtStep(int r1, int r2, int r3, int r4) {
        if (r3 != 0) goto L5;
        return r2;
    L5:
        if (r3 <= 0) goto L9;
        return r1 * (1 << (r4 - r3));
    L9:
        return r2 << ((-r3) - 1);
    }
}
