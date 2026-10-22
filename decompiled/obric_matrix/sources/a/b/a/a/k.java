package a.b.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.WorkerThread;
import androidx.core.view.PointerIconCompat;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bytedance.lego.init.IdleTaskConfig;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.ss.ttuploader.TTVideoUploaderListener;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.f0;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<com.bytedance.lego.init.e.d, PriorityQueue<com.bytedance.lego.init.e.c>> f51a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f52b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile AtomicInteger f53c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f54d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f55e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f56f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Handler f57g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k f58h = null;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.lego.init.e.c f59f;

        public a(com.bytedance.lego.init.e.c r1) {
            this.f59f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public f0 invoke() {
            com.bytedance.lego.init.e.c r0 = this.f59f;
            if (r0.f4865i == true) goto L5;
            k r2 = k.f58h;
            kotlin.n0.d.o.b(r0, "task");
            k.c(r2, r0, false);
        L7:
            return f0.f18324a;
        L5:
            k.f58h.a().post(new i(this));
            goto L7
        }
    }

    static final class b implements Handler.Callback {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f60f = null;

        static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final a f61f = null;

            static {
                f61f = new a();
            }

            public a() {
                super(0);
            }

            @Override // kotlin.n0.c.a
            public f0 invoke() {
                k r2 = k.f58h;
                k.b(r2);
                k.d(r2, k.f51a.get(com.bytedance.lego.init.e.d.f4869f));
                return f0.f18324a;
            }
        }

        /* JADX INFO: renamed from: a.b.a.a.k$b$b, reason: collision with other inner class name */
        static final class C0002b extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final C0002b f62f = null;

            static {
                f62f = new C0002b();
            }

            public C0002b() {
                super(0);
            }

            @Override // kotlin.n0.c.a
            public f0 invoke() {
                k.d(k.f58h, k.f51a.get(com.bytedance.lego.init.e.d.f4870g));
                return f0.f18324a;
            }
        }

        static final class c extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final c f63f = null;

            static {
                f63f = new c();
            }

            public c() {
                super(0);
            }

            @Override // kotlin.n0.c.a
            public f0 invoke() {
                k.d(k.f58h, k.f51a.get(com.bytedance.lego.init.e.d.f4871h));
                return f0.f18324a;
            }
        }

        static final class d extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final d f64f = null;

            static {
                f64f = new d();
            }

            public d() {
                super(0);
            }

            @Override // kotlin.n0.c.a
            public f0 invoke() {
                k.d(k.f58h, k.f51a.get(com.bytedance.lego.init.e.d.f4872i));
                return f0.f18324a;
            }
        }

        static final class e extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final e f65f = null;

            static {
                f65f = new e();
            }

            public e() {
                super(0);
            }

            @Override // kotlin.n0.c.a
            public f0 invoke() {
                k.d(k.f58h, k.f51a.get(com.bytedance.lego.init.e.d.f4873j));
                return f0.f18324a;
            }
        }

        static final class f extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final f f66f = null;

            static {
                f66f = new f();
            }

            public f() {
                super(0);
            }

            @Override // kotlin.n0.c.a
            public f0 invoke() {
                k.d(k.f58h, k.f51a.get(com.bytedance.lego.init.e.d.f4874k));
                return f0.f18324a;
            }
        }

        static final class g extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final g f67f = null;

            static {
                f67f = new g();
            }

            public g() {
                super(0);
            }

            @Override // kotlin.n0.c.a
            public f0 invoke() {
                k.d(k.f58h, k.f51a.get(com.bytedance.lego.init.e.d.f4875l));
                return f0.f18324a;
            }
        }

        static final class h extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final h f68f = null;

            static {
                f68f = new h();
            }

            public h() {
                super(0);
            }

            @Override // kotlin.n0.c.a
            public f0 invoke() {
                k.d(k.f58h, k.f51a.get(com.bytedance.lego.init.e.d.m));
                return f0.f18324a;
            }
        }

        static final class i extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final i f69f = null;

            static {
                f69f = new i();
            }

            public i() {
                super(0);
            }

            @Override // kotlin.n0.c.a
            public f0 invoke() {
                k.d(k.f58h, k.f51a.get(com.bytedance.lego.init.e.d.n));
                return f0.f18324a;
            }
        }

        static {
            f60f = new b();
        }

        public b() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r19) {
            int r3 = 3072;
            switch(r19.what) {
                case 1001: goto L77;
                case 1002: goto L68;
                case 1003: goto L59;
                case 1004: goto L50;
                case 1005: goto L41;
                case 1006: goto L32;
                case 1007: goto L23;
                case 1008: goto L14;
                case 1009: goto L5;
                default: goto L87;
            };
        L5:
            a.b.a.a.j.b r0 = a.b.a.a.j.b.f40c;
            long r11 = System.currentTimeMillis();
            k r13 = k.f58h;
            r0.f("Start_Dispatch_15min", r11 - k.f56f, true);
            kotlin.n0.d.o.g("DelayTaskDispatcher", "classname");
            kotlin.n0.d.o.g("Start dispatch 15min tasks...", "message");
            if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L13;
            String r1 = b.a.a.a.a.b("DelayTaskDispatcher", ' ', "Start dispatch 15min tasks...");
            int r5 = r1.length();
            int r12 = 0;
            int r4 = 1;
        L9:
            if (r4 > 100) goto L13;
            if (r5 <= r3) goto L12;
            int r6 = b.a.a.a.a.a(r1, r12, r3, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r4), r3, 3072);
            r4 = r4 + 1;
            r12 = r3;
            r3 = r6;
            goto L9
        L12:
            b.a.a.a.a.f(r1, r12, r5, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r4));
        L13:
            kotlin.n0.c.a r2 = i.f69f;
        L86:
            a.b.a.a.c.a(r2);
            goto L87
        L14:
            a.b.a.a.j.b r7 = a.b.a.a.j.b.f40c;
            long r14 = System.currentTimeMillis();
            k r15 = k.f58h;
            r7.f("Start_Dispatch_10min", r14 - k.f56f, true);
            kotlin.n0.d.o.g("DelayTaskDispatcher", "classname");
            kotlin.n0.d.o.g("Start dispatch 10min tasks...", "message");
            if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L22;
            String r8 = b.a.a.a.a.b("DelayTaskDispatcher", ' ', "Start dispatch 10min tasks...");
            int r9 = r8.length();
            int r16 = 0;
            int r10 = 1;
        L18:
            if (r10 > 100) goto L22;
            if (r9 <= r3) goto L21;
            int r17 = b.a.a.a.a.a(r8, r16, r3, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r10), r3, 3072);
            r10 = r10 + 1;
            r16 = r3;
            r3 = r17;
            goto L18
        L21:
            b.a.a.a.a.f(r8, r16, r9, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r10));
        L22:
            r2 = h.f68f;
            goto L86
        L23:
            a.b.a.a.j.b r18 = a.b.a.a.j.b.f40c;
            long r110 = System.currentTimeMillis();
            k r111 = k.f58h;
            r18.f("Start_Dispatch_5min", r110 - k.f56f, true);
            kotlin.n0.d.o.g("DelayTaskDispatcher", "classname");
            kotlin.n0.d.o.g("Start dispatch 5min tasks...", "message");
            if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L31;
            String r20 = b.a.a.a.a.b("DelayTaskDispatcher", ' ', "Start dispatch 5min tasks...");
            int r21 = r20.length();
            int r112 = 0;
            int r22 = 1;
        L27:
            if (r22 > 100) goto L31;
            if (r21 <= r3) goto L30;
            int r23 = b.a.a.a.a.a(r20, r112, r3, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r22), r3, 3072);
            r22 = r22 + 1;
            r112 = r3;
            r3 = r23;
            goto L27
        L30:
            b.a.a.a.a.f(r20, r112, r21, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r22));
        L31:
            r2 = g.f67f;
            goto L86
        L32:
            a.b.a.a.j.b r24 = a.b.a.a.j.b.f40c;
            long r113 = System.currentTimeMillis();
            k r114 = k.f58h;
            r24.f("Start_Dispatch_2min", r113 - k.f56f, true);
            kotlin.n0.d.o.g("DelayTaskDispatcher", "classname");
            kotlin.n0.d.o.g("Start dispatch 2min tasks...", "message");
            if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L40;
            String r25 = b.a.a.a.a.b("DelayTaskDispatcher", ' ', "Start dispatch 2min tasks...");
            int r26 = r25.length();
            int r115 = 0;
            int r27 = 1;
        L36:
            if (r27 > 100) goto L40;
            if (r26 <= r3) goto L39;
            int r28 = b.a.a.a.a.a(r25, r115, r3, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r27), r3, 3072);
            r27 = r27 + 1;
            r115 = r3;
            r3 = r28;
            goto L36
        L39:
            b.a.a.a.a.f(r25, r115, r26, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r27));
        L40:
            r2 = f.f66f;
            goto L86
        L41:
            a.b.a.a.j.b r29 = a.b.a.a.j.b.f40c;
            long r116 = System.currentTimeMillis();
            k r117 = k.f58h;
            r29.f("Start_Dispatch_60s", r116 - k.f56f, true);
            kotlin.n0.d.o.g("DelayTaskDispatcher", "classname");
            kotlin.n0.d.o.g("Start dispatch 60s tasks...", "message");
            if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L49;
            String r30 = b.a.a.a.a.b("DelayTaskDispatcher", ' ', "Start dispatch 60s tasks...");
            int r31 = r30.length();
            int r118 = 0;
            int r32 = 1;
        L45:
            if (r32 > 100) goto L49;
            if (r31 <= r3) goto L48;
            int r33 = b.a.a.a.a.a(r30, r118, r3, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r32), r3, 3072);
            r32 = r32 + 1;
            r118 = r3;
            r3 = r33;
            goto L45
        L48:
            b.a.a.a.a.f(r30, r118, r31, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r32));
        L49:
            r2 = e.f65f;
            goto L86
        L50:
            a.b.a.a.j.b r34 = a.b.a.a.j.b.f40c;
            long r119 = System.currentTimeMillis();
            k r120 = k.f58h;
            r34.f("Start_Dispatch_30s", r119 - k.f56f, true);
            kotlin.n0.d.o.g("DelayTaskDispatcher", "classname");
            kotlin.n0.d.o.g("Start dispatch 30s tasks...", "message");
            if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L58;
            String r35 = b.a.a.a.a.b("DelayTaskDispatcher", ' ', "Start dispatch 30s tasks...");
            int r36 = r35.length();
            int r121 = 0;
            int r37 = 1;
        L54:
            if (r37 > 100) goto L58;
            if (r36 <= r3) goto L57;
            int r38 = b.a.a.a.a.a(r35, r121, r3, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r37), r3, 3072);
            r37 = r37 + 1;
            r121 = r3;
            r3 = r38;
            goto L54
        L57:
            b.a.a.a.a.f(r35, r121, r36, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r37));
        L58:
            r2 = d.f64f;
            goto L86
        L59:
            a.b.a.a.j.b r39 = a.b.a.a.j.b.f40c;
            long r122 = System.currentTimeMillis();
            k r123 = k.f58h;
            r39.f("Start_Dispatch_15s", r122 - k.f56f, true);
            kotlin.n0.d.o.g("DelayTaskDispatcher", "classname");
            kotlin.n0.d.o.g("Start dispatch 15s tasks...", "message");
            if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L67;
            String r40 = b.a.a.a.a.b("DelayTaskDispatcher", ' ', "Start dispatch 15s tasks...");
            int r41 = r40.length();
            int r124 = 0;
            int r42 = 1;
        L63:
            if (r42 > 100) goto L67;
            if (r41 <= r3) goto L66;
            int r43 = b.a.a.a.a.a(r40, r124, r3, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r42), r3, 3072);
            r42 = r42 + 1;
            r124 = r3;
            r3 = r43;
            goto L63
        L66:
            b.a.a.a.a.f(r40, r124, r41, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r42));
        L67:
            r2 = c.f63f;
            goto L86
        L68:
            kotlin.n0.d.o.g("DelayTaskDispatcher", "classname");
            kotlin.n0.d.o.g("Start dispatch 8s tasks...", "message");
            if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L76;
            String r44 = b.a.a.a.a.b("DelayTaskDispatcher", ' ', "Start dispatch 8s tasks...");
            int r45 = r44.length();
            int r125 = 0;
            int r46 = 1;
        L72:
            if (r46 > 100) goto L76;
            if (r45 <= r3) goto L75;
            int r47 = b.a.a.a.a.a(r44, r125, r3, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r46), r3, 3072);
            r46 = r46 + 1;
            r125 = r3;
            r3 = r47;
            goto L72
        L75:
            b.a.a.a.a.f(r44, r125, r45, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r46));
        L76:
            a.b.a.a.j.b r48 = a.b.a.a.j.b.f40c;
            long r49 = System.currentTimeMillis();
            k r50 = k.f58h;
            r48.f("Start_Dispatch_8s", r49 - k.f56f, true);
            r2 = C0002b.f62f;
            goto L86
        L77:
            kotlin.n0.d.o.g("DelayTaskDispatcher", "classname");
            kotlin.n0.d.o.g("Start dispatch 5s tasks...", "message");
            if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L85;
            String r51 = b.a.a.a.a.b("DelayTaskDispatcher", ' ', "Start dispatch 5s tasks...");
            int r52 = r51.length();
            int r126 = 0;
            int r53 = 1;
        L81:
            if (r53 > 100) goto L85;
            if (r52 <= r3) goto L84;
            int r54 = b.a.a.a.a.a(r51, r126, r3, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r53), r3, 3072);
            r53 = r53 + 1;
            r126 = r3;
            r3 = r54;
            goto L81
        L84:
            b.a.a.a.a.f(r51, r126, r52, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r53));
        L85:
            a.b.a.a.j.b r55 = a.b.a.a.j.b.f40c;
            long r56 = System.currentTimeMillis();
            k r57 = k.f58h;
            r55.f("Start_Dispatch_5s", r56 - k.f56f, true);
            r2 = a.f61f;
        L87:
            return true;
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f70f = null;

        static {
            f70f = new c();
        }

        public c() {
            super(0);
        }

        @Override // kotlin.n0.c.a
        public f0 invoke() {
            a.b.a.a.j.b.f40c.a();
            return f0.f18324a;
        }
    }

    static {
        f58h = new k();
        f51a = new LinkedHashMap();
        f53c = new AtomicInteger(0);
        f56f = -1;
        f57g = new Handler(Looper.getMainLooper(), b.f60f);
    }

    public k() {
    }

    public static final /* synthetic */ void b(k r0) {
        r0.h();
    }

    public static final /* synthetic */ void c(k r0, com.bytedance.lego.init.e.c r1, boolean r2) {
        r0.e(r1, r2);
    }

    public static final /* synthetic */ void d(k r0, PriorityQueue r1) {
        r0.g(r1);
    }

    public final Handler a() {
        return f57g;
    }

    public final void e(com.bytedance.lego.init.e.c r18, boolean r19) {
        long r7 = System.currentTimeMillis();     // Catch: Exception -> L42
        a.b.a.a.j.b.f40c.g(r18, r19);     // Catch: Exception -> L42
        StringBuilder r9 = new StringBuilder();     // Catch: Exception -> L42
        r9.append(r18.f4862f);     // Catch: Exception -> L42
        r9.append(" start. startTimeFromOnCreateEnd: ");     // Catch: Exception -> L42
        r9.append(r7 - f56f);     // Catch: Exception -> L42
        String r10 = r9.toString();     // Catch: Exception -> L42
        kotlin.n0.d.o.g("DelayTaskDispatcher", "classname");     // Catch: Exception -> L42
        kotlin.n0.d.o.g(r10, "message");     // Catch: Exception -> L42
        int r11 = 100;
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L14;
        String r12 = "DelayTaskDispatcher " + r10;     // Catch: Exception -> L42
        int r13 = r12.length();     // Catch: Exception -> L42
        int r14 = 1;
        int r15 = 3072;
        int r16 = 0;
    L10:
        if (r14 > r11) goto L14;
        if (r13 <= r15) goto L13;
        String r17 = r12.substring(r16, r15);     // Catch: Exception -> L42
        kotlin.n0.d.o.b(r17, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: Exception -> L42
        Log.d("#inittask#" + r14, r17);     // Catch: Exception -> L42
        r14 = r14 + 1;     // Catch: Exception -> L42
        r16 = r15;
        r15 = r15 + 3072;     // Catch: Exception -> L42
        r11 = 100;
        goto L10
    L13:
        String r20 = r12.substring(r16, r13);     // Catch: Exception -> L42
        kotlin.n0.d.o.b(r20, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: Exception -> L42
        Log.d("#inittask#" + r14, r20);     // Catch: Exception -> L42
    L14:
        StringBuilder r21 = new StringBuilder();     // Catch: Exception -> L42
        r21.append(r18.f4862f);     // Catch: Exception -> L42
        r21.append(" run. isUIThread: ");     // Catch: Exception -> L42
        r21.append(r19);     // Catch: Exception -> L42
        String r22 = r21.toString();     // Catch: Exception -> L42
        kotlin.n0.d.o.g("DelayTaskDispatcher", "classname");     // Catch: Exception -> L42
        kotlin.n0.d.o.g(r22, "message");     // Catch: Exception -> L42
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L24;
        String r23 = "DelayTaskDispatcher " + r22;     // Catch: Exception -> L42
        int r110 = r23.length();     // Catch: Exception -> L42
        int r111 = 1;
        int r112 = 3072;
        int r113 = 0;
        int r114 = 100;
    L20:
        if (r111 > r114) goto L24;
        if (r110 <= r112) goto L23;
        String r115 = r23.substring(r113, r112);     // Catch: Exception -> L42
        kotlin.n0.d.o.b(r115, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: Exception -> L42
        Log.d("#inittask#" + r111, r115);     // Catch: Exception -> L42
        r111 = r111 + 1;     // Catch: Exception -> L42
        r114 = 100;
        r113 = r112;
        r112 = r112 + 3072;     // Catch: Exception -> L42
        goto L20
    L23:
        String r24 = r23.substring(r113, r110);     // Catch: Exception -> L42
        kotlin.n0.d.o.b(r24, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: Exception -> L42
        Log.d("#inittask#" + r111, r24);     // Catch: Exception -> L42
    L24:
        r18.f4864h.run();     // Catch: Exception -> L42
        long r25 = System.currentTimeMillis();     // Catch: Exception -> L42
        a.b.a.a.j.b r116 = a.b.a.a.j.b.f40c;     // Catch: Exception -> L42
        r116.d(r18, r19);     // Catch: Exception -> L42
        long r8 = r25 - r7;     // Catch: Exception -> L42
        r116.c(r18, r8, r19);     // Catch: Exception -> L42
        StringBuilder r0 = new StringBuilder();     // Catch: Exception -> L42
        r0.append(r18.f4862f);     // Catch: Exception -> L42
        r0.append(" end. endTimeFromOnCreateEnd: ");     // Catch: Exception -> L42
        r0.append(r25 - f56f);     // Catch: Exception -> L42
        r0.append(", cos ");     // Catch: Exception -> L42
        r0.append(r8);     // Catch: Exception -> L42
        r0.append(" ms.");     // Catch: Exception -> L42
        String r1 = r0.toString();     // Catch: Exception -> L42
        kotlin.n0.d.o.g("DelayTaskDispatcher", "classname");     // Catch: Exception -> L42
        kotlin.n0.d.o.g(r1, "message");     // Catch: Exception -> L42
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L39;
        String r2 = "DelayTaskDispatcher " + r1;     // Catch: Exception -> L42
        int r26 = r2.length();     // Catch: Exception -> L42
        int r27 = 0;
        int r117 = 3072;
        int r118 = 1;
    L34:
        if (r118 > 100) goto L39;
        if (r26 <= r117) goto L37;
        String r28 = r2.substring(r27, r117);     // Catch: Exception -> L42
        kotlin.n0.d.o.b(r28, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: Exception -> L42
        Log.d("#inittask#" + r118, r28);     // Catch: Exception -> L42
        r118 = r118 + 1;     // Catch: Exception -> L42
        int r119 = r117;
        r117 = r117 + 3072;     // Catch: Exception -> L42
        r27 = r119;
        goto L34
    L37:
        String r3 = r2.substring(r27, r26);     // Catch: Exception -> L42
        kotlin.n0.d.o.b(r3, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: Exception -> L42
        Log.d("#inittask#" + r118, r3);     // Catch: Exception -> L42
    L39:
        if (f53c.incrementAndGet() != f52b) goto L56;
        i();     // Catch: Exception -> L42
        return;
    L56:
        return;
    L42:
        e = move-exception;
        StringBuilder r29 = b.a.a.a.a.e("\nerror!error!error!  ");
        r29.append(r18.f4862f);
        r29.append(" run error.\n");
        String r30 = r29.toString();
        kotlin.n0.d.o.g("DelayTaskDispatcher", "classname");
        kotlin.n0.d.o.g(r30, "message");
        Log.e("#inittask#", "DelayTaskDispatcher " + r30);
        String r31 = Log.getStackTraceString(e);
        kotlin.n0.d.o.b(r31, "Log.getStackTraceString(e)");
        kotlin.n0.d.o.g("DelayTaskDispatcher", "classname");
        kotlin.n0.d.o.g(r31, "message");
        Log.e("#inittask#", "DelayTaskDispatcher " + r31);
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() == false) goto L47;
        InitMonitor r4 = InitMonitor.INSTANCE;
        StringBuilder r5 = b.a.a.a.a.e("RUN_DELAY_TASK_EXCEPTION:");
        r5.append(r18.f4862f);
        r4.ensureNotReachHere(e, r5.toString());
        return;
    L47:
        throw e;
    }

    public final void f(List<? extends com.bytedance.lego.init.e.c> r11) {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        if (r11 == null) goto L30;
        StringBuilder r10 = new StringBuilder("\n-------------------------   AllDelayTasks   ------------------------\n");
        Iterator r12 = kotlin.i0.r.r0(r11).iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        com.bytedance.lego.init.e.c r0 = (com.bytedance.lego.init.e.c) r12.next();
        if (a.b.a.a.c.b(r0) == false) goto L8;
        StringBuilder r1 = new StringBuilder();
        r1.append(r0);
        r1.append('\n');
        r10.append(r1.toString());
        goto L8
    L12:
        String r13 = r10.toString();
        kotlin.n0.d.o.b(r13, "sb.toString()");
        kotlin.n0.d.o.g("DelayTaskDispatcher", "classname");
        kotlin.n0.d.o.g(r13, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L31;
        String r14 = b.a.a.a.a.b("DelayTaskDispatcher", ' ', r13);
        int r15 = r14.length();
        int r2 = 0;
        int r3 = 3072;
        int r9 = 1;
    L16:
        int r4 = r2;
        r2 = r3;
        if (r9 > 100) goto L32;
        if (r15 <= r2) goto L21;
        r3 = b.a.a.a.a.a(r14, r4, r2, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r9), r2, 3072);
        r9 = r9 + 1;
        goto L16
    L21:
        b.a.a.a.a.f(r14, r4, r15, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r9));
        return;
    L32:
        return;
    L31:
        return;
    }

    public final void g(PriorityQueue<com.bytedance.lego.init.e.c> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if ((!r2.isEmpty()) == false) goto L8;
        a.b.a.a.c.a(new a(r2.poll()));
        goto L4
    }

    @WorkerThread
    public final void h() {
        if (f55e == false) goto L5;
        return;
    L5:
        int r0 = 1;
        f55e = true;
        StringBuilder r1 = b.a.a.a.a.e("initDelayTasks, curTimeFromCreateEnd: ");
        r1.append(System.currentTimeMillis() - f56f);
        String r2 = r1.toString();
        kotlin.n0.d.o.g("DelayTaskDispatcher", "classname");
        kotlin.n0.d.o.g(r2, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L13;
        String r3 = b.a.a.a.a.b("DelayTaskDispatcher", ' ', r2);
        int r5 = r3.length();
        int r15 = 1;
        int r13 = 0;
        int r14 = 3072;
    L9:
        if (r15 > 100) goto L13;
        if (r5 <= r14) goto L12;
        int r19 = r14;
        r14 = b.a.a.a.a.a(r3, r13, r14, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r15), r19, 3072);
        r15 = r15 + 1;
        r13 = r19;
        goto L9
    L12:
        b.a.a.a.a.f(r3, r13, r5, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r15));
    L13:
        long r12 = System.currentTimeMillis();
        List<com.bytedance.lego.init.e.c> r4 = com.bytedance.lego.init.d.a();
        if (r4 == null) goto L29;
        Iterator<T> r6 = r4.iterator();
    L17:
        if (r6.hasNext() == false) goto L29;
        com.bytedance.lego.init.e.c r8 = (com.bytedance.lego.init.e.c) r6.next();
        kotlin.n0.d.o.b(r8, "delayTaskInfo");
        if (a.b.a.a.c.b(r8) == false) goto L17;
        Map<com.bytedance.lego.init.e.d, PriorityQueue<com.bytedance.lego.init.e.c>> r16 = f51a;
        if (r16.get(r8.f4868l) != null) goto L25;
        com.bytedance.lego.init.e.d r17 = r8.f4868l;
        kotlin.n0.d.o.b(r17, "delayTaskInfo.delayTime");
        r16.put(r17, new PriorityQueue());
        f0 r10 = f0.f18324a;
    L25:
        PriorityQueue<com.bytedance.lego.init.e.c> r11 = r16.get(r8.f4868l);
        if (r11 == null) goto L28;
        r11.add(r8);
    L28:
        f52b++;
    L29:
        long r18 = System.currentTimeMillis();
        f(r4);
        StringBuilder r7 = new StringBuilder();
        r7.append("init cos: ");
        long r110 = r18 - r12;
        r7.append(r110);
        String r9 = r7.toString();
        kotlin.n0.d.o.g("DelayTaskDispatcher", "classname");
        kotlin.n0.d.o.g(r9, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L37;
        String r20 = b.a.a.a.a.b("DelayTaskDispatcher", ' ', r9);
        int r21 = r20.length();
        int r22 = 0;
        int r23 = 3072;
    L33:
        if (r0 > 100) goto L37;
        if (r21 <= r23) goto L36;
        int r24 = b.a.a.a.a.a(r20, r22, r23, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r0), r23, 3072);
        r0 = r0 + 1;
        int r27 = r23;
        r23 = r24;
        r22 = r27;
        goto L33
    L36:
        b.a.a.a.a.f(r20, r22, r21, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r0));
    L37:
        a.b.a.a.j.b.f40c.f("DelayTaskDispatcher.initDelayTasks", r110, false);
    }

    public final void i() {
        kotlin.n0.d.o.g("DelayTaskDispatcher", "classname");     // Catch: Exception -> L17
        kotlin.n0.d.o.g("sendMonitorData", "message");     // Catch: Exception -> L17
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L15;
        String r9 = "DelayTaskDispatcher sendMonitorData";     // Catch: Exception -> L17
        int r0 = r9.length();     // Catch: Exception -> L17
        int r3 = 0;
        int r1 = 3072;
        int r4 = 1;
    L10:
        if (r4 > 100) goto L15;
        if (r0 <= r1) goto L14;
        String r5 = r9.substring(r3, r1);     // Catch: Exception -> L17
        kotlin.n0.d.o.b(r5, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: Exception -> L17
        Log.d("#inittask#" + r4, r5);     // Catch: Exception -> L17
        r4 = r4 + 1;     // Catch: Exception -> L17
        r3 = r1;
        r1 = r1 + 3072;     // Catch: Exception -> L17
        goto L10
    L14:
        String r10 = r9.substring(r3, r0);     // Catch: Exception -> L17
        kotlin.n0.d.o.b(r10, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: Exception -> L17
        Log.d("#inittask#" + r4, r10);     // Catch: Exception -> L17
    L15:
        a.b.a.a.c.a(c.f70f);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "DELAY_TASK_MONITOR_EXCEPTION");
    }

    public final synchronized void j() {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (f54d == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        int r0 = 1;
        f54d = true;     // Catch: Throwable -> L20
        f56f = System.currentTimeMillis();     // Catch: Throwable -> L20
        StringBuilder r2 = b.a.a.a.a.e("start, curTime: ");     // Catch: Throwable -> L20
        r2.append(f56f);     // Catch: Throwable -> L20
        String r3 = r2.toString();     // Catch: Throwable -> L20
        kotlin.n0.d.o.g("DelayTaskDispatcher", "classname");     // Catch: Throwable -> L20
        kotlin.n0.d.o.g(r3, "message");     // Catch: Throwable -> L20
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L17;
        String r1 = b.a.a.a.a.b("DelayTaskDispatcher", ' ', r3);     // Catch: Throwable -> L20
        int r4 = r1.length();     // Catch: Throwable -> L20
        int r5 = 0;
        int r6 = 3072;
    L12:
        int r7 = r5;
        r5 = r6;
        if (r0 > 100) goto L17;
        if (r4 <= r5) goto L16;
        r6 = b.a.a.a.a.a(r1, r7, r5, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r0), r5, 3072);     // Catch: Throwable -> L20
        r0 = r0 + 1;     // Catch: Throwable -> L20
        goto L12
    L16:
        b.a.a.a.a.f(r1, r7, r4, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r0));     // Catch: Throwable -> L20
    L17:
        a.b.a.a.j.b.f40c.b(f56f);     // Catch: Throwable -> L20
        Handler r8 = f57g;     // Catch: Throwable -> L20
        r8.sendEmptyMessageDelayed(1001, CoroutineLiveDataKt.DEFAULT_TIMEOUT);     // Catch: Throwable -> L20
        r8.sendEmptyMessageDelayed(1002, 8000);     // Catch: Throwable -> L20
        r8.sendEmptyMessageDelayed(1003, IdleTaskConfig.IDLE_START_TIME_OUT);     // Catch: Throwable -> L20
        r8.sendEmptyMessageDelayed(1004, 30000);     // Catch: Throwable -> L20
        r8.sendEmptyMessageDelayed(TTVideoUploaderListener.EndTimeUploadStage5, 60000);     // Catch: Throwable -> L20
        r8.sendEmptyMessageDelayed(PointerIconCompat.TYPE_CELL, 120000);     // Catch: Throwable -> L20
        r8.sendEmptyMessageDelayed(PointerIconCompat.TYPE_CROSSHAIR, 300000);     // Catch: Throwable -> L20
        r8.sendEmptyMessageDelayed(PointerIconCompat.TYPE_TEXT, 600000);     // Catch: Throwable -> L20
        r8.sendEmptyMessageDelayed(PointerIconCompat.TYPE_VERTICAL_TEXT, 900000);     // Catch: Throwable -> L20
        monitor-exit(this);
    }
}
