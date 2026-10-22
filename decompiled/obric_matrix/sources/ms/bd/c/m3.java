package ms.bd.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public class m3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f22422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f22423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private w3 f22424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CountDownLatch f22425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ServiceConnection f22426e;

    class a implements ServiceConnection {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ m3 f22427f;

        a(m3 r1) {
            this.f22427f = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r2, IBinder r3) {
            m3.d(this.f22427f, new w3(r3));
            m3.c(this.f22427f).countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r2) {
            m3.d(this.f22427f, null);
            m3.c(this.f22427f).countDown();
        }
    }

    public m3(Context r8) {
        String r0 = (String) m.a(16777217, 0, 0, "5d34d9", new byte[]{11, 83, 105, 100});
        this.f22426e = new a(this);
        this.f22422a = r8;
        this.f22425d = new CountDownLatch(1);
    }

    private String b(w3 r19, String r20) {
        String r1 = this.f22422a.getPackageName();
        if (this.f22423b == null) goto L37;
    L20:
        String r0 = this.f22423b;
        r19.getClass();
        Parcel r2 = Parcel.obtain();
        Parcel r7 = Parcel.obtain();
        r2.writeInterfaceToken((String) m.a(16777217, 0, 0, "c6cf0c", new byte[]{113, 59, 29, 92, 7, 113, 121, 3, 51, 38, 60, 59, 0, 23, 1, 125, 100, 89, 27, 25, 98, 49, 30, 59, 43}));     // Catch: Throwable -> L23 Exception -> L25
        r2.writeString(r1);     // Catch: Throwable -> L23 Exception -> L25
        r2.writeString(r0);     // Catch: Throwable -> L23 Exception -> L25
        r2.writeString(r20);     // Catch: Throwable -> L23 Exception -> L25
        r19.f22539f.transact(1, r2, r7, 0);     // Catch: Throwable -> L23 Exception -> L25
        r7.readException();     // Catch: Throwable -> L23 Exception -> L25
        String r3 = r7.readString();     // Catch: Throwable -> L23 Exception -> L25
    L28:
        r2.recycle();
        r7.recycle();
        return r3;
    L23:
        th = move-exception;
        r2.recycle();
        r7.recycle();
        throw th;
    L26:
        String r4 = (String) m.a(16777217, 0, 0, "4e2ff1", new byte[]{42, 119, 72});     // Catch: Throwable -> L23
        r3 = null;
        goto L28
    L37:
        Signature[] r5 = this.f22422a.getPackageManager().getPackageInfo(r1, 64).signatures;     // Catch: Exception -> L6
    L7:
        if (r5 != null) goto L9;
    L18:
        String r6 = null;
    L19:
        this.f22423b = r6;
        goto L20
    L9:
        if (r5.length <= 0) goto L18;
        byte[] r8 = r5[0].toByteArray();
        MessageDigest r9 = MessageDigest.getInstance((String) m.a(16777217, 0, 0, "83cd44", new byte[]{26, 25, 49, 65}));     // Catch: Exception -> L32
        if (r9 == null) goto L18;
        byte[] r10 = r9.digest(r8);     // Catch: Exception -> L32
        StringBuilder r11 = new StringBuilder();     // Catch: Exception -> L32
        int r12 = r10.length;     // Catch: Exception -> L32
        int r13 = 0;
    L14:
        if (r13 >= r12) goto L16;
        r11.append(Integer.toHexString((r10[r13] & 255) | 256).substring(1, 3));     // Catch: Exception -> L32
        r13 = r13 + 1;     // Catch: Exception -> L32
        goto L14
    L16:
        r6 = r11.toString();     // Catch: Exception -> L32
    L6:
        r5 = null;
        goto L7
    }

    static /* synthetic */ CountDownLatch c(m3 r0) {
        return r0.f22425d;
    }

    static /* synthetic */ w3 d(m3 r0, w3 r1) {
        r0.f22424c = r1;
        return r1;
    }

    public String a(g3.a r14) {
        String r2 = null;
        if (c3.d(this.f22422a, (String) m.a(16777217, 0, 0, "afdfd8", new byte[]{115, 107, 26, 92, 83, 42, 123, 83, 52, 38, 62, 107, 7, 23, 85, 38, 102})) == true) goto L6;
        return null;
    L6:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L31;
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName((String) m.a(16777217, 0, 0, "b2c81f", new byte[]{112, 63, 29, 2, 6, 116, 120, 7, 51, 120, 61, 63, 0, 73, 0, 120, 101}), (String) m.a(16777217, 0, 0, "77aad9", new byte[]{37, 58, 31, 91, 83, 43, 45, 2, 49, 33, 104, 58, 2, 16, 85, 39, 48, 88, 25, 53, 35, 59, 6, 28, 93, 55, 7, 19, 34, 39, 47, 54, 23})));
        r0.setAction((String) m.a(16777217, 0, 0, "d4f949", new byte[]{116, 53, 1, 68, 4, 32, 41, 22, 56, 100, 59, 62, 16, 84, 31, 47, 119, 91, 56, 121, 112, 56, 28, 73, 69, 1, 87, 48, 25, 86, 92, 18, 42, 126, 46, 28, 81, 60, 20, 76}));
        boolean r3 = false;
        if (this.f22422a.bindService(r0, this.f22426e, 1) == true) goto L34;
    L18:
        if (r3 == true) goto L24;
    L25:
        return r2;
    L24:
        this.f22422a.unbindService(this.f22426e);
        goto L25
    L34:
        this.f22425d.await();     // Catch: Throwable -> L17
        w3 r1 = this.f22424c;     // Catch: Throwable -> L17
        if (r1 != null) goto L13;
    L16:
        r3 = true;
        goto L18
    L13:
        r2 = b(r1, (String) m.a(16777217, 0, 0, "f16c2b", new byte[]{88, 6, 108, 51}));     // Catch: Throwable -> L17
        if (r14 == null) goto L16;
        r14.a(r2);     // Catch: Throwable -> L17
    L17:
        boolean r15 = true;
    L32:
        String r4 = (String) m.a(16777217, 0, 0, "b46522", new byte[]{124, 38});     // Catch: Throwable -> L26
        if (r15 == false) goto L25;
    L26:
        th = move-exception;
        if (r15 == false) goto L29;
        this.f22422a.unbindService(this.f22426e);
    L29:
        throw th;
    L20:
        r15 = false;
        goto L32
    L31:
        throw new IllegalStateException((String) m.a(16777217, 0, 0, "475ea6", new byte[]{6, 52, 72, 31, 81, 53, 119, 4, 113, 59, 101, 58, 72, 81, 115, 32, 62, 24, 80, 61, 55, 48, 71, 21}));
    }
}
