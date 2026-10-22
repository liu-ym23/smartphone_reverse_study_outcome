package com.qualcomm.qti.internal.telephony.data;

import android.os.Looper;
import android.os.Message;
import android.telephony.SubscriptionManager;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneConstants;
import com.android.internal.telephony.data.DataNetworkController;
import com.android.internal.telephony.data.DataSettingsManager;
import com.android.internal.telephony.data.PhoneSwitcher;
import com.android.telephony.Rlog;

/* JADX INFO: loaded from: classes4.dex */
public class QtiDataSettingsManager extends DataSettingsManager {
    private static final int EVENT_ACTIVE_PHONE_SWITCH = 100;
    private static final int EVENT_INITIALIZE = 11;
    private static final int EVENT_SUBSCRIPTIONS_CHANGED = 4;
    private String mLogTag;
    private int mPhoneId;
    private QtiDataNetworkController mQtiDataNetworkController;
    private int mSubId;

    public QtiDataSettingsManager(Phone r1, DataNetworkController r2, Looper r3, DataSettingsManager.DataSettingsManagerCallback r4) {
        super(r1, r2, r3, r4);
        this.mLogTag = "QtiDSMGR-" + r1.getPhoneId();
        this.mQtiDataNetworkController = (QtiDataNetworkController) r2;
        this.mSubId = r1.getSubId();
        this.mPhoneId = r1.getPhoneId();
        log("Constructor ends");
    }

    public void handleMessage(Message r4) {
        log("handleMessage: " + r4.what);
        int r0 = r4.what;
        if (r0 != 4) goto L5;
        super.handleMessage(r4);
        int r5 = ((Integer) r4.obj).intValue();
        if (this.mSubId == r5) goto L21;
        this.mSubId = r5;
        sendDataDuringCall("EVENT_SUBSCRIPTIONS_CHANGED");
        return;
    L21:
        return;
    L5:
        if (r0 != 11) goto L7;
        super.handleMessage(r4);
        onInit();
        return;
    L7:
        if (r0 == 100) goto L9;
        super.handleMessage(r4);
        return;
    L9:
        sendDataDuringCall("EVENT_ACTIVE_PHONE_SWITCH");
        if (this.mPhone.getState() == PhoneConstants.State.IDLE) goto L18;
        updateDataEnabledAndNotify(4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void onInit() {
        log("onInit...");
        PhoneSwitcher.getInstance().registerForActivePhoneSwitch(this, 100, null);
    }

    private void sendDataDuringCall(String r3) {
        if (SubscriptionManager.isValidSubscriptionId(this.mSubId) == true) goto L7;
        log("sendDataDuringCall SUB ID is invalid");
        return;
    L7:
        if (this.mQtiDataNetworkController != null) goto L10;
        log("sendDataDuringCall mQtiDataNetworkController is null");
        return;
    L10:
        log("sendDataDuringCall mPhoneId = " + this.mPhoneId + " + mSubId = " + this.mSubId);
        this.mQtiDataNetworkController.evaluateAndSendDataDuringVoiceCallInfo(this.mPhoneId, r3);
    }

    private void log(String r1) {
        Rlog.d(this.mLogTag, r1);
    }
}
