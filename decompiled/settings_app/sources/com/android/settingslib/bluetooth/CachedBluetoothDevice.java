package com.android.settingslib.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothUuid;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelUuid;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.LruCache;
import android.util.Pair;
import com.GlobalProxyLancet;
import com.android.internal.util.ArrayUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settingslib.R;
import com.android.settingslib.Utils;
import com.android.settingslib.flags.Flags;
import com.android.settingslib.utils.ThreadUtils;
import com.android.settingslib.widget.AdaptiveOutlineDrawable;
import com.google.common.util.concurrent.Futures;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.stream.Stream;
import obric.tablet.widget.BytedanceJustifyTextView;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes.dex */
public class CachedBluetoothDevice implements Comparable<CachedBluetoothDevice> {
    private static final int DEFAULT_LOW_BATTERY_THRESHOLD = 20;
    private static final long MAX_HEARING_AIDS_DELAY_FOR_AUTO_CONNECT = 15000;
    private static final long MAX_HOGP_DELAY_FOR_AUTO_CONNECT = 30000;
    private static final long MAX_LEAUDIO_DELAY_FOR_AUTO_CONNECT = 30000;
    private static final long MAX_MEDIA_PROFILE_CONNECT_DELAY = 60000;
    private static final long MAX_UUID_DELAY_FOR_AUTO_CONNECT = 5000;
    static final int PRIVATE_ADDR = 101;
    private static final int SUMMARY_NO_COLOR_FOR_LOW_BATTERY = 0;
    private static final String TAG = "CachedBluetoothDevice";
    private final int BREDR;
    private final int GROUPID_END;
    private final int GROUPID_START;
    private final int UNKNOWN;
    private LocalBluetoothManager mBluetoothManager;
    private Timestamp mBondTimestamp;
    private final Map<Callback, Executor> mCallbackExecutorMap;
    private final Collection<Callback> mCallbacks;
    private long mConnectAttempted;
    private final Context mContext;
    BluetoothDevice mDevice;
    LruCache<String, BitmapDrawable> mDrawableCache;
    private int mGroupId;
    private final Handler mHandler;
    private HearingAidInfo mHearingAidInfo;
    private boolean mIsA2dpProfileConnectedFail;
    private boolean mIsActiveDeviceA2dp;
    private boolean mIsActiveDeviceHeadset;
    private boolean mIsActiveDeviceHearingAid;
    private boolean mIsActiveDeviceLeAudio;
    boolean mIsCoordinatedSetMember;
    private boolean mIsGroupDevice;
    private boolean mIsHeadsetProfileConnectedFail;
    private boolean mIsHearingAidProfileConnectedFail;
    private boolean mIsIgnore;
    private boolean mIsLeAudioEnabled;
    private boolean mIsLeAudioProfileConnectedFail;
    boolean mJustDiscovered;
    private final BluetoothAdapter mLocalAdapter;
    private boolean mLocalNapRoleConnected;
    private Set<CachedBluetoothDevice> mMemberDevices;
    private final Object mProfileLock;
    private final LocalBluetoothProfileManager mProfileManager;
    private final Collection<LocalBluetoothProfile> mProfiles;
    private int mQGroupId;
    private final Collection<LocalBluetoothProfile> mRemovedProfiles;
    short mRssi;
    private CachedBluetoothDevice mSubDevice;
    public int mTwspBatteryLevel;
    public int mTwspBatteryState;
    private int mType;
    private boolean mUnpairing;

    public interface Callback {
        void onDeviceAttributesChanged();
    }

    public static /* synthetic */ boolean $r8$lambda$vs1ZRTnIuVlo9uxaFII77NjREtk(Object r0) {
        return Objects.nonNull(r0);
    }

    private boolean isTwsBatteryAvailable(int r1, int r2) {
        if (r1 < 0) goto L5;
        if (r2 < 0) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ boolean lambda$getMinBatteryLevelWithMemberDevices$3(int r1) {
        if (r1 <= (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ boolean access$002(CachedBluetoothDevice r0, boolean r1) {
        r0.mIsA2dpProfileConnectedFail = r1;
        return r1;
    }

    static /* synthetic */ boolean access$102(CachedBluetoothDevice r0, boolean r1) {
        r0.mIsHeadsetProfileConnectedFail = r1;
        return r1;
    }

    static /* synthetic */ boolean access$202(CachedBluetoothDevice r0, boolean r1) {
        r0.mIsHearingAidProfileConnectedFail = r1;
        return r1;
    }

    static /* synthetic */ boolean access$302(CachedBluetoothDevice r0, boolean r1) {
        r0.mIsLeAudioProfileConnectedFail = r1;
        return r1;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CachedBluetoothDevice r1) {
        return compareTo2(r1);
    }

    CachedBluetoothDevice(Context r5, LocalBluetoothProfileManager r6, BluetoothDevice r7) {
        this.mProfileLock = new Object();
        this.mProfiles = new CopyOnWriteArrayList();
        this.mRemovedProfiles = new CopyOnWriteArrayList();
        this.mIsCoordinatedSetMember = false;
        this.mCallbacks = new CopyOnWriteArrayList();
        this.mCallbackExecutorMap = new ConcurrentHashMap();
        this.mIsActiveDeviceA2dp = false;
        this.mIsActiveDeviceHeadset = false;
        this.mIsActiveDeviceHearingAid = false;
        this.mIsActiveDeviceLeAudio = false;
        this.mIsA2dpProfileConnectedFail = false;
        this.mIsHeadsetProfileConnectedFail = false;
        this.mIsHearingAidProfileConnectedFail = false;
        this.mIsLeAudioProfileConnectedFail = false;
        this.mMemberDevices = new HashSet();
        this.mIsGroupDevice = false;
        this.mIsIgnore = false;
        this.UNKNOWN = -1;
        this.BREDR = 100;
        this.GROUPID_START = 0;
        this.GROUPID_END = 15;
        this.mType = -1;
        this.mIsLeAudioEnabled = false;
        final Looper r3 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r3);
        this.mContext = r5;
        this.mLocalAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mProfileManager = r6;
        this.mDevice = r7;
        fillData();
        this.mGroupId = -1;
        this.mQGroupId = -1;
        initDrawableCache();
        this.mTwspBatteryState = -1;
        this.mTwspBatteryLevel = -1;
        this.mUnpairing = false;
    }

    CachedBluetoothDevice(CachedBluetoothDevice r4) {
        this.mProfileLock = new Object();
        this.mProfiles = new CopyOnWriteArrayList();
        this.mRemovedProfiles = new CopyOnWriteArrayList();
        this.mIsCoordinatedSetMember = false;
        this.mCallbacks = new CopyOnWriteArrayList();
        this.mCallbackExecutorMap = new ConcurrentHashMap();
        this.mIsActiveDeviceA2dp = false;
        this.mIsActiveDeviceHeadset = false;
        this.mIsActiveDeviceHearingAid = false;
        this.mIsActiveDeviceLeAudio = false;
        this.mIsA2dpProfileConnectedFail = false;
        this.mIsHeadsetProfileConnectedFail = false;
        this.mIsHearingAidProfileConnectedFail = false;
        this.mIsLeAudioProfileConnectedFail = false;
        this.mMemberDevices = new HashSet();
        this.mIsGroupDevice = false;
        this.mIsIgnore = false;
        this.UNKNOWN = -1;
        this.BREDR = 100;
        this.GROUPID_START = 0;
        this.GROUPID_END = 15;
        this.mType = -1;
        this.mIsLeAudioEnabled = false;
        final Looper r2 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r2);
        this.mContext = r4.mContext;
        this.mLocalAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mProfileManager = r4.mProfileManager;
        this.mDevice = r4.mDevice;
        fillData();
        initDrawableCache();
        this.mUnpairing = false;
    }

    public void release() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    private void initDrawableCache() {
        final int r0 = ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
        this.mDrawableCache = new AnonymousClass2(this, r0);
    }

    private String describe(LocalBluetoothProfile r3) {
        StringBuilder r0 = new StringBuilder("Address:");
        r0.append(this.mDevice);
        if (r3 == null) goto L6;
        r0.append(" Profile:").append(r3);
    L6:
        return r0.toString();
    }

    void onProfileStateChanged(LocalBluetoothProfile r9, int r10) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "onProfileStateChanged: profile " + r9 + ", device " + this.mDevice.getAnonymizedAddress() + ", newProfileState " + r10);
        if (this.mLocalAdapter.getState() != 13) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, " BT Turninig Off...Profile conn state change ignored...");
        return;
    L6:
        Object r1 = this.mProfileLock;
        monitor-enter(r1);
    L70:
        th = move-exception;
        throw th;
    L9:
        if ((r9 instanceof A2dpProfile) == false) goto L11;
    L16:
        setProfileConnectedStatus(r9.getProfileId(), false);     // Catch: Throwable -> L70
        if (r10 == 0) goto L29;
        if (r10 == 1) goto L27;
        if (r10 != 2) goto L21;
        this.mHandler.removeMessages(r9.getProfileId());     // Catch: Throwable -> L70
    L33:
        if (r10 != 2) goto L50;
        if ((r9 instanceof MapProfile) == false) goto L38;
        r9.setEnabled(this.mDevice, true);     // Catch: Throwable -> L70
    L38:
        if (this.mProfiles.contains(r9) == true) goto L45;
        this.mRemovedProfiles.remove(r9);     // Catch: Throwable -> L70
        this.mProfiles.add(r9);     // Catch: Throwable -> L70
        if ((r9 instanceof PanProfile) == false) goto L45;
        if (((PanProfile) r9).isLocalRoleNap(this.mDevice) == false) goto L45;
        this.mLocalNapRoleConnected = true;     // Catch: Throwable -> L70
    L45:
        if (Flags.enableSetPreferredTransportForLeAudioDevice() == false) goto L62;
        if ((r9 instanceof HidProfile) == false) goto L62;
        updatePreferredTransport();     // Catch: Throwable -> L70
    L62:
        if (Flags.enableSetPreferredTransportForLeAudioDevice() == true) goto L64;
    L66:
        HearingAidStatsLogUtils.updateHistoryIfNeeded(this.mContext, this, r9, r10);     // Catch: Throwable -> L70
        monitor-exit(r1);     // Catch: Throwable -> L70
        fetchActiveDevices();
        return;
    L64:
        if ((r9 instanceof LeAudioProfile) == false) goto L66;
        updatePreferredTransport();     // Catch: Throwable -> L70
        goto L66
    L50:
        if ((r9 instanceof MapProfile) == false) goto L54;
        if (r10 != 0) goto L54;
        r9.setEnabled(this.mDevice, false);     // Catch: Throwable -> L70
    L54:
        if (this.mLocalNapRoleConnected == false) goto L62;
        if ((r9 instanceof PanProfile) == false) goto L62;
        if (((PanProfile) r9).isLocalRoleNap(this.mDevice) == false) goto L62;
        if (r10 != 0) goto L62;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Removing PanProfile from device after NAP disconnect");     // Catch: Throwable -> L70
        this.mProfiles.remove(r9);     // Catch: Throwable -> L70
        this.mRemovedProfiles.add(r9);     // Catch: Throwable -> L70
        this.mLocalNapRoleConnected = false;     // Catch: Throwable -> L70
        goto L62
    L21:
        if (r10 == 3) goto L24;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "onProfileStateChanged(): unknown profile state : " + r10);     // Catch: Throwable -> L70
        goto L33
    L24:
        if (this.mHandler.hasMessages(r9.getProfileId()) == false) goto L33;
        this.mHandler.removeMessages(r9.getProfileId());     // Catch: Throwable -> L70
        goto L33
    L27:
        this.mHandler.sendEmptyMessageDelayed(r9.getProfileId(), 60000);     // Catch: Throwable -> L70
        goto L33
    L29:
        if (this.mHandler.hasMessages(r9.getProfileId()) == false) goto L33;
        this.mHandler.removeMessages(r9.getProfileId());     // Catch: Throwable -> L70
        if (r9.getConnectionPolicy(this.mDevice) <= 0) goto L33;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "onProfileStateChanged(): Failed to connect profile");     // Catch: Throwable -> L70
        setProfileConnectedStatus(r9.getProfileId(), true);     // Catch: Throwable -> L70
        goto L33
    L11:
        if ((r9 instanceof HeadsetProfile) == true) goto L16;
        if ((r9 instanceof HearingAidProfile) == true) goto L16;
        if ((r9 instanceof LeAudioProfile) == false) goto L33;
        goto L16
    }

    static /* synthetic */ boolean lambda$updatePreferredTransport$0(LocalBluetoothProfile r0) {
        return r0 instanceof LeAudioProfile;
    }

    private void updatePreferredTransport() {
        if (this.mProfiles.stream().noneMatch(new CachedBluetoothDevice$$ExternalSyntheticLambda5()) == false) goto L5;
        return;
    L5:
        if (this.mProfiles.stream().noneMatch(new CachedBluetoothDevice$$ExternalSyntheticLambda6()) == true) goto L17;
        HidProfile r0 = this.mProfileManager.getHidProfile();
        BluetoothDevice r1 = this.mDevice;
        if (this.mProfileManager.getLeAudioProfile().isEnabled(this.mDevice) == false) goto L10;
        int r3 = 2;
    L12:
        if (r0.setPreferredTransport(r1, r3) == true) goto L16;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Fail to set preferred transport");
        return;
    L16:
        return;
    L10:
        r3 = 1;
        goto L12
    }

    static /* synthetic */ boolean lambda$updatePreferredTransport$1(LocalBluetoothProfile r0) {
        return r0 instanceof HidProfile;
    }

    void setProfileConnectedStatus(int r2, boolean r3) {
        if (r2 != 1) goto L5;
        this.mIsHeadsetProfileConnectedFail = r3;
        return;
    L5:
        if (r2 != 2) goto L7;
        this.mIsA2dpProfileConnectedFail = r3;
        return;
    L7:
        if (r2 != 21) goto L9;
        this.mIsHearingAidProfileConnectedFail = r3;
        return;
    L9:
        if (r2 == 22) goto L11;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "setProfileConnectedStatus(): unknown profile id : " + r2);
        return;
    L11:
        this.mIsLeAudioProfileConnectedFail = r3;
    }

    public void disconnect() {
        Object r0 = this.mProfileLock;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (getGroupId() == (-1)) goto L10;
        Iterator<CachedBluetoothDevice> r1 = getMemberDevice().iterator();     // Catch: Throwable -> L18
    L8:
        if (r1.hasNext() == false) goto L10;
        CachedBluetoothDevice r2 = r1.next();     // Catch: Throwable -> L18
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Disconnect the member:" + r2);     // Catch: Throwable -> L18
        r2.disconnect();     // Catch: Throwable -> L18
    L10:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Disconnect " + this);     // Catch: Throwable -> L18
        this.mDevice.disconnect();     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        PbapServerProfile r3 = this.mProfileManager.getPbapProfile();
        if (r3 != null) goto L15;
        return;
    L15:
        if (isConnectedProfile(r3) == false) goto L25;
        r3.setEnabled(this.mDevice, false);
        return;
    }

    public void disconnect(LocalBluetoothProfile r3) {
        if (r3.setEnabled(this.mDevice, false) == false) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Command sent successfully:DISCONNECT " + describe(r3));
        return;
    }

    @Deprecated
    public void connect(boolean r1) {
        connect();
    }

    public void connect() {
        if (ensurePaired() == true) goto L5;
        return;
    L5:
        this.mConnectAttempted = SystemClock.elapsedRealtime();
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "connect: mConnectAttempted = " + this.mConnectAttempted);
        connectDevice();
    }

    public void setHearingAidInfo(HearingAidInfo r1) {
        this.mHearingAidInfo = r1;
        dispatchAttributesChanged();
    }

    public HearingAidInfo getHearingAidInfo() {
        return this.mHearingAidInfo;
    }

    public boolean isHearingAidDevice() {
        if (this.mHearingAidInfo == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int getDeviceSide() {
        HearingAidInfo r0 = this.mHearingAidInfo;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getSide();
    }

    public int getDeviceMode() {
        HearingAidInfo r0 = this.mHearingAidInfo;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getMode();
    }

    public long getHiSyncId() {
        HearingAidInfo r2 = this.mHearingAidInfo;
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.getHiSyncId();
    }

    public void setIsCoordinatedSetMember(boolean r1) {
        this.mIsCoordinatedSetMember = r1;
    }

    public boolean isCoordinatedSetMemberDevice() {
        return this.mIsCoordinatedSetMember;
    }

    public int getGroupId() {
        return this.mGroupId;
    }

    public int getQGroupId() {
        return this.mQGroupId;
    }

    public void setGroupId(int r3) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, getDevice().getAnonymizedAddress() + " set GroupId " + r3);
        this.mGroupId = r3;
    }

    void onBondingDockConnect() {
        connect();
    }

    private void connectDevice() {
        Object r2 = this.mProfileLock;
        monitor-enter(r2);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.mProfiles.isEmpty() == false) goto L9;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "No profiles. Maybe we will connect later for device " + this.mDevice);     // Catch: Throwable -> L17
        monitor-exit(r2);     // Catch: Throwable -> L17
        return;
    L9:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "connect " + this);     // Catch: Throwable -> L17
        this.mDevice.connect();     // Catch: Throwable -> L17
        if (getGroupId() == (-1)) goto L15;
        Iterator<CachedBluetoothDevice> r5 = getMemberDevice().iterator();     // Catch: Throwable -> L17
    L13:
        if (r5.hasNext() == false) goto L15;
        CachedBluetoothDevice r0 = r5.next();     // Catch: Throwable -> L17
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "connect the member:" + r0);     // Catch: Throwable -> L17
        r0.connect();     // Catch: Throwable -> L17
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L17
    }

    public void connectProfile(LocalBluetoothProfile r3) {
        this.mConnectAttempted = SystemClock.elapsedRealtime();
        connectInt(r3);
        refresh();
    }

    synchronized void connectInt(LocalBluetoothProfile r5) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (ensurePaired() == true) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (r5.setEnabled(this.mDevice, true) == false) goto L13;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Command sent successfully:CONNECT " + describe(r5));     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L13:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(TAG, "Failed to connect " + r5.toString() + " to " + getName());     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    private boolean ensurePaired() {
        if (getBondState() != 10) goto L6;
        startPairing();
        return false;
    L6:
        return true;
    }

    public boolean startPairing() {
        if (this.mLocalAdapter.isDiscovering() == false) goto L6;
        this.mLocalAdapter.cancelDiscovery();
    L6:
        if (this.mDevice.createBond() == true) goto L9;
        return false;
    L9:
        return true;
    }

    public void unpair() {
        int r0 = getBondState();
        if (r0 != 11) goto L6;
        this.mDevice.cancelBondProcess();
    L6:
        if (r0 == 10) goto L13;
        BluetoothDevice r1 = this.mDevice;
        if (r1 == null) goto L14;
        this.mUnpairing = true;
        if (r1.removeBond() == false) goto L15;
        releaseLruCache();
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Command sent successfully:REMOVE_BOND " + describe(null));
        return;
    L15:
        return;
    L14:
        return;
    }

    public int getProfileConnectionState(LocalBluetoothProfile r1) {
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.getConnectionStatus(this.mDevice);
    }

    void fillData() {
        updateProfiles();
        fetchActiveDevices();
        migratePhonebookPermissionChoice();
        migrateMessagePermissionChoice();
        setLeAudioEnabled();
        dispatchAttributesChanged();
    }

    public BluetoothDevice getDevice() {
        return this.mDevice;
    }

    public String getAddress() {
        return this.mDevice.getAddress();
    }

    public String getIdentityAddress() {
        String r0 = this.mDevice.getIdentityAddress();
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        return getAddress();
    }

    public String getName() {
        String r0 = this.mDevice.getAlias();
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        return getAddress();
    }

    public void setName(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (TextUtils.equals(r3, getName()) == true) goto L18;
        this.mDevice.setAlias(r3);
        dispatchAttributesChanged();
        Iterator<CachedBluetoothDevice> r0 = this.mMemberDevices.iterator();
    L9:
        if (r0.hasNext() == false) goto L11;
        r0.next().setName(r3);
        goto L9
    L11:
        CachedBluetoothDevice r2 = this.mSubDevice;
        if (r2 == null) goto L17;
        r2.setName(r3);
        return;
    L17:
        return;
    }

    public boolean setActive() {
        A2dpProfile r0 = this.mProfileManager.getA2dpProfile();
        if (r0 != null) goto L5;
    L9:
        boolean r1 = false;
    L10:
        HeadsetProfile r3 = this.mProfileManager.getHeadsetProfile();
        if (r3 != null) goto L13;
    L17:
        HearingAidProfile r4 = this.mProfileManager.getHearingAidProfile();
        if (r4 != null) goto L20;
    L24:
        LeAudioProfile r5 = this.mProfileManager.getLeAudioProfile();
        if (r5 == null) goto L32;
        if (isConnectedProfile(r5) == false) goto L32;
        if (r5.setActiveDevice(getDevice()) == false) goto L32;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(TAG, "OnPreferenceClickListener: LeAudio active device=" + this);
        return true;
    L32:
        return r1;
    L20:
        if (isConnectedProfile(r4) == false) goto L24;
        if (r4.setActiveDevice(getDevice()) == false) goto L24;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(TAG, "OnPreferenceClickListener: Hearing Aid active device=" + this);
        r1 = true;
        goto L24
    L13:
        if (isConnectedProfile(r3) == false) goto L17;
        if (r3.setActiveDevice(getDevice()) == false) goto L17;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(TAG, "OnPreferenceClickListener: Headset active device=" + this);
        r1 = true;
        goto L17
    L5:
        if (isConnectedProfile(r0) == false) goto L9;
        if (r0.setActiveDevice(getDevice()) == false) goto L9;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(TAG, "OnPreferenceClickListener: A2DP active device=" + this);
        r1 = true;
        goto L10
    }

    void refreshName() {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Device name: " + getName());
        dispatchAttributesChanged();
    }

    public boolean hasHumanReadableName() {
        return !TextUtils.isEmpty(this.mDevice.getAlias());
    }

    public int getBatteryLevel() {
        return this.mDevice.getBatteryLevel();
    }

    public int getMinBatteryLevelWithMemberDevices() {
        return Stream.concat(Stream.of(this), this.mMemberDevices.stream()).mapToInt(new CachedBluetoothDevice$$ExternalSyntheticLambda3()).filter(new CachedBluetoothDevice$$ExternalSyntheticLambda4()).min().orElse(-1);
    }

    static /* synthetic */ int lambda$getMinBatteryLevelWithMemberDevices$2(CachedBluetoothDevice r0) {
        return r0.getBatteryLevel();
    }

    private String getValidMinBatteryLevelWithMemberDevices() {
        int r1 = getMinBatteryLevelWithMemberDevices();
        if (r1 > (-1)) goto L7;
        return null;
    L7:
        return Utils.formatPercentage(r1);
    }

    void refresh() {
        Futures.addCallback(ThreadUtils.getBackgroundExecutor().submit(new CachedBluetoothDevice$$ExternalSyntheticLambda1(this)), new AnonymousClass3(this), this.mContext.getMainExecutor());
    }

    /* JADX INFO: renamed from: lambda$refresh$4$com-android-settingslib-bluetooth-CachedBluetoothDevice, reason: not valid java name */
    /* synthetic */ Void m742x3a0a7598() throws Exception {
        if (BluetoothUtils.isAdvancedDetailsHeader(this.mDevice) == false) goto L11;
        Uri r0 = BluetoothUtils.getUriMetaData(getDevice(), 5);
        if (r0 != null) goto L7;
        return null;
    L7:
        if (this.mDrawableCache.get(r0.toString()) != null) goto L13;
        this.mDrawableCache.put(r0.toString(), (BitmapDrawable) BluetoothUtils.getBtDrawableWithDescription(this.mContext, this).first);
        return null;
    L13:
        return null;
    L11:
        return null;
    }

    public void setJustDiscovered(boolean r2) {
        if (this.mJustDiscovered == r2) goto L6;
        this.mJustDiscovered = r2;
        dispatchAttributesChanged();
        return;
    }

    public int getBondState() {
        return this.mDevice.getBondState();
    }

    public void onActiveDeviceChanged(boolean r5, int r6) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "onActiveDeviceChanged: profile " + BluetoothProfile.getProfileName(r6) + ", device " + this.mDevice.getAnonymizedAddress() + ", isActive " + r5);
        boolean r0 = true;
        boolean r2 = false;
        if (r6 == 1) goto L27;
        if (r6 == 2) goto L22;
        if (r6 == 21) goto L17;
        if (r6 == 22) goto L12;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "onActiveDeviceChanged: unknown profile " + r6 + " isActive " + r5);
    L32:
        if (r2 == false) goto L35;
        dispatchAttributesChanged();
        return;
    L35:
        return;
    L12:
        if (this.mIsActiveDeviceLeAudio != r5) goto L15;
        r0 = false;
    L15:
        this.mIsActiveDeviceLeAudio = r5;
    L31:
        r2 = r0;
        goto L32
    L17:
        if (this.mIsActiveDeviceHearingAid != r5) goto L20;
        r0 = false;
    L20:
        this.mIsActiveDeviceHearingAid = r5;
        goto L31
    L22:
        if (this.mIsActiveDeviceA2dp != r5) goto L25;
        r0 = false;
    L25:
        this.mIsActiveDeviceA2dp = r5;
        goto L31
    L27:
        if (this.mIsActiveDeviceHeadset != r5) goto L30;
        r0 = false;
    L30:
        this.mIsActiveDeviceHeadset = r5;
        goto L31
    }

    void onAudioModeChanged() {
        dispatchAttributesChanged();
    }

    public void onAudioDeviceCategoryChanged() {
        dispatchAttributesChanged();
    }

    public boolean isActiveDevice(int r2) {
        if (r2 == 1) goto L19;
        if (r2 == 2) goto L17;
        if (r2 == 21) goto L15;
        if (r2 == 22) goto L13;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "getActiveDevice: unknown profile " + r2);
        return false;
    L13:
        return this.mIsActiveDeviceLeAudio;
    L15:
        return this.mIsActiveDeviceHearingAid;
    L17:
        return this.mIsActiveDeviceA2dp;
    L19:
        return this.mIsActiveDeviceHeadset;
    }

    void setRssi(short r2) {
        if (this.mRssi == r2) goto L6;
        this.mRssi = r2;
        dispatchAttributesChanged();
        return;
    }

    public boolean isConnected() {
        Object r0 = this.mProfileLock;
        monitor-enter(r0);
        Iterator<LocalBluetoothProfile> r1 = this.mProfiles.iterator();     // Catch: Throwable -> L15
    L6:
        if (r1.hasNext() == false) goto L12;
        if (getProfileConnectionState(r1.next()) != 2) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return true;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    public boolean isConnectedProfile(LocalBluetoothProfile r1) {
        if (getProfileConnectionState(r1) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBusy() {
        Object r0 = this.mProfileLock;
        monitor-enter(r0);
        Iterator<LocalBluetoothProfile> r1 = this.mProfiles.iterator();     // Catch: Throwable -> L19
    L5:
        boolean r3 = true;
        if (r1.hasNext() == false) goto L14;
        int r2 = getProfileConnectionState(r1.next());     // Catch: Throwable -> L19
        if (r2 == 1) goto L11;
        if (r2 != 3) goto L5;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return true;
    L14:
        if (getBondState() == 11) goto L17;
        r3 = false;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return r3;
    L19:
        th = move-exception;
        throw th;
    }

    private boolean updateProfiles() {
        ParcelUuid[] r0 = this.mDevice.getUuids();
        int r8 = 0;
        if (r0 != null) goto L5;
        return false;
    L5:
        List r1 = this.mLocalAdapter.getUuidsList();
        ParcelUuid[] r3 = new ParcelUuid[r1.size()];
        r1.toArray(r3);
        processPhonebookAccess();
        Object r9 = this.mProfileLock;
        monitor-enter(r9);
        this.mProfileManager.updateProfiles(r0, r3, this.mProfiles, this.mRemovedProfiles, this.mLocalNapRoleConnected, this.mDevice);     // Catch: Throwable -> L17
        monitor-exit(r9);     // Catch: Throwable -> L17
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "updating profiles for " + this.mDevice.getAnonymizedAddress());
        BluetoothClass r10 = this.mDevice.getBluetoothClass();
        if (r10 == null) goto L12;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_v(TAG, "Class: " + r10.toString());
    L12:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_v(TAG, "UUID:");
        int r11 = r0.length;
    L13:
        if (r8 >= r11) goto L15;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_v(TAG, BytedanceJustifyTextView.TWO_BLANK + r0[r8]);
        r8 = r8 + 1;
        goto L13
    L15:
        return true;
    L17:
        th = move-exception;
        throw th;
    }

    private void fetchActiveDevices() {
        A2dpProfile r0 = this.mProfileManager.getA2dpProfile();
        if (r0 == null) goto L5;
        this.mIsActiveDeviceA2dp = this.mDevice.equals(r0.getActiveDevice());
    L5:
        HeadsetProfile r1 = this.mProfileManager.getHeadsetProfile();
        if (r1 == null) goto L8;
        this.mIsActiveDeviceHeadset = this.mDevice.equals(r1.getActiveDevice());
    L8:
        HearingAidProfile r2 = this.mProfileManager.getHearingAidProfile();
        if (r2 == null) goto L11;
        this.mIsActiveDeviceHearingAid = r2.getActiveDevices().contains(this.mDevice);
    L11:
        LeAudioProfile r3 = this.mProfileManager.getLeAudioProfile();
        if (r3 == null) goto L15;
        this.mIsActiveDeviceLeAudio = r3.getActiveDevices().contains(this.mDevice);
        return;
    }

    void onUuidChanged() {
        updateProfiles();
        ParcelUuid[] r0 = this.mDevice.getUuids();
        long r2 = 30000;
        if (ArrayUtils.contains(r0, BluetoothUuid.HOGP) == false) goto L6;
    L12:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "onUuidChanged: Time since last connect=" + (SystemClock.elapsedRealtime() - this.mConnectAttempted));
        if ((this.mConnectAttempted + r2) <= SystemClock.elapsedRealtime()) goto L15;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "onUuidChanged: triggering connectDevice");
        connectDevice();
    L15:
        dispatchAttributesChanged();
        return;
    L6:
        if (ArrayUtils.contains(r0, BluetoothUuid.HEARING_AID) == false) goto L9;
        r2 = 15000;
        goto L12
    L9:
        if (ArrayUtils.contains(r0, BluetoothUuid.LE_AUDIO) == true) goto L12;
        r2 = 5000;
        goto L12
    }

    void onBondingStateChanged(int r4) {
        if (r4 != 10) goto L12;
        Object r0 = this.mProfileLock;
        monitor-enter(r0);
        this.mProfiles.clear();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        this.mDevice.setPhonebookAccessPermission(0);
        this.mDevice.setMessageAccessPermission(0);
        this.mDevice.setSimAccessPermission(0);
        this.mBondTimestamp = null;
    L9:
        th = move-exception;
        throw th;
    L12:
        refresh();
        if (r4 != 12) goto L21;
        this.mBondTimestamp = new Timestamp(System.currentTimeMillis());
        boolean r5 = this.mDevice.isBondingInitiatedLocally();
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "mIsBondingInitiatedLocally" + r5);
        if (r5 == false) goto L17;
        connect();
    L17:
        HearingAidStatsLogUtils.addToJustBonded(getAddress());
        return;
    }

    public Timestamp getBondTimestamp() {
        return this.mBondTimestamp;
    }

    public BluetoothClass getBtClass() {
        return this.mDevice.getBluetoothClass();
    }

    public List<LocalBluetoothProfile> getProfiles() {
        return new ArrayList(this.mProfiles);
    }

    public boolean isBASeeker() {
        if (this.mDevice != null) goto L12;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "isBASeeker: mDevice is null");
        return false;
    L12:
        return ((Boolean) Class.forName("com.android.settingslib.bluetooth.BCProfile").getDeclaredMethod("isBASeeker", new Class[]{BluetoothDevice.class}).invoke(null, new Object[]{this.mDevice})).booleanValue();
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public List<LocalBluetoothProfile> getConnectableProfiles() {
        ArrayList r0 = new ArrayList();
        Class<?> r1 = Class.forName("com.android.settingslib.bluetooth.BCProfile");     // Catch: ClassNotFoundException -> L5
    L6:
        Object r2 = this.mProfileLock;
        monitor-enter(r2);
        Iterator<LocalBluetoothProfile> r3 = this.mProfiles.iterator();     // Catch: Throwable -> L24
    L10:
        if (r3.hasNext() == false) goto L22;
        LocalBluetoothProfile r4 = r3.next();     // Catch: Throwable -> L24
        if (r1 == null) goto L20;
        if (r1.isInstance(r4) == false) goto L20;
        if (isBASeeker() == true) goto L17;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "BC profile is not enabled for" + this.mDevice);     // Catch: Throwable -> L24
        goto L10
    L17:
        r0.add(r4);     // Catch: Throwable -> L24
    L20:
        if (r4.accessProfileEnabled() == false) goto L10;
        r0.add(r4);     // Catch: Throwable -> L24
        goto L10
    L22:
        monitor-exit(r2);     // Catch: Throwable -> L24
        return r0;
    L24:
        th = move-exception;
        throw th;
    L5:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "no BCProfileClass: exists");
        r1 = null;
        goto L6
    }

    public List<LocalBluetoothProfile> getRemovedProfiles() {
        return new ArrayList(this.mRemovedProfiles);
    }

    @Deprecated
    public void registerCallback(Callback r1) {
        this.mCallbacks.add(r1);
    }

    public void registerCallback(Executor r2, Callback r3) {
        Objects.requireNonNull(r2, "executor cannot be null");
        Objects.requireNonNull(r3, "callback cannot be null");
        this.mCallbackExecutorMap.put(r3, r2);
    }

    public void unregisterCallback(Callback r2) {
        this.mCallbacks.remove(r2);
        this.mCallbackExecutorMap.remove(r2);
    }

    void dispatchAttributesChanged() {
        Iterator<Callback> r0 = this.mCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDeviceAttributesChanged();
        goto L4
    L6:
        this.mCallbackExecutorMap.forEach(new CachedBluetoothDevice$$ExternalSyntheticLambda13());
    }

    static /* synthetic */ void lambda$dispatchAttributesChanged$5(final Callback r1, Executor r2) {
        Objects.requireNonNull(r1);
        r2.execute(new CachedBluetoothDevice$$ExternalSyntheticLambda2(r1));
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("CachedBluetoothDevice{anonymizedAddress=");
        r0.append(this.mDevice.getAnonymizedAddress());
        r0.append(", name=").append(getName());
        r0.append(", groupId=").append(this.mGroupId);
        r0.append(", member=").append(this.mMemberDevices);
        if (isHearingAidDevice() == false) goto L5;
        r0.append(", hearingAidInfo=").append(this.mHearingAidInfo);
        r0.append(", subDevice=").append(this.mSubDevice);
    L5:
        r0.append(VectorFormat.DEFAULT_SUFFIX);
        return r0.toString();
    }

    public boolean equals(Object r2) {
        if (r2 != null) goto L4;
        return false;
    L4:
        if ((r2 instanceof CachedBluetoothDevice) == true) goto L7;
        return false;
    L7:
        return this.mDevice.equals(((CachedBluetoothDevice) r2).mDevice);
    }

    public int hashCode() {
        return this.mDevice.getAddress().hashCode();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(CachedBluetoothDevice r6) {
        int r0 = (r6.isConnected() ? 1 : 0) - (isConnected() ? 1 : 0);
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r1 = 1;
        if (r6.getBondState() != 12) goto L8;
        int r2 = 1;
    L10:
        if (getBondState() == 12) goto L13;
        r1 = 0;
    L13:
        int r3 = r2 - r1;
        if (r3 == 0) goto L16;
        return r3;
    L16:
        int r4 = (r6.mJustDiscovered ? 1 : 0) - (this.mJustDiscovered ? 1 : 0);
        if (r4 == 0) goto L19;
        return r4;
    L19:
        int r5 = r6.mRssi - this.mRssi;
        if (r5 == 0) goto L23;
        return r5;
    L23:
        return getName().compareTo(r6.getName());
    L8:
        r2 = 0;
        goto L10
    }

    private void migratePhonebookPermissionChoice() {
        SharedPreferences r0 = this.mContext.getSharedPreferences("bluetooth_phonebook_permission", 0);
        if (r0.contains(this.mDevice.getAddress()) == true) goto L6;
        return;
    L6:
        if (this.mDevice.getPhonebookAccessPermission() != 0) goto L13;
        int r1 = r0.getInt(this.mDevice.getAddress(), 0);
        if (r1 != 1) goto L11;
        this.mDevice.setPhonebookAccessPermission(1);
        goto L13
    L11:
        if (r1 != 2) goto L13;
        this.mDevice.setPhonebookAccessPermission(2);
    L13:
        SharedPreferences.Editor r2 = r0.edit();
        r2.remove(this.mDevice.getAddress());
        r2.commit();
    }

    private void migrateMessagePermissionChoice() {
        SharedPreferences r0 = this.mContext.getSharedPreferences("bluetooth_message_permission", 0);
        if (r0.contains(this.mDevice.getAddress()) == true) goto L6;
        return;
    L6:
        if (this.mDevice.getMessageAccessPermission() != 0) goto L13;
        int r1 = r0.getInt(this.mDevice.getAddress(), 0);
        if (r1 != 1) goto L11;
        this.mDevice.setMessageAccessPermission(1);
        goto L13
    L11:
        if (r1 != 2) goto L13;
        this.mDevice.setMessageAccessPermission(2);
    L13:
        SharedPreferences.Editor r2 = r0.edit();
        r2.remove(this.mDevice.getAddress());
        r2.commit();
    }

    private void processPhonebookAccess() {
        if (this.mDevice.getBondState() == 12) goto L6;
        return;
    L6:
        if (BluetoothUuid.containsAnyUuid(this.mDevice.getUuids(), PbapServerProfile.PBAB_CLIENT_UUIDS) == false) goto L9;
        this.mDevice.getPhonebookAccessPermission();
        return;
    }

    public int getMaxConnectionState() {
        Object r0 = this.mProfileLock;
        monitor-enter(r0);
        Iterator<LocalBluetoothProfile> r1 = getProfiles().iterator();     // Catch: Throwable -> L12
        int r2 = 0;
    L6:
        if (r1.hasNext() == false) goto L10;
        int r3 = getProfileConnectionState(r1.next());     // Catch: Throwable -> L12
        if (r3 <= r2) goto L6;
        r2 = r3;
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L12:
        th = move-exception;
        throw th;
    }

    public String getConnectionSummary() {
        return getConnectionSummary(false);
    }

    public String getConnectionSummary(boolean r3) {
        if (BluetoothUtils.isAudioSharingEnabled() == true) goto L5;
    L10:
        CharSequence r0 = null;
    L11:
        if (r0 != null) goto L13;
        r0 = getConnectionSummary(r3, false, 0);
    L13:
        if (r0 != null) goto L15;
        return null;
    L15:
        return r0.toString();
    L5:
        if (this.mBluetoothManager != null) goto L8;
        this.mBluetoothManager = LocalBluetoothManager.getInstance(this.mContext, null);
    L8:
        if (BluetoothUtils.isBroadcasting(this.mBluetoothManager) == false) goto L10;
        r0 = getBroadcastConnectionSummary(r3);
        goto L11
    }

    private String getBroadcastConnectionSummary(boolean r11) {
        if (isProfileConnectedFail() == true) goto L5;
    L8:
        Object r0 = this.mProfileLock;
        monitor-enter(r0);
        Iterator<LocalBluetoothProfile> r1 = getProfiles().iterator();     // Catch: Throwable -> L43
    L12:
        if (r1.hasNext() == false) goto L20;
        int r2 = getProfileConnectionState(r1.next());     // Catch: Throwable -> L43
        if (r2 == 1) goto L17;
        if (r2 != 3) goto L12;
    L17:
        String r10 = this.mContext.getString(BluetoothUtils.getConnectionStateSummary(r2));     // Catch: Throwable -> L43
        monitor-exit(r0);     // Catch: Throwable -> L43
        return r10;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L43
        int r6 = BluetoothUtils.getIntMetaData(this.mDevice, 10);
        int r7 = BluetoothUtils.getIntMetaData(this.mDevice, 11);
        String r8 = getValidMinBatteryLevelWithMemberDevices();
        if (this.mBluetoothManager != null) goto L25;
        this.mBluetoothManager = LocalBluetoothManager.getInstance(this.mContext, null);
    L25:
        if (BluetoothUtils.hasConnectedBroadcastSource(this, this.mBluetoothManager) == false) goto L35;
        int r3 = BluetoothUtils.getGroupId(this);
        if (r3 == (-1)) goto L33;
        if (r3 != Settings.Secure.getInt(this.mContext.getContentResolver(), "bluetooth_le_broadcast_fallback_active_group_id", -1)) goto L33;
        return getSummaryWithBatteryInfo(R.string.bluetooth_active_battery_level_untethered, R.string.bluetooth_active_battery_level, R.string.bluetooth_active_no_battery_level, r6, r7, r8, r11);
    L33:
        return getSummaryWithBatteryInfo(R.string.bluetooth_active_media_only_battery_level_untethered, R.string.bluetooth_active_media_only_battery_level, R.string.bluetooth_active_media_only_no_battery_level, r6, r7, r8, r11);
    L35:
        if (getProfiles().stream().anyMatch(new CachedBluetoothDevice$$ExternalSyntheticLambda0(this)) == true) goto L37;
        return null;
    L37:
        if (isConnected() == false) goto L41;
        return getSummaryWithBatteryInfo(R.string.bluetooth_battery_level_untethered_lea_support, R.string.bluetooth_battery_level_lea_support, R.string.bluetooth_no_battery_level_lea_support, r6, r7, r8, r11);
    L41:
        return this.mContext.getString(R.string.bluetooth_saved_device_lea_support);
    L43:
        th = move-exception;
        throw th;
    L5:
        if (isConnected() == false) goto L8;
        return this.mContext.getString(R.string.profile_connect_timeout_subtext);
    }

    /* JADX INFO: renamed from: lambda$getBroadcastConnectionSummary$6$com-android-settingslib-bluetooth-CachedBluetoothDevice, reason: not valid java name */
    /* synthetic */ boolean m741xaa940a1c(LocalBluetoothProfile r2) {
        if ((r2 instanceof LeAudioProfile) == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.isEnabled(getDevice()) == false) goto L7;
        return true;
    }

    private String getSummaryWithBatteryInfo(int r4, int r5, int r6, int r7, int r8, String r9, boolean r10) {
        if (isTwsBatteryAvailable(r7, r8) == false) goto L7;
        if (r10 == true) goto L7;
        return this.mContext.getString(r4, new Object[]{Utils.formatPercentage(r7), Utils.formatPercentage(r8)});
    L7:
        if (r9 == null) goto L12;
        if (r10 == true) goto L12;
        return this.mContext.getString(r5, new Object[]{r9});
    L12:
        return this.mContext.getString(r6);
    }

    public CharSequence getTvConnectionSummary() {
        return getTvConnectionSummary(0);
    }

    public CharSequence getTvConnectionSummary(int r3) {
        return getConnectionSummary(false, true, r3);
    }

    private CharSequence getConnectionSummary(boolean r16, boolean r17, int r18) {
        if (isProfileConnectedFail() == true) goto L5;
    L8:
        Object r2 = this.mProfileLock;
        monitor-enter(r2);
        Iterator<LocalBluetoothProfile> r3 = getProfiles().iterator();     // Catch: Throwable -> L129
        boolean r6 = false;
        boolean r7 = true;
        boolean r8 = true;
        boolean r9 = true;
        boolean r10 = true;
    L12:
        if (r3.hasNext() == false) goto L44;
        LocalBluetoothProfile r11 = r3.next();     // Catch: Throwable -> L129
        int r13 = getProfileConnectionState(r11);     // Catch: Throwable -> L129
        if (r13 != 0) goto L15;
        if (r11.isProfileReady() == false) goto L12;
        if ((r11 instanceof A2dpProfile) == true) goto L43;
        if ((r11 instanceof A2dpSinkProfile) == true) goto L43;
        if ((r11 instanceof HeadsetProfile) == true) goto L42;
        if ((r11 instanceof HfpClientProfile) == true) goto L42;
        if ((r11 instanceof HearingAidProfile) == true) goto L38;
        if ((r11 instanceof LeAudioProfile) == false) goto L12;
        r10 = false;
        goto L12
    L38:
        r9 = false;
    L42:
        r8 = false;
    L43:
        r7 = false;
        goto L12
    L15:
        if (r13 == 1) goto L21;
        if (r13 != 2) goto L18;
        r6 = true;
        goto L12
    L18:
        if (r13 != 3) goto L12;
    L21:
        String r0 = this.mContext.getString(BluetoothUtils.getConnectionStateSummary(r13));     // Catch: Throwable -> L129
        monitor-exit(r2);     // Catch: Throwable -> L129
        return r0;
    L44:
        monitor-exit(r2);     // Catch: Throwable -> L129
        String r4 = getValidMinBatteryLevelWithMemberDevices();
        int r5 = R.string.bluetooth_pairing;
        if (r6 == false) goto L84;
        int r12 = getLeftBatteryLevel();
        int r14 = getRightBatteryLevel();
        if (isTwsBatteryAvailable(r12, r14) == false) goto L50;
        r5 = R.string.bluetooth_battery_level_untethered;
    L53:
        if (r7 == true) goto L57;
        if (r8 == true) goto L57;
        if (r9 == true) goto L57;
        if (r10 == true) goto L57;
    L86:
        if (r5 != R.string.bluetooth_pairing) goto L92;
        if (getBondState() == 11) goto L92;
        return null;
    L92:
        if (r5 != R.string.bluetooth_battery_level) goto L94;
    L105:
        boolean r1 = true;
    L106:
        if (r17 == false) goto L113;
        if (r1 == false) goto L113;
        if (com.android.settingslib.media.flags.Flags.enableTvMediaOutputDialog() == false) goto L113;
        return getTvBatterySummary(getMinBatteryLevelWithMemberDevices(), r12, r14, r18);
    L113:
        if (isTwsBatteryAvailable(r12, r14) == false) goto L117;
        return this.mContext.getString(r5, new Object[]{Utils.formatPercentage(r12), Utils.formatPercentage(r14)});
    L117:
        if (r12 > (-1)) goto L119;
    L122:
        if (r14 <= (-1)) goto L128;
        if (BluetoothUtils.getBooleanMetaData(this.mDevice, 6) == true) goto L128;
        return this.mContext.getString(r5, new Object[]{Utils.formatPercentage(r14)});
    L128:
        return this.mContext.getString(r5, new Object[]{r4});
    L119:
        if (BluetoothUtils.getBooleanMetaData(this.mDevice, 6) == true) goto L122;
        return this.mContext.getString(r5, new Object[]{Utils.formatPercentage(r12)});
    L94:
        if (r5 == R.string.bluetooth_active_battery_level) goto L105;
        if (r5 == R.string.bluetooth_active_battery_level_untethered) goto L105;
        if (r5 == R.string.bluetooth_active_battery_level_untethered_left) goto L105;
        if (r5 == R.string.bluetooth_active_battery_level_untethered_right) goto L105;
        if (r5 == R.string.bluetooth_battery_level_untethered) goto L105;
        r1 = false;
    L57:
        boolean r15 = Utils.isAudioModeOngoingCall(this.mContext);
        if (this.mIsActiveDeviceHearingAid == true) goto L68;
        if (this.mIsActiveDeviceHeadset == false) goto L63;
        if (r15 == true) goto L68;
    L63:
        if (this.mIsActiveDeviceA2dp == false) goto L66;
        if (r15 == false) goto L68;
    L66:
        if (this.mIsActiveDeviceLeAudio == true) goto L68;
    L75:
        boolean r19 = this.mIsActiveDeviceHearingAid;
        if (this.mIsActiveDeviceLeAudio == true) goto L78;
    L80:
        boolean r20 = false;
    L81:
        if (r19 == true) goto L83;
        if (r20 == false) goto L86;
    L83:
        r5 = getHearingDeviceSummaryRes(r12, r14, r16);
        goto L86
    L78:
        if (isConnectedHapClientDevice() == false) goto L80;
        r20 = true;
    L68:
        if (isTwsBatteryAvailable(r12, r14) == false) goto L71;
        if (r16 == true) goto L71;
        r5 = R.string.bluetooth_active_battery_level_untethered;
    L71:
        if (r4 == null) goto L74;
        if (r16 == true) goto L74;
        r5 = R.string.bluetooth_active_battery_level;
    L74:
        r5 = R.string.bluetooth_active_no_battery_level;
        goto L75
    L50:
        if (r4 == null) goto L53;
        if (r16 == true) goto L53;
        r5 = R.string.bluetooth_battery_level;
        goto L53
    L84:
        r12 = -1;
        r14 = -1;
    L129:
        th = move-exception;
        throw th;
    L5:
        if (isConnected() == false) goto L8;
        return this.mContext.getString(R.string.profile_connect_timeout_subtext);
    }

    private CharSequence getTvBatterySummary(int r7, int r8, int r9, int r10) {
        Resources r0 = this.mContext.getResources();
        SpannableStringBuilder r1 = new SpannableStringBuilder();
        if (r8 >= 0) goto L7;
        if (r9 >= 0) goto L7;
        addBatterySpan(r1, r0.getString(R.string.tv_bluetooth_battery_level, new Object[]{Utils.formatPercentage(r7)}), isBatteryLow(r7, 20), r10);
    L14:
        return r1;
    L7:
        if (r8 < 0) goto L9;
        addBatterySpan(r1, r0.getString(R.string.tv_bluetooth_battery_level_untethered_left, new Object[]{Utils.formatPercentage(r8)}), isBatteryLow(r8, 21), r10);
    L9:
        if (r9 < 0) goto L14;
        if (r1.length() <= 0) goto L13;
        r1.append(HanziToPinyin.Token.SEPARATOR);
    L13:
        addBatterySpan(r1, r0.getString(R.string.tv_bluetooth_battery_level_untethered_right, new Object[]{Utils.formatPercentage(r9)}), isBatteryLow(r9, 22), r10);
        goto L14
    }

    private int getHearingDeviceSummaryRes(int r5, int r6, boolean r7) {
        boolean r0 = false;
        boolean r1 = getConnectedHearingAidSide(0).isPresent();
        boolean r4 = getConnectedHearingAidSide(1).isPresent();
        if (r7 == true) goto L6;
        if (r5 <= (-1)) goto L6;
        boolean r8 = true;
    L7:
        if (r7 == true) goto L10;
        if (r6 <= (-1)) goto L10;
        r0 = true;
    L10:
        if (r1 == false) goto L17;
        if (r4 == false) goto L17;
        if (r8 == false) goto L16;
        if (r0 == false) goto L16;
        return R.string.bluetooth_active_battery_level_untethered;
    L16:
        return R.string.bluetooth_hearing_aid_left_and_right_active;
    L17:
        if (r1 == false) goto L22;
        if (r8 == false) goto L21;
        return R.string.bluetooth_active_battery_level_untethered_left;
    L21:
        return R.string.bluetooth_hearing_aid_left_active;
    L22:
        if (r4 == false) goto L28;
        if (r0 == false) goto L26;
        return R.string.bluetooth_active_battery_level_untethered_right;
    L26:
        return R.string.bluetooth_hearing_aid_right_active;
    L28:
        return R.string.bluetooth_active_no_battery_level;
    L6:
        r8 = false;
        goto L7
    }

    private void addBatterySpan(SpannableStringBuilder r1, String r2, boolean r3, int r4) {
        if (r3 == false) goto L5;
        if (r4 == 0) goto L5;
        r1.append(r2, new ForegroundColorSpan(this.mContext.getResources().getColor(r4)), 0);
        return;
    L5:
        r1.append(r2);
    }

    private boolean isBatteryLow(int r1, int r2) {
        int r0 = BluetoothUtils.getIntMetaData(this.mDevice, r2);
        if (r0 > 0) goto L5;
        r0 = 20;
    L5:
        if (r1 > r0) goto L7;
        return true;
    L7:
        return false;
    }

    private Optional<CachedBluetoothDevice> getConnectedHearingAidSide(final int r4) {
        return Stream.concat(Stream.of(new CachedBluetoothDevice[]{this, this.mSubDevice}), this.mMemberDevices.stream()).filter(new CachedBluetoothDevice$$ExternalSyntheticLambda10()).filter(new CachedBluetoothDevice$$ExternalSyntheticLambda11(r4)).filter(new CachedBluetoothDevice$$ExternalSyntheticLambda12()).findAny();
    }

    static /* synthetic */ boolean lambda$getConnectedHearingAidSide$7(int r1, CachedBluetoothDevice r2) {
        if (r2.getDeviceSide() != r1) goto L5;
    L8:
        return true;
    L5:
        if (r2.getDeviceSide() == 2) goto L8;
        return false;
    }

    static /* synthetic */ boolean lambda$getConnectedHearingAidSide$8(CachedBluetoothDevice r0) {
        return r0.getDevice().isConnected();
    }

    private int getLeftBatteryLevel() {
        if (BluetoothUtils.getBooleanMetaData(this.mDevice, 6) == false) goto L5;
        int r0 = BluetoothUtils.getIntMetaData(this.mDevice, 10);
    L6:
        if (r0 == (-1)) goto L8;
        return r0;
    L8:
        return ((Integer) getConnectedHearingAidSide(0).map(new CachedBluetoothDevice$$ExternalSyntheticLambda7()).filter(new CachedBluetoothDevice$$ExternalSyntheticLambda8()).orElse(-1)).intValue();
    L5:
        r0 = -1;
        goto L6
    }

    static /* synthetic */ boolean lambda$getLeftBatteryLevel$9(Integer r1) {
        if (r1.intValue() <= (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private int getRightBatteryLevel() {
        if (BluetoothUtils.getBooleanMetaData(this.mDevice, 6) == false) goto L5;
        int r0 = BluetoothUtils.getIntMetaData(this.mDevice, 11);
    L6:
        if (r0 == (-1)) goto L8;
        return r0;
    L8:
        return ((Integer) getConnectedHearingAidSide(1).map(new CachedBluetoothDevice$$ExternalSyntheticLambda7()).filter(new CachedBluetoothDevice$$ExternalSyntheticLambda9()).orElse(-1)).intValue();
    L5:
        r0 = -1;
        goto L6
    }

    static /* synthetic */ boolean lambda$getRightBatteryLevel$10(Integer r1) {
        if (r1.intValue() <= (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isProfileConnectedFail() {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "anonymizedAddress=" + this.mDevice.getAnonymizedAddress() + " mIsA2dpProfileConnectedFail=" + this.mIsA2dpProfileConnectedFail + " mIsHearingAidProfileConnectedFail=" + this.mIsHearingAidProfileConnectedFail + " mIsLeAudioProfileConnectedFail=" + this.mIsLeAudioProfileConnectedFail + " mIsHeadsetProfileConnectedFail=" + this.mIsHeadsetProfileConnectedFail + " isConnectedSapDevice()=" + isConnectedSapDevice());
        if (this.mIsA2dpProfileConnectedFail == false) goto L5;
    L14:
        return true;
    L5:
        if (this.mIsHearingAidProfileConnectedFail == true) goto L14;
        if (isConnectedSapDevice() == true) goto L11;
        if (this.mIsHeadsetProfileConnectedFail == true) goto L14;
    L11:
        if (this.mIsLeAudioProfileConnectedFail == true) goto L14;
        return false;
    }

    public String getCarConnectionSummary() {
        return getCarConnectionSummary(false);
    }

    public String getCarConnectionSummary(boolean r2) {
        return getCarConnectionSummary(r2, true);
    }

    public String getCarConnectionSummary(boolean r17, boolean r18) {
        Object r1 = this.mProfileLock;
        monitor-enter(r1);
        Iterator<LocalBluetoothProfile> r2 = getProfiles().iterator();     // Catch: Throwable -> L99
        boolean r4 = false;
        boolean r5 = false;
        boolean r6 = false;
        boolean r7 = false;
        boolean r8 = false;
    L6:
        if (r2.hasNext() == false) goto L41;
        LocalBluetoothProfile r9 = r2.next();     // Catch: Throwable -> L99
        int r13 = getProfileConnectionState(r9);     // Catch: Throwable -> L99
        if (r13 != 0) goto L9;
        if (r9.isProfileReady() == false) goto L6;
        if ((r9 instanceof A2dpProfile) == true) goto L40;
        if ((r9 instanceof A2dpSinkProfile) == true) goto L40;
        if ((r9 instanceof HeadsetProfile) == true) goto L39;
        if ((r9 instanceof HfpClientProfile) == true) goto L39;
        if ((r9 instanceof HearingAidProfile) == true) goto L35;
        if ((r9 instanceof LeAudioProfile) == false) goto L6;
        r5 = true;
        goto L6
    L35:
        r4 = true;
    L39:
        r8 = true;
    L40:
        r7 = true;
        goto L6
    L9:
        if (r13 == 1) goto L18;
        if (r13 != 2) goto L11;
        if (r17 == true) goto L14;
        r6 = true;
        goto L6
    L14:
        String r0 = this.mContext.getString(BluetoothUtils.getConnectionStateSummary(r13), new Object[]{""});     // Catch: Throwable -> L99
        monitor-exit(r1);     // Catch: Throwable -> L99
        return r0;
    L11:
        if (r13 != 3) goto L6;
    L18:
        String r3 = this.mContext.getString(BluetoothUtils.getConnectionStateSummary(r13));     // Catch: Throwable -> L99
        monitor-exit(r1);     // Catch: Throwable -> L99
        return r3;
    L41:
        monitor-exit(r1);     // Catch: Throwable -> L99
        int r10 = getMinBatteryLevelWithMemberDevices();
        if (r10 <= (-1)) goto L45;
        String r11 = Utils.formatPercentage(r10);
    L46:
        String[] r12 = this.mContext.getResources().getStringArray(R.array.bluetooth_audio_active_device_summaries);
        String r14 = r12[0];
        boolean r15 = this.mIsActiveDeviceA2dp;
        if (r15 == true) goto L49;
    L51:
        if (r15 == false) goto L54;
        r14 = r12[2];
    L54:
        if (this.mIsActiveDeviceHeadset == false) goto L56;
        String r16 = r12[3];
    L57:
        if (r4 == false) goto L59;
    L62:
        if (r5 == false) goto L64;
    L67:
        if (r6 == false) goto L93;
        if (r7 == false) goto L75;
        if (r8 == false) goto L75;
        if (r11 == null) goto L74;
        return this.mContext.getString(R.string.bluetooth_connected_no_headset_no_a2dp_battery_level, new Object[]{r11, r16});
    L74:
        return this.mContext.getString(R.string.bluetooth_connected_no_headset_no_a2dp, new Object[]{r16});
    L75:
        if (r7 == false) goto L81;
        if (r11 == null) goto L80;
        return this.mContext.getString(R.string.bluetooth_connected_no_a2dp_battery_level, new Object[]{r11, r16});
    L80:
        return this.mContext.getString(R.string.bluetooth_connected_no_a2dp, new Object[]{r16});
    L81:
        if (r8 == false) goto L87;
        if (r11 == null) goto L86;
        return this.mContext.getString(R.string.bluetooth_connected_no_headset_battery_level, new Object[]{r11, r16});
    L86:
        return this.mContext.getString(R.string.bluetooth_connected_no_headset, new Object[]{r16});
    L87:
        if (r11 == null) goto L91;
        return this.mContext.getString(R.string.bluetooth_connected_battery_level, new Object[]{r11, r16});
    L91:
        return this.mContext.getString(R.string.bluetooth_connected, new Object[]{r16});
    L93:
        if (getBondState() == 11) goto L95;
        if (r18 == true) goto L98;
        return null;
    L98:
        return this.mContext.getString(R.string.bluetooth_disconnected);
    L95:
        return this.mContext.getString(R.string.bluetooth_pairing);
    L64:
        if (this.mIsActiveDeviceLeAudio == false) goto L67;
        return this.mContext.getString(R.string.bluetooth_connected, new Object[]{r12[1]});
    L59:
        if (this.mIsActiveDeviceHearingAid == false) goto L62;
        return this.mContext.getString(R.string.bluetooth_connected, new Object[]{r12[1]});
    L56:
        r16 = r14;
        goto L57
    L49:
        if (this.mIsActiveDeviceHeadset == false) goto L51;
        r16 = r12[1];
        goto L57
    L45:
        r11 = null;
    L99:
        th = move-exception;
        throw th;
    }

    public boolean isConnectedA2dpDevice() {
        A2dpProfile r0 = this.mProfileManager.getA2dpProfile();
        A2dpSinkProfile r1 = this.mProfileManager.getA2dpSinkProfile();
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(TAG, "a2dpProfile :" + r0 + " a2dpSinkProfile :" + r1);
        if (r0 != null) goto L5;
        if (r1 != null) goto L11;
        return false;
    L11:
        if (r1.getConnectionStatus(this.mDevice) != 2) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (r0.getConnectionStatus(this.mDevice) != 2) goto L8;
        return true;
    L8:
        return false;
    }

    public boolean isConnectedHfpDevice() {
        HeadsetProfile r0 = this.mProfileManager.getHeadsetProfile();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getConnectionStatus(this.mDevice) != 2) goto L7;
        return true;
    }

    public boolean isConnectedAshaHearingAidDevice() {
        HearingAidProfile r0 = this.mProfileManager.getHearingAidProfile();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getConnectionStatus(this.mDevice) != 2) goto L7;
        return true;
    }

    public boolean isConnectedHapClientDevice() {
        HapClientProfile r0 = this.mProfileManager.getHapClientProfile();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getConnectionStatus(this.mDevice) != 2) goto L7;
        return true;
    }

    public boolean isConnectedLeAudioHearingAidDevice() {
        if (isConnectedHapClientDevice() == true) goto L5;
    L7:
        return false;
    L5:
        if (isConnectedLeAudioDevice() == false) goto L7;
        return true;
    }

    public boolean isConnectedHearingAidDevice() {
        if (isConnectedAshaHearingAidDevice() == false) goto L5;
    L8:
        return true;
    L5:
        if (isConnectedLeAudioHearingAidDevice() == true) goto L8;
        return false;
    }

    public boolean isConnectedLeAudioDevice() {
        LeAudioProfile r0 = this.mProfileManager.getLeAudioProfile();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getConnectionStatus(this.mDevice) != 2) goto L7;
        return true;
    }

    private boolean isConnectedSapDevice() {
        SapProfile r0 = this.mProfileManager.getSapProfile();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getConnectionStatus(this.mDevice) != 2) goto L7;
        return true;
    }

    public CachedBluetoothDevice getSubDevice() {
        return this.mSubDevice;
    }

    public void setSubDevice(CachedBluetoothDevice r1) {
        this.mSubDevice = r1;
    }

    public void switchSubDeviceContent() {
        BluetoothDevice r0 = this.mDevice;
        short r1 = this.mRssi;
        boolean r2 = this.mJustDiscovered;
        HearingAidInfo r3 = this.mHearingAidInfo;
        release();
        CachedBluetoothDevice r4 = this.mSubDevice;
        this.mDevice = r4.mDevice;
        this.mRssi = r4.mRssi;
        this.mJustDiscovered = r4.mJustDiscovered;
        this.mHearingAidInfo = r4.mHearingAidInfo;
        r4.release();
        CachedBluetoothDevice r5 = this.mSubDevice;
        r5.mDevice = r0;
        r5.mRssi = r1;
        r5.mJustDiscovered = r2;
        r5.mHearingAidInfo = r3;
        fetchActiveDevices();
    }

    public Set<CachedBluetoothDevice> getMemberDevice() {
        return this.mMemberDevices;
    }

    public void addMemberDevice(CachedBluetoothDevice r3) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, this + " addMemberDevice = " + r3);
        this.mMemberDevices.add(r3);
    }

    public void removeMemberDevice(CachedBluetoothDevice r1) {
        r1.release();
        this.mMemberDevices.remove(r1);
    }

    public void switchMemberDeviceContent(CachedBluetoothDevice r6) {
        removeMemberDevice(r6);
        BluetoothDevice r0 = this.mDevice;
        short r1 = this.mRssi;
        boolean r2 = this.mJustDiscovered;
        HearingAidInfo r3 = this.mHearingAidInfo;
        release();
        this.mDevice = r6.mDevice;
        this.mRssi = r6.mRssi;
        this.mJustDiscovered = r6.mJustDiscovered;
        this.mHearingAidInfo = r6.mHearingAidInfo;
        fillData();
        r6.release();
        r6.mDevice = r0;
        r6.mRssi = r1;
        r6.mJustDiscovered = r2;
        r6.mHearingAidInfo = r3;
        r6.fillData();
        addMemberDevice(r6);
    }

    public Pair<Drawable, String> getDrawableWithDescription() {
        Uri r0 = BluetoothUtils.getUriMetaData(this.mDevice, 5);
        Pair<Drawable, String> r1 = BluetoothUtils.getBtClassDrawableWithDescription(this.mContext, this);
        if (BluetoothUtils.isAdvancedDetailsHeader(this.mDevice) == false) goto L11;
        if (r0 == null) goto L11;
        BitmapDrawable r2 = this.mDrawableCache.get(r0.toString());
        if (r2 != null) goto L8;
        refresh();
        goto L11
    L8:
        return new Pair(new AdaptiveOutlineDrawable(this.mContext.getResources(), r2.getBitmap()), (String) r1.second);
    L11:
        return BluetoothUtils.getBtRainbowDrawableWithDescription(this.mContext, this);
    }

    void releaseLruCache() {
        this.mDrawableCache.evictAll();
    }

    boolean getUnpairing() {
        return this.mUnpairing;
    }

    void setLocalBluetoothManager(LocalBluetoothManager r1) {
        this.mBluetoothManager = r1;
    }

    void setLeAudioEnabled() {
        if (this.mProfileManager.getLeAudioProfile() == null) goto L5;
        boolean r0 = true;
    L6:
        this.mIsLeAudioEnabled = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    boolean isLeAudioEnabled() {
        return this.mIsLeAudioEnabled;
    }
}
