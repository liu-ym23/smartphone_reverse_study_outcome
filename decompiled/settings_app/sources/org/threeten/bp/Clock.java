package org.threeten.bp;

import java.io.Serializable;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: loaded from: classes6.dex */
public abstract class Clock {

    static final class FixedClock extends Clock implements Serializable {
        private static final long serialVersionUID = 7430389292664866958L;
        private final Instant instant;
        private final ZoneId zone;

        FixedClock(Instant r1, ZoneId r2) {
            this.instant = r1;
            this.zone = r2;
        }

        @Override // org.threeten.bp.Clock
        public ZoneId getZone() {
            return this.zone;
        }

        @Override // org.threeten.bp.Clock
        public Clock withZone(ZoneId r2) {
            if (r2.equals(this.zone) == false) goto L6;
            return this;
        L6:
            return new FixedClock(this.instant, r2);
        }

        @Override // org.threeten.bp.Clock
        public long millis() {
            return this.instant.toEpochMilli();
        }

        @Override // org.threeten.bp.Clock
        public Instant instant() {
            return this.instant;
        }

        @Override // org.threeten.bp.Clock
        public boolean equals(Object r4) {
            if ((r4 instanceof FixedClock) == false) goto L10;
            FixedClock r5 = (FixedClock) r4;
            if (this.instant.equals(r5.instant) == true) goto L7;
            return false;
        L7:
            if (this.zone.equals(r5.zone) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // org.threeten.bp.Clock
        public int hashCode() {
            int r0 = this.instant.hashCode();
            return this.zone.hashCode() ^ r0;
        }

        public String toString() {
            return "FixedClock[" + this.instant + "," + this.zone + "]";
        }
    }

    static final class OffsetClock extends Clock implements Serializable {
        private static final long serialVersionUID = 2007484719125426256L;
        private final Clock baseClock;
        private final Duration offset;

        OffsetClock(Clock r1, Duration r2) {
            this.baseClock = r1;
            this.offset = r2;
        }

        @Override // org.threeten.bp.Clock
        public ZoneId getZone() {
            return this.baseClock.getZone();
        }

        @Override // org.threeten.bp.Clock
        public Clock withZone(ZoneId r3) {
            if (r3.equals(this.baseClock.getZone()) == false) goto L6;
            return this;
        L6:
            return new OffsetClock(this.baseClock.withZone(r3), this.offset);
        }

        @Override // org.threeten.bp.Clock
        public long millis() {
            return Jdk8Methods.safeAdd(this.baseClock.millis(), this.offset.toMillis());
        }

        @Override // org.threeten.bp.Clock
        public Instant instant() {
            return this.baseClock.instant().plus(this.offset);
        }

        @Override // org.threeten.bp.Clock
        public boolean equals(Object r4) {
            if ((r4 instanceof OffsetClock) == false) goto L10;
            OffsetClock r5 = (OffsetClock) r4;
            if (this.baseClock.equals(r5.baseClock) == true) goto L7;
            return false;
        L7:
            if (this.offset.equals(r5.offset) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // org.threeten.bp.Clock
        public int hashCode() {
            int r0 = this.baseClock.hashCode();
            return this.offset.hashCode() ^ r0;
        }

        public String toString() {
            return "OffsetClock[" + this.baseClock + "," + this.offset + "]";
        }
    }

    static final class SystemClock extends Clock implements Serializable {
        private static final long serialVersionUID = 6740630888130243051L;
        private final ZoneId zone;

        SystemClock(ZoneId r1) {
            this.zone = r1;
        }

        @Override // org.threeten.bp.Clock
        public ZoneId getZone() {
            return this.zone;
        }

        @Override // org.threeten.bp.Clock
        public Clock withZone(ZoneId r2) {
            if (r2.equals(this.zone) == false) goto L6;
            return this;
        L6:
            return new SystemClock(r2);
        }

        @Override // org.threeten.bp.Clock
        public long millis() {
            return System.currentTimeMillis();
        }

        @Override // org.threeten.bp.Clock
        public Instant instant() {
            return Instant.ofEpochMilli(millis());
        }

        @Override // org.threeten.bp.Clock
        public boolean equals(Object r2) {
            if ((r2 instanceof SystemClock) == true) goto L5;
            return false;
        L5:
            return this.zone.equals(((SystemClock) r2).zone);
        }

        @Override // org.threeten.bp.Clock
        public int hashCode() {
            return this.zone.hashCode() + 1;
        }

        public String toString() {
            return "SystemClock[" + this.zone + "]";
        }
    }

    static final class TickClock extends Clock implements Serializable {
        private static final long serialVersionUID = 6504659149906368850L;
        private final Clock baseClock;
        private final long tickNanos;

        TickClock(Clock r1, long r2) {
            this.baseClock = r1;
            this.tickNanos = r2;
        }

        @Override // org.threeten.bp.Clock
        public ZoneId getZone() {
            return this.baseClock.getZone();
        }

        @Override // org.threeten.bp.Clock
        public Clock withZone(ZoneId r4) {
            if (r4.equals(this.baseClock.getZone()) == false) goto L6;
            return this;
        L6:
            return new TickClock(this.baseClock.withZone(r4), this.tickNanos);
        }

        @Override // org.threeten.bp.Clock
        public long millis() {
            long r0 = this.baseClock.millis();
            return r0 - Jdk8Methods.floorMod(r0, this.tickNanos / 1000000);
        }

        @Override // org.threeten.bp.Clock
        public Instant instant() {
            if ((this.tickNanos % 1000000) != 0) goto L6;
            long r0 = this.baseClock.millis();
            return Instant.ofEpochMilli(r0 - Jdk8Methods.floorMod(r0, this.tickNanos / 1000000));
        L6:
            Instant r1 = this.baseClock.instant();
            return r1.minusNanos(Jdk8Methods.floorMod(r1.getNano(), this.tickNanos));
        }

        @Override // org.threeten.bp.Clock
        public boolean equals(Object r5) {
            if ((r5 instanceof TickClock) == false) goto L10;
            TickClock r6 = (TickClock) r5;
            if (this.baseClock.equals(r6.baseClock) == true) goto L7;
            return false;
        L7:
            if (this.tickNanos != r6.tickNanos) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // org.threeten.bp.Clock
        public int hashCode() {
            int r0 = this.baseClock.hashCode();
            long r1 = this.tickNanos;
            return ((int) (r1 ^ (r1 >>> 32))) ^ r0;
        }

        public String toString() {
            return "TickClock[" + this.baseClock + "," + Duration.ofNanos(this.tickNanos) + "]";
        }
    }

    public abstract ZoneId getZone();

    public abstract Instant instant();

    public abstract Clock withZone(ZoneId r1);

    public static Clock systemUTC() {
        return new SystemClock(ZoneOffset.UTC);
    }

    public static Clock systemDefaultZone() {
        return new SystemClock(ZoneId.systemDefault());
    }

    public static Clock system(ZoneId r1) {
        Jdk8Methods.requireNonNull(r1, "zone");
        return new SystemClock(r1);
    }

    public static Clock tickSeconds(ZoneId r3) {
        return new TickClock(system(r3), 1000000000);
    }

    public static Clock tickMinutes(ZoneId r3) {
        return new TickClock(system(r3), 60000000000L);
    }

    public static Clock tick(Clock r6, Duration r7) {
        Jdk8Methods.requireNonNull(r6, "baseClock");
        Jdk8Methods.requireNonNull(r7, "tickDuration");
        if (r7.isNegative() == true) goto L17;
        long r0 = r7.toNanos();
        if ((r0 % 1000000) == 0) goto L10;
        if ((1000000000 % r0) == 0) goto L10;
        throw new IllegalArgumentException("Invalid tick duration");
    L10:
        if (r0 > 1) goto L13;
        return r6;
    L13:
        return new TickClock(r6, r0);
    L17:
        throw new IllegalArgumentException("Tick duration must not be negative");
    }

    public static Clock fixed(Instant r1, ZoneId r2) {
        Jdk8Methods.requireNonNull(r1, "fixedInstant");
        Jdk8Methods.requireNonNull(r2, "zone");
        return new FixedClock(r1, r2);
    }

    public static Clock offset(Clock r1, Duration r2) {
        Jdk8Methods.requireNonNull(r1, "baseClock");
        Jdk8Methods.requireNonNull(r2, "offsetDuration");
        if (r2.equals(Duration.ZERO) == false) goto L6;
        return r1;
    L6:
        return new OffsetClock(r1, r2);
    }

    protected Clock() {
    }

    public long millis() {
        return instant().toEpochMilli();
    }

    public boolean equals(Object r1) {
        return super.equals(r1);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
