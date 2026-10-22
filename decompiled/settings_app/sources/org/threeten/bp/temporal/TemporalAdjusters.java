package org.threeten.bp.temporal;

import org.threeten.bp.DayOfWeek;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: loaded from: classes6.dex */
public final class TemporalAdjusters {

    /* JADX INFO: renamed from: org.threeten.bp.temporal.TemporalAdjusters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class DayOfWeekInMonth implements TemporalAdjuster {
        private final int dowValue;
        private final int ordinal;

        /* synthetic */ DayOfWeekInMonth(int r1, DayOfWeek r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private DayOfWeekInMonth(int r1, DayOfWeek r2) {
            this.ordinal = r1;
            this.dowValue = r2.getValue();
        }

        @Override // org.threeten.bp.temporal.TemporalAdjuster
        public Temporal adjustInto(Temporal r10) {
            if (this.ordinal < 0) goto L6;
            Temporal r11 = r10.with(ChronoField.DAY_OF_MONTH, 1);
            return r11.plus((int) (((long) (((this.dowValue - r11.get(ChronoField.DAY_OF_WEEK)) + 7) % 7)) + ((((long) this.ordinal) - 1) * 7)), ChronoUnit.DAYS);
        L6:
            Temporal r12 = r10.with(ChronoField.DAY_OF_MONTH, r10.range(ChronoField.DAY_OF_MONTH).getMaximum());
            int r5 = this.dowValue - r12.get(ChronoField.DAY_OF_WEEK);
            if (r5 != 0) goto L9;
            r5 = 0;
        L12:
            return r12.plus((int) (((long) r5) - ((((long) (-this.ordinal)) - 1) * 7)), ChronoUnit.DAYS);
        L9:
            if (r5 <= 0) goto L12;
            r5 = r5 - 7;
            goto L12
        }
    }

    private static class Impl implements TemporalAdjuster {
        private static final Impl FIRST_DAY_OF_MONTH = null;
        private static final Impl FIRST_DAY_OF_NEXT_MONTH = null;
        private static final Impl FIRST_DAY_OF_NEXT_YEAR = null;
        private static final Impl FIRST_DAY_OF_YEAR = null;
        private static final Impl LAST_DAY_OF_MONTH = null;
        private static final Impl LAST_DAY_OF_YEAR = null;
        private final int ordinal;

        static /* synthetic */ Impl access$000() {
            return FIRST_DAY_OF_MONTH;
        }

        static /* synthetic */ Impl access$100() {
            return LAST_DAY_OF_MONTH;
        }

        static /* synthetic */ Impl access$200() {
            return FIRST_DAY_OF_NEXT_MONTH;
        }

        static /* synthetic */ Impl access$300() {
            return FIRST_DAY_OF_YEAR;
        }

        static /* synthetic */ Impl access$400() {
            return LAST_DAY_OF_YEAR;
        }

        static /* synthetic */ Impl access$500() {
            return FIRST_DAY_OF_NEXT_YEAR;
        }

        static {
            FIRST_DAY_OF_MONTH = new Impl(0);
            LAST_DAY_OF_MONTH = new Impl(1);
            FIRST_DAY_OF_NEXT_MONTH = new Impl(2);
            FIRST_DAY_OF_YEAR = new Impl(3);
            LAST_DAY_OF_YEAR = new Impl(4);
            FIRST_DAY_OF_NEXT_YEAR = new Impl(5);
        }

        private Impl(int r1) {
            this.ordinal = r1;
        }

        @Override // org.threeten.bp.temporal.TemporalAdjuster
        public Temporal adjustInto(Temporal r4) {
            int r3 = this.ordinal;
            if (r3 == 0) goto L27;
            if (r3 == 1) goto L25;
            if (r3 == 2) goto L23;
            if (r3 == 3) goto L21;
            if (r3 == 4) goto L19;
            if (r3 != 5) goto L17;
            return r4.with(ChronoField.DAY_OF_YEAR, 1).plus(1, ChronoUnit.YEARS);
        L17:
            throw new IllegalStateException("Unreachable");
        L19:
            return r4.with(ChronoField.DAY_OF_YEAR, r4.range(ChronoField.DAY_OF_YEAR).getMaximum());
        L21:
            return r4.with(ChronoField.DAY_OF_YEAR, 1);
        L23:
            return r4.with(ChronoField.DAY_OF_MONTH, 1).plus(1, ChronoUnit.MONTHS);
        L25:
            return r4.with(ChronoField.DAY_OF_MONTH, r4.range(ChronoField.DAY_OF_MONTH).getMaximum());
        L27:
            return r4.with(ChronoField.DAY_OF_MONTH, 1);
        }
    }

    private static final class RelativeDayOfWeek implements TemporalAdjuster {
        private final int dowValue;
        private final int relative;

        /* synthetic */ RelativeDayOfWeek(int r1, DayOfWeek r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private RelativeDayOfWeek(int r2, DayOfWeek r3) {
            Jdk8Methods.requireNonNull(r3, "dayOfWeek");
            this.relative = r2;
            this.dowValue = r3.getValue();
        }

        @Override // org.threeten.bp.temporal.TemporalAdjuster
        public Temporal adjustInto(Temporal r4) {
            int r0 = r4.get(ChronoField.DAY_OF_WEEK);
            int r1 = this.relative;
            if (r1 >= 2) goto L8;
            if (r0 != this.dowValue) goto L8;
            return r4;
        L8:
            if ((r1 & 1) != 0) goto L15;
            int r2 = r0 - this.dowValue;
            if (r2 < 0) goto L12;
            int r3 = 7 - r2;
        L14:
            return r4.plus(r3, ChronoUnit.DAYS);
        L12:
            r3 = -r2;
            goto L14
        L15:
            int r5 = this.dowValue - r0;
            if (r5 < 0) goto L18;
            int r6 = 7 - r5;
        L20:
            return r4.minus(r6, ChronoUnit.DAYS);
        L18:
            r6 = -r5;
            goto L20
        }
    }

    private TemporalAdjusters() {
    }

    public static TemporalAdjuster firstDayOfMonth() {
        return Impl.access$000();
    }

    public static TemporalAdjuster lastDayOfMonth() {
        return Impl.access$100();
    }

    public static TemporalAdjuster firstDayOfNextMonth() {
        return Impl.access$200();
    }

    public static TemporalAdjuster firstDayOfYear() {
        return Impl.access$300();
    }

    public static TemporalAdjuster lastDayOfYear() {
        return Impl.access$400();
    }

    public static TemporalAdjuster firstDayOfNextYear() {
        return Impl.access$500();
    }

    public static TemporalAdjuster firstInMonth(DayOfWeek r3) {
        Jdk8Methods.requireNonNull(r3, "dayOfWeek");
        return new DayOfWeekInMonth(1, r3, null);
    }

    public static TemporalAdjuster lastInMonth(DayOfWeek r3) {
        Jdk8Methods.requireNonNull(r3, "dayOfWeek");
        return new DayOfWeekInMonth(-1, r3, null);
    }

    public static TemporalAdjuster dayOfWeekInMonth(int r2, DayOfWeek r3) {
        Jdk8Methods.requireNonNull(r3, "dayOfWeek");
        return new DayOfWeekInMonth(r2, r3, null);
    }

    public static TemporalAdjuster next(DayOfWeek r3) {
        return new RelativeDayOfWeek(2, r3, null);
    }

    public static TemporalAdjuster nextOrSame(DayOfWeek r3) {
        return new RelativeDayOfWeek(0, r3, null);
    }

    public static TemporalAdjuster previous(DayOfWeek r3) {
        return new RelativeDayOfWeek(3, r3, null);
    }

    public static TemporalAdjuster previousOrSame(DayOfWeek r3) {
        return new RelativeDayOfWeek(1, r3, null);
    }
}
