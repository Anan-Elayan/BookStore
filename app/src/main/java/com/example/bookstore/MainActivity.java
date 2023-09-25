package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookDa;
import com.example.bookstore.model.BookFactory;
import com.example.bookstore.model.IBookDa;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        editText = findViewById(R.id.edtText);
        populateSpinner();
    }

    private void populateSpinner() {
        BookFactory bookFactory = new BookFactory();
        IBookDa objBook = bookFactory.getBooks();
        String [] cats = objBook.getCategories();
        ArrayAdapter<String> adapter  = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,cats);
        spinner.setAdapter(adapter);
    }

    public void btnGetBookOnClick(View view) {
        BookFactory bookFactory = new BookFactory();
        IBookDa objBook = bookFactory.getBooks();
        String item = "" ;
        item  = spinner.getSelectedItem().toString();

        List<Book>books = objBook.getBooks(item);
        String str = "";
        for(Book b:books)
        {
            str+=b.getTitle()+ "\n";
            editText.setText(b.getTitle());

        }
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}