package com.google.common.reflect;

import com.android.settings.utils.HanziToPinyin;
import com.bytedance.librarian.LibrarianImpl;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.StandardSystemProperty;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class ClassPath {
    private static final String CLASS_FILE_NAME_EXTENSION = ".class";
    private static final Splitter CLASS_PATH_ATTRIBUTE_SEPARATOR = null;
    private static final Logger logger = null;
    private final ImmutableSet<ResourceInfo> resources;

    public static final class ClassInfo extends ResourceInfo {
        private final String className;

        ClassInfo(File r1, String r2, ClassLoader r3) {
            super(r1, r2, r3);
            this.className = ClassPath.getClassName(r2);
        }

        public String getPackageName() {
            return Reflection.getPackageName(this.className);
        }

        public String getSimpleName() {
            int r0 = this.className.lastIndexOf(36);
            if (r0 == (-1)) goto L6;
            String r2 = this.className.substring(r0 + 1);
            return CharMatcher.inRange('0', '9').trimLeadingFrom(r2);
        L6:
            String r1 = getPackageName();
            if (r1.isEmpty() == false) goto L11;
            return this.className;
        L11:
            return this.className.substring(r1.length() + 1);
        }

        public String getName() {
            return this.className;
        }

        public boolean isTopLevel() {
            if (this.className.indexOf(36) != (-1)) goto L5;
            return true;
        L5:
            return false;
        }

        public Class<?> load() {
            return this.loader.loadClass(this.className);
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.reflect.ClassPath.ResourceInfo
        public String toString() {
            return this.className;
        }
    }

    static final class LocationInfo {
        private final ClassLoader classloader;
        final File home;

        LocationInfo(File r1, ClassLoader r2) {
            this.home = (File) Preconditions.checkNotNull(r1);
            this.classloader = (ClassLoader) Preconditions.checkNotNull(r2);
        }

        public final File file() {
            return this.home;
        }

        public ImmutableSet<ResourceInfo> scanResources() throws IOException {
            return scanResources(new HashSet());
        }

        public ImmutableSet<ResourceInfo> scanResources(Set<File> r3) throws IOException {
            ImmutableSet.Builder<ResourceInfo> r0 = ImmutableSet.builder();
            r3.add(this.home);
            scan(this.home, r3, r0);
            return r0.build();
        }

        private void scan(File r2, Set<File> r3, ImmutableSet.Builder<ResourceInfo> r4) throws IOException {
            if (r2.exists() == true) goto L6;
            return;
        L6:
            if (r2.isDirectory() == false) goto L8;
            scanDirectory(r2, r4);
            return;
        L8:
            scanJar(r2, r3, r4);
            return;
        L10:
            e = move-exception;
            Logger r5 = ClassPath.access$000();
            String r6 = String.valueOf(r2);
            String r1 = String.valueOf(e);
            r5.warning(new StringBuilder((String.valueOf(r6).length() + 16) + String.valueOf(r1).length()).append("Cannot access ").append(r6).append(": ").append(r1).toString());
        }

        private void scanJar(File r4, Set<File> r5, ImmutableSet.Builder<ResourceInfo> r6) throws IOException {
            JarFile r0 = new JarFile(r4);     // Catch: IOException -> L15
            UnmodifiableIterator<File> r7 = ClassPath.getClassPathFromManifest(r4, r0.getManifest()).iterator();     // Catch: Throwable -> L12
        L5:
            if (r7.hasNext() == false) goto L9;
            File r1 = r7.next();     // Catch: Throwable -> L12
            if (r5.add(r1.getCanonicalFile()) == false) goto L5;
            scan(r1, r5, r6);     // Catch: Throwable -> L12
            goto L5
        L9:
            scanJarFile(r0, r6);     // Catch: Throwable -> L12
            r0.close();     // Catch: IOException -> L16
            return;
        L31:
            return;
        L12:
            th = move-exception;
            r0.close();     // Catch: IOException -> L17
        L14:
            throw th;
        }

        private void scanJarFile(JarFile r5, ImmutableSet.Builder<ResourceInfo> r6) {
            Enumeration<JarEntry> r0 = r5.entries();
        L4:
            if (r0.hasMoreElements() == false) goto L11;
            JarEntry r1 = r0.nextElement();
            if (r1.isDirectory() == true) goto L4;
            if (r1.getName().equals("META-INF/MANIFEST.MF") == true) goto L4;
            r6.add(ResourceInfo.of(new File(r5.getName()), r1.getName(), this.classloader));
            goto L4
        }

        private void scanDirectory(File r3, ImmutableSet.Builder<ResourceInfo> r4) throws IOException {
            HashSet r0 = new HashSet();
            r0.add(r3.getCanonicalFile());
            scanDirectory(r3, "", r0, r4);
        }

        private void scanDirectory(File r7, String r8, Set<File> r9, ImmutableSet.Builder<ResourceInfo> r10) throws IOException {
            File[] r0 = r7.listFiles();
            if (r0 != null) goto L6;
            Logger r6 = ClassPath.access$000();
            String r11 = String.valueOf(r7);
            r6.warning(new StringBuilder(String.valueOf(r11).length() + 22).append("Cannot read directory ").append(r11).toString());
            return;
        L6:
            int r12 = r0.length;
            int r1 = 0;
        L7:
            if (r1 >= r12) goto L21;
            File r2 = r0[r1];
            String r3 = r2.getName();
            if (r2.isDirectory() == false) goto L13;
            File r4 = r2.getCanonicalFile();
            if (r9.add(r4) == false) goto L20;
            scanDirectory(r4, new StringBuilder((String.valueOf(r8).length() + 1) + String.valueOf(r3).length()).append(r8).append(r3).append(LibrarianImpl.Constants.SEPARATOR).toString(), r9, r10);
            r9.remove(r4);
        L20:
            r1 = r1 + 1;
            goto L7
        L13:
            String r5 = String.valueOf(r8);
            String r13 = String.valueOf(r3);
            if (r13.length() == 0) goto L16;
            String r14 = r5.concat(r13);
        L18:
            if (r14.equals("META-INF/MANIFEST.MF") == true) goto L20;
            r10.add(ResourceInfo.of(r2, r14, this.classloader));
            goto L20
        L16:
            r14 = new String(r5);
            goto L18
        }

        public boolean equals(@CheckForNull Object r4) {
            if ((r4 instanceof LocationInfo) == false) goto L10;
            LocationInfo r5 = (LocationInfo) r4;
            if (this.home.equals(r5.home) == true) goto L7;
            return false;
        L7:
            if (this.classloader.equals(r5.classloader) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            return this.home.hashCode();
        }

        public String toString() {
            return this.home.toString();
        }
    }

    public static class ResourceInfo {
        private final File file;
        final ClassLoader loader;
        private final String resourceName;

        static ResourceInfo of(File r1, String r2, ClassLoader r3) {
            if (r2.endsWith(ClassPath.CLASS_FILE_NAME_EXTENSION) == false) goto L7;
            return new ClassInfo(r1, r2, r3);
        L7:
            return new ResourceInfo(r1, r2, r3);
        }

        ResourceInfo(File r1, String r2, ClassLoader r3) {
            this.file = (File) Preconditions.checkNotNull(r1);
            this.resourceName = (String) Preconditions.checkNotNull(r2);
            this.loader = (ClassLoader) Preconditions.checkNotNull(r3);
        }

        public final URL url() {
            URL r0 = this.loader.getResource(this.resourceName);
            if (r0 == null) goto L6;
            return r0;
        L6:
            throw new NoSuchElementException(this.resourceName);
        }

        public final ByteSource asByteSource() {
            return Resources.asByteSource(url());
        }

        public final CharSource asCharSource(Charset r1) {
            return Resources.asCharSource(url(), r1);
        }

        public final String getResourceName() {
            return this.resourceName;
        }

        final File getFile() {
            return this.file;
        }

        public int hashCode() {
            return this.resourceName.hashCode();
        }

        public boolean equals(@CheckForNull Object r4) {
            if ((r4 instanceof ResourceInfo) == false) goto L10;
            ResourceInfo r5 = (ResourceInfo) r4;
            if (this.resourceName.equals(r5.resourceName) == true) goto L7;
            return false;
        L7:
            if (this.loader != r5.loader) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public String toString() {
            return this.resourceName;
        }
    }

    static /* synthetic */ Logger access$000() {
        return logger;
    }

    static {
        logger = Logger.getLogger(ClassPath.class.getName());
        CLASS_PATH_ATTRIBUTE_SEPARATOR = Splitter.on(HanziToPinyin.Token.SEPARATOR).omitEmptyStrings();
    }

    private ClassPath(ImmutableSet<ResourceInfo> r1) {
        this.resources = r1;
    }

    public static ClassPath from(ClassLoader r3) throws IOException {
        ImmutableSet<LocationInfo> r4 = locationsFrom(r3);
        HashSet r0 = new HashSet();
        UnmodifiableIterator<LocationInfo> r1 = r4.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(r1.next().file());
        goto L4
    L6:
        ImmutableSet.Builder r2 = ImmutableSet.builder();
        UnmodifiableIterator<LocationInfo> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L11;
        r2.addAll(r5.next().scanResources(r0));
        goto L8
    L11:
        return new ClassPath(r2.build());
    }

    public ImmutableSet<ResourceInfo> getResources() {
        return this.resources;
    }

    public ImmutableSet<ClassInfo> getAllClasses() {
        return FluentIterable.from(this.resources).filter(ClassInfo.class).toSet();
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses() {
        return FluentIterable.from(this.resources).filter(ClassInfo.class).filter(new AnonymousClass1(this)).toSet();
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses(String r4) {
        Preconditions.checkNotNull(r4);
        ImmutableSet.Builder r0 = ImmutableSet.builder();
        UnmodifiableIterator<ClassInfo> r3 = getTopLevelClasses().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        ClassInfo r1 = r3.next();
        if (r1.getPackageName().equals(r4) == false) goto L4;
        r0.add(r1);
        goto L4
    L9:
        return r0.build();
    }

    public ImmutableSet<ClassInfo> getTopLevelClassesRecursive(String r4) {
        Preconditions.checkNotNull(r4);
        String r5 = new StringBuilder(String.valueOf(r4).length() + 1).append(r4).append('.').toString();
        ImmutableSet.Builder r0 = ImmutableSet.builder();
        UnmodifiableIterator<ClassInfo> r3 = getTopLevelClasses().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        ClassInfo r1 = r3.next();
        if (r1.getName().startsWith(r5) == false) goto L4;
        r0.add(r1);
        goto L4
    L9:
        return r0.build();
    }

    static ImmutableSet<LocationInfo> locationsFrom(ClassLoader r4) {
        ImmutableSet.Builder r0 = ImmutableSet.builder();
        UnmodifiableIterator<Map.Entry<File, ClassLoader>> r5 = getClassPathEntries(r4).entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        Map.Entry<File, ClassLoader> r1 = r5.next();
        r0.add(new LocationInfo(r1.getKey(), r1.getValue()));
        goto L4
    L7:
        return r0.build();
    }

    static ImmutableSet<File> getClassPathFromManifest(File r5, @CheckForNull Manifest r6) {
        if (r6 == null) goto L4;
        ImmutableSet.Builder r0 = ImmutableSet.builder();
        String r7 = r6.getMainAttributes().getValue(Attributes.Name.CLASS_PATH.toString());
        if (r7 == null) goto L21;
        Iterator<String> r8 = CLASS_PATH_ATTRIBUTE_SEPARATOR.split(r7).iterator();
    L9:
        if (r8.hasNext() == false) goto L21;
        String r1 = r8.next();
        URL r2 = getClassPathEntry(r5, r1);     // Catch: MalformedURLException -> L15
        if (r2.getProtocol().equals("file") == false) goto L9;
        r0.add(toFile(r2));
    L15:
        Logger r3 = logger;
        String r4 = String.valueOf(r1);
        if (r4.length() == 0) goto L18;
        String r9 = "Invalid Class-Path entry: ".concat(r4);
    L19:
        r3.warning(r9);
        goto L9
    L18:
        r9 = new String("Invalid Class-Path entry: ");
    L21:
        return r0.build();
    L4:
        return ImmutableSet.of();
    }

    static ImmutableMap<File, ClassLoader> getClassPathEntries(ClassLoader r5) {
        LinkedHashMap r0 = Maps.newLinkedHashMap();
        ClassLoader r1 = r5.getParent();
        if (r1 == null) goto L5;
        r0.putAll(getClassPathEntries(r1));
    L5:
        UnmodifiableIterator<URL> r2 = getClassLoaderUrls(r5).iterator();
    L7:
        if (r2.hasNext() == false) goto L14;
        URL r3 = r2.next();
        if (r3.getProtocol().equals("file") == false) goto L7;
        File r4 = toFile(r3);
        if (r0.containsKey(r4) == true) goto L7;
        r0.put(r4, r5);
        goto L7
    L14:
        return ImmutableMap.copyOf(r0);
    }

    private static ImmutableList<URL> getClassLoaderUrls(ClassLoader r1) {
        if ((r1 instanceof URLClassLoader) == false) goto L7;
        return ImmutableList.copyOf(((URLClassLoader) r1).getURLs());
    L7:
        if (r1.equals(ClassLoader.getSystemClassLoader()) == false) goto L11;
        return parseJavaClassPath();
    L11:
        return ImmutableList.of();
    }

    static ImmutableList<URL> parseJavaClassPath() {
        ImmutableList.Builder r0 = ImmutableList.builder();
        Iterator<String> r1 = Splitter.on(StandardSystemProperty.PATH_SEPARATOR.value()).split(StandardSystemProperty.JAVA_CLASS_PATH.value()).iterator();
    L4:
        if (r1.hasNext() == false) goto L18;
        String r2 = r1.next();
        r0.add(new File(r2).toURI().toURL());     // Catch: MalformedURLException -> L8 SecurityException -> L10
    L8:
        e = move-exception;
        Logger r4 = logger;
        Level r5 = Level.WARNING;
        String r3 = String.valueOf(r2);
        if (r3.length() == 0) goto L15;
        String r6 = "malformed classpath entry: ".concat(r3);
    L16:
        r4.log(r5, r6, e);
        goto L4
    L15:
        r6 = new String("malformed classpath entry: ");
    L10:
        r0.add(new URL("file", null, new File(r2).getAbsolutePath()));     // Catch: MalformedURLException -> L8
        goto L4
    L18:
        return r0.build();
    }

    static URL getClassPathEntry(File r1, String r2) throws MalformedURLException {
        return new URL(r1.toURI().toURL(), r2);
    }

    static String getClassName(String r2) {
        return r2.substring(0, r2.length() - 6).replace(IOUtils.DIR_SEPARATOR_UNIX, '.');
    }

    static File toFile(URL r2) {
        Preconditions.checkArgument(r2.getProtocol().equals("file"));
        return new File(r2.toURI());
    L6:
        return new File(r2.getPath());
    }
}
