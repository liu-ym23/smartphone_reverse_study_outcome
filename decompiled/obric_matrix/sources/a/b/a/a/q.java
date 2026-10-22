package a.b.a.a;

import com.bytedance.lego.init.e.j;
import com.bytedance.lego.init.tasks.IdleTaskProxy;
import kotlin.f0;

/* JADX INFO: loaded from: classes.dex */
public final class q extends kotlin.n0.d.q implements kotlin.n0.c.a<f0> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ j f92f;

    public q(j r1) {
        this.f92f = r1;
        super(0);
    }

    @Override // kotlin.n0.c.a
    public f0 invoke() {
        com.bytedance.lego.init.e.b r1 = this.f92f.f4891i;
        kotlin.n0.d.o.b(r1, "task.task");
        String r4 = this.f92f.f4888f;
        kotlin.n0.d.o.b(r4, "task.taskId");
        new IdleTaskProxy(r1, r4, false, p.f91f).run();
        return f0.f18324a;
    }
}
