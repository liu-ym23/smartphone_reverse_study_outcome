package com.android.settings.wifi;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.SoftApConfiguration;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentKt;
import com.android.settings.AdaptWifi;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.R;
import com.android.settings.WifiApSettingFragment;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.base.BaseFragment;
import com.android.settings.bluetooth.Utf8ByteLengthFilter;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.selection.OSelectionPanelView;
import com.obric.oui.selection.OSingleSelectionPanelView;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.titlebar.OCTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class WifiApSetupFragment extends BaseFragment implements View.OnClickListener, TextWatcher {
    public static final int OPEN_INDEX = 0;
    private static final int SOFTAP_SSID_NAME_MAX_LENGTH_BYTES = 32;
    private static final String TAG = "WifiApSetupActivity";
    public static final int WPA2_INDEX = 1;
    public static final int WPA2_WPA3_INDEX = 2;
    public static final int WPA3_INDEX = 3;
    public static final int WPA_INDEX = 1;
    private static String[] formats;
    private static String[] mBandFormats;
    private static String[] mBandFormatsSub;
    private OCardListItem mBand;
    private OInsetSheet mBandDialog;
    private int mBandIndex;
    private OPopover mBandPopover;
    private int mOriBandIndex;
    private int mOriSecurityTypeIndex;
    private OInputLayout mPassword;
    private final BroadcastReceiver mReceiver;
    private View mRightBtn;
    private OCardListItem mSecurity;
    private OInsetSheet mSecurityChooser;
    private OPopover mSecurityPopover;
    private int mSecurityTypeIndex;
    private SoftApConfiguration mSoftApConfig;
    private OInputLayout mSsid;
    private OCardListItem mUseWifi7;
    private WifiConfiguration mWifiConfig;
    private WifiManager mWifiManager;
    private OSwitch useWifi7Switch;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public void com_android_settings_wifi_WifiApSetupFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_wifi_WifiApSetupFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_wifi_WifiApSetupFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_wifi_WifiApSetupFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public WifiApSetupFragment() {
        this.mSecurityTypeIndex = 0;
        this.mBandIndex = 0;
        this.mSecurityPopover = null;
        this.mBandPopover = null;
        this.mReceiver = new AnonymousClass4(this);
    }

    static /* synthetic */ int access$000(WifiApSetupFragment r0) {
        return r0.mSecurityTypeIndex;
    }

    static /* synthetic */ void access$100(WifiApSetupFragment r0, int r1) {
        r0.changeSecurityTypeIndex(r1);
    }

    static /* synthetic */ SoftApConfiguration access$200(WifiApSetupFragment r0) {
        return r0.getConfig();
    }

    static /* synthetic */ WifiManager access$300(WifiApSetupFragment r0) {
        return r0.mWifiManager;
    }

    static /* synthetic */ void access$401(WifiApSetupFragment r0) {
        super.finish();
    }

    private int getSecurityTypeIndex(SoftApConfiguration r6) {
        if (r6.getSecurityType() != 1) goto L5;
        boolean r5 = true;
    L7:
        if (r6.getSecurityType() != 3) goto L9;
        boolean r2 = true;
    L11:
        if (r6.getSecurityType() != 2) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L16;
        return 2;
    L16:
        if (r2 == false) goto L18;
        return 3;
    L18:
        if (r5 == false) goto L20;
        return 1;
    L20:
        return 0;
    L13:
        r7 = false;
        goto L14
    L9:
        r2 = false;
        goto L11
    L5:
        r5 = false;
        goto L7
    }

    private SoftApConfiguration getConfig() {
        SoftApConfiguration.Builder r0 = new SoftApConfiguration.Builder();
        r0.setSsid(this.mSsid.getVInput().getText().toString());
        if (this.mBandIndex != 0) goto L5;
        r0.setBand(1);
    L6:
        int r1 = this.mSecurityTypeIndex;
        if (r1 == 0) goto L19;
        if (r1 == 1) goto L17;
        if (r1 != 2) goto L11;
        r0.setPassphrase(this.mPassword.getVInput().getText().toString(), 2);
        r0.setIeee80211beEnabled(this.useWifi7Switch.isChecked());
        return r0.build();
    L11:
        if (r1 == 3) goto L13;
        return null;
    L13:
        r0.setPassphrase(this.mPassword.getVInput().getText().toString(), 3);
        r0.setIeee80211beEnabled(this.useWifi7Switch.isChecked());
        return r0.build();
    L17:
        r0.setPassphrase(this.mPassword.getVInput().getText().toString(), 1);
        return r0.build();
    L19:
        r0.setPassphrase(null, 0);
        return r0.build();
    L5:
        r0.setBand(2);
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Utils.resetChangeSoftApConfig();
        this.mRootView = r4.inflate(R.layout.wifi_ap_setup, r5, false);
        this.mWifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        formats = getResources().getStringArray(R.array.wifi_ap_security_r);
        mBandFormats = getResources().getStringArray(R.array.wifi_ap_band_config_full_2);
        mBandFormatsSub = getResources().getStringArray(R.array.wifi_ap_band_config_full_2_1);
        OCardListItem r7 = (OCardListItem) findViewByIdNullable(R.id.security);
        this.mSecurity = r7;
        r7.setOnContentClickListener(new WifiApSetupFragment$$ExternalSyntheticLambda2(this));
        this.mSecurity.setDefaultCustomEndView(3);
        this.mSecurity.showCustomEnd(true);
        OCardListItem r8 = (OCardListItem) findViewByIdNullable(R.id.use_owe);
        this.mUseWifi7 = r8;
        r8.setDefaultCustomEndView(1);
        this.mUseWifi7.showCustomEnd(true);
        this.useWifi7Switch = (OSwitch) this.mUseWifi7.getCustomEndView();
        OCardListItem r9 = (OCardListItem) findViewByIdNullable(R.id.choose_band);
        this.mBand = r9;
        r9.setOnContentClickListener(new WifiApSetupFragment$$ExternalSyntheticLambda3(this));
        this.mBand.setDefaultCustomEndView(3);
        this.mBand.showCustomEnd(true);
        OInputLayout r10 = (OInputLayout) findViewByIdNullable(R.id.ssid);
        this.mSsid = r10;
        r10.getVInput().setFilters(new InputFilter[]{new Utf8ByteLengthFilter(32)});
        OInputLayout r11 = (OInputLayout) findViewByIdNullable(R.id.password);
        this.mPassword = r11;
        r11.showInputBackground(false);
        getArguments().getBoolean("from_search", false);
        SoftApConfiguration r12 = this.mWifiManager.getSoftApConfiguration();
        this.mSoftApConfig = r12;
        if (r12 == null) goto L12;
        this.mSsid.setText(r12.getSsid());
        this.mSsid.getVInput().requestFocus();
        int r13 = getSecurityTypeIndex(this.mSoftApConfig);
        this.mSecurityTypeIndex = r13;
        this.mOriSecurityTypeIndex = r13;
        this.mSecurity.setEndDetailText(formats[r13]);
        if (this.mSecurityTypeIndex == 0) goto L8;
        this.mPassword.setText(this.mSoftApConfig.getPassphrase());
    L8:
        if (this.mSoftApConfig.getBand() != 1) goto L10;
        this.mBandIndex = 0;
    L11:
        int r14 = this.mBandIndex;
        this.mOriBandIndex = r14;
        this.mBand.setEndDetailText(mBandFormats[r14]);
        Settings.Global.putInt(getContentResolver(), "wifi_ap_security", this.mOriSecurityTypeIndex);
        Settings.Global.putInt(getContentResolver(), "wifi_ap_band", this.mOriBandIndex);
        goto L12
    L10:
        this.mBandIndex = 1;
    L12:
        String r15 = this.mWifiManager.getCountryCode();
        if (AdaptWifi.is5GHzBandSupported(this.mWifiManager) == true) goto L15;
    L18:
        StringBuilder r16 = new StringBuilder();
        String r0 = "";
        if (AdaptWifi.is5GHzBandSupported(this.mWifiManager) == true) goto L21;
        String r17 = "Device do not support 5GHz ";
    L22:
        StringBuilder r18 = r16.append(r17);
        if (r15 != null) goto L25;
        r0 = " NO country code";
    L25:
        OLog.i(TAG, r18.append(r0).append(" forbid 5GHz").toString());
        this.mBand.setVisibility(8);
    L26:
        this.mSsid.getVInput().addTextChangedListener(this);
        this.mPassword.getVInput().addTextChangedListener(this);
        showSecurityFields();
        return this.mRootView;
    L21:
        r17 = "";
        goto L22
    L15:
        if (TextUtils.isEmpty(r15) == true) goto L18;
        this.mBand.setVisibility(0);
        goto L26
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-wifi-WifiApSetupFragment, reason: not valid java name */
    /* synthetic */ void m682xdfec7536(View r1) {
        onClick(this.mSecurity);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-settings-wifi-WifiApSetupFragment, reason: not valid java name */
    /* synthetic */ void m683x55669b77(View r1) {
        onClick(this.mBand);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        OFloatingTitleBar r5 = this.mTitleView;
        if (r5 == null) goto L5;
        r5.setEndButtonGroupStyle(2132018095);
        View r6 = r5.addEndAction(getString(R.string.wifi_save), -1, null);
        this.mRightBtn = r6;
        r6.setOnClickListener(this);
    L5:
        View r7 = this.mBackView;
        if (r7 == null) goto L9;
        r7.setOnClickListener(new AnonymousClass1(this));
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        updateViews();
        SoftApConfiguration r3 = this.mSoftApConfig;
        if (r3 == null) goto L9;
        this.useWifi7Switch.setChecked(r3.isIeee80211beEnabled());
        int r4 = this.mSecurityTypeIndex;
        if (r4 != 0) goto L7;
    L8:
        this.useWifi7Switch.setChecked(false);
        goto L9
    L7:
        if (r4 == 1) goto L8;
    L9:
        this.useWifi7Switch.setOnCheckedChangeListener(new AnonymousClass2(this));
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    public void updateViews() {
        int r0 = getWifiApSecuritySettingValue();
        this.mSecurityTypeIndex = r0;
        String[] r1 = formats;
        if (r0 < r1.length) goto L5;
        this.mSecurityTypeIndex = 0;
    L5:
        this.mSecurity.setEndDetailText(r1[this.mSecurityTypeIndex]);
        int r2 = getWifiApBandSettingValue();
        this.mBandIndex = r2;
        this.mBand.setEndDetailText(mBandFormats[r2]);
        showSoftInput(this.mSsid.getVInput());
        showSecurityFields();
        validate();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        hideSoftInput(this.mRootView);
    }

    private void validate() {
        OInputLayout r0 = this.mSsid;
        if (r0 == null) goto L7;
        if (r0.getVInput().length() != 0) goto L7;
    L12:
        this.mRightBtn.setEnabled(false);
        return;
    L7:
        if (this.mSecurityTypeIndex != 0) goto L9;
    L13:
        this.mRightBtn.setEnabled(true);
        return;
    L9:
        if (this.mPassword.getVInput().length() < 8) goto L12;
        if (this.mPassword.getVInput().length() <= 63) goto L13;
        goto L12
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r8) {
        if (com.android.settings.Utils.isFastDoubleClick() == false) goto L6;
        return;
    L6:
        if (r8 != this.mRightBtn) goto L21;
        SoftApConfiguration r9 = getConfig();
        if (r9 != null) goto L10;
        return;
    L10:
        if (this.mWifiManager.getWifiApState() != 13) goto L19;
        ContentResolver r10 = getContentResolver();
        int r1 = Settings.Global.getInt(r10, AdaptWifi.WIFI_SAVED_STATE);     // Catch: Settings.SettingNotFoundException -> L14
    L16:
        if (r1 != 1) goto L18;
        Settings.Global.putInt(r10, AdaptWifi.WIFI_SAVED_STATE, 0);
    L18:
        Utils.markChangeSoftApConfig();
        MultiSDKAdapter.setWifiApEnabled(this.mWifiManager, null, false);
        registerReceiver(this.mReceiver, new IntentFilter("android.net.wifi.WIFI_AP_STATE_CHANGED"));
        return;
    L14:
        e = move-exception;
        OLog.e(TAG, "Exception: " + e);
        r1 = 0;
        goto L16
    L19:
        this.mWifiManager.setSoftApConfiguration(r9);
        Bundle r11 = new Bundle();
        r11.putParcelable("extra_ap_config", this.mWifiManager.getWifiApConfiguration());
        r11.putInt("result_code", RESULT_OK);
        FragmentKt.setFragmentResult(this, WifiApSettingFragment.REQUEST_KEY_REQUEST_AP_CONFIG, r11);
        super.finish();
        return;
    L21:
        if (r8 != this.mSecurity) goto L42;
        ArrayList r12 = new ArrayList();
        if (this.useWifi7Switch.isChecked() == false) goto L32;
        int r0 = 2;
    L26:
        if (r0 >= formats.length) goto L40;
        String r4 = formats[r0];
        if (r0 != this.mSecurityTypeIndex) goto L30;
        boolean r5 = true;
    L31:
        r12.add(new Item(r4, r5));
        r0 = r0 + 1;
        goto L26
    L30:
        r5 = false;
    L40:
        this.mSecurityPopover = OPopoverHelper.showPopoverList(requireActivity(), this.mSecurity, r12, new WifiApSetupFragment$$ExternalSyntheticLambda0(this), true);
        return;
    L32:
        int r2 = 0;
    L34:
        if (r2 >= formats.length) goto L40;
        String r6 = formats[r2];
        if (r2 != this.mSecurityTypeIndex) goto L38;
        boolean r7 = true;
    L39:
        r12.add(new Item(r6, r7));
        r2 = r2 + 1;
        goto L34
    L38:
        r7 = false;
        goto L39
    L42:
        if (r8 != this.mBand) goto L68;
        ArrayList r13 = new ArrayList();
        int r3 = 0;
    L45:
        if (r3 >= mBandFormats.length) goto L51;
        String r14 = mBandFormats[r3];
        if (r3 != this.mBandIndex) goto L49;
        boolean r15 = true;
    L50:
        r13.add(new Item(r14, r15, mBandFormatsSub[r3]));
        r3 = r3 + 1;
        goto L45
    L49:
        r15 = false;
        goto L50
    L51:
        this.mBandPopover = OPopoverHelper.showPopoverList(requireActivity(), this.mBand, r13, new WifiApSetupFragment$$ExternalSyntheticLambda1(this), true);
        return;
    }

    /* JADX INFO: renamed from: lambda$onClick$2$com-android-settings-wifi-WifiApSetupFragment, reason: not valid java name */
    /* synthetic */ void m680lambda$onClick$2$comandroidsettingswifiWifiApSetupFragment(View r1, int r2) {
        if (this.useWifi7Switch.isChecked() == false) goto L5;
        r2 = r2 + 2;
    L5:
        changeSecurityTypeIndex(r2);
        OPopover r0 = this.mSecurityPopover;
        if (r0 == null) goto L9;
        r0.dismiss();
        return;
    }

    /* JADX INFO: renamed from: lambda$onClick$3$com-android-settings-wifi-WifiApSetupFragment, reason: not valid java name */
    /* synthetic */ void m681lambda$onClick$3$comandroidsettingswifiWifiApSetupFragment(View r2, int r3) {
        this.mBandIndex = r3;
        Settings.Global.putInt(this.mContext.getContentResolver(), "wifi_ap_band", r3);
        this.mBand.setEndDetailText(mBandFormats[r3]);
        OPopover r1 = this.mBandPopover;
        if (r1 == null) goto L6;
        r1.dismiss();
        return;
    }

    private void changeSecurityTypeIndex(int r3) {
        this.mSecurityTypeIndex = r3;
        Settings.Global.putInt(this.mContext.getContentResolver(), "wifi_ap_security", r3);
        this.mSecurity.setEndDetailText(formats[r3]);
        showSecurityFields();
        validate();
    }

    private OInsetSheet creatDialog(Context r6, String r7, List<OSelectionPanelView.SelectionItemData> r8, int r9, OSingleSelectionPanelView.OnItemSelectListener r10) {
        hideSoftInput();
        final OInsetSheet r0 = new OInsetSheet(r6);
        r0.setRootWidth(OInsetSheet.PanelWidth.NARROW_WIDTH);
        OCTitleBar r1 = new OCTitleBar(r6);
        r1.setShowLeftBack(false);
        OButton r3 = r1.createNeutralButton(r6, r1.mRightContainer);
        r3.setButtonSourceBitmap(R.drawable.o_ic_close);
        r3.setOnClickListener(new AnonymousClass3(this, r0));
        r1.setTitleText(r7);
        r0.setHeaderView(r1);
        OSingleSelectionPanelView r5 = new OSingleSelectionPanelView(r6, null, R.style.OSelectionPanel);
        r5.showDividers(true);
        r5.setItems(r8);
        r5.select(r9);
        r5.removeMinHeightConstraint();
        r5.registerItemSelectListener(r10);
        r0.setContainerView(r5);
        r0.setClearDimFlag(false);
        return r0;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r1) {
        validate();
    }

    private void showSecurityFields() {
        if (this.mSecurityTypeIndex != 0) goto L6;
        findViewByIdNullable(R.id.fields).setVisibility(8);
        return;
    L6:
        findViewByIdNullable(R.id.fields).setVisibility(0);
    }

    private int getWifiApSecuritySettingValue() {
        int r0 = this.mSecurityTypeIndex;
        return Settings.Global.getInt(getContentResolver(), "wifi_ap_security");
    L5:
        e = move-exception;
        OLog.e(TAG, "Exception :" + e);
        return r0;
    }

    private int getWifiApBandSettingValue() {
        int r0 = this.mBandIndex;
        return Settings.Global.getInt(getContentResolver(), "wifi_ap_band");
    L5:
        e = move-exception;
        OLog.e(TAG, "Exception :" + e);
        return r0;
    }

    @Override // com.android.settings.base.BaseFragment
    public void finish() {
        super.finish();
        if (this.mSecurityTypeIndex == this.mOriSecurityTypeIndex) goto L6;
        Settings.Global.putInt(getContentResolver(), "wifi_ap_security", this.mOriSecurityTypeIndex);
    L6:
        if (this.mBandIndex == this.mOriBandIndex) goto L9;
        Settings.Global.putInt(getContentResolver(), "wifi_ap_band", this.mOriBandIndex);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_WifiApSetupFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(WifiApSetupFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_WifiApSetupFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_WifiApSetupFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(WifiApSetupFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_wifi_WifiApSetupFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_WifiApSetupFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(WifiApSetupFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_WifiApSetupFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
