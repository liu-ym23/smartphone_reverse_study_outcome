package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.frameworks.core.encrypt.RequestEncryptUtils;
import com.bytedance.frameworks.core.encrypt.TTEncryptUtils;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.services.apm.api.HttpResponse;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class MonitorNetUtil {
    private static final boolean DEBUG_MOBILE = false;
    private static IRequestIntercept sRequestIntercept;

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        final int nativeInt;

        public static CompressType valueOf(String r1) {
            return (CompressType) Enum.valueOf(CompressType.class, r1);
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
        }

        static {
            CompressType r0 = new CompressType("NONE", 0, 0);
            NONE = r0;
            CompressType r1 = new CompressType("GZIP", 1, 1);
            GZIP = r1;
            CompressType r3 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r3;
            $VALUES = new CompressType[]{r0, r1, r3};
        }

        private CompressType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }
    }

    public interface IRequestIntercept {
        String addRequestVerifyParams(String r1, byte[] r2);
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

        public static NetworkType valueOf(String r1) {
            return (NetworkType) Enum.valueOf(NetworkType.class, r1);
        }

        public static NetworkType[] values() {
            return (NetworkType[]) $VALUES.clone();
        }

        static {
            NetworkType r0 = new NetworkType("NONE", 0, 0);
            NONE = r0;
            NetworkType r1 = new NetworkType("MOBILE", 1, 1);
            MOBILE = r1;
            NetworkType r3 = new NetworkType("MOBILE_2G", 2, 2);
            MOBILE_2G = r3;
            NetworkType r5 = new NetworkType("MOBILE_3G", 3, 3);
            MOBILE_3G = r5;
            NetworkType r7 = new NetworkType("WIFI", 4, 4);
            WIFI = r7;
            NetworkType r9 = new NetworkType("MOBILE_4G", 5, 5);
            MOBILE_4G = r9;
            $VALUES = new NetworkType[]{r0, r1, r3, r5, r7, r9};
        }

        private NetworkType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }

        public int getValue() {
            return this.nativeInt;
        }
    }

    public MonitorNetUtil() {
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

    public static NetworkType getNetworkType(Context r2) {
        NetworkInfo r0 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L23
        if (r0 == null) goto L22;
        if (r0.isAvailable() == false) goto L22;
        int r1 = r0.getType();     // Catch: Throwable -> L23
        if (1 == r1) goto L10;
        if (r1 != 0) goto L20;
        switch(((TelephonyManager) r2.getSystemService("phone")).getNetworkType()) {
            case 3: goto L18;
            case 4: goto L26;
            case 5: goto L18;
            case 6: goto L18;
            case 7: goto L26;
            case 8: goto L18;
            case 9: goto L18;
            case 10: goto L18;
            case 11: goto L26;
            case 12: goto L18;
            case 13: goto L16;
            case 14: goto L18;
            case 15: goto L18;
            default: goto L26;
        };     // Catch: Throwable -> L23
    L26:
        return NetworkType.MOBILE;
    L16:
        return NetworkType.MOBILE_4G;
    L18:
        return NetworkType.MOBILE_3G;
    L20:
        return NetworkType.MOBILE;
    L10:
        return NetworkType.WIFI;
    L22:
        return NetworkType.NONE;
    L24:
        return NetworkType.MOBILE;
    }

    public static boolean isNetworkAvailable(Context r2) {
        if (r2 != null) goto L14;
        return false;
    L14:
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L11
        if (r3 == null) goto L16;
        if (r3.isConnected() == false) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static String getNetWorkType(Context r2) {
        if (r2 != null) goto L14;
        return null;
    L14:
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L13
        if (r3 == null) goto L12;
        if (r3.isAvailable() == false) goto L12;
        return r3.getTypeName();
    L12:
        return null;
    }

    public static void setRequestIntercept(IRequestIntercept r0) {
        sRequestIntercept = r0;
    }

    public static byte[] getRequest(String r7, String r8, boolean r9) throws Throwable {
        if (TextUtils.isDigitsOnly(r7) == false) goto L7;
        return null;
    L7:
        return excuteRequest(r7, null, r8, null, HttpMethodContrants.GET, false, r9).getResponseBytes();
    }

    public static HttpResponse excuteRequest(String r5, byte[] r6, String r7, String r8, String r9, boolean r10, boolean r11) throws Throwable {
        InputStream r1 = null;
        IRequestIntercept r2 = sRequestIntercept;     // Catch: Throwable -> L81
        if (r2 == null) goto L6;
        r5 = r2.addRequestVerifyParams(r5, r6);     // Catch: Throwable -> L81
    L6:
        LinkedList r3 = new LinkedList();     // Catch: Throwable -> L81
        if (r11 == false) goto L9;
        URL r4 = new URL(RequestEncryptUtils.tryEncryptRequest(r5, r3));     // Catch: Throwable -> L81
    L10:
        HttpURLConnection r12 = (HttpURLConnection) r4.openConnection();     // Catch: Throwable -> L81
        if (r11 == false) goto L22;
    L79:
        th = th;
    L80:
        Throwable r13 = th;
        HttpURLConnection r14 = r12;
        th = r13;
    L104:
        throw th;     // Catch: Throwable -> L84
    L84:
        th = move-exception;
        IoUtil.close(r1);
        if (r14 != null) goto L106;
    L88:
        throw th;
    L106:
        r14.disconnect();     // Catch: Exception -> L90
        goto L88
    L13:
        if (r3.isEmpty() == true) goto L22;
        Iterator r15 = r3.iterator();     // Catch: Throwable -> L79
    L16:
        if (r15.hasNext() == false) goto L22;
        Pair r16 = (Pair) r15.next();     // Catch: Throwable -> L79
        if (r16 == null) goto L16;
        r12.setRequestProperty((String) r16.first, (String) r16.second);     // Catch: Throwable -> L79
    L22:
        if (r10 == false) goto L24;
        r12.setDoOutput(true);     // Catch: Throwable -> L79
    L25:
        if (r7 == null) goto L27;
        r12.setRequestProperty("Content-Type", r7);     // Catch: Throwable -> L79
    L27:
        if (r8 == null) goto L29;
        r12.setRequestProperty("Content-Encoding", r8);     // Catch: Throwable -> L79
    L29:
        r12.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L79
        r12.setRequestProperty("Version-Code", "1");     // Catch: Throwable -> L79
        if (r9 == null) goto L78;
        r12.setRequestMethod(r9);     // Catch: Throwable -> L79
        if (r6 != null) goto L34;
    L44:
        int r17 = r12.getResponseCode();     // Catch: Throwable -> L79
        if (r17 != 200) goto L76;
        InputStream r18 = r12.getInputStream();     // Catch: Throwable -> L79
        String r19 = r12.getContentEncoding();     // Catch: Throwable -> L73
        if (TextUtils.isEmpty(r19) == false) goto L50;
    L59:
        byte[] r20 = toByteArray(r18);     // Catch: Throwable -> L73
    L60:
        Map<String, List<String>> r21 = r12.getHeaderFields();     // Catch: Throwable -> L73
        HashMap r110 = new HashMap();     // Catch: Throwable -> L73
        Iterator<String> r0 = r21.keySet().iterator();     // Catch: Throwable -> L73
    L62:
        if (r0.hasNext() == false) goto L68;
        String r22 = r0.next();     // Catch: Throwable -> L73
        List<String> r23 = r21.get(r22);     // Catch: Throwable -> L73
        if (r23 == null) goto L62;
        if (ListUtils.isEmpty(r23) == true) goto L62;
        r110.put(r22, r23.get(0));     // Catch: Throwable -> L73
        goto L62
    L68:
        HttpResponse r24 = new HttpResponse(r17, r110, r20);     // Catch: Throwable -> L73
        IoUtil.close(r18);
        if (r12 != null) goto L97;
    L72:
        return r24;
    L97:
        r12.disconnect();     // Catch: Exception -> L89
        goto L72
    L50:
        if (r19.equalsIgnoreCase("gzip") == false) goto L59;
        GZIPInputStream r25 = new GZIPInputStream(r18);     // Catch: Throwable -> L56
        r20 = toByteArray(r25);     // Catch: Throwable -> L54
        IoUtil.close(r25);     // Catch: Throwable -> L73
    L54:
        th = th;
        r1 = r25;
    L57:
        IoUtil.close(r1);     // Catch: Throwable -> L73
        throw th;     // Catch: Throwable -> L73
    L56:
        th = th;
    L73:
        th = th;
        r1 = r18;
        goto L80
    L76:
        throw new HttpResponseException(r17, r12.getResponseMessage());     // Catch: Throwable -> L79
    L34:
        if (r6.length <= 0) goto L44;
        DataOutputStream r26 = new DataOutputStream(r12.getOutputStream());     // Catch: Throwable -> L40
        r26.write(r6);     // Catch: Throwable -> L38
        r26.flush();     // Catch: Throwable -> L38
        IoUtil.close(r26);     // Catch: Throwable -> L79
    L38:
        th = th;
    L42:
        IoUtil.close(r26);     // Catch: Throwable -> L79
        throw th;     // Catch: Throwable -> L79
    L40:
        th = th;
        r26 = null;
        goto L42
    L78:
        throw new IllegalArgumentException("request method is not null");     // Catch: Throwable -> L79
    L24:
        r12.setDoOutput(false);     // Catch: Throwable -> L79
        goto L25
    L9:
        r4 = new URL(r5);     // Catch: Throwable -> L81
    L81:
        th = th;
        r14 = null;
        goto L104
    }

    public static byte[] toByteArray(InputStream r4) throws IOException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[8192];
    L3:
        int r2 = r4.read(r1);
        if ((-1) == r2) goto L6;
        r0.write(r1, 0, r2);
        goto L3
    L6:
        if (r4 == null) goto L9;
        r4.close();
    L9:
        return r0.toByteArray();
    }

    public static byte[] compress(byte[] r2, Map<String, String> r3) throws IOException {
        if (r2.length <= 128) goto L13;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r1 = new GZIPOutputStream(r0);
        r1.write(r2);     // Catch: Throwable -> L7 IOException -> L9
        r1.close();
        byte[] r4 = r0.toByteArray();
        r3.put("Content-Encoding", "gzip");
        return r4;
    L7:
        th = move-exception;
        r1.close();
        throw th;
    L9:
        e = move-exception;
        throw e;     // Catch: Throwable -> L7
    L13:
        return r2;
    }

    public static HttpResponse excutePost(String r10, byte[] r11, CompressType r12, String r13, boolean r14) throws Throwable {
        String r0 = null;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r11 != null) goto L8;
        r11 = new byte[0];
    L8:
        int r2 = r11.length;
        if (CompressType.GZIP != r12) goto L17;
        if (r2 <= 128) goto L17;
        ByteArrayOutputStream r15 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r1 = new GZIPOutputStream(r15);
        r1.write(r11);     // Catch: Throwable -> L14
        r1.close();
        r11 = r15.toByteArray();
        r0 = "gzip";
    L24:
        byte[] r3 = r11;
        String r6 = r0;
        if (r14 == false) goto L33;
        byte[] r16 = TTEncryptUtils.encrypt(r3, r3.length);
        if (r16 == null) goto L29;
        String r4 = r10 + "&tt_data=a";
        byte[] r5 = r16;
        String r7 = "application/octet-stream;tt-data=a";
    L31:
        return excuteRequest(r4, r5, r7, r6, "POST", true, true);
    L29:
        r4 = r10;
        r7 = r13;
        r5 = r3;
        goto L31
    L33:
        return excuteRequest(r10, r3, r13, r6, "POST", true, false);
    L14:
        r1.close();
        return null;
    L17:
        if (CompressType.DEFLATER != r12) goto L24;
        if (r2 <= 128) goto L24;
        ByteArrayOutputStream r17 = new ByteArrayOutputStream(8192);
        Deflater r8 = new Deflater();
        r8.setInput(r11);
        r8.finish();
        byte[] r18 = new byte[8192];
    L21:
        if (r8.finished() == true) goto L23;
        r17.write(r18, 0, r8.deflate(r18));
        goto L21
    L23:
        r8.end();
        r11 = r17.toByteArray();
        r0 = "deflate";
        goto L24
    }
}
