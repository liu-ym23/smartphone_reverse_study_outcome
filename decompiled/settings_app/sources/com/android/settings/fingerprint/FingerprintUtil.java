package com.android.settings.fingerprint;

import android.content.Context;
import android.hardware.biometrics.SensorProperties;
import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintSensorProperties;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FingerprintUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/settings/fingerprint/FingerprintUtil;", "", "()V", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FingerprintUtil {
    public static final Companion Companion = null;
    private static final String TAG = "FingerprintUtil";

    /* JADX INFO: compiled from: FingerprintUtil.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/settings/fingerprint/FingerprintUtil$Companion;", "", "()V", "TAG", "", "getFingerprintList", "", "Landroid/hardware/fingerprint/Fingerprint;", "fm", "Landroid/hardware/fingerprint/FingerprintManager;", "sensorType", "", "hasFingerprint", "", "context", "Landroid/content/Context;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final boolean hasFingerprint(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
            Companion r2 = this;     // Catch: Throwable -> L11
            List<Fingerprint> r4 = getFingerprintList((FingerprintManager) r3.getSystemService("fingerprint"), 4);     // Catch: Throwable -> L11
            if (r4 == null) goto L7;
            int r5 = r4.size();     // Catch: Throwable -> L11
        L8:
            if (r5 <= 0) goto L18;
            return true;
        L18:
            return false;
        L7:
            r5 = 0;
        L11:
            th = move-exception;
            Result.Companion r6 = Result.Companion;
            Throwable r7 = Result.m1511exceptionOrNullimpl(Result.m1508constructorimpl(ResultKt.createFailure(th)));
            if (r7 == null) goto L15;
            OLog.e(FingerprintUtil.TAG, "hasFingerprint error:" + r7.getMessage());
        L15:
            return false;
        }

        private final List<Fingerprint> getFingerprintList(FingerprintManager r8, int r9) {
            if (r8 != null) goto L33;
            return null;
        L33:
            List<Fingerprint> r0 = r8.getEnrolledFingerprints();     // Catch: Exception -> L30
            if (r9 != 0) goto L8;
            return r0;
        L8:
            List r10 = r8.getSensorProperties();     // Catch: Exception -> L30
            Intrinsics.checkNotNullExpressionValue(r10, "getSensorProperties(...)");     // Catch: Exception -> L30
            Iterator r11 = r10.iterator();     // Catch: Exception -> L30
            int r2 = -1;
        L10:
            if (r11.hasNext() == false) goto L16;
            FingerprintSensorProperties r3 = (SensorProperties) r11.next();     // Catch: Exception -> L30
            if ((r3 instanceof FingerprintSensorProperties) == false) goto L10;
            if (r3.getSensorType() != r9) goto L10;
            r2 = r3.getSensorId();     // Catch: Exception -> L30
            goto L10
        L16:
            if (r2 == (-1)) goto L32;
            if (r0 == null) goto L47;
            ArrayList r12 = new ArrayList();     // Catch: Exception -> L30
            Iterator<T> r13 = r0.iterator();     // Catch: Exception -> L30
        L20:
            if (r13.hasNext() == false) goto L27;
            Object r1 = r13.next();     // Catch: Exception -> L30
            if (((Fingerprint) r1).getDeviceId() != r2) goto L24;
            boolean r4 = true;
        L25:
            if (r4 == false) goto L20;
            r12.add(r1);     // Catch: Exception -> L30
            goto L20
        L24:
            r4 = false;
            goto L25
        L27:
            return r12;
        L47:
            return null;
        L32:
            return null;
        L30:
            e = move-exception;
            OLog.e(FingerprintUtil.TAG, "getFingerprintList", e);
            goto L32
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FingerprintUtil() {
    }
}
