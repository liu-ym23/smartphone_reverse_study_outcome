package com.obric.security.service.health;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.monitor.util.ActivityThreadUtils;
import com.bytedanceos.utils.Constants;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.security.health.engine.HealthTaskListener;
import com.obric.security.health.engine.HealthTaskManager;
import com.obric.security.health.engine.HealthTaskStage;
import com.obric.security.health.model.HealthCheckItemPresentation;
import com.obric.security.health.model.HealthCheckItemSnapshot;
import com.obric.security.health.model.HealthCheckResult;
import com.obric.security.health.model.HealthCheckStatus;
import com.obric.security.health.model.HealthModulePresentation;
import com.obric.security.health.model.HealthModuleSnapshot;
import com.obric.security.health.model.HealthScoreSnapshot;
import com.obric.security.health.score.HealthEvidenceKeys;
import com.obric.security.health.score.HealthScoreCalculator;
import com.obric.security.health.score.HealthScoreLog;
import com.obric.security.health.score.HealthTaskIds;
import com.obric.security.health.score.task.HealthCheckTaskRegistry;
import com.obric.security.health.score.task.HealthTaskPresentations;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: HealthOptimizeManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u0000 b2\u00020\u00012\u00020\u0002:\u0003bcdB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010!\u001a\u00020\r2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020$0#H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J3\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020(0,2\b\u0010-\u001a\u0004\u0018\u00010\u00042\b\u0010.\u001a\u0004\u0018\u00010\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020&H\u0002J\b\u00102\u001a\u00020\rH\u0002J\"\u00103\u001a\u00020*2\u0006\u00104\u001a\u0002052\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u00106\u001a\u00020&H\u0002J\n\u00107\u001a\u0004\u0018\u00010\rH\u0016J\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\u000fH\u0016J\u000e\u0010;\u001a\b\u0012\u0004\u0012\u00020<0,H\u0016J\u0014\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020$0#H\u0002J\u001e\u0010>\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020$0,H\u0002J\u001e\u0010@\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020$0,H\u0002J'\u0010A\u001a\u00020*2\u0006\u00104\u001a\u0002052\f\u0010?\u001a\b\u0012\u0004\u0012\u00020$0,H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010BJ\b\u0010C\u001a\u00020*H\u0016J\b\u0010D\u001a\u00020*H\u0016J \u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020\u00122\u0006\u00104\u001a\u0002052\u0006\u0010G\u001a\u00020$H\u0016J\u0018\u0010H\u001a\u00020*2\u0006\u0010F\u001a\u00020\u00122\u0006\u00104\u001a\u000205H\u0016J)\u0010I\u001a\u00020*2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020(0,2\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010KJ\b\u0010L\u001a\u00020*H\u0016J\u0016\u0010M\u001a\b\u0012\u0004\u0012\u00020(0,2\u0006\u0010N\u001a\u00020\u0019H\u0002J\u0016\u0010O\u001a\b\u0012\u0004\u0012\u00020(0,2\u0006\u0010P\u001a\u00020\rH\u0002J\u000e\u0010Q\u001a\b\u0012\u0004\u0012\u00020(0,H\u0002J\u0016\u0010R\u001a\b\u0012\u0004\u0012\u00020(0,2\u0006\u0010P\u001a\u00020\rH\u0002J\b\u0010S\u001a\u00020*H\u0002J\b\u0010T\u001a\u00020*H\u0016J\u001e\u0010U\u001a\u00020V2\u0006\u00104\u001a\u0002052\f\u0010?\u001a\b\u0012\u0004\u0012\u00020$0,H\u0002J\u0012\u0010W\u001a\u00020*2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010X\u001a\u00020*2\u0006\u0010N\u001a\u00020\u00192\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010Y\u001a\u00020*2\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010[\u001a\u00020*2\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016J\b\u0010\\\u001a\u00020*H\u0016J\b\u0010]\u001a\u00020*H\u0002J\b\u0010^\u001a\u00020*H\u0016J\u0016\u0010_\u001a\u00020*2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020$0,H\u0002J\f\u0010`\u001a\u00020\u0012*\u00020(H\u0002J\u0018\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020$0#*\u00020\rH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006e"}, d2 = {"Lcom/obric/security/service/health/HealthOptimizeManager;", "Lcom/obric/security/service/health/IHealthOptimizeManager;", "Lcom/obric/security/health/engine/HealthTaskListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "activeJob", "Lkotlinx/coroutines/Job;", "appContext", "kotlin.jvm.PlatformType", "callback", "Lcom/obric/security/service/health/IHealthOptimizeManager$Callback;", "lastSnapshot", "Lcom/obric/security/health/model/HealthScoreSnapshot;", "lastTrashTotalSize", "", "pendingOptimizeItemIds", "", "", "pendingScanItemIds", "presentationIndex", "Lcom/obric/security/health/score/task/HealthTaskPresentations;", "progressCounter", "Lcom/obric/security/service/health/HealthOptimizeManager$TaskProgressCounter;", "runningAction", "Lcom/obric/security/service/health/HealthOptimizeManager$HealthOptimizeAction;", "runningActionStartedAt", "scope", "Lkotlinx/coroutines/CoroutineScope;", "taskManager", "Lcom/obric/security/health/engine/HealthTaskManager;", "taskRegistry", "Lcom/obric/security/health/score/task/HealthCheckTaskRegistry;", "calculateSnapshot", "checkResults", "", "Lcom/obric/security/health/model/HealthCheckResult;", "canOptimizeItem", "", "presentation", "Lcom/obric/security/health/model/HealthCheckItemPresentation;", "checkAndAutoOptimize", "", "actionPresentations", "", "runtimeContext", "baseSnapshot", "(Ljava/util/List;Landroid/content/Context;Lcom/obric/security/health/model/HealthScoreSnapshot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completeRunningAction", "clearPendingOptimize", "defaultSnapshot", "dispatchProgress", "stage", "Lcom/obric/security/health/engine/HealthTaskStage;", "taskPassed", "getHealthSnapshot", "getScoreSnapshot", "Landroid/os/Bundle;", "getTrashTotalSize", "getVisibleModulePresentations", "Lcom/obric/security/health/model/HealthModulePresentation;", "grantedHiddenResultMap", "mergeCheckResults", ApkVirusCheckProvider.KEY_RESULTS, "mergeOptimizeResults", "onAllFinish", "(Lcom/obric/security/health/engine/HealthTaskStage;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreate", "onDestroy", "onTaskFinish", "itemId", "result", "onTaskStart", "optimizeSelectedItems", "selectedPresentations", "(Ljava/util/List;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pause", "presentationsForAction", "action", "presentationsForOptimize", "snapshot", "presentationsForScan", "presentationsForSelectedOptimize", "resetRunningAction", "resume", "scoreAppliedResultCount", "", "setCallback", "startAction", "startOptimize", "itemIds", "startScan", "stopOptimize", "stopRunningAction", "stopScan", "updateTrashTotalSize", "displayOptimizeTitle", "toResultMap", "Companion", "HealthOptimizeAction", "TaskProgressCounter", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthOptimizeManager implements IHealthOptimizeManager, HealthTaskListener {
    private static final Companion Companion = null;

    @Deprecated
    private static final String SOURCE = "HealthOptimizeManager";
    private Job activeJob;
    private final Context appContext;
    private IHealthOptimizeManager.Callback callback;
    private HealthScoreSnapshot lastSnapshot;
    private long lastTrashTotalSize;
    private Set<String> pendingOptimizeItemIds;
    private Set<String> pendingScanItemIds;
    private HealthTaskPresentations presentationIndex;
    private final TaskProgressCounter progressCounter;
    private HealthOptimizeAction runningAction;
    private long runningActionStartedAt;
    private final CoroutineScope scope;
    private HealthTaskManager taskManager;
    private HealthCheckTaskRegistry taskRegistry;

    /* JADX INFO: compiled from: HealthOptimizeManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/security/service/health/HealthOptimizeManager$Companion;", "", "()V", "SOURCE", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: HealthOptimizeManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/security/service/health/HealthOptimizeManager$HealthOptimizeAction;", "", "(Ljava/lang/String;I)V", "SCAN", "OPTIMIZE", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final enum HealthOptimizeAction extends Enum<HealthOptimizeAction> {
        private static final /* synthetic */ HealthOptimizeAction[] $VALUES = null;
        public static final HealthOptimizeAction OPTIMIZE = null;
        public static final HealthOptimizeAction SCAN = null;

        static {
            HealthOptimizeAction r1 = new HealthOptimizeAction("SCAN", 0);
            SCAN = r1;
            HealthOptimizeAction r2 = new HealthOptimizeAction("OPTIMIZE", 1);
            OPTIMIZE = r2;
            $VALUES = new HealthOptimizeAction[]{r1, r2};
        }

        public static HealthOptimizeAction valueOf(String r1) {
            return (HealthOptimizeAction) Enum.valueOf(HealthOptimizeAction.class, r1);
        }

        public static HealthOptimizeAction[] values() {
            return (HealthOptimizeAction[]) $VALUES.clone();
        }

        private HealthOptimizeAction(String r1, int r2) {
            super(r1, r2);
        }
    }

    /* JADX INFO: compiled from: HealthOptimizeManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0004J\u001a\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/security/service/health/HealthOptimizeManager$TaskProgressCounter;", "", "()V", "finished", "", PerfConsts.PERF_DISK_TOTAL, "increment", "", "percent", "reset", "setFinished", "value", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class TaskProgressCounter {
        private int finished;
        private int total;

        public TaskProgressCounter() {
        }

        public static /* synthetic */ void reset$default(TaskProgressCounter r1, int r2, int r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = 0;
        L8:
            r1.reset(r2, r3);
        }

        public final void reset(int r1, int r2) {
            this.total = r1;
            this.finished = r2;
        }

        public final void increment() {
            this.finished++;
        }

        public final void setFinished(int r1) {
            this.finished = r1;
        }

        public final int percent() {
            int r0 = this.total;
            if (r0 > 0) goto L6;
            return 100;
        L6:
            return RangesKt.coerceIn((this.finished * 100) / r0, 0, 100);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5 = null;

        static {
            int[] r0 = new int[HealthOptimizeAction.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[HealthOptimizeAction.SCAN.ordinal()] = 1;
            r0[HealthOptimizeAction.OPTIMIZE.ordinal()] = 2;
            int[] r1 = new int[HealthOptimizeAction.values().length];
            $EnumSwitchMapping$1 = r1;
            r1[HealthOptimizeAction.SCAN.ordinal()] = 1;
            r1[HealthOptimizeAction.OPTIMIZE.ordinal()] = 2;
            int[] r2 = new int[HealthOptimizeAction.values().length];
            $EnumSwitchMapping$2 = r2;
            r2[HealthOptimizeAction.SCAN.ordinal()] = 1;
            r2[HealthOptimizeAction.OPTIMIZE.ordinal()] = 2;
            int[] r3 = new int[HealthTaskStage.values().length];
            $EnumSwitchMapping$3 = r3;
            r3[HealthTaskStage.CHECK.ordinal()] = 1;
            r3[HealthTaskStage.OPTIMIZE.ordinal()] = 2;
            int[] r4 = new int[HealthTaskStage.values().length];
            $EnumSwitchMapping$4 = r4;
            r4[HealthTaskStage.CHECK.ordinal()] = 1;
            r4[HealthTaskStage.OPTIMIZE.ordinal()] = 2;
            int[] r5 = new int[HealthTaskStage.values().length];
            $EnumSwitchMapping$5 = r5;
            r5[HealthTaskStage.CHECK.ordinal()] = 1;
            r5[HealthTaskStage.OPTIMIZE.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.obric.security.service.health.HealthOptimizeManager$checkAndAutoOptimize$1, reason: invalid class name */
    /* JADX INFO: compiled from: HealthOptimizeManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0082@"}, d2 = {"checkAndAutoOptimize", "", "actionPresentations", "", "Lcom/obric/security/health/model/HealthCheckItemPresentation;", "runtimeContext", "Landroid/content/Context;", "baseSnapshot", "Lcom/obric/security/health/model/HealthScoreSnapshot;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.service.health.HealthOptimizeManager", f = "HealthOptimizeManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {224, 243}, m = "checkAndAutoOptimize", n = {"this", "actionPresentations", "runtimeContext", "manager", "checkResults", "optimizeFinishedCount", "checkCostMs", "optimizeCostMs", "presentation", "startAt", "checkStartAt", "this", "actionPresentations", "runtimeContext", "manager", "checkResults", "optimizeFinishedCount", "checkCostMs", "optimizeCostMs", "presentation", "startAt", "optimizeStartAt"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "J$0", "J$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ HealthOptimizeManager this$0;

        AnonymousClass1(HealthOptimizeManager r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return HealthOptimizeManager.access$checkAndAutoOptimize(this.this$0, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.security.service.health.HealthOptimizeManager$startAction$2, reason: invalid class name */
    /* JADX INFO: compiled from: HealthOptimizeManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.service.health.HealthOptimizeManager$startAction$2", f = "HealthOptimizeManager.kt", i = {}, l = {564, ActivityThreadUtils.EXECUTE_TRANSACTION, 161}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HealthOptimizeAction $action;
        final /* synthetic */ List $actionPresentations;
        final /* synthetic */ Context $runtimeContext;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ HealthOptimizeManager this$0;

        AnonymousClass2(HealthOptimizeManager r1, HealthOptimizeAction r2, List r3, Context r4, Continuation r5) {
            this.this$0 = r1;
            this.$action = r2;
            this.$actionPresentations = r3;
            this.$runtimeContext = r4;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Intrinsics.checkNotNullParameter(r9, "completion");
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, this.$action, this.$actionPresentations, this.$runtimeContext, r9);
            r0.L$0 = r8;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L14;
            if (r2 == 1) goto L10;
            if (r2 == 2) goto L10;
            if (r2 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L12 CancellationException -> L52
        L46:
            if (HealthOptimizeManager.access$getRunningAction$p(this.this$0) != this.$action) goto L61;
            Job r14 = HealthOptimizeManager.access$getActiveJob$p(this.this$0);
            if (r14 == null) goto L61;
            if (r14.isCancelled() != true) goto L61;
        L51:
            HealthOptimizeManager.access$resetRunningAction(this.this$0);
        L61:
            return Unit.INSTANCE;
        L14:
            ResultKt.throwOnFailure(r13);
            CoroutineScope r15 = (CoroutineScope) this.L$0;
            int r16 = WhenMappings.$EnumSwitchMapping$1[this.$action.ordinal()];     // Catch: Throwable -> L12 CancellationException -> L52
            if (r16 == 1) goto L27;
            if (r16 != 2) goto L46;
            if (HealthOptimizeManager.access$getPendingOptimizeItemIds$p(this.this$0) != null) goto L24;
            HealthOptimizeManager r17 = this.this$0;     // Catch: Throwable -> L12 CancellationException -> L52
            List r0 = this.$actionPresentations;     // Catch: Throwable -> L12 CancellationException -> L52
            Context r3 = this.$runtimeContext;     // Catch: Throwable -> L12 CancellationException -> L52
            this.label = 2;     // Catch: Throwable -> L12 CancellationException -> L52
            if (HealthOptimizeManager.access$checkAndAutoOptimize(r17, r0, r3, null, this) != r1) goto L46;
            return r1;
        L24:
            HealthOptimizeManager r18 = this.this$0;     // Catch: Throwable -> L12 CancellationException -> L52
            List r4 = this.$actionPresentations;     // Catch: Throwable -> L12 CancellationException -> L52
            Context r5 = this.$runtimeContext;     // Catch: Throwable -> L12 CancellationException -> L52
            this.label = 3;     // Catch: Throwable -> L12 CancellationException -> L52
            if (HealthOptimizeManager.access$optimizeSelectedItems(r18, r4, r5, this) != r1) goto L46;
            return r1;
        L27:
            HealthTaskManager r19 = HealthOptimizeManager.access$getTaskManager$p(this.this$0);     // Catch: Throwable -> L12 CancellationException -> L52
            if (r19 != null) goto L38;
            HealthScoreLog r6 = HealthScoreLog.INSTANCE;     // Catch: Throwable -> L12 CancellationException -> L52
            HealthOptimizeManager.access$Companion();     // Catch: Throwable -> L12 CancellationException -> L52
            HealthScoreLog.e$default(r6, HealthOptimizeManager.SOURCE, "abortAction action=" + this.$action + " reason=taskManagerNull", null, 4, null);     // Catch: Throwable -> L12 CancellationException -> L52
            HealthOptimizeManager.access$resetRunningAction(this.this$0);     // Catch: Throwable -> L12 CancellationException -> L52
            Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L12 CancellationException -> L52
            if (HealthOptimizeManager.access$getRunningAction$p(this.this$0) != this.$action) goto L37;
            Job r7 = HealthOptimizeManager.access$getActiveJob$p(this.this$0);
            if (r7 == null) goto L37;
            if (r7.isCancelled() != true) goto L37;
            HealthOptimizeManager.access$resetRunningAction(this.this$0);
        L37:
            return r110;
        L38:
            List r8 = this.$actionPresentations;     // Catch: Throwable -> L12 CancellationException -> L52
            ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));     // Catch: Throwable -> L12 CancellationException -> L52
            Iterator r10 = r8.iterator();     // Catch: Throwable -> L12 CancellationException -> L52
        L40:
            if (r10.hasNext() == false) goto L42;
            r9.add(((HealthCheckItemPresentation) r10.next()).getId());     // Catch: Throwable -> L12 CancellationException -> L52
            goto L40
        L42:
            this.label = 1;     // Catch: Throwable -> L12 CancellationException -> L52
            if (r19.scan(r9, this) != r1) goto L46;
            return r1;
        L12:
            th = move-exception;
            if (HealthOptimizeManager.access$getRunningAction$p(this.this$0) != this.$action) goto L69;
            Job r11 = HealthOptimizeManager.access$getActiveJob$p(this.this$0);
            if (r11 == null) goto L69;
            if (r11.isCancelled() != true) goto L69;
            HealthOptimizeManager.access$resetRunningAction(this.this$0);
        L69:
            throw th;
        L52:
            HealthScoreLog r111 = HealthScoreLog.INSTANCE;     // Catch: Throwable -> L12
            HealthOptimizeManager.access$Companion();     // Catch: Throwable -> L12
            r111.i(HealthOptimizeManager.SOURCE, "actionCancelled action=" + this.$action);     // Catch: Throwable -> L12
            if (HealthOptimizeManager.access$getRunningAction$p(this.this$0) != this.$action) goto L61;
            Job r112 = HealthOptimizeManager.access$getActiveJob$p(this.this$0);
            if (r112 == null) goto L61;
            if (r112.isCancelled() != true) goto L61;
            goto L51
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ Companion access$Companion() {
        return Companion;
    }

    @Override // com.obric.security.service.health.IHealthOptimizeManager
    public void pause() {
    }

    @Override // com.obric.security.service.health.IHealthOptimizeManager
    public void resume() {
    }

    public HealthOptimizeManager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.appContext = r2.getApplicationContext();
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
        this.presentationIndex = HealthTaskPresentations.Companion.getEMPTY();
        this.progressCounter = new TaskProgressCounter();
    }

    public static final /* synthetic */ Object access$checkAndAutoOptimize(HealthOptimizeManager r0, List r1, Context r2, HealthScoreSnapshot r3, Continuation r4) {
        return r0.checkAndAutoOptimize(r1, r2, r3, r4);
    }

    public static final /* synthetic */ Job access$getActiveJob$p(HealthOptimizeManager r0) {
        return r0.activeJob;
    }

    public static final /* synthetic */ Set access$getPendingOptimizeItemIds$p(HealthOptimizeManager r0) {
        return r0.pendingOptimizeItemIds;
    }

    public static final /* synthetic */ HealthOptimizeAction access$getRunningAction$p(HealthOptimizeManager r0) {
        return r0.runningAction;
    }

    public static final /* synthetic */ HealthTaskManager access$getTaskManager$p(HealthOptimizeManager r0) {
        return r0.taskManager;
    }

    public static final /* synthetic */ Object access$optimizeSelectedItems(HealthOptimizeManager r0, List r1, Context r2, Continuation r3) {
        return r0.optimizeSelectedItems(r1, r2, r3);
    }

    public static final /* synthetic */ void access$resetRunningAction(HealthOptimizeManager r0) {
        r0.resetRunningAction();
    }

    public static final /* synthetic */ void access$setActiveJob$p(HealthOptimizeManager r0, Job r1) {
        r0.activeJob = r1;
    }

    public static final /* synthetic */ void access$setPendingOptimizeItemIds$p(HealthOptimizeManager r0, Set r1) {
        r0.pendingOptimizeItemIds = r1;
    }

    public static final /* synthetic */ void access$setRunningAction$p(HealthOptimizeManager r0, HealthOptimizeAction r1) {
        r0.runningAction = r1;
    }

    public static final /* synthetic */ void access$setTaskManager$p(HealthOptimizeManager r0, HealthTaskManager r1) {
        r0.taskManager = r1;
    }

    @Override // com.obric.security.service.health.IHealthOptimizeManager
    public void onCreate() {
        if (this.taskRegistry == null) goto L6;
        HealthScoreLog.INSTANCE.d(SOURCE, "onCreate ignored initialized=true");
        return;
    L6:
        HealthScoreLog.INSTANCE.i(SOURCE, "onCreate");
        HealthCheckTaskRegistry r0 = HealthCheckTaskRegistry.Companion.create();
        Context r1 = this.appContext;
        Intrinsics.checkNotNullExpressionValue(r1, "appContext");
        r0.onCreate(r1);
        this.taskRegistry = r0;
        this.presentationIndex = r0.getPresentations();
        Context r3 = this.appContext;
        Intrinsics.checkNotNullExpressionValue(r3, "appContext");
        this.taskManager = new HealthTaskManager(r3, r0, this);
    }

    @Override // com.obric.security.service.health.IHealthOptimizeManager
    public void onDestroy() {
        HealthScoreLog.INSTANCE.i(SOURCE, "onDestroy runningAction=" + this.runningAction);
        if (this.runningAction == null) goto L5;
        stopRunningAction();
    L5:
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        HealthCheckTaskRegistry r0 = this.taskRegistry;
        if (r0 == null) goto L8;
        Context r1 = this.appContext;
        Intrinsics.checkNotNullExpressionValue(r1, "appContext");
        r0.onDestroy(r1);
    L8:
        HealthCheckTaskRegistry r2 = (HealthCheckTaskRegistry) null;
        this.taskRegistry = null;
        HealthTaskManager r3 = (HealthTaskManager) null;
        this.taskManager = null;
    }

    @Override // com.obric.security.service.health.IHealthOptimizeManager
    public void startScan(Set<String> r5) {
        if (this.runningAction == null) goto L6;
        HealthScoreLog.INSTANCE.d(SOURCE, "ignoreDuplicatedScan itemIds=" + r5 + " runningAction=" + this.runningAction);
        return;
    L6:
        HealthScoreLog.INSTANCE.i(SOURCE, "startScanRequest itemIds=" + r5);
        this.pendingScanItemIds = r5;
        startAction$default(this, HealthOptimizeAction.SCAN, null, 2, null);
    }

    @Override // com.obric.security.service.health.IHealthOptimizeManager
    public void stopScan() {
        stopRunningAction();
    }

    @Override // com.obric.security.service.health.IHealthOptimizeManager
    public void startOptimize(Set<String> r6, Context r7) {
        HealthOptimizeAction r0 = this.runningAction;
        boolean r1 = true;
        if (r0 == null) goto L13;
        int r3 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r3 != 1) goto L8;
        HealthScoreLog.INSTANCE.i(SOURCE, "preemptScanForOptimize itemIds=" + r6);
        stopRunningAction();
        goto L13
    L8:
        if (r3 != 2) goto L13;
        HealthScoreLog.INSTANCE.d(SOURCE, "ignoreDuplicatedOptimize itemIds=" + r6 + " runningAction=" + r0);
        return;
    L13:
        HealthScoreLog r2 = HealthScoreLog.INSTANCE;
        StringBuilder r4 = new StringBuilder("startOptimizeRequest itemIds=").append(r6).append(" hasRuntimeContext=");
        if (r7 != null) goto L17;
        r1 = false;
    L17:
        r2.i(SOURCE, r4.append(r1).toString());
        this.pendingOptimizeItemIds = r6;
        startAction(HealthOptimizeAction.OPTIMIZE, r7);
    }

    @Override // com.obric.security.service.health.IHealthOptimizeManager
    public void stopOptimize() {
        stopRunningAction();
    }

    @Override // com.obric.security.service.health.IHealthOptimizeManager
    public Bundle getScoreSnapshot() {
        HealthScoreBundleMapper r0 = HealthScoreBundleMapper.INSTANCE;
        HealthScoreSnapshot r1 = this.lastSnapshot;
        if (r1 != null) goto L6;
        r1 = defaultSnapshot();
    L6:
        return r0.fromHealthSnapshot(r1);
    }

    @Override // com.obric.security.service.health.IHealthOptimizeManager
    public HealthScoreSnapshot getHealthSnapshot() {
        return this.lastSnapshot;
    }

    @Override // com.obric.security.service.health.IHealthOptimizeManager
    public List<HealthModulePresentation> getVisibleModulePresentations() {
        return this.presentationIndex.getVisibleModules();
    }

    @Override // com.obric.security.service.health.IHealthOptimizeManager
    public long getTrashTotalSize() {
        return this.lastTrashTotalSize;
    }

    @Override // com.obric.security.service.health.IHealthOptimizeManager
    public void setCallback(IHealthOptimizeManager.Callback r1) {
        this.callback = r1;
    }

    static /* synthetic */ void startAction$default(HealthOptimizeManager r0, HealthOptimizeAction r1, Context r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
        Context r5 = (Context) null;
    L5:
        r0.startAction(r1, r2);
    }

    private final void startAction(HealthOptimizeAction r15, Context r16) {
        if (this.runningAction == null) goto L6;
        HealthScoreLog.INSTANCE.d(SOURCE, "ignoreDuplicatedAction action=" + r15 + " runningAction=" + this.runningAction);
        return;
    L6:
        this.runningAction = r15;
        this.runningActionStartedAt = SystemClock.elapsedRealtime();
        List<HealthCheckItemPresentation> r3 = presentationsForAction(r15);
        HealthScoreLog r0 = HealthScoreLog.INSTANCE;
        StringBuilder r4 = new StringBuilder("actionStart action=").append(r15).append(" count=").append(r3.size()).append(" itemIds=");
        List<HealthCheckItemPresentation> r5 = r3;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r7.add(((HealthCheckItemPresentation) r6.next()).getId());
        goto L8
    L10:
        r0.i(SOURCE, r4.append(r7).toString());
        TaskProgressCounter.reset$default(this.progressCounter, r3.size(), 0, 2, null);
        this.activeJob = BuildersKt.launch$default(this.scope, null, null, new AnonymousClass2(this, r15, r3, r16, null), 3, null);
    }

    private final Object optimizeSelectedItems(List<HealthCheckItemPresentation> r8, Context r9, Continuation<? super Unit> r10) {
        boolean r2 = true;
        if (r8.isEmpty() == false) goto L12;
        HealthScoreSnapshot r11 = this.lastSnapshot;
        if (r11 != null) goto L7;
        r11 = defaultSnapshot();
    L7:
        HealthScoreLog.INSTANCE.i(SOURCE, "selectedOptimizeEmpty score=" + r11.getTotal());
        IHealthOptimizeManager.Callback r12 = this.callback;
        if (r12 == null) goto L10;
        r12.onOptimizeFinish(HealthScoreBundleMapper.INSTANCE.fromHealthSnapshot(r11));
    L10:
        completeRunningAction(true);
        return Unit.INSTANCE;
    L12:
        List<HealthCheckItemPresentation> r0 = r8;
        if ((r0 instanceof Collection) == true) goto L15;
    L17:
        Iterator<T> r3 = r0.iterator();
    L19:
        if (r3.hasNext() == false) goto L23;
        if (((HealthCheckItemPresentation) r3.next()).isNavigateFixable() == true) goto L19;
        r2 = false;
    L23:
        if (r2 == false) goto L41;
        HealthTaskManager r4 = this.taskManager;
        if (r4 != null) goto L28;
        HealthScoreLog.e$default(HealthScoreLog.INSTANCE, SOURCE, "abortNavigateOnlyOptimize reason=taskManagerNull", null, 4, null);
        resetRunningAction();
        return Unit.INSTANCE;
    L28:
        TaskProgressCounter.reset$default(this.progressCounter, r8.size(), 0, 2, null);
        HealthScoreLog r7 = HealthScoreLog.INSTANCE;
        StringBuilder r13 = new StringBuilder("navigateOnlyOptimize count=").append(r8.size()).append(" itemIds=");
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r6 = r0.iterator();
    L30:
        if (r6.hasNext() == false) goto L32;
        r5.add(((HealthCheckItemPresentation) r6.next()).getId());
        goto L30
    L32:
        r7.i(SOURCE, r13.append(r5).toString());
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r15 = r0.iterator();
    L34:
        if (r15.hasNext() == false) goto L36;
        r14.add(((HealthCheckItemPresentation) r15.next()).getId());
        goto L34
    L36:
        Object r16 = r4.optimize(r14, r9, r10);
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L40;
        return r16;
    L40:
        return Unit.INSTANCE;
    L41:
        HealthScoreSnapshot r1 = this.lastSnapshot;
        if (r1 != null) goto L44;
        r1 = defaultSnapshot();
    L44:
        Object r17 = checkAndAutoOptimize(r8, r9, r1, r10);
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L48;
        return r17;
    L48:
        return Unit.INSTANCE;
    L15:
        if (r0.isEmpty() == false) goto L17;
        goto L17
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0270 -> B:54:0x0284). Please report as a decompilation issue!!! */
    private final Object checkAndAutoOptimize(List<HealthCheckItemPresentation> r26, Context r27, HealthScoreSnapshot r28, Continuation<? super Unit> r29) {
        if ((r29 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r3 = (AnonymousClass1) r29;
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        String r6 = SOURCE;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        long r0 = r3.J$1;
        long r10 = r3.J$0;
        HealthCheckItemPresentation r7 = (HealthCheckItemPresentation) r3.L$9;
        Iterator r12 = (Iterator) r3.L$8;
        Ref.LongRef r13 = (Ref.LongRef) r3.L$7;
        Ref.LongRef r14 = (Ref.LongRef) r3.L$6;
        Ref.IntRef r15 = (Ref.IntRef) r3.L$5;
        Map<String, HealthCheckResult> r9 = (Map) r3.L$4;
        HealthTaskManager r8 = (HealthTaskManager) r3.L$3;
        Context r11 = (Context) r3.L$2;
        List<HealthCheckItemPresentation> r1 = (List) r3.L$1;
        HealthOptimizeManager r16 = (HealthOptimizeManager) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r17 = SOURCE;
        Object r18 = r4;
        Object r19 = r2;
        Ref.IntRef r20 = r15;
        Ref.LongRef r110 = r14;
        HealthCheckItemPresentation r111 = r7;
        AnonymousClass1 r21 = r3;
        HealthOptimizeManager r22 = r16;
        List<HealthCheckItemPresentation> r25 = r1;
        long r23 = r0;
    L54:
        HealthCheckResult r24 = (HealthCheckResult) r19;
        AnonymousClass1 r210 = r21;
        Object r211 = r18;
        r13.element += SystemClock.elapsedRealtime() - r23;
        r9.put(r111.getId(), r24);
        r20.element++;
        r22.progressCounter.setFinished(r20.element);
        HealthTaskStage r30 = HealthTaskStage.OPTIMIZE;
        if (r24.getStatus() != HealthCheckStatus.PASS) goto L57;
        boolean r31 = true;
    L58:
        r22.dispatchProgress(r30, r111, r31);
        List<HealthCheckItemPresentation> r32 = r25;
        r21 = r210;
        HealthOptimizeManager r33 = r22;
        HealthTaskManager r34 = r8;
        Iterator r35 = r12;
        Ref.LongRef r112 = r110;
        Object r36 = r211;
        Ref.IntRef r113 = r20;
        Context r37 = r11;
        Map<String, HealthCheckResult> r38 = r9;
        long r39 = r10;
    L60:
        r6 = r17;
    L36:
        if (r35.hasNext() == false) goto L61;
        r111 = (HealthCheckItemPresentation) r35.next();
        r17 = r6;
        r33.dispatchProgress(HealthTaskStage.CHECK, r111, false);
        Object r114 = r36;
        long r40 = SystemClock.elapsedRealtime();
        String r115 = r111.getId();
        r21.L$0 = r33;
        r21.L$1 = r32;
        r21.L$2 = r37;
        r21.L$3 = r34;
        r21.L$4 = r38;
        r21.L$5 = r113;
        r21.L$6 = r112;
        r21.L$7 = r13;
        r21.L$8 = r35;
        r21.L$9 = r111;
        r21.J$0 = r39;
        r21.J$1 = r40;
        List<HealthCheckItemPresentation> r116 = r32;
        r21.label = 1;
        Object r41 = r34.checkOne(r115, r21);
        if (r41 != r114) goto L40;
        return r114;
    L40:
        Iterator r212 = r35;
        r22 = r33;
        HealthTaskManager r213 = r34;
        Object r42 = r41;
        long r43 = r40;
        Ref.LongRef r44 = r112;
        r12 = r212;
        r8 = r213;
        Map<String, HealthCheckResult> r214 = r38;
        r11 = r37;
        List<HealthCheckItemPresentation> r45 = r116;
        Object r117 = r114;
        Ref.IntRef r118 = r113;
        long r119 = r39;
        r9 = r214;
    L41:
        HealthCheckResult r46 = (HealthCheckResult) r42;
        long r215 = r119;
        r44.element += SystemClock.elapsedRealtime() - r43;
        r9.put(r111.getId(), r46);
        r22.progressCounter.increment();
        HealthTaskStage r47 = HealthTaskStage.CHECK;
        if (r46.getStatus() != HealthCheckStatus.PASS) goto L44;
        boolean r48 = true;
    L45:
        r22.dispatchProgress(r47, r111, r48);
        if (r46.getStatus() == HealthCheckStatus.PASS) goto L59;
        r33 = r22;
        r35 = r12;
        r113 = r118;
        r112 = r44;
        r32 = r45;
        r37 = r11;
        r38 = r9;
        r39 = r215;
        HealthTaskManager r216 = r8;
        r36 = r117;
        r34 = r216;
        goto L60
    L48:
        if (r111.isAutoFixable() == false) goto L59;
        r22.progressCounter.reset(r45.size(), r118.element);
        r22.dispatchProgress(HealthTaskStage.OPTIMIZE, r111, false);
        long r120 = SystemClock.elapsedRealtime();
        String r49 = r111.getId();
        r21.L$0 = r22;
        r21.L$1 = r45;
        r21.L$2 = r11;
        r21.L$3 = r8;
        r21.L$4 = r9;
        r21.L$5 = r118;
        r21.L$6 = r44;
        r21.L$7 = r13;
        r21.L$8 = r12;
        r21.L$9 = r111;
        List<HealthCheckItemPresentation> r217 = r45;
        r21.J$0 = r215;
        r21.J$1 = r120;
        r21.label = 2;
        Object r50 = r8.optimizeOne(r49, r11, r21);
        Object r51 = r117;
        if (r50 != r51) goto L53;
        return r51;
    L53:
        r25 = r217;
        r19 = r50;
        Ref.LongRef r218 = r44;
        r18 = r51;
        Ref.IntRef r219 = r118;
        r110 = r218;
        r20 = r219;
        r23 = r120;
        r10 = r215;
        goto L54
    L59:
        r33 = r22;
        r35 = r12;
        r113 = r118;
        r112 = r44;
        r32 = r45;
        r37 = r11;
        r38 = r9;
        r39 = r215;
        HealthTaskManager r220 = r8;
        r36 = r117;
        r34 = r220;
        goto L60
    L44:
        r48 = false;
        goto L45
    L61:
        HealthScoreSnapshot r52 = r33.calculateSnapshot(r38);
        r33.lastSnapshot = r52;
        r33.updateTrashTotalSize(CollectionsKt.toList(r38.values()));
        HealthScoreLog.INSTANCE.i(r6, "checkAndAutoOptimizeFinish score=" + r52.getTotal() + " completed=" + r52.getCompletedItems().size() + " todo=" + r52.getTodoItems().size() + " checkCostMs=" + r112.element + " optimizeCostMs=" + r13.element + " autoOptimizeCount=" + r113.element + " totalCostMs=" + (SystemClock.elapsedRealtime() - r39));
        IHealthOptimizeManager.Callback r53 = r33.callback;
        if (r53 == null) goto L64;
        r53.onOptimizeFinish(HealthScoreBundleMapper.INSTANCE.fromHealthSnapshot(r52));
    L64:
        r33.completeRunningAction(true);
        return Unit.INSTANCE;
    L57:
        r31 = false;
        goto L58
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r54 = r3.J$1;
        long r55 = r3.J$0;
        HealthCheckItemPresentation r56 = (HealthCheckItemPresentation) r3.L$9;
        Iterator r57 = (Iterator) r3.L$8;
        Ref.LongRef r121 = (Ref.LongRef) r3.L$7;
        Ref.LongRef r122 = (Ref.LongRef) r3.L$6;
        Ref.IntRef r123 = (Ref.IntRef) r3.L$5;
        Map<String, HealthCheckResult> r124 = (Map) r3.L$4;
        HealthTaskManager r125 = (HealthTaskManager) r3.L$3;
        Context r126 = (Context) r3.L$2;
        List<HealthCheckItemPresentation> r58 = (List) r3.L$1;
        HealthOptimizeManager r59 = (HealthOptimizeManager) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r117 = r4;
        r17 = SOURCE;
        r44 = r122;
        r42 = r2;
        r45 = r58;
        AnonymousClass1 r221 = r3;
        r22 = r59;
        r43 = r54;
        r21 = r221;
        r111 = r56;
        r12 = r57;
        r9 = r124;
        r13 = r121;
        r119 = r55;
        r8 = r125;
        r11 = r126;
        r118 = r123;
        goto L41
    L16:
        ResultKt.throwOnFailure(r2);
        long r60 = SystemClock.elapsedRealtime();
        HealthTaskManager r61 = this.taskManager;
        if (r61 != null) goto L20;
        HealthScoreLog.e$default(HealthScoreLog.INSTANCE, SOURCE, "abortCheckAndAutoOptimize reason=taskManagerNull", null, 4, null);
        resetRunningAction();
        return Unit.INSTANCE;
    L20:
        if (r28 == null) goto L25;
        Map<String, HealthCheckResult> r62 = toResultMap(r28);
        if (r62 == null) goto L25;
        LinkedHashMap r63 = MapsKt.toMutableMap(r62);
        if (r63 == null) goto L25;
    L26:
        TaskProgressCounter.reset$default(this.progressCounter, r26.size(), 0, 2, null);
        Ref.IntRef r64 = new Ref.IntRef();
        r64.element = 0;
        Ref.LongRef r127 = new Ref.LongRef();
        r127.element = 0;
        r13 = new Ref.LongRef();
        r13.element = 0;
        HealthScoreLog r128 = HealthScoreLog.INSTANCE;
        StringBuilder r129 = new StringBuilder("checkAndAutoOptimizeStart count=").append(r26.size()).append(" itemIds=");
        List<HealthCheckItemPresentation> r130 = r26;
        ArrayList r131 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r130, 10));
        Iterator r65 = r130.iterator();
    L28:
        if (r65.hasNext() == false) goto L30;
        r131.add(((HealthCheckItemPresentation) r65.next()).getId());
        r65 = r65;
        goto L28
    L30:
        StringBuilder r66 = r129.append(r131).append(" hasBase=");
        if (r28 == null) goto L33;
        boolean r67 = true;
    L34:
        r128.i(SOURCE, r66.append(r67).toString());
        r32 = r26;
        r113 = r64;
        r112 = r127;
        r39 = r60;
        r36 = r4;
        r38 = r63;
        r34 = r61;
        r21 = r3;
        r37 = r27;
        r35 = r130.iterator();
        r33 = this;
        goto L36
    L33:
        r67 = false;
    L25:
        r63 = new LinkedHashMap();
    L7:
        r3 = new AnonymousClass1(this, r29);
        goto L8
    }

    private final void stopRunningAction() {
        HealthScoreLog.INSTANCE.i(SOURCE, "stopRunningAction runningAction=" + this.runningAction);
        Job r0 = this.activeJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        resetRunningAction();
    }

    private final void resetRunningAction() {
        HealthOptimizeAction r0 = this.runningAction;
        if (r0 != null) goto L5;
    L9:
        HealthOptimizeAction r3 = (HealthOptimizeAction) null;
        this.runningAction = null;
        Job r4 = (Job) null;
        this.activeJob = null;
        Set r5 = (Set) null;
        this.pendingScanItemIds = null;
        this.pendingOptimizeItemIds = null;
        this.runningActionStartedAt = 0;
        TaskProgressCounter.reset$default(this.progressCounter, 0, 0, 3, null);
        return;
    L5:
        if (this.runningActionStartedAt <= 0) goto L7;
        long r6 = SystemClock.elapsedRealtime() - this.runningActionStartedAt;
    L8:
        HealthScoreLog.INSTANCE.d(SOURCE, "actionReset action=" + r0 + " costMs=" + r6);
        goto L9
    L7:
        r6 = 0;
        goto L8
    }

    private final List<HealthCheckItemPresentation> presentationsForAction(HealthOptimizeAction r2) {
        int r3 = WhenMappings.$EnumSwitchMapping$2[r2.ordinal()];
        if (r3 == 1) goto L13;
        if (r3 != 2) goto L11;
        HealthScoreSnapshot r4 = this.lastSnapshot;
        if (r4 != null) goto L14;
        r4 = defaultSnapshot();
    L14:
        return presentationsForOptimize(r4);
    L11:
        throw new NoWhenBranchMatchedException();
    L13:
        return presentationsForScan();
    }

    private final List<HealthCheckItemPresentation> presentationsForScan() {
        Set<String> r0 = this.pendingScanItemIds;
        if (r0 == null) goto L5;
        List<HealthCheckItemPresentation> r4 = this.presentationIndex.getExecutableItems();
        ArrayList r1 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L13;
        Object r2 = r5.next();
        if (r0.contains(((HealthCheckItemPresentation) r2).getId()) == false) goto L8;
        r1.add(r2);
        goto L8
    L13:
        return r1;
    L5:
        return this.presentationIndex.getExecutableItems();
    }

    private final List<HealthCheckItemPresentation> presentationsForOptimize(HealthScoreSnapshot r2) {
        if (this.pendingOptimizeItemIds != null) goto L6;
        return this.presentationIndex.getExecutableItems();
    L6:
        return presentationsForSelectedOptimize(r2);
    }

    private final List<HealthCheckItemPresentation> presentationsForSelectedOptimize(HealthScoreSnapshot r5) {
        List<HealthCheckItemSnapshot> r6 = r5.getTodoItems();
        ArrayList r0 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        HealthCheckItemSnapshot r1 = (HealthCheckItemSnapshot) r7.next();
        HealthCheckItemPresentation r2 = this.presentationIndex.getById().get(r1.getId());
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L8:
        ArrayList r8 = new ArrayList();
        Iterator r3 = r0.iterator();
    L10:
        if (r3.hasNext() == false) goto L19;
        Object r4 = r3.next();
        HealthCheckItemPresentation r9 = (HealthCheckItemPresentation) r4;
        Set<String> r10 = this.pendingOptimizeItemIds;
        if (r10 == null) goto L16;
        boolean r11 = r10.contains(r9.getId());
        boolean r12 = true;
        if (r11 != true) goto L16;
    L17:
        if (r12 == false) goto L10;
        r8.add(r4);
    L16:
        r12 = false;
        goto L17
    L19:
        ArrayList r13 = new ArrayList();
        Iterator r14 = r8.iterator();
    L21:
        if (r14.hasNext() == false) goto L26;
        Object r15 = r14.next();
        if (canOptimizeItem((HealthCheckItemPresentation) r15) == false) goto L21;
        r13.add(r15);
        goto L21
    L26:
        return r13;
    }

    private final HealthScoreSnapshot defaultSnapshot() {
        return HealthScoreCalculator.INSTANCE.calculate(this.presentationIndex.getAllModules(), grantedHiddenResultMap(), this.presentationIndex.getVisibleItemIds());
    }

    @Override // com.obric.security.health.engine.HealthTaskListener
    public void onTaskStart(String r2, HealthTaskStage r3) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        Intrinsics.checkNotNullParameter(r3, "stage");
        dispatchProgress(r3, this.presentationIndex.getById().get(r2), false);
    }

    @Override // com.obric.security.health.engine.HealthTaskListener
    public void onTaskFinish(String r2, HealthTaskStage r3, HealthCheckResult r4) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        Intrinsics.checkNotNullParameter(r3, "stage");
        Intrinsics.checkNotNullParameter(r4, "result");
        HealthCheckItemPresentation r5 = this.presentationIndex.getById().get(r2);
        this.progressCounter.increment();
        if (r4.getStatus() != HealthCheckStatus.PASS) goto L5;
        boolean r6 = true;
    L6:
        dispatchProgress(r3, r5, r6);
        return;
    L5:
        r6 = false;
        goto L6
    }

    @Override // com.obric.security.health.engine.HealthTaskListener
    public Object onAllFinish(HealthTaskStage r9, List<HealthCheckResult> r10, Continuation<? super Unit> r11) {
        int r12 = WhenMappings.$EnumSwitchMapping$3[r9.ordinal()];
        boolean r1 = true;
        if (r12 == 1) goto L12;
        if (r12 != 2) goto L10;
        HealthScoreSnapshot r13 = this.lastSnapshot;
        if (r13 != null) goto L8;
        r13 = defaultSnapshot();
    L8:
        HealthScoreSnapshot r14 = mergeOptimizeResults(r13, r10);
    L22:
        this.lastSnapshot = r14;
        updateTrashTotalSize(r10);
        int r2 = scoreAppliedResultCount(r9, r10);
        if (r9 != HealthTaskStage.OPTIMIZE) goto L25;
        int r3 = r10.size() - r2;
    L26:
        HealthScoreLog.INSTANCE.i(SOURCE, "allFinish stage=" + r9 + " score=" + r14.getTotal() + " completed=" + r14.getCompletedItems().size() + " todo=" + r14.getTodoItems().size() + " resultCount=" + r10.size() + " scoreAppliedResultCount=" + r2 + " ignoredNavigateResultCount=" + r3);
        Bundle r15 = HealthScoreBundleMapper.INSTANCE.fromHealthSnapshot(r14);
        int r16 = WhenMappings.$EnumSwitchMapping$4[r9.ordinal()];
        if (r16 == 1) goto L33;
        if (r16 != 2) goto L37;
        IHealthOptimizeManager.Callback r17 = this.callback;
        if (r17 == null) goto L37;
        r17.onOptimizeFinish(r15);
    L37:
        if (r9 == HealthTaskStage.OPTIMIZE) goto L40;
        r1 = false;
    L40:
        completeRunningAction(r1);
        return Unit.INSTANCE;
    L33:
        IHealthOptimizeManager.Callback r18 = this.callback;
        if (r18 == null) goto L37;
        r18.onScanFinish(r15);
        goto L37
    L25:
        r3 = 0;
        goto L26
    L10:
        throw new NoWhenBranchMatchedException();
    L12:
        if (this.pendingScanItemIds != null) goto L18;
        List<HealthCheckResult> r19 = r10;
        LinkedHashMap r4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r19, 10)), 16));
        Iterator<T> r110 = r19.iterator();
    L15:
        if (r110.hasNext() == false) goto L17;
        Object r5 = r110.next();
        r4.put(((HealthCheckResult) r5).getItemId(), r5);
        goto L15
    L17:
        r14 = calculateSnapshot(r4);
        goto L22
    L18:
        HealthScoreSnapshot r111 = this.lastSnapshot;
        if (r111 != null) goto L21;
        r111 = defaultSnapshot();
    L21:
        r14 = mergeCheckResults(r111, r10);
        goto L22
    }

    private final HealthScoreSnapshot mergeCheckResults(HealthScoreSnapshot r3, List<HealthCheckResult> r4) {
        Map<String, HealthCheckResult> r5 = MapsKt.toMutableMap(toResultMap(r3));
        Iterator<T> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        HealthCheckResult r0 = (HealthCheckResult) r6.next();
        r5.put(r0.getItemId(), r0);
        goto L4
    L7:
        return calculateSnapshot(r5);
    }

    private final HealthScoreSnapshot mergeOptimizeResults(HealthScoreSnapshot r5, List<HealthCheckResult> r6) {
        Map<String, HealthCheckResult> r7 = MapsKt.toMutableMap(toResultMap(r5));
        Iterator<T> r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L12;
        HealthCheckResult r0 = (HealthCheckResult) r8.next();
        HealthCheckItemPresentation r1 = this.presentationIndex.getById().get(r0.getItemId());
        if (r1 == null) goto L10;
        if (r1.isNavigateFixable() != true) goto L10;
        HealthScoreLog.INSTANCE.d(SOURCE, "ignoreNavigateOnlyOptimizeResult itemId=" + r0.getItemId() + " status=" + r0.getStatus());
    L10:
        r7.put(r0.getItemId(), r0);
        goto L4
    L12:
        return calculateSnapshot(r7);
    }

    private final int scoreAppliedResultCount(HealthTaskStage r4, List<HealthCheckResult> r5) {
        if (r4 == HealthTaskStage.CHECK) goto L5;
        List<HealthCheckResult> r6 = r5;
        if ((r6 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r7 = r6.iterator();
        int r8 = 0;
    L13:
        if (r7.hasNext() == false) goto L25;
        HealthCheckItemPresentation r1 = this.presentationIndex.getById().get(((HealthCheckResult) r7.next()).getItemId());
        boolean r2 = true;
        if (r1 != null) goto L17;
    L20:
        if (r2 == false) goto L13;
        r8 = r8 + 1;
        if (r8 >= 0) goto L13;
        CollectionsKt.throwCountOverflow();
        goto L13
    L17:
        if (r1.isNavigateFixable() != true) goto L20;
        r2 = false;
        goto L20
    L25:
        return r8;
    L9:
        if (r6.isEmpty() == false) goto L11;
        return 0;
    L5:
        return r5.size();
    }

    private final HealthScoreSnapshot calculateSnapshot(Map<String, HealthCheckResult> r6) {
        long r0 = SystemClock.elapsedRealtime();
        HealthScoreSnapshot r5 = HealthScoreCalculator.INSTANCE.calculate(this.presentationIndex.getAllModules(), MapsKt.plus(grantedHiddenResultMap(), r6), this.presentationIndex.getVisibleItemIds());
        HealthScoreLog.INSTANCE.d(SOURCE, "calculateSnapshot inputCount=" + r6.size() + " score=" + r5.getTotal() + " costMs=" + (SystemClock.elapsedRealtime() - r0));
        return r5;
    }

    private final Map<String, HealthCheckResult> grantedHiddenResultMap() {
        List<HealthCheckItemPresentation> r11 = this.presentationIndex.getGrantedHiddenItems();
        LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r11, 10)), 16));
        Iterator<T> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        HealthCheckItemPresentation r0 = (HealthCheckItemPresentation) r12.next();
        Pair r2 = TuplesKt.to(r0.getId(), new HealthCheckResult(r0.getId(), HealthCheckStatus.PASS, null, MapsKt.mapOf(new Pair[]{TuplesKt.to(HealthEvidenceKeys.EARNED_SCORE, String.valueOf(r0.getScore())), TuplesKt.to("granted_hidden", Constants.IS_SET), TuplesKt.to("policy", "GRANTED_HIDDEN")}), 4, null));
        r1.put(r2.getFirst(), r2.getSecond());
        goto L4
    L6:
        return r1;
    }

    private final void updateTrashTotalSize(List<HealthCheckResult> r5) {
        Iterator<T> r6 = r5.iterator();
    L3:
        Long r1 = null;
        if (r6.hasNext() == false) goto L8;
        Object r0 = r6.next();
        if (Intrinsics.areEqual(((HealthCheckResult) r0).getItemId(), HealthTaskIds.TRASH_LESS) == false) goto L3;
    L9:
        HealthCheckResult r2 = (HealthCheckResult) r0;
        if (r2 == null) goto L16;
        Map<String, String> r7 = r2.getEvidence();
        if (r7 == null) goto L16;
        String r8 = r7.get(HealthEvidenceKeys.TRASH_SIZE);
        if (r8 == null) goto L16;
        r1 = StringsKt.toLongOrNull(r8);
    L16:
        if (r1 == null) goto L22;
        this.lastTrashTotalSize = r1.longValue();
        HealthScoreLog.INSTANCE.d(SOURCE, "updateTrashTotalSize size=" + r1);
        return;
    L22:
        return;
    L8:
        r0 = null;
        goto L9
    }

    private final void dispatchProgress(HealthTaskStage r8, HealthCheckItemPresentation r9, boolean r10) {
        int r2 = this.progressCounter.percent();
        HealthScoreLog r0 = HealthScoreLog.INSTANCE;
        StringBuilder r1 = new StringBuilder("dispatchProgress stage=").append(r8).append(" progress=").append(r2).append(" itemId=");
        if (r9 == null) goto L5;
        String r4 = r9.getId();
    L6:
        StringBuilder r3 = r1.append(r4).append(" moduleId=");
        if (r9 == null) goto L9;
        String r5 = r9.getModuleId();
    L10:
        r0.d(SOURCE, r3.append(r5).append(" taskPassed=").append(r10).toString());
        int r11 = WhenMappings.$EnumSwitchMapping$5[r8.ordinal()];
        if (r11 != 1) goto L13;
        IHealthOptimizeManager.Callback r6 = this.callback;
        if (r6 == null) goto L42;
        if (r9 == null) goto L31;
        String r7 = displayOptimizeTitle(r9);
    L32:
        if (r9 == null) goto L34;
        String r12 = r9.getId();
    L35:
        if (r9 == null) goto L37;
        String r13 = r9.getModuleId();
    L38:
        r6.onScanProgress(r2, r7, r12, r13, r10);
        return;
    L37:
        r13 = null;
        goto L38
    L34:
        r12 = null;
        goto L35
    L31:
        r7 = null;
        goto L32
    L42:
        return;
    L13:
        if (r11 != 2) goto L43;
        IHealthOptimizeManager.Callback r14 = this.callback;
        if (r14 == null) goto L40;
        if (r9 == null) goto L19;
        String r15 = displayOptimizeTitle(r9);
    L20:
        if (r9 == null) goto L22;
        String r16 = r9.getId();
    L23:
        if (r9 == null) goto L25;
        String r17 = r9.getModuleId();
    L26:
        r14.onOptimizeProgress(r2, r15, r16, r17, r10);
        return;
    L25:
        r17 = null;
        goto L26
    L22:
        r16 = null;
        goto L23
    L19:
        r15 = null;
        goto L20
    L40:
        return;
    L43:
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    private final String displayOptimizeTitle(HealthCheckItemPresentation r3) {
        Integer r4 = Integer.valueOf(r3.getTitleResId());
        if (r4.intValue() == 0) goto L5;
        boolean r0 = true;
    L6:
        String r1 = null;
        if (r0 == true) goto L10;
        r4 = null;
    L10:
        if (r4 == null) goto L12;
        r1 = this.appContext.getString(r4.intValue());
    L12:
        if (r1 != null) goto L15;
        return "";
    L15:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    private final boolean canOptimizeItem(HealthCheckItemPresentation r1) {
        if (this.pendingOptimizeItemIds != null) goto L6;
        return r1.isAutoFixable();
    L6:
        return r1.isFixable();
    }

    private final void completeRunningAction(boolean r9) {
        HealthOptimizeAction r0 = this.runningAction;
        if (this.runningActionStartedAt <= 0) goto L5;
        long r1 = SystemClock.elapsedRealtime() - this.runningActionStartedAt;
    L6:
        HealthScoreLog.INSTANCE.i(SOURCE, "actionFinish action=" + r0 + " costMs=" + r1 + " clearPendingOptimize=" + r9);
        Set r2 = (Set) null;
        this.pendingScanItemIds = null;
        if (r9 == false) goto L9;
        this.pendingOptimizeItemIds = null;
    L9:
        HealthOptimizeAction r10 = (HealthOptimizeAction) null;
        this.runningAction = null;
        Job r11 = (Job) null;
        this.activeJob = null;
        this.runningActionStartedAt = 0;
        return;
    L5:
        r1 = 0;
        goto L6
    }

    private final Map<String, HealthCheckResult> toResultMap(HealthScoreSnapshot r11) {
        List<HealthModuleSnapshot> r10 = r11.getModules();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        CollectionsKt.addAll(r12, ((HealthModuleSnapshot) r13.next()).getItems());
        goto L4
    L6:
        ArrayList r14 = r12;
        LinkedHashMap r0 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r14, 10)), 16));
        Iterator r15 = r14.iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        HealthCheckItemSnapshot r16 = (HealthCheckItemSnapshot) r15.next();
        Pair r17 = TuplesKt.to(r16.getId(), new HealthCheckResult(r16.getId(), r16.getStatus(), null, MapsKt.plus(r16.getEvidence(), MapsKt.mapOf(TuplesKt.to(HealthEvidenceKeys.EARNED_SCORE, String.valueOf(r16.getEarnedScore())))), 4, null));
        r0.put(r17.getFirst(), r17.getSecond());
        goto L8
    L10:
        return r0;
    }
}
