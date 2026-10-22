package d.c.c.d;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class a<T> implements l<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f15386a;

        a(Object r1) {
            this.f15386a = r1;
        }

        @Override // d.c.c.d.l
        public T get() {
            return (T) this.f15386a;
        }
    }

    static {
    }

    public static <T> l<T> a(T r1) {
        return new a(r1);
    }
}
