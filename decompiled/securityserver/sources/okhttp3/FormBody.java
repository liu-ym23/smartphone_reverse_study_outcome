package okhttp3;

import com.ss.android.http.legacy.utils.URLEncodedUtils;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FormBody extends RequestBody {
    private static final MediaType CONTENT_TYPE = null;
    public static final Companion Companion = null;
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    @Metadata
    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        /* JADX WARN: Multi-variable type inference failed */
        @JvmOverloads
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @NotNull
        public final Builder add(@NotNull String r17, @NotNull String r18) {
            Intrinsics.f(r17, "name");
            Intrinsics.f(r18, "value");
            List<String> r1 = this.names;
            HttpUrl.Companion r15 = HttpUrl.Companion;
            r1.add(HttpUrl.Companion.canonicalize$okhttp$default(r15, r17, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, this.charset, 91, null));
            this.values.add(HttpUrl.Companion.canonicalize$okhttp$default(r15, r18, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, this.charset, 91, null));
            return this;
        }

        @NotNull
        public final Builder addEncoded(@NotNull String r17, @NotNull String r18) {
            Intrinsics.f(r17, "name");
            Intrinsics.f(r18, "value");
            List<String> r1 = this.names;
            HttpUrl.Companion r15 = HttpUrl.Companion;
            r1.add(HttpUrl.Companion.canonicalize$okhttp$default(r15, r17, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, null));
            this.values.add(HttpUrl.Companion.canonicalize$okhttp$default(r15, r18, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, null));
            return this;
        }

        @NotNull
        public final FormBody build() {
            return new FormBody(this.names, this.values);
        }

        @JvmOverloads
        public Builder(@Nullable Charset r1) {
            this.charset = r1;
            this.names = new ArrayList();
            this.values = new ArrayList();
        }

        public /* synthetic */ Builder(Charset r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

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
        CONTENT_TYPE = MediaType.Companion.get(URLEncodedUtils.CONTENT_TYPE);
    }

    public FormBody(@NotNull List<String> r2, @NotNull List<String> r3) {
        Intrinsics.f(r2, "encodedNames");
        Intrinsics.f(r3, "encodedValues");
        this.encodedNames = Util.toImmutableList(r2);
        this.encodedValues = Util.toImmutableList(r3);
    }

    private final long writeOrCountBytes(BufferedSink r4, boolean r5) {
        if (r5 == false) goto L4;
        Buffer r6 = new Buffer();
    L5:
        int r0 = this.encodedNames.size();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L10;
        if (r1 <= 0) goto L9;
        r6.writeByte(38);
    L9:
        r6.writeUtf8(this.encodedNames.get(r1));
        r6.writeByte(61);
        r6.writeUtf8(this.encodedValues.get(r1));
        r1 = r1 + 1;
        goto L6
    L10:
        if (r5 == false) goto L12;
        long r2 = r6.size();
        r6.clear();
        return r2;
    L12:
        return 0;
    L4:
        Intrinsics.c(r4);
        r6 = r4.getBuffer();
        goto L5
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m85deprecated_size() {
        return size();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // okhttp3.RequestBody
    @NotNull
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    @NotNull
    public final String encodedName(int r1) {
        return this.encodedNames.get(r1);
    }

    @NotNull
    public final String encodedValue(int r1) {
        return this.encodedValues.get(r1);
    }

    @NotNull
    public final String name(int r8) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedName(r8), 0, 0, true, 3, null);
    }

    @JvmName
    public final int size() {
        return this.encodedNames.size();
    }

    @NotNull
    public final String value(int r8) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedValue(r8), 0, 0, true, 3, null);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(@NotNull BufferedSink r2) {
        Intrinsics.f(r2, "sink");
        writeOrCountBytes(r2, false);
    }
}
