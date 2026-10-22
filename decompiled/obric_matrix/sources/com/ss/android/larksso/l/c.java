package com.ss.android.larksso.l;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.common.wschannel.WsConstants;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f12054a = "https://internal-api.feishu.cn/collect/log/v1/";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f12055b = "https://internal-api.larksuite.com/collect/log/v1/";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicInteger f12056c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static List<C0314c> f12057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Set<C0314c> f12058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static b f12059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f12060g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f12061h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f12062i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f12063j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f12064k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f12065l;
    private static URL m;

    static /* synthetic */ class a {
    }

    private static class b extends Handler {
        b(Looper r1) {
            super(r1);
        }

        private List<List<C0314c>> a(List<C0314c> r3) {
            ArrayList r2 = new ArrayList();
            if (r3 != null) goto L5;
        L12:
            return r2;
        L5:
            if (r3.isEmpty() == true) goto L12;
            ArrayList r0 = new ArrayList();
            Iterator<C0314c> r4 = r3.iterator();
        L9:
            if (r4.hasNext() == false) goto L11;
            r0.add(r4.next());
            goto L9
        L11:
            r2.add(r0);
            goto L12
        }

        private void b(C0314c r3) {
            if (C0314c.d(r3) == true) goto L5;
            return;
        L5:
            boolean r0 = c.a().isEmpty();
            c.a().add(r3);
            if (r0 == false) goto L9;
            sendEmptyMessageDelayed(1, WsConstants.EXIT_DELAY_TIME);
            return;
        }

        private void c() {
            ArrayList r0 = new ArrayList(c.a());
            c.a().clear();
            if (r0.isEmpty() == false) goto L5;
            return;
        L5:
            int r1 = d(r0);
            Iterator<List<C0314c>> r4 = a(r0).iterator();
        L7:
            if (r4.hasNext() == false) goto L16;
            List<C0314c> r2 = r4.next();
            c.g(r2);
            Object r3 = c.b();
            monitor-enter(r3);
            c.c().addAll(r2);     // Catch: Throwable -> L13
            monitor-exit(r3);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        L16:
            if (r1 <= 0) goto L22;
            c.l("LogUpload", "limitEvents remove " + r1);
            return;
        }

        private int d(List<C0314c> r3) {
            int r2 = r3.size() - 50;
            int r0 = 0;
            if (r2 > 0) goto L5;
            return 0;
        L5:
            ListIterator<C0314c> r4 = r3.listIterator();
        L7:
            if (r4.hasNext() == false) goto L10;
            if (r2 <= 0) goto L10;
            r4.next();
            r4.remove();
            r2 = r2 - 1;
            r0 = r0 + 1;
        L10:
            return r0;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r2) {
            super.handleMessage(r2);
            int r0 = r2.what;
            if (r0 != 0) goto L5;
            b((C0314c) r2.obj);
            return;
        L5:
            if (r0 != 1) goto L11;
            c();
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.larksso.l.c$c, reason: collision with other inner class name */
    private static class C0314c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f12066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f12067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f12068c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f12069d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f12070e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f12071f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f12072g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f12073h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f12074i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f12075j;

        private C0314c() {
        }

        /* synthetic */ C0314c(a r1) {
            this();
        }

        static /* synthetic */ boolean a(C0314c r0) {
            return r0.f12072g;
        }

        static /* synthetic */ boolean b(C0314c r0, boolean r1) {
            r0.f12072g = r1;
            return r1;
        }

        static /* synthetic */ String c(C0314c r0) {
            return r0.f12075j;
        }

        static /* synthetic */ boolean d(C0314c r0) {
            return r0.f12074i;
        }

        static /* synthetic */ boolean e(C0314c r0, boolean r1) {
            r0.f12074i = r1;
            return r1;
        }

        static /* synthetic */ String f(C0314c r0, String r1) {
            r0.f12075j = r1;
            return r1;
        }

        static /* synthetic */ String g(C0314c r0) {
            return r0.f12068c;
        }

        static /* synthetic */ String h(C0314c r0, String r1) {
            r0.f12068c = r1;
            return r1;
        }

        static /* synthetic */ long i(C0314c r2) {
            return r2.f12073h;
        }

        static /* synthetic */ long j(C0314c r0, long r1) {
            r0.f12073h = r1;
            return r1;
        }

        static /* synthetic */ String k(C0314c r0) {
            return r0.f12066a;
        }

        static /* synthetic */ String l(C0314c r0, String r1) {
            r0.f12066a = r1;
            return r1;
        }

        static /* synthetic */ String m(C0314c r0) {
            return r0.f12071f;
        }

        static /* synthetic */ String n(C0314c r0, String r1) {
            r0.f12071f = r1;
            return r1;
        }

        static /* synthetic */ String o(C0314c r0) {
            return r0.f12069d;
        }

        static /* synthetic */ String p(C0314c r0, String r1) {
            r0.f12069d = r1;
            return r1;
        }

        static /* synthetic */ String q(C0314c r0) {
            return r0.f12067b;
        }

        static /* synthetic */ String r(C0314c r0, String r1) {
            r0.f12067b = r1;
            return r1;
        }

        static /* synthetic */ int s(C0314c r0) {
            return r0.f12070e;
        }

        static /* synthetic */ int t(C0314c r0, int r1) {
            r0.f12070e = r1;
            return r1;
        }
    }

    static {
        f12056c = new AtomicInteger(0);
        f12057d = Collections.synchronizedList(new ArrayList());
        f12058e = Collections.synchronizedSet(new HashSet());
        f12059f = null;
        f12060g = new Object();
        f12061h = new Object();
    }

    static /* synthetic */ List a() {
        return f12057d;
    }

    static /* synthetic */ Object b() {
        return f12061h;
    }

    static /* synthetic */ Set c() {
        return f12058e;
    }

    private static e.b d(C0314c r1, String r2) {
        e.b r0 = new e.b();
        com.ss.android.larksso.l.a.a(e(r2, r1));
        return r0;
    }

    private static e.a e(String r4, C0314c r5) {
        e.a r6 = new e.a();
        e.a.C0315a r0 = e.a.a();
        r0.j(C0314c.i(r5));
        r0.e(C0314c.g(r5));
        r0.i(C0314c.c(r5));
        r0.f("release");
        r0.h(EnvironmentCompat.MEDIA_UNKNOWN);
        r0.b("main");
        r0.g(C0314c.a(r5));
        String r2 = "feishu";
        if (f12065l == false) goto L5;
        String r1 = "feishu";
    L6:
        r0.d(r1);
        if (f12065l == true) goto L10;
        r2 = "lark";
    L10:
        r0.c(r2);
        r0.a();
        C0314c.k(r5);
        Process.myPid();
        C0314c.m(r5);
        C0314c.o(r5);
        C0314c.q(r5);
        C0314c.s(r5);
        return r6;
    L5:
        r1 = "lark";
        goto L6
    }

    private static e.c f(String r1) {
        e.c r2 = new e.c();
        String r0 = Build.MANUFACTURER;
        String r3 = Build.VERSION.RELEASE;
        return r2;
    }

    public static void g(List<C0314c> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.isEmpty() == true) goto L14;
        e r0 = new e();
        f("43891908782");
        r0.f12077f = new ArrayList();
        Iterator<C0314c> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        C0314c r1 = r5.next();
        r0.f12077f.add(d(r1, ""));
        goto L8
    L10:
        new d(r0).b(m);
        return;
    }

    public static void h(String r4, String r5) {
        n(com.ss.android.larksso.l.b.f12048g.a(), r4 + ": " + r5 + ",LarkSSO=true,associate_id=" + f12064k, false, true);     // Catch: Exception -> L4
        Log.e(r4, r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private static C0314c i(String r5, String r6, boolean r7, boolean r8) {
        Object r0 = f12061h;
        monitor-enter(r0);
        Iterator<C0314c> r1 = f12058e.iterator();     // Catch: Throwable -> L17
        a r2 = null;
        C0314c r3 = null;
    L6:
        if (r1.hasNext() == false) goto L8;
        r3 = r1.next();     // Catch: Throwable -> L17
        r1.remove();     // Catch: Throwable -> L17
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L17
        if (r3 != null) goto L11;
        r3 = new C0314c(r2);
    L11:
        C0314c.r(r3, r5);
        C0314c.h(r3, r6);
        C0314c.b(r3, r7);
        C0314c.n(r3, Thread.currentThread().getName());
        C0314c.l(r3, k());
        C0314c.j(r3, f12056c.getAndIncrement());
        C0314c.e(r3, r8);
        C0314c.f(r3, f12063j);
        C0314c.p(r3, "file");     // Catch: Exception -> L14
        C0314c.t(r3, 0);     // Catch: Exception -> L14
    L16:
        return r3;
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        th = move-exception;
        throw th;
    }

    private static Handler j() {
        if (f12059f != null) goto L15;
        Object r0 = f12060g;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12059f != null) goto L9;
        HandlerThread r1 = new HandlerThread("LogUpload");     // Catch: Throwable -> L11
        r1.start();     // Catch: Throwable -> L11
        f12059f = new b(r1.getLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return f12059f;
    }

    private static String k() {
        Date r0 = new Date();
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX", Locale.getDefault()).format(r0);
    }

    public static void l(String r4, String r5) {
        n(com.ss.android.larksso.l.b.f12050i.a(), r4 + ": " + r5 + ",LarkSSO=true,associate_id=" + f12064k, false, true);     // Catch: Exception -> L4
        Log.i(r4, r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void m(String r0, String r1, boolean r2) {
        f12062i = r0;
        f12063j = r1;
        f12065l = r2;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (f12065l == false) goto L6;
        String r3 = f12054a;     // Catch: MalformedURLException -> L9
    L7:
        m = new URL(r3);     // Catch: MalformedURLException -> L9
        return;
    L6:
        r3 = f12055b;     // Catch: MalformedURLException -> L9
        goto L7
    }

    private static void n(String r0, String r1, boolean r2, boolean r3) {
        C0314c r4 = i(r0, r1, r2, r3);
        Message r5 = Message.obtain();
        r5.what = 0;
        r5.obj = r4;
        j().sendMessage(r5);
    }
}
