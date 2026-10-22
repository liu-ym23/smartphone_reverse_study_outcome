package com.obric.appstore.autoupdate;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;
import com.obric.oui.progress.OProgressView;
import com.obric.oui.sheet.OInsetSheet;

/* JADX INFO: loaded from: classes.dex */
public class UpdateProgressDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f96a;
    public String b;
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UpdateHandler f97d;
    public TextView e;
    public OProgressView f;
    public OInsetSheet g;

    public class UpdateHandler extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UpdateProgressDialog f98a;

        public UpdateHandler(UpdateProgressDialog r1) {
            this.f98a = r1;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r6) {
            if (r6.what != 297) goto L23;
            ObricAutoUpdateUtils r7 = ObricAutoUpdateUtils.b();
            UpdateProgressDialog r1 = this.f98a;
            Context r2 = r1.f96a;
            String r3 = r1.b;
            r7.getClass();
            Bundle r8 = new Bundle();
            r8.putString("auto_update_pkg", r3);
            Bundle r9 = ObricAutoUpdateUtils.a(r2, "getDownloadProgress", r8);
            if (r9 == null) goto L7;
            int r10 = r9.getInt("auto_update_progress");
        L9:
            if (r10 >= 0) goto L12;
            Log.d("UpdateProgressDialog", "appstore progress: -1" + r1.b);
            return;
        L12:
            if (r10 != 100) goto L18;
            Log.d("UpdateProgressDialog", "appstore progress:" + r10);
            r1.a(r10);
            OInsetSheet r5 = r1.g;     // Catch: Exception -> L20
            if (r5 == null) goto L17;
            r5.dismiss();     // Catch: Exception -> L20
        L17:
            r1.f97d.removeMessages(297);
            return;
        L18:
            r1.a(r10);
            sendEmptyMessageDelayed(297, 300);
            return;
        L7:
            Log.d("AutoUpdateUtils", "getDownloadProgress:extrais null");
            r10 = -1;
            goto L9
        }
    }

    public final void a(int r4) {
        TextView r0 = this.e;
        if (r0 == null) goto L5;
        r0.setText(String.format("%d%%", new Object[]{Integer.valueOf(r4)}));
    L5:
        OProgressView r3 = this.f;
        if (r3 == null) goto L9;
        r3.setProgress(r4);
        return;
    }
}
