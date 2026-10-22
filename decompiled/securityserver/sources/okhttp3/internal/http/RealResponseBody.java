package okhttp3.internal.http;

import com.bytedance.apm.battery.dao.DBHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final BufferedSource source;

    public RealResponseBody(@Nullable String r2, long r3, @NotNull BufferedSource r5) {
        Intrinsics.f(r5, DBHelper.BATTERY_COL_SOURCE);
        this.contentTypeString = r2;
        this.contentLength = r3;
        this.source = r5;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.ResponseBody
    @Nullable
    public MediaType contentType() {
        String r1 = this.contentTypeString;
        if (r1 != null) goto L7;
        return null;
    L7:
        return MediaType.Companion.parse(r1);
    }

    @Override // okhttp3.ResponseBody
    @NotNull
    public BufferedSource source() {
        return this.source;
    }
}
