package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    Book_adapter bookAdapter;
    ArrayList<Book> books = new ArrayList<Book>();
    ListView bookList;

    EditText name_in;
    EditText author_in;
    EditText year_of_create_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetInitialDate();

        bookList= findViewById(R.id.bookList);

        bookAdapter = new Book_adapter(this,R.layout.book_layout, books);
        bookList.setAdapter(bookAdapter);
    }
    private void SetInitialDate(){
        books.add(new Book("L.Tolstoi","War and world", "1867 y."));
    }
    public void Clickfour(View view){
        name_in = findViewById(R.id.name_in);
        String name = name_in.getText().toString();

        author_in = findViewById(R.id.author_in);
        String author = author_in.getText().toString();

        year_of_create_in = findViewById(R.id.year_of_create_in);
        String year = year_of_create_in.getText().toString();


        if(!name.isEmpty() && !author.isEmpty() && !year.isEmpty()){

            books.add(new Book(author,name,year));

            name_in.setText("");
            author_in.setText("");
            year_of_create_in.setText("");

            bookAdapter.notifyDataSetChanged();
        }
    }
    public void Clickthree(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}