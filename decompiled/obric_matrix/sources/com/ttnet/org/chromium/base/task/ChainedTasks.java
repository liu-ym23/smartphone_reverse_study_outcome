package com.ttnet.org.chromium.base.task;

import android.util.Pair;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public class ChainedTasks {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private volatile boolean mCanceled;
    private boolean mFinalized;
    private final Runnable mRunAndPost;
    private final LinkedList<Pair<TaskTraits, Runnable>> mTasks;

    static {
    }

    public ChainedTasks() {
        this.mTasks = new LinkedList();
        this.mRunAndPost = new AnonymousClass1(this);
    }

    private /* synthetic */ void a() {
        Iterator<Pair<TaskTraits, Runnable>> r0 = this.mTasks.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        ((Runnable) r0.next().second).run();
        if (this.mCanceled == false) goto L4;
        return;
    }

    static /* synthetic */ boolean access$000(ChainedTasks r0) {
        return r0.mCanceled;
    }

    static /* synthetic */ LinkedList access$100(ChainedTasks r0) {
        return r0.mTasks;
    }

    public void add(TaskTraits r3, Runnable r4) {
        LinkedList<Pair<TaskTraits, Runnable>> r0 = this.mTasks;
        monitor-enter(r0);
        this.mTasks.add(new Pair(r3, r4));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public /* synthetic */ void b() {
        a();
    }

    public void cancel() {
        LinkedList<Pair<TaskTraits, Runnable>> r0 = this.mTasks;
        monitor-enter(r0);
        this.mFinalized = true;     // Catch: Throwable -> L8
        this.mCanceled = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void start(boolean r3) {
        LinkedList<Pair<TaskTraits, Runnable>> r0 = this.mTasks;
        monitor-enter(r0);
        this.mFinalized = true;     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        if (this.mTasks.isEmpty() == false) goto L10;
        return;
    L10:
        if (r3 == false) goto L12;
        PostTask.runOrPostTask((TaskTraits) this.mTasks.peek().first, new c(this));
        return;
    L12:
        PostTask.postTask((TaskTraits) this.mTasks.peek().first, this.mRunAndPost);
        return;
    L16:
        th = move-exception;
        throw th;
    }
}
