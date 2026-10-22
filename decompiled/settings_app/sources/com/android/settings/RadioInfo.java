package com.android.settings;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.DataConnectionRealTimeInfo;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.PreciseCallState;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import androidx.core.os.EnvironmentCompat;
import com.android.ims.ImsManager;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneFactory;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class RadioInfo extends BaseActivity {
    private static final int CELL_INFO_LIST_RATE_DISABLED = Integer.MAX_VALUE;
    private static final int CELL_INFO_LIST_RATE_MAX = 0;
    private static final int EVENT_CFI_CHANGED = 302;
    private static final int EVENT_QUERY_PREFERRED_TYPE_DONE = 1000;
    private static final int EVENT_QUERY_SMSC_DONE = 1005;
    private static final int EVENT_SET_PREFERRED_TYPE_DONE = 1001;
    private static final int EVENT_UPDATE_SMSC_DONE = 1006;
    private static final int MENU_ITEM_GET_PDP_LIST = 4;
    private static final int MENU_ITEM_SELECT_BAND = 0;
    private static final int MENU_ITEM_TOGGLE_DATA = 5;
    private static final int MENU_ITEM_VIEW_ADN = 1;
    private static final int MENU_ITEM_VIEW_FDN = 2;
    private static final int MENU_ITEM_VIEW_SDN = 3;
    private static final String[] mCellInfoRefreshRateLabels = null;
    private static final int[] mCellInfoRefreshRates = null;
    private final String TAG;
    private TextView callState;
    private Button cellInfoRefreshRateButton;
    private Spinner cellInfoRefreshRateSpinner;
    private TextView dBm;
    private TextView dataNetwork;
    private TextView dnsCheckState;
    private Button dnsCheckToggleButton;
    private TextView gprsState;
    private TextView gsmState;
    private Switch imsVoLteProvisionedSwitch;
    private TextView mCellInfo;
    AdapterView.OnItemSelectedListener mCellInfoRefreshRateHandler;
    private int mCellInfoRefreshRateIndex;
    private List<CellInfo> mCellInfoResult;
    private CellLocation mCellLocationResult;
    private TextView mCfi;
    private boolean mCfiValue;
    private TextView mDcRtInfoTv;
    private TextView mDeviceId;
    View.OnClickListener mDnsCheckButtonHandler;
    private MenuItem.OnMenuItemClickListener mGetPdpList;
    private Handler mHandler;
    private TextView mHttpClientTest;
    private String mHttpClientTestResult;
    private ImsManager mImsManager;
    CompoundButton.OnCheckedChangeListener mImsVoLteCheckedChangeListener;
    private TextView mLocation;
    private TextView mMwi;
    private boolean mMwiValue;
    private List<NeighboringCellInfo> mNeighboringCellResult;
    private TextView mNeighboringCids;
    View.OnClickListener mOemInfoButtonHandler;
    private MsimPhoneStateListener mPhoneStateListener;
    View.OnClickListener mPingButtonHandler;
    private String mPingHostnameResultV4;
    private String mPingHostnameResultV6;
    private TextView mPingHostnameV4;
    private TextView mPingHostnameV6;
    AdapterView.OnItemSelectedListener mPreferredNetworkHandler;
    private final String[] mPreferredNetworkLabels;
    private int[] mPreferredNetworkList;
    private int mPreferredNetworkTypeResult;
    CompoundButton.OnCheckedChangeListener mRadioPowerOnChangeListener;
    View.OnClickListener mRefreshSmscButtonHandler;
    private boolean mSdkBeforeQ;
    private MenuItem.OnMenuItemClickListener mSelectBandCallback;
    private int mSlotID;
    private int mSubID;
    private TelephonyManager mTelephonyManager;
    private MenuItem.OnMenuItemClickListener mToggleData;
    View.OnClickListener mUpdateSmscButtonHandler;
    private MenuItem.OnMenuItemClickListener mViewADNCallback;
    private MenuItem.OnMenuItemClickListener mViewFDNCallback;
    private MenuItem.OnMenuItemClickListener mViewSDNCallback;
    private TextView number;
    private Button oemInfoButton;
    private TextView operatorName;
    private Phone phone;
    private Button pingTestButton;
    private Spinner preferredNetworkType;
    private Switch radioPowerOnSwitch;
    private TextView received;
    private Button refreshSmscButton;
    private TextView roamingState;
    private TextView sent;
    private EditText smsc;
    private Button updateSmscButton;
    private TextView voiceNetwork;

    private class MsimPhoneStateListener extends PhoneStateListener {
        final /* synthetic */ RadioInfo this$0;

        public MsimPhoneStateListener(RadioInfo r1) {
            this.this$0 = r1;
        }

        public MsimPhoneStateListener(RadioInfo r1, int r2) {
            this.this$0 = r1;
            super(Integer.valueOf(r2));
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int r1) {
            RadioInfo.access$000(this.this$0);
            RadioInfo.access$100(this.this$0);
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataActivity(int r1) {
            RadioInfo.access$200(this.this$0);
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int r1, String r2) {
            RadioInfo.access$100(this.this$0);
            RadioInfo.access$300(this.this$0, r1);
        }

        public void onPreciseCallStateChanged(PreciseCallState r1) {
            RadioInfo.access$100(this.this$0);
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellLocationChanged(CellLocation r1) {
            RadioInfo.access$400(this.this$0, r1);
        }

        @Override // android.telephony.PhoneStateListener
        public void onMessageWaitingIndicatorChanged(boolean r2) {
            RadioInfo.access$502(this.this$0, r2);
            RadioInfo.access$600(this.this$0);
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallForwardingIndicatorChanged(boolean r2) {
            RadioInfo.access$702(this.this$0, r2);
            RadioInfo.access$800(this.this$0);
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellInfoChanged(List<CellInfo> r4) {
            RadioInfo.access$900(this.this$0, "onCellInfoChanged: arrayCi=" + r4);
            RadioInfo.access$1002(this.this$0, r4);
            RadioInfo r3 = this.this$0;
            RadioInfo.access$1100(r3, RadioInfo.access$1000(r3));
        }

        public void onDataConnectionRealTimeInfoChanged(DataConnectionRealTimeInfo r4) {
            RadioInfo.access$900(this.this$0, "onDataConnectionRealTimeInfoChanged: dcRtInfo=" + r4);
            RadioInfo.access$1200(this.this$0, r4);
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength r4) {
            RadioInfo.access$900(this.this$0, "onSignalStrengthChanged: SignalStrength=" + r4);
            RadioInfo.access$1300(this.this$0, r4);
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState r4) {
            RadioInfo.access$900(this.this$0, "onServiceStateChanged: ServiceState=" + r4);
            RadioInfo.access$1400(this.this$0, r4);
            RadioInfo.access$1500(this.this$0);
            RadioInfo.access$100(this.this$0);
            RadioInfo.access$1600(this.this$0);
        }
    }

    public void com_android_settings_RadioInfo__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_RadioInfo__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_RadioInfo_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_RadioInfo_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_RadioInfo_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_RadioInfo_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_RadioInfo_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public RadioInfo() {
        this.TAG = "RadioInfo";
        this.mPreferredNetworkLabels = new String[]{"WCDMA preferred", "GSM only", "WCDMA only", "GSM auto (PRL)", "CDMA auto (PRL)", "CDMA only", "EvDo only", "Global auto (PRL)", "LTE/CDMA auto (PRL)", "LTE/UMTS auto (PRL)", "LTE/CDMA/UMTS auto (PRL)", "LTE only", "LTE/WCDMA", "TD-SCDMA only", "TD-SCDMA/WCDMA", "LTE/TD-SCDMA", "TD-SCDMA/GSM", "TD-SCDMA/UMTS", "LTE/TD-SCDMA/WCDMA", "LTE/TD-SCDMA/UMTS", "TD-CDMA/GSM/WCDMA/LTE only", "TD-SCDMA/CDMA/UMTS", "Global/TD-SCDMA", "Unknown"};
        this.mImsManager = null;
        this.phone = null;
        this.mMwiValue = false;
        this.mCfiValue = false;
        this.mCellInfoResult = null;
        this.mCellLocationResult = null;
        this.mNeighboringCellResult = null;
        this.mSlotID = -1;
        this.mSubID = -1;
        this.mHandler = new AnonymousClass1(this);
        this.mViewADNCallback = new AnonymousClass7(this);
        this.mViewFDNCallback = new AnonymousClass8(this);
        this.mViewSDNCallback = new AnonymousClass9(this);
        this.mGetPdpList = new AnonymousClass10(this);
        this.mSelectBandCallback = new AnonymousClass11(this);
        this.mToggleData = new AnonymousClass12(this);
        this.mRadioPowerOnChangeListener = new AnonymousClass13(this);
        this.mImsVoLteCheckedChangeListener = new AnonymousClass15(this);
        this.mDnsCheckButtonHandler = new AnonymousClass16(this);
        this.mOemInfoButtonHandler = new AnonymousClass17(this);
        this.mPingButtonHandler = new AnonymousClass18(this);
        this.mUpdateSmscButtonHandler = new AnonymousClass19(this);
        this.mRefreshSmscButtonHandler = new AnonymousClass20(this);
        this.mPreferredNetworkHandler = new AnonymousClass21(this);
        this.mCellInfoRefreshRateHandler = new AnonymousClass22(this);
    }

    static /* synthetic */ void access$000(RadioInfo r0) {
        r0.updateDataState();
    }

    static /* synthetic */ void access$100(RadioInfo r0) {
        r0.updateNetworkType();
    }

    static /* synthetic */ List access$1000(RadioInfo r0) {
        return r0.mCellInfoResult;
    }

    static /* synthetic */ List access$1002(RadioInfo r0, List r1) {
        r0.mCellInfoResult = r1;
        return r1;
    }

    static /* synthetic */ void access$1100(RadioInfo r0, List r1) {
        r0.updateCellInfo(r1);
    }

    static /* synthetic */ void access$1200(RadioInfo r0, DataConnectionRealTimeInfo r1) {
        r0.updateDcRtInfoTv(r1);
    }

    static /* synthetic */ void access$1300(RadioInfo r0, SignalStrength r1) {
        r0.updateSignalStrength(r1);
    }

    static /* synthetic */ void access$1400(RadioInfo r0, ServiceState r1) {
        r0.updateServiceState(r1);
    }

    static /* synthetic */ void access$1500(RadioInfo r0) {
        r0.updateRadioPowerState();
    }

    static /* synthetic */ void access$1600(RadioInfo r0) {
        r0.updateImsVoLteProvisionedState();
    }

    static /* synthetic */ void access$1700(RadioInfo r0, int r1) {
        r0.updatePreferredNetworkType(r1);
    }

    static /* synthetic */ String[] access$1800(RadioInfo r0) {
        return r0.mPreferredNetworkLabels;
    }

    static /* synthetic */ EditText access$1900(RadioInfo r0) {
        return r0.smsc;
    }

    static /* synthetic */ void access$200(RadioInfo r0) {
        r0.updateDataStats2();
    }

    static /* synthetic */ Button access$2000(RadioInfo r0) {
        return r0.updateSmscButton;
    }

    static /* synthetic */ List access$2100(RadioInfo r0) {
        return r0.mNeighboringCellResult;
    }

    static /* synthetic */ void access$2200(RadioInfo r0, List r1) {
        r0.updateNeighboringCids(r1);
    }

    static /* synthetic */ CellLocation access$2300(RadioInfo r0) {
        return r0.mCellLocationResult;
    }

    static /* synthetic */ String access$2400(RadioInfo r0) {
        return r0.mPingHostnameResultV4;
    }

    static /* synthetic */ TextView access$2500(RadioInfo r0) {
        return r0.mPingHostnameV4;
    }

    static /* synthetic */ String access$2600(RadioInfo r0) {
        return r0.mPingHostnameResultV6;
    }

    static /* synthetic */ TextView access$2700(RadioInfo r0) {
        return r0.mPingHostnameV6;
    }

    static /* synthetic */ String access$2800(RadioInfo r0) {
        return r0.mHttpClientTestResult;
    }

    static /* synthetic */ TextView access$2900(RadioInfo r0) {
        return r0.mHttpClientTest;
    }

    static /* synthetic */ void access$300(RadioInfo r0, int r1) {
        r0.updatePhoneState(r1);
    }

    static /* synthetic */ void access$3000(RadioInfo r0) {
        r0.pingHostname();
    }

    static /* synthetic */ Handler access$3100(RadioInfo r0) {
        return r0.mHandler;
    }

    static /* synthetic */ void access$3200(RadioInfo r0) {
        r0.httpClientTest();
    }

    static /* synthetic */ Phone access$3300(RadioInfo r0) {
        return r0.phone;
    }

    static /* synthetic */ TelephonyManager access$3400(RadioInfo r0) {
        return r0.mTelephonyManager;
    }

    static /* synthetic */ boolean access$3500(RadioInfo r0) {
        return r0.isRadioOn();
    }

    static /* synthetic */ ImsManager access$3600(RadioInfo r0) {
        return r0.mImsManager;
    }

    static /* synthetic */ void access$3700(RadioInfo r0) {
        r0.updateDnsCheckState();
    }

    static /* synthetic */ void access$3800(RadioInfo r0) {
        r0.updatePingState();
    }

    static /* synthetic */ void access$3900(RadioInfo r0) {
        r0.refreshSmsc();
    }

    static /* synthetic */ void access$400(RadioInfo r0, CellLocation r1) {
        r0.updateLocation(r1);
    }

    static /* synthetic */ int access$4000(RadioInfo r0) {
        return r0.mPreferredNetworkTypeResult;
    }

    static /* synthetic */ int access$4002(RadioInfo r0, int r1) {
        r0.mPreferredNetworkTypeResult = r1;
        return r1;
    }

    static /* synthetic */ int[] access$4100(RadioInfo r0) {
        return r0.mPreferredNetworkList;
    }

    static /* synthetic */ int access$4202(RadioInfo r0, int r1) {
        r0.mCellInfoRefreshRateIndex = r1;
        return r1;
    }

    static /* synthetic */ int[] access$4300() {
        return mCellInfoRefreshRates;
    }

    static /* synthetic */ void access$4400(RadioInfo r0) {
        r0.updateAllCellInfo();
    }

    static /* synthetic */ boolean access$502(RadioInfo r0, boolean r1) {
        r0.mMwiValue = r1;
        return r1;
    }

    static /* synthetic */ void access$600(RadioInfo r0) {
        r0.updateMessageWaiting();
    }

    static /* synthetic */ boolean access$702(RadioInfo r0, boolean r1) {
        r0.mCfiValue = r1;
        return r1;
    }

    static /* synthetic */ void access$800(RadioInfo r0) {
        r0.updateCallRedirect();
    }

    static /* synthetic */ void access$900(RadioInfo r0, String r1) {
        r0.log(r1);
    }

    static {
        mCellInfoRefreshRateLabels = new String[]{"Disabled", "Immediate", "Min 5s", "Min 10s", "Min 60s"};
        mCellInfoRefreshRates = new int[]{Integer.MAX_VALUE, 0, 5000, 10000, 60000};
    }

    private void updatePreferredNetworkType(int r4) {
        Log.d("RadioInfo", "updatePreferredNetworkType " + r4);
        if (r4 >= this.mPreferredNetworkLabels.length) goto L5;
        if (r4 < 0) goto L5;
    L6:
        this.mPreferredNetworkTypeResult = r4;
        this.preferredNetworkType.setSelection(r4, true);
        return;
    L5:
        log("EVENT_QUERY_PREFERRED_TYPE_DONE: unknown type=" + r4);
        r4 = this.mPreferredNetworkLabels.length - 1;
        goto L6
    }

    public void com_android_settings_RadioInfo__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        setContentView(R.layout.radio_info);
        this.mSdkBeforeQ = false;
        this.mBackView = this.mTitle.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null);
        this.mBackView.setOnClickListener(new AnonymousClass2(this));
        int r1 = getIntent().getIntExtra(TestingSettings.INTENT_SLOT_EXTRA_NAME, 0);
        this.mSlotID = r1;
        if (r1 > 1) goto L5;
        if (r1 < 0) goto L5;
    L6:
        this.mTelephonyManager = (TelephonyManager) getSystemService(MultiSimAdapter.PHONE_KEY);
        int r2 = this.mSlotID;
        if (r2 != 0) goto L9;
        this.phone = PhoneFactory.getDefaultPhone();
    L11:
        if (this.phone != null) goto L13;
        this.phone = PhoneFactory.getDefaultPhone();
    L13:
        this.mImsManager = ImsManager.getInstance(getApplicationContext(), SubscriptionManager.getDefaultVoicePhoneId());
        this.mDeviceId = (TextView) findViewById(R.id.imei);
        this.number = (TextView) findViewById(R.id.number);
        this.callState = (TextView) findViewById(R.id.call);
        this.operatorName = (TextView) findViewById(R.id.operator);
        this.roamingState = (TextView) findViewById(R.id.roaming);
        this.gsmState = (TextView) findViewById(R.id.gsm);
        this.gprsState = (TextView) findViewById(R.id.gprs);
        this.voiceNetwork = (TextView) findViewById(R.id.voice_network);
        this.dataNetwork = (TextView) findViewById(R.id.data_network);
        this.dBm = (TextView) findViewById(R.id.dbm);
        this.mMwi = (TextView) findViewById(R.id.mwi);
        this.mCfi = (TextView) findViewById(R.id.cfi);
        this.mLocation = (TextView) findViewById(R.id.location);
        this.mNeighboringCids = (TextView) findViewById(R.id.neighboring);
        TextView r3 = (TextView) findViewById(R.id.cellinfo);
        this.mCellInfo = r3;
        r3.setTypeface(Typeface.MONOSPACE);
        this.mDcRtInfoTv = (TextView) findViewById(R.id.dcrtinfo);
        this.sent = (TextView) findViewById(R.id.sent);
        this.received = (TextView) findViewById(R.id.received);
        this.smsc = (EditText) findViewById(R.id.smsc);
        this.dnsCheckState = (TextView) findViewById(R.id.dnsCheckState);
        this.mPingHostnameV4 = (TextView) findViewById(R.id.pingHostnameV4);
        this.mPingHostnameV6 = (TextView) findViewById(R.id.pingHostnameV6);
        this.mHttpClientTest = (TextView) findViewById(R.id.httpClientTest);
        this.mPreferredNetworkList = getResources().getIntArray(R.array.network_mode_type_list);
        this.preferredNetworkType = (Spinner) findViewById(R.id.preferredNetworkType);
        ArrayAdapter r4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, this.mPreferredNetworkLabels);
        r4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.preferredNetworkType.setAdapter(r4);
        this.cellInfoRefreshRateSpinner = (Spinner) findViewById(R.id.cell_info_rate_select);
        ArrayAdapter r5 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mCellInfoRefreshRateLabels);
        r5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.cellInfoRefreshRateSpinner.setAdapter(r5);
        this.imsVoLteProvisionedSwitch = (Switch) findViewById(R.id.volte_provisioned_switch);
        this.radioPowerOnSwitch = (Switch) findViewById(R.id.radio_power);
        Button r6 = (Button) findViewById(R.id.ping_test);
        this.pingTestButton = r6;
        r6.setOnClickListener(this.mPingButtonHandler);
        Button r8 = (Button) findViewById(R.id.update_smsc);
        this.updateSmscButton = r8;
        r8.setOnClickListener(this.mUpdateSmscButtonHandler);
        Button r9 = (Button) findViewById(R.id.refresh_smsc);
        this.refreshSmscButton = r9;
        r9.setOnClickListener(this.mRefreshSmscButtonHandler);
        Button r10 = (Button) findViewById(R.id.dns_check_toggle);
        this.dnsCheckToggleButton = r10;
        r10.setOnClickListener(this.mDnsCheckButtonHandler);
        Button r11 = (Button) findViewById(R.id.oem_info);
        this.oemInfoButton = r11;
        r11.setOnClickListener(this.mOemInfoButtonHandler);
        PackageManager r12 = getPackageManager();
        Intent r13 = new Intent("com.android.settings.OEM_RADIO_INFO");
        if (r12 == null) goto L16;
        List<ResolveInfo> r14 = r12.queryIntentActivities(r13, 0);
    L18:
        if (r14.size() != 0) goto L20;
        this.oemInfoButton.setEnabled(false);
    L20:
        this.mCellInfoRefreshRateIndex = 0;
        this.mPreferredNetworkTypeResult = this.mPreferredNetworkLabels.length - 1;
        this.phone.getPreferredNetworkType(this.mHandler.obtainMessage(1000));
        restoreFromBundle(r7);
        return;
    L16:
        r14 = new ArrayList();
        goto L18
    L9:
        this.phone = PhoneFactory.getPhone(r2);
    L5:
        this.mSlotID = 0;
        goto L6
    }

    public void com_android_settings_RadioInfo__onResume$___twin___() {
        super.onResume();
        log("Started onResume");
        updateMessageWaiting();
        updateCallRedirect();
        updateDataState();
        updateDataStats2();
        updateRadioPowerState();
        updateImsVoLteProvisionedState();
        updateProperties();
        updateDnsCheckState();
        updateNetworkType();
        updateNeighboringCids(this.mNeighboringCellResult);
        updateLocation(this.mCellLocationResult);
        updateCellInfo(this.mCellInfoResult);
        this.mPingHostnameV4.setText(this.mPingHostnameResultV4);
        this.mPingHostnameV6.setText(this.mPingHostnameResultV6);
        this.mHttpClientTest.setText(this.mHttpClientTestResult);
        this.cellInfoRefreshRateSpinner.setOnItemSelectedListener(this.mCellInfoRefreshRateHandler);
        this.cellInfoRefreshRateSpinner.setSelection(this.mCellInfoRefreshRateIndex);
        this.preferredNetworkType.setSelection(this.mPreferredNetworkTypeResult, true);
        this.preferredNetworkType.setOnItemSelectedListener(this.mPreferredNetworkHandler);
        this.radioPowerOnSwitch.setOnCheckedChangeListener(this.mRadioPowerOnChangeListener);
        this.imsVoLteProvisionedSwitch.setOnCheckedChangeListener(this.mImsVoLteCheckedChangeListener);
        this.mSubID = MultiSimAdapter.slot2Sub(this.mSlotID);
        if (this.mSdkBeforeQ == false) goto L5;
        MsimPhoneStateListener r0 = new MsimPhoneStateListener(this, this.mSubID);
        this.mPhoneStateListener = r0;
        this.mTelephonyManager.listen(r0, 9725);
    L6:
        this.smsc.clearFocus();
        return;
    L5:
        this.mPhoneStateListener = new MsimPhoneStateListener(this);
        this.mTelephonyManager.createForSubscriptionId(this.mSubID).listen(this.mPhoneStateListener, 9725);
        goto L6
    }

    public void com_android_settings_RadioInfo__onPause$___twin___() {
        super.onPause();
        log("onPause: unregister phone & data intents");
        MsimPhoneStateListener r0 = this.mPhoneStateListener;
        if (r0 != null) goto L5;
    L8:
        MultiSDKAdapter.setCellInfoListRate(this.phone, this.mTelephonyManager, Integer.MAX_VALUE);
        return;
    L5:
        if (this.mSdkBeforeQ == false) goto L7;
        this.mTelephonyManager.listen(r0, 0);
        goto L8
    L7:
        this.mTelephonyManager.createForSubscriptionId(this.mSubID).listen(this.mPhoneStateListener, 0);
        goto L8
    }

    private void restoreFromBundle(Bundle r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.mPingHostnameResultV4 = r3.getString("mPingHostnameResultV4", "");
        this.mPingHostnameResultV6 = r3.getString("mPingHostnameResultV6", "");
        this.mHttpClientTestResult = r3.getString("mHttpClientTestResult", "");
        this.mPingHostnameV4.setText(this.mPingHostnameResultV4);
        this.mPingHostnameV6.setText(this.mPingHostnameResultV6);
        this.mHttpClientTest.setText(this.mHttpClientTestResult);
        this.mPreferredNetworkTypeResult = r3.getInt("mPreferredNetworkTypeResult", this.mPreferredNetworkLabels.length - 1);
        this.mCellInfoRefreshRateIndex = r3.getInt("mCellInfoRefreshRateIndex", 0);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle r3) {
        r3.putString("mPingHostnameResultV4", this.mPingHostnameResultV4);
        r3.putString("mPingHostnameResultV6", this.mPingHostnameResultV6);
        r3.putString("mHttpClientTestResult", this.mHttpClientTestResult);
        r3.putInt("mPreferredNetworkTypeResult", this.mPreferredNetworkTypeResult);
        r3.putInt("mCellInfoRefreshRateIndex", this.mCellInfoRefreshRateIndex);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu r5) {
        r5.add(0, 0, 0, R.string.radio_info_band_mode_label).setOnMenuItemClickListener(this.mSelectBandCallback).setAlphabeticShortcut('b');
        r5.add(1, 1, 0, R.string.radioInfo_menu_viewADN).setOnMenuItemClickListener(this.mViewADNCallback);
        r5.add(1, 2, 0, R.string.radioInfo_menu_viewFDN).setOnMenuItemClickListener(this.mViewFDNCallback);
        r5.add(1, 3, 0, R.string.radioInfo_menu_viewSDN).setOnMenuItemClickListener(this.mViewSDNCallback);
        r5.add(1, 4, 0, R.string.radioInfo_menu_getPDP).setOnMenuItemClickListener(this.mGetPdpList);
        r5.add(1, 5, 0, R.string.radio_info_data_connection_disable).setOnMenuItemClickListener(this.mToggleData);
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu r3) {
        MenuItem r4 = r3.findItem(5);
        int r2 = this.mTelephonyManager.getDataState();
        if (r2 != 0) goto L5;
        r4.setTitle(R.string.radio_info_data_connection_enable);
    L11:
        boolean r5 = true;
    L12:
        r4.setVisible(r5);
        return true;
    L5:
        if (r2 != 2) goto L7;
    L9:
        r4.setTitle(R.string.radio_info_data_connection_disable);
        goto L11
    L7:
        if (r2 == 3) goto L9;
        r5 = false;
        goto L12
    }

    private void updateDnsCheckState() {
        TextView r0 = this.dnsCheckState;
        if (this.phone.isDnsCheckDisabled() == false) goto L5;
        String r1 = "0.0.0.0 allowed";
    L6:
        r0.setText(r1);
        return;
    L5:
        r1 = "0.0.0.0 not allowed";
        goto L6
    }

    private final void updateSignalStrength(SignalStrength r5) {
        Resources r0 = getResources();
        int r1 = r5.getDbm();
        int r6 = r5.getAsuLevel();
        if ((-1) != r6) goto L5;
        r6 = 0;
    L5:
        this.dBm.setText(String.valueOf(r1) + HanziToPinyin.Token.SEPARATOR + r0.getString(R.string.radioInfo_display_dbm) + "   " + String.valueOf(r6) + HanziToPinyin.Token.SEPARATOR + r0.getString(R.string.radioInfo_display_asu));
    }

    private final void updateLocation(CellLocation r9) {
        Resources r0 = getResources();
        boolean r1 = r9 instanceof GsmCellLocation;
        String r3 = EnvironmentCompat.MEDIA_UNKNOWN;
        if (r1 == false) goto L14;
        GsmCellLocation r10 = (GsmCellLocation) r9;
        int r2 = r10.getLac();
        int r11 = r10.getCid();
        TextView r8 = this.mLocation;
        StringBuilder r4 = new StringBuilder().append(r0.getString(R.string.radioInfo_lac)).append(" = ");
        if (r2 != (-1)) goto L7;
        String r5 = EnvironmentCompat.MEDIA_UNKNOWN;
    L8:
        StringBuilder r6 = r4.append(r5).append("   ").append(r0.getString(R.string.radioInfo_cid)).append(" = ");
        if (r11 == (-1)) goto L12;
        r3 = Integer.toHexString(r11);
    L12:
        r8.setText(r6.append(r3).toString());
        return;
    L7:
        r5 = Integer.toHexString(r2);
        goto L8
    L14:
        if ((r9 instanceof CdmaCellLocation) == false) goto L36;
        CdmaCellLocation r12 = (CdmaCellLocation) r9;
        int r7 = r12.getBaseStationId();
        int r13 = r12.getSystemId();
        int r14 = r12.getNetworkId();
        int r15 = r12.getBaseStationLatitude();
        int r16 = r12.getBaseStationLongitude();
        TextView r17 = this.mLocation;
        StringBuilder r18 = new StringBuilder("BID = ");
        if (r7 != (-1)) goto L18;
        String r19 = EnvironmentCompat.MEDIA_UNKNOWN;
    L19:
        StringBuilder r20 = r18.append(r19).append("   SID = ");
        if (r13 != (-1)) goto L22;
        String r21 = EnvironmentCompat.MEDIA_UNKNOWN;
    L23:
        StringBuilder r22 = r20.append(r21).append("   NID = ");
        if (r14 != (-1)) goto L26;
        String r23 = EnvironmentCompat.MEDIA_UNKNOWN;
    L27:
        StringBuilder r24 = r22.append(r23).append("\nLAT = ");
        if (r15 != (-1)) goto L30;
        String r25 = EnvironmentCompat.MEDIA_UNKNOWN;
    L31:
        StringBuilder r26 = r24.append(r25).append("   LONG = ");
        if (r16 == (-1)) goto L35;
        r3 = Integer.toHexString(r16);
    L35:
        r17.setText(r26.append(r3).toString());
        return;
    L30:
        r25 = Integer.toHexString(r15);
        goto L31
    L26:
        r23 = Integer.toHexString(r14);
        goto L27
    L22:
        r21 = Integer.toHexString(r13);
        goto L23
    L18:
        r19 = Integer.toHexString(r7);
        goto L19
    L36:
        this.mLocation.setText(EnvironmentCompat.MEDIA_UNKNOWN);
    }

    private final void updateNeighboringCids(List<NeighboringCellInfo> r4) {
        StringBuilder r0 = new StringBuilder();
        if (r4 != null) goto L5;
        r0.append(EnvironmentCompat.MEDIA_UNKNOWN);
    L12:
        this.mNeighboringCids.setText(r0.toString());
        return;
    L5:
        if (r4.isEmpty() == false) goto L7;
        r0.append("no neighboring cells");
        goto L12
    L7:
        Iterator<NeighboringCellInfo> r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L12;
        r0.append(r5.next().toString()).append(HanziToPinyin.Token.SEPARATOR);
        goto L9
    }

    private final String getCellInfoDisplayString(int r1) {
        if (r1 != Integer.MAX_VALUE) goto L7;
        return "";
    L7:
        return Integer.toString(r1);
    }

    private final String getCellInfoDisplayString(long r3) {
        if (r3 != Long.MAX_VALUE) goto L7;
        return "";
    L7:
        return Long.toString(r3);
    }

    private final String buildCdmaInfoString(CellInfoCdma r5) {
        CellIdentityCdma r0 = r5.getCellIdentity();
        CellSignalStrengthCdma r1 = r5.getCellSignalStrength();
        Object[] r2 = new Object[9];
        if (r5.isRegistered() == false) goto L5;
        String r6 = "S  ";
    L6:
        r2[0] = r6;
        r2[1] = getCellInfoDisplayString(r0.getSystemId());
        r2[2] = getCellInfoDisplayString(r0.getNetworkId());
        r2[3] = getCellInfoDisplayString(r0.getBasestationId());
        r2[4] = getCellInfoDisplayString(r1.getCdmaDbm());
        r2[5] = getCellInfoDisplayString(r1.getCdmaEcio());
        r2[6] = getCellInfoDisplayString(r1.getEvdoDbm());
        r2[7] = getCellInfoDisplayString(r1.getEvdoEcio());
        r2[8] = getCellInfoDisplayString(r1.getEvdoSnr());
        return String.format("%-3.3s %-5.5s %-5.5s %-5.5s %-6.6s %-6.6s %-6.6s %-6.6s %-5.5s", r2);
    L5:
        r6 = "   ";
        goto L6
    }

    private final String buildGsmInfoString(CellInfoGsm r5) {
        CellIdentityGsm r0 = r5.getCellIdentity();
        CellSignalStrengthGsm r1 = r5.getCellSignalStrength();
        Object[] r2 = new Object[8];
        if (r5.isRegistered() == false) goto L5;
        String r6 = "S  ";
    L6:
        r2[0] = r6;
        r2[1] = getCellInfoDisplayString(r0.getMcc());
        r2[2] = getCellInfoDisplayString(r0.getMnc());
        r2[3] = getCellInfoDisplayString(r0.getLac());
        r2[4] = getCellInfoDisplayString(r0.getCid());
        r2[5] = getCellInfoDisplayString(r0.getArfcn());
        r2[6] = getCellInfoDisplayString(r0.getBsic());
        r2[7] = getCellInfoDisplayString(r1.getDbm());
        return String.format("%-3.3s %-3.3s %-3.3s %-5.5s %-5.5s %-6.6s %-4.4s %-4.4s\n", r2);
    L5:
        r6 = "   ";
        goto L6
    }

    private final String buildLteInfoString(CellInfoLte r5) {
        CellIdentityLte r0 = r5.getCellIdentity();
        CellSignalStrengthLte r1 = r5.getCellSignalStrength();
        Object[] r2 = new Object[10];
        if (r5.isRegistered() == false) goto L5;
        String r6 = "S  ";
    L6:
        r2[0] = r6;
        r2[1] = getCellInfoDisplayString(r0.getMcc());
        r2[2] = getCellInfoDisplayString(r0.getMnc());
        r2[3] = getCellInfoDisplayString(r0.getTac());
        r2[4] = getCellInfoDisplayString(r0.getCi());
        r2[5] = getCellInfoDisplayString(r0.getPci());
        r2[6] = getCellInfoDisplayString(r0.getEarfcn());
        r2[7] = getCellInfoDisplayString(r1.getDbm());
        r2[8] = getCellInfoDisplayString(r1.getRsrq());
        r2[9] = getCellInfoDisplayString(r1.getTimingAdvance());
        return String.format("%-3.3s %-3.3s %-3.3s %-5.5s %-5.5s %-3.3s %-6.6s %-4.4s %-4.4s %-2.2s\n", r2);
    L5:
        r6 = "   ";
        goto L6
    }

    private final String buildWcdmaInfoString(CellInfoWcdma r5) {
        CellIdentityWcdma r0 = r5.getCellIdentity();
        CellSignalStrengthWcdma r1 = r5.getCellSignalStrength();
        Object[] r2 = new Object[8];
        if (r5.isRegistered() == false) goto L5;
        String r6 = "S  ";
    L6:
        r2[0] = r6;
        r2[1] = getCellInfoDisplayString(r0.getMcc());
        r2[2] = getCellInfoDisplayString(r0.getMnc());
        r2[3] = getCellInfoDisplayString(r0.getLac());
        r2[4] = getCellInfoDisplayString(r0.getCid());
        r2[5] = getCellInfoDisplayString(r0.getUarfcn());
        r2[6] = getCellInfoDisplayString(r0.getPsc());
        r2[7] = getCellInfoDisplayString(r1.getDbm());
        return String.format("%-3.3s %-3.3s %-3.3s %-5.5s %-5.5s %-6.6s %-3.3s %-4.4s\n", r2);
    L5:
        r6 = "   ";
        goto L6
    }

    private final String buildCellInfoString(List<CellInfo> r22) {
        String r1 = new String();
        StringBuilder r2 = new StringBuilder();
        StringBuilder r3 = new StringBuilder();
        StringBuilder r4 = new StringBuilder();
        StringBuilder r5 = new StringBuilder();
        if (r22 == null) goto L31;
        Iterator<CellInfo> r6 = r22.iterator();
    L6:
        if (r6.hasNext() == false) goto L20;
        CellInfo r7 = r6.next();
        if ((r7 instanceof CellInfoLte) == true) goto L9;
        if ((r7 instanceof CellInfoWcdma) == true) goto L12;
        if ((r7 instanceof CellInfoGsm) == true) goto L15;
        if ((r7 instanceof CellInfoCdma) == false) goto L6;
        r2.append(buildCdmaInfoString((CellInfoCdma) r7));
        goto L6
    L15:
        r3.append(buildGsmInfoString((CellInfoGsm) r7));
        goto L6
    L12:
        r5.append(buildWcdmaInfoString((CellInfoWcdma) r7));
        goto L6
    L9:
        r4.append(buildLteInfoString((CellInfoLte) r7));
        goto L6
    L20:
        if (r4.length() == 0) goto L23;
        r1 = (r1 + String.format("LTE\n%-3.3s %-3.3s %-3.3s %-5.5s %-5.5s %-3.3s %-6.6s %-4.4s %-4.4s %-2.2s\n", new Object[]{"SRV", "MCC", "MNC", "TAC", "CID", "PCI", "EARFCN", "RSRP", "RSRQ", "TA"})) + r4.toString();
    L23:
        if (r5.length() == 0) goto L26;
        r1 = (r1 + String.format("WCDMA\n%-3.3s %-3.3s %-3.3s %-5.5s %-5.5s %-6.6s %-3.3s %-4.4s\n", new Object[]{"SRV", "MCC", "MNC", "LAC", "CID", "UARFCN", "PSC", "RSCP"})) + r5.toString();
    L26:
        if (r3.length() == 0) goto L29;
        r1 = (r1 + String.format("GSM\n%-3.3s %-3.3s %-3.3s %-5.5s %-5.5s %-6.6s %-4.4s %-4.4s\n", new Object[]{"SRV", "MCC", "MNC", "LAC", "CID", "ARFCN", "BSIC", "RSSI"})) + r3.toString();
    L29:
        if (r2.length() == 0) goto L33;
        r1 = (r1 + String.format("CDMA/EVDO\n%-3.3s %-5.5s %-5.5s %-5.5s %-6.6s %-6.6s %-6.6s %-6.6s %-5.5s\n", new Object[]{"SRV", "SID", "NID", "BSID", "C-RSSI", "C-ECIO", "E-RSSI", "E-ECIO", "E-SNR"})) + r2.toString();
    L33:
        return r1.toString();
    L31:
        r1 = EnvironmentCompat.MEDIA_UNKNOWN;
        goto L33
    }

    private final void updateCellInfo(List<CellInfo> r2) {
        this.mCellInfo.setText(buildCellInfoString(r2));
    }

    private final void updateDcRtInfoTv(DataConnectionRealTimeInfo r1) {
        this.mDcRtInfoTv.setText(r1.toString());
    }

    private final void updateMessageWaiting() {
        this.mMwi.setText(String.valueOf(this.mMwiValue));
    }

    private final void updateCallRedirect() {
        this.mCfi.setText(String.valueOf(this.mCfiValue));
    }

    private final void updateServiceState(ServiceState r5) {
        int r0 = r5.getState();
        Resources r1 = getResources();
        String r2 = r1.getString(R.string.radioInfo_unknown);
        if (r0 != 0) goto L5;
        r2 = r1.getString(R.string.radioInfo_service_in);
    L14:
        this.gsmState.setText(r2);
        if (r5.getRoaming() == false) goto L17;
        this.roamingState.setText(R.string.radioInfo_roaming_in);
    L18:
        this.operatorName.setText(r5.getOperatorAlphaLong());
        return;
    L17:
        this.roamingState.setText(R.string.radioInfo_roaming_not);
        goto L18
    L5:
        if (r0 != 1) goto L7;
    L12:
        r2 = r1.getString(R.string.radioInfo_service_emergency);
        goto L14
    L7:
        if (r0 == 2) goto L12;
        if (r0 != 3) goto L14;
        r2 = r1.getString(R.string.radioInfo_service_off);
        goto L14
    }

    private final void updatePhoneState(int r4) {
        Resources r0 = getResources();
        String r1 = r0.getString(R.string.radioInfo_unknown);
        if (r4 != 0) goto L5;
        r1 = r0.getString(R.string.radioInfo_phone_idle);
    L12:
        this.callState.setText(r1);
        return;
    L5:
        if (r4 != 1) goto L7;
        r1 = r0.getString(R.string.radioInfo_phone_ringing);
        goto L12
    L7:
        if (r4 != 2) goto L12;
        r1 = r0.getString(R.string.radioInfo_phone_offhook);
        goto L12
    }

    private final void updateDataState() {
        int r0 = this.mTelephonyManager.getDataState();
        Resources r1 = getResources();
        String r2 = r1.getString(R.string.radioInfo_unknown);
        if (r0 != 0) goto L5;
        r2 = r1.getString(R.string.radioInfo_data_disconnected);
    L15:
        this.gprsState.setText(r2);
        return;
    L5:
        if (r0 != 1) goto L7;
        r2 = r1.getString(R.string.radioInfo_data_connecting);
        goto L15
    L7:
        if (r0 != 2) goto L9;
        r2 = r1.getString(R.string.radioInfo_data_connected);
        goto L15
    L9:
        if (r0 != 3) goto L15;
        r2 = r1.getString(R.string.radioInfo_data_suspended);
        goto L15
    }

    private final void updateNetworkType() {
        Phone r0 = this.phone;
        if (r0 == null) goto L6;
        r0.getServiceState();
        this.dataNetwork.setText(ServiceState.rilRadioTechnologyToString(this.phone.getServiceState().getRilDataRadioTechnology()));
        this.voiceNetwork.setText(ServiceState.rilRadioTechnologyToString(this.phone.getServiceState().getRilVoiceRadioTechnology()));
        return;
    }

    private final void updateProperties() {
        Resources r0 = getResources();
        String r1 = this.phone.getDeviceId();
        if (r1 != null) goto L5;
        r1 = r0.getString(R.string.radioInfo_unknown);
    L5:
        this.mDeviceId.setText(r1);
        String r2 = this.phone.getLine1Number();
        if (r2 != null) goto L8;
        r2 = r0.getString(R.string.radioInfo_unknown);
    L8:
        this.number.setText(r2);
    }

    private final void updateDataStats2() {
        Resources r0 = getResources();
        long r1 = TrafficStats.getMobileTxPackets();
        long r3 = TrafficStats.getMobileRxPackets();
        long r5 = TrafficStats.getMobileTxBytes();
        long r7 = TrafficStats.getMobileRxBytes();
        String r9 = r0.getString(R.string.radioInfo_display_packets);
        String r2 = r0.getString(R.string.radioInfo_display_bytes);
        this.sent.setText(r1 + HanziToPinyin.Token.SEPARATOR + r9 + ", " + r5 + HanziToPinyin.Token.SEPARATOR + r2);
        this.received.setText(r3 + HanziToPinyin.Token.SEPARATOR + r9 + ", " + r7 + HanziToPinyin.Token.SEPARATOR + r2);
    }

    private final void pingHostname() {
        int r5 = Runtime.getRuntime().exec("ping -c 1 www.google.com").waitFor();     // Catch: IOException -> L8 InterruptedException -> L16
        if (r5 != 0) goto L6;
        this.mPingHostnameResultV4 = "Pass";     // Catch: IOException -> L8 InterruptedException -> L16
    L20:
        int r6 = Runtime.getRuntime().exec("ping6 -c 1 www.google.com").waitFor();     // Catch: IOException -> L14 InterruptedException -> L16
    L8:
        this.mPingHostnameResultV4 = "Fail: IOException";     // Catch: InterruptedException -> L16
        goto L20
    L10:
        if (r6 != 0) goto L12;
        this.mPingHostnameResultV6 = "Pass";     // Catch: IOException -> L14 InterruptedException -> L16
    L19:
        return;
    L12:
        this.mPingHostnameResultV6 = String.format("Fail(%d)", new Object[]{Integer.valueOf(r6)});     // Catch: IOException -> L14 InterruptedException -> L16
    L14:
        this.mPingHostnameResultV6 = "Fail: IOException";     // Catch: InterruptedException -> L16
        return;
    L6:
        this.mPingHostnameResultV4 = String.format("Fail(%d)", new Object[]{Integer.valueOf(r5)});     // Catch: IOException -> L8 InterruptedException -> L16
    L16:
        this.mPingHostnameResultV6 = "Fail: InterruptedException";
        this.mPingHostnameResultV4 = "Fail: InterruptedException";
        return;
    L23:
        this.mPingHostnameResultV4 = "Fail: IOException";     // Catch: InterruptedException -> L16
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v9 */
    private void httpClientTest() {
        ?? r1 = 0;
        r1 = 0;
        HttpURLConnection r2 = (HttpURLConnection) new URL("https://www.google.com").openConnection();     // Catch: Throwable -> L13 IOException -> L22
        int r3 = r2.getResponseCode();     // Catch: Throwable -> L10 IOException -> L12
        if (r3 != 200) goto L7;
        this.mHttpClientTestResult = "Pass";     // Catch: Throwable -> L10 IOException -> L12
        r1 = r3;
    L8:
        if (r2 == null) goto L23;
        r2.disconnect();
    L23:
        return;
    L7:
        StringBuilder r4 = new StringBuilder("Fail: Code: ");     // Catch: Throwable -> L10 IOException -> L12
        this.mHttpClientTestResult = r4.append(r2.getResponseMessage()).toString();     // Catch: Throwable -> L10 IOException -> L12
        r1 = r4;
    L12:
        r1 = r2;
    L10:
        th = th;
        r1 = r2;
    L19:
        if (r1 == 0) goto L21;
        r1.disconnect();
    L21:
        throw th;
    L13:
        th = th;
    L15:
        this.mHttpClientTestResult = "Fail: IOException";     // Catch: Throwable -> L13
        if (r1 == 0) goto L23;
        r1.disconnect();
        goto L23
    }

    private void refreshSmsc() {
        this.phone.getSmscAddress(this.mHandler.obtainMessage(1005));
    }

    private final void updateAllCellInfo() {
        this.mCellInfo.setText("");
        this.mNeighboringCids.setText("");
        this.mLocation.setText("");
        new AnonymousClass3(this);
    }

    private final void updatePingState() {
        this.mPingHostnameResultV4 = getResources().getString(R.string.radioInfo_unknown);
        this.mPingHostnameResultV6 = getResources().getString(R.string.radioInfo_unknown);
        this.mHttpClientTestResult = getResources().getString(R.string.radioInfo_unknown);
        this.mPingHostnameV4.setText(this.mPingHostnameResultV4);
        this.mPingHostnameV6.setText(this.mPingHostnameResultV6);
        this.mHttpClientTest.setText(this.mHttpClientTestResult);
        final Runnable r0 = new AnonymousClass4(this);
        new AnonymousClass5(this, r0).start();
        new AnonymousClass6(this, r0).start();
    }

    private boolean isRadioOn() {
        if (this.phone.getServiceState().getState() == 3) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateRadioPowerState() {
        this.radioPowerOnSwitch.setOnCheckedChangeListener(null);
        this.radioPowerOnSwitch.setChecked(isRadioOn());
        this.radioPowerOnSwitch.setOnCheckedChangeListener(this.mRadioPowerOnChangeListener);
    }

    void setImsVoLteProvisionedState(final boolean r4) {
        Object[] r0 = new Object[1];
        if (r4 == false) goto L5;
        String r1 = "on";
    L6:
        r0[0] = r1;
        log(String.format("toggle VoLTE provisioned: %s", r0));
        if (this.phone != null) goto L9;
        return;
    L9:
        if (this.mImsManager == null) goto L13;
        ExecutorManager.execute(new AnonymousClass14(this, r4));
        return;
    L13:
        return;
    L5:
        r1 = "off";
        goto L6
    }

    private boolean isImsVoLteProvisioned() {
        Phone r0 = this.phone;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (this.mImsManager != null) goto L7;
        return false;
    L7:
        if (ImsManager.isVolteEnabledByPlatform(r0.getContext()) == true) goto L9;
        return false;
    L9:
        if (ImsManager.isVolteProvisionedOnDevice(this.phone.getContext()) == false) goto L15;
        return true;
    L15:
        return false;
    }

    private void updateImsVoLteProvisionedState() {
        log("updateImsVoLteProvisionedState isImsVoLteProvisioned()=" + isImsVoLteProvisioned());
        this.imsVoLteProvisionedSwitch.setOnCheckedChangeListener(null);
        this.imsVoLteProvisionedSwitch.setChecked(isImsVoLteProvisioned());
        this.imsVoLteProvisionedSwitch.setOnCheckedChangeListener(this.mImsVoLteCheckedChangeListener);
    }

    private int getNetworkModeIndex(int r4) {
        int r0 = 0;
    L3:
        int[] r1 = this.mPreferredNetworkList;
        if (r0 >= r1.length) goto L10;
        if (r1[r0] == r4) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        return r0;
    L10:
        return r1.length - 1;
    }

    private void log(String r2) {
        Log.d("RadioInfo", "[RadioInfo] " + r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_RadioInfo_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(RadioInfo r1) {
        com_android_settings_RadioInfo_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_RadioInfo_com_obric_hook_lancet_PrivacyHook_onCreate(RadioInfo r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        RadioInfo r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_RadioInfo__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_RadioInfo_com_obric_hook_lancet_BatchedActivityLancet_onResume(RadioInfo r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_RadioInfo_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_RadioInfo_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(RadioInfo r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_RadioInfo_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        RadioInfo r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_RadioInfo_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(RadioInfo r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_RadioInfo__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_RadioInfo_com_obric_hook_lancet_BatchedActivityLancet_onStop(RadioInfo r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_RadioInfo_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_RadioInfo_com_obric_hook_lancet_PrivacyHook_onResume(RadioInfo r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        RadioInfo r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_RadioInfo__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_RadioInfo_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(RadioInfo r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_RadioInfo_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_RadioInfo_com_obric_hook_lancet_PrivacyHook_onPause(RadioInfo r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        RadioInfo r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_RadioInfo__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_RadioInfo_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(RadioInfo r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_RadioInfo_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        RadioInfo r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }

    @Insert("onStop")
    public static void com_android_settings_RadioInfo_com_obric_hook_lancet_PrivacyHook_onStop(RadioInfo r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        RadioInfo r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_RadioInfo__onStop$___twin___();
    }
}
