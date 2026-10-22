package d.a.a.i;

/* JADX INFO: loaded from: classes.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f12397g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f12398h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f12399i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final d f12400j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final d f12401k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d f12402l = null;
    public static final d m = null;
    public static final d n = null;
    public static final d o = null;
    public static final d p = null;
    public static final d q = null;
    public static final d r = null;
    public static final d s = null;
    public static final d t = null;
    public static final d u = null;
    public static final d v = null;
    public static final d w = null;
    private static final /* synthetic */ d[] x = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f12403f;

    static {
        d r0 = new d("AutoCloseSource", 0);
        f12397g = r0;
        d r1 = new d("AllowComment", 1);
        f12398h = r1;
        d r3 = new d("AllowUnQuotedFieldNames", 2);
        f12399i = r3;
        d r5 = new d("AllowSingleQuotes", 3);
        f12400j = r5;
        d r7 = new d("InternFieldNames", 4);
        f12401k = r7;
        d r9 = new d("AllowISO8601DateFormat", 5);
        f12402l = r9;
        d r11 = new d("AllowArbitraryCommas", 6);
        m = r11;
        d r13 = new d("UseBigDecimal", 7);
        n = r13;
        d r15 = new d("IgnoreNotMatch", 8);
        o = r15;
        d r14 = new d("SortFeidFastMatch", 9);
        p = r14;
        d r12 = new d("DisableASM", 10);
        q = r12;
        d r10 = new d("DisableCircularReferenceDetect", 11);
        r = r10;
        d r8 = new d("InitStringFieldAsEmpty", 12);
        s = r8;
        d r6 = new d("SupportArrayToBean", 13);
        t = r6;
        d r4 = new d("OrderedField", 14);
        u = r4;
        d r2 = new d("DisableSpecialKeyDetect", 15);
        v = r2;
        d r16 = new d("SupportNonPublicField", 16);
        w = r16;
        x = new d[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16};
    }

    private d(String r1, int r2) {
        super(r1, r2);
        this.f12403f = 1 << ordinal();
    }

    public static d valueOf(String r1) {
        return (d) Enum.valueOf(d.class, r1);
    }

    public static d[] values() {
        return (d[]) x.clone();
    }
}
