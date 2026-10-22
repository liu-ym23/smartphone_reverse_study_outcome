package d.b.h.a.a.h.l;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class e extends IOException implements d.b.r.l0.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f13413f;

    public e(String r1) {
        super(r1);
        this.f13413f = false;
    }

    @Override // d.b.r.l0.a
    public boolean a() {
        return this.f13413f;
    }

    public void b(boolean r1) {
        this.f13413f = r1;
    }
}
