package com.obric.security.health.score.plan;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: HealthPlanCompiler.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/security/health/score/plan/HealthPlanCompiler;", "", "()V", "MAX_SCORE", "", "compile", "Lcom/obric/security/health/score/plan/HealthPlan;", "validate", "", "plan", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthPlanCompiler {
    public static final HealthPlanCompiler INSTANCE = null;
    private static final int MAX_SCORE = 100;

    static {
        INSTANCE = new HealthPlanCompiler();
    }

    private HealthPlanCompiler() {
    }

    public final HealthPlan compile() {
        HealthPlanBuilder r0 = new HealthPlanBuilder(BaseHealthPlanDeclaration.INSTANCE.createModules(), BaseHealthPlanDeclaration.INSTANCE.createTasks());
        new ProductHealthPlanOverlay().apply(r0);
        new RegionHealthPlanOverlay().apply(r0);
        HealthPlan r1 = r0.build();
        validate(r1);
        return r1;
    }

    private final void validate(HealthPlan r10) {
        Iterator<T> r9 = r10.getTasks().iterator();
        boolean r0 = false;
        int r1 = 0;
    L4:
        if (r9.hasNext() == false) goto L7;
        r1 = r1 + ((HealthTaskPlanItem) r9.next()).getScore();
        goto L4
    L7:
        if (r1 != 100) goto L9;
        r0 = true;
    L9:
        if (r0 == false) goto L12;
        return;
    L12:
        throw new IllegalArgumentException(("Health task scores must sum to 100, actual=" + r1 + ", tasks=" + CollectionsKt.joinToString$default(r10.getTasks(), null, null, null, 0, null, HealthPlanCompiler$validate$1$1.INSTANCE, 31, null)).toString());
    }
}
