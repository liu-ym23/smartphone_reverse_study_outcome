package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class RouteException extends RuntimeException {

    @NotNull
    private final IOException firstConnectException;

    @NotNull
    private IOException lastConnectException;

    public RouteException(@NotNull IOException r2) {
        Intrinsics.f(r2, "firstConnectException");
        super(r2);
        this.firstConnectException = r2;
        this.lastConnectException = r2;
    }

    public final void addConnectException(@NotNull IOException r2) {
        Intrinsics.f(r2, "e");
        ExceptionsKt.a(this.firstConnectException, r2);
        this.lastConnectException = r2;
    }

    @NotNull
    public final IOException getFirstConnectException() {
        return this.firstConnectException;
    }

    @NotNull
    public final IOException getLastConnectException() {
        return this.lastConnectException;
    }
}
