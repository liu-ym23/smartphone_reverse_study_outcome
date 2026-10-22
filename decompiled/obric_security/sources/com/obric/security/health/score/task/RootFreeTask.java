package com.obric.security.health.score.task;

import android.content.Context;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.obric.security.health.model.HealthCheckResult;
import com.obric.security.health.model.HealthCheckStatus;
import com.obric.security.health.model.HealthFixCapability;
import com.obric.security.health.score.HealthModuleIds;
import com.obric.security.health.score.HealthScoreLog;
import com.obric.security.health.score.HealthTaskIds;
import com.obric.security.securestate.SecureState;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RootFreeTask.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/obric/security/health/score/task/RootFreeTask;", "Lcom/obric/security/health/score/task/HealthCheckTask;", "()V", "defaultScore", "", "getDefaultScore", "()I", "fixCapability", "Lcom/obric/security/health/model/HealthFixCapability;", "getFixCapability", "()Lcom/obric/security/health/model/HealthFixCapability;", SlardarConfigConsts.CONFIG_ID, "", "getId", "()Ljava/lang/String;", "moduleId", "getModuleId", "check", "Lcom/obric/security/health/model/HealthCheckResult;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readSecureState", "Lcom/obric/security/health/score/task/RootFreeTask$SecureStateResult;", "Companion", "SecureStateResult", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RootFreeTask extends HealthCheckTask {
    private static final Companion Companion = null;

    @Deprecated
    private static final String SOURCE = "RootFreeTask";
    private final int defaultScore;
    private final HealthFixCapability fixCapability;
    private final String id;
    private final String moduleId;

    /* JADX INFO: compiled from: RootFreeTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/security/health/score/task/RootFreeTask$Companion;", "", "()V", "SOURCE", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: RootFreeTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u001a\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0006\u0010$\u001a\u00020\u0003J\t\u0010%\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006&"}, d2 = {"Lcom/obric/security/health/score/task/RootFreeTask$SecureStateResult;", "", "deviceSecure", "", "secureBootEnabled", "avbVerified", "deviceLocked", "kernelSecure", "selinuxEnforcing", "userDebugBuild", "(ZZZZZZZ)V", "getAvbVerified", "()Z", "getDeviceLocked", "getDeviceSecure", "getKernelSecure", "getSecureBootEnabled", "getSelinuxEnforcing", "getUserDebugBuild", "appendTo", "", "evidence", "", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "isSafe", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class SecureStateResult {
        private final boolean avbVerified;
        private final boolean deviceLocked;
        private final boolean deviceSecure;
        private final boolean kernelSecure;
        private final boolean secureBootEnabled;
        private final boolean selinuxEnforcing;
        private final boolean userDebugBuild;

        public static /* synthetic */ SecureStateResult copy$default(SecureStateResult r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r6 = r5.deviceSecure;
        L6:
            if ((r13 & 2) == 0) goto L8;
            r7 = r5.secureBootEnabled;
        L8:
            boolean r15 = r7;
            if ((r13 & 4) == 0) goto L11;
            r8 = r5.avbVerified;
        L11:
            boolean r0 = r8;
            if ((r13 & 8) == 0) goto L14;
            r9 = r5.deviceLocked;
        L14:
            boolean r1 = r9;
            if ((r13 & 16) == 0) goto L17;
            r10 = r5.kernelSecure;
        L17:
            boolean r2 = r10;
            if ((r13 & 32) == 0) goto L20;
            r11 = r5.selinuxEnforcing;
        L20:
            boolean r3 = r11;
            if ((r13 & 64) == 0) goto L23;
            r12 = r5.userDebugBuild;
        L23:
            boolean r16 = r6;
            return r5.copy(r16, r15, r0, r1, r2, r3, r12);
        }

        public final boolean component1() {
            return this.deviceSecure;
        }

        public final boolean component2() {
            return this.secureBootEnabled;
        }

        public final boolean component3() {
            return this.avbVerified;
        }

        public final boolean component4() {
            return this.deviceLocked;
        }

        public final boolean component5() {
            return this.kernelSecure;
        }

        public final boolean component6() {
            return this.selinuxEnforcing;
        }

        public final boolean component7() {
            return this.userDebugBuild;
        }

        public final SecureStateResult copy(boolean r9, boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15) {
            return new SecureStateResult(r9, r10, r11, r12, r13, r14, r15);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof SecureStateResult) == false) goto L20;
            SecureStateResult r4 = (SecureStateResult) r3;
            if (this.deviceSecure == r4.deviceSecure) goto L8;
            return false;
        L8:
            if (this.secureBootEnabled == r4.secureBootEnabled) goto L10;
            return false;
        L10:
            if (this.avbVerified == r4.avbVerified) goto L12;
            return false;
        L12:
            if (this.deviceLocked == r4.deviceLocked) goto L14;
            return false;
        L14:
            if (this.kernelSecure == r4.kernelSecure) goto L16;
            return false;
        L16:
            if (this.selinuxEnforcing == r4.selinuxEnforcing) goto L18;
            return false;
        L18:
            if (this.userDebugBuild == r4.userDebugBuild) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v13, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9, types: [int] */
        public int hashCode() {
            boolean r0 = this.deviceSecure;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.secureBootEnabled;
            ?? r5 = r4;
            if (r4 == false) goto L8;
            r5 = 1;
        L8:
            int r6 = (r3 + r5) * 31;
            boolean r7 = this.avbVerified;
            ?? r8 = r7;
            if (r7 == false) goto L11;
            r8 = 1;
        L11:
            int r9 = (r6 + r8) * 31;
            boolean r10 = this.deviceLocked;
            ?? r11 = r10;
            if (r10 == false) goto L14;
            r11 = 1;
        L14:
            int r12 = (r9 + r11) * 31;
            boolean r13 = this.kernelSecure;
            ?? r14 = r13;
            if (r13 == false) goto L17;
            r14 = 1;
        L17:
            int r15 = (r12 + r14) * 31;
            boolean r16 = this.selinuxEnforcing;
            ?? r17 = r16;
            if (r16 == false) goto L20;
            r17 = 1;
        L20:
            int r18 = (r15 + r17) * 31;
            boolean r19 = this.userDebugBuild;
            if (r19 == true) goto L25;
            r1 = r19;
        L25:
            return r18 + r1;
        }

        public String toString() {
            return "SecureStateResult(deviceSecure=" + this.deviceSecure + ", secureBootEnabled=" + this.secureBootEnabled + ", avbVerified=" + this.avbVerified + ", deviceLocked=" + this.deviceLocked + ", kernelSecure=" + this.kernelSecure + ", selinuxEnforcing=" + this.selinuxEnforcing + ", userDebugBuild=" + this.userDebugBuild + ")";
        }

        public SecureStateResult(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7) {
            this.deviceSecure = r1;
            this.secureBootEnabled = r2;
            this.avbVerified = r3;
            this.deviceLocked = r4;
            this.kernelSecure = r5;
            this.selinuxEnforcing = r6;
            this.userDebugBuild = r7;
        }

        public final boolean getDeviceSecure() {
            return this.deviceSecure;
        }

        public final boolean getSecureBootEnabled() {
            return this.secureBootEnabled;
        }

        public final boolean getAvbVerified() {
            return this.avbVerified;
        }

        public final boolean getDeviceLocked() {
            return this.deviceLocked;
        }

        public final boolean getKernelSecure() {
            return this.kernelSecure;
        }

        public final boolean getSelinuxEnforcing() {
            return this.selinuxEnforcing;
        }

        public final boolean getUserDebugBuild() {
            return this.userDebugBuild;
        }

        public final boolean isSafe() {
            if (this.userDebugBuild == false) goto L5;
        L9:
            return false;
        L5:
            if (this.avbVerified == false) goto L9;
            if (this.deviceLocked == false) goto L9;
            return true;
        }

        public final void appendTo(Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r3, "evidence");
            r3.put("device_secure", String.valueOf(this.deviceSecure));
            r3.put("secure_boot_enabled", String.valueOf(this.secureBootEnabled));
            r3.put("avb_verified", String.valueOf(this.avbVerified));
            r3.put("device_locked", String.valueOf(this.deviceLocked));
            r3.put("kernel_secure", String.valueOf(this.kernelSecure));
            r3.put("selinux_enforcing", String.valueOf(this.selinuxEnforcing));
            r3.put("user_debug_build", String.valueOf(this.userDebugBuild));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RootFreeTask() {
        this.id = HealthTaskIds.ROOT_FREE;
        this.moduleId = HealthModuleIds.SECURITY;
        this.defaultScore = 8;
        this.fixCapability = HealthFixCapability.NONE;
    }

    @Override // com.obric.security.health.score.task.HealthCheckTask
    public String getId() {
        return this.id;
    }

    @Override // com.obric.security.health.score.task.HealthCheckTask
    public String getModuleId() {
        return this.moduleId;
    }

    @Override // com.obric.security.health.score.task.HealthCheckTask
    public int getDefaultScore() {
        return this.defaultScore;
    }

    @Override // com.obric.security.health.score.task.HealthCheckTask
    public HealthFixCapability getFixCapability() {
        return this.fixCapability;
    }

    @Override // com.obric.security.health.score.task.HealthCheckTask
    protected Object check(Context r8, Continuation<? super HealthCheckResult> r9) {
        SecureStateResult r10 = readSecureState();
        if (r10 == null) goto L5;
        boolean r11 = r10.isSafe();
        String r1 = getId();
        if (r11 == false) goto L9;
        HealthCheckStatus r7 = HealthCheckStatus.PASS;
    L10:
        HealthCheckStatus r2 = r7;
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("device_safe", String.valueOf(r11));
        r10.appendTo(r4);
        Unit r12 = Unit.INSTANCE;
        return new HealthCheckResult(r1, r2, null, r4, 4, null);
    L9:
        r7 = HealthCheckStatus.FAIL;
        goto L10
    L5:
        return new HealthCheckResult(getId(), HealthCheckStatus.ERROR, "read secure state failed", null, 8, null);
    }

    private final SecureStateResult readSecureState() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        RootFreeTask r9 = this;     // Catch: Throwable -> L4
        SecureState r10 = SecureState.getInstance();     // Catch: Throwable -> L4
        Object r11 = Result.m774constructorimpl(new SecureStateResult(r10.deviceIsSecure(), r10.securebootIsEnabled(), r10.avbIsVerified(), r10.deviceIsLocked(), r10.kernelIsSecure(), r10.selinuxIsEnforcing(), r10.buildIsUserDebug()));     // Catch: Throwable -> L4
    L6:
        Throwable r1 = Result.m777exceptionOrNullimpl(r11);
        if (r1 == null) goto L10;
        HealthScoreLog.INSTANCE.e(SOURCE, "readSecureStateFailed", r1);
    L10:
        if (Result.m780isFailureimpl(r11) == false) goto L13;
        r11 = null;
    L13:
        return (SecureStateResult) r11;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r11 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L6
    }
}
