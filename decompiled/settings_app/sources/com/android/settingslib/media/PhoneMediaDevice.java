package com.android.settingslib.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.hardware.hdmi.HdmiControlManager;
import android.hardware.hdmi.HdmiDeviceInfo;
import android.hardware.hdmi.HdmiPortInfo;
import android.media.MediaRoute2Info;
import android.media.RouteListingPreference;
import android.os.SystemProperties;
import com.GlobalProxyLancet;
import com.android.settingslib.R;
import com.android.settingslib.media.flags.Flags;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class PhoneMediaDevice extends MediaDevice {
    public static final String PHONE_ID = "phone_media_device_id";
    private static final String TAG = "PhoneMediaDevice";
    public static final String USB_HEADSET_ID = "usb_headset_media_device_id";
    public static final String WIRED_HEADSET_ID = "wired_headset_media_device_id";
    private final DeviceIconUtil mDeviceIconUtil;
    private String mSummary;

    @Override // com.android.settingslib.media.MediaDevice
    public int getSelectionBehavior() {
        return 1;
    }

    @Override // com.android.settingslib.media.MediaDevice
    public boolean isConnected() {
        return true;
    }

    public static String getMediaTransferThisDeviceName(Context r1) {
        if (isTv(r1) == false) goto L7;
        return r1.getString(R.string.media_transfer_this_device_name_tv);
    L7:
        if (isTablet() == false) goto L11;
        return r1.getString(R.string.media_transfer_this_device_name_tablet);
    L11:
        return r1.getString(R.string.media_transfer_this_device_name);
    }

    public static String getSystemRouteNameFromType(Context r2, MediaRoute2Info r3) {
        boolean r0 = isTv(r2);
        int r4 = r3.getType();
        if (r4 != 2) goto L5;
        String r5 = getMediaTransferThisDeviceName(r2);
    L28:
        return r5.toString();
    L5:
        if (r4 != 3) goto L7;
    L25:
        r5 = r2.getString(R.string.media_transfer_wired_usb_device_name);
        goto L28
    L7:
        if (r4 == 4) goto L25;
        if (r4 == 22) goto L25;
        if (r4 == 29) goto L19;
        switch(r4) {
            case 9: goto L15;
            case 10: goto L19;
            case 11: goto L25;
            case 12: goto L25;
            case 13: goto L14;
            default: goto L13;
        };
    L13:
        r5 = r2.getString(R.string.media_transfer_default_device_name);
        goto L28
    L14:
        r5 = r2.getString(R.string.media_transfer_dock_speaker_device_name);
        goto L28
    L15:
        if (r0 == false) goto L17;
        int r6 = R.string.tv_media_transfer_default;
    L18:
        r5 = r2.getString(r6);
        goto L28
    L17:
        r6 = R.string.media_transfer_external_device_name;
    L19:
        if (r0 == false) goto L24;
        String r7 = getHdmiOutDeviceName(r2);
        if (r7 == null) goto L23;
        r5 = r7;
        goto L28
    L23:
        r5 = r2.getString(R.string.tv_media_transfer_arc_fallback_title);
        goto L28
    L24:
        r5 = r2.getString(R.string.media_transfer_external_device_name);
        goto L28
    }

    PhoneMediaDevice(Context r1, MediaRoute2Info r2, RouteListingPreference.Item r3) {
        super(r1, r2, r3);
        this.mSummary = "";
        this.mDeviceIconUtil = new DeviceIconUtil(this.mContext);
        initDeviceRecord();
    }

    static boolean isTv(Context r1) {
        if (r1.getPackageManager().hasSystemFeature("android.software.leanback") == true) goto L5;
    L7:
        return false;
    L5:
        if (Flags.enableTvMediaOutputDialog() == false) goto L7;
        return true;
    }

    static boolean isTablet() {
        return Arrays.asList(SystemProperties.get("ro.build.characteristics").split(",")).contains("tablet");
    }

    @Override // com.android.settingslib.media.MediaDevice
    public String getName() {
        return getSystemRouteNameFromType(this.mContext, this.mRouteInfo);
    }

    private static String getHdmiOutDeviceName(Context r5) {
        if (r5.checkCallingOrSelfPermission("android.permission.HDMI_CEC") != 0) goto L24;
        HdmiControlManager r6 = (HdmiControlManager) r5.getSystemService(HdmiControlManager.class);
        Iterator r0 = r6.getPortInfo().iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        HdmiPortInfo r2 = (HdmiPortInfo) r0.next();
        if (r2.getType() != 1) goto L6;
    L11:
        if (r2 != null) goto L13;
        return null;
    L13:
        Iterator r7 = r6.getConnectedDevices().iterator();
    L15:
        if (r7.hasNext() == false) goto L23;
        HdmiDeviceInfo r1 = (HdmiDeviceInfo) r7.next();
        if (r1.getPortId() != r2.getId()) goto L15;
        String r3 = r1.getDisplayName();
        if (r3 == null) goto L15;
        if (r3.isEmpty() == true) goto L15;
        return r3;
    L23:
        return null;
    L10:
        r2 = null;
        goto L11
    L24:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Could not get HDMI device name, android.permission.HDMI_CEC denied");
        return null;
    }

    @Override // com.android.settingslib.media.MediaDevice
    public String getSummary() {
        if (isTv(this.mContext) == false) goto L5;
        int r0 = this.mRouteInfo.getType();
        if (r0 == 2) goto L31;
        if (r0 == 29) goto L25;
        if (r0 == 9) goto L23;
        if (r0 == 10) goto L17;
        return null;
    L17:
        if (getHdmiOutDeviceName(this.mContext) != null) goto L21;
        return this.mContext.getString(R.string.tv_media_transfer_connected);
    L21:
        return this.mContext.getString(R.string.tv_media_transfer_arc_subtitle);
    L23:
        return this.mContext.getString(R.string.tv_media_transfer_hdmi);
    L25:
        if (getHdmiOutDeviceName(this.mContext) != null) goto L29;
        return this.mContext.getString(R.string.tv_media_transfer_connected);
    L29:
        return this.mContext.getString(R.string.tv_media_transfer_earc_subtitle);
    L31:
        return this.mContext.getString(R.string.tv_media_transfer_internal_speakers);
    L5:
        return this.mSummary;
    }

    @Override // com.android.settingslib.media.MediaDevice
    public Drawable getIcon() {
        return getIconWithoutBackground();
    }

    @Override // com.android.settingslib.media.MediaDevice
    public Drawable getIconWithoutBackground() {
        return this.mContext.getDrawable(getDrawableResId());
    }

    int getDrawableResId() {
        return this.mDeviceIconUtil.getIconResIdFromMediaRouteType(this.mRouteInfo.getType());
    }

    @Override // com.android.settingslib.media.MediaDevice
    public String getId() {
        if (com.android.media.flags.Flags.enableAudioPoliciesDeviceAndBluetoothController() == true) goto L5;
        int r1 = this.mRouteInfo.getType();
        if (r1 != 3) goto L9;
    L17:
        return WIRED_HEADSET_ID;
    L9:
        if (r1 == 4) goto L17;
        if (r1 != 22) goto L13;
    L16:
        return USB_HEADSET_ID;
    L13:
        if (r1 == 29) goto L16;
        switch(r1) {
            case 9: goto L16;
            case 10: goto L16;
            case 11: goto L16;
            case 12: goto L16;
            case 13: goto L16;
            default: goto L15;
        };
    L15:
        return PHONE_ID;
    L5:
        return this.mRouteInfo.getId();
    }

    public void updateSummary(boolean r2) {
        if (r2 == false) goto L4;
        String r3 = this.mContext.getString(R.string.bluetooth_active_no_battery_level);
    L5:
        this.mSummary = r3;
        return;
    L4:
        r3 = "";
        goto L5
    }
}
