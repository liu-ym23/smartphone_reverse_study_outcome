package com.obric.oui.selection;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.icu.text.PluralRules;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.android.settings.revone.TabletDpiSettingsFragment;
import com.obric.common.oui.R;
import com.obric.oui.common.util.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: OSelectionPanelView.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001:\u0003WXYB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\f2\n\b\u0002\u00100\u001a\u0004\u0018\u000101J\u0010\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020\u0007H\u0002J\b\u00104\u001a\u00020.H\u0002J\b\u00105\u001a\u00020.H\u0002J\u0010\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0002J\b\u00108\u001a\u00020.H&J\b\u00109\u001a\u00020\nH$J\u000e\u0010:\u001a\u00020.2\u0006\u0010;\u001a\u00020\nJ0\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0014J\u0018\u0010B\u001a\u00020.2\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0014J\u0006\u0010E\u001a\u00020.J\u0010\u0010F\u001a\u00020.2\u0006\u00103\u001a\u00020\u0007H&J\u000e\u0010G\u001a\u00020.2\u0006\u0010H\u001a\u00020\u0014J.\u0010I\u001a\u00020.2\b\b\u0002\u0010J\u001a\u00020\u00072\b\b\u0002\u0010K\u001a\u00020\u00072\b\b\u0002\u0010L\u001a\u00020\u00072\b\b\u0002\u0010M\u001a\u00020\u0007J\u0014\u0010N\u001a\u00020.2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020Q0PJ\u000e\u0010R\u001a\u00020.2\u0006\u0010S\u001a\u00020\u0007J\u000e\u0010T\u001a\u00020.2\u0006\u0010U\u001a\u00020\nJ\u000e\u0010V\u001a\u00020.2\u0006\u0010U\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "theme", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allowDividersShow", "", "bottomDivider", "Landroid/view/View;", "getBottomDivider", "()Landroid/view/View;", "setBottomDivider", "(Landroid/view/View;)V", "btnContainer", "Landroid/widget/FrameLayout;", "iconLoader", "Lcom/obric/oui/selection/OSelectionPanelView$IIconLoader;", "itemContainer", "itemScrollView", "Landroidx/core/widget/NestedScrollView;", "itemViews", "", "Lcom/obric/oui/selection/OSelectionPanelItemView;", "getItemViews", "()Ljava/util/List;", "onItemSelectListener", "Lcom/obric/oui/selection/OSingleSelectionPanelView$OnItemSelectListener;", "getOnItemSelectListener", "()Lcom/obric/oui/selection/OSingleSelectionPanelView$OnItemSelectListener;", "setOnItemSelectListener", "(Lcom/obric/oui/selection/OSingleSelectionPanelView$OnItemSelectListener;)V", "onMultiItemSelectListener", "Lcom/obric/oui/selection/OMultiSelectionPanelView$OnMultiItemSelectListener;", "getOnMultiItemSelectListener", "()Lcom/obric/oui/selection/OMultiSelectionPanelView$OnMultiItemSelectListener;", "setOnMultiItemSelectListener", "(Lcom/obric/oui/selection/OMultiSelectionPanelView$OnMultiItemSelectListener;)V", "rootConstraintView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "showSelectLabel", "supportForMinHeight", "addBtnView", "", "view", "params", "Landroid/view/ViewGroup$LayoutParams;", "callConcreteItemSelected", "index", "callItemSelectListener", "callMultiItemSelectListener", "dpToPx", TabletDpiSettingsFragment.UNIT, "initHeight", "isMultiSelect", "needShowSelectLabel", "show", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "removeMinHeightConstraint", "select", "setIconLoader", "loader", "setItemMargin", "left", "top", "right", "bottom", "setItems", "items", "", "Lcom/obric/oui/selection/OSelectionPanelView$SelectionItemData;", "setScrollViewHeight", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "showBottomDivider", "allowShow", "showDividers", "DrawableIconLoader", "IIconLoader", "SelectionItemData", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OSelectionPanelView extends LinearLayout {
    private boolean allowDividersShow;
    public View bottomDivider;
    private final FrameLayout btnContainer;
    private IIconLoader iconLoader;
    private final LinearLayout itemContainer;
    private final NestedScrollView itemScrollView;
    private final List<OSelectionPanelItemView> itemViews;
    private OSingleSelectionPanelView.OnItemSelectListener onItemSelectListener;
    private OMultiSelectionPanelView.OnMultiItemSelectListener onMultiItemSelectListener;
    private final ConstraintLayout rootConstraintView;
    private boolean showSelectLabel;
    private boolean supportForMinHeight;

    /* JADX INFO: compiled from: OSelectionPanelView.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelView$DrawableIconLoader;", "Lcom/obric/oui/selection/OSelectionPanelView$IIconLoader;", "()V", "loadIcon", "", "iconImageView", "Landroid/widget/ImageView;", "data", "Lcom/obric/oui/selection/OSelectionPanelView$SelectionItemData;", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DrawableIconLoader implements IIconLoader {
        public DrawableIconLoader() {
        }

        @Override // com.obric.oui.selection.OSelectionPanelView.IIconLoader
        public void loadIcon(ImageView r1, SelectionItemData r2, Context r3) {
            Intrinsics.checkNotNullParameter(r1, "iconImageView");
            Intrinsics.checkNotNullParameter(r2, "data");
            Intrinsics.checkNotNullParameter(r3, "context");
            r1.setImageDrawable(r2.getIconDrawable());
        }
    }

    /* JADX INFO: compiled from: OSelectionPanelView.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelView$IIconLoader;", "", "loadIcon", "", "iconImageView", "Landroid/widget/ImageView;", "data", "Lcom/obric/oui/selection/OSelectionPanelView$SelectionItemData;", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IIconLoader {
        void loadIcon(ImageView r1, SelectionItemData r2, Context r3);
    }

    /* JADX INFO: compiled from: OSelectionPanelView.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelView$SelectionItemData;", "", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "title", "", "iconUrl", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;)V", "getIconDrawable", "()Landroid/graphics/drawable/Drawable;", "getIconUrl", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SelectionItemData {
        private final Drawable iconDrawable;
        private final String iconUrl;
        private final String title;

        public SelectionItemData() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ SelectionItemData copy$default(SelectionItemData r0, Drawable r1, String r2, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.iconDrawable;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.title;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.iconUrl;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final Drawable component1() {
            return this.iconDrawable;
        }

        public final String component2() {
            return this.title;
        }

        public final String component3() {
            return this.iconUrl;
        }

        public final SelectionItemData copy(Drawable r1, String r2, String r3) {
            return new SelectionItemData(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof SelectionItemData) == true) goto L8;
            return false;
        L8:
            SelectionItemData r6 = (SelectionItemData) r5;
            if (Intrinsics.areEqual(this.iconDrawable, r6.iconDrawable) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.title, r6.title) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.iconUrl, r6.iconUrl) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            Drawable r0 = this.iconDrawable;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.title;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.iconUrl;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "SelectionItemData(iconDrawable=" + this.iconDrawable + ", title=" + this.title + ", iconUrl=" + this.iconUrl + ')';
        }

        public SelectionItemData(Drawable r1, String r2, String r3) {
            this.iconDrawable = r1;
            this.title = r2;
            this.iconUrl = r3;
        }

        public /* synthetic */ SelectionItemData(Drawable r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = null;
        L11:
            this(r2, r3, r4);
        }

        public final Drawable getIconDrawable() {
            return this.iconDrawable;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getIconUrl() {
            return this.iconUrl;
        }
    }

    public static /* synthetic */ void $r8$lambda$CRf0vpWTGHxTuja7ZG9tAc4JBYE(OSelectionPanelView r0, OSelectionPanelItemView r1, int r2, View r3) {
        m1372setItems$lambda3$lambda2$lambda1(r0, r1, r2, r3);
    }

    public OSelectionPanelView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OSelectionPanelView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public abstract void initHeight();

    protected abstract boolean isMultiSelect();

    public abstract void select(int r1);

    public /* synthetic */ OSelectionPanelView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = R.style.OSelectionPanel;
    L8:
        this(r1, r2, r3);
    }

    public OSelectionPanelView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(new ContextThemeWrapper(r2, r4), r3);
        this.showSelectLabel = true;
        this.iconLoader = new DrawableIconLoader();
        this.supportForMinHeight = true;
        this.itemViews = new ArrayList();
        LinearLayout.inflate(getContext(), R.layout.o_view_selection_panel, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setOrientation(1);
        View r5 = findViewById(R.id.item_container);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.item_container)");
        this.itemContainer = (LinearLayout) r5;
        View r6 = findViewById(R.id.btn_container);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.btn_container)");
        this.btnContainer = (FrameLayout) r6;
        View r7 = findViewById(R.id.item_scroll_view);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.item_scroll_view)");
        this.itemScrollView = (NestedScrollView) r7;
        View r8 = findViewById(R.id.root_constraint);
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.root_constraint)");
        this.rootConstraintView = (ConstraintLayout) r8;
        View r9 = findViewById(R.id.bottom_divider);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.bottom_divider)");
        setBottomDivider(r9);
    }

    public final View getBottomDivider() {
        View r0 = this.bottomDivider;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("bottomDivider");
        return null;
    }

    public final void setBottomDivider(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.bottomDivider = r2;
    }

    protected final List<OSelectionPanelItemView> getItemViews() {
        return this.itemViews;
    }

    protected final OSingleSelectionPanelView.OnItemSelectListener getOnItemSelectListener() {
        return this.onItemSelectListener;
    }

    protected final void setOnItemSelectListener(OSingleSelectionPanelView.OnItemSelectListener r1) {
        this.onItemSelectListener = r1;
    }

    protected final OMultiSelectionPanelView.OnMultiItemSelectListener getOnMultiItemSelectListener() {
        return this.onMultiItemSelectListener;
    }

    protected final void setOnMultiItemSelectListener(OMultiSelectionPanelView.OnMultiItemSelectListener r1) {
        this.onMultiItemSelectListener = r1;
    }

    public static /* synthetic */ void addBtnView$default(OSelectionPanelView r0, View r1, ViewGroup.LayoutParams r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.addBtnView(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addBtnView");
    }

    public final void addBtnView(View r2, ViewGroup.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if (r3 != null) goto L5;
        this.btnContainer.addView(r2);
        return;
    L5:
        this.btnContainer.addView(r2, r3);
    }

    public final void showDividers(boolean r1) {
        this.allowDividersShow = r1;
    }

    public final void needShowSelectLabel(boolean r1) {
        this.showSelectLabel = r1;
    }

    public final void showBottomDivider(boolean r1) {
        if (r1 == false) goto L4;
        getBottomDivider().setVisibility(0);
        return;
    L4:
        getBottomDivider().setVisibility(8);
    }

    public final void setItems(List<SelectionItemData> r14) {
        Intrinsics.checkNotNullParameter(r14, "items");
        Iterator<T> r15 = r14.iterator();
        final int r0 = 0;
    L4:
        if (r15.hasNext() == false) goto L15;
        Object r1 = r15.next();
        int r2 = r0 + 1;
        if (r0 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        SelectionItemData r3 = (SelectionItemData) r1;
        List<OSelectionPanelItemView> r4 = getItemViews();
        Context r5 = getContext();
        Intrinsics.checkNotNullExpressionValue(r5, "context");
        final OSelectionPanelItemView r11 = new OSelectionPanelItemView(r5, null, false, this.allowDividersShow, 6, null);
        r11.setSelectMode(isMultiSelect());
        r11.showSelectLabel(this.showSelectLabel);
        if (r3.getIconDrawable() == null) goto L11;
    L13:
        ViewExtensionsKt.makeVisible(r11.getIconView());
        IIconLoader r6 = this.iconLoader;
        ImageView r7 = r11.getIconView();
        Context r8 = r11.getContext();
        Intrinsics.checkNotNullExpressionValue(r8, "context");
        r6.loadIcon(r7, r3, r8);
    L14:
        r11.getTextView().setText(r3.getTitle());
        r11.setOnClickListener(new OSelectionPanelView$$ExternalSyntheticLambda0(this, r11, r0));
        this.itemContainer.addView(r11);
        r4.add(r11);
        r0 = r2;
        goto L4
    L11:
        if (TextUtils.isEmpty(r3.getIconUrl()) == false) goto L13;
        ViewExtensionsKt.makeGone(r11.getIconView());
        goto L14
    L15:
        ((OSelectionPanelItemView) CollectionsKt.last(this.itemViews)).dismissDivider();
        initHeight();
    }

    /* JADX INFO: renamed from: setItems$lambda-3$lambda-2$lambda-1, reason: not valid java name */
    private static final void m1372setItems$lambda3$lambda2$lambda1(OSelectionPanelView r1, OSelectionPanelItemView r2, int r3, View r4) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$this_apply");
        if (r1.isMultiSelect() == false) goto L8;
        r2.setItemSelected(!r2.isItemSelected());
        r1.callMultiItemSelectListener();
        if (r2.isItemSelected() == false) goto L16;
        r1.callConcreteItemSelected(r3);
        return;
    L16:
        return;
    L8:
        if (r2.isItemSelected() == true) goto L13;
        Iterator<T> r5 = r1.itemViews.iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        OSelectionPanelItemView r6 = (OSelectionPanelItemView) r5.next();
        r6.setItemSelected(Intrinsics.areEqual(r4, r6));
    L13:
        r1.callItemSelectListener();
    }

    public final void setScrollViewHeight(int r4) {
        ConstraintLayout.LayoutParams r0 = new ConstraintLayout.LayoutParams(-1, r4);
        if (this.itemViews.size() < 4) goto L5;
    L7:
        this.itemScrollView.setLayoutParams(r0);
        return;
    L5:
        if (this.supportForMinHeight == false) goto L7;
        ConstraintLayout.LayoutParams r5 = new ConstraintLayout.LayoutParams(-1, -2);
        r5.topToBottom = -1;
        r5.bottomToBottom = 0;
        this.btnContainer.setLayoutParams(r5);
        r0.bottomToTop = -1;
        goto L7
    }

    private final void callItemSelectListener() {
        if (isMultiSelect() == false) goto L5;
        return;
    L5:
        if (this.onItemSelectListener == null) goto L24;
        Iterator<T> r0 = this.itemViews.iterator();
        int r1 = 0;
    L8:
        if (r0.hasNext() == false) goto L25;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        OSelectionPanelItemView r4 = (OSelectionPanelItemView) r2;
        if (r4.isItemSelected() == true) goto L14;
        r1 = r3;
        goto L8
    L14:
        OSingleSelectionPanelView.OnItemSelectListener r5 = getOnItemSelectListener();
        if (r5 == null) goto L23;
        r5.onItemSelected(r4, r1);
        return;
    L23:
        return;
    L25:
        return;
    }

    private final void callMultiItemSelectListener() {
        if (isMultiSelect() == true) goto L5;
        return;
    L5:
        if (this.onMultiItemSelectListener == null) goto L25;
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = this.itemViews.iterator();
        int r3 = 0;
    L8:
        if (r2.hasNext() == false) goto L16;
        Object r4 = r2.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        OSelectionPanelItemView r6 = (OSelectionPanelItemView) r4;
        if (r6.isItemSelected() == false) goto L15;
        r0.add(r6);
        r1.add(Integer.valueOf(r3));
    L15:
        r3 = r5;
        goto L8
    L16:
        OMultiSelectionPanelView.OnMultiItemSelectListener r7 = this.onMultiItemSelectListener;
        if (r7 == null) goto L26;
        r7.onItemsSelected(r0, r1);
        return;
    L26:
        return;
    }

    private final void callConcreteItemSelected(int r1) {
        OMultiSelectionPanelView.OnMultiItemSelectListener r0 = this.onMultiItemSelectListener;
        if (r0 == null) goto L7;
        r0.onConcreteItemSelected(r1);
        return;
    }

    public final void setIconLoader(IIconLoader r2) {
        Intrinsics.checkNotNullParameter(r2, "loader");
        this.iconLoader = r2;
    }

    public final void removeMinHeightConstraint() {
        this.rootConstraintView.setMinHeight(0);
        this.rootConstraintView.setMinimumHeight(0);
        this.supportForMinHeight = false;
    }

    public static /* synthetic */ void setItemMargin$default(OSelectionPanelView r1, int r2, int r3, int r4, int r5, int r6, Object r7) {
        if (r7 != null) goto L18;
        if ((r6 & 1) == 0) goto L7;
        r2 = 0;
    L7:
        if ((r6 & 2) == 0) goto L10;
        r3 = 0;
    L10:
        if ((r6 & 4) == 0) goto L13;
        r4 = 0;
    L13:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.dpToPx(12);
    L15:
        r1.setItemMargin(r2, r3, r4, r5);
        return;
    L18:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setItemMargin");
    }

    public final void setItemMargin(int r3, int r4, int r5, int r6) {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(this.rootConstraintView.getLayoutParams());
        r0.setMargins(r3, r4, r5, r6);
        this.rootConstraintView.setLayoutParams(r0);
        this.rootConstraintView.requestLayout();
    }

    private final int dpToPx(int r1) {
        return MathKt.roundToInt(getResources().getDisplayMetrics().density * r1);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
