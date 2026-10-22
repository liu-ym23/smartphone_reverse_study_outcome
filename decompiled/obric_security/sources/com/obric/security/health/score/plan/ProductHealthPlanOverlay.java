package com.obric.security.health.score.plan;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProductHealthPlanOverlay.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/security/health/score/plan/ProductHealthPlanOverlay;", "Lcom/obric/security/health/score/plan/HealthPlanOverlay;", "()V", "apply", "", "builder", "Lcom/obric/security/health/score/plan/HealthPlanBuilder;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductHealthPlanOverlay implements HealthPlanOverlay {
    @Override // com.obric.security.health.score.plan.HealthPlanOverlay
    public void apply(HealthPlanBuilder r1) {
        Intrinsics.checkNotNullParameter(r1, "builder");
    }

    public ProductHealthPlanOverlay() {
    }
}
