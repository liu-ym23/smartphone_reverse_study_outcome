package obric.common.security.attestation;

import com.android.settings.SettingsApplication;
import com.bytedance.privacy.PrivacySdk;
import com.bytedance.privacy.attestation.AttestationConfig;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.common.security.ssl.BDKeyManagerRef;

/* JADX INFO: compiled from: PrivacySDKUtils.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lobric/common/security/attestation/PrivacySDKUtils;", "", "()V", "buildAttestationConfig", "Lcom/bytedance/privacy/attestation/AttestationConfig;", "info", "", "getIDAttestation", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PrivacySDKUtils {
    public static final Companion Companion = null;
    private static final String TAG = "PrivacySDKUtils";
    private static volatile PrivacySDKUtils instance;

    /* JADX INFO: compiled from: PrivacySDKUtils.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lobric/common/security/attestation/PrivacySDKUtils$Companion;", "", "()V", "TAG", "", "instance", "Lobric/common/security/attestation/PrivacySDKUtils;", "getInstance", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final PrivacySDKUtils getInstance() {
            PrivacySDKUtils r0 = PrivacySDKUtils.access$getInstance$cp();
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = PrivacySDKUtils.access$getInstance$cp();     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            r0 = new PrivacySDKUtils(null);     // Catch: Throwable -> L10
            Companion r1 = PrivacySDKUtils.Companion;     // Catch: Throwable -> L10
            PrivacySDKUtils.access$setInstance$cp(r0);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ PrivacySDKUtils(DefaultConstructorMarker r1) {
        this();
    }

    private PrivacySDKUtils() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        PrivacySdk.init(new AccountBridge(), new EnvBridge());     // Catch: Throwable -> L5
        Object r3 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r4 = Result.m1511exceptionOrNullimpl(r3);
        if (r4 == null) goto L13;
        OLog.e(TAG, "init privacy sdk failed", r4);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r3 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final /* synthetic */ PrivacySDKUtils access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ void access$setInstance$cp(PrivacySDKUtils r0) {
        instance = r0;
    }

    public final String getIDAttestation(String r5) {
        Intrinsics.checkNotNullParameter(r5, "info");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        PrivacySDKUtils r2 = this;     // Catch: Throwable -> L9
        AttestationConfig r4 = buildAttestationConfig(r5);     // Catch: Throwable -> L9
        if (r4 != null) goto L6;
        String r6 = null;
    L7:
        Object r7 = Result.m1508constructorimpl(r6);     // Catch: Throwable -> L9
    L11:
        Throwable r8 = Result.m1511exceptionOrNullimpl(r7);
        if (r8 == null) goto L15;
        OLog.e(TAG, "get id attestation failed", r8);
    L15:
        if (Result.m1514isFailureimpl(r7) == true) goto L19;
        r0 = r7;
    L19:
        return (String) r0;
    L6:
        r6 = PrivacySdk.getIdAttestationManager().getIDAttestationString(SettingsApplication.getContext(), "ocean_os_api", BDKeyManagerRef.TLS_PRO_PKEY, r4);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final AttestationConfig buildAttestationConfig(String r3) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L4
        Object r4 = Result.m1508constructorimpl(new AttestationConfig.Builder().customInfo(r3).requestDeviceHealthStatus().build());     // Catch: Throwable -> L4
    L6:
        Throwable r5 = Result.m1511exceptionOrNullimpl(r4);
        if (r5 == null) goto L10;
        OLog.e(TAG, "build attestation config failed", r5);
    L10:
        if (Result.m1514isFailureimpl(r4) == false) goto L13;
        r4 = null;
    L13:
        return (AttestationConfig) r4;
    L4:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L6
    }
}
