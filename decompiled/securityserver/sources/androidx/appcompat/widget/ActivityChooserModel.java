package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
class ActivityChooserModel extends DataSetObservable {
    static final String ATTRIBUTE_ACTIVITY = "activity";
    static final String ATTRIBUTE_TIME = "time";
    static final String ATTRIBUTE_WEIGHT = "weight";
    static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = -1;
    static final String LOG_TAG = "ActivityChooserModel";
    static final String TAG_HISTORICAL_RECORD = "historical-record";
    static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private static final Map<String, ActivityChooserModel> sDataModelRegistry = null;
    private static final Object sRegistryLock = null;
    private final List<ActivityResolveInfo> mActivities;
    private OnChooseActivityListener mActivityChoserModelPolicy;
    private ActivitySorter mActivitySorter;
    boolean mCanReadHistoricalData;
    final Context mContext;
    private final List<HistoricalRecord> mHistoricalRecords;
    private boolean mHistoricalRecordsChanged;
    final String mHistoryFileName;
    private int mHistoryMaxSize;
    private final Object mInstanceLock;
    private Intent mIntent;
    private boolean mReadShareHistoryCalled;
    private boolean mReloadActivities;

    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel r1);
    }

    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo r1) {
            this.resolveInfo = r1;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ActivityResolveInfo r1) {
            return compareTo2(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            if (ActivityResolveInfo.class == r5.getClass()) goto L12;
            return false;
        L12:
            if (Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo) r5).weight)) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public String toString() {
            return "[resolveInfo:" + this.resolveInfo.toString() + "; weight:" + new BigDecimal(this.weight) + "]";
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ActivityResolveInfo r1) {
            return Float.floatToIntBits(r1.weight) - Float.floatToIntBits(this.weight);
        }
    }

    public interface ActivitySorter {
        void sort(Intent r1, List<ActivityResolveInfo> r2, List<HistoricalRecord> r3);
    }

    public static final class DefaultSorter implements ActivitySorter {
        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
        private final Map<ComponentName, ActivityResolveInfo> mPackageNameToActivityMap;

        public DefaultSorter() {
            this.mPackageNameToActivityMap = new HashMap();
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.ActivitySorter
        public void sort(Intent r6, List<ActivityResolveInfo> r7, List<HistoricalRecord> r8) {
            Map<ComponentName, ActivityResolveInfo> r5 = this.mPackageNameToActivityMap;
            r5.clear();
            int r9 = r7.size();
            int r0 = 0;
        L3:
            if (r0 >= r9) goto L5;
            ActivityResolveInfo r1 = r7.get(r0);
            r1.weight = 0.0f;
            ActivityInfo r3 = r1.resolveInfo.activityInfo;
            r5.put(new ComponentName(r3.packageName, r3.name), r1);
            r0 = r0 + 1;
            goto L3
        L5:
            int r10 = r8.size() - 1;
            float r2 = 1.0f;
        L6:
            if (r10 < 0) goto L11;
            HistoricalRecord r4 = r8.get(r10);
            ActivityResolveInfo r11 = r5.get(r4.activity);
            if (r11 == null) goto L10;
            r11.weight = (r4.weight * r2) + r11.weight;
            r2 = r2 * WEIGHT_DECAY_COEFFICIENT;
        L10:
            r10 = r10 - 1;
            goto L6
        L11:
            Collections.sort(r7);
        }
    }

    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(String r1, long r2, float r4) {
            this(ComponentName.unflattenFromString(r1), r2, r4);
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (r7 != null) goto L9;
            return false;
        L9:
            if (HistoricalRecord.class == r7.getClass()) goto L11;
            return false;
        L11:
            HistoricalRecord r8 = (HistoricalRecord) r7;
            ComponentName r2 = this.activity;
            if (r2 != null) goto L17;
            if (r8.activity == null) goto L20;
            return false;
        L20:
            if (this.time == r8.time) goto L23;
            return false;
        L23:
            if (Float.floatToIntBits(this.weight) == Float.floatToIntBits(r8.weight)) goto L25;
            return false;
        L25:
            return true;
        L17:
            if (r2.equals(r8.activity) == true) goto L20;
            return false;
        }

        public int hashCode() {
            ComponentName r0 = this.activity;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            long r2 = this.time;
            int r6 = Float.floatToIntBits(this.weight);
            return r6 + ((((r1 + 31) * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31);
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "[; activity:" + this.activity + "; time:" + this.time + "; weight:" + new BigDecimal(this.weight) + "]";
        }

        public HistoricalRecord(ComponentName r1, long r2, float r4) {
            this.activity = r1;
            this.time = r2;
            this.weight = r4;
        }
    }

    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel r1, Intent r2);
    }

    public final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        final /* synthetic */ ActivityChooserModel this$0;

        public PersistHistoryAsyncTask(ActivityChooserModel r1) {
            this.this$0 = r1;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Void doInBackground(Object[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public Void doInBackground2(Object... r15) {
            List r4 = (List) r15[0];
            String r16 = (String) r15[1];
            FileOutputStream r17 = this.this$0.mContext.openFileOutput(r16, 0);     // Catch: FileNotFoundException -> L38
            XmlSerializer r7 = Xml.newSerializer();
            r7.setOutput(r17, null);     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            r7.startDocument("UTF-8", Boolean.TRUE);     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            r7.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            int r8 = r4.size();     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            int r9 = 0;
        L6:
            if (r9 >= r8) goto L16;
            HistoricalRecord r10 = (HistoricalRecord) r4.remove(0);     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            r7.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            r7.attribute(null, "activity", r10.activity.flattenToString());     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            r7.attribute(null, "time", String.valueOf(r10.time));     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            r7.attribute(null, ActivityChooserModel.ATTRIBUTE_WEIGHT, String.valueOf(r10.weight));     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            r7.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            r9 = r9 + 1;     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            goto L6
        L16:
            r7.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            r7.endDocument();     // Catch: Throwable -> L8 IOException -> L10 IllegalStateException -> L12 IllegalArgumentException -> L14
            this.this$0.mCanReadHistoricalData = true;
            if (r17 != null) goto L44;
        L33:
            return null;
        L44:
            r17.close();     // Catch: IOException -> L41
            goto L33
        L8:
            th = move-exception;
            this.this$0.mCanReadHistoricalData = true;
            if (r17 != null) goto L49;
        L37:
            throw th;
        L49:
            r17.close();     // Catch: IOException -> L42
        L10:
            e = move-exception;
            Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + this.this$0.mHistoryFileName, e);     // Catch: Throwable -> L8
            this.this$0.mCanReadHistoricalData = true;
            if (r17 == null) goto L33;
        L12:
            e = move-exception;
            Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + this.this$0.mHistoryFileName, e);     // Catch: Throwable -> L8
            this.this$0.mCanReadHistoricalData = true;
            if (r17 == null) goto L33;
        L14:
            e = move-exception;
            Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + this.this$0.mHistoryFileName, e);     // Catch: Throwable -> L8
            this.this$0.mCanReadHistoricalData = true;
            if (r17 == null) goto L33;
        L38:
            e = move-exception;
            Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + r16, e);
            return null;
        }
    }

    static {
        sRegistryLock = new Object();
        sDataModelRegistry = new HashMap();
    }

    private ActivityChooserModel(Context r3, String r4) {
        this.mInstanceLock = new Object();
        this.mActivities = new ArrayList();
        this.mHistoricalRecords = new ArrayList();
        this.mActivitySorter = new DefaultSorter();
        this.mHistoryMaxSize = 50;
        this.mCanReadHistoricalData = true;
        this.mReadShareHistoryCalled = false;
        this.mHistoricalRecordsChanged = true;
        this.mReloadActivities = false;
        this.mContext = r3.getApplicationContext();
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L7:
        this.mHistoryFileName = r4;
        return;
    L5:
        if (r4.endsWith(HISTORY_FILE_EXTENSION) == true) goto L7;
        this.mHistoryFileName = r4.concat(HISTORY_FILE_EXTENSION);
    }

    private boolean addHistoricalRecord(HistoricalRecord r2) {
        boolean r3 = this.mHistoricalRecords.add(r2);
        if (r3 == false) goto L5;
        this.mHistoricalRecordsChanged = true;
        pruneExcessiveHistoricalRecordsIfNeeded();
        persistHistoricalDataIfNeeded();
        sortActivitiesIfNeeded();
        notifyChanged();
    L5:
        return r3;
    }

    private void ensureConsistentState() {
        boolean r0 = loadActivitiesIfNeeded() | readHistoricalDataIfNeeded();
        pruneExcessiveHistoricalRecordsIfNeeded();
        if (r0 == false) goto L6;
        sortActivitiesIfNeeded();
        notifyChanged();
        return;
    }

    public static ActivityChooserModel get(Context r3, String r4) {
        Object r0 = sRegistryLock;
        monitor-enter(r0);
        Map<String, ActivityChooserModel> r1 = sDataModelRegistry;     // Catch: Throwable -> L7
        ActivityChooserModel r2 = r1.get(r4);     // Catch: Throwable -> L7
        if (r2 != null) goto L9;
        r2 = new ActivityChooserModel(r3, r4);     // Catch: Throwable -> L7
        r1.put(r4, r2);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean loadActivitiesIfNeeded() {
        int r1 = 0;
        if (this.mReloadActivities == true) goto L5;
    L11:
        return false;
    L5:
        if (this.mIntent == null) goto L11;
        this.mReloadActivities = false;
        this.mActivities.clear();
        List<ResolveInfo> r0 = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int r2 = r0.size();
    L7:
        if (r1 >= r2) goto L9;
        ResolveInfo r3 = r0.get(r1);
        this.mActivities.add(new ActivityResolveInfo(r3));
        r1 = r1 + 1;
        goto L7
    L9:
        return true;
    }

    private void persistHistoricalDataIfNeeded() {
        if (this.mReadShareHistoryCalled == false) goto L12;
        if (this.mHistoricalRecordsChanged == true) goto L7;
        return;
    L7:
        this.mHistoricalRecordsChanged = false;
        if (TextUtils.isEmpty(this.mHistoryFileName) == true) goto L13;
        new PersistHistoryAsyncTask(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.mHistoricalRecords), this.mHistoryFileName});
        return;
    L13:
        return;
    L12:
        throw new IllegalStateException("No preceding call to #readHistoricalData");
    }

    private void pruneExcessiveHistoricalRecordsIfNeeded() {
        int r0 = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
        if (r0 > 0) goto L5;
        return;
    L5:
        this.mHistoricalRecordsChanged = true;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        HistoricalRecord r3 = this.mHistoricalRecords.remove(0);
        r2 = r2 + 1;
        goto L6
    }

    private boolean readHistoricalDataIfNeeded() {
        if (this.mCanReadHistoricalData == true) goto L5;
    L10:
        return false;
    L5:
        if (this.mHistoricalRecordsChanged == false) goto L10;
        if (TextUtils.isEmpty(this.mHistoryFileName) == true) goto L10;
        this.mCanReadHistoricalData = false;
        this.mReadShareHistoryCalled = true;
        readHistoricalDataImpl();
        return true;
    }

    private void readHistoricalDataImpl() {
        FileInputStream r1 = this.mContext.openFileInput(this.mHistoryFileName);     // Catch: FileNotFoundException -> L46
        XmlPullParser r2 = Xml.newPullParser();     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
        r2.setInput(r1, "UTF-8");     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
        int r3 = 0;
    L6:
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L17;
        r3 = r2.next();     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
    L17:
        if (TAG_HISTORICAL_RECORDS.equals(r2.getName()) == false) goto L35;
        List<HistoricalRecord> r4 = this.mHistoricalRecords;     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
        r4.clear();     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
    L19:
        int r5 = r2.next();     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
        if (r5 == 1) goto L21;
        if (r5 == 3) goto L19;
        if (r5 == 4) goto L19;
        if (TAG_HISTORICAL_RECORD.equals(r2.getName()) == false) goto L33;
        r4.add(new HistoricalRecord(r2.getAttributeValue(null, "activity"), Long.parseLong(r2.getAttributeValue(null, "time")), Float.parseFloat(r2.getAttributeValue(null, ATTRIBUTE_WEIGHT))));     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
        goto L19
    L33:
        throw new XmlPullParserException("Share records file not well-formed.");     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
    L21:
        if (r1 != null) goto L53;
        return;
    L53:
        r1.close();     // Catch: IOException -> L47
        return;
    L69:
        return;
    L35:
        throw new XmlPullParserException("Share records file does not start with historical-records tag.");     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
    L12:
        e = move-exception;
        Log.e(LOG_TAG, "Error reading historical recrod file: " + this.mHistoryFileName, e);     // Catch: Throwable -> L10
        if (r1 != null) goto L53;
        return;
    L14:
        e = move-exception;
        Log.e(LOG_TAG, "Error reading historical recrod file: " + this.mHistoryFileName, e);     // Catch: Throwable -> L10
        if (r1 != null) goto L53;
        return;
    L46:
        return;
    L10:
        th = move-exception;
        if (r1 != null) goto L51;
    L45:
        throw th;
    L51:
        r1.close();     // Catch: IOException -> L48
        goto L45
    }

    private boolean sortActivitiesIfNeeded() {
        if (this.mActivitySorter != null) goto L5;
        return false;
    L5:
        if (this.mIntent != null) goto L7;
        return false;
    L7:
        if (this.mActivities.isEmpty() == false) goto L9;
        return false;
    L9:
        if (this.mHistoricalRecords.isEmpty() == true) goto L16;
        this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
        return true;
    L16:
        return false;
    }

    public Intent chooseActivity(int r7) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mIntent != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L10:
        ensureConsistentState();     // Catch: Throwable -> L8
        ActivityInfo r8 = this.mActivities.get(r7).resolveInfo.activityInfo;     // Catch: Throwable -> L8
        ComponentName r1 = new ComponentName(r8.packageName, r8.name);     // Catch: Throwable -> L8
        Intent r9 = new Intent(this.mIntent);     // Catch: Throwable -> L8
        r9.setComponent(r1);     // Catch: Throwable -> L8
        if (this.mActivityChoserModelPolicy == null) goto L16;
        Intent r3 = new Intent(r9);     // Catch: Throwable -> L8
        if (this.mActivityChoserModelPolicy.onChooseActivity(this, r3) == false) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L16:
        addHistoricalRecord(new HistoricalRecord(r1, System.currentTimeMillis(), 1.0f));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r9;
    }

    public ResolveInfo getActivity(int r2) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        ensureConsistentState();     // Catch: Throwable -> L7
        ResolveInfo r1 = this.mActivities.get(r2).resolveInfo;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getActivityCount() {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        ensureConsistentState();     // Catch: Throwable -> L7
        int r1 = this.mActivities.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getActivityIndex(ResolveInfo r5) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        ensureConsistentState();     // Catch: Throwable -> L10
        List<ActivityResolveInfo> r4 = this.mActivities;     // Catch: Throwable -> L10
        int r1 = r4.size();     // Catch: Throwable -> L10
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L13;
        if (r4.get(r2).resolveInfo == r5) goto L8;
        r2 = r2 + 1;     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return -1;
    L10:
        th = move-exception;
        throw th;
    }

    public ResolveInfo getDefaultActivity() {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        ensureConsistentState();     // Catch: Throwable -> L9
        if (this.mActivities.isEmpty() == true) goto L11;
        ResolveInfo r2 = this.mActivities.get(0).resolveInfo;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    public int getHistoryMaxSize() {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        int r1 = this.mHistoryMaxSize;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getHistorySize() {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        ensureConsistentState();     // Catch: Throwable -> L7
        int r1 = this.mHistoricalRecords.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public Intent getIntent() {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        Intent r1 = this.mIntent;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setActivitySorter(ActivitySorter r3) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mActivitySorter != r3) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mActivitySorter = r3;     // Catch: Throwable -> L8
        if (sortActivitiesIfNeeded() == false) goto L13;
        notifyChanged();     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public void setDefaultActivity(int r6) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        ensureConsistentState();     // Catch: Throwable -> L7
        ActivityResolveInfo r7 = this.mActivities.get(r6);     // Catch: Throwable -> L7
        ActivityResolveInfo r1 = this.mActivities.get(0);     // Catch: Throwable -> L7
        if (r1 == null) goto L9;
        float r2 = (r1.weight - r7.weight) + 5.0f;     // Catch: Throwable -> L7
    L10:
        ActivityInfo r8 = r7.resolveInfo.activityInfo;     // Catch: Throwable -> L7
        addHistoricalRecord(new HistoricalRecord(new ComponentName(r8.packageName, r8.name), System.currentTimeMillis(), r2));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        r2 = 1.0f;
    L7:
        th = move-exception;
        throw th;
    }

    public void setHistoryMaxSize(int r3) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mHistoryMaxSize != r3) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mHistoryMaxSize = r3;     // Catch: Throwable -> L8
        pruneExcessiveHistoricalRecordsIfNeeded();     // Catch: Throwable -> L8
        if (sortActivitiesIfNeeded() == false) goto L13;
        notifyChanged();     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public void setIntent(Intent r3) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mIntent != r3) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mIntent = r3;     // Catch: Throwable -> L8
        this.mReloadActivities = true;     // Catch: Throwable -> L8
        ensureConsistentState();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public void setOnChooseActivityListener(OnChooseActivityListener r2) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        this.mActivityChoserModelPolicy = r2;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
