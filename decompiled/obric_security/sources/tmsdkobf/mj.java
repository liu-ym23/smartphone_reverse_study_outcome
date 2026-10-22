package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public class mj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f355a;
    private int b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f356a;
        private byte b;

        public a() {
            this.f356a = new Object();
            this.b = 0;
        }

        public byte a() {
            Object r0 = this.f356a;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if ((this.b + 1) != 127) goto L7;
            this.b = 0;     // Catch: Throwable -> L10
        L7:
            byte r1 = (byte) (this.b + 1);     // Catch: Throwable -> L10
            this.b = r1;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        }
    }

    public mj() {
        this.f355a = new Object();
        this.b = 0;
    }

    public int a() {
        Object r0 = this.f355a;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if ((this.b + 1) != Integer.MAX_VALUE) goto L7;
        this.b = 0;     // Catch: Throwable -> L10
    L7:
        int r1 = this.b + 1;     // Catch: Throwable -> L10
        this.b = r1;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    }
}
