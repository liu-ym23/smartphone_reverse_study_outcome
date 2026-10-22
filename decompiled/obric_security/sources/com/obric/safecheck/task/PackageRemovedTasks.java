package com.obric.safecheck.task;

import android.content.Context;
import android.util.Log;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.riskcontrol.domain.RiskControlEntryPoints;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PackageRemovedTasks.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0007J \u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/safecheck/task/PackageRemovedTasks;", "", "()V", "EXECUTOR", "Ljava/util/concurrent/ThreadPoolExecutor;", "TAG", "", "execute", "", "ctx", "Landroid/content/Context;", ApkVirusCheckProvider.KEY_PKG, AccountInfoBundleKey.USER_ID, "", "notifyRiskControlRemoved", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PackageRemovedTasks {
    private static final ThreadPoolExecutor EXECUTOR = null;
    public static final PackageRemovedTasks INSTANCE = null;
    private static final String TAG = "PackageRemovedTasks";

    static {
        INSTANCE = new PackageRemovedTasks();
        ThreadPoolExecutor r0 = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        r0.allowCoreThreadTimeOut(true);
        EXECUTOR = r0;
    }

    private PackageRemovedTasks() {
    }

    public static final /* synthetic */ void access$notifyRiskControlRemoved(PackageRemovedTasks r0, Context r1, String r2, int r3) {
        r0.notifyRiskControlRemoved(r1, r2, r3);
    }

    @JvmStatic
    public static final void execute(Context r2, final String r3, final int r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, ApkVirusCheckProvider.KEY_PKG);
        final Context r5 = r2.getApplicationContext();
        EXECUTOR.execute(new AnonymousClass1(r5, r3, r4));
    }

    private final void notifyRiskControlRemoved(Context r2, String r3, int r4) {
        RiskControlEntryPoints.onPackageRemoved(r2, r3, r4);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Log.w(TAG, "notifyRiskControlRemoved error, pkg=" + r3 + ", userId=" + r4, th);
    }
}
