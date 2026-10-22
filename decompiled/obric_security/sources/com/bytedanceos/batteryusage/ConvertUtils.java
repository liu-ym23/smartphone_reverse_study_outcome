package com.bytedanceos.batteryusage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class ConvertUtils {
    public static final int CONSUMER_TYPE_SYSTEM_BATTERY = 3;
    public static final int CONSUMER_TYPE_UID_BATTERY = 1;
    public static final int CONSUMER_TYPE_UNKNOWN = 0;
    public static final int CONSUMER_TYPE_USER_BATTERY = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConsumerType {
    }

    private ConvertUtils() {
    }
}
