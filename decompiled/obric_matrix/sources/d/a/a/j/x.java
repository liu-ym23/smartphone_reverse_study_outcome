package d.a.a.j;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x f12517d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.a.a.k.b<t> f12518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f12519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d.a.a.g f12520c;

    static {
        f12517d = new x();
    }

    public x() {
        this.f12519b = "@type";
        d.a.a.k.b<t> r0 = new d.a.a.k.b(1024);
        this.f12518a = r0;
        r0.b(Boolean.class, f.f12479a);
        q r1 = q.f12510a;
        r0.b(Character.class, r1);
        r0.b(Byte.class, k.f12490a);
        r0.b(Short.class, k.f12490a);
        r0.b(Integer.class, k.f12490a);
        r0.b(Long.class, k.f12490a);
        s r2 = s.f12511b;
        r0.b(Float.class, r2);
        r0.b(Double.class, r2);
        r0.b(Number.class, r2);
        e r3 = e.f12478a;
        r0.b(BigDecimal.class, r3);
        r0.b(BigInteger.class, r3);
        r0.b(String.class, b0.f12473a);
        r0.b(Object[].class, b.f12472a);
        r0.b(Class.class, r1);
        r0.b(SimpleDateFormat.class, r1);
        r0.b(Locale.class, r1);
        r0.b(Currency.class, r1);
        r0.b(TimeZone.class, r1);
        r0.b(UUID.class, r1);
        r0.b(URI.class, r1);
        r0.b(URL.class, r1);
        r0.b(Pattern.class, r1);
        r0.b(Charset.class, r1);
    }

    public t a(Class<?> r10) {
        t r0 = this.f12518a.a(r10);
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (Map.class.isAssignableFrom(r10) == false) goto L9;
        d.a.a.k.b<t> r1 = this.f12518a;
        t r2 = new p();
    L7:
        r1.b(r10, r2);
    L78:
        return this.f12518a.a(r10);
    L9:
        if (List.class.isAssignableFrom(r10) == false) goto L12;
        r1 = this.f12518a;
        r2 = new o();
        goto L7
    L12:
        if (Collection.class.isAssignableFrom(r10) == false) goto L15;
        r1 = this.f12518a;
        r2 = g.f12480a;
        goto L7
    L15:
        if (Date.class.isAssignableFrom(r10) == false) goto L18;
    L16:
        r1 = this.f12518a;
        r2 = h.f12481a;
        goto L7
    L18:
        if (d.a.a.c.class.isAssignableFrom(r10) == false) goto L21;
    L19:
        r1 = this.f12518a;
        r2 = q.f12510a;
        goto L7
    L21:
        if (l.class.isAssignableFrom(r10) == true) goto L19;
        if (d.a.a.f.class.isAssignableFrom(r10) == true) goto L19;
        if (r10.isEnum() == true) goto L76;
        Class<? super Object> r3 = r10.getSuperclass();
        if (r3 == null) goto L36;
        if (r3 == Object.class) goto L36;
        if (r3.isEnum() == true) goto L76;
    L36:
        if (r10.isArray() == false) goto L39;
        Class<?> r4 = r10.getComponentType();
        this.f12518a.b(r10, new c(r4, a(r4)));
        goto L78
    L39:
        if (Throwable.class.isAssignableFrom(r10) == false) goto L42;
        n r5 = new n(r10, this.f12520c);
        r5.f12507c |= a0.t.f12471f;
        this.f12518a.b(r10, r5);
        goto L78
    L42:
        if (TimeZone.class.isAssignableFrom(r10) == true) goto L19;
        if (Charset.class.isAssignableFrom(r10) == true) goto L19;
        if (Enumeration.class.isAssignableFrom(r10) == true) goto L19;
        if (Calendar.class.isAssignableFrom(r10) == true) goto L16;
        Class<?>[] r6 = r10.getInterfaces();
        int r7 = r6.length;
        boolean r8 = false;
        int r9 = 0;
    L54:
        boolean r11 = true;
        if (r9 >= r7) goto L66;
        Class<?> r12 = r6[r9];
        if (r12.getName().equals("net.sf.cglib.proxy.Factory") == true) goto L65;
        if (r12.getName().equals("org.springframework.cglib.proxy.Factory") == true) goto L65;
        if (r12.getName().equals("javassist.util.proxy.ProxyObject") == true) goto L67;
        r9 = r9 + 1;
    L67:
        if (r8 == true) goto L74;
        if (r11 == true) goto L74;
        if (r10.getName().startsWith("android.net.Uri$") == true) goto L19;
        r1 = this.f12518a;
        r2 = new n(r10, this.f12520c);
    L74:
        t r13 = a(r10.getSuperclass());
        this.f12518a.b(r10, r13);
        return r13;
    L65:
        r11 = false;
        r8 = true;
        goto L67
    L66:
        r11 = false;
    L76:
        r1 = this.f12518a;
        r2 = new i();
        goto L7
    }
}
