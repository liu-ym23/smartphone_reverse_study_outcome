package com.loc;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.MotionEventCompat;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.KeyGenerator;

/* JADX INFO: loaded from: classes2.dex */
public final class t3 implements o3 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static long f7821k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f7822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<d2> f7823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f7824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    g4 f7825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    c4 f7826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    x2 f7827f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LocationManager f7828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b f7829h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    v0 f7830i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f7831j;

    final class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ t3 f7832f;

        a(t3 r1) {
            this.f7832f = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            t3 r2 = this.f7832f;     // Catch: Throwable -> L8
            if (r2.f7827f == null) goto L13;
            g4 r3 = r2.f7825d;     // Catch: Throwable -> L8
            if (r3 == null) goto L14;
            x2.k(r3.c());     // Catch: Throwable -> L8
            return;
        L14:
            return;
        L13:
            return;
        L8:
            th = move-exception;
            s4.h(th, "cl", "upwr");
        }
    }

    static class b implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private t3 f7833a;

        b(t3 r1) {
            this.f7833a = r1;
        }

        final void a() {
            this.f7833a = null;
        }

        final void b(t3 r1) {
            this.f7833a = r1;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location r1) {
            t3 r0 = this.f7833a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.f(r1);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r1) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String r1) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String r1, int r2, Bundle r3) {
        }
    }

    class c extends s1 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f7834g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Location f7835h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ t3 f7836i;

        c(t3 r1, int r2) {
            this.f7836i = r1;
            this.f7834g = 0;
            this.f7834g = r2;
        }

        c(t3 r2, Location r3) {
            this(r2, 1);
            this.f7835h = r3;
        }

        private void c() {
            u4.a();     // Catch: Throwable -> L40
            if (this.f7835h != null) goto L6;
            return;
        L6:
            if (t3.i(this.f7836i) == true) goto L9;
            return;
        L9:
            if (a5.e0(this.f7836i.f7822a) == false) goto L12;
            u4.a();     // Catch: Throwable -> L40
            return;
        L12:
            Bundle r0 = this.f7835h.getExtras();     // Catch: Throwable -> L40
            int r1 = 0;
            if (r0 == null) goto L16;
            r1 = r0.getInt("satellites");     // Catch: Throwable -> L40
        L16:
            if (a5.o(this.f7835h, r1) == false) goto L18;
            return;
        L18:
            g4 r2 = this.f7836i.f7825d;     // Catch: Throwable -> L40
            if (r2 != null) goto L21;
        L23:
            ArrayList<i3> r3 = this.f7836i.f7825d.c();     // Catch: Throwable -> L40
            List<a3> r4 = this.f7836i.f7826e.i();     // Catch: Throwable -> L40
            b2.a r5 = new b2.a();     // Catch: Throwable -> L40
            h3 r6 = new h3();     // Catch: Throwable -> L40
            r6.f7324h = this.f7835h.getAccuracy();     // Catch: Throwable -> L40
            r6.f7321e = this.f7835h.getAltitude();     // Catch: Throwable -> L40
            r6.f7319c = this.f7835h.getLatitude();     // Catch: Throwable -> L40
            r6.f7323g = this.f7835h.getBearing();     // Catch: Throwable -> L40
            r6.f7320d = this.f7835h.getLongitude();     // Catch: Throwable -> L40
            this.f7835h.isFromMockProvider();     // Catch: Throwable -> L40
            this.f7835h.getProvider();     // Catch: Throwable -> L40
            r6.f7322f = this.f7835h.getSpeed();     // Catch: Throwable -> L40
            r6.f7351j = (byte) r1;     // Catch: Throwable -> L40
            System.currentTimeMillis();     // Catch: Throwable -> L40
            r6.f7318b = this.f7835h.getTime();     // Catch: Throwable -> L40
            r6.f7350i = this.f7835h.getTime();     // Catch: Throwable -> L40
            r5.f7160a = r6;     // Catch: Throwable -> L40
            r5.f7161b = r3;     // Catch: Throwable -> L40
            WifiInfo r7 = this.f7836i.f7825d.l();     // Catch: Throwable -> L40
            if (r7 == null) goto L26;
            r5.f7162c = i3.a(r7.getBSSID());     // Catch: Throwable -> L40
        L26:
            r5.f7163d = g4.E;     // Catch: Throwable -> L40
            r5.f7165f = this.f7835h.getTime();     // Catch: Throwable -> L40
            r5.f7166g = (byte) l5.K(this.f7836i.f7822a);     // Catch: Throwable -> L40
            r5.f7167h = l5.V(this.f7836i.f7822a);     // Catch: Throwable -> L40
            r5.f7164e = this.f7836i.f7825d.v();     // Catch: Throwable -> L40
            r5.f7169j = a5.m(this.f7836i.f7822a);     // Catch: Throwable -> L40
            r5.f7168i = r4;     // Catch: Throwable -> L40
            d2 r8 = x2.a(r5);     // Catch: Throwable -> L40
            if (r8 != null) goto L29;
            return;
        L29:
            ArrayList r9 = t3.k(this.f7836i);     // Catch: Throwable -> L40
            monitor-enter(r9);     // Catch: Throwable -> L40
            t3.k(this.f7836i).add(r8);     // Catch: Throwable -> L37
            if (t3.k(this.f7836i).size() < 5) goto L34;
            this.f7836i.t();     // Catch: Throwable -> L37
        L34:
            monitor-exit(r9);     // Catch: Throwable -> L37
            this.f7836i.s();     // Catch: Throwable -> L40
            return;
        L37:
            th = move-exception;
            throw th;     // Catch: Throwable -> L40
        L21:
            if (r2.o == true) goto L23;
            r2.q();     // Catch: Throwable -> L40
        L40:
            th = move-exception;
            s4.h(th, "cl", "coll");
        }

        private void d() {
            u4.a();
            if (a5.e0(this.f7836i.f7822a) == false) goto L6;
            u4.a();
            return;
        L6:
            l0 r0 = null;
            t3.c(System.currentTimeMillis());     // Catch: Throwable -> L27
            if (this.f7836i.f7830i.f7885f.e() == false) goto L24;
            r0 = l0.b(new File(this.f7836i.f7830i.f7880a), this.f7836i.f7830i.f7881b);     // Catch: Throwable -> L27
            ArrayList r1 = new ArrayList();     // Catch: Throwable -> L27
            byte[] r2 = t3.u();     // Catch: Throwable -> L27
            if (r2 == null) goto L45;
            List r3 = t3.d(r0, this.f7836i.f7830i, r1, r2);     // Catch: Throwable -> L27
            if (r3 != null) goto L16;
        L47:
            r0.close();     // Catch: Throwable -> L36
            return;
        L56:
            return;
        L16:
            if (r3.size() == 0) goto L47;
            this.f7836i.f7830i.f7885f.b(true);     // Catch: Throwable -> L27
            byte[] r5 = m5.h(r2, x2.g(), u5.v());     // Catch: Throwable -> L27
            if (x2.f(u5.t(x2.h(h4.d(r2), r5, r3))) == false) goto L24;
            t3.g(r0, r1);     // Catch: Throwable -> L27
            goto L24
        L45:
            r0.close();     // Catch: Throwable -> L37
            return;
        L55:
            return;
        L24:
            if (r0 == null) goto L58;
            r0.close();     // Catch: Throwable -> L39
            return;
        L57:
            return;
        L58:
            return;
        L27:
            th = move-exception;
            v.m(th, "leg", "uts");     // Catch: Throwable -> L32
            if (r0 == null) goto L59;
            r0.close();     // Catch: Throwable -> L38
            return;
        L60:
            return;
        L59:
            return;
        L32:
            th = move-exception;
            if (r0 != null) goto L43;
        L35:
            throw th;
        L43:
            r0.close();     // Catch: Throwable -> L40
            goto L35
        }

        @Override // com.loc.s1
        public final void b() {
            int r0 = this.f7834g;
            if (r0 != 1) goto L7;
            c();
            return;
        L7:
            if (r0 != 2) goto L11;
            d();
            return;
        L11:
            if (r0 != 3) goto L14;
            t3.q(this.f7836i);
            return;
        }
    }

    static {
    }

    t3(Context r11) {
        this.f7822a = null;
        this.f7823b = new ArrayList();
        this.f7825d = null;
        this.f7826e = null;
        this.f7831j = false;
        this.f7822a = r11;
        v0 r2 = new v0();
        this.f7830i = r2;
        b1.e(r11, r2, t.f7786g, 100, 1024000, BDLocationException.ERROR_TIMEOUT);
        v0 r0 = this.f7830i;
        int r3 = r4.G;
        boolean r5 = r4.E;
        int r6 = r4.F;
        r0.f7885f = new n1(r11, r3, "kKey", new l1(r11, r5, r6, r6 * 10, "carrierLocKey"));
        v0 r10 = this.f7830i;
        r10.f7884e = new e0();
    }

    private static int b(byte[] r2) {
        int r0 = ((r2[3] & 255) | ((r2[2] & 255) << 8)) | ((r2[1] & 255) << 16);
        return ((r2[0] & 255) << 24) | r0;
    }

    static /* synthetic */ long c(long r0) {
        f7821k = r0;
        return r0;
    }

    static /* synthetic */ List d(l0 r0, v0 r1, List r2, byte[] r3) {
        return l(r0, r1, r2, r3);
    }

    static /* synthetic */ void g(l0 r0, List r1) {
        n(r0, r1);
    }

    static /* synthetic */ boolean i(t3 r0) {
        return r0.f7831j;
    }

    private static byte[] j(int r2) {
        KeyGenerator r1 = KeyGenerator.getInstance("AES");     // Catch: Throwable -> L8
        if (r1 != null) goto L6;
        return null;
    L6:
        r1.init(r2);     // Catch: Throwable -> L8
        return r1.generateKey().getEncoded();
    L8:
        return null;
    }

    static /* synthetic */ ArrayList k(t3 r0) {
        return r0.f7823b;
    }

    private static List<d2> l(l0 r17, v0 r18, List<String> r19, byte[] r20) {
        ArrayList r1 = new ArrayList();
        File r0 = r17.M();     // Catch: Throwable -> L74
        if (r0 != null) goto L6;
    L76:
        return r1;
    L6:
        if (r0.exists() == false) goto L76;
        String[] r2 = r0.list();     // Catch: Throwable -> L74
        if (r2 != null) goto L10;
        return r1;
    L10:
        int r3 = r2.length;     // Catch: Throwable -> L74
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L11:
        if (r5 >= r3) goto L73;
        String r7 = r2[r5];     // Catch: Throwable -> L74
        if (r7.contains(".0") == false) goto L71;
        InputStream r8 = null;
        String r9 = r7.split("\\.")[r4];     // Catch: Throwable -> L64
        l0.e r10 = r17.a(r9);     // Catch: Throwable -> L86
        if (r10 != null) goto L92;
        if (r10 == null) goto L71;
    L90:
        r10.close();     // Catch: Throwable -> L77
        goto L71
    L92:
        r8 = r10.a();     // Catch: Throwable -> L63
        if (r8 != null) goto L29;
        if (r8 != null) goto L98;
    L26:
        if (r10 == null) goto L71;
    L98:
        r8.close();     // Catch: Throwable -> L79
        goto L26
    L29:
        byte[] r11 = new byte[2];     // Catch: Throwable -> L63
        r8.read(r11);     // Catch: Throwable -> L63
        int r12 = a5.z(r11);     // Catch: Throwable -> L63
        if (r12 == 0) goto L59;
        if (r12 > 65535) goto L59;
        byte[] r13 = new byte[r12];     // Catch: Throwable -> L63
        r8.read(r13);     // Catch: Throwable -> L63
        byte[] r14 = new byte[2];     // Catch: Throwable -> L63
        int r15 = r4;
    L35:
        if (r8.read(r14) < 0) goto L43;
        byte[] r16 = new byte[a5.z(r14)];     // Catch: Throwable -> L41
        r8.read(r16);     // Catch: Throwable -> L41
        byte[] r110 = m5.e(r13, r16, u5.v());     // Catch: Throwable -> L41
        r15 = r15 + r110.length;     // Catch: Throwable -> L41
        byte[] r111 = new byte[4];     // Catch: Throwable -> L41
        r8.read(r111);     // Catch: Throwable -> L41
        String[] r112 = r2;
        r1.add(new d2(b(r111), m5.h(r20, u5.t(r110), u5.v())));     // Catch: Throwable -> L80
        r2 = r112;
    L66:
        if (r8 != null) goto L118;
    L68:
        if (r10 == null) goto L72;
    L100:
        r10.close();     // Catch: Throwable -> L78
    L72:
        r5 = r5 + 1;
        r2 = r112;
        r4 = 0;
        goto L11
    L118:
        r8.close();     // Catch: Throwable -> L82
    L41:
        r112 = r2;
        goto L66
    L43:
        r112 = r2;
        r6 = r6 + r15;
        r19.add(r9);     // Catch: Throwable -> L58
        if (r6 > r18.f7885f.d()) goto L48;
        if (r8 != null) goto L112;
    L55:
        if (r10 == null) goto L72;
    L112:
        r8.close();     // Catch: Throwable -> L84
        goto L55
    L48:
        if (r8 != null) goto L96;
    L50:
        if (r10 == null) goto L73;
    L108:
        r10.close();     // Catch: Throwable -> L87
        goto L73
    L96:
        r8.close();     // Catch: Throwable -> L83
    L59:
        if (r8 != null) goto L88;
    L61:
        if (r10 == null) goto L73;
    L88:
        r8.close();     // Catch: Throwable -> L85
    L63:
        r112 = r2;
    L65:
        r112 = r2;
        r10 = null;
    L71:
        r112 = r2;
    L73:
        return r1;
    L74:
        th = move-exception;
        v.m(th, "aps", "upc");
        goto L76
    }

    private static void n(l0 r1, List<String> r2) {
        if (r1 == null) goto L15;
        Iterator<String> r3 = r2.iterator();     // Catch: Throwable -> L9
    L5:
        if (r3.hasNext() == false) goto L7;
        r1.V(r3.next());     // Catch: Throwable -> L9
        goto L5
    L7:
        r1.close();     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        v.m(th, "aps", "dlo");
        return;
    }

    private static byte[] o(int r3) {
        return new byte[]{(byte) ((r3 >> 24) & 255), (byte) ((r3 >> 16) & 255), (byte) ((r3 >> 8) & 255), (byte) (r3 & 255)};
    }

    static /* synthetic */ void q(t3 r0) {
        r0.v();
    }

    private static byte[] r(int r3) {
        return new byte[]{(byte) ((r3 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8), (byte) (r3 & 255)};
    }

    static /* synthetic */ byte[] u() {
        return j(128);
    }

    private void v() {
        u4.a();     // Catch: Throwable -> L32
        if (a5.e0(this.f7822a) == false) goto L6;
        u4.a();     // Catch: Throwable -> L32
        return;
    L6:
        ArrayList<d2> r0 = this.f7823b;     // Catch: Throwable -> L32
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.size() == 0) goto L45;
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L32
        ArrayList<d2> r2 = this.f7823b;     // Catch: Throwable -> L32
        monitor-enter(r2);     // Catch: Throwable -> L32
        r1.addAll(this.f7823b);     // Catch: Throwable -> L28
        this.f7823b.clear();     // Catch: Throwable -> L28
        monitor-exit(r2);     // Catch: Throwable -> L28
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();     // Catch: Throwable -> L32
        byte[] r4 = j(256);     // Catch: Throwable -> L32
        if (r4 != null) goto L18;
        return;
    L18:
        r3.write(r(r4.length));     // Catch: Throwable -> L32
        r3.write(r4);     // Catch: Throwable -> L32
        Iterator r5 = r1.iterator();     // Catch: Throwable -> L32
    L20:
        if (r5.hasNext() == false) goto L26;
        d2 r6 = (d2) r5.next();     // Catch: Throwable -> L32
        byte[] r7 = r6.b();     // Catch: Throwable -> L32
        if (r7.length < 10) goto L20;
        if (r7.length > 65535) goto L20;
        byte[] r8 = m5.h(r4, r7, u5.v());     // Catch: Throwable -> L32
        r3.write(r(r8.length));     // Catch: Throwable -> L32
        r3.write(r8);     // Catch: Throwable -> L32
        r3.write(o(r6.a()));     // Catch: Throwable -> L32
        goto L20
    L26:
        byte[] r9 = r3.toByteArray();     // Catch: Throwable -> L32
        w0.c(Long.toString(System.currentTimeMillis()), r9, this.f7830i);     // Catch: Throwable -> L32
        return;
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L45:
        return;
    L32:
        th = move-exception;
        s4.h(th, "clm", "wtD");
    }

    @Override // com.loc.o3
    public final n3 a(m3 r2) {
        m4 r1 = new m4();     // Catch: Throwable -> L4
        r1.J(r2.f7555b);     // Catch: Throwable -> L4
        r1.L(r2.f7554a);     // Catch: Throwable -> L4
        r1.K(r2.f7556c);     // Catch: Throwable -> L4
        o0.b();     // Catch: Throwable -> L4
        u0 r3 = o0.c(r1);     // Catch: Throwable -> L4
        n3 r4 = new n3();     // Catch: Throwable -> L4
        r4.f7567c = r3.f7856a;     // Catch: Throwable -> L4
        r4.f7566b = r3.f7857b;     // Catch: Throwable -> L4
        r4.f7565a = 200;     // Catch: Throwable -> L4
        return r4;
    L4:
        return null;
    }

    final void e() {
        if (a5.e0(this.f7822a) == false) goto L21;
        u4.a();
        return;
    L21:
        b r0 = this.f7829h;     // Catch: Throwable -> L18
        if (r0 == null) goto L11;
        LocationManager r1 = this.f7828g;     // Catch: Throwable -> L18
        if (r1 == null) goto L11;
        r1.removeUpdates(r0);     // Catch: Throwable -> L18
    L11:
        b r2 = this.f7829h;     // Catch: Throwable -> L18
        if (r2 == null) goto L15;
        r2.a();     // Catch: Throwable -> L18
    L15:
        if (this.f7831j == false) goto L23;
        v();     // Catch: Throwable -> L18
        this.f7825d.d(null);     // Catch: Throwable -> L18
        this.f7826e.k(null);     // Catch: Throwable -> L18
        this.f7826e = null;     // Catch: Throwable -> L18
        this.f7825d = null;     // Catch: Throwable -> L18
        this.f7824c = null;     // Catch: Throwable -> L18
        this.f7831j = false;     // Catch: Throwable -> L18
        return;
    L23:
        return;
    L18:
        th = move-exception;
        s4.h(th, "clm", "stc");
    }

    public final void f(Location r3) {
        Handler r0 = this.f7824c;     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        r0.post(new c(this, r3));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        v.m(th, "cl", "olcc");
    }

    public final void h(c4 r7, g4 r8, Handler r9) {
        u4.a();
        if (this.f7831j == false) goto L5;
        return;
    L5:
        if (r7 == null) goto L36;
        if (r8 == null) goto L37;
        if (r9 != null) goto L10;
        return;
    L10:
        if (a5.e0(this.f7822a) == false) goto L13;
        u4.a();
        return;
    L13:
        this.f7831j = true;
        this.f7826e = r7;
        this.f7825d = r8;
        r8.d(this);
        this.f7826e.k(this);
        this.f7824c = r9;
    L30:
        th = move-exception;
        s4.h(th, "col", "init");
        return;
    L15:
        if (this.f7828g != null) goto L19;
        if (r9 == null) goto L19;
        this.f7828g = (LocationManager) this.f7822a.getSystemService(LocationMonitorConst.LOCATION);     // Catch: Throwable -> L30
    L19:
        if (this.f7829h != null) goto L21;
        this.f7829h = new b(this);     // Catch: Throwable -> L30
    L21:
        this.f7829h.b(this);     // Catch: Throwable -> L30
        b r5 = this.f7829h;     // Catch: Throwable -> L30
        if (r5 == null) goto L27;
        LocationManager r0 = this.f7828g;     // Catch: Throwable -> L30
        if (r0 == null) goto L27;
        r0.requestLocationUpdates("passive", 1000, -1.0f, r5);     // Catch: Throwable -> L30
    L27:
        if (this.f7827f != null) goto L35;
        x2 r10 = new x2("6.4.0", i5.j(this.f7822a), "S128DF1572465B890OE3F7A13167KLEI", i5.g(this.f7822a), this);     // Catch: Throwable -> L30
        this.f7827f = r10;     // Catch: Throwable -> L30
        r10.d(l5.P());     // Catch: Throwable -> L30
        r10.i(l5.F(this.f7822a));     // Catch: Throwable -> L30
        r10.l(l5.p(this.f7822a));     // Catch: Throwable -> L30
        r10.m(l5.D(this.f7822a));     // Catch: Throwable -> L30
        r10.n(l5.U());     // Catch: Throwable -> L30
        r10.o(l5.E());     // Catch: Throwable -> L30
        r10.p(Build.MODEL);     // Catch: Throwable -> L30
        r10.q(Build.MANUFACTURER);     // Catch: Throwable -> L30
        r10.r(Build.BRAND);     // Catch: Throwable -> L30
        r10.b(Build.VERSION.SDK_INT);     // Catch: Throwable -> L30
        r10.s(Build.VERSION.RELEASE);     // Catch: Throwable -> L30
        r10.c(i3.a(l5.I()));     // Catch: Throwable -> L30
        r10.t(l5.I());     // Catch: Throwable -> L30
        x2.j();     // Catch: Throwable -> L30
        return;
    L35:
        return;
    L37:
        return;
    }

    public final void m() {
        u4.a();     // Catch: Throwable -> L6
        Handler r0 = this.f7824c;     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        r0.post(new a(this));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        s4.h(th, "cl", "upw");
    }

    public final void p() {
        u4.a();     // Catch: Throwable -> L8
        if (this.f7827f == null) goto L13;
        c4 r2 = this.f7826e;     // Catch: Throwable -> L8
        if (r2 == null) goto L14;
        x2.e(r2.i());     // Catch: Throwable -> L8
        return;
    L14:
        return;
    L13:
        return;
    L8:
        th = move-exception;
        s4.h(th, "cl", "upc");
    }

    public final void s() {
        if (a5.e0(this.f7822a) == false) goto L7;
        u4.a();     // Catch: Throwable -> L11
        return;
    L7:
        if ((System.currentTimeMillis() - f7821k) >= 60000) goto L9;
        return;
    L9:
        r1.f().d(new c(this, 2));     // Catch: Throwable -> L11
        return;
    }

    public final void t() {
        r1.f().d(new c(this, 3));     // Catch: Throwable -> L4
        return;
    }
}
