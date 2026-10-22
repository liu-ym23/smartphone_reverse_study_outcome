package com.tencent.qqimagecompare;

/* JADX INFO: loaded from: classes4.dex */
public class QQImageBitmapLoader {
    public QQImageBitmapLoader() {
    }

    private static native long DecodeJpegFileSubImage1s6iC(String r0, int r1, int r2, int r3, int r4, int r5, int r6);

    public static QQImageBitmap loadBitmapSubImage(String r9, int r10, int r11, int r12, int r13, QQImageLoaderHeadInfo r14) {
        if (r14.bJpeg == false) goto L5;
        QQImageBitmap r0 = new QQImageBitmap(true);
        r0.f23a = DecodeJpegFileSubImage1s6iC(r9, r10, r11, r12, r13, r14.mMCUWidth, r14.mMCUHeight);
        return r0;
    L5:
        return null;
    }
}
