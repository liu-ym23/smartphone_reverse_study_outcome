package com.android.settings;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioRouting;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.core.content.ContextCompat;
import bytedanceos.api.ActivityManagerSmt;
import com.android.settings.accessibility.HourlyChimeFragment;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.base.BaseFragment;
import com.android.settings.pinyin.PinyinUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.android.settings.widget.SettingItemButton;
import com.android.settings.wifi.SoundWorkSettingsFragment;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.olog.OLog;
import com.obric.oui.button.OIconButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.toast.OToast;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class RingtoneSettingsFragment extends BaseFragment implements Runnable, View.OnClickListener {
    public static final String CALENDAR_VIBRATION_EFFECT_URI = "calendar_vibration_effect_uri";
    public static final String CALENDAR_VIBRATION_ENABLED = "calendar_vibration_enabled";
    private static final String[] EXTERNAL_RINGTONE_COLUMN = null;
    public static final String EXTRA_INTERNAL_RINGTONE_POSITION = "internal_ringtone_position";
    public static final String EXTRA_IS_EXTERNAL_RINGTONE = "is_external_ringtone";
    public static final String EXTRA_USER_ID = "user_id";
    private static final String[] INTERNAL_RINGTONE_COLUMN = null;
    public static final String NOTIFICATION_VIBRATION_EFFECT_URI = "notification_vibration_effect_uri";
    public static final String NOTIFICATION_VIBRATION_ENABLED = "notification_vibration_enabled";
    private static final int REQUEST_CODE_CHOOSE_OUTER_MEDIA = 1;
    public static final String RINGTONE_SWITCH_ON_SUFFIX = "_ringtone_switch_on";
    public static final String RINGTONE_VIBRATION_EFFECT = "ringtone_vibration_effect";
    public static final String RINGTONE_VIBRATION_EFFECT_2 = "ringtone_vibration_effect_2";
    private static final String SAVE_CLICKED_POS = "clicked_pos";
    public static final String SMS_1_VIBRATION_EFFECT_URI = "sms_1_vibration_effect_uri";
    public static final String SMS_1_VIBRATION_ENABLED = "sms_1_vibration_enabled";
    public static final String SMS_2_VIBRATION_EFFECT_URI = "sms_2_vibration_effect_uri";
    public static final String SMS_2_VIBRATION_ENABLED = "sms_2_vibration_enabled";
    private static final String TAG = "RingtoneSettingsFragment";
    public static final int TYPE_RINGTONE_2 = 2097152;
    public static final String VIBRATION_EFFECT_NONE = "none";
    public static final String VIBRATION_EFFECT_SYNC = "sync_with_ringtone";
    private static Uri mDefaultUri;
    public static String[] mPresetLongVibrationNames;
    public static final String[] mPresetLongVibrationUris = null;
    public static String[] mPresetShortVibrationNames;
    public static final String[] mPresetShortVibrationUris = null;
    public static final String[] mSyncLongVibrationUris = null;
    public static final String[] mSyncShortVibrationUris = null;
    private RingtoneAdapter mAdapter;
    private AudioManager.OnAudioFocusChangeListener mAudioFocusListener;
    private AudioManager mAudioManager;
    private AudioRouting.OnRoutingChangedListener mAudioRoutingChangedListener;
    private int mClickedPos;
    private MediaPlayer.OnCompletionListener mCompletionListener;
    private Uri mCurrentUri;
    private OCardListItem mCustomRingtoneMusic;
    private SettingItemButton mCustomRingtoneRecord;
    private int mDefaultPos;
    private int mDefaultRingtonePos;
    private ArrayList<Ringtone> mExternalRingtones;
    private View mFooterView;
    private Handler mHandler;
    private boolean mHasDefaultItem;
    private boolean mHasFooterView;
    public boolean mHasMultiSimInDevice;
    private boolean mHasSilentItem;
    private boolean mIncludeDrm;
    private ArrayList<Ringtone> mInternalRingtones;
    private boolean mIsCard2;
    private boolean mIsMediaPlaying;
    private boolean mIsRingtoneType;
    private int mListSelection;
    private int mListTop;
    private ListView mListView;
    private Context mManagedProfileContext;
    private int mManagedProfileId;
    private BroadcastReceiver mManagedProfileReceiver;
    private OToast mMuteToast;
    private ArrayList<OCardListItem> mOCardListItems;
    private View.OnClickListener mOnClickDeleteBtnListener;
    private LocalRingtonePlayer mPlayer;
    private int mPreSelectPos;
    private ContentResolver mResolver;
    private RingtoneManager mRingtoneManager;
    private OCardListItem mRingtoneSwitchCardListItem;
    private int mRingtoneType;
    private OCardListItem mSameToSMS1CardListItem;
    private Uri mSelectedUri;
    private String mSoundSettingType;
    private int mStaticItemCount;
    private boolean mSupportMultiSim;
    private OFloatingTitleBar mTitleBar;
    private String mTitleText;
    private Uri mUriForDefaultItem;
    private OCardListItem mVibrationCardListItem;
    private OPopover mVibrationPopMenu;
    private Vibrator mVibratorManager;
    private View.OnClickListener onItemClickListener;

    class Ringtone {
        private String artist;
        private String data;
        private String displayName;
        private String fileName;
        private int id;
        private boolean isSelected;
        final /* synthetic */ RingtoneSettingsFragment this$0;
        private String title;
        private Uri uri;

        Ringtone(RingtoneSettingsFragment r1) {
            this.this$0 = r1;
        }

        static /* synthetic */ Uri access$3900(Ringtone r0) {
            return r0.uri;
        }

        static /* synthetic */ String access$4300(Ringtone r0) {
            return r0.artist;
        }

        static /* synthetic */ String access$4800(Ringtone r0) {
            return r0.fileName;
        }

        public boolean isSelected() {
            return this.isSelected;
        }

        public void setSelected(boolean r1) {
            this.isSelected = r1;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int r1) {
            this.id = r1;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String r1) {
            this.title = r1;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public void setDisplayName(String r1) {
            this.displayName = r1;
        }

        public String getData() {
            return this.data;
        }

        public void setData(String r1) {
            this.data = r1;
        }

        public Uri getUri() {
            return this.uri;
        }

        public void setUri(Uri r1) {
            this.uri = r1;
        }

        public String getArtist() {
            return this.artist;
        }

        public void setArtist(String r1) {
            this.artist = r1;
        }

        public String getFileName() {
            return this.fileName;
        }

        public void setFileName(String r1) {
            this.fileName = r1;
        }
    }

    class RingtoneAdapter extends BaseAdapter {
        private Context mContext;
        final /* synthetic */ RingtoneSettingsFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return 0;
        }

        public RingtoneAdapter(RingtoneSettingsFragment r1, Context r2) {
            this.this$0 = r1;
            this.mContext = r2;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (RingtoneSettingsFragment.access$2300(this.this$0) == false) goto L5;
        L7:
            return 0;
        L5:
            if (RingtoneSettingsFragment.access$1600(this.this$0) == false) goto L7;
            return RingtoneSettingsFragment.access$4000(this.this$0).size() + RingtoneSettingsFragment.access$1700(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // android.widget.Adapter
        public View getView(final int r7, View r8, ViewGroup r9) {
            View r10 = View.inflate(this.this$0._mActivity, R.layout.ringtone_settings_item_layout_new, null);
            OSectionTitleBar r11 = (OSectionTitleBar) r10.findViewById(R.id.title);
            boolean r1 = false;
            if (RingtoneSettingsFragment.access$1700(this.this$0).isEmpty() == true) goto L7;
            if (r7 != 0) goto L7;
            r11.setVisibility(0);
            r11.setTitleText(this.this$0.getString(R.string.ringtone_by_user));
        L10:
            final OCardListItem r12 = (OCardListItem) r10.findViewById(R.id.ringtone_item);
            r12.showTitle(false);
            OCardListItemUtils.setCustomEndImageView(r12);
            if (RingtoneSettingsFragment.access$600(this.this$0) != r7) goto L13;
            boolean r0 = true;
        L14:
            r12.showCustomEnd(r0);
            if (r7 >= RingtoneSettingsFragment.access$1700(this.this$0).size()) goto L27;
            if (r7 != 0) goto L23;
            if (RingtoneSettingsFragment.access$1700(this.this$0).size() != 1) goto L20;
            int r2 = 0;
        L21:
            r12.setCardPosition(r2);
        L38:
            if (r7 >= RingtoneSettingsFragment.access$1700(this.this$0).size()) goto L50;
            Ringtone r3 = (Ringtone) RingtoneSettingsFragment.access$1700(this.this$0).get(r7);
            r12.setSwipeView(R.layout.layout_card_list_item_delete_swip);
            r12.setEnableSwipe(true);
            r12.setDefaultTailIcon(0);
            r12.showTailIcon(false);
            if (r12.getSwipeView() == null) goto L42;
            OIconButton r4 = (OIconButton) r12.getSwipeView().findViewById(R.id.btn_delete);
            r4.setTag(r3);
            r4.setOnClickListener(RingtoneSettingsFragment.access$4200(this.this$0));
        L42:
            OSwipeLayout r5 = r12.getSwipeLayout();
            if (r5 != null) goto L45;
        L60:
            r12.setTag(Integer.valueOf(r7));
            r12.getContentContainer().setTag(Integer.valueOf(r7));
            r12.setOnContentClickListener(RingtoneSettingsFragment.access$4400(this.this$0));
            Uri r6 = r3.getUri();
            if (r6 != null) goto L63;
        L67:
            String r13 = r3.getTitle();
        L68:
            OCardListItemUtils.setDefaultCustomTitleView(r12, R.layout.card_list_item_custom_title_container_layout, r13, -1);
            RingtoneSettingsFragment r14 = this.this$0;
            if (RingtoneSettingsFragment.access$600(r14) == r7) goto L71;
        L73:
            RingtoneSettingsFragment.access$4600(r14, r1, r12);
            RingtoneSettingsFragment.access$4700(this.this$0).add(r12);
            return r10;
        L71:
            if (RingtoneSettingsFragment.access$4500(this.this$0) == false) goto L73;
            r1 = true;
            goto L73
        L63:
            if (r6.equals(RingtoneSettingsFragment.access$2600()) == false) goto L67;
            if (this.this$0.isAdded() == false) goto L67;
            r13 = r3.getTitle() + this.this$0.getString(R.string.sound_settings_default_text);
            goto L68
        L45:
            if (r5.getTag() != null) goto L47;
        L49:
            OSwipeLayout.SwipeListener r15 = new AnonymousClass1(this, r12, r7);
            r5.addSwipeListener(r15);
            r5.setTag(r15);
            goto L60
        L47:
            if ((r5.getTag() instanceof OSwipeLayout.SwipeListener) == false) goto L49;
            r5.removeSwipeListener((OSwipeLayout.SwipeListener) r5.getTag());
            goto L49
        L50:
            r3 = (Ringtone) RingtoneSettingsFragment.access$4000(this.this$0).get(r7 - RingtoneSettingsFragment.access$1700(this.this$0).size());
            if (RingtoneSettingsFragment.access$3600(this.this$0) == 1) goto L53;
        L59:
            r12.showSubTitle(false);
            goto L60
        L53:
            if (Ringtone.access$4300(r3) == null) goto L59;
            if (Ringtone.access$4300(r3).equals(PinyinUtils.UNKNOWN_STRING) == true) goto L59;
            if (this.this$0.isAdded() == false) goto L59;
            r12.setSubTitle(this.this$0.getString(R.string.ringtone_artist, new Object[]{Ringtone.access$4300(r3)}));
            r12.showSubTitle(true);
            goto L60
        L20:
            r2 = 1;
            goto L21
        L23:
            if (r7 != (RingtoneSettingsFragment.access$1700(this.this$0).size() - 1)) goto L25;
            r12.setCardPosition(3);
            goto L38
        L25:
            r12.setCardPosition(2);
            goto L38
        L27:
            if (r7 != RingtoneSettingsFragment.access$1700(this.this$0).size()) goto L34;
            if (getCount() != 1) goto L31;
            int r16 = 0;
        L32:
            r12.setCardPosition(r16);
            goto L38
        L31:
            r16 = 1;
            goto L32
        L34:
            if (r7 != (getCount() - 1)) goto L36;
            r12.setCardPosition(3);
            goto L38
        L36:
            r12.setCardPosition(2);
            goto L38
        L13:
            r0 = false;
        L7:
            if (r7 != RingtoneSettingsFragment.access$1700(this.this$0).size()) goto L9;
            r11.setVisibility(0);
            r11.setTitleText(RingtoneSettingsFragment.access$4100(this.this$0) + this.this$0.getString(R.string.volume_ring_only_description));
            goto L10
        L9:
            r11.setVisibility(8);
            goto L10
        }
    }

    public void com_android_settings_RingtoneSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_RingtoneSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_RingtoneSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_RingtoneSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public RingtoneSettingsFragment() {
        this.mInternalRingtones = new ArrayList();
        this.mExternalRingtones = new ArrayList();
        this.mOCardListItems = new ArrayList();
        this.mDefaultPos = -1;
        this.mDefaultRingtonePos = -1;
        this.mClickedPos = -1;
        this.mPreSelectPos = -1;
        this.mHasMultiSimInDevice = false;
        this.mVibrationPopMenu = null;
        this.mVibratorManager = null;
        this.mManagedProfileId = -10000;
        this.mManagedProfileContext = null;
        this.mCompletionListener = new AnonymousClass1(this);
        this.mAudioRoutingChangedListener = new AnonymousClass2(this);
        this.mManagedProfileReceiver = new AnonymousClass3(this);
        this.onItemClickListener = new AnonymousClass4(this);
        this.mAudioFocusListener = new AnonymousClass5(this);
        this.mOnClickDeleteBtnListener = new AnonymousClass10(this);
    }

    static /* synthetic */ AudioManager.OnAudioFocusChangeListener access$000(RingtoneSettingsFragment r0) {
        return r0.mAudioFocusListener;
    }

    static /* synthetic */ AudioManager access$100(RingtoneSettingsFragment r0) {
        return r0.mAudioManager;
    }

    static /* synthetic */ Uri access$1000(RingtoneSettingsFragment r0, int r1) {
        return r0.getUri(r1);
    }

    static /* synthetic */ int access$1100(RingtoneSettingsFragment r0) {
        return r0.mPreSelectPos;
    }

    static /* synthetic */ int access$1102(RingtoneSettingsFragment r0, int r1) {
        r0.mPreSelectPos = r1;
        return r1;
    }

    static /* synthetic */ void access$1200(RingtoneSettingsFragment r0) {
        r0.stopAnyPlayingRingtone();
    }

    static /* synthetic */ Handler access$1300(RingtoneSettingsFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ String access$1400(RingtoneSettingsFragment r0) {
        return r0.mSoundSettingType;
    }

    static /* synthetic */ boolean access$1500(RingtoneSettingsFragment r0) {
        return r0.isRingtoneUseExternalRINGTONE();
    }

    static /* synthetic */ boolean access$1600(RingtoneSettingsFragment r0) {
        return r0.isRingtoneSwitchOn();
    }

    static /* synthetic */ ArrayList access$1700(RingtoneSettingsFragment r0) {
        return r0.mExternalRingtones;
    }

    static /* synthetic */ int access$1800(RingtoneSettingsFragment r0) {
        return r0.getInternalRingtonePosition();
    }

    static /* synthetic */ void access$1900(RingtoneSettingsFragment r0, boolean r1, int r2) {
        r0.showVibrationPopMenu(r1, r2);
    }

    static /* synthetic */ void access$200(RingtoneSettingsFragment r0, boolean r1) {
        r0.updatePlayingAnim(r1);
    }

    static /* synthetic */ OCardListItem access$2000(RingtoneSettingsFragment r0) {
        return r0.mRingtoneSwitchCardListItem;
    }

    static /* synthetic */ OCardListItem access$2100(RingtoneSettingsFragment r0) {
        return r0.mSameToSMS1CardListItem;
    }

    static /* synthetic */ View access$2200(RingtoneSettingsFragment r0) {
        return r0.mFooterView;
    }

    static /* synthetic */ boolean access$2300(RingtoneSettingsFragment r0) {
        return r0.isSameToSMS1SwitchOn();
    }

    static /* synthetic */ Uri access$2400(RingtoneSettingsFragment r0) {
        return r0.mCurrentUri;
    }

    static /* synthetic */ Uri access$2402(RingtoneSettingsFragment r0, Uri r1) {
        r0.mCurrentUri = r1;
        return r1;
    }

    static /* synthetic */ Uri access$2500(RingtoneSettingsFragment r0) {
        return r0.getSMS1RingtoneUri();
    }

    static /* synthetic */ Uri access$2600() {
        return mDefaultUri;
    }

    static /* synthetic */ int access$2700(RingtoneSettingsFragment r0, Uri r1) {
        return r0.getListPosition(r1);
    }

    static /* synthetic */ void access$2800(RingtoneSettingsFragment r0) {
        r0.notifyDataSetChanged();
    }

    static /* synthetic */ Uri access$2900(RingtoneSettingsFragment r0) {
        return r0.getCurrentRingtoneUri();
    }

    static /* synthetic */ void access$300(RingtoneSettingsFragment r0) {
        r0.checkAndShowMuteToast();
    }

    static /* synthetic */ Vibrator access$3000(RingtoneSettingsFragment r0) {
        return r0.mVibratorManager;
    }

    static /* synthetic */ void access$3100(RingtoneSettingsFragment r0, String r1) {
        r0.vibrate(r1);
    }

    static /* synthetic */ OCardListItem access$3200(RingtoneSettingsFragment r0) {
        return r0.mVibrationCardListItem;
    }

    static /* synthetic */ String access$3300(RingtoneSettingsFragment r0) {
        return r0.getVibrationEffectString();
    }

    static /* synthetic */ OPopover access$3400(RingtoneSettingsFragment r0) {
        return r0.mVibrationPopMenu;
    }

    static /* synthetic */ OPopover access$3402(RingtoneSettingsFragment r0, OPopover r1) {
        r0.mVibrationPopMenu = r1;
        return r1;
    }

    static /* synthetic */ int access$3500(RingtoneSettingsFragment r0) {
        return r0.mDefaultPos;
    }

    static /* synthetic */ int access$3600(RingtoneSettingsFragment r0) {
        return r0.mRingtoneType;
    }

    static /* synthetic */ RingtoneManager access$3700(RingtoneSettingsFragment r0) {
        return r0.mRingtoneManager;
    }

    static /* synthetic */ void access$3800(RingtoneSettingsFragment r0) {
        r0.updateExternalRingtonesAsync();
    }

    static /* synthetic */ LocalRingtonePlayer access$400(RingtoneSettingsFragment r0) {
        return r0.mPlayer;
    }

    static /* synthetic */ ArrayList access$4000(RingtoneSettingsFragment r0) {
        return r0.mInternalRingtones;
    }

    static /* synthetic */ String access$4100(RingtoneSettingsFragment r0) {
        return r0.mTitleText;
    }

    static /* synthetic */ View.OnClickListener access$4200(RingtoneSettingsFragment r0) {
        return r0.mOnClickDeleteBtnListener;
    }

    static /* synthetic */ View.OnClickListener access$4400(RingtoneSettingsFragment r0) {
        return r0.onItemClickListener;
    }

    static /* synthetic */ boolean access$4500(RingtoneSettingsFragment r0) {
        return r0.mIsMediaPlaying;
    }

    static /* synthetic */ void access$4600(RingtoneSettingsFragment r0, boolean r1, OCardListItem r2) {
        r0.playRingtoneAnimation(r1, r2);
    }

    static /* synthetic */ ArrayList access$4700(RingtoneSettingsFragment r0) {
        return r0.mOCardListItems;
    }

    static /* synthetic */ Ringtone access$4900(RingtoneSettingsFragment r0, Uri r1) {
        return r0.updateExternalRingtonesWithUri(r1);
    }

    static /* synthetic */ Context access$500(RingtoneSettingsFragment r0) {
        return r0.mManagedProfileContext;
    }

    static /* synthetic */ String[] access$5000() {
        return EXTERNAL_RINGTONE_COLUMN;
    }

    static /* synthetic */ String access$5100(RingtoneSettingsFragment r0) {
        return r0.getSelectionFromType();
    }

    static /* synthetic */ RingtoneAdapter access$5200(RingtoneSettingsFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ int access$600(RingtoneSettingsFragment r0) {
        return r0.mClickedPos;
    }

    static /* synthetic */ int access$602(RingtoneSettingsFragment r0, int r1) {
        r0.mClickedPos = r1;
        return r1;
    }

    static /* synthetic */ int access$610(RingtoneSettingsFragment r2) {
        int r0 = r2.mClickedPos;
        r2.mClickedPos = r0 - 1;
        return r0;
    }

    static /* synthetic */ void access$700(RingtoneSettingsFragment r0) {
        r0.updateCardListItemCheckedMode();
    }

    static /* synthetic */ boolean access$800(RingtoneSettingsFragment r0) {
        return r0.mIsCard2;
    }

    static /* synthetic */ void access$900(RingtoneSettingsFragment r0, boolean r1) {
        r0.updateSameToSMS1SwitchMode(r1);
    }

    static {
        mSyncLongVibrationUris = new String[]{"content://vibration/effect/1", "content://vibration/effect/2", "content://vibration/effect/3", "content://vibration/effect/4", "content://vibration/effect/5", "content://vibration/effect/6", "content://vibration/effect/7", "content://vibration/effect/8", "content://vibration/effect/9", "content://vibration/effect/10", "content://vibration/effect/11"};
        mPresetLongVibrationUris = new String[]{"content://vibration/effect/21", "content://vibration/effect/22", "content://vibration/effect/23", "content://vibration/effect/24", "content://vibration/effect/25"};
        mSyncShortVibrationUris = new String[]{"content://vibration/effect/31", "content://vibration/effect/32", "content://vibration/effect/33", "content://vibration/effect/34", "content://vibration/effect/35", "content://vibration/effect/36", "content://vibration/effect/37", "content://vibration/effect/38"};
        mPresetShortVibrationUris = new String[]{"content://vibration/effect/41", "content://vibration/effect/42", "content://vibration/effect/43", "content://vibration/effect/44", "content://vibration/effect/45"};
        INTERNAL_RINGTONE_COLUMN = new String[]{"_id", "title", "artist"};
        EXTERNAL_RINGTONE_COLUMN = new String[]{"_id", "title"};
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        boolean r1 = false;
        this.mRootView = r5.inflate(R.layout.ringtone_settings_layout, r6, false);
        int r8 = getIntent().getIntExtra("user_id", -10000);
        this.mManagedProfileId = r8;
        if (r8 == (-10000)) goto L5;
        this.mManagedProfileContext = SoundWorkSettingsFragment.getManagedProfileContext(this.mContext, this.mManagedProfileId);
    L5:
        this.mHandler = new Handler();
        this.mVibratorManager = (Vibrator) getRealContext().getSystemService("vibrator");
        mPresetLongVibrationNames = getRealContext().getResources().getStringArray(R.array.vibration_title);
        mPresetShortVibrationNames = getRealContext().getResources().getStringArray(R.array.vibration_title);
        this.mRingtoneManager = new RingtoneManager(getRealContext());
        this.mResolver = getContentResolver();
        this.mTitleBar = (OFloatingTitleBar) this.mRootView.findViewById(R.id.view_title);
        Bundle r9 = getArguments();
        String r10 = r9.getString("title");
        this.mTitleText = r10;
        this.mTitleBar.setCenterTitle(r10);
        this.mIncludeDrm = r9.getBoolean("android.intent.extra.ringtone.INCLUDE_DRM", true);
        if (r9.getString("android.intent.extra.ringtone.TYPE") == null) goto L8;
        this.mRingtoneType = Integer.parseInt(r9.getString("android.intent.extra.ringtone.TYPE"));
    L9:
        OLog.w(TAG, "mRingtoneType : " + this.mRingtoneType);
        this.mSoundSettingType = r9.getString(SoundSettingsFragment.EXTRA_TYPE);
        this.mAudioManager = (AudioManager) getSystemService("audio");
        String r11 = this.mSoundSettingType;
        if (r11 != null) goto L14;
        finish();
        return this.mRootView;
    L14:
        if (r11.equals(SoundSettingsFragment.TYPE_RINGTONE) == false) goto L16;
    L19:
        boolean r12 = true;
    L20:
        this.mIsRingtoneType = r12;
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_MMS_SUB2) == false) goto L23;
    L24:
        r1 = true;
    L25:
        this.mIsCard2 = r1;
        if (r1 == false) goto L28;
        this.mTitleBar.setCenterSubtitle(getRealContext().getString(R.string.nfc_sim_card_2));
    L28:
        this.mHasMultiSimInDevice = Utils.hasMultiSimInDevice();
        setDefaultRingtoneItem();
        updateInternalRingtones();
        Uri r13 = (Uri) r9.getParcelable("android.intent.extra.ringtone.DEFAULT_URI");
        this.mUriForDefaultItem = r13;
        if (r13 != null) goto L31;
        this.mUriForDefaultItem = android.provider.Settings.System.DEFAULT_RINGTONE_URI;
    L31:
        if (r7 == null) goto L33;
        this.mClickedPos = r7.getInt(SAVE_CLICKED_POS, -1);
    L33:
        ListView r14 = (ListView) findViewByIdNullable(R.id.list_view);
        this.mListView = r14;
        if (r14 == null) goto L36;
        RingtoneAdapter r15 = new RingtoneAdapter(this, getRealContext());
        this.mAdapter = r15;
        this.mListView.setAdapter(r15);
        initHeaderView();
        initFooterView();
    L36:
        UIUtils.setUpBottomPaddingOnApplyWindowInsets(this.mListView);
        IntentFilter r16 = new IntentFilter();
        r16.addAction("android.intent.action.MANAGED_PROFILE_REMOVED");
        registerReceiver(this.mManagedProfileReceiver, r16);
        return this.mRootView;
    L23:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == false) goto L25;
    L16:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == true) goto L19;
        r12 = false;
        goto L20
    L8:
        this.mRingtoneType = r9.getInt("android.intent.extra.ringtone.TYPE", 1);
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    @Override // com.android.settings.base.BaseFragment
    protected Context getRealContext() {
        Context r0 = this.mManagedProfileContext;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return super.getRealContext();
    }

    @Override // com.android.settings.base.BaseFragment
    public ContentResolver getContentResolver() {
        Context r0 = getRealContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContentResolver();
    }

    public void updateViews() {
        this.mRingtoneManager.setIncludeDrm(this.mIncludeDrm);
        int r0 = this.mRingtoneType;
        if (r0 == (-1)) goto L6;
        this.mRingtoneManager.setType(r0);
    L6:
        if (this._mActivity == null) goto L8;
        this._mActivity.setVolumeControlStream(this.mRingtoneManager.inferStreamType());
    L8:
        Uri r1 = getCurrentRingtoneUri();
        this.mCurrentUri = r1;
        if (r1 == null) goto L11;
        OLog.w(TAG, "mCurrentUri : " + this.mCurrentUri.toString());
        checkExistingUri();
    L12:
        updateExternalRingtonesAsync();
        updateFooterCustomRingtoneButton();
        if (this.mRingtoneType == 4) goto L16;
        this.mClickedPos = getListPosition(this.mCurrentUri);
        setVibrationEffect(this.mCurrentUri);
        OCardListItemUtils.setCustomEndTipTextView(this.mVibrationCardListItem, getVibrationEffectString());
        return;
    L16:
        return;
    L11:
        OLog.w(TAG, "mCurrentUri = null ");
        goto L12
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateFooterCustomRingtoneButton() {
        if (this.mHasFooterView == true) goto L5;
        return;
    L5:
        this.mCustomRingtoneMusic.setVisibility(0);
        this.mCustomRingtoneRecord.setBackgroundStyle(4);
        this.mCustomRingtoneRecord.setVisibility(8);
    }

    private void setDefaultRingtoneItem() {
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE) == false) goto L5;
    L11:
        String r1 = "is_ringtone = 1";
    L12:
        Cursor r3 = null;
        r3 = getContentResolver().query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, new String[]{"_id"}, "title = '" + getDefaultRingtoneTitle(getStoragekey()) + "' AND " + r1, null, null);     // Catch: Throwable -> L20 Exception -> L22
        if (r3 != null) goto L16;
    L18:
        if (r3 == null) goto L33;
    L25:
        r3.close();
        return;
    L33:
        return;
    L16:
        if (r3.moveToFirst() == false) goto L18;
        mDefaultUri = ContentUris.withAppendedId(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, r3.getInt(0));     // Catch: Throwable -> L20 Exception -> L22
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
        if (r3 != null) goto L25;
        return;
    L20:
        th = move-exception;
        if (r3 == null) goto L29;
        r3.close();
    L29:
        throw th;
    L5:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == true) goto L11;
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_ALARM) == false) goto L10;
        r1 = "is_alarm = 1";
        goto L12
    L10:
        r1 = "is_notification = 1";
        goto L12
    }

    private void checkExistingUri() {
        Cursor r3 = null;
        int r4 = this.mRingtoneType;     // Catch: Throwable -> L37 Throwable -> L39
        if (r4 != 1) goto L7;
        String r5 = "is_ringtone";
    L10:
        String[] r16 = {"0"};     // Catch: Throwable -> L37 Throwable -> L39
        Cursor r6 = getContentResolver().query(this.mCurrentUri, new String[]{"title"}, r5.concat("=?"), new String[]{"1"}, null);     // Catch: Throwable -> L37 Throwable -> L39
        if (r6 != null) goto L53;
    L17:
        Cursor r1 = getContentResolver().query(this.mCurrentUri, new String[]{"title"}, r5.concat("=?"), r16, null);     // Catch: Throwable -> L31 Throwable -> L34 Throwable -> L34
        if (r1 != null) goto L57;
    L27:
        if (r6 == null) goto L29;
        r6.close();
    L29:
        if (r1 == null) goto L62;
    L45:
        r1.close();
        return;
    L62:
        return;
    L57:
    L25:
        e = e;
    L36:
        r3 = r6;
    L55:
        e.printStackTrace();     // Catch: Throwable -> L47
        if (r3 == null) goto L44;
        r3.close();
    L44:
        if (r1 != null) goto L45;
        return;
    L47:
        th = th;
    L48:
        if (r3 == null) goto L50;
        r3.close();
    L50:
        if (r1 == null) goto L52;
        r1.close();
    L52:
        throw th;
    L23:
        th = th;
    L33:
        r3 = r6;
        goto L48
    L20:
        if (r1.moveToFirst() == false) goto L27;
        ContentValues r2 = new ContentValues();     // Catch: Throwable -> L23 Throwable -> L25
        r2.put(r5, 1);     // Catch: Throwable -> L23 Throwable -> L25
        getContentResolver().update(this.mCurrentUri, r2, null, null);     // Catch: Throwable -> L23 Throwable -> L25
    L31:
        th = th;
        r1 = null;
    L34:
        e = e;
        r1 = null;
        goto L36
    L53:
        if (r6.moveToFirst() == false) goto L17;
        if (r6 == null) goto L61;
        r6.close();
        return;
    L61:
        return;
    L7:
        if (r4 != 4) goto L9;
        r5 = "is_alarm";
        goto L10
    L9:
        r5 = "is_notification";
    L39:
        e = e;
        r1 = null;
    L37:
        th = th;
        r1 = null;
        goto L48
    }

    private String getStoragekey() {
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE) == false) goto L7;
        return "ringtone";
    L7:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_MMS) == false) goto L11;
        return "mms_ringtone_uri";
    L11:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_CALENDAR) == false) goto L15;
        return "calendar_ringtone_uri";
    L15:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_ALARM) == false) goto L19;
        return "alarm_alert";
    L19:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == false) goto L23;
        return "ringtone_2";
    L23:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_MMS_SUB2) == false) goto L27;
        return "mms_ringtone_uri_2";
    L27:
        if (this.mSoundSettingType.equals(HourlyChimeFragment.TYPE_HOURLY_CHIME) == false) goto L30;
        return "hourly_chime_ringtone_uri";
    L30:
        return "notification_sound";
    }

    private int getInternalRingtonePosition() {
        return this.mClickedPos - this.mExternalRingtones.size();
    }

    private boolean isRingtoneUseExternalRINGTONE() {
        String r1 = android.provider.Settings.System.getString(getContentResolver(), "ringtone");
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.contains("external");
    }

    private boolean isUseExternalRINGTONE() {
        Uri r1 = getRingtoneUri(getStoragekey());
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.toString().contains("external");
    }

    @Override // java.lang.Runnable
    public void run() {
        int r0 = this.mClickedPos;
        if (r0 != this.mDefaultRingtonePos) goto L6;
        Uri r1 = this.mUriForDefaultItem;
    L9:
        LocalRingtonePlayer r2 = this.mPlayer;
        if (r2 != null) goto L12;
        LocalRingtonePlayer r3 = new LocalRingtonePlayer(getRealContext(), r1);
        this.mPlayer = r3;
        r3.setCompletionListener(this.mCompletionListener);
        this.mPlayer.setStreamType(this.mRingtoneManager.inferStreamType());
        this.mPlayer.setSoundType(this.mSoundSettingType);
    L13:
        OLog.d(TAG, "try play ringtone uri = " + r1);
        playRingtone();
        return;
    L12:
        r2.setUri(r1);
        goto L13
    L6:
        if (r0 >= this.mExternalRingtones.size()) goto L8;
        r1 = this.mExternalRingtones.get(this.mClickedPos).getUri();
        goto L9
    L8:
        r1 = this.mInternalRingtones.get(this.mClickedPos - this.mExternalRingtones.size()).getUri();
        goto L9
    }

    private void checkAndShowMuteToast() {
        LocalRingtonePlayer r0 = this.mPlayer;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isPlaying() == true) goto L8;
        return;
    L8:
        if (android.provider.Settings.System.getInt(getContentResolver(), "volume_panel_mute_enable", 0) != 1) goto L16;
        AudioDeviceInfo r1 = this.mPlayer.getRoutedDevice();
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.getType() != 2) goto L18;
        showMuteToast();
        OLog.d(TAG, "not need play ringtone because mute mode is turned on");
        return;
    L18:
        return;
    }

    private void showMuteToast() {
        OToast r0 = this.mMuteToast;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.mMuteToast = ToastUtils.show(this._mActivity, R.string.mute_mode_is_turned_on);
    }

    private void playRingtone() {
        this.mAudioManager.requestAudioFocus(this.mAudioFocusListener, this.mRingtoneType, 2);
        LocalRingtonePlayer r0 = this.mPlayer;
        if (r0 == null) goto L5;
        r0.stop();
        this.mPlayer.play();
        updatePlayingAnim(true);
        this.mPlayer.addOnRoutingChangedListener(this.mAudioRoutingChangedListener, this.mHandler);
        OLog.d(TAG, "play ringtone correctly." + this.mPlayer.getRoutedDevice());
        return;
    L5:
        OLog.d(TAG, "try play ringtone, but player is null.");
    }

    private void stopAnyPlayingRingtone() {
        this.mAudioManager.abandonAudioFocus(this.mAudioFocusListener);
        LocalRingtonePlayer r0 = this.mPlayer;
        if (r0 == null) goto L5;
        r0.stop();
        this.mPlayer.removeOnRoutingChangedListener(this.mAudioRoutingChangedListener);
    L5:
        updatePlayingAnim(false);
    }

    private void updatePlayingAnim(boolean r3) {
        OLog.e(TAG, "updatePlayingAnim:" + r3);
        this.mIsMediaPlaying = r3;
        updatePlayRingtoneAnimation();
    }

    private void addSilentItem() {
        Ringtone r0 = new Ringtone(this);
        r0.setUri(null);
        r0.setTitle(getString(R.string.sound_settings_no_ring));
        this.mExternalRingtones.add(0, r0);
    }

    private void addSametoSub1Item() {
        Ringtone r0 = new Ringtone(this);
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == false) goto L6;
        Uri r1 = RingtoneManager.getActualDefaultRingtoneUri(getRealContext(), 1);
    L9:
        r0.setUri(r1);
        r0.setTitle(getString(R.string.ringtone_same_to_sub1));
        this.mExternalRingtones.add(0, r0);
        return;
    L6:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_MMS_SUB2) == false) goto L8;
        r1 = getRingtoneUri("mms_ringtone_uri");
        goto L9
    L8:
        r1 = null;
        goto L9
    }

    private void initFooterView() {
        if (this.mListView.getFooterViewsCount() != 0) goto L12;
        int r3 = 0;
        LinearLayout r0 = (LinearLayout) this.mLayoutInflater.inflate(R.layout.ringtone_settings_custom_button, null, false);
        SettingItemButton r1 = (SettingItemButton) r0.findViewById(R.id.custom_ringtone_record);
        this.mCustomRingtoneRecord = r1;
        r1.setOnClickListener(this);
        OCardListItem r2 = (OCardListItem) r0.findViewById(R.id.text_make_ringtone);
        this.mCustomRingtoneMusic = r2;
        OTextView r4 = (OTextView) r2.getCustomStartView().findViewById(R.id.settings_text);
        r4.setText(R.string.make_ringtone_text);
        r4.setTextColor(ContextCompat.getColor(this.mContext, R.color.oui_accent_fg));
        this.mCustomRingtoneMusic.setOnContentClickListener(new RingtoneSettingsFragment$$ExternalSyntheticLambda0(this));
        this.mListView.addFooterView(r0);
        this.mHasFooterView = true;
        this.mFooterView = r0;
        if (isSameToSMS1SwitchOn() == false) goto L7;
    L9:
        r3 = 8;
    L10:
        r0.setVisibility(r3);
        return;
    L7:
        if (isRingtoneSwitchOn() == false) goto L9;
    }

    /* JADX INFO: renamed from: lambda$initFooterView$0$com-android-settings-RingtoneSettingsFragment, reason: not valid java name */
    /* synthetic */ void m196x1f8e632a(View r1) {
        onClick(this.mCustomRingtoneMusic);
    }

    private void initHeaderView() {
        View r0 = this.mLayoutInflater.inflate(R.layout.ringtone_settings_list_view_header_view_layout, null, false);
        LinearLayout r1 = (LinearLayout) r0.findViewById(R.id.vibration_item_container);
        OCardListItem r2 = (OCardListItem) r0.findViewById(R.id.vibration_card_list_item);
        this.mVibrationCardListItem = r2;
        int r6 = 8;
        if (this.mRingtoneType != 4) goto L5;
        r1.setVisibility(8);
        ((LinearLayout) r0.findViewById(R.id.ring_switch_container)).setPadding(0, UIUtils.INSTANCE.dp2px(8), 0, 0);
    L7:
        if (this.mHasMultiSimInDevice == true) goto L9;
    L11:
        OCardListItem r3 = (OCardListItem) r0.findViewById(R.id.ringtone_switch_card_list_item);
        this.mRingtoneSwitchCardListItem = r3;
        if (this.mHasMultiSimInDevice == true) goto L14;
    L16:
        int r4 = 0;
    L17:
        r3.setCardPosition(r4);
        this.mRingtoneSwitchCardListItem.setTitle(this.mTitleText + getString(R.string.volume_ring_only_description));
        OCardListItem r5 = this.mRingtoneSwitchCardListItem;
        if (isSameToSMS1SwitchOn() == true) goto L21;
        r6 = 0;
    L21:
        r5.setVisibility(r6);
        this.mRingtoneSwitchCardListItem.getContentContainer().setClickable(false);
        ((OSwitch) this.mRingtoneSwitchCardListItem.getCustomEndView()).setChecked(isRingtoneSwitchOn());
        ((OSwitch) this.mRingtoneSwitchCardListItem.getCustomEndView()).setOnCheckedChangeListener(new AnonymousClass8(this));
        this.mListView.addHeaderView(r0);
        return;
    L14:
        if (this.mIsCard2 == false) goto L16;
        r4 = 3;
        goto L17
    L9:
        if (this.mIsCard2 == false) goto L11;
        OCardListItem r7 = (OCardListItem) r0.findViewById(R.id.same_to_sms1_card_list_item);
        this.mSameToSMS1CardListItem = r7;
        r7.setVisibility(0);
        this.mSameToSMS1CardListItem.setCardPosition(!isSameToSMS1SwitchOn() ? 1 : 0);
        this.mSameToSMS1CardListItem.getContentContainer().setClickable(false);
        ((OSwitch) this.mSameToSMS1CardListItem.getCustomEndView()).setChecked(isSameToSMS1SwitchOn());
        ((OSwitch) this.mSameToSMS1CardListItem.getCustomEndView()).setOnCheckedChangeListener(new AnonymousClass7(this));
        goto L11
    L5:
        r2.setTitle(this.mTitleText + getString(R.string.vibration_tips));
        OCardListItemUtils.setCustomEndTipTextView(this.mVibrationCardListItem, getVibrationEffectString());
        this.mVibrationCardListItem.setOnContentClickListener(new AnonymousClass6(this));
        goto L7
    }

    private void showVibrationPopMenu(final boolean r12, final int r13) {
        int r1 = 0;
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        String[] r3 = mPresetLongVibrationNames;
    L12:
        if (r0 == false) goto L14;
        String[] r4 = mPresetLongVibrationUris;
    L15:
        final String[] r10 = r4;
        if (r0 == false) goto L18;
        String[] r2 = mSyncLongVibrationUris;
    L19:
        final String[] r9 = r2;
        String r5 = getVibrationEffectString();
        ArrayList r6 = new ArrayList();
        r6.add(new Item(getString(R.string.vibration_effect_none), r5.equals(getString(R.string.vibration_effect_none))));
        if (r12 == true) goto L23;
        r6.add(new Item(getString(R.string.vibration_effect_sync), r5.equals(getString(R.string.vibration_effect_sync))));
    L23:
        if (r1 >= r3.length) goto L25;
        String r7 = r3[r1];
        r6.add(new Item(r7, r5.equals(r7)));
        r1 = r1 + 1;
        goto L23
    L25:
        this.mVibrationPopMenu = OPopoverHelper.showPopoverList(this._mActivity, this.mVibrationCardListItem, r6, new AnonymousClass9(this, r12, r13, r9, r10), true);
        return;
    L18:
        r2 = mSyncShortVibrationUris;
        goto L19
    L14:
        r4 = mPresetShortVibrationUris;
        goto L15
    L11:
        r3 = mPresetShortVibrationNames;
        goto L12
    L5:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == true) goto L8;
        r0 = false;
        goto L9
    }

    private void vibrate(String r2) {
        Vibrator r0 = this.mVibratorManager;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hasVibrator() == false) goto L15;
        if (r2 == null) goto L13;
        Uri r3 = Uri.parse(r2);
        VibrationEffect r4 = vibrationEffectGetEffectByUri(getRealContext(), r3);
        if (r4 == null) goto L14;
        this.mVibratorManager.vibrate(r4);
        return;
    L14:
        return;
    L13:
        return;
    }

    public VibrationEffect vibrationEffectGetEffectByUri(Context r8, Uri r9) {
        return (VibrationEffect) VibrationEffect.class.getMethod("getEffectByUri", new Class[]{Uri.class, Context.class}).invoke(null, new Object[]{r9, r8});
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private boolean isRingtoneSwitchOn() {
        if (TextUtils.isEmpty(this.mSoundSettingType) == false) goto L5;
        String r0 = "type_default_ringtone_switch_on";
    L7:
        if (android.provider.Settings.System.getInt(getContentResolver(), r0, 1) == 1) goto L11;
        return false;
    L11:
        return true;
    L5:
        r0 = this.mSoundSettingType + RINGTONE_SWITCH_ON_SUFFIX;
        goto L7
    }

    public static void updateRingtoneSwitchMode(Context r1, String r2, boolean r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        String r4 = "type_default_ringtone_switch_on";
    L6:
        android.provider.Settings.System.putInt(r1.getContentResolver(), r4, r3 ? 1 : 0);
        return;
    L5:
        r4 = r2 + RINGTONE_SWITCH_ON_SUFFIX;
        goto L6
    }

    private boolean isSameToSMS1SwitchOn() {
        if (this.mHasMultiSimInDevice == true) goto L5;
        return false;
    L5:
        if (this.mIsCard2 == true) goto L7;
        return false;
    L7:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_MMS_SUB2) == false) goto L12;
        if (android.provider.Settings.System.getInt(getContentResolver(), "mms_sub2_ringtone_sameto_sub1", 0) == 1) goto L19;
        return false;
    L19:
        return true;
    L12:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == true) goto L14;
        return false;
    L14:
        if (android.provider.Settings.System.getInt(getContentResolver(), "sub2_ringtone_sameto_sub1", 0) == 1) goto L19;
        return false;
    }

    private void updateSameToSMS1SwitchMode(boolean r3) {
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_MMS_SUB2) == false) goto L6;
        android.provider.Settings.System.putInt(getContentResolver(), "mms_sub2_ringtone_sameto_sub1", r3 ? 1 : 0);
        return;
    L6:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == false) goto L10;
        android.provider.Settings.System.putInt(getContentResolver(), "sub2_ringtone_sameto_sub1", r3 ? 1 : 0);
        return;
    }

    private boolean isSyncVibrationEffect(String r3) {
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE) == true) goto L10;
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == true) goto L10;
        return Arrays.asList(mSyncShortVibrationUris).contains(r3);
    L10:
        return Arrays.asList(mSyncLongVibrationUris).contains(r3);
    }

    private String getVibrationEffectString() {
        String r0 = this.mSoundSettingType;
        r0.hashCode();
        int r4 = 0;
        byte r5 = -1;
        switch(r0.hashCode()) {
            case -883389629: goto L26;
            case -675989426: goto L22;
            case -150053113: goto L18;
            case 610021948: goto L14;
            case 908205731: goto L10;
            case 1870114858: goto L6;
            default: goto L29;
        };
    L29:
        switch(r5) {
            case 0: goto L36;
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L31;
            default: goto L30;
        };
    L30:
        String r1 = "";
    L38:
        if (r1 != null) goto L42;
        return getString(R.string.vibration_effect_sync);
    L42:
        if (r1.equals("none") == false) goto L45;
        return getString(R.string.vibration_effect_none);
    L45:
        if (isSyncVibrationEffect(r1) == false) goto L48;
        return getString(R.string.vibration_effect_sync);
    L48:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE) == true) goto L59;
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == true) goto L59;
    L53:
        if (r4 >= mPresetShortVibrationNames.length) goto L73;
        if (r1.equals(mPresetShortVibrationUris[r4]) == true) goto L71;
        r4 = r4 + 1;
        goto L53
    L71:
        return mPresetShortVibrationNames[r4];
    L73:
        return r1;
    L59:
        if (r4 >= mPresetLongVibrationNames.length) goto L74;
        if (r1.equals(mPresetLongVibrationUris[r4]) == true) goto L72;
        r4 = r4 + 1;
        goto L59
    L72:
        return mPresetLongVibrationNames[r4];
    L74:
        return r1;
    L31:
        r1 = android.provider.Settings.System.getString(getContentResolver(), RINGTONE_VIBRATION_EFFECT_2);
        goto L38
    L32:
        r1 = getVibrationEffectUri(CALENDAR_VIBRATION_ENABLED, CALENDAR_VIBRATION_EFFECT_URI);
        goto L38
    L33:
        r1 = getVibrationEffectUri(NOTIFICATION_VIBRATION_ENABLED, NOTIFICATION_VIBRATION_EFFECT_URI);
        goto L38
    L34:
        r1 = android.provider.Settings.System.getString(getContentResolver(), RINGTONE_VIBRATION_EFFECT);
        goto L38
    L35:
        r1 = getVibrationEffectUri(SMS_1_VIBRATION_ENABLED, SMS_1_VIBRATION_EFFECT_URI);
        goto L38
    L36:
        r1 = getVibrationEffectUri(SMS_2_VIBRATION_ENABLED, SMS_2_VIBRATION_EFFECT_URI);
        goto L38
    L6:
        if (r0.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == false) goto L29;
        r5 = 5;
        goto L29
    L10:
        if (r0.equals(SoundSettingsFragment.TYPE_CALENDAR) == false) goto L29;
        r5 = 4;
        goto L29
    L14:
        if (r0.equals(SoundSettingsFragment.TYPE_DEFAULT) == false) goto L29;
        r5 = 3;
        goto L29
    L18:
        if (r0.equals(SoundSettingsFragment.TYPE_RINGTONE) == false) goto L29;
        r5 = 2;
        goto L29
    L22:
        if (r0.equals(SoundSettingsFragment.TYPE_MMS) == false) goto L29;
        r5 = 1;
        goto L29
    L26:
        if (r0.equals(SoundSettingsFragment.TYPE_MMS_SUB2) == false) goto L29;
        r5 = 0;
        goto L29
    }

    private String getVibrationEffectUri(String r3, String r4) {
        if (android.provider.Settings.Global.getInt(getContentResolver(), r3, 1) != 0) goto L7;
        return "none";
    L7:
        return android.provider.Settings.Global.getString(getContentResolver(), r4);
    }

    private boolean isAppInstalled(Context r1, String r2) {
        r1.getPackageManager().getPackageInfo(r2, 1);     // Catch: PackageManager.NameNotFoundException -> L5
        return true;
    L5:
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        if (r4 != this.mCustomRingtoneMusic) goto L11;
        if (isAppInstalled(getRealContext(), "com.obric.filemanager") == true) goto L14;
        ToastUtils.show(getActivity(), getString(R.string.make_ringtone_error_text));
        return;
    L14:
        Intent r5 = new Intent("android.intent.action.GET_CONTENT");     // Catch: Exception -> L8
        r5.setPackage("com.obric.filemanager");     // Catch: Exception -> L8
        r5.setType("audio/*");     // Catch: Exception -> L8
        Utils.startActivity(this, r5, 3, 1);     // Catch: Exception -> L8
        return;
    L8:
        OLog.d(TAG, "filemanager no install");
        return;
    L11:
        if (r4 != this.mCustomRingtoneRecord) goto L18;
        Utils.startActivity(this, new Intent("com.obric.recorder.ACTION_PICK_RINGTONE"), 2, 1);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        if (r3 != RESULT_OK) goto L10;
        if (r4 == null) goto L11;
        Uri r5 = r4.getData();
        ToastUtils.show(getActivity(), getString(R.string.ringtone_set_successfully));
        if (this.mIsCard2 == false) goto L8;
        android.provider.Settings.System.putInt(getContentResolver(), "sub2_ringtone_sameto_sub1", 0);
    L8:
        new AnonymousClass11(this).execute(new Uri[]{r5});
        return;
    L11:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        r2.putInt(SAVE_CLICKED_POS, this.mClickedPos);
    }

    private String getColumnKey() {
        int r1 = this.mRingtoneType;
        if (r1 != 1) goto L5;
        return "is_ringtone";
    L5:
        if (r1 == 2) goto L8;
        return "is_alarm";
    L8:
        return "is_notification";
    }

    private int getListPosition(Uri r7) {
        if (r7 != null) goto L5;
        return -1;
    L5:
        String r1 = r7.toString();
        int r3 = 0;
        if (r1.contains("?") == false) goto L8;
        r7 = Uri.parse(r1.split("\\?")[0]);
    L8:
        int r2 = 0;
    L10:
        if (r2 >= this.mInternalRingtones.size()) goto L17;
        if (r7.equals(this.mInternalRingtones.get(r2).getUri()) == true) goto L14;
        r2 = r2 + 1;
        goto L10
    L14:
        return this.mExternalRingtones.size() + r2;
    L17:
        if (r3 >= this.mExternalRingtones.size()) goto L25;
        if (ContentUris.parseId(r7) != this.mExternalRingtones.get(r3).getId()) goto L24;
        return r3;
    L24:
        r3 = r3 + 1;
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    L25:
        return -1;
    }

    private Uri getUri(int r2) {
        if (r2 != (-1)) goto L7;
        return null;
    L7:
        if (r2 >= this.mExternalRingtones.size()) goto L11;
        return this.mExternalRingtones.get(r2).getUri();
    L11:
        return this.mInternalRingtones.get(r2 - this.mExternalRingtones.size()).getUri();
    }

    private Ringtone findRingtoneByUri(Uri r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        String r1 = r8.getEncodedPath();
        Iterator<Ringtone> r2 = this.mInternalRingtones.iterator();
    L7:
        if (r2.hasNext() == false) goto L15;
        Ringtone r3 = r2.next();
        Uri r4 = Ringtone.access$3900(r3);
        if (r4 == null) goto L7;
        if (TextUtils.equals(r4.getScheme(), r8.getScheme()) == false) goto L7;
        if (TextUtils.equals(r1, r4.getEncodedPath()) == false) goto L7;
        return r3;
    L15:
        Iterator<Ringtone> r7 = this.mExternalRingtones.iterator();
    L17:
        if (r7.hasNext() == false) goto L25;
        Ringtone r5 = r7.next();
        Uri r6 = Ringtone.access$3900(r5);
        if (r6 == null) goto L17;
        if (TextUtils.equals(r6.getScheme(), r8.getScheme()) == false) goto L17;
        if (TextUtils.equals(r1, r6.getEncodedPath()) == false) goto L17;
        return r5;
    L25:
        return null;
    }

    private String findSyncVibrationByUri(Uri r3) {
        Ringtone r4 = findRingtoneByUri(r3);
        if (r4 != null) goto L14;
        return null;
    L14:
        String r5 = r4.getFileName();     // Catch: Exception -> L11
        int r2 = Arrays.asList(getResources().getStringArray(R.array.ringtone_file_name_to_vibration)).indexOf(r5);     // Catch: Exception -> L11
        if (r2 < 0) goto L13;
        String[] r6 = mSyncLongVibrationUris;     // Catch: Exception -> L11
        if (r2 >= r6.length) goto L13;
        return r6[r2];
    L13:
        return null;
    L11:
        e = move-exception;
        OLog.e(TAG, "findSyncVibrationByUri", e);
        goto L13
    }

    private String findSyncShortVibrationByUri(Uri r3) {
        Ringtone r4 = findRingtoneByUri(r3);
        if (r4 != null) goto L14;
        return null;
    L14:
        String r5 = r4.getFileName();     // Catch: Exception -> L11
        int r2 = Arrays.asList(getResources().getStringArray(R.array.notification_file_name_to_vibration)).indexOf(r5);     // Catch: Exception -> L11
        if (r2 < 0) goto L13;
        String[] r6 = mSyncShortVibrationUris;     // Catch: Exception -> L11
        if (r2 >= r6.length) goto L13;
        return r6[r2];
    L13:
        return null;
    L11:
        e = move-exception;
        OLog.e(TAG, "findSyncVibrationByUri", e);
        goto L13
    }

    private void setVibrationEffect(Uri r13) {
        int r0 = getInternalRingtonePosition();
        if (r13 != null) goto L5;
        String r2 = null;
    L6:
        OLog.d(TAG, "setVibrationEffect:" + r2);
        String r3 = this.mSoundSettingType;
        r3.hashCode();
        boolean r6 = true;
        byte r8 = -1;
        switch(r3.hashCode()) {
            case -883389629: goto L30;
            case -675989426: goto L26;
            case -150053113: goto L22;
            case 610021948: goto L18;
            case 908205731: goto L14;
            case 1870114858: goto L10;
            default: goto L34;
        };
    L10:
        if (r3.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == false) goto L34;
        r8 = 5;
        goto L34
    L14:
        if (r3.equals(SoundSettingsFragment.TYPE_CALENDAR) == false) goto L34;
        r8 = 4;
        goto L34
    L18:
        if (r3.equals(SoundSettingsFragment.TYPE_DEFAULT) == false) goto L34;
        r8 = 3;
        goto L34
    L22:
        if (r3.equals(SoundSettingsFragment.TYPE_RINGTONE) == false) goto L34;
        r8 = 2;
        goto L34
    L26:
        if (r3.equals(SoundSettingsFragment.TYPE_MMS) == false) goto L34;
        r8 = 1;
        goto L34
    L30:
        if (r3.equals(SoundSettingsFragment.TYPE_MMS_SUB2) == false) goto L34;
        r8 = 0;
    L34:
        switch(r8) {
            case 0: goto L142;
            case 1: goto L110;
            case 2: goto L83;
            case 3: goto L66;
            case 4: goto L49;
            case 5: goto L36;
            default: goto L159;
        };
    L36:
        String r4 = android.provider.Settings.System.getString(getContentResolver(), RINGTONE_VIBRATION_EFFECT_2);
        if (r4 != null) goto L39;
    L40:
        if (r2 != null) goto L43;
        android.provider.Settings.System.putString(getContentResolver(), RINGTONE_VIBRATION_EFFECT_2, null);
        goto L159
    L43:
        if (isUseExternalRINGTONE() == true) goto L48;
        if (r0 < 0) goto L48;
        if (r0 >= mSyncLongVibrationUris.length) goto L48;
        String r14 = findSyncVibrationByUri(r13);
        OLog.d(TAG, "setVibrationEffect(RINGTONE2):" + r14);
        android.provider.Settings.System.putString(getContentResolver(), RINGTONE_VIBRATION_EFFECT_2, r14);
    L48:
        android.provider.Settings.System.putString(getContentResolver(), RINGTONE_VIBRATION_EFFECT_2, mPresetLongVibrationUris[0]);
        goto L159
    L39:
        if (isSyncVibrationEffect(r4) == false) goto L159;
    L49:
        String r15 = android.provider.Settings.Global.getString(getContentResolver(), CALENDAR_VIBRATION_EFFECT_URI);
        if (android.provider.Settings.Global.getInt(getContentResolver(), CALENDAR_VIBRATION_ENABLED, 1) == 1) goto L53;
        r6 = false;
    L53:
        if (r6 == false) goto L159;
        if (r15 != null) goto L56;
    L57:
        if (r2 != null) goto L60;
        android.provider.Settings.Global.putString(getContentResolver(), CALENDAR_VIBRATION_EFFECT_URI, null);
        goto L159
    L60:
        if (isUseExternalRINGTONE() == true) goto L65;
        if (r0 < 0) goto L65;
        String[] r16 = mSyncShortVibrationUris;
        if (r0 >= r16.length) goto L65;
        android.provider.Settings.Global.putString(getContentResolver(), CALENDAR_VIBRATION_EFFECT_URI, r16[r0]);
    L65:
        android.provider.Settings.Global.putString(getContentResolver(), CALENDAR_VIBRATION_EFFECT_URI, mPresetShortVibrationUris[0]);
        goto L159
    L56:
        if (isSyncVibrationEffect(r15) == false) goto L159;
    L66:
        String r5 = android.provider.Settings.Global.getString(getContentResolver(), NOTIFICATION_VIBRATION_EFFECT_URI);
        if (android.provider.Settings.Global.getInt(getContentResolver(), NOTIFICATION_VIBRATION_ENABLED, 1) == 1) goto L70;
        r6 = false;
    L70:
        if (r6 == false) goto L159;
        if (r5 != null) goto L73;
    L74:
        if (r2 != null) goto L77;
        android.provider.Settings.Global.putString(getContentResolver(), NOTIFICATION_VIBRATION_EFFECT_URI, null);
        goto L159
    L77:
        if (isUseExternalRINGTONE() == true) goto L82;
        if (r0 < 0) goto L82;
        if (r0 >= mSyncShortVibrationUris.length) goto L82;
        android.provider.Settings.Global.putString(getContentResolver(), NOTIFICATION_VIBRATION_EFFECT_URI, findSyncShortVibrationByUri(r13));
    L82:
        android.provider.Settings.Global.putString(getContentResolver(), NOTIFICATION_VIBRATION_EFFECT_URI, mPresetShortVibrationUris[0]);
        goto L159
    L73:
        if (isSyncVibrationEffect(r5) == false) goto L159;
    L83:
        String r7 = android.provider.Settings.System.getString(getContentResolver(), RINGTONE_VIBRATION_EFFECT);
        String r9 = android.provider.Settings.System.getString(getContentResolver(), RINGTONE_VIBRATION_EFFECT_2);
        if (android.provider.Settings.System.getInt(getContentResolver(), "sub2_ringtone_sameto_sub1", 0) != 1) goto L86;
        boolean r10 = true;
    L87:
        if (r10 == true) goto L89;
    L91:
        r6 = false;
    L92:
        if (r7 != null) goto L94;
    L95:
        if (r2 != null) goto L100;
        android.provider.Settings.System.putString(getContentResolver(), RINGTONE_VIBRATION_EFFECT, null);
        if (r6 == false) goto L159;
        android.provider.Settings.System.putString(getContentResolver(), RINGTONE_VIBRATION_EFFECT_2, null);
        goto L159
    L100:
        if (isUseExternalRINGTONE() == true) goto L107;
        if (r0 < 0) goto L107;
        if (r0 >= mSyncLongVibrationUris.length) goto L107;
        String r17 = findSyncVibrationByUri(r13);
        OLog.d(TAG, "setVibrationEffect(RINGTONE):" + r17);
        android.provider.Settings.System.putString(getContentResolver(), RINGTONE_VIBRATION_EFFECT, r17);
        if (r6 == false) goto L159;
        android.provider.Settings.System.putString(getContentResolver(), RINGTONE_VIBRATION_EFFECT_2, r17);
    L107:
        ContentResolver r18 = getContentResolver();
        String[] r1 = mPresetLongVibrationUris;
        android.provider.Settings.System.putString(r18, RINGTONE_VIBRATION_EFFECT, r1[0]);
        if (r6 == false) goto L159;
        android.provider.Settings.System.putString(getContentResolver(), RINGTONE_VIBRATION_EFFECT_2, r1[0]);
        goto L159
    L94:
        if (isSyncVibrationEffect(r7) == false) goto L159;
    L89:
        if (isSyncVibrationEffect(r9) == false) goto L91;
    L86:
        r10 = false;
        goto L87
    L110:
        String r11 = android.provider.Settings.Global.getString(getContentResolver(), SMS_1_VIBRATION_EFFECT_URI);
        String r12 = android.provider.Settings.Global.getString(getContentResolver(), SMS_2_VIBRATION_EFFECT_URI);
        if (android.provider.Settings.System.getInt(getContentResolver(), "mms_sub2_ringtone_sameto_sub1", 0) != 1) goto L113;
        boolean r19 = true;
    L114:
        if (r19 == true) goto L116;
    L118:
        boolean r20 = false;
    L120:
        if (android.provider.Settings.Global.getInt(getContentResolver(), SMS_1_VIBRATION_ENABLED, 1) == 1) goto L123;
        r6 = false;
    L123:
        if (r6 == false) goto L159;
        if (r11 != null) goto L126;
    L127:
        if (r2 != null) goto L132;
        android.provider.Settings.Global.putString(getContentResolver(), SMS_1_VIBRATION_EFFECT_URI, null);
        if (r20 == false) goto L159;
        android.provider.Settings.Global.putString(getContentResolver(), SMS_2_VIBRATION_EFFECT_URI, null);
        goto L159
    L132:
        if (isUseExternalRINGTONE() == true) goto L139;
        if (r0 < 0) goto L139;
        if (r0 >= mSyncShortVibrationUris.length) goto L139;
        String r110 = findSyncShortVibrationByUri(r13);
        android.provider.Settings.Global.putString(getContentResolver(), SMS_1_VIBRATION_EFFECT_URI, r110);
        if (r20 == false) goto L159;
        android.provider.Settings.Global.putString(getContentResolver(), SMS_2_VIBRATION_EFFECT_URI, r110);
    L139:
        ContentResolver r111 = getContentResolver();
        String[] r21 = mPresetShortVibrationUris;
        android.provider.Settings.Global.putString(r111, SMS_1_VIBRATION_EFFECT_URI, r21[0]);
        if (r20 == false) goto L159;
        android.provider.Settings.Global.putString(getContentResolver(), SMS_2_VIBRATION_EFFECT_URI, r21[0]);
        goto L159
    L126:
        if (isSyncVibrationEffect(r11) == false) goto L159;
    L116:
        if (isSyncVibrationEffect(r12) == false) goto L118;
        r20 = true;
        goto L120
    L113:
        r19 = false;
        goto L114
    L142:
        String r22 = android.provider.Settings.Global.getString(getContentResolver(), SMS_2_VIBRATION_EFFECT_URI);
        if (android.provider.Settings.Global.getInt(getContentResolver(), SMS_2_VIBRATION_ENABLED, 1) == 1) goto L146;
        r6 = false;
    L146:
        if (r6 == false) goto L159;
        if (r22 != null) goto L149;
    L150:
        if (r2 != null) goto L153;
        android.provider.Settings.Global.putString(getContentResolver(), SMS_2_VIBRATION_EFFECT_URI, null);
        goto L159
    L153:
        if (isUseExternalRINGTONE() == true) goto L158;
        if (r0 < 0) goto L158;
        if (r0 >= mSyncShortVibrationUris.length) goto L158;
        android.provider.Settings.Global.putString(getContentResolver(), SMS_2_VIBRATION_EFFECT_URI, findSyncShortVibrationByUri(r13));
    L158:
        android.provider.Settings.Global.putString(getContentResolver(), SMS_2_VIBRATION_EFFECT_URI, mPresetShortVibrationUris[0]);
        goto L159
    L149:
        if (isSyncVibrationEffect(r22) == true) goto L150;
    L159:
        OCardListItemUtils.setCustomEndTipTextView(this.mVibrationCardListItem, getVibrationEffectString());
        return;
    L5:
        r2 = r13.toString();
        goto L6
    }

    public void storageRingtoneUri(Uri r5) {
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE) == false) goto L8;
        RingtoneManager.setActualDefaultRingtoneUri(getRealContext(), 1, r5);
        if (isSub2ItemSameToSub1(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == false) goto L15;
        setRingtoneUri("ringtone_2", r5);
    L15:
        setVibrationEffect(r5);
        return;
    L8:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == false) goto L10;
        RingtoneManager.setActualDefaultRingtoneUri(getRealContext(), 2097152, r5);
        setRingtoneUri("ringtone_2", r5);
        goto L15
    L10:
        setRingtoneUri(getStoragekey(), r5);
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_MMS) == false) goto L15;
        if (isSub2ItemSameToSub1(SoundSettingsFragment.TYPE_MMS_SUB2) == false) goto L15;
        setRingtoneUri("mms_ringtone_uri_2", r5);
        goto L15
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        stopAnyPlayingRingtone();
        Vibrator r0 = this.mVibratorManager;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        OPopover r1 = this.mVibrationPopMenu;
        if (r1 == null) goto L8;
        r1.dismiss();
        this.mVibrationPopMenu = null;
    L8:
        this._mActivity.setVolumeControlStream(Integer.MIN_VALUE);
        this.mListSelection = this.mListView.getFirstVisiblePosition();
        if (this.mListView.getChildAt(0) == null) goto L12;
        this.mListTop = this.mListView.getChildAt(0).getTop();
        return;
    }

    private Uri getCurrentRingtoneUri() {
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE) == false) goto L7;
        return RingtoneManager.getActualDefaultRingtoneUri(getRealContext(), 1);
    L7:
        return getRingtoneUri(getStoragekey());
    }

    private Uri getSMS1RingtoneUri() {
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_MMS_SUB2) == false) goto L7;
        return getRingtoneUri("mms_ringtone_uri");
    L7:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == true) goto L9;
        return null;
    L9:
        return getRingtoneUri("ringtone");
    }

    private Uri getRingtoneUri(String r1) {
        String r0 = android.provider.Settings.System.getString(getContentResolver(), r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return Uri.parse(r0);
    }

    private void setRingtoneUri(String r4, Uri r5) {
        OLog.w("0373948", "set ringtone uri for key " + r4 + " uri: " + makeSafeUriString(r5) + " result  " + android.provider.Settings.System.putString(getContentResolver(), r4, makeSafeUriString(r5)));
    }

    private String makeSafeUriString(Uri r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.toString();
    }

    private void playRingtoneAnimation(boolean r2, OCardListItem r3) {
        int r1 = 0;
        View r4 = r3.getCustomTitleView(0);
        if (r4 == null) goto L13;
        ImageView r5 = (ImageView) r4.findViewById(R.id.custom_start_image);
        if (r2 == true) goto L8;
        r1 = 8;
    L8:
        r5.setVisibility(r1);
        r5.setBackgroundResource(R.drawable.anim_play_sound_bg);
        AnimationDrawable r6 = (AnimationDrawable) r5.getBackground();
        if (r2 == false) goto L11;
        r6.start();
        return;
    L11:
        r6.stop();
        return;
    }

    private void updateInternalRingtones() {
        this.mInternalRingtones.clear();
        Cursor r1 = null;
        r1 = getContentResolver().query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, INTERNAL_RINGTONE_COLUMN, getSelectionFromType(), null, "title_key");     // Catch: Throwable -> L32 Exception -> L34
        if (r1 != null) goto L7;
        OLog.e(TAG, "internal cursor is null! Check error logs for more info.");     // Catch: Throwable -> L32 Exception -> L34
    L29:
        sortInternalRingtones();     // Catch: Throwable -> L32 Exception -> L34
        if (r1 == null) goto L54;
    L37:
        r1.close();
        return;
    L54:
        return;
    L7:
        if (r1.getCount() != 0) goto L12;
        OLog.e(TAG, "internal cursor is empty! Query type is " + this.mRingtoneType);     // Catch: Throwable -> L32 Exception -> L34
        if (r1 == null) goto L53;
        r1.close();
        return;
    L53:
        return;
    L12:
        int r0 = r1.getColumnIndex("title");     // Catch: Throwable -> L32 Exception -> L34
        int r2 = r1.getColumnIndex("_id");     // Catch: Throwable -> L32 Exception -> L34
        int r3 = r1.getColumnIndex("artist");     // Catch: Throwable -> L32 Exception -> L34
    L14:
        if (r1.moveToNext() == false) goto L29;
        Ringtone r4 = new Ringtone(this);     // Catch: Throwable -> L32 Exception -> L34
        int r5 = r1.getInt(r2);     // Catch: Throwable -> L32 Exception -> L34
        r4.setId(r5);     // Catch: Throwable -> L32 Exception -> L34
        r4.setUri(ContentUris.withAppendedId(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, r5));     // Catch: Throwable -> L32 Exception -> L34
        String r6 = r1.getString(r0);     // Catch: Throwable -> L32 Exception -> L34
        String r7 = r1.getString(r3);     // Catch: Throwable -> L32 Exception -> L34
        Configuration r8 = ActivityManagerSmt.getInstance().getConfiguration((ActivityManager) getSystemService("activity"));     // Catch: Throwable -> L32 Exception -> L34
        r4.setFileName(r6);     // Catch: Throwable -> L32 Exception -> L34
        if (checkNotShowList(Ringtone.access$4800(r4)) == true) goto L14;
        String r9 = getCNTitle(r6);     // Catch: Throwable -> L32 Exception -> L34
        if (r8.locale.toString().equals(Locale.TRADITIONAL_CHINESE.toString()) == false) goto L22;
        r9 = getTwTitle(r9);     // Catch: Throwable -> L32 Exception -> L34
        r7 = getTwArtist(r7);     // Catch: Throwable -> L32 Exception -> L34
    L24:
        r4.setTitle(r9);     // Catch: Throwable -> L32 Exception -> L34
        r4.setArtist(r7);     // Catch: Throwable -> L32 Exception -> L34
        if (r4.getUri().equals(mDefaultUri) == true) goto L26;
        this.mInternalRingtones.add(r4);     // Catch: Throwable -> L32 Exception -> L34
        goto L14
    L26:
        this.mInternalRingtones.add(0, r4);     // Catch: Throwable -> L32 Exception -> L34
        goto L14
    L22:
        if (r8.locale.toString().equals(Locale.SIMPLIFIED_CHINESE.toString()) == true) goto L24;
        r9 = getEnTitle(r9);     // Catch: Throwable -> L32 Exception -> L34
        r7 = getEnArtist(r7);     // Catch: Throwable -> L32 Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L32
        if (0 != 0) goto L37;
        return;
    L32:
        th = move-exception;
        if (0 == 0) goto L41;
        r1.close();
    L41:
        throw th;
    }

    private void sortInternalRingtones() {
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_ALARM) == true) goto L5;
        final String[] r0 = getResources().getStringArray(R.array.ringtone_file_name);
    L7:
        if (this.mInternalRingtones.isEmpty() == true) goto L9;
        Ringtone r1 = this.mInternalRingtones.remove(0);
    L10:
        Collections.sort(this.mInternalRingtones, new AnonymousClass12(this, r0));
        if (r1 == null) goto L14;
        this.mInternalRingtones.add(0, r1);
        return;
    L14:
        return;
    L9:
        r1 = null;
        goto L10
    L5:
        r0 = getResources().getStringArray(R.array.alarm_sort_ringtone_file_name);
        goto L7
    }

    private Ringtone updateExternalRingtonesWithUri(Uri r11) {
        Cursor r3 = null;
        if (isUseExternalRINGTONE() == true) goto L36;
        return null;
    L36:
        Cursor r2 = getContentResolver().query(r11, new String[]{"_id", "title"}, null, null, null);     // Catch: Throwable -> L20 Exception -> L22
        if (r2 != null) goto L33;
        if (r2 == null) goto L9;
        r2.close();
    L9:
        return null;
    L33:
        int r0 = r2.getColumnIndex("title");     // Catch: Exception -> L18 Throwable -> L28
        int r1 = r2.getColumnIndex("_id");     // Catch: Exception -> L18 Throwable -> L28
        Ringtone r4 = new Ringtone(this);     // Catch: Exception -> L18 Throwable -> L28
    L12:
        if (r2.moveToNext() == false) goto L15;
        r4.setId(r2.getInt(r1));     // Catch: Exception -> L18 Throwable -> L28
        r4.setTitle(r2.getString(r0));     // Catch: Exception -> L18 Throwable -> L28
        r4.setUri(r11);     // Catch: Exception -> L18 Throwable -> L28
        goto L12
    L15:
        if (r2 == null) goto L17;
        r2.close();
    L17:
        return r4;
    L18:
        e = e;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L28
        if (r2 == null) goto L27;
        r2.close();
    L27:
        return null;
    L28:
        th = th;
        r3 = r2;
    L30:
        if (r3 == null) goto L32;
        r3.close();
    L32:
        throw th;
    L22:
        e = e;
        r2 = null;
    L20:
        th = th;
        goto L30
    }

    private void updateExternalRingtonesAsync() {
        new AnonymousClass13(this).execute(new Integer[1]);
    }

    private String getSelectionFromType() {
        int r1 = this.mRingtoneType;
        if (r1 != 1) goto L7;
        return "is_ringtone = 1";
    L7:
        if (r1 != 2) goto L11;
        return "is_notification = 1";
    L11:
        if (r1 != 4) goto L14;
        return "is_alarm = 1";
    L14:
        return null;
    }

    private Uri transformUri(Uri r3) {
        if (r3 == null) goto L7;
        String r2 = r3.toString();
        if (r2.contains("external/audio") == false) goto L8;
        String[] r4 = r2.split(LibrarianImpl.Constants.SEPARATOR);
        r4[r4.length - 1] = "file";
        return Uri.parse(r2.toString());
    L8:
        return r3;
    L7:
        return r3;
    }

    private Uri transformUriTest(Uri r2) {
        if (r2 != null) goto L4;
        return r2;
    L4:
        return Uri.parse(r2.toString().replace("media", "0@media").replace("file", "audio/media").toString());
    }

    private boolean checkNotShowList(String r3) {
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_DEFAULT) == true) goto L5;
        return false;
    L5:
        return !Arrays.asList(getResources().getStringArray(R.array.notification_ringtone_file_name)).contains(r3);
    }

    private String getCNTitle(String r7) {
        String[] r0 = getResources().getStringArray(R.array.ringtone_title);
        String[] r1 = getResources().getStringArray(R.array.ringtone_file_name);
        int r3 = 0;
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_MMS) == false) goto L5;
    L20:
        r0 = getResources().getStringArray(R.array.mms_ringtone_title);
        r1 = getResources().getStringArray(R.array.mms_ringtone_file_name);
    L22:
        if (r3 >= r1.length) goto L28;
        if (r1[r3].equals(r7) == true) goto L25;
        r3 = r3 + 1;
        goto L22
    L25:
        OLog.d(TAG, "getCNTitle:" + r7 + " -> " + r0[r3]);
        return r0[r3];
    L28:
        OLog.d(TAG, "getCNTitle:" + r7);
        return r7;
    L5:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_MMS_SUB2) == true) goto L20;
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_DEFAULT) == false) goto L11;
        r0 = getResources().getStringArray(R.array.notification_ringtone_title);
        r1 = getResources().getStringArray(R.array.notification_ringtone_file_name);
        goto L22
    L11:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_ALARM) == false) goto L22;
        String[] r2 = getResources().getStringArray(R.array.alarm_ringtone_title);
        String[] r6 = getResources().getStringArray(R.array.alarm_ringtone_file_name);
        int r4 = 0;
    L14:
        if (r4 >= r6.length) goto L22;
        if (r6[r4].equals(r7) == true) goto L18;
        r4 = r4 + 1;
        goto L14
    L18:
        return r2[r4];
    }

    private String getEnTitle(String r7) {
        int r0 = getResources().getIdentifier("internal_ringtone_title", "array", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        int r1 = getResources().getIdentifier("internal_ringtone_title_en", "array", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        String[] r2 = getResources().getStringArray(r0);
        String[] r3 = getResources().getStringArray(r1);
        int r4 = 0;
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_MMS) == false) goto L5;
    L20:
        r3 = getResources().getStringArray(R.array.mms_ringtone_title);
        r2 = getResources().getStringArray(R.array.mms_ringtone_file_name);
    L22:
        if (r4 >= r2.length) goto L28;
        if (r2[r4].equals(r7) == true) goto L26;
        r4 = r4 + 1;
        goto L22
    L26:
        return r3[r4];
    L28:
        return r7;
    L5:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_MMS_SUB2) == true) goto L20;
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_DEFAULT) == false) goto L11;
        r3 = getResources().getStringArray(R.array.notification_ringtone_title);
        r2 = getResources().getStringArray(R.array.notification_ringtone_file_name);
        goto L22
    L11:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_ALARM) == false) goto L22;
        String[] r5 = getResources().getStringArray(R.array.alarm_ringtone_title);
        String[] r6 = getResources().getStringArray(R.array.alarm_ringtone_file_name);
        int r8 = 0;
    L14:
        if (r8 >= r6.length) goto L22;
        if (r6[r8].equals(r7) == true) goto L18;
        r8 = r8 + 1;
        goto L14
    L18:
        return r5[r8];
    }

    private String getEnArtist(String r6) {
        int r0 = getResources().getIdentifier("internal_ringtone_author", "array", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        int r1 = getResources().getIdentifier("internal_ringtone_author_en", "array", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        String[] r2 = getResources().getStringArray(r0);
        String[] r5 = getResources().getStringArray(r1);
        int r3 = 0;
    L4:
        if (r3 >= r2.length) goto L10;
        if (r2[r3].equals(r6) == true) goto L8;
        r3 = r3 + 1;
        goto L4
    L8:
        return r5[r3];
    L10:
        return r6;
    }

    private String getTwTitle(String r6) {
        int r0 = getResources().getIdentifier("internal_ringtone_title", "array", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        int r1 = getResources().getIdentifier("internal_ringtone_title_tw", "array", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        String[] r2 = getResources().getStringArray(r0);
        String[] r5 = getResources().getStringArray(r1);
        int r3 = 0;
    L4:
        if (r3 >= r2.length) goto L10;
        if (r2[r3].equals(r6) == true) goto L8;
        r3 = r3 + 1;
        goto L4
    L8:
        return r5[r3];
    L10:
        return r6;
    }

    private String getTwArtist(String r6) {
        int r0 = getResources().getIdentifier("internal_ringtone_author", "array", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        int r1 = getResources().getIdentifier("internal_ringtone_author_tw", "array", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        String[] r2 = getResources().getStringArray(r0);
        String[] r5 = getResources().getStringArray(r1);
        int r3 = 0;
    L4:
        if (r3 >= r2.length) goto L10;
        if (r2[r3].equals(r6) == true) goto L8;
        r3 = r3 + 1;
        goto L4
    L8:
        return r5[r3];
    L10:
        return r6;
    }

    private String getDefaultRingtoneTitle(String r3) {
        r3.hashCode();
        byte r1 = -1;
        switch(r3.hashCode()) {
            case -1236583518: goto L26;
            case -1078676816: goto L22;
            case 394569198: goto L18;
            case 672547131: goto L14;
            case 1349183189: goto L10;
            case 2072701486: goto L6;
            default: goto L29;
        };
    L29:
        switch(r1) {
            case 0: goto L37;
            case 1: goto L43;
            case 2: goto L42;
            case 3: goto L41;
            case 4: goto L40;
            case 5: goto L39;
            default: goto L38;
        };
    L38:
        return getString(R.string.ringtone_notification_default);
    L39:
        return getString(R.string.ringtone_mms_default_2);
    L40:
        return getString(R.string.ringtone_default_2);
    L41:
        return getString(R.string.ringtone_mms_default);
    L42:
        return getString(R.string.ringtone_alarm_default);
    L43:
        return getString(R.string.ringtone_calendar_default);
    L37:
        return getString(R.string.ringtone_default);
    L6:
        if (r3.equals("mms_ringtone_uri_2") == false) goto L29;
        r1 = 5;
        goto L29
    L10:
        if (r3.equals("ringtone_2") == false) goto L29;
        r1 = 4;
        goto L29
    L14:
        if (r3.equals("mms_ringtone_uri") == false) goto L29;
        r1 = 3;
        goto L29
    L18:
        if (r3.equals("alarm_alert") == false) goto L29;
        r1 = 2;
        goto L29
    L22:
        if (r3.equals("calendar_ringtone_uri") == false) goto L29;
        r1 = 1;
        goto L29
    L26:
        if (r3.equals("ringtone") == false) goto L29;
        r1 = 0;
        goto L29
    }

    private boolean isSub2ItemSameToSub1(String r4) {
        if (r4.equals(SoundSettingsFragment.TYPE_MMS_SUB2) == false) goto L10;
        if (android.provider.Settings.System.getInt(getContentResolver(), "mms_sub2_ringtone_sameto_sub1", 0) != 1) goto L8;
        return true;
    L8:
        return false;
    L10:
        if (r4.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == true) goto L12;
        return false;
    L12:
        if (android.provider.Settings.System.getInt(getContentResolver(), "sub2_ringtone_sameto_sub1", 0) != 1) goto L15;
        return true;
    L15:
        return false;
    }

    private void notifyDataSetChanged() {
        this.mOCardListItems.clear();
        this.mAdapter.notifyDataSetChanged();
    }

    private void updateCardListItemCheckedMode() {
        this.mOCardListItems.forEach(new RingtoneSettingsFragment$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: renamed from: lambda$updateCardListItemCheckedMode$1$com-android-settings-RingtoneSettingsFragment, reason: not valid java name */
    /* synthetic */ void m197x3cefdee1(OCardListItem r2) {
        if (((Integer) r2.getTag()).intValue() != this.mClickedPos) goto L5;
        boolean r1 = true;
    L6:
        r2.showCustomEnd(r1);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private void updatePlayRingtoneAnimation() {
        this.mOCardListItems.forEach(new RingtoneSettingsFragment$$ExternalSyntheticLambda2(this));
    }

    /* JADX INFO: renamed from: lambda$updatePlayRingtoneAnimation$2$com-android-settings-RingtoneSettingsFragment, reason: not valid java name */
    /* synthetic */ void m198x4d81bfa7(OCardListItem r3) {
        int r0 = ((Integer) r3.getTag()).intValue();
        if (this.mClickedPos == r0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        playRingtoneAnimation(r1, r3);
        return;
    L5:
        if (this.mIsMediaPlaying == false) goto L7;
        r1 = true;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mManagedProfileReceiver);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_RingtoneSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(RingtoneSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_RingtoneSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_RingtoneSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(RingtoneSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_RingtoneSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_RingtoneSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(RingtoneSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_RingtoneSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
