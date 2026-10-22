package com.slardaros.client;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
class k extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f11681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Object f11682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Context f11683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static k f11684f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f11686b;

    private static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile Context f11687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private l f11688b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<d> f11689c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private AtomicBoolean f11690d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private List<Bundle> f11691e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private l.b f11692f;

        /* JADX INFO: renamed from: com.slardaros.client.k$a$a, reason: collision with other inner class name */
        class C0301a implements l.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f11693a;

            C0301a(a r1) {
                this.f11693a = r1;
            }

            @Override // com.slardaros.client.l.b
            public void a() {
                OLog.e("Slardaros_Agent", "slardar service connected...");
                this.f11693a.sendEmptyMessage(3);
            }

            @Override // com.slardaros.client.l.b
            public void b() {
                OLog.e("Slardaros_Agent", "slardar service disconnected...");
            }
        }

        a(Looper r2) {
            super(r2);
            this.f11689c = new ArrayList();
            this.f11690d = new AtomicBoolean(false);
            this.f11691e = new ArrayList();
            this.f11692f = new C0301a(this);
            l r3 = l.d(this);
            this.f11688b = r3;
            r3.j(this.f11692f);
            OLog.c("Slardaros_Agent", "WorkHandler onCreated");
        }

        private void a(Bundle r3, boolean r4) {
            if (r3 != null) goto L5;
            return;
        L5:
            if (this.f11691e.size() < 100) goto L8;
            if (r4 == true) goto L8;
            this.f11691e.remove(0);
        L8:
            this.f11691e.add(r3);
        }

        private void b(d r4, boolean r5) {
            if (r4 != null) goto L7;
            OLog.c("Slardaros_Agent", "cachEvent event is null ");
            return;
        L7:
            if (this.f11689c.size() < 100) goto L10;
            if (r5 == true) goto L10;
            this.f11689c.remove(0);
        L10:
            OLog.c("Slardaros_Agent", "cachEvent event:" + r4.toString());
            this.f11689c.add(r4);
        }

        private /* synthetic */ void c(AppProfile r2) {
            n(r2, new Messenger(this));
        }

        private /* synthetic */ void e(AppProfile r2) {
            n(r2, new Messenger(this));
        }

        private /* synthetic */ void g(Bundle r1) {
            i(r1);
        }

        private void i(Bundle r2) {
            if (r2 != null) goto L5;
            return;
        L5:
            if (this.f11688b.e() == false) goto L7;
            this.f11688b.g(r2);
            return;
        L7:
            a(r2, false);
            this.f11688b.b(this.f11687a);
        }

        private void j(d r5) {
            if (r5 != null) goto L5;
            return;
        L5:
            if (this.f11690d.get() == true) goto L7;
        L18:
            OLog.e("Slardaros_Agent", "onEvent before Init=" + this.f11690d.get());
            b(r5, false);
            return;
        L7:
            if (hasMessages(3) == true) goto L18;
            if (m.h(this.f11687a) == true) goto L14;
            OLog.e("Slardaros_Agent", "not target device.");
            l();
            return;
        L14:
            if (this.f11688b.e() == false) goto L16;
            b(r5, true);
            k(this.f11689c);
            return;
        L16:
            b(r5, false);
            this.f11688b.b(this.f11687a);
        }

        private void k(List<d> r3) {
            if (r3 != null) goto L5;
        L18:
            OLog.c("Slardaros_Agent", "onEvents list empth");
            return;
        L5:
            if (r3.isEmpty() == true) goto L18;
            if (this.f11688b.e() == true) goto L10;
            OLog.c("Slardaros_Agent", "onEvents add events to cache");
            Iterator<d> r4 = r3.iterator();
        L14:
            if (r4.hasNext() == false) goto L16;
            b(r4.next(), true);
            goto L14
        L16:
            this.f11688b.b(this.f11687a);
            return;
        L10:
            if (this.f11688b.h(r3) == false) goto L21;
            OLog.c("Slardaros_Agent", "onEvents done: ");
            r3.clear();
            return;
        }

        private void l() {
            OLog.e("Slardaros_Agent", "Handler onExit...");
            List<d> r0 = this.f11689c;
            if (r0 == null) goto L5;
            r0.clear();
            this.f11689c = null;
        L5:
            l r1 = this.f11688b;
            if (r1 == null) goto L8;
            r1.k();
            this.f11688b.j(null);
            this.f11688b = null;
        L8:
            this.f11687a = null;
            k.f11684f = null;
        }

        private void m() {
            OLog.c("Slardaros_Agent", "isTargetDevice: " + m.h(this.f11687a));
            if (m.h(this.f11687a) == true) goto L5;
        L7:
            this.f11690d.set(true);
            return;
        L5:
            if (this.f11688b.e() == true) goto L7;
            OLog.c("Slardaros_Agent", "bindService");
            this.f11688b.b(this.f11687a);
            goto L7
        }

        private void n(AppProfile r8, Messenger r9) {
            if (r8 != null) goto L7;
            OLog.c("Slardar", "onProfile profile is null");
            k.f11681c = 2;
            return;
        L7:
            if (this.f11688b.e() == false) goto L9;
            OLog.c("Slardar", "onProfile");
            this.f11688b.i(r8, r9);
            return;
        L9:
            boolean r2 = false;
            int r3 = 0;
            boolean r4 = false;
        L11:
            if (r3 >= 5) goto L23;
            Thread.sleep(1000);     // Catch: InterruptedException -> L20
            if (this.f11688b.e() == false) goto L18;
            this.f11688b.i(r8, r9);     // Catch: InterruptedException -> L20
        L24:
            if (r2 == false) goto L35;
            OLog.c("Slardar", "onProfile 2");
            k.f11681c = 2;
            return;
        L35:
            return;
        L18:
            if (r3 != 4) goto L22;
            r4 = true;
        L22:
            r3 = r3 + 1;
        L20:
            e = move-exception;
            e.printStackTrace();
            goto L22
        L23:
            r2 = r4;
            goto L24
        }

        private void o() {
            if (this.f11689c.isEmpty() == false) goto L6;
            return;
        L6:
            if (this.f11688b.e() == false) goto L16;
            k(this.f11689c);
            if (this.f11691e.size() <= 0) goto L17;
            Iterator<Bundle> r0 = this.f11691e.iterator();
        L11:
            if (r0.hasNext() == false) goto L13;
            Bundle r1 = r0.next();
            this.f11688b.g(r1);
            goto L11
        L13:
            this.f11691e.clear();
            return;
        L17:
            return;
        }

        private void p() {
            this.f11690d.set(false);
            OLog.c("Slardaros_Agent", "do onUnbind");
            l r2 = this.f11688b;
            if (r2 == null) goto L6;
            r2.k();
            return;
        }

        public /* synthetic */ void d(AppProfile r1) {
            c(r1);
        }

        public /* synthetic */ void f(AppProfile r1) {
            e(r1);
        }

        public /* synthetic */ void h(Bundle r1) {
            g(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r6) {
            OLog.c("Slardaros_Agent", "WorkHandler handle msg: " + r6.what);
            if (this.f11688b != null) goto L6;
            return;
        L6:
            if (this.f11687a != null) goto L8;
            q(k.e());
        L8:
            int r0 = r6.what;
            if (r0 != 1005) goto L11;
            OLog.c("Slardaros_Agent", "get message from server");
            k.f11681c = r6.arg1;
            return;
        L11:
            switch(r0) {
                case 2: goto L35;
                case 3: goto L34;
                case 4: goto L33;
                case 5: goto L32;
                case 6: goto L31;
                case 7: goto L25;
                case 8: goto L21;
                case 9: goto L13;
                default: goto L50;
            };
        L13:
            final AppProfile r7 = (AppProfile) r6.obj;
            if (m.h(this.f11687a) == true) goto L18;
            k.f11681c = 3;
            return;
        L18:
            if (this.f11688b.e() == false) goto L20;
            Messenger r1 = new Messenger(this);
        L28:
            n(r7, r1);
            return;
        L20:
            m();
            Runnable r2 = new b(this, r7);
        L30:
            postDelayed(r2, 1000);
            return;
        L21:
            final Bundle r8 = r6.getData();
            OLog.c("Slardaros_Agent", "data: " + r8.toString());
            if (this.f11688b.e() == false) goto L24;
            i(r8);
            return;
        L24:
            m();
            r2 = new com.slardaros.client.a(this, r8);
            goto L30
        L25:
            r7 = (AppProfile) r6.obj;
            if (this.f11688b.e() == false) goto L29;
            r1 = new Messenger(this);
            goto L28
        L29:
            m();
            r2 = new c(this, r7);
            goto L30
        L31:
            p();
            return;
        L32:
            m();
            k((List) r6.obj);
            return;
        L33:
            l();
            return;
        L34:
            o();
            return;
        L35:
            d r9 = (d) r6.obj;
            if (this.f11688b.e() == false) goto L38;
            j(r9);
            return;
        L38:
            m();
            b(r9, true);
            return;
        }

        public void q(Context r1) {
            this.f11687a = r1;
        }
    }

    static {
        f11682d = new Object();
    }

    public k() {
        HandlerThread r0 = new HandlerThread("SlardarHandler");
        r0.start();
        Looper r1 = r0.getLooper();
        Objects.requireNonNull(r1);
        this.f11686b = new a(r1);
    }

    static /* synthetic */ Context e() {
        return f11683e;
    }

    public static k g() {
        Object r0 = f11682d;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f11684f != null) goto L7;
        OLog.c("Slardaros_Agent", "get new SlardarHandler");     // Catch: Throwable -> L10
        f11684f = new k();     // Catch: Throwable -> L10
    L7:
        k r1 = f11684f;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    }

    @Override // com.slardaros.client.e
    public void b(Context r2) {
        if (r2 == null) goto L10;
        if (r2.getApplicationContext() == null) goto L7;
        r2 = r2.getApplicationContext();
    L7:
        this.f11685a = r2;
        this.f11686b.q(r2);
        f11683e = this.f11685a;
        Message.obtain(this.f11686b, 1).sendToTarget();
        return;
    L10:
        throw new IllegalArgumentException("context can't be null when initing slardar agent.");
    }

    @Override // com.slardaros.client.e
    public void c(d r2) {
        Message.obtain(this.f11686b, 2, r2).sendToTarget();
    }

    @Override // com.slardaros.client.e
    public void d(List<d> r2) {
        Message.obtain(this.f11686b, 5, r2).sendToTarget();
    }

    public Context f() {
        return this.f11685a;
    }
}
