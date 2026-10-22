package com.bytedanceos.security.permission;

import android.app.NotificationManager;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import com.bytedanceos.security.widget.SearchBar;
import com.bytedanceos.security.widget.SlideListView;

/* JADX INFO: loaded from: classes2.dex */
public class ZenPermissionsActivity extends BaseAppSortListActivity implements View.OnClickListener, SpecialPermissionApps.Callback, AdapterView.OnItemClickListener, SearchBar.Listener, SlideListView.Listener {
    private static final String TAG = "ZenPermissionsActivity";

    public ZenPermissionsActivity() {
    }

    @Override // com.bytedanceos.security.permission.BaseAppSortListActivity
    public boolean hasAccess(Context context, String pkg) {
        return ((NotificationManager) context.getSystemService(NotificationManager.class)).isNotificationPolicyAccessGrantedForPackage(pkg);
    }

    @Override // com.bytedanceos.security.permission.BaseAppSortListActivity
    public void setAccess(final Context context, final String pkg, final boolean access) {
        AsyncTask.execute(new ZenPermissionsActivity$$ExternalSyntheticLambda0(context, pkg, access));
    }

    static /* synthetic */ void lambda$setAccess$0(Context r1, String r2, boolean r3) {
        ((NotificationManager) r1.getSystemService(NotificationManager.class)).setNotificationPolicyAccessGranted(r2, r3);
    }
}
