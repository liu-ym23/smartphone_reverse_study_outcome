package obric.widget.calendar;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import obric.util.CalendarUtils;
import obric.widget.DatePickerExDialog;
import obric.widget.MenuDialogTitleBar;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class CalendarView extends FrameLayout implements DragViewSwitcher.DragViewSwitcherListener, View.OnClickListener {
    private static final int MESID_JMP = 1;
    protected MonthByWeekAdapter mAdapter;
    protected int mAddTimes;
    ImageView mAllNextIv;
    ImageView mAllPreviousIv;
    MonthByWeekAdapter.CellEventListener mCellEventListener;
    protected int mCurrentMonthDisplayed;
    protected String[] mDayLabels;
    ViewGroup mDayNamesHeader;
    TextView mDayTitle;
    protected Time mFirstDayOfMonth;
    protected int mFirstDayOfWeek;
    protected boolean mFirstJumpCalendar;
    private Formatter mFormatter;
    protected Handler mHandler;
    private boolean mIsWeeksLayoutInAnimation;
    private Time mMaxTime;
    private Time mMinTime;
    private boolean mNeedToHandleTitleClicked;
    private long mSelectedMills;
    private Time mSelectedTime;
    private StringBuilder mStringBuilder;
    protected Time mTempTime;
    private ViewSwitcher.ViewFactory mViewFactory;
    DragViewSwitcher mViewSwitcher;
    RelativeLayout mWeeksLayout;
    protected LinkedList<Calendar> needToRunCals;

    static /* synthetic */ Time access$000(CalendarView r0) {
        return r0.mMinTime;
    }

    static /* synthetic */ Time access$100(CalendarView r0) {
        return r0.mMaxTime;
    }

    static /* synthetic */ void access$200(CalendarView r0, Time r1) {
        r0.onDayTapped(r1);
    }

    static /* synthetic */ long access$300(CalendarView r2) {
        return r2.mSelectedMills;
    }

    static /* synthetic */ long access$302(CalendarView r0, long r1) {
        r0.mSelectedMills = r1;
        return r1;
    }

    static /* synthetic */ boolean access$400(CalendarView r0, int r1) {
        return r0.changeCurrentTime(r1);
    }

    static /* synthetic */ int access$500(CalendarView r0, Calendar r1) {
        return r0.getAndCorrectDay(r1);
    }

    static /* synthetic */ boolean access$602(CalendarView r0, boolean r1) {
        r0.mIsWeeksLayoutInAnimation = r1;
        return r1;
    }

    public CalendarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CalendarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mNeedToHandleTitleClicked = false;
        this.mFirstJumpCalendar = true;
        this.mSelectedTime = new Time();
        this.mMaxTime = new Time();
        this.mMinTime = new Time();
        this.needToRunCals = new LinkedList();
        this.mTempTime = new Time();
        this.mFirstDayOfMonth = new Time();
        this.mCellEventListener = new AnonymousClass1(this);
        this.mViewFactory = new AnonymousClass2(this);
        this.mHandler = new AnonymousClass3(this);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.calendar_view, this, true);
        initViews();
        intDatas();
        setupAdapter();
        updateDayNamesHeader();
    }

    protected void updateDayNamesHeader() {
        int r0 = this.mFirstDayOfWeek;
        int r2 = 0;
    L4:
        if (r2 >= 7) goto L10;
        TextView r4 = (TextView) this.mDayNamesHeader.getChildAt(r2);
        if (r2 >= 8) goto L8;
        r4.setText(this.mDayLabels[(r0 + r2) % 7]);
        r4.setVisibility(0);
    L9:
        r2 = r2 + 1;
        goto L4
    L8:
        r4.setVisibility(8);
        goto L9
    }

    private void initViews() {
        this.mDayNamesHeader = (ViewGroup) findViewById(R.id.day_names);
        TextView r0 = (TextView) findViewById(R.id.date_title);
        this.mDayTitle = r0;
        r0.setOnClickListener(this);
        ImageView r1 = (ImageView) findViewById(R.id.allinone_image_previous);
        this.mAllPreviousIv = r1;
        r1.setOnClickListener(this);
        ImageView r2 = (ImageView) findViewById(R.id.allinone_image_next);
        this.mAllNextIv = r2;
        r2.setOnClickListener(this);
        DragViewSwitcher r3 = (DragViewSwitcher) findViewById(R.id.main_switcher);
        this.mViewSwitcher = r3;
        r3.setFactory(this.mViewFactory);
        this.mViewSwitcher.addDragViewSwitcherActor(this);
        this.mDayLabels = new String[7];
        int r4 = 1;
    L3:
        if (r4 > 7) goto L5;
        this.mDayLabels[r4 - 1] = DateUtils.getDayOfWeekString(r4, 20).toUpperCase();
        r4 = r4 + 1;
        goto L3
    }

    protected void intDatas() {
        this.mStringBuilder = new StringBuilder(50);
        this.mFormatter = new Formatter(this.mStringBuilder, Locale.getDefault());
    }

    protected void animationEnd(Calendar targetC) {
        Time r0 = new Time();
        r0.set(targetC.getTimeInMillis());
        this.mSelectedTime = r0;
        updateDateInTitle();
    }

    public Time getCurrentTime() {
        return this.mSelectedTime;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new DateTimeSavedState(super.onSaveInstanceState(), this.mMinTime.toMillis(true), this.mSelectedMills, this.mMaxTime.toMillis(true));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (state != null) goto L4;
        return;
    L4:
        if ((state instanceof DateTimeSavedState) == false) goto L9;
        DateTimeSavedState r9 = (DateTimeSavedState) state;
        super.onRestoreInstanceState(r9.getSuperState());
        initTimes(r9.getMinMills(), r9.getCurrentMills(), r9.getMaxMills());
        return;
    }

    protected int jumpToDayForMonth(Calendar targetCal, boolean isDropEnd) {
        this.mFirstJumpCalendar = true;
        Calendar r2 = getCalendarBeforeJump(false);
        if (this.mSelectedTime.month != targetCal.get(2)) goto L10;
        if (this.mSelectedTime.year != targetCal.get(1)) goto L10;
        if (Math.abs(this.mAddTimes) != 1) goto L10;
        targetCal.set(5, this.mSelectedTime.monthDay);
    L10:
        if (isSameCalendarByFields(r2, targetCal, new int[]{1, 2}) == false) goto L14;
        long r1 = targetCal.getTimeInMillis();
        this.mSelectedMills = r1;
        goTo(r1, true);
        animationEnd(targetCal);
        return 0;
    L14:
        if (prepareJumpNextView(r2.before(targetCal), getNeedToJumpCalendar(r2, targetCal, 2, 1, new int[]{1, 2})) == false) goto L16;
        this.mViewSwitcher.showNext();
    L16:
        return 0;
    }

    protected Calendar[] getNeedToJumpCalendar(Calendar curSelectTime, Calendar targetTime, int field, int diffy, int... compareFiled) {
        ArrayList r0 = new ArrayList();
        boolean r1 = curSelectTime.after(targetTime);
        if (r1 == false) goto L5;
        Calendar r2 = targetTime;
    L6:
        if (r1 == true) goto L9;
        curSelectTime = targetTime;
    L9:
        r0.add(targetTime);
        Calendar r3 = getCalendarByOffsetInField(r2, field, diffy);
        if (isSameCalendarByFields(r3, curSelectTime, compareFiled) == true) goto L17;
        if (curSelectTime.after(r3) == false) goto L17;
        r0.add(targetTime);
        if (isSameCalendarByFields(getCalendarByOffsetInField(curSelectTime, field, 0 - diffy), r3, compareFiled) == true) goto L17;
        r0.add(targetTime);
    L17:
        return (Calendar[]) r0.toArray(new Calendar[0]);
    L5:
        r2 = curSelectTime;
        goto L6
    }

    private Calendar getCalendarByOffsetInField(Calendar refCalendar, int field, int offset) {
        Calendar r2 = Calendar.getInstance();
        r2.setTimeInMillis(refCalendar.getTimeInMillis());
        r2.add(field, offset);
        return r2;
    }

    public boolean goTo(long time, boolean hasFocus) {
        this.mSelectedTime.set(time);
        this.mSelectedTime.normalize(true);
        this.mTempTime.set(time);
        this.mTempTime.normalize(true);
        this.mFirstDayOfMonth.set(this.mTempTime);
        this.mFirstDayOfMonth.monthDay = 1;
        long r3 = this.mFirstDayOfMonth.normalize(true);
        setMonthDisplayed(this.mFirstDayOfMonth, true);
        int r4 = CalendarUtils.getWeeksSinceEpochFromJulianDay(Time.getJulianDay(r3, this.mFirstDayOfMonth.gmtoff), this.mFirstDayOfWeek);
        this.mAdapter.setPosition(r4);
        this.mAdapter.setSelectedDay(this.mSelectedTime, hasFocus);
        updateDateInTitle();
        return false;
    }

    protected void setMonthDisplayed(Time time, boolean updateHighlight) {
        int r1 = time.month;
        this.mCurrentMonthDisplayed = r1;
        if (updateHighlight == false) goto L6;
        this.mAdapter.updateFocusMonth(r1);
    L6:
        if (this.mSelectedTime.minute < 30) goto L8;
        this.mSelectedTime.minute = 30;
        return;
    L8:
        this.mSelectedTime.minute = 0;
    }

    protected boolean isSameCalendarByFields(Calendar a2, Calendar b, int... compareFiled) {
        int r1 = 0;
    L4:
        if (r1 >= compareFiled.length) goto L12;
        if (compareFiled[r1] != 3) goto L9;
        CalendarUtils.setFisrtDayOfWeek(getContext(), new Calendar[]{a2, b});
    L9:
        if (a2.get(compareFiled[r1]) != b.get(compareFiled[r1])) goto L10;
        r1 = r1 + 1;
        goto L4
    L10:
        return false;
    L12:
        return true;
    }

    public void initTimes(long minMills, long currentMills, long maxMills) {
        setSelectTime(currentMills);
        this.mMinTime.set(minMills);
        this.mMinTime.normalize(true);
        this.mMaxTime.set(maxMills);
        this.mMaxTime.normalize(true);
        goTo(this.mSelectedMills, true);
        setupWeeksLayout(true);
        this.mAdapter.updateRange(CalendarUtils.getJulianDay(this.mMinTime), CalendarUtils.getJulianDay(this.mMaxTime));
    }

    private void setSelectTime(long currentMills) {
        this.mSelectedMills = currentMills;
        this.mSelectedTime.set(currentMills);
        this.mSelectedTime.normalize(true);
        this.mAdapter.setSelectedDay(this.mSelectedTime);
    }

    public void initTimes(long iniTimeMills) {
        initTimes(iniTimeMills, iniTimeMills, CalendarUtils.getMaxTimeMills());
    }

    protected void setupAdapter() {
        this.mFirstDayOfWeek = CalendarUtils.getFirstDayOfWeekInTime(getContext());
        HashMap<String, Integer> r0 = new HashMap();
        r0.put(MonthByWeekAdapter.WEEK_PARAMS_NUM_WEEKS, 6);
        r0.put(MonthByWeekAdapter.WEEK_PARAMS_SINGLE_WEEK, 0);
        r0.put("week_start", Integer.valueOf(this.mFirstDayOfWeek));
        r0.put("selected_day", Integer.valueOf(Time.getJulianDay(this.mSelectedTime.toMillis(true), this.mSelectedTime.gmtoff)));
        r0.put(MonthByWeekAdapter.WEEK_PARAMS_DAYS_PER_WEEK, 7);
        r0.put("focus_month", Integer.valueOf(this.mSelectedTime.month));
        MonthByWeekAdapter r1 = this.mAdapter;
        if (r1 != null) goto L5;
        this.mAdapter = new MonthByWeekAdapter(getContext(), r0, this.mCellEventListener);
        return;
    L5:
        r1.updateParams(r0);
    }

    protected void setupWeeksLayout(boolean useCurrentView) {
        if (useCurrentView == false) goto L4;
        View r2 = this.mViewSwitcher.getCurrentView();
    L5:
        RelativeLayout r3 = (RelativeLayout) r2.findViewById(R.id.linearlayout_list);
        this.mWeeksLayout = r3;
        this.mAdapter.setWeeksLayout(r3);
        return;
    L4:
        r2 = this.mViewSwitcher.getNextView();
        goto L5
    }

    @Override // obric.widget.calendar.DragViewSwitcher.DragViewSwitcherListener
    public boolean prepareNextView(int changeKind) {
        if (isVailidToNext() == true) goto L5;
        return false;
    L5:
        Calendar r2 = getMonthCalendarByOffset(1);
        if (r2 != null) goto L9;
        return false;
    L9:
        return prepareFollowingView(changeKind, true, r2);
    }

    @Override // obric.widget.calendar.DragViewSwitcher.DragViewSwitcherListener
    public boolean preparePreviouseView(int changeKind) {
        if (isVailidToPrevious() == true) goto L5;
        return false;
    L5:
        Calendar r0 = getMonthCalendarByOffset(-1);
        if (r0 != null) goto L9;
        return false;
    L9:
        return prepareFollowingView(changeKind, false, r0);
    }

    protected boolean isVailidToPrevious() {
        Calendar r0 = getMonthCalendarByOffset(-1);
        if (r0 != null) goto L5;
        return false;
    L5:
        int r3 = r0.get(1);
        int r1 = r0.get(2);
        if (r3 >= this.mMinTime.year) goto L9;
        return false;
    L9:
        if (r3 == this.mMinTime.year) goto L11;
        return true;
    L11:
        if (r1 >= this.mMinTime.month) goto L13;
        return false;
    L13:
        return true;
    }

    protected boolean isVailidToNext() {
        Calendar r1 = getMonthCalendarByOffset(1);
        if (r1 != null) goto L5;
        return false;
    L5:
        int r3 = r1.get(1);
        int r2 = r1.get(2);
        if (r3 <= this.mMaxTime.year) goto L9;
        return false;
    L9:
        if (r3 == this.mMaxTime.year) goto L11;
        return true;
    L11:
        if (r2 > this.mMaxTime.month) goto L14;
        return true;
    L14:
        return false;
    }

    protected boolean prepareFollowingView(int changeKind, boolean isNext, Calendar c) {
        this.mFirstJumpCalendar = true;
        if (changeKind == 1) goto L5;
        return false;
    L5:
        return prepareJumpNextView(isNext, new Calendar[]{c});
    }

    protected Calendar getMonthCalendarByOffset(int offset) {
        Calendar r0 = getCalendarBeforeJump(!this.mFirstJumpCalendar);
        this.mFirstJumpCalendar = false;
        r0.add(2, offset);
        if (this.mSelectedTime.month == r0.get(2)) goto L5;
    L7:
        r0.set(5, getAndCorrectDay(r0));
    L9:
        if (r0.get(1) <= 2037) goto L11;
        return null;
    L11:
        if (r0.get(1) < 1970) goto L16;
        return r0;
    L16:
        return null;
    L5:
        if (this.mSelectedTime.year != r0.get(1)) goto L7;
        r0.set(5, this.mSelectedTime.monthDay);
        goto L9
    }

    private int getAndCorrectDay(Calendar calendar) {
        if (calendar.get(1) == this.mMinTime.year) goto L5;
        return 1;
    L5:
        if (calendar.get(2) <= this.mMinTime.month) goto L7;
        return 1;
    L7:
        return this.mMinTime.monthDay;
    }

    protected boolean prepareJumpNextView(boolean next, Calendar... c) {
        if (CalendarUtils.isValidDay(c[0].getTimeInMillis()) == true) goto L6;
        return false;
    L6:
        if (this.mIsWeeksLayoutInAnimation == false) goto L9;
        this.needToRunCals.add(c[0]);
        return false;
    L9:
        setupWeeksLayout(false);
        long r1 = c[0].getTimeInMillis();
        this.mSelectedMills = r1;
        if (c.length != 1) goto L12;
        boolean r3 = true;
    L13:
        goTo(r1, r3);
        int r2 = 1;
    L15:
        if (r2 >= c.length) goto L17;
        this.needToRunCals.add(c[r2]);
        r2 = r2 + 1;
        goto L15
    L17:
        int r4 = this.needToRunCals.size();
        setupScrollAnim(next, getAniminationListener(next, c[0], r4), SequenceAnimUtils.getInterpolator(r4, r4), SequenceAnimUtils.getDuration(r4, r4));
        return true;
    L12:
        r3 = false;
        goto L13
    }

    protected Time getTime(Calendar calendar) {
        Time r2 = new Time();
        r2.set(calendar.getTime().getTime());
        return r2;
    }

    protected Animation.AnimationListener getAniminationListener(final boolean next, final Calendar c, final int allCount) {
        return new AnonymousClass4(this, allCount, next, c);
    }

    protected void setupScrollAnim(boolean next, Animation.AnimationListener listener, Interpolator interpolator, int duration) {
        if (next == false) goto L4;
        Animation r4 = AnimationUtils.loadAnimation(getContext(), R.anim.remind_week_left_in);
        Animation r0 = AnimationUtils.loadAnimation(getContext(), R.anim.remind_week_left_out);
    L5:
        long r1 = duration;
        r4.setDuration(r1);
        this.mViewSwitcher.setInAnimation(r4);
        r0.setDuration(r1);
        this.mViewSwitcher.setOutAnimation(r0);
        r4.setAnimationListener(listener);
        if (interpolator == null) goto L9;
        r4.setInterpolator(interpolator);
        r0.setInterpolator(interpolator);
        return;
    L9:
        return;
    L4:
        r4 = AnimationUtils.loadAnimation(getContext(), R.anim.remind_week_right_in);
        r0 = AnimationUtils.loadAnimation(getContext(), R.anim.remind_week_right_out);
        goto L5
    }

    private Calendar getCalendarBeforeJump(boolean ignoreFoucsMonth) {
        Calendar r0 = Calendar.getInstance();
        int r1 = this.mAdapter.getFocusMonth();
        if (ignoreFoucsMonth == false) goto L5;
    L8:
        if (ignoreFoucsMonth == false) goto L10;
        r0.setTimeInMillis(this.mSelectedMills);
    L11:
        return r0;
    L10:
        r0.setTimeInMillis(this.mSelectedTime.toMillis(true));
        goto L11
    L5:
        if (r1 == this.mSelectedTime.month) goto L8;
        r0.setTimeInMillis(getTimeByFocusMonth(r1).normalize(true));
        goto L11
    }

    protected Time getTimeByFocusMonth(int focusMonth) {
        Time r0 = new Time(this.mSelectedTime);
        if (focusMonth == 11) goto L5;
    L7:
        if (focusMonth == 0) goto L9;
    L11:
        r0.month = this.mAdapter.getFocusMonth();
        r0.monthDay = 15;
        return r0;
    L9:
        if (this.mSelectedTime.month != 11) goto L11;
        r0.year++;
        goto L11
    L5:
        if (this.mSelectedTime.month != 0) goto L7;
        r0.year--;
        goto L11
    }

    private void onDayTapped(Time tappedDay) {
        if (tappedDay != null) goto L4;
        return;
    L4:
        if (CalendarUtils.isValidDay(tappedDay.toMillis(true)) == true) goto L7;
        return;
    L7:
        if (CalendarUtils.isTheSameDay(tappedDay, this.mSelectedTime) == true) goto L11;
        setSelectTime(tappedDay.toMillis(true));
        this.mAdapter.onDayTapped(this.mSelectedTime);
        return;
    }

    private boolean changeCurrentTime(int var) {
        Calendar r3 = getMonthCalendarByOffset(var);
        if (r3 != null) goto L6;
        return false;
    L6:
        this.mSelectedMills = r3.getTimeInMillis();
        return true;
    }

    protected String buildMonthYearDate() {
        this.mStringBuilder.setLength(0);
        long r0 = this.mSelectedMills;
        if (this.mFirstJumpCalendar == false) goto L7;
        Time r2 = new Time();
        r2.set(this.mSelectedMills);
        if (r2.month == this.mAdapter.getFocusMonth()) goto L7;
        r0 = getTimeByFocusMonth(this.mAdapter.getFocusMonth()).toMillis(true);
    L7:
        long r6 = r0;
        return DateUtils.formatDateRange(getContext(), this.mFormatter, r6, r6, 52, this.mAdapter.getHomeTimeZone()).toString();
    }

    protected void updateDateInTitle() {
        this.mDayTitle.setText(buildMonthYearDate());
        ImageView r0 = this.mAllNextIv;
        int r2 = 4;
        if (CalendarUtils.turningMonthIsValid(this.mSelectedTime, true) == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        ImageView r3 = this.mAllPreviousIv;
        if (CalendarUtils.turningMonthIsValid(this.mSelectedTime, false) == false) goto L9;
        r2 = 0;
    L9:
        r3.setVisibility(r2);
        return;
    L5:
        r1 = 4;
        goto L6
    }

    protected void onDateTitleClicked() {
        final Context r2 = getContext();
        final DatePickerExDialog.OnDateSetListener r3 = new AnonymousClass5(this);
        final int r4 = this.mSelectedTime.year;
        final int r5 = this.mSelectedTime.month;
        final int r6 = this.mSelectedTime.monthDay;
        DatePickerExDialog r7 = new AnonymousClass6(this, r2, r3, r4, r5, r6);
        ((MenuDialogTitleBar) r7.findViewById(R.id.menu_dialog_title_bar)).setTitle(R.string.chose_date);
        r7.show();
    }

    public void setNeedToHandleTitleClicked(boolean handleTitleClicked) {
        this.mNeedToHandleTitleClicked = handleTitleClicked;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int r5 = v.getId();
        if (r5 != R.id.date_title) goto L8;
        if (this.mNeedToHandleTitleClicked == false) goto L32;
        onDateTitleClicked();
        return;
    L32:
        return;
    L8:
        if (r5 != R.id.allinone_image_previous) goto L20;
        if (this.needToRunCals.isEmpty() == true) goto L13;
        return;
    L13:
        if (isVailidToPrevious() == true) goto L16;
        return;
    L16:
        if (changeCurrentTime(-1) == false) goto L18;
        this.mAddTimes--;
        updateDateInTitle();
    L18:
        this.mHandler.removeMessages(1);
        Message r6 = this.mHandler.obtainMessage();
        r6.what = 1;
        this.mHandler.sendMessageDelayed(r6, 200);
        return;
    L20:
        if (r5 == R.id.allinone_image_next) goto L22;
        return;
    L22:
        if (this.needToRunCals.isEmpty() == true) goto L25;
        return;
    L25:
        if (isVailidToNext() == true) goto L28;
        return;
    L28:
        if (changeCurrentTime(1) == false) goto L30;
        this.mAddTimes++;
        updateDateInTitle();
    L30:
        this.mHandler.removeMessages(1);
        Message r7 = this.mHandler.obtainMessage();
        r7.what = 1;
        this.mHandler.sendMessageDelayed(r7, 200);
    }
}
