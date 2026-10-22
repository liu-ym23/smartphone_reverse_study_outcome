package kotlin.s0.w.d.l0.i;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class l extends m {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final q f20360e;

    static /* synthetic */ class a {
    }

    static class b<K> implements Map.Entry<K, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Map.Entry<K, l> f20361f;

        private b(Map.Entry<K, l> r1) {
            this.f20361f = r1;
        }

        /* synthetic */ b(Map.Entry r1, a r2) {
            this(r1);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f20361f.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            l r0 = this.f20361f.getValue();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.e();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object r2) {
            if ((r2 instanceof q) == false) goto L7;
            return this.f20361f.getValue().d((q) r2);
        L7:
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f20362f;

        public c(Iterator<Map.Entry<K, Object>> r1) {
            this.f20362f = r1;
        }

        public Map.Entry<K, Object> b() {
            Map.Entry<K, Object> r2 = this.f20362f.next();
            if ((r2.getValue() instanceof l) == true) goto L5;
            return r2;
        L5:
            return new b(r2, null);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20362f.hasNext();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return b();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f20362f.remove();
        }
    }

    public q e() {
        return c(this.f20360e);
    }

    public boolean equals(Object r1) {
        return e().equals(r1);
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        return e().toString();
    }
}
