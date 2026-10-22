package com.android.settings.autoaction;

import android.app.Activity;
import android.os.Bundle;
import android.security.bytedance.guard.BDSecurityGuardStub;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SecurityEventMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/android/settings/autoaction/SecurityEventMonitor;", "", "()V", BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "activity", "Landroid/app/Activity;", "eventType", "", "finish", "start", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SecurityEventMonitor {
    public static final SecurityEventMonitor INSTANCE = null;

    static {
        INSTANCE = new SecurityEventMonitor();
    }

    private SecurityEventMonitor() {
    }

    public final void start(Activity r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        BDSecurityGuardStub.getInstance().bdSettingsEventStart(r2, r3, new Bundle());
    }

    public final void cancel(Activity r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Bundle r0 = new Bundle();
        r0.putString(BDSecurityGuardStub.SettingsEventConst.BUNDLE_KEY_EVENT_RESULT, BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL);
        Unit r1 = Unit.INSTANCE;
        BDSecurityGuardStub.getInstance().bdSettingsEventEnd(r4, r5, r0);
    }

    public final void finish(Activity r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Bundle r0 = new Bundle();
        r0.putString(BDSecurityGuardStub.SettingsEventConst.BUNDLE_KEY_EVENT_RESULT, BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CONFIRM);
        Unit r1 = Unit.INSTANCE;
        BDSecurityGuardStub.getInstance().bdSettingsEventEnd(r4, r5, r0);
    }
}
