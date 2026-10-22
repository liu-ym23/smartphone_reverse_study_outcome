package androidx.slice;

import android.content.Context;
import android.net.Uri;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class SliceManager {
    public abstract int checkSlicePermission(Uri r1, int r2, int r3);

    public abstract List<Uri> getPinnedSlices();

    public abstract Set<SliceSpec> getPinnedSpecs(Uri r1);

    public abstract void grantSlicePermission(String r1, Uri r2);

    public abstract void revokeSlicePermission(String r1, Uri r2);

    public static SliceManager getInstance(Context r1) {
        return new SliceManagerWrapper(r1);
    }

    SliceManager() {
    }
}
