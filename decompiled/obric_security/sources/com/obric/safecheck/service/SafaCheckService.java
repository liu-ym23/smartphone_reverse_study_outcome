package com.obric.safecheck.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.obric.olog.OLog;
import com.obric.safecheck.dataSync.AntiFraudApiClient;
import com.obric.safecheck.dataSync.AntiFraudReportUtil;
import com.obric.safecheck.parser.DirectoryParser;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.util.serviceutil.BatteryChargeUtils;
import com.obric.security.safecheckapi.CheckResult;
import com.obric.security.safecheckapi.ISecurityCheckCallback;
import com.obric.securitycenter.api.ApplicationContainer;
import com.obric.securitycenter.api.TrackUtils;
import com.ss.android.message.log.PushLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SafaCheckService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\rJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001e\u0010\u0018\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J(\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\b\u0002\u0010\"\u001a\u00020\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/safecheck/service/SafaCheckService;", "Landroid/app/Service;", "()V", "antiFraudReportUtil", "Lcom/obric/safecheck/dataSync/AntiFraudReportUtil;", "executorService", "Ljava/util/concurrent/ExecutorService;", "getExecutorService", "()Ljava/util/concurrent/ExecutorService;", "mInterface", "com/obric/safecheck/service/SafaCheckService$mInterface$1", "Lcom/obric/safecheck/service/SafaCheckService$mInterface$1;", "mSecurityCheckHelper", "Lcom/obric/safecheck/service/SecurityCheckHelper;", "checkDateBase", "", "isReport", "getSecurityCheckHelper", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "reportIfHit", ApkVirusCheckProvider.KEY_RESULTS, "", "Lcom/obric/security/safecheckapi/CheckResult;", "key", "", "safeCallCheckResultCallback", "callback", "Lcom/obric/security/safecheckapi/ISecurityCheckCallback;", "checkResult", PushLog.KEY_TAG, "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SafaCheckService extends Service {
    private final AntiFraudReportUtil antiFraudReportUtil;
    private final ExecutorService executorService;
    private final SafaCheckService$mInterface$1 mInterface;
    private volatile SecurityCheckHelper mSecurityCheckHelper;

    public SafaCheckService() {
        ExecutorService r0 = Executors.newCachedThreadPool();
        Intrinsics.checkNotNullExpressionValue(r0, "Executors.newCachedThreadPool()");
        this.executorService = r0;
        this.antiFraudReportUtil = new AntiFraudReportUtil();
        this.mInterface = new SafaCheckService$mInterface$1(this);
    }

    public static final /* synthetic */ void access$reportIfHit(SafaCheckService r0, List r1, String r2) {
        r0.reportIfHit(r1, r2);
    }

    public final ExecutorService getExecutorService() {
        return this.executorService;
    }

    public final SecurityCheckHelper getSecurityCheckHelper() {
        SecurityCheckHelper r0 = this.mSecurityCheckHelper;
        if (r0 != null) goto L13;
        monitor-enter(this);
        r0 = this.mSecurityCheckHelper;     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        r0 = SecurityCheckImplProvider.Companion.createSecurityCheckHelper(this);     // Catch: Throwable -> L10
        this.mSecurityCheckHelper = r0;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
    L10:
        th = move-exception;
        throw th;
    L13:
        return r0;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        OLog.i("SafaCheckService", "onCreate: service started");
    }

    private final void reportIfHit(List<CheckResult> r3, String r4) {
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        CheckResult r0 = (CheckResult) r5.next();
        if (r0.isBlacklisted() == false) goto L4;
        if (Intrinsics.areEqual(r0.getThreatType(), CheckResult.THREAT_FRAUD) == false) goto L4;
        this.antiFraudReportUtil.report(getApplication(), r4);
        goto L4
    }

    public static /* synthetic */ void safeCallCheckResultCallback$default(SafaCheckService r0, ISecurityCheckCallback r1, List r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = "SafeCheck";
    L5:
        r0.safeCallCheckResultCallback(r1, r2, r3);
    }

    public final void safeCallCheckResultCallback(ISecurityCheckCallback r2, List<CheckResult> r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "checkResult");
        Intrinsics.checkNotNullParameter(r4, PushLog.KEY_TAG);
        if (r2 != null) goto L6;
        OLog.w(r4, "回调接口为null，跳过onCheckResult调用");
        return;
    L6:
        IBinder r1 = r2.asBinder();
        Intrinsics.checkNotNullExpressionValue(r1, "callback.asBinder()");
    L12:
        e = move-exception;
        OLog.e(r4, "回调onCheckResult时发生未知异常", e);
        return;
    L8:
        if (r1.isBinderAlive() == false) goto L10;
        r2.onCheckResult(r3);     // Catch: Exception -> L12
    L15:
        return;
    L10:
        OLog.w(r4, "回调Binder已死亡，跳过onCheckResult调用");     // Catch: Exception -> L12
        goto L15
    }

    public final boolean checkDateBase(boolean r10) {
        String r0 = DirectoryParser.INSTANCE.getEndData();
        if (ApplicationContainer.INSTANCE.getApplication() == null) goto L5;
        boolean r9 = BatteryChargeUtils.INSTANCE.isDeviceCharging(this);
    L6:
        if (r10 == false) goto L9;
        TrackUtils.trackEvent$default(TrackUtils.INSTANCE, "antiFraud_data", MapsKt.mapOf(TuplesKt.to("end_data", r0)), false, 4, null);
    L9:
        if (r0.equals(DirectoryParser.DEFAULT_END_DATE) == false) goto L13;
        if (r9 == false) goto L15;
        AntiFraudApiClient.getInstance().getAntiFraudDataAsync("SafaCheckService");
        return false;
    L15:
        return true;
    L13:
        return true;
    L5:
        r9 = false;
        goto L6
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return this.mInterface;
    }
}
