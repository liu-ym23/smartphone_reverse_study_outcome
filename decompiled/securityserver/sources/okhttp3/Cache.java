package okhttp3;

import androidx.appcompat.widget.ActivityChooserView;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.ss.android.http.legacy.protocol.HTTP;
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
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.text.StringsKt;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Cache implements Closeable, Flushable {
    public static final Companion Companion = null;
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;

    @NotNull
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    @Metadata
    public static final class CacheResponseBody extends ResponseBody {
        private final BufferedSource bodySource;
        private final String contentLength;
        private final String contentType;

        @NotNull
        private final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(@NotNull DiskLruCache.Snapshot r2, @Nullable String r3, @Nullable String r4) {
            Intrinsics.f(r2, "snapshot");
            this.snapshot = r2;
            this.contentType = r3;
            this.contentLength = r4;
            final Source r5 = r2.getSource(1);
            this.bodySource = Okio.buffer(new AnonymousClass1(this, r5, r5));
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            String r2 = this.contentLength;
            if (r2 != null) goto L5;
            return -1;
        L5:
            return Util.toLongOrDefault(r2, -1);
        }

        @Override // okhttp3.ResponseBody
        @Nullable
        public MediaType contentType() {
            String r1 = this.contentType;
            if (r1 != null) goto L7;
            return null;
        L7:
            return MediaType.Companion.parse(r1);
        }

        @NotNull
        public final DiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        @Override // okhttp3.ResponseBody
        @NotNull
        public BufferedSource source() {
            return this.bodySource;
        }
    }

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final Set<String> varyFields(Headers r8) {
            int r0 = r8.size();
            TreeSet r1 = null;
            int r3 = 0;
        L3:
            if (r3 >= r0) goto L19;
            if ("Vary".equalsIgnoreCase(r8.name(r3)) == false) goto L18;
            String r4 = r8.value(r3);
            if (r1 != null) goto L10;
            Comparator r5 = String.CASE_INSENSITIVE_ORDER;
            Intrinsics.e(r5, "CASE_INSENSITIVE_ORDER");
            r1 = new TreeSet(r5);
        L10:
            Iterator r6 = StringsKt.C(r4, new char[]{','}).iterator();
        L12:
            if (r6.hasNext() == false) goto L18;
            String r7 = (String) r6.next();
            if (r7 == null) goto L17;
            r1.add(StringsKt.J(r7).toString());
            goto L12
        L17:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        L18:
            r3 = r3 + 1;
            goto L3
        L19:
            if (r1 == null) goto L22;
            return r1;
        L22:
            return EmptySet.b;
        }

        public final boolean hasVaryAll(@NotNull Response r2) {
            Intrinsics.f(r2, "$this$hasVaryAll");
            return varyFields(r2.headers()).contains("*");
        }

        @JvmStatic
        @NotNull
        public final String key(@NotNull HttpUrl r1) {
            Intrinsics.f(r1, "url");
            return ByteString.Companion.encodeUtf8(r1.toString()).md5().hex();
        }

        public final int readInt$okhttp(@NotNull BufferedSource r5) {
            Intrinsics.f(r5, DBHelper.BATTERY_COL_SOURCE);
            long r0 = r5.readDecimalLong();     // Catch: NumberFormatException -> L11
            String r6 = r5.readUtf8LineStrict();     // Catch: NumberFormatException -> L11
            if (r0 < 0) goto L14;
            if (r0 > ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) goto L14;
            if (r6.length() > 0) goto L14;
            return (int) r0;
        L14:
            throw new IOException("expected an int but was \"" + r0 + r6 + '\"');     // Catch: NumberFormatException -> L11
        L11:
            e = move-exception;
            throw new IOException(e.getMessage());
        }

        @NotNull
        public final Headers varyHeaders(@NotNull Response r2) {
            Intrinsics.f(r2, "$this$varyHeaders");
            Response r0 = r2.networkResponse();
            Intrinsics.c(r0);
            return varyHeaders(r0.request().headers(), r2.headers());
        }

        public final boolean varyMatches(@NotNull Response r3, @NotNull Headers r4, @NotNull Request r5) {
            Intrinsics.f(r3, "cachedResponse");
            Intrinsics.f(r4, "cachedRequest");
            Intrinsics.f(r5, "newRequest");
            Set<String> r2 = varyFields(r3.headers());
            if ((r2 instanceof Collection) == true) goto L5;
        L7:
            Iterator<T> r6 = r2.iterator();
        L9:
            if (r6.hasNext() == false) goto L18;
            String r7 = (String) r6.next();
            if ((!Intrinsics.a(r4.values(r7), r5.headers(r7))) == false) goto L9;
            return false;
        L18:
            return true;
        L5:
            if (r2.isEmpty() == false) goto L7;
            return true;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final Headers varyHeaders(Headers r5, Headers r6) {
            Set<String> r4 = varyFields(r6);
            if (r4.isEmpty() == true) goto L5;
            Headers.Builder r7 = new Headers.Builder();
            int r0 = r5.size();
            int r1 = 0;
        L7:
            if (r1 >= r0) goto L13;
            String r2 = r5.name(r1);
            if (r4.contains(r2) == false) goto L11;
            r7.add(r2, r5.value(r1));
        L11:
            r1 = r1 + 1;
            goto L7
        L13:
            return r7.build();
        L5:
            return Util.EMPTY_HEADERS;
        }
    }

    @Metadata
    public static final class Entry {
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
        private final String url;
        private final Headers varyHeaders;

        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
            StringBuilder r0 = new StringBuilder();
            Platform.Companion r1 = Platform.Companion;
            r0.append(r1.get().getPrefix());
            r0.append("-Sent-Millis");
            SENT_MILLIS = r0.toString();
            RECEIVED_MILLIS = r1.get().getPrefix() + "-Received-Millis";
        }

        public Entry(@NotNull Source r9) {
            Intrinsics.f(r9, "rawSource");
            BufferedSource r0 = Okio.buffer(r9);     // Catch: Throwable -> L6
            this.url = r0.readUtf8LineStrict();     // Catch: Throwable -> L6
            this.requestMethod = r0.readUtf8LineStrict();     // Catch: Throwable -> L6
            Headers.Builder r1 = new Headers.Builder();     // Catch: Throwable -> L6
            int r2 = Cache.Companion.readInt$okhttp(r0);     // Catch: Throwable -> L6
            int r3 = 0;
            int r4 = 0;
        L4:
            if (r4 >= r2) goto L8;
            r1.addLenient$okhttp(r0.readUtf8LineStrict());     // Catch: Throwable -> L6
            r4 = r4 + 1;     // Catch: Throwable -> L6
            goto L4
        L8:
            this.varyHeaders = r1.build();     // Catch: Throwable -> L6
            StatusLine r5 = StatusLine.Companion.parse(r0.readUtf8LineStrict());     // Catch: Throwable -> L6
            this.protocol = r5.protocol;     // Catch: Throwable -> L6
            this.code = r5.code;     // Catch: Throwable -> L6
            this.message = r5.message;     // Catch: Throwable -> L6
            Headers.Builder r6 = new Headers.Builder();     // Catch: Throwable -> L6
            int r7 = Cache.Companion.readInt$okhttp(r0);     // Catch: Throwable -> L6
        L9:
            if (r3 >= r7) goto L11;
            r6.addLenient$okhttp(r0.readUtf8LineStrict());     // Catch: Throwable -> L6
            r3 = r3 + 1;     // Catch: Throwable -> L6
            goto L9
        L11:
            String r8 = SENT_MILLIS;     // Catch: Throwable -> L6
            String r10 = r6.get(r8);     // Catch: Throwable -> L6
            String r11 = RECEIVED_MILLIS;     // Catch: Throwable -> L6
            String r12 = r6.get(r11);     // Catch: Throwable -> L6
            r6.removeAll(r8);     // Catch: Throwable -> L6
            r6.removeAll(r11);     // Catch: Throwable -> L6
            long r13 = 0;
            if (r10 == null) goto L14;
            long r14 = Long.parseLong(r10);     // Catch: Throwable -> L6
        L15:
            this.sentRequestMillis = r14;     // Catch: Throwable -> L6
            if (r12 == null) goto L18;
            r13 = Long.parseLong(r12);     // Catch: Throwable -> L6
        L18:
            this.receivedResponseMillis = r13;     // Catch: Throwable -> L6
            this.responseHeaders = r6.build();     // Catch: Throwable -> L6
            if (isHttps() == false) goto L29;
            String r15 = r0.readUtf8LineStrict();     // Catch: Throwable -> L6
            if (r15.length() > 0) goto L28;
            CipherSuite r16 = CipherSuite.Companion.forJavaName(r0.readUtf8LineStrict());     // Catch: Throwable -> L6
            List<Certificate> r17 = readCertificateList(r0);     // Catch: Throwable -> L6
            List<Certificate> r18 = readCertificateList(r0);     // Catch: Throwable -> L6
            if (r0.exhausted() == true) goto L25;
            TlsVersion r19 = TlsVersion.Companion.forJavaName(r0.readUtf8LineStrict());     // Catch: Throwable -> L6
        L26:
            this.handshake = Handshake.Companion.get(r19, r16, r17, r18);     // Catch: Throwable -> L6
        L30:
            r9.close();
            return;
        L25:
            r19 = TlsVersion.SSL_3_0;     // Catch: Throwable -> L6
            goto L26
        L28:
            throw new IOException("expected \"\" but was \"" + r15 + '\"');     // Catch: Throwable -> L6
        L29:
            this.handshake = null;     // Catch: Throwable -> L6
            goto L30
        L14:
            r14 = 0;
        L6:
            th = move-exception;
            r9.close();
            throw th;
        }

        private final boolean isHttps() {
            return StringsKt.F(this.url, "https://", false);
        }

        private final List<Certificate> readCertificateList(BufferedSource r7) {
            int r6 = Cache.Companion.readInt$okhttp(r7);
            if (r6 == (-1)) goto L5;
            CertificateFactory r0 = CertificateFactory.getInstance("X.509");     // Catch: CertificateException -> L10
            ArrayList r1 = new ArrayList(r6);     // Catch: CertificateException -> L10
            int r2 = 0;
        L7:
            if (r2 >= r6) goto L12;
            String r3 = r7.readUtf8LineStrict();     // Catch: CertificateException -> L10
            Buffer r4 = new Buffer();     // Catch: CertificateException -> L10
            ByteString r5 = ByteString.Companion.decodeBase64(r3);     // Catch: CertificateException -> L10
            Intrinsics.c(r5);     // Catch: CertificateException -> L10
            r4.write(r5);     // Catch: CertificateException -> L10
            r1.add(r0.generateCertificate(r4.inputStream()));     // Catch: CertificateException -> L10
            r2 = r2 + 1;
            goto L7
        L12:
            return r1;
        L10:
            e = move-exception;
            throw new IOException(e.getMessage());
        L5:
            return EmptyList.b;
        }

        private final void writeCertList(BufferedSink r10, List<? extends Certificate> r11) {
            r10.writeDecimalLong(r11.size()).writeByte(10);     // Catch: CertificateEncodingException -> L6
            int r9 = r11.size();     // Catch: CertificateEncodingException -> L6
            int r1 = 0;
        L3:
            if (r1 >= r9) goto L8;
            byte[] r4 = r11.get(r1).getEncoded();     // Catch: CertificateEncodingException -> L6
            ByteString.Companion r3 = ByteString.Companion;     // Catch: CertificateEncodingException -> L6
            Intrinsics.e(r4, "bytes");     // Catch: CertificateEncodingException -> L6
            r10.writeUtf8(ByteString.Companion.of$default(r3, r4, 0, 0, 3, null).base64()).writeByte(10);     // Catch: CertificateEncodingException -> L6
            r1 = r1 + 1;
            goto L3
        L8:
            return;
        L6:
            e = move-exception;
            throw new IOException(e.getMessage());
        }

        public final boolean matches(@NotNull Request r3, @NotNull Response r4) {
            Intrinsics.f(r3, "request");
            Intrinsics.f(r4, ApmTrafficStats.TTNET_RESPONSE);
            if (Intrinsics.a(this.url, r3.url().toString()) == true) goto L5;
        L9:
            return false;
        L5:
            if (Intrinsics.a(this.requestMethod, r3.method()) == false) goto L9;
            if (Cache.Companion.varyMatches(r4, this.varyHeaders, r3) == false) goto L9;
            return true;
        }

        @NotNull
        public final Response response(@NotNull DiskLruCache.Snapshot r6) {
            Intrinsics.f(r6, "snapshot");
            String r0 = this.responseHeaders.get("Content-Type");
            String r1 = this.responseHeaders.get(HTTP.CONTENT_LEN);
            Request r2 = new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build();
            return new Response.Builder().request(r2).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(r6, r0, r1)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        public final void writeTo(@NotNull DiskLruCache.Editor r8) {
            Intrinsics.f(r8, "editor");
            int r0 = 0;
            BufferedSink r9 = Okio.buffer(r8.newSink(0));
            r9.writeUtf8(this.url).writeByte(10);     // Catch: Throwable -> L8
            r9.writeUtf8(this.requestMethod).writeByte(10);     // Catch: Throwable -> L8
            r9.writeDecimalLong(this.varyHeaders.size()).writeByte(10);     // Catch: Throwable -> L8
            int r1 = this.varyHeaders.size();     // Catch: Throwable -> L8
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L10;
            r9.writeUtf8(this.varyHeaders.name(r3)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(r3)).writeByte(10);     // Catch: Throwable -> L8
            r3 = r3 + 1;     // Catch: Throwable -> L8
            goto L6
        L10:
            r9.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);     // Catch: Throwable -> L8
            r9.writeDecimalLong(this.responseHeaders.size() + 2).writeByte(10);     // Catch: Throwable -> L8
            int r2 = this.responseHeaders.size();     // Catch: Throwable -> L8
        L11:
            if (r0 >= r2) goto L13;
            r9.writeUtf8(this.responseHeaders.name(r0)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(r0)).writeByte(10);     // Catch: Throwable -> L8
            r0 = r0 + 1;     // Catch: Throwable -> L8
            goto L11
        L13:
            r9.writeUtf8(SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(10);     // Catch: Throwable -> L8
            r9.writeUtf8(RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(10);     // Catch: Throwable -> L8
            if (isHttps() == false) goto L16;
            r9.writeByte(10);     // Catch: Throwable -> L8
            Handshake r4 = this.handshake;     // Catch: Throwable -> L8
            Intrinsics.c(r4);     // Catch: Throwable -> L8
            r9.writeUtf8(r4.cipherSuite().javaName()).writeByte(10);     // Catch: Throwable -> L8
            writeCertList(r9, this.handshake.peerCertificates());     // Catch: Throwable -> L8
            writeCertList(r9, this.handshake.localCertificates());     // Catch: Throwable -> L8
            r9.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(10);     // Catch: Throwable -> L8
        L16:
            CloseableKt.a(r9, null);
            return;
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            CloseableKt.a(r9, th);
            throw th;
        }

        public Entry(@NotNull Response r3) {
            Intrinsics.f(r3, ApmTrafficStats.TTNET_RESPONSE);
            this.url = r3.request().url().toString();
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
    }

    @Metadata
    public final class RealCacheRequest implements CacheRequest {
        private final Sink body;
        private final Sink cacheOut;
        private boolean done;
        private final DiskLruCache.Editor editor;
        final /* synthetic */ Cache this$0;

        public RealCacheRequest(@NotNull Cache r2, DiskLruCache.Editor r3) {
            Intrinsics.f(r3, "editor");
            this.this$0 = r2;
            this.editor = r3;
            final Sink r4 = r3.newSink(1);
            this.cacheOut = r4;
            this.body = new AnonymousClass1(this, r4);
        }

        public static final /* synthetic */ DiskLruCache.Editor access$getEditor$p(RealCacheRequest r0) {
            return r0.editor;
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            Cache r0 = this.this$0;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.done == false) goto L9;
            monitor-exit(r0);
            return;
        L9:
            this.done = true;     // Catch: Throwable -> L14
            Cache r2 = this.this$0;     // Catch: Throwable -> L14
            r2.setWriteAbortCount$okhttp(r2.getWriteAbortCount$okhttp() + 1);     // Catch: Throwable -> L14
            monitor-exit(r0);
            Util.closeQuietly(this.cacheOut);
            this.editor.abort();     // Catch: IOException -> L17
            return;
        }

        @Override // okhttp3.internal.cache.CacheRequest
        @NotNull
        public Sink body() {
            return this.body;
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean r1) {
            this.done = r1;
        }
    }

    /* JADX INFO: renamed from: okhttp3.Cache$urls$1, reason: invalid class name */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<String>, KMutableIterator {
        private boolean canRemove;
        private final Iterator<DiskLruCache.Snapshot> delegate;
        private String nextUrl;
        final /* synthetic */ Cache this$0;

        public AnonymousClass1(Cache r1) {
            this.this$0 = r1;
            this.delegate = r1.getCache$okhttp().snapshots();
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
            CloseableKt.a(r2, null);     // Catch: IOException -> L19
            return true;
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            CloseableKt.a(r2, th);     // Catch: IOException -> L19
            throw th;     // Catch: IOException -> L19
        L18:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ String next() {
            return next2();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.canRemove == false) goto L7;
            this.delegate.remove();
            return;
        L7:
            throw new IllegalStateException("remove() before next()".toString());
        }

        @Override // java.util.Iterator
        @NotNull
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public String next2() {
            if (hasNext() == false) goto L7;
            String r0 = this.nextUrl;
            Intrinsics.c(r0);
            this.nextUrl = null;
            this.canRemove = true;
            return r0;
        L7:
            throw new NoSuchElementException();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Cache(@NotNull File r10, long r11, @NotNull FileSystem r13) {
        Intrinsics.f(r10, "directory");
        Intrinsics.f(r13, "fileSystem");
        this.cache = new DiskLruCache(r13, r10, VERSION, 2, r11, TaskRunner.INSTANCE);
    }

    private final void abortQuietly(DiskLruCache.Editor r1) {
        if (r1 == null) goto L8;
        r1.abort();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    @JvmStatic
    @NotNull
    public static final String key(@NotNull HttpUrl r1) {
        return Companion.key(r1);
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_directory, reason: not valid java name */
    public final File m56deprecated_directory() {
        return this.cache.getDirectory();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.cache.close();
    }

    public final void delete() {
        this.cache.delete();
    }

    @JvmName
    @NotNull
    public final File directory() {
        return this.cache.getDirectory();
    }

    public final void evictAll() {
        this.cache.evictAll();
    }

    @Override // java.io.Flushable
    public void flush() {
        this.cache.flush();
    }

    @Nullable
    public final Response get$okhttp(@NotNull Request r4) {
        Intrinsics.f(r4, "request");
        String r0 = Companion.key(r4.url());
        DiskLruCache.Snapshot r3 = this.cache.get(r0);     // Catch: IOException -> L15
        if (r3 == null) goto L14;
        Entry r1 = new Entry(r3.getSource(0));     // Catch: IOException -> L13
        Response r5 = r1.response(r3);
        if (r1.matches(r4, r5) == true) goto L12;
        ResponseBody r6 = r5.body();
        if (r6 == null) goto L11;
        Util.closeQuietly(r6);
    L11:
        return null;
    L12:
        return r5;
    L13:
        Util.closeQuietly(r3);
    L14:
        return null;
    }

    @NotNull
    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
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

    public final void initialize() {
        this.cache.initialize();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
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

    @Nullable
    public final CacheRequest put$okhttp(@NotNull Response r10) {
        Intrinsics.f(r10, ApmTrafficStats.TTNET_RESPONSE);
        String r0 = r10.request().method();
        if (HttpMethod.INSTANCE.invalidatesCache(r10.request().method()) == false) goto L7;
        remove$okhttp(r10.request());     // Catch: IOException -> L22
    L5:
        return null;
    L7:
        if ((!Intrinsics.a(r0, HttpMethodContrants.GET)) == false) goto L9;
        return null;
    L9:
        Companion r1 = Companion;
        if (r1.hasVaryAll(r10) == false) goto L12;
        return null;
    L12:
        Entry r2 = new Entry(r10);
        DiskLruCache.Editor r11 = DiskLruCache.edit$default(this.cache, r1.key(r10.request().url()), 0, 2, null);     // Catch: IOException -> L18
        if (r11 != null) goto L27;
        return null;
    L27:
        r2.writeTo(r11);     // Catch: IOException -> L21
        return new RealCacheRequest(this, r11);
    L19:
        abortQuietly(r11);
        return null;
    L18:
        r11 = null;
        goto L19
    }

    public final void remove$okhttp(@NotNull Request r2) {
        Intrinsics.f(r2, "request");
        this.cache.remove(Companion.key(r2.url()));
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

    public final void setWriteAbortCount$okhttp(int r1) {
        this.writeAbortCount = r1;
    }

    public final void setWriteSuccessCount$okhttp(int r1) {
        this.writeSuccessCount = r1;
    }

    public final long size() {
        return this.cache.size();
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

    public final synchronized void trackResponse$okhttp(@NotNull CacheStrategy r2) {
        monitor-enter(this);
        Intrinsics.f(r2, "cacheStrategy");     // Catch: Throwable -> L6
        this.requestCount++;     // Catch: Throwable -> L6
        if (r2.getNetworkRequest() == null) goto L9;
        this.networkCount++;     // Catch: Throwable -> L6
    L11:
        monitor-exit(this);
        return;
    L9:
        if (r2.getCacheResponse() == null) goto L11;
        this.hitCount++;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public final void update$okhttp(@NotNull Response r2, @NotNull Response r3) {
        Intrinsics.f(r2, "cached");
        Intrinsics.f(r3, "network");
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

    @NotNull
    public final Iterator<String> urls() {
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

    public Cache(@NotNull File r2, long r3) {
        Intrinsics.f(r2, "directory");
        this(r2, r3, FileSystem.SYSTEM);
    }
}
