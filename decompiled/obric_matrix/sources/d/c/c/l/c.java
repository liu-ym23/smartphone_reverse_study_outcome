package d.c.c.l;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f15447a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f15448b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f15449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f15450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte[] f15451e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte[] f15452f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final byte[] f15453g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final byte[] f15454h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final byte[] f15455i = null;

    static {
        if (Build.VERSION.SDK_INT > 17) goto L5;
        boolean r2 = true;
    L6:
        f15447a = r2;
        f15448b = e();
        f15449c = null;
        f15450d = false;
        f15451e = a("RIFF");
        f15452f = a("WEBP");
        f15453g = a("VP8 ");
        f15454h = a("VP8L");
        f15455i = a("VP8X");
        return;
    L5:
        r2 = false;
        goto L6
    }

    private static byte[] a(String r2) {
        return r2.getBytes("ASCII");
    L4:
        e = move-exception;
        throw new RuntimeException("ASCII not found!", e);
    }

    public static boolean b(byte[] r3, int r4) {
        boolean r0 = j(r3, r4 + 12, f15455i);
        if ((r3[r4 + 20] & 2) != 2) goto L5;
        boolean r5 = true;
    L6:
        if (r0 == false) goto L10;
        if (r5 == false) goto L10;
        return true;
    L10:
        return false;
    L5:
        r5 = false;
        goto L6
    }

    public static boolean c(byte[] r1, int r2, int r3) {
        if (r3 >= 21) goto L5;
    L7:
        return false;
    L5:
        if (j(r1, r2 + 12, f15455i) == false) goto L7;
        return true;
    }

    public static boolean d(byte[] r3, int r4) {
        boolean r0 = j(r3, r4 + 12, f15455i);
        if ((r3[r4 + 20] & 16) != 16) goto L5;
        boolean r5 = true;
    L6:
        if (r0 == false) goto L10;
        if (r5 == false) goto L10;
        return true;
    L10:
        return false;
    L5:
        r5 = false;
        goto L6
    }

    private static boolean e() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 17) goto L6;
        return false;
    L6:
        if (r0 != 17) goto L12;
        byte[] r1 = Base64.decode("UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==", 0);
        BitmapFactory.Options r2 = new BitmapFactory.Options();
        r2.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(r1, 0, r1.length, r2);
        if (r2.outHeight == 1) goto L10;
    L11:
        return false;
    L10:
        if (r2.outWidth != 1) goto L11;
    L12:
        return true;
    }

    public static boolean f(byte[] r1, int r2) {
        return j(r1, r2 + 12, f15454h);
    }

    public static boolean g(byte[] r1, int r2) {
        return j(r1, r2 + 12, f15453g);
    }

    public static boolean h(byte[] r1, int r2, int r3) {
        if (r3 >= 20) goto L5;
    L9:
        return false;
    L5:
        if (j(r1, r2, f15451e) == false) goto L9;
        if (j(r1, r2 + 8, f15452f) == false) goto L9;
        return true;
    }

    public static b i() {
        if (f15450d == true) goto L5;
        b r0 = null;
        r0 = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();     // Catch: Throwable -> L11
    L9:
        f15450d = true;
        return r0;
    L5:
        return f15449c;
    }

    private static boolean j(byte[] r4, int r5, byte[] r6) {
        if (r6 == null) goto L18;
        if (r4 == null) goto L18;
        if ((r6.length + r5) <= r4.length) goto L9;
        return false;
    L9:
        int r1 = 0;
    L11:
        if (r1 >= r6.length) goto L16;
        if (r4[r1 + r5] != r6[r1]) goto L14;
        r1 = r1 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L18:
        return false;
    }
}
