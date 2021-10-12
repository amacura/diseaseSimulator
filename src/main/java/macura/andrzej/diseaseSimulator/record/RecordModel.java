package macura.andrzej.diseaseSimulator.record;

import macura.andrzej.diseaseSimulator.simulation.SimulationModel;

import javax.persistence.*;

@Entity
public class RecordModel {
    Integer infectedCount;          //Pi
    Integer remaining;              //Pv
    Integer killed;                 //Pm
    Integer healed;                 //Pr
    @Id
    @GeneratedValue
    Integer id;
    @ManyToOne
    @JoinColumn(name = "simulation_id", insertable = false, updatable = false)
    SimulationModel model;
}
