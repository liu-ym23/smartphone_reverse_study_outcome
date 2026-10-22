package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class ExecutorDelivery implements ResponseDelivery {
    private final Executor mResponsePoster;

    private static class ResponseDeliveryRunnable implements Runnable {
        private final Request mRequest;
        private final Response mResponse;
        private final Runnable mRunnable;

        public ResponseDeliveryRunnable(Request r1, Response r2, Runnable r3) {
            this.mRequest = r1;
            this.mResponse = r2;
            this.mRunnable = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mRequest.isCanceled() == false) goto L7;
            this.mRequest.finish("canceled-at-delivery");
            return;
        L7:
            if (this.mResponse.isSuccess() == false) goto L9;
            this.mRequest.deliverResponse(this.mResponse.result);
        L11:
            if (this.mResponse.intermediate == false) goto L13;
            this.mRequest.addMarker("intermediate-response");
        L14:
            Runnable r2 = this.mRunnable;
            if (r2 == null) goto L18;
            r2.run();
            return;
        L18:
            return;
        L13:
            this.mRequest.finish("done");
            goto L14
        L9:
            this.mRequest.deliverError(this.mResponse.error);
            goto L11
        }
    }

    public ExecutorDelivery(final Handler r2) {
        this.mResponsePoster = new AnonymousClass1(this, r2);
    }

    public ExecutorDelivery(Executor r1) {
        this.mResponsePoster = r1;
    }

    @Override // com.android.volley.ResponseDelivery
    public void postResponse(Request<?> r2, Response<?> r3) {
        postResponse(r2, r3, null);
    }

    @Override // com.android.volley.ResponseDelivery
    public void postResponse(Request<?> r2, Response<?> r3, Runnable r4) {
        r2.markDelivered();
        r2.addMarker("post-response");
        this.mResponsePoster.execute(new ResponseDeliveryRunnable(r2, r3, r4));
    }

    @Override // com.android.volley.ResponseDelivery
    public void postError(Request<?> r3, VolleyError r4) {
        r3.addMarker("post-error");
        Response r5 = Response.error(r4);
        this.mResponsePoster.execute(new ResponseDeliveryRunnable(r3, r5, null));
    }
}
