package d.c.i.p;

import android.content.ContentResolver;
import android.net.Uri;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class o0 extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ContentResolver f16367c;

    public o0(Executor r1, d.c.c.g.i r2, ContentResolver r3) {
        super(r1, r2);
        this.f16367c = r3;
    }

    @Override // d.c.i.p.a0
    protected d.c.i.l.e d(d.c.i.q.b r2) {
        Uri r3 = r2.v();
        return e(this.f16367c.openInputStream(r3), -1);
    }

    @Override // d.c.i.p.a0
    protected String f() {
        return "QualifiedResourceFetchProducer";
    }
}
