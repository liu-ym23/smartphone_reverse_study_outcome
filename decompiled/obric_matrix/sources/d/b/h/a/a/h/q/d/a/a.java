package d.b.h.a.a.h.q.d.a;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import d.b.r.f;
import d.b.r.k0.i;
import d.b.r.k0.j;
import d.b.r.v;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class a extends f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gson f13710a;

    private a(Gson r2) {
        Objects.requireNonNull(r2, "gson == null");
        this.f13710a = r2;
    }

    public static a f() {
        return g(new Gson());
    }

    public static a g(Gson r1) {
        return new a(r1);
    }

    @Override // d.b.r.f.a
    public f<?, j> c(Type r1, Annotation[] r2, Annotation[] r3, v r4) {
        TypeAdapter r5 = this.f13710a.o(com.google.gson.z.a.get(r1));
        return new b(this.f13710a, r5);
    }

    @Override // d.b.r.f.a
    public f<i, ?> d(Type r1, Annotation[] r2, v r3) {
        TypeAdapter r4 = this.f13710a.o(com.google.gson.z.a.get(r1));
        return new c(this.f13710a, r4);
    }
}
