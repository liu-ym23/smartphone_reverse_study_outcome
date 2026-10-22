package obric.widget.calendar;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import obric.util.CalendarUtils;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class MonthWeekEventsView extends View {
    private static int DAY_SEPARATOR_INNER_WIDTH = 0;
    private static final boolean DEBUG_LAYOUT = false;
    private static int DEFAULT_EDGE_SPACING = 0;
    protected static final int DEFAULT_FOCUS_MONTH = -1;
    protected static int DEFAULT_HEIGHT = 32;
    protected static final int DEFAULT_NUM_DAYS = 7;
    protected static final int DEFAULT_SELECTED_DAY = -1;
    protected static final int DEFAULT_SHOW_WK_NUM = 0;
    protected static final int DEFAULT_WEEK_START = 0;
    public static int EXPANDED_HEIGHT = 10;
    public static int EXPANDED_WIDTH = 10;
    protected static int MINI_DAY_NUMBER_TEXT_SIZE = 0;
    private static final long SHAKE_ANIMATION_DURATION = 200;
    private static int SPACING_WEEK_NUMBER = 24;
    public static final float SWTICH_ANIM_CHANGE_POINT = 0.5f;
    private static final String TAG = "MonthView";
    private static int TODAY_HIGHLIGHT_WIDTH = 2;
    public static final String VIEW_PARAMS_FOCUS_MONTH = "focus_month";
    public static final String VIEW_PARAMS_HEIGHT = "height";
    public static final String VIEW_PARAMS_MAX_JULIANDAY = "max_julianday";
    public static final String VIEW_PARAMS_MIN_JULIANDAY = "min_julianday";
    public static final String VIEW_PARAMS_NUM_DAYS = "num_days";
    public static final String VIEW_PARAMS_SELECTED_WEEKDAY = "selected_day";
    public static final String VIEW_PARAMS_SHOW_WK_NUM = "show_wk_num";
    public static final String VIEW_PARAMS_SINGLE_WEEK = "is_single_week";
    public static final String VIEW_PARAMS_WEEK = "week";
    public static final String VIEW_PARAMS_WEEK_START = "week_start";
    private static final int mClickedAlpha = 128;
    private static boolean mInitialized = false;
    protected static float mScale = 0.0f;
    protected static StringBuilder mStringBuilder = null;
    private static int sBgMarginH = 3;
    private static float sBgMarginV = 4.0f;
    private static int sBorderWidth = 2;
    private static int sWeekCellTotalInterval;
    private Drawable EventDrawableWapper;
    private boolean hasFocus;
    private boolean mAnimateToday;
    private int mAnimateTodayAlpha;
    private float mAnimationValue;
    private ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener;
    private MonthByWeekDayViewDrawer mCellDrawer;
    MonthByWeekAdapter.CellEventListener mCellEventListener;
    private float mCellWidth;
    RectF mChildBounds;
    private int mClickedDayIndex;
    private Context mContext;
    protected String[] mDayNumbers;
    protected String[] mDayTexts;
    protected int mFakeSelectedDay;
    protected int mFirstJulianDay;
    protected int mFirstMonth;
    protected boolean[] mFocusDay;
    private List<Boolean> mHasEvents;
    protected boolean mHasSelectedDay;
    protected boolean mHasToday;
    protected int mHeight;
    private ValueAnimator.AnimatorUpdateListener mHeightUpdateListener;
    protected boolean[] mIsDayOutOfRange;
    private boolean mIsInScaleAnimation;
    private boolean mIsInShakeAnimation;
    private boolean mIsSingleWeek;
    protected boolean[] mIsTodayBefore;
    protected int mLastMonth;
    private int mMaxJulianDay;
    private int mMinJulianDay;
    private Drawable mMonthBGForDropDrawable;
    private Drawable mMonthBGNotFocusDrawable;
    private int mMonthEventTop;
    protected int mNumCells;
    protected int mNumDays;
    private View mOriginalView;
    protected int mPadding;
    private Resources mRes;
    protected Drawable mSelectedDayLine;
    private Drawable mSelectedFullMonthBG;
    protected int mSelectedLeft;
    protected int mSelectedRight;
    protected int mSelectedWeekDay;
    private float mSwitchAnimProgress;
    protected Time mTimeToday;
    protected String mTimeZone;
    protected int mToday;
    protected int mTodayAnimateColor;
    private ObjectAnimator mTodayAnimator;
    protected Drawable mTodayDrawable;
    private Drawable mTodayFullMonthBG;
    protected int mTodayIndex;
    private int mUndrawBackgoundIndex;
    private Drawable mUnfocusTodayFullMonthBG;
    protected int mWeek;
    private int mWeekEvenTop;
    private int mWeekEventWithLunarTop;
    protected int mWeekStart;
    protected int mWidth;
    protected Paint p;
    protected Rect r;

    /* JADX INFO: renamed from: obric.widget.calendar.MonthWeekEventsView$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnTouchListener {
        GestureDetector detector;
        boolean mHandleLongPressEvent;
        final /* synthetic */ MonthWeekEventsView this$0;

        AnonymousClass1(final MonthWeekEventsView this$0) {
            this.this$0 = this$0;
            this.mHandleLongPressEvent = false;
            this.detector = new GestureDetector(MonthWeekEventsView.access$000(this$0), new GestureDetectorOnGestureListenerC00881(this));
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            if ((event.getAction() & 255) != 0) goto L7;
            MotionEvent r3 = MotionEvent.obtain(event);
            r3.setDownTime(SystemClock.uptimeMillis());
            return this.detector.onTouchEvent(r3);
        L7:
            if (this.mHandleLongPressEvent == false) goto L11;
            return true;
        L11:
            return this.detector.onTouchEvent(event);
        }
    }

    static /* synthetic */ Context access$000(MonthWeekEventsView r0) {
        return r0.mContext;
    }

    static /* synthetic */ float access$102(MonthWeekEventsView r0, float r1) {
        r0.mAnimationValue = r1;
        return r1;
    }

    static /* synthetic */ void access$200(MonthWeekEventsView r0) {
        r0.updatePercent();
    }

    static {
        mStringBuilder = new StringBuilder(50);
    }

    public MonthWeekEventsView(Context context, MonthByWeekAdapter.CellEventListener listener) {
        super(context);
        this.mHasToday = false;
        this.mTodayIndex = -1;
        this.mClickedDayIndex = -1;
        this.mAnimateTodayAlpha = 0;
        this.mTodayAnimator = null;
        this.mTimeToday = new Time();
        this.mPadding = 0;
        this.r = new Rect();
        this.p = new Paint();
        this.mIsSingleWeek = false;
        this.mFirstJulianDay = -1;
        this.mFirstMonth = -1;
        this.mLastMonth = -1;
        this.mWeek = -1;
        this.mHeight = DEFAULT_HEIGHT;
        this.mHasSelectedDay = false;
        this.mSelectedWeekDay = -1;
        this.mFakeSelectedDay = -1;
        this.mWeekStart = 0;
        this.mNumDays = 7;
        this.mNumCells = 7;
        this.mSelectedLeft = -1;
        this.mSelectedRight = -1;
        this.mTimeZone = Time.getCurrentTimezone();
        this.mToday = -1;
        this.mSwitchAnimProgress = 0.0f;
        this.mUndrawBackgoundIndex = -1;
        this.mAnimationValue = 0.0f;
        this.mIsInShakeAnimation = false;
        this.mIsInScaleAnimation = false;
        this.mAnimatorUpdateListener = new AnonymousClass2(this);
        this.mHeightUpdateListener = new AnonymousClass3(this);
        this.mContext = context;
        this.mRes = context.getResources();
        if (mScale != 0.0f) goto L7;
        float r0 = context.getResources().getDisplayMetrics().density;
        mScale = r0;
        if (r0 == 1.0f) goto L7;
        DEFAULT_HEIGHT = (int) (DEFAULT_HEIGHT * r0);
    L7:
        sBgMarginV = context.getResources().getDimensionPixelOffset(R.dimen.monthbyweek_v);
        sBgMarginH = context.getResources().getDimensionPixelOffset(R.dimen.monthbyweek_h);
        sBorderWidth = context.getResources().getDimensionPixelOffset(R.dimen.monthbyweek_border_width);
        initView();
        this.mCellEventListener = listener;
        setOnTouchListener(new AnonymousClass1(this));
    }

    public RectF getBoundsForIndex(int index) {
        if (this.mChildBounds != null) goto L5;
        this.mChildBounds = new RectF();
    L5:
        RectF r0 = this.mChildBounds;
        float r2 = this.mCellWidth;
        r0.set(index * r2, 0.0f, (index + 1) * r2, this.mHeight);
        return this.mChildBounds;
    }

    public CharSequence getContentDescriptionForIndex(int index) {
        Time r0 = new Time(this.mTimeZone);
        r0.setJulianDay(this.mFirstJulianDay + index);
        return DateUtils.formatDateTime(this.mContext, r0.toMillis(true), 26);
    }

    public void setFakeSelectedDay(int selectDay) {
        if (this.mFakeSelectedDay == selectDay) goto L6;
        this.mFakeSelectedDay = selectDay;
        return;
    }

    public boolean hasFakeSelectedDay() {
        if (this.mFakeSelectedDay <= (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public void setSelectedDay(int selectDay) {
        if (this.mSelectedWeekDay == selectDay) goto L6;
        this.mSelectedWeekDay = selectDay;
        return;
    }

    public boolean hasSelectedDay() {
        return this.mHasSelectedDay;
    }

    void setHasEvents(List<Boolean> hasEvents) {
        this.mHasEvents = hasEvents;
    }

    protected void loadColors(Context context) {
        this.mTodayAnimateColor = this.mRes.getColor(R.color.today_highlight_color);
        this.mMonthBGForDropDrawable = this.mRes.getDrawable(R.drawable.remind_month_grid_body_for_drop);
        this.mMonthBGNotFocusDrawable = this.mRes.getDrawable(R.drawable.remind_month_view_grey_day_item);
        this.mTodayFullMonthBG = this.mRes.getDrawable(R.drawable.remind_calendar_month_view_today_focused_2);
        this.mUnfocusTodayFullMonthBG = this.mRes.getDrawable(R.drawable.remind_calendar_month_view_day_unfocused);
        this.mSelectedFullMonthBG = this.mRes.getDrawable(R.drawable.remind_calendar_month_view_day_focused_2);
        this.mTodayDrawable = this.mRes.getDrawable(R.drawable.remind_today_blue_week_holo_light);
    }

    protected void initView() {
        if (mInitialized == true) goto L8;
        sWeekCellTotalInterval = (int) this.mRes.getDimension(R.dimen.monthweek_grid_bg_interval_width);
        MINI_DAY_NUMBER_TEXT_SIZE = this.mRes.getDimensionPixelSize(R.dimen.text_size_month_number);
        float r0 = mScale;
        if (r0 == 1.0f) goto L7;
        EXPANDED_HEIGHT = (int) (EXPANDED_HEIGHT * r0);
        EXPANDED_WIDTH = (int) (EXPANDED_WIDTH * r0);
        SPACING_WEEK_NUMBER = (int) (SPACING_WEEK_NUMBER * r0);
        DAY_SEPARATOR_INNER_WIDTH = (int) (DAY_SEPARATOR_INNER_WIDTH * r0);
        DEFAULT_EDGE_SPACING = (int) (DEFAULT_EDGE_SPACING * r0);
        TODAY_HIGHLIGHT_WIDTH = (int) (TODAY_HIGHLIGHT_WIDTH * r0);
    L7:
        mInitialized = true;
    L8:
        this.mCellWidth = (int) this.mRes.getDimension(R.dimen.monthweek_item_width);
        this.p.setFakeBoldText(false);
        this.p.setAntiAlias(true);
        this.p.setTextSize(MINI_DAY_NUMBER_TEXT_SIZE);
        this.p.setStyle(Paint.Style.FILL);
        this.mPadding = DEFAULT_EDGE_SPACING;
        loadColors(getContext());
    }

    public void setWeekParams(HashMap<String, Integer> params, String tz) {
        if (params.containsKey(VIEW_PARAMS_WEEK) == false) goto L83;
        setTag(params);
        this.mTimeZone = tz;
        if (params.containsKey(VIEW_PARAMS_SINGLE_WEEK) == true) goto L7;
    L9:
        this.mIsSingleWeek = false;
    L11:
        if (this.mIsSingleWeek == false) goto L13;
        this.mHeight = MonthByWeekAdapter.mItemSingleHeight;
    L15:
        if (params.containsKey("selected_day") == false) goto L17;
        this.mSelectedWeekDay = params.get("selected_day").intValue();
    L17:
        int r2 = -1;
        if (this.mSelectedWeekDay == (-1)) goto L20;
        boolean r1 = true;
    L21:
        this.mHasSelectedDay = r1;
        if (params.containsKey(VIEW_PARAMS_NUM_DAYS) == false) goto L24;
        this.mNumDays = params.get(VIEW_PARAMS_NUM_DAYS).intValue();
    L24:
        int r3 = this.mNumDays;
        this.mNumCells = r3;
        this.mDayNumbers = new String[r3];
        this.mFocusDay = new boolean[r3];
        int r0 = params.get(VIEW_PARAMS_WEEK).intValue();
        this.mWeek = r0;
        int r4 = CalendarUtils.getJulianMondayFromWeeksSinceEpoch(r0);
        Time r5 = new Time("Asia/Shanghai");
        r5.setJulianDay(r4);
        if (params.containsKey("week_start") == false) goto L28;
        this.mWeekStart = params.get("week_start").intValue();
    L28:
        if (params.containsKey(VIEW_PARAMS_MAX_JULIANDAY) == false) goto L30;
        this.mMaxJulianDay = params.get(VIEW_PARAMS_MAX_JULIANDAY).intValue();
    L32:
        if (params.containsKey(VIEW_PARAMS_MIN_JULIANDAY) == false) goto L34;
        this.mMinJulianDay = params.get(VIEW_PARAMS_MIN_JULIANDAY).intValue();
    L35:
        CalendarUtils.adjustToBeginningOfWeek(r5, this.mWeekStart);
        this.mFirstJulianDay = Time.getJulianDay(r5.toMillis(true), r5.gmtoff);
        this.mFirstMonth = r5.month;
        Time r6 = new Time(tz);
        r6.setToNow();
        this.mHasToday = false;
        this.mToday = -1;
        if (params.containsKey("focus_month") == false) goto L38;
        r2 = params.get("focus_month").intValue();
    L38:
        this.mIsDayOutOfRange = null;
        this.mIsTodayBefore = null;
        int r10 = 0;
    L40:
        if (r10 >= this.mNumCells) goto L78;
        if (r5.monthDay != 1) goto L45;
        this.mFirstMonth = r5.month;
    L45:
        if (r5.month != r2) goto L47;
        this.mFocusDay[r10] = true;
    L48:
        if (r2 >= 0) goto L51;
        this.mFocusDay[r10] = true;
    L51:
        if (r5.year == r6.year) goto L53;
    L57:
        int r7 = this.mFirstJulianDay + r10;
        if (r7 > this.mMaxJulianDay) goto L62;
        if (r7 < this.mMinJulianDay) goto L62;
    L66:
        if (r5.year >= 1970) goto L68;
    L69:
        this.mFocusDay[r10] = false;
        if (this.mIsDayOutOfRange != null) goto L72;
        this.mIsDayOutOfRange = new boolean[this.mNumCells];
    L72:
        this.mIsDayOutOfRange[r10] = true;
    L73:
        this.mDayNumbers[r10] = Integer.toString(r5.monthDay);
        r5.monthDay++;
        if (r5.monthDay <= 28) goto L76;
        r5.normalize(true);
    L76:
        r10 = r10 + 1;
        goto L40
    L68:
        if (r5.year <= 2037) goto L73;
    L62:
        if (this.mIsTodayBefore != null) goto L64;
        this.mIsTodayBefore = new boolean[this.mNumCells];
    L64:
        this.mIsTodayBefore[r10] = true;
        goto L66
    L53:
        if (r5.month != r6.month) goto L57;
        if (r5.monthDay != r6.monthDay) goto L57;
        this.mHasToday = true;
        this.mToday = r10;
        goto L57
    L47:
        this.mFocusDay[r10] = false;
        goto L48
    L78:
        if (r5.monthDay != 1) goto L80;
        r5.monthDay--;
        r5.normalize(true);
    L80:
        this.mLastMonth = r5.month;
        updateSelectionPositions();
        updateToday(tz);
        this.mNumCells = this.mNumDays + 1;
        updatePercent();
        return;
    L34:
        this.mMinJulianDay = 0;
        goto L35
    L30:
        this.mMaxJulianDay = Integer.MAX_VALUE;
        goto L32
    L20:
        r1 = false;
        goto L21
    L13:
        this.mHeight = MonthByWeekAdapter.mItemHeight;
        goto L15
    L7:
        if (params.get(VIEW_PARAMS_SINGLE_WEEK).intValue() == 0) goto L9;
        this.mIsSingleWeek = true;
        goto L11
    L83:
        throw new InvalidParameterException("You must specify the week number for this view");
    }

    private boolean isBeforeDay(Time solar, Time today) {
        if (solar.year >= today.year) goto L6;
        return true;
    L6:
        if (solar.year != today.year) goto L11;
        if (solar.month >= today.month) goto L11;
        return true;
    L11:
        if (solar.year == today.year) goto L13;
        return false;
    L13:
        if (solar.month == today.month) goto L15;
        return false;
    L15:
        if (solar.monthDay >= today.monthDay) goto L20;
        return true;
    L20:
        return false;
    }

    public boolean isFocusDay(int dayOffset) {
        boolean[] r1 = this.mFocusDay;
        if (r1 == null) goto L9;
        if (dayOffset >= 0) goto L6;
        return false;
    L6:
        if (dayOffset < r1.length) goto L8;
        return false;
    L8:
        return r1[dayOffset];
    L9:
        return false;
    }

    public boolean isOutOfRangeDay(int dayOffset) {
        boolean[] r0 = this.mIsDayOutOfRange;
        if (r0 == null) goto L9;
        if (dayOffset >= 0) goto L6;
        return false;
    L6:
        if (dayOffset < this.mFocusDay.length) goto L8;
        return false;
    L8:
        return r0[dayOffset];
    L9:
        return false;
    }

    public boolean isDayNoValid(int dayOffset) {
        boolean[] r1 = this.mIsTodayBefore;
        if (r1 == null) goto L9;
        if (dayOffset >= 0) goto L6;
        return false;
    L6:
        if (dayOffset < r1.length) goto L8;
        return false;
    L8:
        return r1[dayOffset];
    L9:
        return false;
    }

    public int getFirstMonth() {
        return this.mFirstMonth;
    }

    public int getLastMonth() {
        return this.mLastMonth;
    }

    public int getFirstJulianDay() {
        return this.mFirstJulianDay;
    }

    public boolean updateToday(String tz) {
        this.mTimeToday.timezone = tz;
        this.mTimeToday.setToNow();
        this.mTimeToday.normalize(true);
        int r7 = Time.getJulianDay(this.mTimeToday.toMillis(false), this.mTimeToday.gmtoff);
        int r2 = this.mFirstJulianDay;
        if (r7 >= r2) goto L5;
    L7:
        this.mHasToday = false;
        this.mTodayIndex = -1;
    L9:
        return this.mHasToday;
    L5:
        if (r7 >= (this.mNumDays + r2)) goto L7;
        this.mHasToday = true;
        this.mTodayIndex = r7 - r2;
        goto L9
    }

    public boolean hasToday() {
        return this.mHasToday;
    }

    public void setHasFocus(boolean hasFocus) {
        this.hasFocus = hasFocus;
        if (hasFocus == true) goto L8;
        int r3 = 0;
    L5:
        boolean[] r0 = this.mFocusDay;
        if (r3 >= r0.length) goto L8;
        r0[r3] = true;
        r3 = r3 + 1;
    L8:
        setAllDrawerFocusState();
    }

    private void setAllDrawerFocusState() {
        setDrawerFocusState(this.mCellDrawer);
    }

    private void setDrawerFocusState(DayCellViewDrawer drawer) {
        if (drawer == null) goto L5;
        drawer.setHasFocus(this.hasFocus);
        return;
    }

    public boolean isHasFocus() {
        return this.hasFocus;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        drawBackground(canvas);
        drawWeekNums(canvas);
        if (this.hasFocus == true) goto L5;
        return;
    L5:
        if (this.mHasToday == true) goto L7;
        return;
    L7:
        if (this.mAnimateToday == false) goto L12;
        drawToday(canvas);
        return;
    }

    public int getmUndrawBackgoundIndex() {
        return this.mUndrawBackgoundIndex;
    }

    public void setmUndrawBackgoundIndex(int mUndrawBackgoundIndex) {
        this.mUndrawBackgoundIndex = mUndrawBackgoundIndex;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.mWidth = w;
        updateSelectionPositions();
    }

    protected void drawToday(Canvas canvas) {
        this.r.top = DAY_SEPARATOR_INNER_WIDTH + (TODAY_HIGHLIGHT_WIDTH / 2);
        this.r.bottom = this.mHeight - ((int) Math.ceil(TODAY_HIGHLIGHT_WIDTH / 2.0f));
        this.p.setStyle(Paint.Style.STROKE);
        this.p.setStrokeWidth(TODAY_HIGHLIGHT_WIDTH);
        this.r.left = computeDayLeftPosition(this.mTodayIndex) + (TODAY_HIGHLIGHT_WIDTH / 2);
        this.r.right = computeDayLeftPosition(this.mTodayIndex + 1) - ((int) Math.ceil(TODAY_HIGHLIGHT_WIDTH / 2.0f));
        this.p.setColor(this.mTodayAnimateColor | (this.mAnimateTodayAlpha << 24));
        canvas.drawRect(this.r, this.p);
        this.p.setStyle(Paint.Style.FILL);
    }

    private int computeDayLeftPosition(int day) {
        return Math.round((day * this.mCellWidth) + 0);
    }

    protected void drawBackground(Canvas canvas) {
        drawBasicBackgound(canvas);
        if (this.hasFocus == false) goto L6;
        drawSpecificBackground(canvas);
        return;
    }

    private void drawSpecificBackground(Canvas canvas) {
        int r0 = this.mSelectedWeekDay - this.mWeekStart;
        if (r0 >= 0) goto L5;
        r0 = r0 + 7;
    L5:
        Rect r1 = new Rect();
        r1.top = (int) (-sBgMarginV);
        r1.bottom = (int) (this.mHeight + sBgMarginV);
        int r2 = 0;
    L7:
        if (r2 >= this.mNumDays) goto L26;
        if (r2 == this.mUndrawBackgoundIndex) goto L24;
        boolean[] r3 = this.mFocusDay;
        if (r3 != null) goto L14;
    L19:
        boolean[] r4 = this.mIsTodayBefore;
        if (r4 == null) goto L24;
        if (r4[r2] == false) goto L24;
        this.r.left = computeDayLeftPosition(r2);
        this.r.right = computeDayLeftPosition(r2 + 1);
        this.mMonthBGNotFocusDrawable.setBounds(this.r);
        this.mMonthBGNotFocusDrawable.draw(canvas);
        goto L24
    L14:
        if (r3[r2] == true) goto L19;
        this.r.left = computeDayLeftPosition(r2);
        this.r.right = computeDayLeftPosition(r2 + 1);
        this.mMonthBGNotFocusDrawable.setBounds(this.r);
        if (isOutOfRangeDay(r2) == true) goto L18;
        this.mMonthBGNotFocusDrawable.setAlpha((int) ((1.0f - this.mSwitchAnimProgress) * 255.0f));
    L18:
        this.mMonthBGNotFocusDrawable.draw(canvas);
    L24:
        r2 = r2 + 1;
        goto L7
    L26:
        if (this.mHasToday == false) goto L36;
        int r5 = this.mTodayIndex;
        if (r5 == this.mUndrawBackgoundIndex) goto L36;
        r1.left = computeDayLeftPosition(r5) - sBgMarginH;
        r1.right = computeDayLeftPosition(this.mTodayIndex + 1) + sBgMarginH;
        if (this.mHasSelectedDay == true) goto L32;
    L34:
        this.mUnfocusTodayFullMonthBG.setBounds(r1);
        this.mUnfocusTodayFullMonthBG.draw(canvas);
        goto L36
    L32:
        if (r0 != this.mTodayIndex) goto L34;
        this.mTodayFullMonthBG.setBounds(r1);
        this.mTodayFullMonthBG.draw(canvas);
    L36:
        if (this.mHasSelectedDay == true) goto L38;
        return;
    L38:
        if (r0 != this.mUndrawBackgoundIndex) goto L40;
        return;
    L40:
        if (r0 == this.mTodayIndex) goto L50;
        r1.left = computeDayLeftPosition(r0) - sBgMarginH;
        r1.right = computeDayLeftPosition(r0 + 1) + sBgMarginH;
        this.mSelectedFullMonthBG.setBounds(r1);
        this.mSelectedFullMonthBG.draw(canvas);
        return;
    }

    private void drawBasicBackgound(Canvas canvas) {
        this.r.top = 0;
        Rect r0 = this.r;
        r0.bottom = this.mHeight;
        this.r.left = 0;
        Rect r1 = this.r;
        r1.right = this.mWidth + sBorderWidth;
        this.mMonthBGForDropDrawable.setBounds(this.r);
        this.mMonthBGForDropDrawable.draw(canvas);
        this.r.top = 0;
        Rect r5 = this.r;
        r5.bottom = this.mHeight + 1;
    }

    protected void drawWeekNums(Canvas canvas) {
        int r0 = this.mSelectedWeekDay - this.mWeekStart;
        if (r0 >= 0) goto L5;
        r0 = r0 + 7;
    L5:
        DayCellViewDrawer r9 = getDayCellViewDrawer();
        r9.setHasFocus(this.hasFocus);
        int r10 = 0;
    L7:
        if (r10 >= this.mNumDays) goto L37;
        String[] r1 = this.mDayNumbers;
        if (r1 == null) goto L36;
        if (r1[r10] == null) goto L36;
        int r2 = computeDayLeftPosition(r10 + 1);
        int r3 = DayCellViewDrawer.VIEW_TYPE_NORMAL;
        if (this.mFocusDay[r10] == true) goto L17;
        r3 = r3 | DayCellViewDrawer.VIEW_TYPE_NOT_FOCUS_MONTH;
    L17:
        if (isOutOfRangeDay(r10) == false) goto L20;
        r3 = r3 | DayCellViewDrawer.VIEW_TYPE_DAY_OUT_OF_RANGE;
    L20:
        if (this.mHasToday == false) goto L25;
        if (this.mTodayIndex != r10) goto L25;
        r3 = r3 | DayCellViewDrawer.VIEW_TYPE_TODAY;
    L25:
        if (this.mHasSelectedDay == false) goto L29;
        if (r0 != r10) goto L29;
        r3 = r3 | DayCellViewDrawer.VIEW_TYPE_SELECTED;
    L29:
        if (isDayNoValid(r10) == false) goto L31;
        r3 = r3 | DayCellViewDrawer.VIEW_TYPE_DAY_NO_VALID;
    L31:
        int r6 = r3;
        String[] r4 = this.mDayTexts;
        if (r4 != null) goto L34;
        String r5 = "";
    L35:
        r9.drawView(r2, this.mDayNumbers[r10], r5, 2, r6, canvas, this.mSwitchAnimProgress);
        goto L36
    L34:
        r5 = r4[r10];
    L36:
        r10 = r10 + 1;
        goto L7
    }

    public DayCellViewDrawer getDayCellViewDrawer() {
        if (this.mCellDrawer != null) goto L6;
        this.mCellDrawer = new MonthByWeekDayViewDrawer(this.mContext, this.hasFocus, this.mCellWidth);
    L6:
        return this.mCellDrawer;
    }

    private float getStringWidth(String text) {
        int r0 = text.length();
        float[] r1 = new float[r0];
        this.p.getTextWidths(text, r1);
        float r3 = 0.0f;
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L5;
        r3 = r3 + r1[r4];
        r4 = r4 + 1;
        goto L3
    L5:
        return r3;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), this.mHeight);
        this.mCellWidth = (View.MeasureSpec.getSize(widthMeasureSpec) + sBorderWidth) / 7.0f;
    }

    protected void updateSelectionPositions() {
        if (this.mHasSelectedDay == false) goto L9;
        int r0 = this.mSelectedWeekDay - this.mWeekStart;
        if (r0 >= 0) goto L7;
        r0 = r0 + 7;
    L7:
        int r1 = this.mWidth;
        int r2 = this.mPadding;
        int r3 = r1 - (r2 * 2);
        int r4 = SPACING_WEEK_NUMBER;
        int r5 = r3 - r4;
        int r6 = this.mNumDays;
        int r7 = ((r0 * r5) / r6) + r2;
        this.mSelectedLeft = r7;
        this.mSelectedLeft = r7 + r4;
        this.mSelectedRight = ((((r0 + 1) * r5) / r6) + r2) + r4;
        return;
    }

    public int getCellPosFromLocation(float x) {
        int r0 = this.mPadding;
        float r1 = r0;
        if (x >= r1) goto L5;
        return -1;
    L5:
        if (x <= (this.mWidth - r0)) goto L8;
        return -1;
    L8:
        return (int) ((x - r1) / this.mCellWidth);
    }

    public Time getDayFromLocation(float x) {
        int r3 = getCellPosFromLocation(x);
        if (r3 != (-1)) goto L6;
        return null;
    L6:
        int r0 = this.mFirstJulianDay + r3;
        Time r4 = new Time(this.mTimeZone);
        if (this.mWeek == 0) goto L9;
    L12:
        r4.setJulianDay(r0);
        r4.hour = 4;
        return r4;
    L9:
        if (r0 != 2440588) goto L12;
        r4.set(1, 0, CalendarUtils.MIN_CALENDAR_YEAR);
        r4.normalize(true);
        return r4;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void testSetClickedDay(float xLocation) {
        this.mClickedDayIndex = getCellPosFromLocation(xLocation);
    }

    public void testClearClickedDay() {
        this.mClickedDayIndex = -1;
    }

    private void updatePercent() {
        if (this.mIsInScaleAnimation == false) goto L6;
        this.mSwitchAnimProgress = (this.mHeight - MonthByWeekAdapter.mItemHeight) / (MonthByWeekAdapter.mItemSingleHeight - MonthByWeekAdapter.mItemHeight);
        return;
    L6:
        if (this.mIsSingleWeek == false) goto L8;
        this.mSwitchAnimProgress = 1.0f;
        return;
    L8:
        this.mSwitchAnimProgress = 0.0f;
    }

    public void setOriginalView(View view) {
        this.mOriginalView = view;
    }

    private void adjustAnimationBGRect(Rect rect) {
        int r0 = (int) (rect.width() * this.mAnimationValue);
        int r2 = (int) (rect.height() * this.mAnimationValue);
        rect.left -= r0;
        rect.right += r0;
        rect.top -= r2;
        rect.bottom += r2;
    }
}
