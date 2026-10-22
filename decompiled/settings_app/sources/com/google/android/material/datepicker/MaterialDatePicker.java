package com.google.android.material.datepicker;

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
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.android.settings.teaevent.AppMetricsUtils;
import com.google.android.material.R;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    static final Object CANCEL_BUTTON_TAG = null;
    static final Object CONFIRM_BUTTON_TAG = null;
    private static final String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
    public static final int INPUT_MODE_CALENDAR = 0;
    private static final String INPUT_MODE_KEY = "INPUT_MODE_KEY";
    public static final int INPUT_MODE_TEXT = 1;
    private static final String NEGATIVE_BUTTON_TEXT_KEY = "NEGATIVE_BUTTON_TEXT_KEY";
    private static final String NEGATIVE_BUTTON_TEXT_RES_ID_KEY = "NEGATIVE_BUTTON_TEXT_RES_ID_KEY";
    private static final String OVERRIDE_THEME_RES_ID = "OVERRIDE_THEME_RES_ID";
    private static final String POSITIVE_BUTTON_TEXT_KEY = "POSITIVE_BUTTON_TEXT_KEY";
    private static final String POSITIVE_BUTTON_TEXT_RES_ID_KEY = "POSITIVE_BUTTON_TEXT_RES_ID_KEY";
    private static final String TITLE_TEXT_KEY = "TITLE_TEXT_KEY";
    private static final String TITLE_TEXT_RES_ID_KEY = "TITLE_TEXT_RES_ID_KEY";
    static final Object TOGGLE_BUTTON_TAG = null;
    private MaterialShapeDrawable background;
    private MaterialCalendar<S> calendar;
    private CalendarConstraints calendarConstraints;
    private Button confirmButton;
    private DateSelector<S> dateSelector;
    private boolean edgeToEdgeEnabled;
    private boolean fullscreen;
    private TextView headerSelectionText;
    private CheckableImageButton headerToggleButton;
    private int inputMode;
    private CharSequence negativeButtonText;
    private int negativeButtonTextResId;
    private final LinkedHashSet<DialogInterface.OnCancelListener> onCancelListeners;
    private final LinkedHashSet<DialogInterface.OnDismissListener> onDismissListeners;
    private final LinkedHashSet<View.OnClickListener> onNegativeButtonClickListeners;
    private final LinkedHashSet<MaterialPickerOnPositiveButtonClickListener<? super S>> onPositiveButtonClickListeners;
    private int overrideThemeResId;
    private PickerFragment<S> pickerFragment;
    private CharSequence positiveButtonText;
    private int positiveButtonTextResId;
    private CharSequence titleText;
    private int titleTextResId;

    public static final class Builder<S> {
        CalendarConstraints calendarConstraints;
        final DateSelector<S> dateSelector;
        int inputMode;
        CharSequence negativeButtonText;
        int negativeButtonTextResId;
        int overrideThemeResId;
        CharSequence positiveButtonText;
        int positiveButtonTextResId;
        S selection;
        CharSequence titleText;
        int titleTextResId;

        private Builder(DateSelector<S> r3) {
            this.overrideThemeResId = 0;
            this.titleTextResId = 0;
            this.titleText = null;
            this.positiveButtonTextResId = 0;
            this.positiveButtonText = null;
            this.negativeButtonTextResId = 0;
            this.negativeButtonText = null;
            this.selection = null;
            this.inputMode = 0;
            this.dateSelector = r3;
        }

        public static <S> Builder<S> customDatePicker(DateSelector<S> r1) {
            return new Builder(r1);
        }

        public static Builder<Long> datePicker() {
            return new Builder(new SingleDateSelector());
        }

        public static Builder<Pair<Long, Long>> dateRangePicker() {
            return new Builder(new RangeDateSelector());
        }

        public Builder<S> setSelection(S r1) {
            this.selection = r1;
            return this;
        }

        public Builder<S> setTheme(int r1) {
            this.overrideThemeResId = r1;
            return this;
        }

        public Builder<S> setCalendarConstraints(CalendarConstraints r1) {
            this.calendarConstraints = r1;
            return this;
        }

        public Builder<S> setTitleText(int r1) {
            this.titleTextResId = r1;
            this.titleText = null;
            return this;
        }

        public Builder<S> setTitleText(CharSequence r1) {
            this.titleText = r1;
            this.titleTextResId = 0;
            return this;
        }

        public Builder<S> setPositiveButtonText(int r1) {
            this.positiveButtonTextResId = r1;
            this.positiveButtonText = null;
            return this;
        }

        public Builder<S> setPositiveButtonText(CharSequence r1) {
            this.positiveButtonText = r1;
            this.positiveButtonTextResId = 0;
            return this;
        }

        public Builder<S> setNegativeButtonText(int r1) {
            this.negativeButtonTextResId = r1;
            this.negativeButtonText = null;
            return this;
        }

        public Builder<S> setNegativeButtonText(CharSequence r1) {
            this.negativeButtonText = r1;
            this.negativeButtonTextResId = 0;
            return this;
        }

        public Builder<S> setInputMode(int r1) {
            this.inputMode = r1;
            return this;
        }

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
            if (this.calendarConstraints.getOpenAt() != null) goto L15;
            this.calendarConstraints.setOpenAt(createDefaultOpenAt());
        L15:
            return MaterialDatePicker.newInstance(this);
        }

        private Month createDefaultOpenAt() {
            if (this.dateSelector.getSelectedDays().isEmpty() == true) goto L7;
            Month r0 = Month.create(this.dateSelector.getSelectedDays().iterator().next().longValue());
            if (monthInValidRange(r0, this.calendarConstraints) == false) goto L7;
            return r0;
        L7:
            Month r1 = Month.current();
            if (monthInValidRange(r1, this.calendarConstraints) == false) goto L11;
            return r1;
        L11:
            return this.calendarConstraints.getStart();
        }

        private static boolean monthInValidRange(Month r1, CalendarConstraints r2) {
            if (r1.compareTo2(r2.getStart()) >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r1.compareTo2(r2.getEnd()) > 0) goto L7;
            return true;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface InputMode {
    }

    public void com_google_android_material_datepicker_MaterialDatePicker__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r1) {
        com_google_android_material_datepicker_MaterialDatePicker_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_google_android_material_datepicker_MaterialDatePicker_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public MaterialDatePicker() {
        this.onPositiveButtonClickListeners = new LinkedHashSet();
        this.onNegativeButtonClickListeners = new LinkedHashSet();
        this.onCancelListeners = new LinkedHashSet();
        this.onDismissListeners = new LinkedHashSet();
    }

    static /* synthetic */ LinkedHashSet access$000(MaterialDatePicker r0) {
        return r0.onPositiveButtonClickListeners;
    }

    static /* synthetic */ LinkedHashSet access$100(MaterialDatePicker r0) {
        return r0.onNegativeButtonClickListeners;
    }

    static /* synthetic */ void access$200(MaterialDatePicker r0) {
        r0.updateHeader();
    }

    static /* synthetic */ DateSelector access$300(MaterialDatePicker r0) {
        return r0.getDateSelector();
    }

    static /* synthetic */ Button access$400(MaterialDatePicker r0) {
        return r0.confirmButton;
    }

    static /* synthetic */ CheckableImageButton access$500(MaterialDatePicker r0) {
        return r0.headerToggleButton;
    }

    static /* synthetic */ void access$600(MaterialDatePicker r0, CheckableImageButton r1) {
        r0.updateToggleContentDescription(r1);
    }

    static /* synthetic */ void access$700(MaterialDatePicker r0) {
        r0.startPickerFragment();
    }

    static {
        CONFIRM_BUTTON_TAG = "CONFIRM_BUTTON_TAG";
        CANCEL_BUTTON_TAG = "CANCEL_BUTTON_TAG";
        TOGGLE_BUTTON_TAG = "TOGGLE_BUTTON_TAG";
    }

    public static long todayInUtcMilliseconds() {
        return UtcDates.getTodayCalendar().getTimeInMillis();
    }

    public static long thisMonthInUtcMilliseconds() {
        return Month.current().timeInMillis;
    }

    public String getHeaderText() {
        return getDateSelector().getSelectionDisplayString(getContext());
    }

    static <S> MaterialDatePicker<S> newInstance(Builder<S> r4) {
        MaterialDatePicker<S> r0 = new MaterialDatePicker();
        Bundle r1 = new Bundle();
        r1.putInt(OVERRIDE_THEME_RES_ID, r4.overrideThemeResId);
        r1.putParcelable(DATE_SELECTOR_KEY, r4.dateSelector);
        r1.putParcelable(CALENDAR_CONSTRAINTS_KEY, r4.calendarConstraints);
        r1.putInt(TITLE_TEXT_RES_ID_KEY, r4.titleTextResId);
        r1.putCharSequence(TITLE_TEXT_KEY, r4.titleText);
        r1.putInt(INPUT_MODE_KEY, r4.inputMode);
        r1.putInt(POSITIVE_BUTTON_TEXT_RES_ID_KEY, r4.positiveButtonTextResId);
        r1.putCharSequence(POSITIVE_BUTTON_TEXT_KEY, r4.positiveButtonText);
        r1.putInt(NEGATIVE_BUTTON_TEXT_RES_ID_KEY, r4.negativeButtonTextResId);
        r1.putCharSequence(NEGATIVE_BUTTON_TEXT_KEY, r4.negativeButtonText);
        r0.setArguments(r1);
        return r0;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r4) {
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
        r4.putInt(POSITIVE_BUTTON_TEXT_RES_ID_KEY, this.positiveButtonTextResId);
        r4.putCharSequence(POSITIVE_BUTTON_TEXT_KEY, this.positiveButtonText);
        r4.putInt(NEGATIVE_BUTTON_TEXT_RES_ID_KEY, this.negativeButtonTextResId);
        r4.putCharSequence(NEGATIVE_BUTTON_TEXT_KEY, this.negativeButtonText);
    }

    public final void com_google_android_material_datepicker_MaterialDatePicker__onCreate$___twin___(Bundle r2) {
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
        this.positiveButtonTextResId = r2.getInt(POSITIVE_BUTTON_TEXT_RES_ID_KEY);
        this.positiveButtonText = r2.getCharSequence(POSITIVE_BUTTON_TEXT_KEY);
        this.negativeButtonTextResId = r2.getInt(NEGATIVE_BUTTON_TEXT_RES_ID_KEY);
        this.negativeButtonText = r2.getCharSequence(NEGATIVE_BUTTON_TEXT_KEY);
    }

    private int getThemeResId(Context r2) {
        int r0 = this.overrideThemeResId;
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return getDateSelector().getDefaultThemeResId(r2);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r7) {
        Dialog r8 = new Dialog(requireContext(), getThemeResId(requireContext()));
        Context r0 = r8.getContext();
        this.fullscreen = isFullscreen(r0);
        int r1 = MaterialAttributes.resolveOrThrow(r0, R.attr.colorSurface, MaterialDatePicker.class.getCanonicalName());
        MaterialShapeDrawable r2 = new MaterialShapeDrawable(r0, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        this.background = r2;
        r2.initializeElevationOverlay(r0);
        this.background.setFillColor(ColorStateList.valueOf(r1));
        this.background.setElevation(ViewCompat.getElevation(r8.getWindow().getDecorView()));
        return r8;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        if (this.fullscreen == false) goto L5;
        int r7 = R.layout.mtrl_picker_fullscreen;
    L6:
        View r8 = r4.inflate(r7, r5);
        Context r9 = r8.getContext();
        if (this.fullscreen == false) goto L9;
        r8.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(r9), -2));
    L10:
        TextView r10 = (TextView) r8.findViewById(R.id.mtrl_picker_header_selection_text);
        this.headerSelectionText = r10;
        ViewCompat.setAccessibilityLiveRegion(r10, 1);
        this.headerToggleButton = (CheckableImageButton) r8.findViewById(R.id.mtrl_picker_header_toggle);
        TextView r11 = (TextView) r8.findViewById(R.id.mtrl_picker_title_text);
        CharSequence r1 = this.titleText;
        if (r1 == null) goto L13;
        r11.setText(r1);
    L14:
        initHeaderToggle(r9);
        this.confirmButton = (Button) r8.findViewById(R.id.confirm_button);
        if (getDateSelector().isSelectionComplete() == false) goto L17;
        this.confirmButton.setEnabled(true);
    L18:
        this.confirmButton.setTag(CONFIRM_BUTTON_TAG);
        CharSequence r12 = this.positiveButtonText;
        if (r12 == null) goto L21;
        this.confirmButton.setText(r12);
    L24:
        this.confirmButton.setOnClickListener(new AnonymousClass1(this));
        Button r13 = (Button) r8.findViewById(R.id.cancel_button);
        r13.setTag(CANCEL_BUTTON_TAG);
        CharSequence r14 = this.negativeButtonText;
        if (r14 == null) goto L27;
        r13.setText(r14);
    L30:
        r13.setOnClickListener(new AnonymousClass2(this));
        return r8;
    L27:
        int r15 = this.negativeButtonTextResId;
        if (r15 == 0) goto L30;
        r13.setText(r15);
        goto L30
    L21:
        int r16 = this.positiveButtonTextResId;
        if (r16 == 0) goto L24;
        this.confirmButton.setText(r16);
        goto L24
    L17:
        this.confirmButton.setEnabled(false);
        goto L18
    L13:
        r11.setText(this.titleTextResId);
        goto L14
    L9:
        r8.findViewById(R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(r9), -1));
        goto L10
    L5:
        r7 = R.layout.mtrl_picker_dialog;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window r0 = requireDialog().getWindow();
        if (this.fullscreen == false) goto L5;
        r0.setLayout(-1, -1);
        r0.setBackgroundDrawable(this.background);
        enableEdgeToEdgeIfNeeded(r0);
    L6:
        startPickerFragment();
        return;
    L5:
        r0.setLayout(-2, -2);
        int r8 = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
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

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r3) {
        Iterator<DialogInterface.OnCancelListener> r0 = this.onCancelListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onCancel(r3);
        goto L4
    L6:
        super.onCancel(r3);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r3) {
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

    public final S getSelection() {
        return getDateSelector().getSelection();
    }

    private void enableEdgeToEdgeIfNeeded(Window r5) {
        if (this.edgeToEdgeEnabled == false) goto L5;
        return;
    L5:
        final View r0 = requireView().findViewById(R.id.fullscreen_header);
        EdgeToEdgeUtils.applyEdgeToEdge(r5, true, ViewUtils.getBackgroundColor(r0), null);
        final int r6 = r0.getPaddingTop();
        final int r1 = r0.getLayoutParams().height;
        ViewCompat.setOnApplyWindowInsetsListener(r0, new AnonymousClass3(this, r1, r0, r6));
        this.edgeToEdgeEnabled = true;
    }

    private void updateHeader() {
        String r0 = getHeaderText();
        this.headerSelectionText.setContentDescription(String.format(getString(R.string.mtrl_picker_announce_current_selection), new Object[]{r0}));
        this.headerSelectionText.setText(r0);
    }

    private void startPickerFragment() {
        int r0 = getThemeResId(requireContext());
        this.calendar = MaterialCalendar.newInstance(getDateSelector(), r0, this.calendarConstraints);
        if (this.headerToggleButton.isChecked() == false) goto L5;
        PickerFragment<S> r1 = MaterialTextInputPicker.newInstance(getDateSelector(), r0, this.calendarConstraints);
    L6:
        this.pickerFragment = r1;
        updateHeader();
        FragmentTransaction r2 = getChildFragmentManager().beginTransaction();
        r2.replace(R.id.mtrl_calendar_frame, this.pickerFragment);
        r2.commitNow();
        this.pickerFragment.addOnSelectionChangedListener(new AnonymousClass4(this));
        return;
    L5:
        r1 = this.calendar;
        goto L6
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
        this.headerToggleButton.setOnClickListener(new AnonymousClass5(this));
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void updateToggleContentDescription(CheckableImageButton r2) {
        if (this.headerToggleButton.isChecked() == false) goto L5;
        String r3 = r2.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode);
    L6:
        this.headerToggleButton.setContentDescription(r3);
        return;
    L5:
        r3 = r2.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode);
        goto L6
    }

    private DateSelector<S> getDateSelector() {
        if (this.dateSelector != null) goto L6;
        this.dateSelector = (DateSelector) getArguments().getParcelable(DATE_SELECTOR_KEY);
    L6:
        return this.dateSelector;
    }

    private static Drawable createHeaderToggleDrawable(Context r4) {
        StateListDrawable r0 = new StateListDrawable();
        r0.addState(new int[]{android.R.attr.state_checked}, AppCompatResources.getDrawable(r4, R.drawable.material_ic_calendar_black_24dp));
        r0.addState(new int[0], AppCompatResources.getDrawable(r4, R.drawable.material_ic_edit_black_24dp));
        return r0;
    }

    static boolean isFullscreen(Context r1) {
        return readMaterialCalendarStyleBoolean(r1, android.R.attr.windowFullscreen);
    }

    static boolean isNestedScrollable(Context r1) {
        return readMaterialCalendarStyleBoolean(r1, R.attr.nestedScrollable);
    }

    static boolean readMaterialCalendarStyleBoolean(Context r3, int r4) {
        TypedArray r5 = r3.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(r3, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{r4});
        boolean r6 = r5.getBoolean(0, false);
        r5.recycle();
        return r6;
    }

    private static int getPaddedPickerWidth(Context r4) {
        Resources r5 = r4.getResources();
        int r0 = r5.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        int r1 = Month.current().daysInWeek;
        return ((r0 * 2) + (r5.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * r1)) + ((r1 - 1) * r5.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding));
    }

    public boolean addOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> r1) {
        return this.onPositiveButtonClickListeners.add(r1);
    }

    public boolean removeOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> r1) {
        return this.onPositiveButtonClickListeners.remove(r1);
    }

    public void clearOnPositiveButtonClickListeners() {
        this.onPositiveButtonClickListeners.clear();
    }

    public boolean addOnNegativeButtonClickListener(View.OnClickListener r1) {
        return this.onNegativeButtonClickListeners.add(r1);
    }

    public boolean removeOnNegativeButtonClickListener(View.OnClickListener r1) {
        return this.onNegativeButtonClickListeners.remove(r1);
    }

    public void clearOnNegativeButtonClickListeners() {
        this.onNegativeButtonClickListeners.clear();
    }

    public boolean addOnCancelListener(DialogInterface.OnCancelListener r1) {
        return this.onCancelListeners.add(r1);
    }

    public boolean removeOnCancelListener(DialogInterface.OnCancelListener r1) {
        return this.onCancelListeners.remove(r1);
    }

    public void clearOnCancelListeners() {
        this.onCancelListeners.clear();
    }

    public boolean addOnDismissListener(DialogInterface.OnDismissListener r1) {
        return this.onDismissListeners.add(r1);
    }

    public boolean removeOnDismissListener(DialogInterface.OnDismissListener r1) {
        return this.onDismissListeners.remove(r1);
    }

    public void clearOnDismissListeners() {
        this.onDismissListeners.clear();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_google_android_material_datepicker_MaterialDatePicker_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(MaterialDatePicker r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_google_android_material_datepicker_MaterialDatePicker__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_google_android_material_datepicker_MaterialDatePicker_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(MaterialDatePicker r2) {
        String r0 = r2.getClass().getName();
        com_google_android_material_datepicker_MaterialDatePicker_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_google_android_material_datepicker_MaterialDatePicker_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(MaterialDatePicker r2) {
        String r0 = r2.getClass().getName();
        r2.com_google_android_material_datepicker_MaterialDatePicker__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
