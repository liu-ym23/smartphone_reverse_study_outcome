package com.android.settings.tts;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TtsEngines;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.android.settings.PreferenceMgr;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class TTSEngineLocaleSettingFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private static final boolean DBG = false;
    private static final String TAG = "TTSEngineLocaleSettingFragment";
    public static final String TTS_LOCALE_SUFFIX = "_locale_index";
    private List<CharSequence> datas;
    private TtsEngines mEnginesHelper;
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;
    private LocaleListAdapter mLocaleAdapter;
    private ListView mLocaleListView;
    private int mSelectIndex;
    private TextToSpeech mTts;
    private final TextToSpeech.OnInitListener mTtsInitListener;
    private String mTtsName;

    private class LocaleListAdapter extends BaseAdapter {
        private List<CharSequence> datas;
        final /* synthetic */ TTSEngineLocaleSettingFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        LocaleListAdapter(TTSEngineLocaleSettingFragment r1, List<CharSequence> r2) {
            this.this$0 = r1;
            this.datas = r2;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.datas.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return this.datas.get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            if (r5 != null) goto L4;
            ListContentItemCheck r7 = new ListContentItemCheck(this.this$0.mContext);
            View r8 = r7;
        L5:
            boolean r1 = true;
            if (getCount() <= 1) goto L13;
            if (r4 != 0) goto L10;
            int r0 = 2;
        L14:
            r7.setBackgroundStyle(r0);
            r7.setTitle(this.datas.get(r4));
            if (TTSEngineLocaleSettingFragment.access$100(this.this$0) == r4) goto L18;
            r1 = false;
        L18:
            r7.setChecked(r1);
            return r8;
        L10:
            if (r4 != (getCount() - 1)) goto L12;
            r0 = 4;
            goto L14
        L12:
            r0 = 3;
            goto L14
        L13:
            r0 = 1;
            goto L14
        L4:
            r8 = r5;
            r7 = (ListContentItemCheck) r5;
            goto L5
        }
    }

    public void com_android_settings_tts_TTSEngineLocaleSettingFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_tts_TTSEngineLocaleSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_tts_TTSEngineLocaleSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public TTSEngineLocaleSettingFragment() {
        this.mTtsInitListener = new AnonymousClass1(this);
    }

    static /* synthetic */ ListView access$000(TTSEngineLocaleSettingFragment r0) {
        return r0.mLocaleListView;
    }

    static /* synthetic */ int access$100(TTSEngineLocaleSettingFragment r0) {
        return r0.mSelectIndex;
    }

    private void processArgs() {
        Bundle r0 = getArguments();
        this.mEntries = r0.getCharSequenceArray("tts_entries");
        this.mEntryValues = r0.getCharSequenceArray("tts_entry_values");
        this.mSelectIndex = r0.getInt("select_index");
        this.mTtsName = r0.getString("name");
        ArrayList r1 = new ArrayList();
        this.datas = r1;
        Collections.addAll(r1, this.mEntries);
    }

    public void com_android_settings_tts_TTSEngineLocaleSettingFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        processArgs();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.tts_engine_local_settings_layout, r3, false);
        this.mLocaleListView = (ListView) findViewByIdNullable(R.id.options_list);
        addHeaderFooter();
        LocaleListAdapter r5 = new LocaleListAdapter(this, this.datas);
        this.mLocaleAdapter = r5;
        this.mLocaleListView.setAdapter(r5);
        this.mLocaleListView.setOnItemClickListener(this);
        this.mTts = new TextToSpeech(this.mContext, this.mTtsInitListener, this.mTtsName);
        this.mEnginesHelper = new TtsEngines(getActivity());
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        OLog.d(TAG, "index ?" + this.mSelectIndex + ", position:" + r3);
        int r5 = r3 - this.mLocaleListView.getHeaderViewsCount();
        if (r5 >= 0) goto L5;
        return;
    L5:
        if (r5 >= this.mEntries.length) goto L14;
        this.mSelectIndex = r5;
        OLog.d(TAG, "index after ?" + this.mSelectIndex);
        PreferenceMgr.getInstance(this.mContext).putInt(this.mTtsName + TTS_LOCALE_SUFFIX, this.mSelectIndex);
        String r6 = this.mEntryValues[r5].toString();
        if (TextUtils.isEmpty(r6) == false) goto L10;
        Locale r7 = null;
    L11:
        updateLanguageTo(r7);
        this.mLocaleAdapter.notifyDataSetChanged();
        return;
    L10:
        r7 = this.mEnginesHelper.parseLocaleString(r6);
        goto L11
    }

    private void updateLanguageTo(Locale r6) {
        if (r6 != null) goto L4;
        String r0 = "";
    L5:
        int r1 = 0;
    L6:
        CharSequence[] r2 = this.mEntryValues;
        if (r1 >= r2.length) goto L12;
        if (r0.equalsIgnoreCase(r2[r1].toString()) == true) goto L13;
        r1 = r1 + 1;
    L13:
        if (r1 != (-1)) goto L16;
        OLog.w(TAG, "updateLanguageTo called with unknown locale argument");
        return;
    L16:
        this.mEnginesHelper.updateLocalePrefForEngine(this.mTtsName, r6);
        if (this.mTtsName.equals(this.mTts.getCurrentEngine()) == false) goto L25;
        TextToSpeech r5 = this.mTts;
        if (r6 != null) goto L21;
        r6 = Locale.getDefault();
    L21:
        r5.setLanguage(r6);
        return;
    L25:
        return;
    L12:
        r1 = -1;
        goto L13
    L4:
        r0 = r6.toString();
        goto L5
    }

    private void addHeaderFooter() {
        View r0 = Utils.inflateListTransparentHeader(this.mContext);
        View r1 = Utils.inflateListTransparentHeader(this.mContext);
        this.mLocaleListView.addHeaderView(r0);
        this.mLocaleListView.addFooterView(r1);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_tts_TTSEngineLocaleSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TTSEngineLocaleSettingFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_tts_TTSEngineLocaleSettingFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_tts_TTSEngineLocaleSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TTSEngineLocaleSettingFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_tts_TTSEngineLocaleSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_tts_TTSEngineLocaleSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TTSEngineLocaleSettingFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_tts_TTSEngineLocaleSettingFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
