package com.android.settings.accounts;

import android.content.Context;
import android.os.UserHandle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccountAutoSyncItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/android/settings/accounts/AccountAutoSyncItemView;", "Lcom/android/settings/accounts/IAccountAutoSyncItem;", "()V", "create", "Landroid/view/View;", "context", "Landroid/content/Context;", "userHandle", "Landroid/os/UserHandle;", "isManagedProfile", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AccountAutoSyncItemView implements IAccountAutoSyncItem {
    public AccountAutoSyncItemView() {
    }

    @Override // com.android.settings.accounts.IAccountAutoSyncItem
    public View create(Context r4, UserHandle r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "userHandle");
        View r3 = LayoutInflater.from(r4).inflate(R.layout.item_account_auto_sync_data, null, false);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout r7 = (LinearLayout) r3;
        AccountAutoSyncController r0 = new AccountAutoSyncController(r4, r5, r6);
        OCardListItem r8 = r0.getCard();
        r8.setTag(r0);
        r7.addView(r8);
        return r7;
    }
}
