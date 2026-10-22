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
import org.json.JSONObject;

/* JADX INFO: compiled from: MatrixServiceResultReceiver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/MatrixServiceResultReceiver;", "Landroid/os/ResultReceiver;", "handler", "Landroid/os/Handler;", "resultCallback", "Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/IResultCallback;", "(Landroid/os/Handler;Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/IResultCallback;)V", "mResultCallback", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatrixServiceResultReceiver extends ResultReceiver {
    public static final Companion Companion = null;
    private static final String KEY_EXTRA_DATA = "EXTRA_DATA";
    private static final String TAG = "MatrixServiceResultReceiver";
    private final IResultCallback mResultCallback;

    /* JADX INFO: compiled from: MatrixServiceResultReceiver.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/MatrixServiceResultReceiver$Companion;", "", "()V", "KEY_EXTRA_DATA", "", "TAG", "creator", "Landroid/os/ResultReceiver;", "handler", "Landroid/os/Handler;", "resultCallback", "Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/IResultCallback;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final ResultReceiver creator(Handler r2, IResultCallback r3) {
            Intrinsics.checkNotNullParameter(r3, "resultCallback");
            Parcel r1 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r1, "obtain()");
            new MatrixServiceResultReceiver(r2, r3).writeToParcel(r1, 0);
            r1.setDataPosition(0);
            ResultReceiver r4 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(r1);
            r1.recycle();
            return r4;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public MatrixServiceResultReceiver(Handler r2, IResultCallback r3) {
        Intrinsics.checkNotNullParameter(r3, "resultCallback");
        super(r2);
        this.mResultCallback = r3;
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int r5, Bundle r6) {
        super.onReceiveResult(r5, r6);
        if (r6 == null) goto L12;
        byte[] r1 = r6.getByteArray("RESPONSE_BYTE_ARRAY");     // Catch: Exception -> L13
        if (r1 == null) goto L12;
        Response r2 = Response.ADAPTER.decode(r1);     // Catch: Exception -> L13
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
        Intrinsics.checkNotNullExpressionValue(r7, "Builder().statusCode(err…RESULT_EXCEPTION).build()");
        r4.onResponse(r7, new JSONObject());
        return;
    L13:
        e = e;
        r2 = null;
    L12:
        throw new IllegalStateException("RESPONSE_BYTE_ARRAY not found");     // Catch: Exception -> L13
    }
}
