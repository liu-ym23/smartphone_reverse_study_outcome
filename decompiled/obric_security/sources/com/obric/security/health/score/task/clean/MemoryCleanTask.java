package com.obric.security.health.score.task.clean;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedanceos.clearmemory.RunningState;
import com.bytedanceos.clearmemory.RunningStateHelper;
import com.bytedanceos.utils.Constants;
import com.obric.security.health.model.HealthCheckResult;
import com.obric.security.health.model.HealthCheckStatus;
import com.obric.security.health.model.HealthFixCapability;
import com.obric.security.health.score.HealthEvidenceKeys;
import com.obric.security.health.score.HealthModuleIds;
import com.obric.security.health.score.HealthScoreLog;
import com.obric.security.health.score.HealthTaskIds;
import com.obric.security.health.score.task.HealthCheckTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
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
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: MemoryCleanTask.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u000234B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ#\u0010\u001f\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ&\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u001b\u001a\u00020\u001c2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0002J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004H\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J!\u0010(\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ+\u0010)\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020*H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010+J#\u0010,\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ \u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u0010H\u0002J&\u00101\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\f\u00102\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lcom/obric/security/health/score/task/clean/MemoryCleanTask;", "Lcom/obric/security/health/score/task/HealthCheckTask;", "()V", "defaultScore", "", "getDefaultScore", "()I", "fixCapability", "Lcom/obric/security/health/model/HealthFixCapability;", "getFixCapability", "()Lcom/obric/security/health/model/HealthFixCapability;", SlardarConfigConsts.CONFIG_ID, "", "getId", "()Ljava/lang/String;", "lastScanFinishedAt", "", "lastScanResult", "Lcom/obric/security/health/score/task/clean/CleanTaskResult;", "moduleId", "getModuleId", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "runningState", "Lcom/bytedanceos/clearmemory/RunningState;", "check", "Lcom/obric/security/health/model/HealthCheckResult;", "context", "Landroid/content/Context;", "taskScore", "(Landroid/content/Context;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", HealthModuleIds.CLEAN, "filterItems", "", "Lcom/bytedanceos/clearmemory/RunningState$MergedItem;", "mergedItems", "mapDeductScore", "baseDeductScore", "onCreate", "", "optimize", "runMemory", "", "(Landroid/content/Context;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scan", "scoreDetail", "Lcom/obric/security/health/score/task/clean/MemoryCleanTask$ScoreDetail;", "totalSize", "lastCleanTime", "snapshot", "items", "Companion", "ScoreDetail", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class MemoryCleanTask extends HealthCheckTask {

    @Deprecated
    private static final int BASE_SCORE = 6;
    private static final Companion Companion = null;

    @Deprecated
    private static final long KEEP_ZERO_DURATION_MS = 300000;

    @Deprecated
    private static final String KEY_LAST_CLEAN_TIME = "last_clean_time";

    @Deprecated
    private static final long MEMORY_TIMEOUT_MS = 30000;

    @Deprecated
    private static final String PREF_NAME = "memory_work_task_prefs";

    @Deprecated
    private static final long RESULT_CACHE_WINDOW_MS = 2000;

    @Deprecated
    private static final long SIZE_GB = 1073741824;

    @Deprecated
    private static final long SIZE_MB = 1048576;

    @Deprecated
    private static final String SOURCE = "MemoryCleanTask";
    private final int defaultScore;
    private final HealthFixCapability fixCapability;
    private final String id;
    private long lastScanFinishedAt;
    private CleanTaskResult lastScanResult;
    private final String moduleId;
    private final Mutex mutex;
    private RunningState runningState;

    /* JADX INFO: compiled from: MemoryCleanTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/security/health/score/task/clean/MemoryCleanTask$Companion;", "", "()V", "BASE_SCORE", "", "KEEP_ZERO_DURATION_MS", "", "KEY_LAST_CLEAN_TIME", "", "MEMORY_TIMEOUT_MS", "PREF_NAME", "RESULT_CACHE_WINDOW_MS", "SIZE_GB", "SIZE_MB", "SOURCE", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: MemoryCleanTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/security/health/score/task/clean/MemoryCleanTask$ScoreDetail;", "", "earnedScore", "", "deductScore", "range", "", "(IILjava/lang/String;)V", "getDeductScore", "()I", "getEarnedScore", "getRange", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class ScoreDetail {
        private final int deductScore;
        private final int earnedScore;
        private final String range;

        public static /* synthetic */ ScoreDetail copy$default(ScoreDetail r0, int r1, int r2, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.earnedScore;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.deductScore;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.range;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final int component1() {
            return this.earnedScore;
        }

        public final int component2() {
            return this.deductScore;
        }

        public final String component3() {
            return this.range;
        }

        public final ScoreDetail copy(int r1, int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "range");
            return new ScoreDetail(r1, r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof ScoreDetail) == false) goto L12;
            ScoreDetail r4 = (ScoreDetail) r3;
            if (this.earnedScore == r4.earnedScore) goto L8;
            return false;
        L8:
            if (this.deductScore == r4.deductScore) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.range, r4.range) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            int r0 = ((Integer.hashCode(this.earnedScore) * 31) + Integer.hashCode(this.deductScore)) * 31;
            String r2 = this.range;
            if (r2 == null) goto L5;
            int r3 = r2.hashCode();
        L7:
            return r0 + r3;
        L5:
            r3 = 0;
            goto L7
        }

        public String toString() {
            return "ScoreDetail(earnedScore=" + this.earnedScore + ", deductScore=" + this.deductScore + ", range=" + this.range + ")";
        }

        public ScoreDetail(int r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "range");
            this.earnedScore = r2;
            this.deductScore = r3;
            this.range = r4;
        }

        public final int getEarnedScore() {
            return this.earnedScore;
        }

        public final int getDeductScore() {
            return this.deductScore;
        }

        public final String getRange() {
            return this.range;
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.clean.MemoryCleanTask$check$1, reason: invalid class name */
    /* JADX INFO: compiled from: MemoryCleanTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096@"}, d2 = {"check", "", "context", "Landroid/content/Context;", "taskScore", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/security/health/model/HealthCheckResult;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.clean.MemoryCleanTask", f = "MemoryCleanTask.kt", i = {0, 0}, l = {44}, m = "check", n = {"this", "taskScore"}, s = {"L$0", "I$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MemoryCleanTask this$0;

        AnonymousClass1(MemoryCleanTask r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.check(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.clean.MemoryCleanTask$clean$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MemoryCleanTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0082@"}, d2 = {HealthModuleIds.CLEAN, "", "context", "Landroid/content/Context;", "taskScore", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/security/health/score/task/clean/CleanTaskResult;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.clean.MemoryCleanTask", f = "MemoryCleanTask.kt", i = {0, 0, 0, 0, 1, 1}, l = {299, 101}, m = HealthModuleIds.CLEAN, n = {"this", "context", "$this$withLock_u24default$iv", "taskScore", "this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1"})
    static final class C03731 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MemoryCleanTask this$0;

        C03731(MemoryCleanTask r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return MemoryCleanTask.access$clean(this.this$0, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.clean.MemoryCleanTask$optimize$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MemoryCleanTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096@"}, d2 = {"optimize", "", "context", "Landroid/content/Context;", "taskScore", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/security/health/model/HealthCheckResult;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.clean.MemoryCleanTask", f = "MemoryCleanTask.kt", i = {0, 0}, l = {64}, m = "optimize", n = {"this", "taskScore"}, s = {"L$0", "I$0"})
    static final class C03741 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MemoryCleanTask this$0;

        C03741(MemoryCleanTask r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.optimize(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.clean.MemoryCleanTask$runMemory$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MemoryCleanTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0082@"}, d2 = {"runMemory", "", "context", "Landroid/content/Context;", "taskScore", "", HealthModuleIds.CLEAN, "", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/security/health/score/task/clean/CleanTaskResult;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.clean.MemoryCleanTask", f = "MemoryCleanTask.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {130, 135, 190, 190, 190}, m = "runMemory", n = {"this", "context", "state", "packageManager", "deferred", "listener", "taskScore", HealthModuleIds.CLEAN, "totalStartAt", "refreshStartAt", "this", "context", "state", "packageManager", "listener", "taskScore", HealthModuleIds.CLEAN, "totalStartAt", "refreshStartAt"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "Z$0", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "Z$0", "J$0", "J$1"})
    static final class C03751 extends ContinuationImpl {
        int I$0;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MemoryCleanTask this$0;

        C03751(MemoryCleanTask r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return MemoryCleanTask.access$runMemory(this.this$0, null, 0, false, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.clean.MemoryCleanTask$runMemory$2, reason: invalid class name */
    /* JADX INFO: compiled from: MemoryCleanTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.clean.MemoryCleanTask$runMemory$2", f = "MemoryCleanTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef $listener;
        final /* synthetic */ RunningState $state;
        int label;

        AnonymousClass2(RunningState r1, Ref.ObjectRef r2, Continuation r3) {
            this.$state = r1;
            this.$listener = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new AnonymousClass2(this.$state, this.$listener, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$state.registListener((RunningState.OnRefreshUiListener) this.$listener.element);
            this.$state.resume();
            this.$state.updateNow();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.clean.MemoryCleanTask$runMemory$6, reason: invalid class name */
    /* JADX INFO: compiled from: MemoryCleanTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.clean.MemoryCleanTask$runMemory$6", f = "MemoryCleanTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef $listener;
        final /* synthetic */ RunningState $state;
        int label;

        AnonymousClass6(RunningState r1, Ref.ObjectRef r2, Continuation r3) {
            this.$state = r1;
            this.$listener = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new AnonymousClass6(this.$state, this.$listener, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass6) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$state.unregistListener((RunningState.OnRefreshUiListener) this.$listener.element);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.clean.MemoryCleanTask$scan$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MemoryCleanTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0082@"}, d2 = {"scan", "", "context", "Landroid/content/Context;", "taskScore", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/security/health/score/task/clean/CleanTaskResult;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.clean.MemoryCleanTask", f = "MemoryCleanTask.kt", i = {0, 0, 0, 0, 1, 1}, l = {289, 90}, m = "scan", n = {"this", "context", "$this$withLock_u24default$iv", "taskScore", "this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1"})
    static final class C03761 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MemoryCleanTask this$0;

        C03761(MemoryCleanTask r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return MemoryCleanTask.access$scan(this.this$0, null, 0, this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public MemoryCleanTask() {
        this.id = HealthTaskIds.MEMORY_CLEAN;
        this.moduleId = HealthModuleIds.CLEAN;
        this.defaultScore = 6;
        this.fixCapability = HealthFixCapability.AUTO;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
    }

    public static final /* synthetic */ Object access$clean(MemoryCleanTask r0, Context r1, int r2, Continuation r3) {
        return r0.clean(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$runMemory(MemoryCleanTask r0, Context r1, int r2, boolean r3, Continuation r4) {
        return r0.runMemory(r1, r2, r3, r4);
    }

    public static final /* synthetic */ Object access$scan(MemoryCleanTask r0, Context r1, int r2, Continuation r3) {
        return r0.scan(r1, r2, r3);
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
    public void onCreate(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.runningState = RunningState.getInstance(r3.getApplicationContext());
        HealthScoreLog r4 = HealthScoreLog.INSTANCE;
        StringBuilder r0 = new StringBuilder("onCreate runningState=");
        if (this.runningState == null) goto L5;
        boolean r2 = true;
    L6:
        r4.i(SOURCE, r0.append(r2).toString());
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.obric.security.health.score.task.HealthCheckTask
    public Object check(Context r23, int r24, Continuation<? super HealthCheckResult> r25) {
        MemoryCleanTask r0 = this;
        int r1 = r24;
        if ((r25 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r3 = (AnonymousClass1) r25;
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        int r6 = r3.I$0;
        MemoryCleanTask r7 = (MemoryCleanTask) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r1 = r6;
        r0 = r7;
    L17:
        CleanTaskResult r8 = (CleanTaskResult) r2;
        if (r8 == null) goto L20;
        String r15 = r0.getId();
        if (r8.getTotalSize() > 0) goto L24;
        HealthCheckStatus r9 = HealthCheckStatus.PASS;
    L26:
        return new HealthCheckResult(r15, r9, null, MapsKt.mapOf(new Pair[]{TuplesKt.to(HealthEvidenceKeys.EARNED_SCORE, String.valueOf(r8.getScore())), TuplesKt.to("memory_earned_score", String.valueOf(r8.getScore())), TuplesKt.to("memory_deduct_score", String.valueOf(r1 - r8.getScore())), TuplesKt.to("memory_score_range", r8.getScoreRange()), TuplesKt.to(HealthEvidenceKeys.MEMORY_SIZE, String.valueOf(r8.getTotalSize())), TuplesKt.to(HealthEvidenceKeys.OPTIMIZED_SIZE, String.valueOf(r8.getOptimizedSize()))}), 4, null);
    L24:
        r9 = HealthCheckStatus.FAIL;
        goto L26
    L20:
        return new HealthCheckResult(r0.getId(), HealthCheckStatus.ERROR, "memory scan timeout", null, 8, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        r3.L$0 = r0;
        r3.I$0 = r1;
        r3.label = 1;
        r2 = r0.scan(r23, r1, r3);
        if (r2 != r4) goto L17;
        return r4;
    L7:
        r3 = new AnonymousClass1(r0, r25);
        goto L8
    }

    @Override // com.obric.security.health.score.task.HealthCheckTask
    public Object optimize(Context r23, int r24, Continuation<? super HealthCheckResult> r25) {
        MemoryCleanTask r0 = this;
        int r1 = r24;
        if ((r25 instanceof C03741) == false) goto L7;
        C03741 r3 = (C03741) r25;
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        int r6 = r3.I$0;
        MemoryCleanTask r7 = (MemoryCleanTask) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r1 = r6;
        r0 = r7;
    L17:
        CleanTaskResult r8 = (CleanTaskResult) r2;
        if (r8 == null) goto L20;
        String r15 = r0.getId();
        if (r8.getTotalSize() > 0) goto L24;
        HealthCheckStatus r9 = HealthCheckStatus.PASS;
    L26:
        return new HealthCheckResult(r15, r9, null, MapsKt.mapOf(new Pair[]{TuplesKt.to(HealthEvidenceKeys.EARNED_SCORE, String.valueOf(r8.getScore())), TuplesKt.to("memory_earned_score", String.valueOf(r8.getScore())), TuplesKt.to("memory_deduct_score", String.valueOf(r1 - r8.getScore())), TuplesKt.to("memory_score_range", r8.getScoreRange()), TuplesKt.to(HealthEvidenceKeys.MEMORY_SIZE, String.valueOf(r8.getTotalSize())), TuplesKt.to(HealthEvidenceKeys.OPTIMIZED_SIZE, String.valueOf(r8.getOptimizedSize()))}), 4, null);
    L24:
        r9 = HealthCheckStatus.FAIL;
        goto L26
    L20:
        return new HealthCheckResult(r0.getId(), HealthCheckStatus.ERROR, "memory clean timeout", null, 8, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        r3.L$0 = r0;
        r3.I$0 = r1;
        r3.label = 1;
        r2 = r0.clean(r23, r1, r3);
        if (r2 != r4) goto L17;
        return r4;
    L7:
        r3 = new C03741(r0, r25);
        goto L8
    }

    private final Object scan(Context r13, int r14, Continuation<? super CleanTaskResult> r15) {
        if ((r15 instanceof C03761) == false) goto L7;
        C03761 r1 = (C03761) r15;
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r16 = r1.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        Mutex r12 = (Mutex) r1.L$1;
        MemoryCleanTask r17 = (MemoryCleanTask) r1.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L15
    L32:
        CleanTaskResult r4 = (CleanTaskResult) r16;     // Catch: Throwable -> L15
        if (r4 == null) goto L35;
        r17.lastScanResult = r4;     // Catch: Throwable -> L15
        r17.lastScanFinishedAt = System.currentTimeMillis();     // Catch: Throwable -> L15
    L35:
        Mutex r18 = r12;
    L36:
        r18.unlock(null);
        return r4;
    L15:
        th = th;
    L40:
        r12.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r14 = r1.I$0;
        Mutex r19 = (Mutex) r1.L$2;
        r13 = (Context) r1.L$1;
        MemoryCleanTask r5 = (MemoryCleanTask) r1.L$0;
        ResultKt.throwOnFailure(r16);
        r18 = r19;
        MemoryCleanTask this = r5;
    L42:
        r4 = this.lastScanResult;     // Catch: Throwable -> L38
        if (r4 != null) goto L26;
    L28:
        Context r110 = r13.getApplicationContext();     // Catch: Throwable -> L38
        Intrinsics.checkNotNullExpressionValue(r110, "context.applicationContext");     // Catch: Throwable -> L38
        r1.L$0 = this;     // Catch: Throwable -> L38
        r1.L$1 = r18;     // Catch: Throwable -> L38
        r1.L$2 = null;     // Catch: Throwable -> L38
        r1.label = 2;     // Catch: Throwable -> L38
        Object r111 = this.runMemory(r110, r14, false, r1);     // Catch: Throwable -> L38
        if (r111 != r2) goto L31;
        return r2;
    L31:
        r17 = this;
        r12 = r18;
        r16 = r111;
        goto L32
    L26:
        if ((System.currentTimeMillis() - this.lastScanFinishedAt) > RESULT_CACHE_WINDOW_MS) goto L28;
        HealthScoreLog.INSTANCE.d(SOURCE, "scan useCache totalSize=" + r4.getTotalSize() + " score=" + r4.getScore() + " optimizedSize=" + r4.getOptimizedSize());     // Catch: Throwable -> L38
    L38:
        th = th;
        r12 = r18;
        goto L40
    L20:
        ResultKt.throwOnFailure(r16);
        r18 = this.mutex;
        r1.L$0 = this;
        r1.L$1 = r13;
        r1.L$2 = r18;
        r1.I$0 = r14;
        r1.label = 1;
        if (r18.lock(null, r1) != r2) goto L42;
        return r2;
    L7:
        r1 = new C03761(this, r15);
        goto L8
    }

    private final Object clean(Context r8, int r9, Continuation<? super CleanTaskResult> r10) {
        if ((r10 instanceof C03731) == false) goto L7;
        C03731 r0 = (C03731) r10;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L19;
        if (r2 != 2) goto L18;
        Mutex r7 = (Mutex) r0.L$1;
        MemoryCleanTask r12 = (MemoryCleanTask) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L15
    L27:
        CleanTaskResult r13 = (CleanTaskResult) r11;     // Catch: Throwable -> L15
        if (r13 == null) goto L30;
        r12.lastScanResult = r13;     // Catch: Throwable -> L15
        r12.lastScanFinishedAt = System.currentTimeMillis();     // Catch: Throwable -> L15
    L30:
        r7.unlock(null);
        return r13;
    L15:
        th = th;
    L34:
        r7.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r9 = r0.I$0;
        Mutex r14 = (Mutex) r0.L$2;
        r8 = (Context) r0.L$1;
        MemoryCleanTask r3 = (MemoryCleanTask) r0.L$0;
        ResultKt.throwOnFailure(r11);
        Mutex r15 = r14;
        MemoryCleanTask this = r3;
    L36:
        Context r16 = r8.getApplicationContext();     // Catch: Throwable -> L32
        Intrinsics.checkNotNullExpressionValue(r16, "context.applicationContext");     // Catch: Throwable -> L32
        r0.L$0 = this;     // Catch: Throwable -> L32
        r0.L$1 = r15;     // Catch: Throwable -> L32
        r0.L$2 = null;     // Catch: Throwable -> L32
        r0.label = 2;     // Catch: Throwable -> L32
        Object r17 = this.runMemory(r16, r9, true, r0);     // Catch: Throwable -> L32
        if (r17 != r1) goto L26;
        return r1;
    L26:
        r12 = this;
        r7 = r15;
        r11 = r17;
    L32:
        th = th;
        r7 = r15;
        goto L34
    L20:
        ResultKt.throwOnFailure(r11);
        r15 = this.mutex;
        r0.L$0 = this;
        r0.L$1 = r8;
        r0.L$2 = r15;
        r0.I$0 = r9;
        r0.label = 1;
        if (r15.lock(null, r0) != r1) goto L36;
        return r1;
    L7:
        r0 = new C03731(this, r10);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r11v4, types: [T, com.bytedanceos.clearmemory.RunningState$OnRefreshUiListener] */
    private final Object runMemory(Context r36, int r37, boolean r38, Continuation<? super CleanTaskResult> r39) {
        String r4 = " totalCostMs=";
        String r5 = " snapshotCostMs=";
        String r6 = " refreshCostMs=";
        String r7 = "runMemory scanFinish totalSize=";
        if ((r39 instanceof C03751) == false) goto L7;
        C03751 r9 = (C03751) r39;
        if ((r9.label & Integer.MIN_VALUE) == 0) goto L7;
        r9.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r9.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r9.label;
        String r12 = SOURCE;
        if (r11 == 0) goto L33;
        if (r11 == 1) goto L28;
        if (r11 != 2) goto L13;
        long r0 = r9.J$1;
        long r13 = r9.J$0;
        boolean r2 = r9.Z$0;
        int r15 = r9.I$0;
        Ref.ObjectRef r14 = (Ref.ObjectRef) r9.L$4;
        PackageManager r1 = (PackageManager) r9.L$3;
        RunningState r8 = (RunningState) r9.L$2;
        Context r16 = (Context) r9.L$1;
        MemoryCleanTask r17 = (MemoryCleanTask) r9.L$0;
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L26
        r4 = " totalCostMs=";
        r5 = " snapshotCostMs=";
        r6 = " refreshCostMs=";
        r7 = "runMemory scanFinish totalSize=";
        r12 = SOURCE;
        long r18 = r0;
        PackageManager r19 = r1;
        Context r20 = r16;
    L116:
        List<? extends RunningState.MergedItem> r21 = (List) r3;     // Catch: Throwable -> L101
        if (r21 != null) goto L57;
        MemoryCleanTask r22 = r17;     // Catch: Throwable -> L26
        HealthScoreLog r23 = HealthScoreLog.INSTANCE;     // Catch: Throwable -> L26
        StringBuilder r24 = new StringBuilder("runMemory scanTimeout clean=");     // Catch: Throwable -> L26
        if (r2 == false) goto L51;
        boolean r110 = true;
    L52:
        HealthScoreLog.w$default(r23, SOURCE, r24.append(r110).toString(), null, 4, null);     // Catch: Throwable -> L26
        MainCoroutineDispatcher r25 = Dispatchers.getMain();
        AnonymousClass6 r26 = new AnonymousClass6(r8, r14, null);
        r9.L$0 = null;
        r9.L$1 = null;
        r9.L$2 = null;
        r9.L$3 = null;
        r9.L$4 = null;
        r9.label = 3;
        if (BuildersKt.withContext(r25, r26, r9) != r10) goto L139;
        return r10;
    L139:
        return null;
    L51:
        r110 = false;
        goto L52
    L57:
        long r27 = SystemClock.elapsedRealtime() - r18;     // Catch: Throwable -> L101
        long r28 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L101
        List<RunningState.MergedItem> r29 = r17.filterItems(r20, r21);     // Catch: Throwable -> L101
        long r30 = SystemClock.elapsedRealtime() - r28;
        r10 = r10;
        if (r2 == true) goto L114;
        RunningState r210 = r8;
        C03751 r32 = r9;
        Ref.ObjectRef r111 = r14;
        long r33 = r13;
        String r31 = r12;
        long r211 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L99
        CleanTaskResult r34 = r17.snapshot(r20, r15, r29);     // Catch: Throwable -> L99
        HealthScoreLog.INSTANCE.i(r31, r7 + r34.getTotalSize() + " score=" + r34.getScore() + " deductScore=" + r34.getDeductScore() + " scoreRange=" + r34.getScoreRange() + r6 + r27 + " filterCostMs=" + r30 + r5 + (SystemClock.elapsedRealtime() - r211) + r4 + (SystemClock.elapsedRealtime() - r33));     // Catch: Throwable -> L99
    L95:
        MainCoroutineDispatcher r35 = Dispatchers.getMain();
        AnonymousClass6 r40 = new AnonymousClass6(r210, r111, null);
        C03751 r41 = r32;
        r41.L$0 = r34;
        r41.L$1 = null;
        r41.L$2 = null;
        r41.L$3 = null;
        r41.L$4 = null;
        r41.label = 4;
        if (BuildersKt.withContext(r35, r40, r41) != r10) goto L140;
        return r10;
    L140:
        return r34;
    L99:
        th = th;
        r10 = r10;
        r14 = r111;
        r9 = r32;
        r8 = r210;
    L108:
        MainCoroutineDispatcher r42 = Dispatchers.getMain();
        AnonymousClass6 r43 = new AnonymousClass6(r8, r14, null);
        r9.L$0 = th;
        r9.L$1 = null;
        r9.L$2 = null;
        r9.L$3 = null;
        r9.L$4 = null;
        r9.L$5 = null;
        r9.label = 5;
        if (BuildersKt.withContext(r42, r43, r9) != r10) goto L141;
        return r10;
    L141:
        throw th;
    L114:
        long r112 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L91
        CleanTaskResult r44 = r17.snapshot(r20, r15, r29);     // Catch: Throwable -> L91
        r210 = r8;
        long r45 = SystemClock.elapsedRealtime() - r112;
        long r113 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L88
        Iterator r46 = r29.iterator();     // Catch: Throwable -> L88
    L63:
        if (r46.hasNext() == false) goto L77;
        Iterator r310 = r46;
        RunningState.MergedItem r47 = (RunningState.MergedItem) r46.next();     // Catch: Throwable -> L75
        r47.enSureTaskPersist(r19);     // Catch: Throwable -> L75
        PackageManager r212 = r19;
        if (r47.mIsTaskPersist == true) goto L73;
        r32 = r9;
        RunningStateHelper.getInstance().stopPackage(r47, true);     // Catch: Throwable -> L71
    L74:
        r46 = r310;
        r19 = r212;
        r9 = r32;
    L71:
        th = th;
    L87:
        r8 = r210;
        r9 = r32;
        goto L108
    L73:
        r32 = r9;
    L75:
        th = th;
    L90:
        r10 = r10;
        r8 = r210;
        goto L108
    L77:
        r32 = r9;
        long r48 = SystemClock.elapsedRealtime() - r113;     // Catch: Throwable -> L84
        r111 = r14;
        r20.getSharedPreferences(PREF_NAME, 0).edit().putLong("last_clean_time", System.currentTimeMillis()).apply();     // Catch: Throwable -> L82
        CleanTaskResult r49 = new CleanTaskResult(r15, 0, 0, "0_after_clean", r44.getTotalSize());     // Catch: Throwable -> L82
        HealthScoreLog.INSTANCE.i(r12, "runMemory cleanFinish beforeSize=" + r44.getTotalSize() + " optimizedSize=" + r49.getOptimizedSize() + " score=" + r49.getScore() + " deductScore=" + r49.getDeductScore() + " scoreRange=" + r49.getScoreRange() + " beforeDeductScore=" + r44.getDeductScore() + " beforeScoreRange=" + r44.getScoreRange() + " refreshCostMs=" + r27 + " filterCostMs=" + r30 + " snapshotCostMs=" + r45 + " stopCostMs=" + r48 + " totalCostMs=" + (SystemClock.elapsedRealtime() - r13));     // Catch: Throwable -> L82
        r34 = r49;
    L82:
        th = th;
        r14 = r111;
    L84:
        th = th;
    L88:
        th = th;
    L91:
        th = th;
        r10 = r10;
    L101:
        th = th;
    L27:
        r10 = r10;
    L26:
        th = th;
        goto L27
    L13:
        if (r11 != 3) goto L15;
        ResultKt.throwOnFailure(r3);
        return null;
    L15:
        if (r11 != 4) goto L17;
        CleanTaskResult r50 = (CleanTaskResult) r9.L$0;
        ResultKt.throwOnFailure(r3);
        return r50;
    L17:
        if (r11 != 5) goto L19;
        Throwable r51 = (Throwable) r9.L$0;
        ResultKt.throwOnFailure(r3);
        throw r51;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L28:
        long r52 = r9.J$1;
        r13 = r9.J$0;
        boolean r53 = r9.Z$0;
        int r114 = r9.I$0;
        Ref.ObjectRef r115 = (Ref.ObjectRef) r9.L$5;
        CompletableDeferred r54 = (CompletableDeferred) r9.L$4;
        PackageManager r55 = (PackageManager) r9.L$3;
        RunningState r116 = (RunningState) r9.L$2;
        Context r56 = (Context) r9.L$1;
        MemoryCleanTask r57 = (MemoryCleanTask) r9.L$0;
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L31
        boolean r58 = r53;
        int r59 = r114;
        RunningState r117 = r116;
        r18 = r52;
        final CompletableDeferred r60 = r54;
        r19 = r55;
        Context r61 = r56;
    L122:
        MemoryCleanTask$runMemory$mergedItems$1 r118 = new MemoryCleanTask$runMemory$mergedItems$1(r60, null);     // Catch: Throwable -> L103
        r9.L$0 = r57;     // Catch: Throwable -> L103
        r9.L$1 = r61;     // Catch: Throwable -> L103
        r9.L$2 = r117;     // Catch: Throwable -> L103
        r9.L$3 = r19;     // Catch: Throwable -> L103
        r9.L$4 = r115;     // Catch: Throwable -> L103
        r9.L$5 = null;     // Catch: Throwable -> L103
        r9.I$0 = r59;     // Catch: Throwable -> L103
        r9.Z$0 = r58;     // Catch: Throwable -> L103
        r9.J$0 = r13;     // Catch: Throwable -> L103
        r9.J$1 = r18;     // Catch: Throwable -> L103
        r9.label = 2;     // Catch: Throwable -> L103
        MemoryCleanTask r62 = r57;
        r20 = r61;
        Object r63 = TimeoutKt.withTimeoutOrNull(30000, r118, r9);     // Catch: Throwable -> L103
        if (r63 != r10) goto L45;
        return r10;
    L45:
        r8 = r117;
        r14 = r115;
        r15 = r59;
        r2 = r58;
        r3 = r63;
        r17 = r62;
    L103:
        th = th;
        r8 = r117;
    L105:
        r14 = r115;
    L31:
        th = th;
        r10 = r10;
        r14 = r115;
        r8 = r116;
        goto L108
    L33:
        ResultKt.throwOnFailure(r3);
        r13 = SystemClock.elapsedRealtime();
        final RunningState r64 = this.runningState;
        if (r64 != null) goto L37;
        HealthScoreLog.w$default(HealthScoreLog.INSTANCE, SOURCE, "runMemory ignored runningState=null", null, 4, null);
        return null;
    L37:
        HealthScoreLog.INSTANCE.i(SOURCE, "runMemory start clean=" + r38 + " taskScore=" + r37);
        r19 = r36.getPackageManager();
        r60 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        r115 = new Ref.ObjectRef();
        r115.element = new MemoryCleanTask$runMemory$listener$1(r60, r64);
        r18 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L106
        MainCoroutineDispatcher r119 = Dispatchers.getMain();     // Catch: Throwable -> L106
        AnonymousClass2 r120 = new AnonymousClass2(r64, r115, null);     // Catch: Throwable -> L106
        r9.L$0 = this;     // Catch: Throwable -> L106
        r9.L$1 = r36;     // Catch: Throwable -> L106
        r9.L$2 = r64;     // Catch: Throwable -> L106
        r9.L$3 = r19;     // Catch: Throwable -> L106
        r9.L$4 = r60;     // Catch: Throwable -> L106
        r9.L$5 = r115;     // Catch: Throwable -> L106
        r9.I$0 = r37;     // Catch: Throwable -> L106
        r9.Z$0 = r38;     // Catch: Throwable -> L106
        r9.J$0 = r13;     // Catch: Throwable -> L106
        r9.J$1 = r18;     // Catch: Throwable -> L106
        r9.label = 1;     // Catch: Throwable -> L106
        if (BuildersKt.withContext(r119, r120, r9) != r10) goto L41;
        return r10;
    L41:
        r57 = this;
        r117 = r64;
        r58 = r38;
        r59 = r37;
        r61 = r36;
    L106:
        th = th;
        r8 = r64;
    L7:
        r9 = new C03751(this, r39);
        goto L8
    }

    private final List<RunningState.MergedItem> filterItems(Context r4, List<? extends RunningState.MergedItem> r5) {
        List<RunningState.MergedItem> r3 = RunningStateHelper.getInstance().mergedPackages(r5);
        if (r3 != null) goto L5;
        r3 = CollectionsKt.emptyList();
    L5:
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r3.iterator();
    L7:
        if (r7.hasNext() == false) goto L12;
        Object r0 = r7.next();
        RunningState.MergedItem r1 = (RunningState.MergedItem) r0;
        r1.updateMergeSizeString(r4);
        r1.enSureTaskPersist(r4.getPackageManager());
        if (r1.mIsRecommendClear == false) goto L7;
        r6.add(r0);
        goto L7
    L12:
        return r6;
    }

    private final CleanTaskResult snapshot(Context r13, int r14, List<? extends RunningState.MergedItem> r15) {
        Iterator<T> r16 = r15.iterator();
        long r8 = 0;
    L4:
        if (r16.hasNext() == false) goto L6;
        r8 = r8 + ((RunningState.MergedItem) r16.next()).mMergeSize;
        goto L4
    L6:
        long r4 = r8;
        ScoreDetail r12 = scoreDetail(r14, r4, r13.getSharedPreferences(PREF_NAME, 0).getLong("last_clean_time", 0));
        return new CleanTaskResult(r12.getEarnedScore(), r4, r12.getDeductScore(), r12.getRange(), 0, 16, null);
    }

    private final ScoreDetail scoreDetail(int r7, long r8, long r10) {
        if (r8 > 0) goto L6;
        Pair r9 = TuplesKt.to(0, "0");
    L21:
        int r11 = ((Number) r9.component1()).intValue();
        String r12 = (String) r9.component2();
        int r6 = mapDeductScore(r7, r11);
        if (r6 > 0) goto L30;
        if (r10 <= 0) goto L30;
        if ((System.currentTimeMillis() - r10) >= 300000) goto L30;
        return new ScoreDetail(r7, 0, r12 + "_recent_clean");
    L30:
        return new ScoreDetail(RangesKt.coerceIn(r7 - r6, 0, r7), r6, r12);
    L6:
        if (r8 >= 314572800) goto L9;
        r9 = TuplesKt.to(1, "(0,300MB)");
        goto L21
    L9:
        if (r8 >= 838860800) goto L12;
        r9 = TuplesKt.to(2, "[300MB,800MB)");
        goto L21
    L12:
        if (r8 >= 1610612736) goto L15;
        r9 = TuplesKt.to(3, "[800MB,1.5GB)");
        goto L21
    L15:
        if (r8 >= Constants.SWAP_FEATURE_PROPERTY_SIZE_2G) goto L18;
        r9 = TuplesKt.to(4, "[1.5GB,2GB)");
        goto L21
    L18:
        if (r8 >= 3221225472L) goto L20;
        r9 = TuplesKt.to(5, "[2GB,3GB)");
        goto L21
    L20:
        r9 = TuplesKt.to(6, "[3GB,+)");
        goto L21
    }

    private final int mapDeductScore(int r1, int r2) {
        if (r2 > 0) goto L6;
        return 0;
    L6:
        return RangesKt.coerceIn(MathKt.roundToInt((r2 * r1) / 6), 1, r1);
    }
}
