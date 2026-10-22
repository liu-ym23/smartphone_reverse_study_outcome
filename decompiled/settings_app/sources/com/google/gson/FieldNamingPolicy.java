package com.google.gson;

/* JADX INFO: loaded from: classes4.dex */
public abstract enum FieldNamingPolicy extends Enum<FieldNamingPolicy> implements FieldNamingStrategy {
    private static final /* synthetic */ FieldNamingPolicy[] $VALUES = null;
    public static final FieldNamingPolicy IDENTITY = null;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DASHES = null;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DOTS = null;
    public static final FieldNamingPolicy LOWER_CASE_WITH_UNDERSCORES = null;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE = null;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE_WITH_SPACES = null;
    public static final FieldNamingPolicy UPPER_CASE_WITH_UNDERSCORES = null;

    private FieldNamingPolicy(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ FieldNamingPolicy(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public static FieldNamingPolicy valueOf(String r1) {
        return (FieldNamingPolicy) Enum.valueOf(FieldNamingPolicy.class, r1);
    }

    public static FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[]) $VALUES.clone();
    }

    static {
        final String r1 = "IDENTITY";
        final int r2 = 0;
        FieldNamingPolicy r0 = new AnonymousClass1(r1, r2);
        IDENTITY = r0;
        final String r3 = "UPPER_CAMEL_CASE";
        final int r4 = 1;
        FieldNamingPolicy r5 = new AnonymousClass2(r3, r4);
        UPPER_CAMEL_CASE = r5;
        final String r6 = "UPPER_CAMEL_CASE_WITH_SPACES";
        final int r7 = 2;
        FieldNamingPolicy r8 = new AnonymousClass3(r6, r7);
        UPPER_CAMEL_CASE_WITH_SPACES = r8;
        final String r9 = "UPPER_CASE_WITH_UNDERSCORES";
        final int r10 = 3;
        FieldNamingPolicy r11 = new AnonymousClass4(r9, r10);
        UPPER_CASE_WITH_UNDERSCORES = r11;
        final String r12 = "LOWER_CASE_WITH_UNDERSCORES";
        final int r13 = 4;
        FieldNamingPolicy r14 = new AnonymousClass5(r12, r13);
        LOWER_CASE_WITH_UNDERSCORES = r14;
        final String r15 = "LOWER_CASE_WITH_DASHES";
        final int r16 = 5;
        FieldNamingPolicy r17 = new AnonymousClass6(r15, r16);
        LOWER_CASE_WITH_DASHES = r17;
        final String r18 = "LOWER_CASE_WITH_DOTS";
        final int r19 = 6;
        FieldNamingPolicy r110 = new AnonymousClass7(r18, r19);
        LOWER_CASE_WITH_DOTS = r110;
        $VALUES = new FieldNamingPolicy[]{r0, r5, r8, r11, r14, r17, r110};
    }

    static String separateCamelCase(String r5, char r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        char r3 = r5.charAt(r2);
        if (Character.isUpperCase(r3) == false) goto L9;
        if (r0.length() == 0) goto L9;
        r0.append(r6);
    L9:
        r0.append(r3);
        r2 = r2 + 1;
        goto L3
    L11:
        return r0.toString();
    }

    static String upperCaseFirstLetter(String r5) {
        int r0 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L16;
        char r3 = r5.charAt(r2);
        if (Character.isLetter(r3) == true) goto L7;
        r2 = r2 + 1;
        goto L3
    L7:
        if (Character.isUpperCase(r3) == false) goto L9;
        return r5;
    L9:
        char r1 = Character.toUpperCase(r3);
        if (r2 != 0) goto L14;
        return r1 + r5.substring(1);
    L14:
        return r5.substring(0, r2) + r1 + r5.substring(r2 + 1);
    L16:
        return r5;
    }
}
