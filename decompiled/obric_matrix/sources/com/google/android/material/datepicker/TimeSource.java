package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
class TimeSource {
    private static final TimeSource SYSTEM_TIME_SOURCE = null;

    @Nullable
    private final Long fixedTimeMs;

    @Nullable
    private final TimeZone fixedTimeZone;

    static {
        SYSTEM_TIME_SOURCE = new TimeSource(null, null);
    }

    private TimeSource(@Nullable Long r1, @Nullable TimeZone r2) {
        this.fixedTimeMs = r1;
        this.fixedTimeZone = r2;
    }

    static TimeSource fixed(long r1) {
        return new TimeSource(Long.valueOf(r1), null);
    }

    static TimeSource fixed(long r1, @Nullable TimeZone r3) {
        return new TimeSource(Long.valueOf(r1), r3);
    }

    static TimeSource system() {
        return SYSTEM_TIME_SOURCE;
    }

    Calendar now() {
        return now(this.fixedTimeZone);
    }

    Calendar now(@Nullable TimeZone r3) {
        if (r3 != null) goto L4;
        Calendar r4 = Calendar.getInstance();
    L5:
        Long r2 = this.fixedTimeMs;
        if (r2 == null) goto L8;
        r4.setTimeInMillis(r2.longValue());
    L8:
        return r4;
    L4:
        r4 = Calendar.getInstance(r3);
        goto L5
    }
}
