package kotlin.text;

import com.ss.android.http.legacy.protocol.HTTP;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Charsets {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f354a = null;
    public static Charset b;
    public static Charset c;

    static {
        Charset r0 = Charset.forName("UTF-8");
        Intrinsics.e(r0, "forName(\"UTF-8\")");
        f354a = r0;
        Intrinsics.e(Charset.forName(HTTP.UTF_16), "forName(\"UTF-16\")");
        Intrinsics.e(Charset.forName("UTF-16BE"), "forName(\"UTF-16BE\")");
        Intrinsics.e(Charset.forName("UTF-16LE"), "forName(\"UTF-16LE\")");
        Intrinsics.e(Charset.forName("US-ASCII"), "forName(\"US-ASCII\")");
        Intrinsics.e(Charset.forName("ISO-8859-1"), "forName(\"ISO-8859-1\")");
    }
}
