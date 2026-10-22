package com.obric.hook.lancet;

import android.content.Intent;
import android.os.Bundle;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.privacy.GrantUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.This;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: BatchedActivityLancet.kt */
/* JADX INFO: loaded from: classes4.dex */
@TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\"\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¨\u0006\r"}, d2 = {"Lcom/obric/hook/lancet/BatchedActivityLancet;", "", "()V", "onResume", "", "onStop", "startActivityForResult", "intent", "Landroid/content/Intent;", "requestCode", "", "options", "Landroid/os/Bundle;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BatchedActivityLancet {
    public static final BatchedActivityLancet INSTANCE = null;

    static {
        INSTANCE = new BatchedActivityLancet();
    }

    public BatchedActivityLancet() {
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public final void onResume() {
        String r1 = This.get().getClass().getName();
        Origin.callVoid();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r1);
        return;
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public final void startActivityForResult(Intent r1, int r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "intent");
        String r0 = This.get().getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        Origin.callVoid();
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public final void onStop() {
        String r1 = This.get().getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r1);
    L5:
        Origin.callVoid();
    }
}
