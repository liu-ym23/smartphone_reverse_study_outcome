package com.bytedance.blockframework.framework.event;

import android.view.View;
import com.bytedance.blockframework.interaction.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AllBlockViewCreatedEvent.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/blockframework/framework/event/AllBlockViewCreatedEvent;", "Lcom/bytedance/blockframework/interaction/Event;", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "getRootView", "()Landroid/view/View;", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AllBlockViewCreatedEvent extends Event {
    private final View rootView;

    public AllBlockViewCreatedEvent(View r4) {
        Intrinsics.checkNotNullParameter(r4, "rootView");
        super(false, 1, null);
        this.rootView = r4;
    }

    public final View getRootView() {
        return this.rootView;
    }
}
