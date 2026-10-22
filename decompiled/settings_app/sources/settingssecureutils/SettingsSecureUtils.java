package settingssecureutils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import android.util.Base64;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public class SettingsSecureUtils {
    private static final Map<String, String> AUTHORIZED_6939_PACKAGES = null;
    public static final String NUBIA_CLASS = "cn.nubia.databackup.ui.MainActivity";
    public static final String NUBIA_PACKAGE = "cn.nubia.databackup";
    public static final String TAG = "backup_Utils";
    private static final String ZTE_DIGITAL_LABEL_A = "zte_digital_label_A";
    private static final String ZTE_DIGITAL_LABEL_B = "zte_digital_label_B";

    public SettingsSecureUtils() {
    }

    static {
        HashMap r0 = new HashMap();
        AUTHORIZED_6939_PACKAGES = r0;
        r0.put("cuuca.sendfiles.Activity", "D9731DBEFDC00B288CBF7A36126B0AC1A8ADE04B39E28545EB96714074443E19");
        r0.put("com.zte.cloud", "D9731DBEFDC00B288CBF7A36126B0AC1A8ADE04B39E28545EB96714074443E19");
        r0.put("cn.nubia.flycow", "BD94126D9AC1A4E5F1017B70F0414C040AB7800C781E60AE452A33C71080CDE6");
        r0.put("cn.nubia.cloud", "BD94126D9AC1A4E5F1017B70F0414C040AB7800C781E60AE452A33C71080CDE6");
    }

    public static boolean isRightUser(Context r7) {
        if (r7 == null) goto L11;
        String[] r2 = r7.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L11;
        if (checkPackageIsAuthorized(r7, r2[r4], Binder.getCallingUid()) == true) goto L8;
        r4 = r4 + 1;
        goto L5
    L8:
        return true;
    L11:
        if (Binder.getCallingUid() != Process.myUid()) goto L13;
        return true;
    L13:
        return false;
    }

    public static final String getCursorString(Cursor r3, String r4) {
        if (r3 != null) goto L5;
        return "";
    L5:
        if (r3.getColumnIndex(r4) == (-1)) goto L13;
        String r5 = r3.getString(r3.getColumnIndex(r4));
        if (r5 != null) goto L11;
        return "";
    L11:
        return r5;
    L13:
        return "";
    }

    public static final long getCursorLong(Cursor r2, String r3) {
        if (r2 != null) goto L4;
        return -1;
    L4:
        if (r2.getColumnIndex(r3) != (-1)) goto L7;
        return -1;
    L7:
        return r2.getLong(r2.getColumnIndex(r3));
    }

    private static boolean checkPackageIsAuthorized(Context r5, String r6, int r7) {
        String r0 = AUTHORIZED_6939_PACKAGES.get(r6);
        if (r0 != null) goto L5;
        return false;
    L5:
        byte[] r2 = hexStringToByteArray(r0);
        if (r2 != null) goto L25;
        Log.w(TAG, "zbackup invalid hash code:" + r0);
        return false;
    L25:
        PackageInfo r8 = r5.getPackageManager().getPackageInfoAsUser(r6, 64, UserHandle.getUserId(r7));     // Catch: Throwable -> L22
        if (r8.signatures != null) goto L15;
        Log.w(TAG, "zbackup " + r6 + " signatures is null");     // Catch: Throwable -> L22 Throwable -> L22
        return false;
    L15:
        if (r8.signatures.length <= 1) goto L19;
        Log.w(TAG, "zbackup " + r6 + " signatures length=" + r8.signatures.length + " is over");     // Catch: Throwable -> L22 Throwable -> L22
        return false;
    L19:
        if (MessageDigest.isEqual(MessageDigest.getInstance("SHA-256").digest(r8.signatures[0].toByteArray()), r2) == true) goto L21;
        return false;
    L21:
        return true;
    L22:
        e = move-exception;
        Log.e(TAG, "zbackup check signature fail", e);
        return false;
    }

    private static byte[] hexStringToByteArray(String r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.isEmpty() == false) goto L6;
        return null;
    L6:
        if ((r5.length() % 2) != 0) goto L17;
        byte[] r0 = new byte[r5.length() / 2];
        int r1 = 0;
    L10:
        if (r1 >= r5.length()) goto L12;
        int r2 = (Character.digit(r5.charAt(r1), 16) << 4) + Character.digit(r5.charAt(r1 + 1), 16);
        r0[r1 / 2] = (byte) r2;
        r1 = r1 + 2;
        goto L10
    L12:
        return r0;
    L17:
        return null;
    }

    public static String getCertificationNum() {
        String r0 = getZteDigitalLabel(ZTE_DIGITAL_LABEL_A) + getZteDigitalLabel(ZTE_DIGITAL_LABEL_B);     // Catch: Exception -> L4
        String r1 = generateKeyFromModel();     // Catch: Exception -> L4
        return decryptWithIV(getSubstringFrom33rdKey(r1), getSubstringFromStartIsv(r1), r0);
    L4:
        e = move-exception;
        Log.e(TAG, "getCertificationNum: Exception " + e.toString());
        e.printStackTrace();
        return null;
    }

    private static String getZteDigitalLabel(String r9) {
        Class<?> r1 = Class.forName("com.zte.vendorconfig.VendorConfigManager");     // Catch: Exception -> L5
        Constructor<?> r3 = r1.getConstructor(new Class[0]);     // Catch: Exception -> L5
        r3.setAccessible(true);     // Catch: Exception -> L5
        return (String) r1.getDeclaredMethod("cfg_get", new Class[]{String.class, String.class}).invoke(r3.newInstance(new Object[0]), new Object[]{r9, "0"});
    L5:
        e = move-exception;
        Log.e(TAG, "getZteDigitalLabel: Exception for key " + r9, e);
        return "0";
    }

    private static String generateKeyFromModel() {
        String r0 = Build.MODEL;
        if (r0 != null) goto L5;
    L7:
        return "no key";
    L5:
        if (r0.isEmpty() == true) goto L7;
        return sha256(r0);
    }

    private static String sha256(String r6) {
        byte[] r7 = MessageDigest.getInstance("SHA-256").digest(r6.getBytes());     // Catch: NoSuchAlgorithmException -> L10
        StringBuilder r0 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L10
        int r1 = r7.length;     // Catch: NoSuchAlgorithmException -> L10
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        String r3 = Integer.toHexString(r7[r2] & 255);     // Catch: NoSuchAlgorithmException -> L10
        if (r3.length() != 1) goto L7;
        r0.append('0');     // Catch: NoSuchAlgorithmException -> L10
    L7:
        r0.append(r3);     // Catch: NoSuchAlgorithmException -> L10
        r2 = r2 + 1;     // Catch: NoSuchAlgorithmException -> L10
        goto L3
    L8:
        return r0.toString();
    L10:
        e = move-exception;
        Log.e(TAG, "sha256: NoSuchAlgorithmException", e);
        e.printStackTrace();
        return null;
    }

    private static String getSubstringFrom33rdKey(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.length() >= 49) goto L6;
        return null;
    L6:
        return r2.substring(32, 48);
    }

    private static String getSubstringFromStartIsv(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.length() >= 16) goto L6;
        return null;
    L6:
        return r2.substring(0, 16);
    }

    private static String decryptWithIV(String r2, String r3, String r4) {
        SecretKeySpec r0 = new SecretKeySpec(r2.getBytes(), "AES");     // Catch: Exception -> L4
        IvParameterSpec r5 = new IvParameterSpec(r3.getBytes());     // Catch: Exception -> L4
        Cipher r6 = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");     // Catch: Exception -> L4
        r6.init(2, r0, r5);     // Catch: Exception -> L4
        return new String(r6.doFinal(Base64.decode(r4, 0)));
    L4:
        e = move-exception;
        Log.e(TAG, "decryptWithIV: Exception", e);
        e.printStackTrace();
        return null;
    }
}
