package com.loc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class u5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f7869a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f7870b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static String f7871c;

    static {
        f7869a = new String[]{"arm64-v8a", "x86_64"};
        f7870b = new String[]{"arm", "x86"};
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L4:
        if (r1 >= 80) goto L6;
        r0.append("=");
        r1 = r1 + 1;
        goto L4
    L6:
        f7871c = r0.toString();
    }

    private static String A(String r7) {
    L14:
        th = move-exception;
        s.e(th, "ut", "sPa");
    L16:
        return r7;
    L4:
        if (TextUtils.isEmpty(r7) == false) goto L7;
        return "";
    L7:
        String[] r1 = r7.split("&");     // Catch: Throwable -> L14
        Arrays.sort(r1);     // Catch: Throwable -> L14
        StringBuffer r2 = new StringBuffer();     // Catch: Throwable -> L14
        int r3 = r1.length;     // Catch: Throwable -> L14
        int r5 = 0;
    L8:
        if (r5 >= r3) goto L10;
        r2.append(r1[r5]);     // Catch: Throwable -> L14
        r2.append("&");     // Catch: Throwable -> L14
        r5 = r5 + 1;     // Catch: Throwable -> L14
        goto L8
    L10:
        String r0 = r2.toString();     // Catch: Throwable -> L14
        if (r0.length() <= 1) goto L16;
        return (String) r0.subSequence(0, r0.length() - 1);
    }

    static String B(byte[] r2) {
        return E(r2);
    L4:
        th = move-exception;
        s.e(th, "ut", "h2s");
        return null;
    }

    static String C(byte[] r2) {
        return E(r2);
    L4:
        th = move-exception;
        s.e(th, "ut", "csb2h");
        return null;
    }

    private static void D(String r6) {
    L2:
        int r2 = 0;
        if (r6.length() < 78) goto L4;
        Log.i("authErrLog", "|" + r6.substring(0, 78) + "|");
        r6 = r6.substring(78);
        goto L2
    L4:
        StringBuilder r0 = new StringBuilder();
        r0.append("|");
        r0.append(r6);
    L6:
        if (r2 >= (78 - r6.length())) goto L8;
        r0.append(" ");
        r2 = r2 + 1;
        goto L6
    L8:
        r0.append("|");
        Log.i("authErrLog", r0.toString());
    }

    public static String E(byte[] r5) {
        StringBuilder r0 = new StringBuilder();
        if (r5 != null) goto L6;
        return null;
    L6:
        int r1 = 0;
    L8:
        if (r1 >= r5.length) goto L14;
        String r2 = Integer.toHexString(r5[r1] & 255);
        if (r2.length() != 1) goto L12;
        r2 = BDLocationException.ERROR_TIMEOUT.concat(String.valueOf(r2));
    L12:
        r0.append(r2);
        r1 = r1 + 1;
        goto L8
    L14:
        return r0.toString();
    }

    private static byte[] F(byte[] r3) {
        GZIPOutputStream r0 = null;
        if (r3 != null) goto L42;
        return null;
    L42:
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Throwable -> L19
        GZIPOutputStream r2 = new GZIPOutputStream(r1);     // Catch: Throwable -> L17
        r2.write(r3);     // Catch: Throwable -> L15
        r2.finish();     // Catch: Throwable -> L15
        byte[] r4 = r1.toByteArray();     // Catch: Throwable -> L15
        r2.close();     // Catch: Throwable -> L13
        r1.close();     // Catch: Throwable -> L11
        return r4;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        throw th;
    L15:
        th = th;
        r0 = r2;
    L46:
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        if (r0 != null) goto L36;
    L28:
        if (r1 != null) goto L44;
    L33:
        throw th;
    L44:
        r1.close();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    L36:
        r0.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L17:
        th = th;
    L19:
        th = th;
        r1 = null;
        goto L46
    }

    public static t5 a() {
        t5.a r0 = new t5.a("collection", "1.0", "AMap_collection_1.0");
        r0.b(new String[]{"com.amap.api.collection"});
        return r0.c();
    }

    public static String b(long r1) {
        return c(r1, "yyyyMMdd HH:mm:ss:SSS");
    }

    public static String c(long r2, String r4) {
        return new SimpleDateFormat(r4, Locale.CHINA).format(new Date(r2));
    L4:
        th = move-exception;
        s.e(th, "ut", "ctt");
        return null;
    }

    public static String d(Context r7) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 21) goto L9;
        if (r0 >= 28) goto L9;
        ApplicationInfo r4 = r7.getApplicationInfo();     // Catch: Throwable -> L7
        Field r5 = Class.forName(ApplicationInfo.class.getName()).getDeclaredField("primaryCpuAbi");     // Catch: Throwable -> L7
        r5.setAccessible(true);     // Catch: Throwable -> L7
        String r6 = (String) r5.get(r4);     // Catch: Throwable -> L7
    L10:
        if (r0 < 28) goto L33;
        String[] r1 = (String[]) Build.class.getDeclaredField("SUPPORTED_ABIS").get(null);     // Catch: Throwable -> L30
        if (r1 == null) goto L17;
        if (r1.length <= 0) goto L17;
        r6 = r1[0];     // Catch: Throwable -> L30
    L17:
        if (TextUtils.isEmpty(r6) == true) goto L33;
        if (Arrays.asList(f7869a).contains(r6) == false) goto L33;
        String r8 = r7.getApplicationInfo().nativeLibraryDir;     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r8) == true) goto L33;
        String r9 = r8.substring(r8.lastIndexOf(File.separator) + 1);     // Catch: Throwable -> L30
        if (Arrays.asList(f7870b).contains(r9) == false) goto L33;
        String[] r10 = (String[]) Build.class.getDeclaredField("SUPPORTED_32_BIT_ABIS").get(null);     // Catch: Throwable -> L30
        if (r10 == null) goto L33;
        if (r10.length <= 0) goto L33;
        r6 = r10[0];     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        s.e(th, "ut", "gct_p");
    L33:
        if (TextUtils.isEmpty(r6) == true) goto L35;
        return r6;
    L35:
        return Build.CPU_ABI;
    L7:
        th = move-exception;
        s.e(th, "ut", "gct");
    L9:
        r6 = "";
        goto L10
    }

    public static String e(Throwable r3) {
        StringWriter r1 = new StringWriter();     // Catch: Throwable -> L23
        PrintWriter r2 = new PrintWriter(r1);     // Catch: Throwable -> L21
        r3.printStackTrace(r2);     // Catch: Throwable -> L19
    L6:
        r3 = r3.getCause();     // Catch: Throwable -> L19
        if (r3 == null) goto L9;
        r3.printStackTrace(r2);     // Catch: Throwable -> L19
        goto L6
    L9:
        String r4 = r1.toString();     // Catch: Throwable -> L19
        r1.close();     // Catch: Throwable -> L12
    L57:
        r2.close();     // Catch: Throwable -> L16
    L18:
        return r4;
    L16:
        th = move-exception;
        th.printStackTrace();
    L12:
        th = move-exception;
        th.printStackTrace();
    L19:
        th = th;
    L59:
        th.printStackTrace();     // Catch: Throwable -> L37
        if (r1 != null) goto L65;
    L31:
        if (r2 != null) goto L55;
    L36:
        return null;
    L55:
        r2.close();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.printStackTrace();
        goto L36
    L65:
        r1.close();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        th.printStackTrace();
    L37:
        th = move-exception;
        if (r1 != null) goto L53;
    L43:
        if (r2 == null) goto L70;
        r2.close();     // Catch: Throwable -> L46
        throw th;
    L46:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L70:
        throw th;
    L53:
        r1.close();     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        th.printStackTrace();
    L21:
        th = th;
        r2 = null;
    L23:
        th = th;
        r1 = null;
        r2 = null;
        goto L59
    }

    public static String f(Map<String, String> r5) {
        if (r5.size() != 0) goto L6;
        return null;
    L6:
        StringBuffer r0 = new StringBuffer();
        boolean r1 = true;
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();     // Catch: Throwable -> L18
    L8:
        if (r6.hasNext() == false) goto L21;
        Map.Entry<String, String> r2 = r6.next();     // Catch: Throwable -> L18
        if (r1 == false) goto L16;
        r1 = false;
        r0.append(r2.getKey());     // Catch: Throwable -> L18
        r0.append("=");     // Catch: Throwable -> L18
        String r3 = r2.getValue();     // Catch: Throwable -> L18
    L15:
        r0.append(r3);     // Catch: Throwable -> L18
        goto L8
    L16:
        r0.append("&");     // Catch: Throwable -> L18
        r0.append(r2.getKey());     // Catch: Throwable -> L18
        r0.append("=");     // Catch: Throwable -> L18
        r3 = r2.getValue();     // Catch: Throwable -> L18
    L21:
        return r0.toString();
    L18:
        th = move-exception;
        s.e(th, "ut", "abP");
        goto L21
    }

    public static String g(byte[] r2) {
        if (r2 != null) goto L4;
        return "";
    L4:
        if (r2.length == 0) goto L14;
        return new String(r2, "UTF-8");
    L9:
        return new String(r2);
    L14:
        return "";
    }

    public static Calendar h(String r9, String r10) {
        SimpleDateFormat r0 = new SimpleDateFormat(r10, Locale.CHINA);     // Catch: ParseException -> L4
        Calendar r11 = Calendar.getInstance();     // Catch: ParseException -> L4
        Calendar r1 = Calendar.getInstance();     // Catch: ParseException -> L4
        r1.setTime(r0.parse(r9));     // Catch: ParseException -> L4
        r11.set(r11.get(1), r11.get(2), r11.get(5), r1.get(11), r1.get(12), r1.get(13));     // Catch: ParseException -> L4
        return r11;
    L4:
        e = move-exception;
        s.e(e, "ut", "ctt");
        return null;
    }

    public static void i(Context r9, String r10, String r11, JSONObject r12) {
        String r4 = "";
        String r5 = i5.i(r9);
        String r6 = p5.a(r5);
        String r13 = i5.a(r9);
        if (r12.has(LocationMonitorConst.INFO) == false) goto L7;
        String r3 = r12.getString(LocationMonitorConst.INFO);     // Catch: Throwable -> L37
        String r7 = "请在高德开放平台官网中搜索\"" + r3 + "\"相关内容进行解决";     // Catch: Throwable -> L37
    L38:
    L33:
        r4 = r7;
        goto L34
    L9:
        if ("INVALID_USER_SCODE".equals(r3) == false) goto L23;
        if (r12.has("sec_code") == false) goto L13;
        String r1 = r12.getString("sec_code");     // Catch: Throwable -> L33
    L15:
        if (r12.has("sec_code_debug") == false) goto L18;
        r4 = r12.getString("sec_code_debug");     // Catch: Throwable -> L33
    L18:
        if (r6.equals(r1) == false) goto L20;
    L21:
        String r0 = u("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5Lit5pCc57Si") + "\"请求内容过长导致业务调用失败\"相关内容进行解决";     // Catch: Throwable -> L33
    L35:
        Log.i("authErrLog", f7871c);
        Log.i("authErrLog", "                                   鉴权错误信息                                  ");
        Log.i("authErrLog", f7871c);
        D("SHA1Package:".concat(String.valueOf(r5)));
        D("key:".concat(String.valueOf(r13)));
        D("csid:".concat(String.valueOf(r10)));
        D("gsid:".concat(String.valueOf(r11)));
        D("json:" + r12.toString());
        Log.i("authErrLog", "                                                                               ");
        Log.i("authErrLog", r0);
        Log.i("authErrLog", f7871c);
        return;
    L20:
        if (r6.equals(r4) == true) goto L21;
    L32:
        r0 = r7;
        goto L35
    L13:
        r1 = "";
        goto L15
    L23:
        if ("INVALID_USER_KEY".equals(r3) == false) goto L32;
        if (r12.has("key") == false) goto L28;
        r4 = r12.getString("key");     // Catch: Throwable -> L33
    L28:
        if (r4.length() <= 0) goto L32;
        if (r13.equals(r4) == true) goto L32;
        r7 = u("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5LiK5Y+R6LW35oqA5pyv5ZKo6K+i5bel5Y2V4oCUPui0puWPt+S4jktleemXrumimO+8jOWSqOivoklOVkFMSURfVVNFUl9LRVnlpoLkvZXop6PlhrM=");     // Catch: Throwable -> L33
        goto L32
    L7:
        r3 = "";
        r7 = r3;
    L34:
        r0 = r4;
        goto L35
    }

    public static void j(ByteArrayOutputStream r2, byte r3, byte[] r4) {
        r2.write(new byte[]{r3});     // Catch: IOException -> L11
        int r5 = r3 & 255;     // Catch: IOException -> L11
        if (r5 >= 255) goto L8;
        if (r5 <= 0) goto L8;
        r2.write(r4);     // Catch: IOException -> L11
        return;
    L8:
        if (r5 != 255) goto L15;
        r2.write(r4, 0, 255);     // Catch: IOException -> L11
        return;
    L15:
        return;
    L11:
        e = move-exception;
        s.e(e, "ut", "wFie");
    }

    public static void k(ByteArrayOutputStream r2, String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L15;
        int r0 = r3.length();
        if (r0 <= 255) goto L13;
        r0 = 255;
    L13:
        j(r2, (byte) r0, o(r3));
        return;
    L15:
        r2.write(new byte[]{0});     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        s.e(e, "ut", "wsf");
    }

    public static boolean l(Context r6, String r7) {
        if (r6 != null) goto L6;
        return false;
    L6:
        if (r6.checkCallingOrSelfPermission(r7) == 0) goto L9;
        return false;
    L9:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
    L17:
        return true;
    L11:
        if (r6.getApplicationInfo().targetSdkVersion < 23) goto L17;
        if (((Integer) r6.getClass().getMethod("checkSelfPermission", new Class[]{String.class}).invoke(r6, new Object[]{r7})).intValue() == 0) goto L17;
        return false;
    L15:
        th = move-exception;
        s.e(th, "ut", "cpm");
        goto L17
    }

    public static boolean m(JSONObject r0, String r1) {
        if (r0 != null) goto L4;
        return false;
    L4:
        if (r0.has(r1) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static byte[] n(int r3) {
        return new byte[]{(byte) (r3 / 256), (byte) (r3 % 256)};
    }

    public static byte[] o(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L5;
        return r1.getBytes("UTF-8");
    L9:
        return r1.getBytes();
    L5:
        return new byte[0];
    }

    public static t5 p() {
        t5.a r0 = new t5.a("co", "1.0.0", "AMap_co_1.0.0");
        r0.b(new String[]{"com.amap.co", "com.amap.opensdk.co", "com.amap.location"});
        return r0.c();
    }

    public static String q(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        String r3 = m5.i(o(r2));
        return ((char) ((r3.length() % 26) + 65)) + r3;
    L8:
        th = move-exception;
        s.e(th, "ut", "tsfb64");
        return "";
    }

    public static String r(Map<String, String> r3) {
        if (r3 == null) goto L11;
        StringBuilder r0 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r4 = r3.entrySet().iterator();
    L5:
        if (r4.hasNext() == false) goto L10;
        Map.Entry<String, String> r1 = r4.next();
        if (r0.length() <= 0) goto L9;
        r0.append("&");
    L9:
        r0.append(r1.getKey());
        r0.append("=");
        r0.append(r1.getValue());
        goto L5
    L10:
        String r5 = r0.toString();
    L13:
        return A(r5);
    L11:
        r5 = null;
        goto L13
    }

    public static boolean s(Context r0) {
        return p.a(r0);
    }

    public static byte[] t(byte[] r2) {
        return F(r2);
    L4:
        th = move-exception;
        s.e(th, "ut", "gZp");
        return new byte[0];
    }

    public static String u(String r2) {
        if (r2.length() >= 2) goto L7;
        return "";
    L7:
        return m5.a(r2.substring(1));
    }

    public static byte[] v() {
        String[] r1 = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");     // Catch: Throwable -> L13
        byte[] r2 = new byte[r1.length];     // Catch: Throwable -> L13
        int r3 = 0;
        int r4 = 0;
    L5:
        if (r4 >= r1.length) goto L7;
        r2[r4] = Byte.parseByte(r1[r4]);     // Catch: Throwable -> L13
        r4 = r4 + 1;     // Catch: Throwable -> L13
        goto L5
    L7:
        String[] r0 = new StringBuffer(new String(m5.g(new String(r2)))).reverse().toString().split(",");     // Catch: Throwable -> L13
        byte[] r5 = new byte[r0.length];     // Catch: Throwable -> L13
    L8:
        if (r3 >= r0.length) goto L12;
        r5[r3] = Byte.parseByte(r0[r3]);     // Catch: Throwable -> L13
        r3 = r3 + 1;
        goto L8
    L12:
        return r5;
    L13:
        th = move-exception;
        s.e(th, "ut", "gIV");
        return new byte[16];
    }

    public static byte[] w(byte[] r8) {
        byte[] r3 = null;
        if (r8 != null) goto L59;
    L45:
        return null;
    L59:
        if (r8.length == 0) goto L45;
        ByteArrayOutputStream r4 = new ByteArrayOutputStream();     // Catch: Throwable -> L22
        ZipOutputStream r5 = new ZipOutputStream(r4);     // Catch: Throwable -> L20
        r5.putNextEntry(new ZipEntry("log"));     // Catch: Throwable -> L18
        r5.write(r8);     // Catch: Throwable -> L18
        r5.closeEntry();     // Catch: Throwable -> L18
        r5.finish();     // Catch: Throwable -> L18
        r3 = r4.toByteArray();     // Catch: Throwable -> L18
        r5.close();     // Catch: Throwable -> L12
    L14:
        r4.close();     // Catch: Throwable -> L16
    L58:
    L32:
        return r3;
    L12:
        th = move-exception;
        s.e(th, "ut", "zp1");
    L18:
        th = th;
    L61:
        s.e(th, "ut", "zp");     // Catch: Throwable -> L33
        if (r5 != null) goto L50;
    L30:
        if (r4 == null) goto L32;
        r4.close();     // Catch: Throwable -> L16
        goto L58
    L50:
        r5.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        s.e(th, "ut", "zp1");
    L33:
        th = move-exception;
        if (r5 != null) goto L54;
    L39:
        if (r4 == null) goto L65;
        r4.close();     // Catch: Throwable -> L42
        throw th;
    L42:
        th = move-exception;
        s.e(th, "ut", "zp2");
        throw th;
    L65:
        throw th;
    L54:
        r5.close();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        s.e(th, "ut", "zp1");
    L20:
        th = th;
        r5 = null;
    L22:
        th = th;
        r4 = null;
        r5 = null;
    L16:
        th = move-exception;
        s.e(th, "ut", "zp2");
        goto L32
    }

    static PublicKey x() {
        ByteArrayInputStream r2 = new ByteArrayInputStream(m5.g("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));     // Catch: Throwable -> L19
        CertificateFactory r0 = CertificateFactory.getInstance(u("IWC41MDk"));     // Catch: Throwable -> L26
        KeyFactory r3 = KeyFactory.getInstance(u("EUlNB"));     // Catch: Throwable -> L26
        Certificate r1 = r0.generateCertificate(r2);     // Catch: Throwable -> L26
        if (r1 == null) goto L29;
        if (r3 == null) goto L29;
        PublicKey r4 = r3.generatePublic(new X509EncodedKeySpec(r1.getPublicKey().getEncoded()));     // Catch: Throwable -> L26
        r2.close();     // Catch: Throwable -> L11
    L13:
        return r4;
    L11:
        th = move-exception;
        th.printStackTrace();
    L29:
        r2.close();     // Catch: Throwable -> L16
    L18:
        return null;
    L16:
        th = move-exception;
        th.printStackTrace();
    L20:
        if (r2 != null) goto L27;
    L25:
        return null;
    L27:
        r2.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.printStackTrace();
    L19:
        r2 = null;
        goto L20
    }

    public static byte[] y(String r5) {
        if ((r5.length() % 2) == 0) goto L5;
        r5 = BDLocationException.ERROR_TIMEOUT.concat(String.valueOf(r5));
    L5:
        int r0 = r5.length() / 2;
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        int r3 = r2 * 2;
        r1[r2] = (byte) Integer.parseInt(r5.substring(r3, r3 + 2), 16);
        r2 = r2 + 1;
        goto L6
    L8:
        return r1;
    }

    public static byte[] z(byte[] r0) {
        return F(r0);
    L4:
        th = move-exception;
        th.printStackTrace();
        return new byte[0];
    }
}
