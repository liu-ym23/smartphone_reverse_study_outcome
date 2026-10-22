package d.b.i.a.b.i;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes.dex */
public class d {

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f13900g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f13901h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f13902i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f13903j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f13904k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f13905l = null;
        public static final a m = null;
        private static final /* synthetic */ a[] n = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f13906f;

        static {
            a r0 = new a("UNKNOWN", 0, -1);
            f13900g = r0;
            a r1 = new a("NONE", 1, 0);
            f13901h = r1;
            a r3 = new a("MOBILE", 2, 1);
            f13902i = r3;
            a r5 = new a("MOBILE_2G", 3, 2);
            f13903j = r5;
            a r7 = new a("MOBILE_3G", 4, 3);
            f13904k = r7;
            a r9 = new a("WIFI", 5, 4);
            f13905l = r9;
            a r11 = new a("MOBILE_4G", 6, 5);
            m = r11;
            n = new a[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f13906f = r3;
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) n.clone();
        }

        public int a() {
            return this.f13906f;
        }
    }

    static {
        a r0 = a.f13900g;
    }

    public static a a(Context r2) {
        NetworkInfo r0 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L23
        if (r0 == null) goto L22;
        if (r0.isAvailable() == false) goto L22;
        int r1 = r0.getType();     // Catch: Throwable -> L23
        if (1 == r1) goto L10;
        if (r1 != 0) goto L20;
        switch(((TelephonyManager) r2.getSystemService("phone")).getNetworkType()) {
            case 3: goto L18;
            case 4: goto L26;
            case 5: goto L18;
            case 6: goto L18;
            case 7: goto L26;
            case 8: goto L18;
            case 9: goto L18;
            case 10: goto L18;
            case 11: goto L26;
            case 12: goto L18;
            case 13: goto L16;
            case 14: goto L18;
            case 15: goto L18;
            default: goto L26;
        };     // Catch: Throwable -> L23
    L26:
        return a.f13902i;
    L16:
        return a.m;
    L18:
        return a.f13904k;
    L20:
        return a.f13902i;
    L10:
        return a.f13905l;
    L22:
        return a.f13901h;
    L24:
        return a.f13902i;
    }
}
