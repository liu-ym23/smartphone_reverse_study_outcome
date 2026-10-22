package com.android.settingslib.bluetooth;

import android.R;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothCodecConfig;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothUuid;
import android.content.Context;
import android.os.ParcelUuid;
import com.GlobalProxyLancet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class A2dpProfile implements LocalBluetoothProfile {
    static final String NAME = "A2DP";
    private static final int ORDINAL = 1;
    static final ParcelUuid[] SINK_UUIDS = null;
    private static final String TAG = "A2dpProfile";
    private static boolean V = true;
    private final BluetoothAdapter mBluetoothAdapter;
    private Context mContext;
    private final CachedBluetoothDeviceManager mDeviceManager;
    private boolean mIsProfileReady;
    private final LocalBluetoothProfileManager mProfileManager;
    private BluetoothA2dp mService;

    /* JADX INFO: renamed from: com.android.settingslib.bluetooth.A2dpProfile$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class A2dpServiceListener implements BluetoothProfile.ServiceListener {
        final /* synthetic */ A2dpProfile this$0;

        private A2dpServiceListener(A2dpProfile r1) {
            this.this$0 = r1;
        }

        /* synthetic */ A2dpServiceListener(A2dpProfile r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int r3, BluetoothProfile r4) {
            A2dpProfile.access$002(this.this$0, (BluetoothA2dp) r4);
            List<BluetoothDevice> r5 = A2dpProfile.access$000(this.this$0).getConnectedDevices();
        L4:
            if (r5.isEmpty() == true) goto L9;
            BluetoothDevice r6 = r5.remove(0);
            CachedBluetoothDevice r0 = A2dpProfile.access$100(this.this$0).findDevice(r6);
            if (r0 != null) goto L8;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(A2dpProfile.TAG, "A2dpProfile found new device: " + r6);
            r0 = A2dpProfile.access$100(this.this$0).addDevice(r6);
        L8:
            r0.onProfileStateChanged(this.this$0, 2);
            r0.refresh();
            goto L4
        L9:
            A2dpProfile.access$202(this.this$0, true);
            A2dpProfile.access$300(this.this$0).callServiceConnectedListeners();
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r2) {
            A2dpProfile.access$202(this.this$0, false);
            A2dpProfile.access$300(this.this$0).callServiceDisconnectedListeners();
        }
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean accessProfileEnabled() {
        return true;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getDrawableResource(BluetoothClass r1) {
        return R.drawable.ic_menu_block;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getOrdinal() {
        return 1;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getProfileId() {
        return 2;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isAutoConnectable() {
        return true;
    }

    public String toString() {
        return NAME;
    }

    static /* synthetic */ BluetoothA2dp access$000(A2dpProfile r0) {
        return r0.mService;
    }

    static /* synthetic */ BluetoothA2dp access$002(A2dpProfile r0, BluetoothA2dp r1) {
        r0.mService = r1;
        return r1;
    }

    static /* synthetic */ CachedBluetoothDeviceManager access$100(A2dpProfile r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ boolean access$202(A2dpProfile r0, boolean r1) {
        r0.mIsProfileReady = r1;
        return r1;
    }

    static /* synthetic */ LocalBluetoothProfileManager access$300(A2dpProfile r0) {
        return r0.mProfileManager;
    }

    static {
        SINK_UUIDS = new ParcelUuid[]{BluetoothUuid.A2DP_SINK, BluetoothUuid.ADV_AUDIO_DIST};
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isProfileReady() {
        return this.mIsProfileReady;
    }

    A2dpProfile(Context r2, CachedBluetoothDeviceManager r3, LocalBluetoothProfileManager r4) {
        this.mContext = r2;
        this.mDeviceManager = r3;
        this.mProfileManager = r4;
        BluetoothAdapter r5 = BluetoothAdapter.getDefaultAdapter();
        this.mBluetoothAdapter = r5;
        r5.getProfileProxy(r2, new A2dpServiceListener(this, null), 2);
    }

    public List<BluetoothDevice> getConnectedDevices() {
        return getDevicesByStates(new int[]{2, 1, 3});
    }

    public List<BluetoothDevice> getConnectableDevices() {
        return getDevicesByStates(new int[]{0, 2, 1, 3});
    }

    private List<BluetoothDevice> getDevicesByStates(int[] r1) {
        BluetoothA2dp r0 = this.mService;
        if (r0 != null) goto L7;
        return new ArrayList(0);
    L7:
        return r0.getDevicesMatchingConnectionStates(r1);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getConnectionStatus(BluetoothDevice r1) {
        BluetoothA2dp r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionState(r1);
    }

    public boolean setActiveDevice(BluetoothDevice r2) {
        BluetoothAdapter r1 = this.mBluetoothAdapter;
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r2 != null) goto L8;
        return r1.removeActiveDevice(0);
    L8:
        return r1.setActiveDevice(r2, 0);
    }

    public BluetoothDevice getActiveDevice() {
        BluetoothAdapter r2 = this.mBluetoothAdapter;
        if (r2 != null) goto L5;
        return null;
    L5:
        List r3 = r2.getActiveDevices(2);
        if (r3.size() > 0) goto L8;
        return null;
    L8:
        return (BluetoothDevice) r3.get(0);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isEnabled(BluetoothDevice r2) {
        BluetoothA2dp r1 = this.mService;
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.getConnectionPolicy(r2) <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getConnectionPolicy(BluetoothDevice r1) {
        BluetoothA2dp r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionPolicy(r1);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean setEnabled(BluetoothDevice r3, boolean r4) {
        BluetoothA2dp r0 = this.mService;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r4 == false) goto L10;
        if (r0.getConnectionPolicy(r3) < 100) goto L12;
        return false;
    L12:
        return this.mService.setConnectionPolicy(r3, 100);
    L10:
        return r0.setConnectionPolicy(r3, 0);
    }

    boolean isA2dpPlaying() {
        BluetoothA2dp r0 = this.mService;
        if (r0 != null) goto L5;
        return false;
    L5:
        Iterator<BluetoothDevice> r1 = r0.getConnectedDevices().iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        BluetoothDevice r2 = r1.next();
        if (this.mService.isA2dpPlaying(r2) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public boolean supportsHighQualityAudio(BluetoothDevice r4) {
        if (V == false) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, " execute supportsHighQualityAudio()");
    L6:
        if (this.mService == null) goto L8;
        if (r4 != null) goto L14;
        r4 = getActiveDevice();
    L14:
        if (r4 != null) goto L17;
        return false;
    L17:
        if (this.mService.isOptionalCodecsSupported(r4) == 1) goto L19;
        return false;
    L19:
        return true;
    L8:
        if (V == false) goto L10;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "mService is null.");
    L10:
        return false;
    }

    public boolean isHighQualityAudioEnabled(BluetoothDevice r5) {
        if (V == false) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, " execute isHighQualityAudioEnabled()");
    L6:
        if (this.mService == null) goto L8;
        if (r5 != null) goto L14;
        r5 = getActiveDevice();
    L14:
        if (r5 != null) goto L16;
        return false;
    L16:
        int r0 = this.mService.isOptionalCodecsEnabled(r5);
        if (r0 == (-1)) goto L22;
        if (r0 == 1) goto L20;
        return false;
    L20:
        return true;
    L22:
        if (getConnectionStatus(r5) == 2) goto L27;
        if (supportsHighQualityAudio(r5) == false) goto L27;
        return true;
    L27:
        if (this.mService.getCodecStatus(r5) == null) goto L29;
        BluetoothCodecConfig r4 = this.mService.getCodecStatus(r5).getCodecConfig();
    L30:
        if (r4 != null) goto L32;
        return false;
    L32:
        return !r4.isMandatoryCodec();
    L29:
        r4 = null;
        goto L30
    L8:
        if (V == false) goto L10;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "mService is null.");
    L10:
        return false;
    }

    public boolean isMandatoryCodec(BluetoothDevice r4) {
        if (V == false) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, " execute isMandatoryCodec()");
    L6:
        if (this.mService == null) goto L8;
        if (r4 != null) goto L14;
        r4 = getActiveDevice();
    L14:
        if (r4 != null) goto L17;
        return false;
    L17:
        if (this.mService.getCodecStatus(r4) == null) goto L19;
        BluetoothCodecConfig r3 = this.mService.getCodecStatus(r4).getCodecConfig();
    L20:
        if (r3 != null) goto L22;
        return false;
    L22:
        return r3.isMandatoryCodec();
    L19:
        r3 = null;
        goto L20
    L8:
        if (V == false) goto L10;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "mService is null.");
    L10:
        return false;
    }

    public void setHighQualityAudioEnabled(BluetoothDevice r3, boolean r4) {
        if (V == false) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, " execute setHighQualityAudioEnabled()");
    L6:
        if (this.mService == null) goto L8;
        if (r3 != null) goto L14;
        r3 = getActiveDevice();
    L14:
        if (r3 != null) goto L16;
        return;
    L16:
        this.mService.setOptionalCodecsEnabled(r3, r4 ? 1 : 0);
        if (getConnectionStatus(r3) == 2) goto L19;
        return;
    L19:
        if (r4 == false) goto L21;
        this.mService.enableOptionalCodecs(r3);
        return;
    L21:
        this.mService.disableOptionalCodecs(r3);
        return;
    L8:
        if (V == false) goto L23;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "mService is null.");
        return;
    }

    public String getHighQualityAudioOptionLabel(BluetoothDevice r7) {
        if (V == false) goto L5;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, " execute getHighQualityAudioOptionLabel()");
    L5:
        if (r7 == null) goto L7;
        BluetoothDevice r0 = r7;
    L8:
        int r1 = com.android.settingslib.R.string.bluetooth_profile_a2dp_high_quality_unknown_codec;
        if (r0 == null) goto L49;
        if (supportsHighQualityAudio(r7) == false) goto L49;
        byte r2 = 2;
        if (getConnectionStatus(r7) != 2) goto L49;
        BluetoothA2dp r3 = this.mService;
        BluetoothCodecConfig r4 = null;
        if (r3 != null) goto L18;
    L20:
        List<BluetoothCodecConfig> r8 = null;
    L22:
        if (r8 != null) goto L24;
    L27:
        if (r4 != null) goto L29;
    L32:
        int r9 = 1000000;
    L33:
        switch(r9) {
            case 0: goto L42;
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L38;
            case 6: goto L37;
            case 7: goto L36;
            case 8: goto L34;
            case 9: goto L35;
            default: goto L34;
        };
    L34:
        r2 = -1;
        goto L43
    L35:
        r2 = 9;
        goto L43
    L36:
        r2 = 8;
        goto L43
    L37:
        r2 = 7;
        goto L43
    L38:
        r2 = 6;
        goto L43
    L39:
        r2 = 5;
        goto L43
    L40:
        r2 = 4;
        goto L43
    L41:
        r2 = 3;
        goto L43
    L42:
        r2 = 1;
    L43:
        if (r2 >= 0) goto L47;
        return this.mContext.getString(r1);
    L47:
        return this.mContext.getString(com.android.settingslib.R.string.bluetooth_profile_a2dp_high_quality, new Object[]{this.mContext.getResources().getStringArray(com.android.settingslib.R.array.bluetooth_a2dp_codec_titles)[r2]});
    L29:
        if (r4.isMandatoryCodec() == true) goto L32;
        r9 = r4.getCodecType();
        goto L33
    L24:
        if (r8.size() < 1) goto L27;
        r4 = r8.get(0);
        goto L27
    L18:
        if (r3.getCodecStatus(r7) == null) goto L20;
        r8 = this.mService.getCodecStatus(r7).getCodecsSelectableCapabilities();
        Collections.sort(r8, new A2dpProfile$$ExternalSyntheticLambda0());
    L49:
        return this.mContext.getString(r1);
    L7:
        r0 = getActiveDevice();
        goto L8
    }

    static /* synthetic */ int lambda$getHighQualityAudioOptionLabel$0(BluetoothCodecConfig r0, BluetoothCodecConfig r1) {
        return r1.getCodecPriority() - r0.getCodecPriority();
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getNameResource(BluetoothDevice r1) {
        return com.android.settingslib.R.string.bluetooth_profile_a2dp;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getSummaryResourceForDevice(BluetoothDevice r1) {
        int r0 = getConnectionStatus(r1);
        if (r0 == 0) goto L11;
        if (r0 == 2) goto L9;
        return BluetoothUtils.getConnectionStateSummary(r0);
    L9:
        return com.android.settingslib.R.string.bluetooth_a2dp_profile_summary_connected;
    L11:
        return com.android.settingslib.R.string.bluetooth_a2dp_profile_summary_use_for;
    }

    protected void finalize() {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "finalize()");
        if (this.mService == null) goto L11;
        BluetoothAdapter.getDefaultAdapter().closeProfileProxy(2, this.mService);     // Catch: Throwable -> L6
        this.mService = null;     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Error cleaning up A2DP proxy", th);
        return;
    }
}
