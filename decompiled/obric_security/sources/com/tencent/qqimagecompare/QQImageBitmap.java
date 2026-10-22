package com.tencent.qqimagecompare;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes4.dex */
public class QQImageBitmap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f23a;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f24a = null;

        static {
            int[] r0 = new int[eColorFormat.values().length];
            f24a = r0;
            r0[eColorFormat.QQIMAGE_CLR_RGBA8888.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f24a[eColorFormat.QQIMAGE_CLR_GRAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final enum eColorFormat extends Enum<eColorFormat> {
        public static final eColorFormat QQIMAGE_CLR_GRAY = null;
        public static final eColorFormat QQIMAGE_CLR_RGBA8888 = null;
        public static final eColorFormat QQIMAGE_CLR_UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ eColorFormat[] f25a = null;

        static {
            QQIMAGE_CLR_UNKNOWN = new eColorFormat("QQIMAGE_CLR_UNKNOWN", 0);
            QQIMAGE_CLR_RGBA8888 = new eColorFormat("QQIMAGE_CLR_RGBA8888", 1);
            QQIMAGE_CLR_GRAY = new eColorFormat("QQIMAGE_CLR_GRAY", 2);
            f25a = a();
        }

        private eColorFormat(String r1, int r2) {
            super(r1, r2);
        }

        private static /* synthetic */ eColorFormat[] a() {
            return new eColorFormat[]{QQIMAGE_CLR_UNKNOWN, QQIMAGE_CLR_RGBA8888, QQIMAGE_CLR_GRAY};
        }

        public static eColorFormat valueOf(String r1) {
            return (eColorFormat) Enum.valueOf(eColorFormat.class, r1);
        }

        public static eColorFormat[] values() {
            return (eColorFormat[]) f25a.clone();
        }
    }

    QQImageBitmap() {
        this.f23a = createNativeObject0();
    }

    private native int ClipBitmapC(long r1, Bitmap r3, int r4, int r5);

    private native int ClipC(long r1, long r3, int r5, int r6);

    private native int GetHeightC(long r1);

    private native int GetWidthC(long r1);

    public static long createNativeObject() {
        return createNativeObject0();
    }

    private static native long createNativeObject0();

    private native long createNativeObject4i(int r1, int r2, int r3, int r4);

    private native void destroyNativeObject(long r1);

    public int clip(Bitmap r7, int r8, int r9) {
        return ClipBitmapC(this.f23a, r7, r8, r9);
    }

    public void delete() {
        long r0 = this.f23a;
        if (r0 == 0) goto L6;
        destroyNativeObject(r0);
        this.f23a = 0;
        return;
    }

    public int getHeight() {
        return GetHeightC(this.f23a);
    }

    public int getWidth() {
        return GetWidthC(this.f23a);
    }

    public QQImageBitmap(eColorFormat r2, int r3, int r4, int r5) {
        int r6 = a.f24a[r2.ordinal()];
        int r0 = 1;
        if (r6 == 1) goto L7;
        r0 = 2;
        if (r6 == 2) goto L7;
        r0 = 0;
    L7:
        this.f23a = createNativeObject4i(r0, r3, r4, r5);
    }

    public int clip(QQImageBitmap r8, int r9, int r10) {
        return ClipC(this.f23a, r8.f23a, r9, r10);
    }

    QQImageBitmap(boolean r3) {
        if (r3 == true) goto L6;
        this.f23a = createNativeObject0();
        return;
    }
}
