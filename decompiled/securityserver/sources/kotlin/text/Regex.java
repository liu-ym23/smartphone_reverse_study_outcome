package kotlin.text;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Regex implements Serializable {
    public final Pattern b;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class Serialized implements Serializable {

        @Metadata
        public static final class Companion {
        }
    }

    public Regex(String r2) {
        Pattern r3 = Pattern.compile(r2);
        Intrinsics.e(r3, "compile(pattern)");
        this.b = r3;
    }

    public final MatchResult a(int r2, String r3) {
        Intrinsics.f(r3, "input");
        Matcher r1 = this.b.matcher(r3);
        Intrinsics.e(r1, "nativePattern.matcher(input)");
        if (r1.find(r2) == true) goto L6;
        return null;
    L6:
        return new MatcherMatchResult(r1, r3);
    }

    public final boolean b(CharSequence r2) {
        Intrinsics.f(r2, "input");
        return this.b.matcher(r2).matches();
    }

    public final String toString() {
        String r1 = this.b.toString();
        Intrinsics.e(r1, "nativePattern.toString()");
        return r1;
    }
}
