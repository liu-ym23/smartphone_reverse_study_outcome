package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class TimePickerView extends ConstraintLayout implements TimePickerControls {
    private final ClockFaceView clockFace;
    private final ClockHandView clockHandView;
    private final Chip hourView;
    private final Chip minuteView;
    private OnDoubleTapListener onDoubleTapListener;
    private OnPeriodChangeListener onPeriodChangeListener;
    private OnSelectionChange onSelectionChangeListener;
    private final View.OnClickListener selectionListener;
    private final MaterialButtonToggleGroup toggle;

    interface OnDoubleTapListener {
        void onDoubleTap();
    }

    interface OnPeriodChangeListener {
        void onPeriodChange(int r1);
    }

    interface OnSelectionChange {
        void onSelectionChanged(int r1);
    }

    public TimePickerView(Context r2) {
        this(r2, null);
    }

    public TimePickerView(Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, 0);
    }

    public TimePickerView(Context r1, @Nullable AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.selectionListener = new AnonymousClass1(this);
        LayoutInflater.from(r1).inflate(R.layout.material_timepicker, this);
        this.clockFace = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup r4 = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.toggle = r4;
        r4.addOnButtonCheckedListener(new AnonymousClass2(this));
        Chip r5 = (Chip) findViewById(R.id.material_minute_tv);
        this.minuteView = r5;
        Chip r6 = (Chip) findViewById(R.id.material_hour_tv);
        this.hourView = r6;
        this.clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        ViewCompat.setAccessibilityLiveRegion(r5, 2);
        ViewCompat.setAccessibilityLiveRegion(r6, 2);
        setupDoubleTap();
        setUpDisplay();
    }

    static /* synthetic */ OnSelectionChange access$000(TimePickerView r0) {
        return r0.onSelectionChangeListener;
    }

    static /* synthetic */ OnPeriodChangeListener access$100(TimePickerView r0) {
        return r0.onPeriodChangeListener;
    }

    static /* synthetic */ OnDoubleTapListener access$200(TimePickerView r0) {
        return r0.onDoubleTapListener;
    }

    private void setUpDisplay() {
        Chip r0 = this.minuteView;
        int r1 = R.id.selection_type;
        r0.setTag(r1, 12);
        this.hourView.setTag(r1, 10);
        this.minuteView.setOnClickListener(this.selectionListener);
        this.hourView.setOnClickListener(this.selectionListener);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setupDoubleTap() {
        final GestureDetector r0 = new GestureDetector(getContext(), new AnonymousClass3(this));
        View.OnTouchListener r1 = new AnonymousClass4(this, r0);
        this.minuteView.setOnTouchListener(r1);
        this.hourView.setOnTouchListener(r1);
    }

    private void updateToggleConstraints() {
        if (this.toggle.getVisibility() != 0) goto L12;
        ConstraintSet r0 = new ConstraintSet();
        r0.clone(this);
        int r2 = 1;
        if (ViewCompat.getLayoutDirection(this) != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
        r2 = 2;
    L10:
        r0.clear(R.id.material_clock_display, r2);
        r0.applyTo(this);
        return;
    L7:
        r1 = false;
        goto L8
    }

    public void addOnRotateListener(ClockHandView.OnRotateListener r1) {
        this.clockHandView.addOnRotateListener(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateToggleConstraints();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View r1, int r2) {
        super.onVisibilityChanged(r1, r2);
        if (r1 != this) goto L7;
        if (r2 != 0) goto L8;
        updateToggleConstraints();
        return;
    L8:
        return;
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public void setActiveSelection(int r5) {
        Chip r0 = this.minuteView;
        boolean r1 = true;
        if (r5 != 12) goto L5;
        boolean r3 = true;
    L6:
        r0.setChecked(r3);
        Chip r4 = this.hourView;
        if (r5 == 10) goto L10;
        r1 = false;
    L10:
        r4.setChecked(r1);
        return;
    L5:
        r3 = false;
        goto L6
    }

    public void setAnimateOnTouchUp(boolean r1) {
        this.clockHandView.setAnimateOnTouchUp(r1);
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public void setHandRotation(float r1) {
        this.clockHandView.setHandRotation(r1);
    }

    public void setHandRotation(float r1, boolean r2) {
        this.clockHandView.setHandRotation(r1, r2);
    }

    public void setHourClickDelegate(AccessibilityDelegateCompat r1) {
        ViewCompat.setAccessibilityDelegate(this.minuteView, r1);
    }

    public void setMinuteHourDelegate(AccessibilityDelegateCompat r1) {
        ViewCompat.setAccessibilityDelegate(this.hourView, r1);
    }

    public void setOnActionUpListener(ClockHandView.OnActionUpListener r1) {
        this.clockHandView.setOnActionUpListener(r1);
    }

    void setOnDoubleTapListener(@Nullable OnDoubleTapListener r1) {
        this.onDoubleTapListener = r1;
    }

    void setOnPeriodChangeListener(OnPeriodChangeListener r1) {
        this.onPeriodChangeListener = r1;
    }

    void setOnSelectionChangeListener(OnSelectionChange r1) {
        this.onSelectionChangeListener = r1;
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public void setValues(String[] r1, @StringRes int r2) {
        this.clockFace.setValues(r1, r2);
    }

    public void showToggle() {
        this.toggle.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    @SuppressLint({"DefaultLocale"})
    public void updateTime(int r4, int r5, int r6) {
        if (r4 != 1) goto L5;
        int r7 = R.id.material_clock_period_pm_button;
    L6:
        this.toggle.check(r7);
        Locale r8 = getResources().getConfiguration().locale;
        String r1 = String.format(r8, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r6)});
        String r9 = String.format(r8, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r5)});
        this.minuteView.setText(r1);
        this.hourView.setText(r9);
        return;
    L5:
        r7 = R.id.material_clock_period_am_button;
        goto L6
    }
}
