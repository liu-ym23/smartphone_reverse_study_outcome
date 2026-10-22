package org.threeten.bp.zone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.Year;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAdjusters;

/* JADX INFO: loaded from: classes6.dex */
class ZoneRulesBuilder {
    private Map<Object, Object> deduplicateMap;
    private List<TZWindow> windowList;

    class TZRule implements Comparable<TZRule> {
        private int dayOfMonthIndicator;
        private DayOfWeek dayOfWeek;
        private Month month;
        private int savingAmountSecs;
        final /* synthetic */ ZoneRulesBuilder this$0;
        private LocalTime time;
        private ZoneOffsetTransitionRule.TimeDefinition timeDefinition;
        private boolean timeEndOfDay;
        private int year;

        static /* synthetic */ boolean access$1000(TZRule r0) {
            return r0.timeEndOfDay;
        }

        static /* synthetic */ ZoneOffsetTransitionRule.TimeDefinition access$1100(TZRule r0) {
            return r0.timeDefinition;
        }

        static /* synthetic */ int access$300(TZRule r0) {
            return r0.savingAmountSecs;
        }

        static /* synthetic */ int access$500(TZRule r0) {
            return r0.year;
        }

        static /* synthetic */ int access$502(TZRule r0, int r1) {
            r0.year = r1;
            return r1;
        }

        static /* synthetic */ Month access$600(TZRule r0) {
            return r0.month;
        }

        static /* synthetic */ int access$700(TZRule r0) {
            return r0.dayOfMonthIndicator;
        }

        static /* synthetic */ DayOfWeek access$800(TZRule r0) {
            return r0.dayOfWeek;
        }

        static /* synthetic */ LocalTime access$900(TZRule r0) {
            return r0.time;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(TZRule r1) {
            return compareTo2(r1);
        }

        TZRule(ZoneRulesBuilder r1, int r2, Month r3, int r4, DayOfWeek r5, LocalTime r6, boolean r7, ZoneOffsetTransitionRule.TimeDefinition r8, int r9) {
            this.this$0 = r1;
            this.year = r2;
            this.month = r3;
            this.dayOfMonthIndicator = r4;
            this.dayOfWeek = r5;
            this.time = r6;
            this.timeEndOfDay = r7;
            this.timeDefinition = r8;
            this.savingAmountSecs = r9;
        }

        ZoneOffsetTransition toTransition(ZoneOffset r4, int r5) {
            LocalDate r0 = toLocalDate();
            LocalDate r1 = (LocalDate) this.this$0.deduplicate(r0);
            LocalDateTime r2 = (LocalDateTime) this.this$0.deduplicate(LocalDateTime.of(r1, this.time));
            ZoneOffset r6 = (ZoneOffset) this.this$0.deduplicate(ZoneOffset.ofTotalSeconds(r4.getTotalSeconds() + r5));
            return new ZoneOffsetTransition((LocalDateTime) this.this$0.deduplicate(this.timeDefinition.createDateTime(r2, r4, r6)), r6, (ZoneOffset) this.this$0.deduplicate(ZoneOffset.ofTotalSeconds(r4.getTotalSeconds() + this.savingAmountSecs)));
        }

        ZoneOffsetTransitionRule toTransitionRule(ZoneOffset r12, int r13) {
            if (this.dayOfMonthIndicator >= 0) goto L8;
            if (this.month == Month.FEBRUARY) goto L8;
            this.dayOfMonthIndicator = this.month.maxLength() - 6;
        L8:
            if (this.timeEndOfDay == false) goto L22;
            int r0 = this.dayOfMonthIndicator;
            if (r0 <= 0) goto L22;
            if (r0 == 28) goto L14;
        L16:
            boolean r1 = false;
        L17:
            if (r1 == true) goto L22;
            LocalDate r2 = LocalDate.of(2004, this.month, this.dayOfMonthIndicator).plusDays(1);
            this.month = r2.getMonth();
            this.dayOfMonthIndicator = r2.getDayOfMonth();
            DayOfWeek r3 = this.dayOfWeek;
            if (r3 == null) goto L21;
            this.dayOfWeek = r3.plus(1);
        L21:
            this.timeEndOfDay = false;
            goto L22
        L14:
            if (this.month != Month.FEBRUARY) goto L16;
            r1 = true;
        L22:
            ZoneOffsetTransition r14 = toTransition(r12, r13);
            return new ZoneOffsetTransitionRule(this.month, this.dayOfMonthIndicator, this.dayOfWeek, this.time, this.timeEndOfDay, this.timeDefinition, r12, r14.getOffsetBefore(), r14.getOffsetAfter());
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(TZRule r3) {
            int r0 = this.year - r3.year;
            if (r0 != 0) goto L5;
            r0 = this.month.compareTo(r3.month);
        L5:
            if (r0 != 0) goto L7;
            r0 = toLocalDate().compareTo(r3.toLocalDate());
        L7:
            if (r0 == 0) goto L9;
            return r0;
        L9:
            return this.time.compareTo2(r3.time);
        }

        private LocalDate toLocalDate() {
            int r0 = this.dayOfMonthIndicator;
            if (r0 >= 0) goto L7;
            LocalDate r1 = LocalDate.of(this.year, this.month, (this.month.length(IsoChronology.INSTANCE.isLeapYear(this.year)) + 1) + this.dayOfMonthIndicator);
            DayOfWeek r2 = this.dayOfWeek;
            if (r2 == null) goto L11;
            r1 = r1.with(TemporalAdjusters.previousOrSame(r2));
        L11:
            if (this.timeEndOfDay == true) goto L13;
            return r1;
        L13:
            return r1.plusDays(1);
        L7:
            r1 = LocalDate.of(this.year, this.month, r0);
            DayOfWeek r3 = this.dayOfWeek;
            if (r3 == null) goto L11;
            r1 = r1.with(TemporalAdjusters.nextOrSame(r3));
            goto L11
        }
    }

    class TZWindow {
        private Integer fixedSavingAmountSecs;
        private List<TZRule> lastRuleList;
        private int maxLastRuleStartYear;
        private List<TZRule> ruleList;
        private final ZoneOffset standardOffset;
        final /* synthetic */ ZoneRulesBuilder this$0;
        private final ZoneOffsetTransitionRule.TimeDefinition timeDefinition;
        private final LocalDateTime windowEnd;

        static /* synthetic */ ZoneOffset access$000(TZWindow r0) {
            return r0.standardOffset;
        }

        static /* synthetic */ Integer access$100(TZWindow r0) {
            return r0.fixedSavingAmountSecs;
        }

        static /* synthetic */ List access$200(TZWindow r0) {
            return r0.ruleList;
        }

        static /* synthetic */ List access$400(TZWindow r0) {
            return r0.lastRuleList;
        }

        TZWindow(ZoneRulesBuilder r1, ZoneOffset r2, LocalDateTime r3, ZoneOffsetTransitionRule.TimeDefinition r4) {
            this.this$0 = r1;
            this.ruleList = new ArrayList();
            this.maxLastRuleStartYear = Year.MIN_VALUE;
            this.lastRuleList = new ArrayList();
            this.windowEnd = r3;
            this.timeDefinition = r4;
            this.standardOffset = r2;
        }

        void setFixedSavings(int r2) {
            if (this.ruleList.size() > 0) goto L9;
            if (this.lastRuleList.size() > 0) goto L9;
            this.fixedSavingAmountSecs = Integer.valueOf(r2);
            return;
        L9:
            throw new IllegalStateException("Window has DST rules, so cannot have fixed savings");
        }

        void addRule(int r16, int r17, Month r18, int r19, DayOfWeek r20, LocalTime r21, boolean r22, ZoneOffsetTransitionRule.TimeDefinition r23, int r24) {
            if (this.fixedSavingAmountSecs != null) goto L21;
            if (this.ruleList.size() >= 2000) goto L19;
            int r2 = r17;
            if (r2 != 999999999) goto L9;
            boolean r1 = true;
            r2 = r16;
        L10:
            int r13 = r16;
        L11:
            if (r13 > r2) goto L17;
            TZRule r14 = new TZRule(this.this$0, r13, r18, r19, r20, r21, r22, r23, r24);
            if (r1 == false) goto L15;
            this.lastRuleList.add(r14);
            this.maxLastRuleStartYear = Math.max(r16, this.maxLastRuleStartYear);
        L16:
            r13 = r13 + 1;
            goto L11
        L15:
            this.ruleList.add(r14);
            goto L16
        L17:
            return;
        L9:
            r1 = false;
            goto L10
        L19:
            throw new IllegalStateException("Window has reached the maximum number of allowed rules");
        L21:
            throw new IllegalStateException("Window has a fixed DST saving, so cannot have DST rules");
        }

        void validateWindowOrder(TZWindow r4) {
            if (this.windowEnd.isBefore(r4.windowEnd) == true) goto L6;
            return;
        L6:
            throw new IllegalStateException("Windows must be added in date-time order: " + this.windowEnd + " < " + r4.windowEnd);
        }

        void tidy(int r15) {
            if (this.lastRuleList.size() == 1) goto L26;
            if (this.windowEnd.equals(LocalDateTime.MAX) == false) goto L14;
            this.maxLastRuleStartYear = Math.max(this.maxLastRuleStartYear, r15) + 1;
            Iterator<TZRule> r16 = this.lastRuleList.iterator();
        L8:
            if (r16.hasNext() == false) goto L10;
            TZRule r0 = r16.next();
            addRule(TZRule.access$500(r0), this.maxLastRuleStartYear, TZRule.access$600(r0), TZRule.access$700(r0), TZRule.access$800(r0), TZRule.access$900(r0), TZRule.access$1000(r0), TZRule.access$1100(r0), TZRule.access$300(r0));
            TZRule.access$502(r0, this.maxLastRuleStartYear + 1);
            goto L8
        L10:
            int r17 = this.maxLastRuleStartYear;
            if (r17 != 999999999) goto L13;
            this.lastRuleList.clear();
        L19:
            Collections.sort(this.ruleList);
            Collections.sort(this.lastRuleList);
            if (this.ruleList.size() == 0) goto L22;
            return;
        L22:
            if (this.fixedSavingAmountSecs != null) goto L30;
            this.fixedSavingAmountSecs = 0;
            return;
        L30:
            return;
        L13:
            this.maxLastRuleStartYear = r17 + 1;
            goto L19
        L14:
            int r18 = this.windowEnd.getYear();
            Iterator<TZRule> r1 = this.lastRuleList.iterator();
        L16:
            if (r1.hasNext() == false) goto L18;
            TZRule r3 = r1.next();
            addRule(TZRule.access$500(r3), r18 + 1, TZRule.access$600(r3), TZRule.access$700(r3), TZRule.access$800(r3), TZRule.access$900(r3), TZRule.access$1000(r3), TZRule.access$1100(r3), TZRule.access$300(r3));
            goto L16
        L18:
            this.lastRuleList.clear();
            this.maxLastRuleStartYear = Year.MAX_VALUE;
            goto L19
        L26:
            throw new IllegalStateException("Cannot have only one rule defined as being forever");
        }

        boolean isSingleWindowStandardOffset() {
            if (this.windowEnd.equals(LocalDateTime.MAX) == true) goto L5;
        L13:
            return false;
        L5:
            if (this.timeDefinition != ZoneOffsetTransitionRule.TimeDefinition.WALL) goto L13;
            if (this.fixedSavingAmountSecs != null) goto L13;
            if (this.lastRuleList.isEmpty() == false) goto L13;
            if (this.ruleList.isEmpty() == false) goto L13;
            return true;
        }

        ZoneOffset createWallOffset(int r1) {
            return ZoneOffset.ofTotalSeconds(this.standardOffset.getTotalSeconds() + r1);
        }

        long createDateTimeEpochSecond(int r3) {
            ZoneOffset r4 = createWallOffset(r3);
            return this.timeDefinition.createDateTime(this.windowEnd, this.standardOffset, r4).toEpochSecond(r4);
        }
    }

    public ZoneRulesBuilder() {
        this.windowList = new ArrayList();
    }

    public ZoneRulesBuilder addWindow(ZoneOffset r2, LocalDateTime r3, ZoneOffsetTransitionRule.TimeDefinition r4) {
        Jdk8Methods.requireNonNull(r2, "standardOffset");
        Jdk8Methods.requireNonNull(r3, "until");
        Jdk8Methods.requireNonNull(r4, "untilDefinition");
        TZWindow r0 = new TZWindow(this, r2, r3, r4);
        if (this.windowList.size() <= 0) goto L5;
        List<TZWindow> r5 = this.windowList;
        r0.validateWindowOrder(r5.get(r5.size() - 1));
    L5:
        this.windowList.add(r0);
        return this;
    }

    public ZoneRulesBuilder addWindowForever(ZoneOffset r3) {
        return addWindow(r3, LocalDateTime.MAX, ZoneOffsetTransitionRule.TimeDefinition.WALL);
    }

    public ZoneRulesBuilder setFixedSavingsToWindow(int r3) {
        if (this.windowList.isEmpty() == true) goto L7;
        List<TZWindow> r0 = this.windowList;
        r0.get(r0.size() - 1).setFixedSavings(r3);
        return this;
    L7:
        throw new IllegalStateException("Must add a window before setting the fixed savings");
    }

    public ZoneRulesBuilder addRuleToWindow(LocalDateTime r12, ZoneOffsetTransitionRule.TimeDefinition r13, int r14) {
        Jdk8Methods.requireNonNull(r12, "transitionDateTime");
        return addRuleToWindow(r12.getYear(), r12.getYear(), r12.getMonth(), r12.getDayOfMonth(), null, r12.toLocalTime(), false, r13, r14);
    }

    public ZoneRulesBuilder addRuleToWindow(int r11, Month r12, int r13, LocalTime r14, boolean r15, ZoneOffsetTransitionRule.TimeDefinition r16, int r17) {
        return addRuleToWindow(r11, r11, r12, r13, null, r14, r15, r16, r17);
    }

    public ZoneRulesBuilder addRuleToWindow(int r13, int r14, Month r15, int r16, DayOfWeek r17, LocalTime r18, boolean r19, ZoneOffsetTransitionRule.TimeDefinition r20, int r21) {
        Jdk8Methods.requireNonNull(r15, "month");
        Jdk8Methods.requireNonNull(r18, "time");
        Jdk8Methods.requireNonNull(r20, "timeDefinition");
        ChronoField.YEAR.checkValidValue(r13);
        ChronoField.YEAR.checkValidValue(r14);
        if (r16 < (-28)) goto L20;
        if (r16 > 31) goto L20;
        if (r16 == 0) goto L20;
        if (r19 == false) goto L14;
        if (r18.equals(LocalTime.MIDNIGHT) == true) goto L14;
        throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
    L14:
        if (this.windowList.isEmpty() == true) goto L18;
        List<TZWindow> r1 = this.windowList;
        r1.get(r1.size() - 1).addRule(r13, r14, r15, r16, r17, r18, r19, r20, r21);
        return this;
    L18:
        throw new IllegalStateException("Must add a window before adding a rule");
    L20:
        throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
    }

    public ZoneRules toRules(String r2) {
        return toRules(r2, new HashMap());
    }

    ZoneRules toRules(String r21, Map<Object, Object> r22) {
        Jdk8Methods.requireNonNull(r21, "zoneId");
        this.deduplicateMap = r22;
        if (this.windowList.isEmpty() == true) goto L49;
        ArrayList r5 = new ArrayList(4);
        ArrayList r6 = new ArrayList(256);
        ArrayList r7 = new ArrayList(2);
        int r2 = 0;
        TZWindow r1 = this.windowList.get(0);
        ZoneOffset r3 = TZWindow.access$000(r1);
        if (TZWindow.access$100(r1) == null) goto L7;
        int r4 = TZWindow.access$100(r1).intValue();
    L8:
        ZoneOffset r8 = (ZoneOffset) deduplicate(ZoneOffset.ofTotalSeconds(r3.getTotalSeconds() + r4));
        LocalDateTime r9 = (LocalDateTime) deduplicate(LocalDateTime.of(Year.MIN_VALUE, 1, 1, 0, 0));
        Iterator<TZWindow> r11 = this.windowList.iterator();
        ZoneOffset r12 = r8;
    L10:
        if (r11.hasNext() == false) goto L47;
        TZWindow r13 = r11.next();
        r13.tidy(r9.getYear());
        Integer r14 = TZWindow.access$100(r13);
        if (r14 != null) goto L21;
        r14 = Integer.valueOf(r2);
        Iterator r15 = TZWindow.access$200(r13).iterator();
    L15:
        if (r15.hasNext() == false) goto L21;
        TZRule r10 = (TZRule) r15.next();
        if (r10.toTransition(r3, r4).toEpochSecond() > r9.toEpochSecond(r12)) goto L21;
        r14 = Integer.valueOf(TZRule.access$300(r10));
    L21:
        if (r3.equals(TZWindow.access$000(r13)) == true) goto L24;
        r5.add(deduplicate(new ZoneOffsetTransition(LocalDateTime.ofEpochSecond(r9.toEpochSecond(r12), r2, r3), r3, TZWindow.access$000(r13))));
        r3 = (ZoneOffset) deduplicate(TZWindow.access$000(r13));
    L24:
        ZoneOffset r16 = (ZoneOffset) deduplicate(ZoneOffset.ofTotalSeconds(r3.getTotalSeconds() + r14.intValue()));
        if (r12.equals(r16) == true) goto L27;
        r6.add((ZoneOffsetTransition) deduplicate(new ZoneOffsetTransition(r9, r12, r16)));
    L27:
        r4 = r14.intValue();
        Iterator r17 = TZWindow.access$200(r13).iterator();
    L29:
        if (r17.hasNext() == false) goto L41;
        TZRule r18 = (TZRule) r17.next();
        ZoneOffsetTransition r19 = (ZoneOffsetTransition) deduplicate(r18.toTransition(r3, r4));
        if (r19.toEpochSecond() >= r9.toEpochSecond(r12)) goto L33;
        int r110 = 1;
    L34:
        if (r110 != 0) goto L40;
        if (r19.toEpochSecond() >= r13.createDateTimeEpochSecond(r4)) goto L40;
        if (r19.getOffsetBefore().equals(r19.getOffsetAfter()) == true) goto L40;
        r6.add(r19);
        r4 = TZRule.access$300(r18);
    L40:
        r2 = 0;
        goto L29
    L33:
        r110 = r2;
        goto L34
    L41:
        Iterator r20 = TZWindow.access$400(r13).iterator();
    L43:
        if (r20.hasNext() == false) goto L45;
        TZRule r23 = (TZRule) r20.next();
        r7.add((ZoneOffsetTransitionRule) deduplicate(r23.toTransitionRule(r3, r4)));
        r4 = TZRule.access$300(r23);
        goto L43
    L45:
        r12 = (ZoneOffset) deduplicate(r13.createWallOffset(r4));
        r2 = 0;
        r9 = (LocalDateTime) deduplicate(LocalDateTime.ofEpochSecond(r13.createDateTimeEpochSecond(r4), 0, r12));
        r11 = r11;
        goto L10
    L47:
        return new StandardZoneRules(TZWindow.access$000(r1), r8, r5, r6, r7);
    L7:
        r4 = 0;
        goto L8
    L49:
        throw new IllegalStateException("No windows have been added to the builder");
    }

    <T> T deduplicate(T r2) {
        if (this.deduplicateMap.containsKey(r2) == true) goto L6;
        this.deduplicateMap.put(r2, r2);
    L6:
        return (T) this.deduplicateMap.get(r2);
    }
}
