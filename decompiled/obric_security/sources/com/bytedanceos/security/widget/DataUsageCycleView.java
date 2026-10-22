package com.bytedanceos.security.widget;

import android.content.Context;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.bytedanceos.security.Utils;
import com.bytedanceos.utils.Constants;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
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
        void onChanged(int value);
    }

    public DataUsageCycleView(Context context) {
        super(context);
        this.POWER_USAGE_CYCLE_TODAY = 0;
        this.POWER_USAGE_CYCLE_WEEK = 1;
        this.POWER_USAGE_CYCLE_MONTH = 2;
        this.mCurrentSlot = 0;
        this.SUB1 = 0;
    }

    public DataUsageCycleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.POWER_USAGE_CYCLE_TODAY = 0;
        this.POWER_USAGE_CYCLE_WEEK = 1;
        this.POWER_USAGE_CYCLE_MONTH = 2;
        this.mCurrentSlot = 0;
        this.SUB1 = 0;
    }

    public void initView() {
        TextView r0 = (TextView) findViewById(R.id.power_usage_today);
        this.mCycleToday = r0;
        if (r0 == null) goto L5;
        r0.setOnClickListener(this);
    L5:
        TextView r1 = (TextView) findViewById(R.id.power_usage_week);
        this.mCycleWeek = r1;
        if (r1 == null) goto L8;
        r1.setOnClickListener(this);
    L8:
        TextView r2 = (TextView) findViewById(R.id.power_usage_month);
        this.mCycleMonth = r2;
        if (r2 == null) goto L12;
        r2.setOnClickListener(this);
        return;
    }

    public void setCurrentSlot(int slot) {
        this.mCurrentSlot = slot;
    }

    public void setTextViewBackground(int index) {
        if (index != 0) goto L5;
        this.mCycleToday.setBackgroundResource(R.drawable.power_usage_cycle_view_selected_left);
        this.mCycleToday.setTextColor(getContext().getResources().getColor(R.color.white));
        check(this.mCycleToday.getId());
        return;
    L5:
        if (index != 1) goto L7;
        this.mCycleWeek.setBackgroundResource(R.drawable.power_usage_cycle_view_selected_mid);
        this.mCycleWeek.setTextColor(getContext().getResources().getColor(R.color.white));
        check(this.mCycleWeek.getId());
        return;
    L7:
        if (index != 2) goto L15;
        this.mCycleMonth.setBackgroundResource(R.drawable.power_usage_cycle_view_selected_right);
        this.mCycleMonth.setTextColor(getContext().getResources().getColor(R.color.white));
        check(this.mCycleMonth.getId());
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (Utils.isFastDoubleClick() == false) goto L5;
        return;
    L5:
        this.mCycleToday.setTextColor(getContext().getResources().getColor(R.color.selected_text_color));
        this.mCycleWeek.setTextColor(getContext().getResources().getColor(R.color.selected_text_color));
        this.mCycleMonth.setTextColor(getContext().getResources().getColor(R.color.selected_text_color));
        switch(v.getId()) {
            case 2131297659: goto L10;
            case 2131297660: goto L14;
            case 2131297661: goto L9;
            case 2131297662: goto L8;
            default: goto L14;
        };
    L8:
        this.mListener.onChanged(1);
        this.mCycleToday.setBackgroundResource(R.drawable.power_usage_cycle_view_normal_left);
        this.mCycleWeek.setBackgroundResource(R.drawable.power_usage_cycle_view_selected_mid);
        this.mCycleMonth.setBackgroundResource(R.drawable.power_usage_cycle_view_normal_right);
        this.mCycleWeek.setTextColor(getContext().getResources().getColor(R.color.white));
        check(this.mCycleWeek.getId());
        return;
    L9:
        this.mListener.onChanged(0);
        this.mCycleToday.setBackgroundResource(R.drawable.power_usage_cycle_view_selected_left);
        this.mCycleWeek.setBackgroundResource(R.drawable.power_usage_cycle_view_normal_mid);
        this.mCycleMonth.setBackgroundResource(R.drawable.power_usage_cycle_view_normal_right);
        this.mCycleToday.setTextColor(getContext().getResources().getColor(R.color.white));
        check(this.mCycleToday.getId());
        return;
    L10:
        this.mListener.onChanged(2);
        this.mCycleToday.setBackgroundResource(R.drawable.power_usage_cycle_view_normal_left);
        this.mCycleWeek.setBackgroundResource(R.drawable.power_usage_cycle_view_normal_mid);
        this.mCycleMonth.setBackgroundResource(R.drawable.power_usage_cycle_view_selected_right);
        this.mCycleMonth.setTextColor(getContext().getResources().getColor(R.color.white));
        check(this.mCycleMonth.getId());
        return;
    }

    public void setListener(onCycleViewChanged l) {
        this.mListener = l;
    }

    private void saveCfgToDB(int type) {
        if (this.mCurrentSlot != 0) goto L5;
        Settings.Global.putInt(getContext().getContentResolver(), Constants.DATA_USAGE_CYCLE, type);
    L6:
        this.mListener.onChanged(type);
        return;
    L5:
        Settings.Global.putInt(getContext().getContentResolver(), "data_usage_cycle_sub2", type);
        goto L6
    }
}
