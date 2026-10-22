package com.android.widget;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
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

/* JADX INFO: loaded from: classes.dex */
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
    private final PackageManager mPm;

    /* JADX INFO: renamed from: com.android.widget.AppSecurityPermissions$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class MyPermissionGroupInfo extends PermissionGroupInfo {
        final ArrayList<MyPermissionInfo> mAllPermissions;
        CharSequence mLabel;
        final ArrayList<MyPermissionInfo> mNewPermissions;

        MyPermissionGroupInfo(PermissionInfo r2) {
            this.mNewPermissions = new ArrayList();
            this.mAllPermissions = new ArrayList();
            this.name = r2.packageName;
            this.packageName = r2.packageName;
        }

        MyPermissionGroupInfo(PermissionGroupInfo r1) {
            super(r1);
            this.mNewPermissions = new ArrayList();
            this.mAllPermissions = new ArrayList();
        }

        public Drawable loadGroupIcon(Context r2, PackageManager r3) {
            if (this.icon == 0) goto L7;
            return loadUnbadgedIcon(r3);
        L7:
            return r2.getDrawable(R.drawable.pointer_vertical_text_large_icon);
        }
    }

    private static class MyPermissionInfo extends PermissionInfo {
        int mExistingReqFlags;
        CharSequence mLabel;
        boolean mNew;
        int mNewReqFlags;

        MyPermissionInfo(PermissionInfo r1) {
            super(r1);
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
        public /* bridge */ /* synthetic */ int compare(MyPermissionGroupInfo r1, MyPermissionGroupInfo r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public final int compare2(MyPermissionGroupInfo r1, MyPermissionGroupInfo r2) {
            return this.sCollator.compare(r1.mLabel, r2.mLabel);
        }
    }

    private static class PermissionInfoComparator implements Comparator<MyPermissionInfo> {
        private final Collator sCollator;

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(MyPermissionInfo r1, MyPermissionInfo r2) {
            return compare2(r1, r2);
        }

        PermissionInfoComparator() {
            this.sCollator = Collator.getInstance();
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public final int compare2(MyPermissionInfo r1, MyPermissionInfo r2) {
            return this.sCollator.compare(r1.mLabel, r2.mLabel);
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

        public PermissionItemView(Context r1, AttributeSet r2) {
            super(r1, r2);
            this.mShowRevokeUI = false;
            setClickable(true);
        }

        public void setPermission(MyPermissionGroupInfo r1, MyPermissionInfo r2, boolean r3, CharSequence r4, String r5, boolean r6) {
            this.mGroup = r1;
            this.mPerm = r2;
            this.mShowRevokeUI = r6;
            this.mPackageName = r5;
            TextView r7 = (TextView) findViewById(R.id.search_button);
            CharSequence r8 = r2.mLabel;
            CharSequence r9 = r8;
            r9 = r8;
            if (r2.mNew == false) goto L6;
            if (r4 == null) goto L6;
            SpannableStringBuilder r10 = new SpannableStringBuilder();
            Parcel r11 = Parcel.obtain();
            TextUtils.writeToParcel(r4, r11, 0);
            r11.setDataPosition(0);
            CharSequence r12 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r11);
            r11.recycle();
            r10.append(r12);
            r10.append(r8);
            r9 = r10;
        L6:
            r7.setText(r9);
            String r0 = getPermissionDesc();
            if (r0 != null) goto L9;
            return;
        L9:
            TextView r13 = null;
            r13.setText(r0);
            throw null;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r8) {
            if (this.mGroup != null) goto L5;
            return;
        L5:
            if (this.mPerm == null) goto L22;
            AlertDialog r9 = this.mDialog;
            if (r9 == null) goto L9;
            r9.dismiss();
        L9:
            PackageManager r10 = getContext().getPackageManager();
            AlertDialog.Builder r0 = new AlertDialog.Builder(getContext());
            r0.setTitle(this.mGroup.mLabel);
            if (this.mPerm.descriptionRes == 0) goto L19;
            r0.setMessage(this.mPerm.loadDescription(r10));
        L17:
            r0.setCancelable(true);
            r0.setIcon(this.mGroup.loadGroupIcon(getContext(), r10));
            addRevokeUIIfNecessary(r0);
            AlertDialog r11 = r0.show();
            this.mDialog = r11;
            r11.setCanceledOnTouchOutside(true);
            return;
        L19:
            CharSequence r3 = r10.getApplicationInfo(this.mPerm.packageName, 0).loadLabel(r10);     // Catch: PackageManager.NameNotFoundException -> L15
        L16:
            StringBuilder r4 = new StringBuilder(128);
            r4.append(getContext().getString(R.string.satellite_messaging_not_supported_notification_summary, new Object[]{r3}));
            r4.append("\n\n");
            r4.append(this.mPerm.name);
            r0.setMessage(r4.toString());
        L15:
            r3 = this.mPerm.packageName;
            goto L16
        }

        private String getPermissionDesc() {
            if (this.mGroup != null) goto L5;
        L18:
            return null;
        L5:
            if (this.mPerm == null) goto L18;
            PackageManager r0 = getContext().getPackageManager();
            if (this.mPerm.descriptionRes == 0) goto L19;
            CharSequence r5 = this.mPerm.loadDescription(r0);
            if (r5 != null) goto L11;
            return null;
        L11:
            return r5.toString();
        L19:
            CharSequence r1 = r0.getApplicationInfo(this.mPerm.packageName, 0).loadLabel(r0);     // Catch: PackageManager.NameNotFoundException -> L15
        L16:
            StringBuilder r2 = new StringBuilder(128);
            r2.append(getContext().getString(R.string.satellite_messaging_not_supported_notification_summary, new Object[]{r1}));
            r2.append("\n\n");
            r2.append(this.mPerm.name);
            return r2.toString();
        L15:
            r1 = this.mPerm.packageName;
            goto L16
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            AlertDialog r0 = this.mDialog;
            if (r0 == null) goto L6;
            r0.dismiss();
            return;
        }

        private void addRevokeUIIfNecessary(AlertDialog.Builder r3) {
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
            r3.setNegativeButton(R.string.stk_cc_ss_to_dial_video, new AnonymousClass1(this));
            r3.setPositiveButton(R.string.ok, null);
        }
    }

    private AppSecurityPermissions(Context r3) {
        this.mPermGroups = new HashMap();
        this.mPermGroupsList = new ArrayList();
        this.mPermGroupComparator = new PermissionGroupInfoComparator(null);
        this.mPermComparator = new PermissionInfoComparator();
        this.mPermsList = new ArrayList();
        this.mContext = r3;
        this.mInflater = (LayoutInflater) r3.getSystemService("layout_inflater");
        this.mPm = r3.getPackageManager();
        this.mNewPermPrefix = r3.getText(R.string.satellite_messaging_not_supported_notification_title);
    }

    public AppSecurityPermissions(Context r3, String r4) {
        this(r3);
        this.mPackageName = r4;
        HashSet r5 = new HashSet();
        PackageInfo r6 = this.mPm.getPackageInfo(r4, 4096);     // Catch: PackageManager.NameNotFoundException -> L12
        if (r6 != null) goto L6;
    L10:
        this.mPermsList.addAll(r5);
        setPermissions(this.mPermsList);
        return;
    L6:
        if (r6.applicationInfo == null) goto L10;
        if (r6.applicationInfo.uid == (-1)) goto L10;
        getAllUsedPermissions(r6.applicationInfo.uid, r5);
    L12:
        OLog.w(TAG, "Couldn't retrieve permissions for package:" + r4);
    }

    public AppSecurityPermissions(Context r4, PackageInfo r5) {
        this(r4);
        HashSet r6 = new HashSet();
        if (r5 != null) goto L5;
        return;
    L5:
        this.mPackageName = r5.packageName;
        if (r5.requestedPermissions == null) goto L12;
        PackageInfo r0 = this.mPm.getPackageInfo(r5.packageName, 4096);     // Catch: PackageManager.NameNotFoundException -> L9
    L10:
        extractPerms(r5, r6, r0);
    L9:
        r0 = null;
    L12:
        if (r5.sharedUserId != null) goto L18;
    L16:
        this.mPermsList.addAll(r6);
        setPermissions(this.mPermsList);
        return;
    L18:
        getAllUsedPermissions(this.mPm.getUidForSharedUser(r5.sharedUserId), r6);     // Catch: PackageManager.NameNotFoundException -> L15
    L15:
        OLog.w(TAG, "Couldn't retrieve shared user id for: " + r5.packageName);
        goto L16
    }

    public static View getPermissionItemView(Context r7, CharSequence r8, CharSequence r9, boolean r10) {
        LayoutInflater r2 = (LayoutInflater) r7.getSystemService("layout_inflater");
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r10 == false) goto L8;
        int r0 = R.drawable.ic_signal_cellular_3_5_bar;
    L10:
        return getPermissionItemViewOld(r7, r2, r8, r9, r10, r7.getDrawable(r0));
    L8:
        r0 = R.drawable.pointer_wait_vector_21;
        goto L10
    }

    private void getAllUsedPermissions(int r4, Set<MyPermissionInfo> r5) {
        String[] r6 = this.mPm.getPackagesForUid(r4);
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.length == 0) goto L12;
        int r0 = r6.length;
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L13;
        getPermissionsForPackage(r6[r1], r5);
        r1 = r1 + 1;
        goto L8
    L13:
        return;
    }

    private void getPermissionsForPackage(String r3, Set<MyPermissionInfo> r4) {
        PackageInfo r0 = this.mPm.getPackageInfo(r3, 4096);     // Catch: PackageManager.NameNotFoundException -> L4
        extractPerms(r0, r4, r0);     // Catch: PackageManager.NameNotFoundException -> L4
        return;
    L4:
        OLog.w(TAG, "Couldn't retrieve permissions for package: " + r3);
    }

    private void extractPerms(PackageInfo r10, Set<MyPermissionInfo> r11, PackageInfo r12) {
        String[] r0 = r10.requestedPermissions;
        int[] r13 = r10.requestedPermissionsFlags;
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
        if (r12 != null) goto L16;
    L24:
        int r5 = -1;
    L25:
        if (r5 < 0) goto L27;
        int r6 = r12.requestedPermissionsFlags[r5];     // Catch: PackageManager.NameNotFoundException -> L54
    L29:
        if (isDisplayablePermission(r4, r13[r2], r6) == false) goto L55;
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
        MyPermissionGroupInfo r14 = new MyPermissionGroupInfo(r9);     // Catch: PackageManager.NameNotFoundException -> L54
    L46:
        this.mPermGroups.put(r4.group, r14);     // Catch: PackageManager.NameNotFoundException -> L54
        goto L47
    L42:
        r4.group = r4.packageName;     // Catch: PackageManager.NameNotFoundException -> L54
        if (this.mPermGroups.get(r4.group) != null) goto L45;
        new MyPermissionGroupInfo(r4);     // Catch: PackageManager.NameNotFoundException -> L54
    L45:
        r14 = new MyPermissionGroupInfo(r4);     // Catch: PackageManager.NameNotFoundException -> L54
        goto L46
    L39:
        r9 = null;
    L47:
        if (r12 != null) goto L49;
    L51:
        boolean r15 = false;
    L52:
        MyPermissionInfo r16 = new MyPermissionInfo(r4);     // Catch: PackageManager.NameNotFoundException -> L54
        r16.mNewReqFlags = r13[r2];     // Catch: PackageManager.NameNotFoundException -> L54
        r16.mExistingReqFlags = r6;     // Catch: PackageManager.NameNotFoundException -> L54
        r16.mNew = r15;     // Catch: PackageManager.NameNotFoundException -> L54
        r11.add(r16);     // Catch: PackageManager.NameNotFoundException -> L54
        goto L55
    L49:
        if ((r6 & 2) != 0) goto L51;
        r15 = true;
        goto L52
    L34:
        r8 = r7;
        goto L36
    L27:
        r6 = 0;
        goto L29
    L16:
        if (r12.requestedPermissions == null) goto L24;
        r5 = 0;
    L19:
        if (r5 >= r12.requestedPermissions.length) goto L24;
        if (r3.equals(r12.requestedPermissions[r5]) == true) goto L25;
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

    private List<MyPermissionInfo> getPermissionList(MyPermissionGroupInfo r1, int r2) {
        if (r2 != 4) goto L7;
        return r1.mNewPermissions;
    L7:
        return r1.mAllPermissions;
    }

    public int getPermissionCount(int r4) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= this.mPermGroupsList.size()) goto L6;
        r1 = r1 + getPermissionList(this.mPermGroupsList.get(r0), r4).size();
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

    public View getPermissionsView(int r2) {
        return getPermissionsView(r2, false);
    }

    private View getPermissionsView(int r5, boolean r6) {
        LinearLayout r0 = (LinearLayout) this.mInflater.inflate(R.layout.autofill_dataset_picker_fullscreen, null);
        LinearLayout r1 = (LinearLayout) NullSafe.nonNull(r0.findViewById(R.id.search_plate));
        View r2 = NullSafe.nonNull(r0.findViewById(R.id.polite));
        displayPermissions(this.mPermGroupsList, r1, r5, r6);
        if (r1.getChildCount() > 0) goto L5;
        r2.setVisibility(0);
    L5:
        return r0;
    }

    private void displayPermissions(List<MyPermissionGroupInfo> r12, LinearLayout r13, int r14, boolean r15) {
        r13.removeAllViews();
        int r1 = 0;
    L4:
        if (r1 >= r12.size()) goto L18;
        MyPermissionGroupInfo r2 = r12.get(r1);
        List<MyPermissionInfo> r9 = getPermissionList(r2, r14);
        int r10 = 0;
    L7:
        if (r10 >= r9.size()) goto L17;
        MyPermissionInfo r5 = r9.get(r10);
        if (r10 != 0) goto L11;
        boolean r6 = true;
    L13:
        if (r14 == 4) goto L15;
        CharSequence r3 = this.mNewPermPrefix;
    L16:
        r13.addView(getPermissionItemView(r2, r5, r6, r3, r15), new LinearLayout.LayoutParams(-1, -2));
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

    private PermissionItemView getPermissionItemView(MyPermissionGroupInfo r9, MyPermissionInfo r10, boolean r11, CharSequence r12, boolean r13) {
        return getPermissionItemView(this.mContext, this.mInflater, r9, r10, r11, r12, this.mPackageName, r13);
    }

    private static PermissionItemView getPermissionItemView(Context r7, LayoutInflater r8, MyPermissionGroupInfo r9, MyPermissionInfo r10, boolean r11, CharSequence r12, String r13, boolean r14) {
        PermissionItemView r15 = (PermissionItemView) r8.inflate(R.layout.app_perms_summary, null);
        r15.setPermission(r9, r10, r11, r12, r13, r14);
        return r15;
    }

    private static View getPermissionItemViewOld(Context r1, LayoutInflater r2, CharSequence r3, CharSequence r4, boolean r5, Drawable r6) {
        View r7 = r2.inflate(R.layout.autofill_dataset_picker, null);
        TextView r8 = (TextView) NullSafe.nonNull(r7.findViewById(R.id.search_edit_frame));
        TextView r9 = (TextView) NullSafe.nonNull(r7.findViewById(R.id.search_mag_icon));
        ((ImageView) NullSafe.nonNull(r7.findViewById(R.id.search_app_icon))).setImageDrawable(r6);
        if (r3 == null) goto L5;
        r8.setText(r3);
        r9.setText(r4);
    L6:
        return r7;
    L5:
        r8.setText(r4);
        r9.setVisibility(8);
        goto L6
    }

    private boolean isDisplayablePermission(PermissionInfo r4, int r5, int r6) {
        int r3 = r4.protectionLevel & 15;
        if (r3 != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return false;
    L8:
        if (r3 != 1) goto L10;
    L13:
        boolean r7 = true;
    L15:
        if ((r5 & 1) == 0) goto L17;
        boolean r8 = true;
    L19:
        if ((r4.protectionLevel & 32) == 0) goto L21;
        boolean r9 = true;
    L23:
        if ((r6 & 2) == 0) goto L25;
        boolean r10 = true;
    L27:
        if ((r5 & 2) == 0) goto L29;
        boolean r11 = true;
    L30:
        if (r7 == false) goto L35;
        if (r8 == true) goto L34;
        if (r10 == true) goto L34;
        if (r11 == false) goto L35;
    L34:
        return true;
    L35:
        if (r9 == false) goto L38;
        if (r10 == false) goto L38;
        return true;
    L38:
        return false;
    L29:
        r11 = false;
        goto L30
    L25:
        r10 = false;
        goto L27
    L21:
        r9 = false;
        goto L23
    L17:
        r8 = false;
        goto L19
    L10:
        if ((r4.protectionLevel & 128) != 0) goto L13;
        r7 = false;
        goto L15
    L5:
        r2 = false;
        goto L6
    }

    private void addPermToList(List<MyPermissionInfo> r4, MyPermissionInfo r5) {
        if (r5.mLabel != null) goto L5;
        r5.mLabel = r5.loadSafeLabel(this.mPm, 20000.0f, 5);
    L5:
        int r3 = Collections.binarySearch(r4, r5, this.mPermComparator);
        if (r3 >= 0) goto L9;
        r4.add((-r3) - 1, r5);
        return;
    }

    private void setPermissions(List<MyPermissionInfo> r7) {
        if (r7 == null) goto L15;
        Iterator<MyPermissionInfo> r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L15;
        MyPermissionInfo r2 = r8.next();
        if (isDisplayablePermission(r2, r2.mNewReqFlags, r2.mExistingReqFlags) == false) goto L6;
        MyPermissionGroupInfo r3 = this.mPermGroups.get(r2.group);
        if (r3 == null) goto L6;
        r2.mLabel = r2.loadSafeLabel(this.mPm, 20000.0f, 5);
        addPermToList(r3.mAllPermissions, r2);
        if (r2.mNew == false) goto L6;
        addPermToList(r3.mNewPermissions, r2);
    L15:
        Iterator<MyPermissionGroupInfo> r9 = this.mPermGroups.values().iterator();
    L17:
        if (r9.hasNext() == false) goto L28;
        MyPermissionGroupInfo r4 = r9.next();
        if (r4.labelRes == 0) goto L21;
    L26:
        r4.mLabel = r4.loadSafeLabel(this.mPm, 20000.0f, 5);
    L27:
        this.mPermGroupsList.add(r4);
        goto L17
    L21:
        if (r4.nonLocalizedLabel != null) goto L26;
        r4.mLabel = this.mPm.getApplicationInfo(r4.packageName, 0).loadSafeLabel(this.mPm, 20000.0f, 5);     // Catch: PackageManager.NameNotFoundException -> L25
    L25:
        r4.mLabel = r4.loadSafeLabel(this.mPm, 20000.0f, 5);
        goto L27
    L28:
        Collections.sort(this.mPermGroupsList, this.mPermGroupComparator);
    }
}
