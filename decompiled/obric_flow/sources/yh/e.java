package yh;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0019\u0010\rR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001b\u0010\u0005R\u001c\u0010 \u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001e\u001a\u0004\b\u0007\u0010\u001f¨\u0006!"}, d2 = {"Lyh/e;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "content", "b", "d", "head", "", "c", "Ljava/lang/Number;", "()Ljava/lang/Number;", "expires", "Lcom/google/gson/JsonObject;", "Lcom/google/gson/JsonObject;", "e", "()Lcom/google/gson/JsonObject;", "query", "", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "sdk", "h", "version", "g", "url", "", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "enforce", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("content")
    private final String f23275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("head")
    private final String f23276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("expires")
    private final Number f23277c;

    @SerializedName("query")
    private final JsonObject d;

    @SerializedName("sdk")
    private final Integer e;

    @SerializedName("version")
    private final Number f;

    @SerializedName("url")
    private final String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SerializedName("enforce")
    private final Boolean f23278h;

    public final String a() {
        return this.f23275a;
    }

    public final Boolean b() {
        return this.f23278h;
    }

    public final Number c() {
        return this.f23277c;
    }

    public final String d() {
        return this.f23276b;
    }

    public final JsonObject e() {
        return this.d;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r10 = (e) r5;
        if (Intrinsics.areEqual(this.f23275a, r10.f23275a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f23276b, r10.f23276b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f23277c, r10.f23277c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f23278h, r10.f23278h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final Integer f() {
        return this.e;
    }

    public final String g() {
        return this.g;
    }

    public final Number h() {
        return this.f;
    }

    public final int hashCode() {
        String r5 = this.f23275a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.f23276b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        Number r16 = this.f23277c;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        JsonObject r19 = this.d;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.e;
        if (r22 != null) goto L21;
        int r23 = 0;
    L22:
        int r24 = (r21 + r23) * 31;
        Number r25 = this.f;
        if (r25 != null) goto L25;
        int r26 = 0;
    L26:
        int r27 = (r24 + r26) * 31;
        String r28 = this.g;
        if (r28 != null) goto L29;
        int r29 = 0;
    L30:
        int r30 = (r27 + r29) * 31;
        Boolean r31 = this.f23278h;
        if (r31 == null) goto L35;
        r10 = r31.hashCode();
    L35:
        return r30 + r10;
    L29:
        r29 = r28.hashCode();
        goto L30
    L25:
        r26 = r25.hashCode();
        goto L26
    L21:
        r23 = r22.hashCode();
        goto L22
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        return "Params(content=" + this.f23275a + ", head=" + this.f23276b + ", expires=" + this.f23277c + ", query=" + this.d + ", sdk=" + this.e + ", version=" + this.f + ", url=" + this.g + ", enforce=" + this.f23278h + ')';
    }
}
