package com.obric.security.health.score;

import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.olog.OLog;
import com.obric.oui.calendar.format.DayFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HealthScoreLog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\"\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/security/health/score/HealthScoreLog;", "", "()V", "TAG", "", DayFormatter.DEFAULT_FORMAT, "", DBHelper.BATTERY_COL_SOURCE, "message", "e", "throwable", "", "format", "i", "w", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthScoreLog {
    public static final HealthScoreLog INSTANCE = null;
    public static final String TAG = "HealthScore";

    static {
        INSTANCE = new HealthScoreLog();
    }

    private HealthScoreLog() {
    }

    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.checkNotNullParameter(r3, "message");
        OLog.d(TAG, format(r2, r3));
    }

    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.checkNotNullParameter(r3, "message");
        OLog.i(TAG, format(r2, r3));
    }

    public static /* synthetic */ void w$default(HealthScoreLog r0, String r1, String r2, Throwable r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
        Throwable r6 = (Throwable) null;
    L5:
        r0.w(r1, r2, r3);
    }

    public final void w(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.checkNotNullParameter(r3, "message");
        if (r4 != null) goto L5;
        OLog.w(TAG, format(r2, r3));
        return;
    L5:
        OLog.w(TAG, format(r2, r3), r4);
    }

    public static /* synthetic */ void e$default(HealthScoreLog r0, String r1, String r2, Throwable r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
        Throwable r6 = (Throwable) null;
    L5:
        r0.e(r1, r2, r3);
    }

    public final void e(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.checkNotNullParameter(r3, "message");
        if (r4 != null) goto L5;
        OLog.e(TAG, format(r2, r3));
        return;
    L5:
        OLog.e(TAG, format(r2, r3), r4);
    }

    private final String format(String r2, String r3) {
        return "source=" + r2 + ' ' + r3;
    }
}
