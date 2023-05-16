package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class Pokemon {

    int id;
    String name;

    //private EggGroup[] eggGroups;
    private List<EggGroup> eggGroups;

    public Pokemon(){}


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonProperty("egg_groups")
    public List<EggGroup> getEggGroups() {return eggGroups;}
 //  public EggGroup[] getEggGroups() {return eggGroups;}


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEggGroups(List<EggGroup> eggGroups) {this.eggGroups = eggGroups;}
   //public void setEggGroups(EggGroup[] eggGroups) {this.eggGroups = eggGroups;}




    public void printEggGroups() {
        System.out.println("Egg Groups:");
        for(EggGroup e : eggGroups){
            System.out.println(e.getName());
        }
    }
}
