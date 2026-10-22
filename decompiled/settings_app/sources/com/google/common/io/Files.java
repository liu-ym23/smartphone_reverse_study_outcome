package com.google.common.io;

import com.bytedance.librarian.LibrarianImpl;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import com.google.common.graph.SuccessorsFunction;
import com.google.common.graph.Traverser;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Files {
    private static final SuccessorsFunction<File> FILE_TREE = null;
    private static final int TEMP_DIR_ATTEMPTS = 10000;

    private static final class FileByteSink extends ByteSink {
        private final File file;
        private final ImmutableSet<FileWriteMode> modes;

        /* synthetic */ FileByteSink(File r1, FileWriteMode[] r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        @Override // com.google.common.io.ByteSink
        public /* bridge */ /* synthetic */ OutputStream openStream() throws IOException {
            return openStream();
        }

        private FileByteSink(File r1, FileWriteMode... r2) {
            this.file = (File) Preconditions.checkNotNull(r1);
            this.modes = ImmutableSet.copyOf(r2);
        }

        @Override // com.google.common.io.ByteSink
        public FileOutputStream openStream() throws IOException {
            return new FileOutputStream(this.file, this.modes.contains(FileWriteMode.APPEND));
        }

        public String toString() {
            String r0 = String.valueOf(this.file);
            String r3 = String.valueOf(this.modes);
            return new StringBuilder((String.valueOf(r0).length() + 20) + String.valueOf(r3).length()).append("Files.asByteSink(").append(r0).append(", ").append(r3).append(")").toString();
        }
    }

    private static final class FileByteSource extends ByteSource {
        private final File file;

        /* synthetic */ FileByteSource(File r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.io.ByteSource
        public /* bridge */ /* synthetic */ InputStream openStream() throws IOException {
            return openStream();
        }

        private FileByteSource(File r1) {
            this.file = (File) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.io.ByteSource
        public FileInputStream openStream() throws IOException {
            return new FileInputStream(this.file);
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            if (this.file.isFile() == false) goto L7;
            return Optional.of(Long.valueOf(this.file.length()));
        L7:
            return Optional.absent();
        }

        @Override // com.google.common.io.ByteSource
        public long size() throws IOException {
            if (this.file.isFile() == false) goto L7;
            return this.file.length();
        L7:
            throw new FileNotFoundException(this.file.toString());
        }

        @Override // com.google.common.io.ByteSource
        public byte[] read() throws IOException {
            Closer r0 = Closer.create();
            FileInputStream r3 = (FileInputStream) r0.register(openStream());     // Catch: Throwable -> L6
            byte[] r4 = ByteStreams.toByteArray(r3, r3.getChannel().size());     // Catch: Throwable -> L6
            r0.close();
            return r4;
        L6:
            th = move-exception;
        L9:
            th = move-exception;
            r0.close();
            throw th;
        L8:
            throw r0.rethrow(th);     // Catch: Throwable -> L9
        }

        public String toString() {
            String r2 = String.valueOf(this.file);
            return new StringBuilder(String.valueOf(r2).length() + 20).append("Files.asByteSource(").append(r2).append(")").toString();
        }
    }

    private static abstract enum FilePredicate extends Enum<FilePredicate> implements Predicate<File> {
        private static final /* synthetic */ FilePredicate[] $VALUES = null;
        public static final FilePredicate IS_DIRECTORY = null;
        public static final FilePredicate IS_FILE = null;

        private static /* synthetic */ FilePredicate[] $values() {
            return new FilePredicate[]{IS_DIRECTORY, IS_FILE};
        }

        private FilePredicate(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ FilePredicate(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static FilePredicate valueOf(String r1) {
            return (FilePredicate) Enum.valueOf(FilePredicate.class, r1);
        }

        public static FilePredicate[] values() {
            return (FilePredicate[]) $VALUES.clone();
        }

        static {
            final String r1 = "IS_DIRECTORY";
            final int r2 = 0;
            IS_DIRECTORY = new AnonymousClass1(r1, r2);
            final String r3 = "IS_FILE";
            final int r4 = 1;
            IS_FILE = new AnonymousClass2(r3, r4);
            $VALUES = $values();
        }
    }

    private Files() {
    }

    public static BufferedReader newReader(File r3, Charset r4) throws FileNotFoundException {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        return new BufferedReader(new InputStreamReader(new FileInputStream(r3), r4));
    }

    public static BufferedWriter newWriter(File r3, Charset r4) throws FileNotFoundException {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(r3), r4));
    }

    public static ByteSource asByteSource(File r2) {
        return new FileByteSource(r2, null);
    }

    public static ByteSink asByteSink(File r2, FileWriteMode... r3) {
        return new FileByteSink(r2, r3, null);
    }

    public static CharSource asCharSource(File r0, Charset r1) {
        return asByteSource(r0).asCharSource(r1);
    }

    public static CharSink asCharSink(File r0, Charset r1, FileWriteMode... r2) {
        return asByteSink(r0, r2).asCharSink(r1);
    }

    public static byte[] toByteArray(File r0) throws IOException {
        return asByteSource(r0).read();
    }

    @Deprecated
    public static String toString(File r0, Charset r1) throws IOException {
        return asCharSource(r0, r1).read();
    }

    public static void write(byte[] r1, File r2) throws IOException {
        asByteSink(r2, new FileWriteMode[0]).write(r1);
    }

    @Deprecated
    public static void write(CharSequence r1, File r2, Charset r3) throws IOException {
        asCharSink(r2, r3, new FileWriteMode[0]).write(r1);
    }

    public static void copy(File r0, OutputStream r1) throws IOException {
        asByteSource(r0).copyTo(r1);
    }

    public static void copy(File r2, File r3) throws IOException {
        Preconditions.checkArgument(!r2.equals(r3), "Source %s and destination %s must be different", r2, r3);
        asByteSource(r2).copyTo(asByteSink(r3, new FileWriteMode[0]));
    }

    @Deprecated
    public static void copy(File r0, Charset r1, Appendable r2) throws IOException {
        asCharSource(r0, r1).copyTo(r2);
    }

    @Deprecated
    public static void append(CharSequence r3, File r4, Charset r5) throws IOException {
        asCharSink(r4, r5, new FileWriteMode[]{FileWriteMode.APPEND}).write(r3);
    }

    public static boolean equal(File r7, File r8) throws IOException {
        Preconditions.checkNotNull(r7);
        Preconditions.checkNotNull(r8);
        if (r7 != r8) goto L5;
        return true;
    L5:
        if (r7.equals(r8) == true) goto L19;
        long r0 = r7.length();
        long r2 = r8.length();
        if (r0 == 0) goto L16;
        if (r2 == 0) goto L16;
        if (r0 == r2) goto L16;
        return false;
    L16:
        return asByteSource(r7).contentEquals(asByteSource(r8));
    L19:
        return true;
    }

    @Deprecated
    public static File createTempDir() {
        File r0 = new File(System.getProperty("java.io.tmpdir"));
        long r1 = System.currentTimeMillis();
        String r2 = new StringBuilder(21).append(r1).append("-").toString();
        int r3 = 0;
    L4:
        if (r3 >= 10000) goto L10;
        File r4 = new File(r0, new StringBuilder(String.valueOf(r2).length() + 11).append(r2).append(r3).toString());
        if (r4.mkdir() == true) goto L7;
        r3 = r3 + 1;
        goto L4
    L7:
        return r4;
    L10:
        throw new IllegalStateException(new StringBuilder((String.valueOf(r2).length() + 66) + String.valueOf(r2).length()).append("Failed to create directory within 10000 attempts (tried ").append(r2).append("0 to ").append(r2).append("9999)").toString());
    }

    public static void touch(File r3) throws IOException {
        Preconditions.checkNotNull(r3);
        if (r3.createNewFile() == false) goto L5;
        return;
    L5:
        if (r3.setLastModified(System.currentTimeMillis()) == true) goto L10;
        String r4 = String.valueOf(r3);
        throw new IOException(new StringBuilder(String.valueOf(r4).length() + 38).append("Unable to update modification time of ").append(r4).toString());
    }

    public static void createParentDirs(File r3) throws IOException {
        Preconditions.checkNotNull(r3);
        File r0 = r3.getCanonicalFile().getParentFile();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.mkdirs();
        if (r0.isDirectory() == false) goto L8;
        return;
    L8:
        String r4 = String.valueOf(r3);
        throw new IOException(new StringBuilder(String.valueOf(r4).length() + 39).append("Unable to create parent directories of ").append(r4).toString());
    }

    public static void move(File r3, File r4) throws IOException {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        Preconditions.checkArgument(!r3.equals(r4), "Source %s and destination %s must be different", r3, r4);
        if (r3.renameTo(r4) == true) goto L12;
        copy(r3, r4);
        if (r3.delete() == false) goto L7;
        return;
    L7:
        if (r4.delete() == true) goto L10;
        String r5 = String.valueOf(r4);
        throw new IOException(new StringBuilder(String.valueOf(r5).length() + 17).append("Unable to delete ").append(r5).toString());
    L10:
        String r6 = String.valueOf(r3);
        throw new IOException(new StringBuilder(String.valueOf(r6).length() + 17).append("Unable to delete ").append(r6).toString());
    }

    @CheckForNull
    @Deprecated
    public static String readFirstLine(File r0, Charset r1) throws IOException {
        return asCharSource(r0, r1).readFirstLine();
    }

    public static List<String> readLines(File r0, Charset r1) throws IOException {
        return (List) asCharSource(r0, r1).readLines(new AnonymousClass1());
    }

    @ParametricNullness
    @Deprecated
    public static <T> T readLines(File r0, Charset r1, LineProcessor<T> r2) throws IOException {
        return (T) asCharSource(r0, r1).readLines(r2);
    }

    @ParametricNullness
    @Deprecated
    public static <T> T readBytes(File r0, ByteProcessor<T> r1) throws IOException {
        return (T) asByteSource(r0).read(r1);
    }

    @Deprecated
    public static HashCode hash(File r0, HashFunction r1) throws IOException {
        return asByteSource(r0).hash(r1);
    }

    public static MappedByteBuffer map(File r1) throws IOException {
        Preconditions.checkNotNull(r1);
        return map(r1, FileChannel.MapMode.READ_ONLY);
    }

    public static MappedByteBuffer map(File r2, FileChannel.MapMode r3) throws IOException {
        return mapInternal(r2, r3, -1);
    }

    public static MappedByteBuffer map(File r2, FileChannel.MapMode r3, long r4) throws IOException {
        if (r4 < 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "size (%s) may not be negative", r4);
        return mapInternal(r2, r3, r4);
    L5:
        r0 = false;
        goto L6
    }

    private static MappedByteBuffer mapInternal(File r7, FileChannel.MapMode r8, long r9) throws IOException {
        Preconditions.checkNotNull(r7);
        Preconditions.checkNotNull(r8);
        Closer r0 = Closer.create();
    L13:
        th = move-exception;
    L16:
        th = move-exception;
        r0.close();
        throw th;
    L15:
        throw r0.rethrow(th);     // Catch: Throwable -> L16
    L4:
        if (r8 != FileChannel.MapMode.READ_ONLY) goto L6;
        String r2 = "r";
    L7:
        FileChannel r1 = (FileChannel) r0.register(((RandomAccessFile) r0.register(new RandomAccessFile(r7, r2))).getChannel());     // Catch: Throwable -> L13
        if (r9 != (-1)) goto L10;
        r9 = r1.size();     // Catch: Throwable -> L13
    L10:
        MappedByteBuffer r10 = r1.map(r8, 0, r9);     // Catch: Throwable -> L13
        r0.close();
        return r10;
    L6:
        r2 = "rw";
        goto L7
    }

    public static String simplifyPath(String r7) {
        Preconditions.checkNotNull(r7);
        if (r7.length() != 0) goto L5;
        return ".";
    L5:
        Iterable<String> r2 = Splitter.on(IOUtils.DIR_SEPARATOR_UNIX).omitEmptyStrings().split(r7);
        ArrayList r3 = new ArrayList();
        Iterator<String> r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L19;
        String r5 = r4.next();
        r5.hashCode();
        if (r5.equals(".") == true) goto L7;
        if (r5.equals("..") == false) goto L12;
        if (r3.size() <= 0) goto L18;
        if (((String) r3.get(r3.size() - 1)).equals("..") == true) goto L18;
        r3.remove(r3.size() - 1);
    L18:
        r3.add("..");
        goto L7
    L12:
        r3.add(r5);
        goto L7
    L19:
        String r6 = Joiner.on(IOUtils.DIR_SEPARATOR_UNIX).join(r3);
        if (r7.charAt(0) != '/') goto L27;
        String r8 = String.valueOf(r6);
        if (r8.length() == 0) goto L24;
        String r9 = LibrarianImpl.Constants.SEPARATOR.concat(r8);
    L25:
        r6 = r9;
        goto L27
    L24:
        r9 = new String(LibrarianImpl.Constants.SEPARATOR);
    L27:
        if (r6.startsWith("/../") == false) goto L30;
        r6 = r6.substring(3);
        goto L27
    L30:
        if (r6.equals("/..") == false) goto L33;
        return LibrarianImpl.Constants.SEPARATOR;
    L33:
        if ("".equals(r6) == false) goto L36;
        return ".";
    L36:
        return r6;
    }

    public static String getFileExtension(String r2) {
        Preconditions.checkNotNull(r2);
        String r3 = new File(r2).getName();
        int r0 = r3.lastIndexOf(46);
        if (r0 != (-1)) goto L6;
        return "";
    L6:
        return r3.substring(r0 + 1);
    }

    public static String getNameWithoutExtension(String r2) {
        Preconditions.checkNotNull(r2);
        String r3 = new File(r2).getName();
        int r0 = r3.lastIndexOf(46);
        if (r0 != (-1)) goto L6;
        return r3;
    L6:
        return r3.substring(0, r0);
    }

    public static Traverser<File> fileTraverser() {
        return Traverser.forTree(FILE_TREE);
    }

    static {
        FILE_TREE = new AnonymousClass2();
    }

    public static Predicate<File> isDirectory() {
        return FilePredicate.IS_DIRECTORY;
    }

    public static Predicate<File> isFile() {
        return FilePredicate.IS_FILE;
    }
}
