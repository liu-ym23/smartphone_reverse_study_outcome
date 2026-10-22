package cz.msebera.android.httpclient.impl.cookie;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class BestMatchSpec extends DefaultCookieSpec {
    @Override // cz.msebera.android.httpclient.impl.cookie.DefaultCookieSpec
    public String toString() {
        return "best-match";
    }

    public BestMatchSpec(String[] r1, boolean r2) {
        super(r1, r2);
    }

    public BestMatchSpec() {
        this(null, false);
    }
}
