package com.obric.safecheck.riskcontrol.domain.usecase;

import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.riskcontrol.api.model.RiskControlFlags;
import com.obric.safecheck.riskcontrol.api.repo.ScanResultRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApplyRiskControlUseCase.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0019Bô\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012K\u0010\u0004\u001aG\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0005\u0012K\u0010\u000e\u001aG\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\r0\u0005\u0012K\u0010\u0010\u001aG\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0006J2\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nRS\u0010\u000e\u001aG\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000RS\u0010\u0010\u001aG\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RS\u0010\u0004\u001aG\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/safecheck/riskcontrol/domain/usecase/ApplyRiskControlUseCase;", "", "repository", "Lcom/obric/safecheck/riskcontrol/api/repo/ScanResultRepository;", "settingsWriter", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", ApkVirusCheckProvider.KEY_PKG, "", AccountInfoBundleKey.USER_ID, "flags", "", "policyEnforcer", "addedFlags", "policyReleaser", "removedFlags", "(Lcom/obric/safecheck/riskcontrol/api/repo/ScanResultRepository;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;)V", "deleteRecord", "execute", "Lcom/obric/safecheck/riskcontrol/domain/usecase/ApplyRiskControlUseCase$Result;", "virusDescription", "previousFlags", "nextFlags", "Result", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ApplyRiskControlUseCase {
    private final Function3<String, Integer, Integer, Unit> policyEnforcer;
    private final Function3<String, Integer, Integer, Unit> policyReleaser;
    private final ScanResultRepository repository;
    private final Function3<String, Integer, Integer, Unit> settingsWriter;

    /* JADX INFO: compiled from: ApplyRiskControlUseCase.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/safecheck/riskcontrol/domain/usecase/ApplyRiskControlUseCase$Result;", "", "controlFlags", "", "(I)V", "getControlFlags", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Result {
        private final int controlFlags;

        public static /* synthetic */ Result copy$default(Result r0, int r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.controlFlags;
        L6:
            return r0.copy(r1);
        }

        public final int component1() {
            return this.controlFlags;
        }

        public final Result copy(int r1) {
            return new Result(r1);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof Result) == true) goto L6;
            return false;
        L6:
            if (this.controlFlags == ((Result) r2).controlFlags) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            return Integer.hashCode(this.controlFlags);
        }

        public String toString() {
            return "Result(controlFlags=" + this.controlFlags + ")";
        }

        public Result(int r1) {
            this.controlFlags = r1;
        }

        public final int getControlFlags() {
            return this.controlFlags;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ApplyRiskControlUseCase(ScanResultRepository r2, Function3<? super String, ? super Integer, ? super Integer, Unit> r3, Function3<? super String, ? super Integer, ? super Integer, Unit> r4, Function3<? super String, ? super Integer, ? super Integer, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        Intrinsics.checkNotNullParameter(r3, "settingsWriter");
        Intrinsics.checkNotNullParameter(r4, "policyEnforcer");
        Intrinsics.checkNotNullParameter(r5, "policyReleaser");
        this.repository = r2;
        this.settingsWriter = r3;
        this.policyEnforcer = r4;
        this.policyReleaser = r5;
    }

    public final Result execute(String r5, int r6, String r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r5, ApkVirusCheckProvider.KEY_PKG);
        if (r9 != r8) goto L6;
        return null;
    L6:
        int r0 = (~r8) & r9;
        int r10 = r8 & (~r9);
        this.settingsWriter.invoke(r5, Integer.valueOf(r6), Integer.valueOf(r9));
        boolean r1 = RiskControlFlags.hasControlledItem(r9);
        this.repository.updateControlState(r5, r6, r1, r7);
        if (r0 == 0) goto L9;
        this.policyEnforcer.invoke(r5, Integer.valueOf(r6), Integer.valueOf(r0));
    L9:
        if (r10 == 0) goto L12;
        this.policyReleaser.invoke(r5, Integer.valueOf(r6), Integer.valueOf(r10));
    L12:
        return new Result(r9);
    }

    public final void deleteRecord(String r2) {
        Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
        this.repository.deleteByPkg(r2);
    }
}
