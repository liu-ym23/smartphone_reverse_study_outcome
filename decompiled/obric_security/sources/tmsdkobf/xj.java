package tmsdkobf;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes5.dex */
public abstract class xj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f624a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReentrantReadWriteLock f625a;
        public final AtomicInteger b;

        public a() {
            this.f625a = new ReentrantReadWriteLock();
            this.b = new AtomicInteger(0);
        }
    }

    static {
        f624a = new HashMap();
    }

    public static void a(Closeable r0) {
        r0.close();     // Catch: Throwable -> L4
        return;
    }

    public static boolean a(String r7, byte[] r8, boolean r9) {
        FileLock r0 = null;
        FileLock r1 = null;
        r1 = null;
        FileChannel r2 = null;
        if (r9 == false) goto L15;
        HashMap r3 = f624a;
        monitor-enter(r3);
        a r4 = (a) r3.get(r7);     // Catch: Throwable -> L12
        if (r4 != null) goto L9;
        r4 = new a();     // Catch: Throwable -> L12
        r3.put(r7, r4);     // Catch: Throwable -> L12
    L9:
        r4.b.incrementAndGet();     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
        r4.f625a.writeLock().lock();
    L63:
        RandomAccessFile r5 = new RandomAccessFile(r7, "rw");     // Catch: Throwable -> L42
        FileChannel r6 = r5.getChannel();     // Catch: Throwable -> L40
        if (r9 == true) goto L71;
    L20:
        r5.seek(0);     // Catch: Throwable -> L39
        r5.write(r8);     // Catch: Throwable -> L39
        r5.setLength(r8.length);     // Catch: Throwable -> L39
        if (r1 != null) goto L23;
    L25:
        j.a(r6);
        j.a(r5);
        if (r4 == null) goto L37;
        HashMap r10 = f624a;
        monitor-enter(r10);
        r4.f625a.writeLock().unlock();     // Catch: Throwable -> L34
        if (r4.b.decrementAndGet() != 0) goto L32;
        r10.remove(r7);     // Catch: Throwable -> L34
    L32:
        monitor-exit(r10);     // Catch: Throwable -> L34
        return true;
    L34:
        th = move-exception;
        throw th;
    L37:
        return true;
    L23:
        if (r1.isValid() == false) goto L25;
        r1.release();     // Catch: IOException -> L61
    L39:
        FileLock r11 = r1;
        r2 = r6;
    L41:
        FileChannel r12 = r2;
        r0 = r11;
        FileChannel r13 = r12;
    L43:
        if (r0 != null) goto L45;
    L47:
        j.a(r13);
        j.a(r5);
        if (r4 == null) goto L59;
        HashMap r14 = f624a;
        monitor-enter(r14);
        r4.f625a.writeLock().unlock();     // Catch: Throwable -> L56
        if (r4.b.decrementAndGet() != 0) goto L54;
        r14.remove(r7);     // Catch: Throwable -> L56
    L54:
        monitor-exit(r14);     // Catch: Throwable -> L56
        return false;
    L56:
        th = move-exception;
        throw th;
    L59:
        return false;
    L45:
        if (r0.isValid() == false) goto L47;
        r0.release();     // Catch: IOException -> L62
        goto L47
    L71:
        r1 = r6.lock();     // Catch: Throwable -> L39
    L40:
        r11 = null;
    L42:
        r13 = null;
        r5 = null;
    L12:
        th = move-exception;
        throw th;
    L15:
        r4 = null;
        goto L63
    }

    public static byte[] a(String r10, boolean r11) {
        if (r11 == false) goto L15;
        HashMap r1 = f624a;
        monitor-enter(r1);
        a r2 = (a) r1.get(r10);     // Catch: Throwable -> L12
        if (r2 != null) goto L9;
        r2 = new a();     // Catch: Throwable -> L12
        r1.put(r10, r2);     // Catch: Throwable -> L12
    L9:
        r2.b.incrementAndGet();     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        r2.f625a.readLock().lock();
    L70:
        RandomAccessFile r3 = new RandomAccessFile(r10, "r");     // Catch: Throwable -> L47
        FileChannel r4 = r3.getChannel();     // Catch: Throwable -> L46
        if (r11 == true) goto L75;
        FileLock r12 = null;
    L74:
        long r5 = r3.length();     // Catch: Throwable -> L66
        int r6 = (int) r5;     // Catch: Throwable -> L66
        if (r6 != r5) goto L45;
        byte[] r7 = new byte[r6];     // Catch: Throwable -> L66
        r3.readFully(r7);     // Catch: Throwable -> L66
        if (r12 != null) goto L29;
    L31:
        j.a(r4);
        j.a(r3);
        if (r2 == null) goto L43;
        HashMap r13 = f624a;
        monitor-enter(r13);
        r2.f625a.readLock().unlock();     // Catch: Throwable -> L40
        if (r2.b.decrementAndGet() != 0) goto L38;
        r13.remove(r10);     // Catch: Throwable -> L40
    L38:
        monitor-exit(r13);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        throw th;
    L43:
        return r7;
    L29:
        if (r12.isValid() == false) goto L31;
        r12.release();     // Catch: IOException -> L65
        goto L31
    L45:
        throw new IOException("");     // Catch: Throwable -> L66
    L48:
        if (r12 != null) goto L50;
    L52:
        j.a(r4);
        j.a(r3);
        if (r2 == null) goto L64;
        HashMap r14 = f624a;
        monitor-enter(r14);
        r2.f625a.readLock().unlock();     // Catch: Throwable -> L61
        if (r2.b.decrementAndGet() != 0) goto L59;
        r14.remove(r10);     // Catch: Throwable -> L61
    L59:
        monitor-exit(r14);     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        throw th;
    L64:
        return null;
    L50:
        if (r12.isValid() == false) goto L52;
        r12.release();     // Catch: IOException -> L67
        goto L52
    L75:
        r12 = r4.lock(0, Long.MAX_VALUE, true);     // Catch: Throwable -> L22
    L22:
        r12 = null;
    L46:
        r12 = null;
        r4 = null;
    L47:
        r12 = null;
        r3 = null;
        r4 = null;
    L12:
        th = move-exception;
        throw th;
    L15:
        r2 = null;
        goto L70
    }

    public static byte[] a(String r6, int r7) {
        File r0 = new File(r6);
        if (r0.exists() == true) goto L24;
        return null;
    L24:
        FileInputStream r8 = new FileInputStream(r0);     // Catch: Throwable -> L20
        byte[] r1 = new byte[r7];     // Catch: Throwable -> L23
        int r3 = 0;
    L7:
        int r4 = r8.read(r1, r3, r7 - r3);     // Catch: Throwable -> L23
        if (r4 == (-1)) goto L12;
        r3 = r3 + r4;
        if (r3 < r7) goto L7;
    L12:
        if (r3 != 0) goto L15;
        j.a(r8);
        return null;
    L15:
        if (r3 >= r7) goto L18;
        byte[] r9 = new byte[r3];     // Catch: Throwable -> L23
        System.arraycopy(r1, 0, r9, 0, r3);     // Catch: Throwable -> L23
        r1 = r9;
    L18:
        j.a(r8);
        return r1;
    L21:
        j.a(r8);
        return null;
    L20:
        r8 = null;
        goto L21
    }

    public static byte[] a(String r4) {
        FileInputStream r1 = new FileInputStream(r4);     // Catch: Throwable -> L15
        ByteArrayOutputStream r5 = new ByteArrayOutputStream(r1.available());     // Catch: Throwable -> L13
        j.a(r1, r5);     // Catch: Throwable -> L11
        byte[] r0 = r5.toByteArray();     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        r0 = "".getBytes();     // Catch: Throwable -> L11
    L9:
        j.a(r1);
        j.a(r5);
        return r0;
    L11:
        Throwable th = th;
    L21:
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        j.a(r1);
        j.a(r5);
        throw th;
    L13:
        th = move-exception;
        th = th;
        r5 = null;
    L15:
        th = move-exception;
        r1 = null;
        th = th;
        r5 = null;
        goto L21
    }

    public static boolean a(File r5) {
        if (r5.exists() == true) goto L7;
        return true;
    L7:
        if (r5.isDirectory() == false) goto L19;
        File[] r0 = r5.listFiles();
        if (r0 == null) goto L21;
        int r2 = r0.length;
        int r3 = 0;
    L14:
        if (r3 >= r2) goto L21;
        a(r0[r3]);
        r3 = r3 + 1;
    L21:
        return r5.delete();
    L18:
        return false;
    L19:
        return r5.delete();
    L10:
        return false;
    }
}
