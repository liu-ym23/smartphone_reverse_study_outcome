package com.android.settings.bluetooth;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.android.settings.R;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OPopoverHelper;
import com.obric.olog.OLog;
import com.obric.oui.popover.v2.OPopover;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothTimerOption {
    private static final String TAG = "BluetoothTimerOption";
    private TimerCallback mCallback;
    private Context mContext;
    private String[] mDefaultValues;
    private long[] mDelayTimeValue;
    private OPopover mPopover;

    public interface TimerCallback {
        void onDialogFinished(boolean r1);

        void onStartTiming(long r1);

        void onStopTiming();
    }

    public BluetoothTimerOption(Context r3, TimerCallback r4) {
        this.mCallback = r4;
        this.mContext = r3;
        this.mDefaultValues = new String[]{r3.getString(R.string.time_no), this.mContext.getString(R.string.time_15m), this.mContext.getString(R.string.time_30m), this.mContext.getString(R.string.time_1h), this.mContext.getString(2131959093), this.mContext.getString(R.string.time_2h)};
        this.mDelayTimeValue = new long[]{0, 900000, 1800000, 3600000, 5400000, 7200000};
    }

    public void show(Activity r1, View r2) {
        this.mPopover = createPopover(r1, r2);
    }

    private OPopover createPopover(Activity r10, View r11) {
        ArrayList r0 = new ArrayList();
        if (isCountdowning() == false) goto L5;
        long r1 = Utils.getDelayTimeValue(this.mContext);
    L7:
        if (r1 > 0) goto L9;
        r1 = this.mDelayTimeValue[0];
    L9:
        int r3 = 0;
    L11:
        if (r3 >= this.mDefaultValues.length) goto L18;
        String r6 = this.mDefaultValues[r3];
        if (this.mDelayTimeValue[r3] != r1) goto L15;
        boolean r7 = true;
    L16:
        r0.add(new Item(r6, r7));
        r3 = r3 + 1;
        goto L11
    L15:
        r7 = false;
        goto L16
    L18:
        return OPopoverHelper.showPopoverList(r10, r11, r0, new BluetoothTimerOption$$ExternalSyntheticLambda0(this));
    L5:
        r1 = -1;
        goto L7
    }

    /* JADX INFO: renamed from: lambda$createPopover$0$com-android-settings-bluetooth-BluetoothTimerOption, reason: not valid java name */
    /* synthetic */ void m360x98d4127f(View r3, int r4) {
        OLog.d(TAG, "onItemClick: = " + this.mDefaultValues[r4]);
        if (r4 != 0) goto L5;
        this.mCallback.onStopTiming();
    L6:
        OPopover r5 = this.mPopover;
        if (r5 == null) goto L9;
        r5.dismiss();
    L9:
        this.mCallback.onDialogFinished(true);
        return;
    L5:
        this.mCallback.onStartTiming(this.mDelayTimeValue[r4]);
        goto L6
    }

    public boolean isCountdowning() {
        if (Utils.getRemainingTime(this.mContext) <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
