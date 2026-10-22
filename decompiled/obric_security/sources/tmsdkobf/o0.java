package tmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public abstract class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f378a = null;
    public static final Object b = null;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f379a;

        public a(b r1) {
            this.f379a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r12 = this.f379a.toString();
            monitor-enter(mh.class);
            Context r2 = mh.f353a;     // Catch: Throwable -> L44
            monitor-exit(mh.class);
            File r0 = new File(r2.getDir("turingfd", 0), q3.f);
            int r1 = r12.length();
            Object r3 = o0.b;
            monitor-enter(r3);
            ByteArrayOutputStream r4 = new ByteArrayOutputStream();     // Catch: Throwable -> L41
            FileLock r5 = null;
            RandomAccessFile r6 = new RandomAccessFile(r0, "rw");     // Catch: Throwable -> L32
            FileChannel r7 = r6.getChannel();     // Catch: Throwable -> L31
            r5 = r7.lock();     // Catch: Throwable -> L48
            if (r6.length() == 0) goto L21;
            ByteBuffer r8 = ByteBuffer.allocate(1024);     // Catch: Throwable -> L48
        L15:
            int r9 = r7.read(r8);     // Catch: Throwable -> L48
            if (r9 <= 0) goto L18;
            r4.write(r8.array(), 0, r9);     // Catch: Throwable -> L48
            r8.clear();     // Catch: Throwable -> L48
            goto L15
        L18:
            r12 = r4 + "," + r12;     // Catch: Throwable -> L48
            if (r12.length() <= ((r1 + 1) * 50)) goto L21;
            r12 = r12.substring(r12.indexOf(",") + 1);     // Catch: Throwable -> L48
        L21:
            r7.position(0);     // Catch: Throwable -> L48
            ByteBuffer r13 = ByteBuffer.wrap(r12.getBytes());     // Catch: Throwable -> L48
        L23:
            if (r13.hasRemaining() == false) goto L25;
            r7.write(r13);     // Catch: Throwable -> L48
            goto L23
        L25:
            r7.truncate(r13.position());     // Catch: Throwable -> L48
            if (r5 != null) goto L28;
        L30:
            j.a(r7);     // Catch: Throwable -> L41
        L38:
            j.a(r6);     // Catch: Throwable -> L41
            monitor-exit(r3);     // Catch: Throwable -> L41
            return;
        L28:
            if (r5.isValid() == false) goto L30;
            r5.release();     // Catch: IOException -> L47 Throwable -> L41
        L33:
            if (r5 != null) goto L35;
        L37:
            j.a(r7);     // Catch: Throwable -> L41
            goto L38
        L35:
            if (r5.isValid() == false) goto L37;
            r5.release();     // Catch: IOException -> L49 Throwable -> L41
        L31:
            r7 = null;
        L32:
            r7 = null;
            r6 = null;
        L41:
            th = move-exception;
            throw th;
        L44:
            th = move-exception;
            throw th;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f380a;
        public final String b;

        public b(long r1, String r3) {
            this.f380a = r1;
            this.b = r3;
        }

        public String toString() {
            return this.f380a + ":" + this.b;
        }
    }

    static {
        f378a = new HashMap();
        new AtomicBoolean(false);
        b = new Object();
        new AtomicReference();
    }

    public static void a(long r18, String r20) {
        if (TextUtils.isEmpty(r20) == false) goto L5;
        return;
    L5:
        b r0 = new b(r18, r20);
        byte[] r1 = r20.getBytes();
        ByteBuffer r2 = ByteBuffer.wrap(r1);
        int r3 = r1.length;
        long r4 = ((long) r3) * (-4132994306676758123L);
        int r7 = r3 >> 3;
        int r8 = 0;
    L7:
        if (r8 >= r7) goto L9;
        int r15 = r8 << 3;
        long r5 = ((((((((((long) r2.get(r15)) & 255) + ((((long) r2.get(r15 + 1)) & 255) << 8)) + ((((long) r2.get(r15 + 2)) & 255) << 16)) + ((((long) r2.get(r15 + 3)) & 255) << 24)) + ((((long) r2.get(r15 + 4)) & 255) << 32)) + ((((long) r2.get(r15 + 5)) & 255) << 40)) + ((((long) r2.get(r15 + 6)) & 255) << 48)) + ((((long) r2.get(r15 + 7)) & 255) << 56)) * (-4132994306676758123L);
        r4 = (r4 ^ ((r5 ^ (r5 >>> 47)) * (-4132994306676758123L))) * (-4132994306676758123L);
        r8 = r8 + 1;
        goto L7
    L9:
        int r6 = r3 & 7;
        switch(r6) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            default: goto L11;
        };
    L11:
        long r9 = -4132994306676758123L;
    L19:
        long r10 = (r4 ^ (r4 >>> 47)) * r9;
        String r11 = String.valueOf(r10 ^ (r10 >>> 47));
        HashMap r12 = f378a;
        monitor-enter(r12);
        r12.put(r11, r0);     // Catch: Throwable -> L25
        monitor-exit(r12);     // Catch: Throwable -> L25
        xh.f623a.submit(new a(r0));
        return;
    L25:
        th = move-exception;
        throw th;
    L12:
        r4 = r4 ^ (((long) r2.get((r3 - r6) + 6)) << 48);
    L13:
        r4 = r4 ^ (((long) r2.get((r3 - r6) + 5)) << 40);
    L14:
        r4 = r4 ^ (((long) r2.get((r3 - r6) + 4)) << 32);
    L15:
        r4 = r4 ^ (((long) r2.get((r3 - r6) + 3)) << 24);
    L16:
        r4 = r4 ^ (((long) r2.get((r3 - r6) + 2)) << 16);
    L17:
        r4 = r4 ^ (((long) r2.get((r3 - r6) + 1)) << 8);
    L18:
        long r13 = ((long) r2.get(r3 - r6)) ^ r4;
        r9 = -4132994306676758123L;
        r4 = r13 * (-4132994306676758123L);
        goto L19
    }
}
