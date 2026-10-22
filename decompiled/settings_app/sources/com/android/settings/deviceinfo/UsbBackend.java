package com.android.settings.deviceinfo;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.IUsbManager;
import android.hardware.usb.UsbManager;
import android.hardware.usb.UsbPort;
import android.hardware.usb.UsbPortStatus;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import com.GlobalProxyLancet;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.R;
import com.android.settings.Utils;
import com.obric.olog.OLog;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UsbBackend {
    public static final int MODE_AUDIO_SOURCE = 10;
    private static final int MODE_DATA_MASK = 14;
    public static final int MODE_DATA_MIDI = 6;
    public static final int MODE_DATA_MTP = 2;
    public static final int MODE_DATA_NONE = 0;
    public static final int MODE_DATA_PTP = 4;
    public static final int MODE_DATA_TETHERING = 8;
    private static final int MODE_POWER_MASK = 1;
    public static final int MODE_POWER_SINK = 0;
    public static final int MODE_POWER_SOURCE = 1;
    private String TAG;
    private Context mContext;
    private boolean mIsUnlocked;
    private final boolean mMidi;
    private UsbPort mPort;
    private UsbPortStatus mPortStatus;
    private final boolean mRestricted;
    private final boolean mRestrictedBySystem;
    private boolean mTetheringEnabled;
    private UsbManager mUsbManager;
    private IUsbManager mUsbManagerService;
    private UserManager mUserManager;

    public static int getDataRoleDevice() {
        return 2;
    }

    public static int getDataRoleHost() {
        return 1;
    }

    public static int getPowerRoleSink() {
        return 2;
    }

    public static int getPowerRoleSource() {
        return 1;
    }

    public UsbBackend(Context r5) {
        this.TAG = "UsbBackend";
        this.mContext = r5;
        Intent r0 = GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r5, null, new IntentFilter("android.hardware.usb.action.USB_STATE"), 2);
        int r1 = 0;
        if (r0 != null) goto L5;
        boolean r2 = false;
    L6:
        this.mIsUnlocked = r2;
        this.mUserManager = UserManager.get(r5);
        this.mUsbManager = (UsbManager) r5.getSystemService(UsbManager.class);
        this.mUsbManagerService = IUsbManager.Stub.asInterface(ServiceManager.getService("usb"));
        this.mTetheringEnabled = r5.getResources().getBoolean(R.bool.config_regional_usb_tethering_quick_start_enable);
        this.mRestricted = this.mUserManager.hasUserRestriction("no_usb_file_transfer");
        this.mRestrictedBySystem = this.mUserManager.hasBaseUserRestriction("no_usb_file_transfer", UserHandle.of(UserHandle.myUserId()));
        this.mMidi = r5.getPackageManager().hasSystemFeature("android.software.midi");
        UsbPort[] r6 = getPorts(this.mUsbManager);
        int r3 = r6.length;
    L7:
        if (r1 >= r3) goto L15;
        UsbPortStatus r4 = this.mUsbManagerService.getPortStatus(r6[r1].getId());     // Catch: RemoteException -> L12
        if (r4.isConnected() == false) goto L14;
        this.mPort = r6[r1];     // Catch: RemoteException -> L12
        this.mPortStatus = r4;     // Catch: RemoteException -> L12
        return;
    L14:
        r1 = r1 + 1;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L15:
        return;
    L5:
        r2 = r0.getBooleanExtra("unlocked", false);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static UsbPort[] getPorts(UsbManager r1) {
        List r2 = r1.getPorts();
        if ((r2 instanceof UsbPort[]) == false) goto L7;
        return (UsbPort[]) r2;
    L7:
        if ((r2 instanceof List) == false) goto L11;
        return (UsbPort[]) r2.toArray(new UsbPort[r2.size()]);
    L11:
        return new UsbPort[1];
    }

    public int getCurrentMode() {
        if (this.mPort == null) goto L11;
        if (this.mPortStatus.getCurrentPowerRole() != getPowerRoleSource()) goto L7;
        boolean r0 = true;
    L8:
        if (r0 != true) goto L11;
        return 1;
    L7:
        r0 = false;
    L11:
        return getUsbDataMode() | 0;
    }

    public int getCurrentDataMode() {
        return getUsbDataMode() | 0;
    }

    public int getUsbDataMode() {
        if (this.mTetheringEnabled == false) goto L9;
        if (this.mUsbManager.isFunctionEnabled("rndis") == false) goto L9;
        return 8;
    L9:
        if (this.mIsUnlocked == true) goto L22;
        if (MultiSDKAdapter.isChargingUsbFunction(this.mUsbManager) == false) goto L14;
        return 0;
    L14:
        if (this.mUsbManager.isFunctionEnabled("midi") == false) goto L17;
        return 6;
    L17:
        if (this.mUsbManager.isFunctionEnabled("audio_source") == false) goto L20;
        return 10;
    L20:
        return getDefaultFunctions();
    L22:
        if (this.mUsbManager.isFunctionEnabled("mtp") == false) goto L26;
        return 2;
    L26:
        if (this.mUsbManager.isFunctionEnabled("ptp") == false) goto L30;
        return 4;
    L30:
        if (this.mUsbManager.isFunctionEnabled("midi") == false) goto L33;
        return 6;
    L33:
        if (this.mUsbManager.isFunctionEnabled("audio_source") == false) goto L35;
        return 10;
    L35:
        return 0;
    }

    private int getDefaultFunctions() {
        String r0 = SystemProperties.get("persist.sys.usb.config", "none");
        if ("none".equals(r0) == false) goto L5;
        return 2;
    L5:
        if (MultiSDKAdapter.containsUsbFunction(this.mUsbManager, r0, "mtp") == true) goto L11;
        return 0;
    L11:
        return 2;
    }

    private void setUsbFunction(int r4) {
        OLog.d(this.TAG, "setUsbFunction mode " + r4);
        if (r4 != 2) goto L5;
        Utils.setUsbCurrentFunction(this.mUsbManager, "mtp", true);
        return;
    L5:
        if (r4 != 4) goto L7;
        Utils.setUsbCurrentFunction(this.mUsbManager, "ptp", true);
        return;
    L7:
        if (r4 != 6) goto L9;
        Utils.setUsbCurrentFunction(this.mUsbManager, "midi", true);
        return;
    L9:
        if (r4 != 8) goto L11;
        return;
    L11:
        if (r4 == 10) goto L13;
        Utils.setUsbCurrentFunction(this.mUsbManager, "none", true);
        return;
    L13:
        Utils.setUsbCurrentFunction(this.mUsbManager, "audio_source", true);
    }

    public void setMode(int r5) {
        if (this.mPort == null) goto L14;
        int r0 = modeToPower(r5);
        if ((r5 & 14) == 0) goto L7;
    L9:
        int r1 = getDataRoleDevice();
    L16:
        this.mUsbManagerService.setPortRoles(this.mPort.getId(), r0, r1);     // Catch: RemoteException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L7:
        if (this.mPortStatus.isRoleCombinationSupported(r0, getDataRoleHost()) == false) goto L9;
        r1 = getDataRoleHost();
    L14:
        setUsbFunction(r5 & 14);
    }

    public void setPowerMode(int r2) {
        int r3 = modeToPower(r2);
        if (getPowerRole() == r3) goto L6;
        setPowerRole(r3);
        return;
    }

    public void setDataMode(int r1) {
        setUsbFunction(r1 & 14);
    }

    private int modeToPower(int r1) {
        if (r1 != 1) goto L6;
        return getPowerRoleSource();
    L6:
        return getPowerRoleSink();
    }

    public boolean isModeDisallowed(int r1) {
        if (this.mRestricted == false) goto L10;
        int r0 = r1 & 14;
        if (r0 != 0) goto L7;
        return false;
    L7:
        if (r0 == 6) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public boolean isModeDisallowedBySystem(int r1) {
        if (this.mRestrictedBySystem == false) goto L10;
        int r0 = r1 & 14;
        if (r0 != 0) goto L7;
        return false;
    L7:
        if (r0 == 6) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public boolean isModeSupported(int r5) {
        if (this.mMidi == true) goto L8;
        if ((r5 & 14) != 6) goto L8;
        return false;
    L8:
        if (this.mPort == null) goto L20;
        int r0 = modeToPower(r5);
        if ((r5 & 14) == 0) goto L14;
        return this.mPortStatus.isRoleCombinationSupported(r0, getDataRoleDevice());
    L14:
        if (this.mPortStatus.isRoleCombinationSupported(r0, getDataRoleDevice()) == true) goto L18;
        if (this.mPortStatus.isRoleCombinationSupported(r0, getDataRoleHost()) == true) goto L18;
        return false;
    L18:
        return true;
    L20:
        if ((r5 & 1) != 1) goto L22;
        return false;
    L22:
        return true;
    }

    public boolean areAllRolesSupported() {
        if (this.mPort == null) goto L15;
        UsbPortStatus r0 = this.mPortStatus;
        if (r0 == null) goto L15;
        if (r0.isRoleCombinationSupported(2, 2) == false) goto L15;
        if (this.mPortStatus.isRoleCombinationSupported(2, 1) == false) goto L15;
        if (this.mPortStatus.isRoleCombinationSupported(1, 2) == false) goto L15;
        if (this.mPortStatus.isRoleCombinationSupported(1, 1) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public boolean isModeDisplaySupported(int r2) {
        if (r2 == 1) goto L5;
        return true;
    L5:
        return areAllRolesSupported();
    }

    private void updatePorts() {
        this.mPort = null;
        this.mPortStatus = null;
        List r0 = this.mUsbManager.getPorts();
        int r1 = r0.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        UsbPortStatus r3 = ((UsbPort) r0.get(r2)).getStatus();
        if (r3.isConnected() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        this.mPort = (UsbPort) r0.get(r2);
        this.mPortStatus = r3;
        return;
    }

    public int getDataRole() {
        updatePorts();
        UsbPortStatus r0 = this.mPortStatus;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getCurrentDataRole();
    }

    public void setPowerRole(int r3) {
        int r0 = getDataRole();
        if (areAllRolesSupported() == true) goto L9;
        r0 = 1;
        if (r3 == 1) goto L9;
        r0 = 2;
        if (r3 == 2) goto L9;
        r0 = 0;
    L9:
        UsbPort r2 = this.mPort;
        if (r2 == null) goto L13;
        r2.setRoles(r3, r0);
        return;
    }

    public int getPowerRole() {
        updatePorts();
        UsbPortStatus r0 = this.mPortStatus;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getCurrentPowerRole();
    }

    public void setDataRole(int r3) {
        int r0 = getPowerRole();
        if (areAllRolesSupported() == true) goto L9;
        r0 = 1;
        if (r3 == 1) goto L9;
        r0 = 2;
        if (r3 == 2) goto L9;
        r0 = 0;
    L9:
        UsbPort r2 = this.mPort;
        if (r2 == null) goto L13;
        r2.setRoles(r0, r3);
        return;
    }
}
