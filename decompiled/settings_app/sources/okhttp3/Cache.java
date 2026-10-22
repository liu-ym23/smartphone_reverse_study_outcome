package okhttp3;

import com.android.settings.ApnEditor;
import com.android.vcard.VCardConstants;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.obric.capabilitykit.common.Ext;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.text.StringsKt;
import obric.time.HttpHeadTimeFetcher;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: compiled from: Cache.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0004BCDEB\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0018\u00010\"R\u00020\fH\u0002J\b\u0010#\u001a\u00020 H\u0016J\u0006\u0010$\u001a\u00020 J\r\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\b%J\u0006\u0010&\u001a\u00020 J\b\u0010'\u001a\u00020 H\u0016J\u0017\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0000¢\u0006\u0002\b,J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010-\u001a\u00020 J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0011J\u0017\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020)H\u0000¢\u0006\u0002\b1J\u0015\u00102\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0000¢\u0006\u0002\b3J\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u00104\u001a\u00020\u0006J\r\u00105\u001a\u00020 H\u0000¢\u0006\u0002\b6J\u0015\u00107\u001a\u00020 2\u0006\u00108\u001a\u000209H\u0000¢\u0006\u0002\b:J\u001d\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020)H\u0000¢\u0006\u0002\b>J\f\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@J\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u0011R\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u0006F"}, d2 = {"Lokhttp3/Cache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "directory", "Ljava/io/File;", "maxSize", "", "(Ljava/io/File;J)V", "fileSystem", "Lokhttp3/internal/io/FileSystem;", "(Ljava/io/File;JLokhttp3/internal/io/FileSystem;)V", "cache", "Lokhttp3/internal/cache/DiskLruCache;", "getCache$okhttp", "()Lokhttp3/internal/cache/DiskLruCache;", "()Ljava/io/File;", "hitCount", "", "isClosed", "", "()Z", "networkCount", "requestCount", "writeAbortCount", "getWriteAbortCount$okhttp", "()I", "setWriteAbortCount$okhttp", "(I)V", "writeSuccessCount", "getWriteSuccessCount$okhttp", "setWriteSuccessCount$okhttp", "abortQuietly", "", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "close", "delete", "-deprecated_directory", "evictAll", "flush", "get", "Lokhttp3/Response;", Ext.KEY_REQUEST, "Lokhttp3/Request;", "get$okhttp", "initialize", "put", "Lokhttp3/internal/cache/CacheRequest;", ApmTrafficStats.TTNET_RESPONSE, "put$okhttp", "remove", "remove$okhttp", PerfConsts.PERF_DISK_FILE_SIZE, "trackConditionalCacheHit", "trackConditionalCacheHit$okhttp", "trackResponse", "cacheStrategy", "Lokhttp3/internal/cache/CacheStrategy;", "trackResponse$okhttp", "update", "cached", "network", "update$okhttp", "urls", "", "", "CacheResponseBody", "Companion", "Entry", "RealCacheRequest", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Cache implements Closeable, Flushable {
    public static final Companion Companion = null;
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    /* JADX INFO: compiled from: Cache.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0007\u001a\u00020\rH\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lokhttp3/Cache$CacheResponseBody;", "Lokhttp3/ResponseBody;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "contentType", "", "contentLength", "(Lokhttp3/internal/cache/DiskLruCache$Snapshot;Ljava/lang/String;Ljava/lang/String;)V", "bodySource", "Lokio/BufferedSource;", "getSnapshot", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "", "Lokhttp3/MediaType;", "source", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class CacheResponseBody extends ResponseBody {
        private final BufferedSource bodySource;
        private final String contentLength;
        private final String contentType;
        private final DiskLruCache.Snapshot snapshot;

        public final DiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        public CacheResponseBody(DiskLruCache.Snapshot r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "snapshot");
            this.snapshot = r2;
            this.contentType = r3;
            this.contentLength = r4;
            final Source r5 = r2.getSource(1);
            this.bodySource = Okio.buffer(new AnonymousClass1(r5, this));
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            String r1 = this.contentType;
            if (r1 != null) goto L6;
            return null;
        L6:
            return MediaType.Companion.parse(r1);
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            String r2 = this.contentLength;
            if (r2 != null) goto L6;
            return -1;
        L6:
            return Util.toLongOrDefault(r2, -1);
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return this.bodySource;
        }
    }

    /* JADX INFO: compiled from: Cache.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aJ\n\u0010\u001b\u001a\u00020\u0015*\u00020\u0017J\u0012\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u001d*\u00020\u0011H\u0002J\n\u0010\u0010\u001a\u00020\u0011*\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lokhttp3/Cache$Companion;", "", "()V", "ENTRY_BODY", "", "ENTRY_COUNT", "ENTRY_METADATA", VCardConstants.PROPERTY_VERSION, "key", "", "url", "Lokhttp3/HttpUrl;", "readInt", "source", "Lokio/BufferedSource;", "readInt$okhttp", "varyHeaders", "Lokhttp3/Headers;", "requestHeaders", "responseHeaders", "varyMatches", "", "cachedResponse", "Lokhttp3/Response;", "cachedRequest", "newRequest", "Lokhttp3/Request;", "hasVaryAll", "varyFields", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final String key(HttpUrl r1) {
            Intrinsics.checkNotNullParameter(r1, "url");
            return ByteString.Companion.encodeUtf8(r1.toString()).md5().hex();
        }

        public final int readInt$okhttp(BufferedSource r5) throws IOException {
            Intrinsics.checkNotNullParameter(r5, "source");
            long r0 = r5.readDecimalLong();     // Catch: NumberFormatException -> L16
            String r6 = r5.readUtf8LineStrict();     // Catch: NumberFormatException -> L16
            if (r0 < 0) goto L15;
            if (r0 > 2147483647L) goto L15;
            if (r6.length() <= 0) goto L10;
            boolean r2 = true;
        L11:
            if (r2 == true) goto L15;
            return (int) r0;
        L10:
            r2 = false;
        L15:
            throw new IOException("expected an int but was \"" + r0 + r6 + '\"');     // Catch: NumberFormatException -> L16
        L16:
            e = move-exception;
            throw new IOException(e.getMessage());
        }

        public final boolean varyMatches(Response r3, Headers r4, Request r5) {
            Intrinsics.checkNotNullParameter(r3, "cachedResponse");
            Intrinsics.checkNotNullParameter(r4, "cachedRequest");
            Intrinsics.checkNotNullParameter(r5, "newRequest");
            Set<String> r2 = varyFields(r3.headers());
            if ((r2 instanceof Collection) == true) goto L5;
        L7:
            Iterator<T> r6 = r2.iterator();
        L9:
            if (r6.hasNext() == false) goto L18;
            String r7 = (String) r6.next();
            if ((!Intrinsics.areEqual(r4.values(r7), r5.headers(r7))) == false) goto L9;
            return false;
        L18:
            return true;
        L5:
            if (r2.isEmpty() == false) goto L7;
            return true;
        }

        public final boolean hasVaryAll(Response r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            return varyFields(r2.headers()).contains(ApnEditor.APN_TYPE_ALL);
        }

        private final Set<String> varyFields(Headers r14) {
            int r13 = r14.size();
            TreeSet r0 = null;
            int r2 = 0;
        L3:
            if (r2 >= r13) goto L14;
            int r3 = r2 + 1;
            if (StringsKt.equals("Vary", r14.name(r2), true) == false) goto L6;
            String r4 = r14.value(r2);
            if (r0 != null) goto L10;
            r0 = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        L10:
            Iterator r5 = StringsKt.split$default(r4, new char[]{','}, false, 0, 6, null).iterator();
        L12:
            if (r5.hasNext() == false) goto L6;
            r0.add(StringsKt.trim((String) r5.next()).toString());
        L6:
            r2 = r3;
            goto L3
        L14:
            if (r0 == null) goto L16;
            return r0;
        L16:
            return SetsKt.emptySet();
        }

        public final Headers varyHeaders(Response r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            Response r0 = r2.networkResponse();
            Intrinsics.checkNotNull(r0);
            return varyHeaders(r0.request().headers(), r2.headers());
        }

        private final Headers varyHeaders(Headers r6, Headers r7) {
            Set<String> r5 = varyFields(r7);
            if (r5.isEmpty() == true) goto L5;
            Headers.Builder r8 = new Headers.Builder();
            int r0 = r6.size();
            int r1 = 0;
        L7:
            if (r1 >= r0) goto L13;
            int r2 = r1 + 1;
            String r3 = r6.name(r1);
            if (r5.contains(r3) == false) goto L11;
            r8.add(r3, r6.value(r1));
        L11:
            r1 = r2;
            goto L7
        L13:
            return r8.build();
        L5:
            return Util.EMPTY_HEADERS;
        }
    }

    /* JADX INFO: compiled from: Cache.kt */
    @Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\n\u0010$\u001a\u00060%R\u00020&J\u001e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u0012\u0010,\u001a\u00020(2\n\u0010-\u001a\u00060.R\u00020&R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lokhttp3/Cache$Entry;", "", "rawSource", "Lokio/Source;", "(Lokio/Source;)V", ApmTrafficStats.TTNET_RESPONSE, "Lokhttp3/Response;", "(Lokhttp3/Response;)V", AlogMonitor.ALOG_RESULT_CODE, "", "handshake", "Lokhttp3/Handshake;", "isHttps", "", "()Z", "message", "", "protocol", "Lokhttp3/Protocol;", "receivedResponseMillis", "", "requestMethod", "responseHeaders", "Lokhttp3/Headers;", "sentRequestMillis", "url", "Lokhttp3/HttpUrl;", "varyHeaders", "matches", Ext.KEY_REQUEST, "Lokhttp3/Request;", "readCertificateList", "", "Ljava/security/cert/Certificate;", "source", "Lokio/BufferedSource;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "writeCertList", "", "sink", "Lokio/BufferedSink;", "certificates", "writeTo", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Entry {
        public static final Companion Companion = null;
        private static final String RECEIVED_MILLIS = null;
        private static final String SENT_MILLIS = null;
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final HttpUrl url;
        private final Headers varyHeaders;

        /* JADX INFO: compiled from: Cache.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lokhttp3/Cache$Entry$Companion;", "", "()V", "RECEIVED_MILLIS", "", "SENT_MILLIS", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }
        }

        private final boolean isHttps() {
            return Intrinsics.areEqual(this.url.scheme(), HttpHeadTimeFetcher.FETCHER_TYPE);
        }

        public Entry(Source r10) throws IOException {
            Intrinsics.checkNotNullParameter(r10, "rawSource");
            Source r0 = r10;
            Source r1 = r0;     // Catch: Throwable -> L38
            BufferedSource r11 = Okio.buffer(r10);     // Catch: Throwable -> L38
            String r2 = r11.readUtf8LineStrict();     // Catch: Throwable -> L38
            HttpUrl r3 = HttpUrl.Companion.parse(r2);     // Catch: Throwable -> L38
            if (r3 == null) goto L36;
            this.url = r3;     // Catch: Throwable -> L38
            this.requestMethod = r11.readUtf8LineStrict();     // Catch: Throwable -> L38
            Headers.Builder r4 = new Headers.Builder();     // Catch: Throwable -> L38
            int r5 = Cache.Companion.readInt$okhttp(r11);     // Catch: Throwable -> L38
            boolean r6 = false;
            int r7 = 0;
        L6:
            if (r7 >= r5) goto L8;
            r7 = r7 + 1;     // Catch: Throwable -> L38
            r4.addLenient$okhttp(r11.readUtf8LineStrict());     // Catch: Throwable -> L38
            goto L6
        L8:
            this.varyHeaders = r4.build();     // Catch: Throwable -> L38
            StatusLine r8 = StatusLine.Companion.parse(r11.readUtf8LineStrict());     // Catch: Throwable -> L38
            this.protocol = r8.protocol;     // Catch: Throwable -> L38
            this.code = r8.code;     // Catch: Throwable -> L38
            this.message = r8.message;     // Catch: Throwable -> L38
            Headers.Builder r9 = new Headers.Builder();     // Catch: Throwable -> L38
            int r12 = Cache.Companion.readInt$okhttp(r11);     // Catch: Throwable -> L38
            int r13 = 0;
        L9:
            if (r13 >= r12) goto L11;
            r13 = r13 + 1;     // Catch: Throwable -> L38
            r9.addLenient$okhttp(r11.readUtf8LineStrict());     // Catch: Throwable -> L38
            goto L9
        L11:
            String r14 = SENT_MILLIS;     // Catch: Throwable -> L38
            String r15 = r9.get(r14);     // Catch: Throwable -> L38
            String r16 = RECEIVED_MILLIS;     // Catch: Throwable -> L38
            String r17 = r9.get(r16);     // Catch: Throwable -> L38
            r9.removeAll(r14);     // Catch: Throwable -> L38
            r9.removeAll(r16);     // Catch: Throwable -> L38
            long r18 = 0;
            if (r15 != null) goto L14;
            long r19 = 0;
        L15:
            this.sentRequestMillis = r19;     // Catch: Throwable -> L38
            if (r17 == null) goto L19;
            r18 = Long.parseLong(r17);     // Catch: Throwable -> L38
        L19:
            this.receivedResponseMillis = r18;     // Catch: Throwable -> L38
            this.responseHeaders = r9.build();     // Catch: Throwable -> L38
            if (isHttps() == false) goto L32;
            String r20 = r11.readUtf8LineStrict();     // Catch: Throwable -> L38
            if (r20.length() <= 0) goto L24;
            r6 = true;
        L24:
            if (r6 == true) goto L31;
            CipherSuite r21 = CipherSuite.Companion.forJavaName(r11.readUtf8LineStrict());     // Catch: Throwable -> L38
            List<Certificate> r22 = readCertificateList(r11);     // Catch: Throwable -> L38
            List<Certificate> r23 = readCertificateList(r11);     // Catch: Throwable -> L38
            if (r11.exhausted() == true) goto L28;
            TlsVersion r110 = TlsVersion.Companion.forJavaName(r11.readUtf8LineStrict());     // Catch: Throwable -> L38
        L29:
            this.handshake = Handshake.Companion.get(r110, r21, r22, r23);     // Catch: Throwable -> L38
        L33:
            Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L38
            CloseableKt.closeFinally(r0, null);
            return;
        L28:
            r110 = TlsVersion.SSL_3_0;     // Catch: Throwable -> L38
            goto L29
        L31:
            throw new IOException("expected \"\" but was \"" + r20 + '\"');     // Catch: Throwable -> L38
        L32:
            this.handshake = null;     // Catch: Throwable -> L38
            goto L33
        L14:
            r19 = Long.parseLong(r15);     // Catch: Throwable -> L38
            goto L15
        L36:
            IOException r25 = new IOException(Intrinsics.stringPlus("Cache corruption for ", r2));     // Catch: Throwable -> L38
            Platform.Companion.get().log("cache corruption", 5, r25);     // Catch: Throwable -> L38
            throw r25;     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            throw th;     // Catch: Throwable -> L40
        L40:
            th = move-exception;
            CloseableKt.closeFinally(r0, th);
            throw th;
        }

        public Entry(Response r3) {
            Intrinsics.checkNotNullParameter(r3, ApmTrafficStats.TTNET_RESPONSE);
            this.url = r3.request().url();
            this.varyHeaders = Cache.Companion.varyHeaders(r3);
            this.requestMethod = r3.request().method();
            this.protocol = r3.protocol();
            this.code = r3.code();
            this.message = r3.message();
            this.responseHeaders = r3.headers();
            this.handshake = r3.handshake();
            this.sentRequestMillis = r3.sentRequestAtMillis();
            this.receivedResponseMillis = r3.receivedResponseAtMillis();
        }

        public final void writeTo(DiskLruCache.Editor r9) throws IOException {
            Intrinsics.checkNotNullParameter(r9, "editor");
            int r0 = 0;
            BufferedSink r10 = Okio.buffer(r9.newSink(0));
            BufferedSink r1 = r10;     // Catch: Throwable -> L18
            r1.writeUtf8(this.url.toString()).writeByte(10);     // Catch: Throwable -> L18
            r1.writeUtf8(this.requestMethod).writeByte(10);     // Catch: Throwable -> L18
            r1.writeDecimalLong(this.varyHeaders.size()).writeByte(10);     // Catch: Throwable -> L18
            int r2 = this.varyHeaders.size();     // Catch: Throwable -> L18
            int r4 = 0;
        L6:
            if (r4 >= r2) goto L9;
            int r6 = r4 + 1;
            r1.writeUtf8(this.varyHeaders.name(r4)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(r4)).writeByte(10);     // Catch: Throwable -> L18
            r4 = r6;
            goto L6
        L9:
            r1.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);     // Catch: Throwable -> L18
            r1.writeDecimalLong(this.responseHeaders.size() + 2).writeByte(10);     // Catch: Throwable -> L18
            int r3 = this.responseHeaders.size();     // Catch: Throwable -> L18
        L10:
            if (r0 >= r3) goto L12;
            r1.writeUtf8(this.responseHeaders.name(r0)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(r0)).writeByte(10);     // Catch: Throwable -> L18
            r0 = r0 + 1;     // Catch: Throwable -> L18
            goto L10
        L12:
            r1.writeUtf8(SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(10);     // Catch: Throwable -> L18
            r1.writeUtf8(RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(10);     // Catch: Throwable -> L18
            if (isHttps() == false) goto L15;
            r1.writeByte(10);     // Catch: Throwable -> L18
            Handshake r5 = this.handshake;     // Catch: Throwable -> L18
            Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L18
            r1.writeUtf8(r5.cipherSuite().javaName()).writeByte(10);     // Catch: Throwable -> L18
            writeCertList(r1, this.handshake.peerCertificates());     // Catch: Throwable -> L18
            writeCertList(r1, this.handshake.localCertificates());     // Catch: Throwable -> L18
            r1.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(10);     // Catch: Throwable -> L18
        L15:
            Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L18
            CloseableKt.closeFinally(r10, null);
            return;
        L18:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            CloseableKt.closeFinally(r10, th);
            throw th;
        }

        private final List<Certificate> readCertificateList(BufferedSource r7) throws IOException {
            int r6 = Cache.Companion.readInt$okhttp(r7);
            if (r6 == (-1)) goto L5;
            CertificateFactory r0 = CertificateFactory.getInstance("X.509");     // Catch: CertificateException -> L11
            ArrayList r1 = new ArrayList(r6);     // Catch: CertificateException -> L11
            int r2 = 0;
        L7:
            if (r2 >= r6) goto L9;
            r2 = r2 + 1;     // Catch: CertificateException -> L11
            String r3 = r7.readUtf8LineStrict();     // Catch: CertificateException -> L11
            Buffer r4 = new Buffer();     // Catch: CertificateException -> L11
            ByteString r5 = ByteString.Companion.decodeBase64(r3);     // Catch: CertificateException -> L11
            Intrinsics.checkNotNull(r5);     // Catch: CertificateException -> L11
            r4.write(r5);     // Catch: CertificateException -> L11
            r1.add(r0.generateCertificate(r4.inputStream()));     // Catch: CertificateException -> L11
            goto L7
        L9:
            return r1;
        L11:
            e = move-exception;
            throw new IOException(e.getMessage());
        L5:
            return CollectionsKt.emptyList();
        }

        private final void writeCertList(BufferedSink r8, List<? extends Certificate> r9) throws IOException {
            r8.writeDecimalLong(r9.size()).writeByte(10);     // Catch: CertificateEncodingException -> L8
            Iterator<? extends Certificate> r7 = r9.iterator();     // Catch: CertificateEncodingException -> L8
        L4:
            if (r7.hasNext() == false) goto L7;
            byte[] r2 = r7.next().getEncoded();     // Catch: CertificateEncodingException -> L8
            ByteString.Companion r1 = ByteString.Companion;     // Catch: CertificateEncodingException -> L8
            Intrinsics.checkNotNullExpressionValue(r2, "bytes");     // Catch: CertificateEncodingException -> L8
            r8.writeUtf8(ByteString.Companion.of$default(r1, r2, 0, 0, 3, null).base64()).writeByte(10);     // Catch: CertificateEncodingException -> L8
            goto L4
        L7:
            return;
        L8:
            e = move-exception;
            throw new IOException(e.getMessage());
        }

        public final boolean matches(Request r3, Response r4) {
            Intrinsics.checkNotNullParameter(r3, Ext.KEY_REQUEST);
            Intrinsics.checkNotNullParameter(r4, ApmTrafficStats.TTNET_RESPONSE);
            if (Intrinsics.areEqual(this.url, r3.url()) == true) goto L5;
        L9:
            return false;
        L5:
            if (Intrinsics.areEqual(this.requestMethod, r3.method()) == false) goto L9;
            if (Cache.Companion.varyMatches(r4, this.varyHeaders, r3) == false) goto L9;
            return true;
        }

        public final Response response(DiskLruCache.Snapshot r6) {
            Intrinsics.checkNotNullParameter(r6, "snapshot");
            String r0 = this.responseHeaders.get("Content-Type");
            String r1 = this.responseHeaders.get("Content-Length");
            Request r2 = new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build();
            return new Response.Builder().request(r2).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(r6, r0, r1)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        static {
            Companion = new Companion(null);
            SENT_MILLIS = Intrinsics.stringPlus(Platform.Companion.get().getPrefix(), "-Sent-Millis");
            RECEIVED_MILLIS = Intrinsics.stringPlus(Platform.Companion.get().getPrefix(), "-Received-Millis");
        }
    }

    /* JADX INFO: compiled from: Cache.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokhttp3/Cache$RealCacheRequest;", "Lokhttp3/internal/cache/CacheRequest;", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "(Lokhttp3/Cache;Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "body", "Lokio/Sink;", "cacheOut", "done", "", "getDone", "()Z", "setDone", "(Z)V", "abort", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class RealCacheRequest implements CacheRequest {
        private final Sink body;
        private final Sink cacheOut;
        private boolean done;
        private final DiskLruCache.Editor editor;
        final /* synthetic */ Cache this$0;

        public RealCacheRequest(final Cache r2, DiskLruCache.Editor r3) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            Intrinsics.checkNotNullParameter(r3, "editor");
            this.this$0 = r2;
            this.editor = r3;
            final Sink r4 = r3.newSink(1);
            this.cacheOut = r4;
            this.body = new AnonymousClass1(r2, this, r4);
        }

        public static final /* synthetic */ DiskLruCache.Editor access$getEditor$p(RealCacheRequest r0) {
            return r0.editor;
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean r1) {
            this.done = r1;
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            Cache r0 = this.this$0;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (getDone() == false) goto L9;
            monitor-exit(r0);
            return;
        L9:
            setDone(true);     // Catch: Throwable -> L14
            r0.setWriteAbortCount$okhttp(r0.getWriteAbortCount$okhttp() + 1);     // Catch: Throwable -> L14
            monitor-exit(r0);
            Util.closeQuietly(this.cacheOut);
            this.editor.abort();     // Catch: IOException -> L17
            return;
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public Sink body() {
            return this.body;
        }
    }

    /* JADX INFO: renamed from: okhttp3.Cache$urls$1, reason: invalid class name */
    /* JADX INFO: compiled from: Cache.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\t\u001a\u00020\u0004H\u0096\u0002J\t\u0010\n\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0006R\u00020\u00070\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"okhttp3/Cache$urls$1", "", "", "canRemove", "", "delegate", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "nextUrl", "hasNext", "next", "remove", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<String>, KMutableIterator {
        private boolean canRemove;
        private final Iterator<DiskLruCache.Snapshot> delegate;
        private String nextUrl;
        final /* synthetic */ Cache this$0;

        AnonymousClass1(Cache r1) {
            this.this$0 = r1;
            this.delegate = r1.getCache$okhttp().snapshots();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ String next() {
            return next2();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextUrl == null) goto L5;
            return true;
        L5:
            this.canRemove = false;
        L7:
            if (this.delegate.hasNext() == false) goto L18;
            DiskLruCache.Snapshot r2 = this.delegate.next();     // Catch: IOException -> L19
            this.nextUrl = Okio.buffer(r2.getSource(0)).readUtf8LineStrict();     // Catch: Throwable -> L13
            goto L7
        L11:
            CloseableKt.closeFinally(r2, null);     // Catch: IOException -> L19
            return true;
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            CloseableKt.closeFinally(r2, th);     // Catch: IOException -> L19
            throw th;     // Catch: IOException -> L19
        L18:
            return false;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public String next2() {
            if (hasNext() == false) goto L7;
            String r0 = this.nextUrl;
            Intrinsics.checkNotNull(r0);
            this.nextUrl = null;
            this.canRemove = true;
            return r0;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.canRemove == false) goto L7;
            this.delegate.remove();
            return;
        L7:
            throw new IllegalStateException("remove() before next()".toString());
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final String key(HttpUrl r1) {
        return Companion.key(r1);
    }

    public Cache(File r10, long r11, FileSystem r13) {
        Intrinsics.checkNotNullParameter(r10, "directory");
        Intrinsics.checkNotNullParameter(r13, "fileSystem");
        this.cache = new DiskLruCache(r13, r10, VERSION, 2, r11, TaskRunner.INSTANCE);
    }

    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final void setWriteSuccessCount$okhttp(int r1) {
        this.writeSuccessCount = r1;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final void setWriteAbortCount$okhttp(int r1) {
        this.writeAbortCount = r1;
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public Cache(File r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "directory");
        this(r2, r3, FileSystem.SYSTEM);
    }

    public final Response get$okhttp(Request r4) {
        Intrinsics.checkNotNullParameter(r4, Ext.KEY_REQUEST);
        String r0 = Companion.key(r4.url());
        DiskLruCache.Snapshot r3 = this.cache.get(r0);     // Catch: IOException -> L17
        if (r3 != null) goto L20;
        return null;
    L20:
        Entry r1 = new Entry(r3.getSource(0));     // Catch: IOException -> L15
        Response r5 = r1.response(r3);
        if (r1.matches(r4, r5) == true) goto L14;
        ResponseBody r6 = r5.body();
        if (r6 == null) goto L13;
        Util.closeQuietly(r6);
    L13:
        return null;
    L14:
        return r5;
    L15:
        Util.closeQuietly(r3);
    L16:
        return null;
    }

    public final CacheRequest put$okhttp(Response r10) {
        Intrinsics.checkNotNullParameter(r10, ApmTrafficStats.TTNET_RESPONSE);
        String r0 = r10.request().method();
        if (HttpMethod.INSTANCE.invalidatesCache(r10.request().method()) == false) goto L7;
        remove$okhttp(r10.request());     // Catch: IOException -> L22
    L5:
        return null;
    L7:
        if (Intrinsics.areEqual(r0, "GET") == true) goto L9;
        return null;
    L9:
        Companion r1 = Companion;
        if (r1.hasVaryAll(r10) == false) goto L12;
        return null;
    L12:
        Entry r2 = new Entry(r10);
        DiskLruCache.Editor r11 = DiskLruCache.edit$default(this.cache, r1.key(r10.request().url()), 0, 2, null);     // Catch: IOException -> L18
        if (r11 != null) goto L25;
        return null;
    L25:
        r2.writeTo(r11);     // Catch: IOException -> L21
        return new RealCacheRequest(this, r11);
    L19:
        abortQuietly(r11);
        return null;
    L18:
        r11 = null;
        goto L19
    }

    public final void remove$okhttp(Request r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        this.cache.remove(Companion.key(r2.url()));
    }

    public final void update$okhttp(Response r2, Response r3) {
        Intrinsics.checkNotNullParameter(r2, "cached");
        Intrinsics.checkNotNullParameter(r3, "network");
        Entry r0 = new Entry(r3);
        ResponseBody r4 = r2.body();
        if (r4 == null) goto L14;
        DiskLruCache.Editor r5 = ((CacheResponseBody) r4).getSnapshot().edit();     // Catch: IOException -> L10
        if (r5 != null) goto L18;
        return;
    L18:
        r0.writeTo(r5);     // Catch: IOException -> L15
        r5.commit();     // Catch: IOException -> L15
        return;
    L11:
        abortQuietly(r5);
        return;
    L10:
        r5 = null;
        goto L11
    L14:
        throw new NullPointerException("null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
    }

    private final void abortQuietly(DiskLruCache.Editor r1) {
        if (r1 == null) goto L9;
        r1.abort();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    public final Iterator<String> urls() throws IOException {
        return new AnonymousClass1(this);
    }

    public final synchronized int writeAbortCount() {
        monitor-enter(this);
        int r0 = this.writeAbortCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int writeSuccessCount() {
        monitor-enter(this);
        int r0 = this.writeSuccessCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.cache.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cache.close();
    }

    public final File directory() {
        return this.cache.getDirectory();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "directory", imports = {}))
    /* JADX INFO: renamed from: -deprecated_directory, reason: not valid java name */
    public final File m3098deprecated_directory() {
        return this.cache.getDirectory();
    }

    public final synchronized void trackResponse$okhttp(CacheStrategy r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "cacheStrategy");     // Catch: Throwable -> L11
        this.requestCount++;     // Catch: Throwable -> L11
        if (r2.getNetworkRequest() == null) goto L7;
        this.networkCount++;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L7:
        if (r2.getCacheResponse() == null) goto L9;
        this.hitCount++;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        monitor-enter(this);
        this.hitCount++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int networkCount() {
        monitor-enter(this);
        int r0 = this.networkCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int hitCount() {
        monitor-enter(this);
        int r0 = this.hitCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int requestCount() {
        monitor-enter(this);
        int r0 = this.requestCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
