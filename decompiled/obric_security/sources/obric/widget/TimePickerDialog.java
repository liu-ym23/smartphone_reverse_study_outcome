package obric.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import obric.util.Utils;

/* JADX INFO: loaded from: classes5.dex */
public class TimePickerDialog extends Dialog implements View.OnClickListener {
    private static final String HOUR = "hour";
    private static final String IS_24_HOUR = "is24hour";
    private static final String MINUTE = "minute";
    private final OnTimeSetListener mCallback;
    int mInitialHourOfDay;
    int mInitialMinute;
    boolean mIs24HourView;
    private final TimePicker mTimePicker;
    private MenuDialogTitleBar titlebar;

    public interface OnTimeSetListener {
        void onTimeSet(TimePicker view, int hourOfDay, int minute);
    }

    static /* synthetic */ TimePicker access$000(TimePickerDialog r0) {
        return r0.mTimePicker;
    }

    static /* synthetic */ MenuDialogTitleBar access$100(TimePickerDialog r0) {
        return r0.titlebar;
    }

    public TimePickerDialog(Context context, OnTimeSetListener callBack, int hourOfDay, int minute, boolean is24HourView) {
        super(context, R.style.PickTimeDialogTheme);
        this.mCallback = callBack;
        this.mInitialHourOfDay = hourOfDay;
        this.mInitialMinute = minute;
        this.mIs24HourView = is24HourView;
        setContentView(R.layout.time_picker_dialog);
        TimePicker r7 = (TimePicker) findViewById(R.id.time_picker);
        this.mTimePicker = r7;
        r7.setIs24HourView(Boolean.valueOf(this.mIs24HourView));
        r7.setCurrentHour(Integer.valueOf(this.mInitialHourOfDay));
        r7.setCurrentMinute(Integer.valueOf(this.mInitialMinute));
        MenuDialogTitleBar r8 = (MenuDialogTitleBar) findViewById(R.id.menu_dialog_title_bar);
        this.titlebar = r8;
        r8.setLeftButtonVisibility(0);
        this.titlebar.addCancelImage(true);
        this.titlebar.addCompleteImage(false);
        int r9 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r0 = View.MeasureSpec.makeMeasureSpec(0, 0);
        ImageView r1 = this.titlebar.getLeftImageView();
        ImageView r2 = this.titlebar.getRightImageView();
        TextView r3 = this.titlebar.getTitleView();
        r1.measure(r9, r0);
        int r4 = r1.getMeasuredWidth();
        this.titlebar.getRightImageView().measure(r9, r0);
        int r10 = r2.getMeasuredWidth();
        this.titlebar.setOnLeftButtonClickListener(this);
        this.titlebar.setOnRightButtonClickListener(this);
        float r5 = context.getResources().getConfiguration().fontScale;
        if (((getWindow().getWindowManager().getDefaultDisplay().getWidth() - r4) - r10) >= Utils.calculateTextWidth(r3)) goto L5;
        r3.setTextSize(0, (int) (r3.getTextSize() / r5));
    L5:
        getWindow().setGravity(80);
        final Drawable r6 = context.getDrawable(R.drawable.time_picker_widget_bottom);
        r7.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass1(this, r6));
        setCanceledOnTouchOutside(true);
    }

    private void cardCircle() {
        getWindow().getDecorView().setOutlineProvider(new AnonymousClass2(this));
        getWindow().getDecorView().setClipToOutline(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != R.id.btn_cancel_left) goto L6;
        dismiss();
        return;
    L6:
        if (v.getId() != R.id.btn_cancel_right) goto L10;
        tryNotifyTimeSet();
        dismiss();
        return;
    }

    public void updateTime(int hourOfDay, int minutOfHour) {
        this.mTimePicker.setCurrentHour(Integer.valueOf(hourOfDay));
        this.mTimePicker.setCurrentMinute(Integer.valueOf(minutOfHour));
    }

    private void tryNotifyTimeSet() {
        if (this.mCallback == null) goto L6;
        this.mTimePicker.clearFocus();
        OnTimeSetListener r0 = this.mCallback;
        TimePicker r1 = this.mTimePicker;
        r0.onTimeSet(r1, r1.getCurrentHour().intValue(), this.mTimePicker.getCurrentMinute().intValue());
        return;
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence title) {
        MenuDialogTitleBar r0 = this.titlebar;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setTitle(title);
    }

    @Override // android.app.Dialog
    public void setTitle(int titleId) {
        MenuDialogTitleBar r0 = this.titlebar;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setTitle(titleId);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        this.mTimePicker.clearFocus();
        super.onStop();
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle r0 = super.onSaveInstanceState();
        r0.putInt(HOUR, this.mTimePicker.getCurrentHour().intValue());
        r0.putInt(MINUTE, this.mTimePicker.getCurrentMinute().intValue());
        r0.putBoolean(IS_24_HOUR, this.mTimePicker.is24HourView());
        return r0;
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int r0 = savedInstanceState.getInt(HOUR);
        int r1 = savedInstanceState.getInt(MINUTE);
        this.mTimePicker.setIs24HourView(Boolean.valueOf(savedInstanceState.getBoolean(IS_24_HOUR)));
        this.mTimePicker.setCurrentHour(Integer.valueOf(r0));
        this.mTimePicker.setCurrentMinute(Integer.valueOf(r1));
    }
}
