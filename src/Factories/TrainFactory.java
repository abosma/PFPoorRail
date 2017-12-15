package Factories;

import Model.IItem;
import Core.RichRail;
import Model.Train;
import Model.Wagon;

public class TrainFactory extends RailwayFactory
{
    @Override
    public IItem createTrain(String name)
    {
        int id = RichRail.getInstance().getLastId();
        return new Train(name,id);
    }

    @Override
    public IItem createWagon(String name, int seats)
    {
    	int id = RichRail.getInstance().getLastId();
        return new Wagon(name, seats, id);
    }
}
