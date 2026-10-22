package com.obric.baseservice.privacy;

import android.content.Context;
import com.bytedance.privacy.PrivacySdk;
import com.bytedance.privacy.attestation.AttestationConfig;
import com.bytedance.privacy.exception.BdPrivacyException;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.olog.OLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: PrivacySdkManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\"\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0004J\u0016\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0004J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/baseservice/privacy/PrivacySdkManager;", "", "()V", "APP_ID", "", "KEY_ALIAS", "TAG", "initStarted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "buildAttestationConfig", "Lcom/bytedance/privacy/attestation/AttestationConfig;", "customInfo", "requestRpDid", "", "requestRpUid", "buildCustomInfo", "ensureInitialized", "", "context", "Landroid/content/Context;", "getIdAttestationString", "getPseudoDid", "appId", "getPseudoUid", "getSystemDid", "init", "baseservice_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PrivacySdkManager {
    public static final String APP_ID = "ocean_security_center";
    public static final PrivacySdkManager INSTANCE = null;
    private static final String KEY_ALIAS = "gxb_data_attest_key";
    private static final String TAG = "PrivacySdkManager";
    private static final AtomicBoolean initStarted = null;

    static {
        INSTANCE = new PrivacySdkManager();
        initStarted = new AtomicBoolean(false);
    }

    private PrivacySdkManager() {
    }

    public final void init(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (PrivacySdk.isInitialized() == false) goto L7;
        initStarted.set(true);
        return;
    L7:
        if (initStarted.compareAndSet(false, true) == true) goto L17;
        return;
    L17:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        PrivacySdkManager r4 = this;     // Catch: Throwable -> L11
        PrivacyEnvBridge.INSTANCE.init(r5);     // Catch: Throwable -> L11
        PrivacySdk.init(PrivacyAccountBridge.INSTANCE, PrivacyEnvBridge.INSTANCE);     // Catch: Throwable -> L11
        OLog.i(TAG, "PrivacySDK init success");     // Catch: Throwable -> L11
        Object r6 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r7 = Result.m777exceptionOrNullimpl(r6);
        if (r7 == null) goto L19;
        initStarted.set(false);
        OLog.e(TAG, "PrivacySDK init failed", r7);
        return;
    L19:
        return;
    L11:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static /* synthetic */ String getIdAttestationString$default(PrivacySdkManager r0, Context r1, boolean r2, boolean r3, int r4, Object r5) throws BdPrivacyException {
        if ((r4 & 2) == 0) goto L6;
        r2 = true;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = false;
    L9:
        return r0.getIdAttestationString(r1, r2, r3);
    }

    public final String getIdAttestationString(Context r2, boolean r3, boolean r4) throws BdPrivacyException {
        Intrinsics.checkNotNullParameter(r2, "context");
        ensureInitialized(r2);
        AttestationConfig r1 = buildAttestationConfig(buildCustomInfo(), r3, r4);
        String r5 = PrivacySdk.getIdAttestationManager().getIDAttestationString(r2.getApplicationContext(), APP_ID, KEY_ALIAS, r1);
        Intrinsics.checkNotNullExpressionValue(r5, "PrivacySdk.getIdAttestat…PP_ID, KEY_ALIAS, config)");
        return r5;
    }

    public final String getPseudoDid(Context r2, String r3) throws BdPrivacyException {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "appId");
        ensureInitialized(r2);
        String r1 = PrivacySdk.getPseudoManager().getPseudoDID(r2.getApplicationContext(), r3);
        Intrinsics.checkNotNullExpressionValue(r1, "PrivacySdk.getPseudoMana…pplicationContext, appId)");
        return r1;
    }

    public final String getPseudoUid(Context r2, String r3) throws BdPrivacyException {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "appId");
        ensureInitialized(r2);
        String r1 = PrivacySdk.getPseudoManager().getPseudoUID(r2.getApplicationContext(), r3);
        Intrinsics.checkNotNullExpressionValue(r1, "PrivacySdk.getPseudoMana…pplicationContext, appId)");
        return r1;
    }

    private final AttestationConfig buildAttestationConfig(String r1, boolean r2, boolean r3) throws BdPrivacyException {
        AttestationConfig.Builder r0 = new AttestationConfig.Builder();
        if (r2 == false) goto L5;
        r0.requestId(AttestationConfig.IdType.RPDID);
    L5:
        if (r3 == false) goto L7;
        r0.requestId(AttestationConfig.IdType.RPUID);
    L7:
        String r4 = r1;
        if (r4 != null) goto L10;
    L13:
        boolean r5 = true;
    L14:
        if (r5 == true) goto L16;
        r0.customInfo(r1);
    L16:
        AttestationConfig r6 = r0.build();
        Intrinsics.checkNotNullExpressionValue(r6, "builder.build()");
        return r6;
    L10:
        if (r4.length() == 0) goto L13;
        r5 = false;
        goto L14
    }

    private final String buildCustomInfo() {
        String r2 = getSystemDid();
        String r3 = new JSONObject().put("system_did", r2).put("doubao_did", r2).toString();
        Intrinsics.checkNotNullExpressionValue(r3, "JSONObject()\n           …)\n            .toString()");
        return r3;
    }

    private final String getSystemDid() {
        String r0 = MatrixTeaManager.Companion.getInstance().getDeviceId();     // Catch: Throwable -> L7
        if (r0 != null) goto L12;
        return "";
    L12:
        return r0;
    L7:
        th = move-exception;
        OLog.e(TAG, "get system did failed", th);
        return "";
    }

    private final void ensureInitialized(Context r2) throws BdPrivacyException {
        if (PrivacySdk.isInitialized() == true) goto L6;
        init(r2);
    L6:
        if (PrivacySdk.isInitialized() == false) goto L9;
        return;
    L9:
        throw new BdPrivacyException("PrivacySDK is not initialized");
    }
}
