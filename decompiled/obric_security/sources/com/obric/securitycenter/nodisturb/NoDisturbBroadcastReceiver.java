package com.obric.securitycenter.nodisturb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.obric.olog.OLog;
import com.obric.securitycenter.api.TrackUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoDisturbBroadcastReceiver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/securitycenter/nodisturb/NoDisturbBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "enqueueBackup", "", "context", "Landroid/content/Context;", "skipExist", "", "enqueueRestore", "onReceive", "intent", "Landroid/content/Intent;", "Companion", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NoDisturbBroadcastReceiver extends BroadcastReceiver {
    public static final Companion Companion = null;
    public static final String EXTRA_SKIP_EXIST = "skip_exist";

    /* JADX INFO: compiled from: NoDisturbBroadcastReceiver.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/securitycenter/nodisturb/NoDisturbBroadcastReceiver$Companion;", "", "()V", "EXTRA_SKIP_EXIST", "", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public NoDisturbBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r5, Intent r6) {
        String r0 = null;
        if (r6 == null) goto L5;
        String r1 = r6.getAction();
    L6:
        OLog.e("NoDisturbBroadcastReceiver", "NoDisturbBroadcastReceiver:action" + r1);
        if (r6 == null) goto L9;
        r0 = r6.getAction();
    L9:
        if (r0 == null) goto L23;
        int r2 = r0.hashCode();
        if (r2 == (-158401297)) goto L19;
        if (r2 == 1903002024) goto L16;
        return;
    L16:
        if (r0.equals(NoDisturbBroadcastReceiverKt.NO_DISTURB_RESTORE_ACTION) == false) goto L24;
        Intrinsics.checkNotNull(r5);
        enqueueRestore(r5);
        return;
    L24:
        return;
    L19:
        if (r0.equals(NoDisturbBroadcastReceiverKt.NO_DISTURB_BACKUP_ACTION) == false) goto L27;
        Intrinsics.checkNotNull(r5);
        enqueueBackup(r5, r6.getBooleanExtra(EXTRA_SKIP_EXIST, false));
        return;
    L27:
        return;
    L23:
        return;
    L5:
        r1 = null;
        goto L6
    }

    static /* synthetic */ void enqueueBackup$default(NoDisturbBroadcastReceiver r0, Context r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.enqueueBackup(r1, r2);
    }

    private final void enqueueBackup(Context r8, boolean r9) {
        Data r7 = new Data.Builder().putBoolean(EXTRA_SKIP_EXIST, r9).build();
        Intrinsics.checkNotNullExpressionValue(r7, "Builder().putBoolean(EXT…EXIST, skipExist).build()");
        OneTimeWorkRequest r10 = new OneTimeWorkRequest.Builder(BackupWorker.class).setConstraints(new Constraints.Builder().build()).setInputData(r7).build();
        WorkManager.getInstance(r8).enqueueUniqueWork("backup_work", ExistingWorkPolicy.KEEP, r10);
        TrackUtils.trackEvent$default(TrackUtils.INSTANCE, "nodisturb_backup_entry", null, false, 4, null);
    }

    private final void enqueueRestore(Context r9) {
        OneTimeWorkRequest r8 = new OneTimeWorkRequest.Builder(RestoreWorker.class).setConstraints(new Constraints.Builder().build()).build();
        WorkManager.getInstance(r9).enqueueUniqueWork("restore_work", ExistingWorkPolicy.KEEP, r8);
        TrackUtils.trackEvent$default(TrackUtils.INSTANCE, "nodisturb_restore_entry", null, false, 4, null);
    }
}
