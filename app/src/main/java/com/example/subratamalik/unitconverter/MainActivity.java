package com.example.subratamalik.unitconverter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //for Alert button
  //  AlertDialog.Builder builder;
    //For Option menu
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.my_options_menu, menu);

        return true;

    }

    @Override

    //For Option menu item select
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.item1:
         //Create Alert Dialog Box ------------------------------------------------------------------
                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("About");
                alert.setIcon(R.drawable.information);
                alert.setMessage("Unit Converter"+"\n"+"Version:1.0"+"\n"+"Contact me: subratamalik1997@gmail.com");
                alert.setPositiveButton("OK",null);
                alert.show();
                break;
            case R.id.item2:
               //share activity
                Intent p=new Intent(Intent.ACTION_SEND);
                p.setType("text/plain");
                p.putExtra(Intent.EXTRA_TEXT,"This is the best app for converting unit. Download it from "+"\n"+"");
                startActivity(p);
                break;
            case R.id.item3:
                //Rate activity
                String g="https://play.google.com.store/apps";
                Uri w=Uri.parse(g);
                Intent d=new Intent(Intent.ACTION_VIEW,w);
                if(d.resolveActivity(getPackageManager())!=null)
                {
                    startActivity(d);
                }
                break;
            case R.id.item4:
                //feedback activity
                Intent f = new Intent(Intent.ACTION_SEND);
                f.putExtra(Intent.EXTRA_EMAIL, new String[]{"subratamalik1997@gmail.com"});
                f.putExtra(Intent.EXTRA_SUBJECT, "Feedback from Unit Converter");
                f.putExtra(Intent.EXTRA_TEXT, "Message: ");
                f.setType("message/email");
                f.setPackage("com.google.android.gm");
                startActivity(Intent.createChooser(f, "Send Feedback"));
        }
        return true;
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // create refference of spinner
        Spinner spinner=(Spinner) findViewById(R.id.spinner);
        //value to be shown in the spinner
        String [] items={"Select","Angle","Area","Data","Energy","Length","Power","Speed","Temperature","Time","Volume","Weight & Mass"};  //items is array name
        //array adapter use to bind values in the spinner
        ArrayAdapter<String> adpt=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adpt);

        //create a reference of textview2
        final TextView tv2=(TextView) findViewById(R.id.tv2);


        //create reference of spinner2 and spinner3
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        final Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        //create reference of textview and edittext
        final EditText from=(EditText)findViewById(R.id.from);
        //final EditText to=(EditText)findViewById(R.id.to);
        final TextView to=(TextView)findViewById(R.id.to);
        //make textview text selectable for copy the to clipboard
        //to.setTextIsSelectable(true);

        //create reference of clear button
        final Button clr =(Button)findViewById(R.id.clr);
        //initially make clear button diable as textview and edittext is empty
        clr.setEnabled(false);
        //when click on clear button textview and edittext will be clear
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                from.setText("");
                to.setText("");
            }
        });





        //on item select event handling
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {

                    case 0:tv2.setText(" ");
                        String[] array2 = {"Select"};
                        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array2);
                        spinner2.setAdapter(adapter2);

                        String[] array3 = {"Select"};
                        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array3);
                        spinner3.setAdapter(adapter3);
                        //make textview scrollable
                        to.setMovementMethod(new ScrollingMovementMethod());
                        break;

                    case 1:tv2.setText("Angle Converter");

                        String[] array4 = {"Select","Degrees","Radians","Gradians"};
                        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array4);
                        spinner2.setAdapter(adapter4);

                        String[] array5 = {"Select","Degrees","Radians","Gradians"};
                        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array5);
                        spinner3.setAdapter(adapter5);
                        //make textview scrollable
                        to.setMovementMethod(new ScrollingMovementMethod());
                        break;

                    case 2:tv2.setText("Area Converter");
                        String[] array6 = {"Select","Square millimeters","Square centimeters","Square meters","Hectares","Square kilometers","Square inches", "Square feet", "Square yards","Acres","Square miles"};
                        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array6);
                        spinner2.setAdapter(adapter6);

                        String[] array7 = {"Select","Square millimeters","Square centimeters","Square meters","Hectares","Square kilometers","Square inches", "Square feet", "Square yards","Acres","Square miles"};
                        ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array7);
                        spinner3.setAdapter(adapter7);
                        //make textview scrollable
                        to.setMovementMethod(new ScrollingMovementMethod());
                        break;

                    case 3:tv2.setText("Data Converter");
                        String[] array8 = {"Select","Bits","Bytes","Kilobits","Kilobytes","Megabites","Megabytes","Gigabits","Gigabytes","Terabits","Terabytes","Petabits","Petabytes","Exabits","Exabytes","Zetabits","Zetabytes","Yottabit","Yottabyte"};
                        ArrayAdapter<String> adapter8 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array8);
                        spinner2.setAdapter(adapter8);

                        String[] array9 = {"Select","Bits","Bytes","Kilobits","Kilobytes","Megabites","Megabytes","Gigabits","Gigabytes","Terabits","Terabytes","Petabits","Petabytes","Exabits","Exabytes","Zetabits","Zetabytes","Yottabit","Yottabyte"};
                        ArrayAdapter<String> adapter9 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array9);
                        spinner3.setAdapter(adapter9);
                        //make textview scrollable
                        to.setMovementMethod(new ScrollingMovementMethod());
                        break;

                    case 4:tv2.setText("Energy Converter");
                        String[] array10 = {"Select","Electron volts","Joules","Kilojoules","Thermal calories","Food calories","Foot-pounds","British thermal units"};
                        ArrayAdapter<String> adapter10 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array10);
                        spinner2.setAdapter(adapter10);

                        String[] array11 = {"Select","Electron volts","Joules","Kilojoules","Thermal calories","Food calories","Foot-pounds","British thermal units"};
                        ArrayAdapter<String> adapter11 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array11);
                        spinner3.setAdapter(adapter11);
                        //make textview scrollable
                        to.setMovementMethod(new ScrollingMovementMethod());
                        break;
                    case 5:tv2.setText("Length Converter");
                        String[] array12 = {"Select","Nanometers","Microns","Millimeters","Centimeters","Meters","Kilometers","Inches","Feet","Yards","Miles","Nautical Miles"};
                        ArrayAdapter<String> adapter12 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array12);
                        spinner2.setAdapter(adapter12);

                        String[] array13 = {"Select","Nanometers","Microns","Millimeters","Centimeters","Meters","Kilometers","Inches","Feet","Yards","Miles","Nautical Miles"};
                        ArrayAdapter<String> adapter13 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array13);
                        spinner3.setAdapter(adapter13);
                        //make textview scrollable
                        to.setMovementMethod(new ScrollingMovementMethod());
                        break;
                    case 6:tv2.setText("Power Converter");
                        String[] array14 = {"Select","Watts","Kilowatts","Horsepower(US)","Foot-pounds/minute","BTUs/minute"};
                        ArrayAdapter<String> adapter14 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array14);
                        spinner2.setAdapter(adapter14);

                        String[] array15 = {"Select","Watts","Kilowatts","Horsepower(US)","Foot-pounds/minute","BTUs/minute"};
                        ArrayAdapter<String> adapter15 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array15);
                        spinner3.setAdapter(adapter15);
                        //make textview scrollable
                        to.setMovementMethod(new ScrollingMovementMethod());
                        break;
                    case 7:tv2.setText("Speed Converter");
                        String[] array16 = {"Select","Centimeters/second","Meters/second","Feet/second","Miles/hour","Knots","Mach"};
                        ArrayAdapter<String> adapter16 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array16);
                        spinner2.setAdapter(adapter16);

                        String[] array17 = {"Select","Centimeters/second","Meters/second","Feet/second","Miles/hour","Knots","Mach"};
                        ArrayAdapter<String> adapter17 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array17);
                        spinner3.setAdapter(adapter17);
                        //make textview scrollable
                        to.setMovementMethod(new ScrollingMovementMethod());
                        break;
                    case 8:tv2.setText("Temperature Converter");
                        String[] array18 = {"Select","Celsius","Fahrenheit","Kelvin"};
                        ArrayAdapter<String> adapter18 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array18);
                        spinner2.setAdapter(adapter18);

                        String[] array19 = {"Select","Celsius","Fahrenheit","Kelvin"};
                        ArrayAdapter<String> adapter19 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array19);
                        spinner3.setAdapter(adapter19);
                        //make textview scrollable
                        to.setMovementMethod(new ScrollingMovementMethod());
                        break;
                    case 9:tv2.setText("Time Converter");
                        String[] array20 = {"Select","Microseconds","Milliseconds","Seconds","Minutes","Hours","Days","Weeks","Years"};
                        ArrayAdapter<String> adapter20 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array20);
                        spinner2.setAdapter(adapter20);

                        String[] array21 = {"Select","Microseconds","Milliseconds","Seconds","Minutes","Hours","Days","Weeks","Years"};
                        ArrayAdapter<String> adapter21 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array21);
                        spinner3.setAdapter(adapter21);
                        //make textview scrollable
                        to.setMovementMethod(new ScrollingMovementMethod());
                        break;
                    case 10:tv2.setText("Volume Converter");
                        String[] array22 = {"Select","Milliliters","Cubic centimeters","Liters","Cubic meters","Teaspoons(US)","Tablespoons(US)","Fluid ouncess(US)","Cups(US)","Pints(US)","Quarts(US)","Gallons(US)","Cubic inches","Cubic feet","Cubic yards","Teaspoons(UK)","Tablespoons(UK)","Fluid ounces(UK)","Pints(UK)","Quarts(UK)","Gallons(UK)"};
                        ArrayAdapter<String> adapter22 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array22);
                        spinner2.setAdapter(adapter22);

                        String[] array23 = {"Select","Milliliters","Cubic centimeters","Liters","Cubic meters","Teaspoons(US)","Tablespoons(US)","Fluid ouncess(US)","Cups(US)","Pints(US)","Quarts(US)","Gallons(US)","Cubic inches","Cubic feet","Cubic yards","Teaspoons(UK)","Tablespoons(UK)","Fluid ounces(UK)","Pints(UK)","Quarts(UK)","Gallons(UK)"};
                        ArrayAdapter<String> adapter23 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array23);
                        spinner3.setAdapter(adapter23);
                        //make textview scrollable
                        to.setMovementMethod(new ScrollingMovementMethod());
                        break;
                    case 11:tv2.setText("Weight & Mass Converter");
                        String[] array24 = {"Select","Carats","Milligrams","Centigrams","Decigrams","Grams","Dekagrams","Hectograms","Kilograms","Metric tonnes","Ounces","Stone","Short tons(US)","Long tons(UK)"};
                        ArrayAdapter<String> adapter24 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array24);
                        spinner2.setAdapter(adapter24);

                        String[] array25 = {"Select","Carats","Milligrams","Centigrams","Decigrams","Grams","Dekagrams","Hectograms","Kilograms","Metric tonnes","Ounces","Stone","Short tons(US)","Long tons(UK)"};
                        ArrayAdapter<String> adapter25 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, array25);
                        spinner3.setAdapter(adapter25);
                        //make textview scrollable
                        to.setMovementMethod(new ScrollingMovementMethod());
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final TextView formula=(TextView)findViewById(R.id.formula);

        //Long click to copy the text to clipboard
        to.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupMenu popup=new PopupMenu(MainActivity.this,to);
                popup.getMenuInflater().inflate(R.menu.pop_up,popup.getMenu());
                //on popup item click activity
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        //place textview text to clipboard
                        android.content.ClipboardManager c=(android.content.ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
                        c.setText(to.getText());
                        //show simple toast
                        Toast.makeText(getApplicationContext(),"Text copied",Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popup.show();

                return true;
            }
        });



        //EditText text change activity
        from.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (from.length() == 0)
                {
                    to.setText("");
                    formula.setText("");
                    clr.setEnabled(false);
                }
                else {

                    //make clear button enable
                    clr.setEnabled(true);
                    if(spinner2.getSelectedItem().toString()==spinner3.getSelectedItem().toString())
                    {
                        to.setText(from.getText().toString());
                        formula.setText("");
                    }

                    //logic start
                    //for Angle
                    else if(spinner2.getSelectedItem().toString()=="Degrees" && spinner3.getSelectedItem().toString()=="Radians")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*(3.141592654/180);
                        //convert the value of b from double to decimal and print it textview
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText(String.format("Formula: %sDeg*(π/180)= %sRad", from.getText().toString(), to.getText().toString()));
                    }
                    else if(spinner2.getSelectedItem().toString()=="Degrees" && spinner3.getSelectedItem().toString()=="Gradians")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1.111;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText(String.format("Formula: %sDeg*(200/180)= %sGrad", from.getText().toString(), to.getText().toString()));
                    }
                    else if(spinner2.getSelectedItem().toString()=="Radians" && spinner3.getSelectedItem().toString()=="Degrees")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*57.2958;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText(getString(R.string.formula18)+from.getText().toString()+getString(R.string.formula17)+to.getText().toString()+getString(R.string.formula19));
                    }
                    else if(spinner2.getSelectedItem().toString()=="Radians" && spinner3.getSelectedItem().toString()=="Gradians")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*63.662;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: "+from.getText().toString()+"Rad*(200/π)= "+to.getText().toString()+"Grad");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Gradians" && spinner3.getSelectedItem().toString()=="Degrees")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.09;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: "+from.getText().toString()+"Grad*(180/200)= "+to.getText().toString()+"Deg");
                    }
                    else if(spinner2.getSelectedItem().toString().equals("Gradians") && spinner3.getSelectedItem().toString().equals("Radians"))
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.015708;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText(String.format("Formula: %sGrad*(π/200)= %sRad", from.getText().toString(), to.getText().toString()));
                    }
                    //for Area
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1e+10;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText(R.string.formula2);
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1000000;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText(R.string.formula_area2);
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*100;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText(R.string.formula3);
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1e+12;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText(R.string.formula4);
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1550000000;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText(R.string.formula5);
                    }
                    else if(spinner2.getSelectedItem().toString().equals("Square kilometers") && spinner3.getSelectedItem().toString().equals("Square feet"))
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*10760000;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText(R.string.formula7);
                    }
                    else if(spinner2.getSelectedItem().toString().equals("Square kilometers") && spinner3.getSelectedItem().toString().equals("Square yards"))
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1195990;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText(R.string.formula9);
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*247.1054;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText(R.string.formula11);
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.386102;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText(R.string.formula13);
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.1;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText(R.string.formula14);
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText(R.string.formula16);
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.0000000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText(R.string.formula20);
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000000000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText(R.string.formula21);
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00155;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.00155 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square feet")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000011;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000011 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square yards")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e-6 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0000000002471;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by2471e-13 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000000000039;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: divide the area value by 39e-14");
                    }

                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*100;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 100");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.0001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.0001");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e-8");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.0000000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e-10");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.155;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.155 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square feet")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.001076;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.001076 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square yards")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00012;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.00012 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000002471054;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by0.2471054e-7 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000000003861;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.3861e-10");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1000000;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1000000");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*10000;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 10000");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.0001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.0001");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e-6");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1550.003;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1550.003 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square feet")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*10.76391;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 10.76391 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square yards")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1.19599;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1.19599 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000247;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by0.000247 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000038610216;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.00000038610216");
                    }

                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1e+10;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e+10");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*100000000;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e+8");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*10000;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 10000");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.01;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.01");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*15500031;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 15500031 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square feet")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*107639.1;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 107639.1 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square yards")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*11959.9;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 11959.9 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*2.471054;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by2.471054 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.003861;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.003861 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*645.16;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 645.16 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*6.4516;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 6.4516 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000645;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000645 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000000064516;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000000064516 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000000064516;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 64516e-14 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square feet")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.06944;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.006944 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square yards")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000772;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000772 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000015942251;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by15942251e-14 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.0000000002491;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 2491e-13");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*92903.04;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 92903.04 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*929.0304;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 929.0304 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.092903;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.092903 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000009;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000009 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000009290304;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 9290304e-14 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*144;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 144");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square yards")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.111111;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.111111 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000023;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000023 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000003587006;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 3587006e-14");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*836127.4;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 836127.4 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*8361.274;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 8361.274 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.836127;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.836127 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000084;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000084 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000083612736;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 83612736e-6 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1296;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1296");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square feet")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*9;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 9");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000207;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000207 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000032283058;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 32283058e-14");
                    }


                    //logic end

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //spinner2 item select activity
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (from.length() == 0)
                {
                    to.setText("");
                    formula.setText("");
                    clr.setEnabled(false);
                }
                else {
                    //make clear button enable
                    clr.setEnabled(true);
                    if(spinner2.getSelectedItem().toString()==spinner3.getSelectedItem().toString())
                    {
                        to.setText(from.getText().toString());
                        formula.setText("");
                    }
                    //logic start
                    //for Angle
                    else if(spinner2.getSelectedItem().toString()=="Degrees" && spinner3.getSelectedItem().toString()=="Radians")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*(3.141592654/180);
                        //convert the value of b from double to decimal and print it textview
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: "+from.getText().toString()+"Deg*(π/180)= "+to.getText().toString()+"Rad");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Degrees" && spinner3.getSelectedItem().toString()=="Gradians")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1.111;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: "+from.getText().toString()+"Deg*(200/180)= "+to.getText().toString()+"Grad");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Radians" && spinner3.getSelectedItem().toString()=="Degrees")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*57.2958;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: "+from.getText().toString()+"Rad*(180/π)= "+to.getText().toString()+"Deg");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Radians" && spinner3.getSelectedItem().toString()=="Gradians")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*63.662;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: "+from.getText().toString()+"Rad*(200/π)= "+to.getText().toString()+"Grad");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Gradians" && spinner3.getSelectedItem().toString()=="Degrees")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.09;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: "+from.getText().toString()+"Grad*(180/200)= "+to.getText().toString()+"Deg");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Gradians" && spinner3.getSelectedItem().toString()=="Radians")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.015708;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: "+from.getText().toString()+"Grad*(π/200)= "+to.getText().toString()+"Rad");
                    }
                    //for area
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1e+10;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: multiply the area value by 1e+10");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1000000;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: multiply the area value by 1e+6");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*100;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: multiply the area value by 100");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1e+12;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: multiply the area value by 1e+12");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1550000000;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: multiply the area value by 1.55e+9 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Square feet")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*10760000;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: multiply the area value by 1.076e+7 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Square yards")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1195990;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: multiply the area value by 1.196e+6 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*247.1054;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: multiply the area value by 247.1054 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.386102;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: divide the area value by 2.59");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.1;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: multiply the area value by 0.01");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e-6");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.0000000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e-10");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000000000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e-12");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00155;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.00155 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square feet")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000011;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000011 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square yards")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e-6 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0000000002471;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by2471e-13 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000000000039;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: divide the area value by 39e-14");
                    }

                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*100;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 100");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.0001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.0001");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e-8");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.0000000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e-10");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.155;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.155 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square feet")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.001076;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.001076 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square yards")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00012;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.00012 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000002471054;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by0.2471054e-7 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000000003861;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.3861e-10");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1000000;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1000000");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*10000;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 10000");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.0001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.0001");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e-6");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1550.003;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1550.003 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square feet")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*10.76391;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 10.76391 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square yards")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1.19599;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1.19599 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000247;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by0.000247 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000038610216;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.00000038610216");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1e+10;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e+10");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*100000000;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e+8");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*10000;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 10000");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.01;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.01");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*15500031;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 15500031 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square feet")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*107639.1;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 107639.1 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square yards")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*11959.9;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 11959.9 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*2.471054;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by2.471054 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.003861;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.003861 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*645.16;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 645.16 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*6.4516;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 6.4516 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000645;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000645 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000000064516;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000000064516 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000000064516;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 64516e-14 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square feet")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.06944;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.006944 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square yards")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000772;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000772 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000015942251;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by15942251e-14 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.0000000002491;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 2491e-13");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*92903.04;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 92903.04 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*929.0304;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 929.0304 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.092903;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.092903 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000009;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000009 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000009290304;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 9290304e-14 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*144;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 144");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square yards")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.111111;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.111111 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000023;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000023 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000003587006;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 3587006e-14");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*836127.4;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 836127.4 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*8361.274;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 8361.274 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.836127;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.836127 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000084;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000084 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000083612736;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 83612736e-6 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1296;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1296");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square feet")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*9;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 9");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000207;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000207 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000032283058;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 32283058e-14");
                    }




                    //logic end
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //spinner3 item select activity
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (from.length() == 0)
                {
                    to.setText("");
                    formula.setText("");
                    clr.setEnabled(false);
                }
                else {
                    //make clear button enable
                    clr.setEnabled(true);
                    if(spinner2.getSelectedItem().toString()==spinner3.getSelectedItem().toString())
                    {
                        to.setText(from.getText().toString());
                        formula.setText("");
                    }
                    //logic start
                    //for Angle
                    else if(spinner2.getSelectedItem().toString()=="Degrees" && spinner3.getSelectedItem().toString()=="Radians")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*(3.141592654/180);
                        //convert the value of b from double to decimal and print it textview
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: "+from.getText().toString()+"Deg*(π/180)= "+to.getText().toString()+"Rad");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Degrees" && spinner3.getSelectedItem().toString()=="Gradians")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1.111;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: "+from.getText().toString()+"Deg*(200/180)= "+to.getText().toString()+"Grad");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Radians" && spinner3.getSelectedItem().toString()=="Degrees")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*57.2958;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: "+from.getText().toString()+"Rad*(180/π)= "+to.getText().toString()+"Deg");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Radians" && spinner3.getSelectedItem().toString()=="Gradians")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*63.662;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: "+from.getText().toString()+"Rad*(200/π)= "+to.getText().toString()+"Grad");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Gradians" && spinner3.getSelectedItem().toString()=="Degrees")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.09;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: "+from.getText().toString()+"Grad*(180/200)= "+to.getText().toString()+"Deg");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Gradians" && spinner3.getSelectedItem().toString()=="Radians")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.015708;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: "+from.getText().toString()+"Grad*(π/200)= "+to.getText().toString()+"Rad");
                    }
                    //for area
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1e+10;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: multiply the area value by 1e+10");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1000000;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: multiply the area value by 1e+6");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*100;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: multiply the area value by 100");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1e+12;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: multiply the area value by 1e+12");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1550000000;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: multiply the area value by 1.55e+9 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Square feet")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*10760000;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: multiply the area value by 1.076e+7 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Square yards")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1195990;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: multiply the area value by 1.196e+6 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*247.1054;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: multiply the area value by 247.1054 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square kilometers" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.386102;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: divide the area value by 2.59");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.1;
                        to.setText(String.format("%.2f",b));
                        formula.setText("Formula: multiply the area value by 0.01");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e-6");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.0000000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e-10");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000000000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e-12");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00155;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.00155 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square feet")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000011;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000011 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square yards")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e-6 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0000000002471;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by2471e-13 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square millimeters" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000000000039;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: divide the area value by 39e-14");
                    }

                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*100;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 100");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.0001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.0001");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e-8");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.0000000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e-10");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.155;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.155 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square feet")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.001076;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.001076 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square yards")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00012;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.00012 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000002471054;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by0.2471054e-7 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square centimeters" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000000003861;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.3861e-10");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1000000;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1000000");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*10000;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 10000");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.0001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.0001");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000001;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e-6");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1550.003;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1550.003 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square feet")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*10.76391;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 10.76391 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square yards")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1.19599;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1.19599 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000247;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by0.000247 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square meters" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000038610216;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.00000038610216");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1e+10;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e+10");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*100000000;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1e+8");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*10000;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 10000");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.01;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.01");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*15500031;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 15500031 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square feet")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*107639.1;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 107639.1 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square yards")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*11959.9;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 11959.9 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*2.471054;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by2.471054 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Hectares" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.003861;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.003861 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*645.16;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 645.16 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*6.4516;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 6.4516 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000645;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000645 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000000064516;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000000064516 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000000064516;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 64516e-14 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square feet")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.06944;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.006944 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square yards")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000772;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000772 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000015942251;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by15942251e-14 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square inches" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.0000000002491;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 2491e-13");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*92903.04;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 92903.04 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*929.0304;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 929.0304 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.092903;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.092903 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000009;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000009 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000009290304;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 9290304e-14 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*144;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 144");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square yards")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.111111;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.111111 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000023;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000023 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square feet" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000003587006;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 3587006e-14");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square millimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*836127.4;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 836127.4 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square centimeters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*8361.274;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 8361.274 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square meters")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.836127;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.836127 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Hectares")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000084;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000084 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square kilometers")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000083612736;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 83612736e-6 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square inches")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*1296;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 1296");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square feet")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*9;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 9");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Acres")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.000207;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 0.000207 (approximate)");
                    }
                    else if(spinner2.getSelectedItem().toString()=="Square yards" && spinner3.getSelectedItem().toString()=="Square miles")
                    {
                        double a=Double.parseDouble(from.getText().toString());
                        double b=a*0.00000032283058;
                        String c=Double.toString(b);
                        to.setText(c);
                        formula.setText("Formula: multiply the area value by 32283058e-14");
                    }



                    //logic end
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


}
