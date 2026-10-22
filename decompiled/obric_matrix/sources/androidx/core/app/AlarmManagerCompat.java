package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class AlarmManagerCompat {

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static void setExact(AlarmManager r0, int r1, long r2, PendingIntent r4) {
            r0.setExact(r1, r2, r4);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static AlarmManager.AlarmClockInfo createAlarmClockInfo(long r1, PendingIntent r3) {
            return new AlarmManager.AlarmClockInfo(r1, r3);
        }

        @DoNotInline
        static void setAlarmClock(AlarmManager r0, Object r1, PendingIntent r2) {
            r0.setAlarmClock((AlarmManager.AlarmClockInfo) r1, r2);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static void setAndAllowWhileIdle(AlarmManager r0, int r1, long r2, PendingIntent r4) {
            r0.setAndAllowWhileIdle(r1, r2, r4);
        }

        @DoNotInline
        static void setExactAndAllowWhileIdle(AlarmManager r0, int r1, long r2, PendingIntent r4) {
            r0.setExactAndAllowWhileIdle(r1, r2, r4);
        }
    }

    private AlarmManagerCompat() {
    }

    @SuppressLint({"MissingPermission"})
    public static void setAlarmClock(@NonNull AlarmManager r2, long r3, @NonNull PendingIntent r5, @NonNull PendingIntent r6) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Api21Impl.setAlarmClock(r2, Api21Impl.createAlarmClockInfo(r3, r5), r6);
        return;
    L5:
        setExact(r2, 0, r3, r6);
    }

    public static void setAndAllowWhileIdle(@NonNull AlarmManager r2, int r3, long r4, @NonNull PendingIntent r6) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        Api23Impl.setAndAllowWhileIdle(r2, r3, r4, r6);
        return;
    L5:
        r2.set(r3, r4, r6);
    }

    public static void setExact(@NonNull AlarmManager r2, int r3, long r4, @NonNull PendingIntent r6) {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        Api19Impl.setExact(r2, r3, r4, r6);
        return;
    L5:
        r2.set(r3, r4, r6);
    }

    public static void setExactAndAllowWhileIdle(@NonNull AlarmManager r2, int r3, long r4, @NonNull PendingIntent r6) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        Api23Impl.setExactAndAllowWhileIdle(r2, r3, r4, r6);
        return;
    L5:
        setExact(r2, r3, r4, r6);
    }
}
