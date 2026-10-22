package f.a.j.e;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: f.a.j.e.a$a, reason: collision with other inner class name */
    static final class C0455a extends Throwable {
        C0455a() {
            super("No further exceptions");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    static {
        new C0455a();
    }

    public static RuntimeException a(Throwable r1) {
        if ((r1 instanceof Error) == true) goto L11;
        if ((r1 instanceof RuntimeException) == false) goto L9;
        return (RuntimeException) r1;
    L9:
        return new RuntimeException(r1);
    L11:
        throw ((Error) r1);
    }
}
