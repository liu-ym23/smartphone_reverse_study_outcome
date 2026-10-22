package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class DecodeHelper<Transcode> {
    private final List<Key> cacheKeys;
    private DecodeJob.DiskCacheProvider diskCacheProvider;
    private DiskCacheStrategy diskCacheStrategy;
    private GlideContext glideContext;
    private int height;
    private boolean isCacheKeysSet;
    private boolean isLoadDataSet;
    private boolean isScaleOnlyOrNoTransform;
    private boolean isTransformationRequired;
    private final List<ModelLoader.LoadData<?>> loadData;
    private Object model;
    private Options options;
    private Priority priority;
    private Class<?> resourceClass;
    private Key signature;
    private Class<Transcode> transcodeClass;
    private Map<Class<?>, Transformation<?>> transformations;
    private int width;

    DecodeHelper() {
        this.loadData = new ArrayList();
        this.cacheKeys = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    <R> void init(GlideContext r1, Object r2, Key r3, int r4, int r5, DiskCacheStrategy r6, Class<?> r7, Class<R> r8, Priority r9, Options r10, Map<Class<?>, Transformation<?>> r11, boolean r12, boolean r13, DecodeJob.DiskCacheProvider r14) {
        this.glideContext = r1;
        this.model = r2;
        this.signature = r3;
        this.width = r4;
        this.height = r5;
        this.diskCacheStrategy = r6;
        this.resourceClass = r7;
        this.diskCacheProvider = r14;
        this.transcodeClass = r8;
        this.priority = r9;
        this.options = r10;
        this.transformations = r11;
        this.isTransformationRequired = r12;
        this.isScaleOnlyOrNoTransform = r13;
    }

    void clear() {
        this.glideContext = null;
        this.model = null;
        this.signature = null;
        this.resourceClass = null;
        this.transcodeClass = null;
        this.options = null;
        this.priority = null;
        this.transformations = null;
        this.diskCacheStrategy = null;
        this.loadData.clear();
        this.isLoadDataSet = false;
        this.cacheKeys.clear();
        this.isCacheKeysSet = false;
    }

    DiskCache getDiskCache() {
        return this.diskCacheProvider.getDiskCache();
    }

    DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    <T> DataRewinder<T> getRewinder(T r1) {
        return this.glideContext.getRegistry().getRewinder(r1);
    }

    Priority getPriority() {
        return this.priority;
    }

    Options getOptions() {
        return this.options;
    }

    Key getSignature() {
        return this.signature;
    }

    int getWidth() {
        return this.width;
    }

    int getHeight() {
        return this.height;
    }

    ArrayPool getArrayPool() {
        return this.glideContext.getArrayPool();
    }

    Class<?> getTranscodeClass() {
        return this.transcodeClass;
    }

    Class<?> getModelClass() {
        return this.model.getClass();
    }

    List<Class<?>> getRegisteredResourceClasses() {
        return this.glideContext.getRegistry().getRegisteredResourceClasses(this.model.getClass(), this.resourceClass, this.transcodeClass);
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean hasLoadPath(Class<?> r1) {
        if (getLoadPath(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    <Data> LoadPath<Data, ?, Transcode> getLoadPath(Class<Data> r3) {
        return this.glideContext.getRegistry().getLoadPath(r3, this.resourceClass, this.transcodeClass);
    }

    boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    <Z> Transformation<Z> getTransformation(Class<Z> r5) {
        Transformation<Z> r0 = (Transformation) this.transformations.get(r5);
        if (r0 != null) goto L10;
        Iterator<Map.Entry<Class<?>, Transformation<?>>> r1 = this.transformations.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<Class<?>, Transformation<?>> r2 = r1.next();
        if (r2.getKey().isAssignableFrom(r5) == false) goto L6;
        r0 = (Transformation) r2.getValue();
    L10:
        if (r0 == null) goto L12;
        return r0;
    L12:
        if (this.transformations.isEmpty() == false) goto L19;
        if (this.isTransformationRequired == false) goto L19;
        throw new IllegalArgumentException("Missing transformation for " + r5 + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    L19:
        return UnitTransformation.get();
    }

    boolean isResourceEncoderAvailable(Resource<?> r1) {
        return this.glideContext.getRegistry().isResourceEncoderAvailable(r1);
    }

    <Z> ResourceEncoder<Z> getResultEncoder(Resource<Z> r1) {
        return this.glideContext.getRegistry().getResultEncoder(r1);
    }

    List<ModelLoader<File, ?>> getModelLoaders(File r1) throws Registry.NoModelLoaderAvailableException {
        return this.glideContext.getRegistry().getModelLoaders(r1);
    }

    boolean isSourceKey(Key r5) {
        List<ModelLoader.LoadData<?>> r4 = getLoadData();
        int r0 = r4.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r4.get(r2).sourceKey.equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    List<ModelLoader.LoadData<?>> getLoadData() {
        if (this.isLoadDataSet == true) goto L11;
        this.isLoadDataSet = true;
        this.loadData.clear();
        List r0 = this.glideContext.getRegistry().getModelLoaders(this.model);
        int r1 = r0.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L11;
        ModelLoader.LoadData<?> r3 = ((ModelLoader) r0.get(r2)).buildLoadData(this.model, this.width, this.height, this.options);
        if (r3 == null) goto L9;
        this.loadData.add(r3);
    L9:
        r2 = r2 + 1;
    L11:
        return this.loadData;
    }

    List<Key> getCacheKeys() {
        if (this.isCacheKeysSet == true) goto L18;
        this.isCacheKeysSet = true;
        this.cacheKeys.clear();
        List<ModelLoader.LoadData<?>> r0 = getLoadData();
        int r1 = r0.size();
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L18;
        ModelLoader.LoadData<?> r4 = r0.get(r3);
        if (this.cacheKeys.contains(r4.sourceKey) == true) goto L9;
        this.cacheKeys.add(r4.sourceKey);
    L9:
        int r5 = 0;
    L11:
        if (r5 >= r4.alternateKeys.size()) goto L16;
        if (this.cacheKeys.contains(r4.alternateKeys.get(r5)) == true) goto L15;
        this.cacheKeys.add(r4.alternateKeys.get(r5));
    L15:
        r5 = r5 + 1;
        goto L11
    L16:
        r3 = r3 + 1;
    L18:
        return this.cacheKeys;
    }

    <X> Encoder<X> getSourceEncoder(X r1) throws Registry.NoSourceEncoderAvailableException {
        return this.glideContext.getRegistry().getSourceEncoder(r1);
    }
}
