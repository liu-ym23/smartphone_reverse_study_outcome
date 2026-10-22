package com.tencent.qqimagecompare;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.ExifInterface;
import tmsdkobf.q8;

/* JADX INFO: loaded from: classes4.dex */
public class QQImageLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f29a = false;

    static {
    }

    public QQImageLoader() {
    }

    public static int DecodeJpegFileScale(String r2, int r3, QQImageBitmap r4) {
        return DecodeJpegFileScaleC1s1i1l(r2, r3, r4.f23a);
    }

    private static native int DecodeJpegFileScaleC(String r0, int r1, Bitmap r2);

    private static native int DecodeJpegFileScaleC1s1i1l(String r0, int r1, long r2);

    private static native int DecodeJpegFileScaleMemC(byte[] r0, int r1, Bitmap r2);

    private static native int DecodeJpegFileSubImageC(String r0, int r1, int r2, int r3, int r4, int r5, int r6, Bitmap r7);

    public static QQImageLoaderHeadInfo GetImageHeadInfo(String r3) {
        QQImageLoaderHeadInfo r0 = new QQImageLoaderHeadInfo();
        if (f29a == true) goto L5;
    L7:
        BitmapFactory.Options r1 = new BitmapFactory.Options();
        r1.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r3, r1);
        r0.width = r1.outWidth;
        r0.height = r1.outHeight;
        r0.bJpeg = false;
    L8:
        return r0;
    L5:
        if (IsJpegFileC(r3) == false) goto L7;
        GetJpegHeadInfoC(r3, r0);
        r0.bJpeg = true;
        goto L8
    }

    private static native int GetJpegHeadInfoC(String r0, QQImageLoaderHeadInfo r1);

    private static native int GetJpegHeadInfoMemC(byte[] r0, QQImageLoaderHeadInfo r1);

    static native boolean IsJpegFileC(String r0);

    private static Bitmap a(byte[] r7, int r8, int r9) {
        QQImageLoaderHeadInfo r0 = new QQImageLoaderHeadInfo();
        if (GetJpegHeadInfoMemC(r7, r0) != 0) goto L21;
        int r1 = 1;
        r0.bJpeg = true;
        int r10 = calculateInSampleSize_1_8_max(r0.width, r0.height, r8, r9);
        int r11 = r0.width;
        int r3 = r0.height;
        if (r10 != 1) goto L7;
        r1 = 0;
    L16:
        Bitmap r12 = Bitmap.createBitmap(r11, r3, Bitmap.Config.ARGB_8888);
        if (DecodeJpegFileScaleMemC(r7, r1, r12) == 0) goto L20;
        r12.recycle();
        return null;
    L20:
        return r12;
    L7:
        if (r10 != 2) goto L9;
        r11 = a(r11 << 2, 8);
        r3 = a(r0.height << 2, 8);
        goto L16
    L9:
        if (r10 == 4) goto L13;
        if (r10 != 8) goto L16;
        r11 = a(r11, 8);
        r3 = a(r0.height, 8);
        r1 = 3;
        goto L16
    L13:
        r11 = a(r11 << 1, 8);
        r3 = a(r0.height << 1, 8);
        r1 = 2;
        goto L16
    L21:
        return null;
    }

    private static Bitmap b(String r2) {
        ExifInterface r1 = new ExifInterface(r2);     // Catch: Exception -> L5
    L7:
        if (r1 == null) goto L14;
        byte[] r3 = r1.getThumbnail();
        if (r3 != null) goto L11;
        return null;
    L11:
        return a(r3, 100, 100);
    L14:
        return null;
    L5:
        e = move-exception;
        e.printStackTrace();
        r1 = null;
        goto L7
    }

    public static int calculateInSampleSize(BitmapFactory.Options r3, int r4, int r5) {
        int r0 = r3.outHeight;
        int r6 = r3.outWidth;
        int r1 = 1;
        if (r0 > r5) goto L5;
        if (r6 > r4) goto L5;
    L11:
        return r1;
    L5:
        int r2 = r0 / 2;
        int r7 = r6 / 2;
    L7:
        if ((r2 / r1) <= r5) goto L11;
        if ((r7 / r1) <= r4) goto L11;
        r1 = r1 * 2;
        goto L7
    }

    public static int calculateInSampleSize_1_8_max(int r2, int r3, int r4, int r5) {
        int r0 = 1;
        if (r2 > r5) goto L5;
        if (r3 > r4) goto L5;
    L12:
        return r0;
    L5:
        int r6 = r2 / 2;
        int r7 = r3 / 2;
    L7:
        if ((r6 / r0) <= r5) goto L12;
        if ((r7 / r0) <= r4) goto L12;
        r0 = r0 * 2;
        if (r0 != 8) goto L7;
        goto L12
    }

    public static Bitmap decodeSampledBitmapFromFile(String r5, int r6, int r7) {
        BitmapFactory.Options r1 = new BitmapFactory.Options();
        r1.inJustDecodeBounds = true;
        Bitmap r2 = null;
        BitmapFactory.decodeFile(r5, r1);     // Catch: Exception -> L5
        r1.inSampleSize = calculateInSampleSize(r1, r6, r7);     // Catch: Exception -> L5
        r1.inJustDecodeBounds = false;     // Catch: Exception -> L5
        long r8 = System.currentTimeMillis();     // Catch: Exception -> L5
        r2 = BitmapFactory.decodeFile(r5, r1);     // Catch: Exception -> L5
        q8.c("QQImageCompare", "decode file time: " + (System.currentTimeMillis() - r8));     // Catch: Exception -> L5
        return r2;
    L5:
        e = move-exception;
        e.printStackTrace();
        return r2;
    }

    public static Bitmap loadBitmap100x100FromFile(String r10) {
        long r0 = System.currentTimeMillis();
        if (IsJpegFileC(r10) == false) goto L7;
        Bitmap r2 = b(r10);
        if (r2 != null) goto L9;
        r2 = a(r10, 100, 100);
    L9:
        if (r2 != null) goto L11;
        r2 = null;
    L16:
        q8.c("QQImageCompare", "loadBitmap100x100FromFile t = " + (System.currentTimeMillis() - r0));
        return r2;
    L11:
        if (r2.getWidth() == 100) goto L13;
    L14:
        Bitmap r4 = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Canvas r5 = new Canvas(r4);
        Rect r6 = new Rect();
        r6.set(0, 0, r2.getWidth(), r2.getHeight());
        Rect r7 = new Rect();
        r7.set(0, 0, 100, 100);
        r5.drawBitmap(r2, r6, r7, null);
        r2.recycle();
        r2 = r4;
        goto L16
    L13:
        if (r2.getHeight() == 100) goto L16;
    L7:
        r2 = decodeSampledBitmapFromFile(r10, 100, 100);
        goto L9
    }

    public static Bitmap loadBitmapFromFile(String r4, int r5, int r6) {
        if (IsJpegFileC(r4) == false) goto L31;
        ExifInterface r0 = new ExifInterface(r4);     // Catch: Exception -> L6
    L8:
        if (r0 == null) goto L28;
        byte[] r1 = r0.getThumbnail();
        if (r1 == null) goto L23;
        QQImageLoaderHeadInfo r2 = a(r1);
        if (r2 == null) goto L28;
        int r3 = r2.width;
        if (r5 > r3) goto L19;
        if (r6 > r2.height) goto L19;
        Bitmap r7 = a(r1, r5, r6);
    L29:
        if (r7 == null) goto L31;
        return r7;
    L19:
        if (r5 > (r3 >> 3)) goto L28;
        if (r6 > (r2.height >> 3)) goto L28;
    L27:
        r7 = a(r4, r5, r6);
        goto L29
    L23:
        QQImageLoaderHeadInfo r8 = a(r4);
        if (r5 > (r8.width >> 3)) goto L28;
        if (r6 <= (r8.height >> 3)) goto L27;
    L28:
        r7 = decodeSampledBitmapFromFile(r4, r5, r6);
    L6:
        e = move-exception;
        e.printStackTrace();
        r0 = null;
    L31:
        return decodeSampledBitmapFromFile(r4, r5, r6);
    }

    public static Bitmap loadBitmapSubImage(String r10, int r11, int r12, int r13, int r14, QQImageLoaderHeadInfo r15) {
        if (r15.bJpeg == false) goto L16;
        Bitmap r0 = Bitmap.createBitmap(r13, r14, Bitmap.Config.ARGB_8888);
        if (DecodeJpegFileSubImageC(r10, r11, r12, r13, r14, r15.mMCUWidth, r15.mMCUHeight, r0) == 0) goto L19;
        r0.recycle();
        return null;
    L19:
        return r0;
    L16:
        BitmapRegionDecoder r16 = BitmapRegionDecoder.newInstance(r10, true);     // Catch: Exception -> L11
    L13:
        if (r16 == null) goto L20;
        Rect r17 = new Rect();
        r17.set(r11, r12, r13 + r11, r14 + r12);
        Bitmap r1 = r16.decodeRegion(r17, null);
        r16.recycle();
        return r1;
    L20:
        return null;
    L11:
        e = move-exception;
        e.printStackTrace();
        r16 = null;
        goto L13
    }

    private static Bitmap a(String r7, int r8, int r9) {
        QQImageLoaderHeadInfo r0 = new QQImageLoaderHeadInfo();
        if (GetJpegHeadInfoC(r7, r0) != 0) goto L21;
        int r1 = 1;
        r0.bJpeg = true;
        int r10 = calculateInSampleSize_1_8_max(r0.width, r0.height, r8, r9);
        int r11 = r0.width;
        int r3 = r0.height;
        if (r10 != 1) goto L7;
        r1 = 0;
    L16:
        Bitmap r12 = Bitmap.createBitmap(r11, r3, Bitmap.Config.ARGB_8888);
        if (DecodeJpegFileScaleC(r7, r1, r12) == 0) goto L20;
        r12.recycle();
        return null;
    L20:
        return r12;
    L7:
        if (r10 != 2) goto L9;
        r11 = a(r11 << 2, 8);
        r3 = a(r0.height << 2, 8);
        goto L16
    L9:
        if (r10 == 4) goto L13;
        if (r10 != 8) goto L16;
        r11 = a(r11, 8);
        r3 = a(r0.height, 8);
        r1 = 3;
        goto L16
    L13:
        r11 = a(r11 << 1, 8);
        r3 = a(r0.height << 1, 8);
        r1 = 2;
        goto L16
    L21:
        return null;
    }

    public static int calculateInSampleSize_1_8_max(BitmapFactory.Options r3, int r4, int r5) {
        int r0 = r3.outHeight;
        int r6 = r3.outWidth;
        int r1 = 1;
        if (r0 > r5) goto L5;
        if (r6 > r4) goto L5;
    L12:
        return r1;
    L5:
        int r2 = r0 / 2;
        int r7 = r6 / 2;
    L7:
        if ((r2 / r1) <= r5) goto L12;
        if ((r7 / r1) <= r4) goto L12;
        r1 = r1 * 2;
        if (r1 != 8) goto L7;
        goto L12
    }

    private static int a(int r0, int r1) {
        return ((r0 + r1) - 1) / r1;
    }

    private static QQImageLoaderHeadInfo a(String r1) {
        QQImageLoaderHeadInfo r0 = new QQImageLoaderHeadInfo();
        if (GetJpegHeadInfoC(r1, r0) == 0) goto L6;
        return null;
    L6:
        return r0;
    }

    private static QQImageLoaderHeadInfo a(byte[] r1) {
        QQImageLoaderHeadInfo r0 = new QQImageLoaderHeadInfo();
        if (GetJpegHeadInfoMemC(r1, r0) == 0) goto L6;
        return null;
    L6:
        return r0;
    }
}
