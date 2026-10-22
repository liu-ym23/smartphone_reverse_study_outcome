package com.obric.dejavu.library;

import android.icu.text.PluralRules;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DbIndexConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u000fHÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003Jm\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010*\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0007HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u0006/"}, d2 = {"Lcom/obric/dejavu/library/DbIndexConfig;", "", "strategy", "Lcom/obric/dejavu/library/IndexUpgradeStrategy;", "metricType", "Lcom/obric/dejavu/library/IndexMetricType;", "searchProbe", "", "downgradeLimit", "upgradeLimit", "ivfNodeMin", "ivfNodeMax", "bspNodeSize", "pqSubDim", "pqTrainInsert", "", "(Lcom/obric/dejavu/library/IndexUpgradeStrategy;Lcom/obric/dejavu/library/IndexMetricType;IIIIIIIZ)V", "getBspNodeSize", "()I", "getDowngradeLimit", "getIvfNodeMax", "getIvfNodeMin", "getMetricType", "()Lcom/obric/dejavu/library/IndexMetricType;", "getPqSubDim", "getPqTrainInsert", "()Z", "getSearchProbe", "getStrategy", "()Lcom/obric/dejavu/library/IndexUpgradeStrategy;", "getUpgradeLimit", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DbIndexConfig {
    private final int bspNodeSize;
    private final int downgradeLimit;
    private final int ivfNodeMax;
    private final int ivfNodeMin;
    private final IndexMetricType metricType;
    private final int pqSubDim;
    private final boolean pqTrainInsert;
    private final int searchProbe;
    private final IndexUpgradeStrategy strategy;
    private final int upgradeLimit;

    public DbIndexConfig() {
        this(null, null, 0, 0, 0, 0, 0, 0, 0, false, 1023, null);
    }

    public static /* synthetic */ DbIndexConfig copy$default(DbIndexConfig r11, IndexUpgradeStrategy r12, IndexMetricType r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        IndexUpgradeStrategy r2 = r11.strategy;
    L7:
        if ((r22 & 2) == 0) goto L9;
        IndexMetricType r3 = r11.metricType;
    L11:
        if ((r22 & 4) == 0) goto L13;
        int r4 = r11.searchProbe;
    L15:
        if ((r22 & 8) == 0) goto L17;
        int r5 = r11.downgradeLimit;
    L19:
        if ((r22 & 16) == 0) goto L21;
        int r6 = r11.upgradeLimit;
    L23:
        if ((r22 & 32) == 0) goto L25;
        int r7 = r11.ivfNodeMin;
    L27:
        if ((r22 & 64) == 0) goto L29;
        int r8 = r11.ivfNodeMax;
    L31:
        if ((r22 & 128) == 0) goto L33;
        int r9 = r11.bspNodeSize;
    L35:
        if ((r22 & 256) == 0) goto L37;
        int r10 = r11.pqSubDim;
    L39:
        if ((r22 & 512) == 0) goto L41;
        boolean r1 = r11.pqTrainInsert;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final IndexUpgradeStrategy component1() {
        return this.strategy;
    }

    public final boolean component10() {
        return this.pqTrainInsert;
    }

    public final IndexMetricType component2() {
        return this.metricType;
    }

    public final int component3() {
        return this.searchProbe;
    }

    public final int component4() {
        return this.downgradeLimit;
    }

    public final int component5() {
        return this.upgradeLimit;
    }

    public final int component6() {
        return this.ivfNodeMin;
    }

    public final int component7() {
        return this.ivfNodeMax;
    }

    public final int component8() {
        return this.bspNodeSize;
    }

    public final int component9() {
        return this.pqSubDim;
    }

    public final DbIndexConfig copy(IndexUpgradeStrategy r13, IndexMetricType r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r13, "strategy");
        Intrinsics.checkNotNullParameter(r14, "metricType");
        return new DbIndexConfig(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DbIndexConfig) == true) goto L8;
        return false;
    L8:
        DbIndexConfig r6 = (DbIndexConfig) r5;
        if (this.strategy == r6.strategy) goto L12;
        return false;
    L12:
        if (this.metricType == r6.metricType) goto L15;
        return false;
    L15:
        if (this.searchProbe == r6.searchProbe) goto L18;
        return false;
    L18:
        if (this.downgradeLimit == r6.downgradeLimit) goto L21;
        return false;
    L21:
        if (this.upgradeLimit == r6.upgradeLimit) goto L24;
        return false;
    L24:
        if (this.ivfNodeMin == r6.ivfNodeMin) goto L27;
        return false;
    L27:
        if (this.ivfNodeMax == r6.ivfNodeMax) goto L30;
        return false;
    L30:
        if (this.bspNodeSize == r6.bspNodeSize) goto L33;
        return false;
    L33:
        if (this.pqSubDim == r6.pqSubDim) goto L36;
        return false;
    L36:
        if (this.pqTrainInsert == r6.pqTrainInsert) goto L38;
        return false;
    L38:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r0 = ((((((((((((((((this.strategy.hashCode() * 31) + this.metricType.hashCode()) * 31) + Integer.hashCode(this.searchProbe)) * 31) + Integer.hashCode(this.downgradeLimit)) * 31) + Integer.hashCode(this.upgradeLimit)) * 31) + Integer.hashCode(this.ivfNodeMin)) * 31) + Integer.hashCode(this.ivfNodeMax)) * 31) + Integer.hashCode(this.bspNodeSize)) * 31) + Integer.hashCode(this.pqSubDim)) * 31;
        boolean r2 = this.pqTrainInsert;
        ?? r3 = r2;
        if (r2 == false) goto L6;
        r3 = 1;
    L6:
        return r0 + r3;
    }

    public String toString() {
        return "DbIndexConfig(strategy=" + this.strategy + ", metricType=" + this.metricType + ", searchProbe=" + this.searchProbe + ", downgradeLimit=" + this.downgradeLimit + ", upgradeLimit=" + this.upgradeLimit + ", ivfNodeMin=" + this.ivfNodeMin + ", ivfNodeMax=" + this.ivfNodeMax + ", bspNodeSize=" + this.bspNodeSize + ", pqSubDim=" + this.pqSubDim + ", pqTrainInsert=" + this.pqTrainInsert + ')';
    }

    public DbIndexConfig(IndexUpgradeStrategy r2, IndexMetricType r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        Intrinsics.checkNotNullParameter(r3, "metricType");
        this.strategy = r2;
        this.metricType = r3;
        this.searchProbe = r4;
        this.downgradeLimit = r5;
        this.upgradeLimit = r6;
        this.ivfNodeMin = r7;
        this.ivfNodeMax = r8;
        this.bspNodeSize = r9;
        this.pqSubDim = r10;
        this.pqTrainInsert = r11;
    }

    public /* synthetic */ DbIndexConfig(IndexUpgradeStrategy r12, IndexMetricType r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 1) == 0) goto L5;
        IndexUpgradeStrategy r1 = IndexUpgradeStrategy.Insert;
    L7:
        if ((r22 & 2) == 0) goto L9;
        IndexMetricType r2 = IndexMetricType.L2;
    L11:
        if ((r22 & 4) == 0) goto L13;
        int r3 = 3;
    L15:
        if ((r22 & 8) == 0) goto L17;
        int r4 = 4096;
    L19:
        if ((r22 & 16) == 0) goto L21;
        int r5 = 8192;
    L23:
        if ((r22 & 32) == 0) goto L25;
        int r6 = 64;
    L27:
        if ((r22 & 64) == 0) goto L29;
        int r7 = 128;
    L31:
        if ((r22 & 128) == 0) goto L33;
        int r8 = 2048;
    L34:
        boolean r10 = false;
        if ((r22 & 256) == 0) goto L37;
        int r9 = 0;
    L39:
        if ((r22 & 512) != 0) goto L42;
        r10 = r21;
    L42:
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        return;
    L37:
        r9 = r20;
        goto L39
    L33:
        r8 = r19;
        goto L34
    L29:
        r7 = r18;
        goto L31
    L25:
        r6 = r17;
        goto L27
    L21:
        r5 = r16;
        goto L23
    L17:
        r4 = r15;
        goto L19
    L13:
        r3 = r14;
        goto L15
    L9:
        r2 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }

    public final IndexUpgradeStrategy getStrategy() {
        return this.strategy;
    }

    public final IndexMetricType getMetricType() {
        return this.metricType;
    }

    public final int getSearchProbe() {
        return this.searchProbe;
    }

    public final int getDowngradeLimit() {
        return this.downgradeLimit;
    }

    public final int getUpgradeLimit() {
        return this.upgradeLimit;
    }

    public final int getIvfNodeMin() {
        return this.ivfNodeMin;
    }

    public final int getIvfNodeMax() {
        return this.ivfNodeMax;
    }

    public final int getBspNodeSize() {
        return this.bspNodeSize;
    }

    public final int getPqSubDim() {
        return this.pqSubDim;
    }

    public final boolean getPqTrainInsert() {
        return this.pqTrainInsert;
    }
}
