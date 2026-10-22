package d.b.s.a.g0.a;

import com.bytedance.news.common.service.manager.IService;
import kotlin.n0.d.o;
import kotlin.s0.l;

/* JADX INFO: loaded from: classes.dex */
public final class a<T extends IService> implements kotlin.p0.c<Object, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<T> f14776a;

    public a(Class<T> r2) {
        o.g(r2, "clazz");
        this.f14776a = r2;
    }

    @Override // kotlin.p0.c
    public /* bridge */ /* synthetic */ Object a(Object r1, l r2) {
        return c(r1, r2);
    }

    public T c(Object r1, l<?> r2) {
        o.g(r2, "property");
        return (T) d.b(this.f14776a);
    }
}
