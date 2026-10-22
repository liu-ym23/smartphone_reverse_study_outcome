package a.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ k.a f30f;

    public i(k.a r1) {
        this.f30f = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k r0 = k.f58h;
        com.bytedance.lego.init.e.c r2 = this.f30f.f59f;
        kotlin.n0.d.o.b(r2, "task");
        k.c(r0, r2, true);
    }
}
