package com.obric.oui.window.permission;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PrivacyStatementActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/oui/window/permission/PrivacyStatementActivity$reportPrivacySheetFirstFrame$listener$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrivacyStatementActivity$reportPrivacySheetFirstFrame$listener$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ View $targetView;
    final /* synthetic */ PrivacyStatementActivity this$0;

    public static /* synthetic */ void $r8$lambda$B2NnpMCn4FnS3EUQPZyene5MIo4(PrivacyStatementActivity r0) {
        m1461onPreDraw$lambda0(r0);
    }

    PrivacyStatementActivity$reportPrivacySheetFirstFrame$listener$1(PrivacyStatementActivity r1, View r2) {
        this.this$0 = r1;
        this.$targetView = r2;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        PrivacyStatementActivity.access$removeFirstFramePreDrawListener(this.this$0);
        if (PrivacyStatementActivity.access$getFirstFrameReported$p(this.this$0) == false) goto L5;
        return true;
    L5:
        PrivacyStatementActivity.access$setFirstFrameReported$p(this.this$0, true);
        View r0 = this.$targetView;
        final PrivacyStatementActivity r3 = this.this$0;
        r0.post(new PrivacyStatementActivity$reportPrivacySheetFirstFrame$listener$1$$ExternalSyntheticLambda0(r3));
        return true;
    }

    /* JADX INFO: renamed from: onPreDraw$lambda-0, reason: not valid java name */
    private static final void m1461onPreDraw$lambda0(PrivacyStatementActivity r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        PrivacyStatementActivity.access$logPrivacySheetFirstFrame(r1);
    }
}
