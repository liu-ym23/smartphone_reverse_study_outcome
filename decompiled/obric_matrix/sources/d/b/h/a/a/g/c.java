package d.b.h.a.a.g;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements d, Runnable, Comparable<d> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final AtomicBoolean f13303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f13304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f13305h;

    public c() {
        new AtomicBoolean(false);
        this.f13303f = new AtomicBoolean(false);
        this.f13304g = 0;
    }

    public int g() {
        return this.f13304g;
    }

    public boolean j() {
        return this.f13303f.get();
    }

    public boolean k() {
        return false;
    }

    @Deprecated
    public boolean l() {
        return false;
    }

    public c m(int r1) {
        this.f13305h = r1;
        return this;
    }
}
