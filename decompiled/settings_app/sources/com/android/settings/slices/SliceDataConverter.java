package com.android.settings.slices;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.view.accessibility.AccessibilityManager;
import com.android.settings.R;
import com.android.settings.accessibility.AccessibilitySettings;
import com.android.settings.overlay.FeatureFactory;
import com.android.settingslib.core.instrumentation.MetricsFeatureProvider;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class SliceDataConverter {
    private static final String TAG = "SliceDataConverter";
    private Context mContext;
    private final MetricsFeatureProvider mMetricsFeatureProvider;

    public SliceDataConverter(Context r1) {
        this.mContext = r1;
        this.mMetricsFeatureProvider = FeatureFactory.getFeatureFactory().getMetricsFeatureProvider();
    }

    public List<SliceData> getSliceData() {
        ArrayList r0 = new ArrayList();
        r0.addAll(getAccessibilitySliceData());
        return r0;
    }

    private List<SliceData> getAccessibilitySliceData() {
        ArrayList r0 = new ArrayList();
        String r1 = AccessibilitySettings.class.getName();
        SliceData.Builder r2 = new SliceData.Builder().setFragmentName(r1).setScreenTitle(this.mContext.getText(R.string.accessibility_settings));
        HashSet r3 = new HashSet();
        List<AccessibilityServiceInfo> r4 = getAccessibilityServiceInfoList();
        PackageManager r9 = this.mContext.getPackageManager();
        Iterator<AccessibilityServiceInfo> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L16;
        ResolveInfo r6 = r5.next().getResolveInfo();
        ServiceInfo r7 = r6.serviceInfo;
        String r8 = new ComponentName(r7.packageName, r7.name).flattenToString();
        if (r3.contains(r8) == false) goto L4;
        String r10 = r6.loadLabel(r9).toString();
        int r11 = r6.getIconResource();
        if (r11 != 0) goto L11;
        r11 = R.drawable.ic_accessibility_generic;
    L11:
        r2.setKey(r8).setTitle(r10).setUri(new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath(r8).build()).setIcon(r11).setSliceType(1);
        r0.add(r2.build());     // Catch: SliceData.InvalidSliceDataException -> L14
    L14:
        e = move-exception;
        OLog.w(TAG, "Invalid data when building a11y SliceData for " + r8, e);
        goto L4
    L16:
        return r0;
    }

    List<AccessibilityServiceInfo> getAccessibilityServiceInfoList() {
        return AccessibilityManager.getInstance(this.mContext).getInstalledAccessibilityServiceList();
    }
}
