package d.e.b.a;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class j implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f16615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f16616h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f16617i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f16618j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f16619k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f16620l;
    private int m;
    private String n;
    private boolean o;
    private a p;
    private boolean q;
    private String r;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f16621f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f16622g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f16623h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f16624i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f16625j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ a[] f16626k = null;

        static {
            f16621f = new a("FROM_NUMBER_WITH_PLUS_SIGN", 0);
            f16622g = new a("FROM_NUMBER_WITH_IDD", 1);
            f16623h = new a("FROM_NUMBER_WITHOUT_PLUS_SIGN", 2);
            f16624i = new a("FROM_DEFAULT_COUNTRY", 3);
            f16625j = new a("UNSPECIFIED", 4);
            f16626k = a();
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        private static /* synthetic */ a[] a() {
            return new a[]{f16621f, f16622g, f16623h, f16624i, f16625j};
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f16626k.clone();
        }
    }

    public j() {
        this.f16614f = 0;
        this.f16615g = 0;
        this.f16617i = "";
        this.f16619k = false;
        this.m = 1;
        this.n = "";
        this.r = "";
        this.p = a.f16625j;
    }

    public j a() {
        this.o = false;
        this.p = a.f16625j;
        return this;
    }

    public boolean b(j r7) {
        if (r7 != null) goto L6;
        return false;
    L6:
        if (this != r7) goto L9;
        return true;
    L9:
        if (this.f16614f == r7.f16614f) goto L11;
        return false;
    L11:
        if (this.f16615g == r7.f16615g) goto L13;
        return false;
    L13:
        if (this.f16617i.equals(r7.f16617i) == true) goto L15;
        return false;
    L15:
        if (this.f16619k == r7.f16619k) goto L17;
        return false;
    L17:
        if (this.m == r7.m) goto L19;
        return false;
    L19:
        if (this.n.equals(r7.n) == true) goto L21;
        return false;
    L21:
        if (this.p == r7.p) goto L23;
        return false;
    L23:
        if (this.r.equals(r7.r) == true) goto L25;
        return false;
    L25:
        if (n() == r7.n()) goto L27;
        return false;
    L27:
        return true;
    }

    public int c() {
        return this.f16614f;
    }

    public a d() {
        return this.p;
    }

    public String e() {
        return this.f16617i;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof j) == true) goto L5;
    L7:
        return false;
    L5:
        if (b((j) r2) == false) goto L7;
        return true;
    }

    public long f() {
        return this.f16615g;
    }

    public int g() {
        return this.m;
    }

    public String h() {
        return this.r;
    }

    public int hashCode() {
        int r1 = (((((2173 + c()) * 53) + Long.valueOf(f()).hashCode()) * 53) + e().hashCode()) * 53;
        int r2 = 1231;
        if (o() == false) goto L5;
        int r0 = 1231;
    L6:
        int r3 = (((((((((r1 + r0) * 53) + g()) * 53) + i().hashCode()) * 53) + d().hashCode()) * 53) + h().hashCode()) * 53;
        if (n() == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r0 = 1237;
        goto L6
    }

    public String i() {
        return this.n;
    }

    public boolean j() {
        return this.o;
    }

    public boolean k() {
        return this.f16616h;
    }

    public boolean l() {
        return this.f16618j;
    }

    public boolean m() {
        return this.f16620l;
    }

    public boolean n() {
        return this.q;
    }

    public boolean o() {
        return this.f16619k;
    }

    public j p(int r1) {
        this.f16614f = r1;
        return this;
    }

    public j q(a r2) {
        Objects.requireNonNull(r2);
        this.o = true;
        this.p = r2;
        return this;
    }

    public j r(String r2) {
        Objects.requireNonNull(r2);
        this.f16616h = true;
        this.f16617i = r2;
        return this;
    }

    public j s(boolean r2) {
        this.f16618j = true;
        this.f16619k = r2;
        return this;
    }

    public j t(long r1) {
        this.f16615g = r1;
        return this;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Country Code: ");
        r0.append(this.f16614f);
        r0.append(" National Number: ");
        r0.append(this.f16615g);
        if (l() == false) goto L8;
        if (o() == false) goto L8;
        r0.append(" Leading Zero(s): true");
    L8:
        if (m() == false) goto L11;
        r0.append(" Number of leading zeros: ");
        r0.append(this.m);
    L11:
        if (k() == false) goto L14;
        r0.append(" Extension: ");
        r0.append(this.f16617i);
    L14:
        if (j() == false) goto L17;
        r0.append(" Country Code Source: ");
        r0.append(this.p);
    L17:
        if (n() == false) goto L20;
        r0.append(" Preferred Domestic Carrier Code: ");
        r0.append(this.r);
    L20:
        return r0.toString();
    }

    public j u(int r2) {
        this.f16620l = true;
        this.m = r2;
        return this;
    }

    public j v(String r2) {
        Objects.requireNonNull(r2);
        this.q = true;
        this.r = r2;
        return this;
    }

    public j w(String r1) {
        Objects.requireNonNull(r1);
        this.n = r1;
        return this;
    }
}
