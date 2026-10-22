package d.c.i.p;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import java.io.IOException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class w extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AssetManager f16463c;

    public w(Executor r1, d.c.c.g.i r2, AssetManager r3) {
        super(r1, r2);
        this.f16463c = r3;
    }

    private static String g(d.c.i.q.b r1) {
        return r1.v().getPath().substring(1);
    }

    private int h(d.c.i.q.b r2) {
        AssetFileDescriptor r0 = null;
        r0 = this.f16463c.openFd(g(r2));     // Catch: Throwable -> L8 IOException -> L12
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

    @Override // d.c.i.p.a0
    protected d.c.i.l.e d(d.c.i.q.b r4) {
        return e(this.f16463c.open(g(r4), 2), h(r4));
    }

    @Override // d.c.i.p.a0
    protected String f() {
        return "LocalAssetFetchProducer";
    }
}
