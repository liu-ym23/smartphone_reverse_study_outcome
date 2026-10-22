package okhttp3;

import kotlin.Metadata;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface WebSocket {

    @Metadata
    public interface Factory {
        @NotNull
        WebSocket newWebSocket(@NotNull Request r1, @NotNull WebSocketListener r2);
    }

    void cancel();

    boolean close(int r1, @Nullable String r2);

    long queueSize();

    @NotNull
    Request request();

    boolean send(@NotNull String r1);

    boolean send(@NotNull ByteString r1);
}
