package com.obric.security.mainpage.delegate.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Feature.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/security/mainpage/delegate/data/Feature;", "", "key", "", "position", "", "(Ljava/lang/String;I)V", "getKey", "()Ljava/lang/String;", "getPosition", "()I", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public class Feature {
    private final String key;
    private final int position;

    public Feature(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.key = r2;
        this.position = r3;
    }

    public String getKey() {
        return this.key;
    }

    public int getPosition() {
        return this.position;
    }
}
