package k;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
final class y extends d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Logger f18315l;
    private final Socket m;

    public y(Socket r2) {
        kotlin.n0.d.o.g(r2, "socket");
        this.m = r2;
        this.f18315l = Logger.getLogger("okio.Okio");
    }

    @Override // k.d
    protected IOException t(IOException r2) {
        SocketTimeoutException r1 = new SocketTimeoutException(LocationMonitorConst.TIMEOUT);
        if (r2 == null) goto L5;
        r1.initCause(r2);
    L5:
        return r1;
    }

    @Override // k.d
    protected void x() {
        this.m.close();     // Catch: AssertionError -> L5 Exception -> L10
    L16:
        return;
    L5:
        e = move-exception;
        if (q.c(e) == false) goto L9;
        Logger r2 = this.f18315l;
        Level r3 = Level.WARNING;
        StringBuilder r4 = new StringBuilder();
        Throwable r1 = e;
        Logger r5 = r2;
    L12:
        r4.append("Failed to close timed out socket ");
        r4.append(this.m);
        r5.log(r3, r4.toString(), r1);
        return;
    L9:
        throw e;
    L10:
        e = move-exception;
        Logger r6 = this.f18315l;
        r3 = Level.WARNING;
        r4 = new StringBuilder();
        r1 = e;
        r5 = r6;
        goto L12
    }
}
