package com.obric.oui.pullrefresh;

import kotlin.Metadata;

/* JADX INFO: compiled from: RefreshState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/oui/pullrefresh/RefreshState;", "", "(Ljava/lang/String;I)V", "IDLE", "PULL_TO_REFRESH", "RELEASE_TO_REFRESH", "REFRESHING", "FINISH", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum RefreshState extends Enum<RefreshState> {
    private static final /* synthetic */ RefreshState[] $VALUES = null;
    public static final RefreshState FINISH = null;
    public static final RefreshState IDLE = null;
    public static final RefreshState PULL_TO_REFRESH = null;
    public static final RefreshState REFRESHING = null;
    public static final RefreshState RELEASE_TO_REFRESH = null;

    private static final /* synthetic */ RefreshState[] $values() {
        return new RefreshState[]{IDLE, PULL_TO_REFRESH, RELEASE_TO_REFRESH, REFRESHING, FINISH};
    }

    public static RefreshState valueOf(String r1) {
        return (RefreshState) Enum.valueOf(RefreshState.class, r1);
    }

    public static RefreshState[] values() {
        return (RefreshState[]) $VALUES.clone();
    }

    private RefreshState(String r1, int r2) {
        super(r1, r2);
    }

    static {
        IDLE = new RefreshState("IDLE", 0);
        PULL_TO_REFRESH = new RefreshState("PULL_TO_REFRESH", 1);
        RELEASE_TO_REFRESH = new RefreshState("RELEASE_TO_REFRESH", 2);
        REFRESHING = new RefreshState("REFRESHING", 3);
        FINISH = new RefreshState("FINISH", 4);
        $VALUES = $values();
    }
}
