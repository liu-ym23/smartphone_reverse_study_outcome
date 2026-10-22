package f.a.j.d;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends f.a.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f17119b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ThreadFactory f17120a;

    static {
        f17119b = new f("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    }

    public d() {
        this(f17119b);
    }

    public d(ThreadFactory r1) {
        this.f17120a = r1;
    }

    @Override // f.a.f
    public f.a.f.b a() {
        return new e(this.f17120a);
    }
}
