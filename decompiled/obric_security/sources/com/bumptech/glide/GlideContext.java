package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.util.GlideSuppliers;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GlideContext extends ContextWrapper {
    static final TransitionOptions<?, ?> DEFAULT_TRANSITION_OPTIONS = null;
    private final ArrayPool arrayPool;
    private final List<RequestListener<Object>> defaultRequestListeners;
    private RequestOptions defaultRequestOptions;
    private final Glide.RequestOptionsFactory defaultRequestOptionsFactory;
    private final Map<Class<?>, TransitionOptions<?, ?>> defaultTransitionOptions;
    private final Engine engine;
    private final GlideExperiments experiments;
    private final ImageViewTargetFactory imageViewTargetFactory;
    private final int logLevel;
    private final GlideSuppliers.GlideSupplier<Registry> registry;

    static {
        DEFAULT_TRANSITION_OPTIONS = new GenericTransitionOptions();
    }

    public GlideContext(Context r1, ArrayPool r2, GlideSuppliers.GlideSupplier<Registry> r3, ImageViewTargetFactory r4, Glide.RequestOptionsFactory r5, Map<Class<?>, TransitionOptions<?, ?>> r6, List<RequestListener<Object>> r7, Engine r8, GlideExperiments r9, int r10) {
        super(r1.getApplicationContext());
        this.arrayPool = r2;
        this.imageViewTargetFactory = r4;
        this.defaultRequestOptionsFactory = r5;
        this.defaultRequestListeners = r7;
        this.defaultTransitionOptions = r6;
        this.engine = r8;
        this.experiments = r9;
        this.logLevel = r10;
        this.registry = GlideSuppliers.memorize(r3);
    }

    public List<RequestListener<Object>> getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    public synchronized RequestOptions getDefaultRequestOptions() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.defaultRequestOptions != null) goto L6;
        this.defaultRequestOptions = this.defaultRequestOptionsFactory.build().lock();     // Catch: Throwable -> L9
    L6:
        RequestOptions r0 = this.defaultRequestOptions;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public <T> TransitionOptions<?, T> getDefaultTransitionOptions(Class<T> r4) {
        TransitionOptions<?, T> r0 = (TransitionOptions) this.defaultTransitionOptions.get(r4);
        if (r0 != null) goto L10;
        Iterator<Map.Entry<Class<?>, TransitionOptions<?, ?>>> r3 = this.defaultTransitionOptions.entrySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Map.Entry<Class<?>, TransitionOptions<?, ?>> r1 = r3.next();
        if (r1.getKey().isAssignableFrom(r4) == false) goto L6;
        r0 = (TransitionOptions) r1.getValue();
    L10:
        if (r0 == null) goto L12;
        return r0;
    L12:
        return (TransitionOptions<?, T>) DEFAULT_TRANSITION_OPTIONS;
    }

    public <X> ViewTarget<ImageView, X> buildImageViewTarget(ImageView r1, Class<X> r2) {
        return this.imageViewTargetFactory.buildTarget(r1, r2);
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Registry getRegistry() {
        return this.registry.get();
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public ArrayPool getArrayPool() {
        return this.arrayPool;
    }

    public GlideExperiments getExperiments() {
        return this.experiments;
    }
}
