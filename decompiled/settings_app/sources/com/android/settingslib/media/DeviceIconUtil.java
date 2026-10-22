package com.android.settingslib.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemProperties;
import android.util.SparseIntArray;
import com.android.settingslib.R;
import com.android.settingslib.media.flags.Flags;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class DeviceIconUtil {
    private static final SparseIntArray AUDIO_DEVICE_TO_MEDIA_ROUTE_TYPE = null;
    private final Context mContext;
    private final boolean mIsTablet;
    private final boolean mIsTv;

    static {
        SparseIntArray r0 = new SparseIntArray();
        AUDIO_DEVICE_TO_MEDIA_ROUTE_TYPE = r0;
        r0.put(11, 11);
        r0.put(22, 22);
        r0.put(12, 12);
        r0.put(13, 13);
        r0.put(9, 9);
        r0.put(10, 10);
        r0.put(29, 29);
        r0.put(3, 3);
        r0.put(4, 4);
        r0.put(2, 2);
    }

    public DeviceIconUtil(Context r2) {
        Context r3 = (Context) Objects.requireNonNull(r2);
        this.mContext = r3;
        if (r3.getPackageManager().hasSystemFeature("android.software.leanback") == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        this.mIsTv = r4;
        this.mIsTablet = Arrays.asList(SystemProperties.get("ro.build.characteristics").split(",")).contains("tablet");
        return;
    L5:
        if (Flags.enableTvMediaOutputDialog() == false) goto L7;
        r4 = true;
        goto L8
    }

    DeviceIconUtil(boolean r2) {
        this.mContext = null;
        this.mIsTv = r2;
        this.mIsTablet = false;
    }

    public Drawable getIconFromAudioDeviceType(int r2) {
        return this.mContext.getDrawable(getIconResIdFromAudioDeviceType(r2));
    }

    public int getIconResIdFromAudioDeviceType(int r3) {
        return getIconResIdFromMediaRouteType(AUDIO_DEVICE_TO_MEDIA_ROUTE_TYPE.get(r3, -1));
    }

    public int getIconResIdFromMediaRouteType(int r2) {
        if (this.mIsTv == false) goto L6;
        return getIconResourceIdForTv(r2);
    L6:
        return getIconResourceIdForPhoneOrTablet(r2, this.mIsTablet);
    }

    private static int getIconResourceIdForPhoneOrTablet(int r1, boolean r2) {
        if (r2 == false) goto L4;
        int r3 = R.drawable.ic_media_tablet;
    L6:
        if (r1 == 3) goto L20;
        if (r1 == 4) goto L20;
        if (r1 == 22) goto L20;
        if (r1 == 29) goto L18;
        switch(r1) {
            case 9: goto L18;
            case 10: goto L18;
            case 11: goto L20;
            case 12: goto L20;
            case 13: goto L16;
            default: goto L14;
        };
    L14:
        return r3;
    L16:
        return R.drawable.ic_dock_device;
    L18:
        return R.drawable.ic_external_display;
    L20:
        return R.drawable.ic_headphone;
    L4:
        r3 = R.drawable.ic_smartphone;
        goto L6
    }

    private static int getIconResourceIdForTv(int r1) {
        if (r1 == 2) goto L26;
        if (r1 == 3) goto L24;
        if (r1 == 4) goto L24;
        if (r1 == 22) goto L22;
        if (r1 == 29) goto L20;
        switch(r1) {
            case 9: goto L26;
            case 10: goto L20;
            case 11: goto L22;
            case 12: goto L18;
            case 13: goto L16;
            default: goto L14;
        };
    L14:
        return R.drawable.ic_media_speaker_device;
    L16:
        return R.drawable.ic_dock_device;
    L18:
        return R.drawable.ic_usb;
    L20:
        return R.drawable.ic_hdmi;
    L22:
        return R.drawable.ic_headphone;
    L24:
        return R.drawable.ic_wired_device;
    L26:
        return R.drawable.ic_tv;
    }
}
