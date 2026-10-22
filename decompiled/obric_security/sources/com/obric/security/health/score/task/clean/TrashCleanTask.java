package com.obric.security.health.score.task.clean;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.obric.security.cleaner.trashclear.CleanStatusCallBack;
import com.obric.security.cleaner.trashclear.ScanStatusCallBack;
import com.obric.security.cleaner.trashclear.TcTrashClearHelper;
import com.obric.security.health.model.HealthCheckResult;
import com.obric.security.health.model.HealthCheckStatus;
import com.obric.security.health.model.HealthFixCapability;
import com.obric.security.health.score.HealthEvidenceKeys;
import com.obric.security.health.score.HealthModuleIds;
import com.obric.security.health.score.HealthScoreLog;
import com.obric.security.health.score.HealthTaskIds;
import com.obric.security.health.score.task.HealthCheckTask;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import tmsdk.fg.module.cleanV2.RubbishEntity;
import tmsdk.fg.module.cleanV2.RubbishHolder;

/* JADX INFO: compiled from: TrashCleanTask.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ#\u0010\u001d\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001e\u001a\u00020\u00102\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0002J!\u0010\"\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ+\u0010#\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020$H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%J#\u0010&\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0018\u0010'\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0010H\u0002J\u0018\u0010*\u001a\u00020+2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0002J\u0018\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lcom/obric/security/health/score/task/clean/TrashCleanTask;", "Lcom/obric/security/health/score/task/HealthCheckTask;", "()V", "defaultScore", "", "getDefaultScore", "()I", "fixCapability", "Lcom/obric/security/health/model/HealthFixCapability;", "getFixCapability", "()Lcom/obric/security/health/model/HealthFixCapability;", SlardarConfigConsts.CONFIG_ID, "", "getId", "()Ljava/lang/String;", "lastScanFinishedAt", "", "lastScanResult", "Lcom/obric/security/health/score/task/clean/CleanTaskResult;", "moduleId", "getModuleId", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "check", "Lcom/obric/security/health/model/HealthCheckResult;", "context", "Landroid/content/Context;", "taskScore", "(Landroid/content/Context;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", HealthModuleIds.CLEAN, "getSuggestSize", "rubbishList", "", "Ltmsdk/fg/module/cleanV2/RubbishEntity;", "optimize", "runTrash", "", "(Landroid/content/Context;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scan", "scoreDetail", "Lcom/obric/security/health/score/task/clean/TrashCleanTask$ScoreDetail;", PerfConsts.PERF_DISK_FILE_SIZE, "setSuggestStatus", "", "snapshot", "helper", "Lcom/obric/security/cleaner/trashclear/TcTrashClearHelper;", "Companion", "ScoreDetail", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class TrashCleanTask extends HealthCheckTask {

    @Deprecated
    private static final int BASE_SCORE = 6;
    private static final Companion Companion = null;

    @Deprecated
    private static final long HIGHEST_TRASH_SIZE = 1073741824;

    @Deprecated
    private static final long HIGH_TRASH_SIZE = 524288000;

    @Deprecated
    private static final long LOW_TRASH_SIZE = 209715200;

    @Deprecated
    private static final long RESULT_CACHE_WINDOW_MS = 2000;

    @Deprecated
    private static final long SIZE_MB = 1048576;

    @Deprecated
    private static final String SOURCE = "TrashCleanTask";

    @Deprecated
    private static final long TRASH_TIMEOUT_MS = 60000;
    private final int defaultScore;
    private final HealthFixCapability fixCapability;
    private final String id;
    private long lastScanFinishedAt;
    private CleanTaskResult lastScanResult;
    private final String moduleId;
    private final Mutex mutex;

    /* JADX INFO: compiled from: TrashCleanTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/security/health/score/task/clean/TrashCleanTask$Companion;", "", "()V", "BASE_SCORE", "", "HIGHEST_TRASH_SIZE", "", "HIGH_TRASH_SIZE", "LOW_TRASH_SIZE", "RESULT_CACHE_WINDOW_MS", "SIZE_MB", "SOURCE", "", "TRASH_TIMEOUT_MS", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: TrashCleanTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/security/health/score/task/clean/TrashCleanTask$ScoreDetail;", "", "earnedScore", "", "deductScore", "range", "", "(IILjava/lang/String;)V", "getDeductScore", "()I", "getEarnedScore", "getRange", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
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

    /* JADX INFO: renamed from: com.obric.security.health.score.task.clean.TrashCleanTask$check$1, reason: invalid class name */
    /* JADX INFO: compiled from: TrashCleanTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096@"}, d2 = {"check", "", "context", "Landroid/content/Context;", "taskScore", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/security/health/model/HealthCheckResult;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.clean.TrashCleanTask", f = "TrashCleanTask.kt", i = {0, 0}, l = {38}, m = "check", n = {"this", "taskScore"}, s = {"L$0", "I$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TrashCleanTask this$0;

        AnonymousClass1(TrashCleanTask r1, Continuation r2) {
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

    /* JADX INFO: renamed from: com.obric.security.health.score.task.clean.TrashCleanTask$clean$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TrashCleanTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0082@"}, d2 = {HealthModuleIds.CLEAN, "", "context", "Landroid/content/Context;", "taskScore", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/security/health/score/task/clean/CleanTaskResult;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.clean.TrashCleanTask", f = "TrashCleanTask.kt", i = {0, 0, 0, 0, 1, 1}, l = {279, 95}, m = HealthModuleIds.CLEAN, n = {"this", "context", "$this$withLock_u24default$iv", "taskScore", "this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1"})
    static final class C03771 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TrashCleanTask this$0;

        C03771(TrashCleanTask r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return TrashCleanTask.access$clean(this.this$0, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.clean.TrashCleanTask$optimize$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TrashCleanTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096@"}, d2 = {"optimize", "", "context", "Landroid/content/Context;", "taskScore", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/security/health/model/HealthCheckResult;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.clean.TrashCleanTask", f = "TrashCleanTask.kt", i = {0, 0}, l = {58}, m = "optimize", n = {"this", "taskScore"}, s = {"L$0", "I$0"})
    static final class C03781 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TrashCleanTask this$0;

        C03781(TrashCleanTask r1, Continuation r2) {
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

    /* JADX INFO: renamed from: com.obric.security.health.score.task.clean.TrashCleanTask$runTrash$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TrashCleanTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0082@"}, d2 = {"runTrash", "", "context", "Landroid/content/Context;", "taskScore", "", HealthModuleIds.CLEAN, "", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/security/health/score/task/clean/CleanTaskResult;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.clean.TrashCleanTask", f = "TrashCleanTask.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {142, 167}, m = "runTrash", n = {"this", "helper", "cleanDeferred", "scanCallback", "cleanCallback", "taskScore", HealthModuleIds.CLEAN, "totalStartAt", "scanStartAt", "this", "helper", "scanCallback", "cleanCallback", "beforeClean", "taskScore", "totalStartAt", "scanCostMs", "beforeSnapshotCostMs", "cleanStartAt"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "Z$0", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "J$0", "J$1", "J$2", "J$3"})
    static final class C03791 extends ContinuationImpl {
        int I$0;
        long J$0;
        long J$1;
        long J$2;
        long J$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TrashCleanTask this$0;

        C03791(TrashCleanTask r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return TrashCleanTask.access$runTrash(this.this$0, null, 0, false, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.clean.TrashCleanTask$runTrash$2, reason: invalid class name */
    /* JADX INFO: compiled from: TrashCleanTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.clean.TrashCleanTask$runTrash$2", f = "TrashCleanTask.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletableDeferred $scanDeferred;
        int label;

        AnonymousClass2(CompletableDeferred r1, Continuation r2) {
            this.$scanDeferred = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "completion");
            return new AnonymousClass2(this.$scanDeferred, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            CompletableDeferred r5 = this.$scanDeferred;
            this.label = 1;
            if (r5.await(this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.clean.TrashCleanTask$runTrash$4, reason: invalid class name */
    /* JADX INFO: compiled from: TrashCleanTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.clean.TrashCleanTask$runTrash$4", f = "TrashCleanTask.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletableDeferred $cleanDeferred;
        int label;

        AnonymousClass4(CompletableDeferred r1, Continuation r2) {
            this.$cleanDeferred = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "completion");
            return new AnonymousClass4(this.$cleanDeferred, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass4) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            CompletableDeferred r5 = this.$cleanDeferred;
            this.label = 1;
            if (r5.await(this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.score.task.clean.TrashCleanTask$scan$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TrashCleanTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0082@"}, d2 = {"scan", "", "context", "Landroid/content/Context;", "taskScore", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/obric/security/health/score/task/clean/CleanTaskResult;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.health.score.task.clean.TrashCleanTask", f = "TrashCleanTask.kt", i = {0, 0, 0, 0, 1, 1}, l = {269, 84}, m = "scan", n = {"this", "context", "$this$withLock_u24default$iv", "taskScore", "this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1"})
    static final class C03801 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TrashCleanTask this$0;

        C03801(TrashCleanTask r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return TrashCleanTask.access$scan(this.this$0, null, 0, this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TrashCleanTask() {
        this.id = HealthTaskIds.TRASH_LESS;
        this.moduleId = HealthModuleIds.CLEAN;
        this.defaultScore = 6;
        this.fixCapability = HealthFixCapability.AUTO;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
    }

    public static final /* synthetic */ Object access$clean(TrashCleanTask r0, Context r1, int r2, Continuation r3) {
        return r0.clean(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$runTrash(TrashCleanTask r0, Context r1, int r2, boolean r3, Continuation r4) {
        return r0.runTrash(r1, r2, r3, r4);
    }

    public static final /* synthetic */ Object access$scan(TrashCleanTask r0, Context r1, int r2, Continuation r3) {
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
    public Object check(Context r23, int r24, Continuation<? super HealthCheckResult> r25) {
        TrashCleanTask r0 = this;
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
        TrashCleanTask r7 = (TrashCleanTask) r3.L$0;
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
        return new HealthCheckResult(r15, r9, null, MapsKt.mapOf(new Pair[]{TuplesKt.to(HealthEvidenceKeys.EARNED_SCORE, String.valueOf(r8.getScore())), TuplesKt.to("trash_earned_score", String.valueOf(r8.getScore())), TuplesKt.to("trash_deduct_score", String.valueOf(r1 - r8.getScore())), TuplesKt.to("trash_score_range", r8.getScoreRange()), TuplesKt.to(HealthEvidenceKeys.TRASH_SIZE, String.valueOf(r8.getTotalSize())), TuplesKt.to(HealthEvidenceKeys.OPTIMIZED_SIZE, String.valueOf(r8.getOptimizedSize()))}), 4, null);
    L24:
        r9 = HealthCheckStatus.FAIL;
        goto L26
    L20:
        return new HealthCheckResult(r0.getId(), HealthCheckStatus.ERROR, "trash scan timeout", null, 8, null);
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
        TrashCleanTask r0 = this;
        int r1 = r24;
        if ((r25 instanceof C03781) == false) goto L7;
        C03781 r3 = (C03781) r25;
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        int r6 = r3.I$0;
        TrashCleanTask r7 = (TrashCleanTask) r3.L$0;
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
        return new HealthCheckResult(r15, r9, null, MapsKt.mapOf(new Pair[]{TuplesKt.to(HealthEvidenceKeys.EARNED_SCORE, String.valueOf(r8.getScore())), TuplesKt.to("trash_earned_score", String.valueOf(r8.getScore())), TuplesKt.to("trash_deduct_score", String.valueOf(r1 - r8.getScore())), TuplesKt.to("trash_score_range", r8.getScoreRange()), TuplesKt.to(HealthEvidenceKeys.TRASH_SIZE, String.valueOf(r8.getTotalSize())), TuplesKt.to(HealthEvidenceKeys.OPTIMIZED_SIZE, String.valueOf(r8.getOptimizedSize()))}), 4, null);
    L24:
        r9 = HealthCheckStatus.FAIL;
        goto L26
    L20:
        return new HealthCheckResult(r0.getId(), HealthCheckStatus.ERROR, "trash clean timeout", null, 8, null);
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
        r3 = new C03781(r0, r25);
        goto L8
    }

    private final Object scan(Context r13, int r14, Continuation<? super CleanTaskResult> r15) {
        if ((r15 instanceof C03801) == false) goto L7;
        C03801 r1 = (C03801) r15;
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
        TrashCleanTask r17 = (TrashCleanTask) r1.L$0;
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
        TrashCleanTask r5 = (TrashCleanTask) r1.L$0;
        ResultKt.throwOnFailure(r16);
        r18 = r19;
        TrashCleanTask this = r5;
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
        Object r111 = this.runTrash(r110, r14, false, r1);     // Catch: Throwable -> L38
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
        r1 = new C03801(this, r15);
        goto L8
    }

    private final Object clean(Context r8, int r9, Continuation<? super CleanTaskResult> r10) {
        if ((r10 instanceof C03771) == false) goto L7;
        C03771 r0 = (C03771) r10;
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
        TrashCleanTask r12 = (TrashCleanTask) r0.L$0;
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
        TrashCleanTask r3 = (TrashCleanTask) r0.L$0;
        ResultKt.throwOnFailure(r11);
        Mutex r15 = r14;
        TrashCleanTask this = r3;
    L36:
        Context r16 = r8.getApplicationContext();     // Catch: Throwable -> L32
        Intrinsics.checkNotNullExpressionValue(r16, "context.applicationContext");     // Catch: Throwable -> L32
        r0.L$0 = this;     // Catch: Throwable -> L32
        r0.L$1 = r15;     // Catch: Throwable -> L32
        r0.L$2 = null;     // Catch: Throwable -> L32
        r0.label = 2;     // Catch: Throwable -> L32
        Object r17 = this.runTrash(r16, r9, true, r0);     // Catch: Throwable -> L32
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
        r0 = new C03771(this, r10);
        goto L8
    }

    private final Object runTrash(Context r52, int r53, boolean r54, Continuation<? super CleanTaskResult> r55) {
        boolean r2 = r54;
        String r10 = "runTrash scanTimeout clean=";
        if ((r55 instanceof C03791) == false) goto L7;
        C03791 r11 = (C03791) r55;
        if ((r11.label & Integer.MIN_VALUE) == 0) goto L7;
        r11.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r11.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r11.label;
        String r14 = " score=";
        if (r13 != 0) goto L11;
        ResultKt.throwOnFailure(r3);
        long r4 = SystemClock.elapsedRealtime();
        String r26 = " totalCostMs=";
        String r27 = " scanCostMs=";
        TcTrashClearHelper r6 = TcTrashClearHelper.Companion.getInstance(r52, "HealthTrashCleanTask");
        if (r6 != null) goto L30;
        return null;
    L30:
        HealthScoreLog.INSTANCE.i(SOURCE, "runTrash start clean=" + r2 + " taskScore=" + r53 + " canDeepScan=" + r6.canDeepScan());
        final CompletableDeferred r15 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        final CompletableDeferred r5 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        ScanStatusCallBack r9 = new TrashCleanTask$runTrash$scanCallback$1(r15);
        CleanStatusCallBack r16 = new TrashCleanTask$runTrash$cleanCallback$1(r5);
        long r7 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L91
        if (r6.canDeepScan() == false) goto L34;
        r6.deepScan(r9, false);     // Catch: Throwable -> L91
    L35:
        AnonymousClass2 r17 = new AnonymousClass2(r15, null);     // Catch: Throwable -> L91
        r11.L$0 = this;     // Catch: Throwable -> L91
        r11.L$1 = r6;     // Catch: Throwable -> L91
        r11.L$2 = r5;     // Catch: Throwable -> L91
        r11.L$3 = r9;     // Catch: Throwable -> L91
        r11.L$4 = r16;     // Catch: Throwable -> L91
        r11.I$0 = r53;     // Catch: Throwable -> L91
        r11.Z$0 = r2;     // Catch: Throwable -> L91
        r11.J$0 = r4;     // Catch: Throwable -> L91
        r11.J$1 = r7;     // Catch: Throwable -> L91
        boolean r18 = true;
        r11.label = 1;     // Catch: Throwable -> L91
        Object r19 = TimeoutKt.withTimeoutOrNull(60000, r17, r11);     // Catch: Throwable -> L91
        if (r19 != r12) goto L38;
        return r12;
    L38:
        TrashCleanTask r0 = this;
        CleanStatusCallBack r1 = r16;
        TcTrashClearHelper r110 = r6;
        ScanStatusCallBack r8 = r9;
        int r20 = r53;
    L100:
    L88:
        th = th;
    L90:
        ScanStatusCallBack r21 = r8;
        r6 = r110;
    L93:
        r6.removeScanStatusCallBack(r21);
        r6.removeCleanStatusCallBack(r1);
        throw th;
    L97:
        if (((Unit) r19) != null) goto L50;
        TrashCleanTask r22 = r0;     // Catch: Throwable -> L48
        HealthScoreLog r111 = HealthScoreLog.INSTANCE;     // Catch: Throwable -> L48
        StringBuilder r23 = new StringBuilder(r10);     // Catch: Throwable -> L48
        if (r2 == true) goto L45;
        r18 = false;
    L45:
        HealthScoreLog.w$default(r111, SOURCE, r23.append(r18).toString(), null, 4, null);     // Catch: Throwable -> L48
        r110.removeScanStatusCallBack(r8);
        r110.removeCleanStatusCallBack(r1);
        return null;
    L50:
        long r24 = SystemClock.elapsedRealtime() - r7;     // Catch: Throwable -> L88
        long r112 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L88
        CleanTaskResult r113 = r0.snapshot(r110, r20);     // Catch: Throwable -> L88
        long r114 = SystemClock.elapsedRealtime() - r112;
        if (r2 == true) goto L56;
        HealthScoreLog.INSTANCE.i(SOURCE, "runTrash scanFinish totalSize=" + r113.getTotalSize() + r14 + r113.getScore() + " deductScore=" + r113.getDeductScore() + " scoreRange=" + r113.getScoreRange() + r27 + r24 + " snapshotCostMs=" + r114 + r26 + (SystemClock.elapsedRealtime() - r4));     // Catch: Throwable -> L48
        r110.removeScanStatusCallBack(r8);
        r110.removeCleanStatusCallBack(r1);
        return r113;
    L56:
        String r36 = r26;
        String r38 = r27;
        RubbishHolder r25 = r110.deepScanCallBack.currentRubbish;     // Catch: Throwable -> L88
        if (r25 != null) goto L63;
        CleanTaskResult r28 = r0.snapshot(r110, r20);     // Catch: Throwable -> L48
        r110.removeScanStatusCallBack(r8);
        r110.removeCleanStatusCallBack(r1);
        return r28;
    L63:
        r0.setSuggestStatus(r110.getSoftCacheRubbish());     // Catch: Throwable -> L88
        r0.setSuggestStatus(r110.getUninstallRubbish());     // Catch: Throwable -> L88
        r0.setSuggestStatus(r110.getApkRubbish());     // Catch: Throwable -> L88
        r0.setSuggestStatus(r110.getSystemRubbish());     // Catch: Throwable -> L88
        long r115 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L88
        r110.cleanRubbish(r25, r1);     // Catch: Throwable -> L88
        AnonymousClass4 r29 = new AnonymousClass4(r5, null);     // Catch: Throwable -> L88
        r11.L$0 = r0;     // Catch: Throwable -> L88
        r11.L$1 = r110;     // Catch: Throwable -> L88
        r11.L$2 = r8;     // Catch: Throwable -> L88
        r11.L$3 = r1;     // Catch: Throwable -> L88
        r11.L$4 = r113;     // Catch: Throwable -> L88
        r11.I$0 = r20;     // Catch: Throwable -> L88
        r11.J$0 = r4;     // Catch: Throwable -> L88
        r11.J$1 = r24;     // Catch: Throwable -> L88
        TrashCleanTask r56 = r0;
        CleanStatusCallBack r57 = r1;
        r11.J$2 = r114;     // Catch: Throwable -> L86
        r11.J$3 = r115;     // Catch: Throwable -> L86
        r11.label = 2;     // Catch: Throwable -> L86
        Object r30 = TimeoutKt.withTimeoutOrNull(60000, r29, r11);     // Catch: Throwable -> L86
        if (r30 != r12) goto L69;
        return r12;
    L69:
        r1 = r57;
        Object r31 = r30;
        r21 = r8;
        int r32 = r20;
        r6 = r110;
        TrashCleanTask r33 = r56;
        long r116 = r24;
        long r34 = r114;
    L110:
    L84:
        th = th;
        goto L93
    L71:
        if (((Unit) r31) == null) goto L102;
        long r117 = SystemClock.elapsedRealtime() - r115;     // Catch: Throwable -> L84
        long r118 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L84
        CleanTaskResult r35 = CleanTaskResult.copy$default(r33.snapshot(r6, r32), 0, 0, 0, null, r113.getTotalSize(), 15, null);     // Catch: Throwable -> L84
        CleanStatusCallBack r51 = r1;
        HealthScoreLog.INSTANCE.i(SOURCE, "runTrash cleanFinish beforeSize=" + r113.getTotalSize() + " afterSize=" + r35.getTotalSize() + " optimizedSize=" + r35.getOptimizedSize() + r14 + r35.getScore() + " deductScore=" + r35.getDeductScore() + " scoreRange=" + r35.getScoreRange() + r38 + r116 + " beforeSnapshotCostMs=" + r34 + " cleanCostMs=" + r117 + " afterSnapshotCostMs=" + (SystemClock.elapsedRealtime() - r118) + r36 + (SystemClock.elapsedRealtime() - r4));     // Catch: Throwable -> L82
        r6.removeScanStatusCallBack(r21);
        r6.removeCleanStatusCallBack(r51);
        return r35;
    L82:
        th = th;
        r1 = r51;
        goto L93
    L102:
        TrashCleanTask r37 = r33;     // Catch: Throwable -> L75
        HealthScoreLog.w$default(HealthScoreLog.INSTANCE, SOURCE, "runTrash cleanTimeout beforeSize=" + r113.getTotalSize(), null, 4, null);     // Catch: Throwable -> L75
        r6.removeScanStatusCallBack(r21);
        r6.removeCleanStatusCallBack(r1);
        return null;
    L75:
        th = th;
    L86:
        th = th;
        r1 = r57;
    L48:
        th = th;
        goto L90
    L34:
        r9.onScanFinished();     // Catch: Throwable -> L91
    L91:
        th = th;
        r21 = r9;
        r1 = r16;
        goto L93
    L11:
        if (r13 != 1) goto L13;
        long r39 = r11.J$1;
        long r40 = r11.J$0;
        r2 = r11.Z$0;
        r20 = r11.I$0;
        TrashCleanTask$runTrash$cleanCallback$1 r119 = (TrashCleanTask$runTrash$cleanCallback$1) r11.L$4;
        TrashCleanTask$runTrash$scanCallback$1 r41 = (TrashCleanTask$runTrash$scanCallback$1) r11.L$3;
        CompletableDeferred r42 = (CompletableDeferred) r11.L$2;
        TcTrashClearHelper r210 = (TcTrashClearHelper) r11.L$1;
        r0 = (TrashCleanTask) r11.L$0;
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L24
        r10 = "runTrash scanTimeout clean=";
        r14 = " score=";
        r5 = r42;
        r18 = true;
        r7 = r39;
        r19 = r3;
        r26 = " totalCostMs=";
        r4 = r40;
        r8 = r41;
        r1 = r119;
        r110 = r210;
        r27 = " scanCostMs=";
    L24:
        th = th;
        r21 = r41;
        r1 = r119;
        r6 = r210;
        goto L93
    L13:
        if (r13 != 2) goto L20;
        long r43 = r11.J$3;
        r34 = r11.J$2;
        r116 = r11.J$1;
        long r44 = r11.J$0;
        r32 = r11.I$0;
        r113 = (CleanTaskResult) r11.L$4;
        r1 = (TrashCleanTask$runTrash$cleanCallback$1) r11.L$3;
        r21 = (TrashCleanTask$runTrash$scanCallback$1) r11.L$2;
        TcTrashClearHelper r211 = (TcTrashClearHelper) r11.L$1;
        r33 = (TrashCleanTask) r11.L$0;
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L17
        r36 = " totalCostMs=";
        r38 = " scanCostMs=";
        r14 = " score=";
        r115 = r43;
        r6 = r211;
        r31 = r3;
        r4 = r44;
    L17:
        th = th;
        r6 = r211;
        goto L93
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r11 = new C03791(this, r55);
        goto L8
    }

    private final CleanTaskResult snapshot(TcTrashClearHelper r16, int r17) {
        long r7 = ((getSuggestSize(r16.getSoftCacheRubbish()) + getSuggestSize(r16.getUninstallRubbish())) + getSuggestSize(r16.getApkRubbish())) + getSuggestSize(r16.getSystemRubbish());
        ScoreDetail r0 = scoreDetail(r17, r7);
        return new CleanTaskResult(r0.getEarnedScore(), r7, r0.getDeductScore(), r0.getRange(), 0, 16, null);
    }

    private final void setSuggestStatus(Collection<? extends RubbishEntity> r2) {
        if (r2 == null) goto L7;
        Iterator<T> r1 = r2.iterator();
    L5:
        if (r1.hasNext() == false) goto L9;
        RubbishEntity r3 = (RubbishEntity) r1.next();
        r3.setStatus(r3.isSuggest() ? 1 : 0);
        goto L5
    L9:
        return;
    }

    private final long getSuggestSize(List r5) {
        if (r5 != null) goto L4;
        r5 = CollectionsKt.emptyList();
    L4:
        ArrayList r4 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        Object r0 = r6.next();
        if (((RubbishEntity) r0).isSuggest() == false) goto L6;
        r4.add(r0);
        goto L6
    L10:
        Iterator r7 = r4.iterator();
        long r1 = 0;
    L12:
        if (r7.hasNext() == false) goto L14;
        r1 = r1 + ((RubbishEntity) r7.next()).getSize();
        goto L12
    L14:
        return r1;
    }

    private final ScoreDetail scoreDetail(int r6, long r7) {
        if (r7 > 0) goto L6;
        Pair r5 = TuplesKt.to(0, "0");
    L15:
        int r8 = ((Number) r5.component1()).intValue();
        String r9 = (String) r5.component2();
        if (r8 > 0) goto L18;
        int r10 = 0;
    L20:
        return new ScoreDetail(RangesKt.coerceIn(r6 - r10, 0, r6), r10, r9);
    L18:
        r10 = RangesKt.coerceIn(MathKt.roundToInt((r8 * r6) / 6), 1, r6);
        goto L20
    L6:
        if (r7 >= LOW_TRASH_SIZE) goto L9;
        r5 = TuplesKt.to(1, "(0,200MB)");
        goto L15
    L9:
        if (r7 >= HIGH_TRASH_SIZE) goto L12;
        r5 = TuplesKt.to(3, "[200MB,500MB)");
        goto L15
    L12:
        if (r7 >= 1073741824) goto L14;
        r5 = TuplesKt.to(4, "[500MB,1GB)");
        goto L15
    L14:
        r5 = TuplesKt.to(6, "[1GB,+)");
        goto L15
    }
}
