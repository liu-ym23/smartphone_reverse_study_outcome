package com.obric.matrix.sdk.push.cross_process;

import a.a.a.a.a.b.b;
import a.a.a.a.a.c.c;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.alog.AlogMonitor;
import com.ss.android.message.log.PushLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH&R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/matrix/sdk/push/cross_process/CrossProcessService;", "Landroid/app/Service;", "()V", "mBinder", "Lcom/obric/matrix/push/common/cross_process/ICrossProcessInterface$Stub;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "registerCrossProcessMethod", "", "sdk_push_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CrossProcessService extends Service {
    private b.a mBinder;

    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J9\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J*\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u000fH\u0016¨\u0006\u0014"}, d2 = {"com/obric/matrix/sdk/push/cross_process/CrossProcessService$onBind$1", "Lcom/obric/matrix/push/common/cross_process/ICrossProcessInterface$Stub;", "invoke", "", "method", "", "originPkgName", "args", "", "", "callback", "Lcom/obric/matrix/push/common/cross_process/ICrossProcessCallbackInterface;", "onTransact", "", AlogMonitor.ALOG_RESULT_CODE, "", "data", "Landroid/os/Parcel;", "reply", "flags", "sdk_push_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends b.a {
        public final /* synthetic */ CrossProcessService b;

        public a(CrossProcessService r1) {
            this.b = r1;
        }

        @Override // a.a.a.a.a.b.b
        public void a(String r2, String r3, List<Object> r4, a.a.a.a.a.b.a r5) {
            if (r2 == null) goto L7;
            CrossProcessService r1 = this.b;
            if (r3 == null) goto L8;
            a.a.a.a.a.a.f5a.a(r1).onMethodInvoke(r2, r3, r4, r5);
            return;
        L8:
            return;
        }

        @Override // a.a.a.a.a.b.b.a, android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            Intrinsics.checkNotNullParameter(r7, "data");
            String r2 = "crossProcess service onTransact is " + this.b.getPackageManager().getNameForUid(Binder.getCallingUid());     // Catch: Throwable -> L17
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);     // Catch: Throwable -> L17
            Intrinsics.checkNotNullParameter("", PushLog.KEY_TAG);     // Catch: Throwable -> L17
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);     // Catch: Throwable -> L17
            String r3 = c.b("", r2);     // Catch: Throwable -> L17
            if (c.b == false) goto L9;
            Intrinsics.checkNotNullParameter("MATRIX_PUSH", PushLog.KEY_TAG);     // Catch: Throwable -> L17
            Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);     // Catch: Throwable -> L17
            Log.i("MATRIX_PUSH", r3);     // Catch: Throwable -> L17
        L9:
            a.a.a.a.a.c.b r0 = c.c;     // Catch: Throwable -> L17
            if (r0 == null) goto L13;
            r0.b("MATRIX_PUSH", r3);     // Catch: Throwable -> L17
        L13:
            if (Intrinsics.areEqual(this.b.getPackageManager().getNameForUid(Binder.getCallingUid()), "android.uid.system:1000") == false) goto L21;
            return super.onTransact(r6, r7, r8, r9);
        L21:
            return false;
        L18:
            return super.onTransact(r6, r7, r8, r9);
        }
    }

    public CrossProcessService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        if (this.mBinder != null) goto L6;
        registerCrossProcessMethod();
        this.mBinder = new a(this);
    L6:
        return this.mBinder;
    }

    public abstract void registerCrossProcessMethod();
}
