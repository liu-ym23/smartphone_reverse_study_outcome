package okio;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: okio.-DeprecatedOkio, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public final class DeprecatedOkio {
    public static final DeprecatedOkio INSTANCE = null;

    static {
        INSTANCE = new DeprecatedOkio();
    }

    private DeprecatedOkio() {
    }

    @Deprecated
    @NotNull
    public final Sink appendingSink(@NotNull File r1) {
        Intrinsics.f(r1, "file");
        return Okio.appendingSink(r1);
    }

    @Deprecated
    @NotNull
    public final Sink blackhole() {
        return Okio.blackhole();
    }

    @Deprecated
    @NotNull
    public final BufferedSink buffer(@NotNull Sink r1) {
        Intrinsics.f(r1, "sink");
        return Okio.buffer(r1);
    }

    @Deprecated
    @NotNull
    public final Sink sink(@NotNull File r3) {
        Intrinsics.f(r3, "file");
        return Okio.sink$default(r3, false, 1, null);
    }

    @Deprecated
    @NotNull
    public final Source source(@NotNull File r1) {
        Intrinsics.f(r1, "file");
        return Okio.source(r1);
    }

    @Deprecated
    @NotNull
    public final BufferedSource buffer(@NotNull Source r1) {
        Intrinsics.f(r1, DBHelper.BATTERY_COL_SOURCE);
        return Okio.buffer(r1);
    }

    @Deprecated
    @NotNull
    public final Sink sink(@NotNull OutputStream r1) {
        Intrinsics.f(r1, "outputStream");
        return Okio.sink(r1);
    }

    @Deprecated
    @NotNull
    public final Source source(@NotNull InputStream r1) {
        Intrinsics.f(r1, "inputStream");
        return Okio.source(r1);
    }

    @Deprecated
    @NotNull
    public final Sink sink(@NotNull Path r1, @NotNull OpenOption... r2) {
        Intrinsics.f(r1, ApmTrafficStats.KEY_PATH);
        Intrinsics.f(r2, "options");
        return Okio.sink(r1, (OpenOption[]) Arrays.copyOf(r2, r2.length));
    }

    @Deprecated
    @NotNull
    public final Source source(@NotNull Path r1, @NotNull OpenOption... r2) {
        Intrinsics.f(r1, ApmTrafficStats.KEY_PATH);
        Intrinsics.f(r2, "options");
        return Okio.source(r1, (OpenOption[]) Arrays.copyOf(r2, r2.length));
    }

    @Deprecated
    @NotNull
    public final Sink sink(@NotNull Socket r1) {
        Intrinsics.f(r1, "socket");
        return Okio.sink(r1);
    }

    @Deprecated
    @NotNull
    public final Source source(@NotNull Socket r1) {
        Intrinsics.f(r1, "socket");
        return Okio.source(r1);
    }
}
