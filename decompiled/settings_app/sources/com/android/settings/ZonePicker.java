package com.android.settings;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import bytedanceos.util.NavigationBarHelper;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.utils.UIUtils;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.android.settingslib.datetime.ZoneGetter;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ZonePicker extends ListFragment {
    private static final int HOURS_1 = 3600000;
    private static final int MENU_ALPHABETICAL = 1;
    private static final int MENU_TIMEZONE = 2;
    private static final String TAG = "ZonePicker";
    private int defaultIndex;
    private boolean mIsSetResidentTimezone;
    private ZoneSelectionListener mListener;
    private boolean mSortedByTimezone;
    private BaseAdapter mTimezoneAdapter;

    private static class MyComparator implements Comparator<Map<?, ?>> {
        private String mSortingKey;

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Map<?, ?> r1, Map<?, ?> r2) {
            return compare2(r1, r2);
        }

        public MyComparator(String r1) {
            this.mSortingKey = r1;
        }

        public void setSortingKey(String r1) {
            this.mSortingKey = r1;
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Map<?, ?> r2, Map<?, ?> r3) {
            Object r4 = r2.get(this.mSortingKey);
            Object r5 = r3.get(this.mSortingKey);
            if (isComparable(r4) == true) goto L7;
            return isComparable(r5) ? 1 : 0;
        L7:
            if (isComparable(r5) == true) goto L11;
            return -1;
        L11:
            return ((Comparable) r4).compareTo(r5);
        }

        private boolean isComparable(Object r1) {
            if (r1 != null) goto L4;
        L6:
            return false;
        L4:
            if ((r1 instanceof Comparable) == false) goto L6;
            return true;
        }
    }

    private class TimeZoneAdapter extends SettingsAdapter {
        private List<Map<String, Object>> mList;
        final /* synthetic */ ZonePicker this$0;

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        public TimeZoneAdapter(ZonePicker r1, List<Map<String, Object>> r2) {
            this.this$0 = r1;
            this.mList = r2;
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public int getCount() {
            return this.mList.size();
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public Object getItem(int r1) {
            return this.mList.get(r1);
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public View getView(final int r5, View r6, final ViewGroup r7) {
            if (r6 != null) goto L4;
            r6 = View.inflate(r7.getContext(), R.layout.list_content_item_zone_picker, null);
            OCardListItem r0 = (OCardListItem) r6.findViewById(R.id.item_check);
            r6.setTag(r0);
        L5:
            r6.setClickable(false);
            r0.setOnContentClickListener(new ZonePicker$TimeZoneAdapter$$ExternalSyntheticLambda0(r7, r5));
            Map<String, Object> r8 = this.mList.get(r5);
            String r2 = (String) r8.get("name");
            String r9 = (String) r8.get(ZoneGetter.KEY_GMT);
            r0.setTitle(r2);
            r0.setSubTitle(r9);
            r0.showSubTitle(true);
            if (ZonePicker.access$000(this.this$0) != r5) goto L8;
            r0.showCustomEnd(true);
        L9:
            if (r5 != 0) goto L12;
            r0.setCardPosition(1);
        L15:
            return r6;
        L12:
            if (r5 != (getCount() - 1)) goto L14;
            r0.setCardPosition(3);
            goto L15
        L14:
            r0.setCardPosition(2);
            goto L15
        L8:
            r0.showCustomEnd(false);
            goto L9
        L4:
            r0 = (OCardListItem) r6.getTag();
            goto L5
        }

        static /* synthetic */ void lambda$getView$0(ViewGroup r2, int r3, View r4) {
            if ((r2 instanceof ListView) == false) goto L6;
            ((ListView) r2).performItemClick(r4, r3, r3);
            return;
        }
    }

    public interface ZoneSelectionListener {
        void onZoneSelected(TimeZone r1);
    }

    public void com_android_settings_ZonePicker__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_ZonePicker__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_ZonePicker__onResume$___twin___() {
        super.onResume();
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_ZonePicker_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(this, r1);
    }

    @Override // android.app.Fragment
    public void onPause() {
        com_android_settings_ZonePicker_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(this);
    }

    @Override // android.app.Fragment
    public void onResume() {
        com_android_settings_ZonePicker_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(this);
    }

    public ZonePicker() {
        this.defaultIndex = -1;
    }

    static /* synthetic */ int access$000(ZonePicker r0) {
        return r0.defaultIndex;
    }

    public static SimpleAdapter constructTimezoneAdapter(Context r1, boolean r2) {
        return constructTimezoneAdapter(r1, r2, R.layout.date_time_setup_custom_list_item_2);
    }

    public BaseAdapter constructTimezoneAdapter(Context r3) {
        MyComparator r0 = new MyComparator("offset");
        List<Map<String, Object>> r4 = ZoneGetter.getZonesList(r3);
        Collections.sort(r4, r0);
        return new TimeZoneAdapter(this, r4);
    }

    public static SimpleAdapter constructTimezoneAdapter(Context r8, boolean r9, int r10) {
        String r1 = "name";
        String[] r6 = {"name", ZoneGetter.KEY_GMT};
        int[] r7 = {android.R.id.text1, android.R.id.text2};
        if (r9 == true) goto L6;
        r1 = "offset";
    L6:
        MyComparator r11 = new MyComparator(r1);
        List<Map<String, Object>> r4 = ZoneGetter.getZonesList(r8);
        Collections.sort(r4, r11);
        return new SimpleAdapter(r8, r4, r10, r6, r7);
    }

    public static int getTimeZoneIndex(BaseAdapter r4, TimeZone r5) {
        String r6 = r5.getID();
        int r0 = r4.getCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        Map r2 = (Map) r4.getItem(r1);
        if (r2 == null) goto L9;
        if (r6.equals((String) r2.get("id")) == false) goto L9;
        return r1;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return -1;
    }

    public static String getTimezoneText(TimeZone r1, long r2) {
        int r3 = r1.getOffset(r2);
        int r4 = Math.abs(r3);
        StringBuilder r5 = new StringBuilder("GMT");
        if (r3 >= 0) goto L5;
        r5.append('-');
    L6:
        r5.append(r4 / 3600000);
        r5.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        int r6 = (r4 / 60000) % 60;
        if (r6 >= 10) goto L9;
        r5.append('0');
    L9:
        r5.append(r6);
        return r5.toString();
    L5:
        r5.append('+');
        goto L6
    }

    public static TimeZone obtainTimeZoneFromItem(Object r1) {
        return TimeZone.getTimeZone((String) ((Map) r1).get("id"));
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        this.mTimezoneAdapter = constructTimezoneAdapter(getActivity());
        ListView r4 = (ListView) getView().findViewById(android.R.id.list);
        if (SettingsFeature.isRoundCorner() == false) goto L5;
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(r4);
    L5:
        r4.setClipChildren(false);
        r4.setClipToPadding(false);
        r4.setDivider(null);
        setSorting(true);
        setHasOptionsMenu(false);
    }

    @Override // android.app.ListFragment, android.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        View r6 = r3.inflate(R.layout.o_list_content, r4, false);
        ListView r7 = (ListView) r6.findViewById(android.R.id.list);
        UIUtils.updatePadding(r7, -1, ResourceUtils.getResources().getDimensionPixelSize(R.dimen.main_settings_first_item_card_gap), -1, -1);
        UIUtils.setUpBottomPaddingOnApplyWindowInsets(r7);
        r7.setVerticalScrollBarEnabled(false);
        this.mIsSetResidentTimezone = getActivity().getIntent().getBooleanExtra(TimezoneSettingsActivity.EXTRA_RESIDENT_TIMEZONE_SETTINGS, false);
        OLog.d(TAG, "mIsSetResidentTimezone " + this.mIsSetResidentTimezone);
        return r6;
    }

    public void setZoneSelectionListener(ZoneSelectionListener r1) {
        this.mListener = r1;
    }

    private void setSorting(boolean r3) {
        setListAdapter(this.mTimezoneAdapter);
        this.mSortedByTimezone = r3;
        if (this.mIsSetResidentTimezone == false) goto L5;
        TimeZone r4 = getResidentTimezone(getActivity());
    L6:
        int r5 = getTimeZoneIndex(this.mTimezoneAdapter, r4);
        this.defaultIndex = r5;
        if (r5 < 0) goto L12;
        ListView r6 = getListView();
        if (r6 == null) goto L13;
        int r0 = ResourceUtils.getResources().getDimensionPixelSize(R.dimen.main_settings_first_item_card_gap);
        r6.setSelectionFromTop(this.defaultIndex, r0);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r4 = TimeZone.getDefault();
        goto L6
    }

    private TimeZone getResidentTimezone(Context r2) {
        String r1 = android.provider.Settings.Global.getString(r2.getContentResolver(), "resident_timezone");
        OLog.d(TAG, " residentTimezoneId " + r1);
        if (TextUtils.isEmpty(r1) == true) goto L6;
        return TimeZone.getTimeZone(r1);
    L6:
        return Calendar.getInstance().getTimeZone();
    }

    @Override // android.app.ListFragment
    public void onListItemClick(ListView r1, View r2, int r3, long r4) {
        if (isResumed() == true) goto L5;
        return;
    L5:
        Map r5 = (Map) r1.getItemAtPosition(r3);
        if (r5 != null) goto L8;
        return;
    L8:
        String r6 = (String) r5.get("id");
        Activity r7 = getActivity();
        if (this.mIsSetResidentTimezone == false) goto L11;
        android.provider.Settings.Global.putString(r7.getContentResolver(), "resident_timezone", r6);
    L12:
        TimeZone r8 = TimeZone.getTimeZone(r6);
        ZoneSelectionListener r9 = this.mListener;
        if (r9 == null) goto L15;
        r9.onZoneSelected(r8);
        return;
    L15:
        getActivity().onBackPressed();
        return;
    L11:
        ((AlarmManager) r7.getSystemService("alarm")).setTimeZone(r6);
        goto L12
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ZonePicker_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(ZonePicker r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ZonePicker__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_Fragment " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ZonePicker_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(ZonePicker r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ZonePicker__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_Fragment " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_ZonePicker_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(ZonePicker r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ZonePicker__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Fragment " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
