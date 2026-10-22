package com.obric.oui.time;

import com.android.settingslib.utils.StringUtil;
import cz.msebera.android.httpclient.message.TokenParser;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TimeDateUtil.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0007J:\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\fH\u0002J:\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\fH\u0002J4\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J \u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0003J2\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0003J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\"H\u0007J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0004H\u0007J\u0018\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002¨\u0006*"}, d2 = {"Lcom/obric/oui/time/TimeDateUtil;", "", "()V", "formatTime", "", "style", "Lcom/obric/oui/time/TimeStyle;", "date", "Ljava/util/Date;", "clockFormat", "Lcom/obric/oui/time/ClockFormat;", "showTimezone", "", "locale", "Ljava/util/Locale;", "zoneId", "Ljava/time/ZoneId;", "formatTimeBrief", "pattern", "showDst", "formatTimeFull", "formatTimeRelative", "referenceDate", "formatTimeRelativeDetailed", "formatTimeRelativeFuzzy", "formatTimeRelativeMixed", "isBrief", "formatTimezoneBrief", "zonedDateTime", "Ljava/time/ZonedDateTime;", "formatUSTimeString", "originTimeString", "getDayOfMonthSuffix", "day", "", "getZoneIdByOffset", "offsetHours", "getZoneIdByRegion", "regionId", "handleUKTimeStr", "targetDate", "Ljava/time/LocalDate;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TimeDateUtil {
    public static final TimeDateUtil INSTANCE = null;

    /* JADX INFO: compiled from: TimeDateUtil.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[TimeStyle.values().length];
            r0[TimeStyle.FULL.ordinal()] = 1;
            r0[TimeStyle.FULL_Y.ordinal()] = 2;
            r0[TimeStyle.FULL_YM.ordinal()] = 3;
            r0[TimeStyle.FULL_YMD.ordinal()] = 4;
            r0[TimeStyle.FULL_MD.ordinal()] = 5;
            r0[TimeStyle.FULL_YMDHM.ordinal()] = 6;
            r0[TimeStyle.FULL_YMDEHM.ordinal()] = 7;
            r0[TimeStyle.BRIEF_HM.ordinal()] = 8;
            r0[TimeStyle.BRIEF_MD.ordinal()] = 9;
            r0[TimeStyle.BRIEF_YMDHM.ordinal()] = 10;
            r0[TimeStyle.RELATIVE_DETAILED.ordinal()] = 11;
            r0[TimeStyle.RELATIVE_FUZZY.ordinal()] = 12;
            r0[TimeStyle.RELATIVE_MIXED.ordinal()] = 13;
            r0[TimeStyle.RELATIVE_MIXED_BRIEF.ordinal()] = 14;
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        INSTANCE = new TimeDateUtil();
    }

    @JvmStatic
    public static final String formatTimeRelative(TimeStyle r8, Date r9, Date r10) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(r8, "style");
        Intrinsics.checkNotNullParameter(r9, "date");
        Intrinsics.checkNotNullParameter(r10, "referenceDate");
        return formatTimeRelative$default(r8, r9, r10, null, null, 24, null);
    }

    @JvmStatic
    public static final String formatTimeRelative(TimeStyle r8, Date r9, Date r10, Locale r11) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(r8, "style");
        Intrinsics.checkNotNullParameter(r9, "date");
        Intrinsics.checkNotNullParameter(r10, "referenceDate");
        Intrinsics.checkNotNullParameter(r11, "locale");
        return formatTimeRelative$default(r8, r9, r10, r11, null, 16, null);
    }

    private TimeDateUtil() {
    }

    @JvmStatic
    public static final ZoneId getZoneIdByRegion(String r1) {
        Intrinsics.checkNotNullParameter(r1, "regionId");
        ZoneId r2 = ZoneId.of(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "of(regionId)");
        return r2;
    }

    @JvmStatic
    public static final ZoneId getZoneIdByOffset(int r7) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        String r1 = String.format("%+03d:00", Arrays.copyOf(new Object[]{Integer.valueOf(r7)}, 1));
        Intrinsics.checkNotNullExpressionValue(r1, "format(format, *args)");
        ZoneId r8 = ZoneId.of(StringsKt.replace$default(r1, "+00", "+000", false, 4, null));
        Intrinsics.checkNotNullExpressionValue(r8, "of(offsetIdString)");
        return r8;
    }

    @JvmStatic
    public static final String formatTime(TimeStyle r7, Date r8, ClockFormat r9, boolean r10) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(r7, "style");
        Intrinsics.checkNotNullParameter(r8, "date");
        Intrinsics.checkNotNullParameter(r9, "clockFormat");
        Locale r3 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(r3, "getDefault()");
        ZoneId r5 = ZoneId.systemDefault();
        Intrinsics.checkNotNullExpressionValue(r5, "systemDefault()");
        return formatTime(r7, r8, r3, r9, r5, r10);
    }

    @JvmStatic
    public static final String formatTime(TimeStyle r10, Date r11, Locale r12, ClockFormat r13, ZoneId r14, boolean r15) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(r10, "style");
        Intrinsics.checkNotNullParameter(r11, "date");
        Intrinsics.checkNotNullParameter(r12, "locale");
        Intrinsics.checkNotNullParameter(r13, "clockFormat");
        Intrinsics.checkNotNullParameter(r14, "zoneId");
        switch(WhenMappings.$EnumSwitchMapping$0[r10.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            default: goto L5;
        };
    L6:
        String r4 = TimePattern.Companion.ofClockFormat(TimeFormat.INSTANCE.getBasePattern$OUI_standardRelease(r12).getBriefPatternYMDHM(), r13);
        return formatTimeBrief$default(INSTANCE, r11, r12, r4, r14, r15, false, 32, null);
    L7:
        String r5 = TimePattern.Companion.ofClockFormat(TimeFormat.INSTANCE.getBasePattern$OUI_standardRelease(r12).getBriefPatternMD(), r13);
        return formatTimeBrief$default(INSTANCE, r11, r12, r5, r14, r15, false, 32, null);
    L8:
        String r6 = TimePattern.Companion.ofClockFormat(TimeFormat.INSTANCE.getBasePattern$OUI_standardRelease(r12).getBriefPatternHM(), r13);
        return formatTimeBrief$default(INSTANCE, r11, r12, r6, r14, r15, false, 32, null);
    L9:
        String r7 = TimePattern.Companion.ofClockFormat(TimeFormat.INSTANCE.getBasePattern$OUI_standardRelease(r12).getFullPatternYMDEHM(), r13);
        return formatTimeFull$default(INSTANCE, r11, r12, r7, r14, r15, false, 32, null);
    L10:
        String r8 = TimePattern.Companion.ofClockFormat(TimeFormat.INSTANCE.getBasePattern$OUI_standardRelease(r12).getFullPatternYMDHM(), r13);
        return formatTimeFull$default(INSTANCE, r11, r12, r8, r14, r15, false, 32, null);
    L11:
        String r3 = TimePattern.Companion.ofClockFormat(TimeFormat.INSTANCE.getBasePattern$OUI_standardRelease(r12).getFullPatternMD(), r13);
        return INSTANCE.formatTimeFull(r11, r12, r3, r14, false, false);
    L12:
        String r9 = TimePattern.Companion.ofClockFormat(TimeFormat.INSTANCE.getBasePattern$OUI_standardRelease(r12).getFullPatternYMD(), r13);
        return INSTANCE.formatTimeFull(r11, r12, r9, r14, false, false);
    L13:
        String r16 = TimePattern.Companion.ofClockFormat(TimeFormat.INSTANCE.getBasePattern$OUI_standardRelease(r12).getFullPatternYM(), r13);
        return INSTANCE.formatTimeFull(r11, r12, r16, r14, false, false);
    L14:
        String r17 = TimePattern.Companion.ofClockFormat(TimeFormat.INSTANCE.getBasePattern$OUI_standardRelease(r12).getFullPatternY(), r13);
        return INSTANCE.formatTimeFull(r11, r12, r17, r14, false, false);
    L15:
        String r18 = TimePattern.Companion.ofClockFormat(TimeFormat.INSTANCE.getBasePattern$OUI_standardRelease(r12).getFullPattern(), r13);
        return formatTimeFull$default(INSTANCE, r11, r12, r18, r14, r15, false, 32, null);
    L5:
        throw new IllegalArgumentException("Invalid time style");
    }

    public static /* synthetic */ String formatTimeRelative$default(TimeStyle r0, Date r1, Date r2, Locale r3, ClockFormat r4, int r5, Object r6) throws IllegalArgumentException {
        if ((r5 & 8) == 0) goto L6;
        r3 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(r3, "getDefault()");
    L6:
        if ((r5 & 16) == 0) goto L9;
        r4 = ClockFormat.H24;
    L9:
        return formatTimeRelative(r0, r1, r2, r3, r4);
    }

    @JvmStatic
    public static final String formatTimeRelative(TimeStyle r6, Date r7, Date r8, Locale r9, ClockFormat r10) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(r6, "style");
        Intrinsics.checkNotNullParameter(r7, "date");
        Intrinsics.checkNotNullParameter(r8, "referenceDate");
        Intrinsics.checkNotNullParameter(r9, "locale");
        Intrinsics.checkNotNullParameter(r10, "clockFormat");
        switch(WhenMappings.$EnumSwitchMapping$0[r6.ordinal()]) {
            case 11: goto L16;
            case 12: goto L8;
            case 13: goto L18;
            case 14: goto L17;
            default: goto L5;
        };
    L8:
        TimeDateUtil r11 = INSTANCE;
        String r12 = r11.formatTimeRelativeFuzzy(r7, r8, r9);
        if (r12.length() != 0) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L19;
        r12 = r11.formatTimeRelativeDetailed(r7, r8, r9);
    L19:
        return r12;
    L11:
        r0 = false;
        goto L12
    L5:
        throw new IllegalArgumentException("Invalid time style");
    L17:
        return INSTANCE.formatTimeRelativeMixed(r7, r8, r9, true, r10);
    L18:
        return INSTANCE.formatTimeRelativeMixed(r7, r8, r9, false, r10);
    L16:
        return INSTANCE.formatTimeRelativeDetailed(r7, r8, r9);
    }

    static /* synthetic */ String formatTimeRelativeMixed$default(TimeDateUtil r6, Date r7, Date r8, Locale r9, boolean r10, ClockFormat r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L6;
        r10 = false;
    L6:
        return r6.formatTimeRelativeMixed(r7, r8, r9, r10, r11);
    }

    private final String formatTimeRelativeMixed(Date r9, Date r10, Locale r11, boolean r12, ClockFormat r13) {
        ZoneId r0 = ZoneId.systemDefault();
        ZonedDateTime r14 = r9.toInstant().atZone(r0);
        ZonedDateTime r15 = r10.toInstant().atZone(r0);
        Duration r1 = Duration.between(r14, r15);
        RelativeTimeLocalization r2 = TimeFormat.INSTANCE.getLocalization$OUI_standardRelease(r11);
        if (r1.isNegative() == true) goto L9;
        if (r1.toMinutes() >= 3) goto L9;
        return r2.getJustNow();
    L9:
        if (r1.isNegative() == false) goto L11;
    L14:
        LocalDate r3 = r14.toLocalDate();
        long r4 = ChronoUnit.DAYS.between(r3, r15.toLocalDate());
        if (r4 != 0) goto L19;
        String r16 = r14.format(DateTimeFormatter.ofPattern(TimePattern.Companion.ofClockFormat(r2.getTimePattern(), r13), r11));
        Intrinsics.checkNotNullExpressionValue(r16, "targetDateTime.format(formatter)");
        return formatUSTimeString(r11, r16);
    L19:
        if (r4 != 1) goto L23;
        return r2.getYesterday();
    L23:
        if (Math.abs(r4) >= 7) goto L27;
        String r8 = r14.format(DateTimeFormatter.ofPattern(r2.getDayOfWeekPattern(), r11));
        Intrinsics.checkNotNullExpressionValue(r8, "targetDateTime.format(formatter)");
        return r8;
    L27:
        if (r14.getYear() != r15.getYear()) goto L29;
        String r17 = r2.getDatePattern();
    L32:
        String r18 = r14.format(DateTimeFormatter.ofPattern(r17, r11));
        if (Intrinsics.areEqual(r11, Locale.UK) == false) goto L35;
        Intrinsics.checkNotNullExpressionValue(r3, "targetDate");
        Intrinsics.checkNotNullExpressionValue(r18, "originTimeString");
        r18 = handleUKTimeStr(r3, r18);
    L35:
        Intrinsics.checkNotNullExpressionValue(r18, "originTimeString");
        return r18;
    L29:
        if (r12 == false) goto L31;
        r17 = r2.getDateWithYearPatternBrief();
        goto L32
    L31:
        r17 = r2.getDateWithYearPattern();
        goto L32
    L11:
        if (r1.toMinutes() >= 60) goto L14;
        StringCompanionObject r19 = StringCompanionObject.INSTANCE;
        String r20 = String.format(r2.getMinutesAgoTemplate(), Arrays.copyOf(new Object[]{Long.valueOf(r1.toMinutes())}, 1));
        Intrinsics.checkNotNullExpressionValue(r20, "format(format, *args)");
        return r20;
    }

    private final String formatTimeRelativeDetailed(Date r24, Date r25, Locale r26) {
        ZoneId r1 = ZoneId.systemDefault();
        ZonedDateTime r2 = r24.toInstant().atZone(r1);
        ZonedDateTime r3 = r25.toInstant().atZone(r1);
        RelativeTimeLocalization r4 = TimeFormat.INSTANCE.getLocalization$OUI_standardRelease(r26);
        Duration r5 = Duration.between(r3, r2);
        long r6 = r5.getSeconds();
        long r7 = r5.toMinutes();
        long r9 = r5.toHours();
        long r11 = ChronoUnit.DAYS.between(r3.toLocalDate(), r2.toLocalDate());
        long r13 = ChronoUnit.MONTHS.between(r3.toLocalDate(), r2.toLocalDate());
        long r15 = ChronoUnit.YEARS.between(r3.toLocalDate(), r2.toLocalDate());
        if (Math.abs(r6) >= 60) goto L10;
        if (r6 >= 0) goto L7;
        String r0 = r4.getSecondsAgoTemplate();
    L8:
        StringCompanionObject r8 = StringCompanionObject.INSTANCE;
        String r10 = String.format(r0, Arrays.copyOf(new Object[]{Long.valueOf(Math.abs(r6))}, 1));
        Intrinsics.checkNotNullExpressionValue(r10, "format(format, *args)");
        return r10;
    L7:
        r0 = r4.getSecondsLaterTemplate();
        goto L8
    L10:
        if (Math.abs(r7) >= 60) goto L17;
        if (r7 >= 0) goto L14;
        String r12 = r4.getMinutesAgoTemplate();
    L15:
        StringCompanionObject r14 = StringCompanionObject.INSTANCE;
        String r16 = String.format(r12, Arrays.copyOf(new Object[]{Long.valueOf(Math.abs(r7))}, 1));
        Intrinsics.checkNotNullExpressionValue(r16, "format(format, *args)");
        return r16;
    L14:
        r12 = r4.getMinutesLaterTemplate();
        goto L15
    L17:
        if (Math.abs(r9) >= 24) goto L24;
        if (r9 >= 0) goto L21;
        String r17 = r4.getHoursAgoTemplate();
    L22:
        StringCompanionObject r18 = StringCompanionObject.INSTANCE;
        String r19 = String.format(r17, Arrays.copyOf(new Object[]{Long.valueOf(Math.abs(r9))}, 1));
        Intrinsics.checkNotNullExpressionValue(r19, "format(format, *args)");
        return r19;
    L21:
        r17 = r4.getHoursLaterTemplate();
        goto L22
    L24:
        if (Math.abs(r11) >= 7) goto L27;
        String r20 = r2.format(DateTimeFormatter.ofPattern(r4.getDayOfWeekPattern(), r26));
        Intrinsics.checkNotNullExpressionValue(r20, "{\n                val fo…(formatter)\n            }");
        return r20;
    L27:
        if (Math.abs(r11) >= 31) goto L34;
        if (r11 >= 0) goto L31;
        String r21 = r4.getDaysAgoTemplate();
    L32:
        StringCompanionObject r22 = StringCompanionObject.INSTANCE;
        String r23 = String.format(r21, Arrays.copyOf(new Object[]{Long.valueOf(Math.abs(r11))}, 1));
        Intrinsics.checkNotNullExpressionValue(r23, "format(format, *args)");
        return r23;
    L31:
        r21 = r4.getDaysLaterTemplate();
        goto L32
    L34:
        if (Math.abs(r13) >= 12) goto L41;
        if (r13 >= 0) goto L38;
        String r27 = r4.getMonthsAgoTemplate();
    L39:
        StringCompanionObject r28 = StringCompanionObject.INSTANCE;
        String r29 = String.format(r27, Arrays.copyOf(new Object[]{Long.valueOf(Math.abs(r13))}, 1));
        Intrinsics.checkNotNullExpressionValue(r29, "format(format, *args)");
        return r29;
    L38:
        r27 = r4.getMonthsLaterTemplate();
        goto L39
    L41:
        if (r15 >= 0) goto L43;
        String r30 = r4.getYearsAgoTemplate();
    L44:
        StringCompanionObject r31 = StringCompanionObject.INSTANCE;
        String r32 = String.format(r30, Arrays.copyOf(new Object[]{Long.valueOf(Math.abs(r15))}, 1));
        Intrinsics.checkNotNullExpressionValue(r32, "format(format, *args)");
        return r32;
    L43:
        r30 = r4.getYearsLaterTemplate();
        goto L44
    }

    private final String formatTimeRelativeFuzzy(Date r5, Date r6, Locale r7) {
        ZoneId r4 = ZoneId.systemDefault();
        ZonedDateTime r8 = r5.toInstant().atZone(r4);
        ZonedDateTime r9 = r6.toInstant().atZone(r4);
        Duration r10 = Duration.between(r8, r9);
        RelativeTimeLocalization r11 = TimeFormat.INSTANCE.getLocalization$OUI_standardRelease(r7);
        if (r10.isNegative() == false) goto L5;
    L8:
        LocalDate r12 = r8.toLocalDate();
        LocalDate r13 = r9.toLocalDate();
        long r14 = ChronoUnit.DAYS.between(r12, r13);
        if (r14 != 0) goto L13;
        return r11.getToday();
    L13:
        if (r14 != 1) goto L17;
        return r11.getYesterday();
    L17:
        if (r14 != (-1)) goto L21;
        return r11.getTomorrow();
    L21:
        if (r14 != 2) goto L25;
        return r11.getBeforeYesterday();
    L25:
        if (r14 == (-2)) goto L27;
        return "";
    L27:
        return r11.getAfterTomorrow();
    L5:
        if (r10.toMinutes() >= 3) goto L8;
        return r11.getJustNow();
    }

    static /* synthetic */ String formatTimeFull$default(TimeDateUtil r7, Date r8, Locale r9, String r10, ZoneId r11, boolean r12, boolean r13, int r14, Object r15) {
        if ((r14 & 32) == 0) goto L6;
        r13 = true;
    L6:
        return r7.formatTimeFull(r8, r9, r10, r11, r12, r13);
    }

    private final String formatTimeFull(Date r7, Locale r8, String r9, ZoneId r10, boolean r11, boolean r12) {
        Instant r13 = r7.toInstant();
        ZonedDateTime r0 = r13.atZone(r10);
        StringsKt.padStart(String.valueOf(r0.getNano() / 1000000), 3, '0');
        String r14 = r0.format(DateTimeFormatter.ofPattern(r9, r8));
        if (Intrinsics.areEqual(r8, Locale.UK) == false) goto L5;
        LocalDate r15 = r0.toLocalDate();
        Intrinsics.checkNotNullExpressionValue(r15, "zonedDateTime.toLocalDate()");
        Intrinsics.checkNotNullExpressionValue(r14, "originTimeString");
        r14 = handleUKTimeStr(r15, r14);
    L5:
        String r6 = "";
        if (r11 == true) goto L8;
        String r16 = "";
    L9:
        if (r12 == false) goto L15;
        if (r10.getRules().isDaylightSavings(r13) == false) goto L15;
        r6 = " DST";
    L15:
        return r14 + r16 + r6;
    L8:
        String r1 = r0.getOffset().getId();
        Intrinsics.checkNotNullExpressionValue(r1, "zonedDateTime.offset.id");
        r16 = " (UTC" + StringsKt.replace$default(r1, "Z", "+00:00", false, 4, null) + ')';
        goto L9
    }

    static /* synthetic */ String formatTimeBrief$default(TimeDateUtil r7, Date r8, Locale r9, String r10, ZoneId r11, boolean r12, boolean r13, int r14, Object r15) {
        if ((r14 & 32) == 0) goto L6;
        r13 = true;
    L6:
        return r7.formatTimeBrief(r8, r9, r10, r11, r12, r13);
    }

    private final String formatTimeBrief(Date r3, Locale r4, String r5, ZoneId r6, boolean r7, boolean r8) {
        Instant r9 = r3.toInstant();
        ZonedDateTime r0 = r9.atZone(r6);
        String r10 = r0.format(DateTimeFormatter.ofPattern(r5, r4));
        Intrinsics.checkNotNullExpressionValue(r10, "originTimeString");
        String r11 = formatUSTimeString(r4, r10);
        String r12 = "";
        if (r7 == true) goto L5;
        String r2 = "";
    L6:
        if (r8 == false) goto L12;
        if (r6.getRules().isDaylightSavings(r9) == false) goto L12;
        r12 = " DST";
    L12:
        return r11 + r2 + r12;
    L5:
        Intrinsics.checkNotNullExpressionValue(r0, "zonedDateTime");
        r2 = formatTimezoneBrief(r0);
        goto L6
    }

    private final String formatUSTimeString(Locale r13, String r14) {
        if (Intrinsics.areEqual(r13, Locale.US) == true) goto L5;
        return r14;
    L5:
        return StringsKt.replaceFirst$default(StringsKt.replaceFirst$default(r14, "AM", "am", false, 4, null), "PM", "pm", false, 4, null);
    }

    private final String formatTimezoneBrief(ZonedDateTime r3) {
        ZoneOffset r2 = r3.getOffset();
        int r4 = r2.getTotalSeconds();
        if ((r4 % StringUtil.SECONDS_PER_HOUR) != 0) goto L5;
        int r5 = r4 / StringUtil.SECONDS_PER_HOUR;
        StringCompanionObject r6 = StringCompanionObject.INSTANCE;
        String r7 = String.format("%+d", Arrays.copyOf(new Object[]{Integer.valueOf(r5)}, 1));
        Intrinsics.checkNotNullExpressionValue(r7, "format(format, *args)");
    L7:
        return " (UTC" + r7 + ')';
    L5:
        r7 = r2.getId();
        goto L7
    }

    private final String handleUKTimeStr(LocalDate r13, String r14) {
        int r0 = r13.getDayOfMonth();
        String r1 = r13.getMonth().name().toLowerCase();
        Intrinsics.checkNotNullExpressionValue(r1, "this as java.lang.String).toLowerCase()");
        String r2 = StringsKt.capitalize(r1);
        return StringsKt.replaceFirst$default(StringsKt.replaceFirst$default(StringsKt.replaceFirst$default(r14, r0 + TokenParser.SP + r2, r0 + getDayOfMonthSuffix(r0) + TokenParser.SP + r2, false, 4, null), "am", "AM", false, 4, null), "pm", "PM", false, 4, null);
    }

    private final String getDayOfMonthSuffix(int r3) {
        boolean r1 = false;
        if (11 > r3) goto L8;
        if (r3 >= 14) goto L8;
        r1 = true;
    L8:
        if (r1 == true) goto L23;
        int r4 = r3 % 10;
        if (r4 != 1) goto L14;
        return "st";
    L14:
        if (r4 != 2) goto L17;
        return "nd";
    L17:
        if (r4 != 3) goto L22;
        return "rd";
    L22:
        return "th";
    L23:
        return "th";
    }
}
