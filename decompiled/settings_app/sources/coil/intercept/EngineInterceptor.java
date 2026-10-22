package coil.intercept;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.ComponentRegistry;
import coil.EventListener;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.DecodeResult;
import coil.decode.Decoder;
import coil.decode.FileImageSource;
import coil.decode.ImageSource;
import coil.fetch.DrawableResult;
import coil.fetch.FetchResult;
import coil.fetch.Fetcher;
import coil.fetch.SourceResult;
import coil.memory.MemoryCache;
import coil.memory.MemoryCacheService;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.Options;
import coil.request.RequestService;
import coil.request.SuccessResult;
import coil.size.Scale;
import coil.size.Size;
import coil.transform.Transformation;
import coil.util.Bitmaps;
import coil.util.DrawableUtils;
import coil.util.Logger;
import coil.util.Utils;
import com.obric.capabilitykit.common.Ext;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: EngineInterceptor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 02\u00020\u0001:\u000201B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002JA\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010 J1\u0010!\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010#J9\u0010$\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010+J3\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0081@ø\u0001\u0000¢\u0006\u0004\b.\u0010/R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lcoil/intercept/EngineInterceptor;", "Lcoil/intercept/Interceptor;", "imageLoader", "Lcoil/ImageLoader;", "requestService", "Lcoil/request/RequestService;", "logger", "Lcoil/util/Logger;", "(Lcoil/ImageLoader;Lcoil/request/RequestService;Lcoil/util/Logger;)V", "memoryCacheService", "Lcoil/memory/MemoryCacheService;", "convertDrawableToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "options", "Lcoil/request/Options;", "transformations", "", "Lcoil/transform/Transformation;", "decode", "Lcoil/intercept/EngineInterceptor$ExecuteResult;", "fetchResult", "Lcoil/fetch/SourceResult;", "components", "Lcoil/ComponentRegistry;", Ext.KEY_REQUEST, "Lcoil/request/ImageRequest;", "mappedData", "", "eventListener", "Lcoil/EventListener;", "(Lcoil/fetch/SourceResult;Lcoil/ComponentRegistry;Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "_options", "(Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetch", "Lcoil/fetch/FetchResult;", "(Lcoil/ComponentRegistry;Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intercept", "Lcoil/request/ImageResult;", "chain", "Lcoil/intercept/Interceptor$Chain;", "(Lcoil/intercept/Interceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transform", "result", "transform$coil_base_release", "(Lcoil/intercept/EngineInterceptor$ExecuteResult;Lcoil/request/ImageRequest;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ExecuteResult", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EngineInterceptor implements Interceptor {
    public static final Companion Companion = null;
    private static final String TAG = "EngineInterceptor";
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final MemoryCacheService memoryCacheService;
    private final RequestService requestService;

    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/intercept/EngineInterceptor$Companion;", "", "()V", "TAG", "", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcoil/intercept/EngineInterceptor$ExecuteResult;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "isSampled", "", "dataSource", "Lcoil/decode/DataSource;", "diskCacheKey", "", "(Landroid/graphics/drawable/Drawable;ZLcoil/decode/DataSource;Ljava/lang/String;)V", "getDataSource", "()Lcoil/decode/DataSource;", "getDiskCacheKey", "()Ljava/lang/String;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "()Z", "copy", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ExecuteResult {
        private final DataSource dataSource;
        private final String diskCacheKey;
        private final Drawable drawable;
        private final boolean isSampled;

        public ExecuteResult(Drawable r1, boolean r2, DataSource r3, String r4) {
            this.drawable = r1;
            this.isSampled = r2;
            this.dataSource = r3;
            this.diskCacheKey = r4;
        }

        public final Drawable getDrawable() {
            return this.drawable;
        }

        public final boolean isSampled() {
            return this.isSampled;
        }

        public final DataSource getDataSource() {
            return this.dataSource;
        }

        public final String getDiskCacheKey() {
            return this.diskCacheKey;
        }

        public static /* synthetic */ ExecuteResult copy$default(ExecuteResult r0, Drawable r1, boolean r2, DataSource r3, String r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.drawable;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.isSampled;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.dataSource;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.diskCacheKey;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final ExecuteResult copy(Drawable r1, boolean r2, DataSource r3, String r4) {
            return new ExecuteResult(r1, r2, r3, r4);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$decode$1, reason: invalid class name */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {199}, m = "decode", n = {"this", "fetchResult", "components", Ext.KEY_REQUEST, "mappedData", "options", "eventListener", "decoder", "searchIndex"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EngineInterceptor this$0;

        AnonymousClass1(EngineInterceptor r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            this.result = r9;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.access$decode(this.this$0, null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$execute$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {122, 126, 144}, m = "execute", n = {"this", Ext.KEY_REQUEST, "mappedData", "eventListener", "options", "components", "fetchResult", "this", Ext.KEY_REQUEST, "eventListener", "options", "fetchResult"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C01381 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EngineInterceptor this$0;

        C01381(EngineInterceptor r1, Continuation<? super C01381> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.access$execute(this.this$0, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$fetch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {165}, m = "fetch", n = {"this", "components", Ext.KEY_REQUEST, "mappedData", "options", "eventListener", "fetcher", "searchIndex"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"})
    static final class C01391 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EngineInterceptor this$0;

        C01391(EngineInterceptor r1, Continuation<? super C01391> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.access$fetch(this.this$0, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$intercept$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", i = {0, 0}, l = {73}, m = "intercept", n = {"this", "chain"}, s = {"L$0", "L$1"})
    static final class C01401 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EngineInterceptor this$0;

        C01401(EngineInterceptor r1, Continuation<? super C01401> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.intercept(null, this);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$intercept$2, reason: invalid class name */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcoil/request/SuccessResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.intercept.EngineInterceptor$intercept$2", f = "EngineInterceptor.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SuccessResult>, Object> {
        final /* synthetic */ MemoryCache.Key $cacheKey;
        final /* synthetic */ Interceptor.Chain $chain;
        final /* synthetic */ EventListener $eventListener;
        final /* synthetic */ Object $mappedData;
        final /* synthetic */ Options $options;
        final /* synthetic */ ImageRequest $request;
        int label;
        final /* synthetic */ EngineInterceptor this$0;

        AnonymousClass2(EngineInterceptor r1, ImageRequest r2, Object r3, Options r4, EventListener r5, MemoryCache.Key r6, Interceptor.Chain r7, Continuation<? super AnonymousClass2> r8) {
            this.this$0 = r1;
            this.$request = r2;
            this.$mappedData = r3;
            this.$options = r4;
            this.$eventListener = r5;
            this.$cacheKey = r6;
            this.$chain = r7;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass2(this.this$0, this.$request, this.$mappedData, this.$options, this.$eventListener, this.$cacheKey, this.$chain, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super SuccessResult> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super SuccessResult> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            ExecuteResult r11 = (ExecuteResult) r10;
            boolean r2 = EngineInterceptor.access$getMemoryCacheService$p(this.this$0).setCacheValue(this.$cacheKey, this.$request, r11);
            Drawable r3 = r11.getDrawable();
            ImageRequest r4 = this.$request;
            DataSource r5 = r11.getDataSource();
            MemoryCache.Key r6 = this.$cacheKey;
            if (r2 == false) goto L14;
            MemoryCache.Key r7 = r6;
        L16:
            return new SuccessResult(r3, r4, r5, r7, r11.getDiskCacheKey(), r11.isSampled(), Utils.isPlaceholderCached(this.$chain));
        L14:
            r7 = null;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            this.label = 1;
            r10 = EngineInterceptor.access$execute(this.this$0, this.$request, this.$mappedData, this.$options, this.$eventListener, this);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public EngineInterceptor(ImageLoader r2, RequestService r3, Logger r4) {
        this.imageLoader = r2;
        this.requestService = r3;
        this.logger = r4;
        this.memoryCacheService = new MemoryCacheService(r2, r3, r4);
    }

    public static final /* synthetic */ Bitmap access$convertDrawableToBitmap(EngineInterceptor r0, Drawable r1, Options r2, List r3) {
        return r0.convertDrawableToBitmap(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$decode(EngineInterceptor r0, SourceResult r1, ComponentRegistry r2, ImageRequest r3, Object r4, Options r5, EventListener r6, Continuation r7) {
        return r0.decode(r1, r2, r3, r4, r5, r6, r7);
    }

    public static final /* synthetic */ Object access$execute(EngineInterceptor r0, ImageRequest r1, Object r2, Options r3, EventListener r4, Continuation r5) {
        return r0.execute(r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ Object access$fetch(EngineInterceptor r0, ComponentRegistry r1, ImageRequest r2, Object r3, Options r4, EventListener r5, Continuation r6) {
        return r0.fetch(r1, r2, r3, r4, r5, r6);
    }

    public static final /* synthetic */ MemoryCacheService access$getMemoryCacheService$p(EngineInterceptor r0) {
        return r0.memoryCacheService;
    }

    @Override // coil.intercept.Interceptor
    public Object intercept(Interceptor.Chain r14, Continuation<? super ImageResult> r15) {
        if ((r15 instanceof C01401) == false) goto L7;
        C01401 r0 = (C01401) r15;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 != 1) goto L15;
        Interceptor.Chain r17 = (Interceptor.Chain) r0.L$1;
        EngineInterceptor r13 = (EngineInterceptor) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L28
    L27:
        return r16;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r16);
        ImageRequest r6 = r14.getRequest();     // Catch: Throwable -> L28
        Object r18 = r6.getData();     // Catch: Throwable -> L28
        Size r3 = r14.getSize();     // Catch: Throwable -> L28
        EventListener r9 = Utils.getEventListener(r14);     // Catch: Throwable -> L28
        Options r8 = this.requestService.options(r6, r3);     // Catch: Throwable -> L28
        Scale r4 = r8.getScale();     // Catch: Throwable -> L28
        r9.mapStart(r6, r18);     // Catch: Throwable -> L28
        Object r7 = this.imageLoader.getComponents().map(r18, r8);     // Catch: Throwable -> L28
        r9.mapEnd(r6, r7);     // Catch: Throwable -> L28
        MemoryCache.Key r10 = this.memoryCacheService.newCacheKey(r6, r7, r8, r9);     // Catch: Throwable -> L28
        if (r10 == null) goto L20;
        MemoryCache.Value r19 = this.memoryCacheService.getCacheValue(r6, r10, r3, r4);     // Catch: Throwable -> L28
    L21:
        if (r19 != null) goto L23;
        CoroutineDispatcher r110 = r6.getFetcherDispatcher();     // Catch: Throwable -> L28
        AnonymousClass2 r5 = new AnonymousClass2(this, r6, r7, r8, r9, r10, r14, null);     // Catch: Throwable -> L28
        r0.L$0 = this;     // Catch: Throwable -> L28
        r0.L$1 = r14;     // Catch: Throwable -> L28
        r0.label = 1;     // Catch: Throwable -> L28
        r16 = BuildersKt.withContext(r110, r5, r0);     // Catch: Throwable -> L28
        if (r16 != r1) goto L27;
        return r1;
    L23:
        return this.memoryCacheService.newResult(r14, r6, r10, r19);
    L20:
        r19 = null;
    L28:
        th = move-exception;
        if ((th instanceof CancellationException) == false) goto L32;
        throw th;
    L32:
        return this.requestService.errorResult(r14.getRequest(), th);
    L7:
        r0 = new C01401(this, r15);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14, types: [T, coil.ComponentRegistry] */
    /* JADX WARN: Type inference failed for: r1v21, types: [T, coil.request.Options] */
    /* JADX WARN: Type inference failed for: r1v7, types: [T, coil.ComponentRegistry] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    private final Object execute(ImageRequest r36, Object r37, Options r38, EventListener r39, Continuation<? super ExecuteResult> r40) {
        if ((r40 instanceof C01381) == false) goto L7;
        C01381 r2 = (C01381) r40;
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        C01381 r8 = r2;
        Object r1 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Ref.ObjectRef r3 = r8.label;
        SourceResult r12 = null;
        BitmapDrawable r13 = null;
        if (r3 == 0) goto L24;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r1);
        Object r4 = r1;
    L65:
        ExecuteResult r5 = (ExecuteResult) r4;
        Drawable r0 = r5.getDrawable();
        if ((r0 instanceof BitmapDrawable) == false) goto L68;
        r13 = (BitmapDrawable) r0;
    L68:
        if (r13 == null) goto L72;
        Bitmap r6 = r13.getBitmap();
        if (r6 == null) goto L72;
        r6.prepareToDraw();
    L72:
        return r5;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Ref.ObjectRef r7 = (Ref.ObjectRef) r8.L$4;
        Ref.ObjectRef r10 = (Ref.ObjectRef) r8.L$3;
        EventListener r11 = (EventListener) r8.L$2;
        ImageRequest r14 = (ImageRequest) r8.L$1;
        EngineInterceptor r15 = (EngineInterceptor) r8.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L22
        Object r16 = r1;
    L49:
        ExecuteResult r17 = (ExecuteResult) r16;     // Catch: Throwable -> L22
        EngineInterceptor r18 = r15;
        Ref.ObjectRef r19 = r10;
        ExecuteResult r20 = r17;
    L54:
        T r21 = r7.element;
        if ((r21 instanceof SourceResult) == false) goto L57;
        SourceResult r22 = (SourceResult) r21;
    L58:
        if (r22 == null) goto L62;
        ImageSource r23 = r22.getSource();
        if (r23 == null) goto L62;
        Utils.closeQuietly(r23);
    L62:
        Options r24 = (Options) r19.element;
        r8.L$0 = null;
        r8.L$1 = null;
        r8.L$2 = null;
        r8.L$3 = null;
        r8.L$4 = null;
        r8.L$5 = null;
        r8.L$6 = null;
        r8.L$7 = null;
        r8.label = 3;
        Object r25 = r18.transform$coil_base_release(r20, r14, r24, r11, r8);
        r4 = r25;
        if (r25 != r9) goto L65;
        return r9;
    L57:
        r22 = null;
        goto L58
    L19:
        Ref.ObjectRef r26 = (Ref.ObjectRef) r8.L$7;
        r7 = (Ref.ObjectRef) r8.L$6;
        Ref.ObjectRef r27 = (Ref.ObjectRef) r8.L$5;
        Ref.ObjectRef r28 = (Ref.ObjectRef) r8.L$4;
        EventListener r29 = (EventListener) r8.L$3;
        Object r30 = r8.L$2;
        ImageRequest r31 = (ImageRequest) r8.L$1;
        r18 = (EngineInterceptor) r8.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L22
        Ref.ObjectRef r110 = r27;
        Object r210 = r30;
        T r32 = r1;
    L43:
        r26.element = r32;     // Catch: Throwable -> L22
        FetchResult r33 = (FetchResult) r7.element;     // Catch: Throwable -> L22
        if ((r33 instanceof SourceResult) == false) goto L51;
        CoroutineDispatcher r34 = r31.getDecoderDispatcher();     // Catch: Throwable -> L22
        EngineInterceptor$execute$executeResult$1 r35 = new EngineInterceptor$execute$executeResult$1(r18, r7, r110, r31, r210, r28, r29, null);     // Catch: Throwable -> L22
        r8.L$0 = r18;     // Catch: Throwable -> L22
        r8.L$1 = r31;     // Catch: Throwable -> L22
        r8.L$2 = r29;     // Catch: Throwable -> L22
        r8.L$3 = r28;     // Catch: Throwable -> L22
        r8.L$4 = r7;     // Catch: Throwable -> L22
        r8.L$5 = null;     // Catch: Throwable -> L22
        r8.L$6 = null;     // Catch: Throwable -> L22
        r8.L$7 = null;     // Catch: Throwable -> L22
        r8.label = 2;     // Catch: Throwable -> L22
        Object r41 = BuildersKt.withContext(r34, r35, r8);     // Catch: Throwable -> L22
        if (r41 != r9) goto L48;
        return r9;
    L48:
        r10 = r28;
        r11 = r29;
        r14 = r31;
        r15 = r18;
        r16 = r41;
        goto L49
    L51:
        if ((r33 instanceof DrawableResult) == false) goto L74;
        r20 = new ExecuteResult(((DrawableResult) r7.element).getDrawable(), ((DrawableResult) r7.element).isSampled(), ((DrawableResult) r7.element).getDataSource(), null);     // Catch: Throwable -> L22
        r19 = r28;
        r11 = r29;
        r14 = r31;
        goto L54
    L74:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L22
    L24:
        ResultKt.throwOnFailure(r1);
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        r111.element = r38;
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        r112.element = this.imageLoader.getComponents();
        Ref.ObjectRef r113 = new Ref.ObjectRef();
    L75:
        th = th;
        r3 = r113;
    L77:
        T r42 = r3.element;
        if ((r42 instanceof SourceResult) == false) goto L80;
        r12 = (SourceResult) r42;
    L80:
        if (r12 == null) goto L84;
        ImageSource r43 = r12.getSource();
        if (r43 == null) goto L84;
        Utils.closeQuietly(r43);
    L84:
        throw th;
    L26:
        if (this.requestService.allowHardwareWorkerThread((Options) r111.element) == true) goto L29;
        r111.element = Options.copy$default((Options) r111.element, null, Bitmap.Config.ARGB_8888, null, null, null, false, false, false, null, null, null, null, null, null, null, 32765, null);     // Catch: Throwable -> L75
    L29:
        if (r36.getFetcherFactory() == null) goto L31;
    L32:
        ComponentRegistry.Builder r44 = ((ComponentRegistry) r112.element).newBuilder();     // Catch: Throwable -> L75
        Pair<Fetcher.Factory<?>, Class<?>> r45 = r36.getFetcherFactory();     // Catch: Throwable -> L75
        if (r45 == null) goto L35;
        r44.getFetcherFactories$coil_base_release().add(0, r45);     // Catch: Throwable -> L75
    L35:
        Decoder.Factory r46 = r36.getDecoderFactory();     // Catch: Throwable -> L75
        if (r46 == null) goto L38;
        r44.getDecoderFactories$coil_base_release().add(0, r46);     // Catch: Throwable -> L75
    L38:
        r112.element = r44.build();     // Catch: Throwable -> L75
    L39:
        ComponentRegistry r47 = (ComponentRegistry) r112.element;     // Catch: Throwable -> L75
        Options r48 = (Options) r111.element;     // Catch: Throwable -> L75
        r8.L$0 = this;     // Catch: Throwable -> L75
        r8.L$1 = r36;     // Catch: Throwable -> L75
        r8.L$2 = r37;     // Catch: Throwable -> L75
        r8.L$3 = r39;     // Catch: Throwable -> L75
        r8.L$4 = r111;     // Catch: Throwable -> L75
        r8.L$5 = r112;     // Catch: Throwable -> L75
        r8.L$6 = r113;     // Catch: Throwable -> L75
        r8.L$7 = r113;     // Catch: Throwable -> L75
        r8.label = 1;     // Catch: Throwable -> L75
        Object r49 = fetch(r47, r36, r37, r48, r39, r8);     // Catch: Throwable -> L75
        if (r49 != r9) goto L42;
        return r9;
    L42:
        r31 = r36;
        r210 = r37;
        r29 = r39;
        r28 = r111;
        r110 = r112;
        r7 = r113;
        r18 = this;
        r26 = r7;
        r32 = r49;
        goto L43
    L31:
        if (r36.getDecoderFactory() == null) goto L39;
    L22:
        th = th;
    L7:
        r2 = new C01381(this, r40);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0092 -> B:21:0x009a). Please report as a decompilation issue!!! */
    private final Object fetch(ComponentRegistry r9, ImageRequest r10, Object r11, Options r12, EventListener r13, Continuation<? super FetchResult> r14) {
        if ((r14 instanceof C01391) == false) goto L7;
        C01391 r0 = (C01391) r14;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        int r8 = r0.I$0;
        Fetcher r16 = (Fetcher) r0.L$6;
        EventListener r17 = (EventListener) r0.L$5;
        Options r18 = (Options) r0.L$4;
        Object r19 = r0.L$3;
        ImageRequest r110 = (ImageRequest) r0.L$2;
        ComponentRegistry r3 = (ComponentRegistry) r0.L$1;
        EngineInterceptor r4 = (EngineInterceptor) r0.L$0;
        ResultKt.throwOnFailure(r15);
        C01391 r5 = r0;
        int r6 = r8;
        EngineInterceptor this = r4;
        Object r7 = r1;
        C01391 r20 = r5;
        r13 = r17;
        r10 = r110;
        r12 = r18;
        r11 = r19;
    L21:
        FetchResult r111 = (FetchResult) r15;
        r13.fetchEnd(r10, r16, r12, r111);     // Catch: Throwable -> L26
        if (r111 == null) goto L25;
        return r111;
    L25:
        int r112 = r6;
        r0 = r20;
        r9 = r3;
        r1 = r7;
    L15:
        Pair<Fetcher, Integer> r113 = r9.newFetcher(r11, r12, this.imageLoader, r112);
        if (r113 == null) goto L37;
        Fetcher r21 = r113.getFirst();
        int r114 = r113.getSecond().intValue() + 1;
        r13.fetchStart(r10, r21, r12);
        r0.L$0 = this;
        r0.L$1 = r9;
        r0.L$2 = r10;
        r0.L$3 = r11;
        r0.L$4 = r12;
        r0.L$5 = r13;
        r0.L$6 = r21;
        r0.I$0 = r114;
        r0.label = 1;
        Object r22 = r21.fetch(r0);
        if (r22 != r1) goto L20;
        return r1;
    L20:
        r3 = r9;
        r16 = r21;
        C01391 r23 = r0;
        r6 = r114;
        r15 = r22;
        r7 = r1;
        r20 = r23;
        goto L21
    L37:
        throw new IllegalStateException(("Unable to create a fetcher that supports: " + r11).toString());
    L26:
        th = move-exception;
        if ((r111 instanceof SourceResult) == false) goto L30;
        SourceResult r115 = (SourceResult) r111;
    L31:
        if (r115 == null) goto L35;
        ImageSource r24 = r115.getSource();
        if (r24 == null) goto L35;
        Utils.closeQuietly(r24);
    L35:
        throw th;
    L30:
        r115 = null;
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        r112 = 0;
    L7:
        r0 = new C01391(this, r14);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0098 -> B:21:0x00a0). Please report as a decompilation issue!!! */
    private final Object decode(SourceResult r9, ComponentRegistry r10, ImageRequest r11, Object r12, Options r13, EventListener r14, Continuation<? super ExecuteResult> r15) {
        if ((r15 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r15;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        int r8 = r0.I$0;
        Decoder r17 = (Decoder) r0.L$7;
        EventListener r18 = (EventListener) r0.L$6;
        Options r19 = (Options) r0.L$5;
        r12 = r0.L$4;
        ImageRequest r110 = (ImageRequest) r0.L$3;
        ComponentRegistry r111 = (ComponentRegistry) r0.L$2;
        SourceResult r3 = (SourceResult) r0.L$1;
        EngineInterceptor r4 = (EngineInterceptor) r0.L$0;
        ResultKt.throwOnFailure(r16);
        AnonymousClass1 r5 = r0;
        int r6 = r8;
        EngineInterceptor this = r4;
        Object r7 = r1;
        AnonymousClass1 r20 = r5;
        r14 = r18;
        r10 = r111;
        r13 = r19;
        r11 = r110;
    L21:
        DecodeResult r112 = (DecodeResult) r16;
        r14.decodeEnd(r11, r17, r13, r112);
        if (r112 == null) goto L31;
        Drawable r21 = r112.getDrawable();
        boolean r113 = r112.isSampled();
        DataSource r114 = r3.getDataSource();
        ImageSource r115 = r3.getSource();
        String r116 = null;
        if ((r115 instanceof FileImageSource) == false) goto L26;
        FileImageSource r117 = (FileImageSource) r115;
    L27:
        if (r117 == null) goto L30;
        r116 = r117.getDiskCacheKey$coil_base_release();
    L30:
        return new ExecuteResult(r21, r113, r114, r116);
    L26:
        r117 = null;
        goto L27
    L31:
        int r118 = r6;
        r0 = r20;
        r9 = r3;
        r1 = r7;
    L15:
        Pair<Decoder, Integer> r119 = r10.newDecoder(r9, r13, this.imageLoader, r118);
        if (r119 == null) goto L33;
        Decoder r22 = r119.getFirst();
        int r120 = r119.getSecond().intValue() + 1;
        r14.decodeStart(r11, r22, r13);
        r0.L$0 = this;
        r0.L$1 = r9;
        r0.L$2 = r10;
        r0.L$3 = r11;
        r0.L$4 = r12;
        r0.L$5 = r13;
        r0.L$6 = r14;
        r0.L$7 = r22;
        r0.I$0 = r120;
        r0.label = 1;
        Object r23 = r22.decode(r0);
        if (r23 != r1) goto L20;
        return r1;
    L20:
        r3 = r9;
        r17 = r22;
        AnonymousClass1 r24 = r0;
        r6 = r120;
        r16 = r23;
        r7 = r1;
        r20 = r24;
        goto L21
    L33:
        throw new IllegalStateException(("Unable to create a decoder that supports: " + r12).toString());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        r118 = 0;
    L7:
        r0 = new AnonymousClass1(this, r15);
        goto L8
    }

    public final Object transform$coil_base_release(ExecuteResult r11, ImageRequest r12, Options r13, EventListener r14, Continuation<? super ExecuteResult> r15) {
        List<Transformation> r4 = r12.getTransformations();
        if (r4.isEmpty() == false) goto L6;
        return r11;
    L6:
        if ((r11.getDrawable() instanceof BitmapDrawable) == true) goto L16;
        if (r12.getAllowConversionToBitmap() == true) goto L16;
        Logger r10 = this.logger;
        if (r10 != null) goto L12;
    L14:
        return r11;
    L12:
        if (r10.getLevel() > 4) goto L14;
        r10.log(TAG, 4, "allowConversionToBitmap=false, skipping transformations for type " + r11.getDrawable().getClass().getCanonicalName() + '.', null);
    L16:
        return BuildersKt.withContext(r12.getTransformationDispatcher(), new EngineInterceptor$transform$3(this, r11, r13, r4, r14, r12, null), r15);
    }

    private final Bitmap convertDrawableToBitmap(Drawable r13, Options r14, List<? extends Transformation> r15) {
        if ((r13 instanceof BitmapDrawable) == false) goto L12;
        Bitmap r0 = ((BitmapDrawable) r13).getBitmap();
        Bitmap.Config r6 = Bitmaps.getSafeConfig(r0);
        if (ArraysKt.contains(Utils.getVALID_TRANSFORMATION_CONFIGS(), r6) == false) goto L7;
        return r0;
    L7:
        Logger r12 = this.logger;
        if (r12 == null) goto L18;
        if (r12.getLevel() > 4) goto L18;
        r12.log(TAG, 4, "Converting bitmap with config " + r6 + " to apply transformations: " + r15 + '.', null);
    L18:
        return DrawableUtils.INSTANCE.convertToBitmap(r13, r14.getConfig(), r14.getSize(), r14.getScale(), r14.getAllowInexactSize());
    L12:
        Logger r16 = this.logger;
        if (r16 == null) goto L18;
        if (r16.getLevel() > 4) goto L18;
        r16.log(TAG, 4, "Converting drawable of type " + r13.getClass().getCanonicalName() + " to apply transformations: " + r15 + '.', null);
        goto L18
    }
}
