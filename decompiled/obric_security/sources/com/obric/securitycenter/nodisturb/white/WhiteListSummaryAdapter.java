package com.obric.securitycenter.nodisturb.white;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.securitycenter.nodisturb.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WhiteListSummaryAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003,-.BA\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0012H\u0016J&\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000fH\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u0006\u0010%\u001a\u00020\u0006J\u0014\u0010&\u001a\u00020\u00062\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u000e\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\tJ\u0014\u0010*\u001a\u00020\u00062\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/securitycenter/nodisturb/white/WhiteListSummaryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/securitycenter/nodisturb/white/WhiteListSummaryAdapter$WhiteVH;", "onItemDelete", "Lkotlin/Function1;", "Lcom/obric/securitycenter/nodisturb/white/WhiteListSummaryItem;", "", "onItemSelect", "Lkotlin/Function2;", "", "selectAll", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "isSelectionMode", "items", "", "selectedIds", "", "", "swipeController", "Lcom/obric/securitycenter/nodisturb/white/WhiteListSummaryAdapter$SwipeController;", "formatPhoneNumber", "", AccountConst.KEY_PHONE_NUMBER, "getAllItems", "", "getItemCount", "onBindViewHolder", "holder", "position", "payloads", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "refreshSwipeState", "setSelectedIds", "ids", "setSelectionMode", "enabled", "submitItems", "newItems", "Companion", "SwipeController", "WhiteVH", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WhiteListSummaryAdapter extends RecyclerView.Adapter<WhiteVH> {
    private static final Companion Companion = null;

    @Deprecated
    public static final String PAYLOAD_SELECTION_CHANGED = "payload_selection_changed";

    @Deprecated
    public static final String PAYLOAD_SELECT_MODE_CHANGED = "payload_select_mode_changed";
    private boolean isSelectionMode;
    private final List<WhiteListSummaryItem> items;
    private final Function1<WhiteListSummaryItem, Unit> onItemDelete;
    private final Function2<WhiteListSummaryItem, Boolean, Unit> onItemSelect;
    private final Function0<Unit> selectAll;
    private Set<Integer> selectedIds;
    private final SwipeController swipeController;

    /* JADX INFO: compiled from: WhiteListSummaryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/securitycenter/nodisturb/white/WhiteListSummaryAdapter$Companion;", "", "()V", "PAYLOAD_SELECTION_CHANGED", "", "PAYLOAD_SELECT_MODE_CHANGED", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: WhiteListSummaryAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/securitycenter/nodisturb/white/WhiteListSummaryAdapter$SwipeController;", "", "()V", "openedCardRef", "Ljava/lang/ref/WeakReference;", "Lcom/obric/oui/lisitem/OCardListItem;", "closeCard", "", "card", "closeOpened", "onStartOpen", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class SwipeController {
        private WeakReference<OCardListItem> openedCardRef;

        public SwipeController() {
        }

        public final void onStartOpen(OCardListItem r2) {
            Intrinsics.checkNotNullParameter(r2, "card");
            WeakReference<OCardListItem> r0 = this.openedCardRef;
            if (r0 == null) goto L5;
            OCardListItem r1 = r0.get();
        L6:
            if (r1 == null) goto L9;
            if (r1 == r2) goto L9;
            closeCard(r1);
        L9:
            this.openedCardRef = new WeakReference(r2);
            return;
        L5:
            r1 = null;
            goto L6
        }

        public final void closeOpened() {
            WeakReference<OCardListItem> r0 = this.openedCardRef;
            if (r0 == null) goto L5;
            OCardListItem r1 = r0.get();
        L6:
            if (r1 == null) goto L8;
            closeCard(r1);
        L8:
            this.openedCardRef = null;
            return;
        L5:
            r1 = null;
            goto L6
        }

        private final void closeCard(OCardListItem r2) {
            if (r2.getSwipeLayout().getOpenStatus() != OSwipeLayout.Status.Open) goto L5;
            r2.swipeClose();     // Catch: Exception -> L7
        L5:
            r2.setContentChecked(false);     // Catch: Exception -> L7
            r2.showTailIcon(false);     // Catch: Exception -> L7
            r2.showDivider(true);     // Catch: Exception -> L7
            return;
        }
    }

    /* JADX INFO: compiled from: WhiteListSummaryAdapter.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0005¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nJ\u001e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nJ\b\u0010\u001b\u001a\u00020\u0007H\u0002J\u0006\u0010\u001c\u001a\u00020\u0007J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/securitycenter/nodisturb/white/WhiteListSummaryAdapter$WhiteVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onItemDelete", "Lkotlin/Function1;", "Lcom/obric/securitycenter/nodisturb/white/WhiteListSummaryItem;", "", "onItemSelect", "Lkotlin/Function2;", "", "selectAll", "Lkotlin/Function0;", "onSwipeStartOpen", "Lcom/obric/oui/lisitem/OCardListItem;", "closeOpenedSwipe", "formatPhone", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "checkBox", "Lcom/obric/oui/checkbox/OCheckBox;", "listItem", "bind", "item", "isSelectionMode", "isSelected", "bindSelectUi", "ensureSelectCheckBoxView", "onRecycled", "resetSwipeClick", "card", "entry", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class WhiteVH extends RecyclerView.ViewHolder {
        private OCheckBox checkBox;
        private final Function0<Unit> closeOpenedSwipe;
        private final Function1<String, String> formatPhone;
        private final OCardListItem listItem;
        private final Function1<WhiteListSummaryItem, Unit> onItemDelete;
        private final Function2<WhiteListSummaryItem, Boolean, Unit> onItemSelect;
        private final Function1<OCardListItem, Unit> onSwipeStartOpen;
        private final Function0<Unit> selectAll;

        public static /* synthetic */ void $r8$lambda$0SliRypQqkXKO0hXz_m70BCeXtU(OCardListItem r0, WhiteVH r1, WhiteListSummaryItem r2, View r3) {
            resetSwipeClick$lambda$16(r0, r1, r2, r3);
        }

        public static /* synthetic */ boolean $r8$lambda$A_Y7N18GfiQEq1a6SbnZ_zCUARI(WhiteVH r0, WhiteListSummaryItem r1, View r2) {
            return bind$lambda$15(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$Kbkpoop_27s3nLhG2jxhCQZr_a0(WhiteVH r0, WhiteListSummaryItem r1, OCheckBox r2, boolean r3) {
            bindSelectUi$lambda$4$lambda$3(r0, r1, r2, r3);
        }

        /* JADX INFO: renamed from: $r8$lambda$Lc1KU8NMOz-iqt3S9WsMhUxbM6Y, reason: not valid java name */
        public static /* synthetic */ void m622$r8$lambda$Lc1KU8NMOziqt3S9WsMhUxbM6Y(WhiteVH r0, WhiteListSummaryItem r1, OCheckBox r2, boolean r3) {
            bind$lambda$11$lambda$10(r0, r1, r2, r3);
        }

        public static /* synthetic */ boolean $r8$lambda$XNcdHuuDfS1RL9OVsOl5mQinMSs(WhiteVH r0, WhiteListSummaryItem r1, View r2) {
            return bindSelectUi$lambda$8(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$aTIkzrVYoaQiGU6GhWRuxkFEdns(WhiteVH r0, View r1) {
            bindSelectUi$lambda$6(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$o2yCHDDh1u4p4hJ2M6l3kgsR5_M(WhiteVH r0, View r1) {
            bind$lambda$13(r0, r1);
        }

        public static final /* synthetic */ Function1 access$getOnSwipeStartOpen$p(WhiteVH r0) {
            return r0.onSwipeStartOpen;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public WhiteVH(View r2, Function1<? super WhiteListSummaryItem, Unit> r3, Function2<? super WhiteListSummaryItem, ? super Boolean, Unit> r4, Function0<Unit> r5, Function1<? super OCardListItem, Unit> r6, Function0<Unit> r7, Function1<? super String, String> r8) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "onItemDelete");
            Intrinsics.checkNotNullParameter(r4, "onItemSelect");
            Intrinsics.checkNotNullParameter(r5, "selectAll");
            Intrinsics.checkNotNullParameter(r6, "onSwipeStartOpen");
            Intrinsics.checkNotNullParameter(r7, "closeOpenedSwipe");
            Intrinsics.checkNotNullParameter(r8, "formatPhone");
            super(r2);
            this.onItemDelete = r3;
            this.onItemSelect = r4;
            this.selectAll = r5;
            this.onSwipeStartOpen = r6;
            this.closeOpenedSwipe = r7;
            this.formatPhone = r8;
            View r9 = r2.findViewById(R.id.white_list_item);
            Intrinsics.checkNotNullExpressionValue(r9, "itemView.findViewById(R.id.white_list_item)");
            this.listItem = (OCardListItem) r9;
        }

        private final void ensureSelectCheckBoxView() {
            if (this.checkBox == null) goto L5;
            return;
        L5:
            OCardListItem r0 = this.listItem;
            View r1 = LayoutInflater.from(this.itemView.getContext()).inflate(R.layout.o_listitem_sms_keyword_checkbox, null);
            float r3 = 32;
            FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics())));
            r2.gravity = 16;
            r2.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())));
            r1.setLayoutParams(r2);
            OCheckBox r4 = (OCheckBox) r1.findViewById(R.id.listitem_checkbox);
            if (r4 == null) goto L8;
            Intrinsics.checkNotNullExpressionValue(r4, "findViewById<OCheckBox>(R.id.listitem_checkbox)");
            r4.setFocusable(false);
            r4.setFocusableInTouchMode(false);
            this.checkBox = r4;
        L8:
            r0.setCustomStartView(r1);
        }

        public final void bindSelectUi(final WhiteListSummaryItem r4, boolean r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r4, "item");
            if (r5 == false) goto L20;
            this.closeOpenedSwipe.invoke();
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L10
            if (this.listItem.getSwipeLayout().getOpenStatus() != OSwipeLayout.Status.Open) goto L8;
            this.listItem.swipeClose();     // Catch: Throwable -> L10
        L8:
            Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        L12:
            this.listItem.showDivider(true);
            ensureSelectCheckBoxView();
            OCheckBox r8 = this.checkBox;
            if (r8 == null) goto L15;
            r8.setOnCheckedChangeListener(null);
            r8.setChecked(r6);
            r8.setOnCheckedChangeListener(new WhiteListSummaryAdapter$WhiteVH$$ExternalSyntheticLambda0(this, r4));
        L15:
            OCheckBoxLayout r9 = this.listItem.getStartCheckBox();
            if (r9 == null) goto L19;
            r9.setVisibility(0);
        L19:
            this.listItem.setOnContentClickListener(new WhiteListSummaryAdapter$WhiteVH$$ExternalSyntheticLambda1(this));
            this.listItem.setOnContentLongClickListener(null);
            this.listItem.showCustomStart(true);
            return;
        L10:
            th = move-exception;
            Result.Companion r2 = Result.Companion;
            Result.m774constructorimpl(ResultKt.createFailure(th));
            goto L12
        L20:
            resetSwipeClick(this.listItem, r4);
            OCheckBoxLayout r10 = this.listItem.getStartCheckBox();
            if (r10 == null) goto L24;
            r10.setVisibility(8);
        L24:
            OCheckBox r11 = this.checkBox;
            if (r11 == null) goto L27;
            r11.setOnCheckedChangeListener(null);
            r11.setChecked(false);
        L27:
            this.listItem.setOnContentClickListener(null);
            this.listItem.setOnContentLongClickListener(new WhiteListSummaryAdapter$WhiteVH$$ExternalSyntheticLambda2(this, r4));
            this.listItem.showCustomStart(false);
        }

        private static final void bindSelectUi$lambda$4$lambda$3(WhiteVH r1, WhiteListSummaryItem r2, OCheckBox r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            Intrinsics.checkNotNullParameter(r2, "$item");
            Intrinsics.checkNotNullParameter(r3, "<anonymous parameter 0>");
            r1.onItemSelect.invoke(r2, Boolean.valueOf(r4));
            r1.closeOpenedSwipe.invoke();
        }

        private static final void bindSelectUi$lambda$6(WhiteVH r0, View r1) {
            Intrinsics.checkNotNullParameter(r0, "this$0");
            OCheckBox r2 = r0.checkBox;
            if (r2 == null) goto L6;
            r2.setChecked(!r2.isChecked());
            return;
        }

        private static final boolean bindSelectUi$lambda$8(WhiteVH r1, WhiteListSummaryItem r2, View r3) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            Intrinsics.checkNotNullParameter(r2, "$item");
            r1.selectAll.invoke();
            r1.onItemSelect.invoke(r2, true);
            return true;
        }

        public final void bind(final WhiteListSummaryItem r7, boolean r8, boolean r9) {
            Intrinsics.checkNotNullParameter(r7, "item");
            ensureSelectCheckBoxView();
            if (r7.getNote().length() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            this.listItem.setTitle(this.formatPhone.invoke(r7.getPhoneNumber()));
            this.listItem.setSubTitle("");
            this.listItem.showTitle(true);
            this.listItem.showSubTitle(false);
        L9:
            this.listItem.setContentChecked(false);
            this.listItem.showCustomEnd(true);
            this.listItem.setDefaultTailIcon(0);
            this.listItem.showDivider(true);
            this.listItem.setEnableSwipeDivider(false);
            this.listItem.showTailIcon(false);
            this.listItem.setCardType(1);
            RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r1 = getBindingAdapter();
            if (r1 == null) goto L12;
            int r2 = r1.getItemCount();
        L13:
            int r3 = getBindingAdapterPosition();
            if (r2 != 1) goto L16;
            OCardListItem.setCardPosition$default(this.listItem, 0, false, 2, null);
        L22:
            if (r8 == true) goto L24;
            resetSwipeClick(this.listItem, r7);
        L33:
            if (r8 == false) goto L42;
            OCheckBox r10 = this.checkBox;
            if (r10 == null) goto L37;
            r10.setOnCheckedChangeListener(null);
            r10.setChecked(r9);
            r10.setOnCheckedChangeListener(new WhiteListSummaryAdapter$WhiteVH$$ExternalSyntheticLambda4(this, r7));
        L37:
            OCheckBoxLayout r11 = this.listItem.getStartCheckBox();
            if (r11 == null) goto L41;
            r11.setVisibility(0);
        L41:
            this.listItem.setOnContentClickListener(new WhiteListSummaryAdapter$WhiteVH$$ExternalSyntheticLambda5(this));
            this.listItem.setOnContentLongClickListener(null);
            this.listItem.showCustomStart(true);
            return;
        L42:
            OCheckBoxLayout r12 = this.listItem.getStartCheckBox();
            if (r12 == null) goto L46;
            r12.setVisibility(8);
        L46:
            OCheckBox r13 = this.checkBox;
            if (r13 == null) goto L49;
            r13.setOnCheckedChangeListener(null);
            r13.setChecked(false);
        L49:
            this.listItem.setOnContentClickListener(null);
            this.listItem.setOnContentLongClickListener(new WhiteListSummaryAdapter$WhiteVH$$ExternalSyntheticLambda6(this, r7));
            this.listItem.showCustomStart(false);
            return;
        L24:
            this.closeOpenedSwipe.invoke();
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L30
            if (this.listItem.getSwipeLayout().getOpenStatus() != OSwipeLayout.Status.Open) goto L28;
            this.listItem.swipeClose();     // Catch: Throwable -> L30
        L28:
            Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L30
        L32:
            this.listItem.showDivider(true);
        L30:
            th = move-exception;
            Result.Companion r5 = Result.Companion;
            Result.m774constructorimpl(ResultKt.createFailure(th));
            goto L32
        L16:
            if (r3 != 0) goto L19;
            OCardListItem.setCardPosition$default(this.listItem, 1, false, 2, null);
            goto L22
        L19:
            if (r3 != (r2 - 1)) goto L21;
            OCardListItem.setCardPosition$default(this.listItem, 3, false, 2, null);
            goto L22
        L21:
            OCardListItem.setCardPosition$default(this.listItem, 2, false, 2, null);
            goto L22
        L12:
            r2 = 0;
            goto L13
        L8:
            this.listItem.setTitle(r7.getNote());
            this.listItem.setSubTitle(this.formatPhone.invoke(r7.getPhoneNumber()));
            this.listItem.showTitle(true);
            this.listItem.showSubTitle(true);
            goto L9
        L5:
            r0 = false;
            goto L6
        }

        private static final void bind$lambda$11$lambda$10(WhiteVH r1, WhiteListSummaryItem r2, OCheckBox r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            Intrinsics.checkNotNullParameter(r2, "$item");
            Intrinsics.checkNotNullParameter(r3, "<anonymous parameter 0>");
            r1.onItemSelect.invoke(r2, Boolean.valueOf(r4));
            r1.closeOpenedSwipe.invoke();
        }

        private static final void bind$lambda$13(WhiteVH r0, View r1) {
            Intrinsics.checkNotNullParameter(r0, "this$0");
            OCheckBox r2 = r0.checkBox;
            if (r2 == null) goto L6;
            r2.setChecked(!r2.isChecked());
            return;
        }

        private static final boolean bind$lambda$15(WhiteVH r1, WhiteListSummaryItem r2, View r3) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            Intrinsics.checkNotNullParameter(r2, "$item");
            r1.selectAll.invoke();
            r1.onItemSelect.invoke(r2, true);
            return true;
        }

        public final void onRecycled() {
            this.listItem.swipeClose();
            this.listItem.showTailIcon(false);
            OCheckBox r2 = this.checkBox;
            if (r2 == null) goto L6;
            r2.setOnCheckedChangeListener(null);
            return;
        }

        private final void resetSwipeClick(final OCardListItem r3, final WhiteListSummaryItem r4) {
            r3.setSwipeView(R.layout.layout_card_list_item_swip);
            r3.setEnableSwipe(true);
            r3.getSwipeLayout().addSwipeListener(new WhiteListSummaryAdapter$WhiteVH$resetSwipeClick$1(r3, this));
            View r0 = r3.getSwipeView();
            if (r0 == null) goto L5;
            View r1 = r0.findViewById(R.id.btn_swipe_1);
        L6:
            if (r1 == null) goto L9;
            r1.setOnClickListener(new WhiteListSummaryAdapter$WhiteVH$$ExternalSyntheticLambda3(r3, this, r4));
            return;
        L9:
            return;
        L5:
            r1 = null;
            goto L6
        }

        private static final void resetSwipeClick$lambda$16(OCardListItem r0, WhiteVH r1, WhiteListSummaryItem r2, View r3) {
            Intrinsics.checkNotNullParameter(r0, "$card");
            Intrinsics.checkNotNullParameter(r1, "this$0");
            Intrinsics.checkNotNullParameter(r2, "$entry");
            r0.swipeClose();
            r1.onItemDelete.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.obric.securitycenter.nodisturb.white.WhiteListSummaryAdapter$onCreateViewHolder$3, reason: invalid class name */
    /* JADX INFO: compiled from: WhiteListSummaryAdapter.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<String, String> {
        AnonymousClass3(Object r8) {
            super(1, r8, WhiteListSummaryAdapter.class, "formatPhoneNumber", "formatPhoneNumber(Ljava/lang/String;)Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(String r1) {
            return invoke2(r1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(String r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return WhiteListSummaryAdapter.access$formatPhoneNumber((WhiteListSummaryAdapter) this.receiver, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ String access$formatPhoneNumber(WhiteListSummaryAdapter r0, String r1) {
        return r0.formatPhoneNumber(r1);
    }

    public static final /* synthetic */ SwipeController access$getSwipeController$p(WhiteListSummaryAdapter r0) {
        return r0.swipeController;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((WhiteVH) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2, List r3) {
        onBindViewHolder((WhiteVH) r1, r2, r3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder r1) {
        onViewRecycled((WhiteVH) r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WhiteListSummaryAdapter(Function1<? super WhiteListSummaryItem, Unit> r2, Function2<? super WhiteListSummaryItem, ? super Boolean, Unit> r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "onItemDelete");
        Intrinsics.checkNotNullParameter(r3, "onItemSelect");
        Intrinsics.checkNotNullParameter(r4, "selectAll");
        this.onItemDelete = r2;
        this.onItemSelect = r3;
        this.selectAll = r4;
        this.items = new ArrayList();
        this.selectedIds = SetsKt.emptySet();
        this.swipeController = new SwipeController();
    }

    public final void refreshSwipeState() {
        this.swipeController.closeOpened();
    }

    public final void submitItems(List<WhiteListSummaryItem> r2) {
        Intrinsics.checkNotNullParameter(r2, "newItems");
        refreshSwipeState();
        this.items.clear();
        this.items.addAll(r2);
        notifyDataSetChanged();
    }

    public final void setSelectionMode(boolean r3) {
        refreshSwipeState();
        if (this.isSelectionMode != r3) goto L5;
        return;
    L5:
        this.isSelectionMode = r3;
        if (r3 == true) goto L9;
        this.selectedIds = SetsKt.emptySet();
    L9:
        if (getItemCount() <= 0) goto L12;
        notifyItemRangeChanged(0, getItemCount(), "payload_select_mode_changed");
        return;
    }

    public final void setSelectedIds(Set<Integer> r3) {
        Intrinsics.checkNotNullParameter(r3, "ids");
        refreshSwipeState();
        this.selectedIds = CollectionsKt.toSet(r3);
        if (getItemCount() <= 0) goto L6;
        notifyItemRangeChanged(0, getItemCount(), "payload_selection_changed");
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public WhiteVH onCreateViewHolder(ViewGroup r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "parent");
        View r3 = LayoutInflater.from(r11.getContext()).inflate(R.layout.item_white_list, r11, false);
        Intrinsics.checkNotNullExpressionValue(r3, "view");
        return new WhiteVH(r3, this.onItemDelete, this.onItemSelect, this.selectAll, new AnonymousClass1(this), new AnonymousClass2(this), new AnonymousClass3(this));
    }

    public void onBindViewHolder(WhiteVH r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        WhiteListSummaryItem r5 = this.items.get(r4);
        r3.bind(r5, this.isSelectionMode, this.selectedIds.contains(Integer.valueOf(r5.getId())));
    }

    public void onBindViewHolder(WhiteVH r2, int r3, List<Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        if ((!r4.isEmpty()) == false) goto L9;
        WhiteListSummaryItem r5 = (WhiteListSummaryItem) CollectionsKt.getOrNull(this.items, r3);
        if (r5 != null) goto L7;
        return;
    L7:
        r2.bindSelectUi(r5, this.isSelectionMode, this.selectedIds.contains(Integer.valueOf(r5.getId())));
        return;
    L9:
        super.onBindViewHolder(r2, r3, r4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public void onViewRecycled(WhiteVH r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.onViewRecycled(r2);
        r2.onRecycled();
    }

    public final List<WhiteListSummaryItem> getAllItems() {
        return CollectionsKt.toList(this.items);
    }

    private final String formatPhoneNumber(String r7) {
        String r8 = r7;
        StringBuilder r6 = new StringBuilder();
        int r0 = r8.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        char r3 = r8.charAt(r2);
        if (Character.isDigit(r3) == false) goto L7;
        r6.append(r3);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        String r9 = r6.toString();
        Intrinsics.checkNotNullExpressionValue(r9, "filterTo(StringBuilder(), predicate).toString()");
        if (r9.length() < 11) goto L13;
        String r10 = StringsKt.takeLast(r9, 11);
        String r11 = r10.substring(0, 3);
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String…ing(startIndex, endIndex)");
        String r1 = r10.substring(3, 7);
        Intrinsics.checkNotNullExpressionValue(r1, "this as java.lang.String…ing(startIndex, endIndex)");
        String r12 = r10.substring(7, 11);
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String…ing(startIndex, endIndex)");
        return r11 + " " + r1 + " " + r12;
    L13:
        if (r9.length() <= 7) goto L19;
        String r13 = r9.substring(0, 3);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String…ing(startIndex, endIndex)");
        String r4 = r9.substring(3, 7);
        Intrinsics.checkNotNullExpressionValue(r4, "this as java.lang.String…ing(startIndex, endIndex)");
        String r14 = r9.substring(7);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).substring(startIndex)");
        return r13 + " " + r4 + " " + r14;
    L19:
        return r9;
    }
}
