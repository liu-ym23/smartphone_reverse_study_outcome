package org.checkerframework.framework.qual;

/* JADX INFO: loaded from: classes6.dex */
public final enum TypeUseLocation extends Enum<TypeUseLocation> {
    private static final /* synthetic */ TypeUseLocation[] $VALUES = null;
    public static final TypeUseLocation ALL = null;
    public static final TypeUseLocation CONSTRUCTOR_RESULT = null;
    public static final TypeUseLocation EXCEPTION_PARAMETER = null;
    public static final TypeUseLocation EXPLICIT_LOWER_BOUND = null;
    public static final TypeUseLocation EXPLICIT_UPPER_BOUND = null;
    public static final TypeUseLocation FIELD = null;
    public static final TypeUseLocation IMPLICIT_LOWER_BOUND = null;
    public static final TypeUseLocation IMPLICIT_UPPER_BOUND = null;
    public static final TypeUseLocation LOCAL_VARIABLE = null;
    public static final TypeUseLocation LOWER_BOUND = null;
    public static final TypeUseLocation OTHERWISE = null;
    public static final TypeUseLocation PARAMETER = null;
    public static final TypeUseLocation RECEIVER = null;
    public static final TypeUseLocation RESOURCE_VARIABLE = null;
    public static final TypeUseLocation RETURN = null;
    public static final TypeUseLocation UPPER_BOUND = null;

    private TypeUseLocation(String r1, int r2) {
        super(r1, r2);
    }

    public static TypeUseLocation valueOf(String r1) {
        return (TypeUseLocation) Enum.valueOf(TypeUseLocation.class, r1);
    }

    public static TypeUseLocation[] values() {
        return (TypeUseLocation[]) $VALUES.clone();
    }

    static {
        TypeUseLocation r0 = new TypeUseLocation("FIELD", 0);
        FIELD = r0;
        TypeUseLocation r1 = new TypeUseLocation("LOCAL_VARIABLE", 1);
        LOCAL_VARIABLE = r1;
        TypeUseLocation r3 = new TypeUseLocation("RESOURCE_VARIABLE", 2);
        RESOURCE_VARIABLE = r3;
        TypeUseLocation r5 = new TypeUseLocation("EXCEPTION_PARAMETER", 3);
        EXCEPTION_PARAMETER = r5;
        TypeUseLocation r7 = new TypeUseLocation("RECEIVER", 4);
        RECEIVER = r7;
        TypeUseLocation r9 = new TypeUseLocation("PARAMETER", 5);
        PARAMETER = r9;
        TypeUseLocation r11 = new TypeUseLocation("RETURN", 6);
        RETURN = r11;
        TypeUseLocation r13 = new TypeUseLocation("CONSTRUCTOR_RESULT", 7);
        CONSTRUCTOR_RESULT = r13;
        TypeUseLocation r15 = new TypeUseLocation("LOWER_BOUND", 8);
        LOWER_BOUND = r15;
        TypeUseLocation r14 = new TypeUseLocation("EXPLICIT_LOWER_BOUND", 9);
        EXPLICIT_LOWER_BOUND = r14;
        TypeUseLocation r12 = new TypeUseLocation("IMPLICIT_LOWER_BOUND", 10);
        IMPLICIT_LOWER_BOUND = r12;
        TypeUseLocation r10 = new TypeUseLocation("UPPER_BOUND", 11);
        UPPER_BOUND = r10;
        TypeUseLocation r8 = new TypeUseLocation("EXPLICIT_UPPER_BOUND", 12);
        EXPLICIT_UPPER_BOUND = r8;
        TypeUseLocation r6 = new TypeUseLocation("IMPLICIT_UPPER_BOUND", 13);
        IMPLICIT_UPPER_BOUND = r6;
        TypeUseLocation r4 = new TypeUseLocation("OTHERWISE", 14);
        OTHERWISE = r4;
        TypeUseLocation r2 = new TypeUseLocation("ALL", 15);
        ALL = r2;
        $VALUES = new TypeUseLocation[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2};
    }
}
