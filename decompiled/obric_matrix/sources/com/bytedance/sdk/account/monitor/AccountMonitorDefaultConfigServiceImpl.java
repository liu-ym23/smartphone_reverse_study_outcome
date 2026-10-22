package com.bytedance.sdk.account.monitor;

import com.bytedance.sdk.account.monitor.settings.IAccountMonitorDefaultConfigService;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.c0;
import kotlin.f0;
import kotlin.h;
import kotlin.i;
import kotlin.n0.d.e0;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;
import kotlin.u;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\r\u001a\u00020\u00068V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/account/monitor/AccountMonitorDefaultConfigServiceImpl;", "Lcom/bytedance/sdk/account/monitor/settings/IAccountMonitorDefaultConfigService;", "Lkotlin/Function1;", "Lcom/bytedance/sdk/account/monitor/AccountMonitorDefaultConfigServiceImpl$a;", "Lkotlin/f0;", "build", "Lcom/bytedance/sdk/account/monitor/settings/b;", "buildConfig", "(Lkotlin/n0/c/l;)Lcom/bytedance/sdk/account/monitor/settings/b;", "defaultMonitorConfig$delegate", "Lkotlin/h;", "getDefaultMonitorConfig", "()Lcom/bytedance/sdk/account/monitor/settings/b;", "defaultMonitorConfig", "<init>", "()V", "a", "account-sdk-core_release"}, k = 1, mv = {1, 1, 15})
public final class AccountMonitorDefaultConfigServiceImpl implements IAccountMonitorDefaultConfigService {
    static final /* synthetic */ l[] $$delegatedProperties = null;
    private final h defaultMonitorConfig$delegate;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.sdk.account.monitor.settings.b f5643a;

        private a(int r5) {
            this.f5643a = new com.bytedance.sdk.account.monitor.settings.b(true, r5, "<account default>", null);
        }

        public /* synthetic */ a(int r1, g r2) {
            this(r1);
        }

        public final void a(u<String, com.bytedance.sdk.account.monitor.settings.a>... r6) {
            o.g(r6, "eventConfigs");
            int r0 = r6.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            u<String, com.bytedance.sdk.account.monitor.settings.a> r2 = r6[r1];
            String r3 = r2.a();
            com.bytedance.sdk.account.monitor.settings.a r4 = r2.b();
            this.f5643a.b(r3, r4);
            r1 = r1 + 1;
            goto L3
        }

        public final com.bytedance.sdk.account.monitor.settings.a b() {
            return new com.bytedance.sdk.account.monitor.settings.a(this.f5643a, 0, null, 0, null, null, null, false, 252, null);
        }

        public final com.bytedance.sdk.account.monitor.settings.b c() {
            return this.f5643a;
        }

        public final com.bytedance.sdk.account.monitor.settings.a d(int r13) {
            return new com.bytedance.sdk.account.monitor.settings.a(this.f5643a, r13, null, 0, null, null, null, false, 244, null);
        }
    }

    static final class b extends q implements kotlin.n0.c.a<com.bytedance.sdk.account.monitor.settings.b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ AccountMonitorDefaultConfigServiceImpl f5644f;

        static final class a extends q implements kotlin.n0.c.l<a, f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final a f5645f = null;

            /* JADX INFO: renamed from: com.bytedance.sdk.account.monitor.AccountMonitorDefaultConfigServiceImpl$b$a$a, reason: collision with other inner class name */
            static final class C0178a extends q implements kotlin.n0.c.l<com.bytedance.sdk.account.monitor.f.d.a, com.bytedance.sdk.account.monitor.f.g> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                public static final C0178a f5646f = null;

                static {
                    f5646f = new C0178a();
                }

                C0178a() {
                    super(1);
                }

                public final com.bytedance.sdk.account.monitor.f.g a(com.bytedance.sdk.account.monitor.f.d.a r2) {
                    o.g(r2, "$receiver");
                    return r2.a("key_type", "ree_ecdh_hmac");
                }

                @Override // kotlin.n0.c.l
                public /* bridge */ /* synthetic */ com.bytedance.sdk.account.monitor.f.g invoke(com.bytedance.sdk.account.monitor.f.d.a r1) {
                    return a(r1);
                }
            }

            static {
                f5645f = new a();
            }

            a() {
                super(1);
            }

            public final void a(a r14) {
                o.g(r14, "$receiver");
                r14.a(new u[]{a0.a("bd_ticket_guard_downstream_use_ticket_fail", new com.bytedance.sdk.account.monitor.settings.a(r14.c(), 100, null, 0, null, null, null, true, 116, null)), a0.a("bd_ticket_guard_downstream_use_ticket_fail_no_sign", r14.d(1000)), a0.a("bd_ticket_guard_use_ticket_fail", new com.bytedance.sdk.account.monitor.settings.a(r14.c(), 0, null, 0, null, null, null, true, 126, null)), a0.a("bd_ticket_guard_use_ticket_fail_no_sign", new com.bytedance.sdk.account.monitor.settings.a(r14.c(), 0, null, 0, null, null, null, true, 126, null)), a0.a("bd_ticket_guard_create_signature", new com.bytedance.sdk.account.monitor.settings.a(r14.c(), 1000, null, 0, com.bytedance.sdk.account.monitor.f.d.f5677a.a(C0178a.f5646f), null, null, false, 228, null)), a0.a("bd_ticket_guard_add_get_ticket_headers", r14.b()), a0.a("bd_ticket_guard_add_use_ticket_headers", r14.b()), a0.a("bd_ticket_guard_full_path", new com.bytedance.sdk.account.monitor.settings.a(r14.c(), 20, null, 1, null, null, null, true, 116, null)), a0.a("passport_full_path", new com.bytedance.sdk.account.monitor.settings.a(r14.c(), 20, null, 1, null, null, null, true, 116, null))});
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ f0 invoke(a r1) {
                a(r1);
                return f0.f18324a;
            }
        }

        b(AccountMonitorDefaultConfigServiceImpl r1) {
            this.f5644f = r1;
            super(0);
        }

        public final com.bytedance.sdk.account.monitor.settings.b a() {
            return AccountMonitorDefaultConfigServiceImpl.access$buildConfig(this.f5644f, a.f5645f);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ com.bytedance.sdk.account.monitor.settings.b invoke() {
            return a();
        }
    }

    static {
        $$delegatedProperties = new l[]{e0.g(new y(e0.b(AccountMonitorDefaultConfigServiceImpl.class), "defaultMonitorConfig", "getDefaultMonitorConfig()Lcom/bytedance/sdk/account/monitor/settings/MonitorConfig;"))};
    }

    public AccountMonitorDefaultConfigServiceImpl() {
        this.defaultMonitorConfig$delegate = i.b(new b(this));
    }

    public static final /* synthetic */ com.bytedance.sdk.account.monitor.settings.b access$buildConfig(AccountMonitorDefaultConfigServiceImpl r0, kotlin.n0.c.l r1) {
        return r0.buildConfig(r1);
    }

    private final com.bytedance.sdk.account.monitor.settings.b buildConfig(kotlin.n0.c.l<? super a, f0> r3) {
        int r2 = getDefaultSeed();
        c0.b(r2);
        a r0 = new a(r2, null);
        r3.invoke(r0);
        return r0.c();
    }

    @Override // com.bytedance.sdk.account.monitor.settings.IAccountMonitorDefaultConfigService
    public com.bytedance.sdk.account.monitor.settings.b getDefaultMonitorConfig() {
        h r2 = this.defaultMonitorConfig$delegate;
        l r0 = $$delegatedProperties[0];
        return (com.bytedance.sdk.account.monitor.settings.b) r2.getValue();
    }

    @Override // com.bytedance.sdk.account.monitor.settings.IAccountMonitorDefaultConfigService
    public int getDefaultSeed() {
        return IAccountMonitorDefaultConfigService.a.a(this);
    }
}
