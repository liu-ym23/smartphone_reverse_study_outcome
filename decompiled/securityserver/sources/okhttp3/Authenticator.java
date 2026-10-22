package okhttp3;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.authenticator.JavaNetAuthenticator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface Authenticator {
    public static final Companion Companion = null;

    @JvmField
    @NotNull
    public static final Authenticator JAVA_NET_AUTHENTICATOR = null;

    @JvmField
    @NotNull
    public static final Authenticator NONE = null;

    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        @Metadata
        public static final class AuthenticatorNone implements Authenticator {
            public AuthenticatorNone() {
            }

            @Override // okhttp3.Authenticator
            @Nullable
            public Request authenticate(@Nullable Route r1, @NotNull Response r2) {
                Intrinsics.f(r2, ApmTrafficStats.TTNET_RESPONSE);
                return null;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Companion = new Companion(null);
        NONE = new Companion.AuthenticatorNone();
        Object[] r1 = 0 == true ? 1 : 0;
        JAVA_NET_AUTHENTICATOR = new JavaNetAuthenticator(r1, 1, 0 == true ? 1 : 0);
    }

    @Nullable
    Request authenticate(@Nullable Route r1, @NotNull Response r2);
}
