package com.obric.matrix.platform.sdk.ones.ws;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class WsStatusReceiver extends BroadcastReceiver {

    @NotNull
    public static final Companion Companion = null;

    @NotNull
    private static final String TAG = "WsStatusReceiver";

    @NotNull
    private static final String WS_CHANNEL_ID = "ws_status_channel_id";

    @NotNull
    private static final String WS_CHANNEL_TYPE = "ws_status_channel_type";

    @NotNull
    private static final String WS_CONNECTION_STATE = "ws_connection_state";

    @NotNull
    private static final String WS_IS_CONNECTED = "ws_is_connected";

    @NotNull
    public static final String WS_STATUS_BROADCAST_ACTION = "android.intent.action.WS_STATUS";

    @NotNull
    private final Function4<Integer, Integer, Integer, Boolean, Unit> listener;

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

    /* JADX WARN: Multi-variable type inference failed */
    public WsStatusReceiver(@NotNull Function4<? super Integer, ? super Integer, ? super Integer, ? super Boolean, Unit> r2) {
        Intrinsics.f(r2, "listener");
        this.listener = r2;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context r5, @Nullable Intent r6) {
        Log.d(TAG, "onReceive() called with: context = " + r5 + ", intent = " + r6);
        Boolean r7 = null;
        if (r6 == null) goto L5;
        Integer r1 = Integer.valueOf(r6.getIntExtra(WS_CHANNEL_ID, 0));
    L6:
        if (r6 == null) goto L8;
        Integer r2 = Integer.valueOf(r6.getIntExtra(WS_CHANNEL_TYPE, 0));
    L9:
        if (r6 == null) goto L11;
        Integer r3 = Integer.valueOf(r6.getIntExtra(WS_CONNECTION_STATE, 0));
    L12:
        if (r6 == null) goto L14;
        r7 = Boolean.valueOf(r6.getBooleanExtra(WS_IS_CONNECTED, false));
    L14:
        Function4<Integer, Integer, Integer, Boolean, Unit> r4 = this.listener;
        Intrinsics.c(r2);
        Intrinsics.c(r3);
        Intrinsics.c(r1);
        Intrinsics.c(r7);
        r4.invoke(r2, r3, r1, r7);
        return;
    L11:
        r3 = null;
        goto L12
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }
}
