package com.bytedanceos.securitycenter.init;

import android.content.Context;
import com.bytedanceos.cloud.PreferenceMgr;
import com.obric.olog.OLog;
import com.obric.safecheck.update.VirusDbUpdateManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VirusDbAutoUpdateInitializer.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedanceos/securitycenter/init/VirusDbAutoUpdateInitializer;", "", "()V", "TAG", "", "init", "", "context", "Landroid/content/Context;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class VirusDbAutoUpdateInitializer {
    public static final VirusDbAutoUpdateInitializer INSTANCE = null;
    private static final String TAG = "VirusDbAutoUpdateInitializer";

    static {
        INSTANCE = new VirusDbAutoUpdateInitializer();
    }

    private VirusDbAutoUpdateInitializer() {
    }

    @JvmStatic
    public static final void init(Context r2) {
        if (r2 == null) goto L17;
        Context r3 = r2.getApplicationContext();
        if (r3 == null) goto L18;
        PreferenceMgr r0 = PreferenceMgr.getInstance(r3);
        Intrinsics.checkNotNullExpressionValue(r0, "PreferenceMgr.getInstance(appContext)");
        if (r0.isAllowed() == true) goto L15;
        OLog.i(TAG, "skip init before privacy allowed");
        return;
    L15:
        VirusDbUpdateManager.syncAutoUpdateSetting(r3);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        OLog.w(TAG, "sync virus db auto update schedule failed", th);
        return;
    L18:
        return;
    }
}
