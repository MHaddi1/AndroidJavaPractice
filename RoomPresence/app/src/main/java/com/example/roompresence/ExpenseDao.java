package com.example.roompresence;



import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExpenseDao {
    @Query("select * from expense")
    List<Expense> expenseList();
    @Insert
    void addData(Expense expense);
    @Update
    void updateData(Expense expense);
    @Delete
    void deleteData(Expense expense);

}
