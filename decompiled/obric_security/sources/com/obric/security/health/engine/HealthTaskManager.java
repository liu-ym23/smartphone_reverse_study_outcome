package com.obric.security.health.engine;

import android.content.Context;
import android.os.SystemClock;
import com.bytedanceos.utils.Constants;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.security.health.model.HealthCheckResult;
import com.obric.security.health.model.HealthCheckStatus;
import com.obric.security.health.model.HealthFixCapability;
import com.obric.security.health.score.HealthEvidenceKeys;
import com.obric.security.health.score.HealthScoreLog;
import com.obric.security.health.score.task.HealthCheckTask;
import com.obric.security.health.score.task.HealthCheckTaskRegistry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: HealthTaskManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u0000 =2\u00020\u0001:\u0003=>?B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ)\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J9\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00192\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ3\u0010\u001d\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010 J3\u0010!\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010 J3\u0010#\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0018\u0010%\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u0010&\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00192\u0006\u0010*\u001a\u00020\u0011H\u0002JX\u0010+\u001a\u00020'2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u0011H\u0002J \u00105\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\fH\u0002J1\u00106\u001a\b\u0012\u0004\u0012\u00020\f0\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u00107J%\u00108\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u00109J\u0018\u0010:\u001a\u00020-2\u0006\u0010/\u001a\u00020\f2\u0006\u0010,\u001a\u00020-H\u0002J%\u0010;\u001a\b\u0012\u0004\u0012\u00020\f0\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010<R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006@"}, d2 = {"Lcom/obric/security/health/engine/HealthTaskManager;", "", "context", "Landroid/content/Context;", "taskRegistry", "Lcom/obric/security/health/score/task/HealthCheckTaskRegistry;", "listener", "Lcom/obric/security/health/engine/HealthTaskListener;", "(Landroid/content/Context;Lcom/obric/security/health/score/task/HealthCheckTaskRegistry;Lcom/obric/security/health/engine/HealthTaskListener;)V", "appContext", "kotlin.jvm.PlatformType", "checkOne", "Lcom/obric/security/health/model/HealthCheckResult;", "itemId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delayOptimizeFinishIfNeeded", "", "task", "Lcom/obric/security/health/score/task/HealthCheckTask;", "stage", "Lcom/obric/security/health/engine/HealthTaskStage;", "taskStartAt", "(Lcom/obric/security/health/score/task/HealthCheckTask;Lcom/obric/security/health/engine/HealthTaskStage;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "", "itemIds", "runtimeContext", "(Ljava/util/List;Lcom/obric/security/health/engine/HealthTaskStage;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeOne", "notifyListener", "", "(Ljava/lang/String;Lcom/obric/security/health/engine/HealthTaskStage;Landroid/content/Context;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeOneWithProfile", "Lcom/obric/security/health/engine/HealthTaskManager$TaskExecution;", "executeTask", "(Lcom/obric/security/health/score/task/HealthCheckTask;Lcom/obric/security/health/engine/HealthTaskStage;Landroid/content/Context;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isScoreApplied", "logExecuteSummary", "", "costs", "Lcom/obric/security/health/engine/HealthTaskManager$TaskCost;", "taskExecutionCostMs", "logTaskResult", "taskScore", "", "rawResult", "result", "resultScore", "scoreApplied", "executeCostMs", "displayDelayMs", "totalCostMs", "normalizeResult", "optimize", "(Ljava/util/List;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "optimizeOne", "(Ljava/lang/String;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resultScoreOf", "scan", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "TaskCost", "TaskExecution", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthTaskManager {
    private static final Companion Companion = null;

    @Deprecated
    private static final long MIN_OPTIMIZE_TASK_DURATION_MS = 1000;

    @Deprecated
    private static final String SOURCE = "HealthTaskManager";
    private final Context appContext;
    private final HealthTaskListener listener;
    private final HealthCheckTaskRegistry taskRegistry;

    /* JADX INFO: compiled from: HealthTaskManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/security/health/engine/HealthTaskManager$Companion;", "", "()V", "MIN_OPTIMIZE_TASK_DURATION_MS", "", "SOURCE", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: HealthTaskManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b$\b\u0082\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0002\u0010\u0012J\u0006\u0010#\u001a\u00020\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u000fHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003J\t\u0010,\u001a\u00020\u000fHÆ\u0003J\t\u0010-\u001a\u00020\u000fHÆ\u0003Jm\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fHÆ\u0001J\u0013\u0010/\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\nHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u00063"}, d2 = {"Lcom/obric/security/health/engine/HealthTaskManager$TaskCost;", "", "itemId", "", "moduleId", "stage", "Lcom/obric/security/health/engine/HealthTaskStage;", "status", "Lcom/obric/security/health/model/HealthCheckStatus;", "taskScore", "", "resultScore", "scoreApplied", "", "executeCostMs", "", "displayDelayMs", "totalCostMs", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/security/health/engine/HealthTaskStage;Lcom/obric/security/health/model/HealthCheckStatus;IIZJJJ)V", "getDisplayDelayMs", "()J", "getExecuteCostMs", "getItemId", "()Ljava/lang/String;", "getModuleId", "getResultScore", "()I", "getScoreApplied", "()Z", "getStage", "()Lcom/obric/security/health/engine/HealthTaskStage;", "getStatus", "()Lcom/obric/security/health/model/HealthCheckStatus;", "getTaskScore", "getTotalCostMs", "compact", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class TaskCost {
        private final long displayDelayMs;
        private final long executeCostMs;
        private final String itemId;
        private final String moduleId;
        private final int resultScore;
        private final boolean scoreApplied;
        private final HealthTaskStage stage;
        private final HealthCheckStatus status;
        private final int taskScore;
        private final long totalCostMs;

        public static /* synthetic */ TaskCost copy$default(TaskCost r15, String r16, String r17, HealthTaskStage r18, HealthCheckStatus r19, int r20, int r21, boolean r22, long r23, long r25, long r27, int r29, Object r30) {
            if ((r29 & 1) == 0) goto L5;
            String r2 = r15.itemId;
        L7:
            if ((r29 & 2) == 0) goto L9;
            String r3 = r15.moduleId;
        L11:
            if ((r29 & 4) == 0) goto L13;
            HealthTaskStage r4 = r15.stage;
        L15:
            if ((r29 & 8) == 0) goto L17;
            HealthCheckStatus r5 = r15.status;
        L19:
            if ((r29 & 16) == 0) goto L21;
            int r6 = r15.taskScore;
        L23:
            if ((r29 & 32) == 0) goto L25;
            int r7 = r15.resultScore;
        L27:
            if ((r29 & 64) == 0) goto L29;
            boolean r8 = r15.scoreApplied;
        L31:
            if ((r29 & 128) == 0) goto L33;
            long r9 = r15.executeCostMs;
        L35:
            if ((r29 & 256) == 0) goto L37;
            long r11 = r15.displayDelayMs;
        L39:
            if ((r29 & 512) == 0) goto L41;
            long r13 = r15.totalCostMs;
        L43:
            return r15.copy(r2, r3, r4, r5, r6, r7, r8, r9, r11, r13);
        L41:
            r13 = r27;
            goto L43
        L37:
            r11 = r25;
            goto L39
        L33:
            r9 = r23;
            goto L35
        L29:
            r8 = r22;
            goto L31
        L25:
            r7 = r21;
            goto L27
        L21:
            r6 = r20;
            goto L23
        L17:
            r5 = r19;
            goto L19
        L13:
            r4 = r18;
            goto L15
        L9:
            r3 = r17;
            goto L11
        L5:
            r2 = r16;
            goto L7
        }

        public final String component1() {
            return this.itemId;
        }

        public final long component10() {
            return this.totalCostMs;
        }

        public final String component2() {
            return this.moduleId;
        }

        public final HealthTaskStage component3() {
            return this.stage;
        }

        public final HealthCheckStatus component4() {
            return this.status;
        }

        public final int component5() {
            return this.taskScore;
        }

        public final int component6() {
            return this.resultScore;
        }

        public final boolean component7() {
            return this.scoreApplied;
        }

        public final long component8() {
            return this.executeCostMs;
        }

        public final long component9() {
            return this.displayDelayMs;
        }

        public final TaskCost copy(String r16, String r17, HealthTaskStage r18, HealthCheckStatus r19, int r20, int r21, boolean r22, long r23, long r25, long r27) {
            Intrinsics.checkNotNullParameter(r16, "itemId");
            Intrinsics.checkNotNullParameter(r17, "moduleId");
            Intrinsics.checkNotNullParameter(r18, "stage");
            Intrinsics.checkNotNullParameter(r19, "status");
            return new TaskCost(r16, r17, r18, r19, r20, r21, r22, r23, r25, r27);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L4;
            return true;
        L4:
            if ((r5 instanceof TaskCost) == false) goto L26;
            TaskCost r6 = (TaskCost) r5;
            if (Intrinsics.areEqual(this.itemId, r6.itemId) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.moduleId, r6.moduleId) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.stage, r6.stage) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.status, r6.status) == true) goto L14;
            return false;
        L14:
            if (this.taskScore == r6.taskScore) goto L16;
            return false;
        L16:
            if (this.resultScore == r6.resultScore) goto L18;
            return false;
        L18:
            if (this.scoreApplied == r6.scoreApplied) goto L20;
            return false;
        L20:
            if (this.executeCostMs == r6.executeCostMs) goto L22;
            return false;
        L22:
            if (this.displayDelayMs == r6.displayDelayMs) goto L24;
            return false;
        L24:
            if (this.totalCostMs == r6.totalCostMs) goto L40;
            return false;
        L40:
            return true;
        L26:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        public int hashCode() {
            String r0 = this.itemId;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.moduleId;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            HealthTaskStage r7 = this.stage;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            HealthCheckStatus r10 = this.status;
            if (r10 == null) goto L17;
            r1 = r10.hashCode();
        L17:
            int r11 = (((((r9 + r1) * 31) + Integer.hashCode(this.taskScore)) * 31) + Integer.hashCode(this.resultScore)) * 31;
            boolean r12 = this.scoreApplied;
            ?? r13 = r12;
            if (r12 == false) goto L21;
            r13 = 1;
        L21:
            return ((((((r11 + r13) * 31) + Long.hashCode(this.executeCostMs)) * 31) + Long.hashCode(this.displayDelayMs)) * 31) + Long.hashCode(this.totalCostMs);
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
            return "TaskCost(itemId=" + this.itemId + ", moduleId=" + this.moduleId + ", stage=" + this.stage + ", status=" + this.status + ", taskScore=" + this.taskScore + ", resultScore=" + this.resultScore + ", scoreApplied=" + this.scoreApplied + ", executeCostMs=" + this.executeCostMs + ", displayDelayMs=" + this.displayDelayMs + ", totalCostMs=" + this.totalCostMs + ")";
        }

        public TaskCost(String r2, String r3, HealthTaskStage r4, HealthCheckStatus r5, int r6, int r7, boolean r8, long r9, long r11, long r13) {
            Intrinsics.checkNotNullParameter(r2, "itemId");
            Intrinsics.checkNotNullParameter(r3, "moduleId");
            Intrinsics.checkNotNullParameter(r4, "stage");
            Intrinsics.checkNotNullParameter(r5, "status");
            this.itemId = r2;
            this.moduleId = r3;
            this.stage = r4;
            this.status = r5;
            this.taskScore = r6;
            this.resultScore = r7;
            this.scoreApplied = r8;
            this.executeCostMs = r9;
            this.displayDelayMs = r11;
            this.totalCostMs = r13;
        }

        public final String getItemId() {
            return this.itemId;
        }

        public final String getModuleId() {
            return this.moduleId;
        }

        public final HealthTaskStage getStage() {
            return this.stage;
        }

        public final HealthCheckStatus getStatus() {
            return this.status;
        }

        public final int getTaskScore() {
            return this.taskScore;
        }

        public final int getResultScore() {
            return this.resultScore;
        }

        public final boolean getScoreApplied() {
            return this.scoreApplied;
        }

        public final long getExecuteCostMs() {
            return this.executeCostMs;
        }

        public final long getDisplayDelayMs() {
            return this.displayDelayMs;
        }

        public final long getTotalCostMs() {
            return this.totalCostMs;
        }

        public final String compact() {
            return this.itemId + ':' + this.status + ":execute=" + this.executeCostMs + "ms:total=" + this.totalCostMs + "ms:delay=" + this.displayDelayMs + "ms";
        }
    }

    /* JADX INFO: compiled from: HealthTaskManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/security/health/engine/HealthTaskManager$TaskExecution;", "", "result", "Lcom/obric/security/health/model/HealthCheckResult;", "cost", "Lcom/obric/security/health/engine/HealthTaskManager$TaskCost;", "(Lcom/obric/security/health/model/HealthCheckResult;Lcom/obric/security/health/engine/HealthTaskManager$TaskCost;)V", "getCost", "()Lcom/obric/security/health/engine/HealthTaskManager$TaskCost;", "getResult", "()Lcom/obric/security/health/model/HealthCheckResult;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class TaskExecution {
        private final TaskCost cost;
        private final HealthCheckResult result;

        public static /* synthetic */ TaskExecution copy$default(TaskExecution r0, HealthCheckResult r1, TaskCost r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.result;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.cost;
        L9:
            return r0.copy(r1, r2);
        }

        public final HealthCheckResult component1() {
            return this.result;
        }

        public final TaskCost component2() {
            return this.cost;
        }

        public final TaskExecution copy(HealthCheckResult r1, TaskCost r2) {
            Intrinsics.checkNotNullParameter(r1, "result");
            Intrinsics.checkNotNullParameter(r2, "cost");
            return new TaskExecution(r1, r2);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof TaskExecution) == false) goto L10;
            TaskExecution r4 = (TaskExecution) r3;
            if (Intrinsics.areEqual(this.result, r4.result) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.cost, r4.cost) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            HealthCheckResult r0 = this.result;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            TaskCost r4 = this.cost;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "TaskExecution(result=" + this.result + ", cost=" + this.cost + ")";
        }

        public TaskExecution(HealthCheckResult r2, TaskCost r3) {
            Intrinsics.checkNotNullParameter(r2, "result");
            Intrinsics.checkNotNullParameter(r3, "cost");
            this.result = r2;
            this.cost = r3;
        }

        public final HealthCheckResult getResult() {
            return this.result;
        }

        public final TaskCost getCost() {
            return this.cost;
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[HealthTaskStage.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[HealthTaskStage.CHECK.ordinal()] = 1;
            r0[HealthTaskStage.OPTIMIZE.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.engine.HealthTaskManager$delayOptimizeFinishIfNeeded$1, reason: invalid class name */
    /* JADX INFO: compiled from: HealthTaskManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0082@"}, d2 = {"delayOptimizeFinishIfNeeded", "", "task", "Lcom/obric/security/health/score/task/HealthCheckTask;", "stage", "Lcom/obric/security/health/engine/HealthTaskStage;", "taskStartAt", "", "continuation", "Lkotlin/coroutines/Continuation;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.engine.HealthTaskManager", f = "HealthTaskManager.kt", i = {0}, l = {284}, m = "delayOptimizeFinishIfNeeded", n = {"delayMs"}, s = {"J$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ HealthTaskManager this$0;

        AnonymousClass1(HealthTaskManager r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return HealthTaskManager.access$delayOptimizeFinishIfNeeded(this.this$0, null, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.engine.HealthTaskManager$execute$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HealthTaskManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00030\nH\u0082@"}, d2 = {"execute", "", "itemIds", "", "", "stage", "Lcom/obric/security/health/engine/HealthTaskStage;", "runtimeContext", "Landroid/content/Context;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/security/health/model/HealthCheckResult;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.engine.HealthTaskManager", f = "HealthTaskManager.kt", i = {0, 0, 0, 1, 1, 1, 1, 1}, l = {109, 129}, m = "execute", n = {"this", "stage", "executeStartAt", "stage", ApkVirusCheckProvider.KEY_RESULTS, "executeStartAt", "taskExecutionCostMs", "callbackStartAt"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "J$1", "J$2"})
    static final class C03681 extends ContinuationImpl {
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ HealthTaskManager this$0;

        C03681(HealthTaskManager r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return HealthTaskManager.access$execute(this.this$0, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.engine.HealthTaskManager$execute$3, reason: invalid class name */
    /* JADX INFO: compiled from: HealthTaskManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.engine.HealthTaskManager$execute$3", f = "HealthTaskManager.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef $results;
        final /* synthetic */ HealthTaskStage $stage;
        int label;
        final /* synthetic */ HealthTaskManager this$0;

        AnonymousClass3(HealthTaskManager r1, HealthTaskStage r2, Ref.ObjectRef r3, Continuation r4) {
            this.this$0 = r1;
            this.$stage = r2;
            this.$results = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Intrinsics.checkNotNullParameter(r4, "completion");
            return new AnonymousClass3(this.this$0, this.$stage, this.$results, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass3) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            HealthTaskListener r6 = HealthTaskManager.access$getListener$p(this.this$0);
            if (r6 == null) goto L14;
            HealthTaskStage r2 = this.$stage;
            List<HealthCheckResult> r3 = (List) this.$results.element;
            this.label = 1;
            if (r6.onAllFinish(r2, r3, this) != r0) goto L16;
            return r0;
        L14:
            return null;
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.engine.HealthTaskManager$executeOne$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HealthTaskManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0082@"}, d2 = {"executeOne", "", "itemId", "", "stage", "Lcom/obric/security/health/engine/HealthTaskStage;", "runtimeContext", "Landroid/content/Context;", "notifyListener", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/security/health/model/HealthCheckResult;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.engine.HealthTaskManager", f = "HealthTaskManager.kt", i = {}, l = {152}, m = "executeOne", n = {}, s = {})
    static final class C03691 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ HealthTaskManager this$0;

        C03691(HealthTaskManager r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return HealthTaskManager.access$executeOne(this.this$0, null, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.engine.HealthTaskManager$executeTask$2, reason: invalid class name */
    /* JADX INFO: compiled from: HealthTaskManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lcom/obric/security/health/engine/HealthTaskManager$TaskExecution;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.engine.HealthTaskManager$executeTask$2", f = "HealthTaskManager.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4}, l = {180, 196, 197, 212, 229}, m = "invokeSuspend", n = {"$this$withContext", "taskScore", "taskScore", "taskStartAt", "taskScore", "taskStartAt", "rawResult", "result", "taskScore", "taskStartAt", "executeCostMs", "result", "taskScore", "executeCostMs", "displayDelayMs", "totalCostMs", "resultScore", "scoreApplied"}, s = {"L$0", "I$0", "I$0", "J$0", "I$0", "J$0", "L$0", "L$1", "I$0", "J$0", "J$1", "L$0", "I$0", "J$0", "J$1", "J$2", "I$1", "Z$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TaskExecution>, Object> {
        final /* synthetic */ boolean $notifyListener;
        final /* synthetic */ Context $runtimeContext;
        final /* synthetic */ HealthTaskStage $stage;
        final /* synthetic */ HealthCheckTask $task;
        int I$0;
        int I$1;
        long J$0;
        long J$1;
        long J$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        final /* synthetic */ HealthTaskManager this$0;

        /* JADX INFO: renamed from: com.obric.security.health.engine.HealthTaskManager$executeTask$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: HealthTaskManager.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @DebugMetadata(c = "com.obric.security.health.engine.HealthTaskManager$executeTask$2$1", f = "HealthTaskManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
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
            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L10;
                ResultKt.throwOnFailure(r2);
                HealthTaskListener r3 = HealthTaskManager.access$getListener$p(this.this$0.this$0);
                if (r3 == null) goto L7;
                r3.onTaskStart(this.this$0.$task.getId(), this.this$0.$stage);
                return Unit.INSTANCE;
            L7:
                return null;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.security.health.engine.HealthTaskManager$executeTask$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: HealthTaskManager.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @DebugMetadata(c = "com.obric.security.health.engine.HealthTaskManager$executeTask$2$2", f = "HealthTaskManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00582 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef $result;
            int label;
            final /* synthetic */ AnonymousClass2 this$0;

            C00582(AnonymousClass2 r1, Ref.ObjectRef r2, Continuation r3) {
                this.this$0 = r1;
                this.$result = r2;
                super(2, r3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Intrinsics.checkNotNullParameter(r3, "completion");
                return new C00582(this.this$0, this.$result, r3);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((C00582) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L10;
                ResultKt.throwOnFailure(r3);
                HealthTaskListener r4 = HealthTaskManager.access$getListener$p(this.this$0.this$0);
                if (r4 == null) goto L7;
                r4.onTaskFinish(this.this$0.$task.getId(), this.this$0.$stage, (HealthCheckResult) this.$result.element);
                return Unit.INSTANCE;
            L7:
                return null;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass2(HealthTaskManager r1, HealthCheckTask r2, boolean r3, HealthTaskStage r4, Context r5, Continuation r6) {
            this.this$0 = r1;
            this.$task = r2;
            this.$notifyListener = r3;
            this.$stage = r4;
            this.$runtimeContext = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            Intrinsics.checkNotNullParameter(r10, "completion");
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, this.$task, this.$notifyListener, this.$stage, this.$runtimeContext, r10);
            r0.L$0 = r9;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super TaskExecution> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v1, types: [long] */
        /* JADX WARN: Type inference failed for: r1v2, types: [T, com.obric.security.health.model.HealthCheckResult] */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4, types: [long] */
        /* JADX WARN: Type inference failed for: r2v5, types: [long] */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v15 */
        /* JADX WARN: Type inference failed for: r4v2 */
        /* JADX WARN: Type inference failed for: r4v20 */
        /* JADX WARN: Type inference failed for: r4v28 */
        /* JADX WARN: Type inference failed for: r4v29 */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v30 */
        /* JADX WARN: Type inference failed for: r4v31 */
        /* JADX WARN: Type inference failed for: r4v6, types: [long] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r32) {
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            ?? r4 = 3;
            int r6 = 1;
            if (r0 == 0) goto L22;
            if (r0 == 1) goto L21;
            if (r0 == 2) goto L16;
            if (r0 == 3) goto L13;
            if (r0 == 4) goto L12;
            if (r0 != 5) goto L11;
            boolean r1 = this.Z$0;
            int r2 = this.I$1;
            long r3 = this.J$2;
            long r5 = this.J$1;
            long r9 = this.J$0;
            int r7 = this.I$0;
            Ref.ObjectRef r10 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(r32);
            long r11 = r3;
        L73:
            long r14 = r11;
            long r12 = r5;
            long r29 = r9;
            boolean r13 = r1;
            int r15 = r2;
            Ref.ObjectRef r16 = r10;
            long r17 = r29;
        L76:
            return new TaskExecution((HealthCheckResult) r16.element, new TaskCost(this.$task.getId(), this.$task.getModuleId(), this.$stage, ((HealthCheckResult) r16.element).getStatus(), r7, r15, r13, r17, r12, r14));
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            long r18 = this.J$1;
            long r19 = this.J$0;
            int r20 = this.I$0;
            Ref.ObjectRef r21 = (Ref.ObjectRef) this.L$1;
            HealthCheckResult r22 = (HealthCheckResult) this.L$0;
            ResultKt.throwOnFailure(r32);
            HealthCheckResult r110 = r22;
            r7 = r20;
            Object r23 = r32;
            r16 = r21;
            long r24 = r18;
            ?? r25 = r19;
        L67:
            long r111 = ((Number) r23).longValue();
            ?? r26 = SystemClock.elapsedRealtime() - r25;
            r2 = HealthTaskManager.access$resultScoreOf(this.this$0, (HealthCheckResult) r16.element, r7);
            r13 = HealthTaskManager.access$isScoreApplied(this.this$0, this.$stage, this.$task);
            HealthTaskManager.access$logTaskResult(this.this$0, this.$task, r7, this.$stage, r110, (HealthCheckResult) r16.element, r2, r13, r24, r111, r26);
            if (this.$notifyListener == false) goto L74;
            MainCoroutineDispatcher r112 = Dispatchers.getMain();
            C00582 r113 = new C00582(this, r16, null);
            this.L$0 = r16;
            this.L$1 = null;
            this.I$0 = r7;
            this.J$0 = r24;
            this.J$1 = r111;
            this.J$2 = r26;
            this.I$1 = r2;
            this.Z$0 = r13;
            this.label = 5;
            if (BuildersKt.withContext(r112, r113, this) != r8) goto L72;
            return r8;
        L72:
            r10 = r16;
            r1 = r13;
            r9 = r24;
            r5 = r111;
            r11 = r26;
            goto L73
        L74:
            r12 = r111;
            r15 = r2;
            r14 = r26;
            r17 = r24;
            goto L76
        L13:
            long r27 = this.J$0;
            r6 = this.I$0;
            ResultKt.throwOnFailure(r32);     // Catch: Throwable -> L19
            Object r28 = r32;
            long r30 = r27;
        L43:
            HealthCheckResult r31 = (HealthCheckResult) r28;     // Catch: Throwable -> L19
            r4 = r30;
        L52:
            Object r33 = Result.m774constructorimpl(r31);     // Catch: Throwable -> L19
            ?? r34 = r4;
        L57:
            ?? r114 = r34;
            int r115 = r6;
            Throwable r35 = Result.m777exceptionOrNullimpl(r33);
            if (r35 != null) goto L61;
        L63:
            HealthCheckResult r36 = (HealthCheckResult) r33;
            Ref.ObjectRef r116 = new Ref.ObjectRef();
            r116.element = HealthTaskManager.access$normalizeResult(this.this$0, this.$task, this.$stage, r36);
            ?? r37 = SystemClock.elapsedRealtime() - r114;
            HealthTaskManager r38 = this.this$0;
            HealthCheckTask r39 = this.$task;
            HealthTaskStage r40 = this.$stage;
            this.L$0 = r36;
            this.L$1 = r116;
            this.I$0 = r115;
            this.J$0 = r114;
            this.J$1 = r37;
            this.label = 4;
            r23 = HealthTaskManager.access$delayOptimizeFinishIfNeeded(r38, r39, r40, r114, this);
            if (r23 != r8) goto L66;
            return r8;
        L66:
            r25 = r114;
            r7 = r115;
            r24 = r37;
            r110 = r36;
            r16 = r116;
            goto L67
        L61:
            if ((r35 instanceof CancellationException) == true) goto L77;
            HealthScoreLog r41 = HealthScoreLog.INSTANCE;
            HealthTaskManager.access$Companion();
            r41.e(HealthTaskManager.SOURCE, "taskExecutionFailed stage=" + this.$stage + " itemId=" + this.$task.getId(), r35);
            r33 = new HealthCheckResult(this.$task.getId(), HealthCheckStatus.ERROR, r35.getMessage(), null, 8, null);
            goto L63
        L77:
            throw r35;
        L16:
            long r42 = this.J$0;
            r6 = this.I$0;
            ResultKt.throwOnFailure(r32);     // Catch: Throwable -> L19
            Object r43 = r32;
            long r44 = r42;
        L51:
            r31 = (HealthCheckResult) r43;     // Catch: Throwable -> L19
            r4 = r44;
            goto L52
        L21:
            int r45 = this.I$0;
            CoroutineScope r117 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r32);
        L28:
            int r118 = r45;
        L29:
            long r119 = SystemClock.elapsedRealtime();
            HealthScoreLog r46 = HealthScoreLog.INSTANCE;
            HealthTaskManager.access$Companion();
            r46.d(HealthTaskManager.SOURCE, "taskStart stage=" + this.$stage + " itemId=" + this.$task.getId() + " moduleId=" + this.$task.getModuleId() + " taskScore=" + r118);
            if (this.$stage != HealthTaskStage.OPTIMIZE) goto L34;
            Context r47 = this.$runtimeContext;
            if (r47 != null) goto L78;
            r47 = HealthTaskManager.access$getAppContext$p(this.this$0);
        L78:
            Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L54
            int r121 = WhenMappings.$EnumSwitchMapping$0[this.$stage.ordinal()];     // Catch: Throwable -> L54
            if (r121 == 1) goto L47;
            if (r121 != 2) goto L46;
            HealthCheckTask r48 = this.$task;     // Catch: Throwable -> L54
            Intrinsics.checkNotNullExpressionValue(r47, "executionContext");     // Catch: Throwable -> L54
            this.L$0 = null;     // Catch: Throwable -> L54
            this.I$0 = r118;     // Catch: Throwable -> L54
            this.J$0 = r119;     // Catch: Throwable -> L54
            this.label = 3;     // Catch: Throwable -> L54
            r28 = r48.optimize(r47, r118, this);     // Catch: Throwable -> L54
            if (r28 != r8) goto L42;
            return r8;
        L42:
            r6 = r118;
            r30 = r119;
            goto L43
        L46:
            throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L54
        L47:
            HealthCheckTask r49 = this.$task;     // Catch: Throwable -> L54
            Intrinsics.checkNotNullExpressionValue(r47, "executionContext");     // Catch: Throwable -> L54
            this.L$0 = null;     // Catch: Throwable -> L54
            this.I$0 = r118;     // Catch: Throwable -> L54
            this.J$0 = r119;     // Catch: Throwable -> L54
            this.label = 2;     // Catch: Throwable -> L54
            r43 = r49.check(r47, r118, this);     // Catch: Throwable -> L54
            if (r43 != r8) goto L50;
            return r8;
        L50:
            r6 = r118;
            r44 = r119;
        L54:
            th = th;
            r6 = r118;
            r4 = r119;
        L56:
            Result.Companion r122 = Result.Companion;
            r33 = Result.m774constructorimpl(ResultKt.createFailure(th));
            r34 = r4;
            goto L57
        L34:
            r47 = HealthTaskManager.access$getAppContext$p(this.this$0);
            goto L78
        L22:
            ResultKt.throwOnFailure(r32);
            CoroutineScope r50 = (CoroutineScope) this.L$0;
            r118 = HealthTaskManager.access$getTaskRegistry$p(this.this$0).scoreFor(this.$task);
            if (this.$notifyListener == false) goto L29;
            MainCoroutineDispatcher r123 = Dispatchers.getMain();
            AnonymousClass1 r124 = new AnonymousClass1(this, null);
            this.L$0 = r50;
            this.I$0 = r118;
            this.label = 1;
            if (BuildersKt.withContext(r123, r124, this) != r8) goto L27;
            return r8;
        L27:
            r45 = r118;
        L19:
            th = th;
            goto L56
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ Companion access$Companion() {
        return Companion;
    }

    public HealthTaskManager(Context r2, HealthCheckTaskRegistry r3, HealthTaskListener r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "taskRegistry");
        this.taskRegistry = r3;
        this.listener = r4;
        this.appContext = r2.getApplicationContext();
    }

    public static final /* synthetic */ Object access$delayOptimizeFinishIfNeeded(HealthTaskManager r0, HealthCheckTask r1, HealthTaskStage r2, long r3, Continuation r5) {
        return r0.delayOptimizeFinishIfNeeded(r1, r2, r3, r5);
    }

    public static final /* synthetic */ Object access$execute(HealthTaskManager r0, List r1, HealthTaskStage r2, Context r3, Continuation r4) {
        return r0.execute(r1, r2, r3, r4);
    }

    public static final /* synthetic */ Object access$executeOne(HealthTaskManager r0, String r1, HealthTaskStage r2, Context r3, boolean r4, Continuation r5) {
        return r0.executeOne(r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ Object access$executeOneWithProfile(HealthTaskManager r0, String r1, HealthTaskStage r2, Context r3, boolean r4, Continuation r5) {
        return r0.executeOneWithProfile(r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ Context access$getAppContext$p(HealthTaskManager r0) {
        return r0.appContext;
    }

    public static final /* synthetic */ HealthTaskListener access$getListener$p(HealthTaskManager r0) {
        return r0.listener;
    }

    public static final /* synthetic */ HealthCheckTaskRegistry access$getTaskRegistry$p(HealthTaskManager r0) {
        return r0.taskRegistry;
    }

    public static final /* synthetic */ boolean access$isScoreApplied(HealthTaskManager r0, HealthTaskStage r1, HealthCheckTask r2) {
        return r0.isScoreApplied(r1, r2);
    }

    public static final /* synthetic */ void access$logTaskResult(HealthTaskManager r0, HealthCheckTask r1, int r2, HealthTaskStage r3, HealthCheckResult r4, HealthCheckResult r5, int r6, boolean r7, long r8, long r10, long r12) {
        r0.logTaskResult(r1, r2, r3, r4, r5, r6, r7, r8, r10, r12);
    }

    public static final /* synthetic */ HealthCheckResult access$normalizeResult(HealthTaskManager r0, HealthCheckTask r1, HealthTaskStage r2, HealthCheckResult r3) {
        return r0.normalizeResult(r1, r2, r3);
    }

    public static final /* synthetic */ int access$resultScoreOf(HealthTaskManager r0, HealthCheckResult r1, int r2) {
        return r0.resultScoreOf(r1, r2);
    }

    public /* synthetic */ HealthTaskManager(Context r1, HealthCheckTaskRegistry r2, HealthTaskListener r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
        HealthTaskListener r6 = (HealthTaskListener) null;
    L5:
        this(r1, r2, r3);
    }

    public final Object scan(List<String> r8, Continuation<? super List<HealthCheckResult>> r9) {
        return execute$default(this, r8, HealthTaskStage.CHECK, null, r9, 4, null);
    }

    public static /* synthetic */ Object optimize$default(HealthTaskManager r0, List r1, Context r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
        Context r6 = (Context) null;
    L6:
        return r0.optimize(r1, r2, r3);
    }

    public final Object optimize(List<String> r2, Context r3, Continuation<? super List<HealthCheckResult>> r4) {
        return execute(r2, HealthTaskStage.OPTIMIZE, r3, r4);
    }

    public final Object checkOne(String r7, Continuation<? super HealthCheckResult> r8) {
        return executeOne(r7, HealthTaskStage.CHECK, null, false, r8);
    }

    public static /* synthetic */ Object optimizeOne$default(HealthTaskManager r0, String r1, Context r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
        Context r6 = (Context) null;
    L6:
        return r0.optimizeOne(r1, r2, r3);
    }

    public final Object optimizeOne(String r7, Context r8, Continuation<? super HealthCheckResult> r9) {
        return executeOne(r7, HealthTaskStage.OPTIMIZE, r8, false, r9);
    }

    /* JADX WARN: Type inference failed for: r13v3, types: [T, java.util.List] */
    private final Object execute(List<String> r18, HealthTaskStage r19, Context r20, Continuation<? super List<HealthCheckResult>> r21) {
        if ((r21 instanceof C03681) == false) goto L7;
        C03681 r1 = (C03681) r21;
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        C03681 r8 = r1;
        Object r0 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r8.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        long r3 = r8.J$2;
        long r4 = r8.J$1;
        long r5 = r8.J$0;
        Ref.ObjectRef r7 = (Ref.ObjectRef) r8.L$1;
        HealthTaskStage r10 = (HealthTaskStage) r8.L$0;
        ResultKt.throwOnFailure(r0);
    L32:
        HealthScoreLog.INSTANCE.i(SOURCE, "executeFinish stage=" + r10 + " count=" + ((List) r7.element).size() + " taskExecutionCostMs=" + r4 + " callbackCostMs=" + (SystemClock.elapsedRealtime() - r3) + " totalCostMs=" + (SystemClock.elapsedRealtime() - r5));
        return (List) r7.element;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r6 = r8.J$0;
        HealthTaskStage r11 = (HealthTaskStage) r8.L$1;
        HealthTaskManager r12 = (HealthTaskManager) r8.L$0;
        ResultKt.throwOnFailure(r0);
        r5 = r6;
    L20:
        long r13 = SystemClock.elapsedRealtime() - r5;
        r7 = new Ref.ObjectRef();
        List r14 = (List) r0;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r16 = r14.iterator();
    L22:
        if (r16.hasNext() == false) goto L24;
        r15.add(((TaskExecution) r16.next()).getResult());
        goto L22
    L24:
        r7.element = r15;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r22 = r14.iterator();
    L26:
        if (r22.hasNext() == false) goto L28;
        r17.add(((TaskExecution) r22.next()).getCost());
        goto L26
    L28:
        r12.logExecuteSummary(r11, r17, r13);
        long r110 = SystemClock.elapsedRealtime();
        MainCoroutineDispatcher r23 = Dispatchers.getMain();
        AnonymousClass3 r111 = new AnonymousClass3(r12, r11, r7, null);
        r8.L$0 = r11;
        r8.L$1 = r7;
        r8.J$0 = r5;
        r8.J$1 = r13;
        r8.J$2 = r110;
        r8.label = 2;
        if (BuildersKt.withContext(r23, r111, r8) != r9) goto L31;
        return r9;
    L31:
        r10 = r11;
        r4 = r13;
        r3 = r110;
        goto L32
    L16:
        ResultKt.throwOnFailure(r0);
        long r112 = SystemClock.elapsedRealtime();
        HealthScoreLog.INSTANCE.i(SOURCE, "executeStart stage=" + r19 + " count=" + r18.size() + " itemIds=" + r18);
        HealthTaskManager$execute$executions$1 r24 = new HealthTaskManager$execute$executions$1(this, r18, r19, r20, null);
        r8.L$0 = this;
        r8.L$1 = r19;
        r8.J$0 = r112;
        r8.label = 1;
        r0 = CoroutineScopeKt.coroutineScope(r24, r8);
        if (r0 != r9) goto L19;
        return r9;
    L19:
        r12 = this;
        r11 = r19;
        r5 = r112;
    L7:
        r1 = new C03681(this, r21);
        goto L8
    }

    static /* synthetic */ Object execute$default(HealthTaskManager r0, List r1, HealthTaskStage r2, Context r3, Continuation r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = null;
        Context r7 = (Context) null;
    L6:
        return r0.execute(r1, r2, r3, r4);
    }

    private final Object executeOne(String r8, HealthTaskStage r9, Context r10, boolean r11, Continuation<? super HealthCheckResult> r12) {
        if ((r12 instanceof C03691) == false) goto L7;
        C03691 r0 = (C03691) r12;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        C03691 r6 = r0;
        Object r13 = r6.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r6.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L18:
        return ((TaskExecution) r13).getResult();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r6.label = 1;
        r13 = executeOneWithProfile(r8, r9, r10, r11, r6);
        if (r13 != r1) goto L18;
        return r1;
    L7:
        r0 = new C03691(this, r12);
        goto L8
    }

    private final Object executeOneWithProfile(String r8, HealthTaskStage r9, Context r10, boolean r11, Continuation<? super TaskExecution> r12) {
        return executeTask(this.taskRegistry.taskFor(r8), r9, r10, r11, r12);
    }

    private final Object executeTask(HealthCheckTask r10, HealthTaskStage r11, Context r12, boolean r13, Continuation<? super TaskExecution> r14) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(this, r10, r13, r11, r12, null), r14);
    }

    private final HealthCheckResult normalizeResult(HealthCheckTask r17, HealthTaskStage r18, HealthCheckResult r19) {
        if (r18 == HealthTaskStage.CHECK) goto L5;
    L16:
        return r19;
    L5:
        if (r19.getStatus() != HealthCheckStatus.ERROR) goto L16;
        HealthScoreLog r2 = HealthScoreLog.INSTANCE;
        StringBuilder r0 = new StringBuilder("checkErrorFallbackPass itemId=").append(r17.getId()).append(" moduleId=").append(r17.getModuleId()).append(" reason=");
        String r1 = r19.getReason();
        String r8 = "";
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        HealthScoreLog.w$default(r2, SOURCE, r0.append(r1).toString(), null, 4, null);
        HealthCheckStatus r11 = HealthCheckStatus.PASS;
        Map<String, String> r3 = r19.getEvidence();
        Pair[] r4 = new Pair[3];
        r4[0] = TuplesKt.to(HealthEvidenceKeys.ORIGINAL_STATUS, HealthCheckStatus.ERROR.name());
        String r5 = r19.getReason();
        if (r5 == null) goto L14;
        r8 = r5;
    L14:
        r4[1] = TuplesKt.to(HealthEvidenceKeys.ORIGINAL_REASON, r8);
        r4[2] = TuplesKt.to(HealthEvidenceKeys.ERROR_FALLBACK_PASS, Constants.IS_SET);
        return HealthCheckResult.copy$default(r19, null, r11, null, MapsKt.plus(r3, MapsKt.mapOf(r4)), 5, null);
    }

    private final Object delayOptimizeFinishIfNeeded(HealthCheckTask r6, HealthTaskStage r7, long r8, Continuation<? super Long> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r10;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r0.label;
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L13;
        long r9 = r0.J$0;
        ResultKt.throwOnFailure(r5);
    L25:
        return Boxing.boxLong(r9);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r5);
        if (r7 != HealthTaskStage.OPTIMIZE) goto L29;
        if (r6.getFixCapability() == HealthFixCapability.NAVIGATE) goto L29;
        r9 = 1000 - (SystemClock.elapsedRealtime() - r8);
        if (r9 <= 0) goto L27;
        r0.J$0 = r9;
        r0.label = 1;
        if (DelayKt.delay(r9, r0) != r11) goto L25;
        return r11;
    L27:
        return Boxing.boxLong(0);
    L29:
        return Boxing.boxLong(0);
    L7:
        r0 = new AnonymousClass1(this, r10);
        goto L8
    }

    private final int resultScoreOf(HealthCheckResult r2, int r3) {
        String r1 = r2.getEvidence().get(HealthEvidenceKeys.EARNED_SCORE);
        if (r1 == null) goto L8;
        Integer r4 = StringsKt.toIntOrNull(r1);
        if (r4 == null) goto L8;
        return RangesKt.coerceIn(r4.intValue(), 0, r3);
    L8:
        if (r2.getStatus() != HealthCheckStatus.PASS) goto L11;
        return r3;
    L11:
        return 0;
    }

    private final boolean isScoreApplied(HealthTaskStage r1, HealthCheckTask r2) {
        if (r1 != HealthTaskStage.CHECK) goto L5;
    L8:
        return true;
    L5:
        if (r2.getFixCapability() == HealthFixCapability.AUTO) goto L8;
        return false;
    }

    private final void logTaskResult(HealthCheckTask r3, int r4, HealthTaskStage r5, HealthCheckResult r6, HealthCheckResult r7, int r8, boolean r9, long r10, long r12, long r14) {
        HealthScoreLog r2 = HealthScoreLog.INSTANCE;
        StringBuilder r11 = new StringBuilder("taskFinish stage=").append(r5).append(" itemId=").append(r3.getId()).append(" moduleId=").append(r3.getModuleId()).append(" rawStatus=").append(r6.getStatus()).append(" status=").append(r7.getStatus()).append(" taskScore=").append(r4).append(" resultScore=").append(r8).append(" scoreApplied=").append(r9).append(" executeCostMs=").append(r10).append(" displayDelayMs=").append(r12).append(" totalCostMs=").append(r14).append(" rawReason=");
        String r13 = r6.getReason();
        String r15 = "";
        if (r13 != null) goto L5;
        r13 = "";
    L5:
        StringBuilder r16 = r11.append(r13).append(" reason=");
        String r17 = r7.getReason();
        if (r17 == null) goto L9;
        r15 = r17;
    L9:
        r2.d(SOURCE, r16.append(r15).append(" evidence=").append(r7.getEvidence()).toString());
    }

    private final void logExecuteSummary(HealthTaskStage r12, List<TaskCost> r13, long r14) {
        List<TaskCost> r0 = r13;
        Iterator<T> r11 = r0.iterator();
        String r9 = null;
        if (r11.hasNext() == true) goto L5;
        Object r1 = null;
    L14:
        TaskCost r10 = (TaskCost) r1;
        Iterator<T> r4 = r0.iterator();
        if (r4.hasNext() == true) goto L17;
        Object r15 = null;
    L26:
        TaskCost r16 = (TaskCost) r15;
        String r2 = CollectionsKt.joinToString$default(r0, null, "[", "]", 0, null, HealthTaskManager$logExecuteSummary$taskCosts$1.INSTANCE, 25, null);
        HealthScoreLog r3 = HealthScoreLog.INSTANCE;
        StringBuilder r17 = new StringBuilder("executeCostSummary stage=").append(r12).append(" count=").append(r13.size()).append(" taskExecutionCostMs=").append(r14).append(" slowestExecute=");
        if (r10 == null) goto L29;
        String r18 = r10.compact();
    L30:
        String r19 = "";
        if (r18 != null) goto L33;
        r18 = "";
    L33:
        StringBuilder r110 = r17.append(r18).append(" slowestTotal=");
        if (r16 == null) goto L36;
        r9 = r16.compact();
    L36:
        if (r9 == null) goto L39;
        r19 = r9;
    L39:
        r3.i(SOURCE, r110.append(r19).append(" taskCosts=").append(r2).toString());
        return;
    L29:
        r18 = null;
        goto L30
    L17:
        r15 = r4.next();
        if (r4.hasNext() == false) goto L26;
        long r5 = ((TaskCost) r15).getTotalCostMs();
    L21:
        Object r6 = r4.next();
        long r7 = ((TaskCost) r6).getTotalCostMs();
        if (r5 >= r7) goto L25;
        r15 = r6;
        r5 = r7;
    L25:
        if (r4.hasNext() == true) goto L21;
    L5:
        r1 = r11.next();
        if (r11.hasNext() == false) goto L14;
        long r8 = ((TaskCost) r1).getExecuteCostMs();
    L9:
        Object r20 = r11.next();
        long r21 = ((TaskCost) r20).getExecuteCostMs();
        if (r8 >= r21) goto L13;
        r1 = r20;
        r8 = r21;
    L13:
        if (r11.hasNext() == true) goto L9;
        goto L14
    }
}
