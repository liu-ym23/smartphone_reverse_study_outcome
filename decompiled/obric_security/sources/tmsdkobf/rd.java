package tmsdkobf;

import android.content.Context;
import android.os.Process;
import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
public class rd implements u6 {
    private static Context c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ql f479a;
    private long b;

    rd(ud.b r3) {
        this.b = 1;
        this.f479a = new ql(r3);
    }

    public static Context e() {
        return c;
    }

    public static String f() {
        return String.format("%s.permission.TMF_SHARK", new Object[]{c.getPackageName()});
    }

    @Override // tmsdkobf.u6
    public void a(int r9, JceStruct r10, int r11, a7 r12) {
        this.f479a.a(this.b, r9, r10, r11, r12, false);
    }

    public void b(boolean r1) {
        this.f479a.b(r1);
    }

    @Override // tmsdkobf.u6
    public String c() {
        return this.f479a.d();
    }

    @Override // tmsdkobf.u6
    public void closeConnection() {
        this.f479a.a();
    }

    @Override // tmsdkobf.u6
    public void d() {
        this.f479a.t();
    }

    @Override // tmsdkobf.u6
    public WeakReference a(int r9, JceStruct r10, JceStruct r11, int r12, w6 r13) {
        return a(r9, r10, r11, r12, r13, 0);
    }

    @Override // tmsdkobf.u6
    public void b() {
        this.f479a.u();
    }

    public void c(boolean r1) {
        this.f479a.c(r1);
    }

    @Override // tmsdkobf.u6
    public void a(int r8, long r9, int r11, JceStruct r12) {
        a(r8, r9, r11, r12, 0);
    }

    public static void a(Context r1) {
        if (c != null) goto L6;
        c = r1.getApplicationContext();
        return;
    }

    public void a(boolean r1) {
        this.f479a.a(r1);
    }

    @Override // tmsdkobf.u6
    public void a() {
        this.f479a.v();
    }

    @Override // tmsdkobf.u6
    public a7 a(int r1, int r2) {
        return this.f479a.a(r1, r2);
    }

    @Override // tmsdkobf.u6
    public WeakReference a(int r12, JceStruct r13, JceStruct r14, int r15, w6 r16, long r17) {
        return this.f479a.a(r12, r13, r14, r15, r16, r17, 0, 0);
    }

    public void a(int r22, long r23, int r25, JceStruct r26, int r27) {
        this.f479a.a(Process.myPid(), 0, r22, r23, this.b, r25, r26, null, null, r27 | 1073741824, null, null, 0, 0, 0);
    }

    @Override // tmsdkobf.u6
    public WeakReference a(int r8, byte[] r9, int r10, v6 r11, long r12) {
        return this.f479a.a(r8, r9, r10, r11, r12);
    }
}
