package com.obric.oui.lisitem;

import kotlin.Metadata;

/* JADX INFO: compiled from: ListItemHeightMode.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/lisitem/ListItemHeightMode;", "", "(Ljava/lang/String;I)V", "DEFAULT", "COMPACT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum ListItemHeightMode extends Enum<ListItemHeightMode> {
    private static final /* synthetic */ ListItemHeightMode[] $VALUES = null;
    public static final ListItemHeightMode COMPACT = null;
    public static final ListItemHeightMode DEFAULT = null;

    private static final /* synthetic */ ListItemHeightMode[] $values() {
        return new ListItemHeightMode[]{DEFAULT, COMPACT};
    }

    public static ListItemHeightMode valueOf(String r1) {
        return (ListItemHeightMode) Enum.valueOf(ListItemHeightMode.class, r1);
    }

    public static ListItemHeightMode[] values() {
        return (ListItemHeightMode[]) $VALUES.clone();
    }

    private ListItemHeightMode(String r1, int r2) {
        super(r1, r2);
    }

    static {
        DEFAULT = new ListItemHeightMode("DEFAULT", 0);
        COMPACT = new ListItemHeightMode("COMPACT", 1);
        $VALUES = $values();
    }
}
