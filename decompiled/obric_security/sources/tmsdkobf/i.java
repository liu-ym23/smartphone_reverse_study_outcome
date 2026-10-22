package tmsdkobf;

import com.bytedance.keva.KevaImpl;
import com.bytedance.retrofit2.HttpMethodContrants;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f254a;
    public final URL b;
    public final String c;
    public final Map d;
    public final int e;
    public final int f;
    public final boolean g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f255a;
        public final URL b;
        public final HashMap c;
        public int d;
        public int e;
        public boolean f;

        public a(String r3) {
            HashMap r0 = new HashMap();
            this.c = r0;
            this.d = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            this.e = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            this.f = true;
            this.f255a = r3;
            this.b = new URL(r3);
            r0.put("Content-Type", "application/json; charset=utf-8");
        }

        public static /* synthetic */ String a(a r0) {
            return r0.f255a;
        }

        public static /* synthetic */ URL b(a r0) {
            return r0.b;
        }

        public static /* synthetic */ HashMap c(a r0) {
            return r0.c;
        }

        public static /* synthetic */ int d(a r0) {
            return r0.d;
        }

        public static /* synthetic */ int e(a r0) {
            return r0.e;
        }

        public static /* synthetic */ boolean f(a r0) {
            return r0.f;
        }
    }

    public i(a r2) {
        this.f254a = a.a(r2);
        this.b = a.b(r2);
        this.c = HttpMethodContrants.GET;
        this.d = a.c(r2);
        this.e = a.d(r2);
        this.f = a.e(r2);
        this.g = a.f(r2);
    }
}
