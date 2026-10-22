package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ModelLoaderRegistry {
    private final ModelLoaderCache cache;
    private final MultiModelLoaderFactory multiModelLoaderFactory;

    private static class ModelLoaderCache {
        private final Map<Class<?>, Entry<?>> cachedModelLoaders;

        private static class Entry<Model> {
            final List<ModelLoader<Model, ?>> loaders;

            public Entry(List<ModelLoader<Model, ?>> r1) {
                this.loaders = r1;
            }
        }

        ModelLoaderCache() {
            this.cachedModelLoaders = new HashMap();
        }

        public void clear() {
            this.cachedModelLoaders.clear();
        }

        public <Model> void put(Class<Model> r2, List<ModelLoader<Model, ?>> r3) {
            if (this.cachedModelLoaders.put(r2, new Entry(r3)) != null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Already cached loaders for model: " + r2);
        }

        public <Model> List<ModelLoader<Model, ?>> get(Class<Model> r1) {
            Entry<?> r0 = this.cachedModelLoaders.get(r1);
            if (r0 != null) goto L6;
            return null;
        L6:
            return (List<ModelLoader<Model, ?>>) r0.loaders;
        }
    }

    public ModelLoaderRegistry(Pools.Pool<List<Throwable>> r2) {
        this(new MultiModelLoaderFactory(r2));
    }

    private ModelLoaderRegistry(MultiModelLoaderFactory r2) {
        this.cache = new ModelLoaderCache();
        this.multiModelLoaderFactory = r2;
    }

    public synchronized <Model, Data> void append(Class<Model> r2, Class<Data> r3, ModelLoaderFactory<? extends Model, ? extends Data> r4) {
        monitor-enter(this);
        this.multiModelLoaderFactory.append(r2, r3, r4);     // Catch: Throwable -> L6
        this.cache.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <Model, Data> void prepend(Class<Model> r2, Class<Data> r3, ModelLoaderFactory<? extends Model, ? extends Data> r4) {
        monitor-enter(this);
        this.multiModelLoaderFactory.prepend(r2, r3, r4);     // Catch: Throwable -> L6
        this.cache.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <Model, Data> void remove(Class<Model> r2, Class<Data> r3) {
        monitor-enter(this);
        tearDown(this.multiModelLoaderFactory.remove(r2, r3));     // Catch: Throwable -> L6
        this.cache.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <Model, Data> void replace(Class<Model> r2, Class<Data> r3, ModelLoaderFactory<? extends Model, ? extends Data> r4) {
        monitor-enter(this);
        tearDown(this.multiModelLoaderFactory.replace(r2, r3, r4));     // Catch: Throwable -> L6
        this.cache.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private <Model, Data> void tearDown(List<ModelLoaderFactory<? extends Model, ? extends Data>> r1) {
        Iterator<ModelLoaderFactory<? extends Model, ? extends Data>> r0 = r1.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().teardown();
        goto L4
    }

    public <A> List<ModelLoader<A, ?>> getModelLoaders(A r8) {
        List<ModelLoader<A, ?>> r7 = getModelLoadersForClass(getClass(r8));
        if (r7.isEmpty() == true) goto L18;
        int r0 = r7.size();
        List<ModelLoader<A, ?>> r1 = Collections.emptyList();
        boolean r3 = true;
        int r4 = 0;
    L5:
        if (r4 >= r0) goto L13;
        ModelLoader<A, ?> r5 = r7.get(r4);
        if (r5.handles(r8) == false) goto L11;
        if (r3 == false) goto L10;
        r1 = new ArrayList(r0 - r4);
        r3 = false;
    L10:
        r1.add(r5);
    L11:
        r4 = r4 + 1;
        goto L5
    L13:
        if (r1.isEmpty() == true) goto L16;
        return r1;
    L16:
        throw new Registry.NoModelLoaderAvailableException(r8, r7);
    L18:
        throw new Registry.NoModelLoaderAvailableException(r8);
    }

    public synchronized <Model, Data> ModelLoader<Model, Data> build(Class<Model> r2, Class<Data> r3) {
        monitor-enter(this);
        ModelLoader<Model, Data> r4 = this.multiModelLoaderFactory.build(r2, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized List<Class<?>> getDataClasses(Class<?> r2) {
        monitor-enter(this);
        List<Class<?>> r3 = this.multiModelLoaderFactory.getDataClasses(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized <A> List<ModelLoader<A, ?>> getModelLoadersForClass(Class<A> r3) {
        monitor-enter(this);
        List<ModelLoader<A, ?>> r0 = this.cache.get(r3);     // Catch: Throwable -> L8
        if (r0 != null) goto L6;
        r0 = Collections.unmodifiableList(this.multiModelLoaderFactory.build(r3));     // Catch: Throwable -> L8
        this.cache.put(r3, r0);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r0;
    L8:
        th = move-exception;
        throw th;
    }

    private static <A> Class<A> getClass(A r0) {
        return (Class<A>) r0.getClass();
    }
}
