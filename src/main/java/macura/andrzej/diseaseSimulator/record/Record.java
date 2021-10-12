package macura.andrzej.diseaseSimulator.record;

import com.fasterxml.jackson.annotation.JsonIgnore;
import macura.andrzej.diseaseSimulator.simulation.Simulation;

import javax.persistence.*;

@Entity
public class Record {
    private Integer infectedCount;          //Pi
    private Integer remaining;              //Pv
    private Integer killed;                 //Pm
    private Integer healed;                 //Pr
    private Integer day;
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne()
    @JsonIgnore
    private Simulation model;

    public Record(Integer infectedCount, Integer remaining, Integer killed, Integer healed, Simulation model,Integer day) {
        this.infectedCount = infectedCount;
        this.remaining = remaining;
        this.killed = killed;
        this.healed = healed;
        this.model = model;
        this.day = day;
    }

    public Record() {
    }

    @Override
    public String toString() {
        return "Record{" +
                "infectedCount=" + infectedCount +
                ", remaining=" + remaining +
                ", killed=" + killed +
                ", healed=" + healed +
                ", day=" + day +
                ", id=" + id +
                ", modelId=" + model.getId() +
                '}';
    }

    public Integer getInfectedCount() {
        return infectedCount;
    }

    public void setInfectedCount(Integer infectedCount) {
        this.infectedCount = infectedCount;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public Integer getKilled() {
        return killed;
    }

    public void setKilled(Integer killed) {
        this.killed = killed;
    }

    public Integer getHealed() {
        return healed;
    }

    public void setHealed(Integer healed) {
        this.healed = healed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Simulation getModel() {
        return model;
    }

    public void setModel(Simulation model) {
        this.model = model;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
