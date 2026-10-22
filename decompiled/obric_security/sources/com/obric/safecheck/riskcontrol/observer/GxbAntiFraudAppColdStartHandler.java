package com.obric.safecheck.riskcontrol.observer;

import android.content.Context;
import android.util.Log;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.dataSync.miitAntiFraud.GxbAntiFraudRuleExpiry;
import com.obric.safecheck.dataSync.miitAntiFraud.GxbAppInstallHitReporter;
import com.obric.safecheck.dataSync.miitAntiFraud.GxbRiskAppCache;
import com.obric.safecheck.database.AntiFraudDatabase;
import com.obric.safecheck.database.entity.GxbAntiFraudRuleItem;
import com.obric.securitycenter.api.AppNetworkController;
import com.obric.securitycenter.api.ApplicationContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GxbAntiFraudAppColdStartHandler.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/safecheck/riskcontrol/observer/GxbAntiFraudAppColdStartHandler;", "Lcom/obric/safecheck/riskcontrol/observer/RiskProcessObserverManager$ColdStartCallback;", "()V", "handleColdStart", "", "context", "Landroid/content/Context;", "packageName", "", "onAppColdStart", AccountInfoBundleKey.USER_ID, "", "Companion", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GxbAntiFraudAppColdStartHandler implements RiskProcessObserverManager.ColdStartCallback {
    public static final Companion Companion = null;
    private static final ThreadPoolExecutor EXECUTOR = null;
    private static final String TAG = "GxbAntiFraudAppHandler";

    /* JADX INFO: compiled from: GxbAntiFraudAppColdStartHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/safecheck/riskcontrol/observer/GxbAntiFraudAppColdStartHandler$Companion;", "", "()V", "EXECUTOR", "Ljava/util/concurrent/ThreadPoolExecutor;", "TAG", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    public GxbAntiFraudAppColdStartHandler() {
    }

    public static final /* synthetic */ void access$handleColdStart(GxbAntiFraudAppColdStartHandler r0, Context r1, String r2) {
        r0.handleColdStart(r1, r2);
    }

    @Override // com.obric.safecheck.riskcontrol.observer.RiskProcessObserverManager.ColdStartCallback
    public void onAppColdStart(final String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "packageName");
        Log.d(TAG, "onAppColdStart, packageName=" + r3 + ", userId=" + r4);
        if (r3.length() != 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        return;
    L8:
        final Context r6 = ApplicationContainer.INSTANCE.getApplication();
        if (r6 != null) goto L12;
        Log.e(TAG, "skipped, application context is null");
        return;
    L12:
        EXECUTOR.execute(new AnonymousClass1(this, r6, r3));
        return;
    L5:
        r5 = false;
        goto L6
    }

    private final void handleColdStart(Context r11, String r12) {
        List<GxbAntiFraudRuleItem> r1 = AntiFraudDatabase.getDatabase(r11).gxbAntiFraudRuleDao().getByPacketName(r12);     // Catch: Throwable -> L31
        if (r1.isEmpty() == false) goto L7;
        Log.d(TAG, "no gxb rule for " + r12);     // Catch: Throwable -> L31
        return;
    L7:
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L31
        Iterator<T> r2 = r1.iterator();     // Catch: Throwable -> L31
    L8:
        boolean r3 = true;
        if (r2.hasNext() == false) goto L18;
        Object r4 = r2.next();     // Catch: Throwable -> L31
        GxbAntiFraudRuleItem r5 = (GxbAntiFraudRuleItem) r4;     // Catch: Throwable -> L31
        if (r5.getRuleType() != 3) goto L13;
    L16:
        if (r3 == false) goto L8;
        r0.add(r4);     // Catch: Throwable -> L31
        goto L8
    L13:
        if (r5.getRuleType() == 4) goto L16;
        r3 = false;
        goto L16
    L18:
        ArrayList r6 = r0;     // Catch: Throwable -> L31
        Iterator r7 = r6.iterator();     // Catch: Throwable -> L31
    L20:
        if (r7.hasNext() == false) goto L24;
        Object r8 = r7.next();     // Catch: Throwable -> L31
        if ((!GxbAntiFraudRuleExpiry.isExpired((GxbAntiFraudRuleItem) r8)) == false) goto L20;
    L25:
        GxbAntiFraudRuleItem r9 = (GxbAntiFraudRuleItem) r8;     // Catch: Throwable -> L31
        if (r9 != null) goto L29;
        Log.d(TAG, "no active ruleType=3/4 rule for " + r12 + ", matched=" + r6.size());     // Catch: Throwable -> L31
        return;
    L29:
        Log.d(TAG, "hit gxb rule, packageName=" + r12 + ", ruleNo=" + r9.getRuleNo() + ", ruleType=" + r9.getRuleType());     // Catch: Throwable -> L31
        GxbRiskAppCache.put(r12, Integer.valueOf(r9.getRuleType()), r9.getRuleNo());     // Catch: Throwable -> L31
        GxbAppInstallHitReporter.report$default(2, r9.getRuleNo(), 1, 0, null, 24, null);     // Catch: Throwable -> L31
        Log.d(TAG, "blockAllNetwork done, packageName=" + r12 + ", success=" + AppNetworkController.blockAllNetwork(r11, r12));     // Catch: Throwable -> L31
        GxbAntiFraudAlertOverlay.INSTANCE.show(r11);     // Catch: Throwable -> L31
        return;
    L24:
        r8 = null;
    L31:
        th = move-exception;
        Log.e(TAG, "handle gxb cold start failed, packageName=" + r12, th);
    }

    static {
        Companion = new Companion(null);
        ThreadPoolExecutor r0 = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        r0.allowCoreThreadTimeOut(true);
        EXECUTOR = r0;
    }
}
