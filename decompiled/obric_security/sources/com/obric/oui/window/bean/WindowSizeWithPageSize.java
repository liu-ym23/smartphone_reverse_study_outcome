package com.obric.oui.window.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WindowSizeClass.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/window/bean/WindowSizeWithPageSize;", "", "windowSizeClass", "Lcom/obric/oui/window/bean/WindowSizeClass;", "pageSize", "Lcom/obric/oui/window/bean/AvailableWindowSize;", "(Lcom/obric/oui/window/bean/WindowSizeClass;Lcom/obric/oui/window/bean/AvailableWindowSize;)V", "getPageSize", "()Lcom/obric/oui/window/bean/AvailableWindowSize;", "setPageSize", "(Lcom/obric/oui/window/bean/AvailableWindowSize;)V", "getWindowSizeClass", "()Lcom/obric/oui/window/bean/WindowSizeClass;", "setWindowSizeClass", "(Lcom/obric/oui/window/bean/WindowSizeClass;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WindowSizeWithPageSize {
    private AvailableWindowSize pageSize;
    private WindowSizeClass windowSizeClass;

    public static /* synthetic */ WindowSizeWithPageSize copy$default(WindowSizeWithPageSize r0, WindowSizeClass r1, AvailableWindowSize r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.windowSizeClass;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.pageSize;
    L9:
        return r0.copy(r1, r2);
    }

    public final WindowSizeClass component1() {
        return this.windowSizeClass;
    }

    public final AvailableWindowSize component2() {
        return this.pageSize;
    }

    public final WindowSizeWithPageSize copy(WindowSizeClass r1, AvailableWindowSize r2) {
        Intrinsics.checkNotNullParameter(r1, "windowSizeClass");
        Intrinsics.checkNotNullParameter(r2, "pageSize");
        return new WindowSizeWithPageSize(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WindowSizeWithPageSize) == true) goto L8;
        return false;
    L8:
        WindowSizeWithPageSize r6 = (WindowSizeWithPageSize) r5;
        if (this.windowSizeClass == r6.windowSizeClass) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pageSize, r6.pageSize) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.windowSizeClass.hashCode() * 31) + this.pageSize.hashCode();
    }

    public String toString() {
        return "WindowSizeWithPageSize(windowSizeClass=" + this.windowSizeClass + ", pageSize=" + this.pageSize + ')';
    }

    public WindowSizeWithPageSize(WindowSizeClass r2, AvailableWindowSize r3) {
        Intrinsics.checkNotNullParameter(r2, "windowSizeClass");
        Intrinsics.checkNotNullParameter(r3, "pageSize");
        this.windowSizeClass = r2;
        this.pageSize = r3;
    }

    public final WindowSizeClass getWindowSizeClass() {
        return this.windowSizeClass;
    }

    public final void setWindowSizeClass(WindowSizeClass r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.windowSizeClass = r2;
    }

    public final AvailableWindowSize getPageSize() {
        return this.pageSize;
    }

    public final void setPageSize(AvailableWindowSize r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.pageSize = r2;
    }
}
