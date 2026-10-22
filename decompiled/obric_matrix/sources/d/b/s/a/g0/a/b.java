package d.b.s.a.g0.a;

import com.bytedance.news.common.service.manager.IService;
import kotlin.n0.d.o;
import kotlin.s0.l;

/* JADX INFO: loaded from: classes.dex */
public final class b<T extends IService> implements kotlin.p0.c<Object, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<T> f14777a;

    public b(Class<T> r2) {
        o.g(r2, "clazz");
        this.f14777a = r2;
    }

    @Override // kotlin.p0.c
    public /* bridge */ /* synthetic */ Object a(Object r1, l r2) {
        return c(r1, r2);
    }

    public T c(Object r1, l<?> r2) {
        o.g(r2, "property");
        return (T) d.a(this.f14777a);
    }
}
