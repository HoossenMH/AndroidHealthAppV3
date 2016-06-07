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
//public class OverallFitnessRepositoryImpl extends SQLiteOpenHelper implements OverallFitnessRepository
//{
//    public static final String TABLE_NAME = "user";
//    private SQLiteDatabase db;
//
//    public static final String COLUMN_ID = "id";
//    public static final String COLUMN_RUNNINGKM = "runningKm";
//    public static final String COLUMN_SKIPPINGROPEAMOUNT = "skippingRopeAmount";
//
//    // Database creation sql statement
//    private static final String DATABASE_CREATE = " CREATE TABLE "
//            + TABLE_NAME + "("
//            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
//            + COLUMN_RUNNINGKM + " TEXT UNIQUE NOT NULL , "
//            + COLUMN_SKIPPINGROPEAMOUNT + " TEXT NOT NULL );";
//
//    public OverallFitnessRepositoryImpl(Context context) {
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
//    public OverallFitness findById(Long id) {
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(
//                TABLE_NAME,
//                new String[]{
//                        COLUMN_ID,
//                        COLUMN_RUNNINGKM,
//                        COLUMN_SKIPPINGROPEAMOUNT},
//                COLUMN_ID + " =? ",
//                new String[]{String.valueOf(id)},
//                null,
//                null,
//                null);
//        if (cursor.moveToFirst()) {
//            final OverallFitness OverallFitness = new OverallFitness.Builder()
//                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
//                    .runningKm(cursor.getString(cursor.getColumnIndex(COLUMN_RUNNINGKM)))
//                    .skippingRopeAmount(cursor.getString(cursor.getColumnIndex(COLUMN_SKIPPINGROPEAMOUNT)))
//                    .build();
//
//            return OverallFitness;
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public OverallFitness save(OverallFitness entity) {
//        open();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_ID, entity.getId());
//        values.put(COLUMN_RUNNINGKM, entity.getRunningKm());
//        values.put(COLUMN_SKIPPINGROPEAMOUNT, entity.getSkippingRopeAmount());
//        long id = db.insertOrThrow(TABLE_NAME, null, values);
//
//        OverallFitness insertedEntity = new OverallFitness.Builder()
//                .copy(entity)
//                .id(new Long(id))
//                .build();
//        return insertedEntity;
//    }
//
//    @Override
//    public OverallFitness update(OverallFitness entity) {
//        open();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_ID, entity.getId());
//        values.put(COLUMN_RUNNINGKM, entity.getRunningKm());
//        values.put(COLUMN_SKIPPINGROPEAMOUNT, entity.getSkippingRopeAmount());
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
//    public Set<OverallFitness> findAll() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Set<OverallFitness> overallFitnesss = new HashSet<>();
//        open();
//        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
//        if (cursor.moveToFirst()) {
//            do {
//                final OverallFitness overallFitness = new OverallFitness.Builder()
//                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
//                        .runningKm(cursor.getString(cursor.getColumnIndex(COLUMN_RUNNINGKM)))
//                        .skippingRopeAmount(cursor.getString(cursor.getColumnIndex(COLUMN_SKIPPINGROPEAMOUNT)))
//                        .build();
//                overallFitnesss.add(overallFitness);
//            } while (cursor.moveToNext());
//        }
//        return overallFitnesss;
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
//    public OverallFitness delete(OverallFitness entity) {
//        return entity;
//    }
//}