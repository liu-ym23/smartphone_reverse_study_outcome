package com.obric.securitycenter.nodisturb.black;

import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.preventdisturb.DisturbActivity;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.securitycenter.nodisturb.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: BlackListSummaryAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\b*+,-./01BA\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J&\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00172\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017H\u0016J\u001c\u0010#\u001a\u00020\u00062\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u00152\u0006\u0010%\u001a\u00020\tJ\u000e\u0010&\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\tJ\u0010\u0010'\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010)R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$VH;", "onItemDelete", "Lkotlin/Function1;", "Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryItem;", "", "onItemSelect", "Lkotlin/Function2;", "", "selectAll", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "entries", "", "Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$Entry;", "isSelectAll", "formatPhoneNumber", "", AccountConst.KEY_PHONE_NUMBER, "getAllItems", "", "getEmptyEntryHeight", "", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "payloads", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectItem", "targets", "isSelect", "setSelectAll", "submitCursor", "cursor", "Landroid/database/Cursor;", "BlackEntry", "BlackVH", "Companion", "EmptyEntry", "EmptyVH", "Entry", "EntryType", "VH", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlackListSummaryAdapter extends RecyclerView.Adapter<VH> {
    private static final Companion Companion = null;

    @Deprecated
    public static final String PAYLOAD_SELECTION_CHANGED = "payload_selection_changed";

    @Deprecated
    public static final String PAYLOAD_SELECT_MODE_CHANGED = "payload_select_mode_changed";
    private final List<Entry> entries;
    private boolean isSelectAll;
    private final Function1<BlackListSummaryItem, Unit> onItemDelete;
    private final Function2<BlackListSummaryItem, Boolean, Unit> onItemSelect;
    private final Function0<Unit> selectAll;

    /* JADX INFO: compiled from: BlackListSummaryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$BlackEntry;", "Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$Entry;", "item", "Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryItem;", "isSelected", "", "(Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryItem;Z)V", "()Z", "setSelected", "(Z)V", "getItem", "()Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryItem;", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class BlackEntry extends Entry {
        private boolean isSelected;
        private final BlackListSummaryItem item;

        public BlackEntry(BlackListSummaryItem r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            super(EntryType.Black.INSTANCE.getType());
            this.item = r2;
            this.isSelected = r3;
        }

        public /* synthetic */ BlackEntry(BlackListSummaryItem r1, boolean r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = false;
        L5:
            this(r1, r2);
        }

        public final BlackListSummaryItem getItem() {
            return this.item;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public final void setSelected(boolean r1) {
            this.isSelected = r1;
        }
    }

    /* JADX INFO: compiled from: BlackListSummaryAdapter.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0005¢\u0006\u0002\u0010\u000fJ \u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u001e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nJ\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0006H\u0002R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$BlackVH;", "Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$VH;", "itemView", "Landroid/view/View;", "onItemDelete", "Lkotlin/Function1;", "Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryItem;", "", "onItemSelect", "Lkotlin/Function2;", "", "selectAll", "Lkotlin/Function0;", "formatPhone", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "checkBox", "Lcom/obric/oui/checkbox/OCheckBox;", "listItem", "Lcom/obric/oui/lisitem/OCardListItem;", "bind", "item", "Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$Entry;", "position", "", "isSelectAll", "bindSelectUi", "Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$BlackEntry;", "resetSwipeClick", "card", "entry", "Companion", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class BlackVH extends VH {
        public static final Companion Companion = null;
        private static final Set<WeakReference<OCardListItem>> cardItemRefs = null;
        private OCheckBox checkBox;
        private final Function1<String, String> formatPhone;
        private final OCardListItem listItem;
        private final Function1<BlackListSummaryItem, Unit> onItemDelete;
        private final Function2<BlackListSummaryItem, Boolean, Unit> onItemSelect;
        private final Function0<Unit> selectAll;

        /* JADX INFO: compiled from: BlackListSummaryAdapter.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$BlackVH$Companion;", "", "()V", "cardItemRefs", "", "Ljava/lang/ref/WeakReference;", "Lcom/obric/oui/lisitem/OCardListItem;", "getCardItemRefs", "()Ljava/util/Set;", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }

            public final Set<WeakReference<OCardListItem>> getCardItemRefs() {
                return BlackVH.access$getCardItemRefs$cp();
            }
        }

        public static /* synthetic */ boolean $r8$lambda$1c0LPsspaiPb4oQX26w1uhojMnQ(Entry r0, BlackVH r1, BlackListSummaryItem r2, View r3) {
            return bind$lambda$17(r0, r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$I4fmIVMSbjoVNEaBVs1cwJ9K89w(BlackVH r0, BlackListSummaryItem r1, OCheckBox r2, boolean r3) {
            bindSelectUi$lambda$3$lambda$2(r0, r1, r2, r3);
        }

        /* JADX INFO: renamed from: $r8$lambda$O1nDD6yeXTtg3zpJaDOvIIC-hRQ, reason: not valid java name */
        public static /* synthetic */ void m612$r8$lambda$O1nDD6yeXTtg3zpJaDOvIIChRQ(BlackListSummaryItem r0, BlackVH r1, View r2) {
            bindSelectUi$lambda$7(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$PtsBsMPuHchELqaXB1QCeVhPvQM(BlackVH r0, View r1) {
            bind$lambda$14(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$RqRUTSUlwnhh9-wsb1aJKgak0cw, reason: not valid java name */
        public static /* synthetic */ void m613$r8$lambda$RqRUTSUlwnhh9wsb1aJKgak0cw(BlackVH r0, View r1) {
            bindSelectUi$lambda$5(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$W6NeTpgF7t2RULNFWsLLR6qbt8g(OCardListItem r0, BlackVH r1, BlackListSummaryItem r2, View r3) {
            resetSwipeClick$lambda$18(r0, r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$bYnQB8gP3GSPkSvoKiT0HWLijSg(BlackVH r0, BlackListSummaryItem r1, OCheckBox r2, boolean r3) {
            bind$lambda$12$lambda$11(r0, r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$s53RMifJJ77G7H2xuzA3nMQ2M18(BlackListSummaryItem r0, BlackVH r1, View r2) {
            bind$lambda$16(r0, r1, r2);
        }

        public static /* synthetic */ boolean $r8$lambda$zBBbkmHtHPSE2dS_Os51tbXrjKg(BlackEntry r0, BlackVH r1, BlackListSummaryItem r2, View r3) {
            return bindSelectUi$lambda$8(r0, r1, r2, r3);
        }

        public static final /* synthetic */ Set access$getCardItemRefs$cp() {
            return cardItemRefs;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public BlackVH(View r2, Function1<? super BlackListSummaryItem, Unit> r3, Function2<? super BlackListSummaryItem, ? super Boolean, Unit> r4, Function0<Unit> r5, Function1<? super String, String> r6) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "onItemDelete");
            Intrinsics.checkNotNullParameter(r4, "onItemSelect");
            Intrinsics.checkNotNullParameter(r5, "selectAll");
            Intrinsics.checkNotNullParameter(r6, "formatPhone");
            super(r2);
            this.onItemDelete = r3;
            this.onItemSelect = r4;
            this.selectAll = r5;
            this.formatPhone = r6;
            View r7 = r2.findViewById(R.id.black_list_item);
            Intrinsics.checkNotNullExpressionValue(r7, "itemView.findViewById(R.id.black_list_item)");
            this.listItem = (OCardListItem) r7;
        }

        static {
            Companion = new Companion(null);
            cardItemRefs = new LinkedHashSet();
        }

        public final void bindSelectUi(final BlackEntry r9, int r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r9, "item");
            final BlackListSummaryItem r12 = r9.getItem();
            this.listItem.setEnableSwipe(false);
            if (r11 == true) goto L5;
            OCheckBoxLayout r13 = this.listItem.getStartCheckBox();
            if (r13 == null) goto L22;
            r13.setVisibility(8);
        L22:
            OCheckBox r14 = this.checkBox;
            if (r14 == null) goto L25;
            r14.setOnCheckedChangeListener(null);
            r14.setChecked(false);
        L25:
            this.listItem.showCustomStart(false);
            this.listItem.setOnContentClickListener(new BlackListSummaryAdapter$BlackVH$$ExternalSyntheticLambda6(r12, this));
            this.listItem.setOnContentLongClickListener(new BlackListSummaryAdapter$BlackVH$$ExternalSyntheticLambda7(r9, this, r12));
            return;
        L5:
            if (this.checkBox != null) goto L10;
            OCardListItem r15 = this.listItem;
            View r3 = LayoutInflater.from(this.itemView.getContext()).inflate(R.layout.o_listitem_sms_keyword_checkbox, null);
            float r5 = 32;
            FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics())));
            r4.gravity = 16;
            r4.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())));
            r3.setLayoutParams(r4);
            OCheckBox r6 = (OCheckBox) r3.findViewById(R.id.listitem_checkbox);
            if (r6 == null) goto L9;
            Intrinsics.checkNotNullExpressionValue(r6, "findViewById<OCheckBox>(R.id.listitem_checkbox)");
            this.checkBox = r6;
        L9:
            r15.setCustomStartView(r3);
        L10:
            OCheckBox r16 = this.checkBox;
            if (r16 == null) goto L13;
            r16.setOnCheckedChangeListener(null);
            r16.setChecked(r9.isSelected());
            r16.setOnCheckedChangeListener(new BlackListSummaryAdapter$BlackVH$$ExternalSyntheticLambda4(this, r12));
        L13:
            OCheckBoxLayout r17 = this.listItem.getStartCheckBox();
            if (r17 == null) goto L17;
            r17.setVisibility(0);
        L17:
            this.listItem.setOnContentClickListener(new BlackListSummaryAdapter$BlackVH$$ExternalSyntheticLambda5(this));
            this.listItem.setOnContentLongClickListener(null);
            this.listItem.showCustomStart(true);
        }

        private static final void bindSelectUi$lambda$3$lambda$2(BlackVH r1, BlackListSummaryItem r2, OCheckBox r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            Intrinsics.checkNotNullParameter(r2, "$entry");
            Intrinsics.checkNotNullParameter(r3, "<anonymous parameter 0>");
            r1.onItemSelect.invoke(r2, Boolean.valueOf(r4));
        }

        private static final void bindSelectUi$lambda$5(BlackVH r0, View r1) {
            Intrinsics.checkNotNullParameter(r0, "this$0");
            OCheckBox r2 = r0.checkBox;
            if (r2 == null) goto L6;
            r2.setChecked(!r2.isChecked());
            return;
        }

        private static final void bindSelectUi$lambda$7(BlackListSummaryItem r2, BlackVH r3, View r4) {
            Intrinsics.checkNotNullParameter(r2, "$entry");
            Intrinsics.checkNotNullParameter(r3, "this$0");
            ComponentName r5 = new ComponentName("com.obric.security", "com.obric.securitycenter.nodisturb.BlackDetailActivity");
            Intent r0 = new Intent();
            r0.setComponent(r5);
            r0.putExtra("blackid", r2.getId());
            r0.putExtra(DisturbActivity.CALL_PHONE_NUMBER, r2.getPhoneNumber());
            r3.itemView.getContext().startActivity(r0);
        }

        private static final boolean bindSelectUi$lambda$8(BlackEntry r1, BlackVH r2, BlackListSummaryItem r3, View r4) {
            Intrinsics.checkNotNullParameter(r1, "$item");
            Intrinsics.checkNotNullParameter(r2, "this$0");
            Intrinsics.checkNotNullParameter(r3, "$entry");
            r1.setSelected(true);
            r2.selectAll.invoke();
            r2.onItemSelect.invoke(r3, true);
            r2.listItem.swipeClose();
            return true;
        }

        @Override // com.obric.securitycenter.nodisturb.black.BlackListSummaryAdapter.VH
        public void bind(final Entry r10, int r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r10, "item");
            if ((r10 instanceof BlackEntry) == false) goto L59;
            BlackEntry r0 = (BlackEntry) r10;
            final BlackListSummaryItem r1 = r0.getItem();
            if (r1.getNote().length() != 0) goto L7;
            boolean r2 = true;
        L8:
            if (r2 == false) goto L10;
            this.listItem.setTitle(this.formatPhone.invoke(r1.getPhoneNumber()));
            this.listItem.setSubTitle("");
            this.listItem.showTitle(true);
            this.listItem.showSubTitle(false);
        L11:
            OCardListItem r3 = this.listItem;
            if (r1.getInterceptCount() <= 999) goto L14;
            String r5 = this.itemView.getContext().getString(R.string.intercept_total_text2_more_ten_thousand);
        L15:
            OCardListItem.setEndDetailText$default(r3, r5, 0, 2, null);
            this.listItem.setContentChecked(false);
            this.listItem.showCustomEnd(true);
            this.listItem.setDefaultTailIcon(0);
            this.listItem.showTailIcon(true);
            this.listItem.showDivider(true);
            this.listItem.setCardType(0);
            RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r4 = getBindingAdapter();
            if (r4 != null) goto L18;
        L20:
            boolean r6 = false;
        L21:
            if (r6 == false) goto L23;
            OCardListItem.setCardPosition$default(this.listItem, 0, false, 2, null);
        L34:
            this.listItem.setEnableSwipe(false);
            if (r12 == true) goto L37;
            OCheckBoxLayout r13 = this.listItem.getStartCheckBox();
            if (r13 == null) goto L54;
            r13.setVisibility(8);
        L54:
            OCheckBox r14 = this.checkBox;
            if (r14 == null) goto L57;
            r14.setOnCheckedChangeListener(null);
            r14.setChecked(false);
        L57:
            this.listItem.setOnContentClickListener(new BlackListSummaryAdapter$BlackVH$$ExternalSyntheticLambda2(r1, this));
            this.listItem.setOnContentLongClickListener(new BlackListSummaryAdapter$BlackVH$$ExternalSyntheticLambda3(r10, this, r1));
            this.listItem.showCustomStart(false);
            return;
        L37:
            if (this.checkBox != null) goto L42;
            OCardListItem r15 = this.listItem;
            View r16 = LayoutInflater.from(this.itemView.getContext()).inflate(R.layout.o_listitem_sms_keyword_checkbox, null);
            float r7 = 32;
            FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics())));
            r17.gravity = 16;
            r17.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())));
            r16.setLayoutParams(r17);
            OCheckBox r18 = (OCheckBox) r16.findViewById(R.id.listitem_checkbox);
            if (r18 == null) goto L41;
            Intrinsics.checkNotNullExpressionValue(r18, "findViewById<OCheckBox>(R.id.listitem_checkbox)");
            this.checkBox = r18;
        L41:
            r15.setCustomStartView(r16);
        L42:
            OCheckBox r19 = this.checkBox;
            if (r19 == null) goto L45;
            r19.setOnCheckedChangeListener(null);
            r19.setChecked(r0.isSelected());
            r19.setOnCheckedChangeListener(new BlackListSummaryAdapter$BlackVH$$ExternalSyntheticLambda0(this, r1));
        L45:
            OCheckBoxLayout r110 = this.listItem.getStartCheckBox();
            if (r110 == null) goto L49;
            r110.setVisibility(0);
        L49:
            this.listItem.setOnContentClickListener(new BlackListSummaryAdapter$BlackVH$$ExternalSyntheticLambda1(this));
            this.listItem.setOnContentLongClickListener(null);
            this.listItem.showCustomStart(true);
            return;
        L23:
            if (r11 != 0) goto L25;
            OCardListItem.setCardPosition$default(this.listItem, 1, false, 2, null);
            goto L34
        L25:
            RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r8 = getBindingAdapter();
            if (r8 != null) goto L28;
        L30:
            boolean r111 = false;
        L31:
            if (r111 == false) goto L33;
            OCardListItem.setCardPosition$default(this.listItem, 3, false, 2, null);
            goto L34
        L33:
            OCardListItem.setCardPosition$default(this.listItem, 2, false, 2, null);
            goto L34
        L28:
            if (r11 != (r8.getItemCount() - 1)) goto L30;
            r111 = true;
            goto L31
        L18:
            if (r4.getItemCount() != 1) goto L20;
            r6 = true;
            goto L21
        L14:
            r5 = this.itemView.getContext().getString(R.string.intercept_total_text2, new Object[]{String.valueOf(r1.getInterceptCount())});
            goto L15
        L10:
            this.listItem.setTitle(r1.getNote());
            this.listItem.setSubTitle(this.formatPhone.invoke(r1.getPhoneNumber()));
            this.listItem.showTitle(true);
            this.listItem.showSubTitle(true);
            goto L11
        L7:
            r2 = false;
            goto L8
        }

        private static final void bind$lambda$12$lambda$11(BlackVH r1, BlackListSummaryItem r2, OCheckBox r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            Intrinsics.checkNotNullParameter(r2, "$entry");
            Intrinsics.checkNotNullParameter(r3, "<anonymous parameter 0>");
            r1.onItemSelect.invoke(r2, Boolean.valueOf(r4));
        }

        private static final void bind$lambda$14(BlackVH r0, View r1) {
            Intrinsics.checkNotNullParameter(r0, "this$0");
            OCheckBox r2 = r0.checkBox;
            if (r2 == null) goto L6;
            r2.setChecked(!r2.isChecked());
            return;
        }

        private static final void bind$lambda$16(BlackListSummaryItem r2, BlackVH r3, View r4) {
            Intrinsics.checkNotNullParameter(r2, "$entry");
            Intrinsics.checkNotNullParameter(r3, "this$0");
            ComponentName r5 = new ComponentName("com.obric.security", "com.obric.securitycenter.nodisturb.BlackDetailActivity");
            Intent r0 = new Intent();
            r0.setComponent(r5);
            r0.putExtra("blackid", r2.getId());
            r0.putExtra(DisturbActivity.CALL_PHONE_NUMBER, r2.getPhoneNumber());
            r3.itemView.getContext().startActivity(r0);
        }

        private static final boolean bind$lambda$17(Entry r1, BlackVH r2, BlackListSummaryItem r3, View r4) {
            Intrinsics.checkNotNullParameter(r1, "$item");
            Intrinsics.checkNotNullParameter(r2, "this$0");
            Intrinsics.checkNotNullParameter(r3, "$entry");
            ((BlackEntry) r1).setSelected(true);
            r2.selectAll.invoke();
            r2.onItemSelect.invoke(r3, true);
            r2.listItem.swipeClose();
            return true;
        }

        private final void resetSwipeClick(final OCardListItem r5, final BlackListSummaryItem r6) {
            r5.setSwipeView(R.layout.layout_card_list_item_swip);
            r5.setEnableSwipe(true);
            OSwipeLayout r0 = r5.getSwipeLayout();
            Set<WeakReference<OCardListItem>> r1 = cardItemRefs;
            CollectionsKt.removeAll(r1, BlackListSummaryAdapter$BlackVH$resetSwipeClick$1.INSTANCE);
            r1.add(new WeakReference(r5));
            r0.addSwipeListener(new BlackListSummaryAdapter$BlackVH$resetSwipeClick$2(r5));
            View r2 = r5.getSwipeView();
            if (r2 == null) goto L5;
            View r3 = r2.findViewById(R.id.btn_swipe_1);
        L6:
            if (r3 == null) goto L9;
            r3.setOnClickListener(new BlackListSummaryAdapter$BlackVH$$ExternalSyntheticLambda8(r5, this, r6));
            return;
        L9:
            return;
        L5:
            r3 = null;
            goto L6
        }

        private static final void resetSwipeClick$lambda$18(OCardListItem r0, BlackVH r1, BlackListSummaryItem r2, View r3) {
            Intrinsics.checkNotNullParameter(r0, "$card");
            Intrinsics.checkNotNullParameter(r1, "this$0");
            Intrinsics.checkNotNullParameter(r2, "$entry");
            r0.swipeClose();
            r1.onItemDelete.invoke(r2);
        }
    }

    /* JADX INFO: compiled from: BlackListSummaryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$Companion;", "", "()V", "PAYLOAD_SELECTION_CHANGED", "", "PAYLOAD_SELECT_MODE_CHANGED", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: BlackListSummaryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$EmptyEntry;", "Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$Entry;", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "", "(I)V", "getHeight", "()I", "setHeight", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class EmptyEntry extends Entry {
        private int height;

        public EmptyEntry(int r2) {
            super(EntryType.Empty.INSTANCE.getType());
            this.height = r2;
        }

        public final int getHeight() {
            return this.height;
        }

        public final void setHeight(int r1) {
            this.height = r1;
        }
    }

    /* JADX INFO: compiled from: BlackListSummaryAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$EmptyVH;", "Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$VH;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "item", "Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$Entry;", "position", "", "isSelectAll", "", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class EmptyVH extends VH {
        public EmptyVH(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }

        @Override // com.obric.securitycenter.nodisturb.black.BlackListSummaryAdapter.VH
        public void bind(Entry r1, int r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r1, "item");
            if ((r1 instanceof EmptyEntry) == false) goto L9;
            View r0 = this.itemView;
            Intrinsics.checkNotNullExpressionValue(r0, "itemView");
            ViewGroup.LayoutParams r4 = r0.getLayoutParams();
            if (r4 == null) goto L8;
            r4.height = ((EmptyEntry) r1).getHeight();
            r0.setLayoutParams(r4);
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }

    /* JADX INFO: compiled from: BlackListSummaryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$Entry;", "", "type", "", "(I)V", "getType", "()I", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class Entry {
        private final int type;

        public Entry(int r1) {
            this.type = r1;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: BlackListSummaryAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$EntryType;", "", "type", "", "(I)V", "getType", "()I", "Black", "Empty", "Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$EntryType$Black;", "Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$EntryType$Empty;", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class EntryType {
        private final int type;

        /* JADX INFO: compiled from: BlackListSummaryAdapter.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$EntryType$Black;", "Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$EntryType;", "()V", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Black extends EntryType {
            public static final Black INSTANCE = null;

            static {
                INSTANCE = new Black();
            }

            private Black() {
                super(0, null);
            }
        }

        /* JADX INFO: compiled from: BlackListSummaryAdapter.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$EntryType$Empty;", "Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$EntryType;", "()V", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Empty extends EntryType {
            public static final Empty INSTANCE = null;

            static {
                INSTANCE = new Empty();
            }

            private Empty() {
                super(1, null);
            }
        }

        public /* synthetic */ EntryType(int r1, DefaultConstructorMarker r2) {
            this(r1);
        }

        private EntryType(int r1) {
            this.type = r1;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: BlackListSummaryAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "item", "Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter$Entry;", "position", "", "isSelectAll", "", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class VH extends RecyclerView.ViewHolder {
        public void bind(Entry r1, int r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r1, "item");
        }

        public VH(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    /* JADX INFO: renamed from: com.obric.securitycenter.nodisturb.black.BlackListSummaryAdapter$onCreateViewHolder$1, reason: invalid class name */
    /* JADX INFO: compiled from: BlackListSummaryAdapter.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<String, String> {
        AnonymousClass1(Object r8) {
            super(1, r8, BlackListSummaryAdapter.class, "formatPhoneNumber", "formatPhoneNumber(Ljava/lang/String;)Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(String r1) {
            return invoke2(r1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(String r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return BlackListSummaryAdapter.access$formatPhoneNumber((BlackListSummaryAdapter) this.receiver, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ String access$formatPhoneNumber(BlackListSummaryAdapter r0, String r1) {
        return r0.formatPhoneNumber(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((VH) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2, List r3) {
        onBindViewHolder((VH) r1, r2, r3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BlackListSummaryAdapter(Function1<? super BlackListSummaryItem, Unit> r2, Function2<? super BlackListSummaryItem, ? super Boolean, Unit> r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "onItemDelete");
        Intrinsics.checkNotNullParameter(r3, "onItemSelect");
        Intrinsics.checkNotNullParameter(r4, "selectAll");
        this.onItemDelete = r2;
        this.onItemSelect = r3;
        this.selectAll = r4;
        this.entries = new ArrayList();
    }

    public final void submitCursor(Cursor r13) {
        List<Entry> r0 = this.entries;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof BlackEntry) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        ArrayList r4 = new ArrayList();
        Iterator r5 = r1.iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        Object r6 = r5.next();
        if (((BlackEntry) r6).isSelected() == false) goto L10;
        r4.add(r6);
        goto L10
    L14:
        ArrayList r7 = r4;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L16:
        if (r9.hasNext() == false) goto L18;
        r8.add(Integer.valueOf(((BlackEntry) r9.next()).getItem().getId()));
        goto L16
    L18:
        Set r10 = CollectionsKt.toSet(r8);
        ArrayList r11 = new ArrayList();
        if (r13 == null) goto L36;
        int r12 = r13.getColumnIndex("bl_phone_number");
        int r14 = r13.getColumnIndex("bls_sum");
        int r15 = r13.getColumnIndex("bl_note");
        int r16 = r13.getColumnIndex("_id");
        if (r12 < 0) goto L36;
        if (r14 < 0) goto L36;
        if (r16 < 0) goto L36;
    L25:
        if (r13.moveToNext() == false) goto L36;
        String r17 = r13.getString(r12);
        String r18 = "";
        if (r17 != null) goto L29;
        r17 = "";
    L29:
        int r19 = r13.getInt(r14);
        if (r15 < 0) goto L35;
        String r20 = r13.getString(r15);
        if (r20 == null) goto L35;
        r18 = r20;
    L35:
        int r21 = (int) r13.getLong(r16);
        r11.add(new BlackEntry(new BlackListSummaryItem(r21, r18, r17, r19), r10.contains(Integer.valueOf(r21))));
    L36:
        this.entries.clear();
        this.entries.addAll(r11);
        notifyDataSetChanged();
    }

    public final void setSelectAll(boolean r5) {
        if (this.isSelectAll != r5) goto L5;
        return;
    L5:
        this.isSelectAll = r5;
        Object r0 = CollectionsKt.lastOrNull(this.entries);
        if ((r0 instanceof EmptyEntry) == false) goto L8;
        EmptyEntry r1 = (EmptyEntry) r0;
    L9:
        if (r1 == null) goto L13;
        r1.setHeight(getEmptyEntryHeight());
    L13:
        if (r5 == true) goto L25;
        List<Entry> r6 = this.entries;
        ArrayList r2 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L16:
        if (r7.hasNext() == false) goto L20;
        Object r3 = r7.next();
        if ((r3 instanceof BlackEntry) == false) goto L16;
        r2.add(r3);
        goto L16
    L20:
        Iterator r8 = r2.iterator();
    L22:
        if (r8.hasNext() == false) goto L25;
        ((BlackEntry) r8.next()).setSelected(false);
    L25:
        if (getItemCount() <= 0) goto L34;
        notifyItemRangeChanged(0, getItemCount(), "payload_select_mode_changed");
        return;
    L34:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void selectItem(List<BlackListSummaryItem> r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "targets");
        List<BlackListSummaryItem> r8 = r6;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r0.add(Integer.valueOf(((BlackListSummaryItem) r9.next()).getId()));
        goto L4
    L6:
        Set r10 = CollectionsKt.toSet(r0);
        Iterator<T> r1 = this.entries.iterator();
        int r2 = 0;
    L8:
        if (r1.hasNext() == false) goto L22;
        Object r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        Entry r5 = (Entry) r3;
        if ((r5 instanceof BlackEntry) == false) goto L15;
        BlackEntry r11 = (BlackEntry) r5;
    L16:
        if (r11 == null) goto L21;
        if (r10.contains(Integer.valueOf(r11.getItem().getId())) == false) goto L21;
        r11.setSelected(r7);
        notifyItemChanged(r2, "payload_selection_changed");
    L21:
        r2 = r4;
        goto L8
    L15:
        r11 = null;
        goto L16
    }

    private final int getEmptyEntryHeight() {
        if (this.isSelectAll == false) goto L5;
        float r2 = 160;
        DisplayMetrics r1 = Resources.getSystem().getDisplayMetrics();
    L7:
        return MathKt.roundToInt(TypedValue.applyDimension(1, r2, r1));
    L5:
        r2 = 16;
        r1 = Resources.getSystem().getDisplayMetrics();
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "parent");
        if (r10 != EntryType.Black.INSTANCE.getType()) goto L6;
        View r3 = LayoutInflater.from(r9.getContext()).inflate(R.layout.item_black_list, r9, false);
        Intrinsics.checkNotNullExpressionValue(r3, "view");
        return new BlackVH(r3, this.onItemDelete, this.onItemSelect, this.selectAll, new AnonymousClass1(this));
    L6:
        if (r10 != EntryType.Empty.INSTANCE.getType()) goto L10;
        View r8 = new View(r9.getContext());
        r8.setLayoutParams(new RecyclerView.LayoutParams(-1, 0));
        return new EmptyVH(r8);
    L10:
        throw new IllegalArgumentException("viewType not supported");
    }

    public void onBindViewHolder(VH r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        r2.bind(this.entries.get(r3), r3, this.isSelectAll);
    }

    public void onBindViewHolder(VH r3, int r4, List<Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r5, "payloads");
        if ((!r5.isEmpty()) == false) goto L10;
        Entry r0 = (Entry) CollectionsKt.getOrNull(this.entries, r4);
        if ((r3 instanceof BlackVH) == false) goto L10;
        if ((r0 instanceof BlackEntry) == false) goto L10;
        ((BlackVH) r3).bindSelectUi((BlackEntry) r0, r4, this.isSelectAll);
        return;
    L10:
        super.onBindViewHolder(r3, r4, r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.entries.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r1) {
        return this.entries.get(r1).getType();
    }

    public final List<BlackListSummaryItem> getAllItems() {
        List<Entry> r4 = this.entries;
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L14;
        Entry r1 = (Entry) r5.next();
        BlackListSummaryItem r3 = null;
        if ((r1 instanceof BlackEntry) == false) goto L8;
        BlackEntry r2 = (BlackEntry) r1;
    L9:
        if (r2 == null) goto L11;
        r3 = r2.getItem();
    L11:
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L8:
        r2 = null;
        goto L9
    L14:
        return r0;
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
