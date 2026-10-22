package com.qualcomm.qti.internal.telephony.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.data.DataProfile;
import android.telephony.ims.ImsException;
import android.telephony.ims.ImsManager;
import android.telephony.ims.ImsMmTelManager;
import android.util.Pair;
import android.util.SparseArray;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneFactory;
import com.android.internal.telephony.SubscriptionController;
import com.android.internal.telephony.data.DataEvaluation;
import com.android.internal.telephony.data.DataNetwork;
import com.android.internal.telephony.data.DataNetworkController;
import com.android.internal.telephony.data.TelephonyNetworkRequest;
import com.qti.extphone.Client;
import com.qti.extphone.ExtPhoneCallbackBase;
import com.qti.extphone.ExtTelephonyManager;
import com.qti.extphone.IExtPhoneCallback;
import com.qti.extphone.ServiceCallback;
import com.qti.extphone.Status;
import com.qti.extphone.Token;
import org.codeaurora.telephony.utils.EnhancedRadioCapabilityResponse;

/* JADX INFO: loaded from: classes4.dex */
public class QtiDataNetworkController extends DataNetworkController {
    private static final int EVENT_QOS_PARAMETERS_CHANGED = 270538;
    private static final int EVENT_QTI_DISCONNECT_DEFAULT_PDN = 270537;
    private static final int EVENT_QTI_PHONE_READY = 270539;
    private static final int EVENT_RECONNECT_QTI_EXT_TELEPHONY_SERVICE = 270536;
    private static final int INVALID_CID = -1;
    private static final int INVALID_INDEX = -1;
    private static final int RECONNECT_EXT_TELEPHONY_SERVICE_DELAY_MILLISECOND = 2000;
    protected IExtPhoneCallback mCallback;
    private long mCiwlanTimer;
    private Client mClient;
    private Uri mCrossSimCallingUri;
    private int mEnabledChangedReason;
    private EnhancedRadioCapabilityResponse mEnhancedRadioCapability;
    private ExtTelephonyManager mExtTelephonyManager;
    private boolean mIsCiwlanFeatureEnabledByPlatform;
    private boolean mIsCiwlanFeatureEnabledByUser;
    private boolean mIsDataRoamingEnabled;
    private boolean mIsEssentialRecordsLoaded;
    private boolean mIsInSecureMode;
    private boolean mIsMobileDataEnabled;
    private boolean mPendingDataOff;
    private boolean mPendingRoamingOff;
    private QtiDataConfigManager mQtiDataConfigManager;
    protected final SparseArray<QtiDataServiceManager> mQtiDataServiceManagers;
    private Client mQtiRadioConfigClient;
    private ContentResolver mResolver;
    private ServiceCallback mServiceCallback;

    /* JADX INFO: renamed from: com.qualcomm.qti.internal.telephony.data.QtiDataNetworkController$2, reason: invalid class name */
    class AnonymousClass2 extends ExtPhoneCallbackBase {
        final /* synthetic */ QtiDataNetworkController this$0;

        AnonymousClass2(QtiDataNetworkController r1) {
            this.this$0 = r1;
        }

        public void getQtiRadioCapabilityResponse(int r1, Token r2, Status r3, int r4) throws RemoteException {
            if (SubscriptionManager.isValidSlotIndex(r1) == true) goto L5;
            return;
        L5:
            if (QtiDataNetworkController.access$1100(this.this$0).getPhoneId() != r1) goto L10;
            QtiDataNetworkController.m715$$Nest$fgetmEnhancedRadioCapability(this.this$0).updateEnhancedRadioCapability(r4);
            return;
        }

        public void onDdsSwitchCapabilityChange(final int r2, Token r3, Status r4, final boolean r5) throws RemoteException {
            QtiDataNetworkController.access$1200(this.this$0, "ExtPhoneCallback: onDdsSwitchCapabilityChange support: " + r5 + " SlotId: " + r2);
            if (SubscriptionManager.isValidSlotIndex(r2) == true) goto L5;
            return;
        L5:
            this.this$0.post(new QtiDataNetworkController$2$$ExternalSyntheticLambda0(this, r2, r5));
        }

        /* JADX INFO: renamed from: lambda$onDdsSwitchCapabilityChange$0$com-qualcomm-qti-internal-telephony-data-QtiDataNetworkController$2, reason: not valid java name */
        /* synthetic */ void m728xf1fcfeee(int r2, boolean r3) {
            if (QtiDataNetworkController.access$2000(this.this$0).getPhoneId() != r2) goto L6;
            QtiDataNetworkController.access$2100(this.this$0).setSmartTempDdsSwitchSupported(r3);
            QtiDataNetworkController r1 = this.this$0;
            r1.evaluateAndSendDataDuringVoiceCallInfo(QtiDataNetworkController.access$2200(r1).getPhoneId(), "DDS_SWITCH_CAPABILITY_CHANGED");
            return;
        }

        public void onDataDeactivateDelayTime(int r4, long r5) throws RemoteException {
            QtiDataNetworkController.access$1300(this.this$0, "ExtPhoneCallback: onDataDeactivateDelayTime  SlotId: " + r4 + " delayTimeMilliSecs " + r5);
            if (r4 == QtiDataNetworkController.access$1400(this.this$0).getPhoneId()) goto L6;
            return;
        L6:
            if (r5 >= 0) goto L8;
            return;
        L8:
            QtiDataNetworkController.m720$$Nest$fputmCiwlanTimer(this.this$0, r5);
            if (QtiDataNetworkController.m712$$Nest$fgetmCiwlanTimer(this.this$0) != 0) goto L12;
            this.this$0.removeMessages(QtiDataNetworkController.EVENT_QTI_DISCONNECT_DEFAULT_PDN);
            QtiDataNetworkController r3 = this.this$0;
            r3.sendMessage(r3.obtainMessage(QtiDataNetworkController.EVENT_QTI_DISCONNECT_DEFAULT_PDN));
            return;
        }

        public void onEpdgOverCellularDataSupported(int r4, boolean r5) throws RemoteException {
            QtiDataNetworkController.access$1500(this.this$0, "ExtPhoneCallback: onEpdgOverCellularDataSupported SlotId: " + r4 + " support " + r5);
            if (r4 == QtiDataNetworkController.access$1600(this.this$0).getPhoneId()) goto L5;
            return;
        L5:
            QtiDataNetworkController.m722$$Nest$fputmIsCiwlanFeatureEnabledByPlatform(this.this$0, r5);
            if (r5 == false) goto L9;
            QtiDataNetworkController.m727$$Nest$msendCrossSimCallingEnabled(this.this$0);
            return;
        }

        public void onSecureModeStatusChange(boolean r4) throws RemoteException {
            QtiDataNetworkController.access$1700(this.this$0, "ExtPhoneCallback: onSecureModeStatusChange enabled: " + r4);
            QtiDataNetworkController.m724$$Nest$fputmIsInSecureMode(this.this$0, r4);
            if (r4 == true) goto L6;
            QtiDataNetworkController.access$1800(this.this$0, "Reevaluating unsatisfied network requests due to Secure Mode exit");
            QtiDataNetworkController r3 = this.this$0;
            r3.sendMessage(r3.obtainMessage(5, DataEvaluation.DataEvaluationReason.SECURE_MODE_STATE_CHANGED));
            return;
        }

        public void getSecureModeStatusResponse(Token r2, Status r3, boolean r4) {
            QtiDataNetworkController.access$1900(this.this$0, "ExtPhoneCallback: getSecureModeStatusResponse enabled: " + r4);
            QtiDataNetworkController.m724$$Nest$fputmIsInSecureMode(this.this$0, r4);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCiwlanTimer, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m712$$Nest$fgetmCiwlanTimer(QtiDataNetworkController r2) {
        return r2.mCiwlanTimer;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ Client m713$$Nest$fgetmClient(QtiDataNetworkController r0) {
        return r0.mClient;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCrossSimCallingUri, reason: not valid java name */
    static /* bridge */ /* synthetic */ Uri m714$$Nest$fgetmCrossSimCallingUri(QtiDataNetworkController r0) {
        return r0.mCrossSimCallingUri;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEnhancedRadioCapability, reason: not valid java name */
    static /* bridge */ /* synthetic */ EnhancedRadioCapabilityResponse m715$$Nest$fgetmEnhancedRadioCapability(QtiDataNetworkController r0) {
        return r0.mEnhancedRadioCapability;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExtTelephonyManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ExtTelephonyManager m716$$Nest$fgetmExtTelephonyManager(QtiDataNetworkController r0) {
        return r0.mExtTelephonyManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsCiwlanFeatureEnabledByPlatform, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m717$$Nest$fgetmIsCiwlanFeatureEnabledByPlatform(QtiDataNetworkController r0) {
        return r0.mIsCiwlanFeatureEnabledByPlatform;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsCiwlanFeatureEnabledByUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m718$$Nest$fgetmIsCiwlanFeatureEnabledByUser(QtiDataNetworkController r0) {
        return r0.mIsCiwlanFeatureEnabledByUser;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmQtiRadioConfigClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ Client m719$$Nest$fgetmQtiRadioConfigClient(QtiDataNetworkController r0) {
        return r0.mQtiRadioConfigClient;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCiwlanTimer, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m720$$Nest$fputmCiwlanTimer(QtiDataNetworkController r0, long r1) {
        r0.mCiwlanTimer = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m721$$Nest$fputmClient(QtiDataNetworkController r0, Client r1) {
        r0.mClient = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsCiwlanFeatureEnabledByPlatform, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m722$$Nest$fputmIsCiwlanFeatureEnabledByPlatform(QtiDataNetworkController r0, boolean r1) {
        r0.mIsCiwlanFeatureEnabledByPlatform = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsCiwlanFeatureEnabledByUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m723$$Nest$fputmIsCiwlanFeatureEnabledByUser(QtiDataNetworkController r0, boolean r1) {
        r0.mIsCiwlanFeatureEnabledByUser = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsInSecureMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m724$$Nest$fputmIsInSecureMode(QtiDataNetworkController r0, boolean r1) {
        r0.mIsInSecureMode = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmQtiRadioConfigClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m725$$Nest$fputmQtiRadioConfigClient(QtiDataNetworkController r0, Client r1) {
        r0.mQtiRadioConfigClient = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$misCrossSimCallingEnabledByUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m726$$Nest$misCrossSimCallingEnabledByUser(QtiDataNetworkController r0) {
        return r0.isCrossSimCallingEnabledByUser();
    }

    /* JADX INFO: renamed from: -$$Nest$msendCrossSimCallingEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m727$$Nest$msendCrossSimCallingEnabled(QtiDataNetworkController r0) {
        r0.sendCrossSimCallingEnabled();
    }

    static /* synthetic */ void access$000(QtiDataNetworkController r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ Phone access$100(QtiDataNetworkController r0) {
        return r0.mPhone;
    }

    static /* synthetic */ void access$1000(QtiDataNetworkController r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ Phone access$1100(QtiDataNetworkController r0) {
        return r0.mPhone;
    }

    static /* synthetic */ void access$1200(QtiDataNetworkController r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ void access$1300(QtiDataNetworkController r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ Phone access$1400(QtiDataNetworkController r0) {
        return r0.mPhone;
    }

    static /* synthetic */ void access$1500(QtiDataNetworkController r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ Phone access$1600(QtiDataNetworkController r0) {
        return r0.mPhone;
    }

    static /* synthetic */ void access$1700(QtiDataNetworkController r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ void access$1800(QtiDataNetworkController r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ void access$1900(QtiDataNetworkController r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ void access$200(QtiDataNetworkController r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ Phone access$2000(QtiDataNetworkController r0) {
        return r0.mPhone;
    }

    static /* synthetic */ Phone access$2100(QtiDataNetworkController r0) {
        return r0.mPhone;
    }

    static /* synthetic */ Phone access$2200(QtiDataNetworkController r0) {
        return r0.mPhone;
    }

    static /* synthetic */ void access$2300(QtiDataNetworkController r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ void access$2400(QtiDataNetworkController r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ Phone access$2500(QtiDataNetworkController r0) {
        return r0.mPhone;
    }

    static /* synthetic */ void access$2600(QtiDataNetworkController r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ Phone access$300(QtiDataNetworkController r0) {
        return r0.mPhone;
    }

    static /* synthetic */ void access$400(QtiDataNetworkController r0, String r1) {
        r0.loge(r1);
    }

    static /* synthetic */ Phone access$500(QtiDataNetworkController r0) {
        return r0.mPhone;
    }

    static /* synthetic */ Phone access$600(QtiDataNetworkController r0) {
        return r0.mPhone;
    }

    static /* synthetic */ void access$700(QtiDataNetworkController r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ void access$800(QtiDataNetworkController r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ void access$900(QtiDataNetworkController r0, String r1) {
        r0.loge(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QtiDataNetworkController(Phone r3, Looper r4) {
        super(r3, r4);
        this.mCiwlanTimer = -1;
        this.mIsInSecureMode = false;
        this.mIsEssentialRecordsLoaded = false;
        SparseArray<QtiDataServiceManager> r5 = new SparseArray();
        this.mQtiDataServiceManagers = r5;
        this.mServiceCallback = new AnonymousClass1(this);
        this.mCallback = new AnonymousClass2(this);
        log("QtiDataNetworkController: constructor");
        this.mEnhancedRadioCapability = new EnhancedRadioCapabilityResponse();
        ExtTelephonyManager r6 = ExtTelephonyManager.getInstance(this.mPhone.getContext());
        this.mExtTelephonyManager = r6;
        r6.connectService(this.mServiceCallback);
        this.mQtiDataConfigManager = (QtiDataConfigManager) this.mDataConfigManager;
        r5.put(1, (QtiDataServiceManager) this.mDataServiceManagers.get(1));
        if (this.mAccessNetworksManager.isInLegacyMode() == true) goto L5;
        r5.put(2, (QtiDataServiceManager) this.mDataServiceManagers.get(2));
    L5:
        r5.get(1).registerForQosParametersChanged(this, EVENT_QOS_PARAMETERS_CHANGED);
    }

    public EnhancedRadioCapabilityResponse getEnhancedRadioCapabilityResponse() {
        return this.mEnhancedRadioCapability;
    }

    public void handleMessage(Message r3) {
        log("handleMessage, msg.what = " + r3.what);
        switch(r3.what) {
            case 270536: goto L16;
            case 270537: goto L10;
            case 270538: goto L5;
            default: goto L4;
        };
    L4:
        super.handleMessage(r3);
        return;
    L5:
        log("EVENT_QOS_PARAMETERS_CHANGED");
        AsyncResult r4 = (AsyncResult) r3.obj;
        Pair r0 = (Pair) r4.result;
        if (r4.exception != null) goto L9;
        if (r0 == null) goto L9;
        onQosParametersChanged(((Integer) r0.first).intValue(), (FrameworkQosParameters) r0.second);
        return;
    L9:
        log("EVENT_QOS_PARAMETERS_CHANGED: exception, ignore.");
        return;
    L10:
        log("EVENT_QTI_DISCONNECT_DEFAULT_PDN");
        if (this.mPendingDataOff == false) goto L14;
        this.mPendingDataOff = false;
        super.onDataEnabledChanged(this.mIsMobileDataEnabled, this.mEnabledChangedReason);
    L14:
        if (this.mPendingRoamingOff == false) goto L21;
        this.mPendingRoamingOff = false;
        super.onDataRoamingEnabledChanged(this.mIsDataRoamingEnabled);
        return;
    L21:
        return;
    L16:
        log("EVENT_RECONNECT_QTI_EXT_TELEPHONY_SERVICE");
        this.mExtTelephonyManager.connectService(this.mServiceCallback);
    }

    private void onQosParametersChanged(final int r4, FrameworkQosParameters r5) {
        StringBuilder r0 = new StringBuilder("onQosParametersChanged, cid: ").append(r4).append(", qosParams: ");
        if (r5 != null) goto L5;
        Object r1 = "null";
    L6:
        log(r0.append(r1).toString());
        if (r5 != null) goto L9;
        return;
    L9:
        DataNetwork r2 = (DataNetwork) this.mDataNetworkList.stream().filter(new QtiDataNetworkController$$ExternalSyntheticLambda0(r4)).findFirst().orElse(null);
        if (r2 != null) goto L12;
    L20:
        loge("onQosParametersChanged: no associated DataNetwork yet, ignore");
        return;
    L12:
        if (r2.getDataProfile() == null) goto L20;
        log("onQosParametersChanged: dataNetworkForReceivedCid: " + r2);
        if ((r2.getDataProfile().getSupportedApnTypesBitmask() & 64) != 0) goto L18;
        loge("onQosParametersChanged: associated DataNetwork not for IMS, ignore");
        return;
    L18:
        this.mQtiDataServiceManagers.get(1).addToQosParamsMap(r4, r5);
        r2.updateQosBearerSessions(r5.getQosBearerSessions());
        return;
    L5:
        r1 = r5;
        goto L6
    }

    static /* synthetic */ boolean lambda$onQosParametersChanged$0(int r0, DataNetwork r1) {
        if (r1.getId() != r0) goto L5;
        return true;
    L5:
        return false;
    }

    protected void onDataDuringVoiceCallChanged(boolean r3) {
        log("onDataDuringVoiceCallChanged: " + r3);
        evaluateAndSendDataDuringVoiceCallInfo(this.mPhone.getPhoneId(), "DATA_DURING_VOICE_CALL_CHANGED");
    }

    protected void onSubscriptionChanged() {
        if (SubscriptionManager.isValidSubscriptionId(this.mPhone.getSubId()) == true) goto L5;
    L12:
        super.onSubscriptionChanged();
        return;
    L5:
        if (this.mSubId == this.mPhone.getSubId()) goto L12;
        if (this.mClient != null) goto L9;
    L11:
        getCiwlanUiInfoAndStartTimer();
        goto L12
    L9:
        if (this.mIsCiwlanFeatureEnabledByPlatform == false) goto L11;
        this.mIsCiwlanFeatureEnabledByUser = isCrossSimCallingEnabledByUser();
        sendCrossSimCallingEnabled();
        goto L11
    }

    private boolean isCrossSimCallingEnabledByUser() {
        if (SubscriptionManager.isValidSubscriptionId(this.mPhone.getSubId()) == true) goto L5;
        return false;
    L5:
        ImsMmTelManager r0 = getImsMmTelManager();
        if (r0 != null) goto L13;
        return false;
    L13:
        return r0.isCrossSimCallingEnabled();
    L10:
        e = move-exception;
        log("fail to get cross SIM calling configuration " + e);
        return false;
    }

    private void sendCrossSimCallingEnabled() {
        if (SubscriptionManager.isValidSubscriptionId(this.mPhone.getSubId()) == true) goto L5;
        return;
    L5:
        ImsMmTelManager r0 = getImsMmTelManager();
        if (r0 != null) goto L8;
        return;
    L8:
        this.mIsCiwlanFeatureEnabledByUser = isCrossSimCallingEnabledByUser();
        log("setCrossSimCallingEnabled: " + this.mIsCiwlanFeatureEnabledByUser);
        r0.setCrossSimCallingEnabled(this.mIsCiwlanFeatureEnabledByUser);     // Catch: ImsException -> L11
        return;
    L11:
        e = move-exception;
        log("fail to send cross SIM calling configuration: " + this.mIsCiwlanFeatureEnabledByUser + " Exception: " + e);
    }

    private ImsMmTelManager getImsMmTelManager() {
        if (SubscriptionManager.isValidSubscriptionId(this.mPhone.getSubId()) == true) goto L5;
        return null;
    L5:
        ImsManager r0 = (ImsManager) this.mPhone.getContext().getSystemService(ImsManager.class);
        if (r0 != null) goto L9;
        return null;
    L9:
        return r0.getImsMmTelManager(this.mPhone.getSubId());
    }

    private void getCiwlanUiInfoAndStartTimer() {
        this.mCrossSimCallingUri = Uri.withAppendedPath(SubscriptionManager.CROSS_SIM_ENABLED_CONTENT_URI, String.valueOf(this.mPhone.getSubId()));
        ContentResolver r0 = this.mPhone.getContext().getContentResolver();
        Uri r1 = this.mCrossSimCallingUri;
        final Handler r3 = new Handler();
        r0.registerContentObserver(r1, false, new AnonymousClass3(this, r3));
    }

    protected void onDataEnabledChanged(boolean r5, int r6) {
        log("QtiDNC onDataEnabledChanged: enabled = " + r5 + " reason = " + r6);
        if (isCurrentSubDds(this.mPhone.getSubId()) == false) goto L6;
        evaluateAndSendDataDuringVoiceCallInfo(getNonDdsPhoneId(), "DDS_DATA_ENABLED_CHANGED");
    L6:
        if (this.mIsCiwlanFeatureEnabledByUser == false) goto L14;
        if (r5 == true) goto L14;
        if (this.mCiwlanTimer <= 0) goto L14;
        if (hasMessages(EVENT_QTI_DISCONNECT_DEFAULT_PDN) == true) goto L13;
        this.mIsMobileDataEnabled = r5;
        this.mEnabledChangedReason = r6;
        sendMessageDelayed(obtainMessage(EVENT_QTI_DISCONNECT_DEFAULT_PDN), this.mCiwlanTimer);
    L13:
        this.mPendingDataOff = true;
        return;
    L14:
        super.onDataEnabledChanged(r5, r6);
    }

    protected void onDataRoamingEnabledChanged(boolean r5) {
        log("QtiDNC onDataRoamingEnabledChanged: enabled=" + r5);
        if (isCurrentSubDds(this.mPhone.getSubId()) == false) goto L6;
        evaluateAndSendDataDuringVoiceCallInfo(getNonDdsPhoneId(), "DDS_DATA_ROAMING_ENABLED_CHANGED");
    L6:
        if (this.mIsCiwlanFeatureEnabledByUser == false) goto L14;
        if (r5 == true) goto L14;
        if (this.mCiwlanTimer <= 0) goto L14;
        if (hasMessages(EVENT_QTI_DISCONNECT_DEFAULT_PDN) == true) goto L13;
        this.mIsDataRoamingEnabled = r5;
        sendMessageDelayed(obtainMessage(EVENT_QTI_DISCONNECT_DEFAULT_PDN), this.mCiwlanTimer);
    L13:
        this.mPendingRoamingOff = true;
        return;
    L14:
        super.onDataRoamingEnabledChanged(r5);
    }

    private Phone getDefaultDataPhone() {
        SubscriptionController r0 = SubscriptionController.getInstance();
        int r1 = r0.getDefaultDataSubId();
        if (SubscriptionManager.isValidSubscriptionId(r1) == false) goto L5;
        int r2 = r0.getPhoneId(r1);
    L7:
        if (SubscriptionManager.isValidPhoneId(r2) == true) goto L14;
    L12:
        return null;
    L14:
        return PhoneFactory.getPhone(r2);
    L10:
        e = move-exception;
        loge("getDefaultDataPhone: " + e.getMessage());
        goto L12
    L5:
        r2 = -1;
        goto L7
    }

    private boolean isDataEnabledOnDds() {
        Phone r1 = getDefaultDataPhone();
        if (r1 != null) goto L5;
        return false;
    L5:
        return r1.getDataSettingsManager().isDataEnabledForReason(0);
    }

    private boolean isDdsRoamingCriteriaSatisfiedForTempSwitch() {
        Phone r0 = getDefaultDataPhone();
        if (r0 != null) goto L14;
        return false;
    L14:
    L11:
        e = move-exception;
        loge("Exception while checking DDS roaming state: " + e);
        return false;
    L6:
        if (r0.getServiceState().getDataRoaming() == true) goto L9;
        return true;
    L9:
        return r0.getDataSettingsManager().isDataRoamingEnabled();
    }

    protected void onServiceStateChanged() {
        if (isCurrentSubDds(this.mPhone.getSubId()) == false) goto L5;
        handleDdsRoamingStateChangesIfRequired();
    L5:
        super.onServiceStateChanged();
    }

    private void handleDdsRoamingStateChangesIfRequired() {
        boolean r1 = this.mServiceState.getDataRoaming();     // Catch: NullPointerException -> L7
        boolean r2 = this.mPhone.getServiceStateTracker().getServiceState().getDataRoaming();     // Catch: NullPointerException -> L7
        if (r1 == r2) goto L12;
        log("DDS roaming state changed: " + r1 + " -> " + r2);     // Catch: NullPointerException -> L7
        evaluateAndSendDataDuringVoiceCallInfo(getNonDdsPhoneId(), "DDS_ROAMING_STATE_CHANGED");     // Catch: NullPointerException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        loge("Exception while handling DDs roaming state changes: " + e);
    }

    private int getNonDdsPhoneId() {
        int r1 = 0;
    L4:
        if (r1 >= getPhoneCount()) goto L14;
        int[] r2 = SubscriptionManager.getSubId(r1);
        if (r2 == null) goto L13;
        if (r2.length <= 0) goto L13;
        if (r2[0] == SubscriptionManager.getDefaultDataSubscriptionId()) goto L13;
        log("getNonDdsPhoneId: " + r1);
        return r1;
    L13:
        r1 = r1 + 1;
        goto L4
    L14:
        return -1;
    }

    void evaluateAndSendDataDuringVoiceCallInfo(int r5, String r6) {
        if (SubscriptionManager.isValidPhoneId(r5) == true) goto L32;
        return;
    L32:
        Phone r0 = PhoneFactory.getPhone(r5);     // Catch: IllegalStateException -> L29
        if (r0 != null) goto L10;
        loge("evaluateAndSendDataDuringVoiceCallInfo, phone null for phoneId: " + r5);
        return;
    L10:
        if (SubscriptionManager.isValidSubscriptionId(r0.getSubId()) == true) goto L13;
        loge("evaluateAndSendDataDuringVoiceCallInfo, sub id is invalid");
        return;
    L13:
        boolean r2 = false;
        if (r5 != getNonDdsPhoneId()) goto L24;
        if (r0.getDataSettingsManager().isDataAllowedInVoiceCall() == true) goto L18;
    L22:
        log("isDataAllowedDuringCall: " + r2 + ", data during calls switch: " + r0.getDataSettingsManager().isDataAllowedInVoiceCall() + ", isDataEnabledOnDds: " + isDataEnabledOnDds() + ", isDdsRoamingSatisfied: " + isDdsRoamingCriteriaSatisfiedForTempSwitch() + ", phoneId: " + r5 + ", reason: " + r6);
        goto L24
    L18:
        if (isDataEnabledOnDds() == false) goto L22;
        if (isDdsRoamingCriteriaSatisfiedForTempSwitch() == false) goto L22;
        r2 = true;
    L24:
        if (this.mExtTelephonyManager != null) goto L26;
        return;
    L26:
        if (r0.getSmartTempDdsSwitchSupported() == false) goto L35;
        log("Evaluated data during voice call: " + r2 + " phoneId: " + r5);
        this.mExtTelephonyManager.sendUserPreferenceForDataDuringVoiceCall(r5, r2, this.mClient);
        return;
    L35:
        return;
    L29:
        e = move-exception;
        loge("evaluateAndSendDataDuringVoiceCallInfo " + e.getMessage());
    }

    private boolean isCurrentSubDds(int r2) {
        if (SubscriptionManager.isValidSubscriptionId(r2) == true) goto L5;
        return false;
    L5:
        if (r2 != SubscriptionManager.getDefaultDataSubscriptionId()) goto L9;
        return true;
    L9:
        return false;
    }

    private int getPhoneCount() {
        return ((TelephonyManager) this.mPhone.getContext().getSystemService("phone")).getActiveModemCount();
    }

    public void onCarrierConfigLoadedForEssentialRecords() {
        log("QtiDNC onCarrierConfigLoadedForEssentialRecords");
        getDataConfigManager().onCarrierConfigLoadedForEssentialRecords();
    }

    public void setEssentialRecordsLoaded(boolean r3) {
        log("QtiDNC setEssentialRecordsLoaded to " + r3);
        this.mIsEssentialRecordsLoaded = r3;
    }

    private boolean isEssentialRecordsLoaded() {
        log("QtiDNC isEssentialRecordsLoaded: " + this.mIsEssentialRecordsLoaded);
        return this.mIsEssentialRecordsLoaded;
    }

    protected void onSimStateChanged(int r1) {
        resetEssentialRecordsLoadedStateIfRequired(r1);
        super.onSimStateChanged(r1);
    }

    private void resetEssentialRecordsLoadedStateIfRequired(int r2) {
        if (r2 != 11) goto L5;
        return;
    L5:
        if (r2 == 10) goto L9;
        setEssentialRecordsLoaded(false);
        return;
    }

    protected void addDataDisallowedReasonWhenInSecureMode(DataEvaluation r3) {
        log("addDataDisallowedReasonWhenInSecureMode: mIsInSecureMode = " + this.mIsInSecureMode);
        if (this.mIsInSecureMode == false) goto L6;
        r3.addDataDisallowedReason(DataEvaluation.DataDisallowedReason.DATA_RESTRICTED_BY_SECURE_MODE);
        return;
    }

    protected void checkSimStateForDataEvaluation(DataEvaluation r3) {
        if (this.mSimState != 10) goto L5;
        return;
    L5:
        if (isEssentialRecordsLoaded() == true) goto L9;
        log("QtiDCT SIM is neither loaded, nor essentially loaded");
        r3.addDataDisallowedReason(DataEvaluation.DataDisallowedReason.SIM_NOT_READY);
        return;
    }

    public void onDataNetworkConnected(DataNetwork r2) {
        if (this.mQtiDataConfigManager.isPdpRejectConfigEnabled() == true) goto L5;
    L7:
        super.onDataNetworkConnected(r2);
        return;
    L5:
        if (r2.isInternetSupported() == false) goto L7;
        log("QtiDNC onDataNetworkConnected: Reset data reject count ..");
        this.mDataRetryManager.handlePdpRejectCauseSuccess();
        goto L7
    }

    protected void onDataNetworkDisconnected(DataNetwork r3, int r4) {
        log("QtiDNC onDataNetworkDisconnected: cause: " + r4 + ", " + r3);
        this.mQtiDataServiceManagers.get(1).removeFromQosParamsMap(r3.getId());
        super.onDataNetworkDisconnected(r3, r4);
    }

    protected boolean isPdpRejectRetryOngoing(TelephonyNetworkRequest r3) {
        int r0 = this.mAccessNetworksManager.getPreferredTransportByNetworkCapability(r3.getApnTypeNetworkCapability());
        DataProfile r4 = this.mDataProfileManager.getDataProfileForNetworkRequest(r3, getDataNetworkType(r0));
        QtiDataRetryManager r1 = (QtiDataRetryManager) this.mDataRetryManager;
        if (r1.isPdpRejectRetryOngoing() == true) goto L5;
        return false;
    L5:
        if (r1.isDataProfileOfTypeDefault(r4) == false) goto L10;
        log("isPdpRejectRetryOngoing: true");
        return true;
    L10:
        return false;
    }
}
