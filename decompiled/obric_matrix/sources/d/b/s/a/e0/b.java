package d.b.s.a.e0;

import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f14717a = null;

    static {
        f14717a = r.j(new String[]{"passport-sdk-version", "use_new_token_expire_rule", "request_from_account_sdk", "is_from_ttaccountsdk", "account_sdk_source", "passport_support_flow", "multi_login", "first_beat"});
    }

    public static final boolean a(String r1) {
        o.g(r1, "key");
        return f14717a.contains(r1);
    }
}
