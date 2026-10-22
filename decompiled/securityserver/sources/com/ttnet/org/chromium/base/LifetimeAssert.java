package com.ttnet.org.chromium.base;

import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.build.BuildConfig;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("Lifetime assertions aren't used when DCHECK is off.")
public class LifetimeAssert {
    static TestHook sTestHook;
    private final Object mTarget;

    @VisibleForTesting
    final WrappedReference mWrapper;

    public static class CreationException extends RuntimeException {
        public CreationException() {
            super("vvv This is where object was created. vvv");
        }
    }

    public static class LifetimeAssertException extends RuntimeException {
        public LifetimeAssertException(String r1, Throwable r2) {
            super(r1, r2);
        }
    }

    public interface TestHook {
        void onCleaned(WrappedReference r1, String r2);
    }

    @VisibleForTesting
    public static class WrappedReference extends PhantomReference<Object> {
        private static Set<WrappedReference> sActiveWrappers;
        private static ReferenceQueue<Object> sReferenceQueue;
        final CreationException mCreationException;
        boolean mSafeToGc;
        final Class<?> mTargetClass;

        static {
            sReferenceQueue = new ReferenceQueue();
            sActiveWrappers = Collections.synchronizedSet(new HashSet());
            final String r1 = "GcStateAssertQueue";
            new AnonymousClass1(r1);
        }

        public WrappedReference(Object r2, CreationException r3, boolean r4) {
            super(r2, sReferenceQueue);
            this.mCreationException = r3;
            this.mSafeToGc = r4;
            this.mTargetClass = r2.getClass();
            sActiveWrappers.add(this);
        }

        public static /* synthetic */ ReferenceQueue access$000() {
            return sReferenceQueue;
        }

        public static /* synthetic */ Set access$100() {
            return sActiveWrappers;
        }
    }

    private LifetimeAssert(WrappedReference r1, Object r2) {
        this.mWrapper = r1;
        this.mTarget = r2;
    }

    public static void assertAllInstancesDestroyedForTesting() {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        Set r0 = WrappedReference.access$100();
        monitor-enter(r0);
        Iterator r1 = WrappedReference.access$100().iterator();     // Catch: Throwable -> L15
    L9:
        if (r1.hasNext() == false) goto L17;
        WrappedReference r2 = (WrappedReference) r1.next();     // Catch: Throwable -> L15
        if (r2.mSafeToGc == true) goto L9;
        throw new LifetimeAssertException("Object of type " + r2.mTargetClass.getName() + " was not destroyed after test completed. Refer to \"Caused by\" for where object was created.", r2.mCreationException);     // Catch: Throwable -> L15
    L17:
        WrappedReference.access$100().clear();     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        WrappedReference.access$100().clear();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    }

    public static LifetimeAssert create(Object r4) {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L7;
        return null;
    L7:
        return new LifetimeAssert(new WrappedReference(r4, new CreationException(), false), r4);
    }

    public static void resetForTesting() {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        WrappedReference.access$100().clear();
    }

    public static void setSafeToGc(LifetimeAssert r1, boolean r2) {
        if (BuildConfig.ENABLE_ASSERTS == false) goto L12;
        Object r0 = r1.mTarget;
        monitor-enter(r0);
        r1.mWrapper.mSafeToGc = r2;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static LifetimeAssert create(Object r3, boolean r4) {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L7;
        return null;
    L7:
        return new LifetimeAssert(new WrappedReference(r3, new CreationException(), r4), r3);
    }
}
