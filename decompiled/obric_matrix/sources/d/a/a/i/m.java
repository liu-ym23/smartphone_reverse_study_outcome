package d.a.a.i;

import d.a.a.j.b0;
import d.a.a.j.q;
import d.a.a.j.s;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static m f12444e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.a.a.k.b<d.a.a.i.q.f> f12445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f12446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ClassLoader f12447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d.a.a.g f12448d;

    static {
        f12444e = new m();
    }

    public m() {
        d.a.a.k.b<d.a.a.i.q.f> r0 = new d.a.a.k.b(1024);
        this.f12445a = r0;
        this.f12446b = new o(16384);
        q r1 = q.f12510a;
        r0.b(SimpleDateFormat.class, r1);
        d.a.a.j.h r2 = d.a.a.j.h.f12481a;
        r0.b(Date.class, r2);
        r0.b(Calendar.class, r2);
        r0.b(Map.class, k.f12438a);
        r0.b(HashMap.class, k.f12438a);
        r0.b(LinkedHashMap.class, k.f12438a);
        r0.b(TreeMap.class, k.f12438a);
        r0.b(ConcurrentMap.class, k.f12438a);
        r0.b(ConcurrentHashMap.class, k.f12438a);
        d.a.a.j.g r3 = d.a.a.j.g.f12480a;
        r0.b(Collection.class, r3);
        r0.b(List.class, r3);
        r0.b(ArrayList.class, r3);
        i r4 = i.f12434a;
        r0.b(Object.class, r4);
        r0.b(String.class, b0.f12473a);
        r0.b(Character.TYPE, r1);
        r0.b(Character.class, r1);
        Class r5 = Byte.TYPE;
        s r6 = s.f12511b;
        r0.b(r5, r6);
        r0.b(Byte.class, r6);
        r0.b(Short.TYPE, r6);
        r0.b(Short.class, r6);
        r0.b(Integer.TYPE, d.a.a.j.k.f12490a);
        r0.b(Integer.class, d.a.a.j.k.f12490a);
        r0.b(Long.TYPE, d.a.a.j.k.f12490a);
        r0.b(Long.class, d.a.a.j.k.f12490a);
        d.a.a.j.e r7 = d.a.a.j.e.f12478a;
        r0.b(BigInteger.class, r7);
        r0.b(BigDecimal.class, r7);
        r0.b(Float.TYPE, r6);
        r0.b(Float.class, r6);
        r0.b(Double.TYPE, r6);
        r0.b(Double.class, r6);
        Class r8 = Boolean.TYPE;
        d.a.a.j.f r9 = d.a.a.j.f.f12479a;
        r0.b(r8, r9);
        r0.b(Boolean.class, r9);
        r0.b(Class.class, r1);
        d.a.a.j.b r10 = d.a.a.j.b.f12472a;
        r0.b(char[].class, r10);
        r0.b(Object[].class, r10);
        r0.b(UUID.class, r1);
        r0.b(TimeZone.class, r1);
        r0.b(Locale.class, r1);
        r0.b(Currency.class, r1);
        r0.b(URI.class, r1);
        r0.b(URL.class, r1);
        r0.b(Pattern.class, r1);
        r0.b(Charset.class, r1);
        r0.b(Number.class, r6);
        r0.b(StackTraceElement.class, r1);
        r0.b(Serializable.class, r4);
        r0.b(Cloneable.class, r4);
        r0.b(Comparable.class, r4);
        r0.b(Closeable.class, r4);
    }

    public static m d() {
        return f12444e;
    }

    public static boolean e(Class<?> r1) {
        if (r1.isPrimitive() == false) goto L5;
    L36:
        return true;
    L5:
        if (r1 == Boolean.class) goto L36;
        if (r1 == Character.class) goto L36;
        if (r1 == Byte.class) goto L36;
        if (r1 == Short.class) goto L36;
        if (r1 == Integer.class) goto L36;
        if (r1 == Long.class) goto L36;
        if (r1 == Float.class) goto L36;
        if (r1 == Double.class) goto L36;
        if (r1 == BigInteger.class) goto L36;
        if (r1 == BigDecimal.class) goto L36;
        if (r1 == String.class) goto L36;
        if (r1 == Date.class) goto L36;
        if (r1 == java.sql.Date.class) goto L36;
        if (r1 == Time.class) goto L36;
        if (r1 == Timestamp.class) goto L36;
        return false;
    }

    public d.a.a.i.q.d a(m r2, Class<?> r3, d.a.a.k.a r4) {
        Class<?> r1 = r4.f12534l;
        if (r1 == List.class) goto L14;
        if (r1 == ArrayList.class) goto L14;
        if (r1.isArray() == false) goto L12;
        if (r1.getComponentType().isPrimitive() == false) goto L14;
    L12:
        return new a(r2, r3, r4);
    L14:
        return new j(r2, r3, r4);
    }

    public d.a.a.i.q.f b(Class<?> r4, Type r5) {
        d.a.a.i.q.f r0 = this.f12445a.a(r5);
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (r5 != null) goto L7;
        r5 = r4;
    L7:
        d.a.a.i.q.f r1 = this.f12445a.a(r5);
        if (r1 == null) goto L11;
        return r1;
    L11:
        if (e(r4) == true) goto L19;
        d.a.a.h.c r2 = (d.a.a.h.c) r4.getAnnotation(d.a.a.h.c.class);
        if (r2 == null) goto L19;
        Class<?> r3 = r2.mappingTo();
        if (r3 == Void.class) goto L19;
        return b(r3, r3);
    L19:
        if ((r5 instanceof WildcardType) == false) goto L21;
    L24:
        r1 = this.f12445a.a(r4);
    L25:
        if (r1 == null) goto L27;
        return r1;
    L27:
        d.a.a.i.q.f r6 = this.f12445a.a(r5);
        if (r6 == null) goto L31;
        return r6;
    L31:
        if (r4.isEnum() == false) goto L34;
        d.a.a.i.q.f r7 = new c(r4);
    L61:
        f(r5, r7);
        return r7;
    L34:
        if (r4.isArray() == false) goto L37;
        r7 = d.a.a.j.b.f12472a;
        goto L61
    L37:
        if (r4 != Set.class) goto L39;
    L60:
        r7 = d.a.a.j.g.f12480a;
        goto L61
    L39:
        if (r4 == HashSet.class) goto L60;
        if (r4 == Collection.class) goto L60;
        if (r4 == List.class) goto L60;
        if (r4 == ArrayList.class) goto L60;
        if (Collection.class.isAssignableFrom(r4) == true) goto L60;
        if (Map.class.isAssignableFrom(r4) == false) goto L54;
        r7 = k.f12438a;
        goto L61
    L54:
        if (Throwable.class.isAssignableFrom(r4) == false) goto L57;
        r7 = new p(this, r4);
        goto L61
    L57:
        if (r4.getName().equals("android.net.Uri") == false) goto L59;
        r7 = q.f12510a;
        goto L61
    L59:
        r7 = new g(this, r4, r5);
        goto L61
    L21:
        if ((r5 instanceof TypeVariable) == true) goto L24;
        if ((r5 instanceof ParameterizedType) == false) goto L25;
        goto L24
    }

    public d.a.a.i.q.f c(Type r3) {
        d.a.a.i.q.f r0 = this.f12445a.a(r3);
        if (r0 == null) goto L6;
        return r0;
    L6:
        if ((r3 instanceof Class) == false) goto L11;
        Class<?> r1 = (Class) r3;
    L9:
        return b(r1, r3);
    L11:
        if ((r3 instanceof ParameterizedType) == false) goto L18;
        Type r2 = ((ParameterizedType) r3).getRawType();
        if ((r2 instanceof Class) == false) goto L16;
        r1 = (Class) r2;
        goto L9
    L16:
        return c(r2);
    L18:
        return i.f12434a;
    }

    public void f(Type r1, d.a.a.i.q.f r2) {
        this.f12445a.b(r1, r2);
    }
}
