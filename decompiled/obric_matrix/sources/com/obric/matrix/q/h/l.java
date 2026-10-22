package com.obric.matrix.q.h;

import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/obric/matrix/base/system/ThirdXrPkgInfo;", "", "packageName", "", "versionCode", "signSha256", "xrSdkVer", "appId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getPackageName", "getSignSha256", "getVersionCode", "getXrSdkVer", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f9900e;

    public l(String r2, String r3, String r4, String r5, String r6) {
        o.f(r2, "packageName");
        o.f(r3, "versionCode");
        o.f(r4, "signSha256");
        o.f(r5, "xrSdkVer");
        o.f(r6, "appId");
        this.f9896a = r2;
        this.f9897b = r3;
        this.f9898c = r4;
        this.f9899d = r5;
        this.f9900e = r6;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
        if (o.a(this.f9896a, r6.f9896a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f9897b, r6.f9897b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f9898c, r6.f9898c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f9899d, r6.f9899d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f9900e, r6.f9900e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f9896a.hashCode() * 31) + this.f9897b.hashCode()) * 31) + this.f9898c.hashCode()) * 31) + this.f9899d.hashCode()) * 31) + this.f9900e.hashCode();
    }

    public String toString() {
        return "ThirdXrPkgInfo(packageName=" + this.f9896a + ", versionCode=" + this.f9897b + ", signSha256=" + this.f9898c + ", xrSdkVer=" + this.f9899d + ", appId=" + this.f9900e + ')';
    }
}
