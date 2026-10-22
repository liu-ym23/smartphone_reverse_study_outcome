package com.android.settings.specialaccess.premiumsms;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import com.android.settings.NotificationDisplayDetailsActivity;
import com.android.settings.R;
import com.android.settings.accounts.obric.ObricIconUtils;
import com.android.settings.applications.AppStateSmsPremBridge;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.specialaccess.SpecialAccessHeaderAdapter;
import com.android.settings.textboom.db.OcrAppInfoColumn;
import com.android.settingslib.applications.ApplicationsState;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PremiumSmsAccessAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00012B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\fJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000fH\u0002J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0016J\u0018\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001fH\u0016J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001fH\u0016J\u0018\u0010-\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u001fH\u0002J\u0018\u0010/\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020)2\u0006\u0010 \u001a\u00020\u000fH\u0002J \u00100\u001a\u00020\u000b2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010H\u0007J\u0018\u00101\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020)2\u0006\u0010 \u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082D¢\u0006\u0002\n\u0000R4\u0010\u0019\u001a&\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00180\u0018 \u001b*\u0012\u0012\u000e\b\u0001\u0012\n \u001b*\u0004\u0018\u00010\u00180\u00180\u001a0\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/android/settings/specialaccess/premiumsms/PremiumSmsAccessAdapter;", "Lcom/android/settings/specialaccess/SpecialAccessHeaderAdapter;", "activity", "Landroid/app/Activity;", "mSmsBackend", "Lcom/android/settings/applications/AppStateSmsPremBridge;", "pkgMan", "Landroid/content/pm/PackageManager;", NotificationCompat.CATEGORY_CALL, "Lkotlin/Function1;", "Lcom/obric/oui/sectiontitlebar/OSectionSupportiveText;", "", "(Landroid/app/Activity;Lcom/android/settings/applications/AppStateSmsPremBridge;Landroid/content/pm/PackageManager;Lkotlin/jvm/functions/Function1;)V", OcrAppInfoColumn.TABLE_NAME, "Ljava/util/ArrayList;", "Lcom/android/settingslib/applications/ApplicationsState$AppEntry;", "Lkotlin/collections/ArrayList;", "getApps", "()Ljava/util/ArrayList;", "setApps", "(Ljava/util/ArrayList;)V", "mMenuDialog", "Lcom/obric/oui/popover/v2/OPopover;", "status", "", "valueDescs", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "valueUnknown", "getCurrentValue", "", "appInfo", "getCurrentValueDesc", "value", "getItemContentCount", "onBindContentViewHolder", "holder", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "position", "onCreateContentViewHolder", "Lcom/android/settings/specialaccess/premiumsms/PremiumSmsAccessAdapter$PremiumSmsAccessViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onValueChange", "newValue", "prepareMenuDialog", "setData", "showMenuDialog", "PremiumSmsAccessViewHolder", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PremiumSmsAccessAdapter extends SpecialAccessHeaderAdapter {
    private final Activity activity;
    private ArrayList<ApplicationsState.AppEntry> apps;
    private final Function1<OSectionSupportiveText, Unit> call;
    private OPopover mMenuDialog;
    private final AppStateSmsPremBridge mSmsBackend;
    private final PackageManager pkgMan;
    private final String status;
    private final String[] valueDescs;
    private final String valueUnknown;

    /* JADX INFO: compiled from: PremiumSmsAccessAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/android/settings/specialaccess/premiumsms/PremiumSmsAccessAdapter$PremiumSmsAccessViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "olistitem", "Lcom/obric/oui/lisitem/OCardListItem;", "getOlistitem", "()Lcom/obric/oui/lisitem/OCardListItem;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PremiumSmsAccessViewHolder extends RecyclerView.ViewHolder {
        private final OCardListItem olistitem;

        public PremiumSmsAccessViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            View r3 = this.itemView.findViewById(R.id.card_list_item);
            Intrinsics.checkNotNull(r3);
            this.olistitem = (OCardListItem) r3;
        }

        public final OCardListItem getOlistitem() {
            return this.olistitem;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$BG9t9DX5ag8w0SrlQ2EyhEV-HxA, reason: not valid java name */
    public static /* synthetic */ void m617$r8$lambda$BG9t9DX5ag8w0SrlQ2EyhEVHxA(PremiumSmsAccessAdapter r0, RecyclerView.ViewHolder r1, ApplicationsState.AppEntry r2, View r3) {
        onBindContentViewHolder$lambda$1$lambda$0(r0, r1, r2, r3);
    }

    public static final /* synthetic */ OPopover access$getMMenuDialog$p(PremiumSmsAccessAdapter r0) {
        return r0.mMenuDialog;
    }

    public static final /* synthetic */ String[] access$getValueDescs$p(PremiumSmsAccessAdapter r0) {
        return r0.valueDescs;
    }

    public static final /* synthetic */ void access$onValueChange(PremiumSmsAccessAdapter r0, ApplicationsState.AppEntry r1, int r2) {
        r0.onValueChange(r1, r2);
    }

    public static final /* synthetic */ void access$setMMenuDialog$p(PremiumSmsAccessAdapter r0, OPopover r1) {
        r0.mMenuDialog = r1;
    }

    @Override // com.android.settings.specialaccess.HeaderBaseAdapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup r1, int r2) {
        return onCreateContentViewHolder(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PremiumSmsAccessAdapter(Activity r2, AppStateSmsPremBridge r3, PackageManager r4, Function1<? super OSectionSupportiveText, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "mSmsBackend");
        Intrinsics.checkNotNullParameter(r4, "pkgMan");
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        super(r5);
        this.activity = r2;
        this.mSmsBackend = r3;
        this.pkgMan = r4;
        this.call = r5;
        this.apps = new ArrayList();
        String[] r6 = r2.getResources().getStringArray(R.array.security_settings_premium_sms_values);
        Intrinsics.checkNotNullExpressionValue(r6, "getStringArray(...)");
        this.valueDescs = r6;
        String r7 = r2.getResources().getString(R.string.unknown);
        Intrinsics.checkNotNullExpressionValue(r7, "getString(...)");
        this.valueUnknown = r7;
        this.status = "";
    }

    public final ArrayList<ApplicationsState.AppEntry> getApps() {
        return this.apps;
    }

    public final void setApps(ArrayList<ApplicationsState.AppEntry> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.apps = r2;
    }

    public final void setData(ArrayList<ApplicationsState.AppEntry> r2) {
        Intrinsics.checkNotNullParameter(r2, OcrAppInfoColumn.TABLE_NAME);
        this.apps = r2;
        notifyDataSetChanged();
    }

    @Override // com.android.settings.specialaccess.HeaderBaseAdapter
    public PremiumSmsAccessViewHolder onCreateContentViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        View r1 = LayoutInflater.from(r2.getContext()).inflate(R.layout.settings_oui_card_list_item, r2, false);
        Intrinsics.checkNotNull(r1);
        return new PremiumSmsAccessViewHolder(r1);
    }

    private final int getCurrentValue(ApplicationsState.AppEntry r1) {
        if ((r1.extraInfo instanceof AppStateSmsPremBridge.SmsState) == false) goto L5;
        Object r0 = r1.extraInfo;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.android.settings.applications.AppStateSmsPremBridge.SmsState");
        return ((AppStateSmsPremBridge.SmsState) r0).smsState;
    L5:
        return 0;
    }

    private final String getCurrentValueDesc(int r4) {
        if (r4 != 1) goto L5;
        String r3 = this.valueDescs[0];
        Intrinsics.checkNotNullExpressionValue(r3, "get(...)");
        return r3;
    L5:
        if (r4 != 2) goto L7;
        String r5 = this.valueDescs[1];
        Intrinsics.checkNotNullExpressionValue(r5, "get(...)");
        return r5;
    L7:
        if (r4 != 3) goto L13;
        String r6 = this.valueDescs[2];
        Intrinsics.checkNotNullExpressionValue(r6, "get(...)");
        return r6;
    L13:
        return this.valueUnknown;
    }

    private final void onValueChange(ApplicationsState.AppEntry r1, int r2) {
        this.mSmsBackend.setSmsState(r1.info.packageName, r2);
    }

    @Override // com.android.settings.specialaccess.HeaderBaseAdapter
    public void onBindContentViewHolder(final RecyclerView.ViewHolder r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        ApplicationsState.AppEntry r1 = this.apps.get(r5);
        Intrinsics.checkNotNullExpressionValue(r1, "get(...)");
        final ApplicationsState.AppEntry r2 = r1;
        OCardListItem r0 = ((PremiumSmsAccessViewHolder) r4).getOlistitem();
        OCardListItemUtils.initCardItemInAdapter(r0, r5, this.apps.size());
        OCardListItemUtils.setTrailingText(r0, getCurrentValueDesc(getCurrentValue(r2)));
        String r6 = r2.info.packageName;
        Intrinsics.checkNotNullExpressionValue(r6, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        OCardListItemUtils.setIcon(r0, ObricIconUtils.getDrawable(r6, r2.info.uid));
        OCardListItemUtils.setTitle(r0, r2.info.loadLabel(this.pkgMan));
        r0.setDefaultTailIcon(1);
        r0.showTailIcon(true);
        r0.setOnContentClickListener(new PremiumSmsAccessAdapter$$ExternalSyntheticLambda0(this, r4, r2));
    }

    private static final void onBindContentViewHolder$lambda$1$lambda$0(PremiumSmsAccessAdapter r0, RecyclerView.ViewHolder r1, ApplicationsState.AppEntry r2, View r3) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$holder");
        Intrinsics.checkNotNullParameter(r2, "$appInfo");
        r0.showMenuDialog((PremiumSmsAccessViewHolder) r1, r2);
    }

    private final void showMenuDialog(PremiumSmsAccessViewHolder r1, ApplicationsState.AppEntry r2) {
        prepareMenuDialog(r1, r2);
    }

    private final void prepareMenuDialog(final PremiumSmsAccessViewHolder r14, final ApplicationsState.AppEntry r15) {
        Activity r0 = this.activity;
        View r1 = OCardListItemUtils.getCardView(r14.getOlistitem());
        String[] r2 = this.valueDescs;
        ArrayList r3 = new ArrayList(r2.length);
        int r4 = r2.length;
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L5;
        String r7 = r2[r5];
        Intrinsics.checkNotNull(r7);
        r3.add(new Item(r7, Intrinsics.areEqual(getCurrentValueDesc(getCurrentValue(r15)), r7), null, 4, null));
        r5 = r5 + 1;
        goto L3
    L5:
        this.mMenuDialog = OPopoverHelper.showPopoverList$default(r0, r1, r3, new AnonymousClass2(this, r15, r14), false, 16, null);
    }

    @Override // com.android.settings.specialaccess.HeaderBaseAdapter
    public int getItemContentCount() {
        return this.apps.size();
    }
}
