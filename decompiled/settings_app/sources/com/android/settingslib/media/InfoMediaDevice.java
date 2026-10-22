package com.android.settingslib.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaRoute2Info;
import android.media.RouteListingPreference;
import com.android.settingslib.R;

/* JADX INFO: loaded from: classes.dex */
public class InfoMediaDevice extends MediaDevice {
    private static final String TAG = "InfoMediaDevice";

    @Override // com.android.settingslib.media.MediaDevice
    public boolean isConnected() {
        return true;
    }

    InfoMediaDevice(Context r1, MediaRoute2Info r2, RouteListingPreference.Item r3) {
        super(r1, r2, r3);
        initDeviceRecord();
    }

    @Override // com.android.settingslib.media.MediaDevice
    public String getName() {
        return this.mRouteInfo.getName().toString();
    }

    @Override // com.android.settingslib.media.MediaDevice
    public String getSummary() {
        if (this.mRouteInfo.getClientPackageName() != null) goto L7;
        return null;
    L7:
        return this.mContext.getString(R.string.bluetooth_active_no_battery_level);
    }

    @Override // com.android.settingslib.media.MediaDevice
    public Drawable getIcon() {
        return getIconWithoutBackground();
    }

    @Override // com.android.settingslib.media.MediaDevice
    public Drawable getIconWithoutBackground() {
        return this.mContext.getDrawable(getDrawableResIdByType());
    }

    int getDrawableResIdByType() {
        int r1 = this.mRouteInfo.getType();
        if (r1 == 1001) goto L17;
        if (r1 == 2000) goto L26;
        switch(r1) {
            case 1004: goto L25;
            case 1005: goto L24;
            case 1006: goto L23;
            case 1007: goto L22;
            case 1008: goto L21;
            case 1009: goto L20;
            case 1010: goto L19;
            default: goto L18;
        };
    L18:
        return R.drawable.ic_media_speaker_device;
    L19:
        return R.drawable.ic_smartphone;
    L20:
        return R.drawable.ic_media_smartwatch;
    L21:
        return R.drawable.ic_media_car;
    L22:
        return R.drawable.ic_media_game_console;
    L23:
        return R.drawable.ic_media_computer;
    L24:
        return R.drawable.ic_dock_device;
    L25:
        return R.drawable.ic_media_tablet;
    L26:
        return R.drawable.ic_media_group_device;
    L17:
        return R.drawable.ic_media_display_device;
    }

    @Override // com.android.settingslib.media.MediaDevice
    public String getId() {
        return this.mRouteInfo.getId();
    }
}
