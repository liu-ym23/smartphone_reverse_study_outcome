package com.obric.oui.textswitcher;

import android.os.Handler;
import com.obric.oui.common.util.ToolsExtKt;
import java.util.ArrayList;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: OTextSwitcher.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/oui/textswitcher/OTextSwitcher$startAfterBuild$timerTask$1", "Ljava/util/TimerTask;", "run", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTextSwitcher$startAfterBuild$timerTask$1 extends TimerTask {
    final /* synthetic */ ArrayList<String> $dataArrayList;
    final /* synthetic */ Ref.IntRef $index;
    final /* synthetic */ OTextSwitcher this$0;

    public static /* synthetic */ void $r8$lambda$4tTLPI_BDDhL6Xgf3WVx898q9rE(ArrayList r0, Ref.IntRef r1, OTextSwitcher r2) {
        m1418run$lambda2(r0, r1, r2);
    }

    OTextSwitcher$startAfterBuild$timerTask$1(OTextSwitcher r1, ArrayList<String> r2, Ref.IntRef r3) {
        this.this$0 = r1;
        this.$dataArrayList = r2;
        this.$index = r3;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Handler r0 = OTextSwitcher.access$getMUiHander(this.this$0);
        final ArrayList<String> r1 = this.$dataArrayList;
        final Ref.IntRef r2 = this.$index;
        final OTextSwitcher r4 = this.this$0;
        r0.post(new OTextSwitcher$startAfterBuild$timerTask$1$$ExternalSyntheticLambda0(r1, r2, r4));
    }

    /* JADX INFO: renamed from: run$lambda-2, reason: not valid java name */
    private static final void m1418run$lambda2(ArrayList r2, Ref.IntRef r3, OTextSwitcher r4) {
        Intrinsics.checkNotNullParameter(r3, "$index");
        Intrinsics.checkNotNullParameter(r4, "this$0");
        int r0 = r2.size();     // Catch: Exception -> L11
        if (r0 > 0) goto L7;
        return;
    L7:
        if (r3.element <= r0) goto L9;
        r3.element %= r0;     // Catch: Exception -> L11
    L9:
        Object r5 = r2.get(r3.element);     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r5, "dataArrayList[index]");     // Catch: Exception -> L11
        OTextSwitcher.access$safeUpdateText(r4, (String) r5);     // Catch: Exception -> L11
        r3.element = (r3.element + 1) % r0;     // Catch: Exception -> L11
        Unit r6 = Unit.INSTANCE;     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        ToolsExtKt.printLog(Intrinsics.stringPlus("Try exception occur ", e.getMessage()));
        Unit r7 = Unit.INSTANCE;
    }
}
