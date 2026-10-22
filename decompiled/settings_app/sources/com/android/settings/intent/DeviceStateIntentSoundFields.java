package com.android.settings.intent;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: DeviceStateIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/android/settings/intent/DeviceStateIntentSoundFields;", "", "()V", "isVibrationEnabled", "", "ringerMode", "", "vibrationSetting", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeviceStateIntentSoundFields {
    public static final DeviceStateIntentSoundFields INSTANCE = null;

    static {
        INSTANCE = new DeviceStateIntentSoundFields();
    }

    @JvmStatic
    public static final boolean isVibrationEnabled(int r1, int r2) {
        if (r1 != 1) goto L6;
        if (r2 != 1) goto L6;
        return true;
    L6:
        return false;
    }

    private DeviceStateIntentSoundFields() {
    }
}
