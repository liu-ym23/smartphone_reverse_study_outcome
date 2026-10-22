package tmsdkobf;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class d5 {
    public static final String b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f145a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f146a;
        public final /* synthetic */ Map b;

        public a(d5 r1, Context r2, Map r3) {
            this.f146a = r2;
            this.b = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            d5.a(this.f146a, this.b);
        }
    }

    static {
        b = p.a("turingfd_conf_").append(n0.f360a).append("_").append("vd").toString();
    }

    public d5(Handler r1) {
        this.f145a = r1;
    }

    public static String b(Context r6, String r7) {
        int r1 = 0;
        SharedPreferences r8 = r6.getSharedPreferences(b, 0);     // Catch: Throwable -> L5
    L7:
        if (r8 != null) goto L9;
        return "";
    L9:
        String r9 = r8.getString(r7, "");
        if (TextUtils.isEmpty(r9) == false) goto L18;
        return r9;
    L18:
        int r10 = z1.f651a;     // Catch: Throwable -> L17
        int r11 = r9.length() / 2;     // Catch: Throwable -> L17
        byte[] r3 = new byte[r11];     // Catch: Throwable -> L17
        char[] r12 = r9.toUpperCase().toCharArray();     // Catch: Throwable -> L17
    L13:
        if (r1 >= r11) goto L15;
        int r4 = r1 * 2;     // Catch: Throwable -> L17
        int r5 = ((byte) "0123456789ABCDEF".indexOf(r12[r4])) << 4;     // Catch: Throwable -> L17
        r3[r1] = (byte) (((byte) "0123456789ABCDEF".indexOf(r12[r4 + 1])) | r5);     // Catch: Throwable -> L17
        r1 = r1 + 1;     // Catch: Throwable -> L17
        goto L13
    L15:
        return z1.a(zj.a(r3, zj.a()), "UTF-8");
    L17:
        return "";
    L5:
        r8 = null;
        goto L7
    }

    public w3 a(Context r9) {
        String r0 = b(r9, "101");     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r0) == true) goto L6;
        long r1 = Long.valueOf(b(r9, "102")).longValue();     // Catch: Throwable -> L9
    L10:
        String r3 = b(r9, "104");     // Catch: Throwable -> L12
        String r4 = b(r9, "105");     // Catch: Throwable -> L12
        String r5 = b(r9, "106");     // Catch: Throwable -> L12
        String r10 = b(r9, "110");     // Catch: Throwable -> L12
        w3.a r6 = new w3.a(0);     // Catch: Throwable -> L12
        r6.b = r1;     // Catch: Throwable -> L12
        r6.f595a = r0;     // Catch: Throwable -> L12
        r6.d = r3;     // Catch: Throwable -> L12
        r6.e = r4;     // Catch: Throwable -> L12
        r6.f = r5;     // Catch: Throwable -> L12
        r6.g = r10;     // Catch: Throwable -> L12
        return new w3(r6);
    L9:
        r1 = 0;
        goto L10
    L6:
        return w3.a(1);
    L13:
        return w3.a(1);
    }

    public void c(Context r3, long r4) {
        a(r3, "503", "" + r4, true);
    }

    public void b(Context r3, long r4) {
        HashMap r2 = new HashMap();
        r2.put("902", "" + r4);
        a(r3, r2);
    }

    public void a(Context r4, long r5) {
        if (r5 < Long.MAX_VALUE) goto L5;
        r5 = Long.MAX_VALUE;
    L5:
        a(r4, "401", "" + r5, true);
    }

    public e4 a(Context r4, int r5) {
        e4 r3 = new e4(r5);
        String[] r6 = b(r4, "402").split("_");
        int r7 = r6.length;
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L8;
        r3.a(Long.valueOf(Long.valueOf(r6[r0]).longValue()));
    L7:
        r0 = r0 + 1;
        goto L3
    L8:
        return r3;
    }

    public static void a(Context r4, Map r5) {
        SharedPreferences r6 = r4.getSharedPreferences(b, 0);     // Catch: Throwable -> L4
    L5:
        if (r6 != null) goto L7;
        return;
    L7:
        SharedPreferences.Editor r7 = r6.edit();
        if (r7 != null) goto L10;
        return;
    L10:
        Iterator r0 = r5.keySet().iterator();
    L12:
        if (r0.hasNext() == false) goto L20;
        String r1 = (String) r0.next();
        r7.putString(r1, z1.a(zj.b(((String) r5.get(r1)).getBytes(), zj.a())));     // Catch: Throwable -> L18
        goto L12
    L20:
        r7.commit();     // Catch: Throwable -> L19
        return;
    L28:
        return;
    L4:
        r6 = null;
        goto L5
    }

    public final void a(Context r2, String r3, String r4, boolean r5) {
        HashMap r0 = new HashMap();
        r0.put(r3, r4);
        a(r2, r0, r5);
    }

    public final void a(Context r2, String r3, String r4) {
        HashMap r0 = new HashMap();
        r0.put(r3, r4);
        a(r2, r0, false);
    }

    public final void a(Context r2, Map r3, boolean r4) {
        if (r4 == false) goto L4;
        a(r2, r3);
        return;
    L4:
        this.f145a.post(new a(this, r2, r3));
    }

    public final long a(Context r1, String r2) {
        return Long.valueOf(b(r1, r2)).longValue();
    L5:
        return 0;
    }
}
