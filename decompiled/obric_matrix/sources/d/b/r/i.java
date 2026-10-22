package d.b.r;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    private static class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14395a;

        a(String r1, String r2) {
            this.f14395a = r1;
        }

        @Override // d.b.r.h
        public String a() {
            return this.f14395a;
        }
    }

    public static h a(String r2) {
        return new a(r2, "default");
    }
}
