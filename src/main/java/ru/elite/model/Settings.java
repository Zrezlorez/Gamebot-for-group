package ru.elite.model;

public class Settings {
    private Types types;
    private long[] admins;

    public Types getTypes() { return types; }
    public void setTypes(Types value) { this.types = value; }

    public long[] getAdmins() { return admins; }
    public void setAdmins(long[] value) { this.admins = value; }
}
