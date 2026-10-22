package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Challenge {

    @NotNull
    private final Map<String, String> authParams;

    @NotNull
    private final String scheme;

    public Challenge(@NotNull String r5, @NotNull Map<String, String> r6) {
        Intrinsics.f(r5, "scheme");
        Intrinsics.f(r6, "authParams");
        this.scheme = r5;
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r8 = r6.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        Map.Entry<String, String> r0 = r8.next();
        String r1 = r0.getKey();
        String r2 = r0.getValue();
        if (r1 == null) goto L8;
        Locale r3 = Locale.US;
        Intrinsics.e(r3, "US");
        String r4 = r1.toLowerCase(r3);
        Intrinsics.e(r4, "(this as java.lang.String).toLowerCase(locale)");
    L9:
        r7.put(r4, r2);
        goto L4
    L8:
        r4 = null;
        goto L9
    L10:
        Map<String, String> r9 = Collections.unmodifiableMap(r7);
        Intrinsics.e(r9, "unmodifiableMap<String?, String>(newAuthParams)");
        this.authParams = r9;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_authParams, reason: not valid java name */
    public final Map<String, String> m67deprecated_authParams() {
        return this.authParams;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_charset, reason: not valid java name */
    public final Charset m68deprecated_charset() {
        return charset();
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_realm, reason: not valid java name */
    public final String m69deprecated_realm() {
        return realm();
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m70deprecated_scheme() {
        return this.scheme;
    }

    @JvmName
    @NotNull
    public final Map<String, String> authParams() {
        return this.authParams;
    }

    @JvmName
    @NotNull
    public final Charset charset() {
        String r1 = this.authParams.get("charset");
        if (r1 != null) goto L9;
    L6:
        Charset r2 = StandardCharsets.ISO_8859_1;
        Intrinsics.e(r2, "ISO_8859_1");
        return r2;
    L9:
        Charset r3 = Charset.forName(r1);     // Catch: Exception -> L8
        Intrinsics.e(r3, "Charset.forName(charset)");     // Catch: Exception -> L8
        return r3;
    }

    public boolean equals(@Nullable Object r3) {
        if ((r3 instanceof Challenge) == false) goto L9;
        Challenge r4 = (Challenge) r3;
        if (Intrinsics.a(r4.scheme, this.scheme) == false) goto L9;
        if (Intrinsics.a(r4.authParams, this.authParams) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        int r0 = (this.scheme.hashCode() + 899) * 31;
        return this.authParams.hashCode() + r0;
    }

    @JvmName
    @Nullable
    public final String realm() {
        return this.authParams.get("realm");
    }

    @JvmName
    @NotNull
    public final String scheme() {
        return this.scheme;
    }

    @NotNull
    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }

    @NotNull
    public final Challenge withCharset(@NotNull Charset r4) {
        Intrinsics.f(r4, "charset");
        Map<String, String> r1 = this.authParams;
        Intrinsics.f(r1, "<this>");
        LinkedHashMap r2 = new LinkedHashMap(r1);
        String r5 = r4.name();
        Intrinsics.e(r5, "charset.name()");
        r2.put("charset", r5);
        return new Challenge(this.scheme, r2);
    }

    public Challenge(@NotNull String r2, @NotNull String r3) {
        Intrinsics.f(r2, "scheme");
        Intrinsics.f(r3, "realm");
        Map r4 = Collections.singletonMap("realm", r3);
        Intrinsics.e(r4, "singletonMap(\"realm\", realm)");
        this(r2, r4);
    }
}
