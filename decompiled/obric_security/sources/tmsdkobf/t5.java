package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public class t5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s0 f526a = null;

    public class a extends s0 {
        public a() {
        }

        @Override // tmsdkobf.s0
        public Object a() {
            return new t5();
        }
    }

    static {
        f526a = new a();
    }

    public t5() {
    }

    public boolean a() {
        monitor-enter(k3.class);
        monitor-exit(k3.class);
        return true;
    }

    public String toString() {
        a();
        return "1";
    }
}
