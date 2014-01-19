package com.example.shg_1.sqlite;



import java.util.LinkedList;
import java.util.List;
 
import com.example.shg_1.model.Member;
import com.example.shg_1.model.Transaction;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
 
public class MySQLiteHelper extends SQLiteOpenHelper {
 
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "MemberDB";
 
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table
        String CREATE_MEMBER_TABLE = "CREATE TABLE member ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
                "phone_number TEXT, "+
                "name TEXT, "+
                "address TEXT )";
 
        // create books table
        db.execSQL(CREATE_MEMBER_TABLE);
        String CREATE_TRANSACTION_TABLE = "CREATE TABLE transaction ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
                "from TEXT, "+
                "to TEXT, "+
                "money TEXT, "+
                "why TEXT )";
 
        // create books table
        Log.d("debugTransactions", "Value: " + "2");
        db.execSQL(CREATE_TRANSACTION_TABLE);
        Log.d("debugTransactions", "Value: " + "3");
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS member");
        db.execSQL("DROP TABLE IF EXISTS transaction");
        // create fresh books table
        this.onCreate(db);
    }
    public void chutiya()
    {
    	SQLiteDatabase db = this.getWritableDatabase();
    	this.onUpgrade(db, 1, 2);
    }
    //---------------------------------------------------------------------
 
    /**
     * CRUD operations (create "add", read "get", update, delete) member + get all members + delete all members
     */
 
    // Books table name
    private static final String TABLE_MEMBERS = "member";
 
    // Books Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_PHONE_NUMBER="phone_number";
 
    private static final String[] COLUMNS = {KEY_ID,KEY_PHONE_NUMBER,KEY_NAME,KEY_ADDRESS};
 
    public void addMember(Member member){
        Log.d("addMember", member.toString());
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_PHONE_NUMBER, member.getPhone_number()); // get phone number
        values.put(KEY_NAME, member.getName()); // get name 
        values.put(KEY_ADDRESS, member.getAddress()); // get address
        
 
        // 3. insert
        db.insert(TABLE_MEMBERS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
 
        // 4. close
        db.close(); 
    }
 
    public Member getMember(int id){
 
        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();
 
        // 2. build query
        Cursor cursor = 
                db.query(TABLE_MEMBERS, // a. table
                COLUMNS, // b. column names
                " id = ?", // c. selections 
                new String[] { String.valueOf(id) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
 
        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
 
        // 4. build member object
        Member member = new Member();
        member.setId(Integer.parseInt(cursor.getString(0)));
        member.setPhone_number(cursor.getString(1));
        member.setName(cursor.getString(2));
        member.setAddress(cursor.getString(3));
 
        Log.d("getMember("+id+")", member.toString());
 
        // 5. return member
        return member;
    }
 
    // Get All Members
    public List<Member> getAllMembers() {
        List<Member> members = new LinkedList<Member>();
 
        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_MEMBERS;
 
        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
 
        // 3. go over each row, build member and add it to list
        Member member = null;
        if (cursor.moveToFirst()) {
            do {
                member = new Member();
                member.setId(Integer.parseInt(cursor.getString(0)));
                member.setPhone_number(cursor.getString(1));
                member.setName(cursor.getString(2));
                member.setAddress(cursor.getString(3));
 
                // Add member to members
                members.add(member);
            } while (cursor.moveToNext());
        }
 
        Log.d("getAllMembers()", members.toString());
 
        // return members
        return members;
    }
 
     // Updating single book
    public int updateMember(Member member) {
 
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_PHONE_NUMBER, member.getPhone_number()); // get phone number
        values.put(KEY_NAME, member.getName()); // get name 
        values.put(KEY_ADDRESS, member.getAddress()); // get address
 
        // 3. updating row
        int i = db.update(TABLE_MEMBERS, //table
                values, // column/value
                KEY_ID+" = ?", // selections
                new String[] { String.valueOf(member.getId()) }); //selection args
 
        // 4. close
        db.close();
 
        return i;
 
    }
 
    // Deleting single member
    public void deleteMember(Member member) {
 
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. delete
        db.delete(TABLE_MEMBERS,
                KEY_ID+" = ?",
                new String[] { String.valueOf(member.getId()) });
 
        // 3. close
        db.close();
 
        Log.d("deleteMember", member.toString());
 
    }
  //---------------------------------------------------------------------
    
    /**
     * CRUD operations (create "add", read "get", update, delete) member + get all members + delete all members
     */
 
    // Books table name
    private static final String TABLE_TRANSACTIONS = "transaction";
 
    // Books Table Columns names
    private static final String KEY_ID_1 = "id";
    private static final String KEY_FROM = "from";
    private static final String KEY_TO = "to";
    private static final String KEY_MONEY="money";
    private static final String KEY_WHY="why";
 
    private static final String[] COLUMNS_1 = {KEY_ID_1,KEY_FROM,KEY_TO,KEY_MONEY,KEY_WHY};
 
    public void addTransaction(Transaction transaction){
        Log.d("addTransaction", transaction.toString());
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_FROM, transaction.getFrom()); // get phone number
        values.put(KEY_TO, transaction.getTo()); // get name 
        values.put(KEY_MONEY, transaction.getMoney()); // get address
        values.put(KEY_WHY, transaction.getWhy()); // get address
        
 
        // 3. insert
        db.insert(TABLE_TRANSACTIONS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
 
        // 4. close
        db.close(); 
    }
 
    public Transaction getTransaction(int id){
 
        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();
 
        // 2. build query
        Cursor cursor = 
                db.query(TABLE_TRANSACTIONS, // a. table
                COLUMNS_1, // b. column names
                " id = ?", // c. selections 
                new String[] { String.valueOf(id) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
 
        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
 
        // 4. build member object
        Transaction transaction = new Transaction();
        transaction.setId(Integer.parseInt(cursor.getString(0)));
        transaction.setFrom(cursor.getString(1));
        transaction.setTo(cursor.getString(2));
        transaction.setMoney(cursor.getString(3));
        transaction.setWhy(cursor.getString(4));
 
        Log.d("getTransaction("+id+")", transaction.toString());
 
        // 5. return member
        return transaction;
    }
 
    // Get All Members
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new LinkedList<Transaction>();
 
        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_TRANSACTIONS;
 
        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
 
        // 3. go over each row, build member and add it to list
        Transaction transaction = null;
        if (cursor.moveToFirst()) {
            do {
                transaction = new Transaction();
                transaction.setId(Integer.parseInt(cursor.getString(0)));
                transaction.setFrom(cursor.getString(1));
                transaction.setTo(cursor.getString(2));
                transaction.setMoney(cursor.getString(3));
                transaction.setWhy(cursor.getString(4));
 
                // Add member to members
                transactions.add(transaction);
            } while (cursor.moveToNext());
        }
 
        Log.d("getAllMembers()", transactions.toString());
 
        // return members
        return transactions;
    }
 
     // Updating single book
    public int updateTransaction(Transaction transaction) {
 
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_FROM, transaction.getFrom()); // get phone number
        values.put(KEY_TO, transaction.getTo()); // get name 
        values.put(KEY_MONEY, transaction.getMoney()); // get address
        values.put(KEY_WHY, transaction.getWhy()); // get address
 
        // 3. updating row
        int i = db.update(TABLE_TRANSACTIONS, //table
                values, // column/value
                KEY_ID_1+" = ?", // selections
                new String[] { String.valueOf(transaction.getId()) }); //selection args
 
        // 4. close
        db.close();
 
        return i;
 
    }
 
    // Deleting single member
    public void deleteTransaction(Transaction transaction) {
 
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. delete
        db.delete(TABLE_TRANSACTIONS,
                KEY_ID_1+" = ?",
                new String[] { String.valueOf(transaction.getId()) });
 
        // 3. close
        db.close();
 
        Log.d("deleteMember", transaction.toString());
 
    }
}
