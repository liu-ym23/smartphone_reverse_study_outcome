package d.b.h.a.a.h.q.d.a;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import d.b.r.f;
import d.b.r.k0.g;
import d.b.r.k0.j;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
final class b<T> implements f<T, j> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Charset f13711c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gson f13712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TypeAdapter<T> f13713b;

    static {
        f13711c = Charset.forName("UTF-8");
    }

    b(Gson r1, TypeAdapter<T> r2) {
        this.f13712a = r1;
        this.f13713b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.b.r.f
    public /* bridge */ /* synthetic */ j a(Object r1) {
        return b(r1);
    }

    public j b(T r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(1024);
        OutputStreamWriter r1 = new OutputStreamWriter(r0, f13711c);
        com.google.gson.a0.c r2 = this.f13712a.t(r1);
        this.f13713b.d(r2, r4);
        r2.close();
        return new g("application/json; charset=UTF-8", r0.toByteArray(), new String[0]);
    }
}
