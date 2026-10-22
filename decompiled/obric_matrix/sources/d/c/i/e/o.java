package d.c.i.e;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f15970a = "79e93ec548d39875969ea47be01345cc794f55626fd116f9b6cf4e5c77d313e4";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static byte[] f15971b;

    static {
        f15971b = new byte[]{1, 2, 3, 2, 1, 8, 1, 2, 4, 3, 1, 2};
    }

    public static byte[] a(InputStream r4) {
        byte[] r5 = c(r4);
        byte[] r0 = d(f15970a);
        byte[] r6 = Arrays.copyOfRange(r5, 0, r5.length);
        IvParameterSpec r1 = new IvParameterSpec(f15971b);
        SecretKeySpec r2 = new SecretKeySpec(r0, "AES");
        Cipher r3 = Cipher.getInstance("AES/GCM/NoPadding");
        r3.init(2, r2, r1);
        return r3.doFinal(r6);
    }

    public static byte[] b(InputStream r4) {
        byte[] r5 = c(r4);
        byte[] r0 = d(f15970a);
        byte[] r6 = Arrays.copyOfRange(r5, 0, r5.length);
        IvParameterSpec r1 = new IvParameterSpec(f15971b);
        SecretKeySpec r2 = new SecretKeySpec(r0, "AES");
        Cipher r3 = Cipher.getInstance("AES/GCM/NoPadding");
        r3.init(1, r2, r1);
        return r3.doFinal(r6);
    }

    private static byte[] c(InputStream r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[1024];
    L3:
        int r2 = r4.read(r1);
        if (r2 <= (-1)) goto L6;
        r0.write(r1, 0, r2);
        goto L3
    L6:
        r0.flush();
        r0.close();
        return r0.toByteArray();
    }

    private static byte[] d(String r5) {
        int r0 = r5.length() / 2;
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        int r3 = r2 * 2;
        r1[r2] = Integer.valueOf(r5.substring(r3, r3 + 2), 16).byteValue();
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }
}
