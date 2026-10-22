package com.obric.oui.window.bean;

import android.icu.text.PluralRules;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PageGridConfig.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/window/bean/PageGridConfig;", "", "gridMode", "", "pageColumns", "Lcom/obric/oui/window/bean/PageColumns;", "pageGutter", "Lcom/obric/oui/window/bean/PageGutter;", "pageMargin", "Lcom/obric/oui/window/bean/PageMargin;", "(Ljava/lang/String;Lcom/obric/oui/window/bean/PageColumns;Lcom/obric/oui/window/bean/PageGutter;Lcom/obric/oui/window/bean/PageMargin;)V", "getGridMode", "()Ljava/lang/String;", "getPageColumns", "()Lcom/obric/oui/window/bean/PageColumns;", "getPageGutter", "()Lcom/obric/oui/window/bean/PageGutter;", "getPageMargin", "()Lcom/obric/oui/window/bean/PageMargin;", "component1", "component2", "component3", "component4", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PageGridConfig {
    private final String gridMode;
    private final PageColumns pageColumns;
    private final PageGutter pageGutter;
    private final PageMargin pageMargin;

    public static /* synthetic */ PageGridConfig copy$default(PageGridConfig r0, String r1, PageColumns r2, PageGutter r3, PageMargin r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.gridMode;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.pageColumns;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.pageGutter;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.pageMargin;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.gridMode;
    }

    public final PageColumns component2() {
        return this.pageColumns;
    }

    public final PageGutter component3() {
        return this.pageGutter;
    }

    public final PageMargin component4() {
        return this.pageMargin;
    }

    public final PageGridConfig copy(String r1, PageColumns r2, PageGutter r3, PageMargin r4) {
        Intrinsics.checkNotNullParameter(r1, "gridMode");
        Intrinsics.checkNotNullParameter(r2, "pageColumns");
        Intrinsics.checkNotNullParameter(r3, "pageGutter");
        Intrinsics.checkNotNullParameter(r4, "pageMargin");
        return new PageGridConfig(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PageGridConfig) == true) goto L8;
        return false;
    L8:
        PageGridConfig r6 = (PageGridConfig) r5;
        if (Intrinsics.areEqual(this.gridMode, r6.gridMode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pageColumns, r6.pageColumns) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pageGutter, r6.pageGutter) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pageMargin, r6.pageMargin) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.gridMode.hashCode() * 31) + this.pageColumns.hashCode()) * 31) + this.pageGutter.hashCode()) * 31) + this.pageMargin.hashCode();
    }

    public String toString() {
        return "PageGridConfig(gridMode=" + this.gridMode + ", pageColumns=" + this.pageColumns + ", pageGutter=" + this.pageGutter + ", pageMargin=" + this.pageMargin + ')';
    }

    public PageGridConfig(String r2, PageColumns r3, PageGutter r4, PageMargin r5) {
        Intrinsics.checkNotNullParameter(r2, "gridMode");
        Intrinsics.checkNotNullParameter(r3, "pageColumns");
        Intrinsics.checkNotNullParameter(r4, "pageGutter");
        Intrinsics.checkNotNullParameter(r5, "pageMargin");
        this.gridMode = r2;
        this.pageColumns = r3;
        this.pageGutter = r4;
        this.pageMargin = r5;
    }

    public final String getGridMode() {
        return this.gridMode;
    }

    public final PageColumns getPageColumns() {
        return this.pageColumns;
    }

    public final PageGutter getPageGutter() {
        return this.pageGutter;
    }

    public final PageMargin getPageMargin() {
        return this.pageMargin;
    }
}
