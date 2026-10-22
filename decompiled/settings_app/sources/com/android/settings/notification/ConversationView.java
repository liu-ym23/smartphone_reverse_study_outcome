package com.android.settings.notification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/android/settings/notification/ConversationView;", "Lcom/android/settings/notification/IConversationView;", "()V", "createToParent", "Landroid/view/View;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ConversationView implements IConversationView {
    public ConversationView() {
    }

    @Override // com.android.settings.notification.IConversationView
    public View createToParent(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r2 = LayoutInflater.from(r3).inflate(R.layout.item_conversation, r4, false);
        r4.addView(r2, new ViewGroup.LayoutParams(-1, -1));
        Intrinsics.checkNotNull(r2);
        r4.setTag(new ConversationItemController(r3, r2));
        return r2;
    }
}
