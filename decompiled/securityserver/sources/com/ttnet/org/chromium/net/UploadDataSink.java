package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: classes2.dex */
public abstract class UploadDataSink {
    public UploadDataSink() {
    }

    public abstract void onReadError(Exception r1);

    public abstract void onReadSucceeded(boolean r1);

    public abstract void onRewindError(Exception r1);

    public abstract void onRewindSucceeded();
}
