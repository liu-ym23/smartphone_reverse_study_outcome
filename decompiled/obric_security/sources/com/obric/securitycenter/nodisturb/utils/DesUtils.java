package com.obric.securitycenter.nodisturb.utils;

import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import com.obric.olog.OLog;
import com.obric.security.platformkey.PlatformKeyManager;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: compiled from: DesUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0007J*\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016H\u0007J \u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0007J*\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016H\u0007J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\rH\u0007J(\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0014\u0010\"\u001a\u0004\u0018\u00010\r2\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010$\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u00192\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/securitycenter/nodisturb/utils/DesUtils;", "", "()V", DesUtils.DES, "", "PASSWORD_CRYPT_KEY_BIZ_PUB_KEY_NAME", "PASSWORD_CRYPT_KEY_CIPHER_NAME", "TAG", "isKeyInitialized", "", "passwordCryptKey", "byte2hex", "b", "", "bytesToHexString", "src", "decodePreconfiguredBytes", "value", "decrypt", "key", "hexCipherText", "eventMap", "", "decryptByPlatformKey", "context", "Landroid/content/Context;", "cipher", "bizPubKey", "encrypt", "str", "getHash", "algorithm", "data", "getPlatformProtectedPasswordCryptKey", "hex2byte", "inHex", "initKey", "", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DesUtils {
    private static final String DES = "DES";
    public static final DesUtils INSTANCE = null;
    private static final String PASSWORD_CRYPT_KEY_BIZ_PUB_KEY_NAME = "PASSWORD_CRYPT_KEY_BIZ_PUB_KEY";
    private static final String PASSWORD_CRYPT_KEY_CIPHER_NAME = "PASSWORD_CRYPT_KEY_CIPHER";
    private static final String TAG = "DesUtils";
    private static volatile boolean isKeyInitialized;
    private static volatile String passwordCryptKey;

    private DesUtils() {
    }

    static {
        INSTANCE = new DesUtils();
        passwordCryptKey = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void initKey$default(DesUtils r0, Context r1, Map r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.initKey(r1, r2);
    }

    public final void initKey(Context r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        if (isKeyInitialized == false) goto L5;
        return;
    L5:
        monitor-enter(DesUtils.class);
    L28:
        th = move-exception;
        throw th;
    L7:
        if (isKeyInitialized == false) goto L35;
    L25:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(DesUtils.class);
        return;
    L35:
        passwordCryptKey = INSTANCE.getPlatformProtectedPasswordCryptKey(r6, r7);     // Catch: Throwable -> L12
    L10:
        isKeyInitialized = true;     // Catch: Throwable -> L28
        goto L25
    L12:
        th = move-exception;
        OLog.e(TAG, "initKey ex=" + th.getMessage());     // Catch: Throwable -> L22
        if (r7 == null) goto L19;
        String r8 = th.getMessage();     // Catch: Throwable -> L22
        if (r8 != null) goto L18;
        r8 = "";
    L18:
        String r9 = r7.put("init_des_key_failed", r8);     // Catch: Throwable -> L22
    L19:
        if (r7 == null) goto L10;
        String r10 = r7.put("success", "0");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        isKeyInitialized = true;     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    }

    public static /* synthetic */ String decrypt$default(String r0, Map r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = null;
    L6:
        return decrypt(r0, r1);
    }

    @JvmStatic
    public static final String decrypt(String r8, Map<String, String> r9) {
        Intrinsics.checkNotNullParameter(r8, "hexCipherText");
        boolean r2 = true;
        if (r8.length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L9;
    L26:
        if (r9 == null) goto L28;
        String r10 = r9.put("decrypt_des_failed", "hexCipherText or passwordCryptKey is empty");
    L28:
        if (r9 == null) goto L30;
        String r11 = r9.put("success", "0");
    L30:
        return null;
    L9:
        if (passwordCryptKey.length() == 0) goto L12;
        r2 = false;
    L12:
        if (r2 == true) goto L26;
        byte[] r12 = r8.getBytes(Charsets.UTF_8);     // Catch: Exception -> L16
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).getBytes(charset)");     // Catch: Exception -> L16
        byte[] r13 = hex2byte(r12);     // Catch: Exception -> L16
        byte[] r3 = passwordCryptKey.getBytes(Charsets.UTF_8);     // Catch: Exception -> L16
        Intrinsics.checkNotNullExpressionValue(r3, "this as java.lang.String).getBytes(charset)");     // Catch: Exception -> L16
        byte[] r14 = decrypt(r13, r3);     // Catch: Exception -> L16
        Charset r0 = Charset.defaultCharset();     // Catch: Exception -> L16
        Intrinsics.checkNotNullExpressionValue(r0, "defaultCharset()");     // Catch: Exception -> L16
        return new String(r14, r0);
    L16:
        e = move-exception;
        if (r9 == null) goto L22;
        String r15 = e.getMessage();
        if (r15 != null) goto L21;
        r15 = "";
    L21:
        String r16 = r9.put("decrypt_des_failed", r15);
    L22:
        if (r9 == null) goto L24;
        String r17 = r9.put("success", "0");
    L24:
        String r18 = (String) null;
        return null;
    L5:
        r1 = false;
        goto L7
    }

    public static /* synthetic */ String encrypt$default(String r0, Map r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = null;
    L6:
        return encrypt(r0, r1);
    }

    @JvmStatic
    public static final String encrypt(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "str");
        byte[] r5 = r3.getBytes(Charsets.UTF_8);     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String).getBytes(charset)");     // Catch: Exception -> L5
        byte[] r1 = passwordCryptKey.getBytes(Charsets.UTF_8);     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r1, "this as java.lang.String).getBytes(charset)");     // Catch: Exception -> L5
        return byte2hex(encrypt(r5, r1));
    L5:
        e = move-exception;
        OLog.e(TAG, "encrypt ex=" + e.getMessage());
        if (r4 == null) goto L12;
        String r6 = e.getMessage();
        if (r6 != null) goto L11;
        r6 = "";
    L11:
        String r7 = r4.put("encrypt_des_failed", r6);
    L12:
        if (r4 == null) goto L14;
        String r8 = r4.put("success", "0");
    L14:
        String r9 = (String) null;
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ String getPlatformProtectedPasswordCryptKey$default(DesUtils r0, Context r1, Map r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.getPlatformProtectedPasswordCryptKey(r1, r2);
    }

    private final String getPlatformProtectedPasswordCryptKey(Context r7, Map<String, String> r8) {
        String r0 = FileUtils.getKey(r7, PASSWORD_CRYPT_KEY_CIPHER_NAME);
        String r1 = FileUtils.getKey(r7, PASSWORD_CRYPT_KEY_BIZ_PUB_KEY_NAME);
        boolean r3 = true;
        if (r0.length() != 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L9;
        return "";
    L9:
        if (r1.length() == 0) goto L12;
        r3 = false;
    L12:
        if (r3 == true) goto L31;
        byte[] r6 = decryptByPlatformKey(r7, decodePreconfiguredBytes(r0), decodePreconfiguredBytes(r1));     // Catch: Throwable -> L16
        Charset r9 = StandardCharsets.UTF_8;     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r9, "UTF_8");     // Catch: Throwable -> L16
        return new String(r6, r9);
    L16:
        th = move-exception;
        OLog.e(TAG, "getPlatformProtectedPasswordCryptKey ex=" + th.getMessage());
        if (r8 == null) goto L23;
        String r10 = th.getMessage();
        if (r10 != null) goto L22;
        r10 = "";
    L22:
        String r11 = r8.put("decrypt_platform_key_failed", r10);
    L23:
        if (r8 == null) goto L30;
        String r12 = r8.put("success", "0");
        return "";
    L30:
        return "";
    L31:
        return "";
    L5:
        r2 = false;
        goto L7
    }

    private final byte[] decodePreconfiguredBytes(String r6) {
        String r5 = StringsKt.trim(r6).toString();
        if ((r5.length() % 2) != 0) goto L37;
        String r7 = r5;
        int r1 = 0;
    L5:
        boolean r3 = true;
        if (r1 >= r7.length()) goto L33;
        char r2 = r7.charAt(r1);
        if ('0' <= r2) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == false) goto L15;
    L30:
        if (r3 == false) goto L31;
        r1 = r1 + 1;
        goto L5
    L31:
        r3 = false;
        goto L33
    L15:
        if ('a' <= r2) goto L17;
    L19:
        boolean r8 = false;
    L20:
        if (r8 == true) goto L30;
        if ('A' <= r2) goto L24;
    L26:
        boolean r9 = false;
    L27:
        if (r9 == true) goto L30;
        r3 = false;
        goto L30
    L24:
        if (r2 >= 'G') goto L26;
        r9 = true;
        goto L27
    L17:
        if (r2 >= 'g') goto L19;
        r8 = true;
        goto L20
    L10:
        if (r2 >= ':') goto L12;
        r4 = true;
    L33:
        if (r3 == false) goto L37;
        byte[] r10 = hex2byte(r5);
        if (r10 == null) goto L42;
        return r10;
    L42:
        return new byte[0];
    L37:
        byte[] r11 = Base64.decode(r5, 0);
        Intrinsics.checkNotNullExpressionValue(r11, "{\n            Base64.dec…Base64.DEFAULT)\n        }");
        return r11;
    }

    private final byte[] decryptByPlatformKey(Context r7, byte[] r8, byte[] r9) {
        byte[] r6 = PlatformKeyManager.getInstance().decrypt(r7, -983038, r8, r9, new Bundle());
        Intrinsics.checkNotNullExpressionValue(r6, "getInstance().decrypt(\n …      Bundle(),\n        )");
        return r6;
    }

    @JvmStatic
    public static final byte[] decrypt(byte[] r3, byte[] r4) throws Exception {
        Intrinsics.checkNotNullParameter(r3, "src");
        Intrinsics.checkNotNullParameter(r4, "key");
        SecureRandom r0 = new SecureRandom();
        DESKeySpec r1 = new DESKeySpec(r4);
        SecretKey r2 = SecretKeyFactory.getInstance(DES).generateSecret(r1);
        Cipher r5 = Cipher.getInstance(DES);
        r5.init(2, r2, r0);
        byte[] r6 = r5.doFinal(r3);
        Intrinsics.checkNotNullExpressionValue(r6, "cipher.doFinal(src)");
        return r6;
    }

    @JvmStatic
    public static final byte[] encrypt(byte[] r3, byte[] r4) throws Exception {
        Intrinsics.checkNotNullParameter(r3, "src");
        Intrinsics.checkNotNullParameter(r4, "key");
        SecureRandom r0 = new SecureRandom();
        DESKeySpec r1 = new DESKeySpec(r4);
        SecretKey r2 = SecretKeyFactory.getInstance(DES).generateSecret(r1);
        Cipher r5 = Cipher.getInstance(DES);
        r5.init(1, r2, r0);
        byte[] r6 = r5.doFinal(r3);
        Intrinsics.checkNotNullExpressionValue(r6, "cipher.doFinal(src)");
        return r6;
    }

    @JvmStatic
    public static final String byte2hex(byte[] r6) {
        Intrinsics.checkNotNullParameter(r6, "b");
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        String r3 = Integer.toHexString(r6[r2] & UByte.MAX_VALUE);
        if (r3.length() != 1) goto L7;
        r0.append(DeepCleanSAFEngine.DetailPath.KEY);
    L7:
        r0.append(r3);
        r2 = r2 + 1;
        goto L3
    L8:
        String r7 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "sb.toString()");
        String r8 = r7.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r8, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return r8;
    }

    @JvmStatic
    public static final byte[] hex2byte(byte[] r6) {
        Intrinsics.checkNotNullParameter(r6, "b");
        int r2 = 0;
        if ((r6.length % 2) != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        byte[] r1 = new byte[r6.length / 2];
    L9:
        if (r2 >= r6.length) goto L11;
        Charset r3 = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(r3, "defaultCharset()");
        r1[r2 / 2] = (byte) Integer.parseInt(new String(r6, r2, 2, r3), CharsKt.checkRadix(16));
        r2 = r2 + 2;
        goto L9
    L11:
        return r1;
    L13:
        throw new IllegalArgumentException("".toString());
    L5:
        r0 = false;
        goto L6
    }

    @JvmStatic
    public static final byte[] hex2byte(String r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if ((r5.length() % 2) != 0) goto L14;
        byte[] r0 = new byte[r5.length() / 2];
        int r1 = 0;
    L8:
        if (r1 >= r5.length()) goto L10;
        int r2 = r1 + 2;
        String r3 = r5.substring(r1, r2);
        Intrinsics.checkNotNullExpressionValue(r3, "this as java.lang.String…ing(startIndex, endIndex)");
        r0[r1 / 2] = (byte) Integer.parseInt(r3, 16);
        r1 = r2;
        goto L8
    L10:
        return r0;
    L14:
        return null;
    }

    @JvmStatic
    public static final String bytesToHexString(byte[] r6) {
        if (r6 == null) goto L17;
        int r1 = 0;
        if (r6.length != 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L22;
        StringBuilder r2 = new StringBuilder();
        int r3 = r6.length;
    L10:
        if (r1 >= r3) goto L16;
        String r4 = Integer.toHexString(r6[r1] & UByte.MAX_VALUE);
        Intrinsics.checkNotNullExpressionValue(r4, "toHexString(b.toInt() and 0xFF)");
        String r5 = r4.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (r5.length() >= 2) goto L14;
        r2.append(DeepCleanSAFEngine.DetailPath.KEY);
    L14:
        r2.append(r5);
        r1 = r1 + 1;
        goto L10
    L16:
        return r2.toString();
    L22:
        return null;
    L6:
        r0 = false;
        goto L7
    L17:
        return null;
    }

    @JvmStatic
    public static final byte[] getHash(String r1, byte[] r2) {
        Intrinsics.checkNotNullParameter(r1, "algorithm");
        Intrinsics.checkNotNullParameter(r2, "data");
        MessageDigest r3 = MessageDigest.getInstance(r1);     // Catch: Exception -> L5
        r3.update(r2);     // Catch: Exception -> L5
        byte[] r4 = r3.digest();     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r4, "{\n            val digest…digest.digest()\n        }");     // Catch: Exception -> L5
        return r4;
    L5:
        e = move-exception;
        throw new RuntimeException(e.getMessage());
    }
}
