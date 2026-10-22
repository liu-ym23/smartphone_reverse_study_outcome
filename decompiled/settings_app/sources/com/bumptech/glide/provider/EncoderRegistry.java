package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class EncoderRegistry {
    private final List<Entry<?>> encoders;

    private static final class Entry<T> {
        private final Class<T> dataClass;
        final Encoder<T> encoder;

        Entry(Class<T> r1, Encoder<T> r2) {
            this.dataClass = r1;
            this.encoder = r2;
        }

        boolean handles(Class<?> r1) {
            return this.dataClass.isAssignableFrom(r1);
        }
    }

    public EncoderRegistry() {
        this.encoders = new ArrayList();
    }

    public synchronized <T> Encoder<T> getEncoder(Class<T> r4) {
        monitor-enter(this);
        Iterator<Entry<?>> r0 = this.encoders.iterator();     // Catch: Throwable -> L14
    L5:
        if (r0.hasNext() == false) goto L11;
        Entry<?> r1 = r0.next();     // Catch: Throwable -> L14
        if (r1.handles(r4) == false) goto L5;
        Encoder<T> r5 = (Encoder<T>) r1.encoder;
        monitor-exit(this);
        return r5;
    L11:
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized <T> void append(Class<T> r3, Encoder<T> r4) {
        monitor-enter(this);
        this.encoders.add(new Entry(r3, r4));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <T> void prepend(Class<T> r3, Encoder<T> r4) {
        monitor-enter(this);
        this.encoders.add(0, new Entry(r3, r4));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
