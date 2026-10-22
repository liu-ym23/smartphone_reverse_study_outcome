package com.bytedanceos.storage;

import android.content.Context;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.os.Environment;
import android.os.Handler;
import android.os.UserManager;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedanceos.oui.MultiSegmentProgressBar;
import com.bytedanceos.utils.ByteConverter;
import com.bytedanceos.utils.ByteUnitPair;
import com.obric.olog.OLog;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class StorageVolumeView extends LinearLayout {
    public static final String KEY_CACHE = "cache";
    private static final int MSG_UI_UPDATE_APP = 6;
    private static final int MSG_UI_UPDATE_APPROXIMATE = 1;
    private static final int MSG_UI_UPDATE_AUDIO = 5;
    private static final int MSG_UI_UPDATE_DETAILS = 2;
    private static final int MSG_UI_UPDATE_MEDIA = 3;
    private static final int MSG_UI_UPDATE_OTHER_FILE = 7;
    private static final int MSG_UI_UPDATE_USER = 4;
    private static final int ORDER_STORAGE_LOW = -1;
    private static final int ORDER_USAGE_BAR = -2;
    private static final String TAG = "StorageVolumeView";
    private boolean isInit;
    private TextView mApps;
    private Context mContext;
    private float mCountSize;
    private Map<Integer, Integer> mCurrSizeMap;
    private TextView mDcim;
    private boolean mDetailsStarted;
    private StorageMeasurement.MeasurementDetails mLastDetail;
    private StorageMeasurement mMeasure;
    private TextView mMusic;
    private MultiSegmentProgressBar mProgressBar;
    private int mProgressBarWidth;
    private boolean mProgressInitialized;
    private StorageMeasurement.MeasurementReceiver mReceiver;
    private Resources mResources;
    private StorageSizeInfo mSizeInfo;
    private StorageManager mStorageManager;
    private TextView mSystem;
    private TextView mTotal;
    private Handler mUpdateHandler;
    private boolean mUsbConnected;
    private String mUsbFunction;
    private TextView mUsedText;
    private TextView mUsedUnitText;
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

    public float getGbFromMb(float data) {
        return data / 1000.0f;
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

    public StorageVolumeView(Context context) {
        this(context, null);
    }

    public StorageVolumeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StorageVolumeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mProgressBarWidth = 0;
        this.mCountSize = 0.0f;
        this.mCurrSizeMap = new HashMap();
        this.isInit = false;
        this.mProgressInitialized = false;
        this.mDetailsStarted = false;
        this.mUpdateHandler = new AnonymousClass1(this);
        this.mReceiver = new AnonymousClass2(this);
    }

    public void init(Context context, StorageVolume volume) {
        if (this.isInit == false) goto L5;
        return;
    L5:
        this.isInit = true;
        this.mVolume = volume;
        StorageMeasurement r3 = StorageMeasurement.getInstance(context, volume);
        this.mMeasure = r3;
        r3.setMeasureDetail(true);
        this.mContext = context;
        this.mResources = context.getResources();
        this.mStorageManager = StorageManager.from(context);
        this.mUserManager = (UserManager) context.getSystemService("user");
    }

    public StorageVolume getStorageVolume() {
        return this.mVolume;
    }

    public void updateApproximate(long totalSize, long availSize) {
        if (totalSize >= availSize) goto L5;
        totalSize = availSize;
    L5:
        ByteUnitPair r0 = ByteConverter.convertGB(totalSize, 1000, 1);
        this.mTotal.setText(getContext().getString(R.string.total) + r0.getValue() + r0.getUnit());
        long r1 = parseData(r0.getValue(), r0.getUnit());
        ByteUnitPair r4 = ByteConverter.convertGB(availSize, 1000, 1);
        long r5 = parseData(r4.getValue(), r4.getUnit());
        ByteUnitPair r8 = ByteConverter.convertGB(totalSize - availSize, 1000, 1);
        this.mUsedText.setText(r8.getValue());
        this.mUsedUnitText.setText(r8.getUnit());
        if (r1 >= 1) goto L8;
        return;
    L8:
        float r9 = (r5 * 100.0f) / r1;
        if (r9 < 1.0f) goto L11;
        String r2 = ((int) Math.floor(r9)) + "";
    L13:
        if (this.mProgressInitialized == true) goto L16;
        this.mProgressInitialized = true;
        return;
    L16:
        return;
    L11:
        String.format("%.2f", new Object[]{Float.valueOf(r9)});
        goto L13
    }

    private static long totalValues(HashMap<String, Long> map, String... keys) {
        int r0 = keys.length;
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L8;
        String r4 = keys[r3];
        if (map.containsKey(r4) == false) goto L7;
        r1 = r1 + map.get(r4).longValue();
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        return r1;
    }

    public void updateDetails(StorageMeasurement.MeasurementDetails details) {
        this.mLastDetail = details;
        this.mDetailsStarted = true;
        StorageVolume r2 = this.mVolume;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        return;
    L11:
        long r4 = details.totalSize;
        long r12 = details.availSize;
        long r14 = details.appsSize;
        long r9 = details.audioSizeSumInDb;
        if (r4 >= r12) goto L14;
        long r7 = r12;
    L15:
        ByteUnitPair r5 = ByteConverter.convert(r7, "B", 1000);
        this.mTotal.setText(getContext().getString(R.string.total) + r5.getValue() + r5.getUnit());
        ByteConverter.convertGB(r12, 1000, 1);
        ByteUnitPair r1 = ByteConverter.convertGB(r7 - r12, 1000, 1);
        this.mUsedText.setText(r1.getValue());
        this.mUsedUnitText.setText(r1.getUnit());
        float r6 = (r12 * 100.0f) / r7;
        if (r6 < 1.0f) goto L18;
        String r0 = ((int) Math.floor(r6)) + "";
    L19:
        ByteUnitPair r8 = ByteConverter.convert(r14, "B", 1000);
        this.mApps.setText(r8.getValue() + r8.getUnit());
        long r10 = totalValues(details.mediaSize, new String[]{Environment.DIRECTORY_DCIM, Environment.DIRECTORY_MOVIES, Environment.DIRECTORY_PICTURES});
        ByteUnitPair r11 = ByteConverter.convert(r10, "B", 1000);
        this.mDcim.setText(r11.getValue() + r11.getUnit());
        ByteUnitPair r13 = ByteConverter.convert(r9, "B", 1000);
        this.mMusic.setText(r13.getValue() + r13.getUnit());
        long r15 = ((((details.totalSize - details.availSize) - details.appsSize) - details.systemSize) - r10) - r9;
        if (details.mediaSize == null) goto L22;
        int r16 = details.mediaSize.size();
    L23:
        OLog.d(TAG, "details.totalSize " + details.totalSize + ", availSize " + details.availSize + ", otherFileSize " + details.otherFileSize + ", appSize " + details.appsSize + ", mediaSize.count " + r16 + ", dcimSize " + r10 + ", musicSize " + r9);
        updateProgressDetails(r7, r14, r10, r9, r15);
        ByteUnitPair r17 = ByteConverter.convert(r15, "B", 1000);
        this.mSystem.setText(r17.getValue() + r17.getUnit());
        StorageSizeInfo r18 = new StorageSizeInfo();
        this.mSizeInfo = r18;
        r18.mTotalSize = r7;
        this.mSizeInfo.mAvailableSize = r12;
        this.mSizeInfo.mAppSize = r14;
        this.mSizeInfo.mPicSize = r10;
        this.mSizeInfo.mMusicSize = r9;
        this.mSizeInfo.mCacheSize = 0;
        this.mSizeInfo.mOtherSize = r15;
        return;
    L22:
        r16 = -1;
        goto L23
    L18:
        String.format("%.2f", new Object[]{Float.valueOf(r6)});
        goto L19
    L14:
        r7 = r4;
        goto L15
    L5:
        if (r2.isPrimary() == true) goto L8;
        r3 = false;
        goto L9
    }

    public long parseData(String data, String unit) {
        if (TextUtils.isEmpty(data) == false) goto L5;
    L23:
        return 0;
    L5:
        if (TextUtils.isEmpty(unit) == true) goto L23;
        String r3 = unit.trim().toUpperCase();
        if (TextUtils.equals("TB", r3) == false) goto L15;
        float r4 = Float.parseFloat(data);
        float r5 = 1000;
        float r6 = r4 * r5;
    L10:
        float r7 = r6 * r5;
    L11:
        float r8 = r7 * r5;
    L13:
        return (long) (r8 * r5);
    L15:
        if (TextUtils.equals("GB", r3) == false) goto L18;
        r6 = Float.parseFloat(data);
        r5 = 1000;
        goto L10
    L18:
        if (TextUtils.equals("MB", r3) == false) goto L21;
        r7 = Float.parseFloat(data);
        r5 = 1000;
        goto L11
    L21:
        if (TextUtils.equals("KB", r3) == false) goto L23;
        r8 = Float.parseFloat(data);
        r5 = 1000;
        goto L13
    }

    StorageSizeInfo getStorageSizeInfo() {
        return this.mSizeInfo;
    }

    private void updateMediaPreference(StorageMeasurement.MeasurementDetails details) {
        long r8 = totalValues(details.mediaSize, new String[]{Environment.DIRECTORY_DCIM, Environment.DIRECTORY_MOVIES, Environment.DIRECTORY_PICTURES});
        this.mDcim.setText(formatSize(r8));
        StorageMeasurement.MeasurementDetails r15 = this.mLastDetail;
        long r0 = 0;
        if (r15 == null) goto L5;
        long r4 = r15.totalSize;
    L6:
        StorageMeasurement.MeasurementDetails r16 = this.mLastDetail;
        if (r16 == null) goto L9;
        long r6 = r16.appsSize;
    L10:
        StorageMeasurement.MeasurementDetails r17 = this.mLastDetail;
        if (r17 == null) goto L13;
        r0 = r17.audioSizeSumInDb;
    L13:
        updateProgressDetails(r4, r6, r8, r0, computeMisc(this.mLastDetail));
        return;
    L9:
        r6 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    private long updateAudioPreference(StorageMeasurement.MeasurementDetails details) {
        long r11 = details.audioSizeSumInDb;
        this.mMusic.setText(formatSize(r11));
        StorageMeasurement.MeasurementDetails r0 = this.mLastDetail;
        if (r0 == null) goto L5;
        long r3 = r0.totalSize;
    L6:
        StorageMeasurement.MeasurementDetails r1 = this.mLastDetail;
        if (r1 == null) goto L9;
        long r5 = r1.appsSize;
    L11:
        if (this.mLastDetail == null) goto L13;
        long r7 = totalValues(details.mediaSize, new String[]{Environment.DIRECTORY_DCIM, Environment.DIRECTORY_MOVIES, Environment.DIRECTORY_PICTURES});
    L14:
        updateProgressDetails(r3, r5, r7, r11, computeMisc(this.mLastDetail));
        return r11;
    L13:
        r7 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L11
    L5:
        r3 = 0;
        goto L6
    }

    private void updateAppPreference(StorageMeasurement.MeasurementDetails details) {
        this.mApps.setText(formatSize(details.appsSize));
        if (this.mDetailsStarted == true) goto L5;
        return;
    L5:
        StorageMeasurement.MeasurementDetails r2 = this.mLastDetail;
        if (r2 == null) goto L8;
        long r5 = r2.totalSize;
    L9:
        long r7 = details.appsSize;
        if (this.mLastDetail == null) goto L12;
        long r9 = totalValues(details.mediaSize, new String[]{Environment.DIRECTORY_DCIM, Environment.DIRECTORY_MOVIES, Environment.DIRECTORY_PICTURES});
    L14:
        if (this.mLastDetail == null) goto L16;
        long r11 = details.audioSizeSumInDb;
    L17:
        updateProgressDetails(r5, r7, r9, r11, computeMisc(this.mLastDetail));
        return;
    L16:
        r11 = 0;
        goto L17
    L12:
        r9 = 0;
        goto L14
    L8:
        r5 = 0;
        goto L9
    }

    private long computeMisc(StorageMeasurement.MeasurementDetails details) {
        if (details != null) goto L5;
        return 0;
    L5:
        long r0 = totalValues(details.mediaSize, new String[]{Environment.DIRECTORY_DCIM, Environment.DIRECTORY_MOVIES, Environment.DIRECTORY_PICTURES});
        return ((((details.totalSize - details.availSize) - details.appsSize) - details.systemSize) - r0) - details.audioSizeSumInDb;
    }

    private void updateProgressDetails(long total, long app, long dcim, long music, long misc) {
        if (this.mProgressBar != null) goto L5;
        return;
    L5:
        if (total <= 0) goto L72;
        float r13 = getResources().getDisplayMetrics().density * 6.0f;
        boolean r16 = false;
        float[] r15 = {r13, r13, 0.0f, 0.0f, 0.0f, 0.0f, r13, r13};
        float[] r14 = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        if (app <= 0) goto L10;
        float r3 = app / total;
    L12:
        if (dcim <= 0) goto L14;
        float r4 = dcim / total;
    L16:
        if (music <= 0) goto L18;
        float r5 = music / total;
    L20:
        if (misc <= 0) goto L22;
        float r6 = misc / total;
    L23:
        ArrayList r1 = new ArrayList();
        int r2 = getResources().getColor(R.color.oui_accent_7_fg);
        int r7 = getResources().getColor(R.color.oui_functional_yellow_7);
        int r8 = getResources().getColor(R.color.oui_functional_red_7);
        int r9 = getResources().getColor(R.color.oui_functional_graphite_6);
        if (r3 <= 0.02f) goto L28;
        r1.add(new MultiSegmentProgressBar.Segment(r2, r3, r15));
    L26:
        r16 = true;
    L31:
        if (r4 <= 0.02f) goto L39;
        if (r16 == false) goto L35;
        float[] r10 = r14;
    L36:
        r1.add(new MultiSegmentProgressBar.Segment(r7, r4, r10));
    L37:
        r16 = true;
    L46:
        if (r5 <= 0.02f) goto L53;
        if (r16 == false) goto L50;
        float[] r11 = r14;
    L51:
        r1.add(new MultiSegmentProgressBar.Segment(r8, r5, r11));
    L60:
        if (r6 <= 0.02f) goto L67;
        if (r1.isEmpty() == true) goto L65;
        r15 = r14;
    L65:
        r1.add(new MultiSegmentProgressBar.Segment(r9, r6, r15));
    L69:
        this.mProgressBar.setSegments(r1);
        return;
    L67:
        if (r1.isEmpty() == true) goto L69;
        MultiSegmentProgressBar.Segment r12 = (MultiSegmentProgressBar.Segment) r1.get(r1.size() - 1);
        r1.set(r1.size() - 1, new MultiSegmentProgressBar.Segment(r12.getColor(), r12.getPercent(), r14));
        goto L69
    L50:
        r11 = r15;
        goto L51
    L53:
        if (r5 <= 0.0f) goto L60;
        if (r16 == false) goto L57;
        float[] r17 = r14;
    L58:
        r1.add(new MultiSegmentProgressBar.Segment(r8, 0.02f, r17));
        goto L60
    L57:
        r17 = r15;
        goto L58
    L35:
        r10 = r15;
        goto L36
    L39:
        if (r4 <= 0.0f) goto L46;
        if (r16 == false) goto L43;
        float[] r18 = r14;
    L44:
        r1.add(new MultiSegmentProgressBar.Segment(r7, 0.02f, r18));
        goto L37
    L43:
        r18 = r15;
        goto L44
    L28:
        if (r3 <= 0.0f) goto L31;
        r1.add(new MultiSegmentProgressBar.Segment(r2, 0.02f, r15));
        goto L26
    L22:
        r6 = 0.0f;
        goto L23
    L18:
        r5 = 0.0f;
        goto L20
    L14:
        r4 = 0.0f;
        goto L16
    L10:
        r3 = 0.0f;
        goto L12
    }

    private void measure() {
        this.mMeasure.setMeasureDetail(true);
        this.mMeasure.invalidate();
        this.mMeasure.measure();
    }

    public void onResume() {
        this.mCurrSizeMap.clear();
        this.mProgressInitialized = false;
        this.mDetailsStarted = false;
        this.mMeasure.setReceiver(this.mReceiver);
        measure();
    }

    public void onStorageStateChanged() {
        measure();
    }

    public void onUsbStateChanged(boolean isUsbConnected, String usbFunction) {
        this.mUsbConnected = isUsbConnected;
        this.mUsbFunction = usbFunction;
        measure();
    }

    public void onMediaScannerFinished() {
        measure();
    }

    public void onCacheCleared() {
        measure();
    }

    public void onPause() {
        this.mMeasure.resetReciver();
    }

    private String formatSize(long size) {
        ByteUnitPair r1 = ByteConverter.convert(size, "B", 1000);
        return r1.getValue() + r1.getUnit();
    }

    public String[] spliteSizeStr(String str) {
        if (str != null) goto L5;
        return null;
    L5:
        String r4 = str.replaceAll(" ", "");
        Matcher r5 = Pattern.compile("(\\d+(\\.\\d+)?)").matcher(r4);
        String[] r0 = {"", ""};
        if (r5.find() == false) goto L8;
        int r6 = r5.group(1).length();
        r0[0] = r4.substring(0, r6);
        r0[1] = r4.substring(r6, r4.length());
    L8:
        return r0;
    }

    private SpannableString formatStyle(String str, Matcher matcher) {
        int r8 = matcher.group(1).length();
        if (str.contains(" ") == true) goto L5;
        String r2 = str.substring(0, r8);
        str = str.replace(r2, r2 + " ");
    L5:
        SpannableString r1 = new SpannableString(str);
        r1.setSpan(new TextAppearanceSpan(this.mContext, R.style.TotalSizeStyle), 0, r8, 33);
        r1.setSpan(new TextAppearanceSpan(this.mContext, R.style.UnitStyle), r8 + 1, str.length(), 33);
        return r1;
    }

    private List<UserInfo> getUsersExcluding(UserInfo excluding) {
        List<UserInfo> r3 = this.mUserManager.getUsers();
        Iterator<UserInfo> r0 = r3.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r0.next().id != excluding.id) goto L4;
        r0.remove();
        goto L4
    L8:
        return r3;
    }

    public void initView() {
        this.mTotal = (TextView) findViewById(R.id.tv_detail);
        this.mUsedText = (TextView) findViewById(R.id.scanning_size);
        this.mUsedUnitText = (TextView) findViewById(R.id.tv_used_unit);
        this.mApps = (TextView) findViewById(R.id.tv_app_size);
        this.mDcim = (TextView) findViewById(R.id.tv_pic_size);
        this.mMusic = (TextView) findViewById(R.id.tv_music_size);
        this.mSystem = (TextView) findViewById(R.id.tv_system_size);
        MultiSegmentProgressBar r0 = (MultiSegmentProgressBar) findViewById(R.id.storage_progress);
        this.mProgressBar = r0;
        r0.setUseSegmentGap(true);
        this.mProgressBar.setSegmentGap(2.0f);
        this.mProgressBar.setAnimateSmallProgressBar(false);
    }
}
