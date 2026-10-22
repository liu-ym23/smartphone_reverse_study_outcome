package com.ss.android.pushmanager.app;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class ApiException extends IOException {
    int httpStatus;

    public ApiException(String r1, int r2) {
        super(r1);
        this.httpStatus = r2;
    }
}
