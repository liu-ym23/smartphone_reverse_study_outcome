package com.google.android.material.timepicker;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
class TimePickerClockPresenter implements ClockHandView.OnRotateListener, TimePickerView.OnSelectionChange, TimePickerView.OnPeriodChangeListener, ClockHandView.OnActionUpListener, TimePickerPresenter {
    private static final int DEGREES_PER_HOUR = 30;
    private static final int DEGREES_PER_MINUTE = 6;
    private static final String[] HOUR_CLOCK_24_VALUES = null;
    private static final String[] HOUR_CLOCK_VALUES = null;
    private static final String[] MINUTE_CLOCK_VALUES = null;
    private boolean broadcasting;
    private float hourRotation;
    private float minuteRotation;
    private TimeModel time;
    private TimePickerView timePickerView;

    static {
        HOUR_CLOCK_VALUES = new String[]{"12", LocationInfoConst.ALLOW_USE_LOCATION, "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        HOUR_CLOCK_24_VALUES = new String[]{"00", "2", "4", "6", "8", "10", "12", "14", "16", "18", "20", BDLocationException.ERROR_AMAP_FAIL};
        MINUTE_CLOCK_VALUES = new String[]{"00", "5", "10", "15", "20", "25", BDLocationException.ERROR_SDK_NO_PERMISSION, "35", BDLocationException.ERROR_MULTI_THREAD_LOCATE, "45", BDLocationException.ERROR_BYTE_SCAN_RESULT_IS_EMPTY, "55"};
    }

    public TimePickerClockPresenter(TimePickerView r2, TimeModel r3) {
        this.broadcasting = false;
        this.timePickerView = r2;
        this.time = r3;
        initialize();
    }

    private int getDegreesPerHour() {
        if (this.time.format != 1) goto L5;
        return 15;
    L5:
        return 30;
    }

    private String[] getHourClockValues() {
        if (this.time.format != 1) goto L6;
        return HOUR_CLOCK_24_VALUES;
    L6:
        return HOUR_CLOCK_VALUES;
    }

    private void performHapticFeedback(int r3, int r4) {
        TimeModel r0 = this.time;
        if (r0.minute != r4) goto L7;
        if (r0.hour != r3) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L9;
        int r5 = 4;
    L10:
        this.timePickerView.performHapticFeedback(r5);
        return;
    L9:
        r5 = 1;
        goto L10
    }

    private void updateTime() {
        TimePickerView r0 = this.timePickerView;
        TimeModel r1 = this.time;
        r0.updateTime(r1.period, r1.getHourForDisplay(), this.time.minute);
    }

    private void updateValues() {
        updateValues(HOUR_CLOCK_VALUES, TimeModel.NUMBER_FORMAT);
        updateValues(HOUR_CLOCK_24_VALUES, TimeModel.NUMBER_FORMAT);
        updateValues(MINUTE_CLOCK_VALUES, TimeModel.ZERO_LEADING_NUMBER_FORMAT);
    }

    private void updateValues(String[] r4, String r5) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r4[r0] = TimeModel.formatText(this.timePickerView.getResources(), r4[r0], r5);
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void hide() {
        this.timePickerView.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void initialize() {
        if (this.time.format != 0) goto L5;
        this.timePickerView.showToggle();
    L5:
        this.timePickerView.addOnRotateListener(this);
        this.timePickerView.setOnSelectionChangeListener(this);
        this.timePickerView.setOnPeriodChangeListener(this);
        this.timePickerView.setOnActionUpListener(this);
        updateValues();
        invalidate();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void invalidate() {
        this.hourRotation = this.time.getHourForDisplay() * getDegreesPerHour();
        TimeModel r0 = this.time;
        this.minuteRotation = r0.minute * 6;
        setSelection(r0.selection, false);
        updateTime();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnActionUpListener
    public void onActionUp(float r7, boolean r8) {
        this.broadcasting = true;
        TimeModel r1 = this.time;
        int r2 = r1.minute;
        int r3 = r1.hour;
        if (r1.selection != 10) goto L7;
        this.timePickerView.setHandRotation(this.hourRotation, false);
        if (((AccessibilityManager) ContextCompat.getSystemService(this.timePickerView.getContext(), AccessibilityManager.class)).isTouchExplorationEnabled() == true) goto L11;
        setSelection(12, true);
    L11:
        this.broadcasting = false;
        updateTime();
        performHapticFeedback(r3, r2);
        return;
    L7:
        int r9 = Math.round(r7);
        if (r8 == true) goto L10;
        this.time.setMinute(((r9 + 15) / 30) * 5);
        this.minuteRotation = this.time.minute * 6;
    L10:
        this.timePickerView.setHandRotation(this.minuteRotation, r8);
        goto L11
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnPeriodChangeListener
    public void onPeriodChange(int r1) {
        this.time.setPeriod(r1);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void onRotate(float r6, boolean r7) {
        if (this.broadcasting == false) goto L5;
        return;
    L5:
        TimeModel r0 = this.time;
        int r1 = r0.hour;
        int r2 = r0.minute;
        int r8 = Math.round(r6);
        TimeModel r3 = this.time;
        if (r3.selection != 12) goto L8;
        r3.setMinute((r8 + 3) / 6);
        this.minuteRotation = (float) Math.floor(this.time.minute * 6);
    L9:
        if (r7 == true) goto L12;
        updateTime();
        performHapticFeedback(r1, r2);
        return;
    L12:
        return;
    L8:
        this.time.setHour((r8 + (getDegreesPerHour() / 2)) / getDegreesPerHour());
        this.hourRotation = this.time.getHourForDisplay() * getDegreesPerHour();
        goto L9
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnSelectionChange
    public void onSelectionChanged(int r2) {
        setSelection(r2, true);
    }

    void setSelection(int r5, boolean r6) {
        if (r5 != 12) goto L5;
        boolean r0 = true;
    L6:
        this.timePickerView.setAnimateOnTouchUp(r0);
        this.time.selection = r5;
        TimePickerView r1 = this.timePickerView;
        if (r0 == false) goto L9;
        String[] r2 = MINUTE_CLOCK_VALUES;
    L10:
        if (r0 == false) goto L12;
        int r3 = R.string.material_minute_suffix;
    L13:
        r1.setValues(r2, r3);
        TimePickerView r4 = this.timePickerView;
        if (r0 == false) goto L16;
        float r7 = this.minuteRotation;
    L17:
        r4.setHandRotation(r7, r6);
        this.timePickerView.setActiveSelection(r5);
        this.timePickerView.setMinuteHourDelegate(new ClickActionDelegate(this.timePickerView.getContext(), R.string.material_hour_selection));
        this.timePickerView.setHourClickDelegate(new ClickActionDelegate(this.timePickerView.getContext(), R.string.material_minute_selection));
        return;
    L16:
        r7 = this.hourRotation;
        goto L17
    L12:
        r3 = R.string.material_hour_suffix;
        goto L13
    L9:
        r2 = getHourClockValues();
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void show() {
        this.timePickerView.setVisibility(0);
    }
}
