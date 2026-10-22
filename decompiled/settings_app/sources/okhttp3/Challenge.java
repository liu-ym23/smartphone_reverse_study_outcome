package okhttp3;

import android.icu.text.PluralRules;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Challenge.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\u001b\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00030\u0007H\u0007¢\u0006\u0002\b\u000eJ\r\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\b\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b\u0015J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bR!\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00030\u00078G¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u0004\u0010\rR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\r¨\u0006\u0019"}, d2 = {"Lokhttp3/Challenge;", "", "scheme", "", "realm", "(Ljava/lang/String;Ljava/lang/String;)V", "authParams", "", "(Ljava/lang/String;Ljava/util/Map;)V", "()Ljava/util/Map;", "charset", "Ljava/nio/charset/Charset;", "()Ljava/nio/charset/Charset;", "()Ljava/lang/String;", "-deprecated_authParams", "-deprecated_charset", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "-deprecated_realm", "-deprecated_scheme", "toString", "withCharset", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Challenge {
    private final Map<String, String> authParams;
    private final String scheme;

    public Challenge(String r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r5, "scheme");
        Intrinsics.checkNotNullParameter(r6, "authParams");
        this.scheme = r5;
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r8 = r6.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        Map.Entry<String, String> r0 = r8.next();
        String r1 = r0.getKey();
        String r2 = r0.getValue();
        if (r1 != null) goto L8;
        String r3 = null;
    L9:
        r7.put(r3, r2);
        goto L4
    L8:
        Locale r4 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r4, "US");
        r3 = r1.toLowerCase(r4);
        Intrinsics.checkNotNullExpressionValue(r3, "this as java.lang.String).toLowerCase(locale)");
        goto L9
    L10:
        Map<String, String> r9 = Collections.unmodifiableMap(r7);
        Intrinsics.checkNotNullExpressionValue(r9, "unmodifiableMap<String?, String>(newAuthParams)");
        this.authParams = r9;
    }

    public final String scheme() {
        return this.scheme;
    }

    public final Map<String, String> authParams() {
        return this.authParams;
    }

    public final String realm() {
        return this.authParams.get("realm");
    }

    public final Charset charset() {
        String r1 = this.authParams.get("charset");
        if (r1 != null) goto L9;
    L6:
        Charset r2 = StandardCharsets.ISO_8859_1;
        Intrinsics.checkNotNullExpressionValue(r2, "ISO_8859_1");
        return r2;
    L9:
        Charset r3 = Charset.forName(r1);     // Catch: Exception -> L8
        Intrinsics.checkNotNullExpressionValue(r3, "forName(charset)");     // Catch: Exception -> L8
        return r3;
    }

    public Challenge(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "scheme");
        Intrinsics.checkNotNullParameter(r3, "realm");
        Map r4 = Collections.singletonMap("realm", r3);
        Intrinsics.checkNotNullExpressionValue(r4, "singletonMap(\"realm\", realm)");
        this(r2, r4);
    }

    public final Challenge withCharset(Charset r4) {
        Intrinsics.checkNotNullParameter(r4, "charset");
        Map r1 = MapsKt.toMutableMap(this.authParams);
        String r5 = r4.name();
        Intrinsics.checkNotNullExpressionValue(r5, "charset.name()");
        r1.put("charset", r5);
        return new Challenge(this.scheme, r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "scheme", imports = {}))
    /* JADX INFO: renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m3112deprecated_scheme() {
        return this.scheme;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "authParams", imports = {}))
    /* JADX INFO: renamed from: -deprecated_authParams, reason: not valid java name */
    public final Map<String, String> m3109deprecated_authParams() {
        return this.authParams;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "realm", imports = {}))
    /* JADX INFO: renamed from: -deprecated_realm, reason: not valid java name */
    public final String m3111deprecated_realm() {
        return realm();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "charset", imports = {}))
    /* JADX INFO: renamed from: -deprecated_charset, reason: not valid java name */
    public final Charset m3110deprecated_charset() {
        return charset();
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof Challenge) == false) goto L9;
        Challenge r4 = (Challenge) r3;
        if (Intrinsics.areEqual(r4.scheme, this.scheme) == false) goto L9;
        if (Intrinsics.areEqual(r4.authParams, this.authParams) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        return ((899 + this.scheme.hashCode()) * 31) + this.authParams.hashCode();
    }

    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }
}
