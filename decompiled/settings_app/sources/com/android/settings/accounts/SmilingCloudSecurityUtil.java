package com.android.settings.accounts;

import android.util.Base64InputStream;
import java.io.ByteArrayInputStream;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class SmilingCloudSecurityUtil {
    private static final String ACKCODE = "U01BUlRJU0FOV0lMTEZPVU5EWU9VJCNAIyRAISMjQCEhQEBAIQ==";

    private static class AESUtil {
        private AESUtil() {
        }

        static /* synthetic */ String access$100(String r0, String r1) throws Exception {
            return encrypt(r0, r1);
        }

        private static String encrypt(String r0, String r1) throws Exception {
            return toHex(encrypt(getRawKey(r0.getBytes()), r1.getBytes()));
        }

        public static String decrypt(String r0, String r1) throws Exception {
            return new String(decrypt(getRawKey(r0.getBytes()), toByte(r1)));
        }

        private static byte[] getRawKey(byte[] r3) throws Exception {
            KeyGenerator r0 = KeyGenerator.getInstance("AES");
            SecureRandom r1 = SecureRandom.getInstance("SHA1PRNG", "Crypto");
            r1.setSeed(r3);
            r0.init(128, r1);
            return r0.generateKey().getEncoded();
        }

        private static byte[] encrypt(byte[] r2, byte[] r3) throws Exception {
            SecretKeySpec r0 = new SecretKeySpec(r2, "AES");
            Cipher r4 = Cipher.getInstance("AES");
            r4.init(1, r0);
            return r4.doFinal(r3);
        }

        private static byte[] decrypt(byte[] r2, byte[] r3) throws Exception {
            SecretKeySpec r0 = new SecretKeySpec(r2, "AES");
            Cipher r4 = Cipher.getInstance("AES");
            r4.init(2, r0);
            return r4.doFinal(r3);
        }

        private static byte[] toByte(String r5) {
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

        private static String toHex(byte[] r3) {
            if (r3 != null) goto L5;
            return "";
        L5:
            StringBuffer r0 = new StringBuffer(r3.length * 2);
            int r1 = 0;
        L7:
            if (r1 >= r3.length) goto L10;
            appendHex(r0, r3[r1]);
            r1 = r1 + 1;
            goto L7
        L10:
            return r0.toString();
        }

        private static void appendHex(StringBuffer r2, byte r3) {
            r2.append("0123456789ABCDEF".charAt((r3 >> 4) & 15)).append("0123456789ABCDEF".charAt(r3 & 15));
        }
    }

    private static class Base64Util {
        private Base64Util() {
        }

        static /* synthetic */ String access$000(String r0) {
            return decode(r0);
        }

        private static String decode(String r3) {
            byte[] r0 = new byte[getBufferSize(r3)];
            new Base64InputStream(new ByteArrayInputStream(r3.getBytes()), 0).read(r0);     // Catch: Exception -> L5
        L8:
            return new String(r0);
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L8
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

    public SmilingCloudSecurityUtil() {
    }

    public static String getReallyValue(String r1) {
        return AESUtil.decrypt(Base64Util.access$000(ACKCODE), r1);
    L4:
        return null;
    }

    public static String getStoreAccessValue(String r1) {
        return AESUtil.access$100(Base64Util.access$000(ACKCODE), r1);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
