package d.b.u;

import android.content.Context;
import android.util.LruCache;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f implements d.b.u.w.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f15047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LruCache<String, byte[]> f15048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<String, Long> f15049h;

    private static class a extends LruCache<String, byte[]> {
        public a(int r1) {
            super(r1);
        }

        protected int a(String r1, byte[] r2) {
            return r2.length;
        }

        @Override // android.util.LruCache
        protected /* bridge */ /* synthetic */ int sizeOf(String r1, byte[] r2) {
            return a(r1, r2);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f15050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f15051b;

        public b(boolean r1, String r2) {
            this.f15050a = r1;
            this.f15051b = r2;
        }
    }

    public f(Context r2) {
        this.f15047f = r2;
        this.f15048g = new a(10485760);
        this.f15049h = new HashMap();
    }

    private String F(String r1, long r2, String r4) {
        return r1 + "_" + r2 + "_" + r4;
    }

    private File M(long r3, String r5) {
        return new File(this.f15047f.getFileStreamPath("bd_sync_sdk"), r3 + File.separator + r5);
    }

    private byte[] o0(File r4) {
        if (r4.exists() == true) goto L35;
        return null;
    L35:
        k.g r3 = k.q.b(new k.n(k.q.i(r4)));     // Catch: Throwable -> L15
        byte[] r5 = r3.t();     // Catch: Throwable -> L13
        if (r3 != null) goto L41;
    L12:
        return r5;
    L41:
        r3.close();     // Catch: IOException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    L13:
        th = th;
    L39:
        th.printStackTrace();     // Catch: Throwable -> L24
        d.b.u.x.b.b("read file throw exception : " + th);     // Catch: Throwable -> L24
        if (r3 != null) goto L31;
    L23:
        return null;
    L31:
        r3.close();     // Catch: IOException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
    L24:
        th = move-exception;
        if (r3 != null) goto L37;
    L30:
        throw th;
    L37:
        r3.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L15:
        th = th;
        r3 = null;
        goto L39
    }

    private b p0(File r5, byte[] r6) {
        k.f r4 = null;
        File r0 = r5.getParentFile();     // Catch: Throwable -> L16
        if (r0.exists() == true) goto L6;
        r0.mkdirs();     // Catch: Throwable -> L16
    L6:
        com.bytedance.common.utility.n.b.b(r5.getAbsolutePath());     // Catch: Throwable -> L16
        r5.createNewFile();     // Catch: Throwable -> L16
        k.f r7 = k.q.a(new k.m(k.q.d(r5)));     // Catch: Throwable -> L16
        r7.U(r6);     // Catch: Throwable -> L14
        r7.flush();     // Catch: Throwable -> L14
        b r8 = new b(true, null);     // Catch: Throwable -> L14
        if (r7 != null) goto L33;
    L13:
        return r8;
    L33:
        r7.close();     // Catch: IOException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    L14:
        th = move-exception;
        th = th;
        r4 = r7;
    L35:
        th.printStackTrace();     // Catch: Throwable -> L24
        b r9 = new b(false, th.getClass().toString() + ": " + th.getMessage());     // Catch: Throwable -> L24
        if (r4 != null) goto L37;
    L23:
        return r9;
    L37:
        r4.close();     // Catch: IOException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
    L24:
        th = move-exception;
        if (r4 != null) goto L39;
    L30:
        throw th;
    L39:
        r4.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L16:
        th = th;
        goto L35
    }

    @Override // d.b.u.w.c
    public String A(long r3, String r5) {
        d.b.u.x.b.e("FileCache  readCache " + r5);
        File r4 = new File(r5);
        String r6 = r4.getName();
        byte[] r0 = this.f15048g.get(r6);
        if (r0 != null) goto L12;
        d.b.u.x.b.e("FileCache  real readCache " + r5);
        r0 = o0(r4);
    L12:
        String r2 = new String(r0, "UTF-8");     // Catch: Throwable -> L8
        if (r6.endsWith("_" + com.bytedance.common.utility.j.a(r2, "MD5")) == false) goto L14;
        return r2;
    L14:
        return null;
    L8:
        th = move-exception;
        th.printStackTrace();
        d.b.u.x.b.b("read data throw exception: " + th);
        return null;
    }

    @Override // d.b.u.w.c
    public File K() {
        return this.f15047f.getFileStreamPath("bd_sync_sdk");
    }

    @Override // d.b.u.w.c
    public String O(String r11, long r12, long r14, byte[] r16) {
        return e0(r11, r12, r14, r16, com.bytedance.common.utility.j.a(new String(r16, "UTF-8"), "MD5"));
    L4:
        return null;
    }

    @Override // d.b.u.w.c
    public byte[] Q(long r3, String r5) {
        d.b.u.x.b.e("FileCache  readCache " + r5);
        File r4 = new File(r5);
        String r6 = r4.getName();
        byte[] r0 = this.f15048g.get(r6);
        if (r0 != null) goto L12;
        d.b.u.x.b.e("FileCache  real readCache " + r5);
        r0 = o0(r4);
    L12:
        if (r6.endsWith("_" + com.bytedance.common.utility.j.a(new String(r0, "UTF-8"), "MD5")) == false) goto L14;
        return r0;
    L14:
        return null;
    L8:
        th = move-exception;
        th.printStackTrace();
        d.b.u.x.b.b("read data throw exception: " + th);
        return null;
    }

    @Override // d.b.u.w.c
    public void S(String r3) {
        d.b.u.x.b.e("FileCache  delete " + r3);
        this.f15048g.remove(new File(r3).getName());     // Catch: Exception -> L5
        com.bytedance.common.utility.n.b.b(r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // d.b.u.w.c
    public String e0(String r3, long r4, long r6, byte[] r8, String r9) {
        d.b.u.x.b.e("FileCache  putCache " + r4 + r9);
        String r5 = F(r3, r6, r9);
        this.f15048g.put(r5, r8);
        this.f15049h.put(r5, Long.valueOf(r4));
        File r7 = M(r4, r5);
        String r10 = r7.getAbsolutePath();
        b r2 = p0(r7, r8);
        JSONObject r11 = new JSONObject();
        d.b.u.d0.a.c(r11, "file_path", r10);
        JSONObject r12 = new JSONObject();
        d.b.u.d0.a.d(r12, "success", r2.f15050a);
        if (r2.f15050a == true) goto L5;
        d.b.u.d0.a.c(r12, "error_msg", r2.f15051b);
    L5:
        r.c("sync_sdk_save_file_monitor", r12, null, r11);
        if (r2.f15050a == false) goto L8;
        return r10;
    L8:
        return null;
    }

    @Override // d.b.u.w.c
    public boolean j0(long r4) {
        d.b.u.x.b.e("FileCache  deleteAllFiles " + r4);
        Iterator<Map.Entry<String, Long>> r0 = this.f15049h.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        Map.Entry<String, Long> r1 = r0.next();
        if (r1.getValue() == null) goto L4;
        if (r1.getValue().longValue() != r4) goto L4;
        r0.remove();
        goto L4
    L17:
        com.bytedance.common.utility.n.b.c(new File(this.f15047f.getFileStreamPath("bd_sync_sdk"), String.valueOf(r4)).getAbsolutePath());     // Catch: Exception -> L13
        return true;
    L13:
        e = move-exception;
        e.printStackTrace();
        return true;
    }
}
