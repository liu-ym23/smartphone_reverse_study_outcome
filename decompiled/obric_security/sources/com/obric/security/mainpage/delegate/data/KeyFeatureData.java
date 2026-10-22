package com.obric.security.mainpage.delegate.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyFeatureData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/obric/security/mainpage/delegate/data/KeyFeatureData;", "Lcom/obric/security/mainpage/delegate/data/Feature;", "key", "", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class KeyFeatureData extends Feature {
    public static final Companion Companion = null;
    public static final int position = 0;
    private final String key;

    /* JADX INFO: compiled from: KeyFeatureData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/security/mainpage/delegate/data/KeyFeatureData$Companion;", "", "()V", "position", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KeyFeatureData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ KeyFeatureData copy$default(KeyFeatureData r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.getKey();
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return getKey();
    }

    public final KeyFeatureData copy(String r1) {
        Intrinsics.checkNotNullParameter(r1, "key");
        return new KeyFeatureData(r1);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof KeyFeatureData) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(getKey(), ((KeyFeatureData) r2).getKey()) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        String r0 = getKey();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "KeyFeatureData(key=" + getKey() + ")";
    }

    public KeyFeatureData(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        super("keyFeature", 0);
        this.key = r3;
    }

    public /* synthetic */ KeyFeatureData(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "keyFeature";
    L5:
        this(r1);
    }

    @Override // com.obric.security.mainpage.delegate.data.Feature
    public String getKey() {
        return this.key;
    }
}
