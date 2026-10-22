package com.obric.securitycenter.nodisturb.manager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.RemoteException;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.olog.OLog;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import com.obric.smsparser.risk.ISmsRiskService;
import com.obric.smsparser.risk.SmsRiskQueryParam;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmsBodyRiskService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/securitycenter/nodisturb/manager/SmsBodyRiskService;", "", "()V", ProviderConstants.Sms.BODY, "", "mContext", "Landroid/content/Context;", "mIsUnbindByManual", "", "mMessageRiskListener", "Lcom/obric/securitycenter/nodisturb/manager/SmsBodyRiskService$MessageRiskListener;", "mRetryCount", "", "mServiceConnection", "Landroid/content/ServiceConnection;", "mSmsRiskService", "Lcom/obric/smsparser/risk/ISmsRiskService;", "msgId", "pendingWork", AccountConst.KEY_PHONE_NUMBER, "bindInternal", "checkMessageRisk", "", "listener", "initService", "context", "unbind", "Companion", "MessageRiskListener", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SmsBodyRiskService {
    public static final Companion Companion = null;
    private static final String SERVICE_CLS = "com.obric.smsparser.risk.SmsRiskService";
    private static final String SERVICE_PKG = "com.obric.smsparser";
    private String body;
    private Context mContext;
    private boolean mIsUnbindByManual;
    private MessageRiskListener mMessageRiskListener;
    private int mRetryCount;
    private final ServiceConnection mServiceConnection;
    private ISmsRiskService mSmsRiskService;
    private String msgId;
    private boolean pendingWork;
    private String phoneNumber;

    /* JADX INFO: compiled from: SmsBodyRiskService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/securitycenter/nodisturb/manager/SmsBodyRiskService$Companion;", "", "()V", "SERVICE_CLS", "", "SERVICE_PKG", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: SmsBodyRiskService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/securitycenter/nodisturb/manager/SmsBodyRiskService$MessageRiskListener;", "", "onResult", "", "msgId", "", "riskLevel", "", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface MessageRiskListener {
        void onResult(String r1, int r2);
    }

    static {
        Companion = new Companion(null);
    }

    public SmsBodyRiskService() {
        this.msgId = "";
        this.phoneNumber = "";
        this.body = "";
        this.mServiceConnection = new SmsBodyRiskService$mServiceConnection$1(this);
    }

    public static final /* synthetic */ boolean access$bindInternal(SmsBodyRiskService r0) {
        return r0.bindInternal();
    }

    public static final /* synthetic */ String access$getBody$p(SmsBodyRiskService r0) {
        return r0.body;
    }

    public static final /* synthetic */ boolean access$getMIsUnbindByManual$p(SmsBodyRiskService r0) {
        return r0.mIsUnbindByManual;
    }

    public static final /* synthetic */ MessageRiskListener access$getMMessageRiskListener$p(SmsBodyRiskService r0) {
        return r0.mMessageRiskListener;
    }

    public static final /* synthetic */ int access$getMRetryCount$p(SmsBodyRiskService r0) {
        return r0.mRetryCount;
    }

    public static final /* synthetic */ String access$getMsgId$p(SmsBodyRiskService r0) {
        return r0.msgId;
    }

    public static final /* synthetic */ boolean access$getPendingWork$p(SmsBodyRiskService r0) {
        return r0.pendingWork;
    }

    public static final /* synthetic */ String access$getPhoneNumber$p(SmsBodyRiskService r0) {
        return r0.phoneNumber;
    }

    public static final /* synthetic */ void access$setMMessageRiskListener$p(SmsBodyRiskService r0, MessageRiskListener r1) {
        r0.mMessageRiskListener = r1;
    }

    public static final /* synthetic */ void access$setMRetryCount$p(SmsBodyRiskService r0, int r1) {
        r0.mRetryCount = r1;
    }

    public static final /* synthetic */ void access$setMSmsRiskService$p(SmsBodyRiskService r0, ISmsRiskService r1) {
        r0.mSmsRiskService = r1;
    }

    private final boolean bindInternal() {
        boolean r1 = false;
        if (this.mContext != null) goto L6;
        OLog.w("_CallSmsIntercept", "bindInternal skip: context is null");
        return false;
    L6:
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName(SERVICE_PKG, SERVICE_CLS));
        Context r3 = this.mContext;
        if (r3 == null) goto L9;
        r1 = r3.bindService(r0, this.mServiceConnection, 1);
    L9:
        OLog.d("_CallSmsIntercept", "bindInternal bindService result=" + r1 + ", component=com.obric.smsparser/com.obric.smsparser.risk.SmsRiskService");
        if (r1 == true) goto L12;
        OLog.e("_CallSmsIntercept", "bindService failed, check signature & permission & <queries>");
    L12:
        return r1;
    }

    public final boolean initService(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (this.mSmsRiskService == null) goto L6;
        OLog.d("_CallSmsIntercept", "initService: already bound, reuse service");
        return true;
    L6:
        OLog.d("_CallSmsIntercept", "initService: start binding");
        this.mContext = r3;
        return bindInternal();
    }

    public final void unbind() {
        if (this.mContext == null) goto L5;
        boolean r0 = true;
    L6:
        OLog.d("_CallSmsIntercept", "unbind: manual unbind, bound=" + r0);
        this.mIsUnbindByManual = true;
        this.pendingWork = false;
        Context r1 = this.mContext;
        if (r1 == null) goto L12;
        if (r1 == null) goto L10;
        r1.unbindService(this.mServiceConnection);
    L10:
        this.mContext = null;
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void checkMessageRisk(final String r11, String r12, String r13, MessageRiskListener r14) {
        Intrinsics.checkNotNullParameter(r11, "msgId");
        Intrinsics.checkNotNullParameter(r12, AccountConst.KEY_PHONE_NUMBER);
        Intrinsics.checkNotNullParameter(r13, ProviderConstants.Sms.BODY);
        int r1 = r13.length();
        if (this.mSmsRiskService == null) goto L5;
        boolean r2 = true;
    L6:
        OLog.d("_CallSmsIntercept", "checkMessageRisk: msgId=" + r11 + ", bodyLen=" + r1 + ", serviceBound=" + r2);
        this.mMessageRiskListener = r14;
        if (this.mSmsRiskService != null) goto L10;
        OLog.d("_CallSmsIntercept", "checkMessageRisk: service not connected yet, cache as pending work");
        this.msgId = r11;
        this.phoneNumber = r12;
        this.body = r13;
        this.pendingWork = true;
        return;
    L10:
        if (r14 != null) goto L22;
        OLog.w("_CallSmsIntercept", "checkMessageRisk skip: listener is null");
        return;
    L22:
        this.pendingWork = false;     // Catch: Exception -> L17 RemoteException -> L19
        SmsRiskQueryParam r15 = new SmsRiskQueryParam(r11, r12, r13, System.currentTimeMillis(), new Bundle());     // Catch: Exception -> L17 RemoteException -> L19
        OLog.d("_CallSmsIntercept", "queryRisk: send request, msgId=" + r11);     // Catch: Exception -> L17 RemoteException -> L19
        ISmsRiskService r16 = this.mSmsRiskService;     // Catch: Exception -> L17 RemoteException -> L19
        if (r16 == null) goto L24;
        r16.queryRisk(r15, new AnonymousClass1(this, r11));     // Catch: Exception -> L17 RemoteException -> L19
    L26:
        return;
    L24:
        return;
    L19:
        e = move-exception;
        OLog.e("_CallSmsIntercept", "Error calling queryRisk", e);
        return;
    L17:
        e = move-exception;
        OLog.e("_CallSmsIntercept", "An unexpected error occurred in queryRisk", e);
        return;
    L5:
        r2 = false;
        goto L6
    }
}
