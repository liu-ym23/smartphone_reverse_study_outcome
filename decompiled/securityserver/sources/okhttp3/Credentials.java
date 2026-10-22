package okhttp3;

import a.a;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Credentials {
    public static final Credentials INSTANCE = null;

    static {
        INSTANCE = new Credentials();
    }

    private Credentials() {
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final String basic(@NotNull String r2, @NotNull String r3) {
        return basic$default(r2, r3, null, 4, null);
    }

    public static /* synthetic */ String basic$default(String r0, String r1, Charset r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = StandardCharsets.ISO_8859_1;
        Intrinsics.e(r2, "ISO_8859_1");
    L6:
        return basic(r0, r1, r2);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final String basic(@NotNull String r1, @NotNull String r2, @NotNull Charset r3) {
        Intrinsics.f(r1, "username");
        Intrinsics.f(r2, "password");
        Intrinsics.f(r3, "charset");
        return a.A("Basic ", ByteString.Companion.encodeString(r1 + ':' + r2, r3).base64());
    }
}
