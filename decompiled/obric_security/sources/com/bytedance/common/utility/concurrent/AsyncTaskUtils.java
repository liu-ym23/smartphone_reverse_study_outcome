package com.bytedance.common.utility.concurrent;

import android.os.AsyncTask;

/* JADX INFO: loaded from: classes.dex */
public class AsyncTaskUtils {
    static final BaseImpl IMPL = null;

    /* JADX INFO: renamed from: com.bytedance.common.utility.concurrent.AsyncTaskUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class BaseImpl {
        private BaseImpl() {
        }

        /* synthetic */ BaseImpl(AnonymousClass1 r1) {
            this();
        }

        public <T> void executeAsyncTask(AsyncTask<T, ?, ?> r1, T... r2) {
            r1.execute(r2);     // Catch: Throwable -> L4
            return;
        }
    }

    private static class HoneyCombImpl extends BaseImpl {
        private HoneyCombImpl() {
            super(null);
        }

        /* synthetic */ HoneyCombImpl(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.common.utility.concurrent.AsyncTaskUtils.BaseImpl
        public <T> void executeAsyncTask(AsyncTask<T, ?, ?> r1, T... r2) {
            r1.executeOnExecutor(TTExecutors.getNormalExecutor(), r2);     // Catch: Throwable -> L4
            return;
        }
    }

    public AsyncTaskUtils() {
    }

    static {
        IMPL = new HoneyCombImpl(null);
    }

    public static <T> void executeAsyncTask(AsyncTask<T, ?, ?> r1, T... r2) {
        IMPL.executeAsyncTask(r1, r2);
    }
}
