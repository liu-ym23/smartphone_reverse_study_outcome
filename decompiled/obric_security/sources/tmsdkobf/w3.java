package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public class w3 implements v {
    public static final byte[] j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f594a;
    public final long b;
    public final int c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public int h;
    public int i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f595a;
        public long b;
        public int c;
        public String d;
        public String e;
        public String f;
        public String g;

        public a(int r1) {
            this.c = r1;
        }

        public static /* synthetic */ String a(a r0) {
            return r0.f595a;
        }

        public static /* synthetic */ long b(a r2) {
            return r2.b;
        }

        public static /* synthetic */ int c(a r0) {
            return r0.c;
        }

        public static /* synthetic */ String d(a r0) {
            return r0.d;
        }

        public static /* synthetic */ String e(a r0) {
            return r0.e;
        }

        public static /* synthetic */ String f(a r0) {
            return r0.f;
        }

        public static /* synthetic */ String g(a r0) {
            return r0.g;
        }
    }

    static {
        j = new byte[0];
    }

    public w3(int r3, byte[] r4, int r5, int r6) {
        this.f594a = "";
        this.b = 0;
        this.c = r3;
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = r5;
        this.i = r6;
    }

    public static w3 a(int r3) {
        return new w3(r3, j, 0, 0);
    }

    public w3(a r3) {
        this.h = 0;
        this.i = 0;
        this.f594a = a.a(r3);
        this.b = a.b(r3);
        this.c = a.c(r3);
        this.d = a.d(r3);
        this.e = a.e(r3);
        this.f = a.f(r3);
        this.g = a.g(r3);
    }
}
