package com.android.settings.specialaccess;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.utils.UIUtils;
import com.android.settings.widget.LoadingViewController2;
import com.android.settingslib.core.lifecycle.ObservableActivity;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.olog.OLog;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public class SpecialAccessBaseActivity extends ObservableActivity {
    private final String TAG;
    private boolean isEmpty;
    private Context mContext;
    private OPageStatus mEmptyDesc;
    private View mEmptyView;
    private View mLoadingContainer;
    private LoadingViewController2 mLoadingViewController;
    protected String mPackageName;
    protected RecyclerView mRecyclerView;
    private View mRootView;
    private OFloatingTitleBar mTitleBar;
    private CollapsingToolbarLayoutState state;
    private TextView tvTitle;

    private static final enum CollapsingToolbarLayoutState extends Enum<CollapsingToolbarLayoutState> {
        private static final /* synthetic */ CollapsingToolbarLayoutState[] $VALUES = null;
        public static final CollapsingToolbarLayoutState COLLAPSED = null;
        public static final CollapsingToolbarLayoutState EXPANDED = null;
        public static final CollapsingToolbarLayoutState INTERNEDIATE = null;

        private static /* synthetic */ CollapsingToolbarLayoutState[] $values() {
            return new CollapsingToolbarLayoutState[]{EXPANDED, COLLAPSED, INTERNEDIATE};
        }

        private CollapsingToolbarLayoutState(String r1, int r2) {
            super(r1, r2);
        }

        public static CollapsingToolbarLayoutState valueOf(String r1) {
            return (CollapsingToolbarLayoutState) Enum.valueOf(CollapsingToolbarLayoutState.class, r1);
        }

        public static CollapsingToolbarLayoutState[] values() {
            return (CollapsingToolbarLayoutState[]) $VALUES.clone();
        }

        static {
            EXPANDED = new CollapsingToolbarLayoutState("EXPANDED", 0);
            COLLAPSED = new CollapsingToolbarLayoutState("COLLAPSED", 1);
            INTERNEDIATE = new CollapsingToolbarLayoutState("INTERNEDIATE", 2);
            $VALUES = $values();
        }
    }

    protected int getEmptyRes() {
        return R.string.zen_access_empty_text;
    }

    protected int getPackageIdx(String r1) {
        return -1;
    }

    protected int getSubtitleResId() {
        return -1;
    }

    protected int getTitleRes() {
        return R.string.manage_zen_access_title;
    }

    public SpecialAccessBaseActivity() {
        this.TAG = "SpecialAccessBaseActivity";
        this.tvTitle = null;
        this.state = null;
        this.isEmpty = false;
        this.mPackageName = null;
    }

    public static void setLightStatusBarIcon(Window r1, boolean r2) {
        int r0 = r1.getDecorView().getSystemUiVisibility();
        if (r2 == false) goto L5;
        int r3 = r0 | 8192;
    L6:
        r1.getDecorView().setSystemUiVisibility(r3);
        return;
    L5:
        r3 = r0 & (-8193);
        goto L6
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        this.mContext = this;
        setContentView(R.layout.manage_applications_zenaccess);
        getWindow().getDecorView().setSystemUiVisibility(1792);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
        Window r6 = getWindow();
        if (Utils.isThreeButtonNavBarEnabled(this) == false) goto L5;
        int r1 = getColor(R.color.oui_bg_base_1);
    L6:
        r6.setNavigationBarColor(r1);
        getWindow().setNavigationBarContrastEnforced(false);
        setLightStatusBarIcon(getWindow(), isLightStatusBar());
        Utils.setNavigationBarBtnColor(getWindow(), Boolean.valueOf(isLightStatusBar()));
        View r7 = findViewById(R.id.root_view_container);
        this.mRootView = r7;
        this.mLoadingContainer = r7.findViewById(R.id.oui_loading_container);
        this.mEmptyView = this.mRootView.findViewById(R.id.empty_container);
        OPageStatus r8 = (OPageStatus) this.mRootView.findViewById(R.id.zen_status_loading);
        this.mEmptyDesc = r8;
        r8.setTitle(getString(R.string.no_apps_with_permission));
        this.mEmptyDesc.setMessage(getString(getSubtitleResId()));
        OFloatingTitleBar r9 = (OFloatingTitleBar) this.mRootView.findViewById(R.id.view_title);
        this.mTitleBar = r9;
        r9.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null).setOnClickListener(new SpecialAccessBaseActivity$$ExternalSyntheticLambda1(this));
        this.tvTitle = (TextView) this.mTitleBar.findViewById(R.id.center_title);
        RecyclerView r10 = (RecyclerView) this.mRootView.findViewById(R.id.apps_list);
        this.mRecyclerView = r10;
        r10.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        int r11 = getTitleRes();
        if (r11 <= 0) goto L9;
        this.mTitleBar.setCenterTitle(getString(r11));
    L9:
        LoadingViewController2 r0 = new LoadingViewController2(this.tvTitle, this.mLoadingContainer, this.mRootView.findViewById(R.id.content_layout), this.mEmptyView);
        this.mLoadingViewController = r0;
        r0.showLoadingView();
        this.mPackageName = getPackageData(getIntent());
        OLog.i("SpecialAccessBaseActivity", "getPackageData: " + this.mPackageName);
        UIUtils.fitMaskTitle((ViewGroup) this.mRootView, this.mRecyclerView);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-android-settings-specialaccess-SpecialAccessBaseActivity, reason: not valid java name */
    /* synthetic */ void m604xe649276d(View r1) {
        onBackPressed();
    }

    protected void initDescText(OSectionSupportiveText r2) {
        int r0 = getSubtitleResId();
        if (r0 <= 0) goto L6;
        r2.setSectionDes(getString(r0));
        return;
    }

    protected boolean isLightStatusBar() {
        if ((this.mContext.getResources().getConfiguration().uiMode & 48) == 32) goto L5;
        return true;
    L5:
        return false;
    }

    private static String getPackageData(Intent r2) {
        Uri r3 = r2.getData();
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.getScheme().equals("package") == true) goto L7;
        return null;
    L7:
        return r3.getSchemeSpecificPart();
    }

    protected void showEmptyView() {
        this.mLoadingViewController.showEmpty(false);
        this.isEmpty = true;
    }

    protected void showContent() {
        this.mLoadingViewController.showContent(false);
        this.isEmpty = false;
    }

    protected void updatePositionAfterNotify() {
        String r0 = this.mPackageName;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L10;
        this.mRecyclerView.post(new SpecialAccessBaseActivity$$ExternalSyntheticLambda0(this));
        return;
    }

    /* JADX INFO: renamed from: lambda$updatePositionAfterNotify$2$com-android-settings-specialaccess-SpecialAccessBaseActivity, reason: not valid java name */
    /* synthetic */ void m606x2ae21dad() {
        int r0 = getPackageIdx(this.mPackageName);
        if (r0 < 1) goto L6;
        final int r1 = r0 - 1;
        this.mRecyclerView.post(new SpecialAccessBaseActivity$$ExternalSyntheticLambda2(this, r1));
        return;
    }

    /* JADX INFO: renamed from: lambda$updatePositionAfterNotify$1$com-android-settings-specialaccess-SpecialAccessBaseActivity, reason: not valid java name */
    /* synthetic */ void m605x96a3ae0e(int r2) {
        ((LinearLayoutManager) this.mRecyclerView.getLayoutManager()).scrollToPositionWithOffset(r2, 0);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        TransitionAnimHelper.overrideExitAnim(this, TransitionAnimStyle.Standard);
    }
}
