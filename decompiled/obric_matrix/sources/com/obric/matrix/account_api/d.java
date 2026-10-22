package com.obric.matrix.account_api;

import kotlin.Metadata;
import kotlin.h;
import kotlin.i;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\"#\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"accountImpl", "Lcom/obric/matrix/account_api/IAccount;", "kotlin.jvm.PlatformType", "getAccountImpl", "()Lcom/obric/matrix/account_api/IAccount;", "accountImpl$delegate", "Lkotlin/Lazy;", "account_api_cnRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final h f8820a = null;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/obric/matrix/account_api/IAccount;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements kotlin.n0.c.a<IAccount> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f8821f = null;

        static {
            f8821f = new a();
        }

        a() {
            super(0);
        }

        public final IAccount a() {
            return (IAccount) com.bytedance.news.common.service.manager.d.a(IAccount.class);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ IAccount invoke() {
            return a();
        }
    }

    static {
        f8820a = i.b(a.f8821f);
    }

    public static final /* synthetic */ IAccount a() {
        return b();
    }

    private static final IAccount b() {
        return (IAccount) f8820a.getValue();
    }
}
