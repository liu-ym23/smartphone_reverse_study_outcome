package com.obric.security.health.score.task;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SafeCheckHistory.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/security/health/score/task/SafeCheckHistory;", "", "()V", "KEY_LAST_FINISH_TIME", "", "PREF_NAME", "getLastFinishTime", "", "context", "Landroid/content/Context;", "markScanFinished", "", "timeMillis", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SafeCheckHistory {
    public static final SafeCheckHistory INSTANCE = null;
    private static final String KEY_LAST_FINISH_TIME = "last_finish_time";
    private static final String PREF_NAME = "safe_check_history";

    static {
        INSTANCE = new SafeCheckHistory();
    }

    private SafeCheckHistory() {
    }

    public static /* synthetic */ void markScanFinished$default(SafeCheckHistory r0, Context r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = System.currentTimeMillis();
    L5:
        r0.markScanFinished(r1, r2);
    }

    public final void markScanFinished(Context r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        r2.getApplicationContext().getSharedPreferences(PREF_NAME, 0).edit().putLong(KEY_LAST_FINISH_TIME, r3).apply();
    }

    public final long getLastFinishTime(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return r3.getApplicationContext().getSharedPreferences(PREF_NAME, 0).getLong(KEY_LAST_FINISH_TIME, 0);
    }
}
