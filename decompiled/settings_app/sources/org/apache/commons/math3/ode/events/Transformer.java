package org.apache.commons.math3.ode.events;

/* JADX INFO: loaded from: classes6.dex */
abstract enum Transformer extends Enum<Transformer> {
    private static final /* synthetic */ Transformer[] $VALUES = null;
    public static final Transformer MAX = null;
    public static final Transformer MIN = null;
    public static final Transformer MINUS = null;
    public static final Transformer PLUS = null;
    public static final Transformer UNINITIALIZED = null;

    protected abstract double transformed(double r1);

    private Transformer(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ Transformer(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public static Transformer valueOf(String r1) {
        return (Transformer) Enum.valueOf(Transformer.class, r1);
    }

    public static Transformer[] values() {
        return (Transformer[]) $VALUES.clone();
    }

    static {
        final String r1 = "UNINITIALIZED";
        final int r2 = 0;
        Transformer r0 = new AnonymousClass1(r1, r2);
        UNINITIALIZED = r0;
        final String r3 = "PLUS";
        final int r4 = 1;
        Transformer r5 = new AnonymousClass2(r3, r4);
        PLUS = r5;
        final String r6 = "MINUS";
        final int r7 = 2;
        Transformer r8 = new AnonymousClass3(r6, r7);
        MINUS = r8;
        final String r9 = "MIN";
        final int r10 = 3;
        Transformer r11 = new AnonymousClass4(r9, r10);
        MIN = r11;
        final String r12 = "MAX";
        final int r13 = 4;
        Transformer r14 = new AnonymousClass5(r12, r13);
        MAX = r14;
        $VALUES = new Transformer[]{r0, r5, r8, r11, r14};
    }
}
