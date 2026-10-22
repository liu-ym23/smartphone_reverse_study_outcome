package com.bytedance.blockframework.framework.monitor;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockMonitor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/bytedance/blockframework/framework/monitor/JobRecord;", "", "scene", "", "key", "type", "message", "cost", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getCost", "()J", "getKey", "()Ljava/lang/String;", "getMessage", "getScene", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JobRecord {
    private final long cost;
    private final String key;
    private final String message;
    private final String scene;
    private final String type;

    public JobRecord() {
        this(null, null, null, null, 0, 31, null);
    }

    public static /* synthetic */ JobRecord copy$default(JobRecord r4, String r5, String r6, String r7, String r8, long r9, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.scene;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.key;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.type;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.message;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.cost;
    L17:
        String r10 = r5;
        return r4.copy(r10, r13, r0, r1, r9);
    }

    public final String component1() {
        return this.scene;
    }

    public final String component2() {
        return this.key;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.message;
    }

    public final long component5() {
        return this.cost;
    }

    public final JobRecord copy(String r8, String r9, String r10, String r11, long r12) {
        Intrinsics.checkNotNullParameter(r8, "scene");
        Intrinsics.checkNotNullParameter(r9, "key");
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "message");
        return new JobRecord(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if ((r6 instanceof JobRecord) == true) goto L8;
        return false;
    L8:
        JobRecord r7 = (JobRecord) r6;
        if (Intrinsics.areEqual(this.scene, r7.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.key, r7.key) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r7.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.message, r7.message) == true) goto L21;
        return false;
    L21:
        if (this.cost == r7.cost) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.scene.hashCode() * 31) + this.key.hashCode()) * 31) + this.type.hashCode()) * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.cost);
    }

    public JobRecord(String r2, String r3, String r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "message");
        this.scene = r2;
        this.key = r3;
        this.type = r4;
        this.message = r5;
        this.cost = r6;
    }

    public /* synthetic */ JobRecord(String r2, String r3, String r4, String r5, long r6, int r8, DefaultConstructorMarker r9) {
        if ((r8 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = "";
    L15:
        if ((r8 & 16) == 0) goto L17;
        r6 = 0;
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getType() {
        return this.type;
    }

    public final String getMessage() {
        return this.message;
    }

    public final long getCost() {
        return this.cost;
    }

    public String toString() {
        if (this.cost > 0) goto L7;
        return this.scene + " -- " + this.key + " -- " + this.type + " -- " + this.message;
    L7:
        return this.scene + " -- " + this.key + " -- " + this.type + " -- " + this.message + " -- cost: " + this.cost + "ms";
    }
}
