package tmsdkobf;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public class lj {
    private static String j = "HttpNetworkManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f334a;
    private qg b;
    private z6 c;
    private tj d;
    private boolean e;
    private final Object f;
    private int g;
    private LinkedList h;
    private Handler i;

    class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ lj f335a;

        a(lj r1, Looper r2) {
            this.f335a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            if (r4.what != 1) goto L19;
            Object r5 = lj.a(this.f335a);
            monitor-enter(r5);
        L14:
            th = move-exception;
            throw th;
        L8:
            if (lj.b(this.f335a) >= 4) goto L12;
            e r0 = (e) lj.f(this.f335a).poll();     // Catch: Throwable -> L14
            if (r0 == null) goto L12;
            lj.c(this.f335a);     // Catch: Throwable -> L14
            lj.a(this.f335a, r0.b, r0.f337a, r0.c);     // Catch: Throwable -> L14
        L12:
            monitor-exit(r5);     // Catch: Throwable -> L14
            return;
        }
    }

    class b extends ti {
        final /* synthetic */ qg.n b;
        final /* synthetic */ byte[] c;
        final /* synthetic */ jj.a d;
        final /* synthetic */ lj e;

        b(lj r1, qg.n r2, byte[] r3, jj.a r4) {
            this.e = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // tmsdkobf.ti
        public void a() {
            AtomicReference r6 = new AtomicReference();
            List r5 = lj.g(this.e).a(this.b.b);
            qg.n r0 = this.b;
            if (r0 != null) goto L5;
        L28:
            int r1 = new jj(lj.i(this.e), lj.j(this.e), lj.k(this.e).f444a).a(this.b, this.c, r6, null, r5);     // Catch: Throwable -> L18
        L19:
            Object r2 = lj.a(this.e);
            monitor-enter(r2);
            lj.d(this.e);     // Catch: Throwable -> L25
            monitor-exit(r2);     // Catch: Throwable -> L25
            lj.a(this.e, r1, r6, this.d);
            return;
        L25:
            th = move-exception;
            throw th;
        L18:
            r1 = -1200;
            goto L19
        L5:
            if (r0.q == false) goto L28;
            if (lj.h(this.e) == false) goto L28;
            Object r3 = lj.a(this.e);
            monitor-enter(r3);
            lj.d(this.e);     // Catch: Throwable -> L13
            monitor-exit(r3);     // Catch: Throwable -> L13
            lj.a(this.e, this.b, this.c, r6, this.d, r5);
            return;
        L13:
            th = move-exception;
            throw th;
        }
    }

    class c extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f336a;
        final /* synthetic */ qg.n b;
        final /* synthetic */ byte[] c;
        final /* synthetic */ AtomicReference d;
        final /* synthetic */ List e;
        final /* synthetic */ ConnectivityManager f;
        final /* synthetic */ jj.a g;
        final /* synthetic */ lj h;

        c(lj r1, qg.n r2, byte[] r3, AtomicReference r4, List r5, ConnectivityManager r6, jj.a r7) {
            this.h = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.f336a = false;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r11) {
            super.onAvailable(r11);
            if (this.f336a == false) goto L5;
            return;
        L5:
            this.f336a = true;
            int r12 = new jj(lj.i(this.h), lj.j(this.h), lj.k(this.h).f444a).a(this.b, this.c, this.d, r11, this.e);     // Catch: Throwable -> L8
        L21:
            this.f.unregisterNetworkCallback(this);     // Catch: Throwable -> L17
            lj.a(this.h, r12, this.d, this.g);     // Catch: Throwable -> L17
            Iterator r9 = this.b.k.iterator();     // Catch: Throwable -> L17
        L11:
            if (r9.hasNext() == false) goto L29;
            pi r5 = (pi) r9.next();     // Catch: Throwable -> L17
            if (r5 == null) goto L11;
            lj.k(this.h).f444a.k().a(lj.a(), r5.f422a, r5.b, r5, 51, r12, null);     // Catch: Throwable -> L17
            goto L11
        L29:
            return;
        L17:
            lj.a(this.h, -1200, this.d, this.g);
            return;
        L8:
            r12 = -1200;
            goto L21
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r1, NetworkCapabilities r2) {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network r1, LinkProperties r2) {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network r1, int r2) {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r1) {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
        }
    }

    class d extends ti {
        final /* synthetic */ jj.a b;
        final /* synthetic */ AtomicReference c;
        final /* synthetic */ int d;
        final /* synthetic */ lj e;

        d(lj r1, jj.a r2, AtomicReference r3, int r4) {
            this.e = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // tmsdkobf.ti
        public void a() {
            if (this.b == null) goto L18;
            AtomicReference r0 = this.c;
            if (r0 == null) goto L7;
            byte[] r1 = (byte[]) r0.get();
        L8:
            int r2 = this.d;
            if (r2 > 0) goto L16;
            if (r2 >= 0) goto L14;
            r2 = r2 - 42000000;
            goto L16
        L14:
            if (lj.e(this.e) == true) goto L16;
            lj.a(this.e, true);
            lj.g(this.e).a("http_1st_succ");
        L16:
            this.b.a(r2, r1);
            return;
        L7:
            r1 = null;
            goto L8
        }
    }

    private class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f337a;
        public qg.n b;
        public jj.a c;

        public e(lj r1, byte[] r2, qg.n r3, jj.a r4) {
            this.f337a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
    }

    public lj(Context r3, z6 r4, tj r5, qg r6) {
        this.e = false;
        this.f = new Object();
        this.g = 0;
        this.h = new LinkedList();
        this.f334a = r3;
        this.c = r4;
        this.d = r5;
        this.b = r6;
        this.i = new a(this, this.b.f444a.h());
    }

    static /* synthetic */ Object a(lj r0) {
        return r0.f;
    }

    static /* synthetic */ int b(lj r0) {
        return r0.g;
    }

    static /* synthetic */ int c(lj r2) {
        int r0 = r2.g;
        r2.g = r0 + 1;
        return r0;
    }

    static /* synthetic */ int d(lj r2) {
        int r0 = r2.g;
        r2.g = r0 - 1;
        return r0;
    }

    static /* synthetic */ boolean e(lj r0) {
        return r0.e;
    }

    static /* synthetic */ LinkedList f(lj r0) {
        return r0.h;
    }

    static /* synthetic */ tj g(lj r0) {
        return r0.d;
    }

    static /* synthetic */ boolean h(lj r0) {
        return r0.b();
    }

    static /* synthetic */ Context i(lj r0) {
        return r0.f334a;
    }

    static /* synthetic */ z6 j(lj r0) {
        return r0.c;
    }

    static /* synthetic */ qg k(lj r0) {
        return r0.b;
    }

    static /* synthetic */ void a(lj r0, int r1, AtomicReference r2, jj.a r3) {
        r0.a(r1, r2, r3);
    }

    public void b(qg.n r4, byte[] r5, jj.a r6) {
        Object r0 = this.f;
        monitor-enter(r0);
        this.h.add(new e(this, r5, r4, r6));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.i.sendEmptyMessage(1);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ String a() {
        return j;
    }

    static /* synthetic */ boolean a(lj r0, boolean r1) {
        r0.e = r1;
        return r1;
    }

    static /* synthetic */ void a(lj r0, qg.n r1, byte[] r2, jj.a r3) {
        r0.a(r1, r2, r3);
    }

    static /* synthetic */ void a(lj r0, qg.n r1, byte[] r2, AtomicReference r3, jj.a r4, List r5) {
        r0.a(r1, r2, r3, r4, r5);
    }

    private void a(qg.n r2, byte[] r3, jj.a r4) {
        b r0 = new b(this, r2, r3, r4);
        boolean r5 = this.b.f444a.q();
        boolean r1 = this.b.f444a.k().a();
        if (r5 == true) goto L7;
        if (r1 == true) goto L7;
        uk.a(r0, "shark-http-send");
        return;
    L7:
        uk.b(r0, "shark-http-urgent-send");
    }

    private boolean b() {
        if (wc.a() >= 21) goto L6;
        return false;
    L6:
        if (2 == bl.b()) goto L9;
        return false;
    L9:
        if (this.c.a(this.f334a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    private void a(qg.n r13, byte[] r14, AtomicReference r15, jj.a r16, List r17) {
        ConnectivityManager r9 = (ConnectivityManager) this.f334a.getSystemService("connectivity");     // Catch: Throwable -> L5
        NetworkRequest.Builder r0 = new NetworkRequest.Builder();     // Catch: Throwable -> L5
        r0.addCapability(12);     // Catch: Throwable -> L5
        r0.addTransportType(0);     // Catch: Throwable -> L5
        r9.requestNetwork(r0.build(), new c(this, r13, r14, r15, r17, r9, r16));     // Catch: Throwable -> L5
        return;
    L5:
        a(-1200, r15, r16);
    }

    private void a(int r2, AtomicReference r3, jj.a r4) {
        d r0 = new d(this, r4, r3, r2);
        boolean r5 = this.b.f444a.q();
        boolean r6 = this.b.f444a.k().a();
        if (r5 == true) goto L7;
        if (r6 == true) goto L7;
        uk.a(r0, "shark-http-handleReqResult");
    L8:
        Object r7 = this.f;
        monitor-enter(r7);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (this.h.size() <= 0) goto L13;
        this.i.sendEmptyMessage(1);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r7);     // Catch: Throwable -> L15
        return;
    L7:
        uk.b(r0, "shark-http-urgent-handleReqResult");
        goto L8
    }
}
