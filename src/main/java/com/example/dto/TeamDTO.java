package com.example.dto;

import com.example.domain.Team;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.ArrayList;
import java.util.List;

public class TeamDTO {
    private Long id;

    private String name;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private List<TeammateDTO> members;

    public TeamDTO() {
        members = new ArrayList<>();
    }

    public TeamDTO(String name) {
        this();
        this.name = name;
    }

    public TeamDTO(Team team) {
        this();
        if(team!=null) {
            this.id = team.getId();
            this.name = team.getName();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TeammateDTO> getMembers() {
        return members;
    }

    public void setMembers(List<TeammateDTO> members) {
        this.members = members;
    }
}
