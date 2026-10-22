package kotlinx.coroutines.internal;

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
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FastServiceLoader {
    public static List a() {
        if (FastServiceLoaderKt.f413a == true) goto L34;
        ClassLoader r0 = MainDispatcherFactory.class.getClassLoader();
        return b(r0);
    L8:
        return CollectionsKt.q(ServiceLoader.load(MainDispatcherFactory.class, r0));
    L34:
        ArrayList r1 = new ArrayList(2);     // Catch: Throwable -> L22
        MainDispatcherFactory r4 = null;
        MainDispatcherFactory r2 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(null).newInstance(null));     // Catch: ClassNotFoundException -> L13 Throwable -> L22
    L14:
        if (r2 == null) goto L28;
        r1.add(r2);     // Catch: Throwable -> L22
    L28:
        r4 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(null).newInstance(null));     // Catch: ClassNotFoundException -> L27 Throwable -> L22
    L19:
        if (r4 == null) goto L39;
        r1.add(r4);     // Catch: Throwable -> L22
        return r1;
    L39:
        return r1;
    L13:
        r2 = null;
    L22:
        ClassLoader r3 = MainDispatcherFactory.class.getClassLoader();
        return b(r3);
    L26:
        return CollectionsKt.q(ServiceLoader.load(MainDispatcherFactory.class, r3));
    }

    public static ArrayList b(ClassLoader r9) {
        ArrayList r1 = Collections.list(r9.getResources("META-INF/services/".concat(MainDispatcherFactory.class.getName())));
        Intrinsics.e(r1, "java.util.Collections.list(this)");
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L39;
        URL r4 = (URL) r3.next();
        String r6 = r4.toString();
        if (StringsKt.F(r6, "jar", false) == false) goto L30;
        String r5 = StringsKt.G(r6, "jar:file:");
        int r7 = StringsKt.r(r5, '!', 0, false, 6);
        if (r7 == (-1)) goto L11;
        r5 = r5.substring(0, r7);
        Intrinsics.e(r5, "this as java.lang.String…ing(startIndex, endIndex)");
    L11:
        String r8 = StringsKt.G(r6, "!/");
        JarFile r10 = new JarFile(r5, false);
        BufferedReader r11 = new BufferedReader(new InputStreamReader(r10.getInputStream(new ZipEntry(r8)), "UTF-8"));     // Catch: Throwable -> L16
        List r12 = c(r11);     // Catch: Throwable -> L18
        CloseableKt.a(r11, null);     // Catch: Throwable -> L16
        r10.close();
    L33:
        CollectionsKt.d(r2, r12);
        goto L4
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.a(r11, th);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L27
        throw th;
    L27:
        th = move-exception;
        ExceptionsKt.a(th, th);
        throw th;
    L30:
        BufferedReader r13 = new BufferedReader(new InputStreamReader(r4.openStream()));
        List r14 = c(r13);     // Catch: Throwable -> L34
        CloseableKt.a(r13, null);
        r12 = r14;
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        CloseableKt.a(r13, th);
        throw th;
    L39:
        Set r15 = CollectionsKt.s(r2);
        if ((!r15.isEmpty()) == false) goto L51;
        ArrayList r16 = new ArrayList(CollectionsKt.e(r15, 10));
        Iterator r17 = r15.iterator();
    L43:
        if (r17.hasNext() == false) goto L49;
        Class<?> r18 = Class.forName((String) r17.next(), false, r9);
        if (MainDispatcherFactory.class.isAssignableFrom(r18) == false) goto L48;
        r16.add(MainDispatcherFactory.class.cast(r18.getDeclaredConstructor(null).newInstance(null)));
        goto L43
    L48:
        throw new IllegalArgumentException(("Expected service of class " + MainDispatcherFactory.class + ", but found " + r18).toString());
    L49:
        return r16;
    L51:
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }

    public static List c(BufferedReader r5) {
        LinkedHashSet r0 = new LinkedHashSet();
    L3:
        String r1 = r5.readLine();
        if (r1 == null) goto L24;
        int r4 = 0;
        int r2 = StringsKt.s(r1, "#", 0, false, 6);
        if (r2 == (-1)) goto L9;
        r1 = r1.substring(0, r2);
        Intrinsics.e(r1, "this as java.lang.String…ing(startIndex, endIndex)");
    L9:
        String r3 = StringsKt.J(r1).toString();
    L11:
        if (r4 >= r3.length()) goto L21;
        char r6 = r3.charAt(r4);
        if (r6 == '.') goto L19;
        if (Character.isJavaIdentifierPart(r6) == true) goto L19;
        throw new IllegalArgumentException("Illegal service provider class name: ".concat(r3).toString());
    L19:
        r4 = r4 + 1;
        goto L11
    L21:
        if (r3.length() <= 0) goto L3;
        r0.add(r3);
        goto L3
    L24:
        return CollectionsKt.q(r0);
    }
}
