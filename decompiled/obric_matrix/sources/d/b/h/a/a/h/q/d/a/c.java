package d.b.h.a.a.h.q.d.a;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import d.b.r.f;
import d.b.r.k0.d;
import d.b.r.k0.i;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
final class c<T> implements f<i, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gson f13714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TypeAdapter<T> f13715b;

    c(Gson r1, TypeAdapter<T> r2) {
        this.f13714a = r1;
        this.f13715b = r2;
    }

    @Override // d.b.r.f
    public /* bridge */ /* synthetic */ Object a(i r1) {
        return b(r1);
    }

    public T b(i r3) {
        String r1 = "UTF-8";
        if (r3.a() == null) goto L5;
        r1 = d.a(r3.a(), "UTF-8");
    L5:
        InputStreamReader r0 = new InputStreamReader(r3.d(), r1);
        com.google.gson.a0.a r4 = this.f13714a.s(r0);
        T r2 = this.f13715b.b(r4);     // Catch: Throwable -> L9
        r0.close();     // Catch: IOException -> L12
    L8:
        return r2;
    L9:
        th = move-exception;
        r0.close();     // Catch: IOException -> L13
    L11:
        throw th;
    }
}
