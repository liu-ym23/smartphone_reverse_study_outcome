package com.bytedanceos.securitycenter.init;

import android.content.Context;
import com.obric.olog.OLog;
import com.obric.olog.OLogConfig;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InitOlog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedanceos/securitycenter/init/InitOlog;", "", "()V", "initOLog", "", "ctx", "Landroid/content/Context;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class InitOlog {
    public static final InitOlog INSTANCE = null;

    static {
        INSTANCE = new InitOlog();
    }

    private InitOlog() {
    }

    public final void initOLog(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "ctx");
        File r3 = r4.createDeviceProtectedStorageContext().getFilesDir();
        File r0 = new File(r3, "ologs");
        File r1 = new File(r3, "olog_cache");
        if (r0.exists() == true) goto L7;
        r0.mkdirs();     // Catch: Throwable -> L11
    L7:
        if (r1.exists() == true) goto L9;
        r1.mkdirs();     // Catch: Throwable -> L11
    L9:
        OLog.init(new OLogConfig.Builder(r4).setLevel(3).setSaveToDisk(true).setLogFileExpDays(30).setLogDirPath(r0.getAbsolutePath()).setBufferDirPath(r1.getAbsolutePath()).build());
        OLog.setOutputToLogd(true);
    }
}
