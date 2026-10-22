package okio.internal;

import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.Sink;
import okio.Source;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: ResourceFileSystem.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0018\u0010 \u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\nH\u0016J \u0010%\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020'2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\f\u0010(\u001a\u00020)*\u00020\nH\u0002R-\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\t0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006+"}, d2 = {"Lokio/internal/ResourceFileSystem;", "Lokio/FileSystem;", "classLoader", "Ljava/lang/ClassLoader;", "indexEagerly", "", "(Ljava/lang/ClassLoader;Z)V", "roots", "", "Lkotlin/Pair;", "Lokio/Path;", "getRoots", "()Ljava/util/List;", "roots$delegate", "Lkotlin/Lazy;", "appendingSink", "Lokio/Sink;", "file", "mustExist", "atomicMove", "", "source", "target", "canonicalize", "path", "canonicalizeInternal", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "listOrNull", "metadataOrNull", "Lokio/FileMetadata;", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "toRelativePath", "", "Companion", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResourceFileSystem extends FileSystem {
    private static final Companion Companion = null;

    @Deprecated
    private static final Path ROOT = null;
    private final Lazy roots$delegate;

    /* JADX INFO: compiled from: ResourceFileSystem.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u001c\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e0\r*\u00020\u0010J\u0018\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e*\u00020\u0012J\u0018\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e*\u00020\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lokio/internal/ResourceFileSystem$Companion;", "", "()V", "ROOT", "Lokio/Path;", "getROOT", "()Lokio/Path;", "keepPath", "", "path", "removeBase", TraceStatsConsts.STATS_BASE_MODULE, "toClasspathRoots", "", "Lkotlin/Pair;", "Lokio/FileSystem;", "Ljava/lang/ClassLoader;", "toFileRoot", "Ljava/net/URL;", "toJarRoot", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ boolean access$keepPath(Companion r0, Path r1) {
            return r0.keepPath(r1);
        }

        public final Path getROOT() {
            return ResourceFileSystem.access$getROOT$cp();
        }

        public final Path removeBase(Path r7, Path r8) {
            Intrinsics.checkNotNullParameter(r7, "<this>");
            Intrinsics.checkNotNullParameter(r8, TraceStatsConsts.STATS_BASE_MODULE);
            String r9 = r8.toString();
            return getROOT().resolve(StringsKt.replace$default(StringsKt.removePrefix(r7.toString(), r9), '\\', IOUtils.DIR_SEPARATOR_UNIX, false, 4, null));
        }

        public final List<Pair<FileSystem, Path>> toClasspathRoots(ClassLoader r6) {
            Intrinsics.checkNotNullParameter(r6, "<this>");
            Enumeration<URL> r5 = r6.getResources("");
            Intrinsics.checkNotNullExpressionValue(r5, "getResources(\"\")");
            ArrayList r7 = Collections.list(r5);
            Intrinsics.checkNotNullExpressionValue(r7, "list(this)");
            ArrayList r1 = new ArrayList();
            Iterator r8 = r7.iterator();
        L4:
            if (r8.hasNext() == false) goto L8;
            URL r2 = (URL) r8.next();
            Companion r4 = ResourceFileSystem.access$getCompanion$p();
            Intrinsics.checkNotNullExpressionValue(r2, "it");
            Pair<FileSystem, Path> r3 = r4.toFileRoot(r2);
            if (r3 == null) goto L4;
            r1.add(r3);
            goto L4
        L8:
            ArrayList r9 = r1;
            Enumeration<URL> r10 = r6.getResources("META-INF/MANIFEST.MF");
            Intrinsics.checkNotNullExpressionValue(r10, "getResources(\"META-INF/MANIFEST.MF\")");
            ArrayList r11 = Collections.list(r10);
            Intrinsics.checkNotNullExpressionValue(r11, "list(this)");
            ArrayList r12 = new ArrayList();
            Iterator r13 = r11.iterator();
        L10:
            if (r13.hasNext() == false) goto L15;
            URL r0 = (URL) r13.next();
            Companion r14 = ResourceFileSystem.access$getCompanion$p();
            Intrinsics.checkNotNullExpressionValue(r0, "it");
            Pair<FileSystem, Path> r15 = r14.toJarRoot(r0);
            if (r15 == null) goto L10;
            r12.add(r15);
            goto L10
        L15:
            return CollectionsKt.plus(r9, r12);
        }

        public final Pair<FileSystem, Path> toFileRoot(URL r5) {
            Intrinsics.checkNotNullParameter(r5, "<this>");
            if (Intrinsics.areEqual(r5.getProtocol(), "file") == true) goto L6;
            return null;
        L6:
            return TuplesKt.to(FileSystem.SYSTEM, Path.Companion.get$default(Path.Companion, new File(r5.toURI()), false, 1, null));
        }

        public final Pair<FileSystem, Path> toJarRoot(URL r11) {
            Intrinsics.checkNotNullParameter(r11, "<this>");
            String r12 = r11.toString();
            Intrinsics.checkNotNullExpressionValue(r12, "toString()");
            if (StringsKt.startsWith$default(r12, "jar:file:", false, 2, null) == true) goto L5;
            return null;
        L5:
            int r0 = StringsKt.lastIndexOf$default(r12, "!", 0, false, 6, null);
            if (r0 != (-1)) goto L8;
            return null;
        L8:
            Path.Companion r2 = Path.Companion;
            String r13 = r12.substring(4, r0);
            Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String…ing(startIndex, endIndex)");
            return TuplesKt.to(ZipKt.openZip(Path.Companion.get$default(r2, new File(URI.create(r13)), false, 1, null), FileSystem.SYSTEM, ResourceFileSystem$Companion$toJarRoot$zip$1.INSTANCE), getROOT());
        }

        private final boolean keepPath(Path r2) {
            return !StringsKt.endsWith(r2.name(), ".class", true);
        }
    }

    public static final /* synthetic */ Companion access$getCompanion$p() {
        return Companion;
    }

    public static final /* synthetic */ Path access$getROOT$cp() {
        return ROOT;
    }

    public ResourceFileSystem(final ClassLoader r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "classLoader");
        this.roots$delegate = LazyKt.lazy(new ResourceFileSystem$roots$2(r2));
        if (r3 == false) goto L6;
        getRoots().size();
        return;
    }

    private final List<Pair<FileSystem, Path>> getRoots() {
        return (List) this.roots$delegate.getValue();
    }

    @Override // okio.FileSystem
    public Path canonicalize(Path r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        return canonicalizeInternal(r2);
    }

    private final Path canonicalizeInternal(Path r2) {
        return ROOT.resolve(r2, true);
    }

    @Override // okio.FileSystem
    public List<Path> list(Path r11) {
        Intrinsics.checkNotNullParameter(r11, "dir");
        String r0 = toRelativePath(r11);
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator<Pair<FileSystem, Path>> r10 = getRoots().iterator();
        boolean r2 = false;
    L4:
        if (r10.hasNext() == false) goto L18;
        Pair<FileSystem, Path> r3 = r10.next();
        FileSystem r4 = r3.component1();
        Path r5 = r3.component2();
        LinkedHashSet r6 = r1;     // Catch: IOException -> L23
        List<Path> r7 = r4.list(r5.resolve(r0));     // Catch: IOException -> L23
        ArrayList r8 = new ArrayList();     // Catch: IOException -> L23
        Iterator<T> r9 = r7.iterator();     // Catch: IOException -> L23
    L8:
        if (r9.hasNext() == false) goto L12;
        Object r12 = r9.next();     // Catch: IOException -> L23
        if (Companion.access$keepPath(Companion, (Path) r12) == false) goto L8;
        r8.add(r12);     // Catch: IOException -> L23
        goto L8
    L12:
        ArrayList r13 = r8;     // Catch: IOException -> L23
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));     // Catch: IOException -> L23
        Iterator r15 = r13.iterator();     // Catch: IOException -> L23
    L14:
        if (r15.hasNext() == false) goto L16;
        r14.add(Companion.removeBase((Path) r15.next(), r5));     // Catch: IOException -> L23
        goto L14
    L16:
        CollectionsKt.addAll(r6, r14);     // Catch: IOException -> L23
        r2 = true;
        goto L4
    L18:
        if (r2 == false) goto L22;
        return CollectionsKt.toList(r1);
    L22:
        throw new FileNotFoundException("file not found: " + r11);
    }

    @Override // okio.FileSystem
    public List<Path> listOrNull(Path r9) {
        Intrinsics.checkNotNullParameter(r9, "dir");
        String r10 = toRelativePath(r9);
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<Pair<FileSystem, Path>> r8 = getRoots().iterator();
        boolean r1 = false;
    L3:
        ArrayList r3 = null;
        if (r8.hasNext() == false) goto L20;
        Pair<FileSystem, Path> r2 = r8.next();
        FileSystem r4 = r2.component1();
        Path r5 = r2.component2();
        List<Path> r6 = r4.listOrNull(r5.resolve(r10));
        if (r6 == null) goto L18;
        ArrayList r7 = new ArrayList();
        Iterator<T> r11 = r6.iterator();
    L9:
        if (r11.hasNext() == false) goto L13;
        Object r12 = r11.next();
        Companion r13 = Companion;
        if (Companion.access$keepPath(r13, (Path) r12) == false) goto L9;
        r7.add(r12);
        goto L9
    L13:
        ArrayList r14 = r7;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r16 = r14.iterator();
    L15:
        if (r16.hasNext() == false) goto L17;
        Path r17 = (Path) r16.next();
        r15.add(Companion.removeBase(r17, r5));
        goto L15
    L17:
        r3 = r15;
    L18:
        if (r3 == null) goto L3;
        CollectionsKt.addAll(r0, r3);
        r1 = true;
        goto L3
    L20:
        if (r1 == true) goto L22;
        return null;
    L22:
        return CollectionsKt.toList(r0);
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path r5) {
        Intrinsics.checkNotNullParameter(r5, "file");
        if (Companion.access$keepPath(Companion, r5) == false) goto L13;
        String r0 = toRelativePath(r5);
        Iterator<Pair<FileSystem, Path>> r4 = getRoots().iterator();
    L6:
        if (r4.hasNext() == false) goto L11;
        Pair<FileSystem, Path> r2 = r4.next();
        return r2.component1().openReadOnly(r2.component2().resolve(r0));
    L11:
        throw new FileNotFoundException("file not found: " + r5);
    L13:
        throw new FileNotFoundException("file not found: " + r5);
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "file");
        throw new IOException("resources are not writable");
    }

    @Override // okio.FileSystem
    public FileMetadata metadataOrNull(Path r4) {
        Intrinsics.checkNotNullParameter(r4, "path");
        if (Companion.access$keepPath(Companion, r4) == true) goto L5;
        return null;
    L5:
        String r5 = toRelativePath(r4);
        Iterator<Pair<FileSystem, Path>> r3 = getRoots().iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        Pair<FileSystem, Path> r0 = r3.next();
        FileMetadata r1 = r0.component1().metadataOrNull(r0.component2().resolve(r5));
        if (r1 == null) goto L7;
        return r1;
    L12:
        return null;
    }

    @Override // okio.FileSystem
    public Source source(Path r5) {
        Intrinsics.checkNotNullParameter(r5, "file");
        if (Companion.access$keepPath(Companion, r5) == false) goto L13;
        String r0 = toRelativePath(r5);
        Iterator<Pair<FileSystem, Path>> r4 = getRoots().iterator();
    L6:
        if (r4.hasNext() == false) goto L11;
        Pair<FileSystem, Path> r2 = r4.next();
        return r2.component1().source(r2.component2().resolve(r0));
    L11:
        throw new FileNotFoundException("file not found: " + r5);
    L13:
        throw new FileNotFoundException("file not found: " + r5);
    }

    @Override // okio.FileSystem
    public Sink sink(Path r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void createDirectory(Path r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "dir");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void atomicMove(Path r2, Path r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void delete(Path r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "path");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void createSymlink(Path r2, Path r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "target");
        throw new IOException(this + " is read-only");
    }

    private final String toRelativePath(Path r1) {
        return canonicalizeInternal(r1).relativeTo(ROOT).toString();
    }

    static {
        Companion = new Companion(null);
        ROOT = Path.Companion.get$default(Path.Companion, LibrarianImpl.Constants.SEPARATOR, false, 1, null);
    }
}
