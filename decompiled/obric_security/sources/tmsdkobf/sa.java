package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class sa {
    private static Object b;
    private static sa c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p6 f507a;

    static {
        b = new Object();
    }

    private sa() {
        this.f507a = ((me) qd.a(9)).b("prfle_cnfg_dao");
    }

    private String c(int r2) {
        return "profile_last_enqueue_key_" + r2;
    }

    private String d(int r2) {
        return "profile_quantity_" + r2;
    }

    public boolean a(f1 r2) {
        return ta.a(b(r2.f193a), r2);
    }

    public f1 b(int r3) {
        String r4 = this.f507a.getString(c(r3), null);
        if (r4 != null) goto L6;
        return null;
    L6:
        return a(r4);
    }

    public int e(int r2) {
        return this.f507a.getInt(d(r2), 0);
    }

    public static sa b() {
        if (c != null) goto L15;
        Object r0 = b;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new sa();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public void a(int r2) {
        this.f507a.putInt(d(r2), 0);
    }

    public void c() {
        int r0 = a();
        if (r0 >= 0) goto L5;
        r0 = 0;
    L5:
        this.f507a.putInt("profile_task_id", r0 + 1);
    }

    public void a(int r3, int r4) {
        int r0 = e(r3);
        this.f507a.putInt(d(r3), r0 - r4);
    }

    public void b(int r3, int r4) {
        int r0 = e(r3);
        this.f507a.putInt(d(r3), r0 + r4);
    }

    public void c(f1 r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.f507a.putString(c(r3.f193a), b(r3));
    }

    private String b(f1 r2) {
        if (r2 != null) goto L5;
        return "";
    L5:
        JceOutputStream r1 = new JceOutputStream();
        r1.setServerEncoding("UTF-8");
        r1.write(r2, 0);
        return c3.a(r1.toByteArray());
    }

    public int a() {
        return this.f507a.getInt("profile_task_id", 0);
    }

    public void a(boolean r2) {
        this.f507a.putBoolean("profile_soft_list_upload_opened", r2);
    }

    private f1 a(String r3) {
        if (r3 != null) goto L5;
    L9:
        return null;
    L5:
        if (r3.equals("") == true) goto L9;
        JceInputStream r0 = new JceInputStream(c3.a(r3));     // Catch: Throwable -> L10
        r0.setServerEncoding("UTF-8");     // Catch: Throwable -> L10
        return (f1) r0.read(new f1(), 0, false);
    }
}
