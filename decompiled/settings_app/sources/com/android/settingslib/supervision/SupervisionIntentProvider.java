package com.android.settingslib.supervision;

import android.app.supervision.SupervisionManager;
import android.content.Context;
import android.content.Intent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SupervisionIntentProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/settingslib/supervision/SupervisionIntentProvider;", "", "()V", "ACTION_SHOW_PARENTAL_CONTROLS", "", "getSettingsIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SupervisionIntentProvider {
    private static final String ACTION_SHOW_PARENTAL_CONTROLS = "android.settings.SHOW_PARENTAL_CONTROLS";
    public static final SupervisionIntentProvider INSTANCE = null;

    static {
        INSTANCE = new SupervisionIntentProvider();
    }

    private SupervisionIntentProvider() {
    }

    @JvmStatic
    public static final Intent getSettingsIntent(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        SupervisionManager r0 = (SupervisionManager) r4.getSystemService(SupervisionManager.class);
        if (r0 == null) goto L11;
        String r1 = r0.getActiveSupervisionAppPackage();
        if (r1 == null) goto L13;
        Intent r2 = new Intent("android.settings.SHOW_PARENTAL_CONTROLS").setPackage(r1).addFlags(268435456);
        Intrinsics.checkNotNullExpressionValue(r2, "addFlags(...)");
        List r5 = r4.getPackageManager().queryIntentActivitiesAsUser(r2, 0, r4.getUserId());
        Intrinsics.checkNotNullExpressionValue(r5, "queryIntentActivitiesAsUser(...)");
        if ((!r5.isEmpty()) == true) goto L10;
        return null;
    L10:
        return r2;
    L13:
        return null;
    L11:
        return null;
    }
}
