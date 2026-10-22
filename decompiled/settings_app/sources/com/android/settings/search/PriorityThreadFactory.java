package com.android.settings.search;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public class PriorityThreadFactory implements ThreadFactory {
    private final int mPriority;

    static /* synthetic */ int access$000(PriorityThreadFactory r0) {
        return r0.mPriority;
    }

    public PriorityThreadFactory(int r1) {
        this.mPriority = r1;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable r2) {
        return new AnonymousClass1(this, r2);
    }
}
