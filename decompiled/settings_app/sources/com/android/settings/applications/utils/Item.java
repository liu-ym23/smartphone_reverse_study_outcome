package com.android.settings.applications.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OPopoverHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\b\"\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/android/settings/applications/utils/Item;", "", "title", "", "isSelect", "", "subTitle", "(Ljava/lang/String;ZLjava/lang/String;)V", "()Z", "setSelect", "(Z)V", "getSubTitle", "()Ljava/lang/String;", "getTitle", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Item {
    private boolean isSelect;
    private final String subTitle;
    private final String title;

    public Item(String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "title");
        this(r8, r9, null, 4, null);
    }

    public Item(String r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "title");
        this.title = r2;
        this.isSelect = r3;
        this.subTitle = r4;
    }

    public /* synthetic */ Item(String r1, boolean r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean r1) {
        this.isSelect = r1;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }
}
