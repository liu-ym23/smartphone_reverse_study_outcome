package com.obric.matrix.opush.d.g;

import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/matrix/opush/base/message/HistoryMsgInfo;", "", "dbId", "", "msgId", "", "timeStamp", "(JLjava/lang/String;J)V", "getDbId", "()J", "getMsgId", "()Ljava/lang/String;", "getTimeStamp", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f9310c;

    public c(long r2, String r4, long r5) {
        o.f(r4, "msgId");
        this.f9308a = r2;
        this.f9309b = r4;
        this.f9310c = r5;
    }

    public final long a() {
        return this.f9310c;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
        if (this.f9308a == r9.f9308a) goto L12;
        return false;
    L12:
        if (o.a(this.f9309b, r9.f9309b) == true) goto L15;
        return false;
    L15:
        if (this.f9310c == r9.f9310c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f9308a) * 31) + this.f9309b.hashCode()) * 31) + Long.hashCode(this.f9310c);
    }

    public String toString() {
        return "HistoryMsgInfo(dbId=" + this.f9308a + ", msgId=" + this.f9309b + ", timeStamp=" + this.f9310c + ')';
    }
}
