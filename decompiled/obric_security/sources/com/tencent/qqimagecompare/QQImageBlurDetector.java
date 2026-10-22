package com.tencent.qqimagecompare;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import tmsdkobf.q8;

/* JADX INFO: loaded from: classes4.dex */
public class QQImageBlurDetector extends QQImageNativeObject {
    public QQImageBlurDetector() {
    }

    private native int Detect1j1bmpC(long r1, Bitmap r3);

    private native int Detect1j1jC(long r1, long r3);

    public static int aliginInt(int r1, int r2) {
        int r0 = r1 % r2;
        if (r0 != 0) goto L5;
        return r1;
    L5:
        return r1 + (r2 - r0);
    }

    public static int pad_n(int r0, int r1) {
        return ((r0 + r1) - 1) & (~(r1 - 1));
    }

    @Override // com.tencent.qqimagecompare.QQImageNativeObject
    protected native long createNativeObject();

    @Override // com.tencent.qqimagecompare.QQImageNativeObject
    protected native void destroyNativeObject(long r1);

    public int detect(Bitmap r3) {
        return Detect1j1bmpC(this.mThisC, r3);
    }

    public int detect(QQImageBitmap r5) {
        return Detect1j1jC(this.mThisC, r5.f23a);
    }

    public int detect(String r18) {
        q8.c("QQImageBlurDetector", r18);
        QQImageLoaderHeadInfo r3 = QQImageLoader.GetImageHeadInfo(r18);
        int r4 = r3.width;
        int r5 = r3.height;
        int r6 = Math.max(r4, r5);
        int r7 = Math.min(r4, r5);
        int r8 = 0;
        if (r7 < 200) goto L64;
        int r13 = 1;
        if (r6 >= 1800) goto L9;
        int r9 = 0;
    L17:
        if (r7 < 200) goto L64;
        int[] r10 = new int[3];
        if (r3.bJpeg == false) goto L36;
        QQImageBitmap r11 = new QQImageBitmap();
        if (QQImageLoader.DecodeJpegFileScale(r18, r9, r11) != 0) goto L64;
        int r1 = r11.getWidth();
        int r12 = (r11.getHeight() >> 1) - 100;
        int r14 = (r1 / 3) - 100;
        int r15 = (r1 >> 1) - 100;
        int r2 = ((r1 << 1) / 3) - 100;
        QQImageBitmap r16 = new QQImageBitmap(QQImageBitmap.eColorFormat.QQIMAGE_CLR_RGBA8888, 200, 200, 4);
        r11.clip(r16, r14, r12);
        r10[0] = detect(r16);
        r11.clip(r16, r15, r12);
        int r17 = detect(r16);
        r10[1] = r17;
        int r19 = r10[0];
        if (r19 == r17) goto L32;
        r11.clip(r16, r2, r12);
        r10[2] = detect(r16);
        int r0 = 0;
    L25:
        if (r8 >= 3) goto L30;
        if (r10[r8] >= 0) goto L29;
        r0 = r0 + 1;
    L29:
        r8 = r8 + 1;
        goto L25
    L30:
        if (r0 < 2) goto L34;
        r13 = -1;
    L34:
        r8 = r13;
    L35:
        r16.delete();
        r11.delete();
    L65:
        q8.c("QQImageBlurDetector", "nRet = " + r8);
        q8.c("QQImageBlurDetector", "detect out");
        return r8;
    L32:
        if (r19 >= 0) goto L34;
        r8 = -1;
        goto L35
    L36:
        if (r9 == 1) goto L42;
        if (r9 == 2) goto L41;
        if (r9 != 3) goto L43;
        r4 = r4 >> 3;
        r5 = r5 >> 3;
    L43:
        Bitmap r20 = QQImageLoader.decodeSampledBitmapFromFile(r18, r4, r5);
        if (r20 == null) goto L64;
        int r21 = r20.getWidth();
        int r22 = r20.getHeight() >> 1;
        int r23 = r22 - 100;
        int r24 = r21 / 3;
        int r110 = r24 - 100;
        int r111 = r21 >> 1;
        int r112 = r111 - 100;
        int r25 = (r21 << 1) / 3;
        int r113 = r25 - 100;
        Bitmap r114 = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
        if (r114 == null) goto L63;
        Canvas r115 = new Canvas(r114);
        Rect r26 = new Rect();
        int r27 = r22 + 100;
        r26.set(r110, r23, r24 + 100, r27);
        Rect r28 = new Rect();
        int r116 = 0;
        r28.set(0, 0, 200, 200);
        r115.drawBitmap(r20, r26, r28, null);
        r10[0] = detect(r114);
        r26.set(r112, r23, r111 + 100, r27);
        r115.drawBitmap(r20, r26, r28, null);
        int r117 = detect(r114);
        r10[1] = r117;
        int r118 = r10[0];
        if (r118 == r117) goto L58;
        r26.set(r113, r23, r25 + 100, r27);
        r115.drawBitmap(r20, r26, r28, null);
        r10[2] = detect(r114);
        int r29 = 0;
    L50:
        if (r29 >= 3) goto L56;
        if (r10[r29] >= 0) goto L54;
        r116 = r116 + 1;
    L54:
        r29 = r29 + 1;
        goto L50
    L56:
        if (r116 >= 2) goto L59;
    L60:
        int r119 = 1;
    L61:
        r114.recycle();
        r8 = r119;
    L59:
        r119 = -1;
        goto L61
    L58:
        if (r118 >= 0) goto L60;
    L63:
        r20.recycle();
        goto L65
    L41:
        r4 = r4 >> 2;
        r5 = r5 >> 2;
        goto L43
    L42:
        r4 = r4 >> 1;
        r5 = r5 >> 1;
        goto L43
    L9:
        if (r6 < 1800) goto L12;
        if (r6 >= 3600) goto L12;
        r7 = r7 >> 1;
        r9 = 1;
    L12:
        if (r6 >= 3600) goto L14;
    L16:
        r7 = r7 >> 3;
        r9 = 3;
        goto L17
    L14:
        if (r6 >= 7200) goto L16;
        r7 = r7 >> 2;
        r9 = 2;
    L64:
        r8 = 0;
        goto L65
    }
}
