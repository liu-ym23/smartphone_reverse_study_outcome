package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Okio {
    @NotNull
    public static final Sink appendingSink(@NotNull File r0) {
        return Okio__JvmOkioKt.appendingSink(r0);
    }

    @JvmName
    @NotNull
    public static final Sink blackhole() {
        return Okio__OkioKt.blackhole();
    }

    @NotNull
    public static final BufferedSink buffer(@NotNull Sink r0) {
        return Okio__OkioKt.buffer(r0);
    }

    public static final boolean isAndroidGetsocknameError(@NotNull AssertionError r0) {
        return Okio__JvmOkioKt.isAndroidGetsocknameError(r0);
    }

    @JvmOverloads
    @NotNull
    public static final Sink sink(@NotNull File r3) {
        return sink$default(r3, false, 1, null);
    }

    public static /* synthetic */ Sink sink$default(File r0, boolean r1, int r2, Object r3) {
        return Okio__JvmOkioKt.sink$default(r0, r1, r2, r3);
    }

    @NotNull
    public static final Source source(@NotNull File r0) {
        return Okio__JvmOkioKt.source(r0);
    }

    @NotNull
    public static final BufferedSource buffer(@NotNull Source r0) {
        return Okio__OkioKt.buffer(r0);
    }

    @JvmOverloads
    @NotNull
    public static final Sink sink(@NotNull File r0, boolean r1) {
        return Okio__JvmOkioKt.sink(r0, r1);
    }

    @NotNull
    public static final Source source(@NotNull InputStream r0) {
        return Okio__JvmOkioKt.source(r0);
    }

    @NotNull
    public static final Sink sink(@NotNull OutputStream r0) {
        return Okio__JvmOkioKt.sink(r0);
    }

    @NotNull
    public static final Source source(@NotNull Socket r0) {
        return Okio__JvmOkioKt.source(r0);
    }

    @NotNull
    public static final Sink sink(@NotNull Socket r0) {
        return Okio__JvmOkioKt.sink(r0);
    }

    @IgnoreJRERequirement
    @NotNull
    public static final Source source(@NotNull Path r0, @NotNull OpenOption... r1) {
        return Okio__JvmOkioKt.source(r0, r1);
    }

    @IgnoreJRERequirement
    @NotNull
    public static final Sink sink(@NotNull Path r0, @NotNull OpenOption... r1) {
        return Okio__JvmOkioKt.sink(r0, r1);
    }
}
