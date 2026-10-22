package com.obric.matrix.account;

import kotlin.Metadata;
import kotlin.a0;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/matrix/account/AccountGlobalsShadow;", "", "()V", "innerTokenHeader", "Lkotlin/Pair;", "", "getInnerTokenHeader", "()Lkotlin/Pair;", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8440a = null;

    static {
        f8440a = new b();
    }

    private b() {
    }

    public final u<String, String> a() {
        String r1 = a.f8438a.g();
        if (r1.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return null;
    L10:
        return a0.a("X-Common-Inner-Sso-Token", r1);
    L5:
        r0 = false;
        goto L6
    }
}
