package d.c.i.p;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import java.io.IOException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class c0 extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Resources f16226c;

    public c0(Executor r1, d.c.c.g.i r2, Resources r3) {
        super(r1, r2);
        this.f16226c = r3;
    }

    private int g(d.c.i.q.b r2) {
        AssetFileDescriptor r0 = null;
        r0 = this.f16226c.openRawResourceFd(h(r2));     // Catch: Throwable -> L8 Resources.NotFoundException -> L12
        int r1 = (int) r0.getLength();
        if (r0 != null) goto L19;
    L7:
        return r1;
    L19:
        r0.close();     // Catch: IOException -> L16
        goto L7
    L8:
        th = move-exception;
        if (r0 != null) goto L23;
    L11:
        throw th;
    L23:
        r0.close();     // Catch: IOException -> L17
    L13:
        if (r0 != null) goto L21;
    L15:
        return -1;
    L21:
        r0.close();     // Catch: IOException -> L18
        goto L15
    }

    private static int h(d.c.i.q.b r1) {
        return Integer.parseInt(r1.v().getPath().substring(1));
    }

    @Override // d.c.i.p.a0
    protected d.c.i.l.e d(d.c.i.q.b r3) {
        return e(this.f16226c.openRawResource(h(r3)), g(r3));
    }

    @Override // d.c.i.p.a0
    protected String f() {
        return "LocalResourceFetchProducer";
    }
}
