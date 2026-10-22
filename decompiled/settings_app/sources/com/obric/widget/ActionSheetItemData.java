package com.obric.widget;

import android.graphics.drawable.Drawable;
import android.icu.text.PluralRules;
import com.obric.oui.selection.OActionSheet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionSheetAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/obric/widget/ActionSheetItemData;", "", "style", "Lcom/obric/oui/selection/OActionSheet$Companion$ItemStyle;", "icon", "Landroid/graphics/drawable/Drawable;", "title", "", "titleTextColor", "", "(Lcom/obric/oui/selection/OActionSheet$Companion$ItemStyle;Landroid/graphics/drawable/Drawable;Ljava/lang/String;I)V", "getIcon", "()Landroid/graphics/drawable/Drawable;", "getStyle", "()Lcom/obric/oui/selection/OActionSheet$Companion$ItemStyle;", "getTitle", "()Ljava/lang/String;", "getTitleTextColor", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ActionSheetItemData {
    private final Drawable icon;
    private final OActionSheet.Companion.ItemStyle style;
    private final String title;
    private final int titleTextColor;

    public static /* synthetic */ ActionSheetItemData copy$default(ActionSheetItemData r0, OActionSheet.Companion.ItemStyle r1, Drawable r2, String r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.style;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.icon;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.title;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.titleTextColor;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final OActionSheet.Companion.ItemStyle component1() {
        return this.style;
    }

    public final Drawable component2() {
        return this.icon;
    }

    public final String component3() {
        return this.title;
    }

    public final int component4() {
        return this.titleTextColor;
    }

    public final ActionSheetItemData copy(OActionSheet.Companion.ItemStyle r1, Drawable r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "style");
        Intrinsics.checkNotNullParameter(r3, "title");
        return new ActionSheetItemData(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ActionSheetItemData) == true) goto L8;
        return false;
    L8:
        ActionSheetItemData r6 = (ActionSheetItemData) r5;
        if (this.style == r6.style) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L18;
        return false;
    L18:
        if (this.titleTextColor == r6.titleTextColor) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.style.hashCode() * 31;
        Drawable r1 = this.icon;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.titleTextColor);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ActionSheetItemData(style=" + this.style + ", icon=" + this.icon + ", title=" + this.title + ", titleTextColor=" + this.titleTextColor + ')';
    }

    public ActionSheetItemData(OActionSheet.Companion.ItemStyle r2, Drawable r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "style");
        Intrinsics.checkNotNullParameter(r4, "title");
        this.style = r2;
        this.icon = r3;
        this.title = r4;
        this.titleTextColor = r5;
    }

    public /* synthetic */ ActionSheetItemData(OActionSheet.Companion.ItemStyle r1, Drawable r2, String r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, r3, r4);
    }

    public final OActionSheet.Companion.ItemStyle getStyle() {
        return this.style;
    }

    public final Drawable getIcon() {
        return this.icon;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTitleTextColor() {
        return this.titleTextColor;
    }
}
