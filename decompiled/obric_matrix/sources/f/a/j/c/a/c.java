package f.a.j.c.a;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class c<T> extends f.a.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final f.a.d<T> f17064f;

    static final class a<T> extends AtomicReference<f.a.g.b> implements f.a.b<T>, f.a.g.b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final f.a.c<? super T> f17065f;

        a(f.a.c<? super T> r1) {
            this.f17065f = r1;
        }

        @Override // f.a.b
        public void a() {
            f.a.g.b r0 = get();
            f.a.j.a.c r1 = f.a.j.a.c.f17051f;
            if (r0 == r1) goto L13;
            f.a.g.b r2 = getAndSet(r1);
            if (r2 == r1) goto L16;
            this.f17065f.a();     // Catch: Throwable -> L9
            if (r2 == null) goto L17;
            r2.dispose();
            return;
        L17:
            return;
        L9:
            th = move-exception;
            if (r2 == null) goto L12;
            r2.dispose();
        L12:
            throw th;
        L16:
            return;
        }

        @Override // f.a.b
        public void b(T r3) {
            f.a.g.b r0 = get();
            f.a.j.a.c r1 = f.a.j.a.c.f17051f;
            if (r0 == r1) goto L15;
            f.a.g.b r2 = getAndSet(r1);
            if (r2 == r1) goto L18;
            if (r3 != null) goto L8;
            this.f17065f.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));     // Catch: Throwable -> L11
        L9:
            if (r2 == null) goto L19;
            r2.dispose();
            return;
        L19:
            return;
        L8:
            this.f17065f.b(r3);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            if (r2 == null) goto L14;
            r2.dispose();
        L14:
            throw th;
        L18:
            return;
        }

        @Override // f.a.b
        public void c(f.a.i.c r2) {
            e(new f.a.j.a.a(r2));
        }

        @Override // f.a.b
        public boolean d(Throwable r3) {
            if (r3 != null) goto L4;
            r3 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        L4:
            f.a.g.b r0 = get();
            f.a.j.a.c r1 = f.a.j.a.c.f17051f;
            if (r0 == r1) goto L17;
            f.a.g.b r2 = getAndSet(r1);
            if (r2 == r1) goto L22;
            this.f17065f.onError(r3);     // Catch: Throwable -> L13
            if (r2 == null) goto L21;
            r2.dispose();
            return true;
        L21:
            return true;
        L13:
            th = move-exception;
            if (r2 == null) goto L16;
            r2.dispose();
        L16:
            throw th;
        L22:
            return false;
        L17:
            return false;
        }

        @Override // f.a.g.b
        public void dispose() {
            f.a.j.a.c.a(this);
        }

        public void e(f.a.g.b r1) {
            f.a.j.a.c.j(this, r1);
        }

        @Override // f.a.b
        public void onError(Throwable r1) {
            if (d(r1) == true) goto L6;
            f.a.k.a.m(r1);
            return;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", new Object[]{a.class.getSimpleName(), super.toString()});
        }
    }

    public c(f.a.d<T> r1) {
        this.f17064f = r1;
    }

    @Override // f.a.a
    protected void i(f.a.c<? super T> r2) {
        a r0 = new a(r2);
        r2.c(r0);
        this.f17064f.a(r0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        f.a.h.b.a(th);
        r0.onError(th);
    }
}
