package com.obric.security.health.score.presentation;

import com.obric.security.R;
import com.obric.security.health.model.HealthCheckItemPresentation;
import com.obric.security.health.model.HealthModulePresentation;
import com.obric.security.health.score.HealthModuleIds;
import com.obric.security.health.score.HealthTaskIds;
import com.obric.security.health.score.plan.HealthModulePlanItem;
import com.obric.security.health.score.plan.HealthTaskPlanItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HealthTaskPresentationProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\fJ\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\nH\u0002¨\u0006\u0013"}, d2 = {"Lcom/obric/security/health/score/presentation/HealthTaskPresentationProvider;", "", "()V", "itemPresentationOf", "Lcom/obric/security/health/model/HealthCheckItemPresentation;", "item", "Lcom/obric/security/health/score/plan/HealthTaskPlanItem;", "itemTextOf", "Lcom/obric/security/health/score/presentation/HealthItemTextPresentation;", "itemId", "", "modulePresentations", "", "Lcom/obric/security/health/model/HealthModulePresentation;", "modules", "Lcom/obric/security/health/score/plan/HealthModulePlanItem;", "presentations", "moduleTemplateOf", "moduleId", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthTaskPresentationProvider {
    public HealthTaskPresentationProvider() {
    }

    public final HealthCheckItemPresentation itemPresentationOf(HealthTaskPlanItem r11) {
        Intrinsics.checkNotNullParameter(r11, "item");
        HealthItemTextPresentation r10 = itemTextOf(r11.getId());
        return new HealthCheckItemPresentation(r11.getId(), r11.getModuleId(), r10.getTitleResId(), r10.getCompletedTitleResId(), r10.getProblemTitleResId(), r10.getActionTextResId(), r11.getScore(), r11.getTask().getFixCapability());
    }

    public final List<HealthModulePresentation> modulePresentations(List<HealthModulePlanItem> r12, List<HealthCheckItemPresentation> r13) {
        Intrinsics.checkNotNullParameter(r12, "modules");
        Intrinsics.checkNotNullParameter(r13, "presentations");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<T> r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L9;
        Object r1 = r14.next();
        String r2 = ((HealthCheckItemPresentation) r1).getModuleId();
        Object r3 = r0.get(r2);
        if (r3 != null) goto L8;
        r3 = (List) new ArrayList();
        r0.put(r2, r3);
    L8:
        ((List) r3).add(r1);
        goto L4
    L9:
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r12.iterator();
    L11:
        if (r16.hasNext() == false) goto L26;
        HealthModulePlanItem r4 = (HealthModulePlanItem) r16.next();
        HealthModulePresentation r5 = moduleTemplateOf(r4.getId());
        List r6 = (List) r0.get(r4.getId());
        if (r6 != null) goto L15;
        r6 = CollectionsKt.emptyList();
    L15:
        List r8 = r6;
        if (r8.isEmpty() == false) goto L18;
        HealthModulePresentation r7 = null;
    L23:
        if (r7 == null) goto L11;
        r15.add(r7);
        goto L11
    L18:
        Iterator r9 = r8.iterator();
        int r10 = 0;
    L20:
        if (r9.hasNext() == false) goto L22;
        r10 = r10 + ((HealthCheckItemPresentation) r9.next()).getScore();
        goto L20
    L22:
        r7 = HealthModulePresentation.copy$default(r5, null, 0, 0, r10, r8, 7, null);
        goto L23
    L26:
        return r15;
    }

    private final HealthItemTextPresentation itemTextOf(String r4) {
        switch(r4.hashCode()) {
            case -2108687960: goto L51;
            case -1906005440: goto L48;
            case -1751125642: goto L45;
            case -970536546: goto L42;
            case -867398743: goto L39;
            case -729665957: goto L36;
            case -714112454: goto L33;
            case -127431833: goto L30;
            case 585180961: goto L27;
            case 747390960: goto L24;
            case 1017729419: goto L21;
            case 1115130923: goto L18;
            case 1219698838: goto L15;
            case 1342975130: goto L12;
            case 1962874775: goto L9;
            case 2139612528: goto L6;
            default: goto L55;
        };
    L6:
        if (r4.equals(HealthTaskIds.ACCOUNT_LOGGED_IN) == false) goto L55;
        return new HealthItemTextPresentation(R.string.health_task_account_title, R.string.health_task_account_completed, R.string.health_task_account_problem, R.string.health_action_login_score);
    L9:
        if (r4.equals(HealthTaskIds.SYSTEM_LATEST) == false) goto L55;
        return new HealthItemTextPresentation(R.string.health_task_system_latest_title, R.string.health_task_system_latest_completed, R.string.health_task_system_latest_problem, R.string.health_action_update_score);
    L12:
        if (r4.equals(HealthTaskIds.VIRUS_DB_AUTO_UPDATE) == false) goto L55;
        return new HealthItemTextPresentation(R.string.health_task_virus_db_title, R.string.health_task_virus_db_completed, R.string.health_task_virus_db_problem, R.string.health_action_enable_score);
    L15:
        if (r4.equals(HealthTaskIds.MALWARE_FREE) == false) goto L55;
        return new HealthItemTextPresentation(R.string.health_task_malware_title, R.string.health_task_malware_completed, R.string.health_task_malware_problem, R.string.health_action_check_score);
    L18:
        if (r4.equals(HealthTaskIds.SMS_VERIFICATION_CODE) == false) goto L55;
        return new HealthItemTextPresentation(R.string.health_task_sms_code_title, R.string.health_task_sms_code_completed, R.string.health_task_sms_code_problem, R.string.health_action_enable_score);
    L21:
        if (r4.equals(HealthTaskIds.MEMORY_CLEAN) == false) goto L55;
        return new HealthItemTextPresentation(R.string.health_task_memory_title, R.string.health_task_memory_completed, R.string.health_task_memory_problem, R.string.health_action_enable_score);
    L24:
        if (r4.equals(HealthTaskIds.PRIVACY_PROTECTION) == false) goto L55;
        return new HealthItemTextPresentation(R.string.health_task_privacy_title, R.string.health_task_privacy_completed, R.string.health_task_privacy_problem, R.string.health_action_enable_score);
    L27:
        if (r4.equals(HealthTaskIds.FINGERPRINT_RECOMMEND) == false) goto L55;
        return new HealthItemTextPresentation(R.string.health_task_fingerprint_title, R.string.health_task_fingerprint_completed, R.string.health_task_fingerprint_problem, R.string.health_action_add_score);
    L30:
        if (r4.equals(HealthTaskIds.CLOUD_SYNC_ENABLED) == false) goto L55;
        return new HealthItemTextPresentation(R.string.health_task_cloud_sync_title, R.string.health_task_cloud_sync_completed, R.string.health_task_cloud_sync_problem, R.string.health_action_enable_score);
    L33:
        if (r4.equals(HealthTaskIds.RECENT_SAFE_CHECK) == false) goto L55;
        return new HealthItemTextPresentation(R.string.health_task_virus_scan_title, R.string.health_task_virus_scan_completed, R.string.health_task_virus_scan_problem, R.string.health_action_check_score);
    L36:
        if (r4.equals(HealthTaskIds.AUTO_UPDATE_ENABLED) == false) goto L55;
        return new HealthItemTextPresentation(R.string.health_task_auto_update_title, R.string.health_task_auto_update_completed, R.string.health_task_auto_update_problem, R.string.health_action_enable_score);
    L39:
        if (r4.equals(HealthTaskIds.ROOT_FREE) == false) goto L55;
        return new HealthItemTextPresentation(R.string.health_task_root_title, R.string.health_task_root_completed, R.string.health_task_root_problem, R.string.health_action_enable_score);
    L42:
        if (r4.equals(HealthTaskIds.FIND_DEVICE_ENABLED) == false) goto L55;
        return new HealthItemTextPresentation(R.string.health_task_find_device_title, R.string.health_task_find_device_completed, R.string.health_task_find_device_problem, R.string.health_action_enable_score);
    L45:
        if (r4.equals(HealthTaskIds.RISK_BEHAVIOR_PROTECTION) == false) goto L55;
        return new HealthItemTextPresentation(R.string.health_task_risk_behavior_title, R.string.health_task_risk_behavior_completed, R.string.health_task_risk_behavior_problem, R.string.health_action_enable_score);
    L48:
        if (r4.equals(HealthTaskIds.TRASH_LESS) == false) goto L55;
        return new HealthItemTextPresentation(R.string.health_task_trash_title, R.string.health_task_trash_completed, R.string.health_task_trash_problem, R.string.health_action_enable_score);
    L51:
        if (r4.equals(HealthTaskIds.DEVELOPER_MODE_OFF) == false) goto L55;
        return new HealthItemTextPresentation(R.string.health_task_developer_mode_title, R.string.health_task_developer_mode_completed, R.string.health_task_developer_mode_problem, R.string.health_action_disable_score);
    L55:
        throw new IllegalStateException(("Health item text presentation not found, itemId=" + r4).toString());
    }

    private final HealthModulePresentation moduleTemplateOf(String r7) {
        int r6 = r7.hashCode();
        if (r6 == (-838846263)) goto L15;
        if (r6 == 94746185) goto L12;
        if (r6 != 949122880) goto L19;
        if (r7.equals(HealthModuleIds.SECURITY) == false) goto L19;
        return new HealthModulePresentation(HealthModuleIds.SECURITY, R.string.health_module_security, R.drawable.ic_safe_protect_module, 0, CollectionsKt.emptyList());
    L19:
        throw new IllegalStateException(("Health module presentation not found, moduleId=" + r7).toString());
    L12:
        if (r7.equals(HealthModuleIds.CLEAN) == false) goto L19;
        return new HealthModulePresentation(HealthModuleIds.CLEAN, R.string.health_module_clean, R.drawable.ic_clean_module, 0, CollectionsKt.emptyList());
    L15:
        if (r7.equals(HealthModuleIds.UPDATE) == false) goto L19;
        return new HealthModulePresentation(HealthModuleIds.UPDATE, R.string.health_module_update, R.drawable.ic_update_module, 0, CollectionsKt.emptyList());
    }
}
