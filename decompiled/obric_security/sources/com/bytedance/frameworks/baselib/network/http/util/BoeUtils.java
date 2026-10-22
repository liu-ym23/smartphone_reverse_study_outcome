package com.bytedance.frameworks.baselib.network.http.util;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.retrofit2.client.Header;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BoeUtils {
    private static final String TTNET_BOE_FLAG = "ttnet_boe.flag";
    private static final String TTNET_CONFIG_FILE = "ttnet_config.json";
    private static volatile String mBoeHttpsSuffix = null;
    private static volatile String mBoeSuffix = null;
    private static volatile boolean mDowngradeToHttp = false;
    private static volatile boolean mEnableOkhttpBoeProxy = false;
    private static volatile boolean mHasReadBoeConfigFile;
    private static volatile List<String> mOkhttpBypassBoeHostList;
    private static volatile List<String> mOkhttpBypassBoeHostWithTNC;
    private static volatile List<String> mOkhttpBypassBoePathList;
    private static volatile List<Pattern> mOkhttpBypassBoeRegexList;

    public BoeUtils() {
    }

    static {
        mOkhttpBypassBoeHostList = new ArrayList();
        mOkhttpBypassBoePathList = new ArrayList();
        mHasReadBoeConfigFile = false;
        mOkhttpBypassBoeRegexList = new ArrayList();
        mOkhttpBypassBoeHostWithTNC = new CopyOnWriteArrayList();
    }

    public static boolean isBoeProxyEnabledByTTNetConfig(Context r2) {
        String r3 = getConfigFromAssets(r2, TTNET_CONFIG_FILE);
        if (TextUtils.isEmpty(r3) == false) goto L11;
    L10:
        return false;
    L11:
        if (new JSONObject(r3).optBoolean("boe_proxy_enabled", false) == false) goto L10;
        return true;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    public static void onServerConfigChanged(JSONObject r3) {
        if (mEnableOkhttpBoeProxy == false) goto L16;
        if (r3 == null) goto L20;
        JSONArray r4 = r3.optJSONArray("boe_bypass_host_list");
        if (r4 != null) goto L9;
        return;
    L9:
        int r0 = 0;
    L11:
        if (r0 >= r4.length()) goto L21;
        String r1 = r4.optString(r0);
        if (StringUtils.isEmpty(r1) == true) goto L15;
        mOkhttpBypassBoeHostWithTNC.add(r1);
    L15:
        r0 = r0 + 1;
        goto L11
    L21:
        return;
    L20:
        return;
    }

    public static boolean isBoeProxyEnabledByBoeFlag(Context r3) {
        String r4 = r3.getFilesDir().getAbsolutePath();
        if (TextUtils.isEmpty(r4) == true) goto L14;
        if (new File(r4 + "/ttnet_boe.flag").exists() == false) goto L15;
        return true;
    L15:
        return false;
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    L14:
        return false;
    }

    public static String getConfigFromAssets(Context r2, String r3) {
        InputStream r0 = null;
        r0 = r2.getAssets().open(r3);     // Catch: Throwable -> L9
        byte[] r4 = new byte[r0.available()];     // Catch: Throwable -> L9
        r0.read(r4);     // Catch: Throwable -> L9
        String r5 = new String(r4, "UTF-8");     // Catch: Throwable -> L9
        if (r0 == null) goto L22;
        r0.close();     // Catch: IOException -> L7
        return r5;
    L7:
        e = move-exception;
        e.printStackTrace();
        return r5;
    L22:
        return r5;
    L9:
        if (r0 != null) goto L16;
    L14:
        return "";
    L16:
        r0.close();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static String tryAddOkhttpBoeSuffix(Context r5, String r6, List<Header> r7) {
        boolean r1 = false;
        if (mHasReadBoeConfigFile == true) goto L15;
        if (mEnableOkhttpBoeProxy == true) goto L15;
        if (isBoeProxyEnabledByTTNetConfig(r5) == false) goto L9;
    L12:
        boolean r8 = true;
    L13:
        mEnableOkhttpBoeProxy = r8;
        mHasReadBoeConfigFile = true;
        goto L15
    L9:
        if (isBoeProxyEnabledByBoeFlag(r5) == true) goto L12;
        r8 = false;
    L15:
        if (mEnableOkhttpBoeProxy == true) goto L17;
    L61:
        return r6;
    L17:
        if (TextUtils.isEmpty(mBoeSuffix) == true) goto L19;
    L21:
        Uri r9 = Uri.parse(r6);
        if (StringUtils.isEmpty(r9.getScheme()) == true) goto L61;
        if (StringUtils.isEmpty(r9.getHost()) == true) goto L61;
        if (StringUtils.isEmpty(r9.getPath()) == true) goto L61;
        if (inBypassBoeList(r9.getHost(), r9.getPath()) == false) goto L31;
        return r6;
    L31:
        Iterator<Header> r10 = r7.iterator();
    L33:
        if (r10.hasNext() == false) goto L44;
        Header r0 = r10.next();
        if (StringUtils.isEmpty(r0.getName()) == true) goto L33;
        if (StringUtils.isEmpty(r0.getValue()) == true) goto L33;
        if (r0.getName().equals("bypass-boe") == false) goto L33;
        if (r0.getValue().equals("1") == false) goto L33;
        return r6;
    L44:
        String r11 = downgradeToHttpScheme(r6, r9.getScheme());
        if (InetAddressUtils.isIPv4Address(r9.getHost()) == false) goto L47;
    L50:
        r1 = true;
    L51:
        if (r1 == false) goto L54;
        return r11;
    L54:
        if (mDowngradeToHttp == false) goto L60;
        String r12 = r9.getHost();
        if (r12.contains(mBoeSuffix) == false) goto L58;
        return r11;
    L58:
        return r11.replaceFirst(r12, r12 + mBoeSuffix);
    L60:
        return replaceBoeHttpsSuffix(r11, r9.getHost());
    L47:
        if (InetAddressUtils.isIPv6StdAddress(r9.getHost()) == true) goto L50;
        if (InetAddressUtils.isIPv6HexCompressedAddress(r9.getHost()) == false) goto L51;
    L19:
        if (TextUtils.isEmpty(mBoeHttpsSuffix) == false) goto L21;
        goto L21
    }

    public static String replaceUrlWithoutBoeHttpSuffix(String r3) {
        if (mEnableOkhttpBoeProxy == true) goto L5;
    L19:
        return null;
    L5:
        if (mDowngradeToHttp == false) goto L19;
        if (r3 == null) goto L19;
        if (r3.contains(mBoeSuffix) == false) goto L19;
        String r0 = Uri.parse(r3).getScheme();
        if (HttpHost.DEFAULT_SCHEME_NAME.equals(r0) == false) goto L15;
        r3 = r3.replaceFirst(HttpHost.DEFAULT_SCHEME_NAME, "https");
    L18:
        return r3.replaceFirst(mBoeSuffix, "");
    L15:
        if ("ws".equals(r0) == false) goto L18;
        r3 = r3.replaceFirst("ws", "wss");
        goto L18
    }

    private static String replaceBoeHttpsSuffix(String r3, String r4) {
        if (TextUtils.isEmpty(mBoeHttpsSuffix) == false) goto L5;
        return r3;
    L5:
        String[] r5 = r4.split("\\.");
        int r0 = r5.length;
        if (r0 >= 2) goto L8;
        return r3;
    L8:
        int r1 = r0 - 2;
        String r6 = r5[r1];
        if (r6.contains(mBoeHttpsSuffix) == false) goto L12;
        return r3;
    L12:
        return replaceFirstSubstringAfterOffset(r3, findCharOffsetByNumbersInOrder(r3, LibrarianImpl.Constants.DOT, r1), r6, r6 + mBoeHttpsSuffix);
    }

    private static String replaceFirstSubstringAfterOffset(String r1, int r2, String r3, String r4) {
        return r1.substring(0, r2) + r1.substring(r2).replaceFirst(r3, r4);
    }

    private static int findCharOffsetByNumbersInOrder(String r4, String r5, int r6) {
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r6) goto L11;
        if (r1 != 0) goto L6;
        int r3 = 0;
    L7:
        r2 = r4.indexOf(r5, r3);
        if (r2 == (-1)) goto L9;
        r1 = r1 + 1;
        goto L3
    L9:
        return 0;
    L6:
        r3 = r2 + 1;
        goto L7
    L11:
        return r2;
    }

    private static String downgradeToHttpScheme(String r2, String r3) {
        if (mDowngradeToHttp == true) goto L6;
        return r2;
    L6:
        if (r3.equals("https") == false) goto L9;
        String r0 = HttpHost.DEFAULT_SCHEME_NAME;
    L13:
        if (StringUtils.isEmpty(r0) == false) goto L15;
        return r2;
    L15:
        return r2.replaceFirst(r3, r0);
    L9:
        if (r3.equals("wss") == false) goto L11;
        r0 = "ws";
        goto L13
    L11:
        r0 = null;
        goto L13
    }

    public static void setBoeSuffix(String r0) {
        mBoeSuffix = r0;
        if (TextUtils.isEmpty(r0) == true) goto L6;
        mDowngradeToHttp = true;
        return;
    }

    public static void setBoeHttpsSuffix(String r0) {
        mBoeHttpsSuffix = r0;
        if (TextUtils.isEmpty(r0) == true) goto L6;
        mDowngradeToHttp = false;
        return;
    }

    public static void enableOkhttpBoeProxy(boolean r0) {
        mEnableOkhttpBoeProxy = r0;
    }

    public static void setOkhttpBypassBoeJson(String r5) {
        if (StringUtils.isEmpty(r5) == false) goto L34;
        return;
    L34:
        JSONObject r0 = new JSONObject(r5);     // Catch: JSONException -> L31
        JSONArray r6 = r0.optJSONArray("bypass_boe_host_list");     // Catch: JSONException -> L31
        int r1 = 0;
        if (r6 == null) goto L14;
        int r2 = 0;
    L9:
        if (r2 >= r6.length()) goto L14;
        String r3 = r6.optString(r2);     // Catch: JSONException -> L31
        if (StringUtils.isEmpty(r3) == true) goto L13;
        mOkhttpBypassBoeHostList.add(r3);     // Catch: JSONException -> L31
    L13:
        r2 = r2 + 1;     // Catch: JSONException -> L31
    L14:
        JSONArray r7 = r0.optJSONArray("bypass_boe_path_list");     // Catch: JSONException -> L31
        if (r7 == null) goto L23;
        int r4 = 0;
    L18:
        if (r4 >= r7.length()) goto L23;
        String r8 = r7.optString(r4);     // Catch: JSONException -> L31
        if (StringUtils.isEmpty(r8) == true) goto L22;
        mOkhttpBypassBoePathList.add(r8);     // Catch: JSONException -> L31
    L22:
        r4 = r4 + 1;     // Catch: JSONException -> L31
    L23:
        JSONArray r9 = r0.optJSONArray("bypass_boe_url_list");     // Catch: JSONException -> L31
        if (r9 == null) goto L45;
    L25:
        if (r1 >= r9.length()) goto L46;
        String r10 = r9.optString(r1);     // Catch: JSONException -> L31
        if (StringUtils.isEmpty(r10) == true) goto L30;
        mOkhttpBypassBoeRegexList.add(Pattern.compile(r10, 2));     // Catch: JSONException -> L31
    L30:
        r1 = r1 + 1;
        goto L25
    L46:
        return;
    L45:
        return;
    L31:
        e = move-exception;
        e.printStackTrace();
    }

    private static boolean inBypassBoeList(String r4, String r5) {
        if (mOkhttpBypassBoeHostList.isEmpty() == true) goto L5;
    L11:
        Iterator<String> r0 = mOkhttpBypassBoeHostList.iterator();
    L13:
        if (r0.hasNext() == false) goto L17;
        if (UrlUtils.matchPattern(r4, r0.next()) == false) goto L13;
        return true;
    L17:
        Iterator<String> r1 = mOkhttpBypassBoeHostWithTNC.iterator();
    L19:
        if (r1.hasNext() == false) goto L23;
        if (UrlUtils.matchPattern(r4, r1.next()) == false) goto L19;
        return true;
    L23:
        Iterator<String> r2 = mOkhttpBypassBoePathList.iterator();
    L25:
        if (r2.hasNext() == false) goto L29;
        if (UrlUtils.matchPattern(r5, r2.next()) == false) goto L25;
        return true;
    L29:
        String r6 = r4 + r5;
        Iterator<Pattern> r7 = mOkhttpBypassBoeRegexList.iterator();
    L31:
        if (r7.hasNext() == false) goto L36;
        if (r7.next().matcher(r6).matches() == false) goto L31;
        return true;
    L36:
        return false;
    L5:
        if (mOkhttpBypassBoePathList.isEmpty() == false) goto L11;
        if (mOkhttpBypassBoeRegexList.isEmpty() == false) goto L11;
        if (mOkhttpBypassBoeHostWithTNC.isEmpty() == false) goto L11;
        return false;
    }

    public static boolean isOkhttpBoeProxyEnabled() {
        return mEnableOkhttpBoeProxy;
    }
}
