package com.android.settings.applock.data;

import android.content.Context;
import android.content.pm.LauncherApps;
import android.os.Handler;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.android.settings.R;
import com.android.settings.applock.AppLockManager;
import com.android.settings.pinyin.PinyinUtils;
import com.android.settings.stickylistheaders.StickyListHeadersAdapter;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import obric.widget.ListContentItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class SwitchAdapter extends ArrayAdapter<AppEntry> implements AbsListView.RecyclerListener, StickyListHeadersAdapter {
    private static final String DUP_LAUNCH_SUFF = "@";
    private static final char ENCRYPT_CHAR = '1';
    private static final int PACKAGE_ADD_MESSAGE = 1;
    private static final int PACKAGE_REMOVE_MESSAGE = 2;
    private static final String TAG = "SwitchedAdapter";
    private static final char UNENCRYPT_CHAR = '0';
    private static int sCurrentSortMode = 2;
    private static boolean sInSearchMode = false;
    private final Context mContext;
    protected List<AppEntry> mEntries;
    private final Handler mHandler;
    final LayoutInflater mInflater;
    private final LauncherApps.Callback mLauncherCallback;
    private final HashMap<Character, Integer> mPositionOfSections;
    private final ArrayList<String> mSections;
    private final CompoundButton.OnCheckedChangeListener mSwitchCheckChangeListener;

    static class HeaderViewHolder {
        OSectionTitleBar headerText;

        HeaderViewHolder() {
        }
    }

    static class SwitchViewHolder {
        final ListContentItemSwitch item;

        public SwitchViewHolder(View r2) {
            this.item = (ListContentItemSwitch) r2.findViewById(R.id.app_info);
        }
    }

    static {
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View r1) {
    }

    static /* synthetic */ Context access$000(SwitchAdapter r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$100(SwitchAdapter r0) {
        r0.updateData();
    }

    static /* synthetic */ int access$200() {
        return sCurrentSortMode;
    }

    static /* synthetic */ Handler access$300(SwitchAdapter r0) {
        return r0.mHandler;
    }

    public SwitchAdapter(Context r3, int r4) {
        super(r3, r4);
        this.mEntries = new ArrayList();
        this.mPositionOfSections = new HashMap();
        this.mSections = new ArrayList();
        Handler r5 = new Handler(new AnonymousClass1(this));
        this.mHandler = r5;
        this.mSwitchCheckChangeListener = new AnonymousClass2(this);
        LauncherApps.Callback r0 = new AnonymousClass3(this);
        this.mLauncherCallback = r0;
        this.mContext = r3;
        this.mInflater = (LayoutInflater) r3.getSystemService("layout_inflater");
        ((LauncherApps) r3.getSystemService("launcherapps")).registerCallback(r0, r5);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        List<AppEntry> r0 = this.mEntries;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int r5, View r6, ViewGroup r7) {
        AppEntry r8 = this.mEntries.get(r5);
        int r0 = UserHandle.getUserId(r8.getApplicationInfo().uid);
        if (r6 != null) goto L5;
        r6 = this.mInflater.inflate(R.layout.autostart_item_scroll_layout, null);
        SwitchViewHolder r2 = new SwitchViewHolder(r6);
        r6.setTag(r2);
    L6:
        AppEntry r9 = this.mEntries.get(r5);
        r2.item.setTitle(r8.getLabel());
        r2.item.setIcon(r8.getIcon());
        r2.item.getSwitch().setTag(r8);
        r2.item.getSwitch().setOnCheckedChangeListener(null);
        if (r0 <= 0) goto L9;
        r2.item.setChecked(AppLockManager.getInstance(this.mContext).isAppLocked(r8.getPackageName() + DUP_LAUNCH_SUFF + r0));
    L10:
        r2.item.getSwitch().setOnCheckedChangeListener(this.mSwitchCheckChangeListener);
        if (sCurrentSortMode == 2) goto L13;
        int r4 = this.mContext.getResources().getDimensionPixelSize(R.dimen.application_lock_list_item_normal_margin_right);
    L17:
        LinearLayout.LayoutParams r10 = (LinearLayout.LayoutParams) r2.item.getSwitch().getLayoutParams();
        r10.setMargins(0, 0, r4, 0);
        r2.item.getSwitch().setLayoutParams(r10);
        return r6;
    L13:
        if (sInSearchMode == false) goto L15;
        r4 = this.mContext.getResources().getDimensionPixelSize(R.dimen.application_lock_list_item_normal_margin_right);
        goto L17
    L15:
        r4 = this.mContext.getResources().getDimensionPixelSize(R.dimen.application_lock_list_item_margin_right);
        goto L17
    L9:
        r2.item.setChecked(r8.getAppLockedStatus());
        goto L10
    L5:
        r2 = (SwitchViewHolder) r6.getTag();
        goto L6
    }

    public void setData(List<AppEntry> r3, boolean r4) {
        clear();
        this.mEntries = r3;
        int r0 = sCurrentSortMode;
        if (r0 != 1) goto L6;
        Collections.sort(r3, AppLockComparator.sSwitchComparator);
    L8:
        if (r4 == false) goto L10;
        initSections();
    L10:
        notifyDataSetChanged();
        return;
    L6:
        if (r0 != 2) goto L8;
        Collections.sort(r3, AppLockComparator.sAlphaComparator);
        goto L8
    }

    @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
    public View getHeaderView(int r4, View r5, ViewGroup r6) {
        if (r5 != null) goto L4;
    L7:
        HeaderViewHolder r7 = new HeaderViewHolder();
        r5 = this.mInflater.inflate(R.layout.sticky_list_header_view, null);
        r7.headerText = (OSectionTitleBar) r5.findViewById(R.id.sticky_header);
        r5.setTag(r7);
    L8:
        List<AppEntry> r0 = this.mEntries;
        int r1 = sCurrentSortMode;
        if (r1 != 1) goto L16;
        if (r0.get(r4).getAppLockedStatus() == false) goto L13;
        String r8 = this.mContext.getString(R.string.security_encrypt_application);
    L14:
        Collections.sort(this.mEntries, AppLockComparator.sSwitchComparator);
    L21:
        r7.headerText.setTitleText(r8);
        return r5;
    L13:
        r8 = this.mContext.getString(R.string.security_unencrypt_application);
        goto L14
    L16:
        if (r1 == 2) goto L18;
    L20:
        r8 = "#";
        goto L21
    L18:
        if (r0.get(r4).mLabelEntry == null) goto L20;
        r8 = Character.toString(r0.get(r4).mLabelEntry.firstChar);
        goto L21
    L4:
        if ((r5.getTag() instanceof HeaderViewHolder) == false) goto L7;
        r7 = (HeaderViewHolder) r5.getTag();
        goto L8
    }

    @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
    public long getHeaderId(int r4) {
        List<AppEntry> r3 = this.mEntries;
        int r0 = sCurrentSortMode;
        if (r0 != 1) goto L9;
        if (r3.get(r4).getAppLockedStatus() == false) goto L7;
        char r5 = ENCRYPT_CHAR;
    L15:
        return r5;
    L7:
        r5 = UNENCRYPT_CHAR;
        goto L15
    L9:
        if (r0 == 2) goto L11;
    L13:
        r5 = '#';
        goto L15
    L11:
        if (r3.get(r4).mLabelEntry == null) goto L13;
        r5 = r3.get(r4).mLabelEntry.firstChar;
        goto L15
    }

    public int getPositionForSection(int r1) {
        Integer r0 = this.mPositionOfSections.get(Character.valueOf((char) r1));
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.intValue();
    }

    private void initSections() {
        this.mSections.clear();
        this.mPositionOfSections.clear();
        List<AppEntry> r0 = this.mEntries;
        if (r0.size() <= 0) goto L11;
        String r2 = String.valueOf(r0.get(0).mLabelEntry.firstChar);
        this.mSections.add(r2);
        this.mPositionOfSections.put(Character.valueOf(r0.get(0).mLabelEntry.firstChar), 0);
        int r1 = 1;
    L6:
        if (r1 >= r0.size()) goto L15;
        String r3 = String.valueOf(r0.get(r1).mLabelEntry.firstChar);
        if (r2.equals(r3) == true) goto L10;
        this.mSections.add(r3);
        this.mPositionOfSections.put(Character.valueOf(r0.get(r1).mLabelEntry.firstChar), Integer.valueOf(r1));
        r2 = r3;
    L10:
        r1 = r1 + 1;
        goto L6
    L15:
        return;
    }

    public ArrayList<AppEntry> query(String r6) {
        ArrayList<AppEntry> r0 = new ArrayList();
        if (TextUtils.isEmpty(r6) == true) goto L17;
        List<AppEntry> r5 = this.mEntries;
        String r7 = r6.toUpperCase();
        if (r5 == null) goto L17;
        Iterator<AppEntry> r8 = r5.iterator();
    L8:
        if (r8.hasNext() == false) goto L17;
        AppEntry r1 = r8.next();
        boolean r2 = r1.getLabel().toUpperCase().contains(r7);
        boolean r3 = r1.mLabelEntry.firstLetters.toUpperCase().contains(r7);
        if (PinyinUtils.isChinese(r7) == true) goto L12;
        boolean r4 = r1.mLabelEntry.labelPinyin.toUpperCase().contains(r7);
    L13:
        if (r2 == true) goto L16;
        if (r4 == true) goto L16;
        if (r3 == false) goto L8;
    L16:
        r0.add(r1);
        goto L8
    L12:
        r4 = false;
    L17:
        return r0;
    }

    public ArrayList<String> getSections() {
        return this.mSections;
    }

    public void setCurrentSortMode(int r1) {
        sCurrentSortMode = r1;
    }

    private void updateData() {
        setData(AppLockListInfo.newInstance(this.mContext).getAppEntries(), true);
    }

    public void setInSearchMode(boolean r1) {
        sInSearchMode = r1;
    }
}
