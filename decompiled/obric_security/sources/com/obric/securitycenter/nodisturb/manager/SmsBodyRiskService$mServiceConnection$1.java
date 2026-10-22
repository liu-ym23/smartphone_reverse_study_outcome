package com.obric.securitycenter.nodisturb.manager;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.obric.olog.OLog;
import com.obric.smsparser.risk.ISmsRiskService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmsBodyRiskService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/obric/securitycenter/nodisturb/manager/SmsBodyRiskService$mServiceConnection$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", "className", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "arg0", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SmsBodyRiskService$mServiceConnection$1 implements ServiceConnection {
    final /* synthetic */ SmsBodyRiskService this$0;

    public static /* synthetic */ void $r8$lambda$NDSXWOYUZtOBdUqzL4Py7SF2g_c(SmsBodyRiskService r0) {
        onServiceDisconnected$lambda$0(r0);
    }

    SmsBodyRiskService$mServiceConnection$1(SmsBodyRiskService r1) {
        this.this$0 = r1;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r3, IBinder r4) {
        Intrinsics.checkNotNullParameter(r3, "className");
        Intrinsics.checkNotNullParameter(r4, "service");
        OLog.d("_CallSmsIntercept", "Service connected");
        SmsBodyRiskService.access$setMSmsRiskService$p(this.this$0, ISmsRiskService.Stub.asInterface(r4));
        if (SmsBodyRiskService.access$getPendingWork$p(this.this$0) == false) goto L6;
        SmsBodyRiskService r5 = this.this$0;
        r5.checkMessageRisk(SmsBodyRiskService.access$getMsgId$p(r5), SmsBodyRiskService.access$getPhoneNumber$p(this.this$0), SmsBodyRiskService.access$getBody$p(this.this$0), SmsBodyRiskService.access$getMMessageRiskListener$p(this.this$0));
        return;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r4) {
        Intrinsics.checkNotNullParameter(r4, "arg0");
        OLog.d("_CallSmsIntercept", "Service disconnected");
        SmsBodyRiskService.access$setMSmsRiskService$p(this.this$0, null);
        if (SmsBodyRiskService.access$getMIsUnbindByManual$p(this.this$0) == true) goto L9;
        SmsBodyRiskService r5 = this.this$0;
        int r0 = SmsBodyRiskService.access$getMRetryCount$p(r5);
        SmsBodyRiskService.access$setMRetryCount$p(r5, r0 + 1);
        if (r0 >= 10) goto L7;
        Handler r6 = new Handler();
        final SmsBodyRiskService r3 = this.this$0;
        r6.postDelayed(new SmsBodyRiskService$mServiceConnection$1$$ExternalSyntheticLambda0(r3), 1000);
        return;
    L7:
        OLog.e("app.numberassistant.NumberAssistantProxy.TAG", "Bind sms risk service failed, retry count: " + SmsBodyRiskService.access$getMRetryCount$p(this.this$0));
        return;
    }

    private static final void onServiceDisconnected$lambda$0(SmsBodyRiskService r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        SmsBodyRiskService.access$bindInternal(r1);
    }
}
