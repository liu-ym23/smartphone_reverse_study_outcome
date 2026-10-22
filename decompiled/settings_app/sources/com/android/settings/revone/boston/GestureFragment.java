package com.android.settings.revone.boston;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.widget.SettingItemCheckEx;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import obric.widget.SettingItemText;
import obric.widget.ShadowDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class GestureFragment extends BaseFragment {
    private static final int ITEM_HEIGHT_DP = 60;
    public static final String KEY_TYPE = "gesture_type";
    private static final int MAX_ITEM_COUNT_SCREEN_GESTURE = 4;
    private static final int MAX_ITEM_COUNT_TOUCHPAD_GESTURE = 7;
    private static final int REMOVE_COVER_DELAY = 300;
    private static final String TAG = "Gesture";
    private static final int TOAST_TIME_GAP = 10000;
    public static final int TYPE_SCREEN = 1;
    public static final int TYPE_TOUCHPAD = 2;
    protected GestureAdapter mAdapter;
    protected List<GestureGroup> mGestureGroups;
    private Handler mHandler;
    protected ListView mListview;
    private int mMaxItemCount;
    private long mToastTime;
    protected int mType;
    private String mVideoDirPath;
    private GestureVideoDownloader mVideoDownloader;

    /* JADX INFO: renamed from: com.android.settings.revone.boston.GestureFragment$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$settings$revone$boston$GestureFragment$LoadStatus = null;

        static {
            int[] r0 = new int[LoadStatus.values().length];
            $SwitchMap$com$android$settings$revone$boston$GestureFragment$LoadStatus = r0;
            r0[LoadStatus.loadSuccess.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$android$settings$revone$boston$GestureFragment$LoadStatus[LoadStatus.loadFailed.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$android$settings$revone$boston$GestureFragment$LoadStatus[LoadStatus.loading.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    class GestureAdapter extends BaseAdapter {
        final /* synthetic */ GestureFragment this$0;

        /* JADX INFO: renamed from: com.android.settings.revone.boston.GestureFragment$GestureAdapter$1, reason: invalid class name */
        class AnonymousClass1 implements MediaPlayer.OnPreparedListener {
            final /* synthetic */ GestureAdapter this$1;
            final /* synthetic */ ViewHolder val$holder;

            AnonymousClass1(GestureAdapter r1, ViewHolder r2) {
                this.this$1 = r1;
                this.val$holder = r2;
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer r4) {
                r4.setLooping(true);
                this.val$holder.videoView.start();
                this.val$holder.progressBar.setVisibility(8);
                Handler r5 = GestureFragment.access$000(this.this$1.this$0);
                final ViewHolder r3 = this.val$holder;
                r5.postDelayed(new GestureFragment$GestureAdapter$1$$ExternalSyntheticLambda0(r3), 300);
            }

            static /* synthetic */ void lambda$onPrepared$0(ViewHolder r1) {
                r1.videoBg.setVisibility(8);
            }
        }

        class ViewHolder {
            TextView groupTitle;
            View itemLayout;
            LinearLayout itemsView;
            ProgressBar progressBar;
            final /* synthetic */ GestureAdapter this$1;
            View videoBg;
            VideoView videoView;

            ViewHolder(GestureAdapter r1) {
                this.this$1 = r1;
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        GestureAdapter(GestureFragment r1) {
            this.this$0 = r1;
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.this$0.mGestureGroups.size();
        }

        @Override // android.widget.Adapter
        public GestureGroup getItem(int r1) {
            return this.this$0.mGestureGroups.get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r5, View r6, ViewGroup r7) {
            if (r6 == null) goto L5;
            final ViewHolder r8 = (ViewHolder) r6.getTag();
        L10:
            GestureGroup r9 = getItem(r5);
            r8.groupTitle.setText(r9.groupTitle);
            r8.videoBg.setVisibility(0);
            GestureGroup.GestureItem r0 = r9.items.get(0);
            Uri r1 = getVideoUri(r0);
            OLog.i(GestureFragment.TAG, "getView videoUri for " + r0.key + "= " + r1);
            if (r1 != null) goto L13;
            GestureFragment.access$100(this.this$0).fetchVideo(r0.key, new GestureFragment$GestureAdapter$$ExternalSyntheticLambda2(this, r8));
        L14:
            r8.videoView.setTag(r0.key);
            addChildren(r8, r9);
            ShadowDrawable.setViewBackground(r8.itemLayout, R.drawable.group_list_item_bg_single, R.drawable.list_content_item_single_shadow);
            return r6;
        L13:
            updateVideoView(r8, LoadStatus.loadSuccess, r1);
            goto L14
        L5:
            if (this.this$0.mType != 1) goto L7;
            r6 = LayoutInflater.from(this.this$0.mContext).inflate(R.layout.screen_gesture_group_layout, r7, false);
        L8:
            r8 = new ViewHolder(this);
            r8.groupTitle = (TextView) r6.findViewById(R.id.group_title);
            r8.videoView = (VideoView) r6.findViewById(R.id.video);
            r8.itemsView = (LinearLayout) r6.findViewById(R.id.gesture_items);
            r8.itemLayout = r6.findViewById(R.id.gesture_item_layout);
            r8.videoBg = r6.findViewById(R.id.video_background);
            r8.progressBar = (ProgressBar) r6.findViewById(R.id.progress_bar);
            r8.videoView.setOnPreparedListener(new AnonymousClass1(this, r8));
            r8.videoView.setOnErrorListener(new GestureFragment$GestureAdapter$$ExternalSyntheticLambda1(this, r8));
            r6.setTag(r8);
            goto L10
        L7:
            r6 = LayoutInflater.from(this.this$0.mContext).inflate(R.layout.touchpad_gesture_group_layout, r7, false);
            goto L8
        }

        /* JADX INFO: renamed from: lambda$getView$2$com-android-settings-revone-boston-GestureFragment$GestureAdapter, reason: not valid java name */
        /* synthetic */ boolean m576xf895eacf(final ViewHolder r2, MediaPlayer r3, int r4, int r5) {
            OLog.e(GestureFragment.TAG, "VideoView " + r2.videoView.getTag() + "onError : " + r4 + " - " + r5);
            if (r5 != Integer.MIN_VALUE) goto L7;
            GestureFragment.access$100(this.this$0).fetchVideo((String) r2.videoView.getTag(), new GestureFragment$GestureAdapter$$ExternalSyntheticLambda8(this, r2));
            return true;
        L7:
            return true;
        }

        /* JADX INFO: renamed from: lambda$getView$1$com-android-settings-revone-boston-GestureFragment$GestureAdapter, reason: not valid java name */
        /* synthetic */ void m575x1cd46f0e(final ViewHolder r3, final boolean r4, final Uri r5) {
            GestureFragment.access$000(this.this$0).post(new GestureFragment$GestureAdapter$$ExternalSyntheticLambda0(this, r3, r4, r5));
        }

        /* JADX INFO: renamed from: lambda$getView$0$com-android-settings-revone-boston-GestureFragment$GestureAdapter, reason: not valid java name */
        /* synthetic */ void m574x4112f34d(ViewHolder r1, boolean r2, Uri r3) {
            if (r2 == false) goto L4;
            LoadStatus r4 = LoadStatus.loadSuccess;
        L5:
            updateVideoView(r1, r4, r3);
            return;
        L4:
            r4 = LoadStatus.loadFailed;
            goto L5
        }

        /* JADX INFO: renamed from: lambda$getView$4$com-android-settings-revone-boston-GestureFragment$GestureAdapter, reason: not valid java name */
        /* synthetic */ void m578xb018e251(final ViewHolder r3, final boolean r4, final Uri r5) {
            GestureFragment.access$000(this.this$0).post(new GestureFragment$GestureAdapter$$ExternalSyntheticLambda7(this, r3, r4, r5));
        }

        /* JADX INFO: renamed from: lambda$getView$3$com-android-settings-revone-boston-GestureFragment$GestureAdapter, reason: not valid java name */
        /* synthetic */ void m577xd4576690(ViewHolder r1, boolean r2, Uri r3) {
            if (r2 == false) goto L4;
            LoadStatus r4 = LoadStatus.loadSuccess;
        L5:
            updateVideoView(r1, r4, r3);
            return;
        L4:
            r4 = LoadStatus.loadFailed;
            goto L5
        }

        private void addChildren(final ViewHolder r6, GestureGroup r7) {
            r6.itemsView.removeAllViews();
            int r0 = 0;
        L4:
            if (r0 >= r7.items.size()) goto L14;
            final GestureGroup.GestureItem r1 = r7.items.get(r0);
            SettingItemCheckEx r2 = new SettingItemCheckEx(this.this$0.getContext());
            r2.setTitle(r1.title);
            r2.setSummary(r1.desc);
            r2.setChecked(GestureFragment.access$200(this.this$0, r1.key));
            r2.setCheckboxEnabled(GestureFragment.access$300(this.this$0, r1.key));
            r2.setTag(r1.key);
            if (r0 != 0) goto L9;
            r2.setBackgroundResource(R.drawable.selector_setting_item_check_ex_top);
        L12:
            r2.setOnClickListener(new GestureFragment$GestureAdapter$$ExternalSyntheticLambda5(this, r1, r6));
            r2.setOnCheckedChangeListener(new GestureFragment$GestureAdapter$$ExternalSyntheticLambda6(this, r1));
            r6.itemsView.addView(r2);
            r0 = r0 + 1;
            goto L4
        L9:
            if (r0 != (GestureFragment.access$400(this.this$0) - 1)) goto L11;
            r2.setBackgroundResource(R.drawable.selector_setting_item_check_ex_bottom);
            goto L12
        L11:
            r2.setBackgroundResource(R.drawable.selector_setting_item_check_ex_middle);
            goto L12
        L14:
            if (r7.items.size() >= GestureFragment.access$400(this.this$0)) goto L21;
            TextView r3 = new TextView(this.this$0.mContext);
            r3.setBackgroundResource(R.drawable.list_gesture_left_bottom);
            r3.setHeight(Utils.dp2Pixels(this.this$0.mContext, (GestureFragment.access$400(this.this$0) - r7.items.size()) * 60));
            r6.itemsView.addView(r3, new LinearLayout.LayoutParams(-1, -2));
            return;
        }

        /* JADX INFO: renamed from: lambda$addChildren$7$com-android-settings-revone-boston-GestureFragment$GestureAdapter, reason: not valid java name */
        /* synthetic */ void m572x5b113039(GestureGroup.GestureItem r2, final ViewHolder r3, View r4) {
            Uri r5 = getVideoUri(r2);
            if (r5 != null) goto L5;
            updateVideoView(r3, LoadStatus.loading, r5);
            GestureFragment.access$100(this.this$0).fetchVideo(r2.key, new GestureFragment$GestureAdapter$$ExternalSyntheticLambda3(this, r3));
            return;
        L5:
            updateVideoView(r3, LoadStatus.loadSuccess, r5);
        }

        /* JADX INFO: renamed from: lambda$addChildren$6$com-android-settings-revone-boston-GestureFragment$GestureAdapter, reason: not valid java name */
        /* synthetic */ void m571x7f4fb478(final ViewHolder r3, final boolean r4, final Uri r5) {
            GestureFragment.access$000(this.this$0).post(new GestureFragment$GestureAdapter$$ExternalSyntheticLambda4(this, r3, r4, r5));
        }

        /* JADX INFO: renamed from: lambda$addChildren$5$com-android-settings-revone-boston-GestureFragment$GestureAdapter, reason: not valid java name */
        /* synthetic */ void m570xa38e38b7(ViewHolder r1, boolean r2, Uri r3) {
            if (r2 == false) goto L4;
            LoadStatus r4 = LoadStatus.loadSuccess;
        L5:
            updateVideoView(r1, r4, r3);
            return;
        L4:
            r4 = LoadStatus.loadFailed;
            goto L5
        }

        /* JADX INFO: renamed from: lambda$addChildren$8$com-android-settings-revone-boston-GestureFragment$GestureAdapter, reason: not valid java name */
        /* synthetic */ void m573x36d2abfa(GestureGroup.GestureItem r1, CompoundButton r2, boolean r3) {
            GestureFragment.access$700(this.this$0, r1.key, r3);
        }

        private Uri getVideoUri(GestureGroup.GestureItem r3) {
            File r0 = new File(GestureFragment.access$500(this.this$0), r3.key + ".mp4");
            if (r0.exists() == true) goto L5;
            return null;
        L5:
            return Uri.fromFile(r0);
        }

        private void updateVideoView(ViewHolder r4, LoadStatus r5, Uri r6) {
            int r7 = AnonymousClass1.$SwitchMap$com$android$settings$revone$boston$GestureFragment$LoadStatus[r5.ordinal()];
            if (r7 != 1) goto L5;
            r4.progressBar.setVisibility(8);
            r4.videoView.setVisibility(0);
            r4.videoBg.setVisibility(0);
            r4.videoView.setVideoURI(r6);
            return;
        L5:
            if (r7 != 2) goto L7;
            r4.progressBar.setVisibility(8);
            r4.videoView.stopPlayback();
            r4.videoView.setVisibility(8);
            r4.videoBg.setVisibility(0);
            r4.videoBg.setBackgroundResource(R.drawable.load_fail_video);
            if (GestureFragment.access$600(this.this$0) != 0) goto L13;
        L14:
            ToastUtils.show(this.this$0.getActivity(), R.string.toast_gesture_download_error);
            GestureFragment.access$602(this.this$0, System.currentTimeMillis());
            return;
        L13:
            if ((System.currentTimeMillis() - GestureFragment.access$600(this.this$0)) > 10000) goto L14;
            return;
        L7:
            if (r7 != 3) goto L20;
            r4.progressBar.setVisibility(0);
            r4.videoView.stopPlayback();
            r4.videoView.setVisibility(8);
            r4.videoBg.setVisibility(0);
            r4.videoBg.setBackgroundResource(android.R.color.white);
            return;
        }
    }

    public static final enum LoadStatus extends Enum<LoadStatus> {
        private static final /* synthetic */ LoadStatus[] $VALUES = null;
        public static final LoadStatus loadFailed = null;
        public static final LoadStatus loadSuccess = null;
        public static final LoadStatus loading = null;

        private static /* synthetic */ LoadStatus[] $values() {
            return new LoadStatus[]{loading, loadSuccess, loadFailed};
        }

        private LoadStatus(String r1, int r2) {
            super(r1, r2);
        }

        public static LoadStatus valueOf(String r1) {
            return (LoadStatus) Enum.valueOf(LoadStatus.class, r1);
        }

        public static LoadStatus[] values() {
            return (LoadStatus[]) $VALUES.clone();
        }

        static {
            loading = new LoadStatus("loading", 0);
            loadSuccess = new LoadStatus("loadSuccess", 1);
            loadFailed = new LoadStatus("loadFailed", 2);
            $VALUES = $values();
        }
    }

    public GestureFragment() {
        this.mGestureGroups = new ArrayList();
        this.mHandler = new Handler();
        this.mToastTime = 0;
    }

    static /* synthetic */ Handler access$000(GestureFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ GestureVideoDownloader access$100(GestureFragment r0) {
        return r0.mVideoDownloader;
    }

    static /* synthetic */ boolean access$200(GestureFragment r0, String r1) {
        return r0.isGestureEnabled(r1);
    }

    static /* synthetic */ boolean access$300(GestureFragment r0, String r1) {
        return r0.isCheckboxEnabled(r1);
    }

    static /* synthetic */ int access$400(GestureFragment r0) {
        return r0.mMaxItemCount;
    }

    static /* synthetic */ String access$500(GestureFragment r0) {
        return r0.mVideoDirPath;
    }

    static /* synthetic */ long access$600(GestureFragment r2) {
        return r2.mToastTime;
    }

    static /* synthetic */ long access$602(GestureFragment r0, long r1) {
        r0.mToastTime = r1;
        return r1;
    }

    static /* synthetic */ void access$700(GestureFragment r0, String r1, boolean r2) {
        r0.setGestureEnabled(r1, r2);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 != null) goto L5;
    L8:
        int r5 = 1;
    L9:
        this.mType = r5;
        return;
    L5:
        if (r4.getInt(KEY_TYPE) == 0) goto L8;
        r5 = r4.getInt(KEY_TYPE);
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.gesture_list_layout, r4, false);
        this.mListview = (ListView) findViewByIdNullable(R.id.list_view);
        GestureAdapter r6 = new GestureAdapter(this);
        this.mAdapter = r6;
        this.mListview.setAdapter(r6);
        OFloatingTitleBar r7 = (OFloatingTitleBar) findViewByIdNullable(R.id.view_title);
        View r8 = r3.inflate(R.layout.gesture_header_layout, r4, false);
        SettingItemText r9 = (SettingItemText) r8.findViewById(R.id.gesture_header_title);
        r9.setBackgroundResource(R.drawable.setting_item_bg_blue);
        TextView r10 = r9.getTitleView();
        r10.setTextColor(this.mContext.getResources().getColor(R.color.setting_item_text_blue));
        if (this.mType != 1) goto L5;
        r7.setCenterTitle(R.string.screen_gesture);
        r10.setText(R.string.screen_gesture_desc);
        this.mListview.addHeaderView(r8);
        this.mMaxItemCount = 4;
    L6:
        initItems();
        this.mVideoDownloader = new GestureVideoDownloader(this.mContext);
        this.mVideoDirPath = this.mContext.getExternalFilesDir(null).getAbsolutePath() + File.separator + "gesture";
        return this.mRootView;
    L5:
        r7.setCenterTitle(R.string.touchpad_pager_header_title);
        this.mMaxItemCount = 7;
        goto L6
    }

    private boolean isGestureEnabled(String r2) {
        if (Settings.Global.getInt(getContentResolver(), r2, GestureHelper.getDefaultValue(r2)) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setGestureEnabled(String r1, boolean r2) {
        Settings.Global.putInt(getContentResolver(), r1, r2 ? 1 : 0);
    }

    private boolean isCheckboxEnabled(String r1) {
        return GestureHelper.isCheckboxEnabled(r1);
    }

    private void initItems() {
        this.mGestureGroups.clear();
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = this.mType;
        if (r1 != 1) goto L9;
        this.mGestureGroups = GestureHelper.getScreenGestures(r0);
        return;
    L9:
        if (r1 != 2) goto L13;
        this.mGestureGroups = GestureHelper.getTouchpadGestures(r0);
        return;
    }
}
