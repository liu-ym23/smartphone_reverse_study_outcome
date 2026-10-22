package coil.fetch;

import android.net.Uri;
import android.os.NetworkOnMainThreadException;
import android.webkit.MimeTypeMap;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.ImageSource;
import coil.decode.ImageSources;
import coil.disk.DiskCache;
import coil.network.CacheResponse;
import coil.network.CacheStrategy;
import coil.network.HttpException;
import coil.request.Options;
import coil.util.Calls;
import coil.util.Utils;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.obric.capabilitykit.common.Ext;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import obric.time.HttpHeadTimeFetcher;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;

/* JADX INFO: compiled from: HttpUriFetcher.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 02\u00020\u0001:\u000201B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0011\u0010\u001a\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0001¢\u0006\u0002\b J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\n\u0010$\u001a\u0004\u0018\u00010%H\u0002J.\u0010&\u001a\u0004\u0018\u00010%2\b\u0010'\u001a\u0004\u0018\u00010%2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u000e\u0010*\u001a\u0004\u0018\u00010)*\u00020%H\u0002J\f\u0010+\u001a\u00020,*\u00020\u0016H\u0002J\f\u0010-\u001a\u00020.*\u00020%H\u0002J\f\u0010-\u001a\u00020.*\u00020/H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lcoil/fetch/HttpUriFetcher;", "Lcoil/fetch/Fetcher;", "url", "", "options", "Lcoil/request/Options;", "callFactory", "Lkotlin/Lazy;", "Lokhttp3/Call$Factory;", "diskCache", "Lcoil/disk/DiskCache;", "respectCacheHeaders", "", "(Ljava/lang/String;Lcoil/request/Options;Lkotlin/Lazy;Lkotlin/Lazy;Z)V", "diskCacheKey", "getDiskCacheKey", "()Ljava/lang/String;", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "executeNetworkRequest", "Lokhttp3/Response;", Ext.KEY_REQUEST, "Lokhttp3/Request;", "(Lokhttp3/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetch", "Lcoil/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMimeType", "contentType", "Lokhttp3/MediaType;", "getMimeType$coil_base_release", "isCacheable", ApmTrafficStats.TTNET_RESPONSE, "newRequest", "readFromDiskCache", "Lcoil/disk/DiskCache$Snapshot;", "writeToDiskCache", "snapshot", "cacheResponse", "Lcoil/network/CacheResponse;", "toCacheResponse", "toDataSource", "Lcoil/decode/DataSource;", "toImageSource", "Lcoil/decode/ImageSource;", "Lokhttp3/ResponseBody;", "Companion", "Factory", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HttpUriFetcher implements Fetcher {
    private static final CacheControl CACHE_CONTROL_FORCE_NETWORK_NO_CACHE = null;
    private static final CacheControl CACHE_CONTROL_NO_NETWORK_NO_CACHE = null;
    public static final Companion Companion = null;
    private static final String MIME_TYPE_TEXT_PLAIN = "text/plain";
    private final Lazy<Call.Factory> callFactory;
    private final Lazy<DiskCache> diskCache;
    private final Options options;
    private final boolean respectCacheHeaders;
    private final String url;

    /* JADX INFO: compiled from: HttpUriFetcher.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcoil/fetch/HttpUriFetcher$Companion;", "", "()V", "CACHE_CONTROL_FORCE_NETWORK_NO_CACHE", "Lokhttp3/CacheControl;", "CACHE_CONTROL_NO_NETWORK_NO_CACHE", "MIME_TYPE_TEXT_PLAIN", "", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: HttpUriFetcher.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\"\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcoil/fetch/HttpUriFetcher$Factory;", "Lcoil/fetch/Fetcher$Factory;", "Landroid/net/Uri;", "callFactory", "Lkotlin/Lazy;", "Lokhttp3/Call$Factory;", "diskCache", "Lcoil/disk/DiskCache;", "respectCacheHeaders", "", "(Lkotlin/Lazy;Lkotlin/Lazy;Z)V", "create", "Lcoil/fetch/Fetcher;", "data", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "isApplicable", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Factory implements Fetcher.Factory<Uri> {
        private final Lazy<Call.Factory> callFactory;
        private final Lazy<DiskCache> diskCache;
        private final boolean respectCacheHeaders;

        /* JADX WARN: Multi-variable type inference failed */
        public Factory(Lazy<? extends Call.Factory> r1, Lazy<? extends DiskCache> r2, boolean r3) {
            this.callFactory = r1;
            this.diskCache = r2;
            this.respectCacheHeaders = r3;
        }

        @Override // coil.fetch.Fetcher.Factory
        public /* bridge */ /* synthetic */ Fetcher create(Uri r1, Options r2, ImageLoader r3) {
            return create2(r1, r2, r3);
        }

        /* JADX INFO: renamed from: create, reason: avoid collision after fix types in other method */
        public Fetcher create2(Uri r7, Options r8, ImageLoader r9) {
            if (isApplicable(r7) == true) goto L7;
            return null;
        L7:
            return new HttpUriFetcher(r7.toString(), r8, this.callFactory, this.diskCache, this.respectCacheHeaders);
        }

        private final boolean isApplicable(Uri r2) {
            if (Intrinsics.areEqual(r2.getScheme(), "http") == false) goto L5;
        L8:
            return true;
        L5:
            if (Intrinsics.areEqual(r2.getScheme(), HttpHeadTimeFetcher.FETCHER_TYPE) == true) goto L8;
            return false;
        }
    }

    /* JADX INFO: renamed from: coil.fetch.HttpUriFetcher$executeNetworkRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: HttpUriFetcher.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.fetch.HttpUriFetcher", f = "HttpUriFetcher.kt", i = {}, l = {224}, m = "executeNetworkRequest", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ HttpUriFetcher this$0;

        AnonymousClass1(HttpUriFetcher r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return HttpUriFetcher.access$executeNetworkRequest(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: coil.fetch.HttpUriFetcher$fetch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HttpUriFetcher.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.fetch.HttpUriFetcher", f = "HttpUriFetcher.kt", i = {0, 0, 0, 1, 1, 1}, l = {77, 106}, m = "fetch", n = {"this", "snapshot", "cacheStrategy", "this", "snapshot", ApmTrafficStats.TTNET_RESPONSE}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class C01371 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ HttpUriFetcher this$0;

        C01371(HttpUriFetcher r1, Continuation<? super C01371> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.fetch(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpUriFetcher(String r1, Options r2, Lazy<? extends Call.Factory> r3, Lazy<? extends DiskCache> r4, boolean r5) {
        this.url = r1;
        this.options = r2;
        this.callFactory = r3;
        this.diskCache = r4;
        this.respectCacheHeaders = r5;
    }

    public static final /* synthetic */ Object access$executeNetworkRequest(HttpUriFetcher r0, Request r1, Continuation r2) {
        return r0.executeNetworkRequest(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v13 */
    @Override // coil.fetch.Fetcher
    public Object fetch(Continuation<? super FetchResult> r13) {
        if ((r13 instanceof C01371) == false) goto L7;
        C01371 r0 = (C01371) r13;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = r0.label;
        MediaType r7 = null;
        if (r2 == 0) goto L24;
        if (r2 == 1) goto L19;
        if (r2 != 2) goto L18;
        Response r12 = (Response) r0.L$2;
        DiskCache.Snapshot r3 = (DiskCache.Snapshot) r0.L$1;
        HttpUriFetcher r4 = (HttpUriFetcher) r0.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L15
    L66:
        Response r15 = (Response) r14;     // Catch: Exception -> L15
        ResponseBody r16 = Utils.requireBody(r15);     // Catch: Exception -> L69
        return new SourceResult(r4.toImageSource(r16), r4.getMimeType$coil_base_release(r4.url, r16.contentType()), r4.toDataSource(r15));
    L69:
        e = move-exception;
        e = e;
        r12 = r15;
    L85:
        Utils.closeQuietly(r12);     // Catch: Exception -> L78
        throw e;     // Catch: Exception -> L78
    L78:
        e = e;
        r2 = r3;
    L80:
        if (r2 == 0) goto L82;
        Utils.closeQuietly((Closeable) r2);
    L82:
        throw e;
    L15:
        e = e;
        goto L85
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        CacheStrategy r17 = (CacheStrategy) r0.L$2;
        DiskCache.Snapshot r5 = (DiskCache.Snapshot) r0.L$1;
        HttpUriFetcher r6 = (HttpUriFetcher) r0.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L22
        CacheStrategy r18 = r17;
        HttpUriFetcher this = r6;
        Object r8 = r14;
    L50:
        Response r9 = (Response) r8;     // Catch: Exception -> L22
        ResponseBody r10 = Utils.requireBody(r9);     // Catch: Exception -> L22
        DiskCache.Snapshot r19 = this.writeToDiskCache(r5, r18.getNetworkRequest(), r9, r18.getCacheResponse());     // Catch: Exception -> L73
        if (r19 == null) goto L59;
        ImageSource r11 = this.toImageSource(r19);     // Catch: Exception -> L71
        String r20 = this.url;     // Catch: Exception -> L71
        CacheResponse r21 = this.toCacheResponse(r19);     // Catch: Exception -> L71
        if (r21 == null) goto L57;
        r7 = r21.getContentType();     // Catch: Exception -> L71
    L57:
        return new SourceResult(r11, this.getMimeType$coil_base_release(r20, r7), DataSource.NETWORK);
    L59:
        if (r10.contentLength() > 0) goto L61;
        Utils.closeQuietly(r9);     // Catch: Exception -> L71
        Request r22 = this.newRequest();     // Catch: Exception -> L71
        r0.L$0 = this;     // Catch: Exception -> L71
        r0.L$1 = r19;     // Catch: Exception -> L71
        r0.L$2 = r9;     // Catch: Exception -> L71
        r0.label = 2;     // Catch: Exception -> L71
        Object r23 = this.executeNetworkRequest(r22, r0);     // Catch: Exception -> L71
        if (r23 != r1) goto L65;
        return r1;
    L65:
        r3 = r19;
        r14 = r23;
        r4 = this;
        r12 = r9;
        goto L66
    L61:
        return new SourceResult(this.toImageSource(r10), this.getMimeType$coil_base_release(this.url, r10.contentType()), this.toDataSource(r9));
    L71:
        e = move-exception;
        r3 = r19;
        e = e;
    L75:
        r12 = r9;
    L73:
        e = e;
        r3 = r5;
        goto L75
    L24:
        ResultKt.throwOnFailure(r14);
        r5 = readFromDiskCache();
        if (r5 == null) goto L46;
        Long r110 = getFileSystem().metadata(r5.getMetadata()).getSize();     // Catch: Exception -> L22
        if (r110 != null) goto L30;
    L34:
        if (this.respectCacheHeaders == false) goto L41;
        r18 = new CacheStrategy.Factory(newRequest(), toCacheResponse(r5)).compute();     // Catch: Exception -> L22
        if (r18.getNetworkRequest() == null) goto L38;
    L47:
        Request r24 = r18.getNetworkRequest();     // Catch: Exception -> L22
        Intrinsics.checkNotNull(r24);     // Catch: Exception -> L22
        r0.L$0 = this;     // Catch: Exception -> L22
        r0.L$1 = r5;     // Catch: Exception -> L22
        r0.L$2 = r18;     // Catch: Exception -> L22
        r0.label = 1;     // Catch: Exception -> L22
        r8 = executeNetworkRequest(r24, r0);     // Catch: Exception -> L22
        if (r8 != r1) goto L50;
        return r1;
    L38:
        if (r18.getCacheResponse() == null) goto L47;
        return new SourceResult(toImageSource(r5), getMimeType$coil_base_release(this.url, r18.getCacheResponse().getContentType()), DataSource.DISK);
    L41:
        ImageSource r25 = toImageSource(r5);     // Catch: Exception -> L22
        String r26 = this.url;     // Catch: Exception -> L22
        CacheResponse r27 = toCacheResponse(r5);     // Catch: Exception -> L22
        if (r27 == null) goto L45;
        r7 = r27.getContentType();     // Catch: Exception -> L22
    L45:
        return new SourceResult(r25, getMimeType$coil_base_release(r26, r7), DataSource.DISK);
    L30:
        if (r110.longValue() != 0) goto L34;
        return new SourceResult(toImageSource(r5), getMimeType$coil_base_release(this.url, null), DataSource.DISK);
    L46:
        r18 = new CacheStrategy.Factory(newRequest(), null).compute();     // Catch: Exception -> L22
    L22:
        e = e;
    L7:
        r0 = new C01371(this, r13);
        goto L8
    }

    private final DiskCache.Snapshot readFromDiskCache() {
        if (this.options.getDiskCachePolicy().getReadEnabled() == false) goto L8;
        DiskCache r0 = this.diskCache.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.openSnapshot(getDiskCacheKey());
    L8:
        return null;
    }

    private final DiskCache.Snapshot writeToDiskCache(DiskCache.Snapshot r6, Request r7, Response r8, CacheResponse r9) {
        Throwable th = null;
        if (isCacheable(r7, r8) == true) goto L7;
        if (r6 == null) goto L6;
        Utils.closeQuietly(r6);
    L6:
        return null;
    L7:
        if (r6 == null) goto L9;
        DiskCache.Editor r10 = r6.closeAndOpenEditor();
    L94:
        if (r10 != null) goto L83;
        return null;
    L83:
    L74:
        e = move-exception;
        Utils.abortQuietly(r10);     // Catch: Throwable -> L72
        throw e;     // Catch: Throwable -> L72
    L16:
        if (r8.code() != 304) goto L35;
        if (r9 == null) goto L35;
        Response r11 = r8.newBuilder().headers(CacheStrategy.Companion.combineHeaders(r9.getResponseHeaders(), r8.headers())).build();     // Catch: Throwable -> L72 Exception -> L74
        BufferedSink r5 = Okio.buffer(getFileSystem().sink(r10.getMetadata(), false));     // Catch: Throwable -> L72 Exception -> L74
        new CacheResponse(r11).writeTo(r5);     // Catch: Throwable -> L25
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L25
        if (r5 != null) goto L86;
    L32:
        if (th != null) goto L34;
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L72 Exception -> L74
    L67:
        DiskCache.Snapshot r13 = r10.commitAndOpenSnapshot();     // Catch: Throwable -> L72 Exception -> L74
        Utils.closeQuietly(r8);
        return r13;
    L34:
        throw th;     // Catch: Throwable -> L72 Exception -> L74
    L86:
        r5.close();     // Catch: Throwable -> L23
    L23:
        th = th;
    L25:
        th = move-exception;
        if (r5 != null) goto L79;
    L31:
        th = th;
        r12 = null;
        goto L32
    L79:
        r5.close();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);     // Catch: Throwable -> L72 Exception -> L74
    L35:
        BufferedSink r14 = Okio.buffer(getFileSystem().sink(r10.getMetadata(), false));     // Catch: Throwable -> L72 Exception -> L74
        new CacheResponse(r8).writeTo(r14);     // Catch: Throwable -> L43
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L43
        if (r14 != null) goto L84;
    L42:
        Throwable th2 = null;
    L50:
        if (th2 != null) goto L71;
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L72 Exception -> L74
        BufferedSink r16 = Okio.buffer(getFileSystem().sink(r10.getData(), false));     // Catch: Throwable -> L72 Exception -> L74
        ResponseBody r17 = r8.body();     // Catch: Throwable -> L58
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L58
        Long r18 = Long.valueOf(r17.source().readAll(r16));     // Catch: Throwable -> L58
        if (r16 != null) goto L92;
    L65:
        if (th != null) goto L70;
        Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L72 Exception -> L74
        goto L67
    L70:
        throw th;     // Catch: Throwable -> L72 Exception -> L74
    L92:
        r16.close();     // Catch: Throwable -> L56
    L56:
        th = th;
    L58:
        th = move-exception;
        if (r16 != null) goto L81;
    L64:
        th = th;
        r18 = null;
        goto L65
    L81:
        r16.close();     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);     // Catch: Throwable -> L72 Exception -> L74
        goto L64
    L71:
        throw th2;     // Catch: Throwable -> L72 Exception -> L74
    L84:
        r14.close();     // Catch: Throwable -> L40
    L40:
        th2 = th;
    L43:
        th = move-exception;
        if (r14 != null) goto L97;
    L49:
        th2 = th;
        r15 = null;
        goto L50
    L97:
        r14.close();     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);     // Catch: Throwable -> L72 Exception -> L74
    L72:
        th = move-exception;
        Utils.closeQuietly(r8);
        throw th;
    L9:
        DiskCache r19 = this.diskCache.getValue();
        if (r19 == null) goto L12;
        r10 = r19.openEditor(getDiskCacheKey());
        goto L94
    L12:
        r10 = null;
        goto L94
    }

    private final Request newRequest() {
        Request.Builder r0 = new Request.Builder().url(this.url).headers(this.options.getHeaders());
        Iterator<Map.Entry<Class<?>, Object>> r1 = this.options.getTags().asMap().entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<Class<?>, Object> r2 = r1.next();
        Class<?> r3 = r2.getKey();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
        r0.tag(r3, r2.getValue());
        goto L4
    L6:
        boolean r4 = this.options.getDiskCachePolicy().getReadEnabled();
        boolean r5 = this.options.getNetworkCachePolicy().getReadEnabled();
        if (r5 == true) goto L10;
        if (r4 == false) goto L10;
        r0.cacheControl(CacheControl.FORCE_CACHE);
    L20:
        return r0.build();
    L10:
        if (r5 == false) goto L16;
        if (r4 == true) goto L16;
        if (this.options.getDiskCachePolicy().getWriteEnabled() == false) goto L15;
        r0.cacheControl(CacheControl.FORCE_NETWORK);
        goto L20
    L15:
        r0.cacheControl(CACHE_CONTROL_FORCE_NETWORK_NO_CACHE);
    L16:
        if (r5 == true) goto L20;
        if (r4 == true) goto L20;
        r0.cacheControl(CACHE_CONTROL_NO_NETWORK_NO_CACHE);
        goto L20
    }

    private final Object executeNetworkRequest(Request r5, Continuation<? super Response> r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L24:
        Response r4 = (Response) r7;
    L26:
        if (r4.isSuccessful() == false) goto L28;
    L34:
        return r4;
    L28:
        if (r4.code() == 304) goto L34;
        ResponseBody r8 = r4.body();
        if (r8 == null) goto L33;
        Utils.closeQuietly(r8);
    L33:
        throw new HttpException(r4);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        if (Utils.isMainThread() == true) goto L17;
        Call r9 = this.callFactory.getValue().newCall(r5);
        r0.label = 1;
        r7 = Calls.await(r9, r0);
        if (r7 != r1) goto L24;
        return r1;
    L17:
        if (this.options.getNetworkCachePolicy().getReadEnabled() == true) goto L20;
        r4 = this.callFactory.getValue().newCall(r5).execute();
        goto L26
    L20:
        throw new NetworkOnMainThreadException();
    L7:
        r0 = new AnonymousClass1(this, r6);
        goto L8
    }

    public final String getMimeType$coil_base_release(String r4, MediaType r5) {
        if (r5 == null) goto L5;
        String r6 = r5.toString();
    L7:
        if (r6 != null) goto L9;
    L10:
        String r7 = Utils.getMimeTypeFromUrl(MimeTypeMap.getSingleton(), r4);
        if (r7 == null) goto L13;
        return r7;
    L13:
        if (r6 != null) goto L15;
        return null;
    L15:
        return StringsKt.substringBefore$default(r6, ';', null, 2, null);
    L9:
        if (StringsKt.startsWith$default(r6, "text/plain", false, 2, null) == false) goto L13;
    L5:
        r6 = null;
        goto L7
    }

    private final boolean isCacheable(Request r2, Response r3) {
        if (this.options.getDiskCachePolicy().getWriteEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.respectCacheHeaders == true) goto L7;
    L8:
        return true;
    L7:
        if (CacheStrategy.Companion.isCacheable(r2, r3) == false) goto L9;
        goto L8
    }

    private final CacheResponse toCacheResponse(DiskCache.Snapshot r3) {
        BufferedSource r2 = Okio.buffer(getFileSystem().source(r3.getMetadata()));     // Catch: IOException -> L22
        CacheResponse r1 = new CacheResponse(r2);     // Catch: Throwable -> L11
        if (r2 != null) goto L24;
    L10:
        Throwable th = null;
    L18:
        if (th != null) goto L21;
        Intrinsics.checkNotNull(r1);     // Catch: IOException -> L22
        return r1;
    L21:
        throw th;     // Catch: IOException -> L22
    L24:
        r2.close();     // Catch: Throwable -> L8
    L8:
        th = th;
        goto L18
    L11:
        th = move-exception;
        if (r2 != null) goto L28;
    L17:
        th = th;
        r1 = null;
        goto L18
    L28:
        r2.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);     // Catch: IOException -> L22
    L22:
        return null;
    }

    private final ImageSource toImageSource(DiskCache.Snapshot r3) {
        return ImageSources.create(r3.getData(), getFileSystem(), getDiskCacheKey(), r3);
    }

    private final ImageSource toImageSource(ResponseBody r1) {
        return ImageSources.create(r1.source(), this.options.getContext());
    }

    private final DataSource toDataSource(Response r1) {
        if (r1.networkResponse() == null) goto L6;
        return DataSource.NETWORK;
    L6:
        return DataSource.DISK;
    }

    private final String getDiskCacheKey() {
        String r0 = this.options.getDiskCacheKey();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.url;
    }

    private final FileSystem getFileSystem() {
        DiskCache r0 = this.diskCache.getValue();
        Intrinsics.checkNotNull(r0);
        return r0.getFileSystem();
    }

    static {
        Companion = new Companion(null);
        CACHE_CONTROL_FORCE_NETWORK_NO_CACHE = new CacheControl.Builder().noCache().noStore().build();
        CACHE_CONTROL_NO_NETWORK_NO_CACHE = new CacheControl.Builder().noCache().onlyIfCached().build();
    }
}
