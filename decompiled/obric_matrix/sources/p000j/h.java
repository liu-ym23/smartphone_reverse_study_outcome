package p000j;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import p000j.k0.c;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f17757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f17758b;

    public h(String r4, Map<String, String> r5) {
        Objects.requireNonNull(r4, "scheme == null");
        Objects.requireNonNull(r5, "authParams == null");
        this.f17757a = r4;
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r7 = r5.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        Map.Entry<String, String> r0 = r7.next();
        if (r0.getKey() != null) goto L8;
        String r1 = null;
    L9:
        r6.put(r1, r0.getValue());
        goto L4
    L8:
        r1 = r0.getKey().toLowerCase(Locale.US);
        goto L9
    L10:
        this.f17758b = Collections.unmodifiableMap(r6);
    }

    public Charset a() {
        String r1 = this.f17758b.get("charset");
        if (r1 == null) goto L7;
        return Charset.forName(r1);
    L7:
        return c.f17801j;
    }

    public String b() {
        return this.f17757a;
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof h) == false) goto L9;
        h r4 = (h) r3;
        if (r4.f17757a.equals(this.f17757a) == false) goto L9;
        if (r4.f17758b.equals(this.f17758b) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        return ((899 + this.f17757a.hashCode()) * 31) + this.f17758b.hashCode();
    }

    public String toString() {
        return this.f17757a + " authParams=" + this.f17758b;
    }
}
