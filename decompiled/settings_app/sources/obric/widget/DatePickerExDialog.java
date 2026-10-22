package obric.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import java.util.Calendar;

/* JADX INFO: loaded from: classes5.dex */
public class DatePickerExDialog extends Dialog implements View.OnClickListener, DatePickerEx.OnDateChangedListener {
    private static final String DAY = "day";
    private static final String MONTH = "month";
    private static final String TYPE = "type";
    private static final String YEAR = "year";
    private final Calendar mCalendar;
    private final OnDateSetListener mCallBack;
    private final DatePickerEx mDatePicker;
    private DatePickerEx.DatePickerType mPickerType;
    private final MenuDialogTitleBar mTitle;

    public interface OnDateSetListener {
        void onDateSet(DatePickerEx view, int year, int monthOfYear, int dayOfMonth);
    }

    public DatePickerExDialog(Context context, OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth) {
        this(context, callBack, year, monthOfYear, dayOfMonth, DatePickerEx.DatePickerType.EVENT);
    }

    public DatePickerExDialog(Context context, OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth, DatePickerEx.DatePickerType type) {
        super(context, R.style.PickTimeDialogTheme);
        this.mPickerType = type;
        this.mCallBack = callBack;
        this.mCalendar = Calendar.getInstance();
        setContentView(R.layout.date_picker_ex_dialog);
        MenuDialogTitleBar r7 = (MenuDialogTitleBar) findViewById(R.id.menu_dialog_title_bar);
        this.mTitle = r7;
        DatePickerEx r0 = (DatePickerEx) findViewById(R.id.date_picker);
        this.mDatePicker = r0;
        r0.init(type, year, monthOfYear, dayOfMonth, this);
        updateTitle(year, monthOfYear, dayOfMonth);
        r7.setLeftButtonVisibility(0);
        r7.addCancelImage(true);
        r7.addCompleteImage(false);
        r7.setOnLeftButtonClickListener(this);
        r7.setOnRightButtonClickListener(this);
        getWindow().setGravity(80);
        getWindow().setLayout(-1, -2);
        setCanceledOnTouchOutside(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int r2 = v.getId();
        if (r2 != R.id.btn_cancel_left) goto L6;
        dismiss();
        return;
    L6:
        if (r2 != R.id.btn_cancel_right) goto L10;
        tryNotifyDateSet();
        dismiss();
        return;
    }

    @Override // obric.widget.DatePickerEx.OnDateChangedListener
    public void onDateChanged(DatePickerEx view, int year, int month, int day, DatePickerEx.DatePickerType type) {
        this.mPickerType = type;
        updateTitle(year, month, day);
    }

    public DatePickerEx getDatePicker() {
        return this.mDatePicker;
    }

    public void updateDate(int year, int monthOfYear, int dayOfMonth) {
        this.mDatePicker.updateDate(year, monthOfYear, dayOfMonth);
    }

    private void tryNotifyDateSet() {
        if (this.mCallBack == null) goto L6;
        this.mDatePicker.clearFocus();
        OnDateSetListener r0 = this.mCallBack;
        DatePickerEx r1 = this.mDatePicker;
        r0.onDateSet(r1, r1.getYear(), this.mDatePicker.getMonth(), this.mDatePicker.getDayOfMonth());
        return;
    }

    @Override // android.app.Dialog
    protected void onStop() {
        this.mDatePicker.clearFocus();
        super.onStop();
    }

    private void updateTitle(int year, int month, int day) {
        this.mCalendar.clear();
        this.mCalendar.set(1, year);
        this.mCalendar.set(2, month);
        this.mCalendar.set(5, day);
        if (DatePickerEx.seemsUnsetYear(year, this.mPickerType) == false) goto L5;
        String r3 = DateUtils.formatDateTime(getContext(), this.mCalendar.getTimeInMillis(), 65560);
    L6:
        this.mTitle.setTitle(r3);
        return;
    L5:
        r3 = DateUtils.formatDateTime(getContext(), this.mCalendar.getTimeInMillis(), 98326);
        goto L6
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle r0 = super.onSaveInstanceState();
        r0.putInt(YEAR, this.mDatePicker.getYear());
        r0.putInt(MONTH, this.mDatePicker.getMonth());
        r0.putInt(DAY, this.mDatePicker.getDayOfMonth());
        r0.putInt("type", this.mPickerType.ordinal());
        return r0;
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int r3 = savedInstanceState.getInt(YEAR);
        int r4 = savedInstanceState.getInt(MONTH);
        int r5 = savedInstanceState.getInt(DAY);
        int r8 = savedInstanceState.getInt("type");
        DatePickerEx r1 = this.mDatePicker;
        if (r8 != 0) goto L5;
        DatePickerEx.DatePickerType r9 = DatePickerEx.DatePickerType.EVENT;
    L6:
        r1.init(r9, r3, r4, r5, this);
        return;
    L5:
        r9 = DatePickerEx.DatePickerType.BIRTHDAY;
        goto L6
    }

    @Deprecated
    public void setRightButtonText(CharSequence text) {
        MenuDialogTitleBar r0 = this.mTitle;
        if (r0 == null) goto L6;
        r0.setRightButtonText(text);
        return;
    }

    public void setRightImageRes(int resId) {
        MenuDialogTitleBar r0 = this.mTitle;
        if (r0 == null) goto L6;
        r0.setRightImageRes(resId);
        return;
    }

    @Deprecated
    public void setRightButtonText(int resId) {
        setRightButtonText(getContext().getResources().getString(resId));
    }

    @Deprecated
    public void setLeftButtonText(CharSequence text) {
        MenuDialogTitleBar r0 = this.mTitle;
        if (r0 == null) goto L6;
        r0.setLeftButtonText(text);
        return;
    }

    public void setLeftImageRes(int resId) {
        MenuDialogTitleBar r0 = this.mTitle;
        if (r0 == null) goto L6;
        r0.setLeftImageViewRes(resId);
        return;
    }

    @Deprecated
    public void setLeftButtonText(int resId) {
        setLeftButtonText(getContext().getResources().getString(resId));
    }
}
