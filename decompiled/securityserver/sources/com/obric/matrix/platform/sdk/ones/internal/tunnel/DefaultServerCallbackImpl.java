package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.util.Log;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.platform.server.IServerCallback;
import com.obric.matrix.proto.Response;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DefaultServerCallbackImpl extends IServerCallback.Stub {

    @NotNull
    public static final Companion Companion = null;

    @NotNull
    private static final String TAG = "DefaultServerCallbackImpl";

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

    public DefaultServerCallbackImpl() {
    }

    @Override // com.obric.matrix.platform.server.IServerCallback
    public void onResult(int r7, @Nullable byte[] r8) {
        MLog.d$default(TAG, "onResult(cmd: " + r7 + ", bytes: " + r8 + ").", null, 4, null);
        Iterator<T> r6 = MatrixBinderManager.INSTANCE.getNotificationSet$sdk_platform_ones_release().iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        CmdResultCallback r3 = (CmdResultCallback) r6.next();
        MLog.d$default(TAG, "notification start", null, 4, null);     // Catch: Exception -> L9
        if (r8 != null) goto L8;
        throw new IllegalStateException("result bytes is null".toString());     // Catch: Exception -> L9
    L8:
        Response r4 = Response.ADAPTER.decode(r8);     // Catch: Exception -> L9
        Intrinsics.e(r4, "ADAPTER.decode(bytes)");     // Catch: Exception -> L9
        r3.onResult(r7, r4);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        MLog.d$default(TAG, "on notification exception " + Log.getStackTraceString(e), null, 4, null);
        goto L4
    }
}
