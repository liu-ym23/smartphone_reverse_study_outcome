package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class UriKt {
    @NotNull
    public static final File toFile(@NotNull Uri r2) {
        Intrinsics.g(r2, "$this$toFile");
        if (Intrinsics.a(r2.getScheme(), "file") == false) goto L7;
        return new File(r2.getPath());
    L7:
        throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + r2).toString());
    }

    @NotNull
    public static final Uri toUri(@NotNull String r1) {
        Intrinsics.g(r1, "$this$toUri");
        Uri r2 = Uri.parse(r1);
        Intrinsics.b(r2, "Uri.parse(this)");
        return r2;
    }

    @NotNull
    public static final Uri toUri(@NotNull File r1) {
        Intrinsics.g(r1, "$this$toUri");
        Uri r2 = Uri.fromFile(r1);
        Intrinsics.b(r2, "Uri.fromFile(this)");
        return r2;
    }
}
