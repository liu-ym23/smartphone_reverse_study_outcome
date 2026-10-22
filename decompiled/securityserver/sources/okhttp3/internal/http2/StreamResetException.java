package okhttp3.internal.http2;

import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class StreamResetException extends IOException {

    @JvmField
    @NotNull
    public final ErrorCode errorCode;

    public StreamResetException(@NotNull ErrorCode r3) {
        Intrinsics.f(r3, AccountConst.KEY_ERROR_CODE);
        super("stream was reset: " + r3);
        this.errorCode = r3;
    }
}
