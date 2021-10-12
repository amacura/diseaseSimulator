package macura.andrzej.diseaseSimulator;

import macura.andrzej.diseaseSimulator.record.Record;
import macura.andrzej.diseaseSimulator.record.RecordService;
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
	@Autowired
	RecordService recordService;

	@Test
	void contextLoads() {



	}

}
