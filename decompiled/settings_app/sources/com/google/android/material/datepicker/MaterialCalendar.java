package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.teaevent.AppMetricsUtils;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialCalendar<S> extends PickerFragment<S> {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final String CURRENT_MONTH_KEY = "CURRENT_MONTH_KEY";
    private static final String GRID_SELECTOR_KEY = "GRID_SELECTOR_KEY";
    static final Object MONTHS_VIEW_GROUP_TAG = null;
    static final Object NAVIGATION_NEXT_TAG = null;
    static final Object NAVIGATION_PREV_TAG = null;
    static final Object SELECTOR_TOGGLE_TAG = null;
    private static final int SMOOTH_SCROLL_MAX = 3;
    private static final String THEME_RES_ID_KEY = "THEME_RES_ID_KEY";
    private CalendarConstraints calendarConstraints;
    private CalendarSelector calendarSelector;
    private CalendarStyle calendarStyle;
    private Month current;
    private DateSelector<S> dateSelector;
    private View dayFrame;
    private RecyclerView recyclerView;
    private int themeResId;
    private View yearFrame;
    private RecyclerView yearSelector;

    static final enum CalendarSelector extends Enum<CalendarSelector> {
        private static final /* synthetic */ CalendarSelector[] $VALUES = null;
        public static final CalendarSelector DAY = null;
        public static final CalendarSelector YEAR = null;

        private CalendarSelector(String r1, int r2) {
            super(r1, r2);
        }

        public static CalendarSelector valueOf(String r1) {
            return (CalendarSelector) Enum.valueOf(CalendarSelector.class, r1);
        }

        public static CalendarSelector[] values() {
            return (CalendarSelector[]) $VALUES.clone();
        }

        static {
            CalendarSelector r0 = new CalendarSelector("DAY", 0);
            DAY = r0;
            CalendarSelector r1 = new CalendarSelector("YEAR", 1);
            YEAR = r1;
            $VALUES = new CalendarSelector[]{r0, r1};
        }
    }

    interface OnDayClickListener {
        void onDayClick(long r1);
    }

    public void com_google_android_material_datepicker_MaterialCalendar__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_google_android_material_datepicker_MaterialCalendar_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_google_android_material_datepicker_MaterialCalendar_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public MaterialCalendar() {
    }

    static /* synthetic */ RecyclerView access$000(MaterialCalendar r0) {
        return r0.recyclerView;
    }

    static /* synthetic */ CalendarConstraints access$100(MaterialCalendar r0) {
        return r0.calendarConstraints;
    }

    static /* synthetic */ DateSelector access$200(MaterialCalendar r0) {
        return r0.dateSelector;
    }

    static /* synthetic */ RecyclerView access$300(MaterialCalendar r0) {
        return r0.yearSelector;
    }

    static /* synthetic */ CalendarStyle access$400(MaterialCalendar r0) {
        return r0.calendarStyle;
    }

    static /* synthetic */ View access$500(MaterialCalendar r0) {
        return r0.dayFrame;
    }

    static /* synthetic */ Month access$602(MaterialCalendar r0, Month r1) {
        r0.current = r1;
        return r1;
    }

    static {
        MONTHS_VIEW_GROUP_TAG = "MONTHS_VIEW_GROUP_TAG";
        NAVIGATION_PREV_TAG = "NAVIGATION_PREV_TAG";
        NAVIGATION_NEXT_TAG = "NAVIGATION_NEXT_TAG";
        SELECTOR_TOGGLE_TAG = "SELECTOR_TOGGLE_TAG";
    }

    public static <T> MaterialCalendar<T> newInstance(DateSelector<T> r3, int r4, CalendarConstraints r5) {
        MaterialCalendar<T> r0 = new MaterialCalendar();
        Bundle r1 = new Bundle();
        r1.putInt(THEME_RES_ID_KEY, r4);
        r1.putParcelable(GRID_SELECTOR_KEY, r3);
        r1.putParcelable(CALENDAR_CONSTRAINTS_KEY, r5);
        r1.putParcelable(CURRENT_MONTH_KEY, r5.getOpenAt());
        r0.setArguments(r1);
        return r0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putInt(THEME_RES_ID_KEY, this.themeResId);
        r3.putParcelable(GRID_SELECTOR_KEY, this.dateSelector);
        r3.putParcelable(CALENDAR_CONSTRAINTS_KEY, this.calendarConstraints);
        r3.putParcelable(CURRENT_MONTH_KEY, this.current);
    }

    public void com_google_android_material_datepicker_MaterialCalendar__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        if (r2 != null) goto L5;
        r2 = getArguments();
    L5:
        this.themeResId = r2.getInt(THEME_RES_ID_KEY);
        this.dateSelector = (DateSelector) r2.getParcelable(GRID_SELECTOR_KEY);
        this.calendarConstraints = (CalendarConstraints) r2.getParcelable(CALENDAR_CONSTRAINTS_KEY);
        this.current = (Month) r2.getParcelable(CURRENT_MONTH_KEY);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        ContextThemeWrapper r14 = new ContextThemeWrapper(getContext(), this.themeResId);
        this.calendarStyle = new CalendarStyle(r14);
        LayoutInflater r15 = r11.cloneInContext(r14);
        Month r0 = this.calendarConstraints.getStart();
        if (MaterialDatePicker.isFullscreen(r14) == false) goto L5;
        int r1 = R.layout.mtrl_calendar_vertical;
        final int r9 = 1;
    L6:
        View r16 = r15.inflate(r1, r12, false);
        r16.setMinimumHeight(getDialogPickerHeight(requireContext()));
        GridView r17 = (GridView) r16.findViewById(R.id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(r17, new AnonymousClass1(this));
        r17.setAdapter(new DaysOfWeekAdapter());
        r17.setNumColumns(r0.daysInWeek);
        r17.setEnabled(false);
        this.recyclerView = (RecyclerView) r16.findViewById(R.id.mtrl_calendar_months);
        final Context r6 = getContext();
        final boolean r8 = false;
        final int r7 = r9;
        this.recyclerView.setLayoutManager(new AnonymousClass2(this, r6, r7, r8, r9));
        this.recyclerView.setTag(MONTHS_VIEW_GROUP_TAG);
        MonthsPagerAdapter r18 = new MonthsPagerAdapter(r14, this.dateSelector, this.calendarConstraints, new AnonymousClass3(this));
        this.recyclerView.setAdapter(r18);
        int r2 = r14.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        RecyclerView r3 = (RecyclerView) r16.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.yearSelector = r3;
        if (r3 == null) goto L10;
        r3.setHasFixedSize(true);
        this.yearSelector.setLayoutManager(new GridLayoutManager(r14, r2, 1, false));
        this.yearSelector.setAdapter(new YearGridAdapter(this));
        this.yearSelector.addItemDecoration(createItemDecoration());
    L10:
        if (r16.findViewById(R.id.month_navigation_fragment_toggle) == null) goto L13;
        addActionsToMonthNavigation(r16, r18);
    L13:
        if (MaterialDatePicker.isFullscreen(r14) == true) goto L15;
        new PagerSnapHelper().attachToRecyclerView(this.recyclerView);
    L15:
        this.recyclerView.scrollToPosition(r18.getPosition(this.current));
        return r16;
    L5:
        r1 = R.layout.mtrl_calendar_horizontal;
        r9 = 0;
        goto L6
    }

    private RecyclerView.ItemDecoration createItemDecoration() {
        return new AnonymousClass4(this);
    }

    Month getCurrentMonth() {
        return this.current;
    }

    CalendarConstraints getCalendarConstraints() {
        return this.calendarConstraints;
    }

    void setCurrentMonth(Month r7) {
        MonthsPagerAdapter r0 = (MonthsPagerAdapter) this.recyclerView.getAdapter();
        int r1 = r0.getPosition(r7);
        int r2 = r1 - r0.getPosition(this.current);
        boolean r4 = true;
        if (Math.abs(r2) <= 3) goto L5;
        boolean r3 = true;
    L6:
        if (r2 > 0) goto L9;
        r4 = false;
    L9:
        this.current = r7;
        if (r3 == false) goto L13;
        if (r4 == false) goto L13;
        this.recyclerView.scrollToPosition(r1 - 3);
        postSmoothRecyclerViewScroll(r1);
        return;
    L13:
        if (r3 == false) goto L15;
        this.recyclerView.scrollToPosition(r1 + 3);
        postSmoothRecyclerViewScroll(r1);
        return;
    L15:
        postSmoothRecyclerViewScroll(r1);
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public DateSelector<S> getDateSelector() {
        return this.dateSelector;
    }

    CalendarStyle getCalendarStyle() {
        return this.calendarStyle;
    }

    static int getDayHeight(Context r1) {
        return r1.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
    }

    void setSelector(CalendarSelector r5) {
        this.calendarSelector = r5;
        if (r5 != CalendarSelector.YEAR) goto L6;
        this.yearSelector.getLayoutManager().scrollToPosition(((YearGridAdapter) this.yearSelector.getAdapter()).getPositionForYear(this.current.year));
        this.yearFrame.setVisibility(0);
        this.dayFrame.setVisibility(8);
        return;
    L6:
        if (r5 != CalendarSelector.DAY) goto L10;
        this.yearFrame.setVisibility(8);
        this.dayFrame.setVisibility(0);
        setCurrentMonth(this.current);
        return;
    }

    void toggleVisibleSelector() {
        if (this.calendarSelector != CalendarSelector.YEAR) goto L6;
        setSelector(CalendarSelector.DAY);
        return;
    L6:
        if (this.calendarSelector != CalendarSelector.DAY) goto L10;
        setSelector(CalendarSelector.YEAR);
        return;
    }

    private void addActionsToMonthNavigation(View r5, final MonthsPagerAdapter r6) {
        final MaterialButton r0 = (MaterialButton) r5.findViewById(R.id.month_navigation_fragment_toggle);
        r0.setTag(SELECTOR_TOGGLE_TAG);
        ViewCompat.setAccessibilityDelegate(r0, new AnonymousClass5(this));
        MaterialButton r1 = (MaterialButton) r5.findViewById(R.id.month_navigation_previous);
        r1.setTag(NAVIGATION_PREV_TAG);
        MaterialButton r2 = (MaterialButton) r5.findViewById(R.id.month_navigation_next);
        r2.setTag(NAVIGATION_NEXT_TAG);
        this.yearFrame = r5.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.dayFrame = r5.findViewById(R.id.mtrl_calendar_day_selector_frame);
        setSelector(CalendarSelector.DAY);
        r0.setText(this.current.getLongName());
        this.recyclerView.addOnScrollListener(new AnonymousClass6(this, r6, r0));
        r0.setOnClickListener(new AnonymousClass7(this));
        r2.setOnClickListener(new AnonymousClass8(this, r6));
        r1.setOnClickListener(new AnonymousClass9(this, r6));
    }

    private void postSmoothRecyclerViewScroll(final int r3) {
        this.recyclerView.post(new AnonymousClass10(this, r3));
    }

    private static int getDialogPickerHeight(Context r5) {
        Resources r6 = r5.getResources();
        int r0 = (r6.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height) + r6.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding)) + r6.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding);
        int r1 = r6.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
        return ((r0 + r1) + ((MonthAdapter.MAXIMUM_WEEKS * r6.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height)) + ((MonthAdapter.MAXIMUM_WEEKS - 1) * r6.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding)))) + r6.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding);
    }

    LinearLayoutManager getLayoutManager() {
        return (LinearLayoutManager) this.recyclerView.getLayoutManager();
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public boolean addOnSelectionChangedListener(OnSelectionChangedListener<S> r1) {
        return super.addOnSelectionChangedListener(r1);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_google_android_material_datepicker_MaterialCalendar_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(MaterialCalendar r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_google_android_material_datepicker_MaterialCalendar__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_google_android_material_datepicker_MaterialCalendar_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(MaterialCalendar r2) {
        String r0 = r2.getClass().getName();
        com_google_android_material_datepicker_MaterialCalendar_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_google_android_material_datepicker_MaterialCalendar_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(MaterialCalendar r2) {
        String r0 = r2.getClass().getName();
        r2.com_google_android_material_datepicker_MaterialCalendar__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
