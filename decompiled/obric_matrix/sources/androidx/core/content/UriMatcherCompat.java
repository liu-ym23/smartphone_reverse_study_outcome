package androidx.core.content;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.util.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class UriMatcherCompat {
    private UriMatcherCompat() {
    }

    static /* synthetic */ boolean a(UriMatcher r0, Uri r1) {
        if (r0.match(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @NonNull
    public static Predicate<Uri> asPredicate(@NonNull final UriMatcher r1) {
        return new u(r1);
    }
}
