package yh;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lyh/f;", "", "", "a", "Ljava/lang/Boolean;", "getUpdate", "()Ljava/lang/Boolean;", "update", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("update")
    private final Boolean f23279a;

    public f(Boolean r5) {
        this.f23279a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f23279a, ((f) r5).f23279a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Boolean r5 = this.f23279a;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.hashCode();
    }

    public final String toString() {
        return "Result(update=" + this.f23279a + ')';
    }
}
