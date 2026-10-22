package com.bytedanceos.security;

import android.R;
import android.app.Activity;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.Loader;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import bytedanceos.util.LogTag;
import com.obric.oui.simplified.ORoundedListItemText;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PackagesOverviewFragment extends ListFragment implements LoaderManager.LoaderCallbacks<List<PackagePermissions>>, AdapterView.OnItemClickListener {
    public static final boolean DEBUG = true;
    private static final String TAG = "PackagesListFragment";
    private int animInRight;
    private int animOutLeft;
    MyAdapter mAdapter;
    private Activity mContext;
    View mListViewEmptyView;
    PackageManager mPM;
    BroadcastReceiver mPackageReceiver;

    class MyAdapter extends ArrayAdapter<PackagePermissions> {
        LayoutInflater mInflater;
        final /* synthetic */ PackagesOverviewFragment this$0;

        public MyAdapter(final PackagesOverviewFragment this$0, Context context) {
            this.this$0 = this$0;
            super(context, R.layout.simple_list_item_2);
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void setData(List<PackagePermissions> data) {
            clear();
            if (data != null) goto L5;
        L7:
            this.this$0.getListView().setEmptyView(this.this$0.mListViewEmptyView);
            return;
        L5:
            if (data.size() <= 0) goto L7;
            addAll(data);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView != null) goto L4;
            convertView = this.mInflater.inflate(com.obric.security.R.layout.package_overview_item, null);
            ViewHolder r10 = new ViewHolder(this.this$0);
            r10.item = (ORoundedListItemText) convertView.findViewById(com.obric.security.R.id.app_info);
            r10.emptyView = convertView.findViewById(com.obric.security.R.id.empty_view);
            convertView.setTag(r10);
        L6:
            if (r10.item != null) goto L8;
            return convertView;
        L8:
            r10.setEmptyViewVisibility(8);
            if (getCount() != 1) goto L11;
            r10.setEmptyViewVisibility(0);
        L16:
            PackagePermissions r0 = getItem(position);
            String r3 = r0.getPackageName();
            ApplicationInfo r4 = this.this$0.mPM.getApplicationInfo(r3, 0);     // Catch: PackageManager.NameNotFoundException -> L22
            if (r4 == null) goto L20;
            r10.item.setTitleString(r4.loadLabel(this.this$0.mPM).toString());     // Catch: PackageManager.NameNotFoundException -> L22
        L20:
            r10.item.setContentImage(getItem(position).getIcon());     // Catch: PackageManager.NameNotFoundException -> L22
            r10.item.setTrailingText(this.this$0.getString(com.obric.security.R.string.package_overview_count, new Object[]{Integer.valueOf(r0.getPermissionCount())}));     // Catch: PackageManager.NameNotFoundException -> L22
        L23:
            return convertView;
        L22:
            LogTag.e(PackagesOverviewFragment.TAG, "get application info failed " + r3);
            goto L23
        L11:
            if (position == 0) goto L16;
            if (position != (getCount() - 1)) goto L16;
            r10.setEmptyViewVisibility(0);
            goto L16
        L4:
            r10 = (ViewHolder) convertView.getTag();
            goto L6
        }
    }

    class ViewHolder {
        View emptyView;
        ORoundedListItemText item;
        final /* synthetic */ PackagesOverviewFragment this$0;

        ViewHolder(final PackagesOverviewFragment this$0) {
            this.this$0 = this$0;
        }

        public void setEmptyViewVisibility(int visibility) {
            View r0 = this.emptyView;
            if (r0 == null) goto L6;
            r0.setVisibility(visibility);
            return;
        }
    }

    public PackagesOverviewFragment() {
        this.mAdapter = null;
        this.mPM = null;
        this.mPackageReceiver = new AnonymousClass1(this);
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<List<PackagePermissions>> loader, List<PackagePermissions> data) {
        onLoadFinished2(loader, data);
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentFilter r5 = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
        r5.addDataScheme("package");
        Activity r0 = getActivity();
        this.mContext = r0;
        if (r0 == null) goto L6;
        r0.registerReceiver(this.mPackageReceiver, r5);
        this.animInRight = Utils.getSMTResouceId(this.mContext, "bytedanceos", "slide_in_from_right", "anim", com.obric.security.R.anim.slide_in_from_right);
        this.animOutLeft = Utils.getSMTResouceId(this.mContext, "bytedanceos", "slide_out_to_left", "anim", com.obric.security.R.anim.slide_out_to_left);
        return;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Activity r0 = this.mContext;
        if (r0 == null) goto L6;
        r0.unregisterReceiver(this.mPackageReceiver);
        return;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Activity r4 = this.mContext;
        if (r4 != null) goto L5;
        return;
    L5:
        this.mPM = r4.getPackageManager();
        this.mListViewEmptyView = this.mContext.findViewById(com.obric.security.R.id.empty_view);
        this.mAdapter = new MyAdapter(this, this.mContext);
        getListView().addHeaderView(getHeaderView(), null, false);
        setListAdapter(this.mAdapter);
        Drawable r5 = getResources().getDrawable(com.obric.security.R.color.transparent);
        if (r5 == null) goto L8;
        getListView().setSelector(r5);
        getListView().setDivider(r5);
    L8:
        getListView().setOnItemClickListener(this);
        getListView().setOverScrollMode(0);
        getLoaderManager().initLoader(0, null, this);
    }

    private View getHeaderView() {
        TextView r0 = new TextView(this.mContext);
        r0.setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(com.obric.security.R.dimen.package_overview_margin_top)));
        return r0;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<List<PackagePermissions>> onCreateLoader(int id, Bundle args) {
        return new PackagesListLoader(this.mContext);
    }

    /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
    public void onLoadFinished2(Loader<List<PackagePermissions>> loader, List<PackagePermissions> data) {
        this.mAdapter.setData(data);
        View r1 = this.mContext.findViewById(com.obric.security.R.id.package_loading_text);
        if (r1 == null) goto L6;
        r1.setVisibility(8);
    L6:
        if (isResumed() == false) goto L8;
        setListShown(true);
        return;
    L8:
        setListShownNoAnimation(true);
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<PackagePermissions>> loader) {
        this.mAdapter.clear();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        PackagePermissions r1 = this.mAdapter.getItem(position - 1);
        Intent r2 = new Intent(Utils.INTENT_ACTION_PACKAGE_DETAIL);
        r2.putExtra("detail", r1);
        r2.putExtra(Utils.INTENT_KEY_FROM_CENTER, ((PackagesOverview) this.mContext).isFromSecurityCenter());
        startActivity(r2);
    }
}
