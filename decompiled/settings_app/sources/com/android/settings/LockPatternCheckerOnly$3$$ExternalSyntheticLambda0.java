package com.android.settings;

import com.android.internal.widget.LockPatternChecker;
import com.android.internal.widget.LockPatternUtils;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class LockPatternCheckerOnly$3$$ExternalSyntheticLambda0 implements LockPatternUtils.CheckCredentialProgressCallback {
    public final /* synthetic */ LockPatternChecker.OnCheckCallback f$0;

    public /* synthetic */ LockPatternCheckerOnly$3$$ExternalSyntheticLambda0(LockPatternChecker.OnCheckCallback r1) {
        this.f$0 = r1;
    }

    public final void onEarlyMatched() {
        this.f$0.onEarlyMatched();
    }
}
