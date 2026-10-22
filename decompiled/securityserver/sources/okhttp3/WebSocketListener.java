package okhttp3;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class WebSocketListener {
    public WebSocketListener() {
    }

    public void onClosed(@NotNull WebSocket r1, int r2, @NotNull String r3) {
        Intrinsics.f(r1, "webSocket");
        Intrinsics.f(r3, "reason");
    }

    public void onClosing(@NotNull WebSocket r1, int r2, @NotNull String r3) {
        Intrinsics.f(r1, "webSocket");
        Intrinsics.f(r3, "reason");
    }

    public void onFailure(@NotNull WebSocket r1, @NotNull Throwable r2, @Nullable Response r3) {
        Intrinsics.f(r1, "webSocket");
        Intrinsics.f(r2, "t");
    }

    public void onMessage(@NotNull WebSocket r1, @NotNull String r2) {
        Intrinsics.f(r1, "webSocket");
        Intrinsics.f(r2, "text");
    }

    public void onOpen(@NotNull WebSocket r1, @NotNull Response r2) {
        Intrinsics.f(r1, "webSocket");
        Intrinsics.f(r2, ApmTrafficStats.TTNET_RESPONSE);
    }

    public void onMessage(@NotNull WebSocket r1, @NotNull ByteString r2) {
        Intrinsics.f(r1, "webSocket");
        Intrinsics.f(r2, "bytes");
    }
}
