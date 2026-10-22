package com.obric.securitycenter.nodisturb.black;

import com.bytedance.apm.constant.SlardarConfigConsts;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlackListSummaryAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryItem;", "", SlardarConfigConsts.CONFIG_ID, "", "note", "", AccountConst.KEY_PHONE_NUMBER, "interceptCount", "(ILjava/lang/String;Ljava/lang/String;I)V", "getId", "()I", "getInterceptCount", "getNote", "()Ljava/lang/String;", "getPhoneNumber", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlackListSummaryItem {
    private final int id;
    private final int interceptCount;
    private final String note;
    private final String phoneNumber;

    public static /* synthetic */ BlackListSummaryItem copy$default(BlackListSummaryItem r0, int r1, String r2, String r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.note;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.phoneNumber;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.interceptCount;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.note;
    }

    public final String component3() {
        return this.phoneNumber;
    }

    public final int component4() {
        return this.interceptCount;
    }

    public final BlackListSummaryItem copy(int r1, String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "note");
        Intrinsics.checkNotNullParameter(r3, AccountConst.KEY_PHONE_NUMBER);
        return new BlackListSummaryItem(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BlackListSummaryItem) == true) goto L8;
        return false;
    L8:
        BlackListSummaryItem r6 = (BlackListSummaryItem) r5;
        if (this.id == r6.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.note, r6.note) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.phoneNumber, r6.phoneNumber) == true) goto L18;
        return false;
    L18:
        if (this.interceptCount == r6.interceptCount) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.id) * 31) + this.note.hashCode()) * 31) + this.phoneNumber.hashCode()) * 31) + Integer.hashCode(this.interceptCount);
    }

    public String toString() {
        return "BlackListSummaryItem(id=" + this.id + ", note=" + this.note + ", phoneNumber=" + this.phoneNumber + ", interceptCount=" + this.interceptCount + ")";
    }

    public BlackListSummaryItem(int r2, String r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "note");
        Intrinsics.checkNotNullParameter(r4, AccountConst.KEY_PHONE_NUMBER);
        this.id = r2;
        this.note = r3;
        this.phoneNumber = r4;
        this.interceptCount = r5;
    }

    public final int getId() {
        return this.id;
    }

    public final String getNote() {
        return this.note;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final int getInterceptCount() {
        return this.interceptCount;
    }
}
