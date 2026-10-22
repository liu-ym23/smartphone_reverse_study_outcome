package androidx.slice;

import android.content.Context;
import android.net.Uri;
import androidx.slice.compat.SliceProviderCompat;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class SliceManagerCompat extends SliceManager {
    private final Context mContext;

    SliceManagerCompat(Context r1) {
        this.mContext = r1;
    }

    @Override // androidx.slice.SliceManager
    public Set<SliceSpec> getPinnedSpecs(Uri r1) {
        return SliceProviderCompat.getPinnedSpecs(this.mContext, r1);
    }

    @Override // androidx.slice.SliceManager
    public int checkSlicePermission(Uri r2, int r3, int r4) {
        Context r1 = this.mContext;
        return SliceProviderCompat.checkSlicePermission(r1, r1.getPackageName(), r2, r3, r4);
    }

    @Override // androidx.slice.SliceManager
    public void grantSlicePermission(String r2, Uri r3) {
        Context r1 = this.mContext;
        SliceProviderCompat.grantSlicePermission(r1, r1.getPackageName(), r2, r3);
    }

    @Override // androidx.slice.SliceManager
    public void revokeSlicePermission(String r2, Uri r3) {
        Context r1 = this.mContext;
        SliceProviderCompat.revokeSlicePermission(r1, r1.getPackageName(), r2, r3);
    }

    @Override // androidx.slice.SliceManager
    public List<Uri> getPinnedSlices() {
        return SliceProviderCompat.getPinnedSlices(this.mContext);
    }
}
