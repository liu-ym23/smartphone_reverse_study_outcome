package com.bytedanceos.datausage;

import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.obric.olog.OLog;
import com.obric.safecheck.util.serviceutil.EncryptPhoneToMd5Kt;

/* JADX INFO: loaded from: classes2.dex */
public class MultiSimAdapter {
    public static final String ICC_SUB_ID = "phone_id";
    public static final int SLOT1 = 0;
    public static final int SLOT2 = 1;
    public static final int SLOT_DEFAULT = 0;
    public static final int SLOT_INVALID = -1;
    public static final String TAG = "MultiSimAdapter";

    public MultiSimAdapter() {
    }

    public static String getSubscriberId(int slotId) {
        if (isVaildSlot(slotId) == false) goto L6;
        int r1 = slot2Sub(slotId);
        return TelephonyManager.getDefault().getSubscriberId(r1);
    L6:
        return "";
    }

    public static void sendMessage(int slotId, String content, String phoneNumber) {
        OLog.d(TAG, "sendMessage slotid " + slotId + ",phoneNumber " + EncryptPhoneToMd5Kt.calculateMD5(phoneNumber));
        if (bytedanceos.util.MultiSimAdapter.isMultiSimEnabled() == true) goto L6;
        slotId = 0;
    L6:
        if (isVaildSlot(slotId) == false) goto L9;
        int r10 = slot2Sub(slotId);
        SmsManager r4 = SmsManager.getSmsManagerForSubscriptionId(r10);
        OLog.d(TAG, "sendMessage mCurrentSlot 1, subId " + r10 + ",phoneNumber " + EncryptPhoneToMd5Kt.calculateMD5(phoneNumber));
        r4.sendTextMessage(phoneNumber, null, content, PendingIntent.getBroadcast(SecurityCenterApplication.getApplication().getApplicationContext(), 0, new Intent(), 67108864), null);
        return;
    }

    public static int slot2Sub(int slotId) {
        return bytedanceos.util.MultiSimAdapter.slot2Sub(slotId);
    }

    public static boolean isVaildSlot(int slotId) {
        if (bytedanceos.util.MultiSimAdapter.isMultiSimEnabled() == false) goto L8;
        if (slotId == 0) goto L7;
        if (slotId == 1) goto L7;
        return false;
    L7:
        return true;
    L8:
        if (slotId == 0) goto L10;
        return false;
    L10:
        return true;
    }
}
