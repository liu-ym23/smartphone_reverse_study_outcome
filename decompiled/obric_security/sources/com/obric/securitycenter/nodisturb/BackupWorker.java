package com.obric.securitycenter.nodisturb;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.obric.securitycenter.api.TrackUtils;
import com.obric.securitycenter.nodisturb.utils.BlackAndWhiteUtils;
import com.obric.securitycenter.nodisturb.utils.KeywordsUtils;
import com.obric.securitycenter.nodisturb.utils.SettingsUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoDisturbBroadcastReceiver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/obric/securitycenter/nodisturb/BackupWorker;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BackupWorker extends CoroutineWorker {
    public BackupWorker(Context r2, WorkerParameters r3) {
        Intrinsics.checkNotNullParameter(r2, "appContext");
        Intrinsics.checkNotNullParameter(r3, "workerParams");
        super(r2, r3);
    }

    @Override // androidx.work.CoroutineWorker
    public Object doWork(Continuation<? super ListenableWorker.Result> r11) {
        Map<String, String> r6 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("success", "1")});
        boolean r0 = getInputData().getBoolean(NoDisturbBroadcastReceiver.EXTRA_SKIP_EXIST, false);
        KeywordsUtils r1 = KeywordsUtils.INSTANCE;     // Catch: Throwable -> L5 Exception -> L7
        Context r3 = getApplicationContext();     // Catch: Throwable -> L5 Exception -> L7
        Intrinsics.checkNotNullExpressionValue(r3, "applicationContext");     // Catch: Throwable -> L5 Exception -> L7
        r1.backup(r3, r0, r6);     // Catch: Throwable -> L5 Exception -> L7
        SettingsUtils r2 = SettingsUtils.INSTANCE;     // Catch: Throwable -> L5 Exception -> L7
        Context r4 = getApplicationContext();     // Catch: Throwable -> L5 Exception -> L7
        Intrinsics.checkNotNullExpressionValue(r4, "applicationContext");     // Catch: Throwable -> L5 Exception -> L7
        r2.backup(r4, r0, r6);     // Catch: Throwable -> L5 Exception -> L7
        BlackAndWhiteUtils r5 = BlackAndWhiteUtils.INSTANCE;     // Catch: Throwable -> L5 Exception -> L7
        Context r10 = getApplicationContext();     // Catch: Throwable -> L5 Exception -> L7
        Intrinsics.checkNotNullExpressionValue(r10, "applicationContext");     // Catch: Throwable -> L5 Exception -> L7
        r5.backup(r10, r0, r6);     // Catch: Throwable -> L5 Exception -> L7
        ListenableWorker.Result r12 = ListenableWorker.Result.success();     // Catch: Throwable -> L5 Exception -> L7
        Intrinsics.checkNotNullExpressionValue(r12, "{\n            KeywordsUt…esult.success()\n        }");     // Catch: Throwable -> L5 Exception -> L7
    L12:
        TrackUtils.trackEvent$default(TrackUtils.INSTANCE, "nodisturb_backup", r6, false, 4, null);
        return r12;
    L7:
        e = move-exception;
        String r13 = e.getMessage();     // Catch: Throwable -> L5
        if (r13 != null) goto L11;
        r13 = "";
    L11:
        r6.put("backup_failed", r13);     // Catch: Throwable -> L5
        r6.put("success", "0");     // Catch: Throwable -> L5
        r12 = ListenableWorker.Result.failure();     // Catch: Throwable -> L5
        Intrinsics.checkNotNullExpressionValue(r12, "{\n            eventMap.p…esult.failure()\n        }");     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        TrackUtils.trackEvent$default(TrackUtils.INSTANCE, "nodisturb_backup", r6, false, 4, null);
        throw th;
    }
}
