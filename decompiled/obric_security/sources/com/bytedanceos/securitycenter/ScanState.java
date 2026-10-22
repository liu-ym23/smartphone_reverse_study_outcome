package com.bytedanceos.securitycenter;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.common.module.qscanner.QScanResultEntity;

/* JADX INFO: compiled from: SafeCheckViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/bytedanceos/securitycenter/ScanState;", "", "()V", "Canceled", "Error", "Finished", "Idle", "Scanning", "Lcom/bytedanceos/securitycenter/ScanState$Canceled;", "Lcom/bytedanceos/securitycenter/ScanState$Error;", "Lcom/bytedanceos/securitycenter/ScanState$Finished;", "Lcom/bytedanceos/securitycenter/ScanState$Idle;", "Lcom/bytedanceos/securitycenter/ScanState$Scanning;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ScanState {

    /* JADX INFO: compiled from: SafeCheckViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedanceos/securitycenter/ScanState$Canceled;", "Lcom/bytedanceos/securitycenter/ScanState;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Canceled extends ScanState {
        public static final Canceled INSTANCE = null;

        static {
            INSTANCE = new Canceled();
        }

        private Canceled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SafeCheckViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedanceos/securitycenter/ScanState$Error;", "Lcom/bytedanceos/securitycenter/ScanState;", "errCode", "", "(I)V", "getErrCode", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Error extends ScanState {
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

    /* JADX INFO: compiled from: SafeCheckViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedanceos/securitycenter/ScanState$Finished;", "Lcom/bytedanceos/securitycenter/ScanState;", "allResults", "", "Ltmsdk/common/module/qscanner/QScanResultEntity;", "(Ljava/util/List;)V", "getAllResults", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Finished extends ScanState {
        private final List<QScanResultEntity> allResults;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Finished copy$default(Finished r0, List r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.allResults;
        L6:
            return r0.copy(r1);
        }

        public final List<QScanResultEntity> component1() {
            return this.allResults;
        }

        public final Finished copy(List<? extends QScanResultEntity> r1) {
            Intrinsics.checkNotNullParameter(r1, "allResults");
            return new Finished(r1);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof Finished) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.allResults, ((Finished) r2).allResults) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            List<QScanResultEntity> r0 = this.allResults;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "Finished(allResults=" + this.allResults + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Finished(List<? extends QScanResultEntity> r2) {
            Intrinsics.checkNotNullParameter(r2, "allResults");
            super(null);
            this.allResults = r2;
        }

        public final List<QScanResultEntity> getAllResults() {
            return this.allResults;
        }
    }

    /* JADX INFO: compiled from: SafeCheckViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedanceos/securitycenter/ScanState$Idle;", "Lcom/bytedanceos/securitycenter/ScanState;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Idle extends ScanState {
        public static final Idle INSTANCE = null;

        static {
            INSTANCE = new Idle();
        }

        private Idle() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SafeCheckViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedanceos/securitycenter/ScanState$Scanning;", "Lcom/bytedanceos/securitycenter/ScanState;", "progress", "", "currentItemName", "", "(ILjava/lang/String;)V", "getCurrentItemName", "()Ljava/lang/String;", "getProgress", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Scanning extends ScanState {
        private final String currentItemName;
        private final int progress;

        public static /* synthetic */ Scanning copy$default(Scanning r0, int r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.progress;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.currentItemName;
        L9:
            return r0.copy(r1, r2);
        }

        public final int component1() {
            return this.progress;
        }

        public final String component2() {
            return this.currentItemName;
        }

        public final Scanning copy(int r1, String r2) {
            Intrinsics.checkNotNullParameter(r2, "currentItemName");
            return new Scanning(r1, r2);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof Scanning) == false) goto L10;
            Scanning r4 = (Scanning) r3;
            if (this.progress == r4.progress) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.currentItemName, r4.currentItemName) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            int r0 = Integer.hashCode(this.progress) * 31;
            String r1 = this.currentItemName;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        public String toString() {
            return "Scanning(progress=" + this.progress + ", currentItemName=" + this.currentItemName + ")";
        }

        public Scanning(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "currentItemName");
            super(null);
            this.progress = r2;
            this.currentItemName = r3;
        }

        public final String getCurrentItemName() {
            return this.currentItemName;
        }

        public final int getProgress() {
            return this.progress;
        }
    }

    private ScanState() {
    }

    public /* synthetic */ ScanState(DefaultConstructorMarker r1) {
        this();
    }
}
