package com.android.wifitrackerlib;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.net.ConnectivityDiagnosticsManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.TransportInfo;
import android.net.wifi.MloLink;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiEnterpriseConfig;
import android.net.wifi.WifiInfo;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Pair;
import androidx.core.os.BuildCompat;
import com.android.settings.MultiSimAdapter;
import com.android.settings.utils.HanziToPinyin;
import com.android.settingslib.R;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.bytedance.librarian.LibrarianImpl;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public class Utils {
    public static final int DISABLED_TRANSITION_DISABLE_INDICATION = 13;
    public static final int DPM_SECURITY_TYPE_UNKNOWN = -1;

    public static /* synthetic */ int $r8$lambda$QMp_i6U9__Gta_fZJVHiAzXwm5Y(MloLink r0) {
        return r0.getBand();
    }

    public static int convertSecurityTypeToDpmWifiSecurity(int r0) {
        switch(r0) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L9;
            case 5: goto L5;
            case 6: goto L11;
            case 7: goto L9;
            case 8: goto L7;
            case 9: goto L7;
            case 10: goto L3;
            case 11: goto L7;
            case 12: goto L7;
            default: goto L3;
        };
    L3:
        return -1;
    L5:
        return 3;
    L7:
        return 2;
    L9:
        return 1;
    L11:
        return 0;
    }

    public static int getBand(int r1) {
        if (r1 < 2400) goto L9;
        if (r1 >= 2500) goto L9;
        return 1;
    L9:
        if (r1 < 4900) goto L15;
        if (r1 >= 5900) goto L15;
        return 2;
    L15:
        if (r1 >= 5925) goto L17;
        return 0;
    L17:
        if (r1 >= 7125) goto L22;
        return 8;
    L22:
        return 0;
    }

    public Utils() {
    }

    public static ScanResult getBestScanResultByLevel(List<ScanResult> r1) {
        if (r1.isEmpty() == false) goto L7;
        return null;
    L7:
        return (ScanResult) Collections.max(r1, Comparator.comparingInt(new Utils$$ExternalSyntheticLambda1()));
    }

    static /* synthetic */ int lambda$getBestScanResultByLevel$0(ScanResult r0) {
        return r0.level;
    }

    public static List<Integer> getSecurityTypesFromScanResult(ScanResult r4) {
        ArrayList r0 = new ArrayList();
        int[] r5 = r4.getSecurityTypes();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(Integer.valueOf(r5[r2]));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    static List<Integer> getSecurityTypesFromWifiConfiguration(WifiConfiguration r5) {
        if (r5.allowedKeyManagement.get(14) == false) goto L7;
        return Arrays.asList(new Integer[]{8});
    L7:
        if (r5.allowedKeyManagement.get(13) == false) goto L11;
        return Arrays.asList(new Integer[]{7});
    L11:
        if (r5.allowedKeyManagement.get(10) == false) goto L15;
        return Arrays.asList(new Integer[]{5});
    L15:
        if (r5.allowedKeyManagement.get(9) == false) goto L19;
        return Arrays.asList(new Integer[]{6});
    L19:
        if (r5.allowedKeyManagement.get(8) == false) goto L23;
        return Arrays.asList(new Integer[]{4});
    L23:
        if (r5.allowedKeyManagement.get(4) == false) goto L27;
        return Arrays.asList(new Integer[]{2});
    L27:
        if (r5.allowedKeyManagement.get(2) == false) goto L39;
        if (r5.requirePmf == false) goto L37;
        if (r5.allowedPairwiseCiphers.get(1) == true) goto L37;
        if (r5.allowedProtocols.get(1) == false) goto L37;
        return Arrays.asList(new Integer[]{9});
    L37:
        return Arrays.asList(new Integer[]{3, 9});
    L39:
        if (r5.allowedKeyManagement.get(1) == false) goto L43;
        return Arrays.asList(new Integer[]{2});
    L43:
        if (r5.allowedKeyManagement.get(0) == false) goto L55;
        if (r5.wepKeys == null) goto L55;
        int r0 = 0;
    L48:
        if (r0 >= r5.wepKeys.length) goto L55;
        if (r5.wepKeys[r0] != null) goto L52;
        r0 = r0 + 1;
        goto L48
    L52:
        return Arrays.asList(new Integer[]{1});
    L55:
        return Arrays.asList(new Integer[]{0});
    }

    static int getSingleSecurityTypeFromMultipleSecurityTypes(List<Integer> r3) {
        if (r3.size() != 0) goto L7;
        return -1;
    L7:
        if (r3.size() != 1) goto L11;
        return r3.get(0).intValue();
    L11:
        if (r3.size() != 2) goto L22;
        if (r3.contains(0) == false) goto L16;
        return 0;
    L16:
        if (r3.contains(2) == false) goto L19;
        return 2;
    L19:
        if (r3.contains(3) == false) goto L22;
        return 3;
    L22:
        return r3.get(0).intValue();
    }

    static String getAppLabel(Context r2, String r3) {
        return r2.getPackageManager().getApplicationInfo(r3, 0).loadLabel(r2.getPackageManager()).toString();
    L4:
        return "";
    }

    static String getConnectedDescription(Context r9, WifiConfiguration r10, NetworkCapabilities r11, boolean r12, boolean r13, ConnectivityDiagnosticsManager.ConnectivityReport r14) {
        StringJoiner r0 = new StringJoiner(r9.getString(R.string.wifitrackerlib_summary_separator));
        boolean r1 = r11.hasCapability(16);
        boolean r2 = r11.hasCapability(17);
        boolean r3 = r11.hasCapability(24);
        if (r10 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r1 == false) goto L10;
    L12:
        boolean r7 = false;
    L13:
        if (r1 == true) goto L18;
        if (r3 == true) goto L18;
        if (r14 != null) goto L18;
        if (r6 == true) goto L18;
        boolean r15 = true;
    L19:
        boolean r16 = NonSdkApiWrapper.isOemCapabilities(r11);
        if (r10 != null) goto L22;
    L26:
        String r17 = null;
    L27:
        if (r1 == false) goto L29;
    L28:
        boolean r18 = true;
    L37:
        if (TextUtils.isEmpty(r17) == true) goto L44;
        if (r18 == true) goto L43;
        if (r12 == false) goto L42;
        if (r3 == true) goto L43;
    L42:
        r0.add(r9.getString(R.string.wifitrackerlib_available_via_app, new Object[]{r17}));
    L46:
        if (r13 == false) goto L48;
        r0.add(r9.getString(R.string.wifi_connected_low_quality));
    L48:
        if (r2 == false) goto L50;
        r0.add(r9.getString(r9.getResources().getIdentifier("network_available_sign_in", "string", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME)));
    L61:
        return r0.toString();
    L50:
        if (r3 == false) goto L52;
        r0.add(r9.getString(R.string.wifitrackerlib_wifi_limited_connection));
        goto L61
    L52:
        if (r15 == false) goto L54;
        r0.add(r9.getString(R.string.wifitrackerlib_checking_for_internet_access));
        goto L61
    L54:
        if (r7 == false) goto L56;
        r0.add(r9.getString(R.string.wifitrackerlib_private_dns_broken));
        goto L61
    L56:
        if (r1 == true) goto L61;
        if (r6 == false) goto L59;
        r0.add(r9.getString(R.string.wifitrackerlib_wifi_connected_cannot_provide_internet));
        goto L61
    L59:
        r0.add(r9.getString(R.string.wifitrackerlib_wifi_no_internet));
    L43:
        r0.add(r9.getString(R.string.wifitrackerlib_connected_via_app, new Object[]{r17}));
        goto L46
    L44:
        if (r18 == false) goto L46;
        r0.add(r9.getResources().getStringArray(R.array.wifitrackerlib_wifi_status)[NetworkInfo.DetailedState.CONNECTED.ordinal()]);
        goto L46
    L29:
        if (r15 == true) goto L33;
        if (r2 == true) goto L33;
        if (r7 == true) goto L33;
        if (r6 == false) goto L28;
    L33:
        if (r16 == true) goto L28;
        r18 = false;
        goto L37
    L22:
        if (r10.fromWifiNetworkSuggestion == false) goto L24;
    L25:
        r17 = getSuggestionOrSpecifierLabel(r9, r10);
        goto L27
    L24:
        if (r10.fromWifiNetworkSpecifier == false) goto L26;
    L18:
        r15 = false;
        goto L19
    L10:
        if (r11.isPrivateDnsBroken() == false) goto L12;
        r7 = true;
        goto L13
    L5:
        if (r10.isNoInternetAccessExpected() == false) goto L7;
        r6 = true;
        goto L8
    }

    static String getConnectingDescription(Context r2, NetworkInfo r3) {
        if (r2 == null) goto L14;
        if (r3 == null) goto L15;
        NetworkInfo.DetailedState r4 = r3.getDetailedState();
        if (r4 != null) goto L9;
        return "";
    L9:
        String[] r5 = r2.getResources().getStringArray(R.array.wifitrackerlib_wifi_status);
        int r6 = r4.ordinal();
        if (r6 < r5.length) goto L13;
        return "";
    L13:
        return r5[r6];
    L15:
        return "";
    L14:
        return "";
    }

    static String getDisconnectedDescription(WifiTrackerInjector r2, Context r3, WifiConfiguration r4, boolean r5, boolean r6) {
        if (r3 == null) goto L28;
        if (r4 == null) goto L30;
        StringJoiner r0 = new StringJoiner(r3.getString(R.string.wifitrackerlib_summary_separator));
        if (r6 == false) goto L9;
        r0.add(r3.getString(R.string.wifitrackerlib_wifi_disconnected));
    L23:
        String r7 = getWifiConfigurationFailureMessage(r3, r4);
        if (TextUtils.isEmpty(r7) == true) goto L27;
        r0.add(r7);
    L27:
        return r0.toString();
    L9:
        if (r5 == false) goto L18;
        if (r4.isPasspoint() == true) goto L18;
        if (r2.getNoAttributionAnnotationPackages().contains(r4.creatorName) == true) goto L23;
        String r8 = getAppLabel(r3, r4.creatorName);
        if (TextUtils.isEmpty(r8) == true) goto L23;
        r0.add(r3.getString(R.string.wifitrackerlib_saved_network, new Object[]{r8}));
    L18:
        if (r4.fromWifiNetworkSuggestion == false) goto L22;
        String r9 = getSuggestionOrSpecifierLabel(r3, r4);
        if (TextUtils.isEmpty(r9) == true) goto L23;
        r0.add(r3.getString(R.string.wifitrackerlib_available_via_app, new Object[]{r9}));
        goto L23
    L22:
        r0.add(r3.getString(R.string.wifitrackerlib_wifi_remembered));
        goto L23
    L30:
        return "";
    L28:
        return "";
    }

    private static String getSuggestionOrSpecifierLabel(Context r2, WifiConfiguration r3) {
        if (r2 == null) goto L13;
        if (r3 == null) goto L15;
        String r0 = getCarrierNameForSubId(r2, getSubIdForConfig(r2, r3));
        if (TextUtils.isEmpty(r0) == true) goto L8;
        return r0;
    L8:
        String r4 = getAppLabel(r2, r3.creatorName);
        if (TextUtils.isEmpty(r4) == true) goto L12;
        return r4;
    L12:
        return r3.creatorName;
    L15:
        return "";
    L13:
        return "";
    }

    private static String getWifiConfigurationFailureMessage(Context r4, WifiConfiguration r5) {
        if (r4 == null) goto L53;
        if (r5 == null) goto L53;
        WifiConfiguration.NetworkSelectionStatus r1 = r5.getNetworkSelectionStatus();
        if (r1.getNetworkSelectionStatus() == 0) goto L32;
        switch(r1.getNetworkSelectionDisableReason()) {
            case 1: goto L30;
            case 2: goto L28;
            case 3: goto L26;
            case 4: goto L24;
            case 5: goto L28;
            case 6: goto L22;
            case 7: goto L37;
            case 8: goto L20;
            case 9: goto L28;
            case 10: goto L37;
            case 11: goto L37;
            case 12: goto L14;
            case 13: goto L12;
            default: goto L37;
        };
    L37:
        int r6 = r5.getRecentFailureReason();
        if (r6 == 17) goto L52;
        switch(r6) {
            case 1002: goto L52;
            case 1003: goto L50;
            case 1004: goto L52;
            case 1005: goto L48;
            case 1006: goto L46;
            case 1007: goto L48;
            case 1008: goto L48;
            case 1009: goto L44;
            case 1010: goto L44;
            case 1011: goto L42;
            default: goto L40;
        };
    L40:
        return "";
    L42:
        return r4.getString(R.string.wifitrackerlib_wifi_network_not_found);
    L44:
        return r4.getString(R.string.wifitrackerlib_wifi_mbo_oce_assoc_disallowed_insufficient_rssi);
    L46:
        return r4.getString(R.string.wifitrackerlib_wifi_mbo_assoc_disallowed_max_num_sta_associated);
    L48:
        return r4.getString(R.string.wifitrackerlib_wifi_mbo_assoc_disallowed_cannot_connect);
    L50:
        return r4.getString(R.string.wifitrackerlib_wifi_poor_channel_conditions);
    L52:
        return r4.getString(R.string.wifitrackerlib_wifi_ap_unable_to_handle_new_sta);
    L12:
        return r4.getString(R.string.wifitrackerlib_wifi_disabled_transition_disable_indication);
    L14:
        if (r1.hasEverConnected() == true) goto L37;
        if (r1.getDisableReasonCounter(2) <= 0) goto L37;
        return r4.getString(R.string.wifitrackerlib_wifi_disabled_password_failure);
    L20:
        return r4.getString(R.string.wifitrackerlib_wifi_check_password_try_again);
    L22:
        return r4.getString(R.string.wifitrackerlib_wifi_no_internet_no_reconnect);
    L24:
        return r4.getString(R.string.wifitrackerlib_wifi_no_internet);
    L26:
        return r4.getString(R.string.wifitrackerlib_wifi_disabled_network_failure);
    L28:
        return r4.getString(R.string.wifitrackerlib_wifi_disabled_password_failure);
    L30:
        return r4.getString(R.string.wifitrackerlib_wifi_disabled_generic);
    L32:
        if (r1.getDisableReasonCounter(2) <= 0) goto L37;
        if (r1.hasEverConnected() == true) goto L37;
        return r4.getString(R.string.wifitrackerlib_wifi_disabled_password_failure);
    L53:
        return "";
    }

    static String getAutoConnectDescription(Context r2, WifiEntry r3) {
        if (r2 == null) goto L13;
        if (r3 != null) goto L6;
        return "";
    L6:
        if (r3.canSetAutoJoinEnabled() == true) goto L9;
        return "";
    L9:
        if (r3.isAutoJoinEnabled() == false) goto L12;
        return "";
    L12:
        return r2.getString(R.string.wifitrackerlib_auto_connect_disable);
    L13:
        return "";
    }

    static String getMeteredDescription(Context r3, WifiEntry r4) {
        if (r3 == null) goto L23;
        if (r4 != null) goto L7;
        return "";
    L7:
        if (r4.canSetMeteredChoice() == true) goto L12;
        if (r4.getMeteredChoice() == 1) goto L12;
        return "";
    L12:
        if (r4.getMeteredChoice() != 1) goto L16;
        return r3.getString(R.string.wifitrackerlib_wifi_metered_label);
    L16:
        if (r4.getMeteredChoice() != 2) goto L20;
        return r3.getString(R.string.wifitrackerlib_wifi_unmetered_label);
    L20:
        if (r4.isMetered() == true) goto L22;
        return "";
    L22:
        return r3.getString(R.string.wifitrackerlib_wifi_metered_label);
    L23:
        return "";
    }

    static String getVerboseSummary(WifiEntry r3) {
        if (r3 != null) goto L5;
        return "";
    L5:
        StringJoiner r0 = new StringJoiner(HanziToPinyin.Token.SEPARATOR);
        String r1 = r3.getWifiInfoDescription();
        if (TextUtils.isEmpty(r1) == true) goto L8;
        r0.add(r1);
    L8:
        String r2 = r3.getNetworkCapabilityDescription();
        if (TextUtils.isEmpty(r2) == true) goto L11;
        r0.add(r2);
    L11:
        String r4 = r3.getScanResultDescription();
        if (TextUtils.isEmpty(r4) == true) goto L14;
        r0.add(r4);
    L14:
        String r5 = r3.getNetworkSelectionDescription();
        if (TextUtils.isEmpty(r5) == true) goto L18;
        r0.add(r5);
    L18:
        return r0.toString();
    }

    static String getNetworkSelectionDescription(WifiConfiguration r7) {
        if (r7 != null) goto L5;
        return "";
    L5:
        StringBuilder r0 = new StringBuilder();
        WifiConfiguration.NetworkSelectionStatus r8 = r7.getNetworkSelectionStatus();
        if (r8.getNetworkSelectionStatus() == 0) goto L11;
        r0.append(" (" + r8.getNetworkStatusString());
        if (r8.getDisableTime() <= 0) goto L10;
        r0.append(HanziToPinyin.Token.SEPARATOR + DateUtils.formatElapsedTime((System.currentTimeMillis() - r8.getDisableTime()) / 1000));
    L10:
        r0.append(")");
    L11:
        int r1 = WifiConfiguration.NetworkSelectionStatus.getMaxNetworkSelectionDisableReason();
        int r3 = 0;
    L12:
        if (r3 > r1) goto L19;
        int r4 = r8.getDisableReasonCounter(r3);
        if (r4 == 0) goto L17;
        r0.append(HanziToPinyin.Token.SEPARATOR).append(WifiConfiguration.NetworkSelectionStatus.getNetworkSelectionDisableReasonString(r3)).append("=").append(r4);
    L17:
        r3 = r3 + 1;
        goto L12
    L19:
        return r0.toString();
    }

    static String getNetworkDetailedState(Context r2, NetworkInfo r3) {
        if (r2 == null) goto L14;
        if (r3 == null) goto L15;
        NetworkInfo.DetailedState r4 = r3.getDetailedState();
        if (r4 != null) goto L9;
        return "";
    L9:
        String[] r5 = r2.getResources().getStringArray(R.array.wifitrackerlib_wifi_status);
        int r6 = r4.ordinal();
        if (r6 < r5.length) goto L13;
        return "";
    L13:
        return r5[r6];
    L15:
        return "";
    L14:
        return "";
    }

    static boolean isSimPresent(Context r2, final int r3) {
        SubscriptionManager r4 = (SubscriptionManager) r2.getSystemService("telephony_subscription_service");
        if (r4 != null) goto L5;
        return false;
    L5:
        List<SubscriptionInfo> r5 = r4.getActiveSubscriptionInfoList();
        if (r5 != null) goto L8;
    L16:
        return false;
    L8:
        if (r5.isEmpty() == true) goto L16;
        if (r3 != (-1)) goto L15;
        return true;
    L15:
        return r5.stream().anyMatch(new Utils$$ExternalSyntheticLambda5(r3));
    }

    static /* synthetic */ boolean lambda$isSimPresent$1(int r0, SubscriptionInfo r1) {
        if (r1.getCarrierId() != r0) goto L5;
        return true;
    L5:
        return false;
    }

    static String getCarrierNameForSubId(Context r2, int r3) {
        if (r3 != (-1)) goto L5;
        return null;
    L5:
        TelephonyManager r4 = (TelephonyManager) r2.getSystemService(MultiSimAdapter.PHONE_KEY);
        if (r4 != null) goto L8;
        return null;
    L8:
        TelephonyManager r5 = r4.createForSubscriptionId(r3);
        if (r5 != null) goto L11;
        return null;
    L11:
        CharSequence r6 = r5.getSimCarrierIdName();
        if (r6 != null) goto L15;
        return null;
    L15:
        return r6.toString();
    }

    static boolean isServerCertUsedNetwork(WifiConfiguration r1) {
        if (r1.enterpriseConfig != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.enterpriseConfig.isEapMethodServerCertUsed() == false) goto L7;
        return true;
    }

    static boolean isSimCredential(WifiConfiguration r1) {
        if (r1.enterpriseConfig != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.enterpriseConfig.isAuthenticationSimBased() == false) goto L7;
        return true;
    }

    static int getSubIdForConfig(Context r5, WifiConfiguration r6) {
        int r1 = -1;
        if (r6.carrierId != (-1)) goto L5;
        return -1;
    L5:
        SubscriptionManager r7 = (SubscriptionManager) r5.getSystemService("telephony_subscription_service");
        if (r7 != null) goto L8;
        return -1;
    L8:
        List<SubscriptionInfo> r8 = r7.getActiveSubscriptionInfoList();
        if (r8 != null) goto L11;
    L20:
        return r1;
    L11:
        if (r8.isEmpty() == true) goto L20;
        int r0 = SubscriptionManager.getDefaultDataSubscriptionId();
        Iterator<SubscriptionInfo> r9 = r8.iterator();
    L15:
        if (r9.hasNext() == false) goto L20;
        SubscriptionInfo r2 = r9.next();
        if (r2.getCarrierId() != r6.carrierId) goto L15;
        r1 = r2.getSubscriptionId();
        if (r1 != r0) goto L15;
        goto L20
    }

    static boolean isImsiPrivacyProtectionProvided(Context r1, int r2) {
        CarrierConfigManager r3 = (CarrierConfigManager) r1.getSystemService("carrier_config");
        if (r3 != null) goto L5;
        return false;
    L5:
        PersistableBundle r4 = r3.getConfigForSubId(r2);
        if (r4 != null) goto L9;
        return false;
    L9:
        if ((r4.getInt("imsi_key_availability_int") & 2) == 0) goto L12;
        return true;
    L12:
        return false;
    }

    static CharSequence getImsiProtectionDescription(Context r3, WifiConfiguration r4) {
        if (r3 == null) goto L20;
        if (r4 == null) goto L20;
        if (isSimCredential(r4) == false) goto L20;
        if (isServerCertUsedNetwork(r4) == true) goto L20;
        if (r4.carrierId != (-1)) goto L13;
        int r5 = SubscriptionManager.getDefaultSubscriptionId();
    L14:
        if (r5 == (-1)) goto L20;
        if (isImsiPrivacyProtectionProvided(r3, r5) == true) goto L20;
        return NonSdkApiWrapper.linkifyAnnotation(r3, r3.getText(R.string.wifitrackerlib_imsi_protection_warning), "url", r3.getString(R.string.wifitrackerlib_help_url_imsi_protection));
    L13:
        r5 = getSubIdForConfig(r3, r4);
    L20:
        return "";
    }

    private static boolean isScanResultForPskNetwork(ScanResult r1) {
        return r1.capabilities.contains("PSK");
    }

    private static boolean isScanResultForWapiPskNetwork(ScanResult r1) {
        return r1.capabilities.contains("WAPI-PSK");
    }

    private static boolean isScanResultForWapiCertNetwork(ScanResult r1) {
        return r1.capabilities.contains("WAPI-CERT");
    }

    private static boolean isScanResultForEapNetwork(ScanResult r2) {
        if (r2.capabilities.contains("EAP/SHA1") == true) goto L11;
        if (r2.capabilities.contains("EAP/SHA256") == true) goto L11;
        if (r2.capabilities.contains("FT/EAP") == true) goto L11;
        if (r2.capabilities.contains("EAP-FILS") == true) goto L11;
    L15:
        return false;
    L11:
        if (isScanResultForWpa3EnterpriseOnlyNetwork(r2) == true) goto L15;
        if (isScanResultForWpa3EnterpriseTransitionNetwork(r2) == true) goto L15;
        return true;
    }

    private static boolean isScanResultForPmfMandatoryNetwork(ScanResult r1) {
        return r1.capabilities.contains("[MFPR]");
    }

    private static boolean isScanResultForPmfCapableNetwork(ScanResult r1) {
        return r1.capabilities.contains("[MFPC]");
    }

    private static boolean isScanResultForWpa3EnterpriseTransitionNetwork(ScanResult r2) {
        if (r2.capabilities.contains("EAP/SHA1") == true) goto L5;
    L17:
        return false;
    L5:
        if (r2.capabilities.contains("EAP/SHA256") == false) goto L17;
        if (r2.capabilities.contains("RSN") == false) goto L17;
        if (r2.capabilities.contains("WEP") == true) goto L17;
        if (r2.capabilities.contains("TKIP") == true) goto L17;
        if (isScanResultForPmfMandatoryNetwork(r2) == true) goto L17;
        if (isScanResultForPmfCapableNetwork(r2) == false) goto L17;
        return true;
    }

    private static boolean isScanResultForWpa3EnterpriseOnlyNetwork(ScanResult r2) {
        if (r2.capabilities.contains("EAP/SHA256") == true) goto L5;
    L17:
        return false;
    L5:
        if (r2.capabilities.contains("EAP/SHA1") == true) goto L17;
        if (r2.capabilities.contains("RSN") == false) goto L17;
        if (r2.capabilities.contains("WEP") == true) goto L17;
        if (r2.capabilities.contains("TKIP") == true) goto L17;
        if (isScanResultForPmfMandatoryNetwork(r2) == false) goto L17;
        if (isScanResultForPmfCapableNetwork(r2) == false) goto L17;
        return true;
    }

    private static boolean isScanResultForEapSuiteBNetwork(ScanResult r2) {
        if (r2.capabilities.contains("SUITE_B_192") == true) goto L5;
    L13:
        return false;
    L5:
        if (r2.capabilities.contains("RSN") == false) goto L13;
        if (r2.capabilities.contains("WEP") == true) goto L13;
        if (r2.capabilities.contains("TKIP") == true) goto L13;
        if (isScanResultForPmfMandatoryNetwork(r2) == false) goto L13;
        return true;
    }

    private static boolean isScanResultForWepNetwork(ScanResult r1) {
        return r1.capabilities.contains("WEP");
    }

    private static boolean isScanResultForOweNetwork(ScanResult r1) {
        return r1.capabilities.contains("OWE");
    }

    private static boolean isScanResultForOweTransitionNetwork(ScanResult r1) {
        return r1.capabilities.contains("OWE_TRANSITION");
    }

    private static boolean isScanResultForSaeNetwork(ScanResult r1) {
        return r1.capabilities.contains("SAE");
    }

    private static boolean isScanResultForPskSaeTransitionNetwork(ScanResult r2) {
        if (r2.capabilities.contains("PSK") == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.capabilities.contains("SAE") == false) goto L7;
        return true;
    }

    private static boolean isScanResultForUnknownAkmNetwork(ScanResult r1) {
        return r1.capabilities.contains("?");
    }

    private static boolean isScanResultForOpenNetwork(ScanResult r1) {
        if (isScanResultForWepNetwork(r1) == false) goto L5;
    L23:
        return false;
    L5:
        if (isScanResultForPskNetwork(r1) == true) goto L23;
        if (isScanResultForEapNetwork(r1) == true) goto L23;
        if (isScanResultForSaeNetwork(r1) == true) goto L23;
        if (isScanResultForWpa3EnterpriseTransitionNetwork(r1) == true) goto L23;
        if (isScanResultForWpa3EnterpriseOnlyNetwork(r1) == true) goto L23;
        if (isScanResultForWapiPskNetwork(r1) == true) goto L23;
        if (isScanResultForWapiCertNetwork(r1) == true) goto L23;
        if (isScanResultForEapSuiteBNetwork(r1) == true) goto L23;
        if (isScanResultForUnknownAkmNetwork(r1) == true) goto L23;
        return true;
    }

    public static InetAddress getNetworkPart(InetAddress r2, int r3) {
        byte[] r4 = r2.getAddress();
        maskRawAddress(r4, r3);
        return InetAddress.getByAddress(r4);
    L5:
        e = move-exception;
        throw new IllegalArgumentException("getNetworkPart error - " + e.toString());
    }

    public static void maskRawAddress(byte[] r3, int r4) {
        if (r4 < 0) goto L13;
        if (r4 > (r3.length * 8)) goto L13;
        int r0 = r4 / 8;
        byte r5 = (byte) (255 << (8 - (r4 % 8)));
        if (r0 >= r3.length) goto L8;
        r3[r0] = (byte) (r5 & r3[r0]);
    L8:
        r0 = r0 + 1;
        if (r0 >= r3.length) goto L11;
        r3[r0] = 0;
        goto L8
    L11:
        return;
    L13:
        throw new IllegalArgumentException("IP address with " + r3.length + " bytes has invalid prefix length " + r4);
    }

    private static Context createPackageContextAsUser(int r2, Context r3) {
        return r3.createPackageContextAsUser(r3.getPackageName(), 0, UserHandle.getUserHandleForUid(r2));
    L4:
        return null;
    }

    private static DevicePolicyManager retrieveDevicePolicyManagerFromUserContext(int r0, Context r1) {
        Context r2 = createPackageContextAsUser(r0, r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return (DevicePolicyManager) r2.getSystemService(DevicePolicyManager.class);
    }

    private static Pair<UserHandle, ComponentName> getDeviceOwner(Context r3) {
        DevicePolicyManager r4 = (DevicePolicyManager) r3.getSystemService(DevicePolicyManager.class);
        if (r4 != null) goto L17;
        return null;
    L17:
        UserHandle r1 = r4.getDeviceOwnerUser();     // Catch: Exception -> L14
        ComponentName r5 = r4.getDeviceOwnerComponentOnAnyUser();     // Catch: Exception -> L14
        if (r1 == null) goto L19;
        if (r5 != null) goto L10;
        return null;
    L10:
        if (r5.getPackageName() != null) goto L13;
        return null;
    L13:
        return new Pair(r1, r5);
    L19:
        return null;
    L14:
        e = move-exception;
        throw new RuntimeException("getDeviceOwner error - " + e.toString());
    }

    public static boolean isDeviceOwner(int r2, String r3, Context r4) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Pair<UserHandle, ComponentName> r5 = getDeviceOwner(r4);
        if (r5 != null) goto L9;
        return false;
    L9:
        if (((UserHandle) r5.first).equals(UserHandle.getUserHandleForUid(r2)) == true) goto L11;
        return false;
    L11:
        if (((ComponentName) r5.second).getPackageName().equals(r3) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean isProfileOwner(int r1, String r2, Context r3) {
        if (r2 != null) goto L5;
        return false;
    L5:
        DevicePolicyManager r4 = retrieveDevicePolicyManagerFromUserContext(r1, r3);
        if (r4 != null) goto L9;
        return false;
    L9:
        return r4.isProfileOwnerApp(r2);
    }

    public static boolean isDeviceOrProfileOwner(int r1, String r2, Context r3) {
        if (isDeviceOwner(r1, r2, r3) == false) goto L5;
    L8:
        return true;
    L5:
        if (isProfileOwner(r1, r2, r3) == true) goto L8;
        return false;
    }

    public static String getStandardString(Context r1, int r2) {
        if (r2 == 1) goto L18;
        switch(r2) {
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            default: goto L6;
        };
    L6:
        return r1.getString(R.string.wifitrackerlib_wifi_standard_unknown);
    L8:
        return r1.getString(R.string.wifitrackerlib_wifi_standard_11be);
    L10:
        return r1.getString(R.string.wifitrackerlib_wifi_standard_11ad);
    L12:
        return r1.getString(R.string.wifitrackerlib_wifi_standard_11ax);
    L14:
        return r1.getString(R.string.wifitrackerlib_wifi_standard_11ac);
    L16:
        return r1.getString(R.string.wifitrackerlib_wifi_standard_11n);
    L18:
        return r1.getString(R.string.wifitrackerlib_wifi_standard_legacy);
    }

    public static String bandToBandString(Context r1, int r2) {
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L13;
        if (r2 == 8) goto L11;
        return r1.getResources().getString(R.string.wifitrackerlib_wifi_band_unknown);
    L11:
        return r1.getResources().getString(R.string.wifitrackerlib_wifi_band_6_ghz);
    L13:
        return r1.getResources().getString(R.string.wifitrackerlib_wifi_band_5_ghz);
    L15:
        return r1.getResources().getString(R.string.wifitrackerlib_wifi_band_24_ghz);
    }

    public static String frequencyToBandString(Context r0, int r1) {
        return bandToBandString(r0, getBand(r1));
    }

    public static String wifiInfoToBandString(final Context r3, WifiInfo r4) {
        if (BuildCompat.isAtLeastU() == false) goto L5;
        final StringJoiner r0 = new StringJoiner(r3.getResources().getString(R.string.wifitrackerlib_multiband_separator));
        r4.getAssociatedMloLinks().stream().filter(new Utils$$ExternalSyntheticLambda2()).map(new Utils$$ExternalSyntheticLambda3()).distinct().sorted().forEach(new Utils$$ExternalSyntheticLambda4(r0, r3));
        if (r0.length() != 0) goto L11;
        return frequencyToBandString(r3, r4.getFrequency());
    L11:
        return r0.toString();
    L5:
        return frequencyToBandString(r3, r4.getFrequency());
    }

    static /* synthetic */ boolean lambda$wifiInfoToBandString$2(MloLink r1) {
        if (r1.getState() != 3) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ void lambda$wifiInfoToBandString$3(StringJoiner r0, Context r1, Integer r2) {
        r0.add(bandToBandString(r1, r2.intValue()));
    }

    public static String getSpeedString(Context r9, WifiInfo r10, boolean r11) {
        if (r10 != null) goto L5;
        return "";
    L5:
        if (r11 == false) goto L7;
        int r1 = r10.getTxLinkSpeedMbps();
    L8:
        if (r1 > 0) goto L11;
        return "";
    L11:
        if (BuildCompat.isAtLeastU() == false) goto L13;
        List r12 = (List) r10.getAssociatedMloLinks().stream().filter(new Utils$$ExternalSyntheticLambda0()).collect(Collectors.toList());
        if (r12.size() <= 1) goto L17;
        StringJoiner r0 = new StringJoiner(r9.getString(R.string.wifitrackerlib_multiband_separator));
        Iterator r13 = r12.iterator();
    L20:
        if (r13.hasNext() == false) goto L29;
        MloLink r2 = (MloLink) r13.next();
        if (r11 == false) goto L24;
        int r4 = r2.getTxLinkSpeedMbps();
    L25:
        if (r4 <= 0) goto L20;
        r0.add(r9.getString(R.string.wifitrackerlib_link_speed_on_band, new Object[]{r9.getString(R.string.wifitrackerlib_link_speed_mbps, new Object[]{Integer.valueOf(r4)}), bandToBandString(r9, r2.getBand())}));
        goto L20
    L24:
        r4 = r2.getRxLinkSpeedMbps();
        goto L25
    L29:
        return r0.toString();
    L17:
        return r9.getString(R.string.wifitrackerlib_link_speed_mbps, new Object[]{Integer.valueOf(r1)});
    L13:
        return r9.getString(R.string.wifitrackerlib_link_speed_mbps, new Object[]{Integer.valueOf(r1)});
    L7:
        r1 = r10.getRxLinkSpeedMbps();
        goto L8
    }

    static /* synthetic */ boolean lambda$getSpeedString$4(MloLink r1) {
        if (r1.getState() != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static WifiInfo getWifiInfo(NetworkCapabilities r2) {
        TransportInfo r0 = r2.getTransportInfo();
        if ((r0 instanceof WifiInfo) == false) goto L7;
        return (WifiInfo) r0;
    L7:
        return NonSdkApiWrapper.getWifiInfoIfVcn(r2);
    }

    public static String getSecurityString(Context r5, List<Integer> r6, boolean r7) {
        if (r6.size() != 0) goto L9;
        if (r7 == false) goto L7;
        return "";
    L7:
        return r5.getString(R.string.wifitrackerlib_wifi_security_none);
    L9:
        if (r6.size() != 1) goto L45;
        int r0 = r6.get(0).intValue();
        if (r0 == 9) goto L40;
        switch(r0) {
            case 0: goto L36;
            case 1: goto L35;
            case 2: goto L30;
            case 3: goto L26;
            case 4: goto L22;
            case 5: goto L18;
            case 6: goto L14;
            default: goto L45;
        };
    L14:
        if (r7 == false) goto L17;
        return r5.getString(R.string.wifitrackerlib_wifi_security_short_owe);
    L17:
        return r5.getString(R.string.wifitrackerlib_wifi_security_owe);
    L18:
        if (r7 == false) goto L21;
        return r5.getString(R.string.wifitrackerlib_wifi_security_short_eap_suiteb);
    L21:
        return r5.getString(R.string.wifitrackerlib_wifi_security_eap_suiteb);
    L22:
        if (r7 == false) goto L25;
        return r5.getString(R.string.wifitrackerlib_wifi_security_short_sae);
    L25:
        return r5.getString(R.string.wifitrackerlib_wifi_security_sae);
    L26:
        if (r7 == false) goto L29;
        return r5.getString(R.string.wifitrackerlib_wifi_security_short_eap_wpa_wpa2);
    L29:
        return r5.getString(R.string.wifitrackerlib_wifi_security_eap_wpa_wpa2);
    L30:
        if (r7 == false) goto L33;
        return r5.getString(R.string.wifitrackerlib_wifi_security_short_wpa_wpa2);
    L33:
        return r5.getString(R.string.wifitrackerlib_wifi_security_wpa_wpa2);
    L36:
        if (r7 == false) goto L39;
        return "";
    L39:
        return r5.getString(R.string.wifitrackerlib_wifi_security_none);
    L35:
        return r5.getString(R.string.wifitrackerlib_wifi_security_wep);
    L40:
        if (r7 == false) goto L43;
        return r5.getString(R.string.wifitrackerlib_wifi_security_short_eap_wpa3);
    L43:
        return r5.getString(R.string.wifitrackerlib_wifi_security_eap_wpa3);
    L45:
        if (r6.size() == 2) goto L47;
    L72:
        if (r7 == false) goto L75;
        return "";
    L75:
        return r5.getString(R.string.wifitrackerlib_wifi_security_none);
    L47:
        if (r6.contains(0) == false) goto L57;
        if (r6.contains(6) == false) goto L57;
        StringJoiner r8 = new StringJoiner(LibrarianImpl.Constants.SEPARATOR);
        r8.add(r5.getString(R.string.wifitrackerlib_wifi_security_none));
        if (r7 == false) goto L53;
        String r9 = r5.getString(R.string.wifitrackerlib_wifi_security_short_owe);
    L54:
        r8.add(r9);
        return r8.toString();
    L53:
        r9 = r5.getString(R.string.wifitrackerlib_wifi_security_owe);
    L57:
        if (r6.contains(2) == false) goto L65;
        if (r6.contains(4) == false) goto L65;
        if (r7 == false) goto L63;
        return r5.getString(R.string.wifitrackerlib_wifi_security_short_wpa_wpa2_wpa3);
    L63:
        return r5.getString(R.string.wifitrackerlib_wifi_security_wpa_wpa2_wpa3);
    L65:
        if (r6.contains(3) == false) goto L72;
        if (r6.contains(9) == false) goto L72;
        if (r7 == false) goto L71;
        return r5.getString(R.string.wifitrackerlib_wifi_security_short_eap_wpa_wpa2_wpa3);
    L71:
        return r5.getString(R.string.wifitrackerlib_wifi_security_eap_wpa_wpa2_wpa3);
    }

    public static WifiEntry.CertificateInfo getCertificateInfo(WifiEnterpriseConfig r4) {
        if (r4.isEapMethodServerCertUsed() == true) goto L5;
    L20:
        return null;
    L5:
        if (r4.hasCaCertificate() == false) goto L20;
        WifiEntry.CertificateInfo r0 = new WifiEntry.CertificateInfo();
        r0.domain = r4.getDomainSuffixMatch();
        r0.caCertificateAliases = r4.getCaCertificateAliases();
        if (r0.caCertificateAliases == null) goto L17;
        if (r0.caCertificateAliases.length == 1) goto L12;
    L14:
        r0.validationMethod = 1;
    L15:
        return r0;
    L12:
        if (r0.caCertificateAliases[0].startsWith("hash://server/sha256/") == false) goto L14;
        r0.validationMethod = 3;
        r0.caCertificateAliases = null;
        goto L15
    L17:
        if (r4.getCaPath() == null) goto L20;
        r0.validationMethod = 2;
        return r0;
    }
}
