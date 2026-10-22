package com.obric.oui.calendar;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.sheet.OSheetContentFrameLayout;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.f0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001EJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\nJ\u001f\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ7\u0010#\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0014¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0002H\u0014¢\u0006\u0004\b%\u0010\u0004R\u0016\u0010'\u001a\u00020\u00108\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0012\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u00100R0\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0002\u0018\u0001058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R0\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0002\u0018\u0001058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u00107\u001a\u0004\bB\u00109\"\u0004\bC\u0010;¨\u0006F"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lkotlin/f0;", "g", "()V", "", "second", "setSecond", "(I)V", "getSecond", "()I", "millisecond", "setMillisecond", "getMillisecond", "", "timestamp", "", "format", "f", "(JLjava/lang/String;)Ljava/lang/String;", "getSelectTimestamp", "()J", "selectedTime", "setCurrentTimeMillis", "(J)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "onAttachedToWindow", "Ljava/lang/String;", "TAG", "Landroid/widget/TextView;", "k", "Landroid/widget/TextView;", "currentDateTextView", "i", "J", "mSelectTime", "h", "I", "Lcom/obric/oui/calendar/MaterialCalendarView;", "j", "Lcom/obric/oui/calendar/MaterialCalendarView;", "calendarView", "Lkotlin/Function1;", "m", "Lkotlin/n0/c/l;", "getOnDateChangedListener", "()Lkotlin/n0/c/l;", "setOnDateChangedListener", "(Lkotlin/n0/c/l;)V", "onDateChangedListener", "Lcom/obric/oui/calendar/ODatePickerView$a;", "n", "Lcom/obric/oui/calendar/ODatePickerView$a;", "mDatePickerMode", "l", "getOnMonthChangedListener", "setOnMonthChangedListener", "onMonthChangedListener", "a", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class ODatePickerView extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f10857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10858g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10859h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f10860i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MaterialCalendarView f10861j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f10862k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private kotlin.n0.c.l<? super Long, f0> f10863l;
    private kotlin.n0.c.l<? super Long, f0> m;
    private a n;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f10864f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f10865g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ a[] f10866h = null;

        static {
            a r1 = new a("BOARD_SHEET", 0);
            f10864f = r1;
            a r2 = new a("NARROW_SHEET", 1);
            f10865g = r2;
            f10866h = new a[]{r1, r2};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f10866h.clone();
        }
    }

    static {
    }

    private final String f(long r2, String r4) {
        Date r1 = new Date(r2);
        SimpleDateFormat r3 = new SimpleDateFormat(r4, Locale.getDefault());
        r3.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
        String r5 = r3.format(r1);
        kotlin.n0.d.o.e(r5, "formattedData");
        String r6 = r5.substring(0, 4);
        kotlin.n0.d.o.e(r6, "this as java.lang.String…ing(startIndex, endIndex)");
        String r7 = r5.substring(5, 7);
        kotlin.n0.d.o.e(r7, "this as java.lang.String…ing(startIndex, endIndex)");
        return r6 + " 年 " + r7 + " 月";
    }

    private final void g() {
        Calendar r0 = Calendar.getInstance();
        com.obric.oui.common.util.d r1 = com.obric.oui.common.util.d.f10944b;
        r1.b(this.f10857f, "默认选中的时间:" + this.f10860i + " , mSelectTime:" + this.f10860i);
        kotlin.n0.d.o.e(r0, "calendar");
        r0.setTimeInMillis(this.f10860i);
        int r3 = r0.get(1);
        int r4 = r0.get(2) + 1;
        int r2 = r0.get(5);
        int r5 = r0.get(11);
        int r6 = r0.get(12);
        int r7 = r0.get(13);
        int r8 = r0.get(14);
        r1.b(this.f10857f, "转化时间year:" + r3 + ",month:" + r4 + ",day:" + r2 + ",hour:" + r5 + ",minute:" + r6 + ", selectDate:" + CalendarDay.b(r3, r4, r2));
        long r9 = this.f10860i;
        String r10 = getResources().getString(com.obric.common.oui.i.f8264a);
        kotlin.n0.d.o.e(r10, "resources.getString(R.st….date_picker_date_format)");
        String r11 = f(r9, r10);
        this.f10861j.setCurrentDate(CalendarDay.b(r3, r4, r2));
        this.f10861j.setSelectedDate(CalendarDay.b(r3, r4, r2));
        this.f10862k.setText(r11);
        setSecond(r7);
        setMillisecond(r8);
    }

    private final int getMillisecond() {
        return this.f10859h;
    }

    private final int getSecond() {
        return this.f10858g;
    }

    private final void setMillisecond(int r1) {
        this.f10859h = r1;
    }

    private final void setSecond(int r1) {
        this.f10858g = r1;
    }

    public final kotlin.n0.c.l<Long, f0> getOnDateChangedListener() {
        return this.m;
    }

    public final kotlin.n0.c.l<Long, f0> getOnMonthChangedListener() {
        return this.f10863l;
    }

    public final long getSelectTimestamp() {
        Calendar r6 = Calendar.getInstance();
        CalendarDay r0 = this.f10861j.getSelectedDates().get(0);
        kotlin.n0.d.o.e(r0, "selectDate");
        int r1 = r0.h();
        int r2 = r0.g() - 1;
        int r3 = r0.f();
        r6.set(13, getSecond());
        r6.set(14, getMillisecond());
        r6.set(r1, r2, r3, 0, 0);
        kotlin.n0.d.o.e(r6, "calendar");
        return r6.getTimeInMillis();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.g.d.f.b r0 = d.g.d.f.b.f16934a;
        ViewParent r1 = getParent();
        if (r1 != null) goto L6;
    L4:
        r1 = null;
    L7:
        ViewGroup r2 = (ViewGroup) r1;
        if ((r2 instanceof OSheetContentFrameLayout) == false) goto L35;
        OSheetContentFrameLayout r3 = (OSheetContentFrameLayout) r2;
        if (r3.getId() != com.obric.common.oui.f.H) goto L36;
        int r4 = r3.getPaddingLeft();
        int r5 = r3.getPaddingTop();
        int r6 = r3.getPaddingRight();
        int r7 = r3.getPaddingBottom();
        int r8 = n.f10911a[this.n.ordinal()];
        if (r8 != 1) goto L14;
        float r9 = 16;
        Resources r10 = Resources.getSystem();
        kotlin.n0.d.o.e(r10, "Resources.getSystem()");
        if (r4 != kotlin.o0.a.a(TypedValue.applyDimension(1, r9, r10.getDisplayMetrics()))) goto L33;
        Resources r12 = Resources.getSystem();
        kotlin.n0.d.o.e(r12, "Resources.getSystem()");
        if (r5 != kotlin.o0.a.a(TypedValue.applyDimension(1, 6, r12.getDisplayMetrics()))) goto L33;
        Resources r11 = Resources.getSystem();
        kotlin.n0.d.o.e(r11, "Resources.getSystem()");
        if (r6 != kotlin.o0.a.a(TypedValue.applyDimension(1, r9, r11.getDisplayMetrics()))) goto L33;
        Resources r13 = Resources.getSystem();
        kotlin.n0.d.o.e(r13, "Resources.getSystem()");
        if (r7 != kotlin.o0.a.a(TypedValue.applyDimension(1, r9, r13.getDisplayMetrics()))) goto L33;
        return;
    L33:
        d.g.d.f.f.b.a(this.f10857f, "onAttachedToWindow, we are inside an broad inset sheet, current parent padding: [" + r4 + ", " + r5 + ", " + r6 + ", " + r7 + ']');
        Resources r14 = Resources.getSystem();
        kotlin.n0.d.o.e(r14, "Resources.getSystem()");
        int r15 = kotlin.o0.a.a(TypedValue.applyDimension(1, r9, r14.getDisplayMetrics()));
        Resources r16 = Resources.getSystem();
        kotlin.n0.d.o.e(r16, "Resources.getSystem()");
        int r17 = kotlin.o0.a.a(TypedValue.applyDimension(1, (float) 6, r16.getDisplayMetrics()));
        Resources r18 = Resources.getSystem();
        kotlin.n0.d.o.e(r18, "Resources.getSystem()");
        int r19 = kotlin.o0.a.a(TypedValue.applyDimension(1, r9, r18.getDisplayMetrics()));
        Resources r20 = Resources.getSystem();
        kotlin.n0.d.o.e(r20, "Resources.getSystem()");
        r2.setPadding(r15, r17, r19, kotlin.o0.a.a(TypedValue.applyDimension(1, r9, r20.getDisplayMetrics())));
        return;
    L14:
        if (r8 != 2) goto L40;
        float r110 = 0;
        Resources r111 = Resources.getSystem();
        kotlin.n0.d.o.e(r111, "Resources.getSystem()");
        if (r4 != kotlin.o0.a.a(TypedValue.applyDimension(1, r110, r111.getDisplayMetrics()))) goto L24;
        Resources r112 = Resources.getSystem();
        kotlin.n0.d.o.e(r112, "Resources.getSystem()");
        if (r5 != kotlin.o0.a.a(TypedValue.applyDimension(1, r110, r112.getDisplayMetrics()))) goto L24;
        Resources r113 = Resources.getSystem();
        kotlin.n0.d.o.e(r113, "Resources.getSystem()");
        if (r6 != kotlin.o0.a.a(TypedValue.applyDimension(1, r110, r113.getDisplayMetrics()))) goto L24;
        Resources r114 = Resources.getSystem();
        kotlin.n0.d.o.e(r114, "Resources.getSystem()");
        if (r7 != kotlin.o0.a.a(TypedValue.applyDimension(1, r110, r114.getDisplayMetrics()))) goto L24;
        return;
    L24:
        d.g.d.f.f.b.a(this.f10857f, "onAttachedToWindow, we are inside an narrow inset sheet, current parent padding: [" + r4 + ", " + r5 + ", " + r6 + ", " + r7 + ']');
        r2.setPadding(0, 0, 0, 0);
        return;
    L40:
        return;
    L36:
        return;
    L35:
        return;
    L6:
        if ((r1 instanceof ViewGroup) == false) goto L4;
        goto L4
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void setCurrentTimeMillis(long r1) {
        this.f10860i = r1;
        g();
    }

    public final void setOnDateChangedListener(kotlin.n0.c.l<? super Long, f0> r1) {
        this.m = r1;
    }

    public final void setOnMonthChangedListener(kotlin.n0.c.l<? super Long, f0> r1) {
        this.f10863l = r1;
    }
}
