package com.bytedance.sdk.account.monitor;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.b0;
import kotlin.c0;
import kotlin.h0;
import kotlin.i;
import kotlin.i0.t0;
import kotlin.n0.c.p;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ l[] f5650a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.h f5651b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlin.h f5652c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f5653d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f5654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f5655b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f5656c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f5657d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f5658e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final JSONObject f5659f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Set<String> f5660g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f5661h;

        public a(boolean r2, boolean r3, String r4, String r5, int r6, JSONObject r7, Set<String> r8, boolean r9) {
            o.g(r4, LocationMonitorConst.INFO);
            o.g(r5, "configVersion");
            o.g(r8, "logParams");
            this.f5654a = r2;
            this.f5655b = r3;
            this.f5656c = r4;
            this.f5657d = r5;
            this.f5658e = r6;
            this.f5659f = r7;
            this.f5660g = r8;
            this.f5661h = r9;
        }

        public final String a() {
            return this.f5657d;
        }

        public final JSONObject b() {
            return this.f5659f;
        }

        public final boolean c() {
            return this.f5655b;
        }

        public final String d() {
            return this.f5656c;
        }

        public final boolean e() {
            return this.f5661h;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L5;
        L36:
            return true;
        L5:
            if ((r5 instanceof a) == false) goto L35;
            a r6 = (a) r5;
            if (this.f5654a != r6.f5654a) goto L9;
            boolean r1 = true;
        L10:
            if (r1 == false) goto L35;
            if (this.f5655b != r6.f5655b) goto L14;
            boolean r2 = true;
        L15:
            if (r2 == false) goto L35;
            if (o.a(this.f5656c, r6.f5656c) == false) goto L35;
            if (o.a(this.f5657d, r6.f5657d) == false) goto L35;
            if (this.f5658e != r6.f5658e) goto L23;
            boolean r3 = true;
        L24:
            if (r3 == false) goto L35;
            if (o.a(this.f5659f, r6.f5659f) == false) goto L35;
            if (o.a(this.f5660g, r6.f5660g) == false) goto L35;
            if (this.f5661h != r6.f5661h) goto L32;
            boolean r4 = true;
        L33:
            if (r4 == false) goto L35;
        L32:
            r4 = false;
            goto L33
        L23:
            r3 = false;
            goto L24
        L14:
            r2 = false;
            goto L15
        L9:
            r1 = false;
        L35:
            return false;
        }

        public final Set<String> f() {
            return this.f5660g;
        }

        public final int g() {
            return this.f5658e;
        }

        public final boolean h() {
            return this.f5654a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v15, types: [int] */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v17 */
        public int hashCode() {
            boolean r0 = this.f5654a;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.f5655b;
            ?? r5 = r4;
            if (r4 == false) goto L8;
            r5 = 1;
        L8:
            int r6 = (r3 + r5) * 31;
            String r7 = this.f5656c;
            int r8 = 0;
            if (r7 == null) goto L11;
            int r9 = r7.hashCode();
        L12:
            int r10 = (r6 + r9) * 31;
            String r11 = this.f5657d;
            if (r11 == null) goto L15;
            int r12 = r11.hashCode();
        L16:
            int r13 = (((r10 + r12) * 31) + this.f5658e) * 31;
            JSONObject r14 = this.f5659f;
            if (r14 == null) goto L19;
            int r15 = r14.hashCode();
        L20:
            int r16 = (r13 + r15) * 31;
            Set<String> r17 = this.f5660g;
            if (r17 == null) goto L23;
            r8 = r17.hashCode();
        L23:
            int r18 = (r16 + r8) * 31;
            boolean r19 = this.f5661h;
            if (r19 == true) goto L28;
            r1 = r19;
        L28:
            return r18 + r1;
        L19:
            r15 = 0;
            goto L20
        L15:
            r12 = 0;
            goto L16
        L11:
            r9 = 0;
            goto L12
        }

        public String toString() {
            return "MonitorProcessorResult(shouldReport=" + this.f5654a + ", hasEventConfig=" + this.f5655b + ", info=" + this.f5656c + ", configVersion=" + this.f5657d + ", sampleRate=" + this.f5658e + ", createdParams=" + this.f5659f + ", logParams=" + this.f5660g + ", logAllParams=" + this.f5661h + ")";
        }
    }

    static final class b extends q implements kotlin.n0.c.l<String, a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f5662f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f5663g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.bytedance.sdk.account.monitor.settings.a f5664h;

        b(String r1, int r2, com.bytedance.sdk.account.monitor.settings.a r3) {
            this.f5662f = r1;
            this.f5663g = r2;
            this.f5664h = r3;
            super(1);
        }

        public final a a(String r11) {
            o.g(r11, "reason");
            String r5 = this.f5662f;
            int r6 = this.f5663g;
            Set<String> r1 = this.f5664h.b();
            if (r1 != null) goto L7;
            r1 = t0.b();
        L7:
            return new a(false, true, r11, r5, r6, null, r1, this.f5664h.a());
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ a invoke(String r1) {
            return a(r1);
        }
    }

    static final class c extends q implements p<String, JSONObject, a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f5665f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f5666g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.bytedance.sdk.account.monitor.settings.a f5667h;

        c(String r1, int r2, com.bytedance.sdk.account.monitor.settings.a r3) {
            this.f5665f = r1;
            this.f5666g = r2;
            this.f5667h = r3;
            super(2);
        }

        public final a a(String r11, JSONObject r12) {
            o.g(r11, LocationMonitorConst.INFO);
            o.g(r12, "params");
            String r5 = this.f5665f;
            int r6 = this.f5666g;
            Set<String> r1 = this.f5667h.b();
            if (r1 != null) goto L7;
            r1 = t0.b();
        L7:
            return new a(true, true, r11, r5, r6, r12, r1, this.f5667h.a());
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ a invoke(String r1, JSONObject r2) {
            return a(r1, r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.account.monitor.d$d, reason: collision with other inner class name */
    static final class C0179d extends q implements kotlin.n0.c.l<String, a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f5668f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.a f5669g;

        C0179d(c r1, kotlin.n0.c.a r2) {
            this.f5668f = r1;
            this.f5669g = r2;
            super(1);
        }

        public final a a(String r2) {
            o.g(r2, LocationMonitorConst.INFO);
            return this.f5668f.a(r2, com.bytedance.sdk.account.monitor.b.a(this.f5669g));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ a invoke(String r1) {
            return a(r1);
        }
    }

    static final class e extends q implements kotlin.n0.c.a<IAccountSdkMonitorService> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f5670f = null;

        static {
            f5670f = new e();
        }

        e() {
            super(0);
        }

        public final IAccountSdkMonitorService a() {
            return (IAccountSdkMonitorService) com.bytedance.news.common.service.manager.d.a(IAccountSdkMonitorService.class);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ IAccountSdkMonitorService invoke() {
            return a();
        }
    }

    static final class f extends q implements kotlin.n0.c.a<Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f5671f = null;

        static {
            f5671f = new f();
        }

        f() {
            super(0);
        }

        public final boolean a() {
            IAccountSdkMonitorService r0 = d.a(d.f5653d);
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isDebug();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(a());
        }
    }

    static final class g extends q implements kotlin.n0.c.a<JSONObject> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ JSONObject f5672f;

        g(JSONObject r1) {
            this.f5672f = r1;
            super(0);
        }

        public final JSONObject a() {
            return this.f5672f;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ JSONObject invoke() {
            return a();
        }
    }

    static final class h extends q implements kotlin.n0.c.l<String, StringBuilder> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ StringBuilder f5673f;

        h(StringBuilder r1) {
            this.f5673f = r1;
            super(1);
        }

        public final StringBuilder a(String r2) {
            o.g(r2, "$this$unaryPlus");
            StringBuilder r1 = this.f5673f;
            r1.append(r2);
            return r1;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ StringBuilder invoke(String r1) {
            return a(r1);
        }
    }

    static {
        f5650a = new l[]{e0.g(new y(e0.b(d.class), "commonParamsService", "getCommonParamsService()Lcom/bytedance/sdk/account/monitor/IAccountSdkMonitorService;")), e0.g(new y(e0.b(d.class), "debugMode", "getDebugMode()Z"))};
        f5653d = new d();
        f5651b = i.b(e.f5670f);
        f5652c = i.b(f.f5671f);
    }

    private d() {
    }

    public static final /* synthetic */ IAccountSdkMonitorService a(d r0) {
        return r0.e();
    }

    private final void b(String r5, JSONObject r6, a r7) {
    L22:
        e = move-exception;
        d.b.s.a.a0.a.c("MonitorProcessor", "addCommonParams error", e);
        return;
    L3:
        if (e() == null) goto L32;
        IAccountSdkMonitorService r8 = e();     // Catch: Exception -> L22
        if (r8 == null) goto L20;
        Iterator<Map.Entry<String, Object>> r9 = r8.getMonitorCommonParams(r5).entrySet().iterator();     // Catch: Exception -> L22
    L8:
        if (r9.hasNext() == false) goto L12;
        Map.Entry<String, Object> r1 = r9.next();     // Catch: Exception -> L22
        String r2 = r1.getKey();     // Catch: Exception -> L22
        Object r3 = r1.getValue();     // Catch: Exception -> L22
        if (r6.has(r2) == true) goto L8;
        r6.put(r2, r3);     // Catch: Exception -> L22
        goto L8
    L12:
        IAccountSdkMonitorService r4 = e();     // Catch: Exception -> L22
        if (r4 == null) goto L18;
        Iterator<Map.Entry<String, Object>> r10 = r4.getOverrideCommonParams(r5).entrySet().iterator();     // Catch: Exception -> L22
    L16:
        if (r10.hasNext() == false) goto L33;
        Map.Entry<String, Object> r11 = r10.next();     // Catch: Exception -> L22
        r6.put(r11.getKey(), r11.getValue());     // Catch: Exception -> L22
        goto L16
    L33:
        return;
    L18:
        o.p();     // Catch: Exception -> L22
        throw null;
    L20:
        o.p();     // Catch: Exception -> L22
        throw null;
    }

    private final void c(JSONObject r2, a r3) {
        r2.put("sample_rate", r3.g());
        r2.put("monitor_config_version", r3.a());
    }

    private final a d(com.bytedance.sdk.account.monitor.settings.a r8, String r9, kotlin.n0.c.a<? extends JSONObject> r10) {
        int r0 = r8.g();
        b r1 = new b(r9, r0, r8);
        c r2 = new c(r9, r0, r8);
        C0179d r11 = new C0179d(r2, r10);
        if (r0 < 0) goto L5;
        int r3 = r8.f();
        boolean r5 = true;
        if (r3 > 1) goto L9;
        com.bytedance.sdk.account.monitor.f.g r6 = r8.e();
        if (r6 == null) goto L16;
        JSONObject r12 = com.bytedance.sdk.account.monitor.b.a(r10);
        if (r6.a(r12) == true) goto L16;
        return r2.a("Sample if condition not met", r12);
    L16:
        if (r0 != 0) goto L20;
        return r1.a("Sample rate is 0");
    L20:
        if (r0 == 1) goto L37;
        if (r3 == 0) goto L30;
        if (r3 != 1) goto L25;
        int r7 = h(r8);
        c0.b(r0);
        if (h0.c(r7, r0) == 0) goto L33;
    L32:
        r5 = false;
    L33:
        if (r5 == true) goto L37;
        return r1.a("Intercept by sampler, Sample rate: " + r0 + ", sample mode: " + r3);
    L25:
        return r11.a("Illegal sample mode: " + r3);
    L30:
        if (g().nextInt(r0) != 0) goto L32;
    L37:
        return r11.a("Not intercepted by sampler, sample rate: " + r0 + ", sample mode: " + r3);
    L9:
        return r11.a("Illegal sample mode: " + r3);
    L5:
        return r11.a("Illegal sample rate: " + r0);
    }

    private final IAccountSdkMonitorService e() {
        kotlin.h r2 = f5651b;
        l r0 = f5650a[0];
        return (IAccountSdkMonitorService) r2.getValue();
    }

    private final boolean f() {
        kotlin.h r2 = f5652c;
        l r0 = f5650a[1];
        return ((Boolean) r2.getValue()).booleanValue();
    }

    private final ThreadLocalRandom g() {
        ThreadLocalRandom r1 = ThreadLocalRandom.current();
        o.b(r1, "ThreadLocalRandom.current()");
        return r1;
    }

    private final void l(String r4, kotlin.n0.c.a<? extends JSONObject> r5, a r6, boolean r7) {
        StringBuilder r3 = new StringBuilder();
        h r0 = new h(r3);
        r0.a("onEvent: << ");
        r0.a(r4);
        r0.a(" >>\n");
        r0.a("hasEventConfig: " + r6.c() + '\n');
        if (r6.c() == false) goto L5;
        r0.a("configVersion: " + r6.a() + '\n');
    L5:
        r0.a("doReport: " + r6.h() + '\n');
        if (r6.h() == false) goto L8;
        StringBuilder r8 = new StringBuilder();
        r8.append("reportSuccess: ");
        r8.append(r7);
    L9:
        r8.append('\n');
        r0.a(r8.toString());
        if (r6.e() == false) goto L12;
    L15:
        boolean r9 = true;
    L17:
        if ((true ^ r6.f().isEmpty()) == true) goto L19;
        if (r9 == true) goto L19;
    L33:
        String r10 = r3.toString();
        o.b(r10, "StringBuilder().apply(builderAction).toString()");
        if (r6.h() == false) goto L36;
        d.b.s.a.a0.a.d("AccountMonitor", r10);
        return;
    L36:
        d.b.s.a.a0.a.a("AccountMonitor", r10);
        return;
    L19:
        JSONObject r11 = r6.b();
        if (r11 != null) goto L23;
        r11 = r5.invoke();
    L23:
        if (r11 == null) goto L33;
        if (r11.length() <= 0) goto L33;
        if (r9 == false) goto L28;
        String r12 = r11.toString(2);
        o.b(r12, "params.toString(2)");
    L29:
        if (r9 == false) goto L31;
        StringBuilder r13 = new StringBuilder();
        String r14 = "params: ";
    L32:
        r13.append(r14);
        r13.append(r12);
        r0.a(r13.toString());
        goto L33
    L31:
        r13 = new StringBuilder();
        r14 = "params (filtered): ";
        goto L32
    L28:
        r12 = f5653d.m(r11, r6.f().iterator());
        goto L29
    L12:
        if (f5653d.f() == true) goto L15;
        r9 = false;
        goto L17
    L8:
        r8 = new StringBuilder();
        r8.append("noReportReason: ");
        r8.append(r6.d());
        goto L9
    }

    private final String m(JSONObject r3, Iterator<String> r4) {
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L8
    L4:
        if (r4.hasNext() == false) goto L6;
        String r0 = r4.next();     // Catch: Exception -> L8
        r2.put(r0, r3.get(r0));     // Catch: Exception -> L8
        goto L4
    L6:
        String r5 = r2.toString(2);     // Catch: Exception -> L8
        o.b(r5, "newJson.toString(2)");     // Catch: Exception -> L8
        return r5;
    L8:
        return "<paramsToString error>";
    }

    public final int h(com.bytedance.sdk.account.monitor.settings.a r6) {
        o.g(r6, "config");
        String r5 = r6.d();
        if (r5 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == true) goto L11;
        com.bytedance.sdk.account.monitor.g.a r8 = com.bytedance.sdk.account.monitor.g.a.f5688a;
        byte[][] r3 = new byte[2][];
        r3[0] = r8.f(r6.c().f());
        String r9 = r6.d();
        Charset r4 = kotlin.u0.d.f21429a;
        if (r9 == null) goto L17;
        byte[] r10 = r9.getBytes(r4);
        o.b(r10, "(this as java.lang.String).getBytes(charset)");
        r3[1] = r10;
        int r11 = com.bytedance.sdk.account.monitor.g.a.c(r8, r8.e(r3), 0, 2, null);
        c0.b(r11);
        return r11;
    L17:
        throw new b0("null cannot be cast to non-null type java.lang.String");
    L11:
        return r6.c().f();
    L5:
        if (r5.length() == 0) goto L8;
        r7 = false;
        goto L9
    }

    public final boolean i(String r2, com.bytedance.sdk.account.monitor.e.a r3, kotlin.n0.c.a<? extends JSONObject> r4) {
        o.g(r2, NotificationCompat.CATEGORY_EVENT);
        o.g(r3, "monitor");
        o.g(r4, "lazyParams");
        return j(r2, r3, true, r4);
    }

    public final boolean j(String r3, com.bytedance.sdk.account.monitor.e.a r4, boolean r5, kotlin.n0.c.a<? extends JSONObject> r6) {
        o.g(r3, NotificationCompat.CATEGORY_EVENT);
        o.g(r4, "monitor");
        o.g(r6, "lazyParams");
        a r0 = n(r3, r6);
        if (r0.h() == false) goto L12;
        JSONObject r1 = r0.b();
        if (r1 != null) goto L8;
        r1 = com.bytedance.sdk.account.monitor.b.a(r6);
    L8:
        c(r1, r0);
        if (r5 == false) goto L11;
        b(r3, r1, r0);
    L11:
        boolean r7 = r4.onEvent(r3, r1);
    L13:
        l(r3, r6, r0, r7);
        return r7;
    L12:
        r7 = false;
        goto L13
    }

    public final boolean k(String r2, JSONObject r3, com.bytedance.sdk.account.monitor.e.a r4, boolean r5) {
        o.g(r2, NotificationCompat.CATEGORY_EVENT);
        o.g(r3, "params");
        o.g(r4, "monitor");
        return j(r2, r4, r5, new g(r3));
    }

    public final a n(String r21, kotlin.n0.c.a<? extends JSONObject> r22) {
        o.g(r21, NotificationCompat.CATEGORY_EVENT);
        o.g(r22, "params");
        com.bytedance.sdk.account.monitor.settings.b r2 = com.bytedance.sdk.account.monitor.settings.c.f5707l.n();
        if (r2 == null) goto L14;
        if (r2.e() == false) goto L14;
        com.bytedance.sdk.account.monitor.settings.a r0 = r2.c(r21);
        if (r0 == null) goto L12;
        return d(r0, r2.d(), r22);
    L12:
        return new a(true, false, "Event does not exist in config", r2.d(), 1, com.bytedance.sdk.account.monitor.b.a(r22), t0.b(), false);
    L14:
        if (r2 != null) goto L16;
        String r3 = "Monitor config is null";
    L17:
        String r14 = r3;
        if (r2 == null) goto L22;
        String r4 = r2.d();
        if (r4 == null) goto L22;
    L24:
        return new a(true, false, r14, r4, 1, com.bytedance.sdk.account.monitor.b.a(r22), t0.b(), false);
    L22:
        r4 = "<null>";
        goto L24
    L16:
        r3 = "Monitor config is disabled";
        goto L17
    }
}
