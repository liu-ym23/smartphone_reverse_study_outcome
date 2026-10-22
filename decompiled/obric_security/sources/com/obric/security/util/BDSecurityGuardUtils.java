package com.obric.security.util;

import android.content.Context;
import android.os.Bundle;
import android.security.bytedance.guard.BDSecurityGuardStub;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BDSecurityGuardUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/obric/security/util/BDSecurityGuardUtils;", "", "()V", "bdSettingsEventEnd", "", "context", "Landroid/content/Context;", "eventType", "", "result", "", "bdSettingsEventStart", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class BDSecurityGuardUtils {
    public static final BDSecurityGuardUtils INSTANCE = null;

    static {
        INSTANCE = new BDSecurityGuardUtils();
    }

    private BDSecurityGuardUtils() {
    }

    public final void bdSettingsEventStart(Context r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        BDSecurityGuardStub.getInstance().bdSettingsEventStart(r3, r4, new Bundle());     // Catch: Error -> L5
        OLog.e("BDSecurityGuardStub", "bdSettingsEventStart-success: ");     // Catch: Error -> L5
        return;
    L5:
        e = move-exception;
        OLog.e("BDSecurityGuardStub", "bdSettingsEventStart-Exception: ", e);
    }

    public final void bdSettingsEventEnd(Context r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "result");
        Bundle r1 = new Bundle();     // Catch: Error -> L5
        r1.putString("event_result", r4);     // Catch: Error -> L5
        BDSecurityGuardStub.getInstance().bdSettingsEventEnd(r2, r3, r1);     // Catch: Error -> L5
        return;
    L5:
        e = move-exception;
        OLog.e("BDSecurityGuardStub", "bdSettingsEventEnd-Exception: ", e);
    }
}
