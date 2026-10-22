package org.apache.commons.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes5.dex */
public class FileSystemUtils {
    private static final int INIT_PROBLEM = -1;
    private static final FileSystemUtils INSTANCE = null;
    private static final int OS = 0;
    private static final int OTHER = 0;
    private static final int POSIX_UNIX = 3;
    private static final int UNIX = 2;
    private static final int WINDOWS = 1;

    static {
        INSTANCE = new FileSystemUtils();
        int r0 = -1;
        String r1 = System.getProperty("os.name");     // Catch: Exception -> L41
        if (r1 == null) goto L38;
        String r2 = r1.toLowerCase();     // Catch: Exception -> L41
        if (r2.indexOf("windows") == (-1)) goto L9;
        r0 = 1;
        goto L39
    L9:
        if (r2.indexOf("linux") == (-1)) goto L11;
    L36:
        r0 = 2;
        goto L39
    L11:
        if (r2.indexOf("sun os") != (-1)) goto L36;
        if (r2.indexOf("sunos") != (-1)) goto L36;
        if (r2.indexOf("solaris") != (-1)) goto L36;
        if (r2.indexOf("mpe/ix") != (-1)) goto L36;
        if (r2.indexOf("freebsd") != (-1)) goto L36;
        if (r2.indexOf("irix") != (-1)) goto L36;
        if (r2.indexOf("digital unix") != (-1)) goto L36;
        if (r2.indexOf("unix") != (-1)) goto L36;
        if (r2.indexOf("mac os x") != (-1)) goto L36;
        if (r2.indexOf("hp-ux") == (-1)) goto L32;
    L35:
        r0 = 3;
        goto L39
    L32:
        if (r2.indexOf("aix") != (-1)) goto L35;
        r0 = 0;
        goto L39
    L38:
        throw new IOException("os.name not found");     // Catch: Exception -> L41
    L39:
        OS = r0;
    }

    public FileSystemUtils() {
    }

    public static long freeSpace(String r3) throws IOException {
        return INSTANCE.freeSpaceOS(r3, OS, false);
    }

    public static long freeSpaceKb(String r3) throws IOException {
        return INSTANCE.freeSpaceOS(r3, OS, true);
    }

    long freeSpaceOS(String r3, int r4, boolean r5) throws IOException {
        if (r3 == null) goto L23;
        if (r4 == 0) goto L21;
        if (r4 != 1) goto L7;
        long r2 = freeSpaceWindows(r3);
        if (r5 == true) goto L19;
        return r2;
    L19:
        return r2 / 1024;
    L7:
        if (r4 == 2) goto L15;
        if (r4 != 3) goto L13;
        return freeSpaceUnix(r3, r5, true);
    L13:
        throw new IllegalStateException("Exception caught when determining operating system");
    L15:
        return freeSpaceUnix(r3, r5, false);
    L21:
        throw new IllegalStateException("Unsupported operating system");
    L23:
        throw new IllegalArgumentException("Path must not be empty");
    }

    long freeSpaceWindows(String r6) throws IOException {
        String r7 = FilenameUtils.normalize(r6);
        if (r7.length() > 2) goto L5;
    L7:
        List r0 = performCommand(new String[]{"cmd.exe", "/C", new StringBuffer("dir /-c ").append(r7).toString()}, Integer.MAX_VALUE);
        int r1 = r0.size() - 1;
    L8:
        if (r1 < 0) goto L15;
        String r2 = (String) r0.get(r1);
        if (r2.length() > 0) goto L12;
        r1 = r1 - 1;
        goto L8
    L12:
        return parseDir(r2, r7);
    L15:
        throw new IOException(new StringBuffer("Command line 'dir /-c' did not return any info for path '").append(r7).append("'").toString());
    L5:
        if (r7.charAt(1) != ':') goto L7;
        r7 = r7.substring(0, 2);
        goto L7
    }

    long parseDir(String r8, String r9) throws IOException {
        int r0 = r8.length();
    L3:
        r0 = r0 - 1;
        int r1 = 0;
        if (r0 < 0) goto L9;
        if (Character.isDigit(r8.charAt(r0)) == false) goto L3;
        int r2 = r0 + 1;
    L11:
        if (r0 < 0) goto L18;
        char r5 = r8.charAt(r0);
        if (Character.isDigit(r5) == true) goto L17;
        if (r5 == ',') goto L17;
        if (r5 == '.') goto L17;
        int r6 = r0 + 1;
    L19:
        if (r0 < 0) goto L32;
        StringBuffer r3 = new StringBuffer(r8.substring(r6, r2));
    L22:
        if (r1 >= r3.length()) goto L30;
        if (r3.charAt(r1) != ',') goto L26;
    L27:
        r3.deleteCharAt(r1);
        r1 = r1 - 1;
    L28:
        r1 = r1 + 1;
        goto L22
    L26:
        if (r3.charAt(r1) != '.') goto L28;
    L30:
        return parseBytes(r3.toString(), r9);
    L32:
        throw new IOException(new StringBuffer("Command line 'dir /-c' did not return valid info for path '").append(r9).append("'").toString());
    L17:
        r0 = r0 - 1;
        goto L11
    L18:
        r6 = 0;
        goto L19
    L9:
        r2 = 0;
        goto L11
    }

    long freeSpaceUnix(String r7, boolean r8, boolean r9) throws IOException {
        if (r7.length() == 0) goto L31;
        String r10 = FilenameUtils.normalize(r7);
        if (r8 == false) goto L7;
        String r11 = "-k";
    L8:
        if (r9 == false) goto L11;
        r11 = new StringBuffer().append(r11).append("P").toString();
    L11:
        if (r11.length() <= 1) goto L13;
        String[] r12 = {"df", r11, r10};
    L14:
        List r13 = performCommand(r12, 3);
        if (r13.size() < 2) goto L29;
        StringTokenizer r0 = new StringTokenizer((String) r13.get(1), " ");
        if (r0.countTokens() < 4) goto L19;
        r0.nextToken();
    L26:
        r0.nextToken();
        r0.nextToken();
        return parseBytes(r0.nextToken(), r10);
    L19:
        if (r0.countTokens() != 1) goto L24;
        if (r13.size() < 3) goto L24;
        r0 = new StringTokenizer((String) r13.get(2), " ");
    L24:
        throw new IOException(new StringBuffer("Command line 'df' did not return data as expected for path '").append(r10).append("'- check path is valid").toString());
    L29:
        throw new IOException(new StringBuffer("Command line 'df' did not return info as expected for path '").append(r10).append("'- response was ").append(r13).toString());
    L13:
        r12 = new String[]{"df", r10};
        goto L14
    L7:
        r11 = "-";
        goto L8
    L31:
        throw new IllegalArgumentException("Path must not be empty");
    }

    long parseBytes(String r6, String r7) throws IOException {
        long r1 = Long.parseLong(r6);     // Catch: NumberFormatException -> L8
        if (r1 < 0) goto L7;
        return r1;
    L7:
        throw new IOException(new StringBuffer("Command line 'df' did not find free space in response for path '").append(r7).append("'- check path is valid").toString());     // Catch: NumberFormatException -> L8
    L9:
        throw new IOException(new StringBuffer("Command line 'df' did not return numeric data as expected for path '").append(r7).append("'- check path is valid").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.BufferedReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    List performCommand(String[] r9, int r10) throws IOException {
        ArrayList r1 = new ArrayList(20);
        InputStream r2 = null;
        Process r8 = openProcess(r9);     // Catch: Throwable -> L49 InterruptedException -> L52
        InputStream r3 = r8.getInputStream();     // Catch: Throwable -> L42 InterruptedException -> L44
    L74:
        OutputStream r4 = r8.getOutputStream();     // Catch: Throwable -> L37 InterruptedException -> L40
        InputStream r5 = r8.getErrorStream();     // Catch: Throwable -> L33 InterruptedException -> L35
        ?? r6 = new BufferedReader(new InputStreamReader(r3));     // Catch: Throwable -> L29 InterruptedException -> L31
        String r7 = r6.readLine();     // Catch: Throwable -> L25 InterruptedException -> L27
    L9:
        if (r7 == null) goto L13;
        if (r1.size() >= r10) goto L13;
        r1.add(r7.toLowerCase().trim());     // Catch: Throwable -> L25 InterruptedException -> L27
        r7 = r6.readLine();     // Catch: Throwable -> L25 InterruptedException -> L27
    L13:
        r8.waitFor();     // Catch: Throwable -> L25 InterruptedException -> L27
        if (r8.exitValue() != 0) goto L24;
        if (r1.size() == 0) goto L22;
        IOUtils.closeQuietly(r3);
        IOUtils.closeQuietly(r4);
        IOUtils.closeQuietly(r5);
        IOUtils.closeQuietly(r6);
        if (r8 == null) goto L20;
        r8.destroy();
    L20:
        return r1;
    L22:
        throw new IOException(new StringBuffer().append("Command line did not return any info for command ").append(Arrays.asList(r9)).toString());     // Catch: Throwable -> L25 InterruptedException -> L27
    L24:
        throw new IOException(new StringBuffer().append("Command line returned OS error code '").append(r8.exitValue()).append("' for command ").append(Arrays.asList(r9)).toString());     // Catch: Throwable -> L25 InterruptedException -> L27
    L27:
        e = e;
    L48:
        r2 = r8;
        r6 = r6;
    L63:
    L56:
        th = th;
        r8 = r2;
    L58:
        r2 = r3;
        ?? r11 = r6;
    L59:
        IOUtils.closeQuietly(r2);
        IOUtils.closeQuietly(r4);
        IOUtils.closeQuietly(r5);
        IOUtils.closeQuietly(r11);
        if (r8 == null) goto L62;
        r8.destroy();
    L62:
        throw th;
    L55:
        throw new IOException(new StringBuffer().append("Command line threw an InterruptedException '").append(e.getMessage()).append("' for command ").append(Arrays.asList(r9)).toString());     // Catch: Throwable -> L56
    L25:
        th = th;
        goto L58
    L31:
        e = e;
        r6 = 0;
    L29:
        th = th;
        r6 = 0;
        goto L58
    L35:
        e = e;
        r5 = null;
    L47:
        r6 = r5;
    L33:
        th = th;
        r5 = null;
    L39:
        r6 = r5;
        goto L58
    L40:
        e = e;
        r4 = null;
    L46:
        r5 = r4;
    L37:
        th = th;
        r4 = null;
        r5 = null;
    L44:
        e = e;
        r3 = null;
        r4 = null;
    L42:
        th = th;
        r4 = null;
    L51:
        r5 = r4;
        r11 = r5;
        goto L59
    L52:
        e = e;
        r3 = null;
        r4 = null;
        r5 = null;
        r6 = 0;
    L49:
        th = th;
        r8 = null;
        r4 = null;
        goto L51
    }

    Process openProcess(String[] r1) throws IOException {
        return Runtime.getRuntime().exec(r1);
    }
}
