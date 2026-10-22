package androidx.core.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class AlarmManagerCompat {
    private AlarmManagerCompat() {
    }

    public static void setAlarmClock(@NonNull AlarmManager r1, long r2, @NonNull PendingIntent r4, @NonNull PendingIntent r5) {
        r1.setAlarmClock(new AlarmManager.AlarmClockInfo(r2, r4), r5);
    }

    public static void setAndAllowWhileIdle(@NonNull AlarmManager r0, int r1, long r2, @NonNull PendingIntent r4) {
        r0.setAndAllowWhileIdle(r1, r2, r4);
    }

    public static void setExact(@NonNull AlarmManager r0, int r1, long r2, @NonNull PendingIntent r4) {
        r0.setExact(r1, r2, r4);
    }

    public static void setExactAndAllowWhileIdle(@NonNull AlarmManager r0, int r1, long r2, @NonNull PendingIntent r4) {
        r0.setExactAndAllowWhileIdle(r1, r2, r4);
    }
}
