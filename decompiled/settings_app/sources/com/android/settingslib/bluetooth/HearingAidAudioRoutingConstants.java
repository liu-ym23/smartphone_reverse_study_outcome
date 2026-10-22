package com.android.settingslib.bluetooth;

import android.media.AudioDeviceAttributes;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class HearingAidAudioRoutingConstants {
    public static final int[] CALL_ROUTING_ATTRIBUTES = null;
    public static final AudioDeviceAttributes DEVICE_SPEAKER_OUT = null;
    public static final int[] MEDIA_ROUTING_ATTRIBUTES = null;
    public static final int[] NOTIFICATION_ROUTING_ATTRIBUTES = null;
    public static final int[] RINGTONE_ROUTING_ATTRIBUTES = null;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RoutingValue {
        public static final int AUTO = 0;
        public static final int DEVICE_SPEAKER = 2;
        public static final int HEARING_DEVICE = 1;
    }

    public HearingAidAudioRoutingConstants() {
    }

    static {
        CALL_ROUTING_ATTRIBUTES = new int[]{2};
        MEDIA_ROUTING_ATTRIBUTES = new int[]{1, 11, 3};
        RINGTONE_ROUTING_ATTRIBUTES = new int[]{6};
        NOTIFICATION_ROUTING_ATTRIBUTES = new int[]{5};
        DEVICE_SPEAKER_OUT = new AudioDeviceAttributes(2, 2, "");
    }
}
