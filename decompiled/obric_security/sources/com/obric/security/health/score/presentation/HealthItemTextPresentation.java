package com.obric.security.health.score.presentation;

import kotlin.Metadata;

/* JADX INFO: compiled from: HealthTaskPresentationProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/obric/security/health/score/presentation/HealthItemTextPresentation;", "", "titleResId", "", "completedTitleResId", "problemTitleResId", "actionTextResId", "(IIII)V", "getActionTextResId", "()I", "getCompletedTitleResId", "getProblemTitleResId", "getTitleResId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
final class HealthItemTextPresentation {
    private final int actionTextResId;
    private final int completedTitleResId;
    private final int problemTitleResId;
    private final int titleResId;

    public static /* synthetic */ HealthItemTextPresentation copy$default(HealthItemTextPresentation r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.titleResId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.completedTitleResId;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.problemTitleResId;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.actionTextResId;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.titleResId;
    }

    public final int component2() {
        return this.completedTitleResId;
    }

    public final int component3() {
        return this.problemTitleResId;
    }

    public final int component4() {
        return this.actionTextResId;
    }

    public final HealthItemTextPresentation copy(int r1, int r2, int r3, int r4) {
        return new HealthItemTextPresentation(r1, r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HealthItemTextPresentation) == false) goto L14;
        HealthItemTextPresentation r4 = (HealthItemTextPresentation) r3;
        if (this.titleResId == r4.titleResId) goto L8;
        return false;
    L8:
        if (this.completedTitleResId == r4.completedTitleResId) goto L10;
        return false;
    L10:
        if (this.problemTitleResId == r4.problemTitleResId) goto L12;
        return false;
    L12:
        if (this.actionTextResId == r4.actionTextResId) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.titleResId) * 31) + Integer.hashCode(this.completedTitleResId)) * 31) + Integer.hashCode(this.problemTitleResId)) * 31) + Integer.hashCode(this.actionTextResId);
    }

    public String toString() {
        return "HealthItemTextPresentation(titleResId=" + this.titleResId + ", completedTitleResId=" + this.completedTitleResId + ", problemTitleResId=" + this.problemTitleResId + ", actionTextResId=" + this.actionTextResId + ")";
    }

    public HealthItemTextPresentation(int r1, int r2, int r3, int r4) {
        this.titleResId = r1;
        this.completedTitleResId = r2;
        this.problemTitleResId = r3;
        this.actionTextResId = r4;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public final int getCompletedTitleResId() {
        return this.completedTitleResId;
    }

    public final int getProblemTitleResId() {
        return this.problemTitleResId;
    }

    public final int getActionTextResId() {
        return this.actionTextResId;
    }
}
