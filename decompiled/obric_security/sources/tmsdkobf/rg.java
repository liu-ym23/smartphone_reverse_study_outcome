package tmsdkobf;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class rg {
    private static final int[] l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Socket f481a;
    DataOutputStream b;
    DataInputStream c;
    private int d;
    private long e;
    private qg f;
    private cl g;
    private Handler h;
    private final Object i;
    private int j;
    private int k;

    class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ rg f482a;

        /* JADX INFO: renamed from: tmsdkobf.rg$a$a, reason: collision with other inner class name */
        class C0106a extends ti {
            final /* synthetic */ List b;
            final /* synthetic */ a c;

            C0106a(a r1, String r2, List r3) {
                this.c = r1;
                this.b = r3;
                super(r2);
            }

            @Override // tmsdkobf.ti
            public void a() {
                rg.a(this.c.f482a, this.b, 2);
            }
        }

        a(rg r1, Looper r2) {
            this.f482a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            if (r3.what != 1) goto L10;
            ArrayList r4 = (ArrayList) r3.obj;
            if (r4 != null) goto L8;
            return;
        L8:
            uk.b(new C0106a(this, "r_tcp_connector_second", r4), "t_tcp_connector_second");
            return;
        }
    }

    class b extends ti {
        final /* synthetic */ List b;
        final /* synthetic */ rg c;

        b(rg r1, String r2, List r3) {
            this.c = r1;
            this.b = r3;
            super(r2);
        }

        @Override // tmsdkobf.ti
        public void a() {
            rg.a(this.c, this.b, 0);
        }
    }

    class c extends ti {
        final /* synthetic */ List b;
        final /* synthetic */ rg c;

        c(rg r1, String r2, List r3) {
            this.c = r1;
            this.b = r3;
            super(r2);
        }

        @Override // tmsdkobf.ti
        public void a() {
            rg.a(this.c, this.b, 1);
        }
    }

    class d extends ti {
        final /* synthetic */ List b;
        final /* synthetic */ rg c;

        d(rg r1, String r2, List r3) {
            this.c = r1;
            this.b = r3;
            super(r2);
        }

        @Override // tmsdkobf.ti
        public void a() {
            rg.a(this.c, this.b, 10);
        }
    }

    static {
        l = new int[]{4000, 8000, 16000, 32000};
    }

    public rg(qg r3, cl r4) {
        this.d = -1;
        this.i = new Object();
        this.j = -1;
        this.k = 2;
        this.f = r3;
        this.g = r4;
        this.h = new a(this, uk.a());
    }

    static /* synthetic */ void a(rg r0, List r1, int r2) {
        r0.a(r1, r2);
    }

    public int a(List r4, List r5) {
        this.e = System.currentTimeMillis();
        if (r4 == null) goto L28;
        if (r4.size() == 0) goto L28;
        if (r5 != null) goto L9;
    L15:
        this.k = 1;
        uk.b(new b(this, "r_tcp_connector_first", r4), "t_tcp_connector_first");
    L16:
        Object r6 = this.i;
        monitor-enter(r6);
        this.i.wait();     // Catch: Throwable -> L20 InterruptedException -> L29
    L20:
        th = move-exception;
        throw th;
    L22:
        int r3 = this.d;     // Catch: Throwable -> L20
        monitor-exit(r6);     // Catch: Throwable -> L20
        return r3;
    L9:
        if (r5.size() == 0) goto L15;
        if (this.f.f444a.f460a.z == false) goto L14;
        this.k = 2;
        uk.b(new c(this, "r_tcp_connector_first", r4), "t_tcp_connector_first");
        Message r7 = this.h.obtainMessage(1, r5);
        this.h.sendMessageDelayed(r7, this.f.f444a.f460a.A);
        goto L16
    L14:
        this.k = 1;
        ArrayList r0 = new ArrayList();
        r0.addAll(r4);
        r0.addAll(r5);
        uk.b(new d(this, "r_tcp_connector_first", r0), "t_tcp_connector_first");
    L28:
        throw new IllegalArgumentException("firstHostPortList must not be null or empty!");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v3 */
    private void a(List r29, int r30) {
        int r3 = r29.size();
        int r4 = -1;
        String r0 = null;
        ?? r7 = 0;
        int r11 = -1;
        long r8 = 0;
        int r6 = 0;
        int r10 = 0;
        ej r5 = null;
    L4:
        if (r6 >= r3) goto L65;
        Object r13 = this.i;
        monitor-enter(r13);
    L62:
        th = move-exception;
        throw th;
    L8:
        if (this.j != (-1)) goto L9;
        monitor-exit(r13);     // Catch: Throwable -> L62
        r10 = r10 + 1;
        ej r9 = a((String) r29.get(r6));
        int[] r1 = l;
        if (r6 >= r1.length) goto L15;
        int r2 = r1[r6];
    L16:
        long r14 = System.currentTimeMillis();
        if (r9 == null) goto L47;
        String r12 = r9.f186a;
        if (r12 == null) goto L47;
        InetAddress r15 = InetAddress.getByName(r12);     // Catch: Throwable -> L34 SecurityException -> L36 SocketException -> L38 ConnectException -> L40 SocketTimeoutException -> L42 UnknownHostException -> L44
        Socket r16 = new Socket();     // Catch: Throwable -> L34 SecurityException -> L36 SocketException -> L38 ConnectException -> L40 SocketTimeoutException -> L42 UnknownHostException -> L44
        r16.setSoLinger(r7, r7);     // Catch: Throwable -> L34 SecurityException -> L36 SocketException -> L38 ConnectException -> L40 SocketTimeoutException -> L42 UnknownHostException -> L44
        r16.connect(new InetSocketAddress(r15, r9.b), r2);     // Catch: Throwable -> L34 SecurityException -> L36 SocketException -> L38 ConnectException -> L40 SocketTimeoutException -> L42 UnknownHostException -> L44
        cj.a("TMSDK_SK_HB", "" + r16 + ":" + r9.f186a + ":" + r9.b);     // Catch: Throwable -> L34 SecurityException -> L36 SocketException -> L38 ConnectException -> L40 SocketTimeoutException -> L42 UnknownHostException -> L44
        DataOutputStream r17 = new DataOutputStream(r16.getOutputStream());     // Catch: Throwable -> L34 SecurityException -> L36 SocketException -> L38 ConnectException -> L40 SocketTimeoutException -> L42 UnknownHostException -> L44
        DataInputStream r18 = new DataInputStream(r16.getInputStream());     // Catch: Throwable -> L34 SecurityException -> L36 SocketException -> L38 ConnectException -> L40 SocketTimeoutException -> L42 UnknownHostException -> L44
        Object r19 = this.i;     // Catch: Throwable -> L34 SecurityException -> L36 SocketException -> L38 ConnectException -> L40 SocketTimeoutException -> L42 UnknownHostException -> L44
        monitor-enter(r19);     // Catch: Throwable -> L34 SecurityException -> L36 SocketException -> L38 ConnectException -> L40 SocketTimeoutException -> L42 UnknownHostException -> L44
        if (this.j == (-1)) goto L28;
        a(r16);     // Catch: Throwable -> L31
    L29:
        monitor-exit(r19);     // Catch: Throwable -> L31
        r0 = "";
        r11 = 0;
    L49:
        long r110 = System.currentTimeMillis() - r14;
        if (r11 == 0) goto L61;
        if (j4.e(r11) == false) goto L61;
        if (r6 != 0) goto L60;
        if (this.f.f444a.f460a.E == false) goto L60;
        if (bl.b("tcp connect") == false) goto L60;
        r11 = -160000;
    L60:
        r6 = r6 + 1;
        r5 = r9;
        r8 = r110;
        r7 = 0;
    L61:
        String r21 = r0;
        ej r111 = r9;
        r8 = r110;
    L66:
        Object r20 = this.i;
        monitor-enter(r20);
        int r22 = this.k - 1;     // Catch: Throwable -> L86
        this.k = r22;     // Catch: Throwable -> L86
        int r23 = this.j;     // Catch: Throwable -> L86
        if (r23 != r30) goto L71;
        boolean r24 = false;
        this.d = 0;     // Catch: Throwable -> L86
        this.i.notify();     // Catch: Throwable -> L86
        r4 = this.j;     // Catch: Throwable -> L86
        this.h.removeMessages(1);     // Catch: Throwable -> L86
    L76:
        int r27 = r4;
        boolean r25 = true;
    L78:
        monitor-exit(r20);     // Catch: Throwable -> L86
        if (r25 == false) goto L106;
        Context r112 = rd.e();
        long r113 = System.currentTimeMillis() - this.e;
        if (r10 != r3) goto L83;
        boolean r26 = true;
    L84:
        zg.a(r112, r111, r8, r113, r11, r21, r10, r26, this.f.c(), this.g.a(), this.f.f444a.f460a.E, r27);
        return;
    L83:
        r26 = r24;
        goto L84
    L106:
        return;
    L71:
        r24 = false;
        if (r22 != 0) goto L77;
        if (r23 != (-1)) goto L77;
        this.d = r11;     // Catch: Throwable -> L86
        this.i.notify();     // Catch: Throwable -> L86
    L77:
        r25 = false;
        r27 = -1;
    L86:
        th = move-exception;
        throw th;
    L28:
        this.j = r30;     // Catch: Throwable -> L31
        this.f481a = r16;     // Catch: Throwable -> L31
        this.b = r17;     // Catch: Throwable -> L31
        this.c = r18;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34 SecurityException -> L36 SocketException -> L38 ConnectException -> L40 SocketTimeoutException -> L42 UnknownHostException -> L44
    L36:
        e = move-exception;
        int r28 = j4.a(e.toString(), -440000);
        r0 = e.toString();
    L46:
        r11 = r28;
    L40:
        e = move-exception;
        r28 = j4.a(e.toString(), -500000);
        r0 = e.toString();
    L38:
        e = move-exception;
        r28 = j4.a(e.toString(), -420000);
        r0 = e.toString();
    L42:
        e = move-exception;
        r0 = e.toString();
        r28 = -130000;
    L44:
        e = move-exception;
        r0 = e.toString();
        r28 = -70000;
    L34:
        th = move-exception;
        r0 = th.toString();
    L48:
        r11 = -900000;
    L47:
        r0 = "socketAddress or host null";
        goto L48
    L15:
        r2 = r1[r1.length - 1];
        goto L16
    L9:
        monitor-exit(r13);     // Catch: Throwable -> L62
    L65:
        r21 = r0;
        r111 = r5;
        goto L66
    }

    private static ej a(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return null;
    L5:
        int r0 = r3.lastIndexOf(":");
        if (r0 > 0) goto L8;
    L14:
        return null;
    L8:
        if (r0 == (r3.length() - 1)) goto L14;
        String r2 = r3.substring(0, r0);
        String r4 = r3.substring(r0 + 1);
        if (TextUtils.isDigitsOnly(r4) == false) goto L14;
        return new ej(r2, Integer.parseInt(r4));
    }

    private void a(Socket r3) {
        if (r3 != null) goto L9;
        return;
    L9:
        cj.a("TMSDK_SK_HB", "" + r3 + ":close");     // Catch: Throwable -> L8
        r3.close();     // Catch: Throwable -> L8
        return;
    }
}
