package okhttp3.internal.http2;

import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface PushObserver {

    @JvmField
    @NotNull
    public static final PushObserver CANCEL = null;
    public static final Companion Companion = null;

    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        @Metadata
        public static final class PushObserverCancel implements PushObserver {
            public PushObserverCancel() {
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onData(int r1, @NotNull BufferedSource r2, int r3, boolean r4) {
                Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
                r2.skip(r3);
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onHeaders(int r1, @NotNull List<Header> r2, boolean r3) {
                Intrinsics.f(r2, "responseHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onRequest(int r1, @NotNull List<Header> r2) {
                Intrinsics.f(r2, "requestHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public void onReset(int r1, @NotNull ErrorCode r2) {
                Intrinsics.f(r2, AccountConst.KEY_ERROR_CODE);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        CANCEL = new Companion.PushObserverCancel();
    }

    boolean onData(int r1, @NotNull BufferedSource r2, int r3, boolean r4);

    boolean onHeaders(int r1, @NotNull List<Header> r2, boolean r3);

    boolean onRequest(int r1, @NotNull List<Header> r2);

    void onReset(int r1, @NotNull ErrorCode r2);
}
