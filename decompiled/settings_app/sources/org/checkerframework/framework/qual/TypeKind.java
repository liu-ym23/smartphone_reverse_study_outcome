package org.checkerframework.framework.qual;

import com.android.settings.SelectSubscription;
import com.android.vcard.VCardConstants;

/* JADX INFO: loaded from: classes6.dex */
public final enum TypeKind extends Enum<TypeKind> {
    private static final /* synthetic */ TypeKind[] $VALUES = null;
    public static final TypeKind ARRAY = null;
    public static final TypeKind BOOLEAN = null;
    public static final TypeKind BYTE = null;
    public static final TypeKind CHAR = null;
    public static final TypeKind DECLARED = null;
    public static final TypeKind DOUBLE = null;
    public static final TypeKind ERROR = null;
    public static final TypeKind EXECUTABLE = null;
    public static final TypeKind FLOAT = null;
    public static final TypeKind INT = null;
    public static final TypeKind INTERSECTION = null;
    public static final TypeKind LONG = null;
    public static final TypeKind NONE = null;
    public static final TypeKind NULL = null;
    public static final TypeKind OTHER = null;
    public static final TypeKind PACKAGE = null;
    public static final TypeKind SHORT = null;
    public static final TypeKind TYPEVAR = null;
    public static final TypeKind UNION = null;
    public static final TypeKind VOID = null;
    public static final TypeKind WILDCARD = null;

    private TypeKind(String r1, int r2) {
        super(r1, r2);
    }

    public static TypeKind valueOf(String r1) {
        return (TypeKind) Enum.valueOf(TypeKind.class, r1);
    }

    public static TypeKind[] values() {
        return (TypeKind[]) $VALUES.clone();
    }

    static {
        TypeKind r0 = new TypeKind("BOOLEAN", 0);
        BOOLEAN = r0;
        TypeKind r1 = new TypeKind("BYTE", 1);
        BYTE = r1;
        TypeKind r3 = new TypeKind("SHORT", 2);
        SHORT = r3;
        TypeKind r5 = new TypeKind("INT", 3);
        INT = r5;
        TypeKind r7 = new TypeKind("LONG", 4);
        LONG = r7;
        TypeKind r9 = new TypeKind("CHAR", 5);
        CHAR = r9;
        TypeKind r11 = new TypeKind("FLOAT", 6);
        FLOAT = r11;
        TypeKind r13 = new TypeKind("DOUBLE", 7);
        DOUBLE = r13;
        TypeKind r15 = new TypeKind("VOID", 8);
        VOID = r15;
        TypeKind r14 = new TypeKind("NONE", 9);
        NONE = r14;
        TypeKind r12 = new TypeKind("NULL", 10);
        NULL = r12;
        TypeKind r10 = new TypeKind("ARRAY", 11);
        ARRAY = r10;
        TypeKind r8 = new TypeKind("DECLARED", 12);
        DECLARED = r8;
        TypeKind r6 = new TypeKind("ERROR", 13);
        ERROR = r6;
        TypeKind r4 = new TypeKind("TYPEVAR", 14);
        TYPEVAR = r4;
        TypeKind r2 = new TypeKind("WILDCARD", 15);
        WILDCARD = r2;
        TypeKind r16 = new TypeKind(SelectSubscription.PACKAGE, 16);
        PACKAGE = r16;
        TypeKind r17 = new TypeKind("EXECUTABLE", 17);
        EXECUTABLE = r17;
        TypeKind r18 = new TypeKind(VCardConstants.PARAM_PHONE_EXTRA_TYPE_OTHER, 18);
        OTHER = r18;
        TypeKind r19 = new TypeKind("UNION", 19);
        UNION = r19;
        TypeKind r20 = new TypeKind("INTERSECTION", 20);
        INTERSECTION = r20;
        $VALUES = new TypeKind[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20};
    }
}
