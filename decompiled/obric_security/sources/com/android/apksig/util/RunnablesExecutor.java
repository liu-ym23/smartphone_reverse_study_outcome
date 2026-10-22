package com.android.apksig.util;

/* JADX INFO: loaded from: classes.dex */
public interface RunnablesExecutor {
    public static final RunnablesExecutor SINGLE_THREADED = null;

    static {
        SINGLE_THREADED = new RunnablesExecutor$$ExternalSyntheticLambda0();
    }

    static /* synthetic */ void lambda$static$0(RunnablesProvider r0) {
        r0.createRunnable().run();
    }

    void execute(RunnablesProvider r1);
}
