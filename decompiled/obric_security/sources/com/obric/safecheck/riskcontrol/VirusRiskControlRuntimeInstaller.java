package com.obric.safecheck.riskcontrol;

import android.content.Context;
import com.obric.safecheck.riskcontrol.ui.RiskControlRuntimeDependencies;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VirusRiskControlRuntimeInstaller.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/obric/safecheck/riskcontrol/VirusRiskControlRuntimeInstaller;", "", "()V", "install", "", "context", "Landroid/content/Context;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class VirusRiskControlRuntimeInstaller {
    public static final VirusRiskControlRuntimeInstaller INSTANCE = null;

    static {
        INSTANCE = new VirusRiskControlRuntimeInstaller();
    }

    private VirusRiskControlRuntimeInstaller() {
    }

    @JvmStatic
    public static final void install(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        RiskControlRuntimeDependencies.INSTANCE.setRepositoryFactory(AnonymousClass1.INSTANCE);
        RiskControlRuntimeDependencies r0 = RiskControlRuntimeDependencies.INSTANCE;
        Context r3 = r2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context.applicationContext");
        r0.ensureInitialized(r3);
    }
}
