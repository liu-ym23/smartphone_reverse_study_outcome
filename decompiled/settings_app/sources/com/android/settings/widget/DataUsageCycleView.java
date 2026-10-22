package com.android.settings.widget;

import android.content.Context;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class DataUsageCycleView extends RadioGroup implements View.OnClickListener {
    private static final String POWER_USAGE_CYCLE_INDEX = "power_usage_cycle_index";
    private final int POWER_USAGE_CYCLE_MONTH;
    private final int POWER_USAGE_CYCLE_TODAY;
    private final int POWER_USAGE_CYCLE_WEEK;
    private final int SUB1;
    private int mCurrentSlot;
    private TextView mCycleMonth;
    private TextView mCycleToday;
    private TextView mCycleWeek;
    private onCycleViewChanged mListener;

    public interface onCycleViewChanged {
        void onChanged(int r1);
    }

    public DataUsageCycleView(Context r2) {
        super(r2);
        this.POWER_USAGE_CYCLE_TODAY = 0;
        this.POWER_USAGE_CYCLE_WEEK = 1;
        this.POWER_USAGE_CYCLE_MONTH = 2;
        this.mCurrentSlot = 0;
        this.SUB1 = 0;
    }

    public DataUsageCycleView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.POWER_USAGE_CYCLE_TODAY = 0;
        this.POWER_USAGE_CYCLE_WEEK = 1;
        this.POWER_USAGE_CYCLE_MONTH = 2;
        this.mCurrentSlot = 0;
        this.SUB1 = 0;
    }

    public void initView() {
        TextView r0 = (TextView) findViewById(R.id.power_usage_today);
        this.mCycleToday = r0;
        r0.setOnClickListener(this);
        TextView r1 = (TextView) findViewById(R.id.power_usage_week);
        this.mCycleWeek = r1;
        r1.setOnClickListener(this);
        TextView r2 = (TextView) findViewById(R.id.power_usage_month);
        this.mCycleMonth = r2;
        r2.setOnClickListener(this);
    }

    public void setCurrentSlot(int r1) {
        this.mCurrentSlot = r1;
    }

    public void setTextViewBackground(int r3) {
        if (r3 != 0) goto L5;
        this.mCycleToday.setBackgroundResource(R.drawable.power_usage_cycle_view_selected_left);
        this.mCycleToday.setTextColor(getContext().getResources().getColor(R.color.white));
        check(this.mCycleToday.getId());
        return;
    L5:
        if (r3 != 1) goto L7;
        this.mCycleWeek.setBackgroundResource(R.drawable.power_usage_cycle_view_selected_mid);
        this.mCycleWeek.setTextColor(getContext().getResources().getColor(R.color.white));
        check(this.mCycleWeek.getId());
        return;
    L7:
        if (r3 != 2) goto L15;
        this.mCycleMonth.setBackgroundResource(R.drawable.power_usage_cycle_view_selected_right);
        this.mCycleMonth.setTextColor(getContext().getResources().getColor(R.color.white));
        check(this.mCycleMonth.getId());
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        this.mCycleToday.setTextColor(getContext().getResources().getColor(R.color.lock_screen_header_normal_text_color));
        this.mCycleWeek.setTextColor(getContext().getResources().getColor(R.color.lock_screen_header_normal_text_color));
        this.mCycleMonth.setTextColor(getContext().getResources().getColor(R.color.lock_screen_header_normal_text_color));
        switch(r5.getId()) {
            case 2131430376: goto L7;
            case 2131430377: goto L11;
            case 2131430378: goto L11;
            case 2131430379: goto L6;
            case 2131430380: goto L5;
            default: goto L11;
        };
    L5:
        saveCfgToDB(1);
        this.mCycleToday.setBackgroundResource(R.drawable.power_usage_cycle_view_normal_left);
        this.mCycleWeek.setBackgroundResource(R.drawable.power_usage_cycle_view_selected_mid);
        this.mCycleMonth.setBackgroundResource(R.drawable.power_usage_cycle_view_normal_right);
        this.mCycleWeek.setTextColor(getContext().getResources().getColor(R.color.white));
        check(this.mCycleWeek.getId());
        return;
    L6:
        saveCfgToDB(0);
        this.mCycleToday.setBackgroundResource(R.drawable.power_usage_cycle_view_selected_left);
        this.mCycleWeek.setBackgroundResource(R.drawable.power_usage_cycle_view_normal_mid);
        this.mCycleMonth.setBackgroundResource(R.drawable.power_usage_cycle_view_normal_right);
        this.mCycleToday.setTextColor(getContext().getResources().getColor(R.color.white));
        check(this.mCycleToday.getId());
        return;
    L7:
        saveCfgToDB(2);
        this.mCycleToday.setBackgroundResource(R.drawable.power_usage_cycle_view_normal_left);
        this.mCycleWeek.setBackgroundResource(R.drawable.power_usage_cycle_view_normal_mid);
        this.mCycleMonth.setBackgroundResource(R.drawable.power_usage_cycle_view_selected_right);
        this.mCycleMonth.setTextColor(getContext().getResources().getColor(R.color.white));
        check(this.mCycleMonth.getId());
        return;
    }

    public void setListener(onCycleViewChanged r1) {
        this.mListener = r1;
    }

    private void saveCfgToDB(int r3) {
        if (this.mCurrentSlot != 0) goto L5;
        Settings.Global.putInt(getContext().getContentResolver(), "data_usage_cycle", r3);
    L6:
        this.mListener.onChanged(r3);
        return;
    L5:
        Settings.Global.putInt(getContext().getContentResolver(), "data_usage_cycle_sub2", r3);
        goto L6
    }
}
