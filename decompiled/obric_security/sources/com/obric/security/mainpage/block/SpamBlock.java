package com.obric.security.mainpage.block;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.room.RoomDatabase;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.blockframework.framework.base.UIBlock;
import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedanceos.preventdisturb.BlackCallLogList;
import com.bytedanceos.preventdisturb.Conversation;
import com.bytedanceos.preventdisturb.SpamConversationList;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OTextView;
import com.obric.security.R;
import com.obric.security.mainpage.block.depend.IHolderBlockDepend;
import com.obric.security.mainpage.delegate.data.KeyFeatureData;
import com.obric.security.mainpage.delegate.data.KeyFeatureModel;
import com.ss.android.message.log.PushLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import obric.util.DisplayHelper;

/* JADX INFO: compiled from: SpamBlock.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001@B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010,\u001a\u00020\nH\u0016J\"\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010.2\u0006\u0010/\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020*H\u0016J\"\u00103\u001a\u00020*2\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010.2\b\u00105\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u00106\u001a\u00020*2\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010.H\u0016J\b\u00107\u001a\u00020*H\u0016J\b\u00108\u001a\u00020*H\u0016J\u0010\u00109\u001a\u00020*2\u0006\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020*H\u0002J\b\u0010=\u001a\u00020*H\u0002J\b\u0010>\u001a\u00020*H\u0002J\b\u0010?\u001a\u00020*H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006A"}, d2 = {"Lcom/obric/security/mainpage/block/SpamBlock;", "Lcom/bytedance/blockframework/framework/base/UIBlock;", "Lcom/obric/security/mainpage/delegate/data/KeyFeatureData;", "Lcom/obric/security/mainpage/delegate/data/KeyFeatureModel;", "Landroid/app/LoaderManager$LoaderCallbacks;", "Landroid/database/Cursor;", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "(Lcom/bytedance/blockframework/framework/join/IBlockContext;)V", "MAX_NUMBER", "", "callNumber", "callResolver", "Landroid/content/ContentResolver;", "holderDepend", "Lcom/obric/security/mainpage/block/depend/IHolderBlockDepend;", "getHolderDepend", "()Lcom/obric/security/mainpage/block/depend/IHolderBlockDepend;", "holderDepend$delegate", "Lkotlin/properties/ReadOnlyProperty;", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", PushLog.KEY_LABEL, "Lcom/obric/oui/text/OTextView;", "mCallInterceptObserver", "Landroid/database/ContentObserver;", "mQueryHandler", "Lcom/obric/security/mainpage/block/SpamBlock$ThreadListQueryHandler;", "queryCallStatus", "querySmsStatus", "smsNumber", "smsResolver", "title", "getTitle", "()Lcom/obric/oui/text/OTextView;", "setTitle", "(Lcom/obric/oui/text/OTextView;)V", "bindModel", "", "model", "layoutResource", "onCreateLoader", "Landroid/content/Loader;", SlardarConfigConsts.CONFIG_ID, "args", "Landroid/os/Bundle;", "onDestroy", "onLoadFinished", "loader", "data", "onLoaderReset", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "registerObserver", "startAsyncQuery", "startQuery", "unregisterObserver", "ThreadListQueryHandler", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SpamBlock extends UIBlock<KeyFeatureData, KeyFeatureModel> implements LoaderManager.LoaderCallbacks<Cursor> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final int MAX_NUMBER;
    private int callNumber;
    private ContentResolver callResolver;
    private final ReadOnlyProperty holderDepend$delegate;
    private ImageView icon;
    private OTextView label;
    private final ContentObserver mCallInterceptObserver;
    private ThreadListQueryHandler mQueryHandler;
    private int queryCallStatus;
    private int querySmsStatus;
    private int smsNumber;
    private ContentResolver smsResolver;
    private OTextView title;

    /* JADX INFO: compiled from: SpamBlock.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/security/mainpage/block/SpamBlock$ThreadListQueryHandler;", "Lcom/bytedanceos/preventdisturb/Conversation$ConversationQueryHandler;", "contentResolver", "Landroid/content/ContentResolver;", "(Landroid/content/ContentResolver;)V", "mQueryCallback", "Lcom/obric/security/mainpage/block/SpamBlock$ThreadListQueryHandler$IQueryCallback;", "onQueryComplete", "", "token", "", BaseHttpRequestInfo.KEY_COOKIE, "", "cursor", "Landroid/database/Cursor;", "setQueryCallback", "queryCallback", "IQueryCallback", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class ThreadListQueryHandler extends Conversation.ConversationQueryHandler {
        private IQueryCallback mQueryCallback;

        /* JADX INFO: compiled from: SpamBlock.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/security/mainpage/block/SpamBlock$ThreadListQueryHandler$IQueryCallback;", "", "onQueryComplete", "", "cursor", "Landroid/database/Cursor;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
        public interface IQueryCallback {
            void onQueryComplete(Cursor r1);
        }

        public ThreadListQueryHandler(ContentResolver r1) {
            super(r1);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int r1, Object r2, Cursor r3) {
            IQueryCallback r0 = this.mQueryCallback;
            if (r0 == null) goto L6;
            r0.onQueryComplete(r3);
            return;
        }

        public final void setQueryCallback(IQueryCallback r1) {
            this.mQueryCallback = r1;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(SpamBlock.class, "holderDepend", "getHolderDepend()Lcom/obric/security/mainpage/block/depend/IHolderBlockDepend;", 0))};
    }

    private final IHolderBlockDepend getHolderDepend() {
        return (IHolderBlockDepend) this.holderDepend$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // com.bytedance.blockframework.framework.base.UIBlock
    public int layoutResource() {
        return R.layout.key_feature_item_block;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> r1) {
    }

    public SpamBlock(IBlockContext r2) {
        Intrinsics.checkNotNullParameter(r2, "blockContext");
        super(r2);
        this.MAX_NUMBER = RoomDatabase.MAX_BIND_PARAMETER_CNT;
        this.holderDepend$delegate = new SpamBlock$$special$$inlined$findDepend$1(this);
        final Handler r0 = new Handler();
        this.mCallInterceptObserver = new SpamBlock$mCallInterceptObserver$1(this, r0);
    }

    public static final /* synthetic */ int access$getCallNumber$p(SpamBlock r0) {
        return r0.callNumber;
    }

    public static final /* synthetic */ OTextView access$getLabel$p(SpamBlock r0) {
        return r0.label;
    }

    public static final /* synthetic */ int access$getMAX_NUMBER$p(SpamBlock r0) {
        return r0.MAX_NUMBER;
    }

    public static final /* synthetic */ int access$getQueryCallStatus$p(SpamBlock r0) {
        return r0.queryCallStatus;
    }

    public static final /* synthetic */ int access$getQuerySmsStatus$p(SpamBlock r0) {
        return r0.querySmsStatus;
    }

    public static final /* synthetic */ int access$getSmsNumber$p(SpamBlock r0) {
        return r0.smsNumber;
    }

    public static final /* synthetic */ void access$setCallNumber$p(SpamBlock r0, int r1) {
        r0.callNumber = r1;
    }

    public static final /* synthetic */ void access$setLabel$p(SpamBlock r0, OTextView r1) {
        r0.label = r1;
    }

    public static final /* synthetic */ void access$setQueryCallStatus$p(SpamBlock r0, int r1) {
        r0.queryCallStatus = r1;
    }

    public static final /* synthetic */ void access$setQuerySmsStatus$p(SpamBlock r0, int r1) {
        r0.querySmsStatus = r1;
    }

    public static final /* synthetic */ void access$setSmsNumber$p(SpamBlock r0, int r1) {
        r0.smsNumber = r1;
    }

    public static final /* synthetic */ void access$startQuery(SpamBlock r0) {
        r0.startQuery();
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock
    public /* bridge */ /* synthetic */ void bindModel(IBlockModel r1) {
        bindModel((KeyFeatureModel) r1);
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<Cursor> r1, Cursor r2) {
        onLoadFinished2(r1, r2);
    }

    public final ImageView getIcon() {
        return this.icon;
    }

    public final void setIcon(ImageView r1) {
        this.icon = r1;
    }

    public final OTextView getTitle() {
        return this.title;
    }

    public final void setTitle(OTextView r1) {
        this.title = r1;
    }

    @Override // com.bytedance.blockframework.framework.base.UIBlock, com.bytedance.blockframework.framework.base.IUIBlock
    public void onViewCreated(final View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Context r0 = r4.getContext();
        if (r0 == null) goto L25;
        this.callResolver = ((Activity) r0).getContentResolver();
        this.smsResolver = SecurityCenterApplication.getApplication().getContentResolver();
        ThreadListQueryHandler r1 = new ThreadListQueryHandler(this.smsResolver);
        this.mQueryHandler = r1;
        r1.setQueryCallback(new AnonymousClass1(this));
        this.icon = (ImageView) r4.findViewById(R.id.icon);
        this.title = (OTextView) r4.findViewById(R.id.title);
        this.label = (OTextView) r4.findViewById(R.id.label);
        ImageView r2 = this.icon;
        if (r2 == null) goto L7;
        Intrinsics.checkNotNull(r2);
        r2.setImageDrawable(AppCompatResources.getDrawable(r2.getContext(), R.drawable.spam));
    L7:
        OTextView r3 = this.title;
        View r5 = null;
        if (r3 == null) goto L16;
        if (r3 == null) goto L13;
        Context r6 = r3.getContext();
        if (r6 == null) goto L13;
        String r7 = r6.getString(R.string.security_no_disturb);
    L14:
        r3.setText(r7);
    L13:
        r7 = null;
    L16:
        if ((r4 instanceof OUILinearLayout) == false) goto L19;
        r5 = r4;
    L19:
        OUILinearLayout r8 = (OUILinearLayout) r5;
        if (r8 == null) goto L22;
        r8.setRadius(DisplayHelper.dpToPx(16));
    L22:
        r4.setOnClickListener(new AnonymousClass2(r4));
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onResume() {
        super.onResume();
        startQuery();
        registerObserver();
    }

    private final void startQuery() {
        this.querySmsStatus = 0;
        this.queryCallStatus = 0;
        this.smsNumber = 0;
        this.callNumber = 0;
        startAsyncQuery();
        OTextView r0 = this.label;
        if (r0 == null) goto L5;
        Context r1 = r0.getContext();
    L6:
        Activity r2 = (Activity) r1;
        if (r2 == null) goto L12;
        LoaderManager r3 = r2.getLoaderManager();
        if (r3 == null) goto L13;
        r3.restartLoader(1, null, this);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onPause() {
        super.onPause();
        this.querySmsStatus = 0;
        this.queryCallStatus = 0;
        unregisterObserver();
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onDestroy() {
        super.onDestroy();
        ThreadListQueryHandler r0 = this.mQueryHandler;
        Context r1 = null;
        if (r0 == null) goto L5;
        r0.setQueryCallback(null);
    L5:
        OTextView r2 = this.label;
        if (r2 == null) goto L8;
        r1 = r2.getContext();
    L8:
        Activity r3 = (Activity) r1;
        if (r3 == null) goto L14;
        LoaderManager r4 = r3.getLoaderManager();
        if (r4 == null) goto L15;
        r4.destroyLoader(1);
        return;
    L15:
        return;
    }

    private final void registerObserver() {
        ContentResolver r0 = this.callResolver;
        if (r0 == null) goto L5;
        r0.registerContentObserver(BlackCallLogList.CALL_INTERCEPT_COUNT_URI, true, this.mCallInterceptObserver);
    L5:
        ContentResolver r1 = this.smsResolver;
        if (r1 == null) goto L9;
        r1.registerContentObserver(Conversation.sAllSpamThreadsUri, true, this.mCallInterceptObserver);
        return;
    }

    private final void unregisterObserver() {
        ContentResolver r0 = this.callResolver;
        if (r0 == null) goto L5;
        r0.unregisterContentObserver(this.mCallInterceptObserver);
    L5:
        ContentResolver r1 = this.smsResolver;
        if (r1 == null) goto L9;
        r1.unregisterContentObserver(this.mCallInterceptObserver);
        return;
    }

    private final void startAsyncQuery() {
        Conversation.startQuery(this.mQueryHandler, SpamConversationList.THREAD_LIST_QUERY_TOKEN, null, true);     // Catch: SQLiteException -> L4
        return;
    }

    public void bindModel(KeyFeatureModel r1) {
        super.bindModel(r1);
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int r8, Bundle r9) {
        OTextView r10 = this.label;
        Context r11 = null;
        if (r10 == null) goto L5;
        Context r12 = r10.getContext();
    L7:
        if ((r12 instanceof Activity) == true) goto L9;
        return null;
    L9:
        OTextView r7 = this.label;
        if (r7 == null) goto L13;
        r11 = r7.getContext();
    L13:
        return new CursorLoader(r11, BlackCallLogList.CALL_LOG_SUMMARY_LIST_URI, BlackCallLogList.CALLLOG_PROJECTION, null, null, "bcl_datetime");
    L5:
        r12 = null;
        goto L7
    }

    /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
    public void onLoadFinished2(Loader<Cursor> r9, Cursor r10) {
        if (r10 == null) goto L5;
        int r0 = r10.getCount();
    L6:
        String r4 = null;
        if ((r0 + this.smsNumber) <= this.MAX_NUMBER) goto L16;
        OTextView r8 = this.label;
        if (r8 == null) goto L74;
        if (r8 == null) goto L14;
        Context r11 = r8.getContext();
        if (r11 == null) goto L14;
        r4 = r11.getString(R.string.spam_block_label, new Object[]{"999+"});
    L14:
        r8.setText(r4);
        return;
    L74:
        return;
    L16:
        if (r10 != null) goto L67;
    L35:
        int r1 = 0;
    L36:
        if (r10 != null) goto L34;
    L38:
        this.queryCallStatus = 1;
        this.callNumber = r1;
        if (this.querySmsStatus != 1) goto L75;
        int r12 = this.smsNumber;
        if ((r12 + r1) != 0) goto L50;
        OTextView r13 = this.label;
        if (r13 == null) goto L76;
        if (r13 == null) goto L48;
        Context r14 = r13.getContext();
        if (r14 == null) goto L48;
        r4 = r14.getString(R.string.security_no_disturb_label);
    L48:
        r13.setText(r4);
        return;
    L76:
        return;
    L50:
        if ((r12 + r1) <= this.MAX_NUMBER) goto L58;
        OTextView r15 = this.label;
        if (r15 == null) goto L78;
        if (r15 == null) goto L57;
        Context r16 = r15.getContext();
        if (r16 == null) goto L57;
        r4 = r16.getString(R.string.spam_block_label, new Object[]{"999+"});
    L57:
        r15.setText(r4);
        return;
    L78:
        return;
    L58:
        OTextView r17 = this.label;
        if (r17 == null) goto L80;
        if (r17 == null) goto L64;
        Context r2 = r17.getContext();
        if (r2 == null) goto L64;
        r4 = r2.getString(R.string.spam_block_label, new Object[]{String.valueOf(this.smsNumber + this.callNumber)});
    L64:
        r17.setText(r4);
        return;
    L80:
        return;
    L75:
        return;
    L34:
        r10.close();
        goto L38
    L67:
        if (r10.moveToFirst() == false) goto L35;
        r1 = 0;
        boolean r3 = false;
    L69:
        r1 = r1 + r10.getInt(4);     // Catch: Throwable -> L28 Exception -> L66
        if ((this.smsNumber + r1) <= this.MAX_NUMBER) goto L24;
        r3 = true;
    L24:
        if (r10.moveToNext() == false) goto L36;
        if (r3 == false) goto L69;
    L33:
        if (r10 == null) goto L38;
    L28:
        th = move-exception;
        if (r10 == null) goto L31;
        r10.close();
    L31:
        throw th;
    L32:
        r1 = 0;
        goto L33
    L5:
        r0 = 0;
        goto L6
    }
}
