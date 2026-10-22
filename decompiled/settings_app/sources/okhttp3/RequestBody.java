package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: compiled from: RequestBody.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000f"}, d2 = {"Lokhttp3/RequestBody;", "", "()V", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "isDuplex", "", "isOneShot", "writeTo", "", "sink", "Lokio/BufferedSink;", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class RequestBody {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: RequestBody.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u000eH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u000fH\u0007J\u001d\u0010\u0010\u001a\u00020\u0004*\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003J1\u0010\u0011\u001a\u00020\u0004*\u00020\n2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0002\b\u0003J\u001d\u0010\u0011\u001a\u00020\u0004*\u00020\u000e2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003J\u001d\u0010\u0011\u001a\u00020\u0004*\u00020\u000f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003¨\u0006\u0012"}, d2 = {"Lokhttp3/RequestBody$Companion;", "", "()V", "create", "Lokhttp3/RequestBody;", "contentType", "Lokhttp3/MediaType;", "file", "Ljava/io/File;", "content", "", "offset", "", "byteCount", "", "Lokio/ByteString;", "asRequestBody", "toRequestBody", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        public final RequestBody create(MediaType r9, byte[] r10) {
            Intrinsics.checkNotNullParameter(r10, "content");
            return create$default(this, r9, r10, 0, 0, 12, null);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        public final RequestBody create(MediaType r9, byte[] r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "content");
            return create$default(this, r9, r10, r11, 0, 8, null);
        }

        @JvmStatic
        public final RequestBody create(byte[] r9) {
            Intrinsics.checkNotNullParameter(r9, "<this>");
            return create$default(this, r9, null, 0, 0, 7, null);
        }

        @JvmStatic
        public final RequestBody create(byte[] r9, MediaType r10) {
            Intrinsics.checkNotNullParameter(r9, "<this>");
            return create$default(this, r9, r10, 0, 0, 6, null);
        }

        @JvmStatic
        public final RequestBody create(byte[] r9, MediaType r10, int r11) {
            Intrinsics.checkNotNullParameter(r9, "<this>");
            return create$default(this, r9, r10, r11, 0, 4, null);
        }

        private Companion() {
        }

        public static /* synthetic */ RequestBody create$default(Companion r0, String r1, MediaType r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = null;
        L6:
            return r0.create(r1, r2);
        }

        @JvmStatic
        public final RequestBody create(String r4, MediaType r5) {
            Intrinsics.checkNotNullParameter(r4, "<this>");
            Charset r0 = Charsets.UTF_8;
            if (r5 == null) goto L7;
            r0 = MediaType.charset$default(r5, null, 1, null);
            if (r0 != null) goto L7;
            r0 = Charsets.UTF_8;
            r5 = MediaType.Companion.parse(r5 + "; charset=utf-8");
        L7:
            byte[] r6 = r4.getBytes(r0);
            Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).getBytes(charset)");
            return create(r6, r5, 0, r6.length);
        }

        public static /* synthetic */ RequestBody create$default(Companion r0, ByteString r1, MediaType r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = null;
        L6:
            return r0.create(r1, r2);
        }

        @JvmStatic
        public final RequestBody create(final ByteString r1, final MediaType r2) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            return new RequestBody$Companion$toRequestBody$1(r2, r1);
        }

        public static /* synthetic */ RequestBody create$default(Companion r0, byte[] r1, MediaType r2, int r3, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = 0;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r4 = r1.length;
        L12:
            return r0.create(r1, r2, r3, r4);
        }

        @JvmStatic
        public final RequestBody create(final byte[] r7, final MediaType r8, final int r9, final int r10) {
            Intrinsics.checkNotNullParameter(r7, "<this>");
            Util.checkOffsetAndCount(r7.length, r9, r10);
            return new RequestBody$Companion$toRequestBody$2(r8, r10, r7, r9);
        }

        public static /* synthetic */ RequestBody create$default(Companion r0, File r1, MediaType r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = null;
        L6:
            return r0.create(r1, r2);
        }

        @JvmStatic
        public final RequestBody create(final File r1, final MediaType r2) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            return new RequestBody$Companion$asRequestBody$1(r2, r1);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        public final RequestBody create(MediaType r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "content");
            return create(r3, r2);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        public final RequestBody create(MediaType r2, ByteString r3) {
            Intrinsics.checkNotNullParameter(r3, "content");
            return create(r3, r2);
        }

        public static /* synthetic */ RequestBody create$default(Companion r0, MediaType r1, byte[] r2, int r3, int r4, int r5, Object r6) {
            if ((r5 & 4) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r5 & 8) == 0) goto L9;
            r4 = r2.length;
        L9:
            return r0.create(r1, r2, r3, r4);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        public final RequestBody create(MediaType r2, byte[] r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "content");
            return create(r3, r2, r4, r5);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @ReplaceWith(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
        @JvmStatic
        public final RequestBody create(MediaType r2, File r3) {
            Intrinsics.checkNotNullParameter(r3, "file");
            return create(r3, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final RequestBody create(File r1, MediaType r2) {
        return Companion.create(r1, r2);
    }

    @JvmStatic
    public static final RequestBody create(String r1, MediaType r2) {
        return Companion.create(r1, r2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @ReplaceWith(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
    @JvmStatic
    public static final RequestBody create(MediaType r1, File r2) {
        return Companion.create(r1, r2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public static final RequestBody create(MediaType r1, String r2) {
        return Companion.create(r1, r2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public static final RequestBody create(MediaType r1, ByteString r2) {
        return Companion.create(r1, r2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public static final RequestBody create(MediaType r1, byte[] r2) {
        return Companion.create(r1, r2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public static final RequestBody create(MediaType r1, byte[] r2, int r3) {
        return Companion.create(r1, r2, r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public static final RequestBody create(MediaType r1, byte[] r2, int r3, int r4) {
        return Companion.create(r1, r2, r3, r4);
    }

    @JvmStatic
    public static final RequestBody create(ByteString r1, MediaType r2) {
        return Companion.create(r1, r2);
    }

    @JvmStatic
    public static final RequestBody create(byte[] r1) {
        return Companion.create(r1);
    }

    @JvmStatic
    public static final RequestBody create(byte[] r1, MediaType r2) {
        return Companion.create(r1, r2);
    }

    @JvmStatic
    public static final RequestBody create(byte[] r1, MediaType r2, int r3) {
        return Companion.create(r1, r2, r3);
    }

    @JvmStatic
    public static final RequestBody create(byte[] r1, MediaType r2, int r3, int r4) {
        return Companion.create(r1, r2, r3, r4);
    }

    public long contentLength() throws IOException {
        return -1;
    }

    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(BufferedSink r1) throws IOException;

    public RequestBody() {
    }
}
