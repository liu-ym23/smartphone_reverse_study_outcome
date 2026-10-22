package com.bytedanceos.securitycenter.scan;

import com.obric.safecheck.provider.ApkVirusCheckProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.common.module.qscanner.QScanResultEntity;

/* JADX INFO: compiled from: VirusScanEngineDataSource.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/ScanEngineResult;", "", "()V", "Canceled", "Error", "Finished", "Lcom/bytedanceos/securitycenter/scan/ScanEngineResult$Canceled;", "Lcom/bytedanceos/securitycenter/scan/ScanEngineResult$Error;", "Lcom/bytedanceos/securitycenter/scan/ScanEngineResult$Finished;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ScanEngineResult {

    /* JADX INFO: compiled from: VirusScanEngineDataSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/ScanEngineResult$Canceled;", "Lcom/bytedanceos/securitycenter/scan/ScanEngineResult;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Canceled extends ScanEngineResult {
        public static final Canceled INSTANCE = null;

        static {
            INSTANCE = new Canceled();
        }

        private Canceled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VirusScanEngineDataSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/ScanEngineResult$Error;", "Lcom/bytedanceos/securitycenter/scan/ScanEngineResult;", "errCode", "", "(I)V", "getErrCode", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Error extends ScanEngineResult {
        private final int errCode;

        public static /* synthetic */ Error copy$default(Error r0, int r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.errCode;
        L6:
            return r0.copy(r1);
        }

        public final int component1() {
            return this.errCode;
        }

        public final Error copy(int r1) {
            return new Error(r1);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof Error) == true) goto L6;
            return false;
        L6:
            if (this.errCode == ((Error) r2).errCode) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            return Integer.hashCode(this.errCode);
        }

        public String toString() {
            return "Error(errCode=" + this.errCode + ")";
        }

        public Error(int r2) {
            super(null);
            this.errCode = r2;
        }

        public final int getErrCode() {
            return this.errCode;
        }
    }

    /* JADX INFO: compiled from: VirusScanEngineDataSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/ScanEngineResult$Finished;", "Lcom/bytedanceos/securitycenter/scan/ScanEngineResult;", ApkVirusCheckProvider.KEY_RESULTS, "", "Ltmsdk/common/module/qscanner/QScanResultEntity;", "(Ljava/util/List;)V", "getResults", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Finished extends ScanEngineResult {
        private final List<QScanResultEntity> results;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Finished copy$default(Finished r0, List r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.results;
        L6:
            return r0.copy(r1);
        }

        public final List<QScanResultEntity> component1() {
            return this.results;
        }

        public final Finished copy(List<? extends QScanResultEntity> r1) {
            Intrinsics.checkNotNullParameter(r1, ApkVirusCheckProvider.KEY_RESULTS);
            return new Finished(r1);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof Finished) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.results, ((Finished) r2).results) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            List<QScanResultEntity> r0 = this.results;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "Finished(results=" + this.results + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Finished(List<? extends QScanResultEntity> r2) {
            Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_RESULTS);
            super(null);
            this.results = r2;
        }

        public final List<QScanResultEntity> getResults() {
            return this.results;
        }
    }

    private ScanEngineResult() {
    }

    public /* synthetic */ ScanEngineResult(DefaultConstructorMarker r1) {
        this();
    }
}
