package com.qualcomm.qti.internal.telephony;

import android.content.Context;
import android.os.AsyncResult;
import android.os.Looper;
import android.os.Message;
import android.telephony.Rlog;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneFactory;
import com.android.internal.telephony.RIL;
import com.android.internal.telephony.SubscriptionController;
import com.android.internal.telephony.SubscriptionInfoUpdater;
import com.android.internal.telephony.uicc.IccRefreshResponse;

/* JADX INFO: loaded from: classes4.dex */
public class QtiSubscriptionInfoUpdater extends SubscriptionInfoUpdater {
    private static final int EVENT_ADD_SUBINFO_RECORD = 100;
    private static final int EVENT_SIM_REFRESH = 101;
    private static final String ICCID_STRING_FOR_NO_SIM = "";
    private static final String LOG_TAG = "QtiSubscriptionInfoUpdater";
    private static final int SUPPORTED_MODEM_COUNT = 0;
    private static Context sContext;
    private static QtiSubscriptionInfoUpdater sInstance;
    private boolean[] mIsRecordUpdateRequired;

    static {
        SUPPORTED_MODEM_COUNT = TelephonyManager.getDefault().getSupportedModemCount();
        sInstance = null;
    }

    static QtiSubscriptionInfoUpdater init(Looper r3, Context r4, SubscriptionController r5) {
        monitor-enter(QtiSubscriptionInfoUpdater.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new QtiSubscriptionInfoUpdater(r3, r4, r5);     // Catch: Throwable -> L11
    L8:
        QtiSubscriptionInfoUpdater r6 = sInstance;     // Catch: Throwable -> L11
        monitor-exit(QtiSubscriptionInfoUpdater.class);     // Catch: Throwable -> L11
        return r6;
    L7:
        Log.wtf(LOG_TAG, "init() called multiple times!  sInstance = " + sInstance);     // Catch: Throwable -> L11
        goto L8
    }

    public static QtiSubscriptionInfoUpdater getInstance() {
        if (sInstance != null) goto L6;
        Log.wtf(LOG_TAG, "getInstance null");
    L6:
        return sInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private QtiSubscriptionInfoUpdater(Looper r3, Context r4, SubscriptionController r5) {
        super(r3, r4, r5);
        sContext = r4;
        this.mIsRecordUpdateRequired = new boolean[SUPPORTED_MODEM_COUNT];
        int r6 = 0;
    L4:
        if (r6 >= SUPPORTED_MODEM_COUNT) goto L9;
        this.mIsRecordUpdateRequired[r6] = false;
        Phone r7 = PhoneFactory.getPhone(r6);
        if (r7 == null) goto L8;
        r7.mCi.registerForIccRefresh(this, 101, new Integer(r6));
    L8:
        r6 = r6 + 1;
        goto L4
    }

    public void handleMessage(Message r4) {
        Rlog.d(LOG_TAG, " handleMessage: EVENT:  " + r4.what);
        int r0 = r4.what;
        if (r0 != 100) goto L5;
        handleAddSubInfoRecordEvent(r4.arg1, (String) r4.obj);
        return;
    L5:
        if (r0 == 101) goto L7;
        super.handleMessage(r4);
        return;
    L7:
        AsyncResult r3 = (AsyncResult) r4.obj;
        if (r3 == null) goto L18;
        Integer r5 = (Integer) r3.userObj;
        if (r3.result != null) goto L12;
        Rlog.d(LOG_TAG, "SIM refresh Exception: " + r3.exception + " phoneId " + r5);
        return;
    L12:
        if (((IccRefreshResponse) r3.result).refreshResult != 2) goto L19;
        sIccId[r5.intValue()] = null;
        return;
    L19:
        return;
    }

    void addSubInfoRecord(int r5, String r6) {
        if (r6 == null) goto L14;
        if (r5 < 0) goto L14;
        if (r5 >= SUPPORTED_MODEM_COUNT) goto L14;
        if (QtiPhoneUtils.getInstance().getCurrentUiccCardProvisioningStatus(r5) == 1) goto L12;
        Rlog.w(LOG_TAG, "sim not provisioned, ignore[" + r5 + "] = " + r6);
        return;
    L12:
        sendMessage(obtainMessage(100, r5, -1, r6));
        return;
    L14:
        Rlog.e(LOG_TAG, "addSubInfoRecord, invalid input IccId[" + r5 + "] = " + r6);
    }

    private synchronized void handleAddSubInfoRecordEvent(int r5, String r6) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (sIccId[r5] == null) goto L14;
        if (sIccId[r5].equals("") == true) goto L14;
        if (sIccId[r5].equals(r6) == false) goto L14;
        Rlog.d(LOG_TAG, "Record already exists ignore duplicate update, existing IccId = " + sIccId[r5] + " recvd iccId[" + r5 + "] = " + r6);     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L14:
        if (sIccId[r5] != null) goto L16;
    L19:
        this.mIsRecordUpdateRequired[r5] = true;     // Catch: Throwable -> L23
    L20:
        sIccId[r5] = r6;     // Catch: Throwable -> L23
        Rlog.d(LOG_TAG, " slotId = " + r5 + ", iccId = " + r6);     // Catch: Throwable -> L23
        updateSubscriptionInfoByIccId(r5, true);     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L16:
        if (sIccId[r5] == "") goto L19;
        if (sIccId[r5].equals(r6) == true) goto L20;
        goto L19
    }

    protected void handleSimReady(int r3) {
        if (sIccId[r3] != null) goto L5;
    L6:
        this.mIsRecordUpdateRequired[r3] = true;
    L7:
        super.handleSimReady(r3);
        return;
    L5:
        if (sIccId[r3] != "") goto L7;
        goto L6
    }

    protected void handleSimLoaded(int r3) {
        if (sIccId[r3] != null) goto L5;
    L6:
        this.mIsRecordUpdateRequired[r3] = true;
    L7:
        super.handleSimLoaded(r3);
        return;
    L5:
        if (sIccId[r3] != "") goto L7;
        goto L6
    }

    protected void handleSimLocked(int r3, String r4) {
        if (sIccId[r3] != null) goto L5;
    L6:
        this.mIsRecordUpdateRequired[r3] = true;
    L7:
        super.handleSimLocked(r3, r4);
        return;
    L5:
        if (sIccId[r3] != "") goto L7;
        goto L6
    }

    protected void handleSimAbsent(int r3) {
        if (sIccId[r3] != null) goto L5;
    L6:
        this.mIsRecordUpdateRequired[r3] = true;
    L7:
        super.handleSimAbsent(r3);
        return;
    L5:
        if (sIccId[r3] == "") goto L7;
        goto L6
    }

    protected void handleSimError(int r3) {
        if (sIccId[r3] != null) goto L5;
    L6:
        this.mIsRecordUpdateRequired[r3] = true;
    L7:
        super.handleSimError(r3);
        return;
    L5:
        if (sIccId[r3] == "") goto L7;
        goto L6
    }

    protected void handleSimNotReady(int r3) {
        if (sIccId[r3] != null) goto L5;
    L6:
        this.mIsRecordUpdateRequired[r3] = true;
    L7:
        super.handleSimNotReady(r3);
        return;
    L5:
        if (sIccId[r3] == "") goto L7;
        goto L6
    }

    protected boolean areUiccAppsDisabledOnCard(int r4) {
        TelephonyManager r3 = (TelephonyManager) sContext.getSystemService(TelephonyManager.class);
        if (QtiPhoneUtils.getInstance() == null) goto L12;
        if (r3 == null) goto L12;
        if (QtiPhoneUtils.getInstance().getCurrentUiccCardProvisioningStatus(r4) != 1) goto L11;
        if (r3.getSimState(r4) != 5) goto L11;
        return false;
    L11:
        return true;
    L12:
        Rlog.d(LOG_TAG, "QtiPhoneUtils or TelephonyManager instance is null");
        return false;
    }

    protected synchronized void updateSubscriptionInfoByIccId(int r5, boolean r6) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsRecordUpdateRequired[r5] != true) goto L14;
        super.updateSubscriptionInfoByIccId(r5, r6);     // Catch: Throwable -> L17
        Rlog.d(LOG_TAG, "SIM state changed, Updating user preference " + r5);     // Catch: Throwable -> L17
        if (PhoneFactory.getPhone(r5).getHalVersion().less(RIL.RADIO_HAL_VERSION_1_5) == true) goto L9;
    L13:
        this.mIsRecordUpdateRequired[r5] = false;     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return;
    L9:
        if (QtiUiccCardProvisioner.getInstance().isAllCardProvisionInfoReceived() == false) goto L13;
        if (isAllIccIdQueryDone() == false) goto L13;
        QtiSubscriptionController.getInstance().updateUserPreferences();     // Catch: Throwable -> L17
        goto L13
    L14:
        Rlog.d(LOG_TAG, "Ignoring subscription update event " + r5);     // Catch: Throwable -> L17
        goto L15
    }

    synchronized void updateUserPreferences() {
        monitor-enter(this);
        Rlog.d(LOG_TAG, " calling updateUserPreferences ");     // Catch: Throwable -> L8
        if (isAllIccIdQueryDone() == false) goto L6;
        QtiSubscriptionController.getInstance().updateUserPreferences();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
