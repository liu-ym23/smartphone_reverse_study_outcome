package okhttp3;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes5.dex */
public final class Challenge {
    private final Map<String, String> authParams;
    private final String scheme;

    public Challenge(String r4, Map<String, String> r5) {
        if (r4 == null) goto L18;
        if (r5 == null) goto L16;
        this.scheme = r4;
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r7 = r5.entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L13;
        Map.Entry<String, String> r0 = r7.next();
        if (r0.getKey() != null) goto L11;
        String r1 = null;
    L12:
        r6.put(r1, r0.getValue());
        goto L7
    L11:
        r1 = r0.getKey().toLowerCase(Locale.US);
        goto L12
    L13:
        this.authParams = Collections.unmodifiableMap(r6);
        return;
    L16:
        throw new NullPointerException("authParams == null");
    L18:
        throw new NullPointerException("scheme == null");
    }

    public Challenge(String r1, String r2) {
        if (r1 == null) goto L10;
        if (r2 == null) goto L8;
        this.scheme = r1;
        this.authParams = Collections.singletonMap("realm", r2);
        return;
    L8:
        throw new NullPointerException("realm == null");
    L10:
        throw new NullPointerException("scheme == null");
    }

    public Challenge withCharset(Charset r3) {
        if (r3 == null) goto L6;
        LinkedHashMap r0 = new LinkedHashMap(this.authParams);
        r0.put("charset", r3.name());
        return new Challenge(this.scheme, r0);
    L6:
        throw new NullPointerException("charset == null");
    }

    public String scheme() {
        return this.scheme;
    }

    public Map<String, String> authParams() {
        return this.authParams;
    }

    public String realm() {
        return this.authParams.get("realm");
    }

    public Charset charset() {
        String r1 = this.authParams.get("charset");
        if (r1 == null) goto L7;
        return Charset.forName(r1);
    L7:
        return Util.ISO_8859_1;
    }

    public boolean equals(@Nullable Object r3) {
        if ((r3 instanceof Challenge) == false) goto L9;
        Challenge r4 = (Challenge) r3;
        if (r4.scheme.equals(this.scheme) == false) goto L9;
        if (r4.authParams.equals(this.authParams) == false) goto L9;
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
