package com.java.controller;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;

import javafx.stage.Stage;
import javafx.scene.Scene;

@Component
public class StageReadyEvent extends ApplicationEvent {
	  
	public StageReadyEvent(Stage stage) {
		super(stage);
	}

	public Stage getStage() {
        return ((Stage) getSource());
    }
	  
	 
}
