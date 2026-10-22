package d.e.b.a.k;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a<String, Pattern> f16628a;

    private static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LinkedHashMap<K, V> f16629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f16630b;

        /* JADX INFO: renamed from: d.e.b.a.k.d$a$a, reason: collision with other inner class name */
        class C0437a extends LinkedHashMap<K, V> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ a f16631f;

            C0437a(a r1, int r2, float r3, boolean r4) {
                this.f16631f = r1;
                super(r2, r3, r4);
            }

            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<K, V> r1) {
                if (size() <= a.a(this.f16631f)) goto L5;
                return true;
            L5:
                return false;
            }
        }

        public a(int r4) {
            this.f16630b = r4;
            this.f16629a = new C0437a(this, ((r4 * 4) / 3) + 1, 0.75f, true);
        }

        static /* synthetic */ int a(a r0) {
            return r0.f16630b;
        }

        public synchronized V b(K r2) {
            monitor-enter(this);
            V r3 = this.f16629a.get(r2);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r3;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void c(K r2, V r3) {
            monitor-enter(this);
            this.f16629a.put(r2, r3);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public d(int r2) {
        this.f16628a = new a(r2);
    }

    public Pattern a(String r2) {
        Pattern r0 = this.f16628a.b(r2);
        if (r0 != null) goto L6;
        Pattern r1 = Pattern.compile(r2);
        this.f16628a.c(r2, r1);
        return r1;
    L6:
        return r0;
    }
}
