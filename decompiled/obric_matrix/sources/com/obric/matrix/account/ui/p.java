package com.obric.matrix.account.ui;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/matrix/account/ui/SendCodeRecord;", "Ljava/io/Serializable;", "sendTime", "", "phoneCodeNumber", "", "phoneNumber", "(JLjava/lang/String;Ljava/lang/String;)V", "getPhoneCodeNumber", "()Ljava/lang/String;", "getPhoneNumber", "getSendTime", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class p implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f8805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f8806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f8807h;

    public p() {
        this(0, null, null, 7, null);
    }

    public p(long r2, String r4, String r5) {
        kotlin.n0.d.o.f(r4, "phoneCodeNumber");
        kotlin.n0.d.o.f(r5, "phoneNumber");
        this.f8805f = r2;
        this.f8806g = r4;
        this.f8807h = r5;
    }

    public /* synthetic */ p(long r2, String r4, String r5, int r6, kotlin.n0.d.g r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = "";
    L9:
        if ((r6 & 4) == 0) goto L11;
        r5 = "";
    L11:
        this(r2, r4, r5);
    }

    public final String a() {
        return this.f8806g;
    }

    public final String b() {
        return this.f8807h;
    }

    public final long c() {
        return this.f8805f;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof p) == true) goto L8;
        return false;
    L8:
        p r9 = (p) r8;
        if (this.f8805f == r9.f8805f) goto L12;
        return false;
    L12:
        if (kotlin.n0.d.o.a(this.f8806g, r9.f8806g) == true) goto L15;
        return false;
    L15:
        if (kotlin.n0.d.o.a(this.f8807h, r9.f8807h) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f8805f) * 31) + this.f8806g.hashCode()) * 31) + this.f8807h.hashCode();
    }

    public String toString() {
        return "SendCodeRecord(sendTime=" + this.f8805f + ", phoneCodeNumber=" + this.f8806g + ", phoneNumber=" + this.f8807h + ')';
    }
}
