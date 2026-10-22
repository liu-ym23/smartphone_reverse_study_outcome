package com.obric.security.service;

import android.content.Context;
import android.os.Bundle;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.bytedanceos.securitycenter.appBgBatteryControl.AppBgBatteryControlDataHelper;
import com.obric.security.health.model.HealthModulePresentation;
import com.obric.security.health.model.HealthScoreSnapshot;
import com.obric.security.health.score.HealthScoreLog;
import com.obric.security.service.health.HealthOptimizeManager;
import com.obric.security.service.health.IHealthOptimizeManager;
import com.obric.securitycenter.api.Const;
import com.obric.securitycenter.api.IEventCallback;
import com.obric.securitycenter.api.ISecurityCenterService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: SecurityServiceBinder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\b*\u0001\u000e\u0018\u0000 =2\u00020\u0001:\u0001=B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ>\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u00132\b\u0010#\u001a\u0004\u0018\u00010\u00132\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u0010&\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0011H\u0002J\u0006\u0010(\u001a\u00020\u001dJ\u0006\u0010)\u001a\u00020\u001dJ\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u0011J\b\u0010,\u001a\u00020\u001dH\u0016J\u0012\u0010-\u001a\u00020\u001d2\b\u0010.\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010/\u001a\u00020\u001dH\u0016J\u0012\u00100\u001a\u00020\u001d2\n\b\u0002\u00101\u001a\u0004\u0018\u000102J\b\u00103\u001a\u00020\u001dH\u0016J \u00104\u001a\u00020\u001d2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u0013062\n\b\u0002\u00101\u001a\u0004\u0018\u000102J\u0014\u00107\u001a\u00020\u001d2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001306J\b\u00108\u001a\u00020\u001dH\u0016J\u0006\u00109\u001a\u00020\u001dJ\b\u0010:\u001a\u00020\u001dH\u0016J\u0012\u0010;\u001a\u00020\u001d2\b\u0010.\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010<\u001a\u00020\u001d2\b\u0010.\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006>"}, d2 = {"Lcom/obric/security/service/SecurityServiceBinder;", "Lcom/obric/securitycenter/api/ISecurityCenterService$Stub;", "()V", "healthOptimizeManager", "Lcom/obric/security/service/health/IHealthOptimizeManager;", "mCallbackExecutor", "Ljava/util/concurrent/ExecutorService;", "mCallbacks", "Ljava/util/ArrayList;", "Lcom/obric/securitycenter/api/IEventCallback;", "Lkotlin/collections/ArrayList;", "mIsDestroyed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "managerCallback", "com/obric/security/service/SecurityServiceBinder$managerCallback$1", "Lcom/obric/security/service/SecurityServiceBinder$managerCallback$1;", "getExtraInfo", "Landroid/os/Bundle;", "type", "", "getHealthOptimizeManager", "getHealthSnapshot", "Lcom/obric/security/health/model/HealthScoreSnapshot;", "getTrashTotalSize", "", "getVisibleHealthModulePresentations", "", "Lcom/obric/security/health/model/HealthModulePresentation;", "notifyProgress", "", "event", "progress", "", "title", "itemId", "moduleId", "taskPassed", "", "notifyScoreEvent", "scoreSnapshot", "onCreate", "onDestroy", "onNotify", AppBgBatteryControlDataHelper.ItemColumns.PARAM, "pauseScanTrashAndMem", "removeCallback", "callback", "resumeScanTrashAndMem", "startAutoOptimizeItems", "runtimeContext", "Landroid/content/Context;", "startClearTrashAndMem", "startOptimizeItems", "itemIds", "", "startScanHealthItems", "startScanTrashAndMem", "stopOptimizeItems", "stopScanTrashAndMem", "subscribe", "unsubscribe", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SecurityServiceBinder extends ISecurityCenterService.Stub {
    public static final Companion Companion = null;
    private static final String SOURCE = "SecurityServiceBinder";
    private IHealthOptimizeManager healthOptimizeManager;
    private final ExecutorService mCallbackExecutor;
    private final ArrayList<IEventCallback> mCallbacks;
    private final AtomicBoolean mIsDestroyed;
    private final SecurityServiceBinder$managerCallback$1 managerCallback;

    /* JADX INFO: compiled from: SecurityServiceBinder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/obric/security/service/SecurityServiceBinder$Companion;", "", "()V", "SOURCE", "", "instance", "Lcom/obric/security/service/SecurityServiceBinder;", "getInstance", "()Lcom/obric/security/service/SecurityServiceBinder;", "Holder", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {

        /* JADX INFO: compiled from: SecurityServiceBinder.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/security/service/SecurityServiceBinder$Companion$Holder;", "", "()V", "INSTANCE", "Lcom/obric/security/service/SecurityServiceBinder;", "getINSTANCE", "()Lcom/obric/security/service/SecurityServiceBinder;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
        private static final class Holder {
            public static final Holder INSTANCE = null;

            /* JADX INFO: renamed from: INSTANCE, reason: collision with other field name */
            private static final SecurityServiceBinder f0INSTANCE = null;

            static {
                INSTANCE = new Holder();
                f0INSTANCE = new SecurityServiceBinder(null);
            }

            private Holder() {
            }

            public final SecurityServiceBinder getINSTANCE() {
                return f0INSTANCE;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final SecurityServiceBinder getInstance() {
            return Holder.INSTANCE.getINSTANCE();
        }
    }

    /* JADX INFO: renamed from: com.obric.security.service.SecurityServiceBinder$onDestroy$1, reason: invalid class name */
    /* JADX INFO: compiled from: SecurityServiceBinder.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        AnonymousClass1(SecurityServiceBinder r7) {
            super(r7, SecurityServiceBinder.class, "healthOptimizeManager", "getHealthOptimizeManager()Lcom/obric/security/service/health/IHealthOptimizeManager;", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return SecurityServiceBinder.access$getHealthOptimizeManager$p((SecurityServiceBinder) this.receiver);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
        public void set(Object r1) {
            SecurityServiceBinder.access$setHealthOptimizeManager$p((SecurityServiceBinder) this.receiver, (IHealthOptimizeManager) r1);
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.security.service.SecurityServiceBinder$managerCallback$1] */
    private SecurityServiceBinder() {
        ExecutorService r0 = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(r0, "Executors.newSingleThreadExecutor()");
        this.mCallbackExecutor = r0;
        this.managerCallback = new SecurityServiceBinder$managerCallback$1(this);
        this.mCallbacks = new ArrayList();
        this.mIsDestroyed = new AtomicBoolean(true);
    }

    public /* synthetic */ SecurityServiceBinder(DefaultConstructorMarker r1) {
        this();
    }

    public static final /* synthetic */ IHealthOptimizeManager access$getHealthOptimizeManager$p(SecurityServiceBinder r1) {
        IHealthOptimizeManager r2 = r1.healthOptimizeManager;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("healthOptimizeManager");
    L5:
        return r2;
    }

    public static final /* synthetic */ void access$notifyProgress(SecurityServiceBinder r0, String r1, int r2, String r3, String r4, String r5, boolean r6) {
        r0.notifyProgress(r1, r2, r3, r4, r5, r6);
    }

    public static final /* synthetic */ void access$notifyScoreEvent(SecurityServiceBinder r0, String r1, Bundle r2) {
        r0.notifyScoreEvent(r1, r2);
    }

    public static final /* synthetic */ void access$removeCallback(SecurityServiceBinder r0, IEventCallback r1) {
        r0.removeCallback(r1);
    }

    public static final /* synthetic */ void access$setHealthOptimizeManager$p(SecurityServiceBinder r0, IHealthOptimizeManager r1) {
        r0.healthOptimizeManager = r1;
    }

    @Override // com.obric.securitycenter.api.ISecurityCenterService
    public void startScanTrashAndMem() {
        HealthScoreLog.INSTANCE.i(SOURCE, "startScanTrashAndMem");
        IHealthOptimizeManager.DefaultImpls.startScan$default(getHealthOptimizeManager(), null, 1, null);
    }

    @Override // com.obric.securitycenter.api.ISecurityCenterService
    public void stopScanTrashAndMem() {
        HealthScoreLog.INSTANCE.i(SOURCE, "stopScanTrashAndMem");
        getHealthOptimizeManager().stopScan();
    }

    @Override // com.obric.securitycenter.api.ISecurityCenterService
    public void resumeScanTrashAndMem() {
        HealthScoreLog.INSTANCE.d(SOURCE, "resumeScanTrashAndMem");
        getHealthOptimizeManager().resume();
    }

    @Override // com.obric.securitycenter.api.ISecurityCenterService
    public void pauseScanTrashAndMem() {
        HealthScoreLog.INSTANCE.d(SOURCE, "pauseScanTrashAndMem");
        getHealthOptimizeManager().pause();
    }

    @Override // com.obric.securitycenter.api.ISecurityCenterService
    public void startClearTrashAndMem() {
        HealthScoreLog.INSTANCE.i(SOURCE, "startClearTrashAndMem");
        IHealthOptimizeManager.DefaultImpls.startOptimize$default(getHealthOptimizeManager(), null, null, 3, null);
    }

    @Override // com.obric.securitycenter.api.ISecurityCenterService
    public Bundle getExtraInfo(String r2) {
        if (Intrinsics.areEqual(r2, Const.SCORE_DETAIL) == true) goto L5;
        return null;
    L5:
        return getHealthOptimizeManager().getScoreSnapshot();
    }

    @Override // com.obric.securitycenter.api.ISecurityCenterService
    public void subscribe(IEventCallback r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        getHealthOptimizeManager();
        ArrayList<IEventCallback> r2 = this.mCallbacks;
        monitor-enter(r2);
    L15:
        th = move-exception;
        throw th;
    L8:
        if (this.mCallbacks.contains(r6) == false) goto L12;
        HealthScoreLog.INSTANCE.d(SOURCE, "ignoreDuplicateSubscribe callback=" + r6);     // Catch: Throwable -> L15
        monitor-exit(r2);
        return;
    L12:
        this.mCallbacks.add(r6);     // Catch: Throwable -> L15
        HealthScoreLog.INSTANCE.d(SOURCE, "subscribe callback=" + r6 + " count=" + this.mCallbacks.size());     // Catch: Throwable -> L15
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r2);
    }

    public final void unsubscribe(IEventCallback r1) {
        removeCallback(r1);
    }

    private final void removeCallback(IEventCallback r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        ArrayList<IEventCallback> r1 = this.mCallbacks;
        monitor-enter(r1);
        this.mCallbacks.remove(r6);     // Catch: Throwable -> L10
        HealthScoreLog.INSTANCE.d(SOURCE, "unsubscribe callback=" + r6 + " count=" + this.mCallbacks.size());     // Catch: Throwable -> L10
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r1);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.List] */
    public final void onNotify(final Bundle r9) {
        Intrinsics.checkNotNullParameter(r9, AppBgBatteryControlDataHelper.ItemColumns.PARAM);
        final Ref.ObjectRef r3 = new Ref.ObjectRef();
        ArrayList<IEventCallback> r0 = this.mCallbacks;
        monitor-enter(r0);
        r3.element = new ArrayList(this.mCallbacks);     // Catch: Throwable -> L16
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r0);
        final String r6 = r9.getString("event");
        if ((!Intrinsics.areEqual(r6, Const.EVENT_SCAN_TASK_PROGRESS)) == true) goto L9;
    L11:
        final boolean r5 = false;
    L12:
        if (r5 == false) goto L14;
        HealthScoreLog.INSTANCE.d(SOURCE, "notifyDispatchStart event=" + r6 + " callbackCount=" + ((List) r3.element).size());
    L14:
        this.mCallbackExecutor.execute(new AnonymousClass2(this, r3, r9, r5, r6));
        return;
    L9:
        if ((!Intrinsics.areEqual(r6, Const.EVENT_CLEAR_TASK_PROGRESS)) == false) goto L11;
        r5 = true;
    L16:
        th = move-exception;
        throw th;
    }

    public final void onCreate() {
        if (this.mIsDestroyed.get() == true) goto L5;
        return;
    L5:
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (this.mIsDestroyed.get() == true) goto L10;
        monitor-exit(this);
        return;
    L10:
        HealthScoreLog.INSTANCE.i(SOURCE, "onCreate");     // Catch: Throwable -> L16
        Context r1 = SecurityCenterApplication.getContext();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r1, "SecurityCenterApplication.getContext()");     // Catch: Throwable -> L16
        HealthOptimizeManager r0 = new HealthOptimizeManager(r1);     // Catch: Throwable -> L16
        this.healthOptimizeManager = r0;     // Catch: Throwable -> L16
        r0.setCallback(this.managerCallback);     // Catch: Throwable -> L16
        IHealthOptimizeManager r2 = this.healthOptimizeManager;     // Catch: Throwable -> L16
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("healthOptimizeManager");     // Catch: Throwable -> L16
    L13:
        r2.onCreate();     // Catch: Throwable -> L16
        this.mIsDestroyed.set(false);     // Catch: Throwable -> L16
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public final void onDestroy() {
        if (this.mIsDestroyed.getAndSet(true) == false) goto L5;
        return;
    L5:
        HealthScoreLog.INSTANCE.i(SOURCE, "onDestroy");
        if (this.healthOptimizeManager == null) goto L14;
        IHealthOptimizeManager r0 = this.healthOptimizeManager;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("healthOptimizeManager");
    L10:
        r0.setCallback(null);
        IHealthOptimizeManager r1 = this.healthOptimizeManager;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("healthOptimizeManager");
    L13:
        r1.onDestroy();
    L14:
        ArrayList<IEventCallback> r2 = this.mCallbacks;
        monitor-enter(r2);
        this.mCallbacks.clear();     // Catch: Throwable -> L19
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r2);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final long getTrashTotalSize() {
        return getHealthOptimizeManager().getTrashTotalSize();
    }

    public final HealthScoreSnapshot getHealthSnapshot() {
        return getHealthOptimizeManager().getHealthSnapshot();
    }

    public final List<HealthModulePresentation> getVisibleHealthModulePresentations() {
        return getHealthOptimizeManager().getVisibleModulePresentations();
    }

    public final void startScanHealthItems(Set<String> r4) {
        Intrinsics.checkNotNullParameter(r4, "itemIds");
        HealthScoreLog.INSTANCE.i(SOURCE, "startScanHealthItems itemIds=" + r4);
        getHealthOptimizeManager().startScan(r4);
    }

    public static /* synthetic */ void startAutoOptimizeItems$default(SecurityServiceBinder r0, Context r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
        Context r4 = (Context) null;
    L5:
        r0.startAutoOptimizeItems(r1);
    }

    public final void startAutoOptimizeItems(Context r4) {
        HealthScoreLog r0 = HealthScoreLog.INSTANCE;
        StringBuilder r1 = new StringBuilder("startAutoOptimizeItems hasRuntimeContext=");
        if (r4 == null) goto L5;
        boolean r2 = true;
    L6:
        r0.i(SOURCE, r1.append(r2).toString());
        getHealthOptimizeManager().startOptimize(null, r4);
        return;
    L5:
        r2 = false;
        goto L6
    }

    public static /* synthetic */ void startOptimizeItems$default(SecurityServiceBinder r0, Set r1, Context r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
        Context r5 = (Context) null;
    L5:
        r0.startOptimizeItems(r1, r2);
    }

    public final void startOptimizeItems(Set<String> r4, Context r5) {
        Intrinsics.checkNotNullParameter(r4, "itemIds");
        HealthScoreLog r0 = HealthScoreLog.INSTANCE;
        StringBuilder r1 = new StringBuilder("startOptimizeItems itemIds=").append(r4).append(" hasRuntimeContext=");
        if (r5 == null) goto L5;
        boolean r2 = true;
    L6:
        r0.i(SOURCE, r1.append(r2).toString());
        getHealthOptimizeManager().startOptimize(r4, r5);
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final void stopOptimizeItems() {
        HealthScoreLog.INSTANCE.i(SOURCE, "stopOptimizeItems");
        getHealthOptimizeManager().stopOptimize();
    }

    private final void notifyProgress(String r3, int r4, String r5, String r6, String r7, boolean r8) {
        if (this.mIsDestroyed.get() == false) goto L5;
        return;
    L5:
        Bundle r0 = new Bundle();
        r0.putString("event", r3);
        r0.putInt(Const.TASK_PROGRESS, r4);
        r0.putString(Const.TASK_TITLE, r5);
        r0.putString(Const.TASK_ITEM_ID, r6);
        r0.putString(Const.TASK_MODULE_ID, r7);
        r0.putBoolean(Const.TASK_PASSED, r8);
        onNotify(r0);
    }

    private final void notifyScoreEvent(String r4, Bundle r5) {
        if (this.mIsDestroyed.get() == false) goto L5;
        return;
    L5:
        HealthScoreLog.INSTANCE.i(SOURCE, "notifyScoreEvent event=" + r4 + " currentScore=" + r5.getInt(Const.CURRENT_SCORE) + " totalScore=" + r5.getInt(Const.TOTAL_SCORE));
        Bundle r0 = new Bundle(r5);
        r0.putString("event", r4);
        onNotify(r0);
    }

    private final IHealthOptimizeManager getHealthOptimizeManager() {
        if (this.mIsDestroyed.get() == false) goto L5;
        onCreate();
    L5:
        IHealthOptimizeManager r1 = this.healthOptimizeManager;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("healthOptimizeManager");
    L8:
        return r1;
    }
}
