package com.example.Infrastructure;

import javax.annotation.PostConstruct;

import com.example.domain.Team;
import com.example.domain.Teammate;
import com.example.repository.TeamRepository;
import com.example.repository.TeammateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DatabaseLoader {
    private final TeammateRepository teammateRepository;

    private final TeamRepository teamRepository;

    @Autowired
    public DatabaseLoader(TeammateRepository teammateRepository,
                          TeamRepository teamRepository) {
        this.teammateRepository = teammateRepository;
        this.teamRepository = teamRepository;
    }

    @PostConstruct
    private void initDatabase() {
        Team myTeam = new Team("my team");
        teamRepository.save(myTeam);

        Teammate greg = new Teammate("Greg", "Turnquist");
        greg.setPosition("2nd base");
        greg.setTeam(myTeam);
        teammateRepository.save(greg);

        Teammate roy = new Teammate("Roy", "Clarkson");
        roy.setPosition("1st base");
        roy.setTeam(myTeam);
        teammateRepository.save(roy);

        Teammate phil = new Teammate("Phil", "Webb");
        phil.setPosition("pitcher");
        phil.setTeam(myTeam);
        teammateRepository.save(phil);
    }
}
