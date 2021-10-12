package macura.andrzej.diseaseSimulator;

import macura.andrzej.diseaseSimulator.record.Record;
import macura.andrzej.diseaseSimulator.simulation.Simulation;
import macura.andrzej.diseaseSimulator.simulation.SimulationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class DiseaseSimulatorApplicationTests {
	@Autowired
	SimulationService service;

	@Test
	@Transactional
	void contextLoads() {
		service.createSimulation("first",100,1,2,1,5,6,20);
		Simulation sim = service.getSimulation(1);
		for(Record rec: sim.getRecords()) System.out.println(rec);


	}

}
