package kotlin;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum LazyThreadSafetyMode extends Enum<LazyThreadSafetyMode> {
    public static final /* synthetic */ LazyThreadSafetyMode[] b = null;

    static {
        b = new LazyThreadSafetyMode[]{new LazyThreadSafetyMode("SYNCHRONIZED", 0), new LazyThreadSafetyMode("PUBLICATION", 1), new LazyThreadSafetyMode("NONE", 2)};
    }

    public static LazyThreadSafetyMode valueOf(String r1) {
        return (LazyThreadSafetyMode) Enum.valueOf(LazyThreadSafetyMode.class, r1);
    }

    public static LazyThreadSafetyMode[] values() {
        return (LazyThreadSafetyMode[]) b.clone();
    }
}
