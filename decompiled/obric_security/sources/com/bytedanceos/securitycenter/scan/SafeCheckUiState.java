package com.bytedanceos.securitycenter.scan;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.common.module.qscanner.QScanResultEntity;

/* JADX INFO: compiled from: SafeCheckUiState.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001'Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u0010J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003Jk\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015¨\u0006("}, d2 = {"Lcom/bytedanceos/securitycenter/scan/SafeCheckUiState;", "", "isScanFinished", "", "isScanUiFinished", "pendingScanResults", "", "Ltmsdk/common/module/qscanner/QScanResultEntity;", "riskApps", "Lcom/bytedanceos/securitycenter/scan/SafeCheckRiskAppItem;", "resultState", "Lcom/bytedanceos/securitycenter/scan/SafeCheckUiState$ResultState;", "selectedRiskKeys", "", "", "pendingUninstallKeys", "(ZZLjava/util/List;Ljava/util/List;Lcom/bytedanceos/securitycenter/scan/SafeCheckUiState$ResultState;Ljava/util/Set;Ljava/util/Set;)V", "()Z", "getPendingScanResults", "()Ljava/util/List;", "getPendingUninstallKeys", "()Ljava/util/Set;", "getResultState", "()Lcom/bytedanceos/securitycenter/scan/SafeCheckUiState$ResultState;", "getRiskApps", "getSelectedRiskKeys", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "ResultState", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SafeCheckUiState {
    private final boolean isScanFinished;
    private final boolean isScanUiFinished;
    private final List<QScanResultEntity> pendingScanResults;
    private final Set<String> pendingUninstallKeys;
    private final ResultState resultState;
    private final List<SafeCheckRiskAppItem> riskApps;
    private final Set<String> selectedRiskKeys;

    /* JADX INFO: compiled from: SafeCheckUiState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/SafeCheckUiState$ResultState;", "", "color", "", "text", "", "(ILjava/lang/String;)V", "getColor", "()I", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ResultState {
        private final int color;
        private final String text;

        public static /* synthetic */ ResultState copy$default(ResultState r0, int r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.color;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.text;
        L9:
            return r0.copy(r1, r2);
        }

        public final int component1() {
            return this.color;
        }

        public final String component2() {
            return this.text;
        }

        public final ResultState copy(int r1, String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            return new ResultState(r1, r2);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof ResultState) == false) goto L10;
            ResultState r4 = (ResultState) r3;
            if (this.color == r4.color) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.text, r4.text) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            int r0 = Integer.hashCode(this.color) * 31;
            String r1 = this.text;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        public String toString() {
            return "ResultState(color=" + this.color + ", text=" + this.text + ")";
        }

        public ResultState(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "text");
            this.color = r2;
            this.text = r3;
        }

        public final int getColor() {
            return this.color;
        }

        public final String getText() {
            return this.text;
        }
    }

    public SafeCheckUiState() {
        this(false, false, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SafeCheckUiState copy$default(SafeCheckUiState r5, boolean r6, boolean r7, List r8, List r9, ResultState r10, Set r11, Set r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.isScanFinished;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.isScanUiFinished;
    L8:
        boolean r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.pendingScanResults;
    L11:
        List r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.riskApps;
    L14:
        List r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.resultState;
    L17:
        ResultState r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.selectedRiskKeys;
    L20:
        Set r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.pendingUninstallKeys;
    L23:
        boolean r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final boolean component1() {
        return this.isScanFinished;
    }

    public final boolean component2() {
        return this.isScanUiFinished;
    }

    public final List<QScanResultEntity> component3() {
        return this.pendingScanResults;
    }

    public final List<SafeCheckRiskAppItem> component4() {
        return this.riskApps;
    }

    public final ResultState component5() {
        return this.resultState;
    }

    public final Set<String> component6() {
        return this.selectedRiskKeys;
    }

    public final Set<String> component7() {
        return this.pendingUninstallKeys;
    }

    public final SafeCheckUiState copy(boolean r9, boolean r10, List<? extends QScanResultEntity> r11, List<SafeCheckRiskAppItem> r12, ResultState r13, Set<String> r14, Set<String> r15) {
        Intrinsics.checkNotNullParameter(r12, "riskApps");
        Intrinsics.checkNotNullParameter(r14, "selectedRiskKeys");
        Intrinsics.checkNotNullParameter(r15, "pendingUninstallKeys");
        return new SafeCheckUiState(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SafeCheckUiState) == false) goto L20;
        SafeCheckUiState r4 = (SafeCheckUiState) r3;
        if (this.isScanFinished == r4.isScanFinished) goto L8;
        return false;
    L8:
        if (this.isScanUiFinished == r4.isScanUiFinished) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.pendingScanResults, r4.pendingScanResults) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.riskApps, r4.riskApps) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.resultState, r4.resultState) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.selectedRiskKeys, r4.selectedRiskKeys) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pendingUninstallKeys, r4.pendingUninstallKeys) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18 */
    public int hashCode() {
        boolean r0 = this.isScanFinished;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.isScanUiFinished;
        if (r4 == true) goto L9;
        r1 = r4;
    L9:
        int r5 = (r3 + r1) * 31;
        List<QScanResultEntity> r6 = this.pendingScanResults;
        int r7 = 0;
        if (r6 == null) goto L12;
        int r8 = r6.hashCode();
    L13:
        int r9 = (r5 + r8) * 31;
        List<SafeCheckRiskAppItem> r10 = this.riskApps;
        if (r10 == null) goto L16;
        int r11 = r10.hashCode();
    L17:
        int r12 = (r9 + r11) * 31;
        ResultState r13 = this.resultState;
        if (r13 == null) goto L20;
        int r14 = r13.hashCode();
    L21:
        int r15 = (r12 + r14) * 31;
        Set<String> r16 = this.selectedRiskKeys;
        if (r16 == null) goto L24;
        int r17 = r16.hashCode();
    L25:
        int r18 = (r15 + r17) * 31;
        Set<String> r19 = this.pendingUninstallKeys;
        if (r19 == null) goto L29;
        r7 = r19.hashCode();
    L29:
        return r18 + r7;
    L24:
        r17 = 0;
        goto L25
    L20:
        r14 = 0;
        goto L21
    L16:
        r11 = 0;
        goto L17
    L12:
        r8 = 0;
        goto L13
    }

    public String toString() {
        return "SafeCheckUiState(isScanFinished=" + this.isScanFinished + ", isScanUiFinished=" + this.isScanUiFinished + ", pendingScanResults=" + this.pendingScanResults + ", riskApps=" + this.riskApps + ", resultState=" + this.resultState + ", selectedRiskKeys=" + this.selectedRiskKeys + ", pendingUninstallKeys=" + this.pendingUninstallKeys + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCheckUiState(boolean r2, boolean r3, List<? extends QScanResultEntity> r4, List<SafeCheckRiskAppItem> r5, ResultState r6, Set<String> r7, Set<String> r8) {
        Intrinsics.checkNotNullParameter(r5, "riskApps");
        Intrinsics.checkNotNullParameter(r7, "selectedRiskKeys");
        Intrinsics.checkNotNullParameter(r8, "pendingUninstallKeys");
        this.isScanFinished = r2;
        this.isScanUiFinished = r3;
        this.pendingScanResults = r4;
        this.riskApps = r5;
        this.resultState = r6;
        this.selectedRiskKeys = r7;
        this.pendingUninstallKeys = r8;
    }

    public final boolean isScanFinished() {
        return this.isScanFinished;
    }

    public final boolean isScanUiFinished() {
        return this.isScanUiFinished;
    }

    public /* synthetic */ SafeCheckUiState(boolean r2, boolean r3, List r4, List r5, ResultState r6, Set r7, Set r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r9 & 4) == 0) goto L12;
        List r11 = (List) null;
        r4 = null;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r5 = CollectionsKt.emptyList();
    L15:
        if ((r9 & 16) == 0) goto L18;
        ResultState r12 = (ResultState) null;
        r6 = null;
    L18:
        if ((r9 & 32) == 0) goto L21;
        r7 = SetsKt.emptySet();
    L21:
        if ((r9 & 64) == 0) goto L23;
        r8 = SetsKt.emptySet();
    L23:
        this(r2, r3, r4, r5, r6, r7, r8);
    }

    public final List<QScanResultEntity> getPendingScanResults() {
        return this.pendingScanResults;
    }

    public final List<SafeCheckRiskAppItem> getRiskApps() {
        return this.riskApps;
    }

    public final ResultState getResultState() {
        return this.resultState;
    }

    public final Set<String> getSelectedRiskKeys() {
        return this.selectedRiskKeys;
    }

    public final Set<String> getPendingUninstallKeys() {
        return this.pendingUninstallKeys;
    }
}
