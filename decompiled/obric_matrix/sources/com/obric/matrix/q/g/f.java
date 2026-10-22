package com.obric.matrix.q.g;

import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000b\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/obric/matrix/base/network/CallInfo;", "", "appid", "", "callPkgName", "callVersionCode", "", "callPlatformSDKVersion", "callLoaderSdkVersion", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getAppid", "()Ljava/lang/String;", "getCallLoaderSdkVersion", "setCallLoaderSdkVersion", "(Ljava/lang/String;)V", "getCallPkgName", "getCallPlatformSDKVersion", "getCallVersionCode", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f9861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9863e;

    public f(String r2, String r3, long r4, String r6, String r7) {
        o.f(r2, "appid");
        o.f(r3, "callPkgName");
        o.f(r6, "callPlatformSDKVersion");
        o.f(r7, "callLoaderSdkVersion");
        this.f9859a = r2;
        this.f9860b = r3;
        this.f9861c = r4;
        this.f9862d = r6;
        this.f9863e = r7;
    }

    public final String a() {
        return this.f9863e;
    }

    public final String b() {
        return this.f9860b;
    }

    public final String c() {
        return this.f9862d;
    }

    public final long d() {
        return this.f9861c;
    }

    public final void e(String r2) {
        o.f(r2, "<set-?>");
        this.f9863e = r2;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof f) == true) goto L8;
        return false;
    L8:
        f r9 = (f) r8;
        if (o.a(this.f9859a, r9.f9859a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f9860b, r9.f9860b) == true) goto L15;
        return false;
    L15:
        if (this.f9861c == r9.f9861c) goto L18;
        return false;
    L18:
        if (o.a(this.f9862d, r9.f9862d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f9863e, r9.f9863e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f9859a.hashCode() * 31) + this.f9860b.hashCode()) * 31) + Long.hashCode(this.f9861c)) * 31) + this.f9862d.hashCode()) * 31) + this.f9863e.hashCode();
    }

    public String toString() {
        return "CallInfo(appid=" + this.f9859a + ", callPkgName=" + this.f9860b + ", callVersionCode=" + this.f9861c + ", callPlatformSDKVersion=" + this.f9862d + ", callLoaderSdkVersion=" + this.f9863e + ')';
    }
}
