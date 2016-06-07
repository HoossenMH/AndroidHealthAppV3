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
//import com.example.hoossenlenovo.assignment6.designPatterns.domain.Exercise;
//import com.example.hoossenlenovo.assignment6.repository.ExerciseRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by hoossenLenovo on 2016-04-24.
// */
//public class ExerciseRepositoryImpl extends SQLiteOpenHelper implements ExerciseRepository
//{
//    public static final String TABLE_NAME = "exercise";
//    private SQLiteDatabase db;
//
//    public static final String COLUMN_ID = "id";
//    public static final String COLUMN_DONE = "DONE";
//
//    // Database creation sql statement
//    private static final String DATABASE_CREATE = " CREATE TABLE "
//            + TABLE_NAME + "("
//            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
//            + COLUMN_DONE + " TEXT NOT NULL );";
//
//    public ExerciseRepositoryImpl(Context context) {
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
//    public Exercise findById(Long id) {
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(
//                TABLE_NAME,
//                new String[]{
//                        COLUMN_ID,
//                        COLUMN_DONE},
//                COLUMN_ID + " =? ",
//                new String[]{String.valueOf(id)},
//                null,
//                null,
//                null);
//        if (cursor.moveToFirst()) {
//            final Exercise exercise = new Exercise.Builder()
//                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
//                    .done(cursor.getString(cursor.getColumnIndex(COLUMN_DONE)))
//                    .build();
//
//            return exercise;
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public Exercise save(Exercise entity) {
//        open();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_ID, entity.getId());
//        values.put(COLUMN_DONE, entity.exerciseDone());
//        long id = db.insertOrThrow(TABLE_NAME, null, values);
//
//        Exercise insertedEntity = new Exercise.Builder()
//                .copy(entity)
//                .id(new Long(id))
//                .build();
//        return insertedEntity;
//    }
//
//    @Override
//    public Exercise update(Exercise entity) {
//        open();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_ID, entity.getId());
//        values.put(COLUMN_DONE, entity.exerciseDone());
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
//    public Set<Exercise> findAll() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Set<Exercise> exercises = new HashSet<>();
//        open();
//        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
//        if (cursor.moveToFirst()) {
//            do {
//                final Exercise exercise = new Exercise.Builder()
//                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
//                        .done(cursor.getString(cursor.getColumnIndex(COLUMN_DONE)))
//                        .build();
//                exercises.add(exercise);
//            } while (cursor.moveToNext());
//        }
//        return exercises;
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
//    public Exercise delete(Exercise entity) {
//        return entity;
//    }
//}
