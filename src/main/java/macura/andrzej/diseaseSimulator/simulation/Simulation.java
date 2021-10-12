package macura.andrzej.diseaseSimulator.simulation;


import macura.andrzej.diseaseSimulator.record.Record;

import javax.persistence.*;
import java.util.*;


@Entity
public class Simulation {
    private String name;                // N
    private Integer population;         // P
    private Integer startedInfected;    // I
    private Integer contagiousness;     // R
    private Integer mortality;          // M
    private Integer healingTime;        // Ti
    private Integer deathTime;          // Tm
    private Integer simulationTime;     // Ts
    @Id
    @GeneratedValue
    @Column(name = "SIMULATION_ID")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "SIMULATION_ID")
    private List<Record> records;

    public Simulation(String name, Integer population, Integer startedInfected, Integer contagiousness, Integer mortality, Integer healingTime, Integer deathTime, Integer simulationTime,List<Record> records) {
        this.name = name;
        this.population = population;
        this.startedInfected = startedInfected;
        this.contagiousness = contagiousness;
        this.mortality = mortality;
        this.healingTime = healingTime;
        this.deathTime = deathTime;
        this.simulationTime = simulationTime;
        this.records = records;
    }
    public Simulation()
    {

    }
    //TODO refractor it
    public List<Record> run()
    {
        List<Integer> aliveInfected = new ArrayList<Integer>(Collections.nCopies(healingTime, 0));
        aliveInfected.set(0,startedInfected);
        List<Integer> deathInfected = new ArrayList<Integer>(Collections.nCopies(deathTime, 0));
        int aliveListIndex = 0;
        int deathListIndex = 0;
        Integer healed = 0;
        Integer killed = 0;
        Integer infected = startedInfected ;
        Integer remaining = population-startedInfected;
        for(int i = 0; i < simulationTime; i++)
        {
            records.add(new Record(infected,remaining,killed,healed,this,i));
            int currentHealed,currentInfected,currentKilled;
            aliveListIndex++;
            deathListIndex++;
            if(deathListIndex > deathTime-1) deathListIndex = 0;
            if(aliveListIndex > healingTime-1) aliveListIndex = 0;
            currentHealed = aliveInfected.get(aliveListIndex);
            aliveInfected.set(aliveListIndex,0);
            healed += currentHealed;
            infected -= currentHealed;
            currentKilled = deathInfected.get(deathListIndex);
            deathInfected.set(deathListIndex,0);
            killed += currentKilled;
            infected -= currentKilled;
            currentInfected = contagiousness * infected;
            if(remaining>=currentInfected)
            {
                aliveInfected.set(aliveListIndex,infected*(contagiousness-mortality));
                deathInfected.set(deathListIndex,infected*mortality);
                infected+= currentInfected;
                remaining-=currentInfected;
            }
            else if (remaining>0)
            {
                int ratio = remaining/contagiousness;
                int temphealing,tempkilled;
                temphealing = ratio * (contagiousness-mortality);
                tempkilled = ratio * mortality;
                remaining -= contagiousness*ratio;
                if (remaining > contagiousness-mortality)
                {
                    temphealing += contagiousness-mortality;
                    tempkilled += remaining - (contagiousness-mortality);
                }
                else temphealing +=remaining;
                remaining = 0;
                infected += temphealing + tempkilled ;
                aliveInfected.set(aliveListIndex,temphealing);
                deathInfected.set(deathListIndex,tempkilled);

            }
            else if (remaining == 0)
            {

            }

        }
        return records;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getStartedInfected() {
        return startedInfected;
    }

    public void setStartedInfected(Integer startedInfected) {
        this.startedInfected = startedInfected;
    }

    public Integer getContagiousness() {
        return contagiousness;
    }

    public void setContagiousness(Integer contagiousness) {
        this.contagiousness = contagiousness;
    }

    public Integer getMortality() {
        return mortality;
    }

    public void setMortality(Integer mortality) {
        this.mortality = mortality;
    }

    public Integer getHealingTime() {
        return healingTime;
    }

    public void setHealingTime(Integer healingTime) {
        this.healingTime = healingTime;
    }

    public Integer getDeathTime() {
        return deathTime;
    }

    public void setDeathTime(Integer deathTime) {
        this.deathTime = deathTime;
    }

    public Integer getSimulationTime() {
        return simulationTime;
    }

    public void setSimulationTime(Integer simulationTime) {
        this.simulationTime = simulationTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }
}
