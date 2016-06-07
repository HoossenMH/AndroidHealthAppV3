package com.example.hoossenlenovo.assignment6.repository.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.hoossenlenovo.assignment6.conf.database.DBConstants;
import com.example.hoossenlenovo.assignment6.designPatterns.domain.FitnessBio;
import com.example.hoossenlenovo.assignment6.repository.FitnessBioRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Admin on 2016/06/07.
 */
public class FitnessBioRepositoryImpl extends SQLiteOpenHelper implements FitnessBioRepository
{
    public static final String TABLE_NAME = "fitnessBio";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_GOALS = "goals";
    public static final String COLUMN_REASONS = "reasons";
    public static final String COLUMN_EXERCISE = "exercise";
    public static final String COLUMN_YN = "yn";
    public static final String COLUMN_WEIGHT = "weight";
    public static final String COLUMN_HEIGHT = "height";
    public static final String COLUMN_BMI = "BMI";
    public static final String COLUMN_FITLEVEL = "fitLevel";
    public static final String COLUMN_BLOODPRESSURE = "bloodPressure";
    public static final String COLUMN_DIETLEVEL = "dietlevel";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_GOALS + " TEXT UNIQUE NOT NULL , "
            + COLUMN_REASONS + " TEXT UNIQUE NOT NULL , "
            + COLUMN_EXERCISE + " TEXT UNIQUE NOT NULL , "
            + COLUMN_YN + " TEXT UNIQUE NOT NULL , "
            + COLUMN_WEIGHT + " TEXT UNIQUE NOT NULL , "
            + COLUMN_HEIGHT + " TEXT UNIQUE NOT NULL , "
            + COLUMN_BMI + " TEXT UNIQUE NOT NULL , "
            + COLUMN_FITLEVEL + " TEXT UNIQUE NOT NULL , "
            + COLUMN_DIETLEVEL + " TEXT UNIQUE NOT NULL , "
            + COLUMN_BLOODPRESSURE + " TEXT NOT NULL );";

    public FitnessBioRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }
    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }
    public void close() {
        this.close();
    }


    @Override
    public FitnessBio findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_GOALS,
                        COLUMN_REASONS,
                        COLUMN_EXERCISE,
                        COLUMN_YN,
                        COLUMN_WEIGHT,
                        COLUMN_HEIGHT,
                        COLUMN_BMI,
                        COLUMN_FITLEVEL,
                        COLUMN_DIETLEVEL,
                        COLUMN_BLOODPRESSURE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final FitnessBio fitnessBio = new FitnessBio.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .goals(cursor.getString(cursor.getColumnIndex(COLUMN_GOALS)))
                    .reasons(cursor.getString(cursor.getColumnIndex(COLUMN_REASONS)))
                    .exercise(cursor.getString(cursor.getColumnIndex(COLUMN_EXERCISE)))
                    .yn(cursor.getString(cursor.getColumnIndex(COLUMN_YN)))
                    .weight(cursor.getFloat(cursor.getColumnIndex(COLUMN_WEIGHT)))
                    .height(cursor.getFloat(cursor.getColumnIndex(COLUMN_HEIGHT)))
                    .BMI(cursor.getFloat(cursor.getColumnIndex(COLUMN_BMI)))
                    .fitLevel(cursor.getInt(cursor.getColumnIndex(COLUMN_FITLEVEL)))
                    .dietlevel(cursor.getInt(cursor.getColumnIndex(COLUMN_DIETLEVEL)))
                    .bloodPressure(cursor.getString(cursor.getColumnIndex(COLUMN_BLOODPRESSURE)))
                    .build();

            return fitnessBio;
        } else {
            return null;
        }
    }

    @Override
    public FitnessBio save(FitnessBio entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_GOALS, entity.getGoals());
        values.put(COLUMN_REASONS, entity.getReasons());
        values.put(COLUMN_EXERCISE, entity.getExercise());
        values.put(COLUMN_YN, entity.getYn());
        values.put(COLUMN_WEIGHT, entity.getWeight());
        values.put(COLUMN_HEIGHT, entity.getHeight());
        values.put(COLUMN_BMI, entity.getBMI());
        values.put(COLUMN_FITLEVEL, entity.getFitLevel());
        values.put(COLUMN_DIETLEVEL, entity.getDietlevel());
        values.put(COLUMN_BLOODPRESSURE, entity.getBloodPressure());
        long id = db.insertOrThrow(TABLE_NAME, null, values);

        FitnessBio insertedEntity = new FitnessBio.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public FitnessBio update(FitnessBio entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_GOALS, entity.getGoals());
        values.put(COLUMN_REASONS, entity.getReasons());
        values.put(COLUMN_EXERCISE, entity.getExercise());
        values.put(COLUMN_YN, entity.getYn());
        values.put(COLUMN_WEIGHT, entity.getWeight());
        values.put(COLUMN_HEIGHT, entity.getHeight());
        values.put(COLUMN_BMI, entity.getBMI());
        values.put(COLUMN_FITLEVEL, entity.getFitLevel());
        values.put(COLUMN_DIETLEVEL, entity.getDietlevel());
        values.put(COLUMN_BLOODPRESSURE, entity.getBloodPressure());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Set<FitnessBio> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<FitnessBio> fitnessBios = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final FitnessBio fitnessBio = new FitnessBio.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .goals(cursor.getString(cursor.getColumnIndex(COLUMN_GOALS)))
                        .reasons(cursor.getString(cursor.getColumnIndex(COLUMN_REASONS)))
                        .exercise(cursor.getString(cursor.getColumnIndex(COLUMN_EXERCISE)))
                        .yn(cursor.getString(cursor.getColumnIndex(COLUMN_YN)))
                        .weight(cursor.getFloat(cursor.getColumnIndex(COLUMN_WEIGHT)))
                        .height(cursor.getFloat(cursor.getColumnIndex(COLUMN_HEIGHT)))
                        .BMI(cursor.getFloat(cursor.getColumnIndex(COLUMN_BMI)))
                        .fitLevel(cursor.getInt(cursor.getColumnIndex(COLUMN_FITLEVEL)))
                        .dietlevel(cursor.getInt(cursor.getColumnIndex(COLUMN_DIETLEVEL)))
                        .bloodPressure(cursor.getString(cursor.getColumnIndex(COLUMN_BLOODPRESSURE)))
                        .build();
                fitnessBios.add(fitnessBio);
            } while (cursor.moveToNext());
        }
        return fitnessBios;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    @Override
    public FitnessBio delete(FitnessBio entity) {
        return entity;
    }
}
