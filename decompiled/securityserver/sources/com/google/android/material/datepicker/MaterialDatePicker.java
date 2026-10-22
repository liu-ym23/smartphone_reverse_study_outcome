package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    static final Object CANCEL_BUTTON_TAG = null;
    static final Object CONFIRM_BUTTON_TAG = null;
    private static final String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
    public static final int INPUT_MODE_CALENDAR = 0;
    private static final String INPUT_MODE_KEY = "INPUT_MODE_KEY";
    public static final int INPUT_MODE_TEXT = 1;
    private static final String OVERRIDE_THEME_RES_ID = "OVERRIDE_THEME_RES_ID";
    private static final String TITLE_TEXT_KEY = "TITLE_TEXT_KEY";
    private static final String TITLE_TEXT_RES_ID_KEY = "TITLE_TEXT_RES_ID_KEY";
    static final Object TOGGLE_BUTTON_TAG = null;

    @Nullable
    private MaterialShapeDrawable background;
    private MaterialCalendar<S> calendar;

    @Nullable
    private CalendarConstraints calendarConstraints;
    private Button confirmButton;

    @Nullable
    private DateSelector<S> dateSelector;
    private boolean fullscreen;
    private TextView headerSelectionText;
    private CheckableImageButton headerToggleButton;
    private int inputMode;
    private final LinkedHashSet<DialogInterface.OnCancelListener> onCancelListeners;
    private final LinkedHashSet<DialogInterface.OnDismissListener> onDismissListeners;
    private final LinkedHashSet<View.OnClickListener> onNegativeButtonClickListeners;
    private final LinkedHashSet<MaterialPickerOnPositiveButtonClickListener<? super S>> onPositiveButtonClickListeners;

    @StyleRes
    private int overrideThemeResId;
    private PickerFragment<S> pickerFragment;
    private CharSequence titleText;

    @StringRes
    private int titleTextResId;

    public static final class Builder<S> {
        CalendarConstraints calendarConstraints;
        final DateSelector<S> dateSelector;
        int inputMode;
        int overrideThemeResId;

        @Nullable
        S selection;
        CharSequence titleText;
        int titleTextResId;

        private Builder(DateSelector<S> r3) {
            this.overrideThemeResId = 0;
            this.titleTextResId = 0;
            this.titleText = null;
            this.selection = null;
            this.inputMode = 0;
            this.dateSelector = r3;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static <S> Builder<S> customDatePicker(@NonNull DateSelector<S> r1) {
            return new Builder(r1);
        }

        @NonNull
        public static Builder<Long> datePicker() {
            return new Builder(new SingleDateSelector());
        }

        @NonNull
        public static Builder<Pair<Long, Long>> dateRangePicker() {
            return new Builder(new RangeDateSelector());
        }

        @NonNull
        public MaterialDatePicker<S> build() {
            if (this.calendarConstraints != null) goto L6;
            this.calendarConstraints = new CalendarConstraints.Builder().build();
        L6:
            if (this.titleTextResId != 0) goto L8;
            this.titleTextResId = this.dateSelector.getDefaultTitleResId();
        L8:
            S r0 = this.selection;
            if (r0 == null) goto L12;
            this.dateSelector.setSelection(r0);
        L12:
            return MaterialDatePicker.newInstance(this);
        }

        @NonNull
        public Builder<S> setCalendarConstraints(CalendarConstraints r1) {
            this.calendarConstraints = r1;
            return this;
        }

        @NonNull
        public Builder<S> setInputMode(int r1) {
            this.inputMode = r1;
            return this;
        }

        @NonNull
        public Builder<S> setSelection(S r1) {
            this.selection = r1;
            return this;
        }

        @NonNull
        public Builder<S> setTheme(@StyleRes int r1) {
            this.overrideThemeResId = r1;
            return this;
        }

        @NonNull
        public Builder<S> setTitleText(@StringRes int r1) {
            this.titleTextResId = r1;
            this.titleText = null;
            return this;
        }

        @NonNull
        public Builder<S> setTitleText(@Nullable CharSequence r1) {
            this.titleText = r1;
            this.titleTextResId = 0;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface InputMode {
    }

    static {
        CONFIRM_BUTTON_TAG = "CONFIRM_BUTTON_TAG";
        CANCEL_BUTTON_TAG = "CANCEL_BUTTON_TAG";
        TOGGLE_BUTTON_TAG = "TOGGLE_BUTTON_TAG";
    }

    public MaterialDatePicker() {
        this.onPositiveButtonClickListeners = new LinkedHashSet();
        this.onNegativeButtonClickListeners = new LinkedHashSet();
        this.onCancelListeners = new LinkedHashSet();
        this.onDismissListeners = new LinkedHashSet();
    }

    public static /* synthetic */ LinkedHashSet access$000(MaterialDatePicker r0) {
        return r0.onPositiveButtonClickListeners;
    }

    public static /* synthetic */ LinkedHashSet access$100(MaterialDatePicker r0) {
        return r0.onNegativeButtonClickListeners;
    }

    public static /* synthetic */ void access$200(MaterialDatePicker r0) {
        r0.updateHeader();
    }

    public static /* synthetic */ DateSelector access$300(MaterialDatePicker r0) {
        return r0.dateSelector;
    }

    public static /* synthetic */ Button access$400(MaterialDatePicker r0) {
        return r0.confirmButton;
    }

    public static /* synthetic */ CheckableImageButton access$500(MaterialDatePicker r0) {
        return r0.headerToggleButton;
    }

    public static /* synthetic */ void access$600(MaterialDatePicker r0, CheckableImageButton r1) {
        r0.updateToggleContentDescription(r1);
    }

    public static /* synthetic */ void access$700(MaterialDatePicker r0) {
        r0.startPickerFragment();
    }

    @NonNull
    private static Drawable createHeaderToggleDrawable(Context r3) {
        StateListDrawable r0 = new StateListDrawable();
        r0.addState(new int[]{R.attr.state_checked}, AppCompatResources.getDrawable(r3, com.google.android.material.R.drawable.material_ic_calendar_black_24dp));
        r0.addState(new int[0], AppCompatResources.getDrawable(r3, com.google.android.material.R.drawable.material_ic_edit_black_24dp));
        return r0;
    }

    private static int getDialogPickerHeight(@NonNull Context r5) {
        Resources r6 = r5.getResources();
        int r0 = r6.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_navigation_bottom_padding) + (r6.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_navigation_top_padding) + r6.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_navigation_height));
        int r1 = r6.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_days_of_week_height);
        int r2 = MonthAdapter.MAXIMUM_WEEKS;
        return ((r0 + r1) + ((r6.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_month_vertical_padding) * (r2 - 1)) + (r6.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_day_height) * r2))) + r6.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_bottom_padding);
    }

    private static int getPaddedPickerWidth(@NonNull Context r4) {
        Resources r5 = r4.getResources();
        int r0 = r5.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_content_padding);
        int r1 = Month.current().daysInWeek;
        int r2 = r5.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_day_width) * r1;
        return ((r1 - 1) * r5.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_month_horizontal_padding)) + (r2 + (r0 * 2));
    }

    private int getThemeResId(Context r2) {
        int r0 = this.overrideThemeResId;
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return this.dateSelector.getDefaultThemeResId(r2);
    }

    private void initHeaderToggle(Context r3) {
        this.headerToggleButton.setTag(TOGGLE_BUTTON_TAG);
        this.headerToggleButton.setImageDrawable(createHeaderToggleDrawable(r3));
        CheckableImageButton r4 = this.headerToggleButton;
        if (this.inputMode == 0) goto L5;
        boolean r0 = true;
    L6:
        r4.setChecked(r0);
        ViewCompat.setAccessibilityDelegate(this.headerToggleButton, null);
        updateToggleContentDescription(this.headerToggleButton);
        this.headerToggleButton.setOnClickListener(new AnonymousClass4(this));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static boolean isFullscreen(@NonNull Context r2) {
        TypedArray r3 = r2.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(r2, com.google.android.material.R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{R.attr.windowFullscreen});
        boolean r0 = r3.getBoolean(0, false);
        r3.recycle();
        return r0;
    }

    @NonNull
    public static <S> MaterialDatePicker<S> newInstance(@NonNull Builder<S> r4) {
        MaterialDatePicker<S> r0 = new MaterialDatePicker();
        Bundle r1 = new Bundle();
        r1.putInt(OVERRIDE_THEME_RES_ID, r4.overrideThemeResId);
        r1.putParcelable(DATE_SELECTOR_KEY, r4.dateSelector);
        r1.putParcelable(CALENDAR_CONSTRAINTS_KEY, r4.calendarConstraints);
        r1.putInt(TITLE_TEXT_RES_ID_KEY, r4.titleTextResId);
        r1.putCharSequence(TITLE_TEXT_KEY, r4.titleText);
        r1.putInt(INPUT_MODE_KEY, r4.inputMode);
        r0.setArguments(r1);
        return r0;
    }

    private void startPickerFragment() {
        this.calendar = MaterialCalendar.newInstance(this.dateSelector, getThemeResId(requireContext()), this.calendarConstraints);
        if (this.headerToggleButton.isChecked() == false) goto L5;
        PickerFragment<S> r0 = MaterialTextInputPicker.newInstance(this.dateSelector, this.calendarConstraints);
    L6:
        this.pickerFragment = r0;
        updateHeader();
        FragmentTransaction r1 = getChildFragmentManager().beginTransaction();
        r1.replace(com.google.android.material.R.id.mtrl_calendar_frame, this.pickerFragment);
        r1.commitNow();
        this.pickerFragment.addOnSelectionChangedListener(new AnonymousClass3(this));
        return;
    L5:
        r0 = this.calendar;
        goto L6
    }

    public static long thisMonthInUtcMilliseconds() {
        return Month.current().timeInMillis;
    }

    public static long todayInUtcMilliseconds() {
        return UtcDates.getTodayCalendar().getTimeInMillis();
    }

    private void updateHeader() {
        String r0 = getHeaderText();
        this.headerSelectionText.setContentDescription(String.format(getString(com.google.android.material.R.string.mtrl_picker_announce_current_selection), new Object[]{r0}));
        this.headerSelectionText.setText(r0);
    }

    private void updateToggleContentDescription(@NonNull CheckableImageButton r2) {
        if (this.headerToggleButton.isChecked() == false) goto L5;
        String r3 = r2.getContext().getString(com.google.android.material.R.string.mtrl_picker_toggle_to_calendar_input_mode);
    L6:
        this.headerToggleButton.setContentDescription(r3);
        return;
    L5:
        r3 = r2.getContext().getString(com.google.android.material.R.string.mtrl_picker_toggle_to_text_input_mode);
        goto L6
    }

    public boolean addOnCancelListener(DialogInterface.OnCancelListener r1) {
        return this.onCancelListeners.add(r1);
    }

    public boolean addOnDismissListener(DialogInterface.OnDismissListener r1) {
        return this.onDismissListeners.add(r1);
    }

    public boolean addOnNegativeButtonClickListener(View.OnClickListener r1) {
        return this.onNegativeButtonClickListeners.add(r1);
    }

    public boolean addOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> r1) {
        return this.onPositiveButtonClickListeners.add(r1);
    }

    public void clearOnCancelListeners() {
        this.onCancelListeners.clear();
    }

    public void clearOnDismissListeners() {
        this.onDismissListeners.clear();
    }

    public void clearOnNegativeButtonClickListeners() {
        this.onNegativeButtonClickListeners.clear();
    }

    public void clearOnPositiveButtonClickListeners() {
        this.onPositiveButtonClickListeners.clear();
    }

    public String getHeaderText() {
        return this.dateSelector.getSelectionDisplayString(getContext());
    }

    @Nullable
    public final S getSelection() {
        return this.dateSelector.getSelection();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface r3) {
        Iterator<DialogInterface.OnCancelListener> r0 = this.onCancelListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onCancel(r3);
        goto L4
    L6:
        super.onCancel(r3);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle r2) {
        super.onCreate(r2);
        if (r2 != null) goto L5;
        r2 = getArguments();
    L5:
        this.overrideThemeResId = r2.getInt(OVERRIDE_THEME_RES_ID);
        this.dateSelector = (DateSelector) r2.getParcelable(DATE_SELECTOR_KEY);
        this.calendarConstraints = (CalendarConstraints) r2.getParcelable(CALENDAR_CONSTRAINTS_KEY);
        this.titleTextResId = r2.getInt(TITLE_TEXT_RES_ID_KEY);
        this.titleText = r2.getCharSequence(TITLE_TEXT_KEY);
        this.inputMode = r2.getInt(INPUT_MODE_KEY);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle r7) {
        Dialog r8 = new Dialog(requireContext(), getThemeResId(requireContext()));
        Context r0 = r8.getContext();
        this.fullscreen = isFullscreen(r0);
        int r1 = MaterialAttributes.resolveOrThrow(r0, com.google.android.material.R.attr.colorSurface, MaterialDatePicker.class.getCanonicalName());
        MaterialShapeDrawable r2 = new MaterialShapeDrawable(r0, null, com.google.android.material.R.attr.materialCalendarStyle, com.google.android.material.R.style.Widget_MaterialComponents_MaterialCalendar);
        this.background = r2;
        r2.initializeElevationOverlay(r0);
        this.background.setFillColor(ColorStateList.valueOf(r1));
        this.background.setElevation(ViewCompat.getElevation(r8.getWindow().getDecorView()));
        return r8;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater r5, @Nullable ViewGroup r6, @Nullable Bundle r7) {
        if (this.fullscreen == false) goto L5;
        int r8 = com.google.android.material.R.layout.mtrl_picker_fullscreen;
    L6:
        View r9 = r5.inflate(r8, r6);
        Context r10 = r9.getContext();
        if (this.fullscreen == false) goto L9;
        r9.findViewById(com.google.android.material.R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(r10), -2));
    L10:
        TextView r11 = (TextView) r9.findViewById(com.google.android.material.R.id.mtrl_picker_header_selection_text);
        this.headerSelectionText = r11;
        ViewCompat.setAccessibilityLiveRegion(r11, 1);
        this.headerToggleButton = (CheckableImageButton) r9.findViewById(com.google.android.material.R.id.mtrl_picker_header_toggle);
        TextView r12 = (TextView) r9.findViewById(com.google.android.material.R.id.mtrl_picker_title_text);
        CharSequence r1 = this.titleText;
        if (r1 == null) goto L13;
        r12.setText(r1);
    L14:
        initHeaderToggle(r10);
        this.confirmButton = (Button) r9.findViewById(com.google.android.material.R.id.confirm_button);
        if (this.dateSelector.isSelectionComplete() == false) goto L17;
        this.confirmButton.setEnabled(true);
    L18:
        this.confirmButton.setTag(CONFIRM_BUTTON_TAG);
        this.confirmButton.setOnClickListener(new AnonymousClass1(this));
        Button r13 = (Button) r9.findViewById(com.google.android.material.R.id.cancel_button);
        r13.setTag(CANCEL_BUTTON_TAG);
        r13.setOnClickListener(new AnonymousClass2(this));
        return r9;
    L17:
        this.confirmButton.setEnabled(false);
        goto L18
    L13:
        r12.setText(this.titleTextResId);
        goto L14
    L9:
        View r14 = r9.findViewById(com.google.android.material.R.id.mtrl_calendar_main_pane);
        View r0 = r9.findViewById(com.google.android.material.R.id.mtrl_calendar_frame);
        r14.setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(r10), -1));
        r0.setMinimumHeight(getDialogPickerHeight(requireContext()));
        goto L10
    L5:
        r8 = com.google.android.material.R.layout.mtrl_picker_dialog;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface r3) {
        Iterator<DialogInterface.OnDismissListener> r0 = this.onDismissListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDismiss(r3);
        goto L4
    L6:
        ViewGroup r1 = (ViewGroup) getView();
        if (r1 == null) goto L9;
        r1.removeAllViews();
    L9:
        super.onDismiss(r3);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@NonNull Bundle r4) {
        super.onSaveInstanceState(r4);
        r4.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
        r4.putParcelable(DATE_SELECTOR_KEY, this.dateSelector);
        CalendarConstraints.Builder r0 = new CalendarConstraints.Builder(this.calendarConstraints);
        if (this.calendar.getCurrentMonth() == null) goto L5;
        r0.setOpenAt(this.calendar.getCurrentMonth().timeInMillis);
    L5:
        r4.putParcelable(CALENDAR_CONSTRAINTS_KEY, r0.build());
        r4.putInt(TITLE_TEXT_RES_ID_KEY, this.titleTextResId);
        r4.putCharSequence(TITLE_TEXT_KEY, this.titleText);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window r0 = requireDialog().getWindow();
        if (this.fullscreen == false) goto L5;
        r0.setLayout(-1, -1);
        r0.setBackgroundDrawable(this.background);
    L6:
        startPickerFragment();
        return;
    L5:
        r0.setLayout(-2, -2);
        int r8 = getResources().getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_dialog_background_inset);
        Rect r1 = new Rect(r8, r8, r8, r8);
        r0.setBackgroundDrawable(new InsetDrawable(this.background, r8, r8, r8, r8));
        r0.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(requireDialog(), r1));
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.pickerFragment.clearOnSelectionChangedListeners();
        super.onStop();
    }

    public boolean removeOnCancelListener(DialogInterface.OnCancelListener r1) {
        return this.onCancelListeners.remove(r1);
    }

    public boolean removeOnDismissListener(DialogInterface.OnDismissListener r1) {
        return this.onDismissListeners.remove(r1);
    }

    public boolean removeOnNegativeButtonClickListener(View.OnClickListener r1) {
        return this.onNegativeButtonClickListeners.remove(r1);
    }

    public boolean removeOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> r1) {
        return this.onPositiveButtonClickListeners.remove(r1);
    }
}
