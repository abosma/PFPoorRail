package Factories;

import Model.IItem;
import Model.Train;
import Model.Wagon;

public class TrainFactory extends RailwayFactory
{
    @Override
    public IItem createTrain(String name)
    {
        return new Train(name);
    }

    @Override
    public IItem createWagon(String name, int seats)
    {
        return new Wagon(name, seats);
    }
}
