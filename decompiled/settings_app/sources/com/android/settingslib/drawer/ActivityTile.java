package com.android.settingslib.drawer;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Parcel;
import com.GlobalProxyLancet;
import com.bytedance.librarian.LibrarianImpl;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ActivityTile extends Tile {
    private static final String TAG = "ActivityTile";

    public ActivityTile(ActivityInfo r2, String r3) {
        super(r2, r3, r2.metaData);
    }

    ActivityTile(Parcel r1) {
        super(r1);
    }

    @Override // com.android.settingslib.drawer.Tile
    public int getId() {
        return Objects.hash(new Object[]{getPackageName(), getComponentName()});
    }

    @Override // com.android.settingslib.drawer.Tile
    public String getDescription() {
        return getPackageName() + LibrarianImpl.Constants.SEPARATOR + getComponentName();
    }

    @Override // com.android.settingslib.drawer.Tile
    protected ComponentInfo getComponentInfo(Context r3) {
        if (this.mComponentInfo != null) goto L11;
        PackageManager r4 = r3.getApplicationContext().getPackageManager();
        Intent r0 = getIntent();
        List<ResolveInfo> r5 = r4.queryIntentActivities(r0, 128);
        if (r5 != null) goto L7;
    L9:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Cannot find package info for " + r0.getComponent().flattenToString());
        goto L11
    L7:
        if (r5.isEmpty() == true) goto L9;
        this.mComponentInfo = r5.get(0).activityInfo;
        setMetaData(this.mComponentInfo.metaData);
    L11:
        return this.mComponentInfo;
    }

    @Override // com.android.settingslib.drawer.Tile
    protected CharSequence getComponentLabel(Context r2) {
        PackageManager r0 = r2.getPackageManager();
        ComponentInfo r1 = getComponentInfo(r2);
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.loadLabel(r0);
    }

    @Override // com.android.settingslib.drawer.Tile
    protected int getComponentIcon(ComponentInfo r1) {
        return r1.icon;
    }
}
