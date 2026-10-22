package tmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class dl extends bj {
    private static volatile dl j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f166a;
    private boolean b;
    private NetworkInfo.State c;
    private long d;
    private final Object e;
    private ArrayList f;
    private ArrayList g;
    private ArrayList h;
    private Handler i;

    class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ dl f167a;

        a(dl r1, Looper r2) {
            this.f167a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r2) {
            if (r2.what != 1) goto L7;
            dl.a(this.f167a);
            return;
        }
    }

    class b extends ti {
        final /* synthetic */ Intent b;
        final /* synthetic */ dl c;

        b(dl r1, Intent r2) {
            this.c = r1;
            this.b = r2;
        }

        @Override // tmsdkobf.ti
        public void a() {
            dl.a(this.c, this.b);
        }
    }

    class c extends ti {
        final /* synthetic */ dl b;

        c(dl r1) {
            this.b = r1;
        }

        @Override // tmsdkobf.ti
        public void a() {
            Object r0 = dl.b(this.b);
            monitor-enter(r0);
            ArrayList r1 = (ArrayList) dl.c(this.b).clone();     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L13;
            g r3 = (g) r2.next();
            if (r3 == null) goto L8;
            r3.a();
            goto L8
        L13:
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    class d extends ti {
        final /* synthetic */ dl b;

        d(dl r1) {
            this.b = r1;
        }

        @Override // tmsdkobf.ti
        public void a() {
            Object r0 = dl.b(this.b);
            monitor-enter(r0);
            ArrayList r1 = (ArrayList) dl.d(this.b).clone();     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L13;
            f r3 = (f) r2.next();
            if (r3 == null) goto L8;
            r3.h();
            goto L8
        L13:
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    class e extends ti {
        final /* synthetic */ dl b;

        e(dl r1) {
            this.b = r1;
        }

        @Override // tmsdkobf.ti
        public void a() {
            Object r0 = dl.b(this.b);
            monitor-enter(r0);
            ArrayList r1 = (ArrayList) dl.e(this.b).clone();     // Catch: Throwable -> L28
            monitor-exit(r0);     // Catch: Throwable -> L28
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L13;
            f r3 = (f) r2.next();
            if (r3 == null) goto L8;
            r3.f();
            goto L8
        L13:
            ArrayList r4 = dl.d(this.b);
            monitor-enter(r4);
            ArrayList r5 = (ArrayList) dl.d(this.b).clone();     // Catch: Throwable -> L25
            monitor-exit(r4);     // Catch: Throwable -> L25
            Iterator r6 = r5.iterator();
        L19:
            if (r6.hasNext() == false) goto L24;
            f r7 = (f) r6.next();
            if (r7 == null) goto L19;
            r7.f();
            goto L19
        L24:
            return;
        L25:
            th = move-exception;
            throw th;
        L28:
            th = move-exception;
            throw th;
        }
    }

    public interface f {
        void f();

        void h();
    }

    public interface g {
        void a();
    }

    static {
    }

    public dl() {
        this.f166a = 0;
        this.b = false;
        this.c = NetworkInfo.State.UNKNOWN;
        this.d = 0;
        this.e = new Object();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new a(this, uk.a());
    }

    static /* synthetic */ void a(dl r0) {
        r0.e();
    }

    static /* synthetic */ Object b(dl r0) {
        return r0.e;
    }

    static /* synthetic */ ArrayList c(dl r0) {
        return r0.h;
    }

    static /* synthetic */ ArrayList d(dl r0) {
        return r0.g;
    }

    static /* synthetic */ ArrayList e(dl r0) {
        return r0.f;
    }

    static /* synthetic */ void a(dl r0, Intent r1) {
        r0.a(r1);
    }

    public static dl b() {
        if (j == null) goto L5;
    L14:
        j.a();
        return j;
    L5:
        monitor-enter(dl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (j != null) goto L9;
        j = new dl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(dl.class);     // Catch: Throwable -> L11
        goto L14
    }

    private void c() {
        uk.b(new e(this), "network_connected");
    }

    private void d() {
        uk.b(new d(this), "network_disconnected");
    }

    private void e() {
        uk.b(new c(this), "network_change");
    }

    @Override // tmsdkobf.bj
    public void a(Context r2, Intent r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getAction() != null) goto L7;
        return;
    L7:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r3.getAction()) == false) goto L11;
        this.i.post(new b(this, r3));
        return;
    }

    public void b(f r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Object r0 = this.e;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f.contains(r3) == true) goto L9;
        this.f.add(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void a(g r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Object r0 = this.e;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.h.contains(r3) == true) goto L9;
        this.h.add(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void a(f r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Object r0 = this.e;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.g.contains(r3) == true) goto L9;
        this.g.add(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public boolean a(long r5) {
        if (this.d > 0) goto L5;
    L7:
        return false;
    L5:
        if (Math.abs(System.currentTimeMillis() - this.d) >= r5) goto L7;
        return true;
    }

    private void a(Intent r5) {
        if (this.f166a > 0) goto L5;
    L7:
        this.d = System.currentTimeMillis();
        this.i.removeMessages(1);
        this.i.sendEmptyMessageDelayed(1, 5000);
    L8:
        Bundle r6 = r5.getExtras();
        if (r6 != null) goto L11;
        return;
    L11:
        NetworkInfo r7 = (NetworkInfo) r6.getParcelable("networkInfo");
        if (r7 != null) goto L14;
        return;
    L14:
        NetworkInfo.State r0 = r7.getState();
        r7.getTypeName();
        r7.getSubtypeName();
        NetworkInfo.State r8 = NetworkInfo.State.CONNECTED;
        if (r0 == r8) goto L17;
        NetworkInfo.State r9 = NetworkInfo.State.DISCONNECTED;
        if (r0 == r9) goto L22;
    L24:
        this.c = r0;
        return;
    L22:
        if (this.c == r9) goto L24;
        d();
        goto L24
    L17:
        if (this.c == r8) goto L24;
        c();
        goto L24
    L5:
        if ((System.currentTimeMillis() - this.f166a) > 2000) goto L7;
        goto L7
    }

    private synchronized void a() {
        monitor-enter(this);
        Context r0 = rd.e();     // Catch: Throwable -> L22
        if (r0 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        if (this.b == false) goto L28;
        monitor-exit(this);
        return;
    L28:
        NetworkInfo r1 = bl.a();     // Catch: Throwable -> L25
        if (r1 == null) goto L14;
        this.c = r1.getState();     // Catch: Throwable -> L25
        r1.getTypeName();     // Catch: Throwable -> L25
        r1.getSubtypeName();     // Catch: Throwable -> L25
    L27:
        goto L30
    L14:
        this.c = NetworkInfo.State.DISCONNECTED;     // Catch: Throwable -> L25
    L30:
        IntentFilter r2 = new IntentFilter();     // Catch: Throwable -> L26
        r2.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L26
        r2.setPriority(Integer.MAX_VALUE);     // Catch: Throwable -> L26
        if (Build.VERSION.SDK_INT < 33) goto L18;
        r0.registerReceiver(this, r2, 4);     // Catch: Throwable -> L26
    L19:
        this.f166a = System.currentTimeMillis();     // Catch: Throwable -> L26
        this.b = true;     // Catch: Throwable -> L26
        goto L20
    L18:
        r0.registerReceiver(this, r2);     // Catch: Throwable -> L26
    L20:
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        throw th;
    }
}
