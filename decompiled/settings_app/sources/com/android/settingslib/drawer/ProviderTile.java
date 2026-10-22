package com.android.settingslib.drawer;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.GlobalProxyLancet;
import com.bytedance.librarian.LibrarianImpl;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ProviderTile extends Tile {
    private static final boolean DEBUG_TIMING = false;
    private static final String TAG = "ProviderTile";
    private String mAuthority;
    private String mKey;

    @Override // com.android.settingslib.drawer.Tile
    protected int getComponentIcon(ComponentInfo r1) {
        return 0;
    }

    @Override // com.android.settingslib.drawer.Tile
    protected CharSequence getComponentLabel(Context r1) {
        return null;
    }

    public ProviderTile(ProviderInfo r1, String r2, Bundle r3) {
        super(r1, r2, r3);
        this.mAuthority = r1.authority;
        this.mKey = r3.getString(TileUtils.META_DATA_PREFERENCE_KEYHINT);
    }

    ProviderTile(Parcel r2) {
        super(r2);
        this.mAuthority = ((ProviderInfo) this.mComponentInfo).authority;
        this.mKey = getMetaData().getString(TileUtils.META_DATA_PREFERENCE_KEYHINT);
    }

    @Override // com.android.settingslib.drawer.Tile
    public int getId() {
        return Objects.hash(new Object[]{this.mAuthority, this.mKey});
    }

    @Override // com.android.settingslib.drawer.Tile
    public String getDescription() {
        return this.mAuthority + LibrarianImpl.Constants.SEPARATOR + this.mKey;
    }

    @Override // com.android.settingslib.drawer.Tile
    protected ComponentInfo getComponentInfo(Context r5) {
        if (this.mComponentInfo != null) goto L11;
        System.currentTimeMillis();
        PackageManager r0 = r5.getApplicationContext().getPackageManager();
        Intent r1 = getIntent();
        List<ResolveInfo> r2 = r0.queryIntentContentProviders(r1, 0);
        if (r2 != null) goto L7;
    L9:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Cannot find package info for " + r1.getComponent().flattenToString());
        goto L11
    L7:
        if (r2.isEmpty() == true) goto L9;
        ProviderInfo r3 = r2.get(0).providerInfo;
        this.mComponentInfo = r3;
        setMetaData(TileUtils.getEntryDataFromProvider(r5, r3.authority, this.mKey));
    L11:
        return this.mComponentInfo;
    }
}
