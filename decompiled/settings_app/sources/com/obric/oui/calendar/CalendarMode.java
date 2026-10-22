package com.obric.oui.calendar;

/* JADX INFO: loaded from: classes4.dex */
public final enum CalendarMode extends Enum<CalendarMode> {
    private static final /* synthetic */ CalendarMode[] $VALUES = null;
    public static final CalendarMode MONTHS = null;
    public static final CalendarMode WEEKS = null;
    final int visibleWeeksCount;

    public static CalendarMode valueOf(String r1) {
        return (CalendarMode) Enum.valueOf(CalendarMode.class, r1);
    }

    public static CalendarMode[] values() {
        return (CalendarMode[]) $VALUES.clone();
    }

    static {
        CalendarMode r0 = new CalendarMode("MONTHS", 0, 5);
        MONTHS = r0;
        CalendarMode r1 = new CalendarMode("WEEKS", 1, 1);
        WEEKS = r1;
        $VALUES = new CalendarMode[]{r0, r1};
    }

    private CalendarMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.visibleWeeksCount = r3;
    }
}
