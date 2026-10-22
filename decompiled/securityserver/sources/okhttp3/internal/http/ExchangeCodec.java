package okhttp3.internal.http;

import kotlin.Metadata;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.RealConnection;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface ExchangeCodec {
    public static final Companion Companion = null;
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void cancel();

    @NotNull
    Sink createRequestBody(@NotNull Request r1, long r2);

    void finishRequest();

    void flushRequest();

    @NotNull
    RealConnection getConnection();

    @NotNull
    Source openResponseBodySource(@NotNull Response r1);

    @Nullable
    Response.Builder readResponseHeaders(boolean r1);

    long reportedContentLength(@NotNull Response r1);

    @NotNull
    Headers trailers();

    void writeRequestHeaders(@NotNull Request r1);
}
