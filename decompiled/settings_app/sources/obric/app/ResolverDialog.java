package obric.app;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActivityManager;
import android.app.AppGlobals;
import android.app.KeyguardManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import coil.util.Utils;
import com.android.settings.applications.PreferredSettingsUtils;
import com.android.settingslib.applications.RecentAppOpsAccess;
import java.lang.reflect.Method;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import obric.app.share.ShareItem;
import obric.time.HttpHeadTimeFetcher;
import obric.view.PagerAdapter;
import obric.view.ViewPager;
import obric.widget.MenuDialogTitleBar;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class ResolverDialog extends BaseResolverDialog {
    public static final String ALWAYS_USE_OPTION = "alwaysUseOption";
    private static final int ANDROID_SDK_OREO_VERSION = 26;
    private static final int CONSTRUCTOR_RESULT_DEFAULT = 0;
    private static final int CONSTRUCTOR_RESULT_FAIL = 1;
    private static final int CONSTRUCTOR_RESULT_ONE = 3;
    private static final int CONSTRUCTOR_RESULT_ZERO = 2;
    private static final boolean DEBUG = false;
    private static final String EXTRA_COPY_AND_TOAST = "android.intent.extra.CLICK_TOAST";
    public static final String EXTRA_HAD_CHOOSE = "com.smartisanos.doppelganger.had_choose";
    public static final String FROM_PACKAGE = "doppelganger_from_package";
    static final int IconShadowNoColor = 0;
    public static final String KEY_WINDOW_TYPE = "window_type";
    private static final int RIGHT_HAND_MODE = 1;
    private static final String TAG = "ResolverDialog";
    private static final String USERID = "userId";
    private boolean isOnlyCustomItems;
    private ResolveInfoListBuilder mAdapter;
    private boolean mAlwaysUseOption;
    private AppSpecialAction mAppSpecialAction;
    private View mBorderView;
    private String mCallingPackage;
    private View.OnClickListener mCancelBtnListener;
    private View mConfirmPage;
    private TextView mConfirmText;
    private View mConfirmZone;
    private final int mConfirmZoneHeight;
    private int mConstructorResult;
    private View mContentView;
    private Context mContext;
    private int mCurrentUser;
    private final int mDisplayWidth;
    private TextView mDragTip;
    private ImageView mFloatView;
    private int mIconDpi;
    private int mIconShadowColor;
    private IndicatorView mIndicatorView;
    private boolean mIsOneRow;
    private String mLaunchedFromPackage;
    private int mLaunchedFromUid;
    private int mLaunchedFromUserId;
    private int mMaxGridColumnNum;
    private int mMaxPageGridCount;
    private DialogInterface.OnClickListener mOnClickListener;
    private ResolvePagerAdapter mPageOffsetAdapter;
    private PackageManager mPm;
    private int mTextMaxWidth;
    private ViewPager mViewPager;

    private class AppSpecialAction {
        private String mCopiedToastText;
        private String mLinkToCopy;
        private boolean mSortInitial;
        final /* synthetic */ ResolverDialog this$0;

        static /* synthetic */ boolean access$1800(AppSpecialAction r0) {
            return r0.mSortInitial;
        }

        public AppSpecialAction(final ResolverDialog this$0, Intent intent) {
            this.this$0 = this$0;
            if (ResolverDialog.access$000(this$0) == false) goto L5;
        L7:
            this.mSortInitial = intent.getBooleanExtra("sort_initial_intents", false);
            ResolverDialog.access$102(this$0, intent.getStringExtra("calling_package"));
            return;
        L5:
            if (intent.hasExtra(ResolverDialog.EXTRA_COPY_AND_TOAST) == false) goto L7;
            this.mLinkToCopy = intent.getStringExtra("android.intent.extra.TEXT");
            this.mCopiedToastText = intent.getStringExtra(ResolverDialog.EXTRA_COPY_AND_TOAST);
            goto L7
        }

        public void performBrowserAction() {
            if (TextUtils.isEmpty(this.mLinkToCopy) == true) goto L6;
            ((ClipboardManager) ResolverDialog.access$200(this.this$0).getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, this.mLinkToCopy));
            Toast.makeText(ResolverDialog.access$200(this.this$0), this.mCopiedToastText, 1).show();
            return;
        }

        public boolean shouldSortInitial() {
            return this.mSortInitial;
        }
    }

    private final class DisplayResolveInfo {
        Drawable displayIcon;
        CharSequence displayLabel;
        CharSequence extendedInfo;
        Intent origIntent;
        ResolveInfo ri;
        ShareItem shareItem;
        final /* synthetic */ ResolverDialog this$0;
        int userId;

        DisplayResolveInfo(final ResolverDialog this$0, ResolveInfo pri, CharSequence pLabel, CharSequence pInfo, Intent pOrigIntent, int userId) {
            this(this$0, pri, pLabel, pInfo, pOrigIntent, userId, null);
        }

        DisplayResolveInfo(final ResolverDialog this$0, ResolveInfo pri, CharSequence pLabel, CharSequence pInfo, Intent pOrigIntent, int userId, ShareItem shareItem) {
            this.this$0 = this$0;
            this.ri = pri;
            this.displayLabel = pLabel;
            this.extendedInfo = pInfo;
            this.origIntent = pOrigIntent;
            this.userId = userId;
            this.shareItem = shareItem;
        }

        public String getPackageName() {
            ResolveInfo r0 = this.ri;
            if (r0 != null) goto L6;
            return null;
        L6:
            ActivityInfo r1 = r0.activityInfo;
            ResolveInfo r2 = this.ri;
            if (r1 != null) goto L10;
            return r2.resolvePackageName;
        L10:
            return r2.activityInfo.packageName;
        }

        public String getActivityName() {
            ResolveInfo r0 = this.ri;
            if (r0 != null) goto L5;
            return null;
        L5:
            if (r0.activityInfo != null) goto L7;
            return null;
        L7:
            return this.ri.activityInfo.name;
        }

        public int getShareItemType() {
            ShareItem r0 = this.shareItem;
            if (r0 != null) goto L6;
            return -1;
        L6:
            return r0.getType();
        }
    }

    private static class MimeTypeClassificationsMap {
        private static final Set<String> AUDIO = null;
        private static final Set<String> IMAGE = null;
        private static final Set<String> TEXT = null;
        private static final Set<String> VIDEO = null;

        private MimeTypeClassificationsMap() {
        }

        static /* synthetic */ boolean access$500(String r0) {
            return contains(r0);
        }

        static {
            TEXT = new HashSet(Arrays.asList(new String[]{"application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.openxmlformats-officedocument.wordprocessingml.template", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/vnd.ms-excel", "text/csv", "application/vnd.ms-powerpoint", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "application/vnd.openxmlformats-officedocument.presentationml.slideshow", "application/vnd.openxmlformats-officedocument.presentationml.template", "application/pdf", "text/plain", "application/rtf", "application/vnd.oasis.opendocument.text", "text/markdown", "text/html"}));
            AUDIO = new HashSet(Arrays.asList(new String[]{"audio/mpeg", "audio/x-ms-wma", "audio/x-wav", "audio/aac-adts", "audio/flac", "audio/ogg", "audio/midi", "application/x-cdf", "audio/x-ape", "audio/amr", "audio/x-aiff", "application/x-mpegURL", "audio/mpegurl"}));
            VIDEO = new HashSet(Arrays.asList(new String[]{"video/mp4", "video/x-matroska", "video/quicktime", "video/x-msvideo", "video/x-flv", "video/rm", "video/3gpp", "video/x-ms-wmv", "video/x-ms-asf", "video/m4v", "video/mpeg", "video/MP2T", "video/ogg", "video/webm"}));
            IMAGE = new HashSet(Arrays.asList(new String[]{Utils.MIME_TYPE_JPEG, "image/png", "image/gif", "image/x-ms-bmp", "image/tiff", Utils.MIME_TYPE_WEBP, "image/svg+xml", "image/x-coreldraw", "image/x-adobe-dng"}));
        }

        private static boolean isTextClassification(String mimeType) {
            if (TextUtils.isEmpty(mimeType) == false) goto L7;
            return false;
        L7:
            return TEXT.contains(mimeType);
        }

        private static boolean contains(String mimeType) {
            if (TextUtils.isEmpty(mimeType) == false) goto L6;
            return false;
        L6:
            if (TEXT.contains(mimeType) == false) goto L8;
            return true;
        L8:
            if (AUDIO.contains(mimeType) == false) goto L10;
            return true;
        L10:
            if (VIDEO.contains(mimeType) == false) goto L12;
            return true;
        L12:
            if (IMAGE.contains(mimeType) == true) goto L19;
            return false;
        L19:
            return true;
        }

        public static Set<String> getClassificationSet(String mimeType) {
            if (TextUtils.isEmpty(mimeType) == false) goto L5;
            return null;
        L5:
            Set<String> r0 = TEXT;
            if (r0.contains(mimeType) == false) goto L8;
            return r0;
        L8:
            Set<String> r1 = AUDIO;
            if (r1.contains(mimeType) == false) goto L11;
            return r1;
        L11:
            Set<String> r2 = VIDEO;
            if (r2.contains(mimeType) == false) goto L14;
            return r2;
        L14:
            Set<String> r3 = IMAGE;
            if (r3.contains(mimeType) == false) goto L17;
            return r3;
        L17:
            return null;
        }
    }

    private final class ResolveInfoListBuilder {
        private static final String SIDEBAR_SHARE_ACTIVITY = "com.smartisanos.sidebar.ReceiveShareData";
        private final List<ResolveInfo> mBaseResolveList;
        Set<String> mDoppelgangerApps;
        private final Intent[] mInitialIntents;
        private final Intent mIntent;
        List<DisplayResolveInfo> mList;
        List<ResolveInfo> mOrigResolveList;
        private List<ShareItem> mShareItems;
        private final HashSet<String> mSmartisanSocialPackages;
        final /* synthetic */ ResolverDialog this$0;

        private class DisplayResolveInfoComparator implements Comparator<DisplayResolveInfo> {
            private ResolverComparator mResolverComparator;
            final /* synthetic */ ResolveInfoListBuilder this$1;

            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(DisplayResolveInfo a, DisplayResolveInfo b) {
                return compare2(a, b);
            }

            public DisplayResolveInfoComparator(final ResolveInfoListBuilder this$1) {
                this.this$1 = this$1;
                this.mResolverComparator = new ResolverComparator(this$1);
            }

            /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
            public final int compare2(DisplayResolveInfo a, DisplayResolveInfo b) {
                return this.mResolverComparator.compare2(a.ri, b.ri);
            }
        }

        private class ResolverComparator implements Comparator<ResolveInfo> {
            private static final int FLAG_SYSTEM_APP = 129;
            private final Collator mCollator;
            final /* synthetic */ ResolveInfoListBuilder this$1;

            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(ResolveInfo a, ResolveInfo b) {
                return compare2(a, b);
            }

            public ResolverComparator(final ResolveInfoListBuilder this$1) {
                this.this$1 = this$1;
                Collator r1 = Collator.getInstance();
                this.mCollator = r1;
                r1.setStrength(0);
            }

            /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
            public final int compare2(ResolveInfo a, ResolveInfo b) {
                int r0 = a.activityInfo.applicationInfo.flags & 129;
                int r1 = b.activityInfo.applicationInfo.flags & 129;
                if (r0 >= r1) goto L6;
                return 1;
            L6:
                if (r0 <= r1) goto L8;
                return -1;
            L8:
                boolean r2 = ResolveInfoListBuilder.access$600(this.this$1).contains(a.activityInfo.packageName);
                boolean r3 = ResolveInfoListBuilder.access$600(this.this$1).contains(b.activityInfo.packageName);
                if (r2 == false) goto L12;
                if (r3 == true) goto L12;
                return -1;
            L12:
                if (r2 == true) goto L15;
                if (r3 == false) goto L15;
                return 1;
            L15:
                CharSequence r4 = a.loadLabel(ResolverDialog.access$700(this.this$1.this$0));
                if (r4 != null) goto L18;
                r4 = a.activityInfo.name;
            L18:
                CharSequence r6 = b.loadLabel(ResolverDialog.access$700(this.this$1.this$0));
                if (r6 != null) goto L22;
                r6 = b.activityInfo.name;
            L22:
                return this.mCollator.compare(r4.toString(), r6.toString());
            }
        }

        static /* synthetic */ HashSet access$600(ResolveInfoListBuilder r0) {
            return r0.mSmartisanSocialPackages;
        }

        public ResolveInfoListBuilder(final ResolverDialog this$0, Intent intent, Intent[] initialIntents, List<ResolveInfo> rList) {
            this(this$0, intent, initialIntents, rList, null);
        }

        public ResolveInfoListBuilder(final ResolverDialog this$0, Intent intent, Intent[] initialIntents, List<ResolveInfo> rList, List<ShareItem> shareItems) {
            this.this$0 = this$0;
            this.mDoppelgangerApps = new HashSet();
            this.mIntent = new Intent(intent);
            this.mInitialIntents = initialIntents;
            this.mBaseResolveList = rList;
            this.mShareItems = shareItems;
            this.mList = new ArrayList();
            String[] r2 = ResolverDialog.access$200(this$0).getResources().getStringArray(ResolverDialog.access$200(this$0).getResources().getIdentifier("obric_app_social_notification", "array", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME));
            this.mSmartisanSocialPackages = new HashSet(r2.length);
            int r3 = 0;
        L4:
            if (r3 >= r2.length) goto L6;
            this.mSmartisanSocialPackages.add(r2[r3]);
            r3 = r3 + 1;
            goto L4
        L6:
            rebuildList();
        }

        public void initAdapter() {
            AnonymousClass1 r1 = null;
            if (ResolverDialog.access$300(this.this$0) != null) goto L5;
            ResolverDialog.access$302(this.this$0, new ResolvePagerAdapter(this.this$0, r1));
        L5:
            ArrayList r0 = new ArrayList();
            int r2 = getCount();
            int r3 = 0;
        L6:
            if (r3 >= r2) goto L11;
            DragGridView r4 = (DragGridView) LayoutInflater.from(ResolverDialog.access$200(this.this$0)).inflate(R.layout.resolver_grid, null).findViewById(R.id.gridView);
            ViewGroup r5 = (ViewGroup) r4.getParent();
            if (r5 == null) goto L10;
            r5.removeView(r4);
        L10:
            ResolverDialog r6 = this.this$0;
            ResolveListAdapter r7 = new ResolveListAdapter(r6, ResolverDialog.access$200(r6), r3, r4);
            r4.setAdapter(r7);
            r4.setChoiceMode(1);
            r4.setOnItemClickListener(new AnonymousClass1(this));
            r4.setDragEnabled(ResolverDialog.access$000(this.this$0));
            r4.setDragListener(r7);
            r4.initFloatViewAnimator(ResolverDialog.access$1300(this.this$0), ResolverDialog.access$1400(this.this$0));
            r0.add(r4);
            r3 = r3 + ResolverDialog.access$900(this.this$0);
            goto L6
        L11:
            ResolverDialog.access$300(this.this$0).setList(r0);
        }

        public void handlePackagesChanged() {
            if (ResolverDialog.access$300(this.this$0) != null) goto L5;
            return;
        L5:
            int r0 = ResolverDialog.access$300(this.this$0).getCount();
            rebuildList();
            initAdapter();
            ResolverDialog.access$300(this.this$0).notifyDataSetChanged();
            if (getCount() > 0) goto L8;
            this.this$0.dismiss();
        L8:
            int r1 = ResolverDialog.access$300(this.this$0).getCount();
            if (r1 != r0) goto L11;
            return;
        L11:
            if (ResolverDialog.access$400(this.this$0) == null) goto L15;
            ResolverDialog.access$400(this.this$0).setState(r1);
            return;
        }

        private void rebuildList() {
            this.mList.clear();
            List<ResolveInfo> r0 = this.mBaseResolveList;
            if (r0 == null) goto L5;
            this.mOrigResolveList = null;
        L25:
            if (r0 == null) goto L99;
            int r3 = r0.size();
            if (r3 <= 0) goto L100;
            ResolveInfo r4 = r0.get(0);
            int r5 = 1;
        L29:
            if (r5 >= r3) goto L40;
            ResolveInfo r6 = r0.get(r5);
            if (r4.priority != r6.priority) goto L34;
            if (r4.isDefault != r6.isDefault) goto L34;
        L39:
            r5 = r5 + 1;
        L34:
            if (r5 >= r3) goto L39;
            if (this.mOrigResolveList != r0) goto L38;
            this.mOrigResolveList = new ArrayList(this.mOrigResolveList);
        L38:
            r0.remove(r5);
            r3 = r3 - 1;
            goto L34
        L40:
            if (r3 <= 1) goto L43;
            Collections.sort(r0, new ResolverComparator(this));
        L43:
            if (this.mInitialIntents == null) goto L61;
            int r7 = 0;
        L45:
            Intent[] r8 = this.mInitialIntents;
            if (r7 >= r8.length) goto L61;
            Intent r12 = r8[r7];
            if (r12 == null) goto L60;
            ActivityInfo r9 = r12.resolveActivityInfo(ResolverDialog.access$200(this.this$0).getPackageManager(), 0);
            if (r9 != null) goto L54;
            Log.w("ResolverActivity", "No activity found for " + r12);
            goto L60
        L54:
            if (ActivityManager.checkComponentPermission(r9.permission, ResolverDialog.access$1500(this.this$0), r9.applicationInfo.uid, r9.exported) == 0) goto L56;
            Log.w("ResolverActivity", "Permission deny " + r12);
            goto L60
        L56:
            ResolveInfo r10 = new ResolveInfo();
            r10.activityInfo = r9;
            if ((r12 instanceof LabeledIntent) == false) goto L59;
            LabeledIntent r11 = (LabeledIntent) r12;
            r10.resolvePackageName = r11.getSourcePackage();
            r10.labelRes = r11.getLabelResource();
            r10.nonLocalizedLabel = r11.getNonLocalizedLabel();
            r10.icon = r11.getIconResource();
        L59:
            ResolverDialog r13 = this.this$0;
            addResolveInfo(new DisplayResolveInfo(r13, r10, r10.loadLabel(ResolverDialog.access$200(r13).getPackageManager()), null, r12, ResolverDialog.access$1600(this.this$0)));
        L60:
            r7 = r7 + 1;
        L61:
            ResolveInfo r14 = r0.get(0);
            int r15 = 0;
            int r1 = 1;
            ResolveInfo r16 = r14;
            CharSequence r17 = r14.loadLabel(ResolverDialog.access$700(this.this$0));
        L62:
            if (r1 >= r3) goto L73;
            if (r17 != null) goto L65;
            r17 = r16.activityInfo.packageName;
        L65:
            ResolveInfo r18 = r0.get(r1);
            CharSequence r19 = r18.loadLabel(ResolverDialog.access$700(this.this$0));
            if (r19 != null) goto L68;
            r19 = r18.activityInfo.packageName;
        L68:
            CharSequence r110 = r19;
            if (r110.equals(r17) == true) goto L72;
            processGroup(r0, r15, r1 - 1, r16, r17);
            r15 = r1;
            r16 = r18;
            r17 = r110;
        L72:
            r1 = r1 + 1;
            goto L62
        L73:
            processGroup(r0, r15, r3 - 1, r16, r17);
            if (AppSpecialAction.access$1800(ResolverDialog.access$1700(this.this$0)) == true) goto L76;
        L78:
            addShareItemAndSort();
            return;
        L76:
            if (this.mList.size() <= 1) goto L78;
            Collections.sort(this.mList, new DisplayResolveInfoComparator(this));
            goto L78
        L100:
            return;
        L99:
            return;
        L5:
            PackageManager r2 = ResolverDialog.access$700(this.this$0);
            Intent r20 = this.mIntent;
            if (ResolverDialog.access$000(this.this$0) == false) goto L8;
            int r21 = 64;
        L9:
            r0 = r2.queryIntentActivities(r20, r21 | 65536);
            this.mOrigResolveList = r0;
            if (r0 == null) goto L25;
            int r22 = r0.size() - 1;
        L12:
            if (r22 < 0) goto L25;
            ActivityInfo r23 = r0.get(r22).activityInfo;
            if (ActivityManager.checkComponentPermission(r23.permission, ResolverDialog.access$1500(this.this$0), r23.applicationInfo.uid, r23.exported) == 0) goto L20;
            if (this.mOrigResolveList != r0) goto L18;
            this.mOrigResolveList = new ArrayList(this.mOrigResolveList);
        L18:
            r0.remove(r22);
        L24:
            r22 = r22 - 1;
            goto L12
        L20:
            if (ResolverDialog.access$100(this.this$0) == null) goto L24;
            if (ResolverDialog.access$100(this.this$0).equals(r23.packageName) == false) goto L24;
            r0.remove(r22);
            goto L24
        L8:
            r21 = 0;
            goto L9
        }

        private void addShareItemAndSort() {
            List<ShareItem> r0 = this.mShareItems;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isEmpty() == true) goto L44;
            ArrayList r1 = new ArrayList();
            Iterator<ShareItem> r2 = this.mShareItems.iterator();
        L9:
            if (r2.hasNext() == false) goto L24;
            ShareItem r3 = r2.next();
            if (r3.getType() == 2) goto L12;
            if (r3.getType() == 1) goto L17;
            if (r3.getType() != 3) goto L9;
            removeExcludeShareItem(r3.getPackageName(), r3.getActivityName());
            goto L9
        L17:
            DisplayResolveInfo r4 = findByPackageOrActivity(r3.getPackageName(), r3.getActivityName());
            if (r4 == null) goto L9;
            this.mList.remove(r4);
            r1.add(r4);
            goto L9
        L12:
            DisplayResolveInfo r5 = createShareItemDisplayResolveInfo(r3, null);
            if (r5 == null) goto L9;
            r1.add(r5);
            goto L9
        L24:
            if (r1.size() <= 0) goto L43;
            this.mList.addAll(0, r1);
            r1.clear();
            return;
        L43:
            return;
        }

        private void removeExcludeShareItem(String packageName, String activityName) {
            if (packageName != null) goto L6;
            if (activityName != null) goto L6;
            return;
        L6:
            if (packageName == null) goto L9;
            if (activityName != null) goto L9;
            boolean r2 = true;
        L10:
            ListIterator<DisplayResolveInfo> r5 = this.mList.listIterator();
        L12:
            if (r5.hasNext() == false) goto L30;
            DisplayResolveInfo r3 = r5.next();
            if (activityName != null) goto L16;
        L19:
            boolean r4 = true;
        L20:
            if (packageName != null) goto L22;
        L25:
            boolean r6 = true;
        L26:
            if (r4 == false) goto L29;
            if (r6 == false) goto L29;
            r5.remove();
        L29:
            if (r2 == true) goto L12;
            return;
        L22:
            if (TextUtils.equals(packageName, r3.getPackageName()) == true) goto L25;
            r6 = false;
            goto L26
        L16:
            if (TextUtils.equals(activityName, r3.getActivityName()) == true) goto L19;
            r4 = false;
            goto L20
        L30:
            return;
        L9:
            r2 = false;
            goto L10
        }

        private DisplayResolveInfo createShareItemDisplayResolveInfo(ShareItem item, CharSequence givenLabel) {
            if (ShareItem.isValidCustomShareItem(item) == true) goto L6;
            Log.d(ResolverDialog.TAG, " ShareItem is not a valid parameter: " + item);
            return null;
        L6:
            ResolveInfo r2 = new ResolveInfo();
            r2.resolvePackageName = item.getPackageName();
            r2.labelRes = item.getLabelResId();
            r2.icon = item.getImgResId();
            ResolverDialog r1 = this.this$0;
            if (givenLabel != null) goto L10;
            givenLabel = r2.loadLabel(ResolverDialog.access$200(r1).getPackageManager());
        L10:
            return new DisplayResolveInfo(r1, r2, givenLabel, null, null, ResolverDialog.access$1600(this.this$0), item);
        }

        private DisplayResolveInfo findByPackageOrActivity(String packageName, String activityName) {
            if (packageName != null) goto L6;
            if (activityName != null) goto L6;
        L7:
            return null;
        L6:
            if (this.mList.isEmpty() == true) goto L7;
            Iterator<DisplayResolveInfo> r6 = this.mList.iterator();
        L10:
            if (r6.hasNext() == false) goto L25;
            DisplayResolveInfo r1 = r6.next();
            boolean r2 = false;
            if (activityName != null) goto L14;
        L17:
            boolean r4 = true;
        L18:
            if (packageName != null) goto L20;
        L21:
            r2 = true;
        L22:
            if (r4 == false) goto L10;
            if (r2 == false) goto L10;
            return r1;
        L20:
            if (TextUtils.equals(packageName, r1.getPackageName()) == false) goto L22;
        L14:
            if (TextUtils.equals(activityName, r1.getActivityName()) == true) goto L17;
            r4 = false;
            goto L18
        L25:
            return null;
        }

        private void processGroup(List<ResolveInfo> rList, int start, int end, ResolveInfo ro, CharSequence roLabel) {
            boolean r1 = true;
            if (((end - start) + 1) != 1) goto L5;
            ResolverDialog r3 = this.this$0;
            addResolveInfo(new DisplayResolveInfo(r3, ro, roLabel, null, null, ResolverDialog.access$1600(r3)));
            return;
        L5:
            CharSequence r13 = ro.activityInfo.applicationInfo.loadLabel(ResolverDialog.access$700(this.this$0));
            if (r13 != null) goto L8;
            boolean r0 = true;
        L9:
            if (r0 == true) goto L20;
            HashSet r2 = new HashSet();
            r2.add(r13);
            int r14 = start + 1;
        L11:
            if (r14 > end) goto L18;
            CharSequence r4 = rList.get(r14).activityInfo.applicationInfo.loadLabel(ResolverDialog.access$700(this.this$0));
            if (r4 == null) goto L19;
            if (r2.contains(r4) == true) goto L19;
            r2.add(r4);
            r14 = r14 + 1;
        L19:
            r2.clear();
            r0 = r1;
            goto L20
        L18:
            r1 = r0;
        L20:
            if (start > end) goto L34;
            ResolveInfo r5 = rList.get(start);
            if (r0 == false) goto L24;
            addResolveInfo(new DisplayResolveInfo(this.this$0, r5, roLabel, r5.activityInfo.packageName, null, ResolverDialog.access$1600(this.this$0)));
        L25:
            start = start + 1;
            goto L20
        L24:
            addResolveInfo(new DisplayResolveInfo(this.this$0, r5, roLabel, r5.activityInfo.applicationInfo.loadLabel(ResolverDialog.access$700(this.this$0)), null, ResolverDialog.access$1600(this.this$0)));
            goto L25
        L34:
            return;
        L8:
            r0 = false;
            goto L9
        }

        private void addResolveInfo(DisplayResolveInfo dri) {
            if (ResolverDialog.access$1900(this.this$0) == false) goto L6;
            return;
        L6:
            if (ResolverDialog.access$1600(this.this$0) != ResolverDialog.access$2000(this.this$0)) goto L8;
        L9:
            this.mList.add(dri);
            return;
        L8:
            if (TextUtils.equals(dri.ri.activityInfo.packageName, ResolverDialog.access$2100(this.this$0)) == false) goto L9;
        }

        public ResolveInfo resolveInfoForPosition(int position) {
            return this.mList.get(position).ri;
        }

        public DisplayResolveInfo displayResolveInfoForPosition(int position) {
            return this.mList.get(position);
        }

        public Intent intentForPosition(int position) {
            DisplayResolveInfo r5 = this.mList.get(position);
            if (r5.origIntent == null) goto L5;
            Intent r1 = r5.origIntent;
        L6:
            Intent r0 = new Intent(r1);
            r0.addFlags(50331648);
            ActivityInfo r2 = r5.ri.activityInfo;
            r0.setComponent(new ComponentName(r2.applicationInfo.packageName, r2.name));
            r0.putExtra(ResolverDialog.FROM_PACKAGE, ResolverDialog.access$2100(this.this$0));
            r0.putExtra(ResolverDialog.EXTRA_HAD_CHOOSE, true);
            r0.putExtra("userId", r5.userId);
            return r0;
        L5:
            r1 = this.mIntent;
            goto L6
        }

        public int getCount() {
            return this.mList.size();
        }
    }

    private final class ResolveListAdapter extends BaseAdapter implements DragGridView.DragListener {
        private static final float TIP_DISABLE_ALPHA = 0.302f;
        private static final float TIP_ENABLE_ALPHA = 0.8f;
        private final float iconMaxWidth;
        private DragGridView mDragGridView;
        private final LayoutInflater mInflater;
        private final int mPageOffset;
        private final int size;
        final /* synthetic */ ResolverDialog this$0;

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        static /* synthetic */ int access$1100(ResolveListAdapter r0) {
            return r0.mPageOffset;
        }

        static /* synthetic */ DragGridView access$3000(ResolveListAdapter r0) {
            return r0.mDragGridView;
        }

        public ResolveListAdapter(final ResolverDialog this$0, Context context, int page, DragGridView view) {
            this.this$0 = this$0;
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
            this.mPageOffset = page;
            this.iconMaxWidth = context.getResources().getDimension(R.dimen.icon_size);
            int r3 = ResolverDialog.access$2200(this$0).mList.size();
            if ((ResolverDialog.access$900(this$0) + page) > r3) goto L5;
            this.size = ResolverDialog.access$900(this$0);
        L6:
            this.mDragGridView = view;
            return;
        L5:
            this.size = r3 - page;
            goto L6
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.size;
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView != null) goto L4;
            convertView = this.mInflater.inflate(R.layout.resolver_grid_item, parent, false);
            convertView.setTag(new ViewHolder(this.this$0, convertView));
        L4:
            bindView(convertView, position);
            return convertView;
        }

        private final void bindView(View view, final int position) {
            ViewHolder r8 = (ViewHolder) view.getTag();
            DisplayResolveInfo r9 = ResolverDialog.access$2200(this.this$0).mList.get(this.mPageOffset + position);
            r8.text.setMaxWidth(ResolverDialog.access$2300(this.this$0));
            r8.text.setText(r9.displayLabel);
            if (r9.displayIcon != null) goto L19;
            r9.displayIcon = ResolverDialog.access$2400(this.this$0, r9);
            float r0 = r9.displayIcon.getMinimumHeight();
            float r1 = r9.displayIcon.getMinimumWidth();
            float r2 = this.iconMaxWidth;
            if (r0 > (r2 * 2.0f)) goto L9;
            if (r1 <= (r2 * 2.0f)) goto L19;
        L9:
            if ((r9.displayIcon instanceof BitmapDrawable) == false) goto L19;
            Bitmap r3 = ((BitmapDrawable) r9.displayIcon).getBitmap();
            String r4 = r9.getPackageName();
            ResolverDialog.access$2200(this.this$0).mDoppelgangerApps.contains(r4);
            Resources r5 = ResolverDialog.access$700(this.this$0).getResourcesForApplication(r4);     // Catch: PackageManager.NameNotFoundException -> L17 Exception -> L21
            if (r0 < r1) goto L14;
            float r6 = (this.iconMaxWidth * 2.0f) / r0;     // Catch: PackageManager.NameNotFoundException -> L17 Exception -> L21
        L15:
            r9.displayIcon = new BitmapDrawable(r5, scaleBitmap(r3, r6, false));     // Catch: PackageManager.NameNotFoundException -> L17 Exception -> L21
            goto L19
        L14:
            r6 = (this.iconMaxWidth * 2.0f) / r1;     // Catch: PackageManager.NameNotFoundException -> L17 Exception -> L21
        L17:
            e = move-exception;
            e.printStackTrace();
        L19:
            r8.icon.setImageDrawable(r9.displayIcon);
        }

        private Bitmap scaleBitmap(Bitmap origin, float ratio, boolean recycleOld) {
            if (origin != null) goto L4;
            return null;
        L4:
            if (origin.isRecycled() == true) goto L14;
            int r3 = origin.getWidth();
            int r4 = origin.getHeight();
            Matrix r5 = new Matrix();
            r5.postScale(ratio, ratio);
            Bitmap r7 = Bitmap.createBitmap(origin, 0, 0, r3, r4, r5, true);
            if (r7.equals(origin) == false) goto L9;
            return r7;
        L9:
            if (recycleOld == false) goto L11;
            origin.recycle();
        L11:
            return r7;
        L14:
            return null;
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            return ResolverDialog.access$2200(this.this$0).mList.get(this.mPageOffset + position);
        }

        @Override // obric.app.DragGridView.DragListener
        public void onPressedDown() {
            float r0 = ResolverDialog.access$200(this.this$0).getResources().getDimension(R.dimen.drag_tip_translation);
            this.mDragGridView.setBorder(ResolverDialog.access$2500(this.this$0).getTop() + (((int) r0) * 2));
            AnimatorSet r1 = new AnimatorSet();
            r1.playTogether(new Animator[]{makeTranslationAnimator(ResolverDialog.access$2600(this.this$0), ResolverDialog.access$2600(this.this$0).getTranslationY(), r0), makeTranslationAnimator(ResolverDialog.access$2500(this.this$0), ResolverDialog.access$2500(this.this$0).getTranslationY(), r0 * 2.0f)});
            r1.start();
        }

        @Override // obric.app.DragGridView.DragListener
        public void onPressedCancel() {
            AnimatorSet r0 = new AnimatorSet();
            r0.playTogether(new Animator[]{makeTranslationAnimator(ResolverDialog.access$2600(this.this$0), ResolverDialog.access$2600(this.this$0).getTranslationY(), 0.0f), makeTranslationAnimator(ResolverDialog.access$2500(this.this$0), ResolverDialog.access$2500(this.this$0).getTranslationY(), 0.0f)});
            r0.start();
        }

        @Override // obric.app.DragGridView.DragListener
        public void onCrossBorder(boolean into) {
            TextView r0 = ResolverDialog.access$2600(this.this$0);
            if (into == false) goto L5;
            float r1 = 0.8f;
        L6:
            r0.setAlpha(r1);
            return;
        L5:
            r1 = TIP_DISABLE_ALPHA;
            goto L6
        }

        Animator makeTranslationAnimator(View v, float from, float to) {
            ObjectAnimator r2 = ObjectAnimator.ofFloat(v, View.TRANSLATION_Y, new float[]{from, to});
            r2.setInterpolator(new DecelerateInterpolator(1.5f));
            r2.setDuration(300);
            return r2;
        }

        Animator makeAlphaAnimator(View v, float from, float to, long duration, int setRepeatCount) {
            ObjectAnimator r3 = ObjectAnimator.ofFloat(v, View.ALPHA, new float[]{from, to});
            r3.setDuration(duration);
            if (setRepeatCount <= 0) goto L5;
            r3.setRepeatCount(setRepeatCount);
            r3.setRepeatMode(2);
        L6:
            return r3;
        L5:
            r3.setInterpolator(new DecelerateInterpolator(1.5f));
            goto L6
        }

        void animateConfirmPage(final boolean vis) {
            float r0 = 0.0f;
            if (vis == false) goto L5;
            float r5 = 1.0f;
        L6:
            if (vis == true) goto L9;
            r0 = ResolverDialog.access$2700(this.this$0);
        L9:
            AnimatorSet r1 = new AnimatorSet();
            r1.playTogether(new Animator[]{makeAlphaAnimator(ResolverDialog.access$2800(this.this$0), ResolverDialog.access$2800(this.this$0).getAlpha(), r5, 300, 0), makeTranslationAnimator(ResolverDialog.access$2900(this.this$0), ResolverDialog.access$2900(this.this$0).getTranslationY(), r0)});
            if (vis == false) goto L12;
            r1.addListener(new AnonymousClass1(this));
        L13:
            r1.start();
            return;
        L12:
            this.mDragGridView.setEnabled(true);
            goto L13
        L5:
            r5 = 0.0f;
            goto L6
        }

        @Override // obric.app.DragGridView.DragListener
        public View onStartDrag(ImageView v) {
            makeAlphaAnimator(ResolverDialog.access$2600(this.this$0), TIP_DISABLE_ALPHA, 0.8f, 150, 3).start();
            if (ResolverDialog.access$3100(this.this$0) != null) goto L5;
            ResolverDialog r0 = this.this$0;
            ResolverDialog.access$3102(r0, (ImageView) r0.findViewById(R.id.floatView));
        L5:
            ResolverDialog.access$3100(this.this$0).setImageDrawable(v.getDrawable());
            return ResolverDialog.access$3100(this.this$0);
        }

        @Override // obric.app.DragGridView.DragListener
        public void onStopDrag(final int src, boolean crossBorder, final View.OnClickListener callback) {
            if (crossBorder == true) goto L4;
            onPressedCancel();
            return;
        L4:
            if (ResolverDialog.access$2800(this.this$0) != null) goto L9;
            ResolverDialog r4 = this.this$0;
            ResolverDialog.access$2802(r4, r4.findViewById(R.id.confirmPage));
            ResolverDialog.access$2800(this.this$0).setAlpha(0.0f);
            ResolverDialog.access$2800(this.this$0).setVisibility(0);
            ResolverDialog r5 = this.this$0;
            ResolverDialog.access$3202(r5, (TextView) r5.findViewById(R.id.confirmText));
            if (ResolverDialog.access$1300(this.this$0) == false) goto L8;
            ResolverDialog.access$3200(this.this$0).setTranslationY(ResolverDialog.access$200(this.this$0).getResources().getDimension(R.dimen.confirm_text_trans_y));
        L8:
            ResolverDialog r6 = this.this$0;
            ResolverDialog.access$2902(r6, r6.findViewById(R.id.confirmZone));
        L9:
            animateConfirmPage(true);
            ((Button) this.this$0.findViewById(R.id.confirmCancel)).setOnClickListener(new AnonymousClass2(this, callback));
            ((Button) this.this$0.findViewById(R.id.confirmOk)).setOnClickListener(new AnonymousClass3(this, src));
        }
    }

    private final class ResolvePagerAdapter extends PagerAdapter {
        private List<GridView> mGridList;
        final /* synthetic */ ResolverDialog this$0;

        @Override // obric.view.PagerAdapter
        public boolean isViewFromObject(View arg0, Object arg1) {
            if (arg0 != arg1) goto L4;
            return true;
        L4:
            return false;
        }

        private ResolvePagerAdapter(final ResolverDialog this$0) {
            this.this$0 = this$0;
        }

        /* synthetic */ ResolvePagerAdapter(ResolverDialog r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void setList(List<GridView> gList) {
            this.mGridList = gList;
        }

        @Override // obric.view.PagerAdapter
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager) container).removeView((View) object);
        }

        @Override // obric.view.PagerAdapter
        public Object instantiateItem(View container, int position) {
            ((ViewPager) container).addView(this.mGridList.get(position));
            return this.mGridList.get(position);
        }

        @Override // obric.view.PagerAdapter
        public int getCount() {
            List<GridView> r0 = this.mGridList;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        @Override // obric.view.PagerAdapter
        public int getItemPosition(Object object) {
            int r0 = this.mGridList.indexOf(object);
            if (r0 != (-1)) goto L6;
            return -2;
        L6:
            return r0;
        }
    }

    public class ViewHolder {
        public ImageView icon;
        public TextView text;
        final /* synthetic */ ResolverDialog this$0;

        public ViewHolder(final ResolverDialog this$0, View view) {
            this.this$0 = this$0;
            this.text = (TextView) view.findViewById(R.id.icon_text);
            this.icon = (ImageView) view.findViewById(R.id.icon_image);
        }
    }

    private void finishSuperActivity() {
    }

    static /* synthetic */ boolean access$000(ResolverDialog r0) {
        return r0.mAlwaysUseOption;
    }

    static /* synthetic */ String access$100(ResolverDialog r0) {
        return r0.mCallingPackage;
    }

    static /* synthetic */ int access$1000(ResolverDialog r0) {
        return r0.mIconShadowColor;
    }

    static /* synthetic */ String access$102(ResolverDialog r0, String r1) {
        r0.mCallingPackage = r1;
        return r1;
    }

    static /* synthetic */ void access$1200(ResolverDialog r0, int r1, boolean r2) {
        r0.startSelected(r1, r2);
    }

    static /* synthetic */ boolean access$1300(ResolverDialog r0) {
        return r0.mIsOneRow;
    }

    static /* synthetic */ int access$1400(ResolverDialog r0) {
        return r0.mDisplayWidth;
    }

    static /* synthetic */ int access$1500(ResolverDialog r0) {
        return r0.mLaunchedFromUid;
    }

    static /* synthetic */ int access$1600(ResolverDialog r0) {
        return r0.mCurrentUser;
    }

    static /* synthetic */ AppSpecialAction access$1700(ResolverDialog r0) {
        return r0.mAppSpecialAction;
    }

    static /* synthetic */ boolean access$1900(ResolverDialog r0) {
        return r0.isOnlyCustomItems;
    }

    static /* synthetic */ Context access$200(ResolverDialog r0) {
        return r0.mContext;
    }

    static /* synthetic */ int access$2000(ResolverDialog r0) {
        return r0.mLaunchedFromUserId;
    }

    static /* synthetic */ String access$2100(ResolverDialog r0) {
        return r0.mLaunchedFromPackage;
    }

    static /* synthetic */ ResolveInfoListBuilder access$2200(ResolverDialog r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ int access$2300(ResolverDialog r0) {
        return r0.mTextMaxWidth;
    }

    static /* synthetic */ Drawable access$2400(ResolverDialog r0, DisplayResolveInfo r1) {
        return r0.loadIconForResolveInfo(r1);
    }

    static /* synthetic */ View access$2500(ResolverDialog r0) {
        return r0.mBorderView;
    }

    static /* synthetic */ TextView access$2600(ResolverDialog r0) {
        return r0.mDragTip;
    }

    static /* synthetic */ int access$2700(ResolverDialog r0) {
        return r0.mConfirmZoneHeight;
    }

    static /* synthetic */ View access$2800(ResolverDialog r0) {
        return r0.mConfirmPage;
    }

    static /* synthetic */ View access$2802(ResolverDialog r0, View r1) {
        r0.mConfirmPage = r1;
        return r1;
    }

    static /* synthetic */ View access$2900(ResolverDialog r0) {
        return r0.mConfirmZone;
    }

    static /* synthetic */ View access$2902(ResolverDialog r0, View r1) {
        r0.mConfirmZone = r1;
        return r1;
    }

    static /* synthetic */ ResolvePagerAdapter access$300(ResolverDialog r0) {
        return r0.mPageOffsetAdapter;
    }

    static /* synthetic */ ResolvePagerAdapter access$302(ResolverDialog r0, ResolvePagerAdapter r1) {
        r0.mPageOffsetAdapter = r1;
        return r1;
    }

    static /* synthetic */ ImageView access$3100(ResolverDialog r0) {
        return r0.mFloatView;
    }

    static /* synthetic */ ImageView access$3102(ResolverDialog r0, ImageView r1) {
        r0.mFloatView = r1;
        return r1;
    }

    static /* synthetic */ TextView access$3200(ResolverDialog r0) {
        return r0.mConfirmText;
    }

    static /* synthetic */ TextView access$3202(ResolverDialog r0, TextView r1) {
        r0.mConfirmText = r1;
        return r1;
    }

    static /* synthetic */ IndicatorView access$400(ResolverDialog r0) {
        return r0.mIndicatorView;
    }

    static /* synthetic */ PackageManager access$700(ResolverDialog r0) {
        return r0.mPm;
    }

    static /* synthetic */ int access$900(ResolverDialog r0) {
        return r0.mMaxPageGridCount;
    }

    public ResolverDialog(Context context, Intent intent) {
        this(context, intent, null, null, null, false);
    }

    ResolverDialog(Context context, Intent intent, CharSequence title, Intent[] initialIntents, List<ResolveInfo> rList, boolean alwaysUseOption) {
        this(context, intent, title, initialIntents, rList, alwaysUseOption, null);
    }

    ResolverDialog(Context context, Intent intent, CharSequence title, Intent[] initialIntents, List<ResolveInfo> rList, boolean alwaysUseOption, List<ShareItem> shareItems) {
        super(context, getResolverThemeId());
        this.mCancelBtnListener = new AnonymousClass2(this);
        if (intent != null) goto L67;
        this.mConfirmZoneHeight = 0;
        this.mDisplayWidth = 0;
        dismiss();
        Log.e(TAG, "ResolverDialog intent is null, finish it");
        return;
    L67:
        this.isOnlyCustomItems = intent.getBooleanExtra(ShareItem.EXTRA_SHARE_ITEM_ONLY_CUSTOM_ITEMS, false);     // Catch: Exception -> L8
    L10:
        this.mContext = context;
        this.mContentView = getLayoutInflater().inflate(R.layout.resolver_layout, null);
        Window r0 = getWindow();
        r0.getDecorView().setSystemUiVisibility(1024);
        setContentView(this.mContentView);
        if (intent.hasExtra("no_dim") == false) goto L13;
        r0.setDimAmount(0.0f);
    L13:
        r0.setGravity(80);
        Display r2 = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        Point r3 = new Point();
        r2.getRealSize(r3);
        WindowManager.LayoutParams r4 = r0.getAttributes();
        int r5 = r3.x;
        this.mDisplayWidth = r5;
        r4.width = r5;
        if (intent.hasExtra(KEY_WINDOW_TYPE) == false) goto L16;
        r4.type = intent.getIntExtra(KEY_WINDOW_TYPE, r4.type);
        r0.addFlags(524288);
    L16:
        r0.setAttributes(r4);
        r0.addFlags(android.R.id.mode_in);
        this.mConstructorResult = 0;
        int r1 = context.getResources().getDimensionPixelSize(R.dimen.confirm_zone_height);
        this.mConfirmZoneHeight = r1;
        int r6 = this.mLaunchedFromUid;
        boolean r10 = true;
        if (r6 >= 0) goto L19;
    L65:
        this.mConstructorResult = 1;
        return;
    L19:
        if (UserHandle.isIsolated(r6) == true) goto L65;
        this.mAlwaysUseOption = canAlwaysUse(alwaysUseOption, intent);
        this.mPm = this.mContext.getPackageManager();
        this.mIconDpi = ((ActivityManager) this.mContext.getSystemService("activity")).getLauncherLargeIconDensity();
        this.mCurrentUser = ActivityManager.getCurrentUser();
        Resources r11 = this.mContext.getResources();
        if ((r2.getRotation() & 1) != 0) goto L24;
        boolean r7 = true;
    L25:
        if (r7 == false) goto L27;
        int r8 = r11.getDimensionPixelSize(R.dimen.text_max_length_portrait);
    L28:
        this.mTextMaxWidth = r8;
        int r9 = r11.getInteger(R.integer.maxGridColumns);
        this.mMaxGridColumnNum = r9;
        this.mMaxPageGridCount = r9 * r11.getInteger(R.integer.maxGridRows);
        this.mIconShadowColor = r11.getColor(R.color.icon_shadow);
        this.mAppSpecialAction = new AppSpecialAction(this, intent);
        ResolveInfoListBuilder r12 = new ResolveInfoListBuilder(this, intent, initialIntents, rList, shareItems);
        this.mAdapter = r12;
        int r13 = r12.getCount();
        if (r13 > 1) goto L37;
        if (shareItems != null) goto L32;
    L34:
        if (r13 != 1) goto L36;
        this.mConstructorResult = 3;
        return;
    L36:
        this.mConstructorResult = 2;
        return;
    L32:
        if (shareItems.size() <= 0) goto L34;
    L37:
        if (r13 != 1) goto L39;
        this.mAlwaysUseOption = false;
    L39:
        View r14 = findViewById(R.id.contentPanel);
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r13 > this.mMaxPageGridCount) goto L47;
        int r16 = this.mMaxGridColumnNum;
        int r17 = ((r13 + r16) - 1) / r16;
        r15.height = (r11.getDimensionPixelSize(R.dimen.grid_item_height) * r17) + r11.getDimensionPixelSize(R.dimen.grid_bottom_padding);
        if (r17 == 1) goto L45;
        r10 = false;
    L45:
        this.mIsOneRow = r10;
    L47:
        if (this.mAlwaysUseOption == false) goto L49;
        r15.height += r1;
        View r18 = findViewById(R.id.border);
        this.mBorderView = r18;
        r18.setVisibility(0);
        TextView r19 = (TextView) findViewById(R.id.dragTip);
        this.mDragTip = r19;
        r19.setVisibility(0);
    L49:
        r14.setLayoutParams(r15);
        MenuDialogTitleBar r20 = (MenuDialogTitleBar) findViewById(R.id.menu_dialog_title_bar);
        if (title != null) goto L54;
        CharSequence r21 = intent.getCharSequenceExtra("android.intent.extra.TITLE");
        if (r21 != null) goto L55;
        r21 = r11.getText(R.string.chooseActivity);
    L55:
        r20.setTitle(r21);
        r20.forceRequestAccessibilityFocusWhenAttached(false);
        r20.setOnRightButtonClickListener(this.mCancelBtnListener);
        this.mAdapter.initAdapter();
        ViewPager r22 = (ViewPager) findViewById(R.id.viewPager);
        this.mViewPager = r22;
        r22.setAdapter(this.mPageOffsetAdapter);
        RelativeLayout.LayoutParams r23 = (RelativeLayout.LayoutParams) this.mViewPager.getLayoutParams();
        if (r13 <= this.mMaxPageGridCount) goto L58;
    L60:
        r23.height = r11.getInteger(R.integer.maxGridRows) * r11.getDimensionPixelSize(R.dimen.grid_item_height);
    L61:
        this.mViewPager.setLayoutParams(r23);
        this.mViewPager.setOnPageChangeListener(new AnonymousClass1(this));
        IndicatorView r24 = (IndicatorView) findViewById(R.id.indicator);
        this.mIndicatorView = r24;
        r24.setState(this.mPageOffsetAdapter.getCount());
        if (r13 > this.mMaxPageGridCount) goto L71;
        ViewGroup.LayoutParams r25 = this.mIndicatorView.getLayoutParams();
        r25.height = r11.getDimensionPixelSize(R.dimen.indicator_min_height);
        this.mIndicatorView.setLayoutParams(r25);
        this.mIndicatorView.setVisibility(4);
        return;
    L71:
        return;
    L58:
        if (this.mIsOneRow == false) goto L60;
        r23.height = r11.getDimensionPixelSize(R.dimen.grid_item_height);
        goto L61
    L54:
        r21 = title;
        goto L55
    L27:
        r8 = r11.getDimensionPixelSize(R.dimen.text_max_length_landscape);
        goto L28
    L24:
        r7 = false;
    L8:
        e = move-exception;
        Log.e(TAG, "Error: " + e);
        goto L10
    }

    private static int getResolverThemeId() {
        return ((Integer) Class.forName("com.android.internal.R$style").getDeclaredField("Theme_Smartisanos_Resolver").get(null)).intValue();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public void setOnClickListener(DialogInterface.OnClickListener listener) {
        this.mOnClickListener = listener;
    }

    @Override // android.app.Dialog
    public void show() {
        int r0 = this.mConstructorResult;
        if (r0 != 0) goto L5;
        super.show();
        return;
    L5:
        if (r0 != 1) goto L7;
        finishSuperActivity();
        return;
    L7:
        if (r0 != 2) goto L9;
        Toast.makeText(this.mContext, R.string.noApplications, 1).show();
        finishSuperActivity();
        return;
    L9:
        if (r0 != 3) goto L19;
        safelyStartActivity(this.mAdapter.intentForPosition(0));
        finishSuperActivity();
        return;
    }

    private boolean canAlwaysUse(boolean alwaysUseOption, Intent intent) {
        if (alwaysUseOption == true) goto L4;
    L8:
        return false;
    L4:
        if ("mailto".equals(intent.getScheme()) == true) goto L6;
    L7:
        return true;
    L6:
        if ("android.intent.action.SENDTO".equals(intent.getAction()) == false) goto L8;
        goto L7
    }

    @Override // obric.app.BaseResolverDialog
    protected void handlePackagesChanged() {
        ResolveInfoListBuilder r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.handlePackagesChanged();
        return;
    }

    private Drawable getIcon(Resources res, int resId, int userId) {
        return res.getDrawableForDensity(resId, this.mIconDpi);
    L4:
        return null;
    }

    private Drawable loadIconForResolveInfo(DisplayResolveInfo info) {
        ResolveInfo r0 = info.ri;
    L15:
        e = move-exception;
        Log.e(TAG, "Couldn't find resources for package", e);
    L18:
        return r0.loadIcon(this.mPm);
    L4:
        if (r0.resolvePackageName != null) goto L6;
    L10:
        int r1 = r0.getIconResource();     // Catch: PackageManager.NameNotFoundException -> L15
        if (r1 == 0) goto L18;
        Drawable r5 = getIcon(this.mPm.getResourcesForApplication(r0.activityInfo.packageName), r1, info.userId);     // Catch: PackageManager.NameNotFoundException -> L15
        if (r5 == null) goto L18;
        return r5;
    L6:
        if (r0.icon == 0) goto L10;
        Drawable r2 = getIcon(this.mPm.getResourcesForApplication(r0.resolvePackageName), r0.icon, info.userId);     // Catch: PackageManager.NameNotFoundException -> L15
        if (r2 == null) goto L10;
        return r2;
    }

    private void startSelected(int which, boolean always) {
        onIntentSelected(this.mAdapter.displayResolveInfoForPosition(which).ri, this.mAdapter.intentForPosition(which), always);
        dismiss();
    }

    protected void onIntentSelected(ResolveInfo ri, Intent intent, boolean alwaysCheck) {
        if (this.mAlwaysUseOption == true) goto L5;
    L100:
        if (intent == null) goto L130;
        this.mAppSpecialAction.performBrowserAction();
        DialogInterface.OnClickListener r0 = this.mOnClickListener;
        if (r0 == null) goto L104;
        r0.onClick(null, 0);
    L104:
        safelyStartActivity(intent);
        return;
    L130:
        return;
    L5:
        if (this.mAdapter.mOrigResolveList == null) goto L100;
        IntentFilter r1 = new IntentFilter();
        if (intent.getAction() == null) goto L9;
        r1.addAction(intent.getAction());
    L9:
        Set<String> r2 = intent.getCategories();
        if (r2 == null) goto L15;
        Iterator<String> r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L15;
        r1.addCategory(r3.next());
    L15:
        r1.addCategory("android.intent.category.DEFAULT");
        int r4 = ri.match & 268369920;
        Uri r5 = intent.getData();
        if (r4 != 6291456) goto L23;
        String r6 = intent.resolveType(this.mContext);
        if (r6 == null) goto L23;
        r1.addDataType(r6);     // Catch: IntentFilter.MalformedMimeTypeException -> L21
    L21:
        e = move-exception;
        Log.w("ResolverActivity", e);
        IntentFilter r7 = null;
    L25:
        if (r5 != null) goto L27;
    L87:
        if (r7 == null) goto L100;
        int r8 = this.mAdapter.mOrigResolveList.size();
        ComponentName[] r9 = new ComponentName[r8];
        int r10 = 0;
        int r11 = 0;
    L89:
        if (r10 >= r8) goto L94;
        ResolveInfo r12 = this.mAdapter.mOrigResolveList.get(r10);
        r9[r10] = new ComponentName(r12.activityInfo.packageName, r12.activityInfo.name);
        if (r12.match <= r11) goto L93;
        r11 = r12.match;
    L93:
        r10 = r10 + 1;
        goto L89
    L94:
        if (alwaysCheck == false) goto L108;
        this.mContext.getPackageManager().addPreferredActivity(r7, r11, r9, intent.getComponent());
        notifySettingsAppIfNeed(this.mContext, intent.resolveType(this.mContext), intent);
        Toast.makeText(this.mContext, R.string.set_default_success, 1).show();
        goto L100
    L108:
        AppGlobals.getPackageManager().setLastChosenActivity(intent, intent.resolveTypeIfNeeded(this.mContext.getContentResolver()), 65536, r7, r11, intent.getComponent());     // Catch: RemoteException -> L98
    L98:
        e = move-exception;
        Log.d(TAG, "Error calling setLastChosenActivity\n" + e);
        goto L100
    L27:
        if (r5.getScheme() == null) goto L87;
        if (r7 == null) goto L87;
        String r13 = r5.getScheme();
        if ("http".equals(r13) == false) goto L32;
    L35:
        r7.addDataScheme("http");
        r7.addDataScheme(HttpHeadTimeFetcher.FETCHER_TYPE);
        boolean r14 = true;
    L36:
        int r15 = this.mAdapter.mOrigResolveList.size();
        String r16 = r5.getSchemeSpecificPart();
        String r17 = r5.getPath();
        if (r17 == null) goto L42;
        if (r14 == false) goto L42;
        int r18 = r17.lastIndexOf(46);
        if (r18 <= 0) goto L42;
        r17 = r17.substring(0, r18).replace('.', '_') + r17.substring(r18);
    L42:
        if (r16 != null) goto L44;
        boolean r19 = true;
    L45:
        if (r17 != null) goto L47;
        boolean r20 = true;
    L48:
        int r110 = 0;
        boolean r111 = false;
    L49:
        if (r110 >= r15) goto L87;
        ResolveInfo r112 = this.mAdapter.mOrigResolveList.get(r110);
        if (r112.filter == null) goto L86;
        if (r19 == true) goto L61;
        Iterator<PatternMatcher> r113 = r112.filter.schemeSpecificPartsIterator();
        if (r113 == null) goto L61;
    L57:
        if (r113.hasNext() == false) goto L61;
        PatternMatcher r114 = r113.next();
        if (r114.match(r16) == false) goto L57;
        r7.addDataSchemeSpecificPart(r114.getPath(), r114.getType());
        r19 = true;
    L61:
        if (r111 == true) goto L73;
        Iterator<IntentFilter.AuthorityEntry> r115 = r112.filter.authoritiesIterator();
        if (r115 == null) goto L73;
    L65:
        if (r115.hasNext() == false) goto L73;
        IntentFilter.AuthorityEntry r116 = r115.next();
        if (r116.match(r5) < 0) goto L65;
        int r117 = r116.getPort();
        String r118 = r116.getHost();
        if (r117 < 0) goto L71;
        String r119 = Integer.toString(r117);
    L72:
        r7.addDataAuthority(r118, r119);
        r111 = true;
        goto L73
    L71:
        r119 = null;
    L73:
        if (r20 == true) goto L82;
        Iterator<PatternMatcher> r120 = r112.filter.pathsIterator();
        if (r120 == null) goto L82;
    L76:
        if (r17 == null) goto L82;
        if (r120.hasNext() == false) goto L82;
        PatternMatcher r121 = r120.next();
        if (r121.match(r17) == false) goto L76;
        r7.addDataPath(r121.getPath(), r121.getType());
        r20 = true;
    L82:
        if (r19 == false) goto L86;
        if (r111 == false) goto L86;
        if (r20 == true) goto L87;
    L86:
        r110 = r110 + 1;
        goto L49
    L47:
        r20 = false;
        goto L48
    L44:
        r19 = false;
        goto L45
    L32:
        if (HttpHeadTimeFetcher.FETCHER_TYPE.equals(r13) == true) goto L35;
        r7.addDataScheme(r13);
        r14 = false;
    L23:
        r7 = r1;
        goto L25
    }

    public static void notifySettingsAppIfNeed(Context context, String mimeType, Intent intent) {
        if (MimeTypeClassificationsMap.access$500(mimeType) == false) goto L5;
        return;
    L5:
        String r7 = intent.getDataString();
        if (r7 != null) goto L8;
        return;
    L8:
        String[] r8 = r7.split("[.]");
        if (r8 != null) goto L11;
        return;
    L11:
        if (r8.length <= 0) goto L22;
        String r9 = r8[r8.length - 1];
        Uri r1 = Uri.parse("content://com.android.settings.apiprovider");
        Bundle r2 = new Bundle();
        r2.putString(PreferredSettingsUtils.OTHERS_SUFFIX_KEY, r9);
        r2.putString(PreferredSettingsUtils.OTHERS_MIME_TYPE_KEY, mimeType);
        Log.d(TAG, " suffix: " + r9 + "mimeType:" + mimeType);     // Catch: Exception -> L16
        context.getContentResolver().call(r1, "notifySettingsChangedFileSuffix", null, r2);     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void safelyStartActivity(Intent intent) {
        invokeStaticMethod("smartisanos.app.StrictModeApi", "disableDeathOnFileUriExposure", null, null);
        safelyStartActivityInternal(intent);     // Catch: Throwable -> L6
        invokeStaticMethod("smartisanos.app.StrictModeApi", "enableDeathOnFileUriExposure", null, null);
        return;
    L6:
        th = move-exception;
        invokeStaticMethod("smartisanos.app.StrictModeApi", "enableDeathOnFileUriExposure", null, null);
        throw th;
    }

    private void safelyStartActivityInternal(Intent intent) {
        KeyguardManager r0 = (KeyguardManager) this.mContext.getSystemService("keyguard");
        int r1 = intent.getIntExtra("userId", this.mCurrentUser);
        intent.removeExtra("userId");
        this.mContext.startActivityAsUser(intent, null, new UserHandle(r1));
    }

    public static Object invokeStaticMethod(Class<?> targetClass, String methodName, Class[] paramTypes, Object[] paramObjects) {
        if (paramTypes == null) goto L5;
        Method r4 = targetClass.getDeclaredMethod(methodName, paramTypes);     // Catch: Throwable -> L9
    L7:
        r4.setAccessible(true);     // Catch: Throwable -> L9
        return r4.invoke(null, paramObjects);
    L5:
        r4 = targetClass.getDeclaredMethod(methodName, new Class[0]);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Log.e(TAG, "invokeMethod error!" + targetClass.getName() + "." + methodName, th);
        return null;
    }

    public static Object invokeStaticMethod(String targetClassName, String methodName, Class[] paramTypes, Object[] paramObjects) {
        return invokeStaticMethod(Class.forName(targetClassName), methodName, paramTypes, paramObjects);
    L4:
        th = move-exception;
        Log.e(TAG, "invokeMethod error!" + targetClassName + "." + methodName, th);
        return null;
    }
}
