package com.obric.safecheck.dataSync;

import android.content.Context;
import com.obric.olog.OLog;
import com.obric.safecheck.data.FakeParseData;
import com.obric.safecheck.data.ParsedData;
import com.obric.safecheck.data.ParsedPhoneData;
import com.obric.safecheck.data.ParsedPkgData;
import com.obric.safecheck.data.ParsedUrlData;
import com.obric.safecheck.database.AntiFraudDatabase;
import com.obric.safecheck.database.dao.PhoneDao;
import com.obric.safecheck.database.dao.PkgSignDao;
import com.obric.safecheck.database.dao.UrlDomainDao;
import com.obric.safecheck.database.entity.Item;
import com.obric.safecheck.util.GetDateAfter6MonthsKt;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatabaseConsumer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020,J\b\u0010.\u001a\u00020,H\u0002J\u0018\u0010/\u001a\u00020,2\u0010\u00100\u001a\f\u0012\u0006\b\u0001\u0012\u00020$\u0018\u00010#R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0017\u001a\n \u000f*\u0004\u0018\u00010\u00180\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR#\u0010\u001c\u001a\n \u000f*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0013\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020$0#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010&\u001a\n \u000f*\u0004\u0018\u00010'0'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0013\u001a\u0004\b(\u0010)¨\u00061"}, d2 = {"Lcom/obric/safecheck/dataSync/DatabaseConsumer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "apkCount", "", "consumerExecutor", "Ljava/util/concurrent/ExecutorService;", "consumerThread", "Ljava/lang/Thread;", "database", "Lcom/obric/safecheck/database/AntiFraudDatabase;", "kotlin.jvm.PlatformType", "getDatabase", "()Lcom/obric/safecheck/database/AntiFraudDatabase;", "database$delegate", "Lkotlin/Lazy;", "isConsumerStopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "phoneCount", "phoneDao", "Lcom/obric/safecheck/database/dao/PhoneDao;", "getPhoneDao", "()Lcom/obric/safecheck/database/dao/PhoneDao;", "phoneDao$delegate", "pkgSignDao", "Lcom/obric/safecheck/database/dao/PkgSignDao;", "getPkgSignDao", "()Lcom/obric/safecheck/database/dao/PkgSignDao;", "pkgSignDao$delegate", "taskQueue", "Ljava/util/concurrent/BlockingQueue;", "Lcom/obric/safecheck/data/ParsedData;", "Lcom/obric/safecheck/database/entity/Item;", "urlCount", "urlDomainDao", "Lcom/obric/safecheck/database/dao/UrlDomainDao;", "getUrlDomainDao", "()Lcom/obric/safecheck/database/dao/UrlDomainDao;", "urlDomainDao$delegate", "deleteOlderThan", "", "onAllCompleted", "startConsumer", "submit", "parsedData", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class DatabaseConsumer {
    private final String TAG;
    private int apkCount;
    private final ExecutorService consumerExecutor;
    private Thread consumerThread;
    private final Lazy database$delegate;
    private final AtomicBoolean isConsumerStopped;
    private int phoneCount;
    private final Lazy phoneDao$delegate;
    private final Lazy pkgSignDao$delegate;
    private final BlockingQueue<ParsedData<? extends Item>> taskQueue;
    private int urlCount;
    private final Lazy urlDomainDao$delegate;

    private final AntiFraudDatabase getDatabase() {
        return (AntiFraudDatabase) this.database$delegate.getValue();
    }

    private final PhoneDao getPhoneDao() {
        return (PhoneDao) this.phoneDao$delegate.getValue();
    }

    private final PkgSignDao getPkgSignDao() {
        return (PkgSignDao) this.pkgSignDao$delegate.getValue();
    }

    private final UrlDomainDao getUrlDomainDao() {
        return (UrlDomainDao) this.urlDomainDao$delegate.getValue();
    }

    public DatabaseConsumer(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.TAG = "DatabaseConsumer_AntiFraud";
        this.database$delegate = LazyKt.lazy(new DatabaseConsumer$database$2(r2));
        this.pkgSignDao$delegate = LazyKt.lazy(new DatabaseConsumer$pkgSignDao$2(this));
        this.phoneDao$delegate = LazyKt.lazy(new DatabaseConsumer$phoneDao$2(this));
        this.urlDomainDao$delegate = LazyKt.lazy(new DatabaseConsumer$urlDomainDao$2(this));
        this.taskQueue = new LinkedBlockingQueue(2);
        ExecutorService r3 = Executors.newSingleThreadExecutor(DatabaseConsumer$consumerExecutor$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(r3, "Executors.newSingleThrea…aseConsumerThread\")\n    }");
        this.consumerExecutor = r3;
        this.isConsumerStopped = new AtomicBoolean(false);
        this.apkCount = 0;
        this.urlCount = 0;
        this.phoneCount = 0;
        startConsumer();
    }

    public static final /* synthetic */ Thread access$getConsumerThread$p(DatabaseConsumer r0) {
        return r0.consumerThread;
    }

    public static final /* synthetic */ AntiFraudDatabase access$getDatabase$p(DatabaseConsumer r0) {
        return r0.getDatabase();
    }

    public static final /* synthetic */ PhoneDao access$getPhoneDao$p(DatabaseConsumer r0) {
        return r0.getPhoneDao();
    }

    public static final /* synthetic */ PkgSignDao access$getPkgSignDao$p(DatabaseConsumer r0) {
        return r0.getPkgSignDao();
    }

    public static final /* synthetic */ String access$getTAG$p(DatabaseConsumer r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ BlockingQueue access$getTaskQueue$p(DatabaseConsumer r0) {
        return r0.taskQueue;
    }

    public static final /* synthetic */ UrlDomainDao access$getUrlDomainDao$p(DatabaseConsumer r0) {
        return r0.getUrlDomainDao();
    }

    public static final /* synthetic */ AtomicBoolean access$isConsumerStopped$p(DatabaseConsumer r0) {
        return r0.isConsumerStopped;
    }

    public static final /* synthetic */ void access$setConsumerThread$p(DatabaseConsumer r0, Thread r1) {
        r0.consumerThread = r1;
    }

    public final void submit(ParsedData<? extends Item> r5) {
        OLog.d(this.TAG, "提交任务到队列，队列当前大小: " + this.taskQueue.size());     // Catch: InterruptedException -> L18
        if (r5 != null) goto L8;
        OLog.w(this.TAG, "提交的任务为空，忽略");     // Catch: InterruptedException -> L18
        return;
    L8:
        if ((r5 instanceof ParsedPkgData) == false) goto L11;
        this.apkCount += r5.getCount();     // Catch: InterruptedException -> L18
    L16:
        this.taskQueue.put(r5);     // Catch: InterruptedException -> L18
        return;
    L11:
        if ((r5 instanceof ParsedUrlData) == false) goto L14;
        this.urlCount += r5.getCount();     // Catch: InterruptedException -> L18
        goto L16
    L14:
        if ((r5 instanceof ParsedPhoneData) == false) goto L16;
        this.phoneCount += r5.getCount();     // Catch: InterruptedException -> L18
    L18:
        e = move-exception;
        OLog.e(this.TAG, "提交任务时线程被中断", e);
        Thread.currentThread().interrupt();
    }

    private final void startConsumer() {
        this.consumerExecutor.submit(new AnonymousClass1(this));
    }

    public final void onAllCompleted() {
        OLog.d(this.TAG, "已经全部完成 onAllCompleted");
        this.isConsumerStopped.set(true);
        this.taskQueue.put(new FakeParseData());
        OLog.d(this.TAG, "apkCount: " + this.apkCount + ", urlCount: " + this.urlCount + ", phoneCount: " + this.phoneCount);
    }

    public final void deleteOlderThan() {
        String r0 = GetDateAfter6MonthsKt.getDateBeforeXMonths(12);
        OLog.d(this.TAG, "删除所有过期数据: " + r0);
        getPhoneDao().deleteDataBeforeDate(r0);
        getUrlDomainDao().deleteDataBeforeDate(r0);
        getPkgSignDao().deleteDataBeforeDate(r0);
    }
}
