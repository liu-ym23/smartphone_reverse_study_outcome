package ms.bd.c;

import android.text.TextUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f22373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f22374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f22375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f22376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f22377e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f22378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected String f22379g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected String f22380h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected String f22381i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f22382j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f22383k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected int f22384l;
    protected Map<String, String> m;
    protected Map<String, String> n;
    protected com.bytedance.mobsec.metasec.ml.b.a.InterfaceC0161a o;
    protected String p;
    protected int q;

    public static abstract class a<T extends b> extends i0 implements b {
        public a(String r2, String r3) {
            this(r2, r3, 99999);
        }

        public a(String r1, String r2, int r3) {
            this.f22373a = r1;
            this.f22381i = r2;
            this.f22384l = r3;
            if (TextUtils.isEmpty(r1) == true) goto L10;
            if (BDLocationException.ERROR_TIMEOUT.equals(r1) == true) goto L10;
            if (TextUtils.isEmpty(r2) == true) goto L10;
            return;
        L10:
            throw new IllegalArgumentException("appID or license must be set.");
        }

        protected i0 c() {
            if (this.f22382j == (-1)) goto L6;
            return this;
        L6:
            throw new IllegalArgumentException("MSConfig init error");
        }

        public T d(int r1) {
            this.f22382j = r1;
            return this;
        }

        public T e(String r1) {
            this.f22375c = r1;
            return this;
        }

        public T f(String r1) {
            this.f22377e = r1;
            return this;
        }
    }

    public interface b {
    }

    protected i0() {
        this.f22373a = "";
        this.f22374b = "";
        this.f22375c = "";
        this.f22376d = "";
        this.f22377e = "";
        this.f22378f = "";
        this.f22379g = "";
        this.f22380h = "";
        this.f22381i = "";
        this.f22382j = -1;
        this.f22383k = -1;
        this.f22384l = 99999;
        this.m = new HashMap();
        this.n = new HashMap();
    }

    String a(Object r1) {
        if (r1 != null) goto L4;
        return "";
    L4:
        if ((r1 instanceof String) == true) goto L6;
        return "";
    L6:
        return ((String) r1).trim();
    }

    public synchronized void b(String r1) {
        monitor-enter(this);
        this.p = r1;     // Catch: Throwable -> L6
        this.q = 1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
