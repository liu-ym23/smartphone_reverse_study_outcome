package d.b.h.a.a.h;

import android.text.TextUtils;
import d.b.h.a.a.h.c;
import d.b.r.y;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b<T extends c> {
    private static volatile InterfaceC0357b c0;
    public boolean A;
    public int B;
    public int C;
    public String D;
    public String E;
    public JSONObject F;
    public boolean G;
    public String H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public long f13353J;
    public long K;
    public long L;
    public boolean M;
    public long N;
    public boolean O;
    public String P;
    public boolean Q;
    public long R;
    public boolean S;
    public j T;
    public long U;
    public volatile AtomicBoolean V;
    public String W;
    public long X;
    public y Y;
    public String Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public URL f13354a;
    public boolean a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13355b;
    public boolean b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f13357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public T f13358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f13359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f13360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f13361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f13362i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f13363j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f13364k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f13365l;
    public long m;
    public int n;
    public long o;
    public long p;
    public long q;
    public long r;
    public long s;
    public long t;
    public boolean u;
    public long v;
    public long w;
    public long x;
    public long y;
    public long z;

    class a implements InterfaceC0357b {
        a() {
        }

        @Override // d.b.h.a.a.h.b.InterfaceC0357b
        public b create() {
            return new b();
        }
    }

    /* JADX INFO: renamed from: d.b.h.a.a.h.b$b, reason: collision with other inner class name */
    public interface InterfaceC0357b {
        b create();
    }

    static {
        c0 = new a();
    }

    public b() {
        this.f13355b = false;
        this.f13356c = -1;
        this.n = -1;
        this.B = -1;
        this.C = -1;
        this.D = "";
        this.F = new JSONObject();
        this.G = false;
        this.M = false;
        this.N = -1;
        this.O = false;
        this.Q = false;
        this.R = -1;
        this.S = false;
        this.V = new AtomicBoolean(false);
        this.W = "";
        this.Z = "";
    }

    public static b a() {
        return c0.create();
    }

    public static JSONObject b(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return null;
    L6:
        String[] r5 = r4.split(",");
        JSONArray r0 = new JSONArray();
        int r1 = r5.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        r0.put(r5[r2]);
        r2 = r2 + 1;
        goto L7
    L9:
        JSONObject r6 = new JSONObject();
        r6.put("hit", r0);     // Catch: JSONException -> L12
    L14:
        return r6;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static void c(InterfaceC0357b r0) {
        if (r0 == null) goto L5;
        c0 = r0;
        return;
    }
}
