package com.obric.safecheck.database.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PhoneItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/obric/safecheck/database/entity/PhoneItem;", "Lcom/obric/safecheck/database/entity/Item;", "phone", "", "timestamp", "isBlacklist", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "setBlacklist", "(Z)V", "getPhone", "()Ljava/lang/String;", "setPhone", "(Ljava/lang/String;)V", "getTimestamp", "setTimestamp", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PhoneItem implements Item {
    private boolean isBlacklist;
    private String phone;
    private String timestamp;

    public PhoneItem() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ PhoneItem copy$default(PhoneItem r0, String r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.phone;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.timestamp;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.isBlacklist;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.phone;
    }

    public final String component2() {
        return this.timestamp;
    }

    public final boolean component3() {
        return this.isBlacklist;
    }

    public final PhoneItem copy(String r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "phone");
        Intrinsics.checkNotNullParameter(r2, "timestamp");
        return new PhoneItem(r1, r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof PhoneItem) == false) goto L12;
        PhoneItem r4 = (PhoneItem) r3;
        if (Intrinsics.areEqual(this.phone, r4.phone) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.timestamp, r4.timestamp) == true) goto L10;
        return false;
    L10:
        if (this.isBlacklist == r4.isBlacklist) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        String r0 = this.phone;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.timestamp;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        boolean r6 = this.isBlacklist;
        ?? r7 = r6;
        if (r6 == false) goto L13;
        r7 = 1;
    L13:
        return r5 + r7;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "PhoneItem(phone=" + this.phone + ", timestamp=" + this.timestamp + ", isBlacklist=" + this.isBlacklist + ")";
    }

    public PhoneItem(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "phone");
        Intrinsics.checkNotNullParameter(r3, "timestamp");
        this.phone = r2;
        this.timestamp = r3;
        this.isBlacklist = r4;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final void setPhone(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.phone = r2;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.timestamp = r2;
    }

    public /* synthetic */ PhoneItem(String r2, String r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = false;
    L11:
        this(r2, r3, r4);
    }

    public final boolean isBlacklist() {
        return this.isBlacklist;
    }

    public final void setBlacklist(boolean r1) {
        this.isBlacklist = r1;
    }
}
