package com.android.settings.accounts;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Process;
import android.os.UserHandle;
import android.view.View;
import android.widget.CompoundButton;
import com.android.settings.R;
import com.android.settingslib.drawer.EntriesProvider;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccountAutoSyncItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001b\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0007R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcom/android/settings/accounts/AccountAutoSyncController;", "", "context", "Landroid/content/Context;", "userHandle", "Landroid/os/UserHandle;", "isManagedProfile", "", "(Landroid/content/Context;Landroid/os/UserHandle;Z)V", "card", "Lcom/obric/oui/lisitem/OCardListItem;", "getCard", "()Lcom/obric/oui/lisitem/OCardListItem;", "card$delegate", "Lkotlin/Lazy;", "getContext", "()Landroid/content/Context;", "()Z", "listener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "switch", "Lcom/obric/oui/oswitch/OSwitch;", "getSwitch", "()Lcom/obric/oui/oswitch/OSwitch;", "switch$delegate", "getUserHandle", "()Landroid/os/UserHandle;", "isSyncAutomaticallyAsUser", "setSwitchChecked", "", "checked", "showModifyDialog", EntriesProvider.METHOD_IS_CHECKED, "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AccountAutoSyncController {
    private final Lazy card$delegate;
    private final Context context;
    private final boolean isManagedProfile;
    private final CompoundButton.OnCheckedChangeListener listener;
    private final Lazy switch$delegate;
    private final UserHandle userHandle;

    /* JADX INFO: renamed from: $r8$lambda$nbvtpO089dxb_P-BQvEgvjCY8B8, reason: not valid java name */
    public static /* synthetic */ void m268$r8$lambda$nbvtpO089dxb_PBQvEgvjCY8B8(AccountAutoSyncController r0, View r1) {
        _init_$lambda$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$sGB0qTsSNkxucQjYywtwp7ik56I(AccountAutoSyncController r0, CompoundButton r1, boolean r2) {
        listener$lambda$0(r0, r1, r2);
    }

    public AccountAutoSyncController(Context r2, UserHandle r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "userHandle");
        this.context = r2;
        this.userHandle = r3;
        this.isManagedProfile = r4;
        CompoundButton.OnCheckedChangeListener r5 = new AccountAutoSyncController$$ExternalSyntheticLambda0(this);
        this.listener = r5;
        this.card$delegate = LazyKt.lazy(new AccountAutoSyncController$card$2(this));
        this.switch$delegate = LazyKt.lazy(new AccountAutoSyncController$switch$2(this));
        getCard().showTitle(true);
        getCard().showSubTitle(true);
        getCard().setDefaultCustomEndView(1);
        setSwitchChecked(isSyncAutomaticallyAsUser());
        getSwitch().setOnCheckedChangeListener(r5);
        getCard().setOnContentClickListener(new AccountAutoSyncController$$ExternalSyntheticLambda1(this));
    }

    public static final /* synthetic */ void access$setSwitchChecked(AccountAutoSyncController r0, boolean r1) {
        r0.setSwitchChecked(r1);
    }

    public final Context getContext() {
        return this.context;
    }

    public /* synthetic */ AccountAutoSyncController(Context r1, UserHandle r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = Process.myUserHandle();
        Intrinsics.checkNotNullExpressionValue(r2, "myUserHandle(...)");
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = false;
    L8:
        this(r1, r2, r3);
    }

    public final UserHandle getUserHandle() {
        return this.userHandle;
    }

    public final boolean isManagedProfile() {
        return this.isManagedProfile;
    }

    private static final void listener$lambda$0(AccountAutoSyncController r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "<anonymous parameter 0>");
        r1.showModifyDialog(r3);
    }

    public final OCardListItem getCard() {
        return (OCardListItem) this.card$delegate.getValue();
    }

    public final OSwitch getSwitch() {
        return (OSwitch) this.switch$delegate.getValue();
    }

    private static final void _init_$lambda$1(AccountAutoSyncController r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.showModifyDialog(!r0.getSwitch().isChecked());
    }

    public final boolean isSyncAutomaticallyAsUser() {
        return ContentResolver.getMasterSyncAutomaticallyAsUser(this.userHandle.getIdentifier());
    }

    public final void showModifyDialog(final boolean r4) {
        if (r4 != isSyncAutomaticallyAsUser()) goto L5;
        return;
    L5:
        setSwitchChecked(!r4);
        OAlertDialogBuilder r0 = new OAlertDialogBuilder(this.context);
        if (r4 == false) goto L8;
        r0.title(R.string.data_usage_auto_sync_on_dialog_title).message(R.string.data_usage_auto_sync_on_dialog);
    L9:
        r0.horizontalButton(true).positiveButton(android.R.string.ok, new AnonymousClass1(r4, this)).negativeButton(android.R.string.cancel, AnonymousClass2.INSTANCE);
        r0.show();
        return;
    L8:
        r0.title(R.string.data_usage_auto_sync_off_dialog_title).message(R.string.data_usage_auto_sync_off_dialog);
        goto L9
    }

    private final void setSwitchChecked(boolean r3) {
        getSwitch().setOnCheckedChangeListener(null);
        getSwitch().setChecked(r3);
        getSwitch().setOnCheckedChangeListener(this.listener);
    }
}
