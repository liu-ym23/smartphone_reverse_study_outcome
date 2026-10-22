package com.android.settings.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.RecyclerView;
import com.GlobalProxyLancet;
import com.android.settings.AdaptWifi;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment23;
import com.android.settings.WifiConfigurationSmtOnly;
import com.android.settings.base.BaseFragment;
import com.android.settings.base.adapter.PreferenceGroupWrapperAdapter;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class TrustedNetworkList extends SettingsPreferenceFragment23 implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private final String TAG;
    private boolean constructingAccessPoints;
    private View emptyView;
    private View forbiddenView;
    private TrustedNetworkHelper.CancelCallback mCancelCallback;
    private final AtomicBoolean mConnected;
    private Context mContext;
    private boolean mEditMode;
    private final IntentFilter mFilter;
    private TextView mFooterTextView;
    private Handler mHandler;
    private TextView mHeaderTextView;
    private boolean mIsExtDisplayConnected;
    private boolean mIsExtDisplaying;
    private boolean mIsLandScreen;
    private android.net.wifi.WifiInfo mLastInfo;
    private NetworkInfo.DetailedState mLastState;
    private final BroadcastReceiver mReceiver;
    private ImageView mRightButton;
    private WifiManager.ActionListener mSaveListener;
    private WifiConfiguration mSelectedConfig;
    private CompoundButton mSelectedSwitch;
    private TextView mTipsTextView;
    private TrustedNetworkHelper mTrustedHelper;
    private WifiManager mWifiManager;

    private class Multimap<K, V> {
        private final HashMap<K, List<V>> store;
        final /* synthetic */ TrustedNetworkList this$0;

        private Multimap(TrustedNetworkList r1) {
            this.this$0 = r1;
            this.store = new HashMap();
        }

        /* synthetic */ Multimap(TrustedNetworkList r1, AnonymousClass1 r2) {
            this(r1);
        }

        List<V> getAll(K r1) {
            List<V> r0 = this.store.get(r1);
            if (r0 == null) goto L6;
            return r0;
        L6:
            return Collections.emptyList();
        }

        void put(K r3, V r4) {
            List<V> r0 = this.store.get(r3);
            if (r0 != null) goto L5;
            r0 = new ArrayList(3);
            this.store.put(r3, r0);
        L5:
            r0.add(r4);
        }
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_wifi_TrustedNetworkList_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_wifi_TrustedNetworkList_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ TrustedNetworkHelper access$000(TrustedNetworkList r0) {
        return r0.mTrustedHelper;
    }

    static /* synthetic */ void access$100(TrustedNetworkList r0, Context r1, Intent r2) {
        r0.handleEvent(r1, r2);
    }

    static /* synthetic */ void access$200(TrustedNetworkList r0) {
        r0.updateAccessPoints();
    }

    static /* synthetic */ Handler access$300(TrustedNetworkList r0) {
        return r0.mHandler;
    }

    static /* synthetic */ void access$400(TrustedNetworkList r0, boolean r1) {
        r0.updateSelectedState(r1);
    }

    public TrustedNetworkList() {
        this.TAG = "TrustedNetworkList";
        this.mEditMode = false;
        this.mConnected = new AtomicBoolean(false);
        this.mHandler = new AnonymousClass2(this);
        this.mCancelCallback = new AnonymousClass4(this);
        this.constructingAccessPoints = false;
        IntentFilter r0 = new IntentFilter();
        this.mFilter = r0;
        r0.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        r0.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        r0.addAction("android.net.wifi.STATE_CHANGE");
        r0.addAction("android.net.wifi.RSSI_CHANGED");
        this.mReceiver = new AnonymousClass1(this);
    }

    public void com_android_settings_wifi_TrustedNetworkList__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        Context r5 = getContext();
        this.mContext = r5;
        boolean r0 = true;
        this.mIsExtDisplaying = true;
        if (Settings.Global.getInt(r5.getContentResolver(), "global_pc_mode_settings", 0) != 1) goto L5;
        boolean r6 = true;
    L6:
        this.mIsExtDisplayConnected = r6;
        if (getResources().getConfiguration().orientation == 2) goto L10;
        r0 = false;
    L10:
        this.mIsLandScreen = r0;
        this.mWifiManager = (WifiManager) getSystemService("wifi");
        this.mEditMode = false;
        this.mSaveListener = new AnonymousClass3(this);
        TrustedNetworkHelper r7 = new TrustedNetworkHelper(this);
        this.mTrustedHelper = r7;
        r7.setCancelCallback(this.mCancelCallback);
        return;
    L5:
        r6 = false;
        goto L6
    }

    private void updateSelectedState(boolean r4) {
        WifiConfiguration r0 = this.mSelectedConfig;
        if (r0 != null) goto L6;
        OLog.d("TrustedNetworkList", "mSelectedConfig is null");
        return;
    L6:
        WifiConfigurationSmtOnly.set_isTrustedAp(r0, r4);
        this.mWifiManager.save(this.mSelectedConfig, this.mSaveListener);
        this.mSelectedSwitch.setChecked(r4);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getActivity(), this.mReceiver, this.mFilter, 2);
        RecyclerView r6 = getListView();
        r6.setPadding(0, getResources().getDimensionPixelSize(R.dimen.list_item_vertical_gap), 0, 0);
        r6.setClipToPadding(false);
        r6.setClipChildren(false);
        if (this.mIsLandScreen == true) goto L5;
    L7:
        LinearLayout r7 = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.header_text_layout, null);
    L8:
        TextView r1 = (TextView) r7.findViewById(R.id.header_text);
        this.mHeaderTextView = r1;
        r1.setText(R.string.trusted_network_list_header_title);
        RecyclerView.Adapter r2 = r6.getAdapter();
        if (r2 == null) goto L11;
        PreferenceGroupWrapperAdapter r3 = new PreferenceGroupWrapperAdapter(r2);
        r3.setHeaderView(r7);
        r3.setFooterView(initFooterView());
        r6.setAdapter(r3);
    L11:
        LayoutInflater r8 = LayoutInflater.from(getActivity());
        this.emptyView = r8.inflate(R.layout.trust_network_list_empty_view, null);
        this.forbiddenView = r8.inflate(R.layout.trust_network_list_forbidden_view, null);
        Fragment r9 = getParentFragment();
        if (r9 != null) goto L14;
        return;
    L14:
        if ((r9 instanceof BaseFragment) == false) goto L18;
        ImageView r10 = (ImageView) ((BaseFragment) r9).mTitleView.addEndAction(R.drawable.o_standard_icon_hignlight_multi_select_selector, -1, null);
        this.mRightButton = r10;
        r10.setOnClickListener(this);
        return;
    L18:
        return;
    L5:
        if (this.mIsExtDisplaying == false) goto L7;
        r7 = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.header_text_land_layout, null);
        goto L8
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle r1, String r2) {
        addPreferencesFromResource(R.xml.trusted_network_list);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        this.mTrustedHelper.handleChooseOrConfirmPasswordResult(r2, r3, r4);
        if (r3 != (-1)) goto L5;
        boolean r5 = true;
    L6:
        updateSelectedState(r5);
        updateAccessPoints();
        return;
    L5:
        r5 = false;
        goto L6
    }

    private View initFooterView() {
        LayoutInflater r0 = LayoutInflater.from(getActivity());
        if (this.mIsLandScreen == true) goto L5;
    L7:
        View r1 = r0.inflate(R.layout.trust_wifi_footer, null);
    L8:
        this.mFooterTextView = (TextView) r1.findViewById(R.id.trusted_wifi_tips);
        return r1;
    L5:
        if (this.mIsExtDisplaying == false) goto L7;
        r1 = r0.inflate(R.layout.trust_wifi_land_footer, null);
        goto L8
    }

    private void addEmptyView() {
        this.mEditMode = false;
        ((ViewGroup) getListView().getParent()).removeView(this.emptyView);
        ((ViewGroup) getListView().getParent()).addView(this.emptyView, new ViewGroup.LayoutParams(-1, -1));
        this.mRightButton.setVisibility(8);
    }

    private void addForbiddenView() {
        this.mEditMode = false;
        ((ViewGroup) getListView().getParent()).removeView(this.forbiddenView);
        ((ViewGroup) getListView().getParent()).addView(this.forbiddenView, new ViewGroup.LayoutParams(-1, -1));
        this.mRightButton.setVisibility(8);
    }

    public void com_android_settings_wifi_TrustedNetworkList__onResume$___twin___() {
        super.onResume();
        if (this.mTrustedHelper.isDialogShowing() == true) goto L6;
        updateAccessPoints();
        return;
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.mTrustedHelper.resetPasswordConfirmedFlag();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        unregisterReceiver(this.mReceiver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    private void handleEvent(Context r2, Intent r3) {
        String r4 = r3.getAction();
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r4) == false) goto L5;
    L20:
        updateAccessPoints();
        return;
    L5:
        if (AccessPointDetailFragment.TRUST_AP_CHANGED_ACTION.equals(r4) == true) goto L20;
        if ("android.net.wifi.supplicant.STATE_CHANGE".equals(r4) == false) goto L18;
        SupplicantState r5 = (SupplicantState) r3.getParcelableExtra("newState");
        if (this.mConnected.get() == true) goto L15;
        if (AdaptWifi.isHandshakeState(r5) == false) goto L15;
        updateAccessPointConnectionState(android.net.wifi.WifiInfo.getDetailedStateOf(r5));
        return;
    L15:
        if (r5 != SupplicantState.DISCONNECTED) goto L23;
        updateAccessPointConnectionState(android.net.wifi.WifiInfo.getDetailedStateOf(r5));
        return;
    L23:
        return;
    L18:
        if ("android.net.wifi.STATE_CHANGE".equals(r4) == false) goto L25;
        NetworkInfo r6 = (NetworkInfo) r3.getParcelableExtra("networkInfo");
        this.mConnected.set(r6.isConnected());
        updateAccessPointConnectionState(r6.getDetailedState());
        return;
    }

    private void updateAccessPointConnectionState(NetworkInfo.DetailedState r2) {
        this.mLastInfo = this.mWifiManager.getConnectionInfo();
        if (r2 == null) goto L5;
        this.mLastState = r2;
    L5:
        updateAccessPoints();
    }

    private void updateAccessPoints() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        OLog.d("TrustedNetworkList", "updateAccessPoints");
        int r2 = 8;
        if (this.mWifiManager.getWifiState() == 3) goto L8;
        ((ViewGroup) getListView().getParent()).removeView(this.forbiddenView);
        getPreferenceScreen().removeAll();
        addEmptyView();
        getListView().setVisibility(8);
    L16:
        boolean r0 = com.android.settings.Utils.isUseStrictLockScreen(this.mContext);
        TextView r1 = this.mHeaderTextView;
        if (r0 == false) goto L19;
        int r4 = 8;
    L20:
        r1.setVisibility(r4);
        TextView r3 = this.mFooterTextView;
        if (r0 == true) goto L24;
        r2 = 0;
    L24:
        r3.setVisibility(r2);
        updateListVisibility();
        return;
    L19:
        r4 = 0;
        goto L20
    L8:
        getListView().setVisibility(0);
        List<AccessPoint> r5 = constructAccessPoints();
        getPreferenceScreen().removeAll();
        if (r5.size() != 0) goto L11;
        addEmptyView();
        getListView().setVisibility(8);
        goto L16
    L11:
        ((ViewGroup) getListView().getParent()).removeView(this.emptyView);
        ((ViewGroup) getListView().getParent()).removeView(this.forbiddenView);
        Iterator<AccessPoint> r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L15;
        getPreferenceScreen().addPreference(r6.next());
        goto L13
    L15:
        this.mRightButton.setVisibility(0);
        getListView().setVisibility(0);
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<AccessPoint> constructAccessPoints() {
        this.constructingAccessPoints = true;
        ArrayList<AccessPoint> r1 = new ArrayList();
        List<WifiConfiguration> r3 = null;
        Multimap r2 = new Multimap(this, 0 == true ? 1 : 0);
        HashSet r4 = new HashSet();
        r3 = this.mWifiManager.getConfiguredNetworks();     // Catch: RuntimeException -> L5
    L8:
        if (r3 == null) goto L29;
        int r7 = 0;
    L11:
        if (r7 >= r3.size()) goto L29;
        WifiConfiguration r8 = r3.get(r7);
        FragmentActivity r10 = getActivity();
        if (this.mIsLandScreen == true) goto L15;
    L17:
        boolean r11 = false;
    L18:
        TrustAccessPoint r9 = new TrustAccessPoint(r10, r8, r11);
        if (r9.security == 0) goto L28;
        if (r8.hiddenTrust == true) goto L28;
        if (r4.contains(Integer.valueOf(r8.networkId)) == true) goto L28;
        r9.setRemovedImageOnClickListener(this);
        r9.setEditMode(this.mEditMode);
        r9.update(this.mLastInfo, this.mLastState, -1);
        r9.setOnCheckedChangeListener(this);
        r1.add(r9);
        r2.put(r9.ssid, r9);
        r4.add(Integer.valueOf(r8.networkId));
    L28:
        r7 = r7 + 1;
        goto L11
    L15:
        if (this.mIsExtDisplaying == false) goto L17;
        r11 = true;
    L29:
        this.constructingAccessPoints = false;
        List<ScanResult> r0 = this.mWifiManager.getScanResults();
        if (r0 == null) goto L45;
        Iterator<ScanResult> r5 = r0.iterator();
    L33:
        if (r5.hasNext() == false) goto L45;
        ScanResult r6 = r5.next();
        if (r6.SSID == null) goto L33;
        if (r6.SSID.length() == 0) goto L33;
        if (r6.capabilities.contains("[IBSS]") == true) goto L33;
        List r12 = r2.getAll(r6.SSID);
        int r13 = 0;
    L43:
        if (r13 >= r12.size()) goto L33;
        ((AccessPoint) r12.get(r13)).update(r6, -1);
        r13 = r13 + 1;
    L45:
        Collections.sort(r1);
        setBackgroundForAccessPoints(r1);
        return r1;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    private void setBackgroundForAccessPoints(ArrayList<AccessPoint> r5) {
        Iterator<AccessPoint> r4 = r5.iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L16;
        AccessPoint r1 = r4.next();
        int r2 = 1;
        if (r0 != 0) goto L12;
        if (r5.size() == 1) goto L15;
        r2 = 2;
    L15:
        r1.setBackgroundId(r2);
        r0 = r0 + 1;
        goto L4
    L12:
        if (r0 != (r5.size() - 1)) goto L14;
        r2 = 4;
        goto L15
    L14:
        r2 = 3;
        goto L15
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        WifiConfiguration r0 = (WifiConfiguration) r2.getTag();
        this.mSelectedConfig = r0;
        this.mSelectedSwitch = r2;
        if (r0 != null) goto L5;
        return;
    L5:
        if (WifiConfigurationSmtOnly.get_isTrustedAp(r0) == r3) goto L20;
        if (r3 == true) goto L9;
    L15:
        WifiConfigurationSmtOnly.set_isTrustedAp(this.mSelectedConfig, r3);
        this.mWifiManager.save(this.mSelectedConfig, null);
        return;
    L9:
        if (this.mTrustedHelper.isLockScreenSecure() == false) goto L13;
        if (this.mTrustedHelper.isPasswordConfirmedSuccess() == true) goto L15;
    L13:
        if (this.constructingAccessPoints == true) goto L18;
        this.mTrustedHelper.chooseOrConfirmPasswordDialog();
        return;
    L18:
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        if (this.mRightButton != r4) goto L9;
        if (this.mEditMode == false) goto L7;
        this.mEditMode = false;
        cancelEditMode();
        return;
    L7:
        this.mEditMode = true;
        startEditMode();
        return;
    L9:
        if (r4.getId() != R.id.item_remove_view) goto L29;
        WifiConfiguration r5 = (WifiConfiguration) r4.getTag();
        this.mSelectedConfig = r5;
        if (r5 != null) goto L14;
        OLog.d("TrustedNetworkList", "remove invalid wifi config: " + this.mSelectedConfig);
        return;
    L14:
        OLog.d("TrustedNetworkList", "remove wifi config: " + this.mSelectedConfig.SSID);
        AccessPointDetailFragment.removeAutoLogin(getActivity(), this.mSelectedConfig);
        int r6 = Integer.parseInt(Settings.Global.getString(getContentResolver(), AccessPointDetailFragment.GLOBAL_WIFI_PRIORIT_NETWORK));     // Catch: NumberFormatException -> L21
        if (r6 != (-1)) goto L18;
    L23:
        this.mWifiManager.forget(this.mSelectedConfig.networkId, this.mSaveListener);
        return;
    L18:
        if (r6 != this.mSelectedConfig.networkId) goto L23;
        Settings.Global.putString(getContentResolver(), AccessPointDetailFragment.GLOBAL_WIFI_PRIORIT_NETWORK, "-1");     // Catch: NumberFormatException -> L21
    L21:
        e = move-exception;
        OLog.d("TrustedNetworkList", "NumberFormatException: " + e);
        goto L23
    }

    public boolean onBackPressed() {
        if (this.mEditMode == false) goto L6;
        this.mEditMode = false;
        cancelEditMode();
        return true;
    L6:
        return false;
    }

    private void startEditMode() {
        this.mRightButton.setImageResource(R.drawable.standard_icon_hignlight_confirm_pressed_oui);
        updateRemovedImageVisibility();
        TextView r2 = this.mTipsTextView;
        if (r2 == null) goto L6;
        r2.setVisibility(8);
        return;
    }

    private void cancelEditMode() {
        this.mRightButton.setImageResource(R.drawable.o_standard_icon_hignlight_multi_select_selector);
        updateRemovedImageVisibility();
        TextView r2 = this.mTipsTextView;
        if (r2 == null) goto L6;
        r2.setVisibility(0);
        return;
    }

    private void updateRemovedImageVisibility() {
        PreferenceScreen r0 = getPreferenceScreen();
        int r1 = 0;
    L4:
        if (r1 >= r0.getPreferenceCount()) goto L9;
        Preference r2 = r0.getPreference(r1);
        if ((r2 instanceof TrustAccessPoint) == false) goto L8;
        ((TrustAccessPoint) r2).setEditMode(this.mEditMode);
    L8:
        r1 = r1 + 1;
        goto L4
    }

    private void updateListVisibility() {
        if (this.mEditMode == false) goto L5;
        startEditMode();
        return;
    L5:
        cancelEditMode();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_TrustedNetworkList_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TrustedNetworkList r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_TrustedNetworkList__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_TrustedNetworkList_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TrustedNetworkList r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_wifi_TrustedNetworkList_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_TrustedNetworkList_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TrustedNetworkList r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_TrustedNetworkList__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
