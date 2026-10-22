package d.b.s.a.g0.a;

import com.bytedance.news.common.service.manager.IService;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    static {
    }

    public static final <T extends IService> T a(Class<T> r1) {
        o.g(r1, "clazz");
        T r0 = (T) com.bytedance.news.common.service.manager.d.a(r1);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new c(r1);
    }

    public static final <T extends IService> T b(Class<T> r1) {
        o.g(r1, "clazz");
        return (T) com.bytedance.news.common.service.manager.d.a(r1);
    }
}
