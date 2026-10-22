package com.google.common.cache;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class LongAddables {
    private static final Supplier<LongAddable> SUPPLIER = null;

    private static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        private PureJavaLongAddable() {
        }

        /* synthetic */ PureJavaLongAddable(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.common.cache.LongAddable
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.common.cache.LongAddable
        public void add(long r1) {
            getAndAdd(r1);
        }

        @Override // com.google.common.cache.LongAddable
        public long sum() {
            return get();
        }
    }

    LongAddables() {
    }

    static {
        new LongAdder();     // Catch: Throwable -> L4
        Supplier<LongAddable> r0 = new AnonymousClass1();     // Catch: Throwable -> L4
    L5:
        SUPPLIER = r0;
        return;
    L4:
        r0 = new AnonymousClass2();
        goto L5
    }

    public static LongAddable create() {
        return SUPPLIER.get();
    }
}
