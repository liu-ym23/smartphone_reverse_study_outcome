package com.obric.matrix.platform.sdk.ones.ws;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class WsMsgReceiver extends BroadcastReceiver {

    @NotNull
    public static final Companion Companion = null;

    @NotNull
    private static final String TAG = "WsMsgReceiver";

    @NotNull
    private static final String WS_MSG_KEY_CHANNEL_ID = "channel_id";

    @NotNull
    private static final String WS_MSG_KEY_HEADERS = "ws_headers";

    @NotNull
    private static final String WS_MSG_KEY_IM_CMD = "cmd";

    @NotNull
    private static final String WS_MSG_KEY_LOG_ID = "log_id";

    @NotNull
    private static final String WS_MSG_KEY_METHOD = "method";

    @NotNull
    private static final String WS_MSG_KEY_PAYLOAD = "payload";

    @NotNull
    private static final String WS_MSG_KEY_PAYLOAD_ENCODING = "payload_encoding";

    @NotNull
    private static final String WS_MSG_KEY_PAYLOAD_TYPE = "payload_type";

    @NotNull
    private static final String WS_MSG_KEY_SEQ_ID = "seq_id";

    @NotNull
    private static final String WS_MSG_KEY_SERVICE = "service";

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

    public WsMsgReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context r21, @Nullable Intent r22) {
        Log.d(TAG, "onReceive() called with: context = " + r21 + ", intent = " + r22);
        byte[] r2 = null;
        if (r22 == null) goto L5;
        Integer r3 = Integer.valueOf(r22.getIntExtra("channel_id", 0));
    L7:
        if (r22 == null) goto L9;
        Long r6 = Long.valueOf(r22.getLongExtra(WS_MSG_KEY_SEQ_ID, 0));
    L10:
        if (r22 == null) goto L12;
        Long r4 = Long.valueOf(r22.getLongExtra("log_id", 0));
    L13:
        if (r22 == null) goto L15;
        Integer r5 = Integer.valueOf(r22.getIntExtra("service", 0));
    L16:
        if (r22 == null) goto L18;
        Integer r1 = Integer.valueOf(r22.getIntExtra(WS_MSG_KEY_METHOD, 0));
    L19:
        if (r22 == null) goto L21;
        Serializable r7 = r22.getSerializableExtra(WS_MSG_KEY_HEADERS);
    L22:
        if (r7 == null) goto L35;
        HashMap<String, String> r19 = (HashMap) r7;
        if (r22 == null) goto L26;
        String r17 = r22.getStringExtra(WS_MSG_KEY_PAYLOAD_TYPE);
    L27:
        if (r22 == null) goto L29;
        String r16 = r22.getStringExtra(WS_MSG_KEY_PAYLOAD_ENCODING);
    L30:
        if (r22 == null) goto L32;
        r2 = r22.getByteArrayExtra("payload");
    L32:
        Intrinsics.c(r3);
        int r9 = r3.intValue();
        Intrinsics.c(r6);
        long r10 = r6.longValue();
        Intrinsics.c(r4);
        long r12 = r4.longValue();
        Intrinsics.c(r5);
        int r14 = r5.intValue();
        Intrinsics.c(r1);
        onWsMsgReceived(r9, r10, r12, r14, r1.intValue(), r16, r17, r2, r19);
        return;
    L29:
        r16 = null;
        goto L30
    L26:
        r17 = null;
        goto L27
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
    L21:
        r7 = null;
        goto L22
    L18:
        r1 = null;
        goto L19
    L15:
        r5 = null;
        goto L16
    L12:
        r4 = null;
        goto L13
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    public abstract void onWsMsgReceived(int r1, long r2, long r4, int r6, int r7, @Nullable String r8, @Nullable String r9, @Nullable byte[] r10, @Nullable HashMap<String, String> r11);
}
