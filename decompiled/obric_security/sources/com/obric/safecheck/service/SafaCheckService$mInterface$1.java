package com.obric.safecheck.service;

import android.os.Bundle;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.olog.OLog;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.security.safecheckapi.ApkInfo;
import com.obric.security.safecheckapi.ISecurityCheckCallback;
import com.obric.security.safecheckapi.ISecurityCheckService;
import com.obric.security.safecheckapi.SecurityConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: SafaCheckService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J,\u0010\u000b\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\u0010\u001a\u00020\u00032\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J,\u0010\u0012\u001a\u00020\u00032\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0013"}, d2 = {"com/obric/safecheck/service/SafaCheckService$mInterface$1", "Lcom/obric/security/safecheckapi/ISecurityCheckService$Stub;", ApkVirusCheckProvider.METHOD_CHECK_APK, "", "apkPath", "", "callback", "Lcom/obric/security/safecheckapi/ISecurityCheckCallback;", "checkApkWithInfo", "apkInfo", "Lcom/obric/security/safecheckapi/ApkInfo;", "checkPhoneWithExtra", AccountConst.KEY_PHONE_NUMBER, "", WsConstants.KEY_EXTRA, "Landroid/os/Bundle;", "checkUrl", "urls", "checkUrlWithExtra", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SafaCheckService$mInterface$1 extends ISecurityCheckService.Stub {
    final /* synthetic */ SafaCheckService this$0;

    SafaCheckService$mInterface$1(SafaCheckService r1) {
        this.this$0 = r1;
    }

    @Override // com.obric.security.safecheckapi.ISecurityCheckService
    public void checkApk(final String r3, final ISecurityCheckCallback r4) {
        OLog.d("SafaCheckService", ApkVirusCheckProvider.METHOD_CHECK_APK);
        this.this$0.checkDateBase(true);
        this.this$0.getExecutorService().execute(new SafaCheckService$mInterface$1$checkApk$1(this, r3, r4));
    }

    @Override // com.obric.security.safecheckapi.ISecurityCheckService
    public void checkApkWithInfo(final ApkInfo r3, final ISecurityCheckCallback r4) {
        OLog.d("SafaCheckService", "checkApkWithInfo：" + r4);
        this.this$0.checkDateBase(true);
        this.this$0.getExecutorService().execute(new SafaCheckService$mInterface$1$checkApkWithInfo$1(this, r3, r4));
    }

    @Override // com.obric.security.safecheckapi.ISecurityCheckService
    public void checkUrl(final List<String> r3, final ISecurityCheckCallback r4) {
        OLog.d("SafaCheckService", "checkUrl：" + r4);
        this.this$0.checkDateBase(true);
        this.this$0.getExecutorService().execute(new SafaCheckService$mInterface$1$checkUrl$1(this, r3, r4));
    }

    @Override // com.obric.security.safecheckapi.ISecurityCheckService
    public void checkUrlWithExtra(final List<String> r2, Bundle r3, final ISecurityCheckCallback r4) {
        OLog.d("SafaCheckService", "checkUrlWithExtra：callback" + r4);
        this.this$0.checkDateBase(true);
        this.this$0.getExecutorService().execute(new SafaCheckService$mInterface$1$checkUrlWithExtra$1(this, r2, r4));
    }

    @Override // com.obric.security.safecheckapi.ISecurityCheckService
    public void checkPhoneWithExtra(final List<String> r4, Bundle r5, final ISecurityCheckCallback r6) {
        OLog.d("SafaCheckService", "checkPhoneWithExtra");
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        boolean r1 = false;
        r0.element = false;
        if (r5 != null) goto L5;
    L8:
        this.this$0.checkDateBase(r0.element);
        this.this$0.getExecutorService().execute(new SafaCheckService$mInterface$1$checkPhoneWithExtra$1(this, r4, r0, r6));
        return;
    L5:
        if (r5.getInt(SecurityConst.EXTRA_KEY_ANTI_FRAUD_DETECTION_HIT, 0) != 1) goto L7;
        r1 = true;
    L7:
        r0.element = r1;
        goto L8
    }
}
