package com.android.settingslib.media;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.media.AudioDeviceAttributes;
import android.media.AudioManager;
import android.media.RoutingSessionInfo;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.settingslib.bluetooth.A2dpProfile;
import com.android.settingslib.bluetooth.BluetoothCallback;
import com.android.settingslib.bluetooth.CachedBluetoothDevice;
import com.android.settingslib.bluetooth.CachedBluetoothDeviceManager;
import com.android.settingslib.bluetooth.HearingAidProfile;
import com.android.settingslib.bluetooth.LeAudioProfile;
import com.android.settingslib.bluetooth.LocalBluetoothManager;
import com.android.settingslib.bluetooth.LocalBluetoothProfile;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class LocalMediaManager implements BluetoothCallback {
    private static final int MAX_DISCONNECTED_DEVICE_NUM = 5;
    private static final String TAG = "LocalMediaManager";
    AudioManager mAudioManager;
    BluetoothAdapter mBluetoothAdapter;
    private final Collection<DeviceCallback> mCallbacks;
    private Context mContext;
    MediaDevice mCurrentConnectedDevice;
    DeviceAttributeChangeCallback mDeviceAttributeChangeCallback;
    List<MediaDevice> mDisconnectedMediaDevices;
    private InfoMediaManager mInfoMediaManager;
    private LocalBluetoothManager mLocalBluetoothManager;
    final MediaDeviceCallback mMediaDeviceCallback;
    List<MediaDevice> mMediaDevices;
    private final Object mMediaDevicesLock;
    private MediaDevice mOnTransferBluetoothDevice;
    private String mPackageName;

    class DeviceAttributeChangeCallback implements CachedBluetoothDevice.Callback {
        final /* synthetic */ LocalMediaManager this$0;

        DeviceAttributeChangeCallback(LocalMediaManager r1) {
            this.this$0 = r1;
        }

        @Override // com.android.settingslib.bluetooth.CachedBluetoothDevice.Callback
        public void onDeviceAttributesChanged() {
            if (LocalMediaManager.access$200(this.this$0) != null) goto L5;
        L9:
            this.this$0.dispatchDeviceAttributesChanged();
            return;
        L5:
            if (((BluetoothMediaDevice) LocalMediaManager.access$200(this.this$0)).getCachedDevice().isBusy() == true) goto L9;
            if (LocalMediaManager.access$200(this.this$0).isConnected() == true) goto L9;
            LocalMediaManager.access$200(this.this$0).setState(3);
            LocalMediaManager.access$202(this.this$0, null);
            this.this$0.dispatchOnRequestFailed(0);
            goto L9
        }
    }

    public interface DeviceCallback {
        default void onAboutToConnectDeviceAdded(String r1, String r2, Drawable r3) {
        }

        default void onAboutToConnectDeviceRemoved() {
        }

        default void onDeviceAttributesChanged() {
        }

        default void onDeviceListUpdate(List<MediaDevice> r1) {
        }

        default void onRequestFailed(int r1) {
        }

        default void onSelectedDeviceStateChanged(MediaDevice r1, int r2) {
        }
    }

    class MediaDeviceCallback implements InfoMediaManager.MediaDeviceCallback {
        final /* synthetic */ LocalMediaManager this$0;

        MediaDeviceCallback(LocalMediaManager r1) {
            this.this$0 = r1;
        }

        @Override // com.android.settingslib.media.InfoMediaManager.MediaDeviceCallback
        public void onDeviceListAdded(List<MediaDevice> r4) {
            Object r0 = LocalMediaManager.access$000(this.this$0);
            monitor-enter(r0);
            this.this$0.mMediaDevices.clear();     // Catch: Throwable -> L30
            this.this$0.mMediaDevices.addAll(r4);     // Catch: Throwable -> L30
            Iterator<MediaDevice> r5 = r4.iterator();     // Catch: Throwable -> L30
        L6:
            if (r5.hasNext() == false) goto L19;
            int r1 = r5.next().getDeviceType();     // Catch: Throwable -> L30
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L14;
            if (r1 != 1) goto L6;
        L14:
            if (isTv() == false) goto L16;
            this.this$0.mMediaDevices.addAll(buildDisconnectedBluetoothDevice());     // Catch: Throwable -> L30
            goto L19
        L16:
            MediaDevice r6 = getMutingExpectedDevice();     // Catch: Throwable -> L30
            if (r6 == null) goto L19;
            this.this$0.mMediaDevices.add(r6);     // Catch: Throwable -> L30
        L19:
            monitor-exit(r0);     // Catch: Throwable -> L30
            MediaDevice r7 = LocalMediaManager.access$100(this.this$0).getCurrentConnectedDevice();
            LocalMediaManager r2 = this.this$0;
            if (r7 != null) goto L24;
            r7 = r2.updateCurrentConnectedDevice();
        L24:
            r2.mCurrentConnectedDevice = r7;
            this.this$0.dispatchDeviceListUpdate();
            if (LocalMediaManager.access$200(this.this$0) != null) goto L27;
            return;
        L27:
            if (LocalMediaManager.access$200(this.this$0).isConnected() == false) goto L41;
            LocalMediaManager r8 = this.this$0;
            r8.connectDevice(LocalMediaManager.access$200(r8));
            LocalMediaManager.access$200(this.this$0).setState(0);
            LocalMediaManager r9 = this.this$0;
            r9.dispatchSelectedDeviceStateChanged(LocalMediaManager.access$200(r9), 0);
            LocalMediaManager.access$202(this.this$0, null);
            return;
        L41:
            return;
        L30:
            th = move-exception;
            throw th;
        }

        private boolean isTv() {
            PackageManager r1 = LocalMediaManager.access$300(this.this$0).getPackageManager();
            if (r1.hasSystemFeature("android.hardware.type.television") == false) goto L5;
        L8:
            return true;
        L5:
            if (r1.hasSystemFeature("android.software.leanback") == true) goto L8;
            return false;
        }

        private MediaDevice getMutingExpectedDevice() {
            if (this.this$0.mBluetoothAdapter != null) goto L5;
        L16:
            return null;
        L5:
            if (this.this$0.mAudioManager.getMutingExpectedDevice() == null) goto L16;
            List r0 = this.this$0.mBluetoothAdapter.getMostRecentlyConnectedDevices();
            CachedBluetoothDeviceManager r2 = LocalMediaManager.access$400(this.this$0).getCachedDeviceManager();
            Iterator r1 = r0.iterator();
        L9:
            if (r1.hasNext() == false) goto L16;
            CachedBluetoothDevice r3 = r2.findDevice((BluetoothDevice) r1.next());
            if (isBondedMediaDevice(r3) == false) goto L9;
            if (isMutingExpectedDevice(r3) == false) goto L9;
            return new BluetoothMediaDevice(LocalMediaManager.access$300(this.this$0), r3, null, null);
        }

        private boolean isMutingExpectedDevice(CachedBluetoothDevice r1) {
            AudioDeviceAttributes r0 = this.this$0.mAudioManager.getMutingExpectedDevice();
            if (r0 == null) goto L8;
            if (r1 != null) goto L7;
            return false;
        L7:
            return r1.getAddress().equals(r0.getAddress());
        L8:
            return false;
        }

        private List<MediaDevice> buildDisconnectedBluetoothDevice() {
            if (this.this$0.mBluetoothAdapter != null) goto L6;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(LocalMediaManager.TAG, "buildDisconnectedBluetoothDevice() BluetoothAdapter is null");
            return new ArrayList();
        L6:
            List r0 = this.this$0.mBluetoothAdapter.getMostRecentlyConnectedDevices();
            CachedBluetoothDeviceManager r1 = LocalMediaManager.access$400(this.this$0).getCachedDeviceManager();
            ArrayList r2 = new ArrayList();
            Iterator r3 = r0.iterator();
            int r4 = 0;
        L8:
            if (r3.hasNext() == false) goto L19;
            CachedBluetoothDevice r5 = r1.findDevice((BluetoothDevice) r3.next());
            if (r5 == null) goto L8;
            if (r5.getBondState() != 12) goto L8;
            if (r5.isConnected() == true) goto L8;
            if (isMediaDevice(r5) == false) goto L8;
            r4 = r4 + 1;
            r2.add(r5);
            if (r4 < 5) goto L8;
        L19:
            LocalMediaManager.access$500(this.this$0);
            this.this$0.mDisconnectedMediaDevices.clear();
            Iterator r6 = r2.iterator();
        L21:
            if (r6.hasNext() == false) goto L26;
            CachedBluetoothDevice r7 = (CachedBluetoothDevice) r6.next();
            BluetoothMediaDevice r8 = new BluetoothMediaDevice(LocalMediaManager.access$300(this.this$0), r7, null, null);
            if (this.this$0.mMediaDevices.contains(r8) == true) goto L21;
            r7.registerCallback(this.this$0.mDeviceAttributeChangeCallback);
            this.this$0.mDisconnectedMediaDevices.add(r8);
            goto L21
        L26:
            return new ArrayList(this.this$0.mDisconnectedMediaDevices);
        }

        private boolean isBondedMediaDevice(CachedBluetoothDevice r3) {
            if (r3 != null) goto L4;
        L10:
            return false;
        L4:
            if (r3.getBondState() != 12) goto L10;
            if (r3.isConnected() == true) goto L10;
            if (isMediaDevice(r3) == false) goto L10;
            return true;
        }

        private boolean isMediaDevice(CachedBluetoothDevice r2) {
            Iterator<LocalBluetoothProfile> r1 = r2.getConnectableProfiles().iterator();
        L4:
            if (r1.hasNext() == false) goto L13;
            LocalBluetoothProfile r3 = r1.next();
            if ((r3 instanceof A2dpProfile) == true) goto L11;
            if ((r3 instanceof HearingAidProfile) == true) goto L20;
            if ((r3 instanceof LeAudioProfile) == false) goto L4;
            return true;
        L20:
            return true;
        L11:
            return true;
        L13:
            return false;
        }

        @Override // com.android.settingslib.media.InfoMediaManager.MediaDeviceCallback
        public void onDeviceListRemoved(List<MediaDevice> r3) {
            Object r0 = LocalMediaManager.access$000(this.this$0);
            monitor-enter(r0);
            this.this$0.mMediaDevices.removeAll(r3);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            this.this$0.dispatchDeviceListUpdate();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.android.settingslib.media.InfoMediaManager.MediaDeviceCallback
        public void onConnectedDeviceChanged(String r2) {
            MediaDevice r3 = this.this$0.getMediaDeviceById(r2);
            if (r3 != null) goto L6;
            r3 = this.this$0.updateCurrentConnectedDevice();
        L6:
            this.this$0.mCurrentConnectedDevice = r3;
            if (r3 == null) goto L10;
            r3.setState(0);
            LocalMediaManager r1 = this.this$0;
            r1.dispatchSelectedDeviceStateChanged(r1.mCurrentConnectedDevice, 0);
            return;
        }

        @Override // com.android.settingslib.media.InfoMediaManager.MediaDeviceCallback
        public void onRequestFailed(int r6) {
            Object r0 = LocalMediaManager.access$000(this.this$0);
            monitor-enter(r0);
            Iterator<MediaDevice> r1 = this.this$0.mMediaDevices.iterator();     // Catch: Throwable -> L13
        L6:
            if (r1.hasNext() == false) goto L10;
            MediaDevice r2 = r1.next();     // Catch: Throwable -> L13
            if (r2.getState() != 1) goto L6;
            r2.setState(3);     // Catch: Throwable -> L13
            goto L6
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L13
            this.this$0.dispatchOnRequestFailed(r6);
            return;
        L13:
            th = move-exception;
            throw th;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaDeviceState {
        public static final int STATE_CONNECTED = 0;
        public static final int STATE_CONNECTING = 1;
        public static final int STATE_CONNECTING_FAILED = 3;
        public static final int STATE_DISCONNECTED = 2;
        public static final int STATE_GROUPING = 5;
        public static final int STATE_SELECTED = 4;
    }

    static /* synthetic */ Object access$000(LocalMediaManager r0) {
        return r0.mMediaDevicesLock;
    }

    static /* synthetic */ InfoMediaManager access$100(LocalMediaManager r0) {
        return r0.mInfoMediaManager;
    }

    static /* synthetic */ MediaDevice access$200(LocalMediaManager r0) {
        return r0.mOnTransferBluetoothDevice;
    }

    static /* synthetic */ MediaDevice access$202(LocalMediaManager r0, MediaDevice r1) {
        r0.mOnTransferBluetoothDevice = r1;
        return r1;
    }

    static /* synthetic */ Context access$300(LocalMediaManager r0) {
        return r0.mContext;
    }

    static /* synthetic */ LocalBluetoothManager access$400(LocalMediaManager r0) {
        return r0.mLocalBluetoothManager;
    }

    static /* synthetic */ void access$500(LocalMediaManager r0) {
        r0.unRegisterDeviceAttributeChangeCallback();
    }

    public void registerCallback(DeviceCallback r3) {
        boolean r0 = this.mCallbacks.isEmpty();
        if (this.mCallbacks.contains(r3) == true) goto L8;
        this.mCallbacks.add(r3);
        if (r0 == false) goto L9;
        this.mInfoMediaManager.registerCallback(this.mMediaDeviceCallback);
        return;
    L9:
        return;
    }

    public void unregisterCallback(DeviceCallback r2) {
        if (this.mCallbacks.remove(r2) == true) goto L5;
        return;
    L5:
        if (this.mCallbacks.isEmpty() == false) goto L9;
        this.mInfoMediaManager.unregisterCallback(this.mMediaDeviceCallback);
        unRegisterDeviceAttributeChangeCallback();
        return;
    }

    public LocalMediaManager(Context r3, String r4) {
        this.mCallbacks = new CopyOnWriteArrayList();
        this.mMediaDevicesLock = new Object();
        this.mMediaDeviceCallback = new MediaDeviceCallback(this);
        this.mMediaDevices = new CopyOnWriteArrayList();
        this.mDisconnectedMediaDevices = new CopyOnWriteArrayList();
        this.mDeviceAttributeChangeCallback = new DeviceAttributeChangeCallback(this);
        this.mContext = r3;
        this.mPackageName = r4;
        this.mLocalBluetoothManager = LocalBluetoothManager.getInstance(r3, null);
        this.mAudioManager = (AudioManager) r3.getSystemService(AudioManager.class);
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        LocalBluetoothManager r1 = this.mLocalBluetoothManager;
        if (r1 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Bluetooth is not supported on this device");
        return;
    L6:
        this.mInfoMediaManager = InfoMediaManager.createInstance(r3, r4, null, r1, null);
    }

    public LocalMediaManager(Context r2, LocalBluetoothManager r3, InfoMediaManager r4, String r5) {
        this.mCallbacks = new CopyOnWriteArrayList();
        this.mMediaDevicesLock = new Object();
        this.mMediaDeviceCallback = new MediaDeviceCallback(this);
        this.mMediaDevices = new CopyOnWriteArrayList();
        this.mDisconnectedMediaDevices = new CopyOnWriteArrayList();
        this.mDeviceAttributeChangeCallback = new DeviceAttributeChangeCallback(this);
        this.mContext = r2;
        this.mLocalBluetoothManager = r3;
        this.mInfoMediaManager = r4;
        this.mPackageName = r5;
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mAudioManager = (AudioManager) r2.getSystemService(AudioManager.class);
    }

    public boolean connectDevice(MediaDevice r7) {
        MediaDevice r0 = getMediaDeviceById(r7.getId());
        if (r0 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "connectDevice() connectDevice not in the list!");
        return false;
    L7:
        if ((r0 instanceof BluetoothMediaDevice) == false) goto L15;
        CachedBluetoothDevice r3 = ((BluetoothMediaDevice) r0).getCachedDevice();
        if (r3.isConnected() == true) goto L15;
        if (r3.isBusy() == true) goto L15;
        this.mOnTransferBluetoothDevice = r7;
        r0.setState(1);
        r3.connect();
        return true;
    L15:
        if (r0.equals(this.mCurrentConnectedDevice) == false) goto L18;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "connectDevice() this device is already connected! : " + r0.getName());
        return false;
    L18:
        r0.setState(1);
        this.mInfoMediaManager.connectToDevice(r0);
        return true;
    }

    void dispatchSelectedDeviceStateChanged(MediaDevice r2, int r3) {
        Iterator<DeviceCallback> r1 = getCallbacks().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onSelectedDeviceStateChanged(r2, r3);
        goto L4
    }

    public boolean isMediaSessionAvailableForVolumeControl() {
        return this.mInfoMediaManager.isRoutingSessionAvailableForVolumeControl();
    }

    public boolean isPreferenceRouteListingExist() {
        return this.mInfoMediaManager.preferRouteListingOrdering();
    }

    public ComponentName getLinkedItemComponentName() {
        return this.mInfoMediaManager.getLinkedItemComponentName();
    }

    public void startScan() {
        this.mInfoMediaManager.startScan();
    }

    void dispatchDeviceListUpdate() {
        ArrayList r0 = new ArrayList(this.mMediaDevices);
        Iterator<DeviceCallback> r2 = getCallbacks().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r2.next().onDeviceListUpdate(r0);
        goto L4
    }

    void dispatchDeviceAttributesChanged() {
        Iterator<DeviceCallback> r1 = getCallbacks().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onDeviceAttributesChanged();
        goto L4
    }

    void dispatchOnRequestFailed(int r2) {
        Iterator<DeviceCallback> r1 = getCallbacks().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onRequestFailed(r2);
        goto L4
    }

    public void dispatchAboutToConnectDeviceAdded(String r2, String r3, Drawable r4) {
        Iterator<DeviceCallback> r1 = getCallbacks().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onAboutToConnectDeviceAdded(r2, r3, r4);
        goto L4
    }

    public void dispatchAboutToConnectDeviceRemoved() {
        Iterator<DeviceCallback> r1 = getCallbacks().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onAboutToConnectDeviceRemoved();
        goto L4
    }

    public void stopScan() {
        this.mInfoMediaManager.stopScan();
    }

    public MediaDevice getMediaDeviceById(String r4) {
        Object r0 = this.mMediaDevicesLock;
        monitor-enter(r0);
        Iterator<MediaDevice> r3 = this.mMediaDevices.iterator();     // Catch: Throwable -> L14
    L6:
        if (r3.hasNext() == false) goto L11;
        MediaDevice r1 = r3.next();     // Catch: Throwable -> L14
        if (TextUtils.equals(r1.getId(), r4) == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r1;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L14
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(TAG, "getMediaDeviceById() failed to find device with id: " + r4);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    public MediaDevice getCurrentConnectedDevice() {
        return this.mCurrentConnectedDevice;
    }

    public boolean addDeviceToPlayMedia(MediaDevice r2) {
        r2.setState(5);
        return this.mInfoMediaManager.addDeviceToPlayMedia(r2);
    }

    public boolean removeDeviceFromPlayMedia(MediaDevice r2) {
        r2.setState(5);
        return this.mInfoMediaManager.removeDeviceFromPlayMedia(r2);
    }

    public List<MediaDevice> getSelectableMediaDevice() {
        return this.mInfoMediaManager.getSelectableMediaDevices();
    }

    public List<MediaDevice> getDeselectableMediaDevice() {
        return this.mInfoMediaManager.getDeselectableMediaDevices();
    }

    public boolean releaseSession() {
        return this.mInfoMediaManager.releaseSession();
    }

    public List<MediaDevice> getSelectedMediaDevice() {
        return this.mInfoMediaManager.getSelectedMediaDevices();
    }

    public void adjustDeviceVolume(MediaDevice r1, int r2) {
        this.mInfoMediaManager.adjustDeviceVolume(r1, r2);
    }

    public void adjustSessionVolume(String r2, int r3) {
        RoutingSessionInfo r0 = this.mInfoMediaManager.getRoutingSessionById(r2);
        if (r0 == null) goto L5;
        this.mInfoMediaManager.adjustSessionVolume(r0, r3);
        return;
    L5:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "adjustSessionVolume: Unable to find session: " + r2);
    }

    public void adjustSessionVolume(int r1) {
        this.mInfoMediaManager.adjustSessionVolume(r1);
    }

    public int getSessionVolumeMax() {
        return this.mInfoMediaManager.getSessionVolumeMax();
    }

    public int getSessionVolume() {
        return this.mInfoMediaManager.getSessionVolume();
    }

    public CharSequence getSessionName() {
        return this.mInfoMediaManager.getSessionName();
    }

    public List<RoutingSessionInfo> getRemoteRoutingSessions() {
        return this.mInfoMediaManager.getRemoteSessions();
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public boolean shouldEnableVolumeSeekBar(RoutingSessionInfo r1) {
        return this.mInfoMediaManager.shouldEnableVolumeSeekBar(r1);
    }

    MediaDevice updateCurrentConnectedDevice() {
        Object r0 = this.mMediaDevicesLock;
        monitor-enter(r0);
        Iterator<MediaDevice> r1 = this.mMediaDevices.iterator();     // Catch: Throwable -> L20
        MediaDevice r2 = null;
    L6:
        if (r1.hasNext() == false) goto L18;
        MediaDevice r3 = r1.next();     // Catch: Throwable -> L20
        if ((r3 instanceof BluetoothMediaDevice) == true) goto L10;
        if ((r3 instanceof PhoneMediaDevice) == false) goto L6;
        r2 = r3;
        goto L6
    L10:
        if (isActiveDevice(((BluetoothMediaDevice) r3).getCachedDevice()) == false) goto L6;
        if (r3.isConnected() == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L20
        return r3;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return r2;
    L20:
        th = move-exception;
        throw th;
    }

    private boolean isActiveDevice(CachedBluetoothDevice r5) {
        A2dpProfile r0 = this.mLocalBluetoothManager.getProfileManager().getA2dpProfile();
        if (r0 == null) goto L5;
        boolean r1 = r5.getDevice().equals(r0.getActiveDevice());
    L6:
        if (r1 == true) goto L10;
        HearingAidProfile r2 = this.mLocalBluetoothManager.getProfileManager().getHearingAidProfile();
        if (r2 == null) goto L10;
        boolean r3 = r2.getActiveDevices().contains(r5.getDevice());
    L11:
        if (r1 == true) goto L16;
        if (r3 == true) goto L16;
        LeAudioProfile r4 = this.mLocalBluetoothManager.getProfileManager().getLeAudioProfile();
        if (r4 == null) goto L16;
        boolean r6 = r4.getActiveDevices().contains(r5.getDevice());
    L17:
        if (r1 == true) goto L20;
        if (r3 == true) goto L20;
        if (r6 == true) goto L20;
        return false;
    L20:
        return true;
    L16:
        r6 = false;
    L10:
        r3 = false;
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    private Collection<DeviceCallback> getCallbacks() {
        return new CopyOnWriteArrayList(this.mCallbacks);
    }

    private void unRegisterDeviceAttributeChangeCallback() {
        Iterator<MediaDevice> r0 = this.mDisconnectedMediaDevices.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((BluetoothMediaDevice) r0.next()).getCachedDevice().unregisterCallback(this.mDeviceAttributeChangeCallback);
        goto L4
    }
}
