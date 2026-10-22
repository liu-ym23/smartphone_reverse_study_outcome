package org.checkerframework.framework.qual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final enum LiteralKind extends Enum<LiteralKind> {
    private static final /* synthetic */ LiteralKind[] $VALUES = null;
    public static final LiteralKind ALL = null;
    public static final LiteralKind BOOLEAN = null;
    public static final LiteralKind CHAR = null;
    public static final LiteralKind DOUBLE = null;
    public static final LiteralKind FLOAT = null;
    public static final LiteralKind INT = null;
    public static final LiteralKind LONG = null;
    public static final LiteralKind NULL = null;
    public static final LiteralKind PRIMITIVE = null;
    public static final LiteralKind STRING = null;

    private LiteralKind(String r1, int r2) {
        super(r1, r2);
    }

    public static LiteralKind valueOf(String r1) {
        return (LiteralKind) Enum.valueOf(LiteralKind.class, r1);
    }

    public static LiteralKind[] values() {
        return (LiteralKind[]) $VALUES.clone();
    }

    static {
        LiteralKind r0 = new LiteralKind("NULL", 0);
        NULL = r0;
        LiteralKind r1 = new LiteralKind("INT", 1);
        INT = r1;
        LiteralKind r3 = new LiteralKind("LONG", 2);
        LONG = r3;
        LiteralKind r5 = new LiteralKind("FLOAT", 3);
        FLOAT = r5;
        LiteralKind r7 = new LiteralKind("DOUBLE", 4);
        DOUBLE = r7;
        LiteralKind r9 = new LiteralKind("BOOLEAN", 5);
        BOOLEAN = r9;
        LiteralKind r11 = new LiteralKind("CHAR", 6);
        CHAR = r11;
        LiteralKind r13 = new LiteralKind("STRING", 7);
        STRING = r13;
        LiteralKind r15 = new LiteralKind("ALL", 8);
        ALL = r15;
        LiteralKind r14 = new LiteralKind("PRIMITIVE", 9);
        PRIMITIVE = r14;
        $VALUES = new LiteralKind[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
    }

    public static List<LiteralKind> allLiteralKinds() {
        ArrayList r0 = new ArrayList(Arrays.asList(values()));
        r0.remove(ALL);
        r0.remove(PRIMITIVE);
        return r0;
    }

    public static List<LiteralKind> primitiveLiteralKinds() {
        return Arrays.asList(new LiteralKind[]{INT, LONG, FLOAT, DOUBLE, BOOLEAN, CHAR});
    }
}
