package com.android.settings.notification;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.android.settings.Utils;
import com.obric.oui.lisitem.OCardListItem;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/android/settings/notification/ConversationItemController;", "", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;)V", "itemBubble", "Lcom/obric/oui/lisitem/OCardListItem;", "getItemBubble", "()Lcom/obric/oui/lisitem/OCardListItem;", "itemBubble$delegate", "Lkotlin/Lazy;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ConversationItemController {
    private final Lazy itemBubble$delegate;

    /* JADX INFO: renamed from: $r8$lambda$_NK3-CUiH_dpCv-bxcOXJzdsDMM, reason: not valid java name */
    public static /* synthetic */ void m524$r8$lambda$_NK3CUiH_dpCvbxcOXJzdsDMM(Context r0, View r1) {
        _init_$lambda$0(r0, r1);
    }

    public ConversationItemController(final Context r2, final View r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "view");
        this.itemBubble$delegate = LazyKt.lazy(new ConversationItemController$itemBubble$2(r3));
        getItemBubble().setOnContentClickListener(new ConversationItemController$$ExternalSyntheticLambda0(r2));
    }

    public final OCardListItem getItemBubble() {
        Object r1 = this.itemBubble$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "getValue(...)");
        return (OCardListItem) r1;
    }

    private static final void _init_$lambda$0(Context r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "$context");
        Utils.startActivity(r1, new Intent(r1, AppBubbleNotificationSettingsActivity.class));
    }
}
