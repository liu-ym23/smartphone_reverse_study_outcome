package p000j.k0.m;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;
import p000j.k0.j.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    public c() {
    }

    public static c b(X509TrustManager r1) {
        return g.m().d(r1);
    }

    public abstract List<Certificate> a(List<Certificate> r1, String r2);
}
