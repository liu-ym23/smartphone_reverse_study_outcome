package com.bytedance.bdinstall;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class Api {
    private static final String[] KEYS_PLAINTEXT = null;
    public static final String KEY_AB_VERSION = "ab_version";
    public static final String KEY_ACCESS = "access";
    public static final String KEY_AID = "aid";
    public static final String KEY_APPKEY = "appkey";
    public static final String KEY_APP_LANGUAGE = "app_language";
    public static final String KEY_APP_NAME = "app_name";
    public static final String KEY_APP_REGION = "app_region";
    public static final String KEY_APP_TRACK = "app_track";
    public static final String KEY_APP_VERSION = "app_version";
    public static final String KEY_APP_VERSION_MINOR = "app_version_minor";
    public static final String KEY_BD_DID = "bd_did";
    public static final String KEY_CARRIER = "carrier";
    public static final String KEY_CD = "cd";
    public static final String KEY_CHANNEL = "channel";
    public static final String KEY_CLEAR_KEY_PREFIX = "clear_key_prefix";
    public static final String KEY_CPU_ABI = "cpu_abi";
    public static final String KEY_CUSTOM = "custom";
    public static final String KEY_C_UDID = "clientudid";
    public static final String KEY_DENSITY_DPI = "density_dpi";
    public static final String KEY_DEVICE_BRAND = "device_brand";
    public static final String KEY_DEVICE_ID = "device_id";
    public static final String KEY_DEVICE_MANUFACTURER = "device_manufacturer";
    public static final String KEY_DEVICE_MODEL = "device_model";
    public static final String KEY_DEVICE_TOKEN = "device_token";
    public static final String KEY_DISPLAY_DENSITY = "display_density";
    public static final String KEY_DISPLAY_NAME = "display_name";
    public static final String KEY_EXTERNAL_DERECTORY_DEVICE_PARAMETER = "ZQLiNFJR+CWEI4px";
    public static final String KEY_GOOGLE_AID = "google_aid";
    public static final String KEY_GOOGLE_AID_LIMIT = "gaid_limited";
    public static final String KEY_HEADER = "header";
    public static final String KEY_HTTP_CODE = "HttpCode";
    public static final String KEY_INSTALL_ID = "install_id";
    public static final String KEY_LANGUAGE = "language";
    public static final String KEY_MAGIC = "magic_tag";
    public static final String KEY_MANIFEST_VERSION_CODE = "manifest_version_code";
    public static final String KEY_MCC_MNC = "mcc_mnc";
    private static final String KEY_MSG = "message";
    public static final String KEY_NEW_USER_MODE = "new_user_mode";
    public static final String KEY_NOT_REQUEST_SENDER = "not_request_sender";
    public static final String KEY_OLD_DID = "old_did";
    public static final String KEY_OPEN_UDID = "openudid";
    public static final String KEY_OS = "os";
    public static final String KEY_OS_API = "os_api";
    public static final String KEY_OS_VERSION = "os_version";
    public static final String KEY_PACKAGE = "package";
    public static final String KEY_PICO_SN = "pico_sn";
    public static final String KEY_REAL_PACKAGE_NAME = "real_package_name";
    public static final String KEY_REGION = "region";
    public static final String KEY_REGISTER_TIME = "register_time";
    public static final String KEY_RELEASE_BUILD = "release_build";
    public static final String KEY_RESOLUTION = "resolution";
    public static final String KEY_ROM = "rom";
    public static final String KEY_ROM_VERSION = "rom_version";
    public static final String KEY_SDK_TARGET_VERSION = "sdk_target_version";
    public static final String KEY_SDK_VERSION = "sdk_version";
    public static final String KEY_SDK_VERSION_CODE = "sdk_version_code";
    public static final String KEY_SET_COOKIE = "Set-Cookie";
    public static final String KEY_SIG_HASH = "sig_hash";
    public static final String KEY_SIM_REGION = "sim_region";
    public static final String KEY_SSID = "ssid";
    public static final String KEY_STARTED = "_install_started_v2";
    public static final String KEY_TIMEZONE = "timezone";
    private static final String KEY_TT_DATA = "tt_data";
    private static final String KEY_TT_INFO = "tt_info";
    public static final String KEY_TWEAKED_CHANNEL = "tweaked_channel";
    public static final String KEY_TZ_NAME = "tz_name";
    public static final String KEY_TZ_OFFSET = "tz_offset";
    public static final String KEY_UPDATE_VERSION_CODE = "update_version_code";
    public static final String KEY_USER_AGENT = "user_agent";
    public static final String KEY_USER_UNIQUE_ID = "user_unique_id";
    public static final String KEY_VERSION_CODE = "version_code";
    public static final String MSG_MAGIC = "ss_app_log";
    private static final String MSG_OK = "success";
    public static final String REQ_ID = "req_id";

    public Api() {
    }

    static JSONObject register(INetworkClient r1, String r2, JSONObject r3, boolean r4, IEncryptor r5, boolean r6) {
        HashMap<String, String> r7 = getHeaders(r4, r6);
        byte[] r8 = transformStrToByte(r3.toString(), r4, r5);     // Catch: Exception -> L9
        if (r8 == null) goto L7;
        if (r4 == false) goto L7;
        r2 = r2 + "&tt_data=a";     // Catch: Exception -> L9
    L7:
        String r9 = r1.post(r2, r8, r7);     // Catch: Exception -> L9
    L11:
        if (r9 == null) goto L21;
        return new JSONObject(r9);
    L14:
        e = move-exception;
        DrLog.e("Register#doRegister parse json error " + r9 + ", " + e);
        e.printStackTrace();
        return null;
    L21:
        return null;
    L9:
        e = move-exception;
        DrLog.e("Register#doRegister http error = " + e);
        e.printStackTrace();
        r9 = null;
        goto L11
    }

    static {
        KEYS_PLAINTEXT = new String[]{"aid", "app_version", KEY_TT_DATA, "device_id", KEY_BD_DID};
    }

    private static String encryptUrl(String r8, boolean r9, IEncryptor r10) {
        if (TextUtils.isEmpty(r8) == true) goto L20;
        Uri r11 = Uri.parse(r8);
        String r0 = r11.getQuery();
        ArrayList r1 = new ArrayList();
        String[] r2 = KEYS_PLAINTEXT;
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L10;
        String r5 = r2[r4];
        String r6 = r11.getQueryParameter(r5);
        if (TextUtils.isEmpty(r6) == true) goto L9;
        r1.add(new Pair(r5, r6));
    L9:
        r4 = r4 + 1;
        goto L5
    L10:
        Uri.Builder r12 = r11.buildUpon();
        r12.clearQuery();
        Iterator r7 = r1.iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        Pair r13 = (Pair) r7.next();
        r12.appendQueryParameter((String) r13.first, (String) r13.second);
        goto L12
    L14:
        r12.appendQueryParameter(KEY_TT_INFO, new String(Base64.encode(transformStrToByte(r0, r9, r10), 8)));
        return r12.build().toString();
    L20:
        return r8;
    }

    static boolean active(INetworkClient r1, String r2, boolean r3, IEncryptor r4, boolean r5) {
        StringBuilder r0 = new StringBuilder(r2);
        HashMap<String, String> r6 = buildHeader(r5);
        JSONObject r7 = null;
        String r8 = r1.get(encryptUrl(r0.toString(), r3, r4), r6);     // Catch: Exception -> L5
    L7:
        if (r8 != null) goto L18;
    L12:
        if (r7 != null) goto L14;
    L16:
        return false;
    L14:
        if ("success".equals(r7.optString("message", "")) == false) goto L16;
        return true;
    L18:
        r7 = new JSONObject(r8);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        DrLog.e("Register#active parse json error " + r8 + ", " + e);
        e.printStackTrace();
    L5:
        e = move-exception;
        DrLog.e("Register#active http error = " + e);
        e.printStackTrace();
        r8 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static HashMap<String, String> buildHeader(final boolean r3) {
        HashMap<String, String> r0 = new HashMap();
        Pair<String, String> r4 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new AnonymousClass1(r3));     // Catch: Throwable -> L7
        if (r4 == null) goto L9;
        r0.put(r4.first, r4.second);     // Catch: Throwable -> L7
    L9:
        return r0;
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    private static byte[] transformStrToByte(String r4, boolean r5, IEncryptor r6) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r2 = null;
        if (r5 == false) goto L11;
        GZIPOutputStream r3 = new GZIPOutputStream(r0);     // Catch: Throwable -> L9
        r3.write(r4.getBytes("UTF-8"));     // Catch: Throwable -> L7
        r2 = r3;
    L12:
        if (r2 == null) goto L21;
        r2.close();     // Catch: IOException -> L19
    L33:
    L21:
        byte[] r7 = r0.toByteArray();
        if (r5 == false) goto L43;
        if (r6 != null) goto L25;
        return r7;
    L25:
        return r6.encrypt(r7, r7.length);
    L43:
        return r7;
    L7:
        th = th;
        r2 = r3;
    L36:
        DrLog.ysnp(th);     // Catch: Throwable -> L26
        if (r2 == null) goto L21;
        r2.close();     // Catch: IOException -> L19
    L26:
        th = move-exception;
        if (r2 != null) goto L40;
    L32:
        throw th;
    L40:
        r2.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        DrLog.ysnp(e);
        goto L32
    L11:
        r0.write(r4.getBytes("UTF-8"));     // Catch: Throwable -> L9
    L19:
        e = move-exception;
        DrLog.ysnp(e);
    L9:
        th = th;
        goto L36
    }

    static void addParams(StringBuilder r2, String r3, String r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        return;
    L9:
        if (r2.toString().indexOf(63) >= 0) goto L11;
        r2.append("?");
    L12:
        r2.append(r3).append("=").append(Uri.encode(r4));
        return;
    L11:
        r2.append("&");
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static HashMap<String, String> getHeaders(boolean r2, final boolean r3) {
        HashMap<String, String> r0 = new HashMap(2);
        if (r2 == false) goto L5;
        r0.put("Content-Type", "application/octet-stream;tt-data=a");
    L13:
        Pair<String, String> r4 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new AnonymousClass2(r3));     // Catch: Throwable -> L10
        if (r4 == null) goto L12;
        r0.put(r4.first, r4.second);     // Catch: Throwable -> L10
    L12:
        return r0;
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L12
    L5:
        r0.put("Content-Type", "application/json; charset=utf-8");
        goto L13
    }
}
