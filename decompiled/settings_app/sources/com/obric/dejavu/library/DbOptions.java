package com.obric.dejavu.library;

import android.icu.text.PluralRules;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DbOptions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003JO\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/obric/dejavu/library/DbOptions;", "", "dbname", "", "dims", "", "createIfMissing", "", "errorIfExists", "compressLevel", "kvEngine", "Lcom/obric/dejavu/library/KvEngineType;", "indexCfg", "Lcom/obric/dejavu/library/DbIndexConfig;", "(Ljava/lang/String;IZZILcom/obric/dejavu/library/KvEngineType;Lcom/obric/dejavu/library/DbIndexConfig;)V", "getCompressLevel", "()I", "getCreateIfMissing", "()Z", "getDbname", "()Ljava/lang/String;", "getDims", "getErrorIfExists", "getIndexCfg", "()Lcom/obric/dejavu/library/DbIndexConfig;", "getKvEngine", "()Lcom/obric/dejavu/library/KvEngineType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DbOptions {
    private final int compressLevel;
    private final boolean createIfMissing;
    private final String dbname;
    private final int dims;
    private final boolean errorIfExists;
    private final DbIndexConfig indexCfg;
    private final KvEngineType kvEngine;

    public static /* synthetic */ DbOptions copy$default(DbOptions r5, String r6, int r7, boolean r8, boolean r9, int r10, KvEngineType r11, DbIndexConfig r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.dbname;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.dims;
    L8:
        int r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.createIfMissing;
    L11:
        boolean r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.errorIfExists;
    L14:
        boolean r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.compressLevel;
    L17:
        int r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.kvEngine;
    L20:
        KvEngineType r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.indexCfg;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.dbname;
    }

    public final int component2() {
        return this.dims;
    }

    public final boolean component3() {
        return this.createIfMissing;
    }

    public final boolean component4() {
        return this.errorIfExists;
    }

    public final int component5() {
        return this.compressLevel;
    }

    public final KvEngineType component6() {
        return this.kvEngine;
    }

    public final DbIndexConfig component7() {
        return this.indexCfg;
    }

    public final DbOptions copy(String r9, int r10, boolean r11, boolean r12, int r13, KvEngineType r14, DbIndexConfig r15) {
        Intrinsics.checkNotNullParameter(r9, "dbname");
        Intrinsics.checkNotNullParameter(r14, "kvEngine");
        Intrinsics.checkNotNullParameter(r15, "indexCfg");
        return new DbOptions(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DbOptions) == true) goto L8;
        return false;
    L8:
        DbOptions r6 = (DbOptions) r5;
        if (Intrinsics.areEqual(this.dbname, r6.dbname) == true) goto L12;
        return false;
    L12:
        if (this.dims == r6.dims) goto L15;
        return false;
    L15:
        if (this.createIfMissing == r6.createIfMissing) goto L18;
        return false;
    L18:
        if (this.errorIfExists == r6.errorIfExists) goto L21;
        return false;
    L21:
        if (this.compressLevel == r6.compressLevel) goto L24;
        return false;
    L24:
        if (this.kvEngine == r6.kvEngine) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.indexCfg, r6.indexCfg) == true) goto L29;
        return false;
    L29:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r0 = ((this.dbname.hashCode() * 31) + Integer.hashCode(this.dims)) * 31;
        boolean r1 = this.createIfMissing;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.errorIfExists;
        if (r5 == true) goto L10;
        r2 = r5;
    L10:
        return ((((((r4 + r2) * 31) + Integer.hashCode(this.compressLevel)) * 31) + this.kvEngine.hashCode()) * 31) + this.indexCfg.hashCode();
    }

    public String toString() {
        return "DbOptions(dbname=" + this.dbname + ", dims=" + this.dims + ", createIfMissing=" + this.createIfMissing + ", errorIfExists=" + this.errorIfExists + ", compressLevel=" + this.compressLevel + ", kvEngine=" + this.kvEngine + ", indexCfg=" + this.indexCfg + ')';
    }

    public DbOptions(String r2, int r3, boolean r4, boolean r5, int r6, KvEngineType r7, DbIndexConfig r8) {
        Intrinsics.checkNotNullParameter(r2, "dbname");
        Intrinsics.checkNotNullParameter(r7, "kvEngine");
        Intrinsics.checkNotNullParameter(r8, "indexCfg");
        this.dbname = r2;
        this.dims = r3;
        this.createIfMissing = r4;
        this.errorIfExists = r5;
        this.compressLevel = r6;
        this.kvEngine = r7;
        this.indexCfg = r8;
    }

    public final String getDbname() {
        return this.dbname;
    }

    public final int getDims() {
        return this.dims;
    }

    public final boolean getCreateIfMissing() {
        return this.createIfMissing;
    }

    public final boolean getErrorIfExists() {
        return this.errorIfExists;
    }

    public final int getCompressLevel() {
        return this.compressLevel;
    }

    public /* synthetic */ DbOptions(String r23, int r24, boolean r25, boolean r26, int r27, KvEngineType r28, DbIndexConfig r29, int r30, DefaultConstructorMarker r31) {
        if ((r30 & 4) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r30 & 8) == 0) goto L9;
        boolean r6 = false;
    L11:
        if ((r30 & 16) == 0) goto L13;
        int r7 = 0;
    L15:
        if ((r30 & 32) == 0) goto L17;
        KvEngineType r8 = KvEngineType.LevelDb;
    L19:
        if ((r30 & 64) == 0) goto L21;
        DbIndexConfig r9 = new DbIndexConfig(null, null, 0, 0, 0, 0, 0, 0, 0, false, 1023, null);
    L22:
        this(r23, r24, r5, r6, r7, r8, r9);
        return;
    L21:
        r9 = r29;
        goto L22
    L17:
        r8 = r28;
        goto L19
    L13:
        r7 = r27;
        goto L15
    L9:
        r6 = r26;
        goto L11
    L5:
        r5 = r25;
        goto L7
    }

    public final KvEngineType getKvEngine() {
        return this.kvEngine;
    }

    public final DbIndexConfig getIndexCfg() {
        return this.indexCfg;
    }
}
