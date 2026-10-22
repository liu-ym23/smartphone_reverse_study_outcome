package com.obric.security.health.score.task;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedanceos.utils.Constants;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.matrix.platform.sdk.ones.safecushion.SafeCushionConstant;
import com.obric.security.health.model.HealthCheckResult;
import com.obric.security.health.model.HealthCheckStatus;
import com.obric.security.health.model.HealthFixCapability;
import com.obric.security.health.score.HealthModuleIds;
import com.obric.security.health.score.HealthScoreLog;
import com.obric.security.health.score.HealthTaskIds;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: SystemLatestTask.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0003\u0019\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/obric/security/health/score/task/SystemLatestTask;", "Lcom/obric/security/health/score/task/HealthCheckTask;", "()V", "defaultScore", "", "getDefaultScore", "()I", "fixCapability", "Lcom/obric/security/health/model/HealthFixCapability;", "getFixCapability", "()Lcom/obric/security/health/model/HealthFixCapability;", SlardarConfigConsts.CONFIG_ID, "", "getId", "()Ljava/lang/String;", "moduleId", "getModuleId", "check", "Lcom/obric/security/health/model/HealthCheckResult;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkUpdate", "Lcom/obric/security/health/score/task/SystemLatestTask$OtaCheckResult;", "optimize", "Companion", "OtaCheckResult", "OtaQueryRequest", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SystemLatestTask extends HealthCheckTask {

    @Deprecated
    private static final String ACTION_UPDATE_QUERY = "com.obric.updatequery";

    @Deprecated
    private static final long CHECK_UPDATE_TIMEOUT_MS = 15000;
    private static final Companion Companion = null;

    @Deprecated
    private static final String KEY_ACTION_STATUS = "action_status";

    @Deprecated
    private static final String KEY_CALLING_PKG = "calling_pkg";

    @Deprecated
    private static final String KEY_DOWNLOAD_STATUS = "download_status";

    @Deprecated
    private static final String KEY_ERROR_MSG = "error_msg";

    @Deprecated
    private static final String KEY_RESULT_CODE = "result_code";

    @Deprecated
    private static final String KEY_UPDATE_NAME = "update_name";

    @Deprecated
    private static final String KEY_UPDATE_PROGRESS = "update_progress";

    @Deprecated
    private static final String KEY_UPDATE_STATUS = "update_status";

    @Deprecated
    private static final int METHOD_CHECK_UPDATE = 100;

    @Deprecated
    private static final int RESULT_CODE_ERROR = -1;

    @Deprecated
    private static final String SOURCE = "SystemLatestTask";

    @Deprecated
    private static final int STATUS_INVALID = -1;

    @Deprecated
    private static final String UPDATER_PACKAGE = "com.obric.updater";

    @Deprecated
    private static final String UPDATER_UPDATES_CHECK_ACTIVITY = "com.obric.updater.UpdatesCheck";

    @Deprecated
    private static final int UPDATE_STATUS_CHECK_FAILED = 1;

    @Deprecated
    private static final int UPDATE_STATUS_NO_UPDATE = 0;
    private final int defaultScore;
    private final HealthFixCapability fixCapability;
    private final String id;
    private final String moduleId;

    /* JADX INFO: compiled from: SystemLatestTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0018\u001a\u00020\u0019*\u0004\u0018\u00010\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/security/health/score/task/SystemLatestTask$Companion;", "", "()V", "ACTION_UPDATE_QUERY", "", "CHECK_UPDATE_TIMEOUT_MS", "", "KEY_ACTION_STATUS", "KEY_CALLING_PKG", "KEY_DOWNLOAD_STATUS", "KEY_ERROR_MSG", "KEY_RESULT_CODE", "KEY_UPDATE_NAME", "KEY_UPDATE_PROGRESS", "KEY_UPDATE_STATUS", "METHOD_CHECK_UPDATE", "", "RESULT_CODE_ERROR", "SOURCE", "STATUS_INVALID", "UPDATER_PACKAGE", "UPDATER_UPDATES_CHECK_ACTIVITY", "UPDATE_STATUS_CHECK_FAILED", "UPDATE_STATUS_NO_UPDATE", "toOtaCheckResult", "Lcom/obric/security/health/score/task/SystemLatestTask$OtaCheckResult;", "Landroid/os/Bundle;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ OtaCheckResult access$toOtaCheckResult(Companion r0, Bundle r1) {
            return r0.toOtaCheckResult(r1);
        }

        private final OtaCheckResult toOtaCheckResult(Bundle r9) {
            int r0 = -1;
            if (r9 == null) goto L5;
            int r1 = r9.getInt("result_code", -1);
        L6:
            int r2 = 1;
            if (r9 == null) goto L9;
            r2 = r9.getInt(SystemLatestTask.KEY_UPDATE_STATUS, 1);
        L9:
            if (r9 == null) goto L11;
            int r3 = r9.getInt(SystemLatestTask.KEY_DOWNLOAD_STATUS, -1);
        L12:
            if (r9 == null) goto L14;
            r0 = r9.getInt(SystemLatestTask.KEY_ACTION_STATUS, -1);
        L14:
            int r4 = r0;
            int r5 = 0;
            if (r9 == null) goto L17;
            r5 = r9.getInt(SystemLatestTask.KEY_UPDATE_PROGRESS, 0);
        L17:
            int r6 = r5;
            String r7 = null;
            if (r9 == null) goto L20;
            String r8 = r9.getString(SystemLatestTask.KEY_UPDATE_NAME);
        L21:
            String r10 = "";
            if (r8 != null) goto L24;
            r8 = "";
        L24:
            if (r9 == null) goto L26;
            r7 = r9.getString(SystemLatestTask.KEY_ERROR_MSG);
        L26:
            if (r7 == null) goto L30;
            r10 = r7;
        L30:
            return new OtaCheckResult(r1, r2, r3, r4, r6, r8, r10);
        L20:
            r8 = null;
            goto L21
        L11:
            r3 = -1;
            goto L12
        L5:
            r1 = -1;
            goto L6
        }
    }

    /* JADX INFO: compiled from: SystemLatestTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0!J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, d2 = {"Lcom/obric/security/health/score/task/SystemLatestTask$OtaCheckResult;", "", "resultCode", "", "updateStatus", "downloadStatus", "actionStatus", "updateProgress", "updateName", "", AccountConst.KEY_ERROR_MSG, "(IIIIILjava/lang/String;Ljava/lang/String;)V", "getActionStatus", "()I", "getDownloadStatus", "getErrorMsg", "()Ljava/lang/String;", "getResultCode", "getUpdateName", "getUpdateProgress", "getUpdateStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "evidence", "", "hashCode", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class OtaCheckResult {
        private final int actionStatus;
        private final int downloadStatus;
        private final String errorMsg;
        private final int resultCode;
        private final String updateName;
        private final int updateProgress;
        private final int updateStatus;

        public static /* synthetic */ OtaCheckResult copy$default(OtaCheckResult r5, int r6, int r7, int r8, int r9, int r10, String r11, String r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r6 = r5.resultCode;
        L6:
            if ((r13 & 2) == 0) goto L8;
            r7 = r5.updateStatus;
        L8:
            int r15 = r7;
            if ((r13 & 4) == 0) goto L11;
            r8 = r5.downloadStatus;
        L11:
            int r0 = r8;
            if ((r13 & 8) == 0) goto L14;
            r9 = r5.actionStatus;
        L14:
            int r1 = r9;
            if ((r13 & 16) == 0) goto L17;
            r10 = r5.updateProgress;
        L17:
            int r2 = r10;
            if ((r13 & 32) == 0) goto L20;
            r11 = r5.updateName;
        L20:
            String r3 = r11;
            if ((r13 & 64) == 0) goto L23;
            r12 = r5.errorMsg;
        L23:
            int r16 = r6;
            return r5.copy(r16, r15, r0, r1, r2, r3, r12);
        }

        public final int component1() {
            return this.resultCode;
        }

        public final int component2() {
            return this.updateStatus;
        }

        public final int component3() {
            return this.downloadStatus;
        }

        public final int component4() {
            return this.actionStatus;
        }

        public final int component5() {
            return this.updateProgress;
        }

        public final String component6() {
            return this.updateName;
        }

        public final String component7() {
            return this.errorMsg;
        }

        public final OtaCheckResult copy(int r9, int r10, int r11, int r12, int r13, String r14, String r15) {
            Intrinsics.checkNotNullParameter(r14, "updateName");
            Intrinsics.checkNotNullParameter(r15, AccountConst.KEY_ERROR_MSG);
            return new OtaCheckResult(r9, r10, r11, r12, r13, r14, r15);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof OtaCheckResult) == false) goto L20;
            OtaCheckResult r4 = (OtaCheckResult) r3;
            if (this.resultCode == r4.resultCode) goto L8;
            return false;
        L8:
            if (this.updateStatus == r4.updateStatus) goto L10;
            return false;
        L10:
            if (this.downloadStatus == r4.downloadStatus) goto L12;
            return false;
        L12:
            if (this.actionStatus == r4.actionStatus) goto L14;
            return false;
        L14:
            if (this.updateProgress == r4.updateProgress) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.updateName, r4.updateName) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.errorMsg, r4.errorMsg) == true) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            int r0 = ((((((((Integer.hashCode(this.resultCode) * 31) + Integer.hashCode(this.updateStatus)) * 31) + Integer.hashCode(this.downloadStatus)) * 31) + Integer.hashCode(this.actionStatus)) * 31) + Integer.hashCode(this.updateProgress)) * 31;
            String r1 = this.updateName;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.errorMsg;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            return r4 + r2;
        L5:
            r3 = 0;
            goto L6
        }

        public String toString() {
            return "OtaCheckResult(resultCode=" + this.resultCode + ", updateStatus=" + this.updateStatus + ", downloadStatus=" + this.downloadStatus + ", actionStatus=" + this.actionStatus + ", updateProgress=" + this.updateProgress + ", updateName=" + this.updateName + ", errorMsg=" + this.errorMsg + ")";
        }

        public OtaCheckResult(int r2, int r3, int r4, int r5, int r6, String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, "updateName");
            Intrinsics.checkNotNullParameter(r8, AccountConst.KEY_ERROR_MSG);
            this.resultCode = r2;
            this.updateStatus = r3;
            this.downloadStatus = r4;
            this.actionStatus = r5;
            this.updateProgress = r6;
            this.updateName = r7;
            this.errorMsg = r8;
        }

        public final int getResultCode() {
            return this.resultCode;
        }

        public final int getUpdateStatus() {
            return this.updateStatus;
        }

        public final int getDownloadStatus() {
            return this.downloadStatus;
        }

        public final int getActionStatus() {
            return this.actionStatus;
        }

        public final int getUpdateProgress() {
            return this.updateProgress;
        }

        public final String getUpdateName() {
            return this.updateName;
        }

        public final String getErrorMsg() {
            return this.errorMsg;
        }

        public final Map<String, String> evidence() {
            SystemLatestTask.access$Companion();
            SystemLatestTask.access$Companion();
            SystemLatestTask.access$Companion();
            SystemLatestTask.access$Companion();
            SystemLatestTask.access$Companion();
            SystemLatestTask.access$Companion();
            SystemLatestTask.access$Companion();
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("result_code", String.valueOf(this.resultCode)), TuplesKt.to(SystemLatestTask.KEY_UPDATE_STATUS, String.valueOf(this.updateStatus)), TuplesKt.to(SystemLatestTask.KEY_DOWNLOAD_STATUS, String.valueOf(this.downloadStatus)), TuplesKt.to(SystemLatestTask.KEY_ACTION_STATUS, String.valueOf(this.actionStatus)), TuplesKt.to(SystemLatestTask.KEY_UPDATE_PROGRESS, String.valueOf(this.updateProgress)), TuplesKt.to(SystemLatestTask.KEY_UPDATE_NAME, this.updateName), TuplesKt.to(SystemLatestTask.KEY_ERROR_MSG, this.errorMsg)});
        }
    }

    /* JADX INFO: compiled from: SystemLatestTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001:\u0001\"B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001c\u0010\u001c\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010 \u001a\u00020\u0011H\u0002J\u0006\u0010!\u001a\u00020\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/security/health/score/task/SystemLatestTask$OtaQueryRequest;", "Landroid/content/ServiceConnection;", "context", "Landroid/content/Context;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Lcom/obric/security/health/score/task/SystemLatestTask$OtaCheckResult;", "(Landroid/content/Context;Lkotlinx/coroutines/CancellableContinuation;)V", "bound", "", "finished", "Ljava/util/concurrent/atomic/AtomicBoolean;", "responseHandler", "Landroid/os/Handler;", "responseMessenger", "Landroid/os/Messenger;", "cancel", "", "cancelOnMain", SafeCushionConstant.FINISH_STATE, "result", "onBindingDied", "name", "Landroid/content/ComponentName;", "onNullBinding", "onResponse", "message", "Landroid/os/Message;", "onServiceConnected", "binder", "Landroid/os/IBinder;", "onServiceDisconnected", "release", "start", "OtaResponseCallback", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class OtaQueryRequest implements ServiceConnection {
        private boolean bound;
        private final Context context;
        private final CancellableContinuation<OtaCheckResult> continuation;
        private final AtomicBoolean finished;
        private Handler responseHandler;
        private Messenger responseMessenger;

        /* JADX INFO: compiled from: SystemLatestTask.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/security/health/score/task/SystemLatestTask$OtaQueryRequest$OtaResponseCallback;", "Landroid/os/Handler$Callback;", "request", "Lcom/obric/security/health/score/task/SystemLatestTask$OtaQueryRequest;", "(Lcom/obric/security/health/score/task/SystemLatestTask$OtaQueryRequest;)V", "requestRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "handleMessage", "", "message", "Landroid/os/Message;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
        private static final class OtaResponseCallback implements Handler.Callback {
            private final WeakReference<OtaQueryRequest> requestRef;

            public OtaResponseCallback(OtaQueryRequest r2) {
                Intrinsics.checkNotNullParameter(r2, "request");
                this.requestRef = new WeakReference(r2);
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message r2) {
                Intrinsics.checkNotNullParameter(r2, "message");
                OtaQueryRequest r1 = this.requestRef.get();
                if (r1 == null) goto L7;
                OtaQueryRequest.access$onResponse(r1, r2);
                return true;
            L7:
                return true;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public OtaQueryRequest(Context r2, CancellableContinuation<? super OtaCheckResult> r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "continuation");
            this.context = r2;
            this.continuation = r3;
            this.finished = new AtomicBoolean(false);
            this.responseHandler = new Handler(Looper.getMainLooper(), new OtaResponseCallback(this));
            this.responseMessenger = new Messenger(this.responseHandler);
        }

        public static final /* synthetic */ void access$cancelOnMain(OtaQueryRequest r0) {
            r0.cancelOnMain();
        }

        public static final /* synthetic */ void access$onResponse(OtaQueryRequest r0, Message r1) {
            r0.onResponse(r1);
        }

        public final void start() {
            Intent r0 = new Intent();
            SystemLatestTask.access$Companion();
            r0.setAction(SystemLatestTask.ACTION_UPDATE_QUERY);
            SystemLatestTask.access$Companion();
            r0.setPackage(SystemLatestTask.UPDATER_PACKAGE);
            HealthScoreLog r1 = HealthScoreLog.INSTANCE;
            SystemLatestTask.access$Companion();
            r1.d(SystemLatestTask.SOURCE, "bindOtaProxyService");
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
            OtaQueryRequest r3 = this;     // Catch: Throwable -> L5
            Object r4 = Result.m774constructorimpl(Boolean.valueOf(this.context.bindService(r0, this, 1)));     // Catch: Throwable -> L5
        L7:
            Throwable r5 = Result.m777exceptionOrNullimpl(r4);
            if (r5 == null) goto L11;
            HealthScoreLog r6 = HealthScoreLog.INSTANCE;
            SystemLatestTask.access$Companion();
            r6.e(SystemLatestTask.SOURCE, "bindOtaProxyServiceFailed", r5);
            Unit r7 = Unit.INSTANCE;
        L11:
            if (Result.m780isFailureimpl(r4) == false) goto L13;
            r4 = false;
        L13:
            boolean r8 = ((Boolean) r4).booleanValue();
            this.bound = r8;
            if (r8 == true) goto L19;
            finish(null);
            return;
        L19:
            return;
        L5:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            r4 = Result.m774constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        public final void cancel() {
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
            cancelOnMain();
            return;
        L5:
            new Handler(Looper.getMainLooper()).post(new SystemLatestTask$OtaQueryRequest$cancel$1(this));
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r5, IBinder r6) {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
            OtaQueryRequest r1 = this;     // Catch: Throwable -> L12
            if (r6 == null) goto L11;
            Messenger r2 = new Messenger(r6);     // Catch: Throwable -> L12
            SystemLatestTask.access$Companion();     // Catch: Throwable -> L12
            Message r7 = Message.obtain(null, 100);     // Catch: Throwable -> L12
            Messenger r3 = this.responseMessenger;     // Catch: Throwable -> L12
            if (r3 == null) goto L9;
            r7.replyTo = r3;     // Catch: Throwable -> L12
            Bundle r4 = new Bundle();     // Catch: Throwable -> L12
            SystemLatestTask.access$Companion();     // Catch: Throwable -> L12
            r4.putString(SystemLatestTask.KEY_CALLING_PKG, this.context.getPackageName());     // Catch: Throwable -> L12
            Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L12
            r7.setData(r4);     // Catch: Throwable -> L12
            r2.send(r7);     // Catch: Throwable -> L12
            Object r9 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
        L14:
            Throwable r10 = Result.m777exceptionOrNullimpl(r9);
            if (r10 != null) goto L17;
        L20:
            Result.m780isFailureimpl(r9);
            return;
        L17:
            if ((r10 instanceof RemoteException) == true) goto L19;
            HealthScoreLog r11 = HealthScoreLog.INSTANCE;
            SystemLatestTask.access$Companion();
            r11.e(SystemLatestTask.SOURCE, "checkOtaUpdateFailed", r10);
        L19:
            finish(null);
            goto L20
        L9:
            throw new IllegalArgumentException("ota response messenger released".toString());     // Catch: Throwable -> L12
        L11:
            throw new IllegalArgumentException("ota proxy binder is null".toString());     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r9 = Result.m774constructorimpl(ResultKt.createFailure(th));
            goto L14
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r7) {
            HealthScoreLog r0 = HealthScoreLog.INSTANCE;
            SystemLatestTask.access$Companion();
            HealthScoreLog.w$default(r0, SystemLatestTask.SOURCE, "otaServiceDisconnected", null, 4, null);
            finish(null);
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName r7) {
            HealthScoreLog r0 = HealthScoreLog.INSTANCE;
            SystemLatestTask.access$Companion();
            HealthScoreLog.w$default(r0, SystemLatestTask.SOURCE, "otaServiceBindingDied", null, 4, null);
            finish(null);
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName r7) {
            HealthScoreLog r0 = HealthScoreLog.INSTANCE;
            SystemLatestTask.access$Companion();
            HealthScoreLog.w$default(r0, SystemLatestTask.SOURCE, "otaServiceNullBinding", null, 4, null);
            finish(null);
        }

        private final void onResponse(Message r2) {
            finish(Companion.access$toOtaCheckResult(SystemLatestTask.access$Companion(), r2.getData()));
        }

        private final void finish(OtaCheckResult r4) {
            if (this.finished.compareAndSet(false, true) == true) goto L13;
            return;
        L13:
        L10:
            th = move-exception;
            release();
            throw th;
        L6:
            if (this.continuation.isActive() == false) goto L8;
            CancellableContinuation<OtaCheckResult> r0 = this.continuation;     // Catch: Throwable -> L10
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
            r0.resumeWith(Result.m774constructorimpl(r4));     // Catch: Throwable -> L10
        L8:
            release();
        }

        private final void cancelOnMain() {
            if (this.finished.compareAndSet(false, true) == false) goto L6;
            release();
            return;
        }

        private final void release() {
            Handler r0 = this.responseHandler;
            if (r0 == null) goto L5;
            r0.removeCallbacksAndMessages(null);
        L5:
            Handler r1 = (Handler) null;
            this.responseHandler = null;
            Messenger r2 = (Messenger) null;
            this.responseMessenger = null;
            if (this.bound == false) goto L18;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
            OtaQueryRequest r4 = this;     // Catch: Throwable -> L9
            this.context.unbindService(this);     // Catch: Throwable -> L9
            Object r5 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        L11:
            Throwable r6 = Result.m777exceptionOrNullimpl(r5);
            if (r6 == null) goto L14;
            HealthScoreLog r7 = HealthScoreLog.INSTANCE;
            SystemLatestTask.access$Companion();
            r7.e(SystemLatestTask.SOURCE, "unbindOtaServiceFailed", r6);
        L14:
            this.bound = false;
            return;
        L9:
            th = move-exception;
            Result.Companion r8 = Result.Companion;
            r5 = Result.m774constructorimpl(ResultKt.createFailure(th));
            goto L11
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.SystemLatestTask$check$1, reason: invalid class name */
    /* JADX INFO: compiled from: SystemLatestTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0094@"}, d2 = {"check", "", "context", "Landroid/content/Context;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/security/health/model/HealthCheckResult;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.SystemLatestTask", f = "SystemLatestTask.kt", i = {0, 0}, l = {40}, m = "check", n = {"this", "startAt"}, s = {"L$0", "J$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SystemLatestTask this$0;

        AnonymousClass1(SystemLatestTask r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.check(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.SystemLatestTask$checkUpdate$2, reason: invalid class name */
    /* JADX INFO: compiled from: SystemLatestTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lcom/obric/security/health/score/task/SystemLatestTask$OtaCheckResult;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.SystemLatestTask$checkUpdate$2", f = "SystemLatestTask.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OtaCheckResult>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX INFO: renamed from: com.obric.security.health.score.task.SystemLatestTask$checkUpdate$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: SystemLatestTask.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lcom/obric/security/health/score/task/SystemLatestTask$OtaCheckResult;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @DebugMetadata(c = "com.obric.security.health.score.task.SystemLatestTask$checkUpdate$2$1", f = "SystemLatestTask.kt", i = {0}, l = {277}, m = "invokeSuspend", n = {"$completion$iv"}, s = {"L$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OtaCheckResult>, Object> {
            Object L$0;
            int label;
            final /* synthetic */ AnonymousClass2 this$0;

            AnonymousClass1(AnonymousClass2 r1, Continuation r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
                Intrinsics.checkNotNullParameter(r2, "completion");
                return new AnonymousClass1(this.this$0, r2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope r1, Continuation<? super OtaCheckResult> r2) {
                return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r6) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                AnonymousClass1 r5 = (AnonymousClass1) this.L$0;
                ResultKt.throwOnFailure(r6);
            L13:
                return r6;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r6);
                this.L$0 = this;
                this.label = 1;
                CancellableContinuationImpl r7 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
                r7.initCancellability();
                CancellableContinuationImpl r2 = r7;
                Context r3 = this.this$0.$context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(r3, "context.applicationContext");
                final OtaQueryRequest r4 = new OtaQueryRequest(r3, r2);
                r2.invokeOnCancellation(new SystemLatestTask$checkUpdate$2$1$1$1(r4));
                r4.start();
                r6 = r7.getResult();
                if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
                DebugProbesKt.probeCoroutineSuspended(this);
            L11:
                if (r6 != r0) goto L13;
                return r0;
            }
        }

        AnonymousClass2(Context r1, Continuation r2) {
            this.$context = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "completion");
            return new AnonymousClass2(this.$context, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super OtaCheckResult> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MainCoroutineDispatcher r6 = Dispatchers.getMain();
            AnonymousClass1 r2 = new AnonymousClass1(this, null);
            this.label = 1;
            r5 = BuildersKt.withContext(r6, r2, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.SystemLatestTask$optimize$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SystemLatestTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0094@"}, d2 = {"optimize", "", "context", "Landroid/content/Context;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/security/health/model/HealthCheckResult;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.SystemLatestTask", f = "SystemLatestTask.kt", i = {0}, l = {69}, m = "optimize", n = {"this"}, s = {"L$0"})
    static final class C03721 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SystemLatestTask this$0;

        C03721(SystemLatestTask r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.optimize(null, this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ Companion access$Companion() {
        return Companion;
    }

    public SystemLatestTask() {
        this.id = HealthTaskIds.SYSTEM_LATEST;
        this.moduleId = HealthModuleIds.UPDATE;
        this.defaultScore = 6;
        this.fixCapability = HealthFixCapability.NAVIGATE;
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
    protected Object check(Context r15, Continuation<? super HealthCheckResult> r16) {
        SystemLatestTask r0 = this;
        if ((r16 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r2 = (AnonymousClass1) r16;
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        boolean r5 = true;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        long r6 = r2.J$0;
        r0 = (SystemLatestTask) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L18:
        OtaCheckResult r7 = (OtaCheckResult) r1;
        long r8 = SystemClock.elapsedRealtime() - r6;
        if (r7 != null) goto L22;
        HealthScoreLog.w$default(HealthScoreLog.INSTANCE, SOURCE, "checkOtaUpdate timeout costMs=" + r8, null, 4, null);
        return new HealthCheckResult(r0.getId(), HealthCheckStatus.ERROR, "check ota update timeout", null, 8, null);
    L22:
        HealthScoreLog.INSTANCE.d(SOURCE, "checkOtaUpdate resultCode=" + r7.getResultCode() + " updateStatus=" + r7.getUpdateStatus() + " downloadStatus=" + r7.getDownloadStatus() + " actionStatus=" + r7.getActionStatus() + " updateName=" + r7.getUpdateName() + " costMs=" + r8);
        if (r7.getResultCode() == (-1)) goto L38;
        if (r7.getUpdateStatus() == 1) goto L38;
        if (r7.getUpdateStatus() == 0) goto L31;
        r5 = false;
    L31:
        String r9 = r0.getId();
        if (r5 == false) goto L34;
        HealthCheckStatus r10 = HealthCheckStatus.PASS;
    L36:
        return new HealthCheckResult(r9, r10, null, r7.evidence(), 4, null);
    L34:
        r10 = HealthCheckStatus.FAIL;
    L38:
        return new HealthCheckResult(r0.getId(), HealthCheckStatus.ERROR, "check ota update failed", r7.evidence());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        long r11 = SystemClock.elapsedRealtime();
        Context r12 = r15.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r12, "context.applicationContext");
        r2.L$0 = r0;
        r2.J$0 = r11;
        r2.label = 1;
        r1 = checkUpdate(r12, r2);
        if (r1 != r3) goto L17;
        return r3;
    L17:
        r6 = r11;
    L7:
        r2 = new AnonymousClass1(this, r16);
        goto L8
    }

    @Override // com.obric.security.health.score.task.HealthCheckTask
    protected Object optimize(Context r17, Continuation<? super HealthCheckResult> r18) {
        SystemLatestTask r0 = this;
        if ((r18 instanceof C03721) == false) goto L7;
        C03721 r2 = (C03721) r18;
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        r0 = (SystemLatestTask) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L18:
        if (((Boolean) r1).booleanValue() == false) goto L21;
        return new HealthCheckResult(r0.getId(), HealthCheckStatus.PASS, null, MapsKt.mapOf(TuplesKt.to("activity_launched", Constants.IS_SET)), 4, null);
    L21:
        return new HealthCheckResult(r0.getId(), HealthCheckStatus.ERROR, "launch updater settings failed", null, 8, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        MainCoroutineDispatcher r5 = Dispatchers.getMain();
        SystemLatestTask$optimize$launched$1 r6 = new SystemLatestTask$optimize$launched$1(r17, null);
        r2.L$0 = r0;
        r2.label = 1;
        r1 = BuildersKt.withContext(r5, r6, r2);
        if (r1 != r3) goto L18;
        return r3;
    L7:
        r2 = new C03721(r0, r18);
        goto L8
    }

    private final Object checkUpdate(Context r3, Continuation<? super OtaCheckResult> r4) {
        return TimeoutKt.withTimeoutOrNull(15000, new AnonymousClass2(r3, null), r4);
    }
}
