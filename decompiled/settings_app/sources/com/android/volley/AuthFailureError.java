package com.android.volley;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class AuthFailureError extends VolleyError {
    private Intent mResolutionIntent;

    public AuthFailureError() {
    }

    public AuthFailureError(Intent r1) {
        this.mResolutionIntent = r1;
    }

    public AuthFailureError(NetworkResponse r1) {
        super(r1);
    }

    public AuthFailureError(String r1) {
        super(r1);
    }

    public AuthFailureError(String r1, Exception r2) {
        super(r1, r2);
    }

    public Intent getResolutionIntent() {
        return this.mResolutionIntent;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.mResolutionIntent == null) goto L7;
        return "User needs to (re)enter credentials.";
    L7:
        return super.getMessage();
    }
}
