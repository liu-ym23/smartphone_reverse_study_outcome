package com.android.settings.vpn2;

import android.app.AppOpsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.net.VpnManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.UserHandle;
import android.os.UserManager;
import android.security.LegacyVpnProfileStore;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import com.GlobalProxyLancet;
import com.android.internal.net.LegacyVpnInfo;
import com.android.internal.net.VpnConfig;
import com.android.internal.net.VpnProfile;
import com.android.internal.util.ArrayUtils;
import com.android.settings.HandInHandProcessor;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment23;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.android.settings.utils.UIUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.google.android.collect.Lists;
import com.obric.olog.OLog;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.toast.OToast;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class VpnSettings extends SettingsPreferenceFragment23 implements Handler.Callback, Preference.OnPreferenceClickListener {
    private static final int ACCESSIBILITY_MODE_RESCAN_INTERVAL_MS = 5000;
    public static final String EXTRA_APP_PACKINFO = "extra_app_packageInfo";
    public static final String EXTRA_FLAG_DELETE_PROFILE = "extra_flag_delete_profile";
    public static final String EXTRA_IS_ADD_VPN = "extra_is_add_vpn";
    private static final String EXTRA_PICK_LOCKDOWN = "android.net.vpn.PICK_LOCKDOWN";
    public static final String EXTRA_PROFILE_KEY = "extra_profile_key";
    public static final String EXTRA_VPN_ALWAYS_ON = "extra_vpn_always_on";
    public static final String EXTRA_VPN_PROFILE = "extra_vpn_profile";
    public static final String LAST_VALID_VPN_KEY = "last_vpn_key";
    private static final String LOG_TAG = "VpnSettings";
    private static final int REQ_CODE_ADD_VPN = 10;
    private static final int REQ_CODE_VPN_CONFIG = 11;
    private static final int RESCAN_INTERVAL_MS = 1000;
    private static final int RESCAN_MESSAGE = 0;
    private static final String TAG_LOCKDOWN = "lockdown";
    private static final NetworkRequest VPN_REQUEST = null;
    private AccessibilityManager mAccessibilityManager;
    private Map<AppVpnInfo, AppPreference> mAppPreferences;
    private Map<String, ConfigPreference> mConfigPreferences;
    private LegacyVpnInfo mConnectedLegacyVpn;
    private ConnectivityManager mConnectivityManager;
    private View mEmptyView;
    private boolean mIsAccessibilityEnable;
    private boolean mIsVpnAlwaysOn;
    private View.OnClickListener mManageListener;
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private OToast mNoNetworkToast;
    private BroadcastReceiver mStickyBroadcastReceiver;
    private Handler mUpdater;
    private UserManager mUserManager;
    private VpnManager mVpnManager;
    private String unspecifiedIpsecUserCert;

    @Override // com.android.settings.SettingsPreferenceFragment23
    protected int getHelpResource() {
        return R.string.help_url_vpn;
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_vpn2_VpnSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_vpn2_VpnSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public VpnSettings() {
        this.unspecifiedIpsecUserCert = "";
        this.mConfigPreferences = new ArrayMap();
        this.mAppPreferences = new ArrayMap();
        this.mAccessibilityManager = null;
        this.mIsAccessibilityEnable = false;
        this.mNoNetworkToast = null;
        this.mStickyBroadcastReceiver = new AnonymousClass1(this);
        this.mManageListener = new AnonymousClass6(this);
        this.mNetworkCallback = new AnonymousClass7(this);
    }

    static /* synthetic */ void access$000(VpnSettings r0) {
        r0.unregisterStickyReceiver();
    }

    static /* synthetic */ ConfigPreference access$100(VpnSettings r0, VpnProfile r1) {
        return r0.findOrCreatePreference(r1);
    }

    static /* synthetic */ void access$1000(VpnSettings r0, boolean r1, String r2) {
        r0.updateLockdownVpn(r1, r2);
    }

    static /* synthetic */ void access$1100(VpnSettings r0, VpnProfile r1) throws Exception {
        r0.connect(r1);
    }

    static /* synthetic */ boolean access$1200(VpnSettings r0) {
        return r0.interruptByEnforcedAdmin();
    }

    static /* synthetic */ void access$1300(VpnSettings r0, VpnProfile r1) {
        r0.configVpn(r1);
    }

    static /* synthetic */ void access$1400(VpnSettings r0, AppPreference r1) {
        r0.configAppPrefVpn(r1);
    }

    static /* synthetic */ Handler access$1500(VpnSettings r0) {
        return r0.mUpdater;
    }

    static /* synthetic */ boolean access$200(VpnSettings r0, LegacyVpnInfo r1) {
        return r0.runConnect(r1);
    }

    static /* synthetic */ AppPreference access$300(VpnSettings r0, AppVpnInfo r1) {
        return r0.findOrCreatePreference(r1);
    }

    static /* synthetic */ Map access$400(VpnSettings r0) {
        return r0.mConfigPreferences;
    }

    static /* synthetic */ Map access$500(VpnSettings r0) {
        return r0.mAppPreferences;
    }

    static /* synthetic */ void access$600(VpnSettings r0, ArrayList r1) {
        r0.setVpnPreferenceBackground(r1);
    }

    static /* synthetic */ void access$700(VpnSettings r0, boolean r1) {
        r0.updateEmptyViewVisibility(r1);
    }

    static /* synthetic */ void access$800(VpnSettings r0, String r1) {
        r0.disconnect(r1);
    }

    static /* synthetic */ boolean access$900(VpnSettings r0) {
        return r0.mIsVpnAlwaysOn;
    }

    static {
        VPN_REQUEST = new NetworkRequest.Builder().removeCapability(15).removeCapability(13).removeCapability(14).build();
    }

    public void com_android_settings_vpn2_VpnSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        this.mUserManager = (UserManager) getSystemService(PickApplicationActivity.EXTRA_USER);
        this.mConnectivityManager = (ConnectivityManager) getSystemService("connectivity");
        this.mAccessibilityManager = (AccessibilityManager) getSystemService("accessibility");
        this.mVpnManager = (VpnManager) getSystemService("vpn_management");
        setHasOptionsMenu(false);
        addPreferencesFromResource(R.xml.vpn_settings2);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        RecyclerView r6 = getListView();
        r6.setItemAnimator(null);
        r6.setOverScrollMode(0);
        r6.setClipChildren(false);
        r6.setClipToPadding(false);
        UIUtils.updatePadding(r6, -1, getResources().getDimensionPixelSize(R.dimen.vpn_first_item_card_gap), -1, -1);
        View r0 = LayoutInflater.from(getActivity()).inflate(R.layout.vpn_empty_layout, null, false);
        ((OPageStatus) r0.findViewById(R.id.empty_page)).setTitle(getString(R.string.vpn_list_empty_tips));
        this.mEmptyView = r0;
        r0.setVisibility(8);
        ((ViewGroup) r6.getParent()).addView(r0);
        getActivity();
    }

    protected void addVpn() {
        if (interruptByEnforcedAdmin() == false) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
    L7:
        if (this.mConfigPreferences.containsKey(Long.toHexString(r0)) == false) goto L9;
        r0 = r0 + 1;
        goto L7
    L9:
        Intent r2 = new Intent(getActivity(), VpnConfigActivity.class);
        r2.putExtra(EXTRA_VPN_PROFILE, new VpnProfile(Long.toHexString(r0)));
        r2.putExtra(EXTRA_IS_ADD_VPN, true);
        r2.putExtra("title", getString(R.string.add_vpn_title));
        r2.putExtra("back_text_id", R.string.cancel);
        Utils.startActivity(this, r2, 3, 0);
    }

    private void configVpn(VpnProfile r4) {
        if (interruptByEnforcedAdmin() == false) goto L5;
        return;
    L5:
        Intent r0 = new Intent(getActivity(), VpnConfigActivity.class);
        r0.putExtra(EXTRA_VPN_PROFILE, r4);
        r0.putExtra(EXTRA_IS_ADD_VPN, false);
        r0.putExtra("title", getString(R.string.config_vpn_title));
        Utils.startActivity(this, r0, 3, 0);
    }

    private void configAppPrefVpn(AppPreference r4) {
        Intent r0 = new Intent(getActivity(), VpnAppPrefActivity.class);
        r0.putExtra(EXTRA_APP_PACKINFO, r4.getPackageInfo());
        r0.putExtra("title", getString(R.string.config_vpn_title));
        getActivity().startActivity(r0);
    }

    private void registerStickyReceiver() {
        IntentFilter r0 = new IntentFilter("com.android.server.connectivity.VPN_CONFIG");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver((FragmentActivity) NullSafe.nonNull(getActivity()), this.mStickyBroadcastReceiver, r0, 2);
    }

    private void unregisterStickyReceiver() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        r0.unregisterReceiver(this.mStickyBroadcastReceiver);
        return;
    }

    public void com_android_settings_vpn2_VpnSettings__onResume$___twin___() {
        super.onResume();
        this.mConnectivityManager.registerNetworkCallback(VPN_REQUEST, this.mNetworkCallback);
        if (this.mUpdater != null) goto L5;
        this.mUpdater = new Handler(this);
    L5:
        this.mIsAccessibilityEnable = this.mAccessibilityManager.isEnabled();
        this.mUpdater.sendEmptyMessage(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
        Handler r0 = this.mUpdater;
        if (r0 == null) goto L5;
        r0.removeCallbacksAndMessages(null);
    L5:
        super.onPause();
    }

    private void setVpnPreferenceBackground(ArrayList<ManageablePreference23> r3) {
        r3.size();
        Iterator<ManageablePreference23> r4 = r3.iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        ManageablePreference23 r1 = r4.next();
        r0 = r0 + 1;
        goto L4
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r12) {
        this.mUpdater.removeMessages(0);
        if (isAdded() == true) goto L5;
        return false;
    L5:
        final List<VpnProfile> r3 = loadVpnProfiles(new int[0]);
        final List<AppVpnInfo> r6 = getVpnApps(true);
        final Map<String, LegacyVpnInfo> r4 = getConnectedLegacyVpns();
        final Set<AppVpnInfo> r7 = getConnectedAppVpns();
        final Set<AppVpnInfo> r8 = getAlwaysOnAppVpnInfos();
        final String r5 = VpnUtils.getLockdownVpn();
        getActivity().runOnUiThread(new AnonymousClass2(this, r3, r4, r5, r6, r7, r8));
        if (this.mIsAccessibilityEnable == false) goto L8;
        this.mUpdater.sendEmptyMessageDelayed(0, 5000);
    L9:
        return true;
    L8:
        this.mUpdater.sendEmptyMessageDelayed(0, 1000);
        goto L9
    }

    private void updateEmptyViewVisibility(boolean r1) {
        View r0 = this.mEmptyView;
        if (r0 == null) goto L9;
        if (r1 == false) goto L6;
        int r2 = 0;
    L7:
        r0.setVisibility(r2);
        return;
    L6:
        r2 = 8;
        goto L7
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference r13) {
        if (interruptByEnforcedAdmin() == false) goto L5;
        return false;
    L5:
        FragmentActivity r1 = getActivity();
        if ((r13 instanceof ConfigPreference) == false) goto L49;
        final VpnProfile r14 = ((ConfigPreference) r13).getProfile();
        this.mIsVpnAlwaysOn = VpnUtils.isVpnLockdown(r14.key);
        if (this.mConnectedLegacyVpn == null) goto L16;
        if (r14.key.equals(this.mConnectedLegacyVpn.key) == false) goto L16;
        if (this.mConnectedLegacyVpn.state != 3) goto L16;
        registerStickyReceiver();     // Catch: Throwable -> L63
        return true;
    L62:
        return true;
    L16:
        if (r14.saveLogin == true) goto L18;
        configVpn(r14);
        goto L62
    L18:
        if (r14.type == 2) goto L22;
        if (r14.type == 4) goto L22;
    L66:
    L45:
        e = move-exception;
        e.printStackTrace();
        goto L62
    L30:
        if (this.mConnectedLegacyVpn != null) goto L32;
    L38:
        HandInHandProcessor r6 = new HandInHandProcessor();     // Catch: Exception -> L45
        if (r6.isHandInHandle(getActivity()) == false) goto L41;
        r6.showDialog(getActivity(), 5, new AnonymousClass3(this), new AnonymousClass4(this, r14), new AnonymousClass5(this));     // Catch: Exception -> L45
    L65:
        goto L62
    L41:
        LegacyVpnProfileStore.put("VPN_" + r14.key, r14.encode());     // Catch: Exception -> L45
        disconnect(r14.key);     // Catch: Exception -> L45
        updateLockdownVpn(this.mIsVpnAlwaysOn, r14.key);     // Catch: Exception -> L45
        if (VpnUtils.isVpnLockdown(r14.key) == true) goto L65;
        connect(r14);     // Catch: Exception -> L45
        goto L65
    L32:
        if (r14.key.equals(this.mConnectedLegacyVpn.key) == false) goto L38;
        if (this.mConnectedLegacyVpn.state == 2) goto L65;
        if (this.mConnectedLegacyVpn.state != 3) goto L38;
    L22:
        if (certificatesValid("USRPKEY_", r14.ipsecUserCert) == true) goto L66;
        String r12 = r1.getString(R.string.vpn_cert_lost);
        if (r12 != null) goto L26;
    L28:
        return true;
    L26:
        if (r12.length() == 0) goto L28;
        ToastUtils.show(r1, r12);
        goto L28
    L49:
        if ((r13 instanceof AppPreference) == false) goto L61;
        AppPreference r15 = (AppPreference) r13;
        if (r15.getState() != 3) goto L53;
        boolean r0 = true;
    L54:
        if (r0 == false) goto L68;
    L59:
        AppDialogFragment.show(this, r15.getPackageInfo(), r15.getLabel(), false, r0);
        return true;
    L68:
        UserHandle r2 = new UserHandle(UserHandle.getUserId(r15.getUid()));     // Catch: PackageManager.NameNotFoundException -> L64
        Context r3 = getActivity().createPackageContextAsUser(getActivity().getPackageName(), 0, r2);     // Catch: PackageManager.NameNotFoundException -> L64
        Intent r4 = r3.getPackageManager().getLaunchIntentForPackage(r15.getPackageName());     // Catch: PackageManager.NameNotFoundException -> L64
        if (r4 == null) goto L59;
        r3.startActivityAsUser(r4, r2);     // Catch: PackageManager.NameNotFoundException -> L64
        return true;
    L53:
        r0 = false;
        goto L54
    L61:
        addVpn();
        goto L62
    }

    private void connect(VpnProfile r2) throws Exception {
        this.mVpnManager.startLegacyVpn(r2);     // Catch: IllegalStateException -> L4
    L5:
        Handler r1 = this.mUpdater;
        if (r1 == null) goto L11;
        r1.sendEmptyMessage(0);
        return;
    L11:
        return;
    L4:
        showNoNetworkToast();
        goto L5
    }

    private void showNoNetworkToast() {
        OToast r0 = this.mNoNetworkToast;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L9;
        this.mNoNetworkToast = ToastUtils.show(r1, R.string.vpn_no_network);
        return;
    }

    private void disconnect(String r3) {
        LegacyVpnInfo r1 = this.mConnectedLegacyVpn;
        if (r1 != null) goto L5;
    L7:
        Handler r2 = this.mUpdater;
        if (r2 == null) goto L14;
        r2.sendEmptyMessage(0);
        return;
    L14:
        return;
    L5:
        if (r3.equals(r1.key) == false) goto L7;
        VpnUtils.clearLockdownVpn(getActivity());     // Catch: Exception -> L11
        this.mVpnManager.prepareVpn("[Legacy VPN]", "[Legacy VPN]", UserHandle.myUserId());     // Catch: Exception -> L11
        goto L7
    }

    private boolean runConnect(LegacyVpnInfo r1) {
        if (r1.state != 3) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateLockdownVpn(boolean r4, String r5) {
        if (r4 == false) goto L5;
        MultiSDKAdapterNew.setAlwaysOnVpnPackage(this.mVpnManager, UserHandle.myUserId(), null, false, null);
        VpnUtils.setLockdownVpn(getActivity(), r5);
        return;
    L5:
        if (VpnUtils.isVpnLockdown(r5) == false) goto L9;
        VpnUtils.clearLockdownVpn(getActivity());
        return;
    }

    private static String getVpnIdentifier(int r1, String r2) {
        return Integer.toString(r1) + "_" + r2;
    }

    private ConfigPreference findOrCreatePreference(VpnProfile r4) {
        ConfigPreference r0 = this.mConfigPreferences.get(r4.key);
        if (r0 != null) goto L5;
        r0 = new ConfigPreference(getActivity(), this.mManageListener, r4);
        r0.setOnPreferenceClickListener(this);
        this.mConfigPreferences.put(r4.key, r0);
    L5:
        r0.setProfile(r4);
        return r0;
    }

    private AppPreference findOrCreatePreference(AppVpnInfo r6) {
        AppPreference r0 = this.mAppPreferences.get(r6);
        if (r0 != null) goto L6;
        AppPreference r1 = new AppPreference(getActivity(), this.mManageListener, r6.packageName, r6.userId);
        r1.setOnPreferenceClickListener(this);
        this.mAppPreferences.put(r6, r1);
        return r1;
    L6:
        return r0;
    }

    private Map<String, LegacyVpnInfo> getConnectedLegacyVpns() {
        LegacyVpnInfo r0 = this.mVpnManager.getLegacyVpnInfo(UserHandle.myUserId());
        this.mConnectedLegacyVpn = r0;
        if (r0 == null) goto L7;
        return Collections.singletonMap(r0.key, this.mConnectedLegacyVpn);
    L7:
        return Collections.emptyMap();
    }

    private Set<AppVpnInfo> getConnectedAppVpns() {
        ArraySet r0 = new ArraySet();
        Iterator<UserHandle> r1 = this.mUserManager.getUserProfiles().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        UserHandle r2 = r1.next();
        VpnConfig r3 = this.mVpnManager.getVpnConfig(r2.getIdentifier());
        if (r3 == null) goto L4;
        if (r3.legacy == true) goto L4;
        r0.add(new AppVpnInfo(r2.getIdentifier(), r3.user));
        goto L4
    L10:
        return r0;
    }

    private Set<AppVpnInfo> getAlwaysOnAppVpnInfos() {
        ArraySet r0 = new ArraySet();
        Iterator<UserHandle> r1 = this.mUserManager.getUserProfiles().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        int r2 = r1.next().getIdentifier();
        String r3 = this.mVpnManager.getAlwaysOnVpnPackageForUser(r2);
        if (r3 == null) goto L4;
        r0.add(new AppVpnInfo(r2, r3));
        goto L4
    L8:
        return r0;
    }

    private List<AppVpnInfo> getVpnApps(boolean r11) {
        ArrayList r0 = Lists.newArrayList();
        if (r11 == false) goto L8;
        Set r12 = new ArraySet();
        Iterator<UserHandle> r1 = this.mUserManager.getUserProfiles().iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        r12.add(Integer.valueOf(r1.next().getIdentifier()));
    L9:
        List r10 = ((AppOpsManager) getSystemService("appops")).getPackagesForOps(new int[]{47});
        if (r10 == null) goto L27;
        Iterator r13 = r10.iterator();
    L13:
        if (r13.hasNext() == false) goto L27;
        AppOpsManager.PackageOps r2 = (AppOpsManager.PackageOps) r13.next();
        int r5 = UserHandle.getUserId(r2.getUid());
        if (r12.contains(Integer.valueOf(r5)) == false) goto L13;
        Iterator r6 = r2.getOps().iterator();
        boolean r7 = false;
    L19:
        if (r6.hasNext() == false) goto L25;
        AppOpsManager.OpEntry r8 = (AppOpsManager.OpEntry) r6.next();
        if (r8.getOp() != 47) goto L19;
        if (r8.getMode() != 0) goto L19;
        r7 = true;
        goto L19
    L25:
        if (r7 == false) goto L13;
        r0.add(new AppVpnInfo(r5, r2.getPackageName()));
    L27:
        Collections.sort(r0);
        return r0;
    L8:
        r12 = Collections.singleton(Integer.valueOf(UserHandle.myUserId()));
        goto L9
    }

    protected static List<VpnProfile> loadVpnProfiles(int... r7) {
        ArrayList r0 = Lists.newArrayList();
        String[] r2 = LegacyVpnProfileStore.list("VPN_");
        if (r2 == null) goto L15;
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L15;
        String r5 = r2[r4];
        VpnProfile r6 = VpnProfile.decode(r5, LegacyVpnProfileStore.get("VPN_" + r5));
        if (r6 == null) goto L14;
        if (ArrayUtils.contains(r7, r6.type) == true) goto L14;
        if (r6.saveLogin == true) goto L13;
        r6.saveLogin = true;
    L13:
        r0.add(r6);
    L14:
        r4 = r4 + 1;
    L15:
        return r0;
    }

    private boolean certificatesValid(String r4, String r5) {
        String[] r6 = LegacyVpnProfileStore.list("VPN_");
        if (r6 != null) goto L5;
    L8:
        String[] r2 = {this.unspecifiedIpsecUserCert};
    L9:
        int r3 = 1;
    L11:
        if (r3 >= r2.length) goto L17;
        if (r2[r3].equals(r5) == true) goto L20;
        r3 = r3 + 1;
        goto L11
    L20:
        return true;
    L17:
        return false;
    L5:
        if (r6.length == 0) goto L8;
        r2 = new String[r6.length + 1];
        r2[0] = this.unspecifiedIpsecUserCert;
        System.arraycopy(r6, 0, r2, 1, r6.length);
        goto L9
    }

    private boolean interruptByEnforcedAdmin() {
        if (this.mUserManager.hasUserRestriction("no_config_vpn") == false) goto L6;
        RestrictedLockUtils.EnforcedAdmin r0 = MultiSDKAdapterNew.checkIfRestrictionEnforced(getActivity(), "no_config_vpn", UserHandle.myUserId());
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(getActivity(), r0);
        return true;
    L6:
        return false;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_vpn2_VpnSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(VpnSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_vpn2_VpnSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_vpn2_VpnSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(VpnSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_vpn2_VpnSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_vpn2_VpnSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(VpnSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_vpn2_VpnSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
