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
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialTimePicker extends DialogFragment {
    public static final int INPUT_MODE_CLOCK = 0;
    static final String INPUT_MODE_EXTRA = "TIME_PICKER_INPUT_MODE";
    public static final int INPUT_MODE_KEYBOARD = 1;
    static final String TIME_MODEL_EXTRA = "TIME_PICKER_TIME_MODEL";
    static final String TITLE_RES_EXTRA = "TIME_PICKER_TITLE_RES";
    static final String TITLE_TEXT_EXTRA = "TIME_PICKER_TITLE_TEXT";
    private TimePickerPresenter activePresenter;
    private final Set<DialogInterface.OnCancelListener> cancelListeners;
    private int clockIcon;
    private final Set<DialogInterface.OnDismissListener> dismissListeners;
    private int inputMode;
    private int keyboardIcon;
    private MaterialButton modeButton;
    private final Set<View.OnClickListener> negativeButtonListeners;
    private final Set<View.OnClickListener> positiveButtonListeners;
    private ViewStub textInputStub;
    private LinearLayout textInputView;
    private TimeModel time;
    private TimePickerClockPresenter timePickerClockPresenter;
    private TimePickerTextInputPresenter timePickerTextInputPresenter;
    private TimePickerView timePickerView;
    private int titleResId;
    private String titleText;

    public static final class Builder {
        private int inputMode;
        private TimeModel time;
        private CharSequence titleText;
        private int titleTextResId;

        public Builder() {
            this.time = new TimeModel();
            this.titleTextResId = 0;
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

        public Builder setInputMode(int r1) {
            this.inputMode = r1;
            return this;
        }

        public Builder setHour(int r2) {
            this.time.setHourOfDay(r2);
            return this;
        }

        public Builder setMinute(int r2) {
            this.time.setMinute(r2);
            return this;
        }

        public Builder setTimeFormat(int r4) {
            int r0 = this.time.hour;
            int r1 = this.time.minute;
            TimeModel r2 = new TimeModel(r4);
            this.time = r2;
            r2.setMinute(r1);
            this.time.setHourOfDay(r0);
            return this;
        }

        public Builder setTitleText(int r1) {
            this.titleTextResId = r1;
            return this;
        }

        public Builder setTitleText(CharSequence r1) {
            this.titleText = r1;
            return this;
        }

        public MaterialTimePicker build() {
            return MaterialTimePicker.access$1000(this);
        }
    }

    public MaterialTimePicker() {
        this.positiveButtonListeners = new LinkedHashSet();
        this.negativeButtonListeners = new LinkedHashSet();
        this.cancelListeners = new LinkedHashSet();
        this.dismissListeners = new LinkedHashSet();
        this.titleResId = 0;
        this.inputMode = 0;
    }

    static /* synthetic */ MaterialTimePicker access$1000(Builder r0) {
        return newInstance(r0);
    }

    static /* synthetic */ int access$400(MaterialTimePicker r0) {
        return r0.inputMode;
    }

    static /* synthetic */ int access$402(MaterialTimePicker r0, int r1) {
        r0.inputMode = r1;
        return r1;
    }

    static /* synthetic */ MaterialButton access$500(MaterialTimePicker r0) {
        return r0.modeButton;
    }

    static /* synthetic */ void access$600(MaterialTimePicker r0, MaterialButton r1) {
        r0.updateInputMode(r1);
    }

    static /* synthetic */ TimePickerTextInputPresenter access$700(MaterialTimePicker r0) {
        return r0.timePickerTextInputPresenter;
    }

    static /* synthetic */ Set access$800(MaterialTimePicker r0) {
        return r0.positiveButtonListeners;
    }

    static /* synthetic */ Set access$900(MaterialTimePicker r0) {
        return r0.negativeButtonListeners;
    }

    private static MaterialTimePicker newInstance(Builder r4) {
        MaterialTimePicker r0 = new MaterialTimePicker();
        Bundle r1 = new Bundle();
        r1.putParcelable(TIME_MODEL_EXTRA, Builder.access$000(r4));
        r1.putInt(INPUT_MODE_EXTRA, Builder.access$100(r4));
        r1.putInt(TITLE_RES_EXTRA, Builder.access$200(r4));
        if (Builder.access$300(r4) == null) goto L5;
        r1.putString(TITLE_TEXT_EXTRA, Builder.access$300(r4).toString());
    L5:
        r0.setArguments(r1);
        return r0;
    }

    public int getMinute() {
        return this.time.minute;
    }

    public int getHour() {
        return this.time.hour % 24;
    }

    public int getInputMode() {
        return this.inputMode;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r9) {
        TypedValue r10 = MaterialAttributes.resolve(requireContext(), R.attr.materialTimePickerTheme);
        Context r1 = requireContext();
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        Dialog r0 = new Dialog(r1, r11);
        Context r12 = r0.getContext();
        int r2 = MaterialAttributes.resolveOrThrow(r12, R.attr.colorSurface, MaterialTimePicker.class.getCanonicalName());
        MaterialShapeDrawable r3 = new MaterialShapeDrawable(r12, null, R.attr.materialTimePickerStyle, R.style.Widget_MaterialComponents_TimePicker);
        TypedArray r4 = r12.obtainStyledAttributes(null, R.styleable.MaterialTimePicker, R.attr.materialTimePickerStyle, R.style.Widget_MaterialComponents_TimePicker);
        this.clockIcon = r4.getResourceId(R.styleable.MaterialTimePicker_clockIcon, 0);
        this.keyboardIcon = r4.getResourceId(R.styleable.MaterialTimePicker_keyboardIcon, 0);
        r4.recycle();
        r3.initializeElevationOverlay(r12);
        r3.setFillColor(ColorStateList.valueOf(r2));
        Window r8 = r0.getWindow();
        r8.setBackgroundDrawable(r3);
        r8.requestFeature(1);
        r8.setLayout(-2, -2);
        return r0;
    L5:
        r11 = r10.data;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        if (r1 != null) goto L5;
        r1 = getArguments();
    L5:
        restoreState(r1);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putParcelable(TIME_MODEL_EXTRA, this.time);
        r3.putInt(INPUT_MODE_EXTRA, this.inputMode);
        r3.putInt(TITLE_RES_EXTRA, this.titleResId);
        r3.putString(TITLE_TEXT_EXTRA, this.titleText);
    }

    private void restoreState(Bundle r3) {
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
        this.titleText = r3.getString(TITLE_TEXT_EXTRA);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        ViewGroup r4 = (ViewGroup) r1.inflate(R.layout.material_timepicker_dialog, r2);
        TimePickerView r5 = (TimePickerView) r4.findViewById(R.id.material_timepicker_view);
        this.timePickerView = r5;
        r5.setOnDoubleTapListener(new AnonymousClass1(this));
        this.textInputStub = (ViewStub) r4.findViewById(R.id.material_textinput_timepicker);
        this.modeButton = (MaterialButton) r4.findViewById(R.id.material_timepicker_mode_button);
        TextView r6 = (TextView) r4.findViewById(R.id.header_title);
        if (TextUtils.isEmpty(this.titleText) == true) goto L5;
        r6.setText(this.titleText);
    L5:
        int r7 = this.titleResId;
        if (r7 == 0) goto L8;
        r6.setText(r7);
    L8:
        updateInputMode(this.modeButton);
        ((Button) r4.findViewById(R.id.material_timepicker_ok_button)).setOnClickListener(new AnonymousClass2(this));
        ((Button) r4.findViewById(R.id.material_timepicker_cancel_button)).setOnClickListener(new AnonymousClass3(this));
        this.modeButton.setOnClickListener(new AnonymousClass4(this));
        return r4;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r3) {
        Iterator<DialogInterface.OnCancelListener> r0 = this.cancelListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onCancel(r3);
        goto L4
    L6:
        super.onCancel(r3);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r3) {
        Iterator<DialogInterface.OnDismissListener> r0 = this.dismissListeners.iterator();
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

    private void updateInputMode(MaterialButton r3) {
        TimePickerPresenter r0 = this.activePresenter;
        if (r0 == null) goto L5;
        r0.hide();
    L5:
        TimePickerPresenter r1 = initializeOrRetrieveActivePresenterForMode(this.inputMode);
        this.activePresenter = r1;
        r1.show();
        this.activePresenter.invalidate();
        Pair<Integer, Integer> r2 = dataForMode(this.inputMode);
        r3.setIconResource(((Integer) r2.first).intValue());
        r3.setContentDescription(getResources().getString(((Integer) r2.second).intValue()));
    }

    private TimePickerPresenter initializeOrRetrieveActivePresenterForMode(int r3) {
        if (r3 != 0) goto L9;
        TimePickerClockPresenter r4 = this.timePickerClockPresenter;
        if (r4 != null) goto L6;
        r4 = new TimePickerClockPresenter(this.timePickerView, this.time);
    L6:
        this.timePickerClockPresenter = r4;
        return r4;
    L9:
        if (this.timePickerTextInputPresenter != null) goto L11;
        this.textInputView = (LinearLayout) this.textInputStub.inflate();
        this.timePickerTextInputPresenter = new TimePickerTextInputPresenter(this.textInputView, this.time);
    L11:
        this.timePickerTextInputPresenter.clearCheck();
        return this.timePickerTextInputPresenter;
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

    TimePickerClockPresenter getTimePickerClockPresenter() {
        return this.timePickerClockPresenter;
    }

    public boolean addOnPositiveButtonClickListener(View.OnClickListener r1) {
        return this.positiveButtonListeners.add(r1);
    }

    public boolean removeOnPositiveButtonClickListener(View.OnClickListener r1) {
        return this.positiveButtonListeners.remove(r1);
    }

    public void clearOnPositiveButtonClickListeners() {
        this.positiveButtonListeners.clear();
    }

    public boolean addOnNegativeButtonClickListener(View.OnClickListener r1) {
        return this.negativeButtonListeners.add(r1);
    }

    public boolean removeOnNegativeButtonClickListener(View.OnClickListener r1) {
        return this.negativeButtonListeners.remove(r1);
    }

    public void clearOnNegativeButtonClickListeners() {
        this.negativeButtonListeners.clear();
    }

    public boolean addOnCancelListener(DialogInterface.OnCancelListener r1) {
        return this.cancelListeners.add(r1);
    }

    public boolean removeOnCancelListener(DialogInterface.OnCancelListener r1) {
        return this.cancelListeners.remove(r1);
    }

    public void clearOnCancelListeners() {
        this.cancelListeners.clear();
    }

    public boolean addOnDismissListener(DialogInterface.OnDismissListener r1) {
        return this.dismissListeners.add(r1);
    }

    public boolean removeOnDismissListener(DialogInterface.OnDismissListener r1) {
        return this.dismissListeners.remove(r1);
    }

    public void clearOnDismissListeners() {
        this.dismissListeners.clear();
    }
}
