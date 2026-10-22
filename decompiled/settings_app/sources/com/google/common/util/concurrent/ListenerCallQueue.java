package com.google.common.util.concurrent;

import com.android.settings.utils.HanziToPinyin;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class ListenerCallQueue<L> {
    private static final Logger logger = null;
    private final List<PerListenerQueue<L>> listeners;

    interface Event<L> {
        void call(L r1);
    }

    private static final class PerListenerQueue<L> implements Runnable {
        final Executor executor;
        boolean isThreadScheduled;
        final Queue<Object> labelQueue;
        final L listener;
        final Queue<Event<L>> waitQueue;

        PerListenerQueue(L r2, Executor r3) {
            this.waitQueue = Queues.newArrayDeque();
            this.labelQueue = Queues.newArrayDeque();
            this.listener = (L) Preconditions.checkNotNull(r2);
            this.executor = (Executor) Preconditions.checkNotNull(r3);
        }

        synchronized void add(Event<L> r2, Object r3) {
            monitor-enter(this);
            this.waitQueue.add(r2);     // Catch: Throwable -> L6
            this.labelQueue.add(r3);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        void dispatch() {
            monitor-enter(this);
        L21:
            th = move-exception;
            throw th;
        L4:
            if (this.isThreadScheduled == true) goto L6;
            boolean r0 = true;
            this.isThreadScheduled = true;     // Catch: Throwable -> L21
        L7:
            monitor-exit(this);     // Catch: Throwable -> L21
            if (r0 == true) goto L26;
            return;
        L26:
            this.executor.execute(this);     // Catch: RuntimeException -> L11
            return;
        L11:
            e = move-exception;
            monitor-enter(this);
            this.isThreadScheduled = false;     // Catch: Throwable -> L17
            Logger r1 = ListenerCallQueue.access$000();
            Level r2 = Level.SEVERE;
            String r3 = String.valueOf(this.listener);
            String r6 = String.valueOf(this.executor);
            r1.log(r2, new StringBuilder((String.valueOf(r3).length() + 42) + String.valueOf(r6).length()).append("Exception while running callbacks for ").append(r3).append(" on ").append(r6).toString(), e);
            throw e;
        L17:
            th = move-exception;
            throw th;
        L6:
            r0 = false;
            goto L7
        }

        @Override // java.lang.Runnable
        public void run() {
        L2:
            boolean r1 = true;
            monitor-enter(this);     // Catch: Throwable -> L25
            Preconditions.checkState(this.isThreadScheduled);     // Catch: Throwable -> L17
            Event<L> r2 = this.waitQueue.poll();     // Catch: Throwable -> L17
            Object r3 = this.labelQueue.poll();     // Catch: Throwable -> L17
            if (r2 == null) goto L6;
            monitor-exit(this);     // Catch: Throwable -> L17
            r2.call(this.listener);     // Catch: RuntimeException -> L14 Throwable -> L25
        L14:
            e = move-exception;
            Logger r4 = ListenerCallQueue.access$000();     // Catch: Throwable -> L25
            Level r5 = Level.SEVERE;     // Catch: Throwable -> L25
            String r6 = String.valueOf(this.listener);     // Catch: Throwable -> L25
            String r7 = String.valueOf(r3);     // Catch: Throwable -> L25
            r4.log(r5, new StringBuilder((String.valueOf(r6).length() + 37) + String.valueOf(r7).length()).append("Exception while executing callback: ").append(r6).append(HanziToPinyin.Token.SEPARATOR).append(r7).toString(), e);     // Catch: Throwable -> L25
            goto L2
        L6:
            this.isThreadScheduled = false;     // Catch: Throwable -> L17
            monitor-exit(this);     // Catch: Throwable -> L9
            return;
        L9:
            Throwable th = th;
            boolean r8 = false;
        L41:
            monitor-exit(this);     // Catch: Throwable -> L23
            throw th;     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            boolean r9 = r8;
            th = th;
            r1 = r9;
        L26:
            if (r1 == false) goto L34;
            monitor-enter(this);
            this.isThreadScheduled = false;     // Catch: Throwable -> L31
            monitor-exit(this);     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            throw th;
        L34:
            throw th;
        L23:
            th = th;
        L17:
            th = move-exception;
            r8 = true;
            th = th;
        L25:
            th = th;
            goto L26
        }
    }

    ListenerCallQueue() {
        this.listeners = Collections.synchronizedList(new ArrayList());
    }

    static /* synthetic */ Logger access$000() {
        return logger;
    }

    static {
        logger = Logger.getLogger(ListenerCallQueue.class.getName());
    }

    public void addListener(L r2, Executor r3) {
        Preconditions.checkNotNull(r2, "listener");
        Preconditions.checkNotNull(r3, "executor");
        this.listeners.add(new PerListenerQueue(r2, r3));
    }

    public void enqueue(Event<L> r1) {
        enqueueHelper(r1, r1);
    }

    public void enqueue(Event<L> r1, String r2) {
        enqueueHelper(r1, r2);
    }

    private void enqueueHelper(Event<L> r3, Object r4) {
        Preconditions.checkNotNull(r3, "event");
        Preconditions.checkNotNull(r4, "label");
        List<PerListenerQueue<L>> r0 = this.listeners;
        monitor-enter(r0);
        Iterator<PerListenerQueue<L>> r2 = this.listeners.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        r2.next().add(r3, r4);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void dispatch() {
        int r0 = 0;
    L4:
        if (r0 >= this.listeners.size()) goto L6;
        this.listeners.get(r0).dispatch();
        r0 = r0 + 1;
        goto L4
    }
}
