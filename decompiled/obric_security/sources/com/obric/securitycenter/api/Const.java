package com.obric.securitycenter.api;

import kotlin.Metadata;

/* JADX INFO: compiled from: Const.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/securitycenter/api/Const;", "", "()V", "CURRENT_SCORE", "", "EVENT", "EVENT_CLEAR_TASK_FINISH", "EVENT_CLEAR_TASK_PROGRESS", "EVENT_SCAN_TASK_FINISH", "EVENT_SCAN_TASK_PROGRESS", "MEMORY_SCORE", "PKG", "SCORE_DETAIL", "SERVICE_CLASS", "TASK_ITEM_ID", "TASK_MODULE_ID", "TASK_PASSED", "TASK_PROGRESS", "TASK_TITLE", "TOTAL_SCORE", "TRASH_SCORE", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Const {
    public static final String CURRENT_SCORE = "current_score";
    public static final String EVENT = "event";
    public static final String EVENT_CLEAR_TASK_FINISH = "scan_clear_finish_event";
    public static final String EVENT_CLEAR_TASK_PROGRESS = "clear_task_progress_event";
    public static final String EVENT_SCAN_TASK_FINISH = "scan_task_finish_event";
    public static final String EVENT_SCAN_TASK_PROGRESS = "scan_task_progress_event";
    public static final Const INSTANCE = null;
    public static final String MEMORY_SCORE = "memory_score";
    public static final String PKG = "com.obric.security";
    public static final String SCORE_DETAIL = "score_detail";
    public static final String SERVICE_CLASS = "com.obric.security.service.SecurityCenterService";
    public static final String TASK_ITEM_ID = "task_item_id";
    public static final String TASK_MODULE_ID = "task_module_id";
    public static final String TASK_PASSED = "task_passed";
    public static final String TASK_PROGRESS = "task_progress";
    public static final String TASK_TITLE = "task_title";
    public static final String TOTAL_SCORE = "total_score";
    public static final String TRASH_SCORE = "trash_score";

    static {
        INSTANCE = new Const();
    }

    private Const() {
    }
}
