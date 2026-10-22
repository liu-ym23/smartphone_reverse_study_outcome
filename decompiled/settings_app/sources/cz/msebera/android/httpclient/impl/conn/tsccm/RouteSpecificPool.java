package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.params.ConnPerRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.LangUtils;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class RouteSpecificPool {
    protected final ConnPerRoute connPerRoute;
    protected final LinkedList<BasicPoolEntry> freeEntries;
    public HttpClientAndroidLog log;
    protected final int maxEntries;
    protected int numEntries;
    protected final HttpRoute route;
    protected final Queue<WaitingThread> waitingThreads;

    @Deprecated
    public RouteSpecificPool(HttpRoute r3, int r4) {
        this.log = new HttpClientAndroidLog(getClass());
        this.route = r3;
        this.maxEntries = r4;
        this.connPerRoute = new AnonymousClass1(this);
        this.freeEntries = new LinkedList();
        this.waitingThreads = new LinkedList();
        this.numEntries = 0;
    }

    public RouteSpecificPool(HttpRoute r3, ConnPerRoute r4) {
        this.log = new HttpClientAndroidLog(getClass());
        this.route = r3;
        this.connPerRoute = r4;
        this.maxEntries = r4.getMaxForRoute(r3);
        this.freeEntries = new LinkedList();
        this.waitingThreads = new LinkedList();
        this.numEntries = 0;
    }

    public final HttpRoute getRoute() {
        return this.route;
    }

    public final int getMaxEntries() {
        return this.maxEntries;
    }

    public boolean isUnused() {
        if (this.numEntries < 1) goto L5;
    L7:
        return false;
    L5:
        if (this.waitingThreads.isEmpty() == false) goto L7;
        return true;
    }

    public int getCapacity() {
        return this.connPerRoute.getMaxForRoute(this.route) - this.numEntries;
    }

    public final int getEntryCount() {
        return this.numEntries;
    }

    public BasicPoolEntry allocEntry(Object r4) {
        if (this.freeEntries.isEmpty() == true) goto L14;
        LinkedList<BasicPoolEntry> r0 = this.freeEntries;
        ListIterator<BasicPoolEntry> r1 = r0.listIterator(r0.size());
    L6:
        if (r1.hasPrevious() == false) goto L14;
        BasicPoolEntry r2 = r1.previous();
        if (r2.getState() == null) goto L11;
        if (LangUtils.equals(r4, r2.getState()) == false) goto L6;
    L11:
        r1.remove();
        return r2;
    L14:
        if (getCapacity() == 0) goto L16;
        return null;
    L16:
        if (this.freeEntries.isEmpty() == true) goto L31;
        BasicPoolEntry r5 = this.freeEntries.remove();
        r5.shutdownEntry();
        r5.getConnection().close();     // Catch: IOException -> L20
    L22:
        return r5;
    L20:
        e = move-exception;
        this.log.debug("I/O error closing connection", e);
        goto L22
    L31:
        return null;
    }

    public void freeEntry(BasicPoolEntry r3) {
        int r0 = this.numEntries;
        if (r0 < 1) goto L11;
        if (r0 <= this.freeEntries.size()) goto L9;
        this.freeEntries.add(r3);
        return;
    L9:
        throw new IllegalStateException("No entry allocated from this pool. " + this.route);
    L11:
        throw new IllegalStateException("No entry created for this pool. " + this.route);
    }

    public void createdEntry(BasicPoolEntry r2) {
        Args.check(this.route.equals(r2.getPlannedRoute()), "Entry not planned for this pool");
        this.numEntries++;
    }

    public boolean deleteEntry(BasicPoolEntry r2) {
        boolean r3 = this.freeEntries.remove(r2);
        if (r3 == false) goto L5;
        this.numEntries--;
    L5:
        return r3;
    }

    public void dropEntry() {
        if (this.numEntries <= 0) goto L5;
        boolean r0 = true;
    L6:
        Asserts.check(r0, "There is no entry that could be dropped");
        this.numEntries--;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void queueThread(WaitingThread r2) {
        Args.notNull(r2, "Waiting thread");
        this.waitingThreads.add(r2);
    }

    public boolean hasThread() {
        return !this.waitingThreads.isEmpty();
    }

    public WaitingThread nextThread() {
        return this.waitingThreads.peek();
    }

    public void removeThread(WaitingThread r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.waitingThreads.remove(r1);
    }
}
