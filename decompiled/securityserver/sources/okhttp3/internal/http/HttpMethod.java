package okhttp3.internal.http;

import com.bytedance.retrofit2.HttpMethodContrants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class HttpMethod {
    public static final HttpMethod INSTANCE = null;

    static {
        INSTANCE = new HttpMethod();
    }

    private HttpMethod() {
    }

    @JvmStatic
    public static final boolean permitsRequestBody(@NotNull String r1) {
        Intrinsics.f(r1, "method");
        if (r1.equals(HttpMethodContrants.GET) == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.equals(HttpMethodContrants.HEAD) == true) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean requiresRequestBody(@NotNull String r1) {
        Intrinsics.f(r1, "method");
        if (r1.equals(HttpMethodContrants.POST) == false) goto L5;
    L14:
        return true;
    L5:
        if (r1.equals(HttpMethodContrants.PUT) == true) goto L14;
        if (r1.equals(HttpMethodContrants.PATCH) == true) goto L14;
        if (r1.equals("PROPPATCH") == true) goto L14;
        if (r1.equals("REPORT") == true) goto L14;
        return false;
    }

    public final boolean invalidatesCache(@NotNull String r1) {
        Intrinsics.f(r1, "method");
        if (r1.equals(HttpMethodContrants.POST) == false) goto L5;
    L14:
        return true;
    L5:
        if (r1.equals(HttpMethodContrants.PATCH) == true) goto L14;
        if (r1.equals(HttpMethodContrants.PUT) == true) goto L14;
        if (r1.equals(HttpMethodContrants.DELETE) == true) goto L14;
        if (r1.equals("MOVE") == true) goto L14;
        return false;
    }

    public final boolean redirectsToGet(@NotNull String r1) {
        Intrinsics.f(r1, "method");
        return !r1.equals("PROPFIND");
    }

    public final boolean redirectsWithBody(@NotNull String r1) {
        Intrinsics.f(r1, "method");
        return r1.equals("PROPFIND");
    }
}
