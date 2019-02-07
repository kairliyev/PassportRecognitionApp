package kz.alibi.hday;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Listz> employeeList = new ArrayList<>();
    private java.util.List<Listz> usersLists = new ArrayList<>();
    private ProgressDialog pDialog;
    private RecyclerView recyclerView;
    private EmployeesAdapter eAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_page_layout);

        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Загрузка данных... ");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        Button btn = findViewById(R.id.main_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CreateTeamActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //Creating an object of our api interface


    }
}
