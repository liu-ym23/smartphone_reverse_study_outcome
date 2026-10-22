package d.e.b.a.l.c;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f16651b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16652a;

    static {
        f16651b = Pattern.compile("^[\\p{L}\\p{N}]+$");
    }

    public i(String r2) {
        this.f16652a = r2 + "_";
    }

    @Override // d.e.b.a.l.c.k
    public String a(Object r3) {
        String r0 = r3.toString();
        if (f16651b.matcher(r0).matches() == false) goto L7;
        return this.f16652a + r3;
    L7:
        throw new IllegalArgumentException("Invalid key: " + r0);
    }
}
