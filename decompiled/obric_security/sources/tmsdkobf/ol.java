package tmsdkobf;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class ol {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f403a;
    private Socket b;
    private DataOutputStream c;
    private DataInputStream d;
    private qg e;
    private cl f;
    private c g;
    private Thread h;
    private volatile boolean i;
    private boolean j;

    class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ol f404a;

        a(ol r1, String r2) {
            this.f404a = r1;
            super(r2);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ol.a(this.f404a);
        }
    }

    class b extends ti {
        final /* synthetic */ byte[] b;
        final /* synthetic */ ol c;

        b(ol r1, byte[] r2) {
            this.c = r1;
            this.b = r2;
        }

        @Override // tmsdkobf.ti
        public void a() {
            ol.b(this.c).a(this.b);     // Catch: Throwable -> L4
            return;
        }
    }

    interface c {
        void a(int r1, Object r2);

        void a(byte[] r1);

        void b(int r1, Object r2);
    }

    ol(Context r1, c r2, cl r3, qg r4) {
        this.f403a = new Object();
        this.i = true;
        this.j = false;
        this.g = r2;
        this.f = r3;
        this.e = r4;
    }

    static /* synthetic */ void a(ol r0) {
        r0.b();
    }

    static /* synthetic */ c b(ol r0) {
        return r0.g;
    }

    private void c() {
        a r0 = new a(this, "RcvThread");
        this.h = r0;
        r0.setPriority(10);
        this.h.start();
    }

    private void b() {
    L3:
        if (this.i == true) goto L30;
        int r2 = this.d.readInt();     // Catch: Throwable -> L14 EOFException -> L19 SocketException -> L24
        if (r2 >= this.e.f444a.f460a.p) goto L13;
        cj.a("TMSDK_SK_HB", "[tcp receive] bytes: " + r2);     // Catch: Throwable -> L14 EOFException -> L19 SocketException -> L24
        byte[] r3 = ui.a(this.d, 0, r2, null);     // Catch: Throwable -> L14 EOFException -> L19 SocketException -> L24
        if (r3 == null) goto L3;
        a(r3);     // Catch: Throwable -> L14 EOFException -> L19 SocketException -> L24
        goto L3
    L13:
        throw new RuntimeException("Resp data must not be large than " + this.e.f444a.f460a.p + ", size: " + r2);     // Catch: Throwable -> L14 EOFException -> L19 SocketException -> L24
    L19:
        e = move-exception;
        if (this.j == true) goto L23;
        this.g.b(11, e);
        a(true, false);
        this.g.a(11, e);
        goto L30
    L23:
        this.i = true;
    L24:
        e = move-exception;
        if (this.j == true) goto L28;
        this.g.b(10, e);
        a(true, false);
        this.g.a(10, e);
        goto L30
    L28:
        this.i = true;
    L14:
        th = move-exception;
        if (this.j == true) goto L18;
        this.g.b(12, th);
        a(true, false);
        this.g.a(12, th);
        goto L30
    L18:
        this.i = true;
    L30:
        if (this.j == true) goto L42;
        a(false, false);
        return;
    }

    int a(boolean r7) {
        if (r7 == false) goto L6;
        a(false, true);
    L6:
        if (bl.f() == true) goto L9;
        return -220000;
    L9:
        ArrayList r8 = new ArrayList();
        ArrayList r2 = new ArrayList();
        this.f.a(r8, r2);
        rg r3 = new rg(this.e, this.f);
        int r9 = r3.a(r8, r2);
        if (r9 == 0) goto L12;
        return r9;
    L12:
        Object r10 = this.f403a;
        monitor-enter(r10);
        this.b = r3.f481a;     // Catch: Throwable -> L20
        this.d = r3.c;     // Catch: Throwable -> L20
        this.c = r3.b;     // Catch: Throwable -> L20
        cj.a("TMSDK_SK_HB", "connect:" + this.b);     // Catch: Throwable -> L20
        monitor-exit(r10);     // Catch: Throwable -> L20
        this.e.c().a(r3.f481a);
        sl.a(r3.f481a);
        this.j = false;
        this.i = false;
        c();
        return 0;
    L20:
        th = move-exception;
        throw th;
    }

    int a(qg.n r7, byte[] r8) {
        if (r7 == null) goto L21;
        if (r8 != null) goto L7;
        return -10;
    L7:
        if (r7.c() == false) goto L23;
        return -17;
    L23:
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Throwable -> L17 SocketException -> L19
        DataOutputStream r2 = new DataOutputStream(r1);     // Catch: Throwable -> L17 SocketException -> L19
        r2.writeInt(r8.length);     // Catch: Throwable -> L17 SocketException -> L19
        r2.write(r8);     // Catch: Throwable -> L17 SocketException -> L19
        byte[] r9 = r1.toByteArray();     // Catch: Throwable -> L17 SocketException -> L19
        this.c.write(r9);     // Catch: Throwable -> L17 SocketException -> L19
        cj.a("TMSDK_SK_HB", "[tcp send] bytes: " + r9.length);     // Catch: Throwable -> L17 SocketException -> L19
        this.e.f444a.k().a("TcpNetwork", 40, r7, 0, r9.length);     // Catch: Throwable -> L17 SocketException -> L19
        return 0;
    L19:
        return -330000;
    L17:
        return -320000;
    L21:
        return -10;
    }

    boolean a() {
        Object r0 = this.f403a;
        monitor-enter(r0);
        Socket r1 = this.b;     // Catch: Throwable -> L14
        if (r1 != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r2;
    L7:
        if (r1.isClosed() == true) goto L11;
        if (this.b.isConnected() == false) goto L11;
        r2 = true;
    L14:
        th = move-exception;
        throw th;
    }

    int a(boolean r3, boolean r4) {
        this.i = true;
        if (r3 == true) goto L22;
        this.j = true;
    L22:
        Object r5 = this.f403a;     // Catch: Throwable -> L18
        monitor-enter(r5);     // Catch: Throwable -> L18
        Socket r0 = this.b;     // Catch: Throwable -> L15
        if (r0 != null) goto L10;
    L13:
        monitor-exit(r5);     // Catch: Throwable -> L15
    L24:
        return 0;
    L10:
        if (r0.isClosed() == true) goto L13;
        cj.a("TMSDK_SK_HB", "closeIfNeed:" + this.b + ":close");     // Catch: Throwable -> L15
        this.b.close();     // Catch: Throwable -> L15
        sl.b(this.b);     // Catch: Throwable -> L15
        this.b = null;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        return -900000;
    }

    private void a(byte[] r2) {
        b r0 = new b(this, r2);
        this.e.f444a.a(r0, "shark-notifyOnReceiveData-in-queue");
    }
}
