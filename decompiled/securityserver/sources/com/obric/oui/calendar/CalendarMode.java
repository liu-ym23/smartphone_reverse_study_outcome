package com.obric.oui.calendar;

/* JADX INFO: loaded from: classes2.dex */
public final enum CalendarMode extends Enum<CalendarMode> {
    public static final CalendarMode c = null;
    public static final CalendarMode e = null;
    public static final /* synthetic */ CalendarMode[] f = null;
    public final int b;

    static {
        CalendarMode r0 = new CalendarMode("MONTHS", 0, 6);
        c = r0;
        CalendarMode r1 = new CalendarMode("WEEKS", 1, 1);
        e = r1;
        f = new CalendarMode[]{r0, r1};
    }

    public CalendarMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.b = r3;
    }

    public static CalendarMode valueOf(String r1) {
        return (CalendarMode) Enum.valueOf(CalendarMode.class, r1);
    }

    public static CalendarMode[] values() {
        return (CalendarMode[]) f.clone();
    }
}
