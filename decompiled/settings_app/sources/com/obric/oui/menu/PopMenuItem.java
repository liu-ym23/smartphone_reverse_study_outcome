package com.obric.oui.menu;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PopMenuItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/oui/menu/PopMenuItem;", "", "id", "", "icon", "title", "", "(IILjava/lang/String;)V", "getIcon", "()I", "getId", "getTitle", "()Ljava/lang/String;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PopMenuItem {
    private final int icon;
    private final int id;
    private final String title;

    public PopMenuItem(int r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "title");
        this.id = r2;
        this.icon = r3;
        this.title = r4;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }
}
