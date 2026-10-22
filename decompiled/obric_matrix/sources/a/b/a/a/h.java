package a.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public final class h implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static n f29a;

    static {
    }

    public h() {
    }

    public <T> T a(Class<T> r1) {
        kotlin.n0.d.o.g(r1, "clazz");
        n r0 = f29a;
        if (r0 == null) goto L9;
        if (r0 != null) goto L10;
        return null;
    L10:
        return (T) ((h) r0).a(r1);
    L9:
        return (T) com.bytedance.news.common.service.manager.d.a(r1);
    }
}
