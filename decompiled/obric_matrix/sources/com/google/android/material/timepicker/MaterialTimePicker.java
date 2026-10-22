package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialTimePicker extends DialogFragment implements TimePickerView.OnDoubleTapListener {
    public static final int INPUT_MODE_CLOCK = 0;
    static final String INPUT_MODE_EXTRA = "TIME_PICKER_INPUT_MODE";
    public static final int INPUT_MODE_KEYBOARD = 1;
    static final String NEGATIVE_BUTTON_TEXT_EXTRA = "TIME_PICKER_NEGATIVE_BUTTON_TEXT";
    static final String NEGATIVE_BUTTON_TEXT_RES_EXTRA = "TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES";
    static final String OVERRIDE_THEME_RES_ID = "TIME_PICKER_OVERRIDE_THEME_RES_ID";
    static final String POSITIVE_BUTTON_TEXT_EXTRA = "TIME_PICKER_POSITIVE_BUTTON_TEXT";
    static final String POSITIVE_BUTTON_TEXT_RES_EXTRA = "TIME_PICKER_POSITIVE_BUTTON_TEXT_RES";
    static final String TIME_MODEL_EXTRA = "TIME_PICKER_TIME_MODEL";
    static final String TITLE_RES_EXTRA = "TIME_PICKER_TITLE_RES";
    static final String TITLE_TEXT_EXTRA = "TIME_PICKER_TITLE_TEXT";

    @Nullable
    private TimePickerPresenter activePresenter;
    private Button cancelButton;
    private final Set<DialogInterface.OnCancelListener> cancelListeners;

    @DrawableRes
    private int clockIcon;
    private final Set<DialogInterface.OnDismissListener> dismissListeners;
    private int inputMode;

    @DrawableRes
    private int keyboardIcon;
    private MaterialButton modeButton;
    private final Set<View.OnClickListener> negativeButtonListeners;
    private CharSequence negativeButtonText;

    @StringRes
    private int negativeButtonTextResId;
    private int overrideThemeResId;
    private final Set<View.OnClickListener> positiveButtonListeners;
    private CharSequence positiveButtonText;

    @StringRes
    private int positiveButtonTextResId;
    private ViewStub textInputStub;
    private TimeModel time;

    @Nullable
    private TimePickerClockPresenter timePickerClockPresenter;

    @Nullable
    private TimePickerTextInputPresenter timePickerTextInputPresenter;
    private TimePickerView timePickerView;

    @StringRes
    private int titleResId;
    private CharSequence titleText;

    public static final class Builder {
        private int inputMode;
        private CharSequence negativeButtonText;

        @StringRes
        private int negativeButtonTextResId;
        private int overrideThemeResId;
        private CharSequence positiveButtonText;

        @StringRes
        private int positiveButtonTextResId;
        private TimeModel time;
        private CharSequence titleText;

        @StringRes
        private int titleTextResId;

        public Builder() {
            this.time = new TimeModel();
            this.titleTextResId = 0;
            this.positiveButtonTextResId = 0;
            this.negativeButtonTextResId = 0;
            this.overrideThemeResId = 0;
        }

        static /* synthetic */ TimeModel access$000(Builder r0) {
            return r0.time;
        }

        static /* synthetic */ int access$100(Builder r0) {
            return r0.inputMode;
        }

        static /* synthetic */ int access$200(Builder r0) {
            return r0.titleTextResId;
        }

        static /* synthetic */ CharSequence access$300(Builder r0) {
            return r0.titleText;
        }

        static /* synthetic */ int access$400(Builder r0) {
            return r0.positiveButtonTextResId;
        }

        static /* synthetic */ CharSequence access$500(Builder r0) {
            return r0.positiveButtonText;
        }

        static /* synthetic */ int access$600(Builder r0) {
            return r0.negativeButtonTextResId;
        }

        static /* synthetic */ CharSequence access$700(Builder r0) {
            return r0.negativeButtonText;
        }

        static /* synthetic */ int access$800(Builder r0) {
            return r0.overrideThemeResId;
        }

        @NonNull
        public MaterialTimePicker build() {
            return MaterialTimePicker.access$1400(this);
        }

        @NonNull
        public Builder setHour(@IntRange(from = 0, to = 23) int r2) {
            this.time.setHourOfDay(r2);
            return this;
        }

        @NonNull
        public Builder setInputMode(int r1) {
            this.inputMode = r1;
            return this;
        }

        @NonNull
        public Builder setMinute(@IntRange(from = 0, to = TimeUtils.SECONDS_PER_MINUTE) int r2) {
            this.time.setMinute(r2);
            return this;
        }

        @NonNull
        public Builder setNegativeButtonText(@StringRes int r1) {
            this.negativeButtonTextResId = r1;
            return this;
        }

        @NonNull
        public Builder setNegativeButtonText(@Nullable CharSequence r1) {
            this.negativeButtonText = r1;
            return this;
        }

        @NonNull
        public Builder setPositiveButtonText(@StringRes int r1) {
            this.positiveButtonTextResId = r1;
            return this;
        }

        @NonNull
        public Builder setPositiveButtonText(@Nullable CharSequence r1) {
            this.positiveButtonText = r1;
            return this;
        }

        @NonNull
        public Builder setTheme(@StyleRes int r1) {
            this.overrideThemeResId = r1;
            return this;
        }

        @NonNull
        public Builder setTimeFormat(int r4) {
            TimeModel r0 = this.time;
            int r1 = r0.hour;
            int r2 = r0.minute;
            TimeModel r3 = new TimeModel(r4);
            this.time = r3;
            r3.setMinute(r2);
            this.time.setHourOfDay(r1);
            return this;
        }

        @NonNull
        public Builder setTitleText(@StringRes int r1) {
            this.titleTextResId = r1;
            return this;
        }

        @NonNull
        public Builder setTitleText(@Nullable CharSequence r1) {
            this.titleText = r1;
            return this;
        }
    }

    public MaterialTimePicker() {
        this.positiveButtonListeners = new LinkedHashSet();
        this.negativeButtonListeners = new LinkedHashSet();
        this.cancelListeners = new LinkedHashSet();
        this.dismissListeners = new LinkedHashSet();
        this.titleResId = 0;
        this.positiveButtonTextResId = 0;
        this.negativeButtonTextResId = 0;
        this.inputMode = 0;
        this.overrideThemeResId = 0;
    }

    static /* synthetic */ Set access$1000(MaterialTimePicker r0) {
        return r0.negativeButtonListeners;
    }

    static /* synthetic */ int access$1100(MaterialTimePicker r0) {
        return r0.inputMode;
    }

    static /* synthetic */ int access$1102(MaterialTimePicker r0, int r1) {
        r0.inputMode = r1;
        return r1;
    }

    static /* synthetic */ MaterialButton access$1200(MaterialTimePicker r0) {
        return r0.modeButton;
    }

    static /* synthetic */ void access$1300(MaterialTimePicker r0, MaterialButton r1) {
        r0.updateInputMode(r1);
    }

    static /* synthetic */ MaterialTimePicker access$1400(Builder r0) {
        return newInstance(r0);
    }

    static /* synthetic */ Set access$900(MaterialTimePicker r0) {
        return r0.positiveButtonListeners;
    }

    private Pair<Integer, Integer> dataForMode(int r3) {
        if (r3 == 0) goto L10;
        if (r3 != 1) goto L8;
        return new Pair(Integer.valueOf(this.clockIcon), Integer.valueOf(R.string.material_timepicker_clock_mode_description));
    L8:
        throw new IllegalArgumentException("no icon for mode: " + r3);
    L10:
        return new Pair(Integer.valueOf(this.keyboardIcon), Integer.valueOf(R.string.material_timepicker_text_input_mode_description));
    }

    private int getThemeResId() {
        int r0 = this.overrideThemeResId;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        TypedValue r1 = MaterialAttributes.resolve(requireContext(), R.attr.materialTimePickerTheme);
        if (r1 != null) goto L9;
        return 0;
    L9:
        return r1.data;
    }

    private TimePickerPresenter initializeOrRetrieveActivePresenterForMode(int r1, @NonNull TimePickerView r2, @NonNull ViewStub r3) {
        if (r1 != 0) goto L9;
        TimePickerClockPresenter r4 = this.timePickerClockPresenter;
        if (r4 != null) goto L6;
        r4 = new TimePickerClockPresenter(r2, this.time);
    L6:
        this.timePickerClockPresenter = r4;
        return r4;
    L9:
        if (this.timePickerTextInputPresenter != null) goto L11;
        this.timePickerTextInputPresenter = new TimePickerTextInputPresenter((LinearLayout) r3.inflate(), this.time);
    L11:
        this.timePickerTextInputPresenter.clearCheck();
        return this.timePickerTextInputPresenter;
    }

    @NonNull
    private static MaterialTimePicker newInstance(@NonNull Builder r4) {
        MaterialTimePicker r0 = new MaterialTimePicker();
        Bundle r1 = new Bundle();
        r1.putParcelable(TIME_MODEL_EXTRA, Builder.access$000(r4));
        r1.putInt(INPUT_MODE_EXTRA, Builder.access$100(r4));
        r1.putInt(TITLE_RES_EXTRA, Builder.access$200(r4));
        if (Builder.access$300(r4) == null) goto L5;
        r1.putCharSequence(TITLE_TEXT_EXTRA, Builder.access$300(r4));
    L5:
        r1.putInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, Builder.access$400(r4));
        if (Builder.access$500(r4) == null) goto L8;
        r1.putCharSequence(POSITIVE_BUTTON_TEXT_EXTRA, Builder.access$500(r4));
    L8:
        r1.putInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, Builder.access$600(r4));
        if (Builder.access$700(r4) == null) goto L11;
        r1.putCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA, Builder.access$700(r4));
    L11:
        r1.putInt(OVERRIDE_THEME_RES_ID, Builder.access$800(r4));
        r0.setArguments(r1);
        return r0;
    }

    private void restoreState(@Nullable Bundle r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        TimeModel r0 = (TimeModel) r3.getParcelable(TIME_MODEL_EXTRA);
        this.time = r0;
        if (r0 != null) goto L7;
        this.time = new TimeModel();
    L7:
        this.inputMode = r3.getInt(INPUT_MODE_EXTRA, 0);
        this.titleResId = r3.getInt(TITLE_RES_EXTRA, 0);
        this.titleText = r3.getCharSequence(TITLE_TEXT_EXTRA);
        this.positiveButtonTextResId = r3.getInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, 0);
        this.positiveButtonText = r3.getCharSequence(POSITIVE_BUTTON_TEXT_EXTRA);
        this.negativeButtonTextResId = r3.getInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, 0);
        this.negativeButtonText = r3.getCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA);
        this.overrideThemeResId = r3.getInt(OVERRIDE_THEME_RES_ID, 0);
    }

    private void updateCancelButtonVisibility() {
        Button r0 = this.cancelButton;
        if (r0 != null) goto L5;
        return;
    L5:
        if (isCancelable() == false) goto L7;
        int r1 = 0;
    L8:
        r0.setVisibility(r1);
        return;
    L7:
        r1 = 8;
        goto L8
    }

    private void updateInputMode(MaterialButton r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (this.timePickerView != null) goto L6;
        return;
    L6:
        if (this.textInputStub == null) goto L15;
        TimePickerPresenter r0 = this.activePresenter;
        if (r0 == null) goto L11;
        r0.hide();
    L11:
        TimePickerPresenter r1 = initializeOrRetrieveActivePresenterForMode(this.inputMode, this.timePickerView, this.textInputStub);
        this.activePresenter = r1;
        r1.show();
        this.activePresenter.invalidate();
        Pair<Integer, Integer> r2 = dataForMode(this.inputMode);
        r4.setIconResource(((Integer) r2.first).intValue());
        r4.setContentDescription(getResources().getString(((Integer) r2.second).intValue()));
        r4.sendAccessibilityEvent(4);
        return;
    }

    public boolean addOnCancelListener(@NonNull DialogInterface.OnCancelListener r1) {
        return this.cancelListeners.add(r1);
    }

    public boolean addOnDismissListener(@NonNull DialogInterface.OnDismissListener r1) {
        return this.dismissListeners.add(r1);
    }

    public boolean addOnNegativeButtonClickListener(@NonNull View.OnClickListener r1) {
        return this.negativeButtonListeners.add(r1);
    }

    public boolean addOnPositiveButtonClickListener(@NonNull View.OnClickListener r1) {
        return this.positiveButtonListeners.add(r1);
    }

    public void clearOnCancelListeners() {
        this.cancelListeners.clear();
    }

    public void clearOnDismissListeners() {
        this.dismissListeners.clear();
    }

    public void clearOnNegativeButtonClickListeners() {
        this.negativeButtonListeners.clear();
    }

    public void clearOnPositiveButtonClickListeners() {
        this.positiveButtonListeners.clear();
    }

    @IntRange(from = 0, to = 23)
    public int getHour() {
        return this.time.hour % 24;
    }

    public int getInputMode() {
        return this.inputMode;
    }

    @IntRange(from = 0, to = TimeUtils.SECONDS_PER_MINUTE)
    public int getMinute() {
        return this.time.minute;
    }

    @Nullable
    TimePickerClockPresenter getTimePickerClockPresenter() {
        return this.timePickerClockPresenter;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface r3) {
        Iterator<DialogInterface.OnCancelListener> r0 = this.cancelListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onCancel(r3);
        goto L4
    L6:
        super.onCancel(r3);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle r1) {
        super.onCreate(r1);
        if (r1 != null) goto L5;
        r1 = getArguments();
    L5:
        restoreState(r1);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle r8) {
        Dialog r9 = new Dialog(requireContext(), getThemeResId());
        Context r0 = r9.getContext();
        int r1 = MaterialAttributes.resolveOrThrow(r0, R.attr.colorSurface, MaterialTimePicker.class.getCanonicalName());
        int r3 = R.attr.materialTimePickerStyle;
        int r4 = R.style.Widget_MaterialComponents_TimePicker;
        MaterialShapeDrawable r2 = new MaterialShapeDrawable(r0, null, r3, r4);
        TypedArray r5 = r0.obtainStyledAttributes(null, R.styleable.MaterialTimePicker, r3, r4);
        this.clockIcon = r5.getResourceId(R.styleable.MaterialTimePicker_clockIcon, 0);
        this.keyboardIcon = r5.getResourceId(R.styleable.MaterialTimePicker_keyboardIcon, 0);
        r5.recycle();
        r2.initializeElevationOverlay(r0);
        r2.setFillColor(ColorStateList.valueOf(r1));
        Window r7 = r9.getWindow();
        r7.setBackgroundDrawable(r2);
        r7.requestFeature(1);
        r7.setLayout(-2, -2);
        r2.setElevation(ViewCompat.getElevation(r7.getDecorView()));
        return r9;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater r1, @Nullable ViewGroup r2, @Nullable Bundle r3) {
        ViewGroup r4 = (ViewGroup) r1.inflate(R.layout.material_timepicker_dialog, r2);
        TimePickerView r5 = (TimePickerView) r4.findViewById(R.id.material_timepicker_view);
        this.timePickerView = r5;
        r5.setOnDoubleTapListener(this);
        this.textInputStub = (ViewStub) r4.findViewById(R.id.material_textinput_timepicker);
        this.modeButton = (MaterialButton) r4.findViewById(R.id.material_timepicker_mode_button);
        TextView r6 = (TextView) r4.findViewById(R.id.header_title);
        int r7 = this.titleResId;
        if (r7 == 0) goto L6;
        r6.setText(r7);
    L8:
        updateInputMode(this.modeButton);
        Button r8 = (Button) r4.findViewById(R.id.material_timepicker_ok_button);
        r8.setOnClickListener(new AnonymousClass1(this));
        int r9 = this.positiveButtonTextResId;
        if (r9 == 0) goto L12;
        r8.setText(r9);
    L14:
        Button r10 = (Button) r4.findViewById(R.id.material_timepicker_cancel_button);
        this.cancelButton = r10;
        r10.setOnClickListener(new AnonymousClass2(this));
        int r11 = this.negativeButtonTextResId;
        if (r11 == 0) goto L18;
        this.cancelButton.setText(r11);
    L20:
        updateCancelButtonVisibility();
        this.modeButton.setOnClickListener(new AnonymousClass3(this));
        return r4;
    L18:
        if (TextUtils.isEmpty(this.negativeButtonText) == true) goto L20;
        this.cancelButton.setText(this.negativeButtonText);
        goto L20
    L12:
        if (TextUtils.isEmpty(this.positiveButtonText) == true) goto L14;
        r8.setText(this.positiveButtonText);
        goto L14
    L6:
        if (TextUtils.isEmpty(this.titleText) == true) goto L8;
        r6.setText(this.titleText);
        goto L8
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.activePresenter = null;
        this.timePickerClockPresenter = null;
        this.timePickerTextInputPresenter = null;
        TimePickerView r1 = this.timePickerView;
        if (r1 == null) goto L6;
        r1.setOnDoubleTapListener(null);
        this.timePickerView = null;
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface r3) {
        Iterator<DialogInterface.OnDismissListener> r0 = this.dismissListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDismiss(r3);
        goto L4
    L6:
        super.onDismiss(r3);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnDoubleTapListener
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onDoubleTap() {
        this.inputMode = 1;
        updateInputMode(this.modeButton);
        this.timePickerTextInputPresenter.resetChecked();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putParcelable(TIME_MODEL_EXTRA, this.time);
        r3.putInt(INPUT_MODE_EXTRA, this.inputMode);
        r3.putInt(TITLE_RES_EXTRA, this.titleResId);
        r3.putCharSequence(TITLE_TEXT_EXTRA, this.titleText);
        r3.putInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, this.positiveButtonTextResId);
        r3.putCharSequence(POSITIVE_BUTTON_TEXT_EXTRA, this.positiveButtonText);
        r3.putInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, this.negativeButtonTextResId);
        r3.putCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA, this.negativeButtonText);
        r3.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
    }

    public boolean removeOnCancelListener(@NonNull DialogInterface.OnCancelListener r1) {
        return this.cancelListeners.remove(r1);
    }

    public boolean removeOnDismissListener(@NonNull DialogInterface.OnDismissListener r1) {
        return this.dismissListeners.remove(r1);
    }

    public boolean removeOnNegativeButtonClickListener(@NonNull View.OnClickListener r1) {
        return this.negativeButtonListeners.remove(r1);
    }

    public boolean removeOnPositiveButtonClickListener(@NonNull View.OnClickListener r1) {
        return this.positiveButtonListeners.remove(r1);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setCancelable(boolean r1) {
        super.setCancelable(r1);
        updateCancelButtonVisibility();
    }
}
