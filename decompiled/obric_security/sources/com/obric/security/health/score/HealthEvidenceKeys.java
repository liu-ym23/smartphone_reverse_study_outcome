package com.obric.security.health.score;

import kotlin.Metadata;

/* JADX INFO: compiled from: HealthScoreIds.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/security/health/score/HealthEvidenceKeys;", "", "()V", "EARNED_SCORE", "", "ERROR_FALLBACK_PASS", "MEMORY_SIZE", "OPTIMIZED_SIZE", "ORIGINAL_REASON", "ORIGINAL_STATUS", "TRASH_SIZE", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthEvidenceKeys {
    public static final String EARNED_SCORE = "earned_score";
    public static final String ERROR_FALLBACK_PASS = "error_fallback_pass";
    public static final HealthEvidenceKeys INSTANCE = null;
    public static final String MEMORY_SIZE = "memory_size";
    public static final String OPTIMIZED_SIZE = "optimized_size";
    public static final String ORIGINAL_REASON = "original_reason";
    public static final String ORIGINAL_STATUS = "original_status";
    public static final String TRASH_SIZE = "trash_size";

    static {
        INSTANCE = new HealthEvidenceKeys();
    }

    private HealthEvidenceKeys() {
    }
}
