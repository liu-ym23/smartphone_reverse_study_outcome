package com.obric.security.health.engine;

import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.security.health.model.HealthCheckResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HealthTaskManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\tJ \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/obric/security/health/engine/HealthTaskListener;", "", "onAllFinish", "", "stage", "Lcom/obric/security/health/engine/HealthTaskStage;", ApkVirusCheckProvider.KEY_RESULTS, "", "Lcom/obric/security/health/model/HealthCheckResult;", "(Lcom/obric/security/health/engine/HealthTaskStage;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onTaskFinish", "itemId", "", "result", "onTaskStart", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface HealthTaskListener {

    /* JADX INFO: compiled from: HealthTaskManager.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onTaskFinish(HealthTaskListener r0, String r1, HealthTaskStage r2, HealthCheckResult r3) {
            Intrinsics.checkNotNullParameter(r1, "itemId");
            Intrinsics.checkNotNullParameter(r2, "stage");
            Intrinsics.checkNotNullParameter(r3, "result");
        }

        public static void onTaskStart(HealthTaskListener r0, String r1, HealthTaskStage r2) {
            Intrinsics.checkNotNullParameter(r1, "itemId");
            Intrinsics.checkNotNullParameter(r2, "stage");
        }

        public static Object onAllFinish(HealthTaskListener r0, HealthTaskStage r1, List<HealthCheckResult> r2, Continuation<? super Unit> r3) {
            return Unit.INSTANCE;
        }
    }

    Object onAllFinish(HealthTaskStage r1, List<HealthCheckResult> r2, Continuation<? super Unit> r3);

    void onTaskFinish(String r1, HealthTaskStage r2, HealthCheckResult r3);

    void onTaskStart(String r1, HealthTaskStage r2);
}
