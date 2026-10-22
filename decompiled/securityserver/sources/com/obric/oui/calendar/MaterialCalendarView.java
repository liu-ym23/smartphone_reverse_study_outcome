package com.obric.oui.calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.securityserver.R;
import com.obric.oui.calendar.format.ArrayWeekDayFormatter;
import com.obric.oui.calendar.format.DayFormatter;
import com.obric.oui.calendar.format.MonthArrayTitleFormatter;
import com.obric.oui.calendar.format.TitleFormatter;
import com.obric.oui.calendar.format.WeekDayFormatter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialCalendarView extends ViewGroup {
    public static final /* synthetic */ int G = 0;
    public int A;
    public int B;
    public boolean C;
    public DayOfWeek D;
    public boolean E;
    public State F;
    public final TitleChanger b;
    public final TextView c;
    public final ImageView e;
    public final ImageView f;
    public final CalendarPager i;
    public CalendarPagerAdapter j;
    public CalendarDay k;
    public final LinearLayout l;
    public CalendarMode m;
    public boolean n;
    public final ViewPager.OnPageChangeListener o;
    public CalendarDay p;
    public CalendarDay q;
    public OnDateSelectedListener r;
    public OnDateLongClickListener s;
    public OnMonthChangedListener t;
    public OnRangeSelectedListener u;
    public CharSequence v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* JADX INFO: renamed from: com.obric.oui.calendar.MaterialCalendarView$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f183a = null;

        static {
            int[] r0 = new int[CalendarMode.values().length];
            f183a = r0;
            r0[0] = 1;     // Catch: NoSuchFieldError -> L6
        L10:
            f183a[1] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(int r2) {
            super(-1, r2);
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int b;
        public boolean c;
        public CalendarDay e;
        public CalendarDay f;
        public List i;
        public boolean j;
        public int k;
        public boolean l;
        public CalendarDay m;
        public boolean n;

        /* JADX INFO: renamed from: com.obric.oui.calendar.MaterialCalendarView$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r6) {
                SavedState r5 = new SavedState(r6);
                r5.b = 4;
                boolean r0 = true;
                r5.c = true;
                r5.e = null;
                r5.f = null;
                r5.i = new ArrayList();
                r5.j = true;
                r5.k = 1;
                r5.l = false;
                r5.m = null;
                r5.b = r6.readInt();
                if (r6.readByte() == 0) goto L5;
                boolean r1 = true;
            L6:
                r5.c = r1;
                ClassLoader r2 = CalendarDay.class.getClassLoader();
                r5.e = (CalendarDay) r6.readParcelable(r2);
                r5.f = (CalendarDay) r6.readParcelable(r2);
                r6.readTypedList(r5.i, CalendarDay.CREATOR);
                if (r6.readInt() != 1) goto L9;
                boolean r3 = true;
            L10:
                r5.j = r3;
                r5.k = r6.readInt();
                if (r6.readInt() != 1) goto L13;
                boolean r4 = true;
            L14:
                r5.l = r4;
                r5.m = (CalendarDay) r6.readParcelable(r2);
                if (r6.readByte() != 0) goto L18;
                r0 = false;
            L18:
                r5.n = r0;
                return r5;
            L13:
                r4 = false;
                goto L14
            L9:
                r3 = false;
                goto L10
            L5:
                r1 = false;
                goto L6
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r1) {
                return new SavedState[r1];
            }
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            r2.writeInt(this.b);
            r2.writeByte(this.c ? 1 : 0);
            r2.writeParcelable(this.e, 0);
            r2.writeParcelable(this.f, 0);
            r2.writeTypedList(this.i);
            r2.writeInt(this.j ? 1 : 0);
            r2.writeInt(this.k);
            r2.writeInt(this.l ? 1 : 0);
            r2.writeParcelable(this.m, 0);
            r2.writeByte(this.n ? 1 : 0);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SelectionMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"UniqueConstants"})
    public @interface ShowOtherDates {
    }

    public class State {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CalendarMode f184a;
        public final DayOfWeek b;
        public final CalendarDay c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final CalendarDay f185d;
        public final boolean e;
        public final boolean f;
        public final /* synthetic */ MaterialCalendarView g;

        public State(MaterialCalendarView r1, StateBuilder r2) {
            this.g = r1;
            this.f184a = r2.f186a;
            this.b = r2.b;
            this.c = r2.f187d;
            this.f185d = r2.e;
            this.e = r2.c;
            this.f = r2.f;
        }

        public static /* synthetic */ CalendarMode a(State r0) {
            return r0.f184a;
        }

        public static /* synthetic */ DayOfWeek b(State r0) {
            return r0.b;
        }

        public static /* synthetic */ CalendarDay c(State r0) {
            return r0.c;
        }

        public static /* synthetic */ CalendarDay d(State r0) {
            return r0.f185d;
        }

        public static /* synthetic */ boolean e(State r0) {
            return r0.f;
        }

        public static /* synthetic */ boolean f(State r0) {
            return r0.e;
        }
    }

    public class StateBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CalendarMode f186a;
        public DayOfWeek b;
        public boolean c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CalendarDay f187d;
        public CalendarDay e;
        public boolean f;
        public final /* synthetic */ MaterialCalendarView g;

        public StateBuilder(MaterialCalendarView r4) {
            this.g = r4;
            this.c = false;
            this.f187d = null;
            this.e = null;
            this.f186a = CalendarMode.c;
            this.b = LocalDate.now().with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1).getDayOfWeek();
        }

        public final void a() {
            MaterialCalendarView r1 = this.g;
            State r0 = new State(r1, this);
            int r2 = MaterialCalendarView.G;
            r1.b(r0);
        }

        public final void b(CalendarMode r1) {
            this.f186a = r1;
        }

        public final void c(DayOfWeek r1) {
            this.b = r1;
        }

        public final void d(boolean r1) {
            this.f = r1;
        }

        public StateBuilder(MaterialCalendarView r1, State r2) {
            this.g = r1;
            this.c = false;
            this.f187d = null;
            this.e = null;
            this.f186a = r2.f184a;
            this.b = r2.b;
            this.f187d = r2.c;
            this.e = r2.f185d;
            this.c = r2.e;
            this.f = r2.f;
        }
    }

    public MaterialCalendarView(Context r11, AttributeSet r12) {
        super(r11, r12);
        new ArrayList();
        View.OnClickListener r0 = new AnonymousClass1(this);
        ViewPager.OnPageChangeListener r1 = new AnonymousClass2(this);
        this.p = null;
        this.q = null;
        this.w = 0;
        this.x = -10;
        this.y = -10;
        this.z = -10;
        this.A = -10;
        this.B = 1;
        this.C = true;
        setClipToPadding(false);
        setClipChildren(false);
        View r2 = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.calendar_view, null, false);
        this.l = (LinearLayout) r2.findViewById(R.id.header);
        ImageView r6 = (ImageView) r2.findViewById(R.id.previous);
        this.e = r6;
        TextView r7 = (TextView) r2.findViewById(R.id.month_name);
        this.c = r7;
        ImageView r3 = (ImageView) r2.findViewById(R.id.next);
        this.f = r3;
        CalendarPager r8 = new CalendarPager(getContext());
        this.i = r8;
        r6.setOnClickListener(r0);
        r3.setOnClickListener(r0);
        TitleChanger r4 = new TitleChanger(r7);
        this.b = r4;
        r8.setOnPageChangeListener(r1);
        r8.setPageTransformer(false, new AnonymousClass3());
        TypedArray r13 = r11.getTheme().obtainStyledAttributes(r12, com.obric.common.oui.R.styleable.w, 0, 0);
        int r5 = r13.getInteger(1, 0);     // Catch: Throwable -> L7 Exception -> L9
        int r9 = r13.getInteger(3, -1);     // Catch: Throwable -> L7 Exception -> L9
        r4.c(r13.getInteger(17, 0));     // Catch: Throwable -> L7 Exception -> L9
        if (r9 < 1) goto L11;
        if (r9 > 7) goto L11;
        this.D = DayOfWeek.of(r9);     // Catch: Throwable -> L7 Exception -> L9
    L12:
        this.E = r13.getBoolean(11, true);     // Catch: Throwable -> L7 Exception -> L9
        StateBuilder r10 = new StateBuilder(this);     // Catch: Throwable -> L7 Exception -> L9
        r10.c(this.D);     // Catch: Throwable -> L7 Exception -> L9
        r10.b(CalendarMode.values()[r5]);     // Catch: Throwable -> L7 Exception -> L9
        r10.d(this.E);     // Catch: Throwable -> L7 Exception -> L9
        r10.a();     // Catch: Throwable -> L7 Exception -> L9
        setSelectionMode(r13.getInteger(9, 1));     // Catch: Throwable -> L7 Exception -> L9
        int r14 = r13.getLayoutDimension(14, -10);     // Catch: Throwable -> L7 Exception -> L9
        if (r14 <= (-10)) goto L15;
        setTileSize(r14);     // Catch: Throwable -> L7 Exception -> L9
    L15:
        int r15 = r13.getLayoutDimension(16, -10);     // Catch: Throwable -> L7 Exception -> L9
        if (r15 <= (-10)) goto L18;
        setTileWidth(r15);     // Catch: Throwable -> L7 Exception -> L9
    L18:
        int r16 = r13.getLayoutDimension(13, -10);     // Catch: Throwable -> L7 Exception -> L9
        if (r16 <= (-10)) goto L21;
        setTileHeight(r16);     // Catch: Throwable -> L7 Exception -> L9
    L21:
        int r17 = r13.getLayoutDimension(12, -10);     // Catch: Throwable -> L7 Exception -> L9
        if (r15 <= (-10)) goto L24;
        setTileHSpacing(r17);     // Catch: Throwable -> L7 Exception -> L9
    L24:
        int r18 = r13.getLayoutDimension(15, -10);     // Catch: Throwable -> L7 Exception -> L9
        if (r15 <= (-10)) goto L27;
        setTileVSpacing(r18);     // Catch: Throwable -> L7 Exception -> L9
    L27:
        setLeftArrow(r13.getResourceId(5, R.drawable.o_mcv_action_previous));     // Catch: Throwable -> L7 Exception -> L9
        setRightArrow(r13.getResourceId(7, R.drawable.o_mcv_action_next));     // Catch: Throwable -> L7 Exception -> L9
        TypedValue r19 = new TypedValue();     // Catch: Throwable -> L7 Exception -> L9
        r11.getTheme().resolveAttribute(android.R.attr.colorAccent, r19, true);     // Catch: Throwable -> L7 Exception -> L9
        setSelectionColor(r13.getColor(8, r19.data));     // Catch: Throwable -> L7 Exception -> L9
        CharSequence[] r110 = r13.getTextArray(18);     // Catch: Throwable -> L7 Exception -> L9
        if (r110 == null) goto L30;
        setWeekDayFormatter(new ArrayWeekDayFormatter(r110));     // Catch: Throwable -> L7 Exception -> L9
    L30:
        CharSequence[] r111 = r13.getTextArray(6);     // Catch: Throwable -> L7 Exception -> L9
        if (r111 == null) goto L33;
        setTitleFormatter(new MonthArrayTitleFormatter(r111));     // Catch: Throwable -> L7 Exception -> L9
    L33:
        setHeaderTextAppearance(r13.getResourceId(4, R.style.TextAppearance_MaterialCalendarWidget_Header));     // Catch: Throwable -> L7 Exception -> L9
        setWeekDayTextAppearance(r13.getResourceId(19, R.style.TextAppearance_MaterialCalendarWidget_WeekDay));     // Catch: Throwable -> L7 Exception -> L9
        setDateTextAppearance(r13.getResourceId(2, R.style.TextAppearance_MaterialCalendarWidget_Date));     // Catch: Throwable -> L7 Exception -> L9
        setShowOtherDates(r13.getInteger(10, 4));     // Catch: Throwable -> L7 Exception -> L9
        setAllowClickDaysOutsideCurrentMonth(r13.getBoolean(0, true));     // Catch: Throwable -> L7 Exception -> L9
    L34:
        r13.recycle();
        addView(this.l);
        CalendarPager r112 = this.i;
        r112.setId(R.id.mcv_pager);
        r112.setOffscreenPageLimit(1);
        if (this.E == false) goto L40;
        int r113 = this.m.b + 1;
    L41:
        addView(r112, new LayoutParams(-1, r113));
        CalendarDay r114 = CalendarDay.h();
        this.k = r114;
        setCurrentDate(r114);
        if (isInEditMode() == false) goto L50;
        removeView(this.i);
        MonthView r115 = new MonthView(this, this.k, getFirstDayOfWeek());
        r115.l(getSelectionColor());
        r115.g(this.j.d());
        r115.p(this.j.i());
        r115.n(getShowOtherDates());
        addView(r115, new LayoutParams(this.m.b + 1));
        return;
    L50:
        return;
    L40:
        r113 = this.m.b;
        goto L41
    L11:
        this.D = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();     // Catch: Throwable -> L7 Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        r13.recycle();
        throw th;
    }

    public static boolean e(int r1) {
        if ((r1 & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private int getWeekCountBasedOnMode() {
        CalendarMode r0 = this.m;
        int r1 = r0.b;
        if (r0.equals(CalendarMode.c) == false) goto L12;
        if (this.n == false) goto L12;
        CalendarPagerAdapter r2 = this.j;
        if (r2 == null) goto L12;
        CalendarPager r3 = this.i;
        if (r3 == null) goto L12;
        LocalDate r4 = r2.f(r3.getCurrentItem()).b();
        r1 = r4.withDayOfMonth(r4.lengthOfMonth()).get(WeekFields.of(this.D, 1).weekOfMonth());
    L12:
        if (this.E == true) goto L14;
        return r1;
    L14:
        return r1 + 1;
    }

    public final void a() {
        List<CalendarDay> r0 = getSelectedDates();
        this.j.a();
        Iterator<CalendarDay> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        c(r1.next(), false);
        goto L4
    }

    public final void b(State r7) {
        CalendarPagerAdapter r0 = this.j;
        CalendarPager r1 = this.i;
        if (r0 != null) goto L5;
    L32:
        CalendarDay r2 = null;
    L33:
        this.F = r7;
        this.m = State.a(r7);
        this.D = State.b(r7);
        this.p = State.c(r7);
        this.q = State.d(r7);
        this.E = State.e(r7);
        int r8 = this.m.ordinal();
        if (r8 == 0) goto L39;
        if (r8 != 1) goto L38;
        CalendarPagerAdapter r9 = new WeekPagerAdapter(this);
    L40:
        CalendarPagerAdapter r3 = this.j;
        if (r3 != null) goto L43;
        this.j = r9;
    L44:
        this.j.x(this.E);
        r1.setAdapter(this.j);
        CalendarDay r10 = this.p;
        CalendarDay r4 = this.q;
        CalendarDay r5 = this.k;
        this.j.t(r10, r4);
        this.k = r5;
        if (r10 != null) goto L47;
    L51:
        r1.setCurrentItem(this.j.e(r5), false);
        f();
        if (this.E == false) goto L54;
        int r11 = this.m.b + 1;
    L55:
        r1.setLayoutParams(new LayoutParams(r11));
        if (this.B == 1) goto L58;
    L60:
        CalendarDay r12 = CalendarDay.h();
    L61:
        setCurrentDate(r12);
        if (r2 == null) goto L64;
        r1.setCurrentItem(this.j.e(r2));
    L64:
        this.j.k();
        f();
        return;
    L58:
        if (this.j.g().isEmpty() == true) goto L60;
        r12 = (CalendarDay) this.j.g().get(0);
        goto L61
    L54:
        r11 = this.m.b;
        goto L55
    L47:
        if (r10.f(r5) == true) goto L50;
        r10 = this.k;
    L50:
        this.k = r10;
        goto L51
    L43:
        r3.n(r9);
        this.j = r9;
        goto L44
    L38:
        throw new IllegalArgumentException("Provided display mode which is not yet implemented");
    L39:
        r9 = new MonthPagerAdapter(this);
        goto L40
    L5:
        if (State.f(r7) == false) goto L32;
        r2 = this.j.f(r1.getCurrentItem());
        if (this.m == State.a(r7)) goto L33;
        CalendarDay r6 = getSelectedDate();
        CalendarMode r13 = this.m;
        if (r13 != CalendarMode.c) goto L19;
        if (r6 == null) goto L19;
        CalendarDay r14 = CalendarDay.a(r2.b().plusDays(1));
        if (r6.equals(r2) == false) goto L14;
    L30:
        r2 = r6;
        goto L33
    L14:
        if (r6.f(r2) == false) goto L33;
        if (r6.g(r14) == false) goto L33;
    L19:
        if (r13 != CalendarMode.e) goto L33;
        CalendarDay r15 = CalendarDay.a(r2.b().plusDays(6));
        if (r6 != null) goto L23;
    L31:
        r2 = r15;
        goto L33
    L23:
        if (r6.equals(r2) == true) goto L30;
        if (r6.equals(r15) == true) goto L30;
        if (r6.f(r2) == false) goto L31;
        if (r6.g(r15) == false) goto L31;
        goto L30
    }

    public final void c(CalendarDay r1, boolean r2) {
        OnDateSelectedListener r3 = this.r;
        if (r3 != null) goto L5;
        return;
    L5:
        r3.a(this, r1);
        throw null;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    public final int d(int r2) {
        return (int) TypedValue.applyDimension(1, r2, getResources().getDisplayMetrics());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray r1) {
        dispatchThawSelfOnly(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray r1) {
        dispatchFreezeSelfOnly(r1);
    }

    public final void f() {
        CalendarDay r0 = this.k;
        TitleChanger r1 = this.b;
        r1.getClass();
        long r2 = System.currentTimeMillis();
        boolean r4 = true;
        if (r0 != null) goto L6;
    L18:
        CalendarPager r3 = this.i;
        if (r3.getCurrentItem() <= 0) goto L21;
        boolean r5 = true;
    L22:
        ImageView r6 = this.e;
        r6.setEnabled(r5);
        float r7 = 0.1f;
        if (r5 == false) goto L25;
        float r8 = 1.0f;
    L26:
        r6.setAlpha(r8);
        if (r3.getCurrentItem() < (this.j.getCount() - 1)) goto L30;
        r4 = false;
    L30:
        ImageView r10 = this.f;
        r10.setEnabled(r4);
        if (r4 == false) goto L33;
        r7 = 1.0f;
    L33:
        r10.setAlpha(r7);
        return;
    L25:
        r8 = 0.1f;
        goto L26
    L21:
        r5 = false;
        goto L22
    L6:
        if (TextUtils.isEmpty(r1.f189a.getText()) == false) goto L8;
    L9:
        r1.a(r2, r0, false);
    L11:
        if (r0.equals(r1.i) == true) goto L18;
        if (r0.d() == r1.i.d()) goto L15;
    L17:
        r1.a(r2, r0, true);
        goto L18
    L15:
        if (r0.e() != r1.i.e()) goto L17;
    L8:
        if ((r2 - r1.h) >= r1.c) goto L11;
        goto L9
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, 1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(-1, 1);
    }

    public CharSequence getCalendarContentDescription() {
        CharSequence r0 = this.v;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return getContext().getString(R.string.oui_calendar);
    }

    public CalendarMode getCalendarMode() {
        return this.m;
    }

    public CalendarDay getCurrentDate() {
        return this.j.f(this.i.getCurrentItem());
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.D;
    }

    public Drawable getLeftArrow() {
        return this.e.getDrawable();
    }

    public CalendarDay getMaximumDate() {
        return this.q;
    }

    public CalendarDay getMinimumDate() {
        return this.p;
    }

    public Drawable getRightArrow() {
        return this.f.getDrawable();
    }

    @Nullable
    public CalendarDay getSelectedDate() {
        List r1 = this.j.g();
        if (r1.isEmpty() == false) goto L7;
        return null;
    L7:
        return (CalendarDay) r1.get(r1.size() - 1);
    }

    @NonNull
    public List<CalendarDay> getSelectedDates() {
        return this.j.g();
    }

    public int getSelectionColor() {
        return this.w;
    }

    public int getSelectionMode() {
        return this.B;
    }

    public int getShowOtherDates() {
        return this.j.h();
    }

    public int getTileHSpacing() {
        return this.z;
    }

    public int getTileHeight() {
        return this.x;
    }

    @Deprecated
    public int getTileSize() {
        return Math.max(this.x, this.y);
    }

    public int getTileVSpacing() {
        return this.A;
    }

    public int getTileWidth() {
        return this.y;
    }

    public int getTitleAnimationOrientation() {
        return this.b.g;
    }

    public boolean getTopbarVisible() {
        if (this.l.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent r1) {
        super.onInitializeAccessibilityEvent(r1);
        r1.setClassName(MaterialCalendarView.class.getName());
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        r1.setClassName(MaterialCalendarView.class.getName());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        int r10 = getChildCount();
        int r11 = getPaddingLeft();
        int r12 = ((r8 - r6) - r11) - getPaddingRight();
        int r13 = getPaddingTop();
        int r14 = 0;
    L3:
        if (r14 >= r10) goto L9;
        View r0 = getChildAt(r14);
        if (r0.getVisibility() == 8) goto L8;
        int r1 = r0.getMeasuredWidth();
        int r3 = ((r12 - r1) / 2) + r11;
        int r2 = r0.getMeasuredHeight() + r13;
        r0.layout(r3, r13, r1 + r3, r2);
        r13 = r2;
    L8:
        r14 = r14 + 1;
        goto L3
    }

    @Override // android.view.View
    public final void onMeasure(int r13, int r14) {
        int r0 = View.MeasureSpec.getSize(r13);
        int r1 = View.MeasureSpec.getMode(r13);
        int r2 = View.MeasureSpec.getSize(r14);
        int r3 = View.MeasureSpec.getMode(r14);
        int r4 = (r0 - getPaddingLeft()) - getPaddingRight();
        int r5 = (r2 - getPaddingTop()) - getPaddingBottom();
        int r6 = getWeekCountBasedOnMode();
        if (getTopbarVisible() == false) goto L5;
        r6 = r6 + 1;
    L5:
        int r7 = r4 / 7;
        int r8 = r5 / r6;
        int r9 = this.y;
        int r10 = -1;
        if (r9 == (-10)) goto L8;
    L21:
        if (r9 <= 0) goto L23;
        r7 = r9;
    L23:
        int r11 = this.x;
        if (r11 <= 0) goto L26;
        r8 = r11;
    L26:
        r10 = r7;
        r7 = -1;
    L27:
        if (r7 <= 0) goto L29;
        r8 = r7;
    L38:
        int r12 = 0;
        int r15 = r7 * 7;
        int r16 = ((Math.max(this.A, 0) + r8) * Math.max(0, r6 - 1)) + r8;
        int r17 = (getPaddingRight() + getPaddingLeft()) + r15;
        int r18 = (getPaddingBottom() + getPaddingTop()) + r16;
        int r19 = View.MeasureSpec.getMode(r13);
        int r110 = View.MeasureSpec.getSize(r13);
        if (r19 == Integer.MIN_VALUE) goto L43;
        if (r19 != 1073741824) goto L44;
        r17 = r110;
    L44:
        int r111 = View.MeasureSpec.getMode(r14);
        int r112 = View.MeasureSpec.getSize(r14);
        if (r111 == Integer.MIN_VALUE) goto L49;
        if (r111 != 1073741824) goto L50;
        r18 = r112;
    L50:
        setMeasuredDimension(r17, r18);
        int r113 = getChildCount();
        int r114 = Math.max(this.z, 0);
    L51:
        if (r12 >= r113) goto L53;
        View r20 = getChildAt(r12);
        r20.measure(View.MeasureSpec.makeMeasureSpec((r114 * 6) + r15, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) ((LayoutParams) r20.getLayoutParams())).height * r8, BasicMeasure.EXACTLY));
        r12 = r12 + 1;
        goto L51
    L53:
        return;
    L49:
        r18 = Math.min(r18, r112);
        goto L50
    L43:
        r17 = Math.min(r17, r110);
        goto L44
    L29:
        if (r7 <= 0) goto L31;
        r7 = r10;
        goto L38
    L31:
        if (r10 > 0) goto L33;
        int r21 = d(44);
    L34:
        if (r8 > 0) goto L36;
        r8 = d(44);
    L36:
        r7 = r21;
        goto L38
    L33:
        r21 = r10;
        goto L34
    L8:
        if (this.x != (-10)) goto L21;
        if (r1 == 1073741824) goto L19;
        if (r1 == Integer.MIN_VALUE) goto L19;
        if (r3 == 1073741824) goto L17;
        if (r3 == Integer.MIN_VALUE) goto L17;
        r7 = -1;
        r8 = -1;
    L17:
        r7 = r8;
    L18:
        r8 = -1;
    L19:
        if (r3 != 1073741824) goto L18;
        r7 = Math.min(r7, r8);
        goto L18
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r5) {
        SavedState r6 = (SavedState) r5;
        super.onRestoreInstanceState(r6.getSuperState());
        State r0 = this.F;
        StateBuilder r1 = new StateBuilder(r0.g, r0);
        r1.f187d = r6.e;
        r1.e = r6.f;
        r1.c = r6.n;
        r1.a();
        setShowOtherDates(r6.b);
        setAllowClickDaysOutsideCurrentMonth(r6.c);
        a();
        Iterator r2 = r6.i.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        CalendarDay r3 = (CalendarDay) r2.next();
        if (r3 == null) goto L4;
        this.j.p(r3, true);
        goto L4
    L9:
        setTopbarVisible(r6.j);
        setSelectionMode(r6.k);
        setDynamicHeightEnabled(r6.l);
        setCurrentDate(r6.m);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        r0.b = 4;
        r0.c = true;
        r0.e = null;
        r0.f = null;
        r0.i = new ArrayList();
        r0.j = true;
        r0.k = 1;
        r0.l = false;
        r0.m = null;
        r0.b = getShowOtherDates();
        r0.c = this.C;
        r0.e = getMinimumDate();
        r0.f = getMaximumDate();
        r0.i = getSelectedDates();
        r0.k = getSelectionMode();
        r0.j = getTopbarVisible();
        r0.l = this.n;
        r0.m = this.k;
        r0.n = this.F.e;
        return r0;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r1) {
        return this.i.dispatchTouchEvent(r1);
    }

    public void setAllowClickDaysOutsideCurrentMonth(boolean r1) {
        this.C = r1;
    }

    public void setContentDescriptionArrowFuture(CharSequence r1) {
        this.f.setContentDescription(r1);
    }

    public void setContentDescriptionArrowPast(CharSequence r1) {
        this.e.setContentDescription(r1);
    }

    public void setContentDescriptionCalendar(CharSequence r1) {
        this.v = r1;
    }

    public void setCurrentDate(@Nullable LocalDate r1) {
        setCurrentDate(CalendarDay.a(r1));
    }

    public void setDateTextAppearance(int r1) {
        this.j.q(r1);
    }

    public void setDayFormatter(DayFormatter r1) {
        CalendarPagerAdapter r0 = this.j;
        if (r1 != null) goto L5;
        r1 = DayFormatter.f192a;
    L5:
        r0.r(r1);
    }

    public void setDayFormatterContentDescription(DayFormatter r1) {
        this.j.s(r1);
    }

    public void setDynamicHeightEnabled(boolean r1) {
        this.n = r1;
    }

    public void setHeaderTextAppearance(int r2) {
        this.c.setTextAppearance(getContext(), r2);
    }

    public void setLeftArrow(@DrawableRes int r1) {
        this.e.setImageResource(r1);
    }

    public void setOnDateChangedListener(OnDateSelectedListener r1) {
        this.r = r1;
    }

    public void setOnDateLongClickListener(OnDateLongClickListener r1) {
        this.s = r1;
    }

    public void setOnMonthChangedListener(OnMonthChangedListener r1) {
        this.t = r1;
    }

    public void setOnRangeSelectedListener(OnRangeSelectedListener r1) {
        this.u = r1;
    }

    public void setOnTitleClickListener(View.OnClickListener r1) {
        this.c.setOnClickListener(r1);
    }

    public void setPagingEnabled(boolean r2) {
        this.i.b = r2;
        f();
    }

    public void setRightArrow(@DrawableRes int r1) {
        this.f.setImageResource(r1);
    }

    public void setSelectedDate(@Nullable LocalDate r1) {
        setSelectedDate(CalendarDay.a(r1));
    }

    public void setSelectionColor(int r2) {
        if (r2 == 0) goto L4;
    L7:
        this.w = r2;
        this.j.u(r2);
        invalidate();
        return;
    L4:
        if (isInEditMode() == true) goto L6;
        return;
    L6:
        r2 = -7829368;
        goto L7
    }

    public void setSelectionMode(int r6) {
        int r0 = this.B;
        this.B = r6;
        boolean r1 = false;
        if (r6 == 1) goto L10;
        if (r6 == 2) goto L15;
        if (r6 == 3) goto L9;
        this.B = 0;
        if (r0 == 0) goto L15;
        a();
        goto L15
    L9:
        a();
    L15:
        CalendarPagerAdapter r7 = this.j;
        if (this.B == 0) goto L18;
        r1 = true;
    L18:
        r7.v(r1);
        return;
    L10:
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L15;
    L13:
        if (getSelectedDates().isEmpty() == true) goto L15;
        setSelectedDate(getSelectedDate());
        goto L15
    }

    public void setShowOtherDates(int r1) {
        this.j.w(r1);
    }

    public void setTileHSpacing(int r1) {
        this.z = r1;
        requestLayout();
    }

    public void setTileHeight(int r1) {
        this.x = r1;
        requestLayout();
    }

    public void setTileHeightDp(int r1) {
        setTileHeight(d(r1));
    }

    public void setTileSize(int r1) {
        this.y = r1;
        this.x = r1;
        requestLayout();
    }

    public void setTileSizeDp(int r1) {
        setTileSize(d(r1));
    }

    public void setTileVSpacing(int r1) {
        this.A = r1;
        requestLayout();
    }

    public void setTileWidth(int r1) {
        this.y = r1;
        requestLayout();
    }

    public void setTileWidthDp(int r1) {
        setTileWidth(d(r1));
    }

    public void setTitleAnimationOrientation(int r1) {
        this.b.g = r1;
    }

    public void setTitleFormatter(@Nullable TitleFormatter r3) {
        TitleChanger r0 = this.b;
        if (r3 != null) goto L5;
        r0.getClass();
        TitleFormatter r1 = TitleFormatter.f193a;
    L6:
        r0.b = r1;
        this.j.y(r3);
        f();
        return;
    L5:
        r1 = r3;
        goto L6
    }

    public void setTitleMonths(CharSequence[] r2) {
        setTitleFormatter(new MonthArrayTitleFormatter(r2));
    }

    public void setTopbarVisible(boolean r2) {
        if (r2 == false) goto L4;
        int r3 = 0;
    L5:
        this.l.setVisibility(r3);
        requestLayout();
        return;
    L4:
        r3 = 8;
        goto L5
    }

    public void setWeekDayFormatter(WeekDayFormatter r1) {
        CalendarPagerAdapter r0 = this.j;
        if (r1 != null) goto L5;
        r1 = WeekDayFormatter.f194a;
    L5:
        r0.z(r1);
    }

    public void setWeekDayLabels(CharSequence[] r2) {
        setWeekDayFormatter(new ArrayWeekDayFormatter(r2));
    }

    public void setWeekDayTextAppearance(int r1) {
        this.j.A(r1);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public void setCurrentDate(@Nullable CalendarDay r3) {
        if (r3 == null) goto L6;
        int r4 = this.j.e(r3);
        this.i.setCurrentItem(r4, true);
        f();
        return;
    }

    public void setSelectedDate(@Nullable CalendarDay r2) {
        a();
        if (r2 == null) goto L6;
        this.j.p(r2, true);
        return;
    }

    public void setTitleMonths(@ArrayRes int r2) {
        setTitleMonths(getResources().getTextArray(r2));
    }

    public void setWeekDayLabels(@ArrayRes int r2) {
        setWeekDayLabels(getResources().getTextArray(r2));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        return new LayoutParams(-1, 1);
    }
}
