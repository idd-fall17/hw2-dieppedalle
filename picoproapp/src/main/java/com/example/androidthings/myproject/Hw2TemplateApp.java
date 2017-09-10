package com.example.androidthings.myproject;

import com.google.android.things.pio.Gpio;

/**
 * Template for IDD Fall 2017 HW2 (text entry device)
 * Created by bjoern on 9/5/17.
 */

public class Hw2TemplateApp extends SimplePicoPro {
    @Override
    public void setup() {
        printKeyLayout();
        //changeFontScreen();
        //test();
        //set two GPIOs to input
        pinMode(GPIO_175,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_175,Gpio.EDGE_BOTH);

        pinMode(GPIO_174,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_174,Gpio.EDGE_BOTH);

        pinMode(GPIO_173,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_173,Gpio.EDGE_BOTH);

        pinMode(GPIO_172,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_172,Gpio.EDGE_BOTH);

        pinMode(GPIO_10,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_10,Gpio.EDGE_BOTH);

        pinMode(GPIO_32,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_32,Gpio.EDGE_BOTH);

        pinMode(GPIO_33,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_33,Gpio.EDGE_BOTH);

        pinMode(GPIO_34,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_34,Gpio.EDGE_BOTH);
    }

    @Override
    public void loop() {

    }

    @Override
    void digitalEdgeEvent(Gpio pin, boolean value) {
        println("digitalEdgeEvent"+pin+", "+value);
        if(pin==GPIO_175 && value==HIGH) {
            downPressed();
            printKeyLayout();
        }
        else if(pin==GPIO_174 && value==HIGH) {
            switchSymbol();
        }
        else if(pin==GPIO_173 && value==HIGH) {
            setCaps();
        }
        else if(pin==GPIO_172 && value==HIGH) {
            printCurentCharacter();
        }
        else if(pin==GPIO_10 && value==HIGH) {
            leftPressed();
            printKeyLayout();
        }
        else if(pin==GPIO_32 && value==HIGH) {
            rightPressed();
            printKeyLayout(); 
        }
        else if(pin==GPIO_33 && value==HIGH) {
            upPressed();
            printKeyLayout();
        }
        else if(pin==GPIO_34 && value==HIGH) {
            printCharacterToScreen(' ');
        }
    }
}
