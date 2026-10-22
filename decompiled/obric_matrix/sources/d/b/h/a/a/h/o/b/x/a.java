package d.b.h.a.a.h.o.b.x;

import android.os.Bundle;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f13563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f13564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f13565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f13566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f13567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final WeakHandler f13568f;

    /* JADX INFO: renamed from: d.b.h.a.a.h.o.b.x.a$a, reason: collision with other inner class name */
    public static final enum EnumC0360a extends Enum<EnumC0360a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final EnumC0360a f13569f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final EnumC0360a f13570g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final EnumC0360a f13571h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final EnumC0360a f13572i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final EnumC0360a f13573j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final EnumC0360a f13574k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final EnumC0360a f13575l = null;
        private static final /* synthetic */ EnumC0360a[] m = null;

        static {
            EnumC0360a r0 = new EnumC0360a("CACHE_UNSET", 0);
            f13569f = r0;
            EnumC0360a r1 = new EnumC0360a("CACHE_VALID", 1);
            f13570g = r1;
            EnumC0360a r3 = new EnumC0360a("CACHE_STALE_BOTH", 2);
            f13571h = r3;
            EnumC0360a r5 = new EnumC0360a("CACHE_STALE_NETCHANGED", 3);
            f13572i = r5;
            EnumC0360a r7 = new EnumC0360a("CACHE_STALE_EXPIRED", 4);
            f13573j = r7;
            EnumC0360a r9 = new EnumC0360a("PRELOAD_BATCH", 5);
            f13574k = r9;
            EnumC0360a r11 = new EnumC0360a("REFRESH_BATCH", 6);
            f13575l = r11;
            m = new EnumC0360a[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private EnumC0360a(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumC0360a valueOf(String r1) {
            return (EnumC0360a) Enum.valueOf(EnumC0360a.class, r1);
        }

        public static EnumC0360a[] values() {
            return (EnumC0360a[]) m.clone();
        }
    }

    static {
    }

    public a(String r1, long r2, List<String> r4, List<String> r5, int r6) {
        this.f13563a = r1;
        this.f13567e = r2;
        this.f13564b = r4;
        this.f13565c = r5;
        this.f13566d = r6;
        this.f13568f = new WeakHandler(e.q().k().getLooper(), e.q());
    }

    private void k(Message r3) {
        Bundle r0 = new Bundle();
        r0.putString("dnsrecord_host", this.f13563a);
        r3.setData(r0);
    }

    public void a() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 12;
        k(r0);
        this.f13568f.sendMessageDelayed(r0, this.f13566d * 1000);
        Message r1 = Message.obtain();
        r1.obj = this;
        r1.what = 10;
        k(r1);
        this.f13568f.sendMessageDelayed(r1, (this.f13566d * 1000) + (((long) e.q().m().get()) * 1000));
    }

    public void b() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 13;
        k(r0);
        this.f13568f.sendMessageDelayed(r0, this.f13566d * 1000);
    }

    public void c() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 11;
        k(r0);
        this.f13568f.sendMessageDelayed(r0, ((long) e.q().p().get()) * 1000);
    }

    public long d() {
        return this.f13567e;
    }

    public List<String> e() {
        return this.f13564b;
    }

    public List<String> f() {
        return this.f13565c;
    }

    public long g() {
        return this.f13566d;
    }

    public void h() {
        this.f13568f.removeMessages(10);
        this.f13568f.removeMessages(12);
    }

    public void i() {
        this.f13568f.removeMessages(13);
    }

    public void j() {
        this.f13568f.removeMessages(11);
    }
}
