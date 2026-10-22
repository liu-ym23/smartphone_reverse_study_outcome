package com.obric.slot;

import android.content.Context;
import android.view.View;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.security.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Slot.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/obric/slot/Slot;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "bindView", "", "view", "Landroid/view/View;", "createView", "onDestroy", "onPositioned", Utils.INTENT_KEY_INDEX, "", PerfConsts.PERF_DISK_TOTAL, "slot_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class Slot {
    private final Context context;

    public void bindView(View r1) {
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    public abstract View createView();

    public void onDestroy(View r1) {
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    public void onPositioned(View r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    public Slot(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
    }

    protected final Context getContext() {
        return this.context;
    }
}
