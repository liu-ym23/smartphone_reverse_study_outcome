package com.loc;

import android.app.Application;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.APSService;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.service.SystemBaseLocationImpl;
import com.ss.ttuploader.TTVideoUploaderListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class a2 {
    private static boolean G = true;
    public static volatile boolean H = false;
    private static boolean I = false;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static AtomicBoolean f7120J;
    com.amap.api.location.c A;
    boolean B;
    private volatile boolean C;
    d D;
    String E;
    boolean F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ew f7121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f7122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    AMapLocationClientOption f7123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f7124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    f5 f7125e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b5 f7126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f7127g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f7128h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ArrayList<com.amap.api.location.b> f7129i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f7130j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f7131k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    g5 f7132l;
    Messenger m;
    Messenger n;
    Intent o;
    private boolean p;
    e q;
    boolean r;
    AMapLocationClientOption.b s;
    Object t;
    y4 u;
    boolean v;
    b3 w;
    private AMapLocationClientOption x;
    String y;
    private ServiceConnection z;

    final class a extends s1 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f7133g;

        a(Context r1) {
            this.f7133g = r1;
        }

        @Override // com.loc.s1
        public final void b() {
            l5.R();
            l5.p(this.f7133g);
            l5.F(this.f7133g);
        }
    }

    final class b implements ServiceConnection {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a2 f7134f;

        b(a2 r1) {
            this.f7134f = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r2, IBinder r3) {
            a2 r4 = this.f7134f;     // Catch: Throwable -> L4
            r4.m = new Messenger(r3);     // Catch: Throwable -> L4
            a2.B(this.f7134f, true);     // Catch: Throwable -> L4
            this.f7134f.v = true;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            s4.h(th, "ALManager", "onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r1) {
            a2 r0 = this.f7134f;
            r0.m = null;
            a2.B(r0, false);
        }
    }

    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7135a = null;

        static {
            int[] r0 = new int[AMapLocationClientOption.b.values().length];
            f7135a = r0;
            r0[AMapLocationClientOption.b.f489f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f7135a[AMapLocationClientOption.b.f490g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f7135a[AMapLocationClientOption.b.f491h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public class d extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a2 f7136a;

        public d(a2 r1, Looper r2) {
            this.f7136a = r1;
            super(r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0 */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v6 */
        @Override // android.os.Handler
        public final void handleMessage(Message r6) {
            ?? r0 = 0;
            super.handleMessage(r6);     // Catch: Throwable -> L70
            if (r4.H == false) goto L7;
            Log.e("AMapLocationClient", "SERVICE_NOT_AVAILABLE");     // Catch: Throwable -> L70
            return;
        L7:
            int r1 = r6.what;     // Catch: Throwable -> L70
            if (r1 != 11) goto L10;
            Bundle r7 = r6.getData();     // Catch: Throwable -> L70
            a2.s(this.f7136a, r7);     // Catch: Throwable -> L70
            return;
        L10:
            if (r1 != 12) goto L12;
            a2.t(this.f7136a, r6);     // Catch: Throwable -> L70
            return;
        L12:
            if (r1 != 1011) goto L75;
            a2.r(this.f7136a, 14, null);     // Catch: Throwable -> L70
            this.f7136a.d0();     // Catch: Throwable -> L70
            return;
        L75:
            switch(r1) {
                case 1002: goto L62;
                case 1003: goto L58;
                case 1004: goto L55;
                case 1005: goto L52;
                default: goto L15;
            };     // Catch: Throwable -> L70
        L52:
            a2.L(this.f7136a, (com.amap.api.location.b) r6.obj);     // Catch: Throwable -> L70
            return;
        L62:
            a2.v(this.f7136a, (com.amap.api.location.b) r6.obj);     // Catch: Throwable -> L70
            return;
        L15:
            switch(r1) {
                case 1014: goto L50;
                case 1015: goto L48;
                case 1016: goto L39;
                case 1017: goto L36;
                case 1018: goto L32;
                default: goto L16;
            };     // Catch: Throwable -> L70
        L16:
            switch(r1) {
                case 1023: goto L30;
                case 1024: goto L28;
                case 1025: goto L25;
                case 1026: goto L22;
                case 1027: goto L20;
                case 1028: goto L18;
                default: goto L77;
            };     // Catch: Throwable -> L70
        L18:
            a2.K(this.f7136a, (AMapLocation) r6.obj);     // Catch: Throwable -> L70
            return;
        L20:
            a2.D(this.f7136a).b();     // Catch: Throwable -> L70
            return;
        L22:
            u4.c();     // Catch: Throwable -> L70
            a2.D(this.f7136a).i(this.f7136a.f7123c);     // Catch: Throwable -> L70
            return;
        L28:
            a2.Y(this.f7136a, r6);     // Catch: Throwable -> L70
            return;
        L30:
            a2.T(this.f7136a, r6);     // Catch: Throwable -> L70
            return;
        L77:
            return;
        L25:
            if (this.f7136a.f7125e.F() == false) goto L27;
            this.f7136a.f7125e.c();     // Catch: Throwable -> L70
            a2 r8 = this.f7136a;     // Catch: Throwable -> L70
            r8.f7125e.k(r8.f7123c);     // Catch: Throwable -> L70
        L27:
            a2.q(this.f7136a, InputDeviceCompat.SOURCE_GAMEPAD, 300000);     // Catch: Throwable -> L70
            return;
        L32:
            a2 r5 = this.f7136a;     // Catch: Throwable -> L70
            AMapLocationClientOption r9 = (AMapLocationClientOption) r6.obj;     // Catch: Throwable -> L70
            r5.f7123c = r9;     // Catch: Throwable -> L70
            if (r9 == null) goto L79;
            a2.l0(r5);     // Catch: Throwable -> L70
            return;
        L79:
            return;
        L36:
            this.f7136a.f7125e.c();     // Catch: Throwable -> L70
            a2.i0(this.f7136a);     // Catch: Throwable -> L70
            return;
        L48:
            a2 r10 = this.f7136a;     // Catch: Throwable -> L70
            r10.f7125e.k(r10.f7123c);     // Catch: Throwable -> L70
            a2.q(this.f7136a, InputDeviceCompat.SOURCE_GAMEPAD, 300000);     // Catch: Throwable -> L70
            return;
        L50:
            a2.J(this.f7136a, r6);     // Catch: Throwable -> L70
            return;
        L39:
            if (a5.e0(a2.O(this.f7136a)) == false) goto L43;
            u4.a();     // Catch: Throwable -> L70
            a2.f0(this.f7136a);     // Catch: Throwable -> L70
            return;
        L43:
            if (this.f7136a.f7125e.v() == false) goto L46;
            a2.q(this.f7136a, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, 1000);     // Catch: Throwable -> L70
            return;
        L46:
            a2.h0(this.f7136a);     // Catch: Throwable -> L70
            return;
        L55:
            a2.c0(this.f7136a);     // Catch: Throwable -> L60
            a2.r(this.f7136a, 14, null);     // Catch: Throwable -> L60
            return;
        L58:
            a2.a0(this.f7136a);     // Catch: Throwable -> L60
            a2.r(this.f7136a, 13, null);     // Catch: Throwable -> L60
            return;
        L60:
            th = th;
            r0 = r6;
        L71:
            if (r0 != 0) goto L73;
            r0 = "handleMessage";
        L73:
            s4.h(th, "AMapLocationManage$MHandlerr", r0);
            return;
        L70:
            th = th;
            goto L71
        }
    }

    static class e extends HandlerThread {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        a2 f7137f;

        public e(String r1, a2 r2) {
            super(r1);
            this.f7137f = null;
            this.f7137f = r2;
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            this.f7137f.f7132l.b();     // Catch: Throwable -> L9
            x4.a(a2.O(this.f7137f));     // Catch: Throwable -> L9
            a2.X(this.f7137f);     // Catch: Throwable -> L9
            a2 r0 = this.f7137f;     // Catch: Throwable -> L9
            if (r0 != null) goto L5;
        L7:
            super.onLooperPrepared();     // Catch: Throwable -> L9
            return;
        L5:
            if (a2.O(r0) == null) goto L7;
            r4.j(a2.O(this.f7137f));     // Catch: Throwable -> L9
            r4.a(a2.O(this.f7137f));     // Catch: Throwable -> L9
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            super.run();     // Catch: Throwable -> L4
            return;
        }
    }

    public class f extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a2 f7138a;

        public f(a2 r1) {
            this.f7138a = r1;
        }

        public f(a2 r1, Looper r2) {
            this.f7138a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r6) {
            String r0 = null;
            super.handleMessage(r6);     // Catch: Throwable -> L59
            a2 r1 = this.f7138a;     // Catch: Throwable -> L59
            if (r1.r == false) goto L6;
            return;
        L6:
            int r2 = r6.what;     // Catch: Throwable -> L59
            if (r2 != 1) goto L10;
            Message r3 = r1.D.obtainMessage();     // Catch: Throwable -> L59
            r3.what = 11;     // Catch: Throwable -> L59
            r3.setData(r6.getData());     // Catch: Throwable -> L59
            this.f7138a.D.sendMessage(r3);     // Catch: Throwable -> L59
            return;
        L10:
            if (r2 == 2) goto L49;
            if (r2 != 13) goto L13;
            ew r7 = r1.f7121a;     // Catch: Throwable -> L59
            if (r7 == null) goto L47;
            a2.u(r1, r7);     // Catch: Throwable -> L59
            return;
        L47:
            AMapLocation r8 = new AMapLocation(SystemBaseLocationImpl.LBS_GEOCODE_NAME);     // Catch: Throwable -> L59
            r8.E0(33);     // Catch: Throwable -> L59
            a2.u(this.f7138a, r8);     // Catch: Throwable -> L59
            return;
        L13:
            switch(r2) {
                case 5: goto L41;
                case 6: goto L37;
                case 7: goto L35;
                case 8: goto L34;
                case 9: goto L33;
                case 10: goto L31;
                default: goto L14;
            };
        L14:
            switch(r2) {
                case 100: goto L22;
                case 101: goto L23;
                case 102: goto L20;
                case 103: goto L16;
                default: goto L74;
            };
        L16:
            Bundle r9 = r6.getData();     // Catch: Throwable -> L59
            if (a2.D(this.f7138a) == null) goto L65;
            a2.D(this.f7138a).f(r9);     // Catch: Throwable -> L59
            return;
        L65:
            return;
        L20:
            Bundle r10 = r6.getData();     // Catch: Throwable -> L59
            r10.putBundle("optBundle", s4.a(this.f7138a.f7123c));     // Catch: Throwable -> L59
            a2.r(this.f7138a, 15, r10);     // Catch: Throwable -> L59
            return;
        L22:
            y4.p(null, 2155);     // Catch: Throwable -> L59
        L23:
            Message r4 = Message.obtain();     // Catch: Throwable -> L59
            r4.what = 1028;     // Catch: Throwable -> L59
            r4.obj = r6.obj;     // Catch: Throwable -> L59
            this.f7138a.D.sendMessage(r4);     // Catch: Throwable -> L59
            if (a2.a(this.f7138a) != null) goto L26;
            return;
        L26:
            if (a2.a(this.f7138a).h() == false) goto L67;
            f r5 = this.f7138a.f7124d;     // Catch: Throwable -> L59
            if (r5 == null) goto L68;
            r5.removeMessages(13);     // Catch: Throwable -> L59
            return;
        L68:
            return;
        L67:
            return;
        L74:
            return;
        L31:
            a2.u(r1, (AMapLocation) r6.obj);     // Catch: Throwable -> L59
            return;
        L33:
            a2.N(r6.getData().getBoolean("installMockApp"));     // Catch: Throwable -> L59
            return;
        L34:
            y4.p(null, 2141);     // Catch: Throwable -> L59
            goto L49
        L35:
            Bundle r11 = r6.getData();     // Catch: Throwable -> L59
            a2.M(this.f7138a, r11.getBoolean("ngpsAble"));     // Catch: Throwable -> L59
            return;
        L37:
            Bundle r12 = r6.getData();     // Catch: Throwable -> L59
            f5 r13 = this.f7138a.f7125e;     // Catch: Throwable -> L59
            if (r13 == null) goto L70;
            r13.h(r12);     // Catch: Throwable -> L59
            return;
        L70:
            return;
        L41:
            Bundle r14 = r6.getData();     // Catch: Throwable -> L59
            r14.putBundle("optBundle", s4.a(this.f7138a.f7123c));     // Catch: Throwable -> L59
            a2.r(this.f7138a, 10, r14);     // Catch: Throwable -> L59
            return;
        L49:
            Message r15 = Message.obtain();     // Catch: Throwable -> L59
            r15.what = 12;     // Catch: Throwable -> L59
            r15.obj = r6.obj;     // Catch: Throwable -> L59
            this.f7138a.D.sendMessage(r15);     // Catch: Throwable -> L59
            if (a2.a(this.f7138a) != null) goto L52;
            return;
        L52:
            if (a2.a(this.f7138a).h() == false) goto L72;
            f r16 = this.f7138a.f7124d;     // Catch: Throwable -> L59
            if (r16 == null) goto L73;
            r16.removeMessages(13);     // Catch: Throwable -> L59
            return;
        L73:
            return;
        L72:
            return;
        L59:
            th = move-exception;
            if (0 != 0) goto L62;
            r0 = "handleMessage";
        L62:
            s4.h(th, "AmapLocationManager$MainHandler", r0);
        }
    }

    static {
        f7120J = new AtomicBoolean(false);
    }

    public a2(Context r4, Intent r5, Looper r6) {
        this.f7123c = new AMapLocationClientOption();
        this.f7125e = null;
        this.f7127g = false;
        this.f7128h = false;
        this.f7129i = new ArrayList();
        this.f7130j = true;
        this.f7131k = true;
        this.m = null;
        this.n = null;
        this.o = null;
        this.q = null;
        this.r = false;
        this.s = AMapLocationClientOption.b.f491h;
        this.t = new Object();
        this.u = null;
        this.v = false;
        this.w = null;
        this.x = new AMapLocationClientOption();
        this.y = null;
        this.z = new b(this);
        this.A = null;
        this.B = false;
        this.C = false;
        this.D = null;
        this.E = null;
        this.F = false;
        this.f7122b = r4;
        this.o = r5;
        F(r6);
    }

    static /* synthetic */ boolean B(a2 r0, boolean r1) {
        r0.f7127g = r1;
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ew C(s3 r14) {
        AMapLocation r1 = null;
        this.f7121a = null;
        eq r2 = new eq();
        r2.j(a5.A());     // Catch: Throwable -> L89
        String r3 = AMapLocationClientOption.f();     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r3) == true) goto L120;
        j5.j(this.f7122b, r3);     // Catch: Throwable -> L8
    L120:
        String r4 = com.amap.api.location.e.a();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r4) == true) goto L16;
        l5.t(r4);     // Catch: Throwable -> L14
    L16:
        x(r14, r2);     // Catch: Throwable -> L89
        boolean r5 = r4.D();     // Catch: Throwable -> L89
        boolean r6 = false;
    L34:
        th = move-exception;
        s4.h(th, "ALManager", "apscach");     // Catch: Throwable -> L89
    L36:
        ew r7 = null;
    L38:
        if (r7 != null) goto L53;
        if (r5 == true) goto L41;
        boolean r8 = true;
    L117:
        r7 = r14.h(r8, r2);     // Catch: Throwable -> L48
        if (r7 == null) goto L47;
        if (r7.U() != 0) goto L47;
        r6 = true;
    L47:
        ew r9 = r7;
        boolean r10 = r6;
        r6 = true;
    L54:
        if (r9 != null) goto L115;
        String r11 = null;
    L113:
    L66:
        th = move-exception;
        s4.h(th, "ALManager", "fixLastLocation");     // Catch: Throwable -> L57
    L125:
        if (this.x.h() == false) goto L103;
        f r12 = this.f7124d;     // Catch: Throwable -> L97
        if (r12 == null) goto L103;
        r12.removeMessages(13);     // Catch: Throwable -> L97
    L103:
        Bundle r13 = new Bundle();     // Catch: Throwable -> L80
        if (r1 == null) goto L76;
        r13.putParcelable("loc", r1);     // Catch: Throwable -> L80
        r13.putString("nb", r9.v1());     // Catch: Throwable -> L80
        r13.putParcelable("statics", r2);     // Catch: Throwable -> L80
    L76:
        j(r13);     // Catch: Throwable -> L80
        if (r10 == false) goto L82;
        y(r14, r9);     // Catch: Throwable -> L80
    L82:
        if (r6 == false) goto L107;
        if (r5 == false) goto L107;
        if (H == true) goto L107;
        H = true;     // Catch: Throwable -> L57
        w(r14);     // Catch: Throwable -> L57
    L107:
        r14.A();     // Catch: Throwable -> L98
        return r9;
    L128:
        return r9;
    L80:
        th = move-exception;
        s4.h(th, "ALManager", "apsLocation:callback");     // Catch: Throwable -> L57
    L57:
        th = th;
        r1 = r9;
    L109:
        s4.h(th, "ALManager", "apsLocation");     // Catch: Throwable -> L94
        r14.A();     // Catch: Throwable -> L100
    L93:
        return r1;
    L94:
        th = move-exception;
        r14.A();     // Catch: Throwable -> L99
    L96:
        throw th;
    L61:
        if (this.f7123c.H() == false) goto L125;
        g5 r15 = this.f7132l;     // Catch: Throwable -> L66
        if (r15 == null) goto L125;
        r1 = r15.a(r1, r11, this.f7123c.z());     // Catch: Throwable -> L66
    L115:
        r11 = r9.v1();     // Catch: Throwable -> L57
        r1 = r9.z();     // Catch: Throwable -> L57
    L48:
        th = move-exception;
        s4.h(th, "ALManager", "apsLocation:doFirstNetLocate");     // Catch: Throwable -> L51
    L51:
        th = th;
        r1 = r7;
        goto L109
    L41:
        r8 = false;
        goto L117
    L53:
        r9 = r7;
        r10 = false;
        goto L54
    L19:
        if (this.x.h() == false) goto L32;
        r7 = c(r14, this.x.h());     // Catch: Throwable -> L34
        if (r7 == null) goto L36;
        if (r4.f(r7.getTime()) == true) goto L38;
        if (this.x.h() == false) goto L36;
        int r16 = this.x.j();     // Catch: Throwable -> L34
        long r17 = a5.f() - r7.getTime();     // Catch: Throwable -> L34
        if (r17 <= 0) goto L36;
        if (r17 >= r16) goto L36;
        this.f7121a = r7;     // Catch: Throwable -> L34
        r7.L0(10);     // Catch: Throwable -> L34
        goto L36
    L32:
        r7 = c(r14, false);     // Catch: Throwable -> L34
    L14:
        th = move-exception;
        s4.h(th, "ALManager", "apsLocation setUmidToken");     // Catch: Throwable -> L89
    L8:
        th = move-exception;
        s4.h(th, "ALManager", "apsLocation setAuthKey");     // Catch: Throwable -> L89
    L89:
        th = th;
        goto L109
    }

    static /* synthetic */ b5 D(a2 r0) {
        return r0.f7126f;
    }

    private void F(Looper r4) {
        if (r4 == null) goto L5;
        this.f7124d = new f(this, r4);     // Catch: Throwable -> L11
    L30:
        this.f7132l = new g5(this.f7122b);     // Catch: Throwable -> L15
    L17:
        e r5 = new e("amapLocManagerThread", this);     // Catch: Throwable -> L19
        this.q = r5;     // Catch: Throwable -> L19
        r5.setPriority(5);     // Catch: Throwable -> L19
        this.q.start();     // Catch: Throwable -> L19
        this.D = b(this.q.getLooper());     // Catch: Throwable -> L19
    L33:
        this.f7125e = new f5(this.f7122b, this.f7124d);     // Catch: Throwable -> L23
        this.f7126f = new b5(this.f7122b, this.f7124d);     // Catch: Throwable -> L23
    L26:
        if (this.u != null) goto L28;
        this.u = new y4();
    L28:
        g(this.f7122b);
        return;
    L23:
        th = move-exception;
        s4.h(th, "ALManager", "init 3");
        goto L26
    L15:
        th = move-exception;
        s4.h(th, "ALManager", "init 2");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        s4.h(th, "ALManager", "init 5");
        goto L33
    L5:
        if (Looper.myLooper() != null) goto L8;
        f r6 = new f(this, this.f7122b.getMainLooper());     // Catch: Throwable -> L11
    L7:
        this.f7124d = r6;     // Catch: Throwable -> L11
        goto L30
    L8:
        r6 = new f(this);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        s4.h(th, "ALManager", "init 1");
        goto L30
    }

    private void G(Message r5) {
        AMapLocation r6 = (AMapLocation) r5.obj;     // Catch: Throwable -> L12
        if (this.f7130j == true) goto L5;
    L10:
        m(r6, null);     // Catch: Throwable -> L12
        d(InputDeviceCompat.SOURCE_GAMEPAD);     // Catch: Throwable -> L12
        f(InputDeviceCompat.SOURCE_GAMEPAD, null, 300000);     // Catch: Throwable -> L12
        return;
    L5:
        if (this.m == null) goto L10;
        Bundle r0 = new Bundle();     // Catch: Throwable -> L12
        r0.putBundle("optBundle", s4.a(this.f7123c));     // Catch: Throwable -> L12
        e(0, r0);     // Catch: Throwable -> L12
        if (this.f7128h == false) goto L9;
        e(13, null);     // Catch: Throwable -> L12
    L9:
        this.f7130j = false;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        s4.h(th, "ALManager", "resultGpsLocationSuccess");
    }

    private static void H(AMapLocation r4) {
        if (r4 != null) goto L14;
        return;
    L14:
        if (2 != r4.Y()) goto L8;
    L9:
        long r0 = r4.getTime();     // Catch: Throwable -> L13
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L13
        if (r2 <= r0) goto L17;
        r4.setTime(r2);     // Catch: Throwable -> L13
        return;
    L17:
        return;
    L8:
        if (4 == r4.Y()) goto L9;
        return;
    }

    static /* synthetic */ void J(a2 r0, Message r1) {
        r0.k(r1);
    }

    static /* synthetic */ void K(a2 r0, AMapLocation r1) {
        r0.e0(r1);
    }

    static /* synthetic */ void L(a2 r0, com.amap.api.location.b r1) {
        r0.W(r1);
    }

    static /* synthetic */ boolean M(a2 r0, boolean r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ boolean N(boolean r0) {
        I = r0;
        return r0;
    }

    static /* synthetic */ Context O(a2 r0) {
        return r0.f7122b;
    }

    private void Q(Message r5) {
        if (r5 != null) goto L13;
        return;
    L13:
        Bundle r6 = r5.getData();     // Catch: Throwable -> L10
        if (r6 != null) goto L8;
        return;
    L8:
        int r2 = r6.getInt("i", 0);     // Catch: Throwable -> L10
        Notification r7 = (Notification) r6.getParcelable("h");     // Catch: Throwable -> L10
        Intent r3 = s0();     // Catch: Throwable -> L10
        r3.putExtra("i", r2);     // Catch: Throwable -> L10
        r3.putExtra("h", r7);     // Catch: Throwable -> L10
        r3.putExtra("g", 1);     // Catch: Throwable -> L10
        i(r3, true);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        s4.h(th, "ALManager", "doEnableBackgroundLocation");
    }

    private void R(AMapLocation r8) {
        if (r8 == null) goto L38;
        String r0 = r8.X();     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r0) == false) goto L6;
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L34
    L7:
        boolean r2 = a5.M(this.f7122b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF");     // Catch: Throwable -> L34
        boolean r3 = a5.M(this.f7122b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF");     // Catch: Throwable -> L34
        boolean r4 = a5.M(this.f7122b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==");     // Catch: Throwable -> L34
        boolean r5 = a5.M(this.f7122b, "EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=");     // Catch: Throwable -> L34
        boolean r6 = a5.M(this.f7122b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O");     // Catch: Throwable -> L34
        boolean r7 = a5.M(this.f7122b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=");     // Catch: Throwable -> L34
        if (r2 == false) goto L10;
        String r9 = "#pm1";
    L11:
        r1.append(r9);     // Catch: Throwable -> L34
        String r10 = LocationInfoConst.ALLOW_USE_LOCATION;
        if (r3 == false) goto L15;
        String r11 = LocationInfoConst.ALLOW_USE_LOCATION;
    L16:
        r1.append(r11);     // Catch: Throwable -> L34
        if (r4 == false) goto L19;
        String r12 = LocationInfoConst.ALLOW_USE_LOCATION;
    L20:
        r1.append(r12);     // Catch: Throwable -> L34
        if (r5 == false) goto L23;
        String r13 = LocationInfoConst.ALLOW_USE_LOCATION;
    L24:
        r1.append(r13);     // Catch: Throwable -> L34
        if (r6 == false) goto L27;
        String r14 = LocationInfoConst.ALLOW_USE_LOCATION;
    L28:
        r1.append(r14);     // Catch: Throwable -> L34
        if (r7 == true) goto L32;
        r10 = BDLocationException.ERROR_TIMEOUT;
    L32:
        r1.append(r10);     // Catch: Throwable -> L34
        r8.J0(r1.toString());     // Catch: Throwable -> L34
        return;
    L27:
        r14 = BDLocationException.ERROR_TIMEOUT;
        goto L28
    L23:
        r13 = BDLocationException.ERROR_TIMEOUT;
        goto L24
    L19:
        r12 = BDLocationException.ERROR_TIMEOUT;
        goto L20
    L15:
        r11 = BDLocationException.ERROR_TIMEOUT;
        goto L16
    L10:
        r9 = "#pm0";
        goto L11
    L6:
        r1 = new StringBuilder(r0);     // Catch: Throwable -> L34
    L34:
        u4.c();
        return;
    }

    private void S(com.amap.api.location.b r2) {
        if (r2 == null) goto L11;
        if (this.f7129i != null) goto L7;
        this.f7129i = new ArrayList();
    L7:
        if (this.f7129i.contains(r2) == true) goto L12;
        this.f7129i.add(r2);
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("listener参数不能为null");
    }

    static /* synthetic */ void T(a2 r0, Message r1) {
        r0.Q(r1);
    }

    private void U(Message r3) {
        if (r3 != null) goto L13;
        return;
    L13:
        Bundle r4 = r3.getData();     // Catch: Throwable -> L10
        if (r4 != null) goto L8;
        return;
    L8:
        boolean r5 = r4.getBoolean("j", true);     // Catch: Throwable -> L10
        Intent r1 = s0();     // Catch: Throwable -> L10
        r1.putExtra("j", r5);     // Catch: Throwable -> L10
        r1.putExtra("g", 2);     // Catch: Throwable -> L10
        i(r1, false);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        s4.h(th, "ALManager", "doDisableBackgroundLocation");
    }

    private void V(AMapLocation r3) {
        Message r0 = this.f7124d.obtainMessage();
        r0.what = 10;
        r0.obj = r3;
        this.f7124d.sendMessage(r0);
    }

    private void W(com.amap.api.location.b r2) {
        if (this.f7129i.isEmpty() == true) goto L8;
        if (this.f7129i.contains(r2) == false) goto L8;
        this.f7129i.remove(r2);
    L8:
        if (this.f7129i.isEmpty() == false) goto L11;
        n0();
        return;
    }

    static /* synthetic */ void X(a2 r0) {
        r0.r0();
    }

    static /* synthetic */ void Y(a2 r0, Message r1) {
        r0.U(r1);
    }

    private synchronized void Z(AMapLocation r4) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            monitor-enter(r3)
            if (r4 != 0) goto L14
            com.amap.api.location.AMapLocation r4 = new com.amap.api.location.AMapLocation     // Catch: java.lang.Throwable -> Lab
            java.lang.String r0 = ""
            r4.<init>(r0)     // Catch: java.lang.Throwable -> Lab
            r0 = 8
            r4.E0(r0)     // Catch: java.lang.Throwable -> Lab
            java.lang.String r0 = "coarse amapLocation is null#2005"
            r4.J0(r0)     // Catch: java.lang.Throwable -> Lab
        L14:
            com.amap.api.location.c r0 = r3.A     // Catch: java.lang.Throwable -> Lab
            if (r0 != 0) goto L1f
            com.amap.api.location.c r0 = new com.amap.api.location.c     // Catch: java.lang.Throwable -> Lab
            r0.<init>()     // Catch: java.lang.Throwable -> Lab
            r3.A = r0     // Catch: java.lang.Throwable -> Lab
        L1f:
            com.amap.api.location.c r0 = r3.A     // Catch: java.lang.Throwable -> Lab
            com.amap.api.location.AMapLocationClientOption r1 = r3.f7123c     // Catch: java.lang.Throwable -> Lab
            com.amap.api.location.AMapLocationClientOption$b r1 = r1.B()     // Catch: java.lang.Throwable -> Lab
            r0.f(r1)     // Catch: java.lang.Throwable -> Lab
            com.loc.b5 r0 = r3.f7126f     // Catch: java.lang.Throwable -> Lab
            if (r0 == 0) goto L42
            com.amap.api.location.c r0 = r3.A     // Catch: java.lang.Throwable -> Lab
            int r1 = r4.d0()     // Catch: java.lang.Throwable -> Lab
            r0.c(r1)     // Catch: java.lang.Throwable -> Lab
            com.amap.api.location.c r0 = r3.A     // Catch: java.lang.Throwable -> Lab
            com.loc.b5 r1 = r3.f7126f     // Catch: java.lang.Throwable -> Lab
            int r1 = r1.n()     // Catch: java.lang.Throwable -> Lab
            r0.d(r1)     // Catch: java.lang.Throwable -> Lab
        L42:
            android.content.Context r0 = r3.f7122b     // Catch: java.lang.Throwable -> Lab
            boolean r0 = com.loc.a5.X(r0)     // Catch: java.lang.Throwable -> Lab
            com.amap.api.location.c r1 = r3.A     // Catch: java.lang.Throwable -> Lab
            r1.j(r0)     // Catch: java.lang.Throwable -> Lab
            com.amap.api.location.c r0 = r3.A     // Catch: java.lang.Throwable -> Lab
            android.content.Context r1 = r3.f7122b     // Catch: java.lang.Throwable -> Lab
            java.lang.String r1 = com.loc.a5.Y(r1)     // Catch: java.lang.Throwable -> Lab
            r0.i(r1)     // Catch: java.lang.Throwable -> Lab
            com.amap.api.location.c r0 = r3.A     // Catch: java.lang.Throwable -> Lab
            r1 = 0
            r0.h(r1)     // Catch: java.lang.Throwable -> Lab
            com.amap.api.location.c r0 = r3.A     // Catch: java.lang.Throwable -> Lab
            boolean r1 = com.loc.a2.I     // Catch: java.lang.Throwable -> Lab
            r0.e(r1)     // Catch: java.lang.Throwable -> Lab
            com.amap.api.location.c r0 = r3.A     // Catch: java.lang.Throwable -> Lab
            r4.K0(r0)     // Catch: java.lang.Throwable -> Lab
            boolean r0 = r3.f7128h     // Catch: java.lang.Throwable -> L8e
            if (r0 == 0) goto L96
            android.content.Context r0 = r3.f7122b     // Catch: java.lang.Throwable -> L8e
            com.loc.y4.h(r0, r4)     // Catch: java.lang.Throwable -> L8e
            com.amap.api.location.AMapLocation r0 = r4.z()     // Catch: java.lang.Throwable -> L8e
            r3.V(r0)     // Catch: java.lang.Throwable -> L8e
            android.content.Context r0 = r3.f7122b     // Catch: java.lang.Throwable -> L8e
            com.loc.x4 r0 = com.loc.x4.a(r0)     // Catch: java.lang.Throwable -> L8e
            r0.c(r4)     // Catch: java.lang.Throwable -> L8e
            android.content.Context r4 = r3.f7122b     // Catch: java.lang.Throwable -> L8e
            com.loc.x4 r4 = com.loc.x4.a(r4)     // Catch: java.lang.Throwable -> L8e
            r4.d()     // Catch: java.lang.Throwable -> L8e
            goto L96
        L8e:
            r4 = move-exception
            java.lang.String r0 = "ALManager"
            java.lang.String r1 = "handlerCoarseLocation part"
            com.loc.s4.h(r4, r0, r1)     // Catch: java.lang.Throwable -> Lab
        L96:
            boolean r4 = r3.r     // Catch: java.lang.Throwable -> Lab
            if (r4 == 0) goto L9c
            monitor-exit(r3)
            return
        L9c:
            com.loc.b5 r4 = r3.f7126f     // Catch: java.lang.Throwable -> Lab
            if (r4 == 0) goto La3
            r3.n0()     // Catch: java.lang.Throwable -> Lab
        La3:
            r4 = 14
            r0 = 0
            r3.e(r4, r0)     // Catch: java.lang.Throwable -> Lab
            monitor-exit(r3)
            return
        Lab:
            r4 = move-exception
            java.lang.String r0 = "ALManager"
            java.lang.String r1 = "handlerCoarseLocation part2"
            com.loc.s4.h(r4, r0, r1)     // Catch: java.lang.Throwable -> Lb5
            monitor-exit(r3)
            return
        Lb5:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.a2.Z(com.amap.api.location.AMapLocation):void");
    }

    static /* synthetic */ AMapLocationClientOption a(a2 r0) {
        return r0.x;
    }

    static /* synthetic */ void a0(a2 r0) {
        r0.k0();
    }

    private d b(Looper r3) {
        Object r0 = this.t;
        monitor-enter(r0);
        d r1 = new d(this, r3);     // Catch: Throwable -> L7
        this.D = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void b0(AMapLocation r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        AMapLocation r0 = null;
        j4 r1 = g5.f7337g;     // Catch: Throwable -> L13
        if (r1 != null) goto L10;
        g5 r2 = this.f7132l;     // Catch: Throwable -> L13
        if (r2 == null) goto L11;
        r0 = r2.d();     // Catch: Throwable -> L13
    L11:
        y4.o(r0, r3);     // Catch: Throwable -> L13
        return;
    L10:
        r0 = r1.a();     // Catch: Throwable -> L13
    }

    private ew c(s3 r1, boolean r2) {
        if (this.f7123c.H() == false) goto L12;
        return r1.g(r2);
    L6:
        th = move-exception;
        s4.h(th, "ALManager", "doFirstCacheLoc");
        return null;
    L12:
        return null;
    }

    static /* synthetic */ void c0(a2 r0) {
        r0.n0();
    }

    private void d(int r2) {
        Object r0 = this.t;
        monitor-enter(r0);
        d r1 = this.D;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.removeMessages(r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void e(int r3, Bundle r4) {
        if (r4 != null) goto L5;
        r4 = new Bundle();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if ((th instanceof IllegalStateException) == true) goto L15;
    L17:
        boolean r5 = false;
    L19:
        if ((th instanceof RemoteException) == true) goto L21;
        if (r5 == true) goto L21;
    L22:
        s4.h(th, "ALManager", "sendLocMessage");
        return;
    L21:
        this.m = null;
        this.f7127g = false;
        goto L22
    L15:
        if (th.getMessage().contains("sending message to a Handler on a dead thread") == false) goto L17;
        r5 = true;
    L5:
        if (TextUtils.isEmpty(this.y) == false) goto L7;
        this.y = s4.o(this.f7122b);     // Catch: Throwable -> L11
    L7:
        r4.putString("c", this.y);     // Catch: Throwable -> L11
        Message r0 = Message.obtain();     // Catch: Throwable -> L11
        r0.what = r3;     // Catch: Throwable -> L11
        r0.setData(r4);     // Catch: Throwable -> L11
        r0.replyTo = this.n;     // Catch: Throwable -> L11
        Messenger r6 = this.m;     // Catch: Throwable -> L11
        if (r6 == null) goto L26;
        r6.send(r0);     // Catch: Throwable -> L11
        return;
    }

    private void e0(AMapLocation r4) {
    L12:
        th = move-exception;
        s4.h(th, "ALManager", "resultGpsLocationSuccess");
        return;
    L3:
        if (this.f7131k == true) goto L5;
    L10:
        Z(r4);     // Catch: Throwable -> L12
        return;
    L5:
        if (this.m == null) goto L10;
        Bundle r0 = new Bundle();     // Catch: Throwable -> L12
        r0.putBundle("optBundle", s4.a(this.f7123c));     // Catch: Throwable -> L12
        e(0, r0);     // Catch: Throwable -> L12
        if (this.f7128h == false) goto L9;
        e(13, null);     // Catch: Throwable -> L12
    L9:
        this.f7131k = false;     // Catch: Throwable -> L12
        goto L10
    }

    private void f(int r3, Object r4, long r5) {
        Object r0 = this.t;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.D == null) goto L11;
        Message r1 = Message.obtain();     // Catch: Throwable -> L13
        r1.what = r3;     // Catch: Throwable -> L13
        if ((r4 instanceof Bundle) == false) goto L9;
        r1.setData((Bundle) r4);     // Catch: Throwable -> L13
    L10:
        this.D.sendMessageDelayed(r1, r5);     // Catch: Throwable -> L13
        goto L11
    L9:
        r1.obj = r4;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    static /* synthetic */ void f0(a2 r0) {
        r0.t0();
    }

    private static void g(Context r3) {
        if (f7120J.compareAndSet(false, true) == false) goto L6;
        r1.f().d(new a(r3));
        return;
    }

    private void g0() {
        Object r0 = this.t;
        monitor-enter(r0);
        d r1 = this.D;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        r1.removeCallbacksAndMessages(null);     // Catch: Throwable -> L10
    L7:
        this.D = null;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void h(Intent r3) {
        this.f7122b.bindService(r3, this.z, 1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s4.h(th, "ALManager", "startServiceImpl");
    }

    static /* synthetic */ void h0(a2 r0) {
        r0.p0();
    }

    private void i(Intent r6, boolean r7) {
        Context r0 = this.f7122b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L14;
        if (r7 == false) goto L14;
        if (v0() == true) goto L17;
        Log.e("amapapi", "-------------调用后台定位服务，缺少权限：android.permission.FOREGROUND_SERVICE--------------");
        return;
    L17:
        this.f7122b.getClass().getMethod("startForegroundService", new Class[]{Intent.class}).invoke(this.f7122b, new Object[]{r6});     // Catch: Throwable -> L13
    L15:
        this.F = true;
        return;
    L13:
        this.f7122b.startService(r6);
    L14:
        r0.startService(r6);
        goto L15
    }

    static /* synthetic */ void i0(a2 r1) {
        r1.d(InputDeviceCompat.SOURCE_GAMEPAD);
    }

    private void j(Bundle r5) {
        AMapLocation r0 = null;
        if (r5 != null) goto L25;
        eq r6 = null;
        AMapLocation r1 = null;
    L16:
        f5 r2 = this.f7125e;     // Catch: Throwable -> L21
        if (r2 == null) goto L20;
        r0 = r2.b(r1, this.E);     // Catch: Throwable -> L21
    L23:
        m(r0, r6);
        return;
    L21:
        th = th;
    L22:
        s4.h(th, "AmapLocationManager", "resultLbsLocationSuccess");
        goto L23
    L20:
        r0 = r1;
        goto L23
    L25:
        r5.setClassLoader(AMapLocation.class.getClassLoader());     // Catch: Throwable -> L13
        r1 = (AMapLocation) r5.getParcelable("loc");     // Catch: Throwable -> L13
        this.E = r5.getString("nb");     // Catch: Throwable -> L13
        r6 = (eq) r5.getParcelable("statics");     // Catch: Throwable -> L13
        if (r1 == null) goto L16;
        if (r1.U() != 0) goto L16;
        f5 r3 = this.f7125e;     // Catch: Throwable -> L21
        if (r3 == null) goto L16;
        r3.x();     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r1.K()) == true) goto L16;
        f5.f7286J = r1;     // Catch: Throwable -> L21
    L13:
        th = th;
        r6 = null;
        goto L22
    }

    private boolean j0() {
        boolean r0 = false;
        int r1 = 0;
    L27:
    L18:
        th = move-exception;
        s4.h(th, "ALManager", "checkAPSManager");
    L20:
        if (r0 == false) goto L22;
    L26:
        return r0;
    L22:
        if (a5.c0(this.f7122b.getApplicationContext()) == true) goto L24;
        int r6 = 2103;
    L25:
        y4.p(null, r6);
        goto L26
    L24:
        r6 = 2101;
        goto L25
    L5:
        if (this.m != null) goto L9;
        Thread.sleep(100);     // Catch: Throwable -> L18
        r1 = r1 + 1;     // Catch: Throwable -> L18
        if (r1 < 50) goto L27;
    L9:
        if (this.m != null) goto L17;
        Message r2 = Message.obtain();     // Catch: Throwable -> L18
        Bundle r3 = new Bundle();     // Catch: Throwable -> L18
        AMapLocation r4 = new AMapLocation("");     // Catch: Throwable -> L18
        r4.E0(10);     // Catch: Throwable -> L18
        if (a5.c0(this.f7122b.getApplicationContext()) == true) goto L14;
        String r5 = "请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003";
    L13:
        r4.J0(r5);     // Catch: Throwable -> L18
        r3.putParcelable("loc", r4);     // Catch: Throwable -> L18
        r2.setData(r3);     // Catch: Throwable -> L18
        r2.what = 1;     // Catch: Throwable -> L18
        this.f7124d.sendMessage(r2);     // Catch: Throwable -> L18
        goto L20
    L14:
        r5 = "启动ApsServcie失败#1001";
        goto L13
    L17:
        r0 = true;
        goto L20
    }

    private void k(Message r3) {
        Bundle r4 = r3.getData();     // Catch: Throwable -> L6
        AMapLocation r0 = (AMapLocation) r4.getParcelable("loc");     // Catch: Throwable -> L6
        String r5 = r4.getString("lastLocNb");     // Catch: Throwable -> L6
        b0(r0);     // Catch: Throwable -> L6
        if (this.f7132l.c(r0, r5) == false) goto L11;
        this.f7132l.f();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        s4.h(th, "ALManager", "doSaveLastLocation");
    }

    private synchronized void k0() {
        monitor-enter(this);
        int r0 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L73
        if (r0 >= 29) goto L12;
        if (r0 < 23) goto L12;
        if (a5.M(this.f7122b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") == true) goto L12;
        if (a5.M(this.f7122b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O") == true) goto L12;
    L31:
        m0();     // Catch: Throwable -> L73
        monitor-exit(this);
        return;
    L12:
        if (r0 >= 31) goto L18;
        if (r0 < 29) goto L18;
        if (this.f7122b.getApplicationInfo().targetSdkVersion < 29) goto L18;
        if (a5.M(this.f7122b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O") == false) goto L31;
    L18:
        if (r0 >= 31) goto L26;
        if (r0 < 29) goto L26;
        if (this.f7122b.getApplicationInfo().targetSdkVersion >= 29) goto L26;
        if (a5.M(this.f7122b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") == true) goto L26;
        if (a5.M(this.f7122b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O") == false) goto L31;
    L26:
        if (r0 < 31) goto L35;
        if (a5.M(this.f7122b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") == true) goto L35;
        if (a5.M(this.f7122b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O") == false) goto L31;
    L35:
        if (this.f7123c != null) goto L38;
        this.f7123c = new AMapLocationClientOption();     // Catch: Throwable -> L73
    L38:
        if (this.f7128h == false) goto L42;
        monitor-exit(this);
        return;
    L42:
        this.f7128h = true;     // Catch: Throwable -> L73
        int r1 = c.f7135a[this.f7123c.B().ordinal()];     // Catch: Throwable -> L73
        long r5 = 0;
        if (r1 != 1) goto L45;
        f(1027, null, 0);     // Catch: Throwable -> L73
        f(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, null, 0);     // Catch: Throwable -> L73
        f(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null, 0);     // Catch: Throwable -> L73
        monitor-exit(this);
        return;
    L45:
        if (r1 == 2) goto L63;
        if (r1 == 3) goto L50;
    L60:
        monitor-exit(this);
        return;
    L50:
        if (a5.e0(this.f7122b) == false) goto L54;
        d(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);     // Catch: Throwable -> L73
        f(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, null, 0);     // Catch: Throwable -> L73
        f(1026, null, 0);     // Catch: Throwable -> L73
        monitor-exit(this);
        return;
    L54:
        f(1027, null, 0);     // Catch: Throwable -> L73
        f(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, null, 0);     // Catch: Throwable -> L73
        if (this.f7123c.F() == true) goto L57;
    L59:
        f(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null, r5);     // Catch: Throwable -> L73
        goto L60
    L57:
        if (this.f7123c.N() == false) goto L59;
        r5 = this.f7123c.v();     // Catch: Throwable -> L73
        goto L59
    L63:
        if (a5.e0(this.f7122b) == false) goto L67;
        d(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);     // Catch: Throwable -> L73
        f(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, null, 0);     // Catch: Throwable -> L73
        f(1026, null, 0);     // Catch: Throwable -> L73
        monitor-exit(this);
        return;
    L67:
        d(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);     // Catch: Throwable -> L73
        f(1027, null, 0);     // Catch: Throwable -> L73
        f(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, null, 0);     // Catch: Throwable -> L73
        monitor-exit(this);
        return;
    L73:
        th = move-exception;
        throw th;
    }

    private void l(AMapLocation r9) {
        if (r9.U() == 0) goto L6;
        r9.L0(0);     // Catch: Throwable -> L32
    L6:
        if (r9.U() != 0) goto L21;
        double r2 = r9.getLatitude();     // Catch: Throwable -> L32
        double r4 = r9.getLongitude();     // Catch: Throwable -> L32
        if (r2 != 0.0d) goto L12;
        if (r4 != 0.0d) goto L12;
    L19:
        y4.q("errorLatLng", r9.V0());     // Catch: Throwable -> L32
        r9.L0(0);     // Catch: Throwable -> L32
        r9.E0(8);     // Catch: Throwable -> L32
        r9.J0("LatLng is error#0802");     // Catch: Throwable -> L32
    L12:
        if (r2 < (-90.0d)) goto L19;
        if (r2 > 90.0d) goto L19;
        if (r4 < (-180.0d)) goto L19;
        if (r4 > 180.0d) goto L19;
    L21:
        if ("gps".equalsIgnoreCase(r9.getProvider()) == false) goto L23;
    L24:
        r9.setAltitude(a5.H(r9.getAltitude()));     // Catch: Throwable -> L32
        r9.setBearing(a5.b(r9.getBearing()));     // Catch: Throwable -> L32
        r9.setSpeed(a5.b(r9.getSpeed()));     // Catch: Throwable -> L32
        R(r9);     // Catch: Throwable -> L32
        H(r9);     // Catch: Throwable -> L32
        Iterator<com.amap.api.location.b> r8 = this.f7129i.iterator();     // Catch: Throwable -> L32
    L25:
        if (r8.hasNext() == false) goto L41;
        r8.next().onLocationChanged(r9);     // Catch: Throwable -> L31
        goto L25
    L41:
        return;
    L23:
        if (this.f7125e.v() == false) goto L24;
        return;
    }

    static /* synthetic */ void l0(a2 r0) {
        r0.u0();
    }

    private synchronized void m(AMapLocation r4, eq r5) {
        monitor-enter(this);
        if (r4 != null) goto L6;
        r4 = new AMapLocation("");     // Catch: Throwable -> L40
        r4.E0(8);     // Catch: Throwable -> L40
        r4.J0("amapLocation is null#0801");     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        s4.h(th, "ALManager", "handlerLocation part3");     // Catch: Throwable -> L44
        return;
    L44:
        th = move-exception;
        throw th;
    L6:
        if ("gps".equalsIgnoreCase(r4.getProvider()) == true) goto L9;
        r4.setProvider("lbs");     // Catch: Throwable -> L40
    L9:
        if (this.A != null) goto L11;
        this.A = new com.amap.api.location.c();     // Catch: Throwable -> L40
    L11:
        this.A.f(this.f7123c.B());     // Catch: Throwable -> L40
        f5 r0 = this.f7125e;     // Catch: Throwable -> L40
        if (r0 == null) goto L14;
        this.A.c(r0.C());     // Catch: Throwable -> L40
        this.A.d(this.f7125e.A());     // Catch: Throwable -> L40
    L14:
        boolean r1 = a5.X(this.f7122b);     // Catch: Throwable -> L40
        this.A.j(r1);     // Catch: Throwable -> L40
        this.A.i(a5.Y(this.f7122b));     // Catch: Throwable -> L40
        if (r4.Y() != 1) goto L17;
    L18:
        this.A.h(0);     // Catch: Throwable -> L40
    L19:
        if (r5 == null) goto L21;
        this.A.h(r5.b());     // Catch: Throwable -> L40
    L21:
        this.A.e(I);     // Catch: Throwable -> L40
        r4.K0(this.A);     // Catch: Throwable -> L40
    L29:
        th = move-exception;
        s4.h(th, "ALManager", "handlerLocation part2");     // Catch: Throwable -> L40
    L32:
        if (this.r == false) goto L36;
        monitor-exit(this);
        return;
    L36:
        if (this.f7123c.N() == false) goto L38;
        n0();     // Catch: Throwable -> L40
        e(14, null);     // Catch: Throwable -> L40
    L38:
        monitor-exit(this);
        return;
    L23:
        if (this.f7128h == false) goto L32;
        n(r4, this.E);     // Catch: Throwable -> L29
        if (r5 == null) goto L27;
        r5.q(a5.A());     // Catch: Throwable -> L29
    L27:
        y4.i(this.f7122b, r4, r5);     // Catch: Throwable -> L29
        y4.h(this.f7122b, r4);     // Catch: Throwable -> L29
        V(r4.z());     // Catch: Throwable -> L29
        x4.a(this.f7122b).c(r4);     // Catch: Throwable -> L29
        x4.a(this.f7122b).d();     // Catch: Throwable -> L29
    L17:
        if ("gps".equalsIgnoreCase(r4.getProvider()) == false) goto L19;
        goto L18
    }

    private void m0() {
        AMapLocation r0 = new AMapLocation("");
        r0.E0(12);
        r0.J0("定位权限被禁用,请授予应用定位权限 #1201");
        if (this.A != null) goto L5;
        this.A = new com.amap.api.location.c();
    L5:
        com.amap.api.location.c r1 = new com.amap.api.location.c();
        this.A = r1;
        r1.d(4);
        this.A.c(0);
        this.A.f(this.f7123c.B());
        this.A.j(a5.X(this.f7122b));
        this.A.i(a5.Y(this.f7122b));
        this.A.h(0);
        r0.K0(this.A);
        y4.p(null, 2121);
        V(r0);
    }

    private void n(AMapLocation r4, String r5) {
        Bundle r0 = new Bundle();
        r0.putParcelable("loc", r4);
        r0.putString("lastLocNb", r5);
        f(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, r0, 0);
    }

    private void n0() {
        d(InputDeviceCompat.SOURCE_GAMEPAD);     // Catch: Throwable -> L11
        f5 r0 = this.f7125e;     // Catch: Throwable -> L11
        if (r0 == null) goto L6;
        r0.c();     // Catch: Throwable -> L11
    L6:
        b5 r1 = this.f7126f;     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        r1.b();     // Catch: Throwable -> L11
    L9:
        d(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);     // Catch: Throwable -> L11
        this.f7128h = false;     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        s4.h(th, "ALManager", "stopLocation");
    }

    private void o0() {
        ew r0 = C(new s3(true));
        if (j0() == false) goto L16;
        Bundle r1 = new Bundle();
        if (r0 != null) goto L7;
    L11:
        String r2 = BDLocationException.ERROR_TIMEOUT;
    L12:
        r1.putBundle("optBundle", s4.a(this.f7123c));
        r1.putString("isCacheLoc", r2);
        e(0, r1);
        if (this.f7128h == false) goto L17;
        e(13, null);
        return;
    L17:
        return;
    L7:
        if (r0.Y() != 2) goto L9;
    L10:
        r2 = LocationInfoConst.ALLOW_USE_LOCATION;
        goto L12
    L9:
        if (r0.Y() != 4) goto L11;
    }

    private void p0() {
    L30:
        th = move-exception;
        s4.h(th, "ALManager", "doLBSLocation");     // Catch: Throwable -> L36
        if (this.f7123c.N() == true) goto L57;
        q0();     // Catch: Throwable -> L42
        return;
    L57:
        return;
    L58:
        return;
    L36:
        th = move-exception;
        if (this.f7123c.N() == true) goto L40;
        q0();     // Catch: Throwable -> L43
    L40:
        throw th;
    L4:
        if (G == false) goto L6;
    L25:
        G = false;     // Catch: Throwable -> L30
        this.C = true;     // Catch: Throwable -> L30
        o0();     // Catch: Throwable -> L30
    L48:
        if (this.f7123c.N() == true) goto L55;
        q0();     // Catch: Throwable -> L41
        return;
    L55:
        return;
    L56:
        return;
    L6:
        if (this.v == false) goto L8;
    L44:
    L18:
        th = move-exception;
        this.B = true;     // Catch: Throwable -> L30
        s4.h(th, "ALManager", "doLBSLocation reStartService");     // Catch: Throwable -> L30
    L21:
        if (j0() == false) goto L48;
        this.B = false;     // Catch: Throwable -> L30
        Bundle r1 = new Bundle();     // Catch: Throwable -> L30
        r1.putBundle("optBundle", s4.a(this.f7123c));     // Catch: Throwable -> L30
        r1.putString("d", com.amap.api.location.e.a());     // Catch: Throwable -> L30
        if (this.f7125e.v() == true) goto L48;
        e(1, r1);     // Catch: Throwable -> L30
        goto L48
    L11:
        if (this.v == false) goto L21;
        if (A() == true) goto L21;
        if (this.B == true) goto L21;
        this.B = true;     // Catch: Throwable -> L18
        r0();     // Catch: Throwable -> L18
    L8:
        if (this.C == true) goto L44;
        goto L25
    }

    static /* synthetic */ void q(a2 r1, int r2, long r3) {
        r1.f(r2, null, r3);
    }

    private void q0() {
        if (this.f7123c.B() == AMapLocationClientOption.b.f490g) goto L10;
        long r4 = 1000;
        if (this.f7123c.y() < 1000) goto L8;
        r4 = this.f7123c.y();
    L8:
        f(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null, r4);
        return;
    }

    static /* synthetic */ void r(a2 r0, int r1, Bundle r2) {
        r0.e(r1, r2);
    }

    private void r0() {
        if (this.n != null) goto L5;
        this.n = new Messenger(this.f7124d);     // Catch: Throwable -> L7
    L5:
        h(s0());     // Catch: Throwable -> L7
        return;
    }

    static /* synthetic */ void s(a2 r0, Bundle r1) {
        r0.j(r1);
    }

    private Intent s0() {
        if (this.o != null) goto L14;
        this.o = new Intent(this.f7122b, APSService.class);
    L14:
    L10:
        th = move-exception;
        s4.h(th, "ALManager", "startServiceImpl p2");
        String r0 = "";
    L12:
        this.o.putExtra("a", r0);
        this.o.putExtra("b", i5.g(this.f7122b));
        this.o.putExtra("d", com.amap.api.location.e.a());
        return this.o;
    L6:
        if (TextUtils.isEmpty(AMapLocationClientOption.f()) == true) goto L8;
        r0 = AMapLocationClientOption.f();     // Catch: Throwable -> L10
        goto L12
    L8:
        r0 = i5.j(this.f7122b);     // Catch: Throwable -> L10
        goto L12
    }

    static /* synthetic */ void t(a2 r0, Message r1) {
        r0.G(r1);
    }

    private void t0() {
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L4
        new eq().y("#2001");     // Catch: Throwable -> L4
        r0.append("模糊权限下不支持低功耗定位#2001");     // Catch: Throwable -> L4
        y4.p(null, 2153);     // Catch: Throwable -> L4
        ew r1 = new ew("");     // Catch: Throwable -> L4
        r1.E0(20);     // Catch: Throwable -> L4
        r1.J0(r0.toString());     // Catch: Throwable -> L4
        e0(r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s4.h(th, "ALManager", "apsLocation:callback");
    }

    static /* synthetic */ void u(a2 r0, AMapLocation r1) {
        r0.l(r1);
    }

    private void u0() {
        this.f7125e.u(this.f7123c);
        this.f7126f.q(this.f7123c);
        if (this.f7128h == true) goto L5;
    L7:
        this.s = this.f7123c.B();
        if (this.u != null) goto L10;
        return;
    L10:
        if (this.f7123c.N() == false) goto L12;
        y4 r0 = this.u;
        Context r1 = this.f7122b;
        int r2 = 0;
    L13:
        r0.d(r1, r2);
        this.u.j(this.f7122b, this.f7123c);
        return;
    L12:
        r0 = this.u;
        r1 = this.f7122b;
        r2 = 1;
        goto L13
    L5:
        if (this.f7123c.B().equals(this.s) == true) goto L7;
        n0();
        k0();
        goto L7
    }

    static /* synthetic */ void v(a2 r0, com.amap.api.location.b r1) {
        r0.S(r1);
    }

    private boolean v0() {
        if (a5.b0(this.f7122b) == false) goto L8;
        int r0 = -1;
        r0 = w4.f(((Application) this.f7122b.getApplicationContext()).getBaseContext(), "checkSelfPermission", new Object[]{"android.permission.FOREGROUND_SERVICE"});     // Catch: Throwable -> L9
    L6:
        if (r0 == 0) goto L8;
        return false;
    L8:
        return true;
    }

    private static void w(s3 r2) {
        r2.y();     // Catch: Throwable -> L4
        AMapLocationClientOption r0 = new AMapLocationClientOption();     // Catch: Throwable -> L4
        r0.a0(false);     // Catch: Throwable -> L4
        r2.n(r0);     // Catch: Throwable -> L4
        r2.h(true, new eq());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s4.h(th, "ALManager", "apsLocation:doFirstNetLocate 2");
    }

    private void x(s3 r2, eq r3) {
        r2.k(this.f7122b);     // Catch: Throwable -> L4
        r2.n(this.f7123c);     // Catch: Throwable -> L4
        r2.t(r3);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s4.h(th, "ALManager", "initApsBase");
    }

    private static void y(s3 r1, ew r2) {
        if (r2 == null) goto L12;
    L7:
        th = move-exception;
        s4.h(th, "ALManager", "apsLocation:doFirstAddCache");
        return;
    L4:
        if (r2.U() != 0) goto L13;
        r1.u(r2);     // Catch: Throwable -> L7
        return;
    L13:
        return;
    }

    public final boolean A() {
        return this.f7127g;
    }

    public final void E() {
        if (this.x.h() == false) goto L14;
        f r0 = this.f7124d;     // Catch: Throwable -> L13
        if (r0 == null) goto L14;
        r0.sendEmptyMessageDelayed(13, this.x.i());     // Catch: Throwable -> L13
    L14:
        f(1003, null, 0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        s4.h(th, "ALManager", "startLocation");
    }

    public final void I(com.amap.api.location.b r4) {
        f(TTVideoUploaderListener.EndTimeUploadStage5, r4, 0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        s4.h(th, "ALManager", "unRegisterLocationListener");
    }

    public final void P() {
        f(1004, null, 0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        s4.h(th, "ALManager", "stopLocation");
    }

    final void d0() {
        e(12, null);
        this.f7130j = true;
        this.f7131k = true;
        this.f7127g = false;
        this.v = false;
        n0();
        y4 r2 = this.u;
        if (r2 == null) goto L5;
        r2.u(this.f7122b);
    L5:
        x4.a(this.f7122b).b();
        y4.c(this.f7122b);
        b3 r3 = this.w;
        if (r3 == null) goto L8;
        r3.s().sendEmptyMessage(11);
    L35:
        if (this.F == false) goto L14;
        this.f7122b.stopService(s0());     // Catch: Throwable -> L32
    L14:
        this.F = false;
        ArrayList<com.amap.api.location.b> r4 = this.f7129i;
        if (r4 == null) goto L17;
        r4.clear();
        this.f7129i = null;
    L17:
        this.z = null;
        g0();
        e r5 = this.q;
        if (r5 != null) goto L20;
    L25:
        this.q = null;
        f r0 = this.f7124d;
        if (r0 == null) goto L28;
        r0.removeCallbacksAndMessages(null);
    L28:
        g5 r1 = this.f7132l;
        if (r1 == null) goto L37;
        r1.e();
        this.f7132l = null;
        return;
    L37:
        return;
    L20:
        if (Build.VERSION.SDK_INT >= 18) goto L33;
        r5.quit();
        goto L25
    L33:
        w4.b(r5, HandlerThread.class, "quitSafely", new Object[0]);     // Catch: Throwable -> L23
    L23:
        this.q.quit();
        goto L25
    L8:
        ServiceConnection r6 = this.z;
        if (r6 == null) goto L35;
        this.f7122b.unbindService(r6);
        goto L35
    }

    public final void o(AMapLocationClientOption r4) {
        this.x = r4.e();     // Catch: Throwable -> L4
        f(PointerIconCompat.TYPE_ZOOM_IN, r4.e(), 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s4.h(th, "ALManager", "setLocationOption");
    }

    public final void p(com.amap.api.location.b r4) {
        f(1002, r4, 0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        s4.h(th, "ALManager", "setLocationListener");
    }

    public final void z(boolean r4) {
        Bundle r0 = new Bundle();     // Catch: Throwable -> L4
        r0.putBoolean("j", r4);     // Catch: Throwable -> L4
        f(1024, r0, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s4.h(th, "ALManager", "disableBackgroundLocation");
    }
}
