package com.qualcomm.qti.internal.telephony;

import android.os.AsyncResult;
import android.os.Message;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.GsmCdmaPhone;
import com.android.internal.telephony.NetworkRegistrationManager;
import com.android.internal.telephony.ServiceStateTracker;
import com.android.telephony.Rlog;

/* JADX INFO: loaded from: classes4.dex */
public class QtiServiceStateTracker extends ServiceStateTracker {
    protected static final int EVENT_POLL_STATE_CS_CELLULAR_REGISTRATION_FROM_CI = 101;
    protected static final int EVENT_POLL_STATE_PS_CELLULAR_REGISTRATION_FROM_CI = 102;
    private static final String LOG_TAG = "QtiServiceStateTracker";
    private boolean mIsImsCallingEnabled;
    private QtiCellularNetworkService mQtiCellularNetworkService;

    private String messageToString(int r1) {
        if (r1 != 101) goto L5;
        return ": EVENT_POLL_STATE_CS_CELLULAR_REGISTRATION_FROM_CI";
    L5:
        if (r1 == 102) goto L8;
        return "";
    L8:
        return ": EVENT_POLL_STATE_PS_CELLULAR_REGISTRATION_FROM_CI";
    }

    public QtiServiceStateTracker(GsmCdmaPhone r1, CommandsInterface r2) {
        super(r1, r2);
        this.mIsImsCallingEnabled = isImsCallingEnabled();
        this.mQtiCellularNetworkService = new QtiCellularNetworkService(r1.getPhoneId());
        log("QtiServiceStateTracker created");
    }

    public void handleMessage(Message r3) {
        log("handleMessage: received event " + r3.what);
        int r0 = r3.what;
        if (r0 != 48) goto L5;
        super.handleMessage(r3);
        boolean r4 = this.mIsImsCallingEnabled;
        this.mIsImsCallingEnabled = isImsCallingEnabled();
        if (this.mSS.getState() != 0) goto L13;
        return;
    L13:
        if (r4 == this.mIsImsCallingEnabled) goto L19;
        log("Notify service state as IMS caps will only affect the merged service state");
        this.mPhone.notifyServiceStateChanged(this.mPhone.getServiceState());
        return;
    L19:
        return;
    L5:
        if (r0 != 101) goto L7;
    L9:
        handlePollStateResult(r3.what, (AsyncResult) r3.obj);
        return;
    L7:
        if (r0 == 102) goto L9;
        super.handleMessage(r3);
    }

    protected void issuePollCommands() {
        if (this.mQtiCellularNetworkService == null) goto L11;
        if (isCellularNetworkServiceConnected() == true) goto L11;
        log("QTISST: issuePollCommands");
        int[] r0 = this.mPollingContext;
        r0[0] = r0[0] + 1;
        this.mCi.getOperator(obtainMessage(7, this.mPollingContext));
        int[] r1 = this.mPollingContext;
        r1[0] = r1[0] + 1;
        this.mCi.getDataRegistrationState(obtainMessage(102, this.mPollingContext));
        int[] r2 = this.mPollingContext;
        r2[0] = r2[0] + 1;
        this.mCi.getVoiceRegistrationState(obtainMessage(101, this.mPollingContext));
        if (this.mPhone.isPhoneTypeGsm() == false) goto L15;
        int[] r3 = this.mPollingContext;
        r3[0] = r3[0] + 1;
        this.mCi.getNetworkSelectionMode(obtainMessage(14, this.mPollingContext));
        return;
    L15:
        return;
    L11:
        if (this.mQtiCellularNetworkService == null) goto L13;
        this.mQtiCellularNetworkService = null;
        log("QTISST: discarding local service instance");
    L13:
        super.issuePollCommands();
    }

    private boolean isImsCallingEnabled() {
        if (this.mPhone != null) goto L5;
    L11:
        return false;
    L5:
        if (this.mPhone.isVolteEnabled() == false) goto L7;
    L10:
        return true;
    L7:
        if (this.mPhone.isWifiCallingEnabled() == true) goto L10;
        if (this.mPhone.isVideoEnabled() == false) goto L11;
        goto L10
    }

    private boolean isCellularNetworkServiceConnected() {
        return ((NetworkRegistrationManager) this.mRegStateManagers.get(1)).isServiceConnected();
    L5:
        e = move-exception;
        Rlog.e(LOG_TAG, "Exception checking for cellular network service connection", e);
        return true;
    }

    protected void handlePollStateResultMessage(int r4, AsyncResult r5) {
        log("QTISST: handlePollStateResultMessage processing " + r4 + messageToString(r4));
        if (r4 != 101) goto L5;
        QtiCellularNetworkService r6 = this.mQtiCellularNetworkService;
        if (r6 != null) goto L14;
        super.handlePollStateResultMessage(4, new AsyncResult(null, null, new IllegalStateException()));
        return;
    L14:
        super.handlePollStateResultMessage(4, new AsyncResult(null, r6.getRegistrationStateFromResult(r5.result, 1), null));
        return;
    L5:
        if (r4 == 102) goto L7;
        super.handlePollStateResultMessage(r4, r5);
        return;
    L7:
        QtiCellularNetworkService r7 = this.mQtiCellularNetworkService;
        if (r7 != null) goto L10;
        super.handlePollStateResultMessage(5, new AsyncResult(null, null, new IllegalStateException()));
        return;
    L10:
        super.handlePollStateResultMessage(5, new AsyncResult(null, r7.getRegistrationStateFromResult(r5.result, 2), null));
    }
}
