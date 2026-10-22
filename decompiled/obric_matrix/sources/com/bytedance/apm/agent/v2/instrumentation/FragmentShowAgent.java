package com.bytedance.apm.agent.v2.instrumentation;

import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.o.a.b;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class FragmentShowAgent {
    private static final String TAG = "FragmentShowAgent";

    public FragmentShowAgent() {
    }

    @Keep
    public static void onHiddenChanged(Fragment r0, boolean r1) {
        b.a(r0, !r1);
    }

    @Keep
    public static void onPause(Fragment r1) {
        if (r1.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r1.isHidden() == true) goto L9;
        b.a(r1, false);
        return;
    }

    @Keep
    public static void onResume(Fragment r1) {
        if (r1.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r1.isHidden() == true) goto L9;
        b.a(r1, true);
        return;
    }

    @Keep
    public static void setUserVisibleHint(Fragment r1, boolean r2) {
        if (r1.isResumed() == true) goto L5;
        return;
    L5:
        if (r1.isHidden() == true) goto L9;
        b.a(r1, r2);
        return;
    }
}
