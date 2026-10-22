package com.bytedance.frameworks.baselib.network.http.util;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class DownloadFileTooLargeException extends IOException {
    private static final long serialVersionUID = -1098012010869697449L;
    final long length;
    final int maxSize;

    public DownloadFileTooLargeException(int r3, long r4) {
        super("Download file too large: " + r4 + " exceed maxsize: " + r3);
        this.maxSize = r3;
        this.length = r4;
    }

    public long getLength() {
        return this.length;
    }

    public int getMaxSize() {
        return this.maxSize;
    }
}
