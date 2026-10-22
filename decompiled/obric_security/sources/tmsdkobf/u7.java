package tmsdkobf;

import android.graphics.Bitmap;
import com.tencent.qqimagecompare.QQImageFeatureHSV;
import com.tencent.qqimagecompare.QQImageLoader;

/* JADX INFO: loaded from: classes5.dex */
public abstract class u7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f549a = false;

    static {
    }

    public static int a(QQImageFeatureHSV r1, QQImageFeatureHSV r2) {
        if (f549a == true) goto L10;
        a();
    L10:
        return r1.compare(r2);
    L7:
        th = move-exception;
        q8.e("ImageFeatureCenter", th);
        return 0;
    }

    public static QQImageFeatureHSV a(byte[] r2) {
        if (f549a == true) goto L6;
        a();
    L6:
        if (r2 != null) goto L14;
    L13:
        return null;
    L14:
        QQImageFeatureHSV r1 = new QQImageFeatureHSV();     // Catch: Throwable -> L11
        r1.init();     // Catch: Throwable -> L11
        if (r1.unserialization(r2) == 0) goto L10;
        return null;
    L10:
        return r1;
    L11:
        th = move-exception;
        q8.e("ImageFeatureCenter", th);
        goto L13
    }

    private static byte[] a(Bitmap r2) {
        byte[] r0 = null;
        QQImageFeatureHSV r1 = new QQImageFeatureHSV();     // Catch: Throwable -> L5
        r1.init();     // Catch: Throwable -> L5
        r1.getImageFeature(r2);     // Catch: Throwable -> L5
        r2.recycle();     // Catch: Throwable -> L5
        r0 = r1.serialization();     // Catch: Throwable -> L5
        r1.finish();     // Catch: Throwable -> L5
        return r0;
    L5:
        th = move-exception;
        q8.e("ImageFeatureCenter", th);
        return r0;
    }

    public static QQImageFeatureHSV a(w7.a r0) {
        return a(a(r0.c));
    }

    private static byte[] a(String r2) {
        if (f549a == true) goto L6;
        a();
    L6:
        if (f549a == true) goto L15;
    L14:
        return null;
    L15:
        Bitmap r3 = QQImageLoader.loadBitmap100x100FromFile(r2);     // Catch: Throwable -> L9
    L11:
        if (r3 == null) goto L14;
        return a(r3);
    L9:
        th = move-exception;
        q8.e("ImageFeatureCenter", th);
        r3 = null;
        goto L11
    }

    private static synchronized void a() {
        monitor-enter(u7.class);
        System.loadLibrary("QQImageCompare-1.6.1-mfr");     // Catch: Throwable -> L7
        f549a = true;     // Catch: Throwable -> L7
    L13:
        monitor-exit(u7.class);
        return;
    L7:
        th = move-exception;
        q8.e("ImageFeatureCenter", th);     // Catch: Throwable -> L15
        System.loadLibrary("QQImageCompare-1.6.1-mfr");     // Catch: Throwable -> L11
        f549a = true;     // Catch: Throwable -> L11
    L18:
        goto L13
    L11:
        th = move-exception;
        q8.e("ImageFeatureCenter", th);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }
}
