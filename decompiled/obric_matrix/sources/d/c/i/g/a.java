package d.c.i.g;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f16030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f16031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f16032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Executor f16033d;

    public a(int r5) {
        this.f16030a = Executors.newFixedThreadPool(2, new k(10, "FrescoIoBoundExecutor", true));
        this.f16031b = Executors.newFixedThreadPool(r5, new k(10, "FrescoDecodeExecutor", true));
        this.f16032c = Executors.newFixedThreadPool(r5, new k(10, "FrescoBackgroundExecutor", true));
        this.f16033d = Executors.newFixedThreadPool(1, new k(10, "FrescoLightWeightBackgroundExecutor", true));
    }

    @Override // d.c.i.g.e
    public Executor a() {
        return this.f16031b;
    }

    @Override // d.c.i.g.e
    public Executor b() {
        return this.f16033d;
    }

    @Override // d.c.i.g.e
    public Executor c() {
        return this.f16032c;
    }

    @Override // d.c.i.g.e
    public Executor d() {
        return this.f16030a;
    }

    @Override // d.c.i.g.e
    public Executor e() {
        return this.f16030a;
    }
}
