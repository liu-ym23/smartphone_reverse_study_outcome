package com.android.settingslib.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaRoute2Info;
import android.media.NearbyDevice;
import android.media.RouteListingPreference;
import android.os.Build;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.settingslib.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediaDevice implements Comparable<MediaDevice> {
    private static final String TAG = "MediaDevice";
    private int mConnectedRecord;
    protected final Context mContext;
    protected final RouteListingPreference.Item mItem;
    private int mRangeZone;
    protected final MediaRoute2Info mRouteInfo;
    private int mState;
    int mType;

    private static class Api34Impl {
        private Api34Impl() {
        }

        static boolean isHostForOngoingSession(RouteListingPreference.Item r2) {
            if (r2 == null) goto L5;
            int r3 = r2.getFlags();
        L7:
            if ((r3 & 1) != 0) goto L9;
            return false;
        L9:
            if ((r3 & 2) == 0) goto L13;
            return true;
        L13:
            return false;
        L5:
            r3 = 0;
            goto L7
        }

        static boolean isSuggestedDevice(RouteListingPreference.Item r0) {
            if (r0 != null) goto L4;
        L6:
            return false;
        L4:
            if ((r0.getFlags() & 4) == 0) goto L6;
            return true;
        }

        static boolean hasOngoingSession(RouteListingPreference.Item r1) {
            if (r1 != null) goto L4;
        L6:
            return false;
        L4:
            if ((r1.getFlags() & 1) == 0) goto L6;
            return true;
        }

        static String composeSubtext(RouteListingPreference.Item r2, Context r3) {
            int r0 = r2.getSubText();
            if (r0 == 10000) goto L22;
            switch(r0) {
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L12;
                case 6: goto L10;
                case 7: goto L8;
                default: goto L5;
            };
        L5:
            return "";
        L8:
            return r3.getString(R.string.media_output_status_track_unsupported);
        L10:
            return r3.getString(R.string.media_output_status_unauthorized);
        L12:
            return r3.getString(R.string.media_output_status_device_in_low_power_mode);
        L14:
            return r3.getString(R.string.media_output_status_try_after_ad);
        L16:
            return r3.getString(R.string.media_output_status_not_support_downloads);
        L18:
            return r3.getString(R.string.media_output_status_require_premium);
        L20:
            return r3.getString(R.string.media_output_status_unknown_error);
        L22:
            return (String) r2.getCustomSubtextMessage();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaDeviceType {
        public static final int TYPE_3POINT5_MM_AUDIO_DEVICE = 3;
        public static final int TYPE_BLUETOOTH_DEVICE = 5;
        public static final int TYPE_CAST_DEVICE = 6;
        public static final int TYPE_CAST_GROUP_DEVICE = 7;
        public static final int TYPE_FAST_PAIR_BLUETOOTH_DEVICE = 4;
        public static final int TYPE_PHONE_DEVICE = 1;
        public static final int TYPE_REMOTE_AUDIO_VIDEO_RECEIVER = 8;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_USB_C_AUDIO_DEVICE = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SelectionBehavior {
        public static final int SELECTION_BEHAVIOR_GO_TO_APP = 2;
        public static final int SELECTION_BEHAVIOR_NONE = 0;
        public static final int SELECTION_BEHAVIOR_TRANSFER = 1;
    }

    public abstract Drawable getIcon();

    public abstract Drawable getIconWithoutBackground();

    public abstract String getId();

    public abstract String getName();

    public abstract String getSummary();

    protected boolean isCarKitDevice() {
        return false;
    }

    public abstract boolean isConnected();

    protected boolean isFastPairDevice() {
        return false;
    }

    public boolean isMutingExpectedDevice() {
        return false;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MediaDevice r1) {
        return compareTo2(r1);
    }

    MediaDevice(Context r2, MediaRoute2Info r3, RouteListingPreference.Item r4) {
        this.mRangeZone = 0;
        this.mContext = r2;
        this.mRouteInfo = r3;
        this.mItem = r4;
        setType(r3);
    }

    private void setType(MediaRoute2Info r5) {
        if (r5 != null) goto L6;
        this.mType = 5;
        return;
    L6:
        int r6 = r5.getType();
        if (r6 != 2) goto L9;
        this.mType = 1;
        return;
    L9:
        if (r6 != 3) goto L11;
    L30:
        this.mType = 3;
        return;
    L11:
        if (r6 == 4) goto L30;
        if (r6 != 22) goto L15;
    L29:
        this.mType = 2;
        return;
    L15:
        if (r6 != 23) goto L17;
    L28:
        this.mType = 5;
        return;
    L17:
        if (r6 == 26) goto L28;
        if (r6 == 29) goto L29;
        if (r6 != 1003) goto L23;
        this.mType = 8;
        return;
    L23:
        if (r6 == 2000) goto L26;
        switch(r6) {
            case 8: goto L28;
            case 9: goto L29;
            case 10: goto L29;
            case 11: goto L29;
            case 12: goto L29;
            case 13: goto L29;
            default: goto L25;
        };
    L25:
        this.mType = 6;
        return;
    L26:
        this.mType = 7;
    }

    void initDeviceRecord() {
        ConnectionRecordManager.getInstance().fetchLastSelectedDevice(this.mContext);
        this.mConnectedRecord = ConnectionRecordManager.getInstance().fetchConnectionRecord(this.mContext, getId());
    }

    public int getRangeZone() {
        return this.mRangeZone;
    }

    public void setRangeZone(int r1) {
        this.mRangeZone = r1;
    }

    public CharSequence getSummaryForTv(int r1) {
        return getSummary();
    }

    public int getSelectionBehavior() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        RouteListingPreference.Item r2 = this.mItem;
        if (r2 == null) goto L7;
        return r2.getSelectionBehavior();
    L7:
        return 1;
    }

    public boolean hasSubtext() {
        if (Build.VERSION.SDK_INT < 34) goto L9;
        RouteListingPreference.Item r2 = this.mItem;
        if (r2 == null) goto L9;
        if (r2.getSubText() == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public int getSubtext() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        RouteListingPreference.Item r2 = this.mItem;
        if (r2 == null) goto L7;
        return r2.getSubText();
    L7:
        return 0;
    }

    public String getSubtextString() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        RouteListingPreference.Item r0 = this.mItem;
        if (r0 == null) goto L7;
        return Api34Impl.composeSubtext(r0, this.mContext);
    L7:
        return null;
    }

    public boolean hasOngoingSession() {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
    L7:
        return false;
    L5:
        if (Api34Impl.hasOngoingSession(this.mItem) == false) goto L7;
        return true;
    }

    public boolean isHostForOngoingSession() {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
    L7:
        return false;
    L5:
        if (Api34Impl.isHostForOngoingSession(this.mItem) == false) goto L7;
        return true;
    }

    public boolean isSuggestedDevice() {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
    L7:
        return false;
    L5:
        if (Api34Impl.isSuggestedDevice(this.mItem) == false) goto L7;
        return true;
    }

    void setConnectedRecord() {
        this.mConnectedRecord++;
        ConnectionRecordManager.getInstance().setConnectionRecord(this.mContext, getId(), this.mConnectedRecord);
    }

    public int getMaxVolume() {
        MediaRoute2Info r1 = this.mRouteInfo;
        if (r1 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Unable to get max volume. RouteInfo is empty");
        return 0;
    L7:
        return r1.getVolumeMax();
    }

    public int getCurrentVolume() {
        MediaRoute2Info r1 = this.mRouteInfo;
        if (r1 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Unable to get current volume. RouteInfo is empty");
        return 0;
    L7:
        return r1.getVolume();
    }

    public String getClientPackageName() {
        MediaRoute2Info r1 = this.mRouteInfo;
        if (r1 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Unable to get client package name. RouteInfo is empty");
        return null;
    L7:
        return r1.getClientPackageName();
    }

    public boolean isBLEDevice() {
        if (this.mRouteInfo.getType() != 26) goto L5;
        return true;
    L5:
        return false;
    }

    public int getDeviceType() {
        return this.mType;
    }

    public boolean isVolumeFixed() {
        MediaRoute2Info r2 = this.mRouteInfo;
        if (r2 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "RouteInfo is empty, regarded as volume fixed.");
        return true;
    L7:
        if (r2.getVolumeHandling() == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public void setState(int r1) {
        this.mState = r1;
    }

    public int getState() {
        return this.mState;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MediaDevice r5) {
        if (r5 != null) goto L6;
        return -1;
    L6:
        if ((isConnected() ^ r5.isConnected()) == false) goto L12;
        if (isConnected() == false) goto L10;
        return -1;
    L10:
        return 1;
    L12:
        if (getState() != 4) goto L15;
        return -1;
    L15:
        if (r5.getState() != 4) goto L17;
        return 1;
    L17:
        int r1 = this.mType;
        int r3 = r5.mType;
        if (r1 == r3) goto L20;
        if (r1 >= r3) goto L58;
        return -1;
    L58:
        return 1;
    L20:
        if (isMutingExpectedDevice() == false) goto L23;
        return -1;
    L23:
        if (r5.isMutingExpectedDevice() == false) goto L26;
        return 1;
    L26:
        if (isFastPairDevice() == false) goto L29;
        return -1;
    L29:
        if (r5.isFastPairDevice() == false) goto L32;
        return 1;
    L32:
        if (isCarKitDevice() == false) goto L35;
        return -1;
    L35:
        if (r5.isCarKitDevice() == false) goto L38;
        return 1;
    L38:
        if (NearbyDevice.compareRangeZones(getRangeZone(), r5.getRangeZone()) != 0) goto L40;
        String r2 = ConnectionRecordManager.getInstance().getLastSelectedDevice();
        if (TextUtils.equals(r2, getId()) == false) goto L45;
        return -1;
    L45:
        if (TextUtils.equals(r2, r5.getId()) == false) goto L47;
        return 1;
    L47:
        int r0 = this.mConnectedRecord;
        int r4 = r5.mConnectedRecord;
        if (r0 == r4) goto L54;
        if (r4 > 0) goto L52;
        if (r0 <= 0) goto L54;
    L52:
        return r4 - r0;
    L54:
        return getName().compareToIgnoreCase(r5.getName());
    L40:
        return NearbyDevice.compareRangeZones(getRangeZone(), r5.getRangeZone());
    }

    public List<String> getFeatures() {
        MediaRoute2Info r1 = this.mRouteInfo;
        if (r1 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Unable to get features. RouteInfo is empty");
        return new ArrayList();
    L7:
        return r1.getFeatures();
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof MediaDevice) == true) goto L7;
        return false;
    L7:
        return ((MediaDevice) r2).getId().equals(getId());
    }
}
