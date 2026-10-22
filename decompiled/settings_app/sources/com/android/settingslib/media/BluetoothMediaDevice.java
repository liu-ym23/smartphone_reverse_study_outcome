package com.android.settingslib.media;

import android.bluetooth.BluetoothClass;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaRoute2Info;
import android.media.RouteListingPreference;
import com.android.settingslib.R;
import com.android.settingslib.bluetooth.BluetoothUtils;
import com.android.settingslib.bluetooth.CachedBluetoothDevice;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothMediaDevice extends MediaDevice {
    private static final String TAG = "BluetoothMediaDevice";
    private final AudioManager mAudioManager;
    private final CachedBluetoothDevice mCachedDevice;

    @Override // com.android.settingslib.media.MediaDevice
    public int getSelectionBehavior() {
        return 1;
    }

    BluetoothMediaDevice(Context r1, CachedBluetoothDevice r2, MediaRoute2Info r3, RouteListingPreference.Item r4) {
        super(r1, r3, r4);
        this.mCachedDevice = r2;
        this.mAudioManager = (AudioManager) r1.getSystemService(AudioManager.class);
        initDeviceRecord();
    }

    @Override // com.android.settingslib.media.MediaDevice
    public String getName() {
        return this.mCachedDevice.getName();
    }

    @Override // com.android.settingslib.media.MediaDevice
    public String getSummary() {
        if (isConnected() == true) goto L9;
        if (this.mCachedDevice.isBusy() == true) goto L9;
        return this.mContext.getString(R.string.bluetooth_disconnected);
    L9:
        return this.mCachedDevice.getConnectionSummary();
    }

    @Override // com.android.settingslib.media.MediaDevice
    public CharSequence getSummaryForTv(int r2) {
        if (isConnected() == true) goto L9;
        if (this.mCachedDevice.isBusy() == true) goto L9;
        return this.mContext.getString(R.string.bluetooth_saved_device);
    L9:
        return this.mCachedDevice.getTvConnectionSummary(r2);
    }

    @Override // com.android.settingslib.media.MediaDevice
    public Drawable getIcon() {
        if (BluetoothUtils.isAdvancedUntetheredDevice(this.mCachedDevice.getDevice()) == false) goto L6;
        return this.mContext.getDrawable(R.drawable.ic_earbuds_advanced);
    L6:
        return (Drawable) BluetoothUtils.getBtClassDrawableWithDescription(this.mContext, this.mCachedDevice).first;
    }

    @Override // com.android.settingslib.media.MediaDevice
    public Drawable getIconWithoutBackground() {
        if (BluetoothUtils.isAdvancedUntetheredDevice(this.mCachedDevice.getDevice()) == false) goto L6;
        return this.mContext.getDrawable(R.drawable.ic_earbuds_advanced);
    L6:
        return (Drawable) BluetoothUtils.getBtClassDrawableWithDescription(this.mContext, this.mCachedDevice).first;
    }

    @Override // com.android.settingslib.media.MediaDevice
    public String getId() {
        if (this.mCachedDevice.isHearingAidDevice() == false) goto L9;
        if (this.mCachedDevice.getHiSyncId() == 0) goto L9;
        return Long.toString(this.mCachedDevice.getHiSyncId());
    L9:
        return this.mCachedDevice.getAddress();
    }

    public CachedBluetoothDevice getCachedDevice() {
        return this.mCachedDevice;
    }

    @Override // com.android.settingslib.media.MediaDevice
    protected boolean isCarKitDevice() {
        BluetoothClass r1 = this.mCachedDevice.getDevice().getBluetoothClass();
        if (r1 == null) goto L11;
        int r2 = r1.getDeviceClass();
        if (r2 != 1032) goto L7;
        return true;
    L7:
        if (r2 != 1056) goto L14;
        return true;
    L14:
        return false;
    L11:
        return false;
    }

    @Override // com.android.settingslib.media.MediaDevice
    public boolean isFastPairDevice() {
        CachedBluetoothDevice r1 = this.mCachedDevice;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (BluetoothUtils.getBooleanMetaData(r1.getDevice(), 6) == false) goto L7;
        return true;
    }

    @Override // com.android.settingslib.media.MediaDevice
    public boolean isMutingExpectedDevice() {
        if (this.mAudioManager.getMutingExpectedDevice() != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mCachedDevice.getAddress().equals(this.mAudioManager.getMutingExpectedDevice().getAddress()) == false) goto L7;
        return true;
    }

    @Override // com.android.settingslib.media.MediaDevice
    public boolean isConnected() {
        if (this.mCachedDevice.getBondState() == 12) goto L5;
    L7:
        return false;
    L5:
        if (this.mCachedDevice.isConnected() == false) goto L7;
        return true;
    }
}
