package com.bytedanceos.securitycenter;

import android.content.Context;
import android.content.IContentProvider;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedanceos.security.multi.adpter.MultiSdkAdapter;
import com.bytedanceos.security.reflect.ReflectHelper;

/* JADX INFO: loaded from: classes2.dex */
public class Utils {
    public Utils() {
    }

    public static void sendCloudFeedBack(Context context, String taskName, String receivedMD5) {
        Uri r0 = Uri.parse("content://com.bytedanceos.datasync");
        IContentProvider r2 = context.getContentResolver().acquireProvider(r0);
        if (r2 == null) goto L17;
        Bundle r7 = new Bundle();
        r7.putString("name", taskName);
        r7.putString("md5", receivedMD5);
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        if (MultiSdkAdapter.isAfterQ() == false) goto L8;
        sendCloudFeedBackAfterQ(r2, context.getPackageName(), "com.bytedanceos.datasync", "com.android.providers.downloads.ACTION_SYNC_DATA_FINISH_FEEDBACK", null, r7);     // Catch: RemoteException -> L10
    L13:
        return;
    L8:
        r2.call(context.getPackageName(), "com.android.providers.downloads.ACTION_SYNC_DATA_FINISH_FEEDBACK", null, r7);     // Catch: RemoteException -> L10
        goto L13
    }

    private static void sendCloudFeedBackAfterQ(IContentProvider provider, String packageName, String author, String method, String arg, Bundle extras) {
        if (provider != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(packageName) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(author) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(method) == true) goto L15;
        ReflectHelper.invokeMethod(provider, NotificationCompat.CATEGORY_CALL, new Class[]{String.class, String.class, String.class, String.class, Bundle.class}, new Object[]{packageName, author, method, arg, extras});
        return;
    }
}
