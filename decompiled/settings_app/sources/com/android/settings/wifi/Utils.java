package com.android.settings.wifi;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.R;
import com.android.settings.servicemanager.IPlatform;
import com.android.wifitrackerlib.StandardWifiEntry;
import com.android.wifitrackerlib.WifiEntry;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.obric.olog.OLog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Hashtable;
import obric.widget.editor.LabelEditor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    private static final String ArpFile = "/proc/net/arp";
    public static final String KEY_CHOSEN_WIFIENTRY_KEY = "key_chosen_wifientry_key";
    private static final String LAST_DATA_USAGE = "last_data_usage";
    private static final String START_UP_DATA_USAGE = "startup_data_usage";
    private static Boolean isSoftApConfigChanged = null;
    private static final String softApIntf = "wlan0";

    public static class WifiEntryInfo {
        public int[] securityTypes;
        public String ssid;

        public WifiEntryInfo(String r1, int[] r2) {
            this.ssid = r1;
            this.securityTypes = r2;
        }
    }

    public Utils() {
    }

    static {
        isSoftApConfigChanged = false;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0057: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:33:0x0057 */
    public static boolean hasAssignedIp() {
        ArrayList r0 = new ArrayList();
        BufferedReader r2 = null;
        BufferedReader r3 = new BufferedReader(new FileReader(ArpFile));     // Catch: Throwable -> L18 Exception -> L20
    L44:
        String r4 = r3.readLine();     // Catch: Exception -> L16 Throwable -> L32
        if (r4 == null) goto L14;
        String[] r5 = r4.split(" +");     // Catch: Exception -> L16 Throwable -> L32
        if (r5 == null) goto L44;
        if (r5.length < 5) goto L44;
        if (r5[5].matches(".*wlan0.*") == false) goto L44;
        r0.add(r5[0]);     // Catch: Exception -> L16 Throwable -> L32
        goto L44
    L14:
        r3.close();     // Catch: IOException -> L26
    L40:
    L29:
        if (r0.size() <= 0) goto L58;
        return true;
    L58:
        return false;
    L16:
        Exception e = e;
    L22:
        e.printStackTrace();     // Catch: Throwable -> L32
        if (r3 == null) goto L29;
        r3.close();     // Catch: IOException -> L26
        goto L40
    L26:
        e = move-exception;
        e.printStackTrace();
    L20:
        e = move-exception;
        r3 = null;
        e = e;
    L18:
        th = th;
    L34:
        if (r2 != null) goto L46;
    L39:
        throw th;
    L46:
        r2.close();     // Catch: IOException -> L37
    L37:
        e = move-exception;
        e.printStackTrace();
    L32:
        th = th;
        r2 = r3;
        goto L34
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0055: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:35:0x0055 */
    public static String getIPForMac(String r5) {
        BufferedReader r0 = null;
        BufferedReader r1 = new BufferedReader(new FileReader(ArpFile));     // Catch: Throwable -> L24 Exception -> L26
    L49:
        String r2 = r1.readLine();     // Catch: Exception -> L22 Throwable -> L34
        if (r2 == null) goto L20;
        String[] r3 = r2.split(" +");     // Catch: Exception -> L22 Throwable -> L34
        if (r3 == null) goto L49;
        if (r3.length < 5) goto L49;
        if (r3[5].matches(".*wlan0.*") == false) goto L49;
        if (r3[3].matches(r5) == false) goto L49;
        String r6 = r3[0];     // Catch: Exception -> L22 Throwable -> L34
        r1.close();     // Catch: IOException -> L17
    L19:
        return r6;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L20:
        r1.close();     // Catch: IOException -> L31
    L46:
    L33:
        return null;
    L22:
        e = e;
    L28:
        e.printStackTrace();     // Catch: Throwable -> L34
        r1.close();     // Catch: IOException -> L31
        goto L46
    L34:
        th = th;
        r0 = r1;
    L43:
        r0.close();     // Catch: IOException -> L38
    L40:
        throw th;
    L38:
        e = move-exception;
        e.printStackTrace();
    L26:
        e = e;
        r1 = null;
    L24:
        th = th;
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L33
    }

    public static void storeStartUpDataUsage(Context r2, long r3) {
        SharedPreferences.Editor r4 = r2.getSharedPreferences(START_UP_DATA_USAGE, 0).edit();
        r4.putLong(START_UP_DATA_USAGE, r3);
        r4.apply();
    }

    public static void storeLastDataUsage(Context r2, long r3) {
        SharedPreferences.Editor r4 = r2.getSharedPreferences(LAST_DATA_USAGE, 0).edit();
        r4.putLong(LAST_DATA_USAGE, r3);
        r4.apply();
    }

    public static long getDataUsage(Context r2) {
        return MultiSDKAdapter.getTotalBytes(r2);
    }

    public static long getStartUpDataUsage(Context r4) {
        return r4.getSharedPreferences(START_UP_DATA_USAGE, 0).getLong(START_UP_DATA_USAGE, 0);
    }

    public static long getLastDataUsage(Context r4) {
        return r4.getSharedPreferences(LAST_DATA_USAGE, 0).getLong(LAST_DATA_USAGE, 0);
    }

    public static void markChangeSoftApConfig() {
        isSoftApConfigChanged = true;
    }

    public static boolean isSoftApConfigChanged() {
        return isSoftApConfigChanged.booleanValue();
    }

    public static void resetChangeSoftApConfig() {
        isSoftApConfigChanged = false;
    }

    private static String readConfiguredNetworkKey(WifiManager r1, WifiConfiguration r2) {
        return ((IPlatform) ServiceManager.getService(IPlatform.class)).readConfiguredNetworkKey(r1, r2);
    }

    public static String createContent(WifiManager r4, WifiConfiguration r5, boolean r6) {
        StringBuilder r0 = new StringBuilder("WIFI:");
        String r1 = null;
        if (r5 == null) goto L15;
        int r2 = AccessPoint.getSecurity(r5);
        if (r2 != 1) goto L7;
        r1 = "WEP";
    L11:
        if (r6 == false) goto L13;
        String r7 = r5.preSharedKey;
    L14:
        String r8 = AccessPoint.removeDoubleQuotes(r5.SSID);
    L16:
        StringBuilder r9 = r0.append("T:" + r1).append(";").append("S:" + r8).append(";");
        StringBuilder r10 = new StringBuilder("P:");
        if (TextUtils.isEmpty(r7) == false) goto L19;
        String r11 = "";
    L20:
        r9.append(r10.append(r11).toString()).append(";;");
        return r0.toString();
    L19:
        r11 = escapeSpecialCharacters(r7);
        goto L20
    L13:
        r7 = AccessPoint.removeDoubleQuotes(readConfiguredNetworkKey(r4, r5));
        goto L14
    L7:
        if (r2 == 2) goto L9;
        return null;
    L9:
        r1 = "WPA";
        goto L11
    L15:
        r7 = null;
        r8 = null;
        goto L16
    }

    private static String escapeSpecialCharacters(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return r5;
    L5:
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L7:
        if (r1 >= r5.length()) goto L19;
        char r2 = r5.charAt(r1);
        if (r2 != '\\') goto L11;
    L16:
        r0.append('\\');
    L17:
        r0.append(r2);
        r1 = r1 + 1;
        goto L7
    L11:
        if (r2 == ',') goto L16;
        if (r2 == ';') goto L16;
        if (r2 != ':') goto L17;
    L19:
        return r0.toString();
    }

    public static Bitmap createQrCode(Context r15, String r16) throws WriterException {
        Hashtable r5 = new Hashtable();
        r5.put(EncodeHintType.MARGIN, 0);
        r5.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        if (isIso88591(r16) == true) goto L5;
        r5.put(EncodeHintType.CHARACTER_SET, StandardCharsets.UTF_8.name());
    L5:
        Resources r0 = r15.getResources();
        BitMatrix r1 = new MultiFormatWriter().encode(r16, BarcodeFormat.QR_CODE, r0.getDimensionPixelSize(R.dimen.network_sharing_qrcode_width), r0.getDimensionPixelSize(R.dimen.network_sharing_qrcode_height), r5);
        int[] r2 = r1.getEnclosingRectangle();
        BitMatrix r3 = new BitMatrix(r2[2], r2[3]);
        r3.clear();
        int r4 = 0;
    L7:
        if (r4 >= r2[2]) goto L16;
        int r7 = 0;
    L10:
        if (r7 >= r2[3]) goto L15;
        if (r1.get(r2[0] + r4, r2[1] + r7) == false) goto L14;
        r3.set(r4, r7);
    L14:
        r7 = r7 + 1;
        goto L10
    L15:
        r4 = r4 + 1;
        goto L7
    L16:
        int r13 = r3.getWidth();
        int r14 = r3.getHeight();
        int[] r8 = new int[r13 * r14];
        int r6 = 0;
    L17:
        if (r6 >= r14) goto L26;
        int r9 = 0;
    L19:
        if (r9 >= r13) goto L25;
        if (r3.get(r9, r6) == false) goto L23;
        r8[(r6 * r13) + r9] = -16777216;
    L24:
        r9 = r9 + 1;
        goto L19
    L23:
        r8[(r6 * r13) + r9] = -1;
        goto L24
    L25:
        r6 = r6 + 1;
        goto L17
    L26:
        Bitmap r10 = Bitmap.createBitmap(r13, r14, Bitmap.Config.ARGB_8888);
        r10.setPixels(r8, 0, r13, 0, 0, r13, r14);
        return r10;
    }

    private static boolean isIso88591(String r1) {
        return StandardCharsets.ISO_8859_1.newEncoder().canEncode(r1);
    }

    public static void setRequestFocusForLabelEditorLeftContainer(final LabelEditor r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getLeftContainer() == null) goto L15;
        View r0 = r3.getLeftContainer();
        if (r0 == null) goto L16;
        r0.setOnClickListener(new Utils$$ExternalSyntheticLambda0(r3));
        if ((r0 instanceof ViewGroup) == false) goto L17;
        ViewGroup r1 = (ViewGroup) r0;
        int r2 = 0;
    L11:
        if (r2 >= r1.getChildCount()) goto L18;
        r1.getChildAt(r2).setClickable(false);
        r2 = r2 + 1;
        goto L11
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    static /* synthetic */ void lambda$setRequestFocusForLabelEditorLeftContainer$0(LabelEditor r0, View r1) {
        r0.requestFocus();
    }

    public static WifiConfiguration getWifiConfig(WifiEntry r3, ScanResult r4) {
        if (r3 != null) goto L7;
        if (r4 != null) goto L7;
        throw new IllegalArgumentException("At least one of WifiEntry and ScanResult input is required.");
    L7:
        WifiConfiguration r0 = new WifiConfiguration();
        if (r3 != null) goto L11;
        r0.SSID = "\"" + r4.SSID + "\"";
        int r5 = getWifiEntrySecurity(r4);
    L15:
        switch(r5) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            default: goto L24;
        };
    L17:
        r0.setSecurityParams(5);
        goto L24
    L18:
        r0.setSecurityParams(4);
        goto L24
    L19:
        r0.setSecurityParams(6);
        goto L24
    L20:
        r0.setSecurityParams(3);
        goto L24
    L21:
        r0.setSecurityParams(2);
        goto L24
    L22:
        r0.setSecurityParams(1);
        goto L24
    L23:
        r0.setSecurityParams(0);
    L24:
        return r0;
    L11:
        if (r3.getWifiConfiguration() != null) goto L13;
        r0.SSID = "\"" + r3.getSsid() + "\"";
    L14:
        r5 = r3.getSecurity();
        goto L15
    L13:
        r0.networkId = r3.getWifiConfiguration().networkId;
        r0.hiddenSSID = r3.getWifiConfiguration().hiddenSSID;
        goto L14
    }

    public static int getWifiEntrySecurity(ScanResult r2) {
        if (r2.capabilities.contains("WEP") == false) goto L7;
        return 1;
    L7:
        if (r2.capabilities.contains("SAE") == false) goto L11;
        return 5;
    L11:
        if (r2.capabilities.contains("PSK") == false) goto L15;
        return 2;
    L15:
        if (r2.capabilities.contains("EAP_SUITE_B_192") == false) goto L19;
        return 6;
    L19:
        if (r2.capabilities.contains("EAP") == false) goto L23;
        return 3;
    L23:
        if (r2.capabilities.contains("OWE") == false) goto L26;
        return 4;
    L26:
        return 0;
    }

    public static String getWifiEntrySummary(WifiEntry r1) {
        if (r1 != null) goto L6;
        OLog.d("AccessPointView", "wifiEntry is null");
        return null;
    L6:
        return r1.getSummary(false);
    }

    public static WifiEntryInfo readWifiEntryInfoFromData(Bundle r5) {
        Bundle r0 = r5.getBundle(":settings:show_fragment_args");
        if (r0 == null) goto L6;
        r5 = r0;
    L6:
        String r6 = r5.getString("key_chosen_wifientry_key");
        if (TextUtils.isEmpty(r6) == false) goto L10;
        return null;
    L10:
        if (r6.startsWith(StandardWifiEntry.KEY_PREFIX) == false) goto L26;
        r6 = r6.substring(18);
    L26:
        String r7 = new JSONObject(r6).optString("SCAN_RESULT_KEY");     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(r7) == true) goto L25;
        JSONObject r1 = new JSONObject(r7);     // Catch: JSONException -> L23
        String r8 = r1.optString("SSID");     // Catch: JSONException -> L23
        JSONArray r2 = r1.optJSONArray("SECURITY_TYPES");     // Catch: JSONException -> L23
        if (r2 == null) goto L20;
        int[] r3 = new int[r2.length()];     // Catch: JSONException -> L23
        int r4 = 0;
    L18:
        if (r4 >= r2.length()) goto L21;
        r3[r4] = r2.optInt(r4);     // Catch: JSONException -> L23
        r4 = r4 + 1;     // Catch: JSONException -> L23
    L21:
        return new WifiEntryInfo(r8, r3);
    L20:
        r3 = null;
    L25:
        return null;
    L23:
        e = move-exception;
        OLog.e("Utils", "readWifiEntryInfoFromData JSONException: " + e.getMessage());
        goto L25
    }
}
