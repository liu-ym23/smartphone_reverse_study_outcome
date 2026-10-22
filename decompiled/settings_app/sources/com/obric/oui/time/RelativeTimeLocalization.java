package com.obric.oui.time;

import android.icu.text.PluralRules;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeFormat.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\bH\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BÉ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003¢\u0006\u0002\u0010\u001bJ\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u0015\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003Jû\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u0003HÆ\u0001J\u0013\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010P\u001a\u00020QHÖ\u0001J\t\u0010R\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001dR\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001d¨\u0006S"}, d2 = {"Lcom/obric/oui/time/RelativeTimeLocalization;", "", "justNow", "", "timePattern", "Lkotlin/Pair;", "today", "yesterday", "tomorrow", "beforeYesterday", "afterTomorrow", "dayOfWeekPattern", "datePattern", "dateWithYearPattern", "dateWithYearPatternBrief", "secondsAgoTemplate", "secondsLaterTemplate", "minutesAgoTemplate", "minutesLaterTemplate", "hoursAgoTemplate", "hoursLaterTemplate", "daysAgoTemplate", "daysLaterTemplate", "monthsAgoTemplate", "monthsLaterTemplate", "yearsAgoTemplate", "yearsLaterTemplate", "(Ljava/lang/String;Lkotlin/Pair;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAfterTomorrow", "()Ljava/lang/String;", "getBeforeYesterday", "getDatePattern", "getDateWithYearPattern", "getDateWithYearPatternBrief", "getDayOfWeekPattern", "getDaysAgoTemplate", "getDaysLaterTemplate", "getHoursAgoTemplate", "getHoursLaterTemplate", "getJustNow", "getMinutesAgoTemplate", "getMinutesLaterTemplate", "getMonthsAgoTemplate", "getMonthsLaterTemplate", "getSecondsAgoTemplate", "getSecondsLaterTemplate", "getTimePattern", "()Lkotlin/Pair;", "getToday", "getTomorrow", "getYearsAgoTemplate", "getYearsLaterTemplate", "getYesterday", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RelativeTimeLocalization {
    private final String afterTomorrow;
    private final String beforeYesterday;
    private final String datePattern;
    private final String dateWithYearPattern;
    private final String dateWithYearPatternBrief;
    private final String dayOfWeekPattern;
    private final String daysAgoTemplate;
    private final String daysLaterTemplate;
    private final String hoursAgoTemplate;
    private final String hoursLaterTemplate;
    private final String justNow;
    private final String minutesAgoTemplate;
    private final String minutesLaterTemplate;
    private final String monthsAgoTemplate;
    private final String monthsLaterTemplate;
    private final String secondsAgoTemplate;
    private final String secondsLaterTemplate;
    private final Pair<String, String> timePattern;
    private final String today;
    private final String tomorrow;
    private final String yearsAgoTemplate;
    private final String yearsLaterTemplate;
    private final String yesterday;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RelativeTimeLocalization copy$default(RelativeTimeLocalization r17, String r18, Pair r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, int r41, Object r42) {
        if ((r41 & 1) == 0) goto L5;
        String r2 = r17.justNow;
    L7:
        if ((r41 & 2) == 0) goto L9;
        Pair r3 = r17.timePattern;
    L11:
        if ((r41 & 4) == 0) goto L13;
        String r4 = r17.today;
    L15:
        if ((r41 & 8) == 0) goto L17;
        String r5 = r17.yesterday;
    L19:
        if ((r41 & 16) == 0) goto L21;
        String r6 = r17.tomorrow;
    L23:
        if ((r41 & 32) == 0) goto L25;
        String r7 = r17.beforeYesterday;
    L27:
        if ((r41 & 64) == 0) goto L29;
        String r8 = r17.afterTomorrow;
    L31:
        if ((r41 & 128) == 0) goto L33;
        String r9 = r17.dayOfWeekPattern;
    L35:
        if ((r41 & 256) == 0) goto L37;
        String r10 = r17.datePattern;
    L39:
        if ((r41 & 512) == 0) goto L41;
        String r11 = r17.dateWithYearPattern;
    L43:
        if ((r41 & 1024) == 0) goto L45;
        String r12 = r17.dateWithYearPatternBrief;
    L47:
        if ((r41 & 2048) == 0) goto L49;
        String r13 = r17.secondsAgoTemplate;
    L51:
        if ((r41 & 4096) == 0) goto L53;
        String r14 = r17.secondsLaterTemplate;
    L55:
        if ((r41 & 8192) == 0) goto L57;
        String r15 = r17.minutesAgoTemplate;
    L58:
        String r310 = r15;
        if ((r41 & 16384) == 0) goto L61;
        String r16 = r17.minutesLaterTemplate;
    L62:
        String r311 = r16;
        if ((r41 & 32768) == 0) goto L65;
        String r110 = r17.hoursAgoTemplate;
    L66:
        String r312 = r110;
        if ((r41 & 65536) == 0) goto L69;
        String r111 = r17.hoursLaterTemplate;
    L70:
        String r313 = r111;
        if ((r41 & 131072) == 0) goto L73;
        String r112 = r17.daysAgoTemplate;
    L74:
        String r314 = r112;
        if ((r41 & 262144) == 0) goto L77;
        String r113 = r17.daysLaterTemplate;
    L78:
        String r315 = r113;
        if ((r41 & 524288) == 0) goto L81;
        String r114 = r17.monthsAgoTemplate;
    L82:
        String r316 = r114;
        if ((r41 & 1048576) == 0) goto L85;
        String r115 = r17.monthsLaterTemplate;
    L86:
        String r317 = r115;
        if ((r41 & 2097152) == 0) goto L89;
        String r116 = r17.yearsAgoTemplate;
    L91:
        if ((r41 & 4194304) == 0) goto L93;
        String r1 = r17.yearsLaterTemplate;
    L95:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r116, r1);
    L93:
        r1 = r40;
        goto L95
    L89:
        r116 = r39;
        goto L91
    L85:
        r115 = r38;
        goto L86
    L81:
        r114 = r37;
        goto L82
    L77:
        r113 = r36;
        goto L78
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.justNow;
    }

    public final String component10() {
        return this.dateWithYearPattern;
    }

    public final String component11() {
        return this.dateWithYearPatternBrief;
    }

    public final String component12() {
        return this.secondsAgoTemplate;
    }

    public final String component13() {
        return this.secondsLaterTemplate;
    }

    public final String component14() {
        return this.minutesAgoTemplate;
    }

    public final String component15() {
        return this.minutesLaterTemplate;
    }

    public final String component16() {
        return this.hoursAgoTemplate;
    }

    public final String component17() {
        return this.hoursLaterTemplate;
    }

    public final String component18() {
        return this.daysAgoTemplate;
    }

    public final String component19() {
        return this.daysLaterTemplate;
    }

    public final Pair<String, String> component2() {
        return this.timePattern;
    }

    public final String component20() {
        return this.monthsAgoTemplate;
    }

    public final String component21() {
        return this.monthsLaterTemplate;
    }

    public final String component22() {
        return this.yearsAgoTemplate;
    }

    public final String component23() {
        return this.yearsLaterTemplate;
    }

    public final String component3() {
        return this.today;
    }

    public final String component4() {
        return this.yesterday;
    }

    public final String component5() {
        return this.tomorrow;
    }

    public final String component6() {
        return this.beforeYesterday;
    }

    public final String component7() {
        return this.afterTomorrow;
    }

    public final String component8() {
        return this.dayOfWeekPattern;
    }

    public final String component9() {
        return this.datePattern;
    }

    public final RelativeTimeLocalization copy(String r26, Pair<String, String> r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, String r47, String r48) {
        Intrinsics.checkNotNullParameter(r26, "justNow");
        Intrinsics.checkNotNullParameter(r27, "timePattern");
        Intrinsics.checkNotNullParameter(r28, "today");
        Intrinsics.checkNotNullParameter(r29, "yesterday");
        Intrinsics.checkNotNullParameter(r30, "tomorrow");
        Intrinsics.checkNotNullParameter(r31, "beforeYesterday");
        Intrinsics.checkNotNullParameter(r32, "afterTomorrow");
        Intrinsics.checkNotNullParameter(r33, "dayOfWeekPattern");
        Intrinsics.checkNotNullParameter(r34, "datePattern");
        Intrinsics.checkNotNullParameter(r35, "dateWithYearPattern");
        Intrinsics.checkNotNullParameter(r36, "dateWithYearPatternBrief");
        Intrinsics.checkNotNullParameter(r37, "secondsAgoTemplate");
        Intrinsics.checkNotNullParameter(r38, "secondsLaterTemplate");
        Intrinsics.checkNotNullParameter(r39, "minutesAgoTemplate");
        Intrinsics.checkNotNullParameter(r40, "minutesLaterTemplate");
        Intrinsics.checkNotNullParameter(r41, "hoursAgoTemplate");
        Intrinsics.checkNotNullParameter(r42, "hoursLaterTemplate");
        Intrinsics.checkNotNullParameter(r43, "daysAgoTemplate");
        Intrinsics.checkNotNullParameter(r44, "daysLaterTemplate");
        Intrinsics.checkNotNullParameter(r45, "monthsAgoTemplate");
        Intrinsics.checkNotNullParameter(r46, "monthsLaterTemplate");
        Intrinsics.checkNotNullParameter(r47, "yearsAgoTemplate");
        Intrinsics.checkNotNullParameter(r48, "yearsLaterTemplate");
        return new RelativeTimeLocalization(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RelativeTimeLocalization) == true) goto L8;
        return false;
    L8:
        RelativeTimeLocalization r6 = (RelativeTimeLocalization) r5;
        if (Intrinsics.areEqual(this.justNow, r6.justNow) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.timePattern, r6.timePattern) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.today, r6.today) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.yesterday, r6.yesterday) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tomorrow, r6.tomorrow) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.beforeYesterday, r6.beforeYesterday) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.afterTomorrow, r6.afterTomorrow) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.dayOfWeekPattern, r6.dayOfWeekPattern) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.datePattern, r6.datePattern) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.dateWithYearPattern, r6.dateWithYearPattern) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.dateWithYearPatternBrief, r6.dateWithYearPatternBrief) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.secondsAgoTemplate, r6.secondsAgoTemplate) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.secondsLaterTemplate, r6.secondsLaterTemplate) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.minutesAgoTemplate, r6.minutesAgoTemplate) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.minutesLaterTemplate, r6.minutesLaterTemplate) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.hoursAgoTemplate, r6.hoursAgoTemplate) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.hoursLaterTemplate, r6.hoursLaterTemplate) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.daysAgoTemplate, r6.daysAgoTemplate) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.daysLaterTemplate, r6.daysLaterTemplate) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.monthsAgoTemplate, r6.monthsAgoTemplate) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.monthsLaterTemplate, r6.monthsLaterTemplate) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.yearsAgoTemplate, r6.yearsAgoTemplate) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.yearsLaterTemplate, r6.yearsLaterTemplate) == true) goto L77;
        return false;
    L77:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((this.justNow.hashCode() * 31) + this.timePattern.hashCode()) * 31) + this.today.hashCode()) * 31) + this.yesterday.hashCode()) * 31) + this.tomorrow.hashCode()) * 31) + this.beforeYesterday.hashCode()) * 31) + this.afterTomorrow.hashCode()) * 31) + this.dayOfWeekPattern.hashCode()) * 31) + this.datePattern.hashCode()) * 31) + this.dateWithYearPattern.hashCode()) * 31) + this.dateWithYearPatternBrief.hashCode()) * 31) + this.secondsAgoTemplate.hashCode()) * 31) + this.secondsLaterTemplate.hashCode()) * 31) + this.minutesAgoTemplate.hashCode()) * 31) + this.minutesLaterTemplate.hashCode()) * 31) + this.hoursAgoTemplate.hashCode()) * 31) + this.hoursLaterTemplate.hashCode()) * 31) + this.daysAgoTemplate.hashCode()) * 31) + this.daysLaterTemplate.hashCode()) * 31) + this.monthsAgoTemplate.hashCode()) * 31) + this.monthsLaterTemplate.hashCode()) * 31) + this.yearsAgoTemplate.hashCode()) * 31) + this.yearsLaterTemplate.hashCode();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("RelativeTimeLocalization(justNow=");
        r0.append(this.justNow).append(", timePattern=").append(this.timePattern).append(", today=").append(this.today).append(", yesterday=").append(this.yesterday).append(", tomorrow=").append(this.tomorrow).append(", beforeYesterday=").append(this.beforeYesterday).append(", afterTomorrow=").append(this.afterTomorrow).append(", dayOfWeekPattern=").append(this.dayOfWeekPattern).append(", datePattern=").append(this.datePattern).append(", dateWithYearPattern=").append(this.dateWithYearPattern).append(", dateWithYearPatternBrief=").append(this.dateWithYearPatternBrief).append(", secondsAgoTemplate=");
        r0.append(this.secondsAgoTemplate).append(", secondsLaterTemplate=").append(this.secondsLaterTemplate).append(", minutesAgoTemplate=").append(this.minutesAgoTemplate).append(", minutesLaterTemplate=").append(this.minutesLaterTemplate).append(", hoursAgoTemplate=").append(this.hoursAgoTemplate).append(", hoursLaterTemplate=").append(this.hoursLaterTemplate).append(", daysAgoTemplate=").append(this.daysAgoTemplate).append(", daysLaterTemplate=").append(this.daysLaterTemplate).append(", monthsAgoTemplate=").append(this.monthsAgoTemplate).append(", monthsLaterTemplate=").append(this.monthsLaterTemplate).append(", yearsAgoTemplate=").append(this.yearsAgoTemplate).append(", yearsLaterTemplate=").append(this.yearsLaterTemplate);
        r0.append(')');
        return r0.toString();
    }

    public RelativeTimeLocalization(String r17, Pair<String, String> r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39) {
        Intrinsics.checkNotNullParameter(r17, "justNow");
        Intrinsics.checkNotNullParameter(r18, "timePattern");
        Intrinsics.checkNotNullParameter(r19, "today");
        Intrinsics.checkNotNullParameter(r20, "yesterday");
        Intrinsics.checkNotNullParameter(r21, "tomorrow");
        Intrinsics.checkNotNullParameter(r22, "beforeYesterday");
        Intrinsics.checkNotNullParameter(r23, "afterTomorrow");
        Intrinsics.checkNotNullParameter(r24, "dayOfWeekPattern");
        Intrinsics.checkNotNullParameter(r25, "datePattern");
        Intrinsics.checkNotNullParameter(r26, "dateWithYearPattern");
        Intrinsics.checkNotNullParameter(r27, "dateWithYearPatternBrief");
        Intrinsics.checkNotNullParameter(r28, "secondsAgoTemplate");
        Intrinsics.checkNotNullParameter(r29, "secondsLaterTemplate");
        Intrinsics.checkNotNullParameter(r30, "minutesAgoTemplate");
        Intrinsics.checkNotNullParameter(r31, "minutesLaterTemplate");
        Intrinsics.checkNotNullParameter(r32, "hoursAgoTemplate");
        Intrinsics.checkNotNullParameter(r33, "hoursLaterTemplate");
        Intrinsics.checkNotNullParameter(r34, "daysAgoTemplate");
        Intrinsics.checkNotNullParameter(r35, "daysLaterTemplate");
        Intrinsics.checkNotNullParameter(r36, "monthsAgoTemplate");
        Intrinsics.checkNotNullParameter(r37, "monthsLaterTemplate");
        Intrinsics.checkNotNullParameter(r38, "yearsAgoTemplate");
        Intrinsics.checkNotNullParameter(r39, "yearsLaterTemplate");
        this.justNow = r17;
        this.timePattern = r18;
        this.today = r19;
        this.yesterday = r20;
        this.tomorrow = r21;
        this.beforeYesterday = r22;
        this.afterTomorrow = r23;
        this.dayOfWeekPattern = r24;
        this.datePattern = r25;
        this.dateWithYearPattern = r26;
        this.dateWithYearPatternBrief = r27;
        this.secondsAgoTemplate = r28;
        this.secondsLaterTemplate = r29;
        this.minutesAgoTemplate = r30;
        this.minutesLaterTemplate = r31;
        this.hoursAgoTemplate = r32;
        this.hoursLaterTemplate = r33;
        this.daysAgoTemplate = r34;
        this.daysLaterTemplate = r35;
        this.monthsAgoTemplate = r36;
        this.monthsLaterTemplate = r37;
        this.yearsAgoTemplate = r38;
        this.yearsLaterTemplate = r39;
    }

    public final String getJustNow() {
        return this.justNow;
    }

    public final Pair<String, String> getTimePattern() {
        return this.timePattern;
    }

    public final String getToday() {
        return this.today;
    }

    public final String getYesterday() {
        return this.yesterday;
    }

    public final String getTomorrow() {
        return this.tomorrow;
    }

    public final String getBeforeYesterday() {
        return this.beforeYesterday;
    }

    public final String getAfterTomorrow() {
        return this.afterTomorrow;
    }

    public final String getDayOfWeekPattern() {
        return this.dayOfWeekPattern;
    }

    public final String getDatePattern() {
        return this.datePattern;
    }

    public final String getDateWithYearPattern() {
        return this.dateWithYearPattern;
    }

    public final String getDateWithYearPatternBrief() {
        return this.dateWithYearPatternBrief;
    }

    public final String getSecondsAgoTemplate() {
        return this.secondsAgoTemplate;
    }

    public final String getSecondsLaterTemplate() {
        return this.secondsLaterTemplate;
    }

    public final String getMinutesAgoTemplate() {
        return this.minutesAgoTemplate;
    }

    public final String getMinutesLaterTemplate() {
        return this.minutesLaterTemplate;
    }

    public final String getHoursAgoTemplate() {
        return this.hoursAgoTemplate;
    }

    public final String getHoursLaterTemplate() {
        return this.hoursLaterTemplate;
    }

    public final String getDaysAgoTemplate() {
        return this.daysAgoTemplate;
    }

    public final String getDaysLaterTemplate() {
        return this.daysLaterTemplate;
    }

    public final String getMonthsAgoTemplate() {
        return this.monthsAgoTemplate;
    }

    public final String getMonthsLaterTemplate() {
        return this.monthsLaterTemplate;
    }

    public final String getYearsAgoTemplate() {
        return this.yearsAgoTemplate;
    }

    public final String getYearsLaterTemplate() {
        return this.yearsLaterTemplate;
    }
}
