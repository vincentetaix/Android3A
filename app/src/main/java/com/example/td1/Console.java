package com.example.td1;

import java.util.List;

public class Console {
    private String Name;
    private int Year;
    private String Designer;
    private String CPU;
    private String ROM;
    private String RAM;
    private String Games_support;
    private int Players;
    private String pics_url;

    private List<Console> listConsole;

    public List<Console> getListConsole() {
        return listConsole;
    }

    public void setListConsole(List<Console> listConsole) {
        this.listConsole = listConsole;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        this.Year = year;
    }

    public String getDesigner() {
        return Designer;
    }

    public void setDesigner(String designer) {
        this.Designer = designer;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getROM() {
        return ROM;
    }

    public void setROM(String ROM) {
        this.ROM = ROM;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getSupport() {
        return Games_support;
    }

    public void setSupport(String Games_support) {
        this.Games_support = Games_support;
    }

    public int getPlayers() {
        return Players;
    }

    public void setPlayers(int players) {
        this.Players = players;
    }

    public String getPics_url() {
        return pics_url;
    }

    public void setPics_url(String pics_url) {
        this.pics_url = pics_url;
    }

    public Console(String Name, int Year, String Designer, String CPU, String ROM, String RAM, String Games_support, int Players, String pics_url){
        this.Name = Name;
        this.Year = Year;
        this.Designer = Designer;
        this.CPU = CPU;
        this.ROM = ROM;
        this.RAM = RAM;
        this.Games_support = Games_support;
        this.pics_url = pics_url;
    }
}


