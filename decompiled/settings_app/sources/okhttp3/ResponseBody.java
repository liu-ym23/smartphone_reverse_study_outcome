package okhttp3;

import androidx.exifinterface.media.ExifInterface;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: ResponseBody.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J@\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002H\u00110\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00170\u0014H\u0082\b¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J\b\u0010\u001d\u001a\u00020\u0015H&J\u0006\u0010\u001e\u001a\u00020\u001fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lokhttp3/ResponseBody;", "Ljava/io/Closeable;", "()V", "reader", "Ljava/io/Reader;", "byteStream", "Ljava/io/InputStream;", "byteString", "Lokio/ByteString;", "bytes", "", "charStream", "charset", "Ljava/nio/charset/Charset;", "close", "", "consumeSource", ExifInterface.GPS_DIRECTION_TRUE, "", "consumer", "Lkotlin/Function1;", "Lokio/BufferedSource;", "sizeMapper", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "source", "string", "", "BomAwareReader", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ResponseBody implements Closeable {
    public static final Companion Companion = null;
    private Reader reader;

    /* JADX INFO: compiled from: ResponseBody.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/ResponseBody$BomAwareReader;", "Ljava/io/Reader;", "source", "Lokio/BufferedSource;", "charset", "Ljava/nio/charset/Charset;", "(Lokio/BufferedSource;Ljava/nio/charset/Charset;)V", "closed", "", "delegate", "close", "", "read", "", "cbuf", "", "off", "len", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final BufferedSource source;

        public BomAwareReader(BufferedSource r2, Charset r3) {
            Intrinsics.checkNotNullParameter(r2, "source");
            Intrinsics.checkNotNullParameter(r3, "charset");
            this.source = r2;
            this.charset = r3;
        }

        @Override // java.io.Reader
        public int read(char[] r5, int r6, int r7) throws IOException {
            Intrinsics.checkNotNullParameter(r5, "cbuf");
            if (this.closed == true) goto L10;
            InputStreamReader r0 = this.delegate;
            if (r0 != null) goto L8;
            r0 = new InputStreamReader(this.source.inputStream(), Util.readBomAsCharset(this.source, this.charset));
            this.delegate = r0;
        L8:
            return r0.read(r5, r6, r7);
        L10:
            throw new IOException("Stream closed");
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.closed = true;
            Reader r0 = this.delegate;
            if (r0 != null) goto L5;
            Unit r1 = null;
        L6:
            if (r1 != null) goto L9;
            this.source.close();
            return;
        L9:
            return;
        L5:
            r0.close();
            r1 = Unit.INSTANCE;
            goto L6
        }
    }

    /* JADX INFO: compiled from: ResponseBody.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000bH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\fH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\rH\u0007J'\u0010\u000e\u001a\u00020\u0004*\u00020\u000b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\b\u0003J\u001d\u0010\u000f\u001a\u00020\u0004*\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003J\u001d\u0010\u000f\u001a\u00020\u0004*\u00020\f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003J\u001d\u0010\u000f\u001a\u00020\u0004*\u00020\r2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003¨\u0006\u0010"}, d2 = {"Lokhttp3/ResponseBody$Companion;", "", "()V", "create", "Lokhttp3/ResponseBody;", "contentType", "Lokhttp3/MediaType;", "content", "", "contentLength", "", "Lokio/BufferedSource;", "", "Lokio/ByteString;", "asResponseBody", "toResponseBody", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ResponseBody create$default(Companion r0, String r1, MediaType r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = null;
        L6:
            return r0.create(r1, r2);
        }

        @JvmStatic
        public final ResponseBody create(String r4, MediaType r5) {
            Intrinsics.checkNotNullParameter(r4, "<this>");
            Charset r0 = Charsets.UTF_8;
            if (r5 == null) goto L7;
            r0 = MediaType.charset$default(r5, null, 1, null);
            if (r0 != null) goto L7;
            r0 = Charsets.UTF_8;
            r5 = MediaType.Companion.parse(r5 + "; charset=utf-8");
        L7:
            Buffer r6 = new Buffer().writeString(r4, r0);
            return create(r6, r5, r6.size());
        }

        public static /* synthetic */ ResponseBody create$default(Companion r0, byte[] r1, MediaType r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = null;
        L6:
            return r0.create(r1, r2);
        }

        @JvmStatic
        public final ResponseBody create(byte[] r4, MediaType r5) {
            Intrinsics.checkNotNullParameter(r4, "<this>");
            return create(new Buffer().write(r4), r5, r4.length);
        }

        public static /* synthetic */ ResponseBody create$default(Companion r0, ByteString r1, MediaType r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = null;
        L6:
            return r0.create(r1, r2);
        }

        @JvmStatic
        public final ResponseBody create(ByteString r4, MediaType r5) {
            Intrinsics.checkNotNullParameter(r4, "<this>");
            return create(new Buffer().write(r4), r5, r4.size());
        }

        public static /* synthetic */ ResponseBody create$default(Companion r0, BufferedSource r1, MediaType r2, long r3, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = -1;
        L9:
            return r0.create(r1, r2, r3);
        }

        @JvmStatic
        public final ResponseBody create(final BufferedSource r1, final MediaType r2, final long r3) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            return new ResponseBody$Companion$asResponseBody$1(r2, r3, r1);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @JvmStatic
        public final ResponseBody create(MediaType r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "content");
            return create(r3, r2);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @JvmStatic
        public final ResponseBody create(MediaType r2, byte[] r3) {
            Intrinsics.checkNotNullParameter(r3, "content");
            return create(r3, r2);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @JvmStatic
        public final ResponseBody create(MediaType r2, ByteString r3) {
            Intrinsics.checkNotNullParameter(r3, "content");
            return create(r3, r2);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}))
        @JvmStatic
        public final ResponseBody create(MediaType r2, long r3, BufferedSource r5) {
            Intrinsics.checkNotNullParameter(r5, "content");
            return create(r5, r2, r3);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final ResponseBody create(String r1, MediaType r2) {
        return Companion.create(r1, r2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}))
    @JvmStatic
    public static final ResponseBody create(MediaType r1, long r2, BufferedSource r4) {
        return Companion.create(r1, r2, r4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    public static final ResponseBody create(MediaType r1, String r2) {
        return Companion.create(r1, r2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    public static final ResponseBody create(MediaType r1, ByteString r2) {
        return Companion.create(r1, r2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    public static final ResponseBody create(MediaType r1, byte[] r2) {
        return Companion.create(r1, r2);
    }

    @JvmStatic
    public static final ResponseBody create(BufferedSource r1, MediaType r2, long r3) {
        return Companion.create(r1, r2, r3);
    }

    @JvmStatic
    public static final ResponseBody create(ByteString r1, MediaType r2) {
        return Companion.create(r1, r2);
    }

    @JvmStatic
    public static final ResponseBody create(byte[] r1, MediaType r2) {
        return Companion.create(r1, r2);
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract BufferedSource source();

    public ResponseBody() {
    }

    public final InputStream byteStream() {
        return source().inputStream();
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.Object] */
    private final <T> T consumeSource(Function1<? super BufferedSource, ? extends T> r5, Function1<? super T, Integer> r6) {
        long r0 = contentLength();
        if (r0 > 2147483647L) goto L20;
        BufferedSource r4 = source();
        T r7 = r5.invoke(r4);     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r4, null);
        InlineMarker.finallyEnd(1);
        int r8 = r6.invoke(r7).intValue();
        if (r0 != (-1)) goto L9;
    L13:
        return r7;
    L9:
        if (r0 == r8) goto L13;
        throw new IOException("Content-Length (" + r0 + ") and stream length (" + r8 + ") disagree");
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r4, th);
        InlineMarker.finallyEnd(1);
        throw th;
    L20:
        throw new IOException(Intrinsics.stringPlus("Cannot buffer entire body for content length: ", Long.valueOf(r0)));
    }

    public final Reader charStream() {
        Reader r0 = this.reader;
        if (r0 != null) goto L6;
        BomAwareReader r1 = new BomAwareReader(source(), charset());
        this.reader = r1;
        return r1;
    L6:
        return r0;
    }

    public final String string() throws IOException {
        BufferedSource r0 = source();
        BufferedSource r1 = r0;     // Catch: Throwable -> L6
        String r2 = r1.readString(Util.readBomAsCharset(r1, charset()));     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r0, null);
        return r2;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }

    private final Charset charset() {
        MediaType r1 = contentType();
        if (r1 != null) goto L5;
        Charset r2 = null;
    L6:
        if (r2 == null) goto L8;
        return r2;
    L8:
        return Charsets.UTF_8;
    L5:
        r2 = r1.charset(Charsets.UTF_8);
        goto L6
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(source());
    }

    public final byte[] bytes() throws IOException {
        long r0 = contentLength();
        if (r0 > 2147483647L) goto L20;
        BufferedSource r5 = source();
        byte[] r2 = r5.readByteArray();     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r5, null);
        int r6 = r2.length;
        if (r0 != (-1)) goto L9;
    L13:
        return r2;
    L9:
        if (r0 == r6) goto L13;
        throw new IOException("Content-Length (" + r0 + ") and stream length (" + r6 + ") disagree");
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    L20:
        throw new IOException(Intrinsics.stringPlus("Cannot buffer entire body for content length: ", Long.valueOf(r0)));
    }

    public final ByteString byteString() throws IOException {
        long r0 = contentLength();
        if (r0 > 2147483647L) goto L20;
        BufferedSource r5 = source();
        ByteString r2 = r5.readByteString();     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r5, null);
        int r6 = r2.size();
        if (r0 != (-1)) goto L9;
    L13:
        return r2;
    L9:
        if (r0 == r6) goto L13;
        throw new IOException("Content-Length (" + r0 + ") and stream length (" + r6 + ") disagree");
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    L20:
        throw new IOException(Intrinsics.stringPlus("Cannot buffer entire body for content length: ", Long.valueOf(r0)));
    }
}
