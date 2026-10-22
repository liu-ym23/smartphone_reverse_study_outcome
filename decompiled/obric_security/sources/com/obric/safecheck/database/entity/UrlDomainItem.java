package com.obric.safecheck.database.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UrlDomainItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0003H\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/obric/safecheck/database/entity/UrlDomainItem;", "Lcom/obric/safecheck/database/entity/Item;", "domain", "", "domainOrigin", "timestamp", "isBlacklist", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDomain", "()Ljava/lang/String;", "setDomain", "(Ljava/lang/String;)V", "getDomainOrigin", "setDomainOrigin", "()Z", "setBlacklist", "(Z)V", "getTimestamp", "setTimestamp", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class UrlDomainItem implements Item {
    private String domain;
    private String domainOrigin;
    private boolean isBlacklist;
    private String timestamp;

    public UrlDomainItem() {
        this(null, null, null, false, 15, null);
    }

    public static /* synthetic */ UrlDomainItem copy$default(UrlDomainItem r0, String r1, String r2, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.domain;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.domainOrigin;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.timestamp;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.isBlacklist;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.domain;
    }

    public final String component2() {
        return this.domainOrigin;
    }

    public final String component3() {
        return this.timestamp;
    }

    public final boolean component4() {
        return this.isBlacklist;
    }

    public final UrlDomainItem copy(String r1, String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "domain");
        Intrinsics.checkNotNullParameter(r2, "domainOrigin");
        Intrinsics.checkNotNullParameter(r3, "timestamp");
        return new UrlDomainItem(r1, r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof UrlDomainItem) == false) goto L14;
        UrlDomainItem r4 = (UrlDomainItem) r3;
        if (Intrinsics.areEqual(this.domain, r4.domain) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.domainOrigin, r4.domainOrigin) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.timestamp, r4.timestamp) == true) goto L12;
        return false;
    L12:
        if (this.isBlacklist == r4.isBlacklist) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        String r0 = this.domain;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.domainOrigin;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.timestamp;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        int r8 = (r6 + r1) * 31;
        boolean r9 = this.isBlacklist;
        ?? r10 = r9;
        if (r9 == false) goto L17;
        r10 = 1;
    L17:
        return r8 + r10;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public UrlDomainItem(String r2, String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "domain");
        Intrinsics.checkNotNullParameter(r3, "domainOrigin");
        Intrinsics.checkNotNullParameter(r4, "timestamp");
        this.domain = r2;
        this.domainOrigin = r3;
        this.timestamp = r4;
        this.isBlacklist = r5;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final void setDomain(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.domain = r2;
    }

    public final String getDomainOrigin() {
        return this.domainOrigin;
    }

    public final void setDomainOrigin(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.domainOrigin = r2;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.timestamp = r2;
    }

    public /* synthetic */ UrlDomainItem(String r2, String r3, String r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = false;
    L14:
        this(r2, r3, r4, r5);
    }

    public final boolean isBlacklist() {
        return this.isBlacklist;
    }

    public final void setBlacklist(boolean r1) {
        this.isBlacklist = r1;
    }

    public String toString() {
        return "UrlDomainItem(domain='" + this.domain + "', domainOrigin='" + this.domainOrigin + "', timestamp='" + this.timestamp + "', isBlacklist=" + this.isBlacklist + ")";
    }
}
