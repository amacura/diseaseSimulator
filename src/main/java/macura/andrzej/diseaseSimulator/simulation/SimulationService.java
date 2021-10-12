package macura.andrzej.diseaseSimulator.simulation;

import macura.andrzej.diseaseSimulator.record.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class SimulationService {
    @Autowired
    private SimulationRepository repository;
    @Autowired
    private RecordRepository recordRepository;
    public Simulation getSimulation(Integer simulationId) {
        return repository.findById(simulationId).get();
    }

    public ResponseEntity<Integer> createSimulation(String name,
                                           Integer population,
                                           Integer startedInfected,
                                           Integer contagiousness,
                                           Integer mortality,
                                           Integer healingTime,
                                           Integer deathTime,
                                           Integer simulationTime) {
        Simulation simulation = new Simulation(name,population,startedInfected,contagiousness,
                mortality,healingTime,deathTime,simulationTime,new ArrayList<>());
        simulation.run();
        repository.save(simulation);
        recordRepository.saveAll(simulation.getRecords());
        System.out.println(simulation.getId());
        return new ResponseEntity<>(simulation.getId(), HttpStatus.CREATED);

    }
}
