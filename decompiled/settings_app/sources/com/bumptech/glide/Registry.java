package com.bumptech.glide;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Registry {
    public static final String BUCKET_ANIMATION = "Animation";
    private static final String BUCKET_APPEND_ALL = "legacy_append";
    public static final String BUCKET_BITMAP = "Bitmap";
    public static final String BUCKET_BITMAP_DRAWABLE = "BitmapDrawable";

    @Deprecated
    public static final String BUCKET_GIF = "Animation";
    private static final String BUCKET_PREPEND_ALL = "legacy_prepend_all";
    private final DataRewinderRegistry dataRewinderRegistry;
    private final ResourceDecoderRegistry decoderRegistry;
    private final EncoderRegistry encoderRegistry;
    private final ImageHeaderParserRegistry imageHeaderParserRegistry;
    private final LoadPathCache loadPathCache;
    private final ModelLoaderRegistry modelLoaderRegistry;
    private final ModelToResourceClassCache modelToResourceClassCache;
    private final ResourceEncoderRegistry resourceEncoderRegistry;
    private final Pools.Pool<List<Throwable>> throwableListPool;
    private final TranscoderRegistry transcoderRegistry;

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String r1) {
            super(r1);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Object r3) {
            super("Failed to find any ModelLoaders registered for model class: " + r3.getClass());
        }

        public <M> NoModelLoaderAvailableException(M r3, List<ModelLoader<M, ?>> r4) {
            super("Found ModelLoaders for model class: " + r4 + ", but none that handle this specific model instance: " + r3);
        }

        public NoModelLoaderAvailableException(Class<?> r3, Class<?> r4) {
            super("Failed to find any ModelLoaders for model: " + r3 + " and data: " + r4);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> r3) {
            super("Failed to find result encoder for resource class: " + r3 + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> r3) {
            super("Failed to find source encoder for data class: " + r3);
        }
    }

    public Registry() {
        this.modelToResourceClassCache = new ModelToResourceClassCache();
        this.loadPathCache = new LoadPathCache();
        Pools.Pool<List<Throwable>> r0 = FactoryPools.threadSafeList();
        this.throwableListPool = r0;
        this.modelLoaderRegistry = new ModelLoaderRegistry(r0);
        this.encoderRegistry = new EncoderRegistry();
        this.decoderRegistry = new ResourceDecoderRegistry();
        this.resourceEncoderRegistry = new ResourceEncoderRegistry();
        this.dataRewinderRegistry = new DataRewinderRegistry();
        this.transcoderRegistry = new TranscoderRegistry();
        this.imageHeaderParserRegistry = new ImageHeaderParserRegistry();
        setResourceDecoderBucketPriorityList(Arrays.asList(new String[]{"Animation", BUCKET_BITMAP, BUCKET_BITMAP_DRAWABLE}));
    }

    @Deprecated
    public <Data> Registry register(Class<Data> r1, Encoder<Data> r2) {
        return append(r1, r2);
    }

    public <Data> Registry append(Class<Data> r2, Encoder<Data> r3) {
        this.encoderRegistry.append(r2, r3);
        return this;
    }

    public <Data> Registry prepend(Class<Data> r2, Encoder<Data> r3) {
        this.encoderRegistry.prepend(r2, r3);
        return this;
    }

    public <Data, TResource> Registry append(Class<Data> r2, Class<TResource> r3, ResourceDecoder<Data, TResource> r4) {
        append(BUCKET_APPEND_ALL, r2, r3, r4);
        return this;
    }

    public <Data, TResource> Registry append(String r2, Class<Data> r3, Class<TResource> r4, ResourceDecoder<Data, TResource> r5) {
        this.decoderRegistry.append(r2, r5, r3, r4);
        return this;
    }

    public <Data, TResource> Registry prepend(Class<Data> r2, Class<TResource> r3, ResourceDecoder<Data, TResource> r4) {
        prepend(BUCKET_PREPEND_ALL, r2, r3, r4);
        return this;
    }

    public <Data, TResource> Registry prepend(String r2, Class<Data> r3, Class<TResource> r4, ResourceDecoder<Data, TResource> r5) {
        this.decoderRegistry.prepend(r2, r5, r3, r4);
        return this;
    }

    public final Registry setResourceDecoderBucketPriorityList(List<String> r3) {
        ArrayList r0 = new ArrayList(r3.size());
        r0.add(BUCKET_PREPEND_ALL);
        Iterator<String> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(r4.next());
        goto L4
    L6:
        r0.add(BUCKET_APPEND_ALL);
        this.decoderRegistry.setBucketPriorityList(r0);
        return this;
    }

    @Deprecated
    public <TResource> Registry register(Class<TResource> r1, ResourceEncoder<TResource> r2) {
        return append(r1, r2);
    }

    public <TResource> Registry append(Class<TResource> r2, ResourceEncoder<TResource> r3) {
        this.resourceEncoderRegistry.append(r2, r3);
        return this;
    }

    public <TResource> Registry prepend(Class<TResource> r2, ResourceEncoder<TResource> r3) {
        this.resourceEncoderRegistry.prepend(r2, r3);
        return this;
    }

    public Registry register(DataRewinder.Factory<?> r2) {
        this.dataRewinderRegistry.register(r2);
        return this;
    }

    public <TResource, Transcode> Registry register(Class<TResource> r2, Class<Transcode> r3, ResourceTranscoder<TResource, Transcode> r4) {
        this.transcoderRegistry.register(r2, r3, r4);
        return this;
    }

    public Registry register(ImageHeaderParser r2) {
        this.imageHeaderParserRegistry.add(r2);
        return this;
    }

    public <Model, Data> Registry append(Class<Model> r2, Class<Data> r3, ModelLoaderFactory<Model, Data> r4) {
        this.modelLoaderRegistry.append(r2, r3, r4);
        return this;
    }

    public <Model, Data> Registry prepend(Class<Model> r2, Class<Data> r3, ModelLoaderFactory<Model, Data> r4) {
        this.modelLoaderRegistry.prepend(r2, r3, r4);
        return this;
    }

    public <Model, Data> Registry replace(Class<Model> r2, Class<Data> r3, ModelLoaderFactory<? extends Model, ? extends Data> r4) {
        this.modelLoaderRegistry.replace(r2, r3, r4);
        return this;
    }

    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> getLoadPath(Class<Data> r10, Class<TResource> r11, Class<Transcode> r12) {
        LoadPath<Data, TResource, Transcode> r0 = this.loadPathCache.get(r10, r11, r12);
        if (this.loadPathCache.isEmptyLoadPath(r0) == false) goto L5;
        return null;
    L5:
        if (r0 != null) goto L11;
        List<DecodePath<Data, TResource, Transcode>> r7 = getDecodePaths(r10, r11, r12);
        if (r7.isEmpty() == false) goto L9;
        r0 = null;
    L10:
        this.loadPathCache.put(r10, r11, r12, r0);
        goto L11
    L9:
        r0 = new LoadPath(r10, r11, r12, r7, this.throwableListPool);
    L11:
        return r0;
    }

    private <Data, TResource, Transcode> List<DecodePath<Data, TResource, Transcode>> getDecodePaths(Class<Data> r12, Class<TResource> r13, Class<Transcode> r14) {
        ArrayList r0 = new ArrayList();
        Iterator r15 = this.decoderRegistry.getResourceClasses(r12, r13).iterator();
    L4:
        if (r15.hasNext() == false) goto L9;
        Class r1 = (Class) r15.next();
        Iterator r9 = this.transcoderRegistry.getTranscodeClasses(r1, r14).iterator();
    L7:
        if (r9.hasNext() == false) goto L4;
        Class r5 = (Class) r9.next();
        r0.add(new DecodePath(r12, r1, r5, this.decoderRegistry.getDecoders(r12, r1), this.transcoderRegistry.get(r1, r5), this.throwableListPool));
        goto L7
    L9:
        return r0;
    }

    public <Model, TResource, Transcode> List<Class<?>> getRegisteredResourceClasses(Class<Model> r6, Class<TResource> r7, Class<Transcode> r8) {
        List<Class<?>> r0 = this.modelToResourceClassCache.get(r6, r7, r8);
        if (r0 != null) goto L16;
        r0 = new ArrayList();
        Iterator<Class<?>> r1 = this.modelLoaderRegistry.getDataClasses(r6).iterator();
    L6:
        if (r1.hasNext() == false) goto L15;
        Class<?> r2 = r1.next();
        Iterator r3 = this.decoderRegistry.getResourceClasses(r2, r7).iterator();
    L9:
        if (r3.hasNext() == false) goto L6;
        Class<?> r4 = (Class) r3.next();
        if (this.transcoderRegistry.getTranscodeClasses(r4, r8).isEmpty() == true) goto L9;
        if (r0.contains(r4) == true) goto L9;
        r0.add(r4);
        goto L9
    L15:
        this.modelToResourceClassCache.put(r6, r7, r8, Collections.unmodifiableList(r0));
    L16:
        return r0;
    }

    public boolean isResourceEncoderAvailable(Resource<?> r1) {
        if (this.resourceEncoderRegistry.get(r1.getResourceClass()) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public <X> ResourceEncoder<X> getResultEncoder(Resource<X> r2) throws NoResultEncoderAvailableException {
        ResourceEncoder<X> r1 = this.resourceEncoderRegistry.get(r2.getResourceClass());
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new NoResultEncoderAvailableException(r2.getResourceClass());
    }

    public <X> Encoder<X> getSourceEncoder(X r2) throws NoSourceEncoderAvailableException {
        Encoder<X> r1 = this.encoderRegistry.getEncoder(r2.getClass());
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new NoSourceEncoderAvailableException(r2.getClass());
    }

    public <X> DataRewinder<X> getRewinder(X r1) {
        return this.dataRewinderRegistry.build(r1);
    }

    public <Model> List<ModelLoader<Model, ?>> getModelLoaders(Model r1) {
        return this.modelLoaderRegistry.getModelLoaders(r1);
    }

    public List<ImageHeaderParser> getImageHeaderParsers() {
        List<ImageHeaderParser> r1 = this.imageHeaderParserRegistry.getParsers();
        if (r1.isEmpty() == true) goto L6;
        return r1;
    L6:
        throw new NoImageHeaderParserException();
    }
}
