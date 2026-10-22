package com.obric.securitycenter.nodisturb.service;

import android.app.Service;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.text.TextUtils;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.olog.OLog;
import com.obric.security.nodisturbapi.SmsData;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import com.obric.securitycenter.nodisturb.manager.PhoneSmsBlockVerifier;
import java.util.GregorianCalendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CallSmsInterceptService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0007J4\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J(\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0015R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/securitycenter/nodisturb/service/CallSmsInterceptService;", "Landroid/app/Service;", "()V", "mInterface", "com/obric/securitycenter/nodisturb/service/CallSmsInterceptService$mInterface$1", "Lcom/obric/securitycenter/nodisturb/service/CallSmsInterceptService$mInterface$1;", "phoneSmsBlockVerifier", "Lcom/obric/securitycenter/nodisturb/manager/PhoneSmsBlockVerifier;", "extractContentValues", "Landroid/content/ContentValues;", "smsData", "Lcom/obric/security/nodisturbapi/SmsData;", "getBlockVerifier", "insertBlockedCallLogFromOtherApp", "", "context", "Landroid/content/Context;", AccountConst.KEY_PHONE_NUMBER, "", "blackListId", "interceptType", "", "slotId", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onDestroy", "", "storeMessage", "Landroid/net/Uri;", "type", "blackId", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CallSmsInterceptService extends Service {
    private final CallSmsInterceptService$mInterface$1 mInterface;
    private volatile PhoneSmsBlockVerifier phoneSmsBlockVerifier;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.securitycenter.nodisturb.service.CallSmsInterceptService$mInterface$1] */
    public CallSmsInterceptService() {
        this.mInterface = new CallSmsInterceptService$mInterface$1(this);
    }

    public final PhoneSmsBlockVerifier getBlockVerifier() {
        PhoneSmsBlockVerifier r0 = this.phoneSmsBlockVerifier;
        if (r0 != null) goto L13;
        monitor-enter(this);
        r0 = this.phoneSmsBlockVerifier;     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        r0 = CallSmsInterceptProvider.Companion.createPhoneSmsBlockVerifier(this);     // Catch: Throwable -> L10
        this.phoneSmsBlockVerifier = r0;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
    L10:
        th = move-exception;
        throw th;
    L13:
        return r0;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r3) {
        OLog.d("CallSmsInterceptService", "onBind: " + this.mInterface);
        return (IBinder) this.mInterface;
    }

    public static /* synthetic */ long insertBlockedCallLogFromOtherApp$default(CallSmsInterceptService r7, Context r8, String r9, long r10, int r12, int r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r10 = -1;
    L5:
        long r3 = r10;
        if ((r14 & 8) == 0) goto L8;
        r12 = 1;
    L8:
        int r5 = r12;
        if ((r14 & 16) == 0) goto L12;
        r13 = -1;
    L12:
        return r7.insertBlockedCallLogFromOtherApp(r8, r9, r3, r5, r13);
    }

    public final long insertBlockedCallLogFromOtherApp(Context r7, String r8, long r9, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, AccountConst.KEY_PHONE_NUMBER);
        OLog.d("InsertCallLog", "insertBlockedCallLogFromOtherApp start: interceptType=" + r11 + ", slotId=" + r12 + ", numberLen=" + r8.length());
        long r2 = -1;
        if (StringsKt.isBlank(r8) == false) goto L5;
        return -1;
    L5:
        ContentResolver r10 = r7.getApplicationContext().getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r10, "context.applicationContext.contentResolver");
        ContentValues r0 = new ContentValues();
        r0.put(ProviderConstants.BlockedCallLog.BCL_PHONE_NUMBER, r8);
        r0.put("bcl_datetime", Long.valueOf(System.currentTimeMillis()));
        r0.put(ProviderConstants.BlockedCallLog.BCL_BLACK_LIST_ID, Long.valueOf(r9));
        r0.put("bcl_intercept_type", Integer.valueOf(r11));
        r0.put("bcl_slot_id", Integer.valueOf(r12));
        Uri r13 = r10.insert(ProviderConstants.INSTANCE.getBLOCKED_CALL_LOG_URI(), r0);     // Catch: Exception -> L11
        if (r13 == null) goto L9;
        long r14 = ContentUris.parseId(r13);     // Catch: Exception -> L11
        OLog.d("InsertCallLog", "insertBlockedCallLogFromOtherApp success, id=" + r14);     // Catch: Exception -> L11
        r2 = r14;
    L14:
    L13:
        return r2;
    L9:
        OLog.w("InsertCallLog", "insertBlockedCallLogFromOtherApp failed, uri is null");     // Catch: Exception -> L11
    L11:
        e = move-exception;
        OLog.e("InsertCallLog", "插入拦截记录异常", e);
        goto L13
    }

    public final Uri storeMessage(Context r5, SmsData r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "smsData");
        if (r8 == (-1)) goto L5;
        boolean r1 = true;
    L6:
        OLog.d("_CallSmsIntercept", "storeMessage start: type=" + r7 + ", hasBlackId=" + r1);
        ContentValues r4 = extractContentValues(r6);
        r4.put(ProviderConstants.Sms.BODY, r6.body);
        if (TextUtils.isEmpty(r4.getAsString(ProviderConstants.Sms.ADDRESS)) == false) goto L9;
        r4.put(ProviderConstants.Sms.ADDRESS, "");
    L9:
        r4.put("bsl_type", Integer.valueOf(r7));
        if (r8 == (-1)) goto L12;
        OLog.d("_CallSmsIntercept", "storeMessage: blackId = " + r8);
        r4.put("bsl_bl_id", Integer.valueOf(r8));
    L12:
        Uri r9 = r5.getContentResolver().insert(Uri.parse("content://bytedance_spam_sms/inbox"), r4);
        if (r9 != null) goto L15;
        OLog.w("_CallSmsIntercept", "storeMessage insert returned null uri");
    L16:
        return r9;
    L15:
        OLog.d("_CallSmsIntercept", "storeMessage success uri=" + r9);
        goto L16
    L5:
        r1 = false;
        goto L6
    }

    public final ContentValues extractContentValues(SmsData r5) {
        Intrinsics.checkNotNullParameter(r5, "smsData");
        ContentValues r4 = new ContentValues();
        r4.put(ProviderConstants.Sms.ADDRESS, r5.address);
        new GregorianCalendar(2011, 8, 18);
        GregorianCalendar r0 = new GregorianCalendar();
        long r1 = System.currentTimeMillis();
        r0.setTimeInMillis(r1);
        r4.put(ProviderConstants.Sms.DATE, Long.valueOf(r1));
        r4.put(ProviderConstants.Sms.DATE_SENT, Long.valueOf(r5.dateSent));
        r4.put(ProviderConstants.Sms.PROTOCOL, Integer.valueOf(r5.protocolType));
        r4.put(ProviderConstants.Sms.READ, 0);
        r4.put(ProviderConstants.Sms.SEEN, 0);
        r4.put(ProviderConstants.Sms.SUBSCRIPTION_ID, Integer.valueOf(r5.subId));
        r4.put(ProviderConstants.Sms.REPLY_PATH_PRESENT, Integer.valueOf(r5.replyPathPresent));
        r4.put(ProviderConstants.Sms.SERVICE_CENTER, r5.serviceCenter);
        return r4;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        PhoneSmsBlockVerifier r1 = this.phoneSmsBlockVerifier;
        if (r1 == null) goto L5;
        r1.onDestroy();
    L5:
        OLog.d("CallSmsInterceptService", "onDestroy");
    }
}
