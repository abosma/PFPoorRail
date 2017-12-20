package Factories;

import Model.Component;
import Model.IItem;
import Core.RichRail;
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
    public Component createWagon(String name, int seats)
    {
        return new Wagon(name, seats);
    }
}
