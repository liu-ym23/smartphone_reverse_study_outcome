package com.obric.matrix.push.m.i;

import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/matrix/push/base/message/HistoryMsgInfo;", "", "dbId", "", "msgId", "", "timeStamp", "(JLjava/lang/String;J)V", "getDbId", "()J", "getMsgId", "()Ljava/lang/String;", "getTimeStamp", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f9702c;

    public b(long r2, String r4, long r5) {
        o.f(r4, "msgId");
        this.f9700a = r2;
        this.f9701b = r4;
        this.f9702c = r5;
    }

    public final long a() {
        return this.f9702c;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (this.f9700a == r9.f9700a) goto L12;
        return false;
    L12:
        if (o.a(this.f9701b, r9.f9701b) == true) goto L15;
        return false;
    L15:
        if (this.f9702c == r9.f9702c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f9700a) * 31) + this.f9701b.hashCode()) * 31) + Long.hashCode(this.f9702c);
    }

    public String toString() {
        return "HistoryMsgInfo(dbId=" + this.f9700a + ", msgId=" + this.f9701b + ", timeStamp=" + this.f9702c + ')';
    }
}
