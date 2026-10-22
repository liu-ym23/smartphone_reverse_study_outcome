package com.obric.safecheck.task;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.InstallSourceInfo;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.riskcontrol.api.model.RiskInstallSource;
import com.obric.safecheck.riskcontrol.domain.RiskControlEntryPoints;
import com.obric.securitycenter.api.ApkResultEntity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PackageAddedTasks.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001-B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0006H\u0002J&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J \u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J \u0010\u0019\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002JP\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!H\u0002J\u0012\u0010\"\u001a\u00020\u00112\b\u0010#\u001a\u0004\u0018\u00010\tH\u0007J\"\u0010$\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010&\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u000fH\u0002J\u0018\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020\u000fH\u0002J\b\u0010,\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/safecheck/task/PackageAddedTasks;", "", "()V", "EXECUTOR", "Ljava/util/concurrent/ThreadPoolExecutor;", "TAG", "", "TASKS", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/safecheck/task/PackageAddedTasks$Task;", "buildInstallIdentity", "ctx", "Landroid/content/Context;", ApkVirusCheckProvider.KEY_PKG, AccountInfoBundleKey.USER_ID, "", "clearTasks", "", "currentTimestamp", "determineVirusType", "Lkotlin/Pair;", "virusName", "hasScanError", "", "execute", "isPackageStillInstalled", "notifyRiskControlDetected", "appName", "riskType", "riskLevel", "riskDesc", "installIdentity", "installSource", "Lcom/obric/safecheck/riskcontrol/api/model/RiskInstallSource;", "register", "task", "resolveAppName", "scanAppName", "resolveInstallSource", "resolveRiskLevel", ApkVirusCheckProvider.KEY_VIRUS_TYPE_CODE, "shouldInitializeRiskControl", "result", "Lcom/obric/securitycenter/api/ApkResultEntity;", "shutdown", "Task", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PackageAddedTasks {
    private static final ThreadPoolExecutor EXECUTOR = null;
    public static final PackageAddedTasks INSTANCE = null;
    private static final String TAG = "PackageAddedTasks";
    private static final CopyOnWriteArrayList<Task> TASKS = null;

    /* JADX INFO: compiled from: PackageAddedTasks.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/obric/safecheck/task/PackageAddedTasks$Task;", "", "run", "", "ctx", "Landroid/content/Context;", ApkVirusCheckProvider.KEY_PKG, "", AccountInfoBundleKey.USER_ID, "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public interface Task {
        void run(Context r1, String r2, int r3);
    }

    private final String resolveRiskLevel(int r1) {
        if (r1 != 1) goto L5;
        return "high";
    L5:
        return "medium";
    }

    static {
        INSTANCE = new PackageAddedTasks();
        TASKS = new CopyOnWriteArrayList();
        ThreadPoolExecutor r0 = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        r0.allowCoreThreadTimeOut(true);
        EXECUTOR = r0;
        register(AnonymousClass1.INSTANCE);
        register(new GxbMediumRiskInstallCheckTask());
    }

    private PackageAddedTasks() {
    }

    public static final /* synthetic */ String access$buildInstallIdentity(PackageAddedTasks r0, Context r1, String r2, int r3) {
        return r0.buildInstallIdentity(r1, r2, r3);
    }

    public static final /* synthetic */ String access$currentTimestamp(PackageAddedTasks r0) {
        return r0.currentTimestamp();
    }

    public static final /* synthetic */ boolean access$isPackageStillInstalled(PackageAddedTasks r0, Context r1, String r2, int r3) {
        return r0.isPackageStillInstalled(r1, r2, r3);
    }

    public static final /* synthetic */ void access$notifyRiskControlDetected(PackageAddedTasks r0, Context r1, String r2, int r3, String r4, String r5, String r6, String r7, String r8, RiskInstallSource r9) {
        r0.notifyRiskControlDetected(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static final /* synthetic */ String access$resolveAppName(PackageAddedTasks r0, Context r1, String r2, String r3) {
        return r0.resolveAppName(r1, r2, r3);
    }

    public static final /* synthetic */ RiskInstallSource access$resolveInstallSource(PackageAddedTasks r0, Context r1, String r2) {
        return r0.resolveInstallSource(r1, r2);
    }

    public static final /* synthetic */ String access$resolveRiskLevel(PackageAddedTasks r0, int r1) {
        return r0.resolveRiskLevel(r1);
    }

    public static final /* synthetic */ boolean access$shouldInitializeRiskControl(PackageAddedTasks r0, ApkResultEntity r1, int r2) {
        return r0.shouldInitializeRiskControl(r1, r2);
    }

    @JvmStatic
    public static final void register(Task r1) {
        if (r1 == null) goto L5;
        TASKS.add(r1);
        return;
    }

    @JvmStatic
    public static final void execute(Context r4, final String r5, final int r6) {
        Intrinsics.checkNotNullParameter(r4, "ctx");
        Intrinsics.checkNotNullParameter(r5, ApkVirusCheckProvider.KEY_PKG);
        final Context r7 = r4.getApplicationContext();
        Iterator<T> r0 = TASKS.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        final Task r1 = (Task) r0.next();
        EXECUTOR.execute(new PackageAddedTasks$execute$$inlined$forEach$lambda$1(r1, r7, r5, r6));
        goto L4
    }

    @JvmStatic
    public static final void clearTasks() {
        TASKS.clear();
    }

    @JvmStatic
    public static final void shutdown() {
        EXECUTOR.shutdown();     // Catch: Throwable -> L4
        return;
    }

    @JvmStatic
    public static final Pair<String, Integer> determineVirusType(String r5, boolean r6) {
        String r0 = r5;
        int r1 = 1;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if ((!r2) == true) goto L15;
        if (r6 == false) goto L14;
        return TuplesKt.to(EnvironmentCompat.MEDIA_UNKNOWN, 3);
    L14:
        return TuplesKt.to("none", 0);
    L15:
        Intrinsics.checkNotNull(r5);
        Locale r7 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r7, "Locale.US");
        String r8 = r5.toLowerCase(r7);
        Intrinsics.checkNotNullExpressionValue(r8, "this as java.lang.String).toLowerCase(locale)");
        String r9 = r8;
        if (StringsKt.contains$default(r9, "a.gray.sex", false, 2, null) == false) goto L18;
        String r3 = "sex";
    L20:
        if (StringsKt.contains$default(r9, "a.gray.sex", false, 2, null) == true) goto L24;
        r1 = 2;
    L24:
        return TuplesKt.to(r3, Integer.valueOf(r1));
    L18:
        r3 = "other";
        goto L20
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r2 = false;
        goto L10
    }

    private final boolean shouldInitializeRiskControl(ApkResultEntity r1, int r2) {
        if (r1.getHasRisk() == true) goto L10;
        if (r2 != 1) goto L6;
        return true;
    L6:
        if (r2 == 2) goto L12;
        return false;
    L12:
        return true;
    L10:
        return true;
    }

    private final String resolveAppName(Context r2, String r3, String r4) {
        String r1 = r4;
        if (r1 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == true) goto L18;
        return r4;
    L18:
        ApplicationInfo r6 = r2.getPackageManager().getApplicationInfo(r3, 0);     // Catch: Throwable -> L17
        Intrinsics.checkNotNullExpressionValue(r6, "ctx.packageManager.getApplicationInfo(pkg, 0)");     // Catch: Throwable -> L17
        String r7 = r2.getPackageManager().getApplicationLabel(r6).toString();     // Catch: Throwable -> L17
        if (StringsKt.isBlank(r7) == false) goto L14;
        r7 = r3;
    L14:
        return r7;
    L20:
        return r3;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r5 = false;
        goto L9
    }

    private final String buildInstallIdentity(Context r3, String r4, int r5) {
        long r0 = 0;
        r0 = r3.getPackageManager().getPackageInfo(r4, 0).firstInstallTime;     // Catch: Throwable -> L6
    L5:
        return r4 + "#" + r5 + "#" + r0;
    }

    private final RiskInstallSource resolveInstallSource(Context r1, String r2) {
        InstallSourceInfo r0 = r1.getPackageManager().getInstallSourceInfo(r2);     // Catch: Throwable -> L6
        Intrinsics.checkNotNullExpressionValue(r0, "ctx.packageManager.getInstallSourceInfo(pkg)");     // Catch: Throwable -> L6
        String r3 = r0.getInstallingPackageName();     // Catch: Throwable -> L6
        if (r3 != null) goto L8;
        r3 = r0.getInitiatingPackageName();     // Catch: Throwable -> L6
    L8:
        return PackageAddedTasksKt.mapInstallerPackageToInstallSource(r3);
    L6:
        r3 = null;
        goto L8
    }

    private final boolean isPackageStillInstalled(Context r1, String r2, int r3) {
        r1.getPackageManager().getPackageInfoAsUser(r2, 0, r3);     // Catch: Throwable -> L6
        return true;
    L9:
        return false;
    }

    private final void notifyRiskControlDetected(Context r5, String r6, int r7, String r8, String r9, String r10, String r11, String r12, RiskInstallSource r13) {
        Log.i(TAG, "notifyRiskControlDetected, pkg=" + r6 + ", userId=" + r7 + ", appName=" + r8 + ", riskType=" + r9 + ", riskLevel=" + r10 + ", installIdentity=" + r12 + ", installSource=" + r13);     // Catch: Throwable -> L5
        RiskControlEntryPoints.onRiskDetected(r5, r6, r7, r8, r9, r10, r11, r12, r13);     // Catch: Throwable -> L5
        Log.i(TAG, "notifyRiskControlDetected success, pkg=" + r6 + ", userId=" + r7);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.w(TAG, "notifyRiskControlDetected error, pkg=" + r6, th);
    }

    private final String currentTimestamp() {
        String r3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis()));
        Intrinsics.checkNotNullExpressionValue(r3, "sdf.format(Date(System.currentTimeMillis()))");
        return r3;
    }
}
