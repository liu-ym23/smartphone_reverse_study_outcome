package yh;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\b\u0010\u000f¨\u0006\u0011"}, d2 = {"Lyh/b;", "", "Lcom/google/gson/JsonObject;", "a", "Lcom/google/gson/JsonObject;", "()Lcom/google/gson/JsonObject;", "query", "", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "url", "", "Ljava/lang/Number;", "()Ljava/lang/Number;", "sdk", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("query")
    private final JsonObject f23270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("url")
    private final String f23271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("sdk")
    private final Number f23272c;

    public final JsonObject a() {
        return this.f23270a;
    }

    public final Number b() {
        return this.f23272c;
    }

    public final String c() {
        return this.f23271b;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r5;
        if (Intrinsics.areEqual(this.f23270a, r10.f23270a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f23271b, r10.f23271b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f23272c, r10.f23272c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        JsonObject r5 = this.f23270a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.f23271b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        Number r16 = this.f23272c;
        if (r16 == null) goto L15;
        r10 = r16.hashCode();
    L15:
        return r15 + r10;
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        return "Params(query=" + this.f23270a + ", url=" + this.f23271b + ", sdk=" + this.f23272c + ')';
    }
}
