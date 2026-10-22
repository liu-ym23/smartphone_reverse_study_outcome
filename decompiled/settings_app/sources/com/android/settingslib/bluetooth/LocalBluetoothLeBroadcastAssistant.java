package com.android.settingslib.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothLeBroadcastAssistant;
import android.bluetooth.BluetoothLeBroadcastMetadata;
import android.bluetooth.BluetoothLeBroadcastReceiveState;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.le.ScanFilter;
import android.content.Context;
import com.GlobalProxyLancet;
import com.android.settingslib.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class LocalBluetoothLeBroadcastAssistant implements LocalBluetoothProfile {
    private static final boolean DEBUG = true;
    static final String NAME = "LE_AUDIO_BROADCAST_ASSISTANT";
    private static final int ORDINAL = 1;
    private static final String TAG = "LocalBluetoothLeBroadcastAssistant";
    private static final int UNKNOWN_VALUE_PLACEHOLDER = -1;
    private BluetoothLeBroadcastMetadata mBluetoothLeBroadcastMetadata;
    private BluetoothLeBroadcastMetadata.Builder mBuilder;
    private final Map<BluetoothLeBroadcastAssistant.Callback, Executor> mCachedCallbackExecutorMap;
    private final CachedBluetoothDeviceManager mDeviceManager;
    private boolean mIsProfileReady;
    private LocalBluetoothProfileManager mProfileManager;
    private BluetoothLeBroadcastAssistant mService;
    private final BluetoothProfile.ServiceListener mServiceListener;

    /* JADX INFO: renamed from: com.android.settingslib.bluetooth.LocalBluetoothLeBroadcastAssistant$1, reason: invalid class name */
    public class AnonymousClass1 implements BluetoothProfile.ServiceListener {
        final /* synthetic */ LocalBluetoothLeBroadcastAssistant this$0;

        AnonymousClass1(LocalBluetoothLeBroadcastAssistant r1) {
            this.this$0 = r1;
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int r4, BluetoothProfile r5) {
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(LocalBluetoothLeBroadcastAssistant.TAG, "Bluetooth service connected");
            LocalBluetoothLeBroadcastAssistant.access$002(this.this$0, (BluetoothLeBroadcastAssistant) r5);
            List r6 = LocalBluetoothLeBroadcastAssistant.access$000(this.this$0).getConnectedDevices();
        L4:
            if (r6.isEmpty() == true) goto L9;
            BluetoothDevice r7 = (BluetoothDevice) r6.remove(0);
            CachedBluetoothDevice r1 = LocalBluetoothLeBroadcastAssistant.access$100(this.this$0).findDevice(r7);
            if (r1 != null) goto L8;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(LocalBluetoothLeBroadcastAssistant.TAG, "LocalBluetoothLeBroadcastAssistant found new device: " + r7);
            r1 = LocalBluetoothLeBroadcastAssistant.access$100(this.this$0).addDevice(r7);
        L8:
            r1.onProfileStateChanged(this.this$0, 2);
            r1.refresh();
            goto L4
        L9:
            LocalBluetoothLeBroadcastAssistant.access$200(this.this$0).callServiceConnectedListeners();
            LocalBluetoothLeBroadcastAssistant.access$302(this.this$0, true);
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(LocalBluetoothLeBroadcastAssistant.TAG, "onServiceConnected, register mCachedCallbackExecutorMap = " + LocalBluetoothLeBroadcastAssistant.access$400(this.this$0));
            LocalBluetoothLeBroadcastAssistant.access$400(this.this$0).forEach(new LocalBluetoothLeBroadcastAssistant$1$$ExternalSyntheticLambda0(this));
        }

        /* JADX INFO: renamed from: lambda$onServiceConnected$0$com-android-settingslib-bluetooth-LocalBluetoothLeBroadcastAssistant$1, reason: not valid java name */
        /* synthetic */ void m748x116fbfa2(BluetoothLeBroadcastAssistant.Callback r1, Executor r2) {
            this.this$0.registerServiceCallBack(r2, r1);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r3) {
            if (r3 == 29) goto L6;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(LocalBluetoothLeBroadcastAssistant.TAG, "The profile is not LE_AUDIO_BROADCAST_ASSISTANT");
            return;
        L6:
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(LocalBluetoothLeBroadcastAssistant.TAG, "Bluetooth service disconnected");
            LocalBluetoothLeBroadcastAssistant.access$200(this.this$0).callServiceDisconnectedListeners();
            LocalBluetoothLeBroadcastAssistant.access$302(this.this$0, false);
            LocalBluetoothLeBroadcastAssistant.access$400(this.this$0).clear();
        }
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean accessProfileEnabled() {
        return false;
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
        return 29;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isAutoConnectable() {
        return true;
    }

    public String toString() {
        return NAME;
    }

    static /* synthetic */ BluetoothLeBroadcastAssistant access$000(LocalBluetoothLeBroadcastAssistant r0) {
        return r0.mService;
    }

    static /* synthetic */ BluetoothLeBroadcastAssistant access$002(LocalBluetoothLeBroadcastAssistant r0, BluetoothLeBroadcastAssistant r1) {
        r0.mService = r1;
        return r1;
    }

    static /* synthetic */ CachedBluetoothDeviceManager access$100(LocalBluetoothLeBroadcastAssistant r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ LocalBluetoothProfileManager access$200(LocalBluetoothLeBroadcastAssistant r0) {
        return r0.mProfileManager;
    }

    static /* synthetic */ boolean access$302(LocalBluetoothLeBroadcastAssistant r0, boolean r1) {
        r0.mIsProfileReady = r1;
        return r1;
    }

    static /* synthetic */ Map access$400(LocalBluetoothLeBroadcastAssistant r0) {
        return r0.mCachedCallbackExecutorMap;
    }

    public LocalBluetoothLeBroadcastAssistant(Context r2, CachedBluetoothDeviceManager r3, LocalBluetoothProfileManager r4) {
        this.mCachedCallbackExecutorMap = new ConcurrentHashMap();
        AnonymousClass1 r0 = new AnonymousClass1(this);
        this.mServiceListener = r0;
        this.mProfileManager = r4;
        this.mDeviceManager = r3;
        BluetoothAdapter.getDefaultAdapter().getProfileProxy(r2, r0, 29);
        this.mBuilder = new BluetoothLeBroadcastMetadata.Builder();
    }

    public void addSource(BluetoothDevice r1, BluetoothLeBroadcastMetadata r2, boolean r3) {
        BluetoothLeBroadcastAssistant r0 = this.mService;
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "The BluetoothLeBroadcastAssistant is null");
        return;
    L6:
        r0.addSource(r1, r2, r3);
    }

    public void addSource(BluetoothDevice r11, int r12, int r13, int r14, int r15, int r16, boolean r17, byte[] r18, BluetoothDevice r19, boolean r20) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "addSource()");
        buildMetadata(r12, r13, r14, r15, r16, r17, r18, r19);
        addSource(r11, this.mBluetoothLeBroadcastMetadata, r20);
    }

    private void buildMetadata(int r2, int r3, int r4, int r5, int r6, boolean r7, byte[] r8, BluetoothDevice r9) {
        this.mBluetoothLeBroadcastMetadata = this.mBuilder.setSourceDevice(r9, r2).setSourceAdvertisingSid(r4).setBroadcastId(r5).setPaSyncInterval(r6).setEncrypted(r7).setBroadcastCode(r8).setPresentationDelayMicros(r3).build();
    }

    public void removeSource(BluetoothDevice r3, int r4) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "removeSource()");
        BluetoothLeBroadcastAssistant r2 = this.mService;
        if (r2 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "The BluetoothLeBroadcastAssistant is null");
        return;
    L6:
        r2.removeSource(r3, r4);
    }

    public void startSearchingForSources(List<ScanFilter> r3) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "startSearchingForSources()");
        BluetoothLeBroadcastAssistant r2 = this.mService;
        if (r2 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "The BluetoothLeBroadcastAssistant is null");
        return;
    L6:
        r2.startSearchingForSources(r3);
    }

    public void stopSearchingForSources() {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "stopSearchingForSources()");
        BluetoothLeBroadcastAssistant r2 = this.mService;
        if (r2 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "The BluetoothLeBroadcastAssistant is null");
        return;
    L6:
        r2.stopSearchingForSources();
    }

    public boolean isSearchInProgress() {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "isSearchInProgress()");
        BluetoothLeBroadcastAssistant r2 = this.mService;
        if (r2 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "The BluetoothLeBroadcastAssistant is null");
        return false;
    L7:
        return r2.isSearchInProgress();
    }

    public List<BluetoothLeBroadcastReceiveState> getAllSources(BluetoothDevice r3) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "getAllSources()");
        BluetoothLeBroadcastAssistant r2 = this.mService;
        if (r2 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "The BluetoothLeBroadcastAssistant is null");
        return new ArrayList();
    L7:
        return r2.getAllSources(r3);
    }

    public void registerServiceCallBack(Executor r3, BluetoothLeBroadcastAssistant.Callback r4) {
        BluetoothLeBroadcastAssistant r0 = this.mService;
        if (r0 != null) goto L11;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "registerServiceCallBack failed, the BluetoothLeBroadcastAssistant is null.");
        this.mCachedCallbackExecutorMap.putIfAbsent(r4, r3);
        return;
    L11:
        r0.registerCallback(r3, r4);     // Catch: IllegalArgumentException -> L8
        return;
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "registerServiceCallBack failed. " + e.getMessage());
    }

    public void unregisterServiceCallBack(BluetoothLeBroadcastAssistant.Callback r3) {
        this.mCachedCallbackExecutorMap.remove(r3);
        BluetoothLeBroadcastAssistant r2 = this.mService;
        if (r2 != null) goto L11;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "unregisterServiceCallBack failed, the BluetoothLeBroadcastAssistant is null.");
        return;
    L11:
        r2.unregisterCallback(r3);     // Catch: IllegalArgumentException -> L8
        return;
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "unregisterServiceCallBack failed. " + e.getMessage());
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isProfileReady() {
        return this.mIsProfileReady;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getConnectionStatus(BluetoothDevice r1) {
        BluetoothLeBroadcastAssistant r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionState(r1);
    }

    public List<BluetoothDevice> getConnectedDevices() {
        BluetoothLeBroadcastAssistant r1 = this.mService;
        if (r1 != null) goto L7;
        return new ArrayList(0);
    L7:
        return r1.getDevicesMatchingConnectionStates(new int[]{2, 1, 3});
    }

    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] r1) {
        BluetoothLeBroadcastAssistant r0 = this.mService;
        if (r0 != null) goto L7;
        return new ArrayList(0);
    L7:
        return r0.getDevicesMatchingConnectionStates(r1);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isEnabled(BluetoothDevice r2) {
        BluetoothLeBroadcastAssistant r1 = this.mService;
        if (r1 == null) goto L10;
        if (r2 != null) goto L7;
        return false;
    L7:
        if (r1.getConnectionPolicy(r2) <= 0) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getConnectionPolicy(BluetoothDevice r1) {
        BluetoothLeBroadcastAssistant r0 = this.mService;
        if (r0 == null) goto L8;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionPolicy(r1);
    L8:
        return 0;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean setEnabled(BluetoothDevice r3, boolean r4) {
        BluetoothLeBroadcastAssistant r0 = this.mService;
        if (r0 == null) goto L12;
        if (r3 == null) goto L15;
        if (r4 == false) goto L11;
        if (r0.getConnectionPolicy(r3) < 100) goto L14;
        return false;
    L14:
        return this.mService.setConnectionPolicy(r3, 100);
    L11:
        return r0.setConnectionPolicy(r3, 0);
    L15:
        return false;
    L12:
        return false;
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
        if (this.mService == null) goto L11;
        BluetoothAdapter.getDefaultAdapter().closeProfileProxy(29, this.mService);     // Catch: Throwable -> L6
        this.mService = null;     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Error cleaning up LeAudio proxy", th);
        return;
    }
}
