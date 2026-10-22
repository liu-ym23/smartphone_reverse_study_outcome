package com.obric.safecheck.riskcontrol.ui;

import android.content.Context;
import com.obric.safecheck.riskcontrol.api.repo.RiskAppControlRepository;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RiskControlRuntimeDependencies.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/obric/safecheck/riskcontrol/api/repo/RiskAppControlRepository;", "p1", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class RiskControlRuntimeDependencies$repositoryFactory$1 extends FunctionReferenceImpl implements Function1<Context, RiskAppControlRepository> {
    RiskControlRuntimeDependencies$repositoryFactory$1(RiskControlRuntimeDependencies r8) {
        super(1, r8, RiskControlRuntimeDependencies.class, "missingRepositoryFactory", "missingRepositoryFactory(Landroid/content/Context;)Lcom/obric/safecheck/riskcontrol/api/repo/RiskAppControlRepository;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ RiskAppControlRepository invoke(Context r1) {
        return invoke2(r1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final RiskAppControlRepository invoke2(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        return RiskControlRuntimeDependencies.access$missingRepositoryFactory((RiskControlRuntimeDependencies) this.receiver, r2);
    }
}
