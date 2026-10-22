package com.android.settings;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.telephony.PhoneNumberUtils;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.GlobalProxyLancet;
import com.android.settings.about.status.SimStatusUtils;
import com.android.settings.deviceinfo.DeviceInfoProvider;
import com.android.settings.deviceinfo.Status;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.utils.RegisterUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.api.KeyEventSmt;
import org.codeaurora.internal.Client;
import org.codeaurora.internal.IExtTelephony;
import org.codeaurora.internal.NrIconType;

/* JADX INFO: loaded from: classes2.dex */
public class SimStatus extends Fragment implements View.OnLongClickListener {
    public static final String INTENT_SELECED_PHONE_SUBSCRIPTION = "subscription";
    private final String TAG;
    private BroadcastReceiver mBroadReceiver;
    private Client mClient;
    private LinearLayout mContainer;
    private Context mContext;
    private AboutStaticItem mDataState;
    private IExtTelephony mExtTelephony;
    private boolean mIsVoLTEAvailable;
    private boolean mIsVolteServiceRegistered;
    private AboutStaticItem mItemIccId;
    private AboutStaticItem mItemMeidNumber;
    private AboutStaticItem mItemMinNumber;
    private AboutStaticItem mItemPrlVersion;
    private BroadcastReceiver mNetWorkReceiver;
    private AboutStaticItem mNetworkType;
    private AboutStaticItem mOperatorName;
    private Bundle mPhoneInfo;
    private AboutStaticItem mPhoneNumber;
    private PhoneStateListener mPhoneStateListener;
    protected Status.PinnedPopupWindow mPopupWindow;
    private Resources mRes;
    private AboutStaticItem mRoamingState;
    private AboutStaticItem mServiceState;
    private AboutStaticItem mSignalStrength;
    private final BroadcastReceiver mSimStateChangedReceiver;
    private int mSlotId;
    SubscriptionManager mSubManager;
    private int mSubscription;
    private String mSummary4G;
    private boolean mSupport5G;
    private TelephonyManager mTelephonyManager;
    private Handler mUiHandler;
    private AboutStaticItem mVoLTEState;

    /* JADX INFO: renamed from: com.android.settings.SimStatus$4, reason: invalid class name */
    class AnonymousClass4 extends BroadcastReceiver {
        final /* synthetic */ SimStatus this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_SimStatus$4_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        AnonymousClass4(SimStatus r1) {
            this.this$0 = r1;
        }

        public void com_android_settings_SimStatus$4__onReceive$___twin___(Context r2, Intent r3) {
            int r4 = r3.getIntExtra(DeviceInfoProvider.SLOT_ID, -1);
            NrIconType r5 = r3.getParcelableExtra(DeviceInfoProvider.NR_ICON_TYPE);
            if (this.this$0.getActivity() == null) goto L17;
            if (r5 != null) goto L7;
            return;
        L7:
            if (SimStatus.access$300(this.this$0) == r4) goto L10;
            return;
        L10:
            if (r5.get() != 1) goto L12;
        L15:
            SimStatus.access$402(this.this$0, true);
            SimStatus.access$500(this.this$0).post(new SimStatus$4$$ExternalSyntheticLambda0(this));
            return;
        L12:
            if (r5.get() == 2) goto L15;
            SimStatus.access$402(this.this$0, false);
            SimStatus.access$500(this.this$0).post(new SimStatus$4$$ExternalSyntheticLambda1(this));
            return;
        }

        /* JADX INFO: renamed from: lambda$onReceive$0$com-android-settings-SimStatus$4, reason: not valid java name */
        /* synthetic */ void m208lambda$onReceive$0$comandroidsettingsSimStatus$4() {
            SimStatus.access$700(this.this$0).setSummary("5G");
        }

        /* JADX INFO: renamed from: lambda$onReceive$1$com-android-settings-SimStatus$4, reason: not valid java name */
        /* synthetic */ void m209lambda$onReceive$1$comandroidsettingsSimStatus$4() {
            SimStatus.access$700(this.this$0).setSummary(SimStatus.access$600(this.this$0));
        }

        @Insert("onReceive")
        public static void com_android_settings_SimStatus$4_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(AnonymousClass4 r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            AnonymousClass4 r1 = r7;
            String r2 = r1.getClass().getName();
            String r3 = r1.getClass().getSimpleName();
            boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
            String r5 = null;
            if (r9 == null) goto L5;
            String r6 = r9.getAction();
        L7:
            if (ArraysKt.contains(r0, r6) == false) goto L13;
            StringBuilder r10 = new StringBuilder("onReceive allowList ");
            if (r9 == null) goto L11;
            r5 = r9.getAction();
        L11:
            OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
            r7.com_android_settings_SimStatus$4__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_SimStatus$4__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_SimStatus$4__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_SimStatus$4__onReceive$___twin___(r8, r9);
            return;
        L19:
            if (r13.length() == 0) goto L22;
            r14 = false;
            goto L23
        L5:
            r6 = null;
            goto L7
        }
    }

    private boolean isSupportMultiVoLTE() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_SimStatus_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_SimStatus_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ void access$000(SimStatus r0) {
        r0.updateDataState();
    }

    static /* synthetic */ void access$100(SimStatus r0, ServiceState r1) {
        r0.updateServiceState(r1);
    }

    static /* synthetic */ void access$200(SimStatus r0, ServiceState r1) {
        r0.updateNetworkType(r1);
    }

    static /* synthetic */ int access$300(SimStatus r0) {
        return r0.mSlotId;
    }

    static /* synthetic */ boolean access$402(SimStatus r0, boolean r1) {
        r0.mSupport5G = r1;
        return r1;
    }

    static /* synthetic */ Handler access$500(SimStatus r0) {
        return r0.mUiHandler;
    }

    static /* synthetic */ String access$600(SimStatus r0) {
        return r0.mSummary4G;
    }

    static /* synthetic */ AboutStaticItem access$700(SimStatus r0) {
        return r0.mNetworkType;
    }

    public SimStatus() {
        this.TAG = "SimStatus";
        this.mPhoneInfo = null;
        this.mSummary4G = "";
        this.mSimStateChangedReceiver = new AnonymousClass2(this);
        this.mBroadReceiver = new AnonymousClass3(this);
        this.mNetWorkReceiver = new AnonymousClass4(this);
    }

    public SimStatus(int r2) {
        this.TAG = "SimStatus";
        this.mPhoneInfo = null;
        this.mSummary4G = "";
        this.mSimStateChangedReceiver = new AnonymousClass2(this);
        this.mBroadReceiver = new AnonymousClass3(this);
        this.mNetWorkReceiver = new AnonymousClass4(this);
        this.mSlotId = r2;
        this.mSubscription = MultiSimAdapter.slot2Sub(r2);
    }

    public void com_android_settings_SimStatus__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        this.mContext = getActivity().getApplicationContext();
        this.mSubManager = SubscriptionManager.from(getActivity());
        this.mTelephonyManager = (TelephonyManager) getActivity().getSystemService(MultiSimAdapter.PHONE_KEY);
        this.mExtTelephony = IExtTelephony.Stub.asInterface(ServiceManager.getService("extphone"));
        this.mRes = getResources();
        this.mUiHandler = new Handler();
        Intent r6 = getActivity().getIntent();
        if (r6 != null) goto L5;
    L7:
        this.mClient = this.mContext.getContentResolver().call(DeviceInfoProvider.DEVICE_INFO_PROVIDER_AUTHORITY, DeviceInfoProvider.REGISTER_5G_STATUS, null, null).getParcelable(DeviceInfoProvider.CLIENT);
        if (UserHandle.myUserId() != 0) goto L10;
        this.mPhoneInfo = this.mContext.getContentResolver().call(DeviceInfoProvider.DEVICE_INFO_PROVIDER_AUTHORITY, DeviceInfoProvider.GET_PHONE_INFO, String.valueOf(this.mSlotId), null);
    L10:
        OLog.d("", "mSlotId:" + this.mSlotId);
        if (this.mSlotId >= 0) goto L13;
        return;
    L13:
        this.mPhoneStateListener = new AnonymousClass1(this);
        queryImsRegisterStatus();
        return;
    L5:
        if (Utils.hasExtraSafely(r6, "subscription") == false) goto L7;
        int r7 = Utils.getIntExtraSafely(r6, "subscription", 0);
        this.mSlotId = r7;
        this.mSubscription = MultiSimAdapter.slot2Sub(r7);
        goto L7
    }

    private void updateNetworkType(ServiceState r3) {
        String r4 = SimStatusUtils.INSTANCE.getNetworkTypeName(this.mTelephonyManager, this.mSlotId);
        this.mSummary4G = r4;
        this.mNetworkType.setSummary(r4);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        View r6 = r3.inflate(R.layout.sim_status_layout, null);
        this.mOperatorName = (AboutStaticItem) r6.findViewById(R.id.operator_name);
        this.mSignalStrength = (AboutStaticItem) r6.findViewById(R.id.signal_strength);
        this.mNetworkType = (AboutStaticItem) r6.findViewById(R.id.network_type);
        this.mVoLTEState = (AboutStaticItem) r6.findViewById(R.id.volte_state);
        this.mServiceState = (AboutStaticItem) r6.findViewById(R.id.service_state);
        this.mRoamingState = (AboutStaticItem) r6.findViewById(R.id.roaming_state);
        this.mDataState = (AboutStaticItem) r6.findViewById(R.id.data_state);
        this.mPhoneNumber = (AboutStaticItem) r6.findViewById(R.id.number);
        this.mItemMinNumber = (AboutStaticItem) r6.findViewById(R.id.min_number);
        this.mItemPrlVersion = (AboutStaticItem) r6.findViewById(R.id.prl_version);
        this.mItemMeidNumber = (AboutStaticItem) r6.findViewById(R.id.meid_number);
        this.mItemIccId = (AboutStaticItem) r6.findViewById(R.id.icc_id);
        if (this.mPhoneInfo != null) goto L5;
    L20:
        this.mContainer = (LinearLayout) r6.findViewById(R.id.container);
        allowLongClickCopy();
        return r6;
    L5:
        if (Utils.isWifiOnly(this.mContext) == true) goto L20;
        TelephonyManager.getDefault();
        if ("CDMA".equals(this.mPhoneInfo.getString(DeviceInfoProvider.PHONE_NAME)) == false) goto L19;
        this.mItemMeidNumber.setSummary(this.mPhoneInfo.getString(DeviceInfoProvider.MEID));
        String r7 = this.mPhoneInfo.getString(DeviceInfoProvider.CDMA_MIN);
        if (TextUtils.isEmpty(r7) == false) goto L12;
        r7 = getString(R.string.device_info_default);
    L12:
        this.mItemMinNumber.setSummary(r7);
        if (getResources().getBoolean(R.bool.config_msid_enable) == false) goto L15;
        this.mItemMinNumber.setTitle(getString(R.string.status_msid_number));
    L15:
        this.mItemPrlVersion.setSummary(this.mPhoneInfo.getString(DeviceInfoProvider.CDMA_PRL_VERSION));
        if (this.mPhoneInfo.getInt(DeviceInfoProvider.LTE_ON_CDMA_MODE, -1) != 1) goto L18;
        this.mItemIccId.setSummary(this.mPhoneInfo.getString(DeviceInfoProvider.ICC_SERIAL_NUMBER));
        goto L20
    L18:
        this.mItemIccId.setVisibility(8);
        goto L20
    L19:
        this.mItemPrlVersion.setVisibility(8);
        this.mItemMeidNumber.setVisibility(8);
        this.mItemMinNumber.setVisibility(8);
        this.mItemIccId.setVisibility(8);
        goto L20
    }

    public void com_android_settings_SimStatus__onResume$___twin___() {
        super.onResume();
        if (this.mPhoneInfo != null) goto L5;
    L10:
        this.mIsVoLTEAvailable = isVoLTEAvailable();
        updateVoLTEState();
        if ((getActivity() instanceof MultiSimSimStatus) == false) goto L13;
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getActivity(), this.mSimStateChangedReceiver, new IntentFilter("android.intent.action.SIM_STATE_CHANGED"), 2);
    L13:
        updateItemBorder();
        return;
    L5:
        if (Utils.isWifiOnly(getActivity().getApplicationContext()) == true) goto L10;
        String r0 = this.mPhoneInfo.getString(DeviceInfoProvider.LINE_1_NUMBER);
        if (TextUtils.isEmpty(r0) == true) goto L9;
        String r1 = PhoneNumberUtils.formatNumber(r0);
        this.mPhoneNumber.setSummary(r1);
    L9:
        updateSignalStrength((SignalStrength) this.mPhoneInfo.getParcelable(DeviceInfoProvider.SIGNAL_STRENGTH));
        updateServiceState((ServiceState) this.mPhoneInfo.getParcelable(DeviceInfoProvider.SERVICE_STATE));
        updateDataState();
        registerPhoneStateListener();
        IntentFilter r2 = new IntentFilter(DeviceInfoProvider.ACTION_ON_NR_ICON_TYPE);
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mNetWorkReceiver, r2, 2);
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mPhoneInfo == null) goto L8;
        if (Utils.isWifiOnly(getActivity().getApplicationContext()) == true) goto L8;
        unregisertPhoneStateListener();
        this.mContext.unregisterReceiver(this.mNetWorkReceiver);
    L8:
        if ((getActivity() instanceof MultiSimSimStatus) == false) goto L11;
        RegisterUtils.unRegisterBroadcastReceiverSafely("SimStatus", getActivity(), this.mSimStateChangedReceiver);
        return;
    }

    private void registerPhoneStateListener() {
        if (this.mSlotId >= 0) goto L6;
        OLog.i("SimStatus", "no need to registerPhoneStateListener");
        return;
    L6:
        this.mTelephonyManager.createForSubscriptionId(this.mSubscription).listen(this.mPhoneStateListener, KeyEventSmt.KEYCODE_F20);
    }

    private void unregisertPhoneStateListener() {
        if (this.mSlotId >= 0) goto L6;
        OLog.i("SimStatus", "no need to unregisterPhoneStateListener");
        return;
    L6:
        this.mTelephonyManager.createForSubscriptionId(this.mSubscription).listen(this.mPhoneStateListener, 0);
    }

    private void updateDataState() {
        String r0 = this.mRes.getString(R.string.radioInfo_unknown);
        if (this.mSubscription == SubscriptionManager.getDefaultDataSubscriptionId()) goto L5;
        r0 = this.mRes.getString(R.string.radioInfo_data_disconnected);
    L18:
        this.mDataState.setSummary(r0);
        return;
    L5:
        int r1 = this.mTelephonyManager.getDataState();
        if (r1 != 0) goto L8;
        r0 = this.mRes.getString(R.string.radioInfo_data_disconnected);
        goto L18
    L8:
        if (r1 != 1) goto L10;
        r0 = this.mRes.getString(R.string.radioInfo_data_connecting);
        goto L18
    L10:
        if (r1 != 2) goto L12;
        r0 = this.mRes.getString(R.string.radioInfo_data_connected);
        goto L18
    L12:
        if (r1 != 3) goto L18;
        r0 = this.mRes.getString(R.string.radioInfo_data_suspended);
        goto L18
    }

    private void updateServiceState(ServiceState r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        String r0 = getServiceStateString(r4.getState());
        this.mServiceState.setSummary(r0);
        if (r4.getRoaming() == false) goto L7;
        this.mRoamingState.setSummary(this.mRes.getString(R.string.radioInfo_roaming_in));
    L8:
        String r5 = r4.getOperatorAlphaLong();
        if (TextUtils.isEmpty(r5) == true) goto L11;
        this.mOperatorName.setSummary(r5);
        return;
    L11:
        this.mOperatorName.setSummary(R.string.device_info_not_available);
        return;
    L7:
        this.mRoamingState.setSummary(this.mRes.getString(R.string.radioInfo_roaming_not));
        goto L8
    }

    private String getServiceStateString(int r2) {
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L14;
        if (r2 == 2) goto L14;
        if (r2 == 3) goto L12;
        return this.mRes.getString(R.string.radioInfo_unknown);
    L12:
        return this.mRes.getString(R.string.radioInfo_service_off);
    L14:
        return this.mRes.getString(R.string.radioInfo_service_out);
    L16:
        return this.mRes.getString(R.string.radioInfo_service_in);
    }

    void updateSignalStrength(SignalStrength r5) {
        List<SubscriptionInfo> r0 = SubscriptionManager.from(this.mContext).getActiveSubscriptionInfoList();
        if (r0 != null) goto L5;
    L30:
        this.mSignalStrength.setSummary(R.string.status_unavailable);
        return;
    L5:
        if (r0.isEmpty() == true) goto L30;
        if (this.mSignalStrength == null) goto L32;
        Bundle r1 = this.mPhoneInfo;
        if (r1 == null) goto L33;
        int r2 = ((ServiceState) r1.getParcelable(DeviceInfoProvider.SERVICE_STATE)).getState();
        if (isDetached() == false) goto L15;
        return;
    L15:
        if (isAdded() == false) goto L34;
        Resources r3 = getResources();
        if (1 != r2) goto L19;
    L20:
        this.mSignalStrength.setSummary("0");
    L21:
        int r4 = r5.getDbm();
        int r6 = 0;
        if ((-1) != r4) goto L24;
        r4 = 0;
    L24:
        int r7 = r5.getAsuLevel();
        if ((-1) == r7) goto L28;
        r6 = r7;
    L28:
        this.mSignalStrength.setSummary(String.valueOf(r4) + HanziToPinyin.Token.SEPARATOR + r3.getString(R.string.radioInfo_display_dbm) + "   " + String.valueOf(r6) + HanziToPinyin.Token.SEPARATOR + r3.getString(R.string.radioInfo_display_asu));
        return;
    L19:
        if (3 != r2) goto L21;
    L34:
        return;
    L33:
        return;
    }

    private boolean isVoLTEAvailable() {
        return MultiSDKAdapter.isVoLTEAvailable(this.mContext, isSupportMultiVoLTE(), this.mSubManager, this.mSlotId);
    }

    private void updateVoLTEState() {
        if (this.mIsVoLTEAvailable == false) goto L12;
        this.mVoLTEState.setVisibility(0);
        if (Utils.isSimExists() == false) goto L11;
        AboutStaticItem r0 = this.mVoLTEState;
        if (this.mIsVolteServiceRegistered == false) goto L9;
        int r2 = R.string.radioInfo_data_connected;
    L10:
        r0.setSummary(r2);
        return;
    L9:
        r2 = R.string.radioInfo_data_disconnected;
        goto L10
    L11:
        this.mVoLTEState.setSummary(R.string.status_unavailable);
        return;
    L12:
        this.mVoLTEState.setVisibility(8);
    }

    private void updateItemBorder() {
        LinearLayout r0 = this.mContainer;
        if (r0 != null) goto L26;
        return;
    L26:
        int r1 = r0.getChildCount();     // Catch: Exception -> L23
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L14;
        View r3 = this.mContainer.getChildAt(r2);     // Catch: Exception -> L23
        if (r3.getVisibility() == 0) goto L11;
        r2 = r2 + 1;     // Catch: Exception -> L23
        goto L7
    L11:
        if ((r3 instanceof AboutStaticItem) == false) goto L14;
        ((AboutStaticItem) r3).setCardPosition(1);     // Catch: Exception -> L23
    L14:
        int r4 = r1 - 1;     // Catch: Exception -> L23
    L15:
        if (r4 < 0) goto L34;
        View r5 = this.mContainer.getChildAt(r4);     // Catch: Exception -> L23
        if (r5.getVisibility() == 0) goto L19;
        r4 = r4 - 1;
        goto L15
    L19:
        if ((r5 instanceof AboutStaticItem) == false) goto L32;
        ((AboutStaticItem) r5).setCardPosition(3);     // Catch: Exception -> L23
        return;
    L32:
        return;
    L34:
        return;
    L23:
        e = move-exception;
        OLog.e("SimStatus", "updateItemBorder()", e);
    }

    private void queryImsRegisterStatus() {
        this.mIsVolteServiceRegistered = MultiSDKAdapter.isImsConnected(this.mContext, this.mSlotId);
        OLog.d("SimStatus", "queryVolteRegisterStatus()" + this.mIsVolteServiceRegistered);
    }

    private void allowLongClickCopy() {
        this.mOperatorName.setOnLongClickListener(this);
        this.mSignalStrength.setOnLongClickListener(this);
        this.mNetworkType.setOnLongClickListener(this);
        this.mVoLTEState.setOnLongClickListener(this);
        this.mServiceState.setOnLongClickListener(this);
        this.mRoamingState.setOnLongClickListener(this);
        this.mDataState.setOnLongClickListener(this);
        this.mPhoneNumber.setOnLongClickListener(this);
        this.mItemMinNumber.setOnLongClickListener(this);
        this.mItemPrlVersion.setOnLongClickListener(this);
        this.mItemMeidNumber.setOnLongClickListener(this);
        this.mItemIccId.setOnLongClickListener(this);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View r11) {
        if ((r11 instanceof AboutStaticItem) == false) goto L8;
        final AboutStaticItem r0 = (AboutStaticItem) r11;
        final CharSequence r2 = r0.getSummary().getText();
        if (this.mPopupWindow != null) goto L7;
        this.mPopupWindow = new Status.PinnedPopupWindow(getContext());
    L7:
        this.mPopupWindow.setCopyText(r2);
        int[] r4 = new int[2];
        r0.getSummary().getLocationOnScreen(r4);
        SpannableStringBuilder r5 = new SpannableStringBuilder();
        r5.append(r2);
        int r6 = r5.length();
        r5.setSpan(new BackgroundColorSpan(getResources().getColor(R.color.highlighted_text_bytedanceos_light)), 0, r6, 33);
        r0.getSummary().setText(r5);
        int r7 = (int) getResources().getDimension(R.dimen.pinned_popup_window_height);
        this.mPopupWindow.showAtLocation(r11, 0, (r4[0] + (r0.getSummary().getWidth() / 2)) - ((int) getResources().getDimension(R.dimen.pinned_popup_window_half_width)), r4[1] - r7);
        this.mPopupWindow.setOnDismissListener(new AnonymousClass5(this, r0, r2));
    L8:
        return true;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_SimStatus_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SimStatus r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_SimStatus__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SimStatus_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SimStatus r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_SimStatus_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SimStatus_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SimStatus r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_SimStatus__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
