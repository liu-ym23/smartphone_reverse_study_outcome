package okhttp3;

import android.icu.text.PluralRules;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MediaType.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0007J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0003J\r\u0010\u0005\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0019"}, d2 = {"Lokhttp3/MediaType;", "", "mediaType", "", "type", "subtype", "parameterNamesAndValues", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "[Ljava/lang/String;", "()Ljava/lang/String;", "charset", "Ljava/nio/charset/Charset;", "defaultValue", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "parameter", "name", "-deprecated_subtype", "toString", "-deprecated_type", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MediaType {
    public static final Companion Companion = null;
    private static final Pattern PARAMETER = null;
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private static final Pattern TYPE_SUBTYPE = null;
    private final String mediaType;
    private final String[] parameterNamesAndValues;
    private final String subtype;
    private final String type;

    /* JADX INFO: compiled from: MediaType.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u000fJ\u0011\u0010\u0010\u001a\u00020\u000b*\u00020\u0007H\u0007¢\u0006\u0002\b\nJ\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000b*\u00020\u0007H\u0007¢\u0006\u0002\b\u000eR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/MediaType$Companion;", "", "()V", "PARAMETER", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "QUOTED", "", "TOKEN", "TYPE_SUBTYPE", "get", "Lokhttp3/MediaType;", "mediaType", "-deprecated_get", "parse", "-deprecated_parse", "toMediaType", "toMediaTypeOrNull", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MediaType get(String r13) {
            Intrinsics.checkNotNullParameter(r13, "<this>");
            String r0 = r13;
            Matcher r12 = MediaType.access$getTYPE_SUBTYPE$cp().matcher(r0);
            if (r12.lookingAt() == false) goto L32;
            String r3 = r12.group(1);
            Intrinsics.checkNotNullExpressionValue(r3, "typeSubtype.group(1)");
            Locale r4 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(r4, "US");
            String r8 = r3.toLowerCase(r4);
            Intrinsics.checkNotNullExpressionValue(r8, "this as java.lang.String).toLowerCase(locale)");
            String r6 = r12.group(2);
            Intrinsics.checkNotNullExpressionValue(r6, "typeSubtype.group(2)");
            Locale r7 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(r7, "US");
            String r9 = r6.toLowerCase(r7);
            Intrinsics.checkNotNullExpressionValue(r9, "this as java.lang.String).toLowerCase(locale)");
            ArrayList r5 = new ArrayList();
            Matcher r1 = MediaType.access$getPARAMETER$cp().matcher(r0);
            int r14 = r12.end();
        L6:
            if (r14 >= r13.length()) goto L25;
            r1.region(r14, r13.length());
            if (r1.lookingAt() == false) goto L23;
            String r15 = r1.group(1);
            if (r15 == null) goto L11;
            String r10 = r1.group(2);
            if (r10 != null) goto L16;
            r10 = r1.group(3);
        L22:
            ArrayList r11 = r5;
            r11.add(r15);
            r11.add(r10);
            r14 = r1.end();
            goto L6
        L16:
            if (StringsKt.startsWith$default(r10, "'", false, 2, null) == false) goto L22;
            if (StringsKt.endsWith$default(r10, "'", false, 2, null) == false) goto L22;
            if (r10.length() <= 2) goto L22;
            r10 = r10.substring(1, r10.length() - 1);
            Intrinsics.checkNotNullExpressionValue(r10, "this as java.lang.String…ing(startIndex, endIndex)");
            goto L22
        L11:
            r14 = r1.end();
            goto L6
        L23:
            StringBuilder r2 = new StringBuilder("Parameter is not formatted correctly: \"");
            String r16 = r13.substring(r14);
            Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String).substring(startIndex)");
            throw new IllegalArgumentException(r2.append(r16).append("\" for: \"").append(r13).append('\"').toString().toString());
        L25:
            Object[] r17 = r5.toArray(new String[0]);
            if (r17 == null) goto L30;
            return new MediaType(r13, r8, r9, (String[]) r17, null);
        L30:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        L32:
            throw new IllegalArgumentException(("No subtype found for: \"" + r13 + '\"').toString());
        }

        @JvmStatic
        public final MediaType parse(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            return get(r2);
        L5:
            MediaType r3 = (MediaType) null;
            return null;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "mediaType.toMediaType()", imports = {"okhttp3.MediaType.Companion.toMediaType"}))
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final MediaType m3163deprecated_get(String r2) {
            Intrinsics.checkNotNullParameter(r2, "mediaType");
            return get(r2);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "mediaType.toMediaTypeOrNull()", imports = {"okhttp3.MediaType.Companion.toMediaTypeOrNull"}))
        /* JADX INFO: renamed from: -deprecated_parse, reason: not valid java name */
        public final MediaType m3164deprecated_parse(String r2) {
            Intrinsics.checkNotNullParameter(r2, "mediaType");
            return parse(r2);
        }
    }

    public /* synthetic */ MediaType(String r1, String r2, String r3, String[] r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    @JvmStatic
    public static final MediaType get(String r1) {
        return Companion.get(r1);
    }

    @JvmStatic
    public static final MediaType parse(String r1) {
        return Companion.parse(r1);
    }

    public final Charset charset() {
        return charset$default(this, null, 1, null);
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

    public final String type() {
        return this.type;
    }

    public final String subtype() {
        return this.subtype;
    }

    public static /* synthetic */ Charset charset$default(MediaType r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.charset(r1);
    }

    public final Charset charset(Charset r2) {
        String r1 = parameter("charset");
        if (r1 != null) goto L8;
        return r2;
    L8:
        return Charset.forName(r1);
    L10:
        return r2;
    }

    public final String parameter(String r6) {
        Intrinsics.checkNotNullParameter(r6, "name");
        int r2 = 0;
        int r0 = ProgressionUtilKt.getProgressionLastElement(0, this.parameterNamesAndValues.length - 1, 2);
        if (r0 < 0) goto L11;
    L4:
        int r1 = r2 + 2;
        if (StringsKt.equals(this.parameterNamesAndValues[r2], r6, true) == true) goto L7;
        if (r2 == r0) goto L15;
        r2 = r1;
        goto L4
    L15:
        return null;
    L7:
        return this.parameterNamesAndValues[r2 + 1];
    L11:
        return null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "type", imports = {}))
    /* JADX INFO: renamed from: -deprecated_type, reason: not valid java name */
    public final String m3162deprecated_type() {
        return this.type;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "subtype", imports = {}))
    /* JADX INFO: renamed from: -deprecated_subtype, reason: not valid java name */
    public final String m3161deprecated_subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof MediaType) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((MediaType) r2).mediaType, this.mediaType) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    static {
        Companion = new Companion(null);
        TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }
}
