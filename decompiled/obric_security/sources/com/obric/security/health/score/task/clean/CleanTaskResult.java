package com.obric.security.health.score.task.clean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CleanTaskResult.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/obric/security/health/score/task/clean/CleanTaskResult;", "", "score", "", "totalSize", "", "deductScore", "scoreRange", "", "optimizedSize", "(IJILjava/lang/String;J)V", "getDeductScore", "()I", "getOptimizedSize", "()J", "getScore", "getScoreRange", "()Ljava/lang/String;", "getTotalSize", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class CleanTaskResult {
    private final int deductScore;
    private final long optimizedSize;
    private final int score;
    private final String scoreRange;
    private final long totalSize;

    public static /* synthetic */ CleanTaskResult copy$default(CleanTaskResult r5, int r6, long r7, int r9, String r10, long r11, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.score;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.totalSize;
    L8:
        long r0 = r7;
        if ((r13 & 4) == 0) goto L11;
        r9 = r5.deductScore;
    L11:
        int r15 = r9;
        if ((r13 & 8) == 0) goto L14;
        r10 = r5.scoreRange;
    L14:
        String r2 = r10;
        if ((r13 & 16) == 0) goto L17;
        r11 = r5.optimizedSize;
    L17:
        int r8 = r6;
        return r5.copy(r8, r0, r15, r2, r11);
    }

    public final int component1() {
        return this.score;
    }

    public final long component2() {
        return this.totalSize;
    }

    public final int component3() {
        return this.deductScore;
    }

    public final String component4() {
        return this.scoreRange;
    }

    public final long component5() {
        return this.optimizedSize;
    }

    public final CleanTaskResult copy(int r9, long r10, int r12, String r13, long r14) {
        Intrinsics.checkNotNullParameter(r13, "scoreRange");
        return new CleanTaskResult(r9, r10, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof CleanTaskResult) == false) goto L16;
        CleanTaskResult r6 = (CleanTaskResult) r5;
        if (this.score == r6.score) goto L8;
        return false;
    L8:
        if (this.totalSize == r6.totalSize) goto L10;
        return false;
    L10:
        if (this.deductScore == r6.deductScore) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scoreRange, r6.scoreRange) == true) goto L14;
        return false;
    L14:
        if (this.optimizedSize == r6.optimizedSize) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = ((((Integer.hashCode(this.score) * 31) + Long.hashCode(this.totalSize)) * 31) + Integer.hashCode(this.deductScore)) * 31;
        String r1 = this.scoreRange;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return ((r0 + r2) * 31) + Long.hashCode(this.optimizedSize);
    L5:
        r2 = 0;
        goto L7
    }

    public String toString() {
        return "CleanTaskResult(score=" + this.score + ", totalSize=" + this.totalSize + ", deductScore=" + this.deductScore + ", scoreRange=" + this.scoreRange + ", optimizedSize=" + this.optimizedSize + ")";
    }

    public CleanTaskResult(int r2, long r3, int r5, String r6, long r7) {
        Intrinsics.checkNotNullParameter(r6, "scoreRange");
        this.score = r2;
        this.totalSize = r3;
        this.deductScore = r5;
        this.scoreRange = r6;
        this.optimizedSize = r7;
    }

    public final int getScore() {
        return this.score;
    }

    public final long getTotalSize() {
        return this.totalSize;
    }

    public final int getDeductScore() {
        return this.deductScore;
    }

    public final String getScoreRange() {
        return this.scoreRange;
    }

    public /* synthetic */ CleanTaskResult(int r10, long r11, int r13, String r14, long r15, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 4) == 0) goto L5;
        int r5 = 0;
    L7:
        if ((r17 & 8) == 0) goto L9;
        String r6 = "";
    L11:
        if ((r17 & 16) == 0) goto L13;
        long r7 = r11;
    L14:
        this(r10, r11, r5, r6, r7);
        return;
    L13:
        r7 = r15;
        goto L14
    L9:
        r6 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public final long getOptimizedSize() {
        return this.optimizedSize;
    }
}
