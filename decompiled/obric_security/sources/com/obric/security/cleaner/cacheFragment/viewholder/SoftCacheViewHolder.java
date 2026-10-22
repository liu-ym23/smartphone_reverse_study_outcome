package com.obric.security.cleaner.cacheFragment.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedanceos.oui.OCardListItemExtKt;
import com.obric.oui.button.OIconButton;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OBaseTextView;
import com.obric.security.R;
import com.obric.security.cleaner.CleanerDetailViewModel;
import com.obric.security.cleaner.RubbishEntityWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.fg.module.cleanV2.RubbishEntity;

/* JADX INFO: compiled from: SoftCacheViewHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/security/cleaner/cacheFragment/viewholder/SoftCacheViewHolder;", "Lcom/obric/security/cleaner/cacheFragment/viewholder/RubbishBaseViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Lcom/obric/oui/checkbox/OCheckBox;", "getCheckBox", "()Lcom/obric/oui/checkbox/OCheckBox;", "setCheckBox", "(Lcom/obric/oui/checkbox/OCheckBox;)V", "viewModel", "Lcom/obric/security/cleaner/CleanerDetailViewModel;", "createSubItemView", "entity", "Ltmsdk/fg/module/cleanV2/RubbishEntity;", "onBind", "", "data", "Lcom/obric/security/cleaner/RubbishEntityWrapper;", "updateSubItemCheckState", "isChecked", "", "updateSummary", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public class SoftCacheViewHolder extends RubbishBaseViewHolder {
    private OCheckBox checkBox;
    private CleanerDetailViewModel viewModel;

    public SoftCacheViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    public static final /* synthetic */ CleanerDetailViewModel access$getViewModel$p(SoftCacheViewHolder r0) {
        return r0.viewModel;
    }

    public static final /* synthetic */ void access$setViewModel$p(SoftCacheViewHolder r0, CleanerDetailViewModel r1) {
        r0.viewModel = r1;
    }

    public static final /* synthetic */ void access$updateSubItemCheckState(SoftCacheViewHolder r0, boolean r1) {
        r0.updateSubItemCheckState(r1);
    }

    public static final /* synthetic */ void access$updateSummary(SoftCacheViewHolder r0, RubbishEntity r1) {
        r0.updateSummary(r1);
    }

    public final OCheckBox getCheckBox() {
        return this.checkBox;
    }

    public final void setCheckBox(OCheckBox r1) {
        this.checkBox = r1;
    }

    public final void onBind(RubbishEntityWrapper r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        onBind(r2.getEntity());
    }

    @Override // com.obric.security.cleaner.cacheFragment.viewholder.RubbishBaseViewHolder
    public void onBind(final RubbishEntity r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        super.onBind(r6);
        View r0 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r0, "itemView");
        Object r1 = r0.getContext();
        CleanerDetailViewModel r3 = null;
        if ((r1 instanceof ViewModelStoreOwner) == true) goto L5;
        r1 = null;
    L5:
        ViewModelStoreOwner r2 = (ViewModelStoreOwner) r1;
        if (r2 == null) goto L8;
        r3 = (CleanerDetailViewModel) new ViewModelProvider(r2).get(CleanerDetailViewModel.class);
    L8:
        this.viewModel = r3;
        setSubItem((LinearLayout) this.itemView.findViewById(R.id.sub_item));
        LinearLayout r4 = getSubItem();
        if (r4 == null) goto L11;
        r4.removeAllViews();
    L11:
        OCardListItem r5 = getOCardListItem();
        if (r5 == null) goto L14;
        r5.setVisibility(8);
    L14:
        RelativeLayout r7 = getTitleApp();
        Intrinsics.checkNotNullExpressionValue(r7, "titleApp");
        r7.setVisibility(0);
        OIconButton r8 = getIconImageView();
        View r9 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r9, "itemView");
        r8.setImageDrawable(r9.getContext().getDrawable(R.drawable.null_app_icon));
        OBaseTextView r10 = getSizeApp();
        Intrinsics.checkNotNullExpressionValue(r10, "sizeApp");
        r10.setText(getSizeString(r6.getSize()));
        OBaseTextView r11 = getNameTextApp();
        Intrinsics.checkNotNullExpressionValue(r11, "nameTextApp");
        r11.setText(r6.getAppName());
        OCardListItem r12 = getOCardListItem();
        if (r12 == null) goto L17;
        r12.showTitle(true);
    L17:
        OCheckBox r13 = getAppAllCheck();
        this.checkBox = r13;
        if (r13 == null) goto L24;
        CleanerDetailViewModel r14 = this.viewModel;
        if (r14 == null) goto L22;
        boolean r15 = r14.isSelected(r6);
    L23:
        r13.setChecked(r15);
        goto L24
    L22:
        r15 = false;
    L24:
        RelativeLayout r16 = getTitleApp();
        if (r16 == null) goto L27;
        r16.setOnClickListener(new ViewOnClickListenerC03662(this, r6));
    L27:
        OCheckBox r17 = this.checkBox;
        if (r17 == null) goto L30;
        r17.setOnClickListener(new AnonymousClass3(this, r6));
    L30:
        LinearLayout r18 = getSubItem();
        if (r18 == null) goto L33;
        r18.setVisibility(0);
    L33:
        LinearLayout r19 = getSubItem();
        if (r19 == null) goto L37;
        r19.addView(createSubItemView(r6));
        return;
    }

    private final void updateSubItemCheckState(boolean r6) {
        LinearLayout r0 = getSubItem();
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.getChildCount());
    L6:
        Intrinsics.checkNotNull(r1);
        int r2 = r1.intValue();
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L21;
        LinearLayout r4 = getSubItem();
        if (r4 == null) goto L11;
        View r5 = r4.getChildAt(r3);
    L12:
        if (r5 == null) goto L14;
        OCardListItem r7 = (OCardListItem) r5.findViewById(R.id.oCard_list_item);
    L15:
        if (r7 == null) goto L17;
        OCheckBoxLayout r8 = r7.getStartCheckBox();
    L18:
        if (r8 == null) goto L20;
        r8.setChecked(r6);
    L20:
        r3 = r3 + 1;
        goto L7
    L17:
        r8 = null;
        goto L18
    L14:
        r7 = null;
        goto L15
    L11:
        r5 = null;
        goto L12
    L21:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final View createSubItemView(final RubbishEntity r8) {
        View r0 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r0, "itemView");
        View r1 = View.inflate(r0.getContext(), R.layout.processes_sub_list_item_ocard, null);
        Intrinsics.checkNotNullExpressionValue(r1, "view");
        r1.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        View r2 = r1.findViewById(R.id.oCard_list_item);
        Intrinsics.checkNotNullExpressionValue(r2, "view.findViewById<OCardL…em>(R.id.oCard_list_item)");
        OCardListItem r3 = (OCardListItem) r2;
        r3.setDefaultCustomStartView(0);
        r3.showCustomStart(true);
        final OCheckBoxLayout r4 = r3.getStartCheckBox();
        if (r4 == null) goto L9;
        CleanerDetailViewModel r5 = this.viewModel;
        if (r5 == null) goto L7;
        boolean r6 = r5.isSelected(r8);
    L8:
        r4.setChecked(r6);
        goto L9
    L7:
        r6 = false;
    L9:
        r3.setTitle(r8.getDescription());
        OCardListItemExtKt.setEndText(r3, getSizeString(r8.getSize()));
        OCardListItemExtKt.setStartView(r3, r4);
        OCardListItem.setCardPosition$default(r3, 0, false, 2, null);
        r3.setCardType(0);
        if (r4 == null) goto L12;
        r4.setOnCheckedChangeListener(new AnonymousClass1(this, r8));
    L12:
        r3.setOnContentClickListener(new AnonymousClass2(this, r4, r8));
        return r1;
    }

    private final void updateSummary(RubbishEntity r4) {
        OCheckBox r0 = this.checkBox;
        if (r0 == null) goto L9;
        CleanerDetailViewModel r1 = this.viewModel;
        if (r1 == null) goto L7;
        boolean r2 = r1.isSelected(r4);
    L8:
        r0.setChecked(r2);
        goto L9
    L7:
        r2 = false;
    L9:
        OCheckBox r3 = this.checkBox;
        if (r3 == null) goto L12;
        Boolean r5 = Boolean.valueOf(r3.isChecked());
    L13:
        Intrinsics.checkNotNull(r5);
        if (r5.booleanValue() == false) goto L18;
        OBaseTextView r6 = getSizeApp();
        if (r6 == null) goto L22;
        r6.setText(getSizeString(r4.getSize()));
        return;
    L22:
        return;
    L18:
        OBaseTextView r7 = getSizeApp();
        if (r7 == null) goto L24;
        r7.setText("0 B");
        return;
    L24:
        return;
    L12:
        r5 = null;
        goto L13
    }
}
