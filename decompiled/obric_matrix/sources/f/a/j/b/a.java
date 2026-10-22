package f.a.j.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Runnable f17058a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f.a.i.a f17059b = null;

    /* JADX INFO: renamed from: f.a.j.b.a$a, reason: collision with other inner class name */
    static final class C0451a implements f.a.i.a {
        C0451a() {
        }

        @Override // f.a.i.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    static final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    static {
        f17058a = new b();
        f17059b = new C0451a();
    }
}
