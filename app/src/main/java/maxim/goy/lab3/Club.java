package maxim.goy.lab3;

import java.util.ArrayList;
import java.util.Calendar;

public class Club {
    private String name;
    private String town;
    private Calendar date;
    private String nameCoach;
    private int capacityStadium;
    private String nameStadium;
    private int countPlayers;
    private ArrayList<String> tournament;

    public Club(String name, String town, Calendar date, String nameCoach, int capacityStadium, String nameStadium, int countPlayers, ArrayList<String> tournament) {
        this.name = name;
        this.town = town;
        this.date = date;
        this.nameCoach = nameCoach;
        this.capacityStadium = capacityStadium;
        this.nameStadium = nameStadium;
        this.countPlayers = countPlayers;
        this.tournament = tournament;
    }

    public void addTournament(String str) {
        tournament.add(str);
    }

    //region getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getNameCoach() {
        return nameCoach;
    }

    public void setNameCoach(String nameCoach) {
        this.nameCoach = nameCoach;
    }

    public int getCapacityStadium() {
        return capacityStadium;
    }

    public void setCapacityStadium(int capacityStadium) {
        this.capacityStadium = capacityStadium;
    }

    public String getNameStadium() {
        return nameStadium;
    }

    public void setNameStadium(String nameStadium) {
        this.nameStadium = nameStadium;
    }

    public int getCountPlayers() {
        return countPlayers;
    }

    public void setCountPlayers(int countPlayers) {
        this.countPlayers = countPlayers;
    }

    public ArrayList<String> getTournament() {
        return tournament;
    }

    public void setTournament(ArrayList<String> tournament) {
        this.tournament = tournament;
    }
    //endregion
}
