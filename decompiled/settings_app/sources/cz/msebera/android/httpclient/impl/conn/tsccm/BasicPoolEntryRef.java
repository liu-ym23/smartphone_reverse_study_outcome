package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.util.Args;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class BasicPoolEntryRef extends WeakReference<BasicPoolEntry> {
    private final HttpRoute route;

    public BasicPoolEntryRef(BasicPoolEntry r1, ReferenceQueue<Object> r2) {
        super(r1, r2);
        Args.notNull(r1, "Pool entry");
        this.route = r1.getPlannedRoute();
    }

    public final HttpRoute getRoute() {
        return this.route;
    }
}
