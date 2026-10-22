package com.android.settings.slices;

import android.net.Uri;
import android.util.ArrayMap;
import com.android.settings.wifi.calling.WifiCallingSliceHelper;
import com.android.settings.wifi.slice.WifiSlice;
import com.android.settingslib.media.MediaOutputConstants;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CustomSliceRegistry {
    public static final Uri ALWAYS_ON_SLICE_URI = null;
    public static final Uri BLUETOOTH_DEVICES_SLICE_URI = null;
    public static final Uri BLUETOOTH_URI = null;
    public static final Uri CONTEXTUAL_ADAPTIVE_SLEEP_URI = null;
    public static final Uri DARK_THEME_SLICE_URI = null;
    public static final Uri ENHANCED_4G_SLICE_URI = null;
    public static final Uri FACE_ENROLL_SLICE_URI = null;
    public static final Uri FLASHLIGHT_SLICE_URI = null;
    public static final Uri LOCATION_SLICE_URI = null;
    public static final Uri LOW_STORAGE_SLICE_URI = null;
    public static Uri MEDIA_OUTPUT_INDICATOR_SLICE_URI;
    public static final Uri MOBILE_DATA_SLICE_URI = null;
    public static final Uri NFC_SLICE_URI = null;
    public static final Uri PROVIDER_MODEL_SLICE_URI = null;
    public static Uri REMOTE_MEDIA_SLICE_URI;
    public static final Uri VOLUME_ALARM_URI = null;
    public static final Uri VOLUME_CALL_URI = null;
    public static final Uri VOLUME_MEDIA_URI = null;
    public static final Uri VOLUME_NOTIFICATION_URI = null;
    public static final Uri VOLUME_SEPARATE_RING_URI = null;
    public static final Uri VOLUME_SLICES_URI = null;
    public static final Uri WIFI_CALLING_PREFERENCE_URI = null;
    public static final Uri WIFI_CALLING_URI = null;
    public static final Uri WIFI_SLICE_URI = null;
    public static final Uri ZEN_MODE_SLICE_URI = null;
    static final Map<Uri, Class<? extends CustomSliceable>> sUriToSlice = null;

    public CustomSliceRegistry() {
    }

    static {
        CONTEXTUAL_ADAPTIVE_SLEEP_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("intent").appendPath("screen_timeout").build();
        BLUETOOTH_URI = new Uri.Builder().scheme("content").authority("android.settings.slices").appendPath("action").appendPath("bluetooth").build();
        BLUETOOTH_DEVICES_SLICE_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath("bluetooth_devices").build();
        ENHANCED_4G_SLICE_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath("enhanced_4g_lte").build();
        FACE_ENROLL_SLICE_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath("face_unlock_greeting_card").build();
        FLASHLIGHT_SLICE_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath("flashlight").build();
        LOCATION_SLICE_URI = new Uri.Builder().scheme("content").authority("android.settings.slices").appendPath("action").appendPath("location").build();
        LOW_STORAGE_SLICE_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendEncodedPath("intent").appendPath("low_storage").build();
        NFC_SLICE_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath("toggle_nfc").build();
        MOBILE_DATA_SLICE_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendEncodedPath("action").appendPath("mobile_data").build();
        PROVIDER_MODEL_SLICE_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendEncodedPath("action").appendPath("provider_model").build();
        VOLUME_ALARM_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath("alarm_volume").build();
        VOLUME_CALL_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath("call_volume").build();
        VOLUME_MEDIA_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath("media_volume").build();
        VOLUME_SEPARATE_RING_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath("separate_ring_volume").build();
        VOLUME_NOTIFICATION_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath("notification_volume").build();
        VOLUME_SLICES_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath("volume_slices").build();
        WIFI_CALLING_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("intent").appendPath(WifiCallingSliceHelper.PATH_WIFI_CALLING).build();
        WIFI_CALLING_PREFERENCE_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath(WifiCallingSliceHelper.PATH_WIFI_CALLING_PREFERENCE).build();
        Uri r0 = new Uri.Builder().scheme("content").authority("android.settings.slices").appendPath("action").appendPath("wifi").build();
        WIFI_SLICE_URI = r0;
        ZEN_MODE_SLICE_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath("zen_mode").build();
        MEDIA_OUTPUT_INDICATOR_SLICE_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("intent").appendPath("media_output_indicator").build();
        DARK_THEME_SLICE_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath("dark_theme").build();
        REMOTE_MEDIA_SLICE_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath(MediaOutputConstants.KEY_REMOTE_MEDIA).build();
        ALWAYS_ON_SLICE_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath("always_on_display").build();
        ArrayMap r1 = new ArrayMap();
        sUriToSlice = r1;
        r1.put(r0, WifiSlice.class);
    }

    public static Class<? extends CustomSliceable> getSliceClassByUri(Uri r1) {
        return sUriToSlice.get(removeParameterFromUri(r1));
    }

    public static Uri removeParameterFromUri(Uri r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.buildUpon().clearQuery().build();
    }

    public static boolean isValidUri(Uri r1) {
        return sUriToSlice.containsKey(removeParameterFromUri(r1));
    }

    public static boolean isValidAction(String r0) {
        return isValidUri(Uri.parse(r0));
    }
}
