package com.obric.securitycenter.nodisturb.white;

import com.bytedance.apm.constant.SlardarConfigConsts;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WhiteListSummaryAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/securitycenter/nodisturb/white/WhiteListSummaryItem;", "", SlardarConfigConsts.CONFIG_ID, "", AccountConst.KEY_PHONE_NUMBER, "", "note", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getNote", "()Ljava/lang/String;", "getPhoneNumber", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WhiteListSummaryItem {
    private final int id;
    private final String note;
    private final String phoneNumber;

    public static /* synthetic */ WhiteListSummaryItem copy$default(WhiteListSummaryItem r0, int r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.phoneNumber;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.note;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.phoneNumber;
    }

    public final String component3() {
        return this.note;
    }

    public final WhiteListSummaryItem copy(int r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, AccountConst.KEY_PHONE_NUMBER);
        Intrinsics.checkNotNullParameter(r3, "note");
        return new WhiteListSummaryItem(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WhiteListSummaryItem) == true) goto L8;
        return false;
    L8:
        WhiteListSummaryItem r6 = (WhiteListSummaryItem) r5;
        if (this.id == r6.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.phoneNumber, r6.phoneNumber) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.note, r6.note) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + this.phoneNumber.hashCode()) * 31) + this.note.hashCode();
    }

    public String toString() {
        return "WhiteListSummaryItem(id=" + this.id + ", phoneNumber=" + this.phoneNumber + ", note=" + this.note + ")";
    }

    public WhiteListSummaryItem(int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, AccountConst.KEY_PHONE_NUMBER);
        Intrinsics.checkNotNullParameter(r4, "note");
        this.id = r2;
        this.phoneNumber = r3;
        this.note = r4;
    }

    public final int getId() {
        return this.id;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getNote() {
        return this.note;
    }
}
