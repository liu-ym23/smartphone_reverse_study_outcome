package com.android.settings;

import android.app.Activity;
import android.app.AppGlobals;
import android.app.ListFragment;
import android.app.admin.DeviceAdminInfo;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceAdminSettings extends ListFragment {
    static final int DIALOG_WARNING = 1;
    static final String TAG = "DeviceAdminSettings";
    private final ArrayList<DeviceAdminListItem> mAdmins;
    private DevicePolicyManager mDPM;
    private String mDeviceOwnerPkg;
    private SparseArray<ComponentName> mProfileOwnerComponents;
    private UserManager mUm;

    /* JADX INFO: renamed from: com.android.settings.DeviceAdminSettings$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class DeviceAdminListItem implements Comparable<DeviceAdminListItem> {
        public boolean active;
        public DeviceAdminInfo info;
        public String name;

        private DeviceAdminListItem() {
        }

        /* synthetic */ DeviceAdminListItem(AnonymousClass1 r1) {
            this();
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(DeviceAdminListItem r1) {
            return compareTo2(r1);
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(DeviceAdminListItem r3) {
            boolean r0 = this.active;
            if (r0 == r3.active) goto L9;
            if (r0 == false) goto L6;
            return -1;
        L6:
            return 1;
        L9:
            return this.name.compareTo(r3.name);
        }
    }

    class PolicyListAdapter extends BaseAdapter {
        final LayoutInflater mInflater;
        final /* synthetic */ DeviceAdminSettings this$0;

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int r1) {
            return 0;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return false;
        }

        PolicyListAdapter(DeviceAdminSettings r2) {
            this.this$0 = r2;
            this.mInflater = (LayoutInflater) r2.getActivity().getSystemService("layout_inflater");
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return DeviceAdminSettings.access$000(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return ((DeviceAdminListItem) DeviceAdminSettings.access$000(this.this$0).get(r1)).info;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r1) {
            return isEnabled(getItem(r1));
        }

        private boolean isEnabled(Object r1) {
            DeviceAdminSettings r0 = this.this$0;
            if (DeviceAdminSettings.access$100(r0, (DeviceAdminInfo) r1) == false) goto L6;
            return false;
        L6:
            return true;
        }

        @Override // android.widget.Adapter
        public View getView(int r1, View r2, ViewGroup r3) {
            Object r4 = getItem(r1);
            if (r2 != null) goto L5;
            r2 = newDeviceAdminView(r3);
        L5:
            bindView(r2, (DeviceAdminInfo) r4);
            return r2;
        }

        private View newDeviceAdminView(ViewGroup r3) {
            View r2 = this.mInflater.inflate(R.layout.device_admin_item, r3, false);
            ViewHolder r4 = new ViewHolder();
            r4.icon = (ImageView) r2.findViewById(R.id.icon);
            r4.name = (TextView) r2.findViewById(R.id.name);
            r4.checkbox = (CheckBox) r2.findViewById(R.id.checkbox);
            r4.description = (TextView) r2.findViewById(R.id.description);
            r2.setTag(r4);
            return r2;
        }

        private void bindView(View r6, DeviceAdminInfo r7) {
            Activity r0 = this.this$0.getActivity();
            if (r0 != null) goto L5;
            return;
        L5:
            ViewHolder r8 = (ViewHolder) r6.getTag();
            Drawable r1 = r7.loadIcon(r0.getPackageManager());
            Drawable r2 = r0.getPackageManager().getUserBadgedIcon(r1, new UserHandle(DeviceAdminSettings.access$200(this.this$0, r7)));
            r8.icon.setImageDrawable(r2);
            r8.name.setText(r7.loadLabel(r0.getPackageManager()));
            r8.checkbox.setChecked(DeviceAdminSettings.access$300(this.this$0, r7));
            boolean r5 = isEnabled(r7);
            r8.description.setText(r7.loadDescription(r0.getPackageManager()));     // Catch: Resources.NotFoundException -> L9
        L7:
            r8.checkbox.setEnabled(r5);
            r8.name.setEnabled(r5);
            r8.description.setEnabled(r5);
            r8.icon.setEnabled(r5);
        }
    }

    static class ViewHolder {
        CheckBox checkbox;
        TextView description;
        ImageView icon;
        TextView name;

        ViewHolder() {
        }
    }

    public void com_android_settings_DeviceAdminSettings__onPause$___twin___() {
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_DeviceAdminSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(this, r1);
    }

    @Override // android.app.Fragment
    public void onPause() {
        com_android_settings_DeviceAdminSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(this);
    }

    @Override // android.app.Fragment
    public void onResume() {
        com_android_settings_DeviceAdminSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(this);
    }

    public DeviceAdminSettings() {
        this.mAdmins = new ArrayList();
        this.mProfileOwnerComponents = new SparseArray();
    }

    static /* synthetic */ ArrayList access$000(DeviceAdminSettings r0) {
        return r0.mAdmins;
    }

    static /* synthetic */ boolean access$100(DeviceAdminSettings r0, DeviceAdminInfo r1) {
        return r0.isRemovingAdmin(r1);
    }

    static /* synthetic */ int access$200(DeviceAdminSettings r0, DeviceAdminInfo r1) {
        return r0.getUserId(r1);
    }

    static /* synthetic */ boolean access$300(DeviceAdminSettings r0, DeviceAdminInfo r1) {
        return r0.isActiveAdmin(r1);
    }

    public void com_android_settings_DeviceAdminSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // android.app.ListFragment, android.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mDPM = (DevicePolicyManager) getActivity().getSystemService("device_policy");
        this.mUm = (UserManager) getActivity().getSystemService(PickApplicationActivity.EXTRA_USER);
        return r2.inflate(R.layout.device_admin_settings, r3, false);
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
        setHasOptionsMenu(true);
        Utils.forceCustomPadding(getListView(), true);
    }

    public void com_android_settings_DeviceAdminSettings__onResume$___twin___() {
        super.onResume();
        ComponentName r0 = this.mDPM.getDeviceOwnerComponentOnAnyUser();
        if (r0 == null) goto L5;
        String r1 = r0.getPackageName();
    L6:
        this.mDeviceOwnerPkg = r1;
        this.mProfileOwnerComponents.clear();
        List<UserHandle> r2 = this.mUm.getUserProfiles();
        int r3 = r2.size();
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L9;
        int r5 = r2.get(r4).getIdentifier();
        this.mProfileOwnerComponents.put(r5, this.mDPM.getProfileOwnerAsUser(r5));
        r4 = r4 + 1;
        goto L7
    L9:
        updateList();
        return;
    L5:
        r1 = null;
        goto L6
    }

    void updateList() {
        this.mAdmins.clear();
        List<UserHandle> r0 = this.mUm.getUserProfiles();
        int r1 = r0.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        updateAvailableAdminsForProfile(r0.get(r2).getIdentifier());
        r2 = r2 + 1;
        goto L3
    L5:
        Collections.sort(this.mAdmins);
        getListView().setAdapter(new PolicyListAdapter(this));
    }

    @Override // android.app.ListFragment
    public void onListItemClick(ListView r1, View r2, int r3, long r4) {
        DeviceAdminInfo r5 = (DeviceAdminInfo) r1.getAdapter().getItem(r3);
        if ((r5 instanceof DeviceAdminInfo) == true) goto L5;
        return;
    L5:
        UserHandle r6 = new UserHandle(getUserId(r5));
        Activity r0 = getActivity();
        if (r0 == null) goto L9;
        Intent r7 = new Intent(r0, DeviceAdminAdd.class);
        r7.putExtra("android.app.extra.DEVICE_ADMIN", r5.getComponent());
        r0.startActivityAsUser(r7, r6);
        return;
    }

    private boolean isDeviceOwner(DeviceAdminInfo r3) {
        if (getUserId(r3) == UserHandle.myUserId()) goto L5;
    L7:
        return false;
    L5:
        if (r3.getPackageName().equals(this.mDeviceOwnerPkg) == false) goto L7;
        return true;
    }

    private boolean isProfileOwner(DeviceAdminInfo r2) {
        ComponentName r1 = this.mProfileOwnerComponents.get(getUserId(r2));
        return r2.getComponent().equals(r1);
    }

    private boolean isActiveAdmin(DeviceAdminInfo r3) {
        return this.mDPM.isAdminActiveAsUser(r3.getComponent(), getUserId(r3));
    }

    private boolean isRemovingAdmin(DeviceAdminInfo r3) {
        return this.mDPM.isRemovingAdmin(r3.getComponent(), getUserId(r3));
    }

    private void updateAvailableAdminsForProfile(int r2) {
        List r0 = this.mDPM.getActiveAdminsAsUser(r2);
        addActiveAdminsForProfile(r0, r2);
        addDeviceAdminBroadcastReceiversForProfile(r0, r2);
    }

    private void addDeviceAdminBroadcastReceiversForProfile(Collection<ComponentName> r9, int r10) {
        PackageManager r0 = getActivity().getPackageManager();
        List r11 = r0.queryBroadcastReceiversAsUser(new Intent("android.app.action.DEVICE_ADMIN_ENABLED"), 32896, r10);
        if (r11 != null) goto L5;
        r11 = Collections.emptyList();
    L5:
        int r1 = r11.size();
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L20;
        ResolveInfo r4 = (ResolveInfo) r11.get(r3);
        ComponentName r5 = new ComponentName(r4.activityInfo.packageName, r4.activityInfo.name);
        if (r9 != null) goto L10;
    L11:
        DeviceAdminInfo r6 = createDeviceAdminInfo(r4.activityInfo);
        if (r6 == null) goto L19;
        if (r6.isVisible() == false) goto L19;
        if (r6.getActivityInfo().applicationInfo.isInternal() == false) goto L19;
        DeviceAdminListItem r7 = new DeviceAdminListItem(null);
        r7.info = r6;
        r7.name = r6.loadLabel(r0).toString();
        r7.active = false;
        this.mAdmins.add(r7);
    L19:
        r3 = r3 + 1;
        goto L6
    L10:
        if (r9.contains(r5) == true) goto L19;
    }

    private void addActiveAdminsForProfile(List<ComponentName> r8, int r9) {
        if (r8 == null) goto L13;
        PackageManager r0 = getActivity().getPackageManager();
        IPackageManager r1 = AppGlobals.getPackageManager();
        int r2 = r8.size();
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L20;
        ComponentName r4 = r8.get(r3);
        DeviceAdminInfo r5 = createDeviceAdminInfo(r1.getReceiverInfo(r4, 32896, r9));
        if (r5 == null) goto L12;
        DeviceAdminListItem r6 = new DeviceAdminListItem(null);
        r6.info = r5;
        r6.name = r5.loadLabel(r0).toString();
        r6.active = true;
        this.mAdmins.add(r6);
    L12:
        r3 = r3 + 1;
    L11:
        OLog.w(TAG, "Unable to load component: " + r4);
        goto L12
    L20:
        return;
    }

    private DeviceAdminInfo createDeviceAdminInfo(ActivityInfo r3) {
        return new DeviceAdminInfo(getActivity(), r3);
    L4:
        e = move-exception;
        OLog.w(TAG, "Skipping " + r3, e);
        return null;
    }

    private int getUserId(DeviceAdminInfo r1) {
        return UserHandle.getUserId(r1.getActivityInfo().applicationInfo.uid);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_DeviceAdminSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(DeviceAdminSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DeviceAdminSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_Fragment " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DeviceAdminSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(DeviceAdminSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DeviceAdminSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_Fragment " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_DeviceAdminSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(DeviceAdminSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DeviceAdminSettings__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Fragment " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
