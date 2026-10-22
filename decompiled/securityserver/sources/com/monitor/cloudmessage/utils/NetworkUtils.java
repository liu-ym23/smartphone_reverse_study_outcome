package com.monitor.cloudmessage.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.RouteInfo;
import android.net.TrafficStats;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.monitor.cloudmessage.upload.net.CloudMessageUploadService;
import io.reactivex.annotations.SchedulerSupport;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NetworkUtils {
    private static long lastTimeRxStamp;
    private static long lastTimeTxStamp;
    private static long lastTotalRxBytes;
    private static long lastTotalTxBytes;

    /* JADX INFO: renamed from: com.monitor.cloudmessage.utils.NetworkUtils$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$monitor$cloudmessage$utils$NetworkUtils$NetworkType = null;

        static {
            int[] r0 = new int[NetworkType.values().length];
            $SwitchMap$com$monitor$cloudmessage$utils$NetworkUtils$NetworkType = r0;
            r0[NetworkType.WIFI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$monitor$cloudmessage$utils$NetworkUtils$NetworkType[NetworkType.MOBILE_2G.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$monitor$cloudmessage$utils$NetworkUtils$NetworkType[NetworkType.MOBILE_3G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$monitor$cloudmessage$utils$NetworkUtils$NetworkType[NetworkType.MOBILE_4G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$monitor$cloudmessage$utils$NetworkUtils$NetworkType[NetworkType.MOBILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static final enum NetworkType extends Enum<NetworkType> {
        private static final /* synthetic */ NetworkType[] $VALUES = null;
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType WIFI = null;
        final int nativeInt;

        static {
            NetworkType r0 = new NetworkType("NONE", 0, 0);
            NONE = r0;
            NetworkType r1 = new NetworkType("MOBILE", 1, 1);
            MOBILE = r1;
            NetworkType r2 = new NetworkType("MOBILE_2G", 2, 2);
            MOBILE_2G = r2;
            NetworkType r3 = new NetworkType("MOBILE_3G", 3, 3);
            MOBILE_3G = r3;
            NetworkType r4 = new NetworkType("WIFI", 4, 4);
            WIFI = r4;
            NetworkType r5 = new NetworkType("MOBILE_4G", 5, 5);
            MOBILE_4G = r5;
            $VALUES = new NetworkType[]{r0, r1, r2, r3, r4, r5};
        }

        private NetworkType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }

        public static NetworkType valueOf(String r1) {
            return (NetworkType) Enum.valueOf(NetworkType.class, r1);
        }

        public static NetworkType[] values() {
            return (NetworkType[]) $VALUES.clone();
        }

        public int getValue() {
            return this.nativeInt;
        }
    }

    public NetworkUtils() {
    }

    public static String getDownloadSpeed(Context r8) {
        long r0 = getTotalRxBytes(r8.getApplicationInfo().uid);
        if (r0 != (-1)) goto L6;
        return "UNSUPPORTED";
    L6:
        long r2 = System.currentTimeMillis();
        long r4 = ((r0 - lastTotalRxBytes) * 1000) / (r2 - lastTimeRxStamp);
        lastTimeRxStamp = r2;
        lastTotalRxBytes = r0;
        return String.valueOf(r4) + " KB/s";
    }

    public static List<String> getGateway(Context r8) {
        ArrayList r0 = new ArrayList();
        if (r8 != null) goto L20;
    L19:
        return r0;
    L20:
        ConnectivityManager r9 = (ConnectivityManager) r8.getSystemService("connectivity");     // Catch: Exception -> L15
        NetworkInfo r1 = r9.getActiveNetworkInfo();     // Catch: Exception -> L15
        Network[] r2 = r9.getAllNetworks();     // Catch: Exception -> L15
        int r3 = r2.length;     // Catch: Exception -> L15
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L19;
        Network r5 = r2[r4];     // Catch: Exception -> L15
        if (r9.getNetworkInfo(r5).getType() != r1.getType()) goto L17;
        Iterator<RouteInfo> r6 = r9.getLinkProperties(r5).getRoutes().iterator();     // Catch: Exception -> L15
    L10:
        if (r6.hasNext() == false) goto L17;
        InetAddress r7 = r6.next().getGateway();     // Catch: Exception -> L15
        if (r7 == null) goto L10;
        r0.add(r7.getHostAddress());     // Catch: Exception -> L15
    L17:
        r4 = r4 + 1;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public static List<String> getLocalDNS(Context r8) {
        ArrayList r0 = new ArrayList();
        if (r8 != null) goto L18;
    L17:
        return r0;
    L18:
        ConnectivityManager r9 = (ConnectivityManager) r8.getSystemService("connectivity");     // Catch: Exception -> L13
        NetworkInfo r1 = r9.getActiveNetworkInfo();     // Catch: Exception -> L13
        Network[] r2 = r9.getAllNetworks();     // Catch: Exception -> L13
        int r3 = r2.length;     // Catch: Exception -> L13
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L17;
        Network r5 = r2[r4];     // Catch: Exception -> L13
        if (r9.getNetworkInfo(r5).getType() != r1.getType()) goto L15;
        Iterator<InetAddress> r6 = r9.getLinkProperties(r5).getDnsServers().iterator();     // Catch: Exception -> L13
    L10:
        if (r6.hasNext() == false) goto L15;
        r0.add(r6.next().getHostAddress());     // Catch: Exception -> L13
    L15:
        r4 = r4 + 1;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static String getNativeIp() {
        String r0 = SchedulerSupport.NONE;
        Enumeration<NetworkInterface> r1 = NetworkInterface.getNetworkInterfaces();     // Catch: SocketException -> L13
    L4:
        if (r1.hasMoreElements() == false) goto L25;
        NetworkInterface r2 = r1.nextElement();     // Catch: SocketException -> L13
        String r3 = r2.getName();     // Catch: SocketException -> L13
        if (r3 == null) goto L4;
        if (TextUtils.equals(r3.toLowerCase(), "eth0") == true) goto L15;
        if (TextUtils.equals(r3.toLowerCase(), "wlan0") == false) goto L4;
    L15:
        Enumeration<InetAddress> r4 = r2.getInetAddresses();     // Catch: SocketException -> L13
    L17:
        if (r4.hasMoreElements() == false) goto L4;
        InetAddress r5 = r4.nextElement();     // Catch: SocketException -> L13
        if ((r5 instanceof Inet4Address) == false) goto L17;
        if (r5.isLoopbackAddress() == true) goto L17;
        r0 = r5.getHostAddress();     // Catch: SocketException -> L13
    L25:
        return r0;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L25
    }

    public static String getNetworkAccessType(Context r0) {
        return getNetworkAccessType(getNetworkType(r0));
    }

    private static NetworkType getNetworkType(Context r2) {
        NetworkInfo r0 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L26
        if (r0 == null) goto L25;
        if (r0.isAvailable() == false) goto L25;
        int r1 = r0.getType();     // Catch: Throwable -> L26
        if (1 == r1) goto L10;
        if (r1 != 0) goto L23;
        switch(((TelephonyManager) r2.getSystemService("phone")).getNetworkType()) {
            case 1: goto L21;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L21;
            case 8: goto L19;
            case 9: goto L19;
            case 10: goto L19;
            case 11: goto L21;
            case 12: goto L19;
            case 13: goto L17;
            case 14: goto L19;
            case 15: goto L19;
            default: goto L15;
        };     // Catch: Throwable -> L26
    L15:
        return NetworkType.MOBILE;
    L17:
        return NetworkType.MOBILE_4G;
    L19:
        return NetworkType.MOBILE_3G;
    L21:
        return NetworkType.MOBILE_2G;
    L23:
        return NetworkType.MOBILE;
    L10:
        return NetworkType.WIFI;
    L25:
        return NetworkType.NONE;
    L27:
        return NetworkType.MOBILE;
    }

    private static long getTotalRxBytes(int r4) {
        return TrafficStats.getTotalRxBytes() / 1024;
    }

    private static long getTotalTxBytes(int r4) {
        return TrafficStats.getTotalTxBytes() / 1024;
    }

    public static String getUploadSpeed(Context r8) {
        long r0 = getTotalTxBytes(r8.getApplicationInfo().uid);
        if (r0 != (-1)) goto L6;
        return "UNSUPPORTED";
    L6:
        long r2 = System.currentTimeMillis();
        long r4 = ((r0 - lastTotalTxBytes) * 1000) / (r2 - lastTimeTxStamp);
        lastTimeTxStamp = r2;
        lastTotalTxBytes = r0;
        return String.valueOf(r4) + " KB/s";
    }

    public static boolean isNetworkAvailable(Context r2) {
        if (r2 != null) goto L15;
        return false;
    L15:
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L10
        if (r3 == null) goto L12;
        if (r3.isConnected() == false) goto L17;
        return true;
    L17:
        return false;
    L12:
        return false;
    L10:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean isWifi(Context r2) {
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.isAvailable() == false) goto L17;
        if (1 == r3.getType()) goto L12;
        return false;
    L12:
        return true;
    L17:
        return false;
    L19:
        return false;
    }

    public static List<String> parseDomainName(String r4) {
        ArrayList r0 = new ArrayList();
        InetAddress[] r5 = InetAddress.getAllByName(r4);     // Catch: UnknownHostException -> L11
        if (r5 != null) goto L6;
    L13:
        return r0;
    L6:
        if (r5.length <= 0) goto L13;
        int r1 = r5.length;     // Catch: UnknownHostException -> L11
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L13;
        r0.add(r5[r2].getHostAddress());     // Catch: UnknownHostException -> L11
        r2 = r2 + 1;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static boolean testGet(String r7, JSONObject r8) {
        JSONObject r0 = new JSONObject();
        boolean r1 = false;
        HttpURLConnection r2 = null;
        HttpURLConnection r3 = (HttpURLConnection) new URL(r7).openConnection();     // Catch: Throwable -> L14 Exception -> L16
        r3.setRequestMethod(HttpMethodContrants.GET);     // Catch: Throwable -> L10 Exception -> L12
        r3.setReadTimeout(30000);     // Catch: Throwable -> L10 Exception -> L12
        r3.setConnectTimeout(30000);     // Catch: Throwable -> L10 Exception -> L12
        r3.setDoInput(true);     // Catch: Throwable -> L10 Exception -> L12
        r3.setDoOutput(true);     // Catch: Throwable -> L10 Exception -> L12
        r3.setUseCaches(false);     // Catch: Throwable -> L10 Exception -> L12
        r3.setRequestProperty("Charset", CloudMessageUploadService.ENCODE);     // Catch: Throwable -> L10 Exception -> L12
        int r4 = r3.getResponseCode();     // Catch: Throwable -> L10 Exception -> L12
        r0.put("statusCode", r4);     // Catch: Throwable -> L10 Exception -> L12
        r0.put("header", StringUtils.getJsonFromMap(r3.getHeaderFields()));     // Catch: Throwable -> L10 Exception -> L12
        r8.put(r7, r0);     // Catch: Throwable -> L10 Exception -> L12
    L6:
        if (r4 != 200) goto L8;
        r1 = true;
    L8:
        r3.disconnect();
        return r1;
    L12:
        e = e;
        r2 = r3;
    L17:
        e.printStackTrace();     // Catch: Throwable -> L14
        r8.put(r7, e.getMessage());     // Catch: Throwable -> L14 JSONException -> L22
        if (r2 == null) goto L21;
        r2.disconnect();
    L21:
        return false;
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        if (r2 == null) goto L26;
        r2.disconnect();
    L26:
        return false;
    L10:
        th = th;
        r2 = r3;
    L27:
        if (r2 == null) goto L29;
        r2.disconnect();
    L29:
        throw th;
    L16:
        e = e;
    L14:
        th = th;
        goto L27
    }

    private static String getNetworkAccessType(NetworkType r2) {
        int r3 = AnonymousClass1.$SwitchMap$com$monitor$cloudmessage$utils$NetworkUtils$NetworkType[r2.ordinal()];     // Catch: Exception -> L20
        if (r3 != 1) goto L6;
        return "wifi";
    L6:
        if (r3 == 2) goto L27;
        if (r3 == 3) goto L26;
        if (r3 == 4) goto L25;
        if (r3 == 5) goto L24;
        return "";
    L24:
        return "mobile";
    L25:
        return "4g";
    L26:
        return "3g";
    L27:
        return "2g";
    L28:
        return "";
    }
}
