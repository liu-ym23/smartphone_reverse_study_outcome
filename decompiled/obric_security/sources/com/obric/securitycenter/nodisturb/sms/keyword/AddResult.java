package com.obric.securitycenter.nodisturb.sms.keyword;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SMSKeywordFilterViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/obric/securitycenter/nodisturb/sms/keyword/AddResult;", "", "outOfLength", "", "", "duplicates", "exceedMaxCount", "", "(Ljava/util/List;Ljava/util/List;Z)V", "getDuplicates", "()Ljava/util/List;", "getExceedMaxCount", "()Z", "getOutOfLength", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AddResult {
    private final List<String> duplicates;
    private final boolean exceedMaxCount;
    private final List<String> outOfLength;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AddResult copy$default(AddResult r0, List r1, List r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.outOfLength;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.duplicates;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.exceedMaxCount;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final List<String> component1() {
        return this.outOfLength;
    }

    public final List<String> component2() {
        return this.duplicates;
    }

    public final boolean component3() {
        return this.exceedMaxCount;
    }

    public final AddResult copy(List<String> r1, List<String> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "outOfLength");
        Intrinsics.checkNotNullParameter(r2, "duplicates");
        return new AddResult(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AddResult) == true) goto L8;
        return false;
    L8:
        AddResult r6 = (AddResult) r5;
        if (Intrinsics.areEqual(this.outOfLength, r6.outOfLength) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.duplicates, r6.duplicates) == true) goto L15;
        return false;
    L15:
        if (this.exceedMaxCount == r6.exceedMaxCount) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r0 = ((this.outOfLength.hashCode() * 31) + this.duplicates.hashCode()) * 31;
        boolean r2 = this.exceedMaxCount;
        ?? r3 = r2;
        if (r2 == false) goto L6;
        r3 = 1;
    L6:
        return r0 + r3;
    }

    public String toString() {
        return "AddResult(outOfLength=" + this.outOfLength + ", duplicates=" + this.duplicates + ", exceedMaxCount=" + this.exceedMaxCount + ")";
    }

    public AddResult(List<String> r2, List<String> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "outOfLength");
        Intrinsics.checkNotNullParameter(r3, "duplicates");
        this.outOfLength = r2;
        this.duplicates = r3;
        this.exceedMaxCount = r4;
    }

    public final List<String> getOutOfLength() {
        return this.outOfLength;
    }

    public final List<String> getDuplicates() {
        return this.duplicates;
    }

    public final boolean getExceedMaxCount() {
        return this.exceedMaxCount;
    }
}
