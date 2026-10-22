package com.bumptech.glide.load.data;

import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DataRewinderRegistry {
    private static final DataRewinder.Factory<?> DEFAULT_FACTORY = null;
    private final Map<Class<?>, DataRewinder.Factory<?>> rewinders;

    private static final class DefaultRewinder implements DataRewinder<Object> {
        private final Object data;

        @Override // com.bumptech.glide.load.data.DataRewinder
        public void cleanup() {
        }

        DefaultRewinder(Object r1) {
            this.data = r1;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder
        public Object rewindAndGet() {
            return this.data;
        }
    }

    public DataRewinderRegistry() {
        this.rewinders = new HashMap();
    }

    static {
        DEFAULT_FACTORY = new AnonymousClass1();
    }

    public synchronized void register(DataRewinder.Factory<?> r3) {
        monitor-enter(this);
        this.rewinders.put(r3.getDataClass(), r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <T> DataRewinder<T> build(T r6) {
        monitor-enter(this);
        Preconditions.checkNotNull(r6);     // Catch: Throwable -> L16
        DataRewinder.Factory<?> r0 = this.rewinders.get(r6.getClass());     // Catch: Throwable -> L16
        if (r0 != null) goto L11;
        Iterator<DataRewinder.Factory<?>> r1 = this.rewinders.values().iterator();     // Catch: Throwable -> L16
    L7:
        if (r1.hasNext() == false) goto L11;
        DataRewinder.Factory<?> r2 = r1.next();     // Catch: Throwable -> L16
        if (r2.getDataClass().isAssignableFrom(r6.getClass()) == false) goto L7;
        r0 = r2;
    L11:
        if (r0 != null) goto L13;
        r0 = DEFAULT_FACTORY;     // Catch: Throwable -> L16
    L13:
        DataRewinder<T> r7 = (DataRewinder<T>) r0.build(r6);
        monitor-exit(this);
        return r7;
    L16:
        th = move-exception;
        throw th;
    }
}
