package com.obric.matrix.platform.sdk.ones.picolinks;

import android.util.Log;
import com.obric.matrix.platform.sdk.ones.internal.monitor.EventConstants;
import com.obric.matrix.platform.sdk.ones.internal.tunnel.CmdManager;
import com.obric.matrix.proto.MATRIX_CMD;
import com.obric.matrix.proto.Request;
import com.obric.matrix.proto.Response;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PicoLinksBroker {

    @NotNull
    public static final PicoLinksBroker INSTANCE = null;

    @NotNull
    private static final String TAG = "PicoLinksBroker";

    static {
        INSTANCE = new PicoLinksBroker();
    }

    private PicoLinksBroker() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendCmd$default(PicoLinksBroker r0, MATRIX_CMD r1, Request r2, boolean r3, Function1 r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = null;
    L8:
        r0.sendCmd(r1, r2, r3, r4);
    }

    public final void sendCmd(@NotNull MATRIX_CMD r3, @NotNull Request r4, boolean r5, @Nullable final Function1<? super Response, Unit> r6) {
        Intrinsics.f(r3, EventConstants.EVENT_KEY_CMD);
        Intrinsics.f(r4, "request");
        Log.d(TAG, "request=" + r4 + ", isSync=" + r5);
        if (r5 == false) goto L11;
        Response r7 = CmdManager.INSTANCE.sendCmdSync(r3.getValue(), r4);     // Catch: Throwable -> L9
        if (r7 == null) goto L15;
        Log.d(TAG, "response=" + r7);     // Catch: Throwable -> L9
        if (r6 == null) goto L15;
        r6.invoke(r7);     // Catch: Throwable -> L9
    L15:
        return;
    L11:
        CmdManager.INSTANCE.sendCmd(r3.getValue(), r4, new AnonymousClass2(r6));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Log.w(TAG, th);
    }
}
