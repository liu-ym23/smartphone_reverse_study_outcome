package org.apache.commons.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.output.NullOutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class FileUtils {
    public static final File[] EMPTY_FILE_ARRAY = null;
    public static final long ONE_GB = 1073741824;
    public static final long ONE_KB = 1024;
    public static final long ONE_MB = 1048576;

    public FileUtils() {
    }

    static {
        EMPTY_FILE_ARRAY = new File[0];
    }

    public static FileInputStream openInputStream(File r3) throws IOException {
        if (r3.exists() == false) goto L15;
        if (r3.isDirectory() == true) goto L13;
        if (r3.canRead() == false) goto L11;
        return new FileInputStream(r3);
    L11:
        throw new IOException(new StringBuffer("File '").append(r3).append("' cannot be read").toString());
    L13:
        throw new IOException(new StringBuffer("File '").append(r3).append("' exists but is a directory").toString());
    L15:
        throw new FileNotFoundException(new StringBuffer("File '").append(r3).append("' does not exist").toString());
    }

    public static FileOutputStream openOutputStream(File r3) throws IOException {
        if (r3.exists() == true) goto L5;
        File r0 = r3.getParentFile();
        if (r0 != null) goto L16;
    L23:
        return new FileOutputStream(r3);
    L16:
        if (r0.exists() == true) goto L23;
        if (r0.mkdirs() == true) goto L23;
        throw new IOException(new StringBuffer("File '").append(r3).append("' could not be created").toString());
    L5:
        if (r3.isDirectory() == true) goto L12;
        if (r3.canWrite() == true) goto L23;
        throw new IOException(new StringBuffer("File '").append(r3).append("' cannot be written to").toString());
    L12:
        throw new IOException(new StringBuffer("File '").append(r3).append("' exists but is a directory").toString());
    }

    public static String byteCountToDisplaySize(long r5) {
        long r0 = r5 / ONE_GB;
        if (r0 > 0) goto L13;
        long r1 = r5 / 1048576;
        if (r1 > 0) goto L14;
        long r2 = r5 / 1024;
        if (r2 <= 0) goto L12;
        return new StringBuffer().append(String.valueOf(r2)).append(" KB").toString();
    L12:
        return new StringBuffer().append(String.valueOf(r5)).append(" bytes").toString();
    L14:
        return new StringBuffer().append(String.valueOf(r1)).append(" MB").toString();
    L13:
        return new StringBuffer().append(String.valueOf(r0)).append(" GB").toString();
    }

    public static void touch(File r3) throws IOException {
        if (r3.exists() == true) goto L6;
        IOUtils.closeQuietly(openOutputStream(r3));
    L6:
        if (r3.setLastModified(System.currentTimeMillis()) == false) goto L9;
        return;
    L9:
        throw new IOException(new StringBuffer("Unable to set the last modification time for ").append(r3).toString());
    }

    public static File[] convertFileCollectionToFileArray(Collection r1) {
        return (File[]) r1.toArray(new File[r1.size()]);
    }

    private static void innerListFiles(Collection r2, File r3, IOFileFilter r4) {
        File[] r5 = r3.listFiles(r4);
        if (r5 == null) goto L12;
        int r0 = 0;
    L6:
        if (r0 >= r5.length) goto L16;
        if (r5[r0].isDirectory() == false) goto L10;
        innerListFiles(r2, r5[r0], r4);
    L11:
        r0 = r0 + 1;
        goto L6
    L10:
        r2.add(r5[r0]);
        goto L11
    L16:
        return;
    }

    public static Collection listFiles(File r1, IOFileFilter r2, IOFileFilter r3) {
        if (r1.isDirectory() == false) goto L14;
        if (r2 == null) goto L12;
        IOFileFilter r4 = FileFilterUtils.andFileFilter(r2, FileFilterUtils.notFileFilter(DirectoryFileFilter.INSTANCE));
        if (r3 != null) goto L8;
        IOFileFilter r5 = FalseFileFilter.INSTANCE;
    L9:
        LinkedList r0 = new LinkedList();
        innerListFiles(r0, r1, FileFilterUtils.orFileFilter(r4, r5));
        return r0;
    L8:
        r5 = FileFilterUtils.andFileFilter(r3, DirectoryFileFilter.INSTANCE);
        goto L9
    L12:
        throw new NullPointerException("Parameter 'fileFilter' is null");
    L14:
        throw new IllegalArgumentException("Parameter 'directory' is not a directory");
    }

    public static Iterator iterateFiles(File r0, IOFileFilter r1, IOFileFilter r2) {
        return listFiles(r0, r1, r2).iterator();
    }

    private static String[] toSuffixes(String[] r4) {
        String[] r0 = new String[r4.length];
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L6;
        r0[r1] = new StringBuffer(".").append(r4[r1]).toString();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static Collection listFiles(File r1, String[] r2, boolean r3) {
        if (r2 != null) goto L4;
        IOFileFilter r4 = TrueFileFilter.INSTANCE;
    L5:
        if (r3 == false) goto L7;
        IOFileFilter r5 = TrueFileFilter.INSTANCE;
    L9:
        return listFiles(r1, r4, r5);
    L7:
        r5 = FalseFileFilter.INSTANCE;
        goto L9
    L4:
        r4 = new SuffixFileFilter(toSuffixes(r2));
        goto L5
    }

    public static Iterator iterateFiles(File r0, String[] r1, boolean r2) {
        return listFiles(r0, r1, r2).iterator();
    }

    public static boolean contentEquals(File r7, File r8) throws IOException {
        boolean r0 = r7.exists();
        if (r0 == r8.exists()) goto L6;
        return false;
    L6:
        if (r0 == true) goto L9;
        return true;
    L9:
        if (r7.isDirectory() == true) goto L34;
        if (r8.isDirectory() == true) goto L34;
        if (r7.length() == r8.length()) goto L16;
        return false;
    L16:
        if (r7.getCanonicalFile().equals(r8.getCanonicalFile()) == false) goto L18;
        return true;
    L18:
        FileInputStream r1 = null;
        FileInputStream r2 = new FileInputStream(r7);     // Catch: Throwable -> L29
        FileInputStream r9 = new FileInputStream(r8);     // Catch: Throwable -> L26
        boolean r10 = IOUtils.contentEquals(r2, r9);     // Catch: Throwable -> L24
        IOUtils.closeQuietly(r2);
        IOUtils.closeQuietly(r9);
        return r10;
    L24:
        th = th;
    L28:
        r1 = r2;
    L31:
        IOUtils.closeQuietly(r1);
        IOUtils.closeQuietly(r9);
        throw th;
    L26:
        th = th;
        r9 = null;
    L29:
        th = th;
        r9 = null;
    L34:
        throw new IOException("Can't compare directories, only files");
    }

    public static File toFile(URL r6) {
        if (r6 != null) goto L4;
        return null;
    L4:
        if (r6.getProtocol().equals("file") == false) goto L21;
        String r7 = r6.getFile().replace(IOUtils.DIR_SEPARATOR_UNIX, File.separatorChar);
        int r1 = 0;
    L7:
        r1 = r7.indexOf(37, r1);
        if (r1 < 0) goto L13;
        if ((r1 + 2) >= r7.length()) goto L7;
        int r3 = r1 + 3;
        r7 = new StringBuffer().append(r7.substring(0, r1)).append((char) Integer.parseInt(r7.substring(r1 + 1, r3), 16)).append(r7.substring(r3)).toString();
        goto L7
    L13:
        return new File(r7);
    L21:
        return null;
    }

    public static File[] toFiles(URL[] r5) {
        if (r5 == null) goto L19;
        if (r5.length == 0) goto L19;
        File[] r0 = new File[r5.length];
        int r1 = 0;
    L8:
        if (r1 >= r5.length) goto L17;
        URL r2 = r5[r1];
        if (r2 == null) goto L16;
        if (r2.getProtocol().equals("file") == false) goto L15;
        r0[r1] = toFile(r2);
        goto L16
    L15:
        throw new IllegalArgumentException(new StringBuffer("URL could not be converted to a File: ").append(r2).toString());
    L16:
        r1 = r1 + 1;
        goto L8
    L17:
        return r0;
    L19:
        return EMPTY_FILE_ARRAY;
    }

    public static URL[] toURLs(File[] r4) throws IOException {
        int r0 = r4.length;
        URL[] r1 = new URL[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = r4[r2].toURL();
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public static void copyFileToDirectory(File r1, File r2) throws IOException {
        copyFileToDirectory(r1, r2, true);
    }

    public static void copyFileToDirectory(File r2, File r3, boolean r4) throws IOException {
        if (r3 == null) goto L13;
        if (r3.exists() == true) goto L6;
    L10:
        copyFile(r2, new File(r3, r2.getName()), r4);
        return;
    L6:
        if (r3.isDirectory() == true) goto L10;
        throw new IllegalArgumentException(new StringBuffer("Destination '").append(r3).append("' is not a directory").toString());
    L13:
        throw new NullPointerException("Destination must not be null");
    }

    public static void copyFile(File r1, File r2) throws IOException {
        copyFile(r1, r2, true);
    }

    public static void copyFile(File r3, File r4, boolean r5) throws IOException {
        if (r3 == null) goto L37;
        if (r4 == null) goto L35;
        if (r3.exists() == false) goto L33;
        if (r3.isDirectory() == true) goto L31;
        if (r3.getCanonicalPath().equals(r4.getCanonicalPath()) == true) goto L29;
        if (r4.getParentFile() == null) goto L20;
        if (r4.getParentFile().exists() == true) goto L20;
        if (r4.getParentFile().mkdirs() == true) goto L20;
        throw new IOException(new StringBuffer("Destination '").append(r4).append("' directory cannot be created").toString());
    L20:
        if (r4.exists() == true) goto L22;
    L26:
        doCopyFile(r3, r4, r5);
        return;
    L22:
        if (r4.canWrite() == true) goto L26;
        throw new IOException(new StringBuffer("Destination '").append(r4).append("' exists but is read-only").toString());
    L29:
        throw new IOException(new StringBuffer("Source '").append(r3).append("' and destination '").append(r4).append("' are the same").toString());
    L31:
        throw new IOException(new StringBuffer("Source '").append(r3).append("' exists but is a directory").toString());
    L33:
        throw new FileNotFoundException(new StringBuffer("Source '").append(r3).append("' does not exist").toString());
    L35:
        throw new NullPointerException("Destination must not be null");
    L37:
        throw new NullPointerException("Source must not be null");
    }

    private static void doCopyFile(File r4, File r5, boolean r6) throws IOException {
        if (r5.exists() == true) goto L5;
    L9:
        FileInputStream r0 = new FileInputStream(r4);
        FileOutputStream r1 = new FileOutputStream(r5);     // Catch: Throwable -> L23
        IOUtils.copy(r0, r1);     // Catch: Throwable -> L20
        IOUtils.closeQuietly(r1);     // Catch: Throwable -> L23
        IOUtils.closeQuietly(r0);
        if (r4.length() != r5.length()) goto L19;
        if (r6 == false) goto L29;
        r5.setLastModified(r4.lastModified());
        return;
    L29:
        return;
    L19:
        throw new IOException(new StringBuffer("Failed to copy full contents from '").append(r4).append("' to '").append(r5).append("'").toString());
    L20:
        th = move-exception;
        IOUtils.closeQuietly(r1);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        IOUtils.closeQuietly(r0);
        throw th;
    L5:
        if (r5.isDirectory() == false) goto L9;
        throw new IOException(new StringBuffer("Destination '").append(r5).append("' exists but is a directory").toString());
    }

    public static void copyDirectoryToDirectory(File r3, File r4) throws IOException {
        if (r3 == null) goto L23;
        if (r3.exists() == true) goto L6;
    L10:
        if (r4 == null) goto L21;
        if (r4.exists() == true) goto L14;
    L18:
        copyDirectory(r3, new File(r4, r3.getName()), true);
        return;
    L14:
        if (r4.isDirectory() == true) goto L18;
        throw new IllegalArgumentException(new StringBuffer("Destination '").append(r4).append("' is not a directory").toString());
    L21:
        throw new NullPointerException("Destination must not be null");
    L6:
        if (r3.isDirectory() == true) goto L10;
        throw new IllegalArgumentException(new StringBuffer("Source '").append(r4).append("' is not a directory").toString());
    L23:
        throw new NullPointerException("Source must not be null");
    }

    public static void copyDirectory(File r1, File r2) throws IOException {
        copyDirectory(r1, r2, true);
    }

    public static void copyDirectory(File r3, File r4, boolean r5) throws IOException {
        if (r3 == null) goto L21;
        if (r4 == null) goto L19;
        if (r3.exists() == false) goto L17;
        if (r3.isDirectory() == false) goto L15;
        if (r3.getCanonicalPath().equals(r4.getCanonicalPath()) == true) goto L13;
        doCopyDirectory(r3, r4, r5);
        return;
    L13:
        throw new IOException(new StringBuffer("Source '").append(r3).append("' and destination '").append(r4).append("' are the same").toString());
    L15:
        throw new IOException(new StringBuffer("Source '").append(r3).append("' exists but is not a directory").toString());
    L17:
        throw new FileNotFoundException(new StringBuffer("Source '").append(r3).append("' does not exist").toString());
    L19:
        throw new NullPointerException("Destination must not be null");
    L21:
        throw new NullPointerException("Source must not be null");
    }

    private static void doCopyDirectory(File r4, File r5, boolean r6) throws IOException {
        if (r5.exists() == false) goto L10;
        if (r5.isDirectory() == true) goto L14;
        throw new IOException(new StringBuffer("Destination '").append(r5).append("' exists but is not a directory").toString());
    L14:
        if (r5.canWrite() == false) goto L29;
        File[] r0 = r4.listFiles();
        if (r0 == null) goto L27;
        int r7 = 0;
    L19:
        if (r7 >= r0.length) goto L25;
        File r1 = new File(r5, r0[r7].getName());
        if (r0[r7].isDirectory() == false) goto L23;
        doCopyDirectory(r0[r7], r1, r6);
    L24:
        r7 = r7 + 1;
        goto L19
    L23:
        doCopyFile(r0[r7], r1, r6);
        goto L24
    L25:
        return;
    L27:
        throw new IOException(new StringBuffer("Failed to list contents of ").append(r4).toString());
    L29:
        throw new IOException(new StringBuffer("Destination '").append(r5).append("' cannot be written to").toString());
    L10:
        if (r5.mkdirs() == false) goto L31;
        if (r6 == false) goto L14;
        r5.setLastModified(r4.lastModified());
        goto L14
    L31:
        throw new IOException(new StringBuffer("Destination '").append(r5).append("' directory cannot be created").toString());
    }

    public static void copyURLToFile(URL r1, File r2) throws IOException {
        InputStream r3 = r1.openStream();
        FileOutputStream r4 = openOutputStream(r2);     // Catch: Throwable -> L11
        IOUtils.copy(r3, r4);     // Catch: Throwable -> L8
        IOUtils.closeQuietly(r4);     // Catch: Throwable -> L11
        IOUtils.closeQuietly(r3);
        return;
    L8:
        th = move-exception;
        IOUtils.closeQuietly(r4);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        IOUtils.closeQuietly(r3);
        throw th;
    }

    public static void deleteDirectory(File r2) throws IOException {
        if (r2.exists() == true) goto L5;
        return;
    L5:
        cleanDirectory(r2);
        if (r2.delete() == false) goto L9;
        return;
    L9:
        throw new IOException(new StringBuffer("Unable to delete directory ").append(r2).append(".").toString());
    }

    public static void cleanDirectory(File r3) throws IOException {
        if (r3.exists() == false) goto L24;
        if (r3.isDirectory() == false) goto L22;
        File[] r0 = r3.listFiles();
        if (r0 == null) goto L20;
        IOException e = null;
        int r1 = 0;
    L10:
        if (r1 >= r0.length) goto L16;
        forceDelete(r0[r1]);     // Catch: IOException -> L14
    L15:
        r1 = r1 + 1;
    L14:
        e = e;
        goto L15
    L16:
        if (e != null) goto L18;
        return;
    L18:
        throw e;
    L20:
        throw new IOException(new StringBuffer("Failed to list contents of ").append(r3).toString());
    L22:
        throw new IllegalArgumentException(new StringBuffer().append(r3).append(" is not a directory").toString());
    L24:
        throw new IllegalArgumentException(new StringBuffer().append(r3).append(" does not exist").toString());
    }

    public static boolean waitFor(File r5, int r6) {
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r5.exists() == true) goto L25;
        int r3 = r1 + 1;
        if (r1 < 10) goto L11;
        int r4 = r2 + 1;
        if (r2 > r6) goto L9;
        r2 = r4;
        r1 = 0;
    L19:
        Thread.sleep(100);     // Catch: InterruptedException -> L17 Exception -> L18
    L15:
        return true;
    L9:
        return false;
    L11:
        r1 = r3;
        goto L19
    L25:
        return true;
    }

    public static String readFileToString(File r0, String r1) throws IOException {
        FileInputStream r2 = openInputStream(r0);     // Catch: Throwable -> L8
        String r3 = IOUtils.toString(r2, r1);     // Catch: Throwable -> L6
        IOUtils.closeQuietly(r2);
        return r3;
    L6:
        th = th;
    L10:
        IOUtils.closeQuietly(r2);
        throw th;
    L8:
        th = th;
        r2 = null;
        goto L10
    }

    public static String readFileToString(File r1) throws IOException {
        return readFileToString(r1, null);
    }

    public static byte[] readFileToByteArray(File r1) throws IOException {
        FileInputStream r2 = openInputStream(r1);     // Catch: Throwable -> L8
        byte[] r0 = IOUtils.toByteArray(r2);     // Catch: Throwable -> L6
        IOUtils.closeQuietly(r2);
        return r0;
    L6:
        th = th;
    L10:
        IOUtils.closeQuietly(r2);
        throw th;
    L8:
        th = th;
        r2 = null;
        goto L10
    }

    public static List readLines(File r0, String r1) throws IOException {
        FileInputStream r2 = openInputStream(r0);     // Catch: Throwable -> L8
        List r3 = IOUtils.readLines(r2, r1);     // Catch: Throwable -> L6
        IOUtils.closeQuietly(r2);
        return r3;
    L6:
        th = th;
    L10:
        IOUtils.closeQuietly(r2);
        throw th;
    L8:
        th = th;
        r2 = null;
        goto L10
    }

    public static List readLines(File r1) throws IOException {
        return readLines(r1, null);
    }

    public static LineIterator lineIterator(File r1, String r2) throws IOException {
        FileInputStream r0 = null;
        r0 = openInputStream(r1);     // Catch: RuntimeException -> L5 IOException -> L8
        return IOUtils.lineIterator(r0, r2);
    L8:
        e = move-exception;
        IOUtils.closeQuietly(r0);
        throw e;
    L5:
        e = move-exception;
        IOUtils.closeQuietly(r0);
        throw e;
    }

    public static LineIterator lineIterator(File r1) throws IOException {
        return lineIterator(r1, null);
    }

    public static void writeStringToFile(File r0, String r1, String r2) throws IOException {
        FileOutputStream r3 = openOutputStream(r0);     // Catch: Throwable -> L8
        IOUtils.write(r1, r3, r2);     // Catch: Throwable -> L6
        IOUtils.closeQuietly(r3);
        return;
    L6:
        th = th;
    L10:
        IOUtils.closeQuietly(r3);
        throw th;
    L8:
        th = th;
        r3 = null;
        goto L10
    }

    public static void writeStringToFile(File r1, String r2) throws IOException {
        writeStringToFile(r1, r2, null);
    }

    public static void writeByteArrayToFile(File r0, byte[] r1) throws IOException {
        FileOutputStream r2 = openOutputStream(r0);     // Catch: Throwable -> L8
        r2.write(r1);     // Catch: Throwable -> L6
        IOUtils.closeQuietly(r2);
        return;
    L6:
        th = th;
    L10:
        IOUtils.closeQuietly(r2);
        throw th;
    L8:
        th = th;
        r2 = null;
        goto L10
    }

    public static void writeLines(File r1, String r2, Collection r3) throws IOException {
        writeLines(r1, r2, r3, null);
    }

    public static void writeLines(File r1, Collection r2) throws IOException {
        writeLines(r1, null, r2, null);
    }

    public static void writeLines(File r0, String r1, Collection r2, String r3) throws IOException {
        FileOutputStream r4 = openOutputStream(r0);     // Catch: Throwable -> L8
        IOUtils.writeLines(r2, r3, r4, r1);     // Catch: Throwable -> L6
        IOUtils.closeQuietly(r4);
        return;
    L6:
        th = th;
    L10:
        IOUtils.closeQuietly(r4);
        throw th;
    L8:
        th = th;
        r4 = null;
        goto L10
    }

    public static void writeLines(File r1, Collection r2, String r3) throws IOException {
        writeLines(r1, null, r2, r3);
    }

    public static void forceDelete(File r3) throws IOException {
        if (r3.isDirectory() == false) goto L6;
        deleteDirectory(r3);
        return;
    L6:
        if (r3.exists() == false) goto L13;
        if (r3.delete() == false) goto L11;
        return;
    L11:
        throw new IOException(new StringBuffer("Unable to delete file: ").append(r3).toString());
    L13:
        throw new FileNotFoundException(new StringBuffer("File does not exist: ").append(r3).toString());
    }

    public static void forceDeleteOnExit(File r1) throws IOException {
        if (r1.isDirectory() == false) goto L5;
        deleteDirectoryOnExit(r1);
        return;
    L5:
        r1.deleteOnExit();
    }

    private static void deleteDirectoryOnExit(File r1) throws IOException {
        if (r1.exists() == true) goto L5;
        return;
    L5:
        cleanDirectoryOnExit(r1);
        r1.deleteOnExit();
    }

    private static void cleanDirectoryOnExit(File r3) throws IOException {
        if (r3.exists() == false) goto L24;
        if (r3.isDirectory() == false) goto L22;
        File[] r0 = r3.listFiles();
        if (r0 == null) goto L20;
        IOException e = null;
        int r1 = 0;
    L10:
        if (r1 >= r0.length) goto L16;
        forceDeleteOnExit(r0[r1]);     // Catch: IOException -> L14
    L15:
        r1 = r1 + 1;
    L14:
        e = e;
        goto L15
    L16:
        if (e != null) goto L18;
        return;
    L18:
        throw e;
    L20:
        throw new IOException(new StringBuffer("Failed to list contents of ").append(r3).toString());
    L22:
        throw new IllegalArgumentException(new StringBuffer().append(r3).append(" is not a directory").toString());
    L24:
        throw new IllegalArgumentException(new StringBuffer().append(r3).append(" does not exist").toString());
    }

    public static void forceMkdir(File r2) throws IOException {
        if (r2.exists() == false) goto L10;
        if (r2.isFile() == true) goto L8;
        return;
    L8:
        throw new IOException(new StringBuffer("File ").append(r2).append(" exists and is not a directory. Unable to create directory.").toString());
    L10:
        if (r2.mkdirs() == false) goto L13;
        return;
    L13:
        throw new IOException(new StringBuffer("Unable to create directory ").append(r2).toString());
    }

    public static long sizeOfDirectory(File r5) {
        if (r5.exists() == false) goto L21;
        if (r5.isDirectory() == false) goto L19;
        File[] r6 = r5.listFiles();
        long r0 = 0;
        if (r6 != null) goto L9;
        return 0;
    L9:
        int r2 = 0;
    L11:
        if (r2 >= r6.length) goto L17;
        File r3 = r6[r2];
        if (r3.isDirectory() == false) goto L15;
        long r4 = sizeOfDirectory(r3);
    L16:
        r0 = r0 + r4;
        r2 = r2 + 1;
        goto L11
    L15:
        r4 = r3.length();
        goto L16
    L17:
        return r0;
    L19:
        throw new IllegalArgumentException(new StringBuffer().append(r5).append(" is not a directory").toString());
    L21:
        throw new IllegalArgumentException(new StringBuffer().append(r5).append(" does not exist").toString());
    }

    public static boolean isFileNewer(File r2, File r3) {
        if (r3 == null) goto L10;
        if (r3.exists() == false) goto L8;
        return isFileNewer(r2, r3.lastModified());
    L8:
        throw new IllegalArgumentException(new StringBuffer("The reference file '").append(r2).append("' doesn't exist").toString());
    L10:
        throw new IllegalArgumentException("No specified reference file");
    }

    public static boolean isFileNewer(File r2, Date r3) {
        if (r3 == null) goto L6;
        return isFileNewer(r2, r3.getTime());
    L6:
        throw new IllegalArgumentException("No specified date");
    }

    public static boolean isFileNewer(File r4, long r5) {
        if (r4 == null) goto L11;
        if (r4.exists() == true) goto L7;
        return false;
    L7:
        if (r4.lastModified() <= r5) goto L12;
        return true;
    L12:
        return false;
    L11:
        throw new IllegalArgumentException("No specified file");
    }

    public static boolean isFileOlder(File r2, File r3) {
        if (r3 == null) goto L10;
        if (r3.exists() == false) goto L8;
        return isFileOlder(r2, r3.lastModified());
    L8:
        throw new IllegalArgumentException(new StringBuffer("The reference file '").append(r2).append("' doesn't exist").toString());
    L10:
        throw new IllegalArgumentException("No specified reference file");
    }

    public static boolean isFileOlder(File r2, Date r3) {
        if (r3 == null) goto L6;
        return isFileOlder(r2, r3.getTime());
    L6:
        throw new IllegalArgumentException("No specified date");
    }

    public static boolean isFileOlder(File r4, long r5) {
        if (r4 == null) goto L11;
        if (r4.exists() == true) goto L7;
        return false;
    L7:
        if (r4.lastModified() >= r5) goto L12;
        return true;
    L12:
        return false;
    L11:
        throw new IllegalArgumentException("No specified file");
    }

    public static long checksumCRC32(File r2) throws IOException {
        CRC32 r0 = new CRC32();
        checksum(r2, r0);
        return r0.getValue();
    }

    public static Checksum checksum(File r3, Checksum r4) throws IOException {
        if (r3.isDirectory() == true) goto L15;
        CheckedInputStream r0 = null;
        CheckedInputStream r1 = new CheckedInputStream(new FileInputStream(r3), r4);     // Catch: Throwable -> L11
        IOUtils.copy(r1, new NullOutputStream());     // Catch: Throwable -> L9
        IOUtils.closeQuietly(r1);
        return r4;
    L9:
        th = th;
        r0 = r1;
    L12:
        IOUtils.closeQuietly(r0);
        throw th;
    L11:
        th = th;
        goto L12
    L15:
        throw new IllegalArgumentException("Checksums can't be computed on directories");
    }
}
