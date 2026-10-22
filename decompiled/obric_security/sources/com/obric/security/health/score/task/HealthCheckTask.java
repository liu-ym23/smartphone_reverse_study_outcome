package com.obric.security.health.score.task;

import android.content.Context;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.obric.security.health.model.HealthCheckResult;
import com.obric.security.health.model.HealthCheckStatus;
import com.obric.security.health.model.HealthFixCapability;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HealthCheckTask.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J!\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0019\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J!\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/obric/security/health/score/task/HealthCheckTask;", "", "()V", "defaultScore", "", "getDefaultScore", "()I", "fixCapability", "Lcom/obric/security/health/model/HealthFixCapability;", "getFixCapability", "()Lcom/obric/security/health/model/HealthFixCapability;", SlardarConfigConsts.CONFIG_ID, "", "getId", "()Ljava/lang/String;", "moduleId", "getModuleId", "check", "Lcom/obric/security/health/model/HealthCheckResult;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "taskScore", "(Landroid/content/Context;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreate", "", "onDestroy", "optimize", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public abstract class HealthCheckTask {
    public Object check(Context r1, int r2, Continuation<? super HealthCheckResult> r3) {
        return check$suspendImpl(this, r1, r2, r3);
    }

    protected Object check(Context r1, Continuation<? super HealthCheckResult> r2) {
        return check$suspendImpl(this, r1, r2);
    }

    public abstract int getDefaultScore();

    public abstract HealthFixCapability getFixCapability();

    public abstract String getId();

    public abstract String getModuleId();

    public void onCreate(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    public void onDestroy(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    public Object optimize(Context r1, int r2, Continuation<? super HealthCheckResult> r3) {
        return optimize$suspendImpl(this, r1, r2, r3);
    }

    protected Object optimize(Context r1, Continuation<? super HealthCheckResult> r2) {
        return optimize$suspendImpl(this, r1, r2);
    }

    public HealthCheckTask() {
    }

    static /* synthetic */ Object check$suspendImpl(HealthCheckTask r0, Context r1, int r2, Continuation r3) {
        return r0.check(r1, r3);
    }

    static /* synthetic */ Object check$suspendImpl(HealthCheckTask r7, Context r8, Continuation r9) {
        return new HealthCheckResult(r7.getId(), HealthCheckStatus.UNSUPPORTED, "check unsupported", null, 8, null);
    }

    static /* synthetic */ Object optimize$suspendImpl(HealthCheckTask r0, Context r1, int r2, Continuation r3) {
        return r0.optimize(r1, r3);
    }

    static /* synthetic */ Object optimize$suspendImpl(HealthCheckTask r7, Context r8, Continuation r9) {
        return new HealthCheckResult(r7.getId(), HealthCheckStatus.UNSUPPORTED, "optimize unsupported", null, 8, null);
    }
}
