package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ResourceEncoderRegistry {
    private final List<Entry<?>> encoders;

    private static final class Entry<T> {
        final ResourceEncoder<T> encoder;
        private final Class<T> resourceClass;

        Entry(Class<T> r1, ResourceEncoder<T> r2) {
            this.resourceClass = r1;
            this.encoder = r2;
        }

        boolean handles(Class<?> r1) {
            return this.resourceClass.isAssignableFrom(r1);
        }
    }

    public ResourceEncoderRegistry() {
        this.encoders = new ArrayList();
    }

    public synchronized <Z> void append(Class<Z> r3, ResourceEncoder<Z> r4) {
        monitor-enter(this);
        this.encoders.add(new Entry(r3, r4));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <Z> void prepend(Class<Z> r3, ResourceEncoder<Z> r4) {
        monitor-enter(this);
        this.encoders.add(0, new Entry(r3, r4));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <Z> ResourceEncoder<Z> get(Class<Z> r5) {
        monitor-enter(this);
        int r0 = this.encoders.size();     // Catch: Throwable -> L14
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L11;
        Entry<?> r2 = this.encoders.get(r1);     // Catch: Throwable -> L14
        if (r2.handles(r5) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        ResourceEncoder<Z> r6 = (ResourceEncoder<Z>) r2.encoder;
        monitor-exit(this);
        return r6;
    L11:
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }
}
