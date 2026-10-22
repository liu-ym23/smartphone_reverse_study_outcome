package com.obric.matrix.biz_example;

import com.obric.matrix.biz_example_api.IBizExample;
import com.obric.matrix.s.e;
import com.obric.matrix.w.b0;
import com.obric.matrix.w.c0;
import com.obric.matrix.w.e0;
import f.a.b;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0017¨\u0006\b"}, d2 = {"Lcom/obric/matrix/biz_example/BizExampleImpl;", "Lcom/obric/matrix/biz_example_api/IBizExample;", "()V", "testFun", "Lio/reactivex/Maybe;", "Lcom/obric/matrix/model/BaseResponseBody;", "request", "Lcom/obric/matrix/proto/Request;", "biz_example_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BizExampleImpl implements IBizExample {
    public BizExampleImpl() {
    }

    public static /* synthetic */ void a(b0 r0, b r1) {
        m52testFun$lambda0(r0, r1);
    }

    /* JADX INFO: renamed from: testFun$lambda-0, reason: not valid java name */
    private static final void m52testFun$lambda0(b0 r3, b r4) {
        o.f(r3, "$request");
        o.f(r4, "it");
        c0 r0 = r3.o;
        if (r0 == null) goto L9;
        if (r0.f10238f == null) goto L9;
        com.obric.matrix.u.b.a r5 = new com.obric.matrix.u.b.a();
        r5.c(new com.obric.matrix.u.a("", 0, ""));
        e0.a r1 = new e0.a();
        com.obric.matrix.w.b.a r2 = new com.obric.matrix.w.b.a();
        r2.b("123");
        r1.a(r2.a());
        e0 r6 = r1.b();
        o.e(r6, "Builder()\n              …                 .build()");
        r5.d(r6);
        r4.b(r5.a());
        return;
    L9:
        throw new e(r3);
    }

    @Override // com.obric.matrix.biz_example_api.IBizExample
    public f.a.a<com.obric.matrix.u.b> testFun(final b0 r1) {
        o.f(r1, "request");
        f.a.a<com.obric.matrix.u.b> r0 = f.a.a.b(new a(r1));
        o.e(r0, "create {\n            if …seResponseBody)\n        }");
        return r0;
    }
}
