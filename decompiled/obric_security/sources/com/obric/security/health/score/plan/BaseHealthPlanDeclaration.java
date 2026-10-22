package com.obric.security.health.score.plan;

import com.obric.security.health.score.HealthModuleIds;
import com.obric.security.health.score.task.AccountLoginTask;
import com.obric.security.health.score.task.AutoUpdateTask;
import com.obric.security.health.score.task.DeveloperModeOffTask;
import com.obric.security.health.score.task.FindDeviceEnabledTask;
import com.obric.security.health.score.task.FingerprintRecommendTask;
import com.obric.security.health.score.task.HealthCheckTask;
import com.obric.security.health.score.task.PrivacyProtectionTask;
import com.obric.security.health.score.task.RecentSafeCheckTask;
import com.obric.security.health.score.task.RiskBehaviorProtectionTask;
import com.obric.security.health.score.task.RootFreeTask;
import com.obric.security.health.score.task.SafeCheckRiskAppTask;
import com.obric.security.health.score.task.SmsVerificationCodeTask;
import com.obric.security.health.score.task.SystemLatestTask;
import com.obric.security.health.score.task.VirusDbAutoUpdateTask;
import com.obric.security.health.score.task.clean.MemoryCleanTask;
import com.obric.security.health.score.task.clean.TrashCleanTask;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: BaseHealthPlanDeclaration.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¨\u0006\b"}, d2 = {"Lcom/obric/security/health/score/plan/BaseHealthPlanDeclaration;", "", "()V", "createModules", "", "Lcom/obric/security/health/score/plan/HealthModulePlanItem;", "createTasks", "Lcom/obric/security/health/score/task/HealthCheckTask;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class BaseHealthPlanDeclaration {
    public static final BaseHealthPlanDeclaration INSTANCE = null;

    static {
        INSTANCE = new BaseHealthPlanDeclaration();
    }

    private BaseHealthPlanDeclaration() {
    }

    public final List<HealthModulePlanItem> createModules() {
        return CollectionsKt.listOf(new HealthModulePlanItem[]{new HealthModulePlanItem(HealthModuleIds.SECURITY), new HealthModulePlanItem(HealthModuleIds.CLEAN), new HealthModulePlanItem(HealthModuleIds.UPDATE)});
    }

    public final List<HealthCheckTask> createTasks() {
        return CollectionsKt.listOf(new HealthCheckTask[]{new SafeCheckRiskAppTask(), new RecentSafeCheckTask(), new RiskBehaviorProtectionTask(), new VirusDbAutoUpdateTask(), new FindDeviceEnabledTask(), new DeveloperModeOffTask(), new RootFreeTask(), new FingerprintRecommendTask(), new PrivacyProtectionTask(), new SmsVerificationCodeTask(), new MemoryCleanTask(), new TrashCleanTask(), new AccountLoginTask(), new SystemLatestTask(), new AutoUpdateTask()});
    }
}
