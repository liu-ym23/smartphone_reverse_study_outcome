package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
class DurationUnitKt__DurationUnitJvmKt {

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[TimeUnit.values().length];
            r0[TimeUnit.NANOSECONDS.ordinal()] = 1;
            r0[TimeUnit.MICROSECONDS.ordinal()] = 2;
            r0[TimeUnit.MILLISECONDS.ordinal()] = 3;
            r0[TimeUnit.SECONDS.ordinal()] = 4;
            r0[TimeUnit.MINUTES.ordinal()] = 5;
            r0[TimeUnit.HOURS.ordinal()] = 6;
            r0[TimeUnit.DAYS.ordinal()] = 7;
        }
    }
}
