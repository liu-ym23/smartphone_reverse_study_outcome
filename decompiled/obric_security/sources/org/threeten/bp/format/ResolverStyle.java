package org.threeten.bp.format;

/* JADX INFO: loaded from: classes5.dex */
public final enum ResolverStyle extends Enum<ResolverStyle> {
    private static final /* synthetic */ ResolverStyle[] $VALUES = null;
    public static final ResolverStyle LENIENT = null;
    public static final ResolverStyle SMART = null;
    public static final ResolverStyle STRICT = null;

    private ResolverStyle(String r1, int r2) {
        super(r1, r2);
    }

    public static ResolverStyle valueOf(String r1) {
        return (ResolverStyle) Enum.valueOf(ResolverStyle.class, r1);
    }

    public static ResolverStyle[] values() {
        return (ResolverStyle[]) $VALUES.clone();
    }

    static {
        ResolverStyle r0 = new ResolverStyle("STRICT", 0);
        STRICT = r0;
        ResolverStyle r1 = new ResolverStyle("SMART", 1);
        SMART = r1;
        ResolverStyle r3 = new ResolverStyle("LENIENT", 2);
        LENIENT = r3;
        $VALUES = new ResolverStyle[]{r0, r1, r3};
    }
}
