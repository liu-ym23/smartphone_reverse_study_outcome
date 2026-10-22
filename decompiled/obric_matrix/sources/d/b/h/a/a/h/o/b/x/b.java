package d.b.h.a.a.h.o.b.x;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<String> f13576f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<String> f13577g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f13578h;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f13579f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f13580g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f13581h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f13582i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f13583j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f13584k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f13585l = null;
        private static final /* synthetic */ a[] m = null;

        static {
            a r0 = new a("UNKNOWN", 0);
            f13579f = r0;
            a r1 = new a("HTTPDNS_CACHE", 1);
            f13580g = r1;
            a r3 = new a("HTTPDNS_STALE_CACHE", 2);
            f13581h = r3;
            a r5 = new a("HTTPDNS_REQUEST", 3);
            f13582i = r5;
            a r7 = new a("LOCALDNS_REQUEST", 4);
            f13583j = r7;
            a r9 = new a("LOCALDNS_CACHE", 5);
            f13584k = r9;
            a r11 = new a("HARDCODE_IPS", 6);
            f13585l = r11;
            m = new a[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) m.clone();
        }
    }

    public b() {
        this.f13576f = new ArrayList();
        this.f13577g = new ArrayList();
        this.f13578h = a.f13580g;
    }
}
