package Factories;

import Model.IItem;
import Model.RichRail;
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
    public IItem createWagon(int id, int seats)
    {
        return new Wagon(seats,id);
    }
}
