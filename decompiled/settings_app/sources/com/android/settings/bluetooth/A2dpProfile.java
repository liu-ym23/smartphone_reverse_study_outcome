package com.android.settings.bluetooth;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothCodecConfig;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.ParcelUuid;
import com.GlobalProxyLancet;
import com.android.settings.AdaptConstants;
import com.android.settings.R;
import com.android.settings.utils.ResourceUtils;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class A2dpProfile implements LocalBluetoothProfile {
    static final String NAME = "A2DP";
    private static final int ORDINAL = 1;
    static final ParcelUuid[] SINK_UUIDS = null;
    private static final String TAG = "A2dpProfile";
    private final BroadcastReceiver mCodecReceiver;
    private Context mContext;
    private final CachedBluetoothDeviceManager mDeviceManager;
    private boolean mIsProfileReady;
    private final LocalBluetoothAdapter mLocalAdapter;
    private Object mLock;
    private final LocalBluetoothProfileManager mProfileManager;
    private BluetoothA2dp mService;

    private final class A2dpServiceListener implements BluetoothProfile.ServiceListener {
        final /* synthetic */ A2dpProfile this$0;

        private A2dpServiceListener(A2dpProfile r1) {
            this.this$0 = r1;
        }

        /* synthetic */ A2dpServiceListener(A2dpProfile r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int r6, BluetoothProfile r7) {
            OLog.d(A2dpProfile.TAG, "Bluetooth service connected");
            Object r8 = A2dpProfile.access$000(this.this$0);
            monitor-enter(r8);
            A2dpProfile.access$102(this.this$0, (BluetoothA2dp) r7);     // Catch: Throwable -> L19
            if (A2dpProfile.access$100(this.this$0) != null) goto L9;
            A2dpProfile.access$202(this.this$0, false);     // Catch: Throwable -> L19
            monitor-exit(r8);     // Catch: Throwable -> L19
            return;
        L9:
            List<BluetoothDevice> r9 = A2dpProfile.access$100(this.this$0).getConnectedDevices();     // Catch: Throwable -> L19
        L11:
            if (r9.isEmpty() == true) goto L16;
            BluetoothDevice r1 = r9.remove(0);     // Catch: Throwable -> L19
            CachedBluetoothDevice r2 = A2dpProfile.access$300(this.this$0).findDevice(r1);     // Catch: Throwable -> L19
            if (r2 != null) goto L15;
            OLog.w(A2dpProfile.TAG, "A2dpProfile found new device: " + r1);     // Catch: Throwable -> L19
            r2 = A2dpProfile.access$300(this.this$0).addDevice(A2dpProfile.access$400(this.this$0), A2dpProfile.access$500(this.this$0), r1);     // Catch: Throwable -> L19
            r2.setAudioCodec(A2dpProfile.access$100(this.this$0).getCodecStatus(r1).getCodecConfig().getCodecType());     // Catch: Throwable -> L19
        L15:
            r2.onProfileStateChanged(this.this$0, 2);     // Catch: Throwable -> L19
            r2.setAudioCodec(A2dpProfile.access$100(this.this$0).getCodecStatus(r1).getCodecConfig().getCodecType());     // Catch: Throwable -> L19
            r2.refresh();     // Catch: Throwable -> L19
            goto L11
        L16:
            A2dpProfile.access$202(this.this$0, true);     // Catch: Throwable -> L19
            monitor-exit(r8);     // Catch: Throwable -> L19
            return;
        L19:
            th = move-exception;
            throw th;
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r2) {
            OLog.d(A2dpProfile.TAG, "Bluetooth service disconnected");
            A2dpProfile.access$202(this.this$0, false);
        }
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getDrawableResource(BluetoothClass r1) {
        return R.drawable.settings_oicon_selector_ic_bt_headphones_a2dp;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getNameResource(BluetoothDevice r1) {
        return R.string.bluetooth_profile_a2dp;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getOrdinal() {
        return 1;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean isAutoConnectable() {
        return true;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean isConnectable() {
        return true;
    }

    public String toString() {
        return NAME;
    }

    static /* synthetic */ Object access$000(A2dpProfile r0) {
        return r0.mLock;
    }

    static /* synthetic */ BluetoothA2dp access$100(A2dpProfile r0) {
        return r0.mService;
    }

    static /* synthetic */ BluetoothA2dp access$102(A2dpProfile r0, BluetoothA2dp r1) {
        r0.mService = r1;
        return r1;
    }

    static /* synthetic */ boolean access$202(A2dpProfile r0, boolean r1) {
        r0.mIsProfileReady = r1;
        return r1;
    }

    static /* synthetic */ CachedBluetoothDeviceManager access$300(A2dpProfile r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ LocalBluetoothAdapter access$400(A2dpProfile r0) {
        return r0.mLocalAdapter;
    }

    static /* synthetic */ LocalBluetoothProfileManager access$500(A2dpProfile r0) {
        return r0.mProfileManager;
    }

    static {
        SINK_UUIDS = new ParcelUuid[]{AdaptConstants.A2DP_SINK, AdaptConstants.ADV_AUDIO_DIST};
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean isProfileReady() {
        return this.mIsProfileReady;
    }

    A2dpProfile(Context r2, LocalBluetoothAdapter r3, CachedBluetoothDeviceManager r4, LocalBluetoothProfileManager r5) {
        this.mLock = new Object();
        BroadcastReceiver r0 = new AnonymousClass1(this);
        this.mCodecReceiver = r0;
        this.mContext = r2;
        this.mLocalAdapter = r3;
        this.mDeviceManager = r4;
        this.mProfileManager = r5;
        r3.getProfileProxy(r2, new A2dpServiceListener(this, null), 2);
        IntentFilter r6 = new IntentFilter("android.bluetooth.a2dp.profile.action.CODEC_CONFIG_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, r0, r6, 2);
    }

    public List<BluetoothDevice> getConnectedDevices() {
        BluetoothA2dp r1 = this.mService;
        if (r1 != null) goto L7;
        return new ArrayList(0);
    L7:
        return r1.getDevicesMatchingConnectionStates(new int[]{2, 1, 3});
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean connect(BluetoothDevice r1) {
        BluetoothA2dp r0 = this.mService;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.connect(r1);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean disconnect(BluetoothDevice r3) {
        BluetoothA2dp r0 = this.mService;
        if (r0 != null) goto L7;
        return false;
    L7:
        if (r0.getPriority(r3) <= 100) goto L10;
        this.mService.setPriority(r3, 100);
    L10:
        return this.mService.disconnect(r3);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getConnectionStatus(BluetoothDevice r1) {
        BluetoothA2dp r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionState(r1);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean isPreferred(BluetoothDevice r2) {
        BluetoothA2dp r1 = this.mService;
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.getPriority(r2) <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getPreferred(BluetoothDevice r1) {
        BluetoothA2dp r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getPriority(r1);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public void setPreferred(BluetoothDevice r2, boolean r3) {
        BluetoothA2dp r0 = this.mService;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 == true) goto L7;
        r0.setPriority(r2, 0);
        return;
    L7:
        if (r0.getPriority(r2) >= 100) goto L11;
        this.mService.setPriority(r2, 100);
        return;
    }

    boolean isA2dpPlaying() {
        BluetoothA2dp r0 = this.mService;
        if (r0 != null) goto L5;
        return false;
    L5:
        List<BluetoothDevice> r1 = r0.getConnectedDevices();
        if (r1.isEmpty() == false) goto L8;
    L11:
        return false;
    L8:
        if (this.mService.isA2dpPlaying(r1.get(0)) == false) goto L11;
        return true;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getSummaryResourceForDevice(BluetoothDevice r1) {
        int r0 = getConnectionStatus(r1);
        if (r0 != 0) goto L5;
        return R.string.bluetooth_a2dp_profile_summary_use_for;
    L5:
        if (r0 != 2) goto L7;
        return R.string.bluetooth_a2dp_profile_summary_connected;
    L7:
        return Utils.getConnectionStateSummary(r0);
    }

    protected void finalize() {
        OLog.d(TAG, "finalize()");
        Object r0 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r0);     // Catch: Throwable -> L20
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L6:
        if (this.mService != null) goto L28;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L17
        super.finalize();     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L28:
        BluetoothAdapter.getDefaultAdapter().closeProfileProxy(2, this.mService);     // Catch: Throwable -> L9
        this.mService = null;     // Catch: Throwable -> L9
        this.mContext.unregisterReceiver(this.mCodecReceiver);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        OLog.w(TAG, "Error cleaning up A2DP proxy", th);     // Catch: Throwable -> L17
    L20:
        th = move-exception;
        super.finalize();     // Catch: Throwable -> L23
    L25:
        throw th;
    L23:
        th = move-exception;
        th.printStackTrace();
        goto L25
    }

    boolean supportsHighQualityAudio(BluetoothDevice r4) {
        if (this.mService == null) goto L8;
        OLog.d(TAG, "supportsHighQualityAudio service:" + this.mService + " device:" + r4 + "");
        if (this.mService.isOptionalCodecsSupported(r4) == 1) goto L7;
        return false;
    L7:
        return true;
    L8:
        return false;
    }

    boolean isHighQualityAudioEnabled(BluetoothDevice r3) {
        OLog.d(TAG, "isHighQualityAudioEnabled service:" + this.mService + " device:" + r3 + "");
        BluetoothA2dp r0 = this.mService;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getCodecStatus(r3) == null) goto L7;
        BluetoothCodecConfig r2 = this.mService.getCodecStatus(r3).getCodecConfig();
    L8:
        if (r2 == null) goto L13;
        OLog.d(TAG, "isHighQualityAudioEnabled codecConfig:" + r2.getCodecType());
        return !r2.isMandatoryCodec();
    L13:
        return false;
    L7:
        r2 = null;
        goto L8
    }

    public void setHighQualityAudioEnabled(BluetoothDevice r3, boolean r4) {
        OLog.d(TAG, "setHighQualityAudioEnabled  device:" + r3 + " enabled:" + r4);
        this.mService.setOptionalCodecsEnabled(r3, r4 ? 1 : 0);
        if (getConnectionStatus(r3) == 2) goto L5;
        return;
    L5:
        if (r4 == false) goto L7;
        this.mService.enableOptionalCodecs(r3);
        return;
    L7:
        this.mService.disableOptionalCodecs(r3);
    }

    public String getHighQualityAudioOptionLabel(BluetoothDevice r2) {
        if (this.mService.getCodecStatus(r2) != null) goto L5;
        return null;
    L5:
        return getHighQualityAudioOptionLabel(this.mService.getCodecStatus(r2).getCodecConfig().getCodecType());
    }

    public static String getHighQualityAudioOptionLabel(int r3) {
        OLog.d(TAG, "getHighQualityAudioOptionLabel codec:" + r3);
        switch(r3) {
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        int r4 = -1;
    L14:
        if (r4 != (-1)) goto L16;
        return null;
    L16:
        return ResourceUtils.getResources().getStringArray(R.array.bluetooth_a2dp_codec_labels)[r4 - 1];
    L5:
        r4 = 9;
        goto L14
    L6:
        r4 = 8;
        goto L14
    L7:
        r4 = 7;
        goto L14
    L8:
        r4 = 6;
        goto L14
    L9:
        r4 = 5;
        goto L14
    L10:
        r4 = 4;
        goto L14
    L11:
        r4 = 3;
        goto L14
    L12:
        r4 = 2;
        goto L14
    L13:
        r4 = 1;
        goto L14
    }
}
