package com.bytedance.sdk.account.monitor.settings;

import java.util.concurrent.ThreadLocalRandom;
import kotlin.c0;
import kotlin.h;
import kotlin.i;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.f;
import kotlin.s0.l;
import kotlin.u0.k;
import kotlin.u0.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c extends com.bytedance.sdk.account.settings.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final /* synthetic */ l[] f5703h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final h f5704i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final kotlin.p0.c f5705j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final com.bytedance.sdk.account.settings.c.b f5706k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c f5707l = null;

    static final class a extends q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f5708f = null;

        static {
            f5708f = new a();
        }

        a() {
            super(0);
        }

        public final int a() {
            return ThreadLocalRandom.current().nextInt();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(a());
        }
    }

    static final /* synthetic */ class b extends kotlin.n0.d.l implements kotlin.n0.c.l<JSONObject, com.bytedance.sdk.account.monitor.settings.b> {
        b(c r2) {
            super(1, r2);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "parseMonitorConfig";
        }

        @Override // kotlin.n0.d.c
        public final f getOwner() {
            return e0.b(c.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "parseMonitorConfig(Lorg/json/JSONObject;)Lcom/bytedance/sdk/account/monitor/settings/MonitorConfig;";
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ com.bytedance.sdk.account.monitor.settings.b invoke(JSONObject r1) {
            return m(r1);
        }

        public final com.bytedance.sdk.account.monitor.settings.b m(JSONObject r1) {
            return ((c) this.receiver).o(r1);
        }
    }

    static {
        f5703h = new l[]{e0.g(new y(e0.b(c.class), "defaultSeed", "getDefaultSeed()I")), e0.g(new y(e0.b(c.class), "defaultConfig", "getDefaultConfig()Lcom/bytedance/sdk/account/monitor/settings/IAccountMonitorDefaultConfigService;")), e0.g(new y(e0.b(c.class), "monitorConfig", "getMonitorConfig()Lcom/bytedance/sdk/account/monitor/settings/MonitorConfig;"))};
        c r0 = new c();
        f5707l = r0;
        f5704i = i.b(a.f5708f);
        f5705j = new d.b.s.a.g0.a.a(IAccountMonitorDefaultConfigService.class);
        f5706k = r0.k(new b(r0));
    }

    private c() {
    }

    private final IAccountMonitorDefaultConfigService l() {
        return (IAccountMonitorDefaultConfigService) f5705j.a(this, f5703h[1]);
    }

    @Override // com.bytedance.sdk.account.settings.c
    public String e() {
        return "account_monitor_config";
    }

    public final int m() {
        h r2 = f5704i;
        l r0 = f5703h[0];
        return ((Number) r2.getValue()).intValue();
    }

    public final com.bytedance.sdk.account.monitor.settings.b n() {
        return (com.bytedance.sdk.account.monitor.settings.b) f5706k.f(this, f5703h[2]);
    }

    public final com.bytedance.sdk.account.monitor.settings.b o(JSONObject r7) {
        if (r7 != null) goto L5;
    L26:
        IAccountMonitorDefaultConfigService r6 = l();
        if (r6 != null) goto L29;
        return null;
    L29:
        return r6.getDefaultMonitorConfig();
    L5:
        if (r7.length() == 0) goto L26;
        JSONObject r1 = r7.optJSONObject("event_config");
        if (r1 == null) goto L22;
        String r2 = r7.optString("config_version", "<no version>");
        boolean r3 = r7.optBoolean("enable_monitor_config", true);
        String r8 = r7.optString("sample_seed", String.valueOf(m()));
        o.b(r8, "it");
        int r5 = 0;
        if (k.s0(r8, '-', false, 2, null) == false) goto L14;
        Integer r9 = k.i(r8);
        if (r9 == null) goto L30;
        r5 = r9.intValue();
        c0.b(r5);
    L30:
        com.bytedance.sdk.account.monitor.settings.b.a r10 = com.bytedance.sdk.account.monitor.settings.b.f5698e;     // Catch: Exception -> L19
        o.b(r2, "configVersion");     // Catch: Exception -> L19
        return r10.a(r3, r1, r5, r2);
    L19:
        e = move-exception;
        d.b.s.a.a0.a.c("AccountMonitorSettings", "parse monitor config failed", e);
        return null;
    L14:
        c0 r11 = x.b(r8);
        if (r11 == null) goto L30;
        r5 = r11.k();
        goto L30
    L22:
        IAccountMonitorDefaultConfigService r12 = l();
        if (r12 != null) goto L25;
        return null;
    L25:
        return r12.getDefaultMonitorConfig();
    }
}
