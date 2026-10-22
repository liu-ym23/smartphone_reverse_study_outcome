package androidx.work;

import kotlin.Metadata;

/* JADX INFO: compiled from: ExistingWorkPolicy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/work/ExistingWorkPolicy;", "", "(Ljava/lang/String;I)V", "REPLACE", "KEEP", "APPEND", "APPEND_OR_REPLACE", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum ExistingWorkPolicy extends Enum<ExistingWorkPolicy> {
    private static final /* synthetic */ ExistingWorkPolicy[] $VALUES = null;
    public static final ExistingWorkPolicy APPEND = null;
    public static final ExistingWorkPolicy APPEND_OR_REPLACE = null;
    public static final ExistingWorkPolicy KEEP = null;
    public static final ExistingWorkPolicy REPLACE = null;

    private static final /* synthetic */ ExistingWorkPolicy[] $values() {
        return new ExistingWorkPolicy[]{REPLACE, KEEP, APPEND, APPEND_OR_REPLACE};
    }

    public static ExistingWorkPolicy valueOf(String r1) {
        return (ExistingWorkPolicy) Enum.valueOf(ExistingWorkPolicy.class, r1);
    }

    public static ExistingWorkPolicy[] values() {
        return (ExistingWorkPolicy[]) $VALUES.clone();
    }

    private ExistingWorkPolicy(String r1, int r2) {
        super(r1, r2);
    }

    static {
        REPLACE = new ExistingWorkPolicy("REPLACE", 0);
        KEEP = new ExistingWorkPolicy("KEEP", 1);
        APPEND = new ExistingWorkPolicy("APPEND", 2);
        APPEND_OR_REPLACE = new ExistingWorkPolicy("APPEND_OR_REPLACE", 3);
        $VALUES = $values();
    }
}
