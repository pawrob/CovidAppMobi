package com.example.covidbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.widget.Toast;

import com.example.covidbook.info.PersonInfoList;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {

    public PersonInfoList personList = new PersonInfoList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grpah);

        personList.setPersonInfoList(PersonInfoList.loadData(App.context,personList.getPersonInfoList()));
        if(personList.getPersonInfoList().size()<7){
            Toast.makeText(App.context,"You need to have at least 7 notes to display graphs!",Toast.LENGTH_SHORT).show();
        }
        else{
            GraphView graph = (GraphView) findViewById(R.id.graph);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(1,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-1).getTemperature()),
                new DataPoint(2,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-2).getTemperature()),
                new DataPoint(3,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-3).getTemperature()),
                new DataPoint(4,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-4).getTemperature()),
                new DataPoint(5,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-5).getTemperature()),
                new DataPoint(6,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-6).getTemperature()),
                new DataPoint(7,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-7).getTemperature())
        });

        GraphView graph2 = (GraphView) findViewById(R.id.graph2);
        BarGraphSeries<DataPoint> series2 = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(1,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-1).getRating()),
                new DataPoint(2,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-2).getRating()),
                new DataPoint(3,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-3).getRating()),
                new DataPoint(4,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-4).getRating()),
                new DataPoint(5,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-5).getRating()),
                new DataPoint(6,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-6).getRating()),
                new DataPoint(7,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-7).getRating())
        });
        GraphView graph3 = (GraphView) findViewById(R.id.graph3);
        BarGraphSeries<DataPoint> series3 = new BarGraphSeries<>(new DataPoint[] {

                new DataPoint(1,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-1).getPeoplePassed()),
                new DataPoint(2,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-2).getPeoplePassed()),
                new DataPoint(3,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-3).getPeoplePassed()),
                new DataPoint(4,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-4).getPeoplePassed()),
                new DataPoint(5,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-5).getPeoplePassed()),
                new DataPoint(6,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-6).getPeoplePassed()),
                new DataPoint(7,personList.getPersonInfoList().get(personList.getPersonInfoList().size()-7).getPeoplePassed())
        });

        plot(graph,series,"Temperature over last week");
        plot(graph2,series2,"Rating over last week");
        plot(graph3,series3,"People passed last week");
        }

    }


    @SuppressLint("ResourceType")
    public void plot(GraphView graphView, BarGraphSeries<DataPoint> series, String title){

        graphView.addSeries(series);
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb(204,155,255);

            }
        });
        graphView.setTitle(title);
        series.setSpacing(50);
        series.setDrawValuesOnTop(true);
        series.setColor(R.color.white);
        series.setValuesOnTopSize(40);
    }

}