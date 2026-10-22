package h.a.f3;

import com.bytedance.common.wschannel.WsConstants;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\u0004H\u0082\bJ1\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\bH\u0002¢\u0006\u0002\u0010\u0010J*\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0012\"\u0004\b\u0000\u0010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0000¢\u0006\u0002\b\u0014J/\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0012\"\u0004\b\u0000\u0010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J,\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e*\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002H\u001e0!H\u0082\b¢\u0006\u0002\u0010\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "()V", "PREFIX", "", "createInstanceOf", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "baseClass", "Ljava/lang/Class;", "serviceClass", "getProviderInstance", "S", "name", "loader", "Ljava/lang/ClassLoader;", "service", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "load", "", "loadMainDispatcherFactory", "loadMainDispatcherFactory$kotlinx_coroutines_core", "loadProviders", "loadProviders$kotlinx_coroutines_core", "parse", WsConstants.KEY_CONNECTION_URL, "Ljava/net/URL;", "parseFile", "r", "Ljava/io/BufferedReader;", "use", "R", "Ljava/util/jar/JarFile;", "block", "Lkotlin/Function1;", "(Ljava/util/jar/JarFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f17394a = null;

    static {
        f17394a = new l();
    }

    private l() {
    }

    private final <S> S a(String r1, ClassLoader r2, Class<S> r3) {
        Class<?> r4 = Class.forName(r1, false, r2);
        if (r3.isAssignableFrom(r4) == false) goto L7;
        return r3.cast(r4.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    L7:
        throw new IllegalArgumentException(("Expected service of class " + r3 + ", but found " + r4).toString());
    }

    private final <S> List<S> b(Class<S> r1, ClassLoader r2) {
        return d(r1, r2);
    L5:
        return kotlin.i0.r.z0(ServiceLoader.load(r1, r2));
    }

    private final List<String> e(URL r5) {
        String r4 = r5.toString();
        if (kotlin.u0.k.A(r4, "jar", false, 2, null) == false) goto L25;
        String r6 = kotlin.u0.k.D0(kotlin.u0.k.y0(r4, "jar:file:", null, 2, null), '!', null, 2, null);
        String r7 = kotlin.u0.k.y0(r4, "!/", null, 2, null);
        JarFile r0 = new JarFile(r6, false);
        BufferedReader r8 = new BufferedReader(new InputStreamReader(r0.getInputStream(new ZipEntry(r7)), "UTF-8"));     // Catch: Throwable -> L17
        List<String> r9 = f17394a.f(r8);     // Catch: Throwable -> L12
        kotlin.m0.b.a(r8, null);     // Catch: Throwable -> L17
        r0.close();     // Catch: Throwable -> L10
        return r9;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        kotlin.m0.b.a(r8, th);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L22
        throw th;
    L22:
        th = move-exception;
        kotlin.a.a(th, th);
        throw th;
    L25:
        BufferedReader r10 = new BufferedReader(new InputStreamReader(r5.openStream()));
        List<String> r11 = f17394a.f(r10);     // Catch: Throwable -> L29
        kotlin.m0.b.a(r10, null);
        return r11;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        kotlin.m0.b.a(r10, th);
        throw th;
    }

    private final List<String> f(BufferedReader r7) {
        LinkedHashSet r6 = new LinkedHashSet();
    L3:
        String r0 = r7.readLine();
        if (r0 == null) goto L6;
        String r1 = kotlin.u0.k.G0(kotlin.u0.k.E0(r0, "#", null, 2, null)).toString();
        boolean r2 = false;
        int r3 = 0;
    L9:
        if (r3 >= r1.length()) goto L19;
        char r4 = r1.charAt(r3);
        r3 = r3 + 1;
        if (r4 != '.') goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == true) goto L9;
        boolean r8 = false;
    L20:
        if (r8 == false) goto L27;
        if (r1.length() <= 0) goto L24;
        r2 = true;
    L24:
        if (r2 == false) goto L3;
        r6.add(r1);
        goto L3
    L27:
        throw new IllegalArgumentException(kotlin.n0.d.o.m("Illegal service provider class name: ", r1).toString());
    L13:
        if (Character.isJavaIdentifierPart(r4) == true) goto L16;
        r5 = false;
        goto L17
    L19:
        r8 = true;
        goto L20
    L6:
        return kotlin.i0.r.z0(r6);
    }

    public final List<v> c() {
        if (m.a() == false) goto L5;
        ArrayList r1 = new ArrayList(2);     // Catch: Throwable -> L21
        v r3 = null;
        v r2 = (v) v.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, v.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));     // Catch: ClassNotFoundException -> L10 Throwable -> L21
    L11:
        if (r2 == null) goto L28;
        r1.add(r2);     // Catch: Throwable -> L21
    L28:
        r3 = (v) v.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, v.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));     // Catch: ClassNotFoundException -> L23 Throwable -> L21
    L17:
        if (r3 == null) goto L30;
        r1.add(r3);     // Catch: Throwable -> L21
        return r1;
    L30:
        return r1;
    L10:
        r2 = null;
    L22:
        return b(v.class, v.class.getClassLoader());
    L5:
        return b(v.class, v.class.getClassLoader());
    }

    public final <S> List<S> d(Class<S> r4, ClassLoader r5) {
        ArrayList r3 = Collections.list(r5.getResources(kotlin.n0.d.o.m("META-INF/services/", r4.getName())));
        kotlin.n0.d.o.e(r3, "list(this)");
        ArrayList r0 = new ArrayList();
        Iterator r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        kotlin.i0.r.v(r0, f17394a.e((URL) r6.next()));
        goto L4
    L6:
        Set r7 = kotlin.i0.r.D0(r0);
        if ((!r7.isEmpty()) == false) goto L14;
        ArrayList r1 = new ArrayList(kotlin.i0.r.q(r7, 10));
        Iterator r8 = r7.iterator();
    L10:
        if (r8.hasNext() == false) goto L12;
        r1.add(f17394a.a((String) r8.next(), r5, r4));
        goto L10
    L12:
        return r1;
    L14:
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }
}
