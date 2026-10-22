package com.android.settings.fingerprint;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.FingerprintAnimView;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintAnimationFragment extends BaseFragment {
    private AnimPreviewRecyclerAdapter mAnimAdapter;
    private FingerprintAnimView mAnimView;
    private int mCurrentIndex;
    private Drawable[] mIcons;
    private int mOriginIndex;
    private RecyclerView mRecyclerView;
    private View mRightView;

    public class AnimPreviewRecyclerAdapter extends RecyclerView.Adapter<AnimViewHolder> {
        final /* synthetic */ FingerprintAnimationFragment this$0;

        public class AnimViewHolder extends RecyclerView.ViewHolder {
            ImageView mItemView;
            final /* synthetic */ AnimPreviewRecyclerAdapter this$1;

            public AnimViewHolder(AnimPreviewRecyclerAdapter r1, View r2) {
                this.this$1 = r1;
                super(r2);
                this.mItemView = (ImageView) r2.findViewById(R.id.anim_item);
            }

            public ImageView getItemView() {
                return this.mItemView;
            }
        }

        public AnimPreviewRecyclerAdapter(FingerprintAnimationFragment r1) {
            this.this$0 = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
            onBindViewHolder((AnimViewHolder) r1, r2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
            return onCreateViewHolder(r1, r2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (FingerprintAnimationFragment.access$100(this.this$0) != null) goto L7;
            return 0;
        L7:
            return FingerprintAnimationFragment.access$100(this.this$0).length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public AnimViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            return new AnimViewHolder(this, LayoutInflater.from(this.this$0.mContext).inflate(R.layout.fingerprint_anim_item, r3, false));
        }

        public void onBindViewHolder(AnimViewHolder r6, final int r7) {
            r6.getItemView().setImageDrawable(FingerprintAnimationFragment.access$100(this.this$0)[r7]);
            if (FingerprintAnimationFragment.access$000(this.this$0) != r7) goto L5;
            r6.getItemView().setForeground(this.this$0.mContext.getResources().getDrawable(R.drawable.fingerprint_anim_selected));
        L6:
            LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) r6.getItemView().getLayoutParams();
            Resources r1 = this.this$0.mContext.getResources();
            if (r7 != 0) goto L10;
            r0.leftMargin = r1.getDimensionPixelOffset(R.dimen.fingerprint_recyclerView_margin);
        L13:
            r6.getItemView().setLayoutParams(r0);
            r6.getItemView().setOnClickListener(new AnonymousClass1(this, r7));
            return;
        L10:
            if (r7 != (getItemCount() - 1)) goto L12;
            r0.leftMargin = r1.getDimensionPixelOffset(R.dimen.fingerprint_recyclerView_item_margin);
            r0.rightMargin = r1.getDimensionPixelOffset(R.dimen.fingerprint_recyclerView_margin);
            goto L13
        L12:
            r0.leftMargin = r1.getDimensionPixelOffset(R.dimen.fingerprint_recyclerView_item_margin);
            goto L13
        L5:
            r6.getItemView().setForeground(null);
            goto L6
        }
    }

    public void com_android_settings_fingerprint_FingerprintAnimationFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_fingerprint_FingerprintAnimationFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_fingerprint_FingerprintAnimationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_fingerprint_FingerprintAnimationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public FingerprintAnimationFragment() {
    }

    static /* synthetic */ int access$000(FingerprintAnimationFragment r0) {
        return r0.mCurrentIndex;
    }

    static /* synthetic */ int access$002(FingerprintAnimationFragment r0, int r1) {
        r0.mCurrentIndex = r1;
        return r1;
    }

    static /* synthetic */ Drawable[] access$100(FingerprintAnimationFragment r0) {
        return r0.mIcons;
    }

    static /* synthetic */ FingerprintAnimView access$200(FingerprintAnimationFragment r0) {
        return r0.mAnimView;
    }

    static /* synthetic */ int access$300(FingerprintAnimationFragment r0) {
        return r0.mOriginIndex;
    }

    static /* synthetic */ View access$400(FingerprintAnimationFragment r0) {
        return r0.mRightView;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.fingerprint_anim_preview_layout, r3, false);
        initViews();
        return this.mRootView;
    }

    private void initViews() {
        this.mAnimView = (FingerprintAnimView) findViewByIdNullable(R.id.anim_view);
        RecyclerView r0 = (RecyclerView) findViewByIdNullable(R.id.recycler_view);
        this.mRecyclerView = r0;
        int r3 = 0;
        r0.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        TypedArray r1 = this.mContext.getResources().obtainTypedArray(R.array.fingerprint_anim_preview);
        this.mIcons = new Drawable[r1.length()];
    L4:
        if (r3 >= r1.length()) goto L6;
        this.mIcons[r3] = r1.getDrawable(r3);
        r3 = r3 + 1;
        goto L4
    L6:
        r1.recycle();
        AnimPreviewRecyclerAdapter r2 = new AnimPreviewRecyclerAdapter(this);
        this.mAnimAdapter = r2;
        this.mRecyclerView.setAdapter(r2);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        boolean r0 = false;
        int r6 = Settings.Global.getInt(getContentResolver(), "smt_fp_anim_type", 0);
        this.mOriginIndex = r6;
        this.mCurrentIndex = r6;
        this.mAnimView.setAnimation(r6);
        View r7 = this.mTitleView.addEndAction(R.drawable.standard_icon_hignlight_confirm_selector, -1, null);
        this.mRightView = r7;
        if (this.mCurrentIndex == this.mOriginIndex) goto L5;
        r0 = true;
    L5:
        r7.setEnabled(r0);
        this.mRightView.setOnClickListener(new AnonymousClass1(this));
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fingerprint_FingerprintAnimationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(FingerprintAnimationFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fingerprint_FingerprintAnimationFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_FingerprintAnimationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(FingerprintAnimationFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_fingerprint_FingerprintAnimationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_FingerprintAnimationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(FingerprintAnimationFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fingerprint_FingerprintAnimationFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
