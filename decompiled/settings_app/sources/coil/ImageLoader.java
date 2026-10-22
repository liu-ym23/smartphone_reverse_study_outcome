package coil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import coil.decode.ExifOrientationPolicy;
import coil.disk.DiskCache;
import coil.memory.MemoryCache;
import coil.request.CachePolicy;
import coil.request.DefaultRequestOptions;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.size.Precision;
import coil.transition.CrossfadeTransition;
import coil.transition.Transition;
import coil.util.Contexts;
import coil.util.ImageLoaderOptions;
import coil.util.Logger;
import coil.util.Requests;
import coil.util.Utils;
import com.android.settings.fuelgauge.PowerUsageDetail;
import com.android.settings.search.IndexDatabaseHelper;
import com.obric.capabilitykit.common.Ext;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: ImageLoader.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u001dJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\u001cH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011ø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u001eÀ\u0006\u0001"}, d2 = {"Lcoil/ImageLoader;", "", "components", "Lcoil/ComponentRegistry;", "getComponents", "()Lcoil/ComponentRegistry;", "defaults", "Lcoil/request/DefaultRequestOptions;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "diskCache", "Lcoil/disk/DiskCache;", "getDiskCache", "()Lcoil/disk/DiskCache;", "memoryCache", "Lcoil/memory/MemoryCache;", "getMemoryCache", "()Lcoil/memory/MemoryCache;", "enqueue", "Lcoil/request/Disposable;", Ext.KEY_REQUEST, "Lcoil/request/ImageRequest;", "execute", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newBuilder", "Lcoil/ImageLoader$Builder;", "shutdown", "", "Builder", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ImageLoader {

    /* JADX INFO: compiled from: ImageLoader.kt */
    @Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\u0012\u0010\u001f\u001a\u00020\u00002\b\b\u0001\u0010 \u001a\u00020!H\u0007J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020+J\u0014\u0010\t\u001a\u00020\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0-J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\rH\u0007J!\u0010\f\u001a\u00020\u00002\u0017\u0010/\u001a\u0013\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020200¢\u0006\u0002\b3H\u0007J\u000e\u00104\u001a\u00020\u00002\u0006\u00104\u001a\u00020\rJ\"\u00104\u001a\u00020\u00002\u0017\u0010/\u001a\u0013\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020200¢\u0006\u0002\b3H\u0086\bJ\u000e\u00105\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u00020)J\u000e\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u000209J\u0016\u0010\u0010\u001a\u00020\u00002\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110-J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010%\u001a\u00020;J\u000e\u00108\u001a\u00020\u00002\u0006\u00108\u001a\u000209J\u0010\u0010<\u001a\u00020\u00002\b\u0010=\u001a\u0004\u0018\u00010>J\u0010\u0010<\u001a\u00020\u00002\b\b\u0001\u0010?\u001a\u00020)J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020BJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\u0013J\u0010\u0010D\u001a\u00020\u00002\b\u0010=\u001a\u0004\u0018\u00010>J\u0010\u0010D\u001a\u00020\u00002\b\b\u0001\u0010?\u001a\u00020)J\u000e\u0010E\u001a\u00020\u00002\u0006\u00108\u001a\u000209J\u000e\u0010F\u001a\u00020\u00002\u0006\u00108\u001a\u000209J\u0010\u0010G\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0016\u0010\u0016\u001a\u00020\u00002\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170-J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u0010H\u001a\u00020\u00002\u0006\u0010%\u001a\u00020;J\u000e\u0010I\u001a\u00020\u00002\u0006\u0010%\u001a\u00020;J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\u0014\u0010K\u001a\u00020\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00020L0-J\u000e\u0010K\u001a\u00020\u00002\u0006\u0010K\u001a\u00020LJ\u0010\u0010M\u001a\u00020\u00002\b\u0010=\u001a\u0004\u0018\u00010>J\u0010\u0010M\u001a\u00020\u00002\b\b\u0001\u0010?\u001a\u00020)J\u000e\u0010N\u001a\u00020\u00002\u0006\u0010N\u001a\u00020OJ\u000e\u0010P\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010Q\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u000e\u0010R\u001a\u00020\u00002\u0006\u00108\u001a\u000209J\u0010\u0010S\u001a\u00020\u00002\u0006\u0010S\u001a\u00020TH\u0007J\u000e\u0010U\u001a\u00020\u00002\u0006\u0010C\u001a\u00020VR\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcoil/ImageLoader$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "imageLoader", "Lcoil/RealImageLoader;", "(Lcoil/RealImageLoader;)V", "applicationContext", "callFactory", "Lkotlin/Lazy;", "Lokhttp3/Call$Factory;", "componentRegistry", "Lcoil/ComponentRegistry;", "defaults", "Lcoil/request/DefaultRequestOptions;", "diskCache", "Lcoil/disk/DiskCache;", "eventListenerFactory", "Lcoil/EventListener$Factory;", "logger", "Lcoil/util/Logger;", "memoryCache", "Lcoil/memory/MemoryCache;", "options", "Lcoil/util/ImageLoaderOptions;", "addLastModifiedToFileCacheKey", "enable", "", "allowHardware", "allowRgb565", "availableMemoryPercentage", PowerUsageDetail.EXTRA_PERCENT, "", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "bitmapFactoryExifOrientationPolicy", "policy", "Lcoil/decode/ExifOrientationPolicy;", "bitmapFactoryMaxParallelism", "maxParallelism", "", IndexDatabaseHelper.MetaColumns.BUILD, "Lcoil/ImageLoader;", "initializer", "Lkotlin/Function0;", "registry", "builder", "Lkotlin/Function1;", "Lcoil/ComponentRegistry$Builder;", "", "Lkotlin/ExtensionFunctionType;", "components", "crossfade", "durationMillis", "decoderDispatcher", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "diskCachePolicy", "Lcoil/request/CachePolicy;", "error", "drawable", "Landroid/graphics/drawable/Drawable;", "drawableResId", "eventListener", "listener", "Lcoil/EventListener;", "factory", "fallback", "fetcherDispatcher", "interceptorDispatcher", "launchInterceptorChainOnMainThread", "memoryCachePolicy", "networkCachePolicy", "networkObserverEnabled", "okHttpClient", "Lokhttp3/OkHttpClient;", "placeholder", "precision", "Lcoil/size/Precision;", "respectCacheHeaders", "trackWeakReferences", "transformationDispatcher", "transition", "Lcoil/transition/Transition;", "transitionFactory", "Lcoil/transition/Transition$Factory;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private final Context applicationContext;
        private Lazy<? extends Call.Factory> callFactory;
        private ComponentRegistry componentRegistry;
        private DefaultRequestOptions defaults;
        private Lazy<? extends DiskCache> diskCache;
        private EventListener.Factory eventListenerFactory;
        private Logger logger;
        private Lazy<? extends MemoryCache> memoryCache;
        private ImageLoaderOptions options;

        public static /* synthetic */ EventListener $r8$lambda$T0qrHuQghTGFfYNbvMWa67kSENs(EventListener r0, ImageRequest r1) {
            return eventListener$lambda$15(r0, r1);
        }

        private static final EventListener eventListener$lambda$15(EventListener r0, ImageRequest r1) {
            return r0;
        }

        public static final /* synthetic */ Context access$getApplicationContext$p(Builder r0) {
            return r0.applicationContext;
        }

        public Builder(Context r10) {
            this.applicationContext = r10.getApplicationContext();
            this.defaults = Requests.getDEFAULT_REQUEST_OPTIONS();
            this.memoryCache = null;
            this.diskCache = null;
            this.callFactory = null;
            this.eventListenerFactory = null;
            this.componentRegistry = null;
            this.options = new ImageLoaderOptions(false, false, false, 0, null, 31, null);
            this.logger = null;
        }

        public Builder(RealImageLoader r2) {
            this.applicationContext = r2.getContext().getApplicationContext();
            this.defaults = r2.getDefaults();
            this.memoryCache = r2.getMemoryCacheLazy();
            this.diskCache = r2.getDiskCacheLazy();
            this.callFactory = r2.getCallFactoryLazy();
            this.eventListenerFactory = r2.getEventListenerFactory();
            this.componentRegistry = r2.getComponentRegistry();
            this.options = r2.getOptions();
            this.logger = r2.getLogger();
        }

        public final Builder okHttpClient(OkHttpClient r1) {
            return callFactory(r1);
        }

        public final Builder okHttpClient(Function0<? extends OkHttpClient> r1) {
            return callFactory(r1);
        }

        public final Builder callFactory(Call.Factory r2) {
            this.callFactory = LazyKt.lazyOf(r2);
            return this;
        }

        public final Builder callFactory(Function0<? extends Call.Factory> r2) {
            this.callFactory = LazyKt.lazy(r2);
            return this;
        }

        public final /* synthetic */ Builder components(Function1<? super ComponentRegistry.Builder, Unit> r2) {
            ComponentRegistry.Builder r0 = new ComponentRegistry.Builder();
            r2.invoke(r0);
            return components(r0.build());
        }

        public final Builder components(ComponentRegistry r2) {
            this.componentRegistry = r2;
            return this;
        }

        public final Builder memoryCache(MemoryCache r2) {
            this.memoryCache = LazyKt.lazyOf(r2);
            return this;
        }

        public final Builder memoryCache(Function0<? extends MemoryCache> r2) {
            this.memoryCache = LazyKt.lazy(r2);
            return this;
        }

        public final Builder diskCache(DiskCache r2) {
            this.diskCache = LazyKt.lazyOf(r2);
            return this;
        }

        public final Builder diskCache(Function0<? extends DiskCache> r2) {
            this.diskCache = LazyKt.lazy(r2);
            return this;
        }

        public final Builder allowHardware(boolean r20) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, null, null, null, null, null, null, null, r20, false, null, null, null, null, null, null, 32639, null);
            return this;
        }

        public final Builder allowRgb565(boolean r20) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, null, null, null, null, null, null, null, false, r20, null, null, null, null, null, null, 32511, null);
            return this;
        }

        public final Builder addLastModifiedToFileCacheKey(boolean r10) {
            this.options = ImageLoaderOptions.copy$default(this.options, r10, false, false, 0, null, 30, null);
            return this;
        }

        public final Builder networkObserverEnabled(boolean r10) {
            this.options = ImageLoaderOptions.copy$default(this.options, false, r10, false, 0, null, 29, null);
            return this;
        }

        public final Builder respectCacheHeaders(boolean r10) {
            this.options = ImageLoaderOptions.copy$default(this.options, false, false, r10, 0, null, 27, null);
            return this;
        }

        public final Builder bitmapFactoryMaxParallelism(int r10) {
            if (r10 <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.options = ImageLoaderOptions.copy$default(this.options, false, false, false, r10, null, 23, null);
            return this;
        L10:
            throw new IllegalArgumentException("maxParallelism must be > 0.".toString());
        L5:
            r0 = false;
            goto L6
        }

        public final Builder bitmapFactoryExifOrientationPolicy(ExifOrientationPolicy r10) {
            this.options = ImageLoaderOptions.copy$default(this.options, false, false, false, 0, r10, 15, null);
            return this;
        }

        public final Builder eventListener(final EventListener r2) {
            return eventListenerFactory(new ImageLoader$Builder$$ExternalSyntheticLambda0(r2));
        }

        public final Builder eventListenerFactory(EventListener.Factory r2) {
            this.eventListenerFactory = r2;
            return this;
        }

        public final Builder crossfade(boolean r1) {
            if (r1 == false) goto L4;
            int r2 = 100;
        L6:
            return crossfade(r2);
        L4:
            r2 = 0;
            goto L6
        }

        public final Builder crossfade(int r5) {
            if (r5 <= 0) goto L5;
            boolean r3 = false;
            CrossfadeTransition.Factory r0 = new CrossfadeTransition.Factory(r5, r3, 2, null);
        L6:
            transitionFactory(r0);
            return this;
        L5:
            r0 = Transition.Factory.NONE;
            goto L6
        }

        public final Builder transitionFactory(Transition.Factory r20) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, null, null, null, null, r20, null, null, false, false, null, null, null, null, null, null, 32751, null);
            return this;
        }

        public final Builder precision(Precision r20) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, null, null, null, null, null, r20, null, false, false, null, null, null, null, null, null, 32735, null);
            return this;
        }

        public final Builder bitmapConfig(Bitmap.Config r20) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, null, null, null, null, null, null, r20, false, false, null, null, null, null, null, null, 32703, null);
            return this;
        }

        public final Builder dispatcher(CoroutineDispatcher r20) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, null, r20, r20, r20, null, null, null, false, false, null, null, null, null, null, null, 32753, null);
            return this;
        }

        public final Builder interceptorDispatcher(CoroutineDispatcher r20) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, r20, null, null, null, null, null, null, false, false, null, null, null, null, null, null, 32766, null);
            return this;
        }

        public final Builder fetcherDispatcher(CoroutineDispatcher r20) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, null, r20, null, null, null, null, null, false, false, null, null, null, null, null, null, 32765, null);
            return this;
        }

        public final Builder decoderDispatcher(CoroutineDispatcher r20) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, null, null, r20, null, null, null, null, false, false, null, null, null, null, null, null, 32763, null);
            return this;
        }

        public final Builder transformationDispatcher(CoroutineDispatcher r20) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, null, null, null, r20, null, null, null, false, false, null, null, null, null, null, null, 32759, null);
            return this;
        }

        public final Builder placeholder(int r2) {
            return placeholder(Contexts.getDrawableCompat(this.applicationContext, r2));
        }

        public final Builder placeholder(Drawable r21) {
            DefaultRequestOptions r2 = this.defaults;
            if (r21 == null) goto L5;
            Drawable r1 = r21.mutate();
        L6:
            this.defaults = DefaultRequestOptions.copy$default(r2, null, null, null, null, null, null, null, false, false, r1, null, null, null, null, null, 32255, null);
            return this;
        L5:
            r1 = null;
            goto L6
        }

        public final Builder error(int r2) {
            return error(Contexts.getDrawableCompat(this.applicationContext, r2));
        }

        public final Builder error(Drawable r21) {
            DefaultRequestOptions r2 = this.defaults;
            if (r21 == null) goto L5;
            Drawable r1 = r21.mutate();
        L6:
            this.defaults = DefaultRequestOptions.copy$default(r2, null, null, null, null, null, null, null, false, false, null, r1, null, null, null, null, 31743, null);
            return this;
        L5:
            r1 = null;
            goto L6
        }

        public final Builder fallback(int r2) {
            return fallback(Contexts.getDrawableCompat(this.applicationContext, r2));
        }

        public final Builder fallback(Drawable r21) {
            DefaultRequestOptions r2 = this.defaults;
            if (r21 == null) goto L5;
            Drawable r1 = r21.mutate();
        L6:
            this.defaults = DefaultRequestOptions.copy$default(r2, null, null, null, null, null, null, null, false, false, null, null, r1, null, null, null, 30719, null);
            return this;
        L5:
            r1 = null;
            goto L6
        }

        public final Builder memoryCachePolicy(CachePolicy r20) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, null, null, null, null, null, null, null, false, false, null, null, null, r20, null, null, 28671, null);
            return this;
        }

        public final Builder diskCachePolicy(CachePolicy r20) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, null, null, null, null, null, null, null, false, false, null, null, null, null, r20, null, 24575, null);
            return this;
        }

        public final Builder networkCachePolicy(CachePolicy r20) {
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, null, null, null, null, null, null, null, false, false, null, null, null, null, null, r20, 16383, null);
            return this;
        }

        public final Builder logger(Logger r2) {
            this.logger = r2;
            return this;
        }

        public final ImageLoader build() {
            Context r1 = this.applicationContext;
            DefaultRequestOptions r2 = this.defaults;
            Lazy<? extends MemoryCache> r0 = this.memoryCache;
            if (r0 != null) goto L5;
            r0 = LazyKt.lazy(new ImageLoader$Builder$build$1(this));
        L5:
            Lazy<? extends MemoryCache> r3 = r0;
            Lazy<? extends DiskCache> r4 = this.diskCache;
            if (r4 != null) goto L8;
            r4 = LazyKt.lazy(new ImageLoader$Builder$build$2(this));
        L8:
            Lazy<? extends DiskCache> r5 = r4;
            Lazy<? extends Call.Factory> r6 = this.callFactory;
            if (r6 != null) goto L11;
            r6 = LazyKt.lazy(ImageLoader$Builder$build$3.INSTANCE);
        L11:
            Lazy<? extends Call.Factory> r7 = r6;
            EventListener.Factory r8 = this.eventListenerFactory;
            if (r8 != null) goto L14;
            r8 = EventListener.Factory.NONE;
        L14:
            EventListener.Factory r9 = r8;
            ComponentRegistry r10 = this.componentRegistry;
            if (r10 != null) goto L18;
            r10 = new ComponentRegistry();
        L18:
            return new RealImageLoader(r1, r2, r3, r5, r7, r9, r10, this.options, this.logger);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to 'memoryCache'.", replaceWith = @ReplaceWith(expression = "memoryCache { MemoryCache.Builder(context).maxSizePercent(percent).build() }", imports = {"coil.memory.MemoryCache"}))
        public final Builder availableMemoryPercentage(double r1) {
            Utils.unsupported();
            throw new KotlinNothingValueException();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to 'memoryCache'.", replaceWith = @ReplaceWith(expression = "memoryCache { MemoryCache.Builder(context).weakReferencesEnabled(enable).build() }", imports = {"coil.memory.MemoryCache"}))
        public final Builder trackWeakReferences(boolean r1) {
            Utils.unsupported();
            throw new KotlinNothingValueException();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to 'interceptorDispatcher'.", replaceWith = @ReplaceWith(expression = "interceptorDispatcher(if (enable) Dispatchers.Main.immediate else Dispatchers.IO)", imports = {"kotlinx.coroutines.Dispatchers"}))
        public final Builder launchInterceptorChainOnMainThread(boolean r1) {
            Utils.unsupported();
            throw new KotlinNothingValueException();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Replace with 'components'.", replaceWith = @ReplaceWith(expression = "components(builder)", imports = {}))
        public final /* synthetic */ Builder componentRegistry(Function1 r1) {
            Utils.unsupported();
            throw new KotlinNothingValueException();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Replace with 'components'.", replaceWith = @ReplaceWith(expression = "components(registry)", imports = {}))
        public final Builder componentRegistry(ComponentRegistry r1) {
            Utils.unsupported();
            throw new KotlinNothingValueException();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to 'transitionFactory'.", replaceWith = @ReplaceWith(expression = "transitionFactory { _, _ -> transition }", imports = {}))
        public final Builder transition(Transition r1) {
            Utils.unsupported();
            throw new KotlinNothingValueException();
        }
    }

    Disposable enqueue(ImageRequest r1);

    Object execute(ImageRequest r1, Continuation<? super ImageResult> r2);

    ComponentRegistry getComponents();

    DefaultRequestOptions getDefaults();

    DiskCache getDiskCache();

    MemoryCache getMemoryCache();

    Builder newBuilder();

    void shutdown();
}
