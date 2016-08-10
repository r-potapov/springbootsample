package com.example.dto;

import com.example.domain.Teammate;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

public class TeammateDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String position;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private TeamDTO team;

    public TeammateDTO() {
    }

    public TeammateDTO(String firstName, String lastName) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public TeammateDTO(Teammate teammate) {
        this();
        if (teammate!=null) {
            this.id = teammate.getId();
            this.firstName = teammate.getFirstName();
            this.lastName = teammate.getLastName();
            this.position = teammate.getPosition();
            if(teammate.getTeam()!=null){
                this.team = new TeamDTO(teammate.getTeam());
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public TeamDTO getTeam() {
        return team;
    }

    public void setTeam(TeamDTO team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return id + ": " + firstName + " " + lastName + " is playing " + position + " for the " + team.getName();
    }
}
