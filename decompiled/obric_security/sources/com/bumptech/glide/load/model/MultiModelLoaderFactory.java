package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MultiModelLoaderFactory {
    private static final Factory DEFAULT_FACTORY = null;
    private static final ModelLoader<Object, Object> EMPTY_MODEL_LOADER = null;
    private final Set<Entry<?, ?>> alreadyUsedEntries;
    private final List<Entry<?, ?>> entries;
    private final Factory factory;
    private final Pools.Pool<List<Throwable>> throwableListPool;

    private static class EmptyModelLoader implements ModelLoader<Object, Object> {
        @Override // com.bumptech.glide.load.model.ModelLoader
        public ModelLoader.LoadData<Object> buildLoadData(Object r1, int r2, int r3, Options r4) {
            return null;
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        public boolean handles(Object r1) {
            return false;
        }

        EmptyModelLoader() {
        }
    }

    private static class Entry<Model, Data> {
        final Class<Data> dataClass;
        final ModelLoaderFactory<? extends Model, ? extends Data> factory;
        private final Class<Model> modelClass;

        public Entry(Class<Model> r1, Class<Data> r2, ModelLoaderFactory<? extends Model, ? extends Data> r3) {
            this.modelClass = r1;
            this.dataClass = r2;
            this.factory = r3;
        }

        public boolean handles(Class<?> r1, Class<?> r2) {
            if (handles(r1) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.dataClass.isAssignableFrom(r2) == false) goto L7;
            return true;
        }

        public boolean handles(Class<?> r1) {
            return this.modelClass.isAssignableFrom(r1);
        }
    }

    static class Factory {
        Factory() {
        }

        public <Model, Data> MultiModelLoader<Model, Data> build(List<ModelLoader<Model, Data>> r1, Pools.Pool<List<Throwable>> r2) {
            return new MultiModelLoader(r1, r2);
        }
    }

    static {
        DEFAULT_FACTORY = new Factory();
        EMPTY_MODEL_LOADER = new EmptyModelLoader();
    }

    public MultiModelLoaderFactory(Pools.Pool<List<Throwable>> r2) {
        this(r2, DEFAULT_FACTORY);
    }

    MultiModelLoaderFactory(Pools.Pool<List<Throwable>> r2, Factory r3) {
        this.entries = new ArrayList();
        this.alreadyUsedEntries = new HashSet();
        this.throwableListPool = r2;
        this.factory = r3;
    }

    synchronized <Model, Data> void append(Class<Model> r2, Class<Data> r3, ModelLoaderFactory<? extends Model, ? extends Data> r4) {
        monitor-enter(this);
        add(r2, r3, r4, true);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    synchronized <Model, Data> void prepend(Class<Model> r2, Class<Data> r3, ModelLoaderFactory<? extends Model, ? extends Data> r4) {
        monitor-enter(this);
        add(r2, r3, r4, false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private <Model, Data> void add(Class<Model> r2, Class<Data> r3, ModelLoaderFactory<? extends Model, ? extends Data> r4, boolean r5) {
        Entry<?, ?> r0 = new Entry(r2, r3, r4);
        List<Entry<?, ?>> r1 = this.entries;
        if (r5 == false) goto L5;
        int r6 = r1.size();
    L6:
        r1.add(r6, r0);
        return;
    L5:
        r6 = 0;
        goto L6
    }

    synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> replace(Class<Model> r2, Class<Data> r3, ModelLoaderFactory<? extends Model, ? extends Data> r4) {
        monitor-enter(this);
        List<ModelLoaderFactory<? extends Model, ? extends Data>> r0 = remove(r2, r3);     // Catch: Throwable -> L6
        append(r2, r3, r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> remove(Class<Model> r5, Class<Data> r6) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L12
        Iterator<Entry<?, ?>> r1 = this.entries.iterator();     // Catch: Throwable -> L12
    L5:
        if (r1.hasNext() == false) goto L10;
        Entry<?, ?> r2 = r1.next();     // Catch: Throwable -> L12
        if (r2.handles(r5, r6) == false) goto L5;
        r1.remove();     // Catch: Throwable -> L12
        r0.add(getFactory(r2));     // Catch: Throwable -> L12
        goto L5
    L10:
        monitor-exit(this);
        return r0;
    L12:
        th = move-exception;
        throw th;
    }

    synchronized <Model> List<ModelLoader<Model, ?>> build(Class<Model> r5) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L15
        Iterator<Entry<?, ?>> r1 = this.entries.iterator();     // Catch: Throwable -> L15
    L5:
        if (r1.hasNext() == false) goto L13;
        Entry<?, ?> r2 = r1.next();     // Catch: Throwable -> L15
        if (this.alreadyUsedEntries.contains(r2) == true) goto L5;
        if (r2.handles(r5) == false) goto L5;
        this.alreadyUsedEntries.add(r2);     // Catch: Throwable -> L15
        r0.add(build(r2));     // Catch: Throwable -> L15
        this.alreadyUsedEntries.remove(r2);     // Catch: Throwable -> L15
        goto L5
    L13:
        monitor-exit(this);
        return r0;
    L15:
        th = move-exception;
        this.alreadyUsedEntries.clear();     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    synchronized List<Class<?>> getDataClasses(Class<?> r5) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L14
        Iterator<Entry<?, ?>> r1 = this.entries.iterator();     // Catch: Throwable -> L14
    L5:
        if (r1.hasNext() == false) goto L12;
        Entry<?, ?> r2 = r1.next();     // Catch: Throwable -> L14
        if (r0.contains(r2.dataClass) == true) goto L5;
        if (r2.handles(r5) == false) goto L5;
        r0.add(r2.dataClass);     // Catch: Throwable -> L14
        goto L5
    L12:
        monitor-exit(this);
        return r0;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized <Model, Data> ModelLoader<Model, Data> build(Class<Model> r8, Class<Data> r9) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L28
        Iterator<Entry<?, ?>> r1 = this.entries.iterator();     // Catch: Throwable -> L28
        boolean r3 = false;
    L5:
        if (r1.hasNext() == false) goto L13;
        Entry<?, ?> r4 = r1.next();     // Catch: Throwable -> L28
        if (this.alreadyUsedEntries.contains(r4) == true) goto L8;
        if (r4.handles(r8, r9) == false) goto L5;
        this.alreadyUsedEntries.add(r4);     // Catch: Throwable -> L28
        r0.add(build(r4));     // Catch: Throwable -> L28
        this.alreadyUsedEntries.remove(r4);     // Catch: Throwable -> L28
        goto L5
    L8:
        r3 = true;
        goto L5
    L13:
        if (r0.size() <= 1) goto L18;
        MultiModelLoader<Model, Data> r10 = this.factory.build(r0, this.throwableListPool);     // Catch: Throwable -> L28
        monitor-exit(this);
        return r10;
    L18:
        if (r0.size() != 1) goto L22;
        ModelLoader<Model, Data> r11 = (ModelLoader) r0.get(0);     // Catch: Throwable -> L28
        monitor-exit(this);
        return r11;
    L22:
        if (r3 == false) goto L27;
        ModelLoader<Model, Data> r12 = emptyModelLoader();     // Catch: Throwable -> L28
        monitor-exit(this);
        return r12;
    L27:
        throw new Registry.NoModelLoaderAvailableException(r8, r9);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        this.alreadyUsedEntries.clear();     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    private <Model, Data> ModelLoaderFactory<Model, Data> getFactory(Entry<?, ?> r1) {
        return (ModelLoaderFactory<Model, Data>) r1.factory;
    }

    private <Model, Data> ModelLoader<Model, Data> build(Entry<?, ?> r1) {
        return (ModelLoader) Preconditions.checkNotNull(r1.factory.build(this));
    }

    private static <Model, Data> ModelLoader<Model, Data> emptyModelLoader() {
        return (ModelLoader<Model, Data>) EMPTY_MODEL_LOADER;
    }
}
