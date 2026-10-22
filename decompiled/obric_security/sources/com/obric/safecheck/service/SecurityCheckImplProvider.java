package com.obric.safecheck.service;

import android.content.Context;
import com.obric.safecheck.service.checker.AntiFraudApkChecker;
import com.obric.safecheck.service.checker.AntiFraudPhoneChecker;
import com.obric.safecheck.service.checker.AntiFraudUrlChecker;
import com.obric.safecheck.service.checker.GxbAntiFraudApkChecker;
import com.obric.safecheck.service.checker.TmsApkVirusChecker;
import com.obric.safecheck.service.checker.TmsSecurityUrlChecker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SecurityCheckImplProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/safecheck/service/SecurityCheckImplProvider;", "", "()V", "Companion", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SecurityCheckImplProvider {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: SecurityCheckImplProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/safecheck/service/SecurityCheckImplProvider$Companion;", "", "()V", "createSecurityCheckHelper", "Lcom/obric/safecheck/service/SecurityCheckHelper;", "context", "Landroid/content/Context;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final SecurityCheckHelper createSecurityCheckHelper(Context r9) {
            Intrinsics.checkNotNullParameter(r9, "context");
            ApkAnalyzer r8 = new ApkAnalyzer(r9);
            return new DefaultSecurityCheckHelper(new AntiFraudApkChecker(r9, r8), new GxbAntiFraudApkChecker(r9, r8), new TmsApkVirusChecker(), new AntiFraudPhoneChecker(r9), new AntiFraudUrlChecker(r9), new TmsSecurityUrlChecker());
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SecurityCheckImplProvider() {
    }
}
