package p000j;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f18176a = null;

    static class a implements o {
        a() {
        }

        @Override // p000j.o
        public void a(w r1, List<m> r2) {
        }

        @Override // p000j.o
        public List<m> b(w r1) {
            return Collections.emptyList();
        }
    }

    static {
        f18176a = new a();
    }

    void a(w r1, List<m> r2);

    List<m> b(w r1);
}
