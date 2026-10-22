package l.a.b.e;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<l.a.b.a> f21505a;

    public a() {
        this.f21505a = new ArrayList();
    }

    @Override // l.a.b.e.b
    public void a(l.a.b.a r1) {
        this.f21505a.add(r1);
    }

    public List<l.a.b.a> b() {
        return this.f21505a;
    }
}
