package com.android.settings.wifi;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.os.Environment;
import android.text.TextUtils;
import com.obric.olog.OLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class WifiAuthorizeUtils {
    private static final int AES_IV_FILE_LENGTH = 16;
    private static final String AES_IV_FILE_NAME = "AES_IV";
    private static final int AES_SALT_FILE_LENGTH = 32;
    private static final String AES_SALT_FILE_NAME = "AES_SALT";
    public static final String AUTHORITY = "com.android.wifiAuthorize";
    public static Uri AUTHORIZE_INFO_URI = null;
    public static final String AUTO_LOGIN = "auto_login";
    public static final String AUTO_LOGIN_HOST = "host";
    public static final String AUTO_LOGIN_OFF = "off";
    public static final String AUTO_LOGIN_ON = "on";
    public static final String CLASS_NAME = "com.android.wifiauthorize.WifiAuthorizeActivity";
    private static final String DATABASE_FILE_NAME = "aw_password.db";
    private static final String DATABASE_SQL_QUERY_ALL = "select * from save_password";
    private static final boolean DEBUG = true;
    public static final String EXTRA_NAME_IP_ADDRESS = "ip_address";
    public static final String EXTRA_NAME_SSID = "ssid";
    public static final String EXTRA_NAME_URL = "url";
    public static final String EXTRA_NAME_WIFI_CONFIG = "wifi_config";
    public static final int KEY_TYPE_HOST = 3;
    public static final int KEY_TYPE_SCRIPT = 1;
    public static final int KEY_TYPE_SWITCH = 2;
    private static final String OLD_DATABASE_FILE_NAME = "save_password.db";
    public static final String PACKAGE_NAME = "com.android.wifiauthorize";
    public static final String PREFERENCE_NAME = "WIFI_AUTHORIZE_INFO";
    public static Uri SAVE_PASSWORD_URI = null;
    public static final String TAG = "WifiAutoLogin";

    public static int moveDatabase2ProviderForOta(Context r0) {
        return 0;
    }

    public WifiAuthorizeUtils() {
    }

    static {
        AUTHORIZE_INFO_URI = Uri.parse("content://com.android.wifiAuthorize/authorize_info");
        SAVE_PASSWORD_URI = Uri.parse("content://com.android.wifiAuthorize/save_password");
    }

    public static void saveToSharedPreferences(Context r2, WifiConfiguration r3, String r4, int r5) {
        if (TextUtils.isEmpty(r4) == true) goto L7;
        if (r2 == null) goto L7;
        if (r3 == null) goto L7;
        String r6 = configKey(r3, r5);
        OLog.d(TAG, "saveToSharedPreferences: key: " + r6 + " value: " + r4);
        ContentResolver r7 = r2.getContentResolver();
        ContentValues r8 = new ContentValues();
        r8.put("key", r6);
        r8.put("value", r4);
        r7.insert(AUTHORIZE_INFO_URI, r8);
        return;
    L7:
        OLog.e(TAG, "saveToSharedPreferences: value null");
    }

    public static void removeFromSharedPreferences(Context r6, String r7) {
        if (TextUtils.isEmpty(r7) == false) goto L5;
        return;
    L5:
        ContentResolver r8 = r6.getContentResolver();
        r8.delete(AUTHORIZE_INFO_URI, "key=?", new String[]{r7});
        r8.delete(AUTHORIZE_INFO_URI, "key=?", new String[]{getAutoLoginHostKey(r7)});
        r8.delete(AUTHORIZE_INFO_URI, "key=?", new String[]{getAutoLoginKey(r7)});
    }

    public static String getLoginScript(Context r8, String r9) {
        String r1 = null;
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return null;
    L5:
        Cursor r10 = r8.getContentResolver().query(AUTHORIZE_INFO_URI, new String[]{"value"}, "key=?", new String[]{r9}, null);
        if (r10 != null) goto L9;
        return null;
    L9:
        if (r10.getCount() > 0) goto L11;
    L13:
        r10.close();
        OLog.d(TAG, "getLoginScript: value: " + r1);
        return r1;
    L11:
        if (r10.moveToFirst() == false) goto L13;
        r1 = r10.getString(r10.getColumnIndex("value"));
        goto L13
    }

    public static String getAutoLoginHost(Context r8, String r9) {
        String r1 = null;
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return null;
    L5:
        Cursor r10 = r8.getContentResolver().query(AUTHORIZE_INFO_URI, new String[]{"value"}, "key=?", new String[]{getAutoLoginHostKey(r9)}, null);
        if (r10 != null) goto L9;
        return null;
    L9:
        if (r10.getCount() > 0) goto L11;
    L13:
        r10.close();
        OLog.d(TAG, "getAutoLoginHost: value: " + r1);
        return r1;
    L11:
        if (r10.moveToFirst() == false) goto L13;
        r1 = r10.getString(r10.getColumnIndex("value"));
        goto L13
    }

    public static boolean autoLoginEnabled(Context r8, String r9) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return false;
    L5:
        Cursor r10 = r8.getContentResolver().query(AUTHORIZE_INFO_URI, new String[]{"value"}, "key=?", new String[]{getAutoLoginKey(r9)}, null);
        if (r10 != null) goto L9;
        return false;
    L9:
        if (r10.getCount() > 0) goto L11;
    L13:
        String r11 = null;
    L14:
        r10.close();
        OLog.d(TAG, "login switch: value: " + r11);
        if (TextUtils.isEmpty(r11) == false) goto L17;
    L19:
        return false;
    L17:
        if ("on".equals(r11) == false) goto L19;
        return true;
    L11:
        if (r10.moveToFirst() == false) goto L13;
        r11 = r10.getString(r10.getColumnIndex("value"));
        goto L14
    }

    public static boolean checkSavedLoginInfo(Context r8, String r9) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return false;
    L5:
        Cursor r10 = r8.getContentResolver().query(SAVE_PASSWORD_URI, null, "host=?", new String[]{r9}, null);
        if (r10 != null) goto L8;
        return false;
    L8:
        int r0 = r10.getCount();
        r10.close();
        OLog.d(TAG, "checkSavedLoginInfo: count: " + r0);
        if (r0 <= 0) goto L11;
        return true;
    L11:
        return false;
    }

    public static String configKey(WifiConfiguration r7, int r8) {
        boolean r1 = true;
        if (r7.allowedKeyManagement.get(1) == false) goto L6;
        String r9 = r7.SSID + ":" + WifiConfiguration.KeyMgmt.strings[1];
    L22:
        if (r8 == 2) goto L27;
        if (r8 == 3) goto L30;
        return r9;
    L30:
        return getAutoLoginHostKey(r9);
    L27:
        return getAutoLoginKey(r9);
    L6:
        if (r7.allowedKeyManagement.get(2) == false) goto L8;
    L21:
        r9 = r7.SSID + ":" + WifiConfiguration.KeyMgmt.strings[2];
        goto L22
    L8:
        if (r7.allowedKeyManagement.get(3) == true) goto L21;
        int r5 = 0;
    L12:
        if (r5 >= r7.wepKeys.length) goto L17;
        if (r7.wepKeys[r5] != null) goto L18;
        r5 = r5 + 1;
    L18:
        if (r1 == false) goto L20;
        r9 = r7.SSID + ":WEP";
        goto L22
    L20:
        r9 = r7.SSID + ":" + WifiConfiguration.KeyMgmt.strings[0];
        goto L22
    L17:
        r1 = false;
        goto L18
    }

    public static boolean deleteDatabaseForOta(Context r2) {
        File r0 = r2.getDatabasePath(OLD_DATABASE_FILE_NAME);     // Catch: Exception -> L10
        if (r0.exists() == false) goto L5;
        SQLiteDatabase.deleteDatabase(r0);     // Catch: Exception -> L10
    L5:
        File r3 = r2.getDatabasePath(DATABASE_FILE_NAME);     // Catch: Exception -> L10
        if (r3.exists() == false) goto L15;
        SQLiteDatabase.deleteDatabase(r3);     // Catch: Exception -> L10
        return true;
    L15:
        return true;
    L10:
        e = move-exception;
        OLog.e(TAG, e.toString());
        return false;
    }

    public static int movePreferenceData2ProviderForOta(Context r7) {
        ContentResolver r0 = r7.getContentResolver();
        int r2 = 0;
        SharedPreferences r8 = r7.getSharedPreferences(PREFERENCE_NAME, 0);
        Iterator<String> r1 = r8.getAll().keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        String r3 = r1.next();
        String r4 = r8.getString(r3, null);
        if (r4 == null) goto L4;
        ContentValues r5 = new ContentValues();
        r5.put("key", r3);
        r5.put("value", r4);
        r0.insert(AUTHORIZE_INFO_URI, r5);
        r2 = r2 + 1;
        goto L4
    L9:
        return r2;
    }

    public static boolean deleteSharePreferenceForOta(Context r3) {
        SharedPreferences r4 = r3.getSharedPreferences(PREFERENCE_NAME, 0);
        SharedPreferences.Editor r0 = r4.edit();
        Iterator<String> r5 = r4.getAll().keySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        String r1 = r5.next();
        r0.remove(r1);
        r0.remove(getAutoLoginKey(r1));
        r0.remove(getAutoLoginHostKey(r1));
        r0.apply();
        goto L4
    L6:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context] */
    private static void readBytesFromFile(Context r3, String r4, byte[] r5) {
        ?? r2 = Environment.DIRECTORY_DOWNLOADS;
        FileInputStream r6 = new FileInputStream(new File(r3.getExternalFilesDir(r2), r4));     // Catch: Throwable -> L18 IOException -> L20 FileNotFoundException -> L24
        int r7 = 0;
    L46:
    L16:
        FileNotFoundException e = e;
    L26:
        e.printStackTrace();     // Catch: Throwable -> L33
        if (r6 == null) goto L52;
        r6.close();     // Catch: IOException -> L30
    L43:
        return;
    L52:
        return;
    L14:
        IOException e2 = e;
    L22:
        e2.printStackTrace();     // Catch: Throwable -> L33
        throw new RuntimeException("Couldn't read from " + r4, e2);     // Catch: Throwable -> L33
    L6:
        if (r7 >= r5.length) goto L12;
        int r1 = r6.read(r5, r7, r5.length - r7);     // Catch: IOException -> L14 FileNotFoundException -> L16 Throwable -> L33
        if (r1 <= 0) goto L11;
        r7 = r7 + r1;     // Catch: IOException -> L14 FileNotFoundException -> L16 Throwable -> L33
        goto L46
    L11:
        throw new RuntimeException("Couldn't read from " + r4);     // Catch: IOException -> L14 FileNotFoundException -> L16 Throwable -> L33
    L12:
        r6.close();     // Catch: IOException -> L30
        goto L43
    L33:
        Throwable th = th;
    L34:
        if (r2 != 0) goto L40;
    L39:
        throw th;
    L40:
        r2.close();     // Catch: IOException -> L37
    L37:
        e = move-exception;
        e.printStackTrace();
    L24:
        e = move-exception;
        r6 = null;
        e = e;
    L20:
        e = move-exception;
        e2 = e;
    L18:
        th = move-exception;
        r2 = 0;
        th = th;
    L30:
        e = move-exception;
        e.printStackTrace();
    }

    private static String getAutoLoginKey(String r1) {
        return r1 + AUTO_LOGIN;
    }

    private static String getAutoLoginHostKey(String r1) {
        return r1 + AUTO_LOGIN_HOST;
    }

    private static SQLiteDatabase openDatabase(Context r3) {
        File r1 = r3.getDatabasePath(OLD_DATABASE_FILE_NAME);     // Catch: Exception -> L13
        if (r1.exists() == false) goto L8;
        SQLiteDatabase r2 = SQLiteDatabase.openOrCreateDatabase(r1, null);     // Catch: Exception -> L13
        if (r2 == null) goto L8;
        return r2;
    L8:
        File r4 = r3.getDatabasePath(DATABASE_FILE_NAME);     // Catch: Exception -> L13
        if (r4.exists() == false) goto L12;
        return SQLiteDatabase.openOrCreateDatabase(r4, null);
    L12:
        return null;
    }
}
