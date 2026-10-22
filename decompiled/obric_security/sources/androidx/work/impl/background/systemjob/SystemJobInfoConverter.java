package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class SystemJobInfoConverter {
    static final String EXTRA_IS_PERIODIC = "EXTRA_IS_PERIODIC";
    static final String EXTRA_WORK_SPEC_GENERATION = "EXTRA_WORK_SPEC_GENERATION";
    static final String EXTRA_WORK_SPEC_ID = "EXTRA_WORK_SPEC_ID";
    private static final String TAG = null;
    private final ComponentName mWorkServiceComponent;

    /* JADX INFO: renamed from: androidx.work.impl.background.systemjob.SystemJobInfoConverter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$work$NetworkType = null;

        static {
            int[] r0 = new int[NetworkType.values().length];
            $SwitchMap$androidx$work$NetworkType = r0;
            r0[NetworkType.NOT_REQUIRED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$work$NetworkType[NetworkType.CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$work$NetworkType[NetworkType.UNMETERED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$androidx$work$NetworkType[NetworkType.NOT_ROAMING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$androidx$work$NetworkType[NetworkType.METERED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        TAG = Logger.tagWithPrefix("SystemJobInfoConverter");
    }

    SystemJobInfoConverter(Context context) {
        this.mWorkServiceComponent = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }

    JobInfo convert(WorkSpec workSpec, int jobId) {
        Constraints r0 = workSpec.constraints;
        PersistableBundle r1 = new PersistableBundle();
        r1.putString(EXTRA_WORK_SPEC_ID, workSpec.id);
        r1.putInt(EXTRA_WORK_SPEC_GENERATION, workSpec.getGeneration());
        r1.putBoolean(EXTRA_IS_PERIODIC, workSpec.isPeriodic());
        JobInfo.Builder r9 = new JobInfo.Builder(jobId, this.mWorkServiceComponent).setRequiresCharging(r0.requiresCharging()).setRequiresDeviceIdle(r0.requiresDeviceIdle()).setExtras(r1);
        setRequiredNetwork(r9, r0.getRequiredNetworkType());
        boolean r2 = false;
        if (r0.requiresDeviceIdle() == false) goto L5;
    L9:
        long r3 = Math.max(workSpec.calculateNextRunTime() - System.currentTimeMillis(), 0);
        if (r3 <= 0) goto L13;
        r9.setMinimumLatency(r3);
    L16:
        if (r0.hasContentUriTriggers() == false) goto L22;
        Iterator<Constraints.ContentUriTrigger> r11 = r0.getContentUriTriggers().iterator();
    L19:
        if (r11.hasNext() == false) goto L21;
        r9.addTriggerContentUri(convertContentUriTrigger(r11.next()));
        goto L19
    L21:
        r9.setTriggerContentUpdateDelay(r0.getContentTriggerUpdateDelayMillis());
        r9.setTriggerContentMaxDelay(r0.getContentTriggerMaxDelayMillis());
    L22:
        r9.setPersisted(false);
        r9.setRequiresBatteryNotLow(r0.requiresBatteryNotLow());
        r9.setRequiresStorageNotLow(r0.requiresStorageNotLow());
        if (workSpec.runAttemptCount <= 0) goto L25;
        boolean r12 = true;
    L27:
        if (r3 <= 0) goto L30;
        r2 = true;
    L30:
        if (Build.VERSION.SDK_INT < 31) goto L37;
        if (workSpec.expedited == false) goto L37;
        if (r12 == true) goto L37;
        if (r2 == true) goto L37;
        r9.setExpedited(true);
    L37:
        return r9.build();
    L25:
        r12 = false;
        goto L27
    L13:
        if (workSpec.expedited == true) goto L16;
        r9.setImportantWhileForeground(true);
        goto L16
    L5:
        if (workSpec.backoffPolicy != BackoffPolicy.LINEAR) goto L7;
        int r13 = 0;
    L8:
        r9.setBackoffCriteria(workSpec.backoffDelayDuration, r13);
        goto L9
    L7:
        r13 = 1;
        goto L8
    }

    private static JobInfo.TriggerContentUri convertContentUriTrigger(Constraints.ContentUriTrigger r2) {
        boolean r0 = r2.isTriggeredForDescendants();
        return new JobInfo.TriggerContentUri(r2.getUri(), r0 ? 1 : 0);
    }

    static void setRequiredNetwork(JobInfo.Builder builder, NetworkType networkType) {
        if (networkType != NetworkType.TEMPORARILY_UNMETERED) goto L5;
        builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        return;
    L5:
        builder.setRequiredNetworkType(convertNetworkType(networkType));
    }

    static int convertNetworkType(NetworkType networkType) {
        int r0 = AnonymousClass1.$SwitchMap$androidx$work$NetworkType[networkType.ordinal()];
        if (r0 != 1) goto L5;
        return 0;
    L5:
        if (r0 != 2) goto L7;
        return 1;
    L7:
        if (r0 != 3) goto L9;
        return 2;
    L9:
        if (r0 != 4) goto L11;
        return 3;
    L11:
        if (r0 == 5) goto L14;
        Logger.get().debug(TAG, "API version too low. Cannot convert network type value " + networkType);
        return 1;
    L14:
        return 4;
    }
}
