package com.android.settings.specialaccess.pictureinpicture;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.android.settings.NotificationDisplayDetailsActivity;
import com.android.settings.R;
import com.android.settings.accounts.obric.ObricIconUtils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.specialaccess.SpecialAccessBaseActivity;
import com.android.settings.specialaccess.SpecialAccessHeaderAdapter;
import com.android.settings.specialaccess.SpecialAccessSwitchViewHolder;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.textboom.db.OcrAppInfoColumn;
import com.bytedance.sremlib.LibUtil;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.olog.OLog;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.privacy.GrantUtil;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: PictureInPictureSettingsActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0003%&'B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u000f\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u0010j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011`\u00142\u0006\u0010\u0015\u001a\u00020\u0013J\b\u0010\u0016\u001a\u00020\u0013H\u0014J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u001c\u001a\u00020\u0013H\u0014J\b\u0010\u001d\u001a\u00020\u0013H\u0014J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u001fH\u0016J8\u0010#\u001a\u00020\u001f2.\u0010$\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u0010j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011`\u0014H\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/android/settings/specialaccess/pictureinpicture/PictureInPictureSettingsActivity;", "Lcom/android/settings/specialaccess/SpecialAccessBaseActivity;", "()V", "GET_ACTIVITIES_FLAGS", "Landroid/content/pm/PackageManager$PackageInfoFlags;", "TAG", "", "mApplicationAdapter", "Lcom/android/settings/specialaccess/pictureinpicture/PictureInPictureSettingsActivity$ApplicationAdapter;", "mContext", "Landroid/content/Context;", "mPackageManager", "Landroid/content/pm/PackageManager;", "mUserManager", "Landroid/os/UserManager;", "collectPipApps", "Ljava/util/ArrayList;", "Landroid/util/Pair;", "Landroid/content/pm/ApplicationInfo;", "", "Lkotlin/collections/ArrayList;", AccountInfoBundleKey.USER_ID, "getEmptyRes", "getPackageAndActivityInfoList", "", "Landroid/content/pm/PackageInfo;", "getPackageIdx", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "getSubtitleResId", "getTitleRes", "onCreate", "", "icicle", "Landroid/os/Bundle;", "onResume", "updatePipApps", "pipApps", "AppComparator", "ApplicationAdapter", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PictureInPictureSettingsActivity extends SpecialAccessBaseActivity {
    public static final Companion Companion = null;
    private static final List<String> IGNORE_PACKAGE_LIST = null;
    private final PackageManager.PackageInfoFlags GET_ACTIVITIES_FLAGS;
    private final String TAG;
    private ApplicationAdapter mApplicationAdapter;
    private Context mContext;
    private PackageManager mPackageManager;
    private UserManager mUserManager;

    /* JADX INFO: compiled from: PictureInPictureSettingsActivity.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002`\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ0\u0010\u000b\u001a\u00020\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/settings/specialaccess/pictureinpicture/PictureInPictureSettingsActivity$AppComparator;", "Ljava/util/Comparator;", "Landroid/util/Pair;", "Landroid/content/pm/ApplicationInfo;", "", "Lkotlin/Comparator;", "mPm", "Landroid/content/pm/PackageManager;", "(Landroid/content/pm/PackageManager;)V", "mCollator", "Ljava/text/Collator;", "compare", "a", "b", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AppComparator implements Comparator<Pair<ApplicationInfo, Integer>> {
        private final Collator mCollator;
        private final PackageManager mPm;

        public AppComparator(PackageManager r2) {
            Intrinsics.checkNotNullParameter(r2, "mPm");
            this.mPm = r2;
            Collator r3 = Collator.getInstance();
            Intrinsics.checkNotNullExpressionValue(r3, "getInstance(...)");
            this.mCollator = r3;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Pair<ApplicationInfo, Integer> r1, Pair<ApplicationInfo, Integer> r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Pair<ApplicationInfo, Integer> r4, Pair<ApplicationInfo, Integer> r5) {
            Intrinsics.checkNotNullParameter(r4, "a");
            Intrinsics.checkNotNullParameter(r5, "b");
            Object r0 = r4.first;
            Intrinsics.checkNotNull(r0);
            String r1 = ((ApplicationInfo) r0).loadLabel(this.mPm);
            if (r1 != null) goto L5;
            Object r2 = r4.first;
            Intrinsics.checkNotNull(r2);
            r1 = ((ApplicationInfo) r2).name;
        L5:
            Object r3 = r5.first;
            Intrinsics.checkNotNull(r3);
            String r6 = ((ApplicationInfo) r3).loadLabel(this.mPm);
            if (r6 != null) goto L8;
            Object r7 = r5.first;
            Intrinsics.checkNotNull(r7);
            r6 = ((ApplicationInfo) r7).name;
        L8:
            int r8 = this.mCollator.compare(String.valueOf(r1), String.valueOf(r6));
            if (r8 == 0) goto L11;
            return r8;
        L11:
            Object r9 = r4.second;
            Intrinsics.checkNotNull(r9);
            int r10 = ((Number) r9).intValue();
            Object r11 = r5.second;
            Intrinsics.checkNotNull(r11);
            return r10 - ((Number) r11).intValue();
        }
    }

    /* JADX INFO: compiled from: PictureInPictureSettingsActivity.kt */
    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\u0012\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000fH\u0016J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000fH\u0016J8\u0010(\u001a\u00020\t2.\u0010)\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\fj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r`\u0010H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u000b\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\fj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006+"}, d2 = {"Lcom/android/settings/specialaccess/pictureinpicture/PictureInPictureSettingsActivity$ApplicationAdapter;", "Lcom/android/settings/specialaccess/SpecialAccessHeaderAdapter;", "activity", "Landroid/app/Activity;", "mPkgMan", "Landroid/content/pm/PackageManager;", NotificationCompat.CATEGORY_CALL, "Lkotlin/Function1;", "Lcom/obric/oui/sectiontitlebar/OSectionSupportiveText;", "", "(Landroid/app/Activity;Landroid/content/pm/PackageManager;Lkotlin/jvm/functions/Function1;)V", "pipApps", "Ljava/util/ArrayList;", "Landroid/util/Pair;", "Landroid/content/pm/ApplicationInfo;", "", "Lkotlin/collections/ArrayList;", "getPipApps", "()Ljava/util/ArrayList;", "setPipApps", "(Ljava/util/ArrayList;)V", "checkSwitch", "", "applicationInfo", "enableSwitch", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "", "getItemContentCount", "getSwitchOnCheckedListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", LibUtil.EXCEPTION_APPLICATION, "onBindContentViewHolder", "viewHolder", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "position", "onCreateContentViewHolder", "Lcom/android/settings/specialaccess/SpecialAccessSwitchViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", OcrAppInfoColumn.TABLE_NAME, "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ApplicationAdapter extends SpecialAccessHeaderAdapter {
        public static final Companion Companion = null;
        private final Activity activity;
        private final Function1<OSectionSupportiveText, Unit> call;
        private final PackageManager mPkgMan;
        private ArrayList<Pair<ApplicationInfo, Integer>> pipApps;

        /* JADX INFO: compiled from: PictureInPictureSettingsActivity.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ(\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u0004¨\u0006\u000e"}, d2 = {"Lcom/android/settings/specialaccess/pictureinpicture/PictureInPictureSettingsActivity$ApplicationAdapter$Companion;", "", "()V", "getEnterPipStateForPackage", "", "context", "Landroid/content/Context;", "uid", "", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "", "setEnterPipStateForPackage", "", "value", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }

            public final void setEnterPipStateForPackage(Context r1, int r2, String r3, boolean r4) {
                Intrinsics.checkNotNullParameter(r1, "context");
                AppOpsManager r0 = (AppOpsManager) r1.getSystemService(AppOpsManager.class);
                if (r4 == false) goto L5;
                int r5 = 0;
            L6:
                if (r0 == null) goto L9;
                r0.setMode(67, r2, r3, r5);
                return;
            L9:
                return;
            L5:
                r5 = 2;
                goto L6
            }

            public final boolean getEnterPipStateForPackage(Context r2, int r3, String r4) {
                Intrinsics.checkNotNullParameter(r2, "context");
                Intrinsics.checkNotNullParameter(r4, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
                AppOpsManager r1 = (AppOpsManager) r2.getSystemService(AppOpsManager.class);
                if (r1 != null) goto L5;
                return false;
            L5:
                if (r1.checkOpNoThrow(67, r3, r4) != 0) goto L9;
                return true;
            L9:
                return false;
            }
        }

        public static /* synthetic */ void $r8$lambda$8zV0UN5q3gRlw3vahnv_QymlIxk(ApplicationAdapter r0, ApplicationInfo r1, CompoundButton r2, boolean r3) {
            getSwitchOnCheckedListener$lambda$0(r0, r1, r2, r3);
        }

        static {
            Companion = new Companion(null);
        }

        private final boolean enableSwitch(String r1) {
            return true;
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup r1, int r2) {
            return onCreateContentViewHolder(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ApplicationAdapter(Activity r2, PackageManager r3, Function1<? super OSectionSupportiveText, Unit> r4) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "mPkgMan");
            Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_CALL);
            super(r4);
            this.activity = r2;
            this.mPkgMan = r3;
            this.call = r4;
            this.pipApps = new ArrayList();
        }

        public final ArrayList<Pair<ApplicationInfo, Integer>> getPipApps() {
            return this.pipApps;
        }

        public final void setPipApps(ArrayList<Pair<ApplicationInfo, Integer>> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.pipApps = r2;
        }

        public final void setData(ArrayList<Pair<ApplicationInfo, Integer>> r2) {
            Intrinsics.checkNotNullParameter(r2, OcrAppInfoColumn.TABLE_NAME);
            this.pipApps = r2;
            notifyDataSetChanged();
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public SpecialAccessSwitchViewHolder onCreateContentViewHolder(ViewGroup r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "parent");
            return new SpecialAccessSwitchViewHolder(SpecialAccessSwitchViewHolder.newView(r1));
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public void onBindContentViewHolder(RecyclerView.ViewHolder r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "viewHolder");
            SpecialAccessSwitchViewHolder r6 = (SpecialAccessSwitchViewHolder) r4;
            ArrayList<Pair<ApplicationInfo, Integer>> r0 = this.pipApps;
            Intrinsics.checkNotNull(r0);
            Pair<ApplicationInfo, Integer> r1 = r0.get(r5);
            Intrinsics.checkNotNullExpressionValue(r1, "get(...)");
            ApplicationInfo r2 = (ApplicationInfo) r1.first;
            Intrinsics.checkNotNull(r2);
            r6.setIcon(ObricIconUtils.getDrawable(r2));
            r6.setTitle(r2.loadLabel(this.mPkgMan), null);
            r6.initCardItemInAdapter(this.pipApps.size(), r5);
            r6.updateSwitch(getSwitchOnCheckedListener(r2), enableSwitch(r2.packageName), checkSwitch(r2));
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public int getItemContentCount() {
            ArrayList<Pair<ApplicationInfo, Integer>> r0 = this.pipApps;
            if (r0 != null) goto L5;
            return 0;
        L5:
            Intrinsics.checkNotNull(r0);
            return r0.size();
        }

        public final CompoundButton.OnCheckedChangeListener getSwitchOnCheckedListener(final ApplicationInfo r2) {
            if (r2 != null) goto L6;
            return null;
        L6:
            return new PictureInPictureSettingsActivity$ApplicationAdapter$$ExternalSyntheticLambda0(this, r2);
        }

        private static final void getSwitchOnCheckedListener$lambda$0(ApplicationAdapter r1, ApplicationInfo r2, CompoundButton r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            Companion.setEnterPipStateForPackage(r1.activity, r2.uid, r2.packageName, r4);
        }

        private final boolean checkSwitch(ApplicationInfo r4) {
            Companion r0 = Companion;
            Activity r3 = this.activity;
            int r1 = r4.uid;
            String r5 = r4.packageName;
            Intrinsics.checkNotNullExpressionValue(r5, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
            return r0.getEnterPipStateForPackage(r3, r1, r5);
        }
    }

    /* JADX INFO: compiled from: PictureInPictureSettingsActivity.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0002\u0010\u000fR$\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/android/settings/specialaccess/pictureinpicture/PictureInPictureSettingsActivity$Companion;", "", "()V", "IGNORE_PACKAGE_LIST", "", "", "getIGNORE_PACKAGE_LIST$annotations", "getIGNORE_PACKAGE_LIST", "()Ljava/util/List;", "checkPackageHasPictureInPictureActivities", "", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "activities", "", "Landroid/content/pm/ActivityInfo;", "(Ljava/lang/String;[Landroid/content/pm/ActivityInfo;)Z", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ void getIGNORE_PACKAGE_LIST$annotations() {
        }

        private Companion() {
        }

        public final List<String> getIGNORE_PACKAGE_LIST() {
            return PictureInPictureSettingsActivity.access$getIGNORE_PACKAGE_LIST$cp();
        }

        public final boolean checkPackageHasPictureInPictureActivities(String r2, ActivityInfo[] r3) {
            Intrinsics.checkNotNullParameter(r2, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
            if (getIGNORE_PACKAGE_LIST().contains(r2) == false) goto L5;
            return false;
        L5:
            if (r3 == null) goto L15;
            int r1 = r3.length - 1;
            if (r1 < 0) goto L15;
        L8:
            int r0 = r1 - 1;
            if (r3[r1].supportsPictureInPicture() == true) goto L10;
            if (r0 < 0) goto L15;
            r1 = r0;
            goto L8
        L10:
            return true;
        L15:
            return false;
        }
    }

    /* JADX INFO: renamed from: com.android.settings.specialaccess.pictureinpicture.PictureInPictureSettingsActivity$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: PictureInPictureSettingsActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.specialaccess.pictureinpicture.PictureInPictureSettingsActivity$onCreate$2", f = "PictureInPictureSettingsActivity.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PictureInPictureSettingsActivity this$0;

        AnonymousClass2(PictureInPictureSettingsActivity r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass2(this.this$0, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            PictureInPictureSettingsActivity r5 = this.this$0;
            PictureInPictureSettingsActivity.access$updatePipApps(r5, (ArrayList) r6);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            this.label = 1;
            r6 = BuildersKt.withContext(Dispatchers.getIO(), new PictureInPictureSettingsActivity$onCreate$2$pipApps$1(this.this$0, null), this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    public void com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getEmptyRes() {
        return R.string.picture_in_picture_empty_text;
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getSubtitleResId() {
        return R.string.picture_in_picture_app_detail_switch;
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getTitleRes() {
        return R.string.picture_in_picture_title;
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity, com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public PictureInPictureSettingsActivity() {
        Intrinsics.checkNotNullExpressionValue("PictureInPictureSettingsActivity", "getSimpleName(...)");
        this.TAG = "PictureInPictureSettingsActivity";
        PackageManager.PackageInfoFlags r0 = PackageManager.PackageInfoFlags.of(1);
        Intrinsics.checkNotNullExpressionValue(r0, "of(...)");
        this.GET_ACTIVITIES_FLAGS = r0;
    }

    public static final /* synthetic */ List access$getIGNORE_PACKAGE_LIST$cp() {
        return IGNORE_PACKAGE_LIST;
    }

    public static final /* synthetic */ void access$initDescText(PictureInPictureSettingsActivity r0, OSectionSupportiveText r1) {
        r0.initDescText(r1);
    }

    public static final /* synthetic */ void access$updatePipApps(PictureInPictureSettingsActivity r0, ArrayList r1) {
        r0.updatePipApps(r1);
    }

    public void com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        System.currentTimeMillis();
        PictureInPictureSettingsActivity r8 = this;
        this.mContext = r8;
        Intrinsics.checkNotNull(r8);
        this.mPackageManager = r8.getPackageManager();
        Context r9 = this.mContext;
        Intrinsics.checkNotNull(r9);
        Object r10 = r9.getSystemService(PickApplicationActivity.EXTRA_USER);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.os.UserManager");
        this.mUserManager = (UserManager) r10;
        PackageManager r1 = this.mPackageManager;
        Intrinsics.checkNotNull(r1);
        this.mApplicationAdapter = new ApplicationAdapter(this, r1, new AnonymousClass1(this));
        this.mRecyclerView.setAdapter(this.mApplicationAdapter);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass2(this, null), 3, null);
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getPackageIdx(String r5) {
        ApplicationAdapter r0 = this.mApplicationAdapter;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.getItemCount();
        if (this.mPackageName == null) goto L13;
        if (r1 <= 0) goto L13;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L13;
        ApplicationAdapter r3 = this.mApplicationAdapter;
        Intrinsics.checkNotNull(r3);
        ArrayList<Pair<ApplicationInfo, Integer>> r4 = r3.getPipApps();
        Intrinsics.checkNotNull(r4);
        ApplicationInfo r6 = (ApplicationInfo) r4.get(r2).first;
        if (r6 == null) goto L12;
        if (TextUtils.equals(r5, r6.packageName) == false) goto L12;
    L14:
        OLog.i(this.TAG, "jump to: " + r2 + ", package: " + r5);
        return r2;
    L12:
        r2 = r2 + 1;
    L13:
        r2 = -1;
        goto L14
    }

    public void com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity__onResume$___twin___() {
        super.onResume();
    }

    private final void updatePipApps(ArrayList<Pair<ApplicationInfo, Integer>> r4) {
        PackageManager r2 = this.mPackageManager;
        Intrinsics.checkNotNull(r2);
        Collections.sort(r4, new AppComparator(r2));
        if (r4.isEmpty() == false) goto L5;
        showEmptyView();
    L6:
        ApplicationAdapter r0 = this.mApplicationAdapter;
        Intrinsics.checkNotNull(r0);
        r0.setData(r4);
        updatePositionAfterNotify();
        return;
    L5:
        showContent();
        goto L6
    }

    public final ArrayList<Pair<ApplicationInfo, Integer>> collectPipApps(int r8) {
        ArrayList<Pair<ApplicationInfo, Integer>> r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        UserManager r2 = this.mUserManager;
        Intrinsics.checkNotNull(r2);
        Iterator r9 = r2.getProfiles(r8).iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r1.add(Integer.valueOf(((UserInfo) r9.next()).id));
        goto L4
    L6:
        Iterator r10 = r1.iterator();
    L8:
        if (r10.hasNext() == false) goto L15;
        Integer r3 = (Integer) r10.next();
        Intrinsics.checkNotNull(r3);
        Iterator<PackageInfo> r4 = getPackageAndActivityInfoList(r3.intValue()).iterator();
    L11:
        if (r4.hasNext() == false) goto L8;
        PackageInfo r5 = r4.next();
        Companion r6 = Companion;
        String r7 = r5.packageName;
        Intrinsics.checkNotNullExpressionValue(r7, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        if (r6.checkPackageHasPictureInPictureActivities(r7, r5.activities) == false) goto L11;
        r0.add(new Pair(r5.applicationInfo, r3));
        goto L11
    L15:
        return r0;
    }

    private final List<PackageInfo> getPackageAndActivityInfoList(int r3) {
        List<PackageInfo> r4 = getPackageManager().getInstalledPackagesAsUser(this.GET_ACTIVITIES_FLAGS, r3);     // Catch: Exception -> L4
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L4
        return r4;
    L4:
        e = move-exception;
        OLog.e(this.TAG, "getPackageAndActivityInfoList Exception while getInstalledPackagesAsUser", e);
        return CollectionsKt.emptyList();
    }

    static {
        Companion = new Companion(null);
        ArrayList r0 = new ArrayList();
        IGNORE_PACKAGE_LIST = r0;
        r0.add("com.android.systemui");
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(PictureInPictureSettingsActivity r1) {
        r1.com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(PictureInPictureSettingsActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(PictureInPictureSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        PictureInPictureSettingsActivity r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(PictureInPictureSettingsActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(PictureInPictureSettingsActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(PictureInPictureSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(PictureInPictureSettingsActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_android_settings_specialaccess_pictureinpicture_PictureInPictureSettingsActivity__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        PictureInPictureSettingsActivity r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }
}
