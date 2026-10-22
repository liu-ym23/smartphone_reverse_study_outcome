package com.bytedance.bdinstall.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.ISstInfoProvider;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.SstInfoCompat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SensitiveUtils {
    private static final String ID_TYPE_IMEI = "imei";
    private static final String ID_TYPE_MEID = "meid";
    private static final String ID_TYPE_UNKNOWN = "unknown";
    private static final Singleton<String> sDeviceId = null;
    private static final Singleton<String> sWifiMacAddress = null;

    public SensitiveUtils() {
    }

    static /* synthetic */ String access$000(Context r0, InstallOptions r1) {
        return getDefaultImeiOrMeid(r0, r1);
    }

    private static String getDefaultImeiOrMeid(Context r1, InstallOptions r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r2 == null) goto L9;
        if (r2.isCheckPermissionBeforeCallSensitiveApi() == true) goto L9;
    L11:
        ISstInfoProvider r3 = SstInfoCompat.getProvider();
        if (r3 != null) goto L14;
        return null;
    L14:
        return r3.getDefaultImeiOrMeid(r1);
    L9:
        if (InstallPmsUtils.checkReadPhoneStatePermission(r1) == true) goto L11;
        return null;
    }

    static {
        sDeviceId = new AnonymousClass1();
        sWifiMacAddress = new AnonymousClass2();
    }

    public static String getDeviceIdWithCache(Context r3, InstallOptions r4) {
        return sDeviceId.get(new Object[]{r3, r4});
    }

    public static String[] getSimSerialNumbers(Context r2, InstallOptions r3) {
        if (r2 == null) goto L20;
        if (RomUtils.isAndroidROrHigher() == true) goto L20;
        if (r3 == null) goto L10;
        if (r3.isCheckPermissionBeforeCallSensitiveApi() == true) goto L10;
    L12:
        ISstInfoProvider r4 = SstInfoCompat.getProvider();
        if (r4 == null) goto L18;
        String[] r5 = r4.getSimSerialNumbers(r2);
        if (r5 == null) goto L18;
        return r5;
    L18:
        return new String[0];
    L10:
        if (InstallPmsUtils.checkReadPhoneStatePermission(r2) == true) goto L12;
    L20:
        return new String[0];
    }

    public static JSONArray getMultiImei(Context r7, InstallOptions r8) {
        JSONArray r3 = new JSONArray();
        if (r8 == null) goto L7;
        if (r8.isCheckPermissionBeforeCallSensitiveApi() == true) goto L7;
    L9:
        String r4 = null;
        ISstInfoProvider r5 = SstInfoCompat.getProvider();     // Catch: Throwable -> L16 Exception -> L18
        if (r5 == null) goto L13;
        String r6 = r5.getMeid(r7, 0);     // Catch: Throwable -> L16 Exception -> L18
    L14:
        r3.put(createJsonObjForId(r6, 0, "meid"));     // Catch: Throwable -> L16 Exception -> L18
    L65:
        ISstInfoProvider r9 = SstInfoCompat.getProvider();     // Catch: Throwable -> L16 Exception -> L30
        if (r9 == null) goto L27;
        String r10 = r9.getMeid(r7, 1);     // Catch: Throwable -> L16 Exception -> L30
    L28:
        r3.put(createJsonObjForId(r10, 1, "meid"));     // Catch: Throwable -> L16 Exception -> L30
    L63:
        ISstInfoProvider r1 = SstInfoCompat.getProvider();     // Catch: Throwable -> L16 Exception -> L41
        if (r1 == null) goto L38;
        String r2 = r1.getImei(r7, 0);     // Catch: Throwable -> L16 Exception -> L41
    L39:
        r3.put(createJsonObjForId(r2, 0, "imei"));     // Catch: Throwable -> L16 Exception -> L41
    L68:
        ISstInfoProvider r11 = SstInfoCompat.getProvider();     // Catch: Throwable -> L16 Exception -> L51
        if (r11 == null) goto L49;
        r4 = r11.getImei(r7, 1);     // Catch: Throwable -> L16 Exception -> L51
    L49:
        r3.put(createJsonObjForId(r4, 1, "imei"));     // Catch: Throwable -> L16 Exception -> L51
    L61:
        return r3;
    L51:
        e = move-exception;
        if ((e instanceof SecurityException) == false) goto L55;
        DrLog.e("读取imei没有权限");     // Catch: Throwable -> L16
        goto L61
    L55:
        e.printStackTrace();     // Catch: Throwable -> L16
        goto L61
    L38:
        r2 = null;
    L41:
        e = move-exception;
        if ((e instanceof SecurityException) == false) goto L45;
        DrLog.e("读取imei没有权限");     // Catch: Throwable -> L16
        goto L68
    L45:
        e.printStackTrace();     // Catch: Throwable -> L16
        goto L68
    L27:
        r10 = null;
    L30:
        e = move-exception;
        if ((e instanceof SecurityException) == false) goto L34;
        DrLog.e("读取imei没有权限");     // Catch: Throwable -> L16
        goto L63
    L34:
        e.printStackTrace();     // Catch: Throwable -> L16
        goto L63
    L13:
        r6 = null;
    L16:
        th = move-exception;
        if ((th instanceof SecurityException) == false) goto L60;
        DrLog.e("读取imei没有权限");
        goto L61
    L60:
        th.printStackTrace();
    L18:
        e = move-exception;
        if ((e instanceof SecurityException) == false) goto L22;
        DrLog.e("读取imei没有权限");     // Catch: Throwable -> L16
        goto L65
    L22:
        e.printStackTrace();     // Catch: Throwable -> L16
    L7:
        if (InstallPmsUtils.checkReadPhoneStatePermission(r7) == true) goto L9;
        return r3;
    }

    private static JSONObject createJsonObjForId(String r2, int r3, String r4) throws JSONException {
        JSONObject r0 = new JSONObject();
        if (TextUtils.isEmpty(r2) == true) goto L5;
        r0.put("id", r2);
        r0.put("slot_index", r3);
        r0.put("type", r4);
    L5:
        return r0;
    }

    public static String getSerialNumber(Context r3, InstallOptions r4) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.getApplicationInfo().targetSdkVersion < 26) goto L14;
        if (r4 == null) goto L11;
        if (r4.isCheckPermissionBeforeCallSensitiveApi() == false) goto L14;
    L11:
        if (InstallPmsUtils.checkReadPhoneStatePermission(r3) == true) goto L14;
        return null;
    L14:
        return SstInfoCompat.getProvider().getSerial(r3);
    }

    public static String getMacAddress(Context r3) {
        return sWifiMacAddress.get(new Object[]{r3});
    }
}
