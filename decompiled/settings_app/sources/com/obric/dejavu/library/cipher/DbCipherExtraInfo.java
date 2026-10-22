package com.obric.dejavu.library.cipher;

import android.icu.text.PluralRules;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DbCipherExtraInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/dejavu/library/cipher/DbCipherExtraInfo;", "", "value", "", "nAndNormHex", "(Ljava/lang/String;Ljava/lang/String;)V", "getNAndNormHex", "()Ljava/lang/String;", "getValue", "component1", "component2", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DbCipherExtraInfo {
    private final String nAndNormHex;
    private final String value;

    /* JADX WARN: Multi-variable type inference failed */
    public DbCipherExtraInfo() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DbCipherExtraInfo copy$default(DbCipherExtraInfo r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.value;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.nAndNormHex;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.value;
    }

    public final String component2() {
        return this.nAndNormHex;
    }

    public final DbCipherExtraInfo copy(String r1, String r2) {
        return new DbCipherExtraInfo(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DbCipherExtraInfo) == true) goto L8;
        return false;
    L8:
        DbCipherExtraInfo r6 = (DbCipherExtraInfo) r5;
        if (Intrinsics.areEqual(this.value, r6.value) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nAndNormHex, r6.nAndNormHex) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.value;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.nAndNormHex;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "DbCipherExtraInfo(value=" + this.value + ", nAndNormHex=" + this.nAndNormHex + ')';
    }

    public DbCipherExtraInfo(String r1, String r2) {
        this.value = r1;
        this.nAndNormHex = r2;
    }

    public /* synthetic */ DbCipherExtraInfo(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = "";
    L8:
        this(r2, r3);
    }

    public final String getValue() {
        return this.value;
    }

    public final String getNAndNormHex() {
        return this.nAndNormHex;
    }
}
