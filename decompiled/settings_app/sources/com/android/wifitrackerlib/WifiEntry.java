package com.android.wifitrackerlib;

import android.content.Context;
import android.net.ConnectivityDiagnosticsManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.RouteInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.os.BuildCompat;
import androidx.core.util.Preconditions;
import com.android.settings.utils.HanziToPinyin;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public class WifiEntry {
    public static final int CONNECTED_STATE_CONNECTED = 2;
    public static final int CONNECTED_STATE_CONNECTING = 1;
    public static final int CONNECTED_STATE_DISCONNECTED = 0;
    public static final int FREQUENCY_2_4_GHZ = 2400;
    public static final int FREQUENCY_5_GHZ = 5000;
    public static final int FREQUENCY_60_GHZ = 60000;
    public static final int FREQUENCY_6_GHZ = 6000;
    public static final int FREQUENCY_UNKNOWN = -1;
    public static final int MAX_FREQ_24GHZ = 2500;
    public static final int MAX_FREQ_5GHZ = 5900;
    public static final int MAX_FREQ_60GHZ = 70200;
    public static final int MAX_FREQ_6GHZ = 7125;
    protected static final int MAX_VERBOSE_LOG_DISPLAY_SCANRESULT_COUNT = 4;
    public static final int METERED_CHOICE_AUTO = 0;
    public static final int METERED_CHOICE_METERED = 1;
    public static final int METERED_CHOICE_UNMETERED = 2;
    public static final int MIN_FREQ_24GHZ = 2400;
    public static final int MIN_FREQ_5GHZ = 4900;
    public static final int MIN_FREQ_60GHZ = 58320;
    public static final int MIN_FREQ_6GHZ = 5925;
    public static final int NUM_SECURITY_TYPES = 8;
    public static final int PRIVACY_DEVICE_MAC = 0;
    public static final int PRIVACY_RANDOMIZED_MAC = 1;
    public static final int PRIVACY_UNKNOWN = 2;
    public static final int SECURITY_EAP = 3;
    public static final int SECURITY_EAP_SUITE_B = 6;
    public static final int SECURITY_EAP_WPA3_ENTERPRISE = 7;
    public static final int SECURITY_NONE = 0;
    public static final int SECURITY_OWE = 4;
    public static final int SECURITY_PSK = 2;
    public static final int SECURITY_SAE = 5;
    public static final int SECURITY_WEP = 1;
    public static Comparator<WifiEntry> TITLE_COMPARATOR = null;
    public static final int WIFI_LEVEL_MAX = 4;
    public static final int WIFI_LEVEL_MIN = 0;
    public static final int WIFI_LEVEL_UNREACHABLE = -1;
    public static Comparator<WifiEntry> WIFI_PICKER_COMPARATOR;
    protected final Handler mCallbackHandler;
    protected boolean mCalledConnect;
    protected boolean mCalledDisconnect;
    protected ConnectCallback mConnectCallback;
    protected ConnectedInfo mConnectedInfo;
    protected ConnectivityDiagnosticsManager.ConnectivityReport mConnectivityReport;
    protected final Context mContext;
    protected Network mDefaultNetwork;
    protected NetworkCapabilities mDefaultNetworkCapabilities;
    private int mDeviceWifiStandard;
    protected DisconnectCallback mDisconnectCallback;
    protected final boolean mForSavedNetworksPage;
    protected ForgetCallback mForgetCallback;
    protected final WifiTrackerInjector mInjector;
    private boolean mIsOweTransitionMode;
    private boolean mIsPskSaeTransitionMode;
    protected int mLevel;
    private WifiEntryCallback mListener;
    private Optional<ManageSubscriptionAction> mManageSubscriptionAction;
    protected Network mNetwork;
    protected NetworkCapabilities mNetworkCapabilities;
    protected NetworkInfo mNetworkInfo;
    protected WifiInfo mWifiInfo;
    protected final WifiManager mWifiManager;
    private int mWifiStandard;

    /* JADX INFO: renamed from: com.android.wifitrackerlib.WifiEntry$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$net$NetworkInfo$DetailedState = null;

        static {
            int[] r0 = new int[NetworkInfo.DetailedState.values().length];
            $SwitchMap$android$net$NetworkInfo$DetailedState = r0;
            r0[NetworkInfo.DetailedState.SCANNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$android$net$NetworkInfo$DetailedState[NetworkInfo.DetailedState.CONNECTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$android$net$NetworkInfo$DetailedState[NetworkInfo.DetailedState.AUTHENTICATING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$android$net$NetworkInfo$DetailedState[NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$android$net$NetworkInfo$DetailedState[NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$android$net$NetworkInfo$DetailedState[NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$android$net$NetworkInfo$DetailedState[NetworkInfo.DetailedState.CONNECTED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static class CertificateInfo {
        public static final int CERTIFICATE_VALIDATION_METHOD_USING_CERTIFICATE_PINNING = 3;
        public static final int CERTIFICATE_VALIDATION_METHOD_USING_INSTALLED_ROOTCA = 1;
        public static final int CERTIFICATE_VALIDATION_METHOD_USING_NONE = 0;
        public static final int CERTIFICATE_VALIDATION_METHOD_USING_SYSTEM_CERTIFICATE = 2;
        public String[] caCertificateAliases;
        public String domain;
        public int validationMethod;

        @Retention(RetentionPolicy.SOURCE)
        public @interface CertificateValidationMethod {
        }

        public CertificateInfo() {
        }
    }

    protected class ConnectActionListener implements WifiManager.ActionListener {
        final /* synthetic */ WifiEntry this$0;

        protected ConnectActionListener(WifiEntry r1) {
            this.this$0 = r1;
        }

        public void onSuccess() {
            WifiEntry r0 = this.this$0;
            monitor-enter(r0);
            this.this$0.mCalledConnect = true;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void onFailure(int r2) {
            this.this$0.mCallbackHandler.post(new WifiEntry$ConnectActionListener$$ExternalSyntheticLambda0(this));
        }

        /* JADX INFO: renamed from: lambda$onFailure$0$com-android-wifitrackerlib-WifiEntry$ConnectActionListener, reason: not valid java name */
        /* synthetic */ void m876xe6bfa956() {
            ConnectCallback r1 = this.this$0.mConnectCallback;
            if (r1 == null) goto L6;
            r1.onConnectResult(2);
            return;
        }
    }

    public interface ConnectCallback {
        public static final int CONNECT_STATUS_FAILURE_NO_CONFIG = 1;
        public static final int CONNECT_STATUS_FAILURE_SIM_ABSENT = 3;
        public static final int CONNECT_STATUS_FAILURE_UNKNOWN = 2;
        public static final int CONNECT_STATUS_SUCCESS = 0;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ConnectStatus {
        }

        void onConnectResult(int r1);
    }

    public static class ConnectedInfo {
        public List<String> dnsServers;
        public int frequencyMhz;
        public String gateway;
        public String ipAddress;
        public List<String> ipv6Addresses;
        public int linkSpeedMbps;
        public NetworkCapabilities networkCapabilities;
        public String subnetMask;
        public int wifiStandard;

        public ConnectedInfo() {
            this.dnsServers = new ArrayList();
            this.ipv6Addresses = new ArrayList();
            this.wifiStandard = 0;
        }

        public ConnectedInfo(ConnectedInfo r3) {
            this.dnsServers = new ArrayList();
            this.ipv6Addresses = new ArrayList();
            this.wifiStandard = 0;
            this.frequencyMhz = r3.frequencyMhz;
            this.dnsServers = new ArrayList(this.dnsServers);
            this.linkSpeedMbps = r3.linkSpeedMbps;
            this.ipAddress = r3.ipAddress;
            this.ipv6Addresses = new ArrayList(r3.ipv6Addresses);
            this.gateway = r3.gateway;
            this.subnetMask = r3.subnetMask;
            this.wifiStandard = r3.wifiStandard;
            this.networkCapabilities = r3.networkCapabilities;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnectedState {
    }

    public interface DisconnectCallback {
        public static final int DISCONNECT_STATUS_FAILURE_UNKNOWN = 1;
        public static final int DISCONNECT_STATUS_SUCCESS = 0;

        @Retention(RetentionPolicy.SOURCE)
        public @interface DisconnectStatus {
        }

        void onDisconnectResult(int r1);
    }

    protected class ForgetActionListener implements WifiManager.ActionListener {
        final /* synthetic */ WifiEntry this$0;

        protected ForgetActionListener(WifiEntry r1) {
            this.this$0 = r1;
        }

        public void onSuccess() {
            this.this$0.mCallbackHandler.post(new WifiEntry$ForgetActionListener$$ExternalSyntheticLambda0(this));
        }

        /* JADX INFO: renamed from: lambda$onSuccess$0$com-android-wifitrackerlib-WifiEntry$ForgetActionListener, reason: not valid java name */
        /* synthetic */ void m878x9651724e() {
            ForgetCallback r1 = this.this$0.mForgetCallback;
            if (r1 == null) goto L6;
            r1.onForgetResult(0);
            return;
        }

        public void onFailure(int r2) {
            this.this$0.mCallbackHandler.post(new WifiEntry$ForgetActionListener$$ExternalSyntheticLambda1(this));
        }

        /* JADX INFO: renamed from: lambda$onFailure$1$com-android-wifitrackerlib-WifiEntry$ForgetActionListener, reason: not valid java name */
        /* synthetic */ void m877xe8ae5416() {
            ForgetCallback r1 = this.this$0.mForgetCallback;
            if (r1 == null) goto L6;
            r1.onForgetResult(1);
            return;
        }
    }

    public interface ForgetCallback {
        public static final int FORGET_STATUS_FAILURE_UNKNOWN = 1;
        public static final int FORGET_STATUS_SUCCESS = 0;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ForgetStatus {
        }

        void onForgetResult(int r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Frequency {
    }

    public interface ManageSubscriptionAction {
        void onExecute();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MeteredChoice {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Privacy {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Security {
    }

    public interface SignInCallback {
        public static final int SIGNIN_STATUS_FAILURE_UNKNOWN = 1;
        public static final int SIGNIN_STATUS_SUCCESS = 0;

        @Retention(RetentionPolicy.SOURCE)
        public @interface SignInStatus {
        }

        void onSignInResult(int r1);
    }

    public interface WifiEntryCallback {
        void onUpdated();
    }

    public static /* synthetic */ String $r8$lambda$zfHsz3rXz82mO9Uzi73fmg6luoY(InetAddress r0) {
        return r0.getHostAddress();
    }

    public boolean canConnect() {
        return false;
    }

    public boolean canDisconnect() {
        return false;
    }

    public boolean canEasyConnect() {
        return false;
    }

    public boolean canForget() {
        return false;
    }

    public boolean canSetAutoJoinEnabled() {
        return false;
    }

    public boolean canSetMeteredChoice() {
        return false;
    }

    public boolean canSetPrivacy() {
        return false;
    }

    public boolean canShare() {
        return false;
    }

    public boolean canSignIn() {
        return false;
    }

    public void connect(ConnectCallback r1) {
    }

    protected boolean connectionInfoMatches(WifiInfo r1) {
        return false;
    }

    public void disconnect(DisconnectCallback r1) {
    }

    public void forget(ForgetCallback r1) {
    }

    public String getBandString() {
        return "";
    }

    public CertificateInfo getCertificateInfo() {
        return null;
    }

    public String getHelpUriString() {
        return null;
    }

    public String getKey() {
        return "";
    }

    public String getMacAddress() {
        return null;
    }

    public int getMeteredChoice() {
        return 0;
    }

    String getNetworkSelectionDescription() {
        return "";
    }

    public int getPrivacy() {
        return 2;
    }

    protected String getScanResultDescription() {
        return "";
    }

    public CharSequence getSecondSummary() {
        return "";
    }

    public String getSecurityString(boolean r1) {
        return "";
    }

    public String getSsid() {
        return null;
    }

    public String getStandardString() {
        return "";
    }

    public String getSummary(boolean r1) {
        return "";
    }

    public String getTitle() {
        return "";
    }

    public WifiConfiguration getWifiConfiguration() {
        return null;
    }

    public boolean hasAdminRestrictions() {
        return false;
    }

    public boolean isAutoJoinEnabled() {
        return false;
    }

    public boolean isExpired() {
        return false;
    }

    public boolean isMetered() {
        return false;
    }

    public boolean isSaved() {
        return false;
    }

    public boolean isSubscription() {
        return false;
    }

    public boolean isSuggestion() {
        return false;
    }

    public boolean needsWifiConfiguration() {
        return false;
    }

    public void setAutoJoinEnabled(boolean r1) {
    }

    public void setMeteredChoice(int r1) {
    }

    public void setPrivacy(int r1) {
    }

    public boolean shouldEditBeforeConnect() {
        return false;
    }

    public boolean shouldShowSsid() {
        return false;
    }

    public void signIn(SignInCallback r1) {
    }

    protected void updateSecurityTypes() {
    }

    static {
        WIFI_PICKER_COMPARATOR = Comparator.comparing(new WifiEntry$$ExternalSyntheticLambda12()).thenComparing(new WifiEntry$$ExternalSyntheticLambda15()).thenComparing(new WifiEntry$$ExternalSyntheticLambda16()).thenComparing(new WifiEntry$$ExternalSyntheticLambda1()).thenComparing(new WifiEntry$$ExternalSyntheticLambda2()).thenComparing(new WifiEntry$$ExternalSyntheticLambda3()).thenComparing(new WifiEntry$$ExternalSyntheticLambda4()).thenComparing(new WifiEntry$$ExternalSyntheticLambda5()).thenComparing(new WifiEntry$$ExternalSyntheticLambda6()).thenComparing(new WifiEntry$$ExternalSyntheticLambda7()).thenComparing(new WifiEntry$$ExternalSyntheticLambda13());
        TITLE_COMPARATOR = Comparator.comparing(new WifiEntry$$ExternalSyntheticLambda14());
    }

    static /* synthetic */ Boolean lambda$static$0(WifiEntry r0) {
        return Boolean.valueOf(!r0.isPrimaryNetwork());
    }

    static /* synthetic */ Boolean lambda$static$1(WifiEntry r1) {
        if (r1.getConnectedState() == 2) goto L5;
        boolean r2 = true;
    L7:
        return Boolean.valueOf(r2);
    L5:
        r2 = false;
        goto L7
    }

    static /* synthetic */ Boolean lambda$static$2(WifiEntry r0) {
        return Boolean.valueOf(!(r0 instanceof KnownNetworkEntry));
    }

    static /* synthetic */ Boolean lambda$static$3(WifiEntry r0) {
        return Boolean.valueOf(!(r0 instanceof HotspotNetworkEntry));
    }

    static /* synthetic */ Integer lambda$static$4(WifiEntry r1) {
        if ((r1 instanceof HotspotNetworkEntry) == false) goto L5;
        int r2 = -((HotspotNetworkEntry) r1).getUpstreamConnectionStrength();
    L7:
        return Integer.valueOf(r2);
    L5:
        r2 = 0;
        goto L7
    }

    static /* synthetic */ Boolean lambda$static$5(WifiEntry r0) {
        return Boolean.valueOf(!r0.canConnect());
    }

    static /* synthetic */ Boolean lambda$static$6(WifiEntry r0) {
        return Boolean.valueOf(!r0.isSubscription());
    }

    static /* synthetic */ Boolean lambda$static$7(WifiEntry r0) {
        return Boolean.valueOf(!r0.isSaved());
    }

    static /* synthetic */ Boolean lambda$static$8(WifiEntry r0) {
        return Boolean.valueOf(!r0.isSuggestion());
    }

    static /* synthetic */ Integer lambda$static$9(WifiEntry r0) {
        return Integer.valueOf(-r0.getLevel());
    }

    static /* synthetic */ String lambda$static$10(WifiEntry r0) {
        return r0.getTitle();
    }

    static /* synthetic */ String lambda$static$11(WifiEntry r0) {
        return r0.getTitle();
    }

    public WifiEntry(WifiTrackerInjector r2, Handler r3, WifiManager r4, boolean r5) throws IllegalArgumentException {
        this.mLevel = -1;
        this.mCalledConnect = false;
        this.mCalledDisconnect = false;
        this.mManageSubscriptionAction = Optional.empty();
        this.mWifiStandard = 1;
        Preconditions.checkNotNull(r2, "Cannot construct with null injector!");
        Preconditions.checkNotNull(r3, "Cannot construct with null handler!");
        Preconditions.checkNotNull(r4, "Cannot construct with null WifiManager!");
        this.mInjector = r2;
        this.mContext = r2.getContext();
        this.mCallbackHandler = r3;
        this.mForSavedNetworksPage = r5;
        this.mWifiManager = r4;
        updatetDeviceWifiGenerationInfo();
    }

    public synchronized int getConnectedState() {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.mNetworkCapabilities == null) goto L9;
        monitor-exit(this);
        return 2;
    L9:
        if (this.mNetworkInfo == null) goto L17;
        switch(AnonymousClass1.$SwitchMap$android$net$NetworkInfo$DetailedState[this.mNetworkInfo.getDetailedState().ordinal()]) {
            case 1: goto L14;
            case 2: goto L14;
            case 3: goto L14;
            case 4: goto L14;
            case 5: goto L14;
            case 6: goto L14;
            case 7: goto L14;
            default: goto L12;
        };
    L12:
        monitor-exit(this);
        return 0;
    L14:
        monitor-exit(this);
        return 1;
    L17:
        monitor-exit(this);
        return 0;
    }

    public String getSummary() {
        return getSummary(true);
    }

    public int getLevel() {
        return this.mLevel;
    }

    public boolean shouldShowXLevelIcon() {
        if (getConnectedState() != 0) goto L5;
    L15:
        return false;
    L5:
        if (this.mConnectivityReport == null) goto L15;
        if (hasInternetAccess() == false) goto L11;
        if (isLowQuality() == false) goto L15;
    L11:
        if (canSignIn() == true) goto L15;
        if (isPrimaryNetwork() == false) goto L15;
        return true;
    }

    public synchronized boolean hasInternetAccess() {
        monitor-enter(this);
        NetworkCapabilities r0 = this.mNetworkCapabilities;     // Catch: Throwable -> L11
        if (r0 == null) goto L8;
        if (r0.hasCapability(16) == false) goto L8;
        boolean r1 = true;
    L9:
        monitor-exit(this);
        return r1;
    L8:
        r1 = false;
    L11:
        th = move-exception;
        throw th;
    }

    public boolean isDefaultNetwork() {
        Network r0 = this.mNetwork;
        if (r0 != null) goto L5;
    L7:
        NetworkCapabilities r1 = this.mDefaultNetworkCapabilities;
        if (r1 != null) goto L10;
        return false;
    L10:
        WifiInfo r2 = Utils.getWifiInfo(r1);
        if (r2 == null) goto L15;
        return connectionInfoMatches(r2);
    L15:
        if (BuildCompat.isAtLeastT() == false) goto L17;
        List r3 = this.mDefaultNetworkCapabilities.getUnderlyingNetworks();
    L18:
        if (r3 == null) goto L23;
        if (r3.contains(this.mNetwork) == false) goto L23;
        return true;
    L23:
        return false;
    L17:
        r3 = null;
        goto L18
    L5:
        if (r0.equals(this.mDefaultNetwork) == false) goto L7;
        return true;
    }

    public synchronized boolean isPrimaryNetwork() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        boolean r1 = false;
        if (getConnectedState() != 0) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (this.mNetworkInfo != null) goto L14;
        WifiInfo r0 = this.mWifiInfo;     // Catch: Throwable -> L17
        if (r0 == null) goto L15;
        if (NonSdkApiWrapper.isPrimary(r0) == true) goto L14;
    L15:
        monitor-exit(this);
        return r1;
    L14:
        r1 = true;
        goto L15
    }

    public synchronized boolean isLowQuality() {
        monitor-enter(this);
        boolean r1 = false;
        if (isPrimaryNetwork() == true) goto L6;
    L18:
        monitor-exit(this);
        return r1;
    L6:
        if (hasInternetAccess() == false) goto L18;
        if (isDefaultNetwork() == true) goto L18;
        NetworkCapabilities r0 = this.mDefaultNetworkCapabilities;     // Catch: Throwable -> L20
        if (r0 == null) goto L18;
        if (r0.hasTransport(0) == false) goto L18;
        if (this.mDefaultNetworkCapabilities.hasTransport(4) == true) goto L18;
        if (this.mDefaultNetworkCapabilities.hasCapability(13) == false) goto L18;
        r1 = true;
    L20:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public int getSecurity() {
        switch(Utils.getSingleSecurityTypeFromMultipleSecurityTypes(getSecurityTypes())) {
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L7;
            case 10: goto L4;
            case 11: goto L6;
            case 12: goto L6;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 3;
    L7:
        return 7;
    L9:
        return 4;
    L11:
        return 6;
    L13:
        return 5;
    L15:
        return 3;
    L16:
        return 2;
    L18:
        return 1;
    }

    public List<Integer> getSecurityTypes() {
        return Collections.emptyList();
    }

    public synchronized ConnectedInfo getConnectedInfo() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (getConnectedState() == 2) goto L9;
        monitor-exit(this);
        return null;
    L9:
        ConnectedInfo r0 = new ConnectedInfo(this.mConnectedInfo);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r0;
    }

    public String getTxSpeedString() {
        return Utils.getSpeedString(this.mContext, this.mWifiInfo, true);
    }

    public String getRxSpeedString() {
        return Utils.getSpeedString(this.mContext, this.mWifiInfo, false);
    }

    public boolean canManageSubscription() {
        return this.mManageSubscriptionAction.isPresent();
    }

    public void manageSubscription() {
        this.mManageSubscriptionAction.ifPresent(new WifiEntry$$ExternalSyntheticLambda0());
    }

    public void setManageSubscriptionAction(ManageSubscriptionAction r2) {
        boolean r0 = !this.mManageSubscriptionAction.isPresent();
        this.mManageSubscriptionAction = Optional.of(r2);
        if (r0 == false) goto L6;
        notifyOnUpdated();
        return;
    }

    String getNetworkCapabilityDescription() {
        StringBuilder r0 = new StringBuilder();
        if (getConnectedState() != 2) goto L6;
        r0.append("hasInternet:").append(hasInternetAccess()).append(", isDefaultNetwork:").append(isDefaultNetwork()).append(", isLowQuality:").append(isLowQuality());
    L6:
        return r0.toString();
    }

    public synchronized void setListener(WifiEntryCallback r1) {
        monitor-enter(this);
        this.mListener = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    protected void notifyOnUpdated() {
        if (this.mListener == null) goto L6;
        this.mCallbackHandler.post(new WifiEntry$$ExternalSyntheticLambda10(this));
        return;
    }

    /* JADX INFO: renamed from: lambda$notifyOnUpdated$12$com-android-wifitrackerlib-WifiEntry, reason: not valid java name */
    /* synthetic */ void m874lambda$notifyOnUpdated$12$comandroidwifitrackerlibWifiEntry() {
        WifiEntryCallback r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onUpdated();
        return;
    }

    synchronized void onPrimaryWifiInfoChanged(WifiInfo r2, NetworkInfo r3) {
        monitor-enter(this);
        if (r2 == null) goto L13;
    L17:
        th = move-exception;
        throw th;
    L5:
        if (connectionInfoMatches(r2) == false) goto L13;
        if (r3 == null) goto L9;
        this.mNetworkInfo = r3;     // Catch: Throwable -> L17
    L9:
        updateWifiInfo(r2);     // Catch: Throwable -> L17
        notifyOnUpdated();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L13:
        if (this.mNetworkInfo == null) goto L15;
        this.mNetworkInfo = null;     // Catch: Throwable -> L17
        notifyOnUpdated();     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
    }

    synchronized void onNetworkCapabilitiesChanged(Network r3, NetworkCapabilities r4) {
        monitor-enter(this);
        WifiInfo r0 = Utils.getWifiInfo(r4);     // Catch: Throwable -> L24
        if (r0 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (connectionInfoMatches(r0) == true) goto L15;
        if (r3.equals(this.mNetwork) == false) goto L12;
        onNetworkLost(r3);     // Catch: Throwable -> L24
    L12:
        monitor-exit(this);
        return;
    L15:
        if (NonSdkApiWrapper.isPrimary(r0) == false) goto L17;
    L21:
        this.mNetwork = r3;     // Catch: Throwable -> L24
        this.mNetworkCapabilities = r4;     // Catch: Throwable -> L24
        updateWifiInfo(r0);     // Catch: Throwable -> L24
        notifyOnUpdated();     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L17:
        if (NonSdkApiWrapper.isOemCapabilities(r4) == true) goto L21;
        onNetworkLost(r3);     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    private synchronized void updateWifiInfo(WifiInfo r2) {
        monitor-enter(this);
        if (r2 == null) goto L5;
        this.mWifiInfo = r2;     // Catch: Throwable -> L23
        int r3 = r2.getRssi();     // Catch: Throwable -> L23
        if (r3 == (-127)) goto L12;
        this.mLevel = this.mWifiManager.calculateSignalLevel(r3);     // Catch: Throwable -> L23
    L12:
        if (getConnectedState() == 2) goto L14;
    L20:
        updateSecurityTypes();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L14:
        if (this.mCalledConnect == false) goto L17;
        this.mCalledConnect = false;     // Catch: Throwable -> L23
        this.mCallbackHandler.post(new WifiEntry$$ExternalSyntheticLambda11(this));     // Catch: Throwable -> L23
    L17:
        if (this.mConnectedInfo != null) goto L19;
        this.mConnectedInfo = new ConnectedInfo();     // Catch: Throwable -> L23
    L19:
        ConnectedInfo r4 = this.mConnectedInfo;     // Catch: Throwable -> L23
        r4.frequencyMhz = this.mWifiInfo.getFrequency();     // Catch: Throwable -> L23
        ConnectedInfo r5 = this.mConnectedInfo;     // Catch: Throwable -> L23
        r5.linkSpeedMbps = this.mWifiInfo.getLinkSpeed();     // Catch: Throwable -> L23
        ConnectedInfo r6 = this.mConnectedInfo;     // Catch: Throwable -> L23
        r6.wifiStandard = this.mWifiInfo.getWifiStandard();     // Catch: Throwable -> L23
        goto L20
    L5:
        this.mWifiInfo = null;     // Catch: Throwable -> L23
        this.mConnectedInfo = null;     // Catch: Throwable -> L23
        updateSecurityTypes();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: lambda$updateWifiInfo$13$com-android-wifitrackerlib-WifiEntry, reason: not valid java name */
    /* synthetic */ void m875lambda$updateWifiInfo$13$comandroidwifitrackerlibWifiEntry() {
        ConnectCallback r1 = this.mConnectCallback;
        if (r1 == null) goto L6;
        r1.onConnectResult(0);
        return;
    }

    synchronized void onNetworkLost(Network r2) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (r2.equals(this.mNetwork) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        clearConnectionInfo();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    synchronized void clearConnectionInfo() {
        monitor-enter(this);
        updateWifiInfo(null);     // Catch: Throwable -> L10
        this.mNetworkInfo = null;     // Catch: Throwable -> L10
        this.mNetworkCapabilities = null;     // Catch: Throwable -> L10
        this.mConnectivityReport = null;     // Catch: Throwable -> L10
        if (this.mCalledDisconnect == false) goto L7;
        this.mCalledDisconnect = false;     // Catch: Throwable -> L10
        this.mCallbackHandler.post(new WifiEntry$$ExternalSyntheticLambda9(this));     // Catch: Throwable -> L10
    L7:
        notifyOnUpdated();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: lambda$clearConnectionInfo$14$com-android-wifitrackerlib-WifiEntry, reason: not valid java name */
    /* synthetic */ void m873xf8e9b8f5() {
        DisconnectCallback r1 = this.mDisconnectCallback;
        if (r1 == null) goto L6;
        r1.onDisconnectResult(0);
        return;
    }

    synchronized void onDefaultNetworkCapabilitiesChanged(Network r1, NetworkCapabilities r2) {
        monitor-enter(this);
        this.mDefaultNetwork = r1;     // Catch: Throwable -> L6
        this.mDefaultNetworkCapabilities = r2;     // Catch: Throwable -> L6
        notifyOnUpdated();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void onDefaultNetworkLost() {
        monitor-enter(this);
        this.mDefaultNetwork = null;     // Catch: Throwable -> L7
        this.mDefaultNetworkCapabilities = null;     // Catch: Throwable -> L7
        notifyOnUpdated();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    synchronized void updateLinkProperties(Network r6, LinkProperties r7) {
        monitor-enter(this);
    L35:
        th = move-exception;
        throw th;
    L4:
        if (r6.equals(this.mNetwork) == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.mConnectedInfo != null) goto L10;
        this.mConnectedInfo = new ConnectedInfo();     // Catch: Throwable -> L35
    L10:
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L35
        Iterator<LinkAddress> r0 = r7.getLinkAddresses().iterator();     // Catch: Throwable -> L35
    L12:
        if (r0.hasNext() == false) goto L22;
        LinkAddress r1 = r0.next();     // Catch: Throwable -> L35
        if ((r1.getAddress() instanceof Inet4Address) == true) goto L15;
        if ((r1.getAddress() instanceof Inet6Address) == false) goto L12;
        r8.add(r1.getAddress().getHostAddress());     // Catch: Throwable -> L35
        goto L12
    L15:
        this.mConnectedInfo.ipAddress = r1.getAddress().getHostAddress();     // Catch: Throwable -> L35
        InetAddress r2 = InetAddress.getByAddress(new byte[]{-1, -1, -1, -1});     // Catch: Throwable -> L38 Throwable -> L35
        this.mConnectedInfo.subnetMask = Utils.getNetworkPart(r2, r1.getPrefixLength()).getHostAddress();     // Catch: Throwable -> L38 Throwable -> L35
        goto L12
    L22:
        this.mConnectedInfo.ipv6Addresses = r8;     // Catch: Throwable -> L35
        Iterator<RouteInfo> r9 = r7.getRoutes().iterator();     // Catch: Throwable -> L35
    L24:
        if (r9.hasNext() == false) goto L32;
        RouteInfo r3 = r9.next();     // Catch: Throwable -> L35
        if (r3.isDefaultRoute() == false) goto L24;
        if ((r3.getDestination().getAddress() instanceof Inet4Address) == false) goto L24;
        if (r3.hasGateway() == false) goto L24;
        this.mConnectedInfo.gateway = r3.getGateway().getHostAddress();     // Catch: Throwable -> L35
    L32:
        this.mConnectedInfo.dnsServers = (List) r7.getDnsServers().stream().map(new WifiEntry$$ExternalSyntheticLambda8()).collect(Collectors.toList());     // Catch: Throwable -> L35
        notifyOnUpdated();     // Catch: Throwable -> L35
        monitor-exit(this);
    }

    synchronized void updateConnectivityReport(ConnectivityDiagnosticsManager.ConnectivityReport r3) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (r3.getNetwork().equals(this.mNetwork) == false) goto L6;
        this.mConnectivityReport = r3;     // Catch: Throwable -> L8
        notifyOnUpdated();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    synchronized String getWifiInfoDescription() {
        monitor-enter(this);
        StringJoiner r7 = new StringJoiner(HanziToPinyin.Token.SEPARATOR);     // Catch: Throwable -> L19
        if (getConnectedState() == 2) goto L7;
    L16:
        String r0 = r7.toString();     // Catch: Throwable -> L19
        monitor-exit(this);
        return r0;
    L7:
        if (this.mWifiInfo == null) goto L16;
        r7.add("f = " + this.mWifiInfo.getFrequency());     // Catch: Throwable -> L19
        String r6 = this.mWifiInfo.getBSSID();     // Catch: Throwable -> L19
        if (r6 == null) goto L11;
        r7.add(r6);     // Catch: Throwable -> L19
    L11:
        r7.add("standard = " + getStandardString());     // Catch: Throwable -> L19
        r7.add("rssi = " + this.mWifiInfo.getRssi());     // Catch: Throwable -> L19
        r7.add("score = " + this.mWifiInfo.getScore());     // Catch: Throwable -> L19
        r7.add(String.format(" tx=%.1f,", new Object[]{Double.valueOf(this.mWifiInfo.getSuccessfulTxPacketsPerSecond())}));     // Catch: Throwable -> L19
        r7.add(String.format("%.1f,", new Object[]{Double.valueOf(this.mWifiInfo.getRetriedTxPacketsPerSecond())}));     // Catch: Throwable -> L19
        r7.add(String.format("%.1f ", new Object[]{Double.valueOf(this.mWifiInfo.getLostTxPacketsPerSecond())}));     // Catch: Throwable -> L19
        r7.add(String.format("rx=%.1f", new Object[]{Double.valueOf(this.mWifiInfo.getSuccessfulRxPacketsPerSecond())}));     // Catch: Throwable -> L19
        if (BuildCompat.isAtLeastT() == false) goto L16;
        if (this.mWifiInfo.getApMldMacAddress() == null) goto L16;
        r7.add("mldMac = " + this.mWifiInfo.getApMldMacAddress());     // Catch: Throwable -> L19
        r7.add("linkId = " + this.mWifiInfo.getApMloLinkId());     // Catch: Throwable -> L19
        r7.add("affLinks = " + Arrays.toString(this.mWifiInfo.getAffiliatedMloLinks().toArray()));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof WifiEntry) == true) goto L7;
        return false;
    L7:
        return getKey().equals(((WifiEntry) r2).getKey());
    }

    public int hashCode() {
        return getKey().hashCode();
    }

    public String toString() {
        StringJoiner r0 = new StringJoiner("][", "[", "]");
        r0.add(getClass().getSimpleName());
        r0.add(getTitle());
        r0.add(getSummary());
        StringBuilder r1 = new StringBuilder("Level:").append(getLevel());
        if (shouldShowXLevelIcon() == false) goto L5;
        String r2 = "!";
    L6:
        r0.add(r1.append(r2).toString());
        String r3 = getSecurityString(true);
        if (TextUtils.isEmpty(r3) == true) goto L9;
        r0.add(r3);
    L9:
        r0.add("Standard:" + getWifiStandard());
        int r4 = getConnectedState();
        if (r4 != 2) goto L12;
        r0.add("Connected");
    L15:
        if (hasInternetAccess() == false) goto L18;
        r0.add("Internet");
    L18:
        if (isDefaultNetwork() == false) goto L21;
        r0.add("Default");
    L21:
        if (isPrimaryNetwork() == false) goto L24;
        r0.add("Primary");
    L24:
        if (isLowQuality() == false) goto L27;
        r0.add("LowQuality");
    L27:
        if (isSaved() == false) goto L30;
        r0.add("Saved");
    L30:
        if (isSubscription() == false) goto L33;
        r0.add("Subscription");
    L33:
        if (isSuggestion() == false) goto L36;
        r0.add("Suggestion");
    L36:
        if (isMetered() == false) goto L39;
        r0.add("Metered");
    L39:
        if (isSaved() == true) goto L45;
        if (isSuggestion() == true) goto L45;
        if (isSubscription() == true) goto L45;
    L48:
        if (isExpired() == false) goto L51;
        r0.add("Expired");
    L51:
        if (canSignIn() == false) goto L54;
        r0.add("SignIn");
    L54:
        if (shouldEditBeforeConnect() == false) goto L57;
        r0.add("EditBeforeConnect");
    L57:
        if (hasAdminRestrictions() == false) goto L60;
        r0.add("AdminRestricted");
    L60:
        return r0.toString();
    L45:
        if (isAutoJoinEnabled() == true) goto L48;
        r0.add("AutoJoinDisabled");
        goto L48
    L12:
        if (r4 != 1) goto L15;
        r0.add("Connecting...");
        goto L15
    L5:
        r2 = "";
        goto L6
    }

    public boolean isVerboseSummaryEnabled() {
        return this.mInjector.isVerboseSummaryEnabled();
    }

    protected void updateTransitionModeCapa(ScanResult r3) {
        if (r3.capabilities.contains("PSK") == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.mIsPskSaeTransitionMode = r0;
        this.mIsOweTransitionMode = r3.capabilities.contains("OWE_TRANSITION");
        return;
    L5:
        if (r3.capabilities.contains("SAE") == false) goto L7;
        r0 = true;
        goto L8
    }

    public boolean isPskSaeTransitionMode() {
        return this.mIsPskSaeTransitionMode;
    }

    public boolean isOweTransitionMode() {
        return this.mIsOweTransitionMode;
    }

    private void updatetDeviceWifiGenerationInfo() {
        if (this.mWifiManager.isWifiStandardSupported(8) == false) goto L6;
        this.mDeviceWifiStandard = 8;
        return;
    L6:
        if (this.mWifiManager.isWifiStandardSupported(6) == false) goto L9;
        this.mDeviceWifiStandard = 6;
        return;
    L9:
        if (this.mWifiManager.isWifiStandardSupported(5) == false) goto L12;
        this.mDeviceWifiStandard = 5;
        return;
    L12:
        if (this.mWifiManager.isWifiStandardSupported(4) == false) goto L14;
        this.mDeviceWifiStandard = 4;
        return;
    L14:
        this.mDeviceWifiStandard = 1;
    }

    public synchronized int getWifiStandard() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (getConnectedInfo() != null) goto L6;
    L13:
        int r0 = this.mWifiStandard;     // Catch: Throwable -> L16
        monitor-exit(this);
        return r0;
    L6:
        if (this.mWifiInfo == null) goto L13;
        if (getConnectedState() != 2) goto L13;
        int r1 = this.mWifiInfo.getWifiStandard();     // Catch: Throwable -> L16
        monitor-exit(this);
        return r1;
    }

    protected void updateWifiGenerationInfo(List<ScanResult> r5) {
        int r0 = this.mDeviceWifiStandard;
        Iterator<ScanResult> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L15;
        ScanResult r1 = r6.next();
        int r2 = r1.getWifiStandard();
        if (r2 < r0) goto L7;
        if (r1.getBand() != 1) goto L4;
        if (r2 != 6) goto L4;
        if (r0 != 5) goto L4;
        r0 = 4;
        goto L4
    L7:
        r0 = r2;
        goto L4
    L15:
        this.mWifiStandard = r0;
    }
}
