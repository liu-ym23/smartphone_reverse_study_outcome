package com.bytedance.common.utility.concurrent;

import android.annotation.TargetApi;
import android.os.AsyncTask;

/* JADX INFO: loaded from: classes.dex */
public class AsyncTaskUtils {
    static final BaseImpl IMPL = null;

    /* JADX INFO: renamed from: com.bytedance.common.utility.concurrent.AsyncTaskUtils$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class BaseImpl {
        private BaseImpl() {
        }

        public <T> void executeAsyncTask(AsyncTask<T, ?, ?> r1, T... r2) {
            r1.execute(r2);     // Catch: Throwable -> L4
            return;
        }

        public /* synthetic */ BaseImpl(AnonymousClass1 r1) {
            this();
        }
    }

    @TargetApi(11)
    public static class HoneyCombImpl extends BaseImpl {
        private HoneyCombImpl() {
            super(null);
        }

        @Override // com.bytedance.common.utility.concurrent.AsyncTaskUtils.BaseImpl
        public <T> void executeAsyncTask(AsyncTask<T, ?, ?> r1, T... r2) {
            r1.executeOnExecutor(TTExecutors.getNormalExecutor(), r2);     // Catch: Throwable -> L4
            return;
        }

        public /* synthetic */ HoneyCombImpl(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        IMPL = new HoneyCombImpl(null);
    }

    public AsyncTaskUtils() {
    }

    public static <T> void executeAsyncTask(AsyncTask<T, ?, ?> r1, T... r2) {
        IMPL.executeAsyncTask(r1, r2);
    }
}
