package d.g.a.a.h.f;

import d.g.a.a.h.b;

/* JADX INFO: loaded from: classes2.dex */
public class a implements b {
    public a() {
    }

    @Override // d.g.a.a.h.b
    public /* bridge */ /* synthetic */ String a(Object r1) {
        return b((Thread) r1);
    }

    public String b(Thread r2) {
        StringBuffer r1 = new StringBuffer();
        r1.append("Thread: ");
        r1.append(r2.getName());
        return r1.toString();
    }
}
