package com.obric.safecheck.task;

import android.content.Context;
import android.util.Log;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.dataSync.miitAntiFraud.GxbAppInstallHitReporter;
import com.obric.safecheck.dataSync.miitAntiFraud.GxbRiskAppCache;
import com.obric.safecheck.dataSync.miitAntiFraud.GxbRiskAppItem;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GxbMediumRiskInstallCheckTask.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/safecheck/task/GxbMediumRiskInstallCheckTask;", "Lcom/obric/safecheck/task/PackageAddedTasks$Task;", "()V", "run", "", "ctx", "Landroid/content/Context;", ApkVirusCheckProvider.KEY_PKG, "", AccountInfoBundleKey.USER_ID, "", "Companion", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GxbMediumRiskInstallCheckTask implements PackageAddedTasks.Task {
    public static final Companion Companion = null;
    private static final String TAG = "GxbMediumRiskInstallCheckTask";

    /* JADX INFO: compiled from: GxbMediumRiskInstallCheckTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/safecheck/task/GxbMediumRiskInstallCheckTask$Companion;", "", "()V", "TAG", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public GxbMediumRiskInstallCheckTask() {
    }

    @Override // com.obric.safecheck.task.PackageAddedTasks.Task
    public void run(Context r8, String r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "ctx");
        Intrinsics.checkNotNullParameter(r9, ApkVirusCheckProvider.KEY_PKG);
        GxbRiskAppItem r11 = GxbRiskAppCache.get(r9);     // Catch: Throwable -> L16
        if (r11 != null) goto L7;
        GxbMediumRiskInstallCheckTask r7 = this;     // Catch: Throwable -> L16
        Log.d(TAG, "gxb risk cache miss, pkg=" + r9);     // Catch: Throwable -> L16
        return;
    L7:
        Integer r12 = r11.getRuleType();     // Catch: Throwable -> L16
        if (r12 != null) goto L11;
    L12:
        Log.d(TAG, "gxb risk cache hit but ruleType=" + r11.getRuleType() + ", ignore install-check, pkg=" + r9);     // Catch: Throwable -> L16
        return;
    L11:
        if (r12.intValue() != 1) goto L12;
        Log.i(TAG, "gxb medium risk installed, pkg=" + r9 + ", ruleType=" + r11.getRuleType() + ", ruleNo=" + r11.getRuleNo() + ", report installAppNum=1");     // Catch: Throwable -> L16
        GxbAppInstallHitReporter.report$default(2, r11.getRuleNo(), 0, 1, null, 16, null);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        Log.e(TAG, "gxb medium risk install check error, pkg=" + r9, th);
    }
}
