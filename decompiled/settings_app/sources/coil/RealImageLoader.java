package coil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.lifecycle.Lifecycle;
import coil.decode.BitmapFactoryDecoder;
import coil.decode.DataSource;
import coil.disk.DiskCache;
import coil.fetch.AssetUriFetcher;
import coil.fetch.BitmapFetcher;
import coil.fetch.ByteBufferFetcher;
import coil.fetch.ContentUriFetcher;
import coil.fetch.DrawableFetcher;
import coil.fetch.FileFetcher;
import coil.fetch.HttpUriFetcher;
import coil.fetch.ResourceUriFetcher;
import coil.intercept.EngineInterceptor;
import coil.intercept.Interceptor;
import coil.key.FileKeyer;
import coil.key.UriKeyer;
import coil.map.ByteArrayMapper;
import coil.map.FileUriMapper;
import coil.map.HttpUrlMapper;
import coil.map.ResourceIntMapper;
import coil.map.ResourceUriMapper;
import coil.map.StringMapper;
import coil.memory.MemoryCache;
import coil.request.DefaultRequestOptions;
import coil.request.Disposable;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.NullRequestData;
import coil.request.NullRequestDataException;
import coil.request.OneShotDisposable;
import coil.request.RequestDelegate;
import coil.request.RequestService;
import coil.request.SuccessResult;
import coil.size.Size;
import coil.size.SizeResolver;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.transition.NoneTransition;
import coil.transition.Transition;
import coil.transition.TransitionTarget;
import coil.util.ImageLoaderOptions;
import coil.util.Lifecycles;
import coil.util.Logger;
import coil.util.SystemCallbacks;
import coil.util.Utils;
import com.obric.capabilitykit.common.Ext;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.Call;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: RealImageLoader.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 [2\u00020\u0001:\u0001[Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J\u0019\u0010@\u001a\u00020A2\u0006\u0010>\u001a\u00020?H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010BJ!\u0010C\u001a\u00020A2\u0006\u0010D\u001a\u00020?2\u0006\u0010E\u001a\u00020FH\u0083@ø\u0001\u0000¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u00020IH\u0016J\u0018\u0010J\u001a\u00020K2\u0006\u0010>\u001a\u00020?2\u0006\u0010L\u001a\u00020MH\u0002J\"\u0010N\u001a\u00020K2\u0006\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010L\u001a\u00020MH\u0002J\"\u0010S\u001a\u00020K2\u0006\u0010O\u001a\u00020T2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010L\u001a\u00020MH\u0002J\u0015\u0010U\u001a\u00020K2\u0006\u0010V\u001a\u00020FH\u0000¢\u0006\u0002\bWJ\b\u00108\u001a\u00020KH\u0016J1\u0010X\u001a\u00020K2\u0006\u0010O\u001a\u00020A2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010L\u001a\u00020M2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020K0ZH\u0082\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010 \u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b#\u0010$*\u0004\b!\u0010\"R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001d\u0010-\u001a\u0004\u0018\u00010\b8VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b/\u00100*\u0004\b.\u0010\"R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\\"}, d2 = {"Lcoil/RealImageLoader;", "Lcoil/ImageLoader;", "context", "Landroid/content/Context;", "defaults", "Lcoil/request/DefaultRequestOptions;", "memoryCacheLazy", "Lkotlin/Lazy;", "Lcoil/memory/MemoryCache;", "diskCacheLazy", "Lcoil/disk/DiskCache;", "callFactoryLazy", "Lokhttp3/Call$Factory;", "eventListenerFactory", "Lcoil/EventListener$Factory;", "componentRegistry", "Lcoil/ComponentRegistry;", "options", "Lcoil/util/ImageLoaderOptions;", "logger", "Lcoil/util/Logger;", "(Landroid/content/Context;Lcoil/request/DefaultRequestOptions;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil/EventListener$Factory;Lcoil/ComponentRegistry;Lcoil/util/ImageLoaderOptions;Lcoil/util/Logger;)V", "getCallFactoryLazy", "()Lkotlin/Lazy;", "getComponentRegistry", "()Lcoil/ComponentRegistry;", "components", "getComponents", "getContext", "()Landroid/content/Context;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "diskCache", "getDiskCache$delegate", "(Lcoil/RealImageLoader;)Ljava/lang/Object;", "getDiskCache", "()Lcoil/disk/DiskCache;", "getDiskCacheLazy", "getEventListenerFactory", "()Lcoil/EventListener$Factory;", "interceptors", "", "Lcoil/intercept/Interceptor;", "getLogger", "()Lcoil/util/Logger;", "memoryCache", "getMemoryCache$delegate", "getMemoryCache", "()Lcoil/memory/MemoryCache;", "getMemoryCacheLazy", "getOptions", "()Lcoil/util/ImageLoaderOptions;", "requestService", "Lcoil/request/RequestService;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "shutdown", "Ljava/util/concurrent/atomic/AtomicBoolean;", "systemCallbacks", "Lcoil/util/SystemCallbacks;", "enqueue", "Lcoil/request/Disposable;", Ext.KEY_REQUEST, "Lcoil/request/ImageRequest;", "execute", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeMain", "initialRequest", "type", "", "(Lcoil/request/ImageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newBuilder", "Lcoil/ImageLoader$Builder;", "onCancel", "", "eventListener", "Lcoil/EventListener;", "onError", "result", "Lcoil/request/ErrorResult;", "target", "Lcoil/target/Target;", "onSuccess", "Lcoil/request/SuccessResult;", "onTrimMemory", "level", "onTrimMemory$coil_base_release", "transition", "setDrawable", "Lkotlin/Function0;", "Companion", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RealImageLoader implements ImageLoader {
    public static final Companion Companion = null;
    private static final int REQUEST_TYPE_ENQUEUE = 0;
    private static final int REQUEST_TYPE_EXECUTE = 1;
    private static final String TAG = "RealImageLoader";
    private final Lazy<Call.Factory> callFactoryLazy;
    private final ComponentRegistry componentRegistry;
    private final ComponentRegistry components;
    private final Context context;
    private final DefaultRequestOptions defaults;
    private final Lazy<DiskCache> diskCacheLazy;
    private final EventListener.Factory eventListenerFactory;
    private final List<Interceptor> interceptors;
    private final Logger logger;
    private final Lazy<MemoryCache> memoryCacheLazy;
    private final ImageLoaderOptions options;
    private final RequestService requestService;
    private final CoroutineScope scope;
    private final AtomicBoolean shutdown;
    private final SystemCallbacks systemCallbacks;

    /* JADX INFO: compiled from: RealImageLoader.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcoil/RealImageLoader$Companion;", "", "()V", "REQUEST_TYPE_ENQUEUE", "", "REQUEST_TYPE_EXECUTE", "TAG", "", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: coil.RealImageLoader$execute$2, reason: invalid class name */
    /* JADX INFO: compiled from: RealImageLoader.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcoil/request/ImageResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.RealImageLoader$execute$2", f = "RealImageLoader.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageResult>, Object> {
        final /* synthetic */ ImageRequest $request;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RealImageLoader this$0;

        AnonymousClass2(ImageRequest r1, RealImageLoader r2, Continuation<? super AnonymousClass2> r3) {
            this.$request = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$request, this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super ImageResult> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super ImageResult> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L14:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            Deferred<? extends ImageResult> r11 = BuildersKt.async$default((CoroutineScope) this.L$0, Dispatchers.getMain().getImmediate(), null, new RealImageLoader$execute$2$job$1(this.this$0, this.$request, null), 2, null);
            if ((this.$request.getTarget() instanceof ViewTarget) == false) goto L11;
            Utils.getRequestManager(((ViewTarget) this.$request.getTarget()).getView()).getDisposable(r11);
        L11:
            this.label = 1;
            r10 = r11.await(this);
            if (r10 != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: coil.RealImageLoader$executeMain$1, reason: invalid class name */
    /* JADX INFO: compiled from: RealImageLoader.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.RealImageLoader", f = "RealImageLoader.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2}, l = {166, 178, 182}, m = "executeMain", n = {"this", "requestDelegate", Ext.KEY_REQUEST, "eventListener", "this", "requestDelegate", Ext.KEY_REQUEST, "eventListener", "placeholderBitmap", "this", "requestDelegate", Ext.KEY_REQUEST, "eventListener"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RealImageLoader this$0;

        AnonymousClass1(RealImageLoader r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return RealImageLoader.access$executeMain(this.this$0, null, 0, this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RealImageLoader(Context r2, DefaultRequestOptions r3, Lazy<? extends MemoryCache> r4, Lazy<? extends DiskCache> r5, Lazy<? extends Call.Factory> r6, EventListener.Factory r7, ComponentRegistry r8, ImageLoaderOptions r9, Logger r10) {
        this.context = r2;
        this.defaults = r3;
        this.memoryCacheLazy = r4;
        this.diskCacheLazy = r5;
        this.callFactoryLazy = r6;
        this.eventListenerFactory = r7;
        this.componentRegistry = r8;
        this.options = r9;
        this.logger = r10;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()).plus(new RealImageLoader$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this)));
        SystemCallbacks r11 = new SystemCallbacks(this, r2, r9.getNetworkObserverEnabled());
        this.systemCallbacks = r11;
        RealImageLoader r12 = this;
        RequestService r13 = new RequestService(r12, r11, r10);
        this.requestService = r13;
        this.components = r8.newBuilder().add(new HttpUrlMapper(), HttpUrl.class).add(new StringMapper(), String.class).add(new FileUriMapper(), Uri.class).add(new ResourceUriMapper(), Uri.class).add(new ResourceIntMapper(), Integer.class).add(new ByteArrayMapper(), byte[].class).add(new UriKeyer(), Uri.class).add(new FileKeyer(r9.getAddLastModifiedToFileCacheKey()), File.class).add(new HttpUriFetcher.Factory(r6, r5, r9.getRespectCacheHeaders()), Uri.class).add(new FileFetcher.Factory(), File.class).add(new AssetUriFetcher.Factory(), Uri.class).add(new ContentUriFetcher.Factory(), Uri.class).add(new ResourceUriFetcher.Factory(), Uri.class).add(new DrawableFetcher.Factory(), Drawable.class).add(new BitmapFetcher.Factory(), Bitmap.class).add(new ByteBufferFetcher.Factory(), ByteBuffer.class).add(new BitmapFactoryDecoder.Factory(r9.getBitmapFactoryMaxParallelism(), r9.getBitmapFactoryExifOrientationPolicy())).build();
        this.interceptors = CollectionsKt.plus(getComponents().getInterceptors(), new EngineInterceptor(r12, r13, r10));
        this.shutdown = new AtomicBoolean(false);
        r11.register();
    }

    public static final /* synthetic */ Object access$executeMain(RealImageLoader r0, ImageRequest r1, int r2, Continuation r3) {
        return r0.executeMain(r1, r2, r3);
    }

    public static final /* synthetic */ List access$getInterceptors$p(RealImageLoader r0) {
        return r0.interceptors;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // coil.ImageLoader
    public DefaultRequestOptions getDefaults() {
        return this.defaults;
    }

    public final Lazy<MemoryCache> getMemoryCacheLazy() {
        return this.memoryCacheLazy;
    }

    public final Lazy<DiskCache> getDiskCacheLazy() {
        return this.diskCacheLazy;
    }

    public final Lazy<Call.Factory> getCallFactoryLazy() {
        return this.callFactoryLazy;
    }

    public final EventListener.Factory getEventListenerFactory() {
        return this.eventListenerFactory;
    }

    public final ComponentRegistry getComponentRegistry() {
        return this.componentRegistry;
    }

    public final ImageLoaderOptions getOptions() {
        return this.options;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    private static Object getMemoryCache$delegate(RealImageLoader r0) {
        return r0.memoryCacheLazy;
    }

    @Override // coil.ImageLoader
    public MemoryCache getMemoryCache() {
        return this.memoryCacheLazy.getValue();
    }

    private static Object getDiskCache$delegate(RealImageLoader r0) {
        return r0.diskCacheLazy;
    }

    @Override // coil.ImageLoader
    public DiskCache getDiskCache() {
        return this.diskCacheLazy.getValue();
    }

    @Override // coil.ImageLoader
    public ComponentRegistry getComponents() {
        return this.components;
    }

    @Override // coil.ImageLoader
    public Disposable enqueue(ImageRequest r7) {
        Deferred<? extends ImageResult> r6 = BuildersKt.async$default(this.scope, null, null, new RealImageLoader$enqueue$job$1(this, r7, null), 3, null);
        if ((r7.getTarget() instanceof ViewTarget) == false) goto L6;
        return Utils.getRequestManager(((ViewTarget) r7.getTarget()).getView()).getDisposable(r6);
    L6:
        return new OneShotDisposable(r6);
    }

    @Override // coil.ImageLoader
    public Object execute(ImageRequest r3, Continuation<? super ImageResult> r4) {
        return CoroutineScopeKt.coroutineScope(new AnonymousClass2(r3, this, null), r4);
    }

    private final Object executeMain(ImageRequest r20, int r21, Continuation<? super ImageResult> r22) {
        RealImageLoader r1 = this;
        if ((r22 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r3 = (AnonymousClass1) r22;
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L30;
        if (r5 == 1) goto L25;
        if (r5 == 2) goto L20;
        if (r5 != 3) goto L19;
        EventListener r6 = (EventListener) r3.L$3;
        ImageRequest r7 = (ImageRequest) r3.L$2;
        RequestDelegate r8 = (RequestDelegate) r3.L$1;
        RealImageLoader r9 = (RealImageLoader) r3.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L16
        EventListener r10 = r6;
        r1 = r9;
    L100:
        ImageResult r11 = (ImageResult) r2;     // Catch: Throwable -> L74
        if ((r11 instanceof SuccessResult) == false) goto L70;
        r1.onSuccess((SuccessResult) r11, r7.getTarget(), r10);     // Catch: Throwable -> L74
    L72:
        r8.complete();
        return r11;
    L70:
        if ((r11 instanceof ErrorResult) == false) goto L72;
        r1.onError((ErrorResult) r11, r7.getTarget(), r10);     // Catch: Throwable -> L74
    L74:
        th = th;
    L94:
    L89:
        th = move-exception;
        r8.complete();
        throw th;
    L83:
        if ((th instanceof CancellationException) == true) goto L87;
        ErrorResult r0 = r1.requestService.errorResult(r7, th);     // Catch: Throwable -> L89
        r1.onError(r0, r7.getTarget(), r10);     // Catch: Throwable -> L89
        r8.complete();
        return r0;
    L87:
        r1.onCancel(r7, r10);     // Catch: Throwable -> L89
        throw th;     // Catch: Throwable -> L89
    L16:
        th = th;
        r10 = r6;
        r1 = r9;
        goto L94
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        Bitmap r12 = (Bitmap) r3.L$4;
        EventListener r13 = (EventListener) r3.L$3;
        ImageRequest r14 = (ImageRequest) r3.L$2;
        RequestDelegate r15 = (RequestDelegate) r3.L$1;
        RealImageLoader r16 = (RealImageLoader) r3.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L23
        Bitmap r17 = r12;
        r10 = r13;
        r1 = r16;
    L92:
        Size r18 = (Size) r2;     // Catch: Throwable -> L76
        r10.resolveSizeEnd(r14, r18);     // Catch: Throwable -> L76
        CoroutineDispatcher r19 = r14.getInterceptorDispatcher();     // Catch: Throwable -> L76
        RealImageLoader$executeMain$result$1 r23 = new RealImageLoader$executeMain$result$1(r14, r1, r18, r10, r17, null);     // Catch: Throwable -> L76
        r3.L$0 = r1;     // Catch: Throwable -> L76
        r3.L$1 = r15;     // Catch: Throwable -> L76
        r3.L$2 = r14;     // Catch: Throwable -> L76
        r3.L$3 = r10;     // Catch: Throwable -> L76
        r3.L$4 = null;     // Catch: Throwable -> L76
        r3.label = 3;     // Catch: Throwable -> L76
        r2 = BuildersKt.withContext(r19, r23, r3);     // Catch: Throwable -> L76
        if (r2 != r4) goto L65;
        return r4;
    L65:
        r7 = r14;
        r8 = r15;
    L76:
        th = th;
        r7 = r14;
        r8 = r15;
    L23:
        th = th;
        r10 = r13;
        r7 = r14;
        r8 = r15;
        r1 = r16;
        goto L94
    L25:
        EventListener r24 = (EventListener) r3.L$3;
        ImageRequest r25 = (ImageRequest) r3.L$2;
        RequestDelegate r26 = (RequestDelegate) r3.L$1;
        RealImageLoader r110 = (RealImageLoader) r3.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L28
        r10 = r24;
        r1 = r110;
    L39:
        ImageRequest r27 = r25;
        r8 = r26;
    L40:
        MemoryCache r28 = r1.getMemoryCache();     // Catch: Throwable -> L80
        if (r28 == null) goto L48;
        MemoryCache.Key r29 = r27.getPlaceholderMemoryCacheKey();     // Catch: Throwable -> L80
        if (r29 == null) goto L45;
        MemoryCache.Value r30 = r28.get(r29);     // Catch: Throwable -> L80
    L46:
        if (r30 == null) goto L48;
        Bitmap r31 = r30.getBitmap();     // Catch: Throwable -> L80
    L49:
        if (r31 == null) goto L51;
        BitmapDrawable r111 = new BitmapDrawable(r27.getContext().getResources(), r31);     // Catch: Throwable -> L80
    L52:
        Target r32 = r27.getTarget();     // Catch: Throwable -> L80
        if (r32 == null) goto L55;
        r32.onStart(r111);     // Catch: Throwable -> L80
    L55:
        r10.onStart(r27);     // Catch: Throwable -> L80
        ImageRequest.Listener r33 = r27.getListener();     // Catch: Throwable -> L80
        if (r33 == null) goto L58;
        r33.onStart(r27);     // Catch: Throwable -> L80
    L58:
        r10.resolveSizeStart(r27);     // Catch: Throwable -> L80
        SizeResolver r34 = r27.getSizeResolver();     // Catch: Throwable -> L80
        r3.L$0 = r1;     // Catch: Throwable -> L80
        r3.L$1 = r8;     // Catch: Throwable -> L80
        r3.L$2 = r27;     // Catch: Throwable -> L80
        r3.L$3 = r10;     // Catch: Throwable -> L80
        r3.L$4 = r31;     // Catch: Throwable -> L80
        r3.label = 2;     // Catch: Throwable -> L80
        Object r35 = r34.size(r3);     // Catch: Throwable -> L80
        if (r35 != r4) goto L61;
        return r4;
    L61:
        r17 = r31;
        RequestDelegate r112 = r8;
        r14 = r27;
        r2 = r35;
        r15 = r112;
        goto L92
    L51:
        r111 = r27.getPlaceholder();     // Catch: Throwable -> L80
        goto L52
    L45:
        r30 = null;
    L48:
        r31 = null;
    L28:
        th = th;
        r7 = r25;
        r8 = r26;
        r10 = r24;
        r1 = r110;
        goto L94
    L30:
        ResultKt.throwOnFailure(r2);
        r8 = r1.requestService.requestDelegate(r20, JobKt.getJob(r3.getContext()));
        r8.assertActive();
        r27 = ImageRequest.newBuilder$default(r20, null, 1, null).defaults(getDefaults()).build();
        r10 = r1.eventListenerFactory.create(r27);
    L80:
        th = th;
        r7 = r27;
        goto L94
    L32:
        if (r27.getData() == NullRequestData.INSTANCE) goto L79;
        r8.start();     // Catch: Throwable -> L80
        if (r21 != 0) goto L40;
        Lifecycle r36 = r27.getLifecycle();     // Catch: Throwable -> L80
        r3.L$0 = r1;     // Catch: Throwable -> L80
        r3.L$1 = r8;     // Catch: Throwable -> L80
        r3.L$2 = r27;     // Catch: Throwable -> L80
        r3.L$3 = r10;     // Catch: Throwable -> L80
        r3.label = 1;     // Catch: Throwable -> L80
        if (Lifecycles.awaitStarted(r36, r3) != r4) goto L38;
        return r4;
    L38:
        r26 = r8;
        r25 = r27;
        goto L39
    L79:
        throw new NullRequestDataException();     // Catch: Throwable -> L80
    L7:
        r3 = new AnonymousClass1(r1, r22);
        goto L8
    }

    public final void onTrimMemory$coil_base_release(int r1) {
        Lazy<MemoryCache> r0 = this.memoryCacheLazy;
        if (r0 == null) goto L8;
        MemoryCache r2 = r0.getValue();
        if (r2 == null) goto L9;
        r2.trimMemory(r1);
        return;
    L9:
        return;
    }

    @Override // coil.ImageLoader
    public void shutdown() {
        if (this.shutdown.getAndSet(true) == false) goto L5;
        return;
    L5:
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        this.systemCallbacks.shutdown();
        MemoryCache r3 = getMemoryCache();
        if (r3 == null) goto L9;
        r3.clear();
        return;
    }

    @Override // coil.ImageLoader
    public ImageLoader.Builder newBuilder() {
        return new ImageLoader.Builder(this);
    }

    private final void onSuccess(SuccessResult r6, Target r7, EventListener r8) {
        ImageRequest r0 = r6.getRequest();
        DataSource r1 = r6.getDataSource();
        Logger r5 = this.logger;
        if (r5 == null) goto L8;
        if (r5.getLevel() > 4) goto L8;
        r5.log(TAG, 4, Utils.getEmoji(r1) + " Successful (" + r1.name() + ") - " + r0.getData(), null);
    L8:
        if ((r7 instanceof TransitionTarget) == true) goto L11;
        if (r7 != null) goto L13;
    L15:
        r8.onSuccess(r0, r6);
        ImageRequest.Listener r9 = r0.getListener();
        if (r9 == null) goto L19;
        r9.onSuccess(r0, r6);
        return;
    L19:
        return;
    L13:
        r7.onSuccess(r6.getDrawable());
        goto L15
    L11:
        SuccessResult r10 = r6;
        Transition r2 = r10.getRequest().getTransitionFactory().create((TransitionTarget) r7, r10);
        if ((r2 instanceof NoneTransition) == true) goto L13;
        r8.transitionStart(r10.getRequest(), r2);
        r2.transition();
        r8.transitionEnd(r10.getRequest(), r2);
        goto L15
    }

    private final void onError(ErrorResult r6, Target r7, EventListener r8) {
        ImageRequest r0 = r6.getRequest();
        Logger r5 = this.logger;
        if (r5 == null) goto L8;
        if (r5.getLevel() > 4) goto L8;
        r5.log(TAG, 4, "🚨 Failed - " + r0.getData() + " - " + r6.getThrowable(), null);
    L8:
        if ((r7 instanceof TransitionTarget) == true) goto L11;
        if (r7 != null) goto L13;
    L15:
        r8.onError(r0, r6);
        ImageRequest.Listener r9 = r0.getListener();
        if (r9 == null) goto L19;
        r9.onError(r0, r6);
        return;
    L19:
        return;
    L13:
        r7.onError(r6.getDrawable());
        goto L15
    L11:
        ErrorResult r10 = r6;
        Transition r1 = r10.getRequest().getTransitionFactory().create((TransitionTarget) r7, r10);
        if ((r1 instanceof NoneTransition) == true) goto L13;
        r8.transitionStart(r10.getRequest(), r1);
        r1.transition();
        r8.transitionEnd(r10.getRequest(), r1);
        goto L15
    }

    private final void onCancel(ImageRequest r5, EventListener r6) {
        Logger r4 = this.logger;
        if (r4 != null) goto L5;
    L7:
        r6.onCancel(r5);
        ImageRequest.Listener r7 = r5.getListener();
        if (r7 == null) goto L11;
        r7.onCancel(r5);
        return;
    L11:
        return;
    L5:
        if (r4.getLevel() > 4) goto L7;
        r4.log(TAG, 4, "🏗  Cancelled - " + r5.getData(), null);
        goto L7
    }

    private final void transition(ImageResult r1, Target r2, EventListener r3, Function0<Unit> r4) {
        if ((r2 instanceof TransitionTarget) == true) goto L6;
        r4.invoke();
        return;
    L6:
        Transition r0 = r1.getRequest().getTransitionFactory().create((TransitionTarget) r2, r1);
        if ((r0 instanceof NoneTransition) == false) goto L10;
        r4.invoke();
        return;
    L10:
        r3.transitionStart(r1.getRequest(), r0);
        r0.transition();
        r3.transitionEnd(r1.getRequest(), r0);
    }
}
