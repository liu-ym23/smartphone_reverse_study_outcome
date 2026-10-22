package com.google.gson;

/* JADX INFO: loaded from: classes.dex */
public abstract enum FieldNamingPolicy extends Enum<FieldNamingPolicy> implements FieldNamingStrategy {
    private static final /* synthetic */ FieldNamingPolicy[] $VALUES = null;
    public static final FieldNamingPolicy IDENTITY = null;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DASHES = null;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DOTS = null;
    public static final FieldNamingPolicy LOWER_CASE_WITH_UNDERSCORES = null;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE = null;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE_WITH_SPACES = null;

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
        final String r9 = "LOWER_CASE_WITH_UNDERSCORES";
        final int r10 = 3;
        FieldNamingPolicy r11 = new AnonymousClass4(r9, r10);
        LOWER_CASE_WITH_UNDERSCORES = r11;
        final String r12 = "LOWER_CASE_WITH_DASHES";
        final int r13 = 4;
        FieldNamingPolicy r14 = new AnonymousClass5(r12, r13);
        LOWER_CASE_WITH_DASHES = r14;
        final String r15 = "LOWER_CASE_WITH_DOTS";
        final int r16 = 5;
        FieldNamingPolicy r17 = new AnonymousClass6(r15, r16);
        LOWER_CASE_WITH_DOTS = r17;
        $VALUES = new FieldNamingPolicy[]{r0, r5, r8, r11, r14, r17};
    }

    private FieldNamingPolicy(String r1, int r2) {
        super(r1, r2);
    }

    public static String separateCamelCase(String r5, String r6) {
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

    public static String upperCaseFirstLetter(String r5) {
        int r0 = r5.length() - 1;
        int r3 = 0;
    L4:
        if (Character.isLetter(r5.charAt(r3)) == true) goto L7;
        if (r3 >= r0) goto L7;
        r3 = r3 + 1;
    L7:
        char r1 = r5.charAt(r3);
        if (Character.isUpperCase(r1) == false) goto L10;
        return r5;
    L10:
        char r2 = Character.toUpperCase(r1);
        if (r3 != 0) goto L15;
        return r2 + r5.substring(1);
    L15:
        return r5.substring(0, r3) + r2 + r5.substring(r3 + 1);
    }

    public static FieldNamingPolicy valueOf(String r1) {
        return (FieldNamingPolicy) Enum.valueOf(FieldNamingPolicy.class, r1);
    }

    public static FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[]) $VALUES.clone();
    }

    public /* synthetic */ FieldNamingPolicy(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }
}
