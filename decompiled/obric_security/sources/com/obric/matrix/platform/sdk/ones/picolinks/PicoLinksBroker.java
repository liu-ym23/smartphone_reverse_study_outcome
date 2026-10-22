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

/* JADX INFO: compiled from: PicoLinksBroker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/picolinks/PicoLinksBroker;", "", "()V", "TAG", "", "sendCmd", "", EventConstants.EVENT_KEY_CMD, "Lcom/obric/matrix/proto/MATRIX_CMD;", "request", "Lcom/obric/matrix/proto/Request;", "isSync", "", "callback", "Lkotlin/Function1;", "Lcom/obric/matrix/proto/Response;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PicoLinksBroker {
    public static final PicoLinksBroker INSTANCE = null;
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

    public final void sendCmd(MATRIX_CMD r3, Request r4, boolean r5, final Function1<? super Response, Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, EventConstants.EVENT_KEY_CMD);
        Intrinsics.checkNotNullParameter(r4, "request");
        Log.d(TAG, "request=" + r4 + ", isSync=" + r5);
        if (r5 == false) goto L9;
        Response r7 = CmdManager.INSTANCE.sendCmdSync(r3.getValue(), r4);     // Catch: Throwable -> L11
        if (r7 == null) goto L14;
        Log.d(TAG, "response=" + r7);     // Catch: Throwable -> L11
        if (r6 == null) goto L14;
        r6.invoke(r7);     // Catch: Throwable -> L11
    L14:
        return;
    L9:
        CmdManager.INSTANCE.sendCmd(r3.getValue(), r4, new AnonymousClass2(r6));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Log.w(TAG, th);
    }
}
