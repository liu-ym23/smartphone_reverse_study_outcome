package d.b.s.a.s.e;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class b implements Comparable<b> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String[] f14903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String[] f14904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f14905i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f14906j;

    static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f14907f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f14908g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f14909h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ a[] f14910i = null;

        static {
            a r0 = new a("STABLE", 0);
            f14907f = r0;
            a r1 = new a("RC", 1);
            f14908g = r1;
            a r3 = new a("ALPHA", 2);
            f14909h = r3;
            f14910i = new a[]{r0, r1, r3};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f14910i.clone();
        }
    }

    public b(String r4, int r5) {
        this.f14903g = null;
        this.f14904h = null;
        this.f14905i = a.f14907f;
        this.f14906j = r5;
        this.f14902f = r4;
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        String[] r6 = this.f14902f.split("-");
        this.f14903g = r6[0].split("\\.");
        if (r6.length <= 1) goto L14;
        String[] r7 = r6[1].split("\\.");
        this.f14904h = r7;
        if ("rc".equalsIgnoreCase(r7[0]) == false) goto L12;
        a r8 = a.f14908g;
    L10:
        this.f14905i = r8;
        return;
    L12:
        if ("alpha".equalsIgnoreCase(this.f14904h[0]) == false) goto L16;
        r8 = a.f14909h;
        goto L10
    L16:
        return;
    }

    public static boolean b(CharSequence r0) {
        return TextUtils.isEmpty(r0);
    }

    public int a(b r8) {
        int r0 = this.f14906j - r8.f14906j;
        if (r0 == 0) goto L6;
        return r0;
    L6:
        if (b(this.f14902f) == false) goto L11;
        if (b(r8.f14902f) == false) goto L11;
        return 0;
    L11:
        if (b(r8.f14902f) == false) goto L14;
        return 1;
    L14:
        if (b(this.f14902f) == false) goto L17;
        return -1;
    L17:
        if (this.f14902f.equals(r8.f14902f) == false) goto L19;
        return 0;
    L19:
        int r1 = Math.min(this.f14903g.length, r8.f14903g.length);
        int r4 = 0;
    L20:
        if (r4 >= r1) goto L26;
        int r5 = Integer.parseInt(this.f14903g[r4]) - Integer.parseInt(r8.f14903g[r4]);
        if (r5 != 0) goto L23;
        r4 = r4 + 1;
        goto L20
    L23:
        return r5;
    L26:
        if (this.f14903g.length <= r1) goto L29;
        return 1;
    L29:
        if (r8.f14903g.length <= r1) goto L31;
        return -1;
    L31:
        a r2 = this.f14905i;
        a r6 = a.f14907f;
        if (r2 == r6) goto L34;
    L36:
        a r3 = a.f14908g;
        if (r2 == r3) goto L39;
    L40:
        a r7 = a.f14909h;
        if (r2 == r7) goto L43;
    L46:
        if (r2 != r6) goto L49;
        return 1;
    L49:
        if (r8.f14905i != r6) goto L51;
        return -1;
    L51:
        if (r2 != r3) goto L53;
        return 1;
    L53:
        return -1;
    L43:
        if (r8.f14905i != r7) goto L46;
    L45:
        return Integer.parseInt(this.f14904h[1]) - Integer.parseInt(r8.f14904h[1]);
    L39:
        if (r8.f14905i == r3) goto L45;
    L34:
        if (r8.f14905i != r6) goto L36;
        return 0;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(b r1) {
        return a(r1);
    }
}
