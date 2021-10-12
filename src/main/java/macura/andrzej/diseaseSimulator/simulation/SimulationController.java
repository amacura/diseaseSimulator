package macura.andrzej.diseaseSimulator.simulation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController()
@RequestMapping(path = "/simulation")
public class SimulationController {
    @Autowired
    SimulationService service;
    @GetMapping
    public Simulation getSimulation(@RequestParam @NonNull Integer simulationId)
    {
        return service.getSimulation(simulationId);

    }
    @PostMapping
    public ResponseEntity<Integer> createSimulation(
            @RequestParam @NonNull String n,
            @RequestParam @NonNull @Min(value = 1) Integer p,
            @RequestParam @NonNull @Min(value = 1) Integer i,
            @RequestParam @NonNull @Min(value = 1) Integer r,
            @RequestParam @NonNull @Min(value = 1) Integer m,
            @RequestParam @NonNull @Min(value = 1) Integer ti,
            @RequestParam @NonNull @Min(value = 1) Integer tm,
            @RequestParam @NonNull @Min(value = 1) Integer ts
    )
    {
        return service.createSimulation(n,p,i,r,m,ti,tm,ts);
    }
}
