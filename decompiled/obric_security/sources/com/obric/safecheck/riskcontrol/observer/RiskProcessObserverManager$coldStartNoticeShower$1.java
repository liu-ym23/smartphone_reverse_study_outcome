package com.obric.safecheck.riskcontrol.observer;

import android.content.Context;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RiskProcessObserverManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0015\u0010\u0007\u001a\u00110\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0015\u0010\n\u001a\u00110\u000b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f¢\u0006\u0002\b\r"}, d2 = {"<anonymous>", "", "p1", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "p2", "", ApkVirusCheckProvider.KEY_PKG, "p3", "", AccountInfoBundleKey.USER_ID, "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class RiskProcessObserverManager$coldStartNoticeShower$1 extends FunctionReferenceImpl implements Function3<Context, String, Integer, Unit> {
    RiskProcessObserverManager$coldStartNoticeShower$1(RiskProcessObserverManager r8) {
        super(3, r8, RiskProcessObserverManager.class, "showColdStartNoticeDialog", "showColdStartNoticeDialog(Landroid/content/Context;Ljava/lang/String;I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Context r1, String r2, Integer r3) {
        invoke(r1, r2, r3.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Context r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        Intrinsics.checkNotNullParameter(r3, "p2");
        RiskProcessObserverManager.access$showColdStartNoticeDialog((RiskProcessObserverManager) this.receiver, r2, r3, r4);
    }
}
