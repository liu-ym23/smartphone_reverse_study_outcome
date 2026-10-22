package com.obric.oui.avatar;

import kotlin.Metadata;

/* JADX INFO: compiled from: OAvatarQueueViewV2WithClip.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/avatar/OAvatarQueueShape;", "", "(Ljava/lang/String;I)V", "Queue", "Group", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OAvatarQueueShape extends Enum<OAvatarQueueShape> {
    private static final /* synthetic */ OAvatarQueueShape[] $VALUES = null;
    public static final OAvatarQueueShape Group = null;
    public static final OAvatarQueueShape Queue = null;

    private static final /* synthetic */ OAvatarQueueShape[] $values() {
        return new OAvatarQueueShape[]{Queue, Group};
    }

    public static OAvatarQueueShape valueOf(String r1) {
        return (OAvatarQueueShape) Enum.valueOf(OAvatarQueueShape.class, r1);
    }

    public static OAvatarQueueShape[] values() {
        return (OAvatarQueueShape[]) $VALUES.clone();
    }

    private OAvatarQueueShape(String r1, int r2) {
        super(r1, r2);
    }

    static {
        Queue = new OAvatarQueueShape("Queue", 0);
        Group = new OAvatarQueueShape("Group", 1);
        $VALUES = $values();
    }
}
