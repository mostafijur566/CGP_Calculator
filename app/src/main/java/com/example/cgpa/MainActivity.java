package com.example.cgpa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String[] grades = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "F"};


    public int position = 0;
    public String answer;
    public double TotalCredit=0;
    public double TotalGradePointXcredit=0;
    public double cgpa;

    public double credit1 = 0;
    public double credit2 = 0;
    public double credit3 = 0;
    public double credit4 = 0;
    public double credit5 = 0;
    public double credit6 = 0;
    public double credit7 = 0;

    public double grade1 = 0;
    public double grade2 = 0;
    public double grade3 = 0;
    public double grade4 = 0;
    public double grade5 = 0;
    public double grade6 = 0;
    public double grade7 = 0;

    AlertDialog.Builder alert;

    Button GradeSystem;
    Button calculate;
    Button reset;

    EditText course1;
    EditText course2;
    EditText course3;
    EditText course4;
    EditText course5;
    EditText course6;
    EditText course7;

    EditText Credit1;
    EditText Credit2;
    EditText Credit3;
    EditText Credit4;
    EditText Credit5;
    EditText Credit6;
    EditText Credit7;

    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;
    Spinner spinner5;
    Spinner spinner6;
    Spinner spinner7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner3 = (Spinner)findViewById(R.id.spinner3);
        spinner4 = (Spinner)findViewById(R.id.spinner4);
        spinner5 = (Spinner)findViewById(R.id.spinner5);
        spinner6 = (Spinner)findViewById(R.id.spinner6);
        spinner7 = (Spinner)findViewById(R.id.spinner7);

        GradeSystem = (Button)findViewById(R.id.GradeSystem);
        calculate = (Button)findViewById(R.id.calculate);
        reset = (Button)findViewById(R.id.reset);

        Credit1 = (EditText)findViewById(R.id.credit1);
        Credit2 = (EditText)findViewById(R.id.credit2);
        Credit3 = (EditText)findViewById(R.id.credit3);
        Credit4 = (EditText)findViewById(R.id.credit4);
        Credit5 = (EditText)findViewById(R.id.credit5);
        Credit6 = (EditText)findViewById(R.id.credit6);
        Credit7 = (EditText)findViewById(R.id.credit7);

        course1 = (EditText)findViewById(R.id.course1);
        course2 = (EditText)findViewById(R.id.course2);
        course3 = (EditText)findViewById(R.id.course3);
        course4 = (EditText)findViewById(R.id.course4);
        course5 = (EditText)findViewById(R.id.course5);
        course6 = (EditText)findViewById(R.id.course6);
        course7 = (EditText)findViewById(R.id.course7);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.sample_view, R.id.textView, grades);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
        spinner4.setAdapter(adapter);
        spinner5.setAdapter(adapter);
        spinner6.setAdapter(adapter);
        spinner7.setAdapter(adapter);

        GradeSystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, popup.class);
                startActivity(intent);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                spinner1.setSelection(0);
                spinner2.setSelection(0);
                spinner3.setSelection(0);
                spinner4.setSelection(0);
                spinner5.setSelection(0);
                spinner6.setSelection(0);
                spinner7.setSelection(0);

                Credit1.setText("");
                Credit2.setText("");
                Credit3.setText("");
                Credit4.setText("");
                Credit5.setText("");
                Credit6.setText("");
                Credit7.setText("");

                course1.setText("");
                course2.setText("");
                course3.setText("");
                course4.setText("");
                course5.setText("");
                course6.setText("");
                course7.setText("");

                credit1 = 0;
                credit2 = 0;
                credit3 = 0;
                credit4 = 0;
                credit5 = 0;
                credit6 = 0;
                credit7 = 0;

                grade1 = 0;
                grade2 = 0;
                grade3 = 0;
                grade4 = 0;
                grade5 = 0;
                grade6 = 0;
                grade7 = 0;

                TotalCredit=0;
                TotalGradePointXcredit=0;
                
                Toast.makeText(MainActivity.this, "Reset is done", Toast.LENGTH_SHORT).show();
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //credit box 1
                if(Credit1.getText().toString().isEmpty())
                    credit1 = 0;
                else
                    credit1 = Double.parseDouble(Credit1.getText().toString());

                //credit box 2
                if(Credit2.getText().toString().isEmpty())
                    credit2 = 0;
                else
                    credit2 = Double.parseDouble(Credit2.getText().toString());

                //credit box 3
                if(Credit3.getText().toString().isEmpty())
                    credit3 = 0;
                else
                    credit3 = Double.parseDouble(Credit3.getText().toString());

                //credit box 4
                if(Credit4.getText().toString().isEmpty())
                    credit4 = 0;
                else
                    credit4 = Double.parseDouble(Credit4.getText().toString());

                //credit box 5
                if(Credit5.getText().toString().isEmpty())
                    credit5 = 0;
                else
                    credit5 = Double.parseDouble(Credit5.getText().toString());

                //credit box 6
                if(Credit6.getText().toString().isEmpty())
                    credit6 = 0;
                else
                    credit6 = Double.parseDouble(Credit6.getText().toString());

                //credit box 7
                if(Credit7.getText().toString().isEmpty())
                    credit7 = 0;
                else
                    credit7 = Double.parseDouble(Credit7.getText().toString());

                //Spinner1 and grade1
                if(spinner1.getSelectedItem().toString() == "A")
                    grade1 = 4.0;
                else if(spinner1.getSelectedItem().toString() == "A-")
                    grade1 = 3.7;
                else if(spinner1.getSelectedItem().toString() == "B+")
                    grade1 = 3.3;
                else if(spinner1.getSelectedItem().toString() == "B")
                    grade1 = 3.0;
                else if(spinner1.getSelectedItem().toString() == "B-")
                    grade1 = 2.7;
                else if(spinner1.getSelectedItem().toString() == "C+")
                    grade1 = 2.3;
                else if(spinner1.getSelectedItem().toString() == "C")
                    grade1 = 2.0;
                else if(spinner1.getSelectedItem().toString() == "C-")
                    grade1 = 1.7;
                else if(spinner1.getSelectedItem().toString() == "D+")
                    grade1 = 1.3;
                else if(spinner1.getSelectedItem().toString() == "D")
                    grade1 = 1.0;
                else if(spinner1.getSelectedItem().toString() == "F")
                    grade1 = 0.0;

                //Spinner2 and grade2
                if(spinner2.getSelectedItem().toString() == "A")
                    grade2 = 4.0;
                else if(spinner2.getSelectedItem().toString() == "A-")
                    grade2 = 3.7;
                else if(spinner2.getSelectedItem().toString() == "B+")
                    grade2 = 3.3;
                else if(spinner2.getSelectedItem().toString() == "B")
                    grade2 = 3.0;
                else if(spinner2.getSelectedItem().toString() == "B-")
                    grade2 = 2.7;
                else if(spinner2.getSelectedItem().toString() == "C+")
                    grade2 = 2.3;
                else if(spinner2.getSelectedItem().toString() == "C")
                    grade2 = 2.0;
                else if(spinner2.getSelectedItem().toString() == "C-")
                    grade2 = 1.7;
                else if(spinner2.getSelectedItem().toString() == "D+")
                    grade2 = 1.3;
                else if(spinner2.getSelectedItem().toString() == "D")
                    grade2 = 1.0;
                else if(spinner2.getSelectedItem().toString() == "F")
                    grade2 = 0.0;

                //Spinner3 and grade3
                if(spinner3.getSelectedItem().toString() == "A")
                    grade3 = 4.0;
                else if(spinner3.getSelectedItem().toString() == "A-")
                    grade3 = 3.7;
                else if(spinner3.getSelectedItem().toString() == "B+")
                    grade3 = 3.3;
                else if(spinner3.getSelectedItem().toString() == "B")
                    grade3 = 3.0;
                else if(spinner3.getSelectedItem().toString() == "B-")
                    grade3 = 2.7;
                else if(spinner3.getSelectedItem().toString() == "C+")
                    grade3 = 2.3;
                else if(spinner3.getSelectedItem().toString() == "C")
                    grade3 = 2.0;
                else if(spinner3.getSelectedItem().toString() == "C-")
                    grade3 = 1.7;
                else if(spinner3.getSelectedItem().toString() == "D+")
                    grade3 = 1.3;
                else if(spinner3.getSelectedItem().toString() == "D")
                    grade3 = 1.0;
                else if(spinner3.getSelectedItem().toString() == "F")
                    grade3 = 0.0;

                //Spinner4 and grade4
                if(spinner4.getSelectedItem().toString() == "A")
                    grade4 = 4.0;
                else if(spinner4.getSelectedItem().toString() == "A-")
                    grade4 = 3.7;
                else if(spinner4.getSelectedItem().toString() == "B+")
                    grade4 = 3.3;
                else if(spinner4.getSelectedItem().toString() == "B")
                    grade4 = 3.0;
                else if(spinner4.getSelectedItem().toString() == "B-")
                    grade4 = 2.7;
                else if(spinner4.getSelectedItem().toString() == "C+")
                    grade4 = 2.3;
                else if(spinner4.getSelectedItem().toString() == "C")
                    grade4 = 2.0;
                else if(spinner4.getSelectedItem().toString() == "C-")
                    grade4 = 1.7;
                else if(spinner4.getSelectedItem().toString() == "D+")
                    grade4 = 1.3;
                else if(spinner4.getSelectedItem().toString() == "D")
                    grade4 = 1.0;
                else if(spinner4.getSelectedItem().toString() == "F")
                    grade4 = 0.0;

                //Spinner5 and grade5
                if(spinner5.getSelectedItem().toString() == "A")
                    grade5 = 4.0;
                else if(spinner5.getSelectedItem().toString() == "A-")
                    grade5 = 3.7;
                else if(spinner5.getSelectedItem().toString() == "B+")
                    grade5 = 3.3;
                else if(spinner5.getSelectedItem().toString() == "B")
                    grade5 = 3.0;
                else if(spinner5.getSelectedItem().toString() == "B-")
                    grade5 = 2.7;
                else if(spinner5.getSelectedItem().toString() == "C+")
                    grade5 = 2.3;
                else if(spinner5.getSelectedItem().toString() == "C")
                    grade5 = 2.0;
                else if(spinner5.getSelectedItem().toString() == "C-")
                    grade5 = 1.7;
                else if(spinner5.getSelectedItem().toString() == "D+")
                    grade5 = 1.3;
                else if(spinner5.getSelectedItem().toString() == "D")
                    grade5 = 1.0;
                else if(spinner5.getSelectedItem().toString() == "F")
                    grade5 = 0.0;

                //Spinner6 and grade6
                if(spinner6.getSelectedItem().toString() == "A")
                    grade6 = 4.0;
                else if(spinner6.getSelectedItem().toString() == "A-")
                    grade6 = 3.7;
                else if(spinner6.getSelectedItem().toString() == "B+")
                    grade6 = 3.3;
                else if(spinner6.getSelectedItem().toString() == "B")
                    grade6 = 3.0;
                else if(spinner6.getSelectedItem().toString() == "B-")
                    grade6 = 2.7;
                else if(spinner6.getSelectedItem().toString() == "C+")
                    grade6 = 2.3;
                else if(spinner6.getSelectedItem().toString() == "C")
                    grade6 = 2.0;
                else if(spinner6.getSelectedItem().toString() == "C-")
                    grade6 = 1.7;
                else if(spinner6.getSelectedItem().toString() == "D+")
                    grade6 = 1.3;
                else if(spinner6.getSelectedItem().toString() == "D")
                    grade6 = 1.0;
                else if(spinner6.getSelectedItem().toString() == "F")
                    grade6 = 0.0;

                //Spinner7 and grade7
                if(spinner7.getSelectedItem().toString() == "A")
                    grade7 = 4.0;
                else if(spinner7.getSelectedItem().toString() == "A-")
                    grade7 = 3.7;
                else if(spinner7.getSelectedItem().toString() == "B+")
                    grade7 = 3.3;
                else if(spinner7.getSelectedItem().toString() == "B")
                    grade7 = 3.0;
                else if(spinner7.getSelectedItem().toString() == "B-")
                    grade7 = 2.7;
                else if(spinner7.getSelectedItem().toString() == "C+")
                    grade7 = 2.3;
                else if(spinner7.getSelectedItem().toString() == "C")
                    grade7 = 2.0;
                else if(spinner7.getSelectedItem().toString() == "C-")
                    grade7 = 1.7;
                else if(spinner7.getSelectedItem().toString() == "D+")
                    grade7 = 1.3;
                else if(spinner7.getSelectedItem().toString() == "D")
                    grade7 = 1.0;
                else if(spinner7.getSelectedItem().toString() == "F")
                    grade7 = 0.0;

                TotalCredit = credit1 + credit2 + credit3 + credit4 + credit5 + credit6 + credit7;
                TotalGradePointXcredit = credit1*grade1 + credit2*grade2 + credit3*grade3 + credit4*grade4 + credit5*grade5 + credit6*grade6 + credit7*grade7;
                cgpa = TotalGradePointXcredit/TotalCredit;
                answer = String.format("CGPA: %.2f", cgpa);

                alert = new AlertDialog.Builder(MainActivity.this);

                alert.setTitle("Semester Result");
                alert.setMessage(answer);
                alert.setNegativeButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                if(position == credit2 && position == credit1 && position == credit3 && position == credit4 && position == credit5 && position == credit6 && position == credit7)
                {
                    Toast.makeText(MainActivity.this, "No value assigned", Toast.LENGTH_LONG).show();
                }
                else {
                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                }
            }
        });
    }
}