package com.qualcomm.qti.internal.telephony;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.Registrant;
import android.os.RegistrantList;
import android.telephony.Rlog;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.data.PhoneSwitcher;
import com.android.internal.telephony.uicc.IccCardApplicationStatus;
import com.android.internal.telephony.uicc.IccCardStatus;
import com.android.internal.telephony.uicc.IccFileHandler;
import com.android.internal.telephony.uicc.IccRefreshResponse;
import com.android.internal.telephony.uicc.IccUtils;
import com.android.internal.telephony.uicc.UiccCard;
import com.android.internal.telephony.uicc.UiccCardApplication;
import com.android.internal.telephony.uicc.UiccController;
import com.android.internal.telephony.uicc.UiccPort;
import com.android.internal.telephony.uicc.UiccProfile;
import com.android.internal.telephony.uicc.UiccSlot;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class QtiUiccCardProvisioner extends Handler {
    private static final String ACTION_UICC_MANUAL_PROVISION_STATUS_CHANGED = "org.codeaurora.intent.action.ACTION_UICC_MANUAL_PROVISION_STATUS_CHANGED";
    private static final boolean DBG = true;
    private static final int EVENT_GET_ICCID_DONE = 4;
    private static final int EVENT_ICC_CHANGED = 1;
    private static final int EVENT_OEM_HOOK_SERVICE_READY = 3;
    private static final int EVENT_RADIO_AVAILABLE = 5;
    private static final int EVENT_RADIO_NOT_AVAILABLE = 7;
    private static final int EVENT_SIM_REFRESH = 6;
    private static final int EVENT_UNSOL_MANUAL_PROVISION_STATUS_CHANGED = 2;
    private static final String EXTRA_NEW_PROVISION_STATE = "newProvisionState";
    private static final int GENERIC_FAILURE = -1;
    private static final int INVALID_INPUT = -2;
    private static final String LOG_TAG = "QtiUiccCardProvisioner";
    private static final int REQUEST_IN_PROGRESS = -3;
    private static final int SUCCESS = 0;
    private static final boolean VDBG = false;
    private static int mNumPhones;
    private static AtomicBoolean mRequestInProgress;
    private static UiccController mUiccController;
    private static QtiUiccCardProvisioner sInstance;
    private static Object sManualProvLock;
    private IccCardStatus.CardState[] mCardState;
    private final CommandsInterface[] mCis;
    private Context mContext;
    private boolean[] mIsIccIdQueryPending;
    private RegistrantList mManualProvisionChangedRegistrants;
    private boolean mNeedSetDds;
    private UiccProvisionStatus[] mOldProvisionStatus;
    private UiccProvisionStatus[] mProvisionStatus;
    private QtiRilInterface mQtiRilInterface;
    private String[] mSimFullIccId;
    private String[] mSimIccId;

    public static class UiccProvisionStatus {
        public static final int CARD_NOT_PRESENT = -2;
        public static final int INVALID_STATE = -1;
        public static final int NOT_PROVISIONED = 0;
        public static final int PROVISIONED = 1;
        private int currentState;
        private int userPreference;

        UiccProvisionStatus() {
            this.userPreference = -1;
            this.currentState = -1;
        }

        boolean equals(UiccProvisionStatus r3) {
            if (r3.getUserPreference() == getUserPreference()) goto L5;
        L8:
            return false;
        L5:
            if (r3.getCurrentState() != getCurrentState()) goto L8;
            return true;
        }

        int getUserPreference() {
            return this.userPreference;
        }

        void setUserPreference(int r1) {
            this.userPreference = r1;
        }

        int getCurrentState() {
            return this.currentState;
        }

        void setCurrentState(int r1) {
            this.currentState = r1;
        }

        public String toString() {
            return "User pref " + this.userPreference + " Current pref " + this.currentState;
        }
    }

    static {
        sManualProvLock = new Object();
        mRequestInProgress = new AtomicBoolean(false);
    }

    public static QtiUiccCardProvisioner make(Context r1, CommandsInterface[] r2) {
        if (sInstance != null) goto L5;
        sInstance = new QtiUiccCardProvisioner(r1, r2);
    L7:
        return sInstance;
    L5:
        Log.wtf(LOG_TAG, "QtiUiccCardProvisioner.make() should be called once");
        goto L7
    }

    public static QtiUiccCardProvisioner make(Context r2) {
        if (sInstance != null) goto L5;
        sInstance = new QtiUiccCardProvisioner(r2, null);
    L7:
        return sInstance;
    L5:
        Log.wtf(LOG_TAG, "QtiUiccCardProvisioner.make() should be called once");
        goto L7
    }

    public void dispose() {
        logd(" disposing... ");
        mUiccController.unregisterForIccChanged(this);
        mUiccController = null;
        this.mQtiRilInterface.unRegisterForServiceReadyEvent(this);
        this.mQtiRilInterface.unRegisterForUnsol(this);
        this.mQtiRilInterface = null;
    }

    public static QtiUiccCardProvisioner getInstance() {
        if (sInstance != null) goto L6;
        Log.e(LOG_TAG, "QtiUiccCardProvisioner.getInstance called before make");
    L6:
        return sInstance;
    }

    private QtiUiccCardProvisioner(Context r5, CommandsInterface[] r6) {
        this.mManualProvisionChangedRegistrants = new RegistrantList();
        this.mNeedSetDds = false;
        this.mContext = r5;
        mNumPhones = ((TelephonyManager) r5.getSystemService("phone")).getPhoneCount();
        logd(" Invoking constructor, no of phones = " + mNumPhones);
        this.mCis = r6;
        int r7 = mNumPhones;
        this.mProvisionStatus = new UiccProvisionStatus[r7];
        this.mOldProvisionStatus = new UiccProvisionStatus[r7];
        this.mSimIccId = new String[r7];
        this.mSimFullIccId = new String[r7];
        this.mCardState = new IccCardStatus.CardState[r7];
        this.mIsIccIdQueryPending = new boolean[r7];
        int r8 = 0;
    L4:
        if (r8 >= mNumPhones) goto L6;
        this.mSimIccId[r8] = null;
        this.mSimFullIccId[r8] = null;
        this.mProvisionStatus[r8] = new UiccProvisionStatus();
        this.mCardState[r8] = IccCardStatus.CardState.CARDSTATE_ABSENT;
        this.mIsIccIdQueryPending[r8] = false;
        this.mOldProvisionStatus[r8] = new UiccProvisionStatus();
        this.mCis[r8].registerForAvailable(this, 5, Integer.valueOf(r8));
        this.mCis[r8].registerForNotAvailable(this, 7, Integer.valueOf(r8));
        this.mCis[r8].registerForIccRefresh(this, 6, Integer.valueOf(r8));
        r8 = r8 + 1;
        goto L4
    L6:
        UiccController r9 = UiccController.getInstance();
        mUiccController = r9;
        r9.registerForIccChanged(this, 1, null);
        QtiRilInterface r10 = QtiRilInterface.getInstance(r5);
        this.mQtiRilInterface = r10;
        r10.registerForServiceReadyEvent(this, 3, null);
        this.mQtiRilInterface.registerForUnsol(this, 2, null);
    }

    public void registerForManualProvisionChanged(Handler r2, int r3, Object r4) {
        Registrant r0 = new Registrant(r2, r3, r4);
        RegistrantList r5 = this.mManualProvisionChangedRegistrants;
        monitor-enter(r5);
        this.mManualProvisionChangedRegistrants.add(r0);     // Catch: Throwable -> L7
        r0.notifyRegistrant();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unregisterForManualProvisionChanged(Handler r2) {
        RegistrantList r0 = this.mManualProvisionChangedRegistrants;
        monitor-enter(r0);
        this.mManualProvisionChangedRegistrants.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler
    public void handleMessage(Message r7) {
        String r2 = null;
        switch(r7.what) {
            case 1: goto L74;
            case 2: goto L68;
            case 3: goto L60;
            case 4: goto L30;
            case 5: goto L14;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        loge("Error: hit default case " + r7.what);
        return;
    L5:
        logd(" Event RADIO_NOT_AVAILABLE ");
        this.mNeedSetDds = true;
        return;
    L6:
        AsyncResult r8 = (AsyncResult) r7.obj;
        if (r8 == null) goto L83;
        int r0 = ((Integer) r8.userObj).intValue();
        logd(" SIM refresh: " + r0);
        if (r8.result != null) goto L11;
        logd("SIM refresh Exception: " + r8.exception + " phoneId " + r0);
        return;
    L11:
        if (((IccRefreshResponse) r8.result).refreshResult != 2) goto L84;
        this.mSimIccId[r0] = null;
        this.mSimFullIccId[r0] = null;
        return;
    L84:
        return;
    L83:
        return;
    L14:
        AsyncResult r9 = (AsyncResult) r7.obj;
        if (r9 == null) goto L87;
        int r10 = ((Integer) r9.userObj).intValue();
        logd("RADIO_AVAILABLE for phone: " + r10);
        if (isAllCardProvisionInfoReceived() == false) goto L88;
        int[] r1 = QtiSubscriptionController.getInstance().getSubId(r10);
        if (r1 == null) goto L25;
        if (r1.length == 0) goto L25;
        if (QtiSubscriptionController.getInstance().isActiveSubId(r1[0]) == false) goto L25;
    L28:
        QtiSubscriptionController.getInstance().updateUserPreferences();
    L29:
        this.mCis[r10].unregisterForAvailable(this);
        return;
    L25:
        if (this.mSimIccId[r10] != null) goto L29;
        if (getCurrentProvisioningStatus(r10) != (-2)) goto L29;
    L88:
        return;
    L87:
        return;
    L30:
        AsyncResult r11 = (AsyncResult) r7.obj;
        if (r11 == null) goto L36;
        int r3 = ((Integer) r11.userObj).intValue();
        if (r11.result == null) goto L35;
        byte[] r12 = (byte[]) r11.result;
        String r4 = IccUtils.bchToString(r12, 0, r12.length);
        r2 = IccUtils.stripTrailingFs(r4);
        String r13 = r4;
    L38:
        if (r3 >= 0) goto L40;
        return;
    L40:
        if (r3 >= mNumPhones) goto L91;
        this.mIsIccIdQueryPending[r3] = false;
        if (TextUtils.isEmpty(r2) == true) goto L59;
        logi("SIM_IO add subInfo record, iccId[" + r3 + "] = " + r2);
        this.mSimFullIccId[r3] = r13;
        QtiSubscriptionInfoUpdater.getInstance().addSubInfoRecord(r3, r2);
        this.mSimIccId[r3] = r2;
        if (r2 != null) goto L46;
    L54:
        UiccProvisionStatus[] r14 = this.mOldProvisionStatus;
        if (r14 != null) goto L57;
        return;
    L57:
        if (r14[r3].equals(this.mProvisionStatus[r3]) == true) goto L93;
        logd(" broadcasting ProvisionInfo, phoneId = " + r3);
        broadcastManualProvisionStatusChanged(r3, getCurrentProvisioningStatus(r3));
        this.mOldProvisionStatus[r3] = this.mProvisionStatus[r3];
        return;
    L93:
        return;
    L46:
        if (isAllCardProvisionInfoReceived() == false) goto L54;
        SubscriptionManager r15 = (SubscriptionManager) this.mContext.getSystemService("telephony_subscription_service");
        int[] r5 = QtiSubscriptionController.getInstance().getSubId(r3);
        if (r5 == null) goto L54;
        if (r5.length == 0) goto L54;
        if (r15.isActiveSubscriptionId(r5[0]) == false) goto L54;
        QtiSubscriptionInfoUpdater.getInstance().updateUserPreferences();
        goto L54
    L59:
        logi(" EVENT_GET_ICCID_DONE, ICCID is empty, phoneId = " + r3);
        return;
    L91:
        return;
    L35:
        logd("Exception in GET iccId[" + r3 + "] " + r11.exception);
    L37:
        r13 = null;
        goto L38
    L36:
        r3 = -1;
        goto L37
    L60:
        AsyncResult r16 = (AsyncResult) r7.obj;
        if (r16 != null) goto L63;
    L67:
        loge("Error: empty result, EVENT_OEM_HOOK_SERVICE_READY");
        return;
    L63:
        if (r16.result == null) goto L67;
        if (((Boolean) r16.result).booleanValue() == false) goto L96;
        queryAllUiccProvisionInfo();
        return;
    L96:
        return;
    L68:
        org.codeaurora.telephony.utils.AsyncResult r17 = (org.codeaurora.telephony.utils.AsyncResult) r7.obj;
        if (r17 != null) goto L71;
    L73:
        loge("Error: empty result, UNSOL_MANUAL_PROVISION_STATUS_CHANGED");
        return;
    L71:
        if (r17.result == null) goto L73;
        handleUnsolManualProvisionEvent((Message) r17.result);
        return;
    L74:
        AsyncResult r18 = (AsyncResult) r7.obj;
        if (r18 != null) goto L77;
    L79:
        loge("Error: Invalid card index EVENT_ICC_CHANGED ");
        return;
    L77:
        if (r18.result == null) goto L79;
        updateIccAvailability(((Integer) r18.result).intValue());
    }

    private void handleUnsolManualProvisionEvent(Message r5) {
        if (r5 != null) goto L4;
    L16:
        loge("Null data received in handleUnsolManualProvisionEvent");
        return;
    L4:
        if (r5.obj == null) goto L16;
        ByteBuffer r0 = ByteBuffer.wrap((byte[]) r5.obj);
        r0.order(ByteOrder.nativeOrder());
        int r1 = r0.getInt();
        int r2 = r5.arg1;
        if (isValidSlotId(r2) == true) goto L9;
        return;
    L9:
        if (r1 != 525316) goto L19;
        logi(" Unsol: rspId " + r1 + " slotId " + r5.arg1);
        queryUiccProvisionInfo(r2, false);
        int r6 = SubscriptionManager.getSlotIndex(SubscriptionManager.getDefaultDataSubscriptionId());
        if (r2 == r6) goto L13;
        return;
    L13:
        if (getCurrentProvisioningStatus(r6) != 1) goto L21;
        logd("Set dds after SSR");
        setDdsIfRequired();
        return;
    L21:
        return;
    }

    private void queryAllUiccProvisionInfo() {
        int r0 = 0;
    L4:
        if (r0 >= mNumPhones) goto L11;
        logd(" query  provision info, card state[" + r0 + "] = " + this.mCardState[r0]);
        if (this.mCardState[r0] != IccCardStatus.CardState.CARDSTATE_PRESENT) goto L10;
        if (this.mIsIccIdQueryPending[r0] == true) goto L10;
        queryUiccProvisionInfo(r0, true);
    L10:
        r0 = r0 + 1;
        goto L4
    }

    public String getUiccIccId(int r1) {
        return this.mSimIccId[r1];
    }

    public String getUiccFullIccId(int r1) {
        return this.mSimFullIccId[r1];
    }

    private void queryUiccProvisionInfo(int r7, boolean r8) {
        if (this.mQtiRilInterface.isServiceReady() == true) goto L5;
    L61:
        logi("Oem hook service is not ready yet " + r7);
        return;
    L5:
        if (isValidSlotId(r7) == false) goto L61;
        UiccProvisionStatus r0 = this.mProvisionStatus[r7];
        UiccProvisionStatus r1 = this.mQtiRilInterface.getUiccProvisionPreference(r7);
        if (r1.getCurrentState() != (-1)) goto L10;
    L19:
        String r2 = getFullIccIdFromUicc(r7);
        String r3 = IccUtils.stripTrailingFs(r2);
        UiccCard r4 = mUiccController.getUiccCard(r7);
        UiccSlot r5 = mUiccController.getUiccSlotForPhone(r7);
        String r6 = this.mSimIccId[r7];
        if (r6 != null) goto L22;
    L23:
        if (r4 == null) goto L42;
        UiccProfile r9 = mUiccController.getUiccProfileForPhone(r7);
        if (r5 == null) goto L43;
        boolean r10 = r5.isEuicc();
        if (r9 == null) goto L43;
        if (r9.getNumApplications() != 0) goto L33;
        if (r10 == false) goto L33;
        logd("Can't addsubinforecord as num_apps 0 and slot is Euicc");
    L33:
        if (TextUtils.isEmpty(r3) == true) goto L35;
        this.mSimFullIccId[r7] = r2;
        QtiSubscriptionInfoUpdater.getInstance().addSubInfoRecord(r7, r3);
        this.mSimIccId[r7] = r3;
        goto L43
    L35:
        logd(" queryUiccProvisionInfo: useSimIORequest=  " + r8);
        if (r8 == false) goto L38;
        loadIccId(r7);
        goto L43
    L38:
        String r11 = this.mQtiRilInterface.getUiccIccId(r7);
        String r12 = IccUtils.stripTrailingFs(r11);
        if (TextUtils.isEmpty(r12) == true) goto L41;
        logi("OEM add subInfo record, iccId[" + r7 + "] = " + r12);
        this.mSimFullIccId[r7] = r11;
        QtiSubscriptionInfoUpdater.getInstance().addSubInfoRecord(r7, r12);
        this.mSimIccId[r7] = r12;
        goto L43
    L41:
        logi(" queryUiccProvisionInfo, ICCID[" + r7 + "] is null");
    L43:
        logd(" queryUiccProvisionInfo, iccId[" + r7 + "] = " + this.mSimIccId[r7] + " " + this.mProvisionStatus[r7]);
        if (r0.equals(this.mProvisionStatus[r7]) == false) goto L46;
        return;
    L46:
        if (this.mSimIccId[r7] != null) goto L48;
    L56:
        if (r8 == true) goto L58;
    L59:
        logd(" broadcasting ProvisionInfo, phoneId = " + r7);
        broadcastManualProvisionStatusChanged(r7, getCurrentProvisioningStatus(r7));
        this.mOldProvisionStatus[r7] = this.mProvisionStatus[r7];
        return;
    L58:
        if (this.mSimIccId[r7] != null) goto L59;
        return;
    L48:
        if (isAllCardProvisionInfoReceived() == false) goto L56;
        int[] r13 = QtiSubscriptionController.getInstance().getSubId(r7);
        SubscriptionManager r14 = (SubscriptionManager) this.mContext.getSystemService("telephony_subscription_service");
        if (r13 == null) goto L56;
        if (r13.length == 0) goto L56;
        if (r14.isActiveSubscriptionId(r13[0]) == false) goto L56;
        QtiSubscriptionInfoUpdater.getInstance().updateUserPreferences();
        goto L56
    L42:
        logi(" queryUiccProvisionInfo, uiccCard[" + r7 + "] object is null");
        goto L43
    L22:
        if (r6.equals(r3) == true) goto L43;
    L10:
        if (r1.getUserPreference() == (-1)) goto L19;
        Object r15 = sManualProvLock;
        monitor-enter(r15);
        this.mProvisionStatus[r7] = r1;     // Catch: Throwable -> L16
        monitor-exit(r15);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    private String getFullIccIdFromUicc(int r4) {
        UiccPort r0 = mUiccController.getUiccPort(r4);
        if (r0 == null) goto L5;
        String r1 = r0.getIccId();
    L6:
        logi(" queryUiccProvisionInfo, full iccId for " + r4 + "is " + r1);
        return r1;
    L5:
        logi(" queryUiccProvisionInfo, uiccPort[" + r4 + "] object is null");
        r1 = null;
        goto L6
    }

    private void loadIccId(int r7) {
        if (mUiccController.getUiccCard(r7) == null) goto L25;
        UiccProfile r0 = mUiccController.getUiccProfileForPhone(r7);
        if (r0 != null) goto L7;
        return;
    L7:
        int r1 = r0.getNumApplications();
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L15;
        UiccCardApplication r3 = r0.getApplicationIndex(r2);
        if (r3 == null) goto L14;
        if (r3.getType() == IccCardApplicationStatus.AppType.APPTYPE_UNKNOWN) goto L14;
    L16:
        if (r3 == null) goto L26;
        IccFileHandler r4 = r3.getIccFileHandler();
        if (r4 == null) goto L27;
        this.mIsIccIdQueryPending[r7] = true;
        r4.loadEFTransparent(12258, obtainMessage(4, Integer.valueOf(r7)));
        return;
    L27:
        return;
    L26:
        return;
    L14:
        r2 = r2 + 1;
        goto L8
    L15:
        r3 = null;
        goto L16
    }

    private void updateIccAvailability(int r6) {
        if (isValidSlotId(r6) == true) goto L6;
        loge("Invalid phone Index!!! " + r6);
        return;
    L6:
        IccCardStatus.CardState r0 = IccCardStatus.CardState.CARDSTATE_ABSENT;
        UiccSlot r1 = mUiccController.getUiccSlotForPhone(r6);
        if (r1 == null) goto L37;
        IccCardStatus.CardState r2 = r1.getCardState();
        logd("updateIccAvailability, card state[" + r6 + "] = " + r2);
        this.mCardState[r6] = r2;
        int r3 = getCurrentProvisioningStatus(r6);
        if (this.mCardState[r6] != IccCardStatus.CardState.CARDSTATE_PRESENT) goto L21;
        String r4 = this.mSimIccId[r6];
        if (r4 == null) goto L18;
        if (r4.equals(IccUtils.stripTrailingFs(getFullIccIdFromUicc(r6))) == false) goto L18;
        if (r3 == (-1)) goto L18;
        if (r3 != (-2)) goto L21;
    L18:
        if (this.mIsIccIdQueryPending[r6] == true) goto L21;
        queryUiccProvisionInfo(r6, true);
        return;
    L21:
        if (this.mCardState[r6] != IccCardStatus.CardState.CARDSTATE_ABSENT) goto L25;
        if (r1.isStateUnknown() == true) goto L25;
    L26:
        Object r5 = sManualProvLock;
        monitor-enter(r5);
        this.mProvisionStatus[r6].setUserPreference(-2);     // Catch: Throwable -> L33
        this.mProvisionStatus[r6].setCurrentState(-2);     // Catch: Throwable -> L33
        this.mOldProvisionStatus[r6].setUserPreference(-2);     // Catch: Throwable -> L33
        this.mOldProvisionStatus[r6].setCurrentState(-2);     // Catch: Throwable -> L33
        this.mSimIccId[r6] = null;     // Catch: Throwable -> L33
        this.mSimFullIccId[r6] = null;     // Catch: Throwable -> L33
        this.mManualProvisionChangedRegistrants.notifyRegistrants(new AsyncResult(null, Integer.valueOf(r6), null));     // Catch: Throwable -> L33
        monitor-exit(r5);     // Catch: Throwable -> L33
        if (isAllCardProvisionInfoReceived() == false) goto L42;
        QtiSubscriptionInfoUpdater.getInstance().updateUserPreferences();
        return;
    L42:
        return;
    L33:
        th = move-exception;
        throw th;
    L25:
        if (this.mCardState[r6] == IccCardStatus.CardState.CARDSTATE_ERROR) goto L26;
        return;
    L37:
        logd("updateIccAvailability, uicc card null, ignore " + r6);
    }

    private void broadcastManualProvisionStatusChanged(int r3, int r4) {
        Intent r0 = new Intent(ACTION_UICC_MANUAL_PROVISION_STATUS_CHANGED);
        r0.putExtra("phone", r3);
        r0.putExtra(EXTRA_NEW_PROVISION_STATE, r4);
        this.mContext.sendBroadcast(r0);
        this.mManualProvisionChangedRegistrants.notifyRegistrants(new AsyncResult(null, Integer.valueOf(r3), null));
    }

    private int getCurrentProvisioningStatus(int r3) {
        Object r0 = sManualProvLock;
        monitor-enter(r0);
        UiccSlot r1 = mUiccController.getUiccSlotForPhone(r3);     // Catch: Throwable -> L28
        if (r1 != null) goto L7;
    L25:
        int r2 = this.mProvisionStatus[r3].getCurrentState();     // Catch: Throwable -> L28
        monitor-exit(r0);     // Catch: Throwable -> L28
        return r2;
    L7:
        if (r1.isEuicc() == false) goto L25;
        logd("getCurrentProvisioningStatus for eUICC slot");     // Catch: Throwable -> L28
        if (this.mCardState[r3] != IccCardStatus.CardState.CARDSTATE_ABSENT) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L28
        return -2;
    L13:
        int[] r4 = QtiSubscriptionController.getInstance().getSubId(r3);     // Catch: Throwable -> L28
        int r5 = 0;
        if (r4 != null) goto L16;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L28
        return 0;
    L16:
        if (r4.length == 0) goto L23;
        if (QtiSubscriptionController.getInstance().isActiveSubId(r4[0]) == false) goto L21;
        r5 = 1;
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L28
        return r5;
    L28:
        th = move-exception;
        throw th;
    }

    public int getCurrentUiccCardProvisioningStatus(int r4) {
        if (canProcessRequest(r4) == false) goto L8;
        int r1 = 1;
        if (mNumPhones == 1) goto L9;
        r1 = getCurrentProvisioningStatus(r4);
    L9:
        logd(" getCurrentUiccCardProvisioningStatus, state[" + r4 + "] = " + r1);
        return r1;
    L8:
        r1 = -1;
        goto L9
    }

    public int getUiccCardProvisioningUserPreference(int r2) {
        if (canProcessRequest(r2) == false) goto L12;
        Object r0 = sManualProvLock;
        monitor-enter(r0);
        int r1 = this.mProvisionStatus[r2].getUserPreference();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    L12:
        return -1;
    }

    public int activateUiccCard(int r6) {
        logd(" activateUiccCard: phoneId = " + r6);
        int r1 = -1;
        if (this.mQtiRilInterface.isServiceReady() == true) goto L6;
        logi("Oem hook service is not ready yet " + r6);
        return -1;
    L6:
        enforceModifyPhoneState("activateUiccCard");
        if (canProcessRequest(r6) == true) goto L10;
        return -2;
    L10:
        if (this.mCis[r6].canToggleUiccApplicationsEnablement() == false) goto L13;
        loge("activateUiccCard is not appropriate to use. For 1.5 HAL use enableUiccApplications");
        return -1;
    L13:
        if (mNumPhones != 1) goto L16;
        loge("activateUiccCard is not supported for Single SIM with 1.4 HAL");
        return -1;
    L16:
        if (getCurrentProvisioningStatus(r6) != 1) goto L19;
        logd(" Uicc card in slot[" + r6 + "] already activated ");
        return 0;
    L19:
        if (mRequestInProgress.compareAndSet(false, true) == false) goto L32;
        boolean r0 = this.mQtiRilInterface.setUiccProvisionPreference(1, r6);
        if (r0 == false) goto L28;
        Object r2 = sManualProvLock;
        monitor-enter(r2);
        this.mProvisionStatus[r6].setCurrentState(1);     // Catch: Throwable -> L29
        monitor-exit(r2);     // Catch: Throwable -> L29
        r1 = 0;
    L29:
        th = move-exception;
        throw th;
    L28:
        logi(" activation result[" + r6 + "] = " + r0);
        mRequestInProgress.set(false);
        return r1;
    L32:
        return -3;
    }

    public int deactivateUiccCard(int r6) {
        logd(" deactivateUiccCard: phoneId = " + r6);
        int r1 = -1;
        if (this.mQtiRilInterface.isServiceReady() == true) goto L6;
        logi("Oem hook service is not ready yet " + r6);
        return -1;
    L6:
        enforceModifyPhoneState("deactivateUiccCard");
        if (canProcessRequest(r6) == true) goto L10;
        return -2;
    L10:
        if (this.mCis[r6].canToggleUiccApplicationsEnablement() == false) goto L13;
        loge("deactivateUiccCard is not appropriate to use. For 1.5 HAL use enableUiccApplications");
        return -1;
    L13:
        if (mNumPhones != 1) goto L16;
        loge("deactivateUiccCard is not supported for Single SIM with 1.4 HAL");
        return -1;
    L16:
        if (getCurrentProvisioningStatus(r6) != 0) goto L19;
        logd(" Uicc card in slot[" + r6 + "] already in deactive state ");
        return 0;
    L19:
        if (mRequestInProgress.compareAndSet(false, true) == false) goto L32;
        boolean r0 = this.mQtiRilInterface.setUiccProvisionPreference(0, r6);
        if (r0 == false) goto L28;
        Object r2 = sManualProvLock;
        monitor-enter(r2);
        this.mProvisionStatus[r6].setCurrentState(0);     // Catch: Throwable -> L29
        monitor-exit(r2);     // Catch: Throwable -> L29
        r1 = 0;
    L29:
        th = move-exception;
        throw th;
    L28:
        logi(" deactivation result[" + r6 + "] = " + r0);
        mRequestInProgress.set(false);
        return r1;
    L32:
        return -3;
    }

    private void enforceModifyPhoneState(String r2) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MODIFY_PHONE_STATE", r2);
    }

    private boolean canProcessRequest(int r3) {
        if (isValidSlotId(r3) == false) goto L5;
        return true;
    L5:
        loge("Request can't be processed, slotId " + r3 + " numPhones " + mNumPhones);
        return false;
    }

    private boolean isValidSlotId(int r1) {
        if (r1 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 >= mNumPhones) goto L6;
        return true;
    }

    public boolean isAnyProvisionRequestInProgress() {
        return mRequestInProgress.get();
    }

    public boolean isAllCardProvisionInfoReceived() {
        int r1 = 0;
    L4:
        if (r1 >= mNumPhones) goto L17;
        if (isEuiccHasEmptyProfiles(r1) == true) goto L15;
        int r2 = getCurrentProvisioningStatus(r1);
        if (r2 == (-1)) goto L16;
        if (this.mSimIccId[r1] == null) goto L15;
        if (r2 != (-2)) goto L15;
    L16:
        logd("isAllCardProvisionInfoReceived, prov pref[" + r1 + "] = " + r2);
        return false;
    L15:
        r1 = r1 + 1;
        goto L4
    L17:
        return true;
    }

    private boolean isEuiccHasEmptyProfiles(int r3) {
        UiccCard r0 = mUiccController.getUiccCard(r3);
        UiccSlot r1 = mUiccController.getUiccSlotForPhone(r3);
        if (r0 == null) goto L11;
        if (r1 == null) goto L11;
        UiccProfile r4 = mUiccController.getUiccProfileForPhone(r3);
        if (r4 == null) goto L11;
        boolean r2 = r1.isEuicc();
        if (r4.getNumApplications() != 0) goto L11;
        if (r2 == false) goto L11;
        logd("eUICC don't have active profiles");
        return true;
    L11:
        return false;
    }

    public void setDdsIfRequired() {
        int r0 = QtiSubscriptionController.getInstance().getDefaultDataSubId();
        int r1 = QtiSubscriptionController.getInstance().getPhoneId(r0);
        logd("setDdsIfRequired: ddsSub = " + r0 + " ddsPhone = " + r1 + " needSetDds = " + this.mNeedSetDds);
        if (QtiPhoneUtils.getInstance().isValidPhoneId(r1) == true) goto L5;
        return;
    L5:
        if (this.mNeedSetDds == false) goto L11;
        PhoneSwitcher.getInstance().onRadioCapChanged(r1);
        if (this.mNeedSetDds == false) goto L12;
        this.mNeedSetDds = false;
        return;
    L12:
        return;
    }

    private void logd(String r1) {
        Rlog.d(LOG_TAG, r1);
    }

    private void logi(String r1) {
        Rlog.i(LOG_TAG, r1);
    }

    private void loge(String r1) {
        Rlog.e(LOG_TAG, r1);
    }
}
