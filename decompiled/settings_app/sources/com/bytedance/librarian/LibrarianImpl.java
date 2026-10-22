package com.bytedance.librarian;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.icu.text.DateFormat;
import android.os.Build;
import com.android.settings.utils.HanziToPinyin;
import com.android.settingslib.applications.RecentAppOpsAccess;
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

/* JADX INFO: loaded from: classes3.dex */
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

    interface Constants {
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

    static class LibRecorder {
        boolean loaded;

        LibRecorder() {
            this.loaded = false;
        }

        public String toString() {
            return Boolean.toString(this.loaded);
        }
    }

    class Locker {
        private FileLock cacheLock;
        private FileChannel lockChannel;
        private File lockFile;
        private RandomAccessFile lockRaf;
        final /* synthetic */ LibrarianImpl this$0;

        Locker(LibrarianImpl r1, File r2) {
            this.this$0 = r1;
            this.lockFile = r2;
        }

        void lock() throws IOException {
            RandomAccessFile r2 = new RandomAccessFile(this.lockFile, "rw");
            this.lockRaf = r2;
            this.lockChannel = r2.getChannel();     // Catch: IOException -> L10
            LibrarianImpl.access$000(this.this$0).logDebug("blocking on lock " + this.lockFile.getPath());     // Catch: IOException -> L7
            this.cacheLock = this.lockChannel.lock();     // Catch: IOException -> L7
            LibrarianImpl.access$000(this.this$0).logDebug("acquired on lock " + this.lockFile.getPath());     // Catch: IOException -> L10
            return;
        L7:
            e = move-exception;
            LibrarianImpl.access$100(this.this$0, this.lockChannel);     // Catch: IOException -> L10
            throw e;     // Catch: IOException -> L10
        L10:
            e = move-exception;
            LibrarianImpl.access$100(this.this$0, this.lockRaf);
            throw e;
        }

        void close() {
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
    }

    static /* synthetic */ LibrarianMonitor access$000(LibrarianImpl r0) {
        return r0.mMonitor;
    }

    static /* synthetic */ void access$100(LibrarianImpl r0, Closeable r1) {
        r0.closeQuietly(r1);
    }

    static {
        SYSTEM_LIB_LIST = new String[]{"log", DateFormat.MINUTE, "stdc++", "dl", "c", DateFormat.ABBR_SPECIFIC_TZ, RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME, "jnigraphics", "EGL", "GLESv1_CM", "GLESv2", "GLESv3", "OpenSLES", "OpenMAXAL"};
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
        File r5 = new File(r1, r3 + "." + (new File(r2.sourceDir).lastModified() >> 8));
        File[] r4 = r1.listFiles();
        if (r4 == null) goto L25;
        int r6 = r4.length;
        int r7 = 0;
    L14:
        if (r7 >= r6) goto L25;
        File r8 = r4[r7];
        if (r5.getName().equals(r8.getName()) == true) goto L24;
        File[] r9 = r8.listFiles();
        if (r9 == null) goto L23;
        int r10 = r9.length;
        int r11 = 0;
    L21:
        if (r11 >= r10) goto L23;
        r9[r11].delete();
        r11 = r11 + 1;
    L23:
        r8.delete();
    L24:
        r7 = r7 + 1;
    L25:
        r5.mkdirs();
        if (r5.exists() == true) goto L28;
        instance = null;
        return;
    L28:
        if (Librarian.sMonitor == null) goto L30;
        LibrarianMonitor r12 = Librarian.sMonitor;
    L31:
        instance = new LibrarianImpl(r2, r5, r12);
        return;
    L30:
        r12 = new LibrarianMonitor();
        goto L31
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

    String getLoadedLibsInfo() {
        Map<String, LibRecorder> r0 = this.mLoadedLibMap;
        monitor-enter(r0);
        String r1 = this.mLoadedLibMap.toString();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void loadLibrary(String r12, boolean r13) {
        Map<String, LibRecorder> r6 = this.mLoadedLibMap;
        monitor-enter(r6);
        LibRecorder r7 = this.mLoadedLibMap.get(r12);     // Catch: Throwable -> L73
        if (r7 != null) goto L7;
        r7 = new LibRecorder();     // Catch: Throwable -> L73
        this.mLoadedLibMap.put(r12, r7);     // Catch: Throwable -> L73
    L11:
        monitor-exit(r6);     // Catch: Throwable -> L73
        monitor-enter(r7);
    L70:
        th = move-exception;
        throw th;
    L14:
        if (r7.loaded == false) goto L18;
        this.mMonitor.logDebug("lib was already loaded before: " + r12);     // Catch: Throwable -> L70
        monitor-exit(r7);     // Catch: Throwable -> L70
        return;
    L18:
        File r5 = new File(this.mWorkDir, getLibFileName(r12));     // Catch: Throwable -> L70
        boolean r8 = r5.exists();     // Catch: Throwable -> L70
        if (r13 == false) goto L83;
    L29:
        checkLazyInitialization();     // Catch: Throwable -> L70
        if (r8 == true) goto L79;
        File r3 = new File(this.mNativeLibDir, getLibFileName(r12));     // Catch: Throwable -> L70
        if (checkLibValid(r3) == true) goto L52;
        Locker r4 = new Locker(this, this.mLockFile);     // Catch: Throwable -> L70
        r4.lock();     // Catch: Throwable -> L45 IOException -> L47
        if (extractLibFromZip(r5) == true) goto L43;
        if (r13 == false) goto L42;
        this.mMonitor.logDebug("may be system lib, no found " + r12);     // Catch: Throwable -> L45 IOException -> L47
        r4.close();     // Catch: Throwable -> L70
        monitor-exit(r7);     // Catch: Throwable -> L70
        return;
    L42:
        throw new LibrarianUnsatisfiedLinkError("fail to find " + r12);     // Catch: Throwable -> L45 IOException -> L47
    L43:
        r4.close();     // Catch: Throwable -> L70
    L45:
        th = move-exception;
        r4.close();     // Catch: Throwable -> L70
        throw th;     // Catch: Throwable -> L70
    L47:
        e = move-exception;
        throw new LibrarianUnsatisfiedLinkError("fail to extract " + r12, e);     // Catch: Throwable -> L45
    L52:
        r5 = r3;
    L79:
        Iterator<String> r0 = obtainDependencies(r5).iterator();     // Catch: IOException -> L67 Throwable -> L70
    L55:
        if (r0.hasNext() == false) goto L77;
        String r1 = r0.next();     // Catch: IOException -> L67 Throwable -> L70
        String r2 = r1.substring(3, r1.length() - 3);     // Catch: IOException -> L67 Throwable -> L70
        if (isSystemLib(r2) == true) goto L55;
        this.mMonitor.logDebug("to load depended lib " + r2);     // Catch: IOException -> L67 Throwable -> L70
        loadLibrary(r2, r13);     // Catch: IOException -> L67 Throwable -> L70
    L77:
        this.mMonitor.systemLoad(r5.getPath());     // Catch: UnsatisfiedLinkError -> L64 Throwable -> L70
        this.mMonitor.logDebug("loaded the lib " + r12);     // Catch: UnsatisfiedLinkError -> L64 Throwable -> L70
        r7.loaded = true;     // Catch: Throwable -> L70
        monitor-exit(r7);     // Catch: Throwable -> L70
        return;
    L64:
        e = move-exception;
        throw new LibrarianUnsatisfiedLinkError("finally fail to load " + r5.getPath(), e);     // Catch: Throwable -> L70
    L67:
        e = move-exception;
        throw new LibrarianUnsatisfiedLinkError("fail to load depended lib", e);     // Catch: Throwable -> L70
    L83:
        if (r8 == false) goto L23;
        this.mMonitor.systemLoad(r5.getPath());     // Catch: UnsatisfiedLinkError -> L27 Throwable -> L70
    L24:
        this.mMonitor.logDebug("lib is loaded: " + r12);     // Catch: UnsatisfiedLinkError -> L27 Throwable -> L70
        r7.loaded = true;     // Catch: UnsatisfiedLinkError -> L27 Throwable -> L70
        monitor-exit(r7);     // Catch: Throwable -> L70
        return;
    L23:
        this.mMonitor.systemLoadLibrary(r12);     // Catch: UnsatisfiedLinkError -> L27 Throwable -> L70
    L27:
        e = move-exception;
        this.mMonitor.logWarning("fail to load " + r5.getName() + ", out lib exists: " + r8, e);     // Catch: Throwable -> L70
        goto L29
    L7:
        if (r7.loaded == false) goto L11;
        monitor-exit(r6);     // Catch: Throwable -> L73
        return;
    L73:
        th = move-exception;
        throw th;
    }

    private void checkLazyInitialization() {
        if (this.mIsLazyInitialized == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L34:
        th = move-exception;
        throw th;
    L7:
        if (this.mIsLazyInitialized == true) goto L32;
        File r0 = new File(this.mApplicationInfo.sourceDir);     // Catch: Throwable -> L34
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L34
        r1.add(r0);     // Catch: Throwable -> L34
        String[] r2 = this.mApplicationInfo.splitSourceDirs;     // Catch: Throwable -> L34
        if (r2 != null) goto L11;
    L15:
        ZipFile[] r3 = new ZipFile[r1.size()];     // Catch: Throwable -> L34
        Iterator r4 = r1.iterator();     // Catch: Throwable -> L34
        int r5 = 0;
    L17:
        if (r4.hasNext() == false) goto L25;
        File r6 = (File) r4.next();     // Catch: Throwable -> L34
        int r7 = r5 + 1;
        r3[r5] = new ZipFile(r6);     // Catch: IOException -> L22 Throwable -> L34
    L24:
        r5 = r7;
    L22:
        e = move-exception;
        new LibrarianUnsatisfiedLinkError("fail to get zip file " + r6.getName(), e).printStackTrace();     // Catch: Throwable -> L34
        goto L24
    L25:
        this.mApkZipFiles = r3;     // Catch: Throwable -> L34
        this.mNativeLibDir = new File(this.mApplicationInfo.nativeLibraryDir);     // Catch: Throwable -> L34
        HashMap r8 = new HashMap();     // Catch: Throwable -> L34
        this.mAbiToInstructionSetMap = r8;     // Catch: Throwable -> L34
        r8.put("arm64-v8a", "arm64");     // Catch: Throwable -> L34
        this.mAbiToInstructionSetMap.put("armeabi-v7a", "arm");     // Catch: Throwable -> L34
        this.mAbiToInstructionSetMap.put("armeabi", "arm");     // Catch: Throwable -> L34
        String r9 = null;
        Class<?> r10 = Class.forName("dalvik.system.VMRuntime");     // Catch: Exception -> L29 Throwable -> L34
        r9 = (String) r10.getDeclaredMethod("vmInstructionSet", new Class[0]).invoke(r10.getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0]);     // Catch: Exception -> L29 Throwable -> L34
    L31:
        this.mVmInstructionSet = r9;     // Catch: Throwable -> L34
        this.mMonitor.logDebug("vm instruction set: " + this.mVmInstructionSet);     // Catch: Throwable -> L34
        this.mAbis = Build.SUPPORTED_ABIS;     // Catch: Throwable -> L34
        this.mIsLazyInitialized = true;     // Catch: Throwable -> L34
        goto L32
    L29:
        e = move-exception;
        this.mMonitor.logWarning("fail to get vm instruction set", e);     // Catch: Throwable -> L34
        goto L31
    L11:
        if (r2.length == 0) goto L15;
        int r11 = r2.length;     // Catch: Throwable -> L34
        int r12 = 0;
    L13:
        if (r12 >= r11) goto L15;
        r1.add(new File(r2[r12]));     // Catch: Throwable -> L34
        r12 = r12 + 1;     // Catch: Throwable -> L34
    L32:
        monitor-exit(this);     // Catch: Throwable -> L34
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

    private List<String> obtainDependencies(File r3) throws IOException {
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

    private boolean extractLibFromZip(File r8) throws IOException {
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

    private void ensureRuntimeAbi(String r11) {
        if (this.mAbi == null) goto L5;
        return;
    L5:
        String[] r0 = this.mAbis;
        int r1 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L19;
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
    L19:
        throw new LibrarianUnsatisfiedLinkError("can not ensure abi for " + r11 + ", check " + this.mVmInstructionSet + ", apks " + getApkZipFileInfo());
    }

    private String getApkZipFileInfo() {
        StringBuilder r0 = new StringBuilder("[");
        ZipFile[] r7 = this.mApkZipFiles;
        int r1 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        ZipFile r3 = r7[r2];
        String r4 = r3.getName();
        File r5 = new File(r4);
        r0.append(r4).append("#").append(r3.size()).append(":").append(r5.length()).append(HanziToPinyin.Token.SEPARATOR);
        r2 = r2 + 1;
        goto L3
    L5:
        r0.append("]");
        return r0.toString();
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

    private static String getLibFileName(String r2) {
        return Constants.LIB_PREFIX + r2 + Constants.SO_SUFFIX;
    }

    private File obtainEntryFileFromInputStream(InputStream r6, File r7) throws IOException {
        File r0 = File.createTempFile("tmp-", r7.getName(), r7.getParentFile());
        this.mMonitor.logDebug("extracting " + r0.getPath());
        FileOutputStream r1 = new FileOutputStream(r0);
        byte[] r2 = new byte[8192];     // Catch: Throwable -> L17
        int r3 = r6.read(r2);     // Catch: Throwable -> L17
    L5:
        if (r3 == (-1)) goto L8;
        r1.write(r2, 0, r3);     // Catch: Throwable -> L17
        r3 = r6.read(r2);     // Catch: Throwable -> L17
        goto L5
    L8:
        if (r0.setReadOnly() == false) goto L16;
        this.mMonitor.logDebug("renaming to " + r7.getPath());     // Catch: Throwable -> L17
        if (r0.renameTo(r7) == false) goto L14;
        closeQuietly(r1);
        r0.delete();
        return r7;
    L14:
        throw new IOException("failed to rename \"" + r0.getAbsolutePath() + "\" to \"" + r7.getAbsolutePath() + "\"");     // Catch: Throwable -> L17
    L16:
        throw new IOException("failed to mark readonly \"" + r0.getAbsolutePath() + "\" (tmp of \"" + r7.getAbsolutePath() + "\")");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        closeQuietly(r1);
        r0.delete();
        throw th;
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
}
