package com.obric.securitycenter.nodisturb.dialog.action;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionDialogAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/obric/securitycenter/nodisturb/dialog/action/ActionDialogItemData;", "", "title", "", "buttonStyle", "", "(Ljava/lang/String;I)V", "getButtonStyle", "()I", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ActionDialogItemData {
    private final int buttonStyle;
    private final String title;

    public static /* synthetic */ ActionDialogItemData copy$default(ActionDialogItemData r0, String r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.title;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.buttonStyle;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.title;
    }

    public final int component2() {
        return this.buttonStyle;
    }

    public final ActionDialogItemData copy(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "title");
        return new ActionDialogItemData(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ActionDialogItemData) == true) goto L8;
        return false;
    L8:
        ActionDialogItemData r6 = (ActionDialogItemData) r5;
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (this.buttonStyle == r6.buttonStyle) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + Integer.hashCode(this.buttonStyle);
    }

    public String toString() {
        return "ActionDialogItemData(title=" + this.title + ", buttonStyle=" + this.buttonStyle + ")";
    }

    public ActionDialogItemData(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "title");
        this.title = r2;
        this.buttonStyle = r3;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getButtonStyle() {
        return this.buttonStyle;
    }
}
