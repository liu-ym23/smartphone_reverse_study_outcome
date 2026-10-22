package d.b.b.e.a.j;

import com.bytedance.common.wschannel.WsConstants;
import d.b.b.o.d;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f12635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ByteBuffer f12637c;

    class a implements FileFilter {
        a(c r1) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File r2) {
            String r1 = r2.getName();
            if (r1.endsWith(".log") == false) goto L7;
            return true;
        L7:
            if (r1.endsWith(".txt") == false) goto L9;
            return false;
        L9:
            d.b.b.o.c.a(r2);
            return false;
        }
    }

    class b implements d.b.b.l.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f12638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f12639b;

        b(c r1, JSONObject r2, JSONObject r3) {
            this.f12638a = r2;
            this.f12639b = r3;
        }

        @Override // d.b.b.l.b
        public String a() {
            return "service_monitor";
        }

        @Override // d.b.b.l.b
        public boolean b() {
            return true;
        }

        @Override // d.b.b.l.b
        public JSONObject c() {
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
            r0.put("log_type", "service_monitor");     // Catch: Exception -> L4
            r0.put("service", "apm_error");     // Catch: Exception -> L4
            JSONObject r1 = new JSONObject();     // Catch: Exception -> L4
            r1.put(WsConstants.KEY_CONNECTION_TYPE, "large_data");     // Catch: Exception -> L4
            r1.put("error_service", this.f12638a);     // Catch: Exception -> L4
            r1.put("error_log_type", this.f12639b);     // Catch: Exception -> L4
            r0.put("category", r1);     // Catch: Exception -> L4
            return r0;
        L4:
            return null;
        }
    }

    public c(long r7, File r9, File r10) {
        this.f12635a = r10;
        this.f12636b = r7;
        FileChannel r0 = new RandomAccessFile(r9, "rw").getChannel();     // Catch: Throwable -> L5
        r0.tryLock();     // Catch: Throwable -> L5
        this.f12637c = r0.map(FileChannel.MapMode.READ_WRITE, 0, 262162);     // Catch: Throwable -> L5
        b();     // Catch: Throwable -> L5
    L8:
        if (this.f12637c != null) goto L10;
        this.f12637c = ByteBuffer.allocate(262162);
    L10:
        j();
        return;
    L5:
        th = move-exception;
        d.b.b.o.m.b.c(d.b.b.e.a.a.f12571a, "create MappedByteBuffer failed. will fallback into HeapByteBuffer", th);
        goto L8
    }

    private d.b.b.l.b a(JSONObject r3) {
        JSONObject r0 = null;
        if (r3 == null) goto L5;
        JSONObject r1 = r3.optJSONObject("service");
    L6:
        if (r3 == null) goto L9;
        r0 = r3.optJSONObject("log_type");
    L9:
        return new b(this, r1, r0);
    L5:
        r1 = null;
        goto L6
    }

    private void c() {
        this.f12637c.position(f() + 18);
        this.f12637c.flip();
        d.b.b.e.a.j.a r3 = d.b.b.e.a.j.a.b(this.f12637c);
        if (d.b.b.o.a.c() == false) goto L5;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "flush to memory success. logFile=" + r3);
    L5:
        d.b.b.e.a.c.h().n(r3);
    }

    private long d() {
        return this.f12637c.getLong(2);
    }

    private short e() {
        return this.f12637c.getShort(0);
    }

    private int f() {
        return this.f12637c.getInt(14);
    }

    private int g() {
        return this.f12637c.getInt(10);
    }

    private void j() {
        this.f12637c.clear();
        this.f12637c.putShort(2082);
        this.f12637c.putLong(this.f12636b);
        this.f12637c.putInt(0);
        this.f12637c.putInt(0);
    }

    private void k(int r2) {
        this.f12637c.putInt(14, r2);
    }

    private void l(int r2) {
        this.f12637c.putInt(10, r2);
    }

    public synchronized void b() {
        monitor-enter(this);
        short r0 = e();     // Catch: Throwable -> L51
        long r1 = d();     // Catch: Throwable -> L51
        int r3 = g();     // Catch: Throwable -> L51
        int r4 = f();     // Catch: Throwable -> L51
        if (r0 != 2082) goto L46;
        if (r4 <= 0) goto L46;
        if (r3 <= 0) goto L46;
        if (d.b.b.o.a.c() == false) goto L11;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "flushing: headerId=" + r1 + " totalCount=" + r3 + " totalBytes=" + r4);     // Catch: Throwable -> L51
    L11:
        long r2 = System.nanoTime();     // Catch: Throwable -> L51
        FileChannel r5 = null;
        boolean r6 = false;
        String r7 = System.currentTimeMillis() + "_" + UUID.randomUUID().toString();     // Catch: Throwable -> L35
    L21:
        th = move-exception;
        d.b.b.o.m.b.c(d.b.b.e.a.a.f12571a, "flushDir create error.", th);     // Catch: Throwable -> L35
    L23:
        File r8 = new File(this.f12635a, r7 + ".txt");     // Catch: Throwable -> L35
        if (r8.exists() == false) goto L26;
        d.b.b.o.m.b.b(d.b.b.e.a.a.f12571a, "file is exist:" + r8.getName());     // Catch: Throwable -> L35
    L26:
        r5 = new FileOutputStream(r8, false).getChannel();     // Catch: Throwable -> L35
        this.f12637c.position(r4 + 18);     // Catch: Throwable -> L35
        this.f12637c.flip();     // Catch: Throwable -> L35
        r5.write(this.f12637c);     // Catch: Throwable -> L35
        if (r8.renameTo(new File(this.f12635a, r7 + ".log")) == false) goto L29;
        r6 = true;
    L31:
        if (d.b.b.o.a.c() == false) goto L33;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "flush to file success. flushFile=" + r8.getAbsolutePath());     // Catch: Throwable -> L35
    L33:
        d.a(r5);     // Catch: Throwable -> L51
        if (r6 == true) goto L40;
        c();     // Catch: Throwable -> L51
    L40:
        j();     // Catch: Throwable -> L51
        if (d.b.b.o.a.c() == false) goto L43;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "flush cost=" + (System.nanoTime() - r2));     // Catch: Throwable -> L51
    L43:
        monitor-exit(this);
        return;
    L29:
        d.b.b.o.m.b.b(d.b.b.e.a.a.f12571a, "rename error" + r8.getAbsolutePath());     // Catch: Throwable -> L35
        goto L31
    L15:
        if (this.f12635a.exists() == true) goto L23;
        File r9 = this.f12635a.getParentFile();     // Catch: Throwable -> L21
        if (r9.exists() == true) goto L19;
        r9.mkdirs();     // Catch: Throwable -> L21
    L19:
        this.f12635a.mkdirs();     // Catch: Throwable -> L21
    L35:
        th = move-exception;
        d.b.b.o.m.b.c(d.b.b.e.a.a.f12571a, this.f12635a.exists() + " flush to file failed.", th);     // Catch: Throwable -> L54
    L46:
        if (d.b.b.o.a.c() == false) goto L48;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "flushing: Skipped. no data to flush. reset buffer now.");     // Catch: Throwable -> L51
    L48:
        j();     // Catch: Throwable -> L51
        monitor-exit(this);
        return;
    L51:
        th = move-exception;
        throw th;
    }

    public synchronized String[] h() {
        monitor-enter(this);
        File[] r0 = d.b.b.e.a.b.b().listFiles(new a(this));     // Catch: Throwable -> L14
        if (r0 == null) goto L6;
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L14
        int r2 = r0.length;     // Catch: Throwable -> L14
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L11;
        r1.add(r0[r3].getName());     // Catch: Throwable -> L14
        r3 = r3 + 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        String[] r4 = (String[]) r1.toArray(new String[r1.size()]);     // Catch: Throwable -> L14
        monitor-exit(this);
        return r4;
    L6:
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized void i(JSONObject r6) {
        monitor-enter(this);
        if (r6 != null) goto L30;
        monitor-exit(this);
        return;
    L30:
        String r0 = r6.toString();     // Catch: Throwable -> L27
        if (d.b.b.o.a.c() == false) goto L9;
        com.bytedance.apm.doctor.a.c(r6);     // Catch: Throwable -> L27
    L9:
        byte[] r1 = r0.getBytes();     // Catch: Throwable -> L27
        int r2 = r1.length + 4;     // Catch: Throwable -> L27
        if (r2 <= 262144) goto L15;
        d.b.b.l.a.d(a(r6));     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L15:
        if (r2 <= this.f12637c.remaining()) goto L17;
        b();     // Catch: Throwable -> L27
    L17:
        this.f12637c.putInt(r1.length);     // Catch: Throwable -> L27
        this.f12637c.put(r1);     // Catch: Throwable -> L27
        l(g() + 1);     // Catch: Throwable -> L27
        k(f() + r2);     // Catch: Throwable -> L27
        if (d.b.b.o.a.c() == false) goto L21;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, String.format("push success: totalCount=%s, totalBytes=%s, logItem=%s", new Object[]{Integer.valueOf(g()), Integer.valueOf(f()), r0}));     // Catch: Throwable -> L27
    L21:
        if (this.f12637c.position() < 262134) goto L23;
    L24:
        b();     // Catch: Throwable -> L27
    L25:
        monitor-exit(this);
        return;
    L23:
        if (g() < 256) goto L25;
    L27:
        th = move-exception;
        throw th;
    }
}
