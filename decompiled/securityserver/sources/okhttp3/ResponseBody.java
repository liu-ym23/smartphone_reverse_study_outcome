package okhttp3;

import a.a;
import androidx.appcompat.widget.ActivityChooserView;
import com.bytedance.apm.battery.dao.DBHelper;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class ResponseBody implements Closeable {
    public static final Companion Companion = null;
    private Reader reader;

    @Metadata
    public static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final BufferedSource source;

        public BomAwareReader(@NotNull BufferedSource r2, @NotNull Charset r3) {
            Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
            Intrinsics.f(r3, "charset");
            this.source = r2;
            this.charset = r3;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.closed = true;
            Reader r0 = this.delegate;
            if (r0 == null) goto L5;
            r0.close();
            return;
        L5:
            this.source.close();
        }

        @Override // java.io.Reader
        public int read(@NotNull char[] r5, int r6, int r7) {
            Intrinsics.f(r5, "cbuf");
            if (this.closed == true) goto L11;
            Reader r0 = this.delegate;
            if (r0 != null) goto L9;
            r0 = new InputStreamReader(this.source.inputStream(), Util.readBomAsCharset(this.source, this.charset));
            this.delegate = r0;
        L9:
            return r0.read(r5, r6, r7);
        L11:
            throw new IOException("Stream closed");
        }
    }

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ResponseBody create$default(Companion r0, String r1, MediaType r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = null;
        L6:
            return r0.create(r1, r2);
        }

        @JvmStatic
        @JvmName
        @NotNull
        public final ResponseBody create(@NotNull String r4, @Nullable MediaType r5) {
            Intrinsics.f(r4, "$this$toResponseBody");
            Charset r0 = Charsets.f354a;
            if (r5 == null) goto L8;
            Charset r1 = MediaType.charset$default(r5, null, 1, null);
            if (r1 != null) goto L7;
            r5 = MediaType.Companion.parse(r5 + "; charset=utf-8");
            goto L8
        L7:
            r0 = r1;
        L8:
            Buffer r6 = new Buffer().writeString(r4, r0);
            return create(r6, r5, r6.size());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ ResponseBody create$default(Companion r0, byte[] r1, MediaType r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = null;
        L6:
            return r0.create(r1, r2);
        }

        public static /* synthetic */ ResponseBody create$default(Companion r0, ByteString r1, MediaType r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = null;
        L6:
            return r0.create(r1, r2);
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
        @JvmName
        @NotNull
        public final ResponseBody create(@NotNull byte[] r4, @Nullable MediaType r5) {
            Intrinsics.f(r4, "$this$toResponseBody");
            return create(new Buffer().write(r4), r5, r4.length);
        }

        @JvmStatic
        @JvmName
        @NotNull
        public final ResponseBody create(@NotNull ByteString r4, @Nullable MediaType r5) {
            Intrinsics.f(r4, "$this$toResponseBody");
            return create(new Buffer().write(r4), r5, r4.size());
        }

        @JvmStatic
        @JvmName
        @NotNull
        public final ResponseBody create(@NotNull final BufferedSource r1, @Nullable final MediaType r2, final long r3) {
            Intrinsics.f(r1, "$this$asResponseBody");
            return new ResponseBody$Companion$asResponseBody$1(r1, r2, r3);
        }

        @Deprecated
        @JvmStatic
        @NotNull
        public final ResponseBody create(@Nullable MediaType r2, @NotNull String r3) {
            Intrinsics.f(r3, "content");
            return create(r3, r2);
        }

        @Deprecated
        @JvmStatic
        @NotNull
        public final ResponseBody create(@Nullable MediaType r2, @NotNull byte[] r3) {
            Intrinsics.f(r3, "content");
            return create(r3, r2);
        }

        @Deprecated
        @JvmStatic
        @NotNull
        public final ResponseBody create(@Nullable MediaType r2, @NotNull ByteString r3) {
            Intrinsics.f(r3, "content");
            return create(r3, r2);
        }

        @Deprecated
        @JvmStatic
        @NotNull
        public final ResponseBody create(@Nullable MediaType r2, long r3, @NotNull BufferedSource r5) {
            Intrinsics.f(r5, "content");
            return create(r5, r2, r3);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ResponseBody() {
    }

    private final Charset charset() {
        MediaType r1 = contentType();
        if (r1 == null) goto L8;
        Charset r2 = r1.charset(Charsets.f354a);
        if (r2 == null) goto L8;
        return r2;
    L8:
        return Charsets.f354a;
    }

    private final <T> T consumeSource(Function1<? super BufferedSource, ? extends T> r5, Function1<? super T, Integer> r6) {
        long r0 = contentLength();
        if (r0 > ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) goto L20;
        BufferedSource r4 = source();
        T r7 = (T) r5.invoke(r4);
        CloseableKt.a(r4, null);
        int r8 = ((Number) r6.invoke(r7)).intValue();
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
        CloseableKt.a(r4, th);
        throw th;
    L20:
        throw new IOException(a.h("Cannot buffer entire body for content length: ", r0));
    }

    @JvmStatic
    @JvmName
    @NotNull
    public static final ResponseBody create(@NotNull String r1, @Nullable MediaType r2) {
        return Companion.create(r1, r2);
    }

    @NotNull
    public final InputStream byteStream() {
        return source().inputStream();
    }

    @NotNull
    public final ByteString byteString() {
        long r0 = contentLength();
        if (r0 > ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) goto L20;
        BufferedSource r5 = source();
        ByteString r2 = r5.readByteString();     // Catch: Throwable -> L14
        CloseableKt.a(r5, null);
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
        CloseableKt.a(r5, th);
        throw th;
    L20:
        throw new IOException(a.h("Cannot buffer entire body for content length: ", r0));
    }

    @NotNull
    public final byte[] bytes() {
        long r0 = contentLength();
        if (r0 > ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) goto L20;
        BufferedSource r5 = source();
        byte[] r2 = r5.readByteArray();     // Catch: Throwable -> L14
        CloseableKt.a(r5, null);
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
        CloseableKt.a(r5, th);
        throw th;
    L20:
        throw new IOException(a.h("Cannot buffer entire body for content length: ", r0));
    }

    @NotNull
    public final Reader charStream() {
        Reader r0 = this.reader;
        if (r0 != null) goto L7;
        BomAwareReader r1 = new BomAwareReader(source(), charset());
        this.reader = r1;
        return r1;
    L7:
        return r0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(source());
    }

    public abstract long contentLength();

    @Nullable
    public abstract MediaType contentType();

    @NotNull
    public abstract BufferedSource source();

    @NotNull
    public final String string() {
        BufferedSource r0 = source();
        String r2 = r0.readString(Util.readBomAsCharset(r0, charset()));     // Catch: Throwable -> L6
        CloseableKt.a(r0, null);
        return r2;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.a(r0, th);
        throw th;
    }

    @Deprecated
    @JvmStatic
    @NotNull
    public static final ResponseBody create(@Nullable MediaType r1, long r2, @NotNull BufferedSource r4) {
        return Companion.create(r1, r2, r4);
    }

    @Deprecated
    @JvmStatic
    @NotNull
    public static final ResponseBody create(@Nullable MediaType r1, @NotNull String r2) {
        return Companion.create(r1, r2);
    }

    @Deprecated
    @JvmStatic
    @NotNull
    public static final ResponseBody create(@Nullable MediaType r1, @NotNull ByteString r2) {
        return Companion.create(r1, r2);
    }

    @Deprecated
    @JvmStatic
    @NotNull
    public static final ResponseBody create(@Nullable MediaType r1, @NotNull byte[] r2) {
        return Companion.create(r1, r2);
    }

    @JvmStatic
    @JvmName
    @NotNull
    public static final ResponseBody create(@NotNull BufferedSource r1, @Nullable MediaType r2, long r3) {
        return Companion.create(r1, r2, r3);
    }

    @JvmStatic
    @JvmName
    @NotNull
    public static final ResponseBody create(@NotNull ByteString r1, @Nullable MediaType r2) {
        return Companion.create(r1, r2);
    }

    @JvmStatic
    @JvmName
    @NotNull
    public static final ResponseBody create(@NotNull byte[] r1, @Nullable MediaType r2) {
        return Companion.create(r1, r2);
    }
}
