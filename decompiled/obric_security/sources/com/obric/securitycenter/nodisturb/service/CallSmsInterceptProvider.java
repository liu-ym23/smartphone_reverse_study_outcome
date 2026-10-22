package com.obric.securitycenter.nodisturb.service;

import android.content.Context;
import com.obric.securitycenter.nodisturb.checker.CnSmsBlockChecker;
import com.obric.securitycenter.nodisturb.checker.DefaultCallBlockChecker;
import com.obric.securitycenter.nodisturb.manager.DefaultPhoneSmsBlockVerifier;
import com.obric.securitycenter.nodisturb.manager.PhoneSmsBlockVerifier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallSmsInterceptProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/securitycenter/nodisturb/service/CallSmsInterceptProvider;", "", "()V", "Companion", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CallSmsInterceptProvider {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: CallSmsInterceptProvider.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/securitycenter/nodisturb/service/CallSmsInterceptProvider$Companion;", "", "()V", "createPhoneSmsBlockVerifier", "Lcom/obric/securitycenter/nodisturb/manager/PhoneSmsBlockVerifier;", "context", "Landroid/content/Context;", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final PhoneSmsBlockVerifier createPhoneSmsBlockVerifier(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return new DefaultPhoneSmsBlockVerifier(new DefaultCallBlockChecker(r3), new CnSmsBlockChecker(r3));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CallSmsInterceptProvider() {
    }
}
