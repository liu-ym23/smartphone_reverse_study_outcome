package com.android.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.obric.olog.OLog;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
public class AppLockUtil {
    private static final String ACCOUNT_IS_LOGIN = "request_account_islogin";
    public static final String ACTION_APP_LOCK_SETTING = "com.bytedanceos.action.APP_LOCK_SETTING";
    public static final String ACTION_PRIVACY_SECURITY = "com.bytedanceos.action.PRIVACY_SECURITY";
    private static final String APP_LOCK_ENCRYPT_PREFIX = "app_lock_encrypt_prefix";
    private static final String APP_LOCK_KEY = "app_lock_key";
    public static final Charset ASCII = null;
    public static final String CHANGE_APPLICATION_LOCK_PASSWORD = "change_password";
    public static final String CHANGE_PLATE_LOCK_PASSWORD = "change_plate_lock_password";
    public static final String CHOOSE_LOCK_PASSWORD_ACTION = "com.bytedanceos.action.CHOOSE_LOCK_PASSWORD";
    public static final String CHOOSE_LOCK_PASSWORD_ERROR_CODE = "choose_lock_password_error_code";
    private static final String CLOUD_URI = "content://com.bytedanceos.cloudsync.accountcenter";
    public static final String DESKTOP_PACKAGE_NAME = "com.bytedanceos.desktop";
    public static final String ENCODE_MD5 = "MD5";
    public static final String ENCODE_SHA = "SHA-1";
    public static final String EXIT_SMILING_CLOUD = "exit_smiling_cloud";
    public static final String FROM_BYTEDANCEOS_LAUNCHPAD = "from_bytedanceos_launchpad";
    private static final String KEY_FIND_PASSWORD_ANSWER = "find_password_answer";
    private static final String KEY_SELECTED_QUESTION = "selected_question";
    private static final String LAUNCHER_APP_LOCK_KEY = "launcher_app_lock_key";
    public static final String PACKAGE_NAME = "com.bytedanceos.securitycenter";
    public static final int RESULT_CANCEL = 0;
    private static final String RESULT_LOGIN_KEY = "result";
    public static final int RESULT_SUCCESS = -1;
    public static final Charset UTF_8 = null;
    private static String encryptedKey;
    private static String sAppLockPwd;

    public AppLockUtil() {
    }

    static {
        UTF_8 = Charset.forName("UTF-8");
        ASCII = Charset.forName("US-ASCII");
    }

    private static byte[] encode(Charset r0, String r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        ByteBuffer r2 = r0.encode(CharBuffer.wrap(r1));
        byte[] r3 = new byte[r2.limit()];
        r2.get(r3);
        return r3;
    }

    public static byte[] toUtf8(String r1) {
        return encode(UTF_8, r1);
    }

    public static String getSmallHash(String r1) {
        MessageDigest r0 = MessageDigest.getInstance("SHA-1");     // Catch: NoSuchAlgorithmException -> L5
        r0.update(toUtf8(r1));
        return Integer.toString(getSmallHashFromSha1(r0.digest()));
    L5:
        return null;
    }

    public static boolean isLocked(Context r2) {
        String r3 = getEncryptedPassword(r2);
        OLog.d("encode", "code:[" + r3 + "]");
        return !TextUtils.isEmpty(r3);
    }

    public static boolean checkPassword(Context r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        String r4 = encryptLauncherAppLockPassword(r3);
        if (r4 != null) goto L9;
        return false;
    L9:
        return r4.equals(getEncryptedPassword(r2));
    }

    public static void clearAppLockPassword(Context r2) {
        String r0 = getLauncherAppLockKey();
        if (r2.getContentResolver() == null) goto L6;
        android.provider.Settings.Secure.putString(r2.getContentResolver(), r0, null);
        return;
    }

    public static boolean saveAppLockPassword(Context r1, String r2) {
        String r0 = getLauncherAppLockKey();
        String r3 = encryptLauncherAppLockPassword(r2);
        if (r3 != null) goto L7;
        return false;
    L7:
        return android.provider.Settings.Secure.putString(r1.getContentResolver(), r0, r3);
    }

    public static String getEncryptedPassword(Context r1) {
        return android.provider.Settings.Secure.getString(r1.getContentResolver(), getLauncherAppLockKey());
    }

    public static String getLauncherAppLockKey() {
        if (encryptedKey != null) goto L6;
        encryptedKey = encryptAppLockKey(LAUNCHER_APP_LOCK_KEY);
    L6:
        return encryptedKey;
    }

    private static String encryptAppLockKey(String r1) {
        return encrypt(r1, "SHA-1");
    }

    public static String encryptLauncherAppLockPassword(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        return encrypt(getSmallHash(APP_LOCK_ENCRYPT_PREFIX + r2), "MD5");
    }

    public static String getAppLockPassword(Context r3) {
        int r0 = 0;
    L4:
        if (r0 >= 10000) goto L20;
        if (r0 >= 10) goto L9;
        String r1 = "000";
    L16:
        if (checkPassword(r3, r1 + r0) == true) goto L18;
        r0 = r0 + 1;
        goto L4
    L18:
        return r1 + r0;
    L9:
        if (r0 >= 100) goto L12;
        r1 = "00";
        goto L16
    L12:
        if (r0 >= 1000) goto L14;
        r1 = "0";
        goto L16
    L14:
        r1 = "";
        goto L16
    L20:
        return null;
    }

    public static String encrypt(String r1, String r2) {
        MessageDigest r3 = MessageDigest.getInstance(r2);     // Catch: NoSuchAlgorithmException -> L4
        r3.reset();     // Catch: NoSuchAlgorithmException -> L4
        r3.update(r1.getBytes());     // Catch: NoSuchAlgorithmException -> L4
        return byte2hex(r3.digest());
    L4:
        e = move-exception;
        e.printStackTrace();
        return r1;
    }

    private static String byte2hex(byte[] r4) {
        StringBuffer r0 = new StringBuffer();
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L11;
        if (Integer.toHexString(r4[r1] & 255).length() != 1) goto L8;
        r0.append("0").append(Integer.toHexString(r4[r1] & 255));
    L9:
        r1 = r1 + 1;
        goto L4
    L8:
        r0.append(Integer.toHexString(r4[r1] & 255));
        goto L9
    L11:
        return r0.toString();
    }

    static int getSmallHashFromSha1(byte[] r3) {
        int r0 = r3[19] & 15;
        int r1 = (((r3[r0] & 127) << 24) | ((r3[r0 + 1] & 255) << 16)) | ((r3[r0 + 2] & 255) << 8);
        return (r3[r0 + 3] & 255) | r1;
    }

    @Deprecated
    public static void saveSelectedQuestion(Context r1, String r2) {
        android.provider.Settings.Global.putString(r1.getContentResolver(), KEY_SELECTED_QUESTION, r2);
    }

    public static void saveSelectedQuestion(Context r1, int r2) {
        android.provider.Settings.Global.putInt(r1.getContentResolver(), KEY_SELECTED_QUESTION, r2);
    }

    public static String getSelectedQuestion(Context r3) {
        String r0 = android.provider.Settings.Global.getString(r3.getContentResolver(), KEY_SELECTED_QUESTION);
        if (TextUtils.isEmpty(r0) == false) goto L13;
        return null;
    L13:
        int r1 = Integer.parseInt(r0);     // Catch: NumberFormatException -> L8
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        return r0;
    L11:
        return r3.getResources().getStringArray(R.array.find_password_questions)[r1];
    L8:
        r1 = 0;
        r2 = false;
        goto L9
    }

    public static void saveAnswer(Context r2, String r3) {
        String r0 = encrypt(KEY_FIND_PASSWORD_ANSWER, "SHA-1");
        String r4 = encrypt(r3, "SHA-1");
        android.provider.Settings.Secure.putString(r2.getContentResolver(), r0, r4);
    }

    public static boolean checkAnswer(Context r2, String r3) {
        String r0 = encrypt(KEY_FIND_PASSWORD_ANSWER, "SHA-1");
        return encrypt(r3, "SHA-1").equals(android.provider.Settings.Secure.getString(r2.getContentResolver(), r0));
    }

    public static boolean checkMd5Password(Context r1, String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        String r3 = encrypt(r2, "MD5");
        return PrivacySecurity.getInstance(r1).checkPassword(r3);
    }

    public static void saveAppLockPwd(Context r0, String r1) {
        sAppLockPwd = encryptAppLockPassword(r1);
    }

    private static String encryptAppLockPassword(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return null;
    L7:
        return encrypt(r1, "MD5");
    }

    private static String getAppLockKey() {
        if (encryptedKey != null) goto L6;
        encryptedKey = encryptAppLockKey(APP_LOCK_KEY);
    L6:
        return encryptedKey;
    }

    public static String getAppLockEncryptPwd(Context r0) {
        return sAppLockPwd;
    }

    public static boolean isSmilingCloudLogin(Context r4) {
        Uri r0 = Uri.parse(CLOUD_URI);
        Bundle r5 = r4.getContentResolver().call(r0, ACCOUNT_IS_LOGIN, null, null);     // Catch: IllegalArgumentException -> L7
        if (r5 == null) goto L12;
        return r5.getBoolean("result");
    L12:
        return false;
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static void clearPlatLock(Context r1) {
        if (isLocked(r1) == false) goto L6;
        clearAppLockPassword(r1);
        return;
    }

    public static void setPrivacyPassword(Context r0, boolean r1) {
        PrivacySecurity.getInstance(r0).isSecurityOn();
    }

    public static boolean isPrivacyPasswordSet(ContentResolver r2) {
        if (android.provider.Settings.Secure.getInt(r2, "security_privacy", 0) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static void sendPwdErrCodeBroadcast(Context r1, boolean r2, int r3) {
        if (r2 == false) goto L5;
        Intent r4 = new Intent();
        r4.setAction(CHOOSE_LOCK_PASSWORD_ACTION);
        r4.putExtra(CHOOSE_LOCK_PASSWORD_ERROR_CODE, r3);
        r4.setPackage("com.bytedanceos.desktop");
        r1.sendBroadcast(r4);
        return;
    }
}
