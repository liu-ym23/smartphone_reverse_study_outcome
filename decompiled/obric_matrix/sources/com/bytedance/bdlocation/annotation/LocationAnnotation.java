package com.bytedance.bdlocation.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class LocationAnnotation {

    @Retention(RetentionPolicy.SOURCE)
    public @interface GeocodeMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LocateType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LocationAccuracy {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LocationMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LocationPermission {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LocationRange {
    }

    public @interface NetworkStatusType {
        public static final int BLUETOOTH = 103;
        public static final int CELLULAR = 101;
        public static final int ETHERNET = 104;
        public static final int LOWPAN = 107;
        public static final int NONE = 0;
        public static final int NO_CONNECTION = 100;
        public static final int VPN = 105;
        public static final int WIFI = 102;
        public static final int WIFI_AWARE = 106;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RestrictedMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TriggerType {
        public static final int AUTO = 0;
        public static final int MANUAL = 1;
    }

    public LocationAnnotation() {
    }
}
