package okhttp3;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MediaType {
    public static final Companion Companion = null;
    private static final Pattern PARAMETER = null;
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private static final Pattern TYPE_SUBTYPE = null;
    private final String mediaType;
    private final String[] parameterNamesAndValues;

    @NotNull
    private final String subtype;

    @NotNull
    private final String type;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @Deprecated
        @JvmName
        @NotNull
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final MediaType m121deprecated_get(@NotNull String r2) {
            Intrinsics.f(r2, "mediaType");
            return get(r2);
        }

        @Deprecated
        @JvmName
        @Nullable
        /* JADX INFO: renamed from: -deprecated_parse, reason: not valid java name */
        public final MediaType m122deprecated_parse(@NotNull String r2) {
            Intrinsics.f(r2, "mediaType");
            return parse(r2);
        }

        @JvmStatic
        @JvmName
        @NotNull
        public final MediaType get(@NotNull String r12) {
            Intrinsics.f(r12, "$this$toMediaType");
            Matcher r11 = MediaType.access$getTYPE_SUBTYPE$cp().matcher(r12);
            if (r11.lookingAt() == false) goto L32;
            String r2 = r11.group(1);
            Intrinsics.e(r2, "typeSubtype.group(1)");
            Locale r3 = Locale.US;
            Intrinsics.e(r3, "Locale.US");
            String r7 = r2.toLowerCase(r3);
            Intrinsics.e(r7, "(this as java.lang.String).toLowerCase(locale)");
            String r5 = r11.group(2);
            Intrinsics.e(r5, "typeSubtype.group(2)");
            String r8 = r5.toLowerCase(r3);
            Intrinsics.e(r8, "(this as java.lang.String).toLowerCase(locale)");
            ArrayList r4 = new ArrayList();
            Matcher r6 = MediaType.access$getPARAMETER$cp().matcher(r12);
            int r13 = r11.end();
        L6:
            if (r13 >= r12.length()) goto L25;
            r6.region(r13, r12.length());
            if (r6.lookingAt() == false) goto L23;
            String r14 = r6.group(1);
            if (r14 == null) goto L11;
            String r9 = r6.group(2);
            if (r9 != null) goto L16;
            r9 = r6.group(3);
        L22:
            r4.add(r14);
            r4.add(r9);
            r13 = r6.end();
            goto L6
        L16:
            if (StringsKt.F(r9, "'", false) == false) goto L22;
            if (StringsKt.o(r9, "'") == false) goto L22;
            if (r9.length() <= 2) goto L22;
            r9 = r9.substring(1, r9.length() - 1);
            Intrinsics.e(r9, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            goto L22
        L11:
            r13 = r6.end();
            goto L6
        L23:
            StringBuilder r0 = new StringBuilder("Parameter is not formatted correctly: \"");
            String r15 = r12.substring(r13);
            Intrinsics.e(r15, "(this as java.lang.String).substring(startIndex)");
            r0.append(r15);
            r0.append("\" for: \"");
            r0.append(r12);
            r0.append('\"');
            throw new IllegalArgumentException(r0.toString().toString());
        L25:
            Object[] r1 = r4.toArray(new String[0]);
            if (r1 == null) goto L30;
            return new MediaType(r12, r7, r8, (String[]) r1, null);
        L30:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L32:
            throw new IllegalArgumentException(("No subtype found for: \"" + r12 + '\"').toString());
        }

        @JvmStatic
        @JvmName
        @Nullable
        public final MediaType parse(@NotNull String r2) {
            Intrinsics.f(r2, "$this$toMediaTypeOrNull");
            return get(r2);
        L5:
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    private MediaType(String r1, String r2, String r3, String[] r4) {
        this.mediaType = r1;
        this.type = r2;
        this.subtype = r3;
        this.parameterNamesAndValues = r4;
    }

    public static final /* synthetic */ Pattern access$getPARAMETER$cp() {
        return PARAMETER;
    }

    public static final /* synthetic */ Pattern access$getTYPE_SUBTYPE$cp() {
        return TYPE_SUBTYPE;
    }

    public static /* synthetic */ Charset charset$default(MediaType r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.charset(r1);
    }

    @JvmStatic
    @JvmName
    @NotNull
    public static final MediaType get(@NotNull String r1) {
        return Companion.get(r1);
    }

    @JvmStatic
    @JvmName
    @Nullable
    public static final MediaType parse(@NotNull String r1) {
        return Companion.parse(r1);
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_subtype, reason: not valid java name */
    public final String m119deprecated_subtype() {
        return this.subtype;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_type, reason: not valid java name */
    public final String m120deprecated_type() {
        return this.type;
    }

    @JvmOverloads
    @Nullable
    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }

    public boolean equals(@Nullable Object r2) {
        if ((r2 instanceof MediaType) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.a(((MediaType) r2).mediaType, this.mediaType) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    @Nullable
    public final String parameter(@NotNull String r6) {
        Intrinsics.f(r6, "name");
        String[] r0 = this.parameterNamesAndValues;
        Intrinsics.f(r0, "<this>");
        IntProgression r1 = RangesKt.d(new IntRange(0, r0.length - 1, 1), 2);
        int r2 = r1.b;
        int r3 = r1.c;
        int r4 = r1.e;
        if (r4 < 0) goto L6;
        if (r2 <= r3) goto L8;
        return null;
    L8:
        if (StringsKt.p(this.parameterNamesAndValues[r2], r6, true) == true) goto L10;
        if (r2 == r3) goto L19;
        r2 = r2 + r4;
        goto L8
    L19:
        return null;
    L10:
        return this.parameterNamesAndValues[r2 + 1];
    L6:
        if (r2 >= r3) goto L8;
        return null;
    }

    @JvmName
    @NotNull
    public final String subtype() {
        return this.subtype;
    }

    @NotNull
    public String toString() {
        return this.mediaType;
    }

    @JvmName
    @NotNull
    public final String type() {
        return this.type;
    }

    public /* synthetic */ MediaType(String r1, String r2, String r3, String[] r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    @JvmOverloads
    @Nullable
    public final Charset charset(@Nullable Charset r2) {
        String r1 = parameter("charset");
        if (r1 == null) goto L9;
        return Charset.forName(r1);
    L10:
        return r2;
    L9:
        return r2;
    }
}
