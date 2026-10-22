package com.android.settingslib.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothLeAudioContentMetadata;
import android.bluetooth.BluetoothLeBroadcast;
import android.bluetooth.BluetoothLeBroadcastAssistant;
import android.bluetooth.BluetoothLeBroadcastMetadata;
import android.bluetooth.BluetoothLeBroadcastReceiveState;
import android.bluetooth.BluetoothLeBroadcastSettings;
import android.bluetooth.BluetoothLeBroadcastSubgroup;
import android.bluetooth.BluetoothLeBroadcastSubgroupSettings;
import android.bluetooth.BluetoothProfile;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.UserManager;
import android.provider.Settings;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.settingslib.R;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public class LocalBluetoothLeBroadcast implements LocalBluetoothProfile {
    public static final String ACTION_LE_AUDIO_SHARING_STATE_CHANGE = "com.android.settings.action.BLUETOOTH_LE_AUDIO_SHARING_STATE_CHANGE";
    public static final int BROADCAST_STATE_OFF = 2;
    public static final int BROADCAST_STATE_ON = 1;
    public static final int BROADCAST_STATE_UNKNOWN = 0;
    private static final boolean DEBUG = true;
    private static final int DEFAULT_CODE_MAX = 9999;
    private static final int DEFAULT_CODE_MIN = 1000;
    public static final String EXTRA_BLUETOOTH_DEVICE = "BLUETOOTH_DEVICE";
    public static final String EXTRA_LE_AUDIO_SHARING_STATE = "BLUETOOTH_LE_AUDIO_SHARING_STATE";
    static final String NAME = "LE_AUDIO_BROADCAST";
    private static final int ORDINAL = 1;
    private static final String SETTINGS_PKG = "com.android.settings";
    private static final Uri[] SETTINGS_URIS = null;
    private static final String TAG = "LocalBluetoothLeBroadcast";
    private static final String UNDERLINE = "_";
    private static final int UNKNOWN_VALUE_PLACEHOLDER = -1;
    private String mAppSourceName;
    private BluetoothLeAudioContentMetadata mBluetoothLeAudioContentMetadata;
    private BluetoothLeBroadcastMetadata mBluetoothLeBroadcastMetadata;
    private final BluetoothLeBroadcastAssistant.Callback mBroadcastAssistantCallback;
    private final BluetoothLeBroadcast.Callback mBroadcastCallback;
    private byte[] mBroadcastCode;
    private int mBroadcastId;
    private String mBroadcastName;
    private BluetoothLeAudioContentMetadata.Builder mBuilder;
    private Map<BluetoothLeBroadcast.Callback, Executor> mCachedBroadcastCallbackExecutorMap;
    private ContentResolver mContentResolver;
    private final Context mContext;
    private final CachedBluetoothDeviceManager mDeviceManager;
    private Executor mExecutor;
    private boolean mImproveCompatibility;
    private boolean mIsBroadcastAssistantProfileReady;
    private boolean mIsBroadcastProfileReady;
    private String mNewAppSourceName;
    private String mProgramInfo;
    private BluetoothLeBroadcast mServiceBroadcast;
    private BluetoothLeBroadcastAssistant mServiceBroadcastAssistant;
    private final BluetoothProfile.ServiceListener mServiceListener;
    private ContentObserver mSettingsObserver;

    /* JADX INFO: renamed from: com.android.settingslib.bluetooth.LocalBluetoothLeBroadcast$1, reason: invalid class name */
    public class AnonymousClass1 implements BluetoothProfile.ServiceListener {
        final /* synthetic */ LocalBluetoothLeBroadcast this$0;

        AnonymousClass1(LocalBluetoothLeBroadcast r1) {
            this.this$0 = r1;
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int r4, BluetoothProfile r5) {
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(LocalBluetoothLeBroadcast.TAG, "Bluetooth service connected: " + r4);
            if (r4 != 26) goto L11;
            if (LocalBluetoothLeBroadcast.access$000(this.this$0) == true) goto L11;
            LocalBluetoothLeBroadcast.access$102(this.this$0, (BluetoothLeBroadcast) r5);
            LocalBluetoothLeBroadcast.access$002(this.this$0, true);
            LocalBluetoothLeBroadcast r6 = this.this$0;
            r6.registerServiceCallBack(LocalBluetoothLeBroadcast.access$200(r6), LocalBluetoothLeBroadcast.access$300(this.this$0));
            List<BluetoothLeBroadcastMetadata> r7 = this.this$0.getAllBroadcastMetadata();
            if (r7.isEmpty() == true) goto L9;
            LocalBluetoothLeBroadcast.access$400(this.this$0, r7.get(0));
        L9:
            LocalBluetoothLeBroadcast.access$500(this.this$0);
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(LocalBluetoothLeBroadcast.TAG, "onServiceConnected: register mCachedBroadcastCallbackExecutorMap = " + LocalBluetoothLeBroadcast.access$600(this.this$0));
            LocalBluetoothLeBroadcast.access$600(this.this$0).forEach(new LocalBluetoothLeBroadcast$1$$ExternalSyntheticLambda0(this));
            return;
        L11:
            if (r4 == 29) goto L13;
            return;
        L13:
            if (LocalBluetoothLeBroadcast.access$700(this.this$0) == true) goto L18;
            LocalBluetoothLeBroadcast.access$702(this.this$0, true);
            LocalBluetoothLeBroadcast.access$802(this.this$0, (BluetoothLeBroadcastAssistant) r5);
            LocalBluetoothLeBroadcast r8 = this.this$0;
            LocalBluetoothLeBroadcast.access$1000(r8, LocalBluetoothLeBroadcast.access$200(r8), LocalBluetoothLeBroadcast.access$900(this.this$0));
            return;
        }

        /* JADX INFO: renamed from: lambda$onServiceConnected$0$com-android-settingslib-bluetooth-LocalBluetoothLeBroadcast$1, reason: not valid java name */
        /* synthetic */ void m747x349a6d6(BluetoothLeBroadcast.Callback r1, Executor r2) {
            this.this$0.registerServiceCallBack(r2, r1);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r4) {
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(LocalBluetoothLeBroadcast.TAG, "Bluetooth service disconnected: " + r4);
            if (r4 != 26) goto L8;
            if (LocalBluetoothLeBroadcast.access$000(this.this$0) == false) goto L8;
            LocalBluetoothLeBroadcast.access$002(this.this$0, false);
            LocalBluetoothLeBroadcast.access$1100(this.this$0, 2);
            LocalBluetoothLeBroadcast r0 = this.this$0;
            r0.unregisterServiceCallBack(LocalBluetoothLeBroadcast.access$300(r0));
            LocalBluetoothLeBroadcast.access$600(this.this$0).clear();
        L8:
            if (r4 != 29) goto L13;
            if (LocalBluetoothLeBroadcast.access$700(this.this$0) == false) goto L13;
            LocalBluetoothLeBroadcast.access$702(this.this$0, false);
            LocalBluetoothLeBroadcast r5 = this.this$0;
            LocalBluetoothLeBroadcast.access$1200(r5, LocalBluetoothLeBroadcast.access$900(r5));
        L13:
            if (LocalBluetoothLeBroadcast.access$700(this.this$0) == false) goto L15;
            return;
        L15:
            if (LocalBluetoothLeBroadcast.access$000(this.this$0) == true) goto L19;
            LocalBluetoothLeBroadcast.access$1300(this.this$0);
            return;
        }
    }

    private class BroadcastSettingsObserver extends ContentObserver {
        final /* synthetic */ LocalBluetoothLeBroadcast this$0;

        BroadcastSettingsObserver(LocalBluetoothLeBroadcast r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r2) {
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(LocalBluetoothLeBroadcast.TAG, "BroadcastSettingsObserver: onChange");
            LocalBluetoothLeBroadcast.access$2000(this.this$0);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BroadcastState {
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean accessProfileEnabled() {
        return false;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getConnectionPolicy(BluetoothDevice r1) {
        return 0;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getDrawableResource(BluetoothClass r1) {
        return 0;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getOrdinal() {
        return 1;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getProfileId() {
        return 26;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isAutoConnectable() {
        return true;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean setEnabled(BluetoothDevice r1, boolean r2) {
        return false;
    }

    public String toString() {
        return NAME;
    }

    static /* synthetic */ boolean access$000(LocalBluetoothLeBroadcast r0) {
        return r0.mIsBroadcastProfileReady;
    }

    static /* synthetic */ boolean access$002(LocalBluetoothLeBroadcast r0, boolean r1) {
        r0.mIsBroadcastProfileReady = r1;
        return r1;
    }

    static /* synthetic */ void access$1000(LocalBluetoothLeBroadcast r0, Executor r1, BluetoothLeBroadcastAssistant.Callback r2) {
        r0.registerBroadcastAssistantCallback(r1, r2);
    }

    static /* synthetic */ BluetoothLeBroadcast access$102(LocalBluetoothLeBroadcast r0, BluetoothLeBroadcast r1) {
        r0.mServiceBroadcast = r1;
        return r1;
    }

    static /* synthetic */ void access$1100(LocalBluetoothLeBroadcast r0, int r1) {
        r0.notifyBroadcastStateChange(r1);
    }

    static /* synthetic */ void access$1200(LocalBluetoothLeBroadcast r0, BluetoothLeBroadcastAssistant.Callback r1) {
        r0.unregisterBroadcastAssistantCallback(r1);
    }

    static /* synthetic */ void access$1300(LocalBluetoothLeBroadcast r0) {
        r0.unregisterContentObserver();
    }

    static /* synthetic */ void access$1400(LocalBluetoothLeBroadcast r0, int r1) {
        r0.setLatestBroadcastId(r1);
    }

    static /* synthetic */ String access$1500(LocalBluetoothLeBroadcast r0) {
        return r0.mNewAppSourceName;
    }

    static /* synthetic */ void access$1600(LocalBluetoothLeBroadcast r0, String r1, boolean r2) {
        r0.setAppSourceName(r1, r2);
    }

    static /* synthetic */ void access$1700(LocalBluetoothLeBroadcast r0, BluetoothLeBroadcastMetadata r1) {
        r0.setLatestBluetoothLeBroadcastMetadata(r1);
    }

    static /* synthetic */ void access$1800(LocalBluetoothLeBroadcast r0) {
        r0.stopLocalSourceReceivers();
    }

    static /* synthetic */ void access$1900(LocalBluetoothLeBroadcast r0) {
        r0.resetCacheInfo();
    }

    static /* synthetic */ Executor access$200(LocalBluetoothLeBroadcast r0) {
        return r0.mExecutor;
    }

    static /* synthetic */ void access$2000(LocalBluetoothLeBroadcast r0) {
        r0.updateBroadcastInfoFromContentProvider();
    }

    static /* synthetic */ BluetoothLeBroadcast.Callback access$300(LocalBluetoothLeBroadcast r0) {
        return r0.mBroadcastCallback;
    }

    static /* synthetic */ void access$400(LocalBluetoothLeBroadcast r0, BluetoothLeBroadcastMetadata r1) {
        r0.updateBroadcastInfoFromBroadcastMetadata(r1);
    }

    static /* synthetic */ void access$500(LocalBluetoothLeBroadcast r0) {
        r0.registerContentObserver();
    }

    static /* synthetic */ Map access$600(LocalBluetoothLeBroadcast r0) {
        return r0.mCachedBroadcastCallbackExecutorMap;
    }

    static /* synthetic */ boolean access$700(LocalBluetoothLeBroadcast r0) {
        return r0.mIsBroadcastAssistantProfileReady;
    }

    static /* synthetic */ boolean access$702(LocalBluetoothLeBroadcast r0, boolean r1) {
        r0.mIsBroadcastAssistantProfileReady = r1;
        return r1;
    }

    static /* synthetic */ BluetoothLeBroadcastAssistant access$802(LocalBluetoothLeBroadcast r0, BluetoothLeBroadcastAssistant r1) {
        r0.mServiceBroadcastAssistant = r1;
        return r1;
    }

    static /* synthetic */ BluetoothLeBroadcastAssistant.Callback access$900(LocalBluetoothLeBroadcast r0) {
        return r0.mBroadcastAssistantCallback;
    }

    static {
        SETTINGS_URIS = new Uri[]{Settings.Secure.getUriFor("bluetooth_le_broadcast_name"), Settings.Secure.getUriFor("bluetooth_le_broadcast_program_info"), Settings.Secure.getUriFor("bluetooth_le_broadcast_code"), Settings.Secure.getUriFor("bluetooth_le_broadcast_app_source_name"), Settings.Secure.getUriFor("bluetooth_le_broadcast_improve_compatibility")};
    }

    LocalBluetoothLeBroadcast(Context r3, CachedBluetoothDeviceManager r4) {
        this.mBroadcastId = -1;
        this.mAppSourceName = "";
        this.mNewAppSourceName = "";
        this.mIsBroadcastProfileReady = false;
        this.mIsBroadcastAssistantProfileReady = false;
        this.mImproveCompatibility = false;
        this.mCachedBroadcastCallbackExecutorMap = new ConcurrentHashMap();
        AnonymousClass1 r0 = new AnonymousClass1(this);
        this.mServiceListener = r0;
        this.mBroadcastCallback = new AnonymousClass2(this);
        this.mBroadcastAssistantCallback = new AnonymousClass3(this);
        this.mContext = r3;
        this.mDeviceManager = r4;
        this.mExecutor = Executors.newSingleThreadExecutor();
        this.mBuilder = new BluetoothLeAudioContentMetadata.Builder();
        this.mContentResolver = r3.getContentResolver();
        this.mSettingsObserver = new BroadcastSettingsObserver(this, new Handler(Looper.getMainLooper()));
        updateBroadcastInfoFromContentProvider();
        BluetoothAdapter.getDefaultAdapter().getProfileProxy(r3, r0, 26);
        BluetoothAdapter.getDefaultAdapter().getProfileProxy(r3, r0, 29);
    }

    public void startBroadcast(String r4, String r5) {
        this.mNewAppSourceName = r4;
        if (this.mServiceBroadcast != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "The BluetoothLeBroadcast is null when starting the broadcast.");
        return;
    L6:
        String r6 = getProgramInfo();
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "startBroadcast: language = " + r5 + " ,programInfo = " + r6);
        buildContentMetadata(r5, r6);
        BluetoothLeBroadcast r7 = this.mServiceBroadcast;
        BluetoothLeAudioContentMetadata r8 = this.mBluetoothLeAudioContentMetadata;
        byte[] r3 = this.mBroadcastCode;
        if (r3 != null) goto L9;
    L11:
        r3 = null;
    L12:
        r7.startBroadcast(r8, r3);
        return;
    L9:
        if (r3.length <= 0) goto L11;
        goto L11
    }

    public void startPrivateBroadcast() {
        this.mNewAppSourceName = "Sharing audio";
        BluetoothLeBroadcast r0 = this.mServiceBroadcast;
        if (r0 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "The BluetoothLeBroadcast is null when starting the private broadcast.");
        return;
    L7:
        if (r0.getAllBroadcastMetadata().size() < this.mServiceBroadcast.getMaximumNumberOfBroadcasts()) goto L10;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Skip starting the broadcast due to number limit.");
        return;
    L10:
        String r1 = getBroadcastName();
        String r2 = getProgramInfo();
        boolean r3 = getImproveCompatibility();
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "startBroadcast: language = null , programInfo = " + r2 + ", broadcastName = " + r1 + ", improveCompatibility = " + r3);
        byte[] r4 = null;
        BluetoothLeBroadcastSubgroupSettings r5 = buildBroadcastSubgroupSettings(null, r2, r3);
        if (TextUtils.isEmpty(r1) == false) goto L13;
        r1 = null;
    L13:
        byte[] r6 = this.mBroadcastCode;
        if (r6 != null) goto L16;
    L18:
        this.mServiceBroadcast.startBroadcast(buildBroadcastSettings(true, r1, r4, ImmutableList.of(r5)));
        return;
    L16:
        if (r6.length <= 0) goto L18;
        r4 = r6;
        goto L18
    }

    public boolean isPlaying(int r1) {
        BluetoothLeBroadcast r0 = this.mServiceBroadcast;
        if (r0 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "check isPlaying failed, the BluetoothLeBroadcast is null.");
        return false;
    L7:
        return r0.isPlaying(r1);
    }

    private BluetoothLeBroadcastSettings buildBroadcastSettings(boolean r1, String r2, byte[] r3, List<BluetoothLeBroadcastSubgroupSettings> r4) {
        BluetoothLeBroadcastSettings.Builder r0 = new BluetoothLeBroadcastSettings.Builder().setPublicBroadcast(r1).setBroadcastName(r2).setBroadcastCode(r3);
        Iterator<BluetoothLeBroadcastSubgroupSettings> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        r0.addSubgroupSettings(r5.next());
        goto L4
    L7:
        return r0.build();
    }

    private BluetoothLeBroadcastSubgroupSettings buildBroadcastSubgroupSettings(String r2, String r3, boolean r4) {
        this.mBluetoothLeAudioContentMetadata = new BluetoothLeAudioContentMetadata.Builder().setLanguage(r2).setProgramInfo(r3).build();
        return new BluetoothLeBroadcastSubgroupSettings.Builder().setPreferredQuality(!r4 ? 1 : 0).setContentMetadata(this.mBluetoothLeAudioContentMetadata).build();
    }

    public String getProgramInfo() {
        return this.mProgramInfo;
    }

    public void setProgramInfo(String r2) {
        setProgramInfo(r2, true);
    }

    private void setProgramInfo(String r4, boolean r5) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "setProgramInfo: programInfo is null or empty");
        return;
    L6:
        String r0 = this.mProgramInfo;
        if (r0 != null) goto L9;
    L12:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "setProgramInfo: " + r4);
        this.mProgramInfo = r4;
        if (r5 == false) goto L20;
        ContentResolver r3 = this.mContentResolver;
        if (r3 != null) goto L18;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "mContentResolver is null");
        return;
    L18:
        Settings.Secure.putString(r3, "bluetooth_le_broadcast_program_info", r4);
        return;
    L20:
        return;
    L9:
        if (TextUtils.equals(r0, r4) == false) goto L12;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "setProgramInfo: programInfo is not changed");
    }

    public String getBroadcastName() {
        return this.mBroadcastName;
    }

    public void setBroadcastName(String r2) {
        setBroadcastName(r2, true);
    }

    private void setBroadcastName(String r4, boolean r5) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "setBroadcastName: broadcastName is null or empty");
        return;
    L6:
        String r0 = this.mBroadcastName;
        if (r0 != null) goto L9;
    L12:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "setBroadcastName: " + r4);
        this.mBroadcastName = r4;
        if (r5 == false) goto L20;
        ContentResolver r3 = this.mContentResolver;
        if (r3 != null) goto L18;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "mContentResolver is null");
        return;
    L18:
        Settings.Secure.putString(r3, "bluetooth_le_broadcast_name", r4);
        return;
    L20:
        return;
    L9:
        if (TextUtils.equals(r0, r4) == false) goto L12;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "setBroadcastName: broadcastName is not changed");
    }

    public byte[] getBroadcastCode() {
        return this.mBroadcastCode;
    }

    public void setBroadcastCode(byte[] r2) {
        setBroadcastCode(r2, true);
    }

    private void setBroadcastCode(byte[] r3, boolean r4) {
        if (r3 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "setBroadcastCode: broadcastCode is null");
        return;
    L6:
        byte[] r1 = this.mBroadcastCode;
        if (r1 != null) goto L9;
    L12:
        this.mBroadcastCode = r3;
        if (r4 == false) goto L20;
        ContentResolver r2 = this.mContentResolver;
        if (r2 != null) goto L18;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "mContentResolver is null");
        return;
    L18:
        Settings.Secure.putString(r2, "bluetooth_le_broadcast_code", new String(r3, StandardCharsets.UTF_8));
        return;
    L20:
        return;
    L9:
        if (Arrays.equals(r3, r1) == false) goto L12;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "setBroadcastCode: broadcastCode is not changed");
    }

    public boolean getImproveCompatibility() {
        return this.mImproveCompatibility;
    }

    public void setImproveCompatibility(boolean r2) {
        setImproveCompatibility(r2, true);
    }

    private void setImproveCompatibility(boolean r3, boolean r4) {
        if (this.mImproveCompatibility != r3) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "setImproveCompatibility: improveCompatibility is not changed");
        return;
    L6:
        this.mImproveCompatibility = r3;
        if (r4 == true) goto L9;
        return;
    L9:
        if (this.mContentResolver != null) goto L12;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "mContentResolver is null");
        return;
    L12:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Set improveCompatibility to: " + r3);
        ContentResolver r2 = this.mContentResolver;
        if (r3 == false) goto L15;
        String r5 = "1";
    L16:
        Settings.Secure.putString(r2, "bluetooth_le_broadcast_improve_compatibility", r5);
        return;
    L15:
        r5 = "0";
        goto L16
    }

    private void setLatestBroadcastId(int r3) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "setLatestBroadcastId: mBroadcastId is " + r3);
        this.mBroadcastId = r3;
    }

    public int getLatestBroadcastId() {
        return this.mBroadcastId;
    }

    private void setAppSourceName(String r4, boolean r5) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        r4 = "";
    L5:
        String r0 = this.mAppSourceName;
        if (r0 != null) goto L8;
    L11:
        this.mAppSourceName = r4;
        this.mNewAppSourceName = "";
        if (r5 == false) goto L19;
        ContentResolver r3 = this.mContentResolver;
        if (r3 != null) goto L17;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "mContentResolver is null");
        return;
    L17:
        Settings.Secure.putString(r3, "bluetooth_le_broadcast_app_source_name", r4);
        return;
    L19:
        return;
    L8:
        if (TextUtils.equals(r0, r4) == false) goto L11;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "setAppSourceName: appSourceName is not changed");
    }

    public String getAppSourceName() {
        return this.mAppSourceName;
    }

    private void setLatestBluetoothLeBroadcastMetadata(BluetoothLeBroadcastMetadata r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getBroadcastId() != this.mBroadcastId) goto L8;
        this.mBluetoothLeBroadcastMetadata = r3;
        updateBroadcastInfoFromBroadcastMetadata(r3);
        return;
    }

    public BluetoothLeBroadcastMetadata getLatestBluetoothLeBroadcastMetadata() {
        BluetoothLeBroadcast r0 = this.mServiceBroadcast;
        if (r0 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "The BluetoothLeBroadcast is null");
        return null;
    L7:
        if (this.mBluetoothLeBroadcastMetadata != null) goto L10;
        this.mBluetoothLeBroadcastMetadata = (BluetoothLeBroadcastMetadata) r0.getAllBroadcastMetadata().stream().filter(new LocalBluetoothLeBroadcast$$ExternalSyntheticLambda0(this)).findFirst().orElse(null);
    L10:
        return this.mBluetoothLeBroadcastMetadata;
    }

    /* JADX INFO: renamed from: lambda$getLatestBluetoothLeBroadcastMetadata$0$com-android-settingslib-bluetooth-LocalBluetoothLeBroadcast, reason: not valid java name */
    /* synthetic */ boolean m744xac3c3202(BluetoothLeBroadcastMetadata r1) {
        if (r1.getBroadcastId() != this.mBroadcastId) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateBroadcastInfoFromContentProvider() {
        ContentResolver r0 = this.mContentResolver;
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "updateBroadcastInfoFromContentProvider: mContentResolver is null");
        return;
    L6:
        String r1 = Settings.Secure.getString(r0, "bluetooth_le_broadcast_program_info");
        if (r1 != null) goto L9;
        r1 = getDefaultValueOfProgramInfo();
    L9:
        setProgramInfo(r1, false);
        String r2 = Settings.Secure.getString(this.mContentResolver, "bluetooth_le_broadcast_name");
        if (r2 != null) goto L12;
        r2 = getDefaultValueOfBroadcastName();
    L12:
        setBroadcastName(r2, false);
        String r3 = Settings.Secure.getString(this.mContentResolver, "bluetooth_le_broadcast_code");
        if (r3 != null) goto L15;
        byte[] r4 = getDefaultValueOfBroadcastCode();
    L16:
        setBroadcastCode(r4, false);
        setAppSourceName(Settings.Secure.getString(this.mContentResolver, "bluetooth_le_broadcast_app_source_name"), false);
        String r5 = Settings.Secure.getString(this.mContentResolver, "bluetooth_le_broadcast_improve_compatibility");
        if (r5 != null) goto L19;
        boolean r6 = false;
    L20:
        setImproveCompatibility(r6, false);
        return;
    L19:
        r6 = r5.equals("1");
        goto L20
    L15:
        r4 = r3.getBytes(StandardCharsets.UTF_8);
        goto L16
    }

    private void updateBroadcastInfoFromBroadcastMetadata(BluetoothLeBroadcastMetadata r4) {
        if (r4 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "The bluetoothLeBroadcastMetadata is null");
        return;
    L6:
        setBroadcastName(r4.getBroadcastName());
        setBroadcastCode(r4.getBroadcastCode());
        setLatestBroadcastId(r4.getBroadcastId());
        List r5 = r4.getSubgroups();
        if (r5 != null) goto L9;
    L13:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "The subgroup is not valid value");
        return;
    L9:
        if (r5.size() < 1) goto L13;
        setProgramInfo(((BluetoothLeBroadcastSubgroup) r5.get(0)).getContentMetadata().getProgramInfo());
        setAppSourceName(getAppSourceName(), true);
    }

    public void stopLatestBroadcast() {
        stopBroadcast(this.mBroadcastId);
    }

    public void stopBroadcast(int r3) {
        if (this.mServiceBroadcast != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "The BluetoothLeBroadcast is null when stopping the broadcast.");
        return;
    L6:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "stopBroadcast()");
        this.mServiceBroadcast.stopBroadcast(r3);
    }

    public void updateBroadcast(String r5, String r6) {
        if (this.mServiceBroadcast != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "The BluetoothLeBroadcast is null when updating the broadcast.");
        return;
    L6:
        String r0 = getProgramInfo();
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "updateBroadcast: language = " + r6 + " ,programInfo = " + r0);
        this.mNewAppSourceName = r5;
        BluetoothLeAudioContentMetadata r7 = this.mBuilder.setProgramInfo(r0).build();
        this.mBluetoothLeAudioContentMetadata = r7;
        this.mServiceBroadcast.updateBroadcast(this.mBroadcastId, r7);
    }

    public void updateBroadcast() {
        if (this.mServiceBroadcast != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "The BluetoothLeBroadcast is null when updating the broadcast.");
        return;
    L6:
        String r0 = getProgramInfo();
        String r2 = getBroadcastName();
        this.mBluetoothLeAudioContentMetadata = this.mBuilder.setProgramInfo(r0).build();
        BluetoothLeBroadcastSettings r3 = new BluetoothLeBroadcastSettings.Builder().setBroadcastName(r2).addSubgroupSettings(new BluetoothLeBroadcastSubgroupSettings.Builder().setContentMetadata(this.mBluetoothLeAudioContentMetadata).build()).build();
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "updateBroadcast: broadcastName = " + r2 + " programInfo = " + r0);
        this.mServiceBroadcast.updateBroadcast(this.mBroadcastId, r3);
    }

    public void registerServiceCallBack(Executor r3, BluetoothLeBroadcast.Callback r4) {
        BluetoothLeBroadcast r0 = this.mServiceBroadcast;
        if (r0 != null) goto L11;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "registerServiceCallBack failed, the BluetoothLeBroadcast is null.");
        this.mCachedBroadcastCallbackExecutorMap.putIfAbsent(r4, r3);
        return;
    L11:
        r0.registerCallback(r3, r4);     // Catch: IllegalArgumentException -> L8
        return;
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "registerServiceCallBack failed. " + e.getMessage());
    }

    private void registerBroadcastAssistantCallback(Executor r1, BluetoothLeBroadcastAssistant.Callback r2) {
        BluetoothLeBroadcastAssistant r0 = this.mServiceBroadcastAssistant;
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "registerBroadcastAssistantCallback failed, the BluetoothLeBroadcastAssistant is null.");
        return;
    L6:
        r0.registerCallback(r1, r2);
    }

    public void unregisterServiceCallBack(BluetoothLeBroadcast.Callback r3) {
        this.mCachedBroadcastCallbackExecutorMap.remove(r3);
        BluetoothLeBroadcast r2 = this.mServiceBroadcast;
        if (r2 != null) goto L11;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "unregisterServiceCallBack failed, the BluetoothLeBroadcast is null.");
        return;
    L11:
        r2.unregisterCallback(r3);     // Catch: IllegalArgumentException -> L8
        return;
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "unregisterServiceCallBack failed. " + e.getMessage());
    }

    private void unregisterBroadcastAssistantCallback(BluetoothLeBroadcastAssistant.Callback r1) {
        BluetoothLeBroadcastAssistant r0 = this.mServiceBroadcastAssistant;
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "unregisterBroadcastAssistantCallback, the BluetoothLeBroadcastAssistant is null.");
        return;
    L6:
        r0.unregisterCallback(r1);
    }

    private void buildContentMetadata(String r2, String r3) {
        this.mBluetoothLeAudioContentMetadata = this.mBuilder.setLanguage(r2).setProgramInfo(r3).build();
    }

    public LocalBluetoothLeBroadcastMetadata getLocalBluetoothLeBroadcastMetaData() {
        BluetoothLeBroadcastMetadata r1 = getLatestBluetoothLeBroadcastMetadata();
        if (r1 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "The BluetoothLeBroadcastMetadata is null.");
        return null;
    L7:
        return new LocalBluetoothLeBroadcastMetadata(r1);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isProfileReady() {
        return this.mIsBroadcastProfileReady;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getConnectionStatus(BluetoothDevice r1) {
        BluetoothLeBroadcast r0 = this.mServiceBroadcast;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionState(r1);
    }

    public List<BluetoothDevice> getConnectedDevices() {
        BluetoothLeBroadcast r1 = this.mServiceBroadcast;
        if (r1 != null) goto L7;
        return new ArrayList(0);
    L7:
        return r1.getConnectedDevices();
    }

    public List<BluetoothLeBroadcastMetadata> getAllBroadcastMetadata() {
        BluetoothLeBroadcast r1 = this.mServiceBroadcast;
        if (r1 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "The BluetoothLeBroadcast is null.");
        return Collections.emptyList();
    L7:
        return r1.getAllBroadcastMetadata();
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isEnabled(BluetoothDevice r1) {
        BluetoothLeBroadcast r0 = this.mServiceBroadcast;
        if (r0 != null) goto L7;
        return false;
    L7:
        return !r0.getAllBroadcastMetadata().isEmpty();
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getNameResource(BluetoothDevice r1) {
        return R.string.summary_empty;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getSummaryResourceForDevice(BluetoothDevice r1) {
        return BluetoothUtils.getConnectionStateSummary(getConnectionStatus(r1));
    }

    protected void finalize() {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "finalize()");
        if (this.mServiceBroadcast == null) goto L11;
        BluetoothAdapter.getDefaultAdapter().closeProfileProxy(26, this.mServiceBroadcast);     // Catch: Throwable -> L6
        this.mServiceBroadcast = null;     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Error cleaning up LeAudio proxy", th);
        return;
    }

    private String getDefaultValueOfBroadcastName() {
        return BluetoothAdapter.getDefaultAdapter().getName() + "_" + ThreadLocalRandom.current().nextInt(1000, 9999);
    }

    private String getDefaultValueOfProgramInfo() {
        return BluetoothAdapter.getDefaultAdapter().getName() + "_" + ThreadLocalRandom.current().nextInt(1000, 9999);
    }

    private byte[] getDefaultValueOfBroadcastCode() {
        return generateRandomPassword().getBytes(StandardCharsets.UTF_8);
    }

    private void resetCacheInfo() {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "resetCacheInfo:");
        setAppSourceName("", true);
        this.mBluetoothLeBroadcastMetadata = null;
        this.mBroadcastId = -1;
    }

    private String generateRandomPassword() {
        String r3 = UUID.randomUUID().toString();
        return r3.substring(0, 8) + r3.substring(9, 13);
    }

    private void registerContentObserver() {
        if (this.mContentResolver != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "mContentResolver is null");
        return;
    L6:
        Uri[] r0 = SETTINGS_URIS;
        int r1 = r0.length;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L9;
        this.mContentResolver.registerContentObserver(r0[r3], false, this.mSettingsObserver);
        r3 = r3 + 1;
        goto L7
    }

    private void unregisterContentObserver() {
        ContentResolver r0 = this.mContentResolver;
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "mContentResolver is null");
        return;
    L6:
        r0.unregisterContentObserver(this.mSettingsObserver);
    }

    private void stopLocalSourceReceivers() {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "stopLocalSourceReceivers()");
        Iterator r0 = this.mServiceBroadcastAssistant.getConnectedDevices().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        BluetoothDevice r1 = (BluetoothDevice) r0.next();
        Iterator r2 = this.mServiceBroadcastAssistant.getAllSources(r1).iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        BluetoothLeBroadcastReceiveState r3 = (BluetoothLeBroadcastReceiveState) r2.next();
        int r4 = getLatestBroadcastId();
        if (r3.getBroadcastId() != r4) goto L7;
        this.mServiceBroadcastAssistant.removeSource(r1, r3.getSourceId());
        goto L7
    }

    public void updateFallbackActiveDeviceIfNeeded() {
        BluetoothLeBroadcast r0 = this.mServiceBroadcast;
        if (r0 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Skip updateFallbackActiveDeviceIfNeeded due to broadcast profile is null");
        return;
    L7:
        if (r0.getAllBroadcastMetadata().stream().noneMatch(new LocalBluetoothLeBroadcast$$ExternalSyntheticLambda1(this)) == false) goto L10;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Skip updateFallbackActiveDeviceIfNeeded due to no broadcast ongoing");
        return;
    L10:
        BluetoothLeBroadcastAssistant r1 = this.mServiceBroadcastAssistant;
        if (r1 != null) goto L14;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Skip updateFallbackActiveDeviceIfNeeded due to assistant profile is null");
        return;
    L14:
        List r2 = (List) r1.getConnectedDevices().stream().filter(new LocalBluetoothLeBroadcast$$ExternalSyntheticLambda2(this)).collect(Collectors.toList());
        if (r2.isEmpty() == false) goto L18;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Skip updateFallbackActiveDeviceIfNeeded due to no sinks in broadcast");
        return;
    L18:
        List r3 = BluetoothAdapter.getDefaultAdapter().getMostRecentlyConnectedDevices();
        Iterator r4 = r2.iterator();
        BluetoothDevice r5 = null;
        int r6 = -1;
    L20:
        if (r4.hasNext() == false) goto L26;
        BluetoothDevice r7 = (BluetoothDevice) r4.next();
        if (r3.contains(r7) == false) goto L20;
        int r8 = r3.indexOf(r7);
        if (r8 <= r6) goto L20;
        r5 = r7;
        r6 = r8;
        goto L20
    L26:
        if (r5 != null) goto L29;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Skip updateFallbackActiveDeviceIfNeeded, target is null");
        return;
    L29:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "updateFallbackActiveDeviceIfNeeded, set active device: " + r5.getAnonymizedAddress());
        CachedBluetoothDevice r9 = this.mDeviceManager.findDevice(r5);
        if (r9 != null) goto L33;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Skip updateFallbackActiveDeviceIfNeeded, fail to find cached bt device");
        return;
    L33:
        int r10 = getFallbackActiveGroupId();
        if (r10 != (-1)) goto L36;
    L39:
        r9.setActive();
        return;
    L36:
        if (getGroupId(r9) != r10) goto L39;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Skip updateFallbackActiveDeviceIfNeeded, already is fallback: " + r10);
    }

    /* JADX INFO: renamed from: lambda$updateFallbackActiveDeviceIfNeeded$1$com-android-settingslib-bluetooth-LocalBluetoothLeBroadcast, reason: not valid java name */
    /* synthetic */ boolean m745x5fbf5470(BluetoothLeBroadcastMetadata r1) {
        return this.mServiceBroadcast.isPlaying(r1.getBroadcastId());
    }

    /* JADX INFO: renamed from: lambda$updateFallbackActiveDeviceIfNeeded$2$com-android-settingslib-bluetooth-LocalBluetoothLeBroadcast, reason: not valid java name */
    /* synthetic */ boolean m746x1a34f4f1(BluetoothDevice r1) {
        List r0 = this.mServiceBroadcastAssistant.getAllSources(r1);
        if (r0.isEmpty() == false) goto L5;
    L7:
        return false;
    L5:
        if (r0.stream().anyMatch(new BluetoothUtils$$ExternalSyntheticLambda1()) == false) goto L7;
        return true;
    }

    private int getFallbackActiveGroupId() {
        return Settings.Secure.getInt(this.mContext.getContentResolver(), "bluetooth_le_broadcast_fallback_active_group_id", -1);
    }

    private int getGroupId(CachedBluetoothDevice r6) {
        int r5 = r6.getGroupId();
        String r0 = r6.getDevice().getAnonymizedAddress();
        if (r5 == (-1)) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "getGroupId by CSIP profile for device: " + r0);
        return r5;
    L6:
        Iterator<LocalBluetoothProfile> r7 = r6.getProfiles().iterator();
    L8:
        if (r7.hasNext() == false) goto L13;
        LocalBluetoothProfile r3 = r7.next();
        if ((r3 instanceof LeAudioProfile) == false) goto L8;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "getGroupId by LEA profile for device: " + r0);
        return ((LeAudioProfile) r3).getGroupId(r6.getDevice());
    L13:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "getGroupId return invalid id for device: " + r0);
        return -1;
    }

    private void notifyBroadcastStateChange(int r5) {
        if (this.mContext.getPackageName().equals("com.android.settings") == true) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Skip notifyBroadcastStateChange, not triggered by Settings.");
        return;
    L7:
        if (isWorkProfile(this.mContext) == false) goto L10;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Skip notifyBroadcastStateChange, not triggered for work profile.");
        return;
    L10:
        Intent r0 = new Intent(ACTION_LE_AUDIO_SHARING_STATE_CHANGE);
        r0.putExtra(EXTRA_LE_AUDIO_SHARING_STATE, r5);
        r0.setPackage(this.mContext.getPackageName());
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "notifyBroadcastStateChange for state = " + r5);
        this.mContext.sendBroadcast(r0);
    }

    private boolean isWorkProfile(Context r1) {
        UserManager r0 = (UserManager) r1.getSystemService(UserManager.class);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isManagedProfile() == false) goto L7;
        return true;
    }
}
