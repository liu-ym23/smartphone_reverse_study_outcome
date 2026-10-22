package com.obric.safecheck.update;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import com.obric.olog.OLog;
import com.obric.securitycenter.api.GlobalManagerCreator;
import com.obric.securitycenter.api.IVirusDbUpdateManager;
import com.obric.securitycenter.api.VirusDbCheckResult;
import com.obric.securitycenter.api.VirusDbUpdateResult;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: VirusDbUpdateManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\rJ\u0019\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/obric/safecheck/update/VirusDbUpdateManager;", "", "()V", "KEY_AUTO_UPDATE", "", "KEY_HAS_PENDING_UPDATE", "KEY_LAST_UPDATE_TIME", "SP_NAME", "TAG", "UNIQUE_WORK_NAME", "applyAutoUpdateSetting", "", "context", "Landroid/content/Context;", "enabled", "", "cancelAutoUpdate", "checkUpdate", "getLastUpdateTime", "", "hasPendingUpdate", "isAutoUpdateEnabled", "markUpdated", "timeMillis", "scheduleAutoUpdate", "setPendingUpdate", "pending", "syncAutoUpdateSetting", "updateNow", "Lcom/obric/securitycenter/api/VirusDbUpdateResult;", "updateNowAsync", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class VirusDbUpdateManager {
    public static final VirusDbUpdateManager INSTANCE = null;
    public static final String KEY_AUTO_UPDATE = "auto_update";
    public static final String KEY_HAS_PENDING_UPDATE = "has_pending_virus_update";
    public static final String KEY_LAST_UPDATE_TIME = "last_virus_update_time";
    private static final String SP_NAME = "safe_check_settings";
    private static final String TAG = "VirusDbUpdateManager";
    private static final String UNIQUE_WORK_NAME = "VirusDbAutoUpdateWork";

    /* JADX INFO: renamed from: com.obric.safecheck.update.VirusDbUpdateManager$updateNowAsync$2, reason: invalid class name */
    /* JADX INFO: compiled from: VirusDbUpdateManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lcom/obric/securitycenter/api/VirusDbUpdateResult;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.safecheck.update.VirusDbUpdateManager$updateNowAsync$2", f = "VirusDbUpdateManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super VirusDbUpdateResult>, Object> {
        final /* synthetic */ Context $context;
        int label;

        AnonymousClass2(Context r1, Continuation r2) {
            this.$context = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "completion");
            return new AnonymousClass2(this.$context, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super VirusDbUpdateResult> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return VirusDbUpdateManager.INSTANCE.updateNow(this.$context);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        INSTANCE = new VirusDbUpdateManager();
    }

    private VirusDbUpdateManager() {
    }

    @JvmStatic
    public static final void applyAutoUpdateSetting(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        OLog.i(TAG, "applyAutoUpdateSetting enabled=" + r3);
        if (r3 == false) goto L5;
        scheduleAutoUpdate(r2);
        return;
    L5:
        cancelAutoUpdate(r2);
    }

    @JvmStatic
    public static final void syncAutoUpdateSetting(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Context r4 = r3.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r4, "appContext");
        boolean r0 = isAutoUpdateEnabled(r4);
        OLog.i(TAG, "syncAutoUpdateSetting enabled=" + r0);
        applyAutoUpdateSetting(r4, r0);
    }

    @JvmStatic
    public static final void scheduleAutoUpdate(Context r12) {
        Intrinsics.checkNotNullParameter(r12, "context");
        long r0 = SystemClock.elapsedRealtime();
        WorkManager.getInstance(r12.getApplicationContext()).enqueueUniquePeriodicWork(UNIQUE_WORK_NAME, ExistingPeriodicWorkPolicy.KEEP, new PeriodicWorkRequest.Builder(VirusDbUpdateWorker.class, 1, TimeUnit.DAYS, 6, TimeUnit.HOURS).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.UNMETERED).setRequiresBatteryNotLow(true).build()).addTag(UNIQUE_WORK_NAME).build());
        OLog.i(TAG, "scheduleAutoUpdate costMs=" + (SystemClock.elapsedRealtime() - r0));
    }

    @JvmStatic
    public static final void cancelAutoUpdate(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        long r0 = SystemClock.elapsedRealtime();
        WorkManager.getInstance(r4.getApplicationContext()).cancelUniqueWork(UNIQUE_WORK_NAME);
        OLog.i(TAG, "cancelAutoUpdate costMs=" + (SystemClock.elapsedRealtime() - r0));
    }

    @JvmStatic
    public static final boolean isAutoUpdateEnabled(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return r2.getSharedPreferences(SP_NAME, 0).getBoolean(KEY_AUTO_UPDATE, true);
    }

    public final VirusDbUpdateResult updateNow(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        IVirusDbUpdateManager r0 = (IVirusDbUpdateManager) GlobalManagerCreator.INSTANCE.getManager(IVirusDbUpdateManager.class);
        if (r0 != null) goto L6;
        OLog.e(TAG, "IVirusDbUpdateManager not registered");
        return new VirusDbUpdateResult(false, false, 0, 6, null);
    L6:
        VirusDbUpdateResult r1 = r0.updateVirusDbSync();
        if (r1.getSuccess() == false) goto L9;
        markUpdated(r7, System.currentTimeMillis());
    L9:
        return r1;
    }

    public final Object updateNowAsync(Context r3, Continuation<? super VirusDbUpdateResult> r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(r3, null), r4);
    }

    public final boolean checkUpdate(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        IVirusDbUpdateManager r0 = (IVirusDbUpdateManager) GlobalManagerCreator.INSTANCE.getManager(IVirusDbUpdateManager.class);
        if (r0 != null) goto L6;
        OLog.e(TAG, "IVirusDbUpdateManager not registered");
        return hasPendingUpdate(r3);
    L6:
        VirusDbCheckResult r1 = r0.checkVirusDbUpdateSync();
        if (r1.getSuccess() == false) goto L12;
        if (r1.getHasUpdate() == false) goto L12;
        setPendingUpdate(r3, true);
    L12:
        return hasPendingUpdate(r3);
    }

    public final boolean hasPendingUpdate(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return r2.getSharedPreferences(SP_NAME, 0).getBoolean(KEY_HAS_PENDING_UPDATE, false);
    }

    private final void setPendingUpdate(Context r2, boolean r3) {
        SharedPreferences r1 = r2.getSharedPreferences(SP_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(r1, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        SharedPreferences.Editor r4 = r1.edit();
        Intrinsics.checkNotNullExpressionValue(r4, "editor");
        r4.putBoolean(KEY_HAS_PENDING_UPDATE, r3);
        r4.apply();
    }

    public final long getLastUpdateTime(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return r3.getSharedPreferences(SP_NAME, 0).getLong(KEY_LAST_UPDATE_TIME, 0);
    }

    private final void markUpdated(Context r2, long r3) {
        SharedPreferences r1 = r2.getSharedPreferences(SP_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(r1, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        SharedPreferences.Editor r4 = r1.edit();
        Intrinsics.checkNotNullExpressionValue(r4, "editor");
        r4.putLong(KEY_LAST_UPDATE_TIME, r3);
        r4.putBoolean(KEY_HAS_PENDING_UPDATE, false);
        r4.apply();
    }
}
