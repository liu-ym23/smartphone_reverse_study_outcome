package kotlin;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum DeprecationLevel extends Enum<DeprecationLevel> {
    public static final DeprecationLevel b = null;
    public static final DeprecationLevel c = null;
    public static final /* synthetic */ DeprecationLevel[] e = null;

    static {
        DeprecationLevel r0 = new DeprecationLevel("WARNING", 0);
        b = r0;
        DeprecationLevel r1 = new DeprecationLevel("ERROR", 1);
        c = r1;
        e = new DeprecationLevel[]{r0, r1, new DeprecationLevel("HIDDEN", 2)};
    }

    public static DeprecationLevel valueOf(String r1) {
        return (DeprecationLevel) Enum.valueOf(DeprecationLevel.class, r1);
    }

    public static DeprecationLevel[] values() {
        return (DeprecationLevel[]) e.clone();
    }
}
