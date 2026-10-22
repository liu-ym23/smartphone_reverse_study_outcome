package android.icu.text;

import android.icu.util.Freezable;
import android.icu.util.Output;
import android.icu.util.TimeZone;
import android.icu.util.ULocale;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import java.io.Serializable;
import java.text.AttributedCharacterIterator;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.EnumSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class TimeZoneFormat extends UFormat implements Freezable<TimeZoneFormat>, Serializable {

    public static final enum GMTOffsetPatternType extends Enum<GMTOffsetPatternType> {
        private static final /* synthetic */ GMTOffsetPatternType[] $VALUES = null;
        public static final GMTOffsetPatternType NEGATIVE_H = null;
        public static final GMTOffsetPatternType NEGATIVE_HM = null;
        public static final GMTOffsetPatternType NEGATIVE_HMS = null;
        public static final GMTOffsetPatternType POSITIVE_H = null;
        public static final GMTOffsetPatternType POSITIVE_HM = null;
        public static final GMTOffsetPatternType POSITIVE_HMS = null;

        public static GMTOffsetPatternType valueOf(String r1) {
            return (GMTOffsetPatternType) Enum.valueOf(GMTOffsetPatternType.class, r1);
        }

        public static GMTOffsetPatternType[] values() {
            return (GMTOffsetPatternType[]) $VALUES.clone();
        }

        private GMTOffsetPatternType(String r1, int r2) {
            super(r1, r2);
        }

        static {
            GMTOffsetPatternType r0 = new GMTOffsetPatternType("POSITIVE_HM", 0);
            POSITIVE_HM = r0;
            GMTOffsetPatternType r1 = new GMTOffsetPatternType("POSITIVE_HMS", 1);
            POSITIVE_HMS = r1;
            GMTOffsetPatternType r3 = new GMTOffsetPatternType("NEGATIVE_HM", 2);
            NEGATIVE_HM = r3;
            GMTOffsetPatternType r5 = new GMTOffsetPatternType("NEGATIVE_HMS", 3);
            NEGATIVE_HMS = r5;
            GMTOffsetPatternType r7 = new GMTOffsetPatternType("POSITIVE_H", 4);
            POSITIVE_H = r7;
            GMTOffsetPatternType r9 = new GMTOffsetPatternType("NEGATIVE_H", 5);
            NEGATIVE_H = r9;
            $VALUES = new GMTOffsetPatternType[]{r0, r1, r3, r5, r7, r9};
        }
    }

    public static final enum ParseOption extends Enum<ParseOption> {
        private static final /* synthetic */ ParseOption[] $VALUES = null;
        public static final ParseOption ALL_STYLES = null;
        public static final ParseOption TZ_DATABASE_ABBREVIATIONS = null;

        public static ParseOption valueOf(String r1) {
            return (ParseOption) Enum.valueOf(ParseOption.class, r1);
        }

        public static ParseOption[] values() {
            return (ParseOption[]) $VALUES.clone();
        }

        private ParseOption(String r1, int r2) {
            super(r1, r2);
        }

        static {
            ParseOption r0 = new ParseOption("ALL_STYLES", 0);
            ALL_STYLES = r0;
            ParseOption r1 = new ParseOption("TZ_DATABASE_ABBREVIATIONS", 1);
            TZ_DATABASE_ABBREVIATIONS = r1;
            $VALUES = new ParseOption[]{r0, r1};
        }
    }

    public static final enum Style extends Enum<Style> {
        private static final /* synthetic */ Style[] $VALUES = null;
        public static final Style EXEMPLAR_LOCATION = null;
        public static final Style GENERIC_LOCATION = null;
        public static final Style GENERIC_LONG = null;
        public static final Style GENERIC_SHORT = null;
        public static final Style ISO_BASIC_FIXED = null;
        public static final Style ISO_BASIC_FULL = null;
        public static final Style ISO_BASIC_LOCAL_FIXED = null;
        public static final Style ISO_BASIC_LOCAL_FULL = null;
        public static final Style ISO_BASIC_LOCAL_SHORT = null;
        public static final Style ISO_BASIC_SHORT = null;
        public static final Style ISO_EXTENDED_FIXED = null;
        public static final Style ISO_EXTENDED_FULL = null;
        public static final Style ISO_EXTENDED_LOCAL_FIXED = null;
        public static final Style ISO_EXTENDED_LOCAL_FULL = null;
        public static final Style LOCALIZED_GMT = null;
        public static final Style LOCALIZED_GMT_SHORT = null;
        public static final Style SPECIFIC_LONG = null;
        public static final Style SPECIFIC_SHORT = null;
        public static final Style ZONE_ID = null;
        public static final Style ZONE_ID_SHORT = null;

        public static Style valueOf(String r1) {
            return (Style) Enum.valueOf(Style.class, r1);
        }

        public static Style[] values() {
            return (Style[]) $VALUES.clone();
        }

        private Style(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Style r0 = new Style("GENERIC_LOCATION", 0);
            GENERIC_LOCATION = r0;
            Style r1 = new Style("GENERIC_LONG", 1);
            GENERIC_LONG = r1;
            Style r3 = new Style("GENERIC_SHORT", 2);
            GENERIC_SHORT = r3;
            Style r5 = new Style("SPECIFIC_LONG", 3);
            SPECIFIC_LONG = r5;
            Style r7 = new Style("SPECIFIC_SHORT", 4);
            SPECIFIC_SHORT = r7;
            Style r9 = new Style("LOCALIZED_GMT", 5);
            LOCALIZED_GMT = r9;
            Style r11 = new Style("LOCALIZED_GMT_SHORT", 6);
            LOCALIZED_GMT_SHORT = r11;
            Style r13 = new Style("ISO_BASIC_SHORT", 7);
            ISO_BASIC_SHORT = r13;
            Style r15 = new Style("ISO_BASIC_LOCAL_SHORT", 8);
            ISO_BASIC_LOCAL_SHORT = r15;
            Style r14 = new Style("ISO_BASIC_FIXED", 9);
            ISO_BASIC_FIXED = r14;
            Style r12 = new Style("ISO_BASIC_LOCAL_FIXED", 10);
            ISO_BASIC_LOCAL_FIXED = r12;
            Style r10 = new Style("ISO_BASIC_FULL", 11);
            ISO_BASIC_FULL = r10;
            Style r8 = new Style("ISO_BASIC_LOCAL_FULL", 12);
            ISO_BASIC_LOCAL_FULL = r8;
            Style r6 = new Style("ISO_EXTENDED_FIXED", 13);
            ISO_EXTENDED_FIXED = r6;
            Style r4 = new Style("ISO_EXTENDED_LOCAL_FIXED", 14);
            ISO_EXTENDED_LOCAL_FIXED = r4;
            Style r2 = new Style("ISO_EXTENDED_FULL", 15);
            ISO_EXTENDED_FULL = r2;
            Style r16 = new Style("ISO_EXTENDED_LOCAL_FULL", 16);
            ISO_EXTENDED_LOCAL_FULL = r16;
            Style r17 = new Style("ZONE_ID", 17);
            ZONE_ID = r17;
            Style r18 = new Style("ZONE_ID_SHORT", 18);
            ZONE_ID_SHORT = r18;
            Style r19 = new Style("EXEMPLAR_LOCATION", 19);
            EXEMPLAR_LOCATION = r19;
            $VALUES = new Style[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19};
        }
    }

    public static final enum TimeType extends Enum<TimeType> {
        private static final /* synthetic */ TimeType[] $VALUES = null;
        public static final TimeType DAYLIGHT = null;
        public static final TimeType STANDARD = null;
        public static final TimeType UNKNOWN = null;

        public static TimeType valueOf(String r1) {
            return (TimeType) Enum.valueOf(TimeType.class, r1);
        }

        public static TimeType[] values() {
            return (TimeType[]) $VALUES.clone();
        }

        private TimeType(String r1, int r2) {
            super(r1, r2);
        }

        static {
            TimeType r0 = new TimeType(NetworkStackConstant.UNKNOWN_TYPE, 0);
            UNKNOWN = r0;
            TimeType r1 = new TimeType("STANDARD", 1);
            STANDARD = r1;
            TimeType r3 = new TimeType("DAYLIGHT", 2);
            DAYLIGHT = r3;
            $VALUES = new TimeType[]{r0, r1, r3};
        }
    }

    @Override // android.icu.util.Freezable
    public /* bridge */ /* synthetic */ TimeZoneFormat cloneAsThawed() {
        return cloneAsThawed();
    }

    @Override // android.icu.util.Freezable
    public /* bridge */ /* synthetic */ TimeZoneFormat freeze() {
        return freeze();
    }

    protected TimeZoneFormat(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static TimeZoneFormat getInstance(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static TimeZoneFormat getInstance(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public TimeZoneNames getTimeZoneNames() {
        throw new RuntimeException("Stub!");
    }

    public TimeZoneFormat setTimeZoneNames(TimeZoneNames r1) {
        throw new RuntimeException("Stub!");
    }

    public String getGMTPattern() {
        throw new RuntimeException("Stub!");
    }

    public TimeZoneFormat setGMTPattern(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getGMTOffsetPattern(GMTOffsetPatternType r1) {
        throw new RuntimeException("Stub!");
    }

    public TimeZoneFormat setGMTOffsetPattern(GMTOffsetPatternType r1, String r2) {
        throw new RuntimeException("Stub!");
    }

    public String getGMTOffsetDigits() {
        throw new RuntimeException("Stub!");
    }

    public TimeZoneFormat setGMTOffsetDigits(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getGMTZeroFormat() {
        throw new RuntimeException("Stub!");
    }

    public TimeZoneFormat setGMTZeroFormat(String r1) {
        throw new RuntimeException("Stub!");
    }

    public TimeZoneFormat setDefaultParseOptions(EnumSet<ParseOption> r1) {
        throw new RuntimeException("Stub!");
    }

    public EnumSet<ParseOption> getDefaultParseOptions() {
        throw new RuntimeException("Stub!");
    }

    public final String formatOffsetISO8601Basic(int r1, boolean r2, boolean r3, boolean r4) {
        throw new RuntimeException("Stub!");
    }

    public final String formatOffsetISO8601Extended(int r1, boolean r2, boolean r3, boolean r4) {
        throw new RuntimeException("Stub!");
    }

    public String formatOffsetLocalizedGMT(int r1) {
        throw new RuntimeException("Stub!");
    }

    public String formatOffsetShortLocalizedGMT(int r1) {
        throw new RuntimeException("Stub!");
    }

    public final String format(Style r1, TimeZone r2, long r3) {
        throw new RuntimeException("Stub!");
    }

    public String format(Style r1, TimeZone r2, long r3, Output<TimeType> r5) {
        throw new RuntimeException("Stub!");
    }

    public final int parseOffsetISO8601(String r1, ParsePosition r2) {
        throw new RuntimeException("Stub!");
    }

    public int parseOffsetLocalizedGMT(String r1, ParsePosition r2) {
        throw new RuntimeException("Stub!");
    }

    public int parseOffsetShortLocalizedGMT(String r1, ParsePosition r2) {
        throw new RuntimeException("Stub!");
    }

    public TimeZone parse(Style r1, String r2, ParsePosition r3, EnumSet<ParseOption> r4, Output<TimeType> r5) {
        throw new RuntimeException("Stub!");
    }

    public TimeZone parse(Style r1, String r2, ParsePosition r3, Output<TimeType> r4) {
        throw new RuntimeException("Stub!");
    }

    public final TimeZone parse(String r1, ParsePosition r2) {
        throw new RuntimeException("Stub!");
    }

    public final TimeZone parse(String r1) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.text.Format
    public StringBuffer format(Object r1, StringBuffer r2, FieldPosition r3) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.text.Format
    public AttributedCharacterIterator formatToCharacterIterator(Object r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.text.Format
    public Object parseObject(String r1, ParsePosition r2) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Freezable
    public boolean isFrozen() {
        throw new RuntimeException("Stub!");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.icu.util.Freezable
    public TimeZoneFormat freeze() {
        throw new RuntimeException("Stub!");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.icu.util.Freezable
    public TimeZoneFormat cloneAsThawed() {
        throw new RuntimeException("Stub!");
    }
}
