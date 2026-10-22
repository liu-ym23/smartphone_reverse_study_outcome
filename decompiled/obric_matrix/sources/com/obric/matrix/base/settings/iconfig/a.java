package com.obric.matrix.base.settings.iconfig;

import com.bytedance.news.common.settings.e;
import com.google.gson.y.c;
import kotlin.Metadata;
import kotlin.n0.d.g;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<com.obric.matrix.base.settings.iconfig.a>] */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0000H\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/obric/matrix/base/settings/iconfig/SecretConfig;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "()V", "secret", "", "getSecret", "()Ljava/lang/String;", "create", "Companion", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0239a f8887b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c("secret")
    private final String f8888a;

    /* JADX INFO: renamed from: com.obric.matrix.base.settings.iconfig.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/base/settings/iconfig/SecretConfig$Companion;", "", "()V", "get", "Lcom/obric/matrix/base/settings/iconfig/SecretConfig;", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0239a {
        private C0239a() {
        }

        public /* synthetic */ C0239a(g r1) {
            this();
        }

        public final a a() {
            return ((ISecretConfig) e.e(ISecretConfig.class)).getConfig();
        }
    }

    static {
        f8887b = new C0239a(null);
    }

    public a() {
    }

    public static final a b() {
        return f8887b.a();
    }

    public a a() {
        return new a();
    }

    public final String c() {
        return this.f8888a;
    }
}
