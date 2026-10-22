package com.obric.safecheck.riskcontrol.api.repo;

import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.riskcontrol.api.model.ScanResultRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScanResultRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0014J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J*\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H&J\u0016\u0010\u0011\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\tH&¨\u0006\u0015"}, d2 = {"Lcom/obric/safecheck/riskcontrol/api/repo/ScanResultRepository;", "", "deleteByPkg", "", ApkVirusCheckProvider.KEY_PKG, "", "isRiskControlled", "", "listAll", "", "Lcom/obric/safecheck/riskcontrol/api/model/ScanResultRecord;", "listControlled", "updateControlState", AccountInfoBundleKey.USER_ID, "", "controlled", "virusDescription", "upsertScanResults", "records", "Lcom/obric/safecheck/riskcontrol/api/repo/ScanResultRepository$NewScanResult;", "NewScanResult", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface ScanResultRepository {

    /* JADX INFO: compiled from: ScanResultRepository.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/obric/safecheck/riskcontrol/api/repo/ScanResultRepository$NewScanResult;", "", ApkVirusCheckProvider.KEY_PKG, "", ApkVirusCheckProvider.KEY_VIRUS_TYPE, ApkVirusCheckProvider.KEY_VIRUS_TYPE_CODE, "", "virusName", "virusDescription", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getPkg", "()Ljava/lang/String;", "getVirusDescription", "getVirusName", "getVirusType", "getVirusTypeCode", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class NewScanResult {
        private final String pkg;
        private final String virusDescription;
        private final String virusName;
        private final String virusType;
        private final int virusTypeCode;

        public static /* synthetic */ NewScanResult copy$default(NewScanResult r3, String r4, String r5, int r6, String r7, String r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.pkg;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.virusType;
        L8:
            String r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.virusTypeCode;
        L11:
            int r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.virusName;
        L14:
            String r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.virusDescription;
        L17:
            String r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final String component1() {
            return this.pkg;
        }

        public final String component2() {
            return this.virusType;
        }

        public final int component3() {
            return this.virusTypeCode;
        }

        public final String component4() {
            return this.virusName;
        }

        public final String component5() {
            return this.virusDescription;
        }

        public final NewScanResult copy(String r7, String r8, int r9, String r10, String r11) {
            Intrinsics.checkNotNullParameter(r7, ApkVirusCheckProvider.KEY_PKG);
            Intrinsics.checkNotNullParameter(r8, ApkVirusCheckProvider.KEY_VIRUS_TYPE);
            return new NewScanResult(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof NewScanResult) == false) goto L16;
            NewScanResult r4 = (NewScanResult) r3;
            if (Intrinsics.areEqual(this.pkg, r4.pkg) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.virusType, r4.virusType) == true) goto L10;
            return false;
        L10:
            if (this.virusTypeCode == r4.virusTypeCode) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.virusName, r4.virusName) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.virusDescription, r4.virusDescription) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            String r0 = this.pkg;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.virusType;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (((r3 + r5) * 31) + Integer.hashCode(this.virusTypeCode)) * 31;
            String r7 = this.virusName;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.virusDescription;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "NewScanResult(pkg=" + this.pkg + ", virusType=" + this.virusType + ", virusTypeCode=" + this.virusTypeCode + ", virusName=" + this.virusName + ", virusDescription=" + this.virusDescription + ")";
        }

        public NewScanResult(String r2, String r3, int r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
            Intrinsics.checkNotNullParameter(r3, ApkVirusCheckProvider.KEY_VIRUS_TYPE);
            this.pkg = r2;
            this.virusType = r3;
            this.virusTypeCode = r4;
            this.virusName = r5;
            this.virusDescription = r6;
        }

        public final String getPkg() {
            return this.pkg;
        }

        public final String getVirusType() {
            return this.virusType;
        }

        public final int getVirusTypeCode() {
            return this.virusTypeCode;
        }

        public final String getVirusName() {
            return this.virusName;
        }

        public final String getVirusDescription() {
            return this.virusDescription;
        }
    }

    void deleteByPkg(String r1);

    boolean isRiskControlled(String r1);

    List<ScanResultRecord> listAll();

    List<ScanResultRecord> listControlled();

    void updateControlState(String r1, int r2, boolean r3, String r4);

    void upsertScanResults(List<NewScanResult> r1);
}
