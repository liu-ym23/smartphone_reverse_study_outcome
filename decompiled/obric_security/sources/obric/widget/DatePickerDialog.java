package obric.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import java.util.Calendar;
import obric.util.DisplayHelper;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class DatePickerDialog extends Dialog implements View.OnClickListener, DatePicker.OnDateChangedListener {
    private static final String DAY = "day";
    private static final String MONTH = "month";
    private static final String TYPE = "type";
    private static final String YEAR = "year";
    private final Calendar mCalendar;
    private final OnDateSetListener mCallBack;
    private final DatePicker mDatePicker;
    private DatePicker.DatePickerType mPickerType;
    private final MenuDialogTitleBar mTitle;

    public interface OnDateSetListener {
        void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth);
    }

    public DatePickerDialog(Context context, OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth) {
        this(context, callBack, year, monthOfYear, dayOfMonth, DatePicker.DatePickerType.EVENT);
    }

    public DatePickerDialog(Context context, OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth, DatePicker.DatePickerType type) {
        super(context, R.style.PickTimeDialogTheme);
        this.mPickerType = type;
        this.mCallBack = callBack;
        this.mCalendar = Calendar.getInstance();
        setContentView(R.layout.date_picker_dialog);
        MenuDialogTitleBar r9 = (MenuDialogTitleBar) findViewById(R.id.menu_dialog_title_bar);
        this.mTitle = r9;
        DatePicker r1 = (DatePicker) findViewById(R.id.date_picker);
        this.mDatePicker = r1;
        r1.init(type, year, monthOfYear, dayOfMonth, this);
        updateTitle(year, monthOfYear, dayOfMonth);
        r9.setLeftButtonVisibility(0);
        r9.addCancelImage(true);
        r9.addCompleteImage(false);
        r9.setOnLeftButtonClickListener(this);
        r9.setOnRightButtonClickListener(this);
        cardCircle();
        getWindow().setGravity(17);
        getWindow().setLayout(DisplayHelper.dp2px(context, 360), -2);
        setCanceledOnTouchOutside(true);
    }

    private void cardCircle() {
        getWindow().getDecorView().setOutlineProvider(new AnonymousClass1(this));
        getWindow().getDecorView().setClipToOutline(true);
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

    @Override // obric.widget.DatePicker.OnDateChangedListener
    public void onDateChanged(DatePicker view, int year, int month, int day, DatePicker.DatePickerType type) {
        this.mPickerType = type;
        updateTitle(year, month, day);
    }

    public DatePicker getDatePicker() {
        return this.mDatePicker;
    }

    public void updateDate(int year, int monthOfYear, int dayOfMonth) {
        this.mDatePicker.updateDate(year, monthOfYear, dayOfMonth);
    }

    private void tryNotifyDateSet() {
        if (this.mCallBack == null) goto L6;
        this.mDatePicker.clearFocus();
        OnDateSetListener r0 = this.mCallBack;
        DatePicker r1 = this.mDatePicker;
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
        if (DatePicker.seemsUnsetYear(year, this.mPickerType) == false) goto L5;
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
        DatePicker r1 = this.mDatePicker;
        if (r8 != 0) goto L5;
        DatePicker.DatePickerType r9 = DatePicker.DatePickerType.EVENT;
    L6:
        r1.init(r9, r3, r4, r5, this);
        return;
    L5:
        r9 = DatePicker.DatePickerType.BIRTHDAY;
        goto L6
    }
}
