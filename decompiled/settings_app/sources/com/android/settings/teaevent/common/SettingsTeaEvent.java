package com.android.settings.teaevent.common;

import com.android.settings.teaevent.TeaEventReportUtil;
import com.obric.olog.OLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SettingsTeaEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\n\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/settings/teaevent/common/SettingsTeaEvent;", "", "()V", "TAG", "", "reportEvent", "", "eventName", "params", "", "Event", "Key", "Value", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SettingsTeaEvent {
    public static final SettingsTeaEvent INSTANCE = null;
    private static final String TAG = "SettingsTeaEvent";

    /* JADX INFO: compiled from: SettingsTeaEvent.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/settings/teaevent/common/SettingsTeaEvent$Event;", "", "()V", "EVENT_SETTINGS_FINGER_PRINT_ENROLL", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Event {
        public static final String EVENT_SETTINGS_FINGER_PRINT_ENROLL = "settings_finger_print_enroll";
        public static final Event INSTANCE = null;

        static {
            INSTANCE = new Event();
        }

        private Event() {
        }
    }

    /* JADX INFO: compiled from: SettingsTeaEvent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/settings/teaevent/common/SettingsTeaEvent$Key;", "", "()V", "KEY_SETTINGS_FINGER_PRINT_ENROLL_TYPE", "", "KEY_SETTINGS_FINGER_PRINT_UNLOCK_CHOICE", "KEY_SETTINGS_FINGER_PRINT_USE_FOR_UNLOCKSCREEN_SWITCH", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Key {
        public static final Key INSTANCE = null;
        public static final String KEY_SETTINGS_FINGER_PRINT_ENROLL_TYPE = "settings_finger_print_enroll_type";
        public static final String KEY_SETTINGS_FINGER_PRINT_UNLOCK_CHOICE = "settings_finger_print_unlock_choice";
        public static final String KEY_SETTINGS_FINGER_PRINT_USE_FOR_UNLOCKSCREEN_SWITCH = "settings_finger_print_use_for_unlockscreen_switch";

        static {
            INSTANCE = new Key();
        }

        private Key() {
        }
    }

    /* JADX INFO: compiled from: SettingsTeaEvent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/settings/teaevent/common/SettingsTeaEvent$Value;", "", "()V", "VALUE_DISPLAY_FINGERPRINT_ONLY", "", "VALUE_NO_FINGERPRINT", "VALUE_SIDE_AND_DISPLAY_FINGERPRINT", "VALUE_SIDE_FINGERPRINT_ONLY", "VALUE_USE_FOR_ENTER_LAUNCHER", "VALUE_USE_FOR_STAY_ON_SCREEN", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Value {
        public static final Value INSTANCE = null;
        public static final String VALUE_DISPLAY_FINGERPRINT_ONLY = "display_fingerprint_only";
        public static final String VALUE_NO_FINGERPRINT = "no_fingerprint";
        public static final String VALUE_SIDE_AND_DISPLAY_FINGERPRINT = "side_and_display_fingerprint";
        public static final String VALUE_SIDE_FINGERPRINT_ONLY = "side_fingerprint_only";
        public static final String VALUE_USE_FOR_ENTER_LAUNCHER = "use_for_enter_launcher";
        public static final String VALUE_USE_FOR_STAY_ON_SCREEN = "use_for_stay_on_screen";

        static {
            INSTANCE = new Value();
        }

        private Value() {
        }
    }

    static {
        INSTANCE = new SettingsTeaEvent();
    }

    private SettingsTeaEvent() {
    }

    @JvmStatic
    public static final void reportEvent(String r1, Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
        Intrinsics.checkNotNullParameter(r2, "params");
        TeaEventReportUtil.reportEvent(r1, r2);
        OLog.d(TAG, r1 + ": " + r2);
    }
}
