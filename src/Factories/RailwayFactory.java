package Factories;

import Model.IRoll;

public abstract class RailwayFactory
{
    public abstract IRoll createTrain(String name);
    public abstract IRoll createWagon(int id, int seats);
}
