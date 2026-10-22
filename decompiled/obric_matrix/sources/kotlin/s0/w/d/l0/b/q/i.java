package kotlin.s0.w.d.l0.b.q;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.b.k;
import kotlin.s0.w.d.l0.e.b.x;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f18840a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f18841b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<String> f18842c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<String> f18843d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set<String> f18844e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Set<String> f18845f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Set<String> f18846g = null;

    static {
        i r0 = new i();
        f18840a = r0;
        x r1 = x.f19797a;
        f18841b = t0.i(r1.f("Collection", new String[]{"toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"}), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        f18842c = t0.h(t0.h(t0.h(t0.h(t0.h(t0.h(r0.b(), r1.f("List", new String[]{"sort(Ljava/util/Comparator;)V"})), r1.e("String", new String[]{"codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;"})), r1.e("Double", new String[]{"isInfinite()Z", "isNaN()Z"})), r1.e("Float", new String[]{"isInfinite()Z", "isNaN()Z"})), r1.e("Enum", new String[]{"getDeclaringClass()Ljava/lang/Class;", "finalize()V"})), r1.e("CharSequence", new String[]{"isEmpty()Z"}));
        f18843d = t0.h(t0.h(t0.h(t0.h(t0.h(t0.h(r1.e("CharSequence", new String[]{"codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"}), r1.f("Iterator", new String[]{"forEachRemaining(Ljava/util/function/Consumer;)V"})), r1.e("Iterable", new String[]{"forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;"})), r1.e("Throwable", new String[]{"setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V"})), r1.f("Collection", new String[]{"spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z"})), r1.f("List", new String[]{"replaceAll(Ljava/util/function/UnaryOperator;)V"})), r1.f("Map", new String[]{"getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"}));
        f18844e = t0.h(t0.h(r1.f("Collection", new String[]{"removeIf(Ljava/util/function/Predicate;)Z"}), r1.f("List", new String[]{"replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V"})), r1.f("Map", new String[]{"computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"}));
        Set<String> r2 = r0.a();
        String[] r3 = r1.b(new String[]{"D"});
        Set r4 = t0.h(r2, r1.e("Float", (String[]) Arrays.copyOf(r3, r3.length)));
        String[] r5 = r1.b(new String[]{"[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;"});
        f18845f = t0.h(r4, r1.e("String", (String[]) Arrays.copyOf(r5, r5.length)));
        String[] r6 = r1.b(new String[]{"Ljava/lang/String;Ljava/lang/Throwable;ZZ"});
        f18846g = r1.e("Throwable", (String[]) Arrays.copyOf(r6, r6.length));
    }

    private i() {
    }

    private final Set<String> a() {
        x r5 = x.f19797a;
        kotlin.s0.w.d.l0.k.u.e r1 = kotlin.s0.w.d.l0.k.u.e.f20608l;
        List r0 = r.j(new kotlin.s0.w.d.l0.k.u.e[]{kotlin.s0.w.d.l0.k.u.e.f20606j, r1, kotlin.s0.w.d.l0.k.u.e.q, kotlin.s0.w.d.l0.k.u.e.o, r1, kotlin.s0.w.d.l0.k.u.e.n, kotlin.s0.w.d.l0.k.u.e.p, kotlin.s0.w.d.l0.k.u.e.m});
        LinkedHashSet r2 = new LinkedHashSet();
        Iterator r3 = r0.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        String r4 = ((kotlin.s0.w.d.l0.k.u.e) r3.next()).l().g().b();
        o.e(r4, "it.wrapperFqName.shortName().asString()");
        String[] r6 = r5.b(new String[]{"Ljava/lang/String;"});
        r.v(r2, r5.e(r4, (String[]) Arrays.copyOf(r6, r6.length)));
        goto L4
    L6:
        return r2;
    }

    private final Set<String> b() {
        x r9 = x.f19797a;
        List r0 = r.j(new kotlin.s0.w.d.l0.k.u.e[]{kotlin.s0.w.d.l0.k.u.e.f20606j, kotlin.s0.w.d.l0.k.u.e.f20607k});
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        kotlin.s0.w.d.l0.k.u.e r4 = (kotlin.s0.w.d.l0.k.u.e) r2.next();
        String r5 = r4.l().g().b();
        o.e(r5, "it.wrapperFqName.shortName().asString()");
        r.v(r1, r9.e(r5, new String[]{r4.j() + "Value()" + r4.g()}));
        goto L4
    L6:
        return r1;
    }

    public final Set<String> c() {
        return f18841b;
    }

    public final Set<String> d() {
        return f18845f;
    }

    public final Set<String> e() {
        return f18842c;
    }

    public final Set<String> f() {
        return f18844e;
    }

    public final Set<String> g() {
        return f18846g;
    }

    public final Set<String> h() {
        return f18843d;
    }

    public final boolean i(kotlin.s0.w.d.l0.g.d r1) {
        o.f(r1, "fqName");
        if (o.a(r1, k.a.f18725h) == false) goto L5;
    L8:
        return true;
    L5:
        if (k.e(r1) == true) goto L8;
        return false;
    }

    public final boolean j(kotlin.s0.w.d.l0.g.d r2) {
        o.f(r2, "fqName");
        if (i(r2) == false) goto L6;
        return true;
    L6:
        kotlin.s0.w.d.l0.g.b r1 = c.f18771a.n(r2);
        if (r1 != null) goto L13;
        return false;
    L13:
        return Serializable.class.isAssignableFrom(Class.forName(r1.b().b()));
    L12:
        return false;
    }
}
