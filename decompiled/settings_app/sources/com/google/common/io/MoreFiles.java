package com.google.common.io;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.graph.SuccessorsFunction;
import com.google.common.graph.Traverser;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemException;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class MoreFiles {
    private static final SuccessorsFunction<Path> FILE_TREE = null;

    private static final class PathByteSink extends ByteSink {
        private final OpenOption[] options;
        private final Path path;

        /* synthetic */ PathByteSink(Path r1, OpenOption[] r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private PathByteSink(Path r1, OpenOption... r2) {
            this.path = (Path) Preconditions.checkNotNull(r1);
            this.options = (OpenOption[]) r2.clone();
        }

        @Override // com.google.common.io.ByteSink
        public OutputStream openStream() throws IOException {
            return java.nio.file.Files.newOutputStream(this.path, this.options);
        }

        public String toString() {
            String r0 = String.valueOf(this.path);
            String r3 = Arrays.toString(this.options);
            return new StringBuilder((String.valueOf(r0).length() + 24) + String.valueOf(r3).length()).append("MoreFiles.asByteSink(").append(r0).append(", ").append(r3).append(")").toString();
        }
    }

    private static final class PathByteSource extends ByteSource {
        private static final LinkOption[] FOLLOW_LINKS = null;
        private final boolean followLinks;
        private final OpenOption[] options;
        private final Path path;

        /* synthetic */ PathByteSource(Path r1, OpenOption[] r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ Path access$100(PathByteSource r0) {
            return r0.path;
        }

        static {
            FOLLOW_LINKS = new LinkOption[0];
        }

        private PathByteSource(Path r1, OpenOption... r2) {
            this.path = (Path) Preconditions.checkNotNull(r1);
            OpenOption[] r3 = (OpenOption[]) r2.clone();
            this.options = r3;
            this.followLinks = followLinks(r3);
        }

        private static boolean followLinks(OpenOption[] r5) {
            int r0 = r5.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L8;
            if (r5[r2] == LinkOption.NOFOLLOW_LINKS) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return false;
        L8:
            return true;
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return java.nio.file.Files.newInputStream(this.path, this.options);
        }

        private BasicFileAttributes readAttributes() throws IOException {
            Path r0 = this.path;
            if (this.followLinks == false) goto L5;
            LinkOption[] r4 = FOLLOW_LINKS;
        L7:
            return java.nio.file.Files.readAttributes(r0, BasicFileAttributes.class, r4);
        L5:
            r4 = new LinkOption[]{LinkOption.NOFOLLOW_LINKS};
            goto L7
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            BasicFileAttributes r2 = readAttributes();     // Catch: IOException -> L12
            if (r2.isDirectory() == true) goto L11;
            if (r2.isSymbolicLink() == true) goto L11;
            return Optional.of(Long.valueOf(r2.size()));
        L11:
            return Optional.absent();
        L13:
            return Optional.absent();
        }

        @Override // com.google.common.io.ByteSource
        public long size() throws IOException {
            BasicFileAttributes r2 = readAttributes();
            if (r2.isDirectory() == true) goto L11;
            if (r2.isSymbolicLink() == true) goto L9;
            return r2.size();
        L9:
            throw new IOException("can't read: is a symbolic link");
        L11:
            throw new IOException("can't read: is a directory");
        }

        @Override // com.google.common.io.ByteSource
        public byte[] read() throws IOException {
            SeekableByteChannel r3 = java.nio.file.Files.newByteChannel(this.path, this.options);
            byte[] r0 = ByteStreams.toByteArray(Channels.newInputStream(r3), r3.size());     // Catch: Throwable -> L7
            if (r3 == null) goto L6;
            r3.close();
        L6:
            return r0;
        L7:
            th = move-exception;
            if (r3 != null) goto L14;
        L13:
            throw th;
        L14:
            r3.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }

        @Override // com.google.common.io.ByteSource
        public CharSource asCharSource(final Charset r2) {
            if (this.options.length != 0) goto L7;
            return new AnonymousClass1(this, r2);
        L7:
            return super.asCharSource(r2);
        }

        public String toString() {
            String r0 = String.valueOf(this.path);
            String r3 = Arrays.toString(this.options);
            return new StringBuilder((String.valueOf(r0).length() + 26) + String.valueOf(r3).length()).append("MoreFiles.asByteSource(").append(r0).append(", ").append(r3).append(")").toString();
        }
    }

    static /* synthetic */ Iterable access$300(Path r0) {
        return fileTreeChildren(r0);
    }

    private MoreFiles() {
    }

    public static ByteSource asByteSource(Path r2, OpenOption... r3) {
        return new PathByteSource(r2, r3, null);
    }

    public static ByteSink asByteSink(Path r2, OpenOption... r3) {
        return new PathByteSink(r2, r3, null);
    }

    public static CharSource asCharSource(Path r0, Charset r1, OpenOption... r2) {
        return asByteSource(r0, r2).asCharSource(r1);
    }

    public static CharSink asCharSink(Path r0, Charset r1, OpenOption... r2) {
        return asByteSink(r0, r2).asCharSink(r1);
    }

    public static ImmutableList<Path> listFiles(Path r1) throws IOException {
        DirectoryStream<Path> r2 = java.nio.file.Files.newDirectoryStream(r1);     // Catch: DirectoryIteratorException -> L14
        ImmutableList<Path> r0 = ImmutableList.copyOf(r2);     // Catch: Throwable -> L7
        if (r2 == null) goto L6;
        r2.close();     // Catch: DirectoryIteratorException -> L14
    L6:
        return r0;
    L7:
        th = move-exception;
        if (r2 != null) goto L17;
    L13:
        throw th;     // Catch: DirectoryIteratorException -> L14
    L17:
        r2.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: DirectoryIteratorException -> L14
    L14:
        e = move-exception;
        throw e.getCause();
    }

    public static Traverser<Path> fileTraverser() {
        return Traverser.forTree(FILE_TREE);
    }

    static {
        FILE_TREE = new AnonymousClass1();
    }

    private static Iterable<Path> fileTreeChildren(Path r3) {
        if (java.nio.file.Files.isDirectory(r3, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}) == false) goto L10;
        return listFiles(r3);
    L6:
        e = move-exception;
        throw new DirectoryIteratorException(e);
    L10:
        return ImmutableList.of();
    }

    public static Predicate<Path> isDirectory(LinkOption... r1) {
        final LinkOption[] r2 = (LinkOption[]) r1.clone();
        return new AnonymousClass2(r2);
    }

    private static boolean isDirectory(SecureDirectoryStream<Path> r1, Path r2, LinkOption... r3) throws IOException {
        return ((BasicFileAttributeView) r1.getFileAttributeView(r2, BasicFileAttributeView.class, r3)).readAttributes().isDirectory();
    }

    public static Predicate<Path> isRegularFile(LinkOption... r1) {
        final LinkOption[] r2 = (LinkOption[]) r1.clone();
        return new AnonymousClass3(r2);
    }

    public static boolean equal(Path r8, Path r9) throws IOException {
        Preconditions.checkNotNull(r8);
        Preconditions.checkNotNull(r9);
        if (java.nio.file.Files.isSameFile(r8, r9) == false) goto L6;
        return true;
    L6:
        ByteSource r10 = asByteSource(r8, new OpenOption[0]);
        ByteSource r11 = asByteSource(r9, new OpenOption[0]);
        long r4 = r10.sizeIfKnown().or(0L).longValue();
        long r6 = r11.sizeIfKnown().or(0L).longValue();
        if (r4 == 0) goto L14;
        if (r6 == 0) goto L14;
        if (r4 == r6) goto L14;
        return false;
    L14:
        return r10.contentEquals(r11);
    }

    public static void touch(Path r2) throws IOException {
        Preconditions.checkNotNull(r2);
        java.nio.file.Files.setLastModifiedTime(r2, FileTime.fromMillis(System.currentTimeMillis()));     // Catch: NoSuchFileException -> L5
        return;
    L11:
        java.nio.file.Files.createFile(r2, new FileAttribute[0]);     // Catch: FileAlreadyExistsException -> L8
        return;
    }

    public static void createParentDirectories(Path r3, FileAttribute<?>... r4) throws IOException {
        Path r0 = r3.toAbsolutePath().normalize().getParent();
        if (r0 != null) goto L6;
        return;
    L6:
        if (java.nio.file.Files.isDirectory(r0, new LinkOption[0]) == true) goto L12;
        java.nio.file.Files.createDirectories(r0, r4);
        if (java.nio.file.Files.isDirectory(r0, new LinkOption[0]) == true) goto L13;
        String r5 = String.valueOf(r3);
        throw new IOException(new StringBuilder(String.valueOf(r5).length() + 39).append("Unable to create parent directories of ").append(r5).toString());
    L13:
        return;
    }

    public static String getFileExtension(Path r3) {
        Path r4 = r3.getFileName();
        if (r4 != null) goto L5;
        return "";
    L5:
        String r5 = r4.toString();
        int r1 = r5.lastIndexOf(46);
        if (r1 != (-1)) goto L9;
        return "";
    L9:
        return r5.substring(r1 + 1);
    }

    public static String getNameWithoutExtension(Path r2) {
        Path r3 = r2.getFileName();
        if (r3 != null) goto L6;
        return "";
    L6:
        String r4 = r3.toString();
        int r0 = r4.lastIndexOf(46);
        if (r0 != (-1)) goto L10;
        return r4;
    L10:
        return r4.substring(0, r0);
    }

    public static void deleteRecursively(Path r4, RecursiveDeleteOption... r5) throws IOException {
        Path r0 = getParentPath(r4);
        Collection<IOException> r1 = null;
        if (r0 == null) goto L30;
        DirectoryStream<Path> r2 = java.nio.file.Files.newDirectoryStream(r0);     // Catch: IOException -> L22
    L15:
        th = move-exception;
        if (r2 != null) goto L33;
    L21:
        throw th;     // Catch: IOException -> L22
    L33:
        r2.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L22
        goto L21
    L6:
        if ((r2 instanceof SecureDirectoryStream) == false) goto L9;
        r1 = deleteRecursivelySecure((SecureDirectoryStream) r2, (Path) Objects.requireNonNull(r4.getFileName()));     // Catch: Throwable -> L15
        boolean r3 = true;
    L10:
        if (r2 == null) goto L12;
        r2.close();     // Catch: IOException -> L22
    L12:
        if (r3 == true) goto L25;
        checkAllowsInsecure(r4, r5);     // Catch: IOException -> L22
        r1 = deleteRecursivelyInsecure(r4);     // Catch: IOException -> L22
    L25:
        if (r1 == null) goto L36;
        throwDeleteFailed(r4, r1);
        return;
    L36:
        return;
    L9:
        r3 = false;
    L22:
        e = move-exception;
        if (r1 == null) goto L28;
        r1.add(e);
        goto L25
    L28:
        throw e;
    L30:
        throw new FileSystemException(r4.toString(), null, "can't delete recursively");
    }

    public static void deleteDirectoryContents(Path r3, RecursiveDeleteOption... r4) throws IOException {
        Collection<IOException> r0 = null;
        DirectoryStream<Path> r1 = java.nio.file.Files.newDirectoryStream(r3);     // Catch: IOException -> L19
    L12:
        th = move-exception;
        if (r1 != null) goto L26;
    L18:
        throw th;     // Catch: IOException -> L19
    L26:
        r1.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L19
        goto L18
    L5:
        if ((r1 instanceof SecureDirectoryStream) == false) goto L7;
        Collection<IOException> r5 = deleteDirectoryContentsSecure((SecureDirectoryStream) r1);     // Catch: Throwable -> L12
    L8:
        r0 = r5;
        if (r1 == null) goto L22;
        r1.close();     // Catch: IOException -> L19
    L22:
        if (r0 == null) goto L30;
        throwDeleteFailed(r3, r0);
        return;
    L30:
        return;
    L7:
        checkAllowsInsecure(r3, r4);     // Catch: Throwable -> L12
        r5 = deleteDirectoryContentsInsecure(r1);     // Catch: Throwable -> L12
    L19:
        e = move-exception;
        if (0 == 0) goto L25;
        r0.add(e);
        goto L22
    L25:
        throw e;
    }

    @CheckForNull
    private static Collection<IOException> deleteRecursivelySecure(SecureDirectoryStream<Path> r5, Path r6) {
        Collection<IOException> r1 = null;
    L21:
        e = move-exception;
        return addException(r1, e);
    L4:
        if (isDirectory(r5, r6, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}) == false) goto L19;
        SecureDirectoryStream<Path> r0 = r5.newDirectoryStream(r6, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});     // Catch: IOException -> L21
        r1 = deleteDirectoryContentsSecure(r0);     // Catch: Throwable -> L12
        if (r0 == null) goto L9;
        r0.close();     // Catch: IOException -> L21
    L9:
        if (r1 != null) goto L20;
        r5.deleteDirectory(r6);     // Catch: IOException -> L21
    L20:
        return r1;
    L12:
        th = move-exception;
        if (r0 != null) goto L27;
    L18:
        throw th;     // Catch: IOException -> L21
    L27:
        r0.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L21
        goto L18
    L19:
        r5.deleteFile(r6);     // Catch: IOException -> L21
        goto L20
    }

    @CheckForNull
    private static Collection<IOException> deleteDirectoryContentsSecure(SecureDirectoryStream<Path> r3) {
        Collection<IOException> r0 = null;
        Iterator<Path> r1 = r3.iterator();     // Catch: DirectoryIteratorException -> L9
    L5:
        if (r1.hasNext() == false) goto L8;
        r0 = concat(r0, deleteRecursivelySecure(r3, r1.next().getFileName()));     // Catch: DirectoryIteratorException -> L9
        goto L5
    L8:
        return r0;
    L9:
        e = move-exception;
        return addException(null, e.getCause());
    }

    @CheckForNull
    private static Collection<IOException> deleteRecursivelyInsecure(Path r4) {
        Collection<IOException> r1 = null;
    L20:
        e = move-exception;
        return addException(r1, e);
    L4:
        if (java.nio.file.Files.isDirectory(r4, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}) == false) goto L17;
        DirectoryStream<Path> r0 = java.nio.file.Files.newDirectoryStream(r4);     // Catch: IOException -> L20
        r1 = deleteDirectoryContentsInsecure(r0);     // Catch: Throwable -> L10
        if (r0 == null) goto L17;
        r0.close();     // Catch: IOException -> L20
        goto L17
    L10:
        th = move-exception;
        if (r0 != null) goto L23;
    L16:
        throw th;     // Catch: IOException -> L20
    L23:
        r0.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L20
    L17:
        if (r1 != null) goto L19;
        java.nio.file.Files.delete(r4);     // Catch: IOException -> L20
    L19:
        return r1;
    }

    @CheckForNull
    private static Collection<IOException> deleteDirectoryContentsInsecure(DirectoryStream<Path> r2) {
        Collection<IOException> r0 = null;
        Iterator<Path> r3 = r2.iterator();     // Catch: DirectoryIteratorException -> L9
    L5:
        if (r3.hasNext() == false) goto L8;
        r0 = concat(r0, deleteRecursivelyInsecure(r3.next()));     // Catch: DirectoryIteratorException -> L9
        goto L5
    L8:
        return r0;
    L9:
        e = move-exception;
        return addException(null, e.getCause());
    }

    @CheckForNull
    private static Path getParentPath(Path r2) {
        Path r0 = r2.getParent();
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (r2.getNameCount() != 0) goto L10;
        return null;
    L10:
        return r2.getFileSystem().getPath(".", new String[0]);
    }

    private static void checkAllowsInsecure(Path r1, RecursiveDeleteOption[] r2) throws InsecureRecursiveDeleteException {
        if (Arrays.asList(r2).contains(RecursiveDeleteOption.ALLOW_INSECURE) == false) goto L6;
        return;
    L6:
        throw new InsecureRecursiveDeleteException(r1.toString());
    }

    private static Collection<IOException> addException(@CheckForNull Collection<IOException> r0, IOException r1) {
        if (r0 != null) goto L4;
        r0 = new ArrayList();
    L4:
        r0.add(r1);
        return r0;
    }

    @CheckForNull
    private static Collection<IOException> concat(@CheckForNull Collection<IOException> r0, @CheckForNull Collection<IOException> r1) {
        if (r0 != null) goto L4;
        return r1;
    L4:
        if (r1 == null) goto L6;
        r0.addAll(r1);
    L6:
        return r0;
    }

    private static void throwDeleteFailed(Path r3, Collection<IOException> r4) throws FileSystemException {
        NoSuchFileException r0 = pathNotFound(r3, r4);
        if (r0 != null) goto L9;
        FileSystemException r1 = new FileSystemException(r3.toString(), null, "failed to delete one or more files; see suppressed exceptions for details");
        Iterator<IOException> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        r1.addSuppressed(r5.next());
        goto L6
    L8:
        throw r1;
    L9:
        throw r0;
    }

    @CheckForNull
    private static NoSuchFileException pathNotFound(Path r3, Collection<IOException> r4) {
        if (r4.size() == 1) goto L5;
        return null;
    L5:
        IOException r5 = (IOException) Iterables.getOnlyElement(r4);
        if ((r5 instanceof NoSuchFileException) == true) goto L8;
        return null;
    L8:
        NoSuchFileException r6 = (NoSuchFileException) r5;
        String r0 = r6.getFile();
        if (r0 != null) goto L11;
        return null;
    L11:
        Path r1 = getParentPath(r3);
        if (r1 != null) goto L15;
        return null;
    L15:
        if (r0.equals(r1.resolve((Path) Objects.requireNonNull(r3.getFileName())).toString()) == false) goto L17;
        return r6;
    L17:
        return null;
    }
}
