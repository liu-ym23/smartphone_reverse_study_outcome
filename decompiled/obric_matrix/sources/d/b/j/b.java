package d.b.j;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import d.b.j.e.i;
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
class b {
    static final b m = null;
    private static final String[] n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f13941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f13942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, a> f13943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f13944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f13945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private File f13946f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ZipFile[] f13947g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f13948h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ApplicationInfo f13949i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<String, String> f13950j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String[] f13951k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f13952l;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f13953a;

        a() {
            this.f13953a = false;
        }

        public String toString() {
            return Boolean.toString(this.f13953a);
        }
    }

    /* JADX INFO: renamed from: d.b.j.b$b, reason: collision with other inner class name */
    class C0370b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RandomAccessFile f13954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private FileLock f13955b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private FileChannel f13956c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private File f13957d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f13958e;

        C0370b(b r1, File r2) {
            this.f13958e = r1;
            this.f13957d = r2;
        }

        void a() {
            FileLock r0 = this.f13955b;
            if (r0 != null) goto L8;
        L5:
            b.a(this.f13958e).a("released lock " + this.f13957d.getPath());
            b.b(this.f13958e, this.f13956c);
            b.b(this.f13958e, this.f13954a);
            return;
        L8:
            r0.release();     // Catch: IOException -> L7
            goto L5
        }

        void b() {
            RandomAccessFile r0 = new RandomAccessFile(this.f13957d, "rw");
            this.f13954a = r0;
            this.f13956c = r0.getChannel();     // Catch: IOException -> L10
            b.a(this.f13958e).a("blocking on lock " + this.f13957d.getPath());     // Catch: IOException -> L7
            this.f13955b = this.f13956c.lock();     // Catch: IOException -> L7
            b.a(this.f13958e).a("acquired on lock " + this.f13957d.getPath());     // Catch: IOException -> L10
            return;
        L7:
            e = move-exception;
            b.b(this.f13958e, this.f13956c);     // Catch: IOException -> L10
            throw e;     // Catch: IOException -> L10
        L10:
            e = move-exception;
            b.b(this.f13958e, this.f13954a);
            throw e;
        }
    }

    static {
        n = new String[]{"log", "m", "stdc++", "dl", "c", "z", "android", "jnigraphics", "EGL", "GLESv1_CM", "GLESv2", "GLESv3", "OpenSLES", "OpenMAXAL"};
        Context r0 = d.b.j.a.f13937a;
        b r1 = null;
        d.b.j.a.f13937a = null;
        if (r0 == null) goto L35;
        ApplicationInfo r2 = r0.getApplicationInfo();
        File r3 = r0.getDir("librarian", 0);
        if (r3.exists() == true) goto L8;
        r3.mkdirs();
    L8:
        if (d.b.j.a.f13938b == null) goto L10;
        String r4 = d.b.j.a.f13938b;
    L11:
        File r5 = new File(r3, r4 + "." + (new File(r2.sourceDir).lastModified() >> 8));
        File[] r6 = r3.listFiles();
        if (r6 == null) goto L25;
        int r7 = r6.length;
        int r8 = 0;
    L14:
        if (r8 >= r7) goto L25;
        File r9 = r6[r8];
        if (r5.getName().equals(r9.getName()) == true) goto L24;
        File[] r10 = r9.listFiles();
        if (r10 == null) goto L23;
        int r11 = r10.length;
        int r12 = 0;
    L21:
        if (r12 >= r11) goto L23;
        r10[r12].delete();
        r12 = r12 + 1;
    L23:
        r9.delete();
    L24:
        r8 = r8 + 1;
    L25:
        r5.mkdirs();
        if (r5.exists() == false) goto L32;
        c r13 = d.b.j.a.f13939c;
        if (r13 != null) goto L31;
        r13 = new c();
    L31:
        r1 = new b(r2, r5, r13);
    L32:
        m = r1;
        return;
    L10:
        r4 = "default.version";
        goto L11
    L35:
        throw new d("you should call init first or use loadLibraryForModule.");
    }

    private b(ApplicationInfo r1, File r2, c r3) {
        this.f13941a = r2;
        this.f13942b = r3;
        this.f13949i = r1;
        this.f13944d = new File(r2, "process.lock");
        this.f13943c = new HashMap();
    }

    static /* synthetic */ c a(b r0) {
        return r0.f13942b;
    }

    static /* synthetic */ void b(b r0, Closeable r1) {
        r0.f(r1);
    }

    private void c() {
        int r0 = Build.VERSION.SDK_INT;
        if (this.f13945e == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L41:
        th = move-exception;
        throw th;
    L7:
        if (this.f13945e == true) goto L39;
        File r1 = new File(this.f13949i.sourceDir);     // Catch: Throwable -> L41
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L41
        r2.add(r1);     // Catch: Throwable -> L41
        if (r0 < 21) goto L17;
        String[] r4 = this.f13949i.splitSourceDirs;     // Catch: Throwable -> L41
        if (r4 == null) goto L17;
        if (r4.length == 0) goto L17;
        int r5 = r4.length;     // Catch: Throwable -> L41
        int r6 = 0;
    L15:
        if (r6 >= r5) goto L17;
        r2.add(new File(r4[r6]));     // Catch: Throwable -> L41
        r6 = r6 + 1;     // Catch: Throwable -> L41
    L17:
        ZipFile[] r7 = new ZipFile[r2.size()];     // Catch: Throwable -> L41
        Iterator r3 = r2.iterator();     // Catch: Throwable -> L41
        int r8 = 0;
    L19:
        if (r3.hasNext() == false) goto L27;
        File r9 = (File) r3.next();     // Catch: Throwable -> L41
        int r10 = r8 + 1;
        r7[r8] = new ZipFile(r9);     // Catch: IOException -> L24 Throwable -> L41
    L26:
        r8 = r10;
    L24:
        e = move-exception;
        new d("fail to get zip file " + r9.getName(), e).printStackTrace();     // Catch: Throwable -> L41
        goto L26
    L27:
        this.f13947g = r7;     // Catch: Throwable -> L41
        this.f13946f = new File(this.f13949i.nativeLibraryDir);     // Catch: Throwable -> L41
        HashMap r11 = new HashMap();     // Catch: Throwable -> L41
        this.f13950j = r11;     // Catch: Throwable -> L41
        r11.put("arm64-v8a", "arm64");     // Catch: Throwable -> L41
        this.f13950j.put("armeabi-v7a", "arm");     // Catch: Throwable -> L41
        this.f13950j.put("armeabi", "arm");     // Catch: Throwable -> L41
        String r12 = null;
        if (r0 >= 21) goto L48;
    L34:
        this.f13948h = r12;     // Catch: Throwable -> L41
        this.f13942b.a("vm instruction set: " + this.f13948h);     // Catch: Throwable -> L41
        if (r0 >= 21) goto L37;
        String[] r13 = {Build.CPU_ABI, Build.CPU_ABI2};     // Catch: Throwable -> L41
    L38:
        this.f13951k = r13;     // Catch: Throwable -> L41
        this.f13945e = true;     // Catch: Throwable -> L41
        goto L39
    L37:
        r13 = Build.SUPPORTED_ABIS;     // Catch: Throwable -> L41
        goto L38
    L48:
        Class<?> r14 = Class.forName("dalvik.system.VMRuntime");     // Catch: Exception -> L32 Throwable -> L41
        r12 = (String) r14.getDeclaredMethod("vmInstructionSet", new Class[0]).invoke(r14.getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0]);     // Catch: Exception -> L32 Throwable -> L41
        goto L34
    L32:
        e = move-exception;
        this.f13942b.c("fail to get vm instruction set", e);     // Catch: Throwable -> L41
    L39:
        monitor-exit(this);     // Catch: Throwable -> L41
    }

    private boolean d(File r9) {
        if (r9.exists() == true) goto L7;
        c r8 = this.f13942b;
        String r10 = "file is not exist: " + r9.getPath();
    L5:
        r8.b(r10);
        return false;
    L7:
        h(r9.getName());
        long r2 = 0;
        String r0 = "lib/" + this.f13952l + "/" + r9.getName();
        ZipFile[] r4 = this.f13947g;
        int r5 = r4.length;
        int r6 = 0;
    L8:
        if (r6 >= r5) goto L13;
        ZipEntry r7 = r4[r6].getEntry(r0);
        if (r7 != null) goto L11;
        r6 = r6 + 1;
        goto L8
    L11:
        r2 = r7.getCrc();
    L13:
        long r11 = g(r9);
        r8 = this.f13942b;
        if (r2 != r11) goto L17;
        r8.a(r0 + " compare crc ok: entry is " + r2 + ", file is " + r11);
        return true;
    L17:
        r10 = r0 + " crc is wrong: entry is " + r2 + ", file is " + r11;
        goto L5
    }

    private boolean e(String r2) {
        if (this.f13948h != null) goto L6;
        return true;
    L6:
        String r0 = this.f13950j.get(r2);
        String r1 = this.f13948h;
        if (r0 == null) goto L10;
        r2 = r0;
    L10:
        return r1.equals(r2);
    }

    private void f(Closeable r2) {
        if (r2 != null) goto L9;
        return;
    L9:
        r2.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        this.f13942b.c("failed to close resource", e);
    }

    private long g(File r6) {
        byte[] r0 = new byte[8192];
        Closeable r1 = null;
        CheckedInputStream r2 = new CheckedInputStream(new FileInputStream(r6), new CRC32());     // Catch: Throwable -> L13 IOException -> L15
    L25:
    L11:
        e = e;
        r1 = r2;
    L16:
        this.f13942b.c("fail to check sum for " + r6.getPath(), e);     // Catch: Throwable -> L13
        f(r1);
        return 0;
    L9:
        th = th;
        r1 = r2;
    L19:
        f(r1);
        throw th;
    L5:
        if (r2.read(r0) >= 0) goto L25;
        long r3 = r2.getChecksum().getValue();     // Catch: Throwable -> L9 IOException -> L11
        f(r2);
        return r3;
    L13:
        th = th;
    L15:
        e = e;
        goto L16
    }

    private void h(String r11) {
        if (this.f13952l == null) goto L5;
        return;
    L5:
        String[] r0 = this.f13951k;
        int r1 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L19;
        String r4 = r0[r3];
        if (e(r4) == false) goto L17;
        String r5 = "lib/" + r4 + "/" + r11;
        ZipFile[] r6 = this.f13947g;
        int r7 = r6.length;
        int r8 = 0;
    L11:
        if (r8 >= r7) goto L17;
        if (r6[r8].getEntry(r5) != null) goto L14;
        r8 = r8 + 1;
        goto L11
    L14:
        this.f13952l = r4;
        this.f13942b.a("ensure that abi is " + r4);
        return;
    L17:
        r3 = r3 + 1;
        goto L6
    L19:
        throw new d("can not ensure abi for " + r11 + ", check " + this.f13948h + ", apks " + j());
    }

    private boolean i(File r8) {
        h(r8.getName());
        String r0 = "lib/" + this.f13952l + "/" + r8.getName();
        ZipFile[] r1 = this.f13947g;
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
        o(r3, r8);     // Catch: Throwable -> L11
        this.f13942b.a("get lib file " + r8.getPath() + " from " + r0 + " of " + r5.getName());     // Catch: Throwable -> L11
        f(r3);
        return true;
    L11:
        th = move-exception;
        f(r3);
        throw th;
    L14:
        return false;
    }

    private String j() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[");
        ZipFile[] r6 = this.f13947g;
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

    private static String k(String r2) {
        return "lib" + r2 + ".so";
    }

    private boolean l(String r5) {
        String[] r4 = n;
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

    private List<String> n(File r3) {
        Closeable r0 = null;
        i r1 = new i(r3);     // Catch: Throwable -> L9
        List<String> r4 = r1.g();     // Catch: Throwable -> L7
        Collections.sort(r4);     // Catch: Throwable -> L7
        f(r1);
        return r4;
    L7:
        th = th;
        r0 = r1;
    L10:
        f(r0);
        throw th;
    L9:
        th = th;
        goto L10
    }

    private File o(InputStream r6, File r7) {
        File r0 = File.createTempFile("tmp-", r7.getName(), r7.getParentFile());
        this.f13942b.a("extracting " + r0.getPath());
        FileOutputStream r1 = new FileOutputStream(r0);
        byte[] r2 = new byte[8192];     // Catch: Throwable -> L17
    L4:
        int r3 = r6.read(r2);     // Catch: Throwable -> L17
        if (r3 == (-1)) goto L8;
        r1.write(r2, 0, r3);     // Catch: Throwable -> L17
        goto L4
    L8:
        if (r0.setReadOnly() == false) goto L16;
        this.f13942b.a("renaming to " + r7.getPath());     // Catch: Throwable -> L17
        if (r0.renameTo(r7) == false) goto L14;
        f(r1);
        r0.delete();
        return r7;
    L14:
        throw new IOException("failed to rename \"" + r0.getAbsolutePath() + "\" to \"" + r7.getAbsolutePath() + "\"");     // Catch: Throwable -> L17
    L16:
        throw new IOException("failed to mark readonly \"" + r0.getAbsolutePath() + "\" (tmp of \"" + r7.getAbsolutePath() + "\")");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        f(r1);
        r0.delete();
        throw th;
    }

    void m(String r9, boolean r10) {
        Map<String, a> r0 = this.f13943c;
        monitor-enter(r0);
        a r1 = this.f13943c.get(r9);     // Catch: Throwable -> L73
        if (r1 != null) goto L7;
        r1 = new a();     // Catch: Throwable -> L73
        this.f13943c.put(r9, r1);     // Catch: Throwable -> L73
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L73
        monitor-enter(r1);
    L70:
        th = move-exception;
        throw th;
    L14:
        if (r1.f13953a == false) goto L18;
        this.f13942b.a("lib was already loaded before: " + r9);     // Catch: Throwable -> L70
        monitor-exit(r1);     // Catch: Throwable -> L70
        return;
    L18:
        File r2 = new File(this.f13941a, k(r9));     // Catch: Throwable -> L70
        boolean r3 = r2.exists();     // Catch: Throwable -> L70
        if (r10 == false) goto L82;
    L29:
        c();     // Catch: Throwable -> L70
        if (r3 == true) goto L77;
        File r4 = new File(this.f13946f, k(r9));     // Catch: Throwable -> L70
        if (d(r4) == true) goto L52;
        C0370b r5 = new C0370b(this, this.f13944d);     // Catch: Throwable -> L70
        r5.b();     // Catch: Throwable -> L45 IOException -> L47
        if (i(r2) == true) goto L43;
        if (r10 == false) goto L42;
        this.f13942b.a("may be system lib, no found " + r9);     // Catch: Throwable -> L45 IOException -> L47
        r5.a();     // Catch: Throwable -> L70
        monitor-exit(r1);     // Catch: Throwable -> L70
        return;
    L42:
        throw new d("fail to find " + r9);     // Catch: Throwable -> L45 IOException -> L47
    L43:
        r5.a();     // Catch: Throwable -> L70
    L45:
        th = move-exception;
        r5.a();     // Catch: Throwable -> L70
        throw th;     // Catch: Throwable -> L70
    L47:
        e = move-exception;
        throw new d("fail to extract " + r9, e);     // Catch: Throwable -> L45
    L52:
        r2 = r4;
    L77:
        Iterator<String> r6 = n(r2).iterator();     // Catch: IOException -> L67 Throwable -> L70
    L55:
        if (r6.hasNext() == false) goto L79;
        String r7 = r6.next();     // Catch: IOException -> L67 Throwable -> L70
        String r8 = r7.substring(3, r7.length() - 3);     // Catch: IOException -> L67 Throwable -> L70
        if (l(r8) == true) goto L55;
        this.f13942b.a("to load depended lib " + r8);     // Catch: IOException -> L67 Throwable -> L70
        m(r8, r10);     // Catch: IOException -> L67 Throwable -> L70
    L79:
        this.f13942b.d(r2.getPath());     // Catch: UnsatisfiedLinkError -> L64 Throwable -> L70
        this.f13942b.a("loaded the lib " + r9);     // Catch: UnsatisfiedLinkError -> L64 Throwable -> L70
        r1.f13953a = true;     // Catch: Throwable -> L70
        monitor-exit(r1);     // Catch: Throwable -> L70
        return;
    L64:
        e = move-exception;
        throw new d("finally fail to load " + r2.getPath(), e);     // Catch: Throwable -> L70
    L67:
        e = move-exception;
        throw new d("fail to load depended lib", e);     // Catch: Throwable -> L70
    L82:
        if (r3 == false) goto L23;
        this.f13942b.d(r2.getPath());     // Catch: UnsatisfiedLinkError -> L27 Throwable -> L70
    L24:
        this.f13942b.a("lib is loaded: " + r9);     // Catch: UnsatisfiedLinkError -> L27 Throwable -> L70
        r1.f13953a = true;     // Catch: UnsatisfiedLinkError -> L27 Throwable -> L70
        monitor-exit(r1);     // Catch: Throwable -> L70
        return;
    L23:
        this.f13942b.e(r9);     // Catch: UnsatisfiedLinkError -> L27 Throwable -> L70
    L27:
        e = move-exception;
        this.f13942b.c("fail to load " + r2.getName() + ", out lib exists: " + r3, e);     // Catch: Throwable -> L70
        goto L29
    L7:
        if (r1.f13953a == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L73
        return;
    L73:
        th = move-exception;
        throw th;
    }
}
