package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.util.Log;
import com.obric.matrix.platform.sdk.ones.internal.monitor.EventConstants;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.platform.server.IServerCallback;
import com.obric.matrix.proto.Response;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultServerCallbackImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/DefaultServerCallbackImpl;", "Lcom/obric/matrix/platform/server/IServerCallback$Stub;", "()V", "onResult", "", EventConstants.EVENT_KEY_CMD, "", "bytes", "", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultServerCallbackImpl extends IServerCallback.Stub {
    public static final Companion Companion = null;
    private static final String TAG = "DefaultServerCallbackImpl";

    /* JADX INFO: compiled from: DefaultServerCallbackImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/DefaultServerCallbackImpl$Companion;", "", "()V", "TAG", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DefaultServerCallbackImpl() {
    }

    @Override // com.obric.matrix.platform.server.IServerCallback
    public void onResult(int r7, byte[] r8) {
        MLog.d$default(TAG, "onResult(cmd: " + r7 + ", bytes: " + r8 + ").", null, 4, null);
        Iterator<T> r6 = MatrixBinderManager.INSTANCE.getNotificationSet$sdk_platform_ones_release().iterator();
    L4:
        if (r6.hasNext() == false) goto L16;
        CmdResultCallback r3 = (CmdResultCallback) r6.next();
        MLog.d$default(TAG, "notification start", null, 4, null);     // Catch: Exception -> L14
        if (r8 == null) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L11;
        throw new IllegalStateException("result bytes is null".toString());     // Catch: Exception -> L14
    L11:
        Response r5 = Response.ADAPTER.decode(r8);     // Catch: Exception -> L14
        Intrinsics.checkNotNullExpressionValue(r5, "ADAPTER.decode(bytes)");     // Catch: Exception -> L14
        r3.onResult(r7, r5);     // Catch: Exception -> L14
        goto L4
    L9:
        r4 = false;
    L14:
        e = move-exception;
        MLog.d$default(TAG, "on notification exception " + Log.getStackTraceString(e), null, 4, null);
        goto L4
    }
}
