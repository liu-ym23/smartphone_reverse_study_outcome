package com.bytedanceos.security.permission;

import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.olog.OLog;
import com.obric.security.R;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class AppSecurityPermissions {
    private static final String TAG = "AppSecurityPermissions";
    public static final int WHICH_ALL = 65535;
    public static final int WHICH_NEW = 4;
    private static final boolean localLOGV = false;
    private final Context mContext;
    private final LayoutInflater mInflater;
    private final CharSequence mNewPermPrefix;
    private String mPackageName;
    private final PermissionInfoComparator mPermComparator;
    private final PermissionGroupInfoComparator mPermGroupComparator;
    private final Map<String, MyPermissionGroupInfo> mPermGroups;
    private final List<MyPermissionGroupInfo> mPermGroupsList;
    private final List<MyPermissionInfo> mPermsList;
    private PackageInfo mPkgInfo;
    private final PackageManager mPm;

    /* JADX INFO: renamed from: com.bytedanceos.security.permission.AppSecurityPermissions$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class MyPermissionGroupInfo extends PermissionGroupInfo {
        final ArrayList<MyPermissionInfo> mAllPermissions;
        CharSequence mLabel;
        final ArrayList<MyPermissionInfo> mNewPermissions;

        MyPermissionGroupInfo(PermissionInfo perm) {
            this.mNewPermissions = new ArrayList();
            this.mAllPermissions = new ArrayList();
            this.name = perm.packageName;
            this.packageName = perm.packageName;
        }

        MyPermissionGroupInfo(PermissionGroupInfo info) {
            super(info);
            this.mNewPermissions = new ArrayList();
            this.mAllPermissions = new ArrayList();
        }

        public Drawable loadGroupIcon(Context context, PackageManager pm) {
            if (this.icon == 0) goto L7;
            return loadUnbadgedIcon(pm);
        L7:
            return context.getDrawable(R.drawable.ic_perm_device_info);
        }
    }

    private static class MyPermissionInfo extends PermissionInfo {
        int mExistingReqFlags;
        CharSequence mLabel;
        boolean mNew;
        int mNewReqFlags;

        MyPermissionInfo(PermissionInfo info) {
            super(info);
        }
    }

    private static class PermissionGroupInfoComparator implements Comparator<MyPermissionGroupInfo> {
        private final Collator sCollator;

        private PermissionGroupInfoComparator() {
            this.sCollator = Collator.getInstance();
        }

        /* synthetic */ PermissionGroupInfoComparator(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(MyPermissionGroupInfo a2, MyPermissionGroupInfo b) {
            return compare2(a2, b);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public final int compare2(MyPermissionGroupInfo a2, MyPermissionGroupInfo b) {
            return this.sCollator.compare(a2.mLabel, b.mLabel);
        }
    }

    private static class PermissionInfoComparator implements Comparator<MyPermissionInfo> {
        private final Collator sCollator;

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(MyPermissionInfo a2, MyPermissionInfo b) {
            return compare2(a2, b);
        }

        PermissionInfoComparator() {
            this.sCollator = Collator.getInstance();
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public final int compare2(MyPermissionInfo a2, MyPermissionInfo b) {
            return this.sCollator.compare(a2.mLabel, b.mLabel);
        }
    }

    public static class PermissionItemView extends LinearLayout implements View.OnClickListener {
        AlertDialog mDialog;
        MyPermissionGroupInfo mGroup;
        private String mPackageName;
        MyPermissionInfo mPerm;
        private boolean mShowRevokeUI;

        static /* synthetic */ String access$100(PermissionItemView r0) {
            return r0.mPackageName;
        }

        static /* synthetic */ Context access$200(PermissionItemView r0) {
            return r0.mContext;
        }

        static /* synthetic */ Context access$300(PermissionItemView r0) {
            return r0.mContext;
        }

        public PermissionItemView(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.mShowRevokeUI = false;
            setClickable(true);
        }

        public void setPermission(MyPermissionGroupInfo grp, MyPermissionInfo perm, boolean first, CharSequence newPermPrefix, String packageName, boolean showRevokeUI) {
            this.mGroup = grp;
            this.mPerm = perm;
            this.mShowRevokeUI = showRevokeUI;
            this.mPackageName = packageName;
            TextView r1 = (TextView) findViewById(R.id.perm_name);
            TextView r3 = (TextView) findViewById(R.id.perm_desc);
            CharSequence r4 = perm.mLabel;
            if (r1 == null) goto L9;
            if (r4 == null) goto L9;
            if (perm.name.equals("android.permission.MANAGE_EXTERNAL_STORAGE") == false) goto L8;
            r1.setText(R.string.permission_storage_all);
            goto L9
        L8:
            r1.setText(r4);
        L9:
            String r0 = getPermissionDesc();
            if (r3 == null) goto L17;
            if (r0 != null) goto L13;
            return;
        L13:
            if (perm.name.equals("android.permission.MANAGE_EXTERNAL_STORAGE") == false) goto L15;
            r3.setText(R.string.allow_manage_external_storage_description);
            return;
        L15:
            r3.setText(r0);
            return;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (this.mGroup != null) goto L5;
            return;
        L5:
            if (this.mPerm == null) goto L28;
            AlertDialog r8 = this.mDialog;
            if (r8 == null) goto L9;
            r8.dismiss();
        L9:
            PackageManager r9 = getContext().getPackageManager();
            if (r9 != null) goto L12;
            return;
        L12:
            AlertDialog.Builder r0 = new AlertDialog.Builder(getContext());
            r0.setTitle(this.mGroup.mLabel);
            if (this.mPerm.descriptionRes == 0) goto L25;
            r0.setMessage(this.mPerm.loadDescription(r9));
        L23:
            r0.setCancelable(true);
            r0.setIcon(this.mGroup.loadGroupIcon(getContext(), r9));
            addRevokeUIIfNecessary(r0);
            AlertDialog r10 = r0.show();
            this.mDialog = r10;
            r10.setCanceledOnTouchOutside(true);
            return;
        L25:
            ApplicationInfo r3 = r9.getApplicationInfo(this.mPerm.packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L21
            if (r3 == null) goto L20;
            CharSequence r4 = r3.loadLabel(r9);     // Catch: PackageManager.NameNotFoundException -> L21
        L22:
            StringBuilder r5 = new StringBuilder(128);
            r5.append(getContext().getString(R.string.perms_description_app, new Object[]{r4}));
            r5.append("\n\n");
            r5.append(this.mPerm.name);
            r0.setMessage(r5.toString());
            goto L23
        L20:
            r4 = "";
        L21:
            r4 = this.mPerm.packageName;
            goto L22
        }

        private String getPermissionDesc() {
            if (this.mGroup != null) goto L5;
        L24:
            return null;
        L5:
            if (this.mPerm == null) goto L24;
            PackageManager r0 = getContext().getPackageManager();
            if (r0 != null) goto L10;
            return null;
        L10:
            if (this.mPerm.descriptionRes == 0) goto L25;
            CharSequence r5 = this.mPerm.loadDescription(r0);
            if (r5 != null) goto L14;
            return null;
        L14:
            return r5.toString();
        L25:
            ApplicationInfo r2 = r0.getApplicationInfo(this.mPerm.packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L21
            if (r2 == null) goto L20;
            CharSequence r1 = r2.loadLabel(r0);     // Catch: PackageManager.NameNotFoundException -> L21
        L22:
            StringBuilder r3 = new StringBuilder(128);
            r3.append(getContext().getString(R.string.perms_description_app, new Object[]{r1}));
            r3.append("\n\n");
            r3.append(this.mPerm.name);
            return r3.toString();
        L20:
            r1 = "";
        L21:
            r1 = this.mPerm.packageName;
            goto L22
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            AlertDialog r0 = this.mDialog;
            if (r0 == null) goto L6;
            r0.dismiss();
            return;
        }

        private void addRevokeUIIfNecessary(AlertDialog.Builder builder) {
            if (this.mShowRevokeUI == true) goto L5;
            return;
        L5:
            boolean r1 = true;
            if ((this.mPerm.mExistingReqFlags & 1) != 0) goto L9;
            r1 = false;
        L9:
            if (r1 == false) goto L11;
            return;
        L11:
            builder.setNegativeButton(android.R.string.status_bar_data_connection, new AnonymousClass1(this));
            builder.setPositiveButton(android.R.string.ok, null);
        }
    }

    private AppSecurityPermissions(Context context) {
        this.mPermGroups = new HashMap();
        this.mPermGroupsList = new ArrayList();
        this.mPermGroupComparator = new PermissionGroupInfoComparator(null);
        this.mPermComparator = new PermissionInfoComparator();
        this.mPermsList = new ArrayList();
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mPm = context.getPackageManager();
        this.mNewPermPrefix = context.getText(android.R.string.roamingText1);
    }

    public AppSecurityPermissions(Context context, String packageName) {
        this(context);
        this.mPackageName = packageName;
        HashSet r3 = new HashSet();
        PackageInfo r4 = this.mPm.getPackageInfo(packageName, 4096);     // Catch: PackageManager.NameNotFoundException -> L12
        this.mPkgInfo = r4;     // Catch: PackageManager.NameNotFoundException -> L12
        if (r4 != null) goto L6;
    L10:
        this.mPermsList.addAll(r3);
        setPermissions(this.mPermsList);
        return;
    L6:
        if (r4.applicationInfo == null) goto L10;
        if (this.mPkgInfo.applicationInfo.uid == (-1)) goto L10;
        getAllUsedPermissions(this.mPkgInfo.applicationInfo.uid, r3);
    }

    public AppSecurityPermissions(Context context, PackageInfo info) {
        this(context);
        HashSet r4 = new HashSet();
        if (info != null) goto L5;
        return;
    L5:
        this.mPackageName = info.packageName;
        if (info.requestedPermissions == null) goto L12;
        PackageInfo r0 = this.mPm.getPackageInfo(info.packageName, 4096);     // Catch: PackageManager.NameNotFoundException -> L9
    L10:
        extractPerms(info, r4, r0);
    L9:
        r0 = null;
    L12:
        if (info.sharedUserId != null) goto L18;
    L16:
        this.mPermsList.addAll(r4);
        setPermissions(this.mPermsList);
        return;
    L18:
        getAllUsedPermissions(this.mPm.getUidForSharedUser(info.sharedUserId), r4);     // Catch: PackageManager.NameNotFoundException -> L15
    L15:
        OLog.w(TAG, "Couldn't retrieve shared user id for: " + info.packageName);
        goto L16
    }

    public static View getPermissionItemView(Context context, CharSequence grpName, CharSequence description, boolean dangerous) {
        LayoutInflater r2 = (LayoutInflater) context.getSystemService("layout_inflater");
        if (dangerous == false) goto L5;
        int r0 = android.R.drawable.ic_signal_cellular_2_5_bar;
    L7:
        return getPermissionItemViewOld(context, r2, grpName, description, dangerous, context.getDrawable(r0));
    L5:
        r0 = android.R.drawable.pointer_wait_vector_2;
        goto L7
    }

    private void getAllUsedPermissions(int sharedUid, Set<MyPermissionInfo> permSet) {
        String[] r4 = this.mPm.getPackagesForUid(sharedUid);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.length == 0) goto L12;
        int r0 = r4.length;
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L13;
        getPermissionsForPackage(r4[r1], permSet);
        r1 = r1 + 1;
        goto L8
    L13:
        return;
    }

    private void getPermissionsForPackage(String packageName, Set<MyPermissionInfo> permSet) {
        PackageInfo r0 = this.mPm.getPackageInfo(packageName, 4096);     // Catch: PackageManager.NameNotFoundException -> L7
        if (r0 != null) goto L5;
        return;
    L5:
        extractPerms(r0, permSet, r0);     // Catch: PackageManager.NameNotFoundException -> L7
        return;
    L7:
        OLog.w(TAG, "Couldn't retrieve permissions for package: " + packageName);
    }

    private void extractPerms(PackageInfo info, Set<MyPermissionInfo> permSet, PackageInfo installedPkgInfo) {
        String[] r0 = info.requestedPermissions;
        int[] r10 = info.requestedPermissionsFlags;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length == 0) goto L66;
        int r2 = 0;
    L9:
        if (r2 >= r0.length) goto L67;
        String r3 = r0[r2];
        PermissionInfo r4 = this.mPm.getPermissionInfo(r3, 0);     // Catch: PackageManager.NameNotFoundException -> L54
        if (r4 == null) goto L55;
        if (installedPkgInfo != null) goto L16;
    L24:
        int r5 = -1;
    L25:
        if (r5 < 0) goto L27;
        int r6 = installedPkgInfo.requestedPermissionsFlags[r5];     // Catch: PackageManager.NameNotFoundException -> L54
    L29:
        if (isDisplayablePermission(r4, r10[r2], r6) == false) goto L55;
        String r7 = r4.group;     // Catch: PackageManager.NameNotFoundException -> L54
        if (r7 != null) goto L34;
        String r8 = r4.packageName;     // Catch: PackageManager.NameNotFoundException -> L54
        r4.group = r8;     // Catch: PackageManager.NameNotFoundException -> L54
    L36:
        if (this.mPermGroups.get(r8) != null) goto L47;
        if (r7 == null) goto L39;
        PermissionGroupInfo r9 = this.mPm.getPermissionGroupInfo(r7, 0);     // Catch: PackageManager.NameNotFoundException -> L54
    L40:
        if (r9 == null) goto L42;
        MyPermissionGroupInfo r11 = new MyPermissionGroupInfo(r9);     // Catch: PackageManager.NameNotFoundException -> L54
    L46:
        this.mPermGroups.put(r4.group, r11);     // Catch: PackageManager.NameNotFoundException -> L54
        goto L47
    L42:
        r4.group = r4.packageName;     // Catch: PackageManager.NameNotFoundException -> L54
        if (this.mPermGroups.get(r4.group) != null) goto L45;
        new MyPermissionGroupInfo(r4);     // Catch: PackageManager.NameNotFoundException -> L54
    L45:
        r11 = new MyPermissionGroupInfo(r4);     // Catch: PackageManager.NameNotFoundException -> L54
        goto L46
    L39:
        r9 = null;
    L47:
        if (installedPkgInfo != null) goto L49;
    L51:
        boolean r12 = false;
    L52:
        MyPermissionInfo r13 = new MyPermissionInfo(r4);     // Catch: PackageManager.NameNotFoundException -> L54
        r13.mNewReqFlags = r10[r2];     // Catch: PackageManager.NameNotFoundException -> L54
        r13.mExistingReqFlags = r6;     // Catch: PackageManager.NameNotFoundException -> L54
        r13.mNew = r12;     // Catch: PackageManager.NameNotFoundException -> L54
        permSet.add(r13);     // Catch: PackageManager.NameNotFoundException -> L54
        goto L55
    L49:
        if ((r6 & 2) != 0) goto L51;
        r12 = true;
        goto L52
    L34:
        r8 = r7;
        goto L36
    L27:
        r6 = 0;
        goto L29
    L16:
        if (installedPkgInfo.requestedPermissions == null) goto L24;
        r5 = 0;
    L19:
        if (r5 >= installedPkgInfo.requestedPermissions.length) goto L24;
        if (r3.equals(installedPkgInfo.requestedPermissions[r5]) == true) goto L25;
        r5 = r5 + 1;     // Catch: PackageManager.NameNotFoundException -> L54
    L55:
        r2 = r2 + 1;
    L54:
        OLog.i(TAG, "Ignoring unknown permission:" + r3);
        goto L55
    L67:
        return;
    }

    public int getPermissionCount() {
        return getPermissionCount(65535);
    }

    private List<MyPermissionInfo> getPermissionList(MyPermissionGroupInfo grp, int which) {
        if (which != 4) goto L7;
        return grp.mNewPermissions;
    L7:
        return grp.mAllPermissions;
    }

    public int getPermissionCount(int which) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= this.mPermGroupsList.size()) goto L6;
        r1 = r1 + getPermissionList(this.mPermGroupsList.get(r0), which).size();
        r0 = r0 + 1;
        goto L4
    L6:
        return r1;
    }

    public View getPermissionsView() {
        return getPermissionsView(65535, false);
    }

    public View getPermissionsViewWithRevokeButtons() {
        return getPermissionsView(65535, true);
    }

    public View getPermissionsView(int which) {
        return getPermissionsView(which, false);
    }

    private View getPermissionsView(int which, boolean showRevokeUI) {
        LinearLayout r0 = (LinearLayout) this.mInflater.inflate(R.layout.packageinstaller_app_perms_summary, null);
        LinearLayout r1 = (LinearLayout) r0.findViewById(R.id.perms_list);
        View r2 = r0.findViewById(R.id.no_permissions);
        displayPermissions(this.mPermGroupsList, r1, which, showRevokeUI);
        if (r1.getChildCount() > 0) goto L6;
        if (r2 == null) goto L6;
        r2.setVisibility(0);
    L6:
        return r0;
    }

    private void displayPermissions(List<MyPermissionGroupInfo> groups, LinearLayout permListView, int which, boolean showRevokeUI) {
        permListView.removeAllViews();
        int r1 = 0;
    L4:
        if (r1 >= groups.size()) goto L18;
        MyPermissionGroupInfo r2 = groups.get(r1);
        List<MyPermissionInfo> r9 = getPermissionList(r2, which);
        int r10 = 0;
    L7:
        if (r10 >= r9.size()) goto L17;
        MyPermissionInfo r5 = r9.get(r10);
        if (r10 != 0) goto L11;
        boolean r6 = true;
    L13:
        if (which == 4) goto L15;
        CharSequence r3 = this.mNewPermPrefix;
    L16:
        permListView.addView(getPermissionItemView(r2, r5, r6, r3, showRevokeUI), new LinearLayout.LayoutParams(-1, -2));
        r10 = r10 + 1;
        goto L7
    L15:
        r3 = null;
        goto L16
    L11:
        r6 = false;
        goto L13
    L17:
        r1 = r1 + 1;
        goto L4
    }

    private PermissionItemView getPermissionItemView(MyPermissionGroupInfo grp, MyPermissionInfo perm, boolean first, CharSequence newPermPrefix, boolean showRevokeUI) {
        return getPermissionItemView(this.mContext, this.mInflater, grp, perm, first, newPermPrefix, this.mPackageName, showRevokeUI);
    }

    private static PermissionItemView getPermissionItemView(Context context, LayoutInflater inflater, MyPermissionGroupInfo grp, MyPermissionInfo perm, boolean first, CharSequence newPermPrefix, String packageName, boolean showRevokeUI) {
        PermissionItemView r7 = (PermissionItemView) inflater.inflate(R.layout.packageinstaller_app_permission_item, null);
        r7.setPermission(grp, perm, first, newPermPrefix, packageName, showRevokeUI);
        return r7;
    }

    private static View getPermissionItemViewOld(Context context, LayoutInflater inflater, CharSequence grpName, CharSequence permList, boolean dangerous, Drawable icon) {
        if (inflater != null) goto L5;
        return null;
    L5:
        View r1 = inflater.inflate(R.layout.packageinstaller_app_permission_item_old, null);
        TextView r2 = (TextView) r1.findViewById(R.id.permission_group);
        TextView r5 = (TextView) r1.findViewById(R.id.permission_list);
        ImageView r0 = (ImageView) r1.findViewById(R.id.perm_icon);
        if (r0 == null) goto L8;
        r0.setImageDrawable(icon);
    L8:
        if (r2 == null) goto L13;
        if (r5 == null) goto L13;
        if (grpName == null) goto L12;
        r2.setText(grpName);
        r5.setText(permList);
        goto L13
    L12:
        r2.setText(permList);
        r5.setVisibility(8);
    L13:
        return r1;
    }

    private boolean isDisplayablePermission(PermissionInfo pInfo, int newReqFlags, int existingReqFlags) {
        int r4 = pInfo.protectionLevel & 15;
        if (r4 != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return false;
    L8:
        if (r4 != 1) goto L10;
    L13:
        boolean r5 = true;
    L15:
        if ((newReqFlags & 1) == 0) goto L17;
        boolean r3 = true;
    L19:
        if ((pInfo.protectionLevel & 32) == 0) goto L21;
        boolean r6 = true;
    L23:
        if ((existingReqFlags & 2) == 0) goto L25;
        boolean r7 = true;
    L27:
        if ((newReqFlags & 2) == 0) goto L29;
        boolean r8 = true;
    L30:
        if (r5 == false) goto L36;
        if (r3 == true) goto L34;
        if (r7 == true) goto L34;
        if (r8 == false) goto L36;
    L34:
        return true;
    L36:
        if (pInfo.name.equals("android.permission.MANAGE_EXTERNAL_STORAGE") == false) goto L38;
        return true;
    L38:
        if (r6 == false) goto L41;
        if (r7 == false) goto L41;
        return true;
    L41:
        return false;
    L29:
        r8 = false;
        goto L30
    L25:
        r7 = false;
        goto L27
    L21:
        r6 = false;
        goto L23
    L17:
        r3 = false;
        goto L19
    L10:
        if ((pInfo.protectionLevel & 128) != 0) goto L13;
        r5 = false;
        goto L15
    L5:
        r2 = false;
        goto L6
    }

    private void addPermToList(List<MyPermissionInfo> permList, MyPermissionInfo pInfo) {
        if (pInfo.mLabel != null) goto L5;
        pInfo.mLabel = pInfo.loadLabel(this.mPm);
    L5:
        int r1 = Collections.binarySearch(permList, pInfo, this.mPermComparator);
        if (r1 >= 0) goto L9;
        permList.add((-r1) - 1, pInfo);
        return;
    }

    private void setPermissions(List<MyPermissionInfo> permList) {
        if (permList == null) goto L17;
        Iterator<MyPermissionInfo> r5 = permList.iterator();
    L5:
        if (r5.hasNext() == false) goto L17;
        MyPermissionInfo r0 = r5.next();
        if (isDisplayablePermission(r0, r0.mNewReqFlags, r0.mExistingReqFlags) == false) goto L5;
        MyPermissionGroupInfo r1 = this.mPermGroups.get(r0.group);
        if (r1 == null) goto L5;
        r0.mLabel = r0.loadLabel(this.mPm);
        if (r0.name.equals("android.permission.MANAGE_EXTERNAL_STORAGE") == false) goto L14;
        r0.mLabel = this.mContext.getString(R.string.permission_storage_title);
    L14:
        addPermToList(r1.mAllPermissions, r0);
        if (r0.mNew == false) goto L5;
        addPermToList(r1.mNewPermissions, r0);
    L17:
        Iterator<MyPermissionGroupInfo> r6 = this.mPermGroups.values().iterator();
    L19:
        if (r6.hasNext() == false) goto L32;
        MyPermissionGroupInfo r2 = r6.next();
        if (r2.labelRes == 0) goto L23;
    L30:
        r2.mLabel = r2.loadLabel(this.mPm);
    L31:
        this.mPermGroupsList.add(r2);
        goto L19
    L23:
        if (r2.nonLocalizedLabel != null) goto L30;
        ApplicationInfo r3 = this.mPm.getApplicationInfo(r2.packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L29
        if (r3 == null) goto L31;
        r2.mLabel = r3.loadLabel(this.mPm);     // Catch: PackageManager.NameNotFoundException -> L29
    L29:
        r2.mLabel = r2.loadLabel(this.mPm);
        goto L31
    L32:
        Collections.sort(this.mPermGroupsList, this.mPermGroupComparator);
    }
}
