package com.obric.oui.popover.menu;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedanceos.security.Utils;
import com.obric.common.oui.R;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.popover.view.CheckableImageView;
import com.obric.oui.text.OTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OPopoverFilterMenuView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002\"#B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J(\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0014J\u000e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0007R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverFilterMenuView;", "Lcom/obric/oui/popover/menu/OPopoverMenuView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "itemContainers", "", "Landroid/view/ViewGroup;", "itemHeight", "itemVerticalMargin", "itemWidth", "items", "Ljava/util/ArrayList;", "Lcom/obric/oui/popover/menu/OPopoverFilterMenuView$PopoverItem;", "Lkotlin/collections/ArrayList;", "radioMap", "", "Lcom/obric/oui/popover/view/CheckableImageView;", "topDividerVisibility", "", "addPopoverItems", "", "initView", "onSizeChanged", "w", "h", "oldw", "oldh", "selectItem", Utils.INTENT_KEY_INDEX, "Builder", "PopoverItem", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverFilterMenuView extends OPopoverMenuView {
    private List<ViewGroup> itemContainers;
    private int itemHeight;
    private final int itemVerticalMargin;
    private int itemWidth;
    private ArrayList<PopoverItem> items;
    private Map<Integer, CheckableImageView> radioMap;
    private boolean topDividerVisibility;

    /* JADX INFO: compiled from: OPopoverFilterMenuView.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Jt\u0010\u0012\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142#\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2%\b\u0002\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0016H\u0007J\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010\u000f\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0010J\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010#\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverFilterMenuView$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "itemHeight", "", "itemWidth", "popoverItems", "Ljava/util/ArrayList;", "Lcom/obric/oui/popover/menu/OPopoverFilterMenuView$PopoverItem;", "Lkotlin/collections/ArrayList;", "pressedWithArrow", "", "topDividerVisibility", "addItem", "title", "", "onChecked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", Utils.INTENT_KEY_INDEX, "", "isSelected", "typeFace", "Landroid/graphics/Typeface;", "onClicked", "build", "Lcom/obric/oui/popover/menu/OPopoverFilterMenuView;", "enable", "setItemHeight", "setItemWidth", "setTopDividerVisibility", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private Context context;
        private int itemHeight;
        private int itemWidth;
        private ArrayList<PopoverItem> popoverItems;
        private boolean pressedWithArrow;
        private boolean topDividerVisibility;

        public final Builder addItem(CharSequence r9, Function1<? super Integer, Unit> r10) {
            return addItem$default(this, r9, r10, false, null, null, 28, null);
        }

        public final Builder addItem(CharSequence r9, Function1<? super Integer, Unit> r10, boolean r11) {
            return addItem$default(this, r9, r10, r11, null, null, 24, null);
        }

        public final Builder addItem(CharSequence r9, Function1<? super Integer, Unit> r10, boolean r11, Typeface r12) {
            return addItem$default(this, r9, r10, r11, r12, null, 16, null);
        }

        public Builder(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.context = r2;
            this.popoverItems = new ArrayList();
            this.itemWidth = OUnitExtensionKt.cdp(this.context, 188);
            this.itemHeight = OUnitExtensionKt.cdp(this.context, 44);
        }

        public final Context getContext() {
            return this.context;
        }

        public final void setContext(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.context = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder addItem$default(Builder r6, CharSequence r7, Function1 r8, boolean r9, Typeface r10, Function1 r11, int r12, Object r13) {
            if ((r12 & 4) == 0) goto L5;
            r9 = false;
        L5:
            boolean r3 = r9;
            if ((r12 & 8) == 0) goto L8;
            Typeface r4 = null;
        L10:
            if ((r12 & 16) == 0) goto L12;
            Function1 r5 = null;
        L14:
            return r6.addItem(r7, r8, r3, r4, r5);
        L12:
            r5 = r11;
            goto L14
        L8:
            r4 = r10;
            goto L10
        }

        public final Builder addItem(CharSequence r9, Function1<? super Integer, Unit> r10, boolean r11, Typeface r12, Function1<? super Integer, Unit> r13) {
            this.popoverItems.add(new PopoverItem(r9, r11, r10, r12, r13));
            return this;
        }

        public final void pressedWithArrow(boolean r1) {
            this.pressedWithArrow = r1;
        }

        public final void setItemWidth(int r1) {
            this.itemWidth = r1;
        }

        public final void setItemHeight(int r1) {
            this.itemHeight = r1;
        }

        public final void setTopDividerVisibility(boolean r1) {
            this.topDividerVisibility = r1;
        }

        public final OPopoverFilterMenuView build() {
            OPopoverFilterMenuView r6 = new OPopoverFilterMenuView(this.context, null, 0, 6, null);
            OPopoverFilterMenuView.access$setItems$p(r6, this.popoverItems);
            r6.setPressedWithArrow(this.pressedWithArrow);
            OPopoverFilterMenuView.access$setTopDividerVisibility$p(r6, this.topDividerVisibility);
            OPopoverFilterMenuView.access$setItemHeight$p(r6, this.itemHeight);
            OPopoverFilterMenuView.access$setItemWidth$p(r6, this.itemWidth);
            OPopoverFilterMenuView.access$initView(r6);
            return r6;
        }
    }

    /* JADX INFO: compiled from: OPopoverFilterMenuView.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0002\u0018\u00002\u00020\u0001Bs\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\u0002\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0011\"\u0004\b\u0012\u0010\u0013R7\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R7\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverFilterMenuView$PopoverItem;", "", "title", "", "isSelected", "", "onChecked", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", Utils.INTENT_KEY_INDEX, "", "typeFace", "Landroid/graphics/Typeface;", "onClicked", "(Ljava/lang/CharSequence;ZLkotlin/jvm/functions/Function1;Landroid/graphics/Typeface;Lkotlin/jvm/functions/Function1;)V", "()Z", "setSelected", "(Z)V", "getOnChecked", "()Lkotlin/jvm/functions/Function1;", "setOnChecked", "(Lkotlin/jvm/functions/Function1;)V", "getOnClicked", "setOnClicked", "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "getTypeFace", "()Landroid/graphics/Typeface;", "setTypeFace", "(Landroid/graphics/Typeface;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class PopoverItem {
        private boolean isSelected;
        private Function1<? super Integer, Unit> onChecked;
        private Function1<? super Integer, Unit> onClicked;
        private CharSequence title;
        private Typeface typeFace;

        public PopoverItem(CharSequence r1, boolean r2, Function1<? super Integer, Unit> r3, Typeface r4, Function1<? super Integer, Unit> r5) {
            this.title = r1;
            this.isSelected = r2;
            this.onChecked = r3;
            this.typeFace = r4;
            this.onClicked = r5;
        }

        public /* synthetic */ PopoverItem(CharSequence r7, boolean r8, Function1 r9, Typeface r10, Function1 r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 2) == 0) goto L5;
            r8 = false;
        L5:
            boolean r2 = r8;
            if ((r12 & 4) == 0) goto L8;
            Function1 r3 = null;
        L10:
            if ((r12 & 8) == 0) goto L12;
            Typeface r4 = null;
        L14:
            if ((r12 & 16) == 0) goto L16;
            Function1 r5 = null;
        L17:
            this(r7, r2, r3, r4, r5);
            return;
        L16:
            r5 = r11;
            goto L17
        L12:
            r4 = r10;
            goto L14
        L8:
            r3 = r9;
            goto L10
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final void setTitle(CharSequence r1) {
            this.title = r1;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public final void setSelected(boolean r1) {
            this.isSelected = r1;
        }

        public final Function1<Integer, Unit> getOnChecked() {
            return this.onChecked;
        }

        public final void setOnChecked(Function1<? super Integer, Unit> r1) {
            this.onChecked = r1;
        }

        public final Typeface getTypeFace() {
            return this.typeFace;
        }

        public final void setTypeFace(Typeface r1) {
            this.typeFace = r1;
        }

        public final Function1<Integer, Unit> getOnClicked() {
            return this.onClicked;
        }

        public final void setOnClicked(Function1<? super Integer, Unit> r1) {
            this.onClicked = r1;
        }
    }

    public static /* synthetic */ void $r8$lambda$fXvcNg9SnAaqoYaKctC2eVOq1Hs(OPopoverFilterMenuView r0, int r1, PopoverItem r2, View r3) {
        m440addPopoverItems$lambda1$lambda0(r0, r1, r2, r3);
    }

    public OPopoverFilterMenuView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OPopoverFilterMenuView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OPopoverFilterMenuView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ void access$initView(OPopoverFilterMenuView r0) {
        r0.initView();
    }

    public static final /* synthetic */ void access$setItemHeight$p(OPopoverFilterMenuView r0, int r1) {
        r0.itemHeight = r1;
    }

    public static final /* synthetic */ void access$setItemWidth$p(OPopoverFilterMenuView r0, int r1) {
        r0.itemWidth = r1;
    }

    public static final /* synthetic */ void access$setItems$p(OPopoverFilterMenuView r0, ArrayList r1) {
        r0.items = r1;
    }

    public static final /* synthetic */ void access$setTopDividerVisibility$p(OPopoverFilterMenuView r0, boolean r1) {
        r0.topDividerVisibility = r1;
    }

    public OPopoverFilterMenuView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.items = new ArrayList();
        this.radioMap = new LinkedHashMap();
        this.itemContainers = new ArrayList();
        OPopoverFilterMenuView r5 = this;
        this.itemVerticalMargin = OUnitExtensionKt.vdp(r5, 4);
        this.itemWidth = OUnitExtensionKt.vdp(r5, 188);
        this.itemHeight = (int) r2.getResources().getDimension(R.dimen.oui_h_list_item_menu);
    }

    private final void initView() {
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(this.itemWidth, this.itemHeight));
        addPopoverItems();
    }

    public final void selectItem(int r3) {
        Iterator<Map.Entry<Integer, CheckableImageView>> r2 = this.radioMap.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        Map.Entry<Integer, CheckableImageView> r0 = r2.next();
        int r1 = r0.getKey().intValue();
        CheckableImageView r4 = r0.getValue();
        if (r3 != r1) goto L8;
        boolean r5 = true;
    L9:
        r4.setChecked(r5);
        goto L4
    L8:
        r5 = false;
        goto L9
    }

    private final void addPopoverItems() {
        Iterator<T> r0 = this.items.iterator();
        final int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L34;
        Object r3 = r0.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        final PopoverItem r5 = (PopoverItem) r3;
        View r6 = LayoutInflater.from(getContext()).inflate(R.layout.o_item_popover_menu_filter, this, false);
        if (r6 == null) goto L33;
        PopoverMenuLinearLayout r7 = (PopoverMenuLinearLayout) r6;
        OStateGradientDrawable r8 = new OStateGradientDrawable();
        OPopoverFilterMenuView r9 = this;
        r8.setCornerRadius(OUnitExtensionKt.vdp(r9, 20));
        ColorStateList r10 = ContextCompat.getColorStateList(getContext(), R.color.o_pop_list_item_bg_color);
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNullExpressionValue(r10, "getColorStateList(contex…pop_list_item_bg_color)!!");
        r8.setSolidColors(r10);
        r7.setBackground(r8);
        LinearLayout r11 = new LinearLayout(getContext());
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(this.itemWidth, this.itemHeight);
        ViewGroup r13 = (ViewGroup) r7.findViewById(R.id.item_container);
        CheckableImageView r14 = (CheckableImageView) r7.findViewById(R.id.popover_menu_radio);
        OTextView r15 = (OTextView) r7.findViewById(R.id.tv_popover_action);
        List<ViewGroup> r16 = this.itemContainers;
        Intrinsics.checkNotNullExpressionValue(r13, "itemContainer");
        r16.add(r13);
        r7.setOnClickListener(new OPopoverFilterMenuView$$ExternalSyntheticLambda0(this, r2, r5));
        if (this.topDividerVisibility == false) goto L16;
        View r17 = r7.findViewById(R.id.top_divider);
        r17.setVisibility(0);
        if (r2 != 0) goto L16;
        r17.setVisibility(4);
    L16:
        if (this.items.size() != 1) goto L19;
        r7.setIndexPos(PopoverMenuLinearLayout.Index.ONLY_ONE);
        r12.setMargins(0, 0, 0, 0);
    L25:
        registerPressedCallback(r7);
        if (r5.getTitle() == null) goto L29;
        r15.setText(r5.getTitle());
    L29:
        if (r5.getTypeFace() == null) goto L31;
        r15.setTypeface(r5.getTypeFace());
    L31:
        r14.setChecked(r5.isSelected());
        r14.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.oui_accent_7)));
        Map<Integer, CheckableImageView> r18 = this.radioMap;
        Integer r19 = Integer.valueOf(r2);
        Intrinsics.checkNotNullExpressionValue(r14, "radio");
        r18.put(r19, r14);
        LinearLayout.LayoutParams r20 = new LinearLayout.LayoutParams(-1, -2);
        r20.leftMargin = OUnitExtensionKt.vdp(r9, 8);
        r20.rightMargin = OUnitExtensionKt.vdp(r9, 8);
        r7.setLayoutParams(r20);
        r11.setLayoutParams(r12);
        r11.addView(r7);
        addView(r11);
        r2 = r4;
        goto L4
    L19:
        if (r2 != (this.items.size() - 1)) goto L21;
        r7.setIndexPos(PopoverMenuLinearLayout.Index.LAST);
        r12.setMargins(0, 0, 0, 0);
        goto L25
    L21:
        if (r2 < 0) goto L25;
        if (r2 != 0) goto L24;
        r7.setIndexPos(PopoverMenuLinearLayout.Index.FIRST);
    L24:
        r12.setMargins(0, 0, 0, this.itemVerticalMargin);
        goto L25
    L33:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.menu.PopoverMenuLinearLayout");
    }

    /* JADX INFO: renamed from: addPopoverItems$lambda-1$lambda-0, reason: not valid java name */
    private static final void m440addPopoverItems$lambda1$lambda0(OPopoverFilterMenuView r0, int r1, PopoverItem r2, View r3) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$item");
        r0.selectItem(r1);
        Function1<Integer, Unit> r4 = r2.getOnClicked();
        if (r4 == null) goto L7;
        r4.invoke(Integer.valueOf(r1));
        return;
    }

    @Override // com.obric.oui.popover.menu.OPopoverMenuView, android.view.View
    protected void onSizeChanged(int r5, int r6, int r7, int r8) {
        super.onSizeChanged(r5, r6, r7, r8);
        Iterator<T> r4 = this.itemContainers.iterator();
    L4:
        if (r4.hasNext() == false) goto L24;
        ViewGroup r9 = (ViewGroup) r4.next();
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if (r10 == null) goto L23;
        ViewGroup.LayoutParams r11 = r9.getLayoutParams();
        ViewGroup.LayoutParams r1 = null;
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == true) goto L10;
        r11 = null;
    L10:
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        int r0 = 0;
        if (r12 == null) goto L13;
        int r13 = r12.leftMargin;
    L14:
        int r14 = r5 - r13;
        ViewGroup.LayoutParams r2 = r9.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        r1 = r2;
    L18:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r1;
        if (r3 == null) goto L21;
        r0 = r3.rightMargin;
    L21:
        r10.width = r14 - r0;
        r9.setLayoutParams(r10);
        goto L4
    L13:
        r13 = 0;
        goto L14
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
