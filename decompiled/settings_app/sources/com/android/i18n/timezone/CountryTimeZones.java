package com.android.i18n.timezone;

import android.icu.util.TimeZone;
import java.time.Instant;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CountryTimeZones {

    public static final class OffsetResult {
        OffsetResult() {
            throw new RuntimeException("Stub!");
        }

        public TimeZone getTimeZone() {
            throw new RuntimeException("Stub!");
        }

        public boolean isOnlyMatch() {
            throw new RuntimeException("Stub!");
        }

        public String toString() {
            throw new RuntimeException("Stub!");
        }
    }

    public static final class TimeZoneMapping {
        TimeZoneMapping() {
            throw new RuntimeException("Stub!");
        }

        public String getTimeZoneId() {
            throw new RuntimeException("Stub!");
        }

        public boolean isShownInPickerAt(Instant r1) {
            throw new RuntimeException("Stub!");
        }

        public List<String> getAlternativeIds() {
            throw new RuntimeException("Stub!");
        }

        public TimeZone getTimeZone() {
            throw new RuntimeException("Stub!");
        }

        public static TimeZoneMapping createForTests(String r0, boolean r1, Long r2, List<String> r3) {
            throw new RuntimeException("Stub!");
        }

        public boolean equals(Object r1) {
            throw new RuntimeException("Stub!");
        }

        public int hashCode() {
            throw new RuntimeException("Stub!");
        }

        public String toString() {
            throw new RuntimeException("Stub!");
        }
    }

    private CountryTimeZones() {
        throw new RuntimeException("Stub!");
    }

    public String getCountryIso() {
        throw new RuntimeException("Stub!");
    }

    public boolean matchesCountryCode(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getDefaultTimeZoneId() {
        throw new RuntimeException("Stub!");
    }

    public synchronized TimeZone getDefaultTimeZone() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Stub!");     // Catch: Throwable -> L5
    }

    public boolean isDefaultTimeZoneBoosted() {
        throw new RuntimeException("Stub!");
    }

    public List<TimeZoneMapping> getTimeZoneMappings() {
        throw new RuntimeException("Stub!");
    }

    public boolean hasUtcZone(long r1) {
        throw new RuntimeException("Stub!");
    }

    public OffsetResult lookupByOffsetWithBias(long r1, TimeZone r3, int r4, boolean r5) {
        throw new RuntimeException("Stub!");
    }

    public OffsetResult lookupByOffsetWithBias(long r1, TimeZone r3, int r4) {
        throw new RuntimeException("Stub!");
    }

    public List<TimeZoneMapping> getEffectiveTimeZoneMappingsAt(long r1) {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(Object r1) {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }
}
