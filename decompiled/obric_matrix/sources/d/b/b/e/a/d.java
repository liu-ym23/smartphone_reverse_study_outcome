package d.b.b.e.a;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MappedByteBuffer f12587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f12588b;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f12589a = null;

        static {
            f12589a = new d();
        }

        static /* synthetic */ d a() {
            return f12589a;
        }
    }

    public d() {
        this.f12588b = 0;
    }

    public static d a() {
        return a.a();
    }

    public long b() {
        if (this.f12587a == null) goto L19;
    L13:
        MappedByteBuffer r0 = this.f12587a;
        if (r0 == null) goto L17;
        long r4 = r0.getLong(0) + 1;
        this.f12588b = r4;
        this.f12587a.putLong(0, r4);
        return this.f12588b;
    L17:
        long r1 = this.f12588b;
        this.f12588b = 1 + r1;
        return r1;
    L19:
        File r2 = new File(b.f(), d.b.b.i.c.a.m().replace(".", "_").replace(":", "-") + "_seq_num.txt");     // Catch: Throwable -> L11
        boolean r3 = r2.exists();     // Catch: Throwable -> L11
        if (r3 == true) goto L7;
        r2.createNewFile();     // Catch: Throwable -> L11
    L7:
        MappedByteBuffer r5 = new RandomAccessFile(r2, "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 8);     // Catch: Throwable -> L11
        this.f12587a = r5;     // Catch: Throwable -> L11
        if (r3 == true) goto L13;
        r5.putLong(0, 0);     // Catch: Throwable -> L11
        return 0;
    L11:
        th = move-exception;
        d.b.b.o.m.b.c(d.b.b.e.a.a.f12571a, "prepare seq_number fail.", th);
        goto L13
    }
}
