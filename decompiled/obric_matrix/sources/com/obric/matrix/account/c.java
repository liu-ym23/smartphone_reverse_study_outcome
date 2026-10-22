package com.obric.matrix.account;

import androidx.lifecycle.MutableLiveData;
import com.obric.matrix.larksso_api.ILarkSSOService;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00178Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/obric/matrix/account/LarkSSOGlobals;", "", "()V", "TAG", "", "larkAccessToken", "getLarkAccessToken", "()Ljava/lang/String;", "larkSSOAccount", "Landroidx/lifecycle/MutableLiveData;", "Lcom/obric/matrix/account/larksso/LarkSSOAccount;", "getLarkSSOAccount", "()Landroidx/lifecycle/MutableLiveData;", "larkSSOAccount$delegate", "Lkotlin/Lazy;", "larkSSOService", "Lcom/obric/matrix/larksso_api/ILarkSSOService;", "getLarkSSOService", "()Lcom/obric/matrix/larksso_api/ILarkSSOService;", "larkSSOService$delegate", "mInit", "", "userProfiler", "Lcom/obric/matrix/account/larksso/LarkSSOAccount$UserProfiler;", "getUserProfiler", "()Lcom/obric/matrix/account/larksso/LarkSSOAccount$UserProfiler;", "clearCache", "", "init", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8441a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.h f8442b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlin.h f8443c = null;

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "Lcom/obric/matrix/account/larksso/LarkSSOAccount;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements kotlin.n0.c.a<MutableLiveData<com.obric.matrix.account.larksso.a>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f8444f = null;

        static {
            f8444f = new a();
        }

        a() {
            super(0);
        }

        public final MutableLiveData<com.obric.matrix.account.larksso.a> a() {
            return new MutableLiveData();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ MutableLiveData<com.obric.matrix.account.larksso.a> invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/obric/matrix/larksso_api/ILarkSSOService;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends q implements kotlin.n0.c.a<ILarkSSOService> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f8445f = null;

        static {
            f8445f = new b();
        }

        b() {
            super(0);
        }

        public final ILarkSSOService a() {
            return (ILarkSSOService) com.bytedance.news.common.service.manager.d.a(ILarkSSOService.class);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ILarkSSOService invoke() {
            return a();
        }
    }

    static {
        f8441a = new c();
        f8442b = kotlin.i.b(b.f8445f);
        f8443c = kotlin.i.b(a.f8444f);
    }

    private c() {
    }

    public final void a() {
        c().postValue(com.obric.matrix.account.larksso.a.C0220a.f8581c.a());
        d().clearCache();
    }

    public final String b() {
        com.obric.matrix.account.larksso.a r1 = c().getValue();
        if ((r1 instanceof com.obric.matrix.account.larksso.a.C0220a) == false) goto L5;
        com.obric.matrix.account.larksso.a.C0220a r2 = (com.obric.matrix.account.larksso.a.C0220a) r1;
    L7:
        return r2.c();
    L5:
        r2 = com.obric.matrix.account.larksso.a.C0220a.f8581c.a();
        goto L7
    }

    public final MutableLiveData<com.obric.matrix.account.larksso.a> c() {
        return (MutableLiveData) f8443c.getValue();
    }

    public final ILarkSSOService d() {
        Object r1 = f8442b.getValue();
        o.e(r1, "<get-larkSSOService>(...)");
        return (ILarkSSOService) r1;
    }
}
