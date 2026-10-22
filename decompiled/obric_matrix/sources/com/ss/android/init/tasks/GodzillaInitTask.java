package com.ss.android.init.tasks;

import com.bytedance.lego.init.e.h;
import com.bytedance.platform.godzilla.sysopt.i;
import d.b.p.a.a;
import d.b.p.a.c.c;
import d.b.p.a.e.b;
import d.b.p.a.e.f;
import d.b.p.a.e.g;
import d.b.p.a.g.d;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/ss/android/init/tasks/GodzillaInitTask;", "Lcom/bytedance/lego/init/e/h;", "Ld/b/p/a/a$b;", "builder", "Lkotlin/f0;", "a", "(Ld/b/p/a/a$b;)V", "c", "b", "run", "()V", "<init>", "launch_release"}, k = 1, mv = {1, 1, 15})
public final class GodzillaInitTask extends h {
    public GodzillaInitTask() {
    }

    private final void a(a.b r1) {
        r1.b(new c());
        r1.b(new d.b.p.a.c.a());
    }

    private final void b(a.b r1) {
        r1.b(new b());
        r1.b(new g());
        r1.b(new f());
    }

    private final void c(a.b r1) {
        r1.b(new com.bytedance.platform.godzilla.sysopt.h());
        r1.b(new i());
    }

    @Override // java.lang.Runnable
    public void run() {
        d.b.m.d.a.b("mPaaSInit", new Object[]{"begin godzilla_init"});
        GodzillaInitTaskHook r1 = (GodzillaInitTaskHook) d.b.m.e.a.a(GodzillaInitTaskHook.class);
        a.b r4 = new a.b(com.bytedance.mpaas.app.a.f5245g);
        if (r1 == null) goto L5;
        r1.before(r4);
    L5:
        if (r1 != null) goto L7;
    L8:
        a(r4);
        c(r4);
        b(r4);
        a.a(r4.a()).b(d.f14304g);
    L9:
        if (r1 == null) goto L11;
        r1.after();
    L11:
        d.b.m.d.a.b("mPaaSInit", new Object[]{"end godzilla_init"});
        return;
    L7:
        if (r1.hook() == true) goto L9;
        goto L8
    }
}
