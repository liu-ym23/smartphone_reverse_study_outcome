package com.android.settings.http;

import android.util.Base64InputStream;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes2.dex */
public class RSAUtils {
    static final byte[] HEX_CHAR_TABLE = null;

    /* JADX INFO: renamed from: com.android.settings.http.RSAUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Base64Util {
        private Base64Util() {
        }

        /* synthetic */ Base64Util(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ byte[] access$100(String r0) {
            return decode(r0);
        }

        private static byte[] decode(String r3) {
            byte[] r0 = new byte[getBufferSize(r3)];
            new Base64InputStream(new ByteArrayInputStream(r3.getBytes()), 0).read(r0);     // Catch: Exception -> L5
        L7:
            return r0;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        private static int getBufferSize(String r3) {
            int r0 = (r3.length() / 4) * 3;
            int r1 = r3.indexOf(61);
            if (r1 != (-1)) goto L5;
            return r0;
        L5:
            return r0 - (r3.length() - r1);
        }
    }

    public RSAUtils() {
    }

    static {
        HEX_CHAR_TABLE = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    }

    public static byte[] encryptByPublicKey(String r3, String r4) throws Exception {
        new Base64Util(null);
        X509EncodedKeySpec r0 = new X509EncodedKeySpec(Base64Util.access$100(r4));
        PublicKey r5 = KeyFactory.getInstance("RSA").generatePublic(r0);
        Cipher r1 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r1.init(1, r5);
        return r1.doFinal(r3.getBytes());
    }

    public static String getHexString(byte[] r8) throws UnsupportedEncodingException {
        byte[] r0 = new byte[r8.length * 2];
        int r1 = r8.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L6;
        int r4 = r8[r2] & 255;
        int r5 = r3 + 1;
        byte[] r6 = HEX_CHAR_TABLE;
        r0[r3] = r6[r4 >>> 4];
        r3 = r5 + 1;
        r0[r5] = r6[r4 & 15];
        r2 = r2 + 1;
        goto L3
    L6:
        return new String(r0, "ASCII");
    }

    public static String parsePublicKey(String r4) {
        if (r4 == null) goto L12;
        String[] r5 = r4.split(System.getProperty("line.separator"));
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L5:
        if (r1 >= r5.length) goto L11;
        if (r5[r1].startsWith("----") == true) goto L9;
        r0.append(r5[r1]);
    L9:
        r1 = r1 + 1;
        goto L5
    L11:
        return r0.toString();
    L12:
        return null;
    }

    public static String urlEncodeData(HashMap<String, String> r6) {
        Set<String> r0 = r6.keySet();
        StringBuilder r1 = new StringBuilder();
        Iterator<String> r2 = r0.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L15;
        String r4 = r2.next();
        String r5 = r6.get(r4);
        if (r5 == null) goto L4;
        if (r3 == 0) goto L10;
        r1.append("&");
    L10:
        String r7 = URLEncoder.encode(r5);
        if (r7 == null) goto L13;
        r1.append(r4).append("=").append(r7);
    L13:
        r3 = r3 + 1;
        goto L4
    L15:
        return r1.toString();
    }
}
