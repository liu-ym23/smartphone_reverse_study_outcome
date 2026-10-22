package com.android.settings;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.wifi.SoftApConfiguration;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.settings.base.BaseActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.servicemanager.IPlatform;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.wifi.SoftApControllerActivity;
import com.android.settings.wifi.WifiApEnablerEx;
import com.android.settings.wifi.WifiApSetupFragment;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class WifiApSettingFragment extends BaseFragment implements View.OnClickListener {
    public static final String REQUEST_KEY_REQUEST_AP_CONFIG = "request_key_request_ap_config";
    private Bitmap mBitmap;
    private OCardListItem mCheckBox;
    private OSwitch mCheckBoxSwitch;
    private BroadcastReceiver mDisconnectReceiver;
    private WifiConfiguration mExtraWifiConfig;
    private Handler mHandler;
    private LinearLayout mNetworkSharing;
    private ImageView mNetworkSharingQrcode;
    private WifiManager.SoftApCallback mSoftApCallback;
    private OCardListItem mViewConnectedSta;
    private OCardListItem mViewSummary;
    private WifiApEnablerEx mWifiApEnabler;
    private WifiConfiguration mWifiConfig;
    private WifiManager mWifiManager;
    private String[] mWifiRegexs;
    private boolean wifiAvailable;

    public void com_android_settings_WifiApSettingFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_WifiApSettingFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_WifiApSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_WifiApSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public WifiApSettingFragment() {
        this.mWifiConfig = null;
        this.mExtraWifiConfig = null;
        this.mHandler = new Handler();
        this.mDisconnectReceiver = new AnonymousClass1(this);
        this.mSoftApCallback = new AnonymousClass2(this);
    }

    static /* synthetic */ String access$000(WifiApSettingFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ WifiManager access$100(WifiApSettingFragment r0) {
        return r0.mWifiManager;
    }

    static /* synthetic */ OCardListItem access$200(WifiApSettingFragment r0) {
        return r0.mViewSummary;
    }

    static /* synthetic */ void access$300(WifiApSettingFragment r0, int r1) {
        r0.updateQrCode(r1);
    }

    static /* synthetic */ void access$400(WifiApSettingFragment r0, int r1) {
        r0.updateConnectedStaView(r1);
    }

    static /* synthetic */ OCardListItem access$500(WifiApSettingFragment r0) {
        return r0.mViewConnectedSta;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        boolean r0 = false;
        this.mRootView = r2.inflate(R.layout.wifi_ap_settings_layout, r3, false);
        OCardListItem r5 = (OCardListItem) findViewByIdNullable(R.id.switch_wifi_ap);
        this.mCheckBox = r5;
        r5.setDefaultCustomEndView(1);
        this.mCheckBox.showCustomEnd(true);
        this.mCheckBoxSwitch = (OSwitch) this.mCheckBox.getCustomEndView();
        OCardListItem r6 = (OCardListItem) findViewByIdNullable(R.id.item_wifi_ap_setting);
        this.mViewSummary = r6;
        r6.showSubTitle(true);
        this.mViewSummary.setOnContentClickListener(new WifiApSettingFragment$$ExternalSyntheticLambda0(this));
        this.mNetworkSharing = (LinearLayout) findViewByIdNullable(R.id.ap_network_sharing);
        this.mNetworkSharingQrcode = (ImageView) findViewByIdNullable(R.id.network_sharing_qrcode);
        OCardListItem r7 = (OCardListItem) findViewByIdNullable(R.id.item_wifi_tether_connected_stations);
        this.mViewConnectedSta = r7;
        r7.setDefaultCustomEndView(3);
        this.mViewConnectedSta.showCustomEnd(true);
        if (((IPlatform) ServiceManager.getService(IPlatform.class)).isShowConnectedApList() == false) goto L5;
        this.mViewConnectedSta.setOnContentClickListener(new WifiApSettingFragment$$ExternalSyntheticLambda1(this));
        this.mViewConnectedSta.showTailIcon(true);
    L6:
        String[] r8 = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getTetherableWifiRegexs();
        this.mWifiRegexs = r8;
        if (r8.length == 0) goto L9;
        r0 = true;
    L9:
        this.wifiAvailable = r0;
        this.mWifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        if (this.wifiAvailable == false) goto L13;
        WifiApEnablerEx r9 = new WifiApEnablerEx(requireActivity(), this.mCheckBoxSwitch);
        this.mWifiApEnabler = r9;
        r9.resume();
        initWifiTethering();
    L13:
        return this.mRootView;
    L5:
        this.mViewConnectedSta.showTailIcon(false);
        goto L6
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-WifiApSettingFragment, reason: not valid java name */
    /* synthetic */ void m214lambda$onCreateView$0$comandroidsettingsWifiApSettingFragment(View r1) {
        onClick(this.mViewSummary);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-settings-WifiApSettingFragment, reason: not valid java name */
    /* synthetic */ void m215lambda$onCreateView$1$comandroidsettingsWifiApSettingFragment(View r1) {
        onClick(this.mViewConnectedSta);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        updateQrCode(this.mWifiManager.getWifiApState());
        updateViews();
        if ((r1 instanceof ViewGroup) == false) goto L6;
        ((ViewGroup) r1).setClipChildren(false);
        return;
    }

    private void initWifiTethering() {
        WifiConfiguration r0 = this.mWifiManager.getWifiApConfiguration();
        this.mWifiConfig = r0;
        if (r0 != null) goto L5;
        String r1 = AdaptWifi.getWifiTetherConfigureSSIDDefault(this.mContext);
        this.mViewSummary.setSubTitle(r1);
    L6:
        this.mViewSummary.showSubTitle(true);
        return;
    L5:
        this.mViewSummary.setSubTitle(r0.SSID);
        goto L6
    }

    public void updateViews() {
        this.mWifiManager.registerSoftApCallback(new HandlerExecutor(this.mHandler), this.mSoftApCallback);
        WifiConfiguration r0 = this.mExtraWifiConfig;
        if (r0 == null) goto L6;
        this.mWifiConfig = r0;
        this.mExtraWifiConfig = null;
    L8:
        SoftApConfiguration r1 = this.mWifiManager.getSoftApConfiguration();
        if (r1 == null) goto L11;
        this.mViewSummary.setSubTitle(r1.getSsid());
        this.mViewSummary.showSubTitle(true);
    L11:
        updateConnectedStaView(this.mWifiManager.getWifiApState());
        return;
    L6:
        if (this.wifiAvailable == false) goto L8;
        this.mWifiConfig = this.mWifiManager.getWifiApConfiguration();
        goto L8
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        updateQrCode(this.mWifiManager.getWifiApState());
        this.mWifiManager.unregisterSoftApCallback(this.mSoftApCallback);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        WifiApEnablerEx r0 = this.mWifiApEnabler;
        if (r0 == null) goto L6;
        r0.pause();
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3 != this.mViewSummary) goto L6;
        Bundle r4 = new Bundle();
        r4.putParcelable("extra_ap_config", this.mWifiConfig);
        WifiApSetupFragment r0 = new WifiApSetupFragment();
        r0.setArguments(r4);
        start(r0);
        SettingsTracker.onItemClick(70102);
        return;
    L6:
        if (r3 != this.mViewConnectedSta) goto L10;
        Intent r5 = new Intent();
        r5.setClass(this.mContext, SoftApControllerActivity.class);
        r5.putExtra("back_text_id", R.string.mobile_network_ap);
        r5.putExtra("title", this.mContext.getString(R.string.wifi_tether_connected_stations_text));
        ((BaseActivity) getActivity()).customStartActivityForResult(r5, 0);
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public List<String> getFragmentRequestKeys() {
        new ArrayList().add(REQUEST_KEY_REQUEST_AP_CONFIG);
        return super.getFragmentRequestKeys();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onFragmentResult(String r1, int r2, Bundle r3) {
        super.onFragmentResult(r1, r2, r3);
        if (r1.equals(REQUEST_KEY_REQUEST_AP_CONFIG) == true) goto L5;
        return;
    L5:
        if (r2 != RESULT_OK) goto L11;
        SoftApConfiguration r4 = this.mWifiManager.getSoftApConfiguration();
        if (r4 == null) goto L12;
        this.mViewSummary.setSubTitle(r4.getSsid());
        this.mViewSummary.showSubTitle(true);
        return;
    L12:
        return;
    }

    private void updateConnectedStaView(int r3) {
        if (r3 != 11) goto L6;
        this.mViewConnectedSta.setVisibility(8);
        this.mViewConnectedSta.setEnabled(false);
        this.mViewConnectedSta.setEndDetailText(ResourceUtils.getString(R.string.wifi_tether_status_off));
        return;
    L6:
        if (r3 != 13) goto L10;
        this.mViewConnectedSta.setVisibility(0);
        this.mViewConnectedSta.setEnabled(true);
        this.mViewConnectedSta.setEndDetailText(ResourceUtils.getStringFormat(R.string.wifi_tether_connected_stations_count, new Object[]{0}));
        return;
    }

    private void updateQrCode(int r4) {
        if (r4 != 13) goto L19;
        WifiConfiguration r5 = this.mWifiManager.getWifiApConfiguration();
        this.mWifiConfig = r5;
        if (r5 != null) goto L9;
        SoftApConfiguration r6 = this.mWifiManager.getSoftApConfiguration();
        if (r6 == null) goto L9;
        WifiConfiguration r0 = new WifiConfiguration();
        r0.SSID = r6.getSsid();
        r0.preSharedKey = r6.getPassphrase();
        r0.allowedKeyManagement.set(4);
        this.mWifiConfig = r0;
    L9:
        String r7 = com.android.settings.wifi.Utils.createContent(this.mWifiManager, this.mWifiConfig, true);
        if (TextUtils.isEmpty(r7) == false) goto L27;
        this.mNetworkSharing.setVisibility(8);
        return;
    L27:
        Bitmap r8 = com.android.settings.wifi.Utils.createQrCode(this.mContext, r7);     // Catch: Throwable -> L15
        if (r8 == null) goto L29;
        this.mBitmap = r8;     // Catch: Throwable -> L15
        this.mNetworkSharingQrcode.setImageBitmap(r8);     // Catch: Throwable -> L15
        this.mNetworkSharing.setVisibility(0);     // Catch: Throwable -> L15
        return;
    L29:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        return;
    L19:
        if (r4 != 11) goto L32;
        Bitmap r9 = this.mBitmap;
        if (r9 != null) goto L23;
    L25:
        this.mNetworkSharing.setVisibility(8);
        return;
    L23:
        if (r9.isRecycled() == true) goto L25;
        this.mBitmap.recycle();
        this.mBitmap = null;
        goto L25
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_WifiApSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(WifiApSettingFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_WifiApSettingFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_WifiApSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(WifiApSettingFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_WifiApSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_WifiApSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(WifiApSettingFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_WifiApSettingFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
