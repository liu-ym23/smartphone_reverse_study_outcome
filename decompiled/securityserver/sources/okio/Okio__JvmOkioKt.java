package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final /* synthetic */ class Okio__JvmOkioKt {
    private static final Logger logger = null;

    static {
        logger = Logger.getLogger("okio.Okio");
    }

    public static final /* synthetic */ Logger access$getLogger$p() {
        return logger;
    }

    @NotNull
    public static final Sink appendingSink(@NotNull File r2) {
        Intrinsics.f(r2, "$this$appendingSink");
        return Okio.sink(new FileOutputStream(r2, true));
    }

    private static final Logger getLogger$Okio__JvmOkioKt() {
        return logger;
    }

    public static final boolean isAndroidGetsocknameError(@NotNull AssertionError r2) {
        Intrinsics.f(r2, "$this$isAndroidGetsocknameError");
        if (r2.getCause() == null) goto L11;
        String r3 = r2.getMessage();
        if (r3 == null) goto L7;
        boolean r4 = StringsKt.m("getsockname failed", false, r3);
    L8:
        if (r4 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r4 = false;
        goto L8
    L11:
        return false;
    }

    @JvmOverloads
    @NotNull
    public static final Sink sink(@NotNull File r3) {
        return Okio.sink$default(r3, false, 1, null);
    }

    public static /* synthetic */ Sink sink$default(File r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return Okio.sink(r0, r1);
    }

    @NotNull
    public static final Source source(@NotNull InputStream r2) {
        Intrinsics.f(r2, "$this$source");
        return new InputStreamSource(r2, new Timeout());
    }

    @NotNull
    public static final Sink sink(@NotNull OutputStream r2) {
        Intrinsics.f(r2, "$this$sink");
        return new OutputStreamSink(r2, new Timeout());
    }

    @NotNull
    public static final Source source(@NotNull Socket r3) {
        Intrinsics.f(r3, "$this$source");
        SocketAsyncTimeout r0 = new SocketAsyncTimeout(r3);
        InputStream r4 = r3.getInputStream();
        Intrinsics.e(r4, "getInputStream()");
        return r0.source(new InputStreamSource(r4, r0));
    }

    @NotNull
    public static final Sink sink(@NotNull Socket r3) {
        Intrinsics.f(r3, "$this$sink");
        SocketAsyncTimeout r0 = new SocketAsyncTimeout(r3);
        OutputStream r4 = r3.getOutputStream();
        Intrinsics.e(r4, "getOutputStream()");
        return r0.sink(new OutputStreamSink(r4, r0));
    }

    @NotNull
    public static final Source source(@NotNull File r1) {
        Intrinsics.f(r1, "$this$source");
        return Okio.source(new FileInputStream(r1));
    }

    @JvmOverloads
    @NotNull
    public static final Sink sink(@NotNull File r1, boolean r2) {
        Intrinsics.f(r1, "$this$sink");
        return Okio.sink(new FileOutputStream(r1, r2));
    }

    @IgnoreJRERequirement
    @NotNull
    public static final Source source(@NotNull Path r1, @NotNull OpenOption... r2) {
        Intrinsics.f(r1, "$this$source");
        Intrinsics.f(r2, "options");
        InputStream r3 = Files.newInputStream(r1, (OpenOption[]) Arrays.copyOf(r2, r2.length));
        Intrinsics.e(r3, "Files.newInputStream(this, *options)");
        return Okio.source(r3);
    }

    @IgnoreJRERequirement
    @NotNull
    public static final Sink sink(@NotNull Path r1, @NotNull OpenOption... r2) {
        Intrinsics.f(r1, "$this$sink");
        Intrinsics.f(r2, "options");
        OutputStream r3 = Files.newOutputStream(r1, (OpenOption[]) Arrays.copyOf(r2, r2.length));
        Intrinsics.e(r3, "Files.newOutputStream(this, *options)");
        return Okio.sink(r3);
    }
}
