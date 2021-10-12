package macura.andrzej.diseaseSimulator.simulation;


import macura.andrzej.diseaseSimulator.record.RecordModel;

import javax.persistence.*;
import java.util.List;


@Entity
public class SimulationModel {
    private String name;                // N
    Integer population;         // P
    Integer startedInfected;    // I
    Integer contagiousness;     // R
    Integer mortality;          // M
    Integer healingTime;        // Ti
    Integer deathTime;          // Tm
    Integer simulationTime;     // Ts
    @Id
    @GeneratedValue
    Integer id;
    @OneToMany
    @JoinColumn(name = "simulation_id")
    private List<RecordModel> records;

}
