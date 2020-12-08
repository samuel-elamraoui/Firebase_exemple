package com.example.myapplicationfirebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
class Personne {
    public String identifier;
    public String name;

    public Personne(String indentifier, String name){
        this.identifier= indentifier;
        this.name=name;
    }
    public Personne(){

    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "identifier='" + identifier + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
