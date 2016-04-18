package com.gsu.cs4998.project.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.gsu.cs4998.project.model.BathSchedule;
import com.gsu.cs4998.project.model.Children;
import com.gsu.cs4998.project.model.Diaper;
import com.gsu.cs4998.project.model.LiquidFood;
import com.gsu.cs4998.project.model.Medication;
import com.gsu.cs4998.project.model.Sleep;
import com.gsu.cs4998.project.model.SolidFood;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shakeelosmani on 16/04/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 5;

    // Database Name
    private static final String DATABASE_NAME = "babyTracker";

    // Table Names
    private static final String TABLE_BABY = "babies";
    private static final String TABLE_SOLIDFEED = "solidfeeds";
    private static final String TABLE_LIQUIDFEED = "liquidfeeds";
    private static final String TABLE_DIAPER = "diaper";
    private static final String TABLE_SLEEP = "sleep";
    private static final String TABLE_BATH = "bath";
    private static final String TABLE_MEDICINE = "medicine";

    // Common column names
    private static final String KEY_ID = "id";

    // babaies Table - column nmaes
    private static final String KEY_NAME = "name";
    private static final String KEY_IMAGEPATH = "imagepath";
    private static final String KEY_BIRTHDATE = "birthdate";
    private static final String KEY_BIRTHMONTH = "birthmonth";
    private static final String KEY_SEX = "sex";
    private static final String KEY_HEIGHTFEET = "heightfeet";
    private static final String KEY_HEIGHTINCH = "heighrinch";
    private static final String KEY_WEIGHT = "weight";

    // diaper Table - column nmaes
    private static final String KEY_DIAPERFORPOOP = "poop";
    private static final String KEY_DIAPERFORPEE = "pee";
    private static final String KEY_DIAPERDATE = "day";
    private static final String KEY_DIAPERMONTH = "month";
    private static final String KEY_DIAPERHOUR = "hour";
    private static final String KEY_DIAPERMINUTE = "minute";
    private static final String KEY_DIAPERBRAND = "brand";
    private static final String KEY_DIAPEROBSERVATION = "observation";

    // sleep Table - column nmaes
    private static final String KEY_SLEEPDATE = "date";
    private static final String KEY_SLEEPMONTH = "month";
    private static final String KEY_SLEEPHOURFROM = "hourfrom";
    private static final String KEY_SLEEPMINUTEFROM = "minutefrom";
    private static final String KEY_SLEEPHOURTO = "hourto";
    private static final String KEY_SLEEPMINUTETO = "minuteto";
    private static final String KEY_SLEEPOBSERVATION = "observation";


    // bath Table - column nmaes
    private static final String KEY_BATHDATE = "date";
    private static final String KEY_BATHMONTH = "month";
    private static final String KEY_BATHHOUR = "hour";
    private static final String KEY_BATHMINUTE = "minute";
    private static final String KEY_BATHDIAPER = "diaper";
    private static final String KEY_BATHOBSERVATION = "observation";

    // liquid food Table - column nmaes
    private static final String KEY_LIQUIDFOODNAME = "name";
    private static final String KEY_LIQUIDFOODQUANTITY = "quantity";
    private static final String KEY_LIQUIDFOODMEASURETYPE = "measure";
    private static final String KEY_LIQUIDFOODHOUR = "hour";
    private static final String KEY_LIQUIDFOODMINUTE = "minute";
    private static final String KEY_LIQUIDFOODOBSERVATION = "observation";
    private static final String KEY_LIQUIDFOODDAY = "day";
    private static final String KEY_LIQUIDFOODMONTH = "month";

    // solid food Table - column nmaes
    private static final String KEY_SOLIDFOODNAME = "name";
    private static final String KEY_SOLIDFOODMEASURETYPE = "measure";
    private static final String KEY_SOLIDFOODDAY = "day";
    private static final String KEY_SOLIDFOODMONTH = "month";
    private static final String KEY_SOLIDFOODHOUR = "hour";
    private static final String KEY_SOLIDFOODMINUTE = "minute";
    private static final String KEY_SOLIDFOODOBSERVATION = "observation";


    // medicine food Table - column nmaes
    private static final String KEY_MEDICINENAME = "name";
    private static final String KEY_MEDICINEQUANTITY = "quantity";
    private static final String KEY_MEDICINEMEASURETYPE = "measure";
    private static final String KEY_MEDICINESYMPTOMS = "symptoms";
    private static final String KEY_MEDICINEHOUR = "hour";
    private static final String KEY_MEDICINEMINUTE = "minute";
    private static final String KEY_MEDICINEDATE = "date";
    private static final String KEY_MEDICINEMONTH = "month";
    private static final String KEY_MEDICINEOBSERVATION = "observation";


    // Table Create Statements

    //baby table
    private static final String CREATE_TABLE_BABIES = "CREATE TABLE "
            + TABLE_BABY + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_IMAGEPATH + " TEXT," + KEY_BIRTHDATE + " TEXT," + KEY_BIRTHMONTH + " TEXT,"
            + KEY_SEX + " TEXT," + KEY_HEIGHTFEET + " TEXT," + KEY_HEIGHTINCH + " TEXT," + KEY_WEIGHT +
            " TEXT" + ")";

    //solid food table
    private static final String CREATE_TABLE_SOLIDFEED = "CREATE TABLE "
            + TABLE_SOLIDFEED + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_SOLIDFOODNAME
            + " TEXT," + KEY_SOLIDFOODMEASURETYPE + " TEXT," + KEY_SOLIDFOODHOUR + " TEXT,"
            + KEY_SOLIDFOODMINUTE + " TEXT," + KEY_SOLIDFOODOBSERVATION + " TEXT," + KEY_SOLIDFOODDAY + " TEXT," + KEY_SOLIDFOODMONTH +" TEXT" +")";

    //liquid food table
    private static final String CREATE_TABLE_LIQUIDFEED = "CREATE TABLE "
            + TABLE_LIQUIDFEED + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_LIQUIDFOODNAME
            + " TEXT," + KEY_LIQUIDFOODQUANTITY + " TEXT," + KEY_LIQUIDFOODMEASURETYPE + " TEXT," + KEY_LIQUIDFOODHOUR + " TEXT,"
            + KEY_LIQUIDFOODMINUTE + " TEXT," + KEY_LIQUIDFOODOBSERVATION + " TEXT," + KEY_LIQUIDFOODDAY + " TEXT," + KEY_LIQUIDFOODMONTH +" TEXT" +")";

    //diaper table
    private static final String CREATE_TABLE_DIAPER = "CREATE TABLE "
            + TABLE_DIAPER + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_DIAPERFORPOOP
            + " TEXT," + KEY_DIAPERFORPEE + " TEXT," + KEY_DIAPERDATE + " TEXT," + KEY_DIAPERMONTH + " TEXT," + KEY_DIAPERHOUR + " TEXT," + KEY_DIAPERMINUTE + " TEXT,"
            + KEY_DIAPERBRAND + " TEXT," + KEY_DIAPEROBSERVATION + " TEXT" + ")";

    //sleep table
    private static final String CREATE_TABLE_SLEEP = "CREATE TABLE "
            + TABLE_SLEEP + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_SLEEPDATE + " TEXT," + KEY_SLEEPMONTH
            + " TEXT," + KEY_SLEEPHOURFROM + " TEXT," + KEY_SLEEPMINUTEFROM + " TEXT," + KEY_SLEEPHOURTO + " TEXT,"
            + KEY_SLEEPMINUTETO + " TEXT," + KEY_SLEEPOBSERVATION + " TEXT" + ")";

    //bath table
    private static final String CREATE_TABLE_BATH = "CREATE TABLE "
            + TABLE_BATH + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_BATHDATE + " TEXT," + KEY_BATHMONTH
            + " TEXT," + KEY_BATHHOUR + " TEXT," + KEY_BATHMINUTE + " TEXT," + KEY_BATHDIAPER + " TEXT,"
            + KEY_BATHOBSERVATION + " TEXT" + ")";

    //medicine table
    private static final String CREATE_TABLE_MEDICINE = "CREATE TABLE "
            + TABLE_MEDICINE + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_MEDICINENAME + " TEXT," + KEY_MEDICINEQUANTITY
            + " TEXT," + KEY_MEDICINEMEASURETYPE + " TEXT," + KEY_MEDICINESYMPTOMS + " TEXT," + KEY_MEDICINEDATE + " TEXT,"
            + KEY_MEDICINEMONTH + " TEXT," + KEY_MEDICINEHOUR + " TEXT," + KEY_MEDICINEMINUTE + " TEXT," + KEY_MEDICINEOBSERVATION + " TEXT" + ")";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_BABIES);
        db.execSQL(CREATE_TABLE_BATH);
        db.execSQL(CREATE_TABLE_DIAPER);
        db.execSQL(CREATE_TABLE_LIQUIDFEED);
        db.execSQL(CREATE_TABLE_SOLIDFEED);
        db.execSQL(CREATE_TABLE_MEDICINE);
        db.execSQL(CREATE_TABLE_SLEEP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BABY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BATH);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DIAPER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LIQUIDFEED);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SOLIDFEED);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEDICINE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SLEEP);

        // create new tables
        onCreate(db);

    }

    // We will start adding one by one the methods needed

    // First the methods for add baby

    public Long createBaby(Children children){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME,children.getName());
        contentValues.put(KEY_BIRTHDATE,children.getBirthDate());
        contentValues.put(KEY_BIRTHMONTH,children.getBirthMonth());
        contentValues.put(KEY_SEX,children.getSex());
        contentValues.put(KEY_HEIGHTFEET,children.getHeightFeet());
        contentValues.put(KEY_HEIGHTINCH,children.getHeightInch());
        contentValues.put(KEY_WEIGHT,children.getWeight());
        contentValues.put(KEY_IMAGEPATH,children.getImagePath());

        Long baby_id = database.insert(TABLE_BABY,null,contentValues);
        return baby_id;
    }

    // get all babies

    public List<Children> getAllChildren(){
        List<Children> childrenList = new ArrayList<Children>();
        String sqlQuery = "SELECT * FROM " + TABLE_BABY;
        Log.e(LOG, sqlQuery);

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery, null);
        if(cursor.moveToFirst()){
            do{
                Children child = new Children();
                child.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
                child.setBirthMonth(cursor.getString(cursor.getColumnIndex(KEY_BIRTHMONTH)));
                child.setSex(cursor.getString(cursor.getColumnIndex(KEY_SEX)));
                child.setBirthDate(cursor.getString(cursor.getColumnIndex(KEY_BIRTHDATE)));
                child.setHeightInch(cursor.getString(cursor.getColumnIndex(KEY_HEIGHTINCH)));
                child.setHeightFeet(cursor.getString(cursor.getColumnIndex(KEY_HEIGHTFEET)));
                child.setWeight(cursor.getString(cursor.getColumnIndex(KEY_WEIGHT)));
                child.setImagePath(cursor.getString(cursor.getColumnIndex(KEY_IMAGEPATH)));
                childrenList.add(child);

            }while (cursor.moveToNext());
        }
        return childrenList;

    }

    // get image of last child to show on home

    public String getChildPic(){
        String imagePath ="";
        String sqlQuery = "SELECT "+KEY_IMAGEPATH+ ", "+KEY_ID+ " FROM " + TABLE_BABY+ " ORDER BY " +KEY_ID+ " DESC LIMIT 1";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery,null);
        if(cursor.moveToFirst()){
            imagePath = cursor.getString(cursor.getColumnIndex(KEY_IMAGEPATH));
        }
        return imagePath;
    }

    // insert into LIQUIDFEED

    public Long saveLiquidFood(LiquidFood liquidFood){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_LIQUIDFOODNAME,liquidFood.getLiquidFoodName());
        contentValues.put(KEY_LIQUIDFOODMEASURETYPE,liquidFood.getLiquidFoodMeasureType());
        contentValues.put(KEY_LIQUIDFOODQUANTITY,liquidFood.getLiquidFoodQuantity());
        contentValues.put(KEY_LIQUIDFOODHOUR,liquidFood.getLiquidFoodHour());
        contentValues.put(KEY_LIQUIDFOODMINUTE,liquidFood.getLiquidFoodMinute());
        contentValues.put(KEY_LIQUIDFOODDAY,liquidFood.getLiquidFoodDay());
        contentValues.put(KEY_LIQUIDFOODMONTH,liquidFood.getLiquidFoodMonth());
        contentValues.put(KEY_LIQUIDFOODOBSERVATION,liquidFood.getObservation());

        Long liquidFoodId = database.insert(TABLE_LIQUIDFEED,null,contentValues);

        return liquidFoodId;

    }

    public List<LiquidFood> getAllLiquidFood(){
        List<LiquidFood> liquidFoodList = new ArrayList<LiquidFood>();
        String sqlQuery = "SELECT * FROM " + TABLE_LIQUIDFEED;
        Log.e(LOG, sqlQuery);

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery, null);
        if(cursor.moveToFirst()){
            do{
                LiquidFood liquidFood = new LiquidFood();
                liquidFood.setLiquidFoodName(cursor.getString(cursor.getColumnIndex(KEY_LIQUIDFOODNAME)));
                liquidFood.setLiquidFoodDay(cursor.getString(cursor.getColumnIndex(KEY_LIQUIDFOODDAY)));
                liquidFood.setLiquidFoodQuantity(cursor.getString(cursor.getColumnIndex(KEY_LIQUIDFOODQUANTITY)));
                liquidFood.setLiquidFoodHour(cursor.getString(cursor.getColumnIndex(KEY_LIQUIDFOODHOUR)));
                liquidFood.setLiquidFoodMinute(cursor.getString(cursor.getColumnIndex(KEY_LIQUIDFOODMINUTE)));
                liquidFood.setLiquidFoodMonth(cursor.getString(cursor.getColumnIndex(KEY_LIQUIDFOODMONTH)));
                liquidFood.setLiquidFoodMeasureType(cursor.getString(cursor.getColumnIndex(KEY_LIQUIDFOODMEASURETYPE)));
                liquidFood.setObservation(cursor.getString(cursor.getColumnIndex(KEY_LIQUIDFOODOBSERVATION)));

                liquidFoodList.add(liquidFood);

            }while (cursor.moveToNext());
        }
        return liquidFoodList;

    }

    //Insert into SOLIDFEED

    public Long saveSolidFood(SolidFood solidFood){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_SOLIDFOODNAME,solidFood.getSolidFoodName());
        contentValues.put(KEY_SOLIDFOODDAY,solidFood.getSolidFoodDay());
        contentValues.put(KEY_SOLIDFOODMONTH,solidFood.getSoliFoodMonth());
        contentValues.put(KEY_SOLIDFOODHOUR,solidFood.getSolidFoodHour());
        contentValues.put(KEY_SOLIDFOODMINUTE,solidFood.getSolidFoodMinute());
        contentValues.put(KEY_SOLIDFOODOBSERVATION,solidFood.getObservation());

        Long solidFeedId = database.insert(TABLE_SOLIDFEED,null,contentValues);

        return solidFeedId;

    }

    public List<SolidFood> getAllSolidFood(){
        List<SolidFood> solidFoodList = new ArrayList<SolidFood>();
        String sqlQuery = "SELECT * FROM " + TABLE_SOLIDFEED;
        Log.e(LOG, sqlQuery);

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery, null);
        if(cursor.moveToFirst()){
            do{
                SolidFood solidFood = new SolidFood();
                solidFood.setSolidFoodName(cursor.getString(cursor.getColumnIndex(KEY_SOLIDFOODNAME)));
                solidFood.setSolidFoodDay(cursor.getString(cursor.getColumnIndex(KEY_SOLIDFOODDAY)));
                solidFood.setSoliFoodMonth(cursor.getString(cursor.getColumnIndex(KEY_SOLIDFOODMONTH)));
                solidFood.setSolidFoodHour(cursor.getString(cursor.getColumnIndex(KEY_SOLIDFOODHOUR)));
                solidFood.setSolidFoodMinute(cursor.getString(cursor.getColumnIndex(KEY_SOLIDFOODMINUTE)));
                solidFood.setObservation(cursor.getString(cursor.getColumnIndex(KEY_SOLIDFOODOBSERVATION)));

                solidFoodList.add(solidFood);

            }while (cursor.moveToNext());
        }
        return solidFoodList;

    }

    // Insert into Medication

    public Long saveMedication(Medication medication){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_MEDICINENAME,medication.getMedicineName());
        contentValues.put(KEY_MEDICINEQUANTITY,medication.getMedicineQuantity());
        contentValues.put(KEY_MEDICINEMEASURETYPE,medication.getMedicineQuantityMeasure());
        contentValues.put(KEY_MEDICINESYMPTOMS,medication.getSymptomsDescription());
        contentValues.put(KEY_MEDICINEDATE,medication.getMedicineDate());
        contentValues.put(KEY_MEDICINEMONTH,medication.getMedicineMonth());
        contentValues.put(KEY_MEDICINEHOUR,medication.getMedicineHour());
        contentValues.put(KEY_MEDICINEMINUTE,medication.getMedicineMinute());
        contentValues.put(KEY_MEDICINEOBSERVATION,medication.getObservation());

        Long medicationId = database.insert(TABLE_MEDICINE,null,contentValues);

        return medicationId;

    }

    public List<Medication> getAllMedication(){
        List<Medication> medicationList = new ArrayList<Medication>();
        String sqlQuery = "SELECT * FROM " + TABLE_MEDICINE;
        Log.e(LOG, sqlQuery);

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery, null);
        if(cursor.moveToFirst()){
            do{
                Medication medication = new Medication();
                medication.setMedicineName(cursor.getString(cursor.getColumnIndex(KEY_MEDICINENAME)));
                medication.setMedicineQuantity(cursor.getString(cursor.getColumnIndex(KEY_MEDICINEQUANTITY)));
                medication.setMedicineQuantityMeasure(cursor.getString(cursor.getColumnIndex(KEY_MEDICINEMEASURETYPE)));
                medication.setSymptomsDescription(cursor.getString(cursor.getColumnIndex(KEY_MEDICINESYMPTOMS)));
                medication.setMedicineDate(cursor.getString(cursor.getColumnIndex(KEY_MEDICINEDATE)));
                medication.setMedicineMonth(cursor.getString(cursor.getColumnIndex(KEY_MEDICINEMONTH)));
                medication.setMedicineHour(cursor.getString(cursor.getColumnIndex(KEY_MEDICINEHOUR)));
                medication.setMedicineMinute(cursor.getString(cursor.getColumnIndex(KEY_MEDICINEMINUTE)));
                medication.setObservation(cursor.getString(cursor.getColumnIndex(KEY_MEDICINEOBSERVATION)));

                medicationList.add(medication);

            }while (cursor.moveToNext());
        }
        return medicationList;

    }

    // Insert into Bath

    public Long saveBath(BathSchedule bathSchedule){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_BATHDATE,bathSchedule.getBathDate());
        contentValues.put(KEY_BATHMONTH,bathSchedule.getBathMonth());
        contentValues.put(KEY_BATHHOUR,bathSchedule.getBathHour());
        contentValues.put(KEY_BATHMINUTE,bathSchedule.getBathMinute());
        contentValues.put(KEY_BATHDIAPER,bathSchedule.getDiaperBrand());
        contentValues.put(KEY_BATHOBSERVATION,bathSchedule.getObservation());

        Long bathScheduleId = database.insert(TABLE_BATH,null,contentValues);

        return bathScheduleId;

    }

    public List<BathSchedule> getAllBathSchedule(){
        List<BathSchedule> bathScheduleList = new ArrayList<BathSchedule>();
        String sqlQuery = "SELECT * FROM " + TABLE_BATH;
        Log.e(LOG, sqlQuery);

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery, null);
        if(cursor.moveToFirst()){
            do{
                BathSchedule bathSchedule = new BathSchedule();
                bathSchedule.setBathDate(cursor.getString(cursor.getColumnIndex(KEY_BATHDATE)));
                bathSchedule.setBathMonth(cursor.getString(cursor.getColumnIndex(KEY_BATHMONTH)));
                bathSchedule.setBathHour(cursor.getString(cursor.getColumnIndex(KEY_BATHHOUR)));
                bathSchedule.setBathMinute(cursor.getString(cursor.getColumnIndex(KEY_BATHMINUTE)));
                bathSchedule.setDiaperBrand(cursor.getString(cursor.getColumnIndex(KEY_BATHDIAPER)));
                bathSchedule.setObservation(cursor.getString(cursor.getColumnIndex(KEY_BATHOBSERVATION)));

                bathScheduleList.add(bathSchedule);

            }while (cursor.moveToNext());
        }
        return bathScheduleList;

    }

    // Insert into Sleep

    public Long saveSleep(Sleep sleep){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_SLEEPDATE,sleep.getSleepDate());
        contentValues.put(KEY_SLEEPMONTH,sleep.getSleepMonth());
        contentValues.put(KEY_SLEEPHOURFROM,sleep.getSleepHourFrom());
        contentValues.put(KEY_SLEEPMINUTEFROM,sleep.getSleepMinuteFrom());
        contentValues.put(KEY_SLEEPHOURTO,sleep.getSleepHourTo());
        contentValues.put(KEY_SLEEPMINUTETO,sleep.getSleepMinuteTo());
        contentValues.put(KEY_SLEEPOBSERVATION,sleep.getObservation());

        Long sleepId = database.insert(TABLE_SLEEP,null,contentValues);

        return sleepId;

    }


    public List<Sleep> getAllSleep(){
        List<Sleep> sleepList = new ArrayList<Sleep>();
        String sqlQuery = "SELECT * FROM " + TABLE_SLEEP;
        Log.e(LOG, sqlQuery);

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery, null);
        if(cursor.moveToFirst()){
            do{
                Sleep sleep = new Sleep();
                sleep.setSleepDate(cursor.getString(cursor.getColumnIndex(KEY_SLEEPDATE)));
                sleep.setSleepMonth(cursor.getString(cursor.getColumnIndex(KEY_SLEEPMONTH)));
                sleep.setSleepHourFrom(cursor.getString(cursor.getColumnIndex(KEY_SLEEPHOURFROM)));
                sleep.setSleepMinuteFrom(cursor.getString(cursor.getColumnIndex(KEY_SLEEPMINUTEFROM)));
                sleep.setSleepHourTo(cursor.getString(cursor.getColumnIndex(KEY_SLEEPHOURTO)));
                sleep.setSleepMinuteTo(cursor.getString(cursor.getColumnIndex(KEY_SLEEPMINUTETO)));
                sleep.setObservation(cursor.getString(cursor.getColumnIndex(KEY_SLEEPOBSERVATION)));

                sleepList.add(sleep);

            }while (cursor.moveToNext());
        }
        return sleepList;

    }

    // Insert into Diaper

    public Long saveDiaper(Diaper diaper){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_DIAPERFORPOOP,diaper.getDiaperForPoop());
        contentValues.put(KEY_DIAPERFORPEE,diaper.getDiaperForPee());
        contentValues.put(KEY_DIAPERDATE,diaper.getDiaperDate());
        contentValues.put(KEY_DIAPERMONTH,diaper.getDiaperMonth());
        contentValues.put(KEY_DIAPERHOUR,diaper.getDiaperHour());
        contentValues.put(KEY_DIAPERMINUTE,diaper.getDiaperMinute());
        contentValues.put(KEY_DIAPERBRAND,diaper.getDiaperBrand());
        contentValues.put(KEY_DIAPEROBSERVATION,diaper.getObservation());

        Long sleepId = database.insert(TABLE_DIAPER,null,contentValues);

        return sleepId;

    }


    public List<Diaper> getAllDiaper(){
        List<Diaper> diaperList = new ArrayList<Diaper>();
        String sqlQuery = "SELECT * FROM " + TABLE_DIAPER;
        Log.e(LOG, sqlQuery);

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery, null);
        if(cursor.moveToFirst()){
            do{
                Diaper diaper = new Diaper();
                diaper.setDiaperForPoop(cursor.getString(cursor.getColumnIndex(KEY_DIAPERFORPOOP)));
                diaper.setDiaperForPee(cursor.getString(cursor.getColumnIndex(KEY_DIAPERFORPEE)));
                diaper.setDiaperDate(cursor.getString(cursor.getColumnIndex(KEY_DIAPERDATE)));
                diaper.setDiaperMonth(cursor.getString(cursor.getColumnIndex(KEY_DIAPERMONTH)));
                diaper.setDiaperHour(cursor.getString(cursor.getColumnIndex(KEY_DIAPERHOUR)));
                diaper.setDiaperMinute(cursor.getString(cursor.getColumnIndex(KEY_DIAPERMINUTE)));
                diaper.setDiaperBrand(cursor.getString(cursor.getColumnIndex(KEY_DIAPERBRAND)));
                diaper.setObservation(cursor.getString(cursor.getColumnIndex(KEY_DIAPEROBSERVATION)));

                diaperList.add(diaper);

            }while (cursor.moveToNext());
        }
        return diaperList;

    }

    /************************/
    /*** snapshot methods****/
    /************************/

    // bath section
    public BathSchedule getLatestBath(){

        BathSchedule bathScheduleLatest = new BathSchedule();
        String sqlQuery = "SELECT * FROM " + TABLE_BATH + " ORDER BY " +KEY_ID+ " DESC LIMIT 1";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery,null);
        if(cursor.moveToFirst()){
            bathScheduleLatest.setBathHour(cursor.getString(cursor.getColumnIndex(KEY_BATHHOUR)));
            bathScheduleLatest.setBathMinute(cursor.getString(cursor.getColumnIndex(KEY_BATHMINUTE)));
            bathScheduleLatest.setBathDate(cursor.getString(cursor.getColumnIndex(KEY_BATHDATE)));
            bathScheduleLatest.setBathMonth(cursor.getString(cursor.getColumnIndex(KEY_BATHMONTH)));
            bathScheduleLatest.setDiaperBrand(cursor.getString(cursor.getColumnIndex(KEY_BATHDIAPER)));
            bathScheduleLatest.setObservation(cursor.getString(cursor.getColumnIndex(KEY_BATHOBSERVATION)));
        }
        return bathScheduleLatest;
    }

    // liquid feed section

    public LiquidFood getLatestLiquidFeed(){
        LiquidFood liquidFood = new LiquidFood();
        String sqlQuery = "SELECT * FROM " + TABLE_LIQUIDFEED + " ORDER BY " +KEY_ID+ " DESC LIMIT 1";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery,null);
        if(cursor.moveToFirst()){
            liquidFood.setLiquidFoodName(cursor.getString(cursor.getColumnIndex(KEY_LIQUIDFOODNAME)));
            liquidFood.setLiquidFoodMonth(cursor.getString(cursor.getColumnIndex(KEY_LIQUIDFOODMONTH)));
            liquidFood.setLiquidFoodDay(cursor.getString(cursor.getColumnIndex(KEY_LIQUIDFOODDAY)));
            liquidFood.setLiquidFoodHour(cursor.getString(cursor.getColumnIndex(KEY_LIQUIDFOODHOUR)));
            liquidFood.setLiquidFoodMinute(cursor.getString(cursor.getColumnIndex(KEY_LIQUIDFOODMINUTE)));
            liquidFood.setLiquidFoodMeasureType(cursor.getString(cursor.getColumnIndex(KEY_LIQUIDFOODMEASURETYPE)));
            liquidFood.setObservation(cursor.getString(cursor.getColumnIndex(KEY_LIQUIDFOODOBSERVATION)));
            liquidFood.setLiquidFoodQuantity(cursor.getString(cursor.getColumnIndex(KEY_LIQUIDFOODQUANTITY)));
        }

        return liquidFood;

    }

    // solid feed section

    public SolidFood getLatestSolidFeed(){
        SolidFood solidFood = new SolidFood();
        String sqlQuery = "SELECT * FROM " + TABLE_SOLIDFEED + " ORDER BY " +KEY_ID+ " DESC LIMIT 1";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery,null);
        if(cursor.moveToFirst()){
            solidFood.setSolidFoodName(cursor.getString(cursor.getColumnIndex(KEY_SOLIDFOODNAME)));
            solidFood.setSoliFoodMonth(cursor.getString(cursor.getColumnIndex(KEY_SOLIDFOODMONTH)));
            solidFood.setSolidFoodDay(cursor.getString(cursor.getColumnIndex(KEY_SOLIDFOODDAY)));
            solidFood.setSolidFoodHour(cursor.getString(cursor.getColumnIndex(KEY_SOLIDFOODHOUR)));
            solidFood.setSolidFoodMinute(cursor.getString(cursor.getColumnIndex(KEY_SOLIDFOODMINUTE)));
            solidFood.setObservation(cursor.getString(cursor.getColumnIndex(KEY_SOLIDFOODOBSERVATION)));
        }

        return solidFood;

    }

    // diaper section

    public Diaper getLatestDaiper(){
        Diaper diaper = new Diaper();
        String sqlQuery = "SELECT * FROM " + TABLE_DIAPER + " ORDER BY " +KEY_ID+ " DESC LIMIT 1";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery,null);
        if(cursor.moveToFirst()){
            diaper.setDiaperDate(cursor.getString(cursor.getColumnIndex(KEY_DIAPERDATE)));
            diaper.setDiaperMonth(cursor.getString(cursor.getColumnIndex(KEY_DIAPERMONTH)));
            diaper.setDiaperForPee(cursor.getString(cursor.getColumnIndex(KEY_DIAPERFORPEE)));
            diaper.setDiaperForPoop(cursor.getString(cursor.getColumnIndex(KEY_DIAPERFORPOOP)));
            diaper.setDiaperBrand(cursor.getString(cursor.getColumnIndex(KEY_DIAPERBRAND)));
            diaper.setDiaperHour(cursor.getString(cursor.getColumnIndex(KEY_DIAPERHOUR)));
            diaper.setDiaperMinute(cursor.getString(cursor.getColumnIndex(KEY_DIAPERMINUTE)));
            diaper.setObservation(cursor.getString(cursor.getColumnIndex(KEY_DIAPEROBSERVATION)));
        }

        return diaper;
    }


    //sleep section

    public Sleep getLatestSleep(){
        Sleep sleep = new Sleep();
        String sqlQuery = "SELECT * FROM " + TABLE_SLEEP + " ORDER BY " +KEY_ID+ " DESC LIMIT 1";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery,null);
        if(cursor.moveToFirst()){
            sleep.setSleepDate(cursor.getString(cursor.getColumnIndex(KEY_SLEEPDATE)));
            sleep.setSleepMonth(cursor.getString(cursor.getColumnIndex(KEY_SLEEPMONTH)));
            sleep.setSleepHourFrom(cursor.getString(cursor.getColumnIndex(KEY_SLEEPHOURFROM)));
            sleep.setSleepMinuteFrom(cursor.getString(cursor.getColumnIndex(KEY_SLEEPMINUTEFROM)));
            sleep.setSleepHourTo(cursor.getString(cursor.getColumnIndex(KEY_SLEEPHOURTO)));
            sleep.setSleepMinuteTo(cursor.getString(cursor.getColumnIndex(KEY_SLEEPMINUTETO)));
            sleep.setObservation(cursor.getString(cursor.getColumnIndex(KEY_SLEEPOBSERVATION)));
        }
        return sleep;
    }

    //medicine section

    public Medication getLatestMedication(){
        Medication medication = new Medication();
        String sqlQuery = "SELECT * FROM " + TABLE_MEDICINE + " ORDER BY " +KEY_ID+ " DESC LIMIT 1";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery,null);
        if(cursor.moveToFirst()){
            medication.setMedicineName(cursor.getString(cursor.getColumnIndex(KEY_MEDICINENAME)));
            medication.setMedicineQuantity(cursor.getString(cursor.getColumnIndex(KEY_MEDICINEQUANTITY)));
            medication.setMedicineQuantityMeasure(cursor.getString(cursor.getColumnIndex(KEY_MEDICINEMEASURETYPE)));
            medication.setSymptomsDescription(cursor.getString(cursor.getColumnIndex(KEY_MEDICINESYMPTOMS)));
            medication.setMedicineMonth(cursor.getString(cursor.getColumnIndex(KEY_MEDICINEMONTH)));
            medication.setMedicineDate(cursor.getString(cursor.getColumnIndex(KEY_MEDICINEDATE)));
            medication.setMedicineHour(cursor.getString(cursor.getColumnIndex(KEY_MEDICINEHOUR)));
            medication.setMedicineMinute(cursor.getString(cursor.getColumnIndex(KEY_MEDICINEMINUTE)));
            medication.setObservation(cursor.getString(cursor.getColumnIndex(KEY_MEDICINEOBSERVATION)));
        }
        return medication;
    }



    /*****************************/
    /*** End snapshot methods ****/
    /*****************************/

}
