package com.bytedance.framwork.core.monitor;

import a.a;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.util.NetUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.core.encrypt.RequestEncryptUtils;
import com.bytedance.frameworks.core.encrypt.TTEncryptUtils;
import com.bytedance.framwork.core.monitor.internal.HttpResponseException;
import com.bytedance.retrofit2.HttpMethodContrants;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
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

        static {
            CompressType r0 = new CompressType("NONE", 0, 0);
            NONE = r0;
            CompressType r1 = new CompressType("GZIP", 1, 1);
            GZIP = r1;
            CompressType r2 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r2;
            $VALUES = new CompressType[]{r0, r1, r2};
        }

        private CompressType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }

        public static CompressType valueOf(String r1) {
            return (CompressType) Enum.valueOf(CompressType.class, r1);
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
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

    public MonitorNetUtil() {
    }

    public static String addRequestVerifyParams(String r1, byte[] r2) {
        IRequestIntercept r0 = sRequestIntercept;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return r0.addRequestVerifyParams(r1, r2);
    }

    public static byte[] excutePost(long r7, String r9, byte[] r10, CompressType r11, String r12, boolean r13) {
        String r8 = null;
        if (r9 != null) goto L6;
        return null;
    L6:
        if (r10 != null) goto L8;
        r10 = new byte[0];
    L8:
        int r0 = r10.length;
        if (CompressType.GZIP != r11) goto L18;
        if (r0 <= 128) goto L18;
        ByteArrayOutputStream r14 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r15 = new GZIPOutputStream(r14);
        r15.write(r10);     // Catch: Throwable -> L15
        r15.close();
        r10 = r14.toByteArray();
        r8 = "gzip";
    L14:
        String r3 = r8;
        byte[] r1 = r10;
        if (r13 == false) goto L40;
        byte[] r16 = TTEncryptUtils.encrypt(r1, r1.length);
        if (r16 == null) goto L38;
        if (TextUtils.isEmpty(new URL(r9).getQuery()) == false) goto L34;
        if (r9.endsWith("?") == true) goto L36;
        r9 = r9.concat("?");
    L36:
        r9 = a.j(r9, "tt_data=a");
        r12 = "application/octet-stream;tt-data=a";
        r1 = r16;
        goto L38
    L34:
        if (r9.endsWith("&") == true) goto L36;
        r9 = r9.concat("&");
    L38:
        return excuteRequest(r9, r1, r12, r3, HttpMethodContrants.POST, true, true);
    L40:
        return excuteRequest(r9, r1, r12, r3, HttpMethodContrants.POST, true, false);
    L15:
        r15.close();
        return null;
    L18:
        if (CompressType.DEFLATER != r11) goto L14;
        if (r0 <= 128) goto L14;
        ByteArrayOutputStream r17 = new ByteArrayOutputStream(8192);
        Deflater r18 = new Deflater();
        r18.setInput(r10);
        r18.finish();
        byte[] r19 = new byte[8192];
    L22:
        if (r18.finished() == true) goto L24;
        r17.write(r19, 0, r18.deflate(r19));
        goto L22
    L24:
        r18.end();
        r10 = r17.toByteArray();
        r8 = "deflate";
        goto L14
    }

    public static byte[] excuteRequest(String r5, byte[] r6, String r7, String r8, String r9, boolean r10, boolean r11) {
        InputStream r1 = null;
        IRequestIntercept r2 = sRequestIntercept;     // Catch: Throwable -> L6
        if (r2 == null) goto L8;
        r5 = r2.addRequestVerifyParams(r5, r6);     // Catch: Throwable -> L6
    L8:
        LinkedList r3 = new LinkedList();     // Catch: Throwable -> L6
        if (r11 == false) goto L11;
        URL r4 = new URL(RequestEncryptUtils.tryEncryptRequest(r5, r3));     // Catch: Throwable -> L6
    L12:
        HttpURLConnection r12 = (HttpURLConnection) r4.openConnection();     // Catch: Throwable -> L6
        if (r11 == true) goto L72;
    L25:
        if (r10 == false) goto L27;
        r12.setDoOutput(true);     // Catch: Throwable -> L23
    L28:
        if (r7 == null) goto L30;
        r12.setRequestProperty("Content-Type", r7);     // Catch: Throwable -> L23
    L30:
        if (r8 == null) goto L32;
        r12.setRequestProperty("Content-Encoding", r8);     // Catch: Throwable -> L23
    L32:
        r12.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L23
        r12.setRequestProperty("Version-Code", "1");     // Catch: Throwable -> L23
        if (r9 == null) goto L54;
        r12.setRequestMethod(r9);     // Catch: Throwable -> L23
        if (r6 != null) goto L37;
    L39:
        int r13 = r12.getResponseCode();     // Catch: Throwable -> L23
        if (r13 != 200) goto L52;
        InputStream r14 = r12.getInputStream();     // Catch: Throwable -> L23
        String r15 = r12.getContentEncoding();     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r15) == false) goto L44;
    L46:
        byte[] r16 = toByteArray(r14);     // Catch: Throwable -> L23
    L47:
        if (r14 != null) goto L73;
    L66:
        r12.disconnect();     // Catch: Exception -> L63
    L50:
        return r16;
    L73:
        r14.close();     // Catch: Exception -> L62
        goto L66
    L44:
        if (r15.equalsIgnoreCase("gzip") == false) goto L46;
        GZIPInputStream r17 = new GZIPInputStream(r14);     // Catch: Throwable -> L23
        r16 = toByteArray(r17);     // Catch: Throwable -> L23
        r17.close();     // Catch: Throwable -> L23
        goto L47
    L52:
        throw new HttpResponseException(r13, r12.getResponseMessage());     // Catch: Throwable -> L23
    L37:
        if (r6.length <= 0) goto L39;
        DataOutputStream r18 = new DataOutputStream(r12.getOutputStream());     // Catch: Throwable -> L23
        r18.write(r6);     // Catch: Throwable -> L23
        r18.flush();     // Catch: Throwable -> L23
        r18.close();     // Catch: Throwable -> L23
        goto L39
    L54:
        throw new IllegalArgumentException("request method is not null");     // Catch: Throwable -> L23
    L27:
        r12.setDoOutput(false);     // Catch: Throwable -> L23
        goto L28
    L72:
    L23:
        th = move-exception;
        HttpURLConnection r19 = r12;
        th = th;
    L70:
        throw th;     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        if (0 != 0) goto L75;
    L59:
        if (r19 == null) goto L85;
        r19.disconnect();     // Catch: Exception -> L65
        throw th;
    L86:
        throw th;
    L85:
        throw th;
    L75:
        r1.close();     // Catch: Exception -> L64
        goto L59
    L15:
        if (r3.isEmpty() == true) goto L25;
        Iterator r110 = r3.iterator();     // Catch: Throwable -> L23
    L18:
        if (r110.hasNext() == false) goto L25;
        Pair r20 = (Pair) r110.next();     // Catch: Throwable -> L23
        if (r20 == null) goto L18;
        r12.setRequestProperty((String) r20.first, (String) r20.second);     // Catch: Throwable -> L23
        goto L18
    L11:
        r4 = new URL(r5);     // Catch: Throwable -> L6
    L6:
        th = th;
        r19 = null;
        goto L70
    }

    public static byte[] getRequest(String r7, String r8, boolean r9) {
        if (TextUtils.isDigitsOnly(r7) == false) goto L7;
        return null;
    L7:
        return excuteRequest(r7, null, r8, null, HttpMethodContrants.GET, false, r9);
    }

    public static boolean isNetworkAvailable(Context r0) {
        if (r0 != null) goto L6;
        return false;
    L6:
        return NetUtils.isNetworkAvailable(r0);
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

    public static void setRequestIntercept(IRequestIntercept r0) {
        sRequestIntercept = r0;
    }

    public static byte[] toByteArray(InputStream r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[8192];
    L3:
        int r2 = r4.read(r1);
        if ((-1) == r2) goto L6;
        r0.write(r1, 0, r2);
        goto L3
    L6:
        r4.close();
        return r0.toByteArray();
    }

    public static String uploadFile(String r11, File r12, Map<String, String> r13, String r14, boolean r15) {
        if (TextUtils.isEmpty(r11) == true) goto L89;
        if (r12 == null) goto L89;
        if (r12.exists() == false) goto L89;
        String r1 = "tt_file_upload" + UUID.randomUUID().toString();
        File r4 = null;
        HttpURLConnection r16 = (HttpURLConnection) new URL(r11).openConnection();     // Catch: Throwable -> L74
        r16.setReadTimeout(30000);     // Catch: Throwable -> L14
        r16.setConnectTimeout(30000);     // Catch: Throwable -> L14
        r16.setDoInput(true);     // Catch: Throwable -> L14
        r16.setDoOutput(true);     // Catch: Throwable -> L14
        r16.setUseCaches(false);     // Catch: Throwable -> L14
        r16.setRequestMethod(HttpMethodContrants.POST);     // Catch: Throwable -> L14
        r16.setRequestProperty("Charset", r14);     // Catch: Throwable -> L14
        r16.setRequestProperty(WsConstants.KEY_CONNECTION, "keep-alive");     // Catch: Throwable -> L14
        r16.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + r1);     // Catch: Throwable -> L14
        if (r15 == false) goto L16;
        r16.setRequestProperty("Content-Encoding", "gzip");     // Catch: Throwable -> L14
    L16:
        if (r13 != null) goto L18;
    L28:
        DataOutputStream r17 = new DataOutputStream(r16.getOutputStream());     // Catch: Throwable -> L14
        StringBuffer r6 = new StringBuffer();     // Catch: Throwable -> L14
        r6.append("--");     // Catch: Throwable -> L14
        r6.append(r1);     // Catch: Throwable -> L14
        r6.append("\r\n");     // Catch: Throwable -> L14
        if (r15 == false) goto L36;
        StringBuilder r8 = new StringBuilder();     // Catch: Throwable -> L14
        r8.append("Content-Disposition: form-data; name=\"file\"; filename=\"");     // Catch: Throwable -> L14
        if (r12.getName().endsWith(".zip") == false) goto L34;
        String r9 = r12.getName();     // Catch: Throwable -> L14
    L35:
        r8.append(r9);     // Catch: Throwable -> L14
        r8.append("\"");     // Catch: Throwable -> L14
        r8.append("\r\n");     // Catch: Throwable -> L14
        r6.append(r8.toString());     // Catch: Throwable -> L14
        goto L36
    L34:
        r9 = r12.getName() + ".zip";     // Catch: Throwable -> L14
    L36:
        r6.append("Content-Type: application/octet-stream; charset=" + r14 + "\r\n");     // Catch: Throwable -> L14
        r6.append("\r\n");     // Catch: Throwable -> L14
        r17.write(r6.toString().getBytes());     // Catch: Throwable -> L14
        if (r15 == false) goto L49;
        if (r12.getName().endsWith(".zip") == true) goto L49;
        File r18 = new File(r12.getAbsolutePath() + "_tmp.zip");     // Catch: Throwable -> L14
    L44:
        th = th;
        HttpURLConnection r19 = r16;
        InputStream r110 = null;
        r4 = r18;
    L102:
        th.printStackTrace();     // Catch: Throwable -> L78
        throw th;     // Catch: Throwable -> L78
    L78:
        th = move-exception;
        if (r4 != null) goto L81;
    L83:
        if (r110 != null) goto L100;
    L85:
        if (r19 == null) goto L117;
        r19.disconnect();     // Catch: Exception -> L93
        throw th;
    L118:
        throw th;
    L117:
        throw th;
    L100:
        r110.close();     // Catch: Exception -> L92
        goto L85
    L81:
        if (r4.exists() == false) goto L83;
        r4.delete();
        goto L83
    L42:
        if (r18.exists() == false) goto L46;
        r18.delete();     // Catch: Throwable -> L44
    L46:
        zipFile(r12, r18);     // Catch: Throwable -> L44
        FileInputStream r111 = new FileInputStream(r18);     // Catch: Throwable -> L44
    L51:
        byte[] r112 = new byte[1024];     // Catch: Throwable -> L44
    L52:
        int r7 = r111.read(r112);     // Catch: Throwable -> L44
        if (r7 == (-1)) goto L55;
        r17.write(r112, 0, r7);     // Catch: Throwable -> L44
        goto L52
    L55:
        r111.close();     // Catch: Throwable -> L44
        r17.write("\r\n".getBytes());     // Catch: Throwable -> L44
        r17.write(("--" + r1 + "--\r\n").getBytes());     // Catch: Throwable -> L44
        r17.flush();     // Catch: Throwable -> L44
        r17.close();     // Catch: Throwable -> L44
        int r113 = r16.getResponseCode();     // Catch: Throwable -> L44
        if (r113 != 200) goto L73;
        InputStream r5 = r16.getInputStream();     // Catch: Throwable -> L44
        String r114 = r16.getContentEncoding();     // Catch: Throwable -> L44
        if (TextUtils.isEmpty(r114) == false) goto L60;
    L62:
        byte[] r115 = toByteArray(r5);     // Catch: Throwable -> L44
    L63:
        String r116 = new String(r115);     // Catch: Throwable -> L44
        if (r18 != null) goto L66;
    L68:
        if (r5 != null) goto L106;
    L104:
        r16.disconnect();     // Catch: Exception -> L91
    L71:
        return r116;
    L106:
        r5.close();     // Catch: Exception -> L90
        goto L104
    L66:
        if (r18.exists() == false) goto L68;
        r18.delete();
        goto L68
    L60:
        if (r114.equalsIgnoreCase("gzip") == false) goto L62;
        GZIPInputStream r117 = new GZIPInputStream(r5);     // Catch: Throwable -> L44
        r115 = toByteArray(r117);     // Catch: Throwable -> L44
        r117.close();     // Catch: Throwable -> L44
        goto L63
    L73:
        throw new HttpResponseException(r113, r16.getResponseMessage());     // Catch: Throwable -> L44
    L49:
        r111 = new FileInputStream(r12);     // Catch: Throwable -> L14
        r18 = null;
        goto L51
    L18:
        if (r13.isEmpty() == true) goto L28;
        Iterator<Map.Entry<String, String>> r118 = r13.entrySet().iterator();     // Catch: Throwable -> L14
    L21:
        if (r118.hasNext() == false) goto L28;
        Map.Entry<String, String> r10 = r118.next();     // Catch: Throwable -> L14
        String r20 = r10.getKey();     // Catch: Throwable -> L14
        String r21 = r10.getValue();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r20) == true) goto L21;
        if (TextUtils.isEmpty(r21) == true) goto L21;
        r16.setRequestProperty(r20, r21);     // Catch: Throwable -> L14
    L14:
        th = th;
        r19 = r16;
        r110 = null;
    L74:
        th = th;
        r110 = null;
        r19 = null;
    L89:
        throw new IllegalArgumentException("url and file not be null ");
    }

    public static void zipFile(File r5, File r6) {
        FileInputStream r1 = new FileInputStream(r5);     // Catch: Throwable -> L20
        FileOutputStream r7 = new FileOutputStream(r6);     // Catch: Throwable -> L18
        GZIPOutputStream r8 = new GZIPOutputStream(r7);     // Catch: Throwable -> L16
        byte[] r0 = new byte[1024];     // Catch: Throwable -> L12
    L8:
        int r2 = r1.read(r0);     // Catch: Throwable -> L12
        if (r2 == (-1)) goto L14;
        r8.write(r0, 0, r2);     // Catch: Throwable -> L12
        goto L8
    L14:
        r8.close();
        r7.close();
        r1.close();
        return;
    L12:
        Throwable th = th;
    L22:
        if (r8 == null) goto L24;
        r8.close();
    L24:
        if (r7 == null) goto L26;
        r7.close();
    L26:
        if (r1 == null) goto L28;
        r1.close();
    L28:
        throw th;
    L16:
        th = move-exception;
        th = th;
        r8 = null;
    L18:
        th = move-exception;
        r8 = null;
        th = th;
        r7 = null;
    L20:
        th = move-exception;
        r8 = null;
        r1 = null;
        th = th;
        r7 = null;
        goto L22
    }
}
