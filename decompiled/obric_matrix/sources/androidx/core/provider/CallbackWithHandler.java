package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
class CallbackWithHandler {

    @NonNull
    private final FontsContractCompat.FontRequestCallback mCallback;

    @NonNull
    private final Handler mCallbackHandler;

    CallbackWithHandler(@NonNull FontsContractCompat.FontRequestCallback r1) {
        this.mCallback = r1;
        this.mCallbackHandler = CalleeHandler.create();
    }

    CallbackWithHandler(@NonNull FontsContractCompat.FontRequestCallback r1, @NonNull Handler r2) {
        this.mCallback = r1;
        this.mCallbackHandler = r2;
    }

    private void onTypefaceRequestFailed(final int r4) {
        final FontsContractCompat.FontRequestCallback r0 = this.mCallback;
        this.mCallbackHandler.post(new AnonymousClass2(this, r0, r4));
    }

    private void onTypefaceRetrieved(@NonNull final Typeface r4) {
        final FontsContractCompat.FontRequestCallback r0 = this.mCallback;
        this.mCallbackHandler.post(new AnonymousClass1(this, r0, r4));
    }

    void onTypefaceResult(@NonNull FontRequestWorker.TypefaceResult r2) {
        if (r2.isSuccess() == false) goto L5;
        onTypefaceRetrieved(r2.mTypeface);
        return;
    L5:
        onTypefaceRequestFailed(r2.mResult);
    }
}
