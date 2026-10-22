package com.android.settings.revone.boston;

import android.content.Context;
import android.net.Uri;
import com.obric.olog.OLog;
import java.io.File;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* JADX INFO: loaded from: classes2.dex */
public class GestureVideoDownloader {
    private static final String BASE_URL = "";
    public static final int BUFFER_SIZE = 1024;
    public static final int CODE_SUCCESS = 200;
    public static final String FOLDER = "gesture";
    private static final String TAG = "Gesture";
    private Context mContext;
    private File mDir;
    private OkHttpClient mOkHttpClient;

    public interface FetchVideoListener {
        void onVideoFetched(boolean r1, Uri r2);
    }

    static /* synthetic */ File access$000(GestureVideoDownloader r0) {
        return r0.mDir;
    }

    public GestureVideoDownloader(Context r3) {
        this.mContext = r3;
        this.mOkHttpClient = new OkHttpClient();
        File r4 = new File(this.mContext.getExternalFilesDir(null), "gesture");
        this.mDir = r4;
        if (r4.exists() == true) goto L6;
        this.mDir.mkdir();
        return;
    }

    public void fetchVideo(final String r3, final FetchVideoListener r4) {
        OLog.i(TAG, "gesture Downloader: fetchVideo " + r3);
        if (r3.startsWith("touchpad") == false) goto L5;
        String r0 = "t/" + r3 + "_3.mp4";
    L12:
        this.mOkHttpClient.newCall(new Request.Builder().url(r0).get().build()).enqueue(new AnonymousClass1(this, r4, r3));     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        r0 = "s/" + r3 + "_2.mp4";
        goto L12
    }
}
