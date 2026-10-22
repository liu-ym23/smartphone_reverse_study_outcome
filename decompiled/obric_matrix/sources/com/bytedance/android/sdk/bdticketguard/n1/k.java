package com.bytedance.android.sdk.bdticketguard.n1;

import com.bytedance.android.sdk.bdticketguard.s0;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.n0.d.o;
import kotlin.u;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f909b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f911b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f912c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f913d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f914e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f915f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Map<String, Long> f916g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Map<String, String> f917h;

        private a() {
            this(0, 0, 0, 0, 0, 0, null, null, 255, null);
        }

        private a(long r1, long r3, long r5, long r7, long r9, long r11, Map<String, Long> r13, Map<String, String> r14) {
            this.f910a = r1;
            this.f911b = r3;
            this.f912c = r5;
            this.f913d = r7;
            this.f914e = r9;
            this.f915f = r11;
            this.f916g = r13;
            this.f917h = r14;
        }

        public /* synthetic */ a(long r15, long r17, long r19, long r21, long r23, long r25, Map r27, Map r28, int r29, kotlin.n0.d.g r30) {
            if ((r29 & 1) == 0) goto L5;
            long r1 = l.f919c.a();
        L7:
            if ((r29 & 2) == 0) goto L9;
            long r3 = l.f919c.a();
        L11:
            if ((r29 & 4) == 0) goto L13;
            long r5 = l.f919c.a();
        L15:
            if ((r29 & 8) == 0) goto L17;
            long r7 = l.f919c.a();
        L19:
            if ((r29 & 16) == 0) goto L21;
            long r9 = l.f919c.a();
        L23:
            if ((r29 & 32) == 0) goto L25;
            long r11 = l.f919c.a();
        L27:
            if ((r29 & 64) == 0) goto L29;
            Map r13 = new ConcurrentHashMap();
        L31:
            if ((r29 & 128) == 0) goto L33;
            Map r0 = new ConcurrentHashMap();
        L34:
            this(r1, r3, r5, r7, r9, r11, r13, r0);
            return;
        L33:
            r0 = r28;
            goto L34
        L29:
            r13 = r27;
            goto L31
        L25:
            r11 = r25;
            goto L27
        L21:
            r9 = r23;
            goto L23
        L17:
            r7 = r21;
            goto L19
        L13:
            r5 = r19;
            goto L15
        L9:
            r3 = r17;
            goto L11
        L5:
            r1 = r15;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ a b(a r15, long r16, long r18, long r20, long r22, long r24, long r26, Map r28, Map r29, int r30, Object r31) {
            if ((r30 & 1) == 0) goto L5;
            long r2 = r15.f910a;
        L7:
            if ((r30 & 2) == 0) goto L9;
            long r4 = r15.f911b;
        L11:
            if ((r30 & 4) == 0) goto L13;
            long r6 = r15.f912c;
        L15:
            if ((r30 & 8) == 0) goto L17;
            long r8 = r15.f913d;
        L19:
            if ((r30 & 16) == 0) goto L21;
            long r10 = r15.f914e;
        L23:
            if ((r30 & 32) == 0) goto L25;
            long r12 = r15.f915f;
        L27:
            if ((r30 & 64) == 0) goto L29;
            Map r14 = r15.f916g;
        L31:
            if ((r30 & 128) == 0) goto L33;
            Map r1 = r15.f917h;
        L35:
            return r15.a(r2, r4, r6, r8, r10, r12, r14, r1);
        L33:
            r1 = r29;
            goto L35
        L29:
            r14 = r28;
            goto L31
        L25:
            r12 = r26;
            goto L27
        L21:
            r10 = r24;
            goto L23
        L17:
            r8 = r22;
            goto L19
        L13:
            r6 = r20;
            goto L15
        L9:
            r4 = r18;
            goto L11
        L5:
            r2 = r16;
            goto L7
        }

        public final a a(long r17, long r19, long r21, long r23, long r25, long r27, Map<String, Long> r29, Map<String, String> r30) {
            o.g(r29, "taskDurations");
            o.g(r30, "taskStatus");
            return new a(r17, r19, r21, r23, r25, r27, r29, r30);
        }

        public final long c() {
            return this.f913d;
        }

        public final long d() {
            return this.f914e;
        }

        public final long e() {
            return this.f910a;
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L5;
        L42:
            return true;
        L5:
            if ((r8 instanceof a) == false) goto L41;
            a r9 = (a) r8;
            if (this.f910a != r9.f910a) goto L9;
            boolean r1 = true;
        L10:
            if (r1 == false) goto L41;
            if (this.f911b != r9.f911b) goto L14;
            boolean r2 = true;
        L15:
            if (r2 == false) goto L41;
            if (this.f912c != r9.f912c) goto L19;
            boolean r3 = true;
        L20:
            if (r3 == false) goto L41;
            if (this.f913d != r9.f913d) goto L24;
            boolean r4 = true;
        L25:
            if (r4 == false) goto L41;
            if (this.f914e != r9.f914e) goto L29;
            boolean r5 = true;
        L30:
            if (r5 == false) goto L41;
            if (this.f915f != r9.f915f) goto L34;
            boolean r6 = true;
        L35:
            if (r6 == false) goto L41;
            if (o.a(this.f916g, r9.f916g) == false) goto L41;
            if (o.a(this.f917h, r9.f917h) == false) goto L41;
        L34:
            r6 = false;
            goto L35
        L29:
            r5 = false;
            goto L30
        L24:
            r4 = false;
            goto L25
        L19:
            r3 = false;
            goto L20
        L14:
            r2 = false;
            goto L15
        L9:
            r1 = false;
        L41:
            return false;
        }

        public final long f() {
            return this.f911b;
        }

        public final Map<String, Long> g() {
            return this.f916g;
        }

        public final Map<String, String> h() {
            return this.f917h;
        }

        public int hashCode() {
            int r0 = ((((((((((Long.hashCode(this.f910a) * 31) + Long.hashCode(this.f911b)) * 31) + Long.hashCode(this.f912c)) * 31) + Long.hashCode(this.f913d)) * 31) + Long.hashCode(this.f914e)) * 31) + Long.hashCode(this.f915f)) * 31;
            Map<String, Long> r1 = this.f916g;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            Map<String, String> r5 = this.f917h;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            return r4 + r2;
        L5:
            r3 = 0;
            goto L6
        }

        public final long i() {
            return this.f915f;
        }

        public final long j() {
            return this.f912c;
        }

        public String toString() {
            return "TimePoints(providedAppStartTime=" + l.h(this.f910a) + ", providerOnCreateTime=" + l.h(this.f911b) + ", tokenManagerInitTime=" + l.h(this.f912c) + ", initFinishTime=" + l.h(this.f913d) + ", preInitTime=" + l.h(this.f914e) + ", ticketSdkInitTime=" + l.h(this.f915f) + ", taskDurations=" + this.f916g + ", taskStatus=" + this.f917h + ")";
        }
    }

    static {
        f909b = new k();
        f908a = new a(0, 0, 0, 0, 0, 0, null, null, 255, null);
    }

    private k() {
    }

    public static final Map<String, Object> a() {
        u<l, String> r0 = f909b.b();
        long r1 = r0.a().i();
        Map<String, Object> r2 = m0.l(new u[]{a0.a("sdk_init_time", Long.valueOf(l.g(f908a.j(), f908a.c()))), a0.a("app_start_init_time", Long.valueOf(l.g(r1, f908a.c()))), a0.a("ticket_init_time", Long.valueOf(l.g(f908a.i(), f908a.c()))), a0.a("app_create_time_source", r0.b()), a0.a("app_create_to_ticket_init_time", Long.valueOf(l.g(r1, f908a.i()))), a0.a("app_create_to_token_init_time", Long.valueOf(l.g(r1, f908a.j()))), a0.a("app_create_to_token_preinit_time", Long.valueOf(l.g(r1, f908a.d()))), a0.a("token_init_to_ticket_sdk_init_time", Long.valueOf(l.g(f908a.j(), f908a.i())))});
        Iterator<Map.Entry<String, Long>> r3 = f908a.g().entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry<String, Long> r4 = r3.next();
        r2.put(r4.getKey() + "_init_duration", Long.valueOf(r4.getValue().longValue()));
        goto L4
    L6:
        Iterator<Map.Entry<String, String>> r5 = f908a.h().entrySet().iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        Map.Entry<String, String> r6 = r5.next();
        String r7 = r6.getKey();
        r2.put(r7 + "_init_state", r6.getValue());
        goto L8
    L10:
        return r2;
    }

    private final u<l, String> b() {
        if (l.f(f908a.e()) == false) goto L5;
        l r2 = l.b(f908a.e());
        String r0 = "provided";
    L7:
        return a0.a(r2, r0);
    L5:
        r2 = l.b(f908a.f());
        r0 = "provider";
        goto L7
    }

    public static final void c() {
        if (l.f(f908a.c()) == true) goto L6;
        f908a = a.b(f908a, 0, 0, 0, l.f919c.b(), 0, 0, null, null, 247, null);
        s0.f1065a.e("TicketInitTimeManager", "recordInitFinishTime: " + f908a + "}\n" + a());
        return;
    }

    public static final void d() {
        if (l.f(f908a.d()) == true) goto L6;
        f908a = a.b(f908a, 0, 0, 0, 0, l.f919c.b(), 0, null, null, 239, null);
        return;
    }

    public static final void e() {
        if (l.f(f908a.f()) == true) goto L6;
        f908a = a.b(f908a, 0, l.f919c.b(), 0, 0, 0, 0, null, null, 253, null);
        return;
    }

    public static final void f(String r3, long r4, String r6) {
        o.g(r3, "task");
        o.g(r6, "result");
        f908a.g().put(r3, Long.valueOf(Math.max(r4, -1)));
        f908a.h().put(r3, r6);
    }

    public static final void g() {
        if (l.f(f908a.i()) == true) goto L6;
        f908a = a.b(f908a, 0, 0, 0, 0, 0, l.f919c.b(), null, null, 223, null);
        return;
    }

    public static final void h() {
        if (l.f(f908a.j()) == true) goto L6;
        f908a = a.b(f908a, 0, 0, l.f919c.b(), 0, 0, 0, null, null, 251, null);
        return;
    }
}
