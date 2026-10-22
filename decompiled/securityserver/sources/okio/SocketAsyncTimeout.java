package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SocketAsyncTimeout extends AsyncTimeout {
    private final Socket socket;

    public SocketAsyncTimeout(@NotNull Socket r2) {
        Intrinsics.f(r2, "socket");
        this.socket = r2;
    }

    @Override // okio.AsyncTimeout
    @NotNull
    public IOException newTimeoutException(@Nullable IOException r2) {
        SocketTimeoutException r1 = new SocketTimeoutException("timeout");
        if (r2 == null) goto L5;
        r1.initCause(r2);
    L5:
        return r1;
    }

    @Override // okio.AsyncTimeout
    public void timedOut() {
        this.socket.close();     // Catch: AssertionError -> L5 Exception -> L7
    L18:
        return;
    L5:
        e = move-exception;
        if (Okio.isAndroidGetsocknameError(e) == false) goto L12;
        Okio__JvmOkioKt.access$getLogger$p().log(Level.WARNING, "Failed to close timed out socket " + this.socket, e);
        return;
    L12:
        throw e;
    L7:
        e = move-exception;
        Okio__JvmOkioKt.access$getLogger$p().log(Level.WARNING, "Failed to close timed out socket " + this.socket, e);
    }
}
