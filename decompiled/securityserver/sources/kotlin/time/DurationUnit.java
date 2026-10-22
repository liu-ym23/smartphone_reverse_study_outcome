package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
@WasExperimental
public final enum DurationUnit extends Enum<DurationUnit> {
    public static final DurationUnit b = null;
    public static final DurationUnit c = null;
    public static final DurationUnit e = null;
    public static final DurationUnit f = null;
    public static final DurationUnit i = null;
    public static final DurationUnit j = null;
    public static final DurationUnit k = null;
    public static final /* synthetic */ DurationUnit[] l = null;

    static {
        DurationUnit r0 = new DurationUnit("NANOSECONDS", 0, TimeUnit.NANOSECONDS);
        b = r0;
        DurationUnit r1 = new DurationUnit("MICROSECONDS", 1, TimeUnit.MICROSECONDS);
        c = r1;
        DurationUnit r2 = new DurationUnit("MILLISECONDS", 2, TimeUnit.MILLISECONDS);
        e = r2;
        DurationUnit r3 = new DurationUnit("SECONDS", 3, TimeUnit.SECONDS);
        f = r3;
        DurationUnit r4 = new DurationUnit("MINUTES", 4, TimeUnit.MINUTES);
        i = r4;
        DurationUnit r5 = new DurationUnit("HOURS", 5, TimeUnit.HOURS);
        j = r5;
        DurationUnit r6 = new DurationUnit("DAYS", 6, TimeUnit.DAYS);
        k = r6;
        l = new DurationUnit[]{r0, r1, r2, r3, r4, r5, r6};
    }

    public DurationUnit(String r1, int r2, TimeUnit r3) {
        super(r1, r2);
    }

    public static DurationUnit valueOf(String r1) {
        return (DurationUnit) Enum.valueOf(DurationUnit.class, r1);
    }

    public static DurationUnit[] values() {
        return (DurationUnit[]) l.clone();
    }
}
