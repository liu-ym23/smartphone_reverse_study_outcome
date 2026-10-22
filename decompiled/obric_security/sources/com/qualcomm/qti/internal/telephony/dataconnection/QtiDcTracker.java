package com.qualcomm.qti.internal.telephony.dataconnection;

import android.R;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.telephony.CarrierConfigManager;
import android.telephony.DataFailCause;
import android.telephony.Rlog;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.data.ApnSetting;
import android.telephony.ims.ImsException;
import android.telephony.ims.ImsManager;
import android.telephony.ims.ImsMmTelManager;
import android.text.TextUtils;
import com.android.internal.telephony.DctConstants;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneFactory;
import com.android.internal.telephony.SubscriptionController;
import com.android.internal.telephony.SubscriptionInfoUpdater;
import com.android.internal.telephony.dataconnection.ApnContext;
import com.android.internal.telephony.dataconnection.DataEnabledSettings;
import com.android.internal.telephony.dataconnection.DcTracker;
import com.qti.extphone.Client;
import com.qti.extphone.ExtTelephonyManager;
import com.qti.extphone.IExtPhoneCallback;
import com.qti.extphone.ServiceCallback;
import java.util.concurrent.ConcurrentHashMap;
import org.codeaurora.telephony.utils.EnhancedRadioCapabilityResponse;

/* JADX INFO: loaded from: classes4.dex */
public final class QtiDcTracker extends DcTracker {
    private static final int APN_NAME = 3;
    private static final int APN_TYPE = 1;
    private static final int DEVICE_CAPABILITY = 2;
    private static final int EVENT_CARRIER_CONFIG_LOADED_ON_ESSENTIAL_RECORDS = 270537;
    private static final int EVENT_QTI_DISCONNECT_DEFAULT_PDN = 270539;
    private static final int EVENT_QTI_SUBSCRIPTION_CHANGED = 270538;
    private static final int EVENT_RECONNECT_QTI_EXT_TELEPHONY_SERVICE = 270536;
    private static final int GID = 0;
    private static final int KEY_MULTI_APN_ARRAY_FOR_SAME_GID_ENTRY_LENGTH = 4;
    public static final int MAX_PDP_REJECT_COUNT = 3;
    private static final int MAX_RETRY_ATTEMPTS = 3;
    private static final int RECONNECT_EXT_TELEPHONY_SERVICE_DELAY_MILLISECOND = 2000;
    private static final int RETRY_DELAY = 500;
    protected static AlertDialog mDataRejectDialog;
    private static int mGetEnhancedRadioCapabilityRetryCount;
    private String LOG_TAG;
    protected IExtPhoneCallback mCallback;
    private long mCiwlanTimer;
    private Client mClient;
    private Uri mCrossSimCallingUri;
    private int mDataRejectCount;
    private String mDataRejectReason;
    private int mEnabledChangedReason;
    private EnhancedRadioCapabilityResponse mEnhancedRadioCapability;
    private ExtTelephonyManager mExtTelephonyManager;
    private boolean mExtTelephonyServiceConnected;
    private boolean mIsCiwlanFeatureEnabledByPlatform;
    private boolean mIsCiwlanFeatureEnabledByUser;
    private boolean mIsEssentialRecordsLoaded;
    private boolean mIsMobileDataEnabled;
    private int mMessageType;
    private int mPdpRejectCauseCode;
    private boolean mPendingDataOff;
    private boolean mPendingRoamingOff;
    private QtiDataResetEventTracker mQtiDataResetEventTracker;
    private QtiDataResetEventTracker.ResetEventListener mResetEventListener;
    private ContentResolver mResolver;
    private ServiceCallback mServiceCallback;
    private int mSubId;
    private SubscriptionManager mSubscriptionManager;
    private final SubscriptionManager.OnSubscriptionsChangedListener mSubscriptionsChangedListener;
    private int mTransportType;

    /* JADX INFO: renamed from: -$$Nest$fgetmCiwlanTimer, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m741$$Nest$fgetmCiwlanTimer(QtiDcTracker r2) {
        return r2.mCiwlanTimer;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ Client m742$$Nest$fgetmClient(QtiDcTracker r0) {
        return r0.mClient;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCrossSimCallingUri, reason: not valid java name */
    static /* bridge */ /* synthetic */ Uri m743$$Nest$fgetmCrossSimCallingUri(QtiDcTracker r0) {
        return r0.mCrossSimCallingUri;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDataRejectCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m744$$Nest$fgetmDataRejectCount(QtiDcTracker r0) {
        return r0.mDataRejectCount;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExtTelephonyManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ExtTelephonyManager m745$$Nest$fgetmExtTelephonyManager(QtiDcTracker r0) {
        return r0.mExtTelephonyManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsCiwlanFeatureEnabledByPlatform, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m746$$Nest$fgetmIsCiwlanFeatureEnabledByPlatform(QtiDcTracker r0) {
        return r0.mIsCiwlanFeatureEnabledByPlatform;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsCiwlanFeatureEnabledByUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m747$$Nest$fgetmIsCiwlanFeatureEnabledByUser(QtiDcTracker r0) {
        return r0.mIsCiwlanFeatureEnabledByUser;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmQtiDataResetEventTracker, reason: not valid java name */
    static /* bridge */ /* synthetic */ QtiDataResetEventTracker m748$$Nest$fgetmQtiDataResetEventTracker(QtiDcTracker r0) {
        return r0.mQtiDataResetEventTracker;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSubId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m749$$Nest$fgetmSubId(QtiDcTracker r0) {
        return r0.mSubId;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCiwlanTimer, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m750$$Nest$fputmCiwlanTimer(QtiDcTracker r0, long r1) {
        r0.mCiwlanTimer = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m751$$Nest$fputmClient(QtiDcTracker r0, Client r1) {
        r0.mClient = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmExtTelephonyServiceConnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m752$$Nest$fputmExtTelephonyServiceConnected(QtiDcTracker r0, boolean r1) {
        r0.mExtTelephonyServiceConnected = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsCiwlanFeatureEnabledByPlatform, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m753$$Nest$fputmIsCiwlanFeatureEnabledByPlatform(QtiDcTracker r0, boolean r1) {
        r0.mIsCiwlanFeatureEnabledByPlatform = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsCiwlanFeatureEnabledByUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m754$$Nest$fputmIsCiwlanFeatureEnabledByUser(QtiDcTracker r0, boolean r1) {
        r0.mIsCiwlanFeatureEnabledByUser = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$misCrossSimCallingEnabledByUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m755$$Nest$misCrossSimCallingEnabledByUser(QtiDcTracker r0) {
        return r0.isCrossSimCallingEnabledByUser();
    }

    /* JADX INFO: renamed from: -$$Nest$mresetDataRejectCounter, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m756$$Nest$mresetDataRejectCounter(QtiDcTracker r0) {
        r0.resetDataRejectCounter();
    }

    /* JADX INFO: renamed from: -$$Nest$msendCrossSimCallingEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m757$$Nest$msendCrossSimCallingEnabled(QtiDcTracker r0) {
        r0.sendCrossSimCallingEnabled();
    }

    /* JADX INFO: renamed from: -$$Nest$msendDataDuringVoiceCallInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m758$$Nest$msendDataDuringVoiceCallInfo(QtiDcTracker r0, boolean r1, int r2) {
        r0.sendDataDuringVoiceCallInfo(r1, r2);
    }

    static {
    }

    private boolean isWCDMA(int r1) {
        if (r1 != 3) goto L5;
    L14:
        return true;
    L5:
        if (r1 == 9) goto L14;
        if (r1 == 10) goto L14;
        if (r1 == 11) goto L14;
        if (r1 == 15) goto L14;
        return false;
    }

    static /* synthetic */ Phone access$000(QtiDcTracker r0) {
        return r0.mPhone;
    }

    static /* synthetic */ Phone access$100(QtiDcTracker r0) {
        return r0.mPhone;
    }

    static /* synthetic */ Phone access$1000(QtiDcTracker r0) {
        return r0.mPhone;
    }

    static /* synthetic */ Phone access$1100(QtiDcTracker r0) {
        return r0.mPhone;
    }

    static /* synthetic */ Phone access$1200(QtiDcTracker r0) {
        return r0.mPhone;
    }

    static /* synthetic */ ConcurrentHashMap access$1300(QtiDcTracker r0) {
        return r0.mApnContexts;
    }

    static /* synthetic */ void access$1400(QtiDcTracker r0, ApnContext r1) {
        r0.cancelReconnect(r1);
    }

    static /* synthetic */ Phone access$200(QtiDcTracker r0) {
        return r0.mPhone;
    }

    static /* synthetic */ Phone access$300(QtiDcTracker r0) {
        return r0.mPhone;
    }

    static /* synthetic */ Phone access$400(QtiDcTracker r0) {
        return r0.mPhone;
    }

    static /* synthetic */ Phone access$500(QtiDcTracker r0) {
        return r0.mPhone;
    }

    static /* synthetic */ DataEnabledSettings access$600(QtiDcTracker r0) {
        return r0.mDataEnabledSettings;
    }

    static /* synthetic */ Phone access$700(QtiDcTracker r0) {
        return r0.mPhone;
    }

    static /* synthetic */ Phone access$800(QtiDcTracker r0) {
        return r0.mPhone;
    }

    static /* synthetic */ Phone access$900(QtiDcTracker r0) {
        return r0.mPhone;
    }

    private void initQtiRadioCapability() {
        Rlog.d(this.LOG_TAG, "initQtiRadioCapability");
        this.mEnhancedRadioCapability = new EnhancedRadioCapabilityResponse();
        this.mPhone.mCi.getEnhancedRadioCapability(obtainMessage(270395));
    }

    public QtiDcTracker(Phone r4, int r5) {
        super(r4, r5);
        this.LOG_TAG = "QtiDCT";
        this.mTransportType = 1;
        this.mQtiDataResetEventTracker = null;
        this.mDataRejectReason = "NONE";
        this.mDataRejectCount = 0;
        this.mPdpRejectCauseCode = 0;
        this.mIsEssentialRecordsLoaded = false;
        this.mExtTelephonyServiceConnected = false;
        this.mSubId = -1;
        this.mCiwlanTimer = -1;
        this.mIsCiwlanFeatureEnabledByPlatform = false;
        this.mIsCiwlanFeatureEnabledByUser = false;
        this.mIsMobileDataEnabled = false;
        this.mPendingDataOff = false;
        this.mPendingRoamingOff = false;
        this.mServiceCallback = new AnonymousClass1(this);
        this.mCallback = new AnonymousClass2(this);
        SubscriptionManager.OnSubscriptionsChangedListener r0 = new AnonymousClass4(this);
        this.mSubscriptionsChangedListener = r0;
        this.mResetEventListener = new AnonymousClass5(this);
        this.mTransportType = r5;
        StringBuilder r1 = new StringBuilder().append(this.LOG_TAG);
        if (r5 != 1) goto L5;
        String r6 = "-C";
    L6:
        this.LOG_TAG = r1.append(r6).toString();
        initQtiRadioCapability();
        ExtTelephonyManager r7 = ExtTelephonyManager.getInstance(this.mPhone.getContext());
        this.mExtTelephonyManager = r7;
        r7.connectService(this.mServiceCallback);
        SubscriptionManager r8 = (SubscriptionManager) this.mPhone.getContext().getSystemService(SubscriptionManager.class);
        this.mSubscriptionManager = r8;
        r8.addOnSubscriptionsChangedListener(r0.getHandlerExecutor(), r0);
        return;
    L5:
        r6 = "-I";
        goto L6
    }

    private boolean isDataEnabledOnDds() {
        SubscriptionController r2 = SubscriptionController.getInstance();
        int r0 = r2.getDefaultDataSubId();
        if (SubscriptionManager.isValidSubscriptionId(r0) == false) goto L5;
        int r3 = r2.getPhoneId(r0);
    L7:
        if (SubscriptionManager.isValidPhoneId(r3) == false) goto L9;
        Phone r4 = PhoneFactory.getPhone(r3);
    L10:
        if (r4 != null) goto L14;
        return false;
    L14:
        return r4.getDataEnabledSettings().isDataEnabled();
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = -1;
        goto L7
    }

    private void sendDataDuringVoiceCallInfo(boolean r3, int r4) {
        if (this.mPhone.isUsingNewDataStack() == false) goto L5;
        return;
    L5:
        if (SubscriptionManager.isValidPhoneId(r4) == true) goto L8;
        return;
    L8:
        if (r3 == true) goto L10;
    L12:
        if (r3 == true) goto L14;
    L17:
        if (this.mExtTelephonyManager != null) goto L19;
        return;
    L19:
        if (PhoneFactory.getPhone(r4).getSmartTempDdsSwitchSupported() == false) goto L24;
        log("Data during voice call: " + r3);
        this.mExtTelephonyManager.sendUserPreferenceForDataDuringVoiceCall(r4, r3, this.mClient);
        return;
    L24:
        return;
    L14:
        if (isDataEnabledOnDds() == true) goto L17;
    L11:
        r3 = false;
        goto L17
    L10:
        if (isCurrentSubDds(PhoneFactory.getPhone(r4)) == false) goto L12;
        goto L11
    }

    protected void onVoiceCallEnded() {
        log("onVoiceCallEnded");
        this.mInVoiceCall = false;
        if (isAnyDataConnected() == false) goto L9;
        if (this.mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed() == true) goto L7;
        startNetStatPoll();
        startDataStallAlarm(false);
        goto L9
    L7:
        resetPollStats();
    L9:
        if (this.mPhone.getSubId() != SubscriptionManager.getDefaultDataSubscriptionId()) goto L12;
        setupDataOnAllConnectableApns("2GVoiceCallEnded", DcTracker.RetryFailures.ALWAYS);
        return;
    }

    protected void log(String r4) {
        Rlog.d(this.LOG_TAG, "[" + this.mPhone.getPhoneId() + "]" + r4);
    }

    public void handleMessage(Message r6) {
        switch(r6.what) {
            case 270382: goto L43;
            case 270387: goto L37;
            case 270395: goto L27;
            case 270396: goto L26;
            case 270536: goto L25;
            case 270537: goto L24;
            case 270538: goto L12;
            case 270539: goto L5;
            default: goto L4;
        };
    L4:
        super.handleMessage(r6);
        return;
    L5:
        log("EVENT_QTI_DISCONNECT_DEFAULT_PDN");
        if (this.mPendingDataOff == false) goto L9;
        this.mPendingDataOff = false;
    L9:
        if (this.mPendingRoamingOff == false) goto L68;
        this.mPendingRoamingOff = false;
        return;
    L68:
        return;
    L24:
        log("EVENT_CARRIER_CONFIG_LOADED_ON_ESSENTIAL_RECORDS");
        onCarrierConfigChanged();
        return;
    L25:
        log("EVENT_RECONNECT_QTI_EXT_TELEPHONY_SERVICE");
        this.mExtTelephonyManager.connectService(this.mServiceCallback);
        return;
    L26:
        log("EVENT_GET_ENHANCED_RADIO_CAPABILITY_RETRY");
        this.mPhone.mCi.getEnhancedRadioCapability(obtainMessage(270395));
        return;
    L27:
        log("EVENT_GET_ENHANCED_RADIO_CAPABILITY");
        if (mGetEnhancedRadioCapabilityRetryCount >= 3) goto L79;
        AsyncResult r7 = (AsyncResult) r6.obj;
        if (r7.exception == null) goto L33;
    L36:
        mGetEnhancedRadioCapabilityRetryCount++;
        sendMessageDelayed(obtainMessage(270396), 500);
        return;
    L33:
        if (r7.result == null) goto L36;
        this.mEnhancedRadioCapability.updateEnhancedRadioCapability(((Integer) r7.result).intValue());
        return;
    L79:
        return;
    L37:
        log("EVENT_DATA_ENABLED_OVERRIDE_RULES_CHANGED");
        if (this.mPhone.isUsingNewDataStack() == false) goto L40;
    L42:
        super.handleMessage(r6);
        return;
    L40:
        if (SubscriptionManager.isValidSubscriptionId(this.mPhone.getSubId()) == false) goto L42;
        sendDataDuringVoiceCallInfo(this.mDataEnabledSettings.isDataAllowedInVoiceCall(), this.mPhone.getPhoneId());
        goto L42
    L43:
        log("EVENT_DATA_ENABLED_CHANGED");
        if (this.mPhone.isUsingNewDataStack() == false) goto L46;
    L60:
        super.handleMessage(r6);
        return;
    L46:
        if (SubscriptionManager.isValidSubscriptionId(this.mPhone.getSubId()) == false) goto L60;
        if (isCurrentSubDds(this.mPhone) == false) goto L60;
        boolean r0 = this.mDataEnabledSettings.isDataEnabled();
        int r2 = 0;
    L51:
        if (r2 >= getPhoneCount()) goto L60;
        Phone r3 = PhoneFactory.getPhone(r2);
        if (r3 == null) goto L59;
        if (isCurrentSubDds(r3) == true) goto L59;
        if (r0 == true) goto L58;
        sendDataDuringVoiceCallInfo(false, r2);
        goto L59
    L58:
        sendDataDuringVoiceCallInfo(r3.getDataEnabledSettings().isDataAllowedInVoiceCall(), r2);
    L59:
        r2 = r2 + 1;
        goto L51
    L12:
        if (this.mPhone.isUsingNewDataStack() == false) goto L14;
        return;
    L14:
        log("EVENT_QTI_SUBSCRIPTION_CHANGED");
        int r8 = this.mSubId;
        int r1 = this.mPhone.getSubId();
        this.mSubId = r1;
        if (r8 != r1) goto L17;
        return;
    L17:
        if (SubscriptionManager.isValidSubscriptionId(r1) == true) goto L19;
        return;
    L19:
        if (this.mExtTelephonyServiceConnected == true) goto L21;
    L23:
        getCiwlanUiInfoAndStartTimer();
        return;
    L21:
        if (this.mIsCiwlanFeatureEnabledByPlatform == false) goto L23;
        this.mIsCiwlanFeatureEnabledByUser = isCrossSimCallingEnabledByUser();
        sendCrossSimCallingEnabled();
        goto L23
    }

    private void getCiwlanUiInfoAndStartTimer() {
        this.mCrossSimCallingUri = Uri.withAppendedPath(SubscriptionManager.CROSS_SIM_ENABLED_CONTENT_URI, String.valueOf(this.mSubId));
        ContentResolver r0 = this.mPhone.getContext().getContentResolver();
        Uri r1 = this.mCrossSimCallingUri;
        final Handler r3 = new Handler();
        r0.registerContentObserver(r1, false, new AnonymousClass3(this, r3));
    }

    private boolean isCurrentSubDds(Phone r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (SubscriptionManager.getDefaultDataSubscriptionId() != r2.getSubId()) goto L9;
        return true;
    L9:
        return false;
    }

    private int getPhoneCount() {
        return ((TelephonyManager) this.mPhone.getContext().getSystemService("phone")).getActiveModemCount();
    }

    private void sendCrossSimCallingEnabled() {
        if (SubscriptionManager.isValidSubscriptionId(this.mSubId) == true) goto L5;
        return;
    L5:
        ImsMmTelManager r0 = getImsMmTelManager();
        if (r0 != null) goto L8;
        return;
    L8:
        log("setCrossSimCallingEnabled: " + this.mIsCiwlanFeatureEnabledByUser);
        r0.setCrossSimCallingEnabled(this.mIsCiwlanFeatureEnabledByUser);     // Catch: ImsException -> L11
        return;
    L11:
        e = move-exception;
        log("fail to send cross SIM calling configuration: " + this.mIsCiwlanFeatureEnabledByUser + " Exception: " + e);
    }

    private boolean isCrossSimCallingEnabledByUser() {
        if (SubscriptionManager.isValidSubscriptionId(this.mSubId) == true) goto L5;
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

    private ImsMmTelManager getImsMmTelManager() {
        if (SubscriptionManager.isValidSubscriptionId(this.mSubId) == true) goto L5;
        return null;
    L5:
        ImsManager r0 = (ImsManager) this.mPhone.getContext().getSystemService(ImsManager.class);
        if (r0 != null) goto L9;
        return null;
    L9:
        return r0.getImsMmTelManager(this.mSubId);
    }

    protected void filterApnSettingsWithRadioCapability() {
        int r0 = 0;
    L4:
        if (r0 >= this.mAllApnSettings.size()) goto L17;
        ApnSetting r1 = (ApnSetting) this.mAllApnSettings.get(r0);
        String r2 = ApnSetting.getApnTypesStringFromBitmask(r1.getApnTypeBitmask());
        if (r1.hasMvnoParams() == false) goto L16;
        if (r1.getMvnoType() != 2) goto L16;
        if (isApnFilteringRequired(r1.getMvnoMatchData(), r2) == false) goto L16;
        String r3 = getApnBasedOnRadioCapability(r1.getMvnoMatchData(), r2, this.mEnhancedRadioCapability.getEnhancedRadioCapability());
        if (r3 == null) goto L16;
        if (r3.equals(r1.getApnName()) == true) goto L16;
        this.mAllApnSettings.remove(r0);
        log("filterApnSettingsWithRadioCapability: removed not supported apn:" + r1);
    L16:
        r0 = r0 + 1;
        goto L4
    }

    private boolean isApnFilteringRequired(String r7, String r8) {
        String[] r6 = CarrierConfigManager.getDefaultConfig().getStringArray("multi_apn_array_for_same_gid");
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        String[] r3 = r6[r2].split(":");
        if (r3.length != 4) goto L11;
        if (r7.equals(r3[0]) == false) goto L11;
        if (r8.equals(r3[1]) == false) goto L11;
        return true;
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        return false;
    }

    private String getApnBasedOnRadioCapability(String r8, String r9, String r10) {
        if (r10 != null) goto L6;
        loge("getApnBasedOnRadioCapability: deviceCapability is null");
        return null;
    L6:
        String[] r7 = CarrierConfigManager.getDefaultConfig().getStringArray("multi_apn_array_for_same_gid");
        int r1 = r7.length;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L20;
        String[] r4 = r7[r3].split(":");
        if (r4.length != 4) goto L19;
        if (r10 == null) goto L19;
        if (r8.equals(r4[0]) == false) goto L19;
        if (r9.equals(r4[1]) == false) goto L19;
        if (r10.equals(r4[2]) == false) goto L19;
        return r4[3];
    L19:
        r3 = r3 + 1;
        goto L7
    L20:
        return null;
    }

    protected void setupDataOnConnectableApn(ApnContext r3, String r4, DcTracker.RetryFailures r5) {
        if (this.mPhone.getContext().getResources().getBoolean(R.bool.config_enableTimeoutToDockUserWhenDocked) == true) goto L5;
    L9:
        super.setupDataOnConnectableApn(r3, r4, r5);
        return;
    L5:
        if (this.mDataRejectCount <= 0) goto L9;
        if (TextUtils.equals(r3.getApnType(), "default") == false) goto L9;
        log("setupDataOnConnectableApn: data retry in progress, skip processing");
    }

    protected void onDataSetupComplete(ApnContext r3, boolean r4, int r5, int r6, int r7) {
        boolean r0 = this.mPhone.getContext().getResources().getBoolean(R.bool.config_enableTimeoutToDockUserWhenDocked);
        if (r4 == false) goto L8;
        if (r0 == true) goto L6;
    L9:
        super.onDataSetupComplete(r3, r4, r5, r6, r7);
        return;
    L6:
        if (TextUtils.equals(r3.getApnType(), "default") == false) goto L9;
        handlePdpRejectCauseSuccess();
        goto L9
    L8:
        this.mPdpRejectCauseCode = r5;
        goto L9
    }

    protected void onDataSetupCompleteError(ApnContext r11, int r12, boolean r13) {
        long r0 = r11.getDelayForNextApn(this.mFailFast);
        log("onDataSetupCompleteError: delay from apnContext=" + r0);
        if (this.mPhone.getContext().getResources().getBoolean(R.bool.config_enableTimeoutToDockUserWhenDocked) == false) goto L32;
        if (TextUtils.equals(r11.getApnType(), "default") == false) goto L32;
        String r2 = DataFailCause.toString(this.mPdpRejectCauseCode);
        ApnSetting r6 = r11.getApnSetting();
        if (isMatchingPdpRejectCause(r2) == false) goto L27;
        if (r6 == null) goto L11;
        log("onDataSetupCompleteError: reset permanent failure on apn");
        r6.setPermanentFailed(false);
    L11:
        if (this.mQtiDataResetEventTracker != null) goto L14;
        this.mQtiDataResetEventTracker = new QtiDataResetEventTracker(this.mTransportType, this.mPhone, this.mResetEventListener);
    L14:
        if (this.mDataRejectCount != 0) goto L16;
        this.mQtiDataResetEventTracker.startResetEventTracker();
    L16:
        boolean r3 = handlePdpRejectCauseFailure(r2);
        if (3 > this.mDataRejectCount) goto L19;
    L26:
        log("onDataSetupCompleteError: reached max retry count");
        displayPopup(this.mDataRejectReason);
        r0 = Long.MAX_VALUE;
    L28:
        log("onDataSetupCompleteError: delay= " + r0);
        if (r0 == Long.MAX_VALUE) goto L32;
        long r7 = SystemClock.elapsedRealtime() + r0;
        log("onDataSetupCompleteError: Set retry time in DataThrottler delay= " + r7 + " ApnTypeBitmask=" + r11.getApnTypeBitmask());
        getDataThrottler().setRetryTime(r11.getApnTypeBitmask(), r7, 1);
        goto L32
    L19:
        if (r0 == Long.MAX_VALUE) goto L26;
        if (r3 == false) goto L28;
        long r8 = getDataThrottler().getRetryTime(r11.getApnTypeBitmask());
        if (r8 == (-1)) goto L25;
        log("onDataSetupCompleteError: network suggested retry time" + r8 + ", skip setting delay");
        goto L28
    L25:
        r0 = this.mPhone.getContext().getResources().getInteger(R.integer.config_lowPowerStandbyNonInteractiveTimeout);
        log("onDataSetupCompleteError: delay from config: " + r0);
        goto L28
    L27:
        log("onDataSetupCompleteError: reset reject count");
        resetDataRejectCounter();
    L32:
        if (r0 >= 0) goto L34;
    L37:
        r11.setState(DctConstants.State.FAILED);
        r11.setDataConnection(null);
        log("onDataSetupCompleteError: Stop retrying APNs. delay=" + r0 + ", requestType=" + requestTypeToString(r12));
        sendHandoverCompleteMessages(r11.getApnTypeBitmask(), false, r13);
        return;
    L34:
        if (r0 == Long.MAX_VALUE) goto L37;
        if (r13 == true) goto L37;
        log("onDataSetupCompleteError: APN type=" + r11.getApnType() + ". Request type=" + requestTypeToString(r12) + ", Retry in " + r0 + "ms.");
        startReconnect(r0, r11, r12);
    }

    protected void onSimStateUpdated(int r1) {
        resetEssentialRecordsLoadedStateIfRequired(r1);
        super.onSimStateUpdated(r1);
    }

    private void resetEssentialRecordsLoadedStateIfRequired(int r1) {
        switch(r1) {
            case 0: goto L4;
            case 1: goto L4;
            case 2: goto L4;
            case 3: goto L4;
            case 4: goto L4;
            case 5: goto L6;
            case 6: goto L4;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L4;
            default: goto L6;
        };
    L4:
        setEssentialRecordsLoaded(false);
        return;
    }

    protected boolean isSimCardPresentAndEssentialRecordsLoaded() {
        int r0 = this.mTelephonyManager.getSimCardState();
        int r1 = SubscriptionManager.getSimStateForSlotIndex(this.mPhone.getPhoneId());
        log("simCardState: " + SubscriptionInfoUpdater.simStateString(r0) + ", simApplicationState: " + SubscriptionInfoUpdater.simStateString(r1));
        if (r0 == 11) goto L5;
    L9:
        return false;
    L5:
        if (r1 != 5) goto L9;
        if (isEssentialRecordsLoaded() == false) goto L9;
        return true;
    }

    public void onCarrierConfigLoadedForEssentialRecords() {
        log("onCarrierConfigLoadedForEssentialRecords");
        sendEmptyMessage(EVENT_CARRIER_CONFIG_LOADED_ON_ESSENTIAL_RECORDS);
    }

    public void setEssentialRecordsLoaded(boolean r3) {
        log("setEssentialRecordsLoaded to " + r3);
        this.mIsEssentialRecordsLoaded = r3;
    }

    private boolean isEssentialRecordsLoaded() {
        log("isEssentialRecordsLoaded: " + this.mIsEssentialRecordsLoaded);
        return this.mIsEssentialRecordsLoaded;
    }

    private void handlePdpRejectCauseSuccess() {
        if (this.mDataRejectCount <= 0) goto L6;
        log("handlePdpRejectCauseSuccess: reset reject count");
        resetDataRejectCounter();
        return;
    }

    private boolean handlePdpRejectCauseFailure(String r3) {
        if (isWCDMA(getDataRat()) == false) goto L10;
        log("handlePdpRejectCauseFailure: reason=" + r3 + ", mDataRejectReason=" + this.mDataRejectReason);
        if (r3.equalsIgnoreCase(this.mDataRejectReason) == true) goto L8;
        resetDataRejectCounter();
    L8:
        if (isMatchingPdpRejectCause(r3) == false) goto L11;
        this.mDataRejectCount++;
        this.mDataRejectReason = r3;
        log("handlePdpRejectCauseFailure: DataRejectCount = " + this.mDataRejectCount);
        return true;
    L11:
        return false;
    L10:
        log("isPdpRejectCauseFailureHandled: DataConnection not on wcdma");
        resetDataRejectCounter();
        goto L11
    }

    private void displayPopup(String r4) {
        log("displayPopup : " + r4);
        String r0 = this.mPhone.getContext().getResources().getString(R.string.config_pdp_reject_user_authentication_failed);
        if (r4.equalsIgnoreCase("USER_AUTHENTICATION") == false) goto L6;
        String r5 = this.mPhone.getContext().getResources().getString(R.string.config_pluginsProviderJarPath);
    L12:
        AlertDialog r1 = mDataRejectDialog;
        if (r1 != null) goto L15;
    L16:
        AlertDialog.Builder r2 = new AlertDialog.Builder(this.mPhone.getContext());
        r2.setPositiveButton(R.string.ok, null);
        mDataRejectDialog = r2.create();
    L17:
        mDataRejectDialog.setMessage(r5);
        mDataRejectDialog.setCanceledOnTouchOutside(false);
        mDataRejectDialog.setTitle(r0);
        mDataRejectDialog.getWindow().setType(2003);
        mDataRejectDialog.show();
        return;
    L15:
        if (r1.isShowing() == true) goto L17;
    L6:
        if (r4.equalsIgnoreCase("SERVICE_OPTION_NOT_SUBSCRIBED") == false) goto L9;
        r5 = this.mPhone.getContext().getResources().getString(R.string.config_platformVpnConfirmDialogComponent);
        goto L12
    L9:
        if (r4.equalsIgnoreCase("MULTI_CONN_TO_SAME_PDN_NOT_ALLOWED") == false) goto L11;
        r5 = this.mPhone.getContext().getResources().getString(R.string.config_persistentDataPackageName);
        goto L12
    L11:
        r5 = null;
        goto L12
    }

    private boolean isMatchingPdpRejectCause(String r1) {
        if (r1.equalsIgnoreCase("USER_AUTHENTICATION") == false) goto L5;
    L10:
        return true;
    L5:
        if (r1.equalsIgnoreCase("SERVICE_OPTION_NOT_SUBSCRIBED") == true) goto L10;
        if (r1.equalsIgnoreCase("MULTI_CONN_TO_SAME_PDN_NOT_ALLOWED") == true) goto L10;
        return false;
    }

    private void resetDataRejectCounter() {
        this.mDataRejectCount = 0;
        this.mDataRejectReason = "NONE";
    }
}
