package macura.andrzej.diseaseSimulator.simulation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SimulationRepository extends JpaRepository<Simulation,Integer> {
}
