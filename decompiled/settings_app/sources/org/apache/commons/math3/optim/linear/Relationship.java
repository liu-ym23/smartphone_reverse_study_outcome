package org.apache.commons.math3.optim.linear;

/* JADX INFO: loaded from: classes6.dex */
public final enum Relationship extends Enum<Relationship> {
    private static final /* synthetic */ Relationship[] $VALUES = null;
    public static final Relationship EQ = null;
    public static final Relationship GEQ = null;
    public static final Relationship LEQ = null;
    private final String stringValue;

    /* JADX INFO: renamed from: org.apache.commons.math3.optim.linear.Relationship$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$optim$linear$Relationship = null;

        static {
            int[] r0 = new int[Relationship.values().length];
            $SwitchMap$org$apache$commons$math3$optim$linear$Relationship = r0;
            r0[Relationship.LEQ.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$apache$commons$math3$optim$linear$Relationship[Relationship.GEQ.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static Relationship valueOf(String r1) {
        return (Relationship) Enum.valueOf(Relationship.class, r1);
    }

    public static Relationship[] values() {
        return (Relationship[]) $VALUES.clone();
    }

    static {
        Relationship r0 = new Relationship("EQ", 0, "=");
        EQ = r0;
        Relationship r1 = new Relationship("LEQ", 1, "<=");
        LEQ = r1;
        Relationship r2 = new Relationship("GEQ", 2, ">=");
        GEQ = r2;
        $VALUES = new Relationship[]{r0, r1, r2};
    }

    private Relationship(String r1, int r2, String r3) {
        super(r1, r2);
        this.stringValue = r3;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.stringValue;
    }

    public Relationship oppositeRelationship() {
        int r1 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$optim$linear$Relationship[ordinal()];
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return EQ;
    L9:
        return LEQ;
    L11:
        return GEQ;
    }
}
