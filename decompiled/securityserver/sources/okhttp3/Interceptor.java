package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface Interceptor {
    public static final Companion Companion = null;

    @Metadata
    public interface Chain {
        @NotNull
        Call call();

        int connectTimeoutMillis();

        @Nullable
        Connection connection();

        @NotNull
        Response proceed(@NotNull Request r1);

        int readTimeoutMillis();

        @NotNull
        Request request();

        @NotNull
        Chain withConnectTimeout(int r1, @NotNull TimeUnit r2);

        @NotNull
        Chain withReadTimeout(int r1, @NotNull TimeUnit r2);

        @NotNull
        Chain withWriteTimeout(int r1, @NotNull TimeUnit r2);

        int writeTimeoutMillis();
    }

    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        @NotNull
        public final Interceptor invoke(@NotNull final Function1<? super Chain, Response> r1) {
            Intrinsics.f(r1, "block");
            return new Interceptor$Companion$invoke$1(r1);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @NotNull
    Response intercept(@NotNull Chain r1);
}
