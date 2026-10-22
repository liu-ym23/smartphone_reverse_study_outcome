package com.obric.oui.calendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
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
import androidx.viewpager.widget.ViewPager;
import com.obric.common.oui.R;
import com.obric.oui.calendar.format.ArrayWeekDayFormatter;
import com.obric.oui.calendar.format.DayFormatter;
import com.obric.oui.calendar.format.MonthArrayTitleFormatter;
import com.obric.oui.calendar.format.TitleFormatter;
import com.obric.oui.calendar.format.WeekDayFormatter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialCalendarView extends ViewGroup {
    private static final int DAY_NAMES_ROW = 1;
    private static final int DEFAULT_DAYS_IN_WEEK = 7;
    private static final int DEFAULT_DAYS_ROW = 6;
    public static final int DEFAULT_TILE_CONTENT_VERTICAL_PADDING_DP = 9;
    public static final int DEFAULT_TILE_SIZE_DP = 40;
    public static final int DEFAULT_WEEKDAYS_HEIGHT_DP = 28;
    public static final int HORIZONTAL = 1;
    public static final int INVALID_TILE_DIMENSION = -10;
    public static final int SELECTION_MODE_MULTIPLE = 2;
    public static final int SELECTION_MODE_NONE = 0;
    public static final int SELECTION_MODE_RANGE = 3;
    public static final int SELECTION_MODE_SINGLE = 1;
    public static final int SHOW_ALL = 7;
    public static final int SHOW_DECORATED_DISABLED = 4;
    public static final int SHOW_DEFAULTS = 4;
    public static final int SHOW_NONE = 0;
    public static final int SHOW_OTHER_MONTHS = 1;
    public static final int SHOW_OUT_OF_RANGE = 2;
    public static final int VERTICAL = 0;
    private int accentColor;
    private CalendarPagerAdapter<?> adapter;
    private boolean allowClickDaysOutsideCurrentMonth;
    private final ImageView buttonFuture;
    private final ImageView buttonPast;
    CharSequence calendarContentDescription;
    private CalendarMode calendarMode;
    private CalendarDay currentMonth;
    private final ArrayList<DayViewDecorator> dayViewDecorators;
    private DayOfWeek firstDayOfWeek;
    private OnDateSelectedListener listener;
    private OnDateLongClickListener longClickListener;
    private boolean mDynamicHeightEnabled;
    private CalendarDay maxDate;
    private final MeasureInfo measureInfo;
    private CalendarDay minDate;
    private OnMonthChangedListener monthListener;
    private final View.OnClickListener onClickListener;
    private final ViewPager.OnPageChangeListener pageChangeListener;
    private final CalendarPager pager;
    private OnRangeSelectedListener rangeListener;
    private int selectionMode;
    private boolean showWeekDays;
    private State state;
    private int tileHSpacing;
    private int tileHeight;
    private int tileVSpacing;
    private int tileWidth;
    private final TextView title;
    private final TitleChanger titleChanger;
    private LinearLayout topbar;
    private int weekDaysHeight;

    /* JADX INFO: renamed from: com.obric.oui.calendar.MaterialCalendarView$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$oui$calendar$CalendarMode = null;

        static {
            int[] r0 = new int[CalendarMode.values().length];
            $SwitchMap$com$obric$oui$calendar$CalendarMode = r0;
            r0[CalendarMode.MONTHS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$obric$oui$calendar$CalendarMode[CalendarMode.WEEKS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class MeasureInfo {
        public int tileHeight;
        public int tileWidth;

        public MeasureInfo() {
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean allowClickDaysOutsideCurrentMonth;
        boolean cacheCurrentPosition;
        CalendarDay currentMonth;
        boolean dynamicHeightEnabled;
        CalendarDay maxDate;
        CalendarDay minDate;
        List<CalendarDay> selectedDates;
        int selectionMode;
        int showOtherDates;
        boolean topbarVisible;

        /* synthetic */ SavedState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        SavedState(Parcelable r3) {
            super(r3);
            this.showOtherDates = 4;
            this.allowClickDaysOutsideCurrentMonth = true;
            this.minDate = null;
            this.maxDate = null;
            this.selectedDates = new ArrayList();
            this.topbarVisible = true;
            this.selectionMode = 1;
            this.dynamicHeightEnabled = false;
            this.currentMonth = null;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            r2.writeInt(this.showOtherDates);
            r2.writeByte(this.allowClickDaysOutsideCurrentMonth ? 1 : 0);
            r2.writeParcelable(this.minDate, 0);
            r2.writeParcelable(this.maxDate, 0);
            r2.writeTypedList(this.selectedDates);
            r2.writeInt(this.topbarVisible ? 1 : 0);
            r2.writeInt(this.selectionMode);
            r2.writeInt(this.dynamicHeightEnabled ? 1 : 0);
            r2.writeParcelable(this.currentMonth, 0);
            r2.writeByte(this.cacheCurrentPosition ? 1 : 0);
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        private SavedState(Parcel r6) {
            super(r6);
            this.showOtherDates = 4;
            boolean r0 = true;
            this.allowClickDaysOutsideCurrentMonth = true;
            this.minDate = null;
            this.maxDate = null;
            this.selectedDates = new ArrayList();
            this.topbarVisible = true;
            this.selectionMode = 1;
            this.dynamicHeightEnabled = false;
            this.currentMonth = null;
            this.showOtherDates = r6.readInt();
            if (r6.readByte() == 0) goto L5;
            boolean r1 = true;
        L6:
            this.allowClickDaysOutsideCurrentMonth = r1;
            ClassLoader r2 = CalendarDay.class.getClassLoader();
            this.minDate = (CalendarDay) r6.readParcelable(r2);
            this.maxDate = (CalendarDay) r6.readParcelable(r2);
            r6.readTypedList(this.selectedDates, CalendarDay.CREATOR);
            if (r6.readInt() != 1) goto L9;
            boolean r3 = true;
        L10:
            this.topbarVisible = r3;
            this.selectionMode = r6.readInt();
            if (r6.readInt() != 1) goto L13;
            boolean r4 = true;
        L14:
            this.dynamicHeightEnabled = r4;
            this.currentMonth = (CalendarDay) r6.readParcelable(r2);
            if (r6.readByte() != 0) goto L18;
            r0 = false;
        L18:
            this.cacheCurrentPosition = r0;
            return;
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
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SelectionMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShowOtherDates {
    }

    public class State {
        private final boolean cacheCurrentPosition;
        private final CalendarMode calendarMode;
        private final DayOfWeek firstDayOfWeek;
        private final CalendarDay maxDate;
        private final CalendarDay minDate;
        private final boolean showWeekDays;
        final /* synthetic */ MaterialCalendarView this$0;

        /* synthetic */ State(MaterialCalendarView r1, StateBuilder r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ CalendarMode access$1600(State r0) {
            return r0.calendarMode;
        }

        static /* synthetic */ DayOfWeek access$1700(State r0) {
            return r0.firstDayOfWeek;
        }

        static /* synthetic */ CalendarDay access$1800(State r0) {
            return r0.minDate;
        }

        static /* synthetic */ CalendarDay access$1900(State r0) {
            return r0.maxDate;
        }

        static /* synthetic */ boolean access$2000(State r0) {
            return r0.showWeekDays;
        }

        static /* synthetic */ boolean access$700(State r0) {
            return r0.cacheCurrentPosition;
        }

        private State(MaterialCalendarView r1, StateBuilder r2) {
            this.this$0 = r1;
            this.calendarMode = StateBuilder.access$900(r2);
            this.firstDayOfWeek = StateBuilder.access$1000(r2);
            this.minDate = StateBuilder.access$1100(r2);
            this.maxDate = StateBuilder.access$1200(r2);
            this.cacheCurrentPosition = StateBuilder.access$1300(r2);
            this.showWeekDays = StateBuilder.access$1400(r2);
        }

        public StateBuilder edit() {
            return new StateBuilder(this.this$0, this, null);
        }
    }

    public class StateBuilder {
        private boolean cacheCurrentPosition;
        private CalendarMode calendarMode;
        private DayOfWeek firstDayOfWeek;
        private CalendarDay maxDate;
        private CalendarDay minDate;
        private boolean showWeekDays;
        final /* synthetic */ MaterialCalendarView this$0;

        /* synthetic */ StateBuilder(MaterialCalendarView r1, State r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ DayOfWeek access$1000(StateBuilder r0) {
            return r0.firstDayOfWeek;
        }

        static /* synthetic */ CalendarDay access$1100(StateBuilder r0) {
            return r0.minDate;
        }

        static /* synthetic */ CalendarDay access$1200(StateBuilder r0) {
            return r0.maxDate;
        }

        static /* synthetic */ boolean access$1300(StateBuilder r0) {
            return r0.cacheCurrentPosition;
        }

        static /* synthetic */ boolean access$1400(StateBuilder r0) {
            return r0.showWeekDays;
        }

        static /* synthetic */ CalendarMode access$900(StateBuilder r0) {
            return r0.calendarMode;
        }

        public StateBuilder(MaterialCalendarView r4) {
            this.this$0 = r4;
            this.cacheCurrentPosition = false;
            this.minDate = null;
            this.maxDate = null;
            this.calendarMode = CalendarMode.MONTHS;
            this.firstDayOfWeek = LocalDate.now().with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1).getDayOfWeek();
        }

        private StateBuilder(MaterialCalendarView r1, State r2) {
            this.this$0 = r1;
            this.cacheCurrentPosition = false;
            this.minDate = null;
            this.maxDate = null;
            this.calendarMode = State.access$1600(r2);
            this.firstDayOfWeek = State.access$1700(r2);
            this.minDate = State.access$1800(r2);
            this.maxDate = State.access$1900(r2);
            this.cacheCurrentPosition = State.access$700(r2);
            this.showWeekDays = State.access$2000(r2);
        }

        public StateBuilder setFirstDayOfWeek(DayOfWeek r1) {
            this.firstDayOfWeek = r1;
            return this;
        }

        public StateBuilder setCalendarDisplayMode(CalendarMode r1) {
            this.calendarMode = r1;
            return this;
        }

        public StateBuilder setMinimumDate(LocalDate r1) {
            setMinimumDate(CalendarDay.from(r1));
            return this;
        }

        public StateBuilder setMinimumDate(CalendarDay r1) {
            this.minDate = r1;
            return this;
        }

        public StateBuilder setMaximumDate(LocalDate r1) {
            setMaximumDate(CalendarDay.from(r1));
            return this;
        }

        public StateBuilder setMaximumDate(CalendarDay r1) {
            this.maxDate = r1;
            return this;
        }

        public StateBuilder setShowWeekDays(boolean r1) {
            this.showWeekDays = r1;
            return this;
        }

        public StateBuilder isCacheCalendarPositionEnabled(boolean r1) {
            this.cacheCurrentPosition = r1;
            return this;
        }

        public void commit() {
            MaterialCalendarView.access$2200(this.this$0, new State(this.this$0, this, null));
        }
    }

    public static boolean showDecoratedDisabled(int r0) {
        if ((r0 & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean showOtherMonths(int r1) {
        if ((r1 & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean showOutOfRange(int r0) {
        if ((r0 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    static /* synthetic */ ImageView access$000(MaterialCalendarView r0) {
        return r0.buttonFuture;
    }

    static /* synthetic */ CalendarPager access$100(MaterialCalendarView r0) {
        return r0.pager;
    }

    static /* synthetic */ ImageView access$200(MaterialCalendarView r0) {
        return r0.buttonPast;
    }

    static /* synthetic */ void access$2200(MaterialCalendarView r0, State r1) {
        r0.commit(r1);
    }

    static /* synthetic */ CalendarDay access$300(MaterialCalendarView r0) {
        return r0.currentMonth;
    }

    static /* synthetic */ CalendarDay access$302(MaterialCalendarView r0, CalendarDay r1) {
        r0.currentMonth = r1;
        return r1;
    }

    static /* synthetic */ TitleChanger access$400(MaterialCalendarView r0) {
        return r0.titleChanger;
    }

    static /* synthetic */ CalendarPagerAdapter access$500(MaterialCalendarView r0) {
        return r0.adapter;
    }

    static /* synthetic */ void access$600(MaterialCalendarView r0) {
        r0.updateUi();
    }

    public MaterialCalendarView(Context r2) {
        this(r2, null);
    }

    public MaterialCalendarView(Context r11, AttributeSet r12) {
        super(r11, r12);
        this.dayViewDecorators = new ArrayList();
        View.OnClickListener r0 = new AnonymousClass1(this);
        this.onClickListener = r0;
        ViewPager.OnPageChangeListener r1 = new AnonymousClass2(this);
        this.pageChangeListener = r1;
        this.minDate = null;
        this.maxDate = null;
        this.accentColor = 0;
        this.tileHeight = -10;
        this.tileWidth = -10;
        this.tileHSpacing = -10;
        this.tileVSpacing = -10;
        this.selectionMode = 1;
        this.allowClickDaysOutsideCurrentMonth = true;
        this.weekDaysHeight = -10;
        this.measureInfo = new MeasureInfo();
        setClipToPadding(false);
        setClipChildren(false);
        View r2 = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.calendar_view, null, false);
        this.topbar = (LinearLayout) r2.findViewById(R.id.header);
        ImageView r6 = (ImageView) r2.findViewById(R.id.previous);
        this.buttonPast = r6;
        TextView r7 = (TextView) r2.findViewById(R.id.month_name);
        this.title = r7;
        ImageView r3 = (ImageView) r2.findViewById(R.id.next);
        this.buttonFuture = r3;
        CalendarPager r8 = new CalendarPager(getContext());
        this.pager = r8;
        r6.setOnClickListener(r0);
        r3.setOnClickListener(r0);
        TitleChanger r4 = new TitleChanger(r7);
        this.titleChanger = r4;
        r8.setOnPageChangeListener(r1);
        r8.setPageTransformer(false, new AnonymousClass3(this));
        TypedArray r13 = r11.getTheme().obtainStyledAttributes(r12, R.styleable.O_MaterialCalendarView, 0, 0);
        int r5 = r13.getInteger(R.styleable.O_MaterialCalendarView_o_mcv_calendarMode, 0);     // Catch: Throwable -> L32 Exception -> L34
        int r9 = r13.getInteger(R.styleable.O_MaterialCalendarView_o_mcv_firstDayOfWeek, -1);     // Catch: Throwable -> L32 Exception -> L34
        r4.setOrientation(r13.getInteger(R.styleable.O_MaterialCalendarView_o_mcv_titleAnimationOrientation, 0));     // Catch: Throwable -> L32 Exception -> L34
        if (r9 >= 1) goto L6;
    L8:
        this.firstDayOfWeek = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();     // Catch: Throwable -> L32 Exception -> L34
    L9:
        this.showWeekDays = r13.getBoolean(R.styleable.O_MaterialCalendarView_o_mcv_showWeekDays, true);     // Catch: Throwable -> L32 Exception -> L34
        newState().setFirstDayOfWeek(this.firstDayOfWeek).setCalendarDisplayMode(CalendarMode.values()[r5]).setShowWeekDays(this.showWeekDays).commit();     // Catch: Throwable -> L32 Exception -> L34
        setSelectionMode(r13.getInteger(R.styleable.O_MaterialCalendarView_o_mcv_selectionMode, 1));     // Catch: Throwable -> L32 Exception -> L34
        int r10 = r13.getLayoutDimension(R.styleable.O_MaterialCalendarView_o_mcv_tileSize, -10);     // Catch: Throwable -> L32 Exception -> L34
        if (r10 <= (-10)) goto L12;
        setTileSize(r10);     // Catch: Throwable -> L32 Exception -> L34
    L12:
        int r14 = r13.getLayoutDimension(R.styleable.O_MaterialCalendarView_o_mcv_tileWidth, -10);     // Catch: Throwable -> L32 Exception -> L34
        if (r14 <= (-10)) goto L15;
        setTileWidth(r14);     // Catch: Throwable -> L32 Exception -> L34
    L15:
        int r15 = r13.getLayoutDimension(R.styleable.O_MaterialCalendarView_o_mcv_tileHeight, -10);     // Catch: Throwable -> L32 Exception -> L34
        if (r15 <= (-10)) goto L18;
        setTileHeight(r15);     // Catch: Throwable -> L32 Exception -> L34
    L18:
        int r16 = r13.getLayoutDimension(R.styleable.O_MaterialCalendarView_o_mcv_tileHSpacing, -10);     // Catch: Throwable -> L32 Exception -> L34
        if (r16 <= (-10)) goto L21;
        setTileHSpacing(r16);     // Catch: Throwable -> L32 Exception -> L34
    L21:
        int r17 = r13.getLayoutDimension(R.styleable.O_MaterialCalendarView_o_mcv_tileVSpacing, -10);     // Catch: Throwable -> L32 Exception -> L34
        if (r17 <= (-10)) goto L24;
        setTileVSpacing(r17);     // Catch: Throwable -> L32 Exception -> L34
    L24:
        setLeftArrow(r13.getResourceId(R.styleable.O_MaterialCalendarView_o_mcv_leftArrow, R.drawable.o_mcv_action_previous));     // Catch: Throwable -> L32 Exception -> L34
        setRightArrow(r13.getResourceId(R.styleable.O_MaterialCalendarView_o_mcv_rightArrow, R.drawable.o_mcv_action_next));     // Catch: Throwable -> L32 Exception -> L34
        setSelectionColor(r13.getColor(R.styleable.O_MaterialCalendarView_o_mcv_selectionColor, getThemeAccentColor(r11)));     // Catch: Throwable -> L32 Exception -> L34
        CharSequence[] r18 = r13.getTextArray(R.styleable.O_MaterialCalendarView_o_mcv_weekDayLabels);     // Catch: Throwable -> L32 Exception -> L34
        if (r18 == null) goto L27;
        setWeekDayFormatter(new ArrayWeekDayFormatter(r18));     // Catch: Throwable -> L32 Exception -> L34
    L27:
        CharSequence[] r19 = r13.getTextArray(R.styleable.O_MaterialCalendarView_o_mcv_monthLabels);     // Catch: Throwable -> L32 Exception -> L34
        if (r19 == null) goto L30;
        setTitleFormatter(new MonthArrayTitleFormatter(r19));     // Catch: Throwable -> L32 Exception -> L34
    L30:
        setHeaderTextAppearance(r13.getResourceId(R.styleable.O_MaterialCalendarView_o_mcv_headerTextAppearance, R.style.TextAppearance_MaterialCalendarWidget_Header));     // Catch: Throwable -> L32 Exception -> L34
        setWeekDayTextAppearance(r13.getResourceId(R.styleable.O_MaterialCalendarView_o_mcv_weekDayTextAppearance, R.style.TextAppearance_MaterialCalendarWidget_WeekDay));     // Catch: Throwable -> L32 Exception -> L34
        setDateTextAppearance(r13.getResourceId(R.styleable.O_MaterialCalendarView_o_mcv_dateTextAppearance, R.style.TextAppearance_MaterialCalendarWidget_Date));     // Catch: Throwable -> L32 Exception -> L34
        setShowOtherDates(r13.getInteger(R.styleable.O_MaterialCalendarView_o_mcv_showOtherDates, 4));     // Catch: Throwable -> L32 Exception -> L34
        setAllowClickDaysOutsideCurrentMonth(r13.getBoolean(R.styleable.O_MaterialCalendarView_o_mcv_allowClickDaysOutsideCurrentMonth, true));     // Catch: Throwable -> L32 Exception -> L34
    L36:
        r13.recycle();
        setupChildren();
        CalendarDay r110 = CalendarDay.today();
        this.currentMonth = r110;
        setCurrentDate(r110);
        if (isInEditMode() == false) goto L44;
        removeView(this.pager);
        MonthView r111 = new MonthView(this, this.currentMonth, getFirstDayOfWeek(), true);
        r111.setSelectionColor(getSelectionColor());
        r111.setDateTextAppearance(this.adapter.getDateTextAppearance());
        r111.setWeekDayTextAppearance(this.adapter.getWeekDayTextAppearance());
        r111.setShowOtherDates(getShowOtherDates());
        addView(r111);
        return;
    L44:
        return;
    L6:
        if (r9 > 7) goto L8;
        this.firstDayOfWeek = DayOfWeek.of(r9);     // Catch: Throwable -> L32 Exception -> L34
    L32:
        th = move-exception;
        r13.recycle();
        throw th;
    L34:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L32
        goto L36
    }

    private void setupChildren() {
        addView(this.topbar);
        this.pager.setId(R.id.mcv_pager);
        this.pager.setOffscreenPageLimit(1);
        addView(this.pager);
    }

    private void updateUi() {
        this.titleChanger.change(this.currentMonth);
        enableView(this.buttonPast, canGoBack());
        enableView(this.buttonFuture, canGoForward());
    }

    public void setSelectionMode(int r6) {
        int r0 = this.selectionMode;
        this.selectionMode = r6;
        boolean r1 = false;
        if (r6 == 1) goto L10;
        if (r6 == 2) goto L15;
        if (r6 == 3) goto L9;
        this.selectionMode = 0;
        if (r0 == 0) goto L15;
        clearSelection();
        goto L15
    L9:
        clearSelection();
    L15:
        CalendarPagerAdapter<?> r7 = this.adapter;
        if (this.selectionMode == 0) goto L18;
        r1 = true;
    L18:
        r7.setSelectionEnabled(r1);
        return;
    L10:
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L15;
    L13:
        if (getSelectedDates().isEmpty() == true) goto L15;
        setSelectedDate(getSelectedDate());
        goto L15
    }

    public void goToPrevious() {
        if (canGoBack() == false) goto L6;
        CalendarPager r2 = this.pager;
        r2.setCurrentItem(r2.getCurrentItem() - 1, true);
        return;
    }

    public void goToNext() {
        if (canGoForward() == false) goto L6;
        CalendarPager r2 = this.pager;
        r2.setCurrentItem(r2.getCurrentItem() + 1, true);
        return;
    }

    public int getSelectionMode() {
        return this.selectionMode;
    }

    @Deprecated
    public int getTileSize() {
        return Math.max(this.tileHeight, this.tileWidth);
    }

    public void setTileSize(int r1) {
        this.tileWidth = r1;
        this.tileHeight = r1;
        requestLayout();
    }

    public void setTileSizeDp(int r1) {
        setTileSize(dpToPx(r1));
    }

    public int getTileHeight() {
        return this.tileHeight;
    }

    public void setTileHeight(int r1) {
        this.tileHeight = r1;
        requestLayout();
    }

    public void setTileHeightDp(int r1) {
        setTileHeight(dpToPx(r1));
    }

    public int getTileWidth() {
        return this.tileWidth;
    }

    public void setTileWidth(int r1) {
        this.tileWidth = r1;
        requestLayout();
    }

    public void setTileHSpacing(int r1) {
        this.tileHSpacing = r1;
        requestLayout();
    }

    public void setTileVSpacing(int r1) {
        this.tileVSpacing = r1;
        requestLayout();
    }

    public int getTileHSpacing() {
        return this.tileHSpacing;
    }

    public int getTileVSpacing() {
        return this.tileVSpacing;
    }

    public void setTileWidthDp(int r1) {
        setTileWidth(dpToPx(r1));
    }

    public void setWeekDaysHeight(int r1) {
        this.weekDaysHeight = r1;
        requestLayout();
    }

    public int getWeekDaysHeight() {
        return this.weekDaysHeight;
    }

    public void setWeekDaysHeightDp(int r1) {
        setWeekDaysHeight(dpToPx(r1));
    }

    private int dpToPx(int r2) {
        return (int) TypedValue.applyDimension(1, r2, getResources().getDisplayMetrics());
    }

    public boolean canGoForward() {
        if (this.pager.getCurrentItem() < (this.adapter.getCount() - 1)) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean canGoBack() {
        if (this.pager.getCurrentItem() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r1) {
        return this.pager.dispatchTouchEvent(r1);
    }

    public int getSelectionColor() {
        return this.accentColor;
    }

    public void setSelectionColor(int r2) {
        if (r2 == 0) goto L4;
    L7:
        this.accentColor = r2;
        this.adapter.setSelectionColor(r2);
        invalidate();
        return;
    L4:
        if (isInEditMode() == true) goto L6;
        return;
    L6:
        r2 = -7829368;
        goto L7
    }

    public void setContentDescriptionArrowPast(CharSequence r1) {
        this.buttonPast.setContentDescription(r1);
    }

    public void setContentDescriptionArrowFuture(CharSequence r1) {
        this.buttonFuture.setContentDescription(r1);
    }

    public void setContentDescriptionCalendar(CharSequence r1) {
        this.calendarContentDescription = r1;
    }

    public CharSequence getCalendarContentDescription() {
        CharSequence r0 = this.calendarContentDescription;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return getContext().getString(R.string.oui_calendar);
    }

    public void setDayFormatterContentDescription(DayFormatter r1) {
        this.adapter.setDayFormatterContentDescription(r1);
    }

    public Drawable getLeftArrow() {
        return this.buttonPast.getDrawable();
    }

    public void setLeftArrow(int r1) {
        this.buttonPast.setImageResource(r1);
    }

    public Drawable getRightArrow() {
        return this.buttonFuture.getDrawable();
    }

    public void setRightArrow(int r1) {
        this.buttonFuture.setImageResource(r1);
    }

    public void setHeaderTextAppearance(int r2) {
        this.title.setTextAppearance(getContext(), r2);
    }

    public void setDateTextAppearance(int r1) {
        this.adapter.setDateTextAppearance(r1);
    }

    public void setWeekDayTextAppearance(int r1) {
        this.adapter.setWeekDayTextAppearance(r1);
    }

    public CalendarDay getSelectedDate() {
        List<CalendarDay> r1 = this.adapter.getSelectedDates();
        if (r1.isEmpty() == false) goto L7;
        return null;
    L7:
        return r1.get(r1.size() - 1);
    }

    public List<CalendarDay> getSelectedDates() {
        return this.adapter.getSelectedDates();
    }

    public void clearSelection() {
        List<CalendarDay> r0 = getSelectedDates();
        this.adapter.clearSelections();
        Iterator<CalendarDay> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        dispatchOnDateSelected(r1.next(), false);
        goto L4
    }

    public void setSelectedDate(LocalDate r1) {
        setSelectedDate(CalendarDay.from(r1));
    }

    public void setSelectedDate(CalendarDay r2) {
        clearSelection();
        if (r2 == null) goto L6;
        setDateSelected(r2, true);
        return;
    }

    public void setDateSelected(CalendarDay r1, boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.adapter.setDateSelected(r1, r2);
    }

    public CalendarDay getCurrentDate() {
        return this.adapter.getItem(this.pager.getCurrentItem());
    }

    public void setCurrentDate(LocalDate r1) {
        setCurrentDate(CalendarDay.from(r1));
    }

    public void setCurrentDate(CalendarDay r2) {
        setCurrentDate(r2, true);
    }

    public void setCurrentDate(CalendarDay r2, boolean r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        int r4 = this.adapter.getIndexForDay(r2);
        this.pager.setCurrentItem(r4, r3);
        updateUi();
    }

    public CalendarDay getMinimumDate() {
        return this.minDate;
    }

    public CalendarDay getMaximumDate() {
        return this.maxDate;
    }

    public void setShowOtherDates(int r1) {
        this.adapter.setShowOtherDates(r1);
    }

    public void setAllowClickDaysOutsideCurrentMonth(boolean r1) {
        this.allowClickDaysOutsideCurrentMonth = r1;
    }

    public void setWeekDayFormatter(WeekDayFormatter r1) {
        CalendarPagerAdapter<?> r0 = this.adapter;
        if (r1 != null) goto L5;
        r1 = WeekDayFormatter.DEFAULT;
    L5:
        r0.setWeekDayFormatter(r1);
    }

    public void setDayFormatter(DayFormatter r1) {
        CalendarPagerAdapter<?> r0 = this.adapter;
        if (r1 != null) goto L5;
        r1 = DayFormatter.DEFAULT;
    L5:
        r0.setDayFormatter(r1);
    }

    public void setWeekDayLabels(CharSequence[] r2) {
        setWeekDayFormatter(new ArrayWeekDayFormatter(r2));
    }

    public void setWeekDayLabels(int r2) {
        setWeekDayLabels(getResources().getTextArray(r2));
    }

    public int getShowOtherDates() {
        return this.adapter.getShowOtherDates();
    }

    public boolean allowClickDaysOutsideCurrentMonth() {
        return this.allowClickDaysOutsideCurrentMonth;
    }

    public boolean isShowWeekDays() {
        return this.showWeekDays;
    }

    public void setTitleFormatter(TitleFormatter r2) {
        this.titleChanger.setTitleFormatter(r2);
        this.adapter.setTitleFormatter(r2);
        updateUi();
    }

    public void setTitleMonths(CharSequence[] r2) {
        setTitleFormatter(new MonthArrayTitleFormatter(r2));
    }

    public void setTitleMonths(int r2) {
        setTitleMonths(getResources().getTextArray(r2));
    }

    public void setTitleAnimationOrientation(int r1) {
        this.titleChanger.setOrientation(r1);
    }

    public int getTitleAnimationOrientation() {
        return this.titleChanger.getOrientation();
    }

    public void setTopbarVisible(boolean r2) {
        LinearLayout r0 = this.topbar;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        requestLayout();
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public boolean getTopbarVisible() {
        if (this.topbar.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public CalendarMode getCalendarMode() {
        return this.calendarMode;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        r0.showOtherDates = getShowOtherDates();
        r0.allowClickDaysOutsideCurrentMonth = allowClickDaysOutsideCurrentMonth();
        r0.minDate = getMinimumDate();
        r0.maxDate = getMaximumDate();
        r0.selectedDates = getSelectedDates();
        r0.selectionMode = getSelectionMode();
        r0.topbarVisible = getTopbarVisible();
        r0.dynamicHeightEnabled = this.mDynamicHeightEnabled;
        r0.currentMonth = this.currentMonth;
        r0.cacheCurrentPosition = State.access$700(this.state);
        return r0;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r4) {
        SavedState r5 = (SavedState) r4;
        super.onRestoreInstanceState(r5.getSuperState());
        state().edit().setMinimumDate(r5.minDate).setMaximumDate(r5.maxDate).isCacheCalendarPositionEnabled(r5.cacheCurrentPosition).commit();
        setShowOtherDates(r5.showOtherDates);
        setAllowClickDaysOutsideCurrentMonth(r5.allowClickDaysOutsideCurrentMonth);
        clearSelection();
        Iterator<CalendarDay> r0 = r5.selectedDates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        setDateSelected(r0.next(), true);
        goto L4
    L6:
        setTopbarVisible(r5.topbarVisible);
        setSelectionMode(r5.selectionMode);
        setDynamicHeightEnabled(r5.dynamicHeightEnabled);
        setCurrentDate(r5.currentMonth);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> r1) {
        dispatchFreezeSelfOnly(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> r1) {
        dispatchThawSelfOnly(r1);
    }

    private void setRangeDates(CalendarDay r3, CalendarDay r4) {
        CalendarDay r0 = this.currentMonth;
        this.adapter.setRangeDates(r3, r4);
        this.currentMonth = r0;
        if (r3 != null) goto L5;
    L9:
        int r5 = this.adapter.getIndexForDay(r0);
        this.pager.setCurrentItem(r5, false);
        updateUi();
        return;
    L5:
        if (r3.isAfter(r0) == true) goto L8;
        r3 = this.currentMonth;
    L8:
        this.currentMonth = r3;
        goto L9
    }

    private static int getThemeAccentColor(Context r3) {
        TypedValue r0 = new TypedValue();
        r3.getTheme().resolveAttribute(android.R.attr.colorAccent, r0, true);
        return r0.data;
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public void setDynamicHeightEnabled(boolean r1) {
        this.mDynamicHeightEnabled = r1;
    }

    public boolean isDynamicHeightEnabled() {
        return this.mDynamicHeightEnabled;
    }

    public void addDecorators(Collection<? extends DayViewDecorator> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.dayViewDecorators.addAll(r2);
        this.adapter.setDecorators(this.dayViewDecorators);
    }

    public void addDecorators(DayViewDecorator... r1) {
        addDecorators(Arrays.asList(r1));
    }

    public void addDecorator(DayViewDecorator r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.dayViewDecorators.add(r2);
        this.adapter.setDecorators(this.dayViewDecorators);
    }

    public void removeDecorators() {
        this.dayViewDecorators.clear();
        this.adapter.setDecorators(this.dayViewDecorators);
    }

    public void removeDecorator(DayViewDecorator r2) {
        this.dayViewDecorators.remove(r2);
        this.adapter.setDecorators(this.dayViewDecorators);
    }

    public void invalidateDecorators() {
        this.adapter.invalidateDecorators();
    }

    public void setOnDateChangedListener(OnDateSelectedListener r1) {
        this.listener = r1;
    }

    public void setOnDateLongClickListener(OnDateLongClickListener r1) {
        this.longClickListener = r1;
    }

    public void setOnMonthChangedListener(OnMonthChangedListener r1) {
        this.monthListener = r1;
    }

    public void setOnRangeSelectedListener(OnRangeSelectedListener r1) {
        this.rangeListener = r1;
    }

    public void setOnTitleClickListener(View.OnClickListener r1) {
        this.title.setOnClickListener(r1);
    }

    protected void dispatchOnDateSelected(CalendarDay r2, boolean r3) {
        OnDateSelectedListener r0 = this.listener;
        if (r0 == null) goto L6;
        r0.onDateSelected(this, r2, r3);
        return;
    }

    protected void dispatchOnRangeSelected(List<CalendarDay> r2) {
        OnRangeSelectedListener r0 = this.rangeListener;
        if (r0 == null) goto L6;
        r0.onRangeSelected(this, r2);
        return;
    }

    protected void dispatchOnMonthChanged(CalendarDay r2) {
        OnMonthChangedListener r0 = this.monthListener;
        if (r0 == null) goto L6;
        r0.onMonthChanged(this, r2);
        return;
    }

    protected void onDateClicked(CalendarDay r4, boolean r5) {
        int r0 = this.selectionMode;
        if (r0 != 2) goto L5;
        this.adapter.setDateSelected(r4, r5);
        dispatchOnDateSelected(r4, r5);
        return;
    L5:
        if (r0 == 3) goto L7;
        this.adapter.clearSelections();
        this.adapter.setDateSelected(r4, true);
        dispatchOnDateSelected(r4, true);
        return;
    L7:
        List<CalendarDay> r1 = this.adapter.getSelectedDates();
        if (r1.size() != 0) goto L11;
        this.adapter.setDateSelected(r4, r5);
        dispatchOnDateSelected(r4, r5);
        return;
    L11:
        if (r1.size() != 1) goto L19;
        CalendarDay r2 = r1.get(0);
        if (r2.equals(r4) == false) goto L16;
        this.adapter.setDateSelected(r4, r5);
        dispatchOnDateSelected(r4, r5);
        return;
    L16:
        if (r2.isAfter(r4) == false) goto L18;
        this.adapter.selectRange(r4, r2);
        dispatchOnRangeSelected(this.adapter.getSelectedDates());
        return;
    L18:
        this.adapter.selectRange(r2, r4);
        dispatchOnRangeSelected(this.adapter.getSelectedDates());
        return;
    L19:
        this.adapter.clearSelections();
        this.adapter.setDateSelected(r4, r5);
        dispatchOnDateSelected(r4, r5);
    }

    public void selectRange(CalendarDay r2, CalendarDay r3) {
        if (r2 == null) goto L10;
        if (r3 != null) goto L6;
        return;
    L6:
        if (r2.isAfter(r3) == false) goto L8;
        this.adapter.selectRange(r3, r2);
        dispatchOnRangeSelected(this.adapter.getSelectedDates());
        return;
    L8:
        this.adapter.selectRange(r2, r3);
        dispatchOnRangeSelected(this.adapter.getSelectedDates());
        return;
    }

    protected void onDateClicked(DayView r7) {
        CalendarDay r0 = getCurrentDate();
        CalendarDay r1 = r7.getDate();
        int r2 = r0.getMonth();
        int r3 = r1.getMonth();
        if (this.calendarMode == CalendarMode.MONTHS) goto L5;
    L13:
        onDateClicked(r7.getDate(), !r7.isChecked());
        return;
    L5:
        if (this.allowClickDaysOutsideCurrentMonth == false) goto L13;
        if (r2 == r3) goto L13;
        if (r0.isAfter(r1) == false) goto L11;
        goToPrevious();
        goto L13
    L11:
        if (r0.isBefore(r1) == false) goto L13;
        goToNext();
        goto L13
    }

    protected void onDateLongClicked(DayView r2) {
        OnDateLongClickListener r0 = this.longClickListener;
        if (r0 == null) goto L6;
        r0.onDateLongClick(this, r2.getDate());
        return;
    }

    protected void onDateUnselected(CalendarDay r2) {
        dispatchOnDateSelected(r2, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        if (getAlpha() >= 1.0f) goto L7;
        return true;
    L7:
        return super.dispatchTouchEvent(r3);
    }

    @Override // android.view.View
    protected void onMeasure(int r14, int r15) {
        int r0 = View.MeasureSpec.getSize(r14);
        int r16 = View.MeasureSpec.getMode(r14);
        int r1 = View.MeasureSpec.getSize(r15);
        int r17 = View.MeasureSpec.getMode(r15);
        if (this.weekDaysHeight != (-10)) goto L5;
        this.weekDaysHeight = dpToPx(28);
    L5:
        int r2 = (r0 - getPaddingLeft()) - getPaddingRight();
        int r3 = (r1 - getPaddingTop()) - getPaddingBottom();
        int r4 = this.tileWidth;
        if (r4 <= 0) goto L8;
        this.measureInfo.tileWidth = r4;
    L9:
        int r5 = this.tileHeight;
        if (r5 <= 0) goto L12;
        this.measureInfo.tileHeight = r5;
    L13:
        int r6 = 0;
        int r7 = Math.max(getTileHSpacing(), 0);
        int r8 = Math.max(getTileVSpacing(), 0);
        int r9 = getChildCount();
        int r10 = 0;
        int r11 = 0;
    L14:
        if (r6 >= r9) goto L32;
        View r12 = getChildAt(r6);
        if (r12.getVisibility() == 8) goto L31;
        if (r16 != 1073741824) goto L21;
        int r13 = r2;
    L22:
        int r18 = View.MeasureSpec.makeMeasureSpec(r13, 1073741824);
        if (r17 != 1073741824) goto L25;
        int r19 = r3;
    L30:
        r12.measure(r18, View.MeasureSpec.makeMeasureSpec(r19, 1073741824));
        r10 = Math.max(r10, (r12.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight());
        r11 = Math.max(r11, (r12.getMeasuredHeight() + getPaddingTop()) + getPaddingBottom());
        goto L31
    L25:
        int r110 = (this.measureInfo.tileHeight + r8) * 6;
        if (this.showWeekDays == false) goto L28;
        int r111 = this.weekDaysHeight;
    L29:
        r19 = r110 + r111;
        goto L30
    L28:
        r111 = -r8;
        goto L29
    L21:
        r13 = (this.measureInfo.tileWidth * 7) + (r7 * 6);
    L31:
        r6 = r6 + 1;
        goto L14
    L32:
        setMeasuredDimension(r10, r11);
        return;
    L12:
        this.measureInfo.tileHeight = dpToPx(40);
        goto L13
    L8:
        this.measureInfo.tileWidth = dpToPx(40);
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
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

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof ViewGroup.LayoutParams;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r1) {
        super.onInitializeAccessibilityEvent(r1);
        r1.setClassName(MaterialCalendarView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        r1.setClassName(MaterialCalendarView.class.getName());
    }

    public void setPagingEnabled(boolean r2) {
        this.pager.setPagingEnabled(r2);
        updateUi();
    }

    public boolean isPagingEnabled() {
        return this.pager.isPagingEnabled();
    }

    public State state() {
        return this.state;
    }

    public StateBuilder newState() {
        return new StateBuilder(this);
    }

    private void commit(State r6) {
        if (this.adapter != null) goto L5;
    L32:
        CalendarDay r0 = null;
    L33:
        this.state = r6;
        this.calendarMode = State.access$1600(r6);
        this.firstDayOfWeek = State.access$1700(r6);
        this.minDate = State.access$1800(r6);
        this.maxDate = State.access$1900(r6);
        this.showWeekDays = State.access$2000(r6);
        int r7 = AnonymousClass4.$SwitchMap$com$obric$oui$calendar$CalendarMode[this.calendarMode.ordinal()];
        if (r7 != 1) goto L36;
        CalendarPagerAdapter<?> r8 = new MonthPagerAdapter(this);
    L41:
        CalendarPagerAdapter<?> r2 = this.adapter;
        if (r2 != null) goto L44;
        this.adapter = r8;
    L45:
        this.adapter.setShowWeekDays(this.showWeekDays);
        this.pager.setAdapter(this.adapter);
        setRangeDates(this.minDate, this.maxDate);
        if (this.selectionMode == 1) goto L48;
    L50:
        CalendarDay r9 = CalendarDay.today();
    L51:
        setCurrentDate(r9);
        if (r0 == null) goto L54;
        this.pager.setCurrentItem(this.adapter.getIndexForDay(r0));
    L54:
        invalidateDecorators();
        updateUi();
        return;
    L48:
        if (this.adapter.getSelectedDates().isEmpty() == true) goto L50;
        r9 = this.adapter.getSelectedDates().get(0);
        goto L51
    L44:
        this.adapter = r2.migrateStateAndReturn(r8);
        goto L45
    L36:
        if (r7 != 2) goto L39;
        r8 = new WeekPagerAdapter(this);
        goto L41
    L39:
        throw new IllegalArgumentException("Provided display mode which is not yet implemented");
    L5:
        if (State.access$700(r6) == false) goto L32;
        r0 = this.adapter.getItem(this.pager.getCurrentItem());
        if (this.calendarMode == State.access$1600(r6)) goto L33;
        CalendarDay r1 = getSelectedDate();
        if (this.calendarMode != CalendarMode.MONTHS) goto L19;
        if (r1 == null) goto L19;
        CalendarDay r3 = CalendarDay.from(r0.getDate().plusDays(1));
        if (r1.equals(r0) == false) goto L14;
    L30:
        r0 = r1;
        goto L33
    L14:
        if (r1.isAfter(r0) == false) goto L33;
        if (r1.isBefore(r3) == false) goto L33;
    L19:
        if (this.calendarMode != CalendarMode.WEEKS) goto L33;
        CalendarDay r4 = CalendarDay.from(r0.getDate().plusDays(6));
        if (r1 != null) goto L23;
    L31:
        r0 = r4;
        goto L33
    L23:
        if (r1.equals(r0) == true) goto L30;
        if (r1.equals(r4) == true) goto L30;
        if (r1.isAfter(r0) == false) goto L31;
        if (r1.isBefore(r4) == false) goto L31;
        goto L30
    }

    private static void enableView(View r0, boolean r1) {
        r0.setEnabled(r1);
        if (r1 == false) goto L5;
        float r2 = 1.0f;
    L6:
        r0.setAlpha(r2);
        return;
    L5:
        r2 = 0.1f;
        goto L6
    }

    public MeasureInfo getMeasureInfo() {
        return this.measureInfo;
    }
}
