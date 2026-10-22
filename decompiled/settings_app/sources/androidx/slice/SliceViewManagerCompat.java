package androidx.slice;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.slice.compat.SliceProviderCompat;
import androidx.slice.widget.SliceLiveData;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
class SliceViewManagerCompat extends SliceViewManagerBase {
    SliceViewManagerCompat(Context r1) {
        super(r1);
    }

    @Override // androidx.slice.SliceViewManager
    public void pinSlice(Uri r2) {
        SliceProviderCompat.pinSlice(this.mContext, r2, SliceLiveData.SUPPORTED_SPECS);
    }

    @Override // androidx.slice.SliceViewManager
    public void unpinSlice(Uri r2) {
        SliceProviderCompat.unpinSlice(this.mContext, r2, SliceLiveData.SUPPORTED_SPECS);
    }

    @Override // androidx.slice.SliceViewManager
    public Slice bindSlice(Uri r2) {
        return SliceProviderCompat.bindSlice(this.mContext, r2, SliceLiveData.SUPPORTED_SPECS);
    }

    @Override // androidx.slice.SliceViewManager
    public Slice bindSlice(Intent r2) {
        return SliceProviderCompat.bindSlice(this.mContext, r2, SliceLiveData.SUPPORTED_SPECS);
    }

    @Override // androidx.slice.SliceViewManager
    public Uri mapIntentToUri(Intent r1) {
        return SliceProviderCompat.mapIntentToUri(this.mContext, r1);
    }

    @Override // androidx.slice.SliceViewManager
    public Collection<Uri> getSliceDescendants(Uri r1) {
        return SliceProviderCompat.getSliceDescendants(this.mContext, r1);
    }
}
