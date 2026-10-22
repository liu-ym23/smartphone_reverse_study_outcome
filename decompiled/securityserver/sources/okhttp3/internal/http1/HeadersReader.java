package okhttp3.internal.http1;

import com.bytedance.apm.battery.dao.DBHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class HeadersReader {
    public static final Companion Companion = null;
    private static final int HEADER_LIMIT = 262144;
    private long headerLimit;

    @NotNull
    private final BufferedSource source;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public HeadersReader(@NotNull BufferedSource r3) {
        Intrinsics.f(r3, DBHelper.BATTERY_COL_SOURCE);
        this.source = r3;
        this.headerLimit = 262144;
    }

    @NotNull
    public final BufferedSource getSource() {
        return this.source;
    }

    @NotNull
    public final Headers readHeaders() {
        Headers.Builder r0 = new Headers.Builder();
    L3:
        String r1 = readLine();
        if (r1.length() == 0) goto L6;
        r0.addLenient$okhttp(r1);
        goto L3
    L6:
        return r0.build();
    }

    @NotNull
    public final String readLine() {
        String r0 = this.source.readUtf8LineStrict(this.headerLimit);
        this.headerLimit -= (long) r0.length();
        return r0;
    }
}
