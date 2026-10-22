package org.apache.commons.io;

import java.io.File;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collection;
import java.util.Vector;

/* JADX INFO: loaded from: classes6.dex */
public class FileCleaningTracker {
    volatile boolean exitWhenFinished;
    ReferenceQueue q;
    Thread reaper;
    final Collection trackers;

    private final class Reaper extends Thread {
        private final /* synthetic */ FileCleaningTracker this$0;

        Reaper(FileCleaningTracker r2) {
            super("File Reaper");
            this.this$0 = r2;
            setPriority(10);
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L3:
            if (this.this$0.exitWhenFinished == true) goto L5;
        L12:
            Tracker r0 = (Tracker) this.this$0.q.remove();     // Catch: Exception -> L11
            if (r0 == null) goto L3;
            r0.delete();
            r0.clear();
            this.this$0.trackers.remove(r0);
            goto L3
        L5:
            if (this.this$0.trackers.size() > 0) goto L12;
        }
    }

    private static final class Tracker extends PhantomReference {
        private final FileDeleteStrategy deleteStrategy;
        private final String path;

        Tracker(String r1, FileDeleteStrategy r2, Object r3, ReferenceQueue r4) {
            super(r3, r4);
            this.path = r1;
            if (r2 != null) goto L5;
            r2 = FileDeleteStrategy.NORMAL;
        L5:
            this.deleteStrategy = r2;
        }

        public boolean delete() {
            return this.deleteStrategy.deleteQuietly(new File(this.path));
        }
    }

    public FileCleaningTracker() {
        this.q = new ReferenceQueue();
        this.trackers = new Vector();
        this.exitWhenFinished = false;
    }

    public void track(File r3, Object r4) {
        FileDeleteStrategy r1 = (FileDeleteStrategy) null;
        track(r3, r4, null);
    }

    public void track(File r1, Object r2, FileDeleteStrategy r3) {
        if (r1 == null) goto L6;
        addTracker(r1.getPath(), r2, r3);
        return;
    L6:
        throw new NullPointerException("The file must not be null");
    }

    public void track(String r3, Object r4) {
        FileDeleteStrategy r1 = (FileDeleteStrategy) null;
        track(r3, r4, null);
    }

    public void track(String r1, Object r2, FileDeleteStrategy r3) {
        if (r1 == null) goto L6;
        addTracker(r1, r2, r3);
        return;
    L6:
        throw new NullPointerException("The path must not be null");
    }

    private synchronized void addTracker(String r4, Object r5, FileDeleteStrategy r6) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.exitWhenFinished == true) goto L12;
        if (this.reaper != null) goto L8;
        Reaper r0 = new Reaper(this);     // Catch: Throwable -> L13
        this.reaper = r0;     // Catch: Throwable -> L13
        r0.start();     // Catch: Throwable -> L13
    L8:
        this.trackers.add(new Tracker(r4, r6, r5, this.q));     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L12:
        throw new IllegalStateException("No new trackers can be added once exitWhenFinished() is called");     // Catch: Throwable -> L13
    }

    public int getTrackCount() {
        return this.trackers.size();
    }

    public synchronized void exitWhenFinished() {
        monitor-enter(this);
        this.exitWhenFinished = true;     // Catch: Throwable -> L15
        Thread r0 = this.reaper;     // Catch: Throwable -> L15
        if (r0 == null) goto L13;
        monitor-enter(r0);     // Catch: Throwable -> L15
        this.reaper.interrupt();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
