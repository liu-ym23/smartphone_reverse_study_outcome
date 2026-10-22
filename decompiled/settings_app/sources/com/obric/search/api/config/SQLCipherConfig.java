package com.obric.search.api.config;

import android.icu.text.PluralRules;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteGlobal;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SQLCipherConfig.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\r\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\u0010¨\u0006#"}, d2 = {"Lcom/obric/search/api/config/SQLCipherConfig;", "", "kdfIteration", "", "hmacEnabled", "", "hmacAlgorithm", "kdfAlgorithm", "pageSize", "(IZIII)V", "getHmacAlgorithm", "()I", "getHmacEnabled", "()Z", "getKdfAlgorithm", "setKdfAlgorithm", "(I)V", "getKdfIteration", "getPageSize", "setPageSize", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PluralRules.KEYWORD_OTHER, "hashCode", "toSQLiteCipherSpec", "Lcom/tencent/wcdb/database/SQLiteCipherSpec;", "toSQLiteCipherSpec$sdk_release", "toString", "", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SQLCipherConfig {
    public static final Companion Companion = null;
    public static final int HMAC_DEFAULT = -1;
    public static final int HMAC_SHA1 = 0;
    public static final int HMAC_SHA256 = 1;
    public static final int HMAC_SHA512 = 2;
    private final int hmacAlgorithm;
    private final boolean hmacEnabled;
    private int kdfAlgorithm;
    private final int kdfIteration;
    private int pageSize;

    /* JADX INFO: compiled from: SQLCipherConfig.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/search/api/config/SQLCipherConfig$Companion;", "", "()V", "HMAC_DEFAULT", "", "HMAC_SHA1", "HMAC_SHA256", "HMAC_SHA512", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SQLCipherConfig() {
        this(0, false, 0, 0, 0, 31, null);
    }

    public static /* synthetic */ SQLCipherConfig copy$default(SQLCipherConfig r3, int r4, boolean r5, int r6, int r7, int r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.kdfIteration;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.hmacEnabled;
    L8:
        boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.hmacAlgorithm;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.kdfAlgorithm;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.pageSize;
    L17:
        int r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final int component1() {
        return this.kdfIteration;
    }

    public final boolean component2() {
        return this.hmacEnabled;
    }

    public final int component3() {
        return this.hmacAlgorithm;
    }

    public final int component4() {
        return this.kdfAlgorithm;
    }

    public final int component5() {
        return this.pageSize;
    }

    public final SQLCipherConfig copy(int r7, boolean r8, int r9, int r10, int r11) {
        return new SQLCipherConfig(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SQLCipherConfig) == true) goto L8;
        return false;
    L8:
        SQLCipherConfig r6 = (SQLCipherConfig) r5;
        if (this.kdfIteration == r6.kdfIteration) goto L12;
        return false;
    L12:
        if (this.hmacEnabled == r6.hmacEnabled) goto L15;
        return false;
    L15:
        if (this.hmacAlgorithm == r6.hmacAlgorithm) goto L18;
        return false;
    L18:
        if (this.kdfAlgorithm == r6.kdfAlgorithm) goto L21;
        return false;
    L21:
        if (this.pageSize == r6.pageSize) goto L23;
        return false;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int r0 = Integer.hashCode(this.kdfIteration) * 31;
        boolean r1 = this.hmacEnabled;
        ?? r2 = r1;
        if (r1 == false) goto L6;
        r2 = 1;
    L6:
        return ((((((r0 + r2) * 31) + Integer.hashCode(this.hmacAlgorithm)) * 31) + Integer.hashCode(this.kdfAlgorithm)) * 31) + Integer.hashCode(this.pageSize);
    }

    public String toString() {
        return "SQLCipherConfig(kdfIteration=" + this.kdfIteration + ", hmacEnabled=" + this.hmacEnabled + ", hmacAlgorithm=" + this.hmacAlgorithm + ", kdfAlgorithm=" + this.kdfAlgorithm + ", pageSize=" + this.pageSize + ')';
    }

    public SQLCipherConfig(int r1, boolean r2, int r3, int r4, int r5) {
        this.kdfIteration = r1;
        this.hmacEnabled = r2;
        this.hmacAlgorithm = r3;
        this.kdfAlgorithm = r4;
        this.pageSize = r5;
    }

    public final int getKdfIteration() {
        return this.kdfIteration;
    }

    public final boolean getHmacEnabled() {
        return this.hmacEnabled;
    }

    public final int getHmacAlgorithm() {
        return this.hmacAlgorithm;
    }

    public final int getKdfAlgorithm() {
        return this.kdfAlgorithm;
    }

    public final void setKdfAlgorithm(int r1) {
        this.kdfAlgorithm = r1;
    }

    public /* synthetic */ SQLCipherConfig(int r4, boolean r5, int r6, int r7, int r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = true;
    L8:
        boolean r11 = r5;
        int r0 = -1;
        if ((r9 & 4) == 0) goto L11;
        int r1 = -1;
    L13:
        if ((r9 & 8) != 0) goto L17;
        r0 = r7;
    L17:
        if ((r9 & 16) == 0) goto L19;
        r8 = SQLiteGlobal.defaultPageSize;
    L19:
        this(r4, r11, r1, r0, r8);
        return;
    L11:
        r1 = r6;
        goto L13
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final void setPageSize(int r1) {
        this.pageSize = r1;
    }

    public final SQLiteCipherSpec toSQLiteCipherSpec$sdk_release() {
        SQLiteCipherSpec r2 = new SQLiteCipherSpec().setKDFIteration(this.kdfIteration).withHMACEnabled(this.hmacEnabled).setHmacAlgorithm(this.hmacAlgorithm).setKdfAlgorithm(this.kdfAlgorithm).setPageSize(this.pageSize);
        Intrinsics.checkNotNullExpressionValue(r2, "SQLiteCipherSpec()\n     …   .setPageSize(pageSize)");
        return r2;
    }
}
