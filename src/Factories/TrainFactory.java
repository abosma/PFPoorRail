package Factories;

import Model.IRoll;
import Model.RichRail;
import Model.Train;
import Model.Wagon;

public class TrainFactory extends RailwayFactory
{
    @Override
    public IRoll createTrain(String name)
    {
        int id = RichRail.getInstance().getIDlastTrain();
        return new Train(name,id);
    }

    @Override
    public IRoll createWagon(int id, int seats)
    {
        return new Wagon(seats,id);
    }
}
