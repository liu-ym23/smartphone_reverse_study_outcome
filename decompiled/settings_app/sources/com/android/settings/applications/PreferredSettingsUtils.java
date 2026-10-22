package com.android.settings.applications;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemProperties;
import android.text.TextUtils;
import bytedanceos.api.PackageManagerSmt;
import coil.util.Utils;
import com.android.settings.Constants;
import com.android.settings.PreferenceMgr;
import com.android.settings.SetupDefaultAppService;
import com.android.settings.biometrics.facejigan.CommonUtil;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.obric.olog.OLog;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import settings.PreferredActivityChooseUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class PreferredSettingsUtils {
    private static final String ASSERT_OTHERS_PATH = "preferred_activities/type_others.js";
    public static final String BYTEDANCE_LAUNCHER_PKG_NAME = "com.bytedanceos.launcher";
    public static final String COMPONENT_RESOLVERACTIVITY = "bytedanceos.app.ResolverActivity";
    public static final String COMPONENT_RESOLVERACTIVITY_ANDROID = "com.android.internal.app.ResolverActivity";
    public static final String INTENT_EXTRA_CATEGORY = "category";
    public static final String INTENT_EXTRA_EMPTY = "empty";
    public static final String INTENT_EXTRA_FILTER = "filter";
    public static final String INTENT_EXTRA_FILTER_FOR_MULTIPLE = "Multiple_filter";
    public static final String INTENT_EXTRA_MIMETYPE = "mimetype";
    public static final String INTENT_EXTRA_POSITION = "position";
    public static final String INTENT_EXTRA_SELECT_ACTION = "select_preferred_action";
    public static final String INTENT_EXTRA_SELECT_PREFERRED_ACTIVITY = "select_preferred_activity";
    public static final String INTENT_EXTRA_SELECT_PREFERRED_ACTIVITY_ARRAY = "select_preferred_activity_array";
    public static final String INTENT_EXTRA_SELECT_PREFERRED_PKG = "select_preferred_pkg";
    public static final String INTENT_EXTRA_SUMMARY = "summary";
    public static final String INTENT_FROM_FILE_MANAGE = "from_file_manage";
    private static final String LOCAL_OTHERS_FILE_PATH = "/others_suffix_profile";
    private static final String OLD_VERSION = "old_version";
    public static final String OTHERS_HAS_OPEN_APP_KEY = "has_open_app";
    public static final String OTHERS_MIME_TYPE_KEY = "mime_type";
    public static final String OTHERS_SUFFIXES_KEY = "suffixes";
    public static final String OTHERS_SUFFIX_KEY = "suffix";
    public static final String OTHERS_UPDATE_TIME_KEY = "update_time";
    private static final String TAG = "PreferredSettingsUtils";
    public static final Uri URI_OTHER_FILE_TYPE = null;
    private static IntentFilter mPendingIntentFilter;
    private Context mContext;

    /* JADX INFO: renamed from: com.android.settings.applications.PreferredSettingsUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$settings$applications$PreferredSettingsUtils$Category = null;

        static {
            int[] r0 = new int[Category.values().length];
            $SwitchMap$com$android$settings$applications$PreferredSettingsUtils$Category = r0;
            r0[Category.audio.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$android$settings$applications$PreferredSettingsUtils$Category[Category.video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$android$settings$applications$PreferredSettingsUtils$Category[Category.text.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$android$settings$applications$PreferredSettingsUtils$Category[Category.image.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$android$settings$applications$PreferredSettingsUtils$Category[Category.others.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static final class Action {
        public static HashMap<String, Integer> sActionsDefaultMap;
        public static HashMap<String, Integer> sActionsDefaultMapWithType;

        Action() {
        }

        static {
            sActionsDefaultMap = new AnonymousClass1();
            sActionsDefaultMapWithType = new AnonymousClass2();
        }
    }

    public static final enum Category extends Enum<Category> {
        private static final /* synthetic */ Category[] $VALUES = null;
        public static final Category audio = null;
        public static final Category image = null;
        public static final Category others = null;
        public static final Category text = null;
        public static final Category video = null;

        private static /* synthetic */ Category[] $values() {
            return new Category[]{image, audio, video, text, others};
        }

        private Category(String r1, int r2) {
            super(r1, r2);
        }

        public static Category valueOf(String r1) {
            return (Category) Enum.valueOf(Category.class, r1);
        }

        public static Category[] values() {
            return (Category[]) $VALUES.clone();
        }

        static {
            image = new Category(SlardarSettingsConsts.SETTING_IMAGE, 0);
            audio = new Category("audio", 1);
            video = new Category("video", 2);
            text = new Category("text", 3);
            others = new Category("others", 4);
            $VALUES = $values();
        }
    }

    static class Data {
        public static HashMap<String, Integer> sSchemeMap;

        Data() {
        }

        static {
            sSchemeMap = new AnonymousClass1();
        }
    }

    public static class FileType implements Comparator {
        private Category mCategory;
        private ComponentName mComponentName;
        private boolean mHasOpenApp;
        private IntentFilter mIntentFilter;
        private String mMimeType;
        private String mSuffix;
        private String mSuffixes;
        private long mUpdateTime;

        public FileType(String r2, String r3, String r4, Category r5) {
            this.mHasOpenApp = false;
            this.mSuffix = r2;
            this.mSuffixes = r3;
            this.mMimeType = r4;
            this.mCategory = r5;
        }

        public FileType(String r1, String r2, String r3, Category r4, long r5, boolean r7) {
            this(r1, r2, r3, r4);
            this.mUpdateTime = r5;
            this.mHasOpenApp = r7;
        }

        public String getSuffix() {
            return this.mSuffix;
        }

        public String getSuffixes() {
            return this.mSuffixes;
        }

        public String getMimeType() {
            return this.mMimeType;
        }

        public ComponentName getComponentName() {
            return this.mComponentName;
        }

        public Category getCategory() {
            return this.mCategory;
        }

        public void setCategory(Category r1) {
            this.mCategory = r1;
        }

        public void setSuffix(String r1) {
            this.mSuffix = r1;
        }

        public void setComponentName(ComponentName r1) {
            this.mComponentName = r1;
        }

        public IntentFilter getIntentFilter() {
            return this.mIntentFilter;
        }

        public void setIntentFilter(IntentFilter r1) {
            this.mIntentFilter = r1;
        }

        public boolean hasOpenApp() {
            return this.mHasOpenApp;
        }

        public String toString() {
            return "FileType{mSuffix='" + this.mSuffix + "', mSuffixes='" + this.mSuffixes + "', mMimeType='" + this.mMimeType + "', mUpdateTime=" + this.mUpdateTime + ", mHasOpenApp=" + this.mHasOpenApp + ", mComponentName=" + this.mComponentName + ", mIntentFilter=" + this.mIntentFilter + ", mCategory=" + this.mCategory + '}';
        }

        @Override // java.util.Comparator
        public int compare(Object r1, Object r2) {
            if (r1 == null) goto L6;
            if (r2 == null) goto L6;
            return r1.hashCode() - r2.hashCode();
        L6:
            return 0;
        }

        @Override // java.util.Comparator
        public boolean equals(Object r3) {
            if (this != r3) goto L5;
            return true;
        L5:
            if (r3 != null) goto L7;
            return false;
        L7:
            if (getClass() == r3.getClass()) goto L10;
            return false;
        L10:
            return Objects.equals(this.mMimeType, ((FileType) r3).mMimeType);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mMimeType});
        }
    }

    public static /* synthetic */ TreeMap $r8$lambda$uIKFtCloyLSGyCYr7Su2cZcTzhQ() {
        return new TreeMap();
    }

    static /* synthetic */ IntentFilter lambda$getFileType$2(IntentFilter r0) {
        return r0;
    }

    static /* synthetic */ IntentFilter lambda$getFileType$3(IntentFilter r0, IntentFilter r1) {
        return r1;
    }

    static /* synthetic */ FileType lambda$getFileType$5(FileType r0) {
        return r0;
    }

    static /* synthetic */ IntentFilter lambda$getFileType2$10(IntentFilter r0) {
        return r0;
    }

    static /* synthetic */ IntentFilter lambda$getFileType2$11(IntentFilter r0, IntentFilter r1) {
        return r1;
    }

    static /* synthetic */ FileType lambda$getFileType2$13(FileType r0) {
        return r0;
    }

    static /* synthetic */ ResolveInfo lambda$loadSeeAndSendResolveInfoMap$31(ResolveInfo r0) {
        return r0;
    }

    static /* synthetic */ ResolveInfo lambda$loadSeeAndSendResolveInfoMap$32(ResolveInfo r0, ResolveInfo r1) {
        return r1;
    }

    static /* synthetic */ ResolveInfo lambda$loadSeeAndSendResolveInfoMap$34(ResolveInfo r0) {
        return r0;
    }

    static /* synthetic */ ResolveInfo lambda$loadSeeAndSendResolveInfoMap$35(ResolveInfo r0, ResolveInfo r1) {
        return r1;
    }

    static {
        URI_OTHER_FILE_TYPE = Uri.parse("content://com.android.settings.apiprovider");
    }

    public PreferredSettingsUtils(Context r1) {
        this.mContext = r1;
    }

    public static String parseData(IntentFilter r0) {
        r0.countDataSchemes();
        return null;
    }

    public static void saveCurrentVersionAndUpdateDefaultSetter(Context r6) {
        String r3 = PreferenceMgr.getInstance(r6).getString(OLD_VERSION, "");     // Catch: RuntimeException -> L9
        String r4 = SystemProperties.get("ro.os.ota.version");     // Catch: RuntimeException -> L9
        if (r4 != null) goto L6;
        return;
    L6:
        if (r3.equals(r4) == true) goto L15;
        OLog.d(TAG, "saveCurrentVersionAndUpdateDefaultSetter: " + r3 + " -> " + r4);     // Catch: RuntimeException -> L9
        PreferenceMgr.getInstance(r6).putString(OLD_VERSION, r4);     // Catch: RuntimeException -> L9
        Bundle r1 = new Bundle();     // Catch: RuntimeException -> L9
        r1.putString(SetupDefaultAppService.EXTRA_EVENT_TYPE, SetupDefaultAppService.EVENT_FOR_OTA_UPDATE);     // Catch: RuntimeException -> L9
        SetupDefaultAppService.start(r6, r1);     // Catch: RuntimeException -> L9
        return;
    L15:
        return;
    L9:
        e = move-exception;
        OLog.d(TAG, "saveCurrentVersionAndUpdateDefaultSetter failed. " + e.getMessage());
    }

    public static IntentFilter getIntentFilterForType(String r2) {
        IntentFilter r0 = new IntentFilter();     // Catch: IntentFilter.MalformedMimeTypeException -> L4
        r0.addAction("android.intent.action.VIEW");     // Catch: IntentFilter.MalformedMimeTypeException -> L4
        r0.addCategory("android.intent.category.DEFAULT");     // Catch: IntentFilter.MalformedMimeTypeException -> L4
        r0.addDataScheme("file");     // Catch: IntentFilter.MalformedMimeTypeException -> L4
        r0.addDataType(r2);     // Catch: IntentFilter.MalformedMimeTypeException -> L4
        return r0;
    L4:
        e = move-exception;
        OLog.e(TAG, "get IntentFilter failed. " + e.getMessage());
        return null;
    }

    public static String getDefaultAppByCategory(Category r1) {
        int r2 = AnonymousClass1.$SwitchMap$com$android$settings$applications$PreferredSettingsUtils$Category[r1.ordinal()];
        if (r2 != 1) goto L5;
        return Constants.PKG_MUSIC;
    L5:
        if (r2 != 2) goto L7;
        return Constants.PKG_VIDEO;
    L7:
        if (r2 != 3) goto L9;
        return Constants.PKG_WPS;
    L9:
        if (r2 != 4) goto L11;
        return "com.android.gallery3d";
    L11:
        if (r2 == 5) goto L13;
        return null;
    L13:
        return "com.obric.music,com.bytedanceos.videoplayerproject,cn.wps.moffice_eng,com.android.gallery3d";
    }

    private static List<FileType> createAudioFileType() {
        ArrayList r0 = new ArrayList();
        r0.add(new FileType("mp3", "mp3 mpga mpega mp2 m4a m4r", "audio/mpeg", Category.audio));
        r0.add(new FileType("wma", "wma", "audio/x-ms-wma", Category.audio));
        r0.add(new FileType("wav", "wav", "audio/x-wav", Category.audio));
        r0.add(new FileType("aac", "aac", "audio/aac-adts;audio/aac", Category.audio));
        r0.add(new FileType("flac", "flac", "audio/flac", Category.audio));
        r0.add(new FileType("ogg", "ogg oga opus spx", "audio/ogg", Category.audio));
        r0.add(new FileType("mid", "mid midi kar ota rtttl xmf", "audio/midi", Category.audio));
        r0.add(new FileType("cda", "cda cdf", "application/x-cdf", Category.audio));
        r0.add(new FileType("ape", "ape", "audio/x-ape", Category.audio));
        r0.add(new FileType("amr", "amr", "audio/amr", Category.audio));
        r0.add(new FileType("aif", "aif aiff aifc", "audio/x-aiff", Category.audio));
        r0.add(new FileType("m3u", "m3u m3u8", "application/x-mpegURL;audio/mpegurl;audio/x-mpegurl;application/vnd.apple.mpegurl", Category.audio));
        return r0;
    }

    private static List<FileType> createVideoFileType() {
        ArrayList r0 = new ArrayList();
        r0.add(new FileType("mp4", "mp4", "video/mp4", Category.video));
        r0.add(new FileType("mkv", "mkv mpv", "video/x-matroska", Category.video));
        r0.add(new FileType("mov", "mov qt", "video/quicktime", Category.video));
        r0.add(new FileType("avi", "avi", "video/x-msvideo;video/avi", Category.video));
        r0.add(new FileType("flv", "flv", "video/x-flv", Category.video));
        r0.add(new FileType("rm", "rm rmvb", "video/rm", Category.video));
        r0.add(new FileType("3gp", "3gp", "video/3gpp", Category.video));
        r0.add(new FileType("wmv", "wmv", "video/x-ms-wmv", Category.video));
        r0.add(new FileType("asf", "asf asx", "video/x-ms-asf", Category.video));
        r0.add(new FileType("m4v", "m4v", "video/m4v", Category.video));
        r0.add(new FileType("mpeg", "mpeg mpg mpe", "video/mpeg", Category.video));
        r0.add(new FileType("ts", "ts", "video/mp2ts", Category.video));
        r0.add(new FileType("ogv", "ogv", "video/ogg", Category.video));
        r0.add(new FileType("webm", "webm", "video/webm", Category.video));
        return r0;
    }

    private static List<FileType> createTextFileType() {
        ArrayList r0 = new ArrayList();
        r0.add(new FileType("doc", "doc dot", "application/msword", Category.text));
        r0.add(new FileType("docx", "docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", Category.text));
        r0.add(new FileType("dotx", "dotx", "application/vnd.openxmlformats-officedocument.wordprocessingml.template", Category.text));
        r0.add(new FileType("xlsx", "xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", Category.text));
        r0.add(new FileType("xls", "xls xlb xlt", "application/vnd.ms-excel", Category.text));
        r0.add(new FileType("csv", "csv", "text/csv;text/comma-separated-values", Category.text));
        r0.add(new FileType("ppt", "ppt pps pot", "application/vnd.ms-powerpoint", Category.text));
        r0.add(new FileType("pptx", "pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation", Category.text));
        r0.add(new FileType("ppsx", "ppsx", "application/vnd.openxmlformats-officedocument.presentationml.slideshow", Category.text));
        r0.add(new FileType("potx", "potx", "application/vnd.openxmlformats-officedocument.presentationml.template", Category.text));
        r0.add(new FileType("pdf", "pdf", "application/pdf", Category.text));
        r0.add(new FileType("txt", "asc txt text brf srt diff po", "text/plain", Category.text));
        r0.add(new FileType("rtf", "rtf", "application/rtf;text/rtf", Category.text));
        r0.add(new FileType("odt", "odt", "application/vnd.oasis.opendocument.text", Category.text));
        r0.add(new FileType("md", "md markdown", "text/markdown", Category.text));
        return r0;
    }

    private static List<FileType> createImageFileType() {
        ArrayList r0 = new ArrayList();
        r0.add(new FileType("jpg", "jpg jpeg jpe", Utils.MIME_TYPE_JPEG, Category.image));
        r0.add(new FileType(CommonUtil.UNLOCK_FACE_FEATURE_NAME_SUFFIX, CommonUtil.UNLOCK_FACE_FEATURE_NAME_SUFFIX, "image/png", Category.image));
        r0.add(new FileType("gif", "gif", "image/gif", Category.image));
        r0.add(new FileType("bmp", "bmp", "image/x-ms-bmp;image/bmp", Category.image));
        r0.add(new FileType("tif", "tif tiff", "image/tiff", Category.image));
        r0.add(new FileType("webp", "webp", Utils.MIME_TYPE_WEBP, Category.image));
        r0.add(new FileType("svg", "svg svgz", "image/svg+xml", Category.image));
        r0.add(new FileType("cdr", "cdr", "image/x-coreldraw", Category.image));
        r0.add(new FileType("dng", "dng", "image/x-adobe-dng", Category.image));
        return r0;
    }

    public static List<FileType> getLocalFileTypeConfig(Category r1) {
        int r2 = AnonymousClass1.$SwitchMap$com$android$settings$applications$PreferredSettingsUtils$Category[r1.ordinal()];
        if (r2 == 1) goto L18;
        if (r2 == 2) goto L23;
        if (r2 == 3) goto L22;
        if (r2 == 4) goto L21;
        if (r2 == 5) goto L20;
        return new ArrayList();
    L20:
        return createAllFileType();
    L21:
        return createImageFileType();
    L22:
        return createTextFileType();
    L23:
        return createVideoFileType();
    L18:
        return createAudioFileType();
    }

    public static List<FileType> createAllFileType() {
        ArrayList r0 = new ArrayList();
        r0.addAll(createAudioFileType());
        r0.addAll(createVideoFileType());
        r0.addAll(createTextFileType());
        r0.addAll(createImageFileType());
        return r0;
    }

    public static List<FileType> getLocalOtherFileType(String r12) {
        if (TextUtils.isEmpty(r12) == true) goto L5;
        ArrayList r0 = new ArrayList();
        JSONArray r1 = new JSONArray(r12);     // Catch: JSONException -> L13
        int r13 = 0;
    L9:
        if (r13 >= r1.length()) goto L12;
        JSONObject r2 = r1.getJSONObject(r13);     // Catch: JSONException -> L13
        String r5 = r2.getString(OTHERS_SUFFIX_KEY);     // Catch: JSONException -> L13
        String r6 = r2.getString(OTHERS_SUFFIXES_KEY).trim();     // Catch: JSONException -> L13
        String r7 = r2.getString(OTHERS_MIME_TYPE_KEY).trim();     // Catch: JSONException -> L13
        long r9 = r2.getLong("update_time");     // Catch: JSONException -> L13
        boolean r11 = r2.getBoolean(OTHERS_HAS_OPEN_APP_KEY);     // Catch: JSONException -> L13
        r0.add(new FileType(r5, r6, r7, Category.others, r9, r11));     // Catch: JSONException -> L13
        r13 = r13 + 1;
        goto L9
    L12:
        return r0;
    L13:
        OLog.e(TAG, "get LocalOther FileType occurs JSONException!");
        return r0;
    L5:
        return Collections.EMPTY_LIST;
    }

    public static boolean isHasOpenApp(PreferredActivityChooseUtils r4, String r5, boolean r6) {
        if (r4 != null) goto L5;
    L16:
        return false;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L16;
        String[] r7 = r5.split(";");
        int r1 = r7.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L16;
        r4.generateData(PreferredActivityChooseUtils.makeIntentByFilter(getIntentFilterForType(r7[r2])), r6);
        List<ResolveInfo> r3 = r4.getResolveInfoList();
        if (r3 == null) goto L15;
        if (r3.isEmpty() == true) goto L15;
        return true;
    L15:
        r2 = r2 + 1;
        goto L8
    }

    public static List<FileType> getFileType(Context r8, Category r9, PreferredActivityChooseUtils r10) {
        long r0 = System.currentTimeMillis();
        OLog.i(TAG, "getFileType start");
        PackageManager r2 = r8.getPackageManager();
        final ArrayList r4 = new ArrayList();
        final ArrayList r5 = new ArrayList();
        PackageManagerSmt.getInstance().getAlwaysPreferredActivities(r2, r5, r4, null);
        OLog.i(TAG, "getFileType getAlwaysPreferredActivities " + (System.currentTimeMillis() - r0));
        if (r5.isEmpty() == false) goto L7;
        return Collections.EMPTY_LIST;
    L7:
        if (r9 != Category.others) goto L9;
        List<FileType> r11 = getLocalOthersFileTypeData(r8, r10);
    L11:
        if (r11.isEmpty() == true) goto L13;
        OLog.i(TAG, "getFileType getLocalFileTypeConfig " + (System.currentTimeMillis() - r0));
        final Map r12 = (Map) r5.stream().filter(new PreferredSettingsUtils$$ExternalSyntheticLambda27()).collect(Collectors.toMap(new PreferredSettingsUtils$$ExternalSyntheticLambda28(), new PreferredSettingsUtils$$ExternalSyntheticLambda29(), new PreferredSettingsUtils$$ExternalSyntheticLambda30()));
        OLog.i(TAG, "getFileType intentFilterMap " + (System.currentTimeMillis() - r0));
        ((Map) r11.stream().collect(Collectors.toMap(new PreferredSettingsUtils$$ExternalSyntheticLambda31(), new PreferredSettingsUtils$$ExternalSyntheticLambda32()))).forEach(new PreferredSettingsUtils$$ExternalSyntheticLambda34(r12, r5, r4));
        OLog.i(TAG, "getFileType fileTypeMap " + (System.currentTimeMillis() - r0));
        return (List) r11.stream().distinct().collect(Collectors.toList());
    L13:
        return Collections.EMPTY_LIST;
    L9:
        r11 = getLocalFileTypeConfig(r9);
        goto L11
    }

    static /* synthetic */ boolean lambda$getFileType$0(IntentFilter r0) {
        if (r0.countDataTypes() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ String lambda$getFileType$1(IntentFilter r1) {
        return r1.getDataType(0);
    }

    static /* synthetic */ String lambda$getFileType$4(FileType r0) {
        return r0.getMimeType();
    }

    static /* synthetic */ void lambda$getFileType$7(final Map r2, List r3, List r4, String r5, FileType r6) {
        mPendingIntentFilter = null;
        if (r5.contains(";") == false) goto L5;
        Stream.of(r5.split(";")).forEach(new PreferredSettingsUtils$$ExternalSyntheticLambda18(r2));
    L6:
        IntentFilter r7 = mPendingIntentFilter;
        if (r7 == null) goto L15;
        r6.setIntentFilter(r7);
        int r8 = r3.indexOf(mPendingIntentFilter);
        if (r8 >= 0) goto L11;
    L13:
        OLog.d(TAG, "illegal index");
        return;
    L11:
        if (r8 >= r4.size()) goto L13;
        r6.setComponentName((ComponentName) r4.get(r8));
        return;
    L15:
        return;
    L5:
        mPendingIntentFilter = (IntentFilter) r2.get(r5);
        goto L6
    }

    static /* synthetic */ void lambda$getFileType$6(Map r1, String r2) {
        if (mPendingIntentFilter != null) goto L6;
        mPendingIntentFilter = (IntentFilter) r1.get(r2);
        return;
    }

    public static List<FileType> getFileType2(Context r6, final List<ComponentName> r7, final List<IntentFilter> r8, Category r9, PreferredActivityChooseUtils r10) {
        long r0 = System.currentTimeMillis();
        OLog.i(TAG, "getFileType2 start");
        if (r8.isEmpty() == false) goto L7;
        return Collections.EMPTY_LIST;
    L7:
        if (r9 != Category.others) goto L9;
        List<FileType> r11 = getLocalOthersFileTypeData(r6, r10);
    L11:
        if (r11.isEmpty() == true) goto L13;
        OLog.i(TAG, "getFileType2 getLocalFileTypeConfig " + (System.currentTimeMillis() - r0));
        final Map r12 = (Map) r8.stream().filter(new PreferredSettingsUtils$$ExternalSyntheticLambda19()).collect(Collectors.toMap(new PreferredSettingsUtils$$ExternalSyntheticLambda20(), new PreferredSettingsUtils$$ExternalSyntheticLambda21(), new PreferredSettingsUtils$$ExternalSyntheticLambda23()));
        OLog.i(TAG, "getFileType2 intentFilterMap " + (System.currentTimeMillis() - r0));
        ((Map) r11.stream().collect(Collectors.toMap(new PreferredSettingsUtils$$ExternalSyntheticLambda24(), new PreferredSettingsUtils$$ExternalSyntheticLambda25()))).forEach(new PreferredSettingsUtils$$ExternalSyntheticLambda26(r12, r8, r7));
        OLog.i(TAG, "getFileType2 fileTypeMap " + (System.currentTimeMillis() - r0));
        return (List) r11.stream().distinct().collect(Collectors.toList());
    L13:
        return Collections.EMPTY_LIST;
    L9:
        r11 = getLocalFileTypeConfig(r9);
        goto L11
    }

    static /* synthetic */ boolean lambda$getFileType2$8(IntentFilter r0) {
        if (r0.countDataTypes() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ String lambda$getFileType2$9(IntentFilter r1) {
        return r1.getDataType(0);
    }

    static /* synthetic */ String lambda$getFileType2$12(FileType r0) {
        return r0.getMimeType();
    }

    static /* synthetic */ void lambda$getFileType2$15(final Map r2, List r3, List r4, String r5, FileType r6) {
        mPendingIntentFilter = null;
        if (r5.contains(";") == false) goto L5;
        Stream.of(r5.split(";")).forEach(new PreferredSettingsUtils$$ExternalSyntheticLambda11(r2));
    L6:
        IntentFilter r7 = mPendingIntentFilter;
        if (r7 == null) goto L15;
        r6.setIntentFilter(r7);
        int r8 = r3.indexOf(mPendingIntentFilter);
        if (r8 >= 0) goto L11;
    L13:
        OLog.d(TAG, "illegal index");
        return;
    L11:
        if (r8 >= r4.size()) goto L13;
        r6.setComponentName((ComponentName) r4.get(r8));
        return;
    L15:
        return;
    L5:
        mPendingIntentFilter = (IntentFilter) r2.get(r5);
        goto L6
    }

    static /* synthetic */ void lambda$getFileType2$14(Map r1, String r2) {
        if (mPendingIntentFilter != null) goto L6;
        mPendingIntentFilter = (IntentFilter) r1.get(r2);
        return;
    }

    public static List<FileType> getLocalOthersFileTypeData(Context r2, final PreferredActivityChooseUtils r3) {
        List<FileType> r4 = getLocalOtherFileType(readLocalOthersInfo(r2, LOCAL_OTHERS_FILE_PATH));
        if (r4.isEmpty() == true) goto L5;
        final ArrayList r0 = new ArrayList();
        r4.stream().forEach(new PreferredSettingsUtils$$ExternalSyntheticLambda17(r3, r0));
        return r0;
    L5:
        return Collections.EMPTY_LIST;
    }

    static /* synthetic */ void lambda$getLocalOthersFileTypeData$16(PreferredActivityChooseUtils r2, List r3, FileType r4) {
        if (r4.hasOpenApp() == false) goto L5;
    L6:
        r3.add(r4);
        return;
    L5:
        if (isHasOpenApp(r2, r4.getMimeType(), false) == true) goto L6;
    }

    public static String getSupportShowFileMimeType(Context r4, PreferredActivityChooseUtils r5) {
        TreeMap r0 = (TreeMap) Arrays.stream(Category.values()).filter(new PreferredSettingsUtils$$ExternalSyntheticLambda6()).flatMap(new PreferredSettingsUtils$$ExternalSyntheticLambda7()).collect(Collectors.groupingBy(new PreferredSettingsUtils$$ExternalSyntheticLambda8(), new PreferredSettingsUtils$$ExternalSyntheticLambda9(), Collectors.toList()));
        r0.put(Category.others, getFileType(r4, Category.others, r5));
        final TreeMap r6 = new TreeMap();
        r0.forEach(new PreferredSettingsUtils$$ExternalSyntheticLambda10(r6));
        return new JSONObject(r6).toString();
    }

    static /* synthetic */ boolean lambda$getSupportShowFileMimeType$17(Category r1) {
        return !r1.equals(Category.others);
    }

    static /* synthetic */ Stream lambda$getSupportShowFileMimeType$18(Category r0) {
        return getLocalFileTypeConfig(r0).stream();
    }

    static /* synthetic */ void lambda$getSupportShowFileMimeType$20(TreeMap r1, Category r2, List r3) {
        r1.put(r2.name(), (List) r3.stream().map(new PreferredSettingsUtils$$ExternalSyntheticLambda0()).collect(Collectors.toList()));
    }

    static /* synthetic */ String lambda$getSupportShowFileMimeType$19(FileType r0) {
        return r0.getMimeType();
    }

    public static List<ResolveInfo> deepCopy(List<ResolveInfo> r1) {
        List<ResolveInfo> r0 = Arrays.asList(new ResolveInfo[r1.size()]);
        Collections.copy(r0, r1);
        return r0;
    }

    private static String readLocalOthersInfo(Context r5, String r6) {
        InputStream r1 = null;
    L28:
        e = e;
        ByteArrayOutputStream r7 = null;
    L36:
        OLog.e(TAG, "readOthersMimeTypeFile IOException->" + e.getMessage());     // Catch: Throwable -> L33
        IOUtils.closeQuietly(r1);
        IOUtils.closeQuietly(r7);
        return "";
    L33:
        th = th;
    L34:
        IOUtils.closeQuietly(r1);
        IOUtils.closeQuietly(r7);
        throw th;
    L26:
        th = th;
        r7 = null;
        goto L34
    L4:
        if (ASSERT_OTHERS_PATH.equals(r6) == false) goto L7;
        InputStream r8 = r5.getAssets().open(ASSERT_OTHERS_PATH);     // Catch: Throwable -> L26 IOException -> L28
    L40:
        r7 = new ByteArrayOutputStream();     // Catch: Throwable -> L22 IOException -> L24
    L38:
        int r0 = r8.read();     // Catch: Throwable -> L18 IOException -> L20
        if (r0 == (-1)) goto L15;
        r7.write(r0);     // Catch: Throwable -> L18 IOException -> L20
        goto L38
    L15:
        r7.flush();     // Catch: Throwable -> L18 IOException -> L20
        String r2 = r7.toString();     // Catch: Throwable -> L18 IOException -> L20
        IOUtils.closeQuietly(r8);
        IOUtils.closeQuietly(r7);
        return r2;
    L20:
        e = move-exception;
        r1 = r8;
        e = e;
    L18:
        th = move-exception;
        r1 = r8;
        th = th;
        goto L34
    L24:
        e = move-exception;
        r1 = r8;
        e = e;
        r7 = null;
    L22:
        th = move-exception;
        r1 = r8;
        th = th;
        r7 = null;
        goto L34
    L7:
        if (LOCAL_OTHERS_FILE_PATH.equals(r6) == true) goto L9;
        r8 = null;
        goto L40
    L9:
        r8 = new FileInputStream(getSaveOthersFile(r5));     // Catch: Throwable -> L26 IOException -> L28
        goto L40
    }

    private static File getSaveOthersFile(Context r2) {
        return new File(r2.getFilesDir() + LOCAL_OTHERS_FILE_PATH);
    }

    public static boolean saveOthersMimeTypeFile(Context r6, String r7) {
        BufferedWriter r3 = null;
        File r8 = getSaveOthersFile(r6);     // Catch: Throwable -> L20 Exception -> L22 IOException -> L30 FileNotFoundException -> L31
        if (r8.exists() == true) goto L7;
        r8.createNewFile();     // Catch: Throwable -> L20 Exception -> L22 IOException -> L30 FileNotFoundException -> L31
    L7:
        if (r8.exists() == true) goto L10;
        IOUtils.closeQuietly(null);
        return false;
    L10:
        BufferedWriter r4 = new BufferedWriter(new FileWriter(r8));     // Catch: Throwable -> L20 Exception -> L22 IOException -> L30 FileNotFoundException -> L31
    L34:
        r4.write(r7);     // Catch: Throwable -> L14 Exception -> L16 IOException -> L18 FileNotFoundException -> L19
        r4.flush();     // Catch: Throwable -> L14 Exception -> L16 IOException -> L18 FileNotFoundException -> L19
        IOUtils.closeQuietly(r4);
        return true;
    L19:
        r3 = r4;
    L18:
        r3 = r4;
    L16:
        e = e;
        r3 = r4;
    L23:
        OLog.e(TAG, "saveOthersMimeTypeFile Exception. " + e.getMessage());     // Catch: Throwable -> L20
    L26:
        IOUtils.closeQuietly(r3);
        return false;
    L14:
        th = th;
        r3 = r4;
    L28:
        IOUtils.closeQuietly(r3);
        throw th;
    L20:
        th = th;
    L22:
        e = e;
    L25:
        OLog.e(TAG, "saveOthersMimeTypeFile File Not FoundException.");     // Catch: Throwable -> L20
    L24:
        OLog.e(TAG, "saveOthersMimeTypeFile IOException.");     // Catch: Throwable -> L20
        goto L26
    }

    public static String queryJsonByMimeType(String r3, String r4) {
        JSONArray r0 = new JSONArray(r3);     // Catch: JSONException -> L10
        int r5 = 0;
    L4:
        if (r5 >= r0.length()) goto L17;
        JSONObject r1 = r0.getJSONObject(r5);     // Catch: JSONException -> L10
        if (r4.equalsIgnoreCase(r1.getString(OTHERS_MIME_TYPE_KEY).trim()) == true) goto L7;
        r5 = r5 + 1;
        goto L4
    L7:
        return r1.toString();
    L17:
        return "";
    L10:
        OLog.e(TAG, "queryJsonByMimeType occurs JSONException!");
        return "";
    }

    public static void handleChangeSuffix(Context r11, String r12, String r13) {
        String r1 = readLocalOthersInfo(r11, LOCAL_OTHERS_FILE_PATH);     // Catch: JSONException -> L32
        if (TextUtils.isEmpty(r1) == true) goto L21;
        JSONArray r2 = new JSONArray(r1);     // Catch: JSONException -> L32
        int r8 = 0;
    L8:
        if (r8 >= r2.length()) goto L21;
        JSONObject r9 = r2.getJSONObject(r8);     // Catch: JSONException -> L32
        if (r12.equalsIgnoreCase(r9.getString(OTHERS_MIME_TYPE_KEY).trim()) == true) goto L12;
        r8 = r8 + 1;     // Catch: JSONException -> L32
        goto L8
    L12:
        if (r9.getString(OTHERS_SUFFIX_KEY).equals(r13) == false) goto L15;
        OLog.d(TAG, r12 + " same suffix return.");     // Catch: JSONException -> L32
        return;
    L15:
        r9.put(OTHERS_SUFFIX_KEY, r13);     // Catch: JSONException -> L32
        r9.put(OTHERS_HAS_OPEN_APP_KEY, true);     // Catch: JSONException -> L32
        if (saveOthersMimeTypeFile(r11, r2.toString()) == false) goto L38;
        r11.getContentResolver().notifyChange(URI_OTHER_FILE_TYPE, null);     // Catch: JSONException -> L32
        return;
    L38:
        return;
    L21:
        if (TextUtils.isEmpty(r1) == false) goto L23;
        JSONArray r3 = new JSONArray();     // Catch: JSONException -> L32
    L24:
        String r4 = queryJsonByMimeType(readLocalOthersInfo(r11, ASSERT_OTHERS_PATH), r12);     // Catch: JSONException -> L32
        if (TextUtils.isEmpty(r4) == false) goto L28;
        OLog.d(TAG, r12 + " is not others mime type.");     // Catch: JSONException -> L32
        return;
    L28:
        JSONObject r10 = new JSONObject(r4);     // Catch: JSONException -> L32
        r10.put(OTHERS_SUFFIX_KEY, r13);     // Catch: JSONException -> L32
        r10.put(OTHERS_MIME_TYPE_KEY, r12);     // Catch: JSONException -> L32
        r10.put(OTHERS_HAS_OPEN_APP_KEY, true);     // Catch: JSONException -> L32
        r10.put("update_time", System.currentTimeMillis());     // Catch: JSONException -> L32
        r3.put(r10);     // Catch: JSONException -> L32
        if (saveOthersMimeTypeFile(r11, r3.toString()) == false) goto L39;
        r11.getContentResolver().notifyChange(URI_OTHER_FILE_TYPE, null);     // Catch: JSONException -> L32
        return;
    L39:
        return;
    L23:
        r3 = new JSONArray(r1);     // Catch: JSONException -> L32
    L32:
        e = move-exception;
        OLog.e(TAG, "handle suffix change failed " + e.getMessage());
    }

    public static synchronized void synchronizeOthersPreferenceData(Context r9, List<String> r10) {
        monitor-enter(PreferredSettingsUtils.class);
        if (r10 != null) goto L44;
    L38:
        OLog.d(TAG, "data is null, synchronize others preference data failed!");     // Catch: Throwable -> L41
        monitor-exit(PreferredSettingsUtils.class);
        return;
    L44:
    L41:
        th = move-exception;
        throw th;
    L6:
        if (r10.isEmpty() == true) goto L38;
        String r1 = readLocalOthersInfo(r9, LOCAL_OTHERS_FILE_PATH);     // Catch: JSONException -> L35 Throwable -> L41
        if (TextUtils.isEmpty(r1) == true) goto L11;
        OLog.d(TAG, "synchronize others preference old data.");     // Catch: JSONException -> L35 Throwable -> L41
        final List r2 = (List) getLocalOtherFileType(r1).stream().filter(new PreferredSettingsUtils$$ExternalSyntheticLambda13()).flatMap(new PreferredSettingsUtils$$ExternalSyntheticLambda14()).collect(Collectors.toList());     // Catch: JSONException -> L35 Throwable -> L41
        r10 = (List) r10.stream().filter(new PreferredSettingsUtils$$ExternalSyntheticLambda15(r2)).collect(Collectors.toList());     // Catch: JSONException -> L35 Throwable -> L41
    L11:
        if (r10 != null) goto L13;
    L33:
        monitor-exit(PreferredSettingsUtils.class);
        return;
    L13:
        if (r10.isEmpty() == true) goto L33;
        if (TextUtils.isEmpty(r1) == false) goto L18;
        JSONArray r3 = new JSONArray();     // Catch: JSONException -> L35 Throwable -> L41
    L19:
        JSONArray r4 = new JSONArray(readLocalOthersInfo(r9, ASSERT_OTHERS_PATH));     // Catch: JSONException -> L35 Throwable -> L41
        int r5 = 0;
        int r6 = 0;
    L21:
        if (r5 >= r4.length()) goto L31;
        JSONObject r7 = r4.getJSONObject(r5);     // Catch: JSONException -> L35 Throwable -> L41
        String r8 = r7.getString(OTHERS_MIME_TYPE_KEY).trim();     // Catch: JSONException -> L35 Throwable -> L41
        if (r10.contains(r8) == false) goto L26;
        r7.put(OTHERS_SUFFIX_KEY, "");     // Catch: JSONException -> L35 Throwable -> L41
        r7.put(OTHERS_MIME_TYPE_KEY, r8);     // Catch: JSONException -> L35 Throwable -> L41
        r7.put(OTHERS_HAS_OPEN_APP_KEY, true);     // Catch: JSONException -> L35 Throwable -> L41
        r7.put("update_time", System.currentTimeMillis());     // Catch: JSONException -> L35 Throwable -> L41
        r3.put(r7);     // Catch: JSONException -> L35 Throwable -> L41
        r6 = r6 + 1;     // Catch: JSONException -> L35 Throwable -> L41
    L26:
        if (r6 == r10.size()) goto L27;
        r5 = r5 + 1;
        goto L21
    L27:
        saveOthersMimeTypeFile(r9, r3.toString());     // Catch: JSONException -> L35 Throwable -> L41
        monitor-exit(PreferredSettingsUtils.class);
        return;
    L31:
        saveOthersMimeTypeFile(r9, r3.toString());     // Catch: JSONException -> L35 Throwable -> L41
    L36:
        monitor-exit(PreferredSettingsUtils.class);
        return;
    L18:
        r3 = new JSONArray(r1);     // Catch: JSONException -> L35 Throwable -> L41
    L35:
        OLog.e(TAG, "synchronizeOthersPreferenceData occurs JSONException!");     // Catch: Throwable -> L41
        goto L36
    }

    static /* synthetic */ boolean lambda$synchronizeOthersPreferenceData$21(FileType r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (TextUtils.isEmpty(r0.getMimeType()) == true) goto L6;
        return true;
    }

    static /* synthetic */ Stream lambda$synchronizeOthersPreferenceData$22(FileType r0) {
        return Stream.of(r0.getMimeType());
    }

    static /* synthetic */ boolean lambda$synchronizeOthersPreferenceData$23(List r0, String r1) {
        return !r0.contains(r1);
    }

    public static void changeOthersMimeTypeStatus(Context r6, List<String> r7, boolean r8) {
        if (r6 == null) goto L30;
        if (r7 != null) goto L6;
        return;
    L6:
        if (r7.isEmpty() == true) goto L33;
        String r1 = readLocalOthersInfo(r6, LOCAL_OTHERS_FILE_PATH);
        if (TextUtils.isEmpty(r1) == false) goto L25;
        return;
    L25:
        JSONArray r2 = new JSONArray(r1);     // Catch: JSONException -> L22
        int r3 = 0;
    L13:
        if (r3 >= r2.length()) goto L19;
        JSONObject r4 = r2.getJSONObject(r3);     // Catch: JSONException -> L22
        String r5 = r4.getString(OTHERS_MIME_TYPE_KEY).trim();     // Catch: JSONException -> L22
        if (r7.contains(r5) == false) goto L17;
        r4.put(OTHERS_HAS_OPEN_APP_KEY, r8);     // Catch: JSONException -> L22
        r4.put(OTHERS_MIME_TYPE_KEY, r5);     // Catch: JSONException -> L22
    L17:
        r3 = r3 + 1;     // Catch: JSONException -> L22
        goto L13
    L19:
        if (saveOthersMimeTypeFile(r6, r2.toString()) == false) goto L32;
        r6.getContentResolver().notifyChange(URI_OTHER_FILE_TYPE, null);     // Catch: JSONException -> L22
        return;
    L32:
        return;
    L22:
        e = move-exception;
        OLog.e(TAG, "change others  mimeType status failed." + e.getMessage());
        return;
    L33:
        return;
    }

    public static boolean addPreferredActivity(IntentFilter r7, PreferredActivityChooseUtils r8, PackageManager r9, boolean r10, ComponentName r11) {
        Intent r0 = PreferredActivityChooseUtils.makeIntentByFilter(r7);
        r8.generateData(r0, r10);
        List<ResolveInfo> r1 = r8.getResolveInfoList();
        final String r2 = r11.getPackageName();
        final String r3 = r11.getClassName();
        ResolveInfo r4 = r1.stream().filter(new PreferredSettingsUtils$$ExternalSyntheticLambda35(r2, r3)).findFirst().orElse(null);
        if (r10 == true) goto L5;
        PackageManagerSmt.getInstance().clearPreferredActivities(r9, r0);
    L5:
        int r12 = 0;
        if (r4 != null) goto L9;
        PackageManagerSmt.getInstance().clearPreferredActivities(r9, r0);
        return false;
    L9:
        List<ResolveInfo> r13 = r8.getFullResolveInfoList();
        int r5 = r13.size();
        ComponentName[] r6 = new ComponentName[r5];
        int r14 = 0;
    L10:
        if (r12 >= r5) goto L16;
        ResolveInfo r15 = r13.get(r12);
        r6[r12] = new ComponentName(r15.activityInfo.packageName, r15.activityInfo.name);
        if (r15.match <= r14) goto L14;
        r14 = r15.match;
    L14:
        r12 = r12 + 1;
        goto L10
    L16:
        if (r7.countDataSchemes() <= 0) goto L18;
    L21:
        r9.addPreferredActivity(r7, r14, r6, r11);
        return true;
    L18:
        if (r7.countDataTypes() > 0) goto L21;
        r9.addPreferredActivity(r7, 1048576, r6, r11);
        return true;
    }

    static /* synthetic */ boolean lambda$addPreferredActivity$24(String r1, String r2, ResolveInfo r3) {
        if (r1.equals(r3.activityInfo.packageName) == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.equals(r3.activityInfo.name) == false) goto L7;
        return true;
    }

    public static <T> Predicate<T> distinctByKey(final Function<? super T, ?> r2) {
        final ConcurrentHashMap r0 = new ConcurrentHashMap(16);
        return new PreferredSettingsUtils$$ExternalSyntheticLambda16(r0, r2);
    }

    static /* synthetic */ boolean lambda$distinctByKey$25(ConcurrentHashMap r0, Function r1, Object r2) {
        if (r0.putIfAbsent(r1.apply(r2), Boolean.TRUE) != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static Map<String, List<ResolveInfo>> loadSeeAndSendResolveInfoMap(Category r7, List<FileType> r8, PreferredActivityChooseUtils r9) {
        List r10 = (List) r8.stream().filter(new PreferredSettingsUtils$$ExternalSyntheticLambda22()).flatMap(new PreferredSettingsUtils$$ExternalSyntheticLambda38()).distinct().map(new PreferredSettingsUtils$$ExternalSyntheticLambda39()).collect(Collectors.toList());
        if (r10 == null) goto L24;
        if (r10.isEmpty() == true) goto L24;
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L16;
        IntentFilter r2 = (IntentFilter) r11.next();
        if (r2 == null) goto L9;
        if (r2.countDataTypes() == 0) goto L9;
        Intent r3 = PreferredActivityChooseUtils.makeIntentByFilter(r2);
        r0.addAll(getResolveInfoListWithAction(r3, r9, "android.intent.action.VIEW"));
        r1.addAll(getResolveInfoListWithAction(r3, r9, "android.intent.action.SEND"));
        goto L9
    L16:
        List r12 = (List) r0.stream().filter(distinctByKey(new PreferredSettingsUtils$$ExternalSyntheticLambda40())).collect(Collectors.toList());
        List r13 = (List) r1.stream().filter(distinctByKey(new PreferredSettingsUtils$$ExternalSyntheticLambda41())).collect(Collectors.toList());
        final Set r4 = ((Map) r12.stream().collect(Collectors.toMap(new PreferredSettingsUtils$$ExternalSyntheticLambda1(), new PreferredSettingsUtils$$ExternalSyntheticLambda2(), new PreferredSettingsUtils$$ExternalSyntheticLambda3()))).keySet();
        r4.retainAll(((Map) r13.stream().collect(Collectors.toMap(new PreferredSettingsUtils$$ExternalSyntheticLambda4(), new PreferredSettingsUtils$$ExternalSyntheticLambda5(), new PreferredSettingsUtils$$ExternalSyntheticLambda33()))).keySet());
        List r14 = (List) r12.stream().filter(new PreferredSettingsUtils$$ExternalSyntheticLambda36(r4)).collect(Collectors.toList());
        List r15 = (List) r13.stream().filter(new PreferredSettingsUtils$$ExternalSyntheticLambda37(r4)).collect(Collectors.toList());
        if (r7 == null) goto L21;
        String r16 = getDefaultAppByCategory(r7);
        if (TextUtils.isEmpty(r16) == true) goto L21;
        sortByDefaultApp(r16, r14);
        sortByDefaultApp(r16, r15);
    L21:
        HashMap r17 = new HashMap();
        r17.put("android.intent.action.VIEW", r14);
        r17.put("android.intent.action.SEND", r15);
        return r17;
    L24:
        return Collections.EMPTY_MAP;
    }

    static /* synthetic */ boolean lambda$loadSeeAndSendResolveInfoMap$26(FileType r0) {
        return !TextUtils.isEmpty(r0.getMimeType());
    }

    static /* synthetic */ Stream lambda$loadSeeAndSendResolveInfoMap$27(FileType r1) {
        return Stream.of(r1.getMimeType().split(";"));
    }

    static /* synthetic */ Object lambda$loadSeeAndSendResolveInfoMap$28(ResolveInfo r2) {
        return r2.activityInfo.packageName + r2.activityInfo.name;
    }

    static /* synthetic */ Object lambda$loadSeeAndSendResolveInfoMap$29(ResolveInfo r2) {
        return r2.activityInfo.packageName + r2.activityInfo.name;
    }

    static /* synthetic */ String lambda$loadSeeAndSendResolveInfoMap$30(ResolveInfo r2) {
        return r2.activityInfo.packageName + r2.activityInfo.name;
    }

    static /* synthetic */ String lambda$loadSeeAndSendResolveInfoMap$33(ResolveInfo r2) {
        return r2.activityInfo.packageName + r2.activityInfo.name;
    }

    static /* synthetic */ boolean lambda$loadSeeAndSendResolveInfoMap$36(Set r2, ResolveInfo r3) {
        return !r2.contains(r3.activityInfo.packageName + r3.activityInfo.name);
    }

    static /* synthetic */ boolean lambda$loadSeeAndSendResolveInfoMap$37(Set r2, ResolveInfo r3) {
        return r2.contains(r3.activityInfo.packageName + r3.activityInfo.name);
    }

    private static List<ResolveInfo> getResolveInfoListWithAction(Intent r0, PreferredActivityChooseUtils r1, String r2) {
        Intent r3 = r0.cloneFilter();
        r3.setAction(r2);
        r1.generateData(r3, false);
        return r1.getResolveInfoList();
    }

    private static void sortByDefaultApp(final String r2, List<ResolveInfo> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isEmpty() == true) goto L10;
        ResolveInfo r4 = r3.stream().filter(new PreferredSettingsUtils$$ExternalSyntheticLambda12(r2)).findFirst().orElse(null);
        if (r4 == null) goto L11;
        r3.remove(r3.indexOf(r4));
        r3.add(0, r4);
        return;
    L11:
        return;
    }

    static /* synthetic */ boolean lambda$sortByDefaultApp$38(String r0, ResolveInfo r1) {
        return r0.equals(r1.activityInfo.packageName);
    }
}
