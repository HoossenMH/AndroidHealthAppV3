//package com.example.hoossenlenovo.assignment6.repository.impl;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;
//
//import com.example.hoossenlenovo.assignment6.conf.database.DBConstants;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by Admin on 2016/06/07.
// */
//public class WeightlossRepositoryImpl extends SQLiteOpenHelper implements WeightlossRepository
//{
//    public static final String TABLE_NAME = "weightloss";
//    private SQLiteDatabase db;
//
//    public static final String COLUMN_ID = "id";
//    public static final String COLUMN_SQUATAMOUNT = "squatAmount";
//    public static final String COLUMN_PUSHPRESSAMOUNT = "pushPressAmount";
//    public static final String COLUMN_RUNNNINGKM = "runnningKm";
//
//    // Database creation sql statement
//    private static final String DATABASE_CREATE = " CREATE TABLE "
//            + TABLE_NAME + "("
//            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
//            + COLUMN_SQUATAMOUNT + " TEXT UNIQUE NOT NULL , "
//            + COLUMN_PUSHPRESSAMOUNT + " TEXT UNIQUE NOT NULL , "
//            + COLUMN_RUNNNINGKM + " TEXT NOT NULL );";
//
//    public WeightlossRepositoryImpl(Context context) {
//        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
//    }
//    public void open() throws SQLException {
//        db = this.getWritableDatabase();
//    }
//    public void close() {
//        this.close();
//    }
//
//
//    @Override
//    public Weightloss findById(Long id) {
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(
//                TABLE_NAME,
//                new String[]{
//                        COLUMN_ID,
//                        COLUMN_SQUATAMOUNT,
//                        COLUMN_PUSHPRESSAMOUNT,
//                        COLUMN_RUNNNINGKM},
//                COLUMN_ID + " =? ",
//                new String[]{String.valueOf(id)},
//                null,
//                null,
//                null);
//        if (cursor.moveToFirst()) {
//            final Weightloss weightloss = new Weightloss.Builder()
//                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
//                    .squatAmount(cursor.getString(cursor.getColumnIndex(COLUMN_SQUATAMOUNT)))
//                    .pushPressAmount(cursor.getString(cursor.getColumnIndex(COLUMN_PUSHPRESSAMOUNT)))
//                    .runnningKm(cursor.getString(cursor.getColumnIndex(COLUMN_RUNNNINGKM)))
//                    .build();
//
//            return weightloss;
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public Weightloss save(Weightloss entity) {
//        open();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_ID, entity.getId());
//        values.put(COLUMN_SQUATAMOUNT, entity.getSquatAmount());
//        values.put(COLUMN_PUSHPRESSAMOUNT, entity.getPushPressAmount());
//        values.put(COLUMN_RUNNNINGKM, entity.getRunnningKm());
//        long id = db.insertOrThrow(TABLE_NAME, null, values);
//
//        Weightloss insertedEntity = new Weightloss.Builder()
//                .copy(entity)
//                .id(new Long(id))
//                .build();
//        return insertedEntity;
//    }
//
//    @Override
//    public Weightloss update(Weightloss entity) {
//        open();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_ID, entity.getId());
//        values.put(COLUMN_SQUATAMOUNT, entity.getSquatAmount());
//        values.put(COLUMN_PUSHPRESSAMOUNT, entity.getPushPressAmount());
//        values.put(COLUMN_RUNNNINGKM, entity.getRunnningKm());
//        db.update(
//                TABLE_NAME,
//                values,
//                COLUMN_ID + " =? ",
//                new String[]{String.valueOf(entity.getId())}
//        );
//        return entity;
//    }
//
//    @Override
//    public Set<Weightloss> findAll() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Set<Weightloss> weightlosss = new HashSet<>();
//        open();
//        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
//        if (cursor.moveToFirst()) {
//            do {
//                final Weightloss weightloss = new Weightloss.Builder()
//                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
//                        .squatAmount(cursor.getString(cursor.getColumnIndex(COLUMN_SQUATAMOUNT)))
//                        .pushPressAmount(cursor.getString(cursor.getColumnIndex(COLUMN_PUSHPRESSAMOUNT)))
//                        .runnningKm(cursor.getString(cursor.getColumnIndex(COLUMN_RUNNNINGKM)))
//                        .build();
//                weightlosss.add(weightloss);
//            } while (cursor.moveToNext());
//        }
//        return weightlosss;
//    }
//
//    @Override
//    public int deleteAll() {
//        open();
//        int rowsDeleted = db.delete(TABLE_NAME,null,null);
//        close();
//        return rowsDeleted;
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(DATABASE_CREATE);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        Log.w(this.getClass().getName(),
//                "Upgrading database from version " + oldVersion + " to "
//                        + newVersion + ", which will destroy all old data");
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(db);
//
//    }
//
//    @Override
//    public Weightloss delete(Weightloss entity) {
//        return entity;
//    }
//}
