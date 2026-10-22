package com.bumptech.glide.load.resource.transcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TranscoderRegistry {
    private final List<Entry<?, ?>> transcoders;

    private static final class Entry<Z, R> {
        final Class<Z> fromClass;
        final Class<R> toClass;
        final ResourceTranscoder<Z, R> transcoder;

        Entry(Class<Z> r1, Class<R> r2, ResourceTranscoder<Z, R> r3) {
            this.fromClass = r1;
            this.toClass = r2;
            this.transcoder = r3;
        }

        public boolean handles(Class<?> r2, Class<?> r3) {
            if (this.fromClass.isAssignableFrom(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (r3.isAssignableFrom(this.toClass) == false) goto L7;
            return true;
        }
    }

    public TranscoderRegistry() {
        this.transcoders = new ArrayList();
    }

    public synchronized <Z, R> void register(Class<Z> r3, Class<R> r4, ResourceTranscoder<Z, R> r5) {
        monitor-enter(this);
        this.transcoders.add(new Entry(r3, r4, r5));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <Z, R> ResourceTranscoder<Z, R> get(Class<Z> r4, Class<R> r5) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (r5.isAssignableFrom(r4) == false) goto L8;
        ResourceTranscoder<Z, R> r6 = UnitTranscoder.get();     // Catch: Throwable -> L18
        monitor-exit(this);
        return r6;
    L8:
        Iterator<Entry<?, ?>> r0 = this.transcoders.iterator();     // Catch: Throwable -> L18
    L10:
        if (r0.hasNext() == false) goto L17;
        Entry<?, ?> r1 = r0.next();     // Catch: Throwable -> L18
        if (r1.handles(r4, r5) == false) goto L10;
        ResourceTranscoder<Z, R> r7 = (ResourceTranscoder<Z, R>) r1.transcoder;
        monitor-exit(this);
        return r7;
    L17:
        throw new IllegalArgumentException("No transcoder registered to transcode from " + r4 + " to " + r5);     // Catch: Throwable -> L18
    }

    public synchronized <Z, R> List<Class<R>> getTranscodeClasses(Class<Z> r5, Class<R> r6) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L19
        if (r6.isAssignableFrom(r5) == false) goto L8;
        r0.add(r6);     // Catch: Throwable -> L19
        monitor-exit(this);
        return r0;
    L8:
        Iterator<Entry<?, ?>> r1 = this.transcoders.iterator();     // Catch: Throwable -> L19
    L10:
        if (r1.hasNext() == false) goto L17;
        Entry<?, ?> r2 = r1.next();     // Catch: Throwable -> L19
        if (r2.handles(r5, r6) == false) goto L10;
        if (r0.contains(r2.toClass) == true) goto L10;
        r0.add(r2.toClass);     // Catch: Throwable -> L19
        goto L10
    L17:
        monitor-exit(this);
        return r0;
    L19:
        th = move-exception;
        throw th;
    }
}
