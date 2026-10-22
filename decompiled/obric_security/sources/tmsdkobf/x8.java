package tmsdkobf;

import android.graphics.Bitmap;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes5.dex */
public abstract class x8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f614a = null;
    public static final byte[] b = null;

    static {
        f614a = "0123456789abcdef".toCharArray();
        b = new byte[]{77, 68, 53};
    }

    public static byte[] a(String r0) {
        return a(r0.getBytes());
    }

    public static String b(byte[] r0) {
        return c(a(r0));
    }

    public static String c(byte[] r6) {
        StringBuilder r0 = new StringBuilder(r6.length * 3);
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        byte r3 = r6[r2];
        int r4 = r3 & UByte.MAX_VALUE;
        char[] r5 = f614a;
        r0.append(r5[r4 >> 4]);
        r0.append(r5[r3 & 15]);
        r2 = r2 + 1;
        goto L3
    L6:
        return r0.toString().toUpperCase();
    }

    public static byte[] a(byte[] r2) {
        MessageDigest r0 = MessageDigest.getInstance(new String(b));     // Catch: NoSuchAlgorithmException -> L4
        r0.update(r2);     // Catch: NoSuchAlgorithmException -> L4
        return r0.digest();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String b(String r6) {
        byte[] r7 = a(r6);
        if (r7 != null) goto L6;
        return null;
    L6:
        StringBuilder r0 = new StringBuilder(r7.length * 2);
        int r1 = r7.length;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L10;
        r0.append(Integer.toHexString(r7[r3] & UByte.MAX_VALUE).substring(0, 1));
        r3 = r3 + 1;
        goto L7
    L10:
        return r0.toString();
    }

    public static String c(String r7) {
        byte[] r0 = a(r7);
        if (r0 != null) goto L6;
        r8.c("encypt", "encyptString, text = " + r7 + ", hash == null");
        return null;
    L6:
        r8.c("encypt", "encyptString， before text = " + r7 + ", length = " + r0.length);
        StringBuilder r8 = new StringBuilder(r0.length * 2);
        int r2 = r0.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L13;
        int r4 = r0[r3] & UByte.MAX_VALUE;
        if (Integer.toHexString(r4).length() != 1) goto L11;
        r8.append("0").append(Integer.toHexString(r4));
    L12:
        r3 = r3 + 1;
        goto L7
    L11:
        r8.append(Integer.toHexString(r4));
        goto L12
    L13:
        String r9 = r8.toString().toUpperCase();
        r8.c("encypt", "encyptString, after text = " + r9);
        return r9;
    }

    public static String a(Drawable r8) {
        if (r8 != null) goto L6;
        r8.c("encypt", "encyptDrawable, drawable == null");
        return "";
    L6:
        StringBuilder r1 = new StringBuilder();
    L15:
        th = move-exception;
        r8.b("encypt", th);
    L17:
        String r9 = r1.toString().toUpperCase();
        r8.c("encypt", "encyptDrawable, drawable = " + r9);
        return r9;
    L8:
        if ((r8 instanceof AdaptiveIconDrawable) == false) goto L10;
        AdaptiveIconDrawable r10 = (AdaptiveIconDrawable) r8;     // Catch: Throwable -> L15
        Bitmap r11 = Bitmap.createBitmap(r10.getIntrinsicWidth(), r10.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L15
    L11:
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();     // Catch: Throwable -> L15
        r11.compress(Bitmap.CompressFormat.JPEG, 100, r2);     // Catch: Throwable -> L15
        byte[] r12 = r2.toByteArray();     // Catch: Throwable -> L15
        MessageDigest r3 = MessageDigest.getInstance("SHA-1");     // Catch: Throwable -> L15
        r3.update(r12, 0, r12.length);     // Catch: Throwable -> L15
        byte[] r13 = r3.digest();     // Catch: Throwable -> L15
        int r4 = r13.length;     // Catch: Throwable -> L15
        int r5 = 0;
    L12:
        if (r5 >= r4) goto L17;
        r1.append(String.format("%02x", new Object[]{Byte.valueOf(r13[r5])}));     // Catch: Throwable -> L15
        r5 = r5 + 1;
        goto L12
    L10:
        r11 = ((BitmapDrawable) r8).getBitmap();     // Catch: Throwable -> L15
        goto L11
    }
}
