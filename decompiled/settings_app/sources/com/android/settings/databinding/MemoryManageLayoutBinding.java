package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.deviceinfo.StorageProgressBarItem;
import com.android.settings.deviceinfo.StorageVolumeView;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class MemoryManageLayoutBinding implements ViewBinding {
    public final InstallManageStorageBinding externalStorage;
    public final SettingItemText fileStorageDetail;
    public final ImageView ivApp;
    public final ImageView ivCache;
    public final ImageView ivDownload;
    public final ImageView ivFree;
    public final ImageView ivMusic;
    public final ImageView ivOther;
    public final ImageView ivPic;
    public final ImageView ivTotal;
    public final StorageVolumeView llContent;
    public final LinearLayout llProgressbar;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final PortableStorageLayoutBinding portableStorageLayout;
    private final RelativeLayout rootView;
    public final TextView total;
    public final TextView totalSize;
    public final TextView tvApp;
    public final TextView tvAppSize;
    public final TextView tvDownload;
    public final TextView tvDownloadSize;
    public final TextView tvFree;
    public final TextView tvFreeSize;
    public final TextView tvMusic;
    public final TextView tvMusicSize;
    public final TextView tvOther;
    public final TextView tvOtherSize;
    public final TextView tvPic;
    public final TextView tvPicSize;
    public final TextView tvSystem;
    public final TextView tvSystemSize;
    public final StorageProgressBarItem viewApp;
    public final StorageProgressBarItem viewCache;
    public final StorageProgressBarItem viewDownload;
    public final StorageProgressBarItem viewMusic;
    public final StorageProgressBarItem viewOther;
    public final StorageProgressBarItem viewPic;
    public final OFloatingTitleBar viewTitle;
    public final View viewUsed;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private MemoryManageLayoutBinding(RelativeLayout r3, InstallManageStorageBinding r4, SettingItemText r5, ImageView r6, ImageView r7, ImageView r8, ImageView r9, ImageView r10, ImageView r11, ImageView r12, ImageView r13, StorageVolumeView r14, LinearLayout r15, LinearLayout r16, OScrollView r17, PortableStorageLayoutBinding r18, TextView r19, TextView r20, TextView r21, TextView r22, TextView r23, TextView r24, TextView r25, TextView r26, TextView r27, TextView r28, TextView r29, TextView r30, TextView r31, TextView r32, TextView r33, TextView r34, StorageProgressBarItem r35, StorageProgressBarItem r36, StorageProgressBarItem r37, StorageProgressBarItem r38, StorageProgressBarItem r39, StorageProgressBarItem r40, OFloatingTitleBar r41, View r42) {
        this.rootView = r3;
        this.externalStorage = r4;
        this.fileStorageDetail = r5;
        this.ivApp = r6;
        this.ivCache = r7;
        this.ivDownload = r8;
        this.ivFree = r9;
        this.ivMusic = r10;
        this.ivOther = r11;
        this.ivPic = r12;
        this.ivTotal = r13;
        this.llContent = r14;
        this.llProgressbar = r15;
        this.pageContainer = r16;
        this.pageScrollview = r17;
        this.portableStorageLayout = r18;
        this.total = r19;
        this.totalSize = r20;
        this.tvApp = r21;
        this.tvAppSize = r22;
        this.tvDownload = r23;
        this.tvDownloadSize = r24;
        this.tvFree = r25;
        this.tvFreeSize = r26;
        this.tvMusic = r27;
        this.tvMusicSize = r28;
        this.tvOther = r29;
        this.tvOtherSize = r30;
        this.tvPic = r31;
        this.tvPicSize = r32;
        this.tvSystem = r33;
        this.tvSystemSize = r34;
        this.viewApp = r35;
        this.viewCache = r36;
        this.viewDownload = r37;
        this.viewMusic = r38;
        this.viewOther = r39;
        this.viewPic = r40;
        this.viewTitle = r41;
        this.viewUsed = r42;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MemoryManageLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MemoryManageLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.memory_manage_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static MemoryManageLayoutBinding bind(View r44) {
        int r1 = R.id.external_storage;
        View r2 = ViewBindings.findChildViewById(r44, R.id.external_storage);
        if (r2 == null) goto L83;
        InstallManageStorageBinding r5 = InstallManageStorageBinding.bind(r2);
        r1 = R.id.file_storage_detail;
        SettingItemText r6 = (SettingItemText) ViewBindings.findChildViewById(r44, R.id.file_storage_detail);
        if (r6 == null) goto L83;
        r1 = R.id.iv_app;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r44, R.id.iv_app);
        if (r7 == null) goto L83;
        r1 = R.id.iv_cache;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r44, R.id.iv_cache);
        if (r8 == null) goto L83;
        r1 = R.id.iv_download;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r44, R.id.iv_download);
        if (r9 == null) goto L83;
        r1 = R.id.iv_free;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r44, R.id.iv_free);
        if (r10 == null) goto L83;
        r1 = R.id.iv_music;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(r44, R.id.iv_music);
        if (r11 == null) goto L83;
        r1 = R.id.iv_other;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r44, R.id.iv_other);
        if (r12 == null) goto L83;
        r1 = R.id.iv_pic;
        ImageView r13 = (ImageView) ViewBindings.findChildViewById(r44, R.id.iv_pic);
        if (r13 == null) goto L83;
        r1 = R.id.iv_total;
        ImageView r14 = (ImageView) ViewBindings.findChildViewById(r44, R.id.iv_total);
        if (r14 == null) goto L83;
        r1 = R.id.ll_content;
        StorageVolumeView r15 = (StorageVolumeView) ViewBindings.findChildViewById(r44, R.id.ll_content);
        if (r15 == null) goto L83;
        r1 = R.id.ll_progressbar;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r44, R.id.ll_progressbar);
        if (r16 == null) goto L83;
        r1 = R.id.page_container;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r44, R.id.page_container);
        if (r17 == null) goto L83;
        r1 = R.id.page_scrollview;
        OScrollView r18 = (OScrollView) ViewBindings.findChildViewById(r44, R.id.page_scrollview);
        if (r18 == null) goto L83;
        r1 = R.id.portable_storage_layout;
        View r3 = ViewBindings.findChildViewById(r44, R.id.portable_storage_layout);
        if (r3 == null) goto L83;
        PortableStorageLayoutBinding r19 = PortableStorageLayoutBinding.bind(r3);
        r1 = R.id.total;
        TextView r20 = (TextView) ViewBindings.findChildViewById(r44, R.id.total);
        if (r20 == null) goto L83;
        r1 = R.id.total_size;
        TextView r21 = (TextView) ViewBindings.findChildViewById(r44, R.id.total_size);
        if (r21 == null) goto L83;
        r1 = R.id.tv_app;
        TextView r22 = (TextView) ViewBindings.findChildViewById(r44, R.id.tv_app);
        if (r22 == null) goto L83;
        r1 = R.id.tv_app_size;
        TextView r23 = (TextView) ViewBindings.findChildViewById(r44, R.id.tv_app_size);
        if (r23 == null) goto L83;
        r1 = R.id.tv_download;
        TextView r24 = (TextView) ViewBindings.findChildViewById(r44, R.id.tv_download);
        if (r24 == null) goto L83;
        r1 = R.id.tv_download_size;
        TextView r25 = (TextView) ViewBindings.findChildViewById(r44, R.id.tv_download_size);
        if (r25 == null) goto L83;
        r1 = R.id.tv_free;
        TextView r26 = (TextView) ViewBindings.findChildViewById(r44, R.id.tv_free);
        if (r26 == null) goto L83;
        r1 = R.id.tv_free_size;
        TextView r27 = (TextView) ViewBindings.findChildViewById(r44, R.id.tv_free_size);
        if (r27 == null) goto L83;
        r1 = R.id.tv_music;
        TextView r28 = (TextView) ViewBindings.findChildViewById(r44, R.id.tv_music);
        if (r28 == null) goto L83;
        r1 = R.id.tv_music_size;
        TextView r29 = (TextView) ViewBindings.findChildViewById(r44, R.id.tv_music_size);
        if (r29 == null) goto L83;
        r1 = R.id.tv_other;
        TextView r30 = (TextView) ViewBindings.findChildViewById(r44, R.id.tv_other);
        if (r30 == null) goto L83;
        r1 = R.id.tv_other_size;
        TextView r31 = (TextView) ViewBindings.findChildViewById(r44, R.id.tv_other_size);
        if (r31 == null) goto L83;
        r1 = R.id.tv_pic;
        TextView r32 = (TextView) ViewBindings.findChildViewById(r44, R.id.tv_pic);
        if (r32 == null) goto L83;
        r1 = R.id.tv_pic_size;
        TextView r33 = (TextView) ViewBindings.findChildViewById(r44, R.id.tv_pic_size);
        if (r33 == null) goto L83;
        r1 = R.id.tv_system;
        TextView r34 = (TextView) ViewBindings.findChildViewById(r44, R.id.tv_system);
        if (r34 == null) goto L83;
        r1 = R.id.tv_system_size;
        TextView r35 = (TextView) ViewBindings.findChildViewById(r44, R.id.tv_system_size);
        if (r35 == null) goto L83;
        r1 = R.id.view_app;
        StorageProgressBarItem r36 = (StorageProgressBarItem) ViewBindings.findChildViewById(r44, R.id.view_app);
        if (r36 == null) goto L83;
        r1 = R.id.view_cache;
        StorageProgressBarItem r37 = (StorageProgressBarItem) ViewBindings.findChildViewById(r44, R.id.view_cache);
        if (r37 == null) goto L83;
        r1 = R.id.view_download;
        StorageProgressBarItem r38 = (StorageProgressBarItem) ViewBindings.findChildViewById(r44, R.id.view_download);
        if (r38 == null) goto L83;
        r1 = R.id.view_music;
        StorageProgressBarItem r39 = (StorageProgressBarItem) ViewBindings.findChildViewById(r44, R.id.view_music);
        if (r39 == null) goto L83;
        r1 = R.id.view_other;
        StorageProgressBarItem r40 = (StorageProgressBarItem) ViewBindings.findChildViewById(r44, R.id.view_other);
        if (r40 == null) goto L83;
        r1 = R.id.view_pic;
        StorageProgressBarItem r41 = (StorageProgressBarItem) ViewBindings.findChildViewById(r44, R.id.view_pic);
        if (r41 == null) goto L83;
        r1 = R.id.view_title;
        OFloatingTitleBar r42 = (OFloatingTitleBar) ViewBindings.findChildViewById(r44, R.id.view_title);
        if (r42 == null) goto L83;
        r1 = R.id.view_used;
        View r43 = ViewBindings.findChildViewById(r44, R.id.view_used);
        if (r43 == null) goto L83;
        return new MemoryManageLayoutBinding((RelativeLayout) r44, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43);
    L83:
        throw new NullPointerException("Missing required view with ID: ".concat(r44.getResources().getResourceName(r1)));
    }
}
