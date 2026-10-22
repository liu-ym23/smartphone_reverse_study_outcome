package com.obric.common.oea.style.scene.alpha.alphaplayer.player;

import kotlin.Metadata;

/* JADX INFO: compiled from: PlayerState.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/PlayerState;", "", "(Ljava/lang/String;I)V", "NOT_PREPARED", "PREPARED", "STARTED", "PAUSED", "STOPPED", "RELEASE", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum PlayerState extends Enum<PlayerState> {
    private static final /* synthetic */ PlayerState[] $VALUES = null;
    public static final PlayerState NOT_PREPARED = null;
    public static final PlayerState PAUSED = null;
    public static final PlayerState PREPARED = null;
    public static final PlayerState RELEASE = null;
    public static final PlayerState STARTED = null;
    public static final PlayerState STOPPED = null;

    static {
        PlayerState r1 = new PlayerState("NOT_PREPARED", 0);
        NOT_PREPARED = r1;
        PlayerState r2 = new PlayerState("PREPARED", 1);
        PREPARED = r2;
        PlayerState r3 = new PlayerState("STARTED", 2);
        STARTED = r3;
        PlayerState r4 = new PlayerState("PAUSED", 3);
        PAUSED = r4;
        PlayerState r5 = new PlayerState("STOPPED", 4);
        STOPPED = r5;
        PlayerState r6 = new PlayerState("RELEASE", 5);
        RELEASE = r6;
        $VALUES = new PlayerState[]{r1, r2, r3, r4, r5, r6};
    }

    public static PlayerState valueOf(String r1) {
        return (PlayerState) Enum.valueOf(PlayerState.class, r1);
    }

    public static PlayerState[] values() {
        return (PlayerState[]) $VALUES.clone();
    }

    private PlayerState(String r1, int r2) {
        super(r1, r2);
    }
}
