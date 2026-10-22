package kotlin;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/DeprecationLevel;", "", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "HIDDEN", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum DeprecationLevel extends Enum<DeprecationLevel> {
    private static final /* synthetic */ DeprecationLevel[] $VALUES = null;
    public static final DeprecationLevel ERROR = null;
    public static final DeprecationLevel HIDDEN = null;
    public static final DeprecationLevel WARNING = null;

    private static final /* synthetic */ DeprecationLevel[] $values() {
        return new DeprecationLevel[]{WARNING, ERROR, HIDDEN};
    }

    public static DeprecationLevel valueOf(String r1) {
        return (DeprecationLevel) Enum.valueOf(DeprecationLevel.class, r1);
    }

    public static DeprecationLevel[] values() {
        return (DeprecationLevel[]) $VALUES.clone();
    }

    private DeprecationLevel(String r1, int r2) {
        super(r1, r2);
    }

    static {
        WARNING = new DeprecationLevel("WARNING", 0);
        ERROR = new DeprecationLevel("ERROR", 1);
        HIDDEN = new DeprecationLevel("HIDDEN", 2);
        $VALUES = $values();
    }
}
