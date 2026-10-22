package okhttp3;

import com.android.settingslib.accessibility.AccessibilityUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: compiled from: Credentials.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lokhttp3/Credentials;", "", "()V", "basic", "", "username", "password", "charset", "Ljava/nio/charset/Charset;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Credentials {
    public static final Credentials INSTANCE = null;

    static {
        INSTANCE = new Credentials();
    }

    @JvmStatic
    public static final String basic(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "username");
        Intrinsics.checkNotNullParameter(r3, "password");
        return basic$default(r2, r3, null, 4, null);
    }

    private Credentials() {
    }

    public static /* synthetic */ String basic$default(String r0, String r1, Charset r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = StandardCharsets.ISO_8859_1;
        Intrinsics.checkNotNullExpressionValue(r2, "ISO_8859_1");
    L6:
        return basic(r0, r1, r2);
    }

    @JvmStatic
    public static final String basic(String r1, String r2, Charset r3) {
        Intrinsics.checkNotNullParameter(r1, "username");
        Intrinsics.checkNotNullParameter(r2, "password");
        Intrinsics.checkNotNullParameter(r3, "charset");
        return Intrinsics.stringPlus("Basic ", ByteString.Companion.encodeString(r1 + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + r2, r3).base64());
    }
}
