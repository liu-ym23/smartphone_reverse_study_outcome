package com.obric.security.tcsecurity.safecheck;

import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.olog.OLog;
import com.obric.securitycenter.api.IVirusDbUpdateManager;
import com.obric.securitycenter.api.VirusDbCheckResult;
import com.obric.securitycenter.api.VirusDbUpdateResult;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.common.creator.ManagerCreatorC;
import tmsdk.common.module.update.CheckResult;
import tmsdk.common.module.update.UpdateInfo;
import tmsdk.common.module.update.UpdateManager;

/* JADX INFO: compiled from: TmsVirusDbUpdateManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/security/tcsecurity/safecheck/TmsVirusDbUpdateManager;", "Lcom/obric/securitycenter/api/IVirusDbUpdateManager;", "()V", "CHECK_TIMEOUT_MS", "", "PHASE_AWAIT_TIMEOUT_S", "TAG", "", "VIRUS_UPDATE_FLAGS", "awaitLatch", "", "latch", "Ljava/util/concurrent/CountDownLatch;", "checkVirusDbUpdateSync", "Lcom/obric/securitycenter/api/VirusDbCheckResult;", "doCheck", "Lcom/obric/security/tcsecurity/safecheck/TmsVirusDbUpdateManager$CheckOutcome;", "updateManager", "Ltmsdk/common/module/update/UpdateManager;", "obtainUpdateManager", "updateVirusDbSync", "Lcom/obric/securitycenter/api/VirusDbUpdateResult;", "CheckOutcome", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class TmsVirusDbUpdateManager implements IVirusDbUpdateManager {
    private static final long CHECK_TIMEOUT_MS = 30000;
    public static final TmsVirusDbUpdateManager INSTANCE = null;
    private static final long PHASE_AWAIT_TIMEOUT_S = 60;
    private static final String TAG = "TmsVirusDbUpdate";
    private static final long VIRUS_UPDATE_FLAGS = 0;

    /* JADX INFO: compiled from: TmsVirusDbUpdateManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/obric/security/tcsecurity/safecheck/TmsVirusDbUpdateManager$CheckOutcome;", "", "success", "", AccountConst.KEY_ERROR_CODE, "", "updateInfos", "", "Ltmsdk/common/module/update/UpdateInfo;", "(ZILjava/util/List;)V", "getErrorCode", "()I", "getSuccess", "()Z", "getUpdateInfos", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class CheckOutcome {
        private final int errorCode;
        private final boolean success;
        private final List<UpdateInfo> updateInfos;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CheckOutcome copy$default(CheckOutcome r0, boolean r1, int r2, List r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.success;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.errorCode;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.updateInfos;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final boolean component1() {
            return this.success;
        }

        public final int component2() {
            return this.errorCode;
        }

        public final List<UpdateInfo> component3() {
            return this.updateInfos;
        }

        public final CheckOutcome copy(boolean r1, int r2, List<? extends UpdateInfo> r3) {
            return new CheckOutcome(r1, r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof CheckOutcome) == false) goto L12;
            CheckOutcome r4 = (CheckOutcome) r3;
            if (this.success == r4.success) goto L8;
            return false;
        L8:
            if (this.errorCode == r4.errorCode) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.updateInfos, r4.updateInfos) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean r0 = this.success;
            ?? r1 = r0;
            if (r0 == false) goto L5;
            r1 = 1;
        L5:
            int r2 = ((r1 * 31) + Integer.hashCode(this.errorCode)) * 31;
            List<UpdateInfo> r3 = this.updateInfos;
            if (r3 == null) goto L8;
            int r4 = r3.hashCode();
        L10:
            return r2 + r4;
        L8:
            r4 = 0;
            goto L10
        }

        public String toString() {
            return "CheckOutcome(success=" + this.success + ", errorCode=" + this.errorCode + ", updateInfos=" + this.updateInfos + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CheckOutcome(boolean r1, int r2, List<? extends UpdateInfo> r3) {
            this.success = r1;
            this.errorCode = r2;
            this.updateInfos = r3;
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public /* synthetic */ CheckOutcome(boolean r1, int r2, List r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 2) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r4 & 4) == 0) goto L8;
            r3 = null;
            List r6 = (List) null;
        L8:
            this(r1, r2, r3);
        }

        public final List<UpdateInfo> getUpdateInfos() {
            return this.updateInfos;
        }
    }

    static {
        INSTANCE = new TmsVirusDbUpdateManager();
        VIRUS_UPDATE_FLAGS = 2208686931968L;
    }

    private TmsVirusDbUpdateManager() {
    }

    @Override // com.obric.securitycenter.api.IVirusDbUpdateManager
    public VirusDbUpdateResult updateVirusDbSync() {
        UpdateManager r2 = obtainUpdateManager();
        if (r2 == null) goto L5;
        CheckOutcome r3 = doCheck(r2);
        if (r3.getSuccess() == false) goto L9;
        List<UpdateInfo> r4 = r3.getUpdateInfos();
        List<UpdateInfo> r5 = r4;
        if (r5 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == true) goto L19;
        final AtomicInteger r7 = new AtomicInteger(0);
        final AtomicBoolean r8 = new AtomicBoolean(false);
        final CountDownLatch r9 = new CountDownLatch(1);
        if (r2.update(r4, new TmsVirusDbUpdateManager$updateVirusDbSync$started$1(r7, r9, r8)) == true) goto L26;
        OLog.e(TAG, "update not started");
        return new VirusDbUpdateResult(false, false, 0, 6, null);
    L26:
        if (awaitLatch(r9) == true) goto L30;
        OLog.e(TAG, "update timeout");
        return new VirusDbUpdateResult(false, false, 0, 6, null);
    L30:
        if (r7.get() == 0) goto L33;
        OLog.e(TAG, "update network error: " + r7.get());
        return new VirusDbUpdateResult(false, false, r7.get(), 2, null);
    L33:
        boolean r13 = r8.get();
        return new VirusDbUpdateResult(r13, r13, 0, 4, null);
    L35:
        th = move-exception;
        OLog.e(TAG, "update failed: " + th.getMessage());
        return new VirusDbUpdateResult(false, false, 0, 6, null);
    L19:
        return new VirusDbUpdateResult(true, false, 0, 4, null);
    L13:
        if (r5.isEmpty() == true) goto L16;
        r6 = false;
        goto L17
    L9:
        return new VirusDbUpdateResult(false, false, r3.getErrorCode(), 2, null);
    L5:
        return new VirusDbUpdateResult(false, false, 0, 6, null);
    }

    @Override // com.obric.securitycenter.api.IVirusDbUpdateManager
    public VirusDbCheckResult checkVirusDbUpdateSync() {
        UpdateManager r0 = obtainUpdateManager();
        if (r0 == null) goto L5;
        CheckOutcome r7 = doCheck(r0);
        if (r7.getSuccess() == false) goto L9;
        List<UpdateInfo> r8 = r7.getUpdateInfos();
        if (r8 != null) goto L13;
    L16:
        boolean r9 = true;
    L18:
        return new VirusDbCheckResult(true, !r9, 0, 4, null);
    L13:
        if (r8.isEmpty() == true) goto L16;
        r9 = false;
        goto L18
    L9:
        return new VirusDbCheckResult(false, false, r7.getErrorCode(), 2, null);
    L5:
        return new VirusDbCheckResult(false, false, 0, 6, null);
    }

    private final UpdateManager obtainUpdateManager() {
        return (UpdateManager) ManagerCreatorC.getManager(UpdateManager.class);
    L4:
        th = move-exception;
        OLog.e(TAG, "getManager(UpdateManager) failed: " + th.getMessage());
        return null;
    }

    private final CheckOutcome doCheck(UpdateManager r17) {
        final CheckResult[] r2 = new CheckResult[1];
        final AtomicInteger r3 = new AtomicInteger(0);
        final CountDownLatch r5 = new CountDownLatch(1);
        r17.check(VIRUS_UPDATE_FLAGS, new AnonymousClass1(r3, r5, r2), -1);     // Catch: Throwable -> L18
        if (awaitLatch(r5) == true) goto L9;
        OLog.e(TAG, "check timeout");
        return new CheckOutcome(false, 0, null, 6, null);
    L9:
        if (r3.get() == 0) goto L12;
        OLog.e(TAG, "check network error: " + r3.get());
        return new CheckOutcome(false, r3.get(), null, 4, null);
    L12:
        boolean r11 = true;
        int r12 = 0;
        CheckResult r1 = r2[0];
        if (r1 == null) goto L15;
        List<UpdateInfo> r4 = r1.mUpdateInfoList;
    L17:
        return new CheckOutcome(r11, r12, r4, 2, null);
    L15:
        r4 = null;
    L18:
        th = move-exception;
        OLog.e(TAG, "check failed: " + th.getMessage());
        return new CheckOutcome(false, 0, null, 6, null);
    }

    private final boolean awaitLatch(CountDownLatch r3) {
        return r3.await(60, TimeUnit.SECONDS);
    L4:
        Thread.currentThread().interrupt();
        return false;
    }
}
