package com.example.arcore;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import  android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    ArFragment arFragment;
    private ModelRenderable bearRenderable,
                            catRenderable,
                            cowRenderable,
                            dogRenderable,
                            elephantRenderable,
                            ferretRenderable,
                            hippoRenderable,
                            hourseRenderable,
                            koaloaRenderable,
                            lionRenderable,
                            reindeerRenderable,
                            wolverineRenderable,
                            kotlaRenderable,
                            tableRenderable;

    ImageView bear,cat,cow,dog,elephant,ferret,hippo,horse,koala,lion,reindeer,wolverine,kotla,table;

    View arrayView[];

    int selected =1;

    ViewRenderable animal_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arFragment = (ArFragment)getSupportFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);

        bear = (ImageView)findViewById(R.id.bear);
        cat = (ImageView)findViewById(R.id.cat);
        cow = (ImageView)findViewById(R.id.cow);
        dog = (ImageView)findViewById(R.id.dog);
        elephant = (ImageView)findViewById(R.id.elephant);
        ferret = (ImageView)findViewById(R.id.ferret);
        hippo = (ImageView)findViewById(R.id.hippopotamus);
        horse = (ImageView)findViewById(R.id.horse);
        koala= (ImageView)findViewById(R.id.koala_bear);
        lion = (ImageView)findViewById(R.id.lion);
        reindeer = (ImageView)findViewById(R.id.reindeer);
        wolverine= (ImageView)findViewById(R.id.wolverine);
        kotla= (ImageView)findViewById(R.id.kotla);
        table= (ImageView)findViewById(R.id.table);

        setArrayView();
        setClickListner();

        setupModel();
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {


            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {


//                if (selected == 1){
                    Anchor anchor = hitResult.createAnchor();
                    AnchorNode anchorNode = new AnchorNode(anchor);
                    anchorNode.setParent(arFragment.getArSceneView().getScene());
                    createModel(anchorNode,selected);
//                }
            }
        });

    }

    private  void setupModel(){


        ModelRenderable.builder()
                .setSource(this,R.raw.bear)
                .build().thenAccept(renderable -> bearRenderable = renderable)
                .exceptionally(
                        throwable ->{
                            Toast.makeText(this,"unnable to load bear model",Toast.LENGTH_SHORT).show();
                            return null;
                        }

                );

        ModelRenderable.builder()
                .setSource(this,R.raw.bear)
                .build().thenAccept(renderable -> bearRenderable = renderable)
                .exceptionally(
                        throwable ->{
                            Toast.makeText(this,"unnable to load bear model",Toast.LENGTH_SHORT).show();
                            return null;
                        }

                );

        ModelRenderable.builder()
                .setSource(this,R.raw.cat)
                .build().thenAccept(renderable -> catRenderable = renderable)
                .exceptionally(
                        throwable ->{
                            Toast.makeText(this,"unnable to load cat model",Toast.LENGTH_SHORT).show();
                            return null;
                        }

                );

        ModelRenderable.builder()
                .setSource(this,R.raw.cow)
                .build().thenAccept(renderable -> cowRenderable= renderable)
                .exceptionally(
                        throwable ->{
                            Toast.makeText(this,"unnable to load cow model",Toast.LENGTH_SHORT).show();
                            return null;
                        }

                );

        ModelRenderable.builder()
                .setSource(this,R.raw.dog)
                .build().thenAccept(renderable -> dogRenderable= renderable)
                .exceptionally(
                        throwable ->{
                            Toast.makeText(this,"unnable to load dog model",Toast.LENGTH_SHORT).show();
                            return null;
                        }

                );


        ModelRenderable.builder()
                .setSource(this,R.raw.elephant)
                .build().thenAccept(renderable -> elephantRenderable= renderable)
                .exceptionally(
                        throwable ->{
                            Toast.makeText(this,"unnable to load elephant model",Toast.LENGTH_SHORT).show();
                            return null;
                        }

                );

        ModelRenderable.builder()
                .setSource(this,R.raw.ferret)
                .build().thenAccept(renderable -> ferretRenderable= renderable)
                .exceptionally(
                        throwable ->{
                            Toast.makeText(this,"unnable to load ferret model",Toast.LENGTH_SHORT).show();
                            return null;
                        }

                );

        ModelRenderable.builder()
                .setSource(this,R.raw.hippopotamus)
                .build().thenAccept(renderable -> hippoRenderable= renderable)
                .exceptionally(
                        throwable ->{
                            Toast.makeText(this,"unnable to load hippo model",Toast.LENGTH_SHORT).show();
                            return null;
                        }

                );

        ModelRenderable.builder()
                .setSource(this,R.raw.horse)
                .build().thenAccept(renderable -> hourseRenderable= renderable)
                .exceptionally(
                        throwable ->{
                            Toast.makeText(this,"unnable to load horse model",Toast.LENGTH_SHORT).show();
                            return null;
                        }

                );

        ModelRenderable.builder()
                .setSource(this,R.raw.koala_bear)
                .build().thenAccept(renderable -> koaloaRenderable= renderable)
                .exceptionally(
                        throwable ->{
                            Toast.makeText(this,"unnable to load koala model",Toast.LENGTH_SHORT).show();
                            return null;
                        }

                );

        ModelRenderable.builder()
                .setSource(this,R.raw.lion)
                .build().thenAccept(renderable -> lionRenderable= renderable)
                .exceptionally(
                        throwable ->{
                            Toast.makeText(this,"unnable to load lion model",Toast.LENGTH_SHORT).show();
                            return null;
                        }

                );

        ModelRenderable.builder()
                .setSource(this,R.raw.reindeer)
                .build().thenAccept(renderable -> reindeerRenderable= renderable)
                .exceptionally(
                        throwable ->{
                            Toast.makeText(this,"unnable to load reindeer model",Toast.LENGTH_SHORT).show();
                            return null;
                        }

                );


        ModelRenderable.builder()
                .setSource(this,R.raw.wolverine)
                .build().thenAccept(renderable -> wolverineRenderable= renderable)
                .exceptionally(
                        throwable ->{
                            Toast.makeText(this,"unnable to load wolverine model",Toast.LENGTH_SHORT).show();
                            return null;
                        }

                );
        ModelRenderable.builder()
                .setSource(this,R.raw.ben)
                .build().thenAccept(renderable -> kotlaRenderable= renderable)
                .exceptionally(
                        throwable ->{
                            Toast.makeText(this,"unnable to load kotla model",Toast.LENGTH_SHORT).show();
                            return null;
                        }

                );

        ModelRenderable.builder()
                .setSource(this,R.raw.table)
                .build().thenAccept(renderable -> tableRenderable= renderable)
                .exceptionally(
                        throwable ->{
                            Toast.makeText(this,"unnable to load c model",Toast.LENGTH_SHORT).show();
                            return null;
                        }

                );
    }

    private void createModel(AnchorNode anchorNode,int selected){
        if (selected == 1){
            TransformableNode bear=new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(bearRenderable);
            bear.select();

            addName(anchorNode,bear,"Bear");
        }
        if (selected == 2){
            TransformableNode bear=new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(catRenderable);
            bear.select();

            addName(anchorNode,bear,"Cat");
        }
        if (selected == 3){
            TransformableNode bear=new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(cowRenderable);
            bear.select();

            addName(anchorNode,bear,"Cow");
        }
        if (selected == 4){
            TransformableNode bear=new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(dogRenderable);
            bear.select();

            addName(anchorNode,bear,"Dog");
        }
        if (selected == 5){
            TransformableNode bear=new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(elephantRenderable);
            bear.select();

            addName(anchorNode,bear,"Elephant");
        }
        if (selected == 6){
            TransformableNode bear=new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(ferretRenderable);
            bear.select();

            addName(anchorNode,bear,"Ferret");
        }
        if (selected == 7){
            TransformableNode bear=new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(hippoRenderable);
            bear.select();

            addName(anchorNode,bear,"Hippopotamus");
        }
        if (selected == 8){
            TransformableNode bear=new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(hourseRenderable);
            bear.select();

            addName(anchorNode,bear,"Horse");
        }
        if (selected == 9){
            TransformableNode bear=new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(koaloaRenderable);
            bear.select();

            addName(anchorNode,bear,"Koaloa");
        }
        if (selected == 10){
            TransformableNode bear=new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(lionRenderable);
            bear.select();

            addName(anchorNode,bear,"Lion");
        }
        if (selected == 11){
            TransformableNode bear=new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(reindeerRenderable);
            bear.select();

            addName(anchorNode,bear,"Reindeer");
        }
        if (selected == 12){
            TransformableNode bear=new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(wolverineRenderable);
            bear.select();

            addName(anchorNode,bear,"Wolverine");
        }
        if (selected == 13){
            TransformableNode bear=new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(kotlaRenderable);
            bear.select();

            addName(anchorNode,bear,"kotla");
        }
        if (selected == 14){
            TransformableNode bear=new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(tableRenderable);
            bear.select();

            addName(anchorNode,bear,"table");
        }

    }

    private void addName(AnchorNode anchorNode,TransformableNode model,String name){

        ViewRenderable.builder().setView(this,R.layout.name_animal)
                .build()
                .thenAccept(viewRenderable -> {
                    TransformableNode nameView=new TransformableNode(arFragment.getTransformationSystem());
                    nameView.setLocalPosition(new Vector3(0f,model.getLocalPosition().y+0.5f,0));
                    nameView.setParent(anchorNode);
                    nameView.setRenderable(viewRenderable);
                    nameView.select();


                    TextView txt_name = (TextView)viewRenderable.getView();
                    txt_name.setText(name);
                    txt_name.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                            anchorNode.setParent(null);
                        }
                    });
                });


    }


    private  void setClickListner(){
        for (int i=0;i<arrayView.length;i++){
            arrayView[i].setOnClickListener(this);
        }
    }
    private  void  setArrayView(){
        arrayView = new  View[]{
                bear,cat,cow,dog,elephant,ferret,hippo,horse,koala,lion,reindeer,wolverine,kotla,table
        };
    }

    @Override
    public void onClick(View view){

        if (view.getId() == R.id.bear){
            selected =1;
            setBackground(view.getId());
        }

        else if (view.getId() == R.id.cat){
            selected=2;
            setBackground(view.getId());
        }
        else if (view.getId() == R.id.cow){
            selected=3;
            setBackground(view.getId());
        }else if (view.getId() == R.id.dog){
            selected=4;
            setBackground(view.getId());
        }else if (view.getId() == R.id.elephant){
            selected=5;
            setBackground(view.getId());
        }else if (view.getId() == R.id.ferret){
            selected=6;
            setBackground(view.getId());
        }else if (view.getId() == R.id.hippopotamus){
            selected=7;
            setBackground(view.getId());
        }else if (view.getId() == R.id.horse){
            selected=8;
            setBackground(view.getId());
        }else if (view.getId() == R.id.koala_bear){
            selected=9;
            setBackground(view.getId());
        }else if (view.getId() == R.id.lion){
            selected=10;
            setBackground(view.getId());
        }else if (view.getId() == R.id.reindeer){
            selected=11;
            setBackground(view.getId());
        }else if (view.getId() == R.id.wolverine){
            selected=12;
            setBackground(view.getId());
        }else if (view.getId() == R.id.kotla){
            selected=13;
            setBackground(view.getId());
        }else if (view.getId() == R.id.table){
            selected=14;
            setBackground(view.getId());
        }
    }

    private void setBackground(int id){
        for (int i=0;i<arrayView.length;i++){

            if(arrayView[i].getId() == id){
                arrayView[i].setBackgroundColor(Color.parseColor("#80333639"));
            }
            else {
                arrayView[i].setBackgroundColor(Color.TRANSPARENT);
            }
        }
    }

}
