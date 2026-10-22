package com.android.settings.deviceinfo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.os.Environment;
import android.os.Handler;
import android.os.UserManager;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.SpannableString;
import android.text.format.Formatter;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.preference.Preference;
import com.android.settings.R;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.utils.HanziToPinyin;
import com.obric.olog.OLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class StorageVolumeView extends LinearLayout {
    private static final long APP_ITEM_DEFAULT_WIDTH = 12;
    public static final String KEY_CACHE = "cache";
    private static final int MSG_UI_UPDATE_APP = 6;
    private static final int MSG_UI_UPDATE_APPROXIMATE = 1;
    private static final int MSG_UI_UPDATE_AUDIO = 5;
    private static final int MSG_UI_UPDATE_DETAILS = 2;
    private static final int MSG_UI_UPDATE_MEDIA = 3;
    private static final int MSG_UI_UPDATE_USER = 4;
    private static final int ORDER_STORAGE_LOW = -1;
    private static final int ORDER_USAGE_BAR = -2;
    private static final String TAG = "StorageVolumeView";
    private TextView mApps;
    private TextView mAvailable;
    private final View.OnClickListener mClickListener;
    private Context mContext;
    private float mCountSize;
    private Map<Integer, Integer> mCurrSizeMap;
    private TextView mDcim;
    private TextView mDownloads;
    private SettingItemText mFileStorageDetail;
    private StorageMeasurement.MeasurementDetails mLastDetail;
    private StorageMeasurement mMeasure;
    private TextView mMsic;
    private TextView mMusic;
    private StorageProgressBarItem mPerApps;
    private StorageProgressBarItem mPerDownload;
    private StorageProgressBarItem mPerMusic;
    private StorageProgressBarItem mPerOther;
    private StorageProgressBarItem mPerPic;
    private StorageProgressBarItem mPerSystem;
    private LinearLayout mProgressBar;
    private int mProgressBarWidth;
    private StorageMeasurement.MeasurementReceiver mReceiver;
    private Resources mResources;
    private StorageSizeInfo mSizeInfo;
    private StorageManager mStorageManager;
    private TextView mSystem;
    private TextView mTotal;
    private Handler mUpdateHandler;
    private boolean mUsbConnected;
    private String mUsbFunction;
    private View mUsed;
    private UserManager mUserManager;
    private StorageVolume mVolume;

    static class StorageSizeInfo {
        long mAppSize;
        long mAvailableSize;
        long mCacheSize;
        long mDownloadsSize;
        long mMusicSize;
        long mOtherSize;
        long mPicSize;
        long mTotalSize;

        StorageSizeInfo() {
        }
    }

    static /* synthetic */ void access$000(StorageVolumeView r0, StorageMeasurement.MeasurementDetails r1) {
        r0.updateMediaPreference(r1);
    }

    static /* synthetic */ long access$100(StorageVolumeView r0, StorageMeasurement.MeasurementDetails r1) {
        return r0.updateAudioPreference(r1);
    }

    static /* synthetic */ void access$200(StorageVolumeView r0, StorageMeasurement.MeasurementDetails r1) {
        r0.updateAppPreference(r1);
    }

    static /* synthetic */ Handler access$300(StorageVolumeView r0) {
        return r0.mUpdateHandler;
    }

    static /* synthetic */ Context access$400(StorageVolumeView r0) {
        return r0.mContext;
    }

    public StorageVolumeView(Context r2) {
        this(r2, null);
    }

    public StorageVolumeView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public StorageVolumeView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mProgressBarWidth = 0;
        this.mCountSize = 0.0f;
        this.mCurrSizeMap = new HashMap();
        this.mUpdateHandler = new AnonymousClass1(this);
        this.mReceiver = new AnonymousClass2(this);
        this.mClickListener = new AnonymousClass3(this);
        init(r1, null);
    }

    private void init(Context r1, StorageVolume r2) {
        this.mVolume = r2;
        this.mMeasure = StorageMeasurement.getInstance(r1, r2);
        this.mContext = r1;
        this.mResources = r1.getResources();
        this.mStorageManager = StorageManager.from(r1);
        this.mUserManager = (UserManager) r1.getSystemService(PickApplicationActivity.EXTRA_USER);
    }

    public StorageVolume getStorageVolume() {
        return this.mVolume;
    }

    public void updateApproximate(long r5, long r7) {
        String r0 = formatSize(r5);
        Pattern r1 = Pattern.compile("(\\d+(\\.\\d+)?)");
        Matcher r2 = r1.matcher(r0);
        if (r2.find() == false) goto L5;
        this.mTotal.setText(formatStyle(r0, r2), TextView.BufferType.SPANNABLE);
    L6:
        String r3 = formatSize(r7);
        Matcher r4 = r1.matcher(r3);
        if (r4.find() == false) goto L9;
        this.mAvailable.setText(formatStyle(r3, r4), TextView.BufferType.SPANNABLE);
    L10:
        int r6 = (this.mProgressBar.getWidth() - this.mProgressBar.getPaddingRight()) - this.mProgressBar.getPaddingLeft();
        this.mProgressBarWidth = r6;
        this.mCountSize = r6 / r5;
        updateProView(this.mUsed, r5 - r7);
        return;
    L9:
        this.mAvailable.setText(r3);
        goto L10
    L5:
        this.mTotal.setText(r0);
        goto L6
    }

    private static long totalValues(HashMap<String, Long> r6, String... r7) {
        int r0 = r7.length;
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L8;
        String r4 = r7[r3];
        if (r6.containsKey(r4) == false) goto L7;
        r1 = r1 + r6.get(r4).longValue();
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        return r1;
    }

    public void updateDetails(StorageMeasurement.MeasurementDetails r22) {
        this.mLastDetail = r22;
        StorageVolume r2 = this.mVolume;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        return;
    L11:
        long r5 = r22.totalSize;
        long r7 = r22.availSize;
        long r9 = r22.appsSize;
        long r11 = r22.audioSizeSumInDb;
        String r4 = formatSize(r5);
        Pattern r13 = Pattern.compile("(\\d+(\\.\\d+)?)");
        Matcher r14 = r13.matcher(r4);
        if (r14.find() == false) goto L14;
        this.mTotal.setText(formatStyle(r4, r14), TextView.BufferType.SPANNABLE);
    L15:
        String r6 = formatSize(r7);
        Matcher r15 = r13.matcher(r6);
        if (r15.find() == false) goto L18;
        this.mAvailable.setText(formatStyle(r6, r15), TextView.BufferType.SPANNABLE);
    L19:
        this.mApps.setText(formatSize(r9));
        long r16 = totalValues(r22.mediaSize, new String[]{Environment.DIRECTORY_DCIM, Environment.DIRECTORY_MOVIES, Environment.DIRECTORY_PICTURES});
        this.mDcim.setText(formatSize(r16));
        this.mMusic.setText(formatSize(r11));
        long r8 = totalValues(r22.mediaSize, new String[]{Environment.DIRECTORY_DOWNLOADS});
        this.mDownloads.setText(formatSize(r8));
        long r10 = (((((r22.totalSize - r22.availSize) - r22.appsSize) - r22.systemSize) - r16) - r11) - r8;
        OLog.d(TAG, "details.totalSize " + r22.totalSize + ", availSize " + r22.availSize + ", otherFileSize " + r22.otherFileSize + ", appSize " + r22.appsSize + ", mediaSize " + r22.mediaSize + ", dcimSize " + r16 + ", musicSize " + r11 + ", downloadsSize " + r8);
        long r12 = Math.max(r22.otherFileSize - r8, 0);
        this.mMsic.setText(formatSize(r12));
        updateProView(this.mPerApps, r9);
        updateProView(this.mPerPic, r16);
        updateProView(this.mPerMusic, r11);
        updateProView(this.mPerDownload, r8);
        updateProView(this.mPerOther, r12);
        long r17 = r10 - r12;
        this.mSystem.setText(formatSize(r17));
        updateProView(this.mPerSystem, r17);
        StorageSizeInfo r1 = new StorageSizeInfo();
        this.mSizeInfo = r1;
        r1.mTotalSize = r5;
        this.mSizeInfo.mAvailableSize = r7;
        this.mSizeInfo.mAppSize = r9;
        this.mSizeInfo.mPicSize = r16;
        this.mSizeInfo.mMusicSize = r11;
        this.mSizeInfo.mDownloadsSize = r8;
        this.mSizeInfo.mCacheSize = 0;
        this.mSizeInfo.mOtherSize = r10;
        return;
    L18:
        this.mAvailable.setText(r6);
        goto L19
    L14:
        this.mTotal.setText(r4);
        goto L15
    L5:
        if (r2.isPrimary() == true) goto L8;
        r3 = false;
        goto L9
    }

    StorageSizeInfo getStorageSizeInfo() {
        return this.mSizeInfo;
    }

    private void updateMediaPreference(StorageMeasurement.MeasurementDetails r7) {
        long r0 = totalValues(r7.mediaSize, new String[]{Environment.DIRECTORY_DCIM, Environment.DIRECTORY_MOVIES, Environment.DIRECTORY_PICTURES});
        this.mDcim.setText(formatSize(r0));
        updateProView(this.mPerPic, r0);
        long r1 = totalValues(r7.mediaSize, new String[]{Environment.DIRECTORY_DOWNLOADS});
        this.mDownloads.setText(formatSize(r1));
        updateProView(this.mPerDownload, r1);
    }

    private long updateAudioPreference(StorageMeasurement.MeasurementDetails r4) {
        long r0 = r4.audioSizeSumInDb;
        this.mMusic.setText(formatSize(r0));
        updateProView(this.mPerMusic, r0);
        return r0;
    }

    private void updateAppPreference(StorageMeasurement.MeasurementDetails r4) {
        this.mApps.setText(formatSize(r4.appsSize));
        updateProView(this.mPerApps, r4.appsSize);
    }

    private void measure() {
        this.mMeasure.invalidate();
        this.mMeasure.measure();
    }

    public void onResume() {
        this.mCurrSizeMap.clear();
        this.mMeasure.setReceiver(this.mReceiver);
        measure();
    }

    public void onStorageStateChanged() {
        measure();
    }

    public void onUsbStateChanged(boolean r1, String r2) {
        this.mUsbConnected = r1;
        this.mUsbFunction = r2;
        measure();
    }

    public void onMediaScannerFinished() {
        measure();
    }

    public void onCacheCleared() {
        measure();
    }

    public void onPause() {
        this.mMeasure.cleanUp();
    }

    private String formatSize(long r1) {
        return Formatter.formatFileSize(getContext(), r1).replace('k', 'K');
    }

    private SpannableString formatStyle(String r7, Matcher r8) {
        int r9 = r8.group(1).length();
        if (r7.contains(HanziToPinyin.Token.SEPARATOR) == true) goto L5;
        String r2 = r7.substring(0, r9);
        r7 = r7.replace(r2, r2 + HanziToPinyin.Token.SEPARATOR);
    L5:
        SpannableString r1 = new SpannableString(r7);
        r1.setSpan(new TextAppearanceSpan(this.mContext, R.style.TotalSizeStyle), 0, r9, 33);
        r1.setSpan(new TextAppearanceSpan(this.mContext, R.style.UnitStyle), r9 + 1, r7.length(), 33);
        return r1;
    }

    public Intent intentForClick(Preference r1) {
        r1.getKey();
        return null;
    }

    private List<UserInfo> getUsersExcluding(UserInfo r4) {
        List<UserInfo> r3 = this.mUserManager.getUsers();
        Iterator<UserInfo> r0 = r3.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r0.next().id != r4.id) goto L4;
        r0.remove();
        goto L4
    L8:
        return r3;
    }

    public void initView() {
        this.mTotal = (TextView) findViewById(R.id.total_size);
        this.mAvailable = (TextView) findViewById(R.id.tv_free_size);
        this.mApps = (TextView) findViewById(R.id.tv_app_size);
        this.mDcim = (TextView) findViewById(R.id.tv_pic_size);
        this.mMusic = (TextView) findViewById(R.id.tv_music_size);
        this.mDownloads = (TextView) findViewById(R.id.tv_download_size);
        this.mSystem = (TextView) findViewById(R.id.tv_system_size);
        this.mMsic = (TextView) findViewById(R.id.tv_other_size);
        this.mProgressBar = (LinearLayout) findViewById(R.id.ll_progressbar);
        StorageProgressBarItem r0 = (StorageProgressBarItem) findViewById(R.id.view_app);
        this.mPerApps = r0;
        r0.setRateBackgroundId(R.drawable.memory_manage_green_left);
        updateProView(this.mPerApps, APP_ITEM_DEFAULT_WIDTH);
        StorageProgressBarItem r1 = (StorageProgressBarItem) findViewById(R.id.view_pic);
        this.mPerPic = r1;
        r1.setRateBackgroundId(R.drawable.memory_manage_yellow_mid);
        StorageProgressBarItem r2 = (StorageProgressBarItem) findViewById(R.id.view_music);
        this.mPerMusic = r2;
        r2.setRateBackgroundId(R.drawable.memory_manage_red_mid);
        StorageProgressBarItem r3 = (StorageProgressBarItem) findViewById(R.id.view_download);
        this.mPerDownload = r3;
        r3.setRateBackgroundId(R.drawable.memory_manage_purple_mid);
        StorageProgressBarItem r4 = (StorageProgressBarItem) findViewById(R.id.view_cache);
        this.mPerSystem = r4;
        r4.setRateBackgroundId(R.drawable.memory_manage_blue_mid);
        StorageProgressBarItem r5 = (StorageProgressBarItem) findViewById(R.id.view_other);
        this.mPerOther = r5;
        r5.setRateBackgroundId(R.drawable.memory_manage_white_right);
        this.mUsed = findViewById(R.id.view_used);
        SettingItemText r6 = (SettingItemText) findViewById(R.id.file_storage_detail);
        this.mFileStorageDetail = r6;
        r6.setOnClickListener(this.mClickListener);
    }

    private void updateProView(View r3, long r4) {
        if (r3.getId() != R.id.view_used) goto L5;
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) r3.getLayoutParams();
        r0.width = (int) (r4 * this.mCountSize);
        r3.setLayoutParams(r0);
        return;
    L5:
        int r5 = (int) (r4 * this.mCountSize);
        if (r5 != 0) goto L8;
    L10:
        this.mCurrSizeMap.put(Integer.valueOf(r3.getId()), Integer.valueOf(r5));
        r3.setVisibility(0);
        if (((LinearLayout.LayoutParams) r3.getLayoutParams()).width == r5) goto L15;
        ((StorageProgressBarItem) r3).setRateWidth(r5);
        return;
    L15:
        return;
    L8:
        if (r5 >= 4) goto L10;
        r5 = 4;
        goto L10
    }
}
