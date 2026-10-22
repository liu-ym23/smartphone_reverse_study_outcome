package com.obric.matrix.account.larksso;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/account/larksso/LarkSSOAccount;", "", "()V", "Error", "UserProfiler", "Lcom/obric/matrix/account/larksso/LarkSSOAccount$UserProfiler;", "Lcom/obric/matrix/account/larksso/LarkSSOAccount$Error;", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class a {

    /* JADX INFO: renamed from: com.obric.matrix.account.larksso.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/obric/matrix/account/larksso/LarkSSOAccount$UserProfiler;", "Lcom/obric/matrix/account/larksso/LarkSSOAccount;", NotificationCompat.CATEGORY_EMAIL, "", "accessToken", "(Ljava/lang/String;Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "getEmail", "isEmpty", "", "Companion", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0220a extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C0221a f8581c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final C0220a f8582d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final C0220a f8583e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8585b;

        /* JADX INFO: renamed from: com.obric.matrix.account.larksso.a$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/obric/matrix/account/larksso/LarkSSOAccount$UserProfiler$Companion;", "", "()V", "EMPTY", "Lcom/obric/matrix/account/larksso/LarkSSOAccount$UserProfiler;", "getEMPTY", "()Lcom/obric/matrix/account/larksso/LarkSSOAccount$UserProfiler;", "MOCK", "getMOCK", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class C0221a {
            private C0221a() {
            }

            public /* synthetic */ C0221a(g r1) {
                this();
            }

            public final C0220a a() {
                return C0220a.a();
            }

            public final C0220a b() {
                return C0220a.b();
            }
        }

        static {
            f8581c = new C0221a(null);
            f8582d = new C0220a("", "");
            f8583e = new C0220a("", "");
        }

        public C0220a(String r2, String r3) {
            o.f(r2, NotificationCompat.CATEGORY_EMAIL);
            o.f(r3, "accessToken");
            super(null);
            this.f8584a = r2;
            this.f8585b = r3;
        }

        public static final /* synthetic */ C0220a a() {
            return f8582d;
        }

        public static final /* synthetic */ C0220a b() {
            return f8583e;
        }

        public final String c() {
            return this.f8585b;
        }

        public final String d() {
            return this.f8584a;
        }
    }

    private a() {
    }

    public /* synthetic */ a(g r1) {
        this();
    }
}
