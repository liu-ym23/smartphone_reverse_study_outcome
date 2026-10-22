package androidx.core.util;

import androidx.annotation.RequiresApi;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AtomicFileKt {
    @RequiresApi(17)
    @NotNull
    public static final byte[] readBytes(@NotNull android.util.AtomicFile r1) {
        Intrinsics.g(r1, "$this$readBytes");
        byte[] r2 = r1.readFully();
        Intrinsics.b(r2, "readFully()");
        return r2;
    }

    @RequiresApi(17)
    @NotNull
    public static final String readText(@NotNull android.util.AtomicFile r1, @NotNull Charset r2) {
        Intrinsics.g(r1, "$this$readText");
        Intrinsics.g(r2, "charset");
        byte[] r3 = r1.readFully();
        Intrinsics.b(r3, "readFully()");
        return new String(r3, r2);
    }

    @RequiresApi(17)
    @NotNull
    public static /* synthetic */ String readText$default(android.util.AtomicFile r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = Charsets.f354a;
    L6:
        return readText(r0, r1);
    }

    @RequiresApi(17)
    public static final void tryWrite(@NotNull android.util.AtomicFile r2, @NotNull Function1<? super FileOutputStream, Unit> r3) {
        Intrinsics.g(r2, "$this$tryWrite");
        Intrinsics.g(r3, "block");
        FileOutputStream r0 = r2.startWrite();
        Intrinsics.b(r0, "stream");     // Catch: Throwable -> L6
        r3.invoke(r0);     // Catch: Throwable -> L6
        r2.finishWrite(r0);
        return;
    L6:
        th = move-exception;
        r2.failWrite(r0);
        throw th;
    }

    @RequiresApi(17)
    public static final void writeBytes(@NotNull android.util.AtomicFile r2, @NotNull byte[] r3) {
        Intrinsics.g(r2, "$this$writeBytes");
        Intrinsics.g(r3, "array");
        FileOutputStream r0 = r2.startWrite();
        Intrinsics.b(r0, "stream");     // Catch: Throwable -> L6
        r0.write(r3);     // Catch: Throwable -> L6
        r2.finishWrite(r0);
        return;
    L6:
        th = move-exception;
        r2.failWrite(r0);
        throw th;
    }

    @RequiresApi(17)
    public static final void writeText(@NotNull android.util.AtomicFile r1, @NotNull String r2, @NotNull Charset r3) {
        Intrinsics.g(r1, "$this$writeText");
        Intrinsics.g(r2, "text");
        Intrinsics.g(r3, "charset");
        byte[] r4 = r2.getBytes(r3);
        Intrinsics.b(r4, "(this as java.lang.String).getBytes(charset)");
        writeBytes(r1, r4);
    }

    @RequiresApi(17)
    public static /* synthetic */ void writeText$default(android.util.AtomicFile r0, String r1, Charset r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = Charsets.f354a;
    L5:
        writeText(r0, r1, r2);
    }
}
