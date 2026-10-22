package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapCompat {

    static class Api17Impl {
        private Api17Impl() {
        }

        static boolean hasMipMap(Bitmap r0) {
            return r0.hasMipMap();
        }

        static void setHasMipMap(Bitmap r0, boolean r1) {
            r0.setHasMipMap(r1);
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static int getAllocationByteCount(Bitmap r0) {
            return r0.getAllocationByteCount();
        }
    }

    static class Api27Impl {
        private Api27Impl() {
        }

        static Bitmap createBitmapWithSourceColorspace(int r3, int r4, Bitmap r5, boolean r6) {
            Bitmap.Config r0 = r5.getConfig();
            ColorSpace r1 = r5.getColorSpace();
            ColorSpace r2 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (r6 == false) goto L8;
            if (r5.getColorSpace().equals(r2) == true) goto L8;
            r0 = Bitmap.Config.RGBA_F16;
            r1 = r2;
        L11:
            return Bitmap.createBitmap(r3, r4, r0, r5.hasAlpha(), r1);
        L8:
            if (r5.getConfig() != Bitmap.Config.HARDWARE) goto L11;
            Bitmap.Config r7 = Bitmap.Config.ARGB_8888;
            r0 = Api31Impl.getHardwareBitmapConfig(r5);
            goto L11
        }

        static boolean isAlreadyF16AndLinear(Bitmap r3) {
            ColorSpace r0 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (r3.getConfig() == Bitmap.Config.RGBA_F16) goto L5;
        L7:
            return false;
        L5:
            if (r3.getColorSpace().equals(r0) == false) goto L7;
            return true;
        }

        static Bitmap copyBitmapIfHardware(Bitmap r2) {
            if (r2.getConfig() != Bitmap.Config.HARDWARE) goto L6;
            Bitmap.Config r0 = Bitmap.Config.ARGB_8888;
            return r2.copy(Api31Impl.getHardwareBitmapConfig(r2), true);
        L6:
            return r2;
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void setPaintBlendMode(Paint r1) {
            r1.setBlendMode(BlendMode.SRC);
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static Bitmap.Config getHardwareBitmapConfig(Bitmap r1) {
            if (r1.getHardwareBuffer().getFormat() != 22) goto L7;
            return Bitmap.Config.RGBA_F16;
        L7:
            return Bitmap.Config.ARGB_8888;
        }
    }

    public static int sizeAtStep(int r1, int r2, int r3, int r4) {
        if (r3 != 0) goto L5;
        return r2;
    L5:
        if (r3 <= 0) goto L9;
        return r1 * (1 << (r4 - r3));
    L9:
        return r2 << ((-r3) - 1);
    }

    public static boolean hasMipMap(Bitmap r0) {
        return Api17Impl.hasMipMap(r0);
    }

    public static void setHasMipMap(Bitmap r0, boolean r1) {
        Api17Impl.setHasMipMap(r0, r1);
    }

    public static int getAllocationByteCount(Bitmap r0) {
        return Api19Impl.getAllocationByteCount(r0);
    }

    public static Bitmap createScaledBitmap(Bitmap r20, int r21, int r22, Rect r23, boolean r24) {
        if (r21 <= 0) goto L127;
        if (r22 <= 0) goto L127;
        if (r23 != null) goto L7;
    L19:
        Bitmap r4 = Api27Impl.copyBitmapIfHardware(r20);
        if (r23 == null) goto L22;
        int r5 = r23.width();
    L23:
        if (r23 == null) goto L25;
        int r6 = r23.height();
    L26:
        float r7 = r21 / r5;
        float r8 = r22 / r6;
        if (r23 == null) goto L29;
        int r10 = r23.left;
    L30:
        if (r23 == null) goto L32;
        int r3 = r23.top;
    L34:
        if (r10 != 0) goto L46;
        if (r3 != 0) goto L46;
        if (r21 != r20.getWidth()) goto L46;
        if (r22 != r20.getHeight()) goto L46;
        if (r20.isMutable() == false) goto L45;
        if (r20 != r4) goto L45;
        return r20.copy(r20.getConfig(), true);
    L45:
        return r4;
    L46:
        Paint r12 = new Paint(1);
        r12.setFilterBitmap(true);
        Api29Impl.setPaintBlendMode(r12);
        if (r5 != r21) goto L51;
        if (r6 != r22) goto L51;
        Bitmap r0 = Bitmap.createBitmap(r21, r22, r4.getConfig());
        new Canvas(r0).drawBitmap(r4, -r10, -r3, r12);
        return r0;
    L51:
        double r13 = Math.log(2.0d);
        if (r7 <= 1.0f) goto L54;
        double r9 = Math.ceil(Math.log(r7) / r13);
    L55:
        int r11 = (int) r9;
        if (r8 <= 1.0f) goto L58;
        double r14 = Math.ceil(Math.log(r8) / r13);
    L59:
        int r15 = (int) r14;
        if (r24 == true) goto L62;
    L70:
        Bitmap r16 = null;
        int r17 = r10;
        int r18 = 0;
    L71:
        Rect r19 = new Rect(r17, r3, r5, r6);
        Rect r25 = new Rect();
        int r110 = r11;
        int r111 = r15;
    L72:
        if (r110 != 0) goto L79;
        if (r111 != 0) goto L79;
        if (r16 == r20) goto L78;
        if (r16 == null) goto L78;
        r16.recycle();
    L78:
        return r4;
    L79:
        if (r110 >= 0) goto L81;
        r110 = r110 + 1;
    L83:
        if (r111 >= 0) goto L85;
        r111 = r111 + 1;
    L87:
        Bitmap r112 = r4;
        Paint r113 = r12;
        r25.set(0, 0, sizeAtStep(r5, r21, r110, r11), sizeAtStep(r6, r22, r111, r15));
        if (r110 != 0) goto L91;
        if (r111 != 0) goto L91;
        boolean r26 = true;
    L92:
        if (r16 != null) goto L94;
    L98:
        boolean r114 = false;
    L99:
        if (r16 == null) goto L109;
        if (r16 == r20) goto L109;
        if (r24 == true) goto L103;
    L104:
        if (r26 == false) goto L108;
        if (r114 == false) goto L109;
        if (r18 != 0) goto L109;
    L108:
        r4 = r16;
    L125:
        new Canvas(r4).drawBitmap(r112, r19, r25, r113);
        r19.set(r25);
        r16 = r112;
        r12 = r113;
        goto L72
    L103:
        if (Api27Impl.isAlreadyF16AndLinear(r16) == true) goto L104;
    L109:
        if (r16 == r20) goto L112;
        if (r16 == null) goto L112;
        r16.recycle();
    L112:
        if (r110 <= 0) goto L114;
        int r27 = r18;
    L115:
        int r28 = sizeAtStep(r5, r21, r27, r11);
        if (r111 <= 0) goto L118;
        int r115 = r18;
    L119:
        int r116 = sizeAtStep(r6, r22, r115, r15);
        if (r24 == false) goto L123;
        if (r26 == true) goto L123;
        boolean r29 = true;
    L124:
        r4 = Api27Impl.createBitmapWithSourceColorspace(r28, r116, r20, r29);
    L123:
        r29 = false;
        goto L124
    L118:
        r115 = r111;
        goto L119
    L114:
        r27 = r110;
        goto L115
    L94:
        if (r16.getWidth() != r21) goto L98;
        if (r16.getHeight() != r22) goto L98;
        r114 = true;
    L91:
        r26 = false;
        goto L92
    L85:
        if (r111 <= 0) goto L87;
        r111 = r111 - 1;
        goto L87
    L81:
        if (r110 <= 0) goto L83;
        r110 = r110 - 1;
        goto L83
    L62:
        if (Api27Impl.isAlreadyF16AndLinear(r20) == true) goto L70;
        if (r11 <= 0) goto L65;
        int r30 = sizeAtStep(r5, r21, 1, r11);
    L66:
        if (r15 <= 0) goto L68;
        int r117 = sizeAtStep(r6, r22, 1, r15);
    L69:
        Bitmap r31 = Api27Impl.createBitmapWithSourceColorspace(r30, r117, r20, true);
        new Canvas(r31).drawBitmap(r4, -r10, -r3, r12);
        r18 = 1;
        r3 = 0;
        r17 = 0;
        r16 = r4;
        r4 = r31;
        goto L71
    L68:
        r117 = r6;
        goto L69
    L65:
        r30 = r5;
        goto L66
    L58:
        r14 = Math.floor(Math.log(r8) / r13);
        goto L59
    L54:
        r9 = Math.floor(Math.log(r7) / r13);
        goto L55
    L32:
        r3 = 0;
        goto L34
    L29:
        r10 = 0;
        goto L30
    L25:
        r6 = r20.getHeight();
        goto L26
    L22:
        r5 = r20.getWidth();
        goto L23
    L7:
        if (r23.isEmpty() == true) goto L18;
        if (r23.left < 0) goto L18;
        if (r23.right > r20.getWidth()) goto L18;
        if (r23.top < 0) goto L18;
        if (r23.bottom <= r20.getHeight()) goto L19;
    L18:
        throw new IllegalArgumentException("srcRect must be contained by srcBm!");
    L127:
        throw new IllegalArgumentException("dstW and dstH must be > 0!");
    }

    private BitmapCompat() {
    }
}
