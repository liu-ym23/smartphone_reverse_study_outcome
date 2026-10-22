package cz.msebera.android.httpclient.annotation;

/* JADX INFO: loaded from: classes5.dex */
public final enum ThreadingBehavior extends Enum<ThreadingBehavior> {
    private static final /* synthetic */ ThreadingBehavior[] $VALUES = null;
    public static final ThreadingBehavior IMMUTABLE = null;
    public static final ThreadingBehavior IMMUTABLE_CONDITIONAL = null;
    public static final ThreadingBehavior SAFE = null;
    public static final ThreadingBehavior SAFE_CONDITIONAL = null;
    public static final ThreadingBehavior UNSAFE = null;

    private ThreadingBehavior(String r1, int r2) {
        super(r1, r2);
    }

    public static ThreadingBehavior valueOf(String r1) {
        return (ThreadingBehavior) Enum.valueOf(ThreadingBehavior.class, r1);
    }

    public static ThreadingBehavior[] values() {
        return (ThreadingBehavior[]) $VALUES.clone();
    }

    static {
        ThreadingBehavior r0 = new ThreadingBehavior("IMMUTABLE", 0);
        IMMUTABLE = r0;
        ThreadingBehavior r1 = new ThreadingBehavior("IMMUTABLE_CONDITIONAL", 1);
        IMMUTABLE_CONDITIONAL = r1;
        ThreadingBehavior r3 = new ThreadingBehavior("SAFE", 2);
        SAFE = r3;
        ThreadingBehavior r5 = new ThreadingBehavior("SAFE_CONDITIONAL", 3);
        SAFE_CONDITIONAL = r5;
        ThreadingBehavior r7 = new ThreadingBehavior("UNSAFE", 4);
        UNSAFE = r7;
        $VALUES = new ThreadingBehavior[]{r0, r1, r3, r5, r7};
    }
}
