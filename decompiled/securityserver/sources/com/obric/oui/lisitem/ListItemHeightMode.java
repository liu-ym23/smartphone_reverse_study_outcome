package com.obric.oui.lisitem;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum ListItemHeightMode extends Enum<ListItemHeightMode> {
    public static final /* synthetic */ ListItemHeightMode[] b = null;

    static {
        b = new ListItemHeightMode[]{new ListItemHeightMode("DEFAULT", 0), new ListItemHeightMode("COMPACT", 1)};
    }

    public static ListItemHeightMode valueOf(String r1) {
        return (ListItemHeightMode) Enum.valueOf(ListItemHeightMode.class, r1);
    }

    public static ListItemHeightMode[] values() {
        return (ListItemHeightMode[]) b.clone();
    }
}
