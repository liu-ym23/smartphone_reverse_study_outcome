package com.qualcomm.qti.internal.telephony;

import android.content.Context;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.os.ResultReceiver;
import android.telephony.CarrierConfigManager;
import android.telephony.ImsiEncryptionInfo;
import android.telephony.NetworkScanRequest;
import android.telephony.Rlog;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.CarrierInfoManager;
import com.android.internal.telephony.CommandException;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneFactory;
import com.android.internal.telephony.PhoneInternalInterface;
import com.android.internal.telephony.PhoneNotifier;
import com.android.internal.telephony.RIL;
import com.android.internal.telephony.SubscriptionController;
import com.android.internal.telephony.TelephonyComponentFactory;
import com.android.internal.telephony.uicc.IccCardStatus;
import com.android.internal.telephony.uicc.IccRecords;
import com.android.internal.telephony.uicc.UiccPort;
import com.android.internal.telephony.uicc.UiccSlot;
import com.android.internal.telephony.vendor.VendorGsmCdmaPhone;
import com.qti.extphone.Client;
import com.qti.extphone.ExtTelephonyManager;
import com.qti.extphone.IExtPhoneCallback;
import com.qti.extphone.NetworkSelectionMode;
import com.qti.extphone.ServiceCallback;
import com.qti.extphone.Status;
import java.util.HashMap;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes4.dex */
public class QtiGsmCdmaPhone extends VendorGsmCdmaPhone {
    private static final int EVENT_ESSENTIAL_SIM_RECORDS_LOADED = 66;
    private static final int EVENT_QUERY_VONR_ENABLED_DONE = 67;
    private static final int EVENT_RESET_CARRIER_KEY_IMSI_ENCRYPTION = 65;
    private static final String LOG_TAG = "QtiGsmCdmaPhone";
    private static final int PROP_EVENT_START = 64;
    private int imsiToken;
    private IExtPhoneCallback mCallback;
    private Client mClient;
    private Context mContext;
    private ExtTelephonyManager mExtTelephonyManager;
    private boolean mIsInSecureMode;
    private Object mLock;
    private final HashMap<Integer, Message> mPendingRequests;
    private Client mQtiRadioConfigClient;
    private BaseRilInterface mQtiRilInterface;
    private ServiceCallback mServiceCallback;
    private TelephonyManager mTelephonyManager;

    /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ IExtPhoneCallback m650$$Nest$fgetmCallback(QtiGsmCdmaPhone r0) {
        return r0.mCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ Client m651$$Nest$fgetmClient(QtiGsmCdmaPhone r0) {
        return r0.mClient;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m652$$Nest$fgetmContext(QtiGsmCdmaPhone r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExtTelephonyManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ExtTelephonyManager m653$$Nest$fgetmExtTelephonyManager(QtiGsmCdmaPhone r0) {
        return r0.mExtTelephonyManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingRequests, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m654$$Nest$fgetmPendingRequests(QtiGsmCdmaPhone r0) {
        return r0.mPendingRequests;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmQtiRadioConfigClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ Client m655$$Nest$fgetmQtiRadioConfigClient(QtiGsmCdmaPhone r0) {
        return r0.mQtiRadioConfigClient;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m656$$Nest$fputmClient(QtiGsmCdmaPhone r0, Client r1) {
        r0.mClient = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsInSecureMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m657$$Nest$fputmIsInSecureMode(QtiGsmCdmaPhone r0, boolean r1) {
        r0.mIsInSecureMode = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmQtiRadioConfigClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m658$$Nest$fputmQtiRadioConfigClient(QtiGsmCdmaPhone r0, Client r1) {
        r0.mQtiRadioConfigClient = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mlogd, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m659$$Nest$mlogd(QtiGsmCdmaPhone r0, String r1) {
        r0.logd(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mloge, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m660$$Nest$mloge(QtiGsmCdmaPhone r0, String r1) {
        r0.loge(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monCheckForNetworkSelectionModeAutomatic, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m661$$Nest$monCheckForNetworkSelectionModeAutomatic(QtiGsmCdmaPhone r0, int r1, Message r2, Status r3, NetworkSelectionMode r4) {
        r0.onCheckForNetworkSelectionModeAutomatic(r1, r2, r3, r4);
    }

    public boolean isUsingNewDataStack() {
        return true;
    }

    public QtiGsmCdmaPhone(Context r9, CommandsInterface r10, PhoneNotifier r11, int r12, int r13, TelephonyComponentFactory r14) {
        this(r9, r10, r11, false, r12, r13, r14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QtiGsmCdmaPhone(Context r1, CommandsInterface r2, PhoneNotifier r3, boolean r4, int r5, int r6, TelephonyComponentFactory r7) {
        super(r1, r2, r3, r4, r5, r6, r7);
        this.imsiToken = 0;
        this.mIsInSecureMode = false;
        this.mLock = new Object();
        this.mPendingRequests = new HashMap();
        this.mServiceCallback = new AnonymousClass1(this);
        this.mCallback = new AnonymousClass2(this);
        this.mContext = r1;
        logd("Constructor");
        this.mQtiRilInterface = getQtiRilInterface();
        this.mCi.registerForCarrierInfoForImsiEncryption(this, 65, null);
        this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService(TelephonyManager.class);
        ExtTelephonyManager r8 = ExtTelephonyManager.getInstance(this.mContext);
        this.mExtTelephonyManager = r8;
        r8.connectService(this.mServiceCallback);
    }

    public boolean setLocalCallHold(boolean r2) {
        if (this.mQtiRilInterface.isServiceReady() == true) goto L7;
        loge("mQtiRilInterface is not ready yet");
        return false;
    L7:
        return this.mQtiRilInterface.setLocalCallHold(this.mPhoneId, r2);
    }

    public void dispose() {
        this.mQtiRilInterface = null;
        super.dispose();
    }

    public void handleMessage(Message r4) {
        logd("handleMessage: Event: " + r4.what);
        int r0 = r4.what;
        if (r0 == 3) goto L21;
        if (r0 != 23) goto L7;
        logd("Event EVENT_NV_READY Received");
        this.mSST.pollState();
        logd("notifyMessageWaitingChanged");
        this.mNotifier.notifyMessageWaitingChanged(this);
        updateVoiceMail();
        return;
    L7:
        if (r0 == 45) goto L18;
        switch(r0) {
            case 65: goto L17;
            case 66: goto L16;
            case 67: goto L10;
            default: goto L9;
        };
    L9:
        super.handleMessage(r4);
        return;
    L10:
        AsyncResult r3 = (AsyncResult) r4.obj;
        if (r3 != null) goto L13;
        return;
    L13:
        if (r3.exception != null) goto L32;
        Rlog.d(LOG_TAG, "Event EVENT_QUERY_VONR_ENABLED_DONE Received: " + ((Boolean) r3.result).booleanValue());
        return;
    L32:
        return;
    L16:
        logd("Event EVENT_ESSENTIAL_SIM_RECORDS_LOADED Received");
        handleEssentialRecordsLoaded();
        return;
    L17:
        logd("Event EVENT_RESET_CARRIER_KEY_IMSI_ENCRYPTION");
        super.resetCarrierKeysForImsiEncryption();
        return;
    L18:
        Rlog.d(LOG_TAG, "Event EVENT_MODEM_RESET Received");
        ScbmHandler.getInstance().handleModemReset();
        super.handleMessage(r4);
        return;
    L21:
        if (isPhoneTypeGsm() == false) goto L23;
        logd("notify call forward indication, phone id:" + this.mPhoneId);
        notifyCallForwardingIndicator();
    L23:
        super.handleMessage(r4);
    }

    private BaseRilInterface getQtiRilInterface() {
        if (getUnitTestMode() == false) goto L6;
        logd("getQtiRilInterface, unitTestMode = true");
        return SimulatedQtiRilInterface.getInstance(this.mContext);
    L6:
        return QtiRilInterface.getInstance(this.mContext);
    }

    public void setCarrierInfoForImsiEncryption(ImsiEncryptionInfo r3) {
        Phone r0 = PhoneFactory.getPhone(this.mPhoneId);
        if (r0 != null) goto L5;
    L7:
        CarrierInfoManager.setCarrierInfoForImsiEncryption(r3, this.mContext, this.mPhoneId);
        QtiRIL r1 = QtiTelephonyComponentFactory.getInstance().getRil(this.mPhoneId);
        int r2 = this.imsiToken + 1;
        this.imsiToken = r2;
        r1.setCarrierInfoForImsiEncryption(r2, r3);
        return;
    L5:
        if (r0.getHalVersion().greaterOrEqual(RIL.RADIO_HAL_VERSION_1_6) == false) goto L7;
        super.setCarrierInfoForImsiEncryption(r3);
    }

    public String getFullIccSerialNumber() {
        String r0 = super.getFullIccSerialNumber();
        if (TextUtils.isEmpty(r0) == false) goto L10;
        UiccPort r2 = this.mUiccController.getUiccPort(this.mPhoneId);
        if (r2 != null) goto L7;
        String r3 = null;
    L9:
        return r3;
    L7:
        r3 = r2.getIccId();
        goto L9
    L10:
        return r0;
    }

    private void handleEssentialRecordsLoaded() {
        logd("handleEssentialRecordsLoaded, mPhoneId: " + this.mPhoneId);
        resolveSubscriptionCarrierId("LOADED");
        ((CarrierConfigManager) this.mContext.getSystemService("carrier_config")).updateConfigForPhoneId(this.mPhoneId, "ESSENTIAL_LOADED");
        if (isUsingNewDataStack() == false) goto L5;
        getDataNetworkController().setEssentialRecordsLoaded(true);
        return;
    L5:
        int[] r0 = this.mAccessNetworksManager.getAvailableTransports();
        int r2 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L15;
        int r4 = r0[r3];
        if (getDcTracker(r4) == null) goto L10;
        getDcTracker(r4).setEssentialRecordsLoaded(true);
    L10:
        r3 = r3 + 1;
        goto L6
    }

    public void onCarrierConfigLoadedForEssentialRecords() {
        logd("onCarrierConfigLoadedForEssentialRecords");
        if (isUsingNewDataStack() == false) goto L5;
        getDataNetworkController().onCarrierConfigLoadedForEssentialRecords();
        return;
    L5:
        int[] r0 = this.mAccessNetworksManager.getAvailableTransports();
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L15;
        int r3 = r0[r2];
        if (getDcTracker(r3) == null) goto L10;
        getDcTracker(r3).onCarrierConfigLoadedForEssentialRecords();
    L10:
        r2 = r2 + 1;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void registerForIccRecordEvents() {
        QtiServiceStateTracker r0 = (QtiServiceStateTracker) this.mSST;
        IccRecords r1 = (IccRecords) this.mIccRecords.get();
        if (r1 == null) goto L5;
        logd("registerForEssentialRecordsLoaded");
        r1.registerForEssentialRecordsLoaded(this, 66, null);
    L5:
        super.registerForIccRecordEvents();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void unregisterForIccRecordEvents() {
        QtiServiceStateTracker r0 = (QtiServiceStateTracker) this.mSST;
        IccRecords r1 = (IccRecords) this.mIccRecords.get();
        if (r1 == null) goto L5;
        logd("unregisterForEssentialRecordsLoaded");
        r1.unregisterForEssentialRecordsLoaded(this);
    L5:
        super.unregisterForIccRecordEvents();
    }

    public void setSmartTempDdsSwitchSupported(boolean r1) {
        this.mSmartTempDdsSwitchSupported = r1;
    }

    public boolean getSmartTempDdsSwitchSupported() {
        return this.mSmartTempDdsSwitchSupported;
    }

    public void setTelephonyTempDdsSwitch(boolean r1) {
        this.mTelephonyTempDdsSwitch = r1;
    }

    public boolean getTelephonyTempDdsSwitch() {
        return this.mTelephonyTempDdsSwitch;
    }

    protected void updateVoNrSettings(PersistableBundle r5) {
        UiccSlot r0 = this.mUiccController.getUiccSlotForPhone(this.mPhoneId);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getCardState() != IccCardStatus.CardState.CARDSTATE_PRESENT) goto L27;
        if (r5 != null) goto L10;
        loge("didn't get the vonr_enabled_bool from the carrier config.");
        return;
    L10:
        boolean r6 = r5.getBoolean("vonr_enabled_bool");
        String r1 = SubscriptionController.getInstance().getSubscriptionProperty(getSubId(), "nr_advanced_calling_enabled");
        if (r1 == null) goto L13;
        int r2 = Integer.parseInt(r1);
    L14:
        logd("VoNR setting from telephony.db:" + r2 + " ,vonr_enabled_bool:" + r6);
        if (r2 != (-1)) goto L18;
        this.mCi.isVoNrEnabled(obtainMessage(67), null);
        return;
    L18:
        if (r2 != 1) goto L20;
        this.mCi.setVoNrEnabled(true, obtainMessage(61), null);
        return;
    L20:
        if (r2 != 0) goto L26;
        this.mCi.setVoNrEnabled(false, obtainMessage(61), null);
        return;
    L26:
        return;
    L13:
        r2 = -1;
        goto L14
    }

    public boolean isInScbm() {
        return ScbmHandler.getInstance().isInScbm();
    }

    public void exitScbm() {
        ScbmHandler.getInstance().exitScbm();
    }

    public void setOnScbmExitResponse(Handler r1, int r2, Object r3) {
        ScbmHandler.getInstance().setOnScbmExitResponse(r1, r2, r3);
    }

    public void unsetOnScbmExitResponse(Handler r1) {
        ScbmHandler.getInstance().unsetOnScbmExitResponse(r1);
    }

    public void registerForScbmTimerReset(Handler r1, int r2, Object r3) {
        ScbmHandler.getInstance().registerForScbmTimerReset(r1, r2, r3);
    }

    public void unregisterForScbmTimerReset(Handler r1) {
        ScbmHandler.getInstance().unregisterForScbmTimerReset(r1);
    }

    public boolean isInScbm(int r1) {
        return ScbmHandler.getInstance().isInScbm(r1);
    }

    public boolean isExitScbmFeatureSupported() {
        return ScbmHandler.getInstance().isExitScbmFeatureSupported();
    }

    public boolean isScbmTimerCanceledForEmergency() {
        return ScbmHandler.getInstance().isScbmTimerCanceledForEmergency();
    }

    void notifySubInfoAdded() {
        logd("notifySubInfoAdded, query IMEI");
        this.mCi.getDeviceIdentity(obtainMessage(21));
    }

    public void acceptCall(int r4) throws CallStateException {
        boolean r0 = this.mTelephonyManager.getEmergencyCallbackMode();
        logd("acceptCall: mIsInSecureMode = " + this.mIsInSecureMode + ", isInEcbm = " + r0);
        if (this.mIsInSecureMode == false) goto L8;
        if (r0 == true) goto L8;
        throw new CallStateException(9, "Secure Mode");
    L8:
        super.acceptCall(r4);
    }

    public Connection dial(String r4, PhoneInternalInterface.DialArgs r5, Consumer<Phone> r6) throws CallStateException {
        boolean r0 = getEmergencyNumberTracker().isEmergencyNumber(r4, true);
        logd("dial: mIsInSecureMode = " + this.mIsInSecureMode + ", isEmergency = " + r0);
        if (this.mIsInSecureMode == false) goto L9;
        if (r0 == true) goto L9;
        throw new CallStateException(9, "Secure Mode");
    L9:
        return super.dial(r4, r5, r6);
    }

    public void startNetworkScan(NetworkScanRequest r3, Message r4) {
        logd("startNetworkScan: mIsInSecureMode = " + this.mIsInSecureMode);
        if (this.mIsInSecureMode == true) goto L5;
        super.startNetworkScan(r3, r4);
        return;
    L5:
        AsyncResult.forMessage(r4, null, CommandException.fromRilErrno(54));
        r4.sendToTarget();
    }

    public boolean handleUssdRequest(String r3, ResultReceiver r4) {
        logd("handleUssdRequest: mIsInSecureMode = " + this.mIsInSecureMode);
        if (this.mIsInSecureMode == false) goto L5;
        sendUssdResponse(r3, null, -1, r4);
        return false;
    L5:
        return super.handleUssdRequest(r3, r4);
    }

    public void setNetworkSelectionModeAutomatic(Message r7) {
        logd("setNetworkSelectionModeAutomatic, querying current mode");
        if (QtiTelephonyComponentFactory.getInstance().getRil(this.mPhoneId).isCagSnpnEnabled() == false) goto L27;
        Object r2 = this.mLock;
        monitor-enter(r2);
        int r1 = this.mExtTelephonyManager.getNetworkSelectionMode(this.mPhoneId, this.mClient).get();     // Catch: Throwable -> L8 RuntimeException -> L10
    L12:
        HashMap<Integer, Message> r3 = this.mPendingRequests;     // Catch: Throwable -> L8
        monitor-enter(r3);     // Catch: Throwable -> L8
        this.mPendingRequests.put(Integer.valueOf(r1), r7);     // Catch: Throwable -> L22
        monitor-exit(r3);     // Catch: Throwable -> L22
    L33:
        this.mLock.wait();     // Catch: Throwable -> L8 Exception -> L18
    L20:
        monitor-exit(r2);     // Catch: Throwable -> L8
        return;
    L18:
        e = move-exception;
        logd("Exception :" + e);     // Catch: Throwable -> L8
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L10:
        e = move-exception;
        logd("Exception getNetworkSelectionMode " + e);     // Catch: Throwable -> L8
        r1 = 0;
    L8:
        th = move-exception;
        throw th;
    L27:
        super.setNetworkSelectionModeAutomatic(r7);
    }

    private void onCheckForNetworkSelectionModeAutomatic(int r3, Message r4, Status r5, NetworkSelectionMode r6) {
        AsyncResult r7 = new AsyncResult(r4, r6, null);
        int r0 = QtiTelephonyComponentFactory.getInstance().getRil(this.mPhoneId).getAccessMode();
        if (r5.get() == 1) goto L27;
    L9:
        boolean r8 = true;
    L10:
        Object r9 = this.mLock;
        monitor-enter(r9);
        this.mLock.notify();     // Catch: Throwable -> L23
        monitor-exit(r9);     // Catch: Throwable -> L23
        Phone.NetworkSelectMessage r10 = new Phone.NetworkSelectMessage();
        r10.message = r4;
        r10.operatorNumeric = "";
        r10.operatorAlphaLong = "";
        r10.operatorAlphaShort = "";
        if (r8 == false) goto L17;
        this.mCi.setNetworkSelectionModeAutomatic(obtainMessage(17, r10));
    L21:
        updateSavedNetworkOperator(r10);
        return;
    L17:
        Rlog.d(LOG_TAG, "setNetworkSelectionModeAutomatic - already auto, ignoring");
        if (r10.message == null) goto L20;
        r10.message.arg1 = 1;
    L20:
        r7.userObj = r10;
        handleSetSelectNetwork(r7);
    L23:
        th = move-exception;
        throw th;
    L27:
        if (r6.getIsManual() == true) goto L9;
        if (r6.getAccessMode() != r0) goto L9;
        r8 = false;
        goto L10
    }

    private void logd(String r3) {
        Rlog.d(LOG_TAG, "[" + this.mPhoneId + " ] " + r3);
    }

    private void loge(String r3) {
        Rlog.e(LOG_TAG, "[" + this.mPhoneId + " ] " + r3);
    }
}
