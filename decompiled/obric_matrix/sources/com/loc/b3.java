package com.loc;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b3 {
    static boolean w = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f7170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f7172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    b f7173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ew f7175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    AMapLocation f7176g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    a f7177h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Context f7178i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private g5 f7179j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    s3 f7180k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    HashMap<Messenger, Long> f7181l;
    y4 m;
    long n;
    long o;
    private List<Messenger> p;
    private long q;
    String r;
    private boolean s;
    private String t;
    AMapLocationClientOption u;
    AMapLocationClientOption v;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b3 f7182a;

        public a(b3 r1, Looper r2) {
            this.f7182a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r9) {
            Bundle r2 = r9.getData();     // Catch: Throwable -> L18
            Messenger r3 = r9.replyTo;     // Catch: Throwable -> L16
            if (r2 != null) goto L60;
        L21:
            int r1 = r9.what;     // Catch: Throwable -> L57
            if (r1 == 0) goto L54;
            if (r1 == 1) goto L53;
            switch(r1) {
                case 9: goto L52;
                case 10: goto L51;
                case 11: goto L50;
                case 12: goto L49;
                case 13: goto L40;
                case 14: goto L28;
                case 15: goto L26;
                default: goto L55;
            };     // Catch: Throwable -> L57
        L26:
            b3.n(this.f7182a, r2);     // Catch: Throwable -> L57
            b3 r0 = this.f7182a;     // Catch: Throwable -> L57
            String r4 = "COARSE_LOC";
        L27:
            r0.i(r3, r2, r4);     // Catch: Throwable -> L57
            goto L55
        L28:
            Messenger r5 = r9.replyTo;     // Catch: Throwable -> L57
            if (r5 == null) goto L36;
            if (b3.v(this.f7182a) == null) goto L36;
            if (b3.v(this.f7182a).contains(r5) == false) goto L36;
            b3.v(this.f7182a).remove(r5);     // Catch: Throwable -> L57
        L36:
            if (b3.v(this.f7182a) == null) goto L55;
            if (b3.v(this.f7182a).size() != 0) goto L55;
            this.f7182a.f7180k.D();     // Catch: Throwable -> L57
            goto L55
        L40:
            Messenger r6 = r9.replyTo;     // Catch: Throwable -> L57
            if (r6 == null) goto L55;
            if (b3.v(this.f7182a) == null) goto L55;
            if (b3.v(this.f7182a).contains(r6) == true) goto L55;
            b3.v(this.f7182a).add(r6);     // Catch: Throwable -> L57
            if (b3.v(this.f7182a).size() != 1) goto L55;
            b3.B(this.f7182a);     // Catch: Throwable -> L57
            goto L55
        L49:
            b3.o(this.f7182a, r3);     // Catch: Throwable -> L57
            goto L55
        L50:
            this.f7182a.A();     // Catch: Throwable -> L57
            goto L55
        L51:
            b3.n(this.f7182a, r2);     // Catch: Throwable -> L57
            r0 = this.f7182a;     // Catch: Throwable -> L57
            r4 = "FINE_LOC";
            goto L27
        L52:
            b3.n(this.f7182a, r2);     // Catch: Throwable -> L57
            b3.m(this.f7182a);     // Catch: Throwable -> L57
        L55:
            super.handleMessage(r9);     // Catch: Throwable -> L57
            return;
        L57:
            th = move-exception;
            s4.h(th, "actionHandler", "handleMessage");
            return;
        L53:
            b3.n(this.f7182a, r2);     // Catch: Throwable -> L57
            b3.z(this.f7182a, r3, r2);     // Catch: Throwable -> L57
            goto L55
        L54:
            b3.n(this.f7182a, r2);     // Catch: Throwable -> L57
            b3.p(this.f7182a, r3, r2);     // Catch: Throwable -> L57
            goto L55
        L60:
        L14:
            Throwable th = th;
        L64:
            s4.h(th, "ApsServiceCore", "ActionHandler handlerMessage");     // Catch: Throwable -> L57
            goto L21
        L7:
            if (r2.isEmpty() == true) goto L21;
            if (this.f7182a.r(r2.getString("c")) == true) goto L21;
            if (r9.what != 1) goto L68;
            y4.p(null, 2102);     // Catch: Throwable -> L14
            ew r7 = b3.u("invalid handlder scode!!!#1002");     // Catch: Throwable -> L14
            eq r8 = new eq();     // Catch: Throwable -> L14
            r8.y("#1002");     // Catch: Throwable -> L14
            r8.w("conitue");     // Catch: Throwable -> L14
            b3.q(this.f7182a, r3, r7, r7.v1(), r8);     // Catch: Throwable -> L14
            return;
        L68:
            return;
        L16:
            th = move-exception;
            r3 = null;
            th = th;
        L18:
            th = move-exception;
            r3 = null;
            th = th;
            r2 = null;
            goto L64
        }
    }

    class b extends HandlerThread {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b3 f7183f;

        public b(b3 r1, String r2) {
            this.f7183f = r1;
            super(r2);
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            b3.b(this.f7183f, new g5(this.f7183f.f7178i));     // Catch: Throwable -> L5
        L18:
            r4.j(this.f7183f.f7178i);     // Catch: Throwable -> L9
            r4.a(this.f7183f.f7178i);     // Catch: Throwable -> L9
        L11:
            b3 r1 = this.f7183f;     // Catch: Throwable -> L13
            r1.f7180k = new s3(false);     // Catch: Throwable -> L13
            super.onLooperPrepared();     // Catch: Throwable -> L13
            return;
        L9:
            th = move-exception;
            s4.h(th, "APSManager$ActionThread", "init 3");     // Catch: Throwable -> L13
        L5:
            th = move-exception;
            s4.h(th, "APSManager$ActionThread", "init 2");     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            s4.h(th, "APSManager$ActionThread", "onLooperPrepared");
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            super.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            s4.h(th, "APSManager$ActionThread", "run");
        }
    }

    static {
    }

    public b3(Context r5) {
        this.f7170a = false;
        this.f7171b = false;
        this.f7172c = null;
        this.f7173d = null;
        this.f7174e = 0;
        this.f7175f = null;
        this.f7176g = null;
        this.f7177h = null;
        this.f7178i = null;
        this.f7179j = null;
        this.f7180k = null;
        this.f7181l = new HashMap();
        this.m = null;
        this.n = 0;
        this.o = 0;
        this.q = 0;
        this.r = null;
        this.s = true;
        this.t = "";
        this.u = null;
        this.v = new AMapLocationClientOption();
        this.f7178i = r5;
    }

    static /* synthetic */ void B(b3 r0) {
        r0.D();
    }

    public static void C() {
        w = false;
    }

    private void D() {
        if (a5.e0(this.f7178i) == false) goto L14;
        u4.a();
        return;
    L14:
        s3 r0 = this.f7180k;     // Catch: Throwable -> L11
        if (r0 == null) goto L16;
        if (r0 == null) goto L17;
        r0.l(this.f7177h);     // Catch: Throwable -> L11
        this.f7180k.C();     // Catch: Throwable -> L11
        return;
    L17:
        return;
    L16:
        return;
    L11:
        th = move-exception;
        s4.h(th, "ApsServiceCore", "startColl");
    }

    private void E() {
        r4.m(this.f7178i);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s4.h(th, "ApsServiceCore", "doCallOtherSer");
    }

    private static ew a(int r2, String r3) {
        ew r0 = new ew("");     // Catch: Throwable -> L4
        r0.E0(r2);     // Catch: Throwable -> L4
        r0.J0(r3);     // Catch: Throwable -> L4
        return r0;
    L4:
        th = move-exception;
        s4.h(th, "ApsServiceCore", "newInstanceAMapLoc");
        return null;
    }

    static /* synthetic */ g5 b(b3 r0, g5 r1) {
        r0.f7179j = r1;
        return r1;
    }

    private void e(Bundle r2) {
    L17:
        th = move-exception;
        this.s = false;
        th.printStackTrace();
        this.t = th.getMessage();
        s4.h(th, "ApsServiceCore", "init");
        return;
    L3:
        if (this.f7170a == false) goto L8;
        s3 r3 = this.f7180k;     // Catch: Throwable -> L17
        if (r3 == null) goto L21;
        r3.j();     // Catch: Throwable -> L17
        return;
    L21:
        return;
    L8:
        s4.e(this.f7178i);     // Catch: Throwable -> L17
        if (r2 == null) goto L11;
        this.v = s4.c(r2.getBundle("optBundle"));     // Catch: Throwable -> L17
    L11:
        this.f7180k.k(this.f7178i);     // Catch: Throwable -> L17
        this.f7180k.r();     // Catch: Throwable -> L17
        l(this.v);     // Catch: Throwable -> L17
        this.f7180k.w();     // Catch: Throwable -> L17
        this.f7170a = true;     // Catch: Throwable -> L17
        this.s = true;     // Catch: Throwable -> L17
        this.t = "";     // Catch: Throwable -> L17
        List<Messenger> r4 = this.p;     // Catch: Throwable -> L17
        if (r4 != null) goto L14;
        return;
    L14:
        if (r4.size() <= 0) goto L23;
        D();     // Catch: Throwable -> L17
        return;
    }

    private void f(Messenger r1) {
        this.f7181l.remove(r1);
    }

    private static void g(Messenger r1, int r2, Bundle r3) {
        if (r1 == null) goto L10;
        Message r0 = Message.obtain();     // Catch: Throwable -> L5
        r0.setData(r3);     // Catch: Throwable -> L5
        r0.what = r2;     // Catch: Throwable -> L5
        r1.send(r0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        s4.h(th, "ApsServiceCore", "sendMessage");
        return;
    }

    private void h(Messenger r1, Bundle r2) {
        if (r2 == null) goto L16;
    L11:
        th = move-exception;
        s4.h(th, "ApsServiceCore", "doInitAuth");
        return;
    L4:
        if (r2.isEmpty() == false) goto L7;
        return;
    L7:
        if (this.f7171b == false) goto L9;
        return;
    L9:
        this.f7171b = true;     // Catch: Throwable -> L11
        x(r1);     // Catch: Throwable -> L11
        return;
    }

    private void j(Messenger r3, AMapLocation r4, String r5, eq r6) {
        Bundle r0 = new Bundle();
        r0.setClassLoader(AMapLocation.class.getClassLoader());
        r0.putParcelable("loc", r4);
        r0.putString("nb", r5);
        r0.putParcelable("statics", r6);
        this.f7181l.put(r3, Long.valueOf(a5.A()));
        g(r3, 1, r0);
    }

    private void k(Messenger r4, String r5) {
        Bundle r0 = new Bundle();
        r0.setClassLoader(AMapLocation.class.getClassLoader());
        r0.putInt("I_MAX_GEO_DIS", r4.y() * 3);
        r0.putInt("I_MIN_GEO_DIS", r4.y());
        r0.putParcelable("loc", this.f7176g);
        if ("COARSE_LOC".equals(r5) == false) goto L7;
        int r3 = 103;
    L5:
        g(r4, r3, r0);
        return;
    L7:
        r3 = 6;
        goto L5
    }

    private void l(AMapLocationClientOption r3) {
        s3 r0 = this.f7180k;     // Catch: Throwable -> L24
        if (r0 == null) goto L5;
        r0.n(r3);     // Catch: Throwable -> L24
    L5:
        if (r3 == null) goto L29;
        w = r3.G();     // Catch: Throwable -> L24
        if (this.u != null) goto L9;
    L22:
        this.u = r3;     // Catch: Throwable -> L24
        return;
    L9:
        if (r3.M() == this.u.M()) goto L11;
    L16:
        this.f7174e = 0;     // Catch: Throwable -> L24
    L18:
        if (r3.M() == this.u.M()) goto L20;
    L21:
        this.f7176g = null;     // Catch: Throwable -> L24
        goto L22
    L20:
        if (this.u.q() == r3.q()) goto L22;
    L11:
        if (r3.L() != this.u.L()) goto L16;
        if (r3.H() != this.u.H()) goto L16;
        if (this.u.q() == r3.q()) goto L18;
    L29:
        return;
    L24:
        th = move-exception;
        s4.h(th, "ApsServiceCore", "setExtra");
    }

    static /* synthetic */ void m(b3 r0) {
        r0.E();
    }

    static /* synthetic */ void n(b3 r0, Bundle r1) {
        r0.e(r1);
    }

    static /* synthetic */ void o(b3 r0, Messenger r1) {
        r0.f(r1);
    }

    static /* synthetic */ void p(b3 r0, Messenger r1, Bundle r2) {
        r0.h(r1, r2);
    }

    static /* synthetic */ void q(b3 r0, Messenger r1, AMapLocation r2, String r3, eq r4) {
        r0.j(r1, r2, r3, r4);
    }

    private static AMapLocationClientOption t(Bundle r3) {
        AMapLocationClientOption r1 = null;
        r1 = s4.c(r3.getBundle("optBundle"));     // Catch: Throwable -> L11
        String r4 = r3.getString("d");     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r4) == true) goto L14;
        l5.t(r4);     // Catch: Throwable -> L8
    L14:
    L13:
        return r1;
    L8:
        th = move-exception;
        s4.h(th, "APSManager", "doLocation setUmidToken");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        s4.h(th, "APSManager", "parseBundle");
        goto L13
    }

    static /* synthetic */ ew u(String r1) {
        return a(10, r1);
    }

    static /* synthetic */ List v(b3 r0) {
        return r0.p;
    }

    private void x(Messenger r3) {
        this.f7180k.B();     // Catch: Throwable -> L6
        if (r4.C() == false) goto L11;
        Bundle r2 = new Bundle();     // Catch: Throwable -> L6
        r2.putBoolean("installMockApp", true);     // Catch: Throwable -> L6
        g(r3, 9, r2);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        s4.h(th, "ApsServiceCore", "initAuth");
    }

    private void y(Messenger r12, Bundle r13) {
        if (r13 == null) goto L72;
    L64:
        th = move-exception;
        s4.h(th, "ApsServiceCore", "doLocation");
        return;
    L5:
        if (r13.isEmpty() == true) goto L73;
        eq r3 = new eq();     // Catch: Throwable -> L64
        r3.w("conitue");     // Catch: Throwable -> L64
        AMapLocationClientOption r14 = t(r13);     // Catch: Throwable -> L64
        l(r14);     // Catch: Throwable -> L64
        if (this.f7181l.containsKey(r12) == true) goto L10;
    L14:
        AMapLocation r5 = null;
        if (this.s == true) goto L18;
        this.f7175f = a(9, "init error : " + this.t + "#0901");     // Catch: Throwable -> L64
        r3.y("#0901");     // Catch: Throwable -> L64
        ew r15 = this.f7175f;     // Catch: Throwable -> L64
        j(r12, r15, r15.v1(), r3);     // Catch: Throwable -> L64
        y4.p(null, 2091);     // Catch: Throwable -> L64
        return;
    L18:
        long r6 = a5.A();     // Catch: Throwable -> L64
        if (a5.q(this.f7175f) == true) goto L21;
    L24:
        r3.j(a5.A());     // Catch: Throwable -> L64
        ew r7 = this.f7180k.d(r3);     // Catch: Throwable -> L40
        this.f7175f = r7;     // Catch: Throwable -> L40
        if (r7.Y() != 6) goto L29;
    L37:
        this.f7180k.o(this.f7175f, 2);     // Catch: Throwable -> L40
    L38:
        this.f7175f = this.f7180k.e(this.f7175f);     // Catch: Throwable -> L40
    L44:
        if (a5.q(this.f7175f) == false) goto L47;
        this.f7174e = a5.A();     // Catch: Throwable -> L64
    L47:
        if (this.f7175f != null) goto L49;
        this.f7175f = a(8, "loc is null#0801");     // Catch: Throwable -> L64
        r3.y("#0801");     // Catch: Throwable -> L64
    L49:
        ew r0 = this.f7175f;     // Catch: Throwable -> L64
        if (r0 == null) goto L53;
        String r8 = r0.v1();     // Catch: Throwable -> L64
        r5 = this.f7175f.z();     // Catch: Throwable -> L64
        String r1 = r8;
    L67:
    L60:
        th = move-exception;
        s4.h(th, "ApsServiceCore", "fixLastLocation");     // Catch: Throwable -> L64
    L62:
        j(r12, r5, r1, r3);     // Catch: Throwable -> L64
        return;
    L55:
        if (r14.H() == false) goto L62;
        g5 r2 = this.f7179j;     // Catch: Throwable -> L60
        if (r2 == null) goto L62;
        r5 = r2.a(r5, r1, r14.z());     // Catch: Throwable -> L60
        goto L62
    L53:
        r1 = null;
        goto L67
    L29:
        if (this.f7175f.Y() == 5) goto L37;
        if (this.f7175f.Y() != 2) goto L35;
        this.f7180k.o(this.f7175f, 3);     // Catch: Throwable -> L40
        goto L38
    L35:
        if (this.f7175f.Y() != 4) goto L38;
        this.f7180k.o(this.f7175f, 4);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        y4.p(null, 2081);     // Catch: Throwable -> L64
        r3.y("#0801");     // Catch: Throwable -> L64
        this.f7175f = a(8, "loc error : " + th.getMessage() + "#0801");     // Catch: Throwable -> L64
        s4.h(th, "ApsServiceCore", "run part2");     // Catch: Throwable -> L64
        goto L44
    L21:
        if ((r6 - this.f7174e) >= 600) goto L24;
        ew r16 = this.f7175f;     // Catch: Throwable -> L64
        j(r12, r16, r16.v1(), r3);     // Catch: Throwable -> L64
        this.f7180k.o(this.f7175f, 3);     // Catch: Throwable -> L64
        return;
    L10:
        if (r14.N() == true) goto L14;
        if ((a5.A() - this.f7181l.get(r12).longValue()) >= 800) goto L14;
        return;
    L73:
        return;
    }

    static /* synthetic */ void z(b3 r0, Messenger r1, Bundle r2) {
        r0.y(r1, r2);
    }

    public final void A() {
        HashMap<Messenger, Long> r1 = this.f7181l;     // Catch: Throwable -> L38
        if (r1 == null) goto L43;
        r1.clear();     // Catch: Throwable -> L38
        this.f7181l = null;     // Catch: Throwable -> L38
    L43:
        List<Messenger> r2 = this.p;     // Catch: Throwable -> L10
        if (r2 == null) goto L12;
        r2.clear();     // Catch: Throwable -> L10
    L12:
        g5 r3 = this.f7179j;     // Catch: Throwable -> L38
        if (r3 == null) goto L15;
        r3.e();     // Catch: Throwable -> L38
        this.f7179j = null;     // Catch: Throwable -> L38
    L15:
        this.f7170a = false;     // Catch: Throwable -> L38
        this.f7171b = false;     // Catch: Throwable -> L38
        this.f7180k.A();     // Catch: Throwable -> L38
        a r4 = this.f7177h;     // Catch: Throwable -> L38
        if (r4 == null) goto L18;
        r4.removeCallbacksAndMessages(null);     // Catch: Throwable -> L38
    L18:
        this.f7177h = null;     // Catch: Throwable -> L38
        b r5 = this.f7173d;     // Catch: Throwable -> L38
        if (r5 != null) goto L22;
    L27:
        this.f7173d = null;     // Catch: Throwable -> L38
        if (this.m != null) goto L30;
    L34:
        y4.c(this.f7178i);     // Catch: Throwable -> L38
        v.k();     // Catch: Throwable -> L38
        if (w == false) goto L47;
        Process.killProcess(Process.myPid());     // Catch: Throwable -> L38
        return;
    L47:
        return;
    L30:
        if (this.n == 0) goto L34;
        if (this.o == 0) goto L34;
        long r10 = a5.A() - this.n;     // Catch: Throwable -> L38
        int r6 = this.m.w(this.f7178i);     // Catch: Throwable -> L38
        int r7 = this.m.x(this.f7178i);     // Catch: Throwable -> L38
        y4.e(this.f7178i, r6, r7, this.o, r10);     // Catch: Throwable -> L38
        this.m.y(this.f7178i);     // Catch: Throwable -> L38
        goto L34
    L22:
        if (Build.VERSION.SDK_INT >= 18) goto L45;
        r5.quit();     // Catch: Throwable -> L38
        goto L27
    L45:
        w4.b(r5, HandlerThread.class, "quitSafely", new Object[0]);     // Catch: Throwable -> L25
    L25:
        this.f7173d.quit();     // Catch: Throwable -> L38
    L10:
        th = move-exception;
        s4.h(th, "apm", "des1");     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        s4.h(th, "apm", "tdest");
    }

    public final void c() {
        this.m = new y4();     // Catch: Throwable -> L4
        b r0 = new b(this, "amapLocCoreThread");     // Catch: Throwable -> L4
        this.f7173d = r0;     // Catch: Throwable -> L4
        r0.setPriority(5);     // Catch: Throwable -> L4
        this.f7173d.start();     // Catch: Throwable -> L4
        this.f7177h = new a(this, this.f7173d.getLooper());     // Catch: Throwable -> L4
        this.p = new ArrayList();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s4.h(th, "ApsServiceCore", "onCreate");
    }

    public final void d(Intent r3) {
        if ("true".equals(r3.getStringExtra("as")) == false) goto L8;
        a r2 = this.f7177h;
        if (r2 == null) goto L9;
        r2.sendEmptyMessageDelayed(9, 100);
        return;
    L9:
        return;
    }

    final void i(Messenger r11, Bundle r12, String r13) {
        if (r12 == null) goto L46;
    L35:
        th = move-exception;
        s4.h(th, "ApsServiceCore", "doLocationGeo");
        return;
    L4:
        if (r12.isEmpty() == true) goto L47;
        double r0 = r12.getDouble("lat");     // Catch: Throwable -> L35
        double r2 = r12.getDouble("lon");     // Catch: Throwable -> L35
        float r4 = r12.getFloat("radius");     // Catch: Throwable -> L35
        long r5 = r12.getLong("time");     // Catch: Throwable -> L35
        if ("FINE_LOC".equals(r13) == false) goto L10;
        AMapLocation r7 = new AMapLocation("gps");     // Catch: Throwable -> L35
        r7.setLatitude(r0);     // Catch: Throwable -> L35
        r7.L0(1);     // Catch: Throwable -> L35
        r7.setLongitude(r2);     // Catch: Throwable -> L35
        r7.setAccuracy(r4);     // Catch: Throwable -> L35
        r7.setTime(r5);     // Catch: Throwable -> L35
        this.f7180k.m(r7);     // Catch: Throwable -> L35
    L10:
        if (r4.x() == true) goto L12;
        return;
    L12:
        AMapLocationClientOption r6 = t(r12);     // Catch: Throwable -> L35
        if (r6 != null) goto L15;
        return;
    L15:
        if (r6.L() == false) goto L41;
        l(r6);     // Catch: Throwable -> L35
        AMapLocation r8 = this.f7176g;     // Catch: Throwable -> L35
        if (r8 == null) goto L22;
        float r9 = a5.d(new double[]{r0, r2, r8.getLatitude(), this.f7176g.getLongitude()});     // Catch: Throwable -> L35
        if (r9 >= (r4.y() * 3)) goto L24;
        k(r11, r13);     // Catch: Throwable -> L35
    L24:
        if (r9 != (-1.0f)) goto L26;
    L29:
        e(r12);     // Catch: Throwable -> L35
        this.f7176g = this.f7180k.b(r0, r2);     // Catch: Throwable -> L35
        this.q = a5.A();     // Catch: Throwable -> L35
        AMapLocation r14 = this.f7176g;     // Catch: Throwable -> L35
        if (r14 != null) goto L32;
        return;
    L32:
        if (TextUtils.isEmpty(r14.K()) == true) goto L45;
        k(r11, r13);     // Catch: Throwable -> L35
        return;
    L45:
        return;
    L26:
        if (r9 > r4.y()) goto L28;
        return;
    L28:
        if ((a5.A() - this.q) > (r4.A() * 1000)) goto L29;
        return;
    L22:
        r9 = -1.0f;
        goto L24
    L41:
        return;
    L47:
        return;
    }

    public final boolean r(String r2) {
        if (TextUtils.isEmpty(this.r) == false) goto L6;
        this.r = s4.o(this.f7178i);
    L6:
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return false;
    L8:
        if (r2.equals(this.r) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public final Handler s() {
        return this.f7177h;
    }

    public final void w(Intent r3) {
        String r0 = r3.getStringExtra("a");
        if (TextUtils.isEmpty(r0) == true) goto L5;
        j5.j(this.f7178i, r0);
    L5:
        String r1 = r3.getStringExtra("b");
        this.f7172c = r1;
        i5.c(r1);
        String r2 = r3.getStringExtra("d");
        if (TextUtils.isEmpty(r2) == true) goto L9;
        l5.t(r2);
        return;
    }
}
