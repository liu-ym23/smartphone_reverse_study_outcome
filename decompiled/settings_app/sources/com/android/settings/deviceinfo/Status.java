package com.android.settings.deviceinfo;

import android.app.SmtPCUtils;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.telephony.TelephonyManager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import bytedanceos.util.DeviceType;
import bytedanceos.util.Features;
import com.GlobalProxyLancet;
import com.android.settings.AboutStaticItem;
import com.android.settings.AdaptConstants;
import com.android.settings.MultiSimAdapter;
import com.android.settings.MultiSimSimStatus;
import com.android.settings.R;
import com.android.settings.SimStatus;
import com.android.settings.Utils;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.ttnet.org.chromium.base.TimeUtils;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class Status extends BaseActivity implements View.OnClickListener, View.OnLongClickListener {
    private static final String BUTTON_SELECT_SUB_KEY = "button_aboutphone_msim_status";
    static final String CB_AREA_INFO_RECEIVED_ACTION = "android.cellbroadcastreceiver.CB_AREA_INFO_RECEIVED";
    static final String CB_AREA_INFO_SENDER_PERMISSION = "android.permission.RECEIVE_EMERGENCY_BROADCAST";
    private static final String[] CONNECTIVITY_INTENTS = null;
    private static final int EVENT_UPDATE_CONNECTIVITY = 600;
    private static final int EVENT_UPDATE_STATS = 500;
    static final String GET_LATEST_CB_AREA_INFO_ACTION = "android.cellbroadcastreceiver.GET_LATEST_CB_AREA_INFO";
    private static String IMEStr = null;
    private static final String KEY_BATTERY_LEVEL = "battery_level";
    private static final String KEY_BATTERY_STATUS = "battery_status";
    private static final String KEY_BT_ADDRESS = "bt_address";
    private static final String KEY_DATA_STATE = "data_state";
    private static final String KEY_ICC_ID = "icc_id";
    private static final String KEY_IMEI = "imei";
    private static final String KEY_IMEI_SV = "imei_sv";
    private static final String KEY_IP_ADDRESS = "wifi_ip_address";
    private static final String KEY_LATEST_AREA_INFO = "latest_area_info";
    private static final String KEY_MEID_NUMBER = "meid_number";
    private static final String KEY_MIN_NUMBER = "min_number";
    private static final String KEY_NETWORK_TYPE = "network_type";
    private static final String KEY_OPERATOR_NAME = "operator_name";
    private static final String KEY_PHONE_NUMBER = "number";
    private static final String KEY_PRL_VERSION = "prl_version";
    private static final String KEY_ROAMING_STATE = "roaming_state";
    private static final String KEY_SERIAL_NUMBER = "serial_number";
    private static final String KEY_SERVICE_STATE = "service_state";
    private static final String KEY_SIGNAL_STRENGTH = "signal_strength";
    private static final String KEY_WIFI_MAC_ADDRESS = "wifi_mac_address";
    private static final String KEY_WIMAX_MAC_ADDRESS = "wimax_mac_address";
    private static final String[] PHONE_RELATED_ENTRIES = null;
    private BroadcastReceiver mBatteryInfoReceiver;
    private ConnectivityManager mCM;
    private IntentFilter mConnectivityIntentFilter;
    private final BroadcastReceiver mConnectivityReceiver;
    private Handler mHandler;
    private AboutStaticItem mItemBatteryLevel;
    private AboutStaticItem mItemBatteryStatus;
    private AboutStaticItem mItemBtAddress;
    private AboutStaticItem mItemCmiitId;
    private AboutStaticItem mItemFccId;
    private AboutStaticItem mItemImei;
    private AboutStaticItem mItemImeiSv;
    private AboutStaticItem mItemSerialNumber;
    private AboutStaticItem mItemSim1;
    private AboutStaticItem mItemSim2;
    private AboutStaticItem mItemUpTime;
    private AboutStaticItem mItemWifiIpAddress;
    private AboutStaticItem mItemWifiMacAddress;
    private AboutStaticItem mItemWimaxMacAddress;
    protected PinnedPopupWindow mPopupWindow;
    private Resources mRes;
    private final BroadcastReceiver mSimStateChangedReceiver;
    private View mSimStatusEntrance;
    private FrameLayout mSimStatusFragmentLayout;
    private ScrollView mStatusContainer;
    private LinearLayout mStatusLayout;

    private static class MyHandler extends Handler {
        private WeakReference<Status> mStatus;

        public MyHandler(Status r2) {
            this.mStatus = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r5) {
            Status r0 = this.mStatus.get();
            if (r0 != null) goto L5;
            return;
        L5:
            int r6 = r5.what;
            if (r6 != 500) goto L8;
            r0.updateTimes();
            sendEmptyMessageDelayed(500, 1000);
            return;
        L8:
            if (r6 != 600) goto L14;
            r0.updateConnectivity();
            return;
        }
    }

    public static class PinnedPopupWindow extends PopupWindow implements View.OnClickListener {
        private static final float BIG_FONT_SIZE = 1.1f;
        private static final int POPUP_TEXT_LAYOUT = 17367494;
        private static final int POPUP_WINDOW_BOTTOM_ARROW = 2131231132;
        private static final int POPUP_WINDOW_CONTENT_BG = 2131231133;
        private TextView copyTextView;
        private ClipboardManager mCm;
        private Context mContext;
        private CharSequence mCopyText;

        public PinnedPopupWindow(Context r2) {
            this.mContext = r2;
            this.mCm = (ClipboardManager) r2.getSystemService("clipboard");
            setInputMethodMode(2);
            setWindowLayoutType(1002);
            setWidth(-2);
            setHeight(-2);
            setBackgroundDrawable(new BitmapDrawable());
            setOutsideTouchable(true);
            initContentView();
        }

        protected void initContentView() {
            LayoutInflater r0 = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
            if (r0 != null) goto L5;
            return;
        L5:
            FrameLayout r1 = (FrameLayout) r0.inflate(R.layout.pinned_popup_win_content, null);
            TextView r2 = (TextView) r1.findViewById(R.id.text);
            this.copyTextView = r2;
            r2.setText(android.R.string.copy);
            if (Utils.getCurrentFontScale() <= BIG_FONT_SIZE) goto L9;
            int r3 = this.mContext.getResources().getDimensionPixelSize(R.dimen.pinned_popup_window_text_padding_biggest_font);
        L12:
            this.copyTextView.setPadding(r3, r3, r3, r3);
            this.copyTextView.setOnClickListener(this);
            setContentView(r1);
            return;
        L9:
            if (Utils.getCurrentFontScale() >= BIG_FONT_SIZE) goto L11;
            r3 = this.mContext.getResources().getDimensionPixelSize(R.dimen.pinned_popup_window_text_padding);
            goto L12
        L11:
            r3 = this.mContext.getResources().getDimensionPixelSize(R.dimen.pinned_popup_window_text_padding_big_font);
            goto L12
        }

        public void setCopyText(CharSequence r1) {
            this.mCopyText = r1;
        }

        protected int getPopupWidowHeight() {
            return (int) this.mContext.getResources().getDimension(R.dimen.pinned_popup_window_offset_y);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r3) {
            this.mCm.setPrimaryClip(ClipData.newPlainText("info", this.mCopyText));
            dismiss();
        }
    }

    public void com_android_settings_deviceinfo_Status__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_deviceinfo_Status__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_deviceinfo_Status_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_deviceinfo_Status_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_deviceinfo_Status_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_deviceinfo_Status_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_deviceinfo_Status_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public Status() {
        this.mSimStateChangedReceiver = new AnonymousClass1(this);
        this.mBatteryInfoReceiver = new AnonymousClass2(this);
        this.mConnectivityReceiver = new AnonymousClass3(this);
    }

    static /* synthetic */ void access$000(Status r0, boolean r1) {
        r0.setupSimItems(r1);
    }

    static /* synthetic */ FrameLayout access$100(Status r0) {
        return r0.mSimStatusFragmentLayout;
    }

    static /* synthetic */ int access$200(Status r0) {
        return r0.getSimIndexWhenHasNoMultiSim();
    }

    static /* synthetic */ AboutStaticItem access$300(Status r0) {
        return r0.mItemBatteryLevel;
    }

    static /* synthetic */ AboutStaticItem access$400(Status r0) {
        return r0.mItemBatteryStatus;
    }

    static /* synthetic */ String[] access$500() {
        return CONNECTIVITY_INTENTS;
    }

    static /* synthetic */ Handler access$600(Status r0) {
        return r0.mHandler;
    }

    static {
        PHONE_RELATED_ENTRIES = new String[]{KEY_DATA_STATE, "service_state", KEY_OPERATOR_NAME, KEY_ROAMING_STATE, "network_type", KEY_LATEST_AREA_INFO, KEY_PHONE_NUMBER, "imei", KEY_IMEI_SV, KEY_PRL_VERSION, KEY_MIN_NUMBER, KEY_MEID_NUMBER, "signal_strength", KEY_ICC_ID};
        CONNECTIVITY_INTENTS = new String[]{"android.bluetooth.adapter.action.STATE_CHANGED", "android.net.conn.CONNECTIVITY_CHANGE", AdaptConstants.LINK_CONFIGURATION_CHANGED_ACTION, "android.net.wifi.STATE_CHANGE"};
        IMEStr = "";
    }

    private void setupSimItems(boolean r5) {
        View r0 = this.mSimStatusEntrance;
        if (r5 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        if (r5 == false) goto L12;
        Bundle r6 = getContentResolver().call(DeviceInfoProvider.DEVICE_INFO_PROVIDER_AUTHORITY, DeviceInfoProvider.GET_PHONE_NUM, null, null);
        this.mItemSim1.setTitle(MSimInfoHelper.getSimName(this, 0));
        this.mItemSim2.setTitle(MSimInfoHelper.getSimName(this, 1));
        if (r6 == null) goto L13;
        this.mItemSim1.setSummary(r6.getString(String.valueOf(0)));
        this.mItemSim2.setSummary(r6.getString(String.valueOf(1)));
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r2 = 8;
        goto L6
    }

    private int getSimIndexWhenHasNoMultiSim() {
        int r0 = 0;
        if (Utils.isMultiSimSupport() == false) goto L11;
        if (TelephonyManager.getDefault().hasIccCard(0) == true) goto L14;
        r0 = 1;
        if (TelephonyManager.getDefault().hasIccCard(1) == true) goto L14;
    L13:
        r0 = -1;
    L14:
        OLog.d("Status", "sim:" + r0);
        return r0;
    L11:
        if (Utils.isSimExists() == false) goto L13;
        goto L13
    }

    private boolean hasBluetooth() {
        if (BluetoothAdapter.getDefaultAdapter() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean hasWimax() {
        if (this.mCM.getNetworkInfo(6) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void com_android_settings_deviceinfo_Status__onCreate$___twin___(Bundle r8) {
        super.onCreate(r8);
        if (this.mIsLandScreen == false) goto L5;
        setContentView(R.layout.device_lande_status_layout);
    L6:
        this.mStatusContainer = (ScrollView) findViewById(R.id.status_container);
        this.mStatusLayout = (LinearLayout) findViewById(R.id.status_layout);
        this.mItemBatteryStatus = (AboutStaticItem) findViewById(R.id.battery_status);
        this.mItemBatteryLevel = (AboutStaticItem) findViewById(R.id.battery_level);
        this.mItemImei = (AboutStaticItem) findViewById(R.id.imei);
        this.mItemImeiSv = (AboutStaticItem) findViewById(R.id.imei_sv);
        this.mItemFccId = (AboutStaticItem) findViewById(R.id.fcc_id);
        this.mItemCmiitId = (AboutStaticItem) findViewById(R.id.cmiit_id);
        this.mItemWifiIpAddress = (AboutStaticItem) findViewById(R.id.wifi_ip_address);
        this.mItemWifiMacAddress = (AboutStaticItem) findViewById(R.id.wifi_mac_address);
        this.mItemBtAddress = (AboutStaticItem) findViewById(R.id.bt_address);
        this.mItemSerialNumber = (AboutStaticItem) findViewById(R.id.serial_number);
        this.mItemUpTime = (AboutStaticItem) findViewById(R.id.up_time);
        this.mItemWimaxMacAddress = (AboutStaticItem) findViewById(R.id.wimax_mac_address);
        this.mSimStatusEntrance = findViewById(R.id.sim_status_entrance_layout);
        AboutStaticItem r9 = (AboutStaticItem) findViewById(R.id.sim_1);
        this.mItemSim1 = r9;
        r9.setOnClickListener(this);
        AboutStaticItem r10 = (AboutStaticItem) findViewById(R.id.sim_2);
        this.mItemSim2 = r10;
        r10.setOnClickListener(this);
        this.mSimStatusFragmentLayout = (FrameLayout) findViewById(R.id.sim_status_fragment_container);
        FragmentTransaction r0 = getSupportFragmentManager().beginTransaction();
        if (Utils.hasMultiSimInDevice() == true) goto L9;
        r0.replace(R.id.sim_status_fragment_container, new SimStatus(getSimIndexWhenHasNoMultiSim()));
        r0.commitAllowingStateLoss();
    L10:
        this.mHandler = new MyHandler(this);
        this.mCM = (ConnectivityManager) getSystemService("connectivity");
        setupCommercialIds();
        this.mRes = getResources();
        Bundle r1 = null;
        if (UserHandle.myUserId() != 0) goto L14;
        OLog.d(this.TAG, "defaultSlot " + MultiSimAdapter.getDefaultSlot());
        r1 = getContentResolver().call(DeviceInfoProvider.DEVICE_INFO_PROVIDER_AUTHORITY, DeviceInfoProvider.GET_PHONE_INFO, null, null);
    L14:
        if (r1 != null) goto L16;
    L31:
        String[] r2 = PHONE_RELATED_ENTRIES;
        int r3 = r2.length;
        int r4 = 0;
    L32:
        if (r4 >= r3) goto L35;
        String r5 = r2[r4];
        r4 = r4 + 1;
    L35:
        if (hasBluetooth() == true) goto L38;
        this.mItemBtAddress.setVisibility(8);
    L38:
        if (hasWimax() == true) goto L40;
        this.mItemWimaxMacAddress.setVisibility(8);
    L40:
        this.mConnectivityIntentFilter = new IntentFilter();
        String[] r6 = CONNECTIVITY_INTENTS;
        int r7 = r6.length;
        int r11 = 0;
    L41:
        if (r11 >= r7) goto L43;
        this.mConnectivityIntentFilter.addAction(r6[r11]);
        r11 = r11 + 1;
        goto L41
    L43:
        updateConnectivity();
        String r12 = Build.getSerial();
        if (r12 != null) goto L46;
    L48:
        this.mItemSerialNumber.setVisibility(8);
    L49:
        setupBackBtnOnTitle();
        allowLongClickCopy();
        if (SmtPCUtils.isPcMode(this) == false) goto L55;
        this.mStatusContainer.setVerticalScrollBarEnabled(false);
        return;
    L55:
        return;
    L46:
        if (r12.equals("") == true) goto L48;
        this.mItemSerialNumber.setSummary(r12);
        goto L49
    L16:
        if (Utils.isWifiOnly(getApplicationContext()) == true) goto L31;
        boolean r13 = Utils.isMultiSimSupport();
        TelephonyManager r14 = TelephonyManager.getDefault();
        String r15 = r14.getImei(0) + "\n" + r14.getImei(1);
        if ("CDMA".equals(r1.getString(DeviceInfoProvider.PHONE_NAME)) == false) goto L27;
        this.mItemImeiSv.setVisibility(8);
        if (r1.getInt(DeviceInfoProvider.LTE_ON_CDMA_MODE, -1) != 1) goto L26;
        if (r13 == true) goto L25;
        r15 = r1.getString("imei");
    L25:
        IMEStr = r15;
        this.mItemImei.setSummary(r15);
        goto L35
    L26:
        this.mItemImei.setVisibility(8);
        goto L35
    L27:
        if (r13 == true) goto L30;
        r15 = r1.getString("device_id");
    L30:
        IMEStr = r15;
        this.mItemImei.setSummary(r15);
        this.mItemImeiSv.setSummary(((TelephonyManager) getSystemService(MultiSimAdapter.PHONE_KEY)).getDeviceSoftwareVersion());
        goto L35
    L9:
        this.mSimStatusFragmentLayout.setVisibility(8);
        goto L10
    L5:
        setContentView(R.layout.device_status_layout);
        goto L6
    }

    private void allowLongClickCopy() {
        this.mItemBatteryStatus.setOnLongClickListener(this);
        this.mItemBatteryLevel.setOnLongClickListener(this);
        this.mItemImei.setOnLongClickListener(this);
        this.mItemImeiSv.setOnLongClickListener(this);
        this.mItemFccId.setOnLongClickListener(this);
        this.mItemCmiitId.setOnLongClickListener(this);
        this.mItemWifiIpAddress.setOnLongClickListener(this);
        this.mItemWifiMacAddress.setOnLongClickListener(this);
        this.mItemBtAddress.setOnLongClickListener(this);
        this.mItemSerialNumber.setOnLongClickListener(this);
        this.mItemUpTime.setOnLongClickListener(this);
        this.mItemWimaxMacAddress.setOnLongClickListener(this);
        this.mItemSim1.setOnLongClickListener(this);
        this.mItemSim2.setOnLongClickListener(this);
    }

    private void setupCommercialIds() {
        if (DeviceType.is(DeviceType.T2) == true) goto L5;
        return;
    L5:
        if (Features.isFeatureUSEnabled(this).booleanValue() == false) goto L7;
        this.mItemFccId.setVisibility(0);
        this.mItemFccId.setSummary(getString(R.string.t2_us_fcc_id));
        return;
    L7:
        this.mItemCmiitId.setVisibility(0);
        this.mItemCmiitId.setSummary(getString(R.string.t2_cmiit_id));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mItemSim1) goto L6;
        displaySimStatus(0);
        return;
    L6:
        if (r2 != this.mItemSim2) goto L10;
        displaySimStatus(1);
        return;
    }

    private void displaySimStatus(int r4) {
        Intent r0 = new Intent(this, MultiSimSimStatus.class);
        r0.putExtra("title", MSimInfoHelper.getSimName(this, r4));
        r0.putExtra("back_text_id", R.string.about_item_title_device_status);
        r0.putExtra("subscription", r4);
        startActivity(r0);
    }

    public void com_android_settings_deviceinfo_Status__onResume$___twin___() {
        super.onResume();
        setupSimItems(Utils.hasMultiSimInDevice());
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mConnectivityReceiver, this.mConnectivityIntentFilter, "android.permission.CHANGE_NETWORK_STATE", null);
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mBatteryInfoReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mSimStateChangedReceiver, new IntentFilter("android.intent.action.SIM_STATE_CHANGED"));
        this.mHandler.sendEmptyMessage(500);
    }

    public void com_android_settings_deviceinfo_Status__onPause$___twin___() {
        super.onPause();
        unregisterReceiver(this.mBatteryInfoReceiver);
        unregisterReceiver(this.mSimStateChangedReceiver);
        unregisterReceiver(this.mConnectivityReceiver);
        this.mHandler.removeMessages(500);
    }

    private void setWimaxStatus() {
        if (((ConnectivityManager) getSystemService("connectivity")).getNetworkInfo(6) != null) goto L5;
        this.mItemWimaxMacAddress.setVisibility(8);
        return;
    L5:
        String r0 = SystemProperties.get("net.wimax.mac.address", getString(R.string.status_unavailable));
        this.mItemWimaxMacAddress.setSummary(r0);
    }

    private void setWifiStatus() {
        String[] r0 = ((WifiManager) getSystemService("wifi")).getFactoryMacAddresses();
        if (r0 != null) goto L5;
    L7:
        String r1 = null;
    L8:
        AboutStaticItem r2 = this.mItemWifiMacAddress;
        if (TextUtils.isEmpty(r1) == false) goto L12;
        r1 = getString(R.string.device_info_not_available_mac);
    L12:
        r2.setSummary(r1);
        return;
    L5:
        if (r0.length <= 0) goto L7;
        r1 = r0[0];
        goto L8
    }

    private void setIpAddressStatus() {
        String r0 = Utils.getDefaultIpAddresses(this.mCM);
        if (r0 == null) goto L6;
        this.mItemWifiIpAddress.setSummary(r0);
        return;
    }

    private String getBtAddress() {
        return SystemProperties.get("gsm.scril.bt", getString(R.string.device_info_not_available_bt));
    }

    private void setBtStatus() {
        BluetoothAdapter r0 = BluetoothAdapter.getDefaultAdapter();
        if (r0 != null) goto L6;
        this.mItemBtAddress.setVisibility(8);
        return;
    L6:
        if (DeviceType.is(DeviceType.A1) == false) goto L13;
        AboutStaticItem r1 = this.mItemBtAddress;
        if (r0.isEnabled() == false) goto L10;
        String r4 = getBtAddress();
    L11:
        r1.setSummary(r4);
        return;
    L10:
        r4 = getString(R.string.device_info_not_available_bt);
        goto L11
    L13:
        if (r0.isEnabled() == false) goto L15;
        String r2 = r0.getAddress();
    L16:
        AboutStaticItem r3 = this.mItemBtAddress;
        if (TextUtils.isEmpty(r2) == false) goto L20;
        r2 = getString(R.string.device_info_not_available_bt);
    L20:
        r3.setSummary(r2);
        return;
    L15:
        r2 = null;
        goto L16
    }

    void updateConnectivity() {
        setWimaxStatus();
        setWifiStatus();
        setBtStatus();
        setIpAddressStatus();
    }

    void updateTimes() {
        long r0 = SystemClock.uptimeMillis() / 1000;
        long r1 = SystemClock.elapsedRealtime() / 1000;
        if (r1 != 0) goto L5;
        r1 = 1;
    L5:
        this.mItemUpTime.setSummary(convert(r1));
    }

    private String pad(int r2) {
        if (r2 < 10) goto L7;
        return String.valueOf(r2);
    L7:
        return "0" + String.valueOf(r2);
    }

    private String convert(long r6) {
        int r2 = (int) (r6 % 60);
        int r0 = (int) ((r6 / 60) % 60);
        return ((int) (r6 / TimeUtils.SECONDS_PER_HOUR)) + ":" + pad(r0) + ":" + pad(r2);
    }

    private boolean isMultiSimEnabled() {
        if (TelephonyManager.getDefault().getPhoneCount() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View r11) {
        if ((r11 instanceof AboutStaticItem) == false) goto L8;
        final AboutStaticItem r0 = (AboutStaticItem) r11;
        final CharSequence r2 = r0.getSummary().getText();
        if (this.mPopupWindow != null) goto L7;
        this.mPopupWindow = new PinnedPopupWindow(this);
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
        this.mPopupWindow.setOnDismissListener(new AnonymousClass4(this, r0, r2));
    L8:
        return true;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_deviceinfo_Status_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Status r1) {
        com_android_settings_deviceinfo_Status_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_deviceinfo_Status_com_obric_hook_lancet_PrivacyHook_onCreate(Status r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        Status r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_deviceinfo_Status__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_Status_com_obric_hook_lancet_BatchedActivityLancet_onResume(Status r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_deviceinfo_Status_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_Status_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(Status r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_deviceinfo_Status_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        Status r5 = r4;
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
    public static void com_android_settings_deviceinfo_Status_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(Status r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_deviceinfo_Status__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_deviceinfo_Status_com_obric_hook_lancet_BatchedActivityLancet_onStop(Status r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_deviceinfo_Status_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_deviceinfo_Status_com_obric_hook_lancet_PrivacyHook_onResume(Status r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        Status r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_deviceinfo_Status__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_deviceinfo_Status_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(Status r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_deviceinfo_Status_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_deviceinfo_Status_com_obric_hook_lancet_PrivacyHook_onPause(Status r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        Status r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_deviceinfo_Status__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_deviceinfo_Status_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(Status r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_deviceinfo_Status_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        Status r5 = r3;
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
    public static void com_android_settings_deviceinfo_Status_com_obric_hook_lancet_PrivacyHook_onStop(Status r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        Status r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_deviceinfo_Status__onStop$___twin___();
    }
}
