package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Callables {
    static /* synthetic */ boolean access$000(String r0, Thread r1) {
        return trySetName(r0, r1);
    }

    private Callables() {
    }

    public static <T> Callable<T> returning(@ParametricNullness final T r1) {
        return new AnonymousClass1(r1);
    }

    public static <T> AsyncCallable<T> asAsyncCallable(final Callable<T> r1, final ListeningExecutorService r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass2(r2, r1);
    }

    static <T> Callable<T> threadRenaming(final Callable<T> r1, final Supplier<String> r2) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r1);
        return new AnonymousClass3(r2, r1);
    }

    static Runnable threadRenaming(final Runnable r1, final Supplier<String> r2) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r1);
        return new AnonymousClass4(r2, r1);
    }

    private static boolean trySetName(String r0, Thread r1) {
        r1.setName(r0);     // Catch: SecurityException -> L5
        return true;
    L5:
        return false;
    }
}
