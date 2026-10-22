package com.android.settings.sim;

import android.content.Context;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.android.settings.MultiSimAdapter;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class DataDuringCallsPreferenceController {
    private static final String TAG = "DataDuringCalls";
    private Context mContext;

    public DataDuringCallsPreferenceController(Context r1) {
        this.mContext = r1;
    }

    private int getNonDdsSub() {
        if (isAvailable() == true) goto L5;
        return -1;
    L5:
        int r4 = SubscriptionManager.getDefaultDataSubscriptionId();
        if (r4 != (-1)) goto L9;
        OLog.e(TAG, "getNonDdsTm: invalid dds");
        return r4;
    L9:
        int r5 = SubscriptionManager.getSlotIndex(r4);
        int r2 = 1;
        if (r5 == 0) goto L14;
        if (r5 == 1) goto L14;
        OLog.e(TAG, "getNonDdsTm: invalid ddsSlot: " + r5);
        return -1;
    L14:
        if (r5 == 0) goto L17;
        r2 = 0;
    L17:
        int r6 = MultiSimAdapter.slot2Sub(r2);
        if (r6 != (-1)) goto L21;
        OLog.e(TAG, "getNonDdsTm: nonDdsSlot: " + r2 + " not corresponds to a valid subId");
        return r6;
    L21:
        OLog.d(TAG, "getNonDdsTm: nonDdsSub: " + r6 + "; slot=" + r2);
        return r6;
    }

    private TelephonyManager getNonDdsTm() {
        int r0 = getNonDdsSub();
        if (r0 != (-1)) goto L7;
        return null;
    L7:
        return TelephonyManager.from(this.mContext).createForSubscriptionId(r0);
    }

    public boolean isAvailable() {
        if (MultiSimAdapter.getPhoneCount() == 2) goto L6;
        OLog.e(TAG, "not a 2-SIM device");
        return false;
    L6:
        return true;
    }

    public boolean isChecked() {
        TelephonyManager r1 = getNonDdsTm();
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.isMobileDataPolicyEnabled(1);
    }

    public boolean setChecked(boolean r2) {
        TelephonyManager r1 = getNonDdsTm();
        if (r1 != null) goto L6;
        return false;
    L6:
        r1.setMobileDataPolicyEnabled(1, r2);
        return true;
    }
}
