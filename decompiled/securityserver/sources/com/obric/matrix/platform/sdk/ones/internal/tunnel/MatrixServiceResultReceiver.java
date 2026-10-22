package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ResultReceiver;
import com.obric.matrix.platform.sdk.ones.internal.monitor.SdkErrorCode;
import com.obric.matrix.platform.sdk.ones.internal.util.KtExt;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.proto.Response;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MatrixServiceResultReceiver extends ResultReceiver {

    @NotNull
    public static final Companion Companion = null;

    @NotNull
    private static final String KEY_EXTRA_DATA = "EXTRA_DATA";

    @NotNull
    private static final String TAG = "MatrixServiceResultReceiver";

    @NotNull
    private final IResultCallback mResultCallback;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final ResultReceiver creator(@Nullable Handler r2, @NotNull IResultCallback r3) {
            Intrinsics.f(r3, "resultCallback");
            Parcel r1 = Parcel.obtain();
            Intrinsics.e(r1, "obtain()");
            new MatrixServiceResultReceiver(r2, r3).writeToParcel(r1, 0);
            r1.setDataPosition(0);
            ResultReceiver r4 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(r1);
            r1.recycle();
            return r4;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public MatrixServiceResultReceiver(@Nullable Handler r2, @NotNull IResultCallback r3) {
        Intrinsics.f(r3, "resultCallback");
        super(r2);
        this.mResultCallback = r3;
    }

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int r5, @Nullable Bundle r6) {
        super.onReceiveResult(r5, r6);
        if (r6 == null) goto L14;
        byte[] r1 = r6.getByteArray("RESPONSE_BYTE_ARRAY");     // Catch: Exception -> L11
        if (r1 == null) goto L14;
        Response r2 = Response.ADAPTER.decode(r1);     // Catch: Exception -> L11
        this.mResultCallback.onResponse(r2, KtExt.INSTANCE.toSafeJson(r6.getString(KEY_EXTRA_DATA)));     // Catch: Exception -> L9
        return;
    L9:
        e = e;
    L15:
        MLog.d$default(TAG, "onReceiveResult exception " + e.getMessage(), null, 4, null);
        if (r2 == null) goto L18;
        this.mResultCallback.onResponse(r2, new JSONObject());
        return;
    L18:
        if (r5 != 0) goto L21;
        r5 = SdkErrorCode.ERROR_RECEIVER_RESULT_EXCEPTION;
    L21:
        IResultCallback r4 = this.mResultCallback;
        Response r7 = new Response.Builder().statusCode(Integer.valueOf(r5)).errorMsg(SdkErrorCode.ERROR_REASON_RECEIVE_RESULT_EXCEPTION).build();
        Intrinsics.e(r7, "Builder().statusCode(err…RESULT_EXCEPTION).build()");
        r4.onResponse(r7, new JSONObject());
        return;
    L11:
        e = e;
        r2 = null;
    L14:
        throw new IllegalStateException("RESPONSE_BYTE_ARRAY not found");     // Catch: Exception -> L11
    }
}
