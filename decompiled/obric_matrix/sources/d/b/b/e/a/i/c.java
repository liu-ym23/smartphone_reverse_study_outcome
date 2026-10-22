package d.b.b.e.a.i;

import android.util.Log;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f12625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f12626b;

    class a implements FileFilter {
        a(c r1) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File r7) {
            boolean r6 = true;
            String r1 = r7.getName();     // Catch: Throwable -> L16
            int r2 = r1.lastIndexOf(".bin");     // Catch: Throwable -> L16
            if (r2 == (-1)) goto L10;
            if ((System.currentTimeMillis() - d.b(Long.parseLong(r1.substring(0, r2)))) >= 604800000) goto L10;
            r6 = false;
        L10:
            if (r6 == true) goto L12;
        L15:
            return false;
        L12:
            if (d.b.b.o.a.c() == false) goto L14;
            d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "deleteExpireHeader:" + r7.getName());
        L14:
            d.b.b.o.c.a(r7);
            goto L15
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f12627a = null;

        static {
            f12627a = new c();
        }

        static /* synthetic */ c a() {
            return f12627a;
        }
    }

    public c() {
    }

    private String b(String r1) {
        return r1 + ".bin";
    }

    public static c d() {
        return b.a();
    }

    private synchronized void e() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f12625a == false) goto L19;
        monitor-exit(this);
        return;
    L19:
        File r0 = new File(d.b.b.e.a.b.f(), "header");     // Catch: Throwable -> L11
        this.f12626b = r0;     // Catch: Throwable -> L11
        if (r0.exists() == true) goto L13;
        this.f12626b.mkdirs();     // Catch: Throwable -> L11
    L13:
        this.f12625a = true;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        d.b.b.o.m.b.b("APM", "header store init error " + th.toString());     // Catch: Throwable -> L16
        goto L13
    }

    void a() {
        e();
        File r0 = this.f12626b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.listFiles(new a(this));
    }

    d.b.b.e.a.i.a c(String r4) {
        e();
        if (this.f12626b != null) goto L5;
        return null;
    L5:
        byte[] r3 = d.b.b.o.c.e(new File(this.f12626b, b(r4)));
        if (r3 != null) goto L8;
        return null;
    L8:
        return d.a(r3);
    }

    void f(String r3, d.b.b.e.a.i.a r4) {
        e();
        if (this.f12626b != null) goto L5;
        return;
    L5:
        JSONObject r5 = d.d(r4);
        if (r5 != null) goto L8;
        return;
    L8:
        File r0 = new File(this.f12626b, b(r3));
        FileChannel r2 = null;
        r2 = new FileOutputStream(r0).getChannel();     // Catch: Throwable -> L11
        r2.write(ByteBuffer.wrap(r5.toString().getBytes()));     // Catch: Throwable -> L11
    L10:
        d.b.b.o.d.a(r2);
        return;
    L11:
        th = move-exception;
        Log.e("APM", "header couldn't write file" + th.getMessage());     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        d.b.b.o.d.a(r2);
        throw th;
    }
}
