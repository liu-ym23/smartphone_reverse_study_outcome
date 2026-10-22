package com.obric.matrix.account.n;

import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.mpaas.app.AppInfoProvider;
import java.util.Locale;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/account/core/BDTuringAccount;", "", "()V", "init", "", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8591a = null;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/account/core/BDTuringAccount$init$builder$1", "Lcom/bytedance/bdturing/EventClient;", "onEvent", "", "appLogEvent", "", "params", "Lorg/json/JSONObject;", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements com.bytedance.bdturing.d {
        a() {
        }

        @Override // com.bytedance.bdturing.d
        public void onEvent(String r1, JSONObject r2) {
            com.obric.matrix.r.c.c.f("BdTuring", "onGetIBdTruing");
        }
    }

    static {
        f8591a = new b();
    }

    private b() {
    }

    public final void a() {
        AppInfoProvider r2 = (AppInfoProvider) com.bytedance.news.common.service.manager.d.a(AppInfoProvider.class);
        BdTuringConfig.b r0 = new BdTuringConfig.b();
        r0.C(r2.getAid());
        r0.F(r2.getVersionCode());
        r0.D(r2.getAppName());
        r0.L(Locale.CHINA.getLanguage());
        r0.I(new a());
        r0.E(r2.getVersionName());
        r0.H(r2.getChannel());
        r0.N(new c());
        r0.M(6);
        BdTuringConfig r3 = r0.G(d.g.f.a.a.f16974a.d());
        com.bytedance.bdturing.b.f().g(r3);
    }
}
