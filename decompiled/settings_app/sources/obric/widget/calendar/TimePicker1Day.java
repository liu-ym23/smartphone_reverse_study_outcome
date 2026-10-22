package obric.widget.calendar;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.FrameLayout;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class TimePicker1Day extends FrameLayout {
    private static final boolean DEFAULT_ENABLED_STATE = true;
    private static final int HOURS_IN_HALF_DAY = 12;
    private Button mAmPmButton;
    public View mAmPmDividerView;
    public NumberPicker1Day mAmPmSpinner;
    private String[] mAmPmStrings;
    private Locale mCurrentLocale;
    public NumberPicker1Day mHourSpinner;
    private boolean mIs24HourView;
    private boolean mIsAm;
    private boolean mIsEnabled;
    public NumberPicker1Day mMinuteSpinner;
    private Calendar mTempCalendar;

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        private final int mHour;
        private final int mMinute;

        /* synthetic */ SavedState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        /* synthetic */ SavedState(Parcelable r1, int r2, int r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        private SavedState(Parcelable superState, int hour, int minute) {
            super(superState);
            this.mHour = hour;
            this.mMinute = minute;
        }

        private SavedState(Parcel in) {
            super(in);
            this.mHour = in.readInt();
            this.mMinute = in.readInt();
        }

        public int getHour() {
            return this.mHour;
        }

        public int getMinute() {
            return this.mMinute;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.mHour);
            dest.writeInt(this.mMinute);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    static /* synthetic */ boolean access$000(TimePicker1Day r0) {
        return r0.mIsAm;
    }

    static /* synthetic */ boolean access$002(TimePicker1Day r0, boolean r1) {
        r0.mIsAm = r1;
        return r1;
    }

    static /* synthetic */ void access$100(TimePicker1Day r0) {
        r0.updateAmPmControl();
    }

    static /* synthetic */ void access$200(TimePicker1Day r0, int r1) {
        r0.onHourChanged(r1);
    }

    public TimePicker1Day(Context context) {
        this(context, null);
    }

    public TimePicker1Day(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimePicker1Day(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mIsEnabled = true;
        setCurrentLocale(Locale.getDefault());
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.remind_time_picker_1_day, this, true);
        Resources r9 = getResources();
        int r0 = r9.getColor(R.color.date_pick_normal_day_color);
        int r10 = r9.getColor(R.color.calander_date_pick_select_day_color_2);
        NumberPicker1Day r1 = (NumberPicker1Day) findViewById(R.id.hour);
        this.mHourSpinner = r1;
        r1.setTextSize(getResources().getDimensionPixelSize(R.dimen.no_year_picker_text_size), getResources().getDimensionPixelSize(R.dimen.no_year_picker_text_size_highlight));
        this.mHourSpinner.setTextColor(r0, r10);
        this.mHourSpinner.setOnValueChangedListener(new AnonymousClass1(this));
        this.mHourSpinner.setFormatter(new AnonymousClass2(this));
        NumberPicker1Day r2 = (NumberPicker1Day) findViewById(R.id.minute);
        this.mMinuteSpinner = r2;
        r2.setMinValue(0);
        this.mMinuteSpinner.setMaxValue(60);
        this.mMinuteSpinner.setWrapSelectorWheel(true);
        this.mMinuteSpinner.setFormatter(new AnonymousClass3(this));
        this.mMinuteSpinner.setTextSize(getResources().getDimensionPixelSize(R.dimen.no_year_picker_text_size), getResources().getDimensionPixelSize(R.dimen.no_year_picker_text_size_highlight));
        this.mMinuteSpinner.setTextColor(r0, r10);
        this.mAmPmStrings = new DateFormatSymbols().getAmPmStrings();
        this.mAmPmDividerView = findViewById(R.id.am_pm_divider);
        View r3 = findViewById(R.id.amPm);
        if ((r3 instanceof Button) == false) goto L5;
        this.mAmPmSpinner = null;
        Button r4 = (Button) r3;
        this.mAmPmButton = r4;
        r4.setOnClickListener(new AnonymousClass4(this));
    L6:
        onHourChanged(this.mHourSpinner.getValue());
        setIs24HourView(Boolean.valueOf(DateFormat.is24HourFormat(context)));
        updateHourControl();
        updateAmPmControl();
        if (isEnabled() == true) goto L10;
        setEnabled(false);
    L10:
        if (getResources().getInteger(R.integer.time_picker_wheel_item_count) != 5) goto L12;
        setBackgroundResource(R.drawable.remind_time_picker_widget_5_bg);
        return;
    L12:
        setBackgroundResource(R.drawable.remind_time_picker_widget_bg);
        return;
    L5:
        this.mAmPmButton = null;
        NumberPicker1Day r5 = (NumberPicker1Day) r3;
        this.mAmPmSpinner = r5;
        r5.setMinValue(0);
        this.mAmPmSpinner.setMaxValue(1);
        this.mAmPmSpinner.setDisplayedValues(this.mAmPmStrings);
        this.mAmPmSpinner.setOnValueChangedListener(new AnonymousClass5(this));
        this.mAmPmSpinner.setTextSize(getResources().getDimensionPixelSize(R.dimen.no_year_picker_text_size), getResources().getDimensionPixelSize(R.dimen.no_year_picker_text_size_highlight));
        this.mAmPmSpinner.setTextColor(r0, r10);
        goto L6
    }

    private void onHourChanged(int hour) {
        this.mMinuteSpinner.setMinValue(1);
        this.mMinuteSpinner.setWrapSelectorWheel(true);
        this.mMinuteSpinner.setEnabled(true);
        this.mHourSpinner.setWrapSelectorWheel(true);
    }

    public String[] getDisplayDate(Context mcContext, int julian, Time time) {
        int r2 = 0;
        int[] r0 = {julian - 2, julian - 1, julian, julian + 1, julian + 2};
        String[] r11 = new String[5];
    L3:
        if (r2 >= 5) goto L5;
        long r6 = time.setJulianDay(r0[r2]);
        r11[r2] = DateUtils.formatDateRange(mcContext, r6, r6, 16);
        r2 = r2 + 1;
        goto L3
    L5:
        return r11;
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        if (this.mIsEnabled != enabled) goto L5;
        return;
    L5:
        super.setEnabled(enabled);
        this.mMinuteSpinner.setEnabled(enabled);
        this.mHourSpinner.setEnabled(enabled);
        NumberPicker1Day r0 = this.mAmPmSpinner;
        if (r0 == null) goto L8;
        r0.setEnabled(enabled);
    L9:
        this.mIsEnabled = enabled;
        return;
    L8:
        this.mAmPmButton.setEnabled(enabled);
        goto L9
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setCurrentLocale(newConfig.locale);
    }

    private void setCurrentLocale(Locale locale) {
        if (locale.equals(this.mCurrentLocale) == false) goto L5;
        return;
    L5:
        this.mCurrentLocale = locale;
        this.mTempCalendar = Calendar.getInstance(locale);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getCurrentHour().intValue(), getCurrentMinute().intValue(), null);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        SavedState r2 = (SavedState) state;
        super.onRestoreInstanceState(r2.getSuperState());
        setCurrentHour(Integer.valueOf(r2.getHour()));
        setCurrentMinute(Integer.valueOf(r2.getMinute()));
    }

    public Integer getCurrentHour() {
        int r0 = this.mHourSpinner.getValue();
        if (is24HourView() == false) goto L7;
        return Integer.valueOf(r0);
    L7:
        if (this.mIsAm == false) goto L11;
        return Integer.valueOf(r0 % 12);
    L11:
        return Integer.valueOf((r0 % 12) + 12);
    }

    public void setCurrentHour(Integer currentHour) {
        Log.d("setTime", "setCurrentHour currentHour:" + currentHour);
        if (currentHour != null) goto L5;
        return;
    L5:
        if (currentHour.equals(getCurrentHour()) == false) goto L8;
        return;
    L8:
        if (is24HourView() == false) goto L10;
    L18:
        this.mHourSpinner.setValue(currentHour.intValue());
        onHourChanged(this.mHourSpinner.getValue());
        return;
    L10:
        if (currentHour.intValue() < 12) goto L14;
        this.mIsAm = false;
        if (currentHour.intValue() <= 12) goto L17;
        currentHour = Integer.valueOf(currentHour.intValue() - 12);
    L17:
        updateAmPmControl();
        goto L18
    L14:
        this.mIsAm = true;
        if (currentHour.intValue() != 0) goto L17;
        currentHour = 12;
        goto L17
    }

    public void setIs24HourView(Boolean is24HourView) {
        if (this.mIs24HourView != is24HourView.booleanValue()) goto L5;
        return;
    L5:
        this.mIs24HourView = is24HourView.booleanValue();
        int r3 = getCurrentHour().intValue();
        updateHourControl();
        setCurrentHour(Integer.valueOf(r3));
        updateAmPmControl();
    }

    public boolean is24HourView() {
        return this.mIs24HourView;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.mMinuteSpinner.getValue() - 1);
    }

    public void setCurrentMinute(Integer currentMinute) {
        Log.d("setTime", "setCurrentMinute currentMinute:" + currentMinute);
        if (currentMinute != null) goto L5;
        return;
    L5:
        if (currentMinute.equals(getCurrentMinute()) == true) goto L10;
        this.mMinuteSpinner.setValue(currentMinute.intValue() + 1);
        return;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.mHourSpinner.getBaseline();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        onPopulateAccessibilityEvent(event);
        return true;
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
        if (this.mIs24HourView == false) goto L5;
        int r0 = 129;
    L6:
        this.mTempCalendar.set(11, getCurrentHour().intValue());
        this.mTempCalendar.set(12, getCurrentMinute().intValue());
        String r4 = DateUtils.formatDateTime(getContext(), this.mTempCalendar.getTimeInMillis(), r0);
        event.getText().add(r4);
        return;
    L5:
        r0 = 65;
        goto L6
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setClassName(TimePicker1Day.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(TimePicker1Day.class.getName());
    }

    private void updateHourControl() {
        if (is24HourView() == false) goto L5;
        this.mHourSpinner.setWrapSelectorWheel(true);
        this.mHourSpinner.setMinValue(0);
        this.mHourSpinner.setMaxValue(23);
        return;
    L5:
        this.mHourSpinner.setWrapSelectorWheel(true);
        this.mHourSpinner.setMinValue(1);
        this.mHourSpinner.setMaxValue(12);
    }

    private void updateAmPmControl() {
        if (is24HourView() == false) goto L8;
        this.mAmPmDividerView.setVisibility(8);
        NumberPicker1Day r0 = this.mAmPmSpinner;
        if (r0 == null) goto L7;
        r0.setVisibility(8);
    L12:
        sendAccessibilityEvent(4);
        return;
    L7:
        this.mAmPmButton.setVisibility(8);
        goto L12
    L8:
        int r1 = !this.mIsAm ? 1 : 0;
        this.mAmPmDividerView.setVisibility(0);
        NumberPicker1Day r2 = this.mAmPmSpinner;
        if (r2 == null) goto L11;
        r2.setValue(r1);
        this.mAmPmSpinner.setVisibility(0);
        goto L12
    L11:
        this.mAmPmButton.setText(this.mAmPmStrings[r1]);
        this.mAmPmButton.setVisibility(0);
        goto L12
    }
}
