package com.android.settings.display;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.android.settings.R;
import com.android.settings.utils.NullSafe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppGridView extends GridView {

    private static class ActivityEntry implements Comparable<ActivityEntry> {
        public final ResolveInfo info;
        public final String label;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ActivityEntry r1) {
            return compareTo2(r1);
        }

        public ActivityEntry(ResolveInfo r1, String r2) {
            this.info = r1;
            this.label = r2;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ActivityEntry r1) {
            return this.label.compareToIgnoreCase(r1.label);
        }

        public String toString() {
            return this.label;
        }
    }

    private static class AppsAdapter extends ArrayAdapter<ActivityEntry> {
        private final int mIconResId;
        private final PackageManager mPackageManager;

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r1) {
            return false;
        }

        public AppsAdapter(Context r1, int r2, int r3, int r4) {
            super(r1, r2, r3);
            this.mIconResId = r4;
            this.mPackageManager = (PackageManager) NullSafe.nonNull(r1.getPackageManager());
            loadAllApps();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int r1, View r2, ViewGroup r3) {
            View r4 = super.getView(r1, r2, r3);
            ActivityEntry r5 = getItem(r1);
            ((ImageView) r4.findViewById(this.mIconResId)).setImageDrawable(r5.info.loadIcon(this.mPackageManager));
            return r4;
        }

        private void loadAllApps() {
            Intent r0 = new Intent("android.intent.action.MAIN", null);
            r0.addCategory("android.intent.category.LAUNCHER");
            PackageManager r1 = (PackageManager) NullSafe.nonNull(this.mPackageManager);
            ArrayList r2 = new ArrayList();
            List<ResolveInfo> r3 = r1.queryIntentActivities(r0, 0);
            if (r3 != null) goto L5;
            return;
        L5:
            Iterator<ResolveInfo> r4 = r3.iterator();
        L7:
            if (r4.hasNext() == false) goto L11;
            ResolveInfo r5 = r4.next();
            CharSequence r6 = r5.loadLabel(r1);
            if (r6 == null) goto L7;
            r2.add(new ActivityEntry(r5, r6.toString()));
            goto L7
        L11:
            Collections.sort(r2);
            addAll(r2);
        }
    }

    public AppGridView(Context r2) {
        this(r2, null);
    }

    public AppGridView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public AppGridView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public AppGridView(Context r2, AttributeSet r3, int r4, int r5) {
        super(r2, r3, r4, r5);
        setNumColumns(-1);
        setColumnWidth(getResources().getDimensionPixelSize(R.dimen.screen_zoom_preview_app_icon_width));
        setAdapter(new AppsAdapter(r2, R.layout.screen_zoom_preview_app_icon, android.R.id.text1, android.R.id.icon1));
    }
}
