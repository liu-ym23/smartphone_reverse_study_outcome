package d.a.a.j;

/* JADX INFO: loaded from: classes.dex */
public final enum a0 extends Enum<a0> {
    public static final a0 A = null;
    public static final a0 B = null;
    public static final a0 C = null;
    public static final a0[] D = null;
    private static final /* synthetic */ a0[] E = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a0 f12465g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a0 f12466h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a0 f12467i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a0 f12468j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a0 f12469k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a0 f12470l = null;
    public static final a0 m = null;
    public static final a0 n = null;
    public static final a0 o = null;
    public static final a0 p = null;
    public static final a0 q = null;

    @Deprecated
    public static final a0 r = null;
    public static final a0 s = null;
    public static final a0 t = null;
    public static final a0 u = null;
    public static final a0 v = null;
    public static final a0 w = null;
    public static final a0 x = null;
    public static final a0 y = null;
    public static final a0 z = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f12471f;

    static {
        a0 r0 = new a0("QuoteFieldNames", 0);
        f12465g = r0;
        a0 r1 = new a0("UseSingleQuotes", 1);
        f12466h = r1;
        a0 r3 = new a0("WriteMapNullValue", 2);
        f12467i = r3;
        a0 r5 = new a0("WriteEnumUsingToString", 3);
        f12468j = r5;
        a0 r7 = new a0("UseISO8601DateFormat", 4);
        f12469k = r7;
        a0 r9 = new a0("WriteNullListAsEmpty", 5);
        f12470l = r9;
        a0 r11 = new a0("WriteNullStringAsEmpty", 6);
        m = r11;
        a0 r13 = new a0("WriteNullNumberAsZero", 7);
        n = r13;
        a0 r15 = new a0("WriteNullBooleanAsFalse", 8);
        o = r15;
        a0 r14 = new a0("SkipTransientField", 9);
        p = r14;
        a0 r12 = new a0("SortField", 10);
        q = r12;
        a0 r10 = new a0("WriteTabAsSpecial", 11);
        r = r10;
        a0 r8 = new a0("PrettyFormat", 12);
        s = r8;
        a0 r6 = new a0("WriteClassName", 13);
        t = r6;
        a0 r4 = new a0("DisableCircularReferenceDetect", 14);
        u = r4;
        a0 r2 = new a0("WriteSlashAsSpecial", 15);
        v = r2;
        a0 r16 = new a0("BrowserCompatible", 16);
        w = r16;
        a0 r17 = new a0("WriteDateUseDateFormat", 17);
        x = r17;
        a0 r18 = new a0("NotWriteRootClassName", 18);
        y = r18;
        a0 r19 = new a0("DisableCheckSpecialChar", 19);
        z = r19;
        a0 r20 = new a0("BeanToArray", 20);
        A = r20;
        a0 r21 = new a0("WriteNonStringKeyAsString", 21);
        B = r21;
        a0 r22 = new a0("NotWriteDefaultValue", 22);
        C = r22;
        E = new a0[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22};
        D = new a0[0];
    }

    private a0(String r1, int r2) {
        super(r1, r2);
        this.f12471f = 1 << ordinal();
    }

    public static int a(a0[] r4) {
        int r0 = 0;
        if (r4 != null) goto L5;
        return 0;
    L5:
        int r1 = r4.length;
        int r2 = 0;
    L6:
        if (r0 >= r1) goto L8;
        r2 = r2 | r4[r0].f12471f;
        r0 = r0 + 1;
        goto L6
    L8:
        return r2;
    }

    public static a0 valueOf(String r1) {
        return (a0) Enum.valueOf(a0.class, r1);
    }

    public static a0[] values() {
        return (a0[]) E.clone();
    }
}
