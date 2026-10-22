package com.google.errorprone.annotations;

/* JADX INFO: loaded from: classes4.dex */
public final enum Modifier extends Enum<Modifier> {
    private static final /* synthetic */ Modifier[] $VALUES = null;
    public static final Modifier ABSTRACT = null;
    public static final Modifier DEFAULT = null;
    public static final Modifier FINAL = null;
    public static final Modifier NATIVE = null;
    public static final Modifier PRIVATE = null;
    public static final Modifier PROTECTED = null;
    public static final Modifier PUBLIC = null;
    public static final Modifier STATIC = null;
    public static final Modifier STRICTFP = null;
    public static final Modifier SYNCHRONIZED = null;
    public static final Modifier TRANSIENT = null;
    public static final Modifier VOLATILE = null;

    private static /* synthetic */ Modifier[] $values() {
        return new Modifier[]{PUBLIC, PROTECTED, PRIVATE, ABSTRACT, DEFAULT, STATIC, FINAL, TRANSIENT, VOLATILE, SYNCHRONIZED, NATIVE, STRICTFP};
    }

    private Modifier(String r1, int r2) {
        super(r1, r2);
    }

    public static Modifier valueOf(String r1) {
        return (Modifier) Enum.valueOf(Modifier.class, r1);
    }

    public static Modifier[] values() {
        return (Modifier[]) $VALUES.clone();
    }

    static {
        PUBLIC = new Modifier("PUBLIC", 0);
        PROTECTED = new Modifier("PROTECTED", 1);
        PRIVATE = new Modifier("PRIVATE", 2);
        ABSTRACT = new Modifier("ABSTRACT", 3);
        DEFAULT = new Modifier("DEFAULT", 4);
        STATIC = new Modifier("STATIC", 5);
        FINAL = new Modifier("FINAL", 6);
        TRANSIENT = new Modifier("TRANSIENT", 7);
        VOLATILE = new Modifier("VOLATILE", 8);
        SYNCHRONIZED = new Modifier("SYNCHRONIZED", 9);
        NATIVE = new Modifier("NATIVE", 10);
        STRICTFP = new Modifier("STRICTFP", 11);
        $VALUES = $values();
    }
}
