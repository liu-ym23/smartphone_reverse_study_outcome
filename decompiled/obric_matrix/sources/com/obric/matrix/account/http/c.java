package com.obric.matrix.account.http;

import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B=\u0012\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\bJ\u0015\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004HÆ\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\fJL\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u00042\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/obric/matrix/account/http/AsyncData;", "T", "", "async", "Lcom/obric/matrix/account/http/Async;", "Lcom/obric/matrix/account/http/Resp;", "lastAsync", "data", "(Lcom/obric/matrix/account/http/Async;Lcom/obric/matrix/account/http/Async;Ljava/lang/Object;)V", "getAsync", "()Lcom/obric/matrix/account/http/Async;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getLastAsync", "component1", "component2", "component3", "copy", "(Lcom/obric/matrix/account/http/Async;Lcom/obric/matrix/account/http/Async;Ljava/lang/Object;)Lcom/obric/matrix/account/http/AsyncData;", "equals", "", "other", "hashCode", "", "toString", "", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b<Resp<T>> f8494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b<Resp<T>> f8495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final T f8496c;

    public c() {
        this(null, null, null, 7, null);
    }

    public c(b<Resp<T>> r2, b<Resp<T>> r3, T r4) {
        o.f(r2, "async");
        o.f(r3, "lastAsync");
        this.f8494a = r2;
        this.f8495b = r3;
        this.f8496c = r4;
    }

    public /* synthetic */ c(b r1, b r2, Object r3, int r4, kotlin.n0.d.g r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = m.f8530b;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = m.f8530b;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = null;
    L11:
        this(r1, r2, r3);
    }

    public final b<Resp<T>> a() {
        return this.f8494a;
    }

    public final T b() {
        return this.f8496c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (o.a(this.f8494a, r6.f8494a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f8495b, r6.f8495b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f8496c, r6.f8496c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f8494a.hashCode() * 31) + this.f8495b.hashCode()) * 31;
        T r2 = this.f8496c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "AsyncData(async=" + this.f8494a + ", lastAsync=" + this.f8495b + ", data=" + this.f8496c + ')';
    }
}
