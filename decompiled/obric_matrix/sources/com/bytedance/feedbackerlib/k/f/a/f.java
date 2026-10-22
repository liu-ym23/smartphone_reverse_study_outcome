package com.bytedance.feedbackerlib.k.f.a;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class f implements MediaScannerConnection.MediaScannerConnectionClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediaScannerConnection f4252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f4254c;

    public interface a {
        void a();
    }

    public f(Context r1, String r2, a r3) {
        this.f4253b = r2;
        this.f4254c = r3;
        MediaScannerConnection r4 = new MediaScannerConnection(r1, this);
        this.f4252a = r4;
        r4.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        this.f4252a.scanFile(this.f4253b, null);
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String r1, Uri r2) {
        this.f4252a.disconnect();
        a r0 = this.f4254c;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }
}
