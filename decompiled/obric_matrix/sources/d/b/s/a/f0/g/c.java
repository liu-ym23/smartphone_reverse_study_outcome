package d.b.s.a.f0.g;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f14756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f14759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f14762g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f14763h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f14764i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private d.b.s.a.f0.g.a f14765j;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f14766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f14767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f14768c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f14769d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f14770e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f14771f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f14772g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f14773h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f14774i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private d.b.s.a.f0.g.a f14775j;

        public a() {
        }

        public c a() {
            return new c(this.f14766a, this.f14767b, this.f14768c, this.f14769d, this.f14770e, this.f14771f, this.f14772g, this.f14773h, this.f14774i, this.f14775j);
        }

        public a b(String r1) {
            this.f14771f = r1;
            return this;
        }

        public a c(Integer r2) {
            if (this.f14775j != null) goto L5;
            this.f14775j = new d.b.s.a.f0.g.a();
        L5:
            this.f14775j.b(r2);
            return this;
        }

        public a d(String r1) {
            this.f14768c = r1;
            return this;
        }

        public a e(String r1) {
            this.f14773h = r1;
            return this;
        }

        public a f(String r1) {
            this.f14774i = r1;
            return this;
        }

        public a g(String r1) {
            this.f14772g = r1;
            return this;
        }

        public a h(String r1) {
            this.f14770e = r1;
            return this;
        }

        public a i(long r1) {
            this.f14766a = r1;
            return this;
        }

        public a j(int r1) {
            this.f14767b = r1;
            return this;
        }

        public a k(long r1) {
            this.f14769d = r1;
            return this;
        }
    }

    public c(long r1, int r3, String r4, long r5, String r7, String r8, String r9, String r10, String r11, d.b.s.a.f0.g.a r12) {
        this.f14756a = r1;
        this.f14757b = r3;
        this.f14758c = r4;
        this.f14759d = r5;
        this.f14760e = r7;
        this.f14761f = r8;
        this.f14762g = r9;
        this.f14763h = r10;
        this.f14764i = r11;
        this.f14765j = r12;
    }

    public String a() {
        return this.f14761f;
    }

    public d.b.s.a.f0.g.a b() {
        return this.f14765j;
    }

    public String c() {
        return this.f14758c;
    }

    public String d() {
        return this.f14763h;
    }

    public String e() {
        return this.f14764i;
    }

    public String f() {
        return this.f14762g;
    }

    public String g() {
        return this.f14760e;
    }

    public long h() {
        return this.f14756a;
    }

    public int i() {
        return this.f14757b;
    }

    public long j() {
        return this.f14759d;
    }

    public String toString() {
        return "LoginInfo{time=" + this.f14756a + "\n, type=" + this.f14757b + "\n, info='" + this.f14758c + "'\n, uid=" + this.f14759d + "\n, secUid='" + this.f14760e + "'\n, avatarUrl='" + this.f14761f + "'\n, screenName='" + this.f14762g + "'\n, platformAvatarUrl='" + this.f14763h + "'\n, platformScreenName='" + this.f14764i + "'\n, ext=" + this.f14765j + '}';
    }
}
