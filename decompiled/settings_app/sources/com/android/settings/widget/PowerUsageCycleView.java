package com.android.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.android.settings.PreferenceMgr;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class PowerUsageCycleView extends RadioGroup implements View.OnClickListener {
    private static final String POWER_USAGE_CYCLE_INDEX = "power_usage_cycle_index";
    private final int POWER_USAGE_CYCLE_MONTH;
    private final int POWER_USAGE_CYCLE_TODAY;
    private final int POWER_USAGE_CYCLE_WEEK;
    private TextView mCycleMonth;
    private TextView mCycleToday;
    private TextView mCycleWeek;
    private onCycleViewChanged mListener;

    public interface onCycleViewChanged {
        void onChanged(int r1);
    }

    public PowerUsageCycleView(Context r1) {
        super(r1);
        this.POWER_USAGE_CYCLE_TODAY = 0;
        this.POWER_USAGE_CYCLE_WEEK = 1;
        this.POWER_USAGE_CYCLE_MONTH = 2;
    }

    public PowerUsageCycleView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.POWER_USAGE_CYCLE_TODAY = 0;
        this.POWER_USAGE_CYCLE_WEEK = 1;
        this.POWER_USAGE_CYCLE_MONTH = 2;
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
    public void onClick(View r7) {
        this.mCycleToday.setTextColor(getContext().getResources().getColor(R.color.lock_screen_header_normal_text_color));
        this.mCycleWeek.setTextColor(getContext().getResources().getColor(R.color.lock_screen_header_normal_text_color));
        this.mCycleMonth.setTextColor(getContext().getResources().getColor(R.color.lock_screen_header_normal_text_color));
        switch(r7.getId()) {
            case 2131430376: goto L7;
            case 2131430377: goto L8;
            case 2131430378: goto L8;
            case 2131430379: goto L6;
            case 2131430380: goto L5;
            default: goto L8;
        };
    L5:
        PreferenceMgr.getInstance(getContext()).putInt(POWER_USAGE_CYCLE_INDEX, 1);
        this.mCycleToday.setBackgroundResource(R.drawable.power_usage_cycle_view_normal_left);
        this.mCycleWeek.setBackgroundResource(R.drawable.power_usage_cycle_view_selected_mid);
        this.mCycleMonth.setBackgroundResource(R.drawable.power_usage_cycle_view_normal_right);
        this.mCycleWeek.setTextColor(getContext().getResources().getColor(R.color.white));
        check(this.mCycleWeek.getId());
        goto L8
    L6:
        PreferenceMgr.getInstance(getContext()).putInt(POWER_USAGE_CYCLE_INDEX, 0);
        this.mCycleToday.setBackgroundResource(R.drawable.power_usage_cycle_view_selected_left);
        this.mCycleWeek.setBackgroundResource(R.drawable.power_usage_cycle_view_normal_mid);
        this.mCycleMonth.setBackgroundResource(R.drawable.power_usage_cycle_view_normal_right);
        this.mCycleToday.setTextColor(getContext().getResources().getColor(R.color.white));
        check(this.mCycleToday.getId());
        goto L8
    L7:
        PreferenceMgr.getInstance(getContext()).putInt(POWER_USAGE_CYCLE_INDEX, 2);
        this.mCycleToday.setBackgroundResource(R.drawable.power_usage_cycle_view_normal_left);
        this.mCycleWeek.setBackgroundResource(R.drawable.power_usage_cycle_view_normal_mid);
        this.mCycleMonth.setBackgroundResource(R.drawable.power_usage_cycle_view_selected_right);
        this.mCycleMonth.setTextColor(getContext().getResources().getColor(R.color.white));
        check(this.mCycleMonth.getId());
    L8:
        this.mListener.onChanged(PreferenceMgr.getInstance(getContext()).getInt(POWER_USAGE_CYCLE_INDEX, 0));
    }

    public void setListener(onCycleViewChanged r1) {
        this.mListener = r1;
    }
}
