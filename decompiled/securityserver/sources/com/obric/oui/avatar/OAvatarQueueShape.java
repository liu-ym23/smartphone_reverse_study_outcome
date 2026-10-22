package com.obric.oui.avatar;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum OAvatarQueueShape extends Enum<OAvatarQueueShape> {
    public static final /* synthetic */ OAvatarQueueShape[] b = null;

    static {
        b = new OAvatarQueueShape[]{new OAvatarQueueShape("Queue", 0), new OAvatarQueueShape("Group", 1)};
    }

    public static OAvatarQueueShape valueOf(String r1) {
        return (OAvatarQueueShape) Enum.valueOf(OAvatarQueueShape.class, r1);
    }

    public static OAvatarQueueShape[] values() {
        return (OAvatarQueueShape[]) b.clone();
    }
}
