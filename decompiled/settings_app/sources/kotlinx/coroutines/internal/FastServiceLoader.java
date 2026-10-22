package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FastServiceLoader.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\u0004H\u0082\bJ1\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\bH\u0002¢\u0006\u0002\u0010\u0010J*\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0012\"\u0004\b\u0000\u0010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0000¢\u0006\u0002\b\u0014J/\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0012\"\u0004\b\u0000\u0010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J,\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e*\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002H\u001e0!H\u0082\b¢\u0006\u0002\u0010\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "()V", "PREFIX", "", "createInstanceOf", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "baseClass", "Ljava/lang/Class;", "serviceClass", "getProviderInstance", ExifInterface.LATITUDE_SOUTH, "name", "loader", "Ljava/lang/ClassLoader;", "service", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "load", "", "loadMainDispatcherFactory", "loadMainDispatcherFactory$kotlinx_coroutines_core", "loadProviders", "loadProviders$kotlinx_coroutines_core", "parse", "url", "Ljava/net/URL;", "parseFile", "r", "Ljava/io/BufferedReader;", "use", "R", "Ljava/util/jar/JarFile;", "block", "Lkotlin/Function1;", "(Ljava/util/jar/JarFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FastServiceLoader {
    public static final FastServiceLoader INSTANCE = null;
    private static final String PREFIX = "META-INF/services/";

    static {
        INSTANCE = new FastServiceLoader();
    }

    private FastServiceLoader() {
    }

    public final List<MainDispatcherFactory> loadMainDispatcherFactory$kotlinx_coroutines_core() {
        if (FastServiceLoaderKt.getANDROID_DETECTED() == false) goto L5;
        ArrayList r1 = new ArrayList(2);     // Catch: Throwable -> L20
        MainDispatcherFactory r3 = null;
        MainDispatcherFactory r2 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));     // Catch: ClassNotFoundException -> L10 Throwable -> L20
    L11:
        if (r2 == null) goto L27;
        r1.add(r2);     // Catch: Throwable -> L20
    L27:
        r3 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));     // Catch: ClassNotFoundException -> L22 Throwable -> L20
    L16:
        if (r3 == null) goto L18;
        r1.add(r3);     // Catch: Throwable -> L20
    L18:
        return r1;
    L10:
        r2 = null;
    L21:
        return load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
    L5:
        return load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
    }

    private final MainDispatcherFactory createInstanceOf(Class<MainDispatcherFactory> r2, String r3) {
        return r2.cast(Class.forName(r3, true, r2.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    L4:
        return null;
    }

    private final <S> List<S> load(Class<S> r1, ClassLoader r2) {
        return loadProviders$kotlinx_coroutines_core(r1, r2);
    L5:
        return CollectionsKt.toList(ServiceLoader.load(r1, r2));
    }

    public final <S> List<S> loadProviders$kotlinx_coroutines_core(Class<S> r4, ClassLoader r5) {
        ArrayList r3 = Collections.list(r5.getResources(PREFIX + r4.getName()));
        Intrinsics.checkNotNullExpressionValue(r3, "list(this)");
        ArrayList r0 = new ArrayList();
        Iterator r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        CollectionsKt.addAll(r0, INSTANCE.parse((URL) r6.next()));
        goto L4
    L6:
        Set r7 = CollectionsKt.toSet(r0);
        if ((!r7.isEmpty()) == false) goto L15;
        Set r8 = r7;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r9 = r8.iterator();
    L10:
        if (r9.hasNext() == false) goto L13;
        r1.add(INSTANCE.getProviderInstance((String) r9.next(), r5, r4));
        goto L10
    L13:
        return r1;
    L15:
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }

    private final <S> S getProviderInstance(String r1, ClassLoader r2, Class<S> r3) {
        Class<?> r4 = Class.forName(r1, false, r2);
        if (r3.isAssignableFrom(r4) == false) goto L7;
        return r3.cast(r4.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    L7:
        throw new IllegalArgumentException(("Expected service of class " + r3 + ", but found " + r4).toString());
    }

    private final List<String> parse(URL r5) {
        String r4 = r5.toString();
        if (StringsKt.startsWith$default(r4, "jar", false, 2, null) == false) goto L25;
        String r6 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(r4, "jar:file:", null, 2, null), '!', null, 2, null);
        String r7 = StringsKt.substringAfter$default(r4, "!/", null, 2, null);
        JarFile r0 = new JarFile(r6, false);
        BufferedReader r8 = new BufferedReader(new InputStreamReader(r0.getInputStream(new ZipEntry(r7)), "UTF-8"));     // Catch: Throwable -> L17
        FastServiceLoader r1 = INSTANCE;     // Catch: Throwable -> L12
        List<String> r9 = r1.parseFile(r8);     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L17
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
        CloseableKt.closeFinally(r8, th);     // Catch: Throwable -> L17
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
        ExceptionsKt.addSuppressed(th, th);
        throw th;
    L25:
        BufferedReader r10 = new BufferedReader(new InputStreamReader(r5.openStream()));
        FastServiceLoader r2 = INSTANCE;     // Catch: Throwable -> L29
        List<String> r11 = r2.parseFile(r10);     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r10, null);
        return r11;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    }

    private final <R> R use(JarFile r2, Function1<? super JarFile, ? extends R> r3) {
        R r4 = r3.invoke(r2);     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        r2.close();     // Catch: Throwable -> L8
        InlineMarker.finallyEnd(1);
        return r4;
    L8:
        th = move-exception;
        throw th;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r2.close();     // Catch: Throwable -> L17
        InlineMarker.finallyEnd(1);
        throw th;
    L17:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);
        throw th;
    }

    private final List<String> parseFile(BufferedReader r8) {
        LinkedHashSet r7 = new LinkedHashSet();
    L3:
        String r0 = r8.readLine();
        if (r0 == null) goto L6;
        String r1 = StringsKt.trim(StringsKt.substringBefore$default(r0, "#", null, 2, null)).toString();
        String r2 = r1;
        boolean r3 = false;
        int r4 = 0;
    L9:
        if (r4 >= r2.length()) goto L20;
        char r5 = r2.charAt(r4);
        if (r5 != '.') goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == false) goto L18;
        r4 = r4 + 1;
        goto L9
    L18:
        boolean r9 = false;
    L21:
        if (r9 == false) goto L28;
        if (r2.length() <= 0) goto L25;
        r3 = true;
    L25:
        if (r3 == false) goto L3;
        r7.add(r1);
        goto L3
    L28:
        throw new IllegalArgumentException(("Illegal service provider class name: " + r1).toString());
    L13:
        if (Character.isJavaIdentifierPart(r5) == true) goto L16;
        r6 = false;
        goto L17
    L20:
        r9 = true;
        goto L21
    L6:
        return CollectionsKt.toList(r7);
    }
}
