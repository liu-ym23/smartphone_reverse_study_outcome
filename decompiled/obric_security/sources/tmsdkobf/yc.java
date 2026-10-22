package tmsdkobf;

import android.content.Context;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes5.dex */
public class yc extends bb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f639a = null;

    static {
        f639a = xk.a(xk.i);
    }

    public yc() {
    }

    @Override // tmsdkobf.bb
    public String a(IBinder r10) {
        monitor-enter(mh.class);
        Context r0 = mh.f353a;     // Catch: Throwable -> L28
        monitor-exit(mh.class);
        String r9 = r0.getPackageName();
        Signature[] r1 = aj.a(r0, r9);
        String r2 = null;
        if (r1 != null) goto L9;
    L21:
        String r3 = xk.a(xk.j);
        Parcel r4 = Parcel.obtain();
        Parcel r5 = Parcel.obtain();
        r4.writeInterfaceToken(f639a);     // Catch: Throwable -> L25
        r4.writeString(r9);     // Catch: Throwable -> L25
        r4.writeString(r2);     // Catch: Throwable -> L25
        r4.writeString(r3);     // Catch: Throwable -> L25
        r10.transact(1, r4, r5, 0);     // Catch: Throwable -> L25
        r5.readException();     // Catch: Throwable -> L25
        String r11 = r5.readString();     // Catch: Throwable -> L25
        r5.recycle();
        r4.recycle();
        return r11;
    L25:
        th = move-exception;
        r5.recycle();
        r4.recycle();
        throw th;
    L9:
        if (r1.length <= 0) goto L21;
        byte[] r6 = r1[0].toByteArray();
        MessageDigest r7 = MessageDigest.getInstance("SHA1");     // Catch: Throwable -> L19
        if (r7 == null) goto L21;
        byte[] r8 = r7.digest(r6);     // Catch: Throwable -> L19
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L19
        int r13 = r8.length;     // Catch: Throwable -> L19
        int r14 = 0;
    L15:
        if (r14 >= r13) goto L17;
        r12.append(Integer.toHexString((r8[r14] & UByte.MAX_VALUE) | 256).substring(1, 3));     // Catch: Throwable -> L19
        r14 = r14 + 1;     // Catch: Throwable -> L19
        goto L15
    L17:
        r2 = r12.toString();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
    L28:
        th = move-exception;
        throw th;
    }
}
