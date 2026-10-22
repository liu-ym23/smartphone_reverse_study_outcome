package com.android.settingslib.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaRoute2Info;
import android.media.RouteListingPreference;
import com.android.settingslib.R;

/* JADX INFO: loaded from: classes.dex */
public class ComplexMediaDevice extends MediaDevice {
    private final String mSummary;

    @Override // com.android.settingslib.media.MediaDevice
    public String getSummary() {
        return "";
    }

    @Override // com.android.settingslib.media.MediaDevice
    public boolean isConnected() {
        return true;
    }

    ComplexMediaDevice(Context r1, MediaRoute2Info r2, RouteListingPreference.Item r3) {
        super(r1, r2, r3);
        this.mSummary = "";
    }

    @Override // com.android.settingslib.media.MediaDevice
    public String getName() {
        return this.mRouteInfo.getName().toString();
    }

    @Override // com.android.settingslib.media.MediaDevice
    public Drawable getIcon() {
        return this.mContext.getDrawable(R.drawable.ic_media_avr_device);
    }

    @Override // com.android.settingslib.media.MediaDevice
    public Drawable getIconWithoutBackground() {
        return this.mContext.getDrawable(R.drawable.ic_media_avr_device);
    }

    @Override // com.android.settingslib.media.MediaDevice
    public String getId() {
        return this.mRouteInfo.getId();
    }
}
