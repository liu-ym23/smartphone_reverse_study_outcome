package com.obric.capabilitykit.search;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0017\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/search/PhotoScore;", "", "entityId", "", "score", "", "(Ljava/lang/String;F)V", "getEntityId", "()Ljava/lang/String;", "setEntityId", "(Ljava/lang/String;)V", "getScore", "()F", "setScore", "(F)V", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class PhotoScore {
    private String entityId;
    private float score;

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoScore() {
        String r2 = null;
        this(r2, 0.0f, 3, 0 == true ? 1 : 0);
    }

    public PhotoScore(String r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        this.entityId = r2;
        this.score = r3;
    }

    public /* synthetic */ PhotoScore(String r1, float r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 0.0f;
    L8:
        this(r1, r2);
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final float getScore() {
        return this.score;
    }

    public final void setEntityId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.entityId = r2;
    }

    public final void setScore(float r1) {
        this.score = r1;
    }
}
