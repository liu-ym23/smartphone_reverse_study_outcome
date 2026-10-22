package com.bytedance.librarian;

import a.a;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.bytedance.librarian.elf.ElfParser;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
class LibrarianImpl {
    private static final String[] SYSTEM_LIB_LIST = null;
    static final LibrarianImpl instance = null;
    private String mAbi;
    private Map<String, String> mAbiToInstructionSetMap;
    private String[] mAbis;
    private ZipFile[] mApkZipFiles;
    private ApplicationInfo mApplicationInfo;
    private volatile boolean mIsLazyInitialized;
    private final Map<String, LibRecorder> mLoadedLibMap;
    private final File mLockFile;
    private final LibrarianMonitor mMonitor;
    private File mNativeLibDir;
    private String mVmInstructionSet;
    private final File mWorkDir;

    public interface Constants {
        public static final int BUFFER_SIZE = 8192;
        public static final String DEFAULT_VERSION = "default.version";
        public static final String DOT = ".";
        public static final String LIB_PREFIX = "lib";
        public static final String LOCK_FILE_NAME = "process.lock";
        public static final int MAX_EXTRACT_ATTEMPTS = 3;
        public static final String SEPARATOR = "/";
        public static final String SO_SUFFIX = ".so";
        public static final String TAG = "librarian";
    }

    public static class LibRecorder {
        boolean loaded;

        public LibRecorder() {
            this.loaded = false;
        }

        public String toString() {
            return Boolean.toString(this.loaded);
        }
    }

    public class Locker {
        private FileLock cacheLock;
        private FileChannel lockChannel;
        private File lockFile;
        private RandomAccessFile lockRaf;
        final /* synthetic */ LibrarianImpl this$0;

        public Locker(LibrarianImpl r1, File r2) {
            this.this$0 = r1;
            this.lockFile = r2;
        }

        public void close() {
            FileLock r0 = this.cacheLock;
            if (r0 != null) goto L8;
        L5:
            LibrarianImpl.access$000(this.this$0).logDebug("released lock " + this.lockFile.getPath());
            LibrarianImpl.access$100(this.this$0, this.lockChannel);
            LibrarianImpl.access$100(this.this$0, this.lockRaf);
            return;
        L8:
            r0.release();     // Catch: IOException -> L7
            goto L5
        }

        public void lock() {
            RandomAccessFile r2 = new RandomAccessFile(this.lockFile, "rw");
            this.lockRaf = r2;
            this.lockChannel = r2.getChannel();     // Catch: IOException -> L7
            LibrarianImpl.access$000(this.this$0).logDebug("blocking on lock " + this.lockFile.getPath());     // Catch: IOException -> L9
            this.cacheLock = this.lockChannel.lock();     // Catch: IOException -> L9
            LibrarianImpl.access$000(this.this$0).logDebug("acquired on lock " + this.lockFile.getPath());     // Catch: IOException -> L7
            return;
        L9:
            e = move-exception;
            LibrarianImpl.access$100(this.this$0, this.lockChannel);     // Catch: IOException -> L7
            throw e;     // Catch: IOException -> L7
        L7:
            e = move-exception;
            LibrarianImpl.access$100(this.this$0, this.lockRaf);
            throw e;
        }
    }

    static {
        SYSTEM_LIB_LIST = new String[]{"log", "m", "stdc++", "dl", "c", "z", "android", "jnigraphics", "EGL", "GLESv1_CM", "GLESv2", "GLESv3", "OpenSLES", "OpenMAXAL"};
        Context r0 = Librarian.sContext;
        Librarian.sContext = null;
        if (r0 == null) goto L35;
        ApplicationInfo r2 = r0.getApplicationInfo();
        File r1 = r0.getDir(Constants.TAG, 0);
        if (r1.exists() == true) goto L8;
        r1.mkdirs();
    L8:
        if (Librarian.sVersion == null) goto L10;
        String r3 = Librarian.sVersion;
    L11:
        File r5 = new File(r2.sourceDir);
        StringBuilder r4 = a.t(r3, Constants.DOT);
        r4.append(r5.lastModified() >> 8);
        File r6 = new File(r1, r4.toString());
        File[] r7 = r1.listFiles();
        if (r7 == null) goto L25;
        int r8 = r7.length;
        int r9 = 0;
    L14:
        if (r9 >= r8) goto L25;
        File r10 = r7[r9];
        if (r6.getName().equals(r10.getName()) == true) goto L24;
        File[] r11 = r10.listFiles();
        if (r11 == null) goto L23;
        int r12 = r11.length;
        int r13 = 0;
    L21:
        if (r13 >= r12) goto L23;
        r11[r13].delete();
        r13 = r13 + 1;
    L23:
        r10.delete();
    L24:
        r9 = r9 + 1;
    L25:
        r6.mkdirs();
        if (r6.exists() == false) goto L32;
        LibrarianMonitor r14 = Librarian.sMonitor;
        if (r14 != null) goto L31;
        r14 = new LibrarianMonitor();
    L31:
        instance = new LibrarianImpl(r2, r6, r14);
        return;
    L32:
        instance = null;
        return;
    L10:
        r3 = Constants.DEFAULT_VERSION;
        goto L11
    L35:
        throw new LibrarianUnsatisfiedLinkError("you should call init first or use loadLibraryForModule.");
    }

    private LibrarianImpl(ApplicationInfo r1, File r2, LibrarianMonitor r3) {
        this.mWorkDir = r2;
        this.mMonitor = r3;
        this.mApplicationInfo = r1;
        this.mLockFile = new File(r2, Constants.LOCK_FILE_NAME);
        this.mLoadedLibMap = new HashMap();
    }

    public static /* synthetic */ LibrarianMonitor access$000(LibrarianImpl r0) {
        return r0.mMonitor;
    }

    public static /* synthetic */ void access$100(LibrarianImpl r0, Closeable r1) {
        r0.closeQuietly(r1);
    }

    private void checkLazyInitialization() {
        if (this.mIsLazyInitialized == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.mIsLazyInitialized == true) goto L34;
        File r1 = new File(this.mApplicationInfo.sourceDir);     // Catch: Throwable -> L15
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L15
        r2.add(r1);     // Catch: Throwable -> L15
        String[] r3 = this.mApplicationInfo.splitSourceDirs;     // Catch: Throwable -> L15
        int r4 = 0;
        if (r3 != null) goto L11;
    L17:
        ZipFile[] r5 = new ZipFile[r2.size()];     // Catch: Throwable -> L15
        Iterator r6 = r2.iterator();     // Catch: Throwable -> L15
    L19:
        if (r6.hasNext() == false) goto L27;
        File r7 = (File) r6.next();     // Catch: Throwable -> L15
        int r8 = r4 + 1;
        r5[r4] = new ZipFile(r7);     // Catch: Throwable -> L15 IOException -> L24
    L26:
        r4 = r8;
    L24:
        e = move-exception;
        new LibrarianUnsatisfiedLinkError("fail to get zip file " + r7.getName(), e).printStackTrace();     // Catch: Throwable -> L15
        goto L26
    L27:
        this.mApkZipFiles = r5;     // Catch: Throwable -> L15
        this.mNativeLibDir = new File(this.mApplicationInfo.nativeLibraryDir);     // Catch: Throwable -> L15
        HashMap r9 = new HashMap();     // Catch: Throwable -> L15
        this.mAbiToInstructionSetMap = r9;     // Catch: Throwable -> L15
        r9.put("arm64-v8a", "arm64");     // Catch: Throwable -> L15
        this.mAbiToInstructionSetMap.put("armeabi-v7a", "arm");     // Catch: Throwable -> L15
        this.mAbiToInstructionSetMap.put("armeabi", "arm");     // Catch: Throwable -> L15
        String r10 = null;
        Class<?> r11 = Class.forName("dalvik.system.VMRuntime");     // Catch: Throwable -> L15 Exception -> L31
        r10 = (String) r11.getDeclaredMethod("vmInstructionSet", null).invoke(r11.getDeclaredMethod("getRuntime", null).invoke(null, null), null);     // Catch: Throwable -> L15 Exception -> L31
    L33:
        this.mVmInstructionSet = r10;     // Catch: Throwable -> L15
        this.mMonitor.logDebug("vm instruction set: " + this.mVmInstructionSet);     // Catch: Throwable -> L15
        this.mAbis = Build.SUPPORTED_ABIS;     // Catch: Throwable -> L15
        this.mIsLazyInitialized = true;     // Catch: Throwable -> L15
        goto L34
    L31:
        e = move-exception;
        this.mMonitor.logWarning("fail to get vm instruction set", e);     // Catch: Throwable -> L15
        goto L33
    L11:
        if (r3.length == 0) goto L17;
        int r12 = r3.length;     // Catch: Throwable -> L15
        int r13 = 0;
    L13:
        if (r13 >= r12) goto L17;
        r2.add(new File(r3[r13]));     // Catch: Throwable -> L15
        r13 = r13 + 1;     // Catch: Throwable -> L15
    L34:
        monitor-exit(this);     // Catch: Throwable -> L15
    }

    private boolean checkLibValid(File r8) {
        if (r8.exists() == true) goto L6;
        this.mMonitor.logWarning("file is not exist: " + r8.getPath());
        return false;
    L6:
        ensureRuntimeAbi(r8.getName());
        String r0 = "lib/" + this.mAbi + Constants.SEPARATOR + r8.getName();
        ZipFile[] r2 = this.mApkZipFiles;
        int r3 = r2.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L12;
        ZipEntry r5 = r2[r4].getEntry(r0);
        if (r5 != null) goto L10;
        r4 = r4 + 1;
        goto L7
    L10:
        long r6 = r5.getCrc();
    L13:
        long r7 = doFileCheckSum(r8);
        if (r6 != r7) goto L17;
        this.mMonitor.logDebug(r0 + " compare crc ok: entry is " + r6 + ", file is " + r7);
        return true;
    L17:
        this.mMonitor.logWarning(r0 + " crc is wrong: entry is " + r6 + ", file is " + r7);
        return false;
    L12:
        r6 = 0;
        goto L13
    }

    private boolean checkRuntimeAbi(String r2) {
        if (this.mVmInstructionSet != null) goto L6;
        return true;
    L6:
        String r0 = this.mAbiToInstructionSetMap.get(r2);
        String r1 = this.mVmInstructionSet;
        if (r0 == null) goto L10;
        r2 = r0;
    L10:
        return r1.equals(r2);
    }

    private void closeQuietly(Closeable r2) {
        if (r2 != null) goto L9;
        return;
    L9:
        r2.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        this.mMonitor.logWarning("failed to close resource", e);
    }

    private long doFileCheckSum(File r6) {
        byte[] r0 = new byte[8192];
        Closeable r1 = null;
        CheckedInputStream r2 = new CheckedInputStream(new FileInputStream(r6), new CRC32());     // Catch: Throwable -> L13 IOException -> L15
    L25:
    L11:
        e = e;
        r1 = r2;
    L16:
        this.mMonitor.logWarning("fail to check sum for " + r6.getPath(), e);     // Catch: Throwable -> L13
        closeQuietly(r1);
        return 0;
    L9:
        th = th;
        r1 = r2;
    L19:
        closeQuietly(r1);
        throw th;
    L5:
        if (r2.read(r0) >= 0) goto L25;
        long r3 = r2.getChecksum().getValue();     // Catch: Throwable -> L9 IOException -> L11
        closeQuietly(r2);
        return r3;
    L13:
        th = th;
    L15:
        e = e;
        goto L16
    }

    private void ensureRuntimeAbi(String r11) {
        if (this.mAbi == null) goto L5;
        return;
    L5:
        String[] r0 = this.mAbis;
        int r1 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L18;
        String r4 = r0[r3];
        if (checkRuntimeAbi(r4) == false) goto L17;
        String r5 = "lib/" + r4 + Constants.SEPARATOR + r11;
        ZipFile[] r6 = this.mApkZipFiles;
        int r7 = r6.length;
        int r8 = 0;
    L11:
        if (r8 >= r7) goto L17;
        if (r6[r8].getEntry(r5) != null) goto L14;
        r8 = r8 + 1;
        goto L11
    L14:
        this.mAbi = r4;
        this.mMonitor.logDebug("ensure that abi is " + r4);
        return;
    L17:
        r3 = r3 + 1;
        goto L6
    L18:
        StringBuilder r12 = a.u("can not ensure abi for ", r11, ", check ");
        r12.append(this.mVmInstructionSet);
        r12.append(", apks ");
        r12.append(getApkZipFileInfo());
        throw new LibrarianUnsatisfiedLinkError(r12.toString());
    }

    private boolean extractLibFromZip(File r8) {
        ensureRuntimeAbi(r8.getName());
        String r0 = "lib/" + this.mAbi + Constants.SEPARATOR + r8.getName();
        ZipFile[] r1 = this.mApkZipFiles;
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L14;
        ZipFile r5 = r1[r4];
        ZipEntry r6 = r5.getEntry(r0);
        if (r6 != null) goto L7;
        r4 = r4 + 1;
        goto L3
    L7:
        InputStream r3 = r5.getInputStream(r6);
        obtainEntryFileFromInputStream(r3, r8);     // Catch: Throwable -> L11
        this.mMonitor.logDebug("get lib file " + r8.getPath() + " from " + r0 + " of " + r5.getName());     // Catch: Throwable -> L11
        closeQuietly(r3);
        return true;
    L11:
        th = move-exception;
        closeQuietly(r3);
        throw th;
    L14:
        return false;
    }

    private String getApkZipFileInfo() {
        StringBuilder r0 = new StringBuilder("[");
        ZipFile[] r6 = this.mApkZipFiles;
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        ZipFile r3 = r6[r2];
        String r4 = r3.getName();
        File r5 = new File(r4);
        r0.append(r4);
        r0.append("#");
        r0.append(r3.size());
        r0.append(":");
        r0.append(r5.length());
        r0.append(" ");
        r2 = r2 + 1;
        goto L3
    L5:
        r0.append("]");
        return r0.toString();
    }

    private static String getLibFileName(String r2) {
        return a.k(Constants.LIB_PREFIX, r2, Constants.SO_SUFFIX);
    }

    private boolean isSystemLib(String r5) {
        String[] r4 = SYSTEM_LIB_LIST;
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r4[r2].equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private List<String> obtainDependencies(File r3) {
        Closeable r0 = null;
        ElfParser r1 = new ElfParser(r3);     // Catch: Throwable -> L9
        List<String> r4 = r1.parseNeededDependencies();     // Catch: Throwable -> L7
        Collections.sort(r4);     // Catch: Throwable -> L7
        closeQuietly(r1);
        return r4;
    L7:
        th = th;
        r0 = r1;
    L10:
        closeQuietly(r0);
        throw th;
    L9:
        th = th;
        goto L10
    }

    private File obtainEntryFileFromInputStream(InputStream r6, File r7) {
        File r0 = File.createTempFile("tmp-", r7.getName(), r7.getParentFile());
        this.mMonitor.logDebug("extracting " + r0.getPath());
        FileOutputStream r1 = new FileOutputStream(r0);
        byte[] r2 = new byte[8192];     // Catch: Throwable -> L7
        int r3 = r6.read(r2);     // Catch: Throwable -> L7
    L5:
        if (r3 == (-1)) goto L10;
        r1.write(r2, 0, r3);     // Catch: Throwable -> L7
        r3 = r6.read(r2);     // Catch: Throwable -> L7
        goto L5
    L10:
        if (r0.setReadOnly() == false) goto L18;
        this.mMonitor.logDebug("renaming to " + r7.getPath());     // Catch: Throwable -> L7
        if (r0.renameTo(r7) == false) goto L16;
        closeQuietly(r1);
        r0.delete();
        return r7;
    L16:
        throw new IOException("failed to rename \"" + r0.getAbsolutePath() + "\" to \"" + r7.getAbsolutePath() + "\"");     // Catch: Throwable -> L7
    L18:
        throw new IOException("failed to mark readonly \"" + r0.getAbsolutePath() + "\" (tmp of \"" + r7.getAbsolutePath() + "\")");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        closeQuietly(r1);
        r0.delete();
        throw th;
    }

    public String getLoadedLibsInfo() {
        Map<String, LibRecorder> r0 = this.mLoadedLibMap;
        monitor-enter(r0);
        String r1 = this.mLoadedLibMap.toString();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v9, types: [com.bytedance.librarian.LibrarianImpl$Locker] */
    public void loadLibrary(String r12, boolean r13) {
        Map<String, LibRecorder> r6 = this.mLoadedLibMap;
        monitor-enter(r6);
        LibRecorder r7 = this.mLoadedLibMap.get(r12);     // Catch: Throwable -> L10
        if (r7 != null) goto L7;
        r7 = new LibRecorder();     // Catch: Throwable -> L10
        this.mLoadedLibMap.put(r12, r7);     // Catch: Throwable -> L10
    L13:
        monitor-exit(r6);     // Catch: Throwable -> L10
        monitor-enter(r7);
    L20:
        th = move-exception;
        throw th;
    L16:
        if (r7.loaded == false) goto L22;
        this.mMonitor.logDebug("lib was already loaded before: " + r12);     // Catch: Throwable -> L20
        monitor-exit(r7);     // Catch: Throwable -> L20
        return;
    L22:
        File r5 = new File(this.mWorkDir, getLibFileName(r12));     // Catch: Throwable -> L20
        boolean r8 = r5.exists();     // Catch: Throwable -> L20
        if (r13 == false) goto L83;
    L34:
        checkLazyInitialization();     // Catch: Throwable -> L20
        File r9 = r5;
        if (r8 == true) goto L88;
        Locker r3 = new File(this.mNativeLibDir, getLibFileName(r12));     // Catch: Throwable -> L20
        if (checkLibValid(r3) == false) goto L87;
        r9 = r3;
        goto L88
    L87:
        r3 = new Locker(this, this.mLockFile);     // Catch: Throwable -> L20
        r3.lock();     // Catch: Throwable -> L46 IOException -> L48
        if (extractLibFromZip(r5) == true) goto L52;
        if (r13 == false) goto L51;
        this.mMonitor.logDebug("may be system lib, no found " + r12);     // Catch: Throwable -> L46 IOException -> L48
        r3.close();     // Catch: Throwable -> L20
        monitor-exit(r7);     // Catch: Throwable -> L20
        return;
    L51:
        throw new LibrarianUnsatisfiedLinkError("fail to find " + r12);     // Catch: Throwable -> L46 IOException -> L48
    L52:
        r3.close();     // Catch: Throwable -> L20
        r9 = r5;
    L48:
        e = move-exception;
        throw new LibrarianUnsatisfiedLinkError("fail to extract " + r12, e);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L88:
        Iterator<String> r0 = obtainDependencies(r9).iterator();     // Catch: Throwable -> L20 IOException -> L66
    L61:
        if (r0.hasNext() == false) goto L81;
        String r1 = r0.next();     // Catch: Throwable -> L20 IOException -> L66
        String r2 = r1.substring(3, r1.length() - 3);     // Catch: Throwable -> L20 IOException -> L66
        if (isSystemLib(r2) == true) goto L61;
        this.mMonitor.logDebug("to load depended lib " + r2);     // Catch: Throwable -> L20 IOException -> L66
        loadLibrary(r2, r13);     // Catch: Throwable -> L20 IOException -> L66
    L81:
        this.mMonitor.systemLoad(r9.getPath());     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L72
        this.mMonitor.logDebug("loaded the lib " + r12);     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L72
        r7.loaded = true;     // Catch: Throwable -> L20
        monitor-exit(r7);     // Catch: Throwable -> L20
        return;
    L72:
        e = move-exception;
        throw new LibrarianUnsatisfiedLinkError("finally fail to load " + r9.getPath(), e);     // Catch: Throwable -> L20
    L66:
        e = move-exception;
        throw new LibrarianUnsatisfiedLinkError("fail to load depended lib", e);     // Catch: Throwable -> L20
    L83:
        if (r8 == false) goto L29;
        this.mMonitor.systemLoad(r5.getPath());     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L27
    L30:
        this.mMonitor.logDebug("lib is loaded: " + r12);     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L27
        r7.loaded = true;     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L27
        monitor-exit(r7);     // Catch: Throwable -> L20
        return;
    L29:
        this.mMonitor.systemLoadLibrary(r12);     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L27
    L27:
        e = move-exception;
        this.mMonitor.logWarning("fail to load " + r5.getName() + ", out lib exists: " + r8, e);     // Catch: Throwable -> L20
        goto L34
    L7:
        if (r7.loaded == false) goto L13;
        monitor-exit(r6);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
