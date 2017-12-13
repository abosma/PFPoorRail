package Factories;

import Model.IItem;

public abstract class RailwayFactory
{
    public abstract IItem createTrain(String name);
    public abstract IItem createWagon(int id, int seats);
}
