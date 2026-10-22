package com.android.settings.utils;

import android.content.ContentResolver;
import android.provider.Settings;
import com.android.settings.RingtoneSettingsFragment;
import com.android.settings.SoundSettingsFragment;
import com.android.settingslib.SliceBroadcastRelay;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VibrationEffectManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0002J.\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0007¨\u0006\u000e"}, d2 = {"Lcom/android/settings/utils/VibrationEffectManager;", "", "()V", "getStorageKey", "", "soundSettingType", "useEnabledKey", "", "setVibrationEffect", "", "contentResolver", "Landroid/content/ContentResolver;", SliceBroadcastRelay.EXTRA_URI, "isVibrationEffectEnabled", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VibrationEffectManager {
    public static final VibrationEffectManager INSTANCE = null;

    static {
        INSTANCE = new VibrationEffectManager();
    }

    private VibrationEffectManager() {
    }

    @JvmStatic
    public static final void setVibrationEffect(ContentResolver r3, String r4, String r5, boolean r6) {
        if (Intrinsics.areEqual(r4, SoundSettingsFragment.TYPE_RINGTONE) == false) goto L5;
    L10:
        Settings.System.putString(r3, getStorageKey$default(INSTANCE, r4, false, 2, null), r5);
        return;
    L5:
        if (Intrinsics.areEqual(r4, SoundSettingsFragment.TYPE_RINGTONE_SUB2) == true) goto L10;
        VibrationEffectManager r0 = INSTANCE;
        Settings.Global.putInt(r3, r0.getStorageKey(r4, true), r6 ? 1 : 0);
        if (r6 == false) goto L12;
        Settings.Global.putString(r3, r0.getStorageKey(r4, false), r5);
        return;
    }

    static /* synthetic */ String getStorageKey$default(VibrationEffectManager r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.getStorageKey(r1, r2);
    }

    private final String getStorageKey(String r1, boolean r2) {
        if (r1 != null) goto L4;
    L37:
        if (r2 == false) goto L39;
        return RingtoneSettingsFragment.NOTIFICATION_VIBRATION_ENABLED;
    L39:
        return RingtoneSettingsFragment.NOTIFICATION_VIBRATION_EFFECT_URI;
    L4:
        switch(r1.hashCode()) {
            case -883389629: goto L31;
            case -675989426: goto L24;
            case -150053113: goto L19;
            case 908205731: goto L12;
            case 1870114858: goto L7;
            default: goto L37;
        };
    L7:
        if (r1.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == false) goto L37;
        return RingtoneSettingsFragment.RINGTONE_VIBRATION_EFFECT_2;
    L12:
        if (r1.equals(SoundSettingsFragment.TYPE_CALENDAR) == false) goto L37;
        if (r2 == false) goto L16;
        return RingtoneSettingsFragment.CALENDAR_VIBRATION_ENABLED;
    L16:
        return RingtoneSettingsFragment.CALENDAR_VIBRATION_EFFECT_URI;
    L19:
        if (r1.equals(SoundSettingsFragment.TYPE_RINGTONE) == false) goto L37;
        return RingtoneSettingsFragment.RINGTONE_VIBRATION_EFFECT;
    L24:
        if (r1.equals(SoundSettingsFragment.TYPE_MMS) == false) goto L37;
        if (r2 == false) goto L28;
        return RingtoneSettingsFragment.SMS_1_VIBRATION_ENABLED;
    L28:
        return RingtoneSettingsFragment.SMS_1_VIBRATION_EFFECT_URI;
    L31:
        if (r1.equals(SoundSettingsFragment.TYPE_MMS_SUB2) == false) goto L37;
        if (r2 == false) goto L35;
        return RingtoneSettingsFragment.SMS_2_VIBRATION_ENABLED;
    L35:
        return RingtoneSettingsFragment.SMS_2_VIBRATION_EFFECT_URI;
    }
}
