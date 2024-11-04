package Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import Model.Classmates;
import Utils.Util;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String  CREATE_CLASSMATES_TABLE = "CREATE TABLE " + Util.TABLE_NAME + " ("
                + Util.KEY_ID + " INTEGER PRIMARY KEY, "
                + Util.KEY_F + " TEXT, "
                + Util.KEY_I + " TEXT, "
                + Util.KEY_O + " TEXT, "
                + Util.KEY_TIME + " TEXT" + " )";

        sqLiteDatabase.execSQL(CREATE_CLASSMATES_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public void  addClas (Classmates classmates){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Util.KEY_F, classmates.getF());
        contentValues.put(Util.KEY_I, classmates.getI());
        contentValues.put(Util.KEY_O, classmates.getO());
        contentValues.put(Util.KEY_TIME, classmates.getTime());

        db.insert(Util.TABLE_NAME, null, contentValues);
        db.close();

    }

    public Classmates getClas(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Util.TABLE_NAME, new String[] {Util.KEY_ID, Util.KEY_F, Util.KEY_I, Util.KEY_O, Util.KEY_TIME},
                Util.KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        Classmates classmates = new Classmates(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4));
        return classmates;
    }

    public List<Classmates> getAllClas(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Classmates> classList = new ArrayList<>();
        String selectAllClas = "Select * from " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAllClas, null);
        if(cursor.moveToFirst()){
            do{
                Classmates classmates = new Classmates();
                classmates.setId(Integer.parseInt(cursor.getString(0)));
                classmates.setF(cursor.getString(1));
                classmates.setI(cursor.getString(2));
                classmates.setO(cursor.getString(3));
                classmates.setTime(cursor.getString(4));

                classList.add(classmates);
            } while (cursor.moveToNext());
        }
        return classList;
    }

    public int updateClas(Classmates classmates){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.KEY_F, classmates.getF());
        contentValues.put(Util.KEY_I, classmates.getI());
        contentValues.put(Util.KEY_O, classmates.getO());
        contentValues.put(Util.KEY_TIME, classmates.getTime());

        return db.update(Util.TABLE_NAME, contentValues, Util.KEY_ID + "=?", new String[]{String.valueOf(classmates.getId())});
    }

    public void deleteClas (Classmates classmates){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(Util.TABLE_NAME, Util.KEY_ID + "=?", new String[]{String.valueOf(classmates.getId())});
        db.close();
    }


}
