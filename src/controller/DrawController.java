package controller;

import Model.IItem;
import Model.RichRail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.*;
import java.util.ArrayList;

public class DrawController
{
    //The panel to draw the graphics to
    private Graphics _graphics;

    public DrawController(Graphics graphics)
    {
        _graphics = graphics;
    }

    public void draw()
    {
    	RichRail instance = RichRail.getInstance();
        ArrayList<IItem> items = instance.getAllItems();

        for(IItem item : items)
        {
            item.draw(_graphics);
        }
    }
}
