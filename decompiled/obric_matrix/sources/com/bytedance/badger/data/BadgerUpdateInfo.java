package com.bytedance.badger.data;

import kotlin.Metadata;
import kotlin.n0.d.g;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/bytedance/badger/data/BadgerUpdateInfo;", "", "", "component1", "()J", "component2", "startTime", "endTime", "copy", "(JJ)Lcom/bytedance/badger/data/BadgerUpdateInfo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "J", "getEndTime", "a", "getStartTime", "<init>", "(JJ)V", "badger-api_release"}, k = 1, mv = {1, 1, 15})
public final class BadgerUpdateInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f2530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f2531b;

    public BadgerUpdateInfo() {
        this(0, 0, 3, null);
    }

    public BadgerUpdateInfo(long r1, long r3) {
        this.f2530a = r1;
        this.f2531b = r3;
    }

    public /* synthetic */ BadgerUpdateInfo(long r3, long r5, int r7, g r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r7 & 2) == 0) goto L8;
        r5 = 0;
    L8:
        this(r3, r5);
    }

    public static /* synthetic */ BadgerUpdateInfo copy$default(BadgerUpdateInfo r0, long r1, long r3, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.f2530a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0.f2531b;
    L9:
        return r0.copy(r1, r3);
    }

    public final long component1() {
        return this.f2530a;
    }

    public final long component2() {
        return this.f2531b;
    }

    public final BadgerUpdateInfo copy(long r1, long r3) {
        return new BadgerUpdateInfo(r1, r3);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L5;
    L18:
        return true;
    L5:
        if ((r8 instanceof BadgerUpdateInfo) == false) goto L17;
        BadgerUpdateInfo r9 = (BadgerUpdateInfo) r8;
        if (this.f2530a != r9.f2530a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L17;
        if (this.f2531b != r9.f2531b) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L17;
    L14:
        r7 = false;
        goto L15
    L9:
        r1 = false;
    L17:
        return false;
    }

    public final long getEndTime() {
        return this.f2531b;
    }

    public final long getStartTime() {
        return this.f2530a;
    }

    public int hashCode() {
        return (Long.hashCode(this.f2530a) * 31) + Long.hashCode(this.f2531b);
    }

    public String toString() {
        return "BadgerUpdateInfo(startTime=" + this.f2530a + ", endTime=" + this.f2531b + ")";
    }
}
