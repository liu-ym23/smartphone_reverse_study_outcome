package obric.util;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.provider.CalendarContract;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.format.Time;
import java.io.File;
import java.util.Calendar;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import kotlinx.coroutines.DebugKt;
import obric.view.WindowManagerHelper;

/* JADX INFO: loaded from: classes5.dex */
public class CalendarUtils {
    public static final int EVENT_TYPE_NORMAL = 2;
    public static final int MAX_CALENDAR_YEAR = 2037;
    public static final int MIN_CALENDAR_YEAR = 1970;
    public static final int MONDAY_BEFORE_JULIAN_EPOCH = 2440585;
    private static AssetManager mAssetManager;
    private static final String mCalendarBg = null;
    private static final String mCalendarFlip = null;
    private static final String mCalendarPrefix = null;
    private static final String mCalendarRing = null;
    private static final TimeZoneUtils mTZUtils = null;

    public static class TimeZoneUtils {
        public static final String[] CALENDAR_CACHE_POJECTION = null;
        public static final String KEY_HOME_TZ = "preferences_home_tz";
        public static final String KEY_HOME_TZ_ENABLED = "preferences_home_tz_enabled";
        private static final String[] TIMEZONE_INSTANCES_ARGS = null;
        private static final String[] TIMEZONE_TYPE_ARGS = null;
        private static Formatter mF;
        private static volatile boolean mFirstTZRequest;
        private static AsyncTZHandler mHandler;
        private static volatile String mHomeTZ;
        private static StringBuilder mSB;
        private static HashSet<Runnable> mTZCallbacks;
        private static volatile boolean mTZQueryInProgress;
        private static int mToken;
        private static volatile boolean mUseHomeTZ;
        private final String mPrefsName;

        private class AsyncTZHandler extends AsyncQueryHandler {
            final /* synthetic */ TimeZoneUtils this$0;

            public AsyncTZHandler(final TimeZoneUtils this$0, ContentResolver cr) {
                this.this$0 = this$0;
                super(cr);
            }

            @Override // android.content.AsyncQueryHandler
            protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
                HashSet r9 = TimeZoneUtils.access$300();
                monitor-enter(r9);
                if (cursor != null) goto L7;
                TimeZoneUtils.access$402(false);     // Catch: Throwable -> L39
                TimeZoneUtils.access$502(true);     // Catch: Throwable -> L39
            L37:
                monitor-exit(r9);     // Catch: Throwable -> L39
                return;
            L7:
                int r2 = cursor.getColumnIndexOrThrow("key");     // Catch: Throwable -> L39
                int r3 = cursor.getColumnIndexOrThrow("value");     // Catch: Throwable -> L39
                boolean r4 = false;
            L9:
                if (cursor.moveToNext() == false) goto L27;
                String r5 = cursor.getString(r2);     // Catch: Throwable -> L39
                String r6 = cursor.getString(r3);     // Catch: Throwable -> L39
                if (TextUtils.equals(r5, "timezoneType") == true) goto L13;
                if (TextUtils.equals(r5, "timezoneInstancesPrevious") == false) goto L9;
                if (TextUtils.isEmpty(r6) == true) goto L9;
                if (TextUtils.equals(TimeZoneUtils.access$700(), r6) == true) goto L9;
                TimeZoneUtils.access$702(r6);     // Catch: Throwable -> L39
            L19:
                r4 = true;
                goto L9
            L13:
                if (TextUtils.equals(r6, DebugKt.DEBUG_PROPERTY_VALUE_AUTO) == true) goto L15;
                boolean r7 = true;
            L17:
                if (r7 == TimeZoneUtils.access$600()) goto L9;
                TimeZoneUtils.access$602(r7);     // Catch: Throwable -> L39
                goto L19
            L15:
                r7 = false;
                goto L17
            L27:
                cursor.close();     // Catch: Throwable -> L39
                if (r4 == false) goto L30;
                SharedPreferences r8 = CalendarUtils.access$000((Context) cookie, TimeZoneUtils.access$800(this.this$0));     // Catch: Throwable -> L39
                CalendarUtils.access$100(r8, TimeZoneUtils.KEY_HOME_TZ_ENABLED, TimeZoneUtils.access$600());     // Catch: Throwable -> L39
                CalendarUtils.access$200(r8, TimeZoneUtils.KEY_HOME_TZ, TimeZoneUtils.access$700());     // Catch: Throwable -> L39
            L30:
                TimeZoneUtils.access$402(false);     // Catch: Throwable -> L39
                Iterator r10 = TimeZoneUtils.access$300().iterator();     // Catch: Throwable -> L39
            L32:
                if (r10.hasNext() == false) goto L36;
                Runnable r11 = (Runnable) r10.next();     // Catch: Throwable -> L39
                if (r11 == null) goto L32;
                r11.run();     // Catch: Throwable -> L39
                goto L32
            L36:
                TimeZoneUtils.access$300().clear();     // Catch: Throwable -> L39
            L39:
                th = move-exception;
                throw th;
            }
        }

        static /* synthetic */ HashSet access$300() {
            return mTZCallbacks;
        }

        static /* synthetic */ boolean access$402(boolean r0) {
            mTZQueryInProgress = r0;
            return r0;
        }

        static /* synthetic */ boolean access$502(boolean r0) {
            mFirstTZRequest = r0;
            return r0;
        }

        static /* synthetic */ boolean access$600() {
            return mUseHomeTZ;
        }

        static /* synthetic */ boolean access$602(boolean r0) {
            mUseHomeTZ = r0;
            return r0;
        }

        static /* synthetic */ String access$700() {
            return mHomeTZ;
        }

        static /* synthetic */ String access$702(String r0) {
            mHomeTZ = r0;
            return r0;
        }

        static /* synthetic */ String access$800(TimeZoneUtils r0) {
            return r0.mPrefsName;
        }

        static {
            TIMEZONE_TYPE_ARGS = new String[]{"timezoneType"};
            TIMEZONE_INSTANCES_ARGS = new String[]{"timezoneInstances"};
            CALENDAR_CACHE_POJECTION = new String[]{"key", "value"};
            mSB = new StringBuilder(50);
            mF = new Formatter(mSB, Locale.getDefault());
            mFirstTZRequest = true;
            mTZQueryInProgress = false;
            mUseHomeTZ = false;
            mHomeTZ = Time.getCurrentTimezone();
            mTZCallbacks = new HashSet();
            mToken = 1;
        }

        public TimeZoneUtils(String prefsName) {
            this.mPrefsName = prefsName;
        }

        public String formatDateRange(Context context, long startMillis, long endMillis, int flags) {
            if ((flags & 8192) == 0) goto L5;
            String r8 = "UTC";
        L6:
            String r7 = r8;
            StringBuilder r9 = mSB;
            monitor-enter(r9);
            mSB.setLength(0);     // Catch: Throwable -> L11
            String r10 = DateUtils.formatDateRange(context, mF, startMillis, endMillis, flags, r7).toString();     // Catch: Throwable -> L11
            monitor-exit(r9);     // Catch: Throwable -> L11
            return r10;
        L11:
            th = move-exception;
            throw th;
        L5:
            Runnable r1 = (Runnable) null;
            r8 = getTimeZone(context, null);
            goto L6
        }

        public void setTimeZone(Context context, String timeZone) {
            if (TextUtils.isEmpty(timeZone) == true) goto L33;
            HashSet<Runnable> r0 = mTZCallbacks;
            monitor-enter(r0);
            boolean r2 = false;
            if (DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(timeZone) == false) goto L10;
            boolean r13 = mUseHomeTZ;     // Catch: Throwable -> L30
            mUseHomeTZ = false;     // Catch: Throwable -> L30
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L30
            if (r13 == false) goto L36;
            SharedPreferences r14 = CalendarUtils.access$000(context, this.mPrefsName);
            CalendarUtils.access$100(r14, KEY_HOME_TZ_ENABLED, mUseHomeTZ);
            CalendarUtils.access$200(r14, KEY_HOME_TZ, mHomeTZ);
            ContentValues r8 = new ContentValues();
            AsyncTZHandler r15 = mHandler;
            if (r15 == null) goto L20;
            r15.cancelOperation(mToken);
        L20:
            mHandler = new AsyncTZHandler(this, context.getContentResolver());
            int r11 = mToken + 1;
            mToken = r11;
            if (r11 != 0) goto L24;
            mToken = 1;
        L24:
            if (mUseHomeTZ == false) goto L26;
            String r12 = "home";
        L27:
            r8.put("value", r12);
            mHandler.startUpdate(mToken, null, CalendarContract.CalendarCache.URI, r8, "key=?", TIMEZONE_TYPE_ARGS);
            if (mUseHomeTZ == false) goto L37;
            ContentValues r4 = new ContentValues();
            r4.put("value", mHomeTZ);
            mHandler.startUpdate(mToken, null, CalendarContract.CalendarCache.URI, r4, "key=?", TIMEZONE_INSTANCES_ARGS);
            return;
        L37:
            return;
        L26:
            r12 = DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
            goto L27
        L36:
            return;
        L10:
            if (mUseHomeTZ == true) goto L12;
        L13:
            r2 = true;
        L14:
            mUseHomeTZ = true;     // Catch: Throwable -> L30
            mHomeTZ = timeZone;     // Catch: Throwable -> L30
            r13 = r2;
            goto L15
        L12:
            if (TextUtils.equals(mHomeTZ, timeZone) == true) goto L14;
        L30:
            th = move-exception;
            throw th;
        }

        public String getTimeZone(Context context, Runnable callback) {
            HashSet<Runnable> r0 = mTZCallbacks;
            monitor-enter(r0);
        L19:
            th = move-exception;
            throw th;
        L5:
            if (mFirstTZRequest == false) goto L11;
            mTZQueryInProgress = true;     // Catch: Throwable -> L19
            mFirstTZRequest = false;     // Catch: Throwable -> L19
            SharedPreferences r2 = CalendarUtils.access$000(context, this.mPrefsName);     // Catch: Throwable -> L19
            mUseHomeTZ = r2.getBoolean(KEY_HOME_TZ_ENABLED, false);     // Catch: Throwable -> L19
            mHomeTZ = r2.getString(KEY_HOME_TZ, Time.getCurrentTimezone());     // Catch: Throwable -> L19
            if (mHandler != null) goto L9;
            mHandler = new AsyncTZHandler(this, context.getContentResolver());     // Catch: Throwable -> L19
        L9:
            String r9 = (String) null;     // Catch: Throwable -> L19
            String[] r10 = (String[]) null;     // Catch: Throwable -> L19
            String r11 = (String) null;     // Catch: Throwable -> L19
            mHandler.startQuery(0, context, CalendarContract.CalendarCache.URI, CALENDAR_CACHE_POJECTION, null, null, null);     // Catch: Throwable -> L19
        L11:
            if (mTZQueryInProgress == false) goto L13;
            mTZCallbacks.add(callback);     // Catch: Throwable -> L19
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L19
            if (mUseHomeTZ == false) goto L18;
            return mHomeTZ;
        L18:
            return Time.getCurrentTimezone();
        }

        public void forceDBRequery(Context context, Runnable callback) {
            HashSet<Runnable> r0 = mTZCallbacks;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (mTZQueryInProgress == false) goto L7;
            mTZCallbacks.add(callback);     // Catch: Throwable -> L10
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L7:
            mFirstTZRequest = true;     // Catch: Throwable -> L10
            getTimeZone(context, callback);     // Catch: Throwable -> L10
            goto L8
        }
    }

    public static int getJulianMondayFromWeeksSinceEpoch(int week) {
        return (week * 7) + MONDAY_BEFORE_JULIAN_EPOCH;
    }

    static /* synthetic */ SharedPreferences access$000(Context r0, String r1) {
        return getSharedPreferences(r0, r1);
    }

    static /* synthetic */ void access$100(SharedPreferences r0, String r1, boolean r2) {
        setSharedPreference(r0, r1, r2);
    }

    static /* synthetic */ void access$200(SharedPreferences r0, String r1, String r2) {
        setSharedPreference(r0, r1, r2);
    }

    static {
        mTZUtils = new TimeZoneUtils("com.android.calendar_preferences");
        mAssetManager = null;
        String r0 = "calendar" + File.separator;
        mCalendarPrefix = r0;
        mCalendarBg = r0 + "bg.png";
        mCalendarRing = r0 + "ring.png";
        mCalendarFlip = r0 + "flip.png";
    }

    public CalendarUtils() {
    }

    public static long getMaxTimeMills() {
        Time r0 = new Time();
        r0.set(31, 11, MAX_CALENDAR_YEAR);
        return r0.normalize(true);
    }

    public static long getMinTimeMills() {
        Time r0 = new Time();
        r0.set(1, 0, MIN_CALENDAR_YEAR);
        return r0.normalize(true);
    }

    public static void adjustToBeginningOfWeek(Time time, int weekStart) {
        int r0 = time.weekDay - weekStart;
        if (r0 == 0) goto L8;
        if (r0 >= 0) goto L6;
        r0 = r0 + 7;
    L6:
        time.monthDay -= r0;
        time.normalize(true);
        return;
    }

    public static int getJulianDay(Time time) {
        return Time.getJulianDay(time.toMillis(false), time.gmtoff);
    }

    public static int getFirstDayOfWeekInCalendar(Context context) {
        if (getDefaultWeekStartWithLocale(context) == 1) goto L7;
        return 2;
    L7:
        return 1;
    }

    public static int getFirstDayOfWeekInTime(Context context) {
        if (getDefaultWeekStartWithLocale(context) != 1) goto L6;
        return 0;
    L6:
        return 1;
    }

    public static int getDefaultWeekStartWithLocale(Context context) {
        Locale r2 = context.getResources().getConfiguration().locale;
        if (Locale.US.getCountry().equals(r2.getCountry()) == false) goto L5;
    L8:
        return 1;
    L5:
        if ("ID".equals(r2.getCountry()) == true) goto L8;
        return 2;
    }

    public static int getWeeksSinceEpochFromJulianDay(int julianDay, int firstDayOfWeek) {
        int r2 = 4 - firstDayOfWeek;
        if (r2 >= 0) goto L6;
        r2 = r2 + 7;
    L6:
        return (julianDay - (2440588 - r2)) / 7;
    }

    public static boolean isValidDay(long millitime) {
        Time r0 = new Time();
        r0.set(1, 0, MIN_CALENDAR_YEAR);
        long r1 = r0.normalize(true);
        Time r4 = new Time();
        r4.set(1, 0, WindowManagerHelper.LayoutParamsSmt.TYPE_APPLICATION_OVERLAY);
        if (millitime > r4.normalize(true)) goto L8;
        if (millitime < r1) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean isTheSameDay(Time a2, Time b) {
        if (a2 == null) goto L13;
        if (b != null) goto L6;
        return false;
    L6:
        if (a2.year == b.year) goto L8;
        return false;
    L8:
        if (a2.month == b.month) goto L10;
        return false;
    L10:
        if (a2.monthDay != b.monthDay) goto L17;
        return true;
    L17:
        return false;
    L13:
        return false;
    }

    public static int compareJulianDay(Time time1, Time time2) {
        return Time.getJulianDay(time1.toMillis(false), time1.gmtoff) - Time.getJulianDay(time2.toMillis(false), time1.gmtoff);
    }

    public static boolean isValidDay(Time minTime, Time selecctTime, Time maxTime) {
        if (compareJulianDay(minTime, selecctTime) <= 0) goto L5;
    L7:
        return false;
    L5:
        if (compareJulianDay(maxTime, selecctTime) < 0) goto L7;
        return true;
    }

    public static void setFisrtDayOfWeek(Context context, Calendar... cals) {
        int r4 = getFirstDayOfWeekInCalendar(context);
        int r0 = cals.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Calendar r2 = cals[r1];
        r2.setFirstDayOfWeek(r4);
        r2.setMinimalDaysInFirstWeek(4);
        r2.clear(3);
        r1 = r1 + 1;
        goto L3
    }

    public static boolean turningMonthIsValid(Time time, boolean isToNext) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(time.toMillis(true));
        if (isToNext == false) goto L9;
        r0.add(2, 1);
        if (r0.get(1) > 2037) goto L8;
        return true;
    L8:
        return false;
    L9:
        r0.add(2, -1);
        if (r0.get(1) < 1970) goto L13;
        return true;
    L13:
        return false;
    }

    public static String addEnglishNumberSuffix(int n) {
        return n + getEnglishNumberSuffix(n);
    }

    public static String getEnglishNumberSuffix(int n) {
        if (n >= 11) goto L5;
    L7:
        int r2 = n % 10;
        if (r2 != 1) goto L10;
        return "st";
    L10:
        if (r2 != 2) goto L12;
        return "nd";
    L12:
        if (r2 == 3) goto L14;
        return "th";
    L14:
        return "rd";
    L5:
        if (n > 13) goto L7;
        return "th";
    }

    public static String getTimeZone(Context context, Runnable callback) {
        return mTZUtils.getTimeZone(context, callback);
    }

    private static void setSharedPreference(SharedPreferences prefs, String key, String value) {
        SharedPreferences.Editor r0 = prefs.edit();
        r0.putString(key, value);
        r0.apply();
    }

    private static void setSharedPreference(SharedPreferences prefs, String key, boolean value) {
        SharedPreferences.Editor r0 = prefs.edit();
        r0.putBoolean(key, value);
        r0.apply();
    }

    private static SharedPreferences getSharedPreferences(Context context, String prefsName) {
        return context.getSharedPreferences(prefsName, 0);
    }

    private static int getCurrentDay() {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(System.currentTimeMillis());
        return r0.get(5);
    }
}
