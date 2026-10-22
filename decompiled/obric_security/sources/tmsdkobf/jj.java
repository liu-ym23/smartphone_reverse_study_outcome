package tmsdkobf;

import android.content.Context;
import android.net.Network;
import android.text.TextUtils;
import com.bytedance.platform.godzilla.common.Constant;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.ss.android.http.legacy.protocol.HTTP;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public class jj {
    private static final int[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f294a;
    private HttpURLConnection b;
    private ql c;
    private String d;
    private int e;

    public interface a {
        void a(int r1, byte[] r2);
    }

    static {
        f = new int[]{4000, 8000, 16000};
    }

    public jj(Context r1, z6 r2, ql r3) {
        this.f294a = "POST";
        this.e = 0;
        this.c = r3;
    }

    private int a(String r7, Network r8, int r9) {
        URL r2 = new URL(r7);     // Catch: MalformedURLException -> L34
        int r10 = bl.b();     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
        if (r10 != 0) goto L9;
        return -220000;
    L9:
        if (3 != r10) goto L17;
        Proxy r11 = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(bl.c(), bl.d()));     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
        if (r8 != null) goto L13;
        this.b = (HttpURLConnection) r2.openConnection(r11);     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
    L20:
        this.b.setReadTimeout(60000);     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
        this.b.setConnectTimeout(r9);     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
        if (wc.a() >= 8) goto L23;
        System.setProperty("http.keepAlive", "false");     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
    L23:
        this.b.setUseCaches(false);     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
        this.b.setRequestProperty("Pragma", "no-cache");     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
        this.b.setRequestProperty("Cache-Control", "no-cache");     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
        this.b.setInstanceFollowRedirects(false);     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
        if (HttpMethodContrants.GET.equalsIgnoreCase(this.f294a) == false) goto L26;
        this.b.setRequestMethod(HttpMethodContrants.GET);     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
        return 0;
    L26:
        this.b.setRequestMethod("POST");     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
        this.b.setDoOutput(true);     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
        this.b.setDoInput(true);     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
        this.b.setRequestProperty("Accept", "*/*");     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
        this.b.setRequestProperty("Accept-Charset", Constant.CHARSET_UTF_8);     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
        this.b.setRequestProperty("Content-Type", "application/octet-stream");     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
        return 0;
    L13:
        if (wc.a() < 23) goto L15;
        this.b = (HttpURLConnection) r8.openConnection(r2, r11);     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
        goto L20
    L15:
        this.b = (HttpURLConnection) r8.openConnection(r2);     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
        goto L20
    L17:
        if (r8 == null) goto L19;
        this.b = (HttpURLConnection) r8.openConnection(r2);     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
        goto L20
    L19:
        this.b = (HttpURLConnection) r2.openConnection();     // Catch: Exception -> L28 IOException -> L29 SecurityException -> L30 IllegalArgumentException -> L31 UnknownHostException -> L32
    L31:
        return -240000;
    L30:
        return -440000;
    L32:
        return -520000;
    L29:
        return -140000;
    L28:
        return -150000;
    L34:
        return -510000;
    }

    private String b() {
        return this.b.getHeaderField("Location");
    L4:
        return null;
    }

    private boolean c() {
        HttpURLConnection r0 = this.b;
        if (r0 != null) goto L10;
        return false;
    L10:
        r0.disconnect();     // Catch: Throwable -> L9
        this.b = null;     // Catch: Throwable -> L9
        return true;
    L12:
        return true;
    }

    synchronized int a(qg.n r10, byte[] r11, AtomicReference r12, Network r13, List r14) {
        monitor-enter(this);
        if (r11 == null) goto L58;
        if (r10 == null) goto L58;
        if (r14 == null) goto L58;
    L55:
        th = move-exception;
        throw th;
    L7:
        if (r14.size() == 0) goto L58;
        int r0 = f.length;     // Catch: Throwable -> L55
        int r1 = 0;
        int r3 = -1;
        int r2 = 0;
    L11:
        if (r1 >= 3) goto L53;
        if (bl.b() == 0) goto L15;
        if (r10.c() == true) goto L19;
        String r6 = null;
        if (TextUtils.isEmpty(this.d) == true) goto L29;
        int r4 = this.e;     // Catch: Throwable -> L55
        if (r4 >= 1) goto L27;
        String r8 = this.d;     // Catch: Throwable -> L55
        this.d = null;     // Catch: Throwable -> L55
        this.e = r4 + 1;     // Catch: Throwable -> L55
        r6 = r8;
        goto L29
    L27:
        this.d = null;     // Catch: Throwable -> L55
        r2 = r2 + 1;     // Catch: Throwable -> L55
    L29:
        if (TextUtils.isEmpty(r6) == true) goto L31;
    L34:
        if (r1 >= r0) goto L36;
        int r5 = f[r1];     // Catch: Throwable -> L55
    L37:
        r3 = a(r6, r13, r5);     // Catch: Throwable -> L55
        if (r3 != 0) goto L40;
        r10.n = true;     // Catch: Throwable -> L55
        r3 = a(r11, r12);     // Catch: Throwable -> L55
    L40:
        c();     // Catch: Throwable -> L55
        if (r3 == (-60000)) goto L52;
        if (r3 == 0) goto L53;
        if (r3 == (-220000)) goto L53;
        if (this.c.f460a.E == true) goto L49;
    L51:
        r2 = r2 + 1;
        goto L52
    L49:
        if (bl.b("http send") == false) goto L51;
        r3 = -160000;
    L52:
        r1 = r1 + 1;
        goto L11
    L36:
        r5 = f[r0 - 1];     // Catch: Throwable -> L55
        goto L37
    L31:
        if (r2 > (r14.size() - 1)) goto L53;
        r6 = (String) r14.get(r2);     // Catch: Throwable -> L55
        goto L34
    L19:
        monitor-exit(this);
        return -17;
    L15:
        monitor-exit(this);
        return -220000;
    L53:
        monitor-exit(this);
        return r3;
    L58:
        monitor-exit(this);
        return -10;
    }

    private int a(byte[] r4, AtomicReference r5) {
        if (this.b != null) goto L7;
        return -10000;
    L7:
        if (HttpMethodContrants.GET.equalsIgnoreCase(this.f294a) == true) goto L49;
        this.b.setRequestProperty("Content-length", "" + r4.length);
    L49:
        OutputStream r0 = this.b.getOutputStream();     // Catch: Throwable -> L24 Exception -> L26 IOException -> L28 SocketTimeoutException -> L30 SecurityException -> L32 SocketException -> L35 ConnectException -> L38 ProtocolException -> L41 IllegalStateException -> L43 IllegalAccessError -> L45 UnknownHostException -> L47
        r0.write(r4);     // Catch: Throwable -> L24 Exception -> L26 IOException -> L28 SocketTimeoutException -> L30 SecurityException -> L32 SocketException -> L35 ConnectException -> L38 ProtocolException -> L41 IllegalStateException -> L43 IllegalAccessError -> L45 UnknownHostException -> L47
        r0.flush();     // Catch: Throwable -> L24 Exception -> L26 IOException -> L28 SocketTimeoutException -> L30 SecurityException -> L32 SocketException -> L35 ConnectException -> L38 ProtocolException -> L41 IllegalStateException -> L43 IllegalAccessError -> L45 UnknownHostException -> L47
        r0.close();     // Catch: Throwable -> L24 Exception -> L26 IOException -> L28 SocketTimeoutException -> L30 SecurityException -> L32 SocketException -> L35 ConnectException -> L38 ProtocolException -> L41 IllegalStateException -> L43 IllegalAccessError -> L45 UnknownHostException -> L47
        int r6 = this.b.getResponseCode();     // Catch: Throwable -> L24 Exception -> L26 IOException -> L28 SocketTimeoutException -> L30 SecurityException -> L32 SocketException -> L35 ConnectException -> L38 ProtocolException -> L41 IllegalStateException -> L43 IllegalAccessError -> L45 UnknownHostException -> L47
        if (bl.a(r6) == false) goto L18;
        String r7 = b();     // Catch: Throwable -> L24 Exception -> L26 IOException -> L28 SocketTimeoutException -> L30 SecurityException -> L32 SocketException -> L35 ConnectException -> L38 ProtocolException -> L41 IllegalStateException -> L43 IllegalAccessError -> L45 UnknownHostException -> L47
        this.d = r7;     // Catch: Throwable -> L24 Exception -> L26 IOException -> L28 SocketTimeoutException -> L30 SecurityException -> L32 SocketException -> L35 ConnectException -> L38 ProtocolException -> L41 IllegalStateException -> L43 IllegalAccessError -> L45 UnknownHostException -> L47
        if (TextUtils.isEmpty(r7) == false) goto L16;
        return -900000;
    L16:
        return -60000;
    L18:
        a();     // Catch: Throwable -> L24 Exception -> L26 IOException -> L28 SocketTimeoutException -> L30 SecurityException -> L32 SocketException -> L35 ConnectException -> L38 ProtocolException -> L41 IllegalStateException -> L43 IllegalAccessError -> L45 UnknownHostException -> L47
        if (r6 == 200) goto L21;
        return r6;
    L21:
        String r8 = this.b.getHeaderField(HTTP.SERVER_HEADER);     // Catch: Throwable -> L24 Exception -> L26 IOException -> L28 SocketTimeoutException -> L30 SecurityException -> L32 SocketException -> L35 ConnectException -> L38 ProtocolException -> L41 IllegalStateException -> L43 IllegalAccessError -> L45 UnknownHostException -> L47
        TextUtils.isEmpty(r8);     // Catch: Throwable -> L24 Exception -> L26 IOException -> L28 SocketTimeoutException -> L30 SecurityException -> L32 SocketException -> L35 ConnectException -> L38 ProtocolException -> L41 IllegalStateException -> L43 IllegalAccessError -> L45 UnknownHostException -> L47
        r8.equals("QBServer");     // Catch: Throwable -> L24 Exception -> L26 IOException -> L28 SocketTimeoutException -> L30 SecurityException -> L32 SocketException -> L35 ConnectException -> L38 ProtocolException -> L41 IllegalStateException -> L43 IllegalAccessError -> L45 UnknownHostException -> L47
        r5.set(a(this.b.getInputStream()));     // Catch: Throwable -> L24 Exception -> L26 IOException -> L28 SocketTimeoutException -> L30 SecurityException -> L32 SocketException -> L35 ConnectException -> L38 ProtocolException -> L41 IllegalStateException -> L43 IllegalAccessError -> L45 UnknownHostException -> L47
        return 0;
    L45:
        return -80000;
    L43:
        return -90000;
    L32:
        e = move-exception;
        return j4.a(e.toString(), -440000);
    L38:
        e = move-exception;
        return j4.a(e.toString(), -500000);
    L41:
        return -100000;
    L35:
        e = move-exception;
        return j4.a(e.toString(), -420000);
    L30:
        return -120000;
    L47:
        return -70000;
    L28:
        return -140000;
    L26:
        return -150000;
    L24:
        th = move-exception;
        throw th;
    }

    private byte[] a(InputStream r4) {
        byte[] r3 = new byte[2048];
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
    L22:
        int r1 = r4.read(r3);     // Catch: Throwable -> L9 IOException -> L11
        if (r1 == (-1)) goto L6;
        r0.write(r3, 0, r1);     // Catch: Throwable -> L9 IOException -> L11
        goto L22
    L6:
        byte[] r5 = r0.toByteArray();     // Catch: Throwable -> L9 IOException -> L11
        r0.close();     // Catch: Exception -> L16
    L8:
        return r5;
    L11:
        e = move-exception;
        throw new RuntimeException("get Bytes from inputStream when read buffer: " + e.getMessage());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r0.close();     // Catch: Exception -> L17
    L15:
        throw th;
    }

    private void a() {
        this.d = null;
        this.e = 0;
    }
}
