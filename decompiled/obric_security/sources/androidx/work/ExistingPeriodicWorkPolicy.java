package androidx.work;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: compiled from: ExistingPeriodicWorkPolicy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/work/ExistingPeriodicWorkPolicy;", "", "(Ljava/lang/String;I)V", "REPLACE", "KEEP", "UPDATE", "CANCEL_AND_REENQUEUE", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum ExistingPeriodicWorkPolicy extends Enum<ExistingPeriodicWorkPolicy> {
    private static final /* synthetic */ ExistingPeriodicWorkPolicy[] $VALUES = null;
    public static final ExistingPeriodicWorkPolicy CANCEL_AND_REENQUEUE = null;
    public static final ExistingPeriodicWorkPolicy KEEP = null;

    @Deprecated(message = "Deprecated in favor of the UPDATE policy. UPDATE policy has very similar behavior: next run of the worker with the same unique name, going to have new specification. However, UPDATE has better defaults: unlike REPLACE policy UPDATE won't cancel the worker if it is currently running and new worker specification will be used only on the next run. Also it preserves original enqueue time, so unlike REPLACE period isn't reset. If you want to preserve previous behavior, CANCEL_AND_REENQUEUE should be used.", replaceWith = @ReplaceWith(expression = "UPDATE", imports = {}))
    public static final ExistingPeriodicWorkPolicy REPLACE = null;
    public static final ExistingPeriodicWorkPolicy UPDATE = null;

    private static final /* synthetic */ ExistingPeriodicWorkPolicy[] $values() {
        return new ExistingPeriodicWorkPolicy[]{REPLACE, KEEP, UPDATE, CANCEL_AND_REENQUEUE};
    }

    public static ExistingPeriodicWorkPolicy valueOf(String r1) {
        return (ExistingPeriodicWorkPolicy) Enum.valueOf(ExistingPeriodicWorkPolicy.class, r1);
    }

    public static ExistingPeriodicWorkPolicy[] values() {
        return (ExistingPeriodicWorkPolicy[]) $VALUES.clone();
    }

    private ExistingPeriodicWorkPolicy(String r1, int r2) {
        super(r1, r2);
    }

    static {
        REPLACE = new ExistingPeriodicWorkPolicy("REPLACE", 0);
        KEEP = new ExistingPeriodicWorkPolicy("KEEP", 1);
        UPDATE = new ExistingPeriodicWorkPolicy("UPDATE", 2);
        CANCEL_AND_REENQUEUE = new ExistingPeriodicWorkPolicy("CANCEL_AND_REENQUEUE", 3);
        $VALUES = $values();
    }
}
