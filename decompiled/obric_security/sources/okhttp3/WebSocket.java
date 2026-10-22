package okhttp3;

import javax.annotation.Nullable;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
public interface WebSocket {

    public interface Factory {
        WebSocket newWebSocket(Request r1, WebSocketListener r2);
    }

    void cancel();

    boolean close(int r1, @Nullable String r2);

    long queueSize();

    Request request();

    boolean send(String r1);

    boolean send(ByteString r1);
}
