package androidx.work;

import kotlin.Metadata;

/* JADX INFO: compiled from: BackoffPolicy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/work/BackoffPolicy;", "", "(Ljava/lang/String;I)V", "EXPONENTIAL", "LINEAR", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum BackoffPolicy extends Enum<BackoffPolicy> {
    private static final /* synthetic */ BackoffPolicy[] $VALUES = null;
    public static final BackoffPolicy EXPONENTIAL = null;
    public static final BackoffPolicy LINEAR = null;

    private static final /* synthetic */ BackoffPolicy[] $values() {
        return new BackoffPolicy[]{EXPONENTIAL, LINEAR};
    }

    public static BackoffPolicy valueOf(String r1) {
        return (BackoffPolicy) Enum.valueOf(BackoffPolicy.class, r1);
    }

    public static BackoffPolicy[] values() {
        return (BackoffPolicy[]) $VALUES.clone();
    }

    private BackoffPolicy(String r1, int r2) {
        super(r1, r2);
    }

    static {
        EXPONENTIAL = new BackoffPolicy("EXPONENTIAL", 0);
        LINEAR = new BackoffPolicy("LINEAR", 1);
        $VALUES = $values();
    }
}
