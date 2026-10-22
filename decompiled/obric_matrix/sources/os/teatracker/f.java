package os.teatracker;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f22709f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static String f22710g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f22711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f22712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f22713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f22714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, Object> f22715e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f22716a;

        public a() {
            this.f22716a = new f();
        }

        public f a() {
            return this.f22716a;
        }

        public a b(String r2) {
            this.f22716a.e(r2);
            return this;
        }

        public a c(String r2) {
            this.f22716a.f(r2);
            return this;
        }
    }

    static {
        f22709f = k.d();
        f22710g = "CommonLog";
    }

    public f() {
    }

    public String a() {
        return this.f22711a;
    }

    public String b() {
        return this.f22712b;
    }

    public String c() {
        return this.f22713c;
    }

    public Map<String, Object> d() {
        return this.f22715e;
    }

    void e(String r1) {
        this.f22711a = r1;
    }

    public void f(String r1) {
        this.f22712b = r1;
    }

    public String toString() {
        return "TeaConfig{keepTeaServiceConnected=" + this.f22714d + '}';
    }
}
