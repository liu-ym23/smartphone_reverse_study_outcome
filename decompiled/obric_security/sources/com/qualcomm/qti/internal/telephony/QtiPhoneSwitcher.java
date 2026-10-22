package com.qualcomm.qti.internal.telephony;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.telephony.Rlog;
import android.telephony.SubscriptionManager;
import androidx.core.app.NotificationCompat;
import com.android.internal.telephony.Call;
import com.android.internal.telephony.CommandException;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneFactory;
import com.android.internal.telephony.data.PhoneSwitcher;
import com.qti.extphone.Client;
import com.qti.extphone.ExtPhoneCallbackBase;
import com.qti.extphone.ExtTelephonyManager;
import com.qti.extphone.IExtPhoneCallback;
import com.qti.extphone.ServiceCallback;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Set;
import org.codeaurora.telephony.utils.AsyncResult;

/* JADX INFO: loaded from: classes4.dex */
public class QtiPhoneSwitcher extends PhoneSwitcher {
    private static final int DEFAULT_PHONE_INDEX = 0;
    private static final int RECONNECT_EXT_TELEPHONY_SERVICE_DELAY_MILLISECOND = 2000;
    private final int NONUSER_INITIATED_SWITCH;
    private final int USER_INITIATED_SWITCH;
    protected IExtPhoneCallback mCallback;
    private Client mClient;
    private ExtTelephonyManager mExtTelephonyManager;
    private QtiRilInterface mQtiRilInterface;
    private ServiceCallback mServiceCallback;

    /* JADX INFO: renamed from: com.qualcomm.qti.internal.telephony.QtiPhoneSwitcher$2, reason: invalid class name */
    class AnonymousClass2 extends ExtPhoneCallbackBase {
        final /* synthetic */ QtiPhoneSwitcher this$0;

        AnonymousClass2(QtiPhoneSwitcher r1) {
            this.this$0 = r1;
        }

        public void onDdsSwitchCriteriaChange(final int r4, final boolean r5) throws RemoteException {
            QtiPhoneSwitcher.access$400(this.this$0, "ExtPhoneCallback: onDdsSwitchCriteriaChange: " + r5 + " slotId: " + r4);
            if (SubscriptionManager.isValidPhoneId(r4) == true) goto L5;
            return;
        L5:
            this.this$0.post(new QtiPhoneSwitcher$2$$ExternalSyntheticLambda0(this, r4, r5));
        }

        /* JADX INFO: renamed from: lambda$onDdsSwitchCriteriaChange$0$com-qualcomm-qti-internal-telephony-QtiPhoneSwitcher$2, reason: not valid java name */
        /* synthetic */ void m667x8abe932d(int r5, boolean r6) {
            Phone r0 = PhoneFactory.getPhone(r5);
            if (r0 == null) goto L22;
            boolean r2 = true;
            if (r0.isUsingNewDataStack() == false) goto L11;
            if (r6 == true) goto L8;
        L10:
            boolean r7 = false;
        L15:
            if (r7 == true) goto L17;
        L19:
            r2 = false;
        L20:
            QtiPhoneSwitcher.access$1000(this.this$0, "Enable telephony temp DDS " + r2 + " on slot " + r5);
            r0.setTelephonyTempDdsSwitch(r2);
            return;
        L17:
            if (QtiPhoneSwitcher.m666$$Nest$misTelTempDdsSwitchSatisfiedWithDdsSubSituation(this.this$0) == false) goto L19;
        L8:
            if (r0.getDataSettingsManager().isDataAllowedInVoiceCall() == false) goto L10;
        L9:
            r7 = true;
            goto L15
        L11:
            if (r6 == false) goto L10;
            if (r0.getDataEnabledSettings().isDataAllowedInVoiceCall() == false) goto L10;
        }

        public void onDdsSwitchRecommendation(int r3, final int r4) throws RemoteException {
            QtiPhoneSwitcher.access$500(this.this$0, "ExtPhoneCallback: onDdsSwitchRecommendation, recommendedSlotId: " + r4);
            if (SubscriptionManager.isValidPhoneId(r4) == true) goto L5;
            return;
        L5:
            this.this$0.post(new QtiPhoneSwitcher$2$$ExternalSyntheticLambda1(this, r4));
        }

        /* JADX INFO: renamed from: lambda$onDdsSwitchRecommendation$1$com-qualcomm-qti-internal-telephony-QtiPhoneSwitcher$2, reason: not valid java name */
        /* synthetic */ void m668xcb94e182(int r2) {
            if (QtiPhoneSwitcher.m665$$Nest$mgetPrimaryDataPhoneId(this.this$0) != r2) goto L7;
            QtiPhoneSwitcher.access$602(this.this$0, -1);
            if (QtiPhoneSwitcher.access$700(this.this$0) == null) goto L8;
            QtiPhoneSwitcher.access$800(this.this$0, "Precise call state simulates");
            QtiPhoneSwitcher r3 = this.this$0;
            r3.sendMessage(r3.obtainMessage(109));
        L8:
            this.this$0.onEvaluate(false, NotificationCompat.CATEGORY_RECOMMENDATION);
            return;
        L7:
            QtiPhoneSwitcher.access$902(this.this$0, r2);
            goto L8
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ Client m662$$Nest$fgetmClient(QtiPhoneSwitcher r0) {
        return r0.mClient;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExtTelephonyManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ExtTelephonyManager m663$$Nest$fgetmExtTelephonyManager(QtiPhoneSwitcher r0) {
        return r0.mExtTelephonyManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m664$$Nest$fputmClient(QtiPhoneSwitcher r0, Client r1) {
        r0.mClient = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetPrimaryDataPhoneId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m665$$Nest$mgetPrimaryDataPhoneId(QtiPhoneSwitcher r0) {
        return r0.getPrimaryDataPhoneId();
    }

    /* JADX INFO: renamed from: -$$Nest$misTelTempDdsSwitchSatisfiedWithDdsSubSituation, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m666$$Nest$misTelTempDdsSwitchSatisfiedWithDdsSubSituation(QtiPhoneSwitcher r0) {
        return r0.isTelTempDdsSwitchSatisfiedWithDdsSubSituation();
    }

    static /* synthetic */ void access$000(QtiPhoneSwitcher r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ Context access$100(QtiPhoneSwitcher r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$1000(QtiPhoneSwitcher r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ void access$200(QtiPhoneSwitcher r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ void access$300(QtiPhoneSwitcher r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ void access$400(QtiPhoneSwitcher r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ void access$500(QtiPhoneSwitcher r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ int access$602(QtiPhoneSwitcher r0, int r1) {
        r0.mPhoneIdInVoiceCall = r1;
        return r1;
    }

    static /* synthetic */ PhoneSwitcher.EmergencyOverrideRequest access$700(QtiPhoneSwitcher r0) {
        return r0.mEmergencyOverride;
    }

    static /* synthetic */ void access$800(QtiPhoneSwitcher r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ int access$902(QtiPhoneSwitcher r0, int r1) {
        r0.mPhoneIdInVoiceCall = r1;
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QtiPhoneSwitcher(int r1, Context r2, Looper r3) {
        super(r1, r2, r3);
        this.USER_INITIATED_SWITCH = 0;
        this.NONUSER_INITIATED_SWITCH = 1;
        this.mServiceCallback = new AnonymousClass1(this);
        this.mCallback = new AnonymousClass2(this);
        QtiRilInterface r4 = QtiRilInterface.getInstance(r2);
        this.mQtiRilInterface = r4;
        r4.registerForUnsol(this, 122, null);
        ExtTelephonyManager r5 = ExtTelephonyManager.getInstance(this.mContext);
        this.mExtTelephonyManager = r5;
        r5.connectService(this.mServiceCallback);
    }

    public static QtiPhoneSwitcher make(int r1, Context r2, Looper r3) {
        if (sPhoneSwitcher != null) goto L6;
        sPhoneSwitcher = new QtiPhoneSwitcher(r1, r2, r3);
    L6:
        return (QtiPhoneSwitcher) sPhoneSwitcher;
    }

    private boolean isTelTempDdsSwitchSatisfiedWithDdsSubSituation() {
        Phone r0 = PhoneFactory.getPhone(getPrimaryDataPhoneId());
        if (r0 == null) goto L13;
        boolean r1 = r0.getServiceState().getDataRoaming();
        boolean r2 = r0.getDataRoamingEnabled();
        if (r0.isUsingNewDataStack() == false) goto L7;
        boolean r3 = r0.getDataSettingsManager().isDataEnabledForReason(0);
    L8:
        log("DDS SUB: isDataEnabled = " + r3 + " isDataRoaming = " + r1 + " isRoamingDataEnabled = " + r2);
        if (r3 == false) goto L12;
        if (r1 == false) goto L15;
        if (r2 == false) goto L12;
        return true;
    L15:
        return true;
    L12:
        return false;
    L7:
        r3 = r0.getDataEnabledSettings().isDataEnabled();
        goto L8
    L13:
        return true;
    }

    private void queryMaxDataAllowed() {
        this.mMaxDataAttachModemCount = this.mQtiRilInterface.getMaxDataAllowed();
    }

    private void handleUnsolMaxDataAllowedChange(Message r3) {
        if (r3 != null) goto L4;
    L14:
        log("Null data received in handleUnsolMaxDataAllowedChange");
        return;
    L4:
        if (r3.obj == null) goto L14;
        ByteBuffer r4 = ByteBuffer.wrap((byte[]) r3.obj);
        r4.order(ByteOrder.nativeOrder());
        if (r4.getInt() != 525342) goto L16;
        int r0 = r4.getInt();
        if (r0 >= 0) goto L12;
        log("Response size is Invalid " + r0);
        return;
    L12:
        this.mMaxDataAttachModemCount = r4.get();
        log(" Unsol Max Data Changed to: " + this.mMaxDataAttachModemCount);
        return;
    }

    public void handleMessage(Message r3) {
        this.mSubscriptionController.getPhoneId(this.mSubscriptionController.getDefaultDataSubId());
        log("handle event - " + r3.what);
        int r0 = r3.what;
        if (r0 == 108) goto L15;
        if (r0 != 122) goto L7;
        AsyncResult r4 = (AsyncResult) r3.obj;
        if (r4.result == null) goto L13;
        handleUnsolMaxDataAllowedChange((Message) r4.result);
        return;
    L13:
        log("Error: empty result, EVENT_UNSOL_MAX_DATA_ALLOWED_CHANGED");
        return;
    L7:
        if (r0 == 125) goto L9;
        super.handleMessage(r3);
        return;
    L9:
        log("EVENT_RECONNECT_EXT_TELEPHONY_SERVICE");
        this.mExtTelephonyManager.connectService(this.mServiceCallback);
        return;
    L15:
        if (this.mQtiRilInterface.isServiceReady() == false) goto L17;
        queryMaxDataAllowed();
    L18:
        super.handleMessage(r3);
        return;
    L17:
        log("Oem hook service is not ready");
        goto L18
    }

    private int getPrimaryDataPhoneId() {
        if (SubscriptionManager.isValidSubscriptionId(this.mPrimaryDataSubId) == true) goto L7;
        return -1;
    L7:
        return this.mSubscriptionController.getPhoneId(this.mPrimaryDataSubId);
    }

    private void informDdsToRil(int r5) {
        int r6 = this.mSubscriptionController.getPhoneId(r5);
        if (this.mQtiRilInterface.isServiceReady() == true) goto L7;
        log("Oem hook service is not ready yet");
        return;
    L7:
        if (updateHalCommandToUse() == true) goto L10;
        log("sendRilCommands: waiting for HAL command update, may be radio is unavailable");
        return;
    L10:
        int r1 = 0;
    L12:
        if (r1 >= this.mActiveModemCount) goto L18;
        log("InformDdsToRil rild= " + r1 + ", DDS=" + r6);
        if (isCallInProgress() == false) goto L16;
        this.mQtiRilInterface.qcRilSendDDSInfo(r6, 1, r1);
    L17:
        r1 = r1 + 1;
        goto L12
    L16:
        this.mQtiRilInterface.qcRilSendDDSInfo(r6, 0, r1);
        goto L17
    }

    private boolean isCallInProgress() {
        return SubscriptionManager.isValidPhoneId(this.mPhoneIdInVoiceCall);
    }

    protected boolean onEvaluate(boolean r2, String r3) {
        if (updateHalCommandToUse() == true) goto L7;
        log("Wait for HAL command update");
        return false;
    L7:
        return super.onEvaluate(r2, r3);
    }

    protected void sendRilCommands(int r2) {
        if (updateHalCommandToUse() == true) goto L6;
        log("Wait for HAL command update");
        return;
    L6:
        super.sendRilCommands(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDdsSwitchResponse(android.os.AsyncResult r4) {
        if (r4 != null) goto L4;
    L6:
        boolean r0 = false;
    L7:
        int r1 = ((Integer) r4.userObj).intValue();
        if (this.mEmergencyOverride == null) goto L10;
        log("Emergency override result sent = " + r0);
        this.mEmergencyOverride.sendOverrideCompleteCallbackResultAndClear(r0);
    L21:
        if (r0 == false) goto L23;
        log("onDdsSwitchResponse: DDS switch success on phoneId = " + r1);
    L23:
        ((Set) this.mCurrentDdsSwitchFailure.get(r1)).clear();
        if (PhoneFactory.getDefaultPhone().isUsingNewDataStack() == false) goto L26;
    L28:
        this.mActivePhoneRegistrants.notifyRegistrants();
        notifyPreferredDataSubIdChanged();
        return;
    L26:
        if (isSmartTempDdsSwitchSupported() == false) goto L28;
        sendDataDuringVoiceCallInfo();
        goto L28
    L10:
        if (r0 == true) goto L21;
        log("onDdsSwitchResponse: DDS switch failed. with exception " + r4.exception);
        if (isAnyVoiceCallActiveOnDevice() == false) goto L16;
        ((Set) this.mCurrentDdsSwitchFailure.get(r1)).add(CommandException.Error.OP_NOT_ALLOWED_DURING_VOICE_CALL);
        log("onDdsSwitchResponse: Wait for call end indication");
        return;
    L16:
        if (isSimApplicationReady(r1) == true) goto L19;
        ((Set) this.mCurrentDdsSwitchFailure.get(r1)).add(CommandException.Error.INVALID_SIM_STATE);
        log("onDdsSwitchResponse: Wait for SIM to get READY");
        return;
    L19:
        log("onDdsSwitchResponse: Scheduling DDS switch retry");
        sendMessageDelayed(Message.obtain(this, 113, Integer.valueOf(r1)), 5000);
        return;
    L4:
        if (r4.exception != null) goto L6;
        r0 = true;
        goto L7
    }

    private boolean isSmartTempDdsSwitchSupported() {
        int r1 = 0;
    L4:
        if (r1 >= this.mActiveModemCount) goto L9;
        if (PhoneFactory.getPhone(r1).getSmartTempDdsSwitchSupported() == false) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    private void sendDataDuringVoiceCallInfo() {
        int r0 = getPrimaryDataPhoneId();
        if (SubscriptionManager.isValidPhoneId(r0) == false) goto L42;
        ExtTelephonyManager r1 = this.mExtTelephonyManager;
        if (r1 == null) goto L42;
        r1.sendUserPreferenceForDataDuringVoiceCall(r0, false, this.mClient);
        Phone r2 = PhoneFactory.getPhone(r0);
        if (r2 != null) goto L12;
        log("primaryDataPhone is null");
        return;
    L12:
        if (r2.isUsingNewDataStack() == false) goto L14;
        boolean r3 = r2.getDataSettingsManager().isDataEnabledForReason(0);
    L15:
        int r4 = 0;
    L17:
        if (r4 >= this.mActiveModemCount) goto L41;
        if (r4 == r0) goto L40;
        if (r3 == true) goto L22;
        this.mExtTelephonyManager.sendUserPreferenceForDataDuringVoiceCall(r4, false, this.mClient);
        goto L40
    L22:
        Phone r5 = PhoneFactory.getPhone(r4);
        if (r5 == null) goto L24;
        if (r5.isUsingNewDataStack() == false) goto L29;
        boolean r6 = r5.getDataSettingsManager().isDataAllowedInVoiceCall();
    L44:
    L37:
        e = move-exception;
        Rlog.e("PhoneSwitcher", "Exception while checking roaming state for DDS", e);
    L39:
        this.mExtTelephonyManager.sendUserPreferenceForDataDuringVoiceCall(r4, r6, this.mClient);
        goto L40
    L31:
        if (r2.getServiceState().getDataRoaming() == false) goto L39;
        if (r6 == false) goto L36;
        if (r2.getDataRoamingEnabled() == false) goto L36;
        r6 = true;
    L36:
        r6 = false;
        goto L39
    L29:
        r6 = r5.getDataEnabledSettings().isDataAllowedInVoiceCall();
        goto L44
    L24:
        log("phone is null");
        return;
    L40:
        r4 = r4 + 1;
        goto L17
    L41:
        return;
    L14:
        r3 = r2.getDataEnabledSettings().isDataEnabled();
    L42:
        log("sendDataDuringVoiceCallInfo bail out");
    }

    private boolean updateHalCommandToUse() {
        if (this.mHalCommandToUse != 0) goto L21;
        int r0 = 0;
        boolean r3 = true;
    L5:
        int r5 = 2;
        if (r0 >= this.mActiveModemCount) goto L12;
        if (PhoneFactory.getPhone(r0).mCi.getRadioState() == 2) goto L10;
        boolean r4 = true;
    L11:
        r3 = r3 & r4;
        r0 = r0 + 1;
        goto L5
    L10:
        r4 = false;
        goto L11
    L12:
        if (r3 == false) goto L19;
        log("update HAL command");
        if (this.mRadioConfig.isSetPreferredDataCommandSupported() == true) goto L17;
        r5 = 1;
    L17:
        this.mHalCommandToUse = r5;
        return true;
    L19:
        log("radio is unavailable");
    L21:
        if (this.mHalCommandToUse != 0) goto L23;
        return false;
    L23:
        return true;
    }

    protected boolean isPhoneInVoiceCall(Phone r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Call.State r0 = r3.getForegroundCall().getState();
        if (r3.getBackgroundCall().isIdle() == true) goto L8;
    L17:
        return true;
    L8:
        if (r0 == Call.State.ACTIVE) goto L17;
        if (r0 == Call.State.ALERTING) goto L17;
        if (r0 == Call.State.DISCONNECTING) goto L17;
        if (r3.getRingingCall().isRinging() == true) goto L17;
        if (r3.getRingingCall().getState() == Call.State.DISCONNECTING) goto L17;
        return false;
    }
}
