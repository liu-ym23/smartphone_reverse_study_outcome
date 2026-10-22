package com.obric.matrix.account.ui;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/obric/matrix/account/ui/Country;", "", "countryName", "", "countryCode", "phoneCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCountryCode", "()Ljava/lang/String;", "getCountryName", "getPhoneCode", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f8800c;

    public l(String r2, String r3, String r4) {
        kotlin.n0.d.o.f(r2, "countryName");
        kotlin.n0.d.o.f(r3, "countryCode");
        kotlin.n0.d.o.f(r4, "phoneCode");
        this.f8798a = r2;
        this.f8799b = r3;
        this.f8800c = r4;
    }

    public final String a() {
        return this.f8799b;
    }

    public final String b() {
        return this.f8798a;
    }

    public final String c() {
        return this.f8800c;
    }
}
