package com.android.settings.inputmethod;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.hardware.input.InputDeviceIdentifier;
import android.hardware.input.InputManager;
import android.hardware.input.KeyboardLayout;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.InputDevice;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreference;
import com.android.internal.inputmethod.InputMethodUtils;
import com.android.internal.util.Preconditions;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public final class PhysicalKeyboardFragment extends SettingsPreferenceFragment implements InputManager.InputDeviceListener {
    private static final String IM_SUBTYPE_MODE_KEYBOARD = "keyboard";
    private static final String KEYBOARD_ASSISTANCE_CATEGORY = "keyboard_assistance_category";
    private static final String KEYBOARD_SHORTCUTS_HELPER = "keyboard_shortcuts_helper";
    private static final String SHOW_VIRTUAL_KEYBOARD_SWITCH = "show_virtual_keyboard_switch";
    private final ContentObserver mContentObserver;
    private InputManager mIm;
    private PreferenceCategory mKeyboardAssistanceCategory;
    private final List<HardKeyboardDeviceInfo> mLastHardKeyboards;
    private final HashSet<Integer> mLoaderIDs;
    private int mNextLoaderId;
    private InputMethodUtils.InputMethodSettings mSettings;
    private SwitchPreference mShowVirtualKeyboardSwitch;
    private final Preference.OnPreferenceChangeListener mShowVirtualKeyboardSwitchPreferenceChangeListener;
    private final List<KeyboardInfoPreference> mTempKeyboardInfoList;

    private static final class Callbacks implements LoaderManager.LoaderCallbacks<List<Keyboards>> {
        final Context mContext;
        final List<HardKeyboardDeviceInfo> mHardKeyboards;
        final PhysicalKeyboardFragment mPhysicalKeyboardFragment;

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader<List<Keyboards>> r1) {
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public /* bridge */ /* synthetic */ void onLoadFinished(Loader<List<Keyboards>> r1, List<Keyboards> r2) {
            onLoadFinished2(r1, r2);
        }

        public Callbacks(Context r1, PhysicalKeyboardFragment r2, List<HardKeyboardDeviceInfo> r3) {
            this.mContext = r1;
            this.mPhysicalKeyboardFragment = r2;
            this.mHardKeyboards = r3;
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public Loader<List<Keyboards>> onCreateLoader(int r1, Bundle r2) {
            return new KeyboardLayoutLoader(this.mContext, this.mHardKeyboards);
        }

        /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
        public void onLoadFinished2(Loader<List<Keyboards>> r1, List<Keyboards> r2) {
            this.mPhysicalKeyboardFragment.onLoadFinishedInternal(r1.getId(), r2);
        }
    }

    public static final class HardKeyboardDeviceInfo {
        public final InputDeviceIdentifier mDeviceIdentifier;
        public final String mDeviceName;

        public HardKeyboardDeviceInfo(String r1, InputDeviceIdentifier r2) {
            if (r1 != null) goto L6;
            r1 = "";
        L6:
            this.mDeviceName = r1;
            this.mDeviceIdentifier = r2;
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            if ((r5 instanceof HardKeyboardDeviceInfo) == true) goto L11;
            return false;
        L11:
            HardKeyboardDeviceInfo r6 = (HardKeyboardDeviceInfo) r5;
            if (TextUtils.equals(this.mDeviceName, r6.mDeviceName) == true) goto L15;
            return false;
        L15:
            if (this.mDeviceIdentifier.getVendorId() == r6.mDeviceIdentifier.getVendorId()) goto L18;
            return false;
        L18:
            if (this.mDeviceIdentifier.getProductId() == r6.mDeviceIdentifier.getProductId()) goto L21;
            return false;
        L21:
            if (TextUtils.equals(this.mDeviceIdentifier.getDescriptor(), r6.mDeviceIdentifier.getDescriptor()) == true) goto L23;
            return false;
        L23:
            return true;
        }
    }

    static final class KeyboardInfoPreference extends Preference {
        private final Collator collator;
        private final CharSequence mImSubtypeName;
        private final CharSequence mImeName;

        /* synthetic */ KeyboardInfoPreference(Context r1, Keyboards.KeyboardInfo r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        @Override // androidx.preference.Preference, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Preference r1) {
            return compareTo(r1);
        }

        private KeyboardInfoPreference(Context r4, Keyboards.KeyboardInfo r5) {
            super(r4);
            this.collator = Collator.getInstance();
            CharSequence r0 = r5.mImi.loadLabel(r4.getPackageManager());
            this.mImeName = r0;
            CharSequence r1 = getImSubtypeName(r4, r5.mImi, r5.mImSubtype);
            this.mImSubtypeName = r1;
            setTitle(formatDisplayName(r4, r0, r1));
            if (r5.mLayout == null) goto L6;
            setSummary(r5.mLayout.getLabel());
            return;
        }

        static CharSequence getDisplayName(Context r1, InputMethodInfo r2, InputMethodSubtype r3) {
            return formatDisplayName(r1, r2.loadLabel(r1.getPackageManager()), getImSubtypeName(r1, r2, r3));
        }

        private static CharSequence formatDisplayName(Context r2, CharSequence r3, CharSequence r4) {
            if (r4 != null) goto L5;
            return r3;
        L5:
            return String.format(r2.getString(R.string.physical_device_title), new Object[]{r3, r4});
        }

        private static CharSequence getImSubtypeName(Context r0, InputMethodInfo r1, InputMethodSubtype r2) {
            if (r2 != null) goto L4;
            return null;
        L4:
            return InputMethodAndSubtypeUtil.getSubtypeLocaleNameAsSentence(r2, r0, r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.preference.Preference
        public int compareTo(Preference r3) {
            if ((r3 instanceof KeyboardInfoPreference) == false) goto L5;
            KeyboardInfoPreference r4 = (KeyboardInfoPreference) r3;
            int r0 = compare(this.mImeName, r4.mImeName);
            if (r0 == 0) goto L9;
            return r0;
        L9:
            return compare(this.mImSubtypeName, r4.mImSubtypeName);
        L5:
            return super.compareTo2(r3);
        }

        private int compare(CharSequence r2, CharSequence r3) {
            if (TextUtils.isEmpty(r2) == true) goto L9;
            if (TextUtils.isEmpty(r3) == true) goto L9;
            return this.collator.compare(r2.toString(), r3.toString());
        L9:
            if (TextUtils.isEmpty(r2) == false) goto L15;
            if (TextUtils.isEmpty(r3) == false) goto L15;
            return 0;
        L15:
            if (TextUtils.isEmpty(r2) == true) goto L18;
            return -1;
        L18:
            return 1;
        }
    }

    private static final class KeyboardLayoutLoader extends AsyncTaskLoader<List<Keyboards>> {
        private final List<HardKeyboardDeviceInfo> mHardKeyboards;

        @Override // androidx.loader.content.AsyncTaskLoader
        public /* bridge */ /* synthetic */ List<Keyboards> loadInBackground() {
            return loadInBackground2();
        }

        public KeyboardLayoutLoader(Context r1, List<HardKeyboardDeviceInfo> r2) {
            super(r1);
            this.mHardKeyboards = (List) Preconditions.checkNotNull(r2);
        }

        private Keyboards loadInBackground(HardKeyboardDeviceInfo r11) {
            ArrayList r0 = new ArrayList();
            InputMethodManager r1 = (InputMethodManager) getContext().getSystemService(InputMethodManager.class);
            InputManager r10 = (InputManager) getContext().getSystemService(InputManager.class);
            if (r1 == null) goto L19;
            if (r10 == null) goto L19;
            Iterator<InputMethodInfo> r2 = r1.getEnabledInputMethodList().iterator();
        L7:
            if (r2.hasNext() == false) goto L19;
            InputMethodInfo r3 = r2.next();
            List<InputMethodSubtype> r4 = r1.getEnabledInputMethodSubtypeList(r3, true);
            if (r4.isEmpty() == true) goto L10;
            int r5 = r4.size();
            int r6 = 0;
        L12:
            if (r6 >= r5) goto L7;
            InputMethodSubtype r7 = r4.get(r6);
            if ("keyboard".equalsIgnoreCase(r7.getMode()) == false) goto L17;
            r0.add(new Keyboards.KeyboardInfo(r3, r7, MultiSDKAdapter.getKeyboardLayoutForInputDevice(r10, r11.mDeviceIdentifier, r3, r7)));
        L17:
            r6 = r6 + 1;
            goto L12
        L10:
            r0.add(new Keyboards.KeyboardInfo(r3, null, MultiSDKAdapter.getKeyboardLayoutForInputDevice(r10, r11.mDeviceIdentifier, r3, null)));
        L19:
            return new Keyboards(r11, r0);
        }

        @Override // androidx.loader.content.AsyncTaskLoader
        /* JADX INFO: renamed from: loadInBackground, reason: avoid collision after fix types in other method */
        public List<Keyboards> loadInBackground2() {
            ArrayList r0 = new ArrayList(this.mHardKeyboards.size());
            Iterator<HardKeyboardDeviceInfo> r1 = this.mHardKeyboards.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r0.add(loadInBackground(r1.next()));
            goto L4
        L6:
            return r0;
        }

        @Override // androidx.loader.content.Loader
        protected void onStartLoading() {
            super.onStartLoading();
            forceLoad();
        }

        @Override // androidx.loader.content.Loader
        protected void onStopLoading() {
            super.onStopLoading();
            cancelLoad();
        }
    }

    public static final class Keyboards implements Comparable<Keyboards> {
        public final Collator mCollator;
        public final HardKeyboardDeviceInfo mDeviceInfo;
        public final ArrayList<KeyboardInfo> mKeyboardInfoList;

        public static final class KeyboardInfo {
            public final InputMethodSubtype mImSubtype;
            public final InputMethodInfo mImi;
            public final KeyboardLayout mLayout;

            public KeyboardInfo(InputMethodInfo r1, InputMethodSubtype r2, KeyboardLayout r3) {
                this.mImi = r1;
                this.mImSubtype = r2;
                this.mLayout = r3;
            }
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Keyboards r1) {
            return compareTo2(r1);
        }

        public Keyboards(HardKeyboardDeviceInfo r2, ArrayList<KeyboardInfo> r3) {
            this.mCollator = Collator.getInstance();
            this.mDeviceInfo = r2;
            this.mKeyboardInfoList = r3;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(Keyboards r2) {
            return this.mCollator.compare(this.mDeviceInfo.mDeviceName, r2.mDeviceInfo.mDeviceName);
        }
    }

    public void com_android_settings_inputmethod_PhysicalKeyboardFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_inputmethod_PhysicalKeyboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_inputmethod_PhysicalKeyboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public PhysicalKeyboardFragment() {
        this.mLastHardKeyboards = new ArrayList();
        this.mTempKeyboardInfoList = new ArrayList();
        this.mLoaderIDs = new HashSet();
        this.mNextLoaderId = 0;
        this.mShowVirtualKeyboardSwitchPreferenceChangeListener = new AnonymousClass2(this);
        final Handler r1 = new Handler(true);
        this.mContentObserver = new AnonymousClass3(this, r1);
    }

    static /* synthetic */ void access$000(PhysicalKeyboardFragment r0) {
        r0.toggleKeyboardShortcutsMenu();
    }

    static /* synthetic */ InputMethodUtils.InputMethodSettings access$200(PhysicalKeyboardFragment r0) {
        return r0.mSettings;
    }

    static /* synthetic */ void access$300(PhysicalKeyboardFragment r0) {
        r0.updateShowVirtualKeyboardSwitch();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle r8, String r9) {
        Activity r10 = (Activity) Preconditions.checkNotNull(getActivity());
        addPreferencesFromResource(R.xml.physical_keyboard_settings);
        this.mIm = (InputManager) Preconditions.checkNotNull((InputManager) r10.getSystemService(InputManager.class));
        this.mSettings = new InputMethodUtils.InputMethodSettings(r10.getResources(), getContentResolver(), new HashMap(), new ArrayList(), UserHandle.myUserId(), false);
        PreferenceCategory r11 = (PreferenceCategory) Preconditions.checkNotNull((PreferenceCategory) findPreference(KEYBOARD_ASSISTANCE_CATEGORY));
        this.mKeyboardAssistanceCategory = r11;
        this.mShowVirtualKeyboardSwitch = (SwitchPreference) Preconditions.checkNotNull((SwitchPreference) r11.findPreference(SHOW_VIRTUAL_KEYBOARD_SWITCH));
        findPreference(KEYBOARD_SHORTCUTS_HELPER).setOnPreferenceClickListener(new AnonymousClass1(this));
    }

    public void com_android_settings_inputmethod_PhysicalKeyboardFragment__onResume$___twin___() {
        super.onResume();
        clearLoader();
        this.mLastHardKeyboards.clear();
        updateHardKeyboards();
        this.mIm.registerInputDeviceListener(this, null);
        this.mShowVirtualKeyboardSwitch.setOnPreferenceChangeListener(this.mShowVirtualKeyboardSwitchPreferenceChangeListener);
        registerShowVirtualKeyboardSettingsObserver();
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        clearLoader();
        this.mLastHardKeyboards.clear();
        this.mIm.unregisterInputDeviceListener(this);
        this.mShowVirtualKeyboardSwitch.setOnPreferenceChangeListener(null);
        unregisterShowVirtualKeyboardSettingsObserver();
    }

    public void onLoadFinishedInternal(int r10, List<Keyboards> r11) {
        if (this.mLoaderIDs.remove(Integer.valueOf(r10)) == true) goto L5;
        return;
    L5:
        Collections.sort(r11);
        PreferenceScreen r12 = getPreferenceScreen();
        r12.removeAll();
        Iterator<Keyboards> r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L18;
        final Keyboards r0 = r13.next();
        AnonymousClass1 r3 = null;
        PreferenceCategory r1 = new PreferenceCategory(getPrefContext(), null);
        r1.setTitle(r0.mDeviceInfo.mDeviceName);
        r1.setOrder(0);
        r12.addPreference(r1);
        Iterator<Keyboards.KeyboardInfo> r2 = r0.mKeyboardInfoList.iterator();
    L10:
        if (r2.hasNext() == false) goto L7;
        Keyboards.KeyboardInfo r4 = r2.next();
        this.mTempKeyboardInfoList.clear();
        final InputMethodInfo r5 = r4.mImi;
        final InputMethodSubtype r6 = r4.mImSubtype;
        if (r5 == null) goto L14;
        KeyboardInfoPreference r7 = new KeyboardInfoPreference(getPrefContext(), r4, r3);
        r7.setOnPreferenceClickListener(new PhysicalKeyboardFragment$$ExternalSyntheticLambda0(this, r0, r5, r6));
        this.mTempKeyboardInfoList.add(r7);
        Collections.sort(this.mTempKeyboardInfoList);
    L14:
        Iterator<KeyboardInfoPreference> r8 = this.mTempKeyboardInfoList.iterator();
    L16:
        if (r8.hasNext() == false) goto L10;
        r1.addPreference(r8.next());
        goto L16
    L18:
        this.mTempKeyboardInfoList.clear();
        this.mKeyboardAssistanceCategory.setOrder(1);
        r12.addPreference(this.mKeyboardAssistanceCategory);
        updateShowVirtualKeyboardSwitch();
    }

    /* JADX INFO: renamed from: lambda$onLoadFinishedInternal$0$com-android-settings-inputmethod-PhysicalKeyboardFragment, reason: not valid java name */
    /* synthetic */ boolean m494x14227cc9(Keyboards r1, InputMethodInfo r2, InputMethodSubtype r3, Preference r4) {
        showKeyboardLayoutScreen(r1.mDeviceInfo.mDeviceIdentifier, r2, r3);
        return true;
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceAdded(int r1) {
        updateHardKeyboards();
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceRemoved(int r1) {
        updateHardKeyboards();
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceChanged(int r1) {
        updateHardKeyboards();
    }

    private static ArrayList<HardKeyboardDeviceInfo> getHardKeyboards() {
        ArrayList<HardKeyboardDeviceInfo> r0 = new ArrayList();
        int[] r1 = InputDevice.getDeviceIds();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L12;
        InputDevice r4 = InputDevice.getDevice(r1[r3]);
        if (r4 == null) goto L11;
        if (r4.isVirtual() == true) goto L11;
        if (r4.isFullKeyboard() == false) goto L11;
        r0.add(new HardKeyboardDeviceInfo(r4.getName(), r4.getIdentifier()));
    L11:
        r3 = r3 + 1;
        goto L3
    L12:
        return r0;
    }

    private void updateHardKeyboards() {
        ArrayList<HardKeyboardDeviceInfo> r0 = getHardKeyboards();
        if (Objects.equals(r0, this.mLastHardKeyboards) == true) goto L6;
        clearLoader();
        this.mLastHardKeyboards.clear();
        this.mLastHardKeyboards.addAll(r0);
        LoaderManager.getInstance(this).initLoader(this.mNextLoaderId, null, new Callbacks(getContext(), this, this.mLastHardKeyboards));
        this.mLoaderIDs.add(Integer.valueOf(this.mNextLoaderId));
        this.mNextLoaderId++;
        return;
    }

    private void showKeyboardLayoutScreen(InputDeviceIdentifier r3, InputMethodInfo r4, InputMethodSubtype r5) {
        Intent r0 = new Intent("android.intent.action.MAIN");
        r0.putExtra("input_device_identifier", r3);
        r0.putExtra(KeyboardLayoutPickerFragment2.EXTRA_INPUT_METHOD_INFO, r4);
        r0.putExtra(KeyboardLayoutPickerFragment2.EXTRA_INPUT_METHOD_SUBTYPE, r5);
        startActivity(r0);
    }

    private void clearLoader() {
        Iterator<Integer> r0 = this.mLoaderIDs.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        int r1 = r0.next().intValue();
        LoaderManager.getInstance(this).destroyLoader(r1);
        goto L4
    L6:
        this.mLoaderIDs.clear();
    }

    private void registerShowVirtualKeyboardSettingsObserver() {
        unregisterShowVirtualKeyboardSettingsObserver();
        getActivity().getContentResolver().registerContentObserver(Settings.Secure.getUriFor("show_ime_with_hard_keyboard"), false, this.mContentObserver, UserHandle.myUserId());
        updateShowVirtualKeyboardSwitch();
    }

    private void unregisterShowVirtualKeyboardSettingsObserver() {
        getActivity().getContentResolver().unregisterContentObserver(this.mContentObserver);
    }

    private void updateShowVirtualKeyboardSwitch() {
        this.mShowVirtualKeyboardSwitch.setChecked(this.mSettings.isShowImeWithHardKeyboardEnabled());
    }

    private void toggleKeyboardShortcutsMenu() {
        getActivity().requestShowKeyboardShortcuts();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_inputmethod_PhysicalKeyboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PhysicalKeyboardFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_PhysicalKeyboardFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_PhysicalKeyboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PhysicalKeyboardFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_inputmethod_PhysicalKeyboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_PhysicalKeyboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PhysicalKeyboardFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_PhysicalKeyboardFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
