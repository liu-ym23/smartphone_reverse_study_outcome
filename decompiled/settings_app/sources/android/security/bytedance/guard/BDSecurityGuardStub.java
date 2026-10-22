package android.security.bytedance.guard;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class BDSecurityGuardStub {

    public interface SettingsEventConst {
        public static final String BUNDLE_KEY_EVENT_RESULT = "event_result";
        public static final String EVENT_RESULT_CANCEL = "cancel";
        public static final String EVENT_RESULT_CONFIRM = "confirm";
    }

    public static BDSecurityGuardStub getInstance() {
        return null;
    }

    public void bdSettingsEventEnd(Context r1, int r2, Bundle r3) {
    }

    public void bdSettingsEventStart(Context r1, int r2, Bundle r3) {
    }

    public BDSecurityGuardStub() {
    }
}
