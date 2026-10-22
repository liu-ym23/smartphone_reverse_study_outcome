package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ResourceDecoderRegistry {
    private final List<String> bucketPriorityList;
    private final Map<String, List<Entry<?, ?>>> decoders;

    private static class Entry<T, R> {
        private final Class<T> dataClass;
        final ResourceDecoder<T, R> decoder;
        final Class<R> resourceClass;

        public Entry(Class<T> r1, Class<R> r2, ResourceDecoder<T, R> r3) {
            this.dataClass = r1;
            this.resourceClass = r2;
            this.decoder = r3;
        }

        public boolean handles(Class<?> r2, Class<?> r3) {
            if (this.dataClass.isAssignableFrom(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (r3.isAssignableFrom(this.resourceClass) == false) goto L7;
            return true;
        }
    }

    public ResourceDecoderRegistry() {
        this.bucketPriorityList = new ArrayList();
        this.decoders = new HashMap();
    }

    public synchronized void setBucketPriorityList(List<String> r5) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList(this.bucketPriorityList);     // Catch: Throwable -> L16
        this.bucketPriorityList.clear();     // Catch: Throwable -> L16
        Iterator<String> r1 = r5.iterator();     // Catch: Throwable -> L16
    L5:
        if (r1.hasNext() == false) goto L7;
        String r2 = r1.next();     // Catch: Throwable -> L16
        this.bucketPriorityList.add(r2);     // Catch: Throwable -> L16
        goto L5
    L7:
        Iterator r3 = r0.iterator();     // Catch: Throwable -> L16
    L8:
        if (r3.hasNext() == false) goto L14;
        String r4 = (String) r3.next();     // Catch: Throwable -> L16
        if (r5.contains(r4) == true) goto L8;
        this.bucketPriorityList.add(r4);     // Catch: Throwable -> L16
        goto L8
    L14:
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public synchronized <T, R> List<ResourceDecoder<T, R>> getDecoders(Class<T> r6, Class<R> r7) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L18
        Iterator<String> r1 = this.bucketPriorityList.iterator();     // Catch: Throwable -> L18
    L5:
        if (r1.hasNext() == false) goto L16;
        String r2 = r1.next();     // Catch: Throwable -> L18
        List<Entry<?, ?>> r3 = this.decoders.get(r2);     // Catch: Throwable -> L18
        if (r3 == null) goto L5;
        Iterator<Entry<?, ?>> r4 = r3.iterator();     // Catch: Throwable -> L18
    L11:
        if (r4.hasNext() == false) goto L5;
        Entry<?, ?> r5 = r4.next();     // Catch: Throwable -> L18
        if (r5.handles(r6, r7) == false) goto L11;
        r0.add(r5.decoder);     // Catch: Throwable -> L18
        goto L11
    L16:
        monitor-exit(this);
        return r0;
    L18:
        th = move-exception;
        throw th;
    }

    public synchronized <T, R> List<Class<R>> getResourceClasses(Class<T> r6, Class<R> r7) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L20
        Iterator<String> r1 = this.bucketPriorityList.iterator();     // Catch: Throwable -> L20
    L5:
        if (r1.hasNext() == false) goto L18;
        String r2 = r1.next();     // Catch: Throwable -> L20
        List<Entry<?, ?>> r3 = this.decoders.get(r2);     // Catch: Throwable -> L20
        if (r3 == null) goto L5;
        Iterator<Entry<?, ?>> r4 = r3.iterator();     // Catch: Throwable -> L20
    L11:
        if (r4.hasNext() == false) goto L5;
        Entry<?, ?> r5 = r4.next();     // Catch: Throwable -> L20
        if (r5.handles(r6, r7) == false) goto L11;
        if (r0.contains(r5.resourceClass) == true) goto L11;
        r0.add(r5.resourceClass);     // Catch: Throwable -> L20
        goto L11
    L18:
        monitor-exit(this);
        return r0;
    L20:
        th = move-exception;
        throw th;
    }

    public synchronized <T, R> void append(String r2, ResourceDecoder<T, R> r3, Class<T> r4, Class<R> r5) {
        monitor-enter(this);
        getOrAddEntryList(r2).add(new Entry(r4, r5, r3));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <T, R> void prepend(String r2, ResourceDecoder<T, R> r3, Class<T> r4, Class<R> r5) {
        monitor-enter(this);
        getOrAddEntryList(r2).add(0, new Entry(r4, r5, r3));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized List<Entry<?, ?>> getOrAddEntryList(String r3) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.bucketPriorityList.contains(r3) == true) goto L6;
        this.bucketPriorityList.add(r3);     // Catch: Throwable -> L11
    L6:
        List<Entry<?, ?>> r0 = this.decoders.get(r3);     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        r0 = new ArrayList();     // Catch: Throwable -> L11
        this.decoders.put(r3, r0);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return r0;
    }
}
